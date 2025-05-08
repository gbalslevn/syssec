package dk.molslinjen.api.services.account;

import dk.molslinjen.api.helpers.ApiResult;
import dk.molslinjen.api.services.account.request.CreateAccountRequestParameters;
import dk.molslinjen.api.services.account.request.MergeAccountAssetsRequestParameters;
import dk.molslinjen.api.services.account.request.UpdateAccountRequestParameters;
import dk.molslinjen.api.services.account.response.AccountInfoResponseDTO;
import dk.molslinjen.api.services.account.response.AccountUpdateInfoResponseDTO;
import dk.molslinjen.api.services.account.response.AuthTokenDTO;
import dk.molslinjen.api.services.account.response.MergeAccountAssetsResponseDTO;
import dk.molslinjen.api.services.config.response.SiteDTO;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH¦@¢\u0006\u0002\u0010\nJ.\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0004H¦@¢\u0006\u0002\u0010\u000eJ$\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH¦@¢\u0006\u0002\u0010\u0011J,\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH¦@¢\u0006\u0002\u0010\nJ$\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\b\u001a\u00020\tH¦@¢\u0006\u0002\u0010\u0018J$\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH¦@¢\u0006\u0002\u0010\u0011J,\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00032\u0006\u0010\u0016\u001a\u00020\u001d2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0004H¦@¢\u0006\u0002\u0010\u001eJ4\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010 \u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0004H¦@¢\u0006\u0002\u0010!J$\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0004H¦@¢\u0006\u0002\u0010$J$\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0004H¦@¢\u0006\u0002\u0010$J,\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u00032\u0006\u0010(\u001a\u00020)2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0004H¦@¢\u0006\u0002\u0010*¨\u0006+"}, d2 = {"Ldk/molslinjen/api/services/account/IAccountService;", BuildConfig.FLAVOR, "login", "Ldk/molslinjen/api/helpers/ApiResult;", "Ldk/molslinjen/api/services/account/response/AuthTokenDTO;", "email", BuildConfig.FLAVOR, "password", "site", "Ldk/molslinjen/api/services/config/response/SiteDTO;", "(Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/services/config/response/SiteDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "changeAccountContext", "companyId", "authToken", "(Ljava/lang/String;Ldk/molslinjen/api/services/config/response/SiteDTO;Ldk/molslinjen/api/services/account/response/AuthTokenDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "forgotPassword", BuildConfig.FLAVOR, "(Ljava/lang/String;Ldk/molslinjen/api/services/config/response/SiteDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resetPassword", "newPassword", "resetToken", "create", "requestParams", "Ldk/molslinjen/api/services/account/request/CreateAccountRequestParameters;", "(Ldk/molslinjen/api/services/account/request/CreateAccountRequestParameters;Ldk/molslinjen/api/services/config/response/SiteDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "activate", "activationToken", "update", "Ldk/molslinjen/api/services/account/response/AccountUpdateInfoResponseDTO;", "Ldk/molslinjen/api/services/account/request/UpdateAccountRequestParameters;", "(Ldk/molslinjen/api/services/account/request/UpdateAccountRequestParameters;Ldk/molslinjen/api/services/config/response/SiteDTO;Ldk/molslinjen/api/services/account/response/AuthTokenDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "changePassword", "currentPassword", "(Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/services/config/response/SiteDTO;Ldk/molslinjen/api/services/account/response/AuthTokenDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAccountInfo", "Ldk/molslinjen/api/services/account/response/AccountInfoResponseDTO;", "(Ldk/molslinjen/api/services/config/response/SiteDTO;Ldk/molslinjen/api/services/account/response/AuthTokenDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "delete", "mergeAccount", "Ldk/molslinjen/api/services/account/response/MergeAccountAssetsResponseDTO;", "requestParameters", "Ldk/molslinjen/api/services/account/request/MergeAccountAssetsRequestParameters;", "(Ldk/molslinjen/api/services/account/request/MergeAccountAssetsRequestParameters;Ldk/molslinjen/api/services/config/response/SiteDTO;Ldk/molslinjen/api/services/account/response/AuthTokenDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IAccountService {
    Object activate(String str, SiteDTO siteDTO, Continuation<? super ApiResult<AuthTokenDTO>> continuation);

    Object changeAccountContext(String str, SiteDTO siteDTO, AuthTokenDTO authTokenDTO, Continuation<? super ApiResult<AuthTokenDTO>> continuation);

    Object changePassword(String str, String str2, SiteDTO siteDTO, AuthTokenDTO authTokenDTO, Continuation<? super ApiResult<AuthTokenDTO>> continuation);

    Object create(CreateAccountRequestParameters createAccountRequestParameters, SiteDTO siteDTO, Continuation<? super ApiResult<Unit>> continuation);

    Object delete(SiteDTO siteDTO, AuthTokenDTO authTokenDTO, Continuation<? super ApiResult<Unit>> continuation);

    Object forgotPassword(String str, SiteDTO siteDTO, Continuation<? super ApiResult<Unit>> continuation);

    Object getAccountInfo(SiteDTO siteDTO, AuthTokenDTO authTokenDTO, Continuation<? super ApiResult<AccountInfoResponseDTO>> continuation);

    Object login(String str, String str2, SiteDTO siteDTO, Continuation<? super ApiResult<AuthTokenDTO>> continuation);

    Object mergeAccount(MergeAccountAssetsRequestParameters mergeAccountAssetsRequestParameters, SiteDTO siteDTO, AuthTokenDTO authTokenDTO, Continuation<? super ApiResult<MergeAccountAssetsResponseDTO>> continuation);

    Object resetPassword(String str, String str2, SiteDTO siteDTO, Continuation<? super ApiResult<AuthTokenDTO>> continuation);

    Object update(UpdateAccountRequestParameters updateAccountRequestParameters, SiteDTO siteDTO, AuthTokenDTO authTokenDTO, Continuation<? super ApiResult<AccountUpdateInfoResponseDTO>> continuation);
}
