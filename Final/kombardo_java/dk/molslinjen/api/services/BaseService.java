package dk.molslinjen.api.services;

import dk.molslinjen.api.helpers.ApiResult;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JN\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\n\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0006\u001a\u00020\u00052(\u0010\u000b\u001a$\b\u0001\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007H\u0084@¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Ldk/molslinjen/api/services/BaseService;", BuildConfig.FLAVOR, "<init>", "()V", "T", "Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "Ldk/molslinjen/api/helpers/ApiResult;", "block", "withContextHandlingErrors", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class BaseService {
    /* JADX INFO: Access modifiers changed from: protected */
    public final <T> Object withContextHandlingErrors(CoroutineDispatcher coroutineDispatcher, Function2<? super CoroutineScope, ? super Continuation<? super ApiResult<? extends T>>, ? extends Object> function2, Continuation<? super ApiResult<? extends T>> continuation) {
        return BuildersKt.withContext(coroutineDispatcher, new BaseService$withContextHandlingErrors$2(function2, null), continuation);
    }
}
