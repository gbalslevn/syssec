package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.R$styleable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;
import org.conscrypt.BuildConfig;

/* loaded from: classes.dex */
public final class zzr implements Parcelable.Creator<zzp> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzp createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        Boolean bool = null;
        ArrayList<String> arrayList = null;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        long j5 = 0;
        long j6 = 0;
        long j7 = 0;
        long j8 = 0;
        long j9 = 0;
        long j10 = 0;
        long j11 = 0;
        boolean z5 = true;
        boolean z6 = true;
        boolean z7 = false;
        int i5 = 0;
        boolean z8 = false;
        boolean z9 = false;
        int i6 = 0;
        int i7 = 0;
        long j12 = -2147483648L;
        String str11 = BuildConfig.FLAVOR;
        String str12 = str11;
        String str13 = str12;
        String str14 = str13;
        int i8 = 100;
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
                    str3 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 5:
                    str4 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 6:
                    j5 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 7:
                    j6 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 8:
                    str5 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 9:
                    z5 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 10:
                    z7 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 11:
                    j12 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 12:
                    str6 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 13:
                case 17:
                case 20:
                case 33:
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
                case 14:
                    j7 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 15:
                    i5 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 16:
                    z6 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 18:
                    z8 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 19:
                    str7 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 21:
                    bool = SafeParcelReader.readBooleanObject(parcel, readHeader);
                    break;
                case 22:
                    j8 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case R$styleable.Toolbar_titleMarginBottom /* 23 */:
                    arrayList = SafeParcelReader.createStringList(parcel, readHeader);
                    break;
                case R$styleable.Toolbar_titleMarginEnd /* 24 */:
                    str8 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 25:
                    str11 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 26:
                    str12 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 27:
                    str9 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 28:
                    z9 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case R$styleable.Toolbar_titleTextColor /* 29 */:
                    j9 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 30:
                    i8 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 31:
                    str13 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 32:
                    i6 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 34:
                    j10 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 35:
                    str10 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 36:
                    str14 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 37:
                    j11 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 38:
                    i7 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzp(str, str2, str3, str4, j5, j6, str5, z5, z7, j12, str6, j7, i5, z6, z8, str7, bool, j8, arrayList, str8, str11, str12, str9, z9, j9, i8, str13, i6, j10, str10, str14, j11, i7);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzp[] newArray(int i5) {
        return new zzp[i5];
    }
}
