package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Rect;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u001f\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH&¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\f2\b\b\u0002\u0010\u0012\u001a\u00020\fH&¢\u0006\u0004\b\u0013\u0010\u0010J\u0017\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\fH&¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017H&ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ$\u0010!\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u00062\b\b\u0002\u0010\u001e\u001a\u00020\u001dH\u0016ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 J<\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020\f2\b\b\u0002\u0010\u001e\u001a\u00020\u001dH&ø\u0001\u0000¢\u0006\u0004\b&\u0010'J$\u0010,\u001a\u00020\u00022\u0006\u0010)\u001a\u00020(2\b\b\u0002\u0010\u001e\u001a\u00020\u001dH&ø\u0001\u0000¢\u0006\u0004\b*\u0010+J*\u00102\u001a\u00020\u00022\u0006\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u00020-2\u0006\u0010\t\u001a\u00020\bH&ø\u0001\u0000¢\u0006\u0004\b0\u00101J\u001f\u00103\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b3\u0010\u000bJ7\u00103\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b3\u00104JG\u00107\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020\f2\u0006\u00105\u001a\u00020\f2\u0006\u00106\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b7\u00108J*\u0010=\u001a\u00020\u00022\u0006\u00109\u001a\u00020-2\u0006\u0010:\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\bH&ø\u0001\u0000¢\u0006\u0004\b;\u0010<J\u001f\u0010>\u001a\u00020\u00022\u0006\u0010)\u001a\u00020(2\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b>\u0010?J*\u0010E\u001a\u00020\u00022\u0006\u0010A\u001a\u00020@2\u0006\u0010B\u001a\u00020-2\u0006\u0010\t\u001a\u00020\bH&ø\u0001\u0000¢\u0006\u0004\bC\u0010DJJ\u0010N\u001a\u00020\u00022\u0006\u0010A\u001a\u00020@2\b\b\u0002\u0010G\u001a\u00020F2\b\b\u0002\u0010I\u001a\u00020H2\b\b\u0002\u0010J\u001a\u00020F2\b\b\u0002\u0010K\u001a\u00020H2\u0006\u0010\t\u001a\u00020\bH&ø\u0001\u0000¢\u0006\u0004\bL\u0010MJ\u000f\u0010O\u001a\u00020\u0002H&¢\u0006\u0004\bO\u0010\u0004J\u000f\u0010P\u001a\u00020\u0002H&¢\u0006\u0004\bP\u0010\u0004ø\u0001\u0001\u0082\u0002\r\n\u0005\b¡\u001e0\u0001\n\u0004\b!0\u0001¨\u0006QÀ\u0006\u0003"}, d2 = {"Landroidx/compose/ui/graphics/Canvas;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "save", "()V", "restore", "Landroidx/compose/ui/geometry/Rect;", "bounds", "Landroidx/compose/ui/graphics/Paint;", "paint", "saveLayer", "(Landroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/graphics/Paint;)V", BuildConfig.FLAVOR, "dx", "dy", "translate", "(FF)V", "sx", "sy", "scale", "degrees", "rotate", "(F)V", "Landroidx/compose/ui/graphics/Matrix;", "matrix", "concat-58bKbWc", "([F)V", "concat", "rect", "Landroidx/compose/ui/graphics/ClipOp;", "clipOp", "clipRect-mtrdD-E", "(Landroidx/compose/ui/geometry/Rect;I)V", "clipRect", "left", "top", "right", "bottom", "clipRect-N_I0leg", "(FFFFI)V", "Landroidx/compose/ui/graphics/Path;", "path", "clipPath-mtrdD-E", "(Landroidx/compose/ui/graphics/Path;I)V", "clipPath", "Landroidx/compose/ui/geometry/Offset;", "p1", "p2", "drawLine-Wko1d7g", "(JJLandroidx/compose/ui/graphics/Paint;)V", "drawLine", "drawRect", "(FFFFLandroidx/compose/ui/graphics/Paint;)V", "radiusX", "radiusY", "drawRoundRect", "(FFFFFFLandroidx/compose/ui/graphics/Paint;)V", "center", "radius", "drawCircle-9KIMszo", "(JFLandroidx/compose/ui/graphics/Paint;)V", "drawCircle", "drawPath", "(Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/graphics/Paint;)V", "Landroidx/compose/ui/graphics/ImageBitmap;", "image", "topLeftOffset", "drawImage-d-4ec7I", "(Landroidx/compose/ui/graphics/ImageBitmap;JLandroidx/compose/ui/graphics/Paint;)V", "drawImage", "Landroidx/compose/ui/unit/IntOffset;", "srcOffset", "Landroidx/compose/ui/unit/IntSize;", "srcSize", "dstOffset", "dstSize", "drawImageRect-HPBpro0", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJLandroidx/compose/ui/graphics/Paint;)V", "drawImageRect", "enableZ", "disableZ", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface Canvas {
    /* renamed from: clipPath-mtrdD-E$default, reason: not valid java name */
    static /* synthetic */ void m1473clipPathmtrdDE$default(Canvas canvas, Path path, int i5, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clipPath-mtrdD-E");
        }
        if ((i6 & 2) != 0) {
            i5 = ClipOp.INSTANCE.m1480getIntersectrtfAjoo();
        }
        canvas.mo1389clipPathmtrdDE(path, i5);
    }

    /* renamed from: clipRect-N_I0leg$default, reason: not valid java name */
    static /* synthetic */ void m1474clipRectN_I0leg$default(Canvas canvas, float f5, float f6, float f7, float f8, int i5, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clipRect-N_I0leg");
        }
        if ((i6 & 16) != 0) {
            i5 = ClipOp.INSTANCE.m1480getIntersectrtfAjoo();
        }
        canvas.mo1390clipRectN_I0leg(f5, f6, f7, f8, i5);
    }

    /* renamed from: clipRect-mtrdD-E$default, reason: not valid java name */
    static /* synthetic */ void m1475clipRectmtrdDE$default(Canvas canvas, Rect rect, int i5, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clipRect-mtrdD-E");
        }
        if ((i6 & 2) != 0) {
            i5 = ClipOp.INSTANCE.m1480getIntersectrtfAjoo();
        }
        canvas.m1476clipRectmtrdDE(rect, i5);
    }

    /* renamed from: clipPath-mtrdD-E */
    void mo1389clipPathmtrdDE(Path path, int clipOp);

    /* renamed from: clipRect-N_I0leg */
    void mo1390clipRectN_I0leg(float left, float top, float right, float bottom, int clipOp);

    /* renamed from: clipRect-mtrdD-E, reason: not valid java name */
    default void m1476clipRectmtrdDE(Rect rect, int clipOp) {
        mo1390clipRectN_I0leg(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom(), clipOp);
    }

    /* renamed from: concat-58bKbWc */
    void mo1391concat58bKbWc(float[] matrix);

    void disableZ();

    /* renamed from: drawCircle-9KIMszo */
    void mo1392drawCircle9KIMszo(long center, float radius, Paint paint);

    /* renamed from: drawImage-d-4ec7I */
    void mo1393drawImaged4ec7I(ImageBitmap image, long topLeftOffset, Paint paint);

    /* renamed from: drawImageRect-HPBpro0 */
    void mo1394drawImageRectHPBpro0(ImageBitmap image, long srcOffset, long srcSize, long dstOffset, long dstSize, Paint paint);

    /* renamed from: drawLine-Wko1d7g */
    void mo1395drawLineWko1d7g(long p12, long p22, Paint paint);

    void drawPath(Path path, Paint paint);

    void drawRect(float left, float top, float right, float bottom, Paint paint);

    default void drawRect(Rect rect, Paint paint) {
        drawRect(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom(), paint);
    }

    void drawRoundRect(float left, float top, float right, float bottom, float radiusX, float radiusY, Paint paint);

    void enableZ();

    void restore();

    void rotate(float degrees);

    void save();

    void saveLayer(Rect bounds, Paint paint);

    void scale(float sx, float sy);

    void translate(float dx, float dy);
}
