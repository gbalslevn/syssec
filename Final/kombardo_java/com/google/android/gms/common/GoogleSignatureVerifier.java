package com.google.android.gms.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Set;

/* loaded from: classes.dex */
public class GoogleSignatureVerifier {
    private static GoogleSignatureVerifier zza;
    private static volatile Set zzb;
    private static volatile Set zzc;
    private final Context zzd;
    private volatile String zze;

    public GoogleSignatureVerifier(Context context) {
        this.zzd = context.getApplicationContext();
    }

    public static GoogleSignatureVerifier getInstance(Context context) {
        Preconditions.checkNotNull(context);
        synchronized (GoogleSignatureVerifier.class) {
            try {
                if (zza == null) {
                    zzn.zze(context);
                    zza = new GoogleSignatureVerifier(context);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zza;
    }

    static final zzj zza(PackageInfo packageInfo, zzj... zzjVarArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr != null) {
            if (signatureArr.length != 1) {
                Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
                return null;
            }
            zzk zzkVar = new zzk(packageInfo.signatures[0].toByteArray());
            for (int i5 = 0; i5 < zzjVarArr.length; i5++) {
                if (zzjVarArr[i5].equals(zzkVar)) {
                    return zzjVarArr[i5];
                }
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0047 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean zzb(PackageInfo packageInfo, boolean z5) {
        PackageInfo packageInfo2;
        if (z5) {
            if (packageInfo == null) {
                packageInfo2 = null;
                if (packageInfo != null && packageInfo2.signatures != null) {
                    if ((!z5 ? zza(packageInfo2, zzm.zza) : zza(packageInfo2, zzm.zza[0])) == null) {
                        return true;
                    }
                }
                return false;
            }
            if ("com.android.vending".equals(packageInfo.packageName) || "com.google.android.gms".equals(packageInfo.packageName)) {
                ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                z5 = (applicationInfo == null || (applicationInfo.flags & 129) == 0) ? false : true;
            }
        }
        packageInfo2 = packageInfo;
        if (packageInfo != null) {
            if ((!z5 ? zza(packageInfo2, zzm.zza) : zza(packageInfo2, zzm.zza[0])) == null) {
            }
        }
        return false;
    }

    @SuppressLint({"PackageManagerGetSignatures"})
    private final zzw zzc(String str, boolean z5, boolean z6) {
        zzw zzc2;
        ApplicationInfo applicationInfo;
        if (str == null) {
            return zzw.zzc("null pkg");
        }
        if (str.equals(this.zze)) {
            return zzw.zzb();
        }
        if (zzn.zzg()) {
            zzc2 = zzn.zzb(str, GooglePlayServicesUtilLight.honorsDebugCertificates(this.zzd), false, false);
        } else {
            try {
                PackageInfo packageInfo = this.zzd.getPackageManager().getPackageInfo(str, 64);
                boolean honorsDebugCertificates = GooglePlayServicesUtilLight.honorsDebugCertificates(this.zzd);
                if (packageInfo == null) {
                    zzc2 = zzw.zzc("null pkg");
                } else {
                    Signature[] signatureArr = packageInfo.signatures;
                    if (signatureArr == null || signatureArr.length != 1) {
                        zzc2 = zzw.zzc("single cert required");
                    } else {
                        zzk zzkVar = new zzk(packageInfo.signatures[0].toByteArray());
                        String str2 = packageInfo.packageName;
                        zzw zza2 = zzn.zza(str2, zzkVar, honorsDebugCertificates, false);
                        zzc2 = (!zza2.zza || (applicationInfo = packageInfo.applicationInfo) == null || (applicationInfo.flags & 2) == 0 || !zzn.zza(str2, zzkVar, false, true).zza) ? zza2 : zzw.zzc("debuggable release cert app rejected");
                    }
                }
            } catch (PackageManager.NameNotFoundException e5) {
                return zzw.zzd("no pkg ".concat(str), e5);
            }
        }
        if (zzc2.zza) {
            this.zze = str;
        }
        return zzc2;
    }

    public boolean isGooglePublicSignedPackage(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (zzb(packageInfo, false)) {
            return true;
        }
        if (zzb(packageInfo, true)) {
            if (GooglePlayServicesUtilLight.honorsDebugCertificates(this.zzd)) {
                return true;
            }
            Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        }
        return false;
    }

    public boolean isUidGoogleSigned(int i5) {
        zzw zzc2;
        int length;
        String[] packagesForUid = this.zzd.getPackageManager().getPackagesForUid(i5);
        if (packagesForUid != null && (length = packagesForUid.length) != 0) {
            zzc2 = null;
            int i6 = 0;
            while (true) {
                if (i6 >= length) {
                    Preconditions.checkNotNull(zzc2);
                    break;
                }
                zzc2 = zzc(packagesForUid[i6], false, false);
                if (zzc2.zza) {
                    break;
                }
                i6++;
            }
        } else {
            zzc2 = zzw.zzc("no pkgs");
        }
        zzc2.zze();
        return zzc2.zza;
    }
}
