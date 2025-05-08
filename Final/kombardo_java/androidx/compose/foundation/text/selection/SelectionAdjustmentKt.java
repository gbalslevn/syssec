package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.StringHelpers_androidKt;
import androidx.compose.foundation.text.selection.Selection;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a,\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u001c\u0010\u000e\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\rH\u0002\u001a\u0014\u0010\u0011\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0014\u0010\u0012\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u001c\u0010\u0013\u001a\u00020\n*\u00020\b2\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\nH\u0002\u001a4\u0010\u0015\u001a\u00020\u0007*\u00020\b2\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\nH\u0002\u001a\u001c\u0010\u0019\u001a\u00020\u0007*\u00020\u00032\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0007H\u0002¨\u0006\u001b²\u0006\n\u0010\u001c\u001a\u00020\rX\u008a\u0084\u0002²\u0006\n\u0010\u001d\u001a\u00020\u0007X\u008a\u0084\u0002"}, d2 = {"adjustToBoundaries", "Landroidx/compose/foundation/text/selection/Selection;", "layout", "Landroidx/compose/foundation/text/selection/SelectionLayout;", "boundaryFunction", "Landroidx/compose/foundation/text/selection/BoundaryFunction;", "anchorOnBoundary", "Landroidx/compose/foundation/text/selection/Selection$AnchorInfo;", "Landroidx/compose/foundation/text/selection/SelectableInfo;", "crossed", BuildConfig.FLAVOR, "isStart", "slot", BuildConfig.FLAVOR, "changeOffset", "info", "newOffset", "ensureAtLeastOneChar", "expandOneChar", "isExpanding", "currentRawOffset", "snapToWordBoundary", "currentLine", "currentOffset", "otherOffset", "updateSelectionBoundary", "previousSelectionAnchor", "foundation_release", "currentRawLine", "anchorSnappedToWordBoundary"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class SelectionAdjustmentKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Selection adjustToBoundaries(SelectionLayout selectionLayout, BoundaryFunction boundaryFunction) {
        boolean z5 = selectionLayout.getCrossStatus() == CrossStatus.CROSSED;
        return new Selection(anchorOnBoundary(selectionLayout.getStartInfo(), z5, true, selectionLayout.getStartSlot(), boundaryFunction), anchorOnBoundary(selectionLayout.getEndInfo(), z5, false, selectionLayout.getEndSlot(), boundaryFunction), z5);
    }

    private static final Selection.AnchorInfo anchorOnBoundary(SelectableInfo selectableInfo, boolean z5, boolean z6, int i5, BoundaryFunction boundaryFunction) {
        int rawStartHandleOffset = z6 ? selectableInfo.getRawStartHandleOffset() : selectableInfo.getRawEndHandleOffset();
        if (i5 != selectableInfo.getSlot()) {
            return selectableInfo.anchorForOffset(rawStartHandleOffset);
        }
        long mo623getBoundaryfzxv0v0 = boundaryFunction.mo623getBoundaryfzxv0v0(selectableInfo, rawStartHandleOffset);
        return selectableInfo.anchorForOffset(z5 ^ z6 ? TextRange.m2285getStartimpl(mo623getBoundaryfzxv0v0) : TextRange.m2280getEndimpl(mo623getBoundaryfzxv0v0));
    }

    private static final Selection.AnchorInfo changeOffset(Selection.AnchorInfo anchorInfo, SelectableInfo selectableInfo, int i5) {
        return Selection.AnchorInfo.copy$default(anchorInfo, selectableInfo.getTextLayoutResult().getBidiRunDirection(i5), i5, 0L, 4, null);
    }

    public static final Selection ensureAtLeastOneChar(Selection selection, SelectionLayout selectionLayout) {
        if (SelectionLayoutKt.isCollapsed(selection, selectionLayout)) {
            return (selectionLayout.getSize() > 1 || selectionLayout.getPreviousSelection() == null || selectionLayout.getInfo().getInputText().length() == 0) ? selection : expandOneChar(selection, selectionLayout);
        }
        return selection;
    }

    private static final Selection expandOneChar(Selection selection, SelectionLayout selectionLayout) {
        SelectableInfo info = selectionLayout.getInfo();
        String inputText = info.getInputText();
        int rawStartHandleOffset = info.getRawStartHandleOffset();
        int length = inputText.length();
        if (rawStartHandleOffset == 0) {
            int findFollowingBreak = StringHelpers_androidKt.findFollowingBreak(inputText, 0);
            return selectionLayout.getIsStartHandle() ? Selection.copy$default(selection, changeOffset(selection.getStart(), info, findFollowingBreak), null, true, 2, null) : Selection.copy$default(selection, null, changeOffset(selection.getEnd(), info, findFollowingBreak), false, 1, null);
        }
        if (rawStartHandleOffset == length) {
            int findPrecedingBreak = StringHelpers_androidKt.findPrecedingBreak(inputText, length);
            return selectionLayout.getIsStartHandle() ? Selection.copy$default(selection, changeOffset(selection.getStart(), info, findPrecedingBreak), null, false, 2, null) : Selection.copy$default(selection, null, changeOffset(selection.getEnd(), info, findPrecedingBreak), true, 1, null);
        }
        Selection previousSelection = selectionLayout.getPreviousSelection();
        boolean z5 = previousSelection != null && previousSelection.getHandlesCrossed();
        int findPrecedingBreak2 = selectionLayout.getIsStartHandle() ^ z5 ? StringHelpers_androidKt.findPrecedingBreak(inputText, rawStartHandleOffset) : StringHelpers_androidKt.findFollowingBreak(inputText, rawStartHandleOffset);
        return selectionLayout.getIsStartHandle() ? Selection.copy$default(selection, changeOffset(selection.getStart(), info, findPrecedingBreak2), null, z5, 2, null) : Selection.copy$default(selection, null, changeOffset(selection.getEnd(), info, findPrecedingBreak2), z5, 1, null);
    }

    private static final boolean isExpanding(SelectableInfo selectableInfo, int i5, boolean z5) {
        if (selectableInfo.getRawPreviousHandleOffset() == -1) {
            return true;
        }
        if (i5 == selectableInfo.getRawPreviousHandleOffset()) {
            return false;
        }
        if (z5 ^ (selectableInfo.getRawCrossStatus() == CrossStatus.CROSSED)) {
            if (i5 < selectableInfo.getRawPreviousHandleOffset()) {
                return true;
            }
        } else if (i5 > selectableInfo.getRawPreviousHandleOffset()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Selection.AnchorInfo snapToWordBoundary(SelectableInfo selectableInfo, int i5, int i6, int i7, boolean z5, boolean z6) {
        long m2272getWordBoundaryjx7JFs = selectableInfo.getTextLayoutResult().m2272getWordBoundaryjx7JFs(i6);
        int m2285getStartimpl = selectableInfo.getTextLayoutResult().getLineForOffset(TextRange.m2285getStartimpl(m2272getWordBoundaryjx7JFs)) == i5 ? TextRange.m2285getStartimpl(m2272getWordBoundaryjx7JFs) : i5 >= selectableInfo.getTextLayoutResult().getLineCount() ? selectableInfo.getTextLayoutResult().getLineStart(selectableInfo.getTextLayoutResult().getLineCount() - 1) : selectableInfo.getTextLayoutResult().getLineStart(i5);
        int m2280getEndimpl = selectableInfo.getTextLayoutResult().getLineForOffset(TextRange.m2280getEndimpl(m2272getWordBoundaryjx7JFs)) == i5 ? TextRange.m2280getEndimpl(m2272getWordBoundaryjx7JFs) : i5 >= selectableInfo.getTextLayoutResult().getLineCount() ? TextLayoutResult.getLineEnd$default(selectableInfo.getTextLayoutResult(), selectableInfo.getTextLayoutResult().getLineCount() - 1, false, 2, null) : TextLayoutResult.getLineEnd$default(selectableInfo.getTextLayoutResult(), i5, false, 2, null);
        if (m2285getStartimpl == i7) {
            return selectableInfo.anchorForOffset(m2280getEndimpl);
        }
        if (m2280getEndimpl == i7) {
            return selectableInfo.anchorForOffset(m2285getStartimpl);
        }
        if (!(z5 ^ z6) ? i6 >= m2285getStartimpl : i6 > m2280getEndimpl) {
            m2285getStartimpl = m2280getEndimpl;
        }
        return selectableInfo.anchorForOffset(m2285getStartimpl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Selection.AnchorInfo updateSelectionBoundary(final SelectionLayout selectionLayout, final SelectableInfo selectableInfo, Selection.AnchorInfo anchorInfo) {
        final int rawStartHandleOffset = selectionLayout.getIsStartHandle() ? selectableInfo.getRawStartHandleOffset() : selectableInfo.getRawEndHandleOffset();
        if ((selectionLayout.getIsStartHandle() ? selectionLayout.getStartSlot() : selectionLayout.getEndSlot()) != selectableInfo.getSlot()) {
            return selectableInfo.anchorForOffset(rawStartHandleOffset);
        }
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        final Lazy lazy = LazyKt.lazy(lazyThreadSafetyMode, new Function0<Integer>() { // from class: androidx.compose.foundation.text.selection.SelectionAdjustmentKt$updateSelectionBoundary$currentRawLine$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                return Integer.valueOf(SelectableInfo.this.getTextLayoutResult().getLineForOffset(rawStartHandleOffset));
            }
        });
        final int rawEndHandleOffset = selectionLayout.getIsStartHandle() ? selectableInfo.getRawEndHandleOffset() : selectableInfo.getRawStartHandleOffset();
        final int i5 = rawStartHandleOffset;
        Lazy lazy2 = LazyKt.lazy(lazyThreadSafetyMode, new Function0<Selection.AnchorInfo>() { // from class: androidx.compose.foundation.text.selection.SelectionAdjustmentKt$updateSelectionBoundary$anchorSnappedToWordBoundary$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Selection.AnchorInfo invoke() {
                int updateSelectionBoundary$lambda$0;
                Selection.AnchorInfo snapToWordBoundary;
                SelectableInfo selectableInfo2 = SelectableInfo.this;
                updateSelectionBoundary$lambda$0 = SelectionAdjustmentKt.updateSelectionBoundary$lambda$0(lazy);
                snapToWordBoundary = SelectionAdjustmentKt.snapToWordBoundary(selectableInfo2, updateSelectionBoundary$lambda$0, i5, rawEndHandleOffset, selectionLayout.getIsStartHandle(), selectionLayout.getCrossStatus() == CrossStatus.CROSSED);
                return snapToWordBoundary;
            }
        });
        if (selectableInfo.getSelectableId() != anchorInfo.getSelectableId()) {
            return updateSelectionBoundary$lambda$1(lazy2);
        }
        int rawPreviousHandleOffset = selectableInfo.getRawPreviousHandleOffset();
        if (rawStartHandleOffset == rawPreviousHandleOffset) {
            return anchorInfo;
        }
        if (updateSelectionBoundary$lambda$0(lazy) != selectableInfo.getTextLayoutResult().getLineForOffset(rawPreviousHandleOffset)) {
            return updateSelectionBoundary$lambda$1(lazy2);
        }
        int offset = anchorInfo.getOffset();
        long m2272getWordBoundaryjx7JFs = selectableInfo.getTextLayoutResult().m2272getWordBoundaryjx7JFs(offset);
        return !isExpanding(selectableInfo, rawStartHandleOffset, selectionLayout.getIsStartHandle()) ? selectableInfo.anchorForOffset(rawStartHandleOffset) : (offset == TextRange.m2285getStartimpl(m2272getWordBoundaryjx7JFs) || offset == TextRange.m2280getEndimpl(m2272getWordBoundaryjx7JFs)) ? updateSelectionBoundary$lambda$1(lazy2) : selectableInfo.anchorForOffset(rawStartHandleOffset);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int updateSelectionBoundary$lambda$0(Lazy<Integer> lazy) {
        return lazy.getValue().intValue();
    }

    private static final Selection.AnchorInfo updateSelectionBoundary$lambda$1(Lazy<Selection.AnchorInfo> lazy) {
        return lazy.getValue();
    }
}
