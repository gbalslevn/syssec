package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzia<V> extends FutureTask<V> implements Comparable<zzia<V>> {
    final boolean zza;
    private final long zzb;
    private final String zzc;
    private final /* synthetic */ zzhv zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzia(zzhv zzhvVar, Runnable runnable, boolean z5, String str) {
        super(com.google.android.gms.internal.measurement.zzdi.zza().zza(runnable), null);
        AtomicLong atomicLong;
        this.zzd = zzhvVar;
        Preconditions.checkNotNull(str);
        atomicLong = zzhv.zza;
        long andIncrement = atomicLong.getAndIncrement();
        this.zzb = andIncrement;
        this.zzc = str;
        this.zza = z5;
        if (andIncrement == Long.MAX_VALUE) {
            zzhvVar.zzj().zzg().zza("Tasks index overflow");
        }
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(Object obj) {
        zzia zziaVar = (zzia) obj;
        boolean z5 = this.zza;
        if (z5 != zziaVar.zza) {
            return z5 ? -1 : 1;
        }
        long j5 = this.zzb;
        long j6 = zziaVar.zzb;
        if (j5 < j6) {
            return -1;
        }
        if (j5 > j6) {
            return 1;
        }
        this.zzd.zzj().zzo().zza("Two tasks share the same index. index", Long.valueOf(this.zzb));
        return 0;
    }

    @Override // java.util.concurrent.FutureTask
    protected final void setException(Throwable th) {
        this.zzd.zzj().zzg().zza(this.zzc, th);
        super.setException(th);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzia(zzhv zzhvVar, Callable<V> callable, boolean z5, String str) {
        super(com.google.android.gms.internal.measurement.zzdi.zza().zza(callable));
        AtomicLong atomicLong;
        this.zzd = zzhvVar;
        Preconditions.checkNotNull(str);
        atomicLong = zzhv.zza;
        long andIncrement = atomicLong.getAndIncrement();
        this.zzb = andIncrement;
        this.zzc = str;
        this.zza = z5;
        if (andIncrement == Long.MAX_VALUE) {
            zzhvVar.zzj().zzg().zza("Tasks index overflow");
        }
    }
}
