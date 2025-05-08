package okio;

import com.sun.jna.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.Buffer;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000L\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a'\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0013\u0010\b\u001a\u00020\u0007*\u00020\u0007H\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u0013\u0010\b\u001a\u00020\n*\u00020\nH\u0000¢\u0006\u0004\b\b\u0010\u000b\u001a\u0013\u0010\b\u001a\u00020\u0000*\u00020\u0000H\u0000¢\u0006\u0004\b\b\u0010\f\u001a7\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\nH\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u0013\u0010\u0017\u001a\u00020\u0016*\u00020\u0015H\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0013\u0010\u0017\u001a\u00020\u0016*\u00020\nH\u0000¢\u0006\u0004\b\u0017\u0010\u0019\u001a\u001b\u0010\u001c\u001a\u00020\n*\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\nH\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u001b\u0010\u001c\u001a\u00020\n*\u00020\r2\u0006\u0010\u001e\u001a\u00020\nH\u0000¢\u0006\u0004\b\u001c\u0010\u001f\" \u0010!\u001a\u00020 8\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b!\u0010\"\u0012\u0004\b%\u0010&\u001a\u0004\b#\u0010$\"\u001a\u0010'\u001a\u00020\n8\u0000X\u0080D¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*¨\u0006+"}, d2 = {BuildConfig.FLAVOR, "size", "offset", "byteCount", BuildConfig.FLAVOR, "checkOffsetAndCount", "(JJJ)V", BuildConfig.FLAVOR, "reverseBytes", "(S)S", BuildConfig.FLAVOR, "(I)I", "(J)J", BuildConfig.FLAVOR, "a", "aOffset", "b", "bOffset", BuildConfig.FLAVOR, "arrayRangeEquals", "([BI[BII)Z", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "toHexString", "(B)Ljava/lang/String;", "(I)Ljava/lang/String;", "Lokio/ByteString;", "position", "resolveDefaultParameter", "(Lokio/ByteString;I)I", "sizeParam", "([BI)I", "Lokio/Buffer$UnsafeCursor;", "DEFAULT__new_UnsafeCursor", "Lokio/Buffer$UnsafeCursor;", "getDEFAULT__new_UnsafeCursor", "()Lokio/Buffer$UnsafeCursor;", "getDEFAULT__new_UnsafeCursor$annotations", "()V", "DEFAULT__ByteString_size", "I", "getDEFAULT__ByteString_size", "()I", "okio"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* renamed from: okio.-SegmentedByteString, reason: invalid class name */
/* loaded from: classes3.dex */
public abstract class SegmentedByteString {
    private static final Buffer.UnsafeCursor DEFAULT__new_UnsafeCursor = new Buffer.UnsafeCursor();
    private static final int DEFAULT__ByteString_size = -1234567890;

    public static final boolean arrayRangeEquals(byte[] a5, int i5, byte[] b5, int i6, int i7) {
        Intrinsics.checkNotNullParameter(a5, "a");
        Intrinsics.checkNotNullParameter(b5, "b");
        for (int i8 = 0; i8 < i7; i8++) {
            if (a5[i8 + i5] != b5[i8 + i6]) {
                return false;
            }
        }
        return true;
    }

    public static final void checkOffsetAndCount(long j5, long j6, long j7) {
        if ((j6 | j7) < 0 || j6 > j5 || j5 - j6 < j7) {
            throw new ArrayIndexOutOfBoundsException("size=" + j5 + " offset=" + j6 + " byteCount=" + j7);
        }
    }

    public static final int getDEFAULT__ByteString_size() {
        return DEFAULT__ByteString_size;
    }

    public static final int resolveDefaultParameter(ByteString byteString, int i5) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        return i5 == DEFAULT__ByteString_size ? byteString.size() : i5;
    }

    public static final int reverseBytes(int i5) {
        return ((i5 & Function.USE_VARARGS) << 24) | (((-16777216) & i5) >>> 24) | ((16711680 & i5) >>> 8) | ((65280 & i5) << 8);
    }

    public static final String toHexString(byte b5) {
        return StringsKt.concatToString(new char[]{okio.internal.ByteString.getHEX_DIGIT_CHARS()[(b5 >> 4) & 15], okio.internal.ByteString.getHEX_DIGIT_CHARS()[b5 & 15]});
    }

    public static final int resolveDefaultParameter(byte[] bArr, int i5) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return i5 == DEFAULT__ByteString_size ? bArr.length : i5;
    }

    public static final long reverseBytes(long j5) {
        return ((j5 & 255) << 56) | (((-72057594037927936L) & j5) >>> 56) | ((71776119061217280L & j5) >>> 40) | ((280375465082880L & j5) >>> 24) | ((1095216660480L & j5) >>> 8) | ((4278190080L & j5) << 8) | ((16711680 & j5) << 24) | ((65280 & j5) << 40);
    }

    public static final short reverseBytes(short s5) {
        return (short) (((s5 & 255) << 8) | ((65280 & s5) >>> 8));
    }

    public static final String toHexString(int i5) {
        int i6 = 0;
        if (i5 == 0) {
            return "0";
        }
        char[] cArr = {okio.internal.ByteString.getHEX_DIGIT_CHARS()[(i5 >> 28) & 15], okio.internal.ByteString.getHEX_DIGIT_CHARS()[(i5 >> 24) & 15], okio.internal.ByteString.getHEX_DIGIT_CHARS()[(i5 >> 20) & 15], okio.internal.ByteString.getHEX_DIGIT_CHARS()[(i5 >> 16) & 15], okio.internal.ByteString.getHEX_DIGIT_CHARS()[(i5 >> 12) & 15], okio.internal.ByteString.getHEX_DIGIT_CHARS()[(i5 >> 8) & 15], okio.internal.ByteString.getHEX_DIGIT_CHARS()[(i5 >> 4) & 15], okio.internal.ByteString.getHEX_DIGIT_CHARS()[i5 & 15]};
        while (i6 < 8 && cArr[i6] == '0') {
            i6++;
        }
        return StringsKt.concatToString(cArr, i6, 8);
    }
}
