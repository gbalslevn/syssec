package com.google.firebase.perf.network;

import androidx.annotation.Keep;
import com.google.firebase.perf.metrics.NetworkRequestMetricBuilder;
import com.google.firebase.perf.transport.TransportManager;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.perf.util.URLWrapper;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;

/* loaded from: classes2.dex */
public class FirebasePerfUrlConnection {
    @Keep
    public static Object getContent(URL url) {
        return getContent(new URLWrapper(url), TransportManager.getInstance(), new Timer());
    }

    @Keep
    public static Object instrument(Object obj) {
        return obj instanceof HttpsURLConnection ? new InstrHttpsURLConnection((HttpsURLConnection) obj, new Timer(), NetworkRequestMetricBuilder.builder(TransportManager.getInstance())) : obj instanceof HttpURLConnection ? new InstrHttpURLConnection((HttpURLConnection) obj, new Timer(), NetworkRequestMetricBuilder.builder(TransportManager.getInstance())) : obj;
    }

    @Keep
    public static InputStream openStream(URL url) {
        return openStream(new URLWrapper(url), TransportManager.getInstance(), new Timer());
    }

    @Keep
    public static Object getContent(URL url, Class[] clsArr) {
        return getContent(new URLWrapper(url), clsArr, TransportManager.getInstance(), new Timer());
    }

    static InputStream openStream(URLWrapper uRLWrapper, TransportManager transportManager, Timer timer) {
        if (!TransportManager.getInstance().isInitialized()) {
            return uRLWrapper.openConnection().getInputStream();
        }
        timer.reset();
        long micros = timer.getMicros();
        NetworkRequestMetricBuilder builder = NetworkRequestMetricBuilder.builder(transportManager);
        try {
            URLConnection openConnection = uRLWrapper.openConnection();
            if (openConnection instanceof HttpsURLConnection) {
                return new InstrHttpsURLConnection((HttpsURLConnection) openConnection, timer, builder).getInputStream();
            }
            if (openConnection instanceof HttpURLConnection) {
                return new InstrHttpURLConnection((HttpURLConnection) openConnection, timer, builder).getInputStream();
            }
            return openConnection.getInputStream();
        } catch (IOException e5) {
            builder.setRequestStartTimeMicros(micros);
            builder.setTimeToResponseCompletedMicros(timer.getDurationMicros());
            builder.setUrl(uRLWrapper.toString());
            NetworkRequestMetricBuilderUtil.logError(builder);
            throw e5;
        }
    }

    static Object getContent(URLWrapper uRLWrapper, TransportManager transportManager, Timer timer) {
        timer.reset();
        long micros = timer.getMicros();
        NetworkRequestMetricBuilder builder = NetworkRequestMetricBuilder.builder(transportManager);
        try {
            URLConnection openConnection = uRLWrapper.openConnection();
            if (openConnection instanceof HttpsURLConnection) {
                return new InstrHttpsURLConnection((HttpsURLConnection) openConnection, timer, builder).getContent();
            }
            if (openConnection instanceof HttpURLConnection) {
                return new InstrHttpURLConnection((HttpURLConnection) openConnection, timer, builder).getContent();
            }
            return openConnection.getContent();
        } catch (IOException e5) {
            builder.setRequestStartTimeMicros(micros);
            builder.setTimeToResponseCompletedMicros(timer.getDurationMicros());
            builder.setUrl(uRLWrapper.toString());
            NetworkRequestMetricBuilderUtil.logError(builder);
            throw e5;
        }
    }

    static Object getContent(URLWrapper uRLWrapper, Class[] clsArr, TransportManager transportManager, Timer timer) {
        timer.reset();
        long micros = timer.getMicros();
        NetworkRequestMetricBuilder builder = NetworkRequestMetricBuilder.builder(transportManager);
        try {
            URLConnection openConnection = uRLWrapper.openConnection();
            if (openConnection instanceof HttpsURLConnection) {
                return new InstrHttpsURLConnection((HttpsURLConnection) openConnection, timer, builder).getContent(clsArr);
            }
            if (openConnection instanceof HttpURLConnection) {
                return new InstrHttpURLConnection((HttpURLConnection) openConnection, timer, builder).getContent(clsArr);
            }
            return openConnection.getContent(clsArr);
        } catch (IOException e5) {
            builder.setRequestStartTimeMicros(micros);
            builder.setTimeToResponseCompletedMicros(timer.getDurationMicros());
            builder.setUrl(uRLWrapper.toString());
            NetworkRequestMetricBuilderUtil.logError(builder);
            throw e5;
        }
    }
}
