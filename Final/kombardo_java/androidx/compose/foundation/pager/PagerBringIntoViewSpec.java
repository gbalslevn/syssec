package androidx.compose.foundation.pager;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.gestures.BringIntoViewSpec;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ'\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0004\u001a\u00020\u00018\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u00168\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Landroidx/compose/foundation/pager/PagerBringIntoViewSpec;", "Landroidx/compose/foundation/gestures/BringIntoViewSpec;", "Landroidx/compose/foundation/pager/PagerState;", "pagerState", "defaultBringIntoViewSpec", "<init>", "(Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/foundation/gestures/BringIntoViewSpec;)V", BuildConfig.FLAVOR, "proposedOffsetMove", "overrideProposedOffsetMove", "(F)F", "offset", "size", "containerSize", "calculateScrollDistance", "(FFF)F", "Landroidx/compose/foundation/pager/PagerState;", "getPagerState", "()Landroidx/compose/foundation/pager/PagerState;", "Landroidx/compose/foundation/gestures/BringIntoViewSpec;", "getDefaultBringIntoViewSpec", "()Landroidx/compose/foundation/gestures/BringIntoViewSpec;", "Landroidx/compose/animation/core/AnimationSpec;", "scrollAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "getScrollAnimationSpec", "()Landroidx/compose/animation/core/AnimationSpec;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class PagerBringIntoViewSpec implements BringIntoViewSpec {
    private final BringIntoViewSpec defaultBringIntoViewSpec;
    private final PagerState pagerState;
    private final AnimationSpec<Float> scrollAnimationSpec;

    public PagerBringIntoViewSpec(PagerState pagerState, BringIntoViewSpec bringIntoViewSpec) {
        this.pagerState = pagerState;
        this.defaultBringIntoViewSpec = bringIntoViewSpec;
        this.scrollAnimationSpec = bringIntoViewSpec.getScrollAnimationSpec();
    }

    private final float overrideProposedOffsetMove(float proposedOffsetMove) {
        float firstVisiblePageOffset = this.pagerState.getFirstVisiblePageOffset() * (-1);
        while (proposedOffsetMove > 0.0f && firstVisiblePageOffset < proposedOffsetMove) {
            firstVisiblePageOffset += this.pagerState.getPageSizeWithSpacing$foundation_release();
        }
        while (proposedOffsetMove < 0.0f && firstVisiblePageOffset > proposedOffsetMove) {
            firstVisiblePageOffset -= this.pagerState.getPageSizeWithSpacing$foundation_release();
        }
        return firstVisiblePageOffset;
    }

    @Override // androidx.compose.foundation.gestures.BringIntoViewSpec
    public float calculateScrollDistance(float offset, float size, float containerSize) {
        float calculateScrollDistance = this.defaultBringIntoViewSpec.calculateScrollDistance(offset, size, containerSize);
        if (calculateScrollDistance != 0.0f) {
            return overrideProposedOffsetMove(calculateScrollDistance);
        }
        if (this.pagerState.getFirstVisiblePageOffset() == 0) {
            return 0.0f;
        }
        float firstVisiblePageOffset = this.pagerState.getFirstVisiblePageOffset() * (-1.0f);
        if (this.pagerState.getLastScrolledForward()) {
            firstVisiblePageOffset += this.pagerState.getPageSizeWithSpacing$foundation_release();
        }
        return RangesKt.coerceIn(firstVisiblePageOffset, -containerSize, containerSize);
    }

    @Override // androidx.compose.foundation.gestures.BringIntoViewSpec
    public AnimationSpec<Float> getScrollAnimationSpec() {
        return this.scrollAnimationSpec;
    }
}
