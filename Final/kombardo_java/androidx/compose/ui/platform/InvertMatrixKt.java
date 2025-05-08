package androidx.compose.ui.platform;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0006"}, d2 = {"invertTo", BuildConfig.FLAVOR, "Landroidx/compose/ui/graphics/Matrix;", "other", "invertTo-JiSxe2E", "([F[F)Z", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class InvertMatrixKt {
    /* renamed from: invertTo-JiSxe2E, reason: not valid java name */
    public static final boolean m2138invertToJiSxe2E(float[] fArr, float[] fArr2) {
        float f5 = fArr[0];
        float f6 = fArr[1];
        float f7 = fArr[2];
        float f8 = fArr[3];
        float f9 = fArr[4];
        float f10 = fArr[5];
        float f11 = fArr[6];
        float f12 = fArr[7];
        float f13 = fArr[8];
        float f14 = fArr[9];
        float f15 = fArr[10];
        float f16 = fArr[11];
        float f17 = fArr[12];
        float f18 = fArr[13];
        float f19 = fArr[14];
        float f20 = fArr[15];
        float f21 = (f5 * f10) - (f6 * f9);
        float f22 = (f5 * f11) - (f7 * f9);
        float f23 = (f5 * f12) - (f8 * f9);
        float f24 = (f6 * f11) - (f7 * f10);
        float f25 = (f6 * f12) - (f8 * f10);
        float f26 = (f7 * f12) - (f8 * f11);
        float f27 = (f13 * f18) - (f14 * f17);
        float f28 = (f13 * f19) - (f15 * f17);
        float f29 = (f13 * f20) - (f16 * f17);
        float f30 = (f14 * f19) - (f15 * f18);
        float f31 = (f14 * f20) - (f16 * f18);
        float f32 = (f15 * f20) - (f16 * f19);
        float f33 = (((((f21 * f32) - (f22 * f31)) + (f23 * f30)) + (f24 * f29)) - (f25 * f28)) + (f26 * f27);
        if (f33 == 0.0f) {
            return false;
        }
        float f34 = 1.0f / f33;
        fArr2[0] = (((f10 * f32) - (f11 * f31)) + (f12 * f30)) * f34;
        fArr2[1] = ((((-f6) * f32) + (f7 * f31)) - (f8 * f30)) * f34;
        fArr2[2] = (((f18 * f26) - (f19 * f25)) + (f20 * f24)) * f34;
        fArr2[3] = ((((-f14) * f26) + (f15 * f25)) - (f16 * f24)) * f34;
        float f35 = -f9;
        fArr2[4] = (((f35 * f32) + (f11 * f29)) - (f12 * f28)) * f34;
        fArr2[5] = (((f32 * f5) - (f7 * f29)) + (f8 * f28)) * f34;
        float f36 = -f17;
        fArr2[6] = (((f36 * f26) + (f19 * f23)) - (f20 * f22)) * f34;
        fArr2[7] = (((f26 * f13) - (f15 * f23)) + (f16 * f22)) * f34;
        fArr2[8] = (((f9 * f31) - (f10 * f29)) + (f12 * f27)) * f34;
        fArr2[9] = ((((-f5) * f31) + (f29 * f6)) - (f8 * f27)) * f34;
        fArr2[10] = (((f17 * f25) - (f18 * f23)) + (f20 * f21)) * f34;
        fArr2[11] = ((((-f13) * f25) + (f23 * f14)) - (f16 * f21)) * f34;
        fArr2[12] = (((f35 * f30) + (f10 * f28)) - (f11 * f27)) * f34;
        fArr2[13] = (((f5 * f30) - (f6 * f28)) + (f7 * f27)) * f34;
        fArr2[14] = (((f36 * f24) + (f18 * f22)) - (f19 * f21)) * f34;
        fArr2[15] = (((f13 * f24) - (f14 * f22)) + (f15 * f21)) * f34;
        return true;
    }
}
