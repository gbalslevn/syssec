package com.google.firebase.crashlytics.internal.common;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Debug;
import android.os.StatFs;
import android.text.TextUtils;
import com.google.firebase.crashlytics.internal.Logger;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import org.conscrypt.BuildConfig;

/* loaded from: classes2.dex */
public abstract class CommonUtils {
    private static final String GOLDFISH = "goldfish";
    private static final char[] HEX_VALUES = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final String RANCHU = "ranchu";
    private static final String SDK = "sdk";
    private static final String SHA1_INSTANCE = "SHA-1";

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v0 com.google.firebase.crashlytics.internal.common.CommonUtils$Architecture, still in use, count: 1, list:
      (r0v0 com.google.firebase.crashlytics.internal.common.CommonUtils$Architecture) from 0x0084: INVOKE (r5v5 java.util.HashMap), ("x86"), (r0v0 com.google.firebase.crashlytics.internal.common.CommonUtils$Architecture) INTERFACE call: java.util.Map.put(java.lang.Object, java.lang.Object):java.lang.Object A[MD:(K, V):V (c)]
    	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:151)
    	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:116)
    	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:88)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1597)
    	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:87)
    	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:238)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:180)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    static final class Architecture {
        X86_32,
        X86_64,
        ARM_UNKNOWN,
        PPC,
        PPC64,
        ARMV6,
        ARMV7,
        UNKNOWN,
        ARMV7S,
        ARM64;

        private static final Map<String, Architecture> matcher;

        static {
            HashMap hashMap = new HashMap(4);
            matcher = hashMap;
            hashMap.put("armeabi-v7a", new Architecture());
            hashMap.put("armeabi", new Architecture());
            hashMap.put("arm64-v8a", new Architecture());
            hashMap.put("x86", new Architecture());
        }

        private Architecture() {
        }

        static Architecture getValue() {
            String str = Build.CPU_ABI;
            if (TextUtils.isEmpty(str)) {
                Logger.getLogger().v("Architecture#getValue()::Build.CPU_ABI returned null or empty");
                return UNKNOWN;
            }
            Architecture architecture = matcher.get(str.toLowerCase(Locale.US));
            return architecture == null ? UNKNOWN : architecture;
        }

        public static Architecture valueOf(String str) {
            return (Architecture) Enum.valueOf(Architecture.class, str);
        }

        public static Architecture[] values() {
            return (Architecture[]) $VALUES.clone();
        }
    }

    public static long calculateFreeRamInBytes(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    public static synchronized long calculateTotalRamInBytes(Context context) {
        long j5;
        synchronized (CommonUtils.class) {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
            j5 = memoryInfo.totalMem;
        }
        return j5;
    }

    public static long calculateUsedDiskSpaceInBytes(String str) {
        long blockSize = new StatFs(str).getBlockSize();
        return (r0.getBlockCount() * blockSize) - (blockSize * r0.getAvailableBlocks());
    }

    @SuppressLint({"MissingPermission"})
    public static boolean canTryConnection(Context context) {
        if (!checkPermission(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return true;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    public static boolean checkPermission(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }

    public static void closeOrLog(Closeable closeable, String str) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e5) {
                Logger.getLogger().e(str, e5);
            }
        }
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e5) {
                throw e5;
            } catch (Exception unused) {
            }
        }
    }

    public static String createInstanceIdFrom(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (str != null) {
                arrayList.add(str.replace("-", BuildConfig.FLAVOR).toLowerCase(Locale.US));
            }
        }
        Collections.sort(arrayList);
        StringBuilder sb = new StringBuilder();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            sb.append((String) it.next());
        }
        String sb2 = sb.toString();
        if (sb2.length() > 0) {
            return sha1(sb2);
        }
        return null;
    }

    public static boolean getBooleanResourceValue(Context context, String str, boolean z5) {
        Resources resources;
        if (context != null && (resources = context.getResources()) != null) {
            int resourcesIdentifier = getResourcesIdentifier(context, str, "bool");
            if (resourcesIdentifier > 0) {
                return resources.getBoolean(resourcesIdentifier);
            }
            int resourcesIdentifier2 = getResourcesIdentifier(context, str, "string");
            if (resourcesIdentifier2 > 0) {
                return Boolean.parseBoolean(context.getString(resourcesIdentifier2));
            }
        }
        return z5;
    }

    public static List<BuildIdInfo> getBuildIdInfo(Context context) {
        ArrayList arrayList = new ArrayList();
        int resourcesIdentifier = getResourcesIdentifier(context, "com.google.firebase.crashlytics.build_ids_lib", "array");
        int resourcesIdentifier2 = getResourcesIdentifier(context, "com.google.firebase.crashlytics.build_ids_arch", "array");
        int resourcesIdentifier3 = getResourcesIdentifier(context, "com.google.firebase.crashlytics.build_ids_build_id", "array");
        if (resourcesIdentifier == 0 || resourcesIdentifier2 == 0 || resourcesIdentifier3 == 0) {
            Logger.getLogger().d(String.format("Could not find resources: %d %d %d", Integer.valueOf(resourcesIdentifier), Integer.valueOf(resourcesIdentifier2), Integer.valueOf(resourcesIdentifier3)));
            return arrayList;
        }
        String[] stringArray = context.getResources().getStringArray(resourcesIdentifier);
        String[] stringArray2 = context.getResources().getStringArray(resourcesIdentifier2);
        String[] stringArray3 = context.getResources().getStringArray(resourcesIdentifier3);
        if (stringArray.length != stringArray3.length || stringArray2.length != stringArray3.length) {
            Logger.getLogger().d(String.format("Lengths did not match: %d %d %d", Integer.valueOf(stringArray.length), Integer.valueOf(stringArray2.length), Integer.valueOf(stringArray3.length)));
            return arrayList;
        }
        for (int i5 = 0; i5 < stringArray3.length; i5++) {
            arrayList.add(new BuildIdInfo(stringArray[i5], stringArray2[i5], stringArray3[i5]));
        }
        return arrayList;
    }

    public static int getCpuArchitectureInt() {
        return Architecture.getValue().ordinal();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    public static int getDeviceState() {
        boolean isEmulator = isEmulator();
        ?? r02 = isEmulator;
        if (isRooted()) {
            r02 = (isEmulator ? 1 : 0) | 2;
        }
        return isDebuggerAttached() ? r02 | 4 : r02;
    }

    public static String getMappingFileId(Context context) {
        int resourcesIdentifier = getResourcesIdentifier(context, "com.google.firebase.crashlytics.mapping_file_id", "string");
        if (resourcesIdentifier == 0) {
            resourcesIdentifier = getResourcesIdentifier(context, "com.crashlytics.android.build_id", "string");
        }
        if (resourcesIdentifier != 0) {
            return context.getResources().getString(resourcesIdentifier);
        }
        return null;
    }

    public static boolean getProximitySensorEnabled(Context context) {
        return (isEmulator() || ((SensorManager) context.getSystemService("sensor")).getDefaultSensor(8) == null) ? false : true;
    }

    public static String getResourcePackageName(Context context) {
        int i5 = context.getApplicationContext().getApplicationInfo().icon;
        if (i5 <= 0) {
            return context.getPackageName();
        }
        try {
            String resourcePackageName = context.getResources().getResourcePackageName(i5);
            return "android".equals(resourcePackageName) ? context.getPackageName() : resourcePackageName;
        } catch (Resources.NotFoundException unused) {
            return context.getPackageName();
        }
    }

    public static int getResourcesIdentifier(Context context, String str, String str2) {
        return context.getResources().getIdentifier(str, str2, getResourcePackageName(context));
    }

    public static SharedPreferences getSharedPrefs(Context context) {
        return context.getSharedPreferences("com.google.firebase.crashlytics", 0);
    }

    private static String hash(String str, String str2) {
        return hash(str.getBytes(), str2);
    }

    public static String hexify(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i5 = 0; i5 < bArr.length; i5++) {
            byte b5 = bArr[i5];
            int i6 = i5 * 2;
            char[] cArr2 = HEX_VALUES;
            cArr[i6] = cArr2[(b5 & 255) >>> 4];
            cArr[i6 + 1] = cArr2[b5 & 15];
        }
        return new String(cArr);
    }

    public static boolean isAppDebuggable(Context context) {
        return (context.getApplicationInfo().flags & 2) != 0;
    }

    public static boolean isDebuggerAttached() {
        return Debug.isDebuggerConnected() || Debug.waitingForDebugger();
    }

    public static boolean isEmulator() {
        if (!Build.PRODUCT.contains(SDK)) {
            String str = Build.HARDWARE;
            if (!str.contains(GOLDFISH) && !str.contains(RANCHU)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isRooted() {
        boolean isEmulator = isEmulator();
        String str = Build.TAGS;
        if ((isEmulator || str == null || !str.contains("test-keys")) && !new File("/system/app/Superuser.apk").exists()) {
            return !isEmulator && new File("/system/xbin/su").exists();
        }
        return true;
    }

    public static boolean nullSafeEquals(String str, String str2) {
        return str == null ? str2 == null : str.equals(str2);
    }

    public static String sha1(String str) {
        return hash(str, SHA1_INSTANCE);
    }

    public static String streamToString(InputStream inputStream) {
        Scanner useDelimiter = new Scanner(inputStream).useDelimiter("\\A");
        return useDelimiter.hasNext() ? useDelimiter.next() : BuildConfig.FLAVOR;
    }

    private static String hash(byte[] bArr, String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            messageDigest.update(bArr);
            return hexify(messageDigest.digest());
        } catch (NoSuchAlgorithmException e5) {
            Logger.getLogger().e("Could not create hashing algorithm: " + str + ", returning empty string.", e5);
            return BuildConfig.FLAVOR;
        }
    }
}
