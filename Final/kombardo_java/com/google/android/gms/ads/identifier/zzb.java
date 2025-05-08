package com.google.android.gms.ads.identifier;

import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
final class zzb extends Thread {
    final CountDownLatch zza;
    private final WeakReference zzb;
    private final long zzc;

    public zzb(AdvertisingIdClient advertisingIdClient, long j5) {
        super("AdIdClientAutoDisconnectThread");
        this.zzb = new WeakReference(advertisingIdClient);
        this.zzc = j5;
        this.zza = new CountDownLatch(1);
        start();
    }

    private final void zza() {
        AdvertisingIdClient advertisingIdClient = (AdvertisingIdClient) this.zzb.get();
        if (advertisingIdClient != null) {
            advertisingIdClient.zza();
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        try {
            if (this.zza.await(this.zzc, TimeUnit.MILLISECONDS)) {
                return;
            }
            zza();
        } catch (InterruptedException unused) {
            zza();
        }
    }
}
