package com.sdk.growthbook.utils;

import kotlin.Metadata;
import okhttp3.sse.EventSource;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&¨\u0006\t"}, d2 = {"Lcom/sdk/growthbook/utils/GBEventSourceHandler;", BuildConfig.FLAVOR, "onClose", BuildConfig.FLAVOR, "eventSource", "Lokhttp3/sse/EventSource;", "onFeaturesResponse", "featuresJsonResponse", BuildConfig.FLAVOR, "NetworkDispatcherOkHttp_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface GBEventSourceHandler {
    void onClose(EventSource eventSource);

    void onFeaturesResponse(String featuresJsonResponse);
}
