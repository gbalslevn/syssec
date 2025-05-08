package org.conscrypt;

import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.SignatureSpi;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

/* loaded from: classes3.dex */
public final class OpenSSLSignatureRawRSA extends SignatureSpi {
    private byte[] inputBuffer;
    private boolean inputIsTooLong;
    private int inputOffset;
    private OpenSSLKey key;

    @Override // java.security.SignatureSpi
    protected Object engineGetParameter(String str) {
        return null;
    }

    @Override // java.security.SignatureSpi
    protected void engineInitSign(PrivateKey privateKey) {
        if (privateKey instanceof OpenSSLRSAPrivateKey) {
            this.key = ((OpenSSLRSAPrivateKey) privateKey).getOpenSSLKey();
        } else if (privateKey instanceof RSAPrivateCrtKey) {
            this.key = OpenSSLRSAPrivateCrtKey.getInstance((RSAPrivateCrtKey) privateKey);
        } else {
            if (!(privateKey instanceof RSAPrivateKey)) {
                throw new InvalidKeyException("Need RSA private key");
            }
            this.key = OpenSSLRSAPrivateKey.getInstance((RSAPrivateKey) privateKey);
        }
        this.inputBuffer = new byte[NativeCrypto.RSA_size(this.key.getNativeRef())];
        this.inputOffset = 0;
    }

    @Override // java.security.SignatureSpi
    protected void engineInitVerify(PublicKey publicKey) {
        if (publicKey instanceof OpenSSLRSAPublicKey) {
            this.key = ((OpenSSLRSAPublicKey) publicKey).getOpenSSLKey();
        } else {
            if (!(publicKey instanceof RSAPublicKey)) {
                throw new InvalidKeyException("Need RSA public key");
            }
            this.key = OpenSSLRSAPublicKey.getInstance((RSAPublicKey) publicKey);
        }
        this.inputBuffer = new byte[NativeCrypto.RSA_size(this.key.getNativeRef())];
        this.inputOffset = 0;
    }

    @Override // java.security.SignatureSpi
    protected void engineSetParameter(String str, Object obj) {
    }

    @Override // java.security.SignatureSpi
    protected byte[] engineSign() {
        OpenSSLKey openSSLKey = this.key;
        if (openSSLKey == null) {
            throw new SignatureException("Need RSA private key");
        }
        if (this.inputIsTooLong) {
            throw new SignatureException("input length " + this.inputOffset + " != " + this.inputBuffer.length + " (modulus size)");
        }
        byte[] bArr = this.inputBuffer;
        byte[] bArr2 = new byte[bArr.length];
        try {
            try {
                NativeCrypto.RSA_private_encrypt(this.inputOffset, bArr, bArr2, openSSLKey.getNativeRef(), 1);
                return bArr2;
            } catch (Exception e5) {
                throw new SignatureException(e5);
            }
        } finally {
            this.inputOffset = 0;
        }
    }

    @Override // java.security.SignatureSpi
    protected void engineUpdate(byte b5) {
        int i5 = this.inputOffset;
        int i6 = i5 + 1;
        this.inputOffset = i6;
        byte[] bArr = this.inputBuffer;
        if (i6 > bArr.length) {
            this.inputIsTooLong = true;
        } else {
            bArr[i5] = b5;
        }
    }

    @Override // java.security.SignatureSpi
    protected boolean engineVerify(byte[] bArr) {
        OpenSSLKey openSSLKey = this.key;
        if (openSSLKey == null) {
            throw new SignatureException("Need RSA public key");
        }
        if (this.inputIsTooLong) {
            return false;
        }
        int length = bArr.length;
        byte[] bArr2 = this.inputBuffer;
        if (length > bArr2.length) {
            throw new SignatureException("Input signature length is too large: " + bArr.length + " > " + this.inputBuffer.length);
        }
        byte[] bArr3 = new byte[bArr2.length];
        try {
            try {
                try {
                    boolean z5 = true;
                    int RSA_public_decrypt = NativeCrypto.RSA_public_decrypt(bArr.length, bArr, bArr3, openSSLKey.getNativeRef(), 1);
                    if (RSA_public_decrypt != this.inputOffset) {
                        z5 = false;
                    }
                    for (int i5 = 0; i5 < RSA_public_decrypt; i5++) {
                        if (this.inputBuffer[i5] != bArr3[i5]) {
                            z5 = false;
                        }
                    }
                    return z5;
                } finally {
                    this.inputOffset = 0;
                }
            } catch (SignatureException e5) {
                throw e5;
            } catch (Exception unused) {
                return false;
            }
        } catch (Exception e6) {
            throw new SignatureException(e6);
        }
    }

    @Override // java.security.SignatureSpi
    protected void engineUpdate(byte[] bArr, int i5, int i6) {
        int i7 = this.inputOffset;
        int i8 = i7 + i6;
        this.inputOffset = i8;
        byte[] bArr2 = this.inputBuffer;
        if (i8 > bArr2.length) {
            this.inputIsTooLong = true;
        } else {
            System.arraycopy(bArr, i5, bArr2, i7, i6);
        }
    }
}
