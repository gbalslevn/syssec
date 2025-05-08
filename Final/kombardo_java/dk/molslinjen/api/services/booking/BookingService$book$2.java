package dk.molslinjen.api.services.booking;

import dk.molslinjen.api.extensions.ResponseExtensionsKt;
import dk.molslinjen.api.helpers.ApiResult;
import dk.molslinjen.api.services.account.response.AuthTokenDTO;
import dk.molslinjen.api.services.booking.request.BookRequestParameters;
import dk.molslinjen.api.services.booking.response.booking.BookingCompletedResponseDTO;
import dk.molslinjen.api.services.config.response.SiteDTO;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import retrofit2.Response;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Ldk/molslinjen/api/helpers/ApiResult;", "Ldk/molslinjen/api/services/booking/response/booking/BookingCompletedResponseDTO;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.api.services.booking.BookingService$book$2", f = "BookingService.kt", l = {148}, m = "invokeSuspend")
/* loaded from: classes2.dex */
final class BookingService$book$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ApiResult<? extends BookingCompletedResponseDTO>>, Object> {
    final /* synthetic */ AuthTokenDTO $authToken;
    final /* synthetic */ BookRequestParameters $requestParameters;
    final /* synthetic */ String $sessionKey;
    final /* synthetic */ SiteDTO $site;
    int label;
    final /* synthetic */ BookingService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BookingService$book$2(BookingService bookingService, BookRequestParameters bookRequestParameters, SiteDTO siteDTO, AuthTokenDTO authTokenDTO, String str, Continuation<? super BookingService$book$2> continuation) {
        super(2, continuation);
        this.this$0 = bookingService;
        this.$requestParameters = bookRequestParameters;
        this.$site = siteDTO;
        this.$authToken = authTokenDTO;
        this.$sessionKey = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BookingService$book$2(this.this$0, this.$requestParameters, this.$site, this.$authToken, this.$sessionKey, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super ApiResult<? extends BookingCompletedResponseDTO>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super ApiResult<BookingCompletedResponseDTO>>) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        BookingApi bookingApi;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            bookingApi = this.this$0.api;
            BookRequestParameters bookRequestParameters = this.$requestParameters;
            SiteDTO siteDTO = this.$site;
            AuthTokenDTO authTokenDTO = this.$authToken;
            String token = authTokenDTO != null ? authTokenDTO.getToken() : null;
            String str = this.$sessionKey;
            this.label = 1;
            obj = bookingApi.book(bookRequestParameters, siteDTO, token, str, this);
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
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super ApiResult<BookingCompletedResponseDTO>> continuation) {
        return ((BookingService$book$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
