package okio;

import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;
import kotlin.Deprecated;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u00012\u00020\u0002J\u000f\u0010\u0004\u001a\u00020\u0003H'¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H&¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0013H&¢\u0006\u0004\b\u0016\u0010\u0015J\u000f\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0017H&¢\u0006\u0004\b\u001a\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\tH&¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\tH&¢\u0006\u0004\b\u001d\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u001e\u0010\rJ\u0017\u0010 \u001a\u00020\u001f2\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b \u0010!J\u0017\u0010$\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\"H&¢\u0006\u0004\b$\u0010%J\u0017\u0010'\u001a\u00020&2\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b'\u0010(J\u001f\u0010*\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b*\u0010+J\u0017\u0010-\u001a\u00020\t2\u0006\u0010)\u001a\u00020,H&¢\u0006\u0004\b-\u0010.J\u0017\u00100\u001a\u00020/2\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020/H&¢\u0006\u0004\b2\u00103J\u0017\u00102\u001a\u00020/2\u0006\u00104\u001a\u00020\tH&¢\u0006\u0004\b2\u00101J\u0017\u00107\u001a\u00020/2\u0006\u00106\u001a\u000205H&¢\u0006\u0004\b7\u00108J'\u0010<\u001a\u00020\t2\u0006\u00109\u001a\u00020\u00102\u0006\u0010:\u001a\u00020\t2\u0006\u0010;\u001a\u00020\tH&¢\u0006\u0004\b<\u0010=J\u0017\u0010<\u001a\u00020\t2\u0006\u0010>\u001a\u00020\u001fH&¢\u0006\u0004\b<\u0010?J\u0017\u0010A\u001a\u00020\t2\u0006\u0010@\u001a\u00020\u001fH&¢\u0006\u0004\bA\u0010?J\u001f\u0010C\u001a\u00020\u00062\u0006\u0010B\u001a\u00020\t2\u0006\u0010>\u001a\u00020\u001fH&¢\u0006\u0004\bC\u0010DJ\u000f\u0010E\u001a\u00020\u0000H&¢\u0006\u0004\bE\u0010FJ\u000f\u0010H\u001a\u00020GH&¢\u0006\u0004\bH\u0010IR\u0014\u0010\u0004\u001a\u00020\u00038&X¦\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010\u0005\u0082\u0001\u0002\u0003Kø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006LÀ\u0006\u0001"}, d2 = {"Lokio/BufferedSource;", "Lokio/Source;", "Ljava/nio/channels/ReadableByteChannel;", "Lokio/Buffer;", "buffer", "()Lokio/Buffer;", BuildConfig.FLAVOR, "exhausted", "()Z", BuildConfig.FLAVOR, "byteCount", BuildConfig.FLAVOR, "require", "(J)V", "request", "(J)Z", BuildConfig.FLAVOR, "readByte", "()B", BuildConfig.FLAVOR, "readShort", "()S", "readShortLe", BuildConfig.FLAVOR, "readInt", "()I", "readIntLe", "readLongLe", "()J", "readHexadecimalUnsignedLong", "skip", "Lokio/ByteString;", "readByteString", "(J)Lokio/ByteString;", "Lokio/Options;", "options", "select", "(Lokio/Options;)I", BuildConfig.FLAVOR, "readByteArray", "(J)[B", "sink", "readFully", "(Lokio/Buffer;J)V", "Lokio/Sink;", "readAll", "(Lokio/Sink;)J", BuildConfig.FLAVOR, "readUtf8", "(J)Ljava/lang/String;", "readUtf8LineStrict", "()Ljava/lang/String;", "limit", "Ljava/nio/charset/Charset;", "charset", "readString", "(Ljava/nio/charset/Charset;)Ljava/lang/String;", "b", "fromIndex", "toIndex", "indexOf", "(BJJ)J", "bytes", "(Lokio/ByteString;)J", "targetBytes", "indexOfElement", "offset", "rangeEquals", "(JLokio/ByteString;)Z", "peek", "()Lokio/BufferedSource;", "Ljava/io/InputStream;", "inputStream", "()Ljava/io/InputStream;", "getBuffer", "Lokio/RealBufferedSource;", "okio"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface BufferedSource extends Source, ReadableByteChannel {
    @Deprecated
    Buffer buffer();

    boolean exhausted();

    Buffer getBuffer();

    long indexOf(byte b5, long fromIndex, long toIndex);

    long indexOf(ByteString bytes);

    long indexOfElement(ByteString targetBytes);

    InputStream inputStream();

    BufferedSource peek();

    boolean rangeEquals(long offset, ByteString bytes);

    long readAll(Sink sink);

    byte readByte();

    byte[] readByteArray(long byteCount);

    ByteString readByteString(long byteCount);

    void readFully(Buffer sink, long byteCount);

    long readHexadecimalUnsignedLong();

    int readInt();

    int readIntLe();

    long readLongLe();

    short readShort();

    short readShortLe();

    String readString(Charset charset);

    String readUtf8(long byteCount);

    String readUtf8LineStrict();

    String readUtf8LineStrict(long limit);

    boolean request(long byteCount);

    void require(long byteCount);

    int select(Options options);

    void skip(long byteCount);
}
