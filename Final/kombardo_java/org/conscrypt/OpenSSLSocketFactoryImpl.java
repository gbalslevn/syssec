package org.conscrypt;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.security.KeyManagementException;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes3.dex */
final class OpenSSLSocketFactoryImpl extends SSLSocketFactory {
    private static boolean useEngineSocketByDefault = SSLUtils.USE_ENGINE_SOCKET_BY_DEFAULT;
    private final IOException instantiationException;
    private final SSLParametersImpl sslParameters;
    private boolean useEngineSocket;

    OpenSSLSocketFactoryImpl() {
        IOException iOException;
        this.useEngineSocket = useEngineSocketByDefault;
        SSLParametersImpl sSLParametersImpl = null;
        try {
            iOException = null;
            sSLParametersImpl = SSLParametersImpl.getDefault();
        } catch (KeyManagementException e5) {
            iOException = new IOException("Delayed instantiation exception:", e5);
        }
        this.sslParameters = sSLParametersImpl;
        this.instantiationException = iOException;
    }

    private boolean hasFileDescriptor(Socket socket) {
        try {
            Platform.getFileDescriptor(socket);
            return true;
        } catch (RuntimeException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setUseEngineSocketByDefault(boolean z5) {
        useEngineSocketByDefault = z5;
        SocketFactory socketFactory = SSLSocketFactory.getDefault();
        if (socketFactory instanceof OpenSSLSocketFactoryImpl) {
            ((OpenSSLSocketFactoryImpl) socketFactory).setUseEngineSocket(z5);
        }
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket() {
        IOException iOException = this.instantiationException;
        if (iOException == null) {
            if (this.useEngineSocket) {
                return Platform.createEngineSocket((SSLParametersImpl) this.sslParameters.clone());
            }
            return Platform.createFileDescriptorSocket((SSLParametersImpl) this.sslParameters.clone());
        }
        throw iOException;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return this.sslParameters.getEnabledCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return NativeCrypto.getSupportedCipherSuites();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setUseEngineSocket(boolean z5) {
        this.useEngineSocket = z5;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i5) {
        if (this.useEngineSocket) {
            return Platform.createEngineSocket(str, i5, (SSLParametersImpl) this.sslParameters.clone());
        }
        return Platform.createFileDescriptorSocket(str, i5, (SSLParametersImpl) this.sslParameters.clone());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OpenSSLSocketFactoryImpl(SSLParametersImpl sSLParametersImpl) {
        this.useEngineSocket = useEngineSocketByDefault;
        this.sslParameters = sSLParametersImpl;
        this.instantiationException = null;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i5, InetAddress inetAddress, int i6) {
        if (this.useEngineSocket) {
            return Platform.createEngineSocket(str, i5, inetAddress, i6, (SSLParametersImpl) this.sslParameters.clone());
        }
        return Platform.createFileDescriptorSocket(str, i5, inetAddress, i6, (SSLParametersImpl) this.sslParameters.clone());
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i5) {
        if (this.useEngineSocket) {
            return Platform.createEngineSocket(inetAddress, i5, (SSLParametersImpl) this.sslParameters.clone());
        }
        return Platform.createFileDescriptorSocket(inetAddress, i5, (SSLParametersImpl) this.sslParameters.clone());
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i5, InetAddress inetAddress2, int i6) {
        if (this.useEngineSocket) {
            return Platform.createEngineSocket(inetAddress, i5, inetAddress2, i6, (SSLParametersImpl) this.sslParameters.clone());
        }
        return Platform.createFileDescriptorSocket(inetAddress, i5, inetAddress2, i6, (SSLParametersImpl) this.sslParameters.clone());
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i5, boolean z5) {
        Preconditions.checkNotNull(socket, "socket");
        if (socket.isConnected()) {
            if (!this.useEngineSocket && hasFileDescriptor(socket)) {
                return Platform.createFileDescriptorSocket(socket, str, i5, z5, (SSLParametersImpl) this.sslParameters.clone());
            }
            return Platform.createEngineSocket(socket, str, i5, z5, (SSLParametersImpl) this.sslParameters.clone());
        }
        throw new SocketException("Socket is not connected.");
    }
}
