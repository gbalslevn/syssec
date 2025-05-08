package org.conscrypt;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.InvalidParameterSpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Locale;
import javax.crypto.BadPaddingException;
import javax.crypto.CipherSpi;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes3.dex */
public abstract class OpenSSLCipher extends CipherSpi {
    private int blockSize;
    byte[] encodedKey;
    private boolean encrypting;
    byte[] iv;
    Mode mode;
    private Padding padding;

    /* loaded from: classes3.dex */
    enum Mode {
        NONE,
        CBC,
        CTR,
        ECB,
        GCM,
        GCM_SIV,
        POLY1305;

        public static Mode getNormalized(String str) {
            String upperCase = str.toUpperCase(Locale.US);
            if (upperCase.equals("GCM-SIV")) {
                return GCM_SIV;
            }
            if (upperCase.equals("GCM_SIV")) {
                throw new IllegalArgumentException("Invalid mode");
            }
            return valueOf(upperCase);
        }
    }

    /* loaded from: classes3.dex */
    enum Padding {
        NOPADDING,
        PKCS5PADDING,
        PKCS7PADDING;

        public static Padding getNormalized(String str) {
            Padding valueOf = valueOf(str.toUpperCase(Locale.US));
            return valueOf == PKCS7PADDING ? PKCS5PADDING : valueOf;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OpenSSLCipher() {
        this.mode = Mode.ECB;
        this.padding = Padding.PKCS5PADDING;
    }

    private byte[] checkAndSetEncodedKey(int i5, Key key) {
        if (i5 == 1 || i5 == 3) {
            this.encrypting = true;
        } else {
            if (i5 != 2 && i5 != 4) {
                throw new InvalidParameterException("Unsupported opmode " + i5);
            }
            this.encrypting = false;
        }
        if (!(key instanceof SecretKey)) {
            throw new InvalidKeyException("Only SecretKey is supported");
        }
        byte[] encoded = key.getEncoded();
        if (encoded == null) {
            throw new InvalidKeyException("key.getEncoded() == null");
        }
        checkSupportedKeySize(encoded.length);
        this.encodedKey = encoded;
        return encoded;
    }

    abstract void checkSupportedKeySize(int i5);

    abstract void checkSupportedMode(Mode mode);

    abstract void checkSupportedPadding(Padding padding);

    abstract int doFinalInternal(byte[] bArr, int i5, int i6);

    @Override // javax.crypto.CipherSpi
    protected byte[] engineDoFinal(byte[] bArr, int i5, int i6) {
        int i7;
        int outputSizeForFinal = getOutputSizeForFinal(i6);
        byte[] bArr2 = new byte[outputSizeForFinal];
        if (i6 > 0) {
            try {
                i7 = updateInternal(bArr, i5, i6, bArr2, 0, outputSizeForFinal);
            } catch (ShortBufferException e5) {
                throw new RuntimeException("our calculated buffer was too small", e5);
            }
        } else {
            i7 = 0;
        }
        try {
            int doFinalInternal = i7 + doFinalInternal(bArr2, i7, outputSizeForFinal - i7);
            if (doFinalInternal == outputSizeForFinal) {
                return bArr2;
            }
            if (doFinalInternal == 0) {
                return EmptyArray.BYTE;
            }
            return Arrays.copyOfRange(bArr2, 0, doFinalInternal);
        } catch (ShortBufferException e6) {
            throw new RuntimeException("our calculated buffer was too small", e6);
        }
    }

    @Override // javax.crypto.CipherSpi
    protected int engineGetBlockSize() {
        return this.blockSize;
    }

    @Override // javax.crypto.CipherSpi
    protected byte[] engineGetIV() {
        return this.iv;
    }

    @Override // javax.crypto.CipherSpi
    protected int engineGetKeySize(Key key) {
        if (!(key instanceof SecretKey)) {
            throw new InvalidKeyException("Only SecretKey is supported");
        }
        byte[] encoded = key.getEncoded();
        if (encoded == null) {
            throw new InvalidKeyException("key.getEncoded() == null");
        }
        checkSupportedKeySize(encoded.length);
        return encoded.length * 8;
    }

    @Override // javax.crypto.CipherSpi
    protected int engineGetOutputSize(int i5) {
        return Math.max(getOutputSizeForUpdate(i5), getOutputSizeForFinal(i5));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.crypto.CipherSpi
    public AlgorithmParameters engineGetParameters() {
        byte[] bArr = this.iv;
        if (bArr != null && bArr.length > 0) {
            try {
                AlgorithmParameters algorithmParameters = AlgorithmParameters.getInstance(getBaseCipherName());
                algorithmParameters.init(new IvParameterSpec(this.iv));
                return algorithmParameters;
            } catch (NoSuchAlgorithmException | InvalidParameterSpecException unused) {
            }
        }
        return null;
    }

    @Override // javax.crypto.CipherSpi
    protected void engineInit(int i5, Key key, SecureRandom secureRandom) {
        checkAndSetEncodedKey(i5, key);
        try {
            engineInitInternal(this.encodedKey, null, secureRandom);
        } catch (InvalidAlgorithmParameterException e5) {
            throw new RuntimeException(e5);
        }
    }

    abstract void engineInitInternal(byte[] bArr, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom);

    @Override // javax.crypto.CipherSpi
    protected void engineSetMode(String str) {
        try {
            Mode normalized = Mode.getNormalized(str);
            checkSupportedMode(normalized);
            this.mode = normalized;
        } catch (IllegalArgumentException e5) {
            NoSuchAlgorithmException noSuchAlgorithmException = new NoSuchAlgorithmException("No such mode: " + str);
            noSuchAlgorithmException.initCause(e5);
            throw noSuchAlgorithmException;
        }
    }

    @Override // javax.crypto.CipherSpi
    protected void engineSetPadding(String str) {
        try {
            Padding normalized = Padding.getNormalized(str);
            checkSupportedPadding(normalized);
            this.padding = normalized;
        } catch (IllegalArgumentException e5) {
            NoSuchPaddingException noSuchPaddingException = new NoSuchPaddingException("No such padding: " + str);
            noSuchPaddingException.initCause(e5);
            throw noSuchPaddingException;
        }
    }

    @Override // javax.crypto.CipherSpi
    protected Key engineUnwrap(byte[] bArr, String str, int i5) {
        try {
            byte[] engineDoFinal = engineDoFinal(bArr, 0, bArr.length);
            if (i5 == 1) {
                return KeyFactory.getInstance(str).generatePublic(new X509EncodedKeySpec(engineDoFinal));
            }
            if (i5 == 2) {
                return KeyFactory.getInstance(str).generatePrivate(new PKCS8EncodedKeySpec(engineDoFinal));
            }
            if (i5 == 3) {
                return new SecretKeySpec(engineDoFinal, str);
            }
            throw new UnsupportedOperationException("wrappedKeyType == " + i5);
        } catch (InvalidKeySpecException e5) {
            throw new InvalidKeyException(e5);
        } catch (BadPaddingException e6) {
            throw new InvalidKeyException(e6);
        } catch (IllegalBlockSizeException e7) {
            throw new InvalidKeyException(e7);
        }
    }

    @Override // javax.crypto.CipherSpi
    protected byte[] engineUpdate(byte[] bArr, int i5, int i6) {
        byte[] bArr2;
        int outputSizeForUpdate = getOutputSizeForUpdate(i6);
        if (outputSizeForUpdate > 0) {
            bArr2 = new byte[outputSizeForUpdate];
        } else {
            bArr2 = EmptyArray.BYTE;
        }
        byte[] bArr3 = bArr2;
        try {
            int updateInternal = updateInternal(bArr, i5, i6, bArr3, 0, outputSizeForUpdate);
            if (bArr3.length == updateInternal) {
                return bArr3;
            }
            if (updateInternal == 0) {
                return EmptyArray.BYTE;
            }
            return Arrays.copyOfRange(bArr3, 0, updateInternal);
        } catch (ShortBufferException unused) {
            throw new RuntimeException("calculated buffer size was wrong: " + outputSizeForUpdate);
        }
    }

    @Override // javax.crypto.CipherSpi
    protected byte[] engineWrap(Key key) {
        try {
            byte[] encoded = key.getEncoded();
            return engineDoFinal(encoded, 0, encoded.length);
        } catch (BadPaddingException e5) {
            IllegalBlockSizeException illegalBlockSizeException = new IllegalBlockSizeException();
            illegalBlockSizeException.initCause(e5);
            throw illegalBlockSizeException;
        }
    }

    abstract String getBaseCipherName();

    abstract int getCipherBlockSize();

    abstract int getOutputSizeForFinal(int i5);

    abstract int getOutputSizeForUpdate(int i5);

    /* JADX INFO: Access modifiers changed from: package-private */
    public Padding getPadding() {
        return this.padding;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AlgorithmParameterSpec getParameterSpec(AlgorithmParameters algorithmParameters) {
        if (algorithmParameters == null) {
            return null;
        }
        try {
            return algorithmParameters.getParameterSpec(IvParameterSpec.class);
        } catch (InvalidParameterSpecException e5) {
            throw new InvalidAlgorithmParameterException("Params must be convertible to IvParameterSpec", e5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isEncrypting() {
        return this.encrypting;
    }

    boolean supportsVariableSizeIv() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean supportsVariableSizeKey() {
        return false;
    }

    abstract int updateInternal(byte[] bArr, int i5, int i6, byte[] bArr2, int i7, int i8);

    /* JADX INFO: Access modifiers changed from: package-private */
    public OpenSSLCipher(Mode mode, Padding padding) {
        this.mode = Mode.ECB;
        Padding padding2 = Padding.NOPADDING;
        this.mode = mode;
        this.padding = padding;
        this.blockSize = getCipherBlockSize();
    }

    @Override // javax.crypto.CipherSpi
    protected void engineInit(int i5, Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) {
        checkAndSetEncodedKey(i5, key);
        engineInitInternal(this.encodedKey, algorithmParameterSpec, secureRandom);
    }

    @Override // javax.crypto.CipherSpi
    protected void engineInit(int i5, Key key, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) {
        engineInit(i5, key, getParameterSpec(algorithmParameters), secureRandom);
    }

    @Override // javax.crypto.CipherSpi
    protected int engineUpdate(byte[] bArr, int i5, int i6, byte[] bArr2, int i7) {
        return updateInternal(bArr, i5, i6, bArr2, i7, getOutputSizeForUpdate(i6));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.crypto.CipherSpi
    public int engineDoFinal(byte[] bArr, int i5, int i6, byte[] bArr2, int i7) {
        int i8;
        if (bArr2 != null) {
            int outputSizeForFinal = getOutputSizeForFinal(i6);
            if (i6 > 0) {
                i8 = updateInternal(bArr, i5, i6, bArr2, i7, outputSizeForFinal);
                i7 += i8;
                outputSizeForFinal -= i8;
            } else {
                i8 = 0;
            }
            return i8 + doFinalInternal(bArr2, i7, outputSizeForFinal);
        }
        throw new NullPointerException("output == null");
    }
}
