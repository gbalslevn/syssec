package org.conscrypt;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import org.conscrypt.OpenSSLCipher;

/* loaded from: classes3.dex */
public class OpenSSLAeadCipherChaCha20 extends OpenSSLAeadCipher {
    public OpenSSLAeadCipherChaCha20() {
        super(OpenSSLCipher.Mode.POLY1305);
    }

    @Override // org.conscrypt.OpenSSLCipher
    void checkSupportedKeySize(int i5) {
        if (i5 == 32) {
            return;
        }
        throw new InvalidKeyException("Unsupported key size: " + i5 + " bytes (must be 32)");
    }

    @Override // org.conscrypt.OpenSSLCipher
    void checkSupportedMode(OpenSSLCipher.Mode mode) {
        if (mode != OpenSSLCipher.Mode.POLY1305) {
            throw new NoSuchAlgorithmException("Mode must be Poly1305");
        }
    }

    @Override // org.conscrypt.OpenSSLCipher
    String getBaseCipherName() {
        return "ChaCha20";
    }

    @Override // org.conscrypt.OpenSSLCipher
    int getCipherBlockSize() {
        return 0;
    }

    @Override // org.conscrypt.OpenSSLAeadCipher
    long getEVP_AEAD(int i5) {
        if (i5 == 32) {
            return NativeCrypto.EVP_aead_chacha20_poly1305();
        }
        throw new RuntimeException("Unexpected key length: " + i5);
    }

    @Override // org.conscrypt.OpenSSLAeadCipher, org.conscrypt.OpenSSLCipher
    int getOutputSizeForFinal(int i5) {
        return isEncrypting() ? this.bufCount + i5 + 16 : Math.max(0, (this.bufCount + i5) - 16);
    }
}
