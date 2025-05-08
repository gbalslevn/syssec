package com.sdk.growthbook.utils;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H&J \u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H&¨\u0006\t"}, d2 = {"Lcom/sdk/growthbook/utils/Crypto;", BuildConfig.FLAVOR, "decrypt", BuildConfig.FLAVOR, "cipherText", "key", "iv", "encrypt", "inputText", "GrowthBook_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface Crypto {
    byte[] decrypt(byte[] cipherText, byte[] key, byte[] iv);

    byte[] encrypt(byte[] inputText, byte[] key, byte[] iv);
}
