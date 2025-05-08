package com.soywiz.krypto.encoding;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0015\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\u0007\u001a\u00020\u0005*\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\r\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\t8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\t8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/soywiz/krypto/encoding/Base64;", BuildConfig.FLAVOR, "<init>", "()V", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "index", "readU8", "([BI)I", BuildConfig.FLAVOR, "str", BuildConfig.FLAVOR, "url", "decode", "(Ljava/lang/String;Z)[B", "src", "dst", "([B[BZ)I", "TABLE", "Ljava/lang/String;", "TABLE_URL", BuildConfig.FLAVOR, "DECODE", "[I", "DECODE_URL", "krypto_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class Base64 {
    private static final int[] DECODE;
    private static final int[] DECODE_URL;
    public static final Base64 INSTANCE = new Base64();
    private static final String TABLE = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=";
    private static final String TABLE_URL = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_=";

    static {
        int[] decodeArray;
        int[] decodeArray2;
        decodeArray = Base64Kt.toDecodeArray("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=");
        DECODE = decodeArray;
        decodeArray2 = Base64Kt.toDecodeArray("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_=");
        DECODE_URL = decodeArray2;
    }

    private Base64() {
    }

    public static /* synthetic */ byte[] decode$default(Base64 base64, String str, boolean z5, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            z5 = false;
        }
        return base64.decode(str, z5);
    }

    private final int readU8(byte[] bArr, int i5) {
        return bArr[i5] & 255;
    }

    public final byte[] decode(String str, boolean url) {
        int length = str.length();
        byte[] bArr = new byte[length];
        for (int i5 = 0; i5 < length; i5++) {
            bArr[i5] = (byte) str.charAt(i5);
        }
        byte[] bArr2 = new byte[length];
        byte[] copyOf = Arrays.copyOf(bArr2, decode(bArr, bArr2, url));
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        return copyOf;
    }

    public final int decode(byte[] src, byte[] dst, boolean url) {
        int[] iArr;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        if (url) {
            iArr = DECODE_URL;
        } else {
            iArr = DECODE;
        }
        int i12 = 0;
        int i13 = 0;
        while (i12 < src.length) {
            if (iArr[readU8(src, i12)] < 0) {
                i12++;
            } else {
                if (i12 < src.length) {
                    i5 = i12 + 1;
                    i6 = iArr[readU8(src, i12)];
                } else {
                    i5 = i12;
                    i6 = 64;
                }
                if (i5 < src.length) {
                    i7 = i5 + 1;
                    i8 = iArr[readU8(src, i5)];
                } else {
                    i7 = i5;
                    i8 = 64;
                }
                if (i7 < src.length) {
                    i9 = i7 + 1;
                    i10 = iArr[readU8(src, i7)];
                } else {
                    i9 = i7;
                    i10 = 64;
                }
                if (i9 < src.length) {
                    i11 = iArr[readU8(src, i9)];
                    i9++;
                } else {
                    i11 = 64;
                }
                int i14 = i13 + 1;
                dst[i13] = (byte) ((i6 << 2) | (i8 >> 4));
                if (i10 < 64) {
                    int i15 = i13 + 2;
                    dst[i14] = (byte) ((i8 << 4) | (i10 >> 2));
                    if (i11 < 64) {
                        i13 += 3;
                        dst[i15] = (byte) ((i10 << 6) | i11);
                    } else {
                        i13 = i15;
                    }
                    i12 = i9;
                } else {
                    i12 = i9;
                    i13 = i14;
                }
            }
        }
        return i13;
    }
}
