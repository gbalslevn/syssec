package dk.molslinjen.ui.views.screens.profile.vehicles;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.user.IUserManager;
import dk.molslinjen.domain.managers.user.vehicles.IUserVehiclesManager;
import dk.molslinjen.domain.managers.user.vehicles.UserVehiclesState;
import dk.molslinjen.domain.model.account.UserVehicle;
import dk.molslinjen.extensions.ActivationInfoExtensionsKt;
import dk.molslinjen.extensions.ManagerResultExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.screens.profile.shared.accountCard.AccountCardData;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001dB!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0015J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/vehicles/ProfileVehiclesViewModel;", "Landroidx/lifecycle/ViewModel;", "vehiclesManager", "Ldk/molslinjen/domain/managers/user/vehicles/IUserVehiclesManager;", "userManager", "Ldk/molslinjen/domain/managers/user/IUserManager;", "snackbarService", "Ldk/molslinjen/core/snackbar/ISnackbarService;", "<init>", "(Ldk/molslinjen/domain/managers/user/vehicles/IUserVehiclesManager;Ldk/molslinjen/domain/managers/user/IUserManager;Ldk/molslinjen/core/snackbar/ISnackbarService;)V", "accountCardData", "Lkotlinx/coroutines/flow/Flow;", "Ldk/molslinjen/ui/views/screens/profile/shared/accountCard/AccountCardData;", "_viewState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/ui/views/screens/profile/vehicles/ProfileVehiclesViewModel$ViewState;", "viewState", "Lkotlinx/coroutines/flow/StateFlow;", "getViewState", "()Lkotlinx/coroutines/flow/StateFlow;", "triggerDeleteFlow", BuildConfig.FLAVOR, "vehicle", "Ldk/molslinjen/domain/model/account/UserVehicle;", "cancelDeleteVehicle", "deleteVehicle", "Lkotlinx/coroutines/Job;", "vehicleId", BuildConfig.FLAVOR, "ViewState", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ProfileVehiclesViewModel extends ViewModel {
    private final MutableStateFlow<ViewState> _viewState;
    private final Flow<AccountCardData> accountCardData;
    private final ISnackbarService snackbarService;
    private final IUserVehiclesManager vehiclesManager;
    private final StateFlow<ViewState> viewState;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.ui.views.screens.profile.vehicles.ProfileVehiclesViewModel$1", f = "ProfileVehiclesViewModel.kt", l = {52, 53}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.ui.views.screens.profile.vehicles.ProfileVehiclesViewModel$1, reason: invalid class name */
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
            MutableStateFlow mutableStateFlow;
            Object value;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 == 0) {
                ResultKt.throwOnFailure(obj);
                IUserVehiclesManager iUserVehiclesManager = ProfileVehiclesViewModel.this.vehiclesManager;
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
                    mutableStateFlow = ProfileVehiclesViewModel.this._viewState;
                    do {
                        value = mutableStateFlow.getValue();
                    } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default((ViewState) value, null, null, false, null, false, 27, null)));
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
            }
            ISnackbarService iSnackbarService = ProfileVehiclesViewModel.this.snackbarService;
            this.label = 2;
            if (ManagerResultExtensionsKt.handlePotentialError((ManagerResult) obj, iSnackbarService, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutableStateFlow = ProfileVehiclesViewModel.this._viewState;
            do {
                value = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default((ViewState) value, null, null, false, null, false, 27, null)));
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.ui.views.screens.profile.vehicles.ProfileVehiclesViewModel$2", f = "ProfileVehiclesViewModel.kt", l = {59}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.ui.views.screens.profile.vehicles.ProfileVehiclesViewModel$2, reason: invalid class name */
    /* loaded from: classes2.dex */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "newState", "Ldk/molslinjen/domain/managers/user/vehicles/UserVehiclesState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "dk.molslinjen.ui.views.screens.profile.vehicles.ProfileVehiclesViewModel$2$1", f = "ProfileVehiclesViewModel.kt", l = {}, m = "invokeSuspend")
        /* renamed from: dk.molslinjen.ui.views.screens.profile.vehicles.ProfileVehiclesViewModel$2$1, reason: invalid class name */
        /* loaded from: classes2.dex */
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<UserVehiclesState, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ ProfileVehiclesViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(ProfileVehiclesViewModel profileVehiclesViewModel, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = profileVehiclesViewModel;
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
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                UserVehiclesState userVehiclesState = (UserVehiclesState) this.L$0;
                MutableStateFlow mutableStateFlow = this.this$0._viewState;
                do {
                    value = mutableStateFlow.getValue();
                } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default((ViewState) value, userVehiclesState, null, false, null, false, 30, null)));
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
                StateFlow<UserVehiclesState> vehiclesState = ProfileVehiclesViewModel.this.vehiclesManager.getVehiclesState();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(ProfileVehiclesViewModel.this, null);
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
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ProfileVehiclesViewModel(IUserVehiclesManager vehiclesManager, IUserManager userManager, ISnackbarService snackbarService) {
        Intrinsics.checkNotNullParameter(vehiclesManager, "vehiclesManager");
        Intrinsics.checkNotNullParameter(userManager, "userManager");
        Intrinsics.checkNotNullParameter(snackbarService, "snackbarService");
        this.vehiclesManager = vehiclesManager;
        this.snackbarService = snackbarService;
        Flow<AccountCardData> profileAssetsCardData = ActivationInfoExtensionsKt.toProfileAssetsCardData(userManager.getPendingAccountActivation(), R.string.profile_vehicle_loginDescription, userManager.getAuthenticationType());
        this.accountCardData = profileAssetsCardData;
        MutableStateFlow<ViewState> MutableStateFlow = StateFlowKt.MutableStateFlow(new ViewState(null, null, false, null, false, 31, null));
        this._viewState = MutableStateFlow;
        Object[] objArr = 0 == true ? 1 : 0;
        Object[] objArr2 = 0 == true ? 1 : 0;
        this.viewState = FlowKt.stateIn(FlowKt.flowCombine(MutableStateFlow, profileAssetsCardData, new ProfileVehiclesViewModel$viewState$1(null)), ViewModelKt.getViewModelScope(this), SharingStarted.INSTANCE.getLazily(), new ViewState(objArr2, null, false, objArr, false, 31, null));
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass2(null), 3, null);
    }

    public final void cancelDeleteVehicle() {
        ViewState value;
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, null, null, false, null, false, 23, null)));
    }

    public final Job deleteVehicle(String vehicleId) {
        Job launch$default;
        Intrinsics.checkNotNullParameter(vehicleId, "vehicleId");
        launch$default = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ProfileVehiclesViewModel$deleteVehicle$1(this, vehicleId, null), 3, null);
        return launch$default;
    }

    public final StateFlow<ViewState> getViewState() {
        return this.viewState;
    }

    public final void triggerDeleteFlow(UserVehicle vehicle) {
        ViewState value;
        Intrinsics.checkNotNullParameter(vehicle, "vehicle");
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, null, null, false, vehicle, false, 23, null)));
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fJF\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0016\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001e\u001a\u0004\b\u0007\u0010\u001fR\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010\n\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\n\u0010\u001e\u001a\u0004\b\n\u0010\u001f¨\u0006#"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/vehicles/ProfileVehiclesViewModel$ViewState;", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/managers/user/vehicles/UserVehiclesState;", "userVehiclesState", "Ldk/molslinjen/ui/views/screens/profile/shared/accountCard/AccountCardData;", "accountCardData", BuildConfig.FLAVOR, "isLoading", "Ldk/molslinjen/domain/model/account/UserVehicle;", "vehicleToDelete", "isDeleteLoading", "<init>", "(Ldk/molslinjen/domain/managers/user/vehicles/UserVehiclesState;Ldk/molslinjen/ui/views/screens/profile/shared/accountCard/AccountCardData;ZLdk/molslinjen/domain/model/account/UserVehicle;Z)V", "copy", "(Ldk/molslinjen/domain/managers/user/vehicles/UserVehiclesState;Ldk/molslinjen/ui/views/screens/profile/shared/accountCard/AccountCardData;ZLdk/molslinjen/domain/model/account/UserVehicle;Z)Ldk/molslinjen/ui/views/screens/profile/vehicles/ProfileVehiclesViewModel$ViewState;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ldk/molslinjen/domain/managers/user/vehicles/UserVehiclesState;", "getUserVehiclesState", "()Ldk/molslinjen/domain/managers/user/vehicles/UserVehiclesState;", "Ldk/molslinjen/ui/views/screens/profile/shared/accountCard/AccountCardData;", "getAccountCardData", "()Ldk/molslinjen/ui/views/screens/profile/shared/accountCard/AccountCardData;", "Z", "()Z", "Ldk/molslinjen/domain/model/account/UserVehicle;", "getVehicleToDelete", "()Ldk/molslinjen/domain/model/account/UserVehicle;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ViewState {
        private final AccountCardData accountCardData;
        private final boolean isDeleteLoading;
        private final boolean isLoading;
        private final UserVehiclesState userVehiclesState;
        private final UserVehicle vehicleToDelete;

        public ViewState(UserVehiclesState userVehiclesState, AccountCardData accountCardData, boolean z5, UserVehicle userVehicle, boolean z6) {
            Intrinsics.checkNotNullParameter(userVehiclesState, "userVehiclesState");
            this.userVehiclesState = userVehiclesState;
            this.accountCardData = accountCardData;
            this.isLoading = z5;
            this.vehicleToDelete = userVehicle;
            this.isDeleteLoading = z6;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, UserVehiclesState userVehiclesState, AccountCardData accountCardData, boolean z5, UserVehicle userVehicle, boolean z6, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                userVehiclesState = viewState.userVehiclesState;
            }
            if ((i5 & 2) != 0) {
                accountCardData = viewState.accountCardData;
            }
            AccountCardData accountCardData2 = accountCardData;
            if ((i5 & 4) != 0) {
                z5 = viewState.isLoading;
            }
            boolean z7 = z5;
            if ((i5 & 8) != 0) {
                userVehicle = viewState.vehicleToDelete;
            }
            UserVehicle userVehicle2 = userVehicle;
            if ((i5 & 16) != 0) {
                z6 = viewState.isDeleteLoading;
            }
            return viewState.copy(userVehiclesState, accountCardData2, z7, userVehicle2, z6);
        }

        public final ViewState copy(UserVehiclesState userVehiclesState, AccountCardData accountCardData, boolean isLoading, UserVehicle vehicleToDelete, boolean isDeleteLoading) {
            Intrinsics.checkNotNullParameter(userVehiclesState, "userVehiclesState");
            return new ViewState(userVehiclesState, accountCardData, isLoading, vehicleToDelete, isDeleteLoading);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return Intrinsics.areEqual(this.userVehiclesState, viewState.userVehiclesState) && Intrinsics.areEqual(this.accountCardData, viewState.accountCardData) && this.isLoading == viewState.isLoading && Intrinsics.areEqual(this.vehicleToDelete, viewState.vehicleToDelete) && this.isDeleteLoading == viewState.isDeleteLoading;
        }

        public final AccountCardData getAccountCardData() {
            return this.accountCardData;
        }

        public final UserVehiclesState getUserVehiclesState() {
            return this.userVehiclesState;
        }

        public final UserVehicle getVehicleToDelete() {
            return this.vehicleToDelete;
        }

        public int hashCode() {
            int hashCode = this.userVehiclesState.hashCode() * 31;
            AccountCardData accountCardData = this.accountCardData;
            int hashCode2 = (((hashCode + (accountCardData == null ? 0 : accountCardData.hashCode())) * 31) + Boolean.hashCode(this.isLoading)) * 31;
            UserVehicle userVehicle = this.vehicleToDelete;
            return ((hashCode2 + (userVehicle != null ? userVehicle.hashCode() : 0)) * 31) + Boolean.hashCode(this.isDeleteLoading);
        }

        /* renamed from: isDeleteLoading, reason: from getter */
        public final boolean getIsDeleteLoading() {
            return this.isDeleteLoading;
        }

        /* renamed from: isLoading, reason: from getter */
        public final boolean getIsLoading() {
            return this.isLoading;
        }

        public String toString() {
            return "ViewState(userVehiclesState=" + this.userVehiclesState + ", accountCardData=" + this.accountCardData + ", isLoading=" + this.isLoading + ", vehicleToDelete=" + this.vehicleToDelete + ", isDeleteLoading=" + this.isDeleteLoading + ")";
        }

        public /* synthetic */ ViewState(UserVehiclesState userVehiclesState, AccountCardData accountCardData, boolean z5, UserVehicle userVehicle, boolean z6, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? new UserVehiclesState(null, 1, null) : userVehiclesState, (i5 & 2) != 0 ? null : accountCardData, (i5 & 4) == 0 ? z5 : true, (i5 & 8) == 0 ? userVehicle : null, (i5 & 16) != 0 ? false : z6);
        }
    }
}
