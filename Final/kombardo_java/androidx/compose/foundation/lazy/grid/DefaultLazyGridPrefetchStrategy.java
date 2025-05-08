package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.LazyGridSnapLayoutInfoProviderKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.foundation.lazy.layout.NestedPrefetchScope;
import androidx.compose.runtime.collection.MutableVector;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003H\u0016J\u001c\u0010\u000f\u001a\u00020\f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0014\u0010\u0015\u001a\u00020\f*\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Landroidx/compose/foundation/lazy/grid/DefaultLazyGridPrefetchStrategy;", "Landroidx/compose/foundation/lazy/grid/LazyGridPrefetchStrategy;", "nestedPrefetchItemCount", BuildConfig.FLAVOR, "(I)V", "currentLinePrefetchHandles", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "lineToPrefetch", "wasScrollingForward", BuildConfig.FLAVOR, "onNestedPrefetch", BuildConfig.FLAVOR, "Landroidx/compose/foundation/lazy/layout/NestedPrefetchScope;", "firstVisibleItemIndex", "onScroll", "Landroidx/compose/foundation/lazy/grid/LazyGridPrefetchScope;", "delta", BuildConfig.FLAVOR, "layoutInfo", "Landroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;", "onVisibleItemsUpdated", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class DefaultLazyGridPrefetchStrategy implements LazyGridPrefetchStrategy {
    private final int nestedPrefetchItemCount;
    private boolean wasScrollingForward;
    private int lineToPrefetch = -1;
    private final MutableVector<LazyLayoutPrefetchState.PrefetchHandle> currentLinePrefetchHandles = new MutableVector<>(new LazyLayoutPrefetchState.PrefetchHandle[16], 0);

    public DefaultLazyGridPrefetchStrategy(int i5) {
        this.nestedPrefetchItemCount = i5;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridPrefetchStrategy
    public void onNestedPrefetch(NestedPrefetchScope nestedPrefetchScope, int i5) {
        int i6 = this.nestedPrefetchItemCount;
        for (int i7 = 0; i7 < i6; i7++) {
            nestedPrefetchScope.schedulePrefetch(i5 + i7);
        }
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridPrefetchStrategy
    public void onScroll(LazyGridPrefetchScope lazyGridPrefetchScope, float f5, LazyGridLayoutInfo lazyGridLayoutInfo) {
        int row;
        int index;
        MutableVector<LazyLayoutPrefetchState.PrefetchHandle> mutableVector;
        int size;
        MutableVector<LazyLayoutPrefetchState.PrefetchHandle> mutableVector2;
        int size2;
        MutableVector<LazyLayoutPrefetchState.PrefetchHandle> mutableVector3;
        int size3;
        if (lazyGridLayoutInfo.getVisibleItemsInfo().isEmpty()) {
            return;
        }
        int i5 = 0;
        boolean z5 = f5 < 0.0f;
        if (z5) {
            LazyGridItemInfo lazyGridItemInfo = (LazyGridItemInfo) CollectionsKt.last((List) lazyGridLayoutInfo.getVisibleItemsInfo());
            row = (lazyGridLayoutInfo.getOrientation() == Orientation.Vertical ? lazyGridItemInfo.getRow() : lazyGridItemInfo.getColumn()) + 1;
            index = ((LazyGridItemInfo) CollectionsKt.last((List) lazyGridLayoutInfo.getVisibleItemsInfo())).getIndex() + 1;
        } else {
            LazyGridItemInfo lazyGridItemInfo2 = (LazyGridItemInfo) CollectionsKt.first((List) lazyGridLayoutInfo.getVisibleItemsInfo());
            row = (lazyGridLayoutInfo.getOrientation() == Orientation.Vertical ? lazyGridItemInfo2.getRow() : lazyGridItemInfo2.getColumn()) - 1;
            index = ((LazyGridItemInfo) CollectionsKt.first((List) lazyGridLayoutInfo.getVisibleItemsInfo())).getIndex() - 1;
        }
        if (index < 0 || index >= lazyGridLayoutInfo.getTotalItemsCount()) {
            return;
        }
        if (row != this.lineToPrefetch && row >= 0) {
            if (this.wasScrollingForward != z5 && (size3 = (mutableVector3 = this.currentLinePrefetchHandles).getSize()) > 0) {
                LazyLayoutPrefetchState.PrefetchHandle[] content = mutableVector3.getContent();
                int i6 = 0;
                do {
                    content[i6].cancel();
                    i6++;
                } while (i6 < size3);
            }
            this.wasScrollingForward = z5;
            this.lineToPrefetch = row;
            this.currentLinePrefetchHandles.clear();
            MutableVector<LazyLayoutPrefetchState.PrefetchHandle> mutableVector4 = this.currentLinePrefetchHandles;
            mutableVector4.addAll(mutableVector4.getSize(), (List<? extends LazyLayoutPrefetchState.PrefetchHandle>) lazyGridPrefetchScope.scheduleLinePrefetch(row));
        }
        if (!z5) {
            if (lazyGridLayoutInfo.getViewportStartOffset() - LazyGridSnapLayoutInfoProviderKt.offsetOnMainAxis((LazyGridItemInfo) CollectionsKt.first((List) lazyGridLayoutInfo.getVisibleItemsInfo()), lazyGridLayoutInfo.getOrientation()) >= f5 || (size = (mutableVector = this.currentLinePrefetchHandles).getSize()) <= 0) {
                return;
            }
            LazyLayoutPrefetchState.PrefetchHandle[] content2 = mutableVector.getContent();
            do {
                content2[i5].markAsUrgent();
                i5++;
            } while (i5 < size);
            return;
        }
        LazyGridItemInfo lazyGridItemInfo3 = (LazyGridItemInfo) CollectionsKt.last((List) lazyGridLayoutInfo.getVisibleItemsInfo());
        if (((LazyGridSnapLayoutInfoProviderKt.offsetOnMainAxis(lazyGridItemInfo3, lazyGridLayoutInfo.getOrientation()) + LazyGridSnapLayoutInfoProviderKt.sizeOnMainAxis(lazyGridItemInfo3, lazyGridLayoutInfo.getOrientation())) + lazyGridLayoutInfo.getMainAxisItemSpacing()) - lazyGridLayoutInfo.getViewportEndOffset() >= (-f5) || (size2 = (mutableVector2 = this.currentLinePrefetchHandles).getSize()) <= 0) {
            return;
        }
        LazyLayoutPrefetchState.PrefetchHandle[] content3 = mutableVector2.getContent();
        do {
            content3[i5].markAsUrgent();
            i5++;
        } while (i5 < size2);
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridPrefetchStrategy
    public void onVisibleItemsUpdated(LazyGridPrefetchScope lazyGridPrefetchScope, LazyGridLayoutInfo lazyGridLayoutInfo) {
        int row;
        if (this.lineToPrefetch == -1 || lazyGridLayoutInfo.getVisibleItemsInfo().isEmpty()) {
            return;
        }
        if (this.wasScrollingForward) {
            LazyGridItemInfo lazyGridItemInfo = (LazyGridItemInfo) CollectionsKt.last((List) lazyGridLayoutInfo.getVisibleItemsInfo());
            row = (lazyGridLayoutInfo.getOrientation() == Orientation.Vertical ? lazyGridItemInfo.getRow() : lazyGridItemInfo.getColumn()) + 1;
        } else {
            LazyGridItemInfo lazyGridItemInfo2 = (LazyGridItemInfo) CollectionsKt.first((List) lazyGridLayoutInfo.getVisibleItemsInfo());
            row = (lazyGridLayoutInfo.getOrientation() == Orientation.Vertical ? lazyGridItemInfo2.getRow() : lazyGridItemInfo2.getColumn()) - 1;
        }
        if (this.lineToPrefetch != row) {
            this.lineToPrefetch = -1;
            MutableVector<LazyLayoutPrefetchState.PrefetchHandle> mutableVector = this.currentLinePrefetchHandles;
            int size = mutableVector.getSize();
            if (size > 0) {
                LazyLayoutPrefetchState.PrefetchHandle[] content = mutableVector.getContent();
                int i5 = 0;
                do {
                    content[i5].cancel();
                    i5++;
                } while (i5 < size);
            }
            this.currentLinePrefetchHandles.clear();
        }
    }
}
