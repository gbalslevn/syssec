package com.facebook.internal;

import android.R;
import androidx.appcompat.R$styleable;
import com.facebook.FacebookSdk;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.FetchedAppGateKeepersManager;
import com.sun.jna.Function;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\bÇ\u0002\u0018\u00002\u00020\u0001:\u0002\u0016\u0017B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0007H\u0007J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0004H\u0007J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J\b\u0010\u0014\u001a\u00020\nH\u0002J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u0007H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R \u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/facebook/internal/FeatureManager;", BuildConfig.FLAVOR, "()V", "FEATURE_MANAGER_STORE", BuildConfig.FLAVOR, "featureMapping", BuildConfig.FLAVOR, "Lcom/facebook/internal/FeatureManager$Feature;", BuildConfig.FLAVOR, "checkFeature", BuildConfig.FLAVOR, "feature", com.sun.jna.Callback.METHOD_NAME, "Lcom/facebook/internal/FeatureManager$Callback;", "defaultStatus", BuildConfig.FLAVOR, "disableFeature", "getFeature", "className", "getGKStatus", "initializeFeatureMapping", "isEnabled", "Callback", "Feature", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class FeatureManager {
    private static final String FEATURE_MANAGER_STORE = "com.facebook.internal.FEATURE_MANAGER";
    public static final FeatureManager INSTANCE = new FeatureManager();
    private static final Map<Feature, String[]> featureMapping = new HashMap();

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/facebook/internal/FeatureManager$Callback;", BuildConfig.FLAVOR, "onCompleted", BuildConfig.FLAVOR, "enabled", BuildConfig.FLAVOR, "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes.dex */
    public interface Callback {
        void onCompleted(boolean enabled);
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b/\b\u0086\u0001\u0018\u0000 72\b\u0012\u0004\u0012\u00020\u00000\u0001:\u00017B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\b\u001a\u00020\tJ\b\u0010\n\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6¨\u00068"}, d2 = {"Lcom/facebook/internal/FeatureManager$Feature;", BuildConfig.FLAVOR, "code", BuildConfig.FLAVOR, "(Ljava/lang/String;II)V", "parent", "getParent", "()Lcom/facebook/internal/FeatureManager$Feature;", "toKey", BuildConfig.FLAVOR, "toString", "Unknown", "Core", "AppEvents", "CodelessEvents", "CloudBridge", "RestrictiveDataFiltering", "AAM", "PrivacyProtection", "SuggestedEvents", "IntelligentIntegrity", "ModelRequest", "ProtectedMode", "MACARuleMatching", "BlocklistEvents", "FilterRedactedEvents", "FilterSensitiveParams", "StdParamEnforcement", "BannedParamFiltering", "EventDeactivation", "OnDeviceEventProcessing", "OnDevicePostInstallEventProcessing", "IapLogging", "IapLoggingLib2", "IapLoggingLib5To7", "AndroidManualImplicitPurchaseDedupe", "AndroidManualImplicitSubsDedupe", "AndroidIAPSubscriptionAutoLogging", "Instrument", "CrashReport", "CrashShield", "ThreadCheck", "ErrorReport", "AnrReport", "Monitoring", "ServiceUpdateCompliance", "Megatron", "Elora", "GPSARATriggers", "GPSPACAProcessing", "Login", "ChromeCustomTabsPrefetching", "IgnoreAppSwitchToLoggedOut", "BypassAppSwitch", "Share", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes.dex */
    public enum Feature {
        Unknown(-1),
        Core(0),
        AppEvents(65536),
        CodelessEvents(65792),
        CloudBridge(67584),
        RestrictiveDataFiltering(66048),
        AAM(66304),
        PrivacyProtection(66560),
        SuggestedEvents(66561),
        IntelligentIntegrity(66562),
        ModelRequest(66563),
        ProtectedMode(66564),
        MACARuleMatching(66565),
        BlocklistEvents(66566),
        FilterRedactedEvents(66567),
        FilterSensitiveParams(66568),
        StdParamEnforcement(R.attr.trimPathEnd),
        BannedParamFiltering(R.attr.trimPathOffset),
        EventDeactivation(66816),
        OnDeviceEventProcessing(67072),
        OnDevicePostInstallEventProcessing(67073),
        IapLogging(67328),
        IapLoggingLib2(67329),
        IapLoggingLib5To7(67330),
        AndroidManualImplicitPurchaseDedupe(67331),
        AndroidManualImplicitSubsDedupe(67332),
        AndroidIAPSubscriptionAutoLogging(67333),
        Instrument(131072),
        CrashReport(131328),
        CrashShield(131329),
        ThreadCheck(131330),
        ErrorReport(131584),
        AnrReport(131840),
        Monitoring(196608),
        ServiceUpdateCompliance(196864),
        Megatron(262144),
        Elora(327680),
        GPSARATriggers(393216),
        GPSPACAProcessing(458752),
        Login(16777216),
        ChromeCustomTabsPrefetching(R.attr.theme),
        IgnoreAppSwitchToLoggedOut(R.id.background),
        BypassAppSwitch(R.style.Animation),
        Share(33554432);


        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final int code;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/facebook/internal/FeatureManager$Feature$Companion;", BuildConfig.FLAVOR, "()V", "fromInt", "Lcom/facebook/internal/FeatureManager$Feature;", "code", BuildConfig.FLAVOR, "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        /* loaded from: classes.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final Feature fromInt(int code) {
                Feature[] valuesCustom = Feature.valuesCustom();
                int length = valuesCustom.length;
                int i5 = 0;
                while (i5 < length) {
                    Feature feature = valuesCustom[i5];
                    i5++;
                    if (feature.code == code) {
                        return feature;
                    }
                }
                return Feature.Unknown;
            }

            private Companion() {
            }
        }

        @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
        /* loaded from: classes.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[Feature.valuesCustom().length];
                iArr[Feature.Core.ordinal()] = 1;
                iArr[Feature.AppEvents.ordinal()] = 2;
                iArr[Feature.CodelessEvents.ordinal()] = 3;
                iArr[Feature.RestrictiveDataFiltering.ordinal()] = 4;
                iArr[Feature.Instrument.ordinal()] = 5;
                iArr[Feature.CrashReport.ordinal()] = 6;
                iArr[Feature.CrashShield.ordinal()] = 7;
                iArr[Feature.ThreadCheck.ordinal()] = 8;
                iArr[Feature.ErrorReport.ordinal()] = 9;
                iArr[Feature.AnrReport.ordinal()] = 10;
                iArr[Feature.AAM.ordinal()] = 11;
                iArr[Feature.CloudBridge.ordinal()] = 12;
                iArr[Feature.PrivacyProtection.ordinal()] = 13;
                iArr[Feature.SuggestedEvents.ordinal()] = 14;
                iArr[Feature.IntelligentIntegrity.ordinal()] = 15;
                iArr[Feature.StdParamEnforcement.ordinal()] = 16;
                iArr[Feature.ProtectedMode.ordinal()] = 17;
                iArr[Feature.BannedParamFiltering.ordinal()] = 18;
                iArr[Feature.MACARuleMatching.ordinal()] = 19;
                iArr[Feature.BlocklistEvents.ordinal()] = 20;
                iArr[Feature.FilterRedactedEvents.ordinal()] = 21;
                iArr[Feature.FilterSensitiveParams.ordinal()] = 22;
                iArr[Feature.ModelRequest.ordinal()] = 23;
                iArr[Feature.EventDeactivation.ordinal()] = 24;
                iArr[Feature.OnDeviceEventProcessing.ordinal()] = 25;
                iArr[Feature.OnDevicePostInstallEventProcessing.ordinal()] = 26;
                iArr[Feature.IapLogging.ordinal()] = 27;
                iArr[Feature.IapLoggingLib2.ordinal()] = 28;
                iArr[Feature.IapLoggingLib5To7.ordinal()] = 29;
                iArr[Feature.AndroidManualImplicitPurchaseDedupe.ordinal()] = 30;
                iArr[Feature.AndroidManualImplicitSubsDedupe.ordinal()] = 31;
                iArr[Feature.AndroidIAPSubscriptionAutoLogging.ordinal()] = 32;
                iArr[Feature.Monitoring.ordinal()] = 33;
                iArr[Feature.Megatron.ordinal()] = 34;
                iArr[Feature.Elora.ordinal()] = 35;
                iArr[Feature.GPSARATriggers.ordinal()] = 36;
                iArr[Feature.GPSPACAProcessing.ordinal()] = 37;
                iArr[Feature.ServiceUpdateCompliance.ordinal()] = 38;
                iArr[Feature.Login.ordinal()] = 39;
                iArr[Feature.ChromeCustomTabsPrefetching.ordinal()] = 40;
                iArr[Feature.IgnoreAppSwitchToLoggedOut.ordinal()] = 41;
                iArr[Feature.BypassAppSwitch.ordinal()] = 42;
                iArr[Feature.Share.ordinal()] = 43;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        Feature(int i5) {
            this.code = i5;
        }

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static Feature[] valuesCustom() {
            Feature[] valuesCustom = values();
            return (Feature[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
        }

        public final Feature getParent() {
            int i5 = this.code;
            return (i5 & Function.USE_VARARGS) > 0 ? INSTANCE.fromInt(i5 & (-256)) : (65280 & i5) > 0 ? INSTANCE.fromInt(i5 & (-65536)) : (16711680 & i5) > 0 ? INSTANCE.fromInt(i5 & (-16777216)) : INSTANCE.fromInt(0);
        }

        public final String toKey() {
            return Intrinsics.stringPlus("FBSDKFeature", this);
        }

        @Override // java.lang.Enum
        public String toString() {
            switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
                case 1:
                    return "CoreKit";
                case 2:
                    return "AppEvents";
                case 3:
                    return "CodelessEvents";
                case 4:
                    return "RestrictiveDataFiltering";
                case 5:
                    return "Instrument";
                case 6:
                    return "CrashReport";
                case 7:
                    return "CrashShield";
                case 8:
                    return "ThreadCheck";
                case 9:
                    return "ErrorReport";
                case 10:
                    return "AnrReport";
                case 11:
                    return "AAM";
                case 12:
                    return "AppEventsCloudbridge";
                case 13:
                    return "PrivacyProtection";
                case 14:
                    return "SuggestedEvents";
                case 15:
                    return "IntelligentIntegrity";
                case 16:
                    return "StdParamEnforcement";
                case 17:
                    return "ProtectedMode";
                case 18:
                    return "BannedParamFiltering";
                case 19:
                    return "MACARuleMatching";
                case 20:
                    return "BlocklistEvents";
                case 21:
                    return "FilterRedactedEvents";
                case 22:
                    return "FilterSensitiveParams";
                case R$styleable.Toolbar_titleMarginBottom /* 23 */:
                    return "ModelRequest";
                case R$styleable.Toolbar_titleMarginEnd /* 24 */:
                    return "EventDeactivation";
                case 25:
                    return "OnDeviceEventProcessing";
                case 26:
                    return "OnDevicePostInstallEventProcessing";
                case 27:
                    return "IAPLogging";
                case 28:
                    return "IAPLoggingLib2";
                case R$styleable.Toolbar_titleTextColor /* 29 */:
                    return "IAPLoggingLib5To7";
                case 30:
                    return "AndroidManualImplicitPurchaseDedupe";
                case 31:
                    return "AndroidManualImplicitSubsDedupe";
                case 32:
                    return "AndroidIAPSubscriptionAutoLogging";
                case 33:
                    return "Monitoring";
                case 34:
                    return "Megatron";
                case 35:
                    return "Elora";
                case 36:
                    return "GPSARATriggers";
                case 37:
                    return "GPSPACAProcessing";
                case 38:
                    return "ServiceUpdateCompliance";
                case 39:
                    return "LoginKit";
                case 40:
                    return "ChromeCustomTabsPrefetching";
                case 41:
                    return "IgnoreAppSwitchToLoggedOut";
                case 42:
                    return "BypassAppSwitch";
                case 43:
                    return "ShareKit";
                default:
                    return "unknown";
            }
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Feature.valuesCustom().length];
            iArr[Feature.RestrictiveDataFiltering.ordinal()] = 1;
            iArr[Feature.Instrument.ordinal()] = 2;
            iArr[Feature.CrashReport.ordinal()] = 3;
            iArr[Feature.CrashShield.ordinal()] = 4;
            iArr[Feature.ThreadCheck.ordinal()] = 5;
            iArr[Feature.ErrorReport.ordinal()] = 6;
            iArr[Feature.AnrReport.ordinal()] = 7;
            iArr[Feature.AAM.ordinal()] = 8;
            iArr[Feature.CloudBridge.ordinal()] = 9;
            iArr[Feature.PrivacyProtection.ordinal()] = 10;
            iArr[Feature.SuggestedEvents.ordinal()] = 11;
            iArr[Feature.IntelligentIntegrity.ordinal()] = 12;
            iArr[Feature.ModelRequest.ordinal()] = 13;
            iArr[Feature.EventDeactivation.ordinal()] = 14;
            iArr[Feature.OnDeviceEventProcessing.ordinal()] = 15;
            iArr[Feature.OnDevicePostInstallEventProcessing.ordinal()] = 16;
            iArr[Feature.IapLogging.ordinal()] = 17;
            iArr[Feature.IapLoggingLib2.ordinal()] = 18;
            iArr[Feature.IapLoggingLib5To7.ordinal()] = 19;
            iArr[Feature.AndroidManualImplicitPurchaseDedupe.ordinal()] = 20;
            iArr[Feature.AndroidManualImplicitSubsDedupe.ordinal()] = 21;
            iArr[Feature.AndroidIAPSubscriptionAutoLogging.ordinal()] = 22;
            iArr[Feature.BannedParamFiltering.ordinal()] = 23;
            iArr[Feature.ProtectedMode.ordinal()] = 24;
            iArr[Feature.StdParamEnforcement.ordinal()] = 25;
            iArr[Feature.MACARuleMatching.ordinal()] = 26;
            iArr[Feature.BlocklistEvents.ordinal()] = 27;
            iArr[Feature.FilterRedactedEvents.ordinal()] = 28;
            iArr[Feature.FilterSensitiveParams.ordinal()] = 29;
            iArr[Feature.ChromeCustomTabsPrefetching.ordinal()] = 30;
            iArr[Feature.Monitoring.ordinal()] = 31;
            iArr[Feature.IgnoreAppSwitchToLoggedOut.ordinal()] = 32;
            iArr[Feature.BypassAppSwitch.ordinal()] = 33;
            iArr[Feature.GPSARATriggers.ordinal()] = 34;
            iArr[Feature.GPSPACAProcessing.ordinal()] = 35;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private FeatureManager() {
    }

    public static final void checkFeature(final Feature feature, final Callback callback) {
        Intrinsics.checkNotNullParameter(feature, "feature");
        Intrinsics.checkNotNullParameter(callback, "callback");
        FetchedAppGateKeepersManager fetchedAppGateKeepersManager = FetchedAppGateKeepersManager.INSTANCE;
        FetchedAppGateKeepersManager.loadAppGateKeepersAsync(new FetchedAppGateKeepersManager.Callback() { // from class: com.facebook.internal.FeatureManager$checkFeature$1
            @Override // com.facebook.internal.FetchedAppGateKeepersManager.Callback
            public void onCompleted() {
                FeatureManager.Callback callback2 = FeatureManager.Callback.this;
                FeatureManager featureManager = FeatureManager.INSTANCE;
                callback2.onCompleted(FeatureManager.isEnabled(feature));
            }
        });
    }

    private final boolean defaultStatus(Feature feature) {
        switch (WhenMappings.$EnumSwitchMapping$0[feature.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case R$styleable.Toolbar_titleMarginBottom /* 23 */:
            case R$styleable.Toolbar_titleMarginEnd /* 24 */:
            case 25:
            case 26:
            case 27:
            case 28:
            case R$styleable.Toolbar_titleTextColor /* 29 */:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
                return false;
            default:
                return true;
        }
    }

    public static final void disableFeature(Feature feature) {
        Intrinsics.checkNotNullParameter(feature, "feature");
        FacebookSdk.getApplicationContext().getSharedPreferences(FEATURE_MANAGER_STORE, 0).edit().putString(feature.toKey(), FacebookSdk.getSdkVersion()).apply();
    }

    public static final Feature getFeature(String className) {
        Intrinsics.checkNotNullParameter(className, "className");
        INSTANCE.initializeFeatureMapping();
        for (Map.Entry<Feature, String[]> entry : featureMapping.entrySet()) {
            Feature key = entry.getKey();
            String[] value = entry.getValue();
            int length = value.length;
            int i5 = 0;
            while (i5 < length) {
                String str = value[i5];
                i5++;
                if (StringsKt.startsWith$default(className, str, false, 2, (Object) null)) {
                    return key;
                }
            }
        }
        return Feature.Unknown;
    }

    private final boolean getGKStatus(Feature feature) {
        boolean defaultStatus = defaultStatus(feature);
        FetchedAppGateKeepersManager fetchedAppGateKeepersManager = FetchedAppGateKeepersManager.INSTANCE;
        return FetchedAppGateKeepersManager.getGateKeeperForKey(feature.toKey(), FacebookSdk.getApplicationId(), defaultStatus);
    }

    private final synchronized void initializeFeatureMapping() {
        Map<Feature, String[]> map = featureMapping;
        if (map.isEmpty()) {
            map.put(Feature.AAM, new String[]{"com.facebook.appevents.aam."});
            map.put(Feature.CodelessEvents, new String[]{"com.facebook.appevents.codeless."});
            map.put(Feature.CloudBridge, new String[]{"com.facebook.appevents.cloudbridge."});
            map.put(Feature.ErrorReport, new String[]{"com.facebook.internal.instrument.errorreport."});
            map.put(Feature.AnrReport, new String[]{"com.facebook.internal.instrument.anrreport."});
            map.put(Feature.PrivacyProtection, new String[]{"com.facebook.appevents.ml."});
            map.put(Feature.SuggestedEvents, new String[]{"com.facebook.appevents.suggestedevents."});
            map.put(Feature.RestrictiveDataFiltering, new String[]{"com.facebook.appevents.restrictivedatafilter.RestrictiveDataManager"});
            map.put(Feature.IntelligentIntegrity, new String[]{"com.facebook.appevents.integrity.IntegrityManager"});
            map.put(Feature.ProtectedMode, new String[]{"com.facebook.appevents.integrity.ProtectedModeManager"});
            map.put(Feature.MACARuleMatching, new String[]{"com.facebook.appevents.integrity.MACARuleMatchingManager"});
            map.put(Feature.BlocklistEvents, new String[]{"com.facebook.appevents.integrity.BlocklistEventsManager"});
            map.put(Feature.FilterRedactedEvents, new String[]{"com.facebook.appevents.integrity.RedactedEventsManager"});
            map.put(Feature.FilterSensitiveParams, new String[]{"com.facebook.appevents.integrity.SensitiveParamsManager"});
            map.put(Feature.EventDeactivation, new String[]{"com.facebook.appevents.eventdeactivation."});
            map.put(Feature.OnDeviceEventProcessing, new String[]{"com.facebook.appevents.ondeviceprocessing."});
            map.put(Feature.IapLogging, new String[]{"com.facebook.appevents.iap."});
            map.put(Feature.Monitoring, new String[]{"com.facebook.internal.logging.monitor"});
            map.put(Feature.GPSARATriggers, new String[]{"com.facebook.appevents.gps.ara.GpsARAManager"});
            map.put(Feature.GPSPACAProcessing, new String[]{"com.facebook.appevents.gps.pa.PACustomAudienceClient"});
        }
    }

    public static final boolean isEnabled(Feature feature) {
        Intrinsics.checkNotNullParameter(feature, "feature");
        if (Feature.Unknown == feature) {
            return false;
        }
        if (Feature.Core == feature) {
            return true;
        }
        String string = FacebookSdk.getApplicationContext().getSharedPreferences(FEATURE_MANAGER_STORE, 0).getString(feature.toKey(), null);
        if (string != null && Intrinsics.areEqual(string, FacebookSdk.getSdkVersion())) {
            return false;
        }
        Feature parent = feature.getParent();
        return parent == feature ? INSTANCE.getGKStatus(feature) : isEnabled(parent) && INSTANCE.getGKStatus(feature);
    }
}
