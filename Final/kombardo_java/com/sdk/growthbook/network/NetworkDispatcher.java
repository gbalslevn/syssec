package com.sdk.growthbook.network;

import com.sdk.growthbook.utils.Resource;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J8\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\b0\u0007H&JL\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00052\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u000e2\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\b0\u0007H&J\u001c\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00110\u00102\u0006\u0010\f\u001a\u00020\u0005H&¨\u0006\u0012"}, d2 = {"Lcom/sdk/growthbook/network/NetworkDispatcher;", BuildConfig.FLAVOR, "consumeGETRequest", "Lkotlinx/coroutines/Job;", "request", BuildConfig.FLAVOR, "onSuccess", "Lkotlin/Function1;", BuildConfig.FLAVOR, "onError", BuildConfig.FLAVOR, "consumePOSTRequest", "url", "bodyParams", BuildConfig.FLAVOR, "consumeSSEConnection", "Lkotlinx/coroutines/flow/Flow;", "Lcom/sdk/growthbook/utils/Resource;", "Core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface NetworkDispatcher {
    Job consumeGETRequest(String request, Function1<? super String, Unit> onSuccess, Function1<? super Throwable, Unit> onError);

    void consumePOSTRequest(String url, Map<String, ? extends Object> bodyParams, Function1<? super String, Unit> onSuccess, Function1<? super Throwable, Unit> onError);

    Flow<Resource<String>> consumeSSEConnection(String url);
}
