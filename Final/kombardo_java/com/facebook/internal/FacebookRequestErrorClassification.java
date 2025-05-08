package com.facebook.internal;

import com.facebook.FacebookRequestError;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0081\u0001\b\u0000\u0012\u001c\u0010\u0005\u001a\u0018\u0012\u0004\u0012\u00020\u0003\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0004\u0018\u00010\u0002\u0012\u001c\u0010\u0006\u001a\u0018\u0012\u0004\u0012\u00020\u0003\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0004\u0018\u00010\u0002\u0012\u001c\u0010\u0007\u001a\u0018\u0012\u0004\u0012\u00020\u0003\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0010\u001a\u0004\u0018\u00010\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0010\u0010\u0011J%\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017R-\u0010\u0005\u001a\u0018\u0012\u0004\u0012\u00020\u0003\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR-\u0010\u0006\u001a\u0018\u0012\u0004\u0012\u00020\u0003\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0018\u001a\u0004\b\u001b\u0010\u001aR-\u0010\u0007\u001a\u0018\u0012\u0004\u0012\u00020\u0003\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0018\u001a\u0004\b\u001c\u0010\u001aR\u0016\u0010\t\u001a\u0004\u0018\u00010\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u001dR\u0016\u0010\n\u001a\u0004\u0018\u00010\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u001dR\u0016\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u001d¨\u0006\u001f"}, d2 = {"Lcom/facebook/internal/FacebookRequestErrorClassification;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, BuildConfig.FLAVOR, BuildConfig.FLAVOR, "otherErrors", "transientErrors", "loginRecoverableErrors", BuildConfig.FLAVOR, "otherRecoveryMessage", "transientRecoveryMessage", "loginRecoverableRecoveryMessage", "<init>", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Lcom/facebook/FacebookRequestError$Category;", "category", "getRecoveryMessage", "(Lcom/facebook/FacebookRequestError$Category;)Ljava/lang/String;", "errorCode", "errorSubCode", BuildConfig.FLAVOR, "isTransient", "classify", "(IIZ)Lcom/facebook/FacebookRequestError$Category;", "Ljava/util/Map;", "getOtherErrors", "()Ljava/util/Map;", "getTransientErrors", "getLoginRecoverableErrors", "Ljava/lang/String;", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class FacebookRequestErrorClassification {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static FacebookRequestErrorClassification defaultInstance;
    private final Map<Integer, Set<Integer>> loginRecoverableErrors;
    private final String loginRecoverableRecoveryMessage;
    private final Map<Integer, Set<Integer>> otherErrors;
    private final String otherRecoveryMessage;
    private final Map<Integer, Set<Integer>> transientErrors;
    private final String transientRecoveryMessage;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\t\u001a\u0018\u0012\u0004\u0012\u00020\u0007\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\b\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\r8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0003\u001a\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001b\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001c\u0010\u0017R\u0014\u0010\u001d\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001d\u0010\u0017R\u0014\u0010\u001e\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001e\u0010\u0017R\u0014\u0010\u001f\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001f\u0010\u0017R\u0014\u0010 \u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b \u0010\u0017R\u0014\u0010\"\u001a\u00020!8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020!8\u0006X\u0086T¢\u0006\u0006\n\u0004\b$\u0010#R\u0014\u0010%\u001a\u00020!8\u0006X\u0086T¢\u0006\u0006\n\u0004\b%\u0010#R\u0014\u0010&\u001a\u00020!8\u0006X\u0086T¢\u0006\u0006\n\u0004\b&\u0010#R\u0014\u0010'\u001a\u00020!8\u0006X\u0086T¢\u0006\u0006\n\u0004\b'\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)¨\u0006*"}, d2 = {"Lcom/facebook/internal/FacebookRequestErrorClassification$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "Lorg/json/JSONObject;", "definition", BuildConfig.FLAVOR, BuildConfig.FLAVOR, BuildConfig.FLAVOR, "parseJSONDefinition", "(Lorg/json/JSONObject;)Ljava/util/Map;", "Lorg/json/JSONArray;", "jsonArray", "Lcom/facebook/internal/FacebookRequestErrorClassification;", "createFromJSON", "(Lorg/json/JSONArray;)Lcom/facebook/internal/FacebookRequestErrorClassification;", "getDefaultErrorClassificationImpl", "()Lcom/facebook/internal/FacebookRequestErrorClassification;", "defaultErrorClassificationImpl", "getDefaultErrorClassification", "getDefaultErrorClassification$annotations", "defaultErrorClassification", "EC_APP_NOT_INSTALLED", "I", "EC_APP_TOO_MANY_CALLS", "EC_INVALID_SESSION", "EC_INVALID_TOKEN", "EC_RATE", "EC_SERVICE_UNAVAILABLE", "EC_TOO_MANY_USER_ACTION_CALLS", "EC_USER_TOO_MANY_CALLS", "ESC_APP_INACTIVE", "ESC_APP_NOT_INSTALLED", BuildConfig.FLAVOR, "KEY_LOGIN_RECOVERABLE", "Ljava/lang/String;", "KEY_NAME", "KEY_OTHER", "KEY_RECOVERY_MESSAGE", "KEY_TRANSIENT", "defaultInstance", "Lcom/facebook/internal/FacebookRequestErrorClassification;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final FacebookRequestErrorClassification getDefaultErrorClassificationImpl() {
            return new FacebookRequestErrorClassification(null, MapsKt.hashMapOf(TuplesKt.to(2, null), TuplesKt.to(4, null), TuplesKt.to(9, null), TuplesKt.to(17, null), TuplesKt.to(341, null)), MapsKt.hashMapOf(TuplesKt.to(102, null), TuplesKt.to(190, null), TuplesKt.to(412, null)), null, null, null);
        }

        private final Map<Integer, Set<Integer>> parseJSONDefinition(JSONObject definition) {
            int optInt;
            HashSet hashSet;
            JSONArray optJSONArray = definition.optJSONArray("items");
            if (optJSONArray == null || optJSONArray.length() == 0) {
                return null;
            }
            HashMap hashMap = new HashMap();
            int length = optJSONArray.length();
            if (length > 0) {
                int i5 = 0;
                while (true) {
                    int i6 = i5 + 1;
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i5);
                    if (optJSONObject != null && (optInt = optJSONObject.optInt("code")) != 0) {
                        JSONArray optJSONArray2 = optJSONObject.optJSONArray("subcodes");
                        if (optJSONArray2 == null || optJSONArray2.length() <= 0) {
                            hashSet = null;
                        } else {
                            hashSet = new HashSet();
                            int length2 = optJSONArray2.length();
                            if (length2 > 0) {
                                int i7 = 0;
                                while (true) {
                                    int i8 = i7 + 1;
                                    int optInt2 = optJSONArray2.optInt(i7);
                                    if (optInt2 != 0) {
                                        hashSet.add(Integer.valueOf(optInt2));
                                    }
                                    if (i8 >= length2) {
                                        break;
                                    }
                                    i7 = i8;
                                }
                            }
                        }
                        hashMap.put(Integer.valueOf(optInt), hashSet);
                    }
                    if (i6 >= length) {
                        break;
                    }
                    i5 = i6;
                }
            }
            return hashMap;
        }

        public final FacebookRequestErrorClassification createFromJSON(JSONArray jsonArray) {
            Map<Integer, Set<Integer>> map;
            Map<Integer, Set<Integer>> map2;
            Map<Integer, Set<Integer>> map3;
            String str;
            String str2;
            String str3;
            String optString;
            if (jsonArray == null) {
                return null;
            }
            int length = jsonArray.length();
            if (length > 0) {
                int i5 = 0;
                Map<Integer, Set<Integer>> map4 = null;
                Map<Integer, Set<Integer>> map5 = null;
                Map<Integer, Set<Integer>> map6 = null;
                String str4 = null;
                String str5 = null;
                String str6 = null;
                while (true) {
                    int i6 = i5 + 1;
                    JSONObject optJSONObject = jsonArray.optJSONObject(i5);
                    if (optJSONObject != null && (optString = optJSONObject.optString("name")) != null) {
                        if (StringsKt.equals(optString, "other", true)) {
                            str4 = optJSONObject.optString("recovery_message", null);
                            map4 = parseJSONDefinition(optJSONObject);
                        } else if (StringsKt.equals(optString, "transient", true)) {
                            str5 = optJSONObject.optString("recovery_message", null);
                            map5 = parseJSONDefinition(optJSONObject);
                        } else if (StringsKt.equals(optString, "login_recoverable", true)) {
                            str6 = optJSONObject.optString("recovery_message", null);
                            map6 = parseJSONDefinition(optJSONObject);
                        }
                    }
                    if (i6 >= length) {
                        break;
                    }
                    i5 = i6;
                }
                map = map4;
                map2 = map5;
                map3 = map6;
                str = str4;
                str2 = str5;
                str3 = str6;
            } else {
                map = null;
                map2 = null;
                map3 = null;
                str = null;
                str2 = null;
                str3 = null;
            }
            return new FacebookRequestErrorClassification(map, map2, map3, str, str2, str3);
        }

        public final synchronized FacebookRequestErrorClassification getDefaultErrorClassification() {
            FacebookRequestErrorClassification facebookRequestErrorClassification;
            try {
                if (FacebookRequestErrorClassification.defaultInstance == null) {
                    FacebookRequestErrorClassification.defaultInstance = getDefaultErrorClassificationImpl();
                }
                facebookRequestErrorClassification = FacebookRequestErrorClassification.defaultInstance;
                if (facebookRequestErrorClassification == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.facebook.internal.FacebookRequestErrorClassification");
                }
            } catch (Throwable th) {
                throw th;
            }
            return facebookRequestErrorClassification;
        }

        private Companion() {
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FacebookRequestError.Category.valuesCustom().length];
            iArr[FacebookRequestError.Category.OTHER.ordinal()] = 1;
            iArr[FacebookRequestError.Category.LOGIN_RECOVERABLE.ordinal()] = 2;
            iArr[FacebookRequestError.Category.TRANSIENT.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FacebookRequestErrorClassification(Map<Integer, ? extends Set<Integer>> map, Map<Integer, ? extends Set<Integer>> map2, Map<Integer, ? extends Set<Integer>> map3, String str, String str2, String str3) {
        this.otherErrors = map;
        this.transientErrors = map2;
        this.loginRecoverableErrors = map3;
        this.otherRecoveryMessage = str;
        this.transientRecoveryMessage = str2;
        this.loginRecoverableRecoveryMessage = str3;
    }

    public final FacebookRequestError.Category classify(int errorCode, int errorSubCode, boolean isTransient) {
        Set<Integer> set;
        Set<Integer> set2;
        Set<Integer> set3;
        if (isTransient) {
            return FacebookRequestError.Category.TRANSIENT;
        }
        Map<Integer, Set<Integer>> map = this.otherErrors;
        if (map != null && map.containsKey(Integer.valueOf(errorCode)) && ((set3 = this.otherErrors.get(Integer.valueOf(errorCode))) == null || set3.contains(Integer.valueOf(errorSubCode)))) {
            return FacebookRequestError.Category.OTHER;
        }
        Map<Integer, Set<Integer>> map2 = this.loginRecoverableErrors;
        if (map2 != null && map2.containsKey(Integer.valueOf(errorCode)) && ((set2 = this.loginRecoverableErrors.get(Integer.valueOf(errorCode))) == null || set2.contains(Integer.valueOf(errorSubCode)))) {
            return FacebookRequestError.Category.LOGIN_RECOVERABLE;
        }
        Map<Integer, Set<Integer>> map3 = this.transientErrors;
        return (map3 != null && map3.containsKey(Integer.valueOf(errorCode)) && ((set = this.transientErrors.get(Integer.valueOf(errorCode))) == null || set.contains(Integer.valueOf(errorSubCode)))) ? FacebookRequestError.Category.TRANSIENT : FacebookRequestError.Category.OTHER;
    }

    public final String getRecoveryMessage(FacebookRequestError.Category category) {
        int i5 = category == null ? -1 : WhenMappings.$EnumSwitchMapping$0[category.ordinal()];
        if (i5 == 1) {
            return this.otherRecoveryMessage;
        }
        if (i5 == 2) {
            return this.loginRecoverableRecoveryMessage;
        }
        if (i5 != 3) {
            return null;
        }
        return this.transientRecoveryMessage;
    }
}
