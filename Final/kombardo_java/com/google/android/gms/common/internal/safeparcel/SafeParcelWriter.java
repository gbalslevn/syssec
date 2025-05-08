package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* loaded from: classes.dex */
public abstract class SafeParcelWriter {
    public static int beginObjectHeader(Parcel parcel) {
        return zza(parcel, 20293);
    }

    public static void finishObjectHeader(Parcel parcel, int i5) {
        zzb(parcel, i5);
    }

    public static void writeBoolean(Parcel parcel, int i5, boolean z5) {
        zzc(parcel, i5, 4);
        parcel.writeInt(z5 ? 1 : 0);
    }

    public static void writeBooleanObject(Parcel parcel, int i5, Boolean bool, boolean z5) {
        if (bool != null) {
            zzc(parcel, i5, 4);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        } else if (z5) {
            zzc(parcel, i5, 0);
        }
    }

    public static void writeBundle(Parcel parcel, int i5, Bundle bundle, boolean z5) {
        if (bundle == null) {
            if (z5) {
                zzc(parcel, i5, 0);
            }
        } else {
            int zza = zza(parcel, i5);
            parcel.writeBundle(bundle);
            zzb(parcel, zza);
        }
    }

    public static void writeByteArray(Parcel parcel, int i5, byte[] bArr, boolean z5) {
        if (bArr == null) {
            if (z5) {
                zzc(parcel, i5, 0);
            }
        } else {
            int zza = zza(parcel, i5);
            parcel.writeByteArray(bArr);
            zzb(parcel, zza);
        }
    }

    public static void writeDoubleObject(Parcel parcel, int i5, Double d5, boolean z5) {
        if (d5 != null) {
            zzc(parcel, i5, 8);
            parcel.writeDouble(d5.doubleValue());
        } else if (z5) {
            zzc(parcel, i5, 0);
        }
    }

    public static void writeFloat(Parcel parcel, int i5, float f5) {
        zzc(parcel, i5, 4);
        parcel.writeFloat(f5);
    }

    public static void writeFloatObject(Parcel parcel, int i5, Float f5, boolean z5) {
        if (f5 != null) {
            zzc(parcel, i5, 4);
            parcel.writeFloat(f5.floatValue());
        } else if (z5) {
            zzc(parcel, i5, 0);
        }
    }

    public static void writeIBinder(Parcel parcel, int i5, IBinder iBinder, boolean z5) {
        if (iBinder == null) {
            if (z5) {
                zzc(parcel, i5, 0);
            }
        } else {
            int zza = zza(parcel, i5);
            parcel.writeStrongBinder(iBinder);
            zzb(parcel, zza);
        }
    }

    public static void writeInt(Parcel parcel, int i5, int i6) {
        zzc(parcel, i5, 4);
        parcel.writeInt(i6);
    }

    public static void writeIntArray(Parcel parcel, int i5, int[] iArr, boolean z5) {
        if (iArr == null) {
            if (z5) {
                zzc(parcel, i5, 0);
            }
        } else {
            int zza = zza(parcel, i5);
            parcel.writeIntArray(iArr);
            zzb(parcel, zza);
        }
    }

    public static void writeIntegerList(Parcel parcel, int i5, List<Integer> list, boolean z5) {
        if (list == null) {
            if (z5) {
                zzc(parcel, i5, 0);
                return;
            }
            return;
        }
        int zza = zza(parcel, i5);
        int size = list.size();
        parcel.writeInt(size);
        for (int i6 = 0; i6 < size; i6++) {
            parcel.writeInt(list.get(i6).intValue());
        }
        zzb(parcel, zza);
    }

    public static void writeLong(Parcel parcel, int i5, long j5) {
        zzc(parcel, i5, 8);
        parcel.writeLong(j5);
    }

    public static void writeLongObject(Parcel parcel, int i5, Long l5, boolean z5) {
        if (l5 != null) {
            zzc(parcel, i5, 8);
            parcel.writeLong(l5.longValue());
        } else if (z5) {
            zzc(parcel, i5, 0);
        }
    }

    public static void writeParcelable(Parcel parcel, int i5, Parcelable parcelable, int i6, boolean z5) {
        if (parcelable == null) {
            if (z5) {
                zzc(parcel, i5, 0);
            }
        } else {
            int zza = zza(parcel, i5);
            parcelable.writeToParcel(parcel, i6);
            zzb(parcel, zza);
        }
    }

    public static void writeString(Parcel parcel, int i5, String str, boolean z5) {
        if (str == null) {
            if (z5) {
                zzc(parcel, i5, 0);
            }
        } else {
            int zza = zza(parcel, i5);
            parcel.writeString(str);
            zzb(parcel, zza);
        }
    }

    public static void writeStringList(Parcel parcel, int i5, List<String> list, boolean z5) {
        if (list == null) {
            if (z5) {
                zzc(parcel, i5, 0);
            }
        } else {
            int zza = zza(parcel, i5);
            parcel.writeStringList(list);
            zzb(parcel, zza);
        }
    }

    public static <T extends Parcelable> void writeTypedArray(Parcel parcel, int i5, T[] tArr, int i6, boolean z5) {
        if (tArr == null) {
            if (z5) {
                zzc(parcel, i5, 0);
                return;
            }
            return;
        }
        int zza = zza(parcel, i5);
        parcel.writeInt(tArr.length);
        for (T t5 : tArr) {
            if (t5 == null) {
                parcel.writeInt(0);
            } else {
                zzd(parcel, t5, i6);
            }
        }
        zzb(parcel, zza);
    }

    public static <T extends Parcelable> void writeTypedList(Parcel parcel, int i5, List<T> list, boolean z5) {
        if (list == null) {
            if (z5) {
                zzc(parcel, i5, 0);
                return;
            }
            return;
        }
        int zza = zza(parcel, i5);
        int size = list.size();
        parcel.writeInt(size);
        for (int i6 = 0; i6 < size; i6++) {
            T t5 = list.get(i6);
            if (t5 == null) {
                parcel.writeInt(0);
            } else {
                zzd(parcel, t5, 0);
            }
        }
        zzb(parcel, zza);
    }

    private static int zza(Parcel parcel, int i5) {
        parcel.writeInt(i5 | (-65536));
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    private static void zzb(Parcel parcel, int i5) {
        int dataPosition = parcel.dataPosition();
        parcel.setDataPosition(i5 - 4);
        parcel.writeInt(dataPosition - i5);
        parcel.setDataPosition(dataPosition);
    }

    private static void zzc(Parcel parcel, int i5, int i6) {
        parcel.writeInt(i5 | (i6 << 16));
    }

    private static void zzd(Parcel parcel, Parcelable parcelable, int i5) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int dataPosition2 = parcel.dataPosition();
        parcelable.writeToParcel(parcel, i5);
        int dataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition3 - dataPosition2);
        parcel.setDataPosition(dataPosition3);
    }
}
