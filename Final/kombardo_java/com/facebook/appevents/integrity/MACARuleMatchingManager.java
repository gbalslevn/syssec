package com.facebook.appevents.integrity;

import android.os.Build;
import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.sdk.growthbook.utils.Constants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0007J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\tH\u0007J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\u0012\u0010\u0014\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007J&\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016j\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004H\u0007J\u001c\u0010\u0019\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u000fH\u0007J\b\u0010\u001c\u001a\u00020\fH\u0002J\u001a\u0010\u001d\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\tH\u0007J\u0010\u0010\u001e\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\"\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u000fH\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\n¨\u0006\""}, d2 = {"Lcom/facebook/appevents/integrity/MACARuleMatchingManager;", BuildConfig.FLAVOR, "()V", "MACARules", "Lorg/json/JSONArray;", "enabled", BuildConfig.FLAVOR, "keys", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "[Ljava/lang/String;", "enable", BuildConfig.FLAVOR, "generateInfo", "params", "Landroid/os/Bundle;", "event", "getKey", "logic", "Lorg/json/JSONObject;", "getMatchPropertyIDs", "getStringArrayList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "jsonArray", "isMatchCCRule", "ruleString", "data", "loadMACARules", "processParameters", "removeGeneratedInfo", "stringComparison", "variable", "values", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class MACARuleMatchingManager {
    private static JSONArray MACARules;
    private static boolean enabled;
    public static final MACARuleMatchingManager INSTANCE = new MACARuleMatchingManager();
    private static String[] keys = {"event", "_locale", "_appVersion", "_deviceOS", "_platform", "_deviceModel", "_nativeAppID", "_nativeAppShortVersion", "_timezone", "_carrier", "_deviceOSTypeName", "_deviceOSVersion", "_remainingDiskGB"};

    private MACARuleMatchingManager() {
    }

    public static final void enable() {
        if (CrashShieldHandler.isObjectCrashing(MACARuleMatchingManager.class)) {
            return;
        }
        try {
            INSTANCE.loadMACARules();
            if (MACARules != null) {
                enabled = true;
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MACARuleMatchingManager.class);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0043 A[Catch: all -> 0x00b4, TryCatch #0 {all -> 0x00b4, blocks: (B:6:0x000d, B:10:0x0033, B:13:0x004a, B:16:0x005d, B:19:0x0073, B:22:0x0089, B:26:0x0043, B:29:0x002c), top: B:5:0x000d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void generateInfo(Bundle params, String event) {
        String language;
        Locale locale;
        String country;
        String versionName;
        String str;
        String versionName2;
        if (CrashShieldHandler.isObjectCrashing(MACARuleMatchingManager.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(params, "params");
            Intrinsics.checkNotNullParameter(event, "event");
            params.putString("event", event);
            StringBuilder sb = new StringBuilder();
            Utility utility = Utility.INSTANCE;
            Locale locale2 = utility.getLocale();
            String str2 = BuildConfig.FLAVOR;
            if (locale2 != null) {
                language = locale2.getLanguage();
                if (language == null) {
                }
                sb.append(language);
                sb.append('_');
                locale = utility.getLocale();
                if (locale != null) {
                    country = locale.getCountry();
                    if (country != null) {
                    }
                    sb.append(country);
                    params.putString("_locale", sb.toString());
                    versionName = utility.getVersionName();
                    if (versionName == null) {
                        versionName = BuildConfig.FLAVOR;
                    }
                    params.putString("_appVersion", versionName);
                    params.putString("_deviceOS", "ANDROID");
                    params.putString("_platform", "mobile");
                    str = Build.MODEL;
                    if (str == null) {
                        str = BuildConfig.FLAVOR;
                    }
                    params.putString("_deviceModel", str);
                    params.putString("_nativeAppID", FacebookSdk.getApplicationId());
                    versionName2 = utility.getVersionName();
                    if (versionName2 != null) {
                        str2 = versionName2;
                    }
                    params.putString("_nativeAppShortVersion", str2);
                    params.putString("_timezone", utility.getDeviceTimeZoneName());
                    params.putString("_carrier", utility.getCarrierName());
                    params.putString("_deviceOSTypeName", "ANDROID");
                    params.putString("_deviceOSVersion", Build.VERSION.RELEASE);
                    params.putLong("_remainingDiskGB", utility.getAvailableExternalStorageGB());
                }
                country = BuildConfig.FLAVOR;
                sb.append(country);
                params.putString("_locale", sb.toString());
                versionName = utility.getVersionName();
                if (versionName == null) {
                }
                params.putString("_appVersion", versionName);
                params.putString("_deviceOS", "ANDROID");
                params.putString("_platform", "mobile");
                str = Build.MODEL;
                if (str == null) {
                }
                params.putString("_deviceModel", str);
                params.putString("_nativeAppID", FacebookSdk.getApplicationId());
                versionName2 = utility.getVersionName();
                if (versionName2 != null) {
                }
                params.putString("_nativeAppShortVersion", str2);
                params.putString("_timezone", utility.getDeviceTimeZoneName());
                params.putString("_carrier", utility.getCarrierName());
                params.putString("_deviceOSTypeName", "ANDROID");
                params.putString("_deviceOSVersion", Build.VERSION.RELEASE);
                params.putLong("_remainingDiskGB", utility.getAvailableExternalStorageGB());
            }
            language = BuildConfig.FLAVOR;
            sb.append(language);
            sb.append('_');
            locale = utility.getLocale();
            if (locale != null) {
            }
            country = BuildConfig.FLAVOR;
            sb.append(country);
            params.putString("_locale", sb.toString());
            versionName = utility.getVersionName();
            if (versionName == null) {
            }
            params.putString("_appVersion", versionName);
            params.putString("_deviceOS", "ANDROID");
            params.putString("_platform", "mobile");
            str = Build.MODEL;
            if (str == null) {
            }
            params.putString("_deviceModel", str);
            params.putString("_nativeAppID", FacebookSdk.getApplicationId());
            versionName2 = utility.getVersionName();
            if (versionName2 != null) {
            }
            params.putString("_nativeAppShortVersion", str2);
            params.putString("_timezone", utility.getDeviceTimeZoneName());
            params.putString("_carrier", utility.getCarrierName());
            params.putString("_deviceOSTypeName", "ANDROID");
            params.putString("_deviceOSVersion", Build.VERSION.RELEASE);
            params.putLong("_remainingDiskGB", utility.getAvailableExternalStorageGB());
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MACARuleMatchingManager.class);
        }
    }

    public static final String getKey(JSONObject logic) {
        if (CrashShieldHandler.isObjectCrashing(MACARuleMatchingManager.class)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(logic, "logic");
            Iterator<String> keys2 = logic.keys();
            if (keys2.hasNext()) {
                return keys2.next();
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MACARuleMatchingManager.class);
            return null;
        }
    }

    public static final String getMatchPropertyIDs(Bundle params) {
        String optString;
        if (CrashShieldHandler.isObjectCrashing(MACARuleMatchingManager.class)) {
            return null;
        }
        try {
            JSONArray jSONArray = MACARules;
            if (jSONArray == null) {
                return "[]";
            }
            Integer valueOf = jSONArray == null ? null : Integer.valueOf(jSONArray.length());
            if (valueOf != null && valueOf.intValue() == 0) {
                return "[]";
            }
            JSONArray jSONArray2 = MACARules;
            if (jSONArray2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type org.json.JSONArray");
            }
            ArrayList arrayList = new ArrayList();
            int length = jSONArray2.length();
            if (length > 0) {
                int i5 = 0;
                while (true) {
                    int i6 = i5 + 1;
                    String optString2 = jSONArray2.optString(i5);
                    if (optString2 != null) {
                        JSONObject jSONObject = new JSONObject(optString2);
                        long optLong = jSONObject.optLong(Constants.ID_ATTRIBUTE_KEY);
                        if (optLong != 0 && (optString = jSONObject.optString("rule")) != null && isMatchCCRule(optString, params)) {
                            arrayList.add(Long.valueOf(optLong));
                        }
                    }
                    if (i6 >= length) {
                        break;
                    }
                    i5 = i6;
                }
            }
            String jSONArray3 = new JSONArray((Collection) arrayList).toString();
            Intrinsics.checkNotNullExpressionValue(jSONArray3, "JSONArray(res).toString()");
            return jSONArray3;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MACARuleMatchingManager.class);
            return null;
        }
    }

    public static final ArrayList<String> getStringArrayList(JSONArray jsonArray) {
        if (CrashShieldHandler.isObjectCrashing(MACARuleMatchingManager.class) || jsonArray == null) {
            return null;
        }
        try {
            ArrayList<String> arrayList = new ArrayList<>();
            int length = jsonArray.length();
            if (length > 0) {
                int i5 = 0;
                while (true) {
                    int i6 = i5 + 1;
                    arrayList.add(jsonArray.get(i5).toString());
                    if (i6 >= length) {
                        break;
                    }
                    i5 = i6;
                }
            }
            return arrayList;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MACARuleMatchingManager.class);
            return null;
        }
    }

    public static final boolean isMatchCCRule(String ruleString, Bundle data) {
        int length;
        if (!CrashShieldHandler.isObjectCrashing(MACARuleMatchingManager.class) && ruleString != null && data != null) {
            try {
                JSONObject jSONObject = new JSONObject(ruleString);
                String key = getKey(jSONObject);
                if (key == null) {
                    return false;
                }
                Object obj = jSONObject.get(key);
                int hashCode = key.hashCode();
                if (hashCode != 3555) {
                    if (hashCode != 96727) {
                        if (hashCode == 109267 && key.equals("not")) {
                            return !isMatchCCRule(obj.toString(), data);
                        }
                    } else if (key.equals("and")) {
                        JSONArray jSONArray = (JSONArray) obj;
                        if (jSONArray == null) {
                            return false;
                        }
                        int length2 = jSONArray.length();
                        if (length2 > 0) {
                            int i5 = 0;
                            while (true) {
                                int i6 = i5 + 1;
                                if (!isMatchCCRule(jSONArray.get(i5).toString(), data)) {
                                    return false;
                                }
                                if (i6 >= length2) {
                                    break;
                                }
                                i5 = i6;
                            }
                        }
                        return true;
                    }
                } else if (key.equals("or")) {
                    JSONArray jSONArray2 = (JSONArray) obj;
                    if (jSONArray2 != null && (length = jSONArray2.length()) > 0) {
                        int i7 = 0;
                        while (true) {
                            int i8 = i7 + 1;
                            if (isMatchCCRule(jSONArray2.get(i7).toString(), data)) {
                                return true;
                            }
                            if (i8 >= length) {
                                break;
                            }
                            i7 = i8;
                        }
                    }
                    return false;
                }
                JSONObject jSONObject2 = (JSONObject) obj;
                if (jSONObject2 == null) {
                    return false;
                }
                return stringComparison(key, jSONObject2, data);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, MACARuleMatchingManager.class);
            }
        }
        return false;
    }

    private final void loadMACARules() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
            FetchedAppSettings queryAppSettings = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false);
            if (queryAppSettings == null) {
                return;
            }
            MACARules = queryAppSettings.getMACARuleMatchingSetting();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public static final void processParameters(Bundle params, String event) {
        if (CrashShieldHandler.isObjectCrashing(MACARuleMatchingManager.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(event, "event");
            if (!enabled || params == null) {
                return;
            }
            try {
                generateInfo(params, event);
                params.putString("_audiencePropertyIds", getMatchPropertyIDs(params));
                params.putString("cs_maca", "1");
                removeGeneratedInfo(params);
            } catch (Exception unused) {
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MACARuleMatchingManager.class);
        }
    }

    public static final void removeGeneratedInfo(Bundle params) {
        if (CrashShieldHandler.isObjectCrashing(MACARuleMatchingManager.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(params, "params");
            String[] strArr = keys;
            int length = strArr.length;
            int i5 = 0;
            while (i5 < length) {
                String str = strArr[i5];
                i5++;
                params.remove(str);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MACARuleMatchingManager.class);
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:27:0x007a. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:107:0x02be A[Catch: all -> 0x004e, TryCatch #0 {all -> 0x004e, blocks: (B:6:0x000a, B:9:0x001d, B:13:0x0041, B:15:0x0039, B:24:0x006a, B:25:0x0072, B:28:0x007f, B:32:0x0089, B:34:0x008f, B:36:0x009a, B:38:0x00a7, B:39:0x00ac, B:40:0x00ad, B:41:0x00b2, B:42:0x00b3, B:46:0x00bd, B:51:0x00ca, B:57:0x025b, B:60:0x0263, B:61:0x0267, B:63:0x026d, B:65:0x0275, B:67:0x0284, B:74:0x0293, B:75:0x0298, B:77:0x0299, B:78:0x029e, B:80:0x00d4, B:84:0x00de, B:86:0x00e4, B:88:0x00ef, B:90:0x00fc, B:91:0x0101, B:92:0x0102, B:93:0x0107, B:94:0x0108, B:100:0x02ac, B:104:0x02b4, B:105:0x02b8, B:107:0x02be, B:109:0x02c6, B:111:0x02d5, B:117:0x02e4, B:118:0x02e9, B:120:0x02ea, B:121:0x02ef, B:124:0x0112, B:128:0x011c, B:130:0x0122, B:132:0x012d, B:134:0x013a, B:135:0x013f, B:136:0x0140, B:137:0x0145, B:138:0x0146, B:142:0x01f6, B:146:0x0150, B:150:0x01da, B:154:0x015a, B:158:0x01b4, B:162:0x0164, B:166:0x016e, B:170:0x023c, B:174:0x0178, B:178:0x0182, B:184:0x0392, B:186:0x018c, B:190:0x020c, B:194:0x0196, B:198:0x01a0, B:202:0x0228, B:204:0x01aa, B:208:0x01c6, B:212:0x01d0, B:216:0x01ec, B:220:0x0202, B:224:0x021e, B:228:0x0232, B:232:0x024e, B:236:0x029f, B:240:0x02f0, B:244:0x02fa, B:246:0x0300, B:248:0x030b, B:252:0x031a, B:253:0x031f, B:254:0x0320, B:255:0x0325, B:256:0x0326, B:260:0x0330, B:262:0x033a, B:268:0x037d, B:270:0x0344, B:274:0x034f, B:276:0x035e, B:280:0x0368, B:282:0x0371, B:286:0x0386, B:290:0x039b, B:294:0x03a4, B:296:0x03aa, B:298:0x03b5, B:302:0x03c5, B:303:0x03ca, B:304:0x03cb, B:305:0x03d0, B:307:0x0057), top: B:5:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:145:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:153:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:161:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:172:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:173:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0391 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0392 A[Catch: all -> 0x004e, TryCatch #0 {all -> 0x004e, blocks: (B:6:0x000a, B:9:0x001d, B:13:0x0041, B:15:0x0039, B:24:0x006a, B:25:0x0072, B:28:0x007f, B:32:0x0089, B:34:0x008f, B:36:0x009a, B:38:0x00a7, B:39:0x00ac, B:40:0x00ad, B:41:0x00b2, B:42:0x00b3, B:46:0x00bd, B:51:0x00ca, B:57:0x025b, B:60:0x0263, B:61:0x0267, B:63:0x026d, B:65:0x0275, B:67:0x0284, B:74:0x0293, B:75:0x0298, B:77:0x0299, B:78:0x029e, B:80:0x00d4, B:84:0x00de, B:86:0x00e4, B:88:0x00ef, B:90:0x00fc, B:91:0x0101, B:92:0x0102, B:93:0x0107, B:94:0x0108, B:100:0x02ac, B:104:0x02b4, B:105:0x02b8, B:107:0x02be, B:109:0x02c6, B:111:0x02d5, B:117:0x02e4, B:118:0x02e9, B:120:0x02ea, B:121:0x02ef, B:124:0x0112, B:128:0x011c, B:130:0x0122, B:132:0x012d, B:134:0x013a, B:135:0x013f, B:136:0x0140, B:137:0x0145, B:138:0x0146, B:142:0x01f6, B:146:0x0150, B:150:0x01da, B:154:0x015a, B:158:0x01b4, B:162:0x0164, B:166:0x016e, B:170:0x023c, B:174:0x0178, B:178:0x0182, B:184:0x0392, B:186:0x018c, B:190:0x020c, B:194:0x0196, B:198:0x01a0, B:202:0x0228, B:204:0x01aa, B:208:0x01c6, B:212:0x01d0, B:216:0x01ec, B:220:0x0202, B:224:0x021e, B:228:0x0232, B:232:0x024e, B:236:0x029f, B:240:0x02f0, B:244:0x02fa, B:246:0x0300, B:248:0x030b, B:252:0x031a, B:253:0x031f, B:254:0x0320, B:255:0x0325, B:256:0x0326, B:260:0x0330, B:262:0x033a, B:268:0x037d, B:270:0x0344, B:274:0x034f, B:276:0x035e, B:280:0x0368, B:282:0x0371, B:286:0x0386, B:290:0x039b, B:294:0x03a4, B:296:0x03aa, B:298:0x03b5, B:302:0x03c5, B:303:0x03ca, B:304:0x03cb, B:305:0x03d0, B:307:0x0057), top: B:5:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:192:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:193:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:267:0x037c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:268:0x037d A[Catch: all -> 0x004e, TryCatch #0 {all -> 0x004e, blocks: (B:6:0x000a, B:9:0x001d, B:13:0x0041, B:15:0x0039, B:24:0x006a, B:25:0x0072, B:28:0x007f, B:32:0x0089, B:34:0x008f, B:36:0x009a, B:38:0x00a7, B:39:0x00ac, B:40:0x00ad, B:41:0x00b2, B:42:0x00b3, B:46:0x00bd, B:51:0x00ca, B:57:0x025b, B:60:0x0263, B:61:0x0267, B:63:0x026d, B:65:0x0275, B:67:0x0284, B:74:0x0293, B:75:0x0298, B:77:0x0299, B:78:0x029e, B:80:0x00d4, B:84:0x00de, B:86:0x00e4, B:88:0x00ef, B:90:0x00fc, B:91:0x0101, B:92:0x0102, B:93:0x0107, B:94:0x0108, B:100:0x02ac, B:104:0x02b4, B:105:0x02b8, B:107:0x02be, B:109:0x02c6, B:111:0x02d5, B:117:0x02e4, B:118:0x02e9, B:120:0x02ea, B:121:0x02ef, B:124:0x0112, B:128:0x011c, B:130:0x0122, B:132:0x012d, B:134:0x013a, B:135:0x013f, B:136:0x0140, B:137:0x0145, B:138:0x0146, B:142:0x01f6, B:146:0x0150, B:150:0x01da, B:154:0x015a, B:158:0x01b4, B:162:0x0164, B:166:0x016e, B:170:0x023c, B:174:0x0178, B:178:0x0182, B:184:0x0392, B:186:0x018c, B:190:0x020c, B:194:0x0196, B:198:0x01a0, B:202:0x0228, B:204:0x01aa, B:208:0x01c6, B:212:0x01d0, B:216:0x01ec, B:220:0x0202, B:224:0x021e, B:228:0x0232, B:232:0x024e, B:236:0x029f, B:240:0x02f0, B:244:0x02fa, B:246:0x0300, B:248:0x030b, B:252:0x031a, B:253:0x031f, B:254:0x0320, B:255:0x0325, B:256:0x0326, B:260:0x0330, B:262:0x033a, B:268:0x037d, B:270:0x0344, B:274:0x034f, B:276:0x035e, B:280:0x0368, B:282:0x0371, B:286:0x0386, B:290:0x039b, B:294:0x03a4, B:296:0x03aa, B:298:0x03b5, B:302:0x03c5, B:303:0x03ca, B:304:0x03cb, B:305:0x03d0, B:307:0x0057), top: B:5:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x025a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x025b A[Catch: all -> 0x004e, TryCatch #0 {all -> 0x004e, blocks: (B:6:0x000a, B:9:0x001d, B:13:0x0041, B:15:0x0039, B:24:0x006a, B:25:0x0072, B:28:0x007f, B:32:0x0089, B:34:0x008f, B:36:0x009a, B:38:0x00a7, B:39:0x00ac, B:40:0x00ad, B:41:0x00b2, B:42:0x00b3, B:46:0x00bd, B:51:0x00ca, B:57:0x025b, B:60:0x0263, B:61:0x0267, B:63:0x026d, B:65:0x0275, B:67:0x0284, B:74:0x0293, B:75:0x0298, B:77:0x0299, B:78:0x029e, B:80:0x00d4, B:84:0x00de, B:86:0x00e4, B:88:0x00ef, B:90:0x00fc, B:91:0x0101, B:92:0x0102, B:93:0x0107, B:94:0x0108, B:100:0x02ac, B:104:0x02b4, B:105:0x02b8, B:107:0x02be, B:109:0x02c6, B:111:0x02d5, B:117:0x02e4, B:118:0x02e9, B:120:0x02ea, B:121:0x02ef, B:124:0x0112, B:128:0x011c, B:130:0x0122, B:132:0x012d, B:134:0x013a, B:135:0x013f, B:136:0x0140, B:137:0x0145, B:138:0x0146, B:142:0x01f6, B:146:0x0150, B:150:0x01da, B:154:0x015a, B:158:0x01b4, B:162:0x0164, B:166:0x016e, B:170:0x023c, B:174:0x0178, B:178:0x0182, B:184:0x0392, B:186:0x018c, B:190:0x020c, B:194:0x0196, B:198:0x01a0, B:202:0x0228, B:204:0x01aa, B:208:0x01c6, B:212:0x01d0, B:216:0x01ec, B:220:0x0202, B:224:0x021e, B:228:0x0232, B:232:0x024e, B:236:0x029f, B:240:0x02f0, B:244:0x02fa, B:246:0x0300, B:248:0x030b, B:252:0x031a, B:253:0x031f, B:254:0x0320, B:255:0x0325, B:256:0x0326, B:260:0x0330, B:262:0x033a, B:268:0x037d, B:270:0x0344, B:274:0x034f, B:276:0x035e, B:280:0x0368, B:282:0x0371, B:286:0x0386, B:290:0x039b, B:294:0x03a4, B:296:0x03aa, B:298:0x03b5, B:302:0x03c5, B:303:0x03ca, B:304:0x03cb, B:305:0x03d0, B:307:0x0057), top: B:5:0x000a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean stringComparison(String variable, JSONObject values, Bundle data) {
        Object obj;
        if (CrashShieldHandler.isObjectCrashing(MACARuleMatchingManager.class)) {
            return false;
        }
        try {
            Intrinsics.checkNotNullParameter(variable, "variable");
            Intrinsics.checkNotNullParameter(values, "values");
            String key = getKey(values);
            if (key == null) {
                return false;
            }
            String obj2 = values.get(key).toString();
            ArrayList<String> stringArrayList = getStringArrayList(values.optJSONArray(key));
            Boolean bool = null;
            if (Intrinsics.areEqual(key, "exists")) {
                if (data != null) {
                    bool = Boolean.valueOf(data.containsKey(variable));
                }
                return Intrinsics.areEqual(bool, Boolean.valueOf(Boolean.parseBoolean(obj2)));
            }
            if (data == null) {
                obj = null;
            } else {
                String lowerCase = variable.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
                obj = data.get(lowerCase);
            }
            if (obj == null) {
                obj = data == null ? null : data.get(variable);
                if (obj == null) {
                    return false;
                }
            }
            switch (key.hashCode()) {
                case -1729128927:
                    if (!key.equals("i_not_contains")) {
                        return false;
                    }
                    String obj3 = obj.toString();
                    if (obj3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                    Locale locale = Locale.ROOT;
                    String lowerCase2 = obj3.toLowerCase(locale);
                    Intrinsics.checkNotNullExpressionValue(lowerCase2, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
                    if (obj2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                    String lowerCase3 = obj2.toLowerCase(locale);
                    Intrinsics.checkNotNullExpressionValue(lowerCase3, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
                    return !StringsKt.contains$default((CharSequence) lowerCase2, (CharSequence) lowerCase3, false, 2, (Object) null);
                case -1179774633:
                    if (!key.equals("is_any")) {
                        return false;
                    }
                    if (stringArrayList != null) {
                        return false;
                    }
                    return stringArrayList.contains(obj.toString());
                case -1039699439:
                    if (!key.equals("not_in")) {
                        return false;
                    }
                    if (stringArrayList != null) {
                        return false;
                    }
                    return stringArrayList.contains(obj.toString());
                case -969266188:
                    if (key.equals("starts_with")) {
                        return StringsKt.startsWith$default(obj.toString(), obj2, false, 2, (Object) null);
                    }
                    return false;
                case -966353971:
                    if (key.equals("regex_match")) {
                        return new Regex(obj2).matches(obj.toString());
                    }
                    return false;
                case -665609109:
                    if (!key.equals("is_not_any")) {
                        return false;
                    }
                    if (stringArrayList != null) {
                    }
                    break;
                case -567445985:
                    if (key.equals("contains")) {
                        return StringsKt.contains$default((CharSequence) obj.toString(), (CharSequence) obj2, false, 2, (Object) null);
                    }
                    return false;
                case -327990090:
                    if (!key.equals("i_str_neq")) {
                        return false;
                    }
                    String obj4 = obj.toString();
                    if (obj4 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                    Locale locale2 = Locale.ROOT;
                    String lowerCase4 = obj4.toLowerCase(locale2);
                    Intrinsics.checkNotNullExpressionValue(lowerCase4, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
                    if (obj2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                    String lowerCase5 = obj2.toLowerCase(locale2);
                    Intrinsics.checkNotNullExpressionValue(lowerCase5, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
                    if (Intrinsics.areEqual(lowerCase4, lowerCase5)) {
                        return false;
                    }
                case -159812115:
                    if (!key.equals("i_is_any")) {
                        return false;
                    }
                    if (stringArrayList == null && !stringArrayList.isEmpty()) {
                        for (String str : stringArrayList) {
                            if (str == null) {
                                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                            }
                            Locale locale3 = Locale.ROOT;
                            String lowerCase6 = str.toLowerCase(locale3);
                            Intrinsics.checkNotNullExpressionValue(lowerCase6, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
                            String obj5 = obj.toString();
                            if (obj5 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                            }
                            String lowerCase7 = obj5.toLowerCase(locale3);
                            Intrinsics.checkNotNullExpressionValue(lowerCase7, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
                            if (Intrinsics.areEqual(lowerCase6, lowerCase7)) {
                            }
                        }
                        return false;
                    }
                    return false;
                case -92753547:
                    if (!key.equals("i_str_not_in")) {
                        return false;
                    }
                    if (stringArrayList != null) {
                        return false;
                    }
                    if (!stringArrayList.isEmpty()) {
                        for (String str2 : stringArrayList) {
                            if (str2 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                            }
                            Locale locale4 = Locale.ROOT;
                            String lowerCase8 = str2.toLowerCase(locale4);
                            Intrinsics.checkNotNullExpressionValue(lowerCase8, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
                            String obj6 = obj.toString();
                            if (obj6 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                            }
                            String lowerCase9 = obj6.toLowerCase(locale4);
                            Intrinsics.checkNotNullExpressionValue(lowerCase9, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
                            if (Intrinsics.areEqual(lowerCase8, lowerCase9)) {
                                return false;
                            }
                        }
                    }
                case 60:
                    if (!key.equals("<")) {
                        return false;
                    }
                    if (Double.parseDouble(obj.toString()) < Double.parseDouble(obj2)) {
                        return false;
                    }
                case 61:
                    if (!key.equals("=")) {
                        return false;
                    }
                    return Intrinsics.areEqual(obj.toString(), obj2);
                case 62:
                    if (!key.equals(">")) {
                        return false;
                    }
                    if (Double.parseDouble(obj.toString()) > Double.parseDouble(obj2)) {
                        return false;
                    }
                case 1084:
                    if (!key.equals("!=")) {
                        return false;
                    }
                    if (Intrinsics.areEqual(obj.toString(), obj2)) {
                        return false;
                    }
                case 1921:
                    if (!key.equals("<=")) {
                        return false;
                    }
                    if (Double.parseDouble(obj.toString()) > Double.parseDouble(obj2)) {
                        return false;
                    }
                case 1952:
                    if (!key.equals("==")) {
                        return false;
                    }
                    return Intrinsics.areEqual(obj.toString(), obj2);
                case 1983:
                    if (!key.equals(">=")) {
                        return false;
                    }
                    if (Double.parseDouble(obj.toString()) < Double.parseDouble(obj2)) {
                        return false;
                    }
                case 3244:
                    if (!key.equals("eq")) {
                        return false;
                    }
                    return Intrinsics.areEqual(obj.toString(), obj2);
                case 3294:
                    if (!key.equals("ge")) {
                        return false;
                    }
                    if (Double.parseDouble(obj.toString()) < Double.parseDouble(obj2)) {
                    }
                    break;
                case 3309:
                    if (!key.equals("gt")) {
                        return false;
                    }
                    if (Double.parseDouble(obj.toString()) > Double.parseDouble(obj2)) {
                    }
                    break;
                case 3365:
                    if (!key.equals("in")) {
                        return false;
                    }
                    if (stringArrayList != null) {
                    }
                    break;
                case 3449:
                    if (!key.equals("le")) {
                        return false;
                    }
                    if (Double.parseDouble(obj.toString()) > Double.parseDouble(obj2)) {
                    }
                    break;
                case 3464:
                    if (!key.equals("lt")) {
                        return false;
                    }
                    if (Double.parseDouble(obj.toString()) < Double.parseDouble(obj2)) {
                    }
                    break;
                case 3511:
                    if (!key.equals("ne")) {
                        return false;
                    }
                    if (Intrinsics.areEqual(obj.toString(), obj2)) {
                    }
                    break;
                case 102680:
                    if (!key.equals("gte")) {
                        return false;
                    }
                    if (Double.parseDouble(obj.toString()) < Double.parseDouble(obj2)) {
                    }
                    break;
                case 107485:
                    if (!key.equals("lte")) {
                        return false;
                    }
                    if (Double.parseDouble(obj.toString()) > Double.parseDouble(obj2)) {
                    }
                    break;
                case 108954:
                    if (!key.equals("neq")) {
                        return false;
                    }
                    if (Intrinsics.areEqual(obj.toString(), obj2)) {
                    }
                    break;
                case 127966736:
                    if (!key.equals("i_str_eq")) {
                        return false;
                    }
                    String obj7 = obj.toString();
                    if (obj7 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                    Locale locale5 = Locale.ROOT;
                    String lowerCase10 = obj7.toLowerCase(locale5);
                    Intrinsics.checkNotNullExpressionValue(lowerCase10, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
                    if (obj2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                    String lowerCase11 = obj2.toLowerCase(locale5);
                    Intrinsics.checkNotNullExpressionValue(lowerCase11, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
                    return Intrinsics.areEqual(lowerCase10, lowerCase11);
                case 127966857:
                    if (!key.equals("i_str_in")) {
                        return false;
                    }
                    if (stringArrayList == null) {
                        return false;
                    }
                    while (r9.hasNext()) {
                    }
                    return false;
                case 363990325:
                    if (!key.equals("i_contains")) {
                        return false;
                    }
                    String obj8 = obj.toString();
                    if (obj8 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                    Locale locale6 = Locale.ROOT;
                    String lowerCase12 = obj8.toLowerCase(locale6);
                    Intrinsics.checkNotNullExpressionValue(lowerCase12, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
                    if (obj2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                    String lowerCase13 = obj2.toLowerCase(locale6);
                    Intrinsics.checkNotNullExpressionValue(lowerCase13, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
                    return StringsKt.contains$default((CharSequence) lowerCase12, (CharSequence) lowerCase13, false, 2, (Object) null);
                case 1091487233:
                    if (!key.equals("i_is_not_any")) {
                        return false;
                    }
                    if (stringArrayList != null) {
                    }
                    break;
                case 1918401035:
                    if (!key.equals("not_contains") || StringsKt.contains$default((CharSequence) obj.toString(), (CharSequence) obj2, false, 2, (Object) null)) {
                        return false;
                    }
                case 1961112862:
                    if (!key.equals("i_starts_with")) {
                        return false;
                    }
                    String obj9 = obj.toString();
                    if (obj9 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                    Locale locale7 = Locale.ROOT;
                    String lowerCase14 = obj9.toLowerCase(locale7);
                    Intrinsics.checkNotNullExpressionValue(lowerCase14, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
                    if (obj2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                    String lowerCase15 = obj2.toLowerCase(locale7);
                    Intrinsics.checkNotNullExpressionValue(lowerCase15, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
                    return StringsKt.startsWith$default(lowerCase14, lowerCase15, false, 2, (Object) null);
                default:
                    return false;
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MACARuleMatchingManager.class);
            return false;
        }
    }
}
