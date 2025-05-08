package com.google.common.primitives;

import com.google.common.base.Preconditions;

/* loaded from: classes2.dex */
public abstract class Ints extends IntsMethodsForWeb {
    public static int constrainToRange(int i5, int i6, int i7) {
        Preconditions.checkArgument(i6 <= i7, "min (%s) must be less than or equal to max (%s)", i6, i7);
        return Math.min(Math.max(i5, i6), i7);
    }

    public static int saturatedCast(long j5) {
        if (j5 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (j5 < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) j5;
    }
}
