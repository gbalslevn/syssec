package androidx.compose.ui.text;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.text.style.TextDecoration;
import java.util.List;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0002H&¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0002H&¢\u0006\u0004\b\u0010\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0002H&¢\u0006\u0004\b\u0011\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0002H&¢\u0006\u0004\b\u0012\u0010\u000fJ\u0017\u0010\u0013\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H&¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0017\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H&¢\u0006\u0004\b\u0019\u0010\u0014J\u001f\u0010\u001b\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0015H&¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\b\u001a\u00020\u0002H&¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\u001d2\u0006\u0010\b\u001a\u00020\u0002H&¢\u0006\u0004\b \u0010\u001fJ\u0017\u0010\"\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\rH&¢\u0006\u0004\b\"\u0010#J\u001a\u0010(\u001a\u00020\u00022\u0006\u0010%\u001a\u00020$H&ø\u0001\u0000¢\u0006\u0004\b&\u0010'J*\u00101\u001a\u00020.2\u0006\u0010)\u001a\u00020\t2\u0006\u0010+\u001a\u00020*2\u0006\u0010-\u001a\u00020,H&ø\u0001\u0000¢\u0006\u0004\b/\u00100J\u0017\u00102\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0002H&¢\u0006\u0004\b2\u0010\u000bJ,\u0010:\u001a\u0002072\u0006\u00103\u001a\u00020.2\u0006\u00105\u001a\u0002042\b\b\u0001\u00106\u001a\u00020\u0002H&ø\u0001\u0000¢\u0006\u0004\b8\u00109J\u001d\u0010=\u001a\u00020.2\u0006\u0010\b\u001a\u00020\u0002H&ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b;\u0010<JR\u0010L\u001a\u0002072\u0006\u0010?\u001a\u00020>2\b\b\u0002\u0010A\u001a\u00020@2\n\b\u0002\u0010C\u001a\u0004\u0018\u00010B2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010D2\n\b\u0002\u0010G\u001a\u0004\u0018\u00010F2\b\b\u0002\u0010I\u001a\u00020HH&ø\u0001\u0000¢\u0006\u0004\bJ\u0010KJZ\u0010L\u001a\u0002072\u0006\u0010?\u001a\u00020>2\u0006\u0010N\u001a\u00020M2\b\b\u0002\u0010O\u001a\u00020\r2\n\b\u0002\u0010C\u001a\u0004\u0018\u00010B2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010D2\n\b\u0002\u0010G\u001a\u0004\u0018\u00010F2\b\b\u0002\u0010I\u001a\u00020HH&ø\u0001\u0000¢\u0006\u0004\bP\u0010QR\u0014\u0010T\u001a\u00020\r8&X¦\u0004¢\u0006\u0006\u001a\u0004\bR\u0010SR\u0014\u0010V\u001a\u00020\r8&X¦\u0004¢\u0006\u0006\u001a\u0004\bU\u0010SR\u0014\u0010X\u001a\u00020\r8&X¦\u0004¢\u0006\u0006\u001a\u0004\bW\u0010SR\u0014\u0010Z\u001a\u00020\r8&X¦\u0004¢\u0006\u0006\u001a\u0004\bY\u0010SR\u0014\u0010\\\u001a\u00020\r8&X¦\u0004¢\u0006\u0006\u001a\u0004\b[\u0010SR\u0014\u0010^\u001a\u00020\r8&X¦\u0004¢\u0006\u0006\u001a\u0004\b]\u0010SR\u0014\u0010a\u001a\u00020\u00158&X¦\u0004¢\u0006\u0006\u001a\u0004\b_\u0010`R\u0014\u0010d\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\bb\u0010cR\u001c\u0010h\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0e8&X¦\u0004¢\u0006\u0006\u001a\u0004\bf\u0010g\u0082\u0001\u0001iø\u0001\u0002\u0082\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006jÀ\u0006\u0003"}, d2 = {"Landroidx/compose/ui/text/Paragraph;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "start", "end", "Landroidx/compose/ui/graphics/Path;", "getPathForRange", "(II)Landroidx/compose/ui/graphics/Path;", "offset", "Landroidx/compose/ui/geometry/Rect;", "getCursorRect", "(I)Landroidx/compose/ui/geometry/Rect;", "lineIndex", BuildConfig.FLAVOR, "getLineLeft", "(I)F", "getLineRight", "getLineTop", "getLineBottom", "getLineStart", "(I)I", BuildConfig.FLAVOR, "visibleEnd", "getLineEnd", "(IZ)I", "getLineForOffset", "usePrimaryDirection", "getHorizontalPosition", "(IZ)F", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "getParagraphDirection", "(I)Landroidx/compose/ui/text/style/ResolvedTextDirection;", "getBidiRunDirection", "vertical", "getLineForVerticalPosition", "(F)I", "Landroidx/compose/ui/geometry/Offset;", "position", "getOffsetForPosition-k-4lQ0M", "(J)I", "getOffsetForPosition", "rect", "Landroidx/compose/ui/text/TextGranularity;", "granularity", "Landroidx/compose/ui/text/TextInclusionStrategy;", "inclusionStrategy", "Landroidx/compose/ui/text/TextRange;", "getRangeForRect-8-6BmAI", "(Landroidx/compose/ui/geometry/Rect;ILandroidx/compose/ui/text/TextInclusionStrategy;)J", "getRangeForRect", "getBoundingBox", "range", BuildConfig.FLAVOR, "array", "arrayStart", BuildConfig.FLAVOR, "fillBoundingBoxes-8ffj60Q", "(J[FI)V", "fillBoundingBoxes", "getWordBoundary--jx7JFs", "(I)J", "getWordBoundary", "Landroidx/compose/ui/graphics/Canvas;", "canvas", "Landroidx/compose/ui/graphics/Color;", "color", "Landroidx/compose/ui/graphics/Shadow;", "shadow", "Landroidx/compose/ui/text/style/TextDecoration;", "textDecoration", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "drawStyle", "Landroidx/compose/ui/graphics/BlendMode;", "blendMode", "paint-LG529CI", "(Landroidx/compose/ui/graphics/Canvas;JLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/drawscope/DrawStyle;I)V", "paint", "Landroidx/compose/ui/graphics/Brush;", "brush", "alpha", "paint-hn5TExg", "(Landroidx/compose/ui/graphics/Canvas;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/drawscope/DrawStyle;I)V", "getWidth", "()F", "width", "getHeight", "height", "getMinIntrinsicWidth", "minIntrinsicWidth", "getMaxIntrinsicWidth", "maxIntrinsicWidth", "getFirstBaseline", "firstBaseline", "getLastBaseline", "lastBaseline", "getDidExceedMaxLines", "()Z", "didExceedMaxLines", "getLineCount", "()I", "lineCount", BuildConfig.FLAVOR, "getPlaceholderRects", "()Ljava/util/List;", "placeholderRects", "Landroidx/compose/ui/text/AndroidParagraph;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface Paragraph {
    /* renamed from: paint-LG529CI$default, reason: not valid java name */
    static /* synthetic */ void m2224paintLG529CI$default(Paragraph paragraph, Canvas canvas, long j5, Shadow shadow, TextDecoration textDecoration, DrawStyle drawStyle, int i5, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: paint-LG529CI");
        }
        paragraph.mo2190paintLG529CI(canvas, (i6 & 2) != 0 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : j5, (i6 & 4) != 0 ? null : shadow, (i6 & 8) != 0 ? null : textDecoration, (i6 & 16) == 0 ? drawStyle : null, (i6 & 32) != 0 ? DrawScope.INSTANCE.m1704getDefaultBlendMode0nO6VwU() : i5);
    }

    /* renamed from: paint-hn5TExg$default, reason: not valid java name */
    static /* synthetic */ void m2225painthn5TExg$default(Paragraph paragraph, Canvas canvas, Brush brush, float f5, Shadow shadow, TextDecoration textDecoration, DrawStyle drawStyle, int i5, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: paint-hn5TExg");
        }
        paragraph.mo2191painthn5TExg(canvas, brush, (i6 & 4) != 0 ? Float.NaN : f5, (i6 & 8) != 0 ? null : shadow, (i6 & 16) != 0 ? null : textDecoration, (i6 & 32) != 0 ? null : drawStyle, (i6 & 64) != 0 ? DrawScope.INSTANCE.m1704getDefaultBlendMode0nO6VwU() : i5);
    }

    /* renamed from: fillBoundingBoxes-8ffj60Q */
    void mo2186fillBoundingBoxes8ffj60Q(long range, float[] array, int arrayStart);

    ResolvedTextDirection getBidiRunDirection(int offset);

    Rect getBoundingBox(int offset);

    Rect getCursorRect(int offset);

    boolean getDidExceedMaxLines();

    float getFirstBaseline();

    float getHeight();

    float getHorizontalPosition(int offset, boolean usePrimaryDirection);

    float getLastBaseline();

    float getLineBottom(int lineIndex);

    int getLineCount();

    int getLineEnd(int lineIndex, boolean visibleEnd);

    int getLineForOffset(int offset);

    int getLineForVerticalPosition(float vertical);

    float getLineLeft(int lineIndex);

    float getLineRight(int lineIndex);

    int getLineStart(int lineIndex);

    float getLineTop(int lineIndex);

    float getMaxIntrinsicWidth();

    float getMinIntrinsicWidth();

    /* renamed from: getOffsetForPosition-k-4lQ0M */
    int mo2187getOffsetForPositionk4lQ0M(long position);

    ResolvedTextDirection getParagraphDirection(int offset);

    Path getPathForRange(int start, int end);

    List<Rect> getPlaceholderRects();

    /* renamed from: getRangeForRect-8-6BmAI */
    long mo2188getRangeForRect86BmAI(Rect rect, int granularity, TextInclusionStrategy inclusionStrategy);

    float getWidth();

    /* renamed from: getWordBoundary--jx7JFs */
    long mo2189getWordBoundaryjx7JFs(int offset);

    /* renamed from: paint-LG529CI */
    void mo2190paintLG529CI(Canvas canvas, long color, Shadow shadow, TextDecoration textDecoration, DrawStyle drawStyle, int blendMode);

    /* renamed from: paint-hn5TExg */
    void mo2191painthn5TExg(Canvas canvas, Brush brush, float alpha, Shadow shadow, TextDecoration textDecoration, DrawStyle drawStyle, int blendMode);
}
