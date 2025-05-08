package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes.dex */
final class zzjs extends zzis<Double> implements zzkm<Double>, zzly, RandomAccess {
    private static final double[] zza;
    private double[] zzb;
    private int zzc;

    static {
        double[] dArr = new double[0];
        zza = dArr;
        new zzjs(dArr, 0, false);
    }

    private zzjs(double[] dArr, int i5, boolean z5) {
        super(z5);
        this.zzb = dArr;
        this.zzc = i5;
    }

    private static int zzd(int i5) {
        return Math.max(((i5 * 3) / 2) + 1, 10);
    }

    private final String zze(int i5) {
        return "Index:" + i5 + ", Size:" + this.zzc;
    }

    private final void zzf(int i5) {
        if (i5 < 0 || i5 >= this.zzc) {
            throw new IndexOutOfBoundsException(zze(i5));
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i5, Object obj) {
        int i6;
        double doubleValue = ((Double) obj).doubleValue();
        zza();
        if (i5 >= 0 && i5 <= (i6 = this.zzc)) {
            double[] dArr = this.zzb;
            if (i6 < dArr.length) {
                System.arraycopy(dArr, i5, dArr, i5 + 1, i6 - i5);
            } else {
                double[] dArr2 = new double[zzd(dArr.length)];
                System.arraycopy(this.zzb, 0, dArr2, 0, i5);
                System.arraycopy(this.zzb, i5, dArr2, i5 + 1, this.zzc - i5);
                this.zzb = dArr2;
            }
            this.zzb[i5] = doubleValue;
            this.zzc++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(zze(i5));
    }

    @Override // com.google.android.gms.internal.measurement.zzis, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Double> collection) {
        zza();
        zzkj.zza(collection);
        if (!(collection instanceof zzjs)) {
            return super.addAll(collection);
        }
        zzjs zzjsVar = (zzjs) collection;
        int i5 = zzjsVar.zzc;
        if (i5 == 0) {
            return false;
        }
        int i6 = this.zzc;
        if (Integer.MAX_VALUE - i6 < i5) {
            throw new OutOfMemoryError();
        }
        int i7 = i6 + i5;
        double[] dArr = this.zzb;
        if (i7 > dArr.length) {
            this.zzb = Arrays.copyOf(dArr, i7);
        }
        System.arraycopy(zzjsVar.zzb, 0, this.zzb, this.zzc, zzjsVar.zzc);
        this.zzc = i7;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // com.google.android.gms.internal.measurement.zzis, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzjs)) {
            return super.equals(obj);
        }
        zzjs zzjsVar = (zzjs) obj;
        if (this.zzc != zzjsVar.zzc) {
            return false;
        }
        double[] dArr = zzjsVar.zzb;
        for (int i5 = 0; i5 < this.zzc; i5++) {
            if (Double.doubleToLongBits(this.zzb[i5]) != Double.doubleToLongBits(dArr[i5])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i5) {
        return Double.valueOf(zzb(i5));
    }

    @Override // com.google.android.gms.internal.measurement.zzis, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i5 = 1;
        for (int i6 = 0; i6 < this.zzc; i6++) {
            i5 = (i5 * 31) + zzkj.zza(Double.doubleToLongBits(this.zzb[i6]));
        }
        return i5;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Double)) {
            return -1;
        }
        double doubleValue = ((Double) obj).doubleValue();
        int size = size();
        for (int i5 = 0; i5 < size; i5++) {
            if (this.zzb[i5] == doubleValue) {
                return i5;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.measurement.zzis, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i5) {
        zza();
        zzf(i5);
        double[] dArr = this.zzb;
        double d5 = dArr[i5];
        if (i5 < this.zzc - 1) {
            System.arraycopy(dArr, i5 + 1, dArr, i5, (r3 - i5) - 1);
        }
        this.zzc--;
        ((AbstractList) this).modCount++;
        return Double.valueOf(d5);
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i5, int i6) {
        zza();
        if (i6 < i5) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        double[] dArr = this.zzb;
        System.arraycopy(dArr, i6, dArr, i5, this.zzc - i6);
        this.zzc -= i6 - i5;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i5, Object obj) {
        double doubleValue = ((Double) obj).doubleValue();
        zza();
        zzf(i5);
        double[] dArr = this.zzb;
        double d5 = dArr[i5];
        dArr[i5] = doubleValue;
        return Double.valueOf(d5);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zzkm
    public final /* synthetic */ zzkm<Double> zza(int i5) {
        if (i5 >= this.zzc) {
            return new zzjs(i5 == 0 ? zza : Arrays.copyOf(this.zzb, i5), this.zzc, true);
        }
        throw new IllegalArgumentException();
    }

    public final double zzb(int i5) {
        zzf(i5);
        return this.zzb[i5];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzc(int i5) {
        double[] dArr = this.zzb;
        if (i5 <= dArr.length) {
            return;
        }
        if (dArr.length == 0) {
            this.zzb = new double[Math.max(i5, 10)];
            return;
        }
        int length = dArr.length;
        while (length < i5) {
            length = zzd(length);
        }
        this.zzb = Arrays.copyOf(this.zzb, length);
    }

    public final void zza(double d5) {
        zza();
        int i5 = this.zzc;
        double[] dArr = this.zzb;
        if (i5 == dArr.length) {
            double[] dArr2 = new double[zzd(dArr.length)];
            System.arraycopy(this.zzb, 0, dArr2, 0, this.zzc);
            this.zzb = dArr2;
        }
        double[] dArr3 = this.zzb;
        int i6 = this.zzc;
        this.zzc = i6 + 1;
        dArr3[i6] = d5;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* synthetic */ boolean add(Object obj) {
        zza(((Double) obj).doubleValue());
        return true;
    }
}
