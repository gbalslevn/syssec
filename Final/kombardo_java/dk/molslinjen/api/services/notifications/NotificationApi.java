package dk.molslinjen.api.services.notifications;

import dk.molslinjen.api.helpers.retry.Retry;
import dk.molslinjen.api.services.notifications.request.CreateOrUpdatePushSubscriptionParameters;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.conscrypt.BuildConfig;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.POST;
import retrofit2.http.Query;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\ba\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\t\u001a\u00020\nH§@¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Ldk/molslinjen/api/services/notifications/NotificationApi;", BuildConfig.FLAVOR, "subscribe", "Lretrofit2/Response;", BuildConfig.FLAVOR, "parameters", "Ldk/molslinjen/api/services/notifications/request/CreateOrUpdatePushSubscriptionParameters;", "(Ldk/molslinjen/api/services/notifications/request/CreateOrUpdatePushSubscriptionParameters;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unsubscribe", "fcmToken", BuildConfig.FLAVOR, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface NotificationApi {
    @POST("subscribers/createorupdate")
    @Retry
    Object subscribe(@Body CreateOrUpdatePushSubscriptionParameters createOrUpdatePushSubscriptionParameters, Continuation<Response<Unit>> continuation);

    @DELETE("subscribers/deletesubscriber")
    @Retry
    Object unsubscribe(@Query("userId") String str, Continuation<Response<Unit>> continuation);
}
