package dk.molslinjen.ui.views.screens.profile.edit.changePassword;

import androidx.compose.material3.SnackbarDuration;
import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.core.snackbar.SnackbarEvent;
import dk.molslinjen.core.snackbar.SnackbarText;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.user.IUserManager;
import dk.molslinjen.extensions.ManagerResultExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.screens.profile.edit.changePassword.ChangePasswordViewModel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.profile.edit.changePassword.ChangePasswordViewModel$submit$1", f = "ChangePasswordViewModel.kt", l = {43, 48, 50}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class ChangePasswordViewModel$submit$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $dismiss;
    int label;
    final /* synthetic */ ChangePasswordViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChangePasswordViewModel$submit$1(ChangePasswordViewModel changePasswordViewModel, Function0<Unit> function0, Continuation<? super ChangePasswordViewModel$submit$1> continuation) {
        super(2, continuation);
        this.this$0 = changePasswordViewModel;
        this.$dismiss = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ChangePasswordViewModel$submit$1(this.this$0, this.$dismiss, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MutableStateFlow mutableStateFlow;
        Object value;
        IUserManager iUserManager;
        ISnackbarService iSnackbarService;
        ISnackbarService iSnackbarService2;
        MutableStateFlow mutableStateFlow2;
        Object value2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            mutableStateFlow = this.this$0._viewState;
            do {
                value = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value, ChangePasswordViewModel.ViewState.copy$default((ChangePasswordViewModel.ViewState) value, true, null, null, 6, null)));
            iUserManager = this.this$0.userManager;
            String currentPassword = this.this$0.getViewState().getValue().getCurrentPassword();
            String newPassword = this.this$0.getViewState().getValue().getNewPassword();
            this.label = 1;
            obj = iUserManager.changePassword(currentPassword, newPassword, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                if (i5 == 2) {
                    ResultKt.throwOnFailure(obj);
                    mutableStateFlow2 = this.this$0._viewState;
                    do {
                        value2 = mutableStateFlow2.getValue();
                    } while (!mutableStateFlow2.compareAndSet(value2, ChangePasswordViewModel.ViewState.copy$default((ChangePasswordViewModel.ViewState) value2, false, null, null, 6, null)));
                    return Unit.INSTANCE;
                }
                if (i5 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.$dismiss.invoke();
                mutableStateFlow2 = this.this$0._viewState;
                do {
                    value2 = mutableStateFlow2.getValue();
                } while (!mutableStateFlow2.compareAndSet(value2, ChangePasswordViewModel.ViewState.copy$default((ChangePasswordViewModel.ViewState) value2, false, null, null, 6, null)));
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        }
        ManagerResult managerResult = (ManagerResult) obj;
        if (managerResult instanceof ManagerResult.Error) {
            iSnackbarService2 = this.this$0.snackbarService;
            this.label = 2;
            if (ManagerResultExtensionsKt.handleError((ManagerResult.Error) managerResult, iSnackbarService2, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutableStateFlow2 = this.this$0._viewState;
            do {
                value2 = mutableStateFlow2.getValue();
            } while (!mutableStateFlow2.compareAndSet(value2, ChangePasswordViewModel.ViewState.copy$default((ChangePasswordViewModel.ViewState) value2, false, null, null, 6, null)));
            return Unit.INSTANCE;
        }
        if (!(managerResult instanceof ManagerResult.Success)) {
            throw new NoWhenBranchMatchedException();
        }
        iSnackbarService = this.this$0.snackbarService;
        SnackbarEvent.Default r12 = new SnackbarEvent.Default(new SnackbarText.ResourceText(R.string.changePassword_passwordChanged), null, true, SnackbarDuration.Short, Boxing.boxInt(R.drawable.icon_checkmark_circle), 2, null);
        this.label = 3;
        if (iSnackbarService.publishEvent(r12, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        this.$dismiss.invoke();
        mutableStateFlow2 = this.this$0._viewState;
        do {
            value2 = mutableStateFlow2.getValue();
        } while (!mutableStateFlow2.compareAndSet(value2, ChangePasswordViewModel.ViewState.copy$default((ChangePasswordViewModel.ViewState) value2, false, null, null, 6, null)));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ChangePasswordViewModel$submit$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
