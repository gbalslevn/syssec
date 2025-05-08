package com.facebook;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import com.adjust.sdk.Constants;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.Profile;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.AppEventsLoggerImpl;
import com.facebook.appevents.AppEventsManager;
import com.facebook.appevents.iap.InAppPurchaseLoggerManager;
import com.facebook.appevents.internal.ActivityLifecycleTracker;
import com.facebook.appevents.internal.AppEventsLoggerUtility;
import com.facebook.appevents.internal.AppLinkManager;
import com.facebook.appevents.ondeviceprocessing.OnDeviceProcessingManager;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.BoltsMeasurementEventListener;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.FetchedAppGateKeepersManager;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.LockOnGetVariable;
import com.facebook.internal.Logger;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.internal.instrument.InstrumentManager;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.sun.jna.Callback;
import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002pqB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\nH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\nH\u0007¢\u0006\u0004\b\u0011\u0010\fJ\u000f\u0010\u0013\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\nH\u0007¢\u0006\u0004\b\u0015\u0010\fJ\u000f\u0010\u0016\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u0016\u0010\u0014J\u000f\u0010\u0017\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u0017\u0010\u0014J\u000f\u0010\u0018\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u0018\u0010\u0014J\u0017\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u0019H\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ!\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0007¢\u0006\u0004\b\u001b\u0010\u001fJ\u000f\u0010 \u001a\u00020\nH\u0007¢\u0006\u0004\b \u0010\fJ\u000f\u0010!\u001a\u00020\u000eH\u0007¢\u0006\u0004\b!\u0010\u0003J\u0017\u0010$\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\"H\u0007¢\u0006\u0004\b$\u0010%J\u0017\u0010&\u001a\u00020\n2\u0006\u0010#\u001a\u00020\"H\u0007¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u000eH\u0002¢\u0006\u0004\b(\u0010\u0003J\u000f\u0010)\u001a\u00020\u0012H\u0007¢\u0006\u0004\b)\u0010\u0014J\u000f\u0010*\u001a\u00020\u0019H\u0007¢\u0006\u0004\b*\u0010+J\u001f\u0010.\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020\u00192\u0006\u0010-\u001a\u00020\u0012H\u0007¢\u0006\u0004\b.\u0010/J\u001f\u00100\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020\u00192\u0006\u0010-\u001a\u00020\u0012H\u0003¢\u0006\u0004\b0\u0010/J\u000f\u00101\u001a\u00020\u0012H\u0007¢\u0006\u0004\b1\u0010\u0014J\u0017\u00102\u001a\u00020\n2\u0006\u0010,\u001a\u00020\u0019H\u0007¢\u0006\u0004\b2\u00103J\u0019\u00105\u001a\u00020\u000e2\b\u0010,\u001a\u0004\u0018\u00010\u0019H\u0001¢\u0006\u0004\b4\u0010\u001cJ\u000f\u00106\u001a\u00020\u0012H\u0007¢\u0006\u0004\b6\u0010\u0014J\u0011\u00107\u001a\u0004\u0018\u00010\u0012H\u0007¢\u0006\u0004\b7\u0010\u0014J\u000f\u00108\u001a\u00020\u0012H\u0007¢\u0006\u0004\b8\u0010\u0014J\u000f\u00109\u001a\u00020\nH\u0007¢\u0006\u0004\b9\u0010\fJ\u0017\u0010;\u001a\u00020\u000e2\u0006\u0010:\u001a\u00020\nH\u0007¢\u0006\u0004\b;\u0010\u0010J\u000f\u0010<\u001a\u00020\nH\u0007¢\u0006\u0004\b<\u0010\fJ\u0017\u0010=\u001a\u00020\u000e2\u0006\u0010:\u001a\u00020\nH\u0007¢\u0006\u0004\b=\u0010\u0010J\u000f\u0010>\u001a\u00020\nH\u0007¢\u0006\u0004\b>\u0010\fJ\u000f\u0010?\u001a\u00020\nH\u0007¢\u0006\u0004\b?\u0010\fJ\u0017\u0010@\u001a\u00020\u000e2\u0006\u0010:\u001a\u00020\nH\u0007¢\u0006\u0004\b@\u0010\u0010J\u000f\u0010B\u001a\u00020AH\u0007¢\u0006\u0004\bB\u0010CR\u001c\u0010E\u001a\n D*\u0004\u0018\u00010\u00120\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010FR$\u0010I\u001a\u0012\u0012\u0004\u0012\u00020\"0Gj\b\u0012\u0004\u0012\u00020\"`H8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u0014\u0010K\u001a\u00020A8\u0002X\u0082T¢\u0006\u0006\n\u0004\bK\u0010LR\u0018\u0010M\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u0018\u0010-\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010FR\u0018\u0010O\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010FR\u0018\u0010P\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010FR\u0018\u0010Q\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010T\u001a\u00020S8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010V\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010\u0011\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010WR\u001c\u0010Z\u001a\b\u0012\u0004\u0012\u00020Y0X8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001a\u0010\\R\u0016\u0010]\u001a\u00020A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010LR\u0014\u0010_\u001a\u00020^8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010a\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010FR\u0014\u0010b\u001a\u00020A8\u0002X\u0082T¢\u0006\u0006\n\u0004\bb\u0010LR\u0014\u0010c\u001a\u00020\u00128\u0002X\u0082T¢\u0006\u0006\n\u0004\bc\u0010FR\u0014\u0010d\u001a\u00020\u00128\u0002X\u0082T¢\u0006\u0006\n\u0004\bd\u0010FR\u0016\u0010e\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\be\u0010WR\u0016\u0010f\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bf\u0010WR\u0016\u0010g\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bg\u0010WR\u0014\u0010i\u001a\u00020h8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bi\u0010jR\u0016\u0010k\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010FR\u0016\u0010l\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bl\u0010FR\u0016\u0010n\u001a\u00020m8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bn\u0010oR\u0016\u0010\u0015\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010W¨\u0006r"}, d2 = {"Lcom/facebook/FacebookSdk;", BuildConfig.FLAVOR, "<init>", "()V", "Ljava/util/concurrent/Executor;", "getExecutor", "()Ljava/util/concurrent/Executor;", BuildConfig.FLAVOR, "getOnProgressThreshold", "()J", BuildConfig.FLAVOR, "isDebugEnabled", "()Z", "enabled", BuildConfig.FLAVOR, "setIsDebugEnabled", "(Z)V", "isLegacyTokenUpgradeSupported", BuildConfig.FLAVOR, "getGraphApiVersion", "()Ljava/lang/String;", "isFullyInitialized", "getFacebookDomain", "getFacebookGamingDomain", "getInstagramDomain", "Landroid/content/Context;", "applicationContext", "sdkInitialize", "(Landroid/content/Context;)V", "Lcom/facebook/FacebookSdk$InitializeCallback;", Callback.METHOD_NAME, "(Landroid/content/Context;Lcom/facebook/FacebookSdk$InitializeCallback;)V", "isInitialized", "fullyInitialize", "Lcom/facebook/LoggingBehavior;", "behavior", "addLoggingBehavior", "(Lcom/facebook/LoggingBehavior;)V", "isLoggingBehaviorEnabled", "(Lcom/facebook/LoggingBehavior;)Z", "updateGraphDebugBehavior", "getGraphDomain", "getApplicationContext", "()Landroid/content/Context;", "context", "applicationId", "publishInstallAsync", "(Landroid/content/Context;Ljava/lang/String;)V", "publishInstallAndWaitForResponse", "getSdkVersion", "getLimitEventAndDataUsage", "(Landroid/content/Context;)Z", "loadDefaultsFromMetadata$facebook_core_release", "loadDefaultsFromMetadata", "getApplicationId", "getApplicationName", "getClientToken", "getAutoInitEnabled", "flag", "setAutoInitEnabled", "getAutoLogAppEventsEnabled", "setAutoLogAppEventsEnabled", "getCodelessSetupEnabled", "getAdvertiserIDCollectionEnabled", "setAdvertiserIDCollectionEnabled", BuildConfig.FLAVOR, "getCallbackRequestCodeOffset", "()I", "kotlin.jvm.PlatformType", "TAG", "Ljava/lang/String;", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "loggingBehaviors", "Ljava/util/HashSet;", "DEFAULT_CALLBACK_REQUEST_CODE_OFFSET", "I", "executor", "Ljava/util/concurrent/Executor;", "applicationName", "appClientToken", "codelessDebugLogEnabled", "Ljava/lang/Boolean;", "Ljava/util/concurrent/atomic/AtomicLong;", "onProgressThreshold", "Ljava/util/concurrent/atomic/AtomicLong;", "isDebugEnabledField", "Z", "Lcom/facebook/internal/LockOnGetVariable;", "Ljava/io/File;", "cacheDir", "Lcom/facebook/internal/LockOnGetVariable;", "Landroid/content/Context;", "callbackRequestCodeOffset", "Ljava/util/concurrent/locks/ReentrantLock;", "LOCK", "Ljava/util/concurrent/locks/ReentrantLock;", "graphApiVersion", "MAX_REQUEST_CODE_RANGE", "ATTRIBUTION_PREFERENCES", "PUBLISH_ACTIVITY_PATH", "hasCustomTabsPrefetching", "ignoreAppSwitchToLoggedOut", "bypassAppSwitch", "Ljava/util/concurrent/atomic/AtomicBoolean;", "sdkInitialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "instagramDomain", "facebookDomain", "Lcom/facebook/FacebookSdk$GraphRequestCreator;", "graphRequestCreator", "Lcom/facebook/FacebookSdk$GraphRequestCreator;", "GraphRequestCreator", "InitializeCallback", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class FacebookSdk {
    private static final String ATTRIBUTION_PREFERENCES = "com.facebook.sdk.attributionTracking";
    private static final int MAX_REQUEST_CODE_RANGE = 100;
    private static final String PUBLISH_ACTIVITY_PATH = "%s/activities";
    private static volatile String appClientToken;
    private static Context applicationContext;
    private static volatile String applicationId;
    private static volatile String applicationName;
    public static boolean bypassAppSwitch;
    private static LockOnGetVariable<File> cacheDir;
    private static volatile Boolean codelessDebugLogEnabled;
    private static Executor executor;
    public static boolean hasCustomTabsPrefetching;
    public static boolean ignoreAppSwitchToLoggedOut;
    private static volatile boolean isDebugEnabledField;
    private static boolean isFullyInitialized;
    private static boolean isLegacyTokenUpgradeSupported;
    public static final FacebookSdk INSTANCE = new FacebookSdk();
    private static final String TAG = FacebookSdk.class.getCanonicalName();
    private static final HashSet<LoggingBehavior> loggingBehaviors = SetsKt.hashSetOf(LoggingBehavior.DEVELOPER_ERRORS);
    private static AtomicLong onProgressThreshold = new AtomicLong(65536);
    private static final int DEFAULT_CALLBACK_REQUEST_CODE_OFFSET = 64206;
    private static int callbackRequestCodeOffset = DEFAULT_CALLBACK_REQUEST_CODE_OFFSET;
    private static final ReentrantLock LOCK = new ReentrantLock();
    private static String graphApiVersion = ServerProtocol.getDefaultAPIVersion();
    private static final AtomicBoolean sdkInitialized = new AtomicBoolean(false);
    private static volatile String instagramDomain = "instagram.com";
    private static volatile String facebookDomain = "facebook.com";
    private static GraphRequestCreator graphRequestCreator = new GraphRequestCreator() { // from class: d0.d
        @Override // com.facebook.FacebookSdk.GraphRequestCreator
        public final GraphRequest createPostRequest(AccessToken accessToken, String str, JSONObject jSONObject, GraphRequest.Callback callback) {
            GraphRequest m2774graphRequestCreator$lambda0;
            m2774graphRequestCreator$lambda0 = FacebookSdk.m2774graphRequestCreator$lambda0(accessToken, str, jSONObject, callback);
            return m2774graphRequestCreator$lambda0;
        }
    };

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bá\u0080\u0001\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&¨\u0006\f"}, d2 = {"Lcom/facebook/FacebookSdk$GraphRequestCreator;", BuildConfig.FLAVOR, "createPostRequest", "Lcom/facebook/GraphRequest;", "accessToken", "Lcom/facebook/AccessToken;", "publishUrl", BuildConfig.FLAVOR, "publishParams", "Lorg/json/JSONObject;", Callback.METHOD_NAME, "Lcom/facebook/GraphRequest$Callback;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes.dex */
    public interface GraphRequestCreator {
        GraphRequest createPostRequest(AccessToken accessToken, String publishUrl, JSONObject publishParams, GraphRequest.Callback callback);
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/facebook/FacebookSdk$InitializeCallback;", BuildConfig.FLAVOR, "onInitialized", BuildConfig.FLAVOR, "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes.dex */
    public interface InitializeCallback {
        void onInitialized();
    }

    private FacebookSdk() {
    }

    public static final void addLoggingBehavior(LoggingBehavior behavior) {
        Intrinsics.checkNotNullParameter(behavior, "behavior");
        HashSet<LoggingBehavior> hashSet = loggingBehaviors;
        synchronized (hashSet) {
            hashSet.add(behavior);
            INSTANCE.updateGraphDebugBehavior();
            Unit unit = Unit.INSTANCE;
        }
    }

    public static final void fullyInitialize() {
        isFullyInitialized = true;
    }

    public static final boolean getAdvertiserIDCollectionEnabled() {
        return UserSettingsManager.getAdvertiserIDCollectionEnabled();
    }

    public static final Context getApplicationContext() {
        Validate.sdkInitialized();
        Context context = applicationContext;
        if (context != null) {
            return context;
        }
        Intrinsics.throwUninitializedPropertyAccessException("applicationContext");
        throw null;
    }

    public static final String getApplicationId() {
        Validate.sdkInitialized();
        String str = applicationId;
        if (str != null) {
            return str;
        }
        throw new FacebookException("A valid Facebook app id must be set in the AndroidManifest.xml or set by calling FacebookSdk.setApplicationId before initializing the sdk.");
    }

    public static final String getApplicationName() {
        Validate.sdkInitialized();
        return applicationName;
    }

    public static final boolean getAutoInitEnabled() {
        return UserSettingsManager.getAutoInitEnabled();
    }

    public static final boolean getAutoLogAppEventsEnabled() {
        return UserSettingsManager.getAutoLogAppEventsEnabled();
    }

    public static final int getCallbackRequestCodeOffset() {
        Validate.sdkInitialized();
        return callbackRequestCodeOffset;
    }

    public static final String getClientToken() {
        Validate.sdkInitialized();
        String str = appClientToken;
        if (str != null) {
            return str;
        }
        throw new FacebookException("A valid Facebook client token must be set in the AndroidManifest.xml or set by calling FacebookSdk.setClientToken before initializing the sdk. Visit https://developers.facebook.com/docs/android/getting-started#add-app_id for more information.");
    }

    public static final boolean getCodelessSetupEnabled() {
        return UserSettingsManager.getCodelessSetupEnabled();
    }

    public static final Executor getExecutor() {
        ReentrantLock reentrantLock = LOCK;
        reentrantLock.lock();
        try {
            if (executor == null) {
                executor = AsyncTask.THREAD_POOL_EXECUTOR;
            }
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            Executor executor2 = executor;
            if (executor2 != null) {
                return executor2;
            }
            throw new IllegalStateException("Required value was null.");
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public static final String getFacebookDomain() {
        return facebookDomain;
    }

    public static final String getFacebookGamingDomain() {
        return "fb.gg";
    }

    public static final String getGraphApiVersion() {
        Utility utility = Utility.INSTANCE;
        String str = TAG;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("getGraphApiVersion: %s", Arrays.copyOf(new Object[]{graphApiVersion}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
        Utility.logd(str, format);
        return graphApiVersion;
    }

    public static final String getGraphDomain() {
        AccessToken currentAccessToken = AccessToken.INSTANCE.getCurrentAccessToken();
        return Utility.getGraphDomainFromTokenDomain(currentAccessToken != null ? currentAccessToken.getGraphDomain() : null);
    }

    public static final String getInstagramDomain() {
        return instagramDomain;
    }

    public static final boolean getLimitEventAndDataUsage(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Validate.sdkInitialized();
        return context.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).getBoolean("limitEventUsage", false);
    }

    public static final long getOnProgressThreshold() {
        Validate.sdkInitialized();
        return onProgressThreshold.get();
    }

    public static final String getSdkVersion() {
        return "18.0.0";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: graphRequestCreator$lambda-0, reason: not valid java name */
    public static final GraphRequest m2774graphRequestCreator$lambda0(AccessToken accessToken, String str, JSONObject jSONObject, GraphRequest.Callback callback) {
        return GraphRequest.INSTANCE.newPostRequest(accessToken, str, jSONObject, callback);
    }

    public static final boolean isDebugEnabled() {
        return isDebugEnabledField;
    }

    public static final synchronized boolean isFullyInitialized() {
        boolean z5;
        synchronized (FacebookSdk.class) {
            z5 = isFullyInitialized;
        }
        return z5;
    }

    public static final boolean isInitialized() {
        return sdkInitialized.get();
    }

    public static final boolean isLegacyTokenUpgradeSupported() {
        return isLegacyTokenUpgradeSupported;
    }

    public static final boolean isLoggingBehaviorEnabled(LoggingBehavior behavior) {
        boolean z5;
        Intrinsics.checkNotNullParameter(behavior, "behavior");
        HashSet<LoggingBehavior> hashSet = loggingBehaviors;
        synchronized (hashSet) {
            if (isDebugEnabled()) {
                z5 = hashSet.contains(behavior);
            }
        }
        return z5;
    }

    public static final void loadDefaultsFromMetadata$facebook_core_release(Context context) {
        if (context == null) {
            return;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            Intrinsics.checkNotNullExpressionValue(applicationInfo, "try {\n                context.packageManager.getApplicationInfo(\n                    context.packageName, PackageManager.GET_META_DATA\n                )\n            } catch (e: PackageManager.NameNotFoundException) {\n                return\n            }");
            if (applicationInfo.metaData == null) {
                return;
            }
            if (applicationId == null) {
                Object obj = applicationInfo.metaData.get("com.facebook.sdk.ApplicationId");
                if (obj instanceof String) {
                    String str = (String) obj;
                    Locale ROOT = Locale.ROOT;
                    Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
                    String lowerCase = str.toLowerCase(ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                    if (StringsKt.startsWith$default(lowerCase, "fb", false, 2, (Object) null)) {
                        String substring = str.substring(2);
                        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
                        applicationId = substring;
                    } else {
                        applicationId = str;
                    }
                } else if (obj instanceof Number) {
                    throw new FacebookException("App Ids cannot be directly placed in the manifest.They must be prefixed by 'fb' or be placed in the string resource file.");
                }
            }
            if (applicationName == null) {
                applicationName = applicationInfo.metaData.getString("com.facebook.sdk.ApplicationName");
            }
            if (appClientToken == null) {
                appClientToken = applicationInfo.metaData.getString("com.facebook.sdk.ClientToken");
            }
            if (callbackRequestCodeOffset == DEFAULT_CALLBACK_REQUEST_CODE_OFFSET) {
                callbackRequestCodeOffset = applicationInfo.metaData.getInt("com.facebook.sdk.CallbackOffset", DEFAULT_CALLBACK_REQUEST_CODE_OFFSET);
            }
            if (codelessDebugLogEnabled == null) {
                codelessDebugLogEnabled = Boolean.valueOf(applicationInfo.metaData.getBoolean("com.facebook.sdk.CodelessDebugLogEnabled", false));
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    private final void publishInstallAndWaitForResponse(Context context, String applicationId2) {
        try {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return;
            }
            try {
                AttributionIdentifiers attributionIdentifiers = AttributionIdentifiers.INSTANCE.getAttributionIdentifiers(context);
                SharedPreferences sharedPreferences = context.getSharedPreferences(ATTRIBUTION_PREFERENCES, 0);
                String stringPlus = Intrinsics.stringPlus(applicationId2, "ping");
                long j5 = sharedPreferences.getLong(stringPlus, 0L);
                try {
                    AppEventsLoggerUtility appEventsLoggerUtility = AppEventsLoggerUtility.INSTANCE;
                    JSONObject jSONObjectForGraphAPICall = AppEventsLoggerUtility.getJSONObjectForGraphAPICall(AppEventsLoggerUtility.GraphAPIActivityType.MOBILE_INSTALL_EVENT, attributionIdentifiers, AppEventsLogger.INSTANCE.getAnonymousAppDeviceGUID(context), getLimitEventAndDataUsage(context), context);
                    String installReferrer = AppEventsLoggerImpl.INSTANCE.getInstallReferrer();
                    if (installReferrer != null) {
                        jSONObjectForGraphAPICall.put(Constants.INSTALL_REFERRER, installReferrer);
                    }
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String format = String.format(PUBLISH_ACTIVITY_PATH, Arrays.copyOf(new Object[]{applicationId2}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
                    GraphRequest createPostRequest = graphRequestCreator.createPostRequest(null, format, jSONObjectForGraphAPICall, null);
                    if (j5 == 0 && createPostRequest.executeAndWait().getError() == null) {
                        SharedPreferences.Editor edit = sharedPreferences.edit();
                        edit.putLong(stringPlus, System.currentTimeMillis());
                        edit.apply();
                        Logger.Companion companion = Logger.INSTANCE;
                        LoggingBehavior loggingBehavior = LoggingBehavior.APP_EVENTS;
                        String TAG2 = TAG;
                        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                        companion.log(loggingBehavior, TAG2, "MOBILE_APP_INSTALL has been logged");
                    }
                } catch (JSONException e5) {
                    throw new FacebookException("An error occurred while publishing install.", e5);
                }
            } catch (Exception e6) {
                Utility.logd("Facebook-publish", e6);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public static final void publishInstallAsync(Context context, final String applicationId2) {
        if (CrashShieldHandler.isObjectCrashing(FacebookSdk.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(applicationId2, "applicationId");
            final Context applicationContext2 = context.getApplicationContext();
            if (applicationContext2 == null) {
                return;
            }
            FetchedAppGateKeepersManager fetchedAppGateKeepersManager = FetchedAppGateKeepersManager.INSTANCE;
            if (!FetchedAppGateKeepersManager.getGateKeeperForKey("app_events_killswitch", getApplicationId(), false)) {
                getExecutor().execute(new Runnable() { // from class: d0.l
                    @Override // java.lang.Runnable
                    public final void run() {
                        FacebookSdk.m2775publishInstallAsync$lambda15(applicationContext2, applicationId2);
                    }
                });
            }
            FeatureManager featureManager = FeatureManager.INSTANCE;
            if (FeatureManager.isEnabled(FeatureManager.Feature.OnDeviceEventProcessing) && OnDeviceProcessingManager.isOnDeviceProcessingEnabled()) {
                OnDeviceProcessingManager.sendInstallEventAsync(applicationId2, ATTRIBUTION_PREFERENCES);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, FacebookSdk.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: publishInstallAsync$lambda-15, reason: not valid java name */
    public static final void m2775publishInstallAsync$lambda15(Context applicationContext2, String applicationId2) {
        Intrinsics.checkNotNullParameter(applicationContext2, "$applicationContext");
        Intrinsics.checkNotNullParameter(applicationId2, "$applicationId");
        INSTANCE.publishInstallAndWaitForResponse(applicationContext2, applicationId2);
    }

    @Deprecated
    public static final synchronized void sdkInitialize(Context applicationContext2) {
        synchronized (FacebookSdk.class) {
            Intrinsics.checkNotNullParameter(applicationContext2, "applicationContext");
            sdkInitialize(applicationContext2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: sdkInitialize$lambda-3, reason: not valid java name */
    public static final File m2776sdkInitialize$lambda3() {
        Context context = applicationContext;
        if (context != null) {
            return context.getCacheDir();
        }
        Intrinsics.throwUninitializedPropertyAccessException("applicationContext");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: sdkInitialize$lambda-4, reason: not valid java name */
    public static final void m2777sdkInitialize$lambda4(boolean z5) {
        if (z5) {
            InstrumentManager.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: sdkInitialize$lambda-5, reason: not valid java name */
    public static final void m2778sdkInitialize$lambda5(boolean z5) {
        if (z5) {
            AppEventsManager.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: sdkInitialize$lambda-6, reason: not valid java name */
    public static final void m2779sdkInitialize$lambda6(boolean z5) {
        if (z5) {
            hasCustomTabsPrefetching = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: sdkInitialize$lambda-7, reason: not valid java name */
    public static final void m2780sdkInitialize$lambda7(boolean z5) {
        if (z5) {
            ignoreAppSwitchToLoggedOut = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: sdkInitialize$lambda-8, reason: not valid java name */
    public static final void m2781sdkInitialize$lambda8(boolean z5) {
        if (z5) {
            bypassAppSwitch = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: sdkInitialize$lambda-9, reason: not valid java name */
    public static final Void m2782sdkInitialize$lambda9(InitializeCallback initializeCallback) {
        AccessTokenManager.INSTANCE.getInstance().loadCurrentAccessToken();
        ProfileManager.INSTANCE.getInstance().loadCurrentProfile();
        if (AccessToken.INSTANCE.isCurrentAccessTokenActive()) {
            Profile.Companion companion = Profile.INSTANCE;
            if (companion.getCurrentProfile() == null) {
                companion.fetchProfileForCurrentAccessToken();
            }
        }
        if (initializeCallback != null) {
            initializeCallback.onInitialized();
        }
        AppEventsLogger.Companion companion2 = AppEventsLogger.INSTANCE;
        companion2.initializeLib(getApplicationContext(), applicationId);
        UserSettingsManager.logIfAutoAppLinkEnabled();
        Context applicationContext2 = getApplicationContext().getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext2, "getApplicationContext().applicationContext");
        companion2.newLogger(applicationContext2).flush();
        return null;
    }

    public static final void setAdvertiserIDCollectionEnabled(boolean flag) {
        UserSettingsManager.setAdvertiserIDCollectionEnabled(flag);
    }

    public static final void setAutoInitEnabled(boolean flag) {
        UserSettingsManager.setAutoInitEnabled(flag);
        if (flag) {
            fullyInitialize();
        }
    }

    public static final void setAutoLogAppEventsEnabled(boolean flag) {
        UserSettingsManager.setAutoLogAppEventsEnabled(flag);
        if (flag) {
            Application application = (Application) getApplicationContext();
            ActivityLifecycleTracker activityLifecycleTracker = ActivityLifecycleTracker.INSTANCE;
            ActivityLifecycleTracker.startTracking(application, getApplicationId());
        }
    }

    public static final void setIsDebugEnabled(boolean enabled) {
        isDebugEnabledField = enabled;
    }

    private final void updateGraphDebugBehavior() {
        HashSet<LoggingBehavior> hashSet = loggingBehaviors;
        if (hashSet.contains(LoggingBehavior.GRAPH_API_DEBUG_INFO)) {
            LoggingBehavior loggingBehavior = LoggingBehavior.GRAPH_API_DEBUG_WARNING;
            if (hashSet.contains(loggingBehavior)) {
                return;
            }
            hashSet.add(loggingBehavior);
        }
    }

    @Deprecated
    public static final synchronized void sdkInitialize(Context applicationContext2, final InitializeCallback callback) {
        synchronized (FacebookSdk.class) {
            Intrinsics.checkNotNullParameter(applicationContext2, "applicationContext");
            AtomicBoolean atomicBoolean = sdkInitialized;
            if (atomicBoolean.get()) {
                if (callback != null) {
                    callback.onInitialized();
                }
                return;
            }
            Validate.hasFacebookActivity(applicationContext2, false);
            Validate.hasInternetPermissions(applicationContext2, false);
            Context applicationContext3 = applicationContext2.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext3, "applicationContext.applicationContext");
            applicationContext = applicationContext3;
            AppEventsLogger.INSTANCE.getAnonymousAppDeviceGUID(applicationContext2);
            Context context = applicationContext;
            if (context != null) {
                loadDefaultsFromMetadata$facebook_core_release(context);
                String str = applicationId;
                if (str != null && str.length() != 0) {
                    String str2 = appClientToken;
                    if (str2 != null && str2.length() != 0) {
                        atomicBoolean.set(true);
                        if (getAutoInitEnabled()) {
                            fullyInitialize();
                        }
                        Context context2 = applicationContext;
                        if (context2 != null) {
                            if ((context2 instanceof Application) && UserSettingsManager.getAutoLogAppEventsEnabled()) {
                                ActivityLifecycleTracker activityLifecycleTracker = ActivityLifecycleTracker.INSTANCE;
                                Context context3 = applicationContext;
                                if (context3 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("applicationContext");
                                    throw null;
                                }
                                ActivityLifecycleTracker.startTracking((Application) context3, applicationId);
                            } else {
                                InAppPurchaseLoggerManager.updateLatestPossiblePurchaseTime();
                            }
                            AppLinkManager companion = AppLinkManager.INSTANCE.getInstance();
                            if (companion != null) {
                                Context context4 = applicationContext;
                                if (context4 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("applicationContext");
                                    throw null;
                                }
                                companion.setupLifecycleListener((Application) context4);
                            }
                            FetchedAppSettingsManager.loadAppSettingsAsync();
                            NativeProtocol.updateAllAvailableProtocolVersionsAsync();
                            BoltsMeasurementEventListener.Companion companion2 = BoltsMeasurementEventListener.INSTANCE;
                            Context context5 = applicationContext;
                            if (context5 != null) {
                                companion2.getInstance(context5);
                                cacheDir = new LockOnGetVariable<>(new Callable() { // from class: d0.e
                                    @Override // java.util.concurrent.Callable
                                    public final Object call() {
                                        File m2776sdkInitialize$lambda3;
                                        m2776sdkInitialize$lambda3 = FacebookSdk.m2776sdkInitialize$lambda3();
                                        return m2776sdkInitialize$lambda3;
                                    }
                                });
                                FeatureManager featureManager = FeatureManager.INSTANCE;
                                FeatureManager.checkFeature(FeatureManager.Feature.Instrument, new FeatureManager.Callback() { // from class: d0.f
                                    @Override // com.facebook.internal.FeatureManager.Callback
                                    public final void onCompleted(boolean z5) {
                                        FacebookSdk.m2777sdkInitialize$lambda4(z5);
                                    }
                                });
                                FeatureManager.checkFeature(FeatureManager.Feature.AppEvents, new FeatureManager.Callback() { // from class: d0.g
                                    @Override // com.facebook.internal.FeatureManager.Callback
                                    public final void onCompleted(boolean z5) {
                                        FacebookSdk.m2778sdkInitialize$lambda5(z5);
                                    }
                                });
                                FeatureManager.checkFeature(FeatureManager.Feature.ChromeCustomTabsPrefetching, new FeatureManager.Callback() { // from class: d0.h
                                    @Override // com.facebook.internal.FeatureManager.Callback
                                    public final void onCompleted(boolean z5) {
                                        FacebookSdk.m2779sdkInitialize$lambda6(z5);
                                    }
                                });
                                FeatureManager.checkFeature(FeatureManager.Feature.IgnoreAppSwitchToLoggedOut, new FeatureManager.Callback() { // from class: d0.i
                                    @Override // com.facebook.internal.FeatureManager.Callback
                                    public final void onCompleted(boolean z5) {
                                        FacebookSdk.m2780sdkInitialize$lambda7(z5);
                                    }
                                });
                                FeatureManager.checkFeature(FeatureManager.Feature.BypassAppSwitch, new FeatureManager.Callback() { // from class: d0.j
                                    @Override // com.facebook.internal.FeatureManager.Callback
                                    public final void onCompleted(boolean z5) {
                                        FacebookSdk.m2781sdkInitialize$lambda8(z5);
                                    }
                                });
                                getExecutor().execute(new FutureTask(new Callable(callback) { // from class: d0.k
                                    @Override // java.util.concurrent.Callable
                                    public final Object call() {
                                        Void m2782sdkInitialize$lambda9;
                                        m2782sdkInitialize$lambda9 = FacebookSdk.m2782sdkInitialize$lambda9(null);
                                        return m2782sdkInitialize$lambda9;
                                    }
                                }));
                                return;
                            }
                            Intrinsics.throwUninitializedPropertyAccessException("applicationContext");
                            throw null;
                        }
                        Intrinsics.throwUninitializedPropertyAccessException("applicationContext");
                        throw null;
                    }
                    throw new FacebookException("A valid Facebook app client token must be set in the AndroidManifest.xml or set by calling FacebookSdk.setClientToken before initializing the sdk.");
                }
                throw new FacebookException("A valid Facebook app id must be set in the AndroidManifest.xml or set by calling FacebookSdk.setApplicationId before initializing the sdk.");
            }
            Intrinsics.throwUninitializedPropertyAccessException("applicationContext");
            throw null;
        }
    }
}
