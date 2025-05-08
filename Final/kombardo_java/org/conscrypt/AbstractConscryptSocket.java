package org.conscrypt;

import java.io.FileDescriptor;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.channels.SocketChannel;
import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.HandshakeCompletedEvent;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public abstract class AbstractConscryptSocket extends SSLSocket {
    private final boolean autoClose;
    private final List<HandshakeCompletedListener> listeners;
    private String peerHostname;
    private final PeerInfoProvider peerInfoProvider;
    private final int peerPort;
    private int readTimeoutMilliseconds;
    final Socket socket;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractConscryptSocket() {
        this.peerInfoProvider = new PeerInfoProvider() { // from class: org.conscrypt.AbstractConscryptSocket.1
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // org.conscrypt.PeerInfoProvider
            public String getHostname() {
                return AbstractConscryptSocket.this.getHostname();
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // org.conscrypt.PeerInfoProvider
            public String getHostnameOrIP() {
                return AbstractConscryptSocket.this.getHostnameOrIP();
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // org.conscrypt.PeerInfoProvider
            public int getPort() {
                return AbstractConscryptSocket.this.getPort();
            }
        };
        this.listeners = new ArrayList(2);
        this.socket = this;
        this.peerHostname = null;
        this.peerPort = -1;
        this.autoClose = false;
    }

    private boolean isDelegating() {
        Socket socket = this.socket;
        return (socket == null || socket == this) ? false : true;
    }

    @Override // javax.net.ssl.SSLSocket
    public void addHandshakeCompletedListener(HandshakeCompletedListener handshakeCompletedListener) {
        Preconditions.checkArgument(handshakeCompletedListener != null, "Provided listener is null");
        this.listeners.add(handshakeCompletedListener);
    }

    @Override // java.net.Socket
    public void bind(SocketAddress socketAddress) {
        if (isDelegating()) {
            this.socket.bind(socketAddress);
        } else {
            super.bind(socketAddress);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void checkOpen() {
        if (isClosed()) {
            throw new SocketException("Socket is closed");
        }
    }

    @Override // java.net.Socket, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (!isDelegating()) {
            if (super.isClosed()) {
                return;
            }
            super.close();
        } else {
            if (!this.autoClose || this.socket.isClosed()) {
                return;
            }
            this.socket.close();
        }
    }

    @Override // java.net.Socket
    public final void connect(SocketAddress socketAddress) {
        connect(socketAddress, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract byte[] exportKeyingMaterial(String str, byte[] bArr, int i5);

    abstract SSLSession getActiveSession();

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public abstract byte[] getAlpnSelectedProtocol();

    @Override // javax.net.ssl.SSLSocket
    public abstract String getApplicationProtocol();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract String[] getApplicationProtocols();

    @Override // java.net.Socket
    public SocketChannel getChannel() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract byte[] getChannelId();

    public FileDescriptor getFileDescriptor$() {
        return isDelegating() ? Platform.getFileDescriptor(this.socket) : Platform.getFileDescriptorFromSSLSocket(this);
    }

    @Override // javax.net.ssl.SSLSocket
    public abstract String getHandshakeApplicationProtocol();

    @Override // javax.net.ssl.SSLSocket
    public abstract SSLSession getHandshakeSession();

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getHostname() {
        return this.peerHostname;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getHostnameOrIP() {
        String str = this.peerHostname;
        if (str != null) {
            return str;
        }
        InetAddress inetAddress = getInetAddress();
        if (inetAddress != null) {
            return Platform.getOriginalHostNameFromInetAddress(inetAddress);
        }
        return null;
    }

    @Override // java.net.Socket
    public InetAddress getInetAddress() {
        return isDelegating() ? this.socket.getInetAddress() : super.getInetAddress();
    }

    @Override // java.net.Socket
    public InputStream getInputStream() {
        return isDelegating() ? this.socket.getInputStream() : super.getInputStream();
    }

    @Override // java.net.Socket
    public boolean getKeepAlive() {
        return isDelegating() ? this.socket.getKeepAlive() : super.getKeepAlive();
    }

    @Override // java.net.Socket
    public InetAddress getLocalAddress() {
        return isDelegating() ? this.socket.getLocalAddress() : super.getLocalAddress();
    }

    @Override // java.net.Socket
    public int getLocalPort() {
        return isDelegating() ? this.socket.getLocalPort() : super.getLocalPort();
    }

    @Override // java.net.Socket
    public SocketAddress getLocalSocketAddress() {
        return isDelegating() ? this.socket.getLocalSocketAddress() : super.getLocalSocketAddress();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public byte[] getNpnSelectedProtocol() {
        return null;
    }

    @Override // java.net.Socket
    public boolean getOOBInline() {
        return false;
    }

    @Override // java.net.Socket
    public OutputStream getOutputStream() {
        return isDelegating() ? this.socket.getOutputStream() : super.getOutputStream();
    }

    @Override // java.net.Socket
    public final int getPort() {
        if (isDelegating()) {
            return this.socket.getPort();
        }
        int i5 = this.peerPort;
        return i5 != -1 ? i5 : super.getPort();
    }

    @Override // java.net.Socket
    public int getReceiveBufferSize() {
        return isDelegating() ? this.socket.getReceiveBufferSize() : super.getReceiveBufferSize();
    }

    @Override // java.net.Socket
    public SocketAddress getRemoteSocketAddress() {
        return isDelegating() ? this.socket.getRemoteSocketAddress() : super.getRemoteSocketAddress();
    }

    @Override // java.net.Socket
    public boolean getReuseAddress() {
        return isDelegating() ? this.socket.getReuseAddress() : super.getReuseAddress();
    }

    @Override // java.net.Socket
    public int getSendBufferSize() {
        return isDelegating() ? this.socket.getSendBufferSize() : super.getSendBufferSize();
    }

    @Override // java.net.Socket
    public int getSoLinger() {
        return isDelegating() ? this.socket.getSoLinger() : super.getSoLinger();
    }

    @Override // java.net.Socket
    public final int getSoTimeout() {
        return isDelegating() ? this.socket.getSoTimeout() : this.readTimeoutMilliseconds;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSoWriteTimeout() {
        return 0;
    }

    @Override // java.net.Socket
    public boolean getTcpNoDelay() {
        return isDelegating() ? this.socket.getTcpNoDelay() : super.getTcpNoDelay();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract byte[] getTlsUnique();

    @Override // java.net.Socket
    public int getTrafficClass() {
        return isDelegating() ? this.socket.getTrafficClass() : super.getTrafficClass();
    }

    @Override // java.net.Socket
    public boolean isBound() {
        return isDelegating() ? this.socket.isBound() : super.isBound();
    }

    @Override // java.net.Socket
    public boolean isClosed() {
        return isDelegating() ? this.socket.isClosed() : super.isClosed();
    }

    @Override // java.net.Socket
    public boolean isConnected() {
        return isDelegating() ? this.socket.isConnected() : super.isConnected();
    }

    @Override // java.net.Socket
    public boolean isInputShutdown() {
        return isDelegating() ? this.socket.isInputShutdown() : super.isInputShutdown();
    }

    @Override // java.net.Socket
    public boolean isOutputShutdown() {
        return isDelegating() ? this.socket.isOutputShutdown() : super.isOutputShutdown();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void notifyHandshakeCompletedListeners() {
        ArrayList arrayList = new ArrayList(this.listeners);
        if (arrayList.isEmpty()) {
            return;
        }
        HandshakeCompletedEvent handshakeCompletedEvent = new HandshakeCompletedEvent(this, getActiveSession());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            try {
                ((HandshakeCompletedListener) it.next()).handshakeCompleted(handshakeCompletedEvent);
            } catch (RuntimeException e5) {
                Thread currentThread = Thread.currentThread();
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, e5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final PeerInfoProvider peerInfoProvider() {
        return this.peerInfoProvider;
    }

    @Override // javax.net.ssl.SSLSocket
    public void removeHandshakeCompletedListener(HandshakeCompletedListener handshakeCompletedListener) {
        Preconditions.checkArgument(handshakeCompletedListener != null, "Provided listener is null");
        if (!this.listeners.remove(handshakeCompletedListener)) {
            throw new IllegalArgumentException("Provided listener is not registered");
        }
    }

    @Override // java.net.Socket
    public final void sendUrgentData(int i5) {
        throw new SocketException("Method sendUrgentData() is not supported.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public abstract void setAlpnProtocols(byte[] bArr);

    @Deprecated
    abstract void setAlpnProtocols(String[] strArr);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void setApplicationProtocolSelector(ApplicationProtocolSelector applicationProtocolSelector);

    abstract void setApplicationProtocolSelector(ApplicationProtocolSelectorAdapter applicationProtocolSelectorAdapter);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void setApplicationProtocols(String[] strArr);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void setChannelIdEnabled(boolean z5);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void setChannelIdPrivateKey(PrivateKey privateKey);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setHandshakeTimeout(int i5) {
        throw new SocketException("Method setHandshakeTimeout() is not supported.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setHostname(String str) {
        this.peerHostname = str;
    }

    @Override // java.net.Socket
    public void setKeepAlive(boolean z5) {
        if (isDelegating()) {
            this.socket.setKeepAlive(z5);
        } else {
            super.setKeepAlive(z5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public void setNpnProtocols(byte[] bArr) {
    }

    @Override // java.net.Socket
    public final void setOOBInline(boolean z5) {
        throw new SocketException("Method setOOBInline() is not supported.");
    }

    @Override // java.net.Socket
    public void setPerformancePreferences(int i5, int i6, int i7) {
        if (isDelegating()) {
            this.socket.setPerformancePreferences(i5, i6, i7);
        } else {
            super.setPerformancePreferences(i5, i6, i7);
        }
    }

    @Override // java.net.Socket
    public void setReceiveBufferSize(int i5) {
        if (isDelegating()) {
            this.socket.setReceiveBufferSize(i5);
        } else {
            super.setReceiveBufferSize(i5);
        }
    }

    @Override // java.net.Socket
    public void setReuseAddress(boolean z5) {
        if (isDelegating()) {
            this.socket.setReuseAddress(z5);
        } else {
            super.setReuseAddress(z5);
        }
    }

    @Override // java.net.Socket
    public void setSendBufferSize(int i5) {
        if (isDelegating()) {
            this.socket.setSendBufferSize(i5);
        } else {
            super.setSendBufferSize(i5);
        }
    }

    @Override // java.net.Socket
    public void setSoLinger(boolean z5, int i5) {
        if (isDelegating()) {
            this.socket.setSoLinger(z5, i5);
        } else {
            super.setSoLinger(z5, i5);
        }
    }

    @Override // java.net.Socket
    public final void setSoTimeout(int i5) {
        if (isDelegating()) {
            this.socket.setSoTimeout(i5);
        } else {
            super.setSoTimeout(i5);
            this.readTimeoutMilliseconds = i5;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSoWriteTimeout(int i5) {
        throw new SocketException("Method setSoWriteTimeout() is not supported.");
    }

    @Override // java.net.Socket
    public void setTcpNoDelay(boolean z5) {
        if (isDelegating()) {
            this.socket.setTcpNoDelay(z5);
        } else {
            super.setTcpNoDelay(z5);
        }
    }

    @Override // java.net.Socket
    public void setTrafficClass(int i5) {
        if (isDelegating()) {
            this.socket.setTrafficClass(i5);
        } else {
            super.setTrafficClass(i5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void setUseSessionTickets(boolean z5);

    @Override // java.net.Socket
    public void shutdownInput() {
        if (isDelegating()) {
            this.socket.shutdownInput();
        } else {
            super.shutdownInput();
        }
    }

    @Override // java.net.Socket
    public void shutdownOutput() {
        if (isDelegating()) {
            this.socket.shutdownOutput();
        } else {
            super.shutdownOutput();
        }
    }

    @Override // javax.net.ssl.SSLSocket, java.net.Socket
    public String toString() {
        StringBuilder sb = new StringBuilder("SSL socket over ");
        if (isDelegating()) {
            sb.append(this.socket.toString());
        } else {
            sb.append(super.toString());
        }
        return sb.toString();
    }

    @Override // java.net.Socket
    public final void connect(SocketAddress socketAddress, int i5) {
        if (this.peerHostname == null && (socketAddress instanceof InetSocketAddress)) {
            this.peerHostname = Platform.getHostStringFromInetSocketAddress((InetSocketAddress) socketAddress);
        }
        if (isDelegating()) {
            this.socket.connect(socketAddress, i5);
        } else {
            super.connect(socketAddress, i5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractConscryptSocket(String str, int i5) {
        super(str, i5);
        this.peerInfoProvider = new PeerInfoProvider() { // from class: org.conscrypt.AbstractConscryptSocket.1
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // org.conscrypt.PeerInfoProvider
            public String getHostname() {
                return AbstractConscryptSocket.this.getHostname();
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // org.conscrypt.PeerInfoProvider
            public String getHostnameOrIP() {
                return AbstractConscryptSocket.this.getHostnameOrIP();
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // org.conscrypt.PeerInfoProvider
            public int getPort() {
                return AbstractConscryptSocket.this.getPort();
            }
        };
        this.listeners = new ArrayList(2);
        this.socket = this;
        this.peerHostname = str;
        this.peerPort = i5;
        this.autoClose = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractConscryptSocket(InetAddress inetAddress, int i5) {
        super(inetAddress, i5);
        this.peerInfoProvider = new PeerInfoProvider() { // from class: org.conscrypt.AbstractConscryptSocket.1
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // org.conscrypt.PeerInfoProvider
            public String getHostname() {
                return AbstractConscryptSocket.this.getHostname();
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // org.conscrypt.PeerInfoProvider
            public String getHostnameOrIP() {
                return AbstractConscryptSocket.this.getHostnameOrIP();
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // org.conscrypt.PeerInfoProvider
            public int getPort() {
                return AbstractConscryptSocket.this.getPort();
            }
        };
        this.listeners = new ArrayList(2);
        this.socket = this;
        this.peerHostname = null;
        this.peerPort = -1;
        this.autoClose = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractConscryptSocket(String str, int i5, InetAddress inetAddress, int i6) {
        super(str, i5, inetAddress, i6);
        this.peerInfoProvider = new PeerInfoProvider() { // from class: org.conscrypt.AbstractConscryptSocket.1
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // org.conscrypt.PeerInfoProvider
            public String getHostname() {
                return AbstractConscryptSocket.this.getHostname();
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // org.conscrypt.PeerInfoProvider
            public String getHostnameOrIP() {
                return AbstractConscryptSocket.this.getHostnameOrIP();
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // org.conscrypt.PeerInfoProvider
            public int getPort() {
                return AbstractConscryptSocket.this.getPort();
            }
        };
        this.listeners = new ArrayList(2);
        this.socket = this;
        this.peerHostname = str;
        this.peerPort = i5;
        this.autoClose = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractConscryptSocket(InetAddress inetAddress, int i5, InetAddress inetAddress2, int i6) {
        super(inetAddress, i5, inetAddress2, i6);
        this.peerInfoProvider = new PeerInfoProvider() { // from class: org.conscrypt.AbstractConscryptSocket.1
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // org.conscrypt.PeerInfoProvider
            public String getHostname() {
                return AbstractConscryptSocket.this.getHostname();
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // org.conscrypt.PeerInfoProvider
            public String getHostnameOrIP() {
                return AbstractConscryptSocket.this.getHostnameOrIP();
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // org.conscrypt.PeerInfoProvider
            public int getPort() {
                return AbstractConscryptSocket.this.getPort();
            }
        };
        this.listeners = new ArrayList(2);
        this.socket = this;
        this.peerHostname = null;
        this.peerPort = -1;
        this.autoClose = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractConscryptSocket(Socket socket, String str, int i5, boolean z5) {
        this.peerInfoProvider = new PeerInfoProvider() { // from class: org.conscrypt.AbstractConscryptSocket.1
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // org.conscrypt.PeerInfoProvider
            public String getHostname() {
                return AbstractConscryptSocket.this.getHostname();
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // org.conscrypt.PeerInfoProvider
            public String getHostnameOrIP() {
                return AbstractConscryptSocket.this.getHostnameOrIP();
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // org.conscrypt.PeerInfoProvider
            public int getPort() {
                return AbstractConscryptSocket.this.getPort();
            }
        };
        this.listeners = new ArrayList(2);
        this.socket = (Socket) Preconditions.checkNotNull(socket, "socket");
        this.peerHostname = str;
        this.peerPort = i5;
        this.autoClose = z5;
    }
}
