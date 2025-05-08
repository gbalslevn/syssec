package androidx.compose.ui.platform;

import android.graphics.Matrix;
import androidx.compose.ui.graphics.AndroidMatrixConversions_androidKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B!\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00028\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0011\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00028\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u000eR&\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0012R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000eø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000eø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001bR\u0016\u0010\u001d\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001b\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u001e"}, d2 = {"Landroidx/compose/ui/platform/LayerMatrixCache;", "T", BuildConfig.FLAVOR, "Lkotlin/Function2;", "Landroid/graphics/Matrix;", BuildConfig.FLAVOR, "getMatrix", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "invalidate", "()V", "target", "Landroidx/compose/ui/graphics/Matrix;", "calculateMatrix-GrdbGEg", "(Ljava/lang/Object;)[F", "calculateMatrix", "calculateInverseMatrix-bWbORWo", "calculateInverseMatrix", "Lkotlin/jvm/functions/Function2;", "androidMatrixCache", "Landroid/graphics/Matrix;", "previousAndroidMatrix", "matrixCache", "[F", "inverseMatrixCache", BuildConfig.FLAVOR, "isDirty", "Z", "isInverseDirty", "isInverseValid", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LayerMatrixCache<T> {
    private Matrix androidMatrixCache;
    private final Function2<T, Matrix, Unit> getMatrix;
    private float[] inverseMatrixCache;
    private boolean isDirty = true;
    private boolean isInverseDirty = true;
    private boolean isInverseValid = true;
    private float[] matrixCache;
    private Matrix previousAndroidMatrix;

    /* JADX WARN: Multi-variable type inference failed */
    public LayerMatrixCache(Function2<? super T, ? super Matrix, Unit> function2) {
        this.getMatrix = function2;
    }

    /* renamed from: calculateInverseMatrix-bWbORWo, reason: not valid java name */
    public final float[] m2139calculateInverseMatrixbWbORWo(T target) {
        float[] fArr = this.inverseMatrixCache;
        if (fArr == null) {
            fArr = androidx.compose.ui.graphics.Matrix.m1547constructorimpl$default(null, 1, null);
            this.inverseMatrixCache = fArr;
        }
        if (this.isInverseDirty) {
            this.isInverseValid = InvertMatrixKt.m2138invertToJiSxe2E(m2140calculateMatrixGrdbGEg(target), fArr);
            this.isInverseDirty = false;
        }
        if (this.isInverseValid) {
            return fArr;
        }
        return null;
    }

    /* renamed from: calculateMatrix-GrdbGEg, reason: not valid java name */
    public final float[] m2140calculateMatrixGrdbGEg(T target) {
        float[] fArr = this.matrixCache;
        if (fArr == null) {
            fArr = androidx.compose.ui.graphics.Matrix.m1547constructorimpl$default(null, 1, null);
            this.matrixCache = fArr;
        }
        if (!this.isDirty) {
            return fArr;
        }
        Matrix matrix = this.androidMatrixCache;
        if (matrix == null) {
            matrix = new Matrix();
            this.androidMatrixCache = matrix;
        }
        this.getMatrix.invoke(target, matrix);
        Matrix matrix2 = this.previousAndroidMatrix;
        if (matrix2 == null || !Intrinsics.areEqual(matrix, matrix2)) {
            AndroidMatrixConversions_androidKt.m1402setFromtUYjHk(fArr, matrix);
            this.androidMatrixCache = matrix2;
            this.previousAndroidMatrix = matrix;
        }
        this.isDirty = false;
        return fArr;
    }

    public final void invalidate() {
        this.isDirty = true;
        this.isInverseDirty = true;
    }
}
