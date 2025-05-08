package androidx.compose.foundation.gestures.snapping;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.FinalSnappingItem;
import androidx.compose.foundation.pager.PageInfo;
import androidx.compose.foundation.pager.PagerLayoutInfo;
import androidx.compose.foundation.pager.PagerLayoutInfoKt;
import androidx.compose.foundation.pager.PagerSnapDistance;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function3;
import kotlin.ranges.RangesKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a?\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u001e\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004H\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u0013\u0010\u000b\u001a\u00020\n*\u00020\u0000H\u0002¢\u0006\u0004\b\u000b\u0010\f\u001a\u0013\u0010\r\u001a\u00020\n*\u00020\u0000H\u0002¢\u0006\u0004\b\r\u0010\f\u001a\u0013\u0010\u000e\u001a\u00020\u0005*\u00020\u0000H\u0002¢\u0006\u0004\b\u000e\u0010\u000f\u001a?\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\u0006\u0010\u0016¨\u0006\u0017"}, d2 = {"Landroidx/compose/foundation/pager/PagerState;", "pagerState", "Landroidx/compose/foundation/pager/PagerSnapDistance;", "pagerSnapDistance", "Lkotlin/Function3;", BuildConfig.FLAVOR, "calculateFinalSnappingBound", "Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;", "SnapLayoutInfoProvider", "(Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/foundation/pager/PagerSnapDistance;Lkotlin/jvm/functions/Function3;)Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;", BuildConfig.FLAVOR, "isLtrDragging", "(Landroidx/compose/foundation/pager/PagerState;)Z", "isScrollingForward", "dragGestureDelta", "(Landroidx/compose/foundation/pager/PagerState;)F", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "snapPositionalThreshold", "flingVelocity", "lowerBoundOffset", "upperBoundOffset", "(Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/ui/unit/LayoutDirection;FFFF)F", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class PagerSnapLayoutInfoProviderKt {
    public static final SnapLayoutInfoProvider SnapLayoutInfoProvider(final PagerState pagerState, final PagerSnapDistance pagerSnapDistance, final Function3<? super Float, ? super Float, ? super Float, Float> function3) {
        return new SnapLayoutInfoProvider() { // from class: androidx.compose.foundation.gestures.snapping.PagerSnapLayoutInfoProviderKt$SnapLayoutInfoProvider$1
            private final Pair<Float, Float> searchForSnappingBounds(SnapPosition snapPosition) {
                float f5;
                float dragGestureDelta;
                boolean isScrollingForward;
                boolean isScrollingForward2;
                List<PageInfo> visiblePagesInfo = getLayoutInfo().getVisiblePagesInfo();
                PagerState pagerState2 = PagerState.this;
                int size = visiblePagesInfo.size();
                float f6 = Float.NEGATIVE_INFINITY;
                float f7 = Float.POSITIVE_INFINITY;
                int i5 = 0;
                while (true) {
                    f5 = 0.0f;
                    if (i5 >= size) {
                        break;
                    }
                    PageInfo pageInfo = visiblePagesInfo.get(i5);
                    float calculateDistanceToDesiredSnapPosition = SnapPositionKt.calculateDistanceToDesiredSnapPosition(PagerLayoutInfoKt.getMainAxisViewportSize(getLayoutInfo()), getLayoutInfo().getBeforeContentPadding(), getLayoutInfo().getAfterContentPadding(), getLayoutInfo().getPageSize(), pageInfo.getOffset(), pageInfo.getIndex(), snapPosition, pagerState2.getPageCount());
                    if (calculateDistanceToDesiredSnapPosition <= 0.0f && calculateDistanceToDesiredSnapPosition > f6) {
                        f6 = calculateDistanceToDesiredSnapPosition;
                    }
                    if (calculateDistanceToDesiredSnapPosition >= 0.0f && calculateDistanceToDesiredSnapPosition < f7) {
                        f7 = calculateDistanceToDesiredSnapPosition;
                    }
                    i5++;
                }
                if (f6 == Float.NEGATIVE_INFINITY) {
                    f6 = f7;
                }
                if (f7 == Float.POSITIVE_INFINITY) {
                    f7 = f6;
                }
                dragGestureDelta = PagerSnapLayoutInfoProviderKt.dragGestureDelta(PagerState.this);
                boolean z5 = dragGestureDelta == 0.0f;
                if (!PagerState.this.getCanScrollForward()) {
                    if (!z5) {
                        isScrollingForward2 = PagerSnapLayoutInfoProviderKt.isScrollingForward(PagerState.this);
                        if (isScrollingForward2) {
                            f6 = 0.0f;
                            f7 = 0.0f;
                        }
                    }
                    f7 = 0.0f;
                }
                if (PagerState.this.getCanScrollBackward()) {
                    f5 = f6;
                } else if (!z5) {
                    isScrollingForward = PagerSnapLayoutInfoProviderKt.isScrollingForward(PagerState.this);
                    if (!isScrollingForward) {
                        f7 = 0.0f;
                    }
                }
                return TuplesKt.to(Float.valueOf(f5), Float.valueOf(f7));
            }

            @Override // androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider
            public float calculateApproachOffset(float velocity, float decayOffset) {
                int pageSize$foundation_release = PagerState.this.getPageSize$foundation_release() + PagerState.this.getPageSpacing$foundation_release();
                if (pageSize$foundation_release == 0) {
                    return 0.0f;
                }
                int firstVisiblePage = velocity < 0.0f ? PagerState.this.getFirstVisiblePage() + 1 : PagerState.this.getFirstVisiblePage();
                int coerceAtLeast = RangesKt.coerceAtLeast(Math.abs((RangesKt.coerceIn(pagerSnapDistance.calculateTargetPage(firstVisiblePage, RangesKt.coerceIn(((int) (decayOffset / pageSize$foundation_release)) + firstVisiblePage, 0, PagerState.this.getPageCount()), velocity, PagerState.this.getPageSize$foundation_release(), PagerState.this.getPageSpacing$foundation_release()), 0, PagerState.this.getPageCount()) - firstVisiblePage) * pageSize$foundation_release) - pageSize$foundation_release, 0);
                if (coerceAtLeast == 0) {
                    return coerceAtLeast;
                }
                return Math.signum(velocity) * coerceAtLeast;
            }

            @Override // androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider
            public float calculateSnapOffset(float velocity) {
                Pair<Float, Float> searchForSnappingBounds = searchForSnappingBounds(PagerState.this.getLayoutInfo().getSnapPosition());
                float floatValue = searchForSnappingBounds.component1().floatValue();
                float floatValue2 = searchForSnappingBounds.component2().floatValue();
                float floatValue3 = function3.invoke(Float.valueOf(velocity), Float.valueOf(floatValue), Float.valueOf(floatValue2)).floatValue();
                if (floatValue3 == floatValue || floatValue3 == floatValue2 || floatValue3 == 0.0f) {
                    if (isValidDistance(floatValue3)) {
                        return floatValue3;
                    }
                    return 0.0f;
                }
                throw new IllegalStateException(("Final Snapping Offset Should Be one of " + floatValue + ", " + floatValue2 + " or 0.0").toString());
            }

            public final PagerLayoutInfo getLayoutInfo() {
                return PagerState.this.getLayoutInfo();
            }

            public final boolean isValidDistance(float f5) {
                return (f5 == Float.POSITIVE_INFINITY || f5 == Float.NEGATIVE_INFINITY) ? false : true;
            }
        };
    }

    public static final float calculateFinalSnappingBound(PagerState pagerState, LayoutDirection layoutDirection, float f5, float f6, float f7, float f8) {
        boolean isScrollingForward = pagerState.getLayoutInfo().getOrientation() == Orientation.Vertical ? isScrollingForward(pagerState) : layoutDirection == LayoutDirection.Ltr ? isScrollingForward(pagerState) : !isScrollingForward(pagerState);
        int pageSize = pagerState.getLayoutInfo().getPageSize();
        float dragGestureDelta = pageSize == 0 ? 0.0f : dragGestureDelta(pagerState) / pageSize;
        float f9 = dragGestureDelta - ((int) dragGestureDelta);
        int calculateFinalSnappingItem = LazyListSnapLayoutInfoProviderKt.calculateFinalSnappingItem(pagerState.getDensity(), f6);
        FinalSnappingItem.Companion companion = FinalSnappingItem.INSTANCE;
        if (FinalSnappingItem.m252equalsimpl0(calculateFinalSnappingItem, companion.m253getClosestItembbeMdSM())) {
            if (Math.abs(f9) > f5) {
                if (!isScrollingForward) {
                    return f7;
                }
            } else if (Math.abs(dragGestureDelta) >= Math.abs(pagerState.getPositionThresholdFraction$foundation_release())) {
                if (isScrollingForward) {
                    return f7;
                }
            } else if (Math.abs(f7) < Math.abs(f8)) {
                return f7;
            }
        } else if (!FinalSnappingItem.m252equalsimpl0(calculateFinalSnappingItem, companion.m254getNextItembbeMdSM())) {
            if (FinalSnappingItem.m252equalsimpl0(calculateFinalSnappingItem, companion.m255getPreviousItembbeMdSM())) {
                return f7;
            }
            return 0.0f;
        }
        return f8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float dragGestureDelta(PagerState pagerState) {
        return pagerState.getLayoutInfo().getOrientation() == Orientation.Horizontal ? Offset.m1337getXimpl(pagerState.m447getUpDownDifferenceF1C5BW0$foundation_release()) : Offset.m1338getYimpl(pagerState.m447getUpDownDifferenceF1C5BW0$foundation_release());
    }

    private static final boolean isLtrDragging(PagerState pagerState) {
        return dragGestureDelta(pagerState) > 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isScrollingForward(PagerState pagerState) {
        boolean reverseLayout = pagerState.getLayoutInfo().getReverseLayout();
        return (isLtrDragging(pagerState) && reverseLayout) || !(isLtrDragging(pagerState) || reverseLayout);
    }
}
