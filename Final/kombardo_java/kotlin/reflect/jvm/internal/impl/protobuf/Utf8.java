package kotlin.reflect.jvm.internal.impl.protobuf;

/* loaded from: classes3.dex */
abstract class Utf8 {
    private static int incompleteStateFor(int i5) {
        if (i5 > -12) {
            return -1;
        }
        return i5;
    }

    public static boolean isValidUtf8(byte[] bArr) {
        return isValidUtf8(bArr, 0, bArr.length);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0015, code lost:
    
        if (r7[r8] > (-65)) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0046, code lost:
    
        if (r7[r8] > (-65)) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0083, code lost:
    
        if (r7[r6] > (-65)) goto L53;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int partialIsValidUtf8(int i5, byte[] bArr, int i6, int i7) {
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
                        return incompleteStateFor(b6, b8);
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
                    return incompleteStateFor(b6, b9);
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
                    return incompleteStateFor(b6, b9, b10);
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
                        return incompleteStateFor(bArr, i7, i6);
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
                    return incompleteStateFor(bArr, i7, i6);
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

    private static int incompleteStateFor(int i5, int i6) {
        if (i5 > -12 || i6 > -65) {
            return -1;
        }
        return i5 ^ (i6 << 8);
    }

    public static boolean isValidUtf8(byte[] bArr, int i5, int i6) {
        return partialIsValidUtf8(bArr, i5, i6) == 0;
    }

    private static int incompleteStateFor(int i5, int i6, int i7) {
        if (i5 > -12 || i6 > -65 || i7 > -65) {
            return -1;
        }
        return (i5 ^ (i6 << 8)) ^ (i7 << 16);
    }

    private static int incompleteStateFor(byte[] bArr, int i5, int i6) {
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

    public static int partialIsValidUtf8(byte[] bArr, int i5, int i6) {
        while (i5 < i6 && bArr[i5] >= 0) {
            i5++;
        }
        if (i5 >= i6) {
            return 0;
        }
        return partialIsValidUtf8NonAscii(bArr, i5, i6);
    }
}
