package com.ionspin.kotlin.bignum.decimal;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a)\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {BuildConfig.FLAVOR, BuildConfig.FLAVOR, "exponentModifier", "Lcom/ionspin/kotlin/bignum/decimal/DecimalMode;", "decimalMode", "Lcom/ionspin/kotlin/bignum/decimal/BigDecimal;", "toBigDecimal", "(FLjava/lang/Long;Lcom/ionspin/kotlin/bignum/decimal/DecimalMode;)Lcom/ionspin/kotlin/bignum/decimal/BigDecimal;", "bignum"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public abstract class BigDecimalExtensionsKt {
    public static final BigDecimal toBigDecimal(float f5, Long l5, DecimalMode decimalMode) {
        return BigDecimal.Companion.fromFloat(f5, decimalMode).moveDecimalPoint(l5 == null ? 0L : l5.longValue());
    }

    public static /* synthetic */ BigDecimal toBigDecimal$default(float f5, Long l5, DecimalMode decimalMode, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            l5 = null;
        }
        if ((i5 & 2) != 0) {
            decimalMode = null;
        }
        return toBigDecimal(f5, l5, decimalMode);
    }
}
