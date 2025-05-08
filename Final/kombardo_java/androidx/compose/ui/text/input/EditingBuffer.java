package androidx.compose.ui.text.input;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\f\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u001d\b\u0007\u0018\u0000 D2\u00020\u0001:\u0001DB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\u000b\u001a\u00020\bH\u0000¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0080\u0002¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0014H\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\fH\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\fH\u0000¢\u0006\u0004\b\u001c\u0010\u001aJ\u001f\u0010\u001f\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\fH\u0000¢\u0006\u0004\b\u001e\u0010\u001aJ\u000f\u0010\"\u001a\u00020\u0015H\u0000¢\u0006\u0004\b \u0010!J\u000f\u0010#\u001a\u00020\u0014H\u0016¢\u0006\u0004\b#\u0010$J\u000f\u0010'\u001a\u00020\u0002H\u0000¢\u0006\u0004\b%\u0010&R\u0014\u0010)\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R*\u0010,\u001a\u00020\f2\u0006\u0010+\u001a\u00020\f8\u0000@BX\u0080\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R*\u00102\u001a\u00020\f2\u0006\u0010+\u001a\u00020\f8\u0000@BX\u0080\u000e¢\u0006\u0012\n\u0004\b2\u0010-\u001a\u0004\b3\u0010/\"\u0004\b4\u00101R$\u00106\u001a\u00020\f2\u0006\u00105\u001a\u00020\f8\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\b6\u0010-\u001a\u0004\b7\u0010/R$\u00108\u001a\u00020\f2\u0006\u00105\u001a\u00020\f8\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\b8\u0010-\u001a\u0004\b9\u0010/R\u001c\u0010<\u001a\u0004\u0018\u00010\u00048@X\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b:\u0010;R\u001a\u0010\u0005\u001a\u00020\u00048@X\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b=\u0010>R$\u0010?\u001a\u00020\f2\u0006\u0010?\u001a\u00020\f8@@@X\u0080\u000e¢\u0006\f\u001a\u0004\b@\u0010/\"\u0004\bA\u00101R\u0014\u0010C\u001a\u00020\f8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bB\u0010/\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006E"}, d2 = {"Landroidx/compose/ui/text/input/EditingBuffer;", BuildConfig.FLAVOR, "Landroidx/compose/ui/text/AnnotatedString;", "text", "Landroidx/compose/ui/text/TextRange;", "selection", "<init>", "(Landroidx/compose/ui/text/AnnotatedString;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", BuildConfig.FLAVOR, "hasComposition$ui_text_release", "()Z", "hasComposition", BuildConfig.FLAVOR, "index", BuildConfig.FLAVOR, "get$ui_text_release", "(I)C", "get", "start", "end", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "replace$ui_text_release", "(IILjava/lang/String;)V", "replace", "delete$ui_text_release", "(II)V", "delete", "setSelection$ui_text_release", "setSelection", "setComposition$ui_text_release", "setComposition", "commitComposition$ui_text_release", "()V", "commitComposition", "toString", "()Ljava/lang/String;", "toAnnotatedString$ui_text_release", "()Landroidx/compose/ui/text/AnnotatedString;", "toAnnotatedString", "Landroidx/compose/ui/text/input/PartialGapBuffer;", "gapBuffer", "Landroidx/compose/ui/text/input/PartialGapBuffer;", "value", "selectionStart", "I", "getSelectionStart$ui_text_release", "()I", "setSelectionStart", "(I)V", "selectionEnd", "getSelectionEnd$ui_text_release", "setSelectionEnd", "<set-?>", "compositionStart", "getCompositionStart$ui_text_release", "compositionEnd", "getCompositionEnd$ui_text_release", "getComposition-MzsxiRA$ui_text_release", "()Landroidx/compose/ui/text/TextRange;", "composition", "getSelection-d9O1mEE$ui_text_release", "()J", "cursor", "getCursor$ui_text_release", "setCursor$ui_text_release", "getLength$ui_text_release", "length", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class EditingBuffer {
    private int compositionEnd;
    private int compositionStart;
    private final PartialGapBuffer gapBuffer;
    private int selectionEnd;
    private int selectionStart;
    public static final int $stable = 8;

    public /* synthetic */ EditingBuffer(AnnotatedString annotatedString, long j5, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, j5);
    }

    private final void setSelectionEnd(int i5) {
        if (i5 >= 0) {
            this.selectionEnd = i5;
            return;
        }
        throw new IllegalArgumentException(("Cannot set selectionEnd to a negative value: " + i5).toString());
    }

    private final void setSelectionStart(int i5) {
        if (i5 >= 0) {
            this.selectionStart = i5;
            return;
        }
        throw new IllegalArgumentException(("Cannot set selectionStart to a negative value: " + i5).toString());
    }

    public final void commitComposition$ui_text_release() {
        this.compositionStart = -1;
        this.compositionEnd = -1;
    }

    public final void delete$ui_text_release(int start, int end) {
        long TextRange = TextRangeKt.TextRange(start, end);
        this.gapBuffer.replace(start, end, BuildConfig.FLAVOR);
        long m2374updateRangeAfterDeletepWDy79M = EditingBufferKt.m2374updateRangeAfterDeletepWDy79M(TextRangeKt.TextRange(this.selectionStart, this.selectionEnd), TextRange);
        setSelectionStart(TextRange.m2283getMinimpl(m2374updateRangeAfterDeletepWDy79M));
        setSelectionEnd(TextRange.m2282getMaximpl(m2374updateRangeAfterDeletepWDy79M));
        if (hasComposition$ui_text_release()) {
            long m2374updateRangeAfterDeletepWDy79M2 = EditingBufferKt.m2374updateRangeAfterDeletepWDy79M(TextRangeKt.TextRange(this.compositionStart, this.compositionEnd), TextRange);
            if (TextRange.m2279getCollapsedimpl(m2374updateRangeAfterDeletepWDy79M2)) {
                commitComposition$ui_text_release();
            } else {
                this.compositionStart = TextRange.m2283getMinimpl(m2374updateRangeAfterDeletepWDy79M2);
                this.compositionEnd = TextRange.m2282getMaximpl(m2374updateRangeAfterDeletepWDy79M2);
            }
        }
    }

    public final char get$ui_text_release(int index) {
        return this.gapBuffer.get(index);
    }

    /* renamed from: getComposition-MzsxiRA$ui_text_release, reason: not valid java name */
    public final TextRange m2372getCompositionMzsxiRA$ui_text_release() {
        if (hasComposition$ui_text_release()) {
            return TextRange.m2273boximpl(TextRangeKt.TextRange(this.compositionStart, this.compositionEnd));
        }
        return null;
    }

    /* renamed from: getCompositionEnd$ui_text_release, reason: from getter */
    public final int getCompositionEnd() {
        return this.compositionEnd;
    }

    /* renamed from: getCompositionStart$ui_text_release, reason: from getter */
    public final int getCompositionStart() {
        return this.compositionStart;
    }

    public final int getCursor$ui_text_release() {
        int i5 = this.selectionStart;
        int i6 = this.selectionEnd;
        if (i5 == i6) {
            return i6;
        }
        return -1;
    }

    public final int getLength$ui_text_release() {
        return this.gapBuffer.getLength();
    }

    /* renamed from: getSelection-d9O1mEE$ui_text_release, reason: not valid java name */
    public final long m2373getSelectiond9O1mEE$ui_text_release() {
        return TextRangeKt.TextRange(this.selectionStart, this.selectionEnd);
    }

    /* renamed from: getSelectionEnd$ui_text_release, reason: from getter */
    public final int getSelectionEnd() {
        return this.selectionEnd;
    }

    /* renamed from: getSelectionStart$ui_text_release, reason: from getter */
    public final int getSelectionStart() {
        return this.selectionStart;
    }

    public final boolean hasComposition$ui_text_release() {
        return this.compositionStart != -1;
    }

    public final void replace$ui_text_release(int start, int end, String text) {
        if (start < 0 || start > this.gapBuffer.getLength()) {
            throw new IndexOutOfBoundsException("start (" + start + ") offset is outside of text region " + this.gapBuffer.getLength());
        }
        if (end < 0 || end > this.gapBuffer.getLength()) {
            throw new IndexOutOfBoundsException("end (" + end + ") offset is outside of text region " + this.gapBuffer.getLength());
        }
        if (start <= end) {
            this.gapBuffer.replace(start, end, text);
            setSelectionStart(text.length() + start);
            setSelectionEnd(start + text.length());
            this.compositionStart = -1;
            this.compositionEnd = -1;
            return;
        }
        throw new IllegalArgumentException("Do not set reversed range: " + start + " > " + end);
    }

    public final void setComposition$ui_text_release(int start, int end) {
        if (start < 0 || start > this.gapBuffer.getLength()) {
            throw new IndexOutOfBoundsException("start (" + start + ") offset is outside of text region " + this.gapBuffer.getLength());
        }
        if (end < 0 || end > this.gapBuffer.getLength()) {
            throw new IndexOutOfBoundsException("end (" + end + ") offset is outside of text region " + this.gapBuffer.getLength());
        }
        if (start < end) {
            this.compositionStart = start;
            this.compositionEnd = end;
            return;
        }
        throw new IllegalArgumentException("Do not set reversed or empty range: " + start + " > " + end);
    }

    public final void setCursor$ui_text_release(int i5) {
        setSelection$ui_text_release(i5, i5);
    }

    public final void setSelection$ui_text_release(int start, int end) {
        if (start < 0 || start > this.gapBuffer.getLength()) {
            throw new IndexOutOfBoundsException("start (" + start + ") offset is outside of text region " + this.gapBuffer.getLength());
        }
        if (end < 0 || end > this.gapBuffer.getLength()) {
            throw new IndexOutOfBoundsException("end (" + end + ") offset is outside of text region " + this.gapBuffer.getLength());
        }
        if (start <= end) {
            setSelectionStart(start);
            setSelectionEnd(end);
            return;
        }
        throw new IllegalArgumentException("Do not set reversed range: " + start + " > " + end);
    }

    public final AnnotatedString toAnnotatedString$ui_text_release() {
        return new AnnotatedString(toString(), null, null, 6, null);
    }

    public String toString() {
        return this.gapBuffer.toString();
    }

    private EditingBuffer(AnnotatedString annotatedString, long j5) {
        this.gapBuffer = new PartialGapBuffer(annotatedString.getText());
        this.selectionStart = TextRange.m2283getMinimpl(j5);
        this.selectionEnd = TextRange.m2282getMaximpl(j5);
        this.compositionStart = -1;
        this.compositionEnd = -1;
        int m2283getMinimpl = TextRange.m2283getMinimpl(j5);
        int m2282getMaximpl = TextRange.m2282getMaximpl(j5);
        if (m2283getMinimpl >= 0 && m2283getMinimpl <= annotatedString.length()) {
            if (m2282getMaximpl < 0 || m2282getMaximpl > annotatedString.length()) {
                throw new IndexOutOfBoundsException("end (" + m2282getMaximpl + ") offset is outside of text region " + annotatedString.length());
            }
            if (m2283getMinimpl <= m2282getMaximpl) {
                return;
            }
            throw new IllegalArgumentException("Do not set reversed range: " + m2283getMinimpl + " > " + m2282getMaximpl);
        }
        throw new IndexOutOfBoundsException("start (" + m2283getMinimpl + ") offset is outside of text region " + annotatedString.length());
    }
}
