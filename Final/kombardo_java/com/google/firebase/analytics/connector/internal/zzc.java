package com.google.firebase.analytics.connector.internal;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes2.dex */
public final class zzc {
    Set<String> zza;
    private AnalyticsConnector.AnalyticsConnectorListener zzb;
    private AppMeasurementSdk zzc;
    private zzf zzd;

    public zzc(AppMeasurementSdk appMeasurementSdk, AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener) {
        this.zzb = analyticsConnectorListener;
        this.zzc = appMeasurementSdk;
        zzf zzfVar = new zzf(this);
        this.zzd = zzfVar;
        this.zzc.registerOnMeasurementEventListener(zzfVar);
        this.zza = new HashSet();
    }
}
