package com.sdk.growthbook.network;

import java.io.IOException;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.sdk.growthbook.network.GBNetworkDispatcherOkHttp$consumePOSTRequest$1", f = "GBNetworkDispatcherOkHttp.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes2.dex */
final class GBNetworkDispatcherOkHttp$consumePOSTRequest$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Map<String, Object> $bodyParams;
    final /* synthetic */ Function1<Throwable, Unit> $onError;
    final /* synthetic */ Function1<String, Unit> $onSuccess;
    final /* synthetic */ String $url;
    int label;
    final /* synthetic */ GBNetworkDispatcherOkHttp this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public GBNetworkDispatcherOkHttp$consumePOSTRequest$1(Map<String, ? extends Object> map, String str, GBNetworkDispatcherOkHttp gBNetworkDispatcherOkHttp, Function1<? super Throwable, Unit> function1, Function1<? super String, Unit> function12, Continuation<? super GBNetworkDispatcherOkHttp$consumePOSTRequest$1> continuation) {
        super(2, continuation);
        this.$bodyParams = map;
        this.$url = str;
        this.this$0 = gBNetworkDispatcherOkHttp;
        this.$onError = function1;
        this.$onSuccess = function12;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GBNetworkDispatcherOkHttp$consumePOSTRequest$1(this.$bodyParams, this.$url, this.this$0, this.$onError, this.$onSuccess, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        OkHttpClient okHttpClient;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        Request build = new Request.Builder().url(this.$url).addHeader("Content-Type", "application/json").addHeader("Accept", "application/json").post(RequestBody.INSTANCE.create(GBNetworkDispatcherOkHttpKt.toJsonElement(this.$bodyParams).toString(), MediaType.INSTANCE.parse("application/json; charset=utf-8"))).build();
        okHttpClient = this.this$0.client;
        Call newCall = okHttpClient.newCall(build);
        final Function1<Throwable, Unit> function1 = this.$onError;
        final Function1<String, Unit> function12 = this.$onSuccess;
        newCall.enqueue(new Callback() { // from class: com.sdk.growthbook.network.GBNetworkDispatcherOkHttp$consumePOSTRequest$1.1
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException e5) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(e5, "e");
                function1.invoke(e5);
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) {
                int code;
                Unit unit;
                String string;
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                Function1<Throwable, Unit> function13 = function1;
                Function1<String, Unit> function14 = function12;
                try {
                    if (!response.isSuccessful() || 200 > (code = response.getCode()) || code >= 300) {
                        function13.invoke(new IOException("Unexpected code " + response));
                        CloseableKt.closeFinally(response, null);
                        return;
                    }
                    ResponseBody body = response.getBody();
                    if (body == null || (string = body.string()) == null) {
                        unit = null;
                    } else {
                        function14.invoke(string);
                        unit = Unit.INSTANCE;
                    }
                    if (unit == null) {
                        function13.invoke(new IOException("Response body is null: " + response.getBody()));
                    }
                    Unit unit2 = Unit.INSTANCE;
                    CloseableKt.closeFinally(response, null);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(response, th);
                        throw th2;
                    }
                }
            }
        });
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GBNetworkDispatcherOkHttp$consumePOSTRequest$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
