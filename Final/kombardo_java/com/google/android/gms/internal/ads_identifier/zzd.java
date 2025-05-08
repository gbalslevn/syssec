package com.google.android.gms.internal.ads_identifier;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class zzd extends zza implements zzf {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzd(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
    }

    @Override // com.google.android.gms.internal.ads_identifier.zzf
    public final String zzc() {
        Parcel zzb = zzb(1, zza());
        String readString = zzb.readString();
        zzb.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads_identifier.zzf
    public final boolean zze(boolean z5) {
        Parcel zza = zza();
        int i5 = zzc.f4346a;
        zza.writeInt(1);
        Parcel zzb = zzb(2, zza);
        boolean zza2 = zzc.zza(zzb);
        zzb.recycle();
        return zza2;
    }
}
