package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\nJ\u0014\u0010\u000e\u001a\u00020\u0006*\u00020\bø\u0001\u0001¢\u0006\u0004\b\f\u0010\rJ\u0014\u0010\u0010\u001a\u00020\u0006*\u00020\bø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\rJ%\u0010\u0015\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u00020\b8\u0002@\u0002X\u0082\u000eø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u001e"}, d2 = {"Landroidx/compose/foundation/gestures/TouchSlopDetector;", BuildConfig.FLAVOR, "Landroidx/compose/foundation/gestures/Orientation;", "orientation", "<init>", "(Landroidx/compose/foundation/gestures/Orientation;)V", BuildConfig.FLAVOR, "touchSlop", "Landroidx/compose/ui/geometry/Offset;", "calculatePostSlopOffset-tuRUvjQ", "(F)J", "calculatePostSlopOffset", "mainAxis-k-4lQ0M", "(J)F", "mainAxis", "crossAxis-k-4lQ0M", "crossAxis", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "dragEvent", "addPointerInputChange-GcwITfU", "(Landroidx/compose/ui/input/pointer/PointerInputChange;F)Landroidx/compose/ui/geometry/Offset;", "addPointerInputChange", BuildConfig.FLAVOR, "reset", "()V", "Landroidx/compose/foundation/gestures/Orientation;", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "totalPositionChange", "J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class TouchSlopDetector {
    private final Orientation orientation;
    private long totalPositionChange = Offset.INSTANCE.m1349getZeroF1C5BW0();

    public TouchSlopDetector(Orientation orientation) {
        this.orientation = orientation;
    }

    /* renamed from: calculatePostSlopOffset-tuRUvjQ, reason: not valid java name */
    private final long m239calculatePostSlopOffsettuRUvjQ(float touchSlop) {
        if (this.orientation == null) {
            long j5 = this.totalPositionChange;
            return Offset.m1341minusMKHz9U(this.totalPositionChange, Offset.m1343timestuRUvjQ(Offset.m1332divtuRUvjQ(j5, Offset.m1335getDistanceimpl(j5)), touchSlop));
        }
        float m242mainAxisk4lQ0M = m242mainAxisk4lQ0M(this.totalPositionChange) - (Math.signum(m242mainAxisk4lQ0M(this.totalPositionChange)) * touchSlop);
        float m241crossAxisk4lQ0M = m241crossAxisk4lQ0M(this.totalPositionChange);
        return this.orientation == Orientation.Horizontal ? OffsetKt.Offset(m242mainAxisk4lQ0M, m241crossAxisk4lQ0M) : OffsetKt.Offset(m241crossAxisk4lQ0M, m242mainAxisk4lQ0M);
    }

    /* renamed from: addPointerInputChange-GcwITfU, reason: not valid java name */
    public final Offset m240addPointerInputChangeGcwITfU(PointerInputChange dragEvent, float touchSlop) {
        long m1342plusMKHz9U = Offset.m1342plusMKHz9U(this.totalPositionChange, Offset.m1341minusMKHz9U(dragEvent.getPosition(), dragEvent.getPreviousPosition()));
        this.totalPositionChange = m1342plusMKHz9U;
        if ((this.orientation == null ? Offset.m1335getDistanceimpl(m1342plusMKHz9U) : Math.abs(m242mainAxisk4lQ0M(m1342plusMKHz9U))) >= touchSlop) {
            return Offset.m1328boximpl(m239calculatePostSlopOffsettuRUvjQ(touchSlop));
        }
        return null;
    }

    /* renamed from: crossAxis-k-4lQ0M, reason: not valid java name */
    public final float m241crossAxisk4lQ0M(long j5) {
        return this.orientation == Orientation.Horizontal ? Offset.m1338getYimpl(j5) : Offset.m1337getXimpl(j5);
    }

    /* renamed from: mainAxis-k-4lQ0M, reason: not valid java name */
    public final float m242mainAxisk4lQ0M(long j5) {
        return this.orientation == Orientation.Horizontal ? Offset.m1337getXimpl(j5) : Offset.m1338getYimpl(j5);
    }

    public final void reset() {
        this.totalPositionChange = Offset.INSTANCE.m1349getZeroF1C5BW0();
    }
}
