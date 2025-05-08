package com.facebook.internal;

import android.net.Uri;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b7\u0018\u0000 a2\u00020\u0001:\u0002abB\u008f\u0003\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u001e\u0010\u000e\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\r0\f0\f\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0004\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0016\u0012\u0014\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0002\u0018\u00010\f\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010#\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0016\u0012\u000e\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010&\u0012\u000e\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010&\u0012 \u0010*\u001a\u001c\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040&0)\u0018\u00010&\u0012 \u0010+\u001a\u001c\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040&0)\u0018\u00010&\u0012\b\u0010-\u001a\u0004\u0018\u00010,¢\u0006\u0004\b.\u0010/J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u00100R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u00101R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u00102\u001a\u0004\b3\u00104R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u00101\u001a\u0004\b5\u00100R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u00106\u001a\u0004\b7\u00108R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006¢\u0006\f\n\u0004\b\u000b\u00109\u001a\u0004\b:\u0010;R/\u0010\u000e\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\r0\f0\f8\u0006¢\u0006\f\n\u0004\b\u000e\u0010<\u001a\u0004\b=\u0010>R\u0017\u0010\u000f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u00101\u001a\u0004\b?\u00100R\u0017\u0010\u0011\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010@\u001a\u0004\bA\u0010BR\u0017\u0010\u0012\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0012\u00102\u001a\u0004\bC\u00104R\u0017\u0010\u0013\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0013\u00102\u001a\u0004\bD\u00104R\u0017\u0010\u0014\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u00101\u001a\u0004\bE\u00100R\u0017\u0010\u0015\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u00101\u001a\u0004\bF\u00100R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006¢\u0006\f\n\u0004\b\u0017\u0010G\u001a\u0004\bH\u0010IR\u0017\u0010\u0018\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0018\u00102\u001a\u0004\bJ\u00104R\u0017\u0010\u0019\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0019\u00101\u001a\u0004\bK\u00100R\u0017\u0010\u001a\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001a\u00101\u001a\u0004\bL\u00100R\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u001b\u00102\u001a\u0004\bM\u00104R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u001c\u00102\u001a\u0004\bN\u00104R\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u001d\u00102\u001a\u0004\bO\u00104R\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u00168\u0006¢\u0006\f\n\u0004\b\u001e\u0010G\u001a\u0004\bP\u0010IR\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u00168\u0006¢\u0006\f\n\u0004\b\u001f\u0010G\u001a\u0004\bQ\u0010IR%\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0002\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b \u0010<\u001a\u0004\bR\u0010>R\u0019\u0010!\u001a\u0004\u0018\u00010\u00168\u0006¢\u0006\f\n\u0004\b!\u0010G\u001a\u0004\bS\u0010IR\u0019\u0010\"\u001a\u0004\u0018\u00010\u00168\u0006¢\u0006\f\n\u0004\b\"\u0010G\u001a\u0004\bT\u0010IR\u0019\u0010#\u001a\u0004\u0018\u00010\u00168\u0006¢\u0006\f\n\u0004\b#\u0010G\u001a\u0004\bU\u0010IR\u0019\u0010$\u001a\u0004\u0018\u00010\u00168\u0006¢\u0006\f\n\u0004\b$\u0010G\u001a\u0004\bV\u0010IR\u0019\u0010%\u001a\u0004\u0018\u00010\u00168\u0006¢\u0006\f\n\u0004\b%\u0010G\u001a\u0004\bW\u0010IR\u001f\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010&8\u0006¢\u0006\f\n\u0004\b'\u0010X\u001a\u0004\bY\u0010ZR\u001f\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010&8\u0006¢\u0006\f\n\u0004\b(\u0010X\u001a\u0004\b[\u0010ZR1\u0010*\u001a\u001c\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040&0)\u0018\u00010&8\u0006¢\u0006\f\n\u0004\b*\u0010X\u001a\u0004\b\\\u0010ZR1\u0010+\u001a\u001c\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040&0)\u0018\u00010&8\u0006¢\u0006\f\n\u0004\b+\u0010X\u001a\u0004\b]\u0010ZR\u0019\u0010-\u001a\u0004\u0018\u00010,8\u0006¢\u0006\f\n\u0004\b-\u0010^\u001a\u0004\b_\u0010`¨\u0006c"}, d2 = {"Lcom/facebook/internal/FetchedAppSettings;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "supportsImplicitLogging", BuildConfig.FLAVOR, "nuxContent", "nuxEnabled", BuildConfig.FLAVOR, "sessionTimeoutInSeconds", "Ljava/util/EnumSet;", "Lcom/facebook/internal/SmartLoginOption;", "smartLoginOptions", BuildConfig.FLAVOR, "Lcom/facebook/internal/FetchedAppSettings$DialogFeatureConfig;", "dialogConfigurations", "automaticLoggingEnabled", "Lcom/facebook/internal/FacebookRequestErrorClassification;", "errorClassification", "smartLoginBookmarkIconURL", "smartLoginMenuIconURL", "iAPAutomaticLoggingEnabled", "codelessEventsEnabled", "Lorg/json/JSONArray;", "eventBindings", "sdkUpdateMessage", "trackUninstallEnabled", "monitorViaDialogEnabled", "rawAamRules", "suggestedEventsSetting", "restrictiveDataSetting", "protectedModeStandardParamsSetting", "MACARuleMatchingSetting", "migratedAutoLogValues", "blocklistEvents", "redactedEvents", "sensitiveParams", "schemaRestrictions", "bannedParams", BuildConfig.FLAVOR, "currencyDedupeParameters", "purchaseValueDedupeParameters", "Lkotlin/Pair;", "prodDedupeParameters", "testDedupeParameters", BuildConfig.FLAVOR, "dedupeWindow", "<init>", "(ZLjava/lang/String;ZILjava/util/EnumSet;Ljava/util/Map;ZLcom/facebook/internal/FacebookRequestErrorClassification;Ljava/lang/String;Ljava/lang/String;ZZLorg/json/JSONArray;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONArray;Lorg/json/JSONArray;Ljava/util/Map;Lorg/json/JSONArray;Lorg/json/JSONArray;Lorg/json/JSONArray;Lorg/json/JSONArray;Lorg/json/JSONArray;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Long;)V", "()Z", "Z", "Ljava/lang/String;", "getNuxContent", "()Ljava/lang/String;", "getNuxEnabled", "I", "getSessionTimeoutInSeconds", "()I", "Ljava/util/EnumSet;", "getSmartLoginOptions", "()Ljava/util/EnumSet;", "Ljava/util/Map;", "getDialogConfigurations", "()Ljava/util/Map;", "getAutomaticLoggingEnabled", "Lcom/facebook/internal/FacebookRequestErrorClassification;", "getErrorClassification", "()Lcom/facebook/internal/FacebookRequestErrorClassification;", "getSmartLoginBookmarkIconURL", "getSmartLoginMenuIconURL", "getIAPAutomaticLoggingEnabled", "getCodelessEventsEnabled", "Lorg/json/JSONArray;", "getEventBindings", "()Lorg/json/JSONArray;", "getSdkUpdateMessage", "getTrackUninstallEnabled", "getMonitorViaDialogEnabled", "getRawAamRules", "getSuggestedEventsSetting", "getRestrictiveDataSetting", "getProtectedModeStandardParamsSetting", "getMACARuleMatchingSetting", "getMigratedAutoLogValues", "getBlocklistEvents", "getRedactedEvents", "getSensitiveParams", "getSchemaRestrictions", "getBannedParams", "Ljava/util/List;", "getCurrencyDedupeParameters", "()Ljava/util/List;", "getPurchaseValueDedupeParameters", "getProdDedupeParameters", "getTestDedupeParameters", "Ljava/lang/Long;", "getDedupeWindow", "()Ljava/lang/Long;", "Companion", "DialogFeatureConfig", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class FetchedAppSettings {
    private final JSONArray MACARuleMatchingSetting;
    private final boolean automaticLoggingEnabled;
    private final JSONArray bannedParams;
    private final JSONArray blocklistEvents;
    private final boolean codelessEventsEnabled;
    private final List<String> currencyDedupeParameters;
    private final Long dedupeWindow;
    private final Map<String, Map<String, DialogFeatureConfig>> dialogConfigurations;
    private final FacebookRequestErrorClassification errorClassification;
    private final JSONArray eventBindings;
    private final boolean iAPAutomaticLoggingEnabled;
    private final Map<String, Boolean> migratedAutoLogValues;
    private final boolean monitorViaDialogEnabled;
    private final String nuxContent;
    private final boolean nuxEnabled;
    private final List<Pair<String, List<String>>> prodDedupeParameters;
    private final JSONArray protectedModeStandardParamsSetting;
    private final List<String> purchaseValueDedupeParameters;
    private final String rawAamRules;
    private final JSONArray redactedEvents;
    private final String restrictiveDataSetting;
    private final JSONArray schemaRestrictions;
    private final String sdkUpdateMessage;
    private final JSONArray sensitiveParams;
    private final int sessionTimeoutInSeconds;
    private final String smartLoginBookmarkIconURL;
    private final String smartLoginMenuIconURL;
    private final EnumSet<SmartLoginOption> smartLoginOptions;
    private final String suggestedEventsSetting;
    private final boolean supportsImplicitLogging;
    private final List<Pair<String, List<String>>> testDedupeParameters;
    private final boolean trackUninstallEnabled;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u000f\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B-\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u000b\u001a\u0004\b\u000e\u0010\rR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/facebook/internal/FetchedAppSettings$DialogFeatureConfig;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "dialogName", "featureName", "Landroid/net/Uri;", "fallbackUrl", BuildConfig.FLAVOR, "versionSpec", "<init>", "(Ljava/lang/String;Ljava/lang/String;Landroid/net/Uri;[I)V", "Ljava/lang/String;", "getDialogName", "()Ljava/lang/String;", "getFeatureName", "Landroid/net/Uri;", "getFallbackUrl", "()Landroid/net/Uri;", "[I", "getVersionSpec", "()[I", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes.dex */
    public static final class DialogFeatureConfig {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final String DIALOG_CONFIG_DIALOG_NAME_FEATURE_NAME_SEPARATOR = "|";
        private static final String DIALOG_CONFIG_NAME_KEY = "name";
        private static final String DIALOG_CONFIG_URL_KEY = "url";
        private static final String DIALOG_CONFIG_VERSIONS_KEY = "versions";
        private final String dialogName;
        private final Uri fallbackUrl;
        private final String featureName;
        private final int[] versionSpec;

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0014\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/facebook/internal/FetchedAppSettings$DialogFeatureConfig$Companion;", BuildConfig.FLAVOR, "()V", "DIALOG_CONFIG_DIALOG_NAME_FEATURE_NAME_SEPARATOR", BuildConfig.FLAVOR, "DIALOG_CONFIG_NAME_KEY", "DIALOG_CONFIG_URL_KEY", "DIALOG_CONFIG_VERSIONS_KEY", "parseDialogConfig", "Lcom/facebook/internal/FetchedAppSettings$DialogFeatureConfig;", "dialogConfigJSON", "Lorg/json/JSONObject;", "parseVersionSpec", BuildConfig.FLAVOR, "versionsJSON", "Lorg/json/JSONArray;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        /* loaded from: classes.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private final int[] parseVersionSpec(JSONArray versionsJSON) {
                if (versionsJSON == null) {
                    return null;
                }
                int length = versionsJSON.length();
                int[] iArr = new int[length];
                if (length <= 0) {
                    return iArr;
                }
                int i5 = 0;
                while (true) {
                    int i6 = i5 + 1;
                    int i7 = -1;
                    int optInt = versionsJSON.optInt(i5, -1);
                    if (optInt == -1) {
                        String versionString = versionsJSON.optString(i5);
                        if (!Utility.isNullOrEmpty(versionString)) {
                            try {
                                Intrinsics.checkNotNullExpressionValue(versionString, "versionString");
                                i7 = Integer.parseInt(versionString);
                            } catch (NumberFormatException e5) {
                                Utility.logd("FacebookSDK", e5);
                            }
                            optInt = i7;
                        }
                    }
                    iArr[i5] = optInt;
                    if (i6 >= length) {
                        return iArr;
                    }
                    i5 = i6;
                }
            }

            public final DialogFeatureConfig parseDialogConfig(JSONObject dialogConfigJSON) {
                Intrinsics.checkNotNullParameter(dialogConfigJSON, "dialogConfigJSON");
                String dialogNameWithFeature = dialogConfigJSON.optString(DialogFeatureConfig.DIALOG_CONFIG_NAME_KEY);
                if (Utility.isNullOrEmpty(dialogNameWithFeature)) {
                    return null;
                }
                Intrinsics.checkNotNullExpressionValue(dialogNameWithFeature, "dialogNameWithFeature");
                List split$default = StringsKt.split$default((CharSequence) dialogNameWithFeature, new String[]{DialogFeatureConfig.DIALOG_CONFIG_DIALOG_NAME_FEATURE_NAME_SEPARATOR}, false, 0, 6, (Object) null);
                if (split$default.size() != 2) {
                    return null;
                }
                String str = (String) CollectionsKt.first(split$default);
                String str2 = (String) CollectionsKt.last(split$default);
                if (Utility.isNullOrEmpty(str) || Utility.isNullOrEmpty(str2)) {
                    return null;
                }
                String optString = dialogConfigJSON.optString(DialogFeatureConfig.DIALOG_CONFIG_URL_KEY);
                return new DialogFeatureConfig(str, str2, Utility.isNullOrEmpty(optString) ? null : Uri.parse(optString), parseVersionSpec(dialogConfigJSON.optJSONArray(DialogFeatureConfig.DIALOG_CONFIG_VERSIONS_KEY)), null);
            }

            private Companion() {
            }
        }

        public /* synthetic */ DialogFeatureConfig(String str, String str2, Uri uri, int[] iArr, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, uri, iArr);
        }

        public final String getDialogName() {
            return this.dialogName;
        }

        public final String getFeatureName() {
            return this.featureName;
        }

        private DialogFeatureConfig(String str, String str2, Uri uri, int[] iArr) {
            this.dialogName = str;
            this.featureName = str2;
            this.fallbackUrl = uri;
            this.versionSpec = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FetchedAppSettings(boolean z5, String nuxContent, boolean z6, int i5, EnumSet<SmartLoginOption> smartLoginOptions, Map<String, ? extends Map<String, DialogFeatureConfig>> dialogConfigurations, boolean z7, FacebookRequestErrorClassification errorClassification, String smartLoginBookmarkIconURL, String smartLoginMenuIconURL, boolean z8, boolean z9, JSONArray jSONArray, String sdkUpdateMessage, boolean z10, boolean z11, String str, String str2, String str3, JSONArray jSONArray2, JSONArray jSONArray3, Map<String, Boolean> map, JSONArray jSONArray4, JSONArray jSONArray5, JSONArray jSONArray6, JSONArray jSONArray7, JSONArray jSONArray8, List<String> list, List<String> list2, List<? extends Pair<String, ? extends List<String>>> list3, List<? extends Pair<String, ? extends List<String>>> list4, Long l5) {
        Intrinsics.checkNotNullParameter(nuxContent, "nuxContent");
        Intrinsics.checkNotNullParameter(smartLoginOptions, "smartLoginOptions");
        Intrinsics.checkNotNullParameter(dialogConfigurations, "dialogConfigurations");
        Intrinsics.checkNotNullParameter(errorClassification, "errorClassification");
        Intrinsics.checkNotNullParameter(smartLoginBookmarkIconURL, "smartLoginBookmarkIconURL");
        Intrinsics.checkNotNullParameter(smartLoginMenuIconURL, "smartLoginMenuIconURL");
        Intrinsics.checkNotNullParameter(sdkUpdateMessage, "sdkUpdateMessage");
        this.supportsImplicitLogging = z5;
        this.nuxContent = nuxContent;
        this.nuxEnabled = z6;
        this.sessionTimeoutInSeconds = i5;
        this.smartLoginOptions = smartLoginOptions;
        this.dialogConfigurations = dialogConfigurations;
        this.automaticLoggingEnabled = z7;
        this.errorClassification = errorClassification;
        this.smartLoginBookmarkIconURL = smartLoginBookmarkIconURL;
        this.smartLoginMenuIconURL = smartLoginMenuIconURL;
        this.iAPAutomaticLoggingEnabled = z8;
        this.codelessEventsEnabled = z9;
        this.eventBindings = jSONArray;
        this.sdkUpdateMessage = sdkUpdateMessage;
        this.trackUninstallEnabled = z10;
        this.monitorViaDialogEnabled = z11;
        this.rawAamRules = str;
        this.suggestedEventsSetting = str2;
        this.restrictiveDataSetting = str3;
        this.protectedModeStandardParamsSetting = jSONArray2;
        this.MACARuleMatchingSetting = jSONArray3;
        this.migratedAutoLogValues = map;
        this.blocklistEvents = jSONArray4;
        this.redactedEvents = jSONArray5;
        this.sensitiveParams = jSONArray6;
        this.schemaRestrictions = jSONArray7;
        this.bannedParams = jSONArray8;
        this.currencyDedupeParameters = list;
        this.purchaseValueDedupeParameters = list2;
        this.prodDedupeParameters = list3;
        this.testDedupeParameters = list4;
        this.dedupeWindow = l5;
    }

    public final boolean getAutomaticLoggingEnabled() {
        return this.automaticLoggingEnabled;
    }

    public final JSONArray getBannedParams() {
        return this.bannedParams;
    }

    public final JSONArray getBlocklistEvents() {
        return this.blocklistEvents;
    }

    public final boolean getCodelessEventsEnabled() {
        return this.codelessEventsEnabled;
    }

    public final List<String> getCurrencyDedupeParameters() {
        return this.currencyDedupeParameters;
    }

    public final Long getDedupeWindow() {
        return this.dedupeWindow;
    }

    public final FacebookRequestErrorClassification getErrorClassification() {
        return this.errorClassification;
    }

    public final JSONArray getEventBindings() {
        return this.eventBindings;
    }

    public final boolean getIAPAutomaticLoggingEnabled() {
        return this.iAPAutomaticLoggingEnabled;
    }

    public final JSONArray getMACARuleMatchingSetting() {
        return this.MACARuleMatchingSetting;
    }

    public final List<Pair<String, List<String>>> getProdDedupeParameters() {
        return this.prodDedupeParameters;
    }

    public final JSONArray getProtectedModeStandardParamsSetting() {
        return this.protectedModeStandardParamsSetting;
    }

    public final List<String> getPurchaseValueDedupeParameters() {
        return this.purchaseValueDedupeParameters;
    }

    public final String getRawAamRules() {
        return this.rawAamRules;
    }

    public final JSONArray getRedactedEvents() {
        return this.redactedEvents;
    }

    public final String getRestrictiveDataSetting() {
        return this.restrictiveDataSetting;
    }

    public final JSONArray getSchemaRestrictions() {
        return this.schemaRestrictions;
    }

    public final String getSdkUpdateMessage() {
        return this.sdkUpdateMessage;
    }

    public final JSONArray getSensitiveParams() {
        return this.sensitiveParams;
    }

    public final int getSessionTimeoutInSeconds() {
        return this.sessionTimeoutInSeconds;
    }

    public final EnumSet<SmartLoginOption> getSmartLoginOptions() {
        return this.smartLoginOptions;
    }

    public final String getSuggestedEventsSetting() {
        return this.suggestedEventsSetting;
    }

    public final List<Pair<String, List<String>>> getTestDedupeParameters() {
        return this.testDedupeParameters;
    }

    /* renamed from: supportsImplicitLogging, reason: from getter */
    public final boolean getSupportsImplicitLogging() {
        return this.supportsImplicitLogging;
    }
}
