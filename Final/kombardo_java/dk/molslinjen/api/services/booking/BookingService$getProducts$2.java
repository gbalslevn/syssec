package dk.molslinjen.api.services.booking;

import dk.molslinjen.api.extensions.ResponseExtensionsKt;
import dk.molslinjen.api.helpers.ApiResult;
import dk.molslinjen.api.services.booking.request.DirectionDTO;
import dk.molslinjen.api.services.booking.request.ProductsRequestParameters;
import dk.molslinjen.api.services.booking.response.ProductsResponseDTO;
import dk.molslinjen.api.services.config.response.SiteDTO;
import dk.molslinjen.api.shared.response.CurrencyTypeDTO;
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

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Ldk/molslinjen/api/helpers/ApiResult;", "Ldk/molslinjen/api/services/booking/response/ProductsResponseDTO;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.api.services.booking.BookingService$getProducts$2", f = "BookingService.kt", l = {87}, m = "invokeSuspend")
/* loaded from: classes2.dex */
final class BookingService$getProducts$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ApiResult<? extends ProductsResponseDTO>>, Object> {
    final /* synthetic */ String $carId;
    final /* synthetic */ CurrencyTypeDTO $currency;
    final /* synthetic */ String $departureId;
    final /* synthetic */ DirectionDTO $direction;
    final /* synthetic */ String $editPhoneNumber;
    final /* synthetic */ boolean $includeSummaryProducts;
    final /* synthetic */ int $passengerCount;
    final /* synthetic */ String $reservationNumber;
    final /* synthetic */ SiteDTO $site;
    int label;
    final /* synthetic */ BookingService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BookingService$getProducts$2(String str, String str2, DirectionDTO directionDTO, int i5, String str3, String str4, boolean z5, CurrencyTypeDTO currencyTypeDTO, BookingService bookingService, SiteDTO siteDTO, Continuation<? super BookingService$getProducts$2> continuation) {
        super(2, continuation);
        this.$carId = str;
        this.$departureId = str2;
        this.$direction = directionDTO;
        this.$passengerCount = i5;
        this.$reservationNumber = str3;
        this.$editPhoneNumber = str4;
        this.$includeSummaryProducts = z5;
        this.$currency = currencyTypeDTO;
        this.this$0 = bookingService;
        this.$site = siteDTO;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BookingService$getProducts$2(this.$carId, this.$departureId, this.$direction, this.$passengerCount, this.$reservationNumber, this.$editPhoneNumber, this.$includeSummaryProducts, this.$currency, this.this$0, this.$site, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super ApiResult<? extends ProductsResponseDTO>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super ApiResult<ProductsResponseDTO>>) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        BookingApi bookingApi;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            ProductsRequestParameters productsRequestParameters = new ProductsRequestParameters(this.$carId, this.$departureId, this.$direction, this.$passengerCount, this.$reservationNumber, this.$editPhoneNumber, this.$includeSummaryProducts, this.$currency);
            bookingApi = this.this$0.api;
            SiteDTO siteDTO = this.$site;
            this.label = 1;
            obj = bookingApi.getProducts(productsRequestParameters, siteDTO, this);
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
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super ApiResult<ProductsResponseDTO>> continuation) {
        return ((BookingService$getProducts$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
