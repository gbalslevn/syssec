# 1. Sending 3 duplicate ACK packets to simulate packet loss and force retransmission
# 2. Sending a TCP reset packet to drop the connection altogether.

# This tool slows down TCP transmssions. 
# It does this either by sending 3 dublicate ACK packets, simulating packets loss and forcing retransmission. 
# or sending a TCP reset packet to drop the connection altogether.

# Takes as input a source and destination IP addresses for a TCP connection 
# and the approach for throttling which should be used.

import logging
import random
import time
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
sourceIp = "localhost"
destIp = "localhost"

# sport = random.randint(1024, 65535)
# SYN
# ip = IP(src="192.168.0.197", dst=destIp)
# SYN = TCP(sport=sport, dport=443, flags='S', seq=1000)
# SYNACK = sr1(ip/SYN)

# # SYN-ACK
# ACK = TCP(sport=sport, dport=443, flags='A', seq=SYNACK.ack + 1, ack=SYNACK.seq + 1)
# send(ip/ACK)


def retransmit_ack(packet):
    if packet.haslayer(TCP) and packet[TCP].flags == "A":  # Checking for ACK flag
        print(f"Captured ACK Packet: {packet.summary()}")

        # Modify if necessary (e.g., changing TTL, sequence number, etc.)
        new_packet = packet.copy()

        # Send the modified or original ACK packet
        sendp(new_packet, iface="en0", count=3, inter=0.5)  

        print("Retransmitted ACK Packet.")

# capture = sniff(count=1)
# print(capture.summary())
sniff(prn=retransmit_ack, iface="en0", count=1) 