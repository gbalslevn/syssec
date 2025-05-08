package androidx.compose.material3.internal;

import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.ui.geometry.Offset;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0002R\u0016\u0010\u0003\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0006R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0011"}, d2 = {"Landroidx/compose/material3/internal/MappedInteractionSource;", "Landroidx/compose/foundation/interaction/InteractionSource;", "underlyingInteractionSource", "delta", "Landroidx/compose/ui/geometry/Offset;", "(Landroidx/compose/foundation/interaction/InteractionSource;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "interactions", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/compose/foundation/interaction/Interaction;", "getInteractions", "()Lkotlinx/coroutines/flow/Flow;", "mappedPresses", BuildConfig.FLAVOR, "Landroidx/compose/foundation/interaction/PressInteraction$Press;", "mapPress", "press", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MappedInteractionSource implements InteractionSource {
    private final long delta;
    private final Flow<Interaction> interactions;
    private final Map<PressInteraction.Press, PressInteraction.Press> mappedPresses;

    public /* synthetic */ MappedInteractionSource(InteractionSource interactionSource, long j5, DefaultConstructorMarker defaultConstructorMarker) {
        this(interactionSource, j5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PressInteraction.Press mapPress(PressInteraction.Press press) {
        return new PressInteraction.Press(Offset.m1341minusMKHz9U(press.getPressPosition(), this.delta), null);
    }

    @Override // androidx.compose.foundation.interaction.InteractionSource
    public Flow<Interaction> getInteractions() {
        return this.interactions;
    }

    private MappedInteractionSource(InteractionSource interactionSource, long j5) {
        this.delta = j5;
        this.mappedPresses = new LinkedHashMap();
        final Flow<Interaction> interactions = interactionSource.getInteractions();
        this.interactions = new Flow<Interaction>() { // from class: androidx.compose.material3.internal.MappedInteractionSource$special$$inlined$map$1

            @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "value", BuildConfig.FLAVOR, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
            /* renamed from: androidx.compose.material3.internal.MappedInteractionSource$special$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ MappedInteractionSource this$0;

                @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                @DebugMetadata(c = "androidx.compose.material3.internal.MappedInteractionSource$special$$inlined$map$1$2", f = "MappedInteractionSource.kt", l = {223}, m = "emit")
                /* renamed from: androidx.compose.material3.internal.MappedInteractionSource$special$$inlined$map$1$2$1, reason: invalid class name */
                /* loaded from: classes.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, MappedInteractionSource mappedInteractionSource) {
                    this.$this_unsafeFlow = flowCollector;
                    this.this$0 = mappedInteractionSource;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                /* JADX WARN: Type inference failed for: r2v13, types: [androidx.compose.foundation.interaction.PressInteraction$Press, java.lang.Object] */
                /* JADX WARN: Type inference failed for: r6v1, types: [androidx.compose.foundation.interaction.Interaction, java.lang.Object] */
                /* JADX WARN: Type inference failed for: r6v2, types: [androidx.compose.foundation.interaction.PressInteraction$Release] */
                /* JADX WARN: Type inference failed for: r6v3, types: [androidx.compose.foundation.interaction.PressInteraction$Release] */
                /* JADX WARN: Type inference failed for: r6v4, types: [androidx.compose.foundation.interaction.PressInteraction$Cancel] */
                /* JADX WARN: Type inference failed for: r6v5, types: [androidx.compose.foundation.interaction.PressInteraction$Cancel] */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    int i5;
                    Map map;
                    Map map2;
                    T t5;
                    ?? mapPress;
                    Map map3;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        int i6 = anonymousClass1.label;
                        if ((i6 & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label = i6 - Integer.MIN_VALUE;
                            Object obj2 = anonymousClass1.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            i5 = anonymousClass1.label;
                            if (i5 != 0) {
                                ResultKt.throwOnFailure(obj2);
                                FlowCollector flowCollector = this.$this_unsafeFlow;
                                ?? r6 = (Interaction) obj;
                                if (r6 instanceof PressInteraction.Press) {
                                    mapPress = this.this$0.mapPress((PressInteraction.Press) r6);
                                    map3 = this.this$0.mappedPresses;
                                    map3.put(r6, mapPress);
                                    t5 = mapPress;
                                } else if (r6 instanceof PressInteraction.Cancel) {
                                    map2 = this.this$0.mappedPresses;
                                    ?? r62 = (PressInteraction.Cancel) r6;
                                    PressInteraction.Press press = (PressInteraction.Press) map2.remove(r62.getPress());
                                    t5 = r62;
                                    if (press != null) {
                                        t5 = new PressInteraction.Cancel(press);
                                    }
                                } else {
                                    boolean z5 = r6 instanceof PressInteraction.Release;
                                    t5 = r6;
                                    if (z5) {
                                        map = this.this$0.mappedPresses;
                                        ?? r63 = (PressInteraction.Release) r6;
                                        PressInteraction.Press press2 = (PressInteraction.Press) map.remove(r63.getPress());
                                        t5 = r63;
                                        if (press2 != null) {
                                            t5 = new PressInteraction.Release(press2);
                                        }
                                    }
                                }
                                anonymousClass1.label = 1;
                                if (flowCollector.emit(t5, anonymousClass1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else {
                                if (i5 != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj2);
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    anonymousClass1 = new AnonymousClass1(continuation);
                    Object obj22 = anonymousClass1.result;
                    Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i5 = anonymousClass1.label;
                    if (i5 != 0) {
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super Interaction> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, this), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        };
    }
}
