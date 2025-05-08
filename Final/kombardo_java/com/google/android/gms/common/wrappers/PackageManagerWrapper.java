package com.google.android.gms.common.wrappers;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Binder;
import android.os.Process;
import com.google.android.gms.common.util.PlatformVersion;

/* loaded from: classes.dex */
public class PackageManagerWrapper {
    protected final Context zza;

    public PackageManagerWrapper(Context context) {
        this.zza = context;
    }

    public int checkCallingOrSelfPermission(String str) {
        return this.zza.checkCallingOrSelfPermission(str);
    }

    public int checkPermission(String str, String str2) {
        return this.zza.getPackageManager().checkPermission(str, str2);
    }

    public ApplicationInfo getApplicationInfo(String str, int i5) {
        return this.zza.getPackageManager().getApplicationInfo(str, i5);
    }

    public CharSequence getApplicationLabel(String str) {
        Context context = this.zza;
        return context.getPackageManager().getApplicationLabel(context.getPackageManager().getApplicationInfo(str, 0));
    }

    public PackageInfo getPackageInfo(String str, int i5) {
        return this.zza.getPackageManager().getPackageInfo(str, i5);
    }

    public boolean isCallerInstantApp() {
        String nameForUid;
        if (Binder.getCallingUid() == Process.myUid()) {
            return InstantApps.isInstantApp(this.zza);
        }
        if (!PlatformVersion.isAtLeastO() || (nameForUid = this.zza.getPackageManager().getNameForUid(Binder.getCallingUid())) == null) {
            return false;
        }
        return this.zza.getPackageManager().isInstantApp(nameForUid);
    }

    @TargetApi(19)
    public final boolean zza(int i5, String str) {
        try {
            AppOpsManager appOpsManager = (AppOpsManager) this.zza.getSystemService("appops");
            if (appOpsManager == null) {
                throw new NullPointerException("context.getSystemService(Context.APP_OPS_SERVICE) is null");
            }
            appOpsManager.checkPackage(i5, str);
            return true;
        } catch (SecurityException unused) {
            return false;
        }
    }
}
