package com.google.android.gms.internal.identity;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.zzv;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzdv extends zzv {
    private final zzdr zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdv(zzdr zzdrVar) {
        this.zza = zzdrVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzdv zzc(ListenerHolder listenerHolder) {
        this.zza.zzb(listenerHolder);
        return this;
    }

    @Override // com.google.android.gms.location.zzw
    public final void zzd(LocationResult locationResult) {
        this.zza.zza().notifyListener(new zzds(this, locationResult));
    }

    @Override // com.google.android.gms.location.zzw
    public final void zze(LocationAvailability locationAvailability) {
        this.zza.zza().notifyListener(new zzdt(this, locationAvailability));
    }

    @Override // com.google.android.gms.location.zzw
    public final void zzf() {
        this.zza.zza().notifyListener(new zzdu(this));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzg() {
        this.zza.zza().clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzdr zzh() {
        return this.zza;
    }
}
