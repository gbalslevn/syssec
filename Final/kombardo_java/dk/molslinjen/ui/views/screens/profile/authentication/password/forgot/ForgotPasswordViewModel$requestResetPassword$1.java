package dk.molslinjen.ui.views.screens.profile.authentication.password.forgot;

import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.user.IUserManager;
import dk.molslinjen.extensions.ManagerResultExtensionsKt;
import dk.molslinjen.ui.views.reusable.model.UIUploadState;
import dk.molslinjen.ui.views.screens.profile.authentication.password.forgot.ForgotPasswordViewModel;
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
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.profile.authentication.password.forgot.ForgotPasswordViewModel$requestResetPassword$1", f = "ForgotPasswordViewModel.kt", l = {31, 33}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class ForgotPasswordViewModel$requestResetPassword$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ForgotPasswordViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForgotPasswordViewModel$requestResetPassword$1(ForgotPasswordViewModel forgotPasswordViewModel, Continuation<? super ForgotPasswordViewModel$requestResetPassword$1> continuation) {
        super(2, continuation);
        this.this$0 = forgotPasswordViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ForgotPasswordViewModel$requestResetPassword$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MutableStateFlow mutableStateFlow;
        Object value;
        IUserManager iUserManager;
        UIUploadState uIUploadState;
        ISnackbarService iSnackbarService;
        MutableStateFlow mutableStateFlow2;
        Object value2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            mutableStateFlow = this.this$0._viewState;
            do {
                value = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value, ForgotPasswordViewModel.ViewState.copy$default((ForgotPasswordViewModel.ViewState) value, null, UIUploadState.Loading, 1, null)));
            iUserManager = this.this$0.userManager;
            String email = this.this$0.getViewState().getValue().getEmail();
            this.label = 1;
            obj = iUserManager.forgotPassword(email, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                if (i5 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                uIUploadState = UIUploadState.Idle;
                mutableStateFlow2 = this.this$0._viewState;
                do {
                    value2 = mutableStateFlow2.getValue();
                } while (!mutableStateFlow2.compareAndSet(value2, ForgotPasswordViewModel.ViewState.copy$default((ForgotPasswordViewModel.ViewState) value2, null, uIUploadState, 1, null)));
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        }
        ManagerResult managerResult = (ManagerResult) obj;
        if (!(managerResult instanceof ManagerResult.Error)) {
            if (!(managerResult instanceof ManagerResult.Success)) {
                throw new NoWhenBranchMatchedException();
            }
            uIUploadState = UIUploadState.Success;
            mutableStateFlow2 = this.this$0._viewState;
            do {
                value2 = mutableStateFlow2.getValue();
            } while (!mutableStateFlow2.compareAndSet(value2, ForgotPasswordViewModel.ViewState.copy$default((ForgotPasswordViewModel.ViewState) value2, null, uIUploadState, 1, null)));
            return Unit.INSTANCE;
        }
        iSnackbarService = this.this$0.snackbarService;
        this.label = 2;
        if (ManagerResultExtensionsKt.handleError((ManagerResult.Error) managerResult, iSnackbarService, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        uIUploadState = UIUploadState.Idle;
        mutableStateFlow2 = this.this$0._viewState;
        do {
            value2 = mutableStateFlow2.getValue();
        } while (!mutableStateFlow2.compareAndSet(value2, ForgotPasswordViewModel.ViewState.copy$default((ForgotPasswordViewModel.ViewState) value2, null, uIUploadState, 1, null)));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ForgotPasswordViewModel$requestResetPassword$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
