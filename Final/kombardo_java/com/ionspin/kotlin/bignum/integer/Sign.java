package com.ionspin.kotlin.bignum.integer;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\u0004\u0010\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/ionspin/kotlin/bignum/integer/Sign;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "not", "()Lcom/ionspin/kotlin/bignum/integer/Sign;", "POSITIVE", "NEGATIVE", "ZERO", "bignum"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public enum Sign {
    POSITIVE,
    NEGATIVE,
    ZERO;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Sign.values().length];
            iArr[Sign.POSITIVE.ordinal()] = 1;
            iArr[Sign.NEGATIVE.ordinal()] = 2;
            iArr[Sign.ZERO.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final Sign not() {
        int i5 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i5 == 1) {
            return NEGATIVE;
        }
        if (i5 == 2) {
            return POSITIVE;
        }
        if (i5 == 3) {
            return ZERO;
        }
        throw new NoWhenBranchMatchedException();
    }
}
