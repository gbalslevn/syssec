package androidx.compose.ui.platform;

import android.graphics.Matrix;
import android.view.View;
import androidx.compose.ui.graphics.AndroidMatrixConversions_androidKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u0016ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\"\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u000eJ\u001e\u0010\u0011\u001a\u00020\t*\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J&\u0010\u0016\u001a\u00020\t*\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0002ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0007\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001c"}, d2 = {"Landroidx/compose/ui/platform/CalculateMatrixToWindowApi21;", "Landroidx/compose/ui/platform/CalculateMatrixToWindow;", "tmpMatrix", "Landroidx/compose/ui/graphics/Matrix;", "([FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "tmpLocation", BuildConfig.FLAVOR, "[F", "calculateMatrixToWindow", BuildConfig.FLAVOR, "view", "Landroid/view/View;", "matrix", "calculateMatrixToWindow-EL8BTi8", "(Landroid/view/View;[F)V", "transformMatrixToWindow", "transformMatrixToWindow-EL8BTi8", "preConcat", "other", "Landroid/graphics/Matrix;", "preConcat-tU-YjHk", "([FLandroid/graphics/Matrix;)V", "preTranslate", "x", BuildConfig.FLAVOR, "y", "preTranslate-3XD1CNM", "([FFF)V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CalculateMatrixToWindowApi21 implements CalculateMatrixToWindow {
    private final int[] tmpLocation;
    private final float[] tmpMatrix;

    public /* synthetic */ CalculateMatrixToWindowApi21(float[] fArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(fArr);
    }

    /* renamed from: preConcat-tU-YjHk, reason: not valid java name */
    private final void m2119preConcattUYjHk(float[] fArr, Matrix matrix) {
        AndroidMatrixConversions_androidKt.m1402setFromtUYjHk(this.tmpMatrix, matrix);
        AndroidComposeView_androidKt.m2116preTransformJiSxe2E(fArr, this.tmpMatrix);
    }

    /* renamed from: preTranslate-3XD1CNM, reason: not valid java name */
    private final void m2120preTranslate3XD1CNM(float[] fArr, float f5, float f6) {
        AndroidComposeView_androidKt.m2117preTranslatecG2Xzmc(fArr, f5, f6, this.tmpMatrix);
    }

    /* renamed from: transformMatrixToWindow-EL8BTi8, reason: not valid java name */
    private final void m2121transformMatrixToWindowEL8BTi8(View view, float[] matrix) {
        Object parent = view.getParent();
        if (parent instanceof View) {
            m2121transformMatrixToWindowEL8BTi8((View) parent, matrix);
            m2120preTranslate3XD1CNM(matrix, -view.getScrollX(), -view.getScrollY());
            m2120preTranslate3XD1CNM(matrix, view.getLeft(), view.getTop());
        } else {
            view.getLocationInWindow(this.tmpLocation);
            m2120preTranslate3XD1CNM(matrix, -view.getScrollX(), -view.getScrollY());
            m2120preTranslate3XD1CNM(matrix, r0[0], r0[1]);
        }
        Matrix matrix2 = view.getMatrix();
        if (matrix2.isIdentity()) {
            return;
        }
        m2119preConcattUYjHk(matrix, matrix2);
    }

    @Override // androidx.compose.ui.platform.CalculateMatrixToWindow
    /* renamed from: calculateMatrixToWindow-EL8BTi8 */
    public void mo2118calculateMatrixToWindowEL8BTi8(View view, float[] matrix) {
        androidx.compose.ui.graphics.Matrix.m1552resetimpl(matrix);
        m2121transformMatrixToWindowEL8BTi8(view, matrix);
    }

    private CalculateMatrixToWindowApi21(float[] fArr) {
        this.tmpMatrix = fArr;
        this.tmpLocation = new int[2];
    }
}
