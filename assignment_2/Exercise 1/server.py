import socket

# Creation of socket and awaiting incoming ICMP packets from client.py
def receive_icmp():
    sock = socket.socket(socket.AF_INET, socket.SOCK_RAW, socket.getprotobyname("icmp"))
    while True:
        print("Server listening")
        packet, addr = sock.recvfrom(1024)
        # Strip the ip-header(20 bytes) and icmp-header(8 bytes) from the packet
        data = packet[28:]
        print(f"Received data from {addr}: {data.decode('utf-8')}")

if __name__ == "__main__":
    receive_icmp()
