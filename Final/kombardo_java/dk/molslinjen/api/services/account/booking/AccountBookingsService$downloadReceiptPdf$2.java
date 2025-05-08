package dk.molslinjen.api.services.account.booking;

import dk.molslinjen.api.extensions.ApiResultExtensionsKt;
import dk.molslinjen.api.extensions.ResponseExtensionsKt;
import dk.molslinjen.api.helpers.ApiResult;
import dk.molslinjen.api.services.account.booking.AccountBookingsApi;
import dk.molslinjen.api.services.account.response.AuthTokenDTO;
import java.io.File;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.ResponseBody;
import org.conscrypt.BuildConfig;
import retrofit2.Response;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Ldk/molslinjen/api/helpers/ApiResult;", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.api.services.account.booking.AccountBookingsService$downloadReceiptPdf$2", f = "AccountBookingsService.kt", l = {68, 73}, m = "invokeSuspend")
/* loaded from: classes2.dex */
final class AccountBookingsService$downloadReceiptPdf$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ApiResult<? extends Unit>>, Object> {
    final /* synthetic */ AuthTokenDTO $authToken;
    final /* synthetic */ File $outputFile;
    final /* synthetic */ String $phoneNumber;
    final /* synthetic */ String $reservationNumber;
    int label;
    final /* synthetic */ AccountBookingsService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "data", "Lokhttp3/ResponseBody;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.api.services.account.booking.AccountBookingsService$downloadReceiptPdf$2$1", f = "AccountBookingsService.kt", l = {}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.api.services.account.booking.AccountBookingsService$downloadReceiptPdf$2$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<ResponseBody, Continuation<? super Unit>, Object> {
        final /* synthetic */ File $outputFile;
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ AccountBookingsService this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(AccountBookingsService accountBookingsService, File file, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = accountBookingsService;
            this.$outputFile = file;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$outputFile, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            InputStream byteStream = ((ResponseBody) this.L$0).byteStream();
            try {
                this.this$0.copyStreamToFile(byteStream, this.$outputFile);
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(byteStream, null);
                return Unit.INSTANCE;
            } finally {
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ResponseBody responseBody, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(responseBody, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccountBookingsService$downloadReceiptPdf$2(AccountBookingsService accountBookingsService, String str, String str2, AuthTokenDTO authTokenDTO, File file, Continuation<? super AccountBookingsService$downloadReceiptPdf$2> continuation) {
        super(2, continuation);
        this.this$0 = accountBookingsService;
        this.$reservationNumber = str;
        this.$phoneNumber = str2;
        this.$authToken = authTokenDTO;
        this.$outputFile = file;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AccountBookingsService$downloadReceiptPdf$2(this.this$0, this.$reservationNumber, this.$phoneNumber, this.$authToken, this.$outputFile, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super ApiResult<? extends Unit>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super ApiResult<Unit>>) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        AccountBookingsApi accountBookingsApi;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            accountBookingsApi = this.this$0.api;
            String str = this.$reservationNumber;
            String str2 = this.$phoneNumber;
            String token = this.$authToken.getToken();
            this.label = 1;
            obj = AccountBookingsApi.DefaultImpls.downloadReceiptPdf$default(accountBookingsApi, str, str2, null, token, this, 4, null);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                if (i5 == 2) {
                    ResultKt.throwOnFailure(obj);
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        ApiResult response = ResponseExtensionsKt.response((Response) obj);
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$outputFile, null);
        this.label = 2;
        obj = ApiResultExtensionsKt.mapOnSuccess(response, anonymousClass1, this);
        return obj == coroutine_suspended ? coroutine_suspended : obj;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super ApiResult<Unit>> continuation) {
        return ((AccountBookingsService$downloadReceiptPdf$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
