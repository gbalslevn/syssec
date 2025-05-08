package coil.intercept;

import coil.EventListener;
import coil.content.Utils;
import coil.intercept.EngineInterceptor;
import coil.intercept.Interceptor;
import coil.memory.MemoryCache;
import coil.memory.MemoryCacheService;
import coil.request.ImageRequest;
import coil.request.Options;
import coil.request.SuccessResult;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcoil/request/SuccessResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "coil.intercept.EngineInterceptor$intercept$2", f = "EngineInterceptor.kt", l = {75}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class EngineInterceptor$intercept$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SuccessResult>, Object> {
    final /* synthetic */ MemoryCache.Key $cacheKey;
    final /* synthetic */ Interceptor.Chain $chain;
    final /* synthetic */ EventListener $eventListener;
    final /* synthetic */ Object $mappedData;
    final /* synthetic */ Options $options;
    final /* synthetic */ ImageRequest $request;
    int label;
    final /* synthetic */ EngineInterceptor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EngineInterceptor$intercept$2(EngineInterceptor engineInterceptor, ImageRequest imageRequest, Object obj, Options options, EventListener eventListener, MemoryCache.Key key, Interceptor.Chain chain, Continuation<? super EngineInterceptor$intercept$2> continuation) {
        super(2, continuation);
        this.this$0 = engineInterceptor;
        this.$request = imageRequest;
        this.$mappedData = obj;
        this.$options = options;
        this.$eventListener = eventListener;
        this.$cacheKey = key;
        this.$chain = chain;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new EngineInterceptor$intercept$2(this.this$0, this.$request, this.$mappedData, this.$options, this.$eventListener, this.$cacheKey, this.$chain, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MemoryCacheService memoryCacheService;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            EngineInterceptor engineInterceptor = this.this$0;
            ImageRequest imageRequest = this.$request;
            Object obj2 = this.$mappedData;
            Options options = this.$options;
            EventListener eventListener = this.$eventListener;
            this.label = 1;
            obj = engineInterceptor.execute(imageRequest, obj2, options, eventListener, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        EngineInterceptor.ExecuteResult executeResult = (EngineInterceptor.ExecuteResult) obj;
        memoryCacheService = this.this$0.memoryCacheService;
        return new SuccessResult(executeResult.getDrawable(), this.$request, executeResult.getDataSource(), memoryCacheService.setCacheValue(this.$cacheKey, this.$request, executeResult) ? this.$cacheKey : null, executeResult.getDiskCacheKey(), executeResult.getIsSampled(), Utils.isPlaceholderCached(this.$chain));
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super SuccessResult> continuation) {
        return ((EngineInterceptor$intercept$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
