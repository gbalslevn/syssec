package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class zzb {
    private final zzf zza;
    private zzh zzb;
    private zzac zzc;
    private final zzaa zzd;

    public zzb() {
        this(new zzf());
    }

    public static /* synthetic */ zzal zzb(zzb zzbVar) {
        return new zzw(zzbVar.zzd);
    }

    public final zzac zza() {
        return this.zzc;
    }

    public final boolean zzc() {
        return !this.zzc.zzb().equals(this.zzc.zza());
    }

    private zzb(zzf zzfVar) {
        this.zza = zzfVar;
        this.zzb = zzfVar.zza.zza();
        this.zzc = new zzac();
        this.zzd = new zzaa();
        zzfVar.zza("internal.registerCallback", new Callable() { // from class: com.google.android.gms.internal.measurement.zza
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzb.zzb(zzb.this);
            }
        });
        zzfVar.zza("internal.eventLogger", new Callable() { // from class: com.google.android.gms.internal.measurement.zzd
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzb.zza(zzb.this);
            }
        });
    }

    public static /* synthetic */ zzal zza(zzb zzbVar) {
        return new zzk(zzbVar.zzc);
    }

    public final boolean zzb() {
        return !this.zzc.zzc().isEmpty();
    }

    public final void zza(zzgr$zzc zzgr_zzc) {
        zzal zzalVar;
        try {
            this.zzb = this.zza.zza.zza();
            if (!(this.zza.zza(this.zzb, (zzgr$zzd[]) zzgr_zzc.zzc().toArray(new zzgr$zzd[0])) instanceof zzaj)) {
                for (zzgr$zzb zzgr_zzb : zzgr_zzc.zza().zzd()) {
                    List<zzgr$zzd> zzc = zzgr_zzb.zzc();
                    String zzb = zzgr_zzb.zzb();
                    Iterator<zzgr$zzd> it = zzc.iterator();
                    while (it.hasNext()) {
                        zzaq zza = this.zza.zza(this.zzb, it.next());
                        if (zza instanceof zzap) {
                            zzh zzhVar = this.zzb;
                            if (zzhVar.zzb(zzb)) {
                                zzaq zza2 = zzhVar.zza(zzb);
                                if (zza2 instanceof zzal) {
                                    zzalVar = (zzal) zza2;
                                } else {
                                    throw new IllegalStateException("Invalid function name: " + zzb);
                                }
                            } else {
                                zzalVar = null;
                            }
                            if (zzalVar != null) {
                                zzalVar.zza(this.zzb, Collections.singletonList(zza));
                            } else {
                                throw new IllegalStateException("Rule function is undefined: " + zzb);
                            }
                        } else {
                            throw new IllegalArgumentException("Invalid rule definition");
                        }
                    }
                }
                return;
            }
            throw new IllegalStateException("Program loading failed");
        } catch (Throwable th) {
            throw new zzc(th);
        }
    }

    public final void zza(String str, Callable<? extends zzal> callable) {
        this.zza.zza(str, callable);
    }

    public final boolean zza(zzad zzadVar) {
        try {
            this.zzc.zza(zzadVar);
            this.zza.zzb.zzc("runtime.counter", new zzai(Double.valueOf(0.0d)));
            this.zzd.zza(this.zzb.zza(), this.zzc);
            if (zzc()) {
                return true;
            }
            return zzb();
        } catch (Throwable th) {
            throw new zzc(th);
        }
    }
}
