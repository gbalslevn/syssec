package androidx.compose.animation.core;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\u000b\u001a\u00020\bH\u0010¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000e\u001a\u00020\u0000H\u0010¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0090\u0002¢\u0006\u0004\b\u0011\u0010\u0012J \u0010\u0017\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0002H\u0090\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0096\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u000fH\u0016¢\u0006\u0004\b \u0010!R*\u0010\u0003\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u00028\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R*\u0010\u0004\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u00028\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010#\u001a\u0004\b(\u0010%\"\u0004\b)\u0010'R*\u0010\u0005\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u00028\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010#\u001a\u0004\b*\u0010%\"\u0004\b+\u0010'R\u001a\u0010,\u001a\u00020\u000f8\u0010X\u0090D¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010!¨\u0006/"}, d2 = {"Landroidx/compose/animation/core/AnimationVector3D;", "Landroidx/compose/animation/core/AnimationVector;", BuildConfig.FLAVOR, "v1", "v2", "v3", "<init>", "(FFF)V", BuildConfig.FLAVOR, "reset$animation_core_release", "()V", "reset", "newVector$animation_core_release", "()Landroidx/compose/animation/core/AnimationVector3D;", "newVector", BuildConfig.FLAVOR, "index", "get$animation_core_release", "(I)F", "get", "value", "set$animation_core_release", "(IF)V", "set", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "<set-?>", "F", "getV1", "()F", "setV1$animation_core_release", "(F)V", "getV2", "setV2$animation_core_release", "getV3", "setV3$animation_core_release", "size", "I", "getSize$animation_core_release", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AnimationVector3D extends AnimationVector {
    private final int size;
    private float v1;
    private float v2;
    private float v3;

    public AnimationVector3D(float f5, float f6, float f7) {
        super(null);
        this.v1 = f5;
        this.v2 = f6;
        this.v3 = f7;
        this.size = 3;
    }

    public boolean equals(Object other) {
        if (other instanceof AnimationVector3D) {
            AnimationVector3D animationVector3D = (AnimationVector3D) other;
            if (animationVector3D.v1 == this.v1 && animationVector3D.v2 == this.v2 && animationVector3D.v3 == this.v3) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public float get$animation_core_release(int index) {
        if (index == 0) {
            return this.v1;
        }
        if (index == 1) {
            return this.v2;
        }
        if (index != 2) {
            return 0.0f;
        }
        return this.v3;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    /* renamed from: getSize$animation_core_release, reason: from getter */
    public int getSize() {
        return this.size;
    }

    public int hashCode() {
        return (((Float.hashCode(this.v1) * 31) + Float.hashCode(this.v2)) * 31) + Float.hashCode(this.v3);
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public void reset$animation_core_release() {
        this.v1 = 0.0f;
        this.v2 = 0.0f;
        this.v3 = 0.0f;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public void set$animation_core_release(int index, float value) {
        if (index == 0) {
            this.v1 = value;
        } else if (index == 1) {
            this.v2 = value;
        } else {
            if (index != 2) {
                return;
            }
            this.v3 = value;
        }
    }

    public String toString() {
        return "AnimationVector3D: v1 = " + this.v1 + ", v2 = " + this.v2 + ", v3 = " + this.v3;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public AnimationVector3D newVector$animation_core_release() {
        return new AnimationVector3D(0.0f, 0.0f, 0.0f);
    }
}
