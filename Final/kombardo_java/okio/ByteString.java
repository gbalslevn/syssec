package okio;

import com.adjust.sdk.Constants;
import java.io.EOFException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u0013\b\u0016\u0018\u0000 X2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001XB\u0011\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0012J\r\u0010\u0014\u001a\u00020\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0010H\u0010¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u001a\u0010\u0012J\u000f\u0010\u001b\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u001b\u0010\u0015J#\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u001cH\u0017¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010%\u001a\u00020\"2\u0006\u0010!\u001a\u00020\u001cH\u0010¢\u0006\u0004\b#\u0010$J\u0018\u0010(\u001a\u00020\"2\u0006\u0010&\u001a\u00020\u001cH\u0087\u0002¢\u0006\u0004\b'\u0010$J\u000f\u0010+\u001a\u00020\u001cH\u0010¢\u0006\u0004\b)\u0010*J\u000f\u0010.\u001a\u00020\u0003H\u0010¢\u0006\u0004\b,\u0010-J'\u00105\u001a\u00020\t2\u0006\u00100\u001a\u00020/2\u0006\u00101\u001a\u00020\u001c2\u0006\u00102\u001a\u00020\u001cH\u0010¢\u0006\u0004\b3\u00104J/\u00109\u001a\u0002082\u0006\u00101\u001a\u00020\u001c2\u0006\u00106\u001a\u00020\u00002\u0006\u00107\u001a\u00020\u001c2\u0006\u00102\u001a\u00020\u001cH\u0016¢\u0006\u0004\b9\u0010:J/\u00109\u001a\u0002082\u0006\u00101\u001a\u00020\u001c2\u0006\u00106\u001a\u00020\u00032\u0006\u00107\u001a\u00020\u001c2\u0006\u00102\u001a\u00020\u001cH\u0016¢\u0006\u0004\b9\u0010;J\u0015\u0010=\u001a\u0002082\u0006\u0010<\u001a\u00020\u0000¢\u0006\u0004\b=\u0010>J\u0015\u0010@\u001a\u0002082\u0006\u0010?\u001a\u00020\u0000¢\u0006\u0004\b@\u0010>J!\u0010B\u001a\u00020\u001c2\u0006\u00106\u001a\u00020\u00002\b\b\u0002\u0010A\u001a\u00020\u001cH\u0007¢\u0006\u0004\bB\u0010CJ!\u0010B\u001a\u00020\u001c2\u0006\u00106\u001a\u00020\u00032\b\b\u0002\u0010A\u001a\u00020\u001cH\u0017¢\u0006\u0004\bB\u0010DJ!\u0010E\u001a\u00020\u001c2\u0006\u00106\u001a\u00020\u00002\b\b\u0002\u0010A\u001a\u00020\u001cH\u0007¢\u0006\u0004\bE\u0010CJ!\u0010E\u001a\u00020\u001c2\u0006\u00106\u001a\u00020\u00032\b\b\u0002\u0010A\u001a\u00020\u001cH\u0017¢\u0006\u0004\bE\u0010DJ\u001a\u0010G\u001a\u0002082\b\u00106\u001a\u0004\u0018\u00010FH\u0096\u0002¢\u0006\u0004\bG\u0010HJ\u000f\u0010I\u001a\u00020\u001cH\u0016¢\u0006\u0004\bI\u0010*J\u0018\u0010J\u001a\u00020\u001c2\u0006\u00106\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\bJ\u0010KJ\u000f\u0010L\u001a\u00020\u0010H\u0016¢\u0006\u0004\bL\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u00038\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0004\u0010M\u001a\u0004\bN\u0010-R\"\u0010I\u001a\u00020\u001c8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bI\u0010O\u001a\u0004\bP\u0010*\"\u0004\bQ\u0010RR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010S\u001a\u0004\bT\u0010\u0012\"\u0004\bU\u0010VR\u0011\u0010W\u001a\u00020\u001c8G¢\u0006\u0006\u001a\u0004\bW\u0010*¨\u0006Y"}, d2 = {"Lokio/ByteString;", "Ljava/io/Serializable;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "data", "<init>", "([B)V", "Ljava/io/ObjectInputStream;", "in", BuildConfig.FLAVOR, "readObject", "(Ljava/io/ObjectInputStream;)V", "Ljava/io/ObjectOutputStream;", "out", "writeObject", "(Ljava/io/ObjectOutputStream;)V", BuildConfig.FLAVOR, "utf8", "()Ljava/lang/String;", "base64", "sha256", "()Lokio/ByteString;", "algorithm", "digest$okio", "(Ljava/lang/String;)Lokio/ByteString;", "digest", "hex", "toAsciiLowercase", BuildConfig.FLAVOR, "beginIndex", "endIndex", "substring", "(II)Lokio/ByteString;", "pos", BuildConfig.FLAVOR, "internalGet$okio", "(I)B", "internalGet", "index", "getByte", "get", "getSize$okio", "()I", "getSize", "internalArray$okio", "()[B", "internalArray", "Lokio/Buffer;", "buffer", "offset", "byteCount", "write$okio", "(Lokio/Buffer;II)V", "write", "other", "otherOffset", BuildConfig.FLAVOR, "rangeEquals", "(ILokio/ByteString;II)Z", "(I[BII)Z", "prefix", "startsWith", "(Lokio/ByteString;)Z", "suffix", "endsWith", "fromIndex", "indexOf", "(Lokio/ByteString;I)I", "([BI)I", "lastIndexOf", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "hashCode", "compareTo", "(Lokio/ByteString;)I", "toString", "[B", "getData$okio", "I", "getHashCode$okio", "setHashCode$okio", "(I)V", "Ljava/lang/String;", "getUtf8$okio", "setUtf8$okio", "(Ljava/lang/String;)V", "size", "Companion", "okio"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public class ByteString implements Serializable, Comparable<ByteString> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final ByteString EMPTY = new ByteString(new byte[0]);
    private static final long serialVersionUID = 1;
    private final byte[] data;
    private transient int hashCode;
    private transient String utf8;

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\u000b\u001a\u00020\b*\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\r\u001a\u00020\b*\u00020\fH\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0013\u001a\u00020\b*\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0014\u001a\u00020\b*\u00020\fH\u0007¢\u0006\u0004\b\u0014\u0010\u000eJ\u001b\u0010\u0018\u001a\u00020\b*\u00020\u00152\u0006\u0010\u0007\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lokio/ByteString$Companion;", BuildConfig.FLAVOR, "<init>", "()V", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "offset", "byteCount", "Lokio/ByteString;", "of", "([BII)Lokio/ByteString;", "toByteString", BuildConfig.FLAVOR, "encodeUtf8", "(Ljava/lang/String;)Lokio/ByteString;", "Ljava/nio/charset/Charset;", "charset", "encodeString", "(Ljava/lang/String;Ljava/nio/charset/Charset;)Lokio/ByteString;", "encode", "decodeHex", "Ljava/io/InputStream;", "read", "(Ljava/io/InputStream;I)Lokio/ByteString;", "readByteString", "EMPTY", "Lokio/ByteString;", BuildConfig.FLAVOR, "serialVersionUID", "J", "okio"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ ByteString of$default(Companion companion, byte[] bArr, int i5, int i6, int i7, Object obj) {
            if ((i7 & 1) != 0) {
                i5 = 0;
            }
            if ((i7 & 2) != 0) {
                i6 = SegmentedByteString.getDEFAULT__ByteString_size();
            }
            return companion.of(bArr, i5, i6);
        }

        public final ByteString decodeHex(String str) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            if (str.length() % 2 != 0) {
                throw new IllegalArgumentException(("Unexpected hex string: " + str).toString());
            }
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i5 = 0; i5 < length; i5++) {
                int i6 = i5 * 2;
                bArr[i5] = (byte) ((okio.internal.ByteString.access$decodeHexDigit(str.charAt(i6)) << 4) + okio.internal.ByteString.access$decodeHexDigit(str.charAt(i6 + 1)));
            }
            return new ByteString(bArr);
        }

        public final ByteString encodeString(String str, Charset charset) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            Intrinsics.checkNotNullParameter(charset, "charset");
            byte[] bytes = str.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            return new ByteString(bytes);
        }

        public final ByteString encodeUtf8(String str) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            ByteString byteString = new ByteString(_JvmPlatformKt.asUtf8ToByteArray(str));
            byteString.setUtf8$okio(str);
            return byteString;
        }

        public final ByteString of(byte[] bArr, int i5, int i6) {
            Intrinsics.checkNotNullParameter(bArr, "<this>");
            int resolveDefaultParameter = SegmentedByteString.resolveDefaultParameter(bArr, i6);
            SegmentedByteString.checkOffsetAndCount(bArr.length, i5, resolveDefaultParameter);
            return new ByteString(ArraysKt.copyOfRange(bArr, i5, resolveDefaultParameter + i5));
        }

        public final ByteString read(InputStream inputStream, int i5) {
            Intrinsics.checkNotNullParameter(inputStream, "<this>");
            if (i5 < 0) {
                throw new IllegalArgumentException(("byteCount < 0: " + i5).toString());
            }
            byte[] bArr = new byte[i5];
            int i6 = 0;
            while (i6 < i5) {
                int read = inputStream.read(bArr, i6, i5 - i6);
                if (read == -1) {
                    throw new EOFException();
                }
                i6 += read;
            }
            return new ByteString(bArr);
        }

        private Companion() {
        }
    }

    public ByteString(byte[] data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
    }

    public static final ByteString encodeUtf8(String str) {
        return INSTANCE.encodeUtf8(str);
    }

    public static /* synthetic */ int indexOf$default(ByteString byteString, ByteString byteString2, int i5, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
        }
        if ((i6 & 2) != 0) {
            i5 = 0;
        }
        return byteString.indexOf(byteString2, i5);
    }

    public static /* synthetic */ int lastIndexOf$default(ByteString byteString, ByteString byteString2, int i5, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
        }
        if ((i6 & 2) != 0) {
            i5 = SegmentedByteString.getDEFAULT__ByteString_size();
        }
        return byteString.lastIndexOf(byteString2, i5);
    }

    private final void readObject(ObjectInputStream in) {
        ByteString read = INSTANCE.read(in, in.readInt());
        Field declaredField = ByteString.class.getDeclaredField("data");
        declaredField.setAccessible(true);
        declaredField.set(this, read.data);
    }

    public static /* synthetic */ ByteString substring$default(ByteString byteString, int i5, int i6, int i7, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: substring");
        }
        if ((i7 & 1) != 0) {
            i5 = 0;
        }
        if ((i7 & 2) != 0) {
            i6 = SegmentedByteString.getDEFAULT__ByteString_size();
        }
        return byteString.substring(i5, i6);
    }

    private final void writeObject(ObjectOutputStream out) {
        out.writeInt(this.data.length);
        out.write(this.data);
    }

    public String base64() {
        return Base64.encodeBase64$default(getData(), null, 1, null);
    }

    public ByteString digest$okio(String algorithm) {
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        messageDigest.update(this.data, 0, size());
        byte[] digestBytes = messageDigest.digest();
        Intrinsics.checkNotNullExpressionValue(digestBytes, "digestBytes");
        return new ByteString(digestBytes);
    }

    public final boolean endsWith(ByteString suffix) {
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        return rangeEquals(size() - suffix.size(), suffix, 0, suffix.size());
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (other instanceof ByteString) {
            ByteString byteString = (ByteString) other;
            if (byteString.size() == getData().length && byteString.rangeEquals(0, getData(), 0, getData().length)) {
                return true;
            }
        }
        return false;
    }

    public final byte getByte(int index) {
        return internalGet$okio(index);
    }

    /* renamed from: getData$okio, reason: from getter */
    public final byte[] getData() {
        return this.data;
    }

    /* renamed from: getHashCode$okio, reason: from getter */
    public final int getHashCode() {
        return this.hashCode;
    }

    public int getSize$okio() {
        return getData().length;
    }

    /* renamed from: getUtf8$okio, reason: from getter */
    public final String getUtf8() {
        return this.utf8;
    }

    public int hashCode() {
        int hashCode = getHashCode();
        if (hashCode != 0) {
            return hashCode;
        }
        int hashCode2 = Arrays.hashCode(getData());
        setHashCode$okio(hashCode2);
        return hashCode2;
    }

    public String hex() {
        char[] cArr = new char[getData().length * 2];
        int i5 = 0;
        for (byte b5 : getData()) {
            int i6 = i5 + 1;
            cArr[i5] = okio.internal.ByteString.getHEX_DIGIT_CHARS()[(b5 >> 4) & 15];
            i5 += 2;
            cArr[i6] = okio.internal.ByteString.getHEX_DIGIT_CHARS()[b5 & 15];
        }
        return StringsKt.concatToString(cArr);
    }

    public final int indexOf(ByteString other, int fromIndex) {
        Intrinsics.checkNotNullParameter(other, "other");
        return indexOf(other.internalArray$okio(), fromIndex);
    }

    public byte[] internalArray$okio() {
        return getData();
    }

    public byte internalGet$okio(int pos) {
        return getData()[pos];
    }

    public final int lastIndexOf(ByteString other, int fromIndex) {
        Intrinsics.checkNotNullParameter(other, "other");
        return lastIndexOf(other.internalArray$okio(), fromIndex);
    }

    public boolean rangeEquals(int offset, ByteString other, int otherOffset, int byteCount) {
        Intrinsics.checkNotNullParameter(other, "other");
        return other.rangeEquals(otherOffset, getData(), offset, byteCount);
    }

    public final void setHashCode$okio(int i5) {
        this.hashCode = i5;
    }

    public final void setUtf8$okio(String str) {
        this.utf8 = str;
    }

    public final ByteString sha256() {
        return digest$okio(Constants.SHA256);
    }

    public final int size() {
        return getSize$okio();
    }

    public final boolean startsWith(ByteString prefix) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        return rangeEquals(0, prefix, 0, prefix.size());
    }

    public ByteString substring(int beginIndex, int endIndex) {
        int resolveDefaultParameter = SegmentedByteString.resolveDefaultParameter(this, endIndex);
        if (beginIndex < 0) {
            throw new IllegalArgumentException("beginIndex < 0");
        }
        if (resolveDefaultParameter <= getData().length) {
            if (resolveDefaultParameter - beginIndex >= 0) {
                return (beginIndex == 0 && resolveDefaultParameter == getData().length) ? this : new ByteString(ArraysKt.copyOfRange(getData(), beginIndex, resolveDefaultParameter));
            }
            throw new IllegalArgumentException("endIndex < beginIndex");
        }
        throw new IllegalArgumentException(("endIndex > length(" + getData().length + ')').toString());
    }

    public ByteString toAsciiLowercase() {
        for (int i5 = 0; i5 < getData().length; i5++) {
            byte b5 = getData()[i5];
            if (b5 >= 65 && b5 <= 90) {
                byte[] data = getData();
                byte[] copyOf = Arrays.copyOf(data, data.length);
                Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
                copyOf[i5] = (byte) (b5 + 32);
                for (int i6 = i5 + 1; i6 < copyOf.length; i6++) {
                    byte b6 = copyOf[i6];
                    if (b6 >= 65 && b6 <= 90) {
                        copyOf[i6] = (byte) (b6 + 32);
                    }
                }
                return new ByteString(copyOf);
            }
        }
        return this;
    }

    public String toString() {
        String str;
        if (getData().length == 0) {
            str = "[size=0]";
        } else {
            int access$codePointIndexToCharIndex = okio.internal.ByteString.access$codePointIndexToCharIndex(getData(), 64);
            if (access$codePointIndexToCharIndex != -1) {
                String utf8 = utf8();
                String substring = utf8.substring(0, access$codePointIndexToCharIndex);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                String replace$default = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(substring, "\\", "\\\\", false, 4, (Object) null), "\n", "\\n", false, 4, (Object) null), "\r", "\\r", false, 4, (Object) null);
                if (access$codePointIndexToCharIndex >= utf8.length()) {
                    return "[text=" + replace$default + ']';
                }
                return "[size=" + getData().length + " text=" + replace$default + "…]";
            }
            if (getData().length > 64) {
                StringBuilder sb = new StringBuilder();
                sb.append("[size=");
                sb.append(getData().length);
                sb.append(" hex=");
                int resolveDefaultParameter = SegmentedByteString.resolveDefaultParameter(this, 64);
                if (resolveDefaultParameter <= getData().length) {
                    if (resolveDefaultParameter < 0) {
                        throw new IllegalArgumentException("endIndex < beginIndex");
                    }
                    sb.append((resolveDefaultParameter == getData().length ? this : new ByteString(ArraysKt.copyOfRange(getData(), 0, resolveDefaultParameter))).hex());
                    sb.append("…]");
                    return sb.toString();
                }
                throw new IllegalArgumentException(("endIndex > length(" + getData().length + ')').toString());
            }
            str = "[hex=" + hex() + ']';
        }
        return str;
    }

    public String utf8() {
        String utf8 = getUtf8();
        if (utf8 != null) {
            return utf8;
        }
        String utf8String = _JvmPlatformKt.toUtf8String(internalArray$okio());
        setUtf8$okio(utf8String);
        return utf8String;
    }

    public void write$okio(Buffer buffer, int offset, int byteCount) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        okio.internal.ByteString.commonWrite(this, buffer, offset, byteCount);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0034, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:?, code lost:
    
        return 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0031, code lost:
    
        if (r0 < r1) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0028, code lost:
    
        if (r7 < r8) goto L9;
     */
    @Override // java.lang.Comparable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int compareTo(ByteString other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int size = size();
        int size2 = other.size();
        int min = Math.min(size, size2);
        for (int i5 = 0; i5 < min; i5++) {
            int i6 = getByte(i5) & 255;
            int i7 = other.getByte(i5) & 255;
            if (i6 == i7) {
            }
        }
        if (size == size2) {
            return 0;
        }
    }

    public int indexOf(byte[] other, int fromIndex) {
        Intrinsics.checkNotNullParameter(other, "other");
        int length = getData().length - other.length;
        int max = Math.max(fromIndex, 0);
        if (max <= length) {
            while (!SegmentedByteString.arrayRangeEquals(getData(), max, other, 0, other.length)) {
                if (max != length) {
                    max++;
                }
            }
            return max;
        }
        return -1;
    }

    public int lastIndexOf(byte[] other, int fromIndex) {
        Intrinsics.checkNotNullParameter(other, "other");
        for (int min = Math.min(SegmentedByteString.resolveDefaultParameter(this, fromIndex), getData().length - other.length); -1 < min; min--) {
            if (SegmentedByteString.arrayRangeEquals(getData(), min, other, 0, other.length)) {
                return min;
            }
        }
        return -1;
    }

    public boolean rangeEquals(int offset, byte[] other, int otherOffset, int byteCount) {
        Intrinsics.checkNotNullParameter(other, "other");
        return offset >= 0 && offset <= getData().length - byteCount && otherOffset >= 0 && otherOffset <= other.length - byteCount && SegmentedByteString.arrayRangeEquals(getData(), offset, other, otherOffset, byteCount);
    }
}
