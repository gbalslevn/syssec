package dk.molslinjen.domain.extensions;

import dk.molslinjen.api.helpers.ApiResult;
import dk.molslinjen.domain.managers.ManagerResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001aN\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00030\u00042\"\u0010\u0005\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006H\u0086@¢\u0006\u0002\u0010\t\u001a$\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0004H\u0086@¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"mapToManagerResult", "Ldk/molslinjen/domain/managers/ManagerResult;", "Result", "Incoming", "Ldk/molslinjen/api/helpers/ApiResult;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", BuildConfig.FLAVOR, "(Ldk/molslinjen/api/helpers/ApiResult;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toUnitManagerResult", BuildConfig.FLAVOR, "(Ldk/molslinjen/api/helpers/ApiResult;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class ApiResultExtensionsKt {
    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <Incoming, Result> Object mapToManagerResult(ApiResult<? extends Incoming> apiResult, Function2<? super Incoming, ? super Continuation<? super Result>, ? extends Object> function2, Continuation<? super ManagerResult<? extends Result>> continuation) {
        ApiResultExtensionsKt$mapToManagerResult$1 apiResultExtensionsKt$mapToManagerResult$1;
        int i5;
        if (continuation instanceof ApiResultExtensionsKt$mapToManagerResult$1) {
            apiResultExtensionsKt$mapToManagerResult$1 = (ApiResultExtensionsKt$mapToManagerResult$1) continuation;
            int i6 = apiResultExtensionsKt$mapToManagerResult$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                apiResultExtensionsKt$mapToManagerResult$1.label = i6 - Integer.MIN_VALUE;
                Object obj = apiResultExtensionsKt$mapToManagerResult$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = apiResultExtensionsKt$mapToManagerResult$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    ApiResultExtensionsKt$mapToManagerResult$2 apiResultExtensionsKt$mapToManagerResult$2 = new ApiResultExtensionsKt$mapToManagerResult$2(function2, null);
                    apiResultExtensionsKt$mapToManagerResult$1.label = 1;
                    obj = dk.molslinjen.api.extensions.ApiResultExtensionsKt.mapOnSuccess(apiResult, apiResultExtensionsKt$mapToManagerResult$2, apiResultExtensionsKt$mapToManagerResult$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return ManagerResultExtensionsKt.toManagerResult((ApiResult) obj);
            }
        }
        apiResultExtensionsKt$mapToManagerResult$1 = new ApiResultExtensionsKt$mapToManagerResult$1(continuation);
        Object obj2 = apiResultExtensionsKt$mapToManagerResult$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = apiResultExtensionsKt$mapToManagerResult$1.label;
        if (i5 != 0) {
        }
        return ManagerResultExtensionsKt.toManagerResult((ApiResult) obj2);
    }

    public static final <Incoming> Object toUnitManagerResult(ApiResult<? extends Incoming> apiResult, Continuation<? super ManagerResult<Unit>> continuation) {
        return mapToManagerResult(apiResult, new ApiResultExtensionsKt$toUnitManagerResult$2(null), continuation);
    }
}
