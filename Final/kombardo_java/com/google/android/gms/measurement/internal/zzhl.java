package com.google.android.gms.measurement.internal;

import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import com.adjust.sdk.Constants;
import com.google.android.gms.common.stats.ConnectionTracker;

/* loaded from: classes.dex */
final class zzhl implements Runnable {
    private final /* synthetic */ com.google.android.gms.internal.measurement.zzbz zza;
    private final /* synthetic */ ServiceConnection zzb;
    private final /* synthetic */ zzhi zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhl(zzhi zzhiVar, com.google.android.gms.internal.measurement.zzbz zzbzVar, ServiceConnection serviceConnection) {
        this.zza = zzbzVar;
        this.zzb = serviceConnection;
        this.zzc = zzhiVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        zzhi zzhiVar = this.zzc;
        zzhj zzhjVar = zzhiVar.zza;
        str = zzhiVar.zzb;
        com.google.android.gms.internal.measurement.zzbz zzbzVar = this.zza;
        ServiceConnection serviceConnection = this.zzb;
        Bundle zza = zzhjVar.zza(str, zzbzVar);
        zzhjVar.zza.zzl().zzv();
        zzhjVar.zza.zzaa();
        if (zza != null) {
            long j5 = zza.getLong("install_begin_timestamp_seconds", 0L) * 1000;
            if (j5 == 0) {
                zzhjVar.zza.zzj().zzr().zza("Service response is missing Install Referrer install timestamp");
            } else {
                String string = zza.getString(Constants.INSTALL_REFERRER);
                if (string == null || string.isEmpty()) {
                    zzhjVar.zza.zzj().zzg().zza("No referrer defined in Install Referrer response");
                } else {
                    zzhjVar.zza.zzj().zzq().zza("InstallReferrer API result", string);
                    Bundle zza2 = zzhjVar.zza.zzv().zza(Uri.parse("?" + string));
                    if (zza2 == null) {
                        zzhjVar.zza.zzj().zzg().zza("No campaign params defined in Install Referrer result");
                    } else {
                        if (zza2.containsKey("gclid") || zza2.containsKey("gbraid")) {
                            long j6 = zza.getLong("referrer_click_timestamp_server_seconds", 0L) * 1000;
                            if (j6 > 0) {
                                zza2.putLong("click_timestamp", j6);
                            }
                        }
                        if (j5 == zzhjVar.zza.zzn().zzd.zza()) {
                            zzhjVar.zza.zzj().zzq().zza("Logging Install Referrer campaign from module while it may have already been logged.");
                        }
                        if (zzhjVar.zza.zzae()) {
                            zzhjVar.zza.zzn().zzd.zza(j5);
                            zzhjVar.zza.zzj().zzq().zza("Logging Install Referrer campaign from gmscore with ", "referrer API v2");
                            zza2.putString("_cis", "referrer API v2");
                            zzhjVar.zza.zzp().zza("auto", "_cmp", zza2, str);
                        }
                    }
                }
            }
        }
        if (serviceConnection != null) {
            ConnectionTracker.getInstance().unbindService(zzhjVar.zza.zza(), serviceConnection);
        }
    }
}
