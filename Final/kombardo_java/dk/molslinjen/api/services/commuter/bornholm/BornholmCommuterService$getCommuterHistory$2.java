package dk.molslinjen.api.services.commuter.bornholm;

import dk.molslinjen.api.extensions.ResponseExtensionsKt;
import dk.molslinjen.api.helpers.ApiResult;
import dk.molslinjen.api.services.commuter.bornholm.BornholmCommuterApi;
import dk.molslinjen.api.services.commuter.bornholm.response.BornholmCommuterBookingResponseDTO;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;
import retrofit2.Response;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Ldk/molslinjen/api/helpers/ApiResult;", BuildConfig.FLAVOR, "Ldk/molslinjen/api/services/commuter/bornholm/response/BornholmCommuterBookingResponseDTO;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.api.services.commuter.bornholm.BornholmCommuterService$getCommuterHistory$2", f = "BornholmCommuterService.kt", l = {35}, m = "invokeSuspend")
/* loaded from: classes2.dex */
final class BornholmCommuterService$getCommuterHistory$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ApiResult<? extends List<? extends BornholmCommuterBookingResponseDTO>>>, Object> {
    final /* synthetic */ String $commuterAgreementId;
    final /* synthetic */ String $commuterId;
    final /* synthetic */ String $textId;
    int label;
    final /* synthetic */ BornholmCommuterService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BornholmCommuterService$getCommuterHistory$2(BornholmCommuterService bornholmCommuterService, String str, String str2, String str3, Continuation<? super BornholmCommuterService$getCommuterHistory$2> continuation) {
        super(2, continuation);
        this.this$0 = bornholmCommuterService;
        this.$commuterId = str;
        this.$commuterAgreementId = str2;
        this.$textId = str3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BornholmCommuterService$getCommuterHistory$2(this.this$0, this.$commuterId, this.$commuterAgreementId, this.$textId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super ApiResult<? extends List<? extends BornholmCommuterBookingResponseDTO>>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super ApiResult<? extends List<BornholmCommuterBookingResponseDTO>>>) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        BornholmCommuterApi bornholmCommuterApi;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            bornholmCommuterApi = this.this$0.api;
            String str = this.$commuterId;
            String str2 = this.$commuterAgreementId;
            String str3 = this.$textId;
            this.label = 1;
            obj = BornholmCommuterApi.DefaultImpls.getBornholmCommuterHistory$default(bornholmCommuterApi, str, str2, str3, null, this, 8, null);
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
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super ApiResult<? extends List<BornholmCommuterBookingResponseDTO>>> continuation) {
        return ((BornholmCommuterService$getCommuterHistory$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
