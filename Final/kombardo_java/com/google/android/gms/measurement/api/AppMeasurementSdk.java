package com.google.android.gms.measurement.api;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzed;
import com.google.android.gms.measurement.internal.zzjt;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class AppMeasurementSdk {
    private final zzed zza;

    /* loaded from: classes.dex */
    public interface OnEventListener extends zzjt {
    }

    public AppMeasurementSdk(zzed zzedVar) {
        this.zza = zzedVar;
    }

    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        this.zza.zza(str, str2, bundle);
    }

    public List<Bundle> getConditionalUserProperties(String str, String str2) {
        return this.zza.zza(str, str2);
    }

    public int getMaxUserProperties(String str) {
        return this.zza.zza(str);
    }

    public Map<String, Object> getUserProperties(String str, String str2, boolean z5) {
        return this.zza.zza(str, str2, z5);
    }

    public void logEvent(String str, String str2, Bundle bundle) {
        this.zza.zzb(str, str2, bundle);
    }

    public void registerOnMeasurementEventListener(OnEventListener onEventListener) {
        this.zza.zza(onEventListener);
    }

    public void setConditionalUserProperty(Bundle bundle) {
        this.zza.zza(bundle);
    }

    public void setUserProperty(String str, String str2, Object obj) {
        this.zza.zza(str, str2, obj, true);
    }
}
