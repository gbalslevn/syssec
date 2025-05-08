package org.conscrypt;

import java.security.InvalidKeyException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactorySpi;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes3.dex */
public class DESEDESecretKeyFactory extends SecretKeyFactorySpi {
    @Override // javax.crypto.SecretKeyFactorySpi
    protected SecretKey engineGenerateSecret(KeySpec keySpec) {
        if (keySpec == null) {
            throw new InvalidKeySpecException("Null KeySpec");
        }
        if (keySpec instanceof SecretKeySpec) {
            SecretKeySpec secretKeySpec = (SecretKeySpec) keySpec;
            try {
                if (DESedeKeySpec.isParityAdjusted(secretKeySpec.getEncoded(), 0)) {
                    return secretKeySpec;
                }
                throw new InvalidKeySpecException("SecretKeySpec is not a parity-adjusted DESEDE key");
            } catch (InvalidKeyException e5) {
                throw new InvalidKeySpecException(e5);
            }
        }
        if (keySpec instanceof DESedeKeySpec) {
            return new SecretKeySpec(((DESedeKeySpec) keySpec).getKey(), "DESEDE");
        }
        throw new InvalidKeySpecException("Unsupported KeySpec class: " + keySpec.getClass().getName());
    }

    @Override // javax.crypto.SecretKeyFactorySpi
    protected KeySpec engineGetKeySpec(SecretKey secretKey, Class cls) {
        if (secretKey == null) {
            throw new InvalidKeySpecException("Null SecretKey");
        }
        if (cls == SecretKeySpec.class) {
            try {
                if (DESedeKeySpec.isParityAdjusted(secretKey.getEncoded(), 0)) {
                    return secretKey instanceof SecretKeySpec ? (KeySpec) secretKey : new SecretKeySpec(secretKey.getEncoded(), "DESEDE");
                }
                throw new InvalidKeySpecException("SecretKey is not a parity-adjusted DESEDE key");
            } catch (InvalidKeyException e5) {
                throw new InvalidKeySpecException(e5);
            }
        }
        if (cls == DESedeKeySpec.class) {
            try {
                return new DESedeKeySpec(secretKey.getEncoded());
            } catch (InvalidKeyException e6) {
                throw new InvalidKeySpecException(e6);
            }
        }
        throw new InvalidKeySpecException("Unsupported KeySpec class: " + cls);
    }

    @Override // javax.crypto.SecretKeyFactorySpi
    protected SecretKey engineTranslateKey(SecretKey secretKey) {
        if (secretKey != null) {
            return new SecretKeySpec(secretKey.getEncoded(), secretKey.getAlgorithm());
        }
        throw new InvalidKeyException("Null SecretKey");
    }
}
