package com.google.android.gms.common.internal;

import android.content.Intent;
import com.google.android.gms.common.api.internal.LifecycleFragment;

/* loaded from: classes.dex */
final class zaf extends zag {
    final /* synthetic */ Intent zaa;
    final /* synthetic */ LifecycleFragment zab;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zaf(Intent intent, LifecycleFragment lifecycleFragment, int i5) {
        this.zaa = intent;
        this.zab = lifecycleFragment;
    }

    @Override // com.google.android.gms.common.internal.zag
    public final void zaa() {
        Intent intent = this.zaa;
        if (intent != null) {
            this.zab.startActivityForResult(intent, 2);
        }
    }
}
