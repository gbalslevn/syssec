package androidx.compose.ui.graphics;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\t"}, d2 = {"setFrom", BuildConfig.FLAVOR, "Landroid/graphics/Matrix;", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "setFrom-EL8BTi8", "(Landroid/graphics/Matrix;[F)V", "setFrom-tU-YjHk", "([FLandroid/graphics/Matrix;)V", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class AndroidMatrixConversions_androidKt {
    /* renamed from: setFrom-EL8BTi8, reason: not valid java name */
    public static final void m1401setFromEL8BTi8(android.graphics.Matrix matrix, float[] fArr) {
        float f5 = fArr[0];
        float f6 = fArr[1];
        float f7 = fArr[2];
        float f8 = fArr[3];
        float f9 = fArr[4];
        float f10 = fArr[5];
        float f11 = fArr[6];
        float f12 = fArr[7];
        float f13 = fArr[8];
        float f14 = fArr[12];
        float f15 = fArr[13];
        float f16 = fArr[15];
        fArr[0] = f5;
        fArr[1] = f9;
        fArr[2] = f14;
        fArr[3] = f6;
        fArr[4] = f10;
        fArr[5] = f15;
        fArr[6] = f8;
        fArr[7] = f12;
        fArr[8] = f16;
        matrix.setValues(fArr);
        fArr[0] = f5;
        fArr[1] = f6;
        fArr[2] = f7;
        fArr[3] = f8;
        fArr[4] = f9;
        fArr[5] = f10;
        fArr[6] = f11;
        fArr[7] = f12;
        fArr[8] = f13;
    }

    /* renamed from: setFrom-tU-YjHk, reason: not valid java name */
    public static final void m1402setFromtUYjHk(float[] fArr, android.graphics.Matrix matrix) {
        matrix.getValues(fArr);
        float f5 = fArr[0];
        float f6 = fArr[1];
        float f7 = fArr[2];
        float f8 = fArr[3];
        float f9 = fArr[4];
        float f10 = fArr[5];
        float f11 = fArr[6];
        float f12 = fArr[7];
        float f13 = fArr[8];
        fArr[0] = f5;
        fArr[1] = f8;
        fArr[2] = 0.0f;
        fArr[3] = f11;
        fArr[4] = f6;
        fArr[5] = f9;
        fArr[6] = 0.0f;
        fArr[7] = f12;
        fArr[8] = 0.0f;
        fArr[9] = 0.0f;
        fArr[10] = 1.0f;
        fArr[11] = 0.0f;
        fArr[12] = f7;
        fArr[13] = f10;
        fArr[14] = 0.0f;
        fArr[15] = f13;
    }
}
