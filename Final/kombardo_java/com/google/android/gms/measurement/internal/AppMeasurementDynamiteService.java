package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Map;

@DynamiteApi
/* loaded from: classes.dex */
public class AppMeasurementDynamiteService extends com.google.android.gms.internal.measurement.zzdo {
    zzic zza = null;
    private final Map<Integer, zzjt> zzb = new ArrayMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class zza implements zzjq {
        private com.google.android.gms.internal.measurement.zzdw zza;

        zza(com.google.android.gms.internal.measurement.zzdw zzdwVar) {
            this.zza = zzdwVar;
        }

        @Override // com.google.android.gms.measurement.internal.zzjq
        public final void interceptEvent(String str, String str2, Bundle bundle, long j5) {
            try {
                this.zza.zza(str, str2, bundle, j5);
            } catch (RemoteException e5) {
                zzic zzicVar = AppMeasurementDynamiteService.this.zza;
                if (zzicVar != null) {
                    zzicVar.zzj().zzr().zza("Event interceptor threw exception", e5);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    class zzb implements zzjt {
        private com.google.android.gms.internal.measurement.zzdw zza;

        zzb(com.google.android.gms.internal.measurement.zzdw zzdwVar) {
            this.zza = zzdwVar;
        }

        @Override // com.google.android.gms.measurement.internal.zzjt
        public final void onEvent(String str, String str2, Bundle bundle, long j5) {
            try {
                this.zza.zza(str, str2, bundle, j5);
            } catch (RemoteException e5) {
                zzic zzicVar = AppMeasurementDynamiteService.this.zza;
                if (zzicVar != null) {
                    zzicVar.zzj().zzr().zza("Event listener threw exception", e5);
                }
            }
        }
    }

    public static /* synthetic */ void $r8$lambda$W3cgi1t5N0SU6fYxM9Fsh5qQfPc(AppMeasurementDynamiteService appMeasurementDynamiteService, com.google.android.gms.internal.measurement.zzdr zzdrVar) {
        try {
            zzdrVar.a_();
        } catch (RemoteException e5) {
            ((zzic) Preconditions.checkNotNull(appMeasurementDynamiteService.zza)).zzj().zzr().zza("Failed to call IDynamiteUploadBatchesCallback", e5);
        }
    }

    private final void zza() {
        if (this.zza == null) {
            throw new IllegalStateException("Attempting to perform action before initialize.");
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void beginAdUnitExposure(String str, long j5) {
        zza();
        this.zza.zze().zza(str, j5);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        zza();
        this.zza.zzp().zza(str, str2, bundle);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void clearMeasurementEnabled(long j5) {
        zza();
        this.zza.zzp().zza((Boolean) null);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void endAdUnitExposure(String str, long j5) {
        zza();
        this.zza.zze().zzb(str, j5);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void generateEventId(com.google.android.gms.internal.measurement.zzdq zzdqVar) {
        zza();
        long zzo = this.zza.zzv().zzo();
        zza();
        this.zza.zzv().zza(zzdqVar, zzo);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void getAppInstanceId(com.google.android.gms.internal.measurement.zzdq zzdqVar) {
        zza();
        this.zza.zzl().zzb(new zzi(this, zzdqVar));
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void getCachedAppInstanceId(com.google.android.gms.internal.measurement.zzdq zzdqVar) {
        zza();
        zza(zzdqVar, this.zza.zzp().zzai());
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void getConditionalUserProperties(String str, String str2, com.google.android.gms.internal.measurement.zzdq zzdqVar) {
        zza();
        this.zza.zzl().zzb(new zzm(this, zzdqVar, str, str2));
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void getCurrentScreenClass(com.google.android.gms.internal.measurement.zzdq zzdqVar) {
        zza();
        zza(zzdqVar, this.zza.zzp().zzaj());
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void getCurrentScreenName(com.google.android.gms.internal.measurement.zzdq zzdqVar) {
        zza();
        zza(zzdqVar, this.zza.zzp().zzak());
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void getGmpAppId(com.google.android.gms.internal.measurement.zzdq zzdqVar) {
        zza();
        zza(zzdqVar, this.zza.zzp().zzal());
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void getMaxUserProperties(String str, com.google.android.gms.internal.measurement.zzdq zzdqVar) {
        zza();
        this.zza.zzp();
        zzju.zza(str);
        zza();
        this.zza.zzv().zza(zzdqVar, 25);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void getSessionId(com.google.android.gms.internal.measurement.zzdq zzdqVar) {
        zza();
        this.zza.zzp().zza(zzdqVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void getTestFlag(com.google.android.gms.internal.measurement.zzdq zzdqVar, int i5) {
        zza();
        if (i5 == 0) {
            this.zza.zzv().zza(zzdqVar, this.zza.zzp().zzam());
            return;
        }
        if (i5 == 1) {
            this.zza.zzv().zza(zzdqVar, this.zza.zzp().zzah().longValue());
            return;
        }
        if (i5 != 2) {
            if (i5 == 3) {
                this.zza.zzv().zza(zzdqVar, this.zza.zzp().zzag().intValue());
                return;
            } else {
                if (i5 != 4) {
                    return;
                }
                this.zza.zzv().zza(zzdqVar, this.zza.zzp().zzae().booleanValue());
                return;
            }
        }
        zzpn zzv = this.zza.zzv();
        double doubleValue = this.zza.zzp().zzaf().doubleValue();
        Bundle bundle = new Bundle();
        bundle.putDouble("r", doubleValue);
        try {
            zzdqVar.zza(bundle);
        } catch (RemoteException e5) {
            zzv.zzu.zzj().zzr().zza("Error returning double value to wrapper", e5);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void getUserProperties(String str, String str2, boolean z5, com.google.android.gms.internal.measurement.zzdq zzdqVar) {
        zza();
        this.zza.zzl().zzb(new zzk(this, zzdqVar, str, str2, z5));
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void initForTests(Map map) {
        zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void initialize(IObjectWrapper iObjectWrapper, com.google.android.gms.internal.measurement.zzdz zzdzVar, long j5) {
        zzic zzicVar = this.zza;
        if (zzicVar == null) {
            this.zza = zzic.zza((Context) Preconditions.checkNotNull((Context) ObjectWrapper.unwrap(iObjectWrapper)), zzdzVar, Long.valueOf(j5));
        } else {
            zzicVar.zzj().zzr().zza("Attempting to initialize multiple times");
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void isDataCollectionEnabled(com.google.android.gms.internal.measurement.zzdq zzdqVar) {
        zza();
        this.zza.zzl().zzb(new zzo(this, zzdqVar));
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void logEvent(String str, String str2, Bundle bundle, boolean z5, boolean z6, long j5) {
        zza();
        this.zza.zzp().zza(str, str2, bundle, z5, z6, j5);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void logEventAndBundle(String str, String str2, Bundle bundle, com.google.android.gms.internal.measurement.zzdq zzdqVar, long j5) {
        zza();
        Preconditions.checkNotEmpty(str2);
        (bundle != null ? new Bundle(bundle) : new Bundle()).putString("_o", "app");
        this.zza.zzl().zzb(new zzl(this, zzdqVar, new zzbl(str2, new zzbg(bundle), "app", j5), str));
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void logHealthData(int i5, String str, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        zza();
        this.zza.zzj().zza(i5, true, false, str, iObjectWrapper == null ? null : ObjectWrapper.unwrap(iObjectWrapper), iObjectWrapper2 == null ? null : ObjectWrapper.unwrap(iObjectWrapper2), iObjectWrapper3 != null ? ObjectWrapper.unwrap(iObjectWrapper3) : null);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void onActivityCreated(IObjectWrapper iObjectWrapper, Bundle bundle, long j5) {
        zza();
        onActivityCreatedByScionActivityInfo(com.google.android.gms.internal.measurement.zzeb.zza((Activity) Preconditions.checkNotNull((Activity) ObjectWrapper.unwrap(iObjectWrapper))), bundle, j5);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void onActivityCreatedByScionActivityInfo(com.google.android.gms.internal.measurement.zzeb zzebVar, Bundle bundle, long j5) {
        zza();
        zzll zzad = this.zza.zzp().zzad();
        if (zzad != null) {
            this.zza.zzp().zzar();
            zzad.zza(zzebVar, bundle);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void onActivityDestroyed(IObjectWrapper iObjectWrapper, long j5) {
        zza();
        onActivityDestroyedByScionActivityInfo(com.google.android.gms.internal.measurement.zzeb.zza((Activity) Preconditions.checkNotNull((Activity) ObjectWrapper.unwrap(iObjectWrapper))), j5);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void onActivityDestroyedByScionActivityInfo(com.google.android.gms.internal.measurement.zzeb zzebVar, long j5) {
        zza();
        zzll zzad = this.zza.zzp().zzad();
        if (zzad != null) {
            this.zza.zzp().zzar();
            zzad.zza(zzebVar);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void onActivityPaused(IObjectWrapper iObjectWrapper, long j5) {
        zza();
        onActivityPausedByScionActivityInfo(com.google.android.gms.internal.measurement.zzeb.zza((Activity) Preconditions.checkNotNull((Activity) ObjectWrapper.unwrap(iObjectWrapper))), j5);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void onActivityPausedByScionActivityInfo(com.google.android.gms.internal.measurement.zzeb zzebVar, long j5) {
        zza();
        zzll zzad = this.zza.zzp().zzad();
        if (zzad != null) {
            this.zza.zzp().zzar();
            zzad.zzb(zzebVar);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void onActivityResumed(IObjectWrapper iObjectWrapper, long j5) {
        zza();
        onActivityResumedByScionActivityInfo(com.google.android.gms.internal.measurement.zzeb.zza((Activity) Preconditions.checkNotNull((Activity) ObjectWrapper.unwrap(iObjectWrapper))), j5);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void onActivityResumedByScionActivityInfo(com.google.android.gms.internal.measurement.zzeb zzebVar, long j5) {
        zza();
        zzll zzad = this.zza.zzp().zzad();
        if (zzad != null) {
            this.zza.zzp().zzar();
            zzad.zzc(zzebVar);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void onActivitySaveInstanceState(IObjectWrapper iObjectWrapper, com.google.android.gms.internal.measurement.zzdq zzdqVar, long j5) {
        zza();
        onActivitySaveInstanceStateByScionActivityInfo(com.google.android.gms.internal.measurement.zzeb.zza((Activity) Preconditions.checkNotNull((Activity) ObjectWrapper.unwrap(iObjectWrapper))), zzdqVar, j5);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void onActivitySaveInstanceStateByScionActivityInfo(com.google.android.gms.internal.measurement.zzeb zzebVar, com.google.android.gms.internal.measurement.zzdq zzdqVar, long j5) {
        zza();
        zzll zzad = this.zza.zzp().zzad();
        Bundle bundle = new Bundle();
        if (zzad != null) {
            this.zza.zzp().zzar();
            zzad.zzb(zzebVar, bundle);
        }
        try {
            zzdqVar.zza(bundle);
        } catch (RemoteException e5) {
            this.zza.zzj().zzr().zza("Error returning bundle value to wrapper", e5);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void onActivityStarted(IObjectWrapper iObjectWrapper, long j5) {
        zza();
        onActivityStartedByScionActivityInfo(com.google.android.gms.internal.measurement.zzeb.zza((Activity) Preconditions.checkNotNull((Activity) ObjectWrapper.unwrap(iObjectWrapper))), j5);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void onActivityStartedByScionActivityInfo(com.google.android.gms.internal.measurement.zzeb zzebVar, long j5) {
        zza();
        if (this.zza.zzp().zzad() != null) {
            this.zza.zzp().zzar();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void onActivityStopped(IObjectWrapper iObjectWrapper, long j5) {
        zza();
        onActivityStoppedByScionActivityInfo(com.google.android.gms.internal.measurement.zzeb.zza((Activity) Preconditions.checkNotNull((Activity) ObjectWrapper.unwrap(iObjectWrapper))), j5);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void onActivityStoppedByScionActivityInfo(com.google.android.gms.internal.measurement.zzeb zzebVar, long j5) {
        zza();
        if (this.zza.zzp().zzad() != null) {
            this.zza.zzp().zzar();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void performAction(Bundle bundle, com.google.android.gms.internal.measurement.zzdq zzdqVar, long j5) {
        zza();
        zzdqVar.zza(null);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void registerOnMeasurementEventListener(com.google.android.gms.internal.measurement.zzdw zzdwVar) {
        zzjt zzjtVar;
        zza();
        synchronized (this.zzb) {
            try {
                zzjtVar = this.zzb.get(Integer.valueOf(zzdwVar.zza()));
                if (zzjtVar == null) {
                    zzjtVar = new zzb(zzdwVar);
                    this.zzb.put(Integer.valueOf(zzdwVar.zza()), zzjtVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.zza.zzp().zza(zzjtVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void resetAnalyticsData(long j5) {
        zza();
        this.zza.zzp().zza(j5);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void retrieveAndUploadBatches(final com.google.android.gms.internal.measurement.zzdr zzdrVar) {
        zza();
        if (this.zza.zzf().zzf(null, zzbn.zzcl)) {
            this.zza.zzp().zza(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzj
                @Override // java.lang.Runnable
                public final void run() {
                    AppMeasurementDynamiteService.$r8$lambda$W3cgi1t5N0SU6fYxM9Fsh5qQfPc(AppMeasurementDynamiteService.this, zzdrVar);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void setConditionalUserProperty(Bundle bundle, long j5) {
        zza();
        if (bundle == null) {
            this.zza.zzj().zzg().zza("Conditional user property must not be null");
        } else {
            this.zza.zzp().zza(bundle, j5);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void setConsent(Bundle bundle, long j5) {
        zza();
        this.zza.zzp().zzb(bundle, j5);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void setConsentThirdParty(Bundle bundle, long j5) {
        zza();
        this.zza.zzp().zzc(bundle, j5);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void setCurrentScreen(IObjectWrapper iObjectWrapper, String str, String str2, long j5) {
        zza();
        setCurrentScreenByScionActivityInfo(com.google.android.gms.internal.measurement.zzeb.zza((Activity) Preconditions.checkNotNull((Activity) ObjectWrapper.unwrap(iObjectWrapper))), str, str2, j5);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void setCurrentScreenByScionActivityInfo(com.google.android.gms.internal.measurement.zzeb zzebVar, String str, String str2, long j5) {
        zza();
        this.zza.zzs().zza(zzebVar, str, str2);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void setDataCollectionEnabled(boolean z5) {
        zza();
        this.zza.zzp().zzc(z5);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void setDefaultEventParameters(Bundle bundle) {
        zza();
        this.zza.zzp().zzb(bundle);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void setEventInterceptor(com.google.android.gms.internal.measurement.zzdw zzdwVar) {
        zza();
        zza zzaVar = new zza(zzdwVar);
        if (this.zza.zzl().zzm()) {
            this.zza.zzp().zza(zzaVar);
        } else {
            this.zza.zzl().zzb(new zzn(this, zzaVar));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void setInstanceIdProvider(com.google.android.gms.internal.measurement.zzdx zzdxVar) {
        zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void setMeasurementEnabled(boolean z5, long j5) {
        zza();
        this.zza.zzp().zza(Boolean.valueOf(z5));
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void setMinimumSessionDuration(long j5) {
        zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void setSessionTimeoutDuration(long j5) {
        zza();
        this.zza.zzp().zzd(j5);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void setSgtmDebugInfo(Intent intent) {
        zza();
        this.zza.zzp().zza(intent);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void setUserId(String str, long j5) {
        zza();
        this.zza.zzp().zza(str, j5);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void setUserProperty(String str, String str2, IObjectWrapper iObjectWrapper, boolean z5, long j5) {
        zza();
        this.zza.zzp().zza(str, str2, ObjectWrapper.unwrap(iObjectWrapper), z5, j5);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public void unregisterOnMeasurementEventListener(com.google.android.gms.internal.measurement.zzdw zzdwVar) {
        zzjt remove;
        zza();
        synchronized (this.zzb) {
            remove = this.zzb.remove(Integer.valueOf(zzdwVar.zza()));
        }
        if (remove == null) {
            remove = new zzb(zzdwVar);
        }
        this.zza.zzp().zzb(remove);
    }

    private final void zza(com.google.android.gms.internal.measurement.zzdq zzdqVar, String str) {
        zza();
        this.zza.zzv().zza(zzdqVar, str);
    }
}
