package com.google.android.gms.cloudmessaging;

import android.os.Bundle;

/* loaded from: classes.dex */
final class zzr extends zzs {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzr(int i5, int i6, Bundle bundle) {
        super(i5, i6, bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.cloudmessaging.zzs
    public final void zza(Bundle bundle) {
        if (bundle.getBoolean("ack", false)) {
            zzd(null);
        } else {
            zzc(new zzt(4, "Invalid response to one way request", null));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.cloudmessaging.zzs
    public final boolean zzb() {
        return true;
    }
}
