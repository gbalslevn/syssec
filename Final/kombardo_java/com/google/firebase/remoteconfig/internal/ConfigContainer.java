package com.google.firebase.remoteconfig.internal;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class ConfigContainer {
    private static final Date DEFAULTS_FETCH_TIME = new Date(0);
    private JSONArray abtExperiments;
    private JSONObject configsJson;
    private JSONObject containerJson;
    private Date fetchTime;
    private JSONObject personalizationMetadata;
    private JSONArray rolloutMetadata;
    private long templateVersionNumber;

    /* loaded from: classes2.dex */
    public static class Builder {
        private JSONArray builderAbtExperiments;
        private JSONObject builderConfigsJson;
        private Date builderFetchTime;
        private JSONObject builderPersonalizationMetadata;
        private JSONArray builderRolloutMetadata;
        private long builderTemplateVersionNumber;

        public ConfigContainer build() {
            return new ConfigContainer(this.builderConfigsJson, this.builderFetchTime, this.builderAbtExperiments, this.builderPersonalizationMetadata, this.builderTemplateVersionNumber, this.builderRolloutMetadata);
        }

        public Builder replaceConfigsWith(JSONObject jSONObject) {
            try {
                this.builderConfigsJson = new JSONObject(jSONObject.toString());
            } catch (JSONException unused) {
            }
            return this;
        }

        public Builder withAbtExperiments(JSONArray jSONArray) {
            try {
                this.builderAbtExperiments = new JSONArray(jSONArray.toString());
            } catch (JSONException unused) {
            }
            return this;
        }

        public Builder withFetchTime(Date date) {
            this.builderFetchTime = date;
            return this;
        }

        public Builder withPersonalizationMetadata(JSONObject jSONObject) {
            try {
                this.builderPersonalizationMetadata = new JSONObject(jSONObject.toString());
            } catch (JSONException unused) {
            }
            return this;
        }

        public Builder withRolloutMetadata(JSONArray jSONArray) {
            try {
                this.builderRolloutMetadata = new JSONArray(jSONArray.toString());
            } catch (JSONException unused) {
            }
            return this;
        }

        public Builder withTemplateVersionNumber(long j5) {
            this.builderTemplateVersionNumber = j5;
            return this;
        }

        private Builder() {
            this.builderConfigsJson = new JSONObject();
            this.builderFetchTime = ConfigContainer.DEFAULTS_FETCH_TIME;
            this.builderAbtExperiments = new JSONArray();
            this.builderPersonalizationMetadata = new JSONObject();
            this.builderTemplateVersionNumber = 0L;
            this.builderRolloutMetadata = new JSONArray();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ConfigContainer copyOf(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("personalization_metadata_key");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        JSONObject jSONObject2 = optJSONObject;
        JSONArray optJSONArray = jSONObject.optJSONArray("rollout_metadata_key");
        if (optJSONArray == null) {
            optJSONArray = new JSONArray();
        }
        return new ConfigContainer(jSONObject.getJSONObject("configs_key"), new Date(jSONObject.getLong("fetch_time_key")), jSONObject.getJSONArray("abt_experiments_key"), jSONObject2, jSONObject.optLong("template_version_number_key"), optJSONArray);
    }

    private Map<String, Map<String, String>> createRolloutParameterKeyMap() {
        HashMap hashMap = new HashMap();
        for (int i5 = 0; i5 < getRolloutMetadata().length(); i5++) {
            JSONObject jSONObject = getRolloutMetadata().getJSONObject(i5);
            String string = jSONObject.getString("rolloutId");
            String string2 = jSONObject.getString("variantId");
            JSONArray jSONArray = jSONObject.getJSONArray("affectedParameterKeys");
            for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                String string3 = jSONArray.getString(i6);
                if (!hashMap.containsKey(string3)) {
                    hashMap.put(string3, new HashMap());
                }
                Map map = (Map) hashMap.get(string3);
                if (map != null) {
                    map.put(string, string2);
                }
            }
        }
        return hashMap;
    }

    private static ConfigContainer deepCopyOf(JSONObject jSONObject) {
        return copyOf(new JSONObject(jSONObject.toString()));
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ConfigContainer) {
            return this.containerJson.toString().equals(((ConfigContainer) obj).toString());
        }
        return false;
    }

    public JSONArray getAbtExperiments() {
        return this.abtExperiments;
    }

    public Set<String> getChangedParams(ConfigContainer configContainer) {
        JSONObject configs = deepCopyOf(configContainer.containerJson).getConfigs();
        Map<String, Map<String, String>> createRolloutParameterKeyMap = createRolloutParameterKeyMap();
        Map<String, Map<String, String>> createRolloutParameterKeyMap2 = configContainer.createRolloutParameterKeyMap();
        HashSet hashSet = new HashSet();
        Iterator<String> keys = getConfigs().keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!configContainer.getConfigs().has(next)) {
                hashSet.add(next);
            } else if (!getConfigs().get(next).equals(configContainer.getConfigs().get(next))) {
                hashSet.add(next);
            } else if ((getPersonalizationMetadata().has(next) && !configContainer.getPersonalizationMetadata().has(next)) || (!getPersonalizationMetadata().has(next) && configContainer.getPersonalizationMetadata().has(next))) {
                hashSet.add(next);
            } else if (getPersonalizationMetadata().has(next) && configContainer.getPersonalizationMetadata().has(next) && !getPersonalizationMetadata().getJSONObject(next).toString().equals(configContainer.getPersonalizationMetadata().getJSONObject(next).toString())) {
                hashSet.add(next);
            } else if (createRolloutParameterKeyMap.containsKey(next) != createRolloutParameterKeyMap2.containsKey(next)) {
                hashSet.add(next);
            } else if (createRolloutParameterKeyMap.containsKey(next) && createRolloutParameterKeyMap2.containsKey(next) && !createRolloutParameterKeyMap.get(next).equals(createRolloutParameterKeyMap2.get(next))) {
                hashSet.add(next);
            } else {
                configs.remove(next);
            }
        }
        Iterator<String> keys2 = configs.keys();
        while (keys2.hasNext()) {
            hashSet.add(keys2.next());
        }
        return hashSet;
    }

    public JSONObject getConfigs() {
        return this.configsJson;
    }

    public Date getFetchTime() {
        return this.fetchTime;
    }

    public JSONObject getPersonalizationMetadata() {
        return this.personalizationMetadata;
    }

    public JSONArray getRolloutMetadata() {
        return this.rolloutMetadata;
    }

    public long getTemplateVersionNumber() {
        return this.templateVersionNumber;
    }

    public int hashCode() {
        return this.containerJson.hashCode();
    }

    public String toString() {
        return this.containerJson.toString();
    }

    private ConfigContainer(JSONObject jSONObject, Date date, JSONArray jSONArray, JSONObject jSONObject2, long j5, JSONArray jSONArray2) {
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("configs_key", jSONObject);
        jSONObject3.put("fetch_time_key", date.getTime());
        jSONObject3.put("abt_experiments_key", jSONArray);
        jSONObject3.put("personalization_metadata_key", jSONObject2);
        jSONObject3.put("template_version_number_key", j5);
        jSONObject3.put("rollout_metadata_key", jSONArray2);
        this.configsJson = jSONObject;
        this.fetchTime = date;
        this.abtExperiments = jSONArray;
        this.personalizationMetadata = jSONObject2;
        this.templateVersionNumber = j5;
        this.rolloutMetadata = jSONArray2;
        this.containerJson = jSONObject3;
    }
}
