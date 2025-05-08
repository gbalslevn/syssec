package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.LazyGridSnapLayoutInfoProviderKt;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.RulerScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b.\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B½\u0001\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012$\u0010\u0016\u001a \u0012\u0004\u0012\u00020\u0005\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00150\u00140\u00130\u0012\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0013\u0012\u0006\u0010\u0019\u001a\u00020\u0005\u0012\u0006\u0010\u001a\u001a\u00020\u0005\u0012\u0006\u0010\u001b\u001a\u00020\u0005\u0012\u0006\u0010\u001c\u001a\u00020\u0007\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\u0006\u0010\u001f\u001a\u00020\u0005\u0012\u0006\u0010 \u001a\u00020\u0005¢\u0006\u0004\b!\u0010\"J\u0010\u0010$\u001a\u00020#H\u0096\u0001¢\u0006\u0004\b$\u0010%J\u0015\u0010'\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0005¢\u0006\u0004\b'\u0010(R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010)\u001a\u0004\b*\u0010+R\"\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u0017\u0010\f\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\f\u00101\u001a\u0004\b;\u00103R\u0017\u0010\u000e\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010<\u001a\u0004\b=\u0010>R\u0017\u0010\u0010\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010?\u001a\u0004\b@\u0010AR\u0017\u0010\u0011\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0011\u0010,\u001a\u0004\bB\u0010.R5\u0010\u0016\u001a \u0012\u0004\u0012\u00020\u0005\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00150\u00140\u00130\u00128\u0006¢\u0006\f\n\u0004\b\u0016\u0010C\u001a\u0004\bD\u0010ER \u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010F\u001a\u0004\bG\u0010HR\u001a\u0010\u0019\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0019\u0010,\u001a\u0004\bI\u0010.R\u001a\u0010\u001a\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001a\u0010,\u001a\u0004\bJ\u0010.R\u001a\u0010\u001b\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001b\u0010,\u001a\u0004\bK\u0010.R\u001a\u0010\u001c\u001a\u00020\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001c\u00101\u001a\u0004\bL\u00103R\u001a\u0010\u001e\u001a\u00020\u001d8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001e\u0010M\u001a\u0004\bN\u0010OR\u001a\u0010\u001f\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001f\u0010,\u001a\u0004\bP\u0010.R\u001a\u0010 \u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b \u0010,\u001a\u0004\bQ\u0010.R \u0010V\u001a\u000e\u0012\u0004\u0012\u00020S\u0012\u0004\u0012\u00020\u00050R8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bT\u0010UR\u0014\u0010X\u001a\u00020\u00058\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bW\u0010.R\"\u0010[\u001a\u0010\u0012\u0004\u0012\u00020Y\u0012\u0004\u0012\u00020#\u0018\u00010\u00128VX\u0096\u0005¢\u0006\u0006\u001a\u0004\bZ\u0010ER\u0014\u0010]\u001a\u00020\u00058\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\\\u0010.R\u0011\u0010_\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b^\u00103R\u001a\u0010c\u001a\u00020`8VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\ba\u0010bR\u0014\u0010e\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bd\u0010.\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006f"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "Landroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLine;", "firstVisibleLine", BuildConfig.FLAVOR, "firstVisibleLineScrollOffset", BuildConfig.FLAVOR, "canScrollForward", BuildConfig.FLAVOR, "consumedScroll", "measureResult", "remeasureNeeded", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "Landroidx/compose/ui/unit/Density;", "density", "slotsPerLine", "Lkotlin/Function1;", BuildConfig.FLAVOR, "Lkotlin/Pair;", "Landroidx/compose/ui/unit/Constraints;", "prefetchInfoRetriever", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "visibleItemsInfo", "viewportStartOffset", "viewportEndOffset", "totalItemsCount", "reverseLayout", "Landroidx/compose/foundation/gestures/Orientation;", "orientation", "afterContentPadding", "mainAxisItemSpacing", "<init>", "(Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLine;IZFLandroidx/compose/ui/layout/MeasureResult;ZLkotlinx/coroutines/CoroutineScope;Landroidx/compose/ui/unit/Density;ILkotlin/jvm/functions/Function1;Ljava/util/List;IIIZLandroidx/compose/foundation/gestures/Orientation;II)V", BuildConfig.FLAVOR, "placeChildren", "()V", "delta", "tryToApplyScrollWithoutRemeasure", "(I)Z", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLine;", "getFirstVisibleLine", "()Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLine;", "I", "getFirstVisibleLineScrollOffset", "()I", "setFirstVisibleLineScrollOffset", "(I)V", "Z", "getCanScrollForward", "()Z", "setCanScrollForward", "(Z)V", "F", "getConsumedScroll", "()F", "setConsumedScroll", "(F)V", "getRemeasureNeeded", "Lkotlinx/coroutines/CoroutineScope;", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "Landroidx/compose/ui/unit/Density;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "getSlotsPerLine", "Lkotlin/jvm/functions/Function1;", "getPrefetchInfoRetriever", "()Lkotlin/jvm/functions/Function1;", "Ljava/util/List;", "getVisibleItemsInfo", "()Ljava/util/List;", "getViewportStartOffset", "getViewportEndOffset", "getTotalItemsCount", "getReverseLayout", "Landroidx/compose/foundation/gestures/Orientation;", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "getAfterContentPadding", "getMainAxisItemSpacing", BuildConfig.FLAVOR, "Landroidx/compose/ui/layout/AlignmentLine;", "getAlignmentLines", "()Ljava/util/Map;", "alignmentLines", "getHeight", "height", "Landroidx/compose/ui/layout/RulerScope;", "getRulers", "rulers", "getWidth", "width", "getCanScrollBackward", "canScrollBackward", "Landroidx/compose/ui/unit/IntSize;", "getViewportSize-YbymL2g", "()J", "viewportSize", "getBeforeContentPadding", "beforeContentPadding", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LazyGridMeasureResult implements LazyGridLayoutInfo, MeasureResult {
    private final /* synthetic */ MeasureResult $$delegate_0;
    private final int afterContentPadding;
    private boolean canScrollForward;
    private float consumedScroll;
    private final CoroutineScope coroutineScope;
    private final Density density;
    private final LazyGridMeasuredLine firstVisibleLine;
    private int firstVisibleLineScrollOffset;
    private final int mainAxisItemSpacing;
    private final Orientation orientation;
    private final Function1<Integer, List<Pair<Integer, Constraints>>> prefetchInfoRetriever;
    private final boolean remeasureNeeded;
    private final boolean reverseLayout;
    private final int slotsPerLine;
    private final int totalItemsCount;
    private final int viewportEndOffset;
    private final int viewportStartOffset;
    private final List<LazyGridMeasuredItem> visibleItemsInfo;

    /* JADX WARN: Multi-variable type inference failed */
    public LazyGridMeasureResult(LazyGridMeasuredLine lazyGridMeasuredLine, int i5, boolean z5, float f5, MeasureResult measureResult, boolean z6, CoroutineScope coroutineScope, Density density, int i6, Function1<? super Integer, ? extends List<Pair<Integer, Constraints>>> function1, List<LazyGridMeasuredItem> list, int i7, int i8, int i9, boolean z7, Orientation orientation, int i10, int i11) {
        this.firstVisibleLine = lazyGridMeasuredLine;
        this.firstVisibleLineScrollOffset = i5;
        this.canScrollForward = z5;
        this.consumedScroll = f5;
        this.remeasureNeeded = z6;
        this.coroutineScope = coroutineScope;
        this.density = density;
        this.slotsPerLine = i6;
        this.prefetchInfoRetriever = function1;
        this.visibleItemsInfo = list;
        this.viewportStartOffset = i7;
        this.viewportEndOffset = i8;
        this.totalItemsCount = i9;
        this.reverseLayout = z7;
        this.orientation = orientation;
        this.afterContentPadding = i10;
        this.mainAxisItemSpacing = i11;
        this.$$delegate_0 = measureResult;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public int getAfterContentPadding() {
        return this.afterContentPadding;
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    public Map<AlignmentLine, Integer> getAlignmentLines() {
        return this.$$delegate_0.getAlignmentLines();
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public int getBeforeContentPadding() {
        return -getViewportStartOffset();
    }

    public final boolean getCanScrollBackward() {
        LazyGridMeasuredLine lazyGridMeasuredLine = this.firstVisibleLine;
        return ((lazyGridMeasuredLine != null ? lazyGridMeasuredLine.getIndex() : 0) == 0 && this.firstVisibleLineScrollOffset == 0) ? false : true;
    }

    public final boolean getCanScrollForward() {
        return this.canScrollForward;
    }

    public final float getConsumedScroll() {
        return this.consumedScroll;
    }

    public final LazyGridMeasuredLine getFirstVisibleLine() {
        return this.firstVisibleLine;
    }

    public final int getFirstVisibleLineScrollOffset() {
        return this.firstVisibleLineScrollOffset;
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    /* renamed from: getHeight */
    public int get$height() {
        return this.$$delegate_0.get$height();
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public int getMainAxisItemSpacing() {
        return this.mainAxisItemSpacing;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public Orientation getOrientation() {
        return this.orientation;
    }

    public final Function1<Integer, List<Pair<Integer, Constraints>>> getPrefetchInfoRetriever() {
        return this.prefetchInfoRetriever;
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    public Function1<RulerScope, Unit> getRulers() {
        return this.$$delegate_0.getRulers();
    }

    public final int getSlotsPerLine() {
        return this.slotsPerLine;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public int getTotalItemsCount() {
        return this.totalItemsCount;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public int getViewportEndOffset() {
        return this.viewportEndOffset;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    /* renamed from: getViewportSize-YbymL2g */
    public long mo395getViewportSizeYbymL2g() {
        return IntSizeKt.IntSize(get$width(), get$height());
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public int getViewportStartOffset() {
        return this.viewportStartOffset;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public List<LazyGridMeasuredItem> getVisibleItemsInfo() {
        return this.visibleItemsInfo;
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    /* renamed from: getWidth */
    public int get$width() {
        return this.$$delegate_0.get$width();
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    public void placeChildren() {
        this.$$delegate_0.placeChildren();
    }

    public final boolean tryToApplyScrollWithoutRemeasure(int delta) {
        LazyGridMeasuredLine lazyGridMeasuredLine;
        boolean z5 = false;
        z5 = false;
        z5 = false;
        z5 = false;
        z5 = false;
        z5 = false;
        z5 = false;
        z5 = false;
        z5 = false;
        if (!this.remeasureNeeded && !getVisibleItemsInfo().isEmpty() && (lazyGridMeasuredLine = this.firstVisibleLine) != null) {
            int mainAxisSizeWithSpacings = lazyGridMeasuredLine.getMainAxisSizeWithSpacings();
            int i5 = this.firstVisibleLineScrollOffset - delta;
            if (i5 >= 0 && i5 < mainAxisSizeWithSpacings) {
                LazyGridMeasuredItem lazyGridMeasuredItem = (LazyGridMeasuredItem) CollectionsKt.first((List) getVisibleItemsInfo());
                LazyGridMeasuredItem lazyGridMeasuredItem2 = (LazyGridMeasuredItem) CollectionsKt.last((List) getVisibleItemsInfo());
                if (!lazyGridMeasuredItem.getNonScrollableItem() && !lazyGridMeasuredItem2.getNonScrollableItem() && (delta >= 0 ? Math.min(getViewportStartOffset() - LazyGridSnapLayoutInfoProviderKt.offsetOnMainAxis(lazyGridMeasuredItem, getOrientation()), getViewportEndOffset() - LazyGridSnapLayoutInfoProviderKt.offsetOnMainAxis(lazyGridMeasuredItem2, getOrientation())) > delta : Math.min((LazyGridSnapLayoutInfoProviderKt.offsetOnMainAxis(lazyGridMeasuredItem, getOrientation()) + lazyGridMeasuredItem.getMainAxisSizeWithSpacings()) - getViewportStartOffset(), (LazyGridSnapLayoutInfoProviderKt.offsetOnMainAxis(lazyGridMeasuredItem2, getOrientation()) + lazyGridMeasuredItem2.getMainAxisSizeWithSpacings()) - getViewportEndOffset()) > (-delta))) {
                    this.firstVisibleLineScrollOffset -= delta;
                    List<LazyGridMeasuredItem> visibleItemsInfo = getVisibleItemsInfo();
                    int size = visibleItemsInfo.size();
                    for (int i6 = 0; i6 < size; i6++) {
                        visibleItemsInfo.get(i6).applyScrollDelta(delta);
                    }
                    this.consumedScroll = delta;
                    z5 = true;
                    z5 = true;
                    z5 = true;
                    if (!this.canScrollForward && delta > 0) {
                        this.canScrollForward = true;
                    }
                }
            }
        }
        return z5;
    }
}
