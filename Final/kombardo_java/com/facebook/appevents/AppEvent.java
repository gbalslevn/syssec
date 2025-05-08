package com.facebook.appevents;

import android.os.Bundle;
import com.adjust.sdk.Constants;
import com.facebook.FacebookException;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.eventdeactivation.EventDeactivationManager;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.appevents.integrity.RedactedEventsManager;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.appevents.restrictivedatafilter.RestrictiveDataManager;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Regex;
import org.conscrypt.BuildConfig;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0016\b\u0007\u0018\u0000 32\u00020\u0001:\u000234BS\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0010\u0010\u0011B3\b\u0012\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\t\u0012\u0006\u0010\u0015\u001a\u00020\t\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0010\u0010\u0017J=\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ/\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u001c2\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u001b\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010 \u001a\u00020\u001fH\u0002¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\"\u0010#J\r\u0010$\u001a\u00020\t¢\u0006\u0004\b$\u0010%J\r\u0010&\u001a\u00020\u0018¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u0002H\u0016¢\u0006\u0004\b(\u0010#R\u0017\u0010)\u001a\u00020\u00188\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010'R\u0017\u0010,\u001a\u00020\u00188\u0006¢\u0006\f\n\u0004\b,\u0010*\u001a\u0004\b-\u0010'R\u0017\u0010\u0014\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0014\u0010.\u001a\u0004\b\u0014\u0010%R\u0014\u0010\u0015\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010.R\u0017\u0010/\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u0010#R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u00100R\u0011\u00102\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b2\u0010%¨\u00065"}, d2 = {"Lcom/facebook/appevents/AppEvent;", "Ljava/io/Serializable;", BuildConfig.FLAVOR, "contextName", "eventName", BuildConfig.FLAVOR, "valueToSum", "Landroid/os/Bundle;", "parameters", BuildConfig.FLAVOR, "isImplicitlyLogged", "isInBackground", "Ljava/util/UUID;", "currentSessionId", "Lcom/facebook/appevents/OperationalData;", "operationalParameters", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Landroid/os/Bundle;ZZLjava/util/UUID;Lcom/facebook/appevents/OperationalData;)V", "jsonString", "operationalJsonString", "isImplicit", "inBackground", "checksum", "(Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;)V", "Lorg/json/JSONObject;", "getJSONObjectForAppEvent", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Landroid/os/Bundle;Ljava/util/UUID;)Lorg/json/JSONObject;", "isOperational", BuildConfig.FLAVOR, "validateParameters", "(Landroid/os/Bundle;Z)Ljava/util/Map;", BuildConfig.FLAVOR, "writeReplace", "()Ljava/lang/Object;", "calculateChecksum", "()Ljava/lang/String;", "getIsImplicit", "()Z", "getJSONObject", "()Lorg/json/JSONObject;", "toString", "jsonObject", "Lorg/json/JSONObject;", "getJsonObject", "operationalJsonObject", "getOperationalJsonObject", "Z", "name", "Ljava/lang/String;", "getName", "isChecksumValid", "Companion", "SerializationProxyV2", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class AppEvent implements Serializable {
    private static final int MAX_IDENTIFIER_LENGTH = 40;
    private static final long serialVersionUID = 1;
    private final String checksum;
    private final boolean inBackground;
    private final boolean isImplicit;
    private final JSONObject jsonObject;
    private final String name;
    private final JSONObject operationalJsonObject;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final HashSet<String> validatedIdentifiers = new HashSet<>();

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0002J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/facebook/appevents/AppEvent$Companion;", BuildConfig.FLAVOR, "()V", "MAX_IDENTIFIER_LENGTH", BuildConfig.FLAVOR, "serialVersionUID", BuildConfig.FLAVOR, "validatedIdentifiers", "Ljava/util/HashSet;", BuildConfig.FLAVOR, "Lkotlin/collections/HashSet;", "md5Checksum", "toHash", "validateIdentifier", BuildConfig.FLAVOR, "identifier", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String md5Checksum(String toHash) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                Charset forName = Charset.forName(Constants.ENCODING);
                Intrinsics.checkNotNullExpressionValue(forName, "Charset.forName(charsetName)");
                if (toHash == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                byte[] bytes = toHash.getBytes(forName);
                Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                messageDigest.update(bytes, 0, bytes.length);
                byte[] digest = messageDigest.digest();
                Intrinsics.checkNotNullExpressionValue(digest, "digest.digest()");
                return AppEventUtility.bytesToHex(digest);
            } catch (UnsupportedEncodingException e5) {
                Utility.logd("Failed to generate checksum: ", e5);
                return "1";
            } catch (NoSuchAlgorithmException e6) {
                Utility.logd("Failed to generate checksum: ", e6);
                return "0";
            }
        }

        public final void validateIdentifier(String identifier) {
            boolean contains;
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            if (identifier.length() == 0 || identifier.length() > AppEvent.MAX_IDENTIFIER_LENGTH) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format(Locale.ROOT, "Identifier '%s' must be less than %d characters", Arrays.copyOf(new Object[]{identifier, Integer.valueOf(AppEvent.MAX_IDENTIFIER_LENGTH)}, 2));
                Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, format, *args)");
                throw new FacebookException(format);
            }
            synchronized (AppEvent.validatedIdentifiers) {
                contains = AppEvent.validatedIdentifiers.contains(identifier);
                Unit unit = Unit.INSTANCE;
            }
            if (contains) {
                return;
            }
            if (new Regex("^[0-9a-zA-Z_]+[0-9a-zA-Z _-]*$").matches(identifier)) {
                synchronized (AppEvent.validatedIdentifiers) {
                    AppEvent.validatedIdentifiers.add(identifier);
                }
            } else {
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                String format2 = String.format("Skipping event named '%s' due to illegal name - must be under 40 chars and alphanumeric, _, - or space, and not start with a space or hyphen.", Arrays.copyOf(new Object[]{identifier}, 1));
                Intrinsics.checkNotNullExpressionValue(format2, "java.lang.String.format(format, *args)");
                throw new FacebookException(format2);
            }
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0000\u0018\u0000 \f2\u00020\u0001:\u0001\fB/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/facebook/appevents/AppEvent$SerializationProxyV2;", "Ljava/io/Serializable;", "jsonString", BuildConfig.FLAVOR, "operationalJsonString", "isImplicit", BuildConfig.FLAVOR, "inBackground", "checksum", "(Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;)V", "readResolve", BuildConfig.FLAVOR, "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes.dex */
    public static final class SerializationProxyV2 implements Serializable {
        private static final long serialVersionUID = 20160803001L;
        private final String checksum;
        private final boolean inBackground;
        private final boolean isImplicit;
        private final String jsonString;
        private final String operationalJsonString;

        public SerializationProxyV2(String jsonString, String operationalJsonString, boolean z5, boolean z6, String str) {
            Intrinsics.checkNotNullParameter(jsonString, "jsonString");
            Intrinsics.checkNotNullParameter(operationalJsonString, "operationalJsonString");
            this.jsonString = jsonString;
            this.operationalJsonString = operationalJsonString;
            this.isImplicit = z5;
            this.inBackground = z6;
            this.checksum = str;
        }

        private final Object readResolve() {
            return new AppEvent(this.jsonString, this.operationalJsonString, this.isImplicit, this.inBackground, this.checksum, null);
        }
    }

    public /* synthetic */ AppEvent(String str, String str2, boolean z5, boolean z6, String str3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, z5, z6, str3);
    }

    private final String calculateChecksum() {
        Companion companion = INSTANCE;
        String jSONObject = this.jsonObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "jsonObject.toString()");
        return companion.md5Checksum(jSONObject);
    }

    private final JSONObject getJSONObjectForAppEvent(String contextName, String eventName, Double valueToSum, Bundle parameters, UUID currentSessionId) {
        INSTANCE.validateIdentifier(eventName);
        JSONObject jSONObject = new JSONObject();
        String processEvent = RestrictiveDataManager.processEvent(eventName);
        if (Intrinsics.areEqual(processEvent, eventName)) {
            processEvent = RedactedEventsManager.processEventsRedaction(eventName);
        }
        jSONObject.put("_eventName", processEvent);
        jSONObject.put("_logTime", System.currentTimeMillis() / Constants.ONE_SECOND);
        jSONObject.put("_ui", contextName);
        if (currentSessionId != null) {
            jSONObject.put("_session_id", currentSessionId);
        }
        if (parameters != null) {
            Map validateParameters$default = validateParameters$default(this, parameters, false, 2, null);
            for (String str : validateParameters$default.keySet()) {
                jSONObject.put(str, validateParameters$default.get(str));
            }
        }
        if (valueToSum != null) {
            jSONObject.put("_valueToSum", valueToSum.doubleValue());
        }
        if (this.inBackground) {
            jSONObject.put("_inBackground", "1");
        }
        if (this.isImplicit) {
            jSONObject.put("_implicitlyLogged", "1");
        } else {
            Logger.Companion companion = Logger.INSTANCE;
            LoggingBehavior loggingBehavior = LoggingBehavior.APP_EVENTS;
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "eventObject.toString()");
            companion.log(loggingBehavior, "AppEvents", "Created app event '%s'", jSONObject2);
        }
        return jSONObject;
    }

    private final Map<String, String> validateParameters(Bundle parameters, boolean isOperational) {
        HashMap hashMap = new HashMap();
        for (String key : parameters.keySet()) {
            Companion companion = INSTANCE;
            Intrinsics.checkNotNullExpressionValue(key, "key");
            companion.validateIdentifier(key);
            Object obj = parameters.get(key);
            if (!(obj instanceof String) && !(obj instanceof Number)) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format("Parameter value '%s' for key '%s' should be a string or a numeric type.", Arrays.copyOf(new Object[]{obj, key}, 2));
                Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
                throw new FacebookException(format);
            }
            hashMap.put(key, obj.toString());
        }
        if (!isOperational) {
            IntegrityManager.processParameters(hashMap);
            RestrictiveDataManager restrictiveDataManager = RestrictiveDataManager.INSTANCE;
            RestrictiveDataManager.processParameters(hashMap, this.name);
            EventDeactivationManager eventDeactivationManager = EventDeactivationManager.INSTANCE;
            EventDeactivationManager.processDeprecatedParameters(hashMap, this.name);
        }
        return hashMap;
    }

    static /* synthetic */ Map validateParameters$default(AppEvent appEvent, Bundle bundle, boolean z5, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            z5 = false;
        }
        return appEvent.validateParameters(bundle, z5);
    }

    private final Object writeReplace() {
        String jSONObject = this.jsonObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "jsonObject.toString()");
        String jSONObject2 = this.operationalJsonObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "operationalJsonObject.toString()");
        return new SerializationProxyV2(jSONObject, jSONObject2, this.isImplicit, this.inBackground, this.checksum);
    }

    public final boolean getIsImplicit() {
        return this.isImplicit;
    }

    /* renamed from: getJSONObject, reason: from getter */
    public final JSONObject getJsonObject() {
        return this.jsonObject;
    }

    public final JSONObject getJsonObject() {
        return this.jsonObject;
    }

    public final String getName() {
        return this.name;
    }

    public final JSONObject getOperationalJsonObject() {
        return this.operationalJsonObject;
    }

    public final boolean isChecksumValid() {
        if (this.checksum == null) {
            return true;
        }
        return Intrinsics.areEqual(calculateChecksum(), this.checksum);
    }

    public final boolean isImplicit() {
        return this.isImplicit;
    }

    public String toString() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("\"%s\", implicit: %b, json: %s", Arrays.copyOf(new Object[]{this.jsonObject.optString("_eventName"), Boolean.valueOf(this.isImplicit), this.jsonObject.toString()}, 3));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
        return format;
    }

    public AppEvent(String contextName, String eventName, Double d5, Bundle bundle, boolean z5, boolean z6, UUID uuid, OperationalData operationalData) {
        Intrinsics.checkNotNullParameter(contextName, "contextName");
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        this.isImplicit = z5;
        this.inBackground = z6;
        this.name = eventName;
        JSONObject json = operationalData == null ? null : operationalData.toJSON();
        this.operationalJsonObject = json == null ? new JSONObject() : json;
        this.jsonObject = getJSONObjectForAppEvent(contextName, eventName, d5, bundle, uuid);
        this.checksum = calculateChecksum();
    }

    private AppEvent(String str, String str2, boolean z5, boolean z6, String str3) {
        JSONObject jSONObject = new JSONObject(str);
        this.jsonObject = jSONObject;
        this.operationalJsonObject = new JSONObject(str2);
        this.isImplicit = z5;
        String optString = jSONObject.optString("_eventName");
        Intrinsics.checkNotNullExpressionValue(optString, "jsonObject.optString(Constants.EVENT_NAME_EVENT_KEY)");
        this.name = optString;
        this.checksum = str3;
        this.inBackground = z6;
    }
}
