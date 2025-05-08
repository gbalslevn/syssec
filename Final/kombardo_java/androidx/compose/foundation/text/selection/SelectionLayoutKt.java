package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.selection.Selection;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$BooleanRef;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aJ\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0000ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u001b\u0010\u0011\u001a\u00020\u0010*\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u001b\u0010\u0013\u001a\u00020\b*\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u001f\u0010\u0017\u001a\u00020\b*\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u000bH\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0019"}, d2 = {"Landroidx/compose/ui/text/TextLayoutResult;", "layoutResult", BuildConfig.FLAVOR, "rawStartHandleOffset", "rawEndHandleOffset", "rawPreviousHandleOffset", "Landroidx/compose/ui/text/TextRange;", "previousSelectionRange", BuildConfig.FLAVOR, "isStartOfSelection", "isStartHandle", "Landroidx/compose/foundation/text/selection/SelectionLayout;", "getTextFieldSelectionLayout-RcvT-LA", "(Landroidx/compose/ui/text/TextLayoutResult;IIIJZZ)Landroidx/compose/foundation/text/selection/SelectionLayout;", "getTextFieldSelectionLayout", "offset", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "getTextDirectionForOffset", "(Landroidx/compose/ui/text/TextLayoutResult;I)Landroidx/compose/ui/text/style/ResolvedTextDirection;", "isOffsetAnEmptyLine", "(Landroidx/compose/ui/text/TextLayoutResult;I)Z", "Landroidx/compose/foundation/text/selection/Selection;", "layout", "isCollapsed", "(Landroidx/compose/foundation/text/selection/Selection;Landroidx/compose/foundation/text/selection/SelectionLayout;)Z", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class SelectionLayoutKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final ResolvedTextDirection getTextDirectionForOffset(TextLayoutResult textLayoutResult, int i5) {
        return isOffsetAnEmptyLine(textLayoutResult, i5) ? textLayoutResult.getParagraphDirection(i5) : textLayoutResult.getBidiRunDirection(i5);
    }

    /* renamed from: getTextFieldSelectionLayout-RcvT-LA, reason: not valid java name */
    public static final SelectionLayout m629getTextFieldSelectionLayoutRcvTLA(TextLayoutResult textLayoutResult, int i5, int i6, int i7, long j5, boolean z5, boolean z6) {
        return new SingleSelectionLayout(z6, 1, 1, z5 ? null : new Selection(new Selection.AnchorInfo(getTextDirectionForOffset(textLayoutResult, TextRange.m2285getStartimpl(j5)), TextRange.m2285getStartimpl(j5), 1L), new Selection.AnchorInfo(getTextDirectionForOffset(textLayoutResult, TextRange.m2280getEndimpl(j5)), TextRange.m2280getEndimpl(j5), 1L), TextRange.m2284getReversedimpl(j5)), new SelectableInfo(1L, 1, i5, i6, i7, textLayoutResult));
    }

    public static final boolean isCollapsed(Selection selection, SelectionLayout selectionLayout) {
        if (selection == null || selectionLayout == null) {
            return true;
        }
        if (selection.getStart().getSelectableId() == selection.getEnd().getSelectableId()) {
            return selection.getStart().getOffset() == selection.getEnd().getOffset();
        }
        if ((selection.getHandlesCrossed() ? selection.getStart() : selection.getEnd()).getOffset() != 0) {
            return false;
        }
        if (selectionLayout.getFirstInfo().getTextLength() != (selection.getHandlesCrossed() ? selection.getEnd() : selection.getStart()).getOffset()) {
            return false;
        }
        final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        ref$BooleanRef.element = true;
        selectionLayout.forEachMiddleInfo(new Function1<SelectableInfo, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionLayoutKt$isCollapsed$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SelectableInfo selectableInfo) {
                invoke2(selectableInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SelectableInfo selectableInfo) {
                if (selectableInfo.getInputText().length() > 0) {
                    Ref$BooleanRef.this.element = false;
                }
            }
        });
        return ref$BooleanRef.element;
    }

    private static final boolean isOffsetAnEmptyLine(TextLayoutResult textLayoutResult, int i5) {
        if (textLayoutResult.getLayoutInput().getText().length() == 0) {
            return true;
        }
        int lineForOffset = textLayoutResult.getLineForOffset(i5);
        return (i5 == 0 || lineForOffset != textLayoutResult.getLineForOffset(i5 + (-1))) && (i5 == textLayoutResult.getLayoutInput().getText().length() || lineForOffset != textLayoutResult.getLineForOffset(i5 + 1));
    }
}
