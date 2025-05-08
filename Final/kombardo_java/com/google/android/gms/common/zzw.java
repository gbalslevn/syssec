package com.google.android.gms.common;

import android.util.Log;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class zzw {
    private static final zzw zze = new zzw(true, 3, 1, null, null);
    final boolean zza;
    final String zzb;
    final Throwable zzc;
    final int zzd;

    private zzw(boolean z5, int i5, int i6, String str, Throwable th) {
        this.zza = z5;
        this.zzd = i5;
        this.zzb = str;
        this.zzc = th;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public static zzw zzb() {
        return zze;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzw zzc(String str) {
        return new zzw(false, 1, 5, str, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzw zzd(String str, Throwable th) {
        return new zzw(false, 1, 5, str, th);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzw zzf(int i5) {
        return new zzw(true, i5, 1, null, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzw zzg(int i5, int i6, String str, Throwable th) {
        return new zzw(false, i5, i6, str, th);
    }

    String zza() {
        return this.zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zze() {
        if (this.zza || !Log.isLoggable("GoogleCertificatesRslt", 3)) {
            return;
        }
        if (this.zzc != null) {
            Log.d("GoogleCertificatesRslt", zza(), this.zzc);
        } else {
            Log.d("GoogleCertificatesRslt", zza());
        }
    }
}
