package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: classes.dex */
public abstract class zziy implements Serializable, Iterable<Byte> {
    public static final zziy zza = new zzjf(zzkj.zzb);
    private static final zzjb zzb = new zzji();
    private int zzc = 0;

    static {
        new zzja();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int zza(byte b5) {
        return b5 & 255;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzjd zzc(int i5) {
        return new zzjd(i5);
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i5 = this.zzc;
        if (i5 == 0) {
            int zzb2 = zzb();
            i5 = zzb(zzb2, 0, zzb2);
            if (i5 == 0) {
                i5 = 1;
            }
            this.zzc = i5;
        }
        return i5;
    }

    @Override // java.lang.Iterable
    public /* synthetic */ Iterator<Byte> iterator() {
        return new zzix(this);
    }

    public final String toString() {
        String str;
        Locale locale = Locale.ROOT;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        Integer valueOf = Integer.valueOf(zzb());
        if (zzb() <= 50) {
            str = zzmq.zza(this);
        } else {
            str = zzmq.zza(zza(0, 47)) + "...";
        }
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", hexString, valueOf, str);
    }

    public abstract byte zza(int i5);

    public abstract zziy zza(int i5, int i6);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zza(zziv zzivVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract byte zzb(int i5);

    public abstract int zzb();

    protected abstract int zzb(int i5, int i6, int i7);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(int i5, int i6, int i7) {
        int i8 = i6 - i5;
        if ((i5 | i6 | i8 | (i7 - i6)) >= 0) {
            return i8;
        }
        if (i5 < 0) {
            throw new IndexOutOfBoundsException("Beginning index: " + i5 + " < 0");
        }
        if (i6 < i5) {
            throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i5 + ", " + i6);
        }
        throw new IndexOutOfBoundsException("End index: " + i6 + " >= " + i7);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int zza() {
        return this.zzc;
    }

    public static zziy zza(byte[] bArr) {
        return zza(bArr, 0, bArr.length);
    }

    public static zziy zza(byte[] bArr, int i5, int i6) {
        zza(i5, i5 + i6, bArr.length);
        return new zzjf(zzb.zza(bArr, i5, i6));
    }

    public static zziy zza(String str) {
        return new zzjf(str.getBytes(zzkj.zza));
    }
}
