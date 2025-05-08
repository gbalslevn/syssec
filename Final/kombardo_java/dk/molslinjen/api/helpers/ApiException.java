package dk.molslinjen.api.helpers;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00060\u0001j\u0002`\u0002R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Ldk/molslinjen/api/helpers/ApiException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "Ldk/molslinjen/api/helpers/NetworkStatus;", "networkStatus", "Ldk/molslinjen/api/helpers/NetworkStatus;", "getNetworkStatus", "()Ldk/molslinjen/api/helpers/NetworkStatus;", BuildConfig.FLAVOR, "errorMessage", "Ljava/lang/String;", "getErrorMessage", "()Ljava/lang/String;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ApiException extends Exception {
    private final String errorMessage;
    private final NetworkStatus networkStatus;

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final NetworkStatus getNetworkStatus() {
        return this.networkStatus;
    }
}
