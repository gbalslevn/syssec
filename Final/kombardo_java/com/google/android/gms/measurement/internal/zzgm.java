package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.common.internal.TelemetryLogging;
import com.google.android.gms.common.internal.TelemetryLoggingClient;
import com.google.android.gms.common.internal.TelemetryLoggingOptions;
import com.google.android.gms.tasks.OnFailureListener;
import java.time.Duration;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes.dex */
public final class zzgm {
    private static zzgm zza;
    private static final Duration zzb = Duration.ofMinutes(30);
    private final zzic zzc;
    private final TelemetryLoggingClient zzd;
    private final AtomicLong zze = new AtomicLong(-1);

    private zzgm(Context context, zzic zzicVar) {
        this.zzd = TelemetryLogging.getClient(context, TelemetryLoggingOptions.builder().setApi("measurement:api").build());
        this.zzc = zzicVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzgm zza(zzic zzicVar) {
        if (zza == null) {
            zza = new zzgm(zzicVar.zza(), zzicVar);
        }
        return zza;
    }

    public final synchronized void zza(int i5, int i6, long j5, long j6, int i7) {
        final long elapsedRealtime = this.zzc.zzb().elapsedRealtime();
        if (this.zze.get() != -1 && elapsedRealtime - this.zze.get() <= zzb.toMillis()) {
            return;
        }
        this.zzd.log(new TelemetryData(0, Arrays.asList(new MethodInvocation(36301, i6, 0, j5, j6, null, null, 0, i7)))).addOnFailureListener(new OnFailureListener() { // from class: com.google.android.gms.measurement.internal.zzgp
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                zzgm.this.zze.set(elapsedRealtime);
            }
        });
    }
}
