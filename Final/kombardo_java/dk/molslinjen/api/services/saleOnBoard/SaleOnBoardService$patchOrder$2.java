package dk.molslinjen.api.services.saleOnBoard;

import dk.molslinjen.api.extensions.ResponseExtensionsKt;
import dk.molslinjen.api.helpers.ApiResult;
import dk.molslinjen.api.services.saleOnBoard.request.PatchOrderRequestParameters;
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

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Ldk/molslinjen/api/helpers/ApiResult;", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.api.services.saleOnBoard.SaleOnBoardService$patchOrder$2", f = "SaleOnBoardService.kt", l = {46}, m = "invokeSuspend")
/* loaded from: classes2.dex */
final class SaleOnBoardService$patchOrder$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ApiResult<? extends Unit>>, Object> {
    final /* synthetic */ int $orderId;
    final /* synthetic */ PatchOrderRequestParameters $requestParameters;
    int label;
    final /* synthetic */ SaleOnBoardService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SaleOnBoardService$patchOrder$2(SaleOnBoardService saleOnBoardService, int i5, PatchOrderRequestParameters patchOrderRequestParameters, Continuation<? super SaleOnBoardService$patchOrder$2> continuation) {
        super(2, continuation);
        this.this$0 = saleOnBoardService;
        this.$orderId = i5;
        this.$requestParameters = patchOrderRequestParameters;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SaleOnBoardService$patchOrder$2(this.this$0, this.$orderId, this.$requestParameters, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super ApiResult<? extends Unit>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super ApiResult<Unit>>) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        SaleOnBoardApi saleOnBoardApi;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            saleOnBoardApi = this.this$0.api;
            String valueOf = String.valueOf(this.$orderId);
            PatchOrderRequestParameters patchOrderRequestParameters = this.$requestParameters;
            this.label = 1;
            obj = saleOnBoardApi.patchOrder(valueOf, patchOrderRequestParameters, this);
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
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super ApiResult<Unit>> continuation) {
        return ((SaleOnBoardService$patchOrder$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
