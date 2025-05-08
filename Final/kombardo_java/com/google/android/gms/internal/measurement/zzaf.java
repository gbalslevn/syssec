package com.google.android.gms.internal.measurement;

import com.adjust.sdk.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import org.conscrypt.BuildConfig;

/* loaded from: classes.dex */
public final class zzaf implements zzak, zzaq, Iterable<zzaq> {
    private final SortedMap<Integer, zzaq> zza;
    private final Map<String, zzaq> zzb;

    public zzaf() {
        this.zza = new TreeMap();
        this.zzb = new TreeMap();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzaf)) {
            return false;
        }
        zzaf zzafVar = (zzaf) obj;
        if (zzb() != zzafVar.zzb()) {
            return false;
        }
        if (this.zza.isEmpty()) {
            return zzafVar.zza.isEmpty();
        }
        for (int intValue = this.zza.firstKey().intValue(); intValue <= this.zza.lastKey().intValue(); intValue++) {
            if (!zza(intValue).equals(zzafVar.zza(intValue))) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        return this.zza.hashCode() * 31;
    }

    @Override // java.lang.Iterable
    public final Iterator<zzaq> iterator() {
        return new zzah(this);
    }

    public final String toString() {
        return zzb(",");
    }

    public final int zza() {
        return this.zza.size();
    }

    public final int zzb() {
        if (this.zza.isEmpty()) {
            return 0;
        }
        return this.zza.lastKey().intValue() + 1;
    }

    @Override // com.google.android.gms.internal.measurement.zzaq
    public final zzaq zzc() {
        zzaf zzafVar = new zzaf();
        for (Map.Entry<Integer, zzaq> entry : this.zza.entrySet()) {
            if (entry.getValue() instanceof zzak) {
                zzafVar.zza.put(entry.getKey(), entry.getValue());
            } else {
                zzafVar.zza.put(entry.getKey(), entry.getValue().zzc());
            }
        }
        return zzafVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzaq
    public final Boolean zzd() {
        return Boolean.TRUE;
    }

    @Override // com.google.android.gms.internal.measurement.zzaq
    public final Double zze() {
        return this.zza.size() == 1 ? zza(0).zze() : this.zza.size() <= 0 ? Double.valueOf(0.0d) : Double.valueOf(Double.NaN);
    }

    @Override // com.google.android.gms.internal.measurement.zzaq
    public final String zzf() {
        return toString();
    }

    public final Iterator<Integer> zzg() {
        return this.zza.keySet().iterator();
    }

    @Override // com.google.android.gms.internal.measurement.zzaq
    public final Iterator<zzaq> zzh() {
        return new zzae(this, this.zza.keySet().iterator(), this.zzb.keySet().iterator());
    }

    public final List<zzaq> zzi() {
        ArrayList arrayList = new ArrayList(zzb());
        for (int i5 = 0; i5 < zzb(); i5++) {
            arrayList.add(zza(i5));
        }
        return arrayList;
    }

    public final void zzj() {
        this.zza.clear();
    }

    @Override // com.google.android.gms.internal.measurement.zzaq
    public final zzaq zza(String str, zzh zzhVar, List<zzaq> list) {
        if (!"concat".equals(str) && !"every".equals(str) && !"filter".equals(str) && !"forEach".equals(str) && !"indexOf".equals(str) && !"join".equals(str) && !"lastIndexOf".equals(str) && !"map".equals(str) && !"pop".equals(str) && !Constants.PUSH.equals(str) && !"reduce".equals(str) && !"reduceRight".equals(str) && !"reverse".equals(str) && !"shift".equals(str) && !"slice".equals(str) && !"some".equals(str) && !"sort".equals(str) && !"splice".equals(str) && !"toString".equals(str) && !"unshift".equals(str)) {
            return zzan.zza(this, new zzas(str), zzhVar, list);
        }
        return zzbe.zza(str, this, zzhVar, list);
    }

    public final String zzb(String str) {
        if (str == null) {
            str = BuildConfig.FLAVOR;
        }
        StringBuilder sb = new StringBuilder();
        if (!this.zza.isEmpty()) {
            for (int i5 = 0; i5 < zzb(); i5++) {
                zzaq zza = zza(i5);
                sb.append(str);
                if (!(zza instanceof zzax) && !(zza instanceof zzao)) {
                    sb.append(zza.zzf());
                }
            }
            sb.delete(0, str.length());
        }
        return sb.toString();
    }

    public zzaf(List<zzaq> list) {
        this();
        if (list != null) {
            for (int i5 = 0; i5 < list.size(); i5++) {
                zzb(i5, list.get(i5));
            }
        }
    }

    public final boolean zzc(int i5) {
        if (i5 >= 0 && i5 <= this.zza.lastKey().intValue()) {
            return this.zza.containsKey(Integer.valueOf(i5));
        }
        throw new IndexOutOfBoundsException("Out of bounds index: " + i5);
    }

    public zzaf(zzaq... zzaqVarArr) {
        this((List<zzaq>) Arrays.asList(zzaqVarArr));
    }

    @Override // com.google.android.gms.internal.measurement.zzak
    public final boolean zzc(String str) {
        return "length".equals(str) || this.zzb.containsKey(str);
    }

    public final void zzb(int i5) {
        int intValue = this.zza.lastKey().intValue();
        if (i5 > intValue || i5 < 0) {
            return;
        }
        this.zza.remove(Integer.valueOf(i5));
        if (i5 == intValue) {
            int i6 = i5 - 1;
            if (this.zza.containsKey(Integer.valueOf(i6)) || i6 < 0) {
                return;
            }
            this.zza.put(Integer.valueOf(i6), zzaq.zzc);
            return;
        }
        while (true) {
            i5++;
            if (i5 > this.zza.lastKey().intValue()) {
                return;
            }
            zzaq zzaqVar = this.zza.get(Integer.valueOf(i5));
            if (zzaqVar != null) {
                this.zza.put(Integer.valueOf(i5 - 1), zzaqVar);
                this.zza.remove(Integer.valueOf(i5));
            }
        }
    }

    public final void zzb(int i5, zzaq zzaqVar) {
        if (i5 > 32468) {
            throw new IllegalStateException("Array too large");
        }
        if (i5 < 0) {
            throw new IndexOutOfBoundsException("Out of bounds index: " + i5);
        }
        if (zzaqVar == null) {
            this.zza.remove(Integer.valueOf(i5));
        } else {
            this.zza.put(Integer.valueOf(i5), zzaqVar);
        }
    }

    public final zzaq zza(int i5) {
        zzaq zzaqVar;
        if (i5 < zzb()) {
            return (!zzc(i5) || (zzaqVar = this.zza.get(Integer.valueOf(i5))) == null) ? zzaq.zzc : zzaqVar;
        }
        throw new IndexOutOfBoundsException("Attempting to get element outside of current array");
    }

    @Override // com.google.android.gms.internal.measurement.zzak
    public final zzaq zza(String str) {
        zzaq zzaqVar;
        if ("length".equals(str)) {
            return new zzai(Double.valueOf(zzb()));
        }
        return (!zzc(str) || (zzaqVar = this.zzb.get(str)) == null) ? zzaq.zzc : zzaqVar;
    }

    public final void zza(zzaq zzaqVar) {
        zzb(zzb(), zzaqVar);
    }

    public final void zza(int i5, zzaq zzaqVar) {
        if (i5 >= 0) {
            if (i5 >= zzb()) {
                zzb(i5, zzaqVar);
                return;
            }
            for (int intValue = this.zza.lastKey().intValue(); intValue >= i5; intValue--) {
                zzaq zzaqVar2 = this.zza.get(Integer.valueOf(intValue));
                if (zzaqVar2 != null) {
                    zzb(intValue + 1, zzaqVar2);
                    this.zza.remove(Integer.valueOf(intValue));
                }
            }
            zzb(i5, zzaqVar);
            return;
        }
        throw new IllegalArgumentException("Invalid value index: " + i5);
    }

    @Override // com.google.android.gms.internal.measurement.zzak
    public final void zza(String str, zzaq zzaqVar) {
        if (zzaqVar == null) {
            this.zzb.remove(str);
        } else {
            this.zzb.put(str, zzaqVar);
        }
    }
}
