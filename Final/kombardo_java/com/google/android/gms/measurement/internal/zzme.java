package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class zzme extends zzf {
    private final zznj zza;
    private zzfz zzb;
    private volatile Boolean zzc;
    private final zzbb zzd;
    private final zzoh zze;
    private final List<Runnable> zzf;
    private final zzbb zzg;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzme(zzic zzicVar) {
        super(zzicVar);
        this.zzf = new ArrayList();
        this.zze = new zzoh(zzicVar.zzb());
        this.zza = new zznj(this);
        this.zzd = new zzmk(this, zzicVar);
        this.zzg = new zzmx(this, zzicVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaq() {
        zzv();
        zzj().zzq().zza("Processing queued up service tasks", Integer.valueOf(this.zzf.size()));
        Iterator<Runnable> it = this.zzf.iterator();
        while (it.hasNext()) {
            try {
                it.next().run();
            } catch (RuntimeException e5) {
                zzj().zzg().zza("Task exception while flushing queue", e5);
            }
        }
        this.zzf.clear();
        this.zzg.zza();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzar() {
        zzv();
        this.zze.zzb();
        this.zzd.zza(zzbn.zzat.zza(null).longValue());
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    protected final boolean zzab() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzap zzac() {
        zzv();
        zzw();
        zzfz zzfzVar = this.zzb;
        if (zzfzVar == null) {
            zzag();
            zzj().zzc().zza("Failed to get consents; not connected to service yet.");
            return null;
        }
        zzp zzc = zzc(false);
        Preconditions.checkNotNull(zzc);
        try {
            zzap zza = zzfzVar.zza(zzc);
            zzar();
            return zza;
        } catch (RemoteException e5) {
            zzj().zzg().zza("Failed to get consents; remote exception", e5);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Boolean zzad() {
        return this.zzc;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzae() {
        zzv();
        zzw();
        zza(new zzmw(this, zzc(true)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzaf() {
        zzv();
        zzw();
        zzp zzc = zzc(true);
        zzh().zzad();
        zza(new zzmu(this, zzc));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzag() {
        zzv();
        zzw();
        if (zzal()) {
            return;
        }
        if (zzap()) {
            this.zza.zza();
            return;
        }
        if (zze().zzz()) {
            return;
        }
        List<ResolveInfo> queryIntentServices = zza().getPackageManager().queryIntentServices(new Intent().setClassName(zza(), "com.google.android.gms.measurement.AppMeasurementService"), 65536);
        if (queryIntentServices == null || queryIntentServices.isEmpty()) {
            zzj().zzg().zza("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
            return;
        }
        Intent intent = new Intent("com.google.android.gms.measurement.START");
        intent.setComponent(new ComponentName(zza(), "com.google.android.gms.measurement.AppMeasurementService"));
        this.zza.zza(intent);
    }

    public final void zzah() {
        zzv();
        zzw();
        this.zza.zzb();
        try {
            ConnectionTracker.getInstance().unbindService(zza(), this.zza);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        this.zzb = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzai() {
        zzv();
        zzw();
        zzp zzc = zzc(false);
        zzh().zzac();
        zza(new zzmt(this, zzc));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzaj() {
        zzv();
        zzw();
        zza(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzmg
            @Override // java.lang.Runnable
            public final void run() {
                zzme.zzd(zzme.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzak() {
        zzv();
        zzw();
        zza(new zzna(this, zzc(true)));
    }

    public final boolean zzal() {
        zzv();
        zzw();
        return this.zzb != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzam() {
        zzv();
        zzw();
        return !zzap() || zzs().zzg() >= 200900;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzan() {
        zzv();
        zzw();
        return !zzap() || zzs().zzg() >= zzbn.zzcd.zza(null).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzao() {
        zzv();
        zzw();
        return !zzap() || zzs().zzg() >= 241200;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00f6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean zzap() {
        boolean z5;
        zzv();
        zzw();
        if (this.zzc == null) {
            zzv();
            zzw();
            Boolean zzq = zzk().zzq();
            if (zzq == null || !zzq.booleanValue()) {
                boolean z6 = false;
                if (zzg().zzac() != 1) {
                    zzj().zzq().zza("Checking service availability");
                    int zza = zzs().zza(GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
                    if (zza != 0) {
                        if (zza != 1) {
                            if (zza != 2) {
                                if (zza == 3) {
                                    zzj().zzr().zza("Service disabled");
                                } else if (zza == 9) {
                                    zzj().zzr().zza("Service invalid");
                                } else if (zza != 18) {
                                    zzj().zzr().zza("Unexpected service status", Integer.valueOf(zza));
                                } else {
                                    zzj().zzr().zza("Service updating");
                                }
                                z5 = false;
                                r1 = false;
                            } else {
                                zzj().zzc().zza("Service container out of date");
                                if (zzs().zzg() >= 17443) {
                                    r1 = zzq == null;
                                    z5 = false;
                                }
                            }
                            if (r1 && zze().zzz()) {
                                zzj().zzg().zza("No way to upload. Consider using the full version of Analytics");
                            } else {
                                z6 = z5;
                            }
                            if (z6) {
                                zzk().zza(r1);
                            }
                        } else {
                            zzj().zzq().zza("Service missing");
                        }
                        z5 = true;
                        r1 = false;
                        if (r1) {
                        }
                        z6 = z5;
                        if (z6) {
                        }
                    } else {
                        zzj().zzq().zza("Service available");
                    }
                }
                z5 = true;
                if (r1) {
                }
                z6 = z5;
                if (z6) {
                }
            }
            this.zzc = Boolean.valueOf(r1);
        }
        return this.zzc.booleanValue();
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    public final /* bridge */ /* synthetic */ zza zzc() {
        return super.zzc();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf, com.google.android.gms.measurement.internal.zzjh
    public final /* bridge */ /* synthetic */ zzaf zzd() {
        return super.zzd();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ zzbf zzf() {
        return super.zzf();
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    public final /* bridge */ /* synthetic */ zzgj zzh() {
        return super.zzh();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ zzgl zzi() {
        return super.zzi();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf, com.google.android.gms.measurement.internal.zzjh
    public final /* bridge */ /* synthetic */ zzgo zzj() {
        return super.zzj();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ zzha zzk() {
        return super.zzk();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf, com.google.android.gms.measurement.internal.zzjh
    public final /* bridge */ /* synthetic */ zzhv zzl() {
        return super.zzl();
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    public final /* bridge */ /* synthetic */ zzju zzm() {
        return super.zzm();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ zzlp zzn() {
        return super.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    public final /* bridge */ /* synthetic */ zzls zzo() {
        return super.zzo();
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    public final /* bridge */ /* synthetic */ zzlz zzp() {
        return super.zzp();
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    public final /* bridge */ /* synthetic */ zzme zzq() {
        return super.zzq();
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    public final /* bridge */ /* synthetic */ zznx zzr() {
        return super.zzr();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ zzpn zzs() {
        return super.zzs();
    }

    @Override // com.google.android.gms.measurement.internal.zzg, com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ void zzt() {
        super.zzt();
    }

    @Override // com.google.android.gms.measurement.internal.zzg, com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ void zzu() {
        super.zzu();
    }

    @Override // com.google.android.gms.measurement.internal.zzg, com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ void zzv() {
        super.zzv();
    }

    private final zzp zzc(boolean z5) {
        return zzg().zza(z5 ? zzj().zzy() : null);
    }

    public static /* synthetic */ void zzd(zzme zzmeVar) {
        zzfz zzfzVar = zzmeVar.zzb;
        if (zzfzVar == null) {
            zzmeVar.zzj().zzg().zza("Failed to send Dma consent settings to service");
            return;
        }
        try {
            zzp zzc = zzmeVar.zzc(false);
            Preconditions.checkNotNull(zzc);
            zzfzVar.zzg(zzc);
            zzmeVar.zzar();
        } catch (RemoteException e5) {
            zzmeVar.zzj().zzg().zza("Failed to send Dma consent settings to the service", e5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzf(zzme zzmeVar) {
        zzmeVar.zzv();
        if (zzmeVar.zzal()) {
            zzmeVar.zzj().zzq().zza("Inactivity, disconnecting from the service");
            zzmeVar.zzah();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzjf, com.google.android.gms.measurement.internal.zzjh
    public final /* bridge */ /* synthetic */ Clock zzb() {
        return super.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ zzai zze() {
        return super.zze();
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    public final /* bridge */ /* synthetic */ zzgg zzg() {
        return super.zzg();
    }

    public static /* synthetic */ void zzc(zzme zzmeVar) {
        zzfz zzfzVar = zzmeVar.zzb;
        if (zzfzVar == null) {
            zzmeVar.zzj().zzg().zza("Failed to send storage consent settings to service");
            return;
        }
        try {
            zzp zzc = zzmeVar.zzc(false);
            Preconditions.checkNotNull(zzc);
            zzfzVar.zzi(zzc);
            zzmeVar.zzar();
        } catch (RemoteException e5) {
            zzmeVar.zzj().zzg().zza("Failed to send storage consent settings to the service", e5);
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzjf, com.google.android.gms.measurement.internal.zzjh
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzb(boolean z5) {
        zzv();
        zzw();
        zza(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzmh
            @Override // java.lang.Runnable
            public final void run() {
                zzme.zzc(zzme.this);
            }
        });
    }

    public static /* synthetic */ void zza(zzme zzmeVar, AtomicReference atomicReference, zzp zzpVar, zzop zzopVar) {
        zzfz zzfzVar;
        synchronized (atomicReference) {
            try {
                zzfzVar = zzmeVar.zzb;
            } catch (RemoteException e5) {
                zzmeVar.zzj().zzg().zza("[sgtm] Failed to get upload batches; remote exception", e5);
                atomicReference.notifyAll();
            }
            if (zzfzVar == null) {
                zzmeVar.zzj().zzg().zza("[sgtm] Failed to get upload batches; not connected to service");
                return;
            }
            Preconditions.checkNotNull(zzpVar);
            zzfzVar.zza(zzpVar, zzopVar, new zzmr(zzmeVar, atomicReference));
            zzmeVar.zzar();
        }
    }

    public static /* synthetic */ void zza(zzme zzmeVar, AtomicReference atomicReference, zzp zzpVar, Bundle bundle) {
        zzfz zzfzVar;
        synchronized (atomicReference) {
            try {
                zzfzVar = zzmeVar.zzb;
            } catch (RemoteException e5) {
                zzmeVar.zzj().zzg().zza("Failed to request trigger URIs; remote exception", e5);
                atomicReference.notifyAll();
            }
            if (zzfzVar == null) {
                zzmeVar.zzj().zzg().zza("Failed to request trigger URIs; not connected to service");
                return;
            }
            Preconditions.checkNotNull(zzpVar);
            zzfzVar.zza(zzpVar, bundle, new zzmp(zzmeVar, atomicReference));
            zzmeVar.zzar();
        }
    }

    public static /* synthetic */ void zza(zzme zzmeVar, zzp zzpVar, zzae zzaeVar) {
        zzfz zzfzVar = zzmeVar.zzb;
        if (zzfzVar == null) {
            zzmeVar.zzj().zzg().zza("[sgtm] Discarding data. Failed to update batch upload status.");
            return;
        }
        try {
            zzfzVar.zza(zzpVar, zzaeVar);
            zzmeVar.zzar();
        } catch (RemoteException e5) {
            zzmeVar.zzj().zzg().zza("[sgtm] Failed to update batch upload status, rowId, exception", Long.valueOf(zzaeVar.zza), e5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zza(zzme zzmeVar, ComponentName componentName) {
        zzmeVar.zzv();
        if (zzmeVar.zzb != null) {
            zzmeVar.zzb = null;
            zzmeVar.zzj().zzq().zza("Disconnected from device MeasurementService", componentName);
            zzmeVar.zzv();
            zzmeVar.zzag();
        }
    }

    public final void zza(com.google.android.gms.internal.measurement.zzdq zzdqVar) {
        zzv();
        zzw();
        zza(new zzmv(this, zzc(false), zzdqVar));
    }

    public final void zza(AtomicReference<String> atomicReference) {
        zzv();
        zzw();
        zza(new zzms(this, atomicReference, zzc(false)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zza(com.google.android.gms.internal.measurement.zzdq zzdqVar, String str, String str2) {
        zzv();
        zzw();
        zza(new zznh(this, str, str2, zzc(false), zzdqVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zza(AtomicReference<List<zzag>> atomicReference, String str, String str2, String str3) {
        zzv();
        zzw();
        zza(new zzne(this, atomicReference, str, str2, str3, zzc(false)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zza(final AtomicReference<List<zzog>> atomicReference, final Bundle bundle) {
        zzv();
        zzw();
        final zzp zzc = zzc(false);
        if (zze().zza(zzbn.zzdd)) {
            zza(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzmi
                @Override // java.lang.Runnable
                public final void run() {
                    zzme.zza(zzme.this, atomicReference, zzc, bundle);
                }
            });
        } else {
            zza(new zzmo(this, atomicReference, zzc, bundle));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zza(final AtomicReference<zzor> atomicReference, final zzop zzopVar) {
        zzv();
        zzw();
        final zzp zzc = zzc(false);
        zza(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzml
            @Override // java.lang.Runnable
            public final void run() {
                zzme.zza(zzme.this, atomicReference, zzc, zzopVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zza(com.google.android.gms.internal.measurement.zzdq zzdqVar, String str, String str2, boolean z5) {
        zzv();
        zzw();
        zza(new zzmn(this, str, str2, zzc(false), z5, zzdqVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zza(AtomicReference<List<zzpm>> atomicReference, String str, String str2, String str3, boolean z5) {
        zzv();
        zzw();
        zza(new zzng(this, atomicReference, str, str2, str3, zzc(false), z5));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zza(zzbl zzblVar, String str) {
        Preconditions.checkNotNull(zzblVar);
        zzv();
        zzw();
        zza(new zznc(this, true, zzc(true), zzh().zza(zzblVar), zzblVar, str));
    }

    public final void zza(com.google.android.gms.internal.measurement.zzdq zzdqVar, zzbl zzblVar, String str) {
        zzv();
        zzw();
        if (zzs().zza(GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE) != 0) {
            zzj().zzr().zza("Not bundling data. Service unavailable or out of date");
            zzs().zza(zzdqVar, new byte[0]);
        } else {
            zza(new zznb(this, zzblVar, str, zzdqVar));
        }
    }

    private final void zza(Runnable runnable) {
        zzv();
        if (zzal()) {
            runnable.run();
        } else {
            if (this.zzf.size() >= 1000) {
                zzj().zzg().zza("Discarding data. Max runnable queue size reached");
                return;
            }
            this.zzf.add(runnable);
            this.zzg.zza(60000L);
            zzag();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0139 A[ADDED_TO_REGION, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zza(zzfz zzfzVar, AbstractSafeParcelable abstractSafeParcelable, zzp zzpVar) {
        int i5;
        long j5;
        long j6;
        long currentTimeMillis;
        zzv();
        zzw();
        int i6 = 100;
        int i7 = 0;
        for (int i8 = 100; i7 < 1001 && i6 == i8; i8 = 100) {
            ArrayList arrayList = new ArrayList();
            List<AbstractSafeParcelable> zza = zzh().zza(i8);
            if (zza != null) {
                arrayList.addAll(zza);
                i5 = zza.size();
            } else {
                i5 = 0;
            }
            if (abstractSafeParcelable != null && i5 < i8) {
                arrayList.add(abstractSafeParcelable);
            }
            boolean zza2 = zze().zza(zzbn.zzco);
            int size = arrayList.size();
            int i9 = 0;
            while (i9 < size) {
                int i10 = i9 + 1;
                AbstractSafeParcelable abstractSafeParcelable2 = (AbstractSafeParcelable) arrayList.get(i9);
                if (abstractSafeParcelable2 instanceof zzbl) {
                    if (zza2) {
                        try {
                            currentTimeMillis = this.zzu.zzb().currentTimeMillis();
                            try {
                                j5 = this.zzu.zzb().elapsedRealtime();
                            } catch (RemoteException e5) {
                                e = e5;
                                j5 = 0;
                                j6 = currentTimeMillis;
                                zzj().zzg().zza("Failed to send event to the service", e);
                                if (!zza2) {
                                    zzgm.zza(this.zzu).zza(36301, 13, j6, this.zzu.zzb().currentTimeMillis(), (int) (this.zzu.zzb().elapsedRealtime() - j5));
                                }
                                i9 = i10;
                            }
                        } catch (RemoteException e6) {
                            e = e6;
                            j5 = 0;
                            j6 = 0;
                            zzj().zzg().zza("Failed to send event to the service", e);
                            if (!zza2) {
                            }
                            i9 = i10;
                        }
                    } else {
                        currentTimeMillis = 0;
                        j5 = 0;
                    }
                    try {
                        zzfzVar.zza((zzbl) abstractSafeParcelable2, zzpVar);
                        if (zza2) {
                            zzj().zzq().zza("Logging telemetry for logEvent from database");
                            zzgm.zza(this.zzu).zza(36301, 0, currentTimeMillis, this.zzu.zzb().currentTimeMillis(), (int) (this.zzu.zzb().elapsedRealtime() - j5));
                        }
                    } catch (RemoteException e7) {
                        e = e7;
                        j6 = currentTimeMillis;
                        zzj().zzg().zza("Failed to send event to the service", e);
                        if (!zza2 && j6 != 0) {
                            zzgm.zza(this.zzu).zza(36301, 13, j6, this.zzu.zzb().currentTimeMillis(), (int) (this.zzu.zzb().elapsedRealtime() - j5));
                        }
                        i9 = i10;
                    }
                } else if (abstractSafeParcelable2 instanceof zzpm) {
                    try {
                        zzfzVar.zza((zzpm) abstractSafeParcelable2, zzpVar);
                    } catch (RemoteException e8) {
                        zzj().zzg().zza("Failed to send user property to the service", e8);
                    }
                } else if (abstractSafeParcelable2 instanceof zzag) {
                    try {
                        zzfzVar.zza((zzag) abstractSafeParcelable2, zzpVar);
                    } catch (RemoteException e9) {
                        zzj().zzg().zza("Failed to send conditional user property to the service", e9);
                    }
                } else {
                    zzj().zzg().zza("Discarding data. Unrecognized parcel type.");
                }
                i9 = i10;
            }
            i7++;
            i6 = i5;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zza(zzag zzagVar) {
        Preconditions.checkNotNull(zzagVar);
        zzv();
        zzw();
        zza(new zznf(this, true, zzc(true), zzh().zza(zzagVar), new zzag(zzagVar), zzagVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zza(boolean z5) {
        zzv();
        zzw();
        if (zzan()) {
            zza(new zznd(this, zzc(false)));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zza(zzlw zzlwVar) {
        zzv();
        zzw();
        zza(new zzmz(this, zzlwVar));
    }

    public final void zza(Bundle bundle) {
        zzv();
        zzw();
        zza(new zzmy(this, zzc(false), bundle));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zza(zzfz zzfzVar) {
        zzv();
        Preconditions.checkNotNull(zzfzVar);
        this.zzb = zzfzVar;
        zzar();
        zzaq();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zza(zzpm zzpmVar) {
        zzv();
        zzw();
        zza(new zzmq(this, zzc(true), zzh().zza(zzpmVar), zzpmVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zza(final zzae zzaeVar) {
        zzv();
        zzw();
        final zzp zzc = zzc(true);
        Preconditions.checkNotNull(zzc);
        zza(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzmj
            @Override // java.lang.Runnable
            public final void run() {
                zzme.zza(zzme.this, zzc, zzaeVar);
            }
        });
    }
}
