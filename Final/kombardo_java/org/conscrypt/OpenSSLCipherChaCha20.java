package org.conscrypt;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import org.conscrypt.OpenSSLCipher;

/* loaded from: classes3.dex */
public class OpenSSLCipherChaCha20 extends OpenSSLCipher {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int BLOCK_SIZE_BYTES = 64;
    private static final int NONCE_SIZE_BYTES = 12;
    private int currentBlockConsumedBytes = 0;
    private int blockCounter = 0;

    private void reset() {
        this.blockCounter = 0;
        this.currentBlockConsumedBytes = 0;
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
        if (mode != OpenSSLCipher.Mode.NONE) {
            throw new NoSuchAlgorithmException("Mode must be NONE");
        }
    }

    @Override // org.conscrypt.OpenSSLCipher
    void checkSupportedPadding(OpenSSLCipher.Padding padding) {
        if (padding != OpenSSLCipher.Padding.NOPADDING) {
            throw new NoSuchPaddingException("Must be NoPadding");
        }
    }

    @Override // org.conscrypt.OpenSSLCipher
    int doFinalInternal(byte[] bArr, int i5, int i6) {
        reset();
        return 0;
    }

    @Override // org.conscrypt.OpenSSLCipher
    void engineInitInternal(byte[] bArr, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) {
        if (algorithmParameterSpec instanceof IvParameterSpec) {
            IvParameterSpec ivParameterSpec = (IvParameterSpec) algorithmParameterSpec;
            if (ivParameterSpec.getIV().length != 12) {
                throw new InvalidAlgorithmParameterException("IV must be 12 bytes long");
            }
            this.iv = ivParameterSpec.getIV();
            return;
        }
        if (!isEncrypting()) {
            throw new InvalidAlgorithmParameterException("IV must be specified when decrypting");
        }
        byte[] bArr2 = new byte[12];
        this.iv = bArr2;
        if (secureRandom != null) {
            secureRandom.nextBytes(bArr2);
        } else {
            NativeCrypto.RAND_bytes(bArr2);
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

    @Override // org.conscrypt.OpenSSLCipher
    int getOutputSizeForFinal(int i5) {
        return i5;
    }

    @Override // org.conscrypt.OpenSSLCipher
    int getOutputSizeForUpdate(int i5) {
        return i5;
    }

    @Override // org.conscrypt.OpenSSLCipher
    int updateInternal(byte[] bArr, int i5, int i6, byte[] bArr2, int i7, int i8) {
        int i9;
        int i10;
        int i11;
        if (i6 > bArr2.length - i7) {
            throw new ShortBufferWithoutStackTraceException("Insufficient output space");
        }
        int i12 = this.currentBlockConsumedBytes;
        if (i12 > 0) {
            int min = Math.min(64 - i12, i6);
            byte[] bArr3 = new byte[64];
            byte[] bArr4 = new byte[64];
            System.arraycopy(bArr, i5, bArr3, this.currentBlockConsumedBytes, min);
            NativeCrypto.chacha20_encrypt_decrypt(bArr3, 0, bArr4, 0, 64, this.encodedKey, this.iv, this.blockCounter);
            System.arraycopy(bArr4, this.currentBlockConsumedBytes, bArr2, i7, min);
            int i13 = this.currentBlockConsumedBytes + min;
            this.currentBlockConsumedBytes = i13;
            if (i13 < 64) {
                return min;
            }
            this.currentBlockConsumedBytes = 0;
            int i14 = i5 + min;
            int i15 = i7 + min;
            int i16 = i6 - min;
            this.blockCounter++;
            i11 = i15;
            i9 = i14;
            i10 = i16;
        } else {
            i9 = i5;
            i10 = i6;
            i11 = i7;
        }
        NativeCrypto.chacha20_encrypt_decrypt(bArr, i9, bArr2, i11, i10, this.encodedKey, this.iv, this.blockCounter);
        this.currentBlockConsumedBytes = i10 % 64;
        this.blockCounter += i10 / 64;
        return i6;
    }
}
