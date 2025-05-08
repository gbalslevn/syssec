package com.facebook.ppml.receiver;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes.dex */
public interface IReceiverService extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements IReceiverService {
        private static final String DESCRIPTOR = "com.facebook.ppml.receiver.IReceiverService";

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class Proxy implements IReceiverService {
            public static IReceiverService sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.facebook.ppml.receiver.IReceiverService
            public int sendEvents(Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        int sendEvents = Stub.getDefaultImpl().sendEvents(bundle);
                        obtain2.recycle();
                        obtain.recycle();
                        return sendEvents;
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    return readInt;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }
        }

        public static IReceiverService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IReceiverService)) ? new Proxy(iBinder) : (IReceiverService) queryLocalInterface;
        }

        public static IReceiverService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }

    int sendEvents(Bundle bundle);
}
