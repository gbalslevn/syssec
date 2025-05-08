package com.google.firebase.messaging;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.ContextCompat;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
class Store {
    private static final String SCOPE_ALL = "*";
    private static final String STORE_KEY_TOKEN = "|T|";
    final SharedPreferences store;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class Token {
        private static final String KEY_APP_VERSION = "appVersion";
        private static final String KEY_TIMESTAMP = "timestamp";
        private static final String KEY_TOKEN = "token";
        private static final long REFRESH_PERIOD_MILLIS = TimeUnit.DAYS.toMillis(7);
        final String appVersion;
        final long timestamp;
        final String token;

        private Token(String str, String str2, long j5) {
            this.token = str;
            this.appVersion = str2;
            this.timestamp = j5;
        }

        static String encode(String str, String str2, long j5) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(KEY_TOKEN, str);
                jSONObject.put(KEY_APP_VERSION, str2);
                jSONObject.put(KEY_TIMESTAMP, j5);
                return jSONObject.toString();
            } catch (JSONException e5) {
                Log.w("FirebaseMessaging", "Failed to encode token: " + e5);
                return null;
            }
        }

        static Token parse(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (!str.startsWith("{")) {
                return new Token(str, null, 0L);
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                return new Token(jSONObject.getString(KEY_TOKEN), jSONObject.getString(KEY_APP_VERSION), jSONObject.getLong(KEY_TIMESTAMP));
            } catch (JSONException e5) {
                Log.w("FirebaseMessaging", "Failed to parse token: " + e5);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean needsRefresh(String str) {
            return System.currentTimeMillis() > this.timestamp + REFRESH_PERIOD_MILLIS || !str.equals(this.appVersion);
        }
    }

    public Store(Context context) {
        this.store = context.getSharedPreferences("com.google.android.gms.appid", 0);
        checkForRestore(context, "com.google.android.gms.appid-no-backup");
    }

    private void checkForRestore(Context context, String str) {
        File file = new File(ContextCompat.getNoBackupFilesDir(context), str);
        if (file.exists()) {
            return;
        }
        try {
            if (!file.createNewFile() || isEmpty()) {
                return;
            }
            Log.i("FirebaseMessaging", "App restored, clearing state");
            deleteAll();
        } catch (IOException e5) {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "Error creating file in no backup dir: " + e5.getMessage());
            }
        }
    }

    private String createTokenKey(String str, String str2) {
        return str + STORE_KEY_TOKEN + str2 + "|" + SCOPE_ALL;
    }

    public synchronized void deleteAll() {
        this.store.edit().clear().commit();
    }

    public synchronized Token getToken(String str, String str2) {
        return Token.parse(this.store.getString(createTokenKey(str, str2), null));
    }

    public synchronized boolean isEmpty() {
        return this.store.getAll().isEmpty();
    }

    public synchronized void saveToken(String str, String str2, String str3, String str4) {
        String encode = Token.encode(str3, str4, System.currentTimeMillis());
        if (encode == null) {
            return;
        }
        SharedPreferences.Editor edit = this.store.edit();
        edit.putString(createTokenKey(str, str2), encode);
        edit.commit();
    }
}
