package dk.molslinjen.domain.managers.notification;

import dk.molslinjen.domain.model.push.PushMessage;
import dk.molslinjen.domain.model.push.PushTag;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.StateFlow;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H¦@¢\u0006\u0002\u0010\tJ\u0016\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0005H&J\u000e\u0010\u0013\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u000eH&J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u000eH&R\u001a\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0018"}, d2 = {"Ldk/molslinjen/domain/managers/notification/INotificationManager;", BuildConfig.FLAVOR, "createOrUpdateSubscription", BuildConfig.FLAVOR, "fcmToken", BuildConfig.FLAVOR, "tags", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/push/PushTag;", "(Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unsubscribe", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "pushMessageReadyToShownInDialog", "Lkotlinx/coroutines/flow/StateFlow;", "Ldk/molslinjen/domain/model/push/PushMessage;", "getPushMessageReadyToShownInDialog", "()Lkotlinx/coroutines/flow/StateFlow;", "setToken", "token", "awaitNonNullToken", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "markPushMessageAsShownInDialog", "pushMessage", "addPushMessageToShowInDialog", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface INotificationManager {
    void addPushMessageToShowInDialog(PushMessage pushMessage);

    Object awaitNonNullToken(Continuation<? super String> continuation);

    Object createOrUpdateSubscription(String str, List<PushTag> list, Continuation<? super Unit> continuation);

    StateFlow<PushMessage> getPushMessageReadyToShownInDialog();

    void markPushMessageAsShownInDialog(PushMessage pushMessage);

    void setToken(String token);

    Object unsubscribe(String str, Continuation<? super Unit> continuation);
}
