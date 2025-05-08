package org.conscrypt;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import org.conscrypt.OpenSSLCipher;

/* loaded from: classes3.dex */
public abstract class OpenSSLAeadCipherAES extends OpenSSLAeadCipher {
    private static final int AES_BLOCK_SIZE = 16;

    /* loaded from: classes3.dex */
    public static class GCM extends OpenSSLAeadCipherAES {

        /* loaded from: classes3.dex */
        public static class AES_128 extends GCM {
            @Override // org.conscrypt.OpenSSLAeadCipherAES, org.conscrypt.OpenSSLCipher
            void checkSupportedKeySize(int i5) {
                if (i5 == 16) {
                    return;
                }
                throw new InvalidKeyException("Unsupported key size: " + i5 + " bytes (must be 16)");
            }
        }

        /* loaded from: classes3.dex */
        public static class AES_256 extends GCM {
            @Override // org.conscrypt.OpenSSLAeadCipherAES, org.conscrypt.OpenSSLCipher
            void checkSupportedKeySize(int i5) {
                if (i5 == 32) {
                    return;
                }
                throw new InvalidKeyException("Unsupported key size: " + i5 + " bytes (must be 32)");
            }
        }

        public GCM() {
            super(OpenSSLCipher.Mode.GCM);
        }

        @Override // org.conscrypt.OpenSSLCipher
        void checkSupportedMode(OpenSSLCipher.Mode mode) {
            if (mode != OpenSSLCipher.Mode.GCM) {
                throw new NoSuchAlgorithmException("Mode must be GCM");
            }
        }

        @Override // org.conscrypt.OpenSSLAeadCipher
        long getEVP_AEAD(int i5) {
            if (i5 == 16) {
                return NativeCrypto.EVP_aead_aes_128_gcm();
            }
            if (i5 == 32) {
                return NativeCrypto.EVP_aead_aes_256_gcm();
            }
            throw new RuntimeException("Unexpected key length: " + i5);
        }
    }

    /* loaded from: classes3.dex */
    public static class GCM_SIV extends OpenSSLAeadCipherAES {

        /* loaded from: classes3.dex */
        public static class AES_128 extends GCM_SIV {
            @Override // org.conscrypt.OpenSSLAeadCipherAES, org.conscrypt.OpenSSLCipher
            void checkSupportedKeySize(int i5) {
                if (i5 == 16) {
                    return;
                }
                throw new InvalidKeyException("Unsupported key size: " + i5 + " bytes (must be 16)");
            }
        }

        /* loaded from: classes3.dex */
        public static class AES_256 extends GCM_SIV {
            @Override // org.conscrypt.OpenSSLAeadCipherAES, org.conscrypt.OpenSSLCipher
            void checkSupportedKeySize(int i5) {
                if (i5 == 32) {
                    return;
                }
                throw new InvalidKeyException("Unsupported key size: " + i5 + " bytes (must be 32)");
            }
        }

        public GCM_SIV() {
            super(OpenSSLCipher.Mode.GCM_SIV);
        }

        @Override // org.conscrypt.OpenSSLAeadCipher
        boolean allowsNonceReuse() {
            return true;
        }

        @Override // org.conscrypt.OpenSSLCipher
        void checkSupportedMode(OpenSSLCipher.Mode mode) {
            if (mode != OpenSSLCipher.Mode.GCM_SIV) {
                throw new NoSuchAlgorithmException("Mode must be GCM-SIV");
            }
        }

        @Override // org.conscrypt.OpenSSLAeadCipher
        void checkSupportedTagLength(int i5) {
            if (i5 != 128) {
                throw new InvalidAlgorithmParameterException("Tag length must be 128 bits");
            }
        }

        @Override // org.conscrypt.OpenSSLAeadCipher
        long getEVP_AEAD(int i5) {
            if (i5 == 16) {
                return NativeCrypto.EVP_aead_aes_128_gcm_siv();
            }
            if (i5 == 32) {
                return NativeCrypto.EVP_aead_aes_256_gcm_siv();
            }
            throw new RuntimeException("Unexpected key length: " + i5);
        }
    }

    OpenSSLAeadCipherAES(OpenSSLCipher.Mode mode) {
        super(mode);
    }

    @Override // org.conscrypt.OpenSSLCipher
    void checkSupportedKeySize(int i5) {
        if (i5 == 16 || i5 == 32) {
            return;
        }
        throw new InvalidKeyException("Unsupported key size: " + i5 + " bytes (must be 16 or 32)");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.conscrypt.OpenSSLCipher, javax.crypto.CipherSpi
    public AlgorithmParameters engineGetParameters() {
        byte[] bArr = this.iv;
        if (bArr == null) {
            return null;
        }
        AlgorithmParameterSpec gCMParameterSpec = Platform.toGCMParameterSpec(this.tagLengthInBytes * 8, bArr);
        if (gCMParameterSpec == null) {
            return super.engineGetParameters();
        }
        try {
            AlgorithmParameters algorithmParameters = AlgorithmParameters.getInstance("GCM");
            algorithmParameters.init(gCMParameterSpec);
            return algorithmParameters;
        } catch (NoSuchAlgorithmException e5) {
            throw ((Error) new AssertionError("GCM not supported").initCause(e5));
        } catch (InvalidParameterSpecException unused) {
            return null;
        }
    }

    @Override // org.conscrypt.OpenSSLCipher
    String getBaseCipherName() {
        return "AES";
    }

    @Override // org.conscrypt.OpenSSLCipher
    int getCipherBlockSize() {
        return 16;
    }

    @Override // org.conscrypt.OpenSSLAeadCipher, org.conscrypt.OpenSSLCipher
    int getOutputSizeForFinal(int i5) {
        return isEncrypting() ? this.bufCount + i5 + this.tagLengthInBytes : Math.max(0, (this.bufCount + i5) - this.tagLengthInBytes);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.conscrypt.OpenSSLCipher
    public AlgorithmParameterSpec getParameterSpec(AlgorithmParameters algorithmParameters) {
        if (algorithmParameters == null) {
            return null;
        }
        AlgorithmParameterSpec fromGCMParameters = Platform.fromGCMParameters(algorithmParameters);
        return fromGCMParameters != null ? fromGCMParameters : super.getParameterSpec(algorithmParameters);
    }
}
