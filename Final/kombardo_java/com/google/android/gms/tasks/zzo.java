package com.google.android.gms.tasks;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
final class zzo implements Runnable {
    final /* synthetic */ Task zza;
    final /* synthetic */ zzp zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzo(zzp zzpVar, Task task) {
        this.zzb = zzpVar;
        this.zza = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SuccessContinuation successContinuation;
        try {
            successContinuation = this.zzb.zzb;
            Task then = successContinuation.then(this.zza.getResult());
            if (then == null) {
                this.zzb.onFailure(new NullPointerException("Continuation returned null"));
                return;
            }
            zzp zzpVar = this.zzb;
            Executor executor = TaskExecutors.zza;
            then.addOnSuccessListener(executor, zzpVar);
            then.addOnFailureListener(executor, this.zzb);
            then.addOnCanceledListener(executor, this.zzb);
        } catch (RuntimeExecutionException e5) {
            if (e5.getCause() instanceof Exception) {
                this.zzb.onFailure((Exception) e5.getCause());
            } else {
                this.zzb.onFailure(e5);
            }
        } catch (CancellationException unused) {
            this.zzb.onCanceled();
        } catch (Exception e6) {
            this.zzb.onFailure(e6);
        }
    }
}
