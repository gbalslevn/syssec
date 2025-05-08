package dk.molslinjen.core.providers;

import dk.molslinjen.core.ApiEnvironment;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005¨\u0006\b"}, d2 = {"Ldk/molslinjen/core/providers/IApiInfoProvider;", BuildConfig.FLAVOR, "originalApi", "Ldk/molslinjen/core/ApiEnvironment;", "getOriginalApi", "()Ldk/molslinjen/core/ApiEnvironment;", "overrideApi", "getOverrideApi", "core_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IApiInfoProvider {
    ApiEnvironment getOriginalApi();

    ApiEnvironment getOverrideApi();
}
