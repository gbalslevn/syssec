package dk.molslinjen.ui.views.screens.profile.vehicles.edit;

import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.user.vehicles.IUserVehiclesManager;
import dk.molslinjen.domain.model.account.UserVehicle;
import dk.molslinjen.ui.views.screens.profile.vehicles.edit.ProfileVehiclesEditViewModel;
import kotlin.Metadata;
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
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.profile.vehicles.edit.ProfileVehiclesEditViewModel$updateVehicle$1", f = "ProfileVehiclesEditViewModel.kt", l = {53, 54}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class ProfileVehiclesEditViewModel$updateVehicle$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $onSuccess;
    int label;
    final /* synthetic */ ProfileVehiclesEditViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileVehiclesEditViewModel$updateVehicle$1(ProfileVehiclesEditViewModel profileVehiclesEditViewModel, Function0<Unit> function0, Continuation<? super ProfileVehiclesEditViewModel$updateVehicle$1> continuation) {
        super(2, continuation);
        this.this$0 = profileVehiclesEditViewModel;
        this.$onSuccess = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ProfileVehiclesEditViewModel$updateVehicle$1(this.this$0, this.$onSuccess, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MutableStateFlow mutableStateFlow;
        MutableStateFlow mutableStateFlow2;
        Object value;
        IUserVehiclesManager iUserVehiclesManager;
        Object handleResult;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            mutableStateFlow = this.this$0._viewState;
            UserVehicle originalVehicle = ((ProfileVehiclesEditViewModel.ViewState) mutableStateFlow.getValue()).getOriginalVehicle();
            if (originalVehicle != null) {
                UserVehicle copy$default = UserVehicle.copy$default(originalVehicle, null, this.this$0.getVehicleInput().getValue().getName(), this.this$0.getVehicleInput().getValue().getLicensePlate(), null, null, null, null, 121, null);
                if (copy$default != null) {
                    mutableStateFlow2 = this.this$0._viewState;
                    do {
                        value = mutableStateFlow2.getValue();
                    } while (!mutableStateFlow2.compareAndSet(value, ProfileVehiclesEditViewModel.ViewState.copy$default((ProfileVehiclesEditViewModel.ViewState) value, true, false, null, 6, null)));
                    iUserVehiclesManager = this.this$0.vehiclesManager;
                    this.label = 1;
                    obj = iUserVehiclesManager.updateVehicle(copy$default, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
            return Unit.INSTANCE;
        }
        if (i5 != 1) {
            if (i5 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        ProfileVehiclesEditViewModel profileVehiclesEditViewModel = this.this$0;
        Function0<Unit> function0 = this.$onSuccess;
        this.label = 2;
        handleResult = profileVehiclesEditViewModel.handleResult((ManagerResult) obj, function0, this);
        if (handleResult == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ProfileVehiclesEditViewModel$updateVehicle$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
