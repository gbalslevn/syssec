package com.ionspin.kotlin.bignum.integer;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0004\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/ionspin/kotlin/bignum/integer/ComparisonWorkaround;", BuildConfig.FLAVOR, "()V", "isSpecialHandlingForFloatNeeded", BuildConfig.FLAVOR, "number", BuildConfig.FLAVOR, "bignum"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class ComparisonWorkaround {
    public static final ComparisonWorkaround INSTANCE = new ComparisonWorkaround();

    private ComparisonWorkaround() {
    }

    public final boolean isSpecialHandlingForFloatNeeded(Number number) {
        Intrinsics.checkNotNullParameter(number, "number");
        return false;
    }
}
