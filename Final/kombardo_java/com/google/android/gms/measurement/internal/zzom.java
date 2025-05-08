package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes.dex */
public final class zzom implements Parcelable.Creator<zzon> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzon createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        long j5 = 0;
        long j6 = 0;
        byte[] bArr = null;
        String str = null;
        Bundle bundle = null;
        String str2 = null;
        int i5 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    j5 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 2:
                    bArr = SafeParcelReader.createByteArray(parcel, readHeader);
                    break;
                case 3:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 4:
                    bundle = SafeParcelReader.createBundle(parcel, readHeader);
                    break;
                case 5:
                    i5 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 6:
                    j6 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 7:
                    str2 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzon(j5, bArr, str, bundle, i5, j6, str2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzon[] newArray(int i5) {
        return new zzon[i5];
    }
}
