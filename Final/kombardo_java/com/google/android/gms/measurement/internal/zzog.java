package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* loaded from: classes.dex */
public final class zzog extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzog> CREATOR = new zzoj();
    public final String zza;
    public final long zzb;
    public final int zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzog(String str, long j5, int i5) {
        this.zza = str;
        this.zzb = j5;
        this.zzc = i5;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeLong(parcel, 2, this.zzb);
        SafeParcelWriter.writeInt(parcel, 3, this.zzc);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
