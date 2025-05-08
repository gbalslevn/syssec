package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import org.conscrypt.BuildConfig;

/* loaded from: classes.dex */
public final class zzgo extends zzji {
    private char zza;
    private long zzb;
    private String zzc;
    private final zzgq zzd;
    private final zzgq zze;
    private final zzgq zzf;
    private final zzgq zzg;
    private final zzgq zzh;
    private final zzgq zzi;
    private final zzgq zzj;
    private final zzgq zzk;
    private final zzgq zzl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgo(zzic zzicVar) {
        super(zzicVar);
        this.zza = (char) 0;
        this.zzb = -1L;
        this.zzd = new zzgq(this, 6, false, false);
        this.zze = new zzgq(this, 6, true, false);
        this.zzf = new zzgq(this, 6, false, true);
        this.zzg = new zzgq(this, 5, false, false);
        this.zzh = new zzgq(this, 5, true, false);
        this.zzi = new zzgq(this, 5, false, true);
        this.zzj = new zzgq(this, 4, false, false);
        this.zzk = new zzgq(this, 3, false, false);
        this.zzl = new zzgq(this, 2, false, false);
    }

    private final String zzz() {
        String str;
        synchronized (this) {
            try {
                if (this.zzc == null) {
                    this.zzc = this.zzu.zzy() != null ? this.zzu.zzy() : "FA";
                }
                Preconditions.checkNotNull(this.zzc);
                str = this.zzc;
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }

    public final zzgq zzc() {
        return this.zzk;
    }

    @Override // com.google.android.gms.measurement.internal.zzjf, com.google.android.gms.measurement.internal.zzjh
    public final /* bridge */ /* synthetic */ zzaf zzd() {
        return super.zzd();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ zzai zze() {
        return super.zze();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ zzbf zzf() {
        return super.zzf();
    }

    public final zzgq zzg() {
        return this.zzd;
    }

    @Override // com.google.android.gms.measurement.internal.zzji
    protected final boolean zzh() {
        return false;
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ zzgl zzi() {
        return super.zzi();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf, com.google.android.gms.measurement.internal.zzjh
    public final /* bridge */ /* synthetic */ zzgo zzj() {
        return super.zzj();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ zzha zzk() {
        return super.zzk();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf, com.google.android.gms.measurement.internal.zzjh
    public final /* bridge */ /* synthetic */ zzhv zzl() {
        return super.zzl();
    }

    public final zzgq zzm() {
        return this.zzf;
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ zzlp zzn() {
        return super.zzn();
    }

    public final zzgq zzo() {
        return this.zze;
    }

    public final zzgq zzp() {
        return this.zzj;
    }

    public final zzgq zzq() {
        return this.zzl;
    }

    public final zzgq zzr() {
        return this.zzg;
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ zzpn zzs() {
        return super.zzs();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ void zzt() {
        super.zzt();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ void zzu() {
        super.zzu();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ void zzv() {
        super.zzv();
    }

    public final zzgq zzw() {
        return this.zzi;
    }

    public final zzgq zzx() {
        return this.zzh;
    }

    public final String zzy() {
        Pair<String, Long> zza;
        if (zzk().zzb == null || (zza = zzk().zzb.zza()) == null || zza == zzha.zza) {
            return null;
        }
        return String.valueOf(zza.second) + ":" + ((String) zza.first);
    }

    @Override // com.google.android.gms.measurement.internal.zzjf, com.google.android.gms.measurement.internal.zzjh
    public final /* bridge */ /* synthetic */ Clock zzb() {
        return super.zzb();
    }

    private static String zzb(String str) {
        int lastIndexOf;
        return (TextUtils.isEmpty(str) || (lastIndexOf = str.lastIndexOf(46)) == -1) ? BuildConfig.FLAVOR : str.substring(0, lastIndexOf);
    }

    @Override // com.google.android.gms.measurement.internal.zzjf, com.google.android.gms.measurement.internal.zzjh
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Object zza(String str) {
        if (str == null) {
            return null;
        }
        return new zzgt(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zza(boolean z5, String str, Object obj, Object obj2, Object obj3) {
        String str2 = BuildConfig.FLAVOR;
        if (str == null) {
            str = BuildConfig.FLAVOR;
        }
        String zza = zza(z5, obj);
        String zza2 = zza(z5, obj2);
        String zza3 = zza(z5, obj3);
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            str2 = ": ";
        }
        String str3 = ", ";
        if (!TextUtils.isEmpty(zza)) {
            sb.append(str2);
            sb.append(zza);
            str2 = ", ";
        }
        if (TextUtils.isEmpty(zza2)) {
            str3 = str2;
        } else {
            sb.append(str2);
            sb.append(zza2);
        }
        if (!TextUtils.isEmpty(zza3)) {
            sb.append(str3);
            sb.append(zza3);
        }
        return sb.toString();
    }

    private static String zza(boolean z5, Object obj) {
        String str;
        String className;
        String str2 = BuildConfig.FLAVOR;
        if (obj == null) {
            return BuildConfig.FLAVOR;
        }
        if (obj instanceof Integer) {
            obj = Long.valueOf(((Integer) obj).intValue());
        }
        int i5 = 0;
        if (obj instanceof Long) {
            if (!z5) {
                return String.valueOf(obj);
            }
            Long l5 = (Long) obj;
            if (Math.abs(l5.longValue()) < 100) {
                return String.valueOf(obj);
            }
            if (String.valueOf(obj).charAt(0) == '-') {
                str2 = "-";
            }
            String valueOf = String.valueOf(Math.abs(l5.longValue()));
            return str2 + Math.round(Math.pow(10.0d, valueOf.length() - 1)) + "..." + str2 + Math.round(Math.pow(10.0d, valueOf.length()) - 1.0d);
        }
        if (obj instanceof Boolean) {
            return String.valueOf(obj);
        }
        if (obj instanceof Throwable) {
            Throwable th = (Throwable) obj;
            StringBuilder sb = new StringBuilder(z5 ? th.getClass().getName() : th.toString());
            String zzb = zzb(zzic.class.getCanonicalName());
            StackTraceElement[] stackTrace = th.getStackTrace();
            int length = stackTrace.length;
            while (true) {
                if (i5 >= length) {
                    break;
                }
                StackTraceElement stackTraceElement = stackTrace[i5];
                if (!stackTraceElement.isNativeMethod() && (className = stackTraceElement.getClassName()) != null && zzb(className).equals(zzb)) {
                    sb.append(": ");
                    sb.append(stackTraceElement);
                    break;
                }
                i5++;
            }
            return sb.toString();
        }
        if (!(obj instanceof zzgt)) {
            return z5 ? "-" : String.valueOf(obj);
        }
        str = ((zzgt) obj).zza;
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zza(int i5, boolean z5, boolean z6, String str, Object obj, Object obj2, Object obj3) {
        if (!z5 && zza(i5)) {
            zza(i5, zza(false, str, obj, obj2, obj3));
        }
        if (z6 || i5 < 5) {
            return;
        }
        Preconditions.checkNotNull(str);
        zzhv zzo = this.zzu.zzo();
        if (zzo == null) {
            zza(6, "Scheduler not set. Not logging error/warn");
            return;
        }
        if (!zzo.zzag()) {
            zza(6, "Scheduler not initialized. Not logging error/warn");
            return;
        }
        if (i5 < 0) {
            i5 = 0;
        }
        if (i5 >= 9) {
            i5 = 8;
        }
        zzo.zzb(new zzgr(this, i5, str, obj, obj2, obj3));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zza(int i5, String str) {
        Log.println(i5, zzz(), str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean zza(int i5) {
        return Log.isLoggable(zzz(), i5);
    }
}
