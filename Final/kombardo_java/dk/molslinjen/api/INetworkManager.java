package dk.molslinjen.api;

import dk.molslinjen.core.ApiEnvironment;
import dk.molslinjen.core.Environment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlinx.coroutines.flow.Flow;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J5\u0010\u0007\u001a\u0002H\b\"\u0004\b\u0000\u0010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH&¢\u0006\u0002\u0010\u000fJ5\u0010\u0010\u001a\u0002H\b\"\u0004\b\u0000\u0010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH&¢\u0006\u0002\u0010\u000fJ5\u0010\u0011\u001a\u0002H\b\"\u0004\b\u0000\u0010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH&¢\u0006\u0002\u0010\u000fJ5\u0010\u0012\u001a\u0002H\b\"\u0004\b\u0000\u0010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH&¢\u0006\u0002\u0010\u000fJ\b\u0010\u0013\u001a\u00020\u0014H\u0002R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0015"}, d2 = {"Ldk/molslinjen/api/INetworkManager;", BuildConfig.FLAVOR, "onUnauthorized", "Lkotlinx/coroutines/flow/Flow;", BuildConfig.FLAVOR, "getOnUnauthorized", "()Lkotlinx/coroutines/flow/Flow;", "createApiService", "T", "serviceType", "Ljava/lang/Class;", "baseUrl", BuildConfig.FLAVOR, "timeoutInSeconds", BuildConfig.FLAVOR, "(Ljava/lang/Class;Ljava/lang/String;I)Ljava/lang/Object;", "createNotificationService", "createRetailItsService", "createPaymentService", "apiEnvironment", "Ldk/molslinjen/core/ApiEnvironment;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface INetworkManager {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        private static ApiEnvironment apiEnvironment(INetworkManager iNetworkManager) {
            return ApiEnvironment.INSTANCE.from(Environment.INSTANCE.current());
        }

        public static /* synthetic */ Object createApiService$default(INetworkManager iNetworkManager, Class cls, String str, int i5, int i6, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createApiService");
            }
            if ((i6 & 2) != 0) {
                str = ApiEnvironmentExtensionsKt.getVerticaApiUrl(apiEnvironment(iNetworkManager));
            }
            if ((i6 & 4) != 0) {
                i5 = 60;
            }
            return iNetworkManager.createApiService(cls, str, i5);
        }

        public static /* synthetic */ Object createNotificationService$default(INetworkManager iNetworkManager, Class cls, String str, int i5, int i6, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createNotificationService");
            }
            if ((i6 & 2) != 0) {
                str = ApiEnvironmentExtensionsKt.getBaseNotificationServiceApiUrl(apiEnvironment(iNetworkManager));
            }
            if ((i6 & 4) != 0) {
                i5 = 60;
            }
            return iNetworkManager.createNotificationService(cls, str, i5);
        }

        public static /* synthetic */ Object createPaymentService$default(INetworkManager iNetworkManager, Class cls, String str, int i5, int i6, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createPaymentService");
            }
            if ((i6 & 2) != 0) {
                str = ApiConstants$Payment.INSTANCE.getPaymentServiceBaseUrl();
            }
            if ((i6 & 4) != 0) {
                i5 = 60;
            }
            return iNetworkManager.createPaymentService(cls, str, i5);
        }

        public static /* synthetic */ Object createRetailItsService$default(INetworkManager iNetworkManager, Class cls, String str, int i5, int i6, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createRetailItsService");
            }
            if ((i6 & 2) != 0) {
                str = ApiEnvironmentExtensionsKt.getBaseRetailItsUrl(apiEnvironment(iNetworkManager));
            }
            if ((i6 & 4) != 0) {
                i5 = 60;
            }
            return iNetworkManager.createRetailItsService(cls, str, i5);
        }
    }

    <T> T createApiService(Class<T> serviceType, String baseUrl, int timeoutInSeconds);

    <T> T createNotificationService(Class<T> serviceType, String baseUrl, int timeoutInSeconds);

    <T> T createPaymentService(Class<T> serviceType, String baseUrl, int timeoutInSeconds);

    <T> T createRetailItsService(Class<T> serviceType, String baseUrl, int timeoutInSeconds);

    Flow<Unit> getOnUnauthorized();
}
