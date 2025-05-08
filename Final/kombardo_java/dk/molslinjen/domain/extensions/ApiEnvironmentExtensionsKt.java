package dk.molslinjen.domain.extensions;

import dk.molslinjen.core.ApiEnvironment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"verticaApiUrl", BuildConfig.FLAVOR, "Ldk/molslinjen/core/ApiEnvironment;", "getVerticaApiUrl", "(Ldk/molslinjen/core/ApiEnvironment;)Ljava/lang/String;", "domain_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class ApiEnvironmentExtensionsKt {
    public static final String getVerticaApiUrl(ApiEnvironment apiEnvironment) {
        Intrinsics.checkNotNullParameter(apiEnvironment, "<this>");
        return dk.molslinjen.api.ApiEnvironmentExtensionsKt.getVerticaApiUrl(apiEnvironment);
    }
}
