package dk.molslinjen.ui.views.screens.profile.passengers;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import dk.molslinjen.domain.managers.user.IUserManager;
import dk.molslinjen.domain.managers.user.passengers.IUserPassengerManager;
import dk.molslinjen.domain.managers.user.passengers.UserPassengersState;
import dk.molslinjen.domain.model.account.UserPassenger;
import dk.molslinjen.extensions.ActivationInfoExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.screens.profile.shared.accountCard.AccountCardData;
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

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0019B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0013J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001a"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/passengers/ProfilePassengersViewModel;", "Landroidx/lifecycle/ViewModel;", "passengerManager", "Ldk/molslinjen/domain/managers/user/passengers/IUserPassengerManager;", "userManager", "Ldk/molslinjen/domain/managers/user/IUserManager;", "<init>", "(Ldk/molslinjen/domain/managers/user/passengers/IUserPassengerManager;Ldk/molslinjen/domain/managers/user/IUserManager;)V", "accountCardData", "Lkotlinx/coroutines/flow/Flow;", "Ldk/molslinjen/ui/views/screens/profile/shared/accountCard/AccountCardData;", "_viewState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/ui/views/screens/profile/passengers/ProfilePassengersViewModel$ViewState;", "viewState", "Lkotlinx/coroutines/flow/StateFlow;", "getViewState", "()Lkotlinx/coroutines/flow/StateFlow;", "triggerDeleteFlow", BuildConfig.FLAVOR, "passenger", "Ldk/molslinjen/domain/model/account/UserPassenger;", "cancelDeleteFlow", "deletePassenger", "Lkotlinx/coroutines/Job;", "ViewState", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ProfilePassengersViewModel extends ViewModel {
    private final MutableStateFlow<ViewState> _viewState;
    private final Flow<AccountCardData> accountCardData;
    private final IUserPassengerManager passengerManager;
    private final StateFlow<ViewState> viewState;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.ui.views.screens.profile.passengers.ProfilePassengersViewModel$1", f = "ProfilePassengersViewModel.kt", l = {47}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.ui.views.screens.profile.passengers.ProfilePassengersViewModel$1, reason: invalid class name */
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
                IUserPassengerManager iUserPassengerManager = ProfilePassengersViewModel.this.passengerManager;
                this.label = 1;
                if (iUserPassengerManager.loadPassengers(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i5 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            MutableStateFlow mutableStateFlow = ProfilePassengersViewModel.this._viewState;
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
    @DebugMetadata(c = "dk.molslinjen.ui.views.screens.profile.passengers.ProfilePassengersViewModel$2", f = "ProfilePassengersViewModel.kt", l = {52}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.ui.views.screens.profile.passengers.ProfilePassengersViewModel$2, reason: invalid class name */
    /* loaded from: classes2.dex */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "state", "Ldk/molslinjen/domain/managers/user/passengers/UserPassengersState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "dk.molslinjen.ui.views.screens.profile.passengers.ProfilePassengersViewModel$2$1", f = "ProfilePassengersViewModel.kt", l = {}, m = "invokeSuspend")
        /* renamed from: dk.molslinjen.ui.views.screens.profile.passengers.ProfilePassengersViewModel$2$1, reason: invalid class name */
        /* loaded from: classes2.dex */
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<UserPassengersState, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ ProfilePassengersViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(ProfilePassengersViewModel profilePassengersViewModel, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = profilePassengersViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(UserPassengersState userPassengersState, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(userPassengersState, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object value;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                List<UserPassenger> passengers = ((UserPassengersState) this.L$0).getPassengers();
                ArrayList arrayList = new ArrayList();
                for (Object obj2 : passengers) {
                    if (!((UserPassenger) obj2).isCurrentUser()) {
                        arrayList.add(obj2);
                    }
                }
                MutableStateFlow mutableStateFlow = this.this$0._viewState;
                do {
                    value = mutableStateFlow.getValue();
                } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default((ViewState) value, null, arrayList, false, null, false, 29, null)));
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
                StateFlow<UserPassengersState> passengersState = ProfilePassengersViewModel.this.passengerManager.getPassengersState();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(ProfilePassengersViewModel.this, null);
                this.label = 1;
                if (FlowKt.collectLatest(passengersState, anonymousClass1, this) == coroutine_suspended) {
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
    public ProfilePassengersViewModel(IUserPassengerManager passengerManager, IUserManager userManager) {
        Intrinsics.checkNotNullParameter(passengerManager, "passengerManager");
        Intrinsics.checkNotNullParameter(userManager, "userManager");
        this.passengerManager = passengerManager;
        Flow<AccountCardData> profileAssetsCardData = ActivationInfoExtensionsKt.toProfileAssetsCardData(userManager.getPendingAccountActivation(), R.string.profile_passenger_loginDescription, userManager.getAuthenticationType());
        this.accountCardData = profileAssetsCardData;
        MutableStateFlow<ViewState> MutableStateFlow = StateFlowKt.MutableStateFlow(new ViewState(null, null, false, null, false, 31, null));
        this._viewState = MutableStateFlow;
        Object[] objArr = 0 == true ? 1 : 0;
        Object[] objArr2 = 0 == true ? 1 : 0;
        this.viewState = FlowKt.stateIn(FlowKt.flowCombine(MutableStateFlow, profileAssetsCardData, new ProfilePassengersViewModel$viewState$1(null)), ViewModelKt.getViewModelScope(this), SharingStarted.INSTANCE.getLazily(), new ViewState(objArr2, null, false, objArr, false, 31, null));
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass2(null), 3, null);
    }

    public final void cancelDeleteFlow() {
        ViewState value;
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, null, null, false, null, false, 7, null)));
    }

    public final Job deletePassenger(UserPassenger passenger) {
        Job launch$default;
        Intrinsics.checkNotNullParameter(passenger, "passenger");
        launch$default = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ProfilePassengersViewModel$deletePassenger$1(this, passenger, null), 3, null);
        return launch$default;
    }

    public final StateFlow<ViewState> getViewState() {
        return this.viewState;
    }

    public final void triggerDeleteFlow(UserPassenger passenger) {
        ViewState value;
        Intrinsics.checkNotNullParameter(passenger, "passenger");
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, null, null, false, passenger, false, 23, null)));
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJL\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\n\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0016\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001e\u001a\u0004\b\b\u0010\u001fR\u0019\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\t\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010\n\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\n\u0010\u001e\u001a\u0004\b\n\u0010\u001f¨\u0006#"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/passengers/ProfilePassengersViewModel$ViewState;", BuildConfig.FLAVOR, "Ldk/molslinjen/ui/views/screens/profile/shared/accountCard/AccountCardData;", "accountCardData", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/account/UserPassenger;", "passengers", BuildConfig.FLAVOR, "isLoading", "passengerToDelete", "isDeleteLoading", "<init>", "(Ldk/molslinjen/ui/views/screens/profile/shared/accountCard/AccountCardData;Ljava/util/List;ZLdk/molslinjen/domain/model/account/UserPassenger;Z)V", "copy", "(Ldk/molslinjen/ui/views/screens/profile/shared/accountCard/AccountCardData;Ljava/util/List;ZLdk/molslinjen/domain/model/account/UserPassenger;Z)Ldk/molslinjen/ui/views/screens/profile/passengers/ProfilePassengersViewModel$ViewState;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ldk/molslinjen/ui/views/screens/profile/shared/accountCard/AccountCardData;", "getAccountCardData", "()Ldk/molslinjen/ui/views/screens/profile/shared/accountCard/AccountCardData;", "Ljava/util/List;", "getPassengers", "()Ljava/util/List;", "Z", "()Z", "Ldk/molslinjen/domain/model/account/UserPassenger;", "getPassengerToDelete", "()Ldk/molslinjen/domain/model/account/UserPassenger;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ViewState {
        private final AccountCardData accountCardData;
        private final boolean isDeleteLoading;
        private final boolean isLoading;
        private final UserPassenger passengerToDelete;
        private final List<UserPassenger> passengers;

        public ViewState(AccountCardData accountCardData, List<UserPassenger> passengers, boolean z5, UserPassenger userPassenger, boolean z6) {
            Intrinsics.checkNotNullParameter(passengers, "passengers");
            this.accountCardData = accountCardData;
            this.passengers = passengers;
            this.isLoading = z5;
            this.passengerToDelete = userPassenger;
            this.isDeleteLoading = z6;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, AccountCardData accountCardData, List list, boolean z5, UserPassenger userPassenger, boolean z6, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                accountCardData = viewState.accountCardData;
            }
            if ((i5 & 2) != 0) {
                list = viewState.passengers;
            }
            List list2 = list;
            if ((i5 & 4) != 0) {
                z5 = viewState.isLoading;
            }
            boolean z7 = z5;
            if ((i5 & 8) != 0) {
                userPassenger = viewState.passengerToDelete;
            }
            UserPassenger userPassenger2 = userPassenger;
            if ((i5 & 16) != 0) {
                z6 = viewState.isDeleteLoading;
            }
            return viewState.copy(accountCardData, list2, z7, userPassenger2, z6);
        }

        public final ViewState copy(AccountCardData accountCardData, List<UserPassenger> passengers, boolean isLoading, UserPassenger passengerToDelete, boolean isDeleteLoading) {
            Intrinsics.checkNotNullParameter(passengers, "passengers");
            return new ViewState(accountCardData, passengers, isLoading, passengerToDelete, isDeleteLoading);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return Intrinsics.areEqual(this.accountCardData, viewState.accountCardData) && Intrinsics.areEqual(this.passengers, viewState.passengers) && this.isLoading == viewState.isLoading && Intrinsics.areEqual(this.passengerToDelete, viewState.passengerToDelete) && this.isDeleteLoading == viewState.isDeleteLoading;
        }

        public final AccountCardData getAccountCardData() {
            return this.accountCardData;
        }

        public final UserPassenger getPassengerToDelete() {
            return this.passengerToDelete;
        }

        public final List<UserPassenger> getPassengers() {
            return this.passengers;
        }

        public int hashCode() {
            AccountCardData accountCardData = this.accountCardData;
            int hashCode = (((((accountCardData == null ? 0 : accountCardData.hashCode()) * 31) + this.passengers.hashCode()) * 31) + Boolean.hashCode(this.isLoading)) * 31;
            UserPassenger userPassenger = this.passengerToDelete;
            return ((hashCode + (userPassenger != null ? userPassenger.hashCode() : 0)) * 31) + Boolean.hashCode(this.isDeleteLoading);
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
            return "ViewState(accountCardData=" + this.accountCardData + ", passengers=" + this.passengers + ", isLoading=" + this.isLoading + ", passengerToDelete=" + this.passengerToDelete + ", isDeleteLoading=" + this.isDeleteLoading + ")";
        }

        public /* synthetic */ ViewState(AccountCardData accountCardData, List list, boolean z5, UserPassenger userPassenger, boolean z6, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? null : accountCardData, (i5 & 2) != 0 ? CollectionsKt.emptyList() : list, (i5 & 4) != 0 ? true : z5, (i5 & 8) == 0 ? userPassenger : null, (i5 & 16) != 0 ? false : z6);
        }
    }
}
