package dk.molslinjen.domain.extensions;

import A2.d;
import dk.molslinjen.api.helpers.ApiResult;
import dk.molslinjen.domain.managers.ManagerResult;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\t\u001a6\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00020\u0006\u001aP\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00020\u00062\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0006\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0004\u001aH\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\n0\u0001\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00012\"\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\fH\u0086@¢\u0006\u0002\u0010\u0010\u001aB\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\n0\u0001\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00012\u001c\u0010\u0012\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0006H\u0086@¢\u0006\u0002\u0010\u0013\u001a\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0001\"\u0004\b\u0000\u0010\u0015*\b\u0012\u0004\u0012\u0002H\u00150\u0001\u001a\u001d\u0010\u0016\u001a\u0004\u0018\u0001H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001¢\u0006\u0002\u0010\u0017¨\u0006\u0018"}, d2 = {"toManagerResult", "Ldk/molslinjen/domain/managers/ManagerResult;", "T", "I", "Ldk/molslinjen/api/helpers/ApiResult;", "transform", "Lkotlin/Function1;", "errorTransform", "Ldk/molslinjen/api/helpers/ApiResult$Error;", "onSuccess", "Value", "successCallback", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "(Ldk/molslinjen/domain/managers/ManagerResult;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onFailure", "failureCallback", "(Ldk/molslinjen/domain/managers/ManagerResult;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toUnitManagerResult", "Incoming", "toData", "(Ldk/molslinjen/domain/managers/ManagerResult;)Ljava/lang/Object;", "domain_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class ManagerResultExtensionsKt {
    /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <Value> Object onFailure(ManagerResult<? extends Value> managerResult, Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super ManagerResult<? extends Value>> continuation) {
        ManagerResultExtensionsKt$onFailure$1 managerResultExtensionsKt$onFailure$1;
        int i5;
        if (continuation instanceof ManagerResultExtensionsKt$onFailure$1) {
            managerResultExtensionsKt$onFailure$1 = (ManagerResultExtensionsKt$onFailure$1) continuation;
            int i6 = managerResultExtensionsKt$onFailure$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                managerResultExtensionsKt$onFailure$1.label = i6 - Integer.MIN_VALUE;
                Object obj = managerResultExtensionsKt$onFailure$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = managerResultExtensionsKt$onFailure$1.label;
                if (i5 == 0) {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ManagerResult managerResult2 = (ManagerResult) managerResultExtensionsKt$onFailure$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    return managerResult2;
                }
                ResultKt.throwOnFailure(obj);
                if (!(managerResult instanceof ManagerResult.Error)) {
                    return managerResult;
                }
                managerResultExtensionsKt$onFailure$1.L$0 = managerResult;
                managerResultExtensionsKt$onFailure$1.label = 1;
                return function1.invoke(managerResultExtensionsKt$onFailure$1) == coroutine_suspended ? coroutine_suspended : managerResult;
            }
        }
        managerResultExtensionsKt$onFailure$1 = new ManagerResultExtensionsKt$onFailure$1(continuation);
        Object obj2 = managerResultExtensionsKt$onFailure$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = managerResultExtensionsKt$onFailure$1.label;
        if (i5 == 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <Value> Object onSuccess(ManagerResult<? extends Value> managerResult, Function2<? super Value, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super ManagerResult<? extends Value>> continuation) {
        ManagerResultExtensionsKt$onSuccess$1 managerResultExtensionsKt$onSuccess$1;
        int i5;
        if (continuation instanceof ManagerResultExtensionsKt$onSuccess$1) {
            managerResultExtensionsKt$onSuccess$1 = (ManagerResultExtensionsKt$onSuccess$1) continuation;
            int i6 = managerResultExtensionsKt$onSuccess$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                managerResultExtensionsKt$onSuccess$1.label = i6 - Integer.MIN_VALUE;
                Object obj = managerResultExtensionsKt$onSuccess$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = managerResultExtensionsKt$onSuccess$1.label;
                if (i5 == 0) {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ManagerResult managerResult2 = (ManagerResult) managerResultExtensionsKt$onSuccess$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    return managerResult2;
                }
                ResultKt.throwOnFailure(obj);
                if (!(managerResult instanceof ManagerResult.Success)) {
                    return managerResult;
                }
                d dVar = (Object) ((ManagerResult.Success) managerResult).getData();
                managerResultExtensionsKt$onSuccess$1.L$0 = managerResult;
                managerResultExtensionsKt$onSuccess$1.label = 1;
                return function2.invoke(dVar, managerResultExtensionsKt$onSuccess$1) == coroutine_suspended ? coroutine_suspended : managerResult;
            }
        }
        managerResultExtensionsKt$onSuccess$1 = new ManagerResultExtensionsKt$onSuccess$1(continuation);
        Object obj2 = managerResultExtensionsKt$onSuccess$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = managerResultExtensionsKt$onSuccess$1.label;
        if (i5 == 0) {
        }
    }

    public static final <T> T toData(ManagerResult<? extends T> managerResult) {
        Intrinsics.checkNotNullParameter(managerResult, "<this>");
        if (managerResult instanceof ManagerResult.Error) {
            return null;
        }
        if (managerResult instanceof ManagerResult.Success) {
            return (T) ((ManagerResult.Success) managerResult).getData();
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final <I, T> ManagerResult<T> toManagerResult(ApiResult<? extends I> apiResult, Function1<? super I, ? extends T> transform) {
        Intrinsics.checkNotNullParameter(apiResult, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        if (apiResult instanceof ApiResult.Error) {
            ApiResult.Error error = (ApiResult.Error) apiResult;
            return new ManagerResult.Error.ErrorString(error.getNetworkStatus(), error.getErrorMessage());
        }
        if (apiResult instanceof ApiResult.Success) {
            return new ManagerResult.Success(transform.invoke((Object) ((ApiResult.Success) apiResult).getData()));
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <Incoming> ManagerResult<Unit> toUnitManagerResult(ManagerResult<? extends Incoming> managerResult) {
        Intrinsics.checkNotNullParameter(managerResult, "<this>");
        if (managerResult instanceof ManagerResult.Error) {
            return managerResult;
        }
        if (managerResult instanceof ManagerResult.Success) {
            return new ManagerResult.Success(Unit.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final <I, T> ManagerResult<T> toManagerResult(ApiResult<? extends I> apiResult, Function1<? super I, ? extends T> transform, Function1<? super ApiResult.Error, ? extends ManagerResult<? extends T>> errorTransform) {
        Intrinsics.checkNotNullParameter(apiResult, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        Intrinsics.checkNotNullParameter(errorTransform, "errorTransform");
        if (apiResult instanceof ApiResult.Error) {
            return errorTransform.invoke(apiResult);
        }
        if (apiResult instanceof ApiResult.Success) {
            return new ManagerResult.Success(transform.invoke((Object) ((ApiResult.Success) apiResult).getData()));
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final <T> ManagerResult<T> toManagerResult(ApiResult<? extends T> apiResult) {
        Intrinsics.checkNotNullParameter(apiResult, "<this>");
        if (apiResult instanceof ApiResult.Error) {
            ApiResult.Error error = (ApiResult.Error) apiResult;
            return new ManagerResult.Error.ErrorString(error.getNetworkStatus(), error.getErrorMessage());
        }
        if (apiResult instanceof ApiResult.Success) {
            return new ManagerResult.Success(((ApiResult.Success) apiResult).getData());
        }
        throw new NoWhenBranchMatchedException();
    }
}
