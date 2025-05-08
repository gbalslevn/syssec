package com.google.android.play.core.appupdate;

import android.app.PendingIntent;
import java.util.Map;

/* loaded from: classes.dex */
public class AppUpdateInfo {
    private final String zza;
    private final int zzb;
    private final int zzc;
    private final int zzd;
    private final Integer zze;
    private final int zzf;
    private final long zzg;
    private final long zzh;
    private final long zzi;
    private final long zzj;
    private final PendingIntent zzk;
    private final PendingIntent zzl;
    private final PendingIntent zzm;
    private final PendingIntent zzn;
    private final Map zzo;
    private boolean zzp = false;

    private AppUpdateInfo(String str, int i5, int i6, int i7, Integer num, int i8, long j5, long j6, long j7, long j8, PendingIntent pendingIntent, PendingIntent pendingIntent2, PendingIntent pendingIntent3, PendingIntent pendingIntent4, Map map) {
        this.zza = str;
        this.zzb = i5;
        this.zzc = i6;
        this.zzd = i7;
        this.zze = num;
        this.zzf = i8;
        this.zzg = j5;
        this.zzh = j6;
        this.zzi = j7;
        this.zzj = j8;
        this.zzk = pendingIntent;
        this.zzl = pendingIntent2;
        this.zzm = pendingIntent3;
        this.zzn = pendingIntent4;
        this.zzo = map;
    }

    public static AppUpdateInfo zzb(String str, int i5, int i6, int i7, Integer num, int i8, long j5, long j6, long j7, long j8, PendingIntent pendingIntent, PendingIntent pendingIntent2, PendingIntent pendingIntent3, PendingIntent pendingIntent4, Map map) {
        return new AppUpdateInfo(str, i5, i6, i7, num, i8, j5, j6, j7, j8, pendingIntent, pendingIntent2, pendingIntent3, pendingIntent4, map);
    }

    private final boolean zzf(AppUpdateOptions appUpdateOptions) {
        return appUpdateOptions.allowAssetPackDeletion() && this.zzi <= this.zzj;
    }

    public int installStatus() {
        return this.zzd;
    }

    public boolean isUpdateTypeAllowed(int i5) {
        return zza(AppUpdateOptions.defaultOptions(i5)) != null;
    }

    public int updateAvailability() {
        return this.zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final PendingIntent zza(AppUpdateOptions appUpdateOptions) {
        if (appUpdateOptions.appUpdateType() == 0) {
            PendingIntent pendingIntent = this.zzl;
            if (pendingIntent != null) {
                return pendingIntent;
            }
            if (zzf(appUpdateOptions)) {
                return this.zzn;
            }
            return null;
        }
        if (appUpdateOptions.appUpdateType() == 1) {
            PendingIntent pendingIntent2 = this.zzk;
            if (pendingIntent2 != null) {
                return pendingIntent2;
            }
            if (zzf(appUpdateOptions)) {
                return this.zzm;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzc() {
        this.zzp = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzd() {
        return this.zzp;
    }

    public boolean isUpdateTypeAllowed(AppUpdateOptions appUpdateOptions) {
        return zza(appUpdateOptions) != null;
    }
}
