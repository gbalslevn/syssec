package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import org.conscrypt.BuildConfig;

/* loaded from: classes.dex */
public final class zzhe {
    private final String zza;
    private final String zzb;
    private final String zzc;
    private final long zzd;
    private final /* synthetic */ zzha zze;

    private final long zzb() {
        return this.zze.zzg().getLong(this.zza, 0L);
    }

    private final void zzc() {
        this.zze.zzv();
        long currentTimeMillis = this.zze.zzb().currentTimeMillis();
        SharedPreferences.Editor edit = this.zze.zzg().edit();
        edit.remove(this.zzb);
        edit.remove(this.zzc);
        edit.putLong(this.zza, currentTimeMillis);
        edit.apply();
    }

    public final Pair<String, Long> zza() {
        long abs;
        this.zze.zzv();
        this.zze.zzv();
        long zzb = zzb();
        if (zzb == 0) {
            zzc();
            abs = 0;
        } else {
            abs = Math.abs(zzb - this.zze.zzb().currentTimeMillis());
        }
        long j5 = this.zzd;
        if (abs < j5) {
            return null;
        }
        if (abs > (j5 << 1)) {
            zzc();
            return null;
        }
        String string = this.zze.zzg().getString(this.zzc, null);
        long j6 = this.zze.zzg().getLong(this.zzb, 0L);
        zzc();
        if (string != null && j6 > 0) {
            return new Pair<>(string, Long.valueOf(j6));
        }
        return zzha.zza;
    }

    private zzhe(zzha zzhaVar, String str, long j5) {
        this.zze = zzhaVar;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkArgument(j5 > 0);
        this.zza = str + ":start";
        this.zzb = str + ":count";
        this.zzc = str + ":value";
        this.zzd = j5;
    }

    public final void zza(String str, long j5) {
        this.zze.zzv();
        if (zzb() == 0) {
            zzc();
        }
        if (str == null) {
            str = BuildConfig.FLAVOR;
        }
        long j6 = this.zze.zzg().getLong(this.zzb, 0L);
        if (j6 <= 0) {
            SharedPreferences.Editor edit = this.zze.zzg().edit();
            edit.putString(this.zzc, str);
            edit.putLong(this.zzb, 1L);
            edit.apply();
            return;
        }
        long j7 = j6 + 1;
        boolean z5 = (this.zze.zzs().zzw().nextLong() & Long.MAX_VALUE) < Long.MAX_VALUE / j7;
        SharedPreferences.Editor edit2 = this.zze.zzg().edit();
        if (z5) {
            edit2.putString(this.zzc, str);
        }
        edit2.putLong(this.zzb, j7);
        edit2.apply();
    }
}
