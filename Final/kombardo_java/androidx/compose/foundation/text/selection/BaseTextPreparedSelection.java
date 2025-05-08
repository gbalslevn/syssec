package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.StringHelpersKt;
import androidx.compose.foundation.text.StringHelpers_androidKt;
import androidx.compose.foundation.text.selection.BaseTextPreparedSelection;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b/\n\u0002\u0010\u000e\n\u0002\b\u0005\b \u0018\u0000 f*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00002\u00020\u0002:\u0001fB1\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0012\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0012\u0010\u0010J\u000f\u0010\u0013\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0013\u0010\u0010J\u000f\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001e\u0010\u0019\u001a\u00020\u0017*\u00020\u00072\b\b\u0002\u0010\u0018\u001a\u00020\u0017H\u0082\u0010¢\u0006\u0004\b\u0019\u0010\u001aJ\u001e\u0010\u001b\u001a\u00020\u0017*\u00020\u00072\b\b\u0002\u0010\u0018\u001a\u00020\u0017H\u0082\u0010¢\u0006\u0004\b\u001b\u0010\u001aJ\u001d\u0010\u001c\u001a\u00020\u0017*\u00020\u00072\b\b\u0002\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u001c\u0010\u001aJ\u001d\u0010\u001d\u001a\u00020\u0017*\u00020\u00072\b\b\u0002\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u001d\u0010\u001aJ\u001b\u0010\u001f\u001a\u00020\u0017*\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u001f\u0010\u001aJ\u000f\u0010 \u001a\u00020\u0017H\u0002¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\"\u0010!J\u000f\u0010#\u001a\u00020\u0017H\u0002¢\u0006\u0004\b#\u0010!J\u0017\u0010%\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u0017H\u0002¢\u0006\u0004\b%\u0010&J\u0017\u0010(\u001a\u00020'2\u0006\u0010$\u001a\u00020\u0017H\u0004¢\u0006\u0004\b(\u0010)J\u001f\u0010,\u001a\u00020'2\u0006\u0010*\u001a\u00020\u00172\u0006\u0010+\u001a\u00020\u0017H\u0004¢\u0006\u0004\b,\u0010-J\r\u0010.\u001a\u00028\u0000¢\u0006\u0004\b.\u0010\u0010J\r\u0010/\u001a\u00028\u0000¢\u0006\u0004\b/\u0010\u0010J\r\u00100\u001a\u00028\u0000¢\u0006\u0004\b0\u0010\u0010J\r\u00101\u001a\u00028\u0000¢\u0006\u0004\b1\u0010\u0010J!\u00104\u001a\u00028\u00002\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020'02¢\u0006\u0004\b4\u00105J!\u00106\u001a\u00028\u00002\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020'02¢\u0006\u0004\b6\u00105J\r\u00107\u001a\u00020\u0017¢\u0006\u0004\b7\u0010!J\r\u00108\u001a\u00020\u0017¢\u0006\u0004\b8\u0010!J\r\u00109\u001a\u00028\u0000¢\u0006\u0004\b9\u0010\u0010J\r\u0010:\u001a\u00028\u0000¢\u0006\u0004\b:\u0010\u0010J\r\u0010;\u001a\u00028\u0000¢\u0006\u0004\b;\u0010\u0010J\r\u0010<\u001a\u00028\u0000¢\u0006\u0004\b<\u0010\u0010J\u000f\u0010=\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b=\u0010>J\u000f\u0010?\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b?\u0010>J\r\u0010@\u001a\u00028\u0000¢\u0006\u0004\b@\u0010\u0010J\r\u0010A\u001a\u00028\u0000¢\u0006\u0004\bA\u0010\u0010J\r\u0010B\u001a\u00028\u0000¢\u0006\u0004\bB\u0010\u0010J\r\u0010C\u001a\u00028\u0000¢\u0006\u0004\bC\u0010\u0010J\u000f\u0010D\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\bD\u0010>J\r\u0010E\u001a\u00028\u0000¢\u0006\u0004\bE\u0010\u0010J\u000f\u0010F\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\bF\u0010>J\r\u0010G\u001a\u00028\u0000¢\u0006\u0004\bG\u0010\u0010J\r\u0010H\u001a\u00028\u0000¢\u0006\u0004\bH\u0010\u0010J\r\u0010I\u001a\u00028\u0000¢\u0006\u0004\bI\u0010\u0010J\r\u0010J\u001a\u00028\u0000¢\u0006\u0004\bJ\u0010\u0010R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010K\u001a\u0004\bL\u0010MR\u001d\u0010\u0006\u001a\u00020\u00058\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0006\u0010N\u001a\u0004\bO\u0010PR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010Q\u001a\u0004\bR\u0010SR\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010T\u001a\u0004\bU\u0010VR\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010W\u001a\u0004\bX\u0010YR(\u0010Z\u001a\u00020\u00058\u0006@\u0006X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\bZ\u0010N\u001a\u0004\b[\u0010P\"\u0004\b\\\u0010]R\"\u0010^\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b^\u0010K\u001a\u0004\b_\u0010M\"\u0004\b`\u0010aR\u0014\u0010e\u001a\u00020b8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bc\u0010d\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006g"}, d2 = {"Landroidx/compose/foundation/text/selection/BaseTextPreparedSelection;", "T", BuildConfig.FLAVOR, "Landroidx/compose/ui/text/AnnotatedString;", "originalText", "Landroidx/compose/ui/text/TextRange;", "originalSelection", "Landroidx/compose/ui/text/TextLayoutResult;", "layoutResult", "Landroidx/compose/ui/text/input/OffsetMapping;", "offsetMapping", "Landroidx/compose/foundation/text/selection/TextPreparedSelectionState;", "state", "<init>", "(Landroidx/compose/ui/text/AnnotatedString;JLandroidx/compose/ui/text/TextLayoutResult;Landroidx/compose/ui/text/input/OffsetMapping;Landroidx/compose/foundation/text/selection/TextPreparedSelectionState;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "moveCursorPrev", "()Landroidx/compose/foundation/text/selection/BaseTextPreparedSelection;", "moveCursorNext", "moveCursorNextByWord", "moveCursorPrevByWord", BuildConfig.FLAVOR, "isLtr", "()Z", BuildConfig.FLAVOR, "currentOffset", "getNextWordOffsetForLayout", "(Landroidx/compose/ui/text/TextLayoutResult;I)I", "getPrevWordOffset", "getLineStartByOffsetForLayout", "getLineEndByOffsetForLayout", "linesAmount", "jumpByLinesOffset", "transformedEndOffset", "()I", "transformedMinOffset", "transformedMaxOffset", "offset", "charOffset", "(I)I", BuildConfig.FLAVOR, "setCursor", "(I)V", "start", "end", "setSelection", "(II)V", "selectAll", "deselect", "moveCursorLeft", "moveCursorRight", "Lkotlin/Function1;", "or", "collapseLeftOr", "(Lkotlin/jvm/functions/Function1;)Landroidx/compose/foundation/text/selection/BaseTextPreparedSelection;", "collapseRightOr", "getPrecedingCharacterIndex", "getNextCharacterIndex", "moveCursorToHome", "moveCursorToEnd", "moveCursorLeftByWord", "moveCursorRightByWord", "getNextWordOffset", "()Ljava/lang/Integer;", "getPreviousWordOffset", "moveCursorPrevByParagraph", "moveCursorNextByParagraph", "moveCursorUpByLine", "moveCursorDownByLine", "getLineStartByOffset", "moveCursorToLineStart", "getLineEndByOffset", "moveCursorToLineEnd", "moveCursorToLineLeftSide", "moveCursorToLineRightSide", "selectMovement", "Landroidx/compose/ui/text/AnnotatedString;", "getOriginalText", "()Landroidx/compose/ui/text/AnnotatedString;", "J", "getOriginalSelection-d9O1mEE", "()J", "Landroidx/compose/ui/text/TextLayoutResult;", "getLayoutResult", "()Landroidx/compose/ui/text/TextLayoutResult;", "Landroidx/compose/ui/text/input/OffsetMapping;", "getOffsetMapping", "()Landroidx/compose/ui/text/input/OffsetMapping;", "Landroidx/compose/foundation/text/selection/TextPreparedSelectionState;", "getState", "()Landroidx/compose/foundation/text/selection/TextPreparedSelectionState;", "selection", "getSelection-d9O1mEE", "setSelection-5zc-tL8", "(J)V", "annotatedString", "getAnnotatedString", "setAnnotatedString", "(Landroidx/compose/ui/text/AnnotatedString;)V", BuildConfig.FLAVOR, "getText$foundation_release", "()Ljava/lang/String;", "text", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class BaseTextPreparedSelection<T extends BaseTextPreparedSelection<T>> {
    private AnnotatedString annotatedString;
    private final TextLayoutResult layoutResult;
    private final OffsetMapping offsetMapping;
    private final long originalSelection;
    private final AnnotatedString originalText;
    private long selection;
    private final TextPreparedSelectionState state;
    public static final int $stable = 8;

    public /* synthetic */ BaseTextPreparedSelection(AnnotatedString annotatedString, long j5, TextLayoutResult textLayoutResult, OffsetMapping offsetMapping, TextPreparedSelectionState textPreparedSelectionState, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, j5, textLayoutResult, offsetMapping, textPreparedSelectionState);
    }

    private final int charOffset(int offset) {
        return RangesKt.coerceAtMost(offset, getText$foundation_release().length() - 1);
    }

    private final int getLineEndByOffsetForLayout(TextLayoutResult textLayoutResult, int i5) {
        return this.offsetMapping.transformedToOriginal(textLayoutResult.getLineEnd(textLayoutResult.getLineForOffset(i5), true));
    }

    static /* synthetic */ int getLineEndByOffsetForLayout$default(BaseTextPreparedSelection baseTextPreparedSelection, TextLayoutResult textLayoutResult, int i5, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getLineEndByOffsetForLayout");
        }
        if ((i6 & 1) != 0) {
            i5 = baseTextPreparedSelection.transformedMaxOffset();
        }
        return baseTextPreparedSelection.getLineEndByOffsetForLayout(textLayoutResult, i5);
    }

    private final int getLineStartByOffsetForLayout(TextLayoutResult textLayoutResult, int i5) {
        return this.offsetMapping.transformedToOriginal(textLayoutResult.getLineStart(textLayoutResult.getLineForOffset(i5)));
    }

    static /* synthetic */ int getLineStartByOffsetForLayout$default(BaseTextPreparedSelection baseTextPreparedSelection, TextLayoutResult textLayoutResult, int i5, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getLineStartByOffsetForLayout");
        }
        if ((i6 & 1) != 0) {
            i5 = baseTextPreparedSelection.transformedMinOffset();
        }
        return baseTextPreparedSelection.getLineStartByOffsetForLayout(textLayoutResult, i5);
    }

    private final int getNextWordOffsetForLayout(TextLayoutResult textLayoutResult, int i5) {
        while (i5 < this.originalText.length()) {
            long m2272getWordBoundaryjx7JFs = textLayoutResult.m2272getWordBoundaryjx7JFs(charOffset(i5));
            if (TextRange.m2280getEndimpl(m2272getWordBoundaryjx7JFs) > i5) {
                return this.offsetMapping.transformedToOriginal(TextRange.m2280getEndimpl(m2272getWordBoundaryjx7JFs));
            }
            i5++;
        }
        return this.originalText.length();
    }

    static /* synthetic */ int getNextWordOffsetForLayout$default(BaseTextPreparedSelection baseTextPreparedSelection, TextLayoutResult textLayoutResult, int i5, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getNextWordOffsetForLayout");
        }
        if ((i6 & 1) != 0) {
            i5 = baseTextPreparedSelection.transformedEndOffset();
        }
        return baseTextPreparedSelection.getNextWordOffsetForLayout(textLayoutResult, i5);
    }

    private final int getPrevWordOffset(TextLayoutResult textLayoutResult, int i5) {
        while (i5 > 0) {
            long m2272getWordBoundaryjx7JFs = textLayoutResult.m2272getWordBoundaryjx7JFs(charOffset(i5));
            if (TextRange.m2285getStartimpl(m2272getWordBoundaryjx7JFs) < i5) {
                return this.offsetMapping.transformedToOriginal(TextRange.m2285getStartimpl(m2272getWordBoundaryjx7JFs));
            }
            i5--;
        }
        return 0;
    }

    static /* synthetic */ int getPrevWordOffset$default(BaseTextPreparedSelection baseTextPreparedSelection, TextLayoutResult textLayoutResult, int i5, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPrevWordOffset");
        }
        if ((i6 & 1) != 0) {
            i5 = baseTextPreparedSelection.transformedEndOffset();
        }
        return baseTextPreparedSelection.getPrevWordOffset(textLayoutResult, i5);
    }

    private final boolean isLtr() {
        TextLayoutResult textLayoutResult = this.layoutResult;
        return (textLayoutResult != null ? textLayoutResult.getParagraphDirection(transformedEndOffset()) : null) != ResolvedTextDirection.Rtl;
    }

    private final int jumpByLinesOffset(TextLayoutResult textLayoutResult, int i5) {
        int transformedEndOffset = transformedEndOffset();
        if (this.state.getCachedX() == null) {
            this.state.setCachedX(Float.valueOf(textLayoutResult.getCursorRect(transformedEndOffset).getLeft()));
        }
        int lineForOffset = textLayoutResult.getLineForOffset(transformedEndOffset) + i5;
        if (lineForOffset < 0) {
            return 0;
        }
        if (lineForOffset >= textLayoutResult.getLineCount()) {
            return getText$foundation_release().length();
        }
        float lineBottom = textLayoutResult.getLineBottom(lineForOffset) - 1;
        Float cachedX = this.state.getCachedX();
        Intrinsics.checkNotNull(cachedX);
        float floatValue = cachedX.floatValue();
        if ((isLtr() && floatValue >= textLayoutResult.getLineRight(lineForOffset)) || (!isLtr() && floatValue <= textLayoutResult.getLineLeft(lineForOffset))) {
            return textLayoutResult.getLineEnd(lineForOffset, true);
        }
        return this.offsetMapping.transformedToOriginal(textLayoutResult.m2270getOffsetForPositionk4lQ0M(OffsetKt.Offset(cachedX.floatValue(), lineBottom)));
    }

    private final T moveCursorNext() {
        int nextCharacterIndex;
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0 && (nextCharacterIndex = getNextCharacterIndex()) != -1) {
            setCursor(nextCharacterIndex);
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    private final T moveCursorNextByWord() {
        Integer nextWordOffset;
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0 && (nextWordOffset = getNextWordOffset()) != null) {
            setCursor(nextWordOffset.intValue());
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    private final T moveCursorPrev() {
        int precedingCharacterIndex;
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0 && (precedingCharacterIndex = getPrecedingCharacterIndex()) != -1) {
            setCursor(precedingCharacterIndex);
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    private final T moveCursorPrevByWord() {
        Integer previousWordOffset;
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0 && (previousWordOffset = getPreviousWordOffset()) != null) {
            setCursor(previousWordOffset.intValue());
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    private final int transformedEndOffset() {
        return this.offsetMapping.originalToTransformed(TextRange.m2280getEndimpl(this.selection));
    }

    private final int transformedMaxOffset() {
        return this.offsetMapping.originalToTransformed(TextRange.m2282getMaximpl(this.selection));
    }

    private final int transformedMinOffset() {
        return this.offsetMapping.originalToTransformed(TextRange.m2283getMinimpl(this.selection));
    }

    public final T collapseLeftOr(Function1<? super T, Unit> or) {
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            if (TextRange.m2279getCollapsedimpl(this.selection)) {
                Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection.collapseLeftOr$lambda$4");
                or.invoke(this);
            } else if (isLtr()) {
                setCursor(TextRange.m2283getMinimpl(this.selection));
            } else {
                setCursor(TextRange.m2282getMaximpl(this.selection));
            }
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final T collapseRightOr(Function1<? super T, Unit> or) {
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            if (TextRange.m2279getCollapsedimpl(this.selection)) {
                Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection.collapseRightOr$lambda$5");
                or.invoke(this);
            } else if (isLtr()) {
                setCursor(TextRange.m2282getMaximpl(this.selection));
            } else {
                setCursor(TextRange.m2283getMinimpl(this.selection));
            }
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final T deselect() {
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            setCursor(TextRange.m2280getEndimpl(this.selection));
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final AnnotatedString getAnnotatedString() {
        return this.annotatedString;
    }

    public final Integer getLineEndByOffset() {
        TextLayoutResult textLayoutResult = this.layoutResult;
        if (textLayoutResult != null) {
            return Integer.valueOf(getLineEndByOffsetForLayout$default(this, textLayoutResult, 0, 1, null));
        }
        return null;
    }

    public final Integer getLineStartByOffset() {
        TextLayoutResult textLayoutResult = this.layoutResult;
        if (textLayoutResult != null) {
            return Integer.valueOf(getLineStartByOffsetForLayout$default(this, textLayoutResult, 0, 1, null));
        }
        return null;
    }

    public final int getNextCharacterIndex() {
        return StringHelpers_androidKt.findFollowingBreak(this.annotatedString.getText(), TextRange.m2280getEndimpl(this.selection));
    }

    public final Integer getNextWordOffset() {
        TextLayoutResult textLayoutResult = this.layoutResult;
        if (textLayoutResult != null) {
            return Integer.valueOf(getNextWordOffsetForLayout$default(this, textLayoutResult, 0, 1, null));
        }
        return null;
    }

    public final OffsetMapping getOffsetMapping() {
        return this.offsetMapping;
    }

    public final int getPrecedingCharacterIndex() {
        return StringHelpers_androidKt.findPrecedingBreak(this.annotatedString.getText(), TextRange.m2280getEndimpl(this.selection));
    }

    public final Integer getPreviousWordOffset() {
        TextLayoutResult textLayoutResult = this.layoutResult;
        if (textLayoutResult != null) {
            return Integer.valueOf(getPrevWordOffset$default(this, textLayoutResult, 0, 1, null));
        }
        return null;
    }

    /* renamed from: getSelection-d9O1mEE, reason: not valid java name and from getter */
    public final long getSelection() {
        return this.selection;
    }

    public final TextPreparedSelectionState getState() {
        return this.state;
    }

    public final String getText$foundation_release() {
        return this.annotatedString.getText();
    }

    public final T moveCursorDownByLine() {
        TextLayoutResult textLayoutResult;
        if (getText$foundation_release().length() > 0 && (textLayoutResult = this.layoutResult) != null) {
            setCursor(jumpByLinesOffset(textLayoutResult, 1));
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final T moveCursorLeft() {
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            if (isLtr()) {
                moveCursorPrev();
            } else {
                moveCursorNext();
            }
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final T moveCursorLeftByWord() {
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            if (isLtr()) {
                moveCursorPrevByWord();
            } else {
                moveCursorNextByWord();
            }
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final T moveCursorNextByParagraph() {
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            int findParagraphEnd = StringHelpersKt.findParagraphEnd(getText$foundation_release(), TextRange.m2282getMaximpl(this.selection));
            if (findParagraphEnd == TextRange.m2282getMaximpl(this.selection) && findParagraphEnd != getText$foundation_release().length()) {
                findParagraphEnd = StringHelpersKt.findParagraphEnd(getText$foundation_release(), findParagraphEnd + 1);
            }
            setCursor(findParagraphEnd);
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final T moveCursorPrevByParagraph() {
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            int findParagraphStart = StringHelpersKt.findParagraphStart(getText$foundation_release(), TextRange.m2283getMinimpl(this.selection));
            if (findParagraphStart == TextRange.m2283getMinimpl(this.selection) && findParagraphStart != 0) {
                findParagraphStart = StringHelpersKt.findParagraphStart(getText$foundation_release(), findParagraphStart - 1);
            }
            setCursor(findParagraphStart);
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final T moveCursorRight() {
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            if (isLtr()) {
                moveCursorNext();
            } else {
                moveCursorPrev();
            }
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final T moveCursorRightByWord() {
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            if (isLtr()) {
                moveCursorNextByWord();
            } else {
                moveCursorPrevByWord();
            }
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final T moveCursorToEnd() {
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            setCursor(getText$foundation_release().length());
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final T moveCursorToHome() {
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            setCursor(0);
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final T moveCursorToLineEnd() {
        Integer lineEndByOffset;
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0 && (lineEndByOffset = getLineEndByOffset()) != null) {
            setCursor(lineEndByOffset.intValue());
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final T moveCursorToLineLeftSide() {
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            if (isLtr()) {
                moveCursorToLineStart();
            } else {
                moveCursorToLineEnd();
            }
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final T moveCursorToLineRightSide() {
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            if (isLtr()) {
                moveCursorToLineEnd();
            } else {
                moveCursorToLineStart();
            }
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final T moveCursorToLineStart() {
        Integer lineStartByOffset;
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0 && (lineStartByOffset = getLineStartByOffset()) != null) {
            setCursor(lineStartByOffset.intValue());
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final T moveCursorUpByLine() {
        TextLayoutResult textLayoutResult;
        if (getText$foundation_release().length() > 0 && (textLayoutResult = this.layoutResult) != null) {
            setCursor(jumpByLinesOffset(textLayoutResult, -1));
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final T selectAll() {
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            setSelection(0, getText$foundation_release().length());
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final T selectMovement() {
        if (getText$foundation_release().length() > 0) {
            this.selection = TextRangeKt.TextRange(TextRange.m2285getStartimpl(this.originalSelection), TextRange.m2280getEndimpl(this.selection));
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setCursor(int offset) {
        setSelection(offset, offset);
    }

    protected final void setSelection(int start, int end) {
        this.selection = TextRangeKt.TextRange(start, end);
    }

    private BaseTextPreparedSelection(AnnotatedString annotatedString, long j5, TextLayoutResult textLayoutResult, OffsetMapping offsetMapping, TextPreparedSelectionState textPreparedSelectionState) {
        this.originalText = annotatedString;
        this.originalSelection = j5;
        this.layoutResult = textLayoutResult;
        this.offsetMapping = offsetMapping;
        this.state = textPreparedSelectionState;
        this.selection = j5;
        this.annotatedString = annotatedString;
    }
}
