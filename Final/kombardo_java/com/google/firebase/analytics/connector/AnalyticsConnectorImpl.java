package com.google.firebase.analytics.connector;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzed;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.DataCollectionDefaultChange;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.analytics.connector.internal.zzc;
import com.google.firebase.analytics.connector.internal.zzd;
import com.google.firebase.analytics.connector.internal.zze;
import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;
import com.google.firebase.events.Subscriber;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public class AnalyticsConnectorImpl implements AnalyticsConnector {
    private static volatile AnalyticsConnector zzb;
    final Map<String, Object> zza;
    private final AppMeasurementSdk zzc;

    private AnalyticsConnectorImpl(AppMeasurementSdk appMeasurementSdk) {
        Preconditions.checkNotNull(appMeasurementSdk);
        this.zzc = appMeasurementSdk;
        this.zza = new ConcurrentHashMap();
    }

    public static AnalyticsConnector getInstance(FirebaseApp firebaseApp, Context context, Subscriber subscriber) {
        Preconditions.checkNotNull(firebaseApp);
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(subscriber);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zzb == null) {
            synchronized (AnalyticsConnectorImpl.class) {
                try {
                    if (zzb == null) {
                        Bundle bundle = new Bundle(1);
                        if (firebaseApp.isDefaultApp()) {
                            subscriber.subscribe(DataCollectionDefaultChange.class, new Executor() { // from class: com.google.firebase.analytics.connector.zzb
                                @Override // java.util.concurrent.Executor
                                public final void execute(Runnable runnable) {
                                    runnable.run();
                                }
                            }, new EventHandler() { // from class: com.google.firebase.analytics.connector.zza
                                @Override // com.google.firebase.events.EventHandler
                                public final void handle(Event event) {
                                    AnalyticsConnectorImpl.zza(event);
                                }
                            });
                            bundle.putBoolean("dataCollectionDefaultEnabled", firebaseApp.isDataCollectionDefaultEnabled());
                        }
                        zzb = new AnalyticsConnectorImpl(zzed.zza(context, (String) null, (String) null, (String) null, bundle).zzb());
                    }
                } finally {
                }
            }
        }
        return zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zza(Event event) {
        throw null;
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        if (str2 == null || zzd.zza(str2, bundle)) {
            this.zzc.clearConditionalUserProperty(str, str2, bundle);
        }
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public List<AnalyticsConnector.ConditionalUserProperty> getConditionalUserProperties(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        Iterator<Bundle> it = this.zzc.getConditionalUserProperties(str, str2).iterator();
        while (it.hasNext()) {
            arrayList.add(zzd.zza(it.next()));
        }
        return arrayList;
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public int getMaxUserProperties(String str) {
        return this.zzc.getMaxUserProperties(str);
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public Map<String, Object> getUserProperties(boolean z5) {
        return this.zzc.getUserProperties(null, null, z5);
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public void logEvent(String str, String str2, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (zzd.zzf(str) && zzd.zza(str2, bundle) && zzd.zzb(str, str2, bundle)) {
            zzd.zza(str, str2, bundle);
            this.zzc.logEvent(str, str2, bundle);
        }
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public AnalyticsConnector.AnalyticsConnectorHandle registerAnalyticsConnectorListener(final String str, AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener) {
        Preconditions.checkNotNull(analyticsConnectorListener);
        if (!zzd.zzf(str) || zza(str)) {
            return null;
        }
        AppMeasurementSdk appMeasurementSdk = this.zzc;
        Object zzcVar = "fiam".equals(str) ? new zzc(appMeasurementSdk, analyticsConnectorListener) : "clx".equals(str) ? new zze(appMeasurementSdk, analyticsConnectorListener) : null;
        if (zzcVar == null) {
            return null;
        }
        this.zza.put(str, zzcVar);
        return new AnalyticsConnector.AnalyticsConnectorHandle(this) { // from class: com.google.firebase.analytics.connector.AnalyticsConnectorImpl.1
            private final /* synthetic */ AnalyticsConnectorImpl zzb;

            {
                this.zzb = this;
            }
        };
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public void setConditionalUserProperty(AnalyticsConnector.ConditionalUserProperty conditionalUserProperty) {
        if (zzd.zzb(conditionalUserProperty)) {
            this.zzc.setConditionalUserProperty(zzd.zza(conditionalUserProperty));
        }
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public void setUserProperty(String str, String str2, Object obj) {
        if (zzd.zzf(str) && zzd.zza(str, str2)) {
            this.zzc.setUserProperty(str, str2, obj);
        }
    }

    private final boolean zza(String str) {
        return (str.isEmpty() || !this.zza.containsKey(str) || this.zza.get(str) == null) ? false : true;
    }
}
