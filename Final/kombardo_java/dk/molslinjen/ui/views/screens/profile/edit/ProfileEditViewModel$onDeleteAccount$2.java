package dk.molslinjen.ui.views.screens.profile.edit;

import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.user.IUserManager;
import dk.molslinjen.extensions.ManagerResultExtensionsKt;
import dk.molslinjen.ui.views.screens.profile.edit.ProfileEditViewModel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.profile.edit.ProfileEditViewModel$onDeleteAccount$2", f = "ProfileEditViewModel.kt", l = {70, 71}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class ProfileEditViewModel$onDeleteAccount$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $dismissFlow;
    int label;
    final /* synthetic */ ProfileEditViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileEditViewModel$onDeleteAccount$2(ProfileEditViewModel profileEditViewModel, Function0<Unit> function0, Continuation<? super ProfileEditViewModel$onDeleteAccount$2> continuation) {
        super(2, continuation);
        this.this$0 = profileEditViewModel;
        this.$dismissFlow = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ProfileEditViewModel$onDeleteAccount$2(this.this$0, this.$dismissFlow, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IUserManager iUserManager;
        ISnackbarService iSnackbarService;
        MutableStateFlow mutableStateFlow;
        Object value;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            iUserManager = this.this$0.userManager;
            this.label = 1;
            obj = iUserManager.deleteAccount(this);
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
                    value = mutableStateFlow.getValue();
                } while (!mutableStateFlow.compareAndSet(value, ProfileEditViewModel.ViewState.copy$default((ProfileEditViewModel.ViewState) value, false, null, null, null, false, false, 31, null)));
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
        } else {
            if (!(managerResult instanceof ManagerResult.Success)) {
                throw new NoWhenBranchMatchedException();
            }
            this.$dismissFlow.invoke();
        }
        mutableStateFlow = this.this$0._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ProfileEditViewModel.ViewState.copy$default((ProfileEditViewModel.ViewState) value, false, null, null, null, false, false, 31, null)));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ProfileEditViewModel$onDeleteAccount$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
