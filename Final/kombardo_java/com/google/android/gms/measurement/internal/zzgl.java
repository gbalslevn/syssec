package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class zzgl {
    private static final AtomicReference<String[]> zza = new AtomicReference<>();
    private static final AtomicReference<String[]> zzb = new AtomicReference<>();
    private static final AtomicReference<String[]> zzc = new AtomicReference<>();
    private final zzgk zzd;

    public zzgl(zzgk zzgkVar) {
        this.zzd = zzgkVar;
    }

    private final String zza(Object[] objArr) {
        String valueOf;
        if (objArr == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Object obj : objArr) {
            if (obj instanceof Bundle) {
                valueOf = zza((Bundle) obj);
            } else {
                valueOf = String.valueOf(obj);
            }
            if (valueOf != null) {
                if (sb.length() != 1) {
                    sb.append(", ");
                }
                sb.append(valueOf);
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String zzb(String str) {
        if (str == null) {
            return null;
        }
        return !this.zzd.zza() ? str : zza(str, zzjo.zzb, zzjo.zza, zzb);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String zzc(String str) {
        if (str == null) {
            return null;
        }
        if (!this.zzd.zza()) {
            return str;
        }
        if (!str.startsWith("_exp_")) {
            return zza(str, zzjr.zzb, zzjr.zza, zzc);
        }
        return "experiment_id(" + str + ")";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String zza(Bundle bundle) {
        String valueOf;
        if (bundle == null) {
            return null;
        }
        if (!this.zzd.zza()) {
            return bundle.toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Bundle[{");
        for (String str : bundle.keySet()) {
            if (sb.length() != 8) {
                sb.append(", ");
            }
            sb.append(zzb(str));
            sb.append("=");
            Object obj = bundle.get(str);
            if (obj instanceof Bundle) {
                valueOf = zza(new Object[]{obj});
            } else if (obj instanceof Object[]) {
                valueOf = zza((Object[]) obj);
            } else if (obj instanceof ArrayList) {
                valueOf = zza(((ArrayList) obj).toArray());
            } else {
                valueOf = String.valueOf(obj);
            }
            sb.append(valueOf);
        }
        sb.append("}]");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String zza(zzbl zzblVar) {
        String str = null;
        if (zzblVar == null) {
            return null;
        }
        if (!this.zzd.zza()) {
            return zzblVar.toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("origin=");
        sb.append(zzblVar.zzc);
        sb.append(",name=");
        sb.append(zza(zzblVar.zza));
        sb.append(",params=");
        zzbg zzbgVar = zzblVar.zzb;
        if (zzbgVar != null) {
            if (!this.zzd.zza()) {
                str = zzbgVar.toString();
            } else {
                str = zza(zzbgVar.zzb());
            }
        }
        sb.append(str);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String zza(String str) {
        if (str == null) {
            return null;
        }
        return !this.zzd.zza() ? str : zza(str, zzjp.zzc, zzjp.zza, zza);
    }

    private static String zza(String str, String[] strArr, String[] strArr2, AtomicReference<String[]> atomicReference) {
        String str2;
        Preconditions.checkNotNull(strArr);
        Preconditions.checkNotNull(strArr2);
        Preconditions.checkNotNull(atomicReference);
        Preconditions.checkArgument(strArr.length == strArr2.length);
        for (int i5 = 0; i5 < strArr.length; i5++) {
            if (Objects.equals(str, strArr[i5])) {
                synchronized (atomicReference) {
                    try {
                        String[] strArr3 = atomicReference.get();
                        if (strArr3 == null) {
                            strArr3 = new String[strArr2.length];
                            atomicReference.set(strArr3);
                        }
                        if (strArr3[i5] == null) {
                            strArr3[i5] = strArr2[i5] + "(" + strArr[i5] + ")";
                        }
                        str2 = strArr3[i5];
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return str2;
            }
        }
        return str;
    }
}
