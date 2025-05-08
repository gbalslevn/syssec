package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzfw$zzd;
import com.google.android.gms.internal.measurement.zzfw$zzf;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class zzaa {
    String zza;
    int zzb;
    Boolean zzc;
    Boolean zzd;
    Long zze;
    Long zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaa(String str, int i5) {
        this.zza = str;
        this.zzb = i5;
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x0080, code lost:
    
        if (r3 != null) goto L36;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Boolean zza(BigDecimal bigDecimal, zzfw$zzd zzfw_zzd, double d5) {
        BigDecimal bigDecimal2;
        BigDecimal bigDecimal3;
        BigDecimal bigDecimal4;
        Preconditions.checkNotNull(zzfw_zzd);
        if (zzfw_zzd.zzh() && zzfw_zzd.zza() != zzfw$zzd.zza.UNKNOWN_COMPARISON_TYPE) {
            zzfw$zzd.zza zza = zzfw_zzd.zza();
            zzfw$zzd.zza zzaVar = zzfw$zzd.zza.BETWEEN;
            if (zza == zzaVar) {
                if (!zzfw_zzd.zzl() || !zzfw_zzd.zzk()) {
                    return null;
                }
            } else if (!zzfw_zzd.zzi()) {
                return null;
            }
            zzfw$zzd.zza zza2 = zzfw_zzd.zza();
            if (zzfw_zzd.zza() == zzaVar) {
                if (zzpj.zzb(zzfw_zzd.zzf()) && zzpj.zzb(zzfw_zzd.zze())) {
                    try {
                        BigDecimal bigDecimal5 = new BigDecimal(zzfw_zzd.zzf());
                        bigDecimal4 = new BigDecimal(zzfw_zzd.zze());
                        bigDecimal3 = bigDecimal5;
                        bigDecimal2 = null;
                    } catch (NumberFormatException unused) {
                    }
                }
                return null;
            }
            if (!zzpj.zzb(zzfw_zzd.zzd())) {
                return null;
            }
            try {
                bigDecimal2 = new BigDecimal(zzfw_zzd.zzd());
                bigDecimal3 = null;
                bigDecimal4 = null;
            } catch (NumberFormatException unused2) {
            }
            if (zza2 == zzaVar) {
                if (bigDecimal3 == null) {
                    return null;
                }
            }
            int i5 = zzw.zzb[zza2.ordinal()];
            if (i5 != 1) {
                if (i5 != 2) {
                    if (i5 != 3) {
                        if (i5 != 4 || bigDecimal3 == null) {
                            return null;
                        }
                        if (bigDecimal.compareTo(bigDecimal3) >= 0 && bigDecimal.compareTo(bigDecimal4) <= 0) {
                            r2 = true;
                        }
                        return Boolean.valueOf(r2);
                    }
                    if (bigDecimal2 != null) {
                        if (d5 == 0.0d) {
                            return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2) == 0);
                        }
                        if (bigDecimal.compareTo(bigDecimal2.subtract(new BigDecimal(d5).multiply(new BigDecimal(2)))) > 0 && bigDecimal.compareTo(bigDecimal2.add(new BigDecimal(d5).multiply(new BigDecimal(2)))) < 0) {
                            r2 = true;
                        }
                        return Boolean.valueOf(r2);
                    }
                } else if (bigDecimal2 != null) {
                    return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2) > 0);
                }
            } else if (bigDecimal2 != null) {
                return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2) < 0);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int zza();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean zzb();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean zzc();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Boolean zza(String str, zzfw$zzf zzfw_zzf, zzgo zzgoVar) {
        String zze;
        List<String> list;
        Preconditions.checkNotNull(zzfw_zzf);
        if (str == null || !zzfw_zzf.zzj() || zzfw_zzf.zzb() == zzfw$zzf.zza.UNKNOWN_MATCH_TYPE) {
            return null;
        }
        zzfw$zzf.zza zzb = zzfw_zzf.zzb();
        zzfw$zzf.zza zzaVar = zzfw$zzf.zza.IN_LIST;
        if (zzb == zzaVar) {
            if (zzfw_zzf.zza() == 0) {
                return null;
            }
        } else if (!zzfw_zzf.zzi()) {
            return null;
        }
        zzfw$zzf.zza zzb2 = zzfw_zzf.zzb();
        boolean zzg = zzfw_zzf.zzg();
        if (!zzg && zzb2 != zzfw$zzf.zza.REGEXP && zzb2 != zzaVar) {
            zze = zzfw_zzf.zze().toUpperCase(Locale.ENGLISH);
        } else {
            zze = zzfw_zzf.zze();
        }
        String str2 = zze;
        if (zzfw_zzf.zza() == 0) {
            list = null;
        } else {
            List<String> zzf = zzfw_zzf.zzf();
            if (!zzg) {
                ArrayList arrayList = new ArrayList(zzf.size());
                Iterator<String> it = zzf.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().toUpperCase(Locale.ENGLISH));
                }
                zzf = Collections.unmodifiableList(arrayList);
            }
            list = zzf;
        }
        return zza(str, zzb2, zzg, str2, list, zzb2 == zzfw$zzf.zza.REGEXP ? str2 : null, zzgoVar);
    }

    private static Boolean zza(String str, zzfw$zzf.zza zzaVar, boolean z5, String str2, List<String> list, String str3, zzgo zzgoVar) {
        if (str == null) {
            return null;
        }
        if (zzaVar == zzfw$zzf.zza.IN_LIST) {
            if (list == null || list.isEmpty()) {
                return null;
            }
        } else if (str2 == null) {
            return null;
        }
        if (!z5 && zzaVar != zzfw$zzf.zza.REGEXP) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        switch (zzw.zza[zzaVar.ordinal()]) {
            case 1:
                if (str3 == null) {
                    return null;
                }
                try {
                    return Boolean.valueOf(Pattern.compile(str3, z5 ? 0 : 66).matcher(str).matches());
                } catch (PatternSyntaxException unused) {
                    if (zzgoVar != null) {
                        zzgoVar.zzr().zza("Invalid regular expression in REGEXP audience filter. expression", str3);
                    }
                    return null;
                }
            case 2:
                return Boolean.valueOf(str.startsWith(str2));
            case 3:
                return Boolean.valueOf(str.endsWith(str2));
            case 4:
                return Boolean.valueOf(str.contains(str2));
            case 5:
                return Boolean.valueOf(str.equals(str2));
            case 6:
                if (list == null) {
                    return null;
                }
                return Boolean.valueOf(list.contains(str));
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Boolean zza(double d5, zzfw$zzd zzfw_zzd) {
        try {
            return zza(new BigDecimal(d5), zzfw_zzd, Math.ulp(d5));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Boolean zza(long j5, zzfw$zzd zzfw_zzd) {
        try {
            return zza(new BigDecimal(j5), zzfw_zzd, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Boolean zza(String str, zzfw$zzd zzfw_zzd) {
        if (!zzpj.zzb(str)) {
            return null;
        }
        try {
            return zza(new BigDecimal(str), zzfw_zzd, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Boolean zza(Boolean bool, boolean z5) {
        if (bool == null) {
            return null;
        }
        return Boolean.valueOf(bool.booleanValue() != z5);
    }
}
