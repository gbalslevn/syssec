package androidx.compose.foundation.lazy;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.RulerScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b/\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u009f\u0001\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u0014\u0012\u0006\u0010\u0016\u001a\u00020\u0005\u0012\u0006\u0010\u0017\u001a\u00020\u0005\u0012\u0006\u0010\u0018\u001a\u00020\u0005\u0012\u0006\u0010\u0019\u001a\u00020\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\u001c\u001a\u00020\u0005\u0012\u0006\u0010\u001d\u001a\u00020\u0005¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010!\u001a\u00020 H\u0096\u0001¢\u0006\u0004\b!\u0010\"J\u001d\u0010%\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u0007¢\u0006\u0004\b%\u0010&R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010'\u001a\u0004\b(\u0010)R\"\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u0017\u0010\f\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\f\u00104\u001a\u0004\b9\u00106R\u0017\u0010\r\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\r\u0010/\u001a\u0004\b:\u00101R\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010;\u001a\u0004\b<\u0010=R\u0017\u0010\u0011\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010>\u001a\u0004\b?\u0010@R\u001d\u0010\u0013\u001a\u00020\u00128\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0013\u0010A\u001a\u0004\bB\u0010CR \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u00148\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0015\u0010D\u001a\u0004\bE\u0010FR\u001a\u0010\u0016\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0016\u0010*\u001a\u0004\bG\u0010,R\u001a\u0010\u0017\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0017\u0010*\u001a\u0004\bH\u0010,R\u001a\u0010\u0018\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010*\u001a\u0004\bI\u0010,R\u001a\u0010\u0019\u001a\u00020\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0019\u0010/\u001a\u0004\bJ\u00101R\u001a\u0010\u001b\u001a\u00020\u001a8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001b\u0010K\u001a\u0004\bL\u0010MR\u001a\u0010\u001c\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001c\u0010*\u001a\u0004\bN\u0010,R\u001a\u0010\u001d\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001d\u0010*\u001a\u0004\bO\u0010,R \u0010T\u001a\u000e\u0012\u0004\u0012\u00020Q\u0012\u0004\u0012\u00020\u00050P8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bR\u0010SR\u0014\u0010V\u001a\u00020\u00058\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bU\u0010,R\"\u0010[\u001a\u0010\u0012\u0004\u0012\u00020X\u0012\u0004\u0012\u00020 \u0018\u00010W8VX\u0096\u0005¢\u0006\u0006\u001a\u0004\bY\u0010ZR\u0014\u0010]\u001a\u00020\u00058\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\\\u0010,R\u0011\u0010_\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b^\u00101R\u001a\u0010b\u001a\u00020`8VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\ba\u0010CR\u0014\u0010d\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bc\u0010,\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006e"}, d2 = {"Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "Landroidx/compose/foundation/lazy/LazyListLayoutInfo;", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/foundation/lazy/LazyListMeasuredItem;", "firstVisibleItem", BuildConfig.FLAVOR, "firstVisibleItemScrollOffset", BuildConfig.FLAVOR, "canScrollForward", BuildConfig.FLAVOR, "consumedScroll", "measureResult", "scrollBackAmount", "remeasureNeeded", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "Landroidx/compose/ui/unit/Density;", "density", "Landroidx/compose/ui/unit/Constraints;", "childConstraints", BuildConfig.FLAVOR, "visibleItemsInfo", "viewportStartOffset", "viewportEndOffset", "totalItemsCount", "reverseLayout", "Landroidx/compose/foundation/gestures/Orientation;", "orientation", "afterContentPadding", "mainAxisItemSpacing", "<init>", "(Landroidx/compose/foundation/lazy/LazyListMeasuredItem;IZFLandroidx/compose/ui/layout/MeasureResult;FZLkotlinx/coroutines/CoroutineScope;Landroidx/compose/ui/unit/Density;JLjava/util/List;IIIZLandroidx/compose/foundation/gestures/Orientation;IILkotlin/jvm/internal/DefaultConstructorMarker;)V", BuildConfig.FLAVOR, "placeChildren", "()V", "delta", "updateAnimations", "tryToApplyScrollWithoutRemeasure", "(IZ)Z", "Landroidx/compose/foundation/lazy/LazyListMeasuredItem;", "getFirstVisibleItem", "()Landroidx/compose/foundation/lazy/LazyListMeasuredItem;", "I", "getFirstVisibleItemScrollOffset", "()I", "setFirstVisibleItemScrollOffset", "(I)V", "Z", "getCanScrollForward", "()Z", "setCanScrollForward", "(Z)V", "F", "getConsumedScroll", "()F", "setConsumedScroll", "(F)V", "getScrollBackAmount", "getRemeasureNeeded", "Lkotlinx/coroutines/CoroutineScope;", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "Landroidx/compose/ui/unit/Density;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "J", "getChildConstraints-msEJaDk", "()J", "Ljava/util/List;", "getVisibleItemsInfo", "()Ljava/util/List;", "getViewportStartOffset", "getViewportEndOffset", "getTotalItemsCount", "getReverseLayout", "Landroidx/compose/foundation/gestures/Orientation;", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "getAfterContentPadding", "getMainAxisItemSpacing", BuildConfig.FLAVOR, "Landroidx/compose/ui/layout/AlignmentLine;", "getAlignmentLines", "()Ljava/util/Map;", "alignmentLines", "getHeight", "height", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/RulerScope;", "getRulers", "()Lkotlin/jvm/functions/Function1;", "rulers", "getWidth", "width", "getCanScrollBackward", "canScrollBackward", "Landroidx/compose/ui/unit/IntSize;", "getViewportSize-YbymL2g", "viewportSize", "getBeforeContentPadding", "beforeContentPadding", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LazyListMeasureResult implements LazyListLayoutInfo, MeasureResult {
    private final /* synthetic */ MeasureResult $$delegate_0;
    private final int afterContentPadding;
    private boolean canScrollForward;
    private final long childConstraints;
    private float consumedScroll;
    private final CoroutineScope coroutineScope;
    private final Density density;
    private final LazyListMeasuredItem firstVisibleItem;
    private int firstVisibleItemScrollOffset;
    private final int mainAxisItemSpacing;
    private final Orientation orientation;
    private final boolean remeasureNeeded;
    private final boolean reverseLayout;
    private final float scrollBackAmount;
    private final int totalItemsCount;
    private final int viewportEndOffset;
    private final int viewportStartOffset;
    private final List<LazyListMeasuredItem> visibleItemsInfo;

    public /* synthetic */ LazyListMeasureResult(LazyListMeasuredItem lazyListMeasuredItem, int i5, boolean z5, float f5, MeasureResult measureResult, float f6, boolean z6, CoroutineScope coroutineScope, Density density, long j5, List list, int i6, int i7, int i8, boolean z7, Orientation orientation, int i9, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(lazyListMeasuredItem, i5, z5, f5, measureResult, f6, z6, coroutineScope, density, j5, list, i6, i7, i8, z7, orientation, i9, i10);
    }

    @Override // androidx.compose.foundation.lazy.LazyListLayoutInfo
    public int getAfterContentPadding() {
        return this.afterContentPadding;
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    public Map<AlignmentLine, Integer> getAlignmentLines() {
        return this.$$delegate_0.getAlignmentLines();
    }

    @Override // androidx.compose.foundation.lazy.LazyListLayoutInfo
    public int getBeforeContentPadding() {
        return -getViewportStartOffset();
    }

    public final boolean getCanScrollBackward() {
        LazyListMeasuredItem lazyListMeasuredItem = this.firstVisibleItem;
        return ((lazyListMeasuredItem != null ? lazyListMeasuredItem.getIndex() : 0) == 0 && this.firstVisibleItemScrollOffset == 0) ? false : true;
    }

    public final boolean getCanScrollForward() {
        return this.canScrollForward;
    }

    /* renamed from: getChildConstraints-msEJaDk, reason: not valid java name and from getter */
    public final long getChildConstraints() {
        return this.childConstraints;
    }

    public final float getConsumedScroll() {
        return this.consumedScroll;
    }

    public final CoroutineScope getCoroutineScope() {
        return this.coroutineScope;
    }

    public final Density getDensity() {
        return this.density;
    }

    public final LazyListMeasuredItem getFirstVisibleItem() {
        return this.firstVisibleItem;
    }

    public final int getFirstVisibleItemScrollOffset() {
        return this.firstVisibleItemScrollOffset;
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    /* renamed from: getHeight */
    public int get$height() {
        return this.$$delegate_0.get$height();
    }

    @Override // androidx.compose.foundation.lazy.LazyListLayoutInfo
    public int getMainAxisItemSpacing() {
        return this.mainAxisItemSpacing;
    }

    @Override // androidx.compose.foundation.lazy.LazyListLayoutInfo
    public Orientation getOrientation() {
        return this.orientation;
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    public Function1<RulerScope, Unit> getRulers() {
        return this.$$delegate_0.getRulers();
    }

    public final float getScrollBackAmount() {
        return this.scrollBackAmount;
    }

    @Override // androidx.compose.foundation.lazy.LazyListLayoutInfo
    public int getTotalItemsCount() {
        return this.totalItemsCount;
    }

    @Override // androidx.compose.foundation.lazy.LazyListLayoutInfo
    public int getViewportEndOffset() {
        return this.viewportEndOffset;
    }

    @Override // androidx.compose.foundation.lazy.LazyListLayoutInfo
    /* renamed from: getViewportSize-YbymL2g */
    public long mo368getViewportSizeYbymL2g() {
        return IntSizeKt.IntSize(get$width(), get$height());
    }

    @Override // androidx.compose.foundation.lazy.LazyListLayoutInfo
    public int getViewportStartOffset() {
        return this.viewportStartOffset;
    }

    @Override // androidx.compose.foundation.lazy.LazyListLayoutInfo
    public List<LazyListMeasuredItem> getVisibleItemsInfo() {
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

    public final boolean tryToApplyScrollWithoutRemeasure(int delta, boolean updateAnimations) {
        LazyListMeasuredItem lazyListMeasuredItem;
        boolean z5 = false;
        z5 = false;
        z5 = false;
        z5 = false;
        z5 = false;
        z5 = false;
        z5 = false;
        z5 = false;
        z5 = false;
        if (!this.remeasureNeeded && !getVisibleItemsInfo().isEmpty() && (lazyListMeasuredItem = this.firstVisibleItem) != null) {
            int mainAxisSizeWithSpacings = lazyListMeasuredItem.getMainAxisSizeWithSpacings();
            int i5 = this.firstVisibleItemScrollOffset - delta;
            if (i5 >= 0 && i5 < mainAxisSizeWithSpacings) {
                LazyListMeasuredItem lazyListMeasuredItem2 = (LazyListMeasuredItem) CollectionsKt.first((List) getVisibleItemsInfo());
                LazyListMeasuredItem lazyListMeasuredItem3 = (LazyListMeasuredItem) CollectionsKt.last((List) getVisibleItemsInfo());
                if (!lazyListMeasuredItem2.getNonScrollableItem() && !lazyListMeasuredItem3.getNonScrollableItem() && (delta >= 0 ? Math.min(getViewportStartOffset() - lazyListMeasuredItem2.getOffset(), getViewportEndOffset() - lazyListMeasuredItem3.getOffset()) > delta : Math.min((lazyListMeasuredItem2.getOffset() + lazyListMeasuredItem2.getMainAxisSizeWithSpacings()) - getViewportStartOffset(), (lazyListMeasuredItem3.getOffset() + lazyListMeasuredItem3.getMainAxisSizeWithSpacings()) - getViewportEndOffset()) > (-delta))) {
                    this.firstVisibleItemScrollOffset -= delta;
                    List<LazyListMeasuredItem> visibleItemsInfo = getVisibleItemsInfo();
                    int size = visibleItemsInfo.size();
                    for (int i6 = 0; i6 < size; i6++) {
                        visibleItemsInfo.get(i6).applyScrollDelta(delta, updateAnimations);
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

    private LazyListMeasureResult(LazyListMeasuredItem lazyListMeasuredItem, int i5, boolean z5, float f5, MeasureResult measureResult, float f6, boolean z6, CoroutineScope coroutineScope, Density density, long j5, List<LazyListMeasuredItem> list, int i6, int i7, int i8, boolean z7, Orientation orientation, int i9, int i10) {
        this.firstVisibleItem = lazyListMeasuredItem;
        this.firstVisibleItemScrollOffset = i5;
        this.canScrollForward = z5;
        this.consumedScroll = f5;
        this.scrollBackAmount = f6;
        this.remeasureNeeded = z6;
        this.coroutineScope = coroutineScope;
        this.density = density;
        this.childConstraints = j5;
        this.visibleItemsInfo = list;
        this.viewportStartOffset = i6;
        this.viewportEndOffset = i7;
        this.totalItemsCount = i8;
        this.reverseLayout = z7;
        this.orientation = orientation;
        this.afterContentPadding = i9;
        this.mainAxisItemSpacing = i10;
        this.$$delegate_0 = measureResult;
    }
}
