package com.google.android.finsky.externalreferrer;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.a.a;
import com.google.android.a.b;
import com.google.android.a.c;

/* loaded from: classes.dex */
public interface IGetInstallReferrerService extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class Stub extends b implements IGetInstallReferrerService {

        /* loaded from: classes.dex */
        public static class Proxy extends a implements IGetInstallReferrerService {
            Proxy(IBinder iBinder) {
                super(iBinder);
            }

            @Override // com.google.android.finsky.externalreferrer.IGetInstallReferrerService
            public final Bundle c(Bundle bundle) {
                Parcel a5 = a();
                c.b(a5, bundle);
                Parcel b5 = b(a5);
                Bundle bundle2 = (Bundle) c.a(b5, Bundle.CREATOR);
                b5.recycle();
                return bundle2;
            }
        }

        public static IGetInstallReferrerService b(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
            return queryLocalInterface instanceof IGetInstallReferrerService ? (IGetInstallReferrerService) queryLocalInterface : new Proxy(iBinder);
        }
    }

    Bundle c(Bundle bundle);
}
