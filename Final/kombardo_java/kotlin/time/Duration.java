package kotlin.time;

import com.adjust.sdk.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b'\b\u0087@\u0018\u0000 ]2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001]B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0010\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0012\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0011\u0010\u000fJ\u0010\u0010\u0014\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\u0013\u0010\u0005J\u0018\u0010\u0017\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001e\u001a\u00020\u000b¢\u0006\u0004\b\u001d\u0010\u000fJ\r\u0010 \u001a\u00020\u000b¢\u0006\u0004\b\u001f\u0010\u000fJ\r\u0010\"\u001a\u00020\u000b¢\u0006\u0004\b!\u0010\u000fJ\r\u0010$\u001a\u00020\u000b¢\u0006\u0004\b#\u0010\u000fJ\u0018\u0010'\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\b%\u0010&J\u0015\u0010,\u001a\u00020\u00022\u0006\u0010)\u001a\u00020(¢\u0006\u0004\b*\u0010+J\u000f\u00100\u001a\u00020-H\u0016¢\u0006\u0004\b.\u0010/J?\u0010:\u001a\u000207*\u000601j\u0002`22\u0006\u00103\u001a\u00020\u00062\u0006\u00104\u001a\u00020\u00062\u0006\u00105\u001a\u00020\u00062\u0006\u0010)\u001a\u00020-2\u0006\u00106\u001a\u00020\u000bH\u0002¢\u0006\u0004\b8\u00109J\r\u0010<\u001a\u00020-¢\u0006\u0004\b;\u0010/R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010=R\u0014\u0010?\u001a\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b>\u0010\u0005R\u0014\u0010B\u001a\u00020(8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b@\u0010AR\u0011\u0010D\u001a\u00020\u00008F¢\u0006\u0006\u001a\u0004\bC\u0010\u0005R\u001a\u0010I\u001a\u00020\u00068@X\u0081\u0004¢\u0006\f\u0012\u0004\bG\u0010H\u001a\u0004\bE\u0010FR\u001a\u0010L\u001a\u00020\u00068@X\u0081\u0004¢\u0006\f\u0012\u0004\bK\u0010H\u001a\u0004\bJ\u0010FR\u001a\u0010O\u001a\u00020\u00068@X\u0081\u0004¢\u0006\f\u0012\u0004\bN\u0010H\u001a\u0004\bM\u0010FR\u001a\u0010R\u001a\u00020\u00068@X\u0081\u0004¢\u0006\f\u0012\u0004\bQ\u0010H\u001a\u0004\bP\u0010FR\u0011\u0010T\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\bS\u0010\u0005R\u0011\u0010V\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\bU\u0010\u0005R\u0011\u0010X\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\bW\u0010\u0005R\u0011\u0010Z\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\bY\u0010\u0005R\u0011\u0010\\\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b[\u0010\u0005\u0088\u0001\u0003\u0092\u0001\u00020\u0002¨\u0006^"}, d2 = {"Lkotlin/time/Duration;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "rawValue", "constructor-impl", "(J)J", BuildConfig.FLAVOR, "hashCode", "()I", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "isInNanos-impl", "(J)Z", "isInNanos", "isInMillis-impl", "isInMillis", "unaryMinus-UwyO8pc", "unaryMinus", "plus-LRDsOJo", "(JJ)J", "plus", "thisMillis", "otherNanos", "addValuesMixedRanges-UwyO8pc", "(JJJ)J", "addValuesMixedRanges", "isNegative-impl", "isNegative", "isPositive-impl", "isPositive", "isInfinite-impl", "isInfinite", "isFinite-impl", "isFinite", "compareTo-LRDsOJo", "(JJ)I", "compareTo", "Lkotlin/time/DurationUnit;", "unit", "toLong-impl", "(JLkotlin/time/DurationUnit;)J", "toLong", BuildConfig.FLAVOR, "toString-impl", "(J)Ljava/lang/String;", "toString", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "whole", "fractional", "fractionalSize", "isoZeroes", BuildConfig.FLAVOR, "appendFractional-impl", "(JLjava/lang/StringBuilder;IIILjava/lang/String;Z)V", "appendFractional", "toIsoString-impl", "toIsoString", "J", "getValue-impl", "value", "getStorageUnit-impl", "(J)Lkotlin/time/DurationUnit;", "storageUnit", "getAbsoluteValue-UwyO8pc", "absoluteValue", "getHoursComponent-impl", "(J)I", "getHoursComponent$annotations", "()V", "hoursComponent", "getMinutesComponent-impl", "getMinutesComponent$annotations", "minutesComponent", "getSecondsComponent-impl", "getSecondsComponent$annotations", "secondsComponent", "getNanosecondsComponent-impl", "getNanosecondsComponent$annotations", "nanosecondsComponent", "getInWholeDays-impl", "inWholeDays", "getInWholeHours-impl", "inWholeHours", "getInWholeMinutes-impl", "inWholeMinutes", "getInWholeSeconds-impl", "inWholeSeconds", "getInWholeMilliseconds-impl", "inWholeMilliseconds", "Companion", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Duration implements Comparable<Duration> {
    private static final long INFINITE;
    private static final long NEG_INFINITE;
    private final long rawValue;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long ZERO = m3729constructorimpl(0);

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\n\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\r¨\u0006\u0010"}, d2 = {"Lkotlin/time/Duration$Companion;", BuildConfig.FLAVOR, "<init>", "()V", BuildConfig.FLAVOR, "value", "Lkotlin/time/Duration;", "parseIsoString-UwyO8pc", "(Ljava/lang/String;)J", "parseIsoString", "ZERO", "J", "getZERO-UwyO8pc", "()J", "INFINITE", "getINFINITE-UwyO8pc", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getINFINITE-UwyO8pc, reason: not valid java name */
        public final long m3757getINFINITEUwyO8pc() {
            return Duration.INFINITE;
        }

        /* renamed from: getZERO-UwyO8pc, reason: not valid java name */
        public final long m3758getZEROUwyO8pc() {
            return Duration.ZERO;
        }

        /* renamed from: parseIsoString-UwyO8pc, reason: not valid java name */
        public final long m3759parseIsoStringUwyO8pc(String value) {
            long parseDuration;
            Intrinsics.checkNotNullParameter(value, "value");
            try {
                parseDuration = DurationKt.parseDuration(value, true);
                return parseDuration;
            } catch (IllegalArgumentException e5) {
                throw new IllegalArgumentException("Invalid ISO duration string format: '" + value + "'.", e5);
            }
        }

        private Companion() {
        }
    }

    static {
        long durationOfMillis;
        long durationOfMillis2;
        durationOfMillis = DurationKt.durationOfMillis(4611686018427387903L);
        INFINITE = durationOfMillis;
        durationOfMillis2 = DurationKt.durationOfMillis(-4611686018427387903L);
        NEG_INFINITE = durationOfMillis2;
    }

    private /* synthetic */ Duration(long j5) {
        this.rawValue = j5;
    }

    /* renamed from: addValuesMixedRanges-UwyO8pc, reason: not valid java name */
    private static final long m3725addValuesMixedRangesUwyO8pc(long j5, long j6, long j7) {
        long nanosToMillis;
        long durationOfMillis;
        long millisToNanos;
        long millisToNanos2;
        long durationOfNanos;
        nanosToMillis = DurationKt.nanosToMillis(j7);
        long j8 = j6 + nanosToMillis;
        if (-4611686018426L > j8 || j8 >= 4611686018427L) {
            durationOfMillis = DurationKt.durationOfMillis(RangesKt.coerceIn(j8, -4611686018427387903L, 4611686018427387903L));
            return durationOfMillis;
        }
        millisToNanos = DurationKt.millisToNanos(nanosToMillis);
        long j9 = j7 - millisToNanos;
        millisToNanos2 = DurationKt.millisToNanos(j8);
        durationOfNanos = DurationKt.durationOfNanos(millisToNanos2 + j9);
        return durationOfNanos;
    }

    /* renamed from: appendFractional-impl, reason: not valid java name */
    private static final void m3726appendFractionalimpl(long j5, StringBuilder sb, int i5, int i6, int i7, String str, boolean z5) {
        sb.append(i5);
        if (i6 != 0) {
            sb.append('.');
            String padStart = StringsKt.padStart(String.valueOf(i6), i7, '0');
            int i8 = -1;
            int length = padStart.length() - 1;
            if (length >= 0) {
                while (true) {
                    int i9 = length - 1;
                    if (padStart.charAt(length) != '0') {
                        i8 = length;
                        break;
                    } else if (i9 < 0) {
                        break;
                    } else {
                        length = i9;
                    }
                }
            }
            int i10 = i8 + 1;
            if (z5 || i10 >= 3) {
                sb.append((CharSequence) padStart, 0, ((i8 + 3) / 3) * 3);
                Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
            } else {
                sb.append((CharSequence) padStart, 0, i10);
                Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
            }
        }
        sb.append(str);
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Duration m3727boximpl(long j5) {
        return new Duration(j5);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m3729constructorimpl(long j5) {
        if (DurationJvmKt.getDurationAssertionsEnabled()) {
            if (m3746isInNanosimpl(j5)) {
                long m3742getValueimpl = m3742getValueimpl(j5);
                if (-4611686018426999999L > m3742getValueimpl || m3742getValueimpl >= 4611686018427000000L) {
                    throw new AssertionError(m3742getValueimpl(j5) + " ns is out of nanoseconds range");
                }
            } else {
                long m3742getValueimpl2 = m3742getValueimpl(j5);
                if (-4611686018427387903L > m3742getValueimpl2 || m3742getValueimpl2 >= 4611686018427387904L) {
                    throw new AssertionError(m3742getValueimpl(j5) + " ms is out of milliseconds range");
                }
                long m3742getValueimpl3 = m3742getValueimpl(j5);
                if (-4611686018426L <= m3742getValueimpl3 && m3742getValueimpl3 < 4611686018427L) {
                    throw new AssertionError(m3742getValueimpl(j5) + " ms is denormalized");
                }
            }
        }
        return j5;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m3730equalsimpl(long j5, Object obj) {
        return (obj instanceof Duration) && j5 == ((Duration) obj).getRawValue();
    }

    /* renamed from: getAbsoluteValue-UwyO8pc, reason: not valid java name */
    public static final long m3731getAbsoluteValueUwyO8pc(long j5) {
        return m3748isNegativeimpl(j5) ? m3754unaryMinusUwyO8pc(j5) : j5;
    }

    /* renamed from: getHoursComponent-impl, reason: not valid java name */
    public static final int m3732getHoursComponentimpl(long j5) {
        if (m3747isInfiniteimpl(j5)) {
            return 0;
        }
        return (int) (m3734getInWholeHoursimpl(j5) % 24);
    }

    /* renamed from: getInWholeDays-impl, reason: not valid java name */
    public static final long m3733getInWholeDaysimpl(long j5) {
        return m3752toLongimpl(j5, DurationUnit.DAYS);
    }

    /* renamed from: getInWholeHours-impl, reason: not valid java name */
    public static final long m3734getInWholeHoursimpl(long j5) {
        return m3752toLongimpl(j5, DurationUnit.HOURS);
    }

    /* renamed from: getInWholeMilliseconds-impl, reason: not valid java name */
    public static final long m3735getInWholeMillisecondsimpl(long j5) {
        return (m3745isInMillisimpl(j5) && m3744isFiniteimpl(j5)) ? m3742getValueimpl(j5) : m3752toLongimpl(j5, DurationUnit.MILLISECONDS);
    }

    /* renamed from: getInWholeMinutes-impl, reason: not valid java name */
    public static final long m3736getInWholeMinutesimpl(long j5) {
        return m3752toLongimpl(j5, DurationUnit.MINUTES);
    }

    /* renamed from: getInWholeSeconds-impl, reason: not valid java name */
    public static final long m3737getInWholeSecondsimpl(long j5) {
        return m3752toLongimpl(j5, DurationUnit.SECONDS);
    }

    /* renamed from: getMinutesComponent-impl, reason: not valid java name */
    public static final int m3738getMinutesComponentimpl(long j5) {
        if (m3747isInfiniteimpl(j5)) {
            return 0;
        }
        return (int) (m3736getInWholeMinutesimpl(j5) % 60);
    }

    /* renamed from: getNanosecondsComponent-impl, reason: not valid java name */
    public static final int m3739getNanosecondsComponentimpl(long j5) {
        if (m3747isInfiniteimpl(j5)) {
            return 0;
        }
        return (int) (m3745isInMillisimpl(j5) ? DurationKt.millisToNanos(m3742getValueimpl(j5) % Constants.ONE_SECOND) : m3742getValueimpl(j5) % 1000000000);
    }

    /* renamed from: getSecondsComponent-impl, reason: not valid java name */
    public static final int m3740getSecondsComponentimpl(long j5) {
        if (m3747isInfiniteimpl(j5)) {
            return 0;
        }
        return (int) (m3737getInWholeSecondsimpl(j5) % 60);
    }

    /* renamed from: getStorageUnit-impl, reason: not valid java name */
    private static final DurationUnit m3741getStorageUnitimpl(long j5) {
        return m3746isInNanosimpl(j5) ? DurationUnit.NANOSECONDS : DurationUnit.MILLISECONDS;
    }

    /* renamed from: getValue-impl, reason: not valid java name */
    private static final long m3742getValueimpl(long j5) {
        return j5 >> 1;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m3743hashCodeimpl(long j5) {
        return Long.hashCode(j5);
    }

    /* renamed from: isFinite-impl, reason: not valid java name */
    public static final boolean m3744isFiniteimpl(long j5) {
        return !m3747isInfiniteimpl(j5);
    }

    /* renamed from: isInMillis-impl, reason: not valid java name */
    private static final boolean m3745isInMillisimpl(long j5) {
        return (((int) j5) & 1) == 1;
    }

    /* renamed from: isInNanos-impl, reason: not valid java name */
    private static final boolean m3746isInNanosimpl(long j5) {
        return (((int) j5) & 1) == 0;
    }

    /* renamed from: isInfinite-impl, reason: not valid java name */
    public static final boolean m3747isInfiniteimpl(long j5) {
        return j5 == INFINITE || j5 == NEG_INFINITE;
    }

    /* renamed from: isNegative-impl, reason: not valid java name */
    public static final boolean m3748isNegativeimpl(long j5) {
        return j5 < 0;
    }

    /* renamed from: isPositive-impl, reason: not valid java name */
    public static final boolean m3749isPositiveimpl(long j5) {
        return j5 > 0;
    }

    /* renamed from: plus-LRDsOJo, reason: not valid java name */
    public static final long m3750plusLRDsOJo(long j5, long j6) {
        long durationOfMillisNormalized;
        long durationOfNanosNormalized;
        if (m3747isInfiniteimpl(j5)) {
            if (m3744isFiniteimpl(j6) || (j6 ^ j5) >= 0) {
                return j5;
            }
            throw new IllegalArgumentException("Summing infinite durations of different signs yields an undefined result.");
        }
        if (m3747isInfiniteimpl(j6)) {
            return j6;
        }
        if ((((int) j5) & 1) != (((int) j6) & 1)) {
            return m3745isInMillisimpl(j5) ? m3725addValuesMixedRangesUwyO8pc(j5, m3742getValueimpl(j5), m3742getValueimpl(j6)) : m3725addValuesMixedRangesUwyO8pc(j5, m3742getValueimpl(j6), m3742getValueimpl(j5));
        }
        long m3742getValueimpl = m3742getValueimpl(j5) + m3742getValueimpl(j6);
        if (m3746isInNanosimpl(j5)) {
            durationOfNanosNormalized = DurationKt.durationOfNanosNormalized(m3742getValueimpl);
            return durationOfNanosNormalized;
        }
        durationOfMillisNormalized = DurationKt.durationOfMillisNormalized(m3742getValueimpl);
        return durationOfMillisNormalized;
    }

    /* renamed from: toIsoString-impl, reason: not valid java name */
    public static final String m3751toIsoStringimpl(long j5) {
        StringBuilder sb = new StringBuilder();
        if (m3748isNegativeimpl(j5)) {
            sb.append('-');
        }
        sb.append("PT");
        long m3731getAbsoluteValueUwyO8pc = m3731getAbsoluteValueUwyO8pc(j5);
        long m3734getInWholeHoursimpl = m3734getInWholeHoursimpl(m3731getAbsoluteValueUwyO8pc);
        int m3738getMinutesComponentimpl = m3738getMinutesComponentimpl(m3731getAbsoluteValueUwyO8pc);
        int m3740getSecondsComponentimpl = m3740getSecondsComponentimpl(m3731getAbsoluteValueUwyO8pc);
        int m3739getNanosecondsComponentimpl = m3739getNanosecondsComponentimpl(m3731getAbsoluteValueUwyO8pc);
        if (m3747isInfiniteimpl(j5)) {
            m3734getInWholeHoursimpl = 9999999999999L;
        }
        boolean z5 = false;
        boolean z6 = m3734getInWholeHoursimpl != 0;
        boolean z7 = (m3740getSecondsComponentimpl == 0 && m3739getNanosecondsComponentimpl == 0) ? false : true;
        if (m3738getMinutesComponentimpl != 0 || (z7 && z6)) {
            z5 = true;
        }
        if (z6) {
            sb.append(m3734getInWholeHoursimpl);
            sb.append('H');
        }
        if (z5) {
            sb.append(m3738getMinutesComponentimpl);
            sb.append('M');
        }
        if (z7 || (!z6 && !z5)) {
            m3726appendFractionalimpl(j5, sb, m3740getSecondsComponentimpl, m3739getNanosecondsComponentimpl, 9, "S", true);
        }
        return sb.toString();
    }

    /* renamed from: toLong-impl, reason: not valid java name */
    public static final long m3752toLongimpl(long j5, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (j5 == INFINITE) {
            return Long.MAX_VALUE;
        }
        if (j5 == NEG_INFINITE) {
            return Long.MIN_VALUE;
        }
        return DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(m3742getValueimpl(j5), m3741getStorageUnitimpl(j5), unit);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m3753toStringimpl(long j5) {
        if (j5 == 0) {
            return "0s";
        }
        if (j5 == INFINITE) {
            return "Infinity";
        }
        if (j5 == NEG_INFINITE) {
            return "-Infinity";
        }
        boolean m3748isNegativeimpl = m3748isNegativeimpl(j5);
        StringBuilder sb = new StringBuilder();
        if (m3748isNegativeimpl) {
            sb.append('-');
        }
        long m3731getAbsoluteValueUwyO8pc = m3731getAbsoluteValueUwyO8pc(j5);
        long m3733getInWholeDaysimpl = m3733getInWholeDaysimpl(m3731getAbsoluteValueUwyO8pc);
        int m3732getHoursComponentimpl = m3732getHoursComponentimpl(m3731getAbsoluteValueUwyO8pc);
        int m3738getMinutesComponentimpl = m3738getMinutesComponentimpl(m3731getAbsoluteValueUwyO8pc);
        int m3740getSecondsComponentimpl = m3740getSecondsComponentimpl(m3731getAbsoluteValueUwyO8pc);
        int m3739getNanosecondsComponentimpl = m3739getNanosecondsComponentimpl(m3731getAbsoluteValueUwyO8pc);
        int i5 = 0;
        boolean z5 = m3733getInWholeDaysimpl != 0;
        boolean z6 = m3732getHoursComponentimpl != 0;
        boolean z7 = m3738getMinutesComponentimpl != 0;
        boolean z8 = (m3740getSecondsComponentimpl == 0 && m3739getNanosecondsComponentimpl == 0) ? false : true;
        if (z5) {
            sb.append(m3733getInWholeDaysimpl);
            sb.append('d');
            i5 = 1;
        }
        if (z6 || (z5 && (z7 || z8))) {
            int i6 = i5 + 1;
            if (i5 > 0) {
                sb.append(' ');
            }
            sb.append(m3732getHoursComponentimpl);
            sb.append('h');
            i5 = i6;
        }
        if (z7 || (z8 && (z6 || z5))) {
            int i7 = i5 + 1;
            if (i5 > 0) {
                sb.append(' ');
            }
            sb.append(m3738getMinutesComponentimpl);
            sb.append('m');
            i5 = i7;
        }
        if (z8) {
            int i8 = i5 + 1;
            if (i5 > 0) {
                sb.append(' ');
            }
            if (m3740getSecondsComponentimpl != 0 || z5 || z6 || z7) {
                m3726appendFractionalimpl(j5, sb, m3740getSecondsComponentimpl, m3739getNanosecondsComponentimpl, 9, "s", false);
            } else if (m3739getNanosecondsComponentimpl >= 1000000) {
                m3726appendFractionalimpl(j5, sb, m3739getNanosecondsComponentimpl / 1000000, m3739getNanosecondsComponentimpl % 1000000, 6, "ms", false);
            } else if (m3739getNanosecondsComponentimpl >= 1000) {
                m3726appendFractionalimpl(j5, sb, m3739getNanosecondsComponentimpl / Constants.ONE_SECOND, m3739getNanosecondsComponentimpl % Constants.ONE_SECOND, 3, "us", false);
            } else {
                sb.append(m3739getNanosecondsComponentimpl);
                sb.append("ns");
            }
            i5 = i8;
        }
        if (m3748isNegativeimpl && i5 > 1) {
            sb.insert(1, '(').append(')');
        }
        return sb.toString();
    }

    /* renamed from: unaryMinus-UwyO8pc, reason: not valid java name */
    public static final long m3754unaryMinusUwyO8pc(long j5) {
        long durationOf;
        durationOf = DurationKt.durationOf(-m3742getValueimpl(j5), ((int) j5) & 1);
        return durationOf;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Duration duration) {
        return m3755compareToLRDsOJo(duration.getRawValue());
    }

    /* renamed from: compareTo-LRDsOJo, reason: not valid java name */
    public int m3755compareToLRDsOJo(long j5) {
        return m3728compareToLRDsOJo(this.rawValue, j5);
    }

    public boolean equals(Object other) {
        return m3730equalsimpl(this.rawValue, other);
    }

    public int hashCode() {
        return m3743hashCodeimpl(this.rawValue);
    }

    public String toString() {
        return m3753toStringimpl(this.rawValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ long getRawValue() {
        return this.rawValue;
    }

    /* renamed from: compareTo-LRDsOJo, reason: not valid java name */
    public static int m3728compareToLRDsOJo(long j5, long j6) {
        long j7 = j5 ^ j6;
        if (j7 < 0 || (((int) j7) & 1) == 0) {
            return Intrinsics.compare(j5, j6);
        }
        int i5 = (((int) j5) & 1) - (((int) j6) & 1);
        return m3748isNegativeimpl(j5) ? -i5 : i5;
    }
}
