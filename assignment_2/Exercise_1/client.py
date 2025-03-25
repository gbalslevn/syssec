import socket
import struct
from Crypto.Cipher import AES
from Crypto.Random import get_random_bytes
import data


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
    type = 47
    code = 0
    checksum = 0
    sequence = 1
    id = 12345
    header = struct.pack("!BBHHH", type, code, checksum, sequence, id)
    data = enc_message
    new_checksum = calculate_checksum(header + data)
    new_header = struct.pack("!BBHHH", type, code, new_checksum, sequence, id)
    packet = new_header + data
    return packet

# Wraps the message inside the payload of a ICMP-packet and sends it to the server
def send_icmp(data):
    dest_ip = "127.0.0.1"
    packet = create_packet(data)
    sock = socket.socket(socket.AF_INET, socket.SOCK_RAW, socket.getprotobyname("icmp"))
    sent = sock.sendto(packet, (dest_ip, 1))

# Encrypts the message using AES-GCM and returns the encrypted message
def encrypt_message(message):
    message_as_bytes_object = message.encode('utf-8')
    aes = AES.new(data.key, AES.MODE_GCM, nonce=data.nonce)
    encrypted, tag = aes.encrypt_and_digest(message_as_bytes_object)
    return encrypted + tag

# Main function that takes a message from the user and sends it to the server
def main():
    while True:
        message = input("Enter the message: ")
        enc_message = encrypt_message(message)
        send_icmp(enc_message)

if __name__ == "__main__":
    main()