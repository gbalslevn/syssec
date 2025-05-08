package com.google.firebase.remoteconfig.internal;

import android.util.Log;
import com.adjust.sdk.Constants;
import com.google.android.gms.common.util.BiConsumer;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigValue;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;
import org.conscrypt.BuildConfig;
import org.json.JSONException;

/* loaded from: classes2.dex */
public class ConfigGetParameterHandler {
    private final ConfigCacheClient activatedConfigsCache;
    private final ConfigCacheClient defaultConfigsCache;
    private final Executor executor;
    private final Set<BiConsumer<String, ConfigContainer>> listeners = new HashSet();
    public static final Charset FRC_BYTE_ARRAY_ENCODING = Charset.forName(Constants.ENCODING);
    static final Pattern TRUE_REGEX = Pattern.compile("^(1|true|t|yes|y|on)$", 2);
    static final Pattern FALSE_REGEX = Pattern.compile("^(0|false|f|no|n|off|)$", 2);

    public ConfigGetParameterHandler(Executor executor, ConfigCacheClient configCacheClient, ConfigCacheClient configCacheClient2) {
        this.executor = executor;
        this.activatedConfigsCache = configCacheClient;
        this.defaultConfigsCache = configCacheClient2;
    }

    private void callListeners(final String str, final ConfigContainer configContainer) {
        if (configContainer == null) {
            return;
        }
        synchronized (this.listeners) {
            try {
                for (final BiConsumer<String, ConfigContainer> biConsumer : this.listeners) {
                    this.executor.execute(new Runnable() { // from class: com.google.firebase.remoteconfig.internal.j
                        @Override // java.lang.Runnable
                        public final void run() {
                            BiConsumer.this.accept(str, configContainer);
                        }
                    });
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static ConfigContainer getConfigsFromCache(ConfigCacheClient configCacheClient) {
        return configCacheClient.getBlocking();
    }

    private static Set<String> getKeySetFromCache(ConfigCacheClient configCacheClient) {
        HashSet hashSet = new HashSet();
        ConfigContainer configsFromCache = getConfigsFromCache(configCacheClient);
        if (configsFromCache == null) {
            return hashSet;
        }
        Iterator<String> keys = configsFromCache.getConfigs().keys();
        while (keys.hasNext()) {
            hashSet.add(keys.next());
        }
        return hashSet;
    }

    private static String getStringFromCache(ConfigCacheClient configCacheClient, String str) {
        ConfigContainer configsFromCache = getConfigsFromCache(configCacheClient);
        if (configsFromCache == null) {
            return null;
        }
        try {
            return configsFromCache.getConfigs().getString(str);
        } catch (JSONException unused) {
            return null;
        }
    }

    private static void logParameterValueDoesNotExist(String str, String str2) {
        Log.w("FirebaseRemoteConfig", String.format("No value of type '%s' exists for parameter key '%s'.", str2, str));
    }

    public void addListener(BiConsumer<String, ConfigContainer> biConsumer) {
        synchronized (this.listeners) {
            this.listeners.add(biConsumer);
        }
    }

    public Map<String, FirebaseRemoteConfigValue> getAll() {
        HashSet<String> hashSet = new HashSet();
        hashSet.addAll(getKeySetFromCache(this.activatedConfigsCache));
        hashSet.addAll(getKeySetFromCache(this.defaultConfigsCache));
        HashMap hashMap = new HashMap();
        for (String str : hashSet) {
            hashMap.put(str, getValue(str));
        }
        return hashMap;
    }

    public FirebaseRemoteConfigValue getValue(String str) {
        String stringFromCache = getStringFromCache(this.activatedConfigsCache, str);
        if (stringFromCache != null) {
            callListeners(str, getConfigsFromCache(this.activatedConfigsCache));
            return new FirebaseRemoteConfigValueImpl(stringFromCache, 2);
        }
        String stringFromCache2 = getStringFromCache(this.defaultConfigsCache, str);
        if (stringFromCache2 != null) {
            return new FirebaseRemoteConfigValueImpl(stringFromCache2, 1);
        }
        logParameterValueDoesNotExist(str, "FirebaseRemoteConfigValue");
        return new FirebaseRemoteConfigValueImpl(BuildConfig.FLAVOR, 0);
    }
}
