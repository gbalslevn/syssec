package com.facebook.appevents.suggestedevents;

import android.util.Patterns;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.io.File;
import java.io.FileInputStream;
import java.util.Map;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0006H\u0007J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0019\u001a\u00020\u0012H\u0002J \u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0007J\u0012\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0007J\u0010\u0010!\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u0012H\u0002J\b\u0010#\u001a\u00020\u000fH\u0007J)\u0010$\u001a\u00020\u000f2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00060&2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00060&H\u0002¢\u0006\u0002\u0010(J0\u0010)\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u00122\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0002J\u0010\u0010.\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u0012H\u0002J\u0018\u0010/\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u00122\u0006\u0010*\u001a\u00020+H\u0002J\u0018\u00100\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u00062\u0006\u00102\u001a\u00020\u0006H\u0002J(\u00100\u001a\u00020\u000f2\u0006\u00103\u001a\u00020\u00062\u0006\u00104\u001a\u00020\u00062\u0006\u00105\u001a\u00020\u00062\u0006\u00102\u001a\u00020\u0006H\u0002J\u0018\u00106\u001a\u00020\u001e2\u0006\u00107\u001a\u00020\u00152\u0006\u00108\u001a\u00020\u0015H\u0002J(\u00109\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u00122\n\u0010:\u001a\u00060;j\u0002`<2\n\u0010=\u001a\u00060;j\u0002`<H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\rX\u0082.¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lcom/facebook/appevents/suggestedevents/FeatureExtractor;", BuildConfig.FLAVOR, "()V", "NUM_OF_FEATURES", BuildConfig.FLAVOR, "REGEX_ADD_TO_CART_BUTTON_TEXT", BuildConfig.FLAVOR, "REGEX_ADD_TO_CART_PAGE_TITLE", "REGEX_CR_HAS_CONFIRM_PASSWORD_FIELD", "REGEX_CR_HAS_LOG_IN_KEYWORDS", "REGEX_CR_HAS_SIGN_ON_KEYWORDS", "REGEX_CR_PASSWORD_FIELD", "eventInfo", BuildConfig.FLAVOR, "initialized", BuildConfig.FLAVOR, "languageInfo", "rules", "Lorg/json/JSONObject;", "textTypeInfo", "getDenseFeatures", BuildConfig.FLAVOR, "viewHierarchy", "appName", "getInteractedNode", "view", "getTextFeature", "buttonText", "activityName", "initialize", BuildConfig.FLAVOR, "file", "Ljava/io/File;", "isButton", "node", "isInitialized", "matchIndicators", "indicators", BuildConfig.FLAVOR, "values", "([Ljava/lang/String;[Ljava/lang/String;)Z", "nonparseFeatures", "siblings", "Lorg/json/JSONArray;", "screenName", "formFieldsJSON", "parseFeatures", "pruneTree", "regexMatched", "pattern", "matchText", "language", "event", "textType", "sum", "a", "b", "updateHintAndTextRecursively", "textSB", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "hintSB", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class FeatureExtractor {
    public static final FeatureExtractor INSTANCE = new FeatureExtractor();
    private static final int NUM_OF_FEATURES = 30;
    private static final String REGEX_ADD_TO_CART_BUTTON_TEXT = "(?i)add to(\\s|\\Z)|update(\\s|\\Z)|cart";
    private static final String REGEX_ADD_TO_CART_PAGE_TITLE = "(?i)add to(\\s|\\Z)|update(\\s|\\Z)|cart|shop|buy";
    private static final String REGEX_CR_HAS_CONFIRM_PASSWORD_FIELD = "(?i)(confirm.*password)|(password.*(confirmation|confirm)|confirmation)";
    private static final String REGEX_CR_HAS_LOG_IN_KEYWORDS = "(?i)(sign in)|login|signIn";
    private static final String REGEX_CR_HAS_SIGN_ON_KEYWORDS = "(?i)(sign.*(up|now)|registration|register|(create|apply).*(profile|account)|open.*account|account.*(open|creation|application)|enroll|join.*now)";
    private static final String REGEX_CR_PASSWORD_FIELD = "password";
    private static Map<String, String> eventInfo;
    private static boolean initialized;
    private static Map<String, String> languageInfo;
    private static JSONObject rules;
    private static Map<String, String> textTypeInfo;

    private FeatureExtractor() {
    }

    public static final float[] getDenseFeatures(JSONObject viewHierarchy, String appName) {
        String lowerCase;
        JSONObject jSONObject;
        String screenName;
        JSONArray jSONArray;
        FeatureExtractor featureExtractor;
        JSONObject interactedNode;
        if (CrashShieldHandler.isObjectCrashing(FeatureExtractor.class)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(viewHierarchy, "viewHierarchy");
            Intrinsics.checkNotNullParameter(appName, "appName");
            if (!initialized) {
                return null;
            }
            float[] fArr = new float[NUM_OF_FEATURES];
            for (int i5 = 0; i5 < NUM_OF_FEATURES; i5++) {
                fArr[i5] = 0.0f;
            }
            try {
                lowerCase = appName.toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
                jSONObject = new JSONObject(viewHierarchy.optJSONObject("view").toString());
                screenName = viewHierarchy.optString("screenname");
                jSONArray = new JSONArray();
                featureExtractor = INSTANCE;
                featureExtractor.pruneTree(jSONObject, jSONArray);
                featureExtractor.sum(fArr, featureExtractor.parseFeatures(jSONObject));
                interactedNode = featureExtractor.getInteractedNode(jSONObject);
            } catch (JSONException unused) {
            }
            if (interactedNode == null) {
                return null;
            }
            Intrinsics.checkNotNullExpressionValue(screenName, "screenName");
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "viewTree.toString()");
            featureExtractor.sum(fArr, featureExtractor.nonparseFeatures(interactedNode, jSONArray, screenName, jSONObject2, lowerCase));
            return fArr;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, FeatureExtractor.class);
            return null;
        }
    }

    private final JSONObject getInteractedNode(JSONObject view) {
        int length;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
        } catch (JSONException unused) {
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
        if (view.optBoolean("is_interacted")) {
            return view;
        }
        JSONArray optJSONArray = view.optJSONArray("childviews");
        if (optJSONArray != null && (length = optJSONArray.length()) > 0) {
            int i5 = 0;
            while (true) {
                int i6 = i5 + 1;
                JSONObject jSONObject = optJSONArray.getJSONObject(i5);
                Intrinsics.checkNotNullExpressionValue(jSONObject, "children.getJSONObject(i)");
                JSONObject interactedNode = getInteractedNode(jSONObject);
                if (interactedNode != null) {
                    return interactedNode;
                }
                if (i6 >= length) {
                    break;
                }
                i5 = i6;
            }
        }
        return null;
    }

    public static final String getTextFeature(String buttonText, String activityName, String appName) {
        if (CrashShieldHandler.isObjectCrashing(FeatureExtractor.class)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(buttonText, "buttonText");
            Intrinsics.checkNotNullParameter(activityName, "activityName");
            Intrinsics.checkNotNullParameter(appName, "appName");
            String str = appName + " | " + activityName + ", " + buttonText;
            if (str == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String lowerCase = str.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
            return lowerCase;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, FeatureExtractor.class);
            return null;
        }
    }

    public static final void initialize(File file) {
        if (CrashShieldHandler.isObjectCrashing(FeatureExtractor.class)) {
            return;
        }
        try {
            try {
                rules = new JSONObject();
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] bArr = new byte[fileInputStream.available()];
                fileInputStream.read(bArr);
                fileInputStream.close();
                rules = new JSONObject(new String(bArr, Charsets.UTF_8));
                languageInfo = MapsKt.mapOf(TuplesKt.to("ENGLISH", "1"), TuplesKt.to("GERMAN", "2"), TuplesKt.to("SPANISH", "3"), TuplesKt.to("JAPANESE", "4"));
                eventInfo = MapsKt.mapOf(TuplesKt.to("VIEW_CONTENT", "0"), TuplesKt.to("SEARCH", "1"), TuplesKt.to("ADD_TO_CART", "2"), TuplesKt.to("ADD_TO_WISHLIST", "3"), TuplesKt.to("INITIATE_CHECKOUT", "4"), TuplesKt.to("ADD_PAYMENT_INFO", "5"), TuplesKt.to("PURCHASE", "6"), TuplesKt.to("LEAD", "7"), TuplesKt.to("COMPLETE_REGISTRATION", "8"));
                textTypeInfo = MapsKt.mapOf(TuplesKt.to("BUTTON_TEXT", "1"), TuplesKt.to("PAGE_TITLE", "2"), TuplesKt.to("RESOLVED_DOCUMENT_LINK", "3"), TuplesKt.to("BUTTON_ID", "4"));
                initialized = true;
            } catch (Exception unused) {
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, FeatureExtractor.class);
        }
    }

    private final boolean isButton(JSONObject node) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            return ((node.optInt("classtypebitmask") & 1) << 5) > 0;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }

    public static final boolean isInitialized() {
        if (CrashShieldHandler.isObjectCrashing(FeatureExtractor.class)) {
            return false;
        }
        try {
            return initialized;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, FeatureExtractor.class);
            return false;
        }
    }

    private final boolean matchIndicators(String[] indicators, String[] values) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            int length = indicators.length;
            int i5 = 0;
            while (i5 < length) {
                String str = indicators[i5];
                i5++;
                int length2 = values.length;
                int i6 = 0;
                while (i6 < length2) {
                    String str2 = values[i6];
                    i6++;
                    if (StringsKt.contains$default((CharSequence) str2, (CharSequence) str, false, 2, (Object) null)) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }

    private final float[] nonparseFeatures(JSONObject node, JSONArray siblings, String screenName, String formFieldsJSON, String appName) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            float[] fArr = new float[NUM_OF_FEATURES];
            for (int i5 = 0; i5 < NUM_OF_FEATURES; i5++) {
                fArr[i5] = 0.0f;
            }
            int length = siblings.length();
            fArr[3] = length > 1 ? length - 1.0f : 0.0f;
            try {
                int length2 = siblings.length();
                if (length2 > 0) {
                    int i6 = 0;
                    while (true) {
                        int i7 = i6 + 1;
                        JSONObject jSONObject = siblings.getJSONObject(i6);
                        Intrinsics.checkNotNullExpressionValue(jSONObject, "siblings.getJSONObject(i)");
                        if (isButton(jSONObject)) {
                            fArr[9] = fArr[9] + 1.0f;
                        }
                        if (i7 >= length2) {
                            break;
                        }
                        i6 = i7;
                    }
                }
            } catch (JSONException unused) {
            }
            fArr[13] = -1.0f;
            fArr[14] = -1.0f;
            String str = screenName + '|' + appName;
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            updateHintAndTextRecursively(node, sb2, sb);
            String sb3 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb3, "hintSB.toString()");
            String sb4 = sb2.toString();
            Intrinsics.checkNotNullExpressionValue(sb4, "textSB.toString()");
            fArr[15] = regexMatched("ENGLISH", "COMPLETE_REGISTRATION", "BUTTON_TEXT", sb4) ? 1.0f : 0.0f;
            fArr[16] = regexMatched("ENGLISH", "COMPLETE_REGISTRATION", "PAGE_TITLE", str) ? 1.0f : 0.0f;
            fArr[17] = regexMatched("ENGLISH", "COMPLETE_REGISTRATION", "BUTTON_ID", sb3) ? 1.0f : 0.0f;
            fArr[18] = StringsKt.contains$default((CharSequence) formFieldsJSON, (CharSequence) REGEX_CR_PASSWORD_FIELD, false, 2, (Object) null) ? 1.0f : 0.0f;
            fArr[19] = regexMatched(REGEX_CR_HAS_CONFIRM_PASSWORD_FIELD, formFieldsJSON) ? 1.0f : 0.0f;
            fArr[20] = regexMatched(REGEX_CR_HAS_LOG_IN_KEYWORDS, formFieldsJSON) ? 1.0f : 0.0f;
            fArr[21] = regexMatched(REGEX_CR_HAS_SIGN_ON_KEYWORDS, formFieldsJSON) ? 1.0f : 0.0f;
            fArr[22] = regexMatched("ENGLISH", "PURCHASE", "BUTTON_TEXT", sb4) ? 1.0f : 0.0f;
            fArr[24] = regexMatched("ENGLISH", "PURCHASE", "PAGE_TITLE", str) ? 1.0f : 0.0f;
            fArr[25] = regexMatched(REGEX_ADD_TO_CART_BUTTON_TEXT, sb4) ? 1.0f : 0.0f;
            fArr[27] = regexMatched(REGEX_ADD_TO_CART_PAGE_TITLE, str) ? 1.0f : 0.0f;
            fArr[28] = regexMatched("ENGLISH", "LEAD", "BUTTON_TEXT", sb4) ? 1.0f : 0.0f;
            fArr[29] = regexMatched("ENGLISH", "LEAD", "PAGE_TITLE", str) ? 1.0f : 0.0f;
            return fArr;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private final float[] parseFeatures(JSONObject node) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            float[] fArr = new float[NUM_OF_FEATURES];
            int i5 = 0;
            for (int i6 = 0; i6 < NUM_OF_FEATURES; i6++) {
                fArr[i6] = 0.0f;
            }
            String optString = node.optString("text");
            Intrinsics.checkNotNullExpressionValue(optString, "node.optString(TEXT_KEY)");
            String lowerCase = optString.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
            String optString2 = node.optString("hint");
            Intrinsics.checkNotNullExpressionValue(optString2, "node.optString(HINT_KEY)");
            String lowerCase2 = optString2.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "(this as java.lang.String).toLowerCase()");
            String optString3 = node.optString("classname");
            Intrinsics.checkNotNullExpressionValue(optString3, "node.optString(CLASS_NAME_KEY)");
            String lowerCase3 = optString3.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase3, "(this as java.lang.String).toLowerCase()");
            int optInt = node.optInt("inputtype", -1);
            String[] strArr = {lowerCase, lowerCase2};
            if (matchIndicators(new String[]{"$", "amount", "price", "total"}, strArr)) {
                fArr[0] = fArr[0] + 1.0f;
            }
            if (matchIndicators(new String[]{REGEX_CR_PASSWORD_FIELD, "pwd"}, strArr)) {
                fArr[1] = fArr[1] + 1.0f;
            }
            if (matchIndicators(new String[]{"tel", "phone"}, strArr)) {
                fArr[2] = fArr[2] + 1.0f;
            }
            if (matchIndicators(new String[]{"search"}, strArr)) {
                fArr[4] = fArr[4] + 1.0f;
            }
            if (optInt >= 0) {
                fArr[5] = fArr[5] + 1.0f;
            }
            if (optInt == 3 || optInt == 2) {
                fArr[6] = fArr[6] + 1.0f;
            }
            if (optInt == 32 || Patterns.EMAIL_ADDRESS.matcher(lowerCase).matches()) {
                fArr[7] = fArr[7] + 1.0f;
            }
            if (StringsKt.contains$default((CharSequence) lowerCase3, (CharSequence) "checkbox", false, 2, (Object) null)) {
                fArr[8] = fArr[8] + 1.0f;
            }
            if (matchIndicators(new String[]{"complete", "confirm", "done", "submit"}, new String[]{lowerCase})) {
                fArr[10] = fArr[10] + 1.0f;
            }
            if (StringsKt.contains$default((CharSequence) lowerCase3, (CharSequence) "radio", false, 2, (Object) null) && StringsKt.contains$default((CharSequence) lowerCase3, (CharSequence) "button", false, 2, (Object) null)) {
                fArr[12] = fArr[12] + 1.0f;
            }
            try {
                JSONArray optJSONArray = node.optJSONArray("childviews");
                int length = optJSONArray.length();
                if (length > 0) {
                    while (true) {
                        int i7 = i5 + 1;
                        JSONObject jSONObject = optJSONArray.getJSONObject(i5);
                        Intrinsics.checkNotNullExpressionValue(jSONObject, "childViews.getJSONObject(i)");
                        sum(fArr, parseFeatures(jSONObject));
                        if (i7 >= length) {
                            break;
                        }
                        i5 = i7;
                    }
                }
            } catch (JSONException unused) {
            }
            return fArr;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private final boolean pruneTree(JSONObject node, JSONArray siblings) {
        boolean z5;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            if (node.optBoolean("is_interacted")) {
                return true;
            }
            JSONArray optJSONArray = node.optJSONArray("childviews");
            int length = optJSONArray.length();
            if (length > 0) {
                int i5 = 0;
                while (true) {
                    int i6 = i5 + 1;
                    if (optJSONArray.getJSONObject(i5).optBoolean("is_interacted")) {
                        z5 = true;
                        break;
                    }
                    if (i6 >= length) {
                        break;
                    }
                    i5 = i6;
                }
            }
            z5 = false;
            boolean z6 = z5;
            JSONArray jSONArray = new JSONArray();
            if (z5) {
                int length2 = optJSONArray.length();
                if (length2 > 0) {
                    int i7 = 0;
                    while (true) {
                        int i8 = i7 + 1;
                        siblings.put(optJSONArray.getJSONObject(i7));
                        if (i8 >= length2) {
                            break;
                        }
                        i7 = i8;
                    }
                }
            } else {
                int length3 = optJSONArray.length();
                if (length3 > 0) {
                    int i9 = 0;
                    while (true) {
                        int i10 = i9 + 1;
                        JSONObject child = optJSONArray.getJSONObject(i9);
                        Intrinsics.checkNotNullExpressionValue(child, "child");
                        if (pruneTree(child, siblings)) {
                            jSONArray.put(child);
                            z6 = true;
                        }
                        if (i10 >= length3) {
                            break;
                        }
                        i9 = i10;
                    }
                }
                node.put("childviews", jSONArray);
            }
            return z6;
        } catch (JSONException unused) {
            return false;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0060 A[Catch: all -> 0x0065, TryCatch #0 {all -> 0x0065, blocks: (B:6:0x0008, B:8:0x000d, B:18:0x0060, B:20:0x0045, B:23:0x004f, B:25:0x0053, B:26:0x0067, B:27:0x006d, B:28:0x002a, B:31:0x0034, B:33:0x0038, B:34:0x006e, B:35:0x0073, B:36:0x0018, B:38:0x001c, B:39:0x0074, B:40:0x0079, B:41:0x007a, B:42:0x0080), top: B:5:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0053 A[Catch: all -> 0x0065, TryCatch #0 {all -> 0x0065, blocks: (B:6:0x0008, B:8:0x000d, B:18:0x0060, B:20:0x0045, B:23:0x004f, B:25:0x0053, B:26:0x0067, B:27:0x006d, B:28:0x002a, B:31:0x0034, B:33:0x0038, B:34:0x006e, B:35:0x0073, B:36:0x0018, B:38:0x001c, B:39:0x0074, B:40:0x0079, B:41:0x007a, B:42:0x0080), top: B:5:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0067 A[Catch: all -> 0x0065, TryCatch #0 {all -> 0x0065, blocks: (B:6:0x0008, B:8:0x000d, B:18:0x0060, B:20:0x0045, B:23:0x004f, B:25:0x0053, B:26:0x0067, B:27:0x006d, B:28:0x002a, B:31:0x0034, B:33:0x0038, B:34:0x006e, B:35:0x0073, B:36:0x0018, B:38:0x001c, B:39:0x0074, B:40:0x0079, B:41:0x007a, B:42:0x0080), top: B:5:0x0008 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean regexMatched(String language, String event, String textType, String matchText) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONObject optJSONObject3;
        JSONObject optJSONObject4;
        Map<String, String> map;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            JSONObject jSONObject = rules;
            String str = null;
            if (jSONObject != null) {
                JSONObject optJSONObject5 = jSONObject.optJSONObject("rulesForLanguage");
                if (optJSONObject5 == null) {
                    optJSONObject = null;
                } else {
                    Map<String, String> map2 = languageInfo;
                    if (map2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("languageInfo");
                        throw null;
                    }
                    optJSONObject = optJSONObject5.optJSONObject(map2.get(language));
                }
                if (optJSONObject != null && (optJSONObject2 = optJSONObject.optJSONObject("rulesForEvent")) != null) {
                    Map<String, String> map3 = eventInfo;
                    if (map3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("eventInfo");
                        throw null;
                    }
                    optJSONObject3 = optJSONObject2.optJSONObject(map3.get(event));
                    if (optJSONObject3 != null && (optJSONObject4 = optJSONObject3.optJSONObject("positiveRules")) != null) {
                        map = textTypeInfo;
                        if (map != null) {
                            Intrinsics.throwUninitializedPropertyAccessException("textTypeInfo");
                            throw null;
                        }
                        str = optJSONObject4.optString(map.get(textType));
                    }
                    if (str != null) {
                        return false;
                    }
                    return regexMatched(str, matchText);
                }
                optJSONObject3 = null;
                if (optJSONObject3 != null) {
                    map = textTypeInfo;
                    if (map != null) {
                    }
                }
                if (str != null) {
                }
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("rules");
                throw null;
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }

    private final void sum(float[] a5, float[] b5) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            int length = a5.length - 1;
            if (length < 0) {
                return;
            }
            int i5 = 0;
            while (true) {
                int i6 = i5 + 1;
                a5[i5] = a5[i5] + b5[i5];
                if (i6 > length) {
                    return;
                } else {
                    i5 = i6;
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private final void updateHintAndTextRecursively(JSONObject view, StringBuilder textSB, StringBuilder hintSB) {
        int length;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            String optString = view.optString("text", BuildConfig.FLAVOR);
            Intrinsics.checkNotNullExpressionValue(optString, "view.optString(TEXT_KEY, \"\")");
            String lowerCase = optString.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
            String optString2 = view.optString("hint", BuildConfig.FLAVOR);
            Intrinsics.checkNotNullExpressionValue(optString2, "view.optString(HINT_KEY, \"\")");
            String lowerCase2 = optString2.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "(this as java.lang.String).toLowerCase()");
            if (lowerCase.length() > 0) {
                textSB.append(lowerCase);
                textSB.append(" ");
            }
            if (lowerCase2.length() > 0) {
                hintSB.append(lowerCase2);
                hintSB.append(" ");
            }
            JSONArray optJSONArray = view.optJSONArray("childviews");
            if (optJSONArray == null || (length = optJSONArray.length()) <= 0) {
                return;
            }
            int i5 = 0;
            while (true) {
                int i6 = i5 + 1;
                try {
                    JSONObject currentChildView = optJSONArray.getJSONObject(i5);
                    Intrinsics.checkNotNullExpressionValue(currentChildView, "currentChildView");
                    updateHintAndTextRecursively(currentChildView, textSB, hintSB);
                } catch (JSONException unused) {
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

    private final boolean regexMatched(String pattern, String matchText) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            return Pattern.compile(pattern).matcher(matchText).find();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }
}
