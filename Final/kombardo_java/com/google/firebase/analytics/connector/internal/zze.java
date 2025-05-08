package com.google.firebase.analytics.connector.internal;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.connector.AnalyticsConnector;

/* loaded from: classes2.dex */
public final class zze {
    private AnalyticsConnector.AnalyticsConnectorListener zza;
    private AppMeasurementSdk zzb;
    private zzg zzc;

    public zze(AppMeasurementSdk appMeasurementSdk, AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener) {
        this.zza = analyticsConnectorListener;
        this.zzb = appMeasurementSdk;
        zzg zzgVar = new zzg(this);
        this.zzc = zzgVar;
        this.zzb.registerOnMeasurementEventListener(zzgVar);
    }
}
