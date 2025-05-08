package com.google.android.gms.location;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.identity.zzb;
import com.google.android.gms.internal.identity.zzc;

/* loaded from: classes.dex */
public abstract class zzv extends zzb implements zzw {
    public zzv() {
        super("com.google.android.gms.location.ILocationCallback");
    }

    public static zzw zzb(IBinder iBinder) {
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.ILocationCallback");
        return queryLocalInterface instanceof zzw ? (zzw) queryLocalInterface : new zzu(iBinder);
    }

    @Override // com.google.android.gms.internal.identity.zzb
    protected final boolean zza(int i5, Parcel parcel, Parcel parcel2, int i6) {
        if (i5 == 1) {
            LocationResult locationResult = (LocationResult) zzc.zza(parcel, LocationResult.CREATOR);
            zzc.zzd(parcel);
            zzd(locationResult);
        } else if (i5 == 2) {
            LocationAvailability locationAvailability = (LocationAvailability) zzc.zza(parcel, LocationAvailability.CREATOR);
            zzc.zzd(parcel);
            zze(locationAvailability);
        } else {
            if (i5 != 3) {
                return false;
            }
            zzf();
        }
        return true;
    }
}
