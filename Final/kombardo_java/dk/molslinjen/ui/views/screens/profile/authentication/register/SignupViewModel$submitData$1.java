package dk.molslinjen.ui.views.screens.profile.authentication.register;

import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.domain.analytics.AnalyticsEvent;
import dk.molslinjen.domain.analytics.IAnalyticsTracker;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.user.IUserManager;
import dk.molslinjen.domain.managers.user.UserInfoInput;
import dk.molslinjen.extensions.ManagerResultExtensionsKt;
import dk.molslinjen.ui.views.reusable.model.UIUploadState;
import dk.molslinjen.ui.views.screens.profile.authentication.register.SignupViewModel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.profile.authentication.register.SignupViewModel$submitData$1", f = "SignupViewModel.kt", l = {57, 61}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class SignupViewModel$submitData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SignupViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SignupViewModel$submitData$1(SignupViewModel signupViewModel, Continuation<? super SignupViewModel$submitData$1> continuation) {
        super(2, continuation);
        this.this$0 = signupViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SignupViewModel$submitData$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object value;
        IUserManager iUserManager;
        Object value2;
        IAnalyticsTracker iAnalyticsTracker;
        ISnackbarService iSnackbarService;
        MutableStateFlow mutableStateFlow;
        Object value3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            UserInfoInput value4 = this.this$0.getUserInfoInput().getValue();
            MutableStateFlow mutableStateFlow2 = this.this$0._viewState;
            do {
                value = mutableStateFlow2.getValue();
            } while (!mutableStateFlow2.compareAndSet(value, SignupViewModel.ViewState.copy$default((SignupViewModel.ViewState) value, UIUploadState.Loading, false, null, null, 14, null)));
            iUserManager = this.this$0.userManager;
            this.label = 1;
            obj = iUserManager.createAccount(value4, this);
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
                    value3 = mutableStateFlow.getValue();
                } while (!mutableStateFlow.compareAndSet(value3, SignupViewModel.ViewState.copy$default((SignupViewModel.ViewState) value3, UIUploadState.Idle, false, null, null, 14, null)));
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        }
        ManagerResult managerResult = (ManagerResult) obj;
        if (managerResult instanceof ManagerResult.Error) {
            iSnackbarService = this.this$0.snackbarService;
            this.label = 2;
            if (ManagerResultExtensionsKt.handleError((ManagerResult.Error) managerResult, iSnackbarService, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutableStateFlow = this.this$0._viewState;
            do {
                value3 = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value3, SignupViewModel.ViewState.copy$default((SignupViewModel.ViewState) value3, UIUploadState.Idle, false, null, null, 14, null)));
            return Unit.INSTANCE;
        }
        if (!(managerResult instanceof ManagerResult.Success)) {
            throw new NoWhenBranchMatchedException();
        }
        MutableStateFlow mutableStateFlow3 = this.this$0._viewState;
        do {
            value2 = mutableStateFlow3.getValue();
        } while (!mutableStateFlow3.compareAndSet(value2, SignupViewModel.ViewState.copy$default((SignupViewModel.ViewState) value2, UIUploadState.Success, false, null, null, 14, null)));
        iAnalyticsTracker = this.this$0.analyticsTracker;
        iAnalyticsTracker.trackEvent(new AnalyticsEvent.CreateAccount(((SignupViewModel.ViewState) this.this$0._viewState.getValue()).getOriginRoute()));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SignupViewModel$submitData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
