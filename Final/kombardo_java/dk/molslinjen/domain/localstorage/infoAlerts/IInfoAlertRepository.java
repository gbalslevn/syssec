package dk.molslinjen.domain.localstorage.infoAlerts;

import dk.molslinjen.domain.model.info.InfoAlert;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H¦@¢\u0006\u0002\u0010\u0007J\u0016\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\nJ\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H¦@¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Ldk/molslinjen/domain/localstorage/infoAlerts/IInfoAlertRepository;", BuildConfig.FLAVOR, "update", BuildConfig.FLAVOR, "infoAlerts", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/info/InfoAlert;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setAsShown", "infoAlert", "(Ldk/molslinjen/domain/model/info/InfoAlert;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllNotShown", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IInfoAlertRepository {
    Object getAllNotShown(Continuation<? super List<InfoAlert>> continuation);

    Object setAsShown(InfoAlert infoAlert, Continuation<? super Unit> continuation);

    Object update(List<InfoAlert> list, Continuation<? super Unit> continuation);
}
