package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;
import org.conscrypt.BuildConfig;

/* loaded from: classes.dex */
public final class zzjj {
    public static final zzjj zza = new zzjj(null, null, 100);
    private final EnumMap<zza, zzjm> zzb;
    private final int zzc;

    /* loaded from: classes.dex */
    public enum zza {
        AD_STORAGE("ad_storage"),
        ANALYTICS_STORAGE("analytics_storage"),
        AD_USER_DATA("ad_user_data"),
        AD_PERSONALIZATION("ad_personalization");

        public final String zze;

        zza(String str) {
            this.zze = str;
        }
    }

    private zzjj(EnumMap<zza, zzjm> enumMap, int i5) {
        EnumMap<zza, zzjm> enumMap2 = new EnumMap<>((Class<zza>) zza.class);
        this.zzb = enumMap2;
        enumMap2.putAll(enumMap);
        this.zzc = i5;
    }

    public static boolean zza(int i5, int i6) {
        if (i5 == -20 && i6 == -30) {
            return true;
        }
        return (i5 == -30 && i6 == -20) || i5 == i6 || i5 < i6;
    }

    public final boolean equals(Object obj) {
        zza[] zzaVarArr;
        if (!(obj instanceof zzjj)) {
            return false;
        }
        zzjj zzjjVar = (zzjj) obj;
        zzaVarArr = zzjl.STORAGE.zzd;
        for (zza zzaVar : zzaVarArr) {
            if (this.zzb.get(zzaVar) != zzjjVar.zzb.get(zzaVar)) {
                return false;
            }
        }
        return this.zzc == zzjjVar.zzc;
    }

    public final int hashCode() {
        int i5 = this.zzc * 17;
        Iterator<zzjm> it = this.zzb.values().iterator();
        while (it.hasNext()) {
            i5 = (i5 * 31) + it.next().hashCode();
        }
        return i5;
    }

    public final String toString() {
        zza[] zzaVarArr;
        StringBuilder sb = new StringBuilder("source=");
        sb.append(zza(this.zzc));
        zzaVarArr = zzjl.STORAGE.zzd;
        for (zza zzaVar : zzaVarArr) {
            sb.append(",");
            sb.append(zzaVar.zze);
            sb.append("=");
            zzjm zzjmVar = this.zzb.get(zzaVar);
            if (zzjmVar == null) {
                zzjmVar = zzjm.UNINITIALIZED;
            }
            sb.append(zzjmVar);
        }
        return sb.toString();
    }

    public final Bundle zzb() {
        Bundle bundle = new Bundle();
        for (Map.Entry<zza, zzjm> entry : this.zzb.entrySet()) {
            String zzb = zzb(entry.getValue());
            if (zzb != null) {
                bundle.putString(entry.getKey().zze, zzb);
            }
        }
        return bundle;
    }

    public final zzjm zzc() {
        zzjm zzjmVar = this.zzb.get(zza.AD_STORAGE);
        return zzjmVar == null ? zzjm.UNINITIALIZED : zzjmVar;
    }

    public final zzjm zzd() {
        zzjm zzjmVar = this.zzb.get(zza.ANALYTICS_STORAGE);
        return zzjmVar == null ? zzjm.UNINITIALIZED : zzjmVar;
    }

    public final String zze() {
        int ordinal;
        StringBuilder sb = new StringBuilder("G1");
        for (zza zzaVar : zzjl.STORAGE.zza()) {
            zzjm zzjmVar = this.zzb.get(zzaVar);
            char c5 = '-';
            if (zzjmVar != null && (ordinal = zzjmVar.ordinal()) != 0) {
                if (ordinal != 1) {
                    if (ordinal == 2) {
                        c5 = '0';
                    } else if (ordinal != 3) {
                    }
                }
                c5 = '1';
            }
            sb.append(c5);
        }
        return sb.toString();
    }

    public final String zzf() {
        StringBuilder sb = new StringBuilder("G1");
        for (zza zzaVar : zzjl.STORAGE.zza()) {
            sb.append(zza(this.zzb.get(zzaVar)));
        }
        return sb.toString();
    }

    public final boolean zzg() {
        return zza(zza.AD_STORAGE);
    }

    public final boolean zzh() {
        return zza(zza.ANALYTICS_STORAGE);
    }

    public final boolean zzi() {
        Iterator<zzjm> it = this.zzb.values().iterator();
        while (it.hasNext()) {
            if (it.next() != zzjm.UNINITIALIZED) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static char zza(zzjm zzjmVar) {
        if (zzjmVar == null) {
            return '-';
        }
        int ordinal = zzjmVar.ordinal();
        if (ordinal == 1) {
            return '+';
        }
        if (ordinal != 2) {
            return ordinal != 3 ? '-' : '1';
        }
        return '0';
    }

    public final int zza() {
        return this.zzc;
    }

    public final boolean zzc(zzjj zzjjVar) {
        for (zza zzaVar : (zza[]) this.zzb.keySet().toArray(new zza[0])) {
            zzjm zzjmVar = this.zzb.get(zzaVar);
            zzjm zzjmVar2 = zzjjVar.zzb.get(zzaVar);
            zzjm zzjmVar3 = zzjm.DENIED;
            if (zzjmVar == zzjmVar3 && zzjmVar2 != zzjmVar3) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzjm zza(String str) {
        if (str == null) {
            return zzjm.UNINITIALIZED;
        }
        if (str.equals("granted")) {
            return zzjm.GRANTED;
        }
        if (str.equals("denied")) {
            return zzjm.DENIED;
        }
        return zzjm.UNINITIALIZED;
    }

    public zzjj(Boolean bool, Boolean bool2, int i5) {
        EnumMap<zza, zzjm> enumMap = new EnumMap<>((Class<zza>) zza.class);
        this.zzb = enumMap;
        enumMap.put((EnumMap<zza, zzjm>) zza.AD_STORAGE, (zza) zza((Boolean) null));
        enumMap.put((EnumMap<zza, zzjm>) zza.ANALYTICS_STORAGE, (zza) zza((Boolean) null));
        this.zzc = i5;
    }

    public static zzjj zzb(String str) {
        return zza(str, 100);
    }

    public final zzjj zzb(zzjj zzjjVar) {
        zza[] zzaVarArr;
        EnumMap enumMap = new EnumMap(zza.class);
        zzaVarArr = zzjl.STORAGE.zzd;
        for (zza zzaVar : zzaVarArr) {
            zzjm zzjmVar = this.zzb.get(zzaVar);
            if (zzjmVar == zzjm.UNINITIALIZED) {
                zzjmVar = zzjjVar.zzb.get(zzaVar);
            }
            if (zzjmVar != null) {
                enumMap.put((EnumMap) zzaVar, (zza) zzjmVar);
            }
        }
        return new zzjj(enumMap, this.zzc);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzjm zza(char c5) {
        if (c5 == '+') {
            return zzjm.POLICY;
        }
        if (c5 == '0') {
            return zzjm.DENIED;
        }
        if (c5 != '1') {
            return zzjm.UNINITIALIZED;
        }
        return zzjm.GRANTED;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zzb(zzjm zzjmVar) {
        int ordinal = zzjmVar.ordinal();
        if (ordinal == 2) {
            return "denied";
        }
        if (ordinal != 3) {
            return null;
        }
        return "granted";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzjm zza(Boolean bool) {
        if (bool == null) {
            return zzjm.UNINITIALIZED;
        }
        if (bool.booleanValue()) {
            return zzjm.GRANTED;
        }
        return zzjm.DENIED;
    }

    public static zzjj zza(Bundle bundle, int i5) {
        zza[] zzaVarArr;
        if (bundle == null) {
            return new zzjj(null, null, i5);
        }
        EnumMap enumMap = new EnumMap(zza.class);
        zzaVarArr = zzjl.STORAGE.zzd;
        for (zza zzaVar : zzaVarArr) {
            enumMap.put((EnumMap) zzaVar, (zza) zza(bundle.getString(zzaVar.zze)));
        }
        return new zzjj(enumMap, i5);
    }

    public static zzjj zza(zzjm zzjmVar, zzjm zzjmVar2, int i5) {
        EnumMap enumMap = new EnumMap(zza.class);
        enumMap.put((EnumMap) zza.AD_STORAGE, (zza) zzjmVar);
        enumMap.put((EnumMap) zza.ANALYTICS_STORAGE, (zza) zzjmVar2);
        return new zzjj(enumMap, -10);
    }

    public static zzjj zza(String str, int i5) {
        EnumMap enumMap = new EnumMap(zza.class);
        if (str == null) {
            str = BuildConfig.FLAVOR;
        }
        zza[] zza2 = zzjl.STORAGE.zza();
        for (int i6 = 0; i6 < zza2.length; i6++) {
            zza zzaVar = zza2[i6];
            int i7 = i6 + 2;
            if (i7 < str.length()) {
                enumMap.put((EnumMap) zzaVar, (zza) zza(str.charAt(i7)));
            } else {
                enumMap.put((EnumMap) zzaVar, (zza) zzjm.UNINITIALIZED);
            }
        }
        return new zzjj(enumMap, i5);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzjj zza(zzjj zzjjVar) {
        zza[] zzaVarArr;
        EnumMap enumMap = new EnumMap(zza.class);
        zzaVarArr = zzjl.STORAGE.zzd;
        for (zza zzaVar : zzaVarArr) {
            zzjm zzjmVar = this.zzb.get(zzaVar);
            zzjm zzjmVar2 = zzjjVar.zzb.get(zzaVar);
            if (zzjmVar != null) {
                if (zzjmVar2 != null) {
                    zzjm zzjmVar3 = zzjm.UNINITIALIZED;
                    if (zzjmVar != zzjmVar3) {
                        if (zzjmVar2 != zzjmVar3) {
                            zzjm zzjmVar4 = zzjm.POLICY;
                            if (zzjmVar != zzjmVar4) {
                                if (zzjmVar2 != zzjmVar4) {
                                    zzjm zzjmVar5 = zzjm.DENIED;
                                    zzjmVar = (zzjmVar == zzjmVar5 || zzjmVar2 == zzjmVar5) ? zzjmVar5 : zzjm.GRANTED;
                                }
                            }
                        }
                    }
                }
                if (zzjmVar == null) {
                    enumMap.put((EnumMap) zzaVar, (zza) zzjmVar);
                }
            }
            zzjmVar = zzjmVar2;
            if (zzjmVar == null) {
            }
        }
        return new zzjj(enumMap, 100);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zza(int i5) {
        if (i5 == -30) {
            return "TCF";
        }
        if (i5 == -20) {
            return "API";
        }
        if (i5 == -10) {
            return "MANIFEST";
        }
        if (i5 == 0) {
            return "1P_API";
        }
        if (i5 == 30) {
            return "1P_INIT";
        }
        if (i5 == 90) {
            return "REMOTE_CONFIG";
        }
        if (i5 != 100) {
            return "OTHER";
        }
        return "UNKNOWN";
    }

    public static String zza(Bundle bundle) {
        zza[] zzaVarArr;
        String string;
        zzaVarArr = zzjl.STORAGE.zzd;
        int length = zzaVarArr.length;
        int i5 = 0;
        while (true) {
            Boolean bool = null;
            if (i5 >= length) {
                return null;
            }
            zza zzaVar = zzaVarArr[i5];
            if (bundle.containsKey(zzaVar.zze) && (string = bundle.getString(zzaVar.zze)) != null) {
                if (string.equals("granted")) {
                    bool = Boolean.TRUE;
                } else if (string.equals("denied")) {
                    bool = Boolean.FALSE;
                }
                if (bool == null) {
                    return string;
                }
            }
            i5++;
        }
    }

    public final boolean zza(zza zzaVar) {
        return this.zzb.get(zzaVar) != zzjm.DENIED;
    }
}
