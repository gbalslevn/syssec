package com.google.android.gms.measurement.internal;

import android.os.Parcel;

/* loaded from: classes.dex */
public abstract class zzge extends com.google.android.gms.internal.measurement.zzbx implements zzgf {
    public zzge() {
        super("com.google.android.gms.measurement.internal.IUploadBatchesCallback");
    }

    @Override // com.google.android.gms.internal.measurement.zzbx
    protected final boolean zza(int i5, Parcel parcel, Parcel parcel2, int i6) {
        if (i5 != 2) {
            return false;
        }
        zzor zzorVar = (zzor) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzor.CREATOR);
        com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
        zza(zzorVar);
        return true;
    }
}
