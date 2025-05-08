package dk.molslinjen.ui.views.reusable.modifiers;

import androidx.appcompat.R$styleable;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.TweenSpec;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.reusable.modifiers.AnimatedClickableKt$clickableWithScaleAnimation$1$1", f = "AnimatedClickable.kt", l = {R$styleable.Toolbar_titleMarginEnd, 26}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class AnimatedClickableKt$clickableWithScaleAnimation$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $animationDuration;
    final /* synthetic */ Function0<Unit> $onClick;
    final /* synthetic */ Animatable<Float, AnimationVector1D> $scale;
    final /* synthetic */ float $scaleDownTo;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnimatedClickableKt$clickableWithScaleAnimation$1$1(Animatable<Float, AnimationVector1D> animatable, float f5, int i5, Function0<Unit> function0, Continuation<? super AnimatedClickableKt$clickableWithScaleAnimation$1$1> continuation) {
        super(2, continuation);
        this.$scale = animatable;
        this.$scaleDownTo = f5;
        this.$animationDuration = i5;
        this.$onClick = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AnimatedClickableKt$clickableWithScaleAnimation$1$1(this.$scale, this.$scaleDownTo, this.$animationDuration, this.$onClick, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            Animatable<Float, AnimationVector1D> animatable = this.$scale;
            Float boxFloat = Boxing.boxFloat(this.$scaleDownTo);
            TweenSpec tween$default = AnimationSpecKt.tween$default(this.$animationDuration, 0, null, 6, null);
            this.label = 1;
            if (Animatable.animateTo$default(animatable, boxFloat, tween$default, null, null, this, 12, null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                if (i5 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        }
        this.$onClick.invoke();
        Animatable<Float, AnimationVector1D> animatable2 = this.$scale;
        Float boxFloat2 = Boxing.boxFloat(1.0f);
        TweenSpec tween$default2 = AnimationSpecKt.tween$default(this.$animationDuration, 0, null, 6, null);
        this.label = 2;
        if (Animatable.animateTo$default(animatable2, boxFloat2, tween$default2, null, null, this, 12, null) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AnimatedClickableKt$clickableWithScaleAnimation$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
