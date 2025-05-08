package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0001\n\u0002\b\u0003\u001a\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0007¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001d\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0002\u0010\u0005\u001a\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0006*\u00020\u0000H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a\u001d\u0010\u0007\u001a\u0004\u0018\u00010\u0006*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0007\u0010\t\u001a\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {BuildConfig.FLAVOR, BuildConfig.FLAVOR, "toIntOrNull", "(Ljava/lang/String;)Ljava/lang/Integer;", "radix", "(Ljava/lang/String;I)Ljava/lang/Integer;", BuildConfig.FLAVOR, "toLongOrNull", "(Ljava/lang/String;)Ljava/lang/Long;", "(Ljava/lang/String;I)Ljava/lang/Long;", "input", BuildConfig.FLAVOR, "numberFormatError", "(Ljava/lang/String;)Ljava/lang/Void;", "kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "kotlin/text/StringsKt")
/* loaded from: classes3.dex */
public abstract class StringsKt__StringNumberConversionsKt extends StringsKt__StringNumberConversionsJVMKt {
    public static final Void numberFormatError(String input) {
        Intrinsics.checkNotNullParameter(input, "input");
        throw new NumberFormatException("Invalid number format: '" + input + '\'');
    }

    public static Integer toIntOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return toIntOrNull(str, 10);
    }

    public static Long toLongOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return toLongOrNull(str, 10);
    }

    public static final Integer toIntOrNull(String str, int i5) {
        boolean z5;
        int i6;
        int i7;
        Intrinsics.checkNotNullParameter(str, "<this>");
        CharsKt.checkRadix(i5);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i8 = 0;
        char charAt = str.charAt(0);
        int i9 = -2147483647;
        if (Intrinsics.compare((int) charAt, 48) < 0) {
            i6 = 1;
            if (length == 1) {
                return null;
            }
            if (charAt == '+') {
                z5 = false;
            } else {
                if (charAt != '-') {
                    return null;
                }
                i9 = Integer.MIN_VALUE;
                z5 = true;
            }
        } else {
            z5 = false;
            i6 = 0;
        }
        int i10 = -59652323;
        while (i6 < length) {
            int digitOf = CharsKt__CharJVMKt.digitOf(str.charAt(i6), i5);
            if (digitOf < 0) {
                return null;
            }
            if ((i8 < i10 && (i10 != -59652323 || i8 < (i10 = i9 / i5))) || (i7 = i8 * i5) < i9 + digitOf) {
                return null;
            }
            i8 = i7 - digitOf;
            i6++;
        }
        return z5 ? Integer.valueOf(i8) : Integer.valueOf(-i8);
    }

    public static final Long toLongOrNull(String str, int i5) {
        boolean z5;
        Intrinsics.checkNotNullParameter(str, "<this>");
        CharsKt.checkRadix(i5);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i6 = 0;
        char charAt = str.charAt(0);
        long j5 = -9223372036854775807L;
        if (Intrinsics.compare((int) charAt, 48) < 0) {
            z5 = true;
            if (length == 1) {
                return null;
            }
            if (charAt == '+') {
                z5 = false;
                i6 = 1;
            } else {
                if (charAt != '-') {
                    return null;
                }
                j5 = Long.MIN_VALUE;
                i6 = 1;
            }
        } else {
            z5 = false;
        }
        long j6 = -256204778801521550L;
        long j7 = 0;
        long j8 = -256204778801521550L;
        while (i6 < length) {
            int digitOf = CharsKt__CharJVMKt.digitOf(str.charAt(i6), i5);
            if (digitOf < 0) {
                return null;
            }
            if (j7 < j8) {
                if (j8 == j6) {
                    j8 = j5 / i5;
                    if (j7 < j8) {
                    }
                }
                return null;
            }
            long j9 = j7 * i5;
            long j10 = digitOf;
            if (j9 < j5 + j10) {
                return null;
            }
            j7 = j9 - j10;
            i6++;
            j6 = -256204778801521550L;
        }
        return z5 ? Long.valueOf(j7) : Long.valueOf(-j7);
    }
}
