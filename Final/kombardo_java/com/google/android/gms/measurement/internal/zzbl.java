package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* loaded from: classes.dex */
public final class zzbl extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbl> CREATOR = new zzbk();
    public final String zza;
    public final zzbg zzb;
    public final String zzc;
    public final long zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbl(zzbl zzblVar, long j5) {
        Preconditions.checkNotNull(zzblVar);
        this.zza = zzblVar.zza;
        this.zzb = zzblVar.zzb;
        this.zzc = zzblVar.zzc;
        this.zzd = j5;
    }

    public final String toString() {
        return "origin=" + this.zzc + ",name=" + this.zza + ",params=" + String.valueOf(this.zzb);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zza, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzb, i5, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzc, false);
        SafeParcelWriter.writeLong(parcel, 5, this.zzd);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public zzbl(String str, zzbg zzbgVar, String str2, long j5) {
        this.zza = str;
        this.zzb = zzbgVar;
        this.zzc = str2;
        this.zzd = j5;
    }
}
