package dk.molslinjen.api.services.account;

import dk.molslinjen.api.extensions.ResponseExtensionsKt;
import dk.molslinjen.api.helpers.ApiResult;
import dk.molslinjen.api.services.account.request.ChangePasswordRequestParameters;
import dk.molslinjen.api.services.account.response.AuthTokenDTO;
import dk.molslinjen.api.services.config.response.SiteDTO;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import retrofit2.Response;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Ldk/molslinjen/api/helpers/ApiResult;", "Ldk/molslinjen/api/services/account/response/AuthTokenDTO;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.api.services.account.AccountService$changePassword$2", f = "AccountService.kt", l = {109}, m = "invokeSuspend")
/* loaded from: classes2.dex */
final class AccountService$changePassword$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ApiResult<? extends AuthTokenDTO>>, Object> {
    final /* synthetic */ AuthTokenDTO $authToken;
    final /* synthetic */ String $currentPassword;
    final /* synthetic */ String $newPassword;
    final /* synthetic */ SiteDTO $site;
    int label;
    final /* synthetic */ AccountService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccountService$changePassword$2(AccountService accountService, String str, String str2, SiteDTO siteDTO, AuthTokenDTO authTokenDTO, Continuation<? super AccountService$changePassword$2> continuation) {
        super(2, continuation);
        this.this$0 = accountService;
        this.$currentPassword = str;
        this.$newPassword = str2;
        this.$site = siteDTO;
        this.$authToken = authTokenDTO;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AccountService$changePassword$2(this.this$0, this.$currentPassword, this.$newPassword, this.$site, this.$authToken, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super ApiResult<? extends AuthTokenDTO>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super ApiResult<AuthTokenDTO>>) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        AccountApi accountApi;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            accountApi = this.this$0.accountApi;
            ChangePasswordRequestParameters changePasswordRequestParameters = new ChangePasswordRequestParameters(this.$currentPassword, this.$newPassword, false, 4, (DefaultConstructorMarker) null);
            SiteDTO siteDTO = this.$site;
            String token = this.$authToken.getToken();
            this.label = 1;
            obj = accountApi.changePassword(changePasswordRequestParameters, siteDTO, token, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return ResponseExtensionsKt.response((Response) obj);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super ApiResult<AuthTokenDTO>> continuation) {
        return ((AccountService$changePassword$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
