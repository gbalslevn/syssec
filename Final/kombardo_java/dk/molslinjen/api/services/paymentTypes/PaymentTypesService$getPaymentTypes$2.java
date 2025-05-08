package dk.molslinjen.api.services.paymentTypes;

import dk.molslinjen.api.extensions.ResponseExtensionsKt;
import dk.molslinjen.api.helpers.ApiResult;
import dk.molslinjen.api.services.config.response.SiteDTO;
import dk.molslinjen.api.services.paymentTypes.response.PaymentTypesResponseDTO;
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

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Ldk/molslinjen/api/helpers/ApiResult;", "Ldk/molslinjen/api/services/paymentTypes/response/PaymentTypesResponseDTO;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.api.services.paymentTypes.PaymentTypesService$getPaymentTypes$2", f = "PaymentTypesService.kt", l = {21}, m = "invokeSuspend")
/* loaded from: classes2.dex */
final class PaymentTypesService$getPaymentTypes$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ApiResult<? extends PaymentTypesResponseDTO>>, Object> {
    final /* synthetic */ CurrencyTypeDTO $currency;
    final /* synthetic */ String $routeId;
    final /* synthetic */ SiteDTO $site;
    int label;
    final /* synthetic */ PaymentTypesService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PaymentTypesService$getPaymentTypes$2(PaymentTypesService paymentTypesService, SiteDTO siteDTO, CurrencyTypeDTO currencyTypeDTO, String str, Continuation<? super PaymentTypesService$getPaymentTypes$2> continuation) {
        super(2, continuation);
        this.this$0 = paymentTypesService;
        this.$site = siteDTO;
        this.$currency = currencyTypeDTO;
        this.$routeId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PaymentTypesService$getPaymentTypes$2(this.this$0, this.$site, this.$currency, this.$routeId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super ApiResult<? extends PaymentTypesResponseDTO>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super ApiResult<PaymentTypesResponseDTO>>) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        PaymentTypesApi paymentTypesApi;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            paymentTypesApi = this.this$0.api;
            SiteDTO siteDTO = this.$site;
            int rawValue = this.$currency.getRawValue();
            String str = this.$routeId;
            this.label = 1;
            obj = paymentTypesApi.getPaymentTypesByCurrency(siteDTO, rawValue, str, this);
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
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super ApiResult<PaymentTypesResponseDTO>> continuation) {
        return ((PaymentTypesService$getPaymentTypes$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
