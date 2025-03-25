import socket

def start_proxy_server():
    server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    server_socket.bind(('0.0.0.0', 8080))  # Listen on all interfaces, port 8080
    server_socket.listen(1)
    print("Proxy server listening on port 8080...")

    while True:
        client_socket, client_address = server_socket.accept()
        print(f"Connection from {client_address}")
        data = client_socket.recv(1024)
        print(f"Received: {data.decode()}")
        client_socket.send(b"ACK: " + data)
        client_socket.close()

if __name__ == "__main__":
    start_proxy_server()