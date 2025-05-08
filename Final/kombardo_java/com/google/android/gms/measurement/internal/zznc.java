package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zznc implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ zzp zzb;
    private final /* synthetic */ boolean zzc;
    private final /* synthetic */ zzbl zzd;
    private final /* synthetic */ String zze;
    private final /* synthetic */ zzme zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zznc(zzme zzmeVar, boolean z5, zzp zzpVar, boolean z6, zzbl zzblVar, String str) {
        this.zza = z5;
        this.zzb = zzpVar;
        this.zzc = z6;
        this.zzd = zzblVar;
        this.zze = str;
        this.zzf = zzmeVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfz zzfzVar;
        long j5;
        long j6;
        long j7;
        zzfzVar = this.zzf.zzb;
        if (zzfzVar == null) {
            this.zzf.zzj().zzg().zza("Discarding data. Failed to send event to service");
            return;
        }
        if (this.zza) {
            Preconditions.checkNotNull(this.zzb);
            this.zzf.zza(zzfzVar, this.zzc ? null : this.zzd, this.zzb);
        } else {
            boolean zza = this.zzf.zze().zza(zzbn.zzco);
            try {
                if (TextUtils.isEmpty(this.zze)) {
                    Preconditions.checkNotNull(this.zzb);
                    if (zza) {
                        j7 = this.zzf.zzu.zzb().currentTimeMillis();
                        try {
                            j5 = this.zzf.zzu.zzb().elapsedRealtime();
                        } catch (RemoteException e5) {
                            e = e5;
                            j5 = 0;
                            j6 = j7;
                            this.zzf.zzj().zzg().zza("Failed to send event to the service", e);
                            if (zza) {
                                zzgm.zza(this.zzf.zzu).zza(36301, 13, j6, this.zzf.zzu.zzb().currentTimeMillis(), (int) (this.zzf.zzu.zzb().elapsedRealtime() - j5));
                            }
                            this.zzf.zzar();
                        }
                    } else {
                        j7 = 0;
                        j5 = 0;
                    }
                    try {
                        zzfzVar.zza(this.zzd, this.zzb);
                        if (zza) {
                            this.zzf.zzj().zzq().zza("Logging telemetry for logEvent");
                            zzgm.zza(this.zzf.zzu).zza(36301, 0, j7, this.zzf.zzu.zzb().currentTimeMillis(), (int) (this.zzf.zzu.zzb().elapsedRealtime() - j5));
                        }
                    } catch (RemoteException e6) {
                        e = e6;
                        j6 = j7;
                        this.zzf.zzj().zzg().zza("Failed to send event to the service", e);
                        if (zza && j6 != 0) {
                            zzgm.zza(this.zzf.zzu).zza(36301, 13, j6, this.zzf.zzu.zzb().currentTimeMillis(), (int) (this.zzf.zzu.zzb().elapsedRealtime() - j5));
                        }
                        this.zzf.zzar();
                    }
                } else {
                    zzfzVar.zza(this.zzd, this.zze, this.zzf.zzj().zzy());
                }
            } catch (RemoteException e7) {
                e = e7;
                j5 = 0;
                j6 = 0;
            }
        }
        this.zzf.zzar();
    }
}
