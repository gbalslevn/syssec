package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.interaction.FocusInteraction$Focus;
import androidx.compose.foundation.interaction.HoverInteraction$Enter;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.material3.internal.ElevationKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.ButtonElevation$animateElevation$2$1", f = "Button.kt", l = {989, 998}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class ButtonElevation$animateElevation$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Animatable<Dp, AnimationVector1D> $animatable;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ Interaction $interaction;
    final /* synthetic */ float $target;
    int label;
    final /* synthetic */ ButtonElevation this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ButtonElevation$animateElevation$2$1(Animatable<Dp, AnimationVector1D> animatable, float f5, boolean z5, ButtonElevation buttonElevation, Interaction interaction, Continuation<? super ButtonElevation$animateElevation$2$1> continuation) {
        super(2, continuation);
        this.$animatable = animatable;
        this.$target = f5;
        this.$enabled = z5;
        this.this$0 = buttonElevation;
        this.$interaction = interaction;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ButtonElevation$animateElevation$2$1(this.$animatable, this.$target, this.$enabled, this.this$0, this.$interaction, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        float f5;
        float f6;
        float f7;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            if (!Dp.m2601equalsimpl0(this.$animatable.getTargetValue().getValue(), this.$target)) {
                if (this.$enabled) {
                    float value = this.$animatable.getTargetValue().getValue();
                    f5 = this.this$0.pressedElevation;
                    Interaction interaction = null;
                    if (Dp.m2601equalsimpl0(value, f5)) {
                        interaction = new PressInteraction.Press(Offset.INSTANCE.m1349getZeroF1C5BW0(), null);
                    } else {
                        f6 = this.this$0.hoveredElevation;
                        if (Dp.m2601equalsimpl0(value, f6)) {
                            interaction = new HoverInteraction$Enter();
                        } else {
                            f7 = this.this$0.focusedElevation;
                            if (Dp.m2601equalsimpl0(value, f7)) {
                                interaction = new FocusInteraction$Focus();
                            }
                        }
                    }
                    Animatable<Dp, AnimationVector1D> animatable = this.$animatable;
                    float f8 = this.$target;
                    Interaction interaction2 = this.$interaction;
                    this.label = 2;
                    if (ElevationKt.m993animateElevationrAjV9yQ(animatable, f8, interaction, interaction2, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    Animatable<Dp, AnimationVector1D> animatable2 = this.$animatable;
                    Dp m2597boximpl = Dp.m2597boximpl(this.$target);
                    this.label = 1;
                    if (animatable2.snapTo(m2597boximpl, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
        } else {
            if (i5 != 1 && i5 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ButtonElevation$animateElevation$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
