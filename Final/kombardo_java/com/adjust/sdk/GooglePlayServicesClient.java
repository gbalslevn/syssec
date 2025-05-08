package com.adjust.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class GooglePlayServicesClient {

    /* loaded from: classes.dex */
    public static final class GooglePlayServicesInfo {
        private final String gpsAdid;
        private final Boolean trackingEnabled;

        public GooglePlayServicesInfo(String str, Boolean bool) {
            this.gpsAdid = str;
            this.trackingEnabled = bool;
        }

        public String getGpsAdid() {
            return this.gpsAdid;
        }

        public Boolean isTrackingEnabled() {
            return this.trackingEnabled;
        }
    }

    /* loaded from: classes.dex */
    public static final class a implements ServiceConnection {

        /* renamed from: a, reason: collision with root package name */
        public long f4137a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f4138b = false;

        /* renamed from: c, reason: collision with root package name */
        public final LinkedBlockingQueue<IBinder> f4139c = new LinkedBlockingQueue<>(1);

        public a(long j5) {
            this.f4137a = j5;
        }

        public final IBinder a() {
            if (this.f4138b) {
                throw new IllegalStateException();
            }
            this.f4138b = true;
            return this.f4139c.poll(this.f4137a, TimeUnit.MILLISECONDS);
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f4139c.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public static GooglePlayServicesInfo getGooglePlayServicesInfo(Context context, long j5) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("Google Play Services info can't be accessed from the main thread");
        }
        context.getPackageManager().getPackageInfo("com.android.vending", 0);
        a aVar = new a(j5);
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        try {
            if (!context.bindService(intent, aVar, 1)) {
                throw new IOException("Google Play connection failed");
            }
            try {
                IBinder a5 = aVar.a();
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    a5.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    obtain = Parcel.obtain();
                    obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                        obtain.writeInt(1);
                        a5.transact(2, obtain, obtain2, 0);
                        obtain2.readException();
                        boolean z5 = obtain2.readInt() != 0;
                        obtain2.recycle();
                        obtain.recycle();
                        return new GooglePlayServicesInfo(readString, Boolean.valueOf(!z5));
                    } finally {
                    }
                } finally {
                }
            } catch (Exception e5) {
                throw e5;
            }
        } finally {
            context.unbindService(aVar);
        }
    }
}
