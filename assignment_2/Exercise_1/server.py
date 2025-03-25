import socket
from Crypto.Cipher import AES
import data

# Creation of socket and awaiting incoming ICMP packets from client.py
def receive_icmp():
    sock = socket.socket(socket.AF_INET, socket.SOCK_RAW, socket.getprotobyname("icmp"))
    packet, addr = sock.recvfrom(1024)
    # Strip the ip-header(20 bytes) and icmp-header(8 bytes) from the packet
    data = packet[28:]
    return data

# Decrypts the message using AES-GCM
def decrypt(encrypted_and_tag):
    tag = encrypted_and_tag[-16:]
    encrypted = encrypted_and_tag[:-16]
    aes = AES.new(data.key, AES.MODE_GCM, nonce=data.nonce)
    decrypted = aes.decrypt_and_verify(encrypted, tag)
    decrypted_utf = decrypted.decode('utf-8')
    return decrypted_utf

# Main function that receives the ICMP-packets and decrypts the message
def main():
    while True:
        icmp_packet = receive_icmp()
        decrypted_message = decrypt(icmp_packet)
        print(f"Message reveived through ICMP: {decrypted_message}")

if __name__ == "__main__":
    main()
