package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* loaded from: classes.dex */
public final class zzhi implements ServiceConnection {
    final /* synthetic */ zzhj zza;
    private final String zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhi(zzhj zzhjVar, String str) {
        this.zza = zzhjVar;
        this.zzb = str;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (iBinder == null) {
            this.zza.zza.zzj().zzr().zza("Install Referrer connection returned with null binder");
            return;
        }
        try {
            com.google.android.gms.internal.measurement.zzbz zza = com.google.android.gms.internal.measurement.zzby.zza(iBinder);
            if (zza == null) {
                this.zza.zza.zzj().zzr().zza("Install Referrer Service implementation was not found");
            } else {
                this.zza.zza.zzj().zzq().zza("Install Referrer Service connected");
                this.zza.zza.zzl().zzb(new zzhl(this, zza, this));
            }
        } catch (RuntimeException e5) {
            this.zza.zza.zzj().zzr().zza("Exception occurred while calling Install Referrer API", e5);
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.zza.zza.zzj().zzq().zza("Install Referrer Service disconnected");
    }
}
