package dk.molslinjen.domain.localstorage.passengers;

import dk.molslinjen.domain.model.account.UserPassenger;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H¦@¢\u0006\u0002\u0010\u0005J\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\bH¦@¢\u0006\u0002\u0010\tJ\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H¦@¢\u0006\u0002\u0010\rJ\u0016\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0004H¦@¢\u0006\u0002\u0010\rJ\u000e\u0010\u0010\u001a\u00020\u000bH¦@¢\u0006\u0002\u0010\u0005¨\u0006\u0011"}, d2 = {"Ldk/molslinjen/domain/localstorage/passengers/IPassengerRepository;", BuildConfig.FLAVOR, "getPassengers", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/account/UserPassenger;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deletePassenger", "passengerId", BuildConfig.FLAVOR, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updatePassenger", BuildConfig.FLAVOR, "updatedPassenger", "(Ldk/molslinjen/domain/model/account/UserPassenger;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "save", "passenger", "clear", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IPassengerRepository {
    Object clear(Continuation<? super Boolean> continuation);

    Object deletePassenger(String str, Continuation<? super List<UserPassenger>> continuation);

    Object getPassengers(Continuation<? super List<UserPassenger>> continuation);

    Object save(UserPassenger userPassenger, Continuation<? super Boolean> continuation);

    Object updatePassenger(UserPassenger userPassenger, Continuation<? super Boolean> continuation);
}
