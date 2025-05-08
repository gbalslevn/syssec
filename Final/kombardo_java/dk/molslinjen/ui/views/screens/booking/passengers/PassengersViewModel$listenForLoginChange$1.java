package dk.molslinjen.ui.views.screens.booking.passengers;

import dk.molslinjen.domain.managers.user.AuthenticationType;
import dk.molslinjen.domain.managers.user.IUserManager;
import dk.molslinjen.domain.model.booking.DepartureDirection;
import dk.molslinjen.ui.views.screens.booking.passengers.PassengersViewModel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.passengers.PassengersViewModel$listenForLoginChange$1", f = "PassengersViewModel.kt", l = {127}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class PassengersViewModel$listenForLoginChange$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ PassengersViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PassengersViewModel$listenForLoginChange$1(PassengersViewModel passengersViewModel, Continuation<? super PassengersViewModel$listenForLoginChange$1> continuation) {
        super(2, continuation);
        this.this$0 = passengersViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PassengersViewModel$listenForLoginChange$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IUserManager iUserManager;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            iUserManager = this.this$0.userManager;
            StateFlow<AuthenticationType> authenticationType = iUserManager.getAuthenticationType();
            final PassengersViewModel passengersViewModel = this.this$0;
            FlowCollector<? super AuthenticationType> flowCollector = new FlowCollector() { // from class: dk.molslinjen.ui.views.screens.booking.passengers.PassengersViewModel$listenForLoginChange$1.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit((AuthenticationType) obj2, (Continuation<? super Unit>) continuation);
                }

                public final Object emit(AuthenticationType authenticationType2, Continuation<? super Unit> continuation) {
                    DepartureDirection departureDirection = ((PassengersViewModel.ViewState) PassengersViewModel.this._viewState.getValue()).getDepartureDirection();
                    PassengersViewModel.this.loadPassengers(departureDirection, departureDirection == DepartureDirection.Return && !((PassengersViewModel.ViewState) PassengersViewModel.this._viewState.getValue()).getSameReturnPassengersAsOutbound(), true);
                    return Unit.INSTANCE;
                }
            };
            this.label = 1;
            if (authenticationType.collect(flowCollector, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PassengersViewModel$listenForLoginChange$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
