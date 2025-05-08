package com.google.firebase.messaging;

import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import java.util.Arrays;
import java.util.MissingFormatArgumentException;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: classes2.dex */
public class NotificationParams {
    private static final int COLOR_TRANSPARENT_IN_HEX = -16777216;
    private static final int EMPTY_JSON_ARRAY_LENGTH = 1;
    private static final String TAG = "NotificationParams";
    private static final int VISIBILITY_MAX = 1;
    private static final int VISIBILITY_MIN = -1;
    private final Bundle data;

    public NotificationParams(Bundle bundle) {
        if (bundle == null) {
            throw new NullPointerException("data");
        }
        this.data = new Bundle(bundle);
    }

    private static int getLightColor(String str) {
        int parseColor = Color.parseColor(str);
        if (parseColor != COLOR_TRANSPARENT_IN_HEX) {
            return parseColor;
        }
        throw new IllegalArgumentException("Transparent color is invalid");
    }

    private static boolean isAnalyticsKey(String str) {
        return str.startsWith("google.c.a.") || str.equals("from");
    }

    public static boolean isNotification(Bundle bundle) {
        return "1".equals(bundle.getString("gcm.n.e")) || "1".equals(bundle.getString(keyWithOldPrefix("gcm.n.e")));
    }

    private static boolean isReservedKey(String str) {
        return str.startsWith("google.c.") || str.startsWith("gcm.n.") || str.startsWith("gcm.notification.");
    }

    private static String keyWithOldPrefix(String str) {
        return !str.startsWith("gcm.n.") ? str : str.replace("gcm.n.", "gcm.notification.");
    }

    private String normalizePrefix(String str) {
        if (!this.data.containsKey(str) && str.startsWith("gcm.n.")) {
            String keyWithOldPrefix = keyWithOldPrefix(str);
            if (this.data.containsKey(keyWithOldPrefix)) {
                return keyWithOldPrefix;
            }
        }
        return str;
    }

    private static String userFriendlyKey(String str) {
        return str.startsWith("gcm.n.") ? str.substring(6) : str;
    }

    public boolean getBoolean(String str) {
        String string = getString(str);
        return "1".equals(string) || Boolean.parseBoolean(string);
    }

    public Integer getInteger(String str) {
        String string = getString(str);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt(string));
        } catch (NumberFormatException unused) {
            Log.w(TAG, "Couldn't parse value of " + userFriendlyKey(str) + "(" + string + ") into an int");
            return null;
        }
    }

    public JSONArray getJSONArray(String str) {
        String string = getString(str);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            return new JSONArray(string);
        } catch (JSONException unused) {
            Log.w(TAG, "Malformed JSON for key " + userFriendlyKey(str) + ": " + string + ", falling back to default");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] getLightSettings() {
        JSONArray jSONArray = getJSONArray("gcm.n.light_settings");
        if (jSONArray == null) {
            return null;
        }
        int[] iArr = new int[3];
        try {
            if (jSONArray.length() != 3) {
                throw new JSONException("lightSettings don't have all three fields");
            }
            iArr[0] = getLightColor(jSONArray.optString(0));
            iArr[1] = jSONArray.optInt(1);
            iArr[2] = jSONArray.optInt(2);
            return iArr;
        } catch (IllegalArgumentException e5) {
            Log.w(TAG, "LightSettings is invalid: " + jSONArray + ". " + e5.getMessage() + ". Skipping setting LightSettings");
            return null;
        } catch (JSONException unused) {
            Log.w(TAG, "LightSettings is invalid: " + jSONArray + ". Skipping setting LightSettings");
            return null;
        }
    }

    public Uri getLink() {
        String string = getString("gcm.n.link_android");
        if (TextUtils.isEmpty(string)) {
            string = getString("gcm.n.link");
        }
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return Uri.parse(string);
    }

    public Object[] getLocalizationArgsForKey(String str) {
        JSONArray jSONArray = getJSONArray(str + "_loc_args");
        if (jSONArray == null) {
            return null;
        }
        int length = jSONArray.length();
        String[] strArr = new String[length];
        for (int i5 = 0; i5 < length; i5++) {
            strArr[i5] = jSONArray.optString(i5);
        }
        return strArr;
    }

    public String getLocalizationResourceForKey(String str) {
        return getString(str + "_loc_key");
    }

    public String getLocalizedString(Resources resources, String str, String str2) {
        String localizationResourceForKey = getLocalizationResourceForKey(str2);
        if (TextUtils.isEmpty(localizationResourceForKey)) {
            return null;
        }
        int identifier = resources.getIdentifier(localizationResourceForKey, "string", str);
        if (identifier == 0) {
            Log.w(TAG, userFriendlyKey(str2 + "_loc_key") + " resource not found: " + str2 + " Default value will be used.");
            return null;
        }
        Object[] localizationArgsForKey = getLocalizationArgsForKey(str2);
        if (localizationArgsForKey == null) {
            return resources.getString(identifier);
        }
        try {
            return resources.getString(identifier, localizationArgsForKey);
        } catch (MissingFormatArgumentException e5) {
            Log.w(TAG, "Missing format argument for " + userFriendlyKey(str2) + ": " + Arrays.toString(localizationArgsForKey) + " Default value will be used.", e5);
            return null;
        }
    }

    public Long getLong(String str) {
        String string = getString(str);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            return Long.valueOf(Long.parseLong(string));
        } catch (NumberFormatException unused) {
            Log.w(TAG, "Couldn't parse value of " + userFriendlyKey(str) + "(" + string + ") into a long");
            return null;
        }
    }

    public String getNotificationChannelId() {
        return getString("gcm.n.android_channel_id");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Integer getNotificationCount() {
        Integer integer = getInteger("gcm.n.notification_count");
        if (integer == null) {
            return null;
        }
        if (integer.intValue() >= 0) {
            return integer;
        }
        Log.w("FirebaseMessaging", "notificationCount is invalid: " + integer + ". Skipping setting notificationCount.");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Integer getNotificationPriority() {
        Integer integer = getInteger("gcm.n.notification_priority");
        if (integer == null) {
            return null;
        }
        if (integer.intValue() >= -2 && integer.intValue() <= 2) {
            return integer;
        }
        Log.w("FirebaseMessaging", "notificationPriority is invalid " + integer + ". Skipping setting notificationPriority.");
        return null;
    }

    public String getPossiblyLocalizedString(Resources resources, String str, String str2) {
        String string = getString(str2);
        return !TextUtils.isEmpty(string) ? string : getLocalizedString(resources, str, str2);
    }

    public String getSoundResourceName() {
        String string = getString("gcm.n.sound2");
        return TextUtils.isEmpty(string) ? getString("gcm.n.sound") : string;
    }

    public String getString(String str) {
        return this.data.getString(normalizePrefix(str));
    }

    public long[] getVibrateTimings() {
        JSONArray jSONArray = getJSONArray("gcm.n.vibrate_timings");
        if (jSONArray == null) {
            return null;
        }
        try {
            if (jSONArray.length() <= 1) {
                throw new JSONException("vibrateTimings have invalid length");
            }
            int length = jSONArray.length();
            long[] jArr = new long[length];
            for (int i5 = 0; i5 < length; i5++) {
                jArr[i5] = jSONArray.optLong(i5);
            }
            return jArr;
        } catch (NumberFormatException | JSONException unused) {
            Log.w(TAG, "User defined vibrateTimings is invalid: " + jSONArray + ". Skipping setting vibrateTimings.");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Integer getVisibility() {
        Integer integer = getInteger("gcm.n.visibility");
        if (integer == null) {
            return null;
        }
        if (integer.intValue() >= -1 && integer.intValue() <= 1) {
            return integer;
        }
        Log.w(TAG, "visibility is invalid: " + integer + ". Skipping setting visibility.");
        return null;
    }

    public Bundle paramsForAnalyticsIntent() {
        Bundle bundle = new Bundle(this.data);
        for (String str : this.data.keySet()) {
            if (!isAnalyticsKey(str)) {
                bundle.remove(str);
            }
        }
        return bundle;
    }

    public Bundle paramsWithReservedKeysRemoved() {
        Bundle bundle = new Bundle(this.data);
        for (String str : this.data.keySet()) {
            if (isReservedKey(str)) {
                bundle.remove(str);
            }
        }
        return bundle;
    }
}
