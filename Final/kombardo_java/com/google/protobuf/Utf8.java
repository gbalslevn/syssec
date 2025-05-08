package com.google.protobuf;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class Utf8 {
    private static final long ASCII_MASK_LONG = -9187201950435737472L;
    private static final int UNSAFE_COUNT_ASCII_THRESHOLD = 16;
    private static final Processor processor;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static abstract class Processor {
        Processor() {
        }

        abstract int encodeUtf8(CharSequence charSequence, byte[] bArr, int i5, int i6);

        final boolean isValidUtf8(byte[] bArr, int i5, int i6) {
            return partialIsValidUtf8(0, bArr, i5, i6) == 0;
        }

        abstract int partialIsValidUtf8(int i5, byte[] bArr, int i6, int i7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class UnpairedSurrogateException extends IllegalArgumentException {
        UnpairedSurrogateException(int i5, int i6) {
            super("Unpaired surrogate at index " + i5 + " of " + i6);
        }
    }

    static {
        processor = (!UnsafeProcessor.isAvailable() || Android.isOnAndroidDevice()) ? new SafeProcessor() : new UnsafeProcessor();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int encode(CharSequence charSequence, byte[] bArr, int i5, int i6) {
        return processor.encodeUtf8(charSequence, bArr, i5, i6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int encodedLength(CharSequence charSequence) {
        int length = charSequence.length();
        int i5 = 0;
        while (i5 < length && charSequence.charAt(i5) < 128) {
            i5++;
        }
        int i6 = length;
        while (true) {
            if (i5 < length) {
                char charAt = charSequence.charAt(i5);
                if (charAt >= 2048) {
                    i6 += encodedLengthGeneral(charSequence, i5);
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

    private static int encodedLengthGeneral(CharSequence charSequence, int i5) {
        int length = charSequence.length();
        int i6 = 0;
        while (i5 < length) {
            char charAt = charSequence.charAt(i5);
            if (charAt < 2048) {
                i6 += (127 - charAt) >>> 31;
            } else {
                i6 += 2;
                if (55296 <= charAt && charAt <= 57343) {
                    if (Character.codePointAt(charSequence, i5) < 65536) {
                        throw new UnpairedSurrogateException(i5, length);
                    }
                    i5++;
                }
            }
            i5++;
        }
        return i6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int incompleteStateFor(int i5) {
        if (i5 > -12) {
            return -1;
        }
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isValidUtf8(byte[] bArr) {
        return processor.isValidUtf8(bArr, 0, bArr.length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int incompleteStateFor(int i5, int i6) {
        if (i5 > -12 || i6 > -65) {
            return -1;
        }
        return i5 ^ (i6 << 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isValidUtf8(byte[] bArr, int i5, int i6) {
        return processor.isValidUtf8(bArr, i5, i6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int incompleteStateFor(int i5, int i6, int i7) {
        if (i5 > -12 || i6 > -65 || i7 > -65) {
            return -1;
        }
        return (i5 ^ (i6 << 8)) ^ (i7 << 16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int incompleteStateFor(byte[] bArr, int i5, int i6) {
        byte b5 = bArr[i5 - 1];
        int i7 = i6 - i5;
        if (i7 == 0) {
            return incompleteStateFor(b5);
        }
        if (i7 == 1) {
            return incompleteStateFor(b5, bArr[i5]);
        }
        if (i7 == 2) {
            return incompleteStateFor(b5, bArr[i5], bArr[i5 + 1]);
        }
        throw new AssertionError();
    }

    /* loaded from: classes2.dex */
    static final class SafeProcessor extends Processor {
        SafeProcessor() {
        }

        private static int partialIsValidUtf8NonAscii(byte[] bArr, int i5, int i6) {
            while (i5 < i6) {
                int i7 = i5 + 1;
                byte b5 = bArr[i5];
                if (b5 < 0) {
                    if (b5 < -32) {
                        if (i7 >= i6) {
                            return b5;
                        }
                        if (b5 >= -62) {
                            i5 += 2;
                            if (bArr[i7] > -65) {
                            }
                        }
                        return -1;
                    }
                    if (b5 >= -16) {
                        if (i7 >= i6 - 2) {
                            return Utf8.incompleteStateFor(bArr, i7, i6);
                        }
                        int i8 = i5 + 2;
                        byte b6 = bArr[i7];
                        if (b6 <= -65 && (((b5 << 28) + (b6 + 112)) >> 30) == 0) {
                            int i9 = i5 + 3;
                            if (bArr[i8] <= -65) {
                                i5 += 4;
                                if (bArr[i9] > -65) {
                                }
                            }
                        }
                        return -1;
                    }
                    if (i7 >= i6 - 1) {
                        return Utf8.incompleteStateFor(bArr, i7, i6);
                    }
                    int i10 = i5 + 2;
                    byte b7 = bArr[i7];
                    if (b7 <= -65 && ((b5 != -32 || b7 >= -96) && (b5 != -19 || b7 < -96))) {
                        i5 += 3;
                        if (bArr[i10] > -65) {
                        }
                    }
                    return -1;
                }
                i5 = i7;
            }
            return 0;
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
        
            return r10 + r0;
         */
        @Override // com.google.protobuf.Utf8.Processor
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        int encodeUtf8(CharSequence charSequence, byte[] bArr, int i5, int i6) {
            int i7;
            int i8;
            char charAt;
            int length = charSequence.length();
            int i9 = i6 + i5;
            int i10 = 0;
            while (i10 < length && (i8 = i10 + i5) < i9 && (charAt = charSequence.charAt(i10)) < 128) {
                bArr[i8] = (byte) charAt;
                i10++;
            }
            int i11 = i5 + i10;
            while (i10 < length) {
                char charAt2 = charSequence.charAt(i10);
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
                            if (55296 <= charAt2 && charAt2 <= 57343 && ((i7 = i10 + 1) == charSequence.length() || !Character.isSurrogatePair(charAt2, charSequence.charAt(i7)))) {
                                throw new UnpairedSurrogateException(i10, length);
                            }
                            throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + i11);
                        }
                        int i13 = i10 + 1;
                        if (i13 != charSequence.length()) {
                            char charAt3 = charSequence.charAt(i13);
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

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0015, code lost:
        
            if (r8[r9] > (-65)) goto L13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0046, code lost:
        
            if (r8[r9] > (-65)) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x0083, code lost:
        
            if (r8[r7] > (-65)) goto L53;
         */
        @Override // com.google.protobuf.Utf8.Processor
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        int partialIsValidUtf8(int i5, byte[] bArr, int i6, int i7) {
            byte b5;
            int i8;
            int i9;
            if (i5 != 0) {
                if (i6 >= i7) {
                    return i5;
                }
                byte b6 = (byte) i5;
                if (b6 < -32) {
                    if (b6 >= -62) {
                        i9 = i6 + 1;
                    }
                    return -1;
                }
                if (b6 < -16) {
                    byte b7 = (byte) (~(i5 >> 8));
                    if (b7 == 0) {
                        int i10 = i6 + 1;
                        byte b8 = bArr[i6];
                        if (i10 >= i7) {
                            return Utf8.incompleteStateFor(b6, b8);
                        }
                        i6 = i10;
                        b7 = b8;
                    }
                    if (b7 <= -65 && ((b6 != -32 || b7 >= -96) && (b6 != -19 || b7 < -96))) {
                        i9 = i6 + 1;
                    }
                    return -1;
                }
                byte b9 = (byte) (~(i5 >> 8));
                if (b9 == 0) {
                    i8 = i6 + 1;
                    b9 = bArr[i6];
                    if (i8 >= i7) {
                        return Utf8.incompleteStateFor(b6, b9);
                    }
                    b5 = 0;
                } else {
                    b5 = (byte) (i5 >> 16);
                    i8 = i6;
                }
                if (b5 == 0) {
                    int i11 = i8 + 1;
                    byte b10 = bArr[i8];
                    if (i11 >= i7) {
                        return Utf8.incompleteStateFor(b6, b9, b10);
                    }
                    b5 = b10;
                    i8 = i11;
                }
                if (b9 <= -65 && (((b6 << 28) + (b9 + 112)) >> 30) == 0 && b5 <= -65) {
                    i6 = i8 + 1;
                }
                return -1;
                i6 = i9;
            }
            return partialIsValidUtf8(bArr, i6, i7);
        }

        private static int partialIsValidUtf8(byte[] bArr, int i5, int i6) {
            while (i5 < i6 && bArr[i5] >= 0) {
                i5++;
            }
            if (i5 >= i6) {
                return 0;
            }
            return partialIsValidUtf8NonAscii(bArr, i5, i6);
        }
    }

    /* loaded from: classes2.dex */
    static final class UnsafeProcessor extends Processor {
        UnsafeProcessor() {
        }

        static boolean isAvailable() {
            return UnsafeUtil.hasUnsafeArrayOperations() && UnsafeUtil.hasUnsafeByteBufferOperations();
        }

        private static int unsafeEstimateConsecutiveAscii(byte[] bArr, long j5, int i5) {
            int i6 = 0;
            if (i5 < 16) {
                return 0;
            }
            int i7 = 8 - (((int) j5) & 7);
            while (i6 < i7) {
                long j6 = 1 + j5;
                if (UnsafeUtil.getByte(bArr, j5) < 0) {
                    return i6;
                }
                i6++;
                j5 = j6;
            }
            while (true) {
                int i8 = i6 + 8;
                if (i8 > i5 || (UnsafeUtil.getLong(bArr, UnsafeUtil.BYTE_ARRAY_BASE_OFFSET + j5) & Utf8.ASCII_MASK_LONG) != 0) {
                    break;
                }
                j5 += 8;
                i6 = i8;
            }
            while (i6 < i5) {
                long j7 = j5 + 1;
                if (UnsafeUtil.getByte(bArr, j5) < 0) {
                    return i6;
                }
                i6++;
                j5 = j7;
            }
            return i5;
        }

        private static int unsafeIncompleteStateFor(byte[] bArr, int i5, long j5, int i6) {
            if (i6 == 0) {
                return Utf8.incompleteStateFor(i5);
            }
            if (i6 == 1) {
                return Utf8.incompleteStateFor(i5, UnsafeUtil.getByte(bArr, j5));
            }
            if (i6 == 2) {
                return Utf8.incompleteStateFor(i5, UnsafeUtil.getByte(bArr, j5), UnsafeUtil.getByte(bArr, j5 + 1));
            }
            throw new AssertionError();
        }

        @Override // com.google.protobuf.Utf8.Processor
        int encodeUtf8(CharSequence charSequence, byte[] bArr, int i5, int i6) {
            long j5;
            String str;
            String str2;
            int i7;
            long j6;
            long j7;
            char charAt;
            long j8 = i5;
            long j9 = i6 + j8;
            int length = charSequence.length();
            String str3 = " at index ";
            String str4 = "Failed writing ";
            if (length > i6 || bArr.length - i6 < i5) {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(length - 1) + " at index " + (i5 + i6));
            }
            int i8 = 0;
            while (true) {
                j5 = 1;
                if (i8 >= length || (charAt = charSequence.charAt(i8)) >= 128) {
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
                char charAt2 = charSequence.charAt(i8);
                if (charAt2 >= 128 || j8 >= j9) {
                    if (charAt2 >= 2048 || j8 > j9 - 2) {
                        str = str3;
                        str2 = str4;
                        if ((charAt2 >= 55296 && 57343 >= charAt2) || j8 > j9 - 3) {
                            if (j8 > j9 - 4) {
                                if (55296 <= charAt2 && charAt2 <= 57343 && ((i7 = i8 + 1) == length || !Character.isSurrogatePair(charAt2, charSequence.charAt(i7)))) {
                                    throw new UnpairedSurrogateException(i8, length);
                                }
                                throw new ArrayIndexOutOfBoundsException(str2 + charAt2 + str + j8);
                            }
                            int i9 = i8 + 1;
                            if (i9 != length) {
                                char charAt3 = charSequence.charAt(i9);
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
                        str = str3;
                        str2 = str4;
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
                    str2 = str4;
                    j6 = j5;
                    j8 += j5;
                    str = str3;
                }
                i8++;
                str3 = str;
                str4 = str2;
                j5 = j6;
                j9 = j7;
            }
            return (int) j8;
        }

        /* JADX WARN: Code restructure failed: missing block: B:34:0x0058, code lost:
        
            if (com.google.protobuf.UnsafeUtil.getByte(r12, r0) > (-65)) goto L38;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x009e, code lost:
        
            if (com.google.protobuf.UnsafeUtil.getByte(r12, r0) > (-65)) goto L59;
         */
        @Override // com.google.protobuf.Utf8.Processor
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        int partialIsValidUtf8(int i5, byte[] bArr, int i6, int i7) {
            byte b5;
            long j5;
            if ((i6 | i7 | (bArr.length - i7)) >= 0) {
                long j6 = i6;
                long j7 = i7;
                if (i5 != 0) {
                    if (j6 >= j7) {
                        return i5;
                    }
                    byte b6 = (byte) i5;
                    if (b6 < -32) {
                        if (b6 >= -62) {
                            long j8 = 1 + j6;
                            if (UnsafeUtil.getByte(bArr, j6) <= -65) {
                                j6 = j8;
                            }
                        }
                        return -1;
                    }
                    if (b6 < -16) {
                        byte b7 = (byte) (~(i5 >> 8));
                        if (b7 == 0) {
                            long j9 = j6 + 1;
                            b7 = UnsafeUtil.getByte(bArr, j6);
                            if (j9 >= j7) {
                                return Utf8.incompleteStateFor(b6, b7);
                            }
                            j6 = j9;
                        }
                        if (b7 <= -65 && ((b6 != -32 || b7 >= -96) && (b6 != -19 || b7 < -96))) {
                            j5 = j6 + 1;
                        }
                        return -1;
                    }
                    byte b8 = (byte) (~(i5 >> 8));
                    if (b8 == 0) {
                        long j10 = j6 + 1;
                        b8 = UnsafeUtil.getByte(bArr, j6);
                        if (j10 >= j7) {
                            return Utf8.incompleteStateFor(b6, b8);
                        }
                        b5 = 0;
                        j6 = j10;
                    } else {
                        b5 = (byte) (i5 >> 16);
                    }
                    if (b5 == 0) {
                        long j11 = j6 + 1;
                        b5 = UnsafeUtil.getByte(bArr, j6);
                        if (j11 >= j7) {
                            return Utf8.incompleteStateFor(b6, b8, b5);
                        }
                        j6 = j11;
                    }
                    if (b8 <= -65 && (((b6 << 28) + (b8 + 112)) >> 30) == 0 && b5 <= -65) {
                        j5 = j6 + 1;
                    }
                    return -1;
                    j6 = j5;
                }
                return partialIsValidUtf8(bArr, j6, (int) (j7 - j6));
            }
            throw new ArrayIndexOutOfBoundsException(String.format("Array length=%d, index=%d, limit=%d", Integer.valueOf(bArr.length), Integer.valueOf(i6), Integer.valueOf(i7)));
        }

        /* JADX WARN: Code restructure failed: missing block: B:69:0x0039, code lost:
        
            return -1;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private static int partialIsValidUtf8(byte[] bArr, long j5, int i5) {
            int unsafeEstimateConsecutiveAscii = unsafeEstimateConsecutiveAscii(bArr, j5, i5);
            int i6 = i5 - unsafeEstimateConsecutiveAscii;
            long j6 = j5 + unsafeEstimateConsecutiveAscii;
            while (true) {
                byte b5 = 0;
                while (true) {
                    if (i6 <= 0) {
                        break;
                    }
                    long j7 = j6 + 1;
                    b5 = UnsafeUtil.getByte(bArr, j6);
                    if (b5 < 0) {
                        j6 = j7;
                        break;
                    }
                    i6--;
                    j6 = j7;
                }
                if (i6 != 0) {
                    int i7 = i6 - 1;
                    if (b5 >= -32) {
                        if (b5 >= -16) {
                            if (i7 < 3) {
                                return unsafeIncompleteStateFor(bArr, b5, j6, i7);
                            }
                            i6 -= 4;
                            long j8 = 1 + j6;
                            byte b6 = UnsafeUtil.getByte(bArr, j6);
                            if (b6 > -65 || (((b5 << 28) + (b6 + 112)) >> 30) != 0) {
                                break;
                            }
                            long j9 = 2 + j6;
                            if (UnsafeUtil.getByte(bArr, j8) > -65) {
                                break;
                            }
                            j6 += 3;
                            if (UnsafeUtil.getByte(bArr, j9) > -65) {
                                break;
                            }
                        } else {
                            if (i7 < 2) {
                                return unsafeIncompleteStateFor(bArr, b5, j6, i7);
                            }
                            i6 -= 3;
                            long j10 = 1 + j6;
                            byte b7 = UnsafeUtil.getByte(bArr, j6);
                            if (b7 > -65 || ((b5 == -32 && b7 < -96) || (b5 == -19 && b7 >= -96))) {
                                break;
                            }
                            j6 += 2;
                            if (UnsafeUtil.getByte(bArr, j10) > -65) {
                                break;
                            }
                        }
                    } else if (i7 != 0) {
                        i6 -= 2;
                        if (b5 < -62) {
                            break;
                        }
                        long j11 = 1 + j6;
                        if (UnsafeUtil.getByte(bArr, j6) > -65) {
                            break;
                        }
                        j6 = j11;
                    } else {
                        return b5;
                    }
                } else {
                    return 0;
                }
            }
            return -1;
        }
    }
}
