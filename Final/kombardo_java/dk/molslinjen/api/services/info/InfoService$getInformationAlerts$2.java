package dk.molslinjen.api.services.info;

import dk.molslinjen.api.extensions.ResponseExtensionsKt;
import dk.molslinjen.api.helpers.ApiResult;
import dk.molslinjen.api.services.info.InfoApi;
import dk.molslinjen.api.services.info.response.InfoAlertsResponseDTO;
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

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Ldk/molslinjen/api/helpers/ApiResult;", "Ldk/molslinjen/api/services/info/response/InfoAlertsResponseDTO;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.api.services.info.InfoService$getInformationAlerts$2", f = "InfoService.kt", l = {15}, m = "invokeSuspend")
/* loaded from: classes2.dex */
final class InfoService$getInformationAlerts$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ApiResult<? extends InfoAlertsResponseDTO>>, Object> {
    int label;
    final /* synthetic */ InfoService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InfoService$getInformationAlerts$2(InfoService infoService, Continuation<? super InfoService$getInformationAlerts$2> continuation) {
        super(2, continuation);
        this.this$0 = infoService;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InfoService$getInformationAlerts$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super ApiResult<? extends InfoAlertsResponseDTO>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super ApiResult<InfoAlertsResponseDTO>>) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        InfoApi infoApi;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            infoApi = this.this$0.api;
            this.label = 1;
            obj = InfoApi.DefaultImpls.getInformationAlerts$default(infoApi, null, 0, this, 3, null);
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
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super ApiResult<InfoAlertsResponseDTO>> continuation) {
        return ((InfoService$getInformationAlerts$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
