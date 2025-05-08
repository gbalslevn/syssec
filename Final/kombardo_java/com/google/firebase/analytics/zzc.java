package com.google.firebase.analytics;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzed;
import com.google.android.gms.measurement.internal.zzlm;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
final class zzc implements zzlm {
    private final /* synthetic */ zzed zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzc(zzed zzedVar) {
        this.zza = zzedVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzlm
    public final int zza(String str) {
        return this.zza.zza(str);
    }

    @Override // com.google.android.gms.measurement.internal.zzlm
    public final void zzb(String str) {
        this.zza.zzb(str);
    }

    @Override // com.google.android.gms.measurement.internal.zzlm
    public final void zzc(String str) {
        this.zza.zzc(str);
    }

    @Override // com.google.android.gms.measurement.internal.zzlm
    public final long zzf() {
        return this.zza.zza();
    }

    @Override // com.google.android.gms.measurement.internal.zzlm
    public final String zzg() {
        return this.zza.zzf();
    }

    @Override // com.google.android.gms.measurement.internal.zzlm
    public final String zzh() {
        return this.zza.zzg();
    }

    @Override // com.google.android.gms.measurement.internal.zzlm
    public final String zzi() {
        return this.zza.zzh();
    }

    @Override // com.google.android.gms.measurement.internal.zzlm
    public final String zzj() {
        return this.zza.zzi();
    }

    @Override // com.google.android.gms.measurement.internal.zzlm
    public final List<Bundle> zza(String str, String str2) {
        return this.zza.zza(str, str2);
    }

    @Override // com.google.android.gms.measurement.internal.zzlm
    public final void zzb(String str, String str2, Bundle bundle) {
        this.zza.zzb(str, str2, bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzlm
    public final Map<String, Object> zza(String str, String str2, boolean z5) {
        return this.zza.zza(str, str2, z5);
    }

    @Override // com.google.android.gms.measurement.internal.zzlm
    public final void zza(String str, String str2, Bundle bundle) {
        this.zza.zza(str, str2, bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzlm
    public final void zza(Bundle bundle) {
        this.zza.zza(bundle);
    }
}
