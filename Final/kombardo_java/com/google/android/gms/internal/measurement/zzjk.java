package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public abstract class zzjk {
    private static volatile int zzd = 100;
    private int zze;

    public static long zza(long j5) {
        return (-(j5 & 1)) ^ (j5 >>> 1);
    }

    public static int zze(int i5) {
        return (-(i5 & 1)) ^ (i5 >>> 1);
    }

    public abstract int zza(int i5);

    public abstract int zzc();

    private zzjk() {
        this.zze = zzd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzjk zza(byte[] bArr, int i5, int i6, boolean z5) {
        zzjj zzjjVar = new zzjj(bArr, i6);
        try {
            zzjjVar.zza(i6);
            return zzjjVar;
        } catch (zzkp e5) {
            throw new IllegalArgumentException(e5);
        }
    }
}
