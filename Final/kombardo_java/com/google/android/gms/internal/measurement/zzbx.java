package com.google.android.gms.internal.measurement;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes.dex */
public abstract class zzbx extends Binder implements IInterface {
    /* JADX INFO: Access modifiers changed from: protected */
    public zzbx(String str) {
        attachInterface(this, str);
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i5, Parcel parcel, Parcel parcel2, int i6) {
        boolean z5;
        if (i5 > 16777215) {
            z5 = super.onTransact(i5, parcel, parcel2, i6);
        } else {
            parcel.enforceInterface(getInterfaceDescriptor());
            z5 = false;
        }
        if (z5) {
            return true;
        }
        return zza(i5, parcel, parcel2, i6);
    }

    protected abstract boolean zza(int i5, Parcel parcel, Parcel parcel2, int i6);
}
