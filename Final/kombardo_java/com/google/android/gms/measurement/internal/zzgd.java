package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class zzgd extends com.google.android.gms.internal.measurement.zzbx implements zzga {
    public zzgd() {
        super("com.google.android.gms.measurement.internal.ITriggerUrisCallback");
    }

    @Override // com.google.android.gms.internal.measurement.zzbx
    protected final boolean zza(int i5, Parcel parcel, Parcel parcel2, int i6) {
        if (i5 != 2) {
            return false;
        }
        ArrayList createTypedArrayList = parcel.createTypedArrayList(zzog.CREATOR);
        com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
        zza(createTypedArrayList);
        return true;
    }
}
