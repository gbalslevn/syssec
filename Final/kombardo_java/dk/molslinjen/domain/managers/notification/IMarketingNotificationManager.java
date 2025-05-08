package dk.molslinjen.domain.managers.notification;

import dk.molslinjen.domain.model.constants.Constants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.conscrypt.BuildConfig;
import uniffi.molslinjen_shared.AgillicReportId;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002H¦@¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002H¦@¢\u0006\u0004\b\u0005\u0010\u0004J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H¦@¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Ldk/molslinjen/domain/managers/notification/IMarketingNotificationManager;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "register", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withdrawConsent", "Luniffi/molslinjen_shared/AgillicReportId;", Constants.IntentExtra.ReportId, "trackOpenedNotification", "(Luniffi/molslinjen_shared/AgillicReportId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IMarketingNotificationManager {
    Object register(Continuation<? super Unit> continuation);

    Object trackOpenedNotification(AgillicReportId agillicReportId, Continuation<? super Unit> continuation);

    Object withdrawConsent(Continuation<? super Unit> continuation);
}
