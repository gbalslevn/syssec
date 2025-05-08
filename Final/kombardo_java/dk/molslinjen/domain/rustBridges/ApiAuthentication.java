package dk.molslinjen.domain.rustBridges;

import dk.molslinjen.domain.model.constants.Constants;
import kotlin.Metadata;
import uniffi.molslinjen_shared.ApiAuthenticationBridge;
import uniffi.molslinjen_shared.BasicAuth;
import uniffi.molslinjen_shared.Molslinjen_sharedKt;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Ldk/molslinjen/domain/rustBridges/ApiAuthentication;", "Luniffi/molslinjen_shared/ApiAuthenticationBridge;", "<init>", "()V", "currentAgillicAuthentication", "Luniffi/molslinjen_shared/BasicAuth;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ApiAuthentication implements ApiAuthenticationBridge {
    public ApiAuthentication() {
        Molslinjen_sharedKt.ffiInitializeApiAuthenticationBridge(this);
    }

    @Override // uniffi.molslinjen_shared.ApiAuthenticationBridge
    public BasicAuth currentAgillicAuthentication() {
        Constants.Agillic agillic = Constants.Agillic.INSTANCE;
        return new BasicAuth(agillic.getKey(), agillic.getSecret());
    }
}
