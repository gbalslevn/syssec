package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes.dex */
public final class zzpl implements Parcelable.Creator<zzpm> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzpm createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int i5 = 0;
        String str = null;
        Long l5 = null;
        Float f5 = null;
        String str2 = null;
        String str3 = null;
        Double d5 = null;
        long j5 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    i5 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 2:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 3:
                    j5 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 4:
                    l5 = SafeParcelReader.readLongObject(parcel, readHeader);
                    break;
                case 5:
                    f5 = SafeParcelReader.readFloatObject(parcel, readHeader);
                    break;
                case 6:
                    str2 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 7:
                    str3 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 8:
                    d5 = SafeParcelReader.readDoubleObject(parcel, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzpm(i5, str, j5, l5, f5, str2, str3, d5);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzpm[] newArray(int i5) {
        return new zzpm[i5];
    }
}
