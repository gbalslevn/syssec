package androidx.compose.ui.input.pointer;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.unit.IntSize;
import kotlin.Deprecated;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0004\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0003\u001a\u0011\u0010\u0005\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0003\u001a\u0011\u0010\u0006\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0006\u0010\u0003\u001a\u0011\u0010\u0007\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0007\u0010\u0003\u001a\u0011\u0010\b\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\b\u0010\u0003\u001a\u0011\u0010\n\u001a\u00020\t*\u00020\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a\u0011\u0010\f\u001a\u00020\t*\u00020\u0000¢\u0006\u0004\b\f\u0010\u000b\u001a\u001d\u0010\u000e\u001a\u00020\t*\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u001e\u0010\u0014\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0010H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a$\u0010\u0014\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0015ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0019"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerInputChange;", BuildConfig.FLAVOR, "changedToDown", "(Landroidx/compose/ui/input/pointer/PointerInputChange;)Z", "changedToDownIgnoreConsumed", "changedToUp", "changedToUpIgnoreConsumed", "positionChanged", "positionChangedIgnoreConsumed", "Landroidx/compose/ui/geometry/Offset;", "positionChange", "(Landroidx/compose/ui/input/pointer/PointerInputChange;)J", "positionChangeIgnoreConsumed", "ignoreConsumed", "positionChangeInternal", "(Landroidx/compose/ui/input/pointer/PointerInputChange;Z)J", "Landroidx/compose/ui/unit/IntSize;", "size", "isOutOfBounds-O0kMr_c", "(Landroidx/compose/ui/input/pointer/PointerInputChange;J)Z", "isOutOfBounds", "Landroidx/compose/ui/geometry/Size;", "extendedTouchPadding", "isOutOfBounds-jwHxaWs", "(Landroidx/compose/ui/input/pointer/PointerInputChange;JJ)Z", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class PointerEventKt {
    public static final boolean changedToDown(PointerInputChange pointerInputChange) {
        return (pointerInputChange.isConsumed() || pointerInputChange.getPreviousPressed() || !pointerInputChange.getPressed()) ? false : true;
    }

    public static final boolean changedToDownIgnoreConsumed(PointerInputChange pointerInputChange) {
        return !pointerInputChange.getPreviousPressed() && pointerInputChange.getPressed();
    }

    public static final boolean changedToUp(PointerInputChange pointerInputChange) {
        return (pointerInputChange.isConsumed() || !pointerInputChange.getPreviousPressed() || pointerInputChange.getPressed()) ? false : true;
    }

    public static final boolean changedToUpIgnoreConsumed(PointerInputChange pointerInputChange) {
        return pointerInputChange.getPreviousPressed() && !pointerInputChange.getPressed();
    }

    @Deprecated
    /* renamed from: isOutOfBounds-O0kMr_c, reason: not valid java name */
    public static final boolean m1856isOutOfBoundsO0kMr_c(PointerInputChange pointerInputChange, long j5) {
        long position = pointerInputChange.getPosition();
        float m1337getXimpl = Offset.m1337getXimpl(position);
        float m1338getYimpl = Offset.m1338getYimpl(position);
        return m1337getXimpl < 0.0f || m1337getXimpl > ((float) IntSize.m2661getWidthimpl(j5)) || m1338getYimpl < 0.0f || m1338getYimpl > ((float) IntSize.m2660getHeightimpl(j5));
    }

    /* renamed from: isOutOfBounds-jwHxaWs, reason: not valid java name */
    public static final boolean m1857isOutOfBoundsjwHxaWs(PointerInputChange pointerInputChange, long j5, long j6) {
        if (!PointerType.m1904equalsimpl0(pointerInputChange.getType(), PointerType.INSTANCE.m1910getTouchT8wyACA())) {
            return m1856isOutOfBoundsO0kMr_c(pointerInputChange, j5);
        }
        long position = pointerInputChange.getPosition();
        float m1337getXimpl = Offset.m1337getXimpl(position);
        float m1338getYimpl = Offset.m1338getYimpl(position);
        return m1337getXimpl < (-Size.m1377getWidthimpl(j6)) || m1337getXimpl > ((float) IntSize.m2661getWidthimpl(j5)) + Size.m1377getWidthimpl(j6) || m1338getYimpl < (-Size.m1375getHeightimpl(j6)) || m1338getYimpl > ((float) IntSize.m2660getHeightimpl(j5)) + Size.m1375getHeightimpl(j6);
    }

    public static final long positionChange(PointerInputChange pointerInputChange) {
        return positionChangeInternal(pointerInputChange, false);
    }

    public static final long positionChangeIgnoreConsumed(PointerInputChange pointerInputChange) {
        return positionChangeInternal(pointerInputChange, true);
    }

    private static final long positionChangeInternal(PointerInputChange pointerInputChange, boolean z5) {
        long m1341minusMKHz9U = Offset.m1341minusMKHz9U(pointerInputChange.getPosition(), pointerInputChange.getPreviousPosition());
        return (z5 || !pointerInputChange.isConsumed()) ? m1341minusMKHz9U : Offset.INSTANCE.m1349getZeroF1C5BW0();
    }

    public static final boolean positionChanged(PointerInputChange pointerInputChange) {
        return !Offset.m1334equalsimpl0(positionChangeInternal(pointerInputChange, false), Offset.INSTANCE.m1349getZeroF1C5BW0());
    }

    public static final boolean positionChangedIgnoreConsumed(PointerInputChange pointerInputChange) {
        return !Offset.m1334equalsimpl0(positionChangeInternal(pointerInputChange, true), Offset.INSTANCE.m1349getZeroF1C5BW0());
    }
}
