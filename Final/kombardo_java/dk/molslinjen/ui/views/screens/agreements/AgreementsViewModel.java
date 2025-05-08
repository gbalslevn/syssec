package dk.molslinjen.ui.views.screens.agreements;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import dk.molslinjen.domain.extensions.CommuterDataStateExtensionsKt;
import dk.molslinjen.domain.managers.agreement.commuter.CommuterDataState;
import dk.molslinjen.domain.managers.agreement.commuter.bornholm.IBornholmCommuterManager;
import dk.molslinjen.domain.managers.agreement.commuter.oeresund.IOeresundCommuterManager;
import dk.molslinjen.domain.managers.agreement.multiride.IMultiRideManager;
import dk.molslinjen.domain.managers.route.IRouteManager;
import dk.molslinjen.domain.model.agreement.commuter.bornholm.BornholmCommuterAgreement;
import dk.molslinjen.domain.model.agreement.commuter.oeresund.OeresundCommuterAgreement;
import dk.molslinjen.domain.model.agreement.multiRide.MultiRideCard;
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
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001 B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J\u001c\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00130\u001aJ\u001c\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001d2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00130\u001aJ\u000e\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006!"}, d2 = {"Ldk/molslinjen/ui/views/screens/agreements/AgreementsViewModel;", "Landroidx/lifecycle/ViewModel;", "routeManager", "Ldk/molslinjen/domain/managers/route/IRouteManager;", "bornholmCommuterManager", "Ldk/molslinjen/domain/managers/agreement/commuter/bornholm/IBornholmCommuterManager;", "oeresundCommuterManager", "Ldk/molslinjen/domain/managers/agreement/commuter/oeresund/IOeresundCommuterManager;", "multiRideManager", "Ldk/molslinjen/domain/managers/agreement/multiride/IMultiRideManager;", "<init>", "(Ldk/molslinjen/domain/managers/route/IRouteManager;Ldk/molslinjen/domain/managers/agreement/commuter/bornholm/IBornholmCommuterManager;Ldk/molslinjen/domain/managers/agreement/commuter/oeresund/IOeresundCommuterManager;Ldk/molslinjen/domain/managers/agreement/multiride/IMultiRideManager;)V", "_viewState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/ui/views/screens/agreements/AgreementsViewModel$ViewState;", "viewState", "getViewState", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "forceSelectedTab", BuildConfig.FLAVOR, "newTab", "Ldk/molslinjen/ui/views/screens/agreements/AgreementTab;", "startMultiRideBooking", "multiRideCard", "Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideCard;", "proceed", "Lkotlin/Function0;", "startCommuterBooking", "bornholmCommuterAgreement", "Ldk/molslinjen/domain/model/agreement/commuter/bornholm/BornholmCommuterAgreement;", "updateSelectedTab", "tab", "ViewState", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AgreementsViewModel extends ViewModel {
    private final MutableStateFlow<ViewState> _viewState;
    private final IBornholmCommuterManager bornholmCommuterManager;
    private final IMultiRideManager multiRideManager;
    private final IOeresundCommuterManager oeresundCommuterManager;
    private final IRouteManager routeManager;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.ui.views.screens.agreements.AgreementsViewModel$1", f = "AgreementsViewModel.kt", l = {50}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.ui.views.screens.agreements.AgreementsViewModel$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\n"}, d2 = {"<anonymous>", "Ldk/molslinjen/ui/views/screens/agreements/AgreementTab;", "bornholmState", "Ldk/molslinjen/domain/managers/agreement/commuter/bornholm/IBornholmCommuterManager$State;", "oeresundState", "Ldk/molslinjen/domain/managers/agreement/commuter/CommuterDataState;", "Ldk/molslinjen/domain/model/agreement/commuter/oeresund/OeresundCommuterAgreement;", "multiRideState", "Ldk/molslinjen/domain/managers/agreement/multiride/IMultiRideManager$MultiRideManagerState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "dk.molslinjen.ui.views.screens.agreements.AgreementsViewModel$1$1", f = "AgreementsViewModel.kt", l = {}, m = "invokeSuspend")
        /* renamed from: dk.molslinjen.ui.views.screens.agreements.AgreementsViewModel$1$1, reason: invalid class name and collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C00491 extends SuspendLambda implements Function4<IBornholmCommuterManager.State, CommuterDataState<? extends OeresundCommuterAgreement>, IMultiRideManager.MultiRideManagerState, Continuation<? super AgreementTab>, Object> {
            /* synthetic */ Object L$0;
            /* synthetic */ Object L$1;
            /* synthetic */ Object L$2;
            int label;

            C00491(Continuation<? super C00491> continuation) {
                super(4, continuation);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(IBornholmCommuterManager.State state, CommuterDataState<OeresundCommuterAgreement> commuterDataState, IMultiRideManager.MultiRideManagerState multiRideManagerState, Continuation<? super AgreementTab> continuation) {
                C00491 c00491 = new C00491(continuation);
                c00491.L$0 = state;
                c00491.L$1 = commuterDataState;
                c00491.L$2 = multiRideManagerState;
                return c00491.invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                IBornholmCommuterManager.State state = (IBornholmCommuterManager.State) this.L$0;
                CommuterDataState commuterDataState = (CommuterDataState) this.L$1;
                if (Intrinsics.areEqual(((IMultiRideManager.MultiRideManagerState) this.L$2).getHasLocalData(), Boxing.boxBoolean(true))) {
                    return AgreementTab.MultiRide;
                }
                if (Intrinsics.areEqual(state.getHasLocalData(), Boxing.boxBoolean(true)) || CommuterDataStateExtensionsKt.hasData(commuterDataState)) {
                    return AgreementTab.Commuter;
                }
                return null;
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Object invoke(IBornholmCommuterManager.State state, CommuterDataState<? extends OeresundCommuterAgreement> commuterDataState, IMultiRideManager.MultiRideManagerState multiRideManagerState, Continuation<? super AgreementTab> continuation) {
                return invoke2(state, (CommuterDataState<OeresundCommuterAgreement>) commuterDataState, multiRideManagerState, continuation);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "tab", "Ldk/molslinjen/ui/views/screens/agreements/AgreementTab;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "dk.molslinjen.ui.views.screens.agreements.AgreementsViewModel$1$2", f = "AgreementsViewModel.kt", l = {}, m = "invokeSuspend")
        /* renamed from: dk.molslinjen.ui.views.screens.agreements.AgreementsViewModel$1$2, reason: invalid class name */
        /* loaded from: classes2.dex */
        public static final class AnonymousClass2 extends SuspendLambda implements Function2<AgreementTab, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ AgreementsViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(AgreementsViewModel agreementsViewModel, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.this$0 = agreementsViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.this$0, continuation);
                anonymousClass2.L$0 = obj;
                return anonymousClass2;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(AgreementTab agreementTab, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(agreementTab, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.this$0.forceSelectedTab((AgreementTab) this.L$0);
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
                Flow combine = FlowKt.combine(AgreementsViewModel.this.bornholmCommuterManager.getState(), AgreementsViewModel.this.oeresundCommuterManager.getState(), AgreementsViewModel.this.multiRideManager.getState(), new C00491(null));
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(AgreementsViewModel.this, null);
                this.label = 1;
                if (FlowKt.collectLatest(combine, anonymousClass2, this) == coroutine_suspended) {
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
    @DebugMetadata(c = "dk.molslinjen.ui.views.screens.agreements.AgreementsViewModel$2", f = "AgreementsViewModel.kt", l = {56}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.ui.views.screens.agreements.AgreementsViewModel$2, reason: invalid class name */
    /* loaded from: classes2.dex */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

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
                Duration.Companion companion = Duration.INSTANCE;
                long duration = DurationKt.toDuration(1, DurationUnit.SECONDS);
                this.label = 1;
                if (DelayKt.m3760delayVtjQ1oo(duration, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i5 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            AgreementsViewModel.this.forceSelectedTab(AgreementTab.MultiRide);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AgreementsViewModel(IRouteManager routeManager, IBornholmCommuterManager bornholmCommuterManager, IOeresundCommuterManager oeresundCommuterManager, IMultiRideManager multiRideManager) {
        Intrinsics.checkNotNullParameter(routeManager, "routeManager");
        Intrinsics.checkNotNullParameter(bornholmCommuterManager, "bornholmCommuterManager");
        Intrinsics.checkNotNullParameter(oeresundCommuterManager, "oeresundCommuterManager");
        Intrinsics.checkNotNullParameter(multiRideManager, "multiRideManager");
        this.routeManager = routeManager;
        this.bornholmCommuterManager = bornholmCommuterManager;
        this.oeresundCommuterManager = oeresundCommuterManager;
        this.multiRideManager = multiRideManager;
        this._viewState = StateFlowKt.MutableStateFlow(new ViewState(null, 1, 0 == true ? 1 : 0));
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass2(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void forceSelectedTab(AgreementTab newTab) {
        ViewState value;
        if (getViewState().getValue().getSelectedTab() != null || newTab == null) {
            return;
        }
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, value.copy(newTab)));
    }

    public final MutableStateFlow<ViewState> getViewState() {
        return this._viewState;
    }

    public final void startCommuterBooking(BornholmCommuterAgreement bornholmCommuterAgreement, Function0<Unit> proceed) {
        Intrinsics.checkNotNullParameter(bornholmCommuterAgreement, "bornholmCommuterAgreement");
        Intrinsics.checkNotNullParameter(proceed, "proceed");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AgreementsViewModel$startCommuterBooking$1(this, bornholmCommuterAgreement, proceed, null), 3, null);
    }

    public final void startMultiRideBooking(MultiRideCard multiRideCard, Function0<Unit> proceed) {
        Intrinsics.checkNotNullParameter(multiRideCard, "multiRideCard");
        Intrinsics.checkNotNullParameter(proceed, "proceed");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AgreementsViewModel$startMultiRideBooking$1(this, multiRideCard, proceed, null), 3, null);
    }

    public final void updateSelectedTab(AgreementTab tab) {
        ViewState value;
        Intrinsics.checkNotNullParameter(tab, "tab");
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, value.copy(tab)));
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Ldk/molslinjen/ui/views/screens/agreements/AgreementsViewModel$ViewState;", BuildConfig.FLAVOR, "Ldk/molslinjen/ui/views/screens/agreements/AgreementTab;", "selectedTab", "<init>", "(Ldk/molslinjen/ui/views/screens/agreements/AgreementTab;)V", "copy", "(Ldk/molslinjen/ui/views/screens/agreements/AgreementTab;)Ldk/molslinjen/ui/views/screens/agreements/AgreementsViewModel$ViewState;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ldk/molslinjen/ui/views/screens/agreements/AgreementTab;", "getSelectedTab", "()Ldk/molslinjen/ui/views/screens/agreements/AgreementTab;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ViewState {
        private final AgreementTab selectedTab;

        public ViewState(AgreementTab agreementTab) {
            this.selectedTab = agreementTab;
        }

        public final ViewState copy(AgreementTab selectedTab) {
            return new ViewState(selectedTab);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ViewState) && this.selectedTab == ((ViewState) other).selectedTab;
        }

        public final AgreementTab getSelectedTab() {
            return this.selectedTab;
        }

        public int hashCode() {
            AgreementTab agreementTab = this.selectedTab;
            if (agreementTab == null) {
                return 0;
            }
            return agreementTab.hashCode();
        }

        public String toString() {
            return "ViewState(selectedTab=" + this.selectedTab + ")";
        }

        public /* synthetic */ ViewState(AgreementTab agreementTab, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? null : agreementTab);
        }
    }
}
