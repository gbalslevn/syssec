package dk.molslinjen.api.services.commuter.bornholm;

import dk.molslinjen.api.helpers.ApiResult;
import dk.molslinjen.api.services.BaseService;
import dk.molslinjen.api.services.commuter.bornholm.response.BornholmCommuterAgreementResponseDTO;
import dk.molslinjen.api.services.commuter.bornholm.response.BornholmCommuterBookingResponseDTO;
import dk.molslinjen.api.services.commuter.bornholm.response.BornholmCommuterLoginResponseDTO;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J$\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\rJ\"\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\b2\u0006\u0010\u0011\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\u0012J2\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u000f0\b2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Ldk/molslinjen/api/services/commuter/bornholm/BornholmCommuterService;", "Ldk/molslinjen/api/services/commuter/bornholm/IBornholmCommuterService;", "Ldk/molslinjen/api/services/BaseService;", "api", "Ldk/molslinjen/api/services/commuter/bornholm/BornholmCommuterApi;", "<init>", "(Ldk/molslinjen/api/services/commuter/bornholm/BornholmCommuterApi;)V", "login", "Ldk/molslinjen/api/helpers/ApiResult;", "Ldk/molslinjen/api/services/commuter/bornholm/response/BornholmCommuterLoginResponseDTO;", "email", BuildConfig.FLAVOR, "password", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCommuterAgreements", BuildConfig.FLAVOR, "Ldk/molslinjen/api/services/commuter/bornholm/response/BornholmCommuterAgreementResponseDTO;", "commuterId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCommuterHistory", "Ldk/molslinjen/api/services/commuter/bornholm/response/BornholmCommuterBookingResponseDTO;", "commuterAgreementId", "textId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class BornholmCommuterService extends BaseService implements IBornholmCommuterService {
    private final BornholmCommuterApi api;

    public BornholmCommuterService(BornholmCommuterApi api) {
        Intrinsics.checkNotNullParameter(api, "api");
        this.api = api;
    }

    @Override // dk.molslinjen.api.services.commuter.bornholm.IBornholmCommuterService
    public Object getCommuterAgreements(String str, Continuation<? super ApiResult<? extends List<BornholmCommuterAgreementResponseDTO>>> continuation) {
        return withContextHandlingErrors(Dispatchers.getIO(), new BornholmCommuterService$getCommuterAgreements$2(this, str, null), continuation);
    }

    @Override // dk.molslinjen.api.services.commuter.bornholm.IBornholmCommuterService
    public Object getCommuterHistory(String str, String str2, String str3, Continuation<? super ApiResult<? extends List<BornholmCommuterBookingResponseDTO>>> continuation) {
        return withContextHandlingErrors(Dispatchers.getIO(), new BornholmCommuterService$getCommuterHistory$2(this, str, str2, str3, null), continuation);
    }

    @Override // dk.molslinjen.api.services.commuter.bornholm.IBornholmCommuterService
    public Object login(String str, String str2, Continuation<? super ApiResult<BornholmCommuterLoginResponseDTO>> continuation) {
        return withContextHandlingErrors(Dispatchers.getIO(), new BornholmCommuterService$login$2(str, str2, this, null), continuation);
    }
}
