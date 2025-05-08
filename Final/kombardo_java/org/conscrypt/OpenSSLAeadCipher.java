package org.conscrypt;

import java.lang.reflect.InvocationTargetException;
import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import org.conscrypt.OpenSSLCipher;

/* loaded from: classes3.dex */
public abstract class OpenSSLAeadCipher extends OpenSSLCipher {
    static final int DEFAULT_TAG_SIZE_BITS = 128;
    private static final boolean ENABLE_BYTEBUFFER_OPTIMIZATIONS = true;
    private static int lastGlobalMessageSize = 32;
    private byte[] aad;
    byte[] buf;
    int bufCount;
    long evpAead;
    private boolean mustInitialize;
    private byte[] previousIv;
    private byte[] previousKey;
    int tagLengthInBytes;

    public OpenSSLAeadCipher(OpenSSLCipher.Mode mode) {
        super(mode, OpenSSLCipher.Padding.NOPADDING);
    }

    private boolean arraysAreEqual(byte[] bArr, byte[] bArr2) {
        if (bArr.length != bArr2.length) {
            return false;
        }
        int i5 = 0;
        for (int i6 = 0; i6 < bArr.length; i6++) {
            i5 |= bArr[i6] ^ bArr2[i6];
        }
        if (i5 == 0) {
            return ENABLE_BYTEBUFFER_OPTIMIZATIONS;
        }
        return false;
    }

    private void checkInitialization() {
        if (this.mustInitialize) {
            throw new IllegalStateException("Cannot re-use same key and IV for multiple encryptions");
        }
    }

    private void expand(int i5) {
        int i6 = this.bufCount;
        int i7 = i6 + i5;
        byte[] bArr = this.buf;
        if (i7 <= bArr.length) {
            return;
        }
        byte[] bArr2 = new byte[(i5 + i6) * 2];
        System.arraycopy(bArr, 0, bArr2, 0, i6);
        this.buf = bArr2;
    }

    private void reset() {
        this.aad = null;
        int i5 = lastGlobalMessageSize;
        byte[] bArr = this.buf;
        if (bArr == null) {
            this.buf = new byte[i5];
        } else {
            int i6 = this.bufCount;
            if (i6 > 0 && i6 != i5) {
                lastGlobalMessageSize = i6;
                if (bArr.length != i6) {
                    this.buf = new byte[i6];
                }
            }
        }
        this.bufCount = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0036 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void throwAEADBadTagExceptionIfAvailable(String str, Throwable th) {
        BadPaddingException badPaddingException;
        try {
            BadPaddingException badPaddingException2 = null;
            try {
                try {
                    badPaddingException = (BadPaddingException) Class.forName("javax.crypto.AEADBadTagException").getConstructor(String.class).newInstance(str);
                    try {
                        badPaddingException.initCause(th);
                    } catch (IllegalAccessException | InstantiationException unused) {
                        badPaddingException2 = badPaddingException;
                        badPaddingException = badPaddingException2;
                        if (badPaddingException == null) {
                        }
                    }
                } catch (InvocationTargetException e5) {
                    throw ((BadPaddingException) new BadPaddingException().initCause(e5.getTargetException()));
                }
            } catch (IllegalAccessException | InstantiationException unused2) {
            }
            if (badPaddingException == null) {
                throw badPaddingException;
            }
        } catch (Exception unused3) {
        }
    }

    boolean allowsNonceReuse() {
        return false;
    }

    @Override // org.conscrypt.OpenSSLCipher
    void checkSupportedPadding(OpenSSLCipher.Padding padding) {
        if (padding != OpenSSLCipher.Padding.NOPADDING) {
            throw new NoSuchPaddingException("Must be NoPadding for AEAD ciphers");
        }
    }

    void checkSupportedTagLength(int i5) {
        if (i5 % 8 == 0) {
            return;
        }
        throw new InvalidAlgorithmParameterException("Tag length must be a multiple of 8; was " + i5);
    }

    int doFinalInternal(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        int EVP_AEAD_CTX_open_buf;
        checkInitialization();
        try {
            if (isEncrypting()) {
                EVP_AEAD_CTX_open_buf = NativeCrypto.EVP_AEAD_CTX_seal_buf(this.evpAead, this.encodedKey, this.tagLengthInBytes, byteBuffer2, this.iv, byteBuffer, this.aad);
            } else {
                EVP_AEAD_CTX_open_buf = NativeCrypto.EVP_AEAD_CTX_open_buf(this.evpAead, this.encodedKey, this.tagLengthInBytes, byteBuffer2, this.iv, byteBuffer, this.aad);
            }
            if (isEncrypting()) {
                this.mustInitialize = ENABLE_BYTEBUFFER_OPTIMIZATIONS;
            }
            return EVP_AEAD_CTX_open_buf;
        } catch (BadPaddingException e5) {
            throwAEADBadTagExceptionIfAvailable(e5.getMessage(), e5.getCause());
            throw e5;
        }
    }

    @Override // javax.crypto.CipherSpi
    protected int engineDoFinal(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        if (byteBuffer != null && byteBuffer2 != null) {
            if (getOutputSizeForFinal(byteBuffer.remaining()) <= byteBuffer2.remaining()) {
                if (!byteBuffer2.isReadOnly()) {
                    if (this.bufCount != 0) {
                        return super.engineDoFinal(byteBuffer, byteBuffer2);
                    }
                    if (!byteBuffer.isDirect()) {
                        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(byteBuffer.remaining());
                        allocateDirect.mark();
                        allocateDirect.put(byteBuffer);
                        allocateDirect.reset();
                        byteBuffer = allocateDirect;
                    }
                    if (!byteBuffer2.isDirect()) {
                        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(getOutputSizeForFinal(byteBuffer.remaining()));
                        int doFinalInternal = doFinalInternal(byteBuffer, allocateDirect2);
                        byteBuffer2.put(allocateDirect2);
                        byteBuffer.position(byteBuffer.limit());
                        return doFinalInternal;
                    }
                    int doFinalInternal2 = doFinalInternal(byteBuffer, byteBuffer2);
                    byteBuffer2.position(byteBuffer2.position() + doFinalInternal2);
                    byteBuffer.position(byteBuffer.limit());
                    return doFinalInternal2;
                }
                throw new IllegalArgumentException("Cannot write to Read Only ByteBuffer");
            }
            throw new ShortBufferWithoutStackTraceException("Insufficient Bytes for Output Buffer");
        }
        throw new NullPointerException("Null ByteBuffer Error");
    }

    @Override // org.conscrypt.OpenSSLCipher
    void engineInitInternal(byte[] bArr, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) {
        byte[] bArr2 = null;
        int i5 = 128;
        if (algorithmParameterSpec != null) {
            GCMParameters fromGCMParameterSpec = Platform.fromGCMParameterSpec(algorithmParameterSpec);
            if (fromGCMParameterSpec != null) {
                bArr2 = fromGCMParameterSpec.getIV();
                i5 = fromGCMParameterSpec.getTLen();
            } else if (algorithmParameterSpec instanceof IvParameterSpec) {
                bArr2 = ((IvParameterSpec) algorithmParameterSpec).getIV();
            }
        }
        checkSupportedTagLength(i5);
        this.tagLengthInBytes = i5 / 8;
        boolean isEncrypting = isEncrypting();
        long evp_aead = getEVP_AEAD(bArr.length);
        this.evpAead = evp_aead;
        int EVP_AEAD_nonce_length = NativeCrypto.EVP_AEAD_nonce_length(evp_aead);
        if (bArr2 != null || EVP_AEAD_nonce_length == 0) {
            if (EVP_AEAD_nonce_length == 0 && bArr2 != null) {
                throw new InvalidAlgorithmParameterException("IV not used in " + this.mode + " mode");
            }
            if (bArr2 != null && bArr2.length != EVP_AEAD_nonce_length) {
                throw new InvalidAlgorithmParameterException("Expected IV length of " + EVP_AEAD_nonce_length + " but was " + bArr2.length);
            }
        } else {
            if (!isEncrypting) {
                throw new InvalidAlgorithmParameterException("IV must be specified in " + this.mode + " mode");
            }
            bArr2 = new byte[EVP_AEAD_nonce_length];
            if (secureRandom != null) {
                secureRandom.nextBytes(bArr2);
            } else {
                NativeCrypto.RAND_bytes(bArr2);
            }
        }
        if (isEncrypting() && bArr2 != null && !allowsNonceReuse()) {
            byte[] bArr3 = this.previousKey;
            if (bArr3 != null && this.previousIv != null && arraysAreEqual(bArr3, bArr) && arraysAreEqual(this.previousIv, bArr2)) {
                this.mustInitialize = ENABLE_BYTEBUFFER_OPTIMIZATIONS;
                throw new InvalidAlgorithmParameterException("When using AEAD key and IV must not be re-used");
            }
            this.previousKey = bArr;
            this.previousIv = bArr2;
        }
        this.mustInitialize = false;
        this.iv = bArr2;
        reset();
    }

    @Override // javax.crypto.CipherSpi
    protected void engineUpdateAAD(byte[] bArr, int i5, int i6) {
        checkInitialization();
        byte[] bArr2 = this.aad;
        if (bArr2 == null) {
            this.aad = Arrays.copyOfRange(bArr, i5, i6 + i5);
            return;
        }
        byte[] bArr3 = new byte[bArr2.length + i6];
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        System.arraycopy(bArr, i5, bArr3, this.aad.length, i6);
        this.aad = bArr3;
    }

    abstract long getEVP_AEAD(int i5);

    @Override // org.conscrypt.OpenSSLCipher
    int getOutputSizeForFinal(int i5) {
        return this.bufCount + i5 + (isEncrypting() ? NativeCrypto.EVP_AEAD_max_overhead(this.evpAead) : 0);
    }

    @Override // org.conscrypt.OpenSSLCipher
    int getOutputSizeForUpdate(int i5) {
        return 0;
    }

    @Override // org.conscrypt.OpenSSLCipher
    int updateInternal(byte[] bArr, int i5, int i6, byte[] bArr2, int i7, int i8) {
        checkInitialization();
        if (this.buf == null) {
            throw new IllegalStateException("Cipher not initialized");
        }
        ArrayUtils.checkOffsetAndCount(bArr.length, i5, i6);
        if (i6 <= 0) {
            return 0;
        }
        expand(i6);
        System.arraycopy(bArr, i5, this.buf, this.bufCount, i6);
        this.bufCount += i6;
        return 0;
    }

    @Override // org.conscrypt.OpenSSLCipher
    int doFinalInternal(byte[] bArr, int i5, int i6) {
        int EVP_AEAD_CTX_open;
        checkInitialization();
        try {
            if (isEncrypting()) {
                EVP_AEAD_CTX_open = NativeCrypto.EVP_AEAD_CTX_seal(this.evpAead, this.encodedKey, this.tagLengthInBytes, bArr, i5, this.iv, this.buf, 0, this.bufCount, this.aad);
            } else {
                EVP_AEAD_CTX_open = NativeCrypto.EVP_AEAD_CTX_open(this.evpAead, this.encodedKey, this.tagLengthInBytes, bArr, i5, this.iv, this.buf, 0, this.bufCount, this.aad);
            }
            if (isEncrypting()) {
                this.mustInitialize = ENABLE_BYTEBUFFER_OPTIMIZATIONS;
            }
            reset();
            return EVP_AEAD_CTX_open;
        } catch (BadPaddingException e5) {
            throwAEADBadTagExceptionIfAvailable(e5.getMessage(), e5.getCause());
            throw e5;
        }
    }

    @Override // javax.crypto.CipherSpi
    protected void engineUpdateAAD(ByteBuffer byteBuffer) {
        checkInitialization();
        byte[] bArr = this.aad;
        if (bArr == null) {
            byte[] bArr2 = new byte[byteBuffer.remaining()];
            this.aad = bArr2;
            byteBuffer.get(bArr2);
        } else {
            byte[] bArr3 = new byte[bArr.length + byteBuffer.remaining()];
            byte[] bArr4 = this.aad;
            System.arraycopy(bArr4, 0, bArr3, 0, bArr4.length);
            byteBuffer.get(bArr3, this.aad.length, byteBuffer.remaining());
            this.aad = bArr3;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.conscrypt.OpenSSLCipher, javax.crypto.CipherSpi
    public int engineDoFinal(byte[] bArr, int i5, int i6, byte[] bArr2, int i7) {
        if (bArr2 != null && getOutputSizeForFinal(i6) > bArr2.length - i7) {
            throw new ShortBufferWithoutStackTraceException("Insufficient output space");
        }
        return super.engineDoFinal(bArr, i5, i6, bArr2, i7);
    }
}
