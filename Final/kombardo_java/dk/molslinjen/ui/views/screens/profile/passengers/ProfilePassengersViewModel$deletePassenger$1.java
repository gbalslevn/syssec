package dk.molslinjen.ui.views.screens.profile.passengers;

import dk.molslinjen.domain.managers.user.passengers.IUserPassengerManager;
import dk.molslinjen.domain.model.account.UserPassenger;
import dk.molslinjen.ui.views.screens.profile.passengers.ProfilePassengersViewModel;
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
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.profile.passengers.ProfilePassengersViewModel$deletePassenger$1", f = "ProfilePassengersViewModel.kt", l = {79}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class ProfilePassengersViewModel$deletePassenger$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ UserPassenger $passenger;
    int label;
    final /* synthetic */ ProfilePassengersViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfilePassengersViewModel$deletePassenger$1(ProfilePassengersViewModel profilePassengersViewModel, UserPassenger userPassenger, Continuation<? super ProfilePassengersViewModel$deletePassenger$1> continuation) {
        super(2, continuation);
        this.this$0 = profilePassengersViewModel;
        this.$passenger = userPassenger;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ProfilePassengersViewModel$deletePassenger$1(this.this$0, this.$passenger, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object value;
        Object value2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            MutableStateFlow mutableStateFlow = this.this$0._viewState;
            do {
                value = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value, ProfilePassengersViewModel.ViewState.copy$default((ProfilePassengersViewModel.ViewState) value, null, null, false, null, true, 15, null)));
            IUserPassengerManager iUserPassengerManager = this.this$0.passengerManager;
            String localId = this.$passenger.getLocalId();
            this.label = 1;
            if (iUserPassengerManager.deletePassenger(localId, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        MutableStateFlow mutableStateFlow2 = this.this$0._viewState;
        do {
            value2 = mutableStateFlow2.getValue();
        } while (!mutableStateFlow2.compareAndSet(value2, ProfilePassengersViewModel.ViewState.copy$default((ProfilePassengersViewModel.ViewState) value2, null, null, false, null, false, 7, null)));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ProfilePassengersViewModel$deletePassenger$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
