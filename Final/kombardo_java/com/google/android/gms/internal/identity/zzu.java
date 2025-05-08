package com.google.android.gms.internal.identity;

import android.location.Location;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.api.internal.IStatusCallback;
import com.google.android.gms.location.LastLocationRequest;
import com.google.android.gms.location.LocationRequest;

/* loaded from: classes.dex */
public final class zzu extends zza implements zzv {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.location.internal.IGoogleLocationManagerService");
    }

    @Override // com.google.android.gms.internal.identity.zzv
    public final void zzq(LastLocationRequest lastLocationRequest, zzee zzeeVar) {
        Parcel zza = zza();
        zzc.zzb(zza, lastLocationRequest);
        zzc.zzb(zza, zzeeVar);
        zzc(90, zza);
    }

    @Override // com.google.android.gms.internal.identity.zzv
    public final void zzr(LastLocationRequest lastLocationRequest, zzz zzzVar) {
        Parcel zza = zza();
        zzc.zzb(zza, lastLocationRequest);
        zzc.zzc(zza, zzzVar);
        zzc(82, zza);
    }

    @Override // com.google.android.gms.internal.identity.zzv
    public final Location zzs() {
        Parcel zzb = zzb(7, zza());
        Location location = (Location) zzc.zza(zzb, Location.CREATOR);
        zzb.recycle();
        return location;
    }

    @Override // com.google.android.gms.internal.identity.zzv
    public final void zzv(zzei zzeiVar) {
        Parcel zza = zza();
        zzc.zzb(zza, zzeiVar);
        zzc(59, zza);
    }

    @Override // com.google.android.gms.internal.identity.zzv
    public final void zzw(zzee zzeeVar, LocationRequest locationRequest, IStatusCallback iStatusCallback) {
        Parcel zza = zza();
        zzc.zzb(zza, zzeeVar);
        zzc.zzb(zza, locationRequest);
        zzc.zzc(zza, iStatusCallback);
        zzc(88, zza);
    }

    @Override // com.google.android.gms.internal.identity.zzv
    public final void zzx(zzee zzeeVar, IStatusCallback iStatusCallback) {
        Parcel zza = zza();
        zzc.zzb(zza, zzeeVar);
        zzc.zzc(zza, iStatusCallback);
        zzc(89, zza);
    }
}
