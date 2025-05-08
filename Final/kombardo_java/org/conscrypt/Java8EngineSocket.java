package org.conscrypt;

import java.net.InetAddress;
import java.net.Socket;
import java.util.List;
import java.util.function.BiFunction;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLSocket;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class Java8EngineSocket extends ConscryptEngineSocket {
    private BiFunction<SSLSocket, List<String>, String> selector;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Java8EngineSocket(SSLParametersImpl sSLParametersImpl) {
        super(sSLParametersImpl);
    }

    private static ApplicationProtocolSelector toApplicationProtocolSelector(final BiFunction<SSLSocket, List<String>, String> biFunction) {
        if (biFunction == null) {
            return null;
        }
        return new ApplicationProtocolSelector() { // from class: org.conscrypt.Java8EngineSocket.1
            @Override // org.conscrypt.ApplicationProtocolSelector
            public String selectApplicationProtocol(SSLEngine sSLEngine, List<String> list) {
                throw new UnsupportedOperationException();
            }

            @Override // org.conscrypt.ApplicationProtocolSelector
            public String selectApplicationProtocol(SSLSocket sSLSocket, List<String> list) {
                return (String) biFunction.apply(sSLSocket, list);
            }
        };
    }

    @Override // javax.net.ssl.SSLSocket
    public BiFunction<SSLSocket, List<String>, String> getHandshakeApplicationProtocolSelector() {
        return this.selector;
    }

    @Override // javax.net.ssl.SSLSocket
    public void setHandshakeApplicationProtocolSelector(BiFunction<SSLSocket, List<String>, String> biFunction) {
        this.selector = biFunction;
        setApplicationProtocolSelector(toApplicationProtocolSelector(biFunction));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Java8EngineSocket(String str, int i5, SSLParametersImpl sSLParametersImpl) {
        super(str, i5, sSLParametersImpl);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Java8EngineSocket(InetAddress inetAddress, int i5, SSLParametersImpl sSLParametersImpl) {
        super(inetAddress, i5, sSLParametersImpl);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Java8EngineSocket(String str, int i5, InetAddress inetAddress, int i6, SSLParametersImpl sSLParametersImpl) {
        super(str, i5, inetAddress, i6, sSLParametersImpl);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Java8EngineSocket(InetAddress inetAddress, int i5, InetAddress inetAddress2, int i6, SSLParametersImpl sSLParametersImpl) {
        super(inetAddress, i5, inetAddress2, i6, sSLParametersImpl);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Java8EngineSocket(Socket socket, String str, int i5, boolean z5, SSLParametersImpl sSLParametersImpl) {
        super(socket, str, i5, z5, sSLParametersImpl);
    }
}
