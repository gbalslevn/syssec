package org.conscrypt;

import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import org.conscrypt.NativeRef;
import org.conscrypt.OpenSSLX509CertificateFactory;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class OpenSSLKey {
    private final NativeRef.EVP_PKEY ctx;
    private final boolean hardwareBacked;
    private final boolean wrapped;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OpenSSLKey(long j5) {
        this(j5, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static OpenSSLKey fromECPrivateKeyForTLSStackOnly(PrivateKey privateKey, ECParameterSpec eCParameterSpec) {
        OpenSSLKey openSSLKey = getOpenSSLKey(privateKey);
        if (openSSLKey != null) {
            return openSSLKey;
        }
        OpenSSLKey fromKeyMaterial = fromKeyMaterial(privateKey);
        return fromKeyMaterial != null ? fromKeyMaterial : OpenSSLECPrivateKey.wrapJCAPrivateKeyForTLSStackOnly(privateKey, eCParameterSpec);
    }

    private static OpenSSLKey fromKeyMaterial(PrivateKey privateKey) {
        byte[] encoded;
        if (!"PKCS#8".equals(privateKey.getFormat()) || (encoded = privateKey.getEncoded()) == null) {
            return null;
        }
        try {
            return new OpenSSLKey(NativeCrypto.EVP_parse_private_key(encoded));
        } catch (OpenSSLX509CertificateFactory.ParsingException e5) {
            throw new InvalidKeyException(e5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static OpenSSLKey fromPrivateKey(PrivateKey privateKey) {
        if (privateKey instanceof OpenSSLKeyHolder) {
            return ((OpenSSLKeyHolder) privateKey).getOpenSSLKey();
        }
        String format = privateKey.getFormat();
        if (format == null) {
            return wrapPrivateKey(privateKey);
        }
        if (!"PKCS#8".equals(privateKey.getFormat())) {
            throw new InvalidKeyException("Unknown key format " + format);
        }
        if (privateKey.getEncoded() == null) {
            throw new InvalidKeyException("Key encoding is null");
        }
        try {
            return new OpenSSLKey(NativeCrypto.EVP_parse_private_key(privateKey.getEncoded()));
        } catch (OpenSSLX509CertificateFactory.ParsingException e5) {
            throw new InvalidKeyException(e5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static OpenSSLKey fromPrivateKeyForTLSStackOnly(PrivateKey privateKey, PublicKey publicKey) {
        OpenSSLKey openSSLKey = getOpenSSLKey(privateKey);
        if (openSSLKey != null) {
            return openSSLKey;
        }
        OpenSSLKey fromKeyMaterial = fromKeyMaterial(privateKey);
        return fromKeyMaterial != null ? fromKeyMaterial : wrapJCAPrivateKeyForTLSStackOnly(privateKey, publicKey);
    }

    static OpenSSLKey fromPrivateKeyPemInputStream(InputStream inputStream) {
        OpenSSLBIOInputStream openSSLBIOInputStream = new OpenSSLBIOInputStream(inputStream, true);
        try {
            try {
                long PEM_read_bio_PrivateKey = NativeCrypto.PEM_read_bio_PrivateKey(openSSLBIOInputStream.getBioContext());
                if (PEM_read_bio_PrivateKey != 0) {
                    return new OpenSSLKey(PEM_read_bio_PrivateKey);
                }
                openSSLBIOInputStream.release();
                return null;
            } catch (Exception e5) {
                throw new InvalidKeyException(e5);
            }
        } finally {
            openSSLBIOInputStream.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static OpenSSLKey fromPublicKey(PublicKey publicKey) {
        if (publicKey instanceof OpenSSLKeyHolder) {
            return ((OpenSSLKeyHolder) publicKey).getOpenSSLKey();
        }
        if (!"X.509".equals(publicKey.getFormat())) {
            throw new InvalidKeyException("Unknown key format " + publicKey.getFormat());
        }
        if (publicKey.getEncoded() == null) {
            throw new InvalidKeyException("Key encoding is null");
        }
        try {
            return new OpenSSLKey(NativeCrypto.EVP_parse_public_key(publicKey.getEncoded()));
        } catch (Exception e5) {
            throw new InvalidKeyException(e5);
        }
    }

    static OpenSSLKey fromPublicKeyPemInputStream(InputStream inputStream) {
        OpenSSLBIOInputStream openSSLBIOInputStream = new OpenSSLBIOInputStream(inputStream, true);
        try {
            try {
                long PEM_read_bio_PUBKEY = NativeCrypto.PEM_read_bio_PUBKEY(openSSLBIOInputStream.getBioContext());
                if (PEM_read_bio_PUBKEY != 0) {
                    return new OpenSSLKey(PEM_read_bio_PUBKEY);
                }
                openSSLBIOInputStream.release();
                return null;
            } catch (Exception e5) {
                throw new InvalidKeyException(e5);
            }
        } finally {
            openSSLBIOInputStream.release();
        }
    }

    private static OpenSSLKey getOpenSSLKey(PrivateKey privateKey) {
        if (privateKey instanceof OpenSSLKeyHolder) {
            return ((OpenSSLKeyHolder) privateKey).getOpenSSLKey();
        }
        if ("RSA".equals(privateKey.getAlgorithm())) {
            return Platform.wrapRsaKey(privateKey);
        }
        return null;
    }

    private static OpenSSLKey wrapJCAPrivateKeyForTLSStackOnly(PrivateKey privateKey, PublicKey publicKey) {
        String algorithm = privateKey.getAlgorithm();
        if ("RSA".equals(algorithm)) {
            return OpenSSLRSAPrivateKey.wrapJCAPrivateKeyForTLSStackOnly(privateKey, publicKey);
        }
        if ("EC".equals(algorithm)) {
            return OpenSSLECPrivateKey.wrapJCAPrivateKeyForTLSStackOnly(privateKey, publicKey);
        }
        throw new InvalidKeyException("Unsupported key algorithm: " + algorithm);
    }

    private static OpenSSLKey wrapPrivateKey(PrivateKey privateKey) {
        if (privateKey instanceof RSAPrivateKey) {
            return OpenSSLRSAPrivateKey.wrapPlatformKey((RSAPrivateKey) privateKey);
        }
        if (privateKey instanceof ECPrivateKey) {
            return OpenSSLECPrivateKey.wrapPlatformKey((ECPrivateKey) privateKey);
        }
        throw new InvalidKeyException("Unknown key type: " + privateKey.toString());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OpenSSLKey)) {
            return false;
        }
        OpenSSLKey openSSLKey = (OpenSSLKey) obj;
        return this.ctx.equals(openSSLKey.getNativeRef()) || NativeCrypto.EVP_PKEY_cmp(this.ctx, openSSLKey.getNativeRef()) == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public NativeRef.EVP_PKEY getNativeRef() {
        return this.ctx;
    }

    PrivateKey getPrivateKey() {
        int EVP_PKEY_type = NativeCrypto.EVP_PKEY_type(this.ctx);
        if (EVP_PKEY_type == 6) {
            return new OpenSSLRSAPrivateKey(this);
        }
        if (EVP_PKEY_type == 408) {
            return new OpenSSLECPrivateKey(this);
        }
        throw new NoSuchAlgorithmException("unknown PKEY type");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PublicKey getPublicKey() {
        int EVP_PKEY_type = NativeCrypto.EVP_PKEY_type(this.ctx);
        if (EVP_PKEY_type == 6) {
            return new OpenSSLRSAPublicKey(this);
        }
        if (EVP_PKEY_type == 408) {
            return new OpenSSLECPublicKey(this);
        }
        throw new NoSuchAlgorithmException("unknown PKEY type");
    }

    public int hashCode() {
        return this.ctx.hashCode();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isHardwareBacked() {
        return this.hardwareBacked;
    }

    boolean isWrapped() {
        return this.wrapped;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OpenSSLKey(long j5, boolean z5) {
        this(j5, z5, false);
    }

    OpenSSLKey(long j5, boolean z5, boolean z6) {
        this.ctx = new NativeRef.EVP_PKEY(j5);
        this.wrapped = z5;
        this.hardwareBacked = z6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PrivateKey getPrivateKey(PKCS8EncodedKeySpec pKCS8EncodedKeySpec, int i5) {
        try {
            OpenSSLKey openSSLKey = new OpenSSLKey(NativeCrypto.EVP_parse_private_key(pKCS8EncodedKeySpec.getEncoded()));
            if (NativeCrypto.EVP_PKEY_type(openSSLKey.getNativeRef()) == i5) {
                try {
                    return openSSLKey.getPrivateKey();
                } catch (NoSuchAlgorithmException e5) {
                    throw new InvalidKeySpecException(e5);
                }
            }
            throw new InvalidKeySpecException("Unexpected key type");
        } catch (Exception e6) {
            throw new InvalidKeySpecException(e6);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PublicKey getPublicKey(X509EncodedKeySpec x509EncodedKeySpec, int i5) {
        try {
            OpenSSLKey openSSLKey = new OpenSSLKey(NativeCrypto.EVP_parse_public_key(x509EncodedKeySpec.getEncoded()));
            if (NativeCrypto.EVP_PKEY_type(openSSLKey.getNativeRef()) == i5) {
                try {
                    return openSSLKey.getPublicKey();
                } catch (NoSuchAlgorithmException e5) {
                    throw new InvalidKeySpecException(e5);
                }
            }
            throw new InvalidKeySpecException("Unexpected key type");
        } catch (Exception e6) {
            throw new InvalidKeySpecException(e6);
        }
    }
}
