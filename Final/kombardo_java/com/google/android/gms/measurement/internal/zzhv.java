package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import java.lang.Thread;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class zzhv extends zzji {
    private static final AtomicLong zza = new AtomicLong(Long.MIN_VALUE);
    private zzhz zzb;
    private zzhz zzc;
    private final PriorityBlockingQueue<zzia<?>> zzd;
    private final BlockingQueue<zzia<?>> zze;
    private final Thread.UncaughtExceptionHandler zzf;
    private final Thread.UncaughtExceptionHandler zzg;
    private final Object zzh;
    private final Semaphore zzi;
    private volatile boolean zzj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhv(zzic zzicVar) {
        super(zzicVar);
        this.zzh = new Object();
        this.zzi = new Semaphore(2);
        this.zzd = new PriorityBlockingQueue<>();
        this.zze = new LinkedBlockingQueue();
        this.zzf = new zzhx(this, "Thread death: Uncaught exception on worker thread");
        this.zzg = new zzhx(this, "Thread death: Uncaught exception on network thread");
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ zzbf zzf() {
        return super.zzf();
    }

    public final boolean zzg() {
        return Thread.currentThread() == this.zzc;
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

    public final boolean zzm() {
        return Thread.currentThread() == this.zzb;
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ zzlp zzn() {
        return super.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ zzpn zzs() {
        return super.zzs();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    public final void zzt() {
        if (Thread.currentThread() != this.zzc) {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ void zzu() {
        super.zzu();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    public final void zzv() {
        if (Thread.currentThread() != this.zzb) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzjf, com.google.android.gms.measurement.internal.zzjh
    public final /* bridge */ /* synthetic */ zzaf zzd() {
        return super.zzd();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ zzai zze() {
        return super.zze();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf, com.google.android.gms.measurement.internal.zzjh
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf, com.google.android.gms.measurement.internal.zzjh
    public final /* bridge */ /* synthetic */ Clock zzb() {
        return super.zzb();
    }

    public final void zzc(Runnable runnable) {
        zzad();
        Preconditions.checkNotNull(runnable);
        zza(new zzia<>(this, runnable, true, "Task exception on worker thread"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final <T> T zza(AtomicReference<T> atomicReference, long j5, String str, Runnable runnable) {
        synchronized (atomicReference) {
            zzl().zzb(runnable);
            try {
                atomicReference.wait(j5);
            } catch (InterruptedException unused) {
                zzj().zzr().zza("Interrupted waiting for " + str);
                return null;
            }
        }
        T t5 = atomicReference.get();
        if (t5 == null) {
            zzj().zzr().zza("Timed out waiting for " + str);
        }
        return t5;
    }

    public final <V> Future<V> zzb(Callable<V> callable) {
        zzad();
        Preconditions.checkNotNull(callable);
        zzia<?> zziaVar = new zzia<>(this, (Callable<?>) callable, true, "Task exception on worker thread");
        if (Thread.currentThread() == this.zzb) {
            zziaVar.run();
        } else {
            zza(zziaVar);
        }
        return zziaVar;
    }

    public final void zzb(Runnable runnable) {
        zzad();
        Preconditions.checkNotNull(runnable);
        zza(new zzia<>(this, runnable, false, "Task exception on worker thread"));
    }

    public final <V> Future<V> zza(Callable<V> callable) {
        zzad();
        Preconditions.checkNotNull(callable);
        zzia<?> zziaVar = new zzia<>(this, (Callable<?>) callable, false, "Task exception on worker thread");
        if (Thread.currentThread() == this.zzb) {
            if (!this.zzd.isEmpty()) {
                zzj().zzr().zza("Callable skipped the worker queue.");
            }
            zziaVar.run();
        } else {
            zza(zziaVar);
        }
        return zziaVar;
    }

    private final void zza(zzia<?> zziaVar) {
        synchronized (this.zzh) {
            try {
                this.zzd.add(zziaVar);
                zzhz zzhzVar = this.zzb;
                if (zzhzVar == null) {
                    zzhz zzhzVar2 = new zzhz(this, "Measurement Worker", this.zzd);
                    this.zzb = zzhzVar2;
                    zzhzVar2.setUncaughtExceptionHandler(this.zzf);
                    this.zzb.start();
                } else {
                    zzhzVar.zza();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zza(Runnable runnable) {
        zzad();
        Preconditions.checkNotNull(runnable);
        zzia<?> zziaVar = new zzia<>(this, runnable, false, "Task exception on network thread");
        synchronized (this.zzh) {
            try {
                this.zze.add(zziaVar);
                zzhz zzhzVar = this.zzc;
                if (zzhzVar == null) {
                    zzhz zzhzVar2 = new zzhz(this, "Measurement Network", this.zze);
                    this.zzc = zzhzVar2;
                    zzhzVar2.setUncaughtExceptionHandler(this.zzg);
                    this.zzc.start();
                } else {
                    zzhzVar.zza();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
