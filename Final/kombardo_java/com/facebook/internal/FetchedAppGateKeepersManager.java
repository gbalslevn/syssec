package com.facebook.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.internal.FetchedAppGateKeepersManager;
import com.facebook.internal.gatekeeper.GateKeeper;
import com.facebook.internal.gatekeeper.GateKeeperRuntimeCache;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import org.conscrypt.BuildConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001<B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\u0003J\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J)\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0012\u001a\u00020\fH\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000eH\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001d\u001a\u00020\f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\u0003J#\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f0\u001f2\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b \u0010!R\u0016\u0010\"\u001a\u0004\u0018\u00010\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b$\u0010#R\u0014\u0010%\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b%\u0010#R\u0014\u0010&\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b&\u0010#R\u0014\u0010'\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b'\u0010#R\u0014\u0010(\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b(\u0010#R\u0014\u0010)\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b)\u0010#R\u0014\u0010*\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b*\u0010#R\u0014\u0010+\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b+\u0010#R\u0014\u0010,\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b,\u0010#R\u0014\u0010.\u001a\u00020-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u001a\u00101\u001a\b\u0012\u0004\u0012\u00020\u0004008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R \u00104\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000e038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0014\u00106\u001a\u00020\u001b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u00108R\u0018\u0010:\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;¨\u0006="}, d2 = {"Lcom/facebook/internal/FetchedAppGateKeepersManager;", BuildConfig.FLAVOR, "<init>", "()V", "Lcom/facebook/internal/FetchedAppGateKeepersManager$Callback;", com.sun.jna.Callback.METHOD_NAME, BuildConfig.FLAVOR, "loadAppGateKeepersAsync", "(Lcom/facebook/internal/FetchedAppGateKeepersManager$Callback;)V", "pollCallbacks", BuildConfig.FLAVOR, "applicationId", BuildConfig.FLAVOR, "forceRequery", "Lorg/json/JSONObject;", "queryAppGateKeepers", "(Ljava/lang/String;Z)Lorg/json/JSONObject;", "name", "defaultValue", "getGateKeeperForKey", "(Ljava/lang/String;Ljava/lang/String;Z)Z", "getAppGateKeepersQueryResponse", "(Ljava/lang/String;)Lorg/json/JSONObject;", "gateKeepersJSON", "parseAppGateKeepersFromJSON$facebook_core_release", "(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;", "parseAppGateKeepersFromJSON", BuildConfig.FLAVOR, "timestamp", "isTimestampValid", "(Ljava/lang/Long;)Z", BuildConfig.FLAVOR, "getGateKeepersForApplication", "(Ljava/lang/String;)Ljava/util/Map;", "TAG", "Ljava/lang/String;", "APP_GATEKEEPERS_PREFS_STORE", "APP_GATEKEEPERS_PREFS_KEY_FORMAT", "APP_PLATFORM", "APPLICATION_GATEKEEPER_EDGE", "APPLICATION_GATEKEEPER_FIELD", "APPLICATION_GRAPH_DATA", "APPLICATION_FIELDS", "APPLICATION_PLATFORM", "APPLICATION_SDK_VERSION", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isLoading", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "callbacks", "Ljava/util/concurrent/ConcurrentLinkedQueue;", BuildConfig.FLAVOR, "fetchedAppGateKeepers", "Ljava/util/Map;", "APPLICATION_GATEKEEPER_CACHE_TIMEOUT", "J", "Ljava/lang/Long;", "Lcom/facebook/internal/gatekeeper/GateKeeperRuntimeCache;", "gateKeeperRuntimeCache", "Lcom/facebook/internal/gatekeeper/GateKeeperRuntimeCache;", "Callback", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class FetchedAppGateKeepersManager {
    private static final String APPLICATION_FIELDS = "fields";
    private static final long APPLICATION_GATEKEEPER_CACHE_TIMEOUT = 3600000;
    private static final String APPLICATION_GATEKEEPER_EDGE = "mobile_sdk_gk";
    private static final String APPLICATION_GATEKEEPER_FIELD = "gatekeepers";
    private static final String APPLICATION_GRAPH_DATA = "data";
    private static final String APPLICATION_PLATFORM = "platform";
    private static final String APPLICATION_SDK_VERSION = "sdk_version";
    private static final String APP_GATEKEEPERS_PREFS_KEY_FORMAT = "com.facebook.internal.APP_GATEKEEPERS.%s";
    private static final String APP_GATEKEEPERS_PREFS_STORE = "com.facebook.internal.preferences.APP_GATEKEEPERS";
    private static final String APP_PLATFORM = "android";
    private static GateKeeperRuntimeCache gateKeeperRuntimeCache;
    private static Long timestamp;
    public static final FetchedAppGateKeepersManager INSTANCE = new FetchedAppGateKeepersManager();
    private static final String TAG = Reflection.getOrCreateKotlinClass(FetchedAppGateKeepersManager.class).getSimpleName();
    private static final AtomicBoolean isLoading = new AtomicBoolean(false);
    private static final ConcurrentLinkedQueue<Callback> callbacks = new ConcurrentLinkedQueue<>();
    private static final Map<String, JSONObject> fetchedAppGateKeepers = new ConcurrentHashMap();

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/facebook/internal/FetchedAppGateKeepersManager$Callback;", BuildConfig.FLAVOR, "onCompleted", BuildConfig.FLAVOR, "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes.dex */
    public interface Callback {
        void onCompleted();
    }

    private FetchedAppGateKeepersManager() {
    }

    private final JSONObject getAppGateKeepersQueryResponse(String applicationId) {
        Bundle bundle = new Bundle();
        bundle.putString(APPLICATION_PLATFORM, APP_PLATFORM);
        bundle.putString(APPLICATION_SDK_VERSION, FacebookSdk.getSdkVersion());
        bundle.putString(APPLICATION_FIELDS, APPLICATION_GATEKEEPER_FIELD);
        GraphRequest.Companion companion = GraphRequest.INSTANCE;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("app/%s", Arrays.copyOf(new Object[]{APPLICATION_GATEKEEPER_EDGE}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
        GraphRequest newGraphPathRequest = companion.newGraphPathRequest(null, format, null);
        newGraphPathRequest.setParameters(bundle);
        JSONObject jsonObject = newGraphPathRequest.executeAndWait().getJsonObject();
        return jsonObject == null ? new JSONObject() : jsonObject;
    }

    public static final boolean getGateKeeperForKey(String name, String applicationId, boolean defaultValue) {
        Boolean bool;
        Intrinsics.checkNotNullParameter(name, "name");
        Map<String, Boolean> gateKeepersForApplication = INSTANCE.getGateKeepersForApplication(applicationId);
        return (gateKeepersForApplication.containsKey(name) && (bool = gateKeepersForApplication.get(name)) != null) ? bool.booleanValue() : defaultValue;
    }

    private final boolean isTimestampValid(Long timestamp2) {
        return timestamp2 != null && System.currentTimeMillis() - timestamp2.longValue() < APPLICATION_GATEKEEPER_CACHE_TIMEOUT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: loadAppGateKeepersAsync$lambda-0, reason: not valid java name */
    public static final void m2855loadAppGateKeepersAsync$lambda0(String applicationId, Context context, String gateKeepersKey) {
        Intrinsics.checkNotNullParameter(applicationId, "$applicationId");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(gateKeepersKey, "$gateKeepersKey");
        FetchedAppGateKeepersManager fetchedAppGateKeepersManager = INSTANCE;
        JSONObject appGateKeepersQueryResponse = fetchedAppGateKeepersManager.getAppGateKeepersQueryResponse(applicationId);
        if (appGateKeepersQueryResponse.length() != 0) {
            parseAppGateKeepersFromJSON$facebook_core_release(applicationId, appGateKeepersQueryResponse);
            context.getSharedPreferences(APP_GATEKEEPERS_PREFS_STORE, 0).edit().putString(gateKeepersKey, appGateKeepersQueryResponse.toString()).apply();
            timestamp = Long.valueOf(System.currentTimeMillis());
        }
        fetchedAppGateKeepersManager.pollCallbacks();
        isLoading.set(false);
    }

    public static final synchronized JSONObject parseAppGateKeepersFromJSON$facebook_core_release(String applicationId, JSONObject gateKeepersJSON) {
        JSONObject jSONObject;
        JSONArray optJSONArray;
        synchronized (FetchedAppGateKeepersManager.class) {
            try {
                Intrinsics.checkNotNullParameter(applicationId, "applicationId");
                jSONObject = fetchedAppGateKeepers.get(applicationId);
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                int i5 = 0;
                JSONObject jSONObject2 = null;
                if (gateKeepersJSON != null && (optJSONArray = gateKeepersJSON.optJSONArray(APPLICATION_GRAPH_DATA)) != null) {
                    jSONObject2 = optJSONArray.optJSONObject(0);
                }
                if (jSONObject2 == null) {
                    jSONObject2 = new JSONObject();
                }
                JSONArray optJSONArray2 = jSONObject2.optJSONArray(APPLICATION_GATEKEEPER_FIELD);
                if (optJSONArray2 == null) {
                    optJSONArray2 = new JSONArray();
                }
                int length = optJSONArray2.length();
                if (length > 0) {
                    while (true) {
                        int i6 = i5 + 1;
                        try {
                            JSONObject jSONObject3 = optJSONArray2.getJSONObject(i5);
                            jSONObject.put(jSONObject3.getString("key"), jSONObject3.getBoolean("value"));
                        } catch (JSONException e5) {
                            Utility.logd("FacebookSDK", e5);
                        }
                        if (i6 >= length) {
                            break;
                        }
                        i5 = i6;
                    }
                }
                fetchedAppGateKeepers.put(applicationId, jSONObject);
            } catch (Throwable th) {
                throw th;
            }
        }
        return jSONObject;
    }

    private final void pollCallbacks() {
        Handler handler = new Handler(Looper.getMainLooper());
        while (true) {
            ConcurrentLinkedQueue<Callback> concurrentLinkedQueue = callbacks;
            if (concurrentLinkedQueue.isEmpty()) {
                return;
            }
            final Callback poll = concurrentLinkedQueue.poll();
            if (poll != null) {
                handler.post(new Runnable() { // from class: o0.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        FetchedAppGateKeepersManager.Callback.this.onCompleted();
                    }
                });
            }
        }
    }

    public static final JSONObject queryAppGateKeepers(String applicationId, boolean forceRequery) {
        Intrinsics.checkNotNullParameter(applicationId, "applicationId");
        if (!forceRequery) {
            Map<String, JSONObject> map = fetchedAppGateKeepers;
            if (map.containsKey(applicationId)) {
                JSONObject jSONObject = map.get(applicationId);
                return jSONObject == null ? new JSONObject() : jSONObject;
            }
        }
        JSONObject appGateKeepersQueryResponse = INSTANCE.getAppGateKeepersQueryResponse(applicationId);
        Context applicationContext = FacebookSdk.getApplicationContext();
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(APP_GATEKEEPERS_PREFS_KEY_FORMAT, Arrays.copyOf(new Object[]{applicationId}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
        applicationContext.getSharedPreferences(APP_GATEKEEPERS_PREFS_STORE, 0).edit().putString(format, appGateKeepersQueryResponse.toString()).apply();
        return parseAppGateKeepersFromJSON$facebook_core_release(applicationId, appGateKeepersQueryResponse);
    }

    public final Map<String, Boolean> getGateKeepersForApplication(String applicationId) {
        loadAppGateKeepersAsync();
        if (applicationId != null) {
            Map<String, JSONObject> map = fetchedAppGateKeepers;
            if (map.containsKey(applicationId)) {
                GateKeeperRuntimeCache gateKeeperRuntimeCache2 = gateKeeperRuntimeCache;
                List<GateKeeper> dumpGateKeepers = gateKeeperRuntimeCache2 == null ? null : gateKeeperRuntimeCache2.dumpGateKeepers(applicationId);
                if (dumpGateKeepers != null) {
                    HashMap hashMap = new HashMap();
                    for (GateKeeper gateKeeper : dumpGateKeepers) {
                        hashMap.put(gateKeeper.getName(), Boolean.valueOf(gateKeeper.getValue()));
                    }
                    return hashMap;
                }
                HashMap hashMap2 = new HashMap();
                JSONObject jSONObject = map.get(applicationId);
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String key = keys.next();
                    Intrinsics.checkNotNullExpressionValue(key, "key");
                    hashMap2.put(key, Boolean.valueOf(jSONObject.optBoolean(key)));
                }
                GateKeeperRuntimeCache gateKeeperRuntimeCache3 = gateKeeperRuntimeCache;
                if (gateKeeperRuntimeCache3 == null) {
                    gateKeeperRuntimeCache3 = new GateKeeperRuntimeCache();
                }
                ArrayList arrayList = new ArrayList(hashMap2.size());
                for (Map.Entry entry : hashMap2.entrySet()) {
                    arrayList.add(new GateKeeper((String) entry.getKey(), ((Boolean) entry.getValue()).booleanValue()));
                }
                gateKeeperRuntimeCache3.setGateKeepers(applicationId, arrayList);
                gateKeeperRuntimeCache = gateKeeperRuntimeCache3;
                return hashMap2;
            }
        }
        return new HashMap();
    }

    public final void loadAppGateKeepersAsync() {
        loadAppGateKeepersAsync(null);
    }

    public static final synchronized void loadAppGateKeepersAsync(Callback callback) {
        synchronized (FetchedAppGateKeepersManager.class) {
            if (callback != null) {
                try {
                    callbacks.add(callback);
                } catch (Throwable th) {
                    throw th;
                }
            }
            final String applicationId = FacebookSdk.getApplicationId();
            FetchedAppGateKeepersManager fetchedAppGateKeepersManager = INSTANCE;
            if (fetchedAppGateKeepersManager.isTimestampValid(timestamp) && fetchedAppGateKeepers.containsKey(applicationId)) {
                fetchedAppGateKeepersManager.pollCallbacks();
                return;
            }
            final Context applicationContext = FacebookSdk.getApplicationContext();
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            final String format = String.format(APP_GATEKEEPERS_PREFS_KEY_FORMAT, Arrays.copyOf(new Object[]{applicationId}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
            if (applicationContext == null) {
                return;
            }
            JSONObject jSONObject = null;
            String string = applicationContext.getSharedPreferences(APP_GATEKEEPERS_PREFS_STORE, 0).getString(format, null);
            if (!Utility.isNullOrEmpty(string)) {
                try {
                    jSONObject = new JSONObject(string);
                } catch (JSONException e5) {
                    Utility.logd("FacebookSDK", e5);
                }
                if (jSONObject != null) {
                    parseAppGateKeepersFromJSON$facebook_core_release(applicationId, jSONObject);
                }
            }
            Executor executor = FacebookSdk.getExecutor();
            if (executor == null) {
                return;
            }
            if (isLoading.compareAndSet(false, true)) {
                executor.execute(new Runnable() { // from class: o0.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        FetchedAppGateKeepersManager.m2855loadAppGateKeepersAsync$lambda0(applicationId, applicationContext, format);
                    }
                });
            }
        }
    }
}
