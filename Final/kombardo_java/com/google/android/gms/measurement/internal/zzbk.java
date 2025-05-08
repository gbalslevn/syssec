package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes.dex */
public final class zzbk implements Parcelable.Creator<zzbl> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbl createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        zzbg zzbgVar = null;
        String str2 = null;
        long j5 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId == 2) {
                str = SafeParcelReader.createString(parcel, readHeader);
            } else if (fieldId == 3) {
                zzbgVar = (zzbg) SafeParcelReader.createParcelable(parcel, readHeader, zzbg.CREATOR);
            } else if (fieldId == 4) {
                str2 = SafeParcelReader.createString(parcel, readHeader);
            } else if (fieldId != 5) {
                SafeParcelReader.skipUnknownField(parcel, readHeader);
            } else {
                j5 = SafeParcelReader.readLong(parcel, readHeader);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzbl(str, zzbgVar, str2, j5);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbl[] newArray(int i5) {
        return new zzbl[i5];
    }
}
