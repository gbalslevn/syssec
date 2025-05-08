package dk.molslinjen.ui.views.screens.profile.vehicles.selector;

import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.ramcosta.composedestinations.generated.destinations.VehicleSelectorScreenDestination;
import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.configuration.IConfigurationManager;
import dk.molslinjen.domain.managers.user.vehicles.IUserVehiclesManager;
import dk.molslinjen.domain.managers.user.vehicles.UserVehiclesState;
import dk.molslinjen.domain.model.account.UserVehicle;
import dk.molslinjen.domain.model.config.LocalizedSiteConfiguration;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.domain.model.config.Transportation;
import dk.molslinjen.extensions.ManagerResultExtensionsKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 &2\u00020\u0001:\u0002%&B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ2\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00182\u0006\u0010\u001c\u001a\u00020\u001dH\u0082@¢\u0006\u0002\u0010\u001eJ\"\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u00192\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00160\"J\u0006\u0010#\u001a\u00020\u0016J\u0006\u0010$\u001a\u00020\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006'"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/vehicles/selector/VehicleSelectorViewModel;", "Landroidx/lifecycle/ViewModel;", "vehiclesManager", "Ldk/molslinjen/domain/managers/user/vehicles/IUserVehiclesManager;", "snackbarService", "Ldk/molslinjen/core/snackbar/ISnackbarService;", "configurationManager", "Ldk/molslinjen/domain/managers/configuration/IConfigurationManager;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "<init>", "(Ldk/molslinjen/domain/managers/user/vehicles/IUserVehiclesManager;Ldk/molslinjen/core/snackbar/ISnackbarService;Ldk/molslinjen/domain/managers/configuration/IConfigurationManager;Landroidx/lifecycle/SavedStateHandle;)V", "navArgs", "Ldk/molslinjen/ui/views/screens/profile/vehicles/selector/VehicleSelectorScreenNavArgs;", "_viewState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/ui/views/screens/profile/vehicles/selector/VehicleSelectorViewModel$ViewState;", "viewState", "Lkotlinx/coroutines/flow/StateFlow;", "getViewState", "()Lkotlinx/coroutines/flow/StateFlow;", "validateVehicles", BuildConfig.FLAVOR, "vehicles", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/account/UserVehicle;", "allowedCarIds", BuildConfig.FLAVOR, "site", "Ldk/molslinjen/domain/model/config/Site;", "(Ljava/util/List;Ljava/util/List;Ldk/molslinjen/domain/model/config/Site;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "vehicleSelected", "vehicle", "vehicleValidationSuccess", "Lkotlin/Function1;", "hideValidationDialog", "showNoMatchVehicleMessage", "ViewState", "Companion", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class VehicleSelectorViewModel extends ViewModel {
    private final MutableStateFlow<ViewState> _viewState;
    private final IConfigurationManager configurationManager;
    private final VehicleSelectorScreenNavArgs navArgs;
    private final ISnackbarService snackbarService;
    private final IUserVehiclesManager vehiclesManager;
    public static final int $stable = 8;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.ui.views.screens.profile.vehicles.selector.VehicleSelectorViewModel$1", f = "VehicleSelectorViewModel.kt", l = {42}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.ui.views.screens.profile.vehicles.selector.VehicleSelectorViewModel$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object value;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 == 0) {
                ResultKt.throwOnFailure(obj);
                IConfigurationManager iConfigurationManager = VehicleSelectorViewModel.this.configurationManager;
                Site site = VehicleSelectorViewModel.this.navArgs.getSite();
                this.label = 1;
                obj = iConfigurationManager.getActiveConfiguration(site, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i5 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            LocalizedSiteConfiguration localizedSiteConfiguration = (LocalizedSiteConfiguration) obj;
            if (localizedSiteConfiguration == null) {
                return Unit.INSTANCE;
            }
            List<Transportation> transportations = localizedSiteConfiguration.getTransportations();
            VehicleSelectorViewModel vehicleSelectorViewModel = VehicleSelectorViewModel.this;
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : transportations) {
                if (vehicleSelectorViewModel.navArgs.getTransportationIds().contains(((Transportation) obj2).getId())) {
                    arrayList.add(obj2);
                }
            }
            MutableStateFlow mutableStateFlow = VehicleSelectorViewModel.this._viewState;
            do {
                value = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default((ViewState) value, null, null, null, false, false, null, arrayList, 63, null)));
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.ui.views.screens.profile.vehicles.selector.VehicleSelectorViewModel$2", f = "VehicleSelectorViewModel.kt", l = {48, 49}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.ui.views.screens.profile.vehicles.selector.VehicleSelectorViewModel$2, reason: invalid class name */
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
                IUserVehiclesManager iUserVehiclesManager = VehicleSelectorViewModel.this.vehiclesManager;
                this.label = 1;
                obj = iUserVehiclesManager.loadVehicles(this);
                if (obj == coroutine_suspended) {
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
            ISnackbarService iSnackbarService = VehicleSelectorViewModel.this.snackbarService;
            this.label = 2;
            if (ManagerResultExtensionsKt.handlePotentialError((ManagerResult) obj, iSnackbarService, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.ui.views.screens.profile.vehicles.selector.VehicleSelectorViewModel$3", f = "VehicleSelectorViewModel.kt", l = {53}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.ui.views.screens.profile.vehicles.selector.VehicleSelectorViewModel$3, reason: invalid class name */
    /* loaded from: classes2.dex */
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "newState", "Ldk/molslinjen/domain/managers/user/vehicles/UserVehiclesState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "dk.molslinjen.ui.views.screens.profile.vehicles.selector.VehicleSelectorViewModel$3$1", f = "VehicleSelectorViewModel.kt", l = {62}, m = "invokeSuspend")
        /* renamed from: dk.molslinjen.ui.views.screens.profile.vehicles.selector.VehicleSelectorViewModel$3$1, reason: invalid class name */
        /* loaded from: classes2.dex */
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<UserVehiclesState, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ VehicleSelectorViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(VehicleSelectorViewModel vehicleSelectorViewModel, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = vehicleSelectorViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(UserVehiclesState userVehiclesState, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(userVehiclesState, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object value;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i5 = this.label;
                if (i5 == 0) {
                    ResultKt.throwOnFailure(obj);
                    UserVehiclesState userVehiclesState = (UserVehiclesState) this.L$0;
                    MutableStateFlow mutableStateFlow = this.this$0._viewState;
                    do {
                        value = mutableStateFlow.getValue();
                    } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default((ViewState) value, userVehiclesState.getVehicles(), CollectionsKt.emptyList(), CollectionsKt.emptyList(), false, false, null, null, 120, null)));
                    VehicleSelectorViewModel vehicleSelectorViewModel = this.this$0;
                    List<UserVehicle> vehicles = userVehiclesState.getVehicles();
                    ArrayList<String> carIds = this.this$0.navArgs.getCarIds();
                    Site site = this.this$0.navArgs.getSite();
                    this.label = 1;
                    if (vehicleSelectorViewModel.validateVehicles(vehicles, carIds, site, this) == coroutine_suspended) {
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
        }

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass3(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 == 0) {
                ResultKt.throwOnFailure(obj);
                StateFlow<UserVehiclesState> vehiclesState = VehicleSelectorViewModel.this.vehiclesManager.getVehiclesState();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(VehicleSelectorViewModel.this, null);
                this.label = 1;
                if (FlowKt.collectLatest(vehiclesState, anonymousClass1, this) == coroutine_suspended) {
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
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public VehicleSelectorViewModel(IUserVehiclesManager vehiclesManager, ISnackbarService snackbarService, IConfigurationManager configurationManager, SavedStateHandle savedStateHandle) {
        Intrinsics.checkNotNullParameter(vehiclesManager, "vehiclesManager");
        Intrinsics.checkNotNullParameter(snackbarService, "snackbarService");
        Intrinsics.checkNotNullParameter(configurationManager, "configurationManager");
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        this.vehiclesManager = vehiclesManager;
        this.snackbarService = snackbarService;
        this.configurationManager = configurationManager;
        this.navArgs = VehicleSelectorScreenDestination.INSTANCE.argsFrom(savedStateHandle);
        this._viewState = StateFlowKt.MutableStateFlow(new ViewState(null, null, null, false, false, null, null, 127, null));
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass2(null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass3(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00e3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00c9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x00e4 -> B:12:0x008b). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object validateVehicles(List<UserVehicle> list, List<String> list2, Site site, Continuation<? super Unit> continuation) {
        VehicleSelectorViewModel$validateVehicles$1 vehicleSelectorViewModel$validateVehicles$1;
        int i5;
        VehicleSelectorViewModel vehicleSelectorViewModel;
        Iterator<UserVehicle> it;
        List<String> list3;
        UserVehicle userVehicle;
        List<String> list4;
        VehicleSelectorViewModel$validateVehicles$3 vehicleSelectorViewModel$validateVehicles$3;
        ViewState value;
        if (continuation instanceof VehicleSelectorViewModel$validateVehicles$1) {
            vehicleSelectorViewModel$validateVehicles$1 = (VehicleSelectorViewModel$validateVehicles$1) continuation;
            int i6 = vehicleSelectorViewModel$validateVehicles$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                vehicleSelectorViewModel$validateVehicles$1.label = i6 - Integer.MIN_VALUE;
                Object obj = vehicleSelectorViewModel$validateVehicles$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = vehicleSelectorViewModel$validateVehicles$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    vehicleSelectorViewModel = this;
                    it = list.iterator();
                    list3 = list2;
                } else if (i5 == 1) {
                    userVehicle = (UserVehicle) vehicleSelectorViewModel$validateVehicles$1.L$4;
                    it = (Iterator) vehicleSelectorViewModel$validateVehicles$1.L$3;
                    site = (Site) vehicleSelectorViewModel$validateVehicles$1.L$2;
                    list4 = (List) vehicleSelectorViewModel$validateVehicles$1.L$1;
                    vehicleSelectorViewModel = (VehicleSelectorViewModel) vehicleSelectorViewModel$validateVehicles$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    VehicleSelectorViewModel$validateVehicles$2 vehicleSelectorViewModel$validateVehicles$2 = new VehicleSelectorViewModel$validateVehicles$2(vehicleSelectorViewModel, userVehicle, null);
                    vehicleSelectorViewModel$validateVehicles$1.L$0 = vehicleSelectorViewModel;
                    vehicleSelectorViewModel$validateVehicles$1.L$1 = list4;
                    vehicleSelectorViewModel$validateVehicles$1.L$2 = site;
                    vehicleSelectorViewModel$validateVehicles$1.L$3 = it;
                    vehicleSelectorViewModel$validateVehicles$1.L$4 = userVehicle;
                    vehicleSelectorViewModel$validateVehicles$1.label = 2;
                    obj = dk.molslinjen.domain.extensions.ManagerResultExtensionsKt.onSuccess((ManagerResult) obj, vehicleSelectorViewModel$validateVehicles$2, vehicleSelectorViewModel$validateVehicles$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    VehicleSelectorViewModel vehicleSelectorViewModel2 = vehicleSelectorViewModel;
                    List<String> list5 = list4;
                    vehicleSelectorViewModel$validateVehicles$3 = new VehicleSelectorViewModel$validateVehicles$3(vehicleSelectorViewModel2, userVehicle, null);
                    vehicleSelectorViewModel$validateVehicles$1.L$0 = vehicleSelectorViewModel2;
                    vehicleSelectorViewModel$validateVehicles$1.L$1 = list5;
                    vehicleSelectorViewModel$validateVehicles$1.L$2 = site;
                    vehicleSelectorViewModel$validateVehicles$1.L$3 = it;
                    vehicleSelectorViewModel$validateVehicles$1.L$4 = null;
                    vehicleSelectorViewModel$validateVehicles$1.label = 3;
                    if (dk.molslinjen.domain.extensions.ManagerResultExtensionsKt.onFailure((ManagerResult) obj, vehicleSelectorViewModel$validateVehicles$3, vehicleSelectorViewModel$validateVehicles$1) == coroutine_suspended) {
                    }
                } else if (i5 == 2) {
                    userVehicle = (UserVehicle) vehicleSelectorViewModel$validateVehicles$1.L$4;
                    it = (Iterator) vehicleSelectorViewModel$validateVehicles$1.L$3;
                    site = (Site) vehicleSelectorViewModel$validateVehicles$1.L$2;
                    list4 = (List) vehicleSelectorViewModel$validateVehicles$1.L$1;
                    vehicleSelectorViewModel = (VehicleSelectorViewModel) vehicleSelectorViewModel$validateVehicles$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    VehicleSelectorViewModel vehicleSelectorViewModel22 = vehicleSelectorViewModel;
                    List<String> list52 = list4;
                    vehicleSelectorViewModel$validateVehicles$3 = new VehicleSelectorViewModel$validateVehicles$3(vehicleSelectorViewModel22, userVehicle, null);
                    vehicleSelectorViewModel$validateVehicles$1.L$0 = vehicleSelectorViewModel22;
                    vehicleSelectorViewModel$validateVehicles$1.L$1 = list52;
                    vehicleSelectorViewModel$validateVehicles$1.L$2 = site;
                    vehicleSelectorViewModel$validateVehicles$1.L$3 = it;
                    vehicleSelectorViewModel$validateVehicles$1.L$4 = null;
                    vehicleSelectorViewModel$validateVehicles$1.label = 3;
                    if (dk.molslinjen.domain.extensions.ManagerResultExtensionsKt.onFailure((ManagerResult) obj, vehicleSelectorViewModel$validateVehicles$3, vehicleSelectorViewModel$validateVehicles$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    list3 = list52;
                    vehicleSelectorViewModel = vehicleSelectorViewModel22;
                } else {
                    if (i5 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Iterator<UserVehicle> it2 = (Iterator) vehicleSelectorViewModel$validateVehicles$1.L$3;
                    Site site2 = (Site) vehicleSelectorViewModel$validateVehicles$1.L$2;
                    List<String> list6 = (List) vehicleSelectorViewModel$validateVehicles$1.L$1;
                    VehicleSelectorViewModel vehicleSelectorViewModel3 = (VehicleSelectorViewModel) vehicleSelectorViewModel$validateVehicles$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    vehicleSelectorViewModel = vehicleSelectorViewModel3;
                    it = it2;
                    list3 = list6;
                    site = site2;
                }
                if (it.hasNext()) {
                    MutableStateFlow<ViewState> mutableStateFlow = vehicleSelectorViewModel._viewState;
                    do {
                        value = mutableStateFlow.getValue();
                    } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, null, null, null, false, false, null, null, 119, null)));
                    return Unit.INSTANCE;
                }
                UserVehicle next = it.next();
                IUserVehiclesManager iUserVehiclesManager = vehicleSelectorViewModel.vehiclesManager;
                vehicleSelectorViewModel$validateVehicles$1.L$0 = vehicleSelectorViewModel;
                vehicleSelectorViewModel$validateVehicles$1.L$1 = list3;
                vehicleSelectorViewModel$validateVehicles$1.L$2 = site;
                vehicleSelectorViewModel$validateVehicles$1.L$3 = it;
                vehicleSelectorViewModel$validateVehicles$1.L$4 = next;
                vehicleSelectorViewModel$validateVehicles$1.label = 1;
                Object validateVehicle = iUserVehiclesManager.validateVehicle(next, list3, site, vehicleSelectorViewModel$validateVehicles$1);
                if (validateVehicle == coroutine_suspended) {
                    return coroutine_suspended;
                }
                list4 = list3;
                userVehicle = next;
                obj = validateVehicle;
                VehicleSelectorViewModel$validateVehicles$2 vehicleSelectorViewModel$validateVehicles$22 = new VehicleSelectorViewModel$validateVehicles$2(vehicleSelectorViewModel, userVehicle, null);
                vehicleSelectorViewModel$validateVehicles$1.L$0 = vehicleSelectorViewModel;
                vehicleSelectorViewModel$validateVehicles$1.L$1 = list4;
                vehicleSelectorViewModel$validateVehicles$1.L$2 = site;
                vehicleSelectorViewModel$validateVehicles$1.L$3 = it;
                vehicleSelectorViewModel$validateVehicles$1.L$4 = userVehicle;
                vehicleSelectorViewModel$validateVehicles$1.label = 2;
                obj = dk.molslinjen.domain.extensions.ManagerResultExtensionsKt.onSuccess((ManagerResult) obj, vehicleSelectorViewModel$validateVehicles$22, vehicleSelectorViewModel$validateVehicles$1);
                if (obj == coroutine_suspended) {
                }
                VehicleSelectorViewModel vehicleSelectorViewModel222 = vehicleSelectorViewModel;
                List<String> list522 = list4;
                vehicleSelectorViewModel$validateVehicles$3 = new VehicleSelectorViewModel$validateVehicles$3(vehicleSelectorViewModel222, userVehicle, null);
                vehicleSelectorViewModel$validateVehicles$1.L$0 = vehicleSelectorViewModel222;
                vehicleSelectorViewModel$validateVehicles$1.L$1 = list522;
                vehicleSelectorViewModel$validateVehicles$1.L$2 = site;
                vehicleSelectorViewModel$validateVehicles$1.L$3 = it;
                vehicleSelectorViewModel$validateVehicles$1.L$4 = null;
                vehicleSelectorViewModel$validateVehicles$1.label = 3;
                if (dk.molslinjen.domain.extensions.ManagerResultExtensionsKt.onFailure((ManagerResult) obj, vehicleSelectorViewModel$validateVehicles$3, vehicleSelectorViewModel$validateVehicles$1) == coroutine_suspended) {
                }
            }
        }
        vehicleSelectorViewModel$validateVehicles$1 = new VehicleSelectorViewModel$validateVehicles$1(this, continuation);
        Object obj2 = vehicleSelectorViewModel$validateVehicles$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = vehicleSelectorViewModel$validateVehicles$1.label;
        if (i5 != 0) {
        }
        if (it.hasNext()) {
        }
    }

    public final StateFlow<ViewState> getViewState() {
        return this._viewState;
    }

    public final void hideValidationDialog() {
        ViewState value;
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, null, null, null, false, false, null, null, 79, null)));
    }

    public final void showNoMatchVehicleMessage() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new VehicleSelectorViewModel$showNoMatchVehicleMessage$1(this, null), 3, null);
    }

    public final void vehicleSelected(UserVehicle vehicle, Function1<? super UserVehicle, Unit> vehicleValidationSuccess) {
        Object obj;
        ViewState value;
        Intrinsics.checkNotNullParameter(vehicle, "vehicle");
        Intrinsics.checkNotNullParameter(vehicleValidationSuccess, "vehicleValidationSuccess");
        Iterator<T> it = getViewState().getValue().getAvailableVehicles().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (Intrinsics.areEqual((UserVehicle) obj, vehicle)) {
                    break;
                }
            }
        }
        if (((UserVehicle) obj) != null) {
            vehicleValidationSuccess.invoke(vehicle);
            return;
        }
        List<UserVehicle> availableVehicles = getViewState().getValue().getAvailableVehicles();
        if (!(availableVehicles instanceof Collection) || !availableVehicles.isEmpty()) {
            Iterator<T> it2 = availableVehicles.iterator();
            while (it2.hasNext()) {
                if (Intrinsics.areEqual(((UserVehicle) it2.next()).getLicensePlate(), vehicle.getLicensePlate())) {
                    vehicleValidationSuccess.invoke(vehicle);
                    return;
                }
            }
        }
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, null, null, null, false, true, vehicle, null, 79, null)));
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\b\u0087\b\u0018\u00002\u00020\u0001Bi\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0002¢\u0006\u0004\b\r\u0010\u000eJr\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0018\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001d\u0010\u001cR\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001a\u001a\u0004\b\u001e\u0010\u001cR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001f\u001a\u0004\b\b\u0010 R\u0017\u0010\t\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\t\u0010\u001f\u001a\u0004\b!\u0010 R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006¢\u0006\f\n\u0004\b\n\u0010\"\u001a\u0004\b#\u0010$R\u001f\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b%\u0010\u001c¨\u0006&"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/vehicles/selector/VehicleSelectorViewModel$ViewState;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/account/UserVehicle;", "unvalidatedVehicles", "availableVehicles", "unavailableVehicles", BuildConfig.FLAVOR, "isLoading", "showValidationErrorDialog", "vehicleWithValidationError", "Ldk/molslinjen/domain/model/config/Transportation;", "transportations", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;ZZLdk/molslinjen/domain/model/account/UserVehicle;Ljava/util/List;)V", "copy", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;ZZLdk/molslinjen/domain/model/account/UserVehicle;Ljava/util/List;)Ldk/molslinjen/ui/views/screens/profile/vehicles/selector/VehicleSelectorViewModel$ViewState;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getUnvalidatedVehicles", "()Ljava/util/List;", "getAvailableVehicles", "getUnavailableVehicles", "Z", "()Z", "getShowValidationErrorDialog", "Ldk/molslinjen/domain/model/account/UserVehicle;", "getVehicleWithValidationError", "()Ldk/molslinjen/domain/model/account/UserVehicle;", "getTransportations", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ViewState {
        private final List<UserVehicle> availableVehicles;
        private final boolean isLoading;
        private final boolean showValidationErrorDialog;
        private final List<Transportation> transportations;
        private final List<UserVehicle> unavailableVehicles;
        private final List<UserVehicle> unvalidatedVehicles;
        private final UserVehicle vehicleWithValidationError;

        public ViewState(List<UserVehicle> unvalidatedVehicles, List<UserVehicle> availableVehicles, List<UserVehicle> unavailableVehicles, boolean z5, boolean z6, UserVehicle userVehicle, List<Transportation> list) {
            Intrinsics.checkNotNullParameter(unvalidatedVehicles, "unvalidatedVehicles");
            Intrinsics.checkNotNullParameter(availableVehicles, "availableVehicles");
            Intrinsics.checkNotNullParameter(unavailableVehicles, "unavailableVehicles");
            this.unvalidatedVehicles = unvalidatedVehicles;
            this.availableVehicles = availableVehicles;
            this.unavailableVehicles = unavailableVehicles;
            this.isLoading = z5;
            this.showValidationErrorDialog = z6;
            this.vehicleWithValidationError = userVehicle;
            this.transportations = list;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, List list, List list2, List list3, boolean z5, boolean z6, UserVehicle userVehicle, List list4, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                list = viewState.unvalidatedVehicles;
            }
            if ((i5 & 2) != 0) {
                list2 = viewState.availableVehicles;
            }
            List list5 = list2;
            if ((i5 & 4) != 0) {
                list3 = viewState.unavailableVehicles;
            }
            List list6 = list3;
            if ((i5 & 8) != 0) {
                z5 = viewState.isLoading;
            }
            boolean z7 = z5;
            if ((i5 & 16) != 0) {
                z6 = viewState.showValidationErrorDialog;
            }
            boolean z8 = z6;
            if ((i5 & 32) != 0) {
                userVehicle = viewState.vehicleWithValidationError;
            }
            UserVehicle userVehicle2 = userVehicle;
            if ((i5 & 64) != 0) {
                list4 = viewState.transportations;
            }
            return viewState.copy(list, list5, list6, z7, z8, userVehicle2, list4);
        }

        public final ViewState copy(List<UserVehicle> unvalidatedVehicles, List<UserVehicle> availableVehicles, List<UserVehicle> unavailableVehicles, boolean isLoading, boolean showValidationErrorDialog, UserVehicle vehicleWithValidationError, List<Transportation> transportations) {
            Intrinsics.checkNotNullParameter(unvalidatedVehicles, "unvalidatedVehicles");
            Intrinsics.checkNotNullParameter(availableVehicles, "availableVehicles");
            Intrinsics.checkNotNullParameter(unavailableVehicles, "unavailableVehicles");
            return new ViewState(unvalidatedVehicles, availableVehicles, unavailableVehicles, isLoading, showValidationErrorDialog, vehicleWithValidationError, transportations);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return Intrinsics.areEqual(this.unvalidatedVehicles, viewState.unvalidatedVehicles) && Intrinsics.areEqual(this.availableVehicles, viewState.availableVehicles) && Intrinsics.areEqual(this.unavailableVehicles, viewState.unavailableVehicles) && this.isLoading == viewState.isLoading && this.showValidationErrorDialog == viewState.showValidationErrorDialog && Intrinsics.areEqual(this.vehicleWithValidationError, viewState.vehicleWithValidationError) && Intrinsics.areEqual(this.transportations, viewState.transportations);
        }

        public final List<UserVehicle> getAvailableVehicles() {
            return this.availableVehicles;
        }

        public final boolean getShowValidationErrorDialog() {
            return this.showValidationErrorDialog;
        }

        public final List<Transportation> getTransportations() {
            return this.transportations;
        }

        public final List<UserVehicle> getUnavailableVehicles() {
            return this.unavailableVehicles;
        }

        public final List<UserVehicle> getUnvalidatedVehicles() {
            return this.unvalidatedVehicles;
        }

        public final UserVehicle getVehicleWithValidationError() {
            return this.vehicleWithValidationError;
        }

        public int hashCode() {
            int hashCode = ((((((((this.unvalidatedVehicles.hashCode() * 31) + this.availableVehicles.hashCode()) * 31) + this.unavailableVehicles.hashCode()) * 31) + Boolean.hashCode(this.isLoading)) * 31) + Boolean.hashCode(this.showValidationErrorDialog)) * 31;
            UserVehicle userVehicle = this.vehicleWithValidationError;
            int hashCode2 = (hashCode + (userVehicle == null ? 0 : userVehicle.hashCode())) * 31;
            List<Transportation> list = this.transportations;
            return hashCode2 + (list != null ? list.hashCode() : 0);
        }

        /* renamed from: isLoading, reason: from getter */
        public final boolean getIsLoading() {
            return this.isLoading;
        }

        public String toString() {
            return "ViewState(unvalidatedVehicles=" + this.unvalidatedVehicles + ", availableVehicles=" + this.availableVehicles + ", unavailableVehicles=" + this.unavailableVehicles + ", isLoading=" + this.isLoading + ", showValidationErrorDialog=" + this.showValidationErrorDialog + ", vehicleWithValidationError=" + this.vehicleWithValidationError + ", transportations=" + this.transportations + ")";
        }

        public /* synthetic */ ViewState(List list, List list2, List list3, boolean z5, boolean z6, UserVehicle userVehicle, List list4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? CollectionsKt.emptyList() : list, (i5 & 2) != 0 ? CollectionsKt.emptyList() : list2, (i5 & 4) != 0 ? CollectionsKt.emptyList() : list3, (i5 & 8) != 0 ? true : z5, (i5 & 16) != 0 ? false : z6, (i5 & 32) != 0 ? null : userVehicle, (i5 & 64) != 0 ? null : list4);
        }
    }
}
