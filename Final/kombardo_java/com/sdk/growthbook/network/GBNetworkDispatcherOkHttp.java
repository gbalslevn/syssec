package com.sdk.growthbook.network;

import com.sdk.growthbook.DispatcherKt;
import com.sdk.growthbook.utils.Resource;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J8\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\r0\f2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\r0\fH\u0016JL\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\n2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00140\u00132\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\r0\f2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\r0\fH\u0016J\u001c\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00170\u00162\u0006\u0010\u0011\u001a\u00020\nH\u0016J\u000e\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/sdk/growthbook/network/GBNetworkDispatcherOkHttp;", "Lcom/sdk/growthbook/network/NetworkDispatcher;", "client", "Lokhttp3/OkHttpClient;", "enableLogging", BuildConfig.FLAVOR, "(Lokhttp3/OkHttpClient;Z)V", "consumeGETRequest", "Lkotlinx/coroutines/Job;", "request", BuildConfig.FLAVOR, "onSuccess", "Lkotlin/Function1;", BuildConfig.FLAVOR, "onError", BuildConfig.FLAVOR, "consumePOSTRequest", "url", "bodyParams", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "consumeSSEConnection", "Lkotlinx/coroutines/flow/Flow;", "Lcom/sdk/growthbook/utils/Resource;", "setLoggingEnabled", "enabled", "NetworkDispatcherOkHttp_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class GBNetworkDispatcherOkHttp implements NetworkDispatcher {
    private final OkHttpClient client;
    private boolean enableLogging;

    /* JADX WARN: Multi-variable type inference failed */
    public GBNetworkDispatcherOkHttp() {
        this(null, false, 3, 0 == true ? 1 : 0);
    }

    @Override // com.sdk.growthbook.network.NetworkDispatcher
    public Job consumeGETRequest(String request, Function1<? super String, Unit> onSuccess, Function1<? super Throwable, Unit> onError) {
        Job launch$default;
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(DispatcherKt.getPlatformDependentIODispatcher()), null, null, new GBNetworkDispatcherOkHttp$consumeGETRequest$1(request, this, onError, onSuccess, null), 3, null);
        return launch$default;
    }

    @Override // com.sdk.growthbook.network.NetworkDispatcher
    public void consumePOSTRequest(String url, Map<String, ? extends Object> bodyParams, Function1<? super String, Unit> onSuccess, Function1<? super Throwable, Unit> onError) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(bodyParams, "bodyParams");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(DispatcherKt.getPlatformDependentIODispatcher()), null, null, new GBNetworkDispatcherOkHttp$consumePOSTRequest$1(bodyParams, url, this, onError, onSuccess, null), 3, null);
    }

    @Override // com.sdk.growthbook.network.NetworkDispatcher
    public Flow<Resource<String>> consumeSSEConnection(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        OkHttpClient.Builder retryOnConnectionFailure = new OkHttpClient.Builder().retryOnConnectionFailure(true);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        return FlowKt.callbackFlow(new GBNetworkDispatcherOkHttp$consumeSSEConnection$1(retryOnConnectionFailure.connectTimeout(0L, timeUnit).readTimeout(0L, timeUnit).writeTimeout(0L, timeUnit).build(), new Request.Builder().url(url).header("Accept", "application/json; q=0.5").addHeader("Accept", "text/event-stream").build(), this, null));
    }

    public final void setLoggingEnabled(boolean enabled) {
        this.enableLogging = enabled;
    }

    public GBNetworkDispatcherOkHttp(OkHttpClient client, boolean z5) {
        Intrinsics.checkNotNullParameter(client, "client");
        this.client = client;
        this.enableLogging = z5;
    }

    public /* synthetic */ GBNetworkDispatcherOkHttp(OkHttpClient okHttpClient, boolean z5, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? new OkHttpClient() : okHttpClient, (i5 & 2) != 0 ? false : z5);
    }
}
