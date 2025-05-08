package com.google.firebase.heartbeatinfo;

import android.content.Context;
import android.content.SharedPreferences;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class HeartBeatInfoStorage {
    private static final String GLOBAL = "fire-global";
    private static final String HEARTBEAT_PREFERENCES_NAME = "FirebaseHeartBeat";
    private static final int HEART_BEAT_COUNT_LIMIT = 30;
    private static final String HEART_BEAT_COUNT_TAG = "fire-count";
    private static final String LAST_STORED_DATE = "last-used-date";
    private static final String PREFERENCES_NAME = "FirebaseAppHeartBeat";
    private static HeartBeatInfoStorage instance;
    private final SharedPreferences firebaseSharedPreferences;

    public HeartBeatInfoStorage(Context context, String str) {
        this.firebaseSharedPreferences = context.getSharedPreferences(HEARTBEAT_PREFERENCES_NAME + str, 0);
    }

    private synchronized void cleanUpStoredHeartBeats() {
        try {
            long j5 = this.firebaseSharedPreferences.getLong(HEART_BEAT_COUNT_TAG, 0L);
            String str = BuildConfig.FLAVOR;
            String str2 = null;
            for (Map.Entry<String, ?> entry : this.firebaseSharedPreferences.getAll().entrySet()) {
                if (entry.getValue() instanceof Set) {
                    for (String str3 : (Set) entry.getValue()) {
                        if (str2 != null && str2.compareTo(str3) <= 0) {
                        }
                        str = entry.getKey();
                        str2 = str3;
                    }
                }
            }
            HashSet hashSet = new HashSet(this.firebaseSharedPreferences.getStringSet(str, new HashSet()));
            hashSet.remove(str2);
            this.firebaseSharedPreferences.edit().putStringSet(str, hashSet).putLong(HEART_BEAT_COUNT_TAG, j5 - 1).commit();
        } catch (Throwable th) {
            throw th;
        }
    }

    private synchronized String getFormattedDate(long j5) {
        return new Date(j5).toInstant().atOffset(ZoneOffset.UTC).toLocalDateTime().format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    private synchronized String getStoredUserAgentString(String str) {
        for (Map.Entry<String, ?> entry : this.firebaseSharedPreferences.getAll().entrySet()) {
            if (entry.getValue() instanceof Set) {
                Iterator it = ((Set) entry.getValue()).iterator();
                while (it.hasNext()) {
                    if (str.equals((String) it.next())) {
                        return entry.getKey();
                    }
                }
            }
        }
        return null;
    }

    private synchronized void removeStoredDate(String str) {
        try {
            String storedUserAgentString = getStoredUserAgentString(str);
            if (storedUserAgentString == null) {
                return;
            }
            HashSet hashSet = new HashSet(this.firebaseSharedPreferences.getStringSet(storedUserAgentString, new HashSet()));
            hashSet.remove(str);
            if (hashSet.isEmpty()) {
                this.firebaseSharedPreferences.edit().remove(storedUserAgentString).commit();
            } else {
                this.firebaseSharedPreferences.edit().putStringSet(storedUserAgentString, hashSet).commit();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private synchronized void updateStoredUserAgent(String str, String str2) {
        removeStoredDate(str2);
        HashSet hashSet = new HashSet(this.firebaseSharedPreferences.getStringSet(str, new HashSet()));
        hashSet.add(str2);
        this.firebaseSharedPreferences.edit().putStringSet(str, hashSet).commit();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void deleteAllHeartBeats() {
        try {
            SharedPreferences.Editor edit = this.firebaseSharedPreferences.edit();
            int i5 = 0;
            for (Map.Entry<String, ?> entry : this.firebaseSharedPreferences.getAll().entrySet()) {
                if (entry.getValue() instanceof Set) {
                    Set set = (Set) entry.getValue();
                    String formattedDate = getFormattedDate(System.currentTimeMillis());
                    String key = entry.getKey();
                    if (set.contains(formattedDate)) {
                        HashSet hashSet = new HashSet();
                        hashSet.add(formattedDate);
                        i5++;
                        edit.putStringSet(key, hashSet);
                    } else {
                        edit.remove(key);
                    }
                }
            }
            if (i5 == 0) {
                edit.remove(HEART_BEAT_COUNT_TAG);
            } else {
                edit.putLong(HEART_BEAT_COUNT_TAG, i5);
            }
            edit.commit();
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized List<HeartBeatResult> getAllHeartBeats() {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            for (Map.Entry<String, ?> entry : this.firebaseSharedPreferences.getAll().entrySet()) {
                if (entry.getValue() instanceof Set) {
                    HashSet hashSet = new HashSet((Set) entry.getValue());
                    hashSet.remove(getFormattedDate(System.currentTimeMillis()));
                    if (!hashSet.isEmpty()) {
                        arrayList.add(HeartBeatResult.create(entry.getKey(), new ArrayList(hashSet)));
                    }
                }
            }
            updateGlobalHeartBeat(System.currentTimeMillis());
        } catch (Throwable th) {
            throw th;
        }
        return arrayList;
    }

    synchronized boolean isSameDateUtc(long j5, long j6) {
        return getFormattedDate(j5).equals(getFormattedDate(j6));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void postHeartBeatCleanUp() {
        String formattedDate = getFormattedDate(System.currentTimeMillis());
        this.firebaseSharedPreferences.edit().putString(LAST_STORED_DATE, formattedDate).commit();
        removeStoredDate(formattedDate);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean shouldSendGlobalHeartBeat(long j5) {
        return shouldSendSdkHeartBeat(GLOBAL, j5);
    }

    synchronized boolean shouldSendSdkHeartBeat(String str, long j5) {
        if (!this.firebaseSharedPreferences.contains(str)) {
            this.firebaseSharedPreferences.edit().putLong(str, j5).commit();
            return true;
        }
        if (isSameDateUtc(this.firebaseSharedPreferences.getLong(str, -1L), j5)) {
            return false;
        }
        this.firebaseSharedPreferences.edit().putLong(str, j5).commit();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void storeHeartBeat(long j5, String str) {
        String formattedDate = getFormattedDate(j5);
        if (this.firebaseSharedPreferences.getString(LAST_STORED_DATE, BuildConfig.FLAVOR).equals(formattedDate)) {
            String storedUserAgentString = getStoredUserAgentString(formattedDate);
            if (storedUserAgentString == null) {
                return;
            }
            if (storedUserAgentString.equals(str)) {
                return;
            }
            updateStoredUserAgent(str, formattedDate);
            return;
        }
        long j6 = this.firebaseSharedPreferences.getLong(HEART_BEAT_COUNT_TAG, 0L);
        if (j6 + 1 == 30) {
            cleanUpStoredHeartBeats();
            j6 = this.firebaseSharedPreferences.getLong(HEART_BEAT_COUNT_TAG, 0L);
        }
        HashSet hashSet = new HashSet(this.firebaseSharedPreferences.getStringSet(str, new HashSet()));
        hashSet.add(formattedDate);
        this.firebaseSharedPreferences.edit().putStringSet(str, hashSet).putLong(HEART_BEAT_COUNT_TAG, j6 + 1).putString(LAST_STORED_DATE, formattedDate).commit();
    }

    synchronized void updateGlobalHeartBeat(long j5) {
        this.firebaseSharedPreferences.edit().putLong(GLOBAL, j5).commit();
    }
}
