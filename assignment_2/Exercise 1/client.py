import socket
import struct
import Crypto.Cipher.AES as AES

# Calculate the checksum of the packet header.
def calculate_checksum(data):
    checksum = 0
    # Handle odd-length data
    if len(data) % 2 != 0:
        data += b"\x00"

    # Calculate checksum
    for i in range(0, len(data), 2):
        checksum += (data[i] << 8) + data[i+1]

    checksum = (checksum >> 16) + (checksum & 0xffff)
    checksum += checksum >> 16

    return (~checksum) & 0xffff

# Creates a ICMP-packet with the given message
def create_packet(enc_message): 
    # Construct the packet
    type = 47
    code = 0
    checksum = 0
    sequence = 1
    id = 12345
    header = struct.pack("!BBHHH", type, code, checksum, sequence, id)
    data = enc_message.encode('utf-8')
    new_checksum = calculate_checksum(header + data)
    new_header = struct.pack("!BBHHH", type, code, new_checksum, sequence, id)
    packet = new_header + data
    return packet

# Wraps the message inside the payload of a ICMP-packet and sends it to the server
def send_icmp(data):
    dest_ip = "127.0.0.1"
    print(f'"length of message: " {len(data)}')
    packet = create_packet(data)
    print(f'"length of packet: "{len(packet)}')
    sock = socket.socket(socket.AF_INET, socket.SOCK_RAW, socket.getprotobyname("icmp"))
    print(f"Packet created: {packet}")
    sent = sock.sendto(packet, (dest_ip, 1))
    print(f"Packet sent to {dest_ip}, bytes sent: {sent}")

def main():
    message = input("Enter your message: ")
    send_icmp(message)
    print("Message sent")

if __name__ == "__main__":
    main()