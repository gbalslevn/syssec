package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.Objects;

/* loaded from: classes.dex */
public final class zzq extends BroadcastReceiver {
    private final zzic zza;

    public zzq(zzic zzicVar) {
        this.zza = zzicVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent == null) {
            this.zza.zzj().zzr().zza("App receiver called with null intent");
            return;
        }
        String action = intent.getAction();
        if (action == null) {
            this.zza.zzj().zzr().zza("App receiver called with null action");
            return;
        }
        if (action.equals("com.google.android.gms.measurement.TRIGGERS_AVAILABLE")) {
            final zzic zzicVar = this.zza;
            if (com.google.android.gms.internal.measurement.zzoy.zza() && zzicVar.zzf().zzf(null, zzbn.zzcq)) {
                zzicVar.zzj().zzq().zza("App receiver notified triggers are available");
                zzicVar.zzl().zzb(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzs
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzic zzicVar2 = zzic.this;
                        if (!zzicVar2.zzv().zzx()) {
                            zzicVar2.zzj().zzr().zza("registerTrigger called but app not eligible");
                            return;
                        }
                        zzicVar2.zzp().zzaq();
                        final zzju zzp = zzicVar2.zzp();
                        Objects.requireNonNull(zzp);
                        new Thread(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzt
                            @Override // java.lang.Runnable
                            public final void run() {
                                zzju.this.zzas();
                            }
                        }).start();
                    }
                });
                return;
            }
            return;
        }
        if (!action.equals("com.google.android.gms.measurement.BATCHES_AVAILABLE")) {
            this.zza.zzj().zzr().zza("App receiver called with unknown action");
        } else if (this.zza.zzf().zzf(null, zzbn.zzcl)) {
            this.zza.zzj().zzq().zza("[sgtm] App Receiver notified batches are available");
            this.zza.zzl().zzb(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzv
                @Override // java.lang.Runnable
                public final void run() {
                    zzq.this.zza.zzr().zza(zzbn.zzy.zza(null).longValue());
                }
            });
        }
    }
}
