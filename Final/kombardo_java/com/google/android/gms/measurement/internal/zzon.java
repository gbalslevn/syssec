package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import org.conscrypt.BuildConfig;

/* loaded from: classes.dex */
public final class zzon extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzon> CREATOR = new zzom();
    public final long zza;
    public byte[] zzb;
    public final String zzc;
    public final Bundle zzd;
    public final long zze;
    public String zzf;
    private final int zzg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzon(long j5, byte[] bArr, String str, Bundle bundle, int i5, long j6) {
        this(j5, bArr, str, bundle, i5, j6, BuildConfig.FLAVOR);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, this.zza);
        SafeParcelWriter.writeByteArray(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeBundle(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeInt(parcel, 5, this.zzg);
        SafeParcelWriter.writeLong(parcel, 6, this.zze);
        SafeParcelWriter.writeString(parcel, 7, this.zzf, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzon(long j5, byte[] bArr, String str, Bundle bundle, int i5, long j6, String str2) {
        this.zza = j5;
        this.zzb = bArr;
        this.zzc = str;
        this.zzd = bundle;
        this.zzg = i5;
        this.zze = j6;
        this.zzf = str2;
    }
}
