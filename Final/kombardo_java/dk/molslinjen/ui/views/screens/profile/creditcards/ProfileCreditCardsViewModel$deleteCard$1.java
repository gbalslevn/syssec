package dk.molslinjen.ui.views.screens.profile.creditcards;

import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.domain.analytics.AnalyticsEvent;
import dk.molslinjen.domain.analytics.IAnalyticsTracker;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.user.creditcards.IUserCreditCardsManager;
import dk.molslinjen.extensions.ManagerResultExtensionsKt;
import dk.molslinjen.ui.views.screens.profile.creditcards.ProfileCreditCardsViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.profile.creditcards.ProfileCreditCardsViewModel$deleteCard$1", f = "ProfileCreditCardsViewModel.kt", l = {50, 51}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class ProfileCreditCardsViewModel$deleteCard$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $cardId;
    int label;
    final /* synthetic */ ProfileCreditCardsViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileCreditCardsViewModel$deleteCard$1(ProfileCreditCardsViewModel profileCreditCardsViewModel, String str, Continuation<? super ProfileCreditCardsViewModel$deleteCard$1> continuation) {
        super(2, continuation);
        this.this$0 = profileCreditCardsViewModel;
        this.$cardId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ProfileCreditCardsViewModel$deleteCard$1(this.this$0, this.$cardId, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object value;
        MutableStateFlow mutableStateFlow;
        Object value2;
        IAnalyticsTracker iAnalyticsTracker;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            MutableStateFlow mutableStateFlow2 = this.this$0._viewState;
            do {
                value = mutableStateFlow2.getValue();
            } while (!mutableStateFlow2.compareAndSet(value, ProfileCreditCardsViewModel.ViewState.copy$default((ProfileCreditCardsViewModel.ViewState) value, null, false, true, null, 11, null)));
            IUserCreditCardsManager iUserCreditCardsManager = this.this$0.creditCardsManager;
            String str = this.$cardId;
            this.label = 1;
            obj = iUserCreditCardsManager.deleteCreditCard(str, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                if (i5 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                mutableStateFlow = this.this$0._viewState;
                do {
                    value2 = mutableStateFlow.getValue();
                } while (!mutableStateFlow.compareAndSet(value2, ProfileCreditCardsViewModel.ViewState.copy$default((ProfileCreditCardsViewModel.ViewState) value2, null, false, false, null, 3, null)));
                iAnalyticsTracker = this.this$0.analyticsTracker;
                iAnalyticsTracker.trackEvent(AnalyticsEvent.RemovedSavedCardEvent.INSTANCE);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        }
        ISnackbarService iSnackbarService = this.this$0.snackbarService;
        this.label = 2;
        if (ManagerResultExtensionsKt.handlePotentialError((ManagerResult) obj, iSnackbarService, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        mutableStateFlow = this.this$0._viewState;
        do {
            value2 = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value2, ProfileCreditCardsViewModel.ViewState.copy$default((ProfileCreditCardsViewModel.ViewState) value2, null, false, false, null, 3, null)));
        iAnalyticsTracker = this.this$0.analyticsTracker;
        iAnalyticsTracker.trackEvent(AnalyticsEvent.RemovedSavedCardEvent.INSTANCE);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ProfileCreditCardsViewModel$deleteCard$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
