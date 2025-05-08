package androidx.compose.material;

import androidx.compose.foundation.interaction.FocusInteraction$Focus;
import androidx.compose.foundation.interaction.FocusInteraction$Unfocus;
import androidx.compose.foundation.interaction.HoverInteraction$Enter;
import androidx.compose.foundation.interaction.HoverInteraction$Exit;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material.DefaultFloatingActionButtonElevation$elevation$2$1", f = "FloatingActionButton.kt", l = {293}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class DefaultFloatingActionButtonElevation$elevation$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FloatingActionButtonElevationAnimatable $animatable;
    final /* synthetic */ InteractionSource $interactionSource;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultFloatingActionButtonElevation$elevation$2$1(InteractionSource interactionSource, FloatingActionButtonElevationAnimatable floatingActionButtonElevationAnimatable, Continuation<? super DefaultFloatingActionButtonElevation$elevation$2$1> continuation) {
        super(2, continuation);
        this.$interactionSource = interactionSource;
        this.$animatable = floatingActionButtonElevationAnimatable;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DefaultFloatingActionButtonElevation$elevation$2$1 defaultFloatingActionButtonElevation$elevation$2$1 = new DefaultFloatingActionButtonElevation$elevation$2$1(this.$interactionSource, this.$animatable, continuation);
        defaultFloatingActionButtonElevation$elevation$2$1.L$0 = obj;
        return defaultFloatingActionButtonElevation$elevation$2$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            final CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            final ArrayList arrayList = new ArrayList();
            Flow<Interaction> interactions = this.$interactionSource.getInteractions();
            final FloatingActionButtonElevationAnimatable floatingActionButtonElevationAnimatable = this.$animatable;
            FlowCollector<? super Interaction> flowCollector = new FlowCollector() { // from class: androidx.compose.material.DefaultFloatingActionButtonElevation$elevation$2$1.1

                /* JADX INFO: Access modifiers changed from: package-private */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                @DebugMetadata(c = "androidx.compose.material.DefaultFloatingActionButtonElevation$elevation$2$1$1$1", f = "FloatingActionButton.kt", l = {319}, m = "invokeSuspend")
                /* renamed from: androidx.compose.material.DefaultFloatingActionButtonElevation$elevation$2$1$1$1, reason: invalid class name and collision with other inner class name */
                /* loaded from: classes.dex */
                public static final class C00171 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ FloatingActionButtonElevationAnimatable $animatable;
                    final /* synthetic */ Interaction $targetInteraction;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C00171(FloatingActionButtonElevationAnimatable floatingActionButtonElevationAnimatable, Interaction interaction, Continuation<? super C00171> continuation) {
                        super(2, continuation);
                        this.$animatable = floatingActionButtonElevationAnimatable;
                        this.$targetInteraction = interaction;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new C00171(this.$animatable, this.$targetInteraction, continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i5 = this.label;
                        if (i5 == 0) {
                            ResultKt.throwOnFailure(obj);
                            FloatingActionButtonElevationAnimatable floatingActionButtonElevationAnimatable = this.$animatable;
                            Interaction interaction = this.$targetInteraction;
                            this.label = 1;
                            if (floatingActionButtonElevationAnimatable.animateElevation(interaction, this) == coroutine_suspended) {
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
                        return ((C00171) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }
                }

                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit((Interaction) obj2, (Continuation<? super Unit>) continuation);
                }

                public final Object emit(Interaction interaction, Continuation<? super Unit> continuation) {
                    if (interaction instanceof HoverInteraction$Enter) {
                        arrayList.add(interaction);
                    } else if (interaction instanceof HoverInteraction$Exit) {
                        arrayList.remove(((HoverInteraction$Exit) interaction).getEnter());
                    } else if (interaction instanceof FocusInteraction$Focus) {
                        arrayList.add(interaction);
                    } else if (interaction instanceof FocusInteraction$Unfocus) {
                        arrayList.remove(((FocusInteraction$Unfocus) interaction).getFocus());
                    } else if (interaction instanceof PressInteraction.Press) {
                        arrayList.add(interaction);
                    } else if (interaction instanceof PressInteraction.Release) {
                        arrayList.remove(((PressInteraction.Release) interaction).getPress());
                    } else if (interaction instanceof PressInteraction.Cancel) {
                        arrayList.remove(((PressInteraction.Cancel) interaction).getPress());
                    }
                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C00171(floatingActionButtonElevationAnimatable, (Interaction) CollectionsKt.lastOrNull((List) arrayList), null), 3, null);
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
        return ((DefaultFloatingActionButtonElevation$elevation$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
