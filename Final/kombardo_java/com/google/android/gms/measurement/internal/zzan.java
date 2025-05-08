package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.internal.zzjj;
import java.util.EnumMap;

/* loaded from: classes.dex */
final class zzan {
    private final EnumMap<zzjj.zza, zzam> zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzan() {
        this.zza = new EnumMap<>(zzjj.zza.class);
    }

    public final String toString() {
        char c5;
        StringBuilder sb = new StringBuilder("1");
        for (zzjj.zza zzaVar : zzjj.zza.values()) {
            zzam zzamVar = this.zza.get(zzaVar);
            if (zzamVar == null) {
                zzamVar = zzam.UNSET;
            }
            c5 = zzamVar.zzl;
            sb.append(c5);
        }
        return sb.toString();
    }

    public final zzam zza(zzjj.zza zzaVar) {
        zzam zzamVar = this.zza.get(zzaVar);
        return zzamVar == null ? zzam.UNSET : zzamVar;
    }

    private zzan(EnumMap<zzjj.zza, zzam> enumMap) {
        EnumMap<zzjj.zza, zzam> enumMap2 = new EnumMap<>((Class<zzjj.zza>) zzjj.zza.class);
        this.zza = enumMap2;
        enumMap2.putAll(enumMap);
    }

    public static zzan zza(String str) {
        EnumMap enumMap = new EnumMap(zzjj.zza.class);
        if (str.length() >= zzjj.zza.values().length) {
            int i5 = 0;
            if (str.charAt(0) == '1') {
                zzjj.zza[] values = zzjj.zza.values();
                int length = values.length;
                int i6 = 1;
                while (i5 < length) {
                    enumMap.put((EnumMap) values[i5], (zzjj.zza) zzam.zza(str.charAt(i6)));
                    i5++;
                    i6++;
                }
                return new zzan(enumMap);
            }
        }
        return new zzan();
    }

    public final void zza(zzjj.zza zzaVar, int i5) {
        zzam zzamVar = zzam.UNSET;
        if (i5 != -30) {
            if (i5 != -20) {
                if (i5 == -10) {
                    zzamVar = zzam.MANIFEST;
                } else if (i5 != 0) {
                    if (i5 == 30) {
                        zzamVar = zzam.INITIALIZATION;
                    }
                }
            }
            zzamVar = zzam.API;
        } else {
            zzamVar = zzam.TCF;
        }
        this.zza.put((EnumMap<zzjj.zza, zzam>) zzaVar, (zzjj.zza) zzamVar);
    }

    public final void zza(zzjj.zza zzaVar, zzam zzamVar) {
        this.zza.put((EnumMap<zzjj.zza, zzam>) zzaVar, (zzjj.zza) zzamVar);
    }
}
