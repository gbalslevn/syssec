package dk.molslinjen.domain.managers.user.passengers;

import dk.molslinjen.domain.model.account.UserPassenger;
import java.util.Collection;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "newPassenger", "Ldk/molslinjen/domain/model/account/UserPassenger;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.user.passengers.UserPassengerManager$registerPassenger$3", f = "UserPassengerManager.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class UserPassengerManager$registerPassenger$3 extends SuspendLambda implements Function2<UserPassenger, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ UserPassengerManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserPassengerManager$registerPassenger$3(UserPassengerManager userPassengerManager, Continuation<? super UserPassengerManager$registerPassenger$3> continuation) {
        super(2, continuation);
        this.this$0 = userPassengerManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        UserPassengerManager$registerPassenger$3 userPassengerManager$registerPassenger$3 = new UserPassengerManager$registerPassenger$3(this.this$0, continuation);
        userPassengerManager$registerPassenger$3.L$0 = obj;
        return userPassengerManager$registerPassenger$3;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(UserPassenger userPassenger, Continuation<? super Unit> continuation) {
        return ((UserPassengerManager$registerPassenger$3) create(userPassenger, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        UserPassengersState value;
        UserPassengersState userPassengersState;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        UserPassenger userPassenger = (UserPassenger) this.L$0;
        MutableStateFlow<UserPassengersState> passengersState = this.this$0.getPassengersState();
        do {
            value = passengersState.getValue();
            userPassengersState = value;
        } while (!passengersState.compareAndSet(value, userPassengersState.copy(CollectionsKt.sortedWith(CollectionsKt.plus((Collection<? extends UserPassenger>) userPassengersState.getPassengers(), userPassenger), new Comparator() { // from class: dk.molslinjen.domain.managers.user.passengers.UserPassengerManager$registerPassenger$3$invokeSuspend$lambda$1$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t5, T t6) {
                return ComparisonsKt.compareValues(((UserPassenger) t5).getFirstName(), ((UserPassenger) t6).getFirstName());
            }
        }))));
        return Unit.INSTANCE;
    }
}
