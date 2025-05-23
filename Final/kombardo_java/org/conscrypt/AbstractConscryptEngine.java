package org.conscrypt;

import java.nio.ByteBuffer;
import java.security.PrivateKey;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLSession;

/* loaded from: classes3.dex */
abstract class AbstractConscryptEngine extends SSLEngine {
    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract byte[] exportKeyingMaterial(String str, byte[] bArr, int i5);

    @Override // javax.net.ssl.SSLEngine
    public abstract String getApplicationProtocol();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract String[] getApplicationProtocols();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract byte[] getChannelId();

    @Override // javax.net.ssl.SSLEngine
    public abstract String getHandshakeApplicationProtocol();

    @Override // javax.net.ssl.SSLEngine
    public final SSLSession getHandshakeSession() {
        return handshakeSession();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract String getHostname();

    @Override // javax.net.ssl.SSLEngine
    public abstract String getPeerHost();

    @Override // javax.net.ssl.SSLEngine
    public abstract int getPeerPort();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract byte[] getTlsUnique();

    abstract SSLSession handshakeSession();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int maxSealOverhead();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void setApplicationProtocolSelector(ApplicationProtocolSelector applicationProtocolSelector);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void setApplicationProtocols(String[] strArr);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void setBufferAllocator(BufferAllocator bufferAllocator);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void setChannelIdEnabled(boolean z5);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void setChannelIdPrivateKey(PrivateKey privateKey);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void setHandshakeListener(HandshakeListener handshakeListener);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void setHostname(String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void setUseSessionTickets(boolean z5);

    @Override // javax.net.ssl.SSLEngine
    public abstract SSLEngineResult unwrap(ByteBuffer byteBuffer, ByteBuffer byteBuffer2);

    @Override // javax.net.ssl.SSLEngine
    public abstract SSLEngineResult unwrap(ByteBuffer byteBuffer, ByteBuffer[] byteBufferArr);

    @Override // javax.net.ssl.SSLEngine
    public abstract SSLEngineResult unwrap(ByteBuffer byteBuffer, ByteBuffer[] byteBufferArr, int i5, int i6);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract SSLEngineResult unwrap(ByteBuffer[] byteBufferArr, int i5, int i6, ByteBuffer[] byteBufferArr2, int i7, int i8);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract SSLEngineResult unwrap(ByteBuffer[] byteBufferArr, ByteBuffer[] byteBufferArr2);

    @Override // javax.net.ssl.SSLEngine
    public abstract SSLEngineResult wrap(ByteBuffer byteBuffer, ByteBuffer byteBuffer2);

    @Override // javax.net.ssl.SSLEngine
    public abstract SSLEngineResult wrap(ByteBuffer[] byteBufferArr, int i5, int i6, ByteBuffer byteBuffer);
}
