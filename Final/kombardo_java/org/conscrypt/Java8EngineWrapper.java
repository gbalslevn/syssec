package org.conscrypt;

import java.nio.ByteBuffer;
import java.security.PrivateKey;
import java.util.List;
import java.util.function.BiFunction;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

/* loaded from: classes3.dex */
final class Java8EngineWrapper extends AbstractConscryptEngine {
    private final ConscryptEngine delegate;
    private BiFunction<SSLEngine, List<String>, String> selector;

    Java8EngineWrapper(ConscryptEngine conscryptEngine) {
        this.delegate = (ConscryptEngine) Preconditions.checkNotNull(conscryptEngine, "delegate");
    }

    static SSLEngine getDelegate(SSLEngine sSLEngine) {
        return sSLEngine instanceof Java8EngineWrapper ? ((Java8EngineWrapper) sSLEngine).delegate : sSLEngine;
    }

    private static ApplicationProtocolSelector toApplicationProtocolSelector(final BiFunction<SSLEngine, List<String>, String> biFunction) {
        if (biFunction == null) {
            return null;
        }
        return new ApplicationProtocolSelector() { // from class: org.conscrypt.Java8EngineWrapper.1
            @Override // org.conscrypt.ApplicationProtocolSelector
            public String selectApplicationProtocol(SSLEngine sSLEngine, List<String> list) {
                return (String) biFunction.apply(sSLEngine, list);
            }

            @Override // org.conscrypt.ApplicationProtocolSelector
            public String selectApplicationProtocol(SSLSocket sSLSocket, List<String> list) {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // javax.net.ssl.SSLEngine
    public void beginHandshake() {
        this.delegate.beginHandshake();
    }

    @Override // javax.net.ssl.SSLEngine
    public void closeInbound() {
        this.delegate.closeInbound();
    }

    @Override // javax.net.ssl.SSLEngine
    public void closeOutbound() {
        this.delegate.closeOutbound();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptEngine
    public byte[] exportKeyingMaterial(String str, byte[] bArr, int i5) {
        return this.delegate.exportKeyingMaterial(str, bArr, i5);
    }

    @Override // org.conscrypt.AbstractConscryptEngine, javax.net.ssl.SSLEngine
    public String getApplicationProtocol() {
        return this.delegate.getApplicationProtocol();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptEngine
    public String[] getApplicationProtocols() {
        return this.delegate.getApplicationProtocols();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptEngine
    public byte[] getChannelId() {
        return this.delegate.getChannelId();
    }

    @Override // javax.net.ssl.SSLEngine
    public Runnable getDelegatedTask() {
        return this.delegate.getDelegatedTask();
    }

    @Override // javax.net.ssl.SSLEngine
    public boolean getEnableSessionCreation() {
        return this.delegate.getEnableSessionCreation();
    }

    @Override // javax.net.ssl.SSLEngine
    public String[] getEnabledCipherSuites() {
        return this.delegate.getEnabledCipherSuites();
    }

    @Override // javax.net.ssl.SSLEngine
    public String[] getEnabledProtocols() {
        return this.delegate.getEnabledProtocols();
    }

    @Override // org.conscrypt.AbstractConscryptEngine, javax.net.ssl.SSLEngine
    public String getHandshakeApplicationProtocol() {
        return this.delegate.getHandshakeApplicationProtocol();
    }

    @Override // javax.net.ssl.SSLEngine
    public BiFunction<SSLEngine, List<String>, String> getHandshakeApplicationProtocolSelector() {
        return this.selector;
    }

    @Override // javax.net.ssl.SSLEngine
    public SSLEngineResult.HandshakeStatus getHandshakeStatus() {
        return this.delegate.getHandshakeStatus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptEngine
    public String getHostname() {
        return this.delegate.getHostname();
    }

    @Override // javax.net.ssl.SSLEngine
    public boolean getNeedClientAuth() {
        return this.delegate.getNeedClientAuth();
    }

    @Override // org.conscrypt.AbstractConscryptEngine, javax.net.ssl.SSLEngine
    public String getPeerHost() {
        return this.delegate.getPeerHost();
    }

    @Override // org.conscrypt.AbstractConscryptEngine, javax.net.ssl.SSLEngine
    public int getPeerPort() {
        return this.delegate.getPeerPort();
    }

    @Override // javax.net.ssl.SSLEngine
    public SSLParameters getSSLParameters() {
        return this.delegate.getSSLParameters();
    }

    @Override // javax.net.ssl.SSLEngine
    public SSLSession getSession() {
        return this.delegate.getSession();
    }

    @Override // javax.net.ssl.SSLEngine
    public String[] getSupportedCipherSuites() {
        return this.delegate.getSupportedCipherSuites();
    }

    @Override // javax.net.ssl.SSLEngine
    public String[] getSupportedProtocols() {
        return this.delegate.getSupportedProtocols();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptEngine
    public byte[] getTlsUnique() {
        return this.delegate.getTlsUnique();
    }

    @Override // javax.net.ssl.SSLEngine
    public boolean getUseClientMode() {
        return this.delegate.getUseClientMode();
    }

    @Override // javax.net.ssl.SSLEngine
    public boolean getWantClientAuth() {
        return this.delegate.getWantClientAuth();
    }

    @Override // org.conscrypt.AbstractConscryptEngine
    SSLSession handshakeSession() {
        return this.delegate.handshakeSession();
    }

    @Override // javax.net.ssl.SSLEngine
    public boolean isInboundDone() {
        return this.delegate.isInboundDone();
    }

    @Override // javax.net.ssl.SSLEngine
    public boolean isOutboundDone() {
        return this.delegate.isOutboundDone();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptEngine
    public int maxSealOverhead() {
        return this.delegate.maxSealOverhead();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptEngine
    public void setApplicationProtocolSelector(ApplicationProtocolSelector applicationProtocolSelector) {
        this.delegate.setApplicationProtocolSelector(applicationProtocolSelector == null ? null : new ApplicationProtocolSelectorAdapter(this, applicationProtocolSelector));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptEngine
    public void setApplicationProtocols(String[] strArr) {
        this.delegate.setApplicationProtocols(strArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptEngine
    public void setBufferAllocator(BufferAllocator bufferAllocator) {
        this.delegate.setBufferAllocator(bufferAllocator);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptEngine
    public void setChannelIdEnabled(boolean z5) {
        this.delegate.setChannelIdEnabled(z5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptEngine
    public void setChannelIdPrivateKey(PrivateKey privateKey) {
        this.delegate.setChannelIdPrivateKey(privateKey);
    }

    @Override // javax.net.ssl.SSLEngine
    public void setEnableSessionCreation(boolean z5) {
        this.delegate.setEnableSessionCreation(z5);
    }

    @Override // javax.net.ssl.SSLEngine
    public void setEnabledCipherSuites(String[] strArr) {
        this.delegate.setEnabledCipherSuites(strArr);
    }

    @Override // javax.net.ssl.SSLEngine
    public void setEnabledProtocols(String[] strArr) {
        this.delegate.setEnabledProtocols(strArr);
    }

    @Override // javax.net.ssl.SSLEngine
    public void setHandshakeApplicationProtocolSelector(BiFunction<SSLEngine, List<String>, String> biFunction) {
        this.selector = biFunction;
        setApplicationProtocolSelector(toApplicationProtocolSelector(biFunction));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptEngine
    public void setHandshakeListener(HandshakeListener handshakeListener) {
        this.delegate.setHandshakeListener(handshakeListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptEngine
    public void setHostname(String str) {
        this.delegate.setHostname(str);
    }

    @Override // javax.net.ssl.SSLEngine
    public void setNeedClientAuth(boolean z5) {
        this.delegate.setNeedClientAuth(z5);
    }

    @Override // javax.net.ssl.SSLEngine
    public void setSSLParameters(SSLParameters sSLParameters) {
        this.delegate.setSSLParameters(sSLParameters);
    }

    @Override // javax.net.ssl.SSLEngine
    public void setUseClientMode(boolean z5) {
        this.delegate.setUseClientMode(z5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptEngine
    public void setUseSessionTickets(boolean z5) {
        this.delegate.setUseSessionTickets(z5);
    }

    @Override // javax.net.ssl.SSLEngine
    public void setWantClientAuth(boolean z5) {
        this.delegate.setWantClientAuth(z5);
    }

    @Override // org.conscrypt.AbstractConscryptEngine, javax.net.ssl.SSLEngine
    public SSLEngineResult unwrap(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        return this.delegate.unwrap(byteBuffer, byteBuffer2);
    }

    @Override // javax.net.ssl.SSLEngine
    public SSLEngineResult wrap(ByteBuffer[] byteBufferArr, ByteBuffer byteBuffer) {
        return this.delegate.wrap(byteBufferArr, byteBuffer);
    }

    @Override // org.conscrypt.AbstractConscryptEngine, javax.net.ssl.SSLEngine
    public SSLEngineResult unwrap(ByteBuffer byteBuffer, ByteBuffer[] byteBufferArr) {
        return this.delegate.unwrap(byteBuffer, byteBufferArr);
    }

    @Override // org.conscrypt.AbstractConscryptEngine, javax.net.ssl.SSLEngine
    public SSLEngineResult wrap(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        return this.delegate.wrap(byteBuffer, byteBuffer2);
    }

    @Override // org.conscrypt.AbstractConscryptEngine, javax.net.ssl.SSLEngine
    public SSLEngineResult unwrap(ByteBuffer byteBuffer, ByteBuffer[] byteBufferArr, int i5, int i6) {
        return this.delegate.unwrap(byteBuffer, byteBufferArr, i5, i6);
    }

    @Override // org.conscrypt.AbstractConscryptEngine, javax.net.ssl.SSLEngine
    public SSLEngineResult wrap(ByteBuffer[] byteBufferArr, int i5, int i6, ByteBuffer byteBuffer) {
        return this.delegate.wrap(byteBufferArr, i5, i6, byteBuffer);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptEngine
    public SSLEngineResult unwrap(ByteBuffer[] byteBufferArr, ByteBuffer[] byteBufferArr2) {
        return this.delegate.unwrap(byteBufferArr, byteBufferArr2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptEngine
    public SSLEngineResult unwrap(ByteBuffer[] byteBufferArr, int i5, int i6, ByteBuffer[] byteBufferArr2, int i7, int i8) {
        return this.delegate.unwrap(byteBufferArr, i5, i6, byteBufferArr2, i7, i8);
    }
}
