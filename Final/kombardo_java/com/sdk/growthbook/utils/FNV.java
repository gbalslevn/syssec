package com.sdk.growthbook.utils;

import com.ionspin.kotlin.bignum.integer.BigInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/sdk/growthbook/utils/FNV;", BuildConfig.FLAVOR, "()V", "INIT32", "Lcom/ionspin/kotlin/bignum/integer/BigInteger;", "MOD32", "PRIME32", "fnv1a32", "data", BuildConfig.FLAVOR, "GrowthBook_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FNV {
    private final BigInteger INIT32 = new BigInteger(2166136261L);
    private final BigInteger PRIME32 = new BigInteger(16777619);
    private final BigInteger MOD32 = new BigInteger(2).pow(32);

    public final BigInteger fnv1a32(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        BigInteger bigInteger = this.INIT32;
        int length = data.length();
        for (int i5 = 0; i5 < length; i5++) {
            bigInteger = bigInteger.xor(new BigInteger(data.charAt(i5) & 255)).multiply(this.PRIME32).mod(this.MOD32);
        }
        return bigInteger;
    }
}
