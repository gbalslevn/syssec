package com.google.android.gms.common.internal;

import android.content.Context;
import android.util.SparseIntArray;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;

/* loaded from: classes.dex */
public final class zal {
    private final SparseIntArray zaa = new SparseIntArray();
    private GoogleApiAvailabilityLight zab;

    public zal(GoogleApiAvailabilityLight googleApiAvailabilityLight) {
        Preconditions.checkNotNull(googleApiAvailabilityLight);
        this.zab = googleApiAvailabilityLight;
    }

    public final int zaa(Context context, int i5) {
        return this.zaa.get(i5, -1);
    }

    @ResultIgnorabilityUnspecified
    public final int zab(Context context, Api.Client client) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(client);
        int i5 = 0;
        if (!client.requiresGooglePlayServices()) {
            return 0;
        }
        int minApkVersion = client.getMinApkVersion();
        int zaa = zaa(context, minApkVersion);
        if (zaa == -1) {
            int i6 = 0;
            while (true) {
                if (i6 >= this.zaa.size()) {
                    i5 = -1;
                    break;
                }
                int keyAt = this.zaa.keyAt(i6);
                if (keyAt > minApkVersion && this.zaa.get(keyAt) == 0) {
                    break;
                }
                i6++;
            }
            zaa = i5 == -1 ? this.zab.isGooglePlayServicesAvailable(context, minApkVersion) : i5;
            this.zaa.put(minApkVersion, zaa);
        }
        return zaa;
    }

    public final void zac() {
        this.zaa.clear();
    }
}
