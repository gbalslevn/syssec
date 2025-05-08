package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes.dex */
public final class zzaj implements Parcelable.Creator<zzag> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzag createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        String str2 = null;
        zzpm zzpmVar = null;
        String str3 = null;
        zzbl zzblVar = null;
        zzbl zzblVar2 = null;
        zzbl zzblVar3 = null;
        long j5 = 0;
        long j6 = 0;
        long j7 = 0;
        boolean z5 = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 2:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 3:
                    str2 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 4:
                    zzpmVar = (zzpm) SafeParcelReader.createParcelable(parcel, readHeader, zzpm.CREATOR);
                    break;
                case 5:
                    j5 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 6:
                    z5 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 7:
                    str3 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 8:
                    zzblVar = (zzbl) SafeParcelReader.createParcelable(parcel, readHeader, zzbl.CREATOR);
                    break;
                case 9:
                    j6 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 10:
                    zzblVar2 = (zzbl) SafeParcelReader.createParcelable(parcel, readHeader, zzbl.CREATOR);
                    break;
                case 11:
                    j7 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 12:
                    zzblVar3 = (zzbl) SafeParcelReader.createParcelable(parcel, readHeader, zzbl.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzag(str, str2, zzpmVar, j5, z5, str3, zzblVar, j6, zzblVar2, j7, zzblVar3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzag[] newArray(int i5) {
        return new zzag[i5];
    }
}
