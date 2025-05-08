package coil.intercept;

import coil.ComponentRegistry;
import coil.EventListener;
import coil.fetch.FetchResult;
import coil.fetch.SourceResult;
import coil.intercept.EngineInterceptor;
import coil.request.ImageRequest;
import coil.request.Options;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcoil/intercept/EngineInterceptor$ExecuteResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "coil.intercept.EngineInterceptor$execute$executeResult$1", f = "EngineInterceptor.kt", l = {127}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class EngineInterceptor$execute$executeResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super EngineInterceptor.ExecuteResult>, Object> {
    final /* synthetic */ Ref$ObjectRef<ComponentRegistry> $components;
    final /* synthetic */ EventListener $eventListener;
    final /* synthetic */ Ref$ObjectRef<FetchResult> $fetchResult;
    final /* synthetic */ Object $mappedData;
    final /* synthetic */ Ref$ObjectRef<Options> $options;
    final /* synthetic */ ImageRequest $request;
    int label;
    final /* synthetic */ EngineInterceptor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EngineInterceptor$execute$executeResult$1(EngineInterceptor engineInterceptor, Ref$ObjectRef<FetchResult> ref$ObjectRef, Ref$ObjectRef<ComponentRegistry> ref$ObjectRef2, ImageRequest imageRequest, Object obj, Ref$ObjectRef<Options> ref$ObjectRef3, EventListener eventListener, Continuation<? super EngineInterceptor$execute$executeResult$1> continuation) {
        super(2, continuation);
        this.this$0 = engineInterceptor;
        this.$fetchResult = ref$ObjectRef;
        this.$components = ref$ObjectRef2;
        this.$request = imageRequest;
        this.$mappedData = obj;
        this.$options = ref$ObjectRef3;
        this.$eventListener = eventListener;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new EngineInterceptor$execute$executeResult$1(this.this$0, this.$fetchResult, this.$components, this.$request, this.$mappedData, this.$options, this.$eventListener, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            EngineInterceptor engineInterceptor = this.this$0;
            SourceResult sourceResult = (SourceResult) this.$fetchResult.element;
            ComponentRegistry componentRegistry = this.$components.element;
            ImageRequest imageRequest = this.$request;
            Object obj2 = this.$mappedData;
            Options options = this.$options.element;
            EventListener eventListener = this.$eventListener;
            this.label = 1;
            obj = engineInterceptor.decode(sourceResult, componentRegistry, imageRequest, obj2, options, eventListener, this);
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
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super EngineInterceptor.ExecuteResult> continuation) {
        return ((EngineInterceptor$execute$executeResult$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
