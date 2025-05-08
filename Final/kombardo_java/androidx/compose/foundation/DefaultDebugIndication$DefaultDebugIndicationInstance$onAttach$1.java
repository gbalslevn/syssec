package androidx.compose.foundation;

import androidx.compose.foundation.DefaultDebugIndication;
import androidx.compose.foundation.interaction.FocusInteraction$Focus;
import androidx.compose.foundation.interaction.FocusInteraction$Unfocus;
import androidx.compose.foundation.interaction.HoverInteraction$Enter;
import androidx.compose.foundation.interaction.HoverInteraction$Exit;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.ui.node.DrawModifierNodeKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$IntRef;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.DefaultDebugIndication$DefaultDebugIndicationInstance$onAttach$1", f = "Indication.kt", l = {240}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class DefaultDebugIndication$DefaultDebugIndicationInstance$onAttach$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DefaultDebugIndication.DefaultDebugIndicationInstance this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultDebugIndication$DefaultDebugIndicationInstance$onAttach$1(DefaultDebugIndication.DefaultDebugIndicationInstance defaultDebugIndicationInstance, Continuation<? super DefaultDebugIndication$DefaultDebugIndicationInstance$onAttach$1> continuation) {
        super(2, continuation);
        this.this$0 = defaultDebugIndicationInstance;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DefaultDebugIndication$DefaultDebugIndicationInstance$onAttach$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        InteractionSource interactionSource;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            final Ref$IntRef ref$IntRef = new Ref$IntRef();
            final Ref$IntRef ref$IntRef2 = new Ref$IntRef();
            final Ref$IntRef ref$IntRef3 = new Ref$IntRef();
            interactionSource = this.this$0.interactionSource;
            Flow<Interaction> interactions = interactionSource.getInteractions();
            final DefaultDebugIndication.DefaultDebugIndicationInstance defaultDebugIndicationInstance = this.this$0;
            FlowCollector<? super Interaction> flowCollector = new FlowCollector() { // from class: androidx.compose.foundation.DefaultDebugIndication$DefaultDebugIndicationInstance$onAttach$1.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit((Interaction) obj2, (Continuation<? super Unit>) continuation);
                }

                public final Object emit(Interaction interaction, Continuation<? super Unit> continuation) {
                    boolean z5;
                    boolean z6;
                    boolean z7;
                    boolean z8 = true;
                    if (interaction instanceof PressInteraction.Press) {
                        Ref$IntRef.this.element++;
                    } else if (interaction instanceof PressInteraction.Release) {
                        Ref$IntRef ref$IntRef4 = Ref$IntRef.this;
                        ref$IntRef4.element--;
                    } else if (interaction instanceof PressInteraction.Cancel) {
                        Ref$IntRef ref$IntRef5 = Ref$IntRef.this;
                        ref$IntRef5.element--;
                    } else if (interaction instanceof HoverInteraction$Enter) {
                        ref$IntRef2.element++;
                    } else if (interaction instanceof HoverInteraction$Exit) {
                        Ref$IntRef ref$IntRef6 = ref$IntRef2;
                        ref$IntRef6.element--;
                    } else if (interaction instanceof FocusInteraction$Focus) {
                        ref$IntRef3.element++;
                    } else if (interaction instanceof FocusInteraction$Unfocus) {
                        Ref$IntRef ref$IntRef7 = ref$IntRef3;
                        ref$IntRef7.element--;
                    }
                    boolean z9 = false;
                    boolean z10 = Ref$IntRef.this.element > 0;
                    boolean z11 = ref$IntRef2.element > 0;
                    boolean z12 = ref$IntRef3.element > 0;
                    z5 = defaultDebugIndicationInstance.isPressed;
                    if (z5 != z10) {
                        defaultDebugIndicationInstance.isPressed = z10;
                        z9 = true;
                    }
                    z6 = defaultDebugIndicationInstance.isHovered;
                    if (z6 != z11) {
                        defaultDebugIndicationInstance.isHovered = z11;
                        z9 = true;
                    }
                    z7 = defaultDebugIndicationInstance.isFocused;
                    if (z7 != z12) {
                        defaultDebugIndicationInstance.isFocused = z12;
                    } else {
                        z8 = z9;
                    }
                    if (z8) {
                        DrawModifierNodeKt.invalidateDraw(defaultDebugIndicationInstance);
                    }
                    return Unit.INSTANCE;
                }
            };
            this.label = 1;
            if (interactions.collect(flowCollector, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DefaultDebugIndication$DefaultDebugIndicationInstance$onAttach$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
