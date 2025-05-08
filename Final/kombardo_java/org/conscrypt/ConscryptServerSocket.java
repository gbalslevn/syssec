package org.conscrypt;

import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;

/* loaded from: classes3.dex */
final class ConscryptServerSocket extends SSLServerSocket {
    private boolean channelIdEnabled;
    private final SSLParametersImpl sslParameters;
    private boolean useEngineSocket;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConscryptServerSocket(SSLParametersImpl sSLParametersImpl) {
        this.sslParameters = sSLParametersImpl;
    }

    @Override // java.net.ServerSocket
    public Socket accept() {
        AbstractConscryptSocket createEngineSocket = this.useEngineSocket ? Platform.createEngineSocket(this.sslParameters) : Platform.createFileDescriptorSocket(this.sslParameters);
        createEngineSocket.setChannelIdEnabled(this.channelIdEnabled);
        implAccept(createEngineSocket);
        return createEngineSocket;
    }

    @Override // javax.net.ssl.SSLServerSocket
    public boolean getEnableSessionCreation() {
        return this.sslParameters.getEnableSessionCreation();
    }

    @Override // javax.net.ssl.SSLServerSocket
    public String[] getEnabledCipherSuites() {
        return this.sslParameters.getEnabledCipherSuites();
    }

    @Override // javax.net.ssl.SSLServerSocket
    public String[] getEnabledProtocols() {
        return this.sslParameters.getEnabledProtocols();
    }

    @Override // javax.net.ssl.SSLServerSocket
    public boolean getNeedClientAuth() {
        return this.sslParameters.getNeedClientAuth();
    }

    @Override // javax.net.ssl.SSLServerSocket
    public String[] getSupportedCipherSuites() {
        return NativeCrypto.getSupportedCipherSuites();
    }

    @Override // javax.net.ssl.SSLServerSocket
    public String[] getSupportedProtocols() {
        return NativeCrypto.getSupportedProtocols();
    }

    @Override // javax.net.ssl.SSLServerSocket
    public boolean getUseClientMode() {
        return this.sslParameters.getUseClientMode();
    }

    @Override // javax.net.ssl.SSLServerSocket
    public boolean getWantClientAuth() {
        return this.sslParameters.getWantClientAuth();
    }

    boolean isChannelIdEnabled() {
        return this.channelIdEnabled;
    }

    void setChannelIdEnabled(boolean z5) {
        this.channelIdEnabled = z5;
    }

    @Override // javax.net.ssl.SSLServerSocket
    public void setEnableSessionCreation(boolean z5) {
        this.sslParameters.setEnableSessionCreation(z5);
    }

    @Override // javax.net.ssl.SSLServerSocket
    public void setEnabledCipherSuites(String[] strArr) {
        this.sslParameters.setEnabledCipherSuites(strArr);
    }

    @Override // javax.net.ssl.SSLServerSocket
    public void setEnabledProtocols(String[] strArr) {
        this.sslParameters.setEnabledProtocols(strArr);
    }

    @Override // javax.net.ssl.SSLServerSocket
    public void setNeedClientAuth(boolean z5) {
        this.sslParameters.setNeedClientAuth(z5);
    }

    @Override // javax.net.ssl.SSLServerSocket
    public void setUseClientMode(boolean z5) {
        this.sslParameters.setUseClientMode(z5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConscryptServerSocket setUseEngineSocket(boolean z5) {
        this.useEngineSocket = z5;
        return this;
    }

    @Override // javax.net.ssl.SSLServerSocket
    public void setWantClientAuth(boolean z5) {
        this.sslParameters.setWantClientAuth(z5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConscryptServerSocket(int i5, SSLParametersImpl sSLParametersImpl) {
        super(i5);
        this.sslParameters = sSLParametersImpl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConscryptServerSocket(int i5, int i6, SSLParametersImpl sSLParametersImpl) {
        super(i5, i6);
        this.sslParameters = sSLParametersImpl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConscryptServerSocket(int i5, int i6, InetAddress inetAddress, SSLParametersImpl sSLParametersImpl) {
        super(i5, i6, inetAddress);
        this.sslParameters = sSLParametersImpl;
    }
}
