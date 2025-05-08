package com.google.android.gms.measurement.internal;

import android.database.sqlite.SQLiteException;
import android.os.Binder;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.GoogleSignatureVerifier;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.UidVerifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
public final class zzig extends zzfy {
    private final zzou zza;
    private Boolean zzb;
    private String zzc;

    public zzig(zzou zzouVar) {
        this(zzouVar, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzbl zzb(zzbl zzblVar, zzp zzpVar) {
        zzbg zzbgVar;
        if ("_cmp".equals(zzblVar.zza) && (zzbgVar = zzblVar.zzb) != null && zzbgVar.zza() != 0) {
            String zzd = zzblVar.zzb.zzd("_cis");
            if ("referrer broadcast".equals(zzd) || "referrer API".equals(zzd)) {
                this.zza.zzj().zzp().zza("Event has been filtered ", zzblVar.toString());
                return new zzbl("_cmpx", zzblVar.zzb, zzblVar.zzc, zzblVar.zzd);
            }
        }
        return zzblVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzfz
    public final void zzc(zzp zzpVar) {
        zzb(zzpVar, false);
        zzb(new zziq(this, zzpVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzfz
    public final void zzd(zzp zzpVar) {
        zzb(zzpVar, false);
        zzb(new zzin(this, zzpVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzfz
    public final void zze(zzp zzpVar) {
        Preconditions.checkNotEmpty(zzpVar.zza);
        zza(zzpVar.zza, false);
        zzb(new zzix(this, zzpVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzfz
    public final void zzf(zzp zzpVar) {
        Preconditions.checkNotEmpty(zzpVar.zza);
        Preconditions.checkNotNull(zzpVar.zzt);
        zza(new zziy(this, zzpVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzfz
    public final void zzg(final zzp zzpVar) {
        Preconditions.checkNotEmpty(zzpVar.zza);
        Preconditions.checkNotNull(zzpVar.zzt);
        zza(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzij
            @Override // java.lang.Runnable
            public final void run() {
                zzig.zzb(zzig.this, zzpVar);
            }
        });
    }

    @Override // com.google.android.gms.measurement.internal.zzfz
    public final void zzh(zzp zzpVar) {
        zzb(zzpVar, false);
        zzb(new zzil(this, zzpVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzfz
    public final void zzi(final zzp zzpVar) {
        Preconditions.checkNotEmpty(zzpVar.zza);
        Preconditions.checkNotNull(zzpVar.zzt);
        zza(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzih
            @Override // java.lang.Runnable
            public final void run() {
                zzig.zza(zzig.this, zzpVar);
            }
        });
    }

    private zzig(zzou zzouVar, String str) {
        Preconditions.checkNotNull(zzouVar);
        this.zza = zzouVar;
        this.zzc = null;
    }

    @Override // com.google.android.gms.measurement.internal.zzfz
    public final zzap zza(zzp zzpVar) {
        zzb(zzpVar, false);
        Preconditions.checkNotEmpty(zzpVar.zza);
        try {
            return (zzap) this.zza.zzl().zzb(new zzja(this, zzpVar)).get(10000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e5) {
            this.zza.zzj().zzg().zza("Failed to get consent. appId", zzgo.zza(zzpVar.zza), e5);
            return new zzap(null);
        }
    }

    private final void zzd(zzbl zzblVar, zzp zzpVar) {
        this.zza.zzs();
        this.zza.zza(zzblVar, zzpVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzc(zzbl zzblVar, zzp zzpVar) {
        boolean z5;
        if (!this.zza.zzi().zzk(zzpVar.zza)) {
            zzd(zzblVar, zzpVar);
            return;
        }
        this.zza.zzj().zzq().zza("EES config found for", zzpVar.zza);
        zzhm zzi = this.zza.zzi();
        String str = zzpVar.zza;
        com.google.android.gms.internal.measurement.zzb zzbVar = TextUtils.isEmpty(str) ? null : zzi.zza.get(str);
        if (zzbVar == null) {
            this.zza.zzj().zzq().zza("EES not loaded for", zzpVar.zza);
            zzd(zzblVar, zzpVar);
            return;
        }
        try {
            Map<String, Object> zza = this.zza.zzp().zza(zzblVar.zzb.zzb(), true);
            String zza2 = zzjp.zza(zzblVar.zza);
            if (zza2 == null) {
                zza2 = zzblVar.zza;
            }
            z5 = zzbVar.zza(new com.google.android.gms.internal.measurement.zzad(zza2, zzblVar.zzd, zza));
        } catch (com.google.android.gms.internal.measurement.zzc unused) {
            this.zza.zzj().zzg().zza("EES error. appId, eventName", zzpVar.zzb, zzblVar.zza);
            z5 = false;
        }
        if (!z5) {
            this.zza.zzj().zzq().zza("EES was not applied to event", zzblVar.zza);
            zzd(zzblVar, zzpVar);
            return;
        }
        if (zzbVar.zzc()) {
            this.zza.zzj().zzq().zza("EES edited event", zzblVar.zza);
            zzd(this.zza.zzp().zza(zzbVar.zza().zzb()), zzpVar);
        } else {
            zzd(zzblVar, zzpVar);
        }
        if (zzbVar.zzb()) {
            for (com.google.android.gms.internal.measurement.zzad zzadVar : zzbVar.zza().zzc()) {
                this.zza.zzj().zzq().zza("EES logging created event", zzadVar.zzb());
                zzd(this.zza.zzp().zza(zzadVar), zzpVar);
            }
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzfz
    public final String zzb(zzp zzpVar) {
        zzb(zzpVar, false);
        return this.zza.zzb(zzpVar);
    }

    public static /* synthetic */ void zzb(zzig zzigVar, zzp zzpVar) {
        zzigVar.zza.zzs();
        zzigVar.zza.zzf(zzpVar);
    }

    private final void zzb(zzp zzpVar, boolean z5) {
        Preconditions.checkNotNull(zzpVar);
        Preconditions.checkNotEmpty(zzpVar.zza);
        zza(zzpVar.zza, false);
        this.zza.zzq().zza(zzpVar.zzb, zzpVar.zzp);
    }

    @Override // com.google.android.gms.measurement.internal.zzfz
    public final List<zzog> zza(zzp zzpVar, Bundle bundle) {
        zzb(zzpVar, false);
        Preconditions.checkNotNull(zzpVar.zza);
        if (this.zza.zze().zza(zzbn.zzdc)) {
            try {
                return (List) this.zza.zzl().zzb(new zzjd(this, zzpVar, bundle)).get(10000L, TimeUnit.MILLISECONDS);
            } catch (InterruptedException | ExecutionException | TimeoutException e5) {
                this.zza.zzj().zzg().zza("Failed to get trigger URIs. appId", zzgo.zza(zzpVar.zza), e5);
                return Collections.emptyList();
            }
        }
        try {
            return (List) this.zza.zzl().zza(new zzjg(this, zzpVar, bundle)).get();
        } catch (InterruptedException | ExecutionException e6) {
            this.zza.zzj().zzg().zza("Failed to get trigger URIs. appId", zzgo.zza(zzpVar.zza), e6);
            return Collections.emptyList();
        }
    }

    private final void zzb(Runnable runnable) {
        Preconditions.checkNotNull(runnable);
        if (this.zza.zzl().zzm()) {
            runnable.run();
        } else {
            this.zza.zzl().zzb(runnable);
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzfz
    public final List<zzpm> zza(zzp zzpVar, boolean z5) {
        zzb(zzpVar, false);
        String str = zzpVar.zza;
        Preconditions.checkNotNull(str);
        try {
            List<zzpo> list = (List) this.zza.zzl().zza(new zzio(this, str)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzpo zzpoVar : list) {
                if (!z5 && zzpn.zzf(zzpoVar.zzc)) {
                }
                arrayList.add(new zzpm(zzpoVar));
            }
            return arrayList;
        } catch (InterruptedException e5) {
            e = e5;
            this.zza.zzj().zzg().zza("Failed to get user properties. appId", zzgo.zza(zzpVar.zza), e);
            return null;
        } catch (ExecutionException e6) {
            e = e6;
            this.zza.zzj().zzg().zza("Failed to get user properties. appId", zzgo.zza(zzpVar.zza), e);
            return null;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzfz
    public final List<zzag> zza(String str, String str2, zzp zzpVar) {
        zzb(zzpVar, false);
        String str3 = zzpVar.zza;
        Preconditions.checkNotNull(str3);
        try {
            return (List) this.zza.zzl().zza(new zziw(this, str3, str, str2)).get();
        } catch (InterruptedException | ExecutionException e5) {
            this.zza.zzj().zzg().zza("Failed to get conditional user properties", e5);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzfz
    public final List<zzag> zza(String str, String str2, String str3) {
        zza(str, true);
        try {
            return (List) this.zza.zzl().zza(new zziv(this, str, str2, str3)).get();
        } catch (InterruptedException | ExecutionException e5) {
            this.zza.zzj().zzg().zza("Failed to get conditional user properties as", e5);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzfz
    public final List<zzpm> zza(String str, String str2, boolean z5, zzp zzpVar) {
        zzb(zzpVar, false);
        String str3 = zzpVar.zza;
        Preconditions.checkNotNull(str3);
        try {
            List<zzpo> list = (List) this.zza.zzl().zza(new zziu(this, str3, str, str2)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzpo zzpoVar : list) {
                if (!z5 && zzpn.zzf(zzpoVar.zzc)) {
                }
                arrayList.add(new zzpm(zzpoVar));
            }
            return arrayList;
        } catch (InterruptedException e5) {
            e = e5;
            this.zza.zzj().zzg().zza("Failed to query user properties. appId", zzgo.zza(zzpVar.zza), e);
            return Collections.emptyList();
        } catch (ExecutionException e6) {
            e = e6;
            this.zza.zzj().zzg().zza("Failed to query user properties. appId", zzgo.zza(zzpVar.zza), e);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzfz
    public final List<zzpm> zza(String str, String str2, String str3, boolean z5) {
        zza(str, true);
        try {
            List<zzpo> list = (List) this.zza.zzl().zza(new zzit(this, str, str2, str3)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzpo zzpoVar : list) {
                if (!z5 && zzpn.zzf(zzpoVar.zzc)) {
                }
                arrayList.add(new zzpm(zzpoVar));
            }
            return arrayList;
        } catch (InterruptedException e5) {
            e = e5;
            this.zza.zzj().zzg().zza("Failed to get user properties as. appId", zzgo.zza(str), e);
            return Collections.emptyList();
        } catch (ExecutionException e6) {
            e = e6;
            this.zza.zzj().zzg().zza("Failed to get user properties as. appId", zzgo.zza(str), e);
            return Collections.emptyList();
        }
    }

    public static /* synthetic */ void zza(zzig zzigVar, String str, zzop zzopVar, zzgf zzgfVar) {
        zzigVar.zza.zzs();
        try {
            zzgfVar.zza(zzigVar.zza.zza(str, zzopVar));
        } catch (RemoteException e5) {
            zzigVar.zza.zzj().zzg().zza("[sgtm] Failed to return upload batches for app", str, e5);
        }
    }

    public static /* synthetic */ void zza(zzig zzigVar, zzp zzpVar) {
        zzigVar.zza.zzs();
        zzigVar.zza.zzg(zzpVar);
    }

    public static /* synthetic */ void zza(zzig zzigVar, zzp zzpVar, zzae zzaeVar) {
        zzigVar.zza.zzs();
        zzigVar.zza.zza((String) Preconditions.checkNotNull(zzpVar.zza), zzaeVar);
    }

    public static /* synthetic */ void zza(zzig zzigVar, zzp zzpVar, Bundle bundle, zzga zzgaVar, String str) {
        zzigVar.zza.zzs();
        try {
            zzgaVar.zza(zzigVar.zza.zza(zzpVar, bundle));
        } catch (RemoteException e5) {
            zzigVar.zza.zzj().zzg().zza("Failed to return trigger URIs for app", str, e5);
        }
    }

    public static /* synthetic */ void zza(zzig zzigVar, Bundle bundle, String str, zzp zzpVar) {
        boolean zza = zzigVar.zza.zze().zza(zzbn.zzcx);
        boolean zza2 = zzigVar.zza.zze().zza(zzbn.zzcz);
        if (bundle.isEmpty() && zza) {
            zzar zzf = zzigVar.zza.zzf();
            zzf.zzv();
            zzf.zzam();
            try {
                zzf.f_().execSQL("delete from default_event_params where app_id=?", new String[]{str});
                return;
            } catch (SQLiteException e5) {
                zzf.zzj().zzg().zza("Error clearing default event params", e5);
                return;
            }
        }
        zzigVar.zza.zzf().zza(str, bundle);
        if (zzigVar.zza.zzf().zza(str, zzpVar.zzae)) {
            if (zza2) {
                zzigVar.zza.zzf().zza(str, Long.valueOf(zzpVar.zzae), (String) null, bundle);
            } else {
                zzigVar.zza.zzf().zza(str, (Long) null, (String) null, bundle);
            }
        }
    }

    private final void zza(String str, boolean z5) {
        boolean z6;
        if (!TextUtils.isEmpty(str)) {
            if (z5) {
                try {
                    if (this.zzb == null) {
                        if (!"com.google.android.gms".equals(this.zzc) && !UidVerifier.isGooglePlayServicesUid(this.zza.zza(), Binder.getCallingUid()) && !GoogleSignatureVerifier.getInstance(this.zza.zza()).isUidGoogleSigned(Binder.getCallingUid())) {
                            z6 = false;
                            this.zzb = Boolean.valueOf(z6);
                        }
                        z6 = true;
                        this.zzb = Boolean.valueOf(z6);
                    }
                    if (this.zzb.booleanValue()) {
                        return;
                    }
                } catch (SecurityException e5) {
                    this.zza.zzj().zzg().zza("Measurement Service called with invalid calling package. appId", zzgo.zza(str));
                    throw e5;
                }
            }
            if (this.zzc == null && GooglePlayServicesUtilLight.uidHasPackageName(this.zza.zza(), Binder.getCallingUid(), str)) {
                this.zzc = str;
            }
            if (str.equals(this.zzc)) {
                return;
            } else {
                throw new SecurityException(String.format("Unknown calling package name '%s'.", str));
            }
        }
        this.zza.zzj().zzg().zza("Measurement Service called without app package");
        throw new SecurityException("Measurement Service called without app package");
    }

    @Override // com.google.android.gms.measurement.internal.zzfz
    public final void zza(zzp zzpVar, final zzop zzopVar, final zzgf zzgfVar) {
        if (this.zza.zze().zza(zzbn.zzcj)) {
            zzb(zzpVar, false);
            final String str = (String) Preconditions.checkNotNull(zzpVar.zza);
            this.zza.zzl().zzb(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzik
                @Override // java.lang.Runnable
                public final void run() {
                    zzig.zza(zzig.this, str, zzopVar, zzgfVar);
                }
            });
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzfz
    public final void zza(zzbl zzblVar, zzp zzpVar) {
        Preconditions.checkNotNull(zzblVar);
        zzb(zzpVar, false);
        zzb(new zziz(this, zzblVar, zzpVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzfz
    public final void zza(zzbl zzblVar, String str, String str2) {
        Preconditions.checkNotNull(zzblVar);
        Preconditions.checkNotEmpty(str);
        zza(str, true);
        zzb(new zzjc(this, zzblVar, str));
    }

    @Override // com.google.android.gms.measurement.internal.zzfz
    public final void zza(final zzp zzpVar, final Bundle bundle, final zzga zzgaVar) {
        zzb(zzpVar, false);
        final String str = (String) Preconditions.checkNotNull(zzpVar.zza);
        this.zza.zzl().zzb(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzii
            @Override // java.lang.Runnable
            public final void run() {
                zzig.zza(zzig.this, zzpVar, bundle, zzgaVar, str);
            }
        });
    }

    private final void zza(Runnable runnable) {
        Preconditions.checkNotNull(runnable);
        if (this.zza.zzl().zzm()) {
            runnable.run();
        } else {
            this.zza.zzl().zzc(runnable);
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzfz
    public final void zza(zzag zzagVar, zzp zzpVar) {
        Preconditions.checkNotNull(zzagVar);
        Preconditions.checkNotNull(zzagVar.zzc);
        zzb(zzpVar, false);
        zzag zzagVar2 = new zzag(zzagVar);
        zzagVar2.zza = zzpVar.zza;
        zzb(new zzis(this, zzagVar2, zzpVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzfz
    public final void zza(zzag zzagVar) {
        Preconditions.checkNotNull(zzagVar);
        Preconditions.checkNotNull(zzagVar.zzc);
        Preconditions.checkNotEmpty(zzagVar.zza);
        zza(zzagVar.zza, true);
        zzb(new zzir(this, new zzag(zzagVar)));
    }

    @Override // com.google.android.gms.measurement.internal.zzfz
    public final void zza(long j5, String str, String str2, String str3) {
        zzb(new zzip(this, str2, str3, str, j5));
    }

    @Override // com.google.android.gms.measurement.internal.zzfz
    public final void zza(final Bundle bundle, final zzp zzpVar) {
        zzb(zzpVar, false);
        final String str = zzpVar.zza;
        Preconditions.checkNotNull(str);
        zzb(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzim
            @Override // java.lang.Runnable
            public final void run() {
                zzig.zza(zzig.this, bundle, str, zzpVar);
            }
        });
    }

    @Override // com.google.android.gms.measurement.internal.zzfz
    public final void zza(zzpm zzpmVar, zzp zzpVar) {
        Preconditions.checkNotNull(zzpmVar);
        zzb(zzpVar, false);
        zzb(new zzje(this, zzpmVar, zzpVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzfz
    public final void zza(final zzp zzpVar, final zzae zzaeVar) {
        if (this.zza.zze().zza(zzbn.zzcj)) {
            zzb(zzpVar, false);
            zzb(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzif
                @Override // java.lang.Runnable
                public final void run() {
                    zzig.zza(zzig.this, zzpVar, zzaeVar);
                }
            });
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzfz
    public final byte[] zza(zzbl zzblVar, String str) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzblVar);
        zza(str, true);
        this.zza.zzj().zzc().zza("Log and bundle. event", this.zza.zzg().zza(zzblVar.zza));
        long nanoTime = this.zza.zzb().nanoTime() / 1000000;
        try {
            byte[] bArr = (byte[]) this.zza.zzl().zzb(new zzjb(this, zzblVar, str)).get();
            if (bArr == null) {
                this.zza.zzj().zzg().zza("Log and bundle returned null. appId", zzgo.zza(str));
                bArr = new byte[0];
            }
            this.zza.zzj().zzc().zza("Log and bundle processed. event, size, time_ms", this.zza.zzg().zza(zzblVar.zza), Integer.valueOf(bArr.length), Long.valueOf((this.zza.zzb().nanoTime() / 1000000) - nanoTime));
            return bArr;
        } catch (InterruptedException e5) {
            e = e5;
            this.zza.zzj().zzg().zza("Failed to log and bundle. appId, event, error", zzgo.zza(str), this.zza.zzg().zza(zzblVar.zza), e);
            return null;
        } catch (ExecutionException e6) {
            e = e6;
            this.zza.zzj().zzg().zza("Failed to log and bundle. appId, event, error", zzgo.zza(str), this.zza.zzg().zza(zzblVar.zza), e);
            return null;
        }
    }
}
