package com.google.android.gms.internal.measurement;

import android.os.Parcel;

/* loaded from: classes.dex */
public abstract class zzdu extends zzbx implements zzdr {
    public zzdu() {
        super("com.google.android.gms.measurement.api.internal.IDynamiteUploadBatchesCallback");
    }

    @Override // com.google.android.gms.internal.measurement.zzbx
    protected final boolean zza(int i5, Parcel parcel, Parcel parcel2, int i6) {
        if (i5 != 2) {
            return false;
        }
        a_();
        return true;
    }
}
