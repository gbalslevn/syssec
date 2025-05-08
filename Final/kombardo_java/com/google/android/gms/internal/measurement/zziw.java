package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes.dex */
final class zziw extends zzis<Boolean> implements zzkm<Boolean>, zzly, RandomAccess {
    private static final boolean[] zza;
    private boolean[] zzb;
    private int zzc;

    static {
        boolean[] zArr = new boolean[0];
        zza = zArr;
        new zziw(zArr, 0, false);
    }

    private zziw(boolean[] zArr, int i5, boolean z5) {
        super(z5);
        this.zzb = zArr;
        this.zzc = i5;
    }

    private static int zzc(int i5) {
        return Math.max(((i5 * 3) / 2) + 1, 10);
    }

    private final String zzd(int i5) {
        return "Index:" + i5 + ", Size:" + this.zzc;
    }

    private final void zze(int i5) {
        if (i5 < 0 || i5 >= this.zzc) {
            throw new IndexOutOfBoundsException(zzd(i5));
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i5, Object obj) {
        int i6;
        boolean booleanValue = ((Boolean) obj).booleanValue();
        zza();
        if (i5 >= 0 && i5 <= (i6 = this.zzc)) {
            boolean[] zArr = this.zzb;
            if (i6 < zArr.length) {
                System.arraycopy(zArr, i5, zArr, i5 + 1, i6 - i5);
            } else {
                boolean[] zArr2 = new boolean[zzc(zArr.length)];
                System.arraycopy(this.zzb, 0, zArr2, 0, i5);
                System.arraycopy(this.zzb, i5, zArr2, i5 + 1, this.zzc - i5);
                this.zzb = zArr2;
            }
            this.zzb[i5] = booleanValue;
            this.zzc++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(zzd(i5));
    }

    @Override // com.google.android.gms.internal.measurement.zzis, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Boolean> collection) {
        zza();
        zzkj.zza(collection);
        if (!(collection instanceof zziw)) {
            return super.addAll(collection);
        }
        zziw zziwVar = (zziw) collection;
        int i5 = zziwVar.zzc;
        if (i5 == 0) {
            return false;
        }
        int i6 = this.zzc;
        if (Integer.MAX_VALUE - i6 < i5) {
            throw new OutOfMemoryError();
        }
        int i7 = i6 + i5;
        boolean[] zArr = this.zzb;
        if (i7 > zArr.length) {
            this.zzb = Arrays.copyOf(zArr, i7);
        }
        System.arraycopy(zziwVar.zzb, 0, this.zzb, this.zzc, zziwVar.zzc);
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
        if (!(obj instanceof zziw)) {
            return super.equals(obj);
        }
        zziw zziwVar = (zziw) obj;
        if (this.zzc != zziwVar.zzc) {
            return false;
        }
        boolean[] zArr = zziwVar.zzb;
        for (int i5 = 0; i5 < this.zzc; i5++) {
            if (this.zzb[i5] != zArr[i5]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i5) {
        return Boolean.valueOf(zzb(i5));
    }

    @Override // com.google.android.gms.internal.measurement.zzis, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i5 = 1;
        for (int i6 = 0; i6 < this.zzc; i6++) {
            i5 = (i5 * 31) + zzkj.zza(this.zzb[i6]);
        }
        return i5;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Boolean)) {
            return -1;
        }
        boolean booleanValue = ((Boolean) obj).booleanValue();
        int size = size();
        for (int i5 = 0; i5 < size; i5++) {
            if (this.zzb[i5] == booleanValue) {
                return i5;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.measurement.zzis, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i5) {
        zza();
        zze(i5);
        boolean[] zArr = this.zzb;
        boolean z5 = zArr[i5];
        if (i5 < this.zzc - 1) {
            System.arraycopy(zArr, i5 + 1, zArr, i5, (r2 - i5) - 1);
        }
        this.zzc--;
        ((AbstractList) this).modCount++;
        return Boolean.valueOf(z5);
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i5, int i6) {
        zza();
        if (i6 < i5) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        boolean[] zArr = this.zzb;
        System.arraycopy(zArr, i6, zArr, i5, this.zzc - i6);
        this.zzc -= i6 - i5;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i5, Object obj) {
        boolean booleanValue = ((Boolean) obj).booleanValue();
        zza();
        zze(i5);
        boolean[] zArr = this.zzb;
        boolean z5 = zArr[i5];
        zArr[i5] = booleanValue;
        return Boolean.valueOf(z5);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zzkm
    public final /* synthetic */ zzkm<Boolean> zza(int i5) {
        if (i5 >= this.zzc) {
            return new zziw(i5 == 0 ? zza : Arrays.copyOf(this.zzb, i5), this.zzc, true);
        }
        throw new IllegalArgumentException();
    }

    public final boolean zzb(int i5) {
        zze(i5);
        return this.zzb[i5];
    }

    public final void zza(boolean z5) {
        zza();
        int i5 = this.zzc;
        boolean[] zArr = this.zzb;
        if (i5 == zArr.length) {
            boolean[] zArr2 = new boolean[zzc(zArr.length)];
            System.arraycopy(this.zzb, 0, zArr2, 0, this.zzc);
            this.zzb = zArr2;
        }
        boolean[] zArr3 = this.zzb;
        int i6 = this.zzc;
        this.zzc = i6 + 1;
        zArr3[i6] = z5;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* synthetic */ boolean add(Object obj) {
        zza(((Boolean) obj).booleanValue());
        return true;
    }
}
