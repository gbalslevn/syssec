package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.adjust.sdk.Constants;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class LocationAvailability extends AbstractSafeParcelable implements ReflectedParcelable {
    final int zzc;
    private final int zzd;
    private final int zze;
    private final long zzf;
    private final zzal[] zzg;
    public static final LocationAvailability zza = new LocationAvailability(0, 1, 1, 0, null, true);
    public static final LocationAvailability zzb = new LocationAvailability(Constants.ONE_SECOND, 1, 1, 0, null, false);
    public static final Parcelable.Creator<LocationAvailability> CREATOR = new zzab();

    /* JADX INFO: Access modifiers changed from: package-private */
    public LocationAvailability(int i5, int i6, int i7, long j5, zzal[] zzalVarArr, boolean z5) {
        this.zzc = i5 < 1000 ? 0 : Constants.ONE_SECOND;
        this.zzd = i6;
        this.zze = i7;
        this.zzf = j5;
        this.zzg = zzalVarArr;
    }

    public boolean equals(Object obj) {
        if (obj instanceof LocationAvailability) {
            LocationAvailability locationAvailability = (LocationAvailability) obj;
            if (this.zzd == locationAvailability.zzd && this.zze == locationAvailability.zze && this.zzf == locationAvailability.zzf && this.zzc == locationAvailability.zzc && Arrays.equals(this.zzg, locationAvailability.zzg)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zzc));
    }

    public boolean isLocationAvailable() {
        return this.zzc < 1000;
    }

    public String toString() {
        boolean isLocationAvailable = isLocationAvailable();
        StringBuilder sb = new StringBuilder(String.valueOf(isLocationAvailable).length() + 22);
        sb.append("LocationAvailability[");
        sb.append(isLocationAvailable);
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i5) {
        int i6 = this.zzd;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, i6);
        SafeParcelWriter.writeInt(parcel, 2, this.zze);
        SafeParcelWriter.writeLong(parcel, 3, this.zzf);
        SafeParcelWriter.writeInt(parcel, 4, this.zzc);
        SafeParcelWriter.writeTypedArray(parcel, 5, this.zzg, i5, false);
        SafeParcelWriter.writeBoolean(parcel, 6, isLocationAvailable());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
