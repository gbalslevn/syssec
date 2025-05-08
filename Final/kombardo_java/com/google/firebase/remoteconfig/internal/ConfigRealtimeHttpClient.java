package com.google.firebase.remoteconfig.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.installations.InstallationTokenResult;
import com.google.firebase.remoteconfig.ConfigUpdate;
import com.google.firebase.remoteconfig.ConfigUpdateListener;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigClientException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigServerException;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class ConfigRealtimeHttpClient {
    private static final String API_KEY_HEADER = "X-Goog-Api-Key";
    static final int[] BACKOFF_TIME_DURATIONS_IN_MINUTES = {2, 4, 8, 16, 32, 64, 128, 256};
    private static final Pattern GMP_APP_ID_PATTERN = Pattern.compile("^[^:]+:([0-9]+):(android|ios|web):([0-9a-f]+)");
    private static final String INSTALLATIONS_AUTH_TOKEN_HEADER = "X-Goog-Firebase-Installations-Auth";
    private static final String X_ACCEPT_RESPONSE_STREAMING = "X-Accept-Response-Streaming";
    private static final String X_ANDROID_CERT_HEADER = "X-Android-Cert";
    private static final String X_ANDROID_PACKAGE_HEADER = "X-Android-Package";
    private static final String X_GOOGLE_GFE_CAN_RETRY = "X-Google-GFE-Can-Retry";
    ConfigCacheClient activatedCache;
    private final ConfigFetchHandler configFetchHandler;
    private final Context context;
    private final FirebaseApp firebaseApp;
    private final FirebaseInstallationsApi firebaseInstallations;
    private int httpRetriesRemaining;
    private final Set<ConfigUpdateListener> listeners;
    private final String namespace;
    private final ScheduledExecutorService scheduledExecutorService;
    private final ConfigSharedPrefsClient sharedPrefsClient;
    private final int ORIGINAL_RETRIES = 8;
    private boolean isHttpConnectionRunning = false;
    private final Random random = new Random();
    private final Clock clock = DefaultClock.getInstance();
    private boolean isRealtimeDisabled = false;
    private boolean isInBackground = false;

    public ConfigRealtimeHttpClient(FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallationsApi, ConfigFetchHandler configFetchHandler, ConfigCacheClient configCacheClient, Context context, String str, Set<ConfigUpdateListener> set, ConfigSharedPrefsClient configSharedPrefsClient, ScheduledExecutorService scheduledExecutorService) {
        this.listeners = set;
        this.scheduledExecutorService = scheduledExecutorService;
        this.httpRetriesRemaining = Math.max(8 - configSharedPrefsClient.getRealtimeBackoffMetadata().getNumFailedStreams(), 1);
        this.firebaseApp = firebaseApp;
        this.configFetchHandler = configFetchHandler;
        this.firebaseInstallations = firebaseInstallationsApi;
        this.activatedCache = configCacheClient;
        this.context = context;
        this.namespace = str;
        this.sharedPrefsClient = configSharedPrefsClient;
    }

    private synchronized boolean canMakeHttpStreamConnection() {
        boolean z5;
        if (!this.listeners.isEmpty() && !this.isHttpConnectionRunning && !this.isRealtimeDisabled) {
            z5 = this.isInBackground ? false : true;
        }
        return z5;
    }

    private JSONObject createRequestBody(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("project", extractProjectNumberFromAppId(this.firebaseApp.getOptions().getApplicationId()));
        hashMap.put("namespace", this.namespace);
        hashMap.put("lastKnownVersionNumber", Long.toString(this.configFetchHandler.getTemplateVersionNumber()));
        hashMap.put("appId", this.firebaseApp.getOptions().getApplicationId());
        hashMap.put("sdkVersion", "22.1.0");
        hashMap.put("appInstanceId", str);
        return new JSONObject(hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void enableBackoff() {
        this.isRealtimeDisabled = true;
    }

    private static String extractProjectNumberFromAppId(String str) {
        Matcher matcher = GMP_APP_ID_PATTERN.matcher(str);
        if (matcher.matches()) {
            return matcher.group(1);
        }
        return null;
    }

    private String getFingerprintHashForPackage() {
        try {
            Context context = this.context;
            byte[] packageCertificateHashBytes = AndroidUtilsLight.getPackageCertificateHashBytes(context, context.getPackageName());
            if (packageCertificateHashBytes != null) {
                return Hex.bytesToStringUppercase(packageCertificateHashBytes, false);
            }
            Log.e("FirebaseRemoteConfig", "Could not get fingerprint hash for package: " + this.context.getPackageName());
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            Log.i("FirebaseRemoteConfig", "No such package: " + this.context.getPackageName());
            return null;
        }
    }

    private long getRandomizedBackoffDurationInMillis(int i5) {
        int length = BACKOFF_TIME_DURATIONS_IN_MINUTES.length;
        if (i5 >= length) {
            i5 = length;
        }
        return (TimeUnit.MINUTES.toMillis(r0[i5 - 1]) / 2) + this.random.nextInt((int) r0);
    }

    private String getRealtimeURL(String str) {
        return String.format("https://firebaseremoteconfigrealtime.googleapis.com/v1/projects/%s/namespaces/%s:streamFetchInvalidations", extractProjectNumberFromAppId(this.firebaseApp.getOptions().getApplicationId()), str);
    }

    private URL getUrl() {
        try {
            return new URL(getRealtimeURL(this.namespace));
        } catch (MalformedURLException unused) {
            Log.e("FirebaseRemoteConfig", "URL is malformed");
            return null;
        }
    }

    private boolean isStatusCodeRetryable(int i5) {
        return i5 == 408 || i5 == 429 || i5 == 502 || i5 == 503 || i5 == 504;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [com.google.android.gms.tasks.Task] */
    /* JADX WARN: Type inference failed for: r10v14, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v4, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r10v7, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r9v0, types: [com.google.firebase.remoteconfig.internal.ConfigRealtimeHttpClient] */
    public /* synthetic */ Task lambda$beginRealtimeHttpStream$1(Task task, Task task2) {
        Integer num;
        Throwable th;
        Integer num2;
        FirebaseRemoteConfigServerException firebaseRemoteConfigServerException;
        int responseCode;
        boolean isStatusCodeRetryable;
        boolean z5 = true;
        try {
            try {
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e5) {
            e = e5;
            task = 0;
            num2 = null;
        } catch (Throwable th3) {
            num = null;
            th = th3;
            task = 0;
        }
        if (!task.isSuccessful()) {
            throw new IOException(task.getException());
        }
        setIsHttpConnectionRunning(true);
        task = (HttpURLConnection) task.getResult();
        try {
            responseCode = task.getResponseCode();
            num2 = Integer.valueOf(responseCode);
            if (responseCode == 200) {
                try {
                    resetRetryCount();
                    this.sharedPrefsClient.resetRealtimeBackoff();
                    startAutoFetch(task).listenForNotifications();
                } catch (IOException e6) {
                    e = e6;
                    Log.d("FirebaseRemoteConfig", "Exception connecting to real-time RC backend. Retrying the connection...", e);
                    closeRealtimeHttpStream(task);
                    setIsHttpConnectionRunning(false);
                    if (num2 != null && !isStatusCodeRetryable(num2.intValue())) {
                        z5 = false;
                    }
                    if (z5) {
                        updateBackoffMetadataWithLastFailedStreamConnectionTime(new Date(this.clock.currentTimeMillis()));
                    }
                    if (!z5 && num2.intValue() != 200) {
                        String format = String.format("Unable to connect to the server. Try again in a few minutes. HTTP status code: %d", num2);
                        if (num2.intValue() == 403) {
                            format = parseForbiddenErrorResponseMessage(task.getErrorStream());
                        }
                        firebaseRemoteConfigServerException = new FirebaseRemoteConfigServerException(num2.intValue(), format, FirebaseRemoteConfigException.Code.CONFIG_UPDATE_STREAM_ERROR);
                        propagateErrors(firebaseRemoteConfigServerException);
                        return Tasks.forResult(null);
                    }
                    retryHttpConnectionWhenBackoffEnds();
                    return Tasks.forResult(null);
                }
            }
            closeRealtimeHttpStream(task);
            setIsHttpConnectionRunning(false);
            isStatusCodeRetryable = isStatusCodeRetryable(responseCode);
            if (isStatusCodeRetryable) {
                updateBackoffMetadataWithLastFailedStreamConnectionTime(new Date(this.clock.currentTimeMillis()));
            }
        } catch (IOException e7) {
            e = e7;
            num2 = null;
        } catch (Throwable th4) {
            num = null;
            th = th4;
            closeRealtimeHttpStream(task);
            setIsHttpConnectionRunning(false);
            if (num != null && !isStatusCodeRetryable(num.intValue())) {
                z5 = false;
            }
            if (z5) {
                updateBackoffMetadataWithLastFailedStreamConnectionTime(new Date(this.clock.currentTimeMillis()));
            }
            if (z5 || num.intValue() == 200) {
                retryHttpConnectionWhenBackoffEnds();
            } else {
                String format2 = String.format("Unable to connect to the server. Try again in a few minutes. HTTP status code: %d", num);
                if (num.intValue() == 403) {
                    format2 = parseForbiddenErrorResponseMessage(task.getErrorStream());
                }
                propagateErrors(new FirebaseRemoteConfigServerException(num.intValue(), format2, FirebaseRemoteConfigException.Code.CONFIG_UPDATE_STREAM_ERROR));
            }
            throw th;
        }
        if (!isStatusCodeRetryable && responseCode != 200) {
            String format3 = String.format("Unable to connect to the server. Try again in a few minutes. HTTP status code: %d", num2);
            if (responseCode == 403) {
                format3 = parseForbiddenErrorResponseMessage(task.getErrorStream());
            }
            firebaseRemoteConfigServerException = new FirebaseRemoteConfigServerException(responseCode, format3, FirebaseRemoteConfigException.Code.CONFIG_UPDATE_STREAM_ERROR);
            propagateErrors(firebaseRemoteConfigServerException);
            return Tasks.forResult(null);
        }
        retryHttpConnectionWhenBackoffEnds();
        return Tasks.forResult(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Task lambda$createRealtimeConnection$0(Task task, Task task2, Task task3) {
        if (!task.isSuccessful()) {
            return Tasks.forException(new FirebaseRemoteConfigClientException("Firebase Installations failed to get installation auth token for config update listener connection.", task.getException()));
        }
        if (!task2.isSuccessful()) {
            return Tasks.forException(new FirebaseRemoteConfigClientException("Firebase Installations failed to get installation ID for config update listener connection.", task2.getException()));
        }
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) getUrl().openConnection();
            setRequestParams(httpURLConnection, (String) task2.getResult(), ((InstallationTokenResult) task.getResult()).getToken());
            return Tasks.forResult(httpURLConnection);
        } catch (IOException e5) {
            return Tasks.forException(new FirebaseRemoteConfigClientException("Failed to open HTTP stream connection", e5));
        }
    }

    private synchronized void makeRealtimeHttpConnection(long j5) {
        try {
            if (canMakeHttpStreamConnection()) {
                int i5 = this.httpRetriesRemaining;
                if (i5 > 0) {
                    this.httpRetriesRemaining = i5 - 1;
                    this.scheduledExecutorService.schedule(new Runnable() { // from class: com.google.firebase.remoteconfig.internal.ConfigRealtimeHttpClient.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ConfigRealtimeHttpClient.this.beginRealtimeHttpStream();
                        }
                    }, j5, TimeUnit.MILLISECONDS);
                } else if (!this.isInBackground) {
                    propagateErrors(new FirebaseRemoteConfigClientException("Unable to connect to the server. Check your connection and try again.", FirebaseRemoteConfigException.Code.CONFIG_UPDATE_STREAM_ERROR));
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private String parseForbiddenErrorResponseMessage(InputStream inputStream) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
            }
        } catch (IOException unused) {
            if (sb.length() == 0) {
                return "Unable to connect to the server, access is forbidden. HTTP status code: 403";
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void propagateErrors(FirebaseRemoteConfigException firebaseRemoteConfigException) {
        Iterator<ConfigUpdateListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onError(firebaseRemoteConfigException);
        }
    }

    private synchronized void resetRetryCount() {
        this.httpRetriesRemaining = 8;
    }

    private void setCommonRequestHeaders(HttpURLConnection httpURLConnection, String str) {
        httpURLConnection.setRequestProperty(INSTALLATIONS_AUTH_TOKEN_HEADER, str);
        httpURLConnection.setRequestProperty(API_KEY_HEADER, this.firebaseApp.getOptions().getApiKey());
        httpURLConnection.setRequestProperty(X_ANDROID_PACKAGE_HEADER, this.context.getPackageName());
        httpURLConnection.setRequestProperty(X_ANDROID_CERT_HEADER, getFingerprintHashForPackage());
        httpURLConnection.setRequestProperty(X_GOOGLE_GFE_CAN_RETRY, "yes");
        httpURLConnection.setRequestProperty(X_ACCEPT_RESPONSE_STREAMING, "true");
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnection.setRequestProperty("Accept", "application/json");
    }

    private synchronized void setIsHttpConnectionRunning(boolean z5) {
        this.isHttpConnectionRunning = z5;
    }

    private void updateBackoffMetadataWithLastFailedStreamConnectionTime(Date date) {
        int numFailedStreams = this.sharedPrefsClient.getRealtimeBackoffMetadata().getNumFailedStreams() + 1;
        this.sharedPrefsClient.setRealtimeBackoffMetadata(numFailedStreams, new Date(date.getTime() + getRandomizedBackoffDurationInMillis(numFailedStreams)));
    }

    @SuppressLint({"VisibleForTests", "DefaultLocale"})
    public void beginRealtimeHttpStream() {
        if (canMakeHttpStreamConnection()) {
            if (new Date(this.clock.currentTimeMillis()).before(this.sharedPrefsClient.getRealtimeBackoffMetadata().getBackoffEndTime())) {
                retryHttpConnectionWhenBackoffEnds();
            } else {
                final Task<HttpURLConnection> createRealtimeConnection = createRealtimeConnection();
                Tasks.whenAllComplete((Task<?>[]) new Task[]{createRealtimeConnection}).continueWith(this.scheduledExecutorService, new Continuation() { // from class: com.google.firebase.remoteconfig.internal.k
                    @Override // com.google.android.gms.tasks.Continuation
                    public final Object then(Task task) {
                        Task lambda$beginRealtimeHttpStream$1;
                        lambda$beginRealtimeHttpStream$1 = ConfigRealtimeHttpClient.this.lambda$beginRealtimeHttpStream$1(createRealtimeConnection, task);
                        return lambda$beginRealtimeHttpStream$1;
                    }
                });
            }
        }
    }

    public void closeRealtimeHttpStream(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
            try {
                httpURLConnection.getInputStream().close();
                if (httpURLConnection.getErrorStream() != null) {
                    httpURLConnection.getErrorStream().close();
                }
            } catch (IOException unused) {
            }
        }
    }

    @SuppressLint({"VisibleForTests"})
    public Task<HttpURLConnection> createRealtimeConnection() {
        final Task<InstallationTokenResult> token = this.firebaseInstallations.getToken(false);
        final Task<String> id = this.firebaseInstallations.getId();
        return Tasks.whenAllComplete((Task<?>[]) new Task[]{token, id}).continueWithTask(this.scheduledExecutorService, new Continuation() { // from class: com.google.firebase.remoteconfig.internal.l
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                Task lambda$createRealtimeConnection$0;
                lambda$createRealtimeConnection$0 = ConfigRealtimeHttpClient.this.lambda$createRealtimeConnection$0(token, id, task);
                return lambda$createRealtimeConnection$0;
            }
        });
    }

    @SuppressLint({"VisibleForTests"})
    public synchronized void retryHttpConnectionWhenBackoffEnds() {
        makeRealtimeHttpConnection(Math.max(0L, this.sharedPrefsClient.getRealtimeBackoffMetadata().getBackoffEndTime().getTime() - new Date(this.clock.currentTimeMillis()).getTime()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setRealtimeBackgroundState(boolean z5) {
        this.isInBackground = z5;
    }

    @SuppressLint({"VisibleForTests"})
    public void setRequestParams(HttpURLConnection httpURLConnection, String str, String str2) {
        httpURLConnection.setRequestMethod("POST");
        setCommonRequestHeaders(httpURLConnection, str2);
        byte[] bytes = createRequestBody(str).toString().getBytes("utf-8");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
        bufferedOutputStream.write(bytes);
        bufferedOutputStream.flush();
        bufferedOutputStream.close();
    }

    @SuppressLint({"VisibleForTests"})
    public synchronized ConfigAutoFetch startAutoFetch(HttpURLConnection httpURLConnection) {
        return new ConfigAutoFetch(httpURLConnection, this.configFetchHandler, this.activatedCache, this.listeners, new ConfigUpdateListener() { // from class: com.google.firebase.remoteconfig.internal.ConfigRealtimeHttpClient.2
            @Override // com.google.firebase.remoteconfig.ConfigUpdateListener
            public void onError(FirebaseRemoteConfigException firebaseRemoteConfigException) {
                ConfigRealtimeHttpClient.this.enableBackoff();
                ConfigRealtimeHttpClient.this.propagateErrors(firebaseRemoteConfigException);
            }

            @Override // com.google.firebase.remoteconfig.ConfigUpdateListener
            public void onUpdate(ConfigUpdate configUpdate) {
            }
        }, this.scheduledExecutorService);
    }

    public void startHttpConnection() {
        makeRealtimeHttpConnection(0L);
    }
}
