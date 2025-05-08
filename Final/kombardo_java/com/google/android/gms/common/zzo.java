package com.google.android.gms.common;

import android.content.Context;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* loaded from: classes.dex */
public final class zzo extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzo> CREATOR = new zzp();
    private final String zza;
    private final boolean zzb;
    private final boolean zzc;
    private final Context zzd;
    private final boolean zze;
    private final boolean zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzo(String str, boolean z5, boolean z6, IBinder iBinder, boolean z7, boolean z8) {
        this.zza = str;
        this.zzb = z5;
        this.zzc = z6;
        this.zzd = (Context) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder));
        this.zze = z7;
        this.zzf = z8;
    }

    /* JADX WARN: Type inference failed for: r5v5, types: [com.google.android.gms.dynamic.IObjectWrapper, android.os.IBinder] */
    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        String str = this.zza;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, str, false);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzb);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzc);
        SafeParcelWriter.writeIBinder(parcel, 4, ObjectWrapper.wrap(this.zzd), false);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zze);
        SafeParcelWriter.writeBoolean(parcel, 6, this.zzf);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
