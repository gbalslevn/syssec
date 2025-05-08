package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.List;
import org.conscrypt.BuildConfig;

/* loaded from: classes.dex */
public final class zzbc extends zzay {
    /* JADX INFO: Access modifiers changed from: protected */
    public zzbc() {
        this.zza.add(zzbv.APPLY);
        this.zza.add(zzbv.BLOCK);
        this.zza.add(zzbv.BREAK);
        this.zza.add(zzbv.CASE);
        this.zza.add(zzbv.DEFAULT);
        this.zza.add(zzbv.CONTINUE);
        this.zza.add(zzbv.DEFINE_FUNCTION);
        this.zza.add(zzbv.FN);
        this.zza.add(zzbv.IF);
        this.zza.add(zzbv.QUOTE);
        this.zza.add(zzbv.RETURN);
        this.zza.add(zzbv.SWITCH);
        this.zza.add(zzbv.TERNARY);
    }

    @Override // com.google.android.gms.internal.measurement.zzay
    public final zzaq zza(String str, zzh zzhVar, List<zzaq> list) {
        zzaq zza;
        int i5 = 0;
        switch (zzbf.zza[zzg.zza(str).ordinal()]) {
            case 1:
                zzg.zza(zzbv.APPLY, 3, list);
                zzaq zza2 = zzhVar.zza(list.get(0));
                String zzf = zzhVar.zza(list.get(1)).zzf();
                zzaq zza3 = zzhVar.zza(list.get(2));
                if (zza3 instanceof zzaf) {
                    if (!zzf.isEmpty()) {
                        return zza2.zza(zzf, zzhVar, ((zzaf) zza3).zzi());
                    }
                    throw new IllegalArgumentException("Function name for apply is undefined");
                }
                throw new IllegalArgumentException(String.format("Function arguments for Apply are not a list found %s", zza3.getClass().getCanonicalName()));
            case 2:
                return zzhVar.zza().zza(new zzaf(list));
            case 3:
                zzg.zza(zzbv.BREAK, 0, list);
                return zzaq.zzf;
            case 4:
            case 5:
                if (!list.isEmpty()) {
                    zzaq zza4 = zzhVar.zza(list.get(0));
                    if (zza4 instanceof zzaf) {
                        return zzhVar.zza((zzaf) zza4);
                    }
                }
                return zzaq.zzc;
            case 6:
                zzg.zza(zzbv.BREAK, 0, list);
                return zzaq.zze;
            case 7:
                zzg.zzb(zzbv.DEFINE_FUNCTION, 2, list);
                zzar zzarVar = (zzar) zza(zzhVar, list);
                if (zzarVar.zza() == null) {
                    zzhVar.zzc(BuildConfig.FLAVOR, zzarVar);
                } else {
                    zzhVar.zzc(zzarVar.zza(), zzarVar);
                }
                return zzarVar;
            case 8:
                return zza(zzhVar, list);
            case 9:
                zzg.zzb(zzbv.IF, 2, list);
                zzaq zza5 = zzhVar.zza(list.get(0));
                zzaq zza6 = zzhVar.zza(list.get(1));
                zzaq zza7 = list.size() > 2 ? zzhVar.zza(list.get(2)) : null;
                zzaq zzaqVar = zzaq.zzc;
                if (zza5.zzd().booleanValue()) {
                    zza = zzhVar.zza((zzaf) zza6);
                } else {
                    zza = zza7 != null ? zzhVar.zza((zzaf) zza7) : zzaqVar;
                }
                return zza instanceof zzaj ? zza : zzaqVar;
            case 10:
                return new zzaf(list);
            case 11:
                if (list.isEmpty()) {
                    return zzaq.zzg;
                }
                zzg.zza(zzbv.RETURN, 1, list);
                return new zzaj("return", zzhVar.zza(list.get(0)));
            case 12:
                zzg.zza(zzbv.SWITCH, 3, list);
                zzaq zza8 = zzhVar.zza(list.get(0));
                zzaq zza9 = zzhVar.zza(list.get(1));
                zzaq zza10 = zzhVar.zza(list.get(2));
                if (zza9 instanceof zzaf) {
                    if (zza10 instanceof zzaf) {
                        zzaf zzafVar = (zzaf) zza9;
                        zzaf zzafVar2 = (zzaf) zza10;
                        boolean z5 = false;
                        while (true) {
                            if (i5 < zzafVar.zzb()) {
                                if (z5 || zza8.equals(zzhVar.zza(zzafVar.zza(i5)))) {
                                    zzaq zza11 = zzhVar.zza(zzafVar2.zza(i5));
                                    if (!(zza11 instanceof zzaj)) {
                                        z5 = true;
                                    } else if (!((zzaj) zza11).zzb().equals("break")) {
                                        return zza11;
                                    }
                                }
                                i5++;
                            } else if (zzafVar.zzb() + 1 == zzafVar2.zzb()) {
                                zzaq zza12 = zzhVar.zza(zzafVar2.zza(zzafVar.zzb()));
                                if (zza12 instanceof zzaj) {
                                    String zzb = ((zzaj) zza12).zzb();
                                    if (zzb.equals("return") || zzb.equals("continue")) {
                                        return zza12;
                                    }
                                }
                            }
                        }
                        return zzaq.zzc;
                    }
                    throw new IllegalArgumentException("Malformed SWITCH statement, case statements are not a list");
                }
                throw new IllegalArgumentException("Malformed SWITCH statement, cases are not a list");
            case 13:
                zzg.zza(zzbv.TERNARY, 3, list);
                if (zzhVar.zza(list.get(0)).zzd().booleanValue()) {
                    return zzhVar.zza(list.get(1));
                }
                return zzhVar.zza(list.get(2));
            default:
                return super.zza(str);
        }
    }

    private static zzaq zza(zzh zzhVar, List<zzaq> list) {
        zzg.zzb(zzbv.FN, 2, list);
        zzaq zza = zzhVar.zza(list.get(0));
        zzaq zza2 = zzhVar.zza(list.get(1));
        if (zza2 instanceof zzaf) {
            List<zzaq> zzi = ((zzaf) zza2).zzi();
            List<zzaq> arrayList = new ArrayList<>();
            if (list.size() > 2) {
                arrayList = list.subList(2, list.size());
            }
            return new zzar(zza.zzf(), zzi, arrayList, zzhVar);
        }
        throw new IllegalArgumentException(String.format("FN requires an ArrayValue of parameter names found %s", zza2.getClass().getCanonicalName()));
    }
}
