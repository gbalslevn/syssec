package com.google.android.gms.location;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.internal.identity.zzb;

/* loaded from: classes.dex */
public abstract class zzy extends zzb implements zzz {
    public static zzz zzb(IBinder iBinder) {
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.ILocationListener");
        return queryLocalInterface instanceof zzz ? (zzz) queryLocalInterface : new zzx(iBinder);
    }
}
