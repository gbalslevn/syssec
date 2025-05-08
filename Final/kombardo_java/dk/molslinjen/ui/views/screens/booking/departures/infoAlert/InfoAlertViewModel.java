package dk.molslinjen.ui.views.screens.booking.departures.infoAlert;

import androidx.appcompat.R$styleable;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import dk.molslinjen.domain.managers.infoAlerts.IInfoAlertManager;
import dk.molslinjen.domain.managers.infoAlerts.InfoAlertManager;
import dk.molslinjen.domain.managers.route.IRouteManager;
import dk.molslinjen.domain.managers.route.RouteSharedSelectedState;
import dk.molslinjen.domain.model.config.Route;
import dk.molslinjen.domain.model.info.InfoAlert;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0016B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002J\u000e\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0017"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/departures/infoAlert/InfoAlertViewModel;", "Landroidx/lifecycle/ViewModel;", "routeManager", "Ldk/molslinjen/domain/managers/route/IRouteManager;", "infoAlertManager", "Ldk/molslinjen/domain/managers/infoAlerts/IInfoAlertManager;", "<init>", "(Ldk/molslinjen/domain/managers/route/IRouteManager;Ldk/molslinjen/domain/managers/infoAlerts/IInfoAlertManager;)V", "_viewState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/ui/views/screens/booking/departures/infoAlert/InfoAlertViewModel$ViewState;", "viewState", "Lkotlinx/coroutines/flow/StateFlow;", "getViewState", "()Lkotlinx/coroutines/flow/StateFlow;", "updateInfoAlertsToShow", BuildConfig.FLAVOR, "infoAlerts", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/info/InfoAlert;", "setAsShown", "infoAlert", "ViewState", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class InfoAlertViewModel extends ViewModel {
    private final MutableStateFlow<ViewState> _viewState;
    private final IInfoAlertManager infoAlertManager;
    private final IRouteManager routeManager;
    private final StateFlow<ViewState> viewState;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.departures.infoAlert.InfoAlertViewModel$1", f = "InfoAlertViewModel.kt", l = {R$styleable.Toolbar_titleMarginEnd}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.ui.views.screens.booking.departures.infoAlert.InfoAlertViewModel$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "it", "Ldk/molslinjen/domain/managers/infoAlerts/InfoAlertManager$InfoAlertsState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.departures.infoAlert.InfoAlertViewModel$1$1", f = "InfoAlertViewModel.kt", l = {}, m = "invokeSuspend")
        /* renamed from: dk.molslinjen.ui.views.screens.booking.departures.infoAlert.InfoAlertViewModel$1$1, reason: invalid class name and collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C00531 extends SuspendLambda implements Function2<InfoAlertManager.InfoAlertsState, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ InfoAlertViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00531(InfoAlertViewModel infoAlertViewModel, Continuation<? super C00531> continuation) {
                super(2, continuation);
                this.this$0 = infoAlertViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C00531 c00531 = new C00531(this.this$0, continuation);
                c00531.L$0 = obj;
                return c00531;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(InfoAlertManager.InfoAlertsState infoAlertsState, Continuation<? super Unit> continuation) {
                return ((C00531) create(infoAlertsState, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                InfoAlertManager.InfoAlertsState infoAlertsState = (InfoAlertManager.InfoAlertsState) this.L$0;
                InfoAlertViewModel infoAlertViewModel = this.this$0;
                List<InfoAlert> infoAlerts = infoAlertsState.getInfoAlerts();
                ArrayList arrayList = new ArrayList();
                for (Object obj2 : infoAlerts) {
                    if (!((InfoAlert) obj2).getShown()) {
                        arrayList.add(obj2);
                    }
                }
                infoAlertViewModel.updateInfoAlertsToShow(arrayList);
                return Unit.INSTANCE;
            }
        }

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 == 0) {
                ResultKt.throwOnFailure(obj);
                StateFlow<InfoAlertManager.InfoAlertsState> infoAlertsState = InfoAlertViewModel.this.infoAlertManager.getInfoAlertsState();
                C00531 c00531 = new C00531(InfoAlertViewModel.this, null);
                this.label = 1;
                if (FlowKt.collectLatest(infoAlertsState, c00531, this) == coroutine_suspended) {
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
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.departures.infoAlert.InfoAlertViewModel$2", f = "InfoAlertViewModel.kt", l = {30}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.ui.views.screens.booking.departures.infoAlert.InfoAlertViewModel$2, reason: invalid class name */
    /* loaded from: classes2.dex */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "route", "Ldk/molslinjen/domain/model/config/Route;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.departures.infoAlert.InfoAlertViewModel$2$2", f = "InfoAlertViewModel.kt", l = {}, m = "invokeSuspend")
        /* renamed from: dk.molslinjen.ui.views.screens.booking.departures.infoAlert.InfoAlertViewModel$2$2, reason: invalid class name and collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C00542 extends SuspendLambda implements Function2<Route, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ InfoAlertViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00542(InfoAlertViewModel infoAlertViewModel, Continuation<? super C00542> continuation) {
                super(2, continuation);
                this.this$0 = infoAlertViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C00542 c00542 = new C00542(this.this$0, continuation);
                c00542.L$0 = obj;
                return c00542;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Route route, Continuation<? super Unit> continuation) {
                return ((C00542) create(route, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                if (((Route) this.L$0) == null) {
                    return Unit.INSTANCE;
                }
                InfoAlertViewModel infoAlertViewModel = this.this$0;
                List<InfoAlert> infoAlerts = infoAlertViewModel.infoAlertManager.getInfoAlertsState().getValue().getInfoAlerts();
                ArrayList arrayList = new ArrayList();
                for (Object obj2 : infoAlerts) {
                    if (!((InfoAlert) obj2).getShown()) {
                        arrayList.add(obj2);
                    }
                }
                infoAlertViewModel.updateInfoAlertsToShow(arrayList);
                return Unit.INSTANCE;
            }
        }

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 == 0) {
                ResultKt.throwOnFailure(obj);
                final StateFlow<RouteSharedSelectedState> sharedSelectedState = InfoAlertViewModel.this.routeManager.getSharedSelectedState();
                Flow<Route> flow = new Flow<Route>() { // from class: dk.molslinjen.ui.views.screens.booking.departures.infoAlert.InfoAlertViewModel$2$invokeSuspend$$inlined$map$1

                    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "value", BuildConfig.FLAVOR, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {2, 1, 0})
                    /* renamed from: dk.molslinjen.ui.views.screens.booking.departures.infoAlert.InfoAlertViewModel$2$invokeSuspend$$inlined$map$1$2, reason: invalid class name */
                    /* loaded from: classes2.dex */
                    public static final class AnonymousClass2<T> implements FlowCollector {
                        final /* synthetic */ FlowCollector $this_unsafeFlow;

                        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
                        @DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.departures.infoAlert.InfoAlertViewModel$2$invokeSuspend$$inlined$map$1$2", f = "InfoAlertViewModel.kt", l = {223}, m = "emit")
                        /* renamed from: dk.molslinjen.ui.views.screens.booking.departures.infoAlert.InfoAlertViewModel$2$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
                        /* loaded from: classes2.dex */
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

                        public AnonymousClass2(FlowCollector flowCollector) {
                            this.$this_unsafeFlow = flowCollector;
                        }

                        /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
                        /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public final Object emit(Object obj, Continuation continuation) {
                            AnonymousClass1 anonymousClass1;
                            int i5;
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
                                        RouteSharedSelectedState routeSharedSelectedState = (RouteSharedSelectedState) obj;
                                        Route selectedRoute = routeSharedSelectedState != null ? routeSharedSelectedState.getSelectedRoute() : null;
                                        anonymousClass1.label = 1;
                                        if (flowCollector.emit(selectedRoute, anonymousClass1) == coroutine_suspended) {
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
                    public Object collect(FlowCollector<? super Route> flowCollector, Continuation continuation) {
                        Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
                    }
                };
                C00542 c00542 = new C00542(InfoAlertViewModel.this, null);
                this.label = 1;
                if (FlowKt.collectLatest(flow, c00542, this) == coroutine_suspended) {
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
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public InfoAlertViewModel(IRouteManager routeManager, IInfoAlertManager infoAlertManager) {
        Intrinsics.checkNotNullParameter(routeManager, "routeManager");
        Intrinsics.checkNotNullParameter(infoAlertManager, "infoAlertManager");
        this.routeManager = routeManager;
        this.infoAlertManager = infoAlertManager;
        MutableStateFlow<ViewState> MutableStateFlow = StateFlowKt.MutableStateFlow(new ViewState(null, 1, 0 == true ? 1 : 0));
        this._viewState = MutableStateFlow;
        this.viewState = MutableStateFlow;
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass2(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateInfoAlertsToShow(List<InfoAlert> infoAlerts) {
        ViewState value;
        ViewState value2;
        if (infoAlerts.isEmpty()) {
            MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
            do {
                value2 = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value2, value2.copy(CollectionsKt.emptyList())));
            return;
        }
        ArrayList arrayList = new ArrayList();
        RouteSharedSelectedState value3 = this.routeManager.getSharedSelectedState().getValue();
        Object obj = null;
        Route selectedRoute = value3 != null ? value3.getSelectedRoute() : null;
        List<InfoAlert> list = infoAlerts;
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (Intrinsics.areEqual(((InfoAlert) next).getVersion(), "100000362")) {
                obj = next;
                break;
            }
        }
        InfoAlert infoAlert = (InfoAlert) obj;
        if (infoAlert != null) {
            arrayList.add(infoAlert);
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : list) {
            InfoAlert infoAlert2 = (InfoAlert) obj2;
            if (selectedRoute != null && Intrinsics.areEqual(selectedRoute.getId(), infoAlert2.getRouteId())) {
                arrayList2.add(obj2);
            }
        }
        arrayList.addAll(arrayList2);
        ArrayList arrayList3 = new ArrayList();
        for (Object obj3 : list) {
            InfoAlert infoAlert3 = (InfoAlert) obj3;
            if (infoAlert3.getRouteId() == null && infoAlert3.getVersion() == null) {
                arrayList3.add(obj3);
            }
        }
        arrayList.addAll(arrayList3);
        MutableStateFlow<ViewState> mutableStateFlow2 = this._viewState;
        do {
            value = mutableStateFlow2.getValue();
        } while (!mutableStateFlow2.compareAndSet(value, value.copy(arrayList)));
    }

    public final StateFlow<ViewState> getViewState() {
        return this.viewState;
    }

    public final void setAsShown(InfoAlert infoAlert) {
        Intrinsics.checkNotNullParameter(infoAlert, "infoAlert");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new InfoAlertViewModel$setAsShown$1(this, infoAlert, null), 3, null);
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J \u0010\u0007\u001a\u00020\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/departures/infoAlert/InfoAlertViewModel$ViewState;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/info/InfoAlert;", "infoAlertToShow", "<init>", "(Ljava/util/List;)V", "copy", "(Ljava/util/List;)Ldk/molslinjen/ui/views/screens/booking/departures/infoAlert/InfoAlertViewModel$ViewState;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getInfoAlertToShow", "()Ljava/util/List;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ViewState {
        private final List<InfoAlert> infoAlertToShow;

        public ViewState(List<InfoAlert> infoAlertToShow) {
            Intrinsics.checkNotNullParameter(infoAlertToShow, "infoAlertToShow");
            this.infoAlertToShow = infoAlertToShow;
        }

        public final ViewState copy(List<InfoAlert> infoAlertToShow) {
            Intrinsics.checkNotNullParameter(infoAlertToShow, "infoAlertToShow");
            return new ViewState(infoAlertToShow);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ViewState) && Intrinsics.areEqual(this.infoAlertToShow, ((ViewState) other).infoAlertToShow);
        }

        public final List<InfoAlert> getInfoAlertToShow() {
            return this.infoAlertToShow;
        }

        public int hashCode() {
            return this.infoAlertToShow.hashCode();
        }

        public String toString() {
            return "ViewState(infoAlertToShow=" + this.infoAlertToShow + ")";
        }

        public /* synthetic */ ViewState(List list, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? CollectionsKt.emptyList() : list);
        }
    }
}
