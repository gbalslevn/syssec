package androidx.compose.ui.input.pointer.util;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.HistoricalChange;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.internal.InlineClassHelperKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000>\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u001c\u001a3\u0010\t\u001a\u00020\b*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\n\u001a\u0019\u0010\u000e\u001a\u00020\b*\u00020\u000b2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u001b\u0010\u0010\u001a\u00020\b*\u00020\u000b2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0010\u0010\u000f\u001a\u001b\u0010\u0011\u001a\u00020\b*\u00020\u000b2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0011\u0010\u000f\u001a9\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u0012H\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a/\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001e\u001a\u001b\u0010 \u001a\u00020\u0006*\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u0012H\u0002¢\u0006\u0004\b \u0010!\"\u0014\u0010\"\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\"\u0010#\"\u0014\u0010$\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b$\u0010#\"\u0014\u0010%\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b%\u0010#\"\u0014\u0010&\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b&\u0010'\"0\u0010)\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020\u001b8G@GX\u0087\u000e¢\u0006\u0018\n\u0004\b)\u0010*\u0012\u0004\b/\u00100\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.\"0\u00101\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020\u001b8G@GX\u0087\u000e¢\u0006\u0018\n\u0004\b1\u0010*\u0012\u0004\b4\u00100\u001a\u0004\b2\u0010,\"\u0004\b3\u0010.*\u0018\b\u0002\u00105\"\b\u0012\u0004\u0012\u00020\u00120\u00002\b\u0012\u0004\u0012\u00020\u00120\u0000*\f\b\u0002\u00106\"\u00020\u00122\u00020\u0012¨\u00067"}, d2 = {BuildConfig.FLAVOR, "Landroidx/compose/ui/input/pointer/util/DataPointAtTime;", BuildConfig.FLAVOR, "index", BuildConfig.FLAVOR, "time", BuildConfig.FLAVOR, "dataPoint", BuildConfig.FLAVOR, "set", "([Landroidx/compose/ui/input/pointer/util/DataPointAtTime;IJF)V", "Landroidx/compose/ui/input/pointer/util/VelocityTracker;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "event", "addPointerInputChange", "(Landroidx/compose/ui/input/pointer/util/VelocityTracker;Landroidx/compose/ui/input/pointer/PointerInputChange;)V", "addPointerInputChangeLegacy", "addPointerInputChangeWithFix", BuildConfig.FLAVOR, "x", "y", "sampleCount", "degree", "coefficients", "polyFitLeastSquares", "([F[FII[F)[F", "dataPoints", BuildConfig.FLAVOR, "isDataDifferential", "calculateImpulseVelocity", "([F[FIZ)F", "a", "dot", "([F[F)F", "AssumePointerMoveStoppedMilliseconds", "I", "HistorySize", "HorizonMilliseconds", "DefaultWeight", "F", "<set-?>", "VelocityTrackerAddPointsFix", "Z", "getVelocityTrackerAddPointsFix", "()Z", "setVelocityTrackerAddPointsFix", "(Z)V", "getVelocityTrackerAddPointsFix$annotations", "()V", "VelocityTrackerStrategyUseImpulse", "getVelocityTrackerStrategyUseImpulse", "setVelocityTrackerStrategyUseImpulse", "getVelocityTrackerStrategyUseImpulse$annotations", "Matrix", "Vector", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class VelocityTrackerKt {
    private static final int AssumePointerMoveStoppedMilliseconds = 40;
    private static final float DefaultWeight = 1.0f;
    private static final int HistorySize = 20;
    private static final int HorizonMilliseconds = 100;
    private static boolean VelocityTrackerAddPointsFix = true;
    private static boolean VelocityTrackerStrategyUseImpulse;

    public static final void addPointerInputChange(VelocityTracker velocityTracker, PointerInputChange pointerInputChange) {
        if (VelocityTrackerAddPointsFix) {
            addPointerInputChangeWithFix(velocityTracker, pointerInputChange);
        } else {
            addPointerInputChangeLegacy(velocityTracker, pointerInputChange);
        }
    }

    private static final void addPointerInputChangeLegacy(VelocityTracker velocityTracker, PointerInputChange pointerInputChange) {
        if (PointerEventKt.changedToDownIgnoreConsumed(pointerInputChange)) {
            velocityTracker.m1926setCurrentPointerPositionAccumulatork4lQ0M$ui_release(pointerInputChange.getPosition());
            velocityTracker.resetTracking();
        }
        long previousPosition = pointerInputChange.getPreviousPosition();
        List<HistoricalChange> historical = pointerInputChange.getHistorical();
        int size = historical.size();
        int i5 = 0;
        while (i5 < size) {
            HistoricalChange historicalChange = historical.get(i5);
            long m1341minusMKHz9U = Offset.m1341minusMKHz9U(historicalChange.getPosition(), previousPosition);
            long position = historicalChange.getPosition();
            velocityTracker.m1926setCurrentPointerPositionAccumulatork4lQ0M$ui_release(Offset.m1342plusMKHz9U(velocityTracker.getCurrentPointerPositionAccumulator(), m1341minusMKHz9U));
            velocityTracker.m1923addPositionUv8p0NA(historicalChange.getUptimeMillis(), velocityTracker.getCurrentPointerPositionAccumulator());
            i5++;
            previousPosition = position;
        }
        velocityTracker.m1926setCurrentPointerPositionAccumulatork4lQ0M$ui_release(Offset.m1342plusMKHz9U(velocityTracker.getCurrentPointerPositionAccumulator(), Offset.m1341minusMKHz9U(pointerInputChange.getPosition(), previousPosition)));
        velocityTracker.m1923addPositionUv8p0NA(pointerInputChange.getUptimeMillis(), velocityTracker.getCurrentPointerPositionAccumulator());
    }

    private static final void addPointerInputChangeWithFix(VelocityTracker velocityTracker, PointerInputChange pointerInputChange) {
        if (PointerEventKt.changedToDownIgnoreConsumed(pointerInputChange)) {
            velocityTracker.resetTracking();
        }
        if (!PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange)) {
            List<HistoricalChange> historical = pointerInputChange.getHistorical();
            int size = historical.size();
            for (int i5 = 0; i5 < size; i5++) {
                HistoricalChange historicalChange = historical.get(i5);
                velocityTracker.m1923addPositionUv8p0NA(historicalChange.getUptimeMillis(), historicalChange.getOriginalEventPosition());
            }
            velocityTracker.m1923addPositionUv8p0NA(pointerInputChange.getUptimeMillis(), pointerInputChange.getOriginalEventPosition());
        }
        if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange) && pointerInputChange.getUptimeMillis() - velocityTracker.getLastMoveEventTimeStamp() > 40) {
            velocityTracker.resetTracking();
        }
        velocityTracker.setLastMoveEventTimeStamp$ui_release(pointerInputChange.getUptimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float calculateImpulseVelocity(float[] fArr, float[] fArr2, int i5, boolean z5) {
        int i6 = i5 - 1;
        float f5 = fArr2[i6];
        float f6 = 0.0f;
        int i7 = i6;
        while (i7 > 0) {
            int i8 = i7 - 1;
            float f7 = fArr2[i8];
            if (f5 != f7) {
                float f8 = (z5 ? -fArr[i8] : fArr[i7] - fArr[i8]) / (f5 - f7);
                f6 += (f8 - (Math.signum(f6) * ((float) Math.sqrt(2 * Math.abs(f6))))) * Math.abs(f8);
                if (i7 == i6) {
                    f6 *= 0.5f;
                }
            }
            i7--;
            f5 = f7;
        }
        return Math.signum(f6) * ((float) Math.sqrt(2 * Math.abs(f6)));
    }

    private static final float dot(float[] fArr, float[] fArr2) {
        int length = fArr.length;
        float f5 = 0.0f;
        for (int i5 = 0; i5 < length; i5++) {
            f5 += fArr[i5] * fArr2[i5];
        }
        return f5;
    }

    public static final boolean getVelocityTrackerStrategyUseImpulse() {
        return VelocityTrackerStrategyUseImpulse;
    }

    public static final float[] polyFitLeastSquares(float[] fArr, float[] fArr2, int i5, int i6, float[] fArr3) {
        int i7 = i6;
        if (i7 < 1) {
            InlineClassHelperKt.throwIllegalArgumentException("The degree must be at positive integer");
        }
        if (i5 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("At least one point must be provided");
        }
        if (i7 >= i5) {
            i7 = i5 - 1;
        }
        int i8 = i7 + 1;
        float[][] fArr4 = new float[i8];
        for (int i9 = 0; i9 < i8; i9++) {
            fArr4[i9] = new float[i5];
        }
        for (int i10 = 0; i10 < i5; i10++) {
            fArr4[0][i10] = 1.0f;
            for (int i11 = 1; i11 < i8; i11++) {
                fArr4[i11][i10] = fArr4[i11 - 1][i10] * fArr[i10];
            }
        }
        float[][] fArr5 = new float[i8];
        for (int i12 = 0; i12 < i8; i12++) {
            fArr5[i12] = new float[i5];
        }
        float[][] fArr6 = new float[i8];
        for (int i13 = 0; i13 < i8; i13++) {
            fArr6[i13] = new float[i8];
        }
        int i14 = 0;
        while (i14 < i8) {
            float[] fArr7 = fArr5[i14];
            ArraysKt.copyInto(fArr4[i14], fArr7, 0, 0, i5);
            for (int i15 = 0; i15 < i14; i15++) {
                float[] fArr8 = fArr5[i15];
                float dot = dot(fArr7, fArr8);
                for (int i16 = 0; i16 < i5; i16++) {
                    fArr7[i16] = fArr7[i16] - (fArr8[i16] * dot);
                }
            }
            float sqrt = (float) Math.sqrt(dot(fArr7, fArr7));
            if (sqrt < 1.0E-6f) {
                sqrt = 1.0E-6f;
            }
            float f5 = DefaultWeight / sqrt;
            for (int i17 = 0; i17 < i5; i17++) {
                fArr7[i17] = fArr7[i17] * f5;
            }
            float[] fArr9 = fArr6[i14];
            int i18 = 0;
            while (i18 < i8) {
                fArr9[i18] = i18 < i14 ? 0.0f : dot(fArr7, fArr4[i18]);
                i18++;
            }
            i14++;
        }
        for (int i19 = i7; -1 < i19; i19--) {
            float dot2 = dot(fArr5[i19], fArr2);
            float[] fArr10 = fArr6[i19];
            int i20 = i19 + 1;
            if (i20 <= i7) {
                int i21 = i7;
                while (true) {
                    dot2 -= fArr10[i21] * fArr3[i21];
                    if (i21 != i20) {
                        i21--;
                    }
                }
            }
            fArr3[i19] = dot2 / fArr10[i19];
        }
        return fArr3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void set(DataPointAtTime[] dataPointAtTimeArr, int i5, long j5, float f5) {
        DataPointAtTime dataPointAtTime = dataPointAtTimeArr[i5];
        if (dataPointAtTime == null) {
            dataPointAtTimeArr[i5] = new DataPointAtTime(j5, f5);
        } else {
            dataPointAtTime.setTime(j5);
            dataPointAtTime.setDataPoint(f5);
        }
    }
}
