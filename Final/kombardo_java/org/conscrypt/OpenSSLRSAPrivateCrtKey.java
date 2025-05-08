package org.conscrypt;

import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateCrtKeySpec;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class OpenSSLRSAPrivateCrtKey extends OpenSSLRSAPrivateKey implements RSAPrivateCrtKey {
    private static final long serialVersionUID = 3785291944868707197L;
    private BigInteger crtCoefficient;
    private BigInteger primeExponentP;
    private BigInteger primeExponentQ;
    private BigInteger primeP;
    private BigInteger primeQ;
    private BigInteger publicExponent;

    OpenSSLRSAPrivateCrtKey(OpenSSLKey openSSLKey) {
        super(openSSLKey);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static OpenSSLKey getInstance(RSAPrivateCrtKey rSAPrivateCrtKey) {
        if (rSAPrivateCrtKey.getFormat() == null) {
            return OpenSSLRSAPrivateKey.wrapPlatformKey(rSAPrivateCrtKey);
        }
        BigInteger modulus = rSAPrivateCrtKey.getModulus();
        BigInteger privateExponent = rSAPrivateCrtKey.getPrivateExponent();
        if (modulus == null) {
            throw new InvalidKeyException("modulus == null");
        }
        if (privateExponent == null) {
            throw new InvalidKeyException("privateExponent == null");
        }
        try {
            BigInteger publicExponent = rSAPrivateCrtKey.getPublicExponent();
            BigInteger primeP = rSAPrivateCrtKey.getPrimeP();
            BigInteger primeQ = rSAPrivateCrtKey.getPrimeQ();
            BigInteger primeExponentP = rSAPrivateCrtKey.getPrimeExponentP();
            BigInteger primeExponentQ = rSAPrivateCrtKey.getPrimeExponentQ();
            BigInteger crtCoefficient = rSAPrivateCrtKey.getCrtCoefficient();
            return new OpenSSLKey(NativeCrypto.EVP_PKEY_new_RSA(modulus.toByteArray(), publicExponent == null ? null : publicExponent.toByteArray(), privateExponent.toByteArray(), primeP == null ? null : primeP.toByteArray(), primeQ == null ? null : primeQ.toByteArray(), primeExponentP == null ? null : primeExponentP.toByteArray(), primeExponentQ == null ? null : primeExponentQ.toByteArray(), crtCoefficient != null ? crtCoefficient.toByteArray() : null));
        } catch (Exception e5) {
            throw new InvalidKeyException(e5);
        }
    }

    private static OpenSSLKey init(RSAPrivateCrtKeySpec rSAPrivateCrtKeySpec) {
        BigInteger modulus = rSAPrivateCrtKeySpec.getModulus();
        BigInteger privateExponent = rSAPrivateCrtKeySpec.getPrivateExponent();
        if (modulus == null) {
            throw new InvalidKeySpecException("modulus == null");
        }
        if (privateExponent == null) {
            throw new InvalidKeySpecException("privateExponent == null");
        }
        try {
            BigInteger publicExponent = rSAPrivateCrtKeySpec.getPublicExponent();
            BigInteger primeP = rSAPrivateCrtKeySpec.getPrimeP();
            BigInteger primeQ = rSAPrivateCrtKeySpec.getPrimeQ();
            BigInteger primeExponentP = rSAPrivateCrtKeySpec.getPrimeExponentP();
            BigInteger primeExponentQ = rSAPrivateCrtKeySpec.getPrimeExponentQ();
            BigInteger crtCoefficient = rSAPrivateCrtKeySpec.getCrtCoefficient();
            return new OpenSSLKey(NativeCrypto.EVP_PKEY_new_RSA(modulus.toByteArray(), publicExponent == null ? null : publicExponent.toByteArray(), privateExponent.toByteArray(), primeP == null ? null : primeP.toByteArray(), primeQ == null ? null : primeQ.toByteArray(), primeExponentP == null ? null : primeExponentP.toByteArray(), primeExponentQ == null ? null : primeExponentQ.toByteArray(), crtCoefficient != null ? crtCoefficient.toByteArray() : null));
        } catch (Exception e5) {
            throw new InvalidKeySpecException(e5);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        byte[] byteArray = this.modulus.toByteArray();
        BigInteger bigInteger = this.publicExponent;
        byte[] byteArray2 = bigInteger == null ? null : bigInteger.toByteArray();
        byte[] byteArray3 = this.privateExponent.toByteArray();
        BigInteger bigInteger2 = this.primeP;
        byte[] byteArray4 = bigInteger2 == null ? null : bigInteger2.toByteArray();
        BigInteger bigInteger3 = this.primeQ;
        byte[] byteArray5 = bigInteger3 == null ? null : bigInteger3.toByteArray();
        BigInteger bigInteger4 = this.primeExponentP;
        byte[] byteArray6 = bigInteger4 == null ? null : bigInteger4.toByteArray();
        BigInteger bigInteger5 = this.primeExponentQ;
        byte[] byteArray7 = bigInteger5 == null ? null : bigInteger5.toByteArray();
        BigInteger bigInteger6 = this.crtCoefficient;
        this.key = new OpenSSLKey(NativeCrypto.EVP_PKEY_new_RSA(byteArray, byteArray2, byteArray3, byteArray4, byteArray5, byteArray6, byteArray7, bigInteger6 != null ? bigInteger6.toByteArray() : null));
        this.fetchedParams = true;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        if (getOpenSSLKey().isHardwareBacked()) {
            throw new NotSerializableException("Hardware backed keys cannot be serialized");
        }
        ensureReadParams();
        objectOutputStream.defaultWriteObject();
    }

    @Override // org.conscrypt.OpenSSLRSAPrivateKey
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof OpenSSLRSAPrivateKey) {
            return getOpenSSLKey().equals(((OpenSSLRSAPrivateKey) obj).getOpenSSLKey());
        }
        if (obj instanceof RSAPrivateCrtKey) {
            ensureReadParams();
            RSAPrivateCrtKey rSAPrivateCrtKey = (RSAPrivateCrtKey) obj;
            return getOpenSSLKey().isHardwareBacked() ? getModulus().equals(rSAPrivateCrtKey.getModulus()) && this.publicExponent.equals(rSAPrivateCrtKey.getPublicExponent()) : getModulus().equals(rSAPrivateCrtKey.getModulus()) && this.publicExponent.equals(rSAPrivateCrtKey.getPublicExponent()) && getPrivateExponent().equals(rSAPrivateCrtKey.getPrivateExponent()) && this.primeP.equals(rSAPrivateCrtKey.getPrimeP()) && this.primeQ.equals(rSAPrivateCrtKey.getPrimeQ()) && this.primeExponentP.equals(rSAPrivateCrtKey.getPrimeExponentP()) && this.primeExponentQ.equals(rSAPrivateCrtKey.getPrimeExponentQ()) && this.crtCoefficient.equals(rSAPrivateCrtKey.getCrtCoefficient());
        }
        if (!(obj instanceof RSAPrivateKey)) {
            return false;
        }
        ensureReadParams();
        RSAPrivateKey rSAPrivateKey = (RSAPrivateKey) obj;
        return getOpenSSLKey().isHardwareBacked() ? getModulus().equals(rSAPrivateKey.getModulus()) : getModulus().equals(rSAPrivateKey.getModulus()) && getPrivateExponent().equals(rSAPrivateKey.getPrivateExponent());
    }

    @Override // java.security.interfaces.RSAPrivateCrtKey
    public BigInteger getCrtCoefficient() {
        ensureReadParams();
        return this.crtCoefficient;
    }

    @Override // java.security.interfaces.RSAPrivateCrtKey
    public BigInteger getPrimeExponentP() {
        ensureReadParams();
        return this.primeExponentP;
    }

    @Override // java.security.interfaces.RSAPrivateCrtKey
    public BigInteger getPrimeExponentQ() {
        ensureReadParams();
        return this.primeExponentQ;
    }

    @Override // java.security.interfaces.RSAPrivateCrtKey
    public BigInteger getPrimeP() {
        ensureReadParams();
        return this.primeP;
    }

    @Override // java.security.interfaces.RSAPrivateCrtKey
    public BigInteger getPrimeQ() {
        ensureReadParams();
        return this.primeQ;
    }

    @Override // java.security.interfaces.RSAPrivateCrtKey
    public BigInteger getPublicExponent() {
        ensureReadParams();
        return this.publicExponent;
    }

    @Override // org.conscrypt.OpenSSLRSAPrivateKey
    public final int hashCode() {
        int hashCode = super.hashCode();
        BigInteger bigInteger = this.publicExponent;
        return bigInteger != null ? hashCode ^ bigInteger.hashCode() : hashCode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.conscrypt.OpenSSLRSAPrivateKey
    public synchronized void readParams(byte[][] bArr) {
        try {
            super.readParams(bArr);
            if (bArr[1] != null) {
                this.publicExponent = new BigInteger(bArr[1]);
            }
            if (bArr[3] != null) {
                this.primeP = new BigInteger(bArr[3]);
            }
            if (bArr[4] != null) {
                this.primeQ = new BigInteger(bArr[4]);
            }
            if (bArr[5] != null) {
                this.primeExponentP = new BigInteger(bArr[5]);
            }
            if (bArr[6] != null) {
                this.primeExponentQ = new BigInteger(bArr[6]);
            }
            if (bArr[7] != null) {
                this.crtCoefficient = new BigInteger(bArr[7]);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // org.conscrypt.OpenSSLRSAPrivateKey
    public String toString() {
        StringBuilder sb = new StringBuilder("OpenSSLRSAPrivateCrtKey{");
        ensureReadParams();
        sb.append("modulus=");
        sb.append(getModulus().toString(16));
        if (this.publicExponent != null) {
            sb.append(',');
            sb.append("publicExponent=");
            sb.append(this.publicExponent.toString(16));
        }
        sb.append('}');
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OpenSSLRSAPrivateCrtKey(OpenSSLKey openSSLKey, byte[][] bArr) {
        super(openSSLKey, bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OpenSSLRSAPrivateCrtKey(RSAPrivateCrtKeySpec rSAPrivateCrtKeySpec) {
        super(init(rSAPrivateCrtKeySpec));
    }
}
