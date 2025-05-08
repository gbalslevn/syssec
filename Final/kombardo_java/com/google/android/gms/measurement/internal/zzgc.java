package com.google.android.gms.measurement.internal;

import android.os.IBinder;
import android.os.Parcel;
import java.util.List;

/* loaded from: classes.dex */
public final class zzgc extends com.google.android.gms.internal.measurement.zzbu implements zzga {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgc(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.ITriggerUrisCallback");
    }

    @Override // com.google.android.gms.measurement.internal.zzga
    public final void zza(List<zzog> list) {
        Parcel b_ = b_();
        b_.writeTypedList(list);
        zzc(2, b_);
    }
}
