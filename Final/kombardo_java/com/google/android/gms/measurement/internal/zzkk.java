package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.util.SparseArray;
import com.google.common.util.concurrent.FutureCallback;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzkk implements FutureCallback<Object> {
    private final /* synthetic */ zzog zza;
    private final /* synthetic */ zzju zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzkk(zzju zzjuVar, zzog zzogVar) {
        this.zza = zzogVar;
        this.zzb = zzjuVar;
    }

    private final void zza() {
        SparseArray<Long> zzm = this.zzb.zzk().zzm();
        zzog zzogVar = this.zza;
        zzm.put(zzogVar.zzc, Long.valueOf(zzogVar.zzb));
        zzha zzk = this.zzb.zzk();
        int[] iArr = new int[zzm.size()];
        long[] jArr = new long[zzm.size()];
        for (int i5 = 0; i5 < zzm.size(); i5++) {
            iArr[i5] = zzm.keyAt(i5);
            jArr[i5] = zzm.valueAt(i5).longValue();
        }
        Bundle bundle = new Bundle();
        bundle.putIntArray("uriSources", iArr);
        bundle.putLongArray("uriTimestamps", jArr);
        zzk.zzi.zza(bundle);
    }

    @Override // com.google.common.util.concurrent.FutureCallback
    public final void onFailure(Throwable th) {
        int i5;
        int i6;
        int i7;
        int i8;
        this.zzb.zzv();
        this.zzb.zzh = false;
        int zza = (this.zzb.zze().zza(zzbn.zzct) ? zzju.zza(this.zzb, th) : 2) - 1;
        if (zza == 0) {
            this.zzb.zzj().zzr().zza("registerTriggerAsync failed with retriable error. Will try later. App ID, throwable", zzgo.zza(this.zzb.zzg().zzaf()), zzgo.zza(th.toString()));
            this.zzb.zzi = 1;
            this.zzb.zzan().add(this.zza);
            return;
        }
        if (zza != 1) {
            if (zza != 2) {
                return;
            }
            this.zzb.zzj().zzg().zza("registerTriggerAsync failed. Dropping URI. App ID, Throwable", zzgo.zza(this.zzb.zzg().zzaf()), th);
            zza();
            this.zzb.zzi = 1;
            this.zzb.zzav();
            return;
        }
        this.zzb.zzan().add(this.zza);
        i5 = this.zzb.zzi;
        if (i5 > zzbn.zzbq.zza(null).intValue()) {
            this.zzb.zzi = 1;
            this.zzb.zzj().zzr().zza("registerTriggerAsync failed. May try later. App ID, throwable", zzgo.zza(this.zzb.zzg().zzaf()), zzgo.zza(th.toString()));
            return;
        }
        zzgq zzr = this.zzb.zzj().zzr();
        Object zza2 = zzgo.zza(this.zzb.zzg().zzaf());
        i6 = this.zzb.zzi;
        zzr.zza("registerTriggerAsync failed. App ID, delay in seconds, throwable", zza2, zzgo.zza(String.valueOf(i6)), zzgo.zza(th.toString()));
        zzju zzjuVar = this.zzb;
        i7 = zzjuVar.zzi;
        zzju.zzb(zzjuVar, i7);
        zzju zzjuVar2 = this.zzb;
        i8 = zzjuVar2.zzi;
        zzjuVar2.zzi = i8 << 1;
    }

    @Override // com.google.common.util.concurrent.FutureCallback
    public final void onSuccess(Object obj) {
        this.zzb.zzv();
        zza();
        this.zzb.zzh = false;
        this.zzb.zzi = 1;
        this.zzb.zzj().zzc().zza("Successfully registered trigger URI", this.zza.zza);
        this.zzb.zzav();
    }
}
