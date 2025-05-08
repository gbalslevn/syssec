package androidx.compose.ui.text;

import android.graphics.Paint;
import android.graphics.RectF;
import android.text.Spanned;
import android.text.TextUtils;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.RectHelper_androidKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.android.TextLayout;
import androidx.compose.ui.text.android.selection.WordBoundary_androidKt;
import androidx.compose.ui.text.android.selection.WordIterator;
import androidx.compose.ui.text.android.style.PlaceholderSpan;
import androidx.compose.ui.text.platform.AndroidParagraphHelper_androidKt;
import androidx.compose.ui.text.platform.AndroidParagraphIntrinsics;
import androidx.compose.ui.text.platform.AndroidTextPaint;
import androidx.compose.ui.text.platform.style.ShaderBrushSpan;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Constraints;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000Ö\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0014\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r*\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0014\u001a\u00020\u0006*\u00020\u00112\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJQ\u0010#\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u0004H\u0002¢\u0006\u0004\b#\u0010$J\u0017\u0010'\u001a\u00020\u00042\u0006\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b'\u0010(J\u001a\u0010-\u001a\u00020\u00042\u0006\u0010*\u001a\u00020)H\u0016ø\u0001\u0000¢\u0006\u0004\b+\u0010,J*\u00107\u001a\u0002042\u0006\u0010/\u001a\u00020.2\u0006\u00101\u001a\u0002002\u0006\u00103\u001a\u000202H\u0016ø\u0001\u0000¢\u0006\u0004\b5\u00106J\u0017\u00109\u001a\u00020.2\u0006\u00108\u001a\u00020\u0004H\u0016¢\u0006\u0004\b9\u0010:J,\u0010A\u001a\u00020\u00182\u0006\u0010;\u001a\u0002042\u0006\u0010=\u001a\u00020<2\b\b\u0001\u0010>\u001a\u00020\u0004H\u0016ø\u0001\u0000¢\u0006\u0004\b?\u0010@J\u001f\u0010E\u001a\u00020D2\u0006\u0010B\u001a\u00020\u00042\u0006\u0010C\u001a\u00020\u0004H\u0016¢\u0006\u0004\bE\u0010FJ\u0017\u0010G\u001a\u00020.2\u0006\u00108\u001a\u00020\u0004H\u0016¢\u0006\u0004\bG\u0010:J\u001d\u0010J\u001a\u0002042\u0006\u00108\u001a\u00020\u0004H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bH\u0010IJ\u0017\u0010L\u001a\u00020%2\u0006\u0010K\u001a\u00020\u0004H\u0016¢\u0006\u0004\bL\u0010MJ\u0017\u0010N\u001a\u00020%2\u0006\u0010K\u001a\u00020\u0004H\u0016¢\u0006\u0004\bN\u0010MJ\u0017\u0010O\u001a\u00020%2\u0006\u0010K\u001a\u00020\u0004H\u0016¢\u0006\u0004\bO\u0010MJ\u0017\u0010P\u001a\u00020%2\u0006\u0010K\u001a\u00020\u0004H\u0016¢\u0006\u0004\bP\u0010MJ\u0017\u0010Q\u001a\u00020%2\u0006\u0010K\u001a\u00020\u0004H\u0016¢\u0006\u0004\bQ\u0010MJ\u0017\u0010R\u001a\u00020\u00042\u0006\u0010K\u001a\u00020\u0004H\u0016¢\u0006\u0004\bR\u0010SJ\u001f\u0010U\u001a\u00020\u00042\u0006\u0010K\u001a\u00020\u00042\u0006\u0010T\u001a\u00020\u0006H\u0016¢\u0006\u0004\bU\u0010VJ\u0017\u0010W\u001a\u00020\u00042\u0006\u00108\u001a\u00020\u0004H\u0016¢\u0006\u0004\bW\u0010SJ\u001f\u0010Y\u001a\u00020%2\u0006\u00108\u001a\u00020\u00042\u0006\u0010X\u001a\u00020\u0006H\u0016¢\u0006\u0004\bY\u0010ZJ\u0017\u0010\\\u001a\u00020[2\u0006\u00108\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\\\u0010]J\u0017\u0010^\u001a\u00020[2\u0006\u00108\u001a\u00020\u0004H\u0016¢\u0006\u0004\b^\u0010]JH\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010`\u001a\u00020_2\b\u0010b\u001a\u0004\u0018\u00010a2\b\u0010d\u001a\u0004\u0018\u00010c2\b\u0010f\u001a\u0004\u0018\u00010e2\u0006\u0010h\u001a\u00020gH\u0016ø\u0001\u0000¢\u0006\u0004\bi\u0010jJP\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010l\u001a\u00020k2\u0006\u0010m\u001a\u00020%2\b\u0010b\u001a\u0004\u0018\u00010a2\b\u0010d\u001a\u0004\u0018\u00010c2\b\u0010f\u001a\u0004\u0018\u00010e2\u0006\u0010h\u001a\u00020gH\u0016ø\u0001\u0000¢\u0006\u0004\bn\u0010oR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010p\u001a\u0004\bq\u0010rR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010s\u001a\u0004\bt\u0010uR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010v\u001a\u0004\bw\u0010xR\u001d\u0010\t\u001a\u00020\b8\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\t\u0010y\u001a\u0004\bz\u0010{R\u0014\u0010|\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b|\u0010}R%\u0010\u007f\u001a\u00020~8\u0000X\u0081\u0004¢\u0006\u0017\n\u0005\b\u007f\u0010\u0080\u0001\u0012\u0006\b\u0083\u0001\u0010\u0084\u0001\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001R(\u0010\u0086\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010.0\u0085\u00018\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\b\u0086\u0001\u0010\u0087\u0001\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001R\u0017\u0010\u008c\u0001\u001a\u00020%8VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001R\u0017\u0010\u008e\u0001\u001a\u00020%8VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u008d\u0001\u0010\u008b\u0001R\u0017\u0010\u0090\u0001\u001a\u00020%8VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u008f\u0001\u0010\u008b\u0001R\u0017\u0010\u0092\u0001\u001a\u00020%8VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0091\u0001\u0010\u008b\u0001R\u0017\u0010\u0094\u0001\u001a\u00020%8VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0093\u0001\u0010\u008b\u0001R\u0017\u0010\u0096\u0001\u001a\u00020%8VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0095\u0001\u0010\u008b\u0001R\u0016\u0010\u0098\u0001\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0097\u0001\u0010xR\u0016\u0010\u009a\u0001\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0099\u0001\u0010uR \u0010\u009f\u0001\u001a\u00030\u009b\u00018@X\u0081\u0004¢\u0006\u0010\u0012\u0006\b\u009e\u0001\u0010\u0084\u0001\u001a\u0006\b\u009c\u0001\u0010\u009d\u0001\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006 \u0001"}, d2 = {"Landroidx/compose/ui/text/AndroidParagraph;", "Landroidx/compose/ui/text/Paragraph;", "Landroidx/compose/ui/text/platform/AndroidParagraphIntrinsics;", "paragraphIntrinsics", BuildConfig.FLAVOR, "maxLines", BuildConfig.FLAVOR, "ellipsis", "Landroidx/compose/ui/unit/Constraints;", "constraints", "<init>", "(Landroidx/compose/ui/text/platform/AndroidParagraphIntrinsics;IZJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "Landroidx/compose/ui/text/android/TextLayout;", BuildConfig.FLAVOR, "Landroidx/compose/ui/text/platform/style/ShaderBrushSpan;", "getShaderBrushSpans", "(Landroidx/compose/ui/text/android/TextLayout;)[Landroidx/compose/ui/text/platform/style/ShaderBrushSpan;", "Landroid/text/Spanned;", "Ljava/lang/Class;", "clazz", "hasSpan", "(Landroid/text/Spanned;Ljava/lang/Class;)Z", "Landroidx/compose/ui/graphics/Canvas;", "canvas", BuildConfig.FLAVOR, "paint", "(Landroidx/compose/ui/graphics/Canvas;)V", "alignment", "justificationMode", "Landroid/text/TextUtils$TruncateAt;", "ellipsize", "hyphens", "breakStrategy", "lineBreakStyle", "lineBreakWordStyle", "constructTextLayout", "(IILandroid/text/TextUtils$TruncateAt;IIIII)Landroidx/compose/ui/text/android/TextLayout;", BuildConfig.FLAVOR, "vertical", "getLineForVerticalPosition", "(F)I", "Landroidx/compose/ui/geometry/Offset;", "position", "getOffsetForPosition-k-4lQ0M", "(J)I", "getOffsetForPosition", "Landroidx/compose/ui/geometry/Rect;", "rect", "Landroidx/compose/ui/text/TextGranularity;", "granularity", "Landroidx/compose/ui/text/TextInclusionStrategy;", "inclusionStrategy", "Landroidx/compose/ui/text/TextRange;", "getRangeForRect-8-6BmAI", "(Landroidx/compose/ui/geometry/Rect;ILandroidx/compose/ui/text/TextInclusionStrategy;)J", "getRangeForRect", "offset", "getBoundingBox", "(I)Landroidx/compose/ui/geometry/Rect;", "range", BuildConfig.FLAVOR, "array", "arrayStart", "fillBoundingBoxes-8ffj60Q", "(J[FI)V", "fillBoundingBoxes", "start", "end", "Landroidx/compose/ui/graphics/Path;", "getPathForRange", "(II)Landroidx/compose/ui/graphics/Path;", "getCursorRect", "getWordBoundary--jx7JFs", "(I)J", "getWordBoundary", "lineIndex", "getLineLeft", "(I)F", "getLineRight", "getLineTop", "getLineBaseline", "getLineBottom", "getLineStart", "(I)I", "visibleEnd", "getLineEnd", "(IZ)I", "getLineForOffset", "usePrimaryDirection", "getHorizontalPosition", "(IZ)F", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "getParagraphDirection", "(I)Landroidx/compose/ui/text/style/ResolvedTextDirection;", "getBidiRunDirection", "Landroidx/compose/ui/graphics/Color;", "color", "Landroidx/compose/ui/graphics/Shadow;", "shadow", "Landroidx/compose/ui/text/style/TextDecoration;", "textDecoration", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "drawStyle", "Landroidx/compose/ui/graphics/BlendMode;", "blendMode", "paint-LG529CI", "(Landroidx/compose/ui/graphics/Canvas;JLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/drawscope/DrawStyle;I)V", "Landroidx/compose/ui/graphics/Brush;", "brush", "alpha", "paint-hn5TExg", "(Landroidx/compose/ui/graphics/Canvas;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/drawscope/DrawStyle;I)V", "Landroidx/compose/ui/text/platform/AndroidParagraphIntrinsics;", "getParagraphIntrinsics", "()Landroidx/compose/ui/text/platform/AndroidParagraphIntrinsics;", "I", "getMaxLines", "()I", "Z", "getEllipsis", "()Z", "J", "getConstraints-msEJaDk", "()J", "layout", "Landroidx/compose/ui/text/android/TextLayout;", BuildConfig.FLAVOR, "charSequence", "Ljava/lang/CharSequence;", "getCharSequence$ui_text_release", "()Ljava/lang/CharSequence;", "getCharSequence$ui_text_release$annotations", "()V", BuildConfig.FLAVOR, "placeholderRects", "Ljava/util/List;", "getPlaceholderRects", "()Ljava/util/List;", "getWidth", "()F", "width", "getHeight", "height", "getMaxIntrinsicWidth", "maxIntrinsicWidth", "getMinIntrinsicWidth", "minIntrinsicWidth", "getFirstBaseline", "firstBaseline", "getLastBaseline", "lastBaseline", "getDidExceedMaxLines", "didExceedMaxLines", "getLineCount", "lineCount", "Landroidx/compose/ui/text/platform/AndroidTextPaint;", "getTextPaint$ui_text_release", "()Landroidx/compose/ui/text/platform/AndroidTextPaint;", "getTextPaint$ui_text_release$annotations", "textPaint", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AndroidParagraph implements Paragraph {
    private final CharSequence charSequence;
    private final long constraints;
    private final boolean ellipsis;
    private final TextLayout layout;
    private final int maxLines;
    private final AndroidParagraphIntrinsics paragraphIntrinsics;
    private final List<Rect> placeholderRects;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ResolvedTextDirection.values().length];
            try {
                iArr[ResolvedTextDirection.Ltr.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ResolvedTextDirection.Rtl.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ AndroidParagraph(AndroidParagraphIntrinsics androidParagraphIntrinsics, int i5, boolean z5, long j5, DefaultConstructorMarker defaultConstructorMarker) {
        this(androidParagraphIntrinsics, i5, z5, j5);
    }

    private final TextLayout constructTextLayout(int alignment, int justificationMode, TextUtils.TruncateAt ellipsize, int maxLines, int hyphens, int breakStrategy, int lineBreakStyle, int lineBreakWordStyle) {
        return new TextLayout(this.charSequence, getWidth(), getTextPaint$ui_text_release(), alignment, ellipsize, this.paragraphIntrinsics.getTextDirectionHeuristic(), 1.0f, 0.0f, AndroidParagraphHelper_androidKt.isIncludeFontPaddingEnabled(this.paragraphIntrinsics.getStyle()), true, maxLines, breakStrategy, lineBreakStyle, lineBreakWordStyle, hyphens, justificationMode, null, null, this.paragraphIntrinsics.getLayoutIntrinsics(), 196736, null);
    }

    private final ShaderBrushSpan[] getShaderBrushSpans(TextLayout textLayout) {
        if (!(textLayout.getText() instanceof Spanned)) {
            return null;
        }
        CharSequence text = textLayout.getText();
        Intrinsics.checkNotNull(text, "null cannot be cast to non-null type android.text.Spanned");
        if (!hasSpan((Spanned) text, ShaderBrushSpan.class)) {
            return null;
        }
        CharSequence text2 = textLayout.getText();
        Intrinsics.checkNotNull(text2, "null cannot be cast to non-null type android.text.Spanned");
        return (ShaderBrushSpan[]) ((Spanned) text2).getSpans(0, textLayout.getText().length(), ShaderBrushSpan.class);
    }

    private final boolean hasSpan(Spanned spanned, Class<?> cls) {
        return spanned.nextSpanTransition(-1, spanned.length(), cls) != spanned.length();
    }

    private final void paint(Canvas canvas) {
        android.graphics.Canvas nativeCanvas = AndroidCanvas_androidKt.getNativeCanvas(canvas);
        if (getDidExceedMaxLines()) {
            nativeCanvas.save();
            nativeCanvas.clipRect(0.0f, 0.0f, getWidth(), getHeight());
        }
        this.layout.paint(nativeCanvas);
        if (getDidExceedMaxLines()) {
            nativeCanvas.restore();
        }
    }

    @Override // androidx.compose.ui.text.Paragraph
    /* renamed from: fillBoundingBoxes-8ffj60Q, reason: not valid java name */
    public void mo2186fillBoundingBoxes8ffj60Q(long range, float[] array, int arrayStart) {
        this.layout.fillBoundingBoxes(TextRange.m2283getMinimpl(range), TextRange.m2282getMaximpl(range), array, arrayStart);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public ResolvedTextDirection getBidiRunDirection(int offset) {
        return this.layout.isRtlCharAt(offset) ? ResolvedTextDirection.Rtl : ResolvedTextDirection.Ltr;
    }

    @Override // androidx.compose.ui.text.Paragraph
    public Rect getBoundingBox(int offset) {
        if (offset >= 0 && offset < this.charSequence.length()) {
            RectF boundingBox = this.layout.getBoundingBox(offset);
            return new Rect(boundingBox.left, boundingBox.top, boundingBox.right, boundingBox.bottom);
        }
        throw new IllegalArgumentException(("offset(" + offset + ") is out of bounds [0," + this.charSequence.length() + ')').toString());
    }

    @Override // androidx.compose.ui.text.Paragraph
    public Rect getCursorRect(int offset) {
        if (offset >= 0 && offset <= this.charSequence.length()) {
            float primaryHorizontal$default = TextLayout.getPrimaryHorizontal$default(this.layout, offset, false, 2, null);
            int lineForOffset = this.layout.getLineForOffset(offset);
            return new Rect(primaryHorizontal$default, this.layout.getLineTop(lineForOffset), primaryHorizontal$default, this.layout.getLineBottom(lineForOffset));
        }
        throw new IllegalArgumentException(("offset(" + offset + ") is out of bounds [0," + this.charSequence.length() + ']').toString());
    }

    @Override // androidx.compose.ui.text.Paragraph
    public boolean getDidExceedMaxLines() {
        return this.layout.getDidExceedMaxLines();
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getFirstBaseline() {
        return getLineBaseline(0);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getHeight() {
        return this.layout.getHeight();
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getHorizontalPosition(int offset, boolean usePrimaryDirection) {
        return usePrimaryDirection ? TextLayout.getPrimaryHorizontal$default(this.layout, offset, false, 2, null) : TextLayout.getSecondaryHorizontal$default(this.layout, offset, false, 2, null);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getLastBaseline() {
        return getLineBaseline(getLineCount() - 1);
    }

    public float getLineBaseline(int lineIndex) {
        return this.layout.getLineBaseline(lineIndex);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getLineBottom(int lineIndex) {
        return this.layout.getLineBottom(lineIndex);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public int getLineCount() {
        return this.layout.getLineCount();
    }

    @Override // androidx.compose.ui.text.Paragraph
    public int getLineEnd(int lineIndex, boolean visibleEnd) {
        return visibleEnd ? this.layout.getLineVisibleEnd(lineIndex) : this.layout.getLineEnd(lineIndex);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public int getLineForOffset(int offset) {
        return this.layout.getLineForOffset(offset);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public int getLineForVerticalPosition(float vertical) {
        return this.layout.getLineForVertical((int) vertical);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getLineLeft(int lineIndex) {
        return this.layout.getLineLeft(lineIndex);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getLineRight(int lineIndex) {
        return this.layout.getLineRight(lineIndex);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public int getLineStart(int lineIndex) {
        return this.layout.getLineStart(lineIndex);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getLineTop(int lineIndex) {
        return this.layout.getLineTop(lineIndex);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getMaxIntrinsicWidth() {
        return this.paragraphIntrinsics.getMaxIntrinsicWidth();
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getMinIntrinsicWidth() {
        return this.paragraphIntrinsics.getMinIntrinsicWidth();
    }

    @Override // androidx.compose.ui.text.Paragraph
    /* renamed from: getOffsetForPosition-k-4lQ0M, reason: not valid java name */
    public int mo2187getOffsetForPositionk4lQ0M(long position) {
        return this.layout.getOffsetForHorizontal(this.layout.getLineForVertical((int) Offset.m1338getYimpl(position)), Offset.m1337getXimpl(position));
    }

    @Override // androidx.compose.ui.text.Paragraph
    public ResolvedTextDirection getParagraphDirection(int offset) {
        return this.layout.getParagraphDirection(this.layout.getLineForOffset(offset)) == 1 ? ResolvedTextDirection.Ltr : ResolvedTextDirection.Rtl;
    }

    @Override // androidx.compose.ui.text.Paragraph
    public Path getPathForRange(int start, int end) {
        if (start >= 0 && start <= end && end <= this.charSequence.length()) {
            android.graphics.Path path = new android.graphics.Path();
            this.layout.getSelectionPath(start, end, path);
            return AndroidPath_androidKt.asComposePath(path);
        }
        throw new IllegalArgumentException(("start(" + start + ") or end(" + end + ") is out of range [0.." + this.charSequence.length() + "], or start > end!").toString());
    }

    @Override // androidx.compose.ui.text.Paragraph
    public List<Rect> getPlaceholderRects() {
        return this.placeholderRects;
    }

    @Override // androidx.compose.ui.text.Paragraph
    /* renamed from: getRangeForRect-8-6BmAI, reason: not valid java name */
    public long mo2188getRangeForRect86BmAI(Rect rect, int granularity, final TextInclusionStrategy inclusionStrategy) {
        int[] rangeForRect = this.layout.getRangeForRect(RectHelper_androidKt.toAndroidRectF(rect), AndroidParagraph_androidKt.m2197access$toLayoutTextGranularityduNsdkg(granularity), new Function2<RectF, RectF, Boolean>() { // from class: androidx.compose.ui.text.AndroidParagraph$getRangeForRect$range$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Boolean invoke(RectF rectF, RectF rectF2) {
                return Boolean.valueOf(TextInclusionStrategy.this.isIncluded(RectHelper_androidKt.toComposeRect(rectF), RectHelper_androidKt.toComposeRect(rectF2)));
            }
        });
        return rangeForRect == null ? TextRange.INSTANCE.m2290getZerod9O1mEE() : TextRangeKt.TextRange(rangeForRect[0], rangeForRect[1]);
    }

    public final AndroidTextPaint getTextPaint$ui_text_release() {
        return this.paragraphIntrinsics.getTextPaint();
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getWidth() {
        return Constraints.m2578getMaxWidthimpl(this.constraints);
    }

    @Override // androidx.compose.ui.text.Paragraph
    /* renamed from: getWordBoundary--jx7JFs, reason: not valid java name */
    public long mo2189getWordBoundaryjx7JFs(int offset) {
        WordIterator wordIterator = this.layout.getWordIterator();
        return TextRangeKt.TextRange(WordBoundary_androidKt.getWordStart(wordIterator, offset), WordBoundary_androidKt.getWordEnd(wordIterator, offset));
    }

    @Override // androidx.compose.ui.text.Paragraph
    /* renamed from: paint-LG529CI, reason: not valid java name */
    public void mo2190paintLG529CI(Canvas canvas, long color, Shadow shadow, TextDecoration textDecoration, DrawStyle drawStyle, int blendMode) {
        int backingBlendMode = getTextPaint$ui_text_release().getBackingBlendMode();
        AndroidTextPaint textPaint$ui_text_release = getTextPaint$ui_text_release();
        textPaint$ui_text_release.m2441setColor8_81llA(color);
        textPaint$ui_text_release.setShadow(shadow);
        textPaint$ui_text_release.setTextDecoration(textDecoration);
        textPaint$ui_text_release.setDrawStyle(drawStyle);
        textPaint$ui_text_release.m2439setBlendModes9anfk8(blendMode);
        paint(canvas);
        getTextPaint$ui_text_release().m2439setBlendModes9anfk8(backingBlendMode);
    }

    @Override // androidx.compose.ui.text.Paragraph
    /* renamed from: paint-hn5TExg, reason: not valid java name */
    public void mo2191painthn5TExg(Canvas canvas, Brush brush, float alpha, Shadow shadow, TextDecoration textDecoration, DrawStyle drawStyle, int blendMode) {
        int backingBlendMode = getTextPaint$ui_text_release().getBackingBlendMode();
        AndroidTextPaint textPaint$ui_text_release = getTextPaint$ui_text_release();
        textPaint$ui_text_release.m2440setBrush12SF9DM(brush, SizeKt.Size(getWidth(), getHeight()), alpha);
        textPaint$ui_text_release.setShadow(shadow);
        textPaint$ui_text_release.setTextDecoration(textDecoration);
        textPaint$ui_text_release.setDrawStyle(drawStyle);
        textPaint$ui_text_release.m2439setBlendModes9anfk8(blendMode);
        paint(canvas);
        getTextPaint$ui_text_release().m2439setBlendModes9anfk8(backingBlendMode);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:57:0x01b3. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    private AndroidParagraph(AndroidParagraphIntrinsics androidParagraphIntrinsics, int i5, boolean z5, long j5) {
        CharSequence charSequence;
        List<Rect> list;
        Rect rect;
        float horizontalPosition;
        float lineBaseline;
        int heightPx;
        float lineTop;
        float f5;
        float lineBaseline2;
        this.paragraphIntrinsics = androidParagraphIntrinsics;
        this.maxLines = i5;
        this.ellipsis = z5;
        this.constraints = j5;
        if (Constraints.m2579getMinHeightimpl(j5) != 0 || Constraints.m2580getMinWidthimpl(j5) != 0) {
            throw new IllegalArgumentException("Setting Constraints.minWidth and Constraints.minHeight is not supported, these should be the default zero values instead.");
        }
        if (i5 >= 1) {
            TextStyle style = androidParagraphIntrinsics.getStyle();
            if (AndroidParagraph_androidKt.access$shouldAttachIndentationFixSpan(style, z5)) {
                charSequence = AndroidParagraph_androidKt.access$attachIndentationFixSpan(androidParagraphIntrinsics.getCharSequence());
            } else {
                charSequence = androidParagraphIntrinsics.getCharSequence();
            }
            this.charSequence = charSequence;
            int m2192access$toLayoutAlignaXe7zB0 = AndroidParagraph_androidKt.m2192access$toLayoutAlignaXe7zB0(style.m2306getTextAligne0LSkKk());
            boolean m2524equalsimpl0 = TextAlign.m2524equalsimpl0(style.m2306getTextAligne0LSkKk(), TextAlign.INSTANCE.m2530getJustifye0LSkKk());
            int m2194access$toLayoutHyphenationFrequency3fSNIE = AndroidParagraph_androidKt.m2194access$toLayoutHyphenationFrequency3fSNIE(style.getParagraphStyle().getHyphens());
            int m2193access$toLayoutBreakStrategyxImikfE = AndroidParagraph_androidKt.m2193access$toLayoutBreakStrategyxImikfE(LineBreak.m2479getStrategyfcGXIks(style.m2304getLineBreakrAG3T2k()));
            int m2195access$toLayoutLineBreakStylehpcqdu8 = AndroidParagraph_androidKt.m2195access$toLayoutLineBreakStylehpcqdu8(LineBreak.m2480getStrictnessusljTpc(style.m2304getLineBreakrAG3T2k()));
            int m2196access$toLayoutLineBreakWordStylewPN0Rpw = AndroidParagraph_androidKt.m2196access$toLayoutLineBreakWordStylewPN0Rpw(LineBreak.m2481getWordBreakjp8hJ3c(style.m2304getLineBreakrAG3T2k()));
            TextUtils.TruncateAt truncateAt = z5 ? TextUtils.TruncateAt.END : null;
            TextLayout constructTextLayout = constructTextLayout(m2192access$toLayoutAlignaXe7zB0, m2524equalsimpl0 ? 1 : 0, truncateAt, i5, m2194access$toLayoutHyphenationFrequency3fSNIE, m2193access$toLayoutBreakStrategyxImikfE, m2195access$toLayoutLineBreakStylehpcqdu8, m2196access$toLayoutLineBreakWordStylewPN0Rpw);
            if (z5 && constructTextLayout.getHeight() > Constraints.m2577getMaxHeightimpl(j5) && i5 > 1) {
                int access$numberOfLinesThatFitMaxHeight = AndroidParagraph_androidKt.access$numberOfLinesThatFitMaxHeight(constructTextLayout, Constraints.m2577getMaxHeightimpl(j5));
                if (access$numberOfLinesThatFitMaxHeight >= 0 && access$numberOfLinesThatFitMaxHeight != i5) {
                    constructTextLayout = constructTextLayout(m2192access$toLayoutAlignaXe7zB0, m2524equalsimpl0 ? 1 : 0, truncateAt, RangesKt.coerceAtLeast(access$numberOfLinesThatFitMaxHeight, 1), m2194access$toLayoutHyphenationFrequency3fSNIE, m2193access$toLayoutBreakStrategyxImikfE, m2195access$toLayoutLineBreakStylehpcqdu8, m2196access$toLayoutLineBreakWordStylewPN0Rpw);
                }
                this.layout = constructTextLayout;
            } else {
                this.layout = constructTextLayout;
            }
            getTextPaint$ui_text_release().m2440setBrush12SF9DM(style.getBrush(), SizeKt.Size(getWidth(), getHeight()), style.getAlpha());
            ShaderBrushSpan[] shaderBrushSpans = getShaderBrushSpans(this.layout);
            if (shaderBrushSpans != null) {
                Iterator it = ArrayIteratorKt.iterator(shaderBrushSpans);
                while (it.hasNext()) {
                    ((ShaderBrushSpan) it.next()).m2454setSizeuvyYCjk(SizeKt.Size(getWidth(), getHeight()));
                }
            }
            CharSequence charSequence2 = this.charSequence;
            if (charSequence2 instanceof Spanned) {
                Spanned spanned = (Spanned) charSequence2;
                Object[] spans = spanned.getSpans(0, charSequence2.length(), PlaceholderSpan.class);
                ArrayList arrayList = new ArrayList(spans.length);
                for (Object obj : spans) {
                    PlaceholderSpan placeholderSpan = (PlaceholderSpan) obj;
                    int spanStart = spanned.getSpanStart(placeholderSpan);
                    int spanEnd = spanned.getSpanEnd(placeholderSpan);
                    int lineForOffset = this.layout.getLineForOffset(spanStart);
                    Object[] objArr = lineForOffset >= this.maxLines;
                    Object[] objArr2 = this.layout.getLineEllipsisCount(lineForOffset) > 0 && spanEnd > this.layout.getLineEllipsisOffset(lineForOffset);
                    Object[] objArr3 = spanEnd > this.layout.getLineEnd(lineForOffset);
                    if (objArr2 == true || objArr3 == true || objArr == true) {
                        rect = null;
                    } else {
                        int i6 = WhenMappings.$EnumSwitchMapping$0[getBidiRunDirection(spanStart).ordinal()];
                        if (i6 != 1) {
                            if (i6 != 2) {
                                throw new NoWhenBranchMatchedException();
                            }
                            horizontalPosition = getHorizontalPosition(spanStart, true) - placeholderSpan.getWidthPx();
                        } else {
                            horizontalPosition = getHorizontalPosition(spanStart, true);
                        }
                        float widthPx = placeholderSpan.getWidthPx() + horizontalPosition;
                        TextLayout textLayout = this.layout;
                        switch (placeholderSpan.getVerticalAlign()) {
                            case 0:
                                lineBaseline = textLayout.getLineBaseline(lineForOffset);
                                heightPx = placeholderSpan.getHeightPx();
                                lineTop = lineBaseline - heightPx;
                                rect = new Rect(horizontalPosition, lineTop, widthPx, placeholderSpan.getHeightPx() + lineTop);
                                break;
                            case 1:
                                lineTop = textLayout.getLineTop(lineForOffset);
                                rect = new Rect(horizontalPosition, lineTop, widthPx, placeholderSpan.getHeightPx() + lineTop);
                                break;
                            case 2:
                                lineBaseline = textLayout.getLineBottom(lineForOffset);
                                heightPx = placeholderSpan.getHeightPx();
                                lineTop = lineBaseline - heightPx;
                                rect = new Rect(horizontalPosition, lineTop, widthPx, placeholderSpan.getHeightPx() + lineTop);
                                break;
                            case 3:
                                lineTop = ((textLayout.getLineTop(lineForOffset) + textLayout.getLineBottom(lineForOffset)) - placeholderSpan.getHeightPx()) / 2;
                                rect = new Rect(horizontalPosition, lineTop, widthPx, placeholderSpan.getHeightPx() + lineTop);
                                break;
                            case 4:
                                f5 = placeholderSpan.getFontMetrics().ascent;
                                lineBaseline2 = textLayout.getLineBaseline(lineForOffset);
                                lineTop = f5 + lineBaseline2;
                                rect = new Rect(horizontalPosition, lineTop, widthPx, placeholderSpan.getHeightPx() + lineTop);
                                break;
                            case 5:
                                lineTop = (placeholderSpan.getFontMetrics().descent + textLayout.getLineBaseline(lineForOffset)) - placeholderSpan.getHeightPx();
                                rect = new Rect(horizontalPosition, lineTop, widthPx, placeholderSpan.getHeightPx() + lineTop);
                                break;
                            case 6:
                                Paint.FontMetricsInt fontMetrics = placeholderSpan.getFontMetrics();
                                f5 = ((fontMetrics.ascent + fontMetrics.descent) - placeholderSpan.getHeightPx()) / 2;
                                lineBaseline2 = textLayout.getLineBaseline(lineForOffset);
                                lineTop = f5 + lineBaseline2;
                                rect = new Rect(horizontalPosition, lineTop, widthPx, placeholderSpan.getHeightPx() + lineTop);
                                break;
                            default:
                                throw new IllegalStateException("unexpected verticalAlignment");
                        }
                    }
                    arrayList.add(rect);
                }
                list = arrayList;
            } else {
                list = CollectionsKt.emptyList();
            }
            this.placeholderRects = list;
            return;
        }
        throw new IllegalArgumentException("maxLines should be greater than 0");
    }
}
