package com.sdk.growthbook.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.sse.EventSource;
import okhttp3.sse.EventSourceListener;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J,\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/sdk/growthbook/utils/GBEventSourceListener;", "Lokhttp3/sse/EventSourceListener;", "handler", "Lcom/sdk/growthbook/utils/GBEventSourceHandler;", "enableLogging", BuildConfig.FLAVOR, "(Lcom/sdk/growthbook/utils/GBEventSourceHandler;Z)V", "onClosed", BuildConfig.FLAVOR, "eventSource", "Lokhttp3/sse/EventSource;", "onEvent", Constants.ID_ATTRIBUTE_KEY, BuildConfig.FLAVOR, "type", "data", "NetworkDispatcherOkHttp_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class GBEventSourceListener extends EventSourceListener {
    private final boolean enableLogging;
    private final GBEventSourceHandler handler;

    public GBEventSourceListener(GBEventSourceHandler handler, boolean z5) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.handler = handler;
        this.enableLogging = z5;
    }

    @Override // okhttp3.sse.EventSourceListener
    public void onClosed(EventSource eventSource) {
        Intrinsics.checkNotNullParameter(eventSource, "eventSource");
        super.onClosed(eventSource);
        this.handler.onClose(eventSource);
    }

    @Override // okhttp3.sse.EventSourceListener
    public void onEvent(EventSource eventSource, String id, String type, String data) {
        Intrinsics.checkNotNullParameter(eventSource, "eventSource");
        Intrinsics.checkNotNullParameter(data, "data");
        super.onEvent(eventSource, id, type, data);
        if (StringsKt.trim(data).toString().length() == 0) {
            return;
        }
        try {
            this.handler.onFeaturesResponse(data);
        } catch (Exception e5) {
            if (this.enableLogging) {
                System.out.println(e5);
            }
        }
    }
}
