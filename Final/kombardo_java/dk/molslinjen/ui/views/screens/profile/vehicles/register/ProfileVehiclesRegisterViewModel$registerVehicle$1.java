package dk.molslinjen.ui.views.screens.profile.vehicles.register;

import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.user.vehicles.IUserVehiclesManager;
import dk.molslinjen.domain.model.account.LicensePlateValidation;
import dk.molslinjen.extensions.ManagerResultExtensionsKt;
import dk.molslinjen.ui.views.screens.profile.vehicles.register.ProfileVehiclesRegisterViewModel;
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
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.profile.vehicles.register.ProfileVehiclesRegisterViewModel$registerVehicle$1", f = "ProfileVehiclesRegisterViewModel.kt", l = {62, 70}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class ProfileVehiclesRegisterViewModel$registerVehicle$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $finishFlow;
    int label;
    final /* synthetic */ ProfileVehiclesRegisterViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileVehiclesRegisterViewModel$registerVehicle$1(ProfileVehiclesRegisterViewModel profileVehiclesRegisterViewModel, Function0<Unit> function0, Continuation<? super ProfileVehiclesRegisterViewModel$registerVehicle$1> continuation) {
        super(2, continuation);
        this.this$0 = profileVehiclesRegisterViewModel;
        this.$finishFlow = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ProfileVehiclesRegisterViewModel$registerVehicle$1(this.this$0, this.$finishFlow, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MutableStateFlow mutableStateFlow;
        Object value;
        IUserVehiclesManager iUserVehiclesManager;
        MutableStateFlow mutableStateFlow2;
        ISnackbarService iSnackbarService;
        MutableStateFlow mutableStateFlow3;
        Object value2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            mutableStateFlow = this.this$0._viewState;
            do {
                value = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value, ProfileVehiclesRegisterViewModel.ViewState.copy$default((ProfileVehiclesRegisterViewModel.ViewState) value, null, true, 1, null)));
            iUserVehiclesManager = this.this$0.vehiclesManager;
            String name = this.this$0.getVehicleInput().getValue().getName();
            String licensePlate = this.this$0.getVehicleInput().getValue().getLicensePlate();
            mutableStateFlow2 = this.this$0._viewState;
            LicensePlateValidation.Valid licensePlaceValidation = ((ProfileVehiclesRegisterViewModel.ViewState) mutableStateFlow2.getValue()).getLicensePlaceValidation();
            this.label = 1;
            obj = iUserVehiclesManager.registerVehicle(name, licensePlate, licensePlaceValidation, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                if (i5 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                mutableStateFlow3 = this.this$0._viewState;
                do {
                    value2 = mutableStateFlow3.getValue();
                } while (!mutableStateFlow3.compareAndSet(value2, ((ProfileVehiclesRegisterViewModel.ViewState) value2).copy(null, false)));
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
        mutableStateFlow3 = this.this$0._viewState;
        do {
            value2 = mutableStateFlow3.getValue();
        } while (!mutableStateFlow3.compareAndSet(value2, ((ProfileVehiclesRegisterViewModel.ViewState) value2).copy(null, false)));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ProfileVehiclesRegisterViewModel$registerVehicle$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
