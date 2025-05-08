package com.google.firebase.perf.network;

import androidx.annotation.Keep;
import com.google.firebase.perf.metrics.NetworkRequestMetricBuilder;
import com.google.firebase.perf.transport.TransportManager;
import com.google.firebase.perf.util.Timer;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* loaded from: classes2.dex */
public class FirebasePerfOkHttpClient {
    @Keep
    public static void enqueue(Call call, Callback callback) {
        Timer timer = new Timer();
        call.enqueue(new InstrumentOkHttpEnqueueCallback(callback, TransportManager.getInstance(), timer, timer.getMicros()));
    }

    @Keep
    public static Response execute(Call call) {
        NetworkRequestMetricBuilder builder = NetworkRequestMetricBuilder.builder(TransportManager.getInstance());
        Timer timer = new Timer();
        long micros = timer.getMicros();
        try {
            Response execute = call.execute();
            sendNetworkMetric(execute, builder, micros, timer.getDurationMicros());
            return execute;
        } catch (IOException e5) {
            Request request = call.request();
            if (request != null) {
                HttpUrl url = request.getUrl();
                if (url != null) {
                    builder.setUrl(url.url().toString());
                }
                if (request.getMethod() != null) {
                    builder.setHttpMethod(request.getMethod());
                }
            }
            builder.setRequestStartTimeMicros(micros);
            builder.setTimeToResponseCompletedMicros(timer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(builder);
            throw e5;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void sendNetworkMetric(Response response, NetworkRequestMetricBuilder networkRequestMetricBuilder, long j5, long j6) {
        Request request = response.getRequest();
        if (request == null) {
            return;
        }
        networkRequestMetricBuilder.setUrl(request.getUrl().url().toString());
        networkRequestMetricBuilder.setHttpMethod(request.getMethod());
        if (request.getBody() != null) {
            long contentLength = request.getBody().contentLength();
            if (contentLength != -1) {
                networkRequestMetricBuilder.setRequestPayloadBytes(contentLength);
            }
        }
        ResponseBody body = response.getBody();
        if (body != null) {
            long contentLength2 = body.getContentLength();
            if (contentLength2 != -1) {
                networkRequestMetricBuilder.setResponsePayloadBytes(contentLength2);
            }
            MediaType mediaType = body.get$contentType();
            if (mediaType != null) {
                networkRequestMetricBuilder.setResponseContentType(mediaType.getMediaType());
            }
        }
        networkRequestMetricBuilder.setHttpResponseCode(response.getCode());
        networkRequestMetricBuilder.setRequestStartTimeMicros(j5);
        networkRequestMetricBuilder.setTimeToResponseCompletedMicros(j6);
        networkRequestMetricBuilder.build();
    }
}
