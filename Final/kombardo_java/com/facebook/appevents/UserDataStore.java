package com.facebook.appevents;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import android.util.Patterns;
import com.facebook.FacebookSdk;
import com.facebook.appevents.UserDataStore;
import com.facebook.appevents.aam.MetadataRule;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0003J\u001f\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\u0003J#\u0010\u0010\u001a\u00020\u00042\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000eH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0017\u001a\n \u0016*\u0004\u0018\u00010\u00060\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u001b8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010\"\u001a\u00020!8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b$\u0010\u0018R$\u0010&\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R$\u0010(\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010'R$\u0010+\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*¨\u0006,"}, d2 = {"Lcom/facebook/appevents/UserDataStore;", BuildConfig.FLAVOR, "<init>", "()V", BuildConfig.FLAVOR, "initStore", BuildConfig.FLAVOR, "key", "value", "writeDataIntoCache", "(Ljava/lang/String;Ljava/lang/String;)V", "getAllHashedUserData", "()Ljava/lang/String;", "initAndWait", BuildConfig.FLAVOR, "ud", "setInternalUd", "(Ljava/util/Map;)V", "type", "data", "normalizeData", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "kotlin.jvm.PlatformType", "TAG", "Ljava/lang/String;", "USER_DATA_KEY", "INTERNAL_USER_DATA_KEY", "Landroid/content/SharedPreferences;", "sharedPreferences", "Landroid/content/SharedPreferences;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "initialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", BuildConfig.FLAVOR, "MAX_NUM", "I", "DATA_SEPARATOR", "Ljava/util/concurrent/ConcurrentHashMap;", "externalHashedUserData", "Ljava/util/concurrent/ConcurrentHashMap;", "internalHashedUserData", "getEnabledInternalUserData", "()Ljava/util/Map;", "enabledInternalUserData", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class UserDataStore {
    private static final String DATA_SEPARATOR = ",";
    private static final String INTERNAL_USER_DATA_KEY = "com.facebook.appevents.UserDataStore.internalUserData";
    private static final int MAX_NUM = 5;
    private static final String USER_DATA_KEY = "com.facebook.appevents.UserDataStore.userData";
    private static SharedPreferences sharedPreferences;
    public static final UserDataStore INSTANCE = new UserDataStore();
    private static final String TAG = UserDataStore.class.getSimpleName();
    private static final AtomicBoolean initialized = new AtomicBoolean(false);
    private static final ConcurrentHashMap<String, String> externalHashedUserData = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, String> internalHashedUserData = new ConcurrentHashMap<>();

    private UserDataStore() {
    }

    public static final String getAllHashedUserData() {
        if (CrashShieldHandler.isObjectCrashing(UserDataStore.class)) {
            return null;
        }
        try {
            if (!initialized.get()) {
                INSTANCE.initAndWait();
            }
            HashMap hashMap = new HashMap();
            hashMap.putAll(externalHashedUserData);
            hashMap.putAll(INSTANCE.getEnabledInternalUserData());
            return Utility.mapToJsonStr(hashMap);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, UserDataStore.class);
            return null;
        }
    }

    private final Map<String, String> getEnabledInternalUserData() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            HashMap hashMap = new HashMap();
            Set<String> enabledRuleNames = MetadataRule.INSTANCE.getEnabledRuleNames();
            for (String str : internalHashedUserData.keySet()) {
                if (enabledRuleNames.contains(str)) {
                    hashMap.put(str, internalHashedUserData.get(str));
                }
            }
            return hashMap;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private final synchronized void initAndWait() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            AtomicBoolean atomicBoolean = initialized;
            if (atomicBoolean.get()) {
                return;
            }
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext());
            Intrinsics.checkNotNullExpressionValue(defaultSharedPreferences, "getDefaultSharedPreferences(FacebookSdk.getApplicationContext())");
            sharedPreferences = defaultSharedPreferences;
            if (defaultSharedPreferences == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
                throw null;
            }
            String string = defaultSharedPreferences.getString(USER_DATA_KEY, BuildConfig.FLAVOR);
            if (string == null) {
                string = BuildConfig.FLAVOR;
            }
            SharedPreferences sharedPreferences2 = sharedPreferences;
            if (sharedPreferences2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
                throw null;
            }
            String string2 = sharedPreferences2.getString(INTERNAL_USER_DATA_KEY, BuildConfig.FLAVOR);
            if (string2 == null) {
                string2 = BuildConfig.FLAVOR;
            }
            externalHashedUserData.putAll(Utility.jsonStrToMap(string));
            internalHashedUserData.putAll(Utility.jsonStrToMap(string2));
            atomicBoolean.set(true);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public static final void initStore() {
        if (CrashShieldHandler.isObjectCrashing(UserDataStore.class)) {
            return;
        }
        try {
            if (initialized.get()) {
                return;
            }
            INSTANCE.initAndWait();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, UserDataStore.class);
        }
    }

    private final String normalizeData(String type, String data) {
        String str;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            int length = data.length() - 1;
            int i5 = 0;
            boolean z5 = false;
            while (i5 <= length) {
                boolean z6 = Intrinsics.compare((int) data.charAt(!z5 ? i5 : length), 32) <= 0;
                if (z5) {
                    if (!z6) {
                        break;
                    }
                    length--;
                } else if (z6) {
                    i5++;
                } else {
                    z5 = true;
                }
            }
            String obj = data.subSequence(i5, length + 1).toString();
            if (obj == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String lowerCase = obj.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
            if (Intrinsics.areEqual("em", type)) {
                if (Patterns.EMAIL_ADDRESS.matcher(lowerCase).matches()) {
                    return lowerCase;
                }
                Log.e(TAG, "Setting email failure: this is not a valid email address");
                return BuildConfig.FLAVOR;
            }
            if (Intrinsics.areEqual("ph", type)) {
                return new Regex("[^0-9]").replace(lowerCase, BuildConfig.FLAVOR);
            }
            if (!Intrinsics.areEqual("ge", type)) {
                return lowerCase;
            }
            if (lowerCase.length() <= 0) {
                str = BuildConfig.FLAVOR;
            } else {
                if (lowerCase == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                str = lowerCase.substring(0, 1);
                Intrinsics.checkNotNullExpressionValue(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            }
            if (!Intrinsics.areEqual("f", str) && !Intrinsics.areEqual("m", str)) {
                Log.e(TAG, "Setting gender failure: the supported value for gender is f or m");
                return BuildConfig.FLAVOR;
            }
            return str;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x00af, code lost:
    
        r5 = new java.lang.String[0];
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void setInternalUd(Map<String, String> ud) {
        List<String> split;
        if (CrashShieldHandler.isObjectCrashing(UserDataStore.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(ud, "ud");
            if (!initialized.get()) {
                INSTANCE.initAndWait();
            }
            for (Map.Entry<String, String> entry : ud.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                Utility utility = Utility.INSTANCE;
                UserDataStore userDataStore = INSTANCE;
                int length = value.length() - 1;
                int i5 = 0;
                boolean z5 = false;
                while (i5 <= length) {
                    boolean z6 = Intrinsics.compare((int) value.charAt(!z5 ? i5 : length), 32) <= 0;
                    if (z5) {
                        if (!z6) {
                            break;
                        } else {
                            length--;
                        }
                    } else if (z6) {
                        i5++;
                    } else {
                        z5 = true;
                    }
                }
                String sha256hash = Utility.sha256hash(userDataStore.normalizeData(key, value.subSequence(i5, length + 1).toString()));
                ConcurrentHashMap<String, String> concurrentHashMap = internalHashedUserData;
                if (concurrentHashMap.containsKey(key)) {
                    String str = concurrentHashMap.get(key);
                    String[] strArr = null;
                    if (str != null && (split = new Regex(DATA_SEPARATOR).split(str, 0)) != null) {
                        Object[] array = split.toArray(new String[0]);
                        if (array == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                        }
                        strArr = (String[]) array;
                    }
                    Set mutableSetOf = SetsKt.mutableSetOf(Arrays.copyOf(strArr, strArr.length));
                    if (mutableSetOf.contains(sha256hash)) {
                        return;
                    }
                    StringBuilder sb = new StringBuilder();
                    if (strArr.length == 0) {
                        sb.append(sha256hash);
                    } else if (strArr.length < 5) {
                        sb.append(str);
                        sb.append(DATA_SEPARATOR);
                        sb.append(sha256hash);
                    } else {
                        int i6 = 1;
                        while (true) {
                            int i7 = i6 + 1;
                            sb.append(strArr[i6]);
                            sb.append(DATA_SEPARATOR);
                            if (i7 >= 5) {
                                break;
                            } else {
                                i6 = i7;
                            }
                        }
                        sb.append(sha256hash);
                        mutableSetOf.remove(strArr[0]);
                    }
                    internalHashedUserData.put(key, sb.toString());
                } else {
                    concurrentHashMap.put(key, sha256hash);
                }
            }
            UserDataStore userDataStore2 = INSTANCE;
            Utility utility2 = Utility.INSTANCE;
            userDataStore2.writeDataIntoCache(INTERNAL_USER_DATA_KEY, Utility.mapToJsonStr(internalHashedUserData));
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, UserDataStore.class);
        }
    }

    private final void writeDataIntoCache(final String key, final String value) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            FacebookSdk.getExecutor().execute(new Runnable() { // from class: e0.y
                @Override // java.lang.Runnable
                public final void run() {
                    UserDataStore.m2812writeDataIntoCache$lambda0(key, value);
                }
            });
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: writeDataIntoCache$lambda-0, reason: not valid java name */
    public static final void m2812writeDataIntoCache$lambda0(String key, String value) {
        if (CrashShieldHandler.isObjectCrashing(UserDataStore.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(key, "$key");
            Intrinsics.checkNotNullParameter(value, "$value");
            if (!initialized.get()) {
                INSTANCE.initAndWait();
            }
            SharedPreferences sharedPreferences2 = sharedPreferences;
            if (sharedPreferences2 != null) {
                sharedPreferences2.edit().putString(key, value).apply();
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
                throw null;
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, UserDataStore.class);
        }
    }
}
