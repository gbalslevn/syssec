package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.InstallIdProvider;
import com.google.firebase.crashlytics.internal.concurrency.CrashlyticsWorkers;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.installations.InstallationTokenResult;
import java.util.Locale;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import org.conscrypt.BuildConfig;

/* loaded from: classes2.dex */
public class IdManager implements InstallIdProvider {
    private static final String SYNTHETIC_FID_PREFIX = "SYN_";
    private static final int TIMEOUT_MILLIS = 10000;
    private final Context appContext;
    private final String appIdentifier;
    private final DataCollectionArbiter dataCollectionArbiter;
    private final FirebaseInstallationsApi firebaseInstallations;
    private InstallIdProvider.InstallIds installIds;
    private final InstallerPackageNameProvider installerPackageNameProvider;
    private static final Pattern ID_PATTERN = Pattern.compile("[^\\p{Alnum}]");
    private static final String FORWARD_SLASH_REGEX = Pattern.quote("/");

    public IdManager(Context context, String str, FirebaseInstallationsApi firebaseInstallationsApi, DataCollectionArbiter dataCollectionArbiter) {
        if (context == null) {
            throw new IllegalArgumentException("appContext must not be null");
        }
        if (str == null) {
            throw new IllegalArgumentException("appIdentifier must not be null");
        }
        this.appContext = context;
        this.appIdentifier = str;
        this.firebaseInstallations = firebaseInstallationsApi;
        this.dataCollectionArbiter = dataCollectionArbiter;
        this.installerPackageNameProvider = new InstallerPackageNameProvider();
    }

    private synchronized String createAndCacheCrashlyticsInstallId(String str, SharedPreferences sharedPreferences) {
        String formatId;
        formatId = formatId(UUID.randomUUID().toString());
        Logger.getLogger().v("Created new Crashlytics installation ID: " + formatId + " for FID: " + str);
        sharedPreferences.edit().putString("crashlytics.installation.id", formatId).putString("firebase.installation.id", str).apply();
        return formatId;
    }

    static String createSyntheticFid() {
        return SYNTHETIC_FID_PREFIX + UUID.randomUUID().toString();
    }

    private static String formatId(String str) {
        return ID_PATTERN.matcher(str).replaceAll(BuildConfig.FLAVOR).toLowerCase(Locale.US);
    }

    static boolean isSyntheticFid(String str) {
        return str != null && str.startsWith(SYNTHETIC_FID_PREFIX);
    }

    private String readCachedCrashlyticsInstallId(SharedPreferences sharedPreferences) {
        return sharedPreferences.getString("crashlytics.installation.id", null);
    }

    private String removeForwardSlashesIn(String str) {
        return str.replaceAll(FORWARD_SLASH_REGEX, BuildConfig.FLAVOR);
    }

    private boolean shouldRefresh() {
        InstallIdProvider.InstallIds installIds = this.installIds;
        return installIds == null || (installIds.getFirebaseInstallationId() == null && this.dataCollectionArbiter.isAutomaticDataCollectionEnabled());
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:1|(7:13|14|4|5|6|7|8)|3|4|5|6|7|8) */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0037, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0038, code lost:
    
        com.google.firebase.crashlytics.internal.Logger.getLogger().w("Error getting Firebase installation id.", r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public FirebaseInstallationId fetchTrueFid(boolean z5) {
        String token;
        CrashlyticsWorkers.checkNotMainThread();
        String str = null;
        if (z5) {
            try {
                token = ((InstallationTokenResult) Tasks.await(this.firebaseInstallations.getToken(false), 10000L, TimeUnit.MILLISECONDS)).getToken();
            } catch (Exception e5) {
                Logger.getLogger().w("Error getting Firebase authentication token.", e5);
            }
            str = (String) Tasks.await(this.firebaseInstallations.getId(), 10000L, TimeUnit.MILLISECONDS);
            return new FirebaseInstallationId(str, token);
        }
        token = null;
        str = (String) Tasks.await(this.firebaseInstallations.getId(), 10000L, TimeUnit.MILLISECONDS);
        return new FirebaseInstallationId(str, token);
    }

    public String getAppIdentifier() {
        return this.appIdentifier;
    }

    @Override // com.google.firebase.crashlytics.internal.common.InstallIdProvider
    public synchronized InstallIdProvider.InstallIds getInstallIds() {
        if (!shouldRefresh()) {
            return this.installIds;
        }
        Logger.getLogger().v("Determining Crashlytics installation ID...");
        SharedPreferences sharedPrefs = CommonUtils.getSharedPrefs(this.appContext);
        String string = sharedPrefs.getString("firebase.installation.id", null);
        Logger.getLogger().v("Cached Firebase Installation ID: " + string);
        if (this.dataCollectionArbiter.isAutomaticDataCollectionEnabled()) {
            FirebaseInstallationId fetchTrueFid = fetchTrueFid(false);
            Logger.getLogger().v("Fetched Firebase Installation ID: " + fetchTrueFid.getFid());
            if (fetchTrueFid.getFid() == null) {
                fetchTrueFid = new FirebaseInstallationId(string == null ? createSyntheticFid() : string, null);
            }
            if (Objects.equals(fetchTrueFid.getFid(), string)) {
                this.installIds = InstallIdProvider.InstallIds.create(readCachedCrashlyticsInstallId(sharedPrefs), fetchTrueFid);
            } else {
                this.installIds = InstallIdProvider.InstallIds.create(createAndCacheCrashlyticsInstallId(fetchTrueFid.getFid(), sharedPrefs), fetchTrueFid);
            }
        } else if (isSyntheticFid(string)) {
            this.installIds = InstallIdProvider.InstallIds.createWithoutFid(readCachedCrashlyticsInstallId(sharedPrefs));
        } else {
            this.installIds = InstallIdProvider.InstallIds.createWithoutFid(createAndCacheCrashlyticsInstallId(createSyntheticFid(), sharedPrefs));
        }
        Logger.getLogger().v("Install IDs: " + this.installIds);
        return this.installIds;
    }

    public String getInstallerPackageName() {
        return this.installerPackageNameProvider.getInstallerPackageName(this.appContext);
    }

    public String getModelName() {
        return String.format(Locale.US, "%s/%s", removeForwardSlashesIn(Build.MANUFACTURER), removeForwardSlashesIn(Build.MODEL));
    }

    public String getOsBuildVersionString() {
        return removeForwardSlashesIn(Build.VERSION.INCREMENTAL);
    }

    public String getOsDisplayVersionString() {
        return removeForwardSlashesIn(Build.VERSION.RELEASE);
    }
}
