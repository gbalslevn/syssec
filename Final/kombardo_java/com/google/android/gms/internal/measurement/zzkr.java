package com.google.android.gms.internal.measurement;

import org.conscrypt.BuildConfig;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'zzb' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes.dex */
public final class zzkr {
    public static final zzkr zza;
    public static final zzkr zzb;
    public static final zzkr zzc;
    public static final zzkr zzd;
    public static final zzkr zze;
    public static final zzkr zzf;
    public static final zzkr zzg;
    public static final zzkr zzh;
    public static final zzkr zzi;
    public static final zzkr zzj;
    private static final /* synthetic */ zzkr[] zzk;
    private final Class<?> zzl;

    static {
        zzkr zzkrVar = new zzkr("VOID", 0, Void.class, Void.class, null);
        zza = zzkrVar;
        Class cls = Integer.TYPE;
        zzkr zzkrVar2 = new zzkr("INT", 1, cls, Integer.class, 0);
        zzb = zzkrVar2;
        zzkr zzkrVar3 = new zzkr("LONG", 2, Long.TYPE, Long.class, 0L);
        zzc = zzkrVar3;
        zzkr zzkrVar4 = new zzkr("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0f));
        zzd = zzkrVar4;
        zzkr zzkrVar5 = new zzkr("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf(0.0d));
        zze = zzkrVar5;
        zzkr zzkrVar6 = new zzkr("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        zzf = zzkrVar6;
        zzkr zzkrVar7 = new zzkr("STRING", 6, String.class, String.class, BuildConfig.FLAVOR);
        zzg = zzkrVar7;
        zzkr zzkrVar8 = new zzkr("BYTE_STRING", 7, zziy.class, zziy.class, zziy.zza);
        zzh = zzkrVar8;
        zzkr zzkrVar9 = new zzkr("ENUM", 8, cls, Integer.class, null);
        zzi = zzkrVar9;
        zzkr zzkrVar10 = new zzkr("MESSAGE", 9, Object.class, Object.class, null);
        zzj = zzkrVar10;
        zzk = new zzkr[]{zzkrVar, zzkrVar2, zzkrVar3, zzkrVar4, zzkrVar5, zzkrVar6, zzkrVar7, zzkrVar8, zzkrVar9, zzkrVar10};
    }

    private zzkr(String str, int i5, Class cls, Class cls2, Object obj) {
        this.zzl = cls2;
    }

    public static zzkr[] values() {
        return (zzkr[]) zzk.clone();
    }

    public final Class<?> zza() {
        return this.zzl;
    }
}
