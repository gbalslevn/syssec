package com.google.android.gms.measurement;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzdz;
import com.google.android.gms.measurement.internal.zzic;
import com.google.android.gms.measurement.internal.zzjk;
import com.google.android.gms.measurement.internal.zzlm;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Deprecated
/* loaded from: classes.dex */
public class AppMeasurement {
    private static volatile AppMeasurement zza;
    private final zza zzb;

    /* loaded from: classes.dex */
    public static class ConditionalUserProperty {

        @Keep
        public boolean mActive;

        @Keep
        public String mAppId;

        @Keep
        public long mCreationTimestamp;

        @Keep
        public String mExpiredEventName;

        @Keep
        public Bundle mExpiredEventParams;

        @Keep
        public String mName;

        @Keep
        public String mOrigin;

        @Keep
        public long mTimeToLive;

        @Keep
        public String mTimedOutEventName;

        @Keep
        public Bundle mTimedOutEventParams;

        @Keep
        public String mTriggerEventName;

        @Keep
        public long mTriggerTimeout;

        @Keep
        public String mTriggeredEventName;

        @Keep
        public Bundle mTriggeredEventParams;

        @Keep
        public long mTriggeredTimestamp;

        @Keep
        public Object mValue;

        ConditionalUserProperty(Bundle bundle) {
            Preconditions.checkNotNull(bundle);
            this.mAppId = (String) zzjk.zza(bundle, "app_id", String.class, null);
            this.mOrigin = (String) zzjk.zza(bundle, "origin", String.class, null);
            this.mName = (String) zzjk.zza(bundle, "name", String.class, null);
            this.mValue = zzjk.zza(bundle, "value", Object.class, null);
            this.mTriggerEventName = (String) zzjk.zza(bundle, "trigger_event_name", String.class, null);
            this.mTriggerTimeout = ((Long) zzjk.zza(bundle, "trigger_timeout", Long.class, 0L)).longValue();
            this.mTimedOutEventName = (String) zzjk.zza(bundle, "timed_out_event_name", String.class, null);
            this.mTimedOutEventParams = (Bundle) zzjk.zza(bundle, "timed_out_event_params", Bundle.class, null);
            this.mTriggeredEventName = (String) zzjk.zza(bundle, "triggered_event_name", String.class, null);
            this.mTriggeredEventParams = (Bundle) zzjk.zza(bundle, "triggered_event_params", Bundle.class, null);
            this.mTimeToLive = ((Long) zzjk.zza(bundle, "time_to_live", Long.class, 0L)).longValue();
            this.mExpiredEventName = (String) zzjk.zza(bundle, "expired_event_name", String.class, null);
            this.mExpiredEventParams = (Bundle) zzjk.zza(bundle, "expired_event_params", Bundle.class, null);
            this.mActive = ((Boolean) zzjk.zza(bundle, "active", Boolean.class, Boolean.FALSE)).booleanValue();
            this.mCreationTimestamp = ((Long) zzjk.zza(bundle, "creation_timestamp", Long.class, 0L)).longValue();
            this.mTriggeredTimestamp = ((Long) zzjk.zza(bundle, "triggered_timestamp", Long.class, 0L)).longValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static abstract class zza implements zzlm {
        private zza() {
        }
    }

    private AppMeasurement(zzic zzicVar) {
        this.zzb = new zzb(zzicVar);
    }

    @Keep
    @Deprecated
    public static AppMeasurement getInstance(Context context) {
        return zza(context, null, null);
    }

    private static AppMeasurement zza(Context context, String str, String str2) {
        if (zza == null) {
            synchronized (AppMeasurement.class) {
                try {
                    if (zza == null) {
                        zzlm zza2 = zza(context, null);
                        if (zza2 != null) {
                            zza = new AppMeasurement(zza2);
                        } else {
                            zza = new AppMeasurement(zzic.zza(context, new zzdz(0L, 0L, true, null, null, null, null, null), null));
                        }
                    }
                } finally {
                }
            }
        }
        return zza;
    }

    @Keep
    public void beginAdUnitExposure(String str) {
        this.zzb.zzb(str);
    }

    @Keep
    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        this.zzb.zza(str, str2, bundle);
    }

    @Keep
    public void endAdUnitExposure(String str) {
        this.zzb.zzc(str);
    }

    @Keep
    public long generateEventId() {
        return this.zzb.zzf();
    }

    @Keep
    public String getAppInstanceId() {
        return this.zzb.zzg();
    }

    @Keep
    public List<ConditionalUserProperty> getConditionalUserProperties(String str, String str2) {
        List<Bundle> zza2 = this.zzb.zza(str, str2);
        ArrayList arrayList = new ArrayList(zza2 == null ? 0 : zza2.size());
        Iterator<Bundle> it = zza2.iterator();
        while (it.hasNext()) {
            arrayList.add(new ConditionalUserProperty(it.next()));
        }
        return arrayList;
    }

    @Keep
    public String getCurrentScreenClass() {
        return this.zzb.zzh();
    }

    @Keep
    public String getCurrentScreenName() {
        return this.zzb.zzi();
    }

    @Keep
    public String getGmpAppId() {
        return this.zzb.zzj();
    }

    @Keep
    public int getMaxUserProperties(String str) {
        return this.zzb.zza(str);
    }

    @Keep
    protected Map<String, Object> getUserProperties(String str, String str2, boolean z5) {
        return this.zzb.zza(str, str2, z5);
    }

    @Keep
    public void logEventInternal(String str, String str2, Bundle bundle) {
        this.zzb.zzb(str, str2, bundle);
    }

    @Keep
    public void setConditionalUserProperty(ConditionalUserProperty conditionalUserProperty) {
        Preconditions.checkNotNull(conditionalUserProperty);
        zza zzaVar = this.zzb;
        Bundle bundle = new Bundle();
        String str = conditionalUserProperty.mAppId;
        if (str != null) {
            bundle.putString("app_id", str);
        }
        String str2 = conditionalUserProperty.mOrigin;
        if (str2 != null) {
            bundle.putString("origin", str2);
        }
        String str3 = conditionalUserProperty.mName;
        if (str3 != null) {
            bundle.putString("name", str3);
        }
        Object obj = conditionalUserProperty.mValue;
        if (obj != null) {
            zzjk.zza(bundle, obj);
        }
        String str4 = conditionalUserProperty.mTriggerEventName;
        if (str4 != null) {
            bundle.putString("trigger_event_name", str4);
        }
        bundle.putLong("trigger_timeout", conditionalUserProperty.mTriggerTimeout);
        String str5 = conditionalUserProperty.mTimedOutEventName;
        if (str5 != null) {
            bundle.putString("timed_out_event_name", str5);
        }
        Bundle bundle2 = conditionalUserProperty.mTimedOutEventParams;
        if (bundle2 != null) {
            bundle.putBundle("timed_out_event_params", bundle2);
        }
        String str6 = conditionalUserProperty.mTriggeredEventName;
        if (str6 != null) {
            bundle.putString("triggered_event_name", str6);
        }
        Bundle bundle3 = conditionalUserProperty.mTriggeredEventParams;
        if (bundle3 != null) {
            bundle.putBundle("triggered_event_params", bundle3);
        }
        bundle.putLong("time_to_live", conditionalUserProperty.mTimeToLive);
        String str7 = conditionalUserProperty.mExpiredEventName;
        if (str7 != null) {
            bundle.putString("expired_event_name", str7);
        }
        Bundle bundle4 = conditionalUserProperty.mExpiredEventParams;
        if (bundle4 != null) {
            bundle.putBundle("expired_event_params", bundle4);
        }
        bundle.putLong("creation_timestamp", conditionalUserProperty.mCreationTimestamp);
        bundle.putBoolean("active", conditionalUserProperty.mActive);
        bundle.putLong("triggered_timestamp", conditionalUserProperty.mTriggeredTimestamp);
        zzaVar.zza(bundle);
    }

    private AppMeasurement(zzlm zzlmVar) {
        this.zzb = new com.google.android.gms.measurement.zza(zzlmVar);
    }

    private static zzlm zza(Context context, Bundle bundle) {
        return (zzlm) FirebaseAnalytics.class.getDeclaredMethod("getScionFrontendApiImplementation", Context.class, Bundle.class).invoke(null, context, null);
    }
}
