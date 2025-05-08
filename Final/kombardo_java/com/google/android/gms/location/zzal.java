package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

@Deprecated
/* loaded from: classes.dex */
public final class zzal extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzal> CREATOR = new zzam();
    public final int zza;
    public final int zzb;
    public final long zzc;
    public final long zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzal(int i5, int i6, long j5, long j6) {
        this.zza = i5;
        this.zzb = i6;
        this.zzc = j5;
        this.zzd = j6;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzal) {
            zzal zzalVar = (zzal) obj;
            if (this.zza == zzalVar.zza && this.zzb == zzalVar.zzb && this.zzc == zzalVar.zzc && this.zzd == zzalVar.zzd) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zzb), Integer.valueOf(this.zza), Long.valueOf(this.zzd), Long.valueOf(this.zzc));
    }

    public final String toString() {
        int i5 = this.zza;
        int length = String.valueOf(i5).length();
        int i6 = this.zzb;
        int length2 = String.valueOf(i6).length();
        long j5 = this.zzd;
        int length3 = String.valueOf(j5).length();
        long j6 = this.zzc;
        StringBuilder sb = new StringBuilder(length + 50 + length2 + 18 + length3 + 17 + String.valueOf(j6).length());
        sb.append("NetworkLocationStatus: Wifi status: ");
        sb.append(i5);
        sb.append(" Cell status: ");
        sb.append(i6);
        sb.append(" elapsed time NS: ");
        sb.append(j5);
        sb.append(" system time ms: ");
        sb.append(j6);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        int i6 = this.zza;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, i6);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.writeLong(parcel, 3, this.zzc);
        SafeParcelWriter.writeLong(parcel, 4, this.zzd);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
