import socket
import struct

def create_packet(enc_message):
    # Construct the packet
    type = 47
    # struct.pack(!"BBHH",)

def send_ping(dest_ip):
    sock = socket.socket()

def main():
    message = input("Enter the message")
    # Encrypt the message
    # -----
    # use create_packet to construct the header and data
    # -----
    # use send_ping to send the encrypted data to the ip of the server (just hardcode it)
    print(f"The ip: {message}")

if __name__ == "__main__":
    main()
