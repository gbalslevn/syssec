package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.measurement.internal.zzjj;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes.dex */
public final class zzbd {
    private static final zzbd zza = new zzbd(null, 100);
    private final int zzb;
    private final String zzc;
    private final Boolean zzd;
    private final String zze;
    private final EnumMap<zzjj.zza, zzjm> zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbd(Boolean bool, int i5) {
        this((Boolean) null, i5, (Boolean) null, (String) null);
    }

    private final String zzh() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.zzb);
        for (zzjj.zza zzaVar : zzjl.DMA.zza()) {
            sb.append(":");
            sb.append(zzjj.zza(this.zzf.get(zzaVar)));
        }
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzbd)) {
            return false;
        }
        zzbd zzbdVar = (zzbd) obj;
        if (this.zzc.equalsIgnoreCase(zzbdVar.zzc) && Objects.equals(this.zzd, zzbdVar.zzd)) {
            return Objects.equals(this.zze, zzbdVar.zze);
        }
        return false;
    }

    public final int hashCode() {
        Boolean bool = this.zzd;
        int i5 = bool == null ? 3 : bool == Boolean.TRUE ? 7 : 13;
        String str = this.zze;
        return this.zzc.hashCode() + (i5 * 29) + ((str == null ? 17 : str.hashCode()) * 137);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("source=");
        sb.append(zzjj.zza(this.zzb));
        for (zzjj.zza zzaVar : zzjl.DMA.zza()) {
            sb.append(",");
            sb.append(zzaVar.zze);
            sb.append("=");
            zzjm zzjmVar = this.zzf.get(zzaVar);
            if (zzjmVar == null) {
                sb.append("uninitialized");
            } else {
                int i5 = zzbc.zza[zzjmVar.ordinal()];
                if (i5 == 1) {
                    sb.append("uninitialized");
                } else if (i5 == 2) {
                    sb.append("eu_consent_policy");
                } else if (i5 == 3) {
                    sb.append("denied");
                } else if (i5 == 4) {
                    sb.append("granted");
                }
            }
        }
        if (this.zzd != null) {
            sb.append(",isDmaRegion=");
            sb.append(this.zzd);
        }
        if (this.zze != null) {
            sb.append(",cpsDisplayStr=");
            sb.append(this.zze);
        }
        return sb.toString();
    }

    public final int zza() {
        return this.zzb;
    }

    public final Bundle zzb() {
        Bundle bundle = new Bundle();
        for (Map.Entry<zzjj.zza, zzjm> entry : this.zzf.entrySet()) {
            String zzb = zzjj.zzb(entry.getValue());
            if (zzb != null) {
                bundle.putString(entry.getKey().zze, zzb);
            }
        }
        Boolean bool = this.zzd;
        if (bool != null) {
            bundle.putString("is_dma_region", bool.toString());
        }
        String str = this.zze;
        if (str != null) {
            bundle.putString("cps_display_str", str);
        }
        return bundle;
    }

    public final zzjm zzc() {
        zzjm zzjmVar = this.zzf.get(zzjj.zza.AD_USER_DATA);
        return zzjmVar == null ? zzjm.UNINITIALIZED : zzjmVar;
    }

    public final Boolean zzd() {
        return this.zzd;
    }

    public final String zze() {
        return this.zze;
    }

    public final String zzf() {
        return this.zzc;
    }

    public final boolean zzg() {
        Iterator<zzjm> it = this.zzf.values().iterator();
        while (it.hasNext()) {
            if (it.next() != zzjm.UNINITIALIZED) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbd(Boolean bool, int i5, Boolean bool2, String str) {
        EnumMap<zzjj.zza, zzjm> enumMap = new EnumMap<>((Class<zzjj.zza>) zzjj.zza.class);
        this.zzf = enumMap;
        enumMap.put((EnumMap<zzjj.zza, zzjm>) zzjj.zza.AD_USER_DATA, (zzjj.zza) zzjj.zza(bool));
        this.zzb = i5;
        this.zzc = zzh();
        this.zzd = bool2;
        this.zze = str;
    }

    public static zzbd zza(Bundle bundle, int i5) {
        if (bundle == null) {
            return new zzbd(null, i5);
        }
        EnumMap enumMap = new EnumMap(zzjj.zza.class);
        for (zzjj.zza zzaVar : zzjl.DMA.zza()) {
            enumMap.put((EnumMap) zzaVar, (zzjj.zza) zzjj.zza(bundle.getString(zzaVar.zze)));
        }
        return new zzbd((EnumMap<zzjj.zza, zzjm>) enumMap, i5, bundle.containsKey("is_dma_region") ? Boolean.valueOf(bundle.getString("is_dma_region")) : null, bundle.getString("cps_display_str"));
    }

    private zzbd(EnumMap<zzjj.zza, zzjm> enumMap, int i5, Boolean bool, String str) {
        EnumMap<zzjj.zza, zzjm> enumMap2 = new EnumMap<>((Class<zzjj.zza>) zzjj.zza.class);
        this.zzf = enumMap2;
        enumMap2.putAll(enumMap);
        this.zzb = i5;
        this.zzc = zzh();
        this.zzd = bool;
        this.zze = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzbd zza(zzjm zzjmVar, int i5) {
        EnumMap enumMap = new EnumMap(zzjj.zza.class);
        enumMap.put((EnumMap) zzjj.zza.AD_USER_DATA, (zzjj.zza) zzjmVar);
        return new zzbd((EnumMap<zzjj.zza, zzjm>) enumMap, -10, (Boolean) null, (String) null);
    }

    public static zzbd zza(String str) {
        if (str != null && str.length() > 0) {
            String[] split = str.split(":");
            int parseInt = Integer.parseInt(split[0]);
            EnumMap enumMap = new EnumMap(zzjj.zza.class);
            zzjj.zza[] zza2 = zzjl.DMA.zza();
            int length = zza2.length;
            int i5 = 1;
            int i6 = 0;
            while (i6 < length) {
                enumMap.put((EnumMap) zza2[i6], (zzjj.zza) zzjj.zza(split[i5].charAt(0)));
                i6++;
                i5++;
            }
            return new zzbd((EnumMap<zzjj.zza, zzjm>) enumMap, parseInt, (Boolean) null, (String) null);
        }
        return zza;
    }

    public static Boolean zza(Bundle bundle) {
        zzjm zza2;
        if (bundle == null || (zza2 = zzjj.zza(bundle.getString("ad_personalization"))) == null) {
            return null;
        }
        int i5 = zzbc.zza[zza2.ordinal()];
        if (i5 == 3) {
            return Boolean.FALSE;
        }
        if (i5 != 4) {
            return null;
        }
        return Boolean.TRUE;
    }
}
