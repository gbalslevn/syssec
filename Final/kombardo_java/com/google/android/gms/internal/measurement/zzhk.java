package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;

/* loaded from: classes.dex */
final class zzhk extends ContentObserver {
    private final /* synthetic */ zzhi zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzhk(zzhi zzhiVar, Handler handler) {
        super(null);
        this.zza = zzhiVar;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z5) {
        this.zza.zzc();
    }
}
