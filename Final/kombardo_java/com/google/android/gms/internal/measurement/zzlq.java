package com.google.android.gms.internal.measurement;

import androidx.appcompat.R$styleable;
import com.sun.jna.Function;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.conscrypt.BuildConfig;
import sun.misc.Unsafe;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzlq<T> implements zzme<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzmz.zzb();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzlm zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final boolean zzj;
    private final int[] zzk;
    private final int zzl;
    private final int zzm;
    private final zzlu zzn;
    private final zzkw zzo;
    private final zzmu<?, ?> zzp;
    private final zzjv<?> zzq;
    private final zzlj zzr;

    private zzlq(int[] iArr, Object[] objArr, int i5, int i6, zzlm zzlmVar, boolean z5, int[] iArr2, int i7, int i8, zzlu zzluVar, zzkw zzkwVar, zzmu<?, ?> zzmuVar, zzjv<?> zzjvVar, zzlj zzljVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i5;
        this.zzf = i6;
        this.zzi = zzlmVar instanceof zzkg;
        this.zzh = zzjvVar != null && zzjvVar.zza(zzlmVar);
        this.zzj = false;
        this.zzk = iArr2;
        this.zzl = i7;
        this.zzm = i8;
        this.zzn = zzluVar;
        this.zzo = zzkwVar;
        this.zzp = zzmuVar;
        this.zzq = zzjvVar;
        this.zzg = zzlmVar;
        this.zzr = zzljVar;
    }

    private static <T> double zza(T t5, long j5) {
        return ((Double) zzmz.zze(t5, j5)).doubleValue();
    }

    private static <T> float zzb(T t5, long j5) {
        return ((Float) zzmz.zze(t5, j5)).floatValue();
    }

    private static <T> int zzc(T t5, long j5) {
        return ((Integer) zzmz.zze(t5, j5)).intValue();
    }

    private static <T> long zzd(T t5, long j5) {
        return ((Long) zzmz.zze(t5, j5)).longValue();
    }

    private final zzme zze(int i5) {
        int i6 = (i5 / 3) << 1;
        zzme zzmeVar = (zzme) this.zzd[i6];
        if (zzmeVar != null) {
            return zzmeVar;
        }
        zzme<T> zza2 = zzma.zza().zza((Class) this.zzd[i6 + 1]);
        this.zzd[i6] = zza2;
        return zza2;
    }

    private final Object zzf(int i5) {
        return this.zzd[(i5 / 3) << 1];
    }

    private static boolean zzg(int i5) {
        return (i5 & 536870912) != 0;
    }

    private final int zzc(int i5) {
        return this.zzc[i5 + 1];
    }

    private final zzkl zzd(int i5) {
        return (zzkl) this.zzd[((i5 / 3) << 1) + 1];
    }

    private static void zzf(Object obj) {
        if (zzg(obj)) {
            return;
        }
        throw new IllegalArgumentException("Mutating immutable message: " + String.valueOf(obj));
    }

    private static boolean zzg(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzkg) {
            return ((zzkg) obj).zzcq();
        }
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:16:0x0058. Please report as an issue. */
    @Override // com.google.android.gms.internal.measurement.zzme
    public final int zza(T t5) {
        int i5;
        int i6;
        int i7;
        int zza2;
        int zza3;
        int zzd;
        boolean z5;
        int zzc;
        int zzd2;
        int zzf;
        int zzg;
        Unsafe unsafe = zzb;
        int i8 = 1048575;
        int i9 = 1048575;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (i11 < this.zzc.length) {
            int zzc2 = zzc(i11);
            int i13 = (267386880 & zzc2) >>> 20;
            int[] iArr = this.zzc;
            int i14 = iArr[i11];
            int i15 = iArr[i11 + 2];
            int i16 = i15 & i8;
            if (i13 <= 17) {
                if (i16 != i9) {
                    i10 = i16 == i8 ? 0 : unsafe.getInt(t5, i16);
                    i9 = i16;
                }
                i5 = i9;
                i6 = i10;
                i7 = 1 << (i15 >>> 20);
            } else {
                i5 = i9;
                i6 = i10;
                i7 = 0;
            }
            long j5 = zzc2 & i8;
            if (i13 >= zzkb.zza.zza()) {
                zzkb.zzb.zza();
            }
            switch (i13) {
                case 0:
                    if (zza((zzlq<T>) t5, i11, i5, i6, i7)) {
                        zza2 = zzjn.zza(i14, 0.0d);
                        i12 += zza2;
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zza((zzlq<T>) t5, i11, i5, i6, i7)) {
                        zza2 = zzjn.zza(i14, 0.0f);
                        i12 += zza2;
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zza((zzlq<T>) t5, i11, i5, i6, i7)) {
                        zza2 = zzjn.zzb(i14, unsafe.getLong(t5, j5));
                        i12 += zza2;
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zza((zzlq<T>) t5, i11, i5, i6, i7)) {
                        zza2 = zzjn.zze(i14, unsafe.getLong(t5, j5));
                        i12 += zza2;
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zza((zzlq<T>) t5, i11, i5, i6, i7)) {
                        zza2 = zzjn.zzc(i14, unsafe.getInt(t5, j5));
                        i12 += zza2;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zza((zzlq<T>) t5, i11, i5, i6, i7)) {
                        zza2 = zzjn.zza(i14, 0L);
                        i12 += zza2;
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zza((zzlq<T>) t5, i11, i5, i6, i7)) {
                        zza2 = zzjn.zzb(i14, 0);
                        i12 += zza2;
                        break;
                    }
                    break;
                case 7:
                    if (zza((zzlq<T>) t5, i11, i5, i6, i7)) {
                        zza3 = zzjn.zza(i14, true);
                        i12 += zza3;
                    }
                    break;
                case 8:
                    if (zza((zzlq<T>) t5, i11, i5, i6, i7)) {
                        Object object = unsafe.getObject(t5, j5);
                        if (object instanceof zziy) {
                            zza3 = zzjn.zza(i14, (zziy) object);
                        } else {
                            zza3 = zzjn.zza(i14, (String) object);
                        }
                        i12 += zza3;
                    }
                    break;
                case 9:
                    if (zza((zzlq<T>) t5, i11, i5, i6, i7)) {
                        zza3 = zzmg.zza(i14, unsafe.getObject(t5, j5), (zzme<?>) zze(i11));
                        i12 += zza3;
                    }
                    break;
                case 10:
                    if (zza((zzlq<T>) t5, i11, i5, i6, i7)) {
                        zza3 = zzjn.zza(i14, (zziy) unsafe.getObject(t5, j5));
                        i12 += zza3;
                    }
                    break;
                case 11:
                    if (zza((zzlq<T>) t5, i11, i5, i6, i7)) {
                        zza3 = zzjn.zzf(i14, unsafe.getInt(t5, j5));
                        i12 += zza3;
                    }
                    break;
                case 12:
                    if (zza((zzlq<T>) t5, i11, i5, i6, i7)) {
                        zza3 = zzjn.zza(i14, unsafe.getInt(t5, j5));
                        i12 += zza3;
                    }
                    break;
                case 13:
                    if (zza((zzlq<T>) t5, i11, i5, i6, i7)) {
                        zzd = zzjn.zzd(i14, 0);
                        i12 += zzd;
                    }
                    break;
                case 14:
                    if (zza((zzlq<T>) t5, i11, i5, i6, i7)) {
                        zza3 = zzjn.zzc(i14, 0L);
                        i12 += zza3;
                    }
                    break;
                case 15:
                    if (zza((zzlq<T>) t5, i11, i5, i6, i7)) {
                        zza3 = zzjn.zze(i14, unsafe.getInt(t5, j5));
                        i12 += zza3;
                    }
                    break;
                case 16:
                    if (zza((zzlq<T>) t5, i11, i5, i6, i7)) {
                        zza3 = zzjn.zzd(i14, unsafe.getLong(t5, j5));
                        i12 += zza3;
                    }
                    break;
                case 17:
                    if (zza((zzlq<T>) t5, i11, i5, i6, i7)) {
                        zza3 = zzjn.zza(i14, (zzlm) unsafe.getObject(t5, j5), zze(i11));
                        i12 += zza3;
                    }
                    break;
                case 18:
                    zza3 = zzmg.zzd(i14, (List) unsafe.getObject(t5, j5), false);
                    i12 += zza3;
                    break;
                case 19:
                    z5 = false;
                    zzc = zzmg.zzc(i14, (List) unsafe.getObject(t5, j5), false);
                    i12 += zzc;
                    break;
                case 20:
                    z5 = false;
                    zzc = zzmg.zzf(i14, (List) unsafe.getObject(t5, j5), false);
                    i12 += zzc;
                    break;
                case 21:
                    z5 = false;
                    zzc = zzmg.zzj(i14, (List) unsafe.getObject(t5, j5), false);
                    i12 += zzc;
                    break;
                case 22:
                    z5 = false;
                    zzc = zzmg.zze(i14, (List) unsafe.getObject(t5, j5), false);
                    i12 += zzc;
                    break;
                case R$styleable.Toolbar_titleMarginBottom /* 23 */:
                    z5 = false;
                    zzc = zzmg.zzd(i14, (List) unsafe.getObject(t5, j5), false);
                    i12 += zzc;
                    break;
                case R$styleable.Toolbar_titleMarginEnd /* 24 */:
                    z5 = false;
                    zzc = zzmg.zzc(i14, (List) unsafe.getObject(t5, j5), false);
                    i12 += zzc;
                    break;
                case 25:
                    z5 = false;
                    zzc = zzmg.zza(i14, (List<?>) unsafe.getObject(t5, j5), false);
                    i12 += zzc;
                    break;
                case 26:
                    zza3 = zzmg.zzb(i14, (List) unsafe.getObject(t5, j5));
                    i12 += zza3;
                    break;
                case 27:
                    zza3 = zzmg.zzb(i14, (List<?>) unsafe.getObject(t5, j5), (zzme<?>) zze(i11));
                    i12 += zza3;
                    break;
                case 28:
                    zza3 = zzmg.zza(i14, (List<zziy>) unsafe.getObject(t5, j5));
                    i12 += zza3;
                    break;
                case R$styleable.Toolbar_titleTextColor /* 29 */:
                    zza3 = zzmg.zzi(i14, (List) unsafe.getObject(t5, j5), false);
                    i12 += zza3;
                    break;
                case 30:
                    z5 = false;
                    zzc = zzmg.zzb(i14, (List<Integer>) unsafe.getObject(t5, j5), false);
                    i12 += zzc;
                    break;
                case 31:
                    z5 = false;
                    zzc = zzmg.zzc(i14, (List) unsafe.getObject(t5, j5), false);
                    i12 += zzc;
                    break;
                case 32:
                    z5 = false;
                    zzc = zzmg.zzd(i14, (List) unsafe.getObject(t5, j5), false);
                    i12 += zzc;
                    break;
                case 33:
                    z5 = false;
                    zzc = zzmg.zzg(i14, (List) unsafe.getObject(t5, j5), false);
                    i12 += zzc;
                    break;
                case 34:
                    z5 = false;
                    zzc = zzmg.zzh(i14, (List) unsafe.getObject(t5, j5), false);
                    i12 += zzc;
                    break;
                case 35:
                    zzd2 = zzmg.zzd((List) unsafe.getObject(t5, j5));
                    if (zzd2 > 0) {
                        zzf = zzjn.zzf(i14);
                        zzg = zzjn.zzg(zzd2);
                        zzd = zzf + zzg + zzd2;
                        i12 += zzd;
                    }
                    break;
                case 36:
                    zzd2 = zzmg.zzc((List) unsafe.getObject(t5, j5));
                    if (zzd2 > 0) {
                        zzf = zzjn.zzf(i14);
                        zzg = zzjn.zzg(zzd2);
                        zzd = zzf + zzg + zzd2;
                        i12 += zzd;
                    }
                    break;
                case 37:
                    zzd2 = zzmg.zzf((List) unsafe.getObject(t5, j5));
                    if (zzd2 > 0) {
                        zzf = zzjn.zzf(i14);
                        zzg = zzjn.zzg(zzd2);
                        zzd = zzf + zzg + zzd2;
                        i12 += zzd;
                    }
                    break;
                case 38:
                    zzd2 = zzmg.zzj((List) unsafe.getObject(t5, j5));
                    if (zzd2 > 0) {
                        zzf = zzjn.zzf(i14);
                        zzg = zzjn.zzg(zzd2);
                        zzd = zzf + zzg + zzd2;
                        i12 += zzd;
                    }
                    break;
                case 39:
                    zzd2 = zzmg.zze((List) unsafe.getObject(t5, j5));
                    if (zzd2 > 0) {
                        zzf = zzjn.zzf(i14);
                        zzg = zzjn.zzg(zzd2);
                        zzd = zzf + zzg + zzd2;
                        i12 += zzd;
                    }
                    break;
                case 40:
                    zzd2 = zzmg.zzd((List) unsafe.getObject(t5, j5));
                    if (zzd2 > 0) {
                        zzf = zzjn.zzf(i14);
                        zzg = zzjn.zzg(zzd2);
                        zzd = zzf + zzg + zzd2;
                        i12 += zzd;
                    }
                    break;
                case 41:
                    zzd2 = zzmg.zzc((List) unsafe.getObject(t5, j5));
                    if (zzd2 > 0) {
                        zzf = zzjn.zzf(i14);
                        zzg = zzjn.zzg(zzd2);
                        zzd = zzf + zzg + zzd2;
                        i12 += zzd;
                    }
                    break;
                case 42:
                    zzd2 = zzmg.zza((List<?>) unsafe.getObject(t5, j5));
                    if (zzd2 > 0) {
                        zzf = zzjn.zzf(i14);
                        zzg = zzjn.zzg(zzd2);
                        zzd = zzf + zzg + zzd2;
                        i12 += zzd;
                    }
                    break;
                case 43:
                    zzd2 = zzmg.zzi((List) unsafe.getObject(t5, j5));
                    if (zzd2 > 0) {
                        zzf = zzjn.zzf(i14);
                        zzg = zzjn.zzg(zzd2);
                        zzd = zzf + zzg + zzd2;
                        i12 += zzd;
                    }
                    break;
                case 44:
                    zzd2 = zzmg.zzb((List) unsafe.getObject(t5, j5));
                    if (zzd2 > 0) {
                        zzf = zzjn.zzf(i14);
                        zzg = zzjn.zzg(zzd2);
                        zzd = zzf + zzg + zzd2;
                        i12 += zzd;
                    }
                    break;
                case 45:
                    zzd2 = zzmg.zzc((List) unsafe.getObject(t5, j5));
                    if (zzd2 > 0) {
                        zzf = zzjn.zzf(i14);
                        zzg = zzjn.zzg(zzd2);
                        zzd = zzf + zzg + zzd2;
                        i12 += zzd;
                    }
                    break;
                case 46:
                    zzd2 = zzmg.zzd((List) unsafe.getObject(t5, j5));
                    if (zzd2 > 0) {
                        zzf = zzjn.zzf(i14);
                        zzg = zzjn.zzg(zzd2);
                        zzd = zzf + zzg + zzd2;
                        i12 += zzd;
                    }
                    break;
                case 47:
                    zzd2 = zzmg.zzg((List) unsafe.getObject(t5, j5));
                    if (zzd2 > 0) {
                        zzf = zzjn.zzf(i14);
                        zzg = zzjn.zzg(zzd2);
                        zzd = zzf + zzg + zzd2;
                        i12 += zzd;
                    }
                    break;
                case 48:
                    zzd2 = zzmg.zzh((List) unsafe.getObject(t5, j5));
                    if (zzd2 > 0) {
                        zzf = zzjn.zzf(i14);
                        zzg = zzjn.zzg(zzd2);
                        zzd = zzf + zzg + zzd2;
                        i12 += zzd;
                    }
                    break;
                case 49:
                    zza3 = zzmg.zza(i14, (List<zzlm>) unsafe.getObject(t5, j5), (zzme<?>) zze(i11));
                    i12 += zza3;
                    break;
                case 50:
                    zza3 = this.zzr.zza(i14, unsafe.getObject(t5, j5), zzf(i11));
                    i12 += zza3;
                    break;
                case 51:
                    if (zzc((zzlq<T>) t5, i14, i11)) {
                        zza3 = zzjn.zza(i14, 0.0d);
                        i12 += zza3;
                    }
                    break;
                case 52:
                    if (zzc((zzlq<T>) t5, i14, i11)) {
                        zza3 = zzjn.zza(i14, 0.0f);
                        i12 += zza3;
                    }
                    break;
                case 53:
                    if (zzc((zzlq<T>) t5, i14, i11)) {
                        zza3 = zzjn.zzb(i14, zzd(t5, j5));
                        i12 += zza3;
                    }
                    break;
                case 54:
                    if (zzc((zzlq<T>) t5, i14, i11)) {
                        zza3 = zzjn.zze(i14, zzd(t5, j5));
                        i12 += zza3;
                    }
                    break;
                case 55:
                    if (zzc((zzlq<T>) t5, i14, i11)) {
                        zza3 = zzjn.zzc(i14, zzc(t5, j5));
                        i12 += zza3;
                    }
                    break;
                case 56:
                    if (zzc((zzlq<T>) t5, i14, i11)) {
                        zza3 = zzjn.zza(i14, 0L);
                        i12 += zza3;
                    }
                    break;
                case 57:
                    if (zzc((zzlq<T>) t5, i14, i11)) {
                        zzd = zzjn.zzb(i14, 0);
                        i12 += zzd;
                    }
                    break;
                case 58:
                    if (zzc((zzlq<T>) t5, i14, i11)) {
                        zza3 = zzjn.zza(i14, true);
                        i12 += zza3;
                    }
                    break;
                case 59:
                    if (zzc((zzlq<T>) t5, i14, i11)) {
                        Object object2 = unsafe.getObject(t5, j5);
                        if (object2 instanceof zziy) {
                            zza3 = zzjn.zza(i14, (zziy) object2);
                        } else {
                            zza3 = zzjn.zza(i14, (String) object2);
                        }
                        i12 += zza3;
                    }
                    break;
                case 60:
                    if (zzc((zzlq<T>) t5, i14, i11)) {
                        zza3 = zzmg.zza(i14, unsafe.getObject(t5, j5), (zzme<?>) zze(i11));
                        i12 += zza3;
                    }
                    break;
                case 61:
                    if (zzc((zzlq<T>) t5, i14, i11)) {
                        zza3 = zzjn.zza(i14, (zziy) unsafe.getObject(t5, j5));
                        i12 += zza3;
                    }
                    break;
                case 62:
                    if (zzc((zzlq<T>) t5, i14, i11)) {
                        zza3 = zzjn.zzf(i14, zzc(t5, j5));
                        i12 += zza3;
                    }
                    break;
                case Function.ALT_CONVENTION /* 63 */:
                    if (zzc((zzlq<T>) t5, i14, i11)) {
                        zza3 = zzjn.zza(i14, zzc(t5, j5));
                        i12 += zza3;
                    }
                    break;
                case Function.THROW_LAST_ERROR /* 64 */:
                    if (zzc((zzlq<T>) t5, i14, i11)) {
                        zzd = zzjn.zzd(i14, 0);
                        i12 += zzd;
                    }
                    break;
                case 65:
                    if (zzc((zzlq<T>) t5, i14, i11)) {
                        zza3 = zzjn.zzc(i14, 0L);
                        i12 += zza3;
                    }
                    break;
                case 66:
                    if (zzc((zzlq<T>) t5, i14, i11)) {
                        zza3 = zzjn.zze(i14, zzc(t5, j5));
                        i12 += zza3;
                    }
                    break;
                case 67:
                    if (zzc((zzlq<T>) t5, i14, i11)) {
                        zza3 = zzjn.zzd(i14, zzd(t5, j5));
                        i12 += zza3;
                    }
                    break;
                case 68:
                    if (zzc((zzlq<T>) t5, i14, i11)) {
                        zza3 = zzjn.zza(i14, (zzlm) unsafe.getObject(t5, j5), zze(i11));
                        i12 += zza3;
                    }
                    break;
            }
            i11 += 3;
            i9 = i5;
            i10 = i6;
            i8 = 1048575;
        }
        int i17 = 0;
        zzmu<?, ?> zzmuVar = this.zzp;
        int zza4 = i12 + zzmuVar.zza(zzmuVar.zzd(t5));
        if (!this.zzh) {
            return zza4;
        }
        zzjw<?> zza5 = this.zzq.zza(t5);
        int zzb2 = zza5.zza.zzb();
        for (int i18 = 0; i18 < zzb2; i18++) {
            Map.Entry<?, Object> zza6 = zza5.zza.zza(i18);
            android.support.v4.media.session.a.a(zza6.getKey());
            i17 += zzjw.zza((zzjy<?>) null, zza6.getValue());
        }
        for (Map.Entry<?, Object> entry : zza5.zza.zzc()) {
            android.support.v4.media.session.a.a(entry.getKey());
            i17 += zzjw.zza((zzjy<?>) null, entry.getValue());
        }
        return zza4 + i17;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x001b. Please report as an issue. */
    @Override // com.google.android.gms.internal.measurement.zzme
    public final int zzb(T t5) {
        int i5;
        int zza2;
        int length = this.zzc.length;
        int i6 = 0;
        for (int i7 = 0; i7 < length; i7 += 3) {
            int zzc = zzc(i7);
            int i8 = this.zzc[i7];
            long j5 = 1048575 & zzc;
            int i9 = 37;
            switch ((zzc & 267386880) >>> 20) {
                case 0:
                    i5 = i6 * 53;
                    zza2 = zzkj.zza(Double.doubleToLongBits(zzmz.zza(t5, j5)));
                    i6 = i5 + zza2;
                    break;
                case 1:
                    i5 = i6 * 53;
                    zza2 = Float.floatToIntBits(zzmz.zzb(t5, j5));
                    i6 = i5 + zza2;
                    break;
                case 2:
                    i5 = i6 * 53;
                    zza2 = zzkj.zza(zzmz.zzd(t5, j5));
                    i6 = i5 + zza2;
                    break;
                case 3:
                    i5 = i6 * 53;
                    zza2 = zzkj.zza(zzmz.zzd(t5, j5));
                    i6 = i5 + zza2;
                    break;
                case 4:
                    i5 = i6 * 53;
                    zza2 = zzmz.zzc(t5, j5);
                    i6 = i5 + zza2;
                    break;
                case 5:
                    i5 = i6 * 53;
                    zza2 = zzkj.zza(zzmz.zzd(t5, j5));
                    i6 = i5 + zza2;
                    break;
                case 6:
                    i5 = i6 * 53;
                    zza2 = zzmz.zzc(t5, j5);
                    i6 = i5 + zza2;
                    break;
                case 7:
                    i5 = i6 * 53;
                    zza2 = zzkj.zza(zzmz.zzh(t5, j5));
                    i6 = i5 + zza2;
                    break;
                case 8:
                    i5 = i6 * 53;
                    zza2 = ((String) zzmz.zze(t5, j5)).hashCode();
                    i6 = i5 + zza2;
                    break;
                case 9:
                    Object zze = zzmz.zze(t5, j5);
                    if (zze != null) {
                        i9 = zze.hashCode();
                    }
                    i6 = (i6 * 53) + i9;
                    break;
                case 10:
                    i5 = i6 * 53;
                    zza2 = zzmz.zze(t5, j5).hashCode();
                    i6 = i5 + zza2;
                    break;
                case 11:
                    i5 = i6 * 53;
                    zza2 = zzmz.zzc(t5, j5);
                    i6 = i5 + zza2;
                    break;
                case 12:
                    i5 = i6 * 53;
                    zza2 = zzmz.zzc(t5, j5);
                    i6 = i5 + zza2;
                    break;
                case 13:
                    i5 = i6 * 53;
                    zza2 = zzmz.zzc(t5, j5);
                    i6 = i5 + zza2;
                    break;
                case 14:
                    i5 = i6 * 53;
                    zza2 = zzkj.zza(zzmz.zzd(t5, j5));
                    i6 = i5 + zza2;
                    break;
                case 15:
                    i5 = i6 * 53;
                    zza2 = zzmz.zzc(t5, j5);
                    i6 = i5 + zza2;
                    break;
                case 16:
                    i5 = i6 * 53;
                    zza2 = zzkj.zza(zzmz.zzd(t5, j5));
                    i6 = i5 + zza2;
                    break;
                case 17:
                    Object zze2 = zzmz.zze(t5, j5);
                    if (zze2 != null) {
                        i9 = zze2.hashCode();
                    }
                    i6 = (i6 * 53) + i9;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case R$styleable.Toolbar_titleMarginBottom /* 23 */:
                case R$styleable.Toolbar_titleMarginEnd /* 24 */:
                case 25:
                case 26:
                case 27:
                case 28:
                case R$styleable.Toolbar_titleTextColor /* 29 */:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i5 = i6 * 53;
                    zza2 = zzmz.zze(t5, j5).hashCode();
                    i6 = i5 + zza2;
                    break;
                case 50:
                    i5 = i6 * 53;
                    zza2 = zzmz.zze(t5, j5).hashCode();
                    i6 = i5 + zza2;
                    break;
                case 51:
                    if (zzc((zzlq<T>) t5, i8, i7)) {
                        i5 = i6 * 53;
                        zza2 = zzkj.zza(Double.doubleToLongBits(zza(t5, j5)));
                        i6 = i5 + zza2;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zzc((zzlq<T>) t5, i8, i7)) {
                        i5 = i6 * 53;
                        zza2 = Float.floatToIntBits(zzb(t5, j5));
                        i6 = i5 + zza2;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zzc((zzlq<T>) t5, i8, i7)) {
                        i5 = i6 * 53;
                        zza2 = zzkj.zza(zzd(t5, j5));
                        i6 = i5 + zza2;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zzc((zzlq<T>) t5, i8, i7)) {
                        i5 = i6 * 53;
                        zza2 = zzkj.zza(zzd(t5, j5));
                        i6 = i5 + zza2;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zzc((zzlq<T>) t5, i8, i7)) {
                        i5 = i6 * 53;
                        zza2 = zzc(t5, j5);
                        i6 = i5 + zza2;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zzc((zzlq<T>) t5, i8, i7)) {
                        i5 = i6 * 53;
                        zza2 = zzkj.zza(zzd(t5, j5));
                        i6 = i5 + zza2;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zzc((zzlq<T>) t5, i8, i7)) {
                        i5 = i6 * 53;
                        zza2 = zzc(t5, j5);
                        i6 = i5 + zza2;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zzc((zzlq<T>) t5, i8, i7)) {
                        i5 = i6 * 53;
                        zza2 = zzkj.zza(zze(t5, j5));
                        i6 = i5 + zza2;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (zzc((zzlq<T>) t5, i8, i7)) {
                        i5 = i6 * 53;
                        zza2 = ((String) zzmz.zze(t5, j5)).hashCode();
                        i6 = i5 + zza2;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (zzc((zzlq<T>) t5, i8, i7)) {
                        i5 = i6 * 53;
                        zza2 = zzmz.zze(t5, j5).hashCode();
                        i6 = i5 + zza2;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zzc((zzlq<T>) t5, i8, i7)) {
                        i5 = i6 * 53;
                        zza2 = zzmz.zze(t5, j5).hashCode();
                        i6 = i5 + zza2;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zzc((zzlq<T>) t5, i8, i7)) {
                        i5 = i6 * 53;
                        zza2 = zzc(t5, j5);
                        i6 = i5 + zza2;
                        break;
                    } else {
                        break;
                    }
                case Function.ALT_CONVENTION /* 63 */:
                    if (zzc((zzlq<T>) t5, i8, i7)) {
                        i5 = i6 * 53;
                        zza2 = zzc(t5, j5);
                        i6 = i5 + zza2;
                        break;
                    } else {
                        break;
                    }
                case Function.THROW_LAST_ERROR /* 64 */:
                    if (zzc((zzlq<T>) t5, i8, i7)) {
                        i5 = i6 * 53;
                        zza2 = zzc(t5, j5);
                        i6 = i5 + zza2;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zzc((zzlq<T>) t5, i8, i7)) {
                        i5 = i6 * 53;
                        zza2 = zzkj.zza(zzd(t5, j5));
                        i6 = i5 + zza2;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zzc((zzlq<T>) t5, i8, i7)) {
                        i5 = i6 * 53;
                        zza2 = zzc(t5, j5);
                        i6 = i5 + zza2;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zzc((zzlq<T>) t5, i8, i7)) {
                        i5 = i6 * 53;
                        zza2 = zzkj.zza(zzd(t5, j5));
                        i6 = i5 + zza2;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zzc((zzlq<T>) t5, i8, i7)) {
                        i5 = i6 * 53;
                        zza2 = zzmz.zze(t5, j5).hashCode();
                        i6 = i5 + zza2;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int hashCode = (i6 * 53) + this.zzp.zzd(t5).hashCode();
        return this.zzh ? (hashCode * 53) + this.zzq.zza(t5).hashCode() : hashCode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzmx zzc(Object obj) {
        zzkg zzkgVar = (zzkg) obj;
        zzmx zzmxVar = zzkgVar.zzb;
        if (zzmxVar != zzmx.zzc()) {
            return zzmxVar;
        }
        zzmx zzd = zzmx.zzd();
        zzkgVar.zzb = zzd;
        return zzd;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.zzme
    public final void zzd(T t5) {
        if (zzg(t5)) {
            if (t5 instanceof zzkg) {
                zzkg zzkgVar = (zzkg) t5;
                zzkgVar.zzc(Integer.MAX_VALUE);
                zzkgVar.zza = 0;
                zzkgVar.zzcp();
            }
            int length = this.zzc.length;
            for (int i5 = 0; i5 < length; i5 += 3) {
                int zzc = zzc(i5);
                long j5 = 1048575 & zzc;
                int i6 = (zzc & 267386880) >>> 20;
                if (i6 != 9) {
                    if (i6 != 60 && i6 != 68) {
                        switch (i6) {
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case R$styleable.Toolbar_titleMarginBottom /* 23 */:
                            case R$styleable.Toolbar_titleMarginEnd /* 24 */:
                            case 25:
                            case 26:
                            case 27:
                            case 28:
                            case R$styleable.Toolbar_titleTextColor /* 29 */:
                            case 30:
                            case 31:
                            case 32:
                            case 33:
                            case 34:
                            case 35:
                            case 36:
                            case 37:
                            case 38:
                            case 39:
                            case 40:
                            case 41:
                            case 42:
                            case 43:
                            case 44:
                            case 45:
                            case 46:
                            case 47:
                            case 48:
                            case 49:
                                this.zzo.zzb(t5, j5);
                                break;
                            case 50:
                                Unsafe unsafe = zzb;
                                Object object = unsafe.getObject(t5, j5);
                                if (object != null) {
                                    unsafe.putObject(t5, j5, this.zzr.zzc(object));
                                    break;
                                } else {
                                    break;
                                }
                        }
                    } else if (zzc((zzlq<T>) t5, this.zzc[i5], i5)) {
                        zze(i5).zzd(zzb.getObject(t5, j5));
                    }
                }
                if (zzc((zzlq<T>) t5, i5)) {
                    zze(i5).zzd(zzb.getObject(t5, j5));
                }
            }
            this.zzp.zzf(t5);
            if (this.zzh) {
                this.zzq.zzc(t5);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.zzme
    public final boolean zze(T t5) {
        int i5;
        int i6;
        int i7 = 1048575;
        int i8 = 0;
        int i9 = 0;
        while (i9 < this.zzl) {
            int i10 = this.zzk[i9];
            int i11 = this.zzc[i10];
            int zzc = zzc(i10);
            int i12 = this.zzc[i10 + 2];
            int i13 = i12 & 1048575;
            int i14 = 1 << (i12 >>> 20);
            if (i13 != i7) {
                if (i13 != 1048575) {
                    i8 = zzb.getInt(t5, i13);
                }
                i6 = i8;
                i5 = i13;
            } else {
                i5 = i7;
                i6 = i8;
            }
            if ((268435456 & zzc) != 0 && !zza((zzlq<T>) t5, i10, i5, i6, i14)) {
                return false;
            }
            int i15 = (267386880 & zzc) >>> 20;
            if (i15 != 9 && i15 != 17) {
                if (i15 != 27) {
                    if (i15 == 60 || i15 == 68) {
                        if (zzc((zzlq<T>) t5, i11, i10) && !zza((Object) t5, zzc, zze(i10))) {
                            return false;
                        }
                    } else if (i15 != 49) {
                        if (i15 == 50 && !this.zzr.zzd(zzmz.zze(t5, zzc & 1048575)).isEmpty()) {
                            this.zzr.zza(zzf(i10));
                            throw null;
                        }
                    }
                }
                List list = (List) zzmz.zze(t5, zzc & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zzme zze = zze(i10);
                    for (int i16 = 0; i16 < list.size(); i16++) {
                        if (!zze.zze(list.get(i16))) {
                            return false;
                        }
                    }
                }
            } else if (zza((zzlq<T>) t5, i10, i5, i6, i14) && !zza((Object) t5, zzc, zze(i10))) {
                return false;
            }
            i9++;
            i7 = i5;
            i8 = i6;
        }
        return !this.zzh || this.zzq.zza(t5).zzg();
    }

    private final boolean zzc(T t5, T t6, int i5) {
        return zzc((zzlq<T>) t5, i5) == zzc((zzlq<T>) t6, i5);
    }

    private final boolean zzc(T t5, int i5) {
        int zzb2 = zzb(i5);
        long j5 = zzb2 & 1048575;
        if (j5 != 1048575) {
            return (zzmz.zzc(t5, j5) & (1 << (zzb2 >>> 20))) != 0;
        }
        int zzc = zzc(i5);
        long j6 = zzc & 1048575;
        switch ((zzc & 267386880) >>> 20) {
            case 0:
                return Double.doubleToRawLongBits(zzmz.zza(t5, j6)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzmz.zzb(t5, j6)) != 0;
            case 2:
                return zzmz.zzd(t5, j6) != 0;
            case 3:
                return zzmz.zzd(t5, j6) != 0;
            case 4:
                return zzmz.zzc(t5, j6) != 0;
            case 5:
                return zzmz.zzd(t5, j6) != 0;
            case 6:
                return zzmz.zzc(t5, j6) != 0;
            case 7:
                return zzmz.zzh(t5, j6);
            case 8:
                Object zze = zzmz.zze(t5, j6);
                if (zze instanceof String) {
                    return !((String) zze).isEmpty();
                }
                if (zze instanceof zziy) {
                    return !zziy.zza.equals(zze);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzmz.zze(t5, j6) != null;
            case 10:
                return !zziy.zza.equals(zzmz.zze(t5, j6));
            case 11:
                return zzmz.zzc(t5, j6) != 0;
            case 12:
                return zzmz.zzc(t5, j6) != 0;
            case 13:
                return zzmz.zzc(t5, j6) != 0;
            case 14:
                return zzmz.zzd(t5, j6) != 0;
            case 15:
                return zzmz.zzc(t5, j6) != 0;
            case 16:
                return zzmz.zzd(t5, j6) != 0;
            case 17:
                return zzmz.zze(t5, j6) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private static <T> boolean zze(T t5, long j5) {
        return ((Boolean) zzmz.zze(t5, j5)).booleanValue();
    }

    private final boolean zzc(T t5, int i5, int i6) {
        return zzmz.zzc(t5, (long) (zzb(i6) & 1048575)) == i5;
    }

    private final int zzb(int i5) {
        return this.zzc[i5 + 2];
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void zzb(T t5, T t6, int i5) {
        int i6 = this.zzc[i5];
        if (zzc((zzlq<T>) t6, i6, i5)) {
            long zzc = zzc(i5) & 1048575;
            Unsafe unsafe = zzb;
            Object object = unsafe.getObject(t6, zzc);
            if (object != null) {
                zzme zze = zze(i5);
                if (!zzc((zzlq<T>) t5, i6, i5)) {
                    if (!zzg(object)) {
                        unsafe.putObject(t5, zzc, object);
                    } else {
                        Object zza2 = zze.zza();
                        zze.zza(zza2, object);
                        unsafe.putObject(t5, zzc, zza2);
                    }
                    zzb((zzlq<T>) t5, i6, i5);
                    return;
                }
                Object object2 = unsafe.getObject(t5, zzc);
                if (!zzg(object2)) {
                    Object zza3 = zze.zza();
                    zze.zza(zza3, object2);
                    unsafe.putObject(t5, zzc, zza3);
                    object2 = zza3;
                }
                zze.zza(object2, object);
                return;
            }
            throw new IllegalStateException("Source subfield " + this.zzc[i5] + " is present but null: " + String.valueOf(t6));
        }
    }

    private final void zzb(T t5, int i5) {
        int zzb2 = zzb(i5);
        long j5 = 1048575 & zzb2;
        if (j5 == 1048575) {
            return;
        }
        zzmz.zza((Object) t5, j5, (1 << (zzb2 >>> 20)) | zzmz.zzc(t5, j5));
    }

    private final void zzb(T t5, int i5, int i6) {
        zzmz.zza((Object) t5, zzb(i6) & 1048575, i5);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x006b, code lost:
    
        if (com.google.android.gms.internal.measurement.zzmg.zza(com.google.android.gms.internal.measurement.zzmz.zze(r10, r6), com.google.android.gms.internal.measurement.zzmz.zze(r11, r6)) != false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x007e, code lost:
    
        if (com.google.android.gms.internal.measurement.zzmz.zzd(r10, r6) == com.google.android.gms.internal.measurement.zzmz.zzd(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x008f, code lost:
    
        if (com.google.android.gms.internal.measurement.zzmz.zzc(r10, r6) == com.google.android.gms.internal.measurement.zzmz.zzc(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00a2, code lost:
    
        if (com.google.android.gms.internal.measurement.zzmz.zzd(r10, r6) == com.google.android.gms.internal.measurement.zzmz.zzd(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00b3, code lost:
    
        if (com.google.android.gms.internal.measurement.zzmz.zzc(r10, r6) == com.google.android.gms.internal.measurement.zzmz.zzc(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00c4, code lost:
    
        if (com.google.android.gms.internal.measurement.zzmz.zzc(r10, r6) == com.google.android.gms.internal.measurement.zzmz.zzc(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00d6, code lost:
    
        if (com.google.android.gms.internal.measurement.zzmz.zzc(r10, r6) == com.google.android.gms.internal.measurement.zzmz.zzc(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00ec, code lost:
    
        if (com.google.android.gms.internal.measurement.zzmg.zza(com.google.android.gms.internal.measurement.zzmz.zze(r10, r6), com.google.android.gms.internal.measurement.zzmz.zze(r11, r6)) != false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0102, code lost:
    
        if (com.google.android.gms.internal.measurement.zzmg.zza(com.google.android.gms.internal.measurement.zzmz.zze(r10, r6), com.google.android.gms.internal.measurement.zzmz.zze(r11, r6)) != false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0118, code lost:
    
        if (com.google.android.gms.internal.measurement.zzmg.zza(com.google.android.gms.internal.measurement.zzmz.zze(r10, r6), com.google.android.gms.internal.measurement.zzmz.zze(r11, r6)) != false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x012a, code lost:
    
        if (com.google.android.gms.internal.measurement.zzmz.zzh(r10, r6) == com.google.android.gms.internal.measurement.zzmz.zzh(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x013c, code lost:
    
        if (com.google.android.gms.internal.measurement.zzmz.zzc(r10, r6) == com.google.android.gms.internal.measurement.zzmz.zzc(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0150, code lost:
    
        if (com.google.android.gms.internal.measurement.zzmz.zzd(r10, r6) == com.google.android.gms.internal.measurement.zzmz.zzd(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0162, code lost:
    
        if (com.google.android.gms.internal.measurement.zzmz.zzc(r10, r6) == com.google.android.gms.internal.measurement.zzmz.zzc(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0176, code lost:
    
        if (com.google.android.gms.internal.measurement.zzmz.zzd(r10, r6) == com.google.android.gms.internal.measurement.zzmz.zzd(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x018a, code lost:
    
        if (com.google.android.gms.internal.measurement.zzmz.zzd(r10, r6) == com.google.android.gms.internal.measurement.zzmz.zzd(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01a4, code lost:
    
        if (java.lang.Float.floatToIntBits(com.google.android.gms.internal.measurement.zzmz.zzb(r10, r6)) == java.lang.Float.floatToIntBits(com.google.android.gms.internal.measurement.zzmz.zzb(r11, r6))) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01c0, code lost:
    
        if (java.lang.Double.doubleToLongBits(com.google.android.gms.internal.measurement.zzmz.zza(r10, r6)) == java.lang.Double.doubleToLongBits(com.google.android.gms.internal.measurement.zzmz.zza(r11, r6))) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0038, code lost:
    
        if (com.google.android.gms.internal.measurement.zzmg.zza(com.google.android.gms.internal.measurement.zzmz.zze(r10, r6), com.google.android.gms.internal.measurement.zzmz.zze(r11, r6)) != false) goto L105;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0017. Please report as an issue. */
    @Override // com.google.android.gms.internal.measurement.zzme
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean zzb(T t5, T t6) {
        int length = this.zzc.length;
        int i5 = 0;
        while (true) {
            boolean z5 = true;
            if (i5 < length) {
                int zzc = zzc(i5);
                long j5 = zzc & 1048575;
                switch ((zzc & 267386880) >>> 20) {
                    case 0:
                        if (zzc(t5, t6, i5)) {
                            break;
                        }
                        z5 = false;
                        break;
                    case 1:
                        if (zzc(t5, t6, i5)) {
                            break;
                        }
                        z5 = false;
                        break;
                    case 2:
                        if (zzc(t5, t6, i5)) {
                            break;
                        }
                        z5 = false;
                        break;
                    case 3:
                        if (zzc(t5, t6, i5)) {
                            break;
                        }
                        z5 = false;
                        break;
                    case 4:
                        if (zzc(t5, t6, i5)) {
                            break;
                        }
                        z5 = false;
                        break;
                    case 5:
                        if (zzc(t5, t6, i5)) {
                            break;
                        }
                        z5 = false;
                        break;
                    case 6:
                        if (zzc(t5, t6, i5)) {
                            break;
                        }
                        z5 = false;
                        break;
                    case 7:
                        if (zzc(t5, t6, i5)) {
                            break;
                        }
                        z5 = false;
                        break;
                    case 8:
                        if (zzc(t5, t6, i5)) {
                            break;
                        }
                        z5 = false;
                        break;
                    case 9:
                        if (zzc(t5, t6, i5)) {
                            break;
                        }
                        z5 = false;
                        break;
                    case 10:
                        if (zzc(t5, t6, i5)) {
                            break;
                        }
                        z5 = false;
                        break;
                    case 11:
                        if (zzc(t5, t6, i5)) {
                            break;
                        }
                        z5 = false;
                        break;
                    case 12:
                        if (zzc(t5, t6, i5)) {
                            break;
                        }
                        z5 = false;
                        break;
                    case 13:
                        if (zzc(t5, t6, i5)) {
                            break;
                        }
                        z5 = false;
                        break;
                    case 14:
                        if (zzc(t5, t6, i5)) {
                            break;
                        }
                        z5 = false;
                        break;
                    case 15:
                        if (zzc(t5, t6, i5)) {
                            break;
                        }
                        z5 = false;
                        break;
                    case 16:
                        if (zzc(t5, t6, i5)) {
                            break;
                        }
                        z5 = false;
                        break;
                    case 17:
                        if (zzc(t5, t6, i5)) {
                            break;
                        }
                        z5 = false;
                        break;
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case R$styleable.Toolbar_titleMarginBottom /* 23 */:
                    case R$styleable.Toolbar_titleMarginEnd /* 24 */:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case R$styleable.Toolbar_titleTextColor /* 29 */:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                        z5 = zzmg.zza(zzmz.zze(t5, j5), zzmz.zze(t6, j5));
                        break;
                    case 50:
                        z5 = zzmg.zza(zzmz.zze(t5, j5), zzmz.zze(t6, j5));
                        break;
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                    case 60:
                    case 61:
                    case 62:
                    case Function.ALT_CONVENTION /* 63 */:
                    case Function.THROW_LAST_ERROR /* 64 */:
                    case 65:
                    case 66:
                    case 67:
                    case 68:
                        long zzb2 = zzb(i5) & 1048575;
                        if (zzmz.zzc(t5, zzb2) == zzmz.zzc(t6, zzb2)) {
                            break;
                        }
                        z5 = false;
                        break;
                }
                if (!z5) {
                    return false;
                }
                i5 += 3;
            } else {
                if (!this.zzp.zzd(t5).equals(this.zzp.zzd(t6))) {
                    return false;
                }
                if (this.zzh) {
                    return this.zzq.zza(t5).equals(this.zzq.zza(t6));
                }
                return true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Failed to find 'out' block for switch in B:27:0x0423. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:421:0x09cb. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:523:0x00af. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0951 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0941 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:425:0x0bef  */
    /* JADX WARN: Removed duplicated region for block: B:426:0x0c70 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int zza(T t5, byte[] bArr, int i5, int i6, int i7, zzit zzitVar) {
        int i8;
        int i9;
        Unsafe unsafe;
        int i10;
        int i11;
        int i12;
        int i13;
        int zza2;
        zzit zzitVar2;
        Unsafe unsafe2;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        zzit zzitVar3;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        Unsafe unsafe3;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        int i29;
        int i30;
        zzit zzitVar4;
        int i31;
        int i32;
        int i33;
        int zzd;
        zzit zzitVar5;
        int i34;
        int i35;
        Unsafe unsafe4;
        zzkm zzkmVar;
        int i36;
        zzit zzitVar6;
        int i37;
        int i38;
        Unsafe unsafe5;
        int i39;
        int i40;
        int i41;
        int i42;
        Unsafe unsafe6;
        int i43;
        int i44;
        int i45;
        int i46;
        zzit zzitVar7;
        int i47;
        int i48;
        Unsafe unsafe7;
        zzkm zzkmVar2;
        int i49;
        zzit zzitVar8;
        int i50;
        int i51;
        zzit zzitVar9;
        zzkm zzkmVar3;
        int zza3;
        T t6 = t5;
        byte[] bArr2 = bArr;
        int i52 = i6;
        int i53 = i7;
        zzit zzitVar10 = zzitVar;
        zzf(t5);
        Unsafe unsafe8 = zzb;
        int i54 = i5;
        int i55 = 0;
        int i56 = 0;
        int i57 = 0;
        int i58 = -1;
        int i59 = 1048575;
        while (true) {
            if (i54 < i52) {
                int i60 = i54 + 1;
                byte b5 = bArr2[i54];
                if (b5 < 0) {
                    int zza4 = zziu.zza(b5, bArr2, i60, zzitVar10);
                    i13 = zzitVar10.zza;
                    i60 = zza4;
                } else {
                    i13 = b5;
                }
                int i61 = i13 >>> 3;
                int i62 = i13 & 7;
                if (i61 > i58) {
                    zza2 = (i61 < this.zze || i61 > this.zzf) ? -1 : zza(i61, i55 / 3);
                } else {
                    zza2 = zza(i61);
                }
                int i63 = zza2;
                if (i63 == -1) {
                    zzitVar2 = zzitVar10;
                    unsafe2 = unsafe8;
                    i14 = i61;
                    i15 = i60;
                    i56 = i13;
                    i16 = i57;
                    i17 = i59;
                    i18 = 0;
                } else {
                    int[] iArr = this.zzc;
                    int i64 = iArr[i63 + 1];
                    int i65 = (i64 & 267386880) >>> 20;
                    int i66 = i60;
                    int i67 = i13;
                    long j5 = i64 & 1048575;
                    if (i65 <= 17) {
                        int i68 = iArr[i63 + 2];
                        int i69 = 1 << (i68 >>> 20);
                        int i70 = 1048575;
                        int i71 = i68 & 1048575;
                        if (i71 != i59) {
                            if (i59 != 1048575) {
                                unsafe8.putInt(t6, i59, i57);
                                i70 = 1048575;
                            }
                            i17 = i71;
                            i16 = i71 == i70 ? 0 : unsafe8.getInt(t6, i71);
                        } else {
                            i16 = i57;
                            i17 = i59;
                        }
                        switch (i65) {
                            case 0:
                                i21 = i6;
                                i53 = i7;
                                zzitVar3 = zzitVar10;
                                i19 = i63;
                                i20 = i66;
                                i22 = i67;
                                i23 = i61;
                                unsafe3 = unsafe8;
                                if (i62 == 1) {
                                    zzmz.zza(t6, j5, zziu.zza(bArr2, i20));
                                    i24 = i20 + 8;
                                    i27 = i16 | i69;
                                    unsafe8 = unsafe3;
                                    i52 = i21;
                                    i55 = i19;
                                    zzitVar10 = zzitVar3;
                                    i58 = i23;
                                    i56 = i22;
                                    i59 = i17;
                                    i54 = i24;
                                    i57 = i27;
                                    break;
                                } else {
                                    unsafe2 = unsafe3;
                                    i15 = i20;
                                    zzitVar2 = zzitVar3;
                                    i14 = i23;
                                    i56 = i22;
                                    i18 = i19;
                                    break;
                                }
                            case 1:
                                i21 = i6;
                                i53 = i7;
                                zzitVar3 = zzitVar10;
                                i19 = i63;
                                i20 = i66;
                                i22 = i67;
                                i23 = i61;
                                unsafe3 = unsafe8;
                                if (i62 == 5) {
                                    zzmz.zza((Object) t6, j5, zziu.zzb(bArr2, i20));
                                    i24 = i20 + 4;
                                    i27 = i16 | i69;
                                    unsafe8 = unsafe3;
                                    i52 = i21;
                                    i55 = i19;
                                    zzitVar10 = zzitVar3;
                                    i58 = i23;
                                    i56 = i22;
                                    i59 = i17;
                                    i54 = i24;
                                    i57 = i27;
                                    break;
                                } else {
                                    unsafe2 = unsafe3;
                                    i15 = i20;
                                    zzitVar2 = zzitVar3;
                                    i14 = i23;
                                    i56 = i22;
                                    i18 = i19;
                                    break;
                                }
                            case 2:
                            case 3:
                                i25 = i7;
                                zzitVar3 = zzitVar10;
                                i19 = i63;
                                i20 = i66;
                                i22 = i67;
                                i23 = i61;
                                unsafe3 = unsafe8;
                                if (i62 == 0) {
                                    int zzd2 = zziu.zzd(bArr2, i20, zzitVar3);
                                    unsafe3.putLong(t5, j5, zzitVar3.zzb);
                                    i26 = i16 | i69;
                                    unsafe8 = unsafe3;
                                    i52 = i6;
                                    i54 = zzd2;
                                    i53 = i25;
                                    i55 = i19;
                                    zzitVar10 = zzitVar3;
                                    i58 = i23;
                                    i56 = i22;
                                    i59 = i17;
                                    i57 = i26;
                                    break;
                                } else {
                                    i53 = i25;
                                    unsafe2 = unsafe3;
                                    i15 = i20;
                                    zzitVar2 = zzitVar3;
                                    i14 = i23;
                                    i56 = i22;
                                    i18 = i19;
                                    break;
                                }
                            case 4:
                            case 11:
                                i21 = i6;
                                i25 = i7;
                                zzitVar3 = zzitVar10;
                                i19 = i63;
                                i20 = i66;
                                i22 = i67;
                                i23 = i61;
                                unsafe3 = unsafe8;
                                if (i62 == 0) {
                                    i24 = zziu.zzc(bArr2, i20, zzitVar3);
                                    unsafe3.putInt(t6, j5, zzitVar3.zza);
                                    i27 = i16 | i69;
                                    i53 = i25;
                                    unsafe8 = unsafe3;
                                    i52 = i21;
                                    i55 = i19;
                                    zzitVar10 = zzitVar3;
                                    i58 = i23;
                                    i56 = i22;
                                    i59 = i17;
                                    i54 = i24;
                                    i57 = i27;
                                    break;
                                } else {
                                    i53 = i25;
                                    unsafe2 = unsafe3;
                                    i15 = i20;
                                    zzitVar2 = zzitVar3;
                                    i14 = i23;
                                    i56 = i22;
                                    i18 = i19;
                                    break;
                                }
                            case 5:
                            case 14:
                                i25 = i7;
                                zzitVar3 = zzitVar10;
                                i19 = i63;
                                i20 = i66;
                                i22 = i67;
                                i23 = i61;
                                unsafe3 = unsafe8;
                                if (i62 == 1) {
                                    unsafe3.putLong(t5, j5, zziu.zzd(bArr2, i20));
                                    i24 = i20 + 8;
                                    i27 = i16 | i69;
                                    unsafe8 = unsafe3;
                                    i52 = i6;
                                    i53 = i25;
                                    i55 = i19;
                                    zzitVar10 = zzitVar3;
                                    i58 = i23;
                                    i56 = i22;
                                    i59 = i17;
                                    i54 = i24;
                                    i57 = i27;
                                    break;
                                } else {
                                    i53 = i25;
                                    unsafe2 = unsafe3;
                                    i15 = i20;
                                    zzitVar2 = zzitVar3;
                                    i14 = i23;
                                    i56 = i22;
                                    i18 = i19;
                                    break;
                                }
                            case 6:
                            case 13:
                                i21 = i6;
                                i25 = i7;
                                zzitVar3 = zzitVar10;
                                i19 = i63;
                                i20 = i66;
                                i22 = i67;
                                i23 = i61;
                                unsafe3 = unsafe8;
                                if (i62 == 5) {
                                    unsafe3.putInt(t6, j5, zziu.zzc(bArr2, i20));
                                    i24 = i20 + 4;
                                    i27 = i16 | i69;
                                    i53 = i25;
                                    unsafe8 = unsafe3;
                                    i52 = i21;
                                    i55 = i19;
                                    zzitVar10 = zzitVar3;
                                    i58 = i23;
                                    i56 = i22;
                                    i59 = i17;
                                    i54 = i24;
                                    i57 = i27;
                                    break;
                                } else {
                                    i53 = i25;
                                    unsafe2 = unsafe3;
                                    i15 = i20;
                                    zzitVar2 = zzitVar3;
                                    i14 = i23;
                                    i56 = i22;
                                    i18 = i19;
                                    break;
                                }
                            case 7:
                                i21 = i6;
                                i25 = i7;
                                zzitVar3 = zzitVar10;
                                i19 = i63;
                                i20 = i66;
                                i22 = i67;
                                i23 = i61;
                                unsafe3 = unsafe8;
                                if (i62 == 0) {
                                    i24 = zziu.zzd(bArr2, i20, zzitVar3);
                                    zzmz.zzc(t6, j5, zzitVar3.zzb != 0);
                                    i27 = i16 | i69;
                                    i53 = i25;
                                    unsafe8 = unsafe3;
                                    i52 = i21;
                                    i55 = i19;
                                    zzitVar10 = zzitVar3;
                                    i58 = i23;
                                    i56 = i22;
                                    i59 = i17;
                                    i54 = i24;
                                    i57 = i27;
                                    break;
                                } else {
                                    i53 = i25;
                                    unsafe2 = unsafe3;
                                    i15 = i20;
                                    zzitVar2 = zzitVar3;
                                    i14 = i23;
                                    i56 = i22;
                                    i18 = i19;
                                    break;
                                }
                            case 8:
                                i21 = i6;
                                i25 = i7;
                                zzitVar3 = zzitVar10;
                                i19 = i63;
                                i20 = i66;
                                i22 = i67;
                                i23 = i61;
                                unsafe3 = unsafe8;
                                if (i62 == 2) {
                                    if (zzg(i64)) {
                                        i24 = zziu.zzb(bArr2, i20, zzitVar3);
                                    } else {
                                        i24 = zziu.zzc(bArr2, i20, zzitVar3);
                                        int i72 = zzitVar3.zza;
                                        if (i72 < 0) {
                                            throw zzkp.zzf();
                                        }
                                        if (i72 == 0) {
                                            zzitVar3.zzc = BuildConfig.FLAVOR;
                                        } else {
                                            zzitVar3.zzc = new String(bArr2, i24, i72, zzkj.zza);
                                            i24 += i72;
                                        }
                                    }
                                    unsafe3.putObject(t6, j5, zzitVar3.zzc);
                                    i27 = i16 | i69;
                                    i53 = i25;
                                    unsafe8 = unsafe3;
                                    i52 = i21;
                                    i55 = i19;
                                    zzitVar10 = zzitVar3;
                                    i58 = i23;
                                    i56 = i22;
                                    i59 = i17;
                                    i54 = i24;
                                    i57 = i27;
                                    break;
                                } else {
                                    i53 = i25;
                                    unsafe2 = unsafe3;
                                    i15 = i20;
                                    zzitVar2 = zzitVar3;
                                    i14 = i23;
                                    i56 = i22;
                                    i18 = i19;
                                    break;
                                }
                            case 9:
                                i53 = i7;
                                zzitVar3 = zzitVar10;
                                i19 = i63;
                                i28 = i67;
                                i20 = i66;
                                i23 = i61;
                                unsafe3 = unsafe8;
                                if (i62 == 2) {
                                    Object zza5 = zza((zzlq<T>) t6, i19);
                                    i22 = i28;
                                    i24 = zziu.zza(zza5, zze(i19), bArr, i20, i6, zzitVar);
                                    zza((zzlq<T>) t6, i19, zza5);
                                    i27 = i16 | i69;
                                    unsafe8 = unsafe3;
                                    i52 = i6;
                                    i53 = i53;
                                    i55 = i19;
                                    zzitVar10 = zzitVar3;
                                    i58 = i23;
                                    i56 = i22;
                                    i59 = i17;
                                    i54 = i24;
                                    i57 = i27;
                                    break;
                                } else {
                                    i22 = i28;
                                    unsafe2 = unsafe3;
                                    i15 = i20;
                                    zzitVar2 = zzitVar3;
                                    i14 = i23;
                                    i56 = i22;
                                    i18 = i19;
                                    break;
                                }
                            case 10:
                                i53 = i7;
                                zzitVar3 = zzitVar10;
                                i19 = i63;
                                i28 = i67;
                                i20 = i66;
                                i23 = i61;
                                unsafe3 = unsafe8;
                                if (i62 == 2) {
                                    i24 = zziu.zza(bArr2, i20, zzitVar3);
                                    unsafe3.putObject(t6, j5, zzitVar3.zzc);
                                    i27 = i16 | i69;
                                    i56 = i28;
                                    unsafe8 = unsafe3;
                                    i52 = i6;
                                    i55 = i19;
                                    zzitVar10 = zzitVar3;
                                    i58 = i23;
                                    i59 = i17;
                                    i54 = i24;
                                    i57 = i27;
                                    break;
                                } else {
                                    i22 = i28;
                                    unsafe2 = unsafe3;
                                    i15 = i20;
                                    zzitVar2 = zzitVar3;
                                    i14 = i23;
                                    i56 = i22;
                                    i18 = i19;
                                    break;
                                }
                            case 12:
                                i53 = i7;
                                zzitVar3 = zzitVar10;
                                i19 = i63;
                                i20 = i66;
                                i22 = i67;
                                i23 = i61;
                                unsafe3 = unsafe8;
                                if (i62 == 0) {
                                    int zzc = zziu.zzc(bArr2, i20, zzitVar3);
                                    int i73 = zzitVar3.zza;
                                    zzkl zzd3 = zzd(i19);
                                    if ((i64 & Integer.MIN_VALUE) != 0 && zzd3 != null && !zzd3.zza(i73)) {
                                        zzc(t5).zza(i22, Long.valueOf(i73));
                                        i56 = i22;
                                        unsafe8 = unsafe3;
                                        i52 = i6;
                                        i55 = i19;
                                        zzitVar10 = zzitVar3;
                                        i58 = i23;
                                        i57 = i16;
                                        i59 = i17;
                                    } else {
                                        unsafe3.putInt(t6, j5, i73);
                                        i56 = i22;
                                        unsafe8 = unsafe3;
                                        i52 = i6;
                                        i55 = i19;
                                        zzitVar10 = zzitVar3;
                                        i58 = i23;
                                        i59 = i17;
                                        i57 = i16 | i69;
                                    }
                                    i54 = zzc;
                                    break;
                                } else {
                                    unsafe2 = unsafe3;
                                    i15 = i20;
                                    zzitVar2 = zzitVar3;
                                    i14 = i23;
                                    i56 = i22;
                                    i18 = i19;
                                    break;
                                }
                            case 15:
                                i21 = i6;
                                i53 = i7;
                                zzitVar3 = zzitVar10;
                                i19 = i63;
                                i20 = i66;
                                i22 = i67;
                                i23 = i61;
                                unsafe3 = unsafe8;
                                if (i62 == 0) {
                                    i24 = zziu.zzc(bArr2, i20, zzitVar3);
                                    unsafe3.putInt(t6, j5, zzjk.zze(zzitVar3.zza));
                                    i27 = i16 | i69;
                                    unsafe8 = unsafe3;
                                    i52 = i21;
                                    i55 = i19;
                                    zzitVar10 = zzitVar3;
                                    i58 = i23;
                                    i56 = i22;
                                    i59 = i17;
                                    i54 = i24;
                                    i57 = i27;
                                    break;
                                } else {
                                    unsafe2 = unsafe3;
                                    i15 = i20;
                                    zzitVar2 = zzitVar3;
                                    i14 = i23;
                                    i56 = i22;
                                    i18 = i19;
                                    break;
                                }
                            case 16:
                                if (i62 == 0) {
                                    int zzd4 = zziu.zzd(bArr2, i66, zzitVar10);
                                    unsafe8.putLong(t5, j5, zzjk.zza(zzitVar10.zzb));
                                    i26 = i16 | i69;
                                    unsafe8 = unsafe8;
                                    i52 = i6;
                                    i53 = i7;
                                    i55 = i63;
                                    zzitVar10 = zzitVar10;
                                    i58 = i61;
                                    i56 = i67;
                                    i59 = i17;
                                    i54 = zzd4;
                                    i57 = i26;
                                    break;
                                } else {
                                    zzitVar3 = zzitVar10;
                                    unsafe3 = unsafe8;
                                    i19 = i63;
                                    i23 = i61;
                                    i20 = i66;
                                    i53 = i7;
                                    i22 = i67;
                                    unsafe2 = unsafe3;
                                    i15 = i20;
                                    zzitVar2 = zzitVar3;
                                    i14 = i23;
                                    i56 = i22;
                                    i18 = i19;
                                    break;
                                }
                            case 17:
                                if (i62 == 3) {
                                    Object zza6 = zza((zzlq<T>) t6, i63);
                                    i54 = zziu.zza(zza6, zze(i63), bArr, i66, i6, (i61 << 3) | 4, zzitVar);
                                    zza((zzlq<T>) t6, i63, zza6);
                                    i57 = i16 | i69;
                                    i56 = i67;
                                    i55 = i63;
                                    i58 = i61;
                                    i59 = i17;
                                    i52 = i6;
                                    i53 = i7;
                                    break;
                                } else {
                                    i53 = i7;
                                    zzitVar3 = zzitVar10;
                                    i19 = i63;
                                    i20 = i66;
                                    i22 = i67;
                                    i23 = i61;
                                    unsafe3 = unsafe8;
                                    unsafe2 = unsafe3;
                                    i15 = i20;
                                    zzitVar2 = zzitVar3;
                                    i14 = i23;
                                    i56 = i22;
                                    i18 = i19;
                                    break;
                                }
                            default:
                                i53 = i7;
                                zzitVar3 = zzitVar10;
                                i19 = i63;
                                i20 = i66;
                                i22 = i67;
                                i23 = i61;
                                unsafe3 = unsafe8;
                                unsafe2 = unsafe3;
                                i15 = i20;
                                zzitVar2 = zzitVar3;
                                i14 = i23;
                                i56 = i22;
                                i18 = i19;
                                break;
                        }
                    } else {
                        i16 = i57;
                        i17 = i59;
                        zzit zzitVar11 = zzitVar10;
                        int i74 = i67;
                        Unsafe unsafe9 = unsafe8;
                        if (i65 != 27) {
                            if (i65 <= 49) {
                                long j6 = i64;
                                Unsafe unsafe10 = zzb;
                                zzkm zzkmVar4 = (zzkm) unsafe10.getObject(t6, j5);
                                if (zzkmVar4.zzc()) {
                                    unsafe4 = unsafe9;
                                    zzkmVar = zzkmVar4;
                                } else {
                                    unsafe4 = unsafe9;
                                    zzkmVar = zzkmVar4.zza(zzkmVar4.size() << 1);
                                    unsafe10.putObject(t6, j5, zzkmVar);
                                }
                                switch (i65) {
                                    case 18:
                                    case 35:
                                        i36 = i7;
                                        i55 = i63;
                                        zzitVar6 = zzitVar11;
                                        i37 = i66;
                                        i38 = i74;
                                        unsafe5 = unsafe4;
                                        i39 = i6;
                                        if (i62 != 2) {
                                            if (i62 == 1) {
                                                zzjs zzjsVar = (zzjs) zzkmVar;
                                                zzjsVar.zza(zziu.zza(bArr2, i37));
                                                i40 = i37 + 8;
                                                while (i40 < i39) {
                                                    int zzc2 = zziu.zzc(bArr2, i40, zzitVar6);
                                                    if (i38 == zzitVar6.zza) {
                                                        zzjsVar.zza(zziu.zza(bArr2, zzc2));
                                                        i40 = zzc2 + 8;
                                                    }
                                                }
                                            }
                                            i41 = i37;
                                            if (i41 == i37) {
                                                i15 = i41;
                                                i53 = i36;
                                                unsafe2 = unsafe5;
                                                i56 = i38;
                                                zzitVar2 = zzitVar6;
                                                t6 = t5;
                                                i18 = i55;
                                                i14 = i61;
                                                break;
                                            } else {
                                                i54 = i41;
                                                i53 = i36;
                                                unsafe8 = unsafe5;
                                                i56 = i38;
                                                i52 = i39;
                                                zzitVar10 = zzitVar6;
                                                i58 = i61;
                                                i57 = i16;
                                                i59 = i17;
                                                t6 = t5;
                                                break;
                                            }
                                        } else {
                                            zzjs zzjsVar2 = (zzjs) zzkmVar;
                                            i40 = zziu.zzc(bArr2, i37, zzitVar6);
                                            int i75 = zzitVar6.zza;
                                            int i76 = i40 + i75;
                                            if (i76 <= bArr2.length) {
                                                zzjsVar2.zzc(zzjsVar2.size() + (i75 / 8));
                                                while (i40 < i76) {
                                                    zzjsVar2.zza(zziu.zza(bArr2, i40));
                                                    i40 += 8;
                                                }
                                                if (i40 != i76) {
                                                    throw zzkp.zzi();
                                                }
                                            } else {
                                                throw zzkp.zzi();
                                            }
                                        }
                                        i41 = i40;
                                        if (i41 == i37) {
                                        }
                                    case 19:
                                    case 36:
                                        i36 = i7;
                                        i55 = i63;
                                        zzitVar6 = zzitVar11;
                                        i37 = i66;
                                        i38 = i74;
                                        unsafe5 = unsafe4;
                                        i39 = i6;
                                        if (i62 == 2) {
                                            zzkc zzkcVar = (zzkc) zzkmVar;
                                            i40 = zziu.zzc(bArr2, i37, zzitVar6);
                                            int i77 = zzitVar6.zza;
                                            int i78 = i40 + i77;
                                            if (i78 <= bArr2.length) {
                                                zzkcVar.zzc(zzkcVar.size() + (i77 / 4));
                                                while (i40 < i78) {
                                                    zzkcVar.zza(zziu.zzb(bArr2, i40));
                                                    i40 += 4;
                                                }
                                                if (i40 != i78) {
                                                    throw zzkp.zzi();
                                                }
                                            } else {
                                                throw zzkp.zzi();
                                            }
                                        } else {
                                            if (i62 == 5) {
                                                zzkc zzkcVar2 = (zzkc) zzkmVar;
                                                zzkcVar2.zza(zziu.zzb(bArr2, i37));
                                                i40 = i37 + 4;
                                                while (i40 < i39) {
                                                    int zzc3 = zziu.zzc(bArr2, i40, zzitVar6);
                                                    if (i38 == zzitVar6.zza) {
                                                        zzkcVar2.zza(zziu.zzb(bArr2, zzc3));
                                                        i40 = zzc3 + 4;
                                                    }
                                                }
                                            }
                                            i41 = i37;
                                            if (i41 == i37) {
                                            }
                                        }
                                        i41 = i40;
                                        if (i41 == i37) {
                                        }
                                        break;
                                    case 20:
                                    case 21:
                                    case 37:
                                    case 38:
                                        i36 = i7;
                                        i55 = i63;
                                        zzitVar6 = zzitVar11;
                                        i37 = i66;
                                        i38 = i74;
                                        unsafe5 = unsafe4;
                                        i39 = i6;
                                        if (i62 == 2) {
                                            zzlb zzlbVar = (zzlb) zzkmVar;
                                            i40 = zziu.zzc(bArr2, i37, zzitVar6);
                                            int i79 = zzitVar6.zza + i40;
                                            while (i40 < i79) {
                                                i40 = zziu.zzd(bArr2, i40, zzitVar6);
                                                zzlbVar.zza(zzitVar6.zzb);
                                            }
                                            if (i40 != i79) {
                                                throw zzkp.zzi();
                                            }
                                        } else {
                                            if (i62 == 0) {
                                                zzlb zzlbVar2 = (zzlb) zzkmVar;
                                                i40 = zziu.zzd(bArr2, i37, zzitVar6);
                                                zzlbVar2.zza(zzitVar6.zzb);
                                                while (i40 < i39) {
                                                    int zzc4 = zziu.zzc(bArr2, i40, zzitVar6);
                                                    if (i38 == zzitVar6.zza) {
                                                        i40 = zziu.zzd(bArr2, zzc4, zzitVar6);
                                                        zzlbVar2.zza(zzitVar6.zzb);
                                                    }
                                                }
                                            }
                                            i41 = i37;
                                            if (i41 == i37) {
                                            }
                                        }
                                        i41 = i40;
                                        if (i41 == i37) {
                                        }
                                        break;
                                    case 22:
                                    case R$styleable.Toolbar_titleTextColor /* 29 */:
                                    case 39:
                                    case 43:
                                        i55 = i63;
                                        zzitVar6 = zzitVar11;
                                        i42 = i66;
                                        i38 = i74;
                                        unsafe6 = unsafe4;
                                        i39 = i6;
                                        i43 = i7;
                                        if (i62 == 2) {
                                            i41 = zziu.zza(bArr2, i42, (zzkm<?>) zzkmVar, zzitVar6);
                                            i37 = i42;
                                            i36 = i43;
                                            unsafe5 = unsafe6;
                                            if (i41 == i37) {
                                            }
                                        } else {
                                            if (i62 == 0) {
                                                i37 = i42;
                                                i36 = i43;
                                                unsafe5 = unsafe6;
                                                i40 = zziu.zza(i38, bArr, i37, i6, (zzkm<?>) zzkmVar, zzitVar);
                                                i41 = i40;
                                                if (i41 == i37) {
                                                }
                                            }
                                            i37 = i42;
                                            i36 = i43;
                                            unsafe5 = unsafe6;
                                            i41 = i37;
                                            if (i41 == i37) {
                                            }
                                        }
                                        break;
                                    case R$styleable.Toolbar_titleMarginBottom /* 23 */:
                                    case 32:
                                    case 40:
                                    case 46:
                                        i55 = i63;
                                        zzitVar6 = zzitVar11;
                                        i42 = i66;
                                        i38 = i74;
                                        unsafe6 = unsafe4;
                                        i39 = i6;
                                        i43 = i7;
                                        if (i62 == 2) {
                                            zzlb zzlbVar3 = (zzlb) zzkmVar;
                                            i41 = zziu.zzc(bArr2, i42, zzitVar6);
                                            int i80 = zzitVar6.zza;
                                            int i81 = i41 + i80;
                                            if (i81 <= bArr2.length) {
                                                zzlbVar3.zzd(zzlbVar3.size() + (i80 / 8));
                                                while (i41 < i81) {
                                                    zzlbVar3.zza(zziu.zzd(bArr2, i41));
                                                    i41 += 8;
                                                }
                                                if (i41 != i81) {
                                                    throw zzkp.zzi();
                                                }
                                                i37 = i42;
                                                i36 = i43;
                                                unsafe5 = unsafe6;
                                                if (i41 == i37) {
                                                }
                                            } else {
                                                throw zzkp.zzi();
                                            }
                                        } else {
                                            if (i62 == 1) {
                                                zzlb zzlbVar4 = (zzlb) zzkmVar;
                                                zzlbVar4.zza(zziu.zzd(bArr2, i42));
                                                i44 = i42 + 8;
                                                while (i44 < i39) {
                                                    int zzc5 = zziu.zzc(bArr2, i44, zzitVar6);
                                                    if (i38 == zzitVar6.zza) {
                                                        zzlbVar4.zza(zziu.zzd(bArr2, zzc5));
                                                        i44 = zzc5 + 8;
                                                    } else {
                                                        i37 = i42;
                                                        i36 = i43;
                                                        i41 = i44;
                                                        unsafe5 = unsafe6;
                                                        if (i41 == i37) {
                                                        }
                                                    }
                                                }
                                                i37 = i42;
                                                i36 = i43;
                                                i41 = i44;
                                                unsafe5 = unsafe6;
                                                if (i41 == i37) {
                                                }
                                            }
                                            i37 = i42;
                                            i36 = i43;
                                            unsafe5 = unsafe6;
                                            i41 = i37;
                                            if (i41 == i37) {
                                            }
                                        }
                                        break;
                                    case R$styleable.Toolbar_titleMarginEnd /* 24 */:
                                    case 31:
                                    case 41:
                                    case 45:
                                        i55 = i63;
                                        zzitVar6 = zzitVar11;
                                        i42 = i66;
                                        i38 = i74;
                                        unsafe6 = unsafe4;
                                        i39 = i6;
                                        i43 = i7;
                                        if (i62 == 2) {
                                            zzkh zzkhVar = (zzkh) zzkmVar;
                                            i41 = zziu.zzc(bArr2, i42, zzitVar6);
                                            int i82 = zzitVar6.zza;
                                            int i83 = i41 + i82;
                                            if (i83 <= bArr2.length) {
                                                zzkhVar.zze(zzkhVar.size() + (i82 / 4));
                                                while (i41 < i83) {
                                                    zzkhVar.zzd(zziu.zzc(bArr2, i41));
                                                    i41 += 4;
                                                }
                                                if (i41 != i83) {
                                                    throw zzkp.zzi();
                                                }
                                                i37 = i42;
                                                i36 = i43;
                                                unsafe5 = unsafe6;
                                                if (i41 == i37) {
                                                }
                                            } else {
                                                throw zzkp.zzi();
                                            }
                                        } else {
                                            if (i62 == 5) {
                                                zzkh zzkhVar2 = (zzkh) zzkmVar;
                                                zzkhVar2.zzd(zziu.zzc(bArr2, i42));
                                                i44 = i42 + 4;
                                                while (i44 < i39) {
                                                    int zzc6 = zziu.zzc(bArr2, i44, zzitVar6);
                                                    if (i38 == zzitVar6.zza) {
                                                        zzkhVar2.zzd(zziu.zzc(bArr2, zzc6));
                                                        i44 = zzc6 + 4;
                                                    } else {
                                                        i37 = i42;
                                                        i36 = i43;
                                                        i41 = i44;
                                                        unsafe5 = unsafe6;
                                                        if (i41 == i37) {
                                                        }
                                                    }
                                                }
                                                i37 = i42;
                                                i36 = i43;
                                                i41 = i44;
                                                unsafe5 = unsafe6;
                                                if (i41 == i37) {
                                                }
                                            }
                                            i37 = i42;
                                            i36 = i43;
                                            unsafe5 = unsafe6;
                                            i41 = i37;
                                            if (i41 == i37) {
                                            }
                                        }
                                        break;
                                    case 25:
                                    case 42:
                                        i55 = i63;
                                        zzitVar6 = zzitVar11;
                                        i42 = i66;
                                        i38 = i74;
                                        unsafe6 = unsafe4;
                                        i39 = i6;
                                        i43 = i7;
                                        if (i62 == 2) {
                                            zziw zziwVar = (zziw) zzkmVar;
                                            i41 = zziu.zzc(bArr2, i42, zzitVar6);
                                            int i84 = zzitVar6.zza + i41;
                                            while (i41 < i84) {
                                                i41 = zziu.zzd(bArr2, i41, zzitVar6);
                                                zziwVar.zza(zzitVar6.zzb != 0);
                                            }
                                            if (i41 != i84) {
                                                throw zzkp.zzi();
                                            }
                                        } else {
                                            if (i62 == 0) {
                                                zziw zziwVar2 = (zziw) zzkmVar;
                                                i41 = zziu.zzd(bArr2, i42, zzitVar6);
                                                zziwVar2.zza(zzitVar6.zzb != 0);
                                                while (i41 < i39) {
                                                    int zzc7 = zziu.zzc(bArr2, i41, zzitVar6);
                                                    if (i38 == zzitVar6.zza) {
                                                        i41 = zziu.zzd(bArr2, zzc7, zzitVar6);
                                                        zziwVar2.zza(zzitVar6.zzb != 0);
                                                    }
                                                }
                                            }
                                            i37 = i42;
                                            i36 = i43;
                                            unsafe5 = unsafe6;
                                            i41 = i37;
                                            if (i41 == i37) {
                                            }
                                        }
                                        i37 = i42;
                                        i36 = i43;
                                        unsafe5 = unsafe6;
                                        if (i41 == i37) {
                                        }
                                        break;
                                    case 26:
                                        i55 = i63;
                                        zzitVar6 = zzitVar11;
                                        i42 = i66;
                                        i38 = i74;
                                        unsafe6 = unsafe4;
                                        i39 = i6;
                                        i43 = i7;
                                        if (i62 == 2) {
                                            if ((j6 & 536870912) == 0) {
                                                i41 = zziu.zzc(bArr2, i42, zzitVar6);
                                                int i85 = zzitVar6.zza;
                                                if (i85 < 0) {
                                                    throw zzkp.zzf();
                                                }
                                                if (i85 == 0) {
                                                    zzkmVar.add(BuildConfig.FLAVOR);
                                                } else {
                                                    zzkmVar.add(new String(bArr2, i41, i85, zzkj.zza));
                                                    i41 += i85;
                                                }
                                                while (i41 < i39) {
                                                    int zzc8 = zziu.zzc(bArr2, i41, zzitVar6);
                                                    if (i38 == zzitVar6.zza) {
                                                        i41 = zziu.zzc(bArr2, zzc8, zzitVar6);
                                                        int i86 = zzitVar6.zza;
                                                        if (i86 < 0) {
                                                            throw zzkp.zzf();
                                                        }
                                                        if (i86 == 0) {
                                                            zzkmVar.add(BuildConfig.FLAVOR);
                                                        } else {
                                                            zzkmVar.add(new String(bArr2, i41, i86, zzkj.zza));
                                                            i41 += i86;
                                                        }
                                                    }
                                                }
                                            } else {
                                                i41 = zziu.zzc(bArr2, i42, zzitVar6);
                                                int i87 = zzitVar6.zza;
                                                if (i87 < 0) {
                                                    throw zzkp.zzf();
                                                }
                                                if (i87 == 0) {
                                                    zzkmVar.add(BuildConfig.FLAVOR);
                                                } else {
                                                    int i88 = i41 + i87;
                                                    if (zzna.zzc(bArr2, i41, i88)) {
                                                        zzkmVar.add(new String(bArr2, i41, i87, zzkj.zza));
                                                        i41 = i88;
                                                    } else {
                                                        throw zzkp.zzd();
                                                    }
                                                }
                                                while (i41 < i39) {
                                                    int zzc9 = zziu.zzc(bArr2, i41, zzitVar6);
                                                    if (i38 == zzitVar6.zza) {
                                                        i41 = zziu.zzc(bArr2, zzc9, zzitVar6);
                                                        int i89 = zzitVar6.zza;
                                                        if (i89 < 0) {
                                                            throw zzkp.zzf();
                                                        }
                                                        if (i89 == 0) {
                                                            zzkmVar.add(BuildConfig.FLAVOR);
                                                        } else {
                                                            int i90 = i41 + i89;
                                                            if (zzna.zzc(bArr2, i41, i90)) {
                                                                zzkmVar.add(new String(bArr2, i41, i89, zzkj.zza));
                                                                i41 = i90;
                                                            } else {
                                                                throw zzkp.zzd();
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                            i37 = i42;
                                            i36 = i43;
                                            unsafe5 = unsafe6;
                                            if (i41 == i37) {
                                            }
                                        }
                                        i37 = i42;
                                        i36 = i43;
                                        unsafe5 = unsafe6;
                                        i41 = i37;
                                        if (i41 == i37) {
                                        }
                                        break;
                                    case 27:
                                        i36 = i7;
                                        i45 = i6;
                                        i46 = i63;
                                        zzitVar7 = zzitVar11;
                                        i47 = i66;
                                        i48 = i74;
                                        unsafe7 = unsafe4;
                                        if (i62 == 2) {
                                            zzitVar6 = zzitVar7;
                                            int zzb2 = zziu.zzb(zze(i46), i48, bArr, i47, i6, zzkmVar, zzitVar);
                                            i39 = i45;
                                            i55 = i46;
                                            i36 = i36;
                                            unsafe5 = unsafe7;
                                            i38 = i48;
                                            i41 = zzb2;
                                            i37 = i47;
                                            if (i41 == i37) {
                                            }
                                        }
                                        zzitVar6 = zzitVar7;
                                        i38 = i48;
                                        i39 = i45;
                                        unsafe5 = unsafe7;
                                        i37 = i47;
                                        i55 = i46;
                                        i41 = i37;
                                        if (i41 == i37) {
                                        }
                                        break;
                                    case 28:
                                        i36 = i7;
                                        i45 = i6;
                                        zzkm zzkmVar5 = zzkmVar;
                                        i46 = i63;
                                        zzitVar7 = zzitVar11;
                                        i47 = i66;
                                        i48 = i74;
                                        unsafe7 = unsafe4;
                                        if (i62 == 2) {
                                            int zzc10 = zziu.zzc(bArr2, i47, zzitVar7);
                                            int i91 = zzitVar7.zza;
                                            if (i91 >= 0) {
                                                if (i91 > bArr2.length - zzc10) {
                                                    throw zzkp.zzi();
                                                }
                                                if (i91 == 0) {
                                                    zzkmVar2 = zzkmVar5;
                                                    zzkmVar2.add(zziy.zza);
                                                } else {
                                                    zzkmVar2 = zzkmVar5;
                                                    zzkmVar2.add(zziy.zza(bArr2, zzc10, i91));
                                                    zzc10 += i91;
                                                }
                                                while (zzc10 < i45) {
                                                    int zzc11 = zziu.zzc(bArr2, zzc10, zzitVar7);
                                                    if (i48 == zzitVar7.zza) {
                                                        zzc10 = zziu.zzc(bArr2, zzc11, zzitVar7);
                                                        int i92 = zzitVar7.zza;
                                                        if (i92 >= 0) {
                                                            if (i92 > bArr2.length - zzc10) {
                                                                throw zzkp.zzi();
                                                            }
                                                            if (i92 == 0) {
                                                                zzkmVar2.add(zziy.zza);
                                                            } else {
                                                                zzkmVar2.add(zziy.zza(bArr2, zzc10, i92));
                                                                zzc10 += i92;
                                                            }
                                                        } else {
                                                            throw zzkp.zzf();
                                                        }
                                                    } else {
                                                        i41 = zzc10;
                                                        zzitVar6 = zzitVar7;
                                                        i38 = i48;
                                                        i39 = i45;
                                                        unsafe5 = unsafe7;
                                                        i37 = i47;
                                                        i55 = i46;
                                                        if (i41 == i37) {
                                                        }
                                                    }
                                                }
                                                i41 = zzc10;
                                                zzitVar6 = zzitVar7;
                                                i38 = i48;
                                                i39 = i45;
                                                unsafe5 = unsafe7;
                                                i37 = i47;
                                                i55 = i46;
                                                if (i41 == i37) {
                                                }
                                            } else {
                                                throw zzkp.zzf();
                                            }
                                        }
                                        zzitVar6 = zzitVar7;
                                        i38 = i48;
                                        i39 = i45;
                                        unsafe5 = unsafe7;
                                        i37 = i47;
                                        i55 = i46;
                                        i41 = i37;
                                        if (i41 == i37) {
                                        }
                                        break;
                                    case 30:
                                    case 44:
                                        i49 = i63;
                                        zzitVar8 = zzitVar11;
                                        i50 = i66;
                                        i51 = i74;
                                        if (i62 == 2) {
                                            i36 = i7;
                                            zzitVar9 = zzitVar8;
                                            zza3 = zziu.zza(bArr2, i50, (zzkm<?>) zzkmVar, zzitVar8);
                                            i46 = i49;
                                            i45 = i6;
                                            i47 = i50;
                                            zzkmVar3 = zzkmVar;
                                            unsafe7 = unsafe4;
                                        } else {
                                            if (i62 == 0) {
                                                zzitVar9 = zzitVar8;
                                                i46 = i49;
                                                i45 = i6;
                                                i47 = i50;
                                                i36 = i7;
                                                zzkmVar3 = zzkmVar;
                                                unsafe7 = unsafe4;
                                                zza3 = zziu.zza(i51, bArr, i50, i6, (zzkm<?>) zzkmVar, zzitVar);
                                            }
                                            i36 = i7;
                                            zzitVar6 = zzitVar8;
                                            i55 = i49;
                                            i37 = i50;
                                            i38 = i51;
                                            unsafe5 = unsafe4;
                                            i39 = i6;
                                            i41 = i37;
                                            if (i41 == i37) {
                                            }
                                        }
                                        zzmg.zza(t5, i61, zzkmVar3, zzd(i46), null, this.zzp);
                                        zzitVar6 = zzitVar9;
                                        i38 = i51;
                                        i41 = zza3;
                                        i39 = i45;
                                        unsafe5 = unsafe7;
                                        i37 = i47;
                                        i55 = i46;
                                        if (i41 == i37) {
                                        }
                                        break;
                                    case 33:
                                    case 47:
                                        i49 = i63;
                                        zzitVar8 = zzitVar11;
                                        i50 = i66;
                                        i51 = i74;
                                        if (i62 == 2) {
                                            zzkh zzkhVar3 = (zzkh) zzkmVar;
                                            i41 = zziu.zzc(bArr2, i50, zzitVar8);
                                            int i93 = zzitVar8.zza + i41;
                                            while (i41 < i93) {
                                                i41 = zziu.zzc(bArr2, i41, zzitVar8);
                                                zzkhVar3.zzd(zzjk.zze(zzitVar8.zza));
                                            }
                                            if (i41 != i93) {
                                                throw zzkp.zzi();
                                            }
                                        } else {
                                            if (i62 == 0) {
                                                zzkh zzkhVar4 = (zzkh) zzkmVar;
                                                i41 = zziu.zzc(bArr2, i50, zzitVar8);
                                                zzkhVar4.zzd(zzjk.zze(zzitVar8.zza));
                                                while (i41 < i6) {
                                                    int zzc12 = zziu.zzc(bArr2, i41, zzitVar8);
                                                    if (i51 == zzitVar8.zza) {
                                                        i41 = zziu.zzc(bArr2, zzc12, zzitVar8);
                                                        zzkhVar4.zzd(zzjk.zze(zzitVar8.zza));
                                                    }
                                                }
                                            }
                                            i36 = i7;
                                            zzitVar6 = zzitVar8;
                                            i55 = i49;
                                            i37 = i50;
                                            i38 = i51;
                                            unsafe5 = unsafe4;
                                            i39 = i6;
                                            i41 = i37;
                                            if (i41 == i37) {
                                            }
                                        }
                                        i36 = i7;
                                        zzitVar6 = zzitVar8;
                                        i55 = i49;
                                        i37 = i50;
                                        i38 = i51;
                                        unsafe5 = unsafe4;
                                        i39 = i6;
                                        if (i41 == i37) {
                                        }
                                        break;
                                    case 34:
                                    case 48:
                                        i49 = i63;
                                        zzitVar8 = zzitVar11;
                                        i50 = i66;
                                        if (i62 == 2) {
                                            zzlb zzlbVar5 = (zzlb) zzkmVar;
                                            i41 = zziu.zzc(bArr2, i50, zzitVar8);
                                            int i94 = zzitVar8.zza + i41;
                                            while (i41 < i94) {
                                                i41 = zziu.zzd(bArr2, i41, zzitVar8);
                                                zzlbVar5.zza(zzjk.zza(zzitVar8.zzb));
                                            }
                                            if (i41 != i94) {
                                                throw zzkp.zzi();
                                            }
                                            i36 = i7;
                                            zzitVar6 = zzitVar8;
                                            i55 = i49;
                                            i39 = i6;
                                            i37 = i50;
                                            i38 = i74;
                                            unsafe5 = unsafe4;
                                            if (i41 == i37) {
                                            }
                                        } else if (i62 == 0) {
                                            zzlb zzlbVar6 = (zzlb) zzkmVar;
                                            i41 = zziu.zzd(bArr2, i50, zzitVar8);
                                            zzlbVar6.zza(zzjk.zza(zzitVar8.zzb));
                                            while (true) {
                                                if (i41 < i6) {
                                                    int zzc13 = zziu.zzc(bArr2, i41, zzitVar8);
                                                    i51 = i74;
                                                    if (i51 == zzitVar8.zza) {
                                                        i41 = zziu.zzd(bArr2, zzc13, zzitVar8);
                                                        zzlbVar6.zza(zzjk.zza(zzitVar8.zzb));
                                                        i74 = i51;
                                                    }
                                                } else {
                                                    i51 = i74;
                                                }
                                            }
                                            i36 = i7;
                                            zzitVar6 = zzitVar8;
                                            i55 = i49;
                                            i37 = i50;
                                            i38 = i51;
                                            unsafe5 = unsafe4;
                                            i39 = i6;
                                            if (i41 == i37) {
                                            }
                                        } else {
                                            i36 = i7;
                                            zzitVar6 = zzitVar8;
                                            i55 = i49;
                                            i39 = i6;
                                            i37 = i50;
                                            i38 = i74;
                                            unsafe5 = unsafe4;
                                            i41 = i37;
                                            if (i41 == i37) {
                                            }
                                        }
                                        break;
                                    case 49:
                                        if (i62 == 3) {
                                            i50 = i66;
                                            i49 = i63;
                                            zzitVar8 = zzitVar11;
                                            i41 = zziu.zza((zzme<?>) zze(i63), i74, bArr, i50, i6, (zzkm<Object>) zzkmVar, zzitVar);
                                            i36 = i7;
                                            zzitVar6 = zzitVar8;
                                            i55 = i49;
                                            i39 = i6;
                                            i37 = i50;
                                            i38 = i74;
                                            unsafe5 = unsafe4;
                                            if (i41 == i37) {
                                            }
                                        }
                                        break;
                                    default:
                                        i36 = i7;
                                        i55 = i63;
                                        zzitVar6 = zzitVar11;
                                        i37 = i66;
                                        i38 = i74;
                                        unsafe5 = unsafe4;
                                        i39 = i6;
                                        i41 = i37;
                                        if (i41 == i37) {
                                        }
                                        break;
                                }
                            } else {
                                unsafe2 = unsafe9;
                                i55 = i63;
                                i29 = i66;
                                i30 = i74;
                                i53 = i7;
                                if (i65 != 50) {
                                    t6 = t5;
                                    Unsafe unsafe11 = zzb;
                                    long j7 = iArr[i55 + 2] & 1048575;
                                    switch (i65) {
                                        case 51:
                                            zzitVar2 = zzitVar;
                                            i31 = i55;
                                            i14 = i61;
                                            i32 = i30;
                                            if (i62 == 1) {
                                                unsafe11.putObject(t6, j5, Double.valueOf(zziu.zza(bArr2, i29)));
                                                i33 = i29 + 8;
                                                unsafe11.putInt(t6, j7, i14);
                                                zzd = i33;
                                                if (zzd != i29) {
                                                    i53 = i7;
                                                    i15 = zzd;
                                                    i56 = i32;
                                                    i18 = i31;
                                                    break;
                                                } else {
                                                    int i95 = i14;
                                                    bArr2 = bArr;
                                                    i52 = i6;
                                                    i53 = i7;
                                                    zzitVar10 = zzitVar;
                                                    i54 = zzd;
                                                    i55 = i31;
                                                    i58 = i95;
                                                    i56 = i32;
                                                    i57 = i16;
                                                    unsafe8 = unsafe2;
                                                    i59 = i17;
                                                    break;
                                                }
                                            }
                                            zzd = i29;
                                            if (zzd != i29) {
                                            }
                                        case 52:
                                            zzitVar2 = zzitVar;
                                            i31 = i55;
                                            i14 = i61;
                                            i32 = i30;
                                            if (i62 == 5) {
                                                unsafe11.putObject(t6, j5, Float.valueOf(zziu.zzb(bArr2, i29)));
                                                i33 = i29 + 4;
                                                unsafe11.putInt(t6, j7, i14);
                                                zzd = i33;
                                                if (zzd != i29) {
                                                }
                                            }
                                            zzd = i29;
                                            if (zzd != i29) {
                                            }
                                            break;
                                        case 53:
                                        case 54:
                                            zzitVar2 = zzitVar;
                                            i31 = i55;
                                            i14 = i61;
                                            i32 = i30;
                                            if (i62 == 0) {
                                                zzd = zziu.zzd(bArr2, i29, zzitVar2);
                                                unsafe11.putObject(t6, j5, Long.valueOf(zzitVar2.zzb));
                                                unsafe11.putInt(t6, j7, i14);
                                                if (zzd != i29) {
                                                }
                                            }
                                            zzd = i29;
                                            if (zzd != i29) {
                                            }
                                            break;
                                        case 55:
                                        case 62:
                                            zzitVar2 = zzitVar;
                                            i31 = i55;
                                            i14 = i61;
                                            i32 = i30;
                                            if (i62 == 0) {
                                                zzd = zziu.zzc(bArr2, i29, zzitVar2);
                                                unsafe11.putObject(t6, j5, Integer.valueOf(zzitVar2.zza));
                                                unsafe11.putInt(t6, j7, i14);
                                                if (zzd != i29) {
                                                }
                                            }
                                            zzd = i29;
                                            if (zzd != i29) {
                                            }
                                            break;
                                        case 56:
                                        case 65:
                                            zzitVar2 = zzitVar;
                                            i31 = i55;
                                            i14 = i61;
                                            i32 = i30;
                                            if (i62 == 1) {
                                                unsafe11.putObject(t6, j5, Long.valueOf(zziu.zzd(bArr2, i29)));
                                                i33 = i29 + 8;
                                                unsafe11.putInt(t6, j7, i14);
                                                zzd = i33;
                                                if (zzd != i29) {
                                                }
                                            }
                                            zzd = i29;
                                            if (zzd != i29) {
                                            }
                                            break;
                                        case 57:
                                        case Function.THROW_LAST_ERROR /* 64 */:
                                            zzitVar2 = zzitVar;
                                            i31 = i55;
                                            i14 = i61;
                                            i32 = i30;
                                            if (i62 == 5) {
                                                unsafe11.putObject(t6, j5, Integer.valueOf(zziu.zzc(bArr2, i29)));
                                                i33 = i29 + 4;
                                                unsafe11.putInt(t6, j7, i14);
                                                zzd = i33;
                                                if (zzd != i29) {
                                                }
                                            }
                                            zzd = i29;
                                            if (zzd != i29) {
                                            }
                                            break;
                                        case 58:
                                            zzitVar2 = zzitVar;
                                            i31 = i55;
                                            i14 = i61;
                                            i32 = i30;
                                            if (i62 == 0) {
                                                zzd = zziu.zzd(bArr2, i29, zzitVar2);
                                                unsafe11.putObject(t6, j5, Boolean.valueOf(zzitVar2.zzb != 0));
                                                unsafe11.putInt(t6, j7, i14);
                                                if (zzd != i29) {
                                                }
                                            }
                                            zzd = i29;
                                            if (zzd != i29) {
                                            }
                                            break;
                                        case 59:
                                            zzitVar2 = zzitVar;
                                            i31 = i55;
                                            i14 = i61;
                                            i32 = i30;
                                            if (i62 == 2) {
                                                int zzc14 = zziu.zzc(bArr2, i29, zzitVar2);
                                                int i96 = zzitVar2.zza;
                                                if (i96 == 0) {
                                                    unsafe2 = unsafe2;
                                                    unsafe11.putObject(t6, j5, BuildConfig.FLAVOR);
                                                } else {
                                                    unsafe2 = unsafe2;
                                                    if ((i64 & 536870912) != 0 && !zzna.zzc(bArr2, zzc14, zzc14 + i96)) {
                                                        throw zzkp.zzd();
                                                    }
                                                    unsafe11.putObject(t6, j5, new String(bArr2, zzc14, i96, zzkj.zza));
                                                    zzc14 += i96;
                                                }
                                                unsafe11.putInt(t6, j7, i14);
                                                zzd = zzc14;
                                                if (zzd != i29) {
                                                }
                                            } else {
                                                unsafe2 = unsafe2;
                                                zzd = i29;
                                                if (zzd != i29) {
                                                }
                                            }
                                            break;
                                        case 60:
                                            zzitVar5 = zzitVar;
                                            i31 = i55;
                                            i34 = i30;
                                            i35 = i61;
                                            if (i62 == 2) {
                                                Object zza7 = zza((zzlq<T>) t6, i35, i31);
                                                i32 = i34;
                                                i14 = i35;
                                                zzd = zziu.zza(zza7, zze(i31), bArr, i29, i6, zzitVar);
                                                zza((zzlq<T>) t6, i14, i31, zza7);
                                                zzitVar2 = zzitVar5;
                                                if (zzd != i29) {
                                                }
                                            }
                                            i32 = i34;
                                            i14 = i35;
                                            zzitVar2 = zzitVar5;
                                            zzd = i29;
                                            if (zzd != i29) {
                                            }
                                            break;
                                        case 61:
                                            i31 = i55;
                                            i34 = i30;
                                            i35 = i61;
                                            zzitVar5 = zzitVar;
                                            if (i62 == 2) {
                                                zzd = zziu.zza(bArr2, i29, zzitVar5);
                                                unsafe11.putObject(t6, j5, zzitVar5.zzc);
                                                unsafe11.putInt(t6, j7, i35);
                                                i32 = i34;
                                                i14 = i35;
                                                zzitVar2 = zzitVar5;
                                                if (zzd != i29) {
                                                }
                                            }
                                            i32 = i34;
                                            i14 = i35;
                                            zzitVar2 = zzitVar5;
                                            zzd = i29;
                                            if (zzd != i29) {
                                            }
                                            break;
                                        case Function.ALT_CONVENTION /* 63 */:
                                            i31 = i55;
                                            i35 = i61;
                                            i32 = i30;
                                            zzitVar5 = zzitVar;
                                            if (i62 == 0) {
                                                zzd = zziu.zzc(bArr2, i29, zzitVar5);
                                                int i97 = zzitVar5.zza;
                                                zzkl zzd5 = zzd(i31);
                                                if (zzd5 != null && !zzd5.zza(i97)) {
                                                    i34 = i32;
                                                    zzc(t5).zza(i34, Long.valueOf(i97));
                                                } else {
                                                    i34 = i32;
                                                    unsafe11.putObject(t6, j5, Integer.valueOf(i97));
                                                    unsafe11.putInt(t6, j7, i35);
                                                }
                                                i32 = i34;
                                                i14 = i35;
                                                zzitVar2 = zzitVar5;
                                                if (zzd != i29) {
                                                }
                                            }
                                            i14 = i35;
                                            zzitVar2 = zzitVar5;
                                            zzd = i29;
                                            if (zzd != i29) {
                                            }
                                            break;
                                        case 66:
                                            i31 = i55;
                                            i35 = i61;
                                            i32 = i30;
                                            zzitVar5 = zzitVar;
                                            if (i62 == 0) {
                                                zzd = zziu.zzc(bArr2, i29, zzitVar5);
                                                unsafe11.putObject(t6, j5, Integer.valueOf(zzjk.zze(zzitVar5.zza)));
                                                unsafe11.putInt(t6, j7, i35);
                                                i14 = i35;
                                                zzitVar2 = zzitVar5;
                                                if (zzd != i29) {
                                                }
                                            }
                                            i14 = i35;
                                            zzitVar2 = zzitVar5;
                                            zzd = i29;
                                            if (zzd != i29) {
                                            }
                                            break;
                                        case 67:
                                            i31 = i55;
                                            i35 = i61;
                                            if (i62 == 0) {
                                                zzitVar5 = zzitVar;
                                                int zzd6 = zziu.zzd(bArr2, i29, zzitVar5);
                                                i32 = i30;
                                                unsafe11.putObject(t6, j5, Long.valueOf(zzjk.zza(zzitVar5.zzb)));
                                                unsafe11.putInt(t6, j7, i35);
                                                zzd = zzd6;
                                                i14 = i35;
                                                zzitVar2 = zzitVar5;
                                                if (zzd != i29) {
                                                }
                                            } else {
                                                i14 = i35;
                                                i32 = i30;
                                                zzitVar2 = zzitVar;
                                                zzd = i29;
                                                if (zzd != i29) {
                                                }
                                            }
                                            break;
                                        case 68:
                                            if (i62 == 3) {
                                                Object zza8 = zza((zzlq<T>) t6, i61, i55);
                                                int zza9 = zziu.zza(zza8, zze(i55), bArr, i29, i6, (i30 & (-8)) | 4, zzitVar);
                                                zza((zzlq<T>) t6, i61, i55, zza8);
                                                i31 = i55;
                                                i14 = i61;
                                                i32 = i30;
                                                zzd = zza9;
                                                zzitVar2 = zzitVar;
                                                i29 = i29;
                                                if (zzd != i29) {
                                                }
                                            }
                                            break;
                                        default:
                                            zzitVar2 = zzitVar;
                                            i31 = i55;
                                            i14 = i61;
                                            i32 = i30;
                                            zzd = i29;
                                            if (zzd != i29) {
                                            }
                                            break;
                                    }
                                } else {
                                    if (i62 == 2) {
                                        Unsafe unsafe12 = zzb;
                                        Object zzf = zzf(i55);
                                        Object object = unsafe12.getObject(t5, j5);
                                        if (this.zzr.zzf(object)) {
                                            Object zzb3 = this.zzr.zzb(zzf);
                                            this.zzr.zza(zzb3, object);
                                            unsafe12.putObject(t5, j5, zzb3);
                                            object = zzb3;
                                        }
                                        this.zzr.zza(zzf);
                                        this.zzr.zze(object);
                                        int zzc15 = zziu.zzc(bArr2, i29, zzitVar11);
                                        int i98 = zzitVar11.zza;
                                        if (i98 >= 0 && i98 <= i6 - zzc15) {
                                            throw null;
                                        }
                                        throw zzkp.zzi();
                                    }
                                    zzitVar4 = zzitVar11;
                                    t6 = t5;
                                }
                            }
                        } else if (i62 == 2) {
                            zzkm zzkmVar6 = (zzkm) unsafe9.getObject(t6, j5);
                            if (!zzkmVar6.zzc()) {
                                int size = zzkmVar6.size();
                                zzkmVar6 = zzkmVar6.zza(size == 0 ? 10 : size << 1);
                                unsafe9.putObject(t6, j5, zzkmVar6);
                            }
                            i54 = zziu.zzb(zze(i63), i74, bArr, i66, i6, zzkmVar6, zzitVar);
                            zzitVar10 = zzitVar11;
                            i55 = i63;
                            i52 = i6;
                            unsafe8 = unsafe9;
                            i58 = i61;
                            i56 = i74;
                            i57 = i16;
                            i59 = i17;
                            i53 = i7;
                        } else {
                            i53 = i7;
                            unsafe2 = unsafe9;
                            i29 = i66;
                            i55 = i63;
                            i30 = i74;
                            zzitVar4 = zzitVar11;
                        }
                        zzitVar2 = zzitVar4;
                        i15 = i29;
                        i56 = i30;
                        i18 = i55;
                        i14 = i61;
                    }
                }
                if (i56 == i53 && i53 != 0) {
                    i8 = i6;
                    i54 = i15;
                    i10 = i53;
                    i11 = i16;
                    unsafe = unsafe2;
                    i12 = i17;
                    i9 = 1048575;
                } else if (this.zzh && zzitVar2.zzd != zzjt.zza) {
                    i54 = zziu.zza(i56, bArr, i15, i6, t5, this.zzg, this.zzp, zzitVar);
                    bArr2 = bArr;
                    zzitVar10 = zzitVar2;
                    i58 = i14;
                    i55 = i18;
                    i56 = i56;
                    i57 = i16;
                    i59 = i17;
                    i52 = i6;
                    unsafe8 = unsafe2;
                } else {
                    int i99 = i56;
                    i54 = zziu.zza(i99, bArr, i15, i6, zzc(t5), zzitVar);
                    bArr2 = bArr;
                    zzitVar10 = zzitVar;
                    i52 = i6;
                    unsafe8 = unsafe2;
                    i53 = i53;
                    i58 = i14;
                    i55 = i18;
                    i56 = i99;
                    i57 = i16;
                    i59 = i17;
                }
            } else {
                i8 = i52;
                int i100 = i57;
                int i101 = i59;
                i9 = 1048575;
                unsafe = unsafe8;
                i10 = i53;
                i11 = i100;
                i12 = i101;
            }
        }
        if (i12 != i9) {
            unsafe.putInt(t6, i12, i11);
        }
        zzmx zzmxVar = null;
        for (int i102 = this.zzl; i102 < this.zzm; i102++) {
            zzmxVar = (zzmx) zza((Object) t5, this.zzk[i102], (int) zzmxVar, (zzmu<UT, int>) this.zzp, (Object) t5);
        }
        if (zzmxVar != null) {
            this.zzp.zzb((Object) t6, (T) zzmxVar);
        }
        if (i10 == 0) {
            if (i54 != i8) {
                throw zzkp.zzg();
            }
        } else if (i54 > i8 || i56 != i10) {
            throw zzkp.zzg();
        }
        return i54;
    }

    private final int zza(int i5) {
        if (i5 < this.zze || i5 > this.zzf) {
            return -1;
        }
        return zza(i5, 0);
    }

    private final int zza(int i5, int i6) {
        int length = (this.zzc.length / 3) - 1;
        while (i6 <= length) {
            int i7 = (length + i6) >>> 1;
            int i8 = i7 * 3;
            int i9 = this.zzc[i8];
            if (i5 == i9) {
                return i8;
            }
            if (i5 < i9) {
                length = i7 - 1;
            } else {
                i6 = i7 + 1;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:113:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0399  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0269  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static <T> zzlq<T> zza(Class<T> cls, zzlk zzlkVar, zzlu zzluVar, zzkw zzkwVar, zzmu<?, ?> zzmuVar, zzjv<?> zzjvVar, zzlj zzljVar) {
        int i5;
        int charAt;
        int charAt2;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int[] iArr;
        int i11;
        char charAt3;
        int i12;
        char charAt4;
        int i13;
        char charAt5;
        int i14;
        char charAt6;
        int i15;
        char charAt7;
        int i16;
        char charAt8;
        int i17;
        char charAt9;
        int i18;
        char charAt10;
        int i19;
        int i20;
        int i21;
        int i22;
        zzmc zzmcVar;
        int i23;
        int objectFieldOffset;
        int i24;
        String str;
        int i25;
        int i26;
        int i27;
        Field zza2;
        int i28;
        char charAt11;
        int i29;
        int i30;
        int i31;
        Object obj;
        Field zza3;
        Object obj2;
        Field zza4;
        int i32;
        char charAt12;
        int i33;
        char charAt13;
        int i34;
        char charAt14;
        int i35;
        char charAt15;
        if (zzlkVar instanceof zzmc) {
            zzmc zzmcVar2 = (zzmc) zzlkVar;
            String zzd = zzmcVar2.zzd();
            int length = zzd.length();
            char c5 = 55296;
            if (zzd.charAt(0) >= 55296) {
                int i36 = 1;
                while (true) {
                    i5 = i36 + 1;
                    if (zzd.charAt(i36) < 55296) {
                        break;
                    }
                    i36 = i5;
                }
            } else {
                i5 = 1;
            }
            int i37 = i5 + 1;
            int charAt16 = zzd.charAt(i5);
            if (charAt16 >= 55296) {
                int i38 = charAt16 & 8191;
                int i39 = 13;
                while (true) {
                    i35 = i37 + 1;
                    charAt15 = zzd.charAt(i37);
                    if (charAt15 < 55296) {
                        break;
                    }
                    i38 |= (charAt15 & 8191) << i39;
                    i39 += 13;
                    i37 = i35;
                }
                charAt16 = i38 | (charAt15 << i39);
                i37 = i35;
            }
            if (charAt16 == 0) {
                i10 = 0;
                charAt = 0;
                charAt2 = 0;
                i9 = 0;
                i8 = 0;
                i7 = 0;
                iArr = zza;
                i6 = 0;
            } else {
                int i40 = i37 + 1;
                int charAt17 = zzd.charAt(i37);
                if (charAt17 >= 55296) {
                    int i41 = charAt17 & 8191;
                    int i42 = 13;
                    while (true) {
                        i18 = i40 + 1;
                        charAt10 = zzd.charAt(i40);
                        if (charAt10 < 55296) {
                            break;
                        }
                        i41 |= (charAt10 & 8191) << i42;
                        i42 += 13;
                        i40 = i18;
                    }
                    charAt17 = i41 | (charAt10 << i42);
                    i40 = i18;
                }
                int i43 = i40 + 1;
                int charAt18 = zzd.charAt(i40);
                if (charAt18 >= 55296) {
                    int i44 = charAt18 & 8191;
                    int i45 = 13;
                    while (true) {
                        i17 = i43 + 1;
                        charAt9 = zzd.charAt(i43);
                        if (charAt9 < 55296) {
                            break;
                        }
                        i44 |= (charAt9 & 8191) << i45;
                        i45 += 13;
                        i43 = i17;
                    }
                    charAt18 = i44 | (charAt9 << i45);
                    i43 = i17;
                }
                int i46 = i43 + 1;
                int charAt19 = zzd.charAt(i43);
                if (charAt19 >= 55296) {
                    int i47 = charAt19 & 8191;
                    int i48 = 13;
                    while (true) {
                        i16 = i46 + 1;
                        charAt8 = zzd.charAt(i46);
                        if (charAt8 < 55296) {
                            break;
                        }
                        i47 |= (charAt8 & 8191) << i48;
                        i48 += 13;
                        i46 = i16;
                    }
                    charAt19 = i47 | (charAt8 << i48);
                    i46 = i16;
                }
                int i49 = i46 + 1;
                int charAt20 = zzd.charAt(i46);
                if (charAt20 >= 55296) {
                    int i50 = charAt20 & 8191;
                    int i51 = 13;
                    while (true) {
                        i15 = i49 + 1;
                        charAt7 = zzd.charAt(i49);
                        if (charAt7 < 55296) {
                            break;
                        }
                        i50 |= (charAt7 & 8191) << i51;
                        i51 += 13;
                        i49 = i15;
                    }
                    charAt20 = i50 | (charAt7 << i51);
                    i49 = i15;
                }
                int i52 = i49 + 1;
                charAt = zzd.charAt(i49);
                if (charAt >= 55296) {
                    int i53 = charAt & 8191;
                    int i54 = 13;
                    while (true) {
                        i14 = i52 + 1;
                        charAt6 = zzd.charAt(i52);
                        if (charAt6 < 55296) {
                            break;
                        }
                        i53 |= (charAt6 & 8191) << i54;
                        i54 += 13;
                        i52 = i14;
                    }
                    charAt = i53 | (charAt6 << i54);
                    i52 = i14;
                }
                int i55 = i52 + 1;
                charAt2 = zzd.charAt(i52);
                if (charAt2 >= 55296) {
                    int i56 = charAt2 & 8191;
                    int i57 = 13;
                    while (true) {
                        i13 = i55 + 1;
                        charAt5 = zzd.charAt(i55);
                        if (charAt5 < 55296) {
                            break;
                        }
                        i56 |= (charAt5 & 8191) << i57;
                        i57 += 13;
                        i55 = i13;
                    }
                    charAt2 = i56 | (charAt5 << i57);
                    i55 = i13;
                }
                int i58 = i55 + 1;
                int charAt21 = zzd.charAt(i55);
                if (charAt21 >= 55296) {
                    int i59 = charAt21 & 8191;
                    int i60 = 13;
                    while (true) {
                        i12 = i58 + 1;
                        charAt4 = zzd.charAt(i58);
                        if (charAt4 < 55296) {
                            break;
                        }
                        i59 |= (charAt4 & 8191) << i60;
                        i60 += 13;
                        i58 = i12;
                    }
                    charAt21 = i59 | (charAt4 << i60);
                    i58 = i12;
                }
                int i61 = i58 + 1;
                int charAt22 = zzd.charAt(i58);
                if (charAt22 >= 55296) {
                    int i62 = charAt22 & 8191;
                    int i63 = 13;
                    while (true) {
                        i11 = i61 + 1;
                        charAt3 = zzd.charAt(i61);
                        if (charAt3 < 55296) {
                            break;
                        }
                        i62 |= (charAt3 & 8191) << i63;
                        i63 += 13;
                        i61 = i11;
                    }
                    charAt22 = i62 | (charAt3 << i63);
                    i61 = i11;
                }
                int[] iArr2 = new int[charAt22 + charAt2 + charAt21];
                int i64 = (charAt17 << 1) + charAt18;
                i6 = charAt17;
                i7 = charAt22;
                i37 = i61;
                i8 = charAt20;
                i9 = charAt19;
                i10 = i64;
                iArr = iArr2;
            }
            Unsafe unsafe = zzb;
            Object[] zze = zzmcVar2.zze();
            Class<?> cls2 = zzmcVar2.zza().getClass();
            int[] iArr3 = new int[charAt * 3];
            Object[] objArr = new Object[charAt << 1];
            int i65 = i7 + charAt2;
            int i66 = i7;
            int i67 = i65;
            int i68 = 0;
            int i69 = 0;
            while (i37 < length) {
                int i70 = i37 + 1;
                int charAt23 = zzd.charAt(i37);
                if (charAt23 >= c5) {
                    int i71 = charAt23 & 8191;
                    int i72 = i70;
                    int i73 = 13;
                    while (true) {
                        i34 = i72 + 1;
                        charAt14 = zzd.charAt(i72);
                        if (charAt14 < c5) {
                            break;
                        }
                        i71 |= (charAt14 & 8191) << i73;
                        i73 += 13;
                        i72 = i34;
                    }
                    charAt23 = i71 | (charAt14 << i73);
                    i19 = i34;
                } else {
                    i19 = i70;
                }
                int i74 = i19 + 1;
                int charAt24 = zzd.charAt(i19);
                if (charAt24 >= c5) {
                    int i75 = charAt24 & 8191;
                    int i76 = i74;
                    int i77 = 13;
                    while (true) {
                        i33 = i76 + 1;
                        charAt13 = zzd.charAt(i76);
                        i20 = length;
                        if (charAt13 < 55296) {
                            break;
                        }
                        i75 |= (charAt13 & 8191) << i77;
                        i77 += 13;
                        i76 = i33;
                        length = i20;
                    }
                    charAt24 = i75 | (charAt13 << i77);
                    i21 = i33;
                } else {
                    i20 = length;
                    i21 = i74;
                }
                int i78 = charAt24 & Function.USE_VARARGS;
                int i79 = i8;
                if ((charAt24 & 1024) != 0) {
                    iArr[i69] = i68;
                    i69++;
                }
                int i80 = i9;
                if (i78 >= 51) {
                    int i81 = i21 + 1;
                    int charAt25 = zzd.charAt(i21);
                    char c6 = 55296;
                    if (charAt25 >= 55296) {
                        int i82 = charAt25 & 8191;
                        int i83 = 13;
                        while (true) {
                            i32 = i81 + 1;
                            charAt12 = zzd.charAt(i81);
                            if (charAt12 < c6) {
                                break;
                            }
                            i82 |= (charAt12 & 8191) << i83;
                            i83 += 13;
                            i81 = i32;
                            c6 = 55296;
                        }
                        charAt25 = i82 | (charAt12 << i83);
                        i81 = i32;
                    }
                    int i84 = i78 - 51;
                    int i85 = i81;
                    if (i84 != 9 && i84 != 17) {
                        if (i84 == 12 && (zzmcVar2.zzb().equals(zzmb.PROTO2) || (charAt24 & 2048) != 0)) {
                            i30 = 1;
                            i31 = i10 + 1;
                            objArr[((i68 / 3) << 1) + 1] = zze[i10];
                        } else {
                            i30 = 1;
                            int i86 = charAt25 << i30;
                            obj = zze[i86];
                            if (!(obj instanceof Field)) {
                                zza3 = (Field) obj;
                            } else {
                                zza3 = zza(cls2, (String) obj);
                                zze[i86] = zza3;
                            }
                            int objectFieldOffset2 = (int) unsafe.objectFieldOffset(zza3);
                            int i87 = i86 + 1;
                            obj2 = zze[i87];
                            int i88 = i10;
                            if (!(obj2 instanceof Field)) {
                                zza4 = (Field) obj2;
                            } else {
                                zza4 = zza(cls2, (String) obj2);
                                zze[i87] = zza4;
                            }
                            i25 = (int) unsafe.objectFieldOffset(zza4);
                            str = zzd;
                            objectFieldOffset = objectFieldOffset2;
                            i24 = i88;
                            i27 = 0;
                            zzmcVar = zzmcVar2;
                            i22 = charAt23;
                            i26 = i85;
                        }
                    } else {
                        i30 = 1;
                        i31 = i10 + 1;
                        objArr[((i68 / 3) << 1) + 1] = zze[i10];
                    }
                    i10 = i31;
                    int i862 = charAt25 << i30;
                    obj = zze[i862];
                    if (!(obj instanceof Field)) {
                    }
                    int objectFieldOffset22 = (int) unsafe.objectFieldOffset(zza3);
                    int i872 = i862 + 1;
                    obj2 = zze[i872];
                    int i882 = i10;
                    if (!(obj2 instanceof Field)) {
                    }
                    i25 = (int) unsafe.objectFieldOffset(zza4);
                    str = zzd;
                    objectFieldOffset = objectFieldOffset22;
                    i24 = i882;
                    i27 = 0;
                    zzmcVar = zzmcVar2;
                    i22 = charAt23;
                    i26 = i85;
                } else {
                    int i89 = i10 + 1;
                    Field zza5 = zza(cls2, (String) zze[i10]);
                    i22 = charAt23;
                    if (i78 == 9 || i78 == 17) {
                        zzmcVar = zzmcVar2;
                        objArr[((i68 / 3) << 1) + 1] = zza5.getType();
                    } else {
                        if (i78 == 27 || i78 == 49) {
                            zzmcVar = zzmcVar2;
                            i29 = i10 + 2;
                            objArr[((i68 / 3) << 1) + 1] = zze[i89];
                        } else if (i78 == 12 || i78 == 30 || i78 == 44) {
                            zzmcVar = zzmcVar2;
                            if (zzmcVar2.zzb() == zzmb.PROTO2 || (charAt24 & 2048) != 0) {
                                i29 = i10 + 2;
                                objArr[((i68 / 3) << 1) + 1] = zze[i89];
                            }
                        } else if (i78 == 50) {
                            int i90 = i66 + 1;
                            iArr[i66] = i68;
                            int i91 = (i68 / 3) << 1;
                            int i92 = i10 + 2;
                            objArr[i91] = zze[i89];
                            if ((charAt24 & 2048) != 0) {
                                i89 = i10 + 3;
                                objArr[i91 + 1] = zze[i92];
                                zzmcVar = zzmcVar2;
                                i66 = i90;
                            } else {
                                i66 = i90;
                                zzmcVar = zzmcVar2;
                                i23 = i92;
                                objectFieldOffset = (int) unsafe.objectFieldOffset(zza5);
                                if ((charAt24 & 4096) != 0 || i78 > 17) {
                                    i24 = i23;
                                    str = zzd;
                                    i25 = 1048575;
                                    i26 = i21;
                                    i27 = 0;
                                } else {
                                    i26 = i21 + 1;
                                    int charAt26 = zzd.charAt(i21);
                                    if (charAt26 >= 55296) {
                                        int i93 = charAt26 & 8191;
                                        int i94 = 13;
                                        while (true) {
                                            i28 = i26 + 1;
                                            charAt11 = zzd.charAt(i26);
                                            if (charAt11 < 55296) {
                                                break;
                                            }
                                            i93 |= (charAt11 & 8191) << i94;
                                            i94 += 13;
                                            i26 = i28;
                                        }
                                        charAt26 = i93 | (charAt11 << i94);
                                        i26 = i28;
                                    }
                                    int i95 = (i6 << 1) + (charAt26 / 32);
                                    Object obj3 = zze[i95];
                                    if (obj3 instanceof Field) {
                                        zza2 = (Field) obj3;
                                    } else {
                                        zza2 = zza(cls2, (String) obj3);
                                        zze[i95] = zza2;
                                    }
                                    i24 = i23;
                                    str = zzd;
                                    i27 = charAt26 % 32;
                                    i25 = (int) unsafe.objectFieldOffset(zza2);
                                }
                                if (i78 >= 18 && i78 <= 49) {
                                    iArr[i67] = objectFieldOffset;
                                    i67++;
                                }
                            }
                        } else {
                            zzmcVar = zzmcVar2;
                        }
                        i23 = i29;
                        objectFieldOffset = (int) unsafe.objectFieldOffset(zza5);
                        if ((charAt24 & 4096) != 0) {
                        }
                        i24 = i23;
                        str = zzd;
                        i25 = 1048575;
                        i26 = i21;
                        i27 = 0;
                        if (i78 >= 18) {
                            iArr[i67] = objectFieldOffset;
                            i67++;
                        }
                    }
                    i23 = i89;
                    objectFieldOffset = (int) unsafe.objectFieldOffset(zza5);
                    if ((charAt24 & 4096) != 0) {
                    }
                    i24 = i23;
                    str = zzd;
                    i25 = 1048575;
                    i26 = i21;
                    i27 = 0;
                    if (i78 >= 18) {
                    }
                }
                int i96 = i68 + 1;
                iArr3[i68] = i22;
                int i97 = i68 + 2;
                Class<?> cls3 = cls2;
                int i98 = i26;
                iArr3[i96] = ((charAt24 & 512) != 0 ? 536870912 : 0) | ((charAt24 & 256) != 0 ? 268435456 : 0) | ((charAt24 & 2048) != 0 ? Integer.MIN_VALUE : 0) | (i78 << 20) | objectFieldOffset;
                i68 += 3;
                iArr3[i97] = (i27 << 20) | i25;
                zzd = str;
                i8 = i79;
                i10 = i24;
                zzmcVar2 = zzmcVar;
                length = i20;
                i9 = i80;
                cls2 = cls3;
                i37 = i98;
                c5 = 55296;
            }
            return new zzlq<>(iArr3, objArr, i9, i8, zzmcVar2.zza(), false, iArr, i7, i65, zzluVar, zzkwVar, zzmuVar, zzjvVar, zzljVar);
        }
        android.support.v4.media.session.a.a(zzlkVar);
        throw new NoSuchMethodError();
    }

    private final <UT, UB> UB zza(Object obj, int i5, UB ub, zzmu<UT, UB> zzmuVar, Object obj2) {
        zzkl zzd;
        int i6 = this.zzc[i5];
        Object zze = zzmz.zze(obj, zzc(i5) & 1048575);
        return (zze == null || (zzd = zzd(i5)) == null) ? ub : (UB) zza(i5, i6, this.zzr.zze(zze), zzd, (zzkl) ub, (zzmu<UT, zzkl>) zzmuVar, obj2);
    }

    private final <K, V, UT, UB> UB zza(int i5, int i6, Map<K, V> map, zzkl zzklVar, UB ub, zzmu<UT, UB> zzmuVar, Object obj) {
        this.zzr.zza(zzf(i5));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!zzklVar.zza(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = zzmuVar.zzc(obj);
                }
                zzjd zzc = zziy.zzc(zzle.zza(null, next.getKey(), next.getValue()));
                try {
                    zzle.zza(zzc.zzb(), null, next.getKey(), next.getValue());
                    zzmuVar.zza(ub, i6, zzc.zza());
                    it.remove();
                } catch (IOException e5) {
                    throw new RuntimeException(e5);
                }
            }
        }
        return ub;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object zza(T t5, int i5) {
        zzme zze = zze(i5);
        long zzc = zzc(i5) & 1048575;
        if (!zzc((zzlq<T>) t5, i5)) {
            return zze.zza();
        }
        Object object = zzb.getObject(t5, zzc);
        if (zzg(object)) {
            return object;
        }
        Object zza2 = zze.zza();
        if (object != null) {
            zze.zza(zza2, object);
        }
        return zza2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object zza(T t5, int i5, int i6) {
        zzme zze = zze(i6);
        if (!zzc((zzlq<T>) t5, i5, i6)) {
            return zze.zza();
        }
        Object object = zzb.getObject(t5, zzc(i6) & 1048575);
        if (zzg(object)) {
            return object;
        }
        Object zza2 = zze.zza();
        if (object != null) {
            zze.zza(zza2, object);
        }
        return zza2;
    }

    @Override // com.google.android.gms.internal.measurement.zzme
    public final T zza() {
        return (T) this.zzn.zza(this.zzg);
    }

    private static Field zza(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzme
    public final void zza(T t5, T t6) {
        zzf(t5);
        t6.getClass();
        for (int i5 = 0; i5 < this.zzc.length; i5 += 3) {
            int zzc = zzc(i5);
            long j5 = 1048575 & zzc;
            int i6 = this.zzc[i5];
            switch ((zzc & 267386880) >>> 20) {
                case 0:
                    if (zzc((zzlq<T>) t6, i5)) {
                        zzmz.zza(t5, j5, zzmz.zza(t6, j5));
                        zzb((zzlq<T>) t5, i5);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zzc((zzlq<T>) t6, i5)) {
                        zzmz.zza((Object) t5, j5, zzmz.zzb(t6, j5));
                        zzb((zzlq<T>) t5, i5);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zzc((zzlq<T>) t6, i5)) {
                        zzmz.zza((Object) t5, j5, zzmz.zzd(t6, j5));
                        zzb((zzlq<T>) t5, i5);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zzc((zzlq<T>) t6, i5)) {
                        zzmz.zza((Object) t5, j5, zzmz.zzd(t6, j5));
                        zzb((zzlq<T>) t5, i5);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zzc((zzlq<T>) t6, i5)) {
                        zzmz.zza((Object) t5, j5, zzmz.zzc(t6, j5));
                        zzb((zzlq<T>) t5, i5);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zzc((zzlq<T>) t6, i5)) {
                        zzmz.zza((Object) t5, j5, zzmz.zzd(t6, j5));
                        zzb((zzlq<T>) t5, i5);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zzc((zzlq<T>) t6, i5)) {
                        zzmz.zza((Object) t5, j5, zzmz.zzc(t6, j5));
                        zzb((zzlq<T>) t5, i5);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zzc((zzlq<T>) t6, i5)) {
                        zzmz.zzc(t5, j5, zzmz.zzh(t6, j5));
                        zzb((zzlq<T>) t5, i5);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (zzc((zzlq<T>) t6, i5)) {
                        zzmz.zza(t5, j5, zzmz.zze(t6, j5));
                        zzb((zzlq<T>) t5, i5);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    zza(t5, t6, i5);
                    break;
                case 10:
                    if (zzc((zzlq<T>) t6, i5)) {
                        zzmz.zza(t5, j5, zzmz.zze(t6, j5));
                        zzb((zzlq<T>) t5, i5);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zzc((zzlq<T>) t6, i5)) {
                        zzmz.zza((Object) t5, j5, zzmz.zzc(t6, j5));
                        zzb((zzlq<T>) t5, i5);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zzc((zzlq<T>) t6, i5)) {
                        zzmz.zza((Object) t5, j5, zzmz.zzc(t6, j5));
                        zzb((zzlq<T>) t5, i5);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zzc((zzlq<T>) t6, i5)) {
                        zzmz.zza((Object) t5, j5, zzmz.zzc(t6, j5));
                        zzb((zzlq<T>) t5, i5);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zzc((zzlq<T>) t6, i5)) {
                        zzmz.zza((Object) t5, j5, zzmz.zzd(t6, j5));
                        zzb((zzlq<T>) t5, i5);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zzc((zzlq<T>) t6, i5)) {
                        zzmz.zza((Object) t5, j5, zzmz.zzc(t6, j5));
                        zzb((zzlq<T>) t5, i5);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zzc((zzlq<T>) t6, i5)) {
                        zzmz.zza((Object) t5, j5, zzmz.zzd(t6, j5));
                        zzb((zzlq<T>) t5, i5);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    zza(t5, t6, i5);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case R$styleable.Toolbar_titleMarginBottom /* 23 */:
                case R$styleable.Toolbar_titleMarginEnd /* 24 */:
                case 25:
                case 26:
                case 27:
                case 28:
                case R$styleable.Toolbar_titleTextColor /* 29 */:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.zzo.zza(t5, t6, j5);
                    break;
                case 50:
                    zzmg.zza(this.zzr, t5, t6, j5);
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (zzc((zzlq<T>) t6, i6, i5)) {
                        zzmz.zza(t5, j5, zzmz.zze(t6, j5));
                        zzb((zzlq<T>) t5, i6, i5);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    zzb(t5, t6, i5);
                    break;
                case 61:
                case 62:
                case Function.ALT_CONVENTION /* 63 */:
                case Function.THROW_LAST_ERROR /* 64 */:
                case 65:
                case 66:
                case 67:
                    if (zzc((zzlq<T>) t6, i6, i5)) {
                        zzmz.zza(t5, j5, zzmz.zze(t6, j5));
                        zzb((zzlq<T>) t5, i6, i5);
                        break;
                    } else {
                        break;
                    }
                case 68:
                    zzb(t5, t6, i5);
                    break;
            }
        }
        zzmg.zza(this.zzp, t5, t6);
        if (this.zzh) {
            zzmg.zza(this.zzq, t5, t6);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzme
    public final void zza(T t5, byte[] bArr, int i5, int i6, zzit zzitVar) {
        zza(t5, bArr, i5, i6, 0, zzitVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void zza(T t5, T t6, int i5) {
        if (zzc((zzlq<T>) t6, i5)) {
            long zzc = zzc(i5) & 1048575;
            Unsafe unsafe = zzb;
            Object object = unsafe.getObject(t6, zzc);
            if (object != null) {
                zzme zze = zze(i5);
                if (!zzc((zzlq<T>) t5, i5)) {
                    if (!zzg(object)) {
                        unsafe.putObject(t5, zzc, object);
                    } else {
                        Object zza2 = zze.zza();
                        zze.zza(zza2, object);
                        unsafe.putObject(t5, zzc, zza2);
                    }
                    zzb((zzlq<T>) t5, i5);
                    return;
                }
                Object object2 = unsafe.getObject(t5, zzc);
                if (!zzg(object2)) {
                    Object zza3 = zze.zza();
                    zze.zza(zza3, object2);
                    unsafe.putObject(t5, zzc, zza3);
                    object2 = zza3;
                }
                zze.zza(object2, object);
                return;
            }
            throw new IllegalStateException("Source subfield " + this.zzc[i5] + " is present but null: " + String.valueOf(t6));
        }
    }

    private final void zza(T t5, int i5, Object obj) {
        zzb.putObject(t5, zzc(i5) & 1048575, obj);
        zzb((zzlq<T>) t5, i5);
    }

    private final void zza(T t5, int i5, int i6, Object obj) {
        zzb.putObject(t5, zzc(i6) & 1048575, obj);
        zzb((zzlq<T>) t5, i5, i6);
    }

    private final <K, V> void zza(zznl zznlVar, int i5, Object obj, int i6) {
        if (obj != null) {
            this.zzr.zza(zzf(i6));
            zznlVar.zza(i5, (zzlh) null, this.zzr.zzd(obj));
        }
    }

    private static void zza(int i5, Object obj, zznl zznlVar) {
        if (obj instanceof String) {
            zznlVar.zza(i5, (String) obj);
        } else {
            zznlVar.zza(i5, (zziy) obj);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:320:0x05b5. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:10:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x0517  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x0556  */
    /* JADX WARN: Removed duplicated region for block: B:511:0x0b90  */
    @Override // com.google.android.gms.internal.measurement.zzme
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zza(T t5, zznl zznlVar) {
        Map.Entry<?, ?> entry;
        Iterator<Map.Entry<?, Object>> it;
        int length;
        int i5;
        Iterator<Map.Entry<?, Object>> it2;
        int i6;
        Map.Entry<?, ?> entry2;
        int i7;
        int i8;
        int i9;
        Map.Entry<?, ?> entry3;
        int i10;
        boolean z5;
        int i11;
        Unsafe unsafe;
        boolean z6;
        Iterator<Map.Entry<?, Object>> it3;
        Map.Entry<?, ?> entry4;
        int length2;
        zznl zznlVar2 = zznlVar;
        int i12 = 267386880;
        int i13 = 1048575;
        if (zznlVar.zza() == 2) {
            zza(this.zzp, t5, zznlVar2);
            if (this.zzh) {
                zzjw<?> zza2 = this.zzq.zza(t5);
                if (!zza2.zza.isEmpty()) {
                    it3 = zza2.zzc();
                    entry4 = (Map.Entry) it3.next();
                    for (length2 = this.zzc.length - 3; length2 >= 0; length2 -= 3) {
                        int zzc = zzc(length2);
                        int i14 = this.zzc[length2];
                        while (entry4 != null && this.zzq.zza(entry4) > i14) {
                            this.zzq.zza(zznlVar2, entry4);
                            entry4 = it3.hasNext() ? (Map.Entry) it3.next() : null;
                        }
                        switch ((zzc & 267386880) >>> 20) {
                            case 0:
                                if (zzc((zzlq<T>) t5, length2)) {
                                    zznlVar2.zza(i14, zzmz.zza(t5, zzc & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 1:
                                if (zzc((zzlq<T>) t5, length2)) {
                                    zznlVar2.zza(i14, zzmz.zzb(t5, zzc & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 2:
                                if (zzc((zzlq<T>) t5, length2)) {
                                    zznlVar2.zzb(i14, zzmz.zzd(t5, zzc & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 3:
                                if (zzc((zzlq<T>) t5, length2)) {
                                    zznlVar2.zze(i14, zzmz.zzd(t5, zzc & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 4:
                                if (zzc((zzlq<T>) t5, length2)) {
                                    zznlVar2.zzc(i14, zzmz.zzc(t5, zzc & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 5:
                                if (zzc((zzlq<T>) t5, length2)) {
                                    zznlVar2.zza(i14, zzmz.zzd(t5, zzc & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 6:
                                if (zzc((zzlq<T>) t5, length2)) {
                                    zznlVar2.zzb(i14, zzmz.zzc(t5, zzc & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 7:
                                if (zzc((zzlq<T>) t5, length2)) {
                                    zznlVar2.zza(i14, zzmz.zzh(t5, zzc & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 8:
                                if (zzc((zzlq<T>) t5, length2)) {
                                    zza(i14, zzmz.zze(t5, zzc & 1048575), zznlVar2);
                                    break;
                                } else {
                                    break;
                                }
                            case 9:
                                if (zzc((zzlq<T>) t5, length2)) {
                                    zznlVar2.zzb(i14, zzmz.zze(t5, zzc & 1048575), zze(length2));
                                    break;
                                } else {
                                    break;
                                }
                            case 10:
                                if (zzc((zzlq<T>) t5, length2)) {
                                    zznlVar2.zza(i14, (zziy) zzmz.zze(t5, zzc & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 11:
                                if (zzc((zzlq<T>) t5, length2)) {
                                    zznlVar2.zzf(i14, zzmz.zzc(t5, zzc & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 12:
                                if (zzc((zzlq<T>) t5, length2)) {
                                    zznlVar2.zza(i14, zzmz.zzc(t5, zzc & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 13:
                                if (zzc((zzlq<T>) t5, length2)) {
                                    zznlVar2.zzd(i14, zzmz.zzc(t5, zzc & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 14:
                                if (zzc((zzlq<T>) t5, length2)) {
                                    zznlVar2.zzc(i14, zzmz.zzd(t5, zzc & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 15:
                                if (zzc((zzlq<T>) t5, length2)) {
                                    zznlVar2.zze(i14, zzmz.zzc(t5, zzc & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 16:
                                if (zzc((zzlq<T>) t5, length2)) {
                                    zznlVar2.zzd(i14, zzmz.zzd(t5, zzc & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 17:
                                if (zzc((zzlq<T>) t5, length2)) {
                                    zznlVar2.zza(i14, zzmz.zze(t5, zzc & 1048575), zze(length2));
                                    break;
                                } else {
                                    break;
                                }
                            case 18:
                                zzmg.zzb(this.zzc[length2], (List<Double>) zzmz.zze(t5, zzc & 1048575), zznlVar2, false);
                                break;
                            case 19:
                                zzmg.zzf(this.zzc[length2], (List) zzmz.zze(t5, zzc & 1048575), zznlVar2, false);
                                break;
                            case 20:
                                zzmg.zzh(this.zzc[length2], (List) zzmz.zze(t5, zzc & 1048575), zznlVar2, false);
                                break;
                            case 21:
                                zzmg.zzn(this.zzc[length2], (List) zzmz.zze(t5, zzc & 1048575), zznlVar2, false);
                                break;
                            case 22:
                                zzmg.zzg(this.zzc[length2], (List) zzmz.zze(t5, zzc & 1048575), zznlVar2, false);
                                break;
                            case R$styleable.Toolbar_titleMarginBottom /* 23 */:
                                zzmg.zze(this.zzc[length2], (List) zzmz.zze(t5, zzc & 1048575), zznlVar2, false);
                                break;
                            case R$styleable.Toolbar_titleMarginEnd /* 24 */:
                                zzmg.zzd(this.zzc[length2], (List) zzmz.zze(t5, zzc & 1048575), zznlVar2, false);
                                break;
                            case 25:
                                zzmg.zza(this.zzc[length2], (List<Boolean>) zzmz.zze(t5, zzc & 1048575), zznlVar2, false);
                                break;
                            case 26:
                                zzmg.zzb(this.zzc[length2], (List<String>) zzmz.zze(t5, zzc & 1048575), zznlVar2);
                                break;
                            case 27:
                                zzmg.zzb(this.zzc[length2], (List<?>) zzmz.zze(t5, zzc & 1048575), zznlVar2, (zzme<?>) zze(length2));
                                break;
                            case 28:
                                zzmg.zza(this.zzc[length2], (List<zziy>) zzmz.zze(t5, zzc & 1048575), zznlVar2);
                                break;
                            case R$styleable.Toolbar_titleTextColor /* 29 */:
                                zzmg.zzm(this.zzc[length2], (List) zzmz.zze(t5, zzc & 1048575), zznlVar2, false);
                                break;
                            case 30:
                                zzmg.zzc(this.zzc[length2], (List) zzmz.zze(t5, zzc & 1048575), zznlVar2, false);
                                break;
                            case 31:
                                zzmg.zzi(this.zzc[length2], (List) zzmz.zze(t5, zzc & 1048575), zznlVar2, false);
                                break;
                            case 32:
                                zzmg.zzj(this.zzc[length2], (List) zzmz.zze(t5, zzc & 1048575), zznlVar2, false);
                                break;
                            case 33:
                                zzmg.zzk(this.zzc[length2], (List) zzmz.zze(t5, zzc & 1048575), zznlVar2, false);
                                break;
                            case 34:
                                zzmg.zzl(this.zzc[length2], (List) zzmz.zze(t5, zzc & 1048575), zznlVar2, false);
                                break;
                            case 35:
                                zzmg.zzb(this.zzc[length2], (List<Double>) zzmz.zze(t5, zzc & 1048575), zznlVar2, true);
                                break;
                            case 36:
                                zzmg.zzf(this.zzc[length2], (List) zzmz.zze(t5, zzc & 1048575), zznlVar2, true);
                                break;
                            case 37:
                                zzmg.zzh(this.zzc[length2], (List) zzmz.zze(t5, zzc & 1048575), zznlVar2, true);
                                break;
                            case 38:
                                zzmg.zzn(this.zzc[length2], (List) zzmz.zze(t5, zzc & 1048575), zznlVar2, true);
                                break;
                            case 39:
                                zzmg.zzg(this.zzc[length2], (List) zzmz.zze(t5, zzc & 1048575), zznlVar2, true);
                                break;
                            case 40:
                                zzmg.zze(this.zzc[length2], (List) zzmz.zze(t5, zzc & 1048575), zznlVar2, true);
                                break;
                            case 41:
                                zzmg.zzd(this.zzc[length2], (List) zzmz.zze(t5, zzc & 1048575), zznlVar2, true);
                                break;
                            case 42:
                                zzmg.zza(this.zzc[length2], (List<Boolean>) zzmz.zze(t5, zzc & 1048575), zznlVar2, true);
                                break;
                            case 43:
                                zzmg.zzm(this.zzc[length2], (List) zzmz.zze(t5, zzc & 1048575), zznlVar2, true);
                                break;
                            case 44:
                                zzmg.zzc(this.zzc[length2], (List) zzmz.zze(t5, zzc & 1048575), zznlVar2, true);
                                break;
                            case 45:
                                zzmg.zzi(this.zzc[length2], (List) zzmz.zze(t5, zzc & 1048575), zznlVar2, true);
                                break;
                            case 46:
                                zzmg.zzj(this.zzc[length2], (List) zzmz.zze(t5, zzc & 1048575), zznlVar2, true);
                                break;
                            case 47:
                                zzmg.zzk(this.zzc[length2], (List) zzmz.zze(t5, zzc & 1048575), zznlVar2, true);
                                break;
                            case 48:
                                zzmg.zzl(this.zzc[length2], (List) zzmz.zze(t5, zzc & 1048575), zznlVar2, true);
                                break;
                            case 49:
                                zzmg.zza(this.zzc[length2], (List<?>) zzmz.zze(t5, zzc & 1048575), zznlVar2, (zzme<?>) zze(length2));
                                break;
                            case 50:
                                zza(zznlVar2, i14, zzmz.zze(t5, zzc & 1048575), length2);
                                break;
                            case 51:
                                if (zzc((zzlq<T>) t5, i14, length2)) {
                                    zznlVar2.zza(i14, zza(t5, zzc & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 52:
                                if (zzc((zzlq<T>) t5, i14, length2)) {
                                    zznlVar2.zza(i14, zzb(t5, zzc & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 53:
                                if (zzc((zzlq<T>) t5, i14, length2)) {
                                    zznlVar2.zzb(i14, zzd(t5, zzc & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 54:
                                if (zzc((zzlq<T>) t5, i14, length2)) {
                                    zznlVar2.zze(i14, zzd(t5, zzc & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 55:
                                if (zzc((zzlq<T>) t5, i14, length2)) {
                                    zznlVar2.zzc(i14, zzc(t5, zzc & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 56:
                                if (zzc((zzlq<T>) t5, i14, length2)) {
                                    zznlVar2.zza(i14, zzd(t5, zzc & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 57:
                                if (zzc((zzlq<T>) t5, i14, length2)) {
                                    zznlVar2.zzb(i14, zzc(t5, zzc & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 58:
                                if (zzc((zzlq<T>) t5, i14, length2)) {
                                    zznlVar2.zza(i14, zze(t5, zzc & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 59:
                                if (zzc((zzlq<T>) t5, i14, length2)) {
                                    zza(i14, zzmz.zze(t5, zzc & 1048575), zznlVar2);
                                    break;
                                } else {
                                    break;
                                }
                            case 60:
                                if (zzc((zzlq<T>) t5, i14, length2)) {
                                    zznlVar2.zzb(i14, zzmz.zze(t5, zzc & 1048575), zze(length2));
                                    break;
                                } else {
                                    break;
                                }
                            case 61:
                                if (zzc((zzlq<T>) t5, i14, length2)) {
                                    zznlVar2.zza(i14, (zziy) zzmz.zze(t5, zzc & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 62:
                                if (zzc((zzlq<T>) t5, i14, length2)) {
                                    zznlVar2.zzf(i14, zzc(t5, zzc & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case Function.ALT_CONVENTION /* 63 */:
                                if (zzc((zzlq<T>) t5, i14, length2)) {
                                    zznlVar2.zza(i14, zzc(t5, zzc & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case Function.THROW_LAST_ERROR /* 64 */:
                                if (zzc((zzlq<T>) t5, i14, length2)) {
                                    zznlVar2.zzd(i14, zzc(t5, zzc & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 65:
                                if (zzc((zzlq<T>) t5, i14, length2)) {
                                    zznlVar2.zzc(i14, zzd(t5, zzc & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 66:
                                if (zzc((zzlq<T>) t5, i14, length2)) {
                                    zznlVar2.zze(i14, zzc(t5, zzc & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 67:
                                if (zzc((zzlq<T>) t5, i14, length2)) {
                                    zznlVar2.zzd(i14, zzd(t5, zzc & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 68:
                                if (zzc((zzlq<T>) t5, i14, length2)) {
                                    zznlVar2.zza(i14, zzmz.zze(t5, zzc & 1048575), zze(length2));
                                    break;
                                } else {
                                    break;
                                }
                        }
                    }
                    while (entry4 != null) {
                        this.zzq.zza(zznlVar2, entry4);
                        entry4 = it3.hasNext() ? (Map.Entry) it3.next() : null;
                    }
                    return;
                }
            }
            it3 = null;
            entry4 = null;
            while (length2 >= 0) {
            }
            while (entry4 != null) {
            }
            return;
        }
        if (this.zzh) {
            zzjw<?> zza3 = this.zzq.zza(t5);
            if (!zza3.zza.isEmpty()) {
                Iterator<Map.Entry<?, Object>> zzd = zza3.zzd();
                entry = (Map.Entry) zzd.next();
                it = zzd;
                length = this.zzc.length;
                Unsafe unsafe2 = zzb;
                int i15 = 0;
                i5 = 0;
                int i16 = 1048575;
                while (i5 < length) {
                    int zzc2 = zzc(i5);
                    int[] iArr = this.zzc;
                    int i17 = iArr[i5];
                    int i18 = (zzc2 & i12) >>> 20;
                    if (i18 <= 17) {
                        int i19 = iArr[i5 + 2];
                        int i20 = i19 & i13;
                        if (i20 != i16) {
                            if (i20 == i13) {
                                it2 = it;
                                i15 = 0;
                            } else {
                                it2 = it;
                                i15 = unsafe2.getInt(t5, i20);
                            }
                            i16 = i20;
                        } else {
                            it2 = it;
                        }
                        entry2 = entry;
                        i7 = i15;
                        i8 = 1 << (i19 >>> 20);
                        i6 = i16;
                    } else {
                        it2 = it;
                        i6 = i16;
                        entry2 = entry;
                        i7 = i15;
                        i8 = 0;
                    }
                    while (entry2 != null && this.zzq.zza(entry2) <= i17) {
                        this.zzq.zza(zznlVar2, entry2);
                        entry2 = it2.hasNext() ? (Map.Entry) it2.next() : null;
                    }
                    long j5 = zzc2 & 1048575;
                    switch (i18) {
                        case 0:
                            i9 = i6;
                            entry3 = entry2;
                            i10 = length;
                            z5 = false;
                            i11 = i5;
                            unsafe = unsafe2;
                            if (zza((zzlq<T>) t5, i11, i9, i7, i8)) {
                                zznlVar2.zza(i17, zzmz.zza(t5, j5));
                                break;
                            } else {
                                break;
                            }
                        case 1:
                            i9 = i6;
                            entry3 = entry2;
                            i10 = length;
                            z5 = false;
                            i11 = i5;
                            unsafe = unsafe2;
                            if (zza((zzlq<T>) t5, i11, i9, i7, i8)) {
                                zznlVar2.zza(i17, zzmz.zzb(t5, j5));
                                break;
                            } else {
                                break;
                            }
                        case 2:
                            i9 = i6;
                            entry3 = entry2;
                            i10 = length;
                            z5 = false;
                            i11 = i5;
                            unsafe = unsafe2;
                            if (zza((zzlq<T>) t5, i11, i9, i7, i8)) {
                                zznlVar2.zzb(i17, unsafe.getLong(t5, j5));
                                break;
                            } else {
                                break;
                            }
                        case 3:
                            i9 = i6;
                            entry3 = entry2;
                            i10 = length;
                            z5 = false;
                            i11 = i5;
                            unsafe = unsafe2;
                            if (zza((zzlq<T>) t5, i11, i9, i7, i8)) {
                                zznlVar2.zze(i17, unsafe.getLong(t5, j5));
                                break;
                            } else {
                                break;
                            }
                        case 4:
                            i9 = i6;
                            entry3 = entry2;
                            i10 = length;
                            z5 = false;
                            i11 = i5;
                            unsafe = unsafe2;
                            if (zza((zzlq<T>) t5, i11, i9, i7, i8)) {
                                zznlVar2.zzc(i17, unsafe.getInt(t5, j5));
                                break;
                            } else {
                                break;
                            }
                        case 5:
                            i9 = i6;
                            entry3 = entry2;
                            i10 = length;
                            z5 = false;
                            i11 = i5;
                            unsafe = unsafe2;
                            if (zza((zzlq<T>) t5, i11, i9, i7, i8)) {
                                zznlVar2.zza(i17, unsafe.getLong(t5, j5));
                                break;
                            } else {
                                break;
                            }
                        case 6:
                            i9 = i6;
                            entry3 = entry2;
                            i10 = length;
                            z5 = false;
                            i11 = i5;
                            unsafe = unsafe2;
                            if (zza((zzlq<T>) t5, i11, i9, i7, i8)) {
                                zznlVar2.zzb(i17, unsafe.getInt(t5, j5));
                                break;
                            } else {
                                break;
                            }
                        case 7:
                            i9 = i6;
                            entry3 = entry2;
                            i10 = length;
                            z5 = false;
                            i11 = i5;
                            unsafe = unsafe2;
                            if (zza((zzlq<T>) t5, i11, i9, i7, i8)) {
                                zznlVar2.zza(i17, zzmz.zzh(t5, j5));
                                break;
                            } else {
                                break;
                            }
                        case 8:
                            i9 = i6;
                            entry3 = entry2;
                            i10 = length;
                            z5 = false;
                            i11 = i5;
                            unsafe = unsafe2;
                            if (zza((zzlq<T>) t5, i11, i9, i7, i8)) {
                                zza(i17, unsafe.getObject(t5, j5), zznlVar2);
                                break;
                            } else {
                                break;
                            }
                        case 9:
                            i9 = i6;
                            entry3 = entry2;
                            i10 = length;
                            z5 = false;
                            i11 = i5;
                            unsafe = unsafe2;
                            if (zza((zzlq<T>) t5, i11, i9, i7, i8)) {
                                zznlVar2.zzb(i17, unsafe.getObject(t5, j5), zze(i11));
                                break;
                            } else {
                                break;
                            }
                        case 10:
                            i9 = i6;
                            entry3 = entry2;
                            i10 = length;
                            z5 = false;
                            i11 = i5;
                            unsafe = unsafe2;
                            if (zza((zzlq<T>) t5, i11, i9, i7, i8)) {
                                zznlVar2.zza(i17, (zziy) unsafe.getObject(t5, j5));
                                break;
                            } else {
                                break;
                            }
                        case 11:
                            i9 = i6;
                            entry3 = entry2;
                            i10 = length;
                            z5 = false;
                            i11 = i5;
                            unsafe = unsafe2;
                            if (zza((zzlq<T>) t5, i11, i9, i7, i8)) {
                                zznlVar2.zzf(i17, unsafe.getInt(t5, j5));
                                break;
                            } else {
                                break;
                            }
                        case 12:
                            i9 = i6;
                            entry3 = entry2;
                            i10 = length;
                            z5 = false;
                            i11 = i5;
                            unsafe = unsafe2;
                            if (zza((zzlq<T>) t5, i11, i9, i7, i8)) {
                                zznlVar2.zza(i17, unsafe.getInt(t5, j5));
                                break;
                            } else {
                                break;
                            }
                        case 13:
                            i9 = i6;
                            entry3 = entry2;
                            i10 = length;
                            z5 = false;
                            i11 = i5;
                            unsafe = unsafe2;
                            if (zza((zzlq<T>) t5, i11, i9, i7, i8)) {
                                zznlVar2.zzd(i17, unsafe.getInt(t5, j5));
                                break;
                            } else {
                                break;
                            }
                        case 14:
                            i9 = i6;
                            entry3 = entry2;
                            i10 = length;
                            z5 = false;
                            i11 = i5;
                            unsafe = unsafe2;
                            if (zza((zzlq<T>) t5, i11, i9, i7, i8)) {
                                zznlVar2.zzc(i17, unsafe.getLong(t5, j5));
                                break;
                            } else {
                                break;
                            }
                        case 15:
                            i9 = i6;
                            entry3 = entry2;
                            i10 = length;
                            z5 = false;
                            i11 = i5;
                            unsafe = unsafe2;
                            if (zza((zzlq<T>) t5, i11, i9, i7, i8)) {
                                zznlVar2.zze(i17, unsafe.getInt(t5, j5));
                                break;
                            } else {
                                break;
                            }
                        case 16:
                            entry3 = entry2;
                            i10 = length;
                            z5 = false;
                            i11 = i5;
                            unsafe = unsafe2;
                            i9 = i6;
                            if (zza((zzlq<T>) t5, i11, i6, i7, i8)) {
                                zznlVar2.zzd(i17, unsafe.getLong(t5, j5));
                                break;
                            } else {
                                break;
                            }
                        case 17:
                            z5 = false;
                            entry3 = entry2;
                            i11 = i5;
                            i10 = length;
                            unsafe = unsafe2;
                            if (zza((zzlq<T>) t5, i5, i6, i7, i8)) {
                                zznlVar2 = zznlVar;
                                zznlVar2.zza(i17, unsafe.getObject(t5, j5), zze(i11));
                            } else {
                                zznlVar2 = zznlVar;
                            }
                            i9 = i6;
                            break;
                        case 18:
                            z6 = false;
                            zzmg.zzb(this.zzc[i5], (List<Double>) unsafe2.getObject(t5, j5), zznlVar2, false);
                            i9 = i6;
                            entry3 = entry2;
                            z5 = z6;
                            i10 = length;
                            i11 = i5;
                            unsafe = unsafe2;
                            break;
                        case 19:
                            z6 = false;
                            zzmg.zzf(this.zzc[i5], (List) unsafe2.getObject(t5, j5), zznlVar2, false);
                            i9 = i6;
                            entry3 = entry2;
                            z5 = z6;
                            i10 = length;
                            i11 = i5;
                            unsafe = unsafe2;
                            break;
                        case 20:
                            z6 = false;
                            zzmg.zzh(this.zzc[i5], (List) unsafe2.getObject(t5, j5), zznlVar2, false);
                            i9 = i6;
                            entry3 = entry2;
                            z5 = z6;
                            i10 = length;
                            i11 = i5;
                            unsafe = unsafe2;
                            break;
                        case 21:
                            z6 = false;
                            zzmg.zzn(this.zzc[i5], (List) unsafe2.getObject(t5, j5), zznlVar2, false);
                            i9 = i6;
                            entry3 = entry2;
                            z5 = z6;
                            i10 = length;
                            i11 = i5;
                            unsafe = unsafe2;
                            break;
                        case 22:
                            z6 = false;
                            zzmg.zzg(this.zzc[i5], (List) unsafe2.getObject(t5, j5), zznlVar2, false);
                            i9 = i6;
                            entry3 = entry2;
                            z5 = z6;
                            i10 = length;
                            i11 = i5;
                            unsafe = unsafe2;
                            break;
                        case R$styleable.Toolbar_titleMarginBottom /* 23 */:
                            z6 = false;
                            zzmg.zze(this.zzc[i5], (List) unsafe2.getObject(t5, j5), zznlVar2, false);
                            i9 = i6;
                            entry3 = entry2;
                            z5 = z6;
                            i10 = length;
                            i11 = i5;
                            unsafe = unsafe2;
                            break;
                        case R$styleable.Toolbar_titleMarginEnd /* 24 */:
                            z6 = false;
                            zzmg.zzd(this.zzc[i5], (List) unsafe2.getObject(t5, j5), zznlVar2, false);
                            i9 = i6;
                            entry3 = entry2;
                            z5 = z6;
                            i10 = length;
                            i11 = i5;
                            unsafe = unsafe2;
                            break;
                        case 25:
                            z6 = false;
                            zzmg.zza(this.zzc[i5], (List<Boolean>) unsafe2.getObject(t5, j5), zznlVar2, false);
                            i9 = i6;
                            entry3 = entry2;
                            z5 = z6;
                            i10 = length;
                            i11 = i5;
                            unsafe = unsafe2;
                            break;
                        case 26:
                            zzmg.zzb(this.zzc[i5], (List<String>) unsafe2.getObject(t5, j5), zznlVar2);
                            i9 = i6;
                            entry3 = entry2;
                            i10 = length;
                            z5 = false;
                            i11 = i5;
                            unsafe = unsafe2;
                            break;
                        case 27:
                            zzmg.zzb(this.zzc[i5], (List<?>) unsafe2.getObject(t5, j5), zznlVar2, (zzme<?>) zze(i5));
                            i9 = i6;
                            entry3 = entry2;
                            i10 = length;
                            z5 = false;
                            i11 = i5;
                            unsafe = unsafe2;
                            break;
                        case 28:
                            zzmg.zza(this.zzc[i5], (List<zziy>) unsafe2.getObject(t5, j5), zznlVar2);
                            i9 = i6;
                            entry3 = entry2;
                            i10 = length;
                            z5 = false;
                            i11 = i5;
                            unsafe = unsafe2;
                            break;
                        case R$styleable.Toolbar_titleTextColor /* 29 */:
                            z6 = false;
                            zzmg.zzm(this.zzc[i5], (List) unsafe2.getObject(t5, j5), zznlVar2, false);
                            i9 = i6;
                            entry3 = entry2;
                            z5 = z6;
                            i10 = length;
                            i11 = i5;
                            unsafe = unsafe2;
                            break;
                        case 30:
                            z6 = false;
                            zzmg.zzc(this.zzc[i5], (List) unsafe2.getObject(t5, j5), zznlVar2, false);
                            i9 = i6;
                            entry3 = entry2;
                            z5 = z6;
                            i10 = length;
                            i11 = i5;
                            unsafe = unsafe2;
                            break;
                        case 31:
                            z6 = false;
                            zzmg.zzi(this.zzc[i5], (List) unsafe2.getObject(t5, j5), zznlVar2, false);
                            i9 = i6;
                            entry3 = entry2;
                            z5 = z6;
                            i10 = length;
                            i11 = i5;
                            unsafe = unsafe2;
                            break;
                        case 32:
                            z6 = false;
                            zzmg.zzj(this.zzc[i5], (List) unsafe2.getObject(t5, j5), zznlVar2, false);
                            i9 = i6;
                            entry3 = entry2;
                            z5 = z6;
                            i10 = length;
                            i11 = i5;
                            unsafe = unsafe2;
                            break;
                        case 33:
                            z6 = false;
                            zzmg.zzk(this.zzc[i5], (List) unsafe2.getObject(t5, j5), zznlVar2, false);
                            i9 = i6;
                            entry3 = entry2;
                            z5 = z6;
                            i10 = length;
                            i11 = i5;
                            unsafe = unsafe2;
                            break;
                        case 34:
                            z6 = false;
                            zzmg.zzl(this.zzc[i5], (List) unsafe2.getObject(t5, j5), zznlVar2, false);
                            i9 = i6;
                            entry3 = entry2;
                            z5 = z6;
                            i10 = length;
                            i11 = i5;
                            unsafe = unsafe2;
                            break;
                        case 35:
                            zzmg.zzb(this.zzc[i5], (List<Double>) unsafe2.getObject(t5, j5), zznlVar2, true);
                            i9 = i6;
                            entry3 = entry2;
                            i10 = length;
                            z5 = false;
                            i11 = i5;
                            unsafe = unsafe2;
                            break;
                        case 36:
                            zzmg.zzf(this.zzc[i5], (List) unsafe2.getObject(t5, j5), zznlVar2, true);
                            i9 = i6;
                            entry3 = entry2;
                            i10 = length;
                            z5 = false;
                            i11 = i5;
                            unsafe = unsafe2;
                            break;
                        case 37:
                            zzmg.zzh(this.zzc[i5], (List) unsafe2.getObject(t5, j5), zznlVar2, true);
                            i9 = i6;
                            entry3 = entry2;
                            i10 = length;
                            z5 = false;
                            i11 = i5;
                            unsafe = unsafe2;
                            break;
                        case 38:
                            zzmg.zzn(this.zzc[i5], (List) unsafe2.getObject(t5, j5), zznlVar2, true);
                            i9 = i6;
                            entry3 = entry2;
                            i10 = length;
                            z5 = false;
                            i11 = i5;
                            unsafe = unsafe2;
                            break;
                        case 39:
                            zzmg.zzg(this.zzc[i5], (List) unsafe2.getObject(t5, j5), zznlVar2, true);
                            i9 = i6;
                            entry3 = entry2;
                            i10 = length;
                            z5 = false;
                            i11 = i5;
                            unsafe = unsafe2;
                            break;
                        case 40:
                            zzmg.zze(this.zzc[i5], (List) unsafe2.getObject(t5, j5), zznlVar2, true);
                            i9 = i6;
                            entry3 = entry2;
                            i10 = length;
                            z5 = false;
                            i11 = i5;
                            unsafe = unsafe2;
                            break;
                        case 41:
                            zzmg.zzd(this.zzc[i5], (List) unsafe2.getObject(t5, j5), zznlVar2, true);
                            i9 = i6;
                            entry3 = entry2;
                            i10 = length;
                            z5 = false;
                            i11 = i5;
                            unsafe = unsafe2;
                            break;
                        case 42:
                            zzmg.zza(this.zzc[i5], (List<Boolean>) unsafe2.getObject(t5, j5), zznlVar2, true);
                            i9 = i6;
                            entry3 = entry2;
                            i10 = length;
                            z5 = false;
                            i11 = i5;
                            unsafe = unsafe2;
                            break;
                        case 43:
                            zzmg.zzm(this.zzc[i5], (List) unsafe2.getObject(t5, j5), zznlVar2, true);
                            i9 = i6;
                            entry3 = entry2;
                            i10 = length;
                            z5 = false;
                            i11 = i5;
                            unsafe = unsafe2;
                            break;
                        case 44:
                            zzmg.zzc(this.zzc[i5], (List) unsafe2.getObject(t5, j5), zznlVar2, true);
                            i9 = i6;
                            entry3 = entry2;
                            i10 = length;
                            z5 = false;
                            i11 = i5;
                            unsafe = unsafe2;
                            break;
                        case 45:
                            zzmg.zzi(this.zzc[i5], (List) unsafe2.getObject(t5, j5), zznlVar2, true);
                            i9 = i6;
                            entry3 = entry2;
                            i10 = length;
                            z5 = false;
                            i11 = i5;
                            unsafe = unsafe2;
                            break;
                        case 46:
                            zzmg.zzj(this.zzc[i5], (List) unsafe2.getObject(t5, j5), zznlVar2, true);
                            i9 = i6;
                            entry3 = entry2;
                            i10 = length;
                            z5 = false;
                            i11 = i5;
                            unsafe = unsafe2;
                            break;
                        case 47:
                            zzmg.zzk(this.zzc[i5], (List) unsafe2.getObject(t5, j5), zznlVar2, true);
                            i9 = i6;
                            entry3 = entry2;
                            i10 = length;
                            z5 = false;
                            i11 = i5;
                            unsafe = unsafe2;
                            break;
                        case 48:
                            zzmg.zzl(this.zzc[i5], (List) unsafe2.getObject(t5, j5), zznlVar2, true);
                            i9 = i6;
                            entry3 = entry2;
                            i10 = length;
                            z5 = false;
                            i11 = i5;
                            unsafe = unsafe2;
                            break;
                        case 49:
                            zzmg.zza(this.zzc[i5], (List<?>) unsafe2.getObject(t5, j5), zznlVar2, (zzme<?>) zze(i5));
                            i9 = i6;
                            entry3 = entry2;
                            i10 = length;
                            z5 = false;
                            i11 = i5;
                            unsafe = unsafe2;
                            break;
                        case 50:
                            zza(zznlVar2, i17, unsafe2.getObject(t5, j5), i5);
                            i9 = i6;
                            entry3 = entry2;
                            i10 = length;
                            z5 = false;
                            i11 = i5;
                            unsafe = unsafe2;
                            break;
                        case 51:
                            if (zzc((zzlq<T>) t5, i17, i5)) {
                                zznlVar2.zza(i17, zza(t5, j5));
                            }
                            i9 = i6;
                            entry3 = entry2;
                            i10 = length;
                            z5 = false;
                            i11 = i5;
                            unsafe = unsafe2;
                            break;
                        case 52:
                            if (zzc((zzlq<T>) t5, i17, i5)) {
                                zznlVar2.zza(i17, zzb(t5, j5));
                            }
                            i9 = i6;
                            entry3 = entry2;
                            i10 = length;
                            z5 = false;
                            i11 = i5;
                            unsafe = unsafe2;
                            break;
                        case 53:
                            if (zzc((zzlq<T>) t5, i17, i5)) {
                                zznlVar2.zzb(i17, zzd(t5, j5));
                            }
                            i9 = i6;
                            entry3 = entry2;
                            i10 = length;
                            z5 = false;
                            i11 = i5;
                            unsafe = unsafe2;
                            break;
                        case 54:
                            if (zzc((zzlq<T>) t5, i17, i5)) {
                                zznlVar2.zze(i17, zzd(t5, j5));
                            }
                            i9 = i6;
                            entry3 = entry2;
                            i10 = length;
                            z5 = false;
                            i11 = i5;
                            unsafe = unsafe2;
                            break;
                        case 55:
                            if (zzc((zzlq<T>) t5, i17, i5)) {
                                zznlVar2.zzc(i17, zzc(t5, j5));
                            }
                            i9 = i6;
                            entry3 = entry2;
                            i10 = length;
                            z5 = false;
                            i11 = i5;
                            unsafe = unsafe2;
                            break;
                        case 56:
                            if (zzc((zzlq<T>) t5, i17, i5)) {
                                zznlVar2.zza(i17, zzd(t5, j5));
                            }
                            i9 = i6;
                            entry3 = entry2;
                            i10 = length;
                            z5 = false;
                            i11 = i5;
                            unsafe = unsafe2;
                            break;
                        case 57:
                            if (zzc((zzlq<T>) t5, i17, i5)) {
                                zznlVar2.zzb(i17, zzc(t5, j5));
                            }
                            i9 = i6;
                            entry3 = entry2;
                            i10 = length;
                            z5 = false;
                            i11 = i5;
                            unsafe = unsafe2;
                            break;
                        case 58:
                            if (zzc((zzlq<T>) t5, i17, i5)) {
                                zznlVar2.zza(i17, zze(t5, j5));
                            }
                            i9 = i6;
                            entry3 = entry2;
                            i10 = length;
                            z5 = false;
                            i11 = i5;
                            unsafe = unsafe2;
                            break;
                        case 59:
                            if (zzc((zzlq<T>) t5, i17, i5)) {
                                zza(i17, unsafe2.getObject(t5, j5), zznlVar2);
                            }
                            i9 = i6;
                            entry3 = entry2;
                            i10 = length;
                            z5 = false;
                            i11 = i5;
                            unsafe = unsafe2;
                            break;
                        case 60:
                            if (zzc((zzlq<T>) t5, i17, i5)) {
                                zznlVar2.zzb(i17, unsafe2.getObject(t5, j5), zze(i5));
                            }
                            i9 = i6;
                            entry3 = entry2;
                            i10 = length;
                            z5 = false;
                            i11 = i5;
                            unsafe = unsafe2;
                            break;
                        case 61:
                            if (zzc((zzlq<T>) t5, i17, i5)) {
                                zznlVar2.zza(i17, (zziy) unsafe2.getObject(t5, j5));
                            }
                            i9 = i6;
                            entry3 = entry2;
                            i10 = length;
                            z5 = false;
                            i11 = i5;
                            unsafe = unsafe2;
                            break;
                        case 62:
                            if (zzc((zzlq<T>) t5, i17, i5)) {
                                zznlVar2.zzf(i17, zzc(t5, j5));
                            }
                            i9 = i6;
                            entry3 = entry2;
                            i10 = length;
                            z5 = false;
                            i11 = i5;
                            unsafe = unsafe2;
                            break;
                        case Function.ALT_CONVENTION /* 63 */:
                            if (zzc((zzlq<T>) t5, i17, i5)) {
                                zznlVar2.zza(i17, zzc(t5, j5));
                            }
                            i9 = i6;
                            entry3 = entry2;
                            i10 = length;
                            z5 = false;
                            i11 = i5;
                            unsafe = unsafe2;
                            break;
                        case Function.THROW_LAST_ERROR /* 64 */:
                            if (zzc((zzlq<T>) t5, i17, i5)) {
                                zznlVar2.zzd(i17, zzc(t5, j5));
                            }
                            i9 = i6;
                            entry3 = entry2;
                            i10 = length;
                            z5 = false;
                            i11 = i5;
                            unsafe = unsafe2;
                            break;
                        case 65:
                            if (zzc((zzlq<T>) t5, i17, i5)) {
                                zznlVar2.zzc(i17, zzd(t5, j5));
                            }
                            i9 = i6;
                            entry3 = entry2;
                            i10 = length;
                            z5 = false;
                            i11 = i5;
                            unsafe = unsafe2;
                            break;
                        case 66:
                            if (zzc((zzlq<T>) t5, i17, i5)) {
                                zznlVar2.zze(i17, zzc(t5, j5));
                            }
                            i9 = i6;
                            entry3 = entry2;
                            i10 = length;
                            z5 = false;
                            i11 = i5;
                            unsafe = unsafe2;
                            break;
                        case 67:
                            if (zzc((zzlq<T>) t5, i17, i5)) {
                                zznlVar2.zzd(i17, zzd(t5, j5));
                            }
                            i9 = i6;
                            entry3 = entry2;
                            i10 = length;
                            z5 = false;
                            i11 = i5;
                            unsafe = unsafe2;
                            break;
                        case 68:
                            if (zzc((zzlq<T>) t5, i17, i5)) {
                                zznlVar2.zza(i17, unsafe2.getObject(t5, j5), zze(i5));
                            }
                            i9 = i6;
                            entry3 = entry2;
                            i10 = length;
                            z5 = false;
                            i11 = i5;
                            unsafe = unsafe2;
                            break;
                        default:
                            i9 = i6;
                            entry3 = entry2;
                            i10 = length;
                            z5 = false;
                            i11 = i5;
                            unsafe = unsafe2;
                            break;
                    }
                    i5 = i11 + 3;
                    i15 = i7;
                    unsafe2 = unsafe;
                    i13 = 1048575;
                    it = it2;
                    entry = entry3;
                    length = i10;
                    i16 = i9;
                    i12 = 267386880;
                }
                Iterator<Map.Entry<?, Object>> it4 = it;
                while (entry != null) {
                    this.zzq.zza(zznlVar2, entry);
                    entry = it4.hasNext() ? (Map.Entry) it4.next() : null;
                }
                zza(this.zzp, t5, zznlVar2);
            }
        }
        entry = null;
        it = null;
        length = this.zzc.length;
        Unsafe unsafe22 = zzb;
        int i152 = 0;
        i5 = 0;
        int i162 = 1048575;
        while (i5 < length) {
        }
        Iterator<Map.Entry<?, Object>> it42 = it;
        while (entry != null) {
        }
        zza(this.zzp, t5, zznlVar2);
    }

    private static <UT, UB> void zza(zzmu<UT, UB> zzmuVar, T t5, zznl zznlVar) {
        zzmuVar.zzb((zzmu<UT, UB>) zzmuVar.zzd(t5), zznlVar);
    }

    private final boolean zza(T t5, int i5, int i6, int i7, int i8) {
        if (i6 == 1048575) {
            return zzc((zzlq<T>) t5, i5);
        }
        return (i7 & i8) != 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean zza(Object obj, int i5, zzme zzmeVar) {
        return zzmeVar.zze(zzmz.zze(obj, i5 & 1048575));
    }
}
