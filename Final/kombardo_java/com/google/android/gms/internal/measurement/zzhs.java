package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzhs extends ContentObserver {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhs(zzhq zzhqVar, Handler handler) {
        super(null);
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z5) {
        zzhx.zzc();
    }
}
