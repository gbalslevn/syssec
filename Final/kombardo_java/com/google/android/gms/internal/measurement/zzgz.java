package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
final class zzgz extends ContentObserver {
    private final /* synthetic */ zzgx zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzgz(zzgx zzgxVar, Handler handler) {
        super(null);
        this.zza = zzgxVar;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z5) {
        AtomicBoolean atomicBoolean;
        atomicBoolean = this.zza.zza;
        atomicBoolean.set(true);
    }
}
