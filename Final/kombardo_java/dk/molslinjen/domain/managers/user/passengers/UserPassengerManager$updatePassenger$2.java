package dk.molslinjen.domain.managers.user.passengers;

import dk.molslinjen.api.services.account.passenger.response.AccountPassengerDTO;
import dk.molslinjen.domain.model.account.UserPassenger;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "resultPassenger", "Ldk/molslinjen/api/services/account/passenger/response/AccountPassengerDTO;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.user.passengers.UserPassengerManager$updatePassenger$2", f = "UserPassengerManager.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class UserPassengerManager$updatePassenger$2 extends SuspendLambda implements Function2<AccountPassengerDTO, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ UserPassengerManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserPassengerManager$updatePassenger$2(UserPassengerManager userPassengerManager, Continuation<? super UserPassengerManager$updatePassenger$2> continuation) {
        super(2, continuation);
        this.this$0 = userPassengerManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        UserPassengerManager$updatePassenger$2 userPassengerManager$updatePassenger$2 = new UserPassengerManager$updatePassenger$2(this.this$0, continuation);
        userPassengerManager$updatePassenger$2.L$0 = obj;
        return userPassengerManager$updatePassenger$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(AccountPassengerDTO accountPassengerDTO, Continuation<? super Unit> continuation) {
        return ((UserPassengerManager$updatePassenger$2) create(accountPassengerDTO, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        UserPassengersState value;
        UserPassengersState userPassengersState;
        ArrayList arrayList;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        AccountPassengerDTO accountPassengerDTO = (AccountPassengerDTO) this.L$0;
        MutableStateFlow<UserPassengersState> passengersState = this.this$0.getPassengersState();
        do {
            value = passengersState.getValue();
            userPassengersState = value;
            List<UserPassenger> passengers = userPassengersState.getPassengers();
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(passengers, 10));
            for (UserPassenger userPassenger : passengers) {
                if (Intrinsics.areEqual(userPassenger.getRemoteId(), accountPassengerDTO.getId())) {
                    userPassenger = new UserPassenger(accountPassengerDTO);
                }
                arrayList.add(userPassenger);
            }
        } while (!passengersState.compareAndSet(value, userPassengersState.copy(arrayList)));
        return Unit.INSTANCE;
    }
}
