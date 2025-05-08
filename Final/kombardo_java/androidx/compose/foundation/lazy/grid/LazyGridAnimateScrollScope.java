package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000e\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ#\u0010\u000f\u001a\u00020\u000e*\u00020\u000b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J4\u0010\u0019\u001a\u00020\u000e2\"\u0010\u0018\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0015H\u0096@¢\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010 \u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001dR\u0014\u0010\"\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u001dR\u0014\u0010$\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u001d¨\u0006%"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridAnimateScrollScope;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimateScrollScope;", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "state", "<init>", "(Landroidx/compose/foundation/lazy/grid/LazyGridState;)V", "Landroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;", "layoutInfo", BuildConfig.FLAVOR, "calculateLineAverageMainAxisSize", "(Landroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;)I", "Landroidx/compose/foundation/gestures/ScrollScope;", "index", "scrollOffset", BuildConfig.FLAVOR, "snapToItem", "(Landroidx/compose/foundation/gestures/ScrollScope;II)V", "targetIndex", BuildConfig.FLAVOR, "calculateDistanceTo", "(I)F", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", BuildConfig.FLAVOR, "block", "scroll", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "getFirstVisibleItemIndex", "()I", "firstVisibleItemIndex", "getFirstVisibleItemScrollOffset", "firstVisibleItemScrollOffset", "getLastVisibleItemIndex", "lastVisibleItemIndex", "getItemCount", "itemCount", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LazyGridAnimateScrollScope implements LazyLayoutAnimateScrollScope {
    private final LazyGridState state;

    public LazyGridAnimateScrollScope(LazyGridState lazyGridState) {
        this.state = lazyGridState;
    }

    private final int calculateLineAverageMainAxisSize(LazyGridLayoutInfo layoutInfo) {
        final boolean z5 = layoutInfo.getOrientation() == Orientation.Vertical;
        final List<LazyGridItemInfo> visibleItemsInfo = layoutInfo.getVisibleItemsInfo();
        Function1<Integer, Integer> function1 = new Function1<Integer, Integer>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridAnimateScrollScope$calculateLineAverageMainAxisSize$lineOf$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Integer invoke(int i5) {
                return Integer.valueOf(z5 ? visibleItemsInfo.get(i5).getRow() : visibleItemsInfo.get(i5).getColumn());
            }
        };
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i5 < visibleItemsInfo.size()) {
            int intValue = function1.invoke(Integer.valueOf(i5)).intValue();
            if (intValue == -1) {
                i5++;
            } else {
                int i8 = 0;
                while (i5 < visibleItemsInfo.size() && function1.invoke(Integer.valueOf(i5)).intValue() == intValue) {
                    i8 = Math.max(i8, z5 ? IntSize.m2660getHeightimpl(visibleItemsInfo.get(i5).getSize()) : IntSize.m2661getWidthimpl(visibleItemsInfo.get(i5).getSize()));
                    i5++;
                }
                i6 += i8;
                i7++;
            }
        }
        return (i6 / i7) + layoutInfo.getMainAxisItemSpacing();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope
    public float calculateDistanceTo(int targetIndex) {
        LazyGridItemInfo lazyGridItemInfo;
        LazyGridLayoutInfo layoutInfo = this.state.getLayoutInfo();
        if (layoutInfo.getVisibleItemsInfo().isEmpty()) {
            return 0.0f;
        }
        List<LazyGridItemInfo> visibleItemsInfo = layoutInfo.getVisibleItemsInfo();
        int size = visibleItemsInfo.size();
        int i5 = 0;
        while (true) {
            if (i5 >= size) {
                lazyGridItemInfo = null;
                break;
            }
            lazyGridItemInfo = visibleItemsInfo.get(i5);
            if (lazyGridItemInfo.getIndex() == targetIndex) {
                break;
            }
            i5++;
        }
        if (lazyGridItemInfo != null) {
            return layoutInfo.getOrientation() == Orientation.Vertical ? IntOffset.m2641getYimpl(r5.getOffset()) : IntOffset.m2640getXimpl(r5.getOffset());
        }
        int slotsPerLine$foundation_release = this.state.getSlotsPerLine$foundation_release();
        return (calculateLineAverageMainAxisSize(layoutInfo) * (((targetIndex - getFirstVisibleItemIndex()) + ((slotsPerLine$foundation_release - 1) * (targetIndex < getFirstVisibleItemIndex() ? -1 : 1))) / slotsPerLine$foundation_release)) - getFirstVisibleItemScrollOffset();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope
    public int getFirstVisibleItemIndex() {
        return this.state.getFirstVisibleItemIndex();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope
    public int getFirstVisibleItemScrollOffset() {
        return this.state.getFirstVisibleItemScrollOffset();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope
    public int getItemCount() {
        return this.state.getLayoutInfo().getTotalItemsCount();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope
    public int getLastVisibleItemIndex() {
        LazyGridItemInfo lazyGridItemInfo = (LazyGridItemInfo) CollectionsKt.lastOrNull((List) this.state.getLayoutInfo().getVisibleItemsInfo());
        if (lazyGridItemInfo != null) {
            return lazyGridItemInfo.getIndex();
        }
        return 0;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope
    public Object scroll(Function2<? super ScrollScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object scroll$default = ScrollableState.scroll$default(this.state, null, function2, continuation, 1, null);
        return scroll$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? scroll$default : Unit.INSTANCE;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope
    public void snapToItem(ScrollScope scrollScope, int i5, int i6) {
        this.state.snapToItemIndexInternal$foundation_release(i5, i6, true);
    }
}
