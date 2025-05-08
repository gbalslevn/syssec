package kotlin.ranges;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\"\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0004\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\"\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {BuildConfig.FLAVOR, "that", "Lkotlin/ranges/ClosedFloatingPointRange;", "rangeTo", "(FF)Lkotlin/ranges/ClosedFloatingPointRange;", BuildConfig.FLAVOR, "isPositive", BuildConfig.FLAVOR, "step", BuildConfig.FLAVOR, "checkStepIsPositive", "(ZLjava/lang/Number;)V", "kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "kotlin/ranges/RangesKt")
/* loaded from: classes2.dex */
public abstract class RangesKt__RangesKt {
    public static final void checkStepIsPositive(boolean z5, Number step) {
        Intrinsics.checkNotNullParameter(step, "step");
        if (z5) {
            return;
        }
        throw new IllegalArgumentException("Step must be positive, was: " + step + '.');
    }

    public static ClosedFloatingPointRange<Float> rangeTo(float f5, float f6) {
        return new ClosedFloatRange(f5, f6);
    }
}
