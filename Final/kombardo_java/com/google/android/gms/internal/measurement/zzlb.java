package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzlb extends zzis<Long> implements zzkn, zzly, RandomAccess {
    private static final long[] zza;
    private static final zzlb zzb;
    private long[] zzc;
    private int zzd;

    static {
        long[] jArr = new long[0];
        zza = jArr;
        zzb = new zzlb(jArr, 0, false);
    }

    private zzlb(long[] jArr, int i5, boolean z5) {
        super(z5);
        this.zzc = jArr;
        this.zzd = i5;
    }

    public static zzlb zzd() {
        return zzb;
    }

    private static int zze(int i5) {
        return Math.max(((i5 * 3) / 2) + 1, 10);
    }

    private final String zzf(int i5) {
        return "Index:" + i5 + ", Size:" + this.zzd;
    }

    private final void zzg(int i5) {
        if (i5 < 0 || i5 >= this.zzd) {
            throw new IndexOutOfBoundsException(zzf(i5));
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i5, Object obj) {
        int i6;
        long longValue = ((Long) obj).longValue();
        zza();
        if (i5 >= 0 && i5 <= (i6 = this.zzd)) {
            long[] jArr = this.zzc;
            if (i6 < jArr.length) {
                System.arraycopy(jArr, i5, jArr, i5 + 1, i6 - i5);
            } else {
                long[] jArr2 = new long[zze(jArr.length)];
                System.arraycopy(this.zzc, 0, jArr2, 0, i5);
                System.arraycopy(this.zzc, i5, jArr2, i5 + 1, this.zzd - i5);
                this.zzc = jArr2;
            }
            this.zzc[i5] = longValue;
            this.zzd++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(zzf(i5));
    }

    @Override // com.google.android.gms.internal.measurement.zzis, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Long> collection) {
        zza();
        zzkj.zza(collection);
        if (!(collection instanceof zzlb)) {
            return super.addAll(collection);
        }
        zzlb zzlbVar = (zzlb) collection;
        int i5 = zzlbVar.zzd;
        if (i5 == 0) {
            return false;
        }
        int i6 = this.zzd;
        if (Integer.MAX_VALUE - i6 < i5) {
            throw new OutOfMemoryError();
        }
        int i7 = i6 + i5;
        long[] jArr = this.zzc;
        if (i7 > jArr.length) {
            this.zzc = Arrays.copyOf(jArr, i7);
        }
        System.arraycopy(zzlbVar.zzc, 0, this.zzc, this.zzd, zzlbVar.zzd);
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
        if (!(obj instanceof zzlb)) {
            return super.equals(obj);
        }
        zzlb zzlbVar = (zzlb) obj;
        if (this.zzd != zzlbVar.zzd) {
            return false;
        }
        long[] jArr = zzlbVar.zzc;
        for (int i5 = 0; i5 < this.zzd; i5++) {
            if (this.zzc[i5] != jArr[i5]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i5) {
        return Long.valueOf(zzb(i5));
    }

    @Override // com.google.android.gms.internal.measurement.zzis, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i5 = 1;
        for (int i6 = 0; i6 < this.zzd; i6++) {
            i5 = (i5 * 31) + zzkj.zza(this.zzc[i6]);
        }
        return i5;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Long)) {
            return -1;
        }
        long longValue = ((Long) obj).longValue();
        int size = size();
        for (int i5 = 0; i5 < size; i5++) {
            if (this.zzc[i5] == longValue) {
                return i5;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.measurement.zzis, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i5) {
        zza();
        zzg(i5);
        long[] jArr = this.zzc;
        long j5 = jArr[i5];
        if (i5 < this.zzd - 1) {
            System.arraycopy(jArr, i5 + 1, jArr, i5, (r3 - i5) - 1);
        }
        this.zzd--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j5);
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i5, int i6) {
        zza();
        if (i6 < i5) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        long[] jArr = this.zzc;
        System.arraycopy(jArr, i6, jArr, i5, this.zzd - i6);
        this.zzd -= i6 - i5;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i5, Object obj) {
        long longValue = ((Long) obj).longValue();
        zza();
        zzg(i5);
        long[] jArr = this.zzc;
        long j5 = jArr[i5];
        jArr[i5] = longValue;
        return Long.valueOf(j5);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.measurement.zzkn
    public final long zzb(int i5) {
        zzg(i5);
        return this.zzc[i5];
    }

    @Override // com.google.android.gms.internal.measurement.zzkm
    /* renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public final zzkn zza(int i5) {
        if (i5 >= this.zzd) {
            return new zzlb(i5 == 0 ? zza : Arrays.copyOf(this.zzc, i5), this.zzd, true);
        }
        throw new IllegalArgumentException();
    }

    public final void zza(long j5) {
        zza();
        int i5 = this.zzd;
        long[] jArr = this.zzc;
        if (i5 == jArr.length) {
            long[] jArr2 = new long[zze(jArr.length)];
            System.arraycopy(this.zzc, 0, jArr2, 0, this.zzd);
            this.zzc = jArr2;
        }
        long[] jArr3 = this.zzc;
        int i6 = this.zzd;
        this.zzd = i6 + 1;
        jArr3[i6] = j5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzd(int i5) {
        long[] jArr = this.zzc;
        if (i5 <= jArr.length) {
            return;
        }
        if (jArr.length == 0) {
            this.zzc = new long[Math.max(i5, 10)];
            return;
        }
        int length = jArr.length;
        while (length < i5) {
            length = zze(length);
        }
        this.zzc = Arrays.copyOf(this.zzc, length);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* synthetic */ boolean add(Object obj) {
        zza(((Long) obj).longValue());
        return true;
    }
}
