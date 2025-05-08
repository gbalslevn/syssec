package androidx.compose.foundation.layout;

import androidx.collection.IntIntPair;
import androidx.compose.foundation.layout.FlowLayoutOverflow;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001:\u0002\"#B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ8\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0003JZ\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u0012ø\u0001\u0000¢\u0006\u0004\b \u0010!R\u0016\u0010\u0006\u001a\u00020\u0007X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\fR\u000e\u0010\n\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006$"}, d2 = {"Landroidx/compose/foundation/layout/FlowLayoutBuildingBlocks;", BuildConfig.FLAVOR, "maxItemsInMainAxis", BuildConfig.FLAVOR, "overflow", "Landroidx/compose/foundation/layout/FlowLayoutOverflowState;", "constraints", "Landroidx/compose/foundation/layout/OrientationIndependentConstraints;", "maxLines", "mainAxisSpacing", "crossAxisSpacing", "(ILandroidx/compose/foundation/layout/FlowLayoutOverflowState;JIIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "getWrapEllipsisInfo", "Landroidx/compose/foundation/layout/FlowLayoutBuildingBlocks$WrapEllipsisInfo;", "wrapInfo", "Landroidx/compose/foundation/layout/FlowLayoutBuildingBlocks$WrapInfo;", "hasNext", BuildConfig.FLAVOR, "lastContentLineIndex", "totalCrossAxisSize", "leftOverMainAxis", "nextIndexInLine", "getWrapInfo", "nextItemHasNext", "leftOver", "Landroidx/collection/IntIntPair;", "nextSize", "lineIndex", "currentLineCrossAxisSize", "isWrappingRound", "isEllipsisWrap", "getWrapInfo-OpUlnko", "(ZIJLandroidx/collection/IntIntPair;IIIZZ)Landroidx/compose/foundation/layout/FlowLayoutBuildingBlocks$WrapInfo;", "WrapEllipsisInfo", "WrapInfo", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FlowLayoutBuildingBlocks {
    private final long constraints;
    private final int crossAxisSpacing;
    private final int mainAxisSpacing;
    private final int maxItemsInMainAxis;
    private final int maxLines;
    private final FlowLayoutOverflowState overflow;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0016"}, d2 = {"Landroidx/compose/foundation/layout/FlowLayoutBuildingBlocks$WrapEllipsisInfo;", BuildConfig.FLAVOR, "ellipsis", "Landroidx/compose/ui/layout/Measurable;", "placeable", "Landroidx/compose/ui/layout/Placeable;", "ellipsisSize", "Landroidx/collection/IntIntPair;", "placeEllipsisOnLastContentLine", BuildConfig.FLAVOR, "(Landroidx/compose/ui/layout/Measurable;Landroidx/compose/ui/layout/Placeable;JZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getEllipsis", "()Landroidx/compose/ui/layout/Measurable;", "getEllipsisSize-OO21N7I", "()J", "J", "getPlaceEllipsisOnLastContentLine", "()Z", "setPlaceEllipsisOnLastContentLine", "(Z)V", "getPlaceable", "()Landroidx/compose/ui/layout/Placeable;", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class WrapEllipsisInfo {
        private final Measurable ellipsis;
        private final long ellipsisSize;
        private boolean placeEllipsisOnLastContentLine;
        private final Placeable placeable;

        public /* synthetic */ WrapEllipsisInfo(Measurable measurable, Placeable placeable, long j5, boolean z5, DefaultConstructorMarker defaultConstructorMarker) {
            this(measurable, placeable, j5, z5);
        }

        public final Measurable getEllipsis() {
            return this.ellipsis;
        }

        /* renamed from: getEllipsisSize-OO21N7I, reason: not valid java name and from getter */
        public final long getEllipsisSize() {
            return this.ellipsisSize;
        }

        public final boolean getPlaceEllipsisOnLastContentLine() {
            return this.placeEllipsisOnLastContentLine;
        }

        public final Placeable getPlaceable() {
            return this.placeable;
        }

        public final void setPlaceEllipsisOnLastContentLine(boolean z5) {
            this.placeEllipsisOnLastContentLine = z5;
        }

        private WrapEllipsisInfo(Measurable measurable, Placeable placeable, long j5, boolean z5) {
            this.ellipsis = measurable;
            this.placeable = placeable;
            this.ellipsisSize = j5;
            this.placeEllipsisOnLastContentLine = z5;
        }

        public /* synthetic */ WrapEllipsisInfo(Measurable measurable, Placeable placeable, long j5, boolean z5, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this(measurable, placeable, j5, (i5 & 8) != 0 ? true : z5, null);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/foundation/layout/FlowLayoutBuildingBlocks$WrapInfo;", BuildConfig.FLAVOR, "isLastItemInLine", BuildConfig.FLAVOR, "isLastItemInContainer", "(ZZ)V", "()Z", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class WrapInfo {
        private final boolean isLastItemInContainer;
        private final boolean isLastItemInLine;

        public WrapInfo(boolean z5, boolean z6) {
            this.isLastItemInLine = z5;
            this.isLastItemInContainer = z6;
        }

        /* renamed from: isLastItemInContainer, reason: from getter */
        public final boolean getIsLastItemInContainer() {
            return this.isLastItemInContainer;
        }

        /* renamed from: isLastItemInLine, reason: from getter */
        public final boolean getIsLastItemInLine() {
            return this.isLastItemInLine;
        }
    }

    public /* synthetic */ FlowLayoutBuildingBlocks(int i5, FlowLayoutOverflowState flowLayoutOverflowState, long j5, int i6, int i7, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(i5, flowLayoutOverflowState, j5, i6, i7, i8);
    }

    public final WrapEllipsisInfo getWrapEllipsisInfo(WrapInfo wrapInfo, boolean hasNext, int lastContentLineIndex, int totalCrossAxisSize, int leftOverMainAxis, int nextIndexInLine) {
        WrapEllipsisInfo ellipsisInfo$foundation_layout_release;
        if (!wrapInfo.getIsLastItemInContainer() || (ellipsisInfo$foundation_layout_release = this.overflow.ellipsisInfo$foundation_layout_release(hasNext, lastContentLineIndex, totalCrossAxisSize)) == null) {
            return null;
        }
        ellipsisInfo$foundation_layout_release.setPlaceEllipsisOnLastContentLine(lastContentLineIndex >= 0 && (nextIndexInLine == 0 || (leftOverMainAxis - IntIntPair.m10getFirstimpl(ellipsisInfo$foundation_layout_release.getEllipsisSize()) >= 0 && nextIndexInLine < this.maxItemsInMainAxis)));
        return ellipsisInfo$foundation_layout_release;
    }

    /* renamed from: getWrapInfo-OpUlnko, reason: not valid java name */
    public final WrapInfo m280getWrapInfoOpUlnko(boolean nextItemHasNext, int nextIndexInLine, long leftOver, IntIntPair nextSize, int lineIndex, int totalCrossAxisSize, int currentLineCrossAxisSize, boolean isWrappingRound, boolean isEllipsisWrap) {
        int i5 = totalCrossAxisSize + currentLineCrossAxisSize;
        if (nextSize == null) {
            return new WrapInfo(true, true);
        }
        if (this.overflow.getType() != FlowLayoutOverflow.OverflowType.Visible && (lineIndex >= this.maxLines || IntIntPair.m11getSecondimpl(leftOver) - IntIntPair.m11getSecondimpl(nextSize.getPackedValue()) < 0)) {
            return new WrapInfo(true, true);
        }
        if (nextIndexInLine != 0 && (nextIndexInLine >= this.maxItemsInMainAxis || IntIntPair.m10getFirstimpl(leftOver) - IntIntPair.m10getFirstimpl(nextSize.getPackedValue()) < 0)) {
            return isWrappingRound ? new WrapInfo(true, true) : new WrapInfo(true, m280getWrapInfoOpUlnko(nextItemHasNext, 0, IntIntPair.m7constructorimpl(Constraints.m2578getMaxWidthimpl(this.constraints), (IntIntPair.m11getSecondimpl(leftOver) - this.crossAxisSpacing) - currentLineCrossAxisSize), IntIntPair.m6boximpl(IntIntPair.m7constructorimpl(IntIntPair.m10getFirstimpl(nextSize.getPackedValue()) - this.mainAxisSpacing, IntIntPair.m11getSecondimpl(nextSize.getPackedValue()))), lineIndex + 1, i5, 0, true, false).getIsLastItemInContainer());
        }
        int max = totalCrossAxisSize + Math.max(currentLineCrossAxisSize, IntIntPair.m11getSecondimpl(nextSize.getPackedValue()));
        IntIntPair m285ellipsisSizeF35zmw$foundation_layout_release = isEllipsisWrap ? null : this.overflow.m285ellipsisSizeF35zmw$foundation_layout_release(nextItemHasNext, lineIndex, max);
        if (m285ellipsisSizeF35zmw$foundation_layout_release != null) {
            m285ellipsisSizeF35zmw$foundation_layout_release.getPackedValue();
            if (nextIndexInLine + 1 >= this.maxItemsInMainAxis || ((IntIntPair.m10getFirstimpl(leftOver) - IntIntPair.m10getFirstimpl(nextSize.getPackedValue())) - this.mainAxisSpacing) - IntIntPair.m10getFirstimpl(m285ellipsisSizeF35zmw$foundation_layout_release.getPackedValue()) < 0) {
                if (isEllipsisWrap) {
                    return new WrapInfo(true, true);
                }
                WrapInfo m280getWrapInfoOpUlnko = m280getWrapInfoOpUlnko(false, 0, IntIntPair.m7constructorimpl(Constraints.m2578getMaxWidthimpl(this.constraints), (IntIntPair.m11getSecondimpl(leftOver) - this.crossAxisSpacing) - Math.max(currentLineCrossAxisSize, IntIntPair.m11getSecondimpl(nextSize.getPackedValue()))), m285ellipsisSizeF35zmw$foundation_layout_release, lineIndex + 1, max, 0, true, true);
                return new WrapInfo(m280getWrapInfoOpUlnko.getIsLastItemInContainer(), m280getWrapInfoOpUlnko.getIsLastItemInContainer());
            }
        }
        return new WrapInfo(false, false);
    }

    private FlowLayoutBuildingBlocks(int i5, FlowLayoutOverflowState flowLayoutOverflowState, long j5, int i6, int i7, int i8) {
        this.maxItemsInMainAxis = i5;
        this.overflow = flowLayoutOverflowState;
        this.constraints = j5;
        this.maxLines = i6;
        this.mainAxisSpacing = i7;
        this.crossAxisSpacing = i8;
    }
}
