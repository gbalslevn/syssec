package com.facebook;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.facebook.internal.Logger;
import java.util.ArrayList;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/facebook/LegacyTokenHelper;", BuildConfig.FLAVOR, "Landroid/content/Context;", "context", BuildConfig.FLAVOR, "cacheKey", "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "key", "Landroid/os/Bundle;", "bundle", BuildConfig.FLAVOR, "deserializeKey", "(Ljava/lang/String;Landroid/os/Bundle;)V", "load", "()Landroid/os/Bundle;", "clear", "()V", "Ljava/lang/String;", "Landroid/content/SharedPreferences;", "cache", "Landroid/content/SharedPreferences;", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class LegacyTokenHelper {
    private static final long INVALID_BUNDLE_MILLISECONDS = Long.MIN_VALUE;
    private static final String IS_SSO_KEY = "com.facebook.TokenCachingStrategy.IsSSO";
    private static final String JSON_VALUE = "value";
    private static final String JSON_VALUE_ENUM_TYPE = "enumType";
    private static final String JSON_VALUE_TYPE = "valueType";
    private static final String TYPE_BOOLEAN = "bool";
    private static final String TYPE_BOOLEAN_ARRAY = "bool[]";
    private static final String TYPE_BYTE = "byte";
    private static final String TYPE_BYTE_ARRAY = "byte[]";
    private static final String TYPE_CHAR = "char";
    private static final String TYPE_CHAR_ARRAY = "char[]";
    private static final String TYPE_DOUBLE = "double";
    private static final String TYPE_DOUBLE_ARRAY = "double[]";
    private static final String TYPE_ENUM = "enum";
    private static final String TYPE_FLOAT = "float";
    private static final String TYPE_FLOAT_ARRAY = "float[]";
    private static final String TYPE_INTEGER = "int";
    private static final String TYPE_INTEGER_ARRAY = "int[]";
    private static final String TYPE_LONG = "long";
    private static final String TYPE_LONG_ARRAY = "long[]";
    private static final String TYPE_SHORT = "short";
    private static final String TYPE_SHORT_ARRAY = "short[]";
    private static final String TYPE_STRING = "string";
    private static final String TYPE_STRING_LIST = "stringList";
    private final SharedPreferences cache;
    private final String cacheKey;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = LegacyTokenHelper.class.getSimpleName();

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b \b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\f\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0010\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0015\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0015\u0010\u0011J\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0016\u0010\u000fR\u0014\u0010\u0017\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001b\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001c\u0010\u0018R\u0014\u0010\u001e\u001a\u00020\u001d8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b \u0010\u0018R\u0014\u0010!\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b!\u0010\u0018R\u0014\u0010\"\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\"\u0010\u0018R\u0014\u0010#\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b#\u0010\u0018R\u0014\u0010$\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b$\u0010\u0018R\u0014\u0010%\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b%\u0010\u0018R\u001c\u0010'\u001a\n &*\u0004\u0018\u00010\u00060\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010\u0018R\u0014\u0010(\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b(\u0010\u0018R\u0014\u0010)\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b)\u0010\u0018R\u0014\u0010*\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b*\u0010\u0018R\u0014\u0010+\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b+\u0010\u0018R\u0014\u0010,\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b,\u0010\u0018R\u0014\u0010-\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b-\u0010\u0018R\u0014\u0010.\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b.\u0010\u0018R\u0014\u0010/\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b/\u0010\u0018R\u0014\u00100\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b0\u0010\u0018R\u0014\u00101\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b1\u0010\u0018R\u0014\u00102\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b2\u0010\u0018R\u0014\u00103\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b3\u0010\u0018R\u0014\u00104\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b4\u0010\u0018R\u0014\u00105\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b5\u0010\u0018R\u0014\u00106\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b6\u0010\u0018R\u0014\u00107\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b7\u0010\u0018R\u0014\u00108\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b8\u0010\u0018R\u0014\u00109\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b9\u0010\u0018R\u0014\u0010:\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b:\u0010\u0018R\u0014\u0010;\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b;\u0010\u0018R\u0014\u0010<\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b<\u0010\u0018¨\u0006="}, d2 = {"Lcom/facebook/LegacyTokenHelper$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "Landroid/os/Bundle;", "bundle", BuildConfig.FLAVOR, "key", "Ljava/util/Date;", "getDate", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/util/Date;", BuildConfig.FLAVOR, "hasTokenInformation", "(Landroid/os/Bundle;)Z", "getToken", "(Landroid/os/Bundle;)Ljava/lang/String;", "getExpirationDate", "(Landroid/os/Bundle;)Ljava/util/Date;", "Lcom/facebook/AccessTokenSource;", "getSource", "(Landroid/os/Bundle;)Lcom/facebook/AccessTokenSource;", "getLastRefreshDate", "getApplicationId", "APPLICATION_ID_KEY", "Ljava/lang/String;", "DECLINED_PERMISSIONS_KEY", "DEFAULT_CACHE_KEY", "EXPIRATION_DATE_KEY", "EXPIRED_PERMISSIONS_KEY", BuildConfig.FLAVOR, "INVALID_BUNDLE_MILLISECONDS", "J", "IS_SSO_KEY", "JSON_VALUE", "JSON_VALUE_ENUM_TYPE", "JSON_VALUE_TYPE", "LAST_REFRESH_DATE_KEY", "PERMISSIONS_KEY", "kotlin.jvm.PlatformType", "TAG", "TOKEN_KEY", "TOKEN_SOURCE_KEY", "TYPE_BOOLEAN", "TYPE_BOOLEAN_ARRAY", "TYPE_BYTE", "TYPE_BYTE_ARRAY", "TYPE_CHAR", "TYPE_CHAR_ARRAY", "TYPE_DOUBLE", "TYPE_DOUBLE_ARRAY", "TYPE_ENUM", "TYPE_FLOAT", "TYPE_FLOAT_ARRAY", "TYPE_INTEGER", "TYPE_INTEGER_ARRAY", "TYPE_LONG", "TYPE_LONG_ARRAY", "TYPE_SHORT", "TYPE_SHORT_ARRAY", "TYPE_STRING", "TYPE_STRING_LIST", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Date getDate(Bundle bundle, String key) {
            if (bundle == null) {
                return null;
            }
            long j5 = bundle.getLong(key, LegacyTokenHelper.INVALID_BUNDLE_MILLISECONDS);
            if (j5 == LegacyTokenHelper.INVALID_BUNDLE_MILLISECONDS) {
                return null;
            }
            return new Date(j5);
        }

        public final String getApplicationId(Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            return bundle.getString("com.facebook.TokenCachingStrategy.ApplicationId");
        }

        public final Date getExpirationDate(Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            return getDate(bundle, "com.facebook.TokenCachingStrategy.ExpirationDate");
        }

        public final Date getLastRefreshDate(Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            return getDate(bundle, "com.facebook.TokenCachingStrategy.LastRefreshDate");
        }

        public final AccessTokenSource getSource(Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            return bundle.containsKey("com.facebook.TokenCachingStrategy.AccessTokenSource") ? (AccessTokenSource) bundle.getSerializable("com.facebook.TokenCachingStrategy.AccessTokenSource") : bundle.getBoolean(LegacyTokenHelper.IS_SSO_KEY) ? AccessTokenSource.FACEBOOK_APPLICATION_WEB : AccessTokenSource.WEB_VIEW;
        }

        public final String getToken(Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            return bundle.getString("com.facebook.TokenCachingStrategy.Token");
        }

        public final boolean hasTokenInformation(Bundle bundle) {
            String string;
            return (bundle == null || (string = bundle.getString("com.facebook.TokenCachingStrategy.Token")) == null || string.length() == 0 || bundle.getLong("com.facebook.TokenCachingStrategy.ExpirationDate", 0L) == 0) ? false : true;
        }

        private Companion() {
        }
    }

    public LegacyTokenHelper(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        str = (str == null || str.length() == 0) ? "com.facebook.SharedPreferencesTokenCachingStrategy.DEFAULT_KEY" : str;
        this.cacheKey = str;
        Context applicationContext = context.getApplicationContext();
        SharedPreferences sharedPreferences = (applicationContext != null ? applicationContext : context).getSharedPreferences(str, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPreferences(this.cacheKey, Context.MODE_PRIVATE)");
        this.cache = sharedPreferences;
    }

    private final void deserializeKey(String key, Bundle bundle) {
        String str;
        String string;
        String string2 = this.cache.getString(key, "{}");
        if (string2 == null) {
            throw new IllegalStateException("Required value was null.");
        }
        JSONObject jSONObject = new JSONObject(string2);
        String string3 = jSONObject.getString(JSON_VALUE_TYPE);
        if (string3 != null) {
            int i5 = 0;
            switch (string3.hashCode()) {
                case -1573317553:
                    if (string3.equals(TYPE_STRING_LIST)) {
                        JSONArray jSONArray = jSONObject.getJSONArray(JSON_VALUE);
                        int length = jSONArray.length();
                        ArrayList<String> arrayList = new ArrayList<>(length);
                        if (length > 0) {
                            while (true) {
                                int i6 = i5 + 1;
                                Object obj = jSONArray.get(i5);
                                if (obj == JSONObject.NULL) {
                                    str = null;
                                } else {
                                    if (obj == null) {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                    }
                                    str = (String) obj;
                                }
                                arrayList.add(i5, str);
                                if (i6 < length) {
                                    i5 = i6;
                                }
                            }
                        }
                        bundle.putStringArrayList(key, arrayList);
                        return;
                    }
                    return;
                case -1383386164:
                    if (string3.equals(TYPE_BOOLEAN_ARRAY)) {
                        JSONArray jSONArray2 = jSONObject.getJSONArray(JSON_VALUE);
                        int length2 = jSONArray2.length();
                        boolean[] zArr = new boolean[length2];
                        int i7 = length2 - 1;
                        if (i7 >= 0) {
                            while (true) {
                                int i8 = i5 + 1;
                                zArr[i5] = jSONArray2.getBoolean(i5);
                                if (i8 <= i7) {
                                    i5 = i8;
                                }
                            }
                        }
                        bundle.putBooleanArray(key, zArr);
                        return;
                    }
                    return;
                case -1374008726:
                    if (string3.equals(TYPE_BYTE_ARRAY)) {
                        JSONArray jSONArray3 = jSONObject.getJSONArray(JSON_VALUE);
                        int length3 = jSONArray3.length();
                        byte[] bArr = new byte[length3];
                        int i9 = length3 - 1;
                        if (i9 >= 0) {
                            while (true) {
                                int i10 = i5 + 1;
                                bArr[i5] = (byte) jSONArray3.getInt(i5);
                                if (i10 <= i9) {
                                    i5 = i10;
                                }
                            }
                        }
                        bundle.putByteArray(key, bArr);
                        return;
                    }
                    return;
                case -1361632968:
                    if (string3.equals(TYPE_CHAR_ARRAY)) {
                        JSONArray jSONArray4 = jSONObject.getJSONArray(JSON_VALUE);
                        int length4 = jSONArray4.length();
                        char[] cArr = new char[length4];
                        int i11 = length4 - 1;
                        if (i11 >= 0) {
                            int i12 = 0;
                            while (true) {
                                int i13 = i12 + 1;
                                String string4 = jSONArray4.getString(i12);
                                if (string4 != null && string4.length() == 1) {
                                    cArr[i12] = string4.charAt(0);
                                }
                                if (i13 <= i11) {
                                    i12 = i13;
                                }
                            }
                        }
                        bundle.putCharArray(key, cArr);
                        return;
                    }
                    return;
                case -1325958191:
                    if (string3.equals(TYPE_DOUBLE)) {
                        bundle.putDouble(key, jSONObject.getDouble(JSON_VALUE));
                        return;
                    }
                    return;
                case -1097129250:
                    if (string3.equals(TYPE_LONG_ARRAY)) {
                        JSONArray jSONArray5 = jSONObject.getJSONArray(JSON_VALUE);
                        int length5 = jSONArray5.length();
                        long[] jArr = new long[length5];
                        int i14 = length5 - 1;
                        if (i14 >= 0) {
                            while (true) {
                                int i15 = i5 + 1;
                                jArr[i5] = jSONArray5.getLong(i5);
                                if (i15 <= i14) {
                                    i5 = i15;
                                }
                            }
                        }
                        bundle.putLongArray(key, jArr);
                        return;
                    }
                    return;
                case -891985903:
                    if (string3.equals(TYPE_STRING)) {
                        bundle.putString(key, jSONObject.getString(JSON_VALUE));
                        return;
                    }
                    return;
                case -766441794:
                    if (string3.equals(TYPE_FLOAT_ARRAY)) {
                        JSONArray jSONArray6 = jSONObject.getJSONArray(JSON_VALUE);
                        int length6 = jSONArray6.length();
                        float[] fArr = new float[length6];
                        int i16 = length6 - 1;
                        if (i16 >= 0) {
                            while (true) {
                                int i17 = i5 + 1;
                                fArr[i5] = (float) jSONArray6.getDouble(i5);
                                if (i17 <= i16) {
                                    i5 = i17;
                                }
                            }
                        }
                        bundle.putFloatArray(key, fArr);
                        return;
                    }
                    return;
                case 104431:
                    if (string3.equals(TYPE_INTEGER)) {
                        bundle.putInt(key, jSONObject.getInt(JSON_VALUE));
                        return;
                    }
                    return;
                case 3029738:
                    if (string3.equals(TYPE_BOOLEAN)) {
                        bundle.putBoolean(key, jSONObject.getBoolean(JSON_VALUE));
                        return;
                    }
                    return;
                case 3039496:
                    if (string3.equals(TYPE_BYTE)) {
                        bundle.putByte(key, (byte) jSONObject.getInt(JSON_VALUE));
                        return;
                    }
                    return;
                case 3052374:
                    if (string3.equals(TYPE_CHAR) && (string = jSONObject.getString(JSON_VALUE)) != null && string.length() == 1) {
                        bundle.putChar(key, string.charAt(0));
                        return;
                    }
                    return;
                case 3118337:
                    if (string3.equals(TYPE_ENUM)) {
                        try {
                            bundle.putSerializable(key, Enum.valueOf(Class.forName(jSONObject.getString(JSON_VALUE_ENUM_TYPE)), jSONObject.getString(JSON_VALUE)));
                            return;
                        } catch (ClassNotFoundException | IllegalArgumentException unused) {
                            return;
                        }
                    }
                    return;
                case 3327612:
                    if (string3.equals("long")) {
                        bundle.putLong(key, jSONObject.getLong(JSON_VALUE));
                        return;
                    }
                    return;
                case 97526364:
                    if (string3.equals(TYPE_FLOAT)) {
                        bundle.putFloat(key, (float) jSONObject.getDouble(JSON_VALUE));
                        return;
                    }
                    return;
                case 100361105:
                    if (string3.equals(TYPE_INTEGER_ARRAY)) {
                        JSONArray jSONArray7 = jSONObject.getJSONArray(JSON_VALUE);
                        int length7 = jSONArray7.length();
                        int[] iArr = new int[length7];
                        int i18 = length7 - 1;
                        if (i18 >= 0) {
                            while (true) {
                                int i19 = i5 + 1;
                                iArr[i5] = jSONArray7.getInt(i5);
                                if (i19 <= i18) {
                                    i5 = i19;
                                }
                            }
                        }
                        bundle.putIntArray(key, iArr);
                        return;
                    }
                    return;
                case 109413500:
                    if (string3.equals(TYPE_SHORT)) {
                        bundle.putShort(key, (short) jSONObject.getInt(JSON_VALUE));
                        return;
                    }
                    return;
                case 1359468275:
                    if (string3.equals(TYPE_DOUBLE_ARRAY)) {
                        JSONArray jSONArray8 = jSONObject.getJSONArray(JSON_VALUE);
                        int length8 = jSONArray8.length();
                        double[] dArr = new double[length8];
                        int i20 = length8 - 1;
                        if (i20 >= 0) {
                            while (true) {
                                int i21 = i5 + 1;
                                dArr[i5] = jSONArray8.getDouble(i5);
                                if (i21 <= i20) {
                                    i5 = i21;
                                }
                            }
                        }
                        bundle.putDoubleArray(key, dArr);
                        return;
                    }
                    return;
                case 2067161310:
                    if (string3.equals(TYPE_SHORT_ARRAY)) {
                        JSONArray jSONArray9 = jSONObject.getJSONArray(JSON_VALUE);
                        int length9 = jSONArray9.length();
                        short[] sArr = new short[length9];
                        int i22 = length9 - 1;
                        if (i22 >= 0) {
                            while (true) {
                                int i23 = i5 + 1;
                                sArr[i5] = (short) jSONArray9.getInt(i5);
                                if (i23 <= i22) {
                                    i5 = i23;
                                }
                            }
                        }
                        bundle.putShortArray(key, sArr);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public final void clear() {
        this.cache.edit().clear().apply();
    }

    public final Bundle load() {
        Bundle bundle = new Bundle();
        for (String key : this.cache.getAll().keySet()) {
            try {
                Intrinsics.checkNotNullExpressionValue(key, "key");
                deserializeKey(key, bundle);
            } catch (JSONException e5) {
                Logger.Companion companion = Logger.INSTANCE;
                LoggingBehavior loggingBehavior = LoggingBehavior.CACHE;
                String TAG2 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                companion.log(loggingBehavior, 5, TAG2, "Error reading cached value for key: '" + ((Object) key) + "' -- " + e5);
                return null;
            }
        }
        return bundle;
    }

    public /* synthetic */ LegacyTokenHelper(Context context, String str, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i5 & 2) != 0 ? null : str);
    }
}
