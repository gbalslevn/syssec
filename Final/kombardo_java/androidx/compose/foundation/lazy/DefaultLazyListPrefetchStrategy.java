package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.foundation.lazy.layout.NestedPrefetchScope;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\n\u001a\u00020\u000b*\u00020\f2\u0006\u0010\r\u001a\u00020\u0003H\u0016J\u001c\u0010\u000e\u001a\u00020\u000b*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0014\u0010\u0014\u001a\u00020\u000b*\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Landroidx/compose/foundation/lazy/DefaultLazyListPrefetchStrategy;", "Landroidx/compose/foundation/lazy/LazyListPrefetchStrategy;", "nestedPrefetchItemCount", BuildConfig.FLAVOR, "(I)V", "currentPrefetchHandle", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "indexToPrefetch", "wasScrollingForward", BuildConfig.FLAVOR, "onNestedPrefetch", BuildConfig.FLAVOR, "Landroidx/compose/foundation/lazy/layout/NestedPrefetchScope;", "firstVisibleItemIndex", "onScroll", "Landroidx/compose/foundation/lazy/LazyListPrefetchScope;", "delta", BuildConfig.FLAVOR, "layoutInfo", "Landroidx/compose/foundation/lazy/LazyListLayoutInfo;", "onVisibleItemsUpdated", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class DefaultLazyListPrefetchStrategy implements LazyListPrefetchStrategy {
    private LazyLayoutPrefetchState.PrefetchHandle currentPrefetchHandle;
    private int indexToPrefetch = -1;
    private final int nestedPrefetchItemCount;
    private boolean wasScrollingForward;

    public DefaultLazyListPrefetchStrategy(int i5) {
        this.nestedPrefetchItemCount = i5;
    }

    @Override // androidx.compose.foundation.lazy.LazyListPrefetchStrategy
    public void onNestedPrefetch(NestedPrefetchScope nestedPrefetchScope, int i5) {
        int i6 = this.nestedPrefetchItemCount;
        for (int i7 = 0; i7 < i6; i7++) {
            nestedPrefetchScope.schedulePrefetch(i5 + i7);
        }
    }

    @Override // androidx.compose.foundation.lazy.LazyListPrefetchStrategy
    public void onScroll(LazyListPrefetchScope lazyListPrefetchScope, float f5, LazyListLayoutInfo lazyListLayoutInfo) {
        LazyLayoutPrefetchState.PrefetchHandle prefetchHandle;
        LazyLayoutPrefetchState.PrefetchHandle prefetchHandle2;
        LazyLayoutPrefetchState.PrefetchHandle prefetchHandle3;
        if (lazyListLayoutInfo.getVisibleItemsInfo().isEmpty()) {
            return;
        }
        boolean z5 = f5 < 0.0f;
        int index = z5 ? ((LazyListItemInfo) CollectionsKt.last((List) lazyListLayoutInfo.getVisibleItemsInfo())).getIndex() + 1 : ((LazyListItemInfo) CollectionsKt.first((List) lazyListLayoutInfo.getVisibleItemsInfo())).getIndex() - 1;
        if (index < 0 || index >= lazyListLayoutInfo.getTotalItemsCount()) {
            return;
        }
        if (index != this.indexToPrefetch) {
            if (this.wasScrollingForward != z5 && (prefetchHandle3 = this.currentPrefetchHandle) != null) {
                prefetchHandle3.cancel();
            }
            this.wasScrollingForward = z5;
            this.indexToPrefetch = index;
            this.currentPrefetchHandle = lazyListPrefetchScope.schedulePrefetch(index);
        }
        if (!z5) {
            if (lazyListLayoutInfo.getViewportStartOffset() - ((LazyListItemInfo) CollectionsKt.first((List) lazyListLayoutInfo.getVisibleItemsInfo())).getOffset() >= f5 || (prefetchHandle = this.currentPrefetchHandle) == null) {
                return;
            }
            prefetchHandle.markAsUrgent();
            return;
        }
        LazyListItemInfo lazyListItemInfo = (LazyListItemInfo) CollectionsKt.last((List) lazyListLayoutInfo.getVisibleItemsInfo());
        if (((lazyListItemInfo.getOffset() + lazyListItemInfo.getSize()) + lazyListLayoutInfo.getMainAxisItemSpacing()) - lazyListLayoutInfo.getViewportEndOffset() >= (-f5) || (prefetchHandle2 = this.currentPrefetchHandle) == null) {
            return;
        }
        prefetchHandle2.markAsUrgent();
    }

    @Override // androidx.compose.foundation.lazy.LazyListPrefetchStrategy
    public void onVisibleItemsUpdated(LazyListPrefetchScope lazyListPrefetchScope, LazyListLayoutInfo lazyListLayoutInfo) {
        if (this.indexToPrefetch == -1 || lazyListLayoutInfo.getVisibleItemsInfo().isEmpty()) {
            return;
        }
        if (this.indexToPrefetch != (this.wasScrollingForward ? ((LazyListItemInfo) CollectionsKt.last((List) lazyListLayoutInfo.getVisibleItemsInfo())).getIndex() + 1 : ((LazyListItemInfo) CollectionsKt.first((List) lazyListLayoutInfo.getVisibleItemsInfo())).getIndex() - 1)) {
            this.indexToPrefetch = -1;
            LazyLayoutPrefetchState.PrefetchHandle prefetchHandle = this.currentPrefetchHandle;
            if (prefetchHandle != null) {
                prefetchHandle.cancel();
            }
            this.currentPrefetchHandle = null;
        }
    }
}
