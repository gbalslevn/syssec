package com.google.android.gms.stats;

import android.content.Context;
import android.os.PowerManager;
import android.os.WorkSource;
import android.support.v4.media.session.a;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.common.util.WorkSourceUtil;
import com.google.android.gms.internal.stats.zzh;
import com.google.android.gms.internal.stats.zzi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class WakeLock {
    private static final long zzb = TimeUnit.DAYS.toMillis(366);
    private static volatile ScheduledExecutorService zzc = null;
    private static final Object zzd = new Object();
    private static volatile zzd zze = new zzb();
    com.google.android.gms.internal.stats.zzb zza;
    private final Object zzf;
    private final PowerManager.WakeLock zzg;
    private int zzh;
    private Future<?> zzi;
    private long zzj;
    private final Set<Object> zzk;
    private boolean zzl;
    private int zzm;
    private Clock zzn;
    private WorkSource zzo;
    private final String zzp;
    private final String zzq;
    private final Context zzr;
    private final Map<String, zzc> zzs;
    private AtomicInteger zzt;
    private final ScheduledExecutorService zzu;

    public WakeLock(Context context, int i5, String str) {
        String packageName = context.getPackageName();
        this.zzf = new Object();
        this.zzh = 0;
        this.zzk = new HashSet();
        this.zzl = true;
        this.zzn = DefaultClock.getInstance();
        this.zzs = new HashMap();
        this.zzt = new AtomicInteger(0);
        Preconditions.checkNotNull(context, "WakeLock: context must not be null");
        Preconditions.checkNotEmpty(str, "WakeLock: wakeLockName must not be empty");
        this.zzr = context.getApplicationContext();
        this.zzq = str;
        this.zza = null;
        if ("com.google.android.gms".equals(context.getPackageName())) {
            this.zzp = str;
        } else {
            String valueOf = String.valueOf(str);
            this.zzp = valueOf.length() != 0 ? "*gcore*:".concat(valueOf) : new String("*gcore*:");
        }
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager == null) {
            StringBuilder sb = new StringBuilder(29);
            sb.append((CharSequence) "expected a non-null reference", 0, 29);
            throw new zzi(sb.toString());
        }
        PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(i5, str);
        this.zzg = newWakeLock;
        if (WorkSourceUtil.hasWorkSourcePermission(context)) {
            WorkSource fromPackage = WorkSourceUtil.fromPackage(context, Strings.isEmptyOrWhitespace(packageName) ? context.getPackageName() : packageName);
            this.zzo = fromPackage;
            if (fromPackage != null) {
                zze(newWakeLock, fromPackage);
            }
        }
        ScheduledExecutorService scheduledExecutorService = zzc;
        if (scheduledExecutorService == null) {
            synchronized (zzd) {
                try {
                    scheduledExecutorService = zzc;
                    if (scheduledExecutorService == null) {
                        zzh.zza();
                        scheduledExecutorService = Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1));
                        zzc = scheduledExecutorService;
                    }
                } finally {
                }
            }
        }
        this.zzu = scheduledExecutorService;
    }

    public static /* synthetic */ void zza(WakeLock wakeLock) {
        synchronized (wakeLock.zzf) {
            try {
                if (wakeLock.isHeld()) {
                    Log.e("WakeLock", String.valueOf(wakeLock.zzp).concat(" ** IS FORCE-RELEASED ON TIMEOUT **"));
                    wakeLock.zzc();
                    if (wakeLock.isHeld()) {
                        wakeLock.zzh = 1;
                        wakeLock.zzd(0);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final String zzb(String str) {
        if (this.zzl) {
            TextUtils.isEmpty(null);
        }
        return null;
    }

    private final void zzc() {
        if (this.zzk.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList(this.zzk);
        this.zzk.clear();
        if (arrayList.size() <= 0) {
            return;
        }
        a.a(arrayList.get(0));
        throw null;
    }

    private final void zzd(int i5) {
        synchronized (this.zzf) {
            try {
                if (isHeld()) {
                    if (this.zzl) {
                        int i6 = this.zzh - 1;
                        this.zzh = i6;
                        if (i6 > 0) {
                            return;
                        }
                    } else {
                        this.zzh = 0;
                    }
                    zzc();
                    Iterator<zzc> it = this.zzs.values().iterator();
                    while (it.hasNext()) {
                        it.next().zza = 0;
                    }
                    this.zzs.clear();
                    Future<?> future = this.zzi;
                    if (future != null) {
                        future.cancel(false);
                        this.zzi = null;
                        this.zzj = 0L;
                    }
                    this.zzm = 0;
                    if (this.zzg.isHeld()) {
                        try {
                            try {
                                this.zzg.release();
                                if (this.zza != null) {
                                    this.zza = null;
                                }
                            } catch (RuntimeException e5) {
                                if (!e5.getClass().equals(RuntimeException.class)) {
                                    throw e5;
                                }
                                Log.e("WakeLock", String.valueOf(this.zzp).concat(" failed to release!"), e5);
                                if (this.zza != null) {
                                    this.zza = null;
                                }
                            }
                        } catch (Throwable th) {
                            if (this.zza != null) {
                                this.zza = null;
                            }
                            throw th;
                        }
                    } else {
                        Log.e("WakeLock", String.valueOf(this.zzp).concat(" should be held!"));
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private static void zze(PowerManager.WakeLock wakeLock, WorkSource workSource) {
        try {
            wakeLock.setWorkSource(workSource);
        } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e5) {
            Log.wtf("WakeLock", e5.toString());
        }
    }

    public void acquire(long j5) {
        this.zzt.incrementAndGet();
        long max = Math.max(Math.min(Long.MAX_VALUE, zzb), 1L);
        if (j5 > 0) {
            max = Math.min(j5, max);
        }
        synchronized (this.zzf) {
            try {
                if (!isHeld()) {
                    this.zza = com.google.android.gms.internal.stats.zzb.zza(false, null);
                    this.zzg.acquire();
                    this.zzn.elapsedRealtime();
                }
                this.zzh++;
                this.zzm++;
                zzb(null);
                zzc zzcVar = this.zzs.get(null);
                if (zzcVar == null) {
                    zzcVar = new zzc(null);
                    this.zzs.put(null, zzcVar);
                }
                zzcVar.zza++;
                long elapsedRealtime = this.zzn.elapsedRealtime();
                long j6 = Long.MAX_VALUE - elapsedRealtime > max ? elapsedRealtime + max : Long.MAX_VALUE;
                if (j6 > this.zzj) {
                    this.zzj = j6;
                    Future<?> future = this.zzi;
                    if (future != null) {
                        future.cancel(false);
                    }
                    this.zzi = this.zzu.schedule(new Runnable() { // from class: com.google.android.gms.stats.zza
                        @Override // java.lang.Runnable
                        public final void run() {
                            WakeLock.zza(WakeLock.this);
                        }
                    }, max, TimeUnit.MILLISECONDS);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean isHeld() {
        boolean z5;
        synchronized (this.zzf) {
            z5 = this.zzh > 0;
        }
        return z5;
    }

    public void release() {
        if (this.zzt.decrementAndGet() < 0) {
            Log.e("WakeLock", String.valueOf(this.zzp).concat(" release without a matched acquire!"));
        }
        synchronized (this.zzf) {
            try {
                zzb(null);
                if (this.zzs.containsKey(null)) {
                    zzc zzcVar = this.zzs.get(null);
                    if (zzcVar != null) {
                        int i5 = zzcVar.zza - 1;
                        zzcVar.zza = i5;
                        if (i5 == 0) {
                            this.zzs.remove(null);
                        }
                    }
                } else {
                    Log.w("WakeLock", String.valueOf(this.zzp).concat(" counter does not exist"));
                }
                zzd(0);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void setReferenceCounted(boolean z5) {
        synchronized (this.zzf) {
            this.zzl = z5;
        }
    }
}
