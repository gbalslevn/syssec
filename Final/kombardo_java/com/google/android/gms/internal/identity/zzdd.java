package com.google.android.gms.internal.identity;

import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.location.zzw;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
final class zzdd extends zzq {
    final /* synthetic */ TaskCompletionSource zza;
    final /* synthetic */ zzw zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdd(TaskCompletionSource taskCompletionSource, zzw zzwVar) {
        this.zza = taskCompletionSource;
        this.zzb = zzwVar;
    }

    @Override // com.google.android.gms.internal.identity.zzr
    public final void zzd(zzl zzlVar) {
        TaskUtil.setResultOrApiException(zzlVar.getStatus(), this.zza);
    }

    @Override // com.google.android.gms.internal.identity.zzr
    public final void zze() {
        this.zzb.zzf();
    }
}
