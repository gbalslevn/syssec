package dk.molslinjen.ui.views.screens.profile.passengers.edit;

import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.user.passengers.IUserPassengerManager;
import dk.molslinjen.domain.model.account.UserPassenger;
import dk.molslinjen.ui.views.screens.profile.passengers.edit.ProfilePassengerEditViewModel;
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
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.profile.passengers.edit.ProfilePassengerEditViewModel$deletePassenger$1", f = "ProfilePassengerEditViewModel.kt", l = {51}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class ProfilePassengerEditViewModel$deletePassenger$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $finishFlow;
    int label;
    final /* synthetic */ ProfilePassengerEditViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfilePassengerEditViewModel$deletePassenger$1(ProfilePassengerEditViewModel profilePassengerEditViewModel, Function0<Unit> function0, Continuation<? super ProfilePassengerEditViewModel$deletePassenger$1> continuation) {
        super(2, continuation);
        this.this$0 = profilePassengerEditViewModel;
        this.$finishFlow = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ProfilePassengerEditViewModel$deletePassenger$1(this.this$0, this.$finishFlow, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        UserPassenger userPassenger;
        String localId;
        MutableStateFlow mutableStateFlow;
        Object value;
        IUserPassengerManager iUserPassengerManager;
        MutableStateFlow mutableStateFlow2;
        Object value2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            userPassenger = this.this$0.originalPassenger;
            if (userPassenger == null || (localId = userPassenger.getLocalId()) == null) {
                return Unit.INSTANCE;
            }
            mutableStateFlow = this.this$0._viewState;
            do {
                value = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value, ProfilePassengerEditViewModel.ViewState.copy$default((ProfilePassengerEditViewModel.ViewState) value, null, false, true, false, 11, null)));
            iUserPassengerManager = this.this$0.passengersManager;
            this.label = 1;
            obj = iUserPassengerManager.deletePassenger(localId, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        ManagerResult managerResult = (ManagerResult) obj;
        if (managerResult instanceof ManagerResult.Error) {
            mutableStateFlow2 = this.this$0._viewState;
            do {
                value2 = mutableStateFlow2.getValue();
            } while (!mutableStateFlow2.compareAndSet(value2, ProfilePassengerEditViewModel.ViewState.copy$default((ProfilePassengerEditViewModel.ViewState) value2, null, false, false, false, 11, null)));
        } else {
            if (!(managerResult instanceof ManagerResult.Success)) {
                throw new NoWhenBranchMatchedException();
            }
            this.$finishFlow.invoke();
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ProfilePassengerEditViewModel$deletePassenger$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
