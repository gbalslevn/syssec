package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes.dex */
public final class zzhf {
    private final String zza;
    private final long zzb;
    private boolean zzc;
    private long zzd;
    private final /* synthetic */ zzha zze;

    public zzhf(zzha zzhaVar, String str, long j5) {
        this.zze = zzhaVar;
        Preconditions.checkNotEmpty(str);
        this.zza = str;
        this.zzb = j5;
    }

    public final long zza() {
        if (!this.zzc) {
            this.zzc = true;
            this.zzd = this.zze.zzg().getLong(this.zza, this.zzb);
        }
        return this.zzd;
    }

    public final void zza(long j5) {
        SharedPreferences.Editor edit = this.zze.zzg().edit();
        edit.putLong(this.zza, j5);
        edit.apply();
        this.zzd = j5;
    }
}
