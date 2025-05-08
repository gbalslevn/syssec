package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0095\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00000\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u001a\u001a\u00020\u0003\u0012\u0006\u0010\u001b\u001a\u00020\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u001d\u0010\"\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0003H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b \u0010!J/\u0010(\u001a\u00020'2\u0006\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u0003H\u0016¢\u0006\u0004\b(\u0010)J=\u0010(\u001a\u00020'2\u0006\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\u0003¢\u0006\u0004\b(\u0010,J\u0015\u0010.\u001a\u00020'2\u0006\u0010-\u001a\u00020\u0003¢\u0006\u0004\b.\u0010/J\u0015\u00101\u001a\u00020'2\u0006\u00100\u001a\u00020\u0003¢\u0006\u0004\b1\u0010/J\u0015\u00104\u001a\u00020'2\u0006\u00103\u001a\u000202¢\u0006\u0004\b4\u00105R\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u00106\u001a\u0004\b7\u00108R\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u00109\u001a\u0004\b:\u0010;R\u001a\u0010\b\u001a\u00020\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010<\u001a\u0004\b\b\u0010=R\u0017\u0010\t\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\t\u00106\u001a\u0004\b>\u00108R\u0014\u0010\u000b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010<R\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010?R\u0014\u0010\u000e\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u00106R\u0014\u0010\u000f\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u00106R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010@R\u001a\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\n\u0004\b\u0014\u0010AR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0015\u00109\u001a\u0004\bB\u0010;R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00000\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010CR \u0010\u0019\u001a\u00020\u00188\u0016X\u0096\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\b\u0019\u0010A\u001a\u0004\bD\u0010ER\u001a\u0010\u001a\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001a\u00106\u001a\u0004\bF\u00108R\u001a\u0010\u001b\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001b\u00106\u001a\u0004\bG\u00108R\u0017\u0010H\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\bH\u00106\u001a\u0004\bI\u00108R\u001a\u0010J\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\bJ\u00106\u001a\u0004\bK\u00108R\u0016\u0010-\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u00106R\u0016\u0010L\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u00106R\u0016\u0010M\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u00106R \u0010O\u001a\u00020N8\u0016X\u0096\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\bO\u0010A\u001a\u0004\bP\u0010ER*\u0010R\u001a\u00020\u00132\u0006\u0010Q\u001a\u00020\u00138\u0016@RX\u0096\u000eø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\bR\u0010A\u001a\u0004\bS\u0010ER$\u0010*\u001a\u00020\u00032\u0006\u0010Q\u001a\u00020\u00038\u0016@RX\u0096\u000e¢\u0006\f\n\u0004\b*\u00106\u001a\u0004\bT\u00108R$\u0010+\u001a\u00020\u00032\u0006\u0010Q\u001a\u00020\u00038\u0016@RX\u0096\u000e¢\u0006\f\n\u0004\b+\u00106\u001a\u0004\bU\u00108R\"\u0010V\u001a\u00020\u00078\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bV\u0010<\u001a\u0004\bW\u0010=\"\u0004\bX\u0010YR\u0018\u0010\\\u001a\u00020\u0003*\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bZ\u0010[R\u0018\u0010H\u001a\u00020\u0003*\u00020\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bI\u0010]R\u0014\u0010_\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b^\u00108\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006`"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "Landroidx/compose/foundation/lazy/grid/LazyGridItemInfo;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;", BuildConfig.FLAVOR, "index", BuildConfig.FLAVOR, "key", BuildConfig.FLAVOR, "isVertical", "crossAxisSize", "mainAxisSpacing", "reverseLayout", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "beforeContentPadding", "afterContentPadding", BuildConfig.FLAVOR, "Landroidx/compose/ui/layout/Placeable;", "placeables", "Landroidx/compose/ui/unit/IntOffset;", "visualOffset", "contentType", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "animator", "Landroidx/compose/ui/unit/Constraints;", "constraints", "lane", "span", "<init>", "(ILjava/lang/Object;ZIIZLandroidx/compose/ui/unit/LayoutDirection;IILjava/util/List;JLjava/lang/Object;Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;JIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getParentData", "(I)Ljava/lang/Object;", "getOffset-Bjo55l4", "(I)J", "getOffset", "mainAxisOffset", "crossAxisOffset", "layoutWidth", "layoutHeight", BuildConfig.FLAVOR, "position", "(IIII)V", "row", "column", "(IIIIII)V", "mainAxisLayoutSize", "updateMainAxisLayoutSize", "(I)V", "delta", "applyScrollDelta", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "scope", "place", "(Landroidx/compose/ui/layout/Placeable$PlacementScope;)V", "I", "getIndex", "()I", "Ljava/lang/Object;", "getKey", "()Ljava/lang/Object;", "Z", "()Z", "getCrossAxisSize", "Landroidx/compose/ui/unit/LayoutDirection;", "Ljava/util/List;", "J", "getContentType", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "getConstraints-msEJaDk", "()J", "getLane", "getSpan", "mainAxisSize", "getMainAxisSize", "mainAxisSizeWithSpacings", "getMainAxisSizeWithSpacings", "minMainAxisOffset", "maxMainAxisOffset", "Landroidx/compose/ui/unit/IntSize;", "size", "getSize-YbymL2g", "<set-?>", "offset", "getOffset-nOcc-ac", "getRow", "getColumn", "nonScrollableItem", "getNonScrollableItem", "setNonScrollableItem", "(Z)V", "getMainAxis--gyyYBs", "(J)I", "mainAxis", "(Landroidx/compose/ui/layout/Placeable;)I", "getPlaceablesCount", "placeablesCount", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LazyGridMeasuredItem implements LazyGridItemInfo, LazyLayoutMeasuredItem {
    private final int afterContentPadding;
    private final LazyLayoutItemAnimator<LazyGridMeasuredItem> animator;
    private final int beforeContentPadding;
    private int column;
    private final long constraints;
    private final Object contentType;
    private final int crossAxisSize;
    private final int index;
    private final boolean isVertical;
    private final Object key;
    private final int lane;
    private final LayoutDirection layoutDirection;
    private int mainAxisLayoutSize;
    private final int mainAxisSize;
    private final int mainAxisSizeWithSpacings;
    private int maxMainAxisOffset;
    private int minMainAxisOffset;
    private boolean nonScrollableItem;
    private long offset;
    private final List<Placeable> placeables;
    private final boolean reverseLayout;
    private int row;
    private final long size;
    private final int span;
    private final long visualOffset;

    public /* synthetic */ LazyGridMeasuredItem(int i5, Object obj, boolean z5, int i6, int i7, boolean z6, LayoutDirection layoutDirection, int i8, int i9, List list, long j5, Object obj2, LazyLayoutItemAnimator lazyLayoutItemAnimator, long j6, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(i5, obj, z5, i6, i7, z6, layoutDirection, i8, i9, list, j5, obj2, lazyLayoutItemAnimator, j6, i10, i11);
    }

    /* renamed from: getMainAxis--gyyYBs, reason: not valid java name */
    private final int m397getMainAxisgyyYBs(long j5) {
        return getIsVertical() ? IntOffset.m2641getYimpl(j5) : IntOffset.m2640getXimpl(j5);
    }

    public final void applyScrollDelta(int delta) {
        if (getNonScrollableItem()) {
            return;
        }
        long offset = getOffset();
        int m2640getXimpl = getIsVertical() ? IntOffset.m2640getXimpl(offset) : IntOffset.m2640getXimpl(offset) + delta;
        boolean isVertical = getIsVertical();
        int m2641getYimpl = IntOffset.m2641getYimpl(offset);
        if (isVertical) {
            m2641getYimpl += delta;
        }
        this.offset = IntOffsetKt.IntOffset(m2640getXimpl, m2641getYimpl);
        int placeablesCount = getPlaceablesCount();
        for (int i5 = 0; i5 < placeablesCount; i5++) {
            this.animator.getAnimation(getKey(), i5);
        }
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemInfo
    public int getColumn() {
        return this.column;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    /* renamed from: getConstraints-msEJaDk, reason: from getter */
    public long getConstraints() {
        return this.constraints;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemInfo, androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int getIndex() {
        return this.index;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public Object getKey() {
        return this.key;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int getLane() {
        return this.lane;
    }

    public final int getMainAxisSize() {
        return this.mainAxisSize;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int getMainAxisSizeWithSpacings() {
        return this.mainAxisSizeWithSpacings;
    }

    public boolean getNonScrollableItem() {
        return this.nonScrollableItem;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    /* renamed from: getOffset-Bjo55l4 */
    public long mo373getOffsetBjo55l4(int index) {
        return getOffset();
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemInfo
    /* renamed from: getOffset-nOcc-ac, reason: from getter */
    public long getOffset() {
        return this.offset;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public Object getParentData(int index) {
        return this.placeables.get(index).getParentData();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int getPlaceablesCount() {
        return this.placeables.size();
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemInfo
    public int getRow() {
        return this.row;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemInfo
    /* renamed from: getSize-YbymL2g, reason: from getter */
    public long getSize() {
        return this.size;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int getSpan() {
        return this.span;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    /* renamed from: isVertical, reason: from getter */
    public boolean getIsVertical() {
        return this.isVertical;
    }

    public final void place(Placeable.PlacementScope scope) {
        if (this.mainAxisLayoutSize == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("position() should be called first");
        }
        int placeablesCount = getPlaceablesCount();
        for (int i5 = 0; i5 < placeablesCount; i5++) {
            Placeable placeable = this.placeables.get(i5);
            getMainAxisSize(placeable);
            long offset = getOffset();
            this.animator.getAnimation(getKey(), i5);
            if (this.reverseLayout) {
                offset = IntOffsetKt.IntOffset(getIsVertical() ? IntOffset.m2640getXimpl(offset) : (this.mainAxisLayoutSize - IntOffset.m2640getXimpl(offset)) - getMainAxisSize(placeable), getIsVertical() ? (this.mainAxisLayoutSize - IntOffset.m2641getYimpl(offset)) - getMainAxisSize(placeable) : IntOffset.m2641getYimpl(offset));
            }
            long m2644plusqkQi6aY = IntOffset.m2644plusqkQi6aY(offset, this.visualOffset);
            if (getIsVertical()) {
                Placeable.PlacementScope.m1972placeWithLayeraW9wM$default(scope, placeable, m2644plusqkQi6aY, 0.0f, (Function1) null, 6, (Object) null);
            } else {
                Placeable.PlacementScope.m1970placeRelativeWithLayeraW9wM$default(scope, placeable, m2644plusqkQi6aY, 0.0f, (Function1) null, 6, (Object) null);
            }
        }
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public void position(int mainAxisOffset, int crossAxisOffset, int layoutWidth, int layoutHeight) {
        position(mainAxisOffset, crossAxisOffset, layoutWidth, layoutHeight, -1, -1);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public void setNonScrollableItem(boolean z5) {
        this.nonScrollableItem = z5;
    }

    public final void updateMainAxisLayoutSize(int mainAxisLayoutSize) {
        this.mainAxisLayoutSize = mainAxisLayoutSize;
        this.maxMainAxisOffset = mainAxisLayoutSize + this.afterContentPadding;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private LazyGridMeasuredItem(int i5, Object obj, boolean z5, int i6, int i7, boolean z6, LayoutDirection layoutDirection, int i8, int i9, List<? extends Placeable> list, long j5, Object obj2, LazyLayoutItemAnimator<LazyGridMeasuredItem> lazyLayoutItemAnimator, long j6, int i10, int i11) {
        long IntSize;
        this.index = i5;
        this.key = obj;
        this.isVertical = z5;
        this.crossAxisSize = i6;
        this.reverseLayout = z6;
        this.layoutDirection = layoutDirection;
        this.beforeContentPadding = i8;
        this.afterContentPadding = i9;
        this.placeables = list;
        this.visualOffset = j5;
        this.contentType = obj2;
        this.animator = lazyLayoutItemAnimator;
        this.constraints = j6;
        this.lane = i10;
        this.span = i11;
        this.mainAxisLayoutSize = Integer.MIN_VALUE;
        int size = list.size();
        int i12 = 0;
        for (int i13 = 0; i13 < size; i13++) {
            Placeable placeable = (Placeable) list.get(i13);
            i12 = Math.max(i12, getIsVertical() ? placeable.getHeight() : placeable.getWidth());
        }
        this.mainAxisSize = i12;
        this.mainAxisSizeWithSpacings = RangesKt.coerceAtLeast(i12 + i7, 0);
        if (getIsVertical()) {
            IntSize = IntSizeKt.IntSize(this.crossAxisSize, i12);
        } else {
            IntSize = IntSizeKt.IntSize(i12, this.crossAxisSize);
        }
        this.size = IntSize;
        this.offset = IntOffset.INSTANCE.m2648getZeronOccac();
        this.row = -1;
        this.column = -1;
    }

    private final int getMainAxisSize(Placeable placeable) {
        return getIsVertical() ? placeable.getHeight() : placeable.getWidth();
    }

    public final void position(int mainAxisOffset, int crossAxisOffset, int layoutWidth, int layoutHeight, int row, int column) {
        long IntOffset;
        this.mainAxisLayoutSize = getIsVertical() ? layoutHeight : layoutWidth;
        if (!getIsVertical()) {
            layoutWidth = layoutHeight;
        }
        if (getIsVertical() && this.layoutDirection == LayoutDirection.Rtl) {
            crossAxisOffset = (layoutWidth - crossAxisOffset) - this.crossAxisSize;
        }
        if (getIsVertical()) {
            IntOffset = IntOffsetKt.IntOffset(crossAxisOffset, mainAxisOffset);
        } else {
            IntOffset = IntOffsetKt.IntOffset(mainAxisOffset, crossAxisOffset);
        }
        this.offset = IntOffset;
        this.row = row;
        this.column = column;
        this.minMainAxisOffset = -this.beforeContentPadding;
        this.maxMainAxisOffset = this.mainAxisLayoutSize + this.afterContentPadding;
    }
}
