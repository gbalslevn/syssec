package dk.molslinjen.ui.views.screens.profile.creditcards;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.domain.analytics.IAnalyticsTracker;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.user.creditcards.IUserCreditCardsManager;
import dk.molslinjen.domain.managers.user.creditcards.UserCreditCardsState;
import dk.molslinjen.domain.model.account.CreditCard;
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

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0019B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0011J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/creditcards/ProfileCreditCardsViewModel;", "Landroidx/lifecycle/ViewModel;", "creditCardsManager", "Ldk/molslinjen/domain/managers/user/creditcards/IUserCreditCardsManager;", "snackbarService", "Ldk/molslinjen/core/snackbar/ISnackbarService;", "analyticsTracker", "Ldk/molslinjen/domain/analytics/IAnalyticsTracker;", "<init>", "(Ldk/molslinjen/domain/managers/user/creditcards/IUserCreditCardsManager;Ldk/molslinjen/core/snackbar/ISnackbarService;Ldk/molslinjen/domain/analytics/IAnalyticsTracker;)V", "_viewState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/ui/views/screens/profile/creditcards/ProfileCreditCardsViewModel$ViewState;", "viewState", "getViewState", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "triggerDeleteFlow", BuildConfig.FLAVOR, "card", "Ldk/molslinjen/domain/model/account/CreditCard;", "cancelDeleteCard", "deleteCard", "Lkotlinx/coroutines/Job;", "cardId", BuildConfig.FLAVOR, "ViewState", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ProfileCreditCardsViewModel extends ViewModel {
    private final MutableStateFlow<ViewState> _viewState;
    private final IAnalyticsTracker analyticsTracker;
    private final IUserCreditCardsManager creditCardsManager;
    private final ISnackbarService snackbarService;
    private final MutableStateFlow<ViewState> viewState;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.ui.views.screens.profile.creditcards.ProfileCreditCardsViewModel$1", f = "ProfileCreditCardsViewModel.kt", l = {31, 32}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.ui.views.screens.profile.creditcards.ProfileCreditCardsViewModel$1, reason: invalid class name */
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
                IUserCreditCardsManager iUserCreditCardsManager = ProfileCreditCardsViewModel.this.creditCardsManager;
                this.label = 1;
                obj = iUserCreditCardsManager.loadCreditCards(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i5 != 1) {
                    if (i5 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    mutableStateFlow = ProfileCreditCardsViewModel.this._viewState;
                    do {
                        value = mutableStateFlow.getValue();
                    } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default((ViewState) value, null, false, false, null, 13, null)));
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
            }
            ISnackbarService iSnackbarService = ProfileCreditCardsViewModel.this.snackbarService;
            this.label = 2;
            if (ManagerResultExtensionsKt.handlePotentialError((ManagerResult) obj, iSnackbarService, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutableStateFlow = ProfileCreditCardsViewModel.this._viewState;
            do {
                value = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default((ViewState) value, null, false, false, null, 13, null)));
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.ui.views.screens.profile.creditcards.ProfileCreditCardsViewModel$2", f = "ProfileCreditCardsViewModel.kt", l = {37}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.ui.views.screens.profile.creditcards.ProfileCreditCardsViewModel$2, reason: invalid class name */
    /* loaded from: classes2.dex */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "it", "Ldk/molslinjen/domain/managers/user/creditcards/UserCreditCardsState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "dk.molslinjen.ui.views.screens.profile.creditcards.ProfileCreditCardsViewModel$2$1", f = "ProfileCreditCardsViewModel.kt", l = {}, m = "invokeSuspend")
        /* renamed from: dk.molslinjen.ui.views.screens.profile.creditcards.ProfileCreditCardsViewModel$2$1, reason: invalid class name */
        /* loaded from: classes2.dex */
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<UserCreditCardsState, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ ProfileCreditCardsViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(ProfileCreditCardsViewModel profileCreditCardsViewModel, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = profileCreditCardsViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(UserCreditCardsState userCreditCardsState, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(userCreditCardsState, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object value;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                UserCreditCardsState userCreditCardsState = (UserCreditCardsState) this.L$0;
                MutableStateFlow mutableStateFlow = this.this$0._viewState;
                do {
                    value = mutableStateFlow.getValue();
                } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default((ViewState) value, userCreditCardsState, false, false, null, 14, null)));
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
                StateFlow<UserCreditCardsState> creditCardsState = ProfileCreditCardsViewModel.this.creditCardsManager.getCreditCardsState();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(ProfileCreditCardsViewModel.this, null);
                this.label = 1;
                if (FlowKt.collectLatest(creditCardsState, anonymousClass1, this) == coroutine_suspended) {
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

    public ProfileCreditCardsViewModel(IUserCreditCardsManager creditCardsManager, ISnackbarService snackbarService, IAnalyticsTracker analyticsTracker) {
        Intrinsics.checkNotNullParameter(creditCardsManager, "creditCardsManager");
        Intrinsics.checkNotNullParameter(snackbarService, "snackbarService");
        Intrinsics.checkNotNullParameter(analyticsTracker, "analyticsTracker");
        this.creditCardsManager = creditCardsManager;
        this.snackbarService = snackbarService;
        this.analyticsTracker = analyticsTracker;
        MutableStateFlow<ViewState> MutableStateFlow = StateFlowKt.MutableStateFlow(new ViewState(null, false, false, null, 15, null));
        this._viewState = MutableStateFlow;
        this.viewState = MutableStateFlow;
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass2(null), 3, null);
    }

    public final void cancelDeleteCard() {
        ViewState value;
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, null, false, false, null, 7, null)));
    }

    public final Job deleteCard(String cardId) {
        Job launch$default;
        Intrinsics.checkNotNullParameter(cardId, "cardId");
        launch$default = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ProfileCreditCardsViewModel$deleteCard$1(this, cardId, null), 3, null);
        return launch$default;
    }

    public final MutableStateFlow<ViewState> getViewState() {
        return this.viewState;
    }

    public final void triggerDeleteFlow(CreditCard card) {
        ViewState value;
        Intrinsics.checkNotNullParameter(card, "card");
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, null, false, false, card, 7, null)));
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ:\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u0005\u0010\u001aR\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0019\u001a\u0004\b\u0006\u0010\u001aR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/creditcards/ProfileCreditCardsViewModel$ViewState;", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/managers/user/creditcards/UserCreditCardsState;", "userCreditCardsState", BuildConfig.FLAVOR, "isLoading", "isDeleteLoading", "Ldk/molslinjen/domain/model/account/CreditCard;", "cardToDelete", "<init>", "(Ldk/molslinjen/domain/managers/user/creditcards/UserCreditCardsState;ZZLdk/molslinjen/domain/model/account/CreditCard;)V", "copy", "(Ldk/molslinjen/domain/managers/user/creditcards/UserCreditCardsState;ZZLdk/molslinjen/domain/model/account/CreditCard;)Ldk/molslinjen/ui/views/screens/profile/creditcards/ProfileCreditCardsViewModel$ViewState;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ldk/molslinjen/domain/managers/user/creditcards/UserCreditCardsState;", "getUserCreditCardsState", "()Ldk/molslinjen/domain/managers/user/creditcards/UserCreditCardsState;", "Z", "()Z", "Ldk/molslinjen/domain/model/account/CreditCard;", "getCardToDelete", "()Ldk/molslinjen/domain/model/account/CreditCard;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ViewState {
        private final CreditCard cardToDelete;
        private final boolean isDeleteLoading;
        private final boolean isLoading;
        private final UserCreditCardsState userCreditCardsState;

        public ViewState(UserCreditCardsState userCreditCardsState, boolean z5, boolean z6, CreditCard creditCard) {
            Intrinsics.checkNotNullParameter(userCreditCardsState, "userCreditCardsState");
            this.userCreditCardsState = userCreditCardsState;
            this.isLoading = z5;
            this.isDeleteLoading = z6;
            this.cardToDelete = creditCard;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, UserCreditCardsState userCreditCardsState, boolean z5, boolean z6, CreditCard creditCard, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                userCreditCardsState = viewState.userCreditCardsState;
            }
            if ((i5 & 2) != 0) {
                z5 = viewState.isLoading;
            }
            if ((i5 & 4) != 0) {
                z6 = viewState.isDeleteLoading;
            }
            if ((i5 & 8) != 0) {
                creditCard = viewState.cardToDelete;
            }
            return viewState.copy(userCreditCardsState, z5, z6, creditCard);
        }

        public final ViewState copy(UserCreditCardsState userCreditCardsState, boolean isLoading, boolean isDeleteLoading, CreditCard cardToDelete) {
            Intrinsics.checkNotNullParameter(userCreditCardsState, "userCreditCardsState");
            return new ViewState(userCreditCardsState, isLoading, isDeleteLoading, cardToDelete);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return Intrinsics.areEqual(this.userCreditCardsState, viewState.userCreditCardsState) && this.isLoading == viewState.isLoading && this.isDeleteLoading == viewState.isDeleteLoading && Intrinsics.areEqual(this.cardToDelete, viewState.cardToDelete);
        }

        public final CreditCard getCardToDelete() {
            return this.cardToDelete;
        }

        public final UserCreditCardsState getUserCreditCardsState() {
            return this.userCreditCardsState;
        }

        public int hashCode() {
            int hashCode = ((((this.userCreditCardsState.hashCode() * 31) + Boolean.hashCode(this.isLoading)) * 31) + Boolean.hashCode(this.isDeleteLoading)) * 31;
            CreditCard creditCard = this.cardToDelete;
            return hashCode + (creditCard == null ? 0 : creditCard.hashCode());
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
            return "ViewState(userCreditCardsState=" + this.userCreditCardsState + ", isLoading=" + this.isLoading + ", isDeleteLoading=" + this.isDeleteLoading + ", cardToDelete=" + this.cardToDelete + ")";
        }

        public /* synthetic */ ViewState(UserCreditCardsState userCreditCardsState, boolean z5, boolean z6, CreditCard creditCard, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? new UserCreditCardsState(null, 1, null) : userCreditCardsState, (i5 & 2) != 0 ? true : z5, (i5 & 4) != 0 ? false : z6, (i5 & 8) != 0 ? null : creditCard);
        }
    }
}
