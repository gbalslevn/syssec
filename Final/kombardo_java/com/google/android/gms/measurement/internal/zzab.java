package com.google.android.gms.measurement.internal;

import androidx.collection.ArrayMap;
import com.google.android.gms.internal.measurement.zzfw$zzb;
import com.google.android.gms.internal.measurement.zzfw$zzc;
import com.google.android.gms.internal.measurement.zzgf$zzf;
import com.google.android.gms.internal.measurement.zzgf$zzh;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzab extends zzaa {
    private zzfw$zzb zzg;
    private final /* synthetic */ zzx zzh;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzab(zzx zzxVar, String str, int i5, zzfw$zzb zzfw_zzb) {
        super(str, i5);
        this.zzh = zzxVar;
        this.zzg = zzfw_zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.measurement.internal.zzaa
    public final int zza() {
        return this.zzg.zzb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.measurement.internal.zzaa
    public final boolean zzb() {
        return this.zzg.zzk();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.measurement.internal.zzaa
    public final boolean zzc() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:42:0x03ae  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x03b9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x03ba  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x03b1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean zza(Long l5, Long l6, zzgf$zzf zzgf_zzf, long j5, zzbh zzbhVar, boolean z5) {
        Boolean zza;
        Object[] objArr = com.google.android.gms.internal.measurement.zzoh.zza() && this.zzh.zze().zzf(this.zza, zzbn.zzbz);
        long j6 = this.zzg.zzj() ? zzbhVar.zze : j5;
        r7 = null;
        r7 = null;
        r7 = null;
        r7 = null;
        r7 = null;
        r7 = null;
        r7 = null;
        r7 = null;
        r7 = null;
        r7 = null;
        r7 = null;
        Boolean bool = null;
        if (this.zzh.zzj().zza(2)) {
            this.zzh.zzj().zzq().zza("Evaluating filter. audience, filter, event", Integer.valueOf(this.zzb), this.zzg.zzl() ? Integer.valueOf(this.zzg.zzb()) : null, this.zzh.zzi().zza(this.zzg.zzf()));
            this.zzh.zzj().zzq().zza("Filter definition", this.zzh.h_().zza(this.zzg));
        }
        if (!this.zzg.zzl() || this.zzg.zzb() > 256) {
            this.zzh.zzj().zzr().zza("Invalid event filter ID. appId, id", zzgo.zza(this.zza), String.valueOf(this.zzg.zzl() ? Integer.valueOf(this.zzg.zzb()) : null));
            return false;
        }
        Object[] objArr2 = this.zzg.zzh() || this.zzg.zzi() || this.zzg.zzj();
        if (z5 && objArr2 == false) {
            this.zzh.zzj().zzq().zza("Event filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID", Integer.valueOf(this.zzb), this.zzg.zzl() ? Integer.valueOf(this.zzg.zzb()) : null);
            return true;
        }
        zzfw$zzb zzfw_zzb = this.zzg;
        String zzg = zzgf_zzf.zzg();
        if (zzfw_zzb.zzk()) {
            Boolean zza2 = zzaa.zza(j6, zzfw_zzb.zze());
            if (zza2 != null) {
                if (!zza2.booleanValue()) {
                    bool = Boolean.FALSE;
                }
            }
            this.zzh.zzj().zzq().zza("Event filter result", bool != null ? "null" : bool);
            if (bool != null) {
                return false;
            }
            Boolean bool2 = Boolean.TRUE;
            this.zzc = bool2;
            if (!bool.booleanValue()) {
                return true;
            }
            this.zzd = bool2;
            if (objArr2 != false && zzgf_zzf.zzk()) {
                Long valueOf = Long.valueOf(zzgf_zzf.zzd());
                if (this.zzg.zzi()) {
                    if (objArr != false && this.zzg.zzk()) {
                        valueOf = l5;
                    }
                    this.zzf = valueOf;
                } else {
                    if (objArr != false && this.zzg.zzk()) {
                        valueOf = l6;
                    }
                    this.zze = valueOf;
                }
            }
            return true;
        }
        HashSet hashSet = new HashSet();
        Iterator<zzfw$zzc> it = zzfw_zzb.zzg().iterator();
        while (true) {
            if (it.hasNext()) {
                zzfw$zzc next = it.next();
                if (next.zze().isEmpty()) {
                    this.zzh.zzj().zzr().zza("null or empty param name in filter. event", this.zzh.zzi().zza(zzg));
                    break;
                }
                hashSet.add(next.zze());
            } else {
                ArrayMap arrayMap = new ArrayMap();
                Iterator<zzgf$zzh> it2 = zzgf_zzf.zzh().iterator();
                while (true) {
                    if (it2.hasNext()) {
                        zzgf$zzh next2 = it2.next();
                        if (hashSet.contains(next2.zzg())) {
                            if (next2.zzl()) {
                                arrayMap.put(next2.zzg(), next2.zzl() ? Long.valueOf(next2.zzd()) : null);
                            } else if (next2.zzj()) {
                                arrayMap.put(next2.zzg(), next2.zzj() ? Double.valueOf(next2.zza()) : null);
                            } else if (next2.zzn()) {
                                arrayMap.put(next2.zzg(), next2.zzh());
                            } else {
                                this.zzh.zzj().zzr().zza("Unknown value for param. event, param", this.zzh.zzi().zza(zzg), this.zzh.zzi().zzb(next2.zzg()));
                                break;
                            }
                        }
                    } else {
                        Iterator<zzfw$zzc> it3 = zzfw_zzb.zzg().iterator();
                        while (true) {
                            if (it3.hasNext()) {
                                zzfw$zzc next3 = it3.next();
                                boolean z6 = next3.zzg() && next3.zzf();
                                String zze = next3.zze();
                                if (zze.isEmpty()) {
                                    this.zzh.zzj().zzr().zza("Event has empty param name. event", this.zzh.zzi().zza(zzg));
                                    break;
                                }
                                Object obj = arrayMap.get(zze);
                                if (obj instanceof Long) {
                                    if (!next3.zzh()) {
                                        this.zzh.zzj().zzr().zza("No number filter for long param. event, param", this.zzh.zzi().zza(zzg), this.zzh.zzi().zzb(zze));
                                        break;
                                    }
                                    Boolean zza3 = zzaa.zza(((Long) obj).longValue(), next3.zzc());
                                    if (zza3 == null) {
                                        break;
                                    }
                                    if (zza3.booleanValue() == z6) {
                                        bool = Boolean.FALSE;
                                        break;
                                    }
                                } else if (obj instanceof Double) {
                                    if (!next3.zzh()) {
                                        this.zzh.zzj().zzr().zza("No number filter for double param. event, param", this.zzh.zzi().zza(zzg), this.zzh.zzi().zzb(zze));
                                        break;
                                    }
                                    Boolean zza4 = zzaa.zza(((Double) obj).doubleValue(), next3.zzc());
                                    if (zza4 == null) {
                                        break;
                                    }
                                    if (zza4.booleanValue() == z6) {
                                        bool = Boolean.FALSE;
                                        break;
                                    }
                                } else if (obj instanceof String) {
                                    if (next3.zzj()) {
                                        zza = zzaa.zza((String) obj, next3.zzd(), this.zzh.zzj());
                                    } else if (next3.zzh()) {
                                        String str = (String) obj;
                                        if (zzpj.zzb(str)) {
                                            zza = zzaa.zza(str, next3.zzc());
                                        } else {
                                            this.zzh.zzj().zzr().zza("Invalid param value for number filter. event, param", this.zzh.zzi().zza(zzg), this.zzh.zzi().zzb(zze));
                                            break;
                                        }
                                    } else {
                                        this.zzh.zzj().zzr().zza("No filter for String param. event, param", this.zzh.zzi().zza(zzg), this.zzh.zzi().zzb(zze));
                                        break;
                                    }
                                    if (zza == null) {
                                        break;
                                    }
                                    if (zza.booleanValue() == z6) {
                                        bool = Boolean.FALSE;
                                        break;
                                    }
                                } else if (obj == null) {
                                    this.zzh.zzj().zzq().zza("Missing param for filter. event, param", this.zzh.zzi().zza(zzg), this.zzh.zzi().zzb(zze));
                                    bool = Boolean.FALSE;
                                } else {
                                    this.zzh.zzj().zzr().zza("Unknown param type. event, param", this.zzh.zzi().zza(zzg), this.zzh.zzi().zzb(zze));
                                }
                            } else {
                                bool = Boolean.TRUE;
                                break;
                            }
                        }
                    }
                }
            }
        }
        this.zzh.zzj().zzq().zza("Event filter result", bool != null ? "null" : bool);
        if (bool != null) {
        }
    }
}
