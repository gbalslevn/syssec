package androidx.compose.material.ripple;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScopeKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010 \u001a\u00020\u0018H\u0086@¢\u0006\u0002\u0010!J\u000e\u0010\"\u001a\u00020\u0018H\u0082@¢\u0006\u0002\u0010!J\u000e\u0010#\u001a\u00020\u0018H\u0082@¢\u0006\u0002\u0010!J\u0006\u0010$\u001a\u00020\u0018J\u001c\u0010%\u001a\u00020\u0018*\u00020&2\u0006\u0010'\u001a\u00020(ø\u0001\u0000¢\u0006\u0004\b)\u0010*R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00078B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00078B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u001c\u0010\u0015\u001a\u0004\b\u001a\u0010\u0011\"\u0004\b\u001b\u0010\u0013R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001eR\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u0003X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006+"}, d2 = {"Landroidx/compose/material/ripple/RippleAnimation;", BuildConfig.FLAVOR, "origin", "Landroidx/compose/ui/geometry/Offset;", "radius", BuildConfig.FLAVOR, "bounded", BuildConfig.FLAVOR, "(Landroidx/compose/ui/geometry/Offset;FZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "animatedAlpha", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector1D;", "animatedCenterPercent", "animatedRadiusPercent", "<set-?>", "finishRequested", "getFinishRequested", "()Z", "setFinishRequested", "(Z)V", "finishRequested$delegate", "Landroidx/compose/runtime/MutableState;", "finishSignalDeferred", "Lkotlinx/coroutines/CompletableDeferred;", BuildConfig.FLAVOR, "finishedFadingIn", "getFinishedFadingIn", "setFinishedFadingIn", "finishedFadingIn$delegate", "startRadius", "Ljava/lang/Float;", "targetCenter", "animate", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fadeIn", "fadeOut", "finish", "draw", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "color", "Landroidx/compose/ui/graphics/Color;", "draw-4WTKRHQ", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;J)V", "material-ripple_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RippleAnimation {
    private final Animatable<Float, AnimationVector1D> animatedAlpha;
    private final Animatable<Float, AnimationVector1D> animatedCenterPercent;
    private final Animatable<Float, AnimationVector1D> animatedRadiusPercent;
    private final boolean bounded;

    /* renamed from: finishRequested$delegate, reason: from kotlin metadata */
    private final MutableState finishRequested;
    private final CompletableDeferred<Unit> finishSignalDeferred;

    /* renamed from: finishedFadingIn$delegate, reason: from kotlin metadata */
    private final MutableState finishedFadingIn;
    private Offset origin;
    private final float radius;
    private Float startRadius;
    private Offset targetCenter;

    public /* synthetic */ RippleAnimation(Offset offset, float f5, boolean z5, DefaultConstructorMarker defaultConstructorMarker) {
        this(offset, f5, z5);
    }

    private final Object fadeIn(Continuation<? super Unit> continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new RippleAnimation$fadeIn$2(this, null), continuation);
        return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }

    private final Object fadeOut(Continuation<? super Unit> continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new RippleAnimation$fadeOut$2(this, null), continuation);
        return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean getFinishRequested() {
        return ((Boolean) this.finishRequested.getValue()).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean getFinishedFadingIn() {
        return ((Boolean) this.finishedFadingIn.getValue()).booleanValue();
    }

    private final void setFinishRequested(boolean z5) {
        this.finishRequested.setValue(Boolean.valueOf(z5));
    }

    private final void setFinishedFadingIn(boolean z5) {
        this.finishedFadingIn.setValue(Boolean.valueOf(z5));
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0071 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0065 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object animate(Continuation<? super Unit> continuation) {
        RippleAnimation$animate$1 rippleAnimation$animate$1;
        Object coroutine_suspended;
        int i5;
        RippleAnimation rippleAnimation;
        CompletableDeferred<Unit> completableDeferred;
        if (continuation instanceof RippleAnimation$animate$1) {
            rippleAnimation$animate$1 = (RippleAnimation$animate$1) continuation;
            int i6 = rippleAnimation$animate$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                rippleAnimation$animate$1.label = i6 - Integer.MIN_VALUE;
                Object obj = rippleAnimation$animate$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = rippleAnimation$animate$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    rippleAnimation$animate$1.L$0 = this;
                    rippleAnimation$animate$1.label = 1;
                    if (fadeIn(rippleAnimation$animate$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    rippleAnimation = this;
                } else {
                    if (i5 != 1) {
                        if (i5 != 2) {
                            if (i5 != 3) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        }
                        rippleAnimation = (RippleAnimation) rippleAnimation$animate$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        rippleAnimation$animate$1.L$0 = null;
                        rippleAnimation$animate$1.label = 3;
                        if (rippleAnimation.fadeOut(rippleAnimation$animate$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    }
                    rippleAnimation = (RippleAnimation) rippleAnimation$animate$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                rippleAnimation.setFinishedFadingIn(true);
                completableDeferred = rippleAnimation.finishSignalDeferred;
                rippleAnimation$animate$1.L$0 = rippleAnimation;
                rippleAnimation$animate$1.label = 2;
                if (completableDeferred.await(rippleAnimation$animate$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                rippleAnimation$animate$1.L$0 = null;
                rippleAnimation$animate$1.label = 3;
                if (rippleAnimation.fadeOut(rippleAnimation$animate$1) == coroutine_suspended) {
                }
                return Unit.INSTANCE;
            }
        }
        rippleAnimation$animate$1 = new RippleAnimation$animate$1(this, continuation);
        Object obj2 = rippleAnimation$animate$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = rippleAnimation$animate$1.label;
        if (i5 != 0) {
        }
        rippleAnimation.setFinishedFadingIn(true);
        completableDeferred = rippleAnimation.finishSignalDeferred;
        rippleAnimation$animate$1.L$0 = rippleAnimation;
        rippleAnimation$animate$1.label = 2;
        if (completableDeferred.await(rippleAnimation$animate$1) == coroutine_suspended) {
        }
        rippleAnimation$animate$1.L$0 = null;
        rippleAnimation$animate$1.label = 3;
        if (rippleAnimation.fadeOut(rippleAnimation$animate$1) == coroutine_suspended) {
        }
        return Unit.INSTANCE;
    }

    /* renamed from: draw-4WTKRHQ, reason: not valid java name */
    public final void m753draw4WTKRHQ(DrawScope drawScope, long j5) {
        if (this.startRadius == null) {
            this.startRadius = Float.valueOf(RippleAnimationKt.m755getRippleStartRadiusuvyYCjk(drawScope.mo1703getSizeNHjbRc()));
        }
        if (this.origin == null) {
            this.origin = Offset.m1328boximpl(drawScope.mo1702getCenterF1C5BW0());
        }
        if (this.targetCenter == null) {
            this.targetCenter = Offset.m1328boximpl(OffsetKt.Offset(Size.m1377getWidthimpl(drawScope.mo1703getSizeNHjbRc()) / 2.0f, Size.m1375getHeightimpl(drawScope.mo1703getSizeNHjbRc()) / 2.0f));
        }
        float floatValue = (!getFinishRequested() || getFinishedFadingIn()) ? this.animatedAlpha.getValue().floatValue() : 1.0f;
        Float f5 = this.startRadius;
        Intrinsics.checkNotNull(f5);
        float lerp = MathHelpersKt.lerp(f5.floatValue(), this.radius, this.animatedRadiusPercent.getValue().floatValue());
        Offset offset = this.origin;
        Intrinsics.checkNotNull(offset);
        float m1337getXimpl = Offset.m1337getXimpl(offset.getPackedValue());
        Offset offset2 = this.targetCenter;
        Intrinsics.checkNotNull(offset2);
        float lerp2 = MathHelpersKt.lerp(m1337getXimpl, Offset.m1337getXimpl(offset2.getPackedValue()), this.animatedCenterPercent.getValue().floatValue());
        Offset offset3 = this.origin;
        Intrinsics.checkNotNull(offset3);
        float m1338getYimpl = Offset.m1338getYimpl(offset3.getPackedValue());
        Offset offset4 = this.targetCenter;
        Intrinsics.checkNotNull(offset4);
        long Offset = OffsetKt.Offset(lerp2, MathHelpersKt.lerp(m1338getYimpl, Offset.m1338getYimpl(offset4.getPackedValue()), this.animatedCenterPercent.getValue().floatValue()));
        long m1485copywmQWz5c$default = Color.m1485copywmQWz5c$default(j5, Color.m1488getAlphaimpl(j5) * floatValue, 0.0f, 0.0f, 0.0f, 14, null);
        if (!this.bounded) {
            DrawScope.m1690drawCircleVaOC9Bg$default(drawScope, m1485copywmQWz5c$default, lerp, Offset, 0.0f, null, null, 0, 120, null);
            return;
        }
        float m1377getWidthimpl = Size.m1377getWidthimpl(drawScope.mo1703getSizeNHjbRc());
        float m1375getHeightimpl = Size.m1375getHeightimpl(drawScope.mo1703getSizeNHjbRc());
        int m1480getIntersectrtfAjoo = ClipOp.INSTANCE.m1480getIntersectrtfAjoo();
        DrawContext drawContext = drawScope.getDrawContext();
        long mo1682getSizeNHjbRc = drawContext.mo1682getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().mo1685clipRectN_I0leg(0.0f, 0.0f, m1377getWidthimpl, m1375getHeightimpl, m1480getIntersectrtfAjoo);
            DrawScope.m1690drawCircleVaOC9Bg$default(drawScope, m1485copywmQWz5c$default, lerp, Offset, 0.0f, null, null, 0, 120, null);
        } finally {
            drawContext.getCanvas().restore();
            drawContext.mo1683setSizeuvyYCjk(mo1682getSizeNHjbRc);
        }
    }

    public final void finish() {
        setFinishRequested(true);
        this.finishSignalDeferred.complete(Unit.INSTANCE);
    }

    private RippleAnimation(Offset offset, float f5, boolean z5) {
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        this.origin = offset;
        this.radius = f5;
        this.bounded = z5;
        this.animatedAlpha = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
        this.animatedRadiusPercent = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
        this.animatedCenterPercent = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
        this.finishSignalDeferred = CompletableDeferredKt.CompletableDeferred(null);
        Boolean bool = Boolean.FALSE;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.finishedFadingIn = mutableStateOf$default;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.finishRequested = mutableStateOf$default2;
    }
}
