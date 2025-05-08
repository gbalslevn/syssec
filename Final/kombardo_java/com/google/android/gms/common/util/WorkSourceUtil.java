package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import android.os.WorkSource;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.wrappers.Wrappers;
import java.lang.reflect.Method;
import org.conscrypt.BuildConfig;

/* loaded from: classes.dex */
public abstract class WorkSourceUtil {
    private static final int zza = Process.myUid();
    private static final Method zzb;
    private static final Method zzc;
    private static final Method zzd;
    private static final Method zze;
    private static final Method zzf;
    private static final Method zzg;
    private static final Method zzh;
    private static final Method zzi;
    private static Boolean zzj;

    /* JADX WARN: Removed duplicated region for block: B:28:0x0094 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0072 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    static {
        Method method;
        Method method2;
        Method method3;
        Method method4;
        Method method5;
        Method method6;
        Method method7;
        Method method8;
        try {
            method = WorkSource.class.getMethod("add", Integer.TYPE);
        } catch (Exception unused) {
            method = null;
        }
        zzb = method;
        try {
            method2 = WorkSource.class.getMethod("add", Integer.TYPE, String.class);
        } catch (Exception unused2) {
            method2 = null;
        }
        zzc = method2;
        try {
            method3 = WorkSource.class.getMethod("size", null);
        } catch (Exception unused3) {
            method3 = null;
        }
        zzd = method3;
        try {
            method4 = WorkSource.class.getMethod("get", Integer.TYPE);
        } catch (Exception unused4) {
            method4 = null;
        }
        zze = method4;
        try {
            method5 = WorkSource.class.getMethod("getName", Integer.TYPE);
        } catch (Exception unused5) {
            method5 = null;
        }
        zzf = method5;
        if (PlatformVersion.isAtLeastP()) {
            try {
                method6 = WorkSource.class.getMethod("createWorkChain", null);
            } catch (Exception e5) {
                Log.w("WorkSourceUtil", "Missing WorkChain API createWorkChain", e5);
            }
            zzg = method6;
            if (PlatformVersion.isAtLeastP()) {
                try {
                    method7 = Class.forName("android.os.WorkSource$WorkChain").getMethod("addNode", Integer.TYPE, String.class);
                } catch (Exception e6) {
                    Log.w("WorkSourceUtil", "Missing WorkChain class", e6);
                }
                zzh = method7;
                if (PlatformVersion.isAtLeastP()) {
                    try {
                        method8 = WorkSource.class.getMethod("isEmpty", null);
                        try {
                            method8.setAccessible(true);
                        } catch (Exception unused6) {
                        }
                    } catch (Exception unused7) {
                    }
                    zzi = method8;
                    zzj = null;
                }
                method8 = null;
                zzi = method8;
                zzj = null;
            }
            method7 = null;
            zzh = method7;
            if (PlatformVersion.isAtLeastP()) {
            }
            method8 = null;
            zzi = method8;
            zzj = null;
        }
        method6 = null;
        zzg = method6;
        if (PlatformVersion.isAtLeastP()) {
        }
        method7 = null;
        zzh = method7;
        if (PlatformVersion.isAtLeastP()) {
        }
        method8 = null;
        zzi = method8;
        zzj = null;
    }

    public static void add(WorkSource workSource, int i5, String str) {
        Method method = zzc;
        if (method != null) {
            if (str == null) {
                str = BuildConfig.FLAVOR;
            }
            try {
                method.invoke(workSource, Integer.valueOf(i5), str);
                return;
            } catch (Exception e5) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e5);
                return;
            }
        }
        Method method2 = zzb;
        if (method2 != null) {
            try {
                method2.invoke(workSource, Integer.valueOf(i5));
            } catch (Exception e6) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e6);
            }
        }
    }

    public static WorkSource fromPackage(Context context, String str) {
        if (context != null && context.getPackageManager() != null && str != null) {
            try {
                ApplicationInfo applicationInfo = Wrappers.packageManager(context).getApplicationInfo(str, 0);
                if (applicationInfo == null) {
                    Log.e("WorkSourceUtil", "Could not get applicationInfo from package: ".concat(str));
                    return null;
                }
                int i5 = applicationInfo.uid;
                WorkSource workSource = new WorkSource();
                add(workSource, i5, str);
                return workSource;
            } catch (PackageManager.NameNotFoundException unused) {
                Log.e("WorkSourceUtil", "Could not find package: ".concat(str));
            }
        }
        return null;
    }

    public static synchronized boolean hasWorkSourcePermission(Context context) {
        synchronized (WorkSourceUtil.class) {
            Boolean bool = zzj;
            if (bool != null) {
                return bool.booleanValue();
            }
            if (context == null) {
                return false;
            }
            boolean z5 = ContextCompat.checkSelfPermission(context, "android.permission.UPDATE_DEVICE_STATS") == 0;
            zzj = Boolean.valueOf(z5);
            return z5;
        }
    }

    public static boolean isEmpty(WorkSource workSource) {
        Method method = zzi;
        if (method != null) {
            try {
                Object invoke = method.invoke(workSource, null);
                Preconditions.checkNotNull(invoke);
                return ((Boolean) invoke).booleanValue();
            } catch (Exception e5) {
                Log.e("WorkSourceUtil", "Unable to check WorkSource emptiness", e5);
            }
        }
        return size(workSource) == 0;
    }

    public static int size(WorkSource workSource) {
        Method method = zzd;
        if (method == null) {
            return 0;
        }
        try {
            Object invoke = method.invoke(workSource, null);
            Preconditions.checkNotNull(invoke);
            return ((Integer) invoke).intValue();
        } catch (Exception e5) {
            Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e5);
            return 0;
        }
    }
}
