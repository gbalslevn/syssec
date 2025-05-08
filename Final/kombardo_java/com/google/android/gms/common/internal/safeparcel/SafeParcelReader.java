package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class SafeParcelReader {

    /* loaded from: classes.dex */
    public static class ParseException extends RuntimeException {
        public ParseException(String str, Parcel parcel) {
            super(str + " Parcel: pos=" + parcel.dataPosition() + " size=" + parcel.dataSize());
        }
    }

    public static Bundle createBundle(Parcel parcel, int i5) {
        int readSize = readSize(parcel, i5);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        Bundle readBundle = parcel.readBundle();
        parcel.setDataPosition(dataPosition + readSize);
        return readBundle;
    }

    public static byte[] createByteArray(Parcel parcel, int i5) {
        int readSize = readSize(parcel, i5);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(dataPosition + readSize);
        return createByteArray;
    }

    public static int[] createIntArray(Parcel parcel, int i5) {
        int readSize = readSize(parcel, i5);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        int[] createIntArray = parcel.createIntArray();
        parcel.setDataPosition(dataPosition + readSize);
        return createIntArray;
    }

    public static ArrayList<Integer> createIntegerList(Parcel parcel, int i5) {
        int readSize = readSize(parcel, i5);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        int readInt = parcel.readInt();
        for (int i6 = 0; i6 < readInt; i6++) {
            arrayList.add(Integer.valueOf(parcel.readInt()));
        }
        parcel.setDataPosition(dataPosition + readSize);
        return arrayList;
    }

    public static <T extends Parcelable> T createParcelable(Parcel parcel, int i5, Parcelable.Creator<T> creator) {
        int readSize = readSize(parcel, i5);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        T createFromParcel = creator.createFromParcel(parcel);
        parcel.setDataPosition(dataPosition + readSize);
        return createFromParcel;
    }

    public static String createString(Parcel parcel, int i5) {
        int readSize = readSize(parcel, i5);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        String readString = parcel.readString();
        parcel.setDataPosition(dataPosition + readSize);
        return readString;
    }

    public static ArrayList<String> createStringList(Parcel parcel, int i5) {
        int readSize = readSize(parcel, i5);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        ArrayList<String> createStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(dataPosition + readSize);
        return createStringArrayList;
    }

    public static <T> T[] createTypedArray(Parcel parcel, int i5, Parcelable.Creator<T> creator) {
        int readSize = readSize(parcel, i5);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        T[] tArr = (T[]) parcel.createTypedArray(creator);
        parcel.setDataPosition(dataPosition + readSize);
        return tArr;
    }

    public static <T> ArrayList<T> createTypedList(Parcel parcel, int i5, Parcelable.Creator<T> creator) {
        int readSize = readSize(parcel, i5);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        ArrayList<T> createTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(dataPosition + readSize);
        return createTypedArrayList;
    }

    public static void ensureAtEnd(Parcel parcel, int i5) {
        if (parcel.dataPosition() == i5) {
            return;
        }
        throw new ParseException("Overread allowed size end=" + i5, parcel);
    }

    public static int getFieldId(int i5) {
        return (char) i5;
    }

    public static boolean readBoolean(Parcel parcel, int i5) {
        zzb(parcel, i5, 4);
        return parcel.readInt() != 0;
    }

    public static Boolean readBooleanObject(Parcel parcel, int i5) {
        int readSize = readSize(parcel, i5);
        if (readSize == 0) {
            return null;
        }
        zza(parcel, i5, readSize, 4);
        return Boolean.valueOf(parcel.readInt() != 0);
    }

    public static Double readDoubleObject(Parcel parcel, int i5) {
        int readSize = readSize(parcel, i5);
        if (readSize == 0) {
            return null;
        }
        zza(parcel, i5, readSize, 8);
        return Double.valueOf(parcel.readDouble());
    }

    public static float readFloat(Parcel parcel, int i5) {
        zzb(parcel, i5, 4);
        return parcel.readFloat();
    }

    public static Float readFloatObject(Parcel parcel, int i5) {
        int readSize = readSize(parcel, i5);
        if (readSize == 0) {
            return null;
        }
        zza(parcel, i5, readSize, 4);
        return Float.valueOf(parcel.readFloat());
    }

    public static int readHeader(Parcel parcel) {
        return parcel.readInt();
    }

    public static IBinder readIBinder(Parcel parcel, int i5) {
        int readSize = readSize(parcel, i5);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        IBinder readStrongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(dataPosition + readSize);
        return readStrongBinder;
    }

    public static int readInt(Parcel parcel, int i5) {
        zzb(parcel, i5, 4);
        return parcel.readInt();
    }

    public static long readLong(Parcel parcel, int i5) {
        zzb(parcel, i5, 8);
        return parcel.readLong();
    }

    public static Long readLongObject(Parcel parcel, int i5) {
        int readSize = readSize(parcel, i5);
        if (readSize == 0) {
            return null;
        }
        zza(parcel, i5, readSize, 8);
        return Long.valueOf(parcel.readLong());
    }

    public static int readSize(Parcel parcel, int i5) {
        return (i5 & (-65536)) != -65536 ? (char) (i5 >> 16) : parcel.readInt();
    }

    public static void skipUnknownField(Parcel parcel, int i5) {
        parcel.setDataPosition(parcel.dataPosition() + readSize(parcel, i5));
    }

    public static int validateObjectHeader(Parcel parcel) {
        int readHeader = readHeader(parcel);
        int readSize = readSize(parcel, readHeader);
        int fieldId = getFieldId(readHeader);
        int dataPosition = parcel.dataPosition();
        if (fieldId != 20293) {
            throw new ParseException("Expected object header. Got 0x".concat(String.valueOf(Integer.toHexString(readHeader))), parcel);
        }
        int i5 = readSize + dataPosition;
        if (i5 >= dataPosition && i5 <= parcel.dataSize()) {
            return i5;
        }
        throw new ParseException("Size read is invalid start=" + dataPosition + " end=" + i5, parcel);
    }

    private static void zza(Parcel parcel, int i5, int i6, int i7) {
        if (i6 == i7) {
            return;
        }
        throw new ParseException("Expected size " + i7 + " got " + i6 + " (0x" + Integer.toHexString(i6) + ")", parcel);
    }

    private static void zzb(Parcel parcel, int i5, int i6) {
        int readSize = readSize(parcel, i5);
        if (readSize == i6) {
            return;
        }
        throw new ParseException("Expected size " + i6 + " got " + readSize + " (0x" + Integer.toHexString(readSize) + ")", parcel);
    }
}
