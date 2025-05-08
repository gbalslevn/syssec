package okio;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u001a\u001d\u0010\u0003\u001a\u00020\u0002*\u00020\u00002\b\b\u0002\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\" \u0010\u0005\u001a\u00020\u00008\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b\" \u0010\u000b\u001a\u00020\u00008\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\u000b\u0010\u0006\u0012\u0004\b\r\u0010\n\u001a\u0004\b\f\u0010\b¨\u0006\u000e"}, d2 = {BuildConfig.FLAVOR, "map", BuildConfig.FLAVOR, "encodeBase64", "([B[B)Ljava/lang/String;", "BASE64", "[B", "getBASE64", "()[B", "getBASE64$annotations", "()V", "BASE64_URL_SAFE", "getBASE64_URL_SAFE", "getBASE64_URL_SAFE$annotations", "okio"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* renamed from: okio.-Base64, reason: invalid class name */
/* loaded from: classes3.dex */
public abstract class Base64 {
    private static final byte[] BASE64;
    private static final byte[] BASE64_URL_SAFE;

    static {
        ByteString.Companion companion = ByteString.Companion;
        BASE64 = companion.encodeUtf8("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/").getData$okio();
        BASE64_URL_SAFE = companion.encodeUtf8("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_").getData$okio();
    }

    public static final String encodeBase64(byte[] bArr, byte[] map) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(map, "map");
        byte[] bArr2 = new byte[((bArr.length + 2) / 3) * 4];
        int length = bArr.length - (bArr.length % 3);
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            byte b5 = bArr[i5];
            int i7 = i5 + 2;
            byte b6 = bArr[i5 + 1];
            i5 += 3;
            byte b7 = bArr[i7];
            bArr2[i6] = map[(b5 & 255) >> 2];
            bArr2[i6 + 1] = map[((b5 & 3) << 4) | ((b6 & 255) >> 4)];
            int i8 = i6 + 3;
            bArr2[i6 + 2] = map[((b6 & 15) << 2) | ((b7 & 255) >> 6)];
            i6 += 4;
            bArr2[i8] = map[b7 & 63];
        }
        int length2 = bArr.length - length;
        if (length2 == 1) {
            byte b8 = bArr[i5];
            bArr2[i6] = map[(b8 & 255) >> 2];
            bArr2[i6 + 1] = map[(b8 & 3) << 4];
            bArr2[i6 + 2] = 61;
            bArr2[i6 + 3] = 61;
        } else if (length2 == 2) {
            int i9 = i5 + 1;
            byte b9 = bArr[i5];
            byte b10 = bArr[i9];
            bArr2[i6] = map[(b9 & 255) >> 2];
            bArr2[i6 + 1] = map[((b9 & 3) << 4) | ((b10 & 255) >> 4)];
            bArr2[i6 + 2] = map[(b10 & 15) << 2];
            bArr2[i6 + 3] = 61;
        }
        return _JvmPlatformKt.toUtf8String(bArr2);
    }

    public static /* synthetic */ String encodeBase64$default(byte[] bArr, byte[] bArr2, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            bArr2 = BASE64;
        }
        return encodeBase64(bArr, bArr2);
    }
}
