package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.WorkSource;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.identity.ClientIdentity;

/* loaded from: classes.dex */
public final class zzaf implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        WorkSource workSource = new WorkSource();
        ClientIdentity clientIdentity = null;
        boolean z5 = false;
        int i5 = 0;
        int i6 = 0;
        boolean z6 = false;
        long j5 = -1;
        float f5 = 0.0f;
        int i7 = Integer.MAX_VALUE;
        long j6 = Long.MAX_VALUE;
        long j7 = Long.MAX_VALUE;
        long j8 = 0;
        long j9 = 600000;
        long j10 = 3600000;
        int i8 = 102;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    i8 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 2:
                    j10 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 3:
                    j9 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 4:
                case 14:
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
                case 5:
                    j6 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 6:
                    i7 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 7:
                    f5 = SafeParcelReader.readFloat(parcel, readHeader);
                    break;
                case 8:
                    j8 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 9:
                    z5 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 10:
                    j7 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 11:
                    j5 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 12:
                    i5 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 13:
                    i6 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 15:
                    z6 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 16:
                    workSource = (WorkSource) SafeParcelReader.createParcelable(parcel, readHeader, WorkSource.CREATOR);
                    break;
                case 17:
                    clientIdentity = (ClientIdentity) SafeParcelReader.createParcelable(parcel, readHeader, ClientIdentity.CREATOR);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new LocationRequest(i8, j10, j9, j8, j6, j7, i7, f5, z5, j5, i5, i6, z6, workSource, clientIdentity);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i5) {
        return new LocationRequest[i5];
    }
}
