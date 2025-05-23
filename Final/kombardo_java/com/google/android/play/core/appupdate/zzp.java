package com.google.android.play.core.appupdate;

import android.os.Bundle;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.play.core.install.InstallException;

/* loaded from: classes.dex */
final class zzp extends zzo {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzp(zzr zzrVar, TaskCompletionSource taskCompletionSource) {
        super(zzrVar, new com.google.android.play.core.appupdate.internal.zzm("OnCompleteUpdateCallback"), taskCompletionSource);
    }

    @Override // com.google.android.play.core.appupdate.zzo, com.google.android.play.core.appupdate.internal.zzh
    public final void zzb(Bundle bundle) {
        int i5;
        int i6;
        super.zzb(bundle);
        i5 = bundle.getInt("error.code", -2);
        if (i5 == 0) {
            this.zzb.trySetResult(null);
            return;
        }
        TaskCompletionSource taskCompletionSource = this.zzb;
        i6 = bundle.getInt("error.code", -2);
        taskCompletionSource.trySetException(new InstallException(i6));
    }
}
