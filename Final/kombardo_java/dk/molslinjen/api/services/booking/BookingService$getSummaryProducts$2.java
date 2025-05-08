package dk.molslinjen.api.services.booking;

import dk.molslinjen.api.extensions.ResponseExtensionsKt;
import dk.molslinjen.api.helpers.ApiResult;
import dk.molslinjen.api.services.booking.response.SummaryProductsResponseDTO;
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

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Ldk/molslinjen/api/helpers/ApiResult;", "Ldk/molslinjen/api/services/booking/response/SummaryProductsResponseDTO;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.api.services.booking.BookingService$getSummaryProducts$2", f = "BookingService.kt", l = {103}, m = "invokeSuspend")
/* loaded from: classes2.dex */
final class BookingService$getSummaryProducts$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ApiResult<? extends SummaryProductsResponseDTO>>, Object> {
    final /* synthetic */ CurrencyTypeDTO $currency;
    final /* synthetic */ boolean $isEditingBooking;
    final /* synthetic */ String $outboundCarId;
    final /* synthetic */ String $outboundDepartureId;
    final /* synthetic */ int $outboundPassengerCount;
    final /* synthetic */ String $returnCarId;
    final /* synthetic */ String $returnDepartureId;
    final /* synthetic */ Integer $returnPassengerCount;
    final /* synthetic */ SiteDTO $site;
    int label;
    final /* synthetic */ BookingService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BookingService$getSummaryProducts$2(BookingService bookingService, String str, String str2, int i5, String str3, String str4, Integer num, boolean z5, CurrencyTypeDTO currencyTypeDTO, SiteDTO siteDTO, Continuation<? super BookingService$getSummaryProducts$2> continuation) {
        super(2, continuation);
        this.this$0 = bookingService;
        this.$outboundDepartureId = str;
        this.$outboundCarId = str2;
        this.$outboundPassengerCount = i5;
        this.$returnDepartureId = str3;
        this.$returnCarId = str4;
        this.$returnPassengerCount = num;
        this.$isEditingBooking = z5;
        this.$currency = currencyTypeDTO;
        this.$site = siteDTO;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BookingService$getSummaryProducts$2(this.this$0, this.$outboundDepartureId, this.$outboundCarId, this.$outboundPassengerCount, this.$returnDepartureId, this.$returnCarId, this.$returnPassengerCount, this.$isEditingBooking, this.$currency, this.$site, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super ApiResult<? extends SummaryProductsResponseDTO>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super ApiResult<SummaryProductsResponseDTO>>) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        BookingApi bookingApi;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            bookingApi = this.this$0.api;
            String str = this.$outboundDepartureId;
            String str2 = this.$outboundCarId;
            int i6 = this.$outboundPassengerCount;
            String str3 = this.$returnDepartureId;
            String str4 = this.$returnCarId;
            Integer num = this.$returnPassengerCount;
            boolean z5 = this.$isEditingBooking;
            CurrencyTypeDTO currencyTypeDTO = this.$currency;
            SiteDTO siteDTO = this.$site;
            this.label = 1;
            obj = bookingApi.getSummaryProducts(str, str2, i6, str3, str4, num, z5, currencyTypeDTO, siteDTO, this);
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
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super ApiResult<SummaryProductsResponseDTO>> continuation) {
        return ((BookingService$getSummaryProducts$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
