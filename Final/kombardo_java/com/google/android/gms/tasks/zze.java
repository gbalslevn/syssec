package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
final class zze implements Runnable {
    final /* synthetic */ Task zza;
    final /* synthetic */ zzf zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zze(zzf zzfVar, Task task) {
        this.zzb = zzfVar;
        this.zza = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzw zzwVar;
        zzw zzwVar2;
        zzw zzwVar3;
        Continuation continuation;
        try {
            continuation = this.zzb.zzb;
            Task task = (Task) continuation.then(this.zza);
            if (task == null) {
                this.zzb.onFailure(new NullPointerException("Continuation returned null"));
                return;
            }
            zzf zzfVar = this.zzb;
            Executor executor = TaskExecutors.zza;
            task.addOnSuccessListener(executor, zzfVar);
            task.addOnFailureListener(executor, this.zzb);
            task.addOnCanceledListener(executor, this.zzb);
        } catch (RuntimeExecutionException e5) {
            if (e5.getCause() instanceof Exception) {
                zzwVar3 = this.zzb.zzc;
                zzwVar3.zza((Exception) e5.getCause());
            } else {
                zzwVar2 = this.zzb.zzc;
                zzwVar2.zza(e5);
            }
        } catch (Exception e6) {
            zzwVar = this.zzb.zzc;
            zzwVar.zza(e6);
        }
    }
}
