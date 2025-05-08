package dk.molslinjen.api.services.account;

import dk.molslinjen.api.helpers.ApiResult;
import dk.molslinjen.api.services.BaseService;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J,\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0096@¢\u0006\u0002\u0010\u000fJ.\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010\u0013J$\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0096@¢\u0006\u0002\u0010\u0016J,\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0096@¢\u0006\u0002\u0010\u000fJ$\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00150\b2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\r\u001a\u00020\u000eH\u0096@¢\u0006\u0002\u0010\u001dJ$\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0096@¢\u0006\u0002\u0010\u0016J,\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\b2\u0006\u0010\u001b\u001a\u00020\"2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010#J4\u0010$\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010%\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010&J$\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010)J$\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00150\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010)J,\u0010+\u001a\b\u0012\u0004\u0012\u00020,0\b2\u0006\u0010-\u001a\u00020.2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010/R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Ldk/molslinjen/api/services/account/AccountService;", "Ldk/molslinjen/api/services/account/IAccountService;", "Ldk/molslinjen/api/services/BaseService;", "accountApi", "Ldk/molslinjen/api/services/account/AccountApi;", "<init>", "(Ldk/molslinjen/api/services/account/AccountApi;)V", "login", "Ldk/molslinjen/api/helpers/ApiResult;", "Ldk/molslinjen/api/services/account/response/AuthTokenDTO;", "email", BuildConfig.FLAVOR, "password", "site", "Ldk/molslinjen/api/services/config/response/SiteDTO;", "(Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/services/config/response/SiteDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "changeAccountContext", "companyId", "authToken", "(Ljava/lang/String;Ldk/molslinjen/api/services/config/response/SiteDTO;Ldk/molslinjen/api/services/account/response/AuthTokenDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "forgotPassword", BuildConfig.FLAVOR, "(Ljava/lang/String;Ldk/molslinjen/api/services/config/response/SiteDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resetPassword", "newPassword", "resetToken", "create", "requestParams", "Ldk/molslinjen/api/services/account/request/CreateAccountRequestParameters;", "(Ldk/molslinjen/api/services/account/request/CreateAccountRequestParameters;Ldk/molslinjen/api/services/config/response/SiteDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "activate", "activationToken", "update", "Ldk/molslinjen/api/services/account/response/AccountUpdateInfoResponseDTO;", "Ldk/molslinjen/api/services/account/request/UpdateAccountRequestParameters;", "(Ldk/molslinjen/api/services/account/request/UpdateAccountRequestParameters;Ldk/molslinjen/api/services/config/response/SiteDTO;Ldk/molslinjen/api/services/account/response/AuthTokenDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "changePassword", "currentPassword", "(Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/services/config/response/SiteDTO;Ldk/molslinjen/api/services/account/response/AuthTokenDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAccountInfo", "Ldk/molslinjen/api/services/account/response/AccountInfoResponseDTO;", "(Ldk/molslinjen/api/services/config/response/SiteDTO;Ldk/molslinjen/api/services/account/response/AuthTokenDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "delete", "mergeAccount", "Ldk/molslinjen/api/services/account/response/MergeAccountAssetsResponseDTO;", "requestParameters", "Ldk/molslinjen/api/services/account/request/MergeAccountAssetsRequestParameters;", "(Ldk/molslinjen/api/services/account/request/MergeAccountAssetsRequestParameters;Ldk/molslinjen/api/services/config/response/SiteDTO;Ldk/molslinjen/api/services/account/response/AuthTokenDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AccountService extends BaseService implements IAccountService {
    private final AccountApi accountApi;

    public AccountService(AccountApi accountApi) {
        Intrinsics.checkNotNullParameter(accountApi, "accountApi");
        this.accountApi = accountApi;
    }

    @Override // dk.molslinjen.api.services.account.IAccountService
    public Object activate(String str, SiteDTO siteDTO, Continuation<? super ApiResult<AuthTokenDTO>> continuation) {
        return withContextHandlingErrors(Dispatchers.getIO(), new AccountService$activate$2(this, str, siteDTO, null), continuation);
    }

    @Override // dk.molslinjen.api.services.account.IAccountService
    public Object changeAccountContext(String str, SiteDTO siteDTO, AuthTokenDTO authTokenDTO, Continuation<? super ApiResult<AuthTokenDTO>> continuation) {
        return withContextHandlingErrors(Dispatchers.getIO(), new AccountService$changeAccountContext$2(this, str, siteDTO, authTokenDTO, null), continuation);
    }

    @Override // dk.molslinjen.api.services.account.IAccountService
    public Object changePassword(String str, String str2, SiteDTO siteDTO, AuthTokenDTO authTokenDTO, Continuation<? super ApiResult<AuthTokenDTO>> continuation) {
        return withContextHandlingErrors(Dispatchers.getIO(), new AccountService$changePassword$2(this, str, str2, siteDTO, authTokenDTO, null), continuation);
    }

    @Override // dk.molslinjen.api.services.account.IAccountService
    public Object create(CreateAccountRequestParameters createAccountRequestParameters, SiteDTO siteDTO, Continuation<? super ApiResult<Unit>> continuation) {
        return withContextHandlingErrors(Dispatchers.getIO(), new AccountService$create$2(this, createAccountRequestParameters, siteDTO, null), continuation);
    }

    @Override // dk.molslinjen.api.services.account.IAccountService
    public Object delete(SiteDTO siteDTO, AuthTokenDTO authTokenDTO, Continuation<? super ApiResult<Unit>> continuation) {
        return withContextHandlingErrors(Dispatchers.getIO(), new AccountService$delete$2(this, siteDTO, authTokenDTO, null), continuation);
    }

    @Override // dk.molslinjen.api.services.account.IAccountService
    public Object forgotPassword(String str, SiteDTO siteDTO, Continuation<? super ApiResult<Unit>> continuation) {
        return withContextHandlingErrors(Dispatchers.getIO(), new AccountService$forgotPassword$2(str, this, siteDTO, null), continuation);
    }

    @Override // dk.molslinjen.api.services.account.IAccountService
    public Object getAccountInfo(SiteDTO siteDTO, AuthTokenDTO authTokenDTO, Continuation<? super ApiResult<AccountInfoResponseDTO>> continuation) {
        return withContextHandlingErrors(Dispatchers.getIO(), new AccountService$getAccountInfo$2(this, siteDTO, authTokenDTO, null), continuation);
    }

    @Override // dk.molslinjen.api.services.account.IAccountService
    public Object login(String str, String str2, SiteDTO siteDTO, Continuation<? super ApiResult<AuthTokenDTO>> continuation) {
        return withContextHandlingErrors(Dispatchers.getIO(), new AccountService$login$2(str, str2, this, siteDTO, null), continuation);
    }

    @Override // dk.molslinjen.api.services.account.IAccountService
    public Object mergeAccount(MergeAccountAssetsRequestParameters mergeAccountAssetsRequestParameters, SiteDTO siteDTO, AuthTokenDTO authTokenDTO, Continuation<? super ApiResult<MergeAccountAssetsResponseDTO>> continuation) {
        return withContextHandlingErrors(Dispatchers.getIO(), new AccountService$mergeAccount$2(this, mergeAccountAssetsRequestParameters, siteDTO, authTokenDTO, null), continuation);
    }

    @Override // dk.molslinjen.api.services.account.IAccountService
    public Object resetPassword(String str, String str2, SiteDTO siteDTO, Continuation<? super ApiResult<AuthTokenDTO>> continuation) {
        return withContextHandlingErrors(Dispatchers.getIO(), new AccountService$resetPassword$2(str, str2, this, siteDTO, null), continuation);
    }

    @Override // dk.molslinjen.api.services.account.IAccountService
    public Object update(UpdateAccountRequestParameters updateAccountRequestParameters, SiteDTO siteDTO, AuthTokenDTO authTokenDTO, Continuation<? super ApiResult<AccountUpdateInfoResponseDTO>> continuation) {
        return withContextHandlingErrors(Dispatchers.getIO(), new AccountService$update$2(this, updateAccountRequestParameters, siteDTO, authTokenDTO, null), continuation);
    }
}
