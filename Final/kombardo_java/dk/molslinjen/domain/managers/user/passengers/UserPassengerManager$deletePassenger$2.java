package dk.molslinjen.domain.managers.user.passengers;

import dk.molslinjen.domain.model.account.UserPassenger;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "it"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.user.passengers.UserPassengerManager$deletePassenger$2", f = "UserPassengerManager.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class UserPassengerManager$deletePassenger$2 extends SuspendLambda implements Function2<Unit, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $passengerLocalId;
    int label;
    final /* synthetic */ UserPassengerManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserPassengerManager$deletePassenger$2(UserPassengerManager userPassengerManager, String str, Continuation<? super UserPassengerManager$deletePassenger$2> continuation) {
        super(2, continuation);
        this.this$0 = userPassengerManager;
        this.$passengerLocalId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UserPassengerManager$deletePassenger$2(this.this$0, this.$passengerLocalId, continuation);
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
        MutableStateFlow<UserPassengersState> passengersState = this.this$0.getPassengersState();
        String str = this.$passengerLocalId;
        do {
            value = passengersState.getValue();
            userPassengersState = value;
            List<UserPassenger> passengers = userPassengersState.getPassengers();
            arrayList = new ArrayList();
            for (Object obj2 : passengers) {
                if (!Intrinsics.areEqual(((UserPassenger) obj2).getRemoteId(), str)) {
                    arrayList.add(obj2);
                }
            }
        } while (!passengersState.compareAndSet(value, userPassengersState.copy(arrayList)));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Unit unit, Continuation<? super Unit> continuation) {
        return ((UserPassengerManager$deletePassenger$2) create(unit, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
