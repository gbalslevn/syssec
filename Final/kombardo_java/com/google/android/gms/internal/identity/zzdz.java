package com.google.android.gms.internal.identity;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import androidx.collection.SimpleArrayMap;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.location.LastLocationRequest;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.zzo;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Objects;

/* loaded from: classes.dex */
public final class zzdz extends GmsClient {
    private final SimpleArrayMap zzf;
    private final SimpleArrayMap zzg;
    private final SimpleArrayMap zzh;
    private final SimpleArrayMap zzi;

    public zzdz(Context context, Looper looper, ClientSettings clientSettings, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 23, clientSettings, connectionCallbacks, onConnectionFailedListener);
        this.zzf = new SimpleArrayMap();
        this.zzg = new SimpleArrayMap();
        this.zzh = new SimpleArrayMap();
        this.zzi = new SimpleArrayMap();
    }

    private final boolean zzG(Feature feature) {
        Feature feature2;
        Feature[] availableFeatures = getAvailableFeatures();
        if (availableFeatures != null) {
            int i5 = 0;
            while (true) {
                if (i5 >= availableFeatures.length) {
                    feature2 = null;
                    break;
                }
                feature2 = availableFeatures[i5];
                if (feature.getName().equals(feature2.getName())) {
                    break;
                }
                i5++;
            }
            if (feature2 != null && feature2.getVersion() >= feature.getVersion()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        return queryLocalInterface instanceof zzv ? (zzv) queryLocalInterface : new zzu(iBinder);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final Feature[] getApiFeatures() {
        return zzo.zzp;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final int getMinApkVersion() {
        return 11717000;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final String getServiceDescriptor() {
        return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final String getStartServiceAction() {
        return "com.google.android.location.internal.GoogleLocationManagerService.START";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final void onConnectionSuspended(int i5) {
        super.onConnectionSuspended(i5);
        synchronized (this.zzf) {
            this.zzf.clear();
        }
        synchronized (this.zzg) {
            this.zzg.clear();
        }
        synchronized (this.zzh) {
            this.zzh.clear();
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final boolean usesClientTelemetry() {
        return true;
    }

    public final void zzq(LastLocationRequest lastLocationRequest, TaskCompletionSource taskCompletionSource) {
        if (zzG(zzo.zzj)) {
            ((zzv) getService()).zzq(lastLocationRequest, zzee.zzd(new zzdk(taskCompletionSource)));
        } else if (zzG(zzo.zzf)) {
            ((zzv) getService()).zzr(lastLocationRequest, new zzdk(taskCompletionSource));
        } else {
            taskCompletionSource.setResult(((zzv) getService()).zzs());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003f A[Catch: all -> 0x002e, TryCatch #0 {all -> 0x002e, blocks: (B:4:0x001a, B:8:0x0028, B:10:0x003f, B:11:0x0075, B:15:0x0056, B:16:0x0030), top: B:3:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0056 A[Catch: all -> 0x002e, TryCatch #0 {all -> 0x002e, blocks: (B:4:0x001a, B:8:0x0028, B:10:0x003f, B:11:0x0075, B:15:0x0056, B:16:0x0030), top: B:3:0x001a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzt(zzdr zzdrVar, LocationRequest locationRequest, TaskCompletionSource taskCompletionSource) {
        zzdv zzdvVar;
        ListenerHolder zza = zzdrVar.zza();
        ListenerHolder.ListenerKey listenerKey = zza.getListenerKey();
        Objects.requireNonNull(listenerKey);
        boolean zzG = zzG(zzo.zzj);
        synchronized (this.zzg) {
            try {
                zzdv zzdvVar2 = (zzdv) this.zzg.get(listenerKey);
                if (zzdvVar2 != null && !zzG) {
                    zzdvVar2.zzc(zza);
                    zzdvVar = zzdvVar2;
                    zzdvVar2 = null;
                    if (zzG) {
                        ((zzv) getService()).zzv(new zzei(1, zzeg.zza(null, locationRequest), null, zzdvVar, null, new zzdd(taskCompletionSource, zzdvVar), listenerKey.toIdString()));
                    } else {
                        ((zzv) getService()).zzw(zzee.zzb(zzdvVar2, zzdvVar, listenerKey.toIdString()), locationRequest, new zzdj(null, taskCompletionSource));
                    }
                }
                zzdv zzdvVar3 = new zzdv(zzdrVar);
                this.zzg.put(listenerKey, zzdvVar3);
                zzdvVar = zzdvVar3;
                if (zzG) {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzw(ListenerHolder.ListenerKey listenerKey, boolean z5, TaskCompletionSource taskCompletionSource) {
        synchronized (this.zzg) {
            try {
                zzdv zzdvVar = (zzdv) this.zzg.remove(listenerKey);
                if (zzdvVar == null) {
                    taskCompletionSource.setResult(Boolean.FALSE);
                    return;
                }
                zzdvVar.zzg();
                if (!z5) {
                    taskCompletionSource.setResult(Boolean.TRUE);
                } else if (zzG(zzo.zzj)) {
                    zzv zzvVar = (zzv) getService();
                    int identityHashCode = System.identityHashCode(zzdvVar);
                    StringBuilder sb = new StringBuilder(String.valueOf(identityHashCode).length() + 18);
                    sb.append("ILocationCallback@");
                    sb.append(identityHashCode);
                    zzvVar.zzx(zzee.zzb(null, zzdvVar, sb.toString()), new zzdj(Boolean.TRUE, taskCompletionSource));
                } else {
                    ((zzv) getService()).zzv(new zzei(2, null, null, zzdvVar, null, new zzdn(Boolean.TRUE, taskCompletionSource), null));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
