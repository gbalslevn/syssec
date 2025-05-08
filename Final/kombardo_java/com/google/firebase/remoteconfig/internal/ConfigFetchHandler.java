package com.google.firebase.remoteconfig.internal;

import android.text.format.DateUtils;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.installations.InstallationTokenResult;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigClientException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigFetchThrottledException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigServerException;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;
import com.google.firebase.remoteconfig.internal.ConfigSharedPrefsClient;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class ConfigFetchHandler {
    private static final String X_FIREBASE_RC_FETCH_TYPE = "X-Firebase-RC-Fetch-Type";
    private final Provider<AnalyticsConnector> analyticsConnector;
    private final Clock clock;
    private final Map<String, String> customHttpHeaders;
    private final Executor executor;
    private final ConfigCacheClient fetchedConfigsCache;
    private final FirebaseInstallationsApi firebaseInstallations;
    private final ConfigFetchHttpClient frcBackendApiClient;
    private final ConfigSharedPrefsClient frcSharedPrefs;
    private final Random randomGenerator;
    public static final long DEFAULT_MINIMUM_FETCH_INTERVAL_IN_SECONDS = TimeUnit.HOURS.toSeconds(12);
    static final int[] BACKOFF_TIME_DURATIONS_IN_MINUTES = {2, 4, 8, 16, 32, 64, 128, 256};

    /* loaded from: classes2.dex */
    public static class FetchResponse {
        private final Date fetchTime;
        private final ConfigContainer fetchedConfigs;
        private final String lastFetchETag;
        private final int status;

        private FetchResponse(Date date, int i5, ConfigContainer configContainer, String str) {
            this.fetchTime = date;
            this.status = i5;
            this.fetchedConfigs = configContainer;
            this.lastFetchETag = str;
        }

        public static FetchResponse forBackendHasNoUpdates(Date date, ConfigContainer configContainer) {
            return new FetchResponse(date, 1, configContainer, null);
        }

        public static FetchResponse forBackendUpdatesFetched(ConfigContainer configContainer, String str) {
            return new FetchResponse(configContainer.getFetchTime(), 0, configContainer, str);
        }

        public static FetchResponse forLocalStorageUsed(Date date) {
            return new FetchResponse(date, 2, null, null);
        }

        public ConfigContainer getFetchedConfigs() {
            return this.fetchedConfigs;
        }

        String getLastFetchETag() {
            return this.lastFetchETag;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int getStatus() {
            return this.status;
        }
    }

    /* loaded from: classes2.dex */
    public enum FetchType {
        BASE("BASE"),
        REALTIME("REALTIME");

        private final String value;

        FetchType(String str) {
            this.value = str;
        }

        String getValue() {
            return this.value;
        }
    }

    public ConfigFetchHandler(FirebaseInstallationsApi firebaseInstallationsApi, Provider<AnalyticsConnector> provider, Executor executor, Clock clock, Random random, ConfigCacheClient configCacheClient, ConfigFetchHttpClient configFetchHttpClient, ConfigSharedPrefsClient configSharedPrefsClient, Map<String, String> map) {
        this.firebaseInstallations = firebaseInstallationsApi;
        this.analyticsConnector = provider;
        this.executor = executor;
        this.clock = clock;
        this.randomGenerator = random;
        this.fetchedConfigsCache = configCacheClient;
        this.frcBackendApiClient = configFetchHttpClient;
        this.frcSharedPrefs = configSharedPrefsClient;
        this.customHttpHeaders = map;
    }

    private boolean areCachedFetchConfigsValid(long j5, Date date) {
        Date lastSuccessfulFetchTime = this.frcSharedPrefs.getLastSuccessfulFetchTime();
        if (lastSuccessfulFetchTime.equals(ConfigSharedPrefsClient.LAST_FETCH_TIME_NO_FETCH_YET)) {
            return false;
        }
        return date.before(new Date(lastSuccessfulFetchTime.getTime() + TimeUnit.SECONDS.toMillis(j5)));
    }

    private FirebaseRemoteConfigServerException createExceptionWithGenericMessage(FirebaseRemoteConfigServerException firebaseRemoteConfigServerException) {
        String str;
        int httpStatusCode = firebaseRemoteConfigServerException.getHttpStatusCode();
        if (httpStatusCode == 401) {
            str = "The request did not have the required credentials. Please make sure your google-services.json is valid.";
        } else if (httpStatusCode == 403) {
            str = "The user is not authorized to access the project. Please make sure you are using the API key that corresponds to your Firebase project.";
        } else {
            if (httpStatusCode == 429) {
                throw new FirebaseRemoteConfigClientException("The throttled response from the server was not handled correctly by the FRC SDK.");
            }
            if (httpStatusCode != 500) {
                switch (httpStatusCode) {
                    case 502:
                    case 503:
                    case 504:
                        str = "The server is unavailable. Please try again later.";
                        break;
                    default:
                        str = "The server returned an unexpected error.";
                        break;
                }
            } else {
                str = "There was an internal server error.";
            }
        }
        return new FirebaseRemoteConfigServerException(firebaseRemoteConfigServerException.getHttpStatusCode(), "Fetch failed: " + str, firebaseRemoteConfigServerException);
    }

    private String createThrottledMessage(long j5) {
        return String.format("Fetch is throttled. Please wait before calling fetch again: %s", DateUtils.formatElapsedTime(TimeUnit.MILLISECONDS.toSeconds(j5)));
    }

    private FetchResponse fetchFromBackend(String str, String str2, Date date, Map<String, String> map) {
        try {
            FetchResponse fetch = this.frcBackendApiClient.fetch(this.frcBackendApiClient.createHttpURLConnection(), str, str2, getUserProperties(), this.frcSharedPrefs.getLastFetchETag(), map, getFirstOpenTime(), date, this.frcSharedPrefs.getCustomSignals());
            if (fetch.getFetchedConfigs() != null) {
                this.frcSharedPrefs.setLastTemplateVersion(fetch.getFetchedConfigs().getTemplateVersionNumber());
            }
            if (fetch.getLastFetchETag() != null) {
                this.frcSharedPrefs.setLastFetchETag(fetch.getLastFetchETag());
            }
            this.frcSharedPrefs.resetBackoff();
            return fetch;
        } catch (FirebaseRemoteConfigServerException e5) {
            ConfigSharedPrefsClient.BackoffMetadata updateAndReturnBackoffMetadata = updateAndReturnBackoffMetadata(e5.getHttpStatusCode(), date);
            if (shouldThrottle(updateAndReturnBackoffMetadata, e5.getHttpStatusCode())) {
                throw new FirebaseRemoteConfigFetchThrottledException(updateAndReturnBackoffMetadata.getBackoffEndTime().getTime());
            }
            throw createExceptionWithGenericMessage(e5);
        }
    }

    private Task<FetchResponse> fetchFromBackendAndCacheResponse(String str, String str2, Date date, Map<String, String> map) {
        try {
            final FetchResponse fetchFromBackend = fetchFromBackend(str, str2, date, map);
            return fetchFromBackend.getStatus() != 0 ? Tasks.forResult(fetchFromBackend) : this.fetchedConfigsCache.put(fetchFromBackend.getFetchedConfigs()).onSuccessTask(this.executor, new SuccessContinuation() { // from class: com.google.firebase.remoteconfig.internal.i
                @Override // com.google.android.gms.tasks.SuccessContinuation
                public final Task then(Object obj) {
                    Task forResult;
                    forResult = Tasks.forResult(ConfigFetchHandler.FetchResponse.this);
                    return forResult;
                }
            });
        } catch (FirebaseRemoteConfigException e5) {
            return Tasks.forException(e5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: fetchIfCacheExpiredAndNotThrottled, reason: merged with bridge method [inline-methods] */
    public Task<FetchResponse> lambda$fetch$0(Task<ConfigContainer> task, long j5, final Map<String, String> map) {
        Task continueWithTask;
        final Date date = new Date(this.clock.currentTimeMillis());
        if (task.isSuccessful() && areCachedFetchConfigsValid(j5, date)) {
            return Tasks.forResult(FetchResponse.forLocalStorageUsed(date));
        }
        Date backoffEndTimeInMillis = getBackoffEndTimeInMillis(date);
        if (backoffEndTimeInMillis != null) {
            continueWithTask = Tasks.forException(new FirebaseRemoteConfigFetchThrottledException(createThrottledMessage(backoffEndTimeInMillis.getTime() - date.getTime()), backoffEndTimeInMillis.getTime()));
        } else {
            final Task<String> id = this.firebaseInstallations.getId();
            final Task<InstallationTokenResult> token = this.firebaseInstallations.getToken(false);
            continueWithTask = Tasks.whenAllComplete((Task<?>[]) new Task[]{id, token}).continueWithTask(this.executor, new Continuation() { // from class: com.google.firebase.remoteconfig.internal.f
                @Override // com.google.android.gms.tasks.Continuation
                public final Object then(Task task2) {
                    Task lambda$fetchIfCacheExpiredAndNotThrottled$2;
                    lambda$fetchIfCacheExpiredAndNotThrottled$2 = ConfigFetchHandler.this.lambda$fetchIfCacheExpiredAndNotThrottled$2(id, token, date, map, task2);
                    return lambda$fetchIfCacheExpiredAndNotThrottled$2;
                }
            });
        }
        return continueWithTask.continueWithTask(this.executor, new Continuation() { // from class: com.google.firebase.remoteconfig.internal.g
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task2) {
                Task lambda$fetchIfCacheExpiredAndNotThrottled$3;
                lambda$fetchIfCacheExpiredAndNotThrottled$3 = ConfigFetchHandler.this.lambda$fetchIfCacheExpiredAndNotThrottled$3(date, task2);
                return lambda$fetchIfCacheExpiredAndNotThrottled$3;
            }
        });
    }

    private Date getBackoffEndTimeInMillis(Date date) {
        Date backoffEndTime = this.frcSharedPrefs.getBackoffMetadata().getBackoffEndTime();
        if (date.before(backoffEndTime)) {
            return backoffEndTime;
        }
        return null;
    }

    private Long getFirstOpenTime() {
        AnalyticsConnector analyticsConnector = this.analyticsConnector.get();
        if (analyticsConnector == null) {
            return null;
        }
        return (Long) analyticsConnector.getUserProperties(true).get("_fot");
    }

    private long getRandomizedBackoffDurationInMillis(int i5) {
        TimeUnit timeUnit = TimeUnit.MINUTES;
        int[] iArr = BACKOFF_TIME_DURATIONS_IN_MINUTES;
        return (timeUnit.toMillis(iArr[Math.min(i5, iArr.length) - 1]) / 2) + this.randomGenerator.nextInt((int) r0);
    }

    private Map<String, String> getUserProperties() {
        HashMap hashMap = new HashMap();
        AnalyticsConnector analyticsConnector = this.analyticsConnector.get();
        if (analyticsConnector == null) {
            return hashMap;
        }
        for (Map.Entry<String, Object> entry : analyticsConnector.getUserProperties(false).entrySet()) {
            hashMap.put(entry.getKey(), entry.getValue().toString());
        }
        return hashMap;
    }

    private boolean isThrottleableServerError(int i5) {
        return i5 == 429 || i5 == 502 || i5 == 503 || i5 == 504;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Task lambda$fetchIfCacheExpiredAndNotThrottled$2(Task task, Task task2, Date date, Map map, Task task3) {
        return !task.isSuccessful() ? Tasks.forException(new FirebaseRemoteConfigClientException("Firebase Installations failed to get installation ID for fetch.", task.getException())) : !task2.isSuccessful() ? Tasks.forException(new FirebaseRemoteConfigClientException("Firebase Installations failed to get installation auth token for fetch.", task2.getException())) : fetchFromBackendAndCacheResponse((String) task.getResult(), ((InstallationTokenResult) task2.getResult()).getToken(), date, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Task lambda$fetchIfCacheExpiredAndNotThrottled$3(Date date, Task task) {
        updateLastFetchStatusAndTime(task, date);
        return task;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Task lambda$fetchNowWithTypeAndAttemptNumber$1(Map map, Task task) {
        return lambda$fetch$0(task, 0L, map);
    }

    private boolean shouldThrottle(ConfigSharedPrefsClient.BackoffMetadata backoffMetadata, int i5) {
        return backoffMetadata.getNumFailedFetches() > 1 || i5 == 429;
    }

    private ConfigSharedPrefsClient.BackoffMetadata updateAndReturnBackoffMetadata(int i5, Date date) {
        if (isThrottleableServerError(i5)) {
            updateBackoffMetadataWithLastFailedFetchTime(date);
        }
        return this.frcSharedPrefs.getBackoffMetadata();
    }

    private void updateBackoffMetadataWithLastFailedFetchTime(Date date) {
        int numFailedFetches = this.frcSharedPrefs.getBackoffMetadata().getNumFailedFetches() + 1;
        this.frcSharedPrefs.setBackoffMetadata(numFailedFetches, new Date(date.getTime() + getRandomizedBackoffDurationInMillis(numFailedFetches)));
    }

    private void updateLastFetchStatusAndTime(Task<FetchResponse> task, Date date) {
        if (task.isSuccessful()) {
            this.frcSharedPrefs.updateLastFetchAsSuccessfulAt(date);
            return;
        }
        Exception exception = task.getException();
        if (exception == null) {
            return;
        }
        if (exception instanceof FirebaseRemoteConfigFetchThrottledException) {
            this.frcSharedPrefs.updateLastFetchAsThrottled();
        } else {
            this.frcSharedPrefs.updateLastFetchAsFailed();
        }
    }

    public Task<FetchResponse> fetch() {
        return fetch(this.frcSharedPrefs.getMinimumFetchIntervalInSeconds());
    }

    public Task<FetchResponse> fetchNowWithTypeAndAttemptNumber(FetchType fetchType, int i5) {
        final HashMap hashMap = new HashMap(this.customHttpHeaders);
        hashMap.put(X_FIREBASE_RC_FETCH_TYPE, fetchType.getValue() + "/" + i5);
        return this.fetchedConfigsCache.get().continueWithTask(this.executor, new Continuation() { // from class: com.google.firebase.remoteconfig.internal.h
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                Task lambda$fetchNowWithTypeAndAttemptNumber$1;
                lambda$fetchNowWithTypeAndAttemptNumber$1 = ConfigFetchHandler.this.lambda$fetchNowWithTypeAndAttemptNumber$1(hashMap, task);
                return lambda$fetchNowWithTypeAndAttemptNumber$1;
            }
        });
    }

    public long getTemplateVersionNumber() {
        return this.frcSharedPrefs.getLastTemplateVersion();
    }

    public Task<FetchResponse> fetch(final long j5) {
        final HashMap hashMap = new HashMap(this.customHttpHeaders);
        hashMap.put(X_FIREBASE_RC_FETCH_TYPE, FetchType.BASE.getValue() + "/1");
        return this.fetchedConfigsCache.get().continueWithTask(this.executor, new Continuation() { // from class: com.google.firebase.remoteconfig.internal.e
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                Task lambda$fetch$0;
                lambda$fetch$0 = ConfigFetchHandler.this.lambda$fetch$0(j5, hashMap, task);
                return lambda$fetch$0;
            }
        });
    }
}
