package com.google.firebase.remoteconfig.internal;

import android.content.SharedPreferences;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigInfo;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class ConfigSharedPrefsClient {
    private static final String BACKOFF_END_TIME_IN_MILLIS_KEY = "backoff_end_time_in_millis";
    private static final int CUSTOM_SIGNALS_MAX_COUNT = 100;
    private static final int CUSTOM_SIGNALS_MAX_KEY_LENGTH = 250;
    private static final int CUSTOM_SIGNALS_MAX_STRING_VALUE_LENGTH = 500;
    private static final String FETCH_TIMEOUT_IN_SECONDS_KEY = "fetch_timeout_in_seconds";
    private static final String LAST_FETCH_ETAG_KEY = "last_fetch_etag";
    private static final String LAST_FETCH_STATUS_KEY = "last_fetch_status";
    private static final String LAST_SUCCESSFUL_FETCH_TIME_IN_MILLIS_KEY = "last_fetch_time_in_millis";
    private static final String LAST_TEMPLATE_VERSION = "last_template_version";
    private static final String MINIMUM_FETCH_INTERVAL_IN_SECONDS_KEY = "minimum_fetch_interval_in_seconds";
    private static final String NUM_FAILED_FETCHES_KEY = "num_failed_fetches";
    private static final String NUM_FAILED_REALTIME_STREAMS_KEY = "num_failed_realtime_streams";
    private static final String REALTIME_BACKOFF_END_TIME_IN_MILLIS_KEY = "realtime_backoff_end_time_in_millis";
    private final SharedPreferences frcSharedPrefs;
    private static final long NO_BACKOFF_TIME_IN_MILLIS = -1;
    static final Date LAST_FETCH_TIME_NO_FETCH_YET = new Date(NO_BACKOFF_TIME_IN_MILLIS);
    static final Date NO_BACKOFF_TIME = new Date(NO_BACKOFF_TIME_IN_MILLIS);
    private final Object frcInfoLock = new Object();
    private final Object backoffMetadataLock = new Object();
    private final Object realtimeBackoffMetadataLock = new Object();
    private final Object customSignalsLock = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class BackoffMetadata {
        private Date backoffEndTime;
        private int numFailedFetches;

        BackoffMetadata(int i5, Date date) {
            this.numFailedFetches = i5;
            this.backoffEndTime = date;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Date getBackoffEndTime() {
            return this.backoffEndTime;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int getNumFailedFetches() {
            return this.numFailedFetches;
        }
    }

    /* loaded from: classes2.dex */
    public static class RealtimeBackoffMetadata {
        private Date backoffEndTime;
        private int numFailedStreams;

        public RealtimeBackoffMetadata(int i5, Date date) {
            this.numFailedStreams = i5;
            this.backoffEndTime = date;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Date getBackoffEndTime() {
            return this.backoffEndTime;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int getNumFailedStreams() {
            return this.numFailedStreams;
        }
    }

    public ConfigSharedPrefsClient(SharedPreferences sharedPreferences) {
        this.frcSharedPrefs = sharedPreferences;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BackoffMetadata getBackoffMetadata() {
        BackoffMetadata backoffMetadata;
        synchronized (this.backoffMetadataLock) {
            backoffMetadata = new BackoffMetadata(this.frcSharedPrefs.getInt(NUM_FAILED_FETCHES_KEY, 0), new Date(this.frcSharedPrefs.getLong(BACKOFF_END_TIME_IN_MILLIS_KEY, NO_BACKOFF_TIME_IN_MILLIS)));
        }
        return backoffMetadata;
    }

    public Map<String, String> getCustomSignals() {
        try {
            JSONObject jSONObject = new JSONObject(this.frcSharedPrefs.getString("customSignals", "{}"));
            HashMap hashMap = new HashMap();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject.optString(next));
            }
            return hashMap;
        } catch (JSONException unused) {
            return new HashMap();
        }
    }

    public long getFetchTimeoutInSeconds() {
        return this.frcSharedPrefs.getLong(FETCH_TIMEOUT_IN_SECONDS_KEY, 60L);
    }

    public FirebaseRemoteConfigInfo getInfo() {
        FirebaseRemoteConfigInfoImpl build;
        synchronized (this.frcInfoLock) {
            long j5 = this.frcSharedPrefs.getLong(LAST_SUCCESSFUL_FETCH_TIME_IN_MILLIS_KEY, NO_BACKOFF_TIME_IN_MILLIS);
            int i5 = this.frcSharedPrefs.getInt(LAST_FETCH_STATUS_KEY, 0);
            build = FirebaseRemoteConfigInfoImpl.newBuilder().withLastFetchStatus(i5).withLastSuccessfulFetchTimeInMillis(j5).withConfigSettings(new FirebaseRemoteConfigSettings.Builder().setFetchTimeoutInSeconds(this.frcSharedPrefs.getLong(FETCH_TIMEOUT_IN_SECONDS_KEY, 60L)).setMinimumFetchIntervalInSeconds(this.frcSharedPrefs.getLong(MINIMUM_FETCH_INTERVAL_IN_SECONDS_KEY, ConfigFetchHandler.DEFAULT_MINIMUM_FETCH_INTERVAL_IN_SECONDS)).build()).build();
        }
        return build;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getLastFetchETag() {
        return this.frcSharedPrefs.getString(LAST_FETCH_ETAG_KEY, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Date getLastSuccessfulFetchTime() {
        return new Date(this.frcSharedPrefs.getLong(LAST_SUCCESSFUL_FETCH_TIME_IN_MILLIS_KEY, NO_BACKOFF_TIME_IN_MILLIS));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getLastTemplateVersion() {
        return this.frcSharedPrefs.getLong(LAST_TEMPLATE_VERSION, 0L);
    }

    public long getMinimumFetchIntervalInSeconds() {
        return this.frcSharedPrefs.getLong(MINIMUM_FETCH_INTERVAL_IN_SECONDS_KEY, ConfigFetchHandler.DEFAULT_MINIMUM_FETCH_INTERVAL_IN_SECONDS);
    }

    public RealtimeBackoffMetadata getRealtimeBackoffMetadata() {
        RealtimeBackoffMetadata realtimeBackoffMetadata;
        synchronized (this.realtimeBackoffMetadataLock) {
            realtimeBackoffMetadata = new RealtimeBackoffMetadata(this.frcSharedPrefs.getInt(NUM_FAILED_REALTIME_STREAMS_KEY, 0), new Date(this.frcSharedPrefs.getLong(REALTIME_BACKOFF_END_TIME_IN_MILLIS_KEY, NO_BACKOFF_TIME_IN_MILLIS)));
        }
        return realtimeBackoffMetadata;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void resetBackoff() {
        setBackoffMetadata(0, NO_BACKOFF_TIME);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void resetRealtimeBackoff() {
        setRealtimeBackoffMetadata(0, NO_BACKOFF_TIME);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setBackoffMetadata(int i5, Date date) {
        synchronized (this.backoffMetadataLock) {
            this.frcSharedPrefs.edit().putInt(NUM_FAILED_FETCHES_KEY, i5).putLong(BACKOFF_END_TIME_IN_MILLIS_KEY, date.getTime()).apply();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setLastFetchETag(String str) {
        synchronized (this.frcInfoLock) {
            this.frcSharedPrefs.edit().putString(LAST_FETCH_ETAG_KEY, str).apply();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setLastTemplateVersion(long j5) {
        synchronized (this.frcInfoLock) {
            this.frcSharedPrefs.edit().putLong(LAST_TEMPLATE_VERSION, j5).apply();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setRealtimeBackoffMetadata(int i5, Date date) {
        synchronized (this.realtimeBackoffMetadataLock) {
            this.frcSharedPrefs.edit().putInt(NUM_FAILED_REALTIME_STREAMS_KEY, i5).putLong(REALTIME_BACKOFF_END_TIME_IN_MILLIS_KEY, date.getTime()).apply();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateLastFetchAsFailed() {
        synchronized (this.frcInfoLock) {
            this.frcSharedPrefs.edit().putInt(LAST_FETCH_STATUS_KEY, 1).apply();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateLastFetchAsSuccessfulAt(Date date) {
        synchronized (this.frcInfoLock) {
            this.frcSharedPrefs.edit().putInt(LAST_FETCH_STATUS_KEY, -1).putLong(LAST_SUCCESSFUL_FETCH_TIME_IN_MILLIS_KEY, date.getTime()).apply();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateLastFetchAsThrottled() {
        synchronized (this.frcInfoLock) {
            this.frcSharedPrefs.edit().putInt(LAST_FETCH_STATUS_KEY, 2).apply();
        }
    }
}
