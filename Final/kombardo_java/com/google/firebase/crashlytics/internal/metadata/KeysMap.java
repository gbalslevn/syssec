package com.google.firebase.crashlytics.internal.metadata;

import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.conscrypt.BuildConfig;

/* loaded from: classes2.dex */
class KeysMap {
    private final Map<String, String> keys = new HashMap();
    private final int maxEntries;
    private final int maxEntryLength;

    public KeysMap(int i5, int i6) {
        this.maxEntries = i5;
        this.maxEntryLength = i6;
    }

    private String sanitizeKey(String str) {
        if (str != null) {
            return sanitizeString(str, this.maxEntryLength);
        }
        throw new IllegalArgumentException("Custom attribute key must not be null.");
    }

    public static String sanitizeString(String str, int i5) {
        if (str == null) {
            return str;
        }
        String trim = str.trim();
        return trim.length() > i5 ? trim.substring(0, i5) : trim;
    }

    public synchronized Map<String, String> getKeys() {
        return Collections.unmodifiableMap(new HashMap(this.keys));
    }

    public synchronized boolean setKey(String str, String str2) {
        String sanitizeKey = sanitizeKey(str);
        if (this.keys.size() >= this.maxEntries && !this.keys.containsKey(sanitizeKey)) {
            Logger.getLogger().w("Ignored entry \"" + str + "\" when adding custom keys. Maximum allowable: " + this.maxEntries);
            return false;
        }
        String sanitizeString = sanitizeString(str2, this.maxEntryLength);
        if (CommonUtils.nullSafeEquals(this.keys.get(sanitizeKey), sanitizeString)) {
            return false;
        }
        Map<String, String> map = this.keys;
        if (str2 == null) {
            sanitizeString = BuildConfig.FLAVOR;
        }
        map.put(sanitizeKey, sanitizeString);
        return true;
    }

    public synchronized void setKeys(Map<String, String> map) {
        try {
            int i5 = 0;
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String sanitizeKey = sanitizeKey(entry.getKey());
                if (this.keys.size() >= this.maxEntries && !this.keys.containsKey(sanitizeKey)) {
                    i5++;
                }
                String value = entry.getValue();
                this.keys.put(sanitizeKey, value == null ? BuildConfig.FLAVOR : sanitizeString(value, this.maxEntryLength));
            }
            if (i5 > 0) {
                Logger.getLogger().w("Ignored " + i5 + " entries when adding custom keys. Maximum allowable: " + this.maxEntries);
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
