package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes.dex */
final class zzkc extends zzis<Float> implements zzkm<Float>, zzly, RandomAccess {
    private static final float[] zza;
    private float[] zzb;
    private int zzc;

    static {
        float[] fArr = new float[0];
        zza = fArr;
        new zzkc(fArr, 0, false);
    }

    private zzkc(float[] fArr, int i5, boolean z5) {
        super(z5);
        this.zzb = fArr;
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
        float floatValue = ((Float) obj).floatValue();
        zza();
        if (i5 >= 0 && i5 <= (i6 = this.zzc)) {
            float[] fArr = this.zzb;
            if (i6 < fArr.length) {
                System.arraycopy(fArr, i5, fArr, i5 + 1, i6 - i5);
            } else {
                float[] fArr2 = new float[zzd(fArr.length)];
                System.arraycopy(this.zzb, 0, fArr2, 0, i5);
                System.arraycopy(this.zzb, i5, fArr2, i5 + 1, this.zzc - i5);
                this.zzb = fArr2;
            }
            this.zzb[i5] = floatValue;
            this.zzc++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(zze(i5));
    }

    @Override // com.google.android.gms.internal.measurement.zzis, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Float> collection) {
        zza();
        zzkj.zza(collection);
        if (!(collection instanceof zzkc)) {
            return super.addAll(collection);
        }
        zzkc zzkcVar = (zzkc) collection;
        int i5 = zzkcVar.zzc;
        if (i5 == 0) {
            return false;
        }
        int i6 = this.zzc;
        if (Integer.MAX_VALUE - i6 < i5) {
            throw new OutOfMemoryError();
        }
        int i7 = i6 + i5;
        float[] fArr = this.zzb;
        if (i7 > fArr.length) {
            this.zzb = Arrays.copyOf(fArr, i7);
        }
        System.arraycopy(zzkcVar.zzb, 0, this.zzb, this.zzc, zzkcVar.zzc);
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
        if (!(obj instanceof zzkc)) {
            return super.equals(obj);
        }
        zzkc zzkcVar = (zzkc) obj;
        if (this.zzc != zzkcVar.zzc) {
            return false;
        }
        float[] fArr = zzkcVar.zzb;
        for (int i5 = 0; i5 < this.zzc; i5++) {
            if (Float.floatToIntBits(this.zzb[i5]) != Float.floatToIntBits(fArr[i5])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i5) {
        return Float.valueOf(zzb(i5));
    }

    @Override // com.google.android.gms.internal.measurement.zzis, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i5 = 1;
        for (int i6 = 0; i6 < this.zzc; i6++) {
            i5 = (i5 * 31) + Float.floatToIntBits(this.zzb[i6]);
        }
        return i5;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Float)) {
            return -1;
        }
        float floatValue = ((Float) obj).floatValue();
        int size = size();
        for (int i5 = 0; i5 < size; i5++) {
            if (this.zzb[i5] == floatValue) {
                return i5;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.measurement.zzis, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i5) {
        zza();
        zzf(i5);
        float[] fArr = this.zzb;
        float f5 = fArr[i5];
        if (i5 < this.zzc - 1) {
            System.arraycopy(fArr, i5 + 1, fArr, i5, (r2 - i5) - 1);
        }
        this.zzc--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(f5);
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i5, int i6) {
        zza();
        if (i6 < i5) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        float[] fArr = this.zzb;
        System.arraycopy(fArr, i6, fArr, i5, this.zzc - i6);
        this.zzc -= i6 - i5;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i5, Object obj) {
        float floatValue = ((Float) obj).floatValue();
        zza();
        zzf(i5);
        float[] fArr = this.zzb;
        float f5 = fArr[i5];
        fArr[i5] = floatValue;
        return Float.valueOf(f5);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zzkm
    public final /* synthetic */ zzkm<Float> zza(int i5) {
        if (i5 >= this.zzc) {
            return new zzkc(i5 == 0 ? zza : Arrays.copyOf(this.zzb, i5), this.zzc, true);
        }
        throw new IllegalArgumentException();
    }

    public final float zzb(int i5) {
        zzf(i5);
        return this.zzb[i5];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzc(int i5) {
        float[] fArr = this.zzb;
        if (i5 <= fArr.length) {
            return;
        }
        if (fArr.length == 0) {
            this.zzb = new float[Math.max(i5, 10)];
            return;
        }
        int length = fArr.length;
        while (length < i5) {
            length = zzd(length);
        }
        this.zzb = Arrays.copyOf(this.zzb, length);
    }

    public final void zza(float f5) {
        zza();
        int i5 = this.zzc;
        float[] fArr = this.zzb;
        if (i5 == fArr.length) {
            float[] fArr2 = new float[zzd(fArr.length)];
            System.arraycopy(this.zzb, 0, fArr2, 0, this.zzc);
            this.zzb = fArr2;
        }
        float[] fArr3 = this.zzb;
        int i6 = this.zzc;
        this.zzc = i6 + 1;
        fArr3[i6] = f5;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* synthetic */ boolean add(Object obj) {
        zza(((Float) obj).floatValue());
        return true;
    }
}
