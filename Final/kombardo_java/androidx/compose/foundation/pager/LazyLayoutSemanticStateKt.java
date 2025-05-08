package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState;
import androidx.compose.ui.semantics.CollectionInfo;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000¨\u0006\u0006"}, d2 = {"LazyLayoutSemanticState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutSemanticState;", "state", "Landroidx/compose/foundation/pager/PagerState;", "isVertical", BuildConfig.FLAVOR, "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class LazyLayoutSemanticStateKt {
    public static final LazyLayoutSemanticState LazyLayoutSemanticState(final PagerState pagerState, final boolean z5) {
        return new LazyLayoutSemanticState() { // from class: androidx.compose.foundation.pager.LazyLayoutSemanticStateKt$LazyLayoutSemanticState$1
            @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
            public CollectionInfo collectionInfo() {
                return z5 ? new CollectionInfo(PagerState.this.getPageCount(), 1) : new CollectionInfo(1, PagerState.this.getPageCount());
            }

            @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
            public int getContentPadding() {
                return PagerState.this.getLayoutInfo().getBeforeContentPadding() + PagerState.this.getLayoutInfo().getAfterContentPadding();
            }

            @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
            public float getMaxScrollOffset() {
                return (float) PagerStateKt.calculateNewMaxScrollOffset(PagerState.this.getLayoutInfo(), PagerState.this.getPageCount());
            }

            @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
            public float getScrollOffset() {
                return (float) PagerScrollPositionKt.currentAbsoluteScrollOffset(PagerState.this);
            }

            @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
            public int getViewport() {
                return PagerState.this.getLayoutInfo().getOrientation() == Orientation.Vertical ? IntSize.m2660getHeightimpl(PagerState.this.getLayoutInfo().mo439getViewportSizeYbymL2g()) : IntSize.m2661getWidthimpl(PagerState.this.getLayoutInfo().mo439getViewportSizeYbymL2g());
            }

            @Override // androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState
            public Object scrollToItem(int i5, Continuation<? super Unit> continuation) {
                Object scrollToPage$default = PagerState.scrollToPage$default(PagerState.this, i5, 0.0f, continuation, 2, null);
                return scrollToPage$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? scrollToPage$default : Unit.INSTANCE;
            }
        };
    }
}
