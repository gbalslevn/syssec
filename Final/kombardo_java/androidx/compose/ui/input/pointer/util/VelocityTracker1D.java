package androidx.compose.ui.input.pointer.util;

import androidx.compose.ui.internal.InlineClassHelperKt;
import com.adjust.sdk.Constants;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\u0001*B\u001d\b\u0000\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\r¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\r¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\r¢\u0006\u0004\b\u0016\u0010\u0019J\r\u0010\u001a\u001a\u00020\u0013¢\u0006\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u0003\u0010\u001dR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001eR\u0014\u0010\u001f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001c\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\"0!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010%\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010 R\u0014\u0010&\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010'R\u0014\u0010)\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010'¨\u0006+"}, d2 = {"Landroidx/compose/ui/input/pointer/util/VelocityTracker1D;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "isDataDifferential", "Landroidx/compose/ui/input/pointer/util/VelocityTracker1D$Strategy;", "strategy", "<init>", "(ZLandroidx/compose/ui/input/pointer/util/VelocityTracker1D$Strategy;)V", BuildConfig.FLAVOR, "dataPoints", "time", BuildConfig.FLAVOR, "sampleCount", BuildConfig.FLAVOR, "calculateLeastSquaresVelocity", "([F[FI)F", BuildConfig.FLAVOR, "timeMillis", "dataPoint", BuildConfig.FLAVOR, "addDataPoint", "(JF)V", "calculateVelocity", "()F", "maximumVelocity", "(F)F", "resetTracking", "()V", "Z", "()Z", "Landroidx/compose/ui/input/pointer/util/VelocityTracker1D$Strategy;", "minSampleSize", "I", BuildConfig.FLAVOR, "Landroidx/compose/ui/input/pointer/util/DataPointAtTime;", "samples", "[Landroidx/compose/ui/input/pointer/util/DataPointAtTime;", "index", "reusableDataPointsArray", "[F", "reusableTimeArray", "reusableVelocityCoefficients", "Strategy", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class VelocityTracker1D {
    private int index;
    private final boolean isDataDifferential;
    private final int minSampleSize;
    private final float[] reusableDataPointsArray;
    private final float[] reusableTimeArray;
    private final float[] reusableVelocityCoefficients;
    private final DataPointAtTime[] samples;
    private final Strategy strategy;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Landroidx/compose/ui/input/pointer/util/VelocityTracker1D$Strategy;", BuildConfig.FLAVOR, "(Ljava/lang/String;I)V", "Lsq2", "Impulse", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public enum Strategy {
        Lsq2,
        Impulse
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Strategy.values().length];
            try {
                iArr[Strategy.Impulse.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Strategy.Lsq2.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public VelocityTracker1D(boolean z5, Strategy strategy) {
        this.isDataDifferential = z5;
        this.strategy = strategy;
        if (z5 && strategy.equals(Strategy.Lsq2)) {
            throw new IllegalStateException("Lsq2 not (yet) supported for differential axes");
        }
        int i5 = WhenMappings.$EnumSwitchMapping$0[strategy.ordinal()];
        int i6 = 2;
        if (i5 != 1) {
            if (i5 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            i6 = 3;
        }
        this.minSampleSize = i6;
        this.samples = new DataPointAtTime[20];
        this.reusableDataPointsArray = new float[20];
        this.reusableTimeArray = new float[20];
        this.reusableVelocityCoefficients = new float[3];
    }

    private final float calculateLeastSquaresVelocity(float[] dataPoints, float[] time, int sampleCount) {
        try {
            return VelocityTrackerKt.polyFitLeastSquares(time, dataPoints, sampleCount, 2, this.reusableVelocityCoefficients)[1];
        } catch (IllegalArgumentException unused) {
            return 0.0f;
        }
    }

    public final void addDataPoint(long timeMillis, float dataPoint) {
        int i5 = (this.index + 1) % 20;
        this.index = i5;
        VelocityTrackerKt.set(this.samples, i5, timeMillis, dataPoint);
    }

    public final float calculateVelocity() {
        float calculateImpulseVelocity;
        float[] fArr = this.reusableDataPointsArray;
        float[] fArr2 = this.reusableTimeArray;
        int i5 = this.index;
        DataPointAtTime dataPointAtTime = this.samples[i5];
        if (dataPointAtTime == null) {
            return 0.0f;
        }
        int i6 = 0;
        DataPointAtTime dataPointAtTime2 = dataPointAtTime;
        while (true) {
            DataPointAtTime dataPointAtTime3 = this.samples[i5];
            if (dataPointAtTime3 != null) {
                float time = (float) (dataPointAtTime.getTime() - dataPointAtTime3.getTime());
                float abs = (float) Math.abs(dataPointAtTime3.getTime() - dataPointAtTime2.getTime());
                DataPointAtTime dataPointAtTime4 = (this.strategy == Strategy.Lsq2 || this.isDataDifferential) ? dataPointAtTime3 : dataPointAtTime;
                if (time > 100.0f || abs > 40.0f) {
                    break;
                }
                fArr[i6] = dataPointAtTime3.getDataPoint();
                fArr2[i6] = -time;
                if (i5 == 0) {
                    i5 = 20;
                }
                i5--;
                i6++;
                if (i6 >= 20) {
                    break;
                }
                dataPointAtTime2 = dataPointAtTime4;
            } else {
                break;
            }
        }
        if (i6 < this.minSampleSize) {
            return 0.0f;
        }
        int i7 = WhenMappings.$EnumSwitchMapping$0[this.strategy.ordinal()];
        if (i7 == 1) {
            calculateImpulseVelocity = VelocityTrackerKt.calculateImpulseVelocity(fArr, fArr2, i6, this.isDataDifferential);
        } else {
            if (i7 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            calculateImpulseVelocity = calculateLeastSquaresVelocity(fArr, fArr2, i6);
        }
        return calculateImpulseVelocity * Constants.ONE_SECOND;
    }

    public final void resetTracking() {
        ArraysKt.fill$default(this.samples, (Object) null, 0, 0, 6, (Object) null);
        this.index = 0;
    }

    public /* synthetic */ VelocityTracker1D(boolean z5, Strategy strategy, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? false : z5, (i5 & 2) != 0 ? Strategy.Lsq2 : strategy);
    }

    public final float calculateVelocity(float maximumVelocity) {
        if (!(maximumVelocity > 0.0f)) {
            InlineClassHelperKt.throwIllegalStateException("maximumVelocity should be a positive value. You specified=" + maximumVelocity);
        }
        float calculateVelocity = calculateVelocity();
        if (calculateVelocity == 0.0f || Float.isNaN(calculateVelocity)) {
            return 0.0f;
        }
        if (calculateVelocity > 0.0f) {
            return RangesKt.coerceAtMost(calculateVelocity, maximumVelocity);
        }
        return RangesKt.coerceAtLeast(calculateVelocity, -maximumVelocity);
    }
}
