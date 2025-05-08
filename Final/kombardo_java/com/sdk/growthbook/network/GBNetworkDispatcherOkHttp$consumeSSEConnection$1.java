package com.sdk.growthbook.network;

import com.sdk.growthbook.utils.GBEventSourceHandler;
import com.sdk.growthbook.utils.GBEventSourceListener;
import com.sdk.growthbook.utils.Resource;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.sse.EventSource;
import okhttp3.sse.EventSources;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/channels/ProducerScope;", "Lcom/sdk/growthbook/utils/Resource;", BuildConfig.FLAVOR}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.sdk.growthbook.network.GBNetworkDispatcherOkHttp$consumeSSEConnection$1", f = "GBNetworkDispatcherOkHttp.kt", l = {151}, m = "invokeSuspend")
/* loaded from: classes2.dex */
final class GBNetworkDispatcherOkHttp$consumeSSEConnection$1 extends SuspendLambda implements Function2<ProducerScope<? super Resource<? extends String>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Request $request;
    final /* synthetic */ OkHttpClient $sseHttpClient;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ GBNetworkDispatcherOkHttp this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GBNetworkDispatcherOkHttp$consumeSSEConnection$1(OkHttpClient okHttpClient, Request request, GBNetworkDispatcherOkHttp gBNetworkDispatcherOkHttp, Continuation<? super GBNetworkDispatcherOkHttp$consumeSSEConnection$1> continuation) {
        super(2, continuation);
        this.$sseHttpClient = okHttpClient;
        this.$request = request;
        this.this$0 = gBNetworkDispatcherOkHttp;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        GBNetworkDispatcherOkHttp$consumeSSEConnection$1 gBNetworkDispatcherOkHttp$consumeSSEConnection$1 = new GBNetworkDispatcherOkHttp$consumeSSEConnection$1(this.$sseHttpClient, this.$request, this.this$0, continuation);
        gBNetworkDispatcherOkHttp$consumeSSEConnection$1.L$0 = obj;
        return gBNetworkDispatcherOkHttp$consumeSSEConnection$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(ProducerScope<? super Resource<? extends String>> producerScope, Continuation<? super Unit> continuation) {
        return invoke2((ProducerScope<? super Resource<String>>) producerScope, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean z5;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            final ProducerScope producerScope = (ProducerScope) this.L$0;
            EventSource.Factory createFactory = EventSources.createFactory(this.$sseHttpClient);
            Request request = this.$request;
            GBEventSourceHandler gBEventSourceHandler = new GBEventSourceHandler() { // from class: com.sdk.growthbook.network.GBNetworkDispatcherOkHttp$consumeSSEConnection$1.1
                @Override // com.sdk.growthbook.utils.GBEventSourceHandler
                public void onClose(EventSource eventSource) {
                    if (eventSource != null) {
                        eventSource.cancel();
                    }
                    CoroutineScopeKt.cancel$default(producerScope, null, 1, null);
                }

                @Override // com.sdk.growthbook.utils.GBEventSourceHandler
                public void onFeaturesResponse(String featuresJsonResponse) {
                    if (featuresJsonResponse != null) {
                        ChannelResult.m3768boximpl(producerScope.mo3767trySendJP2dKIU(new Resource.Success(featuresJsonResponse)));
                    }
                }
            };
            z5 = this.this$0.enableLogging;
            createFactory.newEventSource(request, new GBEventSourceListener(gBEventSourceHandler, z5));
            this.label = 1;
            if (ProduceKt.awaitClose$default(producerScope, null, this, 1, null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(ProducerScope<? super Resource<String>> producerScope, Continuation<? super Unit> continuation) {
        return ((GBNetworkDispatcherOkHttp$consumeSSEConnection$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
