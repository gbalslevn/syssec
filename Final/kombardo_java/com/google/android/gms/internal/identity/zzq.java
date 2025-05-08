package com.google.android.gms.internal.identity;

import android.os.Parcel;

/* loaded from: classes.dex */
public abstract class zzq extends zzb implements zzr {
    public zzq() {
        super("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
    }

    @Override // com.google.android.gms.internal.identity.zzb
    protected final boolean zza(int i5, Parcel parcel, Parcel parcel2, int i6) {
        if (i5 == 1) {
            zzl zzlVar = (zzl) zzc.zza(parcel, zzl.CREATOR);
            zzc.zzd(parcel);
            zzd(zzlVar);
        } else {
            if (i5 != 2) {
                return false;
            }
            zze();
        }
        return true;
    }
}
