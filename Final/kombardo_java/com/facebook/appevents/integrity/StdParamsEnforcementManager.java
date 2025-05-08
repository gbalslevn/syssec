package com.facebook.appevents.integrity;

import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.conscrypt.BuildConfig;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u0019\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ)\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\r2\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0016H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ'\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\r2\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0016H\u0002¢\u0006\u0004\b\u001c\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR2\u0010 \u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e0\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R2\u0010\"\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e0\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010!¨\u0006#"}, d2 = {"Lcom/facebook/appevents/integrity/StdParamsEnforcementManager;", BuildConfig.FLAVOR, "<init>", "()V", BuildConfig.FLAVOR, "enable", "loadConfigs", "Lorg/json/JSONArray;", "schema", "configureSchemaRestrictions", "(Lorg/json/JSONArray;)V", "paramValues", "Ljava/util/HashSet;", BuildConfig.FLAVOR, "Lkotlin/collections/HashSet;", "loadSet", "(Lorg/json/JSONArray;)Ljava/util/HashSet;", "Landroid/os/Bundle;", "parameters", "processFilterParamSchemaBlocking", "(Landroid/os/Bundle;)V", "value", BuildConfig.FLAVOR, "expressions", BuildConfig.FLAVOR, "isAnyRegexMatched", "(Ljava/lang/String;Ljava/util/Set;)Z", "enumValues", "isAnyEnumMatched", "enabled", "Z", BuildConfig.FLAVOR, "regexRestrictionsConfig", "Ljava/util/Map;", "enumRestrictionsConfig", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class StdParamsEnforcementManager {
    private static boolean enabled;
    public static final StdParamsEnforcementManager INSTANCE = new StdParamsEnforcementManager();
    private static Map<String, HashSet<String>> regexRestrictionsConfig = new HashMap();
    private static Map<String, HashSet<String>> enumRestrictionsConfig = new HashMap();

    private StdParamsEnforcementManager() {
    }

    private final void configureSchemaRestrictions(JSONArray schema) {
        int length;
        if (CrashShieldHandler.isObjectCrashing(this) || schema == null) {
            return;
        }
        try {
            if (enabled || (length = schema.length()) <= 0) {
                return;
            }
            int i5 = 0;
            while (true) {
                int i6 = i5 + 1;
                JSONObject jSONObject = schema.getJSONObject(i5);
                String key = jSONObject.getString("key");
                if (key != null && key.length() != 0) {
                    try {
                        JSONArray jSONArray = jSONObject.getJSONArray("value");
                        int length2 = jSONArray.length();
                        if (length2 > 0) {
                            int i7 = 0;
                            while (true) {
                                int i8 = i7 + 1;
                                boolean z5 = jSONArray.getJSONObject(i7).getBoolean("require_exact_match");
                                HashSet<String> loadSet = loadSet(jSONArray.getJSONObject(i7).getJSONArray("potential_matches"));
                                if (z5) {
                                    Map<String, HashSet<String>> map = enumRestrictionsConfig;
                                    Intrinsics.checkNotNullExpressionValue(key, "key");
                                    HashSet<String> hashSet = enumRestrictionsConfig.get(key);
                                    if (hashSet != null) {
                                        hashSet.addAll(loadSet);
                                        loadSet = hashSet;
                                    }
                                    map.put(key, loadSet);
                                } else {
                                    Map<String, HashSet<String>> map2 = regexRestrictionsConfig;
                                    Intrinsics.checkNotNullExpressionValue(key, "key");
                                    HashSet<String> hashSet2 = regexRestrictionsConfig.get(key);
                                    if (hashSet2 != null) {
                                        hashSet2.addAll(loadSet);
                                        loadSet = hashSet2;
                                    }
                                    map2.put(key, loadSet);
                                }
                                if (i8 >= length2) {
                                    break;
                                } else {
                                    i7 = i8;
                                }
                            }
                        }
                    } catch (Exception unused) {
                        enumRestrictionsConfig.remove(key);
                        regexRestrictionsConfig.remove(key);
                    }
                }
                if (i6 >= length) {
                    return;
                } else {
                    i5 = i6;
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public static final void enable() {
        boolean z5;
        if (CrashShieldHandler.isObjectCrashing(StdParamsEnforcementManager.class)) {
            return;
        }
        try {
            if (enabled) {
                return;
            }
            INSTANCE.loadConfigs();
            if (regexRestrictionsConfig.isEmpty() && enumRestrictionsConfig.isEmpty()) {
                z5 = false;
                enabled = z5;
            }
            z5 = true;
            enabled = z5;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, StdParamsEnforcementManager.class);
        }
    }

    private final boolean isAnyEnumMatched(String value, Set<String> enumValues) {
        if (CrashShieldHandler.isObjectCrashing(this) || enumValues == null) {
            return false;
        }
        try {
            Set<String> set = enumValues;
            if ((set instanceof Collection) && set.isEmpty()) {
                return false;
            }
            for (String str : set) {
                if (str == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                Locale locale = Locale.ROOT;
                String lowerCase = str.toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
                if (value == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                String lowerCase2 = value.toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
                if (Intrinsics.areEqual(lowerCase, lowerCase2)) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }

    private final boolean isAnyRegexMatched(String value, Set<String> expressions) {
        if (CrashShieldHandler.isObjectCrashing(this) || expressions == null) {
            return false;
        }
        try {
            Set<String> set = expressions;
            if ((set instanceof Collection) && set.isEmpty()) {
                return false;
            }
            Iterator<T> it = set.iterator();
            while (it.hasNext()) {
                if (new Regex((String) it.next()).matches(value)) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }

    private final void loadConfigs() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
            FetchedAppSettings queryAppSettings = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false);
            if (queryAppSettings == null) {
                return;
            }
            configureSchemaRestrictions(queryAppSettings.getSchemaRestrictions());
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private final HashSet<String> loadSet(JSONArray paramValues) {
        HashSet<String> hashSet;
        try {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return null;
            }
            try {
                hashSet = Utility.convertJSONArrayToHashSet(paramValues);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                }
            } catch (Exception unused) {
                hashSet = new HashSet<>();
            }
            return hashSet;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public static final void processFilterParamSchemaBlocking(Bundle parameters) {
        if (CrashShieldHandler.isObjectCrashing(StdParamsEnforcementManager.class)) {
            return;
        }
        try {
            if (enabled && parameters != null) {
                ArrayList arrayList = new ArrayList();
                for (String key : parameters.keySet()) {
                    String valueOf = String.valueOf(parameters.get(key));
                    boolean z5 = regexRestrictionsConfig.get(key) != null;
                    boolean z6 = enumRestrictionsConfig.get(key) != null;
                    if (z5 || z6) {
                        StdParamsEnforcementManager stdParamsEnforcementManager = INSTANCE;
                        boolean isAnyRegexMatched = stdParamsEnforcementManager.isAnyRegexMatched(valueOf, regexRestrictionsConfig.get(key));
                        boolean isAnyEnumMatched = stdParamsEnforcementManager.isAnyEnumMatched(valueOf, enumRestrictionsConfig.get(key));
                        if (!isAnyRegexMatched && !isAnyEnumMatched) {
                            Intrinsics.checkNotNullExpressionValue(key, "key");
                            arrayList.add(key);
                        }
                    }
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    parameters.remove((String) it.next());
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, StdParamsEnforcementManager.class);
        }
    }
}
