package androidx.compose.animation;

import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u000e\"\u0004\b\u0000\u0010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"EndTension", BuildConfig.FLAVOR, "Inflection", "P1", "P2", "StartTension", "computeSplineInfo", BuildConfig.FLAVOR, "splinePositions", BuildConfig.FLAVOR, "splineTimes", "nbSamples", BuildConfig.FLAVOR, "splineBasedDecay", "Landroidx/compose/animation/core/DecayAnimationSpec;", "T", "density", "Landroidx/compose/ui/unit/Density;", "animation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class SplineBasedDecayKt {
    private static final float EndTension = 1.0f;
    private static final float Inflection = 0.35f;

    /* renamed from: P1, reason: collision with root package name */
    private static final float f3520P1 = 0.175f;

    /* renamed from: P2, reason: collision with root package name */
    private static final float f3521P2 = 0.35000002f;
    private static final float StartTension = 0.5f;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void computeSplineInfo(float[] fArr, float[] fArr2, int i5) {
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        float f12;
        float f13 = 0.0f;
        float f14 = 0.0f;
        for (int i6 = 0; i6 < i5; i6++) {
            float f15 = i6 / i5;
            float f16 = 1.0f;
            while (true) {
                f5 = ((f16 - f13) / 2.0f) + f13;
                f6 = EndTension - f5;
                f7 = f5 * 3.0f * f6;
                f8 = f5 * f5 * f5;
                float f17 = (((f6 * f3520P1) + (f5 * f3521P2)) * f7) + f8;
                if (Math.abs(f17 - f15) < 1.0E-5d) {
                    break;
                } else if (f17 > f15) {
                    f16 = f5;
                } else {
                    f13 = f5;
                }
            }
            float f18 = StartTension;
            fArr[i6] = (f7 * ((f6 * StartTension) + f5)) + f8;
            float f19 = 1.0f;
            while (true) {
                f9 = ((f19 - f14) / 2.0f) + f14;
                f10 = EndTension - f9;
                f11 = f9 * 3.0f * f10;
                f12 = f9 * f9 * f9;
                float f20 = (((f10 * f18) + f9) * f11) + f12;
                if (Math.abs(f20 - f15) >= 1.0E-5d) {
                    if (f20 > f15) {
                        f19 = f9;
                    } else {
                        f14 = f9;
                    }
                    f18 = StartTension;
                }
            }
            fArr2[i6] = (f11 * ((f10 * f3520P1) + (f9 * f3521P2))) + f12;
        }
        fArr2[i5] = 1.0f;
        fArr[i5] = 1.0f;
    }

    public static final <T> DecayAnimationSpec<T> splineBasedDecay(Density density) {
        return DecayAnimationSpecKt.generateDecayAnimationSpec(new SplineBasedFloatDecayAnimationSpec(density));
    }
}
