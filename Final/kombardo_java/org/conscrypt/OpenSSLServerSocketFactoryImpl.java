package org.conscrypt;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.security.KeyManagementException;
import javax.net.ServerSocketFactory;
import javax.net.ssl.SSLServerSocketFactory;

/* loaded from: classes3.dex */
final class OpenSSLServerSocketFactoryImpl extends SSLServerSocketFactory {
    private static boolean useEngineSocketByDefault = SSLUtils.USE_ENGINE_SOCKET_BY_DEFAULT;
    private IOException instantiationException;
    private SSLParametersImpl sslParameters;
    private boolean useEngineSocket = useEngineSocketByDefault;

    OpenSSLServerSocketFactoryImpl() {
        try {
            SSLParametersImpl sSLParametersImpl = SSLParametersImpl.getDefault();
            this.sslParameters = sSLParametersImpl;
            sSLParametersImpl.setUseClientMode(false);
        } catch (KeyManagementException e5) {
            IOException iOException = new IOException("Delayed instantiation exception:");
            this.instantiationException = iOException;
            iOException.initCause(e5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setUseEngineSocketByDefault(boolean z5) {
        useEngineSocketByDefault = z5;
        ServerSocketFactory serverSocketFactory = SSLServerSocketFactory.getDefault();
        if (serverSocketFactory instanceof OpenSSLServerSocketFactoryImpl) {
            ((OpenSSLServerSocketFactoryImpl) serverSocketFactory).setUseEngineSocket(z5);
        }
    }

    @Override // javax.net.ServerSocketFactory
    public ServerSocket createServerSocket() {
        return new ConscryptServerSocket((SSLParametersImpl) this.sslParameters.clone()).setUseEngineSocket(this.useEngineSocket);
    }

    @Override // javax.net.ssl.SSLServerSocketFactory
    public String[] getDefaultCipherSuites() {
        return this.sslParameters.getEnabledCipherSuites();
    }

    @Override // javax.net.ssl.SSLServerSocketFactory
    public String[] getSupportedCipherSuites() {
        return NativeCrypto.getSupportedCipherSuites();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setUseEngineSocket(boolean z5) {
        this.useEngineSocket = z5;
    }

    @Override // javax.net.ServerSocketFactory
    public ServerSocket createServerSocket(int i5) {
        return new ConscryptServerSocket(i5, (SSLParametersImpl) this.sslParameters.clone()).setUseEngineSocket(this.useEngineSocket);
    }

    @Override // javax.net.ServerSocketFactory
    public ServerSocket createServerSocket(int i5, int i6) {
        return new ConscryptServerSocket(i5, i6, (SSLParametersImpl) this.sslParameters.clone()).setUseEngineSocket(this.useEngineSocket);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OpenSSLServerSocketFactoryImpl(SSLParametersImpl sSLParametersImpl) {
        SSLParametersImpl sSLParametersImpl2 = (SSLParametersImpl) sSLParametersImpl.clone();
        this.sslParameters = sSLParametersImpl2;
        sSLParametersImpl2.setUseClientMode(false);
    }

    @Override // javax.net.ServerSocketFactory
    public ServerSocket createServerSocket(int i5, int i6, InetAddress inetAddress) {
        return new ConscryptServerSocket(i5, i6, inetAddress, (SSLParametersImpl) this.sslParameters.clone()).setUseEngineSocket(this.useEngineSocket);
    }
}
