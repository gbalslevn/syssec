package dk.molslinjen.ui.views.screens.profile.brobizz;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.user.brobizz.IUserBrobizzManager;
import dk.molslinjen.domain.managers.user.brobizz.UserBrobizzState;
import dk.molslinjen.extensions.ManagerResultExtensionsKt;
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
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0015B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u000fJ\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0016"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/brobizz/ProfileBrobizzViewModel;", "Landroidx/lifecycle/ViewModel;", "brobizzManager", "Ldk/molslinjen/domain/managers/user/brobizz/IUserBrobizzManager;", "snackbarService", "Ldk/molslinjen/core/snackbar/ISnackbarService;", "<init>", "(Ldk/molslinjen/domain/managers/user/brobizz/IUserBrobizzManager;Ldk/molslinjen/core/snackbar/ISnackbarService;)V", "_viewState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/ui/views/screens/profile/brobizz/ProfileBrobizzViewModel$ViewState;", "viewState", "getViewState", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "triggerRemoveFlow", BuildConfig.FLAVOR, "brobizzId", BuildConfig.FLAVOR, "cancelRemove", "removeBrobizz", "Lkotlinx/coroutines/Job;", "ViewState", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ProfileBrobizzViewModel extends ViewModel {
    private final MutableStateFlow<ViewState> _viewState;
    private final IUserBrobizzManager brobizzManager;
    private final ISnackbarService snackbarService;
    private final MutableStateFlow<ViewState> viewState;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.ui.views.screens.profile.brobizz.ProfileBrobizzViewModel$1", f = "ProfileBrobizzViewModel.kt", l = {27, 28}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.ui.views.screens.profile.brobizz.ProfileBrobizzViewModel$1, reason: invalid class name */
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
                IUserBrobizzManager iUserBrobizzManager = ProfileBrobizzViewModel.this.brobizzManager;
                this.label = 1;
                obj = iUserBrobizzManager.loadBrobizz(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i5 != 1) {
                    if (i5 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    mutableStateFlow = ProfileBrobizzViewModel.this._viewState;
                    do {
                        value = mutableStateFlow.getValue();
                    } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default((ViewState) value, null, false, null, false, 13, null)));
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
            }
            ISnackbarService iSnackbarService = ProfileBrobizzViewModel.this.snackbarService;
            this.label = 2;
            if (ManagerResultExtensionsKt.handlePotentialError((ManagerResult) obj, iSnackbarService, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutableStateFlow = ProfileBrobizzViewModel.this._viewState;
            do {
                value = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default((ViewState) value, null, false, null, false, 13, null)));
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.ui.views.screens.profile.brobizz.ProfileBrobizzViewModel$2", f = "ProfileBrobizzViewModel.kt", l = {33}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.ui.views.screens.profile.brobizz.ProfileBrobizzViewModel$2, reason: invalid class name */
    /* loaded from: classes2.dex */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "state", "Ldk/molslinjen/domain/managers/user/brobizz/UserBrobizzState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "dk.molslinjen.ui.views.screens.profile.brobizz.ProfileBrobizzViewModel$2$1", f = "ProfileBrobizzViewModel.kt", l = {}, m = "invokeSuspend")
        /* renamed from: dk.molslinjen.ui.views.screens.profile.brobizz.ProfileBrobizzViewModel$2$1, reason: invalid class name */
        /* loaded from: classes2.dex */
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<UserBrobizzState, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ ProfileBrobizzViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(ProfileBrobizzViewModel profileBrobizzViewModel, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = profileBrobizzViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(UserBrobizzState userBrobizzState, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(userBrobizzState, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object value;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                UserBrobizzState userBrobizzState = (UserBrobizzState) this.L$0;
                MutableStateFlow mutableStateFlow = this.this$0._viewState;
                do {
                    value = mutableStateFlow.getValue();
                } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default((ViewState) value, userBrobizzState, false, null, false, 14, null)));
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
                StateFlow<UserBrobizzState> brobizzState = ProfileBrobizzViewModel.this.brobizzManager.getBrobizzState();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(ProfileBrobizzViewModel.this, null);
                this.label = 1;
                if (FlowKt.collectLatest(brobizzState, anonymousClass1, this) == coroutine_suspended) {
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

    public ProfileBrobizzViewModel(IUserBrobizzManager brobizzManager, ISnackbarService snackbarService) {
        Intrinsics.checkNotNullParameter(brobizzManager, "brobizzManager");
        Intrinsics.checkNotNullParameter(snackbarService, "snackbarService");
        this.brobizzManager = brobizzManager;
        this.snackbarService = snackbarService;
        MutableStateFlow<ViewState> MutableStateFlow = StateFlowKt.MutableStateFlow(new ViewState(null, false, null, false, 15, null));
        this._viewState = MutableStateFlow;
        this.viewState = MutableStateFlow;
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass2(null), 3, null);
    }

    public final void cancelRemove() {
        ViewState value;
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, null, false, null, false, 11, null)));
    }

    public final MutableStateFlow<ViewState> getViewState() {
        return this.viewState;
    }

    public final Job removeBrobizz(String brobizzId) {
        Job launch$default;
        Intrinsics.checkNotNullParameter(brobizzId, "brobizzId");
        launch$default = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ProfileBrobizzViewModel$removeBrobizz$1(this, brobizzId, null), 3, null);
        return launch$default;
    }

    public final void triggerRemoveFlow(String brobizzId) {
        ViewState value;
        Intrinsics.checkNotNullParameter(brobizzId, "brobizzId");
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, null, false, brobizzId, false, 11, null)));
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\r\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ:\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\b\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0005\u0010\u0019R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001a\u001a\u0004\b\u001b\u0010\u000eR\u0017\u0010\b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\b\u0010\u0018\u001a\u0004\b\b\u0010\u0019¨\u0006\u001c"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/brobizz/ProfileBrobizzViewModel$ViewState;", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/managers/user/brobizz/UserBrobizzState;", "brobizzState", BuildConfig.FLAVOR, "isLoading", BuildConfig.FLAVOR, "brobizzToRemove", "isDeleteLoading", "<init>", "(Ldk/molslinjen/domain/managers/user/brobizz/UserBrobizzState;ZLjava/lang/String;Z)V", "copy", "(Ldk/molslinjen/domain/managers/user/brobizz/UserBrobizzState;ZLjava/lang/String;Z)Ldk/molslinjen/ui/views/screens/profile/brobizz/ProfileBrobizzViewModel$ViewState;", "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ldk/molslinjen/domain/managers/user/brobizz/UserBrobizzState;", "getBrobizzState", "()Ldk/molslinjen/domain/managers/user/brobizz/UserBrobizzState;", "Z", "()Z", "Ljava/lang/String;", "getBrobizzToRemove", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ViewState {
        private final UserBrobizzState brobizzState;
        private final String brobizzToRemove;
        private final boolean isDeleteLoading;
        private final boolean isLoading;

        public ViewState(UserBrobizzState brobizzState, boolean z5, String str, boolean z6) {
            Intrinsics.checkNotNullParameter(brobizzState, "brobizzState");
            this.brobizzState = brobizzState;
            this.isLoading = z5;
            this.brobizzToRemove = str;
            this.isDeleteLoading = z6;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, UserBrobizzState userBrobizzState, boolean z5, String str, boolean z6, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                userBrobizzState = viewState.brobizzState;
            }
            if ((i5 & 2) != 0) {
                z5 = viewState.isLoading;
            }
            if ((i5 & 4) != 0) {
                str = viewState.brobizzToRemove;
            }
            if ((i5 & 8) != 0) {
                z6 = viewState.isDeleteLoading;
            }
            return viewState.copy(userBrobizzState, z5, str, z6);
        }

        public final ViewState copy(UserBrobizzState brobizzState, boolean isLoading, String brobizzToRemove, boolean isDeleteLoading) {
            Intrinsics.checkNotNullParameter(brobizzState, "brobizzState");
            return new ViewState(brobizzState, isLoading, brobizzToRemove, isDeleteLoading);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return Intrinsics.areEqual(this.brobizzState, viewState.brobizzState) && this.isLoading == viewState.isLoading && Intrinsics.areEqual(this.brobizzToRemove, viewState.brobizzToRemove) && this.isDeleteLoading == viewState.isDeleteLoading;
        }

        public final UserBrobizzState getBrobizzState() {
            return this.brobizzState;
        }

        public final String getBrobizzToRemove() {
            return this.brobizzToRemove;
        }

        public int hashCode() {
            int hashCode = ((this.brobizzState.hashCode() * 31) + Boolean.hashCode(this.isLoading)) * 31;
            String str = this.brobizzToRemove;
            return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.isDeleteLoading);
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
            return "ViewState(brobizzState=" + this.brobizzState + ", isLoading=" + this.isLoading + ", brobizzToRemove=" + this.brobizzToRemove + ", isDeleteLoading=" + this.isDeleteLoading + ")";
        }

        public /* synthetic */ ViewState(UserBrobizzState userBrobizzState, boolean z5, String str, boolean z6, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? new UserBrobizzState(null, 1, null) : userBrobizzState, (i5 & 2) != 0 ? true : z5, (i5 & 4) != 0 ? null : str, (i5 & 8) != 0 ? false : z6);
        }
    }
}
