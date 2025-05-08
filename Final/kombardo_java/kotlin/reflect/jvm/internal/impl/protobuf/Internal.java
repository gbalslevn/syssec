package kotlin.reflect.jvm.internal.impl.protobuf;

import com.adjust.sdk.Constants;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public abstract class Internal {
    public static final byte[] EMPTY_BYTE_ARRAY;
    public static final ByteBuffer EMPTY_BYTE_BUFFER;

    /* loaded from: classes3.dex */
    public interface EnumLite {
        int getNumber();
    }

    /* loaded from: classes3.dex */
    public interface EnumLiteMap<T extends EnumLite> {
        T findValueByNumber(int i5);
    }

    static {
        byte[] bArr = new byte[0];
        EMPTY_BYTE_ARRAY = bArr;
        EMPTY_BYTE_BUFFER = ByteBuffer.wrap(bArr);
    }

    public static boolean isValidUtf8(byte[] bArr) {
        return Utf8.isValidUtf8(bArr);
    }

    public static String toStringUtf8(byte[] bArr) {
        try {
            return new String(bArr, Constants.ENCODING);
        } catch (UnsupportedEncodingException e5) {
            throw new RuntimeException("UTF-8 not supported?", e5);
        }
    }
}
