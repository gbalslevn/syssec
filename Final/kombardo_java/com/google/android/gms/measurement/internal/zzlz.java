package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.sdk.growthbook.utils.Constants;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import org.conscrypt.BuildConfig;

/* loaded from: classes.dex */
public final class zzlz extends zzf {
    protected zzlw zza;
    private volatile zzlw zzb;
    private volatile zzlw zzc;
    private final Map<Integer, zzlw> zzd;
    private com.google.android.gms.internal.measurement.zzeb zze;
    private volatile boolean zzf;
    private volatile zzlw zzg;
    private zzlw zzh;
    private boolean zzi;
    private final Object zzj;

    public zzlz(zzic zzicVar) {
        super(zzicVar);
        this.zzj = new Object();
        this.zzd = new ConcurrentHashMap();
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    protected final boolean zzab() {
        return false;
    }

    public final zzlw zzac() {
        return this.zzb;
    }

    @Override // com.google.android.gms.measurement.internal.zzjf, com.google.android.gms.measurement.internal.zzjh
    public final /* bridge */ /* synthetic */ Clock zzb() {
        return super.zzb();
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
    public final /* bridge */ /* synthetic */ zzai zze() {
        return super.zze();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ zzbf zzf() {
        return super.zzf();
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    public final /* bridge */ /* synthetic */ zzgg zzg() {
        return super.zzg();
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

    private final zzlw zzd(com.google.android.gms.internal.measurement.zzeb zzebVar) {
        Preconditions.checkNotNull(zzebVar);
        zzlw zzlwVar = this.zzd.get(Integer.valueOf(zzebVar.zza));
        if (zzlwVar == null) {
            zzlw zzlwVar2 = new zzlw(null, zza(zzebVar.zzb, "Activity"), zzs().zzo());
            this.zzd.put(Integer.valueOf(zzebVar.zza), zzlwVar2);
            zzlwVar = zzlwVar2;
        }
        return this.zzg != null ? this.zzg : zzlwVar;
    }

    public final void zzb(com.google.android.gms.internal.measurement.zzeb zzebVar) {
        synchronized (this.zzj) {
            this.zzi = false;
            this.zzf = true;
        }
        long elapsedRealtime = zzb().elapsedRealtime();
        if (!zze().zzx()) {
            this.zzb = null;
            zzl().zzb(new zzmd(this, elapsedRealtime));
        } else {
            zzlw zzd = zzd(zzebVar);
            this.zzc = this.zzb;
            this.zzb = null;
            zzl().zzb(new zzmc(this, zzd, elapsedRealtime));
        }
    }

    public final void zzc(com.google.android.gms.internal.measurement.zzeb zzebVar) {
        synchronized (this.zzj) {
            this.zzi = true;
            if (!Objects.equals(zzebVar, this.zze)) {
                synchronized (this.zzj) {
                    this.zze = zzebVar;
                    this.zzf = false;
                }
                if (zze().zzx()) {
                    this.zzg = null;
                    zzl().zzb(new zzmf(this));
                }
            }
        }
        if (!zze().zzx()) {
            this.zzb = this.zzg;
            zzl().zzb(new zzma(this));
            return;
        }
        zza(zzebVar.zzb, zzd(zzebVar), false);
        zza zzc = zzc();
        zzc.zzl().zzb(new zze(zzc, zzc.zzb().elapsedRealtime()));
    }

    @Override // com.google.android.gms.measurement.internal.zzjf, com.google.android.gms.measurement.internal.zzjh
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    public final zzlw zza(boolean z5) {
        zzw();
        zzv();
        if (!z5) {
            return this.zza;
        }
        zzlw zzlwVar = this.zza;
        return zzlwVar != null ? zzlwVar : this.zzh;
    }

    private final String zza(String str, String str2) {
        String str3;
        if (str == null) {
            return str2;
        }
        String[] split = str.split("\\.");
        if (split.length > 0) {
            str3 = split[split.length - 1];
        } else {
            str3 = BuildConfig.FLAVOR;
        }
        return str3.length() > zze().zza((String) null, false) ? str3.substring(0, zze().zza((String) null, false)) : str3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zza(zzlz zzlzVar, Bundle bundle, zzlw zzlwVar, zzlw zzlwVar2, long j5) {
        if (bundle != null) {
            bundle.remove("screen_name");
            bundle.remove("screen_class");
        }
        zzlzVar.zza(zzlwVar, zzlwVar2, j5, true, zzlzVar.zzs().zza((String) null, "screen_view", bundle, (List<String>) null, false));
    }

    public final void zzb(com.google.android.gms.internal.measurement.zzeb zzebVar, Bundle bundle) {
        zzlw zzlwVar;
        if (!zze().zzx() || bundle == null || (zzlwVar = this.zzd.get(Integer.valueOf(zzebVar.zza))) == null) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putLong(Constants.ID_ATTRIBUTE_KEY, zzlwVar.zzc);
        bundle2.putString("name", zzlwVar.zza);
        bundle2.putString("referrer_name", zzlwVar.zzb);
        bundle.putBundle("com.google.app_measurement.screen_service", bundle2);
    }

    private final void zza(String str, zzlw zzlwVar, boolean z5) {
        zzlw zzlwVar2;
        zzlw zzlwVar3 = this.zzb == null ? this.zzc : this.zzb;
        if (zzlwVar.zzb == null) {
            zzlwVar2 = new zzlw(zzlwVar.zza, str != null ? zza(str, "Activity") : null, zzlwVar.zzc, zzlwVar.zze, zzlwVar.zzf);
        } else {
            zzlwVar2 = zzlwVar;
        }
        this.zzc = this.zzb;
        this.zzb = zzlwVar2;
        zzl().zzb(new zzmb(this, zzlwVar2, zzlwVar3, zzb().elapsedRealtime(), z5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r8v4, types: [android.os.BaseBundle] */
    /* JADX WARN: Type inference failed for: r8v5, types: [long, android.os.BaseBundle] */
    public final void zza(zzlw zzlwVar, zzlw zzlwVar2, long j5, boolean z5, Bundle bundle) {
        String str;
        long j6;
        zzv();
        boolean z6 = false;
        boolean z7 = (zzlwVar2 != null && zzlwVar2.zzc == zzlwVar.zzc && Objects.equals(zzlwVar2.zzb, zzlwVar.zzb) && Objects.equals(zzlwVar2.zza, zzlwVar.zza)) ? false : true;
        if (z5 && this.zza != null) {
            z6 = true;
        }
        if (z7) {
            zzpn.zza(zzlwVar, bundle != null ? new Bundle(bundle) : new Bundle(), true);
            if (zzlwVar2 != null) {
                String str2 = zzlwVar2.zza;
                if (str2 != null) {
                    "_pn".putString("_pn", str2);
                }
                String str3 = zzlwVar2.zzb;
                if (str3 != null) {
                    "_pc".putString("_pc", str3);
                }
                ?? r8 = zzlwVar2.zzc;
                r8.putLong("_pi", r8);
            }
            ?? r82 = 0;
            if (z6) {
                long zza = zzr().zzb.zza(j5);
                if (zza > 0) {
                    zzs().zza((Bundle) null, zza);
                }
            }
            if (!zze().zzx()) {
                r82.putLong("_mst", 1L);
            }
            if (zzlwVar.zze) {
                str = "app";
            } else {
                str = "auto";
            }
            String str4 = str;
            long currentTimeMillis = zzb().currentTimeMillis();
            if (zzlwVar.zze) {
                currentTimeMillis = zzlwVar.zzf;
                if (currentTimeMillis != 0) {
                    j6 = currentTimeMillis;
                    zzm().zza(str4, "_vs", j6, (Bundle) null);
                }
            }
            j6 = currentTimeMillis;
            zzm().zza(str4, "_vs", j6, (Bundle) null);
        }
        if (z6) {
            zza(this.zza, true, j5);
        }
        this.zza = zzlwVar;
        if (zzlwVar.zze) {
            this.zzh = zzlwVar;
        }
        zzq().zza(zzlwVar);
    }

    public final void zza(com.google.android.gms.internal.measurement.zzeb zzebVar, Bundle bundle) {
        Bundle bundle2;
        if (!zze().zzx() || bundle == null || (bundle2 = bundle.getBundle("com.google.app_measurement.screen_service")) == null) {
            return;
        }
        this.zzd.put(Integer.valueOf(zzebVar.zza), new zzlw(bundle2.getString("name"), bundle2.getString("referrer_name"), bundle2.getLong(Constants.ID_ATTRIBUTE_KEY)));
    }

    public final void zza(com.google.android.gms.internal.measurement.zzeb zzebVar) {
        synchronized (this.zzj) {
            try {
                if (Objects.equals(this.zze, zzebVar)) {
                    this.zze = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (zze().zzx()) {
            this.zzd.remove(Integer.valueOf(zzebVar.zza));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzlw zzlwVar, boolean z5, long j5) {
        zzc().zza(zzb().elapsedRealtime());
        if (!zzr().zza(zzlwVar != null && zzlwVar.zzd, z5, j5) || zzlwVar == null) {
            return;
        }
        zzlwVar.zzd = false;
    }

    @Deprecated
    public final void zza(com.google.android.gms.internal.measurement.zzeb zzebVar, String str, String str2) {
        if (!zze().zzx()) {
            zzj().zzw().zza("setCurrentScreen cannot be called while screen reporting is disabled.");
            return;
        }
        zzlw zzlwVar = this.zzb;
        if (zzlwVar == null) {
            zzj().zzw().zza("setCurrentScreen cannot be called while no activity active");
            return;
        }
        if (this.zzd.get(Integer.valueOf(zzebVar.zza)) == null) {
            zzj().zzw().zza("setCurrentScreen must be called with an activity in the activity lifecycle");
            return;
        }
        if (str2 == null) {
            str2 = zza(zzebVar.zzb, "Activity");
        }
        boolean equals = Objects.equals(zzlwVar.zzb, str2);
        boolean equals2 = Objects.equals(zzlwVar.zza, str);
        if (equals && equals2) {
            zzj().zzw().zza("setCurrentScreen cannot be called with the same class and name");
            return;
        }
        if (str != null && (str.length() <= 0 || str.length() > zze().zza((String) null, false))) {
            zzj().zzw().zza("Invalid screen name length in setCurrentScreen. Length", Integer.valueOf(str.length()));
            return;
        }
        if (str2 != null && (str2.length() <= 0 || str2.length() > zze().zza((String) null, false))) {
            zzj().zzw().zza("Invalid class name length in setCurrentScreen. Length", Integer.valueOf(str2.length()));
            return;
        }
        zzj().zzq().zza("Setting current screen to name, class", str == null ? "null" : str, str2);
        zzlw zzlwVar2 = new zzlw(str, str2, zzs().zzo());
        this.zzd.put(Integer.valueOf(zzebVar.zza), zzlwVar2);
        zza(zzebVar.zzb, zzlwVar2, true);
    }

    public final void zza(Bundle bundle, long j5) {
        String str;
        synchronized (this.zzj) {
            try {
                if (!this.zzi) {
                    zzj().zzw().zza("Cannot log screen view event when the app is in the background.");
                    return;
                }
                String str2 = null;
                if (bundle != null) {
                    String string = bundle.getString("screen_name");
                    if (string != null && (string.length() <= 0 || string.length() > zze().zza((String) null, false))) {
                        zzj().zzw().zza("Invalid screen name length for screen view. Length", Integer.valueOf(string.length()));
                        return;
                    }
                    String string2 = bundle.getString("screen_class");
                    if (string2 != null && (string2.length() <= 0 || string2.length() > zze().zza((String) null, false))) {
                        zzj().zzw().zza("Invalid screen class length for screen view. Length", Integer.valueOf(string2.length()));
                        return;
                    } else {
                        str = string;
                        str2 = string2;
                    }
                } else {
                    str = null;
                }
                if (str2 == null) {
                    com.google.android.gms.internal.measurement.zzeb zzebVar = this.zze;
                    if (zzebVar != null) {
                        str2 = zza(zzebVar.zzb, "Activity");
                    } else {
                        str2 = "Activity";
                    }
                }
                String str3 = str2;
                zzlw zzlwVar = this.zzb;
                if (this.zzf && zzlwVar != null) {
                    this.zzf = false;
                    boolean equals = Objects.equals(zzlwVar.zzb, str3);
                    boolean equals2 = Objects.equals(zzlwVar.zza, str);
                    if (equals && equals2) {
                        zzj().zzw().zza("Ignoring call to log screen view event with duplicate parameters.");
                        return;
                    }
                }
                zzj().zzq().zza("Logging screen view with name, class", str == null ? "null" : str, str3 == null ? "null" : str3);
                zzlw zzlwVar2 = this.zzb == null ? this.zzc : this.zzb;
                zzlw zzlwVar3 = new zzlw(str, str3, zzs().zzo(), true, j5);
                this.zzb = zzlwVar3;
                this.zzc = zzlwVar2;
                this.zzg = zzlwVar3;
                zzl().zzb(new zzly(this, bundle, zzlwVar3, zzlwVar2, zzb().elapsedRealtime()));
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
