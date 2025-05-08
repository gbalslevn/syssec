package dk.molslinjen.domain.managers.route;

import dk.molslinjen.domain.model.booking.TransportationCargoInfo;
import dk.molslinjen.domain.model.settings.ISettings;
import dk.molslinjen.domain.model.settings.SettingsProperty;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.route.RouteManager$transportationListener$1", f = "RouteManager.kt", l = {478}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class RouteManager$transportationListener$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ RouteManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "Ldk/molslinjen/domain/model/booking/TransportationCargoInfo;", "it", "Ldk/molslinjen/domain/managers/route/RouteSelectedState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.domain.managers.route.RouteManager$transportationListener$1$1", f = "RouteManager.kt", l = {}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.domain.managers.route.RouteManager$transportationListener$1$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<RouteSelectedState, Continuation<? super TransportationCargoInfo>, Object> {
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(RouteSelectedState routeSelectedState, Continuation<? super TransportationCargoInfo> continuation) {
            return ((AnonymousClass1) create(routeSelectedState, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            RouteSelectedState routeSelectedState = (RouteSelectedState) this.L$0;
            if (routeSelectedState != null) {
                return routeSelectedState.getTransportationCargoInfo();
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: dk.molslinjen.domain.managers.route.RouteManager$transportationListener$1$4, reason: invalid class name */
    /* loaded from: classes2.dex */
    public /* synthetic */ class AnonymousClass4 extends AdaptedFunctionReference implements Function4<String, TransportationCargoInfo, TransportationCargoInfo, Continuation<? super Triple<? extends String, ? extends TransportationCargoInfo, ? extends TransportationCargoInfo>>, Object> {
        public static final AnonymousClass4 INSTANCE = new AnonymousClass4();

        AnonymousClass4() {
            super(4, Triple.class, "<init>", "<init>(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", 4);
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Object invoke(String str, TransportationCargoInfo transportationCargoInfo, TransportationCargoInfo transportationCargoInfo2, Continuation<? super Triple<? extends String, ? extends TransportationCargoInfo, ? extends TransportationCargoInfo>> continuation) {
            return invoke2(str, transportationCargoInfo, transportationCargoInfo2, (Continuation<? super Triple<String, TransportationCargoInfo, TransportationCargoInfo>>) continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(String str, TransportationCargoInfo transportationCargoInfo, TransportationCargoInfo transportationCargoInfo2, Continuation<? super Triple<String, TransportationCargoInfo, TransportationCargoInfo>> continuation) {
            return RouteManager$transportationListener$1.invokeSuspend$lambda$0(str, transportationCargoInfo, transportationCargoInfo2, continuation);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u001e\u0010\u0002\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "<destruct>", "Lkotlin/Triple;", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/TransportationCargoInfo;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.domain.managers.route.RouteManager$transportationListener$1$5", f = "RouteManager.kt", l = {479}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.domain.managers.route.RouteManager$transportationListener$1$5, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass5 extends SuspendLambda implements Function2<Triple<? extends String, ? extends TransportationCargoInfo, ? extends TransportationCargoInfo>, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ RouteManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(RouteManager routeManager, Continuation<? super AnonymousClass5> continuation) {
            super(2, continuation);
            this.this$0 = routeManager;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass5 anonymousClass5 = new AnonymousClass5(this.this$0, continuation);
            anonymousClass5.L$0 = obj;
            return anonymousClass5;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Triple<? extends String, ? extends TransportationCargoInfo, ? extends TransportationCargoInfo> triple, Continuation<? super Unit> continuation) {
            return invoke2((Triple<String, TransportationCargoInfo, TransportationCargoInfo>) triple, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            String resolveTransportationId;
            Object transportationInternal;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 == 0) {
                ResultKt.throwOnFailure(obj);
                Triple triple = (Triple) this.L$0;
                String str = (String) triple.component1();
                TransportationCargoInfo transportationCargoInfo = (TransportationCargoInfo) triple.component2();
                TransportationCargoInfo transportationCargoInfo2 = (TransportationCargoInfo) triple.component3();
                RouteManager routeManager = this.this$0;
                resolveTransportationId = routeManager.resolveTransportationId(str);
                this.label = 1;
                transportationInternal = routeManager.setTransportationInternal(resolveTransportationId, transportationCargoInfo, transportationCargoInfo2, this);
                if (transportationInternal == coroutine_suspended) {
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

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Triple<String, TransportationCargoInfo, TransportationCargoInfo> triple, Continuation<? super Unit> continuation) {
            return ((AnonymousClass5) create(triple, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RouteManager$transportationListener$1(RouteManager routeManager, Continuation<? super RouteManager$transportationListener$1> continuation) {
        super(2, continuation);
        this.this$0 = routeManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ Object invokeSuspend$lambda$0(String str, TransportationCargoInfo transportationCargoInfo, TransportationCargoInfo transportationCargoInfo2, Continuation continuation) {
        return new Triple(str, transportationCargoInfo, transportationCargoInfo2);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RouteManager$transportationListener$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ISettings iSettings;
        ISettings iSettings2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            iSettings = this.this$0.settings;
            Flow flow = iSettings.getFlow(SettingsProperty.Departures.CurrentTransportationId.INSTANCE);
            iSettings2 = this.this$0.settings;
            Flow distinctUntilChanged = FlowKt.distinctUntilChanged(FlowKt.combine(flow, iSettings2.getFlow(SettingsProperty.Departures.CurrentTransportationInfo.INSTANCE), FlowKt.mapLatest(this.this$0.getReturnSelectedState(), new AnonymousClass1(null)), AnonymousClass4.INSTANCE));
            AnonymousClass5 anonymousClass5 = new AnonymousClass5(this.this$0, null);
            this.label = 1;
            if (FlowKt.collectLatest(distinctUntilChanged, anonymousClass5, this) == coroutine_suspended) {
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
        return ((RouteManager$transportationListener$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
