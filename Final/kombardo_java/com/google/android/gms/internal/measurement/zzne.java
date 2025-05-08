package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
final class zzne extends zznb {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
    
        return r10 + r0;
     */
    @Override // com.google.android.gms.internal.measurement.zznb
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int zza(String str, byte[] bArr, int i5, int i6) {
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
                    if (i11 <= i9 - 4) {
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
                        throw new zznd(i10 - 1, length);
                    }
                    if (55296 <= charAt2 && charAt2 <= 57343 && ((i7 = i10 + 1) == str.length() || !Character.isSurrogatePair(charAt2, str.charAt(i7)))) {
                        throw new zznd(i10, length);
                    }
                    throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + i11);
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

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zznb
    public final int zza(int i5, byte[] bArr, int i6, int i7) {
        while (i6 < i7 && bArr[i6] >= 0) {
            i6++;
        }
        if (i6 >= i7) {
            return 0;
        }
        while (i6 < i7) {
            int i8 = i6 + 1;
            byte b5 = bArr[i6];
            if (b5 < 0) {
                if (b5 < -32) {
                    if (i8 >= i7) {
                        return b5;
                    }
                    if (b5 >= -62) {
                        i6 += 2;
                        if (bArr[i8] > -65) {
                        }
                    }
                    return -1;
                }
                if (b5 >= -16) {
                    if (i8 >= i7 - 2) {
                        return zzna.zza(bArr, i8, i7);
                    }
                    int i9 = i6 + 2;
                    byte b6 = bArr[i8];
                    if (b6 <= -65 && (((b5 << 28) + (b6 + 112)) >> 30) == 0) {
                        int i10 = i6 + 3;
                        if (bArr[i9] <= -65) {
                            i6 += 4;
                            if (bArr[i10] > -65) {
                            }
                        }
                    }
                    return -1;
                }
                if (i8 >= i7 - 1) {
                    return zzna.zza(bArr, i8, i7);
                }
                int i11 = i6 + 2;
                byte b7 = bArr[i8];
                if (b7 <= -65 && ((b5 != -32 || b7 >= -96) && (b5 != -19 || b7 < -96))) {
                    i6 += 3;
                    if (bArr[i11] > -65) {
                    }
                }
                return -1;
            }
            i6 = i8;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zznb
    public final String zza(byte[] bArr, int i5, int i6) {
        if ((i5 | i6 | ((bArr.length - i5) - i6)) >= 0) {
            int i7 = i5 + i6;
            char[] cArr = new char[i6];
            int i8 = 0;
            while (i5 < i7) {
                byte b5 = bArr[i5];
                if (b5 < 0) {
                    break;
                }
                i5++;
                zznc.zza(b5, cArr, i8);
                i8++;
            }
            int i9 = i8;
            while (i5 < i7) {
                int i10 = i5 + 1;
                byte b6 = bArr[i5];
                if (b6 >= 0) {
                    int i11 = i9 + 1;
                    zznc.zza(b6, cArr, i9);
                    while (i10 < i7) {
                        byte b7 = bArr[i10];
                        if (b7 < 0) {
                            break;
                        }
                        i10++;
                        zznc.zza(b7, cArr, i11);
                        i11++;
                    }
                    i9 = i11;
                    i5 = i10;
                } else if (b6 < -32) {
                    if (i10 < i7) {
                        i5 += 2;
                        zznc.zza(b6, bArr[i10], cArr, i9);
                        i9++;
                    } else {
                        throw zzkp.zzd();
                    }
                } else if (b6 < -16) {
                    if (i10 < i7 - 1) {
                        int i12 = i5 + 2;
                        i5 += 3;
                        zznc.zza(b6, bArr[i10], bArr[i12], cArr, i9);
                        i9++;
                    } else {
                        throw zzkp.zzd();
                    }
                } else if (i10 < i7 - 2) {
                    byte b8 = bArr[i10];
                    int i13 = i5 + 3;
                    byte b9 = bArr[i5 + 2];
                    i5 += 4;
                    zznc.zza(b6, b8, b9, bArr[i13], cArr, i9);
                    i9 += 2;
                } else {
                    throw zzkp.zzd();
                }
            }
            return new String(cArr, 0, i9);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i5), Integer.valueOf(i6)));
    }
}
