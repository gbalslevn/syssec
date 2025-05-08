package dk.molslinjen.ui.views.screens.agreements.multiride.details;

import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.ramcosta.composedestinations.generated.destinations.MultiRideDetailsScreenDestination;
import com.sun.jna.Function;
import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.domain.managers.agreement.multiride.IMultiRideManager;
import dk.molslinjen.domain.managers.agreement.multiride.MultiRideManager;
import dk.molslinjen.domain.managers.route.IRouteManager;
import dk.molslinjen.domain.model.account.UserVehicle;
import dk.molslinjen.domain.model.agreement.multiRide.MultiRideAssociatedVehicle;
import dk.molslinjen.domain.model.agreement.multiRide.MultiRideBookingTicket;
import dk.molslinjen.domain.model.agreement.multiRide.MultiRideCard;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.ui.views.screens.agreements.multiride.details.MultiRideDetailsViewModel;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
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

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001)B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u001a\u001a\u00020\u001bH\u0002J\u000e\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020 J\u0006\u0010!\u001a\u00020\u001bJ\u001c\u0010\"\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020$2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001b0&J\u000e\u0010'\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020 J\b\u0010(\u001a\u00020\u001bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\u0015\u001a\u00060\u0016j\u0002`\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006*"}, d2 = {"Ldk/molslinjen/ui/views/screens/agreements/multiride/details/MultiRideDetailsViewModel;", "Landroidx/lifecycle/ViewModel;", "multiRideManager", "Ldk/molslinjen/domain/managers/agreement/multiride/IMultiRideManager;", "routeManager", "Ldk/molslinjen/domain/managers/route/IRouteManager;", "snackbarService", "Ldk/molslinjen/core/snackbar/ISnackbarService;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "<init>", "(Ldk/molslinjen/domain/managers/agreement/multiride/IMultiRideManager;Ldk/molslinjen/domain/managers/route/IRouteManager;Ldk/molslinjen/core/snackbar/ISnackbarService;Landroidx/lifecycle/SavedStateHandle;)V", "navArgs", "Ldk/molslinjen/ui/views/screens/agreements/multiride/details/MultiRideDetailsScreenNavArgs;", "_viewState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/ui/views/screens/agreements/multiride/details/MultiRideDetailsViewModel$ViewState;", "viewState", "Lkotlinx/coroutines/flow/StateFlow;", "getViewState", "()Lkotlinx/coroutines/flow/StateFlow;", "multiRideId", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideCardNumber;", "getMultiRideId", "()Ljava/lang/String;", "loadVehicles", BuildConfig.FLAVOR, "associateVehicle", "vehicle", "Ldk/molslinjen/domain/model/account/UserVehicle;", "triggerRemoveVehicleFlow", "Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideAssociatedVehicle;", "cancelRemoveVehicleFlow", "startMultiRideBooking", "multiRideCard", "Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideCard;", "proceed", "Lkotlin/Function0;", "removeVehicleAssociation", "loadActiveTickets", "ViewState", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MultiRideDetailsViewModel extends ViewModel {
    private final MutableStateFlow<ViewState> _viewState;
    private final String multiRideId;
    private final IMultiRideManager multiRideManager;
    private final MultiRideDetailsScreenNavArgs navArgs;
    private final IRouteManager routeManager;
    private final ISnackbarService snackbarService;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.ui.views.screens.agreements.multiride.details.MultiRideDetailsViewModel$1", f = "MultiRideDetailsViewModel.kt", l = {47}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.ui.views.screens.agreements.multiride.details.MultiRideDetailsViewModel$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "it", "Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideCard;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "dk.molslinjen.ui.views.screens.agreements.multiride.details.MultiRideDetailsViewModel$1$2", f = "MultiRideDetailsViewModel.kt", l = {}, m = "invokeSuspend")
        /* renamed from: dk.molslinjen.ui.views.screens.agreements.multiride.details.MultiRideDetailsViewModel$1$2, reason: invalid class name */
        /* loaded from: classes2.dex */
        public static final class AnonymousClass2 extends SuspendLambda implements Function2<MultiRideCard, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ MultiRideDetailsViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(MultiRideDetailsViewModel multiRideDetailsViewModel, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.this$0 = multiRideDetailsViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(MultiRideCard multiRideCard, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(multiRideCard, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.this$0.loadActiveTickets();
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
                final StateFlow<ViewState> viewState = MultiRideDetailsViewModel.this.getViewState();
                Flow distinctUntilChanged = FlowKt.distinctUntilChanged(new Flow<MultiRideCard>() { // from class: dk.molslinjen.ui.views.screens.agreements.multiride.details.MultiRideDetailsViewModel$1$invokeSuspend$$inlined$map$1

                    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "value", BuildConfig.FLAVOR, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {2, 1, 0})
                    /* renamed from: dk.molslinjen.ui.views.screens.agreements.multiride.details.MultiRideDetailsViewModel$1$invokeSuspend$$inlined$map$1$2, reason: invalid class name */
                    /* loaded from: classes2.dex */
                    public static final class AnonymousClass2<T> implements FlowCollector {
                        final /* synthetic */ FlowCollector $this_unsafeFlow;

                        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
                        @DebugMetadata(c = "dk.molslinjen.ui.views.screens.agreements.multiride.details.MultiRideDetailsViewModel$1$invokeSuspend$$inlined$map$1$2", f = "MultiRideDetailsViewModel.kt", l = {223}, m = "emit")
                        /* renamed from: dk.molslinjen.ui.views.screens.agreements.multiride.details.MultiRideDetailsViewModel$1$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
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
                                        MultiRideCard multiRideCard = ((MultiRideDetailsViewModel.ViewState) obj).getMultiRideCard();
                                        anonymousClass1.label = 1;
                                        if (flowCollector.emit(multiRideCard, anonymousClass1) == coroutine_suspended) {
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
                    public Object collect(FlowCollector<? super MultiRideCard> flowCollector, Continuation continuation) {
                        Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
                    }
                });
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(MultiRideDetailsViewModel.this, null);
                this.label = 1;
                if (FlowKt.collectLatest(distinctUntilChanged, anonymousClass2, this) == coroutine_suspended) {
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
    @DebugMetadata(c = "dk.molslinjen.ui.views.screens.agreements.multiride.details.MultiRideDetailsViewModel$2", f = "MultiRideDetailsViewModel.kt", l = {53}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.ui.views.screens.agreements.multiride.details.MultiRideDetailsViewModel$2, reason: invalid class name */
    /* loaded from: classes2.dex */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "state", "Ldk/molslinjen/domain/managers/agreement/multiride/IMultiRideManager$MultiRideManagerState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "dk.molslinjen.ui.views.screens.agreements.multiride.details.MultiRideDetailsViewModel$2$1", f = "MultiRideDetailsViewModel.kt", l = {}, m = "invokeSuspend")
        /* renamed from: dk.molslinjen.ui.views.screens.agreements.multiride.details.MultiRideDetailsViewModel$2$1, reason: invalid class name */
        /* loaded from: classes2.dex */
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<IMultiRideManager.MultiRideManagerState, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ MultiRideDetailsViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(MultiRideDetailsViewModel multiRideDetailsViewModel, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = multiRideDetailsViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(IMultiRideManager.MultiRideManagerState multiRideManagerState, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(multiRideManagerState, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object value;
                ViewState viewState;
                Object obj2;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                IMultiRideManager.MultiRideManagerState multiRideManagerState = (IMultiRideManager.MultiRideManagerState) this.L$0;
                MutableStateFlow mutableStateFlow = this.this$0._viewState;
                MultiRideDetailsViewModel multiRideDetailsViewModel = this.this$0;
                do {
                    value = mutableStateFlow.getValue();
                    viewState = (ViewState) value;
                    Iterator<T> it = multiRideManagerState.getMultiRideCards().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj2 = null;
                            break;
                        }
                        obj2 = it.next();
                        if (Intrinsics.areEqual(((MultiRideCard) obj2).getId(), multiRideDetailsViewModel.getMultiRideId())) {
                            break;
                        }
                    }
                } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(viewState, null, (MultiRideCard) obj2, false, null, false, null, false, null, 253, null)));
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
                StateFlow<IMultiRideManager.MultiRideManagerState> state = MultiRideDetailsViewModel.this.multiRideManager.getState();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(MultiRideDetailsViewModel.this, null);
                this.label = 1;
                if (FlowKt.collectLatest(state, anonymousClass1, this) == coroutine_suspended) {
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

    public MultiRideDetailsViewModel(IMultiRideManager multiRideManager, IRouteManager routeManager, ISnackbarService snackbarService, SavedStateHandle savedStateHandle) {
        Intrinsics.checkNotNullParameter(multiRideManager, "multiRideManager");
        Intrinsics.checkNotNullParameter(routeManager, "routeManager");
        Intrinsics.checkNotNullParameter(snackbarService, "snackbarService");
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        this.multiRideManager = multiRideManager;
        this.routeManager = routeManager;
        this.snackbarService = snackbarService;
        MultiRideDetailsScreenNavArgs argsFrom = MultiRideDetailsScreenDestination.INSTANCE.argsFrom(savedStateHandle);
        this.navArgs = argsFrom;
        this._viewState = StateFlowKt.MutableStateFlow(new ViewState(null, null, false, null, false, null, false, null, Function.USE_VARARGS, null));
        this.multiRideId = argsFrom.getMultiRideCardNumber();
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass2(null), 3, null);
        loadVehicles();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadActiveTickets() {
        ViewState value;
        if (this.multiRideId == null) {
            return;
        }
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, null, null, false, null, false, null, true, null, 191, null)));
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new MultiRideDetailsViewModel$loadActiveTickets$2(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadVehicles() {
        ViewState value;
        String str = this.multiRideId;
        if (str == null) {
            return;
        }
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, null, null, true, null, false, null, false, null, 251, null)));
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new MultiRideDetailsViewModel$loadVehicles$2(this, str, null), 3, null);
    }

    public final void associateVehicle(UserVehicle vehicle) {
        Intrinsics.checkNotNullParameter(vehicle, "vehicle");
        String str = this.multiRideId;
        if (str == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new MultiRideDetailsViewModel$associateVehicle$1(this, str, vehicle, null), 3, null);
    }

    public final void cancelRemoveVehicleFlow() {
        ViewState value;
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, null, null, false, null, false, null, false, null, 223, null)));
    }

    public final String getMultiRideId() {
        return this.multiRideId;
    }

    public final StateFlow<ViewState> getViewState() {
        return this._viewState;
    }

    public final void removeVehicleAssociation(MultiRideAssociatedVehicle vehicle) {
        ViewState value;
        Intrinsics.checkNotNullParameter(vehicle, "vehicle");
        if (this.multiRideId == null) {
            return;
        }
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, null, null, false, null, true, null, false, null, 239, null)));
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new MultiRideDetailsViewModel$removeVehicleAssociation$2(this, vehicle, null), 3, null);
    }

    public final void startMultiRideBooking(MultiRideCard multiRideCard, Function0<Unit> proceed) {
        Intrinsics.checkNotNullParameter(multiRideCard, "multiRideCard");
        Intrinsics.checkNotNullParameter(proceed, "proceed");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new MultiRideDetailsViewModel$startMultiRideBooking$1(this, multiRideCard, proceed, null), 3, null);
    }

    public final void triggerRemoveVehicleFlow(MultiRideAssociatedVehicle vehicle) {
        ViewState value;
        Intrinsics.checkNotNullParameter(vehicle, "vehicle");
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, null, null, false, null, false, vehicle, false, null, 223, null)));
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0015\b\u0087\b\u0018\u00002\u00020\u0001Bk\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\b¢\u0006\u0004\b\u0010\u0010\u0011Jt\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\b\b\u0002\u0010\u000b\u001a\u00020\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\r\u001a\u00020\u00062\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001b\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010#\u001a\u0004\b\u0007\u0010$R\u001f\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\n\u0010%\u001a\u0004\b&\u0010'R\u0017\u0010\u000b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u000b\u0010#\u001a\u0004\b\u000b\u0010$R\u0019\u0010\f\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\f\u0010(\u001a\u0004\b)\u0010*R\u0017\u0010\r\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\r\u0010#\u001a\u0004\b\r\u0010$R\u001f\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\u000f\u0010%\u001a\u0004\b+\u0010'¨\u0006,"}, d2 = {"Ldk/molslinjen/ui/views/screens/agreements/multiride/details/MultiRideDetailsViewModel$ViewState;", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/config/Site;", "site", "Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideCard;", "multiRideCard", BuildConfig.FLAVOR, "isLoadingVehicles", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideAssociatedVehicle;", "associatedVehicles", "isRemoveVehicleLoading", "vehicleToRemove", "isLoadingTickets", "Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideBookingTicket;", "activeTickets", "<init>", "(Ldk/molslinjen/domain/model/config/Site;Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideCard;ZLjava/util/List;ZLdk/molslinjen/domain/model/agreement/multiRide/MultiRideAssociatedVehicle;ZLjava/util/List;)V", "copy", "(Ldk/molslinjen/domain/model/config/Site;Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideCard;ZLjava/util/List;ZLdk/molslinjen/domain/model/agreement/multiRide/MultiRideAssociatedVehicle;ZLjava/util/List;)Ldk/molslinjen/ui/views/screens/agreements/multiride/details/MultiRideDetailsViewModel$ViewState;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ldk/molslinjen/domain/model/config/Site;", "getSite", "()Ldk/molslinjen/domain/model/config/Site;", "Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideCard;", "getMultiRideCard", "()Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideCard;", "Z", "()Z", "Ljava/util/List;", "getAssociatedVehicles", "()Ljava/util/List;", "Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideAssociatedVehicle;", "getVehicleToRemove", "()Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideAssociatedVehicle;", "getActiveTickets", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ViewState {
        private final List<MultiRideBookingTicket> activeTickets;
        private final List<MultiRideAssociatedVehicle> associatedVehicles;
        private final boolean isLoadingTickets;
        private final boolean isLoadingVehicles;
        private final boolean isRemoveVehicleLoading;
        private final MultiRideCard multiRideCard;
        private final Site site;
        private final MultiRideAssociatedVehicle vehicleToRemove;

        public ViewState(Site site, MultiRideCard multiRideCard, boolean z5, List<MultiRideAssociatedVehicle> list, boolean z6, MultiRideAssociatedVehicle multiRideAssociatedVehicle, boolean z7, List<MultiRideBookingTicket> list2) {
            Intrinsics.checkNotNullParameter(site, "site");
            this.site = site;
            this.multiRideCard = multiRideCard;
            this.isLoadingVehicles = z5;
            this.associatedVehicles = list;
            this.isRemoveVehicleLoading = z6;
            this.vehicleToRemove = multiRideAssociatedVehicle;
            this.isLoadingTickets = z7;
            this.activeTickets = list2;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, Site site, MultiRideCard multiRideCard, boolean z5, List list, boolean z6, MultiRideAssociatedVehicle multiRideAssociatedVehicle, boolean z7, List list2, int i5, Object obj) {
            return viewState.copy((i5 & 1) != 0 ? viewState.site : site, (i5 & 2) != 0 ? viewState.multiRideCard : multiRideCard, (i5 & 4) != 0 ? viewState.isLoadingVehicles : z5, (i5 & 8) != 0 ? viewState.associatedVehicles : list, (i5 & 16) != 0 ? viewState.isRemoveVehicleLoading : z6, (i5 & 32) != 0 ? viewState.vehicleToRemove : multiRideAssociatedVehicle, (i5 & 64) != 0 ? viewState.isLoadingTickets : z7, (i5 & 128) != 0 ? viewState.activeTickets : list2);
        }

        public final ViewState copy(Site site, MultiRideCard multiRideCard, boolean isLoadingVehicles, List<MultiRideAssociatedVehicle> associatedVehicles, boolean isRemoveVehicleLoading, MultiRideAssociatedVehicle vehicleToRemove, boolean isLoadingTickets, List<MultiRideBookingTicket> activeTickets) {
            Intrinsics.checkNotNullParameter(site, "site");
            return new ViewState(site, multiRideCard, isLoadingVehicles, associatedVehicles, isRemoveVehicleLoading, vehicleToRemove, isLoadingTickets, activeTickets);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return this.site == viewState.site && Intrinsics.areEqual(this.multiRideCard, viewState.multiRideCard) && this.isLoadingVehicles == viewState.isLoadingVehicles && Intrinsics.areEqual(this.associatedVehicles, viewState.associatedVehicles) && this.isRemoveVehicleLoading == viewState.isRemoveVehicleLoading && Intrinsics.areEqual(this.vehicleToRemove, viewState.vehicleToRemove) && this.isLoadingTickets == viewState.isLoadingTickets && Intrinsics.areEqual(this.activeTickets, viewState.activeTickets);
        }

        public final List<MultiRideBookingTicket> getActiveTickets() {
            return this.activeTickets;
        }

        public final List<MultiRideAssociatedVehicle> getAssociatedVehicles() {
            return this.associatedVehicles;
        }

        public final MultiRideCard getMultiRideCard() {
            return this.multiRideCard;
        }

        public final Site getSite() {
            return this.site;
        }

        public final MultiRideAssociatedVehicle getVehicleToRemove() {
            return this.vehicleToRemove;
        }

        public int hashCode() {
            int hashCode = this.site.hashCode() * 31;
            MultiRideCard multiRideCard = this.multiRideCard;
            int hashCode2 = (((hashCode + (multiRideCard == null ? 0 : multiRideCard.hashCode())) * 31) + Boolean.hashCode(this.isLoadingVehicles)) * 31;
            List<MultiRideAssociatedVehicle> list = this.associatedVehicles;
            int hashCode3 = (((hashCode2 + (list == null ? 0 : list.hashCode())) * 31) + Boolean.hashCode(this.isRemoveVehicleLoading)) * 31;
            MultiRideAssociatedVehicle multiRideAssociatedVehicle = this.vehicleToRemove;
            int hashCode4 = (((hashCode3 + (multiRideAssociatedVehicle == null ? 0 : multiRideAssociatedVehicle.hashCode())) * 31) + Boolean.hashCode(this.isLoadingTickets)) * 31;
            List<MultiRideBookingTicket> list2 = this.activeTickets;
            return hashCode4 + (list2 != null ? list2.hashCode() : 0);
        }

        /* renamed from: isLoadingTickets, reason: from getter */
        public final boolean getIsLoadingTickets() {
            return this.isLoadingTickets;
        }

        /* renamed from: isLoadingVehicles, reason: from getter */
        public final boolean getIsLoadingVehicles() {
            return this.isLoadingVehicles;
        }

        /* renamed from: isRemoveVehicleLoading, reason: from getter */
        public final boolean getIsRemoveVehicleLoading() {
            return this.isRemoveVehicleLoading;
        }

        public String toString() {
            return "ViewState(site=" + this.site + ", multiRideCard=" + this.multiRideCard + ", isLoadingVehicles=" + this.isLoadingVehicles + ", associatedVehicles=" + this.associatedVehicles + ", isRemoveVehicleLoading=" + this.isRemoveVehicleLoading + ", vehicleToRemove=" + this.vehicleToRemove + ", isLoadingTickets=" + this.isLoadingTickets + ", activeTickets=" + this.activeTickets + ")";
        }

        public /* synthetic */ ViewState(Site site, MultiRideCard multiRideCard, boolean z5, List list, boolean z6, MultiRideAssociatedVehicle multiRideAssociatedVehicle, boolean z7, List list2, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? MultiRideManager.INSTANCE.getForceMolsSite() : site, (i5 & 2) != 0 ? null : multiRideCard, (i5 & 4) != 0 ? true : z5, (i5 & 8) != 0 ? null : list, (i5 & 16) != 0 ? false : z6, (i5 & 32) != 0 ? null : multiRideAssociatedVehicle, (i5 & 64) == 0 ? z7 : true, (i5 & 128) == 0 ? list2 : null);
        }
    }
}
