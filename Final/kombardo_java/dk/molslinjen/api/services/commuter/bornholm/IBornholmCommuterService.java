package dk.molslinjen.api.services.commuter.bornholm;

import dk.molslinjen.api.helpers.ApiResult;
import dk.molslinjen.api.services.commuter.bornholm.response.BornholmCommuterAgreementResponseDTO;
import dk.molslinjen.api.services.commuter.bornholm.response.BornholmCommuterBookingResponseDTO;
import dk.molslinjen.api.services.commuter.bornholm.response.BornholmCommuterLoginResponseDTO;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\bJ\"\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u00032\u0006\u0010\f\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\rJ2\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\n0\u00032\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, d2 = {"Ldk/molslinjen/api/services/commuter/bornholm/IBornholmCommuterService;", BuildConfig.FLAVOR, "login", "Ldk/molslinjen/api/helpers/ApiResult;", "Ldk/molslinjen/api/services/commuter/bornholm/response/BornholmCommuterLoginResponseDTO;", "email", BuildConfig.FLAVOR, "password", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCommuterAgreements", BuildConfig.FLAVOR, "Ldk/molslinjen/api/services/commuter/bornholm/response/BornholmCommuterAgreementResponseDTO;", "commuterId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCommuterHistory", "Ldk/molslinjen/api/services/commuter/bornholm/response/BornholmCommuterBookingResponseDTO;", "commuterAgreementId", "textId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IBornholmCommuterService {
    Object getCommuterAgreements(String str, Continuation<? super ApiResult<? extends List<BornholmCommuterAgreementResponseDTO>>> continuation);

    Object getCommuterHistory(String str, String str2, String str3, Continuation<? super ApiResult<? extends List<BornholmCommuterBookingResponseDTO>>> continuation);

    Object login(String str, String str2, Continuation<? super ApiResult<BornholmCommuterLoginResponseDTO>> continuation);
}
