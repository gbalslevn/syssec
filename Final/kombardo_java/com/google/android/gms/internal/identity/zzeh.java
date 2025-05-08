package com.google.android.gms.internal.identity;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.location.LocationRequest;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class zzeh implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        long j5 = Long.MAX_VALUE;
        LocationRequest locationRequest = null;
        ArrayList arrayList = null;
        String str = null;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        boolean z8 = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId == 1) {
                locationRequest = (LocationRequest) SafeParcelReader.createParcelable(parcel, readHeader, LocationRequest.CREATOR);
            } else if (fieldId == 5) {
                arrayList = SafeParcelReader.createTypedList(parcel, readHeader, ClientIdentity.CREATOR);
            } else if (fieldId == 8) {
                z5 = SafeParcelReader.readBoolean(parcel, readHeader);
            } else if (fieldId != 9) {
                switch (fieldId) {
                    case 11:
                        z7 = SafeParcelReader.readBoolean(parcel, readHeader);
                        break;
                    case 12:
                        z8 = SafeParcelReader.readBoolean(parcel, readHeader);
                        break;
                    case 13:
                        str = SafeParcelReader.createString(parcel, readHeader);
                        break;
                    case 14:
                        j5 = SafeParcelReader.readLong(parcel, readHeader);
                        break;
                    default:
                        SafeParcelReader.skipUnknownField(parcel, readHeader);
                        break;
                }
            } else {
                z6 = SafeParcelReader.readBoolean(parcel, readHeader);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzeg(locationRequest, arrayList, z5, z6, z7, z8, str, j5);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i5) {
        return new zzeg[i5];
    }
}
