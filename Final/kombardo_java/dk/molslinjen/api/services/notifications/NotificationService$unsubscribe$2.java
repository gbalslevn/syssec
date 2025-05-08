package dk.molslinjen.api.services.notifications;

import dk.molslinjen.api.extensions.ResponseExtensionsKt;
import dk.molslinjen.api.helpers.ApiResult;
import dk.molslinjen.api.helpers.NetworkStatus;
import dk.molslinjen.core.log.CriticalLog;
import dk.molslinjen.core.log.Logger;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;
import retrofit2.Response;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Ldk/molslinjen/api/helpers/ApiResult;", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.api.services.notifications.NotificationService$unsubscribe$2", f = "NotificationService.kt", l = {46}, m = "invokeSuspend")
/* loaded from: classes2.dex */
final class NotificationService$unsubscribe$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ApiResult<? extends Unit>>, Object> {
    final /* synthetic */ String $fcmToken;
    int label;
    final /* synthetic */ NotificationService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotificationService$unsubscribe$2(NotificationService notificationService, String str, Continuation<? super NotificationService$unsubscribe$2> continuation) {
        super(2, continuation);
        this.this$0 = notificationService;
        this.$fcmToken = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NotificationService$unsubscribe$2(this.this$0, this.$fcmToken, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super ApiResult<? extends Unit>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super ApiResult<Unit>>) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        NotificationApi notificationApi;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            notificationApi = this.this$0.api;
            String str = this.$fcmToken;
            this.label = 1;
            obj = notificationApi.unsubscribe(str, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        ApiResult response = ResponseExtensionsKt.response((Response) obj);
        if (response instanceof ApiResult.Error) {
            ApiResult.Error error = (ApiResult.Error) response;
            if (error.getNetworkStatus() != NetworkStatus.NoNetwork) {
                Logger logger = Logger.INSTANCE;
                String errorMessage = error.getErrorMessage();
                if (errorMessage == null) {
                    errorMessage = BuildConfig.FLAVOR;
                }
                Logger.log$default(logger, errorMessage, null, 0, 6, null);
                logger.logCritical(new CriticalLog("Push unsubscribe failed"));
            }
        } else {
            if (!(response instanceof ApiResult.Success)) {
                throw new NoWhenBranchMatchedException();
            }
            Logger.log$default(Logger.INSTANCE, "Push unsubscribed", null, 0, 6, null);
        }
        return response;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super ApiResult<Unit>> continuation) {
        return ((NotificationService$unsubscribe$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
