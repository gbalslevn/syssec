package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

/* loaded from: classes3.dex */
public abstract class BitEncoding {
    private static final boolean FORCE_8TO7_ENCODING;

    private static /* synthetic */ void $$$reportNull$$$0(int i5) {
        String str = (i5 == 1 || i5 == 3 || i5 == 6 || i5 == 8 || i5 == 10 || i5 == 12 || i5 == 14) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i5 == 1 || i5 == 3 || i5 == 6 || i5 == 8 || i5 == 10 || i5 == 12 || i5 == 14) ? 2 : 3];
        if (i5 == 1 || i5 == 3 || i5 == 6 || i5 == 8 || i5 == 10 || i5 == 12 || i5 == 14) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/BitEncoding";
        } else {
            objArr[0] = "data";
        }
        if (i5 == 1) {
            objArr[1] = "encodeBytes";
        } else if (i5 == 3) {
            objArr[1] = "encode8to7";
        } else if (i5 == 6) {
            objArr[1] = "splitBytesToStringArray";
        } else if (i5 == 8) {
            objArr[1] = "decodeBytes";
        } else if (i5 == 10) {
            objArr[1] = "dropMarker";
        } else if (i5 == 12) {
            objArr[1] = "combineStringArrayIntoBytes";
        } else if (i5 != 14) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/BitEncoding";
        } else {
            objArr[1] = "decode7to8";
        }
        switch (i5) {
            case 1:
            case 3:
            case 6:
            case 8:
            case 10:
            case 12:
            case 14:
                break;
            case 2:
                objArr[2] = "encode8to7";
                break;
            case 4:
                objArr[2] = "addModuloByte";
                break;
            case 5:
                objArr[2] = "splitBytesToStringArray";
                break;
            case 7:
                objArr[2] = "decodeBytes";
                break;
            case 9:
                objArr[2] = "dropMarker";
                break;
            case 11:
                objArr[2] = "combineStringArrayIntoBytes";
                break;
            case 13:
                objArr[2] = "decode7to8";
                break;
            default:
                objArr[2] = "encodeBytes";
                break;
        }
        String format = String.format(str, objArr);
        if (i5 != 1 && i5 != 3 && i5 != 6 && i5 != 8 && i5 != 10 && i5 != 12 && i5 != 14) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    static {
        String str;
        try {
            str = System.getProperty("kotlin.jvm.serialization.use8to7");
        } catch (SecurityException unused) {
            str = null;
        }
        FORCE_8TO7_ENCODING = "true".equals(str);
    }

    private static void addModuloByte(byte[] bArr, int i5) {
        if (bArr == null) {
            $$$reportNull$$$0(4);
        }
        int length = bArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            bArr[i6] = (byte) ((bArr[i6] + i5) & 127);
        }
    }

    private static byte[] combineStringArrayIntoBytes(String[] strArr) {
        if (strArr == null) {
            $$$reportNull$$$0(11);
        }
        int i5 = 0;
        for (String str : strArr) {
            i5 += str.length();
        }
        byte[] bArr = new byte[i5];
        int i6 = 0;
        for (String str2 : strArr) {
            int length = str2.length();
            int i7 = 0;
            while (i7 < length) {
                bArr[i6] = (byte) str2.charAt(i7);
                i7++;
                i6++;
            }
        }
        return bArr;
    }

    private static byte[] decode7to8(byte[] bArr) {
        if (bArr == null) {
            $$$reportNull$$$0(13);
        }
        int length = (bArr.length * 7) / 8;
        byte[] bArr2 = new byte[length];
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < length; i7++) {
            int i8 = i5 + 1;
            int i9 = i6 + 1;
            bArr2[i7] = (byte) (((bArr[i5] & 255) >>> i6) + ((bArr[i8] & ((1 << i9) - 1)) << (7 - i6)));
            if (i6 == 6) {
                i5 += 2;
                i6 = 0;
            } else {
                i5 = i8;
                i6 = i9;
            }
        }
        return bArr2;
    }

    public static byte[] decodeBytes(String[] strArr) {
        if (strArr == null) {
            $$$reportNull$$$0(7);
        }
        if (strArr.length > 0 && !strArr[0].isEmpty()) {
            char charAt = strArr[0].charAt(0);
            if (charAt == 0) {
                byte[] stringsToBytes = UtfEncodingKt.stringsToBytes(dropMarker(strArr));
                if (stringsToBytes == null) {
                    $$$reportNull$$$0(8);
                }
                return stringsToBytes;
            }
            if (charAt == 65535) {
                strArr = dropMarker(strArr);
            }
        }
        byte[] combineStringArrayIntoBytes = combineStringArrayIntoBytes(strArr);
        addModuloByte(combineStringArrayIntoBytes, 127);
        return decode7to8(combineStringArrayIntoBytes);
    }

    private static String[] dropMarker(String[] strArr) {
        if (strArr == null) {
            $$$reportNull$$$0(9);
        }
        String[] strArr2 = (String[]) strArr.clone();
        strArr2[0] = strArr2[0].substring(1);
        return strArr2;
    }
}
