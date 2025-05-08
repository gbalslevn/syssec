package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzkh extends zzis<Integer> implements zzkk, zzly, RandomAccess {
    private static final int[] zza;
    private static final zzkh zzb;
    private int[] zzc;
    private int zzd;

    static {
        int[] iArr = new int[0];
        zza = iArr;
        zzb = new zzkh(iArr, 0, false);
    }

    private zzkh(int[] iArr, int i5, boolean z5) {
        super(z5);
        this.zzc = iArr;
        this.zzd = i5;
    }

    public static zzkh zzd() {
        return zzb;
    }

    private static int zzf(int i5) {
        return Math.max(((i5 * 3) / 2) + 1, 10);
    }

    private final String zzg(int i5) {
        return "Index:" + i5 + ", Size:" + this.zzd;
    }

    private final void zzh(int i5) {
        if (i5 < 0 || i5 >= this.zzd) {
            throw new IndexOutOfBoundsException(zzg(i5));
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i5, Object obj) {
        int i6;
        int intValue = ((Integer) obj).intValue();
        zza();
        if (i5 >= 0 && i5 <= (i6 = this.zzd)) {
            int[] iArr = this.zzc;
            if (i6 < iArr.length) {
                System.arraycopy(iArr, i5, iArr, i5 + 1, i6 - i5);
            } else {
                int[] iArr2 = new int[zzf(iArr.length)];
                System.arraycopy(this.zzc, 0, iArr2, 0, i5);
                System.arraycopy(this.zzc, i5, iArr2, i5 + 1, this.zzd - i5);
                this.zzc = iArr2;
            }
            this.zzc[i5] = intValue;
            this.zzd++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(zzg(i5));
    }

    @Override // com.google.android.gms.internal.measurement.zzis, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Integer> collection) {
        zza();
        zzkj.zza(collection);
        if (!(collection instanceof zzkh)) {
            return super.addAll(collection);
        }
        zzkh zzkhVar = (zzkh) collection;
        int i5 = zzkhVar.zzd;
        if (i5 == 0) {
            return false;
        }
        int i6 = this.zzd;
        if (Integer.MAX_VALUE - i6 < i5) {
            throw new OutOfMemoryError();
        }
        int i7 = i6 + i5;
        int[] iArr = this.zzc;
        if (i7 > iArr.length) {
            this.zzc = Arrays.copyOf(iArr, i7);
        }
        System.arraycopy(zzkhVar.zzc, 0, this.zzc, this.zzd, zzkhVar.zzd);
        this.zzd = i7;
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
        if (!(obj instanceof zzkh)) {
            return super.equals(obj);
        }
        zzkh zzkhVar = (zzkh) obj;
        if (this.zzd != zzkhVar.zzd) {
            return false;
        }
        int[] iArr = zzkhVar.zzc;
        for (int i5 = 0; i5 < this.zzd; i5++) {
            if (this.zzc[i5] != iArr[i5]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i5) {
        return Integer.valueOf(zzb(i5));
    }

    @Override // com.google.android.gms.internal.measurement.zzis, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i5 = 1;
        for (int i6 = 0; i6 < this.zzd; i6++) {
            i5 = (i5 * 31) + this.zzc[i6];
        }
        return i5;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int intValue = ((Integer) obj).intValue();
        int size = size();
        for (int i5 = 0; i5 < size; i5++) {
            if (this.zzc[i5] == intValue) {
                return i5;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.measurement.zzis, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i5) {
        zza();
        zzh(i5);
        int[] iArr = this.zzc;
        int i6 = iArr[i5];
        if (i5 < this.zzd - 1) {
            System.arraycopy(iArr, i5 + 1, iArr, i5, (r2 - i5) - 1);
        }
        this.zzd--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i6);
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i5, int i6) {
        zza();
        if (i6 < i5) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        int[] iArr = this.zzc;
        System.arraycopy(iArr, i6, iArr, i5, this.zzd - i6);
        this.zzd -= i6 - i5;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i5, Object obj) {
        int intValue = ((Integer) obj).intValue();
        zza();
        zzh(i5);
        int[] iArr = this.zzc;
        int i6 = iArr[i5];
        iArr[i5] = intValue;
        return Integer.valueOf(i6);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzd;
    }

    public final int zzb(int i5) {
        zzh(i5);
        return this.zzc[i5];
    }

    @Override // com.google.android.gms.internal.measurement.zzkm
    /* renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public final zzkk zza(int i5) {
        if (i5 >= this.zzd) {
            return new zzkh(i5 == 0 ? zza : Arrays.copyOf(this.zzc, i5), this.zzd, true);
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zze(int i5) {
        int[] iArr = this.zzc;
        if (i5 <= iArr.length) {
            return;
        }
        if (iArr.length == 0) {
            this.zzc = new int[Math.max(i5, 10)];
            return;
        }
        int length = iArr.length;
        while (length < i5) {
            length = zzf(length);
        }
        this.zzc = Arrays.copyOf(this.zzc, length);
    }

    public final void zzd(int i5) {
        zza();
        int i6 = this.zzd;
        int[] iArr = this.zzc;
        if (i6 == iArr.length) {
            int[] iArr2 = new int[zzf(iArr.length)];
            System.arraycopy(this.zzc, 0, iArr2, 0, this.zzd);
            this.zzc = iArr2;
        }
        int[] iArr3 = this.zzc;
        int i7 = this.zzd;
        this.zzd = i7 + 1;
        iArr3[i7] = i5;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* synthetic */ boolean add(Object obj) {
        zzd(((Integer) obj).intValue());
        return true;
    }
}
