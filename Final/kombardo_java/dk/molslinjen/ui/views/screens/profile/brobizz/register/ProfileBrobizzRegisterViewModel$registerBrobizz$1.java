package dk.molslinjen.ui.views.screens.profile.brobizz.register;

import androidx.appcompat.R$styleable;
import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.user.brobizz.IUserBrobizzManager;
import dk.molslinjen.extensions.ManagerResultExtensionsKt;
import dk.molslinjen.ui.views.screens.profile.brobizz.register.ProfileBrobizzRegisterViewModel;
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
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.profile.brobizz.register.ProfileBrobizzRegisterViewModel$registerBrobizz$1", f = "ProfileBrobizzRegisterViewModel.kt", l = {R$styleable.Toolbar_titleTextColor, 31}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class ProfileBrobizzRegisterViewModel$registerBrobizz$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $finishFlow;
    int label;
    final /* synthetic */ ProfileBrobizzRegisterViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileBrobizzRegisterViewModel$registerBrobizz$1(ProfileBrobizzRegisterViewModel profileBrobizzRegisterViewModel, Function0<Unit> function0, Continuation<? super ProfileBrobizzRegisterViewModel$registerBrobizz$1> continuation) {
        super(2, continuation);
        this.this$0 = profileBrobizzRegisterViewModel;
        this.$finishFlow = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ProfileBrobizzRegisterViewModel$registerBrobizz$1(this.this$0, this.$finishFlow, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MutableStateFlow mutableStateFlow;
        Object value;
        IUserBrobizzManager iUserBrobizzManager;
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
            } while (!mutableStateFlow.compareAndSet(value, ((ProfileBrobizzRegisterViewModel.ViewState) value).copy(true)));
            iUserBrobizzManager = this.this$0.brobizzManager;
            String brobizzNumber = this.this$0.getInputState().getValue().getBrobizzNumber();
            this.label = 1;
            obj = iUserBrobizzManager.registerBrobizz(brobizzNumber, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                if (i5 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                mutableStateFlow2 = this.this$0._viewState;
                do {
                    value2 = mutableStateFlow2.getValue();
                } while (!mutableStateFlow2.compareAndSet(value2, ((ProfileBrobizzRegisterViewModel.ViewState) value2).copy(false)));
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        }
        ManagerResult managerResult = (ManagerResult) obj;
        if (!(managerResult instanceof ManagerResult.Error)) {
            if (!(managerResult instanceof ManagerResult.Success)) {
                throw new NoWhenBranchMatchedException();
            }
            this.$finishFlow.invoke();
            return Unit.INSTANCE;
        }
        iSnackbarService = this.this$0.snackbarService;
        this.label = 2;
        if (ManagerResultExtensionsKt.handleError((ManagerResult.Error) managerResult, iSnackbarService, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        mutableStateFlow2 = this.this$0._viewState;
        do {
            value2 = mutableStateFlow2.getValue();
        } while (!mutableStateFlow2.compareAndSet(value2, ((ProfileBrobizzRegisterViewModel.ViewState) value2).copy(false)));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ProfileBrobizzRegisterViewModel$registerBrobizz$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
