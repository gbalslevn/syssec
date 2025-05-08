package com.google.android.gms.internal.identity;

import android.location.Location;
import android.os.IInterface;
import com.google.android.gms.common.api.internal.IStatusCallback;
import com.google.android.gms.location.LastLocationRequest;
import com.google.android.gms.location.LocationRequest;

/* loaded from: classes.dex */
public interface zzv extends IInterface {
    void zzq(LastLocationRequest lastLocationRequest, zzee zzeeVar);

    @Deprecated
    void zzr(LastLocationRequest lastLocationRequest, zzz zzzVar);

    @Deprecated
    Location zzs();

    @Deprecated
    void zzv(zzei zzeiVar);

    void zzw(zzee zzeeVar, LocationRequest locationRequest, IStatusCallback iStatusCallback);

    void zzx(zzee zzeeVar, IStatusCallback iStatusCallback);
}
