package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.unit.Velocity;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.ranges.RangesKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\f\u001a\u00020\t*\u00020\bH\u0002ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001c\u0010\u0010\u001a\u00020\r*\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\"\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J*\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J#\u0010\u001d\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\rH\u0096@ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010!\u001a\u0004\b\"\u0010#\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006$"}, d2 = {"Landroidx/compose/foundation/pager/DefaultPagerNestedScrollConnection;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "Landroidx/compose/foundation/pager/PagerState;", "state", "Landroidx/compose/foundation/gestures/Orientation;", "orientation", "<init>", "(Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/foundation/gestures/Orientation;)V", "Landroidx/compose/ui/geometry/Offset;", BuildConfig.FLAVOR, "mainAxis-k-4lQ0M", "(J)F", "mainAxis", "Landroidx/compose/ui/unit/Velocity;", "consumeOnOrientation-QWom1Mo", "(JLandroidx/compose/foundation/gestures/Orientation;)J", "consumeOnOrientation", "available", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "source", "onPreScroll-OzD1aCk", "(JI)J", "onPreScroll", "consumed", "onPostScroll-DzOQY0M", "(JJI)J", "onPostScroll", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostFling", "Landroidx/compose/foundation/pager/PagerState;", "getState", "()Landroidx/compose/foundation/pager/PagerState;", "Landroidx/compose/foundation/gestures/Orientation;", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class DefaultPagerNestedScrollConnection implements NestedScrollConnection {
    private final Orientation orientation;
    private final PagerState state;

    public DefaultPagerNestedScrollConnection(PagerState pagerState, Orientation orientation) {
        this.state = pagerState;
        this.orientation = orientation;
    }

    /* renamed from: mainAxis-k-4lQ0M, reason: not valid java name */
    private final float m433mainAxisk4lQ0M(long j5) {
        return this.orientation == Orientation.Horizontal ? Offset.m1337getXimpl(j5) : Offset.m1338getYimpl(j5);
    }

    /* renamed from: consumeOnOrientation-QWom1Mo, reason: not valid java name */
    public final long m434consumeOnOrientationQWom1Mo(long j5, Orientation orientation) {
        return orientation == Orientation.Vertical ? Velocity.m2698copyOhffZ5M$default(j5, 0.0f, 0.0f, 2, null) : Velocity.m2698copyOhffZ5M$default(j5, 0.0f, 0.0f, 1, null);
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPostFling-RZ2iAVY */
    public Object mo218onPostFlingRZ2iAVY(long j5, long j6, Continuation<? super Velocity> continuation) {
        return Velocity.m2695boximpl(m434consumeOnOrientationQWom1Mo(j6, this.orientation));
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPostScroll-DzOQY0M */
    public long mo219onPostScrollDzOQY0M(long consumed, long available, int source) {
        if (!NestedScrollSource.m1840equalsimpl0(source, NestedScrollSource.INSTANCE.m1841getSideEffectWNlRxjI()) || m433mainAxisk4lQ0M(available) == 0.0f) {
            return Offset.INSTANCE.m1349getZeroF1C5BW0();
        }
        throw new CancellationException("Scroll cancelled");
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPreScroll-OzD1aCk, reason: not valid java name */
    public long mo435onPreScrollOzD1aCk(long available, int source) {
        if (!NestedScrollSource.m1840equalsimpl0(source, NestedScrollSource.INSTANCE.m1842getUserInputWNlRxjI()) || Math.abs(this.state.getCurrentPageOffsetFraction()) <= 1.0E-6d) {
            return Offset.INSTANCE.m1349getZeroF1C5BW0();
        }
        float currentPageOffsetFraction = this.state.getCurrentPageOffsetFraction() * this.state.getPageSize$foundation_release();
        float pageSize = ((this.state.getLayoutInfo().getPageSize() + this.state.getLayoutInfo().getPageSpacing()) * (-Math.signum(this.state.getCurrentPageOffsetFraction()))) + currentPageOffsetFraction;
        if (this.state.getCurrentPageOffsetFraction() > 0.0f) {
            pageSize = currentPageOffsetFraction;
            currentPageOffsetFraction = pageSize;
        }
        Orientation orientation = this.orientation;
        Orientation orientation2 = Orientation.Horizontal;
        float f5 = -this.state.dispatchRawDelta(-RangesKt.coerceIn(orientation == orientation2 ? Offset.m1337getXimpl(available) : Offset.m1338getYimpl(available), currentPageOffsetFraction, pageSize));
        float m1337getXimpl = this.orientation == orientation2 ? f5 : Offset.m1337getXimpl(available);
        if (this.orientation != Orientation.Vertical) {
            f5 = Offset.m1338getYimpl(available);
        }
        return Offset.m1330copydBAh8RU(available, m1337getXimpl, f5);
    }
}
