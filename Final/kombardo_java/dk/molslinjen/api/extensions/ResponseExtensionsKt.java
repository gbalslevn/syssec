package dk.molslinjen.api.extensions;

import dk.molslinjen.api.helpers.ApiErrorDTO;
import dk.molslinjen.api.helpers.ApiResult;
import dk.molslinjen.api.helpers.NetworkStatus;
import dk.molslinjen.core.log.CriticalLog;
import dk.molslinjen.core.log.Logger;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.Json;
import okhttp3.Request;
import okhttp3.ResponseBody;
import org.conscrypt.BuildConfig;
import retrofit2.Response;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u001a \u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0004\u001a\"\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0002\u001a\u001c\u0010\u0006\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u00022\f\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0002¨\u0006\b"}, d2 = {"response", "Ldk/molslinjen/api/helpers/ApiResult;", "T", BuildConfig.FLAVOR, "Lretrofit2/Response;", "request", "logError", BuildConfig.FLAVOR, "api_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class ResponseExtensionsKt {
    private static final <T> void logError(Response<T> response) {
        int code = response.code();
        String url = response.raw().getRequest().getUrl().getUrl();
        ArrayList arrayList = new ArrayList();
        arrayList.add("API call failed: " + url);
        arrayList.add("Status code: " + code);
        ResponseBody errorBody = response.errorBody();
        if (errorBody != null) {
            arrayList.add("Error message: " + errorBody.string());
        }
        Logger.INSTANCE.logCritical(new CriticalLog(CollectionsKt.joinToString$default(arrayList, "\n", null, null, 0, null, null, 62, null)));
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x014b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final <T> ApiResult<T> request(Response<T> response) {
        String str;
        ApiErrorDTO apiErrorDTO;
        int code;
        NetworkStatus networkStatus;
        T body = response.body();
        if (response.isSuccessful()) {
            Logger logger = Logger.INSTANCE;
            Logger.log$default(logger, "Network success status code: " + response.code() + " for url: " + response.raw().getRequest().getUrl(), "NetworkManager", 0, 4, null);
            if (body != null) {
                return new ApiResult.Success(body);
            }
            if (response.code() == 204) {
                Logger.log$default(logger, "NetworkManager: ResponseBody is null, but status code is 204. Returning Unit", "NetworkManager", 0, 4, null);
                return new ApiResult.Success(Unit.INSTANCE);
            }
            logger.logCriticalThenFatalError(new CriticalLog("NetworkManager: ResponseBody is null"));
            return new ApiResult.Error(NetworkStatus.UnknownError, null, 2, null);
        }
        Logger.log$default(Logger.INSTANCE, "Network error status code: " + response.code() + " for url: " + response.raw().getRequest().getUrl(), "NetworkManager", 0, 4, null);
        ResponseBody errorBody = response.errorBody();
        if (errorBody == null || (str = errorBody.string()) == null) {
            str = BuildConfig.FLAVOR;
        }
        try {
            apiErrorDTO = (ApiErrorDTO) Json.INSTANCE.decodeFromString(ApiErrorDTO.INSTANCE.serializer(), str);
        } catch (IOException unused) {
            apiErrorDTO = null;
            code = response.code();
            if (code == 0) {
            }
            return new ApiResult.Error(networkStatus, apiErrorDTO != null ? apiErrorDTO.getMessage() : null);
        } catch (Exception e5) {
            if (response.code() != 0) {
                Logger.INSTANCE.logCritical(new CriticalLog("Failed to parse ApiError. " + response.code() + ", error body: '" + str + "' for url: " + response.raw().getRequest().getUrl() + ", StackTrace:\n " + e5.getStackTrace()));
            }
            apiErrorDTO = null;
            code = response.code();
            if (code == 0) {
            }
            return new ApiResult.Error(networkStatus, apiErrorDTO != null ? apiErrorDTO.getMessage() : null);
        }
        code = response.code();
        if (code == 0) {
            networkStatus = NetworkStatus.NoNetwork;
        } else if (code == 401) {
            Logger.INSTANCE.logCritical(new CriticalLog("Network error 401"));
            networkStatus = NetworkStatus.Unauthorized;
        } else if (code == 403) {
            Logger.INSTANCE.logCritical(new CriticalLog("Network error 403"));
            networkStatus = NetworkStatus.Unauthorized;
        } else if (code != 404) {
            logError(response);
            networkStatus = NetworkStatus.UnknownError;
        } else {
            networkStatus = NetworkStatus.NotFound;
        }
        return new ApiResult.Error(networkStatus, apiErrorDTO != null ? apiErrorDTO.getMessage() : null);
    }

    public static final <T> ApiResult<T> response(Response<T> response) {
        Intrinsics.checkNotNullParameter(response, "<this>");
        Request request = response.raw().getRequest();
        Logger logger = Logger.INSTANCE;
        String upperCase = request.getMethod().toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        Logger.log$default(logger, upperCase + " " + request.getUrl(), null, 0, 6, null);
        ApiResult<T> request2 = request(response);
        if (request2 instanceof ApiResult.Error) {
            Logger.log$default(logger, "Network error: " + response.code() + " for url: " + request.getUrl(), null, 0, 6, null);
        }
        return request2;
    }
}
