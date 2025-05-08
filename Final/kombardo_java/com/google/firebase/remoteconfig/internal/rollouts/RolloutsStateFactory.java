package com.google.firebase.remoteconfig.internal.rollouts;

import android.util.Log;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigClientException;
import com.google.firebase.remoteconfig.internal.ConfigCacheClient;
import com.google.firebase.remoteconfig.internal.ConfigContainer;
import com.google.firebase.remoteconfig.interop.rollouts.RolloutAssignment;
import com.google.firebase.remoteconfig.interop.rollouts.RolloutsState;
import java.util.HashSet;
import org.conscrypt.BuildConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class RolloutsStateFactory {
    ConfigCacheClient activatedConfigsCache;
    ConfigCacheClient defaultConfigsCache;

    RolloutsStateFactory(ConfigCacheClient configCacheClient, ConfigCacheClient configCacheClient2) {
        this.activatedConfigsCache = configCacheClient;
        this.defaultConfigsCache = configCacheClient2;
    }

    public static RolloutsStateFactory create(ConfigCacheClient configCacheClient, ConfigCacheClient configCacheClient2) {
        return new RolloutsStateFactory(configCacheClient, configCacheClient2);
    }

    private String getParameterValue(String str) {
        String stringFromCache = getStringFromCache(this.activatedConfigsCache, str);
        if (stringFromCache != null) {
            return stringFromCache;
        }
        String stringFromCache2 = getStringFromCache(this.defaultConfigsCache, str);
        return stringFromCache2 != null ? stringFromCache2 : BuildConfig.FLAVOR;
    }

    private static String getStringFromCache(ConfigCacheClient configCacheClient, String str) {
        ConfigContainer blocking = configCacheClient.getBlocking();
        if (blocking == null) {
            return null;
        }
        try {
            return blocking.getConfigs().getString(str);
        } catch (JSONException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RolloutsState getActiveRolloutsState(ConfigContainer configContainer) {
        JSONArray rolloutMetadata = configContainer.getRolloutMetadata();
        long templateVersionNumber = configContainer.getTemplateVersionNumber();
        HashSet hashSet = new HashSet();
        for (int i5 = 0; i5 < rolloutMetadata.length(); i5++) {
            try {
                JSONObject jSONObject = rolloutMetadata.getJSONObject(i5);
                String string = jSONObject.getString("rolloutId");
                JSONArray jSONArray = jSONObject.getJSONArray("affectedParameterKeys");
                if (jSONArray.length() > 1) {
                    Log.w("FirebaseRemoteConfig", String.format("Rollout has multiple affected parameter keys.Only the first key will be included in RolloutsState. rolloutId: %s, affectedParameterKeys: %s", string, jSONArray));
                }
                String optString = jSONArray.optString(0, BuildConfig.FLAVOR);
                hashSet.add(RolloutAssignment.builder().setRolloutId(string).setVariantId(jSONObject.getString("variantId")).setParameterKey(optString).setParameterValue(getParameterValue(optString)).setTemplateVersion(templateVersionNumber).build());
            } catch (JSONException e5) {
                throw new FirebaseRemoteConfigClientException("Exception parsing rollouts metadata to create RolloutsState.", e5);
            }
        }
        return RolloutsState.create(hashSet);
    }
}
