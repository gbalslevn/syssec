package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* loaded from: classes.dex */
final class zzmd<E> extends zzis<E> implements RandomAccess {
    private static final Object[] zza;
    private static final zzmd<Object> zzb;
    private E[] zzc;
    private int zzd;

    static {
        Object[] objArr = new Object[0];
        zza = objArr;
        zzb = new zzmd<>(objArr, 0, false);
    }

    private zzmd(E[] eArr, int i5, boolean z5) {
        super(z5);
        this.zzc = eArr;
        this.zzd = i5;
    }

    private static int zzc(int i5) {
        return Math.max(((i5 * 3) / 2) + 1, 10);
    }

    public static <E> zzmd<E> zzd() {
        return (zzmd<E>) zzb;
    }

    private final void zze(int i5) {
        if (i5 < 0 || i5 >= this.zzd) {
            throw new IndexOutOfBoundsException(zzd(i5));
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i5, E e5) {
        int i6;
        zza();
        if (i5 >= 0 && i5 <= (i6 = this.zzd)) {
            E[] eArr = this.zzc;
            if (i6 < eArr.length) {
                System.arraycopy(eArr, i5, eArr, i5 + 1, i6 - i5);
            } else {
                E[] eArr2 = (E[]) new Object[zzc(eArr.length)];
                System.arraycopy(this.zzc, 0, eArr2, 0, i5);
                System.arraycopy(this.zzc, i5, eArr2, i5 + 1, this.zzd - i5);
                this.zzc = eArr2;
            }
            this.zzc[i5] = e5;
            this.zzd++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(zzd(i5));
    }

    @Override // java.util.AbstractList, java.util.List
    public final E get(int i5) {
        zze(i5);
        return this.zzc[i5];
    }

    @Override // com.google.android.gms.internal.measurement.zzis, java.util.AbstractList, java.util.List
    public final E remove(int i5) {
        zza();
        zze(i5);
        E[] eArr = this.zzc;
        E e5 = eArr[i5];
        if (i5 < this.zzd - 1) {
            System.arraycopy(eArr, i5 + 1, eArr, i5, (r2 - i5) - 1);
        }
        this.zzd--;
        ((AbstractList) this).modCount++;
        return e5;
    }

    @Override // java.util.AbstractList, java.util.List
    public final E set(int i5, E e5) {
        zza();
        zze(i5);
        E[] eArr = this.zzc;
        E e6 = eArr[i5];
        eArr[i5] = e5;
        ((AbstractList) this).modCount++;
        return e6;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.measurement.zzkm
    public final /* synthetic */ zzkm zza(int i5) {
        if (i5 >= this.zzd) {
            return new zzmd(i5 == 0 ? zza : Arrays.copyOf(this.zzc, i5), this.zzd, true);
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzb(int i5) {
        E[] eArr = this.zzc;
        if (i5 <= eArr.length) {
            return;
        }
        if (eArr.length == 0) {
            this.zzc = (E[]) new Object[Math.max(i5, 10)];
            return;
        }
        int length = eArr.length;
        while (length < i5) {
            length = zzc(length);
        }
        this.zzc = (E[]) Arrays.copyOf(this.zzc, length);
    }

    private final String zzd(int i5) {
        return "Index:" + i5 + ", Size:" + this.zzd;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(E e5) {
        zza();
        int i5 = this.zzd;
        E[] eArr = this.zzc;
        if (i5 == eArr.length) {
            this.zzc = (E[]) Arrays.copyOf(this.zzc, zzc(eArr.length));
        }
        E[] eArr2 = this.zzc;
        int i6 = this.zzd;
        this.zzd = i6 + 1;
        eArr2[i6] = e5;
        ((AbstractList) this).modCount++;
        return true;
    }
}
