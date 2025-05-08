package com.ionspin.kotlin.bignum.integer.util;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0010\f\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0001¨\u0006\u0004"}, d2 = {"toDigit", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "base", "bignum"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public abstract class DigitUtilKt {
    public static final int toDigit(char c5, int i5) {
        int i6;
        int i7;
        if ('0' <= c5 && c5 <= '9') {
            i7 = (char) (c5 - '0');
        } else if ('a' <= c5 && c5 <= 'z') {
            i7 = c5 - 87;
        } else if ('A' > c5 || c5 > 'Z') {
            if (65313 <= c5 && c5 <= 65338) {
                i6 = 65323;
            } else {
                if (65345 > c5 || c5 > 65370) {
                    if (c5 != '.') {
                        throw new NumberFormatException(Intrinsics.stringPlus("Invalid digit for radix ", Character.valueOf(c5)));
                    }
                    throw new NumberFormatException("Invalid digit for radix " + c5 + " (Possibly a decimal value, which is not supported by BigInteger parser");
                }
                i6 = 65355;
            }
            i7 = c5 - i6;
        } else {
            i7 = c5 - 55;
        }
        if (i7 >= 0 && i7 < i5) {
            return i7;
        }
        throw new NumberFormatException(c5 + " is not a valid digit for number system with base " + i5);
    }
}
