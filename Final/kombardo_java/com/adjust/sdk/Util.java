package com.adjust.sdk;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.Uri;
import android.os.Build;
import android.os.LocaleList;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.adjust.sdk.GooglePlayServicesClient;
import com.adjust.sdk.scheduler.AsyncTaskExecutor;
import com.adjust.sdk.scheduler.SingleThreadFutureScheduler;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class Util {
    private static final String fieldReadErrorMessage = "Unable to read '%s' field in migration device with message (%s)";
    public static final DecimalFormat SecondsDisplayFormat = newLocalDecimalFormat();
    private static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'Z";
    public static final SimpleDateFormat dateFormatter = new SimpleDateFormat(DATE_FORMAT, Locale.US);
    private static volatile SingleThreadFutureScheduler playAdIdScheduler = null;

    /* loaded from: classes.dex */
    public class a implements Callable<Object> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f4172a;

        public a(Context context) {
            this.f4172a = context;
        }

        @Override // java.util.concurrent.Callable
        public final Object call() {
            try {
                return Reflection.getAdvertisingInfoObject(this.f4172a);
            } catch (Exception unused) {
                return null;
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Callable<String> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f4173a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f4174b;

        public b(Context context, Object obj) {
            this.f4173a = context;
            this.f4174b = obj;
        }

        @Override // java.util.concurrent.Callable
        public final String call() {
            return Reflection.getPlayAdId(this.f4173a, this.f4174b);
        }
    }

    /* loaded from: classes.dex */
    public class c implements Callable<Boolean> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f4175a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f4176b;

        public c(Context context, Object obj) {
            this.f4175a = context;
            this.f4176b = obj;
        }

        @Override // java.util.concurrent.Callable
        public final Boolean call() {
            return Reflection.isPlayTrackingEnabled(this.f4175a, this.f4176b);
        }
    }

    /* loaded from: classes.dex */
    public class d extends AsyncTaskExecutor<Context, String> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OnDeviceIdsRead f4177a;

        public d(OnDeviceIdsRead onDeviceIdsRead) {
            this.f4177a = onDeviceIdsRead;
        }

        @Override // com.adjust.sdk.scheduler.AsyncTaskExecutor
        public final String doInBackground(Context[] contextArr) {
            ILogger logger = AdjustFactory.getLogger();
            String googleAdId = Util.getGoogleAdId(contextArr[0]);
            logger.debug("GoogleAdId read " + googleAdId, new Object[0]);
            return googleAdId;
        }

        @Override // com.adjust.sdk.scheduler.AsyncTaskExecutor
        public final void onPostExecute(String str) {
            this.f4177a.onGoogleAdIdRead(str);
        }
    }

    public static boolean canReadNonPlayIds(AdjustConfig adjustConfig) {
        return (adjustConfig.playStoreKidsAppEnabled || adjustConfig.coppaCompliantEnabled) ? false : true;
    }

    public static boolean canReadPlayIds(AdjustConfig adjustConfig) {
        return (adjustConfig.playStoreKidsAppEnabled || adjustConfig.coppaCompliantEnabled) ? false : true;
    }

    public static boolean checkPermission(Context context, String str) {
        try {
            return context.checkCallingOrSelfPermission(str) == 0;
        } catch (Exception e5) {
            getLogger().debug("Unable to check permission '%s' with message (%s)", str, e5.getMessage());
            return false;
        }
    }

    public static String convertToHex(byte[] bArr) {
        return formatString("%0" + (bArr.length << 1) + "x", new BigInteger(1, bArr));
    }

    public static String createUuid() {
        return UUID.randomUUID().toString();
    }

    public static boolean equalBoolean(Boolean bool, Boolean bool2) {
        return equalObject(bool, bool2);
    }

    public static boolean equalEnum(Enum r02, Enum r12) {
        return equalObject(r02, r12);
    }

    public static boolean equalInt(Integer num, Integer num2) {
        return equalObject(num, num2);
    }

    public static boolean equalLong(Long l5, Long l6) {
        return equalObject(l5, l6);
    }

    public static boolean equalObject(Object obj, Object obj2) {
        return (obj == null || obj2 == null) ? obj == null && obj2 == null : obj.equals(obj2);
    }

    public static boolean equalString(String str, String str2) {
        return equalObject(str, str2);
    }

    public static boolean equalsDouble(Double d5, Double d6) {
        return (d5 == null || d6 == null) ? d5 == null && d6 == null : Double.doubleToLongBits(d5.doubleValue()) == Double.doubleToLongBits(d6.doubleValue());
    }

    public static String formatString(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static Object getAdvertisingInfoObject(Context context, long j5) {
        return runSyncInPlayAdIdSchedulerWithTimeout(context, new a(context), j5);
    }

    public static String getAndroidId(Context context) {
        return AndroidIdUtil.getAndroidId(context);
    }

    public static int getConnectivityType(Context context) {
        ConnectivityManager connectivityManager;
        NetworkCapabilities networkCapabilities;
        try {
            connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        } catch (Exception e5) {
            getLogger().warn("Couldn't read connectivity type (%s)", e5.getMessage());
        }
        if (connectivityManager == null) {
            return -1;
        }
        int i5 = Build.VERSION.SDK_INT;
        Network activeNetwork = connectivityManager.getActiveNetwork();
        if (activeNetwork == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) {
            return -1;
        }
        if (networkCapabilities.hasTransport(1)) {
            return 1;
        }
        if (networkCapabilities.hasTransport(0)) {
            return 0;
        }
        if (networkCapabilities.hasTransport(3)) {
            return 3;
        }
        if (networkCapabilities.hasTransport(4)) {
            return 4;
        }
        if (networkCapabilities.hasTransport(2)) {
            return 2;
        }
        if (networkCapabilities.hasTransport(5)) {
            return 5;
        }
        if (i5 < 27) {
            return -1;
        }
        return networkCapabilities.hasTransport(6) ? 6 : -1;
    }

    public static String getCpuAbi() {
        return null;
    }

    public static String getFireAdvertisingId(ContentResolver contentResolver) {
        if (contentResolver == null) {
            return null;
        }
        try {
            return Settings.Secure.getString(contentResolver, "advertising_id");
        } catch (Exception unused) {
            return null;
        }
    }

    public static Boolean getFireTrackingEnabled(ContentResolver contentResolver) {
        try {
            return Boolean.valueOf(Settings.Secure.getInt(contentResolver, "limit_ad_tracking") == 0);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getGoogleAdId(Context context) {
        String str;
        Object advertisingInfoObject;
        GooglePlayServicesClient.GooglePlayServicesInfo googlePlayServicesInfo;
        try {
            googlePlayServicesInfo = GooglePlayServicesClient.getGooglePlayServicesInfo(context, 11000L);
        } catch (Exception unused) {
        }
        if (googlePlayServicesInfo != null) {
            str = googlePlayServicesInfo.getGpsAdid();
            return (str != null || (advertisingInfoObject = getAdvertisingInfoObject(context, 11000L)) == null) ? str : getPlayAdId(context, advertisingInfoObject, 1000L);
        }
        str = null;
        if (str != null) {
            return str;
        }
    }

    public static Map<String, String> getImeiParameters(AdjustConfig adjustConfig, ILogger iLogger) {
        if (adjustConfig.coppaCompliantEnabled) {
            return null;
        }
        return Reflection.getImeiParameters(adjustConfig.context, iLogger);
    }

    public static Locale getLocale(Configuration configuration) {
        LocaleList locales = configuration.getLocales();
        if (locales == null || locales.isEmpty()) {
            return null;
        }
        return locales.get(0);
    }

    private static ILogger getLogger() {
        return AdjustFactory.getLogger();
    }

    public static String getMcc(Context context) {
        try {
            String networkOperator = ((TelephonyManager) context.getSystemService("phone")).getNetworkOperator();
            if (!TextUtils.isEmpty(networkOperator)) {
                return networkOperator.substring(0, 3);
            }
            AdjustFactory.getLogger().warn("Couldn't receive networkOperator string to read MCC", new Object[0]);
            return null;
        } catch (Exception unused) {
            AdjustFactory.getLogger().warn("Couldn't return mcc", new Object[0]);
            return null;
        }
    }

    public static String getMnc(Context context) {
        try {
            String networkOperator = ((TelephonyManager) context.getSystemService("phone")).getNetworkOperator();
            if (!TextUtils.isEmpty(networkOperator)) {
                return networkOperator.substring(3);
            }
            AdjustFactory.getLogger().warn("Couldn't receive networkOperator string to read MNC", new Object[0]);
            return null;
        } catch (Exception unused) {
            AdjustFactory.getLogger().warn("Couldn't return mnc", new Object[0]);
            return null;
        }
    }

    public static Map<String, String> getOaidParameters(AdjustConfig adjustConfig, ILogger iLogger) {
        if (adjustConfig.coppaCompliantEnabled) {
            return null;
        }
        return Reflection.getOaidParameters(adjustConfig.context, iLogger);
    }

    public static String getPlayAdId(Context context, Object obj, long j5) {
        return (String) runSyncInPlayAdIdSchedulerWithTimeout(context, new b(context, obj), j5);
    }

    public static String getReasonString(String str, Throwable th) {
        return th != null ? formatString("%s: %s", str, th) : formatString("%s", str);
    }

    public static String getRootCause(Exception exc) {
        if (!hasRootCause(exc)) {
            return null;
        }
        StringWriter stringWriter = new StringWriter();
        exc.printStackTrace(new PrintWriter(stringWriter));
        String stringWriter2 = stringWriter.toString();
        int indexOf = stringWriter2.indexOf("Caused by:");
        return stringWriter2.substring(indexOf, stringWriter2.indexOf("\n", indexOf));
    }

    private static String getSdkPrefix(String str) {
        String[] split;
        if (str != null && str.contains("@") && (split = str.split("@")) != null && split.length == 2) {
            return split[0];
        }
        return null;
    }

    public static String getSdkPrefixPlatform(String str) {
        String[] split;
        String sdkPrefix = getSdkPrefix(str);
        if (sdkPrefix == null || (split = sdkPrefix.split("\\d+", 2)) == null || split.length == 0) {
            return null;
        }
        return split[0];
    }

    public static String getSdkVersion() {
        return Constants.CLIENT_SDK;
    }

    public static String[] getSupportedAbis() {
        return Build.SUPPORTED_ABIS;
    }

    public static long getWaitingTime(int i5, BackoffStrategy backoffStrategy) {
        if (i5 < backoffStrategy.minRetries) {
            return 0L;
        }
        return (long) (Math.min(((long) Math.pow(2.0d, i5 - r0)) * backoffStrategy.milliSecondMultiplier, backoffStrategy.maxWait) * randomInRange(backoffStrategy.minRange, backoffStrategy.maxRange));
    }

    public static boolean hasRootCause(Exception exc) {
        StringWriter stringWriter = new StringWriter();
        exc.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString().contains("Caused by:");
    }

    public static String hash(String str, String str2) {
        try {
            byte[] bytes = str.getBytes(Constants.ENCODING);
            MessageDigest messageDigest = MessageDigest.getInstance(str2);
            messageDigest.update(bytes, 0, bytes.length);
            return convertToHex(messageDigest.digest());
        } catch (Exception unused) {
            return null;
        }
    }

    public static int hashBoolean(Boolean bool, int i5) {
        int i6 = i5 * 37;
        return bool == null ? i6 : bool.hashCode() + i6;
    }

    public static int hashDouble(Double d5, int i5) {
        int i6 = i5 * 37;
        return d5 == null ? i6 : d5.hashCode() + i6;
    }

    public static int hashEnum(Enum r02, int i5) {
        int i6 = i5 * 37;
        return r02 == null ? i6 : r02.hashCode() + i6;
    }

    public static int hashLong(Long l5, int i5) {
        int i6 = i5 * 37;
        return l5 == null ? i6 : l5.hashCode() + i6;
    }

    public static int hashObject(Object obj, int i5) {
        int i6 = i5 * 37;
        return obj == null ? i6 : obj.hashCode() + i6;
    }

    public static int hashString(String str, int i5) {
        int i6 = i5 * 37;
        return str == null ? i6 : str.hashCode() + i6;
    }

    public static boolean isAdjustUninstallDetectionPayload(Map<String, String> map) {
        return map != null && map.size() == 1 && Objects.equals(map.get(Constants.FCM_PAYLOAD_KEY), Constants.FCM_PAYLOAD_VALUE);
    }

    private static boolean isEqualGoogleReferrerDetails(ReferrerDetails referrerDetails, ActivityState activityState) {
        return referrerDetails.referrerClickTimestampSeconds == activityState.clickTime && referrerDetails.installBeginTimestampSeconds == activityState.installBegin && referrerDetails.referrerClickTimestampServerSeconds == activityState.clickTimeServer && referrerDetails.installBeginTimestampServerSeconds == activityState.installBeginServer && equalString(referrerDetails.installReferrer, activityState.installReferrer) && equalString(referrerDetails.installVersion, activityState.installVersion) && equalBoolean(referrerDetails.googlePlayInstant, activityState.googlePlayInstant);
    }

    private static boolean isEqualHuaweiReferrerAdsDetails(ReferrerDetails referrerDetails, ActivityState activityState) {
        return referrerDetails.referrerClickTimestampSeconds == activityState.clickTimeHuawei && referrerDetails.installBeginTimestampSeconds == activityState.installBeginHuawei && equalString(referrerDetails.installReferrer, activityState.installReferrerHuawei);
    }

    private static boolean isEqualHuaweiReferrerAppGalleryDetails(ReferrerDetails referrerDetails, ActivityState activityState) {
        return referrerDetails.referrerClickTimestampSeconds == activityState.clickTimeHuawei && referrerDetails.installBeginTimestampSeconds == activityState.installBeginHuawei && equalString(referrerDetails.installReferrer, activityState.installReferrerHuaweiAppGallery);
    }

    public static boolean isEqualReferrerDetails(ReferrerDetails referrerDetails, String str, ActivityState activityState) {
        if (str.equals(Constants.REFERRER_API_GOOGLE)) {
            return isEqualGoogleReferrerDetails(referrerDetails, activityState);
        }
        if (str.equals(Constants.REFERRER_API_HUAWEI_ADS)) {
            return isEqualHuaweiReferrerAdsDetails(referrerDetails, activityState);
        }
        if (str.equals(Constants.REFERRER_API_HUAWEI_APP_GALLERY)) {
            return isEqualHuaweiReferrerAppGalleryDetails(referrerDetails, activityState);
        }
        if (str.equals(Constants.REFERRER_API_SAMSUNG)) {
            return isEqualSamsungReferrerDetails(referrerDetails, activityState);
        }
        if (str.equals(Constants.REFERRER_API_XIAOMI)) {
            return isEqualXiaomiReferrerDetails(referrerDetails, activityState);
        }
        if (str.equals(Constants.REFERRER_API_VIVO)) {
            return isEqualVivoReferrerDetails(referrerDetails, activityState);
        }
        return false;
    }

    private static boolean isEqualSamsungReferrerDetails(ReferrerDetails referrerDetails, ActivityState activityState) {
        return referrerDetails.referrerClickTimestampSeconds == activityState.clickTimeSamsung && referrerDetails.installBeginTimestampSeconds == activityState.installBeginSamsung && equalString(referrerDetails.installReferrer, activityState.installReferrerSamsung);
    }

    private static boolean isEqualVivoReferrerDetails(ReferrerDetails referrerDetails, ActivityState activityState) {
        return referrerDetails.referrerClickTimestampSeconds == activityState.clickTimeVivo && referrerDetails.installBeginTimestampSeconds == activityState.installBeginVivo && equalString(referrerDetails.installReferrer, activityState.installReferrerVivo) && equalString(referrerDetails.installVersion, activityState.installVersionVivo);
    }

    private static boolean isEqualXiaomiReferrerDetails(ReferrerDetails referrerDetails, ActivityState activityState) {
        return referrerDetails.referrerClickTimestampSeconds == activityState.clickTimeXiaomi && referrerDetails.installBeginTimestampSeconds == activityState.installBeginXiaomi && referrerDetails.referrerClickTimestampServerSeconds == activityState.clickTimeServerXiaomi && referrerDetails.installBeginTimestampServerSeconds == activityState.installBeginServerXiaomi && equalString(referrerDetails.installReferrer, activityState.installReferrerXiaomi) && equalString(referrerDetails.installVersion, activityState.installVersionXiaomi);
    }

    public static Boolean isPlayTrackingEnabled(Context context, Object obj, long j5) {
        return (Boolean) runSyncInPlayAdIdSchedulerWithTimeout(context, new c(context, obj), j5);
    }

    public static boolean isUrlFilteredOut(Uri uri) {
        String uri2;
        return uri == null || (uri2 = uri.toString()) == null || uri2.length() == 0 || uri2.matches(Constants.FB_AUTH_REGEX);
    }

    public static boolean isValidParameter(String str, String str2, String str3) {
        if (str == null) {
            getLogger().error("%s parameter %s is missing", str3, str2);
            return false;
        }
        if (!str.equals(org.conscrypt.BuildConfig.FLAVOR)) {
            return true;
        }
        getLogger().error("%s parameter %s is empty", str3, str2);
        return false;
    }

    public static Map<String, String> mergeParameters(Map<String, String> map, Map<String, String> map2, String str) {
        if (map == null) {
            return map2;
        }
        if (map2 == null) {
            return map;
        }
        HashMap hashMap = new HashMap(map);
        ILogger logger = getLogger();
        for (Map.Entry<String, String> entry : map2.entrySet()) {
            String str2 = (String) hashMap.put(entry.getKey(), entry.getValue());
            if (str2 != null) {
                logger.warn("Key %s with value %s from %s parameter was replaced by value %s", entry.getKey(), str2, str, entry.getValue());
            }
        }
        return hashMap;
    }

    private static DecimalFormat newLocalDecimalFormat() {
        return new DecimalFormat("0.0", new DecimalFormatSymbols(Locale.US));
    }

    public static String quote(String str) {
        if (str == null) {
            return null;
        }
        return !Pattern.compile("\\s").matcher(str).find() ? str : formatString("'%s'", str);
    }

    private static double randomInRange(double d5, double d6) {
        return (new Random().nextDouble() * (d6 - d5)) + d5;
    }

    public static boolean readBooleanField(ObjectInputStream.GetField getField, String str, boolean z5) {
        try {
            return getField.get(str, z5);
        } catch (Exception e5) {
            getLogger().debug(fieldReadErrorMessage, str, e5.getMessage());
            return z5;
        }
    }

    public static int readIntField(ObjectInputStream.GetField getField, String str, int i5) {
        try {
            return getField.get(str, i5);
        } catch (Exception e5) {
            getLogger().debug(fieldReadErrorMessage, str, e5.getMessage());
            return i5;
        }
    }

    public static long readLongField(ObjectInputStream.GetField getField, String str, long j5) {
        try {
            return getField.get(str, j5);
        } catch (Exception e5) {
            getLogger().debug(fieldReadErrorMessage, str, e5.getMessage());
            return j5;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0096 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v10, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r3v13, types: [java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v19, types: [java.io.ObjectInputStream] */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r4v10, types: [java.io.BufferedInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static <T> T readObject(Context context, String str, String str2, Class<T> cls) {
        T t5;
        T t6;
        Exception e5;
        ?? r42;
        Object obj;
        ?? r32;
        T t7 = null;
        try {
            r32 = context.openFileInput(str);
            try {
                r42 = new BufferedInputStream(r32);
            } catch (FileNotFoundException unused) {
                T t8 = t7;
                t7 = r32;
                t6 = t8;
                r42 = t7;
                t7 = t6;
                getLogger().debug("%s file not found", str2);
                obj = r42;
                r32 = obj;
                if (r32 != 0) {
                }
                return t7;
            } catch (Exception e6) {
                e = e6;
                T t9 = t7;
                t7 = r32;
                t5 = t9;
                T t10 = t7;
                t7 = t5;
                e5 = e;
                r42 = t10;
                getLogger().error("Failed to open %s file for reading (%s)", str2, e5);
                obj = r42;
                r32 = obj;
                if (r32 != 0) {
                }
                return t7;
            }
        } catch (FileNotFoundException unused2) {
            t6 = null;
        } catch (Exception e7) {
            e = e7;
            t5 = null;
        }
        try {
            r32 = new ObjectInputStream(r42);
            try {
                t7 = cls.cast(r32.readObject());
                getLogger().debug("Read %s: %s", str2, t7);
            } catch (ClassCastException e8) {
                getLogger().error("Failed to cast %s object (%s)", str2, e8.getMessage());
            } catch (ClassNotFoundException e9) {
                getLogger().error("Failed to find %s class (%s)", str2, e9.getMessage());
            } catch (Exception e10) {
                getLogger().error("Failed to read %s object (%s)", str2, e10.getMessage());
            }
        } catch (FileNotFoundException unused3) {
            getLogger().debug("%s file not found", str2);
            obj = r42;
            r32 = obj;
            if (r32 != 0) {
            }
            return t7;
        } catch (Exception e11) {
            e5 = e11;
            getLogger().error("Failed to open %s file for reading (%s)", str2, e5);
            obj = r42;
            r32 = obj;
            if (r32 != 0) {
            }
            return t7;
        }
        if (r32 != 0) {
            try {
                r32.close();
            } catch (Exception e12) {
                getLogger().error("Failed to close %s file for reading (%s)", str2, e12);
            }
        }
        return t7;
    }

    public static <T> T readObjectField(ObjectInputStream.GetField getField, String str, T t5) {
        try {
            return (T) getField.get(str, t5);
        } catch (Exception e5) {
            getLogger().debug(fieldReadErrorMessage, str, e5.getMessage());
            return t5;
        }
    }

    public static String readStringField(ObjectInputStream.GetField getField, String str, String str2) {
        return (String) readObjectField(getField, str, str2);
    }

    public static boolean resolveContentProvider(Context context, String str) {
        try {
            return context.getPackageManager().resolveContentProvider(str, 0) != null;
        } catch (Exception unused) {
            return false;
        }
    }

    private static <R> R runSyncInPlayAdIdSchedulerWithTimeout(Context context, Callable<R> callable, long j5) {
        if (playAdIdScheduler == null) {
            synchronized (Util.class) {
                try {
                    if (playAdIdScheduler == null) {
                        playAdIdScheduler = new SingleThreadFutureScheduler("PlayAdIdLibrary", true);
                    }
                } finally {
                }
            }
        }
        try {
            return (R) playAdIdScheduler.scheduleFutureWithReturn(callable, 0L).get(j5, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException unused) {
            return null;
        }
    }

    public static String sha256(String str) {
        return hash(str, Constants.SHA256);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0045 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.io.OutputStream, java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.io.ObjectOutputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static <T> void writeObject(T t5, Context context, String str, String str2) {
        ?? r22;
        BufferedOutputStream bufferedOutputStream;
        try {
            r22 = context.openFileOutput(str, 0);
            try {
                bufferedOutputStream = new BufferedOutputStream(r22);
                try {
                    r22 = new ObjectOutputStream(bufferedOutputStream);
                    try {
                        r22.writeObject(t5);
                        getLogger().debug("Wrote %s: %s", str2, t5);
                    } catch (NotSerializableException unused) {
                        getLogger().error("Failed to serialize %s", str2);
                    }
                } catch (Exception e5) {
                    e = e5;
                    getLogger().error("Failed to open %s for writing (%s)", str2, e);
                    r22 = bufferedOutputStream;
                    if (r22 != 0) {
                    }
                }
            } catch (Exception e6) {
                e = e6;
                bufferedOutputStream = r22;
                getLogger().error("Failed to open %s for writing (%s)", str2, e);
                r22 = bufferedOutputStream;
                if (r22 != 0) {
                }
            }
        } catch (Exception e7) {
            e = e7;
            r22 = 0;
        }
        if (r22 != 0) {
            try {
                r22.close();
            } catch (Exception e8) {
                getLogger().error("Failed to close %s file for writing (%s)", str2, e8);
            }
        }
    }

    public static String getFireAdvertisingId(AdjustConfig adjustConfig) {
        if (adjustConfig.coppaCompliantEnabled) {
            return null;
        }
        return getFireAdvertisingId(adjustConfig.context.getContentResolver());
    }

    public static Boolean getFireTrackingEnabled(AdjustConfig adjustConfig) {
        if (adjustConfig.coppaCompliantEnabled) {
            return null;
        }
        return getFireTrackingEnabled(adjustConfig.context.getContentResolver());
    }

    public static void getGoogleAdId(Context context, OnDeviceIdsRead onDeviceIdsRead) {
        new d(onDeviceIdsRead).execute(context);
    }
}
