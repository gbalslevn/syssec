package com.google.android.gms.internal.measurement;

import java.util.List;

/* loaded from: classes.dex */
public final class zzba extends zzay {
    public zzba() {
        this.zza.add(zzbv.EQUALS);
        this.zza.add(zzbv.GREATER_THAN);
        this.zza.add(zzbv.GREATER_THAN_EQUALS);
        this.zza.add(zzbv.IDENTITY_EQUALS);
        this.zza.add(zzbv.IDENTITY_NOT_EQUALS);
        this.zza.add(zzbv.LESS_THAN);
        this.zza.add(zzbv.LESS_THAN_EQUALS);
        this.zza.add(zzbv.NOT_EQUALS);
    }

    private static boolean zzb(zzaq zzaqVar, zzaq zzaqVar2) {
        if (zzaqVar instanceof zzak) {
            zzaqVar = new zzas(zzaqVar.zzf());
        }
        if (zzaqVar2 instanceof zzak) {
            zzaqVar2 = new zzas(zzaqVar2.zzf());
        }
        if ((zzaqVar instanceof zzas) && (zzaqVar2 instanceof zzas)) {
            return zzaqVar.zzf().compareTo(zzaqVar2.zzf()) < 0;
        }
        double doubleValue = zzaqVar.zze().doubleValue();
        double doubleValue2 = zzaqVar2.zze().doubleValue();
        return (Double.isNaN(doubleValue) || Double.isNaN(doubleValue2) || (doubleValue == 0.0d && doubleValue2 == -0.0d) || ((doubleValue == -0.0d && doubleValue2 == 0.0d) || Double.compare(doubleValue, doubleValue2) >= 0)) ? false : true;
    }

    private static boolean zzc(zzaq zzaqVar, zzaq zzaqVar2) {
        if (zzaqVar instanceof zzak) {
            zzaqVar = new zzas(zzaqVar.zzf());
        }
        if (zzaqVar2 instanceof zzak) {
            zzaqVar2 = new zzas(zzaqVar2.zzf());
        }
        return (((zzaqVar instanceof zzas) && (zzaqVar2 instanceof zzas)) || !(Double.isNaN(zzaqVar.zze().doubleValue()) || Double.isNaN(zzaqVar2.zze().doubleValue()))) && !zzb(zzaqVar2, zzaqVar);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x002a. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:11:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x005c  */
    @Override // com.google.android.gms.internal.measurement.zzay
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzaq zza(String str, zzh zzhVar, List<zzaq> list) {
        boolean zza;
        boolean zza2;
        zzg.zza(zzg.zza(str), 2, list);
        zzaq zza3 = zzhVar.zza(list.get(0));
        zzaq zza4 = zzhVar.zza(list.get(1));
        switch (zzbd.zza[zzg.zza(str).ordinal()]) {
            case 1:
                zza = zza(zza3, zza4);
                return !zza ? zzaq.zzh : zzaq.zzi;
            case 2:
                zza = zzb(zza4, zza3);
                if (!zza) {
                }
                break;
            case 3:
                zza = zzc(zza4, zza3);
                if (!zza) {
                }
                break;
            case 4:
                zza = zzg.zza(zza3, zza4);
                if (!zza) {
                }
                break;
            case 5:
                zza2 = zzg.zza(zza3, zza4);
                zza = !zza2;
                if (!zza) {
                }
                break;
            case 6:
                zza = zzb(zza3, zza4);
                if (!zza) {
                }
                break;
            case 7:
                zza = zzc(zza3, zza4);
                if (!zza) {
                }
                break;
            case 8:
                zza2 = zza(zza3, zza4);
                zza = !zza2;
                if (!zza) {
                }
                break;
            default:
                return super.zza(str);
        }
    }

    private static boolean zza(zzaq zzaqVar, zzaq zzaqVar2) {
        zzaq zzaiVar;
        zzaq zzaiVar2;
        while (!zzaqVar.getClass().equals(zzaqVar2.getClass())) {
            if (((zzaqVar instanceof zzax) || (zzaqVar instanceof zzao)) && ((zzaqVar2 instanceof zzax) || (zzaqVar2 instanceof zzao))) {
                return true;
            }
            boolean z5 = zzaqVar instanceof zzai;
            if (z5 && (zzaqVar2 instanceof zzas)) {
                zzaiVar2 = new zzai(zzaqVar2.zze());
            } else {
                boolean z6 = zzaqVar instanceof zzas;
                if (z6 && (zzaqVar2 instanceof zzai)) {
                    zzaiVar = new zzai(zzaqVar.zze());
                } else if (zzaqVar instanceof zzag) {
                    zzaiVar = new zzai(zzaqVar.zze());
                } else if (zzaqVar2 instanceof zzag) {
                    zzaiVar2 = new zzai(zzaqVar2.zze());
                } else if ((z6 || z5) && (zzaqVar2 instanceof zzak)) {
                    zzaiVar2 = new zzas(zzaqVar2.zzf());
                } else {
                    if (!(zzaqVar instanceof zzak) || (!(zzaqVar2 instanceof zzas) && !(zzaqVar2 instanceof zzai))) {
                        return false;
                    }
                    zzaiVar = new zzas(zzaqVar.zzf());
                }
                zzaqVar = zzaiVar;
            }
            zzaqVar2 = zzaiVar2;
        }
        if ((zzaqVar instanceof zzax) || (zzaqVar instanceof zzao)) {
            return true;
        }
        if (zzaqVar instanceof zzai) {
            return (Double.isNaN(zzaqVar.zze().doubleValue()) || Double.isNaN(zzaqVar2.zze().doubleValue()) || zzaqVar.zze().doubleValue() != zzaqVar2.zze().doubleValue()) ? false : true;
        }
        if (zzaqVar instanceof zzas) {
            return zzaqVar.zzf().equals(zzaqVar2.zzf());
        }
        if (zzaqVar instanceof zzag) {
            return zzaqVar.zzd().equals(zzaqVar2.zzd());
        }
        return zzaqVar == zzaqVar2;
    }
}
