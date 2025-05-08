package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class zzdy extends zzbu implements zzdw {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdy(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
    }

    @Override // com.google.android.gms.internal.measurement.zzdw
    public final int zza() {
        Parcel zza = zza(2, b_());
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.internal.measurement.zzdw
    public final void zza(String str, String str2, Bundle bundle, long j5) {
        Parcel b_ = b_();
        b_.writeString(str);
        b_.writeString(str2);
        zzbw.zza(b_, bundle);
        b_.writeLong(j5);
        zzb(1, b_);
    }
}
