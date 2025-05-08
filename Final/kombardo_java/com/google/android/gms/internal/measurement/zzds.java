package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class zzds extends zzbu implements zzdq {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzds(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IBundleReceiver");
    }

    @Override // com.google.android.gms.internal.measurement.zzdq
    public final void zza(Bundle bundle) {
        Parcel b_ = b_();
        zzbw.zza(b_, bundle);
        zzb(1, b_);
    }
}
