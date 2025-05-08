package org.conscrypt;

import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes3.dex */
public abstract class BaseOpenSSLSocketAdapterFactory extends SSLSocketFactory {
    private final OpenSSLSocketFactoryImpl delegate;

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseOpenSSLSocketAdapterFactory(OpenSSLSocketFactoryImpl openSSLSocketFactoryImpl) {
        this.delegate = openSSLSocketFactoryImpl;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket() {
        return wrap((OpenSSLSocketImpl) this.delegate.createSocket());
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return this.delegate.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return this.delegate.getSupportedCipherSuites();
    }

    protected abstract Socket wrap(OpenSSLSocketImpl openSSLSocketImpl);

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i5) {
        return wrap((OpenSSLSocketImpl) this.delegate.createSocket(str, i5));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i5, InetAddress inetAddress, int i6) {
        return wrap((OpenSSLSocketImpl) this.delegate.createSocket(str, i5, inetAddress, i6));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i5) {
        return wrap((OpenSSLSocketImpl) this.delegate.createSocket(inetAddress, i5));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i5, InetAddress inetAddress2, int i6) {
        return wrap((OpenSSLSocketImpl) this.delegate.createSocket(inetAddress, i5, inetAddress2, i6));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i5, boolean z5) {
        return wrap((OpenSSLSocketImpl) this.delegate.createSocket(socket, str, i5, z5));
    }
}
