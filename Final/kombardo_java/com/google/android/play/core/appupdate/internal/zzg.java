package com.google.android.play.core.appupdate.internal;

import android.os.Bundle;
import android.os.Parcel;

/* loaded from: classes.dex */
public abstract class zzg extends zzb implements zzh {
    public zzg() {
        super("com.google.android.play.core.appupdate.protocol.IAppUpdateServiceCallback");
    }

    @Override // com.google.android.play.core.appupdate.internal.zzb
    protected final boolean zza(int i5, Parcel parcel, Parcel parcel2, int i6) {
        if (i5 == 2) {
            Bundle bundle = (Bundle) zzc.zza(parcel, Bundle.CREATOR);
            zzc.zzb(parcel);
            zzc(bundle);
            return true;
        }
        if (i5 != 3) {
            return false;
        }
        Bundle bundle2 = (Bundle) zzc.zza(parcel, Bundle.CREATOR);
        zzc.zzb(parcel);
        zzb(bundle2);
        return true;
    }
}
