package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes.dex */
public final class zzhk {
    private final zza zza;

    /* loaded from: classes.dex */
    public interface zza {
        void doStartService(Context context, Intent intent);
    }

    public zzhk(zza zzaVar) {
        Preconditions.checkNotNull(zzaVar);
        this.zza = zzaVar;
    }

    public final void zza(Context context, Intent intent) {
        zzgo zzj = zzic.zza(context, null, null).zzj();
        if (intent == null) {
            zzj.zzr().zza("Receiver called with null intent");
            return;
        }
        String action = intent.getAction();
        zzj.zzq().zza("Local receiver got", action);
        if (!"com.google.android.gms.measurement.UPLOAD".equals(action)) {
            if ("com.android.vending.INSTALL_REFERRER".equals(action)) {
                zzj.zzr().zza("Install Referrer Broadcasts are deprecated");
            }
        } else {
            Intent className = new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementService");
            className.setAction("com.google.android.gms.measurement.UPLOAD");
            zzj.zzq().zza("Starting wakeful intent.");
            this.zza.doStartService(context, className);
        }
    }
}
