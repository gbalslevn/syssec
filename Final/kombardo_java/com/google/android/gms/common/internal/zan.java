package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes.dex */
public final class zan implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int i5 = -1;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        String str = null;
        String str2 = null;
        long j5 = 0;
        long j6 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    i6 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 2:
                    i7 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 3:
                    i8 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 4:
                    j5 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 5:
                    j6 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 6:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 7:
                    str2 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 8:
                    i9 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 9:
                    i5 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new MethodInvocation(i6, i7, i8, j5, j6, str, str2, i9, i5);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i5) {
        return new MethodInvocation[i5];
    }
}
