package com.google.android.gms.internal.measurement;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'zzc' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes.dex */
public final class zzkb {
    public static final zzkb zza;
    private static final zzkb zzaa;
    private static final zzkb zzab;
    private static final zzkb zzac;
    private static final zzkb zzad;
    private static final zzkb zzae;
    private static final zzkb zzaf;
    private static final zzkb zzag;
    private static final zzkb zzah;
    private static final zzkb zzai;
    private static final zzkb zzaj;
    private static final zzkb zzak;
    private static final zzkb zzal;
    private static final zzkb zzam;
    private static final zzkb zzan;
    private static final zzkb zzao;
    private static final zzkb zzap;
    private static final zzkb zzaq;
    private static final zzkb zzar;
    private static final zzkb zzas;
    private static final zzkb zzat;
    private static final zzkb zzau;
    private static final zzkb zzav;
    private static final zzkb zzaw;
    private static final zzkb zzax;
    private static final zzkb zzay;
    private static final zzkb[] zzaz;
    public static final zzkb zzb;
    private static final /* synthetic */ zzkb[] zzba;
    private static final zzkb zzc;
    private static final zzkb zzd;
    private static final zzkb zze;
    private static final zzkb zzf;
    private static final zzkb zzg;
    private static final zzkb zzh;
    private static final zzkb zzi;
    private static final zzkb zzj;
    private static final zzkb zzk;
    private static final zzkb zzl;
    private static final zzkb zzm;
    private static final zzkb zzn;
    private static final zzkb zzo;
    private static final zzkb zzp;
    private static final zzkb zzq;
    private static final zzkb zzr;
    private static final zzkb zzs;
    private static final zzkb zzt;
    private static final zzkb zzu;
    private static final zzkb zzv;
    private static final zzkb zzw;
    private static final zzkb zzx;
    private static final zzkb zzy;
    private static final zzkb zzz;
    private final int zzbb;

    static {
        zzkd zzkdVar = zzkd.SCALAR;
        zzkr zzkrVar = zzkr.zze;
        zzkb zzkbVar = new zzkb("DOUBLE", 0, 0, zzkdVar, zzkrVar);
        zzc = zzkbVar;
        zzkr zzkrVar2 = zzkr.zzd;
        zzkb zzkbVar2 = new zzkb("FLOAT", 1, 1, zzkdVar, zzkrVar2);
        zzd = zzkbVar2;
        zzkr zzkrVar3 = zzkr.zzc;
        zzkb zzkbVar3 = new zzkb("INT64", 2, 2, zzkdVar, zzkrVar3);
        zze = zzkbVar3;
        zzkb zzkbVar4 = new zzkb("UINT64", 3, 3, zzkdVar, zzkrVar3);
        zzf = zzkbVar4;
        zzkr zzkrVar4 = zzkr.zzb;
        zzkb zzkbVar5 = new zzkb("INT32", 4, 4, zzkdVar, zzkrVar4);
        zzg = zzkbVar5;
        zzkb zzkbVar6 = new zzkb("FIXED64", 5, 5, zzkdVar, zzkrVar3);
        zzh = zzkbVar6;
        zzkb zzkbVar7 = new zzkb("FIXED32", 6, 6, zzkdVar, zzkrVar4);
        zzi = zzkbVar7;
        zzkr zzkrVar5 = zzkr.zzf;
        zzkb zzkbVar8 = new zzkb("BOOL", 7, 7, zzkdVar, zzkrVar5);
        zzj = zzkbVar8;
        zzkr zzkrVar6 = zzkr.zzg;
        zzkb zzkbVar9 = new zzkb("STRING", 8, 8, zzkdVar, zzkrVar6);
        zzk = zzkbVar9;
        zzkr zzkrVar7 = zzkr.zzj;
        zzkb zzkbVar10 = new zzkb("MESSAGE", 9, 9, zzkdVar, zzkrVar7);
        zzl = zzkbVar10;
        zzkr zzkrVar8 = zzkr.zzh;
        zzkb zzkbVar11 = new zzkb("BYTES", 10, 10, zzkdVar, zzkrVar8);
        zzm = zzkbVar11;
        zzkb zzkbVar12 = new zzkb("UINT32", 11, 11, zzkdVar, zzkrVar4);
        zzn = zzkbVar12;
        zzkr zzkrVar9 = zzkr.zzi;
        zzkb zzkbVar13 = new zzkb("ENUM", 12, 12, zzkdVar, zzkrVar9);
        zzo = zzkbVar13;
        zzkb zzkbVar14 = new zzkb("SFIXED32", 13, 13, zzkdVar, zzkrVar4);
        zzp = zzkbVar14;
        zzkb zzkbVar15 = new zzkb("SFIXED64", 14, 14, zzkdVar, zzkrVar3);
        zzq = zzkbVar15;
        zzkb zzkbVar16 = new zzkb("SINT32", 15, 15, zzkdVar, zzkrVar4);
        zzr = zzkbVar16;
        zzkb zzkbVar17 = new zzkb("SINT64", 16, 16, zzkdVar, zzkrVar3);
        zzs = zzkbVar17;
        zzkb zzkbVar18 = new zzkb("GROUP", 17, 17, zzkdVar, zzkrVar7);
        zzt = zzkbVar18;
        zzkd zzkdVar2 = zzkd.VECTOR;
        zzkb zzkbVar19 = new zzkb("DOUBLE_LIST", 18, 18, zzkdVar2, zzkrVar);
        zzu = zzkbVar19;
        zzkb zzkbVar20 = new zzkb("FLOAT_LIST", 19, 19, zzkdVar2, zzkrVar2);
        zzv = zzkbVar20;
        zzkb zzkbVar21 = new zzkb("INT64_LIST", 20, 20, zzkdVar2, zzkrVar3);
        zzw = zzkbVar21;
        zzkb zzkbVar22 = new zzkb("UINT64_LIST", 21, 21, zzkdVar2, zzkrVar3);
        zzx = zzkbVar22;
        zzkb zzkbVar23 = new zzkb("INT32_LIST", 22, 22, zzkdVar2, zzkrVar4);
        zzy = zzkbVar23;
        zzkb zzkbVar24 = new zzkb("FIXED64_LIST", 23, 23, zzkdVar2, zzkrVar3);
        zzz = zzkbVar24;
        zzkb zzkbVar25 = new zzkb("FIXED32_LIST", 24, 24, zzkdVar2, zzkrVar4);
        zzaa = zzkbVar25;
        zzkb zzkbVar26 = new zzkb("BOOL_LIST", 25, 25, zzkdVar2, zzkrVar5);
        zzab = zzkbVar26;
        zzkb zzkbVar27 = new zzkb("STRING_LIST", 26, 26, zzkdVar2, zzkrVar6);
        zzac = zzkbVar27;
        zzkb zzkbVar28 = new zzkb("MESSAGE_LIST", 27, 27, zzkdVar2, zzkrVar7);
        zzad = zzkbVar28;
        zzkb zzkbVar29 = new zzkb("BYTES_LIST", 28, 28, zzkdVar2, zzkrVar8);
        zzae = zzkbVar29;
        zzkb zzkbVar30 = new zzkb("UINT32_LIST", 29, 29, zzkdVar2, zzkrVar4);
        zzaf = zzkbVar30;
        zzkb zzkbVar31 = new zzkb("ENUM_LIST", 30, 30, zzkdVar2, zzkrVar9);
        zzag = zzkbVar31;
        zzkb zzkbVar32 = new zzkb("SFIXED32_LIST", 31, 31, zzkdVar2, zzkrVar4);
        zzah = zzkbVar32;
        zzkb zzkbVar33 = new zzkb("SFIXED64_LIST", 32, 32, zzkdVar2, zzkrVar3);
        zzai = zzkbVar33;
        zzkb zzkbVar34 = new zzkb("SINT32_LIST", 33, 33, zzkdVar2, zzkrVar4);
        zzaj = zzkbVar34;
        zzkb zzkbVar35 = new zzkb("SINT64_LIST", 34, 34, zzkdVar2, zzkrVar3);
        zzak = zzkbVar35;
        zzkd zzkdVar3 = zzkd.PACKED_VECTOR;
        zzkb zzkbVar36 = new zzkb("DOUBLE_LIST_PACKED", 35, 35, zzkdVar3, zzkrVar);
        zza = zzkbVar36;
        zzkb zzkbVar37 = new zzkb("FLOAT_LIST_PACKED", 36, 36, zzkdVar3, zzkrVar2);
        zzal = zzkbVar37;
        zzkb zzkbVar38 = new zzkb("INT64_LIST_PACKED", 37, 37, zzkdVar3, zzkrVar3);
        zzam = zzkbVar38;
        zzkb zzkbVar39 = new zzkb("UINT64_LIST_PACKED", 38, 38, zzkdVar3, zzkrVar3);
        zzan = zzkbVar39;
        zzkb zzkbVar40 = new zzkb("INT32_LIST_PACKED", 39, 39, zzkdVar3, zzkrVar4);
        zzao = zzkbVar40;
        zzkb zzkbVar41 = new zzkb("FIXED64_LIST_PACKED", 40, 40, zzkdVar3, zzkrVar3);
        zzap = zzkbVar41;
        zzkb zzkbVar42 = new zzkb("FIXED32_LIST_PACKED", 41, 41, zzkdVar3, zzkrVar4);
        zzaq = zzkbVar42;
        zzkb zzkbVar43 = new zzkb("BOOL_LIST_PACKED", 42, 42, zzkdVar3, zzkrVar5);
        zzar = zzkbVar43;
        zzkb zzkbVar44 = new zzkb("UINT32_LIST_PACKED", 43, 43, zzkdVar3, zzkrVar4);
        zzas = zzkbVar44;
        zzkb zzkbVar45 = new zzkb("ENUM_LIST_PACKED", 44, 44, zzkdVar3, zzkrVar9);
        zzat = zzkbVar45;
        zzkb zzkbVar46 = new zzkb("SFIXED32_LIST_PACKED", 45, 45, zzkdVar3, zzkrVar4);
        zzau = zzkbVar46;
        zzkb zzkbVar47 = new zzkb("SFIXED64_LIST_PACKED", 46, 46, zzkdVar3, zzkrVar3);
        zzav = zzkbVar47;
        zzkb zzkbVar48 = new zzkb("SINT32_LIST_PACKED", 47, 47, zzkdVar3, zzkrVar4);
        zzaw = zzkbVar48;
        zzkb zzkbVar49 = new zzkb("SINT64_LIST_PACKED", 48, 48, zzkdVar3, zzkrVar3);
        zzb = zzkbVar49;
        zzkb zzkbVar50 = new zzkb("GROUP_LIST", 49, 49, zzkdVar2, zzkrVar7);
        zzax = zzkbVar50;
        zzkb zzkbVar51 = new zzkb("MAP", 50, 50, zzkd.MAP, zzkr.zza);
        zzay = zzkbVar51;
        zzba = new zzkb[]{zzkbVar, zzkbVar2, zzkbVar3, zzkbVar4, zzkbVar5, zzkbVar6, zzkbVar7, zzkbVar8, zzkbVar9, zzkbVar10, zzkbVar11, zzkbVar12, zzkbVar13, zzkbVar14, zzkbVar15, zzkbVar16, zzkbVar17, zzkbVar18, zzkbVar19, zzkbVar20, zzkbVar21, zzkbVar22, zzkbVar23, zzkbVar24, zzkbVar25, zzkbVar26, zzkbVar27, zzkbVar28, zzkbVar29, zzkbVar30, zzkbVar31, zzkbVar32, zzkbVar33, zzkbVar34, zzkbVar35, zzkbVar36, zzkbVar37, zzkbVar38, zzkbVar39, zzkbVar40, zzkbVar41, zzkbVar42, zzkbVar43, zzkbVar44, zzkbVar45, zzkbVar46, zzkbVar47, zzkbVar48, zzkbVar49, zzkbVar50, zzkbVar51};
        zzkb[] values = values();
        zzaz = new zzkb[values.length];
        for (zzkb zzkbVar52 : values) {
            zzaz[zzkbVar52.zzbb] = zzkbVar52;
        }
    }

    private zzkb(String str, int i5, int i6, zzkd zzkdVar, zzkr zzkrVar) {
        this.zzbb = i6;
        int ordinal = zzkdVar.ordinal();
        if (ordinal == 1) {
            zzkrVar.zza();
        } else if (ordinal == 3) {
            zzkrVar.zza();
        }
        if (zzkdVar == zzkd.SCALAR) {
            int i7 = zzka.zza[zzkrVar.ordinal()];
        }
    }

    public static zzkb[] values() {
        return (zzkb[]) zzba.clone();
    }

    public final int zza() {
        return this.zzbb;
    }
}
