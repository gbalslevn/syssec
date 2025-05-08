package androidx.compose.foundation.lazy;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0004\u001aF\u0010\u0000\u001a\u0004\u0018\u00010\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0000¨\u0006\f"}, d2 = {"findOrComposeLazyListHeader", "Landroidx/compose/foundation/lazy/LazyListMeasuredItem;", "composedVisibleItems", BuildConfig.FLAVOR, "itemProvider", "Landroidx/compose/foundation/lazy/LazyListMeasuredItemProvider;", "headerIndexes", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "beforeContentPadding", "layoutWidth", "layoutHeight", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class LazyListHeadersKt {
    public static final LazyListMeasuredItem findOrComposeLazyListHeader(List<LazyListMeasuredItem> list, LazyListMeasuredItemProvider lazyListMeasuredItemProvider, List<Integer> list2, int i5, int i6, int i7) {
        int index = ((LazyListMeasuredItem) CollectionsKt.first((List) list)).getIndex();
        int size = list2.size();
        int i8 = -1;
        int i9 = -1;
        int i10 = 0;
        while (i10 < size && list2.get(i10).intValue() <= index) {
            i9 = list2.get(i10).intValue();
            i10++;
            i8 = ((i10 < 0 || i10 > CollectionsKt.getLastIndex(list2)) ? -1 : list2.get(i10)).intValue();
        }
        int size2 = list.size();
        int i11 = Integer.MIN_VALUE;
        int i12 = Integer.MIN_VALUE;
        int i13 = -1;
        for (int i14 = 0; i14 < size2; i14++) {
            LazyListMeasuredItem lazyListMeasuredItem = list.get(i14);
            if (lazyListMeasuredItem.getIndex() == i9) {
                i11 = lazyListMeasuredItem.getOffset();
                i13 = i14;
            } else if (lazyListMeasuredItem.getIndex() == i8) {
                i12 = lazyListMeasuredItem.getOffset();
            }
        }
        if (i9 == -1) {
            return null;
        }
        LazyListMeasuredItem m374getAndMeasure0kLqBqw$default = LazyListMeasuredItemProvider.m374getAndMeasure0kLqBqw$default(lazyListMeasuredItemProvider, i9, 0L, 2, null);
        m374getAndMeasure0kLqBqw$default.setNonScrollableItem(true);
        int max = i11 != Integer.MIN_VALUE ? Math.max(-i5, i11) : -i5;
        if (i12 != Integer.MIN_VALUE) {
            max = Math.min(max, i12 - m374getAndMeasure0kLqBqw$default.getSize());
        }
        m374getAndMeasure0kLqBqw$default.position(max, i6, i7);
        if (i13 != -1) {
            list.set(i13, m374getAndMeasure0kLqBqw$default);
        } else {
            list.add(0, m374getAndMeasure0kLqBqw$default);
        }
        return m374getAndMeasure0kLqBqw$default;
    }
}
