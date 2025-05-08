package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes.dex */
public final class zzhd {
    private final String zza;
    private final boolean zzb;
    private boolean zzc;
    private boolean zzd;
    private final /* synthetic */ zzha zze;

    public zzhd(zzha zzhaVar, String str, boolean z5) {
        this.zze = zzhaVar;
        Preconditions.checkNotEmpty(str);
        this.zza = str;
        this.zzb = z5;
    }

    public final void zza(boolean z5) {
        SharedPreferences.Editor edit = this.zze.zzg().edit();
        edit.putBoolean(this.zza, z5);
        edit.apply();
        this.zzd = z5;
    }

    public final boolean zza() {
        if (!this.zzc) {
            this.zzc = true;
            this.zzd = this.zze.zzg().getBoolean(this.zza, this.zzb);
        }
        return this.zzd;
    }
}
