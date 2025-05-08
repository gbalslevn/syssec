package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Path;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J/\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\tJD\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\nH&ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ$\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u000b\u001a\u00020\nH&ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0014\u001a\u00020\u00072\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\u0014\u0010\u0015J$\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00022\b\b\u0002\u0010\u0018\u001a\u00020\u0017H&ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ,\u0010 \u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00022\b\b\u0002\u0010\u0018\u001a\u00020\u0017H&ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010%\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020!H&ø\u0001\u0000¢\u0006\u0004\b#\u0010$ø\u0001\u0001\u0082\u0002\r\n\u0005\b¡\u001e0\u0001\n\u0004\b!0\u0001¨\u0006&À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/graphics/drawscope/DrawTransform;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "left", "top", "right", "bottom", BuildConfig.FLAVOR, "inset", "(FFFF)V", "Landroidx/compose/ui/graphics/ClipOp;", "clipOp", "clipRect-N_I0leg", "(FFFFI)V", "clipRect", "Landroidx/compose/ui/graphics/Path;", "path", "clipPath-mtrdD-E", "(Landroidx/compose/ui/graphics/Path;I)V", "clipPath", "translate", "(FF)V", "degrees", "Landroidx/compose/ui/geometry/Offset;", "pivot", "rotate-Uv8p0NA", "(FJ)V", "rotate", "scaleX", "scaleY", "scale-0AR0LA0", "(FFJ)V", "scale", "Landroidx/compose/ui/graphics/Matrix;", "matrix", "transform-58bKbWc", "([F)V", "transform", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface DrawTransform {
    /* renamed from: clipPath-mtrdD-E$default, reason: not valid java name */
    static /* synthetic */ void m1706clipPathmtrdDE$default(DrawTransform drawTransform, Path path, int i5, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clipPath-mtrdD-E");
        }
        if ((i6 & 2) != 0) {
            i5 = ClipOp.INSTANCE.m1480getIntersectrtfAjoo();
        }
        drawTransform.mo1684clipPathmtrdDE(path, i5);
    }

    static /* synthetic */ void translate$default(DrawTransform drawTransform, float f5, float f6, int i5, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: translate");
        }
        if ((i5 & 1) != 0) {
            f5 = 0.0f;
        }
        if ((i5 & 2) != 0) {
            f6 = 0.0f;
        }
        drawTransform.translate(f5, f6);
    }

    /* renamed from: clipPath-mtrdD-E */
    void mo1684clipPathmtrdDE(Path path, int clipOp);

    /* renamed from: clipRect-N_I0leg */
    void mo1685clipRectN_I0leg(float left, float top, float right, float bottom, int clipOp);

    void inset(float left, float top, float right, float bottom);

    /* renamed from: rotate-Uv8p0NA */
    void mo1687rotateUv8p0NA(float degrees, long pivot);

    /* renamed from: scale-0AR0LA0 */
    void mo1688scale0AR0LA0(float scaleX, float scaleY, long pivot);

    /* renamed from: transform-58bKbWc */
    void mo1689transform58bKbWc(float[] matrix);

    void translate(float left, float top);
}
