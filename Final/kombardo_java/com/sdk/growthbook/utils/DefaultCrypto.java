package com.sdk.growthbook.utils;

import com.soywiz.krypto.AES;
import com.soywiz.krypto.Padding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0016J \u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/sdk/growthbook/utils/DefaultCrypto;", "Lcom/sdk/growthbook/utils/Crypto;", "()V", "padding", "Lcom/soywiz/krypto/Padding;", "decrypt", BuildConfig.FLAVOR, "cipherText", "key", "iv", "encrypt", "inputText", "GrowthBook_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DefaultCrypto implements Crypto {
    private final Padding padding = Padding.PKCS7Padding;

    @Override // com.sdk.growthbook.utils.Crypto
    public byte[] decrypt(byte[] cipherText, byte[] key, byte[] iv) {
        Intrinsics.checkNotNullParameter(cipherText, "cipherText");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(iv, "iv");
        return AES.INSTANCE.decryptAesCbc(cipherText, key, iv, this.padding);
    }

    @Override // com.sdk.growthbook.utils.Crypto
    public byte[] encrypt(byte[] inputText, byte[] key, byte[] iv) {
        Intrinsics.checkNotNullParameter(inputText, "inputText");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(iv, "iv");
        return AES.INSTANCE.encryptAesCbc(inputText, key, iv, this.padding);
    }
}
