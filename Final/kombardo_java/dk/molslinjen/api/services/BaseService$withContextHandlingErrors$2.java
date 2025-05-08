package dk.molslinjen.api.services;

import dk.molslinjen.api.helpers.ApiException;
import dk.molslinjen.api.helpers.ApiResult;
import dk.molslinjen.api.helpers.NetworkStatus;
import dk.molslinjen.api.helpers.NoRetriesLeftException;
import dk.molslinjen.core.log.Logger;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Ldk/molslinjen/api/helpers/ApiResult;", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.api.services.BaseService$withContextHandlingErrors$2", f = "BaseService.kt", l = {20}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class BaseService$withContextHandlingErrors$2<T> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ApiResult<? extends T>>, Object> {
    final /* synthetic */ Function2<CoroutineScope, Continuation<? super ApiResult<? extends T>>, Object> $block;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public BaseService$withContextHandlingErrors$2(Function2<? super CoroutineScope, ? super Continuation<? super ApiResult<? extends T>>, ? extends Object> function2, Continuation<? super BaseService$withContextHandlingErrors$2> continuation) {
        super(2, continuation);
        this.$block = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        BaseService$withContextHandlingErrors$2 baseService$withContextHandlingErrors$2 = new BaseService$withContextHandlingErrors$2(this.$block, continuation);
        baseService$withContextHandlingErrors$2.L$0 = obj;
        return baseService$withContextHandlingErrors$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ApiResult.Error error;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        try {
            if (i5 == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                Function2<CoroutineScope, Continuation<? super ApiResult<? extends T>>, Object> function2 = this.$block;
                this.label = 1;
                obj = function2.invoke(coroutineScope, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i5 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        } catch (Throwable th) {
            if (!(th instanceof CancellationException)) {
                Logger.INSTANCE.logError(th);
            }
            if (th instanceof NoRetriesLeftException) {
                return new ApiResult.Error(NetworkStatus.NoNetwork, "Timeout");
            }
            if (th instanceof ApiException) {
                ApiException apiException = th;
                error = new ApiResult.Error(apiException.getNetworkStatus(), apiException.getErrorMessage());
            } else {
                error = new ApiResult.Error(NetworkStatus.UnknownError, th.getLocalizedMessage());
            }
            return error;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ApiResult<? extends T>> continuation) {
        return ((BaseService$withContextHandlingErrors$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
