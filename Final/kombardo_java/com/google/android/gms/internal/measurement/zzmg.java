package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class zzmg {
    private static final zzmu<?, ?> zza = new zzmw();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(int i5, List<?> list, boolean z5) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzjn.zza(i5, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(int i5, List<Integer> list, boolean z5) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzb(list) + (size * zzjn.zzf(i5));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(int i5, List<?> list, boolean z5) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzjn.zzb(i5, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzd(int i5, List<?> list, boolean z5) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzjn.zza(i5, 0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zze(int i5, List<Integer> list, boolean z5) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zze(list) + (size * zzjn.zzf(i5));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzf(int i5, List<Long> list, boolean z5) {
        if (list.size() == 0) {
            return 0;
        }
        return zzf(list) + (list.size() * zzjn.zzf(i5));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzg(int i5, List<Integer> list, boolean z5) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzg(list) + (size * zzjn.zzf(i5));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzh(int i5, List<Long> list, boolean z5) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzh(list) + (size * zzjn.zzf(i5));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzi(int i5, List<Integer> list, boolean z5) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzi(list) + (size * zzjn.zzf(i5));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzj(int i5, List<Long> list, boolean z5) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzj(list) + (size * zzjn.zzf(i5));
    }

    public static void zzk(int i5, List<Integer> list, zznl zznlVar, boolean z5) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zznlVar.zzk(i5, list, z5);
    }

    public static void zzl(int i5, List<Long> list, zznl zznlVar, boolean z5) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zznlVar.zzl(i5, list, z5);
    }

    public static void zzm(int i5, List<Integer> list, zznl zznlVar, boolean z5) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zznlVar.zzm(i5, list, z5);
    }

    public static void zzn(int i5, List<Long> list, zznl zznlVar, boolean z5) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zznlVar.zzn(i5, list, z5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(List<?> list) {
        return list.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(List<?> list) {
        return list.size() << 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzd(List<?> list) {
        return list.size() << 3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(int i5, List<zziy> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzf = size * zzjn.zzf(i5);
        for (int i6 = 0; i6 < list.size(); i6++) {
            zzf += zzjn.zza(list.get(i6));
        }
        return zzf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(List<Integer> list) {
        int i5;
        int size = list.size();
        int i6 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzkh) {
            zzkh zzkhVar = (zzkh) list;
            i5 = 0;
            while (i6 < size) {
                i5 += zzjn.zza(zzkhVar.zzb(i6));
                i6++;
            }
        } else {
            i5 = 0;
            while (i6 < size) {
                i5 += zzjn.zza(list.get(i6).intValue());
                i6++;
            }
        }
        return i5;
    }

    public static void zzc(int i5, List<Integer> list, zznl zznlVar, boolean z5) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zznlVar.zzc(i5, list, z5);
    }

    public static void zzd(int i5, List<Integer> list, zznl zznlVar, boolean z5) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zznlVar.zzd(i5, list, z5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zze(List<Integer> list) {
        int i5;
        int size = list.size();
        int i6 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzkh) {
            zzkh zzkhVar = (zzkh) list;
            i5 = 0;
            while (i6 < size) {
                i5 += zzjn.zzc(zzkhVar.zzb(i6));
                i6++;
            }
        } else {
            i5 = 0;
            while (i6 < size) {
                i5 += zzjn.zzc(list.get(i6).intValue());
                i6++;
            }
        }
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzf(List<Long> list) {
        int i5;
        int size = list.size();
        int i6 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzlb) {
            zzlb zzlbVar = (zzlb) list;
            i5 = 0;
            while (i6 < size) {
                i5 += zzjn.zzb(zzlbVar.zzb(i6));
                i6++;
            }
        } else {
            i5 = 0;
            while (i6 < size) {
                i5 += zzjn.zzb(list.get(i6).longValue());
                i6++;
            }
        }
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzg(List<Integer> list) {
        int i5;
        int size = list.size();
        int i6 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzkh) {
            zzkh zzkhVar = (zzkh) list;
            i5 = 0;
            while (i6 < size) {
                i5 += zzjn.zze(zzkhVar.zzb(i6));
                i6++;
            }
        } else {
            i5 = 0;
            while (i6 < size) {
                i5 += zzjn.zze(list.get(i6).intValue());
                i6++;
            }
        }
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzh(List<Long> list) {
        int i5;
        int size = list.size();
        int i6 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzlb) {
            zzlb zzlbVar = (zzlb) list;
            i5 = 0;
            while (i6 < size) {
                i5 += zzjn.zzd(zzlbVar.zzb(i6));
                i6++;
            }
        } else {
            i5 = 0;
            while (i6 < size) {
                i5 += zzjn.zzd(list.get(i6).longValue());
                i6++;
            }
        }
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzi(List<Integer> list) {
        int i5;
        int size = list.size();
        int i6 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzkh) {
            zzkh zzkhVar = (zzkh) list;
            i5 = 0;
            while (i6 < size) {
                i5 += zzjn.zzg(zzkhVar.zzb(i6));
                i6++;
            }
        } else {
            i5 = 0;
            while (i6 < size) {
                i5 += zzjn.zzg(list.get(i6).intValue());
                i6++;
            }
        }
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzj(List<Long> list) {
        int i5;
        int size = list.size();
        int i6 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzlb) {
            zzlb zzlbVar = (zzlb) list;
            i5 = 0;
            while (i6 < size) {
                i5 += zzjn.zze(zzlbVar.zzb(i6));
                i6++;
            }
        } else {
            i5 = 0;
            while (i6 < size) {
                i5 += zzjn.zze(list.get(i6).longValue());
                i6++;
            }
        }
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(int i5, List<zzlm> list, zzme<?> zzmeVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i6 = 0;
        for (int i7 = 0; i7 < size; i7++) {
            i6 += zzjn.zza(i5, list.get(i7), zzmeVar);
        }
        return i6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(int i5, List<?> list, zzme<?> zzmeVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzf = zzjn.zzf(i5) * size;
        for (int i6 = 0; i6 < size; i6++) {
            zzf += zzjn.zza((zzlm) list.get(i6), zzmeVar);
        }
        return zzf;
    }

    public static void zze(int i5, List<Long> list, zznl zznlVar, boolean z5) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zznlVar.zze(i5, list, z5);
    }

    public static void zzf(int i5, List<Float> list, zznl zznlVar, boolean z5) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zznlVar.zzf(i5, list, z5);
    }

    public static void zzg(int i5, List<Integer> list, zznl zznlVar, boolean z5) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zznlVar.zzg(i5, list, z5);
    }

    public static void zzh(int i5, List<Long> list, zznl zznlVar, boolean z5) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zznlVar.zzh(i5, list, z5);
    }

    public static void zzi(int i5, List<Integer> list, zznl zznlVar, boolean z5) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zznlVar.zzi(i5, list, z5);
    }

    public static void zzj(int i5, List<Long> list, zznl zznlVar, boolean z5) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zznlVar.zzj(i5, list, z5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(int i5, Object obj, zzme<?> zzmeVar) {
        return zzjn.zzb(i5, (zzlm) obj, zzmeVar);
    }

    public static zzmu<?, ?> zza() {
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <UT, UB> UB zza(Object obj, int i5, List<Integer> list, zzkl zzklVar, UB ub, zzmu<UT, UB> zzmuVar) {
        if (zzklVar == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i6 = 0;
            for (int i7 = 0; i7 < size; i7++) {
                Integer num = list.get(i7);
                int intValue = num.intValue();
                if (zzklVar.zza(intValue)) {
                    if (i7 != i6) {
                        list.set(i6, num);
                    }
                    i6++;
                } else {
                    ub = (UB) zza(obj, i5, intValue, ub, zzmuVar);
                }
            }
            if (i6 != size) {
                list.subList(i6, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (!zzklVar.zza(intValue2)) {
                    ub = (UB) zza(obj, i5, intValue2, ub, zzmuVar);
                    it.remove();
                }
            }
        }
        return ub;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(int i5, List<?> list) {
        int zza2;
        int zza3;
        int size = list.size();
        int i6 = 0;
        if (size == 0) {
            return 0;
        }
        int zzf = zzjn.zzf(i5) * size;
        if (list instanceof zzkx) {
            zzkx zzkxVar = (zzkx) list;
            while (i6 < size) {
                Object zza4 = zzkxVar.zza(i6);
                if (zza4 instanceof zziy) {
                    zza3 = zzjn.zza((zziy) zza4);
                } else {
                    zza3 = zzjn.zza((String) zza4);
                }
                zzf += zza3;
                i6++;
            }
        } else {
            while (i6 < size) {
                Object obj = list.get(i6);
                if (obj instanceof zziy) {
                    zza2 = zzjn.zza((zziy) obj);
                } else {
                    zza2 = zzjn.zza((String) obj);
                }
                zzf += zza2;
                i6++;
            }
        }
        return zzf;
    }

    static <UT, UB> UB zza(Object obj, int i5, int i6, UB ub, zzmu<UT, UB> zzmuVar) {
        if (ub == null) {
            ub = zzmuVar.zzc(obj);
        }
        zzmuVar.zzb(ub, i5, i6);
        return ub;
    }

    public static void zzb(int i5, List<Double> list, zznl zznlVar, boolean z5) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zznlVar.zzb(i5, list, z5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, FT extends zzjy<FT>> void zza(zzjv<FT> zzjvVar, T t5, T t6) {
        zzjw<FT> zza2 = zzjvVar.zza(t6);
        if (zza2.zza.isEmpty()) {
            return;
        }
        zzjvVar.zzb(t5).zza(zza2);
    }

    public static void zzb(int i5, List<?> list, zznl zznlVar, zzme<?> zzmeVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zznlVar.zzb(i5, list, (zzme) zzmeVar);
    }

    public static void zzb(int i5, List<String> list, zznl zznlVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zznlVar.zzb(i5, list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> void zza(zzlj zzljVar, T t5, T t6, long j5) {
        zzmz.zza(t5, j5, zzljVar.zza(zzmz.zze(t5, j5), zzmz.zze(t6, j5)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, UT, UB> void zza(zzmu<UT, UB> zzmuVar, T t5, T t6) {
        zzmuVar.zzc(t5, zzmuVar.zza(zzmuVar.zzd(t5), zzmuVar.zzd(t6)));
    }

    public static void zza(Class<?> cls) {
        zzkg.class.isAssignableFrom(cls);
    }

    public static void zza(int i5, List<Boolean> list, zznl zznlVar, boolean z5) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zznlVar.zza(i5, list, z5);
    }

    public static void zza(int i5, List<zziy> list, zznl zznlVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zznlVar.zza(i5, list);
    }

    public static void zza(int i5, List<?> list, zznl zznlVar, zzme<?> zzmeVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zznlVar.zza(i5, list, (zzme) zzmeVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zza(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }
}
