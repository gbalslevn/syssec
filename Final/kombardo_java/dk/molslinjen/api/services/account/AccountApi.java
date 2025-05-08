package dk.molslinjen.api.services.account;

import dk.molslinjen.api.helpers.retry.Retry;
import dk.molslinjen.api.services.account.request.ActivateAccountRequestParameters;
import dk.molslinjen.api.services.account.request.ChangeAccountRequestParameters;
import dk.molslinjen.api.services.account.request.ChangePasswordRequestParameters;
import dk.molslinjen.api.services.account.request.CreateAccountRequestParameters;
import dk.molslinjen.api.services.account.request.ForgotPasswordRequestParameters;
import dk.molslinjen.api.services.account.request.LoginRequestParameters;
import dk.molslinjen.api.services.account.request.MergeAccountAssetsRequestParameters;
import dk.molslinjen.api.services.account.request.ResetPasswordRequestParameters;
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
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH§@¢\u0006\u0002\u0010\tJ2\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u000b2\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\f\u001a\u00020\rH§@¢\u0006\u0002\u0010\u000eJ(\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00112\b\b\u0001\u0010\u0007\u001a\u00020\bH§@¢\u0006\u0002\u0010\u0012J(\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00142\b\b\u0001\u0010\u0007\u001a\u00020\bH§@¢\u0006\u0002\u0010\u0015J(\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00172\b\b\u0001\u0010\u0007\u001a\u00020\bH§@¢\u0006\u0002\u0010\u0018J(\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u001a2\b\b\u0001\u0010\u0007\u001a\u00020\bH§@¢\u0006\u0002\u0010\u001bJ2\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u001e2\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\f\u001a\u00020\rH§@¢\u0006\u0002\u0010\u001fJ2\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020!2\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\f\u001a\u00020\rH§@¢\u0006\u0002\u0010\"J(\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u00032\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\f\u001a\u00020\rH§@¢\u0006\u0002\u0010%J(\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\f\u001a\u00020\rH§@¢\u0006\u0002\u0010%J2\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\u00032\b\b\u0001\u0010\u0005\u001a\u00020)2\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\f\u001a\u00020\rH§@¢\u0006\u0002\u0010*¨\u0006+"}, d2 = {"Ldk/molslinjen/api/services/account/AccountApi;", BuildConfig.FLAVOR, "login", "Lretrofit2/Response;", "Ldk/molslinjen/api/services/account/response/AuthTokenDTO;", "requestParameters", "Ldk/molslinjen/api/services/account/request/LoginRequestParameters;", "site", "Ldk/molslinjen/api/services/config/response/SiteDTO;", "(Ldk/molslinjen/api/services/account/request/LoginRequestParameters;Ldk/molslinjen/api/services/config/response/SiteDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "changeAccountContext", "Ldk/molslinjen/api/services/account/request/ChangeAccountRequestParameters;", "authToken", BuildConfig.FLAVOR, "(Ldk/molslinjen/api/services/account/request/ChangeAccountRequestParameters;Ldk/molslinjen/api/services/config/response/SiteDTO;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "forgotPassword", BuildConfig.FLAVOR, "Ldk/molslinjen/api/services/account/request/ForgotPasswordRequestParameters;", "(Ldk/molslinjen/api/services/account/request/ForgotPasswordRequestParameters;Ldk/molslinjen/api/services/config/response/SiteDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resetPassword", "Ldk/molslinjen/api/services/account/request/ResetPasswordRequestParameters;", "(Ldk/molslinjen/api/services/account/request/ResetPasswordRequestParameters;Ldk/molslinjen/api/services/config/response/SiteDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "create", "Ldk/molslinjen/api/services/account/request/CreateAccountRequestParameters;", "(Ldk/molslinjen/api/services/account/request/CreateAccountRequestParameters;Ldk/molslinjen/api/services/config/response/SiteDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "activate", "Ldk/molslinjen/api/services/account/request/ActivateAccountRequestParameters;", "(Ldk/molslinjen/api/services/account/request/ActivateAccountRequestParameters;Ldk/molslinjen/api/services/config/response/SiteDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "update", "Ldk/molslinjen/api/services/account/response/AccountUpdateInfoResponseDTO;", "Ldk/molslinjen/api/services/account/request/UpdateAccountRequestParameters;", "(Ldk/molslinjen/api/services/account/request/UpdateAccountRequestParameters;Ldk/molslinjen/api/services/config/response/SiteDTO;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "changePassword", "Ldk/molslinjen/api/services/account/request/ChangePasswordRequestParameters;", "(Ldk/molslinjen/api/services/account/request/ChangePasswordRequestParameters;Ldk/molslinjen/api/services/config/response/SiteDTO;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAccountInfo", "Ldk/molslinjen/api/services/account/response/AccountInfoResponseDTO;", "(Ldk/molslinjen/api/services/config/response/SiteDTO;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "delete", "mergeAccountAssets", "Ldk/molslinjen/api/services/account/response/MergeAccountAssetsResponseDTO;", "Ldk/molslinjen/api/services/account/request/MergeAccountAssetsRequestParameters;", "(Ldk/molslinjen/api/services/account/request/MergeAccountAssetsRequestParameters;Ldk/molslinjen/api/services/config/response/SiteDTO;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface AccountApi {
    @POST("v1/accounts/activate")
    @Retry
    Object activate(@Body ActivateAccountRequestParameters activateAccountRequestParameters, @Header("Line") SiteDTO siteDTO, Continuation<? super Response<AuthTokenDTO>> continuation);

    @PUT("v1/accounts/companies/context")
    Object changeAccountContext(@Body ChangeAccountRequestParameters changeAccountRequestParameters, @Header("Line") SiteDTO siteDTO, @Header("token") String str, Continuation<? super Response<AuthTokenDTO>> continuation);

    @POST("v1/accounts/changepassword")
    @Retry
    Object changePassword(@Body ChangePasswordRequestParameters changePasswordRequestParameters, @Header("Line") SiteDTO siteDTO, @Header("token") String str, Continuation<? super Response<AuthTokenDTO>> continuation);

    @POST("v1/accounts/create")
    Object create(@Body CreateAccountRequestParameters createAccountRequestParameters, @Header("Line") SiteDTO siteDTO, Continuation<? super Response<Unit>> continuation);

    @DELETE("v1/accounts/delete")
    @Retry
    Object delete(@Header("Line") SiteDTO siteDTO, @Header("token") String str, Continuation<? super Response<Unit>> continuation);

    @POST("v1/accounts/forgot")
    @Retry
    Object forgotPassword(@Body ForgotPasswordRequestParameters forgotPasswordRequestParameters, @Header("Line") SiteDTO siteDTO, Continuation<? super Response<Unit>> continuation);

    @GET("v1/accounts/info")
    @Retry
    Object getAccountInfo(@Header("Line") SiteDTO siteDTO, @Header("token") String str, Continuation<? super Response<AccountInfoResponseDTO>> continuation);

    @POST("v1/accounts/login")
    Object login(@Body LoginRequestParameters loginRequestParameters, @Header("Line") SiteDTO siteDTO, Continuation<? super Response<AuthTokenDTO>> continuation);

    @POST("v1/accounts/assets")
    Object mergeAccountAssets(@Body MergeAccountAssetsRequestParameters mergeAccountAssetsRequestParameters, @Header("Line") SiteDTO siteDTO, @Header("token") String str, Continuation<? super Response<MergeAccountAssetsResponseDTO>> continuation);

    @POST("v1/accounts/reset")
    @Retry
    Object resetPassword(@Body ResetPasswordRequestParameters resetPasswordRequestParameters, @Header("Line") SiteDTO siteDTO, Continuation<? super Response<AuthTokenDTO>> continuation);

    @POST("v1/accounts/update")
    @Retry
    Object update(@Body UpdateAccountRequestParameters updateAccountRequestParameters, @Header("Line") SiteDTO siteDTO, @Header("token") String str, Continuation<? super Response<AccountUpdateInfoResponseDTO>> continuation);
}
