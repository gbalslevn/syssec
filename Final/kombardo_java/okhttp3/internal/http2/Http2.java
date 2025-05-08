package okhttp3.internal.http2;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.internal.Util;
import okio.ByteString;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J5\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0018R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0018¨\u0006\u001b"}, d2 = {"Lokhttp3/internal/http2/Http2;", BuildConfig.FLAVOR, "<init>", "()V", BuildConfig.FLAVOR, "inbound", BuildConfig.FLAVOR, "streamId", "length", "type", "flags", BuildConfig.FLAVOR, "frameLog", "(ZIIII)Ljava/lang/String;", "formattedType$okhttp", "(I)Ljava/lang/String;", "formattedType", "formatFlags", "(II)Ljava/lang/String;", "Lokio/ByteString;", "CONNECTION_PREFACE", "Lokio/ByteString;", BuildConfig.FLAVOR, "FRAME_NAMES", "[Ljava/lang/String;", "FLAGS", "BINARY", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Http2 {
    private static final String[] BINARY;
    public static final Http2 INSTANCE = new Http2();
    public static final ByteString CONNECTION_PREFACE = ByteString.INSTANCE.encodeUtf8("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
    private static final String[] FRAME_NAMES = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
    private static final String[] FLAGS = new String[64];

    static {
        String[] strArr = new String[256];
        int i5 = 0;
        for (int i6 = 0; i6 < 256; i6++) {
            String binaryString = Integer.toBinaryString(i6);
            Intrinsics.checkNotNullExpressionValue(binaryString, "toBinaryString(it)");
            strArr[i6] = StringsKt.replace$default(Util.format("%8s", binaryString), ' ', '0', false, 4, (Object) null);
        }
        BINARY = strArr;
        String[] strArr2 = FLAGS;
        strArr2[0] = BuildConfig.FLAVOR;
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        int i7 = iArr[0];
        strArr2[i7 | 8] = Intrinsics.stringPlus(strArr2[i7], "|PADDED");
        strArr2[4] = "END_HEADERS";
        strArr2[32] = "PRIORITY";
        strArr2[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        int i8 = 0;
        while (i8 < 3) {
            int i9 = iArr2[i8];
            i8++;
            int i10 = iArr[0];
            String[] strArr3 = FLAGS;
            int i11 = i10 | i9;
            StringBuilder sb = new StringBuilder();
            sb.append((Object) strArr3[i10]);
            sb.append('|');
            sb.append((Object) strArr3[i9]);
            strArr3[i11] = sb.toString();
            strArr3[i11 | 8] = ((Object) strArr3[i10]) + '|' + ((Object) strArr3[i9]) + "|PADDED";
        }
        int length = FLAGS.length;
        while (i5 < length) {
            int i12 = i5 + 1;
            String[] strArr4 = FLAGS;
            if (strArr4[i5] == null) {
                strArr4[i5] = BINARY[i5];
            }
            i5 = i12;
        }
    }

    private Http2() {
    }

    public final String formatFlags(int type, int flags) {
        String str;
        if (flags == 0) {
            return BuildConfig.FLAVOR;
        }
        if (type != 2 && type != 3) {
            if (type == 4 || type == 6) {
                return flags == 1 ? "ACK" : BINARY[flags];
            }
            if (type != 7 && type != 8) {
                String[] strArr = FLAGS;
                if (flags < strArr.length) {
                    str = strArr[flags];
                    Intrinsics.checkNotNull(str);
                } else {
                    str = BINARY[flags];
                }
                String str2 = str;
                return (type != 5 || (flags & 4) == 0) ? (type != 0 || (flags & 32) == 0) ? str2 : StringsKt.replace$default(str2, "PRIORITY", "COMPRESSED", false, 4, (Object) null) : StringsKt.replace$default(str2, "HEADERS", "PUSH_PROMISE", false, 4, (Object) null);
            }
        }
        return BINARY[flags];
    }

    public final String formattedType$okhttp(int type) {
        String[] strArr = FRAME_NAMES;
        return type < strArr.length ? strArr[type] : Util.format("0x%02x", Integer.valueOf(type));
    }

    public final String frameLog(boolean inbound, int streamId, int length, int type, int flags) {
        return Util.format("%s 0x%08x %5d %-13s %s", inbound ? "<<" : ">>", Integer.valueOf(streamId), Integer.valueOf(length), formattedType$okhttp(type), formatFlags(type, flags));
    }
}
