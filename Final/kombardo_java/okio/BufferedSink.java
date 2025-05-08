package okio;

import java.io.OutputStream;
import java.nio.channels.WritableByteChannel;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u00012\u00020\u0002J\u0017\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0005\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\u0005\u0010\tJ'\u0010\u0005\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH&¢\u0006\u0004\b\u0005\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\nH&¢\u0006\u0004\b\u0010\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\nH&¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\nH&¢\u0006\u0004\b\u0019\u0010\u0017J\u0017\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\nH&¢\u0006\u0004\b\u001b\u0010\u0017J\u0017\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001cH&¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001cH&¢\u0006\u0004\b \u0010\u001fJ\u000f\u0010\"\u001a\u00020!H&¢\u0006\u0004\b\"\u0010#J\u000f\u0010%\u001a\u00020$H&¢\u0006\u0004\b%\u0010&R\u0014\u0010*\u001a\u00020'8&X¦\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)\u0082\u0001\u0002'+ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006,À\u0006\u0001"}, d2 = {"Lokio/BufferedSink;", "Lokio/Sink;", "Ljava/nio/channels/WritableByteChannel;", "Lokio/ByteString;", "byteString", "write", "(Lokio/ByteString;)Lokio/BufferedSink;", BuildConfig.FLAVOR, "source", "([B)Lokio/BufferedSink;", BuildConfig.FLAVOR, "offset", "byteCount", "([BII)Lokio/BufferedSink;", BuildConfig.FLAVOR, "string", "writeUtf8", "(Ljava/lang/String;)Lokio/BufferedSink;", "beginIndex", "endIndex", "(Ljava/lang/String;II)Lokio/BufferedSink;", "b", "writeByte", "(I)Lokio/BufferedSink;", "s", "writeShort", "i", "writeInt", BuildConfig.FLAVOR, "v", "writeDecimalLong", "(J)Lokio/BufferedSink;", "writeHexadecimalUnsignedLong", BuildConfig.FLAVOR, "flush", "()V", "Ljava/io/OutputStream;", "outputStream", "()Ljava/io/OutputStream;", "Lokio/Buffer;", "getBuffer", "()Lokio/Buffer;", "buffer", "Lokio/RealBufferedSink;", "okio"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface BufferedSink extends Sink, WritableByteChannel {
    @Override // okio.Sink, java.io.Flushable
    void flush();

    Buffer getBuffer();

    OutputStream outputStream();

    BufferedSink write(ByteString byteString);

    BufferedSink write(byte[] source);

    BufferedSink write(byte[] source, int offset, int byteCount);

    BufferedSink writeByte(int b5);

    BufferedSink writeDecimalLong(long v5);

    BufferedSink writeHexadecimalUnsignedLong(long v5);

    BufferedSink writeInt(int i5);

    BufferedSink writeShort(int s5);

    BufferedSink writeUtf8(String string);

    BufferedSink writeUtf8(String string, int beginIndex, int endIndex);
}
