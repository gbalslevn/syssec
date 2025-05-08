package dk.molslinjen.domain.managers.user.passengers;

import dk.molslinjen.api.services.account.passenger.response.AccountPassengerDTO;
import dk.molslinjen.domain.model.account.UserPassenger;
import java.util.ArrayList;
import java.util.Iterator;
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
import kotlinx.coroutines.flow.MutableStateFlow;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "passengers", BuildConfig.FLAVOR, "Ldk/molslinjen/api/services/account/passenger/response/AccountPassengerDTO;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.user.passengers.UserPassengerManager$loadPassengers$2", f = "UserPassengerManager.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class UserPassengerManager$loadPassengers$2 extends SuspendLambda implements Function2<List<? extends AccountPassengerDTO>, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ UserPassengerManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserPassengerManager$loadPassengers$2(UserPassengerManager userPassengerManager, Continuation<? super UserPassengerManager$loadPassengers$2> continuation) {
        super(2, continuation);
        this.this$0 = userPassengerManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        UserPassengerManager$loadPassengers$2 userPassengerManager$loadPassengers$2 = new UserPassengerManager$loadPassengers$2(this.this$0, continuation);
        userPassengerManager$loadPassengers$2.L$0 = obj;
        return userPassengerManager$loadPassengers$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(List<? extends AccountPassengerDTO> list, Continuation<? super Unit> continuation) {
        return invoke2((List<AccountPassengerDTO>) list, continuation);
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
        List list = (List) this.L$0;
        MutableStateFlow<UserPassengersState> passengersState = this.this$0.getPassengersState();
        do {
            value = passengersState.getValue();
            userPassengersState = value;
            List list2 = list;
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(new UserPassenger((AccountPassengerDTO) it.next()));
            }
        } while (!passengersState.compareAndSet(value, userPassengersState.copy(arrayList)));
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(List<AccountPassengerDTO> list, Continuation<? super Unit> continuation) {
        return ((UserPassengerManager$loadPassengers$2) create(list, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
