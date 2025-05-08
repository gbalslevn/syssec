package com.google.protobuf;

import com.adjust.sdk.Constants;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
public abstract class Internal {
    private static final int DEFAULT_BUFFER_SIZE = 4096;
    public static final byte[] EMPTY_BYTE_ARRAY;
    public static final ByteBuffer EMPTY_BYTE_BUFFER;
    public static final CodedInputStream EMPTY_CODED_INPUT_STREAM;
    static final Charset US_ASCII = Charset.forName("US-ASCII");
    static final Charset UTF_8 = Charset.forName(Constants.ENCODING);
    static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");

    /* loaded from: classes2.dex */
    public interface EnumLite {
        int getNumber();
    }

    /* loaded from: classes2.dex */
    public interface EnumLiteMap<T extends EnumLite> {
    }

    /* loaded from: classes2.dex */
    public interface EnumVerifier {
    }

    /* loaded from: classes2.dex */
    public interface IntList extends ProtobufList<Integer> {
        void addInt(int i5);

        int getInt(int i5);

        @Override // 
        ProtobufList<Integer> mutableCopyWithCapacity(int i5);
    }

    /* loaded from: classes2.dex */
    public interface LongList extends ProtobufList<Long> {
    }

    /* loaded from: classes2.dex */
    public interface ProtobufList<E> extends List<E>, RandomAccess {
        boolean isModifiable();

        void makeImmutable();

        ProtobufList<E> mutableCopyWithCapacity(int i5);
    }

    static {
        byte[] bArr = new byte[0];
        EMPTY_BYTE_ARRAY = bArr;
        EMPTY_BYTE_BUFFER = ByteBuffer.wrap(bArr);
        EMPTY_CODED_INPUT_STREAM = CodedInputStream.newInstance(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T checkNotNull(T t5) {
        t5.getClass();
        return t5;
    }

    public static int hashBoolean(boolean z5) {
        return z5 ? 1231 : 1237;
    }

    public static int hashCode(byte[] bArr) {
        return hashCode(bArr, 0, bArr.length);
    }

    public static int hashLong(long j5) {
        return (int) (j5 ^ (j5 >>> 32));
    }

    public static boolean isValidUtf8(byte[] bArr) {
        return Utf8.isValidUtf8(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int partialHash(int i5, byte[] bArr, int i6, int i7) {
        for (int i8 = i6; i8 < i6 + i7; i8++) {
            i5 = (i5 * 31) + bArr[i8];
        }
        return i5;
    }

    public static String toStringUtf8(byte[] bArr) {
        return new String(bArr, UTF_8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T checkNotNull(T t5, String str) {
        if (t5 != null) {
            return t5;
        }
        throw new NullPointerException(str);
    }

    static int hashCode(byte[] bArr, int i5, int i6) {
        int partialHash = partialHash(i6, bArr, i5, i6);
        if (partialHash == 0) {
            return 1;
        }
        return partialHash;
    }
}
