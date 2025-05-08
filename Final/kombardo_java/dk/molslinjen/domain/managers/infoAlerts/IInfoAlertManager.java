package dk.molslinjen.domain.managers.infoAlerts;

import dk.molslinjen.domain.managers.infoAlerts.InfoAlertManager;
import dk.molslinjen.domain.model.info.InfoAlert;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.StateFlow;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0007\u001a\u00020\bH¦@¢\u0006\u0002\u0010\tJ\u0016\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH¦@¢\u0006\u0002\u0010\rR\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, d2 = {"Ldk/molslinjen/domain/managers/infoAlerts/IInfoAlertManager;", BuildConfig.FLAVOR, "infoAlertsState", "Lkotlinx/coroutines/flow/StateFlow;", "Ldk/molslinjen/domain/managers/infoAlerts/InfoAlertManager$InfoAlertsState;", "getInfoAlertsState", "()Lkotlinx/coroutines/flow/StateFlow;", "updateInfoAlerts", BuildConfig.FLAVOR, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setAsShown", "infoAlert", "Ldk/molslinjen/domain/model/info/InfoAlert;", "(Ldk/molslinjen/domain/model/info/InfoAlert;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IInfoAlertManager {
    StateFlow<InfoAlertManager.InfoAlertsState> getInfoAlertsState();

    Object setAsShown(InfoAlert infoAlert, Continuation<? super Unit> continuation);

    Object updateInfoAlerts(Continuation<? super Unit> continuation);
}
