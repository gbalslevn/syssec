package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerInputChange;
import java.util.List;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0016\u0010\u0007\u001a\u00020\u0001*\u00020\u0004H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0011\u0010\b\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\b\u0010\u0003\u001a\u0011\u0010\t\u001a\u00020\u0004*\u00020\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u001b\u0010\r\u001a\u00020\u0001*\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000e\u001a\u001b\u0010\u000f\u001a\u00020\u0004*\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerEvent;", BuildConfig.FLAVOR, "calculateRotation", "(Landroidx/compose/ui/input/pointer/PointerEvent;)F", "Landroidx/compose/ui/geometry/Offset;", "angle-k-4lQ0M", "(J)F", "angle", "calculateZoom", "calculatePan", "(Landroidx/compose/ui/input/pointer/PointerEvent;)J", BuildConfig.FLAVOR, "useCurrent", "calculateCentroidSize", "(Landroidx/compose/ui/input/pointer/PointerEvent;Z)F", "calculateCentroid", "(Landroidx/compose/ui/input/pointer/PointerEvent;Z)J", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class TransformGestureDetectorKt {
    /* renamed from: angle-k-4lQ0M, reason: not valid java name */
    private static final float m244anglek4lQ0M(long j5) {
        if (Offset.m1337getXimpl(j5) == 0.0f && Offset.m1338getYimpl(j5) == 0.0f) {
            return 0.0f;
        }
        return ((-((float) Math.atan2(Offset.m1337getXimpl(j5), Offset.m1338getYimpl(j5)))) * 180.0f) / 3.1415927f;
    }

    public static final long calculateCentroid(PointerEvent pointerEvent, boolean z5) {
        long m1349getZeroF1C5BW0 = Offset.INSTANCE.m1349getZeroF1C5BW0();
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        int i5 = 0;
        for (int i6 = 0; i6 < size; i6++) {
            PointerInputChange pointerInputChange = changes.get(i6);
            if (pointerInputChange.getPressed() && pointerInputChange.getPreviousPressed()) {
                m1349getZeroF1C5BW0 = Offset.m1342plusMKHz9U(m1349getZeroF1C5BW0, z5 ? pointerInputChange.getPosition() : pointerInputChange.getPreviousPosition());
                i5++;
            }
        }
        return i5 == 0 ? Offset.INSTANCE.m1348getUnspecifiedF1C5BW0() : Offset.m1332divtuRUvjQ(m1349getZeroF1C5BW0, i5);
    }

    public static final float calculateCentroidSize(PointerEvent pointerEvent, boolean z5) {
        long calculateCentroid = calculateCentroid(pointerEvent, z5);
        float f5 = 0.0f;
        if (Offset.m1334equalsimpl0(calculateCentroid, Offset.INSTANCE.m1348getUnspecifiedF1C5BW0())) {
            return 0.0f;
        }
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        int i5 = 0;
        for (int i6 = 0; i6 < size; i6++) {
            PointerInputChange pointerInputChange = changes.get(i6);
            if (pointerInputChange.getPressed() && pointerInputChange.getPreviousPressed()) {
                f5 += Offset.m1335getDistanceimpl(Offset.m1341minusMKHz9U(z5 ? pointerInputChange.getPosition() : pointerInputChange.getPreviousPosition(), calculateCentroid));
                i5++;
            }
        }
        return f5 / i5;
    }

    public static final long calculatePan(PointerEvent pointerEvent) {
        long calculateCentroid = calculateCentroid(pointerEvent, true);
        Offset.Companion companion = Offset.INSTANCE;
        return Offset.m1334equalsimpl0(calculateCentroid, companion.m1348getUnspecifiedF1C5BW0()) ? companion.m1349getZeroF1C5BW0() : Offset.m1341minusMKHz9U(calculateCentroid, calculateCentroid(pointerEvent, false));
    }

    public static final float calculateRotation(PointerEvent pointerEvent) {
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        int i5 = 0;
        int i6 = 0;
        while (true) {
            int i7 = 1;
            if (i5 >= size) {
                break;
            }
            PointerInputChange pointerInputChange = changes.get(i5);
            if (!pointerInputChange.getPreviousPressed() || !pointerInputChange.getPressed()) {
                i7 = 0;
            }
            i6 += i7;
            i5++;
        }
        if (i6 < 2) {
            return 0.0f;
        }
        long calculateCentroid = calculateCentroid(pointerEvent, true);
        long calculateCentroid2 = calculateCentroid(pointerEvent, false);
        List<PointerInputChange> changes2 = pointerEvent.getChanges();
        int size2 = changes2.size();
        float f5 = 0.0f;
        float f6 = 0.0f;
        for (int i8 = 0; i8 < size2; i8++) {
            PointerInputChange pointerInputChange2 = changes2.get(i8);
            if (pointerInputChange2.getPressed() && pointerInputChange2.getPreviousPressed()) {
                long position = pointerInputChange2.getPosition();
                long m1341minusMKHz9U = Offset.m1341minusMKHz9U(pointerInputChange2.getPreviousPosition(), calculateCentroid2);
                long m1341minusMKHz9U2 = Offset.m1341minusMKHz9U(position, calculateCentroid);
                float m244anglek4lQ0M = m244anglek4lQ0M(m1341minusMKHz9U2) - m244anglek4lQ0M(m1341minusMKHz9U);
                float m1335getDistanceimpl = Offset.m1335getDistanceimpl(Offset.m1342plusMKHz9U(m1341minusMKHz9U2, m1341minusMKHz9U)) / 2.0f;
                if (m244anglek4lQ0M > 180.0f) {
                    m244anglek4lQ0M -= 360.0f;
                } else if (m244anglek4lQ0M < -180.0f) {
                    m244anglek4lQ0M += 360.0f;
                }
                f6 += m244anglek4lQ0M * m1335getDistanceimpl;
                f5 += m1335getDistanceimpl;
            }
        }
        if (f5 == 0.0f) {
            return 0.0f;
        }
        return f6 / f5;
    }

    public static final float calculateZoom(PointerEvent pointerEvent) {
        float calculateCentroidSize = calculateCentroidSize(pointerEvent, true);
        float calculateCentroidSize2 = calculateCentroidSize(pointerEvent, false);
        if (calculateCentroidSize == 0.0f || calculateCentroidSize2 == 0.0f) {
            return 1.0f;
        }
        return calculateCentroidSize / calculateCentroidSize2;
    }
}
