package com.google.android.gms.internal.measurement;

import com.sun.jna.Function;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class zzmz {
    static final boolean zza;
    private static final Unsafe zzb;
    private static final Class<?> zzc;
    private static final boolean zzd;
    private static final boolean zze;
    private static final zzc zzf;
    private static final boolean zzg;
    private static final boolean zzh;
    private static final long zzi;

    /* loaded from: classes.dex */
    private static final class zza extends zzc {
        zza(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.measurement.zzmz.zzc
        public final double zza(Object obj, long j5) {
            return Double.longBitsToDouble(zze(obj, j5));
        }

        @Override // com.google.android.gms.internal.measurement.zzmz.zzc
        public final float zzb(Object obj, long j5) {
            return Float.intBitsToFloat(zzd(obj, j5));
        }

        @Override // com.google.android.gms.internal.measurement.zzmz.zzc
        public final boolean zzc(Object obj, long j5) {
            return zzmz.zza ? zzmz.zzf(obj, j5) : zzmz.zzg(obj, j5);
        }

        @Override // com.google.android.gms.internal.measurement.zzmz.zzc
        public final void zza(Object obj, long j5, boolean z5) {
            if (zzmz.zza) {
                zzmz.zza(obj, j5, z5);
            } else {
                zzmz.zzb(obj, j5, z5);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzmz.zzc
        public final void zza(Object obj, long j5, byte b5) {
            if (!zzmz.zza) {
                zzmz.zzd(obj, j5, b5);
            } else {
                zzmz.zzc(obj, j5, b5);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzmz.zzc
        public final void zza(Object obj, long j5, double d5) {
            zza(obj, j5, Double.doubleToLongBits(d5));
        }

        @Override // com.google.android.gms.internal.measurement.zzmz.zzc
        public final void zza(Object obj, long j5, float f5) {
            zza(obj, j5, Float.floatToIntBits(f5));
        }
    }

    /* loaded from: classes.dex */
    private static final class zzb extends zzc {
        zzb(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.measurement.zzmz.zzc
        public final double zza(Object obj, long j5) {
            return Double.longBitsToDouble(zze(obj, j5));
        }

        @Override // com.google.android.gms.internal.measurement.zzmz.zzc
        public final float zzb(Object obj, long j5) {
            return Float.intBitsToFloat(zzd(obj, j5));
        }

        @Override // com.google.android.gms.internal.measurement.zzmz.zzc
        public final boolean zzc(Object obj, long j5) {
            return zzmz.zza ? zzmz.zzf(obj, j5) : zzmz.zzg(obj, j5);
        }

        @Override // com.google.android.gms.internal.measurement.zzmz.zzc
        public final void zza(Object obj, long j5, boolean z5) {
            if (zzmz.zza) {
                zzmz.zza(obj, j5, z5);
            } else {
                zzmz.zzb(obj, j5, z5);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzmz.zzc
        public final void zza(Object obj, long j5, byte b5) {
            if (!zzmz.zza) {
                zzmz.zzd(obj, j5, b5);
            } else {
                zzmz.zzc(obj, j5, b5);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzmz.zzc
        public final void zza(Object obj, long j5, double d5) {
            zza(obj, j5, Double.doubleToLongBits(d5));
        }

        @Override // com.google.android.gms.internal.measurement.zzmz.zzc
        public final void zza(Object obj, long j5, float f5) {
            zza(obj, j5, Float.floatToIntBits(f5));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static abstract class zzc {
        Unsafe zza;

        zzc(Unsafe unsafe) {
            this.zza = unsafe;
        }

        public abstract double zza(Object obj, long j5);

        public abstract void zza(Object obj, long j5, byte b5);

        public abstract void zza(Object obj, long j5, double d5);

        public abstract void zza(Object obj, long j5, float f5);

        public final void zza(Object obj, long j5, int i5) {
            this.zza.putInt(obj, j5, i5);
        }

        public abstract void zza(Object obj, long j5, boolean z5);

        public abstract float zzb(Object obj, long j5);

        public final boolean zzb() {
            Unsafe unsafe = this.zza;
            if (unsafe == null) {
                return false;
            }
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", Field.class);
                cls.getMethod("getLong", Object.class, Long.TYPE);
                return zzmz.zza() != null;
            } catch (Throwable th) {
                zzmz.zza(th);
                return false;
            }
        }

        public abstract boolean zzc(Object obj, long j5);

        public final int zzd(Object obj, long j5) {
            return this.zza.getInt(obj, j5);
        }

        public final long zze(Object obj, long j5) {
            return this.zza.getLong(obj, j5);
        }

        public final void zza(Object obj, long j5, long j6) {
            this.zza.putLong(obj, j5, j6);
        }

        public final boolean zza() {
            Unsafe unsafe = this.zza;
            if (unsafe == null) {
                return false;
            }
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", Field.class);
                cls.getMethod("arrayBaseOffset", Class.class);
                cls.getMethod("arrayIndexScale", Class.class);
                Class cls2 = Long.TYPE;
                cls.getMethod("getInt", Object.class, cls2);
                cls.getMethod("putInt", Object.class, cls2, Integer.TYPE);
                cls.getMethod("getLong", Object.class, cls2);
                cls.getMethod("putLong", Object.class, cls2, cls2);
                cls.getMethod("getObject", Object.class, cls2);
                cls.getMethod("putObject", Object.class, cls2, Object.class);
                return true;
            } catch (Throwable th) {
                zzmz.zza(th);
                return false;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0034  */
    static {
        zzc zzcVar;
        Field zze2;
        Unsafe zzb2 = zzb();
        zzb = zzb2;
        zzc = zzir.zza();
        boolean zzd2 = zzd(Long.TYPE);
        zzd = zzd2;
        boolean zzd3 = zzd(Integer.TYPE);
        zze = zzd3;
        if (zzb2 != null) {
            if (zzd2) {
                zzcVar = new zza(zzb2);
            } else if (zzd3) {
                zzcVar = new zzb(zzb2);
            }
            zzf = zzcVar;
            zzg = zzcVar != null ? false : zzcVar.zzb();
            zzh = zzcVar != null ? false : zzcVar.zza();
            zzi = zzb(byte[].class);
            zzb(boolean[].class);
            zzc(boolean[].class);
            zzb(int[].class);
            zzc(int[].class);
            zzb(long[].class);
            zzc(long[].class);
            zzb(float[].class);
            zzc(float[].class);
            zzb(double[].class);
            zzc(double[].class);
            zzb(Object[].class);
            zzc(Object[].class);
            zze2 = zze();
            if (zze2 != null && zzcVar != null) {
                zzcVar.zza.objectFieldOffset(zze2);
            }
            zza = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
        }
        zzcVar = null;
        zzf = zzcVar;
        zzg = zzcVar != null ? false : zzcVar.zzb();
        zzh = zzcVar != null ? false : zzcVar.zza();
        zzi = zzb(byte[].class);
        zzb(boolean[].class);
        zzc(boolean[].class);
        zzb(int[].class);
        zzc(int[].class);
        zzb(long[].class);
        zzc(long[].class);
        zzb(float[].class);
        zzc(float[].class);
        zzb(double[].class);
        zzc(double[].class);
        zzb(Object[].class);
        zzc(Object[].class);
        zze2 = zze();
        if (zze2 != null) {
            zzcVar.zza.objectFieldOffset(zze2);
        }
        zza = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    static /* synthetic */ Field zza() {
        return zze();
    }

    private static int zzc(Class<?> cls) {
        if (zzh) {
            return zzf.zza.arrayIndexScale(cls);
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long zzd(Object obj, long j5) {
        return zzf.zze(obj, j5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zze(Object obj, long j5) {
        return zzf.zza.getObject(obj, j5);
    }

    static /* synthetic */ boolean zzf(Object obj, long j5) {
        return ((byte) (zzc(obj, (-4) & j5) >>> ((int) (((~j5) & 3) << 3)))) != 0;
    }

    static /* synthetic */ boolean zzg(Object obj, long j5) {
        return ((byte) (zzc(obj, (-4) & j5) >>> ((int) ((j5 & 3) << 3)))) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzh(Object obj, long j5) {
        return zzf.zzc(obj, j5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float zzb(Object obj, long j5) {
        return zzf.zzb(obj, j5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzd(Object obj, long j5, byte b5) {
        long j6 = (-4) & j5;
        int i5 = (((int) j5) & 3) << 3;
        zza(obj, j6, ((255 & b5) << i5) | (zzc(obj, j6) & (~(Function.USE_VARARGS << i5))));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static double zza(Object obj, long j5) {
        return zzf.zza(obj, j5);
    }

    private static int zzb(Class<?> cls) {
        if (zzh) {
            return zzf.zza.arrayBaseOffset(cls);
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(Object obj, long j5) {
        return zzf.zzd(obj, j5);
    }

    private static Field zze() {
        Field zza2 = zza((Class<?>) Buffer.class, "effectiveDirectAddress");
        if (zza2 != null) {
            return zza2;
        }
        Field zza3 = zza((Class<?>) Buffer.class, "address");
        if (zza3 == null || zza3.getType() != Long.TYPE) {
            return null;
        }
        return zza3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T zza(Class<T> cls) {
        try {
            return (T) zzb.allocateInstance(cls);
        } catch (InstantiationException e5) {
            throw new IllegalStateException(e5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzc(Object obj, long j5, boolean z5) {
        zzf.zza(obj, j5, z5);
    }

    private static boolean zzd(Class<?> cls) {
        try {
            Class<?> cls2 = zzc;
            Class cls3 = Boolean.TYPE;
            cls2.getMethod("peekLong", cls, cls3);
            cls2.getMethod("pokeLong", cls, Long.TYPE, cls3);
            Class cls4 = Integer.TYPE;
            cls2.getMethod("pokeInt", cls, cls4, cls3);
            cls2.getMethod("peekInt", cls, cls3);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, cls4, cls4);
            cls2.getMethod("peekByteArray", cls, byte[].class, cls4, cls4);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Unsafe zzb() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzmy());
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzc(Object obj, long j5, byte b5) {
        long j6 = (-4) & j5;
        int zzc2 = zzc(obj, j6);
        int i5 = ((~((int) j5)) & 3) << 3;
        zza(obj, j6, ((255 & b5) << i5) | (zzc2 & (~(Function.USE_VARARGS << i5))));
    }

    private static Field zza(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    static /* synthetic */ void zza(Throwable th) {
        Logger.getLogger(zzmz.class.getName()).logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: " + String.valueOf(th));
    }

    static /* synthetic */ void zzb(Object obj, long j5, boolean z5) {
        zzd(obj, j5, z5 ? (byte) 1 : (byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzc() {
        return zzh;
    }

    static /* synthetic */ void zza(Object obj, long j5, boolean z5) {
        zzc(obj, j5, z5 ? (byte) 1 : (byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(byte[] bArr, long j5, byte b5) {
        zzf.zza((Object) bArr, zzi + j5, b5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(Object obj, long j5, double d5) {
        zzf.zza(obj, j5, d5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(Object obj, long j5, float f5) {
        zzf.zza(obj, j5, f5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(Object obj, long j5, int i5) {
        zzf.zza(obj, j5, i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzd() {
        return zzg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(Object obj, long j5, long j6) {
        zzf.zza(obj, j5, j6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(Object obj, long j5, Object obj2) {
        zzf.zza.putObject(obj, j5, obj2);
    }
}
