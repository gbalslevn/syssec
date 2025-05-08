package kotlin.time;

import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlin.time.Duration;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000,\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0004\u0010\u0007\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\b2\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0004\u0010\t\u001a\u001f\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0017\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0017\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u0017\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0016\u0010\u0014\u001a\u0017\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0018\u0010\u0014\u001a\u0017\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001a\u0010\u0014\u001a\u001f\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u001d\u0010\u001e\u001a\u0017\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001f\u0010\u0014\u001a\u0017\u0010 \u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0006H\u0002¢\u0006\u0004\b \u0010\u0014\"\u0014\u0010!\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006#"}, d2 = {BuildConfig.FLAVOR, "Lkotlin/time/DurationUnit;", "unit", "Lkotlin/time/Duration;", "toDuration", "(ILkotlin/time/DurationUnit;)J", BuildConfig.FLAVOR, "(JLkotlin/time/DurationUnit;)J", BuildConfig.FLAVOR, "(DLkotlin/time/DurationUnit;)J", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "strictIso", "parseDuration", "(Ljava/lang/String;Z)J", "parseOverLongIsoComponent", "(Ljava/lang/String;)J", "nanos", "nanosToMillis", "(J)J", "millis", "millisToNanos", "normalNanos", "durationOfNanos", "normalMillis", "durationOfMillis", "normalValue", "unitDiscriminator", "durationOf", "(JI)J", "durationOfNanosNormalized", "durationOfMillisNormalized", "MAX_NANOS_IN_MILLIS", "J", "kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class DurationKt {
    private static final long MAX_NANOS_IN_MILLIS = 4611686018426L;

    /* JADX INFO: Access modifiers changed from: private */
    public static final long durationOf(long j5, int i5) {
        return Duration.m3729constructorimpl((j5 << 1) + i5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long durationOfMillis(long j5) {
        return Duration.m3729constructorimpl((j5 << 1) + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long durationOfMillisNormalized(long j5) {
        return (-4611686018426L > j5 || j5 >= 4611686018427L) ? durationOfMillis(RangesKt.coerceIn(j5, -4611686018427387903L, 4611686018427387903L)) : durationOfNanos(millisToNanos(j5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long durationOfNanos(long j5) {
        return Duration.m3729constructorimpl(j5 << 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long durationOfNanosNormalized(long j5) {
        return (-4611686018426999999L > j5 || j5 >= 4611686018427000000L) ? durationOfMillis(nanosToMillis(j5)) : durationOfNanos(j5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long millisToNanos(long j5) {
        return j5 * 1000000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long nanosToMillis(long j5) {
        return j5 / 1000000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long parseDuration(String str, boolean z5) {
        long j5;
        char charAt;
        char charAt2;
        int i5;
        char charAt3;
        int length = str.length();
        if (length == 0) {
            throw new IllegalArgumentException("The string is empty");
        }
        Duration.Companion companion = Duration.INSTANCE;
        long m3758getZEROUwyO8pc = companion.m3758getZEROUwyO8pc();
        char charAt4 = str.charAt(0);
        boolean z6 = true;
        int i6 = (charAt4 == '+' || charAt4 == '-') ? 1 : 0;
        boolean z7 = i6 > 0;
        boolean z8 = z7 && StringsKt.startsWith$default((CharSequence) str, '-', false, 2, (Object) null);
        if (length <= i6) {
            throw new IllegalArgumentException("No components");
        }
        char c5 = ':';
        char c6 = '0';
        if (str.charAt(i6) == 'P') {
            int i7 = i6 + 1;
            if (i7 == length) {
                throw new IllegalArgumentException();
            }
            DurationUnit durationUnit = null;
            boolean z9 = false;
            while (i7 < length) {
                if (str.charAt(i7) != 'T') {
                    int i8 = i7;
                    while (i8 < str.length() && ((c6 <= (charAt3 = str.charAt(i8)) && charAt3 < c5) || StringsKt.contains$default((CharSequence) "+-.", charAt3, false, 2, (Object) null))) {
                        i8++;
                        c5 = ':';
                        c6 = '0';
                    }
                    Intrinsics.checkNotNull(str, "null cannot be cast to non-null type java.lang.String");
                    String substring = str.substring(i7, i8);
                    Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                    if (substring.length() == 0) {
                        throw new IllegalArgumentException();
                    }
                    int length2 = i7 + substring.length();
                    if (length2 < 0 || length2 >= str.length()) {
                        throw new IllegalArgumentException("Missing unit for value " + substring);
                    }
                    char charAt5 = str.charAt(length2);
                    int i9 = length2 + 1;
                    DurationUnit durationUnitByIsoChar = DurationUnitKt__DurationUnitKt.durationUnitByIsoChar(charAt5, z9);
                    if (durationUnit != null && durationUnit.compareTo(durationUnitByIsoChar) <= 0) {
                        throw new IllegalArgumentException("Unexpected order of duration components");
                    }
                    int indexOf$default = StringsKt.indexOf$default((CharSequence) substring, '.', 0, false, 6, (Object) null);
                    if (durationUnitByIsoChar != DurationUnit.SECONDS || indexOf$default <= 0) {
                        i5 = i9;
                        m3758getZEROUwyO8pc = Duration.m3750plusLRDsOJo(m3758getZEROUwyO8pc, toDuration(parseOverLongIsoComponent(substring), durationUnitByIsoChar));
                    } else {
                        Intrinsics.checkNotNull(substring, "null cannot be cast to non-null type java.lang.String");
                        String substring2 = substring.substring(0, indexOf$default);
                        Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
                        i5 = i9;
                        long m3750plusLRDsOJo = Duration.m3750plusLRDsOJo(m3758getZEROUwyO8pc, toDuration(parseOverLongIsoComponent(substring2), durationUnitByIsoChar));
                        Intrinsics.checkNotNull(substring, "null cannot be cast to non-null type java.lang.String");
                        String substring3 = substring.substring(indexOf$default);
                        Intrinsics.checkNotNullExpressionValue(substring3, "substring(...)");
                        m3758getZEROUwyO8pc = Duration.m3750plusLRDsOJo(m3750plusLRDsOJo, toDuration(Double.parseDouble(substring3), durationUnitByIsoChar));
                    }
                    i7 = i5;
                    durationUnit = durationUnitByIsoChar;
                    c5 = ':';
                    c6 = '0';
                    z6 = true;
                } else {
                    if (z9 || (i7 = i7 + 1) == length) {
                        throw new IllegalArgumentException();
                    }
                    z9 = z6;
                }
            }
        } else {
            if (z5) {
                throw new IllegalArgumentException();
            }
            String str2 = "Unexpected order of duration components";
            if (StringsKt.regionMatches(str, i6, "Infinity", 0, Math.max(length - i6, 8), true)) {
                m3758getZEROUwyO8pc = companion.m3757getINFINITEUwyO8pc();
            } else {
                boolean z10 = !z7;
                if (z7 && str.charAt(i6) == '(' && StringsKt.last(str) == ')') {
                    i6++;
                    length--;
                    if (i6 == length) {
                        throw new IllegalArgumentException("No components");
                    }
                    j5 = m3758getZEROUwyO8pc;
                    z10 = true;
                } else {
                    j5 = m3758getZEROUwyO8pc;
                }
                DurationUnit durationUnit2 = null;
                boolean z11 = false;
                while (i6 < length) {
                    if (z11 && z10) {
                        while (i6 < str.length() && str.charAt(i6) == ' ') {
                            i6++;
                        }
                    }
                    int i10 = i6;
                    while (i10 < str.length() && (('0' <= (charAt2 = str.charAt(i10)) && charAt2 < ':') || charAt2 == '.')) {
                        i10++;
                    }
                    Intrinsics.checkNotNull(str, "null cannot be cast to non-null type java.lang.String");
                    String substring4 = str.substring(i6, i10);
                    Intrinsics.checkNotNullExpressionValue(substring4, "substring(...)");
                    if (substring4.length() == 0) {
                        throw new IllegalArgumentException();
                    }
                    int length3 = i6 + substring4.length();
                    int i11 = length3;
                    while (i11 < str.length() && 'a' <= (charAt = str.charAt(i11)) && charAt < '{') {
                        i11++;
                    }
                    Intrinsics.checkNotNull(str, "null cannot be cast to non-null type java.lang.String");
                    String substring5 = str.substring(length3, i11);
                    Intrinsics.checkNotNullExpressionValue(substring5, "substring(...)");
                    i6 = length3 + substring5.length();
                    DurationUnit durationUnitByShortName = DurationUnitKt__DurationUnitKt.durationUnitByShortName(substring5);
                    if (durationUnit2 != null && durationUnit2.compareTo(durationUnitByShortName) <= 0) {
                        throw new IllegalArgumentException(str2);
                    }
                    String str3 = str2;
                    int indexOf$default2 = StringsKt.indexOf$default((CharSequence) substring4, '.', 0, false, 6, (Object) null);
                    if (indexOf$default2 > 0) {
                        Intrinsics.checkNotNull(substring4, "null cannot be cast to non-null type java.lang.String");
                        String substring6 = substring4.substring(0, indexOf$default2);
                        Intrinsics.checkNotNullExpressionValue(substring6, "substring(...)");
                        long m3750plusLRDsOJo2 = Duration.m3750plusLRDsOJo(j5, toDuration(Long.parseLong(substring6), durationUnitByShortName));
                        Intrinsics.checkNotNull(substring4, "null cannot be cast to non-null type java.lang.String");
                        String substring7 = substring4.substring(indexOf$default2);
                        Intrinsics.checkNotNullExpressionValue(substring7, "substring(...)");
                        j5 = Duration.m3750plusLRDsOJo(m3750plusLRDsOJo2, toDuration(Double.parseDouble(substring7), durationUnitByShortName));
                        i6 = i6;
                        if (i6 < length) {
                            throw new IllegalArgumentException("Fractional component must be last");
                        }
                    } else {
                        j5 = Duration.m3750plusLRDsOJo(j5, toDuration(Long.parseLong(substring4), durationUnitByShortName));
                    }
                    str2 = str3;
                    durationUnit2 = durationUnitByShortName;
                    z11 = true;
                }
                m3758getZEROUwyO8pc = j5;
            }
        }
        return z8 ? Duration.m3754unaryMinusUwyO8pc(m3758getZEROUwyO8pc) : m3758getZEROUwyO8pc;
    }

    private static final long parseOverLongIsoComponent(String str) {
        int length = str.length();
        int i5 = (length <= 0 || !StringsKt.contains$default((CharSequence) "+-", str.charAt(0), false, 2, (Object) null)) ? 0 : 1;
        if (length - i5 > 16) {
            Iterable intRange = new IntRange(i5, StringsKt.getLastIndex(str));
            if (!(intRange instanceof Collection) || !((Collection) intRange).isEmpty()) {
                Iterator it = intRange.iterator();
                while (it.hasNext()) {
                    char charAt = str.charAt(((IntIterator) it).nextInt());
                    if ('0' <= charAt && charAt < ':') {
                    }
                }
            }
            return str.charAt(0) == '-' ? Long.MIN_VALUE : Long.MAX_VALUE;
        }
        if (StringsKt.startsWith$default(str, "+", false, 2, (Object) null)) {
            str = StringsKt.drop(str, 1);
        }
        return Long.parseLong(str);
    }

    public static final long toDuration(int i5, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (unit.compareTo(DurationUnit.SECONDS) <= 0) {
            return durationOfNanos(DurationUnitKt__DurationUnitJvmKt.convertDurationUnitOverflow(i5, unit, DurationUnit.NANOSECONDS));
        }
        return toDuration(i5, unit);
    }

    public static final long toDuration(long j5, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        DurationUnit durationUnit = DurationUnit.NANOSECONDS;
        long convertDurationUnitOverflow = DurationUnitKt__DurationUnitJvmKt.convertDurationUnitOverflow(4611686018426999999L, durationUnit, unit);
        if ((-convertDurationUnitOverflow) <= j5 && j5 <= convertDurationUnitOverflow) {
            return durationOfNanos(DurationUnitKt__DurationUnitJvmKt.convertDurationUnitOverflow(j5, unit, durationUnit));
        }
        return durationOfMillis(RangesKt.coerceIn(DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(j5, unit, DurationUnit.MILLISECONDS), -4611686018427387903L, 4611686018427387903L));
    }

    public static final long toDuration(double d5, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        double convertDurationUnit = DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(d5, unit, DurationUnit.NANOSECONDS);
        if (!Double.isNaN(convertDurationUnit)) {
            long roundToLong = MathKt.roundToLong(convertDurationUnit);
            if (-4611686018426999999L <= roundToLong && roundToLong < 4611686018427000000L) {
                return durationOfNanos(roundToLong);
            }
            return durationOfMillisNormalized(MathKt.roundToLong(DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(d5, unit, DurationUnit.MILLISECONDS)));
        }
        throw new IllegalArgumentException("Duration value cannot be NaN.");
    }
}
