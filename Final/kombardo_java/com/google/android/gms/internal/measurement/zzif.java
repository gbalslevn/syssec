package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.net.Uri;
import com.google.common.base.Function;
import org.conscrypt.BuildConfig;

/* loaded from: classes.dex */
public final class zzif {
    final String zza;
    final Uri zzb;
    final String zzc;
    final String zzd;
    final boolean zze;
    final boolean zzf;
    final boolean zzg;
    final Function<Context, Boolean> zzh;
    private final boolean zzi;

    public zzif(Uri uri) {
        this(null, uri, BuildConfig.FLAVOR, BuildConfig.FLAVOR, false, false, false, false, null);
    }

    public final zzif zza() {
        return new zzif(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, true, this.zzg, this.zzh);
    }

    public final zzif zzb() {
        if (!this.zzc.isEmpty()) {
            throw new IllegalStateException("Cannot set GServices prefix and skip GServices");
        }
        Function<Context, Boolean> function = this.zzh;
        if (function == null) {
            return new zzif(this.zza, this.zzb, this.zzc, this.zzd, true, this.zzf, this.zzi, this.zzg, function);
        }
        throw new IllegalStateException("Cannot skip gservices both always and conditionally");
    }

    private zzif(String str, Uri uri, String str2, String str3, boolean z5, boolean z6, boolean z7, boolean z8, Function<Context, Boolean> function) {
        this.zza = str;
        this.zzb = uri;
        this.zzc = str2;
        this.zzd = str3;
        this.zze = z5;
        this.zzf = z6;
        this.zzi = z7;
        this.zzg = z8;
        this.zzh = function;
    }

    public final zzhx<Double> zza(String str, double d5) {
        return zzhx.zza(this, str, Double.valueOf(-3.0d), true);
    }

    public final zzhx<Long> zza(String str, long j5) {
        return zzhx.zza(this, str, Long.valueOf(j5), true);
    }

    public final zzhx<String> zza(String str, String str2) {
        return zzhx.zza(this, str, str2, true);
    }

    public final zzhx<Boolean> zza(String str, boolean z5) {
        return zzhx.zza(this, str, Boolean.valueOf(z5), true);
    }
}
