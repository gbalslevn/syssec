package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzng implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ zzp zze;
    private final /* synthetic */ boolean zzf;
    private final /* synthetic */ zzme zzg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzng(zzme zzmeVar, AtomicReference atomicReference, String str, String str2, String str3, zzp zzpVar, boolean z5) {
        this.zza = atomicReference;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = str3;
        this.zze = zzpVar;
        this.zzf = z5;
        this.zzg = zzmeVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfz zzfzVar;
        synchronized (this.zza) {
            try {
                try {
                    zzfzVar = this.zzg.zzb;
                } catch (RemoteException e5) {
                    this.zzg.zzj().zzg().zza("(legacy) Failed to get user properties; remote exception", zzgo.zza(this.zzb), this.zzc, e5);
                    this.zza.set(Collections.emptyList());
                }
                if (zzfzVar == null) {
                    this.zzg.zzj().zzg().zza("(legacy) Failed to get user properties; not connected to service", zzgo.zza(this.zzb), this.zzc, this.zzd);
                    this.zza.set(Collections.emptyList());
                    return;
                }
                if (TextUtils.isEmpty(this.zzb)) {
                    Preconditions.checkNotNull(this.zze);
                    this.zza.set(zzfzVar.zza(this.zzc, this.zzd, this.zzf, this.zze));
                } else {
                    this.zza.set(zzfzVar.zza(this.zzb, this.zzc, this.zzd, this.zzf));
                }
                this.zzg.zzar();
                this.zza.notify();
            } finally {
                this.zza.notify();
            }
        }
    }
}
