package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0014\u001a\u00020\u000eH\u0016J\b\u0010\u0015\u001a\u00020\u000eH\u0002J\b\u0010\u0016\u001a\u00020\u000eH\u0002J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0018H\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J \u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0018H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lokio/GzipSource;", "Lokio/Source;", "source", "(Lokio/Source;)V", "crc", "Ljava/util/zip/CRC32;", "inflater", "Ljava/util/zip/Inflater;", "inflaterSource", "Lokio/InflaterSource;", "section", BuildConfig.FLAVOR, "Lokio/RealBufferedSource;", "checkEqual", BuildConfig.FLAVOR, "name", BuildConfig.FLAVOR, "expected", BuildConfig.FLAVOR, "actual", "close", "consumeHeader", "consumeTrailer", "read", BuildConfig.FLAVOR, "sink", "Lokio/Buffer;", "byteCount", "timeout", "Lokio/Timeout;", "updateCrc", "buffer", "offset", "okio"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class GzipSource implements Source {
    private final CRC32 crc;
    private final Inflater inflater;
    private final InflaterSource inflaterSource;
    private byte section;
    private final buffer source;

    public GzipSource(Source source) {
        Intrinsics.checkNotNullParameter(source, "source");
        buffer bufferVar = new buffer(source);
        this.source = bufferVar;
        Inflater inflater = new Inflater(true);
        this.inflater = inflater;
        this.inflaterSource = new InflaterSource((BufferedSource) bufferVar, inflater);
        this.crc = new CRC32();
    }

    private final void checkEqual(String name, int expected, int actual) {
        if (actual == expected) {
            return;
        }
        String format = String.format("%s: actual 0x%08x != expected 0x%08x", Arrays.copyOf(new Object[]{name, Integer.valueOf(actual), Integer.valueOf(expected)}, 3));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        throw new IOException(format);
    }

    private final void consumeHeader() {
        this.source.require(10L);
        byte b5 = this.source.bufferField.getByte(3L);
        boolean z5 = ((b5 >> 1) & 1) == 1;
        if (z5) {
            updateCrc(this.source.bufferField, 0L, 10L);
        }
        checkEqual("ID1ID2", 8075, this.source.readShort());
        this.source.skip(8L);
        if (((b5 >> 2) & 1) == 1) {
            this.source.require(2L);
            if (z5) {
                updateCrc(this.source.bufferField, 0L, 2L);
            }
            long readShortLe = this.source.bufferField.readShortLe() & 65535;
            this.source.require(readShortLe);
            if (z5) {
                updateCrc(this.source.bufferField, 0L, readShortLe);
            }
            this.source.skip(readShortLe);
        }
        if (((b5 >> 3) & 1) == 1) {
            long indexOf = this.source.indexOf((byte) 0);
            if (indexOf == -1) {
                throw new EOFException();
            }
            if (z5) {
                updateCrc(this.source.bufferField, 0L, indexOf + 1);
            }
            this.source.skip(indexOf + 1);
        }
        if (((b5 >> 4) & 1) == 1) {
            long indexOf2 = this.source.indexOf((byte) 0);
            if (indexOf2 == -1) {
                throw new EOFException();
            }
            if (z5) {
                updateCrc(this.source.bufferField, 0L, indexOf2 + 1);
            }
            this.source.skip(indexOf2 + 1);
        }
        if (z5) {
            checkEqual("FHCRC", this.source.readShortLe(), (short) this.crc.getValue());
            this.crc.reset();
        }
    }

    private final void consumeTrailer() {
        checkEqual("CRC", this.source.readIntLe(), (int) this.crc.getValue());
        checkEqual("ISIZE", this.source.readIntLe(), (int) this.inflater.getBytesWritten());
    }

    private final void updateCrc(Buffer buffer, long offset, long byteCount) {
        Segment segment = buffer.head;
        Intrinsics.checkNotNull(segment);
        while (true) {
            int i5 = segment.limit;
            int i6 = segment.pos;
            if (offset < i5 - i6) {
                break;
            }
            offset -= i5 - i6;
            segment = segment.next;
            Intrinsics.checkNotNull(segment);
        }
        while (byteCount > 0) {
            int min = (int) Math.min(segment.limit - r6, byteCount);
            this.crc.update(segment.data, (int) (segment.pos + offset), min);
            byteCount -= min;
            segment = segment.next;
            Intrinsics.checkNotNull(segment);
            offset = 0;
        }
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.inflaterSource.close();
    }

    @Override // okio.Source
    public long read(Buffer sink, long byteCount) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (byteCount < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
        }
        if (byteCount == 0) {
            return 0L;
        }
        if (this.section == 0) {
            consumeHeader();
            this.section = (byte) 1;
        }
        if (this.section == 1) {
            long size = sink.getSize();
            long read = this.inflaterSource.read(sink, byteCount);
            if (read != -1) {
                updateCrc(sink, size, read);
                return read;
            }
            this.section = (byte) 2;
        }
        if (this.section == 2) {
            consumeTrailer();
            this.section = (byte) 3;
            if (!this.source.exhausted()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }

    @Override // okio.Source
    /* renamed from: timeout */
    public Timeout getTimeout() {
        return this.source.getTimeout();
    }
}
