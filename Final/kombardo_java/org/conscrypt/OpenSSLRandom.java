package org.conscrypt;

import java.io.Serializable;
import java.security.SecureRandomSpi;

/* loaded from: classes3.dex */
public final class OpenSSLRandom extends SecureRandomSpi implements Serializable {
    private static final long serialVersionUID = 8506210602917522861L;

    @Override // java.security.SecureRandomSpi
    protected byte[] engineGenerateSeed(int i5) {
        byte[] bArr = new byte[i5];
        NativeCrypto.RAND_bytes(bArr);
        return bArr;
    }

    @Override // java.security.SecureRandomSpi
    protected void engineNextBytes(byte[] bArr) {
        NativeCrypto.RAND_bytes(bArr);
    }

    @Override // java.security.SecureRandomSpi
    protected void engineSetSeed(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException("seed == null");
        }
    }
}
