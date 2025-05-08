package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¨\u0006\u0004"}, d2 = {"PagerLazyAnimateScrollScope", "Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimateScrollScope;", "state", "Landroidx/compose/foundation/pager/PagerState;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class PagerLazyAnimateScrollScopeKt {
    public static final LazyLayoutAnimateScrollScope PagerLazyAnimateScrollScope(final PagerState pagerState) {
        return new LazyLayoutAnimateScrollScope() { // from class: androidx.compose.foundation.pager.PagerLazyAnimateScrollScopeKt$PagerLazyAnimateScrollScope$1
            private final int getVisibleItemsAverageSize() {
                return PagerState.this.getPageSize$foundation_release() + PagerState.this.getPageSpacing$foundation_release();
            }

            @Override // androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope
            public float calculateDistanceTo(int targetIndex) {
                PageInfo pageInfo;
                List<PageInfo> visiblePagesInfo = PagerState.this.getLayoutInfo().getVisiblePagesInfo();
                int size = visiblePagesInfo.size();
                int i5 = 0;
                while (true) {
                    if (i5 >= size) {
                        pageInfo = null;
                        break;
                    }
                    pageInfo = visiblePagesInfo.get(i5);
                    if (pageInfo.getIndex() == targetIndex) {
                        break;
                    }
                    i5++;
                }
                return pageInfo == null ? ((targetIndex - PagerState.this.getCurrentPage()) * getVisibleItemsAverageSize()) - (PagerState.this.getCurrentPageOffsetFraction() * PagerState.this.getPageSizeWithSpacing$foundation_release()) : r3.getOffset();
            }

            @Override // androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope
            public int getFirstVisibleItemIndex() {
                return PagerState.this.getFirstVisiblePage();
            }

            @Override // androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope
            public int getFirstVisibleItemScrollOffset() {
                return PagerState.this.getFirstVisiblePageOffset();
            }

            @Override // androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope
            public int getItemCount() {
                return PagerState.this.getPageCount();
            }

            @Override // androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope
            public int getLastVisibleItemIndex() {
                return ((PageInfo) CollectionsKt.last((List) PagerState.this.getLayoutInfo().getVisiblePagesInfo())).getIndex();
            }

            @Override // androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope
            public Object scroll(Function2<? super ScrollScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
                Object scroll$default = ScrollableState.scroll$default(PagerState.this, null, function2, continuation, 1, null);
                return scroll$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? scroll$default : Unit.INSTANCE;
            }

            @Override // androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope
            public void snapToItem(ScrollScope scrollScope, int i5, int i6) {
                PagerState.this.snapToItem$foundation_release(i5, i6 / PagerState.this.getPageSizeWithSpacing$foundation_release(), true);
            }
        };
    }
}
