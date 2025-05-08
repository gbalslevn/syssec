package com.google.android.gms.measurement;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.measurement.internal.zzic;
import com.google.android.gms.measurement.internal.zzju;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzb extends AppMeasurement.zza {
    private final zzic zza;
    private final zzju zzb;

    public zzb(zzic zzicVar) {
        super();
        Preconditions.checkNotNull(zzicVar);
        this.zza = zzicVar;
        this.zzb = zzicVar.zzp();
    }

    @Override // com.google.android.gms.measurement.internal.zzlm
    public final int zza(String str) {
        return zzju.zza(str);
    }

    @Override // com.google.android.gms.measurement.internal.zzlm
    public final void zzb(String str) {
        this.zza.zze().zza(str, this.zza.zzb().elapsedRealtime());
    }

    @Override // com.google.android.gms.measurement.internal.zzlm
    public final void zzc(String str) {
        this.zza.zze().zzb(str, this.zza.zzb().elapsedRealtime());
    }

    @Override // com.google.android.gms.measurement.internal.zzlm
    public final long zzf() {
        return this.zza.zzv().zzo();
    }

    @Override // com.google.android.gms.measurement.internal.zzlm
    public final String zzg() {
        return this.zzb.zzai();
    }

    @Override // com.google.android.gms.measurement.internal.zzlm
    public final String zzh() {
        return this.zzb.zzaj();
    }

    @Override // com.google.android.gms.measurement.internal.zzlm
    public final String zzi() {
        return this.zzb.zzak();
    }

    @Override // com.google.android.gms.measurement.internal.zzlm
    public final String zzj() {
        return this.zzb.zzai();
    }

    @Override // com.google.android.gms.measurement.internal.zzlm
    public final List<Bundle> zza(String str, String str2) {
        return this.zzb.zza(str, str2);
    }

    @Override // com.google.android.gms.measurement.internal.zzlm
    public final Map<String, Object> zza(String str, String str2, boolean z5) {
        return this.zzb.zza(str, str2, z5);
    }

    @Override // com.google.android.gms.measurement.internal.zzlm
    public final void zza(String str, String str2, Bundle bundle) {
        this.zza.zzp().zza(str, str2, bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzlm
    public final void zzb(String str, String str2, Bundle bundle) {
        this.zzb.zzb(str, str2, bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzlm
    public final void zza(Bundle bundle) {
        this.zzb.zza(bundle);
    }
}
