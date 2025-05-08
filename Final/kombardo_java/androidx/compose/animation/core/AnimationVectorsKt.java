package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0016\u0010\u0000\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003\u001a\u001e\u0010\u0000\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003\u001a&\u0010\u0000\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003\u001a\u001b\u0010\n\u001a\u0002H\u000b\"\b\b\u0000\u0010\u000b*\u00020\f*\u0002H\u000bH\u0000¢\u0006\u0002\u0010\r\u001a#\u0010\u000e\u001a\u00020\u000f\"\b\b\u0000\u0010\u000b*\u00020\f*\u0002H\u000b2\u0006\u0010\u0010\u001a\u0002H\u000bH\u0000¢\u0006\u0002\u0010\u0011\u001a\u001b\u0010\u0012\u001a\u0002H\u000b\"\b\b\u0000\u0010\u000b*\u00020\f*\u0002H\u000bH\u0000¢\u0006\u0002\u0010\r¨\u0006\u0013"}, d2 = {"AnimationVector", "Landroidx/compose/animation/core/AnimationVector1D;", "v1", BuildConfig.FLAVOR, "Landroidx/compose/animation/core/AnimationVector2D;", "v2", "Landroidx/compose/animation/core/AnimationVector3D;", "v3", "Landroidx/compose/animation/core/AnimationVector4D;", "v4", "copy", "T", "Landroidx/compose/animation/core/AnimationVector;", "(Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "copyFrom", BuildConfig.FLAVOR, "source", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)V", "newInstance", "animation-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class AnimationVectorsKt {
    public static final AnimationVector1D AnimationVector(float f5) {
        return new AnimationVector1D(f5);
    }

    public static final <T extends AnimationVector> T copy(T t5) {
        T t6 = (T) newInstance(t5);
        int size = t6.getSize();
        for (int i5 = 0; i5 < size; i5++) {
            t6.set$animation_core_release(i5, t5.get$animation_core_release(i5));
        }
        return t6;
    }

    public static final <T extends AnimationVector> void copyFrom(T t5, T t6) {
        int size = t5.getSize();
        for (int i5 = 0; i5 < size; i5++) {
            t5.set$animation_core_release(i5, t6.get$animation_core_release(i5));
        }
    }

    public static final <T extends AnimationVector> T newInstance(T t5) {
        T t6 = (T) t5.newVector$animation_core_release();
        Intrinsics.checkNotNull(t6, "null cannot be cast to non-null type T of androidx.compose.animation.core.AnimationVectorsKt.newInstance");
        return t6;
    }

    public static final AnimationVector2D AnimationVector(float f5, float f6) {
        return new AnimationVector2D(f5, f6);
    }

    public static final AnimationVector3D AnimationVector(float f5, float f6, float f7) {
        return new AnimationVector3D(f5, f6, f7);
    }

    public static final AnimationVector4D AnimationVector(float f5, float f6, float f7, float f8) {
        return new AnimationVector4D(f5, f6, f7, f8);
    }
}
