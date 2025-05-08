package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class zzgy extends BroadcastReceiver {
    private final zzou zza;
    private boolean zzb;
    private boolean zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgy(zzou zzouVar) {
        Preconditions.checkNotNull(zzouVar);
        this.zza = zzouVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.zza.zzt();
        String action = intent.getAction();
        this.zza.zzj().zzq().zza("NetworkBroadcastReceiver received action", action);
        if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            this.zza.zzj().zzr().zza("NetworkBroadcastReceiver received unknown action", action);
            return;
        }
        boolean zzr = this.zza.zzh().zzr();
        if (this.zzc != zzr) {
            this.zzc = zzr;
            this.zza.zzl().zzb(new zzhb(this, zzr));
        }
    }

    public final void zzb() {
        this.zza.zzt();
        this.zza.zzl().zzv();
        this.zza.zzl().zzv();
        if (this.zzb) {
            this.zza.zzj().zzq().zza("Unregistering connectivity change receiver");
            this.zzb = false;
            this.zzc = false;
            try {
                this.zza.zza().unregisterReceiver(this);
            } catch (IllegalArgumentException e5) {
                this.zza.zzj().zzg().zza("Failed to unregister the network broadcast receiver", e5);
            }
        }
    }

    public final void zza() {
        this.zza.zzt();
        this.zza.zzl().zzv();
        if (this.zzb) {
            return;
        }
        this.zza.zza().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        this.zzc = this.zza.zzh().zzr();
        this.zza.zzj().zzq().zza("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.zzc));
        this.zzb = true;
    }
}
