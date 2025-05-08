package com.google.android.gms.signin.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class zaf extends com.google.android.gms.internal.base.zaa implements IInterface {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zaf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.signin.internal.ISignInService");
    }

    public final void zag(zai zaiVar, zae zaeVar) {
        Parcel zaa = zaa();
        com.google.android.gms.internal.base.zac.zac(zaa, zaiVar);
        com.google.android.gms.internal.base.zac.zad(zaa, zaeVar);
        zac(12, zaa);
    }
}
