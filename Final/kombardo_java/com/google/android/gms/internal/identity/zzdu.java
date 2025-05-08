package com.google.android.gms.internal.identity;

import com.google.android.gms.common.api.internal.ListenerHolder;

/* loaded from: classes.dex */
final class zzdu implements ListenerHolder.Notifier {
    final /* synthetic */ zzdv zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdu(zzdv zzdvVar) {
        this.zza = zzdvVar;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* bridge */ /* synthetic */ void notifyListener(Object obj) {
        this.zza.zzh().zzc();
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final void onNotifyListenerFailed() {
    }
}
