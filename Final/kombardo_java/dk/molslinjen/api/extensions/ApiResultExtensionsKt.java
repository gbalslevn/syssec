package dk.molslinjen.api.extensions;

import A2.d;
import dk.molslinjen.api.helpers.ApiResult;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001aN\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00030\u00012\"\u0010\u0004\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005H\u0086@¢\u0006\u0002\u0010\b\u001aB\u0010\t\u001a\u00020\n\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00012\"\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005H\u0086@¢\u0006\u0002\u0010\b¨\u0006\f"}, d2 = {"mapOnSuccess", "Ldk/molslinjen/api/helpers/ApiResult;", "R", "T", "map", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", BuildConfig.FLAVOR, "(Ldk/molslinjen/api/helpers/ApiResult;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onSuccess", BuildConfig.FLAVOR, "successCallback", "api_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class ApiResultExtensionsKt {
    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T, R> Object mapOnSuccess(ApiResult<? extends T> apiResult, Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super ApiResult<? extends R>> continuation) {
        ApiResultExtensionsKt$mapOnSuccess$1 apiResultExtensionsKt$mapOnSuccess$1;
        int i5;
        if (continuation instanceof ApiResultExtensionsKt$mapOnSuccess$1) {
            apiResultExtensionsKt$mapOnSuccess$1 = (ApiResultExtensionsKt$mapOnSuccess$1) continuation;
            int i6 = apiResultExtensionsKt$mapOnSuccess$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                apiResultExtensionsKt$mapOnSuccess$1.label = i6 - Integer.MIN_VALUE;
                Object obj = apiResultExtensionsKt$mapOnSuccess$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = apiResultExtensionsKt$mapOnSuccess$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (apiResult instanceof ApiResult.Error) {
                        return apiResult;
                    }
                    if (!(apiResult instanceof ApiResult.Success)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    d dVar = (Object) ((ApiResult.Success) apiResult).getData();
                    apiResultExtensionsKt$mapOnSuccess$1.label = 1;
                    obj = function2.invoke(dVar, apiResultExtensionsKt$mapOnSuccess$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return new ApiResult.Success(obj);
            }
        }
        apiResultExtensionsKt$mapOnSuccess$1 = new ApiResultExtensionsKt$mapOnSuccess$1(continuation);
        Object obj2 = apiResultExtensionsKt$mapOnSuccess$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = apiResultExtensionsKt$mapOnSuccess$1.label;
        if (i5 != 0) {
        }
        return new ApiResult.Success(obj2);
    }

    public static final <T> Object onSuccess(ApiResult<? extends T> apiResult, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        if (apiResult instanceof ApiResult.Error) {
            return Unit.INSTANCE;
        }
        if (!(apiResult instanceof ApiResult.Success)) {
            throw new NoWhenBranchMatchedException();
        }
        Object invoke = function2.invoke((Object) ((ApiResult.Success) apiResult).getData(), continuation);
        return invoke == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? invoke : Unit.INSTANCE;
    }
}
