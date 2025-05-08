package dk.molslinjen.api.services.notifications;

import dk.molslinjen.api.services.BaseService;
import dk.molslinjen.api.services.notifications.request.PushTagParameters;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J,\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\nH\u0096@¢\u0006\u0002\u0010\u000fJ\u0016\u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0096@¢\u0006\u0002\u0010\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Ldk/molslinjen/api/services/notifications/NotificationService;", "Ldk/molslinjen/api/services/BaseService;", "Ldk/molslinjen/api/services/notifications/INotificationService;", "api", "Ldk/molslinjen/api/services/notifications/NotificationApi;", "<init>", "(Ldk/molslinjen/api/services/notifications/NotificationApi;)V", "createOrUpdateSubscription", BuildConfig.FLAVOR, "fcmToken", BuildConfig.FLAVOR, "tags", BuildConfig.FLAVOR, "Ldk/molslinjen/api/services/notifications/request/PushTagParameters;", "language", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unsubscribe", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NotificationService extends BaseService implements INotificationService {
    private final NotificationApi api;

    public NotificationService(NotificationApi api) {
        Intrinsics.checkNotNullParameter(api, "api");
        this.api = api;
    }

    @Override // dk.molslinjen.api.services.notifications.INotificationService
    public Object createOrUpdateSubscription(String str, List<PushTagParameters> list, String str2, Continuation<? super Unit> continuation) {
        Object withContextHandlingErrors = withContextHandlingErrors(Dispatchers.getIO(), new NotificationService$createOrUpdateSubscription$2(str, list, str2, this, null), continuation);
        return withContextHandlingErrors == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContextHandlingErrors : Unit.INSTANCE;
    }

    @Override // dk.molslinjen.api.services.notifications.INotificationService
    public Object unsubscribe(String str, Continuation<? super Unit> continuation) {
        Object withContextHandlingErrors = withContextHandlingErrors(Dispatchers.getIO(), new NotificationService$unsubscribe$2(this, str, null), continuation);
        return withContextHandlingErrors == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContextHandlingErrors : Unit.INSTANCE;
    }
}
