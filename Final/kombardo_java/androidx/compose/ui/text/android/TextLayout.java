package androidx.compose.ui.text.android;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Trace;
import android.text.BoringLayout;
import android.text.Layout;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.compose.ui.text.android.selection.WordIterator;
import androidx.compose.ui.text.android.style.BaselineShiftSpan;
import androidx.compose.ui.text.android.style.IndentationFixSpan_androidKt;
import androidx.compose.ui.text.android.style.LineHeightStyleSpan;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0000\u0018\u00002\u00020\u0001BÅ\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\f\u001a\u00020\b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\b\b\u0003\u0010\u000e\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\b\u0012\b\b\u0002\u0010\u0013\u001a\u00020\b\u0012\b\b\u0002\u0010\u0014\u001a\u00020\b\u0012\b\b\u0002\u0010\u0015\u001a\u00020\b\u0012\b\b\u0002\u0010\u0016\u001a\u00020\b\u0012\b\b\u0002\u0010\u0017\u001a\u00020\b\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\bH\u0002¢\u0006\u0004\b \u0010!J\u0015\u0010#\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\b¢\u0006\u0004\b#\u0010!J\u0015\u0010$\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\b¢\u0006\u0004\b$\u0010!J\u0015\u0010%\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\b¢\u0006\u0004\b%\u0010!J\u0015\u0010&\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\b¢\u0006\u0004\b&\u0010!J\u0015\u0010'\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\b¢\u0006\u0004\b'\u0010!J\u0015\u0010(\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\b¢\u0006\u0004\b(\u0010!J\u0015\u0010)\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\b¢\u0006\u0004\b)\u0010*J\u0015\u0010+\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\b¢\u0006\u0004\b+\u0010*J\u0015\u0010,\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\b¢\u0006\u0004\b,\u0010*J\u0015\u0010-\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\b¢\u0006\u0004\b-\u0010*J\u0015\u0010.\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\b¢\u0006\u0004\b.\u0010*J\u0015\u00100\u001a\u00020\b2\u0006\u0010/\u001a\u00020\b¢\u0006\u0004\b0\u0010*J\u001d\u00102\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\b2\u0006\u00101\u001a\u00020\u0004¢\u0006\u0004\b2\u00103J\u001f\u00106\u001a\u00020\u00042\u0006\u00104\u001a\u00020\b2\b\b\u0002\u00105\u001a\u00020\u000f¢\u0006\u0004\b6\u00107J\u001f\u00108\u001a\u00020\u00042\u0006\u00104\u001a\u00020\b2\b\b\u0002\u00105\u001a\u00020\u000f¢\u0006\u0004\b8\u00107J\u0015\u00109\u001a\u00020\b2\u0006\u00104\u001a\u00020\b¢\u0006\u0004\b9\u0010*J\u0015\u0010:\u001a\u00020\u000f2\u0006\u00104\u001a\u00020\b¢\u0006\u0004\b:\u0010;J\u0015\u0010<\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\b¢\u0006\u0004\b<\u0010*J%\u0010B\u001a\u00020A2\u0006\u0010=\u001a\u00020\b2\u0006\u0010>\u001a\u00020\b2\u0006\u0010@\u001a\u00020?¢\u0006\u0004\bB\u0010CJ9\u0010I\u001a\u0004\u0018\u00010\u00182\u0006\u0010E\u001a\u00020D2\u0006\u0010F\u001a\u00020\b2\u0018\u0010H\u001a\u0014\u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u00020\u000f0G¢\u0006\u0004\bI\u0010JJ\u001f\u0010O\u001a\u00020A2\u0006\u0010\"\u001a\u00020\b2\u0006\u0010L\u001a\u00020KH\u0000¢\u0006\u0004\bM\u0010NJ-\u0010S\u001a\u00020A2\u0006\u0010P\u001a\u00020\b2\u0006\u0010Q\u001a\u00020\b2\u0006\u0010L\u001a\u00020K2\u0006\u0010R\u001a\u00020\b¢\u0006\u0004\bS\u0010TJ\u0015\u0010U\u001a\u00020D2\u0006\u00104\u001a\u00020\b¢\u0006\u0004\bU\u0010VJ\u0015\u0010Y\u001a\u00020A2\u0006\u0010X\u001a\u00020W¢\u0006\u0004\bY\u0010ZJ\u000f\u0010]\u001a\u00020\u000fH\u0000¢\u0006\u0004\b[\u0010\\R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010^\u001a\u0004\b_\u0010`R\u0017\u0010\u0010\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010a\u001a\u0004\bb\u0010\\R\u0017\u0010\u0011\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0011\u0010a\u001a\u0004\bc\u0010\\R\u0017\u0010\u001c\u001a\u00020\u001b8\u0006¢\u0006\f\n\u0004\b\u001c\u0010d\u001a\u0004\be\u0010fR\u0017\u0010g\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\bg\u0010a\u001a\u0004\bh\u0010\\R\u0018\u0010j\u001a\u0004\u0018\u00010i8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bj\u0010kR \u0010m\u001a\u00020l8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\bm\u0010n\u0012\u0004\bq\u0010r\u001a\u0004\bo\u0010pR\u0017\u0010s\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\bs\u0010t\u001a\u0004\bu\u0010vR \u0010w\u001a\u00020\b8\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\bw\u0010t\u0012\u0004\by\u0010r\u001a\u0004\bx\u0010vR \u0010z\u001a\u00020\b8\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\bz\u0010t\u0012\u0004\b|\u0010r\u001a\u0004\b{\u0010vR\u0014\u0010}\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b}\u0010~R\u0014\u0010\u007f\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u007f\u0010~R\u0016\u0010\u0080\u0001\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0080\u0001\u0010aR\u001a\u0010\u0082\u0001\u001a\u0005\u0018\u00010\u0081\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0082\u0001\u0010\u0083\u0001R\u0016\u0010\u0084\u0001\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0084\u0001\u0010tR!\u0010\u0087\u0001\u001a\f\u0012\u0005\u0012\u00030\u0086\u0001\u0018\u00010\u0085\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001R\u0016\u0010E\u001a\u00030\u0089\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bE\u0010\u008a\u0001R\u001c\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u008b\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008c\u0001\u0010\u008d\u0001R\u0018\u0010\u0090\u0001\u001a\u00030\u008b\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001R\u0014\u0010\u0093\u0001\u001a\u00020i8F¢\u0006\b\u001a\u0006\b\u0091\u0001\u0010\u0092\u0001R\u0014\u0010\u0096\u0001\u001a\u00020\u00028F¢\u0006\b\u001a\u0006\b\u0094\u0001\u0010\u0095\u0001R\u0013\u0010\u0098\u0001\u001a\u00020\b8F¢\u0006\u0007\u001a\u0005\b\u0097\u0001\u0010v¨\u0006\u0099\u0001"}, d2 = {"Landroidx/compose/ui/text/android/TextLayout;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "charSequence", BuildConfig.FLAVOR, "width", "Landroid/text/TextPaint;", "textPaint", BuildConfig.FLAVOR, "alignment", "Landroid/text/TextUtils$TruncateAt;", "ellipsize", "textDirectionHeuristic", "lineSpacingMultiplier", "lineSpacingExtra", BuildConfig.FLAVOR, "includePadding", "fallbackLineSpacing", "maxLines", "breakStrategy", "lineBreakStyle", "lineBreakWordStyle", "hyphenationFrequency", "justificationMode", BuildConfig.FLAVOR, "leftIndents", "rightIndents", "Landroidx/compose/ui/text/android/LayoutIntrinsics;", "layoutIntrinsics", "<init>", "(Ljava/lang/CharSequence;FLandroid/text/TextPaint;ILandroid/text/TextUtils$TruncateAt;IFFZZIIIIII[I[ILandroidx/compose/ui/text/android/LayoutIntrinsics;)V", "line", "getHorizontalPadding", "(I)F", "lineIndex", "getLineLeft", "getLineRight", "getLineTop", "getLineBottom", "getLineBaseline", "getLineHeight", "getLineStart", "(I)I", "getLineEnd", "getLineVisibleEnd", "getLineEllipsisOffset", "getLineEllipsisCount", "vertical", "getLineForVertical", "horizontal", "getOffsetForHorizontal", "(IF)I", "offset", "upstream", "getPrimaryHorizontal", "(IZ)F", "getSecondaryHorizontal", "getLineForOffset", "isRtlCharAt", "(I)Z", "getParagraphDirection", "start", "end", "Landroid/graphics/Path;", "dest", BuildConfig.FLAVOR, "getSelectionPath", "(IILandroid/graphics/Path;)V", "Landroid/graphics/RectF;", "rect", "granularity", "Lkotlin/Function2;", "inclusionStrategy", "getRangeForRect", "(Landroid/graphics/RectF;ILkotlin/jvm/functions/Function2;)[I", BuildConfig.FLAVOR, "array", "fillLineHorizontalBounds$ui_text_release", "(I[F)V", "fillLineHorizontalBounds", "startOffset", "endOffset", "arrayStart", "fillBoundingBoxes", "(II[FI)V", "getBoundingBox", "(I)Landroid/graphics/RectF;", "Landroid/graphics/Canvas;", "canvas", "paint", "(Landroid/graphics/Canvas;)V", "isFallbackLinespacingApplied$ui_text_release", "()Z", "isFallbackLinespacingApplied", "Landroid/text/TextPaint;", "getTextPaint", "()Landroid/text/TextPaint;", "Z", "getIncludePadding", "getFallbackLineSpacing", "Landroidx/compose/ui/text/android/LayoutIntrinsics;", "getLayoutIntrinsics", "()Landroidx/compose/ui/text/android/LayoutIntrinsics;", "didExceedMaxLines", "getDidExceedMaxLines", "Landroidx/compose/ui/text/android/selection/WordIterator;", "backingWordIterator", "Landroidx/compose/ui/text/android/selection/WordIterator;", "Landroid/text/Layout;", "layout", "Landroid/text/Layout;", "getLayout", "()Landroid/text/Layout;", "getLayout$annotations", "()V", "lineCount", "I", "getLineCount", "()I", "topPadding", "getTopPadding$ui_text_release", "getTopPadding$ui_text_release$annotations", "bottomPadding", "getBottomPadding$ui_text_release", "getBottomPadding$ui_text_release$annotations", "leftPadding", "F", "rightPadding", "isBoringLayout", "Landroid/graphics/Paint$FontMetricsInt;", "lastLineFontMetrics", "Landroid/graphics/Paint$FontMetricsInt;", "lastLineExtra", BuildConfig.FLAVOR, "Landroidx/compose/ui/text/android/style/LineHeightStyleSpan;", "lineHeightSpans", "[Landroidx/compose/ui/text/android/style/LineHeightStyleSpan;", "Landroid/graphics/Rect;", "Landroid/graphics/Rect;", "Landroidx/compose/ui/text/android/LayoutHelper;", "backingLayoutHelper", "Landroidx/compose/ui/text/android/LayoutHelper;", "getLayoutHelper", "()Landroidx/compose/ui/text/android/LayoutHelper;", "layoutHelper", "getWordIterator", "()Landroidx/compose/ui/text/android/selection/WordIterator;", "wordIterator", "getText", "()Ljava/lang/CharSequence;", "text", "getHeight", "height", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextLayout {
    private LayoutHelper backingLayoutHelper;
    private WordIterator backingWordIterator;
    private final int bottomPadding;
    private final boolean didExceedMaxLines;
    private final boolean fallbackLineSpacing;
    private final boolean includePadding;
    private final boolean isBoringLayout;
    private final int lastLineExtra;
    private final Paint.FontMetricsInt lastLineFontMetrics;
    private final Layout layout;
    private final LayoutIntrinsics layoutIntrinsics;
    private final float leftPadding;
    private final int lineCount;
    private final LineHeightStyleSpan[] lineHeightSpans;
    private final Rect rect;
    private final float rightPadding;
    private final TextPaint textPaint;
    private final int topPadding;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5, types: [int] */
    /* JADX WARN: Type inference failed for: r8v7 */
    public TextLayout(CharSequence charSequence, float f5, TextPaint textPaint, int i5, TextUtils.TruncateAt truncateAt, int i6, float f6, float f7, boolean z5, boolean z6, int i7, int i8, int i9, int i10, int i11, int i12, int[] iArr, int[] iArr2, LayoutIntrinsics layoutIntrinsics) {
        boolean z7;
        boolean z8;
        TextDirectionHeuristic textDirectionHeuristic;
        Layout create;
        long verticalPaddings;
        LineHeightStyleSpan[] lineHeightSpans;
        Paint.FontMetricsInt lastLineMetrics;
        this.textPaint = textPaint;
        this.includePadding = z5;
        this.fallbackLineSpacing = z6;
        this.layoutIntrinsics = layoutIntrinsics;
        this.rect = new Rect();
        int length = charSequence.length();
        TextDirectionHeuristic textDirectionHeuristic2 = TextLayout_androidKt.getTextDirectionHeuristic(i6);
        Layout.Alignment alignment = TextAlignmentAdapter.INSTANCE.get(i5);
        boolean z9 = (charSequence instanceof Spanned) && ((Spanned) charSequence).nextSpanTransition(-1, length, BaselineShiftSpan.class) < length;
        Trace.beginSection("TextLayout:initLayout");
        try {
            BoringLayout.Metrics boringMetrics = layoutIntrinsics.getBoringMetrics();
            double d5 = f5;
            int ceil = (int) Math.ceil(d5);
            if (boringMetrics != null && layoutIntrinsics.getMaxIntrinsicWidth() <= f5 && !z9) {
                this.isBoringLayout = true;
                z7 = true;
                create = BoringLayoutFactory.INSTANCE.create(charSequence, textPaint, ceil, boringMetrics, alignment, z5, z6, truncateAt, ceil);
                textDirectionHeuristic = textDirectionHeuristic2;
                z8 = false;
            } else {
                z7 = true;
                this.isBoringLayout = false;
                z8 = false;
                textDirectionHeuristic = textDirectionHeuristic2;
                create = StaticLayoutFactory.INSTANCE.create(charSequence, textPaint, ceil, 0, charSequence.length(), textDirectionHeuristic2, alignment, i7, truncateAt, (int) Math.ceil(d5), f6, f7, i12, z5, z6, i8, i9, i10, i11, iArr, iArr2);
            }
            this.layout = create;
            Trace.endSection();
            int min = Math.min(create.getLineCount(), i7);
            this.lineCount = min;
            int i13 = min - 1;
            this.didExceedMaxLines = (min >= i7 && (create.getEllipsisCount(i13) > 0 || create.getLineEnd(i13) != charSequence.length())) ? z7 : z8;
            verticalPaddings = TextLayout_androidKt.getVerticalPaddings(this);
            lineHeightSpans = TextLayout_androidKt.getLineHeightSpans(this);
            this.lineHeightSpans = lineHeightSpans;
            long lineHeightPaddings = lineHeightSpans != null ? TextLayout_androidKt.getLineHeightPaddings(lineHeightSpans) : TextLayout_androidKt.ZeroVerticalPadding;
            this.topPadding = Math.max(VerticalPaddings.m2312getTopPaddingimpl(verticalPaddings), VerticalPaddings.m2312getTopPaddingimpl(lineHeightPaddings));
            this.bottomPadding = Math.max(VerticalPaddings.m2311getBottomPaddingimpl(verticalPaddings), VerticalPaddings.m2311getBottomPaddingimpl(lineHeightPaddings));
            lastLineMetrics = TextLayout_androidKt.getLastLineMetrics(this, textPaint, textDirectionHeuristic, lineHeightSpans);
            this.lastLineExtra = lastLineMetrics != null ? lastLineMetrics.bottom - ((int) getLineHeight(i13)) : z8;
            this.lastLineFontMetrics = lastLineMetrics;
            this.leftPadding = IndentationFixSpan_androidKt.getEllipsizedLeftPadding$default(create, i13, null, 2, null);
            this.rightPadding = IndentationFixSpan_androidKt.getEllipsizedRightPadding$default(create, i13, null, 2, null);
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    private final float getHorizontalPadding(int line) {
        if (line == this.lineCount - 1) {
            return this.leftPadding + this.rightPadding;
        }
        return 0.0f;
    }

    private final LayoutHelper getLayoutHelper() {
        LayoutHelper layoutHelper = this.backingLayoutHelper;
        if (layoutHelper != null) {
            Intrinsics.checkNotNull(layoutHelper);
            return layoutHelper;
        }
        LayoutHelper layoutHelper2 = new LayoutHelper(this.layout);
        this.backingLayoutHelper = layoutHelper2;
        return layoutHelper2;
    }

    public static /* synthetic */ float getPrimaryHorizontal$default(TextLayout textLayout, int i5, boolean z5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            z5 = false;
        }
        return textLayout.getPrimaryHorizontal(i5, z5);
    }

    public static /* synthetic */ float getSecondaryHorizontal$default(TextLayout textLayout, int i5, boolean z5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            z5 = false;
        }
        return textLayout.getSecondaryHorizontal(i5, z5);
    }

    public final void fillBoundingBoxes(int startOffset, int endOffset, float[] array, int arrayStart) {
        float secondaryDownstream;
        float secondaryUpstream;
        int length = getText().length();
        if (startOffset < 0) {
            throw new IllegalArgumentException("startOffset must be > 0");
        }
        if (startOffset >= length) {
            throw new IllegalArgumentException("startOffset must be less than text length");
        }
        if (endOffset <= startOffset) {
            throw new IllegalArgumentException("endOffset must be greater than startOffset");
        }
        if (endOffset > length) {
            throw new IllegalArgumentException("endOffset must be smaller or equal to text length");
        }
        if (array.length - arrayStart < (endOffset - startOffset) * 4) {
            throw new IllegalArgumentException("array.size - arrayStart must be greater or equal than (endOffset - startOffset) * 4");
        }
        int lineForOffset = getLineForOffset(startOffset);
        int lineForOffset2 = getLineForOffset(endOffset - 1);
        HorizontalPositionCache horizontalPositionCache = new HorizontalPositionCache(this);
        if (lineForOffset > lineForOffset2) {
            return;
        }
        while (true) {
            int lineStart = getLineStart(lineForOffset);
            int lineEnd = getLineEnd(lineForOffset);
            int min = Math.min(endOffset, lineEnd);
            float lineTop = getLineTop(lineForOffset);
            float lineBottom = getLineBottom(lineForOffset);
            boolean z5 = getParagraphDirection(lineForOffset) == 1;
            for (int max = Math.max(startOffset, lineStart); max < min; max++) {
                boolean isRtlCharAt = isRtlCharAt(max);
                if (z5 && !isRtlCharAt) {
                    secondaryDownstream = horizontalPositionCache.getPrimaryDownstream(max);
                    secondaryUpstream = horizontalPositionCache.getPrimaryUpstream(max + 1);
                } else if (z5 && isRtlCharAt) {
                    secondaryUpstream = horizontalPositionCache.getSecondaryDownstream(max);
                    secondaryDownstream = horizontalPositionCache.getSecondaryUpstream(max + 1);
                } else if (z5 || !isRtlCharAt) {
                    secondaryDownstream = horizontalPositionCache.getSecondaryDownstream(max);
                    secondaryUpstream = horizontalPositionCache.getSecondaryUpstream(max + 1);
                } else {
                    secondaryUpstream = horizontalPositionCache.getPrimaryDownstream(max);
                    secondaryDownstream = horizontalPositionCache.getPrimaryUpstream(max + 1);
                }
                array[arrayStart] = secondaryDownstream;
                array[arrayStart + 1] = lineTop;
                array[arrayStart + 2] = secondaryUpstream;
                array[arrayStart + 3] = lineBottom;
                arrayStart += 4;
            }
            if (lineForOffset == lineForOffset2) {
                return;
            } else {
                lineForOffset++;
            }
        }
    }

    public final void fillLineHorizontalBounds$ui_text_release(int lineIndex, float[] array) {
        float secondaryDownstream;
        float secondaryUpstream;
        int lineStart = getLineStart(lineIndex);
        int lineEnd = getLineEnd(lineIndex);
        if (array.length < (lineEnd - lineStart) * 2) {
            throw new IllegalArgumentException("array.size - arrayStart must be greater or equal than (endOffset - startOffset) * 2");
        }
        HorizontalPositionCache horizontalPositionCache = new HorizontalPositionCache(this);
        int i5 = 0;
        boolean z5 = getParagraphDirection(lineIndex) == 1;
        while (lineStart < lineEnd) {
            boolean isRtlCharAt = isRtlCharAt(lineStart);
            if (z5 && !isRtlCharAt) {
                secondaryDownstream = horizontalPositionCache.getPrimaryDownstream(lineStart);
                secondaryUpstream = horizontalPositionCache.getPrimaryUpstream(lineStart + 1);
            } else if (z5 && isRtlCharAt) {
                secondaryUpstream = horizontalPositionCache.getSecondaryDownstream(lineStart);
                secondaryDownstream = horizontalPositionCache.getSecondaryUpstream(lineStart + 1);
            } else if (isRtlCharAt) {
                secondaryUpstream = horizontalPositionCache.getPrimaryDownstream(lineStart);
                secondaryDownstream = horizontalPositionCache.getPrimaryUpstream(lineStart + 1);
            } else {
                secondaryDownstream = horizontalPositionCache.getSecondaryDownstream(lineStart);
                secondaryUpstream = horizontalPositionCache.getSecondaryUpstream(lineStart + 1);
            }
            array[i5] = secondaryDownstream;
            array[i5 + 1] = secondaryUpstream;
            i5 += 2;
            lineStart++;
        }
    }

    public final RectF getBoundingBox(int offset) {
        float secondaryHorizontal;
        float secondaryHorizontal2;
        float primaryHorizontal;
        float primaryHorizontal2;
        int lineForOffset = getLineForOffset(offset);
        float lineTop = getLineTop(lineForOffset);
        float lineBottom = getLineBottom(lineForOffset);
        boolean z5 = getParagraphDirection(lineForOffset) == 1;
        boolean isRtlCharAt = this.layout.isRtlCharAt(offset);
        if (!z5 || isRtlCharAt) {
            if (z5 && isRtlCharAt) {
                primaryHorizontal = getSecondaryHorizontal(offset, false);
                primaryHorizontal2 = getSecondaryHorizontal(offset + 1, true);
            } else if (isRtlCharAt) {
                primaryHorizontal = getPrimaryHorizontal(offset, false);
                primaryHorizontal2 = getPrimaryHorizontal(offset + 1, true);
            } else {
                secondaryHorizontal = getSecondaryHorizontal(offset, false);
                secondaryHorizontal2 = getSecondaryHorizontal(offset + 1, true);
            }
            float f5 = primaryHorizontal;
            secondaryHorizontal = primaryHorizontal2;
            secondaryHorizontal2 = f5;
        } else {
            secondaryHorizontal = getPrimaryHorizontal(offset, false);
            secondaryHorizontal2 = getPrimaryHorizontal(offset + 1, true);
        }
        return new RectF(secondaryHorizontal, lineTop, secondaryHorizontal2, lineBottom);
    }

    public final boolean getDidExceedMaxLines() {
        return this.didExceedMaxLines;
    }

    public final boolean getFallbackLineSpacing() {
        return this.fallbackLineSpacing;
    }

    public final int getHeight() {
        return (this.didExceedMaxLines ? this.layout.getLineBottom(this.lineCount - 1) : this.layout.getHeight()) + this.topPadding + this.bottomPadding + this.lastLineExtra;
    }

    public final boolean getIncludePadding() {
        return this.includePadding;
    }

    public final Layout getLayout() {
        return this.layout;
    }

    public final float getLineBaseline(int line) {
        return this.topPadding + ((line != this.lineCount + (-1) || this.lastLineFontMetrics == null) ? this.layout.getLineBaseline(line) : getLineTop(line) - this.lastLineFontMetrics.ascent);
    }

    public final float getLineBottom(int line) {
        if (line != this.lineCount - 1 || this.lastLineFontMetrics == null) {
            return this.topPadding + this.layout.getLineBottom(line) + (line == this.lineCount + (-1) ? this.bottomPadding : 0);
        }
        return this.layout.getLineBottom(line - 1) + this.lastLineFontMetrics.bottom;
    }

    public final int getLineCount() {
        return this.lineCount;
    }

    public final int getLineEllipsisCount(int lineIndex) {
        return this.layout.getEllipsisCount(lineIndex);
    }

    public final int getLineEllipsisOffset(int lineIndex) {
        return this.layout.getEllipsisStart(lineIndex);
    }

    public final int getLineEnd(int lineIndex) {
        return this.layout.getEllipsisStart(lineIndex) == 0 ? this.layout.getLineEnd(lineIndex) : this.layout.getText().length();
    }

    public final int getLineForOffset(int offset) {
        return this.layout.getLineForOffset(offset);
    }

    public final int getLineForVertical(int vertical) {
        return this.layout.getLineForVertical(vertical - this.topPadding);
    }

    public final float getLineHeight(int lineIndex) {
        return getLineBottom(lineIndex) - getLineTop(lineIndex);
    }

    public final float getLineLeft(int lineIndex) {
        return this.layout.getLineLeft(lineIndex) + (lineIndex == this.lineCount + (-1) ? this.leftPadding : 0.0f);
    }

    public final float getLineRight(int lineIndex) {
        return this.layout.getLineRight(lineIndex) + (lineIndex == this.lineCount + (-1) ? this.rightPadding : 0.0f);
    }

    public final int getLineStart(int lineIndex) {
        return this.layout.getLineStart(lineIndex);
    }

    public final float getLineTop(int line) {
        return this.layout.getLineTop(line) + (line == 0 ? 0 : this.topPadding);
    }

    public final int getLineVisibleEnd(int lineIndex) {
        if (this.layout.getEllipsisStart(lineIndex) == 0) {
            return getLayoutHelper().getLineVisibleEnd(lineIndex);
        }
        return this.layout.getEllipsisStart(lineIndex) + this.layout.getLineStart(lineIndex);
    }

    public final int getOffsetForHorizontal(int line, float horizontal) {
        return this.layout.getOffsetForHorizontal(line, horizontal + ((-1) * getHorizontalPadding(line)));
    }

    public final int getParagraphDirection(int line) {
        return this.layout.getParagraphDirection(line);
    }

    public final float getPrimaryHorizontal(int offset, boolean upstream) {
        return getLayoutHelper().getHorizontalPosition(offset, true, upstream) + getHorizontalPadding(getLineForOffset(offset));
    }

    public final int[] getRangeForRect(RectF rect, int granularity, Function2<? super RectF, ? super RectF, Boolean> inclusionStrategy) {
        return Build.VERSION.SDK_INT >= 34 ? AndroidLayoutApi34.INSTANCE.getRangeForRect$ui_text_release(this, rect, granularity, inclusionStrategy) : TextLayoutGetRangeForRectExtensions_androidKt.getRangeForRect(this, this.layout, getLayoutHelper(), rect, granularity, inclusionStrategy);
    }

    public final float getSecondaryHorizontal(int offset, boolean upstream) {
        return getLayoutHelper().getHorizontalPosition(offset, false, upstream) + getHorizontalPadding(getLineForOffset(offset));
    }

    public final void getSelectionPath(int start, int end, Path dest) {
        this.layout.getSelectionPath(start, end, dest);
        if (this.topPadding == 0 || dest.isEmpty()) {
            return;
        }
        dest.offset(0.0f, this.topPadding);
    }

    public final CharSequence getText() {
        return this.layout.getText();
    }

    public final TextPaint getTextPaint() {
        return this.textPaint;
    }

    public final WordIterator getWordIterator() {
        WordIterator wordIterator = this.backingWordIterator;
        if (wordIterator != null) {
            return wordIterator;
        }
        WordIterator wordIterator2 = new WordIterator(this.layout.getText(), 0, this.layout.getText().length(), this.textPaint.getTextLocale());
        this.backingWordIterator = wordIterator2;
        return wordIterator2;
    }

    public final boolean isFallbackLinespacingApplied$ui_text_release() {
        if (this.isBoringLayout) {
            BoringLayoutFactory boringLayoutFactory = BoringLayoutFactory.INSTANCE;
            Layout layout = this.layout;
            Intrinsics.checkNotNull(layout, "null cannot be cast to non-null type android.text.BoringLayout");
            return boringLayoutFactory.isFallbackLineSpacingEnabled((BoringLayout) layout);
        }
        StaticLayoutFactory staticLayoutFactory = StaticLayoutFactory.INSTANCE;
        Layout layout2 = this.layout;
        Intrinsics.checkNotNull(layout2, "null cannot be cast to non-null type android.text.StaticLayout");
        return staticLayoutFactory.isFallbackLineSpacingEnabled((StaticLayout) layout2, this.fallbackLineSpacing);
    }

    public final boolean isRtlCharAt(int offset) {
        return this.layout.isRtlCharAt(offset);
    }

    public final void paint(Canvas canvas) {
        TextAndroidCanvas textAndroidCanvas;
        if (canvas.getClipBounds(this.rect)) {
            int i5 = this.topPadding;
            if (i5 != 0) {
                canvas.translate(0.0f, i5);
            }
            textAndroidCanvas = TextLayout_androidKt.SharedTextAndroidCanvas;
            textAndroidCanvas.setCanvas(canvas);
            this.layout.draw(textAndroidCanvas);
            int i6 = this.topPadding;
            if (i6 != 0) {
                canvas.translate(0.0f, (-1) * i6);
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ TextLayout(CharSequence charSequence, float f5, TextPaint textPaint, int i5, TextUtils.TruncateAt truncateAt, int i6, float f6, float f7, boolean z5, boolean z6, int i7, int i8, int i9, int i10, int i11, int i12, int[] iArr, int[] iArr2, LayoutIntrinsics layoutIntrinsics, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this(charSequence, f5, textPaint, r7, r8, r9, (i13 & 64) != 0 ? 1.0f : f6, (i13 & 128) != 0 ? 0.0f : f7, (i13 & 256) != 0 ? false : z5, (i13 & 512) != 0 ? true : z6, (i13 & 1024) != 0 ? Integer.MAX_VALUE : i7, (i13 & 2048) != 0 ? 0 : i8, (i13 & 4096) != 0 ? 0 : i9, (i13 & 8192) != 0 ? 0 : i10, (i13 & 16384) != 0 ? 0 : i11, (32768 & i13) != 0 ? 0 : i12, (65536 & i13) != 0 ? null : iArr, (131072 & i13) != 0 ? null : iArr2, (i13 & 262144) != 0 ? new LayoutIntrinsics(charSequence, textPaint, r9) : layoutIntrinsics);
        int i14 = (i13 & 8) != 0 ? 0 : i5;
        TextUtils.TruncateAt truncateAt2 = (i13 & 16) != 0 ? null : truncateAt;
        int i15 = (i13 & 32) != 0 ? 2 : i6;
    }
}
