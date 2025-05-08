package okio;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\n\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\"\u001a\u00020!2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\"\u0010#J\u0017\u0010\f\u001a\u00020\u001e2\u0006\u0010\t\u001a\u00020$H\u0016¢\u0006\u0004\b\f\u0010%J\u001f\u0010&\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b&\u0010'J\u0017\u0010)\u001a\u00020\n2\u0006\u0010\t\u001a\u00020(H\u0016¢\u0006\u0004\b)\u0010*J\u0017\u0010,\u001a\u00020+2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b,\u0010-J\u0017\u00100\u001a\u00020+2\u0006\u0010/\u001a\u00020.H\u0016¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020+H\u0016¢\u0006\u0004\b2\u00103J\u0017\u00102\u001a\u00020+2\u0006\u00104\u001a\u00020\nH\u0016¢\u0006\u0004\b2\u0010-J\u000f\u00106\u001a\u000205H\u0016¢\u0006\u0004\b6\u00107J\u000f\u00108\u001a\u000205H\u0016¢\u0006\u0004\b8\u00107J\u000f\u00109\u001a\u00020\u001eH\u0016¢\u0006\u0004\b9\u0010:J\u000f\u0010;\u001a\u00020\u001eH\u0016¢\u0006\u0004\b;\u0010:J\u000f\u0010<\u001a\u00020\nH\u0016¢\u0006\u0004\b<\u0010=J\u000f\u0010>\u001a\u00020\nH\u0016¢\u0006\u0004\b>\u0010=J\u0017\u0010?\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b?\u0010\u0013J\u0017\u0010A\u001a\u00020\n2\u0006\u0010@\u001a\u00020\u0016H\u0016¢\u0006\u0004\bA\u0010BJ'\u0010A\u001a\u00020\n2\u0006\u0010@\u001a\u00020\u00162\u0006\u0010C\u001a\u00020\n2\u0006\u0010D\u001a\u00020\nH\u0016¢\u0006\u0004\bA\u0010EJ\u0017\u0010A\u001a\u00020\n2\u0006\u0010F\u001a\u00020\u0019H\u0016¢\u0006\u0004\bA\u0010GJ\u001f\u0010A\u001a\u00020\n2\u0006\u0010F\u001a\u00020\u00192\u0006\u0010C\u001a\u00020\nH\u0016¢\u0006\u0004\bA\u0010HJ\u0017\u0010J\u001a\u00020\n2\u0006\u0010I\u001a\u00020\u0019H\u0016¢\u0006\u0004\bJ\u0010GJ\u001f\u0010J\u001a\u00020\n2\u0006\u0010I\u001a\u00020\u00192\u0006\u0010C\u001a\u00020\nH\u0016¢\u0006\u0004\bJ\u0010HJ\u001f\u0010L\u001a\u00020\u000e2\u0006\u0010K\u001a\u00020\n2\u0006\u0010F\u001a\u00020\u0019H\u0016¢\u0006\u0004\bL\u0010MJ/\u0010L\u001a\u00020\u000e2\u0006\u0010K\u001a\u00020\n2\u0006\u0010F\u001a\u00020\u00192\u0006\u0010N\u001a\u00020\u001e2\u0006\u0010\u000b\u001a\u00020\u001eH\u0016¢\u0006\u0004\bL\u0010OJ\u000f\u0010P\u001a\u00020\u0001H\u0016¢\u0006\u0004\bP\u0010QJ\u000f\u0010S\u001a\u00020RH\u0016¢\u0006\u0004\bS\u0010TJ\u000f\u0010U\u001a\u00020\u000eH\u0016¢\u0006\u0004\bU\u0010\u0010J\u000f\u0010V\u001a\u00020\u0011H\u0016¢\u0006\u0004\bV\u0010WJ\u000f\u0010Y\u001a\u00020XH\u0016¢\u0006\u0004\bY\u0010ZJ\u000f\u0010[\u001a\u00020+H\u0016¢\u0006\u0004\b[\u00103R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\\R\u0014\u0010]\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b]\u0010^R\u0016\u0010_\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b_\u0010`R\u001b\u0010\u0007\u001a\u00020\u00068Ö\u0002X\u0096\u0004¢\u0006\f\u0012\u0004\bb\u0010W\u001a\u0004\ba\u0010\b¨\u0006c"}, d2 = {"Lokio/RealBufferedSource;", "Lokio/BufferedSource;", "Lokio/Source;", "source", "<init>", "(Lokio/Source;)V", "Lokio/Buffer;", "buffer", "()Lokio/Buffer;", "sink", BuildConfig.FLAVOR, "byteCount", "read", "(Lokio/Buffer;J)J", BuildConfig.FLAVOR, "exhausted", "()Z", BuildConfig.FLAVOR, "require", "(J)V", "request", "(J)Z", BuildConfig.FLAVOR, "readByte", "()B", "Lokio/ByteString;", "readByteString", "(J)Lokio/ByteString;", "Lokio/Options;", "options", BuildConfig.FLAVOR, "select", "(Lokio/Options;)I", BuildConfig.FLAVOR, "readByteArray", "(J)[B", "Ljava/nio/ByteBuffer;", "(Ljava/nio/ByteBuffer;)I", "readFully", "(Lokio/Buffer;J)V", "Lokio/Sink;", "readAll", "(Lokio/Sink;)J", BuildConfig.FLAVOR, "readUtf8", "(J)Ljava/lang/String;", "Ljava/nio/charset/Charset;", "charset", "readString", "(Ljava/nio/charset/Charset;)Ljava/lang/String;", "readUtf8LineStrict", "()Ljava/lang/String;", "limit", BuildConfig.FLAVOR, "readShort", "()S", "readShortLe", "readInt", "()I", "readIntLe", "readLongLe", "()J", "readHexadecimalUnsignedLong", "skip", "b", "indexOf", "(B)J", "fromIndex", "toIndex", "(BJJ)J", "bytes", "(Lokio/ByteString;)J", "(Lokio/ByteString;J)J", "targetBytes", "indexOfElement", "offset", "rangeEquals", "(JLokio/ByteString;)Z", "bytesOffset", "(JLokio/ByteString;II)Z", "peek", "()Lokio/BufferedSource;", "Ljava/io/InputStream;", "inputStream", "()Ljava/io/InputStream;", "isOpen", "close", "()V", "Lokio/Timeout;", "timeout", "()Lokio/Timeout;", "toString", "Lokio/Source;", "bufferField", "Lokio/Buffer;", "closed", "Z", "getBuffer", "getBuffer$annotations", "okio"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* renamed from: okio.RealBufferedSource, reason: from toString */
/* loaded from: classes3.dex */
public final class buffer implements BufferedSource {
    public final Buffer bufferField;
    public boolean closed;
    public final Source source;

    public buffer(Source source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.source = source;
        this.bufferField = new Buffer();
    }

    @Override // okio.BufferedSource
    /* renamed from: buffer, reason: from getter */
    public Buffer getBufferField() {
        return this.bufferField;
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.closed) {
            return;
        }
        this.closed = true;
        this.source.close();
        this.bufferField.clear();
    }

    @Override // okio.BufferedSource
    public boolean exhausted() {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        return this.bufferField.exhausted() && this.source.read(this.bufferField, 8192L) == -1;
    }

    @Override // okio.BufferedSource, okio.BufferedSink
    /* renamed from: getBuffer */
    public Buffer getBufferField() {
        return this.bufferField;
    }

    public long indexOf(byte b5) {
        return indexOf(b5, 0L, Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public long indexOfElement(ByteString targetBytes) {
        Intrinsics.checkNotNullParameter(targetBytes, "targetBytes");
        return indexOfElement(targetBytes, 0L);
    }

    @Override // okio.BufferedSource
    public InputStream inputStream() {
        return new InputStream() { // from class: okio.RealBufferedSource$inputStream$1
            @Override // java.io.InputStream
            public int available() {
                buffer bufferVar = buffer.this;
                if (bufferVar.closed) {
                    throw new IOException("closed");
                }
                return (int) Math.min(bufferVar.bufferField.getSize(), Integer.MAX_VALUE);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                buffer.this.close();
            }

            @Override // java.io.InputStream
            public int read() {
                buffer bufferVar = buffer.this;
                if (!bufferVar.closed) {
                    if (bufferVar.bufferField.getSize() == 0) {
                        buffer bufferVar2 = buffer.this;
                        if (bufferVar2.source.read(bufferVar2.bufferField, 8192L) == -1) {
                            return -1;
                        }
                    }
                    return buffer.this.bufferField.readByte() & 255;
                }
                throw new IOException("closed");
            }

            public String toString() {
                return buffer.this + ".inputStream()";
            }

            @Override // java.io.InputStream
            public int read(byte[] data, int offset, int byteCount) {
                Intrinsics.checkNotNullParameter(data, "data");
                if (!buffer.this.closed) {
                    SegmentedByteString.checkOffsetAndCount(data.length, offset, byteCount);
                    if (buffer.this.bufferField.getSize() == 0) {
                        buffer bufferVar = buffer.this;
                        if (bufferVar.source.read(bufferVar.bufferField, 8192L) == -1) {
                            return -1;
                        }
                    }
                    return buffer.this.bufferField.read(data, offset, byteCount);
                }
                throw new IOException("closed");
            }
        };
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.closed;
    }

    @Override // okio.BufferedSource
    public BufferedSource peek() {
        return Okio.buffer(new PeekSource(this));
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long offset, ByteString bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        return rangeEquals(offset, bytes, 0, bytes.size());
    }

    @Override // okio.Source
    public long read(Buffer sink, long byteCount) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (byteCount >= 0) {
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            if (this.bufferField.getSize() == 0 && this.source.read(this.bufferField, 8192L) == -1) {
                return -1L;
            }
            return this.bufferField.read(sink, Math.min(byteCount, this.bufferField.getSize()));
        }
        throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
    }

    @Override // okio.BufferedSource
    public long readAll(Sink sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        long j5 = 0;
        while (this.source.read(this.bufferField, 8192L) != -1) {
            long completeSegmentByteCount = this.bufferField.completeSegmentByteCount();
            if (completeSegmentByteCount > 0) {
                j5 += completeSegmentByteCount;
                sink.write(this.bufferField, completeSegmentByteCount);
            }
        }
        if (this.bufferField.getSize() <= 0) {
            return j5;
        }
        long size = j5 + this.bufferField.getSize();
        Buffer buffer = this.bufferField;
        sink.write(buffer, buffer.getSize());
        return size;
    }

    @Override // okio.BufferedSource
    public byte readByte() {
        require(1L);
        return this.bufferField.readByte();
    }

    @Override // okio.BufferedSource
    public byte[] readByteArray(long byteCount) {
        require(byteCount);
        return this.bufferField.readByteArray(byteCount);
    }

    @Override // okio.BufferedSource
    public ByteString readByteString(long byteCount) {
        require(byteCount);
        return this.bufferField.readByteString(byteCount);
    }

    @Override // okio.BufferedSource
    public void readFully(Buffer sink, long byteCount) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        try {
            require(byteCount);
            this.bufferField.readFully(sink, byteCount);
        } catch (EOFException e5) {
            sink.writeAll(this.bufferField);
            throw e5;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0031, code lost:
    
        if (r0 == 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0034, code lost:
    
        r1 = new java.lang.StringBuilder();
        r1.append("Expected leading [0-9a-fA-F] character but was 0x");
        r2 = java.lang.Integer.toString(r2, kotlin.text.CharsKt.checkRadix(kotlin.text.CharsKt.checkRadix(16)));
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, "toString(this, checkRadix(radix))");
        r1.append(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005d, code lost:
    
        throw new java.lang.NumberFormatException(r1.toString());
     */
    @Override // okio.BufferedSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long readHexadecimalUnsignedLong() {
        require(1L);
        int i5 = 0;
        while (true) {
            int i6 = i5 + 1;
            if (!request(i6)) {
                break;
            }
            byte b5 = this.bufferField.getByte(i5);
            if ((b5 < 48 || b5 > 57) && ((b5 < 97 || b5 > 102) && (b5 < 65 || b5 > 70))) {
                break;
            }
            i5 = i6;
        }
        return this.bufferField.readHexadecimalUnsignedLong();
    }

    @Override // okio.BufferedSource
    public int readInt() {
        require(4L);
        return this.bufferField.readInt();
    }

    @Override // okio.BufferedSource
    public int readIntLe() {
        require(4L);
        return this.bufferField.readIntLe();
    }

    @Override // okio.BufferedSource
    public long readLongLe() {
        require(8L);
        return this.bufferField.readLongLe();
    }

    @Override // okio.BufferedSource
    public short readShort() {
        require(2L);
        return this.bufferField.readShort();
    }

    @Override // okio.BufferedSource
    public short readShortLe() {
        require(2L);
        return this.bufferField.readShortLe();
    }

    @Override // okio.BufferedSource
    public String readString(Charset charset) {
        Intrinsics.checkNotNullParameter(charset, "charset");
        this.bufferField.writeAll(this.source);
        return this.bufferField.readString(charset);
    }

    @Override // okio.BufferedSource
    public String readUtf8(long byteCount) {
        require(byteCount);
        return this.bufferField.readUtf8(byteCount);
    }

    @Override // okio.BufferedSource
    public String readUtf8LineStrict() {
        return readUtf8LineStrict(Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public boolean request(long byteCount) {
        if (byteCount < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
        }
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        while (this.bufferField.getSize() < byteCount) {
            if (this.source.read(this.bufferField, 8192L) == -1) {
                return false;
            }
        }
        return true;
    }

    @Override // okio.BufferedSource
    public void require(long byteCount) {
        if (!request(byteCount)) {
            throw new EOFException();
        }
    }

    @Override // okio.BufferedSource
    public int select(Options options) {
        Intrinsics.checkNotNullParameter(options, "options");
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        while (true) {
            int selectPrefix = okio.internal.Buffer.selectPrefix(this.bufferField, options, true);
            if (selectPrefix != -2) {
                if (selectPrefix != -1) {
                    this.bufferField.skip(options.getByteStrings()[selectPrefix].size());
                    return selectPrefix;
                }
            } else if (this.source.read(this.bufferField, 8192L) == -1) {
                break;
            }
        }
        return -1;
    }

    @Override // okio.BufferedSource
    public void skip(long byteCount) {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        while (byteCount > 0) {
            if (this.bufferField.getSize() == 0 && this.source.read(this.bufferField, 8192L) == -1) {
                throw new EOFException();
            }
            long min = Math.min(byteCount, this.bufferField.getSize());
            this.bufferField.skip(min);
            byteCount -= min;
        }
    }

    @Override // okio.Source
    /* renamed from: timeout */
    public Timeout getTimeout() {
        return this.source.getTimeout();
    }

    public String toString() {
        return "buffer(" + this.source + ')';
    }

    @Override // okio.BufferedSource
    public long indexOf(ByteString bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        return indexOf(bytes, 0L);
    }

    public long indexOfElement(ByteString targetBytes, long fromIndex) {
        Intrinsics.checkNotNullParameter(targetBytes, "targetBytes");
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        while (true) {
            long indexOfElement = this.bufferField.indexOfElement(targetBytes, fromIndex);
            if (indexOfElement != -1) {
                return indexOfElement;
            }
            long size = this.bufferField.getSize();
            if (this.source.read(this.bufferField, 8192L) == -1) {
                return -1L;
            }
            fromIndex = Math.max(fromIndex, size);
        }
    }

    @Override // okio.BufferedSource
    public String readUtf8LineStrict(long limit) {
        if (limit >= 0) {
            long j5 = limit == Long.MAX_VALUE ? Long.MAX_VALUE : limit + 1;
            long indexOf = indexOf((byte) 10, 0L, j5);
            if (indexOf != -1) {
                return okio.internal.Buffer.readUtf8Line(this.bufferField, indexOf);
            }
            if (j5 < Long.MAX_VALUE && request(j5) && this.bufferField.getByte(j5 - 1) == 13 && request(1 + j5) && this.bufferField.getByte(j5) == 10) {
                return okio.internal.Buffer.readUtf8Line(this.bufferField, j5);
            }
            Buffer buffer = new Buffer();
            Buffer buffer2 = this.bufferField;
            buffer2.copyTo(buffer, 0L, Math.min(32, buffer2.getSize()));
            throw new EOFException("\\n not found: limit=" + Math.min(this.bufferField.getSize(), limit) + " content=" + buffer.readByteString().hex() + (char) 8230);
        }
        throw new IllegalArgumentException(("limit < 0: " + limit).toString());
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b5, long fromIndex, long toIndex) {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        if (0 > fromIndex || fromIndex > toIndex) {
            throw new IllegalArgumentException(("fromIndex=" + fromIndex + " toIndex=" + toIndex).toString());
        }
        while (fromIndex < toIndex) {
            long indexOf = this.bufferField.indexOf(b5, fromIndex, toIndex);
            if (indexOf != -1) {
                return indexOf;
            }
            long size = this.bufferField.getSize();
            if (size >= toIndex || this.source.read(this.bufferField, 8192L) == -1) {
                return -1L;
            }
            fromIndex = Math.max(fromIndex, size);
        }
        return -1L;
    }

    public boolean rangeEquals(long offset, ByteString bytes, int bytesOffset, int byteCount) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        if (!this.closed) {
            if (offset < 0 || bytesOffset < 0 || byteCount < 0 || bytes.size() - bytesOffset < byteCount) {
                return false;
            }
            for (int i5 = 0; i5 < byteCount; i5++) {
                long j5 = i5 + offset;
                if (!request(1 + j5) || this.bufferField.getByte(j5) != bytes.getByte(bytesOffset + i5)) {
                    return false;
                }
            }
            return true;
        }
        throw new IllegalStateException("closed");
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (this.bufferField.getSize() == 0 && this.source.read(this.bufferField, 8192L) == -1) {
            return -1;
        }
        return this.bufferField.read(sink);
    }

    public long indexOf(ByteString bytes, long fromIndex) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        while (true) {
            long indexOf = this.bufferField.indexOf(bytes, fromIndex);
            if (indexOf != -1) {
                return indexOf;
            }
            long size = this.bufferField.getSize();
            if (this.source.read(this.bufferField, 8192L) == -1) {
                return -1L;
            }
            fromIndex = Math.max(fromIndex, (size - bytes.size()) + 1);
        }
    }
}
