package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class zzca extends zzbu implements zzbz {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzca(IBinder iBinder) {
        super(iBinder, "com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
    }

    @Override // com.google.android.gms.internal.measurement.zzbz
    public final Bundle zza(Bundle bundle) {
        Parcel b_ = b_();
        zzbw.zza(b_, bundle);
        Parcel zza = zza(1, b_);
        Bundle bundle2 = (Bundle) zzbw.zza(zza, Bundle.CREATOR);
        zza.recycle();
        return bundle2;
    }
}
