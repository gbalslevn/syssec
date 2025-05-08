package dk.molslinjen.domain.localstorage.agreements.multiride;

import dk.molslinjen.domain.model.agreement.multiRide.MultiRideCard;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H¦@¢\u0006\u0002\u0010\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004H¦@¢\u0006\u0002\u0010\tJ\u001c\u0010\n\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H¦@¢\u0006\u0002\u0010\fJ\u000e\u0010\r\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\u0005¨\u0006\u000e"}, d2 = {"Ldk/molslinjen/domain/localstorage/agreements/multiride/IMultiRideRepository;", BuildConfig.FLAVOR, "getMultiRides", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideCard;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "save", BuildConfig.FLAVOR, "multiRide", "(Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideCard;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveAll", "multiRides", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clear", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IMultiRideRepository {
    Object clear(Continuation<? super Boolean> continuation);

    Object getMultiRides(Continuation<? super List<MultiRideCard>> continuation);

    Object save(MultiRideCard multiRideCard, Continuation<? super Boolean> continuation);

    Object saveAll(List<MultiRideCard> list, Continuation<? super Boolean> continuation);
}
