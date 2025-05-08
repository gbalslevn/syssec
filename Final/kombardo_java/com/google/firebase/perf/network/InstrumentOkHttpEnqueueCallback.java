package com.google.firebase.perf.network;

import com.google.firebase.perf.metrics.NetworkRequestMetricBuilder;
import com.google.firebase.perf.transport.TransportManager;
import com.google.firebase.perf.util.Timer;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: classes2.dex */
public class InstrumentOkHttpEnqueueCallback implements Callback {
    private final Callback callback;
    private final NetworkRequestMetricBuilder networkMetricBuilder;
    private final long startTimeMicros;
    private final Timer timer;

    public InstrumentOkHttpEnqueueCallback(Callback callback, TransportManager transportManager, Timer timer, long j5) {
        this.callback = callback;
        this.networkMetricBuilder = NetworkRequestMetricBuilder.builder(transportManager);
        this.startTimeMicros = j5;
        this.timer = timer;
    }

    @Override // okhttp3.Callback
    public void onFailure(Call call, IOException iOException) {
        Request request = call.request();
        if (request != null) {
            HttpUrl url = request.getUrl();
            if (url != null) {
                this.networkMetricBuilder.setUrl(url.url().toString());
            }
            if (request.getMethod() != null) {
                this.networkMetricBuilder.setHttpMethod(request.getMethod());
            }
        }
        this.networkMetricBuilder.setRequestStartTimeMicros(this.startTimeMicros);
        this.networkMetricBuilder.setTimeToResponseCompletedMicros(this.timer.getDurationMicros());
        NetworkRequestMetricBuilderUtil.logError(this.networkMetricBuilder);
        this.callback.onFailure(call, iOException);
    }

    @Override // okhttp3.Callback
    public void onResponse(Call call, Response response) {
        FirebasePerfOkHttpClient.sendNetworkMetric(response, this.networkMetricBuilder, this.startTimeMicros, this.timer.getDurationMicros());
        this.callback.onResponse(call, response);
    }
}
