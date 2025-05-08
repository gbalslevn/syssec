package dk.molslinjen.api.services.multiRide;

import dk.molslinjen.api.extensions.ResponseExtensionsKt;
import dk.molslinjen.api.helpers.ApiResult;
import dk.molslinjen.api.services.booking.request.PaymentTypeRequestParameters;
import dk.molslinjen.api.services.booking.response.booking.ApiAppPaymentRedirectDetailsDTO;
import dk.molslinjen.api.services.config.response.SiteDTO;
import dk.molslinjen.api.services.multiRide.request.PurchaseMultiRideRequestParameters;
import dk.molslinjen.api.services.multiRide.response.MultiRidePurchaseResponseDTO;
import dk.molslinjen.api.services.paymentTypes.response.PaymentTypeDTO;
import dk.molslinjen.api.shared.request.PaymentDataRequestParameters;
import dk.molslinjen.core.Environment;
import dk.molslinjen.core.extensions.IpHelperKt;
import dk.molslinjen.core.providers.IPaymentCallbackUrlProvider;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import retrofit2.Response;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Ldk/molslinjen/api/helpers/ApiResult;", "Ldk/molslinjen/api/services/multiRide/response/MultiRidePurchaseResponseDTO;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.api.services.multiRide.MultiRideService$purchaseOrRefillMultiRide$2", f = "MultiRideService.kt", l = {99}, m = "invokeSuspend")
/* loaded from: classes2.dex */
final class MultiRideService$purchaseOrRefillMultiRide$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ApiResult<? extends MultiRidePurchaseResponseDTO>>, Object> {
    final /* synthetic */ String $cardType;
    final /* synthetic */ String $email;
    final /* synthetic */ String $multiRideId;
    final /* synthetic */ int $numberOfCharges;
    final /* synthetic */ PaymentTypeDTO $paymentType;
    final /* synthetic */ String $phone;
    final /* synthetic */ String $phonePrefix;
    final /* synthetic */ String $postalCode;
    final /* synthetic */ String $savedCreditCardToken;
    final /* synthetic */ float $screenHeight;
    final /* synthetic */ float $screenWidth;
    final /* synthetic */ SiteDTO $site;
    int label;
    final /* synthetic */ MultiRideService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiRideService$purchaseOrRefillMultiRide$2(String str, String str2, String str3, int i5, PaymentTypeDTO paymentTypeDTO, String str4, String str5, String str6, String str7, MultiRideService multiRideService, float f5, float f6, SiteDTO siteDTO, Continuation<? super MultiRideService$purchaseOrRefillMultiRide$2> continuation) {
        super(2, continuation);
        this.$cardType = str;
        this.$email = str2;
        this.$multiRideId = str3;
        this.$numberOfCharges = i5;
        this.$paymentType = paymentTypeDTO;
        this.$phone = str4;
        this.$phonePrefix = str5;
        this.$postalCode = str6;
        this.$savedCreditCardToken = str7;
        this.this$0 = multiRideService;
        this.$screenHeight = f5;
        this.$screenWidth = f6;
        this.$site = siteDTO;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MultiRideService$purchaseOrRefillMultiRide$2(this.$cardType, this.$email, this.$multiRideId, this.$numberOfCharges, this.$paymentType, this.$phone, this.$phonePrefix, this.$postalCode, this.$savedCreditCardToken, this.this$0, this.$screenHeight, this.$screenWidth, this.$site, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super ApiResult<? extends MultiRidePurchaseResponseDTO>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super ApiResult<MultiRidePurchaseResponseDTO>>) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IPaymentCallbackUrlProvider iPaymentCallbackUrlProvider;
        IPaymentCallbackUrlProvider iPaymentCallbackUrlProvider2;
        MultiRideApi multiRideApi;
        Object purchaseOrRefillMultiRide;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            String str = this.$cardType;
            String str2 = this.$email;
            String str3 = this.$multiRideId;
            int i6 = this.$numberOfCharges;
            PaymentTypeRequestParameters requestParameters = this.$paymentType.toRequestParameters();
            String str4 = this.$phone;
            String str5 = this.$phonePrefix;
            String str6 = this.$postalCode;
            String str7 = this.$savedCreditCardToken;
            iPaymentCallbackUrlProvider = this.this$0.paymentCallbackUrlProvider;
            String paymentCallbackUrl = iPaymentCallbackUrlProvider.getPaymentCallbackUrl();
            iPaymentCallbackUrlProvider2 = this.this$0.paymentCallbackUrlProvider;
            PaymentDataRequestParameters paymentDataRequestParameters = new PaymentDataRequestParameters(str7, paymentCallbackUrl, iPaymentCallbackUrlProvider2.getPaymentCallbackUrl());
            String str8 = Environment.INSTANCE.isMolslinjen() ? "AP51" : "KE11";
            float f5 = this.$screenHeight;
            float f6 = this.$screenWidth;
            String language = Locale.getDefault().getLanguage();
            Intrinsics.checkNotNullExpressionValue(language, "getLanguage(...)");
            PurchaseMultiRideRequestParameters purchaseMultiRideRequestParameters = new PurchaseMultiRideRequestParameters(str, str2, str3, i6, requestParameters, str4, str5, str6, paymentDataRequestParameters, str8, new ApiAppPaymentRedirectDetailsDTO(f5, f6, language, IpHelperKt.getIpAddress()));
            multiRideApi = this.this$0.api;
            SiteDTO siteDTO = this.$site;
            this.label = 1;
            purchaseOrRefillMultiRide = multiRideApi.purchaseOrRefillMultiRide(purchaseMultiRideRequestParameters, siteDTO, this);
            if (purchaseOrRefillMultiRide == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            purchaseOrRefillMultiRide = obj;
        }
        return ResponseExtensionsKt.response((Response) purchaseOrRefillMultiRide);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super ApiResult<MultiRidePurchaseResponseDTO>> continuation) {
        return ((MultiRideService$purchaseOrRefillMultiRide$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
