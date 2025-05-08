package okio.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u0019\n\u0002\b\u0007\u001a+\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u0017\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\f\u001a\u001f\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0010\u0010\u0011\" \u0010\u0013\u001a\u00020\u00128\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u0012\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lokio/ByteString;", "Lokio/Buffer;", "buffer", BuildConfig.FLAVOR, "offset", "byteCount", BuildConfig.FLAVOR, "commonWrite", "(Lokio/ByteString;Lokio/Buffer;II)V", BuildConfig.FLAVOR, "c", "decodeHexDigit", "(C)I", BuildConfig.FLAVOR, "s", "codePointCount", "codePointIndexToCharIndex", "([BI)I", BuildConfig.FLAVOR, "HEX_DIGIT_CHARS", "[C", "getHEX_DIGIT_CHARS", "()[C", "getHEX_DIGIT_CHARS$annotations", "()V", "okio"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* renamed from: okio.internal.-ByteString */
/* loaded from: classes3.dex */
public abstract class ByteString {
    private static final char[] HEX_DIGIT_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static final int codePointIndexToCharIndex(byte[] bArr, int i5) {
        byte b5;
        int i6;
        int length = bArr.length;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        loop0: while (i7 < length) {
            byte b6 = bArr[i7];
            if (b6 >= 0) {
                int i10 = i9 + 1;
                if (i9 == i5) {
                    return i8;
                }
                if ((b6 != 10 && b6 != 13 && ((b6 >= 0 && b6 < 32) || (Byte.MAX_VALUE <= b6 && b6 < 160))) || b6 == 65533) {
                    return -1;
                }
                i8 += b6 < 65536 ? 1 : 2;
                i7++;
                while (true) {
                    i9 = i10;
                    if (i7 < length && (b5 = bArr[i7]) >= 0) {
                        i7++;
                        i10 = i9 + 1;
                        if (i9 == i5) {
                            return i8;
                        }
                        if ((b5 == 10 || b5 == 13 || ((b5 < 0 || b5 >= 32) && (Byte.MAX_VALUE > b5 || b5 >= 160))) && b5 != 65533) {
                            i8 += b5 < 65536 ? 1 : 2;
                        }
                    }
                }
            } else {
                if ((b6 >> 5) == -2) {
                    int i11 = i7 + 1;
                    if (length <= i11) {
                        if (i9 == i5) {
                            return i8;
                        }
                        return -1;
                    }
                    byte b7 = bArr[i11];
                    if ((b7 & 192) != 128) {
                        if (i9 == i5) {
                            return i8;
                        }
                        return -1;
                    }
                    int i12 = (b7 ^ 3968) ^ (b6 << 6);
                    if (i12 < 128) {
                        if (i9 == i5) {
                            return i8;
                        }
                        return -1;
                    }
                    i6 = i9 + 1;
                    if (i9 == i5) {
                        return i8;
                    }
                    if ((i12 != 10 && i12 != 13 && ((i12 >= 0 && i12 < 32) || (127 <= i12 && i12 < 160))) || i12 == 65533) {
                        return -1;
                    }
                    i8 += i12 < 65536 ? 1 : 2;
                    Unit unit = Unit.INSTANCE;
                    i7 += 2;
                } else if ((b6 >> 4) == -2) {
                    int i13 = i7 + 2;
                    if (length <= i13) {
                        if (i9 == i5) {
                            return i8;
                        }
                        return -1;
                    }
                    byte b8 = bArr[i7 + 1];
                    if ((b8 & 192) != 128) {
                        if (i9 == i5) {
                            return i8;
                        }
                        return -1;
                    }
                    byte b9 = bArr[i13];
                    if ((b9 & 192) != 128) {
                        if (i9 == i5) {
                            return i8;
                        }
                        return -1;
                    }
                    int i14 = ((b8 << 6) ^ ((-123008) ^ b9)) ^ (b6 << 12);
                    if (i14 < 2048) {
                        if (i9 == i5) {
                            return i8;
                        }
                        return -1;
                    }
                    if (55296 <= i14 && i14 < 57344) {
                        if (i9 == i5) {
                            return i8;
                        }
                        return -1;
                    }
                    i6 = i9 + 1;
                    if (i9 == i5) {
                        return i8;
                    }
                    if ((i14 != 10 && i14 != 13 && ((i14 >= 0 && i14 < 32) || (127 <= i14 && i14 < 160))) || i14 == 65533) {
                        return -1;
                    }
                    i8 += i14 < 65536 ? 1 : 2;
                    Unit unit2 = Unit.INSTANCE;
                    i7 += 3;
                } else {
                    if ((b6 >> 3) != -2) {
                        if (i9 == i5) {
                            return i8;
                        }
                        return -1;
                    }
                    int i15 = i7 + 3;
                    if (length <= i15) {
                        if (i9 == i5) {
                            return i8;
                        }
                        return -1;
                    }
                    byte b10 = bArr[i7 + 1];
                    if ((b10 & 192) != 128) {
                        if (i9 == i5) {
                            return i8;
                        }
                        return -1;
                    }
                    byte b11 = bArr[i7 + 2];
                    if ((b11 & 192) != 128) {
                        if (i9 == i5) {
                            return i8;
                        }
                        return -1;
                    }
                    byte b12 = bArr[i15];
                    if ((b12 & 192) != 128) {
                        if (i9 == i5) {
                            return i8;
                        }
                        return -1;
                    }
                    int i16 = (((b12 ^ 3678080) ^ (b11 << 6)) ^ (b10 << 12)) ^ (b6 << 18);
                    if (i16 > 1114111) {
                        if (i9 == i5) {
                            return i8;
                        }
                        return -1;
                    }
                    if (55296 <= i16 && i16 < 57344) {
                        if (i9 == i5) {
                            return i8;
                        }
                        return -1;
                    }
                    if (i16 < 65536) {
                        if (i9 == i5) {
                            return i8;
                        }
                        return -1;
                    }
                    i6 = i9 + 1;
                    if (i9 == i5) {
                        return i8;
                    }
                    if ((i16 != 10 && i16 != 13 && ((i16 >= 0 && i16 < 32) || (127 <= i16 && i16 < 160))) || i16 == 65533) {
                        return -1;
                    }
                    i8 += i16 < 65536 ? 1 : 2;
                    Unit unit3 = Unit.INSTANCE;
                    i7 += 4;
                }
                i9 = i6;
            }
        }
        return i8;
    }

    public static final void commonWrite(okio.ByteString byteString, Buffer buffer, int i5, int i6) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        buffer.write(byteString.getData(), i5, i6);
    }

    public static final int decodeHexDigit(char c5) {
        if ('0' <= c5 && c5 < ':') {
            return c5 - '0';
        }
        if ('a' <= c5 && c5 < 'g') {
            return c5 - 'W';
        }
        if ('A' <= c5 && c5 < 'G') {
            return c5 - '7';
        }
        throw new IllegalArgumentException("Unexpected hex digit: " + c5);
    }

    public static final char[] getHEX_DIGIT_CHARS() {
        return HEX_DIGIT_CHARS;
    }
}
