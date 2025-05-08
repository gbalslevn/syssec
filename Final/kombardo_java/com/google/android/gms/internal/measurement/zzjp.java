package com.google.android.gms.internal.measurement;

import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
final class zzjp implements zznl {
    private final zzjn zza;

    private zzjp(zzjn zzjnVar) {
        zzjn zzjnVar2 = (zzjn) zzkj.zza(zzjnVar, "output");
        this.zza = zzjnVar2;
        zzjnVar2.zza = this;
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final int zza() {
        return 1;
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final void zzb(int i5, List<Double> list, boolean z5) {
        int i6 = 0;
        if (!(list instanceof zzjs)) {
            if (z5) {
                this.zza.zzj(i5, 2);
                int i7 = 0;
                for (int i8 = 0; i8 < list.size(); i8++) {
                    i7 += zzjn.zza(list.get(i8).doubleValue());
                }
                this.zza.zzk(i7);
                while (i6 < list.size()) {
                    this.zza.zzb(list.get(i6).doubleValue());
                    i6++;
                }
                return;
            }
            while (i6 < list.size()) {
                this.zza.zzb(i5, list.get(i6).doubleValue());
                i6++;
            }
            return;
        }
        zzjs zzjsVar = (zzjs) list;
        if (z5) {
            this.zza.zzj(i5, 2);
            int i9 = 0;
            for (int i10 = 0; i10 < zzjsVar.size(); i10++) {
                i9 += zzjn.zza(zzjsVar.zzb(i10));
            }
            this.zza.zzk(i9);
            while (i6 < zzjsVar.size()) {
                this.zza.zzb(zzjsVar.zzb(i6));
                i6++;
            }
            return;
        }
        while (i6 < zzjsVar.size()) {
            this.zza.zzb(i5, zzjsVar.zzb(i6));
            i6++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final void zzc(int i5, List<Integer> list, boolean z5) {
        int i6 = 0;
        if (!(list instanceof zzkh)) {
            if (z5) {
                this.zza.zzj(i5, 2);
                int i7 = 0;
                for (int i8 = 0; i8 < list.size(); i8++) {
                    i7 += zzjn.zza(list.get(i8).intValue());
                }
                this.zza.zzk(i7);
                while (i6 < list.size()) {
                    this.zza.zzi(list.get(i6).intValue());
                    i6++;
                }
                return;
            }
            while (i6 < list.size()) {
                this.zza.zzh(i5, list.get(i6).intValue());
                i6++;
            }
            return;
        }
        zzkh zzkhVar = (zzkh) list;
        if (z5) {
            this.zza.zzj(i5, 2);
            int i9 = 0;
            for (int i10 = 0; i10 < zzkhVar.size(); i10++) {
                i9 += zzjn.zza(zzkhVar.zzb(i10));
            }
            this.zza.zzk(i9);
            while (i6 < zzkhVar.size()) {
                this.zza.zzi(zzkhVar.zzb(i6));
                i6++;
            }
            return;
        }
        while (i6 < zzkhVar.size()) {
            this.zza.zzh(i5, zzkhVar.zzb(i6));
            i6++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final void zzd(int i5, List<Integer> list, boolean z5) {
        int i6 = 0;
        if (!(list instanceof zzkh)) {
            if (z5) {
                this.zza.zzj(i5, 2);
                int i7 = 0;
                for (int i8 = 0; i8 < list.size(); i8++) {
                    i7 += zzjn.zzb(list.get(i8).intValue());
                }
                this.zza.zzk(i7);
                while (i6 < list.size()) {
                    this.zza.zzh(list.get(i6).intValue());
                    i6++;
                }
                return;
            }
            while (i6 < list.size()) {
                this.zza.zzg(i5, list.get(i6).intValue());
                i6++;
            }
            return;
        }
        zzkh zzkhVar = (zzkh) list;
        if (z5) {
            this.zza.zzj(i5, 2);
            int i9 = 0;
            for (int i10 = 0; i10 < zzkhVar.size(); i10++) {
                i9 += zzjn.zzb(zzkhVar.zzb(i10));
            }
            this.zza.zzk(i9);
            while (i6 < zzkhVar.size()) {
                this.zza.zzh(zzkhVar.zzb(i6));
                i6++;
            }
            return;
        }
        while (i6 < zzkhVar.size()) {
            this.zza.zzg(i5, zzkhVar.zzb(i6));
            i6++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final void zze(int i5, List<Long> list, boolean z5) {
        int i6 = 0;
        if (!(list instanceof zzlb)) {
            if (z5) {
                this.zza.zzj(i5, 2);
                int i7 = 0;
                for (int i8 = 0; i8 < list.size(); i8++) {
                    i7 += zzjn.zza(list.get(i8).longValue());
                }
                this.zza.zzk(i7);
                while (i6 < list.size()) {
                    this.zza.zzf(list.get(i6).longValue());
                    i6++;
                }
                return;
            }
            while (i6 < list.size()) {
                this.zza.zzf(i5, list.get(i6).longValue());
                i6++;
            }
            return;
        }
        zzlb zzlbVar = (zzlb) list;
        if (z5) {
            this.zza.zzj(i5, 2);
            int i9 = 0;
            for (int i10 = 0; i10 < zzlbVar.size(); i10++) {
                i9 += zzjn.zza(zzlbVar.zzb(i10));
            }
            this.zza.zzk(i9);
            while (i6 < zzlbVar.size()) {
                this.zza.zzf(zzlbVar.zzb(i6));
                i6++;
            }
            return;
        }
        while (i6 < zzlbVar.size()) {
            this.zza.zzf(i5, zzlbVar.zzb(i6));
            i6++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final void zzf(int i5, List<Float> list, boolean z5) {
        int i6 = 0;
        if (!(list instanceof zzkc)) {
            if (z5) {
                this.zza.zzj(i5, 2);
                int i7 = 0;
                for (int i8 = 0; i8 < list.size(); i8++) {
                    i7 += zzjn.zza(list.get(i8).floatValue());
                }
                this.zza.zzk(i7);
                while (i6 < list.size()) {
                    this.zza.zzb(list.get(i6).floatValue());
                    i6++;
                }
                return;
            }
            while (i6 < list.size()) {
                this.zza.zzb(i5, list.get(i6).floatValue());
                i6++;
            }
            return;
        }
        zzkc zzkcVar = (zzkc) list;
        if (z5) {
            this.zza.zzj(i5, 2);
            int i9 = 0;
            for (int i10 = 0; i10 < zzkcVar.size(); i10++) {
                i9 += zzjn.zza(zzkcVar.zzb(i10));
            }
            this.zza.zzk(i9);
            while (i6 < zzkcVar.size()) {
                this.zza.zzb(zzkcVar.zzb(i6));
                i6++;
            }
            return;
        }
        while (i6 < zzkcVar.size()) {
            this.zza.zzb(i5, zzkcVar.zzb(i6));
            i6++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final void zzg(int i5, List<Integer> list, boolean z5) {
        int i6 = 0;
        if (!(list instanceof zzkh)) {
            if (!z5) {
                while (i6 < list.size()) {
                    this.zza.zzh(i5, list.get(i6).intValue());
                    i6++;
                }
                return;
            }
            this.zza.zzj(i5, 2);
            int i7 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                i7 += zzjn.zzc(list.get(i8).intValue());
            }
            this.zza.zzk(i7);
            while (i6 < list.size()) {
                this.zza.zzi(list.get(i6).intValue());
                i6++;
            }
            return;
        }
        zzkh zzkhVar = (zzkh) list;
        if (!z5) {
            while (i6 < zzkhVar.size()) {
                this.zza.zzh(i5, zzkhVar.zzb(i6));
                i6++;
            }
            return;
        }
        this.zza.zzj(i5, 2);
        int i9 = 0;
        for (int i10 = 0; i10 < zzkhVar.size(); i10++) {
            i9 += zzjn.zzc(zzkhVar.zzb(i10));
        }
        this.zza.zzk(i9);
        while (i6 < zzkhVar.size()) {
            this.zza.zzi(zzkhVar.zzb(i6));
            i6++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final void zzh(int i5, List<Long> list, boolean z5) {
        int i6 = 0;
        if (!(list instanceof zzlb)) {
            if (!z5) {
                while (i6 < list.size()) {
                    this.zza.zzh(i5, list.get(i6).longValue());
                    i6++;
                }
                return;
            }
            this.zza.zzj(i5, 2);
            int i7 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                i7 += zzjn.zzb(list.get(i8).longValue());
            }
            this.zza.zzk(i7);
            while (i6 < list.size()) {
                this.zza.zzh(list.get(i6).longValue());
                i6++;
            }
            return;
        }
        zzlb zzlbVar = (zzlb) list;
        if (!z5) {
            while (i6 < zzlbVar.size()) {
                this.zza.zzh(i5, zzlbVar.zzb(i6));
                i6++;
            }
            return;
        }
        this.zza.zzj(i5, 2);
        int i9 = 0;
        for (int i10 = 0; i10 < zzlbVar.size(); i10++) {
            i9 += zzjn.zzb(zzlbVar.zzb(i10));
        }
        this.zza.zzk(i9);
        while (i6 < zzlbVar.size()) {
            this.zza.zzh(zzlbVar.zzb(i6));
            i6++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final void zzi(int i5, List<Integer> list, boolean z5) {
        int i6 = 0;
        if (!(list instanceof zzkh)) {
            if (!z5) {
                while (i6 < list.size()) {
                    this.zza.zzg(i5, list.get(i6).intValue());
                    i6++;
                }
                return;
            }
            this.zza.zzj(i5, 2);
            int i7 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                i7 += zzjn.zzd(list.get(i8).intValue());
            }
            this.zza.zzk(i7);
            while (i6 < list.size()) {
                this.zza.zzh(list.get(i6).intValue());
                i6++;
            }
            return;
        }
        zzkh zzkhVar = (zzkh) list;
        if (!z5) {
            while (i6 < zzkhVar.size()) {
                this.zza.zzg(i5, zzkhVar.zzb(i6));
                i6++;
            }
            return;
        }
        this.zza.zzj(i5, 2);
        int i9 = 0;
        for (int i10 = 0; i10 < zzkhVar.size(); i10++) {
            i9 += zzjn.zzd(zzkhVar.zzb(i10));
        }
        this.zza.zzk(i9);
        while (i6 < zzkhVar.size()) {
            this.zza.zzh(zzkhVar.zzb(i6));
            i6++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final void zzj(int i5, List<Long> list, boolean z5) {
        int i6 = 0;
        if (!(list instanceof zzlb)) {
            if (!z5) {
                while (i6 < list.size()) {
                    this.zza.zzf(i5, list.get(i6).longValue());
                    i6++;
                }
                return;
            }
            this.zza.zzj(i5, 2);
            int i7 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                i7 += zzjn.zzc(list.get(i8).longValue());
            }
            this.zza.zzk(i7);
            while (i6 < list.size()) {
                this.zza.zzf(list.get(i6).longValue());
                i6++;
            }
            return;
        }
        zzlb zzlbVar = (zzlb) list;
        if (!z5) {
            while (i6 < zzlbVar.size()) {
                this.zza.zzf(i5, zzlbVar.zzb(i6));
                i6++;
            }
            return;
        }
        this.zza.zzj(i5, 2);
        int i9 = 0;
        for (int i10 = 0; i10 < zzlbVar.size(); i10++) {
            i9 += zzjn.zzc(zzlbVar.zzb(i10));
        }
        this.zza.zzk(i9);
        while (i6 < zzlbVar.size()) {
            this.zza.zzf(zzlbVar.zzb(i6));
            i6++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final void zzk(int i5, List<Integer> list, boolean z5) {
        int i6 = 0;
        if (!(list instanceof zzkh)) {
            if (!z5) {
                while (i6 < list.size()) {
                    this.zza.zzi(i5, list.get(i6).intValue());
                    i6++;
                }
                return;
            }
            this.zza.zzj(i5, 2);
            int i7 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                i7 += zzjn.zze(list.get(i8).intValue());
            }
            this.zza.zzk(i7);
            while (i6 < list.size()) {
                this.zza.zzj(list.get(i6).intValue());
                i6++;
            }
            return;
        }
        zzkh zzkhVar = (zzkh) list;
        if (!z5) {
            while (i6 < zzkhVar.size()) {
                this.zza.zzi(i5, zzkhVar.zzb(i6));
                i6++;
            }
            return;
        }
        this.zza.zzj(i5, 2);
        int i9 = 0;
        for (int i10 = 0; i10 < zzkhVar.size(); i10++) {
            i9 += zzjn.zze(zzkhVar.zzb(i10));
        }
        this.zza.zzk(i9);
        while (i6 < zzkhVar.size()) {
            this.zza.zzj(zzkhVar.zzb(i6));
            i6++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final void zzl(int i5, List<Long> list, boolean z5) {
        int i6 = 0;
        if (!(list instanceof zzlb)) {
            if (!z5) {
                while (i6 < list.size()) {
                    this.zza.zzg(i5, list.get(i6).longValue());
                    i6++;
                }
                return;
            }
            this.zza.zzj(i5, 2);
            int i7 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                i7 += zzjn.zzd(list.get(i8).longValue());
            }
            this.zza.zzk(i7);
            while (i6 < list.size()) {
                this.zza.zzg(list.get(i6).longValue());
                i6++;
            }
            return;
        }
        zzlb zzlbVar = (zzlb) list;
        if (!z5) {
            while (i6 < zzlbVar.size()) {
                this.zza.zzg(i5, zzlbVar.zzb(i6));
                i6++;
            }
            return;
        }
        this.zza.zzj(i5, 2);
        int i9 = 0;
        for (int i10 = 0; i10 < zzlbVar.size(); i10++) {
            i9 += zzjn.zzd(zzlbVar.zzb(i10));
        }
        this.zza.zzk(i9);
        while (i6 < zzlbVar.size()) {
            this.zza.zzg(zzlbVar.zzb(i6));
            i6++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final void zzm(int i5, List<Integer> list, boolean z5) {
        int i6 = 0;
        if (!(list instanceof zzkh)) {
            if (!z5) {
                while (i6 < list.size()) {
                    this.zza.zzk(i5, list.get(i6).intValue());
                    i6++;
                }
                return;
            }
            this.zza.zzj(i5, 2);
            int i7 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                i7 += zzjn.zzg(list.get(i8).intValue());
            }
            this.zza.zzk(i7);
            while (i6 < list.size()) {
                this.zza.zzk(list.get(i6).intValue());
                i6++;
            }
            return;
        }
        zzkh zzkhVar = (zzkh) list;
        if (!z5) {
            while (i6 < zzkhVar.size()) {
                this.zza.zzk(i5, zzkhVar.zzb(i6));
                i6++;
            }
            return;
        }
        this.zza.zzj(i5, 2);
        int i9 = 0;
        for (int i10 = 0; i10 < zzkhVar.size(); i10++) {
            i9 += zzjn.zzg(zzkhVar.zzb(i10));
        }
        this.zza.zzk(i9);
        while (i6 < zzkhVar.size()) {
            this.zza.zzk(zzkhVar.zzb(i6));
            i6++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final void zzn(int i5, List<Long> list, boolean z5) {
        int i6 = 0;
        if (!(list instanceof zzlb)) {
            if (!z5) {
                while (i6 < list.size()) {
                    this.zza.zzh(i5, list.get(i6).longValue());
                    i6++;
                }
                return;
            }
            this.zza.zzj(i5, 2);
            int i7 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                i7 += zzjn.zze(list.get(i8).longValue());
            }
            this.zza.zzk(i7);
            while (i6 < list.size()) {
                this.zza.zzh(list.get(i6).longValue());
                i6++;
            }
            return;
        }
        zzlb zzlbVar = (zzlb) list;
        if (!z5) {
            while (i6 < zzlbVar.size()) {
                this.zza.zzh(i5, zzlbVar.zzb(i6));
                i6++;
            }
            return;
        }
        this.zza.zzj(i5, 2);
        int i9 = 0;
        for (int i10 = 0; i10 < zzlbVar.size(); i10++) {
            i9 += zzjn.zze(zzlbVar.zzb(i10));
        }
        this.zza.zzk(i9);
        while (i6 < zzlbVar.size()) {
            this.zza.zzh(zzlbVar.zzb(i6));
            i6++;
        }
    }

    public static zzjp zza(zzjn zzjnVar) {
        zzjp zzjpVar = zzjnVar.zza;
        return zzjpVar != null ? zzjpVar : new zzjp(zzjnVar);
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final void zza(int i5, boolean z5) {
        this.zza.zzb(i5, z5);
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final void zza(int i5, List<Boolean> list, boolean z5) {
        int i6 = 0;
        if (!(list instanceof zziw)) {
            if (z5) {
                this.zza.zzj(i5, 2);
                int i7 = 0;
                for (int i8 = 0; i8 < list.size(); i8++) {
                    i7 += zzjn.zza(list.get(i8).booleanValue());
                }
                this.zza.zzk(i7);
                while (i6 < list.size()) {
                    this.zza.zzb(list.get(i6).booleanValue());
                    i6++;
                }
                return;
            }
            while (i6 < list.size()) {
                this.zza.zzb(i5, list.get(i6).booleanValue());
                i6++;
            }
            return;
        }
        zziw zziwVar = (zziw) list;
        if (z5) {
            this.zza.zzj(i5, 2);
            int i9 = 0;
            for (int i10 = 0; i10 < zziwVar.size(); i10++) {
                i9 += zzjn.zza(zziwVar.zzb(i10));
            }
            this.zza.zzk(i9);
            while (i6 < zziwVar.size()) {
                this.zza.zzb(zziwVar.zzb(i6));
                i6++;
            }
            return;
        }
        while (i6 < zziwVar.size()) {
            this.zza.zzb(i5, zziwVar.zzb(i6));
            i6++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final void zzb(int i5, int i6) {
        this.zza.zzg(i5, i6);
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final void zzd(int i5, int i6) {
        this.zza.zzg(i5, i6);
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final void zze(int i5, int i6) {
        this.zza.zzi(i5, i6);
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final void zzf(int i5, int i6) {
        this.zza.zzk(i5, i6);
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final void zzb(int i5, long j5) {
        this.zza.zzh(i5, j5);
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final void zze(int i5, long j5) {
        this.zza.zzh(i5, j5);
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final void zzd(int i5, long j5) {
        this.zza.zzg(i5, j5);
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final void zzb(int i5, Object obj, zzme zzmeVar) {
        this.zza.zzc(i5, (zzlm) obj, zzmeVar);
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final void zza(int i5, zziy zziyVar) {
        this.zza.zzc(i5, zziyVar);
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final void zzb(int i5, List<?> list, zzme zzmeVar) {
        for (int i6 = 0; i6 < list.size(); i6++) {
            zzb(i5, list.get(i6), zzmeVar);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final void zzc(int i5, int i6) {
        this.zza.zzh(i5, i6);
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final void zza(int i5, List<zziy> list) {
        for (int i6 = 0; i6 < list.size(); i6++) {
            this.zza.zzc(i5, list.get(i6));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final void zzc(int i5, long j5) {
        this.zza.zzf(i5, j5);
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    @Deprecated
    public final void zzb(int i5) {
        this.zza.zzj(i5, 3);
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final void zza(int i5, double d5) {
        this.zza.zzb(i5, d5);
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final void zzb(int i5, List<String> list) {
        int i6 = 0;
        if (list instanceof zzkx) {
            zzkx zzkxVar = (zzkx) list;
            while (i6 < list.size()) {
                Object zza = zzkxVar.zza(i6);
                if (zza instanceof String) {
                    this.zza.zzb(i5, (String) zza);
                } else {
                    this.zza.zzc(i5, (zziy) zza);
                }
                i6++;
            }
            return;
        }
        while (i6 < list.size()) {
            this.zza.zzb(i5, list.get(i6));
            i6++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    @Deprecated
    public final void zza(int i5) {
        this.zza.zzj(i5, 4);
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final void zza(int i5, int i6) {
        this.zza.zzh(i5, i6);
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final void zza(int i5, long j5) {
        this.zza.zzf(i5, j5);
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final void zza(int i5, float f5) {
        this.zza.zzb(i5, f5);
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final void zza(int i5, Object obj, zzme zzmeVar) {
        zzjn zzjnVar = this.zza;
        zzjnVar.zzj(i5, 3);
        zzmeVar.zza((zzme) obj, (zznl) zzjnVar.zza);
        zzjnVar.zzj(i5, 4);
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final void zza(int i5, List<?> list, zzme zzmeVar) {
        for (int i6 = 0; i6 < list.size(); i6++) {
            zza(i5, list.get(i6), zzmeVar);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final <K, V> void zza(int i5, zzlh<K, V> zzlhVar, Map<K, V> map) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            this.zza.zzj(i5, 2);
            this.zza.zzk(zzle.zza(zzlhVar, entry.getKey(), entry.getValue()));
            zzle.zza(this.zza, zzlhVar, entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final void zza(int i5, Object obj) {
        if (obj instanceof zziy) {
            this.zza.zzd(i5, (zziy) obj);
        } else {
            this.zza.zzb(i5, (zzlm) obj);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final void zza(int i5, String str) {
        this.zza.zzb(i5, str);
    }
}
