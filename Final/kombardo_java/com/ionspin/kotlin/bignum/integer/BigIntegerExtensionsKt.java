package com.ionspin.kotlin.bignum.integer;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\f\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {BuildConfig.FLAVOR, "Lcom/ionspin/kotlin/bignum/integer/BigInteger;", "toBigInteger", "(I)Lcom/ionspin/kotlin/bignum/integer/BigInteger;", "bignum"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public abstract class BigIntegerExtensionsKt {
    public static final BigInteger toBigInteger(int i5) {
        return BigInteger.INSTANCE.fromInt(i5);
    }
}
