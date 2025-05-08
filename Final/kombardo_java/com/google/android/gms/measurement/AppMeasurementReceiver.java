package com.google.android.gms.measurement;

import android.content.Context;
import android.content.Intent;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.google.android.gms.measurement.internal.zzhk;

/* loaded from: classes.dex */
public final class AppMeasurementReceiver extends WakefulBroadcastReceiver implements zzhk.zza {
    private zzhk zza;

    @Override // com.google.android.gms.measurement.internal.zzhk.zza
    public final void doStartService(Context context, Intent intent) {
        WakefulBroadcastReceiver.startWakefulService(context, intent);
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (this.zza == null) {
            this.zza = new zzhk(this);
        }
        this.zza.zza(context, intent);
    }
}
