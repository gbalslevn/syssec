package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;

/* loaded from: classes.dex */
public interface IGmsCallbacks extends IInterface {
    void onPostInitComplete(int i5, IBinder iBinder, Bundle bundle);

    void zzb(int i5, Bundle bundle);

    void zzc(int i5, IBinder iBinder, zzk zzkVar);
}
