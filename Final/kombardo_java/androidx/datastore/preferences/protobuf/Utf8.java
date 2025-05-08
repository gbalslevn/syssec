package androidx.datastore.preferences.protobuf;

import java.nio.charset.Charset;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class Utf8 {
    private static final long ASCII_MASK_LONG = -9187201950435737472L;
    private static final int UNSAFE_COUNT_ASCII_THRESHOLD = 16;
    private static final Processor processor;

    /* loaded from: classes.dex */
    private static class DecodeUtil {
        /* JADX INFO: Access modifiers changed from: private */
        public static void handleFourBytes(byte b5, byte b6, byte b7, byte b8, char[] cArr, int i5) {
            if (isNotTrailingByte(b6) || (((b5 << 28) + (b6 + 112)) >> 30) != 0 || isNotTrailingByte(b7) || isNotTrailingByte(b8)) {
                throw InvalidProtocolBufferException.invalidUtf8();
            }
            int trailingByteValue = ((b5 & 7) << 18) | (trailingByteValue(b6) << 12) | (trailingByteValue(b7) << 6) | trailingByteValue(b8);
            cArr[i5] = highSurrogate(trailingByteValue);
            cArr[i5 + 1] = lowSurrogate(trailingByteValue);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void handleOneByte(byte b5, char[] cArr, int i5) {
            cArr[i5] = (char) b5;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void handleThreeBytes(byte b5, byte b6, byte b7, char[] cArr, int i5) {
            if (isNotTrailingByte(b6) || ((b5 == -32 && b6 < -96) || ((b5 == -19 && b6 >= -96) || isNotTrailingByte(b7)))) {
                throw InvalidProtocolBufferException.invalidUtf8();
            }
            cArr[i5] = (char) (((b5 & 15) << 12) | (trailingByteValue(b6) << 6) | trailingByteValue(b7));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void handleTwoBytes(byte b5, byte b6, char[] cArr, int i5) {
            if (b5 < -62 || isNotTrailingByte(b6)) {
                throw InvalidProtocolBufferException.invalidUtf8();
            }
            cArr[i5] = (char) (((b5 & 31) << 6) | trailingByteValue(b6));
        }

        private static char highSurrogate(int i5) {
            return (char) ((i5 >>> 10) + 55232);
        }

        private static boolean isNotTrailingByte(byte b5) {
            return b5 > -65;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean isOneByte(byte b5) {
            return b5 >= 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean isThreeBytes(byte b5) {
            return b5 < -16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean isTwoBytes(byte b5) {
            return b5 < -32;
        }

        private static char lowSurrogate(int i5) {
            return (char) ((i5 & 1023) + 56320);
        }

        private static int trailingByteValue(byte b5) {
            return b5 & 63;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class Processor {
        Processor() {
        }

        abstract String decodeUtf8(byte[] bArr, int i5, int i6);

        abstract int encodeUtf8(String str, byte[] bArr, int i5, int i6);
    }

    /* loaded from: classes.dex */
    static final class SafeProcessor extends Processor {
        SafeProcessor() {
        }

        @Override // androidx.datastore.preferences.protobuf.Utf8.Processor
        String decodeUtf8(byte[] bArr, int i5, int i6) {
            if ((i5 | i6 | ((bArr.length - i5) - i6)) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i5), Integer.valueOf(i6)));
            }
            int i7 = i5 + i6;
            char[] cArr = new char[i6];
            int i8 = 0;
            while (i5 < i7) {
                byte b5 = bArr[i5];
                if (!DecodeUtil.isOneByte(b5)) {
                    break;
                }
                i5++;
                DecodeUtil.handleOneByte(b5, cArr, i8);
                i8++;
            }
            int i9 = i8;
            while (i5 < i7) {
                int i10 = i5 + 1;
                byte b6 = bArr[i5];
                if (DecodeUtil.isOneByte(b6)) {
                    int i11 = i9 + 1;
                    DecodeUtil.handleOneByte(b6, cArr, i9);
                    while (i10 < i7) {
                        byte b7 = bArr[i10];
                        if (!DecodeUtil.isOneByte(b7)) {
                            break;
                        }
                        i10++;
                        DecodeUtil.handleOneByte(b7, cArr, i11);
                        i11++;
                    }
                    i9 = i11;
                    i5 = i10;
                } else if (DecodeUtil.isTwoBytes(b6)) {
                    if (i10 >= i7) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    i5 += 2;
                    DecodeUtil.handleTwoBytes(b6, bArr[i10], cArr, i9);
                    i9++;
                } else if (DecodeUtil.isThreeBytes(b6)) {
                    if (i10 >= i7 - 1) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    int i12 = i5 + 2;
                    i5 += 3;
                    DecodeUtil.handleThreeBytes(b6, bArr[i10], bArr[i12], cArr, i9);
                    i9++;
                } else {
                    if (i10 >= i7 - 2) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    byte b8 = bArr[i10];
                    int i13 = i5 + 3;
                    byte b9 = bArr[i5 + 2];
                    i5 += 4;
                    DecodeUtil.handleFourBytes(b6, b8, b9, bArr[i13], cArr, i9);
                    i9 += 2;
                }
            }
            return new String(cArr, 0, i9);
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
        
            return r10 + r0;
         */
        @Override // androidx.datastore.preferences.protobuf.Utf8.Processor
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        int encodeUtf8(String str, byte[] bArr, int i5, int i6) {
            int i7;
            int i8;
            char charAt;
            int length = str.length();
            int i9 = i6 + i5;
            int i10 = 0;
            while (i10 < length && (i8 = i10 + i5) < i9 && (charAt = str.charAt(i10)) < 128) {
                bArr[i8] = (byte) charAt;
                i10++;
            }
            int i11 = i5 + i10;
            while (i10 < length) {
                char charAt2 = str.charAt(i10);
                if (charAt2 < 128 && i11 < i9) {
                    bArr[i11] = (byte) charAt2;
                    i11++;
                } else if (charAt2 < 2048 && i11 <= i9 - 2) {
                    int i12 = i11 + 1;
                    bArr[i11] = (byte) ((charAt2 >>> 6) | 960);
                    i11 += 2;
                    bArr[i12] = (byte) ((charAt2 & '?') | 128);
                } else {
                    if ((charAt2 >= 55296 && 57343 >= charAt2) || i11 > i9 - 3) {
                        if (i11 > i9 - 4) {
                            if (55296 <= charAt2 && charAt2 <= 57343 && ((i7 = i10 + 1) == str.length() || !Character.isSurrogatePair(charAt2, str.charAt(i7)))) {
                                throw new UnpairedSurrogateException(i10, length);
                            }
                            throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + i11);
                        }
                        int i13 = i10 + 1;
                        if (i13 != str.length()) {
                            char charAt3 = str.charAt(i13);
                            if (Character.isSurrogatePair(charAt2, charAt3)) {
                                int codePoint = Character.toCodePoint(charAt2, charAt3);
                                bArr[i11] = (byte) ((codePoint >>> 18) | 240);
                                bArr[i11 + 1] = (byte) (((codePoint >>> 12) & 63) | 128);
                                int i14 = i11 + 3;
                                bArr[i11 + 2] = (byte) (((codePoint >>> 6) & 63) | 128);
                                i11 += 4;
                                bArr[i14] = (byte) ((codePoint & 63) | 128);
                                i10 = i13;
                            } else {
                                i10 = i13;
                            }
                        }
                        throw new UnpairedSurrogateException(i10 - 1, length);
                    }
                    bArr[i11] = (byte) ((charAt2 >>> '\f') | 480);
                    int i15 = i11 + 2;
                    bArr[i11 + 1] = (byte) (((charAt2 >>> 6) & 63) | 128);
                    i11 += 3;
                    bArr[i15] = (byte) ((charAt2 & '?') | 128);
                }
                i10++;
            }
            return i11;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class UnpairedSurrogateException extends IllegalArgumentException {
        UnpairedSurrogateException(int i5, int i6) {
            super("Unpaired surrogate at index " + i5 + " of " + i6);
        }
    }

    /* loaded from: classes.dex */
    static final class UnsafeProcessor extends Processor {
        UnsafeProcessor() {
        }

        static boolean isAvailable() {
            return UnsafeUtil.hasUnsafeArrayOperations() && UnsafeUtil.hasUnsafeByteBufferOperations();
        }

        @Override // androidx.datastore.preferences.protobuf.Utf8.Processor
        String decodeUtf8(byte[] bArr, int i5, int i6) {
            Charset charset = Internal.UTF_8;
            String str = new String(bArr, i5, i6, charset);
            if (str.indexOf(65533) >= 0 && !Arrays.equals(str.getBytes(charset), Arrays.copyOfRange(bArr, i5, i6 + i5))) {
                throw InvalidProtocolBufferException.invalidUtf8();
            }
            return str;
        }

        @Override // androidx.datastore.preferences.protobuf.Utf8.Processor
        int encodeUtf8(String str, byte[] bArr, int i5, int i6) {
            long j5;
            String str2;
            String str3;
            int i7;
            long j6;
            long j7;
            char charAt;
            long j8 = i5;
            long j9 = i6 + j8;
            int length = str.length();
            String str4 = " at index ";
            String str5 = "Failed writing ";
            if (length > i6 || bArr.length - i6 < i5) {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + str.charAt(length - 1) + " at index " + (i5 + i6));
            }
            int i8 = 0;
            while (true) {
                j5 = 1;
                if (i8 >= length || (charAt = str.charAt(i8)) >= 128) {
                    break;
                }
                UnsafeUtil.putByte(bArr, j8, (byte) charAt);
                i8++;
                j8 = 1 + j8;
            }
            if (i8 == length) {
                return (int) j8;
            }
            while (i8 < length) {
                char charAt2 = str.charAt(i8);
                if (charAt2 >= 128 || j8 >= j9) {
                    if (charAt2 >= 2048 || j8 > j9 - 2) {
                        str2 = str4;
                        str3 = str5;
                        if ((charAt2 >= 55296 && 57343 >= charAt2) || j8 > j9 - 3) {
                            if (j8 > j9 - 4) {
                                if (55296 <= charAt2 && charAt2 <= 57343 && ((i7 = i8 + 1) == length || !Character.isSurrogatePair(charAt2, str.charAt(i7)))) {
                                    throw new UnpairedSurrogateException(i8, length);
                                }
                                throw new ArrayIndexOutOfBoundsException(str3 + charAt2 + str2 + j8);
                            }
                            int i9 = i8 + 1;
                            if (i9 != length) {
                                char charAt3 = str.charAt(i9);
                                if (Character.isSurrogatePair(charAt2, charAt3)) {
                                    int codePoint = Character.toCodePoint(charAt2, charAt3);
                                    j6 = 1;
                                    UnsafeUtil.putByte(bArr, j8, (byte) ((codePoint >>> 18) | 240));
                                    j7 = j9;
                                    UnsafeUtil.putByte(bArr, j8 + 1, (byte) (((codePoint >>> 12) & 63) | 128));
                                    long j10 = j8 + 3;
                                    UnsafeUtil.putByte(bArr, j8 + 2, (byte) (((codePoint >>> 6) & 63) | 128));
                                    j8 += 4;
                                    UnsafeUtil.putByte(bArr, j10, (byte) ((codePoint & 63) | 128));
                                    i8 = i9;
                                } else {
                                    i8 = i9;
                                }
                            }
                            throw new UnpairedSurrogateException(i8 - 1, length);
                        }
                        UnsafeUtil.putByte(bArr, j8, (byte) ((charAt2 >>> '\f') | 480));
                        long j11 = j8 + 2;
                        UnsafeUtil.putByte(bArr, j8 + 1, (byte) (((charAt2 >>> 6) & 63) | 128));
                        j8 += 3;
                        UnsafeUtil.putByte(bArr, j11, (byte) ((charAt2 & '?') | 128));
                    } else {
                        str2 = str4;
                        str3 = str5;
                        long j12 = j8 + j5;
                        UnsafeUtil.putByte(bArr, j8, (byte) ((charAt2 >>> 6) | 960));
                        j8 += 2;
                        UnsafeUtil.putByte(bArr, j12, (byte) ((charAt2 & '?') | 128));
                    }
                    j7 = j9;
                    j6 = 1;
                } else {
                    UnsafeUtil.putByte(bArr, j8, (byte) charAt2);
                    j7 = j9;
                    str3 = str5;
                    j6 = j5;
                    j8 += j5;
                    str2 = str4;
                }
                i8++;
                str4 = str2;
                str5 = str3;
                j5 = j6;
                j9 = j7;
            }
            return (int) j8;
        }
    }

    static {
        processor = (!UnsafeProcessor.isAvailable() || Android.isOnAndroidDevice()) ? new SafeProcessor() : new UnsafeProcessor();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String decodeUtf8(byte[] bArr, int i5, int i6) {
        return processor.decodeUtf8(bArr, i5, i6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int encode(String str, byte[] bArr, int i5, int i6) {
        return processor.encodeUtf8(str, bArr, i5, i6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int encodedLength(String str) {
        int length = str.length();
        int i5 = 0;
        while (i5 < length && str.charAt(i5) < 128) {
            i5++;
        }
        int i6 = length;
        while (true) {
            if (i5 < length) {
                char charAt = str.charAt(i5);
                if (charAt >= 2048) {
                    i6 += encodedLengthGeneral(str, i5);
                    break;
                }
                i6 += (127 - charAt) >>> 31;
                i5++;
            } else {
                break;
            }
        }
        if (i6 >= length) {
            return i6;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (i6 + 4294967296L));
    }

    private static int encodedLengthGeneral(String str, int i5) {
        int length = str.length();
        int i6 = 0;
        while (i5 < length) {
            char charAt = str.charAt(i5);
            if (charAt < 2048) {
                i6 += (127 - charAt) >>> 31;
            } else {
                i6 += 2;
                if (55296 <= charAt && charAt <= 57343) {
                    if (Character.codePointAt(str, i5) < 65536) {
                        throw new UnpairedSurrogateException(i5, length);
                    }
                    i5++;
                }
            }
            i5++;
        }
        return i6;
    }
}
