package kotlin.ranges;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000,\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0007\u001a\u001c\u0010\u0003\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0086\u0004¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0011\u0010\u0005\u001a\u00020\u0002*\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001c\u0010\u0007\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0000H\u0086\u0004¢\u0006\u0004\b\u0007\u0010\b\u001a\u001c\u0010\n\u001a\u00020\t*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0086\u0004¢\u0006\u0004\b\n\u0010\u000b\u001a\u0019\u0010\r\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\f\u001a\u00020\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a\u0019\u0010\r\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000f¢\u0006\u0004\b\r\u0010\u0010\u001a\u0019\u0010\r\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\f\u001a\u00020\u0011¢\u0006\u0004\b\r\u0010\u0012\u001a\u0019\u0010\u0014\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0000¢\u0006\u0004\b\u0014\u0010\u000e\u001a\u0019\u0010\u0014\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000f¢\u0006\u0004\b\u0014\u0010\u0010\u001a\u0019\u0010\u0014\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011¢\u0006\u0004\b\u0014\u0010\u0012\u001a\u0019\u0010\u0014\u001a\u00020\u0015*\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u0015¢\u0006\u0004\b\u0014\u0010\u0016\u001a!\u0010\u0017\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\f\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a!\u0010\u0017\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000f¢\u0006\u0004\b\u0017\u0010\u0019\u001a!\u0010\u0017\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\f\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011¢\u0006\u0004\b\u0017\u0010\u001a\u001a!\u0010\u0017\u001a\u00020\u0015*\u00020\u00152\u0006\u0010\f\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u001b¨\u0006\u001c"}, d2 = {BuildConfig.FLAVOR, "to", "Lkotlin/ranges/IntProgression;", "downTo", "(II)Lkotlin/ranges/IntProgression;", "reversed", "(Lkotlin/ranges/IntProgression;)Lkotlin/ranges/IntProgression;", "step", "(Lkotlin/ranges/IntProgression;I)Lkotlin/ranges/IntProgression;", "Lkotlin/ranges/IntRange;", "until", "(II)Lkotlin/ranges/IntRange;", "minimumValue", "coerceAtLeast", "(II)I", BuildConfig.FLAVOR, "(JJ)J", BuildConfig.FLAVOR, "(FF)F", "maximumValue", "coerceAtMost", BuildConfig.FLAVOR, "(DD)D", "coerceIn", "(III)I", "(JJJ)J", "(FFF)F", "(DDD)D", "kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "kotlin/ranges/RangesKt")
/* loaded from: classes2.dex */
public abstract class RangesKt___RangesKt extends RangesKt__RangesKt {
    public static float coerceAtLeast(float f5, float f6) {
        return f5 < f6 ? f6 : f5;
    }

    public static double coerceAtMost(double d5, double d6) {
        return d5 > d6 ? d6 : d5;
    }

    public static int coerceIn(int i5, int i6, int i7) {
        if (i6 <= i7) {
            return i5 < i6 ? i6 : i5 > i7 ? i7 : i5;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i7 + " is less than minimum " + i6 + '.');
    }

    public static IntProgression downTo(int i5, int i6) {
        return IntProgression.INSTANCE.fromClosedRange(i5, i6, -1);
    }

    public static IntProgression reversed(IntProgression intProgression) {
        Intrinsics.checkNotNullParameter(intProgression, "<this>");
        return IntProgression.INSTANCE.fromClosedRange(intProgression.getLast(), intProgression.getFirst(), -intProgression.getStep());
    }

    public static IntProgression step(IntProgression intProgression, int i5) {
        Intrinsics.checkNotNullParameter(intProgression, "<this>");
        RangesKt__RangesKt.checkStepIsPositive(i5 > 0, Integer.valueOf(i5));
        IntProgression.Companion companion = IntProgression.INSTANCE;
        int first = intProgression.getFirst();
        int last = intProgression.getLast();
        if (intProgression.getStep() <= 0) {
            i5 = -i5;
        }
        return companion.fromClosedRange(first, last, i5);
    }

    public static IntRange until(int i5, int i6) {
        return i6 <= Integer.MIN_VALUE ? IntRange.INSTANCE.getEMPTY() : new IntRange(i5, i6 - 1);
    }

    public static int coerceAtLeast(int i5, int i6) {
        return i5 < i6 ? i6 : i5;
    }

    public static float coerceAtMost(float f5, float f6) {
        return f5 > f6 ? f6 : f5;
    }

    public static long coerceIn(long j5, long j6, long j7) {
        if (j6 <= j7) {
            return j5 < j6 ? j6 : j5 > j7 ? j7 : j5;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + j7 + " is less than minimum " + j6 + '.');
    }

    public static long coerceAtLeast(long j5, long j6) {
        return j5 < j6 ? j6 : j5;
    }

    public static int coerceAtMost(int i5, int i6) {
        return i5 > i6 ? i6 : i5;
    }

    public static float coerceIn(float f5, float f6, float f7) {
        if (f6 <= f7) {
            return f5 < f6 ? f6 : f5 > f7 ? f7 : f5;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + f7 + " is less than minimum " + f6 + '.');
    }

    public static long coerceAtMost(long j5, long j6) {
        return j5 > j6 ? j6 : j5;
    }

    public static double coerceIn(double d5, double d6, double d7) {
        if (d6 <= d7) {
            return d5 < d6 ? d6 : d5 > d7 ? d7 : d5;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + d7 + " is less than minimum " + d6 + '.');
    }
}
