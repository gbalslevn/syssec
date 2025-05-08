package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider;
import androidx.compose.foundation.lazy.layout.IntervalList;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001:\u0003()*B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u001e\u001a\u00020\u0006H\u0002J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0006J\u000e\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0006J\b\u0010$\u001a\u00020%H\u0002J\u0016\u0010&\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u0006R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0006@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\b\"\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\b¨\u0006+"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider;", BuildConfig.FLAVOR, "gridContent", "Landroidx/compose/foundation/lazy/grid/LazyGridIntervalContent;", "(Landroidx/compose/foundation/lazy/grid/LazyGridIntervalContent;)V", "bucketSize", BuildConfig.FLAVOR, "getBucketSize", "()I", "buckets", "Ljava/util/ArrayList;", "Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider$Bucket;", "Lkotlin/collections/ArrayList;", "cachedBucket", BuildConfig.FLAVOR, "cachedBucketIndex", "lastLineIndex", "lastLineStartItemIndex", "lastLineStartKnownSpan", "previousDefaultSpans", BuildConfig.FLAVOR, "Landroidx/compose/foundation/lazy/grid/GridItemSpan;", "value", "slotsPerLine", "getSlotsPerLine", "setSlotsPerLine", "(I)V", "totalSize", "getTotalSize", "getDefaultSpans", "currentSlotsPerLine", "getLineConfiguration", "Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider$LineConfiguration;", "lineIndex", "getLineIndexOfItem", "itemIndex", "invalidateCache", BuildConfig.FLAVOR, "spanOf", "maxSpan", "Bucket", "LazyGridItemSpanScopeImpl", "LineConfiguration", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LazyGridSpanLayoutProvider {
    private final ArrayList<Bucket> buckets;
    private final List<Integer> cachedBucket;
    private int cachedBucketIndex;
    private final LazyGridIntervalContent gridContent;
    private int lastLineIndex;
    private int lastLineStartItemIndex;
    private int lastLineStartKnownSpan;
    private List<GridItemSpan> previousDefaultSpans;
    private int slotsPerLine;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0005\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000b\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\n¨\u0006\u000e"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider$LazyGridItemSpanScopeImpl;", "Landroidx/compose/foundation/lazy/grid/LazyGridItemSpanScope;", "<init>", "()V", BuildConfig.FLAVOR, "maxCurrentLineSpan", "I", "getMaxCurrentLineSpan", "()I", "setMaxCurrentLineSpan", "(I)V", "maxLineSpan", "getMaxLineSpan", "setMaxLineSpan", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class LazyGridItemSpanScopeImpl implements LazyGridItemSpanScope {
        public static final LazyGridItemSpanScopeImpl INSTANCE = new LazyGridItemSpanScopeImpl();
        private static int maxCurrentLineSpan;
        private static int maxLineSpan;

        private LazyGridItemSpanScopeImpl() {
        }

        @Override // androidx.compose.foundation.lazy.grid.LazyGridItemSpanScope
        public int getMaxLineSpan() {
            return maxLineSpan;
        }

        public void setMaxCurrentLineSpan(int i5) {
            maxCurrentLineSpan = i5;
        }

        public void setMaxLineSpan(int i5) {
            maxLineSpan = i5;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider$LineConfiguration;", BuildConfig.FLAVOR, "firstItemIndex", BuildConfig.FLAVOR, "spans", BuildConfig.FLAVOR, "Landroidx/compose/foundation/lazy/grid/GridItemSpan;", "(ILjava/util/List;)V", "getFirstItemIndex", "()I", "getSpans", "()Ljava/util/List;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class LineConfiguration {
        private final int firstItemIndex;
        private final List<GridItemSpan> spans;

        public LineConfiguration(int i5, List<GridItemSpan> list) {
            this.firstItemIndex = i5;
            this.spans = list;
        }

        public final int getFirstItemIndex() {
            return this.firstItemIndex;
        }

        public final List<GridItemSpan> getSpans() {
            return this.spans;
        }
    }

    public LazyGridSpanLayoutProvider(LazyGridIntervalContent lazyGridIntervalContent) {
        this.gridContent = lazyGridIntervalContent;
        ArrayList<Bucket> arrayList = new ArrayList<>();
        int i5 = 0;
        arrayList.add(new Bucket(i5, i5, 2, null));
        this.buckets = arrayList;
        this.cachedBucketIndex = -1;
        this.cachedBucket = new ArrayList();
        this.previousDefaultSpans = CollectionsKt.emptyList();
    }

    private final int getBucketSize() {
        return ((int) Math.sqrt((getTotalSize() * 1.0d) / this.slotsPerLine)) + 1;
    }

    private final List<GridItemSpan> getDefaultSpans(int currentSlotsPerLine) {
        if (currentSlotsPerLine == this.previousDefaultSpans.size()) {
            return this.previousDefaultSpans;
        }
        ArrayList arrayList = new ArrayList(currentSlotsPerLine);
        for (int i5 = 0; i5 < currentSlotsPerLine; i5++) {
            arrayList.add(GridItemSpan.m380boximpl(LazyGridSpanKt.GridItemSpan(1)));
        }
        this.previousDefaultSpans = arrayList;
        return arrayList;
    }

    private final void invalidateCache() {
        this.buckets.clear();
        int i5 = 0;
        this.buckets.add(new Bucket(i5, i5, 2, null));
        this.lastLineIndex = 0;
        this.lastLineStartItemIndex = 0;
        this.lastLineStartKnownSpan = 0;
        this.cachedBucketIndex = -1;
        this.cachedBucket.clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x008d, code lost:
    
        if (r7 < r6) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final LineConfiguration getLineConfiguration(int lineIndex) {
        int i5;
        int i6;
        int i7;
        if (!this.gridContent.getHasCustomSpans()) {
            int i8 = lineIndex * this.slotsPerLine;
            return new LineConfiguration(i8, getDefaultSpans(RangesKt.coerceAtLeast(RangesKt.coerceAtMost(this.slotsPerLine, getTotalSize() - i8), 0)));
        }
        boolean z5 = true;
        int min = Math.min(lineIndex / getBucketSize(), this.buckets.size() - 1);
        int bucketSize = getBucketSize() * min;
        int firstItemIndex = this.buckets.get(min).getFirstItemIndex();
        int firstItemKnownSpan = this.buckets.get(min).getFirstItemKnownSpan();
        int i9 = this.lastLineIndex;
        if (bucketSize <= i9 && i9 <= lineIndex) {
            firstItemIndex = this.lastLineStartItemIndex;
            firstItemKnownSpan = this.lastLineStartKnownSpan;
            bucketSize = i9;
        } else if (min == this.cachedBucketIndex && (i5 = lineIndex - bucketSize) < this.cachedBucket.size()) {
            firstItemIndex = this.cachedBucket.get(i5).intValue();
            bucketSize = lineIndex;
            firstItemKnownSpan = 0;
        }
        if (bucketSize % getBucketSize() == 0) {
            int bucketSize2 = getBucketSize();
            int i10 = lineIndex - bucketSize;
            if (2 <= i10) {
            }
        }
        z5 = false;
        if (z5) {
            this.cachedBucketIndex = min;
            this.cachedBucket.clear();
        }
        if (bucketSize > lineIndex) {
            throw new IllegalStateException("currentLine > lineIndex");
        }
        while (bucketSize < lineIndex && firstItemIndex < getTotalSize()) {
            if (z5) {
                this.cachedBucket.add(Integer.valueOf(firstItemIndex));
            }
            int i11 = 0;
            while (i11 < this.slotsPerLine && firstItemIndex < getTotalSize()) {
                if (firstItemKnownSpan == 0) {
                    i7 = firstItemKnownSpan;
                    firstItemKnownSpan = spanOf(firstItemIndex, this.slotsPerLine - i11);
                } else {
                    i7 = 0;
                }
                i11 += firstItemKnownSpan;
                if (i11 > this.slotsPerLine) {
                    break;
                }
                firstItemIndex++;
                firstItemKnownSpan = i7;
            }
            bucketSize++;
            if (bucketSize % getBucketSize() == 0 && firstItemIndex < getTotalSize()) {
                if (this.buckets.size() != bucketSize / getBucketSize()) {
                    throw new IllegalStateException("invalid starting point");
                }
                this.buckets.add(new Bucket(firstItemIndex, firstItemKnownSpan));
            }
        }
        this.lastLineIndex = lineIndex;
        this.lastLineStartItemIndex = firstItemIndex;
        this.lastLineStartKnownSpan = firstItemKnownSpan;
        ArrayList arrayList = new ArrayList();
        int i12 = 0;
        int i13 = firstItemIndex;
        while (i12 < this.slotsPerLine && i13 < getTotalSize()) {
            if (firstItemKnownSpan == 0) {
                int i14 = firstItemKnownSpan;
                firstItemKnownSpan = spanOf(i13, this.slotsPerLine - i12);
                i6 = i14;
            } else {
                i6 = 0;
            }
            i12 += firstItemKnownSpan;
            if (i12 > this.slotsPerLine) {
                break;
            }
            i13++;
            arrayList.add(GridItemSpan.m380boximpl(LazyGridSpanKt.GridItemSpan(firstItemKnownSpan)));
            firstItemKnownSpan = i6;
        }
        return new LineConfiguration(firstItemIndex, arrayList);
    }

    public final int getLineIndexOfItem(final int itemIndex) {
        int i5 = 0;
        if (getTotalSize() <= 0) {
            return 0;
        }
        if (itemIndex >= getTotalSize()) {
            throw new IllegalArgumentException("ItemIndex > total count");
        }
        if (!this.gridContent.getHasCustomSpans()) {
            return itemIndex / this.slotsPerLine;
        }
        int binarySearch$default = CollectionsKt.binarySearch$default(this.buckets, 0, 0, new Function1<Bucket, Integer>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider$getLineIndexOfItem$lowerBoundBucket$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Integer invoke(LazyGridSpanLayoutProvider.Bucket bucket) {
                return Integer.valueOf(bucket.getFirstItemIndex() - itemIndex);
            }
        }, 3, (Object) null);
        int i6 = 2;
        if (binarySearch$default < 0) {
            binarySearch$default = (-binarySearch$default) - 2;
        }
        int bucketSize = getBucketSize() * binarySearch$default;
        int firstItemIndex = this.buckets.get(binarySearch$default).getFirstItemIndex();
        if (firstItemIndex > itemIndex) {
            throw new IllegalArgumentException("currentItemIndex > itemIndex");
        }
        int i7 = 0;
        while (firstItemIndex < itemIndex) {
            int i8 = firstItemIndex + 1;
            int spanOf = spanOf(firstItemIndex, this.slotsPerLine - i7);
            i7 += spanOf;
            int i9 = this.slotsPerLine;
            if (i7 >= i9) {
                if (i7 == i9) {
                    bucketSize++;
                    i7 = 0;
                } else {
                    bucketSize++;
                    i7 = spanOf;
                }
            }
            if (bucketSize % getBucketSize() == 0 && bucketSize / getBucketSize() >= this.buckets.size()) {
                this.buckets.add(new Bucket(i8 - (i7 > 0 ? 1 : 0), i5, i6, null));
            }
            firstItemIndex = i8;
        }
        return i7 + spanOf(itemIndex, this.slotsPerLine - i7) > this.slotsPerLine ? bucketSize + 1 : bucketSize;
    }

    public final int getSlotsPerLine() {
        return this.slotsPerLine;
    }

    public final int getTotalSize() {
        return this.gridContent.getIntervals().getSize();
    }

    public final void setSlotsPerLine(int i5) {
        if (i5 != this.slotsPerLine) {
            this.slotsPerLine = i5;
            invalidateCache();
        }
    }

    public final int spanOf(int itemIndex, int maxSpan) {
        LazyGridItemSpanScopeImpl lazyGridItemSpanScopeImpl = LazyGridItemSpanScopeImpl.INSTANCE;
        lazyGridItemSpanScopeImpl.setMaxCurrentLineSpan(maxSpan);
        lazyGridItemSpanScopeImpl.setMaxLineSpan(this.slotsPerLine);
        IntervalList.Interval<LazyGridInterval> interval = this.gridContent.getIntervals().get(itemIndex);
        return GridItemSpan.m383getCurrentLineSpanimpl(interval.getValue().getSpan().invoke(lazyGridItemSpanScopeImpl, Integer.valueOf(itemIndex - interval.getStartIndex())).getPackedValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider$Bucket;", BuildConfig.FLAVOR, "firstItemIndex", BuildConfig.FLAVOR, "firstItemKnownSpan", "(II)V", "getFirstItemIndex", "()I", "getFirstItemKnownSpan", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Bucket {
        private final int firstItemIndex;
        private final int firstItemKnownSpan;

        public Bucket(int i5, int i6) {
            this.firstItemIndex = i5;
            this.firstItemKnownSpan = i6;
        }

        public final int getFirstItemIndex() {
            return this.firstItemIndex;
        }

        public final int getFirstItemKnownSpan() {
            return this.firstItemKnownSpan;
        }

        public /* synthetic */ Bucket(int i5, int i6, int i7, DefaultConstructorMarker defaultConstructorMarker) {
            this(i5, (i7 & 2) != 0 ? 0 : i6);
        }
    }
}
