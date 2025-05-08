package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0080\b\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\u001f\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0004\u001a\u00028\u00008\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001d\u0010\b\u001a\u00020\u00078\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\b\u0010\u001b\u001a\u0004\b\u001c\u0010\u0010\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001d"}, d2 = {"Landroidx/compose/animation/core/VectorizedKeyframeSpecElementInfo;", "Landroidx/compose/animation/core/AnimationVector;", "V", BuildConfig.FLAVOR, "vectorValue", "Landroidx/compose/animation/core/Easing;", "easing", "Landroidx/compose/animation/core/ArcMode;", "arcMode", "<init>", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/Easing;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Landroidx/compose/animation/core/AnimationVector;", "getVectorValue", "()Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/Easing;", "getEasing", "()Landroidx/compose/animation/core/Easing;", "I", "getArcMode--9T-Mq4", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class VectorizedKeyframeSpecElementInfo<V extends AnimationVector> {
    private final int arcMode;
    private final Easing easing;
    private final V vectorValue;

    public /* synthetic */ VectorizedKeyframeSpecElementInfo(AnimationVector animationVector, Easing easing, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(animationVector, easing, i5);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VectorizedKeyframeSpecElementInfo)) {
            return false;
        }
        VectorizedKeyframeSpecElementInfo vectorizedKeyframeSpecElementInfo = (VectorizedKeyframeSpecElementInfo) other;
        return Intrinsics.areEqual(this.vectorValue, vectorizedKeyframeSpecElementInfo.vectorValue) && Intrinsics.areEqual(this.easing, vectorizedKeyframeSpecElementInfo.easing) && ArcMode.m60equalsimpl0(this.arcMode, vectorizedKeyframeSpecElementInfo.arcMode);
    }

    /* renamed from: getArcMode--9T-Mq4, reason: not valid java name and from getter */
    public final int getArcMode() {
        return this.arcMode;
    }

    public final Easing getEasing() {
        return this.easing;
    }

    public final V getVectorValue() {
        return this.vectorValue;
    }

    public int hashCode() {
        return (((this.vectorValue.hashCode() * 31) + this.easing.hashCode()) * 31) + ArcMode.m61hashCodeimpl(this.arcMode);
    }

    public String toString() {
        return "VectorizedKeyframeSpecElementInfo(vectorValue=" + this.vectorValue + ", easing=" + this.easing + ", arcMode=" + ((Object) ArcMode.m62toStringimpl(this.arcMode)) + ')';
    }

    private VectorizedKeyframeSpecElementInfo(V v5, Easing easing, int i5) {
        this.vectorValue = v5;
        this.easing = easing;
        this.arcMode = i5;
    }
}
