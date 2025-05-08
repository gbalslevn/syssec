package com.google.android.gms.internal.measurement;

import android.content.Context;
import com.google.android.gms.internal.measurement.zzht;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public abstract class zzhx<T> {
    private static final Object zza = new Object();
    private static volatile zzie zzb = null;
    private static volatile boolean zzc = false;
    private static zzii zzd;
    private static final AtomicInteger zze;
    private final zzif zzf;
    private final String zzg;
    private Object zzh;
    private volatile int zzi;
    private volatile T zzj;
    private final boolean zzk;
    private volatile boolean zzl;

    static {
        new AtomicReference();
        zzd = new zzii(new zzil() { // from class: com.google.android.gms.internal.measurement.zzhy
            @Override // com.google.android.gms.internal.measurement.zzil
            public final boolean zza() {
                return zzhx.zzd();
            }
        });
        zze = new AtomicInteger();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ zzhx zza(zzif zzifVar, String str, Boolean bool, boolean z5) {
        return new zzia(zzifVar, str, bool, true);
    }

    private final T zzb(zzie zzieVar) {
        zzhl zza2;
        Object zza3;
        if (this.zzf.zzb != null) {
            if (!zzhv.zza(zzieVar.zza(), this.zzf.zzb)) {
                zza2 = null;
            } else if (this.zzf.zzg) {
                zza2 = zzhi.zza(zzieVar.zza().getContentResolver(), zzhu.zza(zzhu.zza(zzieVar.zza(), this.zzf.zzb.getLastPathSegment())), new Runnable() { // from class: com.google.android.gms.internal.measurement.zzhw
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzhx.zzc();
                    }
                });
            } else {
                zza2 = zzhi.zza(zzieVar.zza().getContentResolver(), this.zzf.zzb, new Runnable() { // from class: com.google.android.gms.internal.measurement.zzhw
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzhx.zzc();
                    }
                });
            }
        } else {
            zza2 = zzig.zza(zzieVar.zza(), this.zzf.zza, new Runnable() { // from class: com.google.android.gms.internal.measurement.zzhw
                @Override // java.lang.Runnable
                public final void run() {
                    zzhx.zzc();
                }
            });
        }
        if (zza2 == null || (zza3 = zza2.zza(zzb())) == null) {
            return null;
        }
        return zza(zza3);
    }

    public static void zzc() {
        zze.incrementAndGet();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean zzd() {
        return true;
    }

    private final T zze() {
        return (T) this.zzh;
    }

    abstract T zza(Object obj);

    private zzhx(zzif zzifVar, String str, T t5, boolean z5) {
        this.zzi = -1;
        String str2 = zzifVar.zza;
        if (str2 == null && zzifVar.zzb == null) {
            throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
        }
        if (str2 != null && zzifVar.zzb != null) {
            throw new IllegalArgumentException("Must pass one of SharedPreferences file name or ContentProvider URI");
        }
        this.zzf = zzifVar;
        this.zzg = str;
        this.zzh = t5;
        this.zzk = z5;
        this.zzl = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ zzhx zza(zzif zzifVar, String str, Double d5, boolean z5) {
        return new zzid(zzifVar, str, d5, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ zzhx zza(zzif zzifVar, String str, Long l5, boolean z5) {
        return new zzib(zzifVar, str, l5, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ zzhx zza(zzif zzifVar, String str, String str2, boolean z5) {
        return new zzic(zzifVar, str, str2, true);
    }

    public final T zza() {
        T zzb2;
        if (!this.zzk) {
            Preconditions.checkState(zzd.zza(this.zzg), "Attempt to access PhenotypeFlag not via codegen. All new PhenotypeFlags must be accessed through codegen APIs. If you believe you are seeing this error by mistake, you can add your flag to the exemption list located at //java/com/google/android/libraries/phenotype/client/lockdown/flags.textproto. Send the addition CL to ph-reviews@. See go/phenotype-android-codegen for information about generated code. See go/ph-lockdown for more information about this error.");
        }
        int i5 = zze.get();
        if (this.zzi < i5) {
            synchronized (this) {
                try {
                    if (this.zzi < i5) {
                        zzie zzieVar = zzb;
                        Optional<zzhr> absent = Optional.absent();
                        String str = null;
                        if (zzieVar != null) {
                            absent = zzieVar.zzb().get();
                            if (absent.isPresent()) {
                                zzhr zzhrVar = absent.get();
                                zzif zzifVar = this.zzf;
                                str = zzhrVar.zza(zzifVar.zzb, zzifVar.zza, zzifVar.zzd, this.zzg);
                            }
                        }
                        Preconditions.checkState(zzieVar != null, "Must call PhenotypeFlagInitializer.maybeInit() first");
                        if (!this.zzf.zzf ? (zzb2 = zzb(zzieVar)) == null && (zzb2 = zza(zzieVar)) == null : (zzb2 = zza(zzieVar)) == null && (zzb2 = zzb(zzieVar)) == null) {
                            zzb2 = zze();
                        }
                        if (absent.isPresent()) {
                            zzb2 = str == null ? zze() : zza((Object) str);
                        }
                        this.zzj = zzb2;
                        this.zzi = i5;
                    }
                } finally {
                }
            }
        }
        return this.zzj;
    }

    public final String zzb() {
        return zza(this.zzf.zzd);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0048, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x004d, code lost:
    
        throw r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void zzb(final Context context) {
        if (zzb != null || context == null) {
            return;
        }
        Object obj = zza;
        synchronized (obj) {
            try {
                if (zzb == null) {
                    synchronized (obj) {
                        zzie zzieVar = zzb;
                        Context applicationContext = context.getApplicationContext();
                        if (applicationContext != null) {
                            context = applicationContext;
                        }
                        if (zzieVar != null) {
                            if (zzieVar.zza() != context) {
                            }
                        }
                        if (zzieVar != null) {
                            zzhi.zzb();
                            zzig.zza();
                            zzhq.zza();
                        }
                        zzb = new zzhf(context, Suppliers.memoize(new Supplier() { // from class: com.google.android.gms.internal.measurement.zzhz
                            @Override // com.google.common.base.Supplier
                            public final Object get() {
                                Optional zza2;
                                zza2 = zzht.zza.zza(context);
                                return zza2;
                            }
                        }));
                        zze.incrementAndGet();
                    }
                }
            } finally {
            }
        }
    }

    private final T zza(zzie zzieVar) {
        Function<Context, Boolean> function;
        zzif zzifVar = this.zzf;
        if (!zzifVar.zze && ((function = zzifVar.zzh) == null || function.apply(zzieVar.zza()).booleanValue())) {
            zzhq zza2 = zzhq.zza(zzieVar.zza());
            zzif zzifVar2 = this.zzf;
            Object zza3 = zza2.zza(zzifVar2.zze ? null : zza(zzifVar2.zzc));
            if (zza3 != null) {
                return zza(zza3);
            }
        }
        return null;
    }

    private final String zza(String str) {
        if (str != null && str.isEmpty()) {
            return this.zzg;
        }
        return str + this.zzg;
    }
}
