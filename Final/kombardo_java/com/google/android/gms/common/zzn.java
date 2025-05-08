package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.Log;
import com.adjust.sdk.Constants;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzaf;
import com.google.android.gms.common.internal.zzag;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import java.security.MessageDigest;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class zzn {
    private static volatile zzag zze;
    private static Context zzg;
    static final zzl zza = new zzf(zzj.zze("0\u0082\u0005È0\u0082\u0003° \u0003\u0002\u0001\u0002\u0002\u0014\u0010\u008ae\bsù/\u008eQí"));
    static final zzl zzb = new zzg(zzj.zze("0\u0082\u0006\u00040\u0082\u0003ì \u0003\u0002\u0001\u0002\u0002\u0014\u0003£²\u00ad×árÊkì"));
    static final zzl zzc = new zzh(zzj.zze("0\u0082\u0004C0\u0082\u0003+ \u0003\u0002\u0001\u0002\u0002\t\u0000Âà\u0087FdJ0\u008d0"));
    static final zzl zzd = new zzi(zzj.zze("0\u0082\u0004¨0\u0082\u0003\u0090 \u0003\u0002\u0001\u0002\u0002\t\u0000Õ\u0085¸l}ÓNõ0"));
    private static final Object zzf = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzw zza(String str, zzj zzjVar, boolean z5, boolean z6) {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            return zzh(str, zzjVar, z5, z6);
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzw zzb(String str, boolean z5, boolean z6, boolean z7) {
        return zzi(str, z5, false, false, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ String zzd(boolean z5, String str, zzj zzjVar) {
        String str2 = (z5 || !zzh(str, zzjVar, true, false).zza) ? "not allowed" : "debug cert rejected";
        MessageDigest zza2 = AndroidUtilsLight.zza(Constants.SHA256);
        Preconditions.checkNotNull(zza2);
        return String.format("%s: pkg=%s, sha256=%s, atk=%s, ver=%s", str2, str, Hex.bytesToStringLowercase(zza2.digest(zzjVar.zzf())), Boolean.valueOf(z5), "12451000.false");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void zze(Context context) {
        synchronized (zzn.class) {
            if (zzg != null) {
                Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
            } else if (context != null) {
                zzg = context.getApplicationContext();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzg() {
        boolean z5;
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            try {
                zzj();
                z5 = zze.zzi();
            } finally {
                StrictMode.setThreadPolicy(allowThreadDiskReads);
            }
        } catch (RemoteException | DynamiteModule.LoadingException e5) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e5);
            z5 = false;
        }
        return z5;
    }

    private static zzw zzh(final String str, final zzj zzjVar, final boolean z5, boolean z6) {
        try {
            zzj();
            Preconditions.checkNotNull(zzg);
            try {
                return zze.zzh(new zzs(str, zzjVar, z5, z6), ObjectWrapper.wrap(zzg.getPackageManager())) ? zzw.zzb() : new zzu(new Callable() { // from class: com.google.android.gms.common.zze
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return zzn.zzd(z5, str, zzjVar);
                    }
                }, null);
            } catch (RemoteException e5) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e5);
                return zzw.zzd("module call", e5);
            }
        } catch (DynamiteModule.LoadingException e6) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e6);
            return zzw.zzd("module init: ".concat(String.valueOf(e6.getMessage())), e6);
        }
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [com.google.android.gms.dynamic.IObjectWrapper, android.os.IBinder] */
    private static zzw zzi(String str, boolean z5, boolean z6, boolean z7, boolean z8) {
        zzw zzd2;
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            Preconditions.checkNotNull(zzg);
            try {
                zzj();
                zzo zzoVar = new zzo(str, z5, false, ObjectWrapper.wrap(zzg), false, true);
                try {
                    zzq zze2 = z8 ? zze.zze(zzoVar) : zze.zzf(zzoVar);
                    if (zze2.zzb()) {
                        zzd2 = zzw.zzf(zze2.zzc());
                    } else {
                        String zza2 = zze2.zza();
                        PackageManager.NameNotFoundException nameNotFoundException = zze2.zzd() == 4 ? new PackageManager.NameNotFoundException() : null;
                        if (zza2 == null) {
                            zza2 = "error checking package certificate";
                        }
                        zzd2 = zzw.zzg(zze2.zzc(), zze2.zzd(), zza2, nameNotFoundException);
                    }
                } catch (RemoteException e5) {
                    Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e5);
                    zzd2 = zzw.zzd("module call", e5);
                }
            } catch (DynamiteModule.LoadingException e6) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e6);
                zzd2 = zzw.zzd("module init: ".concat(String.valueOf(e6.getMessage())), e6);
            }
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            return zzd2;
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            throw th;
        }
    }

    private static void zzj() {
        if (zze != null) {
            return;
        }
        Preconditions.checkNotNull(zzg);
        synchronized (zzf) {
            try {
                if (zze == null) {
                    zze = zzaf.zzb(DynamiteModule.load(zzg, DynamiteModule.PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING, "com.google.android.gms.googlecertificates").instantiate("com.google.android.gms.common.GoogleCertificatesImpl"));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
