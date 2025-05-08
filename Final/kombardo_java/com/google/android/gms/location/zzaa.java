package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.identity.ClientIdentity;

/* loaded from: classes.dex */
public final class zzaa implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        ClientIdentity clientIdentity = null;
        int i5 = 0;
        boolean z5 = false;
        long j5 = Long.MAX_VALUE;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId == 1) {
                j5 = SafeParcelReader.readLong(parcel, readHeader);
            } else if (fieldId == 2) {
                i5 = SafeParcelReader.readInt(parcel, readHeader);
            } else if (fieldId == 3) {
                z5 = SafeParcelReader.readBoolean(parcel, readHeader);
            } else if (fieldId != 5) {
                SafeParcelReader.skipUnknownField(parcel, readHeader);
            } else {
                clientIdentity = (ClientIdentity) SafeParcelReader.createParcelable(parcel, readHeader, ClientIdentity.CREATOR);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new LastLocationRequest(j5, i5, z5, clientIdentity);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i5) {
        return new LastLocationRequest[i5];
    }
}
