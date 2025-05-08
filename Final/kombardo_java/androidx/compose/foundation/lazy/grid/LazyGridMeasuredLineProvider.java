package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider;
import androidx.compose.ui.unit.Constraints;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.ranges.RangesKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\b \u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ%\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0006¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0006¢\u0006\u0004\b\u001a\u0010\u001bJ;\u0010#\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u00062\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010\"\u001a\u00020\u0006H&¢\u0006\u0004\b#\u0010$R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010%R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010&R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010'R\u0014\u0010\b\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010'R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010(R\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010)\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006*"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLineProvider;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "isVertical", "Landroidx/compose/foundation/lazy/grid/LazyGridSlots;", "slots", BuildConfig.FLAVOR, "gridItemsCount", "spaceBetweenLines", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItemProvider;", "measuredItemProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider;", "spanLayoutProvider", "<init>", "(ZLandroidx/compose/foundation/lazy/grid/LazyGridSlots;IILandroidx/compose/foundation/lazy/grid/LazyGridMeasuredItemProvider;Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider;)V", "startSlot", "span", "Landroidx/compose/ui/unit/Constraints;", "childConstraints-JhjzzOo$foundation_release", "(II)J", "childConstraints", "index", "spanOf", "(I)I", "lineIndex", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLine;", "getAndMeasure", "(I)Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLine;", BuildConfig.FLAVOR, "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "items", BuildConfig.FLAVOR, "Landroidx/compose/foundation/lazy/grid/GridItemSpan;", "spans", "mainAxisSpacing", "createLine", "(I[Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;Ljava/util/List;I)Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLine;", "Z", "Landroidx/compose/foundation/lazy/grid/LazyGridSlots;", "I", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItemProvider;", "Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class LazyGridMeasuredLineProvider {
    private final int gridItemsCount;
    private final boolean isVertical;
    private final LazyGridMeasuredItemProvider measuredItemProvider;
    private final LazyGridSlots slots;
    private final int spaceBetweenLines;
    private final LazyGridSpanLayoutProvider spanLayoutProvider;

    public LazyGridMeasuredLineProvider(boolean z5, LazyGridSlots lazyGridSlots, int i5, int i6, LazyGridMeasuredItemProvider lazyGridMeasuredItemProvider, LazyGridSpanLayoutProvider lazyGridSpanLayoutProvider) {
        this.isVertical = z5;
        this.slots = lazyGridSlots;
        this.gridItemsCount = i5;
        this.spaceBetweenLines = i6;
        this.measuredItemProvider = lazyGridMeasuredItemProvider;
        this.spanLayoutProvider = lazyGridSpanLayoutProvider;
    }

    /* renamed from: childConstraints-JhjzzOo$foundation_release, reason: not valid java name */
    public final long m399childConstraintsJhjzzOo$foundation_release(int startSlot, int span) {
        int i5;
        if (span == 1) {
            i5 = this.slots.getSizes()[startSlot];
        } else {
            int i6 = (span + startSlot) - 1;
            i5 = (this.slots.getPositions()[i6] + this.slots.getSizes()[i6]) - this.slots.getPositions()[startSlot];
        }
        int coerceAtLeast = RangesKt.coerceAtLeast(i5, 0);
        return this.isVertical ? Constraints.INSTANCE.m2589fixedWidthOenEA2s(coerceAtLeast) : Constraints.INSTANCE.m2588fixedHeightOenEA2s(coerceAtLeast);
    }

    public abstract LazyGridMeasuredLine createLine(int index, LazyGridMeasuredItem[] items, List<GridItemSpan> spans, int mainAxisSpacing);

    public final LazyGridMeasuredLine getAndMeasure(int lineIndex) {
        LazyGridSpanLayoutProvider.LineConfiguration lineConfiguration = this.spanLayoutProvider.getLineConfiguration(lineIndex);
        int size = lineConfiguration.getSpans().size();
        int i5 = (size == 0 || lineConfiguration.getFirstItemIndex() + size == this.gridItemsCount) ? 0 : this.spaceBetweenLines;
        LazyGridMeasuredItem[] lazyGridMeasuredItemArr = new LazyGridMeasuredItem[size];
        int i6 = 0;
        for (int i7 = 0; i7 < size; i7++) {
            int m383getCurrentLineSpanimpl = GridItemSpan.m383getCurrentLineSpanimpl(lineConfiguration.getSpans().get(i7).getPackedValue());
            LazyGridMeasuredItem m398getAndMeasurem8Kt_7k = this.measuredItemProvider.m398getAndMeasurem8Kt_7k(lineConfiguration.getFirstItemIndex() + i7, m399childConstraintsJhjzzOo$foundation_release(i6, m383getCurrentLineSpanimpl), i6, m383getCurrentLineSpanimpl, i5);
            i6 += m383getCurrentLineSpanimpl;
            Unit unit = Unit.INSTANCE;
            lazyGridMeasuredItemArr[i7] = m398getAndMeasurem8Kt_7k;
        }
        return createLine(lineIndex, lazyGridMeasuredItemArr, lineConfiguration.getSpans(), i5);
    }

    public final int spanOf(int index) {
        LazyGridSpanLayoutProvider lazyGridSpanLayoutProvider = this.spanLayoutProvider;
        return lazyGridSpanLayoutProvider.spanOf(index, lazyGridSpanLayoutProvider.getSlotsPerLine());
    }
}
