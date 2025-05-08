package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemProviderKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutNearestRangeState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.SnapshotIntStateKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003J\u0018\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003H\u0002J\u000e\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u0003J\u0016\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\"2\u0006\u0010\t\u001a\u00020\u0003R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00038F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R+\u0010\u0015\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00038F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u000f\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\r¨\u0006#"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridScrollPosition;", BuildConfig.FLAVOR, "initialIndex", BuildConfig.FLAVOR, "initialScrollOffset", "(II)V", "hadFirstNotEmptyLayout", BuildConfig.FLAVOR, "<set-?>", "index", "getIndex", "()I", "setIndex", "(I)V", "index$delegate", "Landroidx/compose/runtime/MutableIntState;", "lastKnownFirstItemKey", "nearestRangeState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutNearestRangeState;", "getNearestRangeState", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutNearestRangeState;", "scrollOffset", "getScrollOffset", "setScrollOffset", "scrollOffset$delegate", "requestPositionAndForgetLastKnownKey", BuildConfig.FLAVOR, "update", "updateFromMeasureResult", "measureResult", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "updateScrollOffset", "updateScrollPositionIfTheFirstItemWasMoved", "itemProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridItemProvider;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LazyGridScrollPosition {
    private boolean hadFirstNotEmptyLayout;

    /* renamed from: index$delegate, reason: from kotlin metadata */
    private final MutableIntState index;
    private Object lastKnownFirstItemKey;
    private final LazyLayoutNearestRangeState nearestRangeState;

    /* renamed from: scrollOffset$delegate, reason: from kotlin metadata */
    private final MutableIntState scrollOffset;

    public LazyGridScrollPosition(int i5, int i6) {
        this.index = SnapshotIntStateKt.mutableIntStateOf(i5);
        this.scrollOffset = SnapshotIntStateKt.mutableIntStateOf(i6);
        this.nearestRangeState = new LazyLayoutNearestRangeState(i5, 90, 200);
    }

    private final void setIndex(int i5) {
        this.index.setIntValue(i5);
    }

    private final void setScrollOffset(int i5) {
        this.scrollOffset.setIntValue(i5);
    }

    private final void update(int index, int scrollOffset) {
        if (index >= 0.0f) {
            setIndex(index);
            this.nearestRangeState.update(index);
            setScrollOffset(scrollOffset);
        } else {
            throw new IllegalArgumentException(("Index should be non-negative (" + index + ')').toString());
        }
    }

    public final int getIndex() {
        return this.index.getIntValue();
    }

    public final LazyLayoutNearestRangeState getNearestRangeState() {
        return this.nearestRangeState;
    }

    public final int getScrollOffset() {
        return this.scrollOffset.getIntValue();
    }

    public final void requestPositionAndForgetLastKnownKey(int index, int scrollOffset) {
        update(index, scrollOffset);
        this.lastKnownFirstItemKey = null;
    }

    public final void updateFromMeasureResult(LazyGridMeasureResult measureResult) {
        LazyGridMeasuredItem[] items;
        LazyGridMeasuredItem lazyGridMeasuredItem;
        LazyGridMeasuredItem[] items2;
        LazyGridMeasuredItem lazyGridMeasuredItem2;
        LazyGridMeasuredLine firstVisibleLine = measureResult.getFirstVisibleLine();
        this.lastKnownFirstItemKey = (firstVisibleLine == null || (items2 = firstVisibleLine.getItems()) == null || (lazyGridMeasuredItem2 = (LazyGridMeasuredItem) ArraysKt.firstOrNull(items2)) == null) ? null : lazyGridMeasuredItem2.getKey();
        if (this.hadFirstNotEmptyLayout || measureResult.getTotalItemsCount() > 0) {
            this.hadFirstNotEmptyLayout = true;
            int firstVisibleLineScrollOffset = measureResult.getFirstVisibleLineScrollOffset();
            if (firstVisibleLineScrollOffset >= 0.0f) {
                LazyGridMeasuredLine firstVisibleLine2 = measureResult.getFirstVisibleLine();
                update((firstVisibleLine2 == null || (items = firstVisibleLine2.getItems()) == null || (lazyGridMeasuredItem = (LazyGridMeasuredItem) ArraysKt.firstOrNull(items)) == null) ? 0 : lazyGridMeasuredItem.getIndex(), firstVisibleLineScrollOffset);
            } else {
                throw new IllegalStateException(("scrollOffset should be non-negative (" + firstVisibleLineScrollOffset + ')').toString());
            }
        }
    }

    public final void updateScrollOffset(int scrollOffset) {
        if (scrollOffset >= 0.0f) {
            setScrollOffset(scrollOffset);
            return;
        }
        throw new IllegalStateException(("scrollOffset should be non-negative (" + scrollOffset + ')').toString());
    }

    public final int updateScrollPositionIfTheFirstItemWasMoved(LazyGridItemProvider itemProvider, int index) {
        int findIndexByKey = LazyLayoutItemProviderKt.findIndexByKey(itemProvider, this.lastKnownFirstItemKey, index);
        if (index != findIndexByKey) {
            setIndex(findIndexByKey);
            this.nearestRangeState.update(index);
        }
        return findIndexByKey;
    }
}
