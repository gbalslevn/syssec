package com.google.android.gms.internal.measurement;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes.dex */
public final class zzee implements Parcelable.Creator<zzeb> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzeb createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int i5 = 0;
        String str = null;
        Intent intent = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId == 1) {
                i5 = SafeParcelReader.readInt(parcel, readHeader);
            } else if (fieldId == 2) {
                str = SafeParcelReader.createString(parcel, readHeader);
            } else if (fieldId != 3) {
                SafeParcelReader.skipUnknownField(parcel, readHeader);
            } else {
                intent = (Intent) SafeParcelReader.createParcelable(parcel, readHeader, Intent.CREATOR);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzeb(i5, str, intent);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzeb[] newArray(int i5) {
        return new zzeb[i5];
    }
}
