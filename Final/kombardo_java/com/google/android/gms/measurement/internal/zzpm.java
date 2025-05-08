package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* loaded from: classes.dex */
public final class zzpm extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzpm> CREATOR = new zzpl();
    public final String zza;
    public final long zzb;
    public final Long zzc;
    public final String zzd;
    public final String zze;
    public final Double zzf;
    private final int zzg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzpm(zzpo zzpoVar) {
        this(zzpoVar.zzc, zzpoVar.zzd, zzpoVar.zze, zzpoVar.zzb);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzg);
        SafeParcelWriter.writeString(parcel, 2, this.zza, false);
        SafeParcelWriter.writeLong(parcel, 3, this.zzb);
        SafeParcelWriter.writeLongObject(parcel, 4, this.zzc, false);
        SafeParcelWriter.writeFloatObject(parcel, 5, null, false);
        SafeParcelWriter.writeString(parcel, 6, this.zzd, false);
        SafeParcelWriter.writeString(parcel, 7, this.zze, false);
        SafeParcelWriter.writeDoubleObject(parcel, 8, this.zzf, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final Object zza() {
        Long l5 = this.zzc;
        if (l5 != null) {
            return l5;
        }
        Double d5 = this.zzf;
        if (d5 != null) {
            return d5;
        }
        String str = this.zzd;
        if (str != null) {
            return str;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzpm(String str, long j5, Object obj, String str2) {
        Preconditions.checkNotEmpty(str);
        this.zzg = 2;
        this.zza = str;
        this.zzb = j5;
        this.zze = str2;
        if (obj == null) {
            this.zzc = null;
            this.zzf = null;
            this.zzd = null;
            return;
        }
        if (obj instanceof Long) {
            this.zzc = (Long) obj;
            this.zzf = null;
            this.zzd = null;
        } else if (obj instanceof String) {
            this.zzc = null;
            this.zzf = null;
            this.zzd = (String) obj;
        } else {
            if (obj instanceof Double) {
                this.zzc = null;
                this.zzf = (Double) obj;
                this.zzd = null;
                return;
            }
            throw new IllegalArgumentException("User attribute given of un-supported type");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzpm(int i5, String str, long j5, Long l5, Float f5, String str2, String str3, Double d5) {
        this.zzg = i5;
        this.zza = str;
        this.zzb = j5;
        this.zzc = l5;
        if (i5 == 1) {
            this.zzf = f5 != null ? Double.valueOf(f5.doubleValue()) : null;
        } else {
            this.zzf = d5;
        }
        this.zzd = str2;
        this.zze = str3;
    }
}
