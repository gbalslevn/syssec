package com.google.android.a;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes.dex */
public abstract class a implements IInterface {

    /* renamed from: a, reason: collision with root package name */
    private final IBinder f4306a;

    /* renamed from: b, reason: collision with root package name */
    private final String f4307b = "com.google.android.finsky.externalreferrer.IGetInstallReferrerService";

    /* JADX INFO: Access modifiers changed from: protected */
    public a(IBinder iBinder) {
        this.f4306a = iBinder;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Parcel a() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f4307b);
        return obtain;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f4306a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Parcel b(Parcel parcel) {
        Parcel obtain = Parcel.obtain();
        try {
            try {
                this.f4306a.transact(1, parcel, obtain, 0);
                obtain.readException();
                return obtain;
            } catch (RuntimeException e5) {
                obtain.recycle();
                throw e5;
            }
        } finally {
            parcel.recycle();
        }
    }
}
