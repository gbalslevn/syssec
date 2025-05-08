package okhttp3.internal.http2;

import com.sdk.growthbook.utils.Constants;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import okhttp3.internal.Util;
import okio.AsyncTimeout;
import okio.Buffer;
import okio.BufferedSource;
import okio.Sink;
import okio.Source;
import okio.Timeout;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u0000 i2\u00020\u0001:\u0004ijklB3\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\t¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0018\u001a\u00020\u0015¢\u0006\u0004\b\u0018\u0010\u0017J\r\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010 \u001a\u00020\u001d2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b \u0010!J\u001d\u0010%\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u0002¢\u0006\u0004\b%\u0010&J\u001d\u0010'\u001a\u00020\u001d2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b'\u0010(J\u0015\u0010)\u001a\u00020\u001d2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b)\u0010!J\u000f\u0010,\u001a\u00020\u001dH\u0000¢\u0006\u0004\b*\u0010+J\u0015\u0010/\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020-¢\u0006\u0004\b/\u00100J\u000f\u00102\u001a\u00020\u001dH\u0000¢\u0006\u0004\b1\u0010+J\u000f\u00104\u001a\u00020\u001dH\u0000¢\u0006\u0004\b3\u0010+R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u00105\u001a\u0004\b6\u00107R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u00108\u001a\u0004\b9\u0010:R*\u0010<\u001a\u00020-2\u0006\u0010;\u001a\u00020-8\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u00100R*\u0010A\u001a\u00020-2\u0006\u0010;\u001a\u00020-8\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\bA\u0010=\u001a\u0004\bB\u0010?\"\u0004\bC\u00100R*\u0010D\u001a\u00020-2\u0006\u0010;\u001a\u00020-8\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\bD\u0010=\u001a\u0004\bE\u0010?\"\u0004\bF\u00100R*\u0010G\u001a\u00020-2\u0006\u0010;\u001a\u00020-8\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\bG\u0010=\u001a\u0004\bH\u0010?\"\u0004\bI\u00100R\u001a\u0010K\u001a\b\u0012\u0004\u0012\u00020\t0J8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010M\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u001e\u0010#\u001a\u00060OR\u00020\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\b#\u0010P\u001a\u0004\bQ\u0010RR\u001e\u0010T\u001a\u00060SR\u00020\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\bT\u0010U\u001a\u0004\bV\u0010WR\u001e\u0010\u0016\u001a\u00060XR\u00020\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0016\u0010Y\u001a\u0004\bZ\u0010[R\u001e\u0010\u0018\u001a\u00060XR\u00020\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0018\u0010Y\u001a\u0004\b\\\u0010[R$\u0010\u000e\u001a\u0004\u0018\u00010\r8@@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010]\u001a\u0004\b^\u0010_\"\u0004\b`\u0010!R$\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010a\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR\u0011\u0010f\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\bf\u0010gR\u0011\u0010h\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\bh\u0010g¨\u0006m"}, d2 = {"Lokhttp3/internal/http2/Http2Stream;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, "Lokhttp3/internal/http2/Http2Connection;", "connection", BuildConfig.FLAVOR, "outFinished", "inFinished", "Lokhttp3/Headers;", "headers", "<init>", "(ILokhttp3/internal/http2/Http2Connection;ZZLokhttp3/Headers;)V", "Lokhttp3/internal/http2/ErrorCode;", "errorCode", "Ljava/io/IOException;", "errorException", "closeInternal", "(Lokhttp3/internal/http2/ErrorCode;Ljava/io/IOException;)Z", "takeHeaders", "()Lokhttp3/Headers;", "Lokio/Timeout;", "readTimeout", "()Lokio/Timeout;", "writeTimeout", "Lokio/Sink;", "getSink", "()Lokio/Sink;", "rstStatusCode", BuildConfig.FLAVOR, "close", "(Lokhttp3/internal/http2/ErrorCode;Ljava/io/IOException;)V", "closeLater", "(Lokhttp3/internal/http2/ErrorCode;)V", "Lokio/BufferedSource;", "source", "length", "receiveData", "(Lokio/BufferedSource;I)V", "receiveHeaders", "(Lokhttp3/Headers;Z)V", "receiveRstStream", "cancelStreamIfNecessary$okhttp", "()V", "cancelStreamIfNecessary", BuildConfig.FLAVOR, "delta", "addBytesToWriteWindow", "(J)V", "checkOutNotClosed$okhttp", "checkOutNotClosed", "waitForIo$okhttp", "waitForIo", "I", "getId", "()I", "Lokhttp3/internal/http2/Http2Connection;", "getConnection", "()Lokhttp3/internal/http2/Http2Connection;", "<set-?>", "readBytesTotal", "J", "getReadBytesTotal", "()J", "setReadBytesTotal$okhttp", "readBytesAcknowledged", "getReadBytesAcknowledged", "setReadBytesAcknowledged$okhttp", "writeBytesTotal", "getWriteBytesTotal", "setWriteBytesTotal$okhttp", "writeBytesMaximum", "getWriteBytesMaximum", "setWriteBytesMaximum$okhttp", "Ljava/util/ArrayDeque;", "headersQueue", "Ljava/util/ArrayDeque;", "hasResponseHeaders", "Z", "Lokhttp3/internal/http2/Http2Stream$FramingSource;", "Lokhttp3/internal/http2/Http2Stream$FramingSource;", "getSource$okhttp", "()Lokhttp3/internal/http2/Http2Stream$FramingSource;", "Lokhttp3/internal/http2/Http2Stream$FramingSink;", "sink", "Lokhttp3/internal/http2/Http2Stream$FramingSink;", "getSink$okhttp", "()Lokhttp3/internal/http2/Http2Stream$FramingSink;", "Lokhttp3/internal/http2/Http2Stream$StreamTimeout;", "Lokhttp3/internal/http2/Http2Stream$StreamTimeout;", "getReadTimeout$okhttp", "()Lokhttp3/internal/http2/Http2Stream$StreamTimeout;", "getWriteTimeout$okhttp", "Lokhttp3/internal/http2/ErrorCode;", "getErrorCode$okhttp", "()Lokhttp3/internal/http2/ErrorCode;", "setErrorCode$okhttp", "Ljava/io/IOException;", "getErrorException$okhttp", "()Ljava/io/IOException;", "setErrorException$okhttp", "(Ljava/io/IOException;)V", "isOpen", "()Z", "isLocallyInitiated", "Companion", "FramingSink", "FramingSource", "StreamTimeout", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Http2Stream {
    private final Http2Connection connection;
    private ErrorCode errorCode;
    private IOException errorException;
    private boolean hasResponseHeaders;
    private final ArrayDeque<Headers> headersQueue;
    private final int id;
    private long readBytesAcknowledged;
    private long readBytesTotal;
    private final StreamTimeout readTimeout;
    private final FramingSink sink;
    private final FramingSource source;
    private long writeBytesMaximum;
    private long writeBytesTotal;
    private final StreamTimeout writeTimeout;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0015\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\tR\u0014\u0010\u001a\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR$\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010#\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0016\u001a\u0004\b$\u0010\u0018\"\u0004\b%\u0010\t¨\u0006&"}, d2 = {"Lokhttp3/internal/http2/Http2Stream$FramingSink;", "Lokio/Sink;", BuildConfig.FLAVOR, "finished", "<init>", "(Lokhttp3/internal/http2/Http2Stream;Z)V", "outFinishedOnLastFrame", BuildConfig.FLAVOR, "emitFrame", "(Z)V", "Lokio/Buffer;", "source", BuildConfig.FLAVOR, "byteCount", "write", "(Lokio/Buffer;J)V", "flush", "()V", "Lokio/Timeout;", "timeout", "()Lokio/Timeout;", "close", "Z", "getFinished", "()Z", "setFinished", "sendBuffer", "Lokio/Buffer;", "Lokhttp3/Headers;", "trailers", "Lokhttp3/Headers;", "getTrailers", "()Lokhttp3/Headers;", "setTrailers", "(Lokhttp3/Headers;)V", "closed", "getClosed", "setClosed", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public final class FramingSink implements Sink {
        private boolean closed;
        private boolean finished;
        private final Buffer sendBuffer;
        final /* synthetic */ Http2Stream this$0;
        private Headers trailers;

        public FramingSink(Http2Stream this$0, boolean z5) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this.this$0 = this$0;
            this.finished = z5;
            this.sendBuffer = new Buffer();
        }

        private final void emitFrame(boolean outFinishedOnLastFrame) {
            long min;
            boolean z5;
            Http2Stream http2Stream = this.this$0;
            synchronized (http2Stream) {
                try {
                    http2Stream.getWriteTimeout().enter();
                    while (http2Stream.getWriteBytesTotal() >= http2Stream.getWriteBytesMaximum() && !getFinished() && !getClosed() && http2Stream.getErrorCode$okhttp() == null) {
                        try {
                            http2Stream.waitForIo$okhttp();
                        } finally {
                            http2Stream.getWriteTimeout().exitAndThrowIfTimedOut();
                        }
                    }
                    http2Stream.getWriteTimeout().exitAndThrowIfTimedOut();
                    http2Stream.checkOutNotClosed$okhttp();
                    min = Math.min(http2Stream.getWriteBytesMaximum() - http2Stream.getWriteBytesTotal(), this.sendBuffer.getSize());
                    http2Stream.setWriteBytesTotal$okhttp(http2Stream.getWriteBytesTotal() + min);
                    z5 = outFinishedOnLastFrame && min == this.sendBuffer.getSize();
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    throw th;
                }
            }
            this.this$0.getWriteTimeout().enter();
            try {
                this.this$0.getConnection().writeData(this.this$0.getId(), z5, this.sendBuffer, min);
            } finally {
                http2Stream = this.this$0;
            }
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            Http2Stream http2Stream = this.this$0;
            if (Util.assertionsEnabled && Thread.holdsLock(http2Stream)) {
                throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + http2Stream);
            }
            Http2Stream http2Stream2 = this.this$0;
            synchronized (http2Stream2) {
                if (getClosed()) {
                    return;
                }
                boolean z5 = http2Stream2.getErrorCode$okhttp() == null;
                Unit unit = Unit.INSTANCE;
                if (!this.this$0.getSink().finished) {
                    boolean z6 = this.sendBuffer.getSize() > 0;
                    if (this.trailers != null) {
                        while (this.sendBuffer.getSize() > 0) {
                            emitFrame(false);
                        }
                        Http2Connection connection = this.this$0.getConnection();
                        int id = this.this$0.getId();
                        Headers headers = this.trailers;
                        Intrinsics.checkNotNull(headers);
                        connection.writeHeaders$okhttp(id, z5, Util.toHeaderList(headers));
                    } else if (z6) {
                        while (this.sendBuffer.getSize() > 0) {
                            emitFrame(true);
                        }
                    } else if (z5) {
                        this.this$0.getConnection().writeData(this.this$0.getId(), true, null, 0L);
                    }
                }
                synchronized (this.this$0) {
                    setClosed(true);
                    Unit unit2 = Unit.INSTANCE;
                }
                this.this$0.getConnection().flush();
                this.this$0.cancelStreamIfNecessary$okhttp();
            }
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() {
            Http2Stream http2Stream = this.this$0;
            if (Util.assertionsEnabled && Thread.holdsLock(http2Stream)) {
                throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + http2Stream);
            }
            Http2Stream http2Stream2 = this.this$0;
            synchronized (http2Stream2) {
                http2Stream2.checkOutNotClosed$okhttp();
                Unit unit = Unit.INSTANCE;
            }
            while (this.sendBuffer.getSize() > 0) {
                emitFrame(false);
                this.this$0.getConnection().flush();
            }
        }

        public final boolean getClosed() {
            return this.closed;
        }

        public final boolean getFinished() {
            return this.finished;
        }

        public final void setClosed(boolean z5) {
            this.closed = z5;
        }

        @Override // okio.Sink
        /* renamed from: timeout */
        public Timeout getTimeout() {
            return this.this$0.getWriteTimeout();
        }

        @Override // okio.Sink
        public void write(Buffer source, long byteCount) {
            Intrinsics.checkNotNullParameter(source, "source");
            Http2Stream http2Stream = this.this$0;
            if (!Util.assertionsEnabled || !Thread.holdsLock(http2Stream)) {
                this.sendBuffer.write(source, byteCount);
                while (this.sendBuffer.getSize() >= 16384) {
                    emitFrame(false);
                }
            } else {
                throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + http2Stream);
            }
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u000fJ\u001f\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001aR\"\u0010\u0005\u001a\u00020\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0017\u0010 \u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0017\u0010$\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b$\u0010!\u001a\u0004\b%\u0010#R$\u0010'\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u0010-\u001a\u00020\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b-\u0010\u001b\u001a\u0004\b.\u0010\u001d\"\u0004\b/\u0010\u001f¨\u00060"}, d2 = {"Lokhttp3/internal/http2/Http2Stream$FramingSource;", "Lokio/Source;", BuildConfig.FLAVOR, "maxByteCount", BuildConfig.FLAVOR, "finished", "<init>", "(Lokhttp3/internal/http2/Http2Stream;JZ)V", "read", BuildConfig.FLAVOR, "updateConnectionFlowControl", "(J)V", "Lokio/Buffer;", "sink", "byteCount", "(Lokio/Buffer;J)J", "Lokio/BufferedSource;", "source", "receive$okhttp", "(Lokio/BufferedSource;J)V", "receive", "Lokio/Timeout;", "timeout", "()Lokio/Timeout;", "close", "()V", "J", "Z", "getFinished$okhttp", "()Z", "setFinished$okhttp", "(Z)V", "receiveBuffer", "Lokio/Buffer;", "getReceiveBuffer", "()Lokio/Buffer;", "readBuffer", "getReadBuffer", "Lokhttp3/Headers;", "trailers", "Lokhttp3/Headers;", "getTrailers", "()Lokhttp3/Headers;", "setTrailers", "(Lokhttp3/Headers;)V", "closed", "getClosed$okhttp", "setClosed$okhttp", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public final class FramingSource implements Source {
        private boolean closed;
        private boolean finished;
        private final long maxByteCount;
        private final Buffer readBuffer;
        private final Buffer receiveBuffer;
        final /* synthetic */ Http2Stream this$0;
        private Headers trailers;

        public FramingSource(Http2Stream this$0, long j5, boolean z5) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this.this$0 = this$0;
            this.maxByteCount = j5;
            this.finished = z5;
            this.receiveBuffer = new Buffer();
            this.readBuffer = new Buffer();
        }

        private final void updateConnectionFlowControl(long read) {
            Http2Stream http2Stream = this.this$0;
            if (!Util.assertionsEnabled || !Thread.holdsLock(http2Stream)) {
                this.this$0.getConnection().updateConnectionFlowControl$okhttp(read);
                return;
            }
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + http2Stream);
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            long size;
            Http2Stream http2Stream = this.this$0;
            synchronized (http2Stream) {
                setClosed$okhttp(true);
                size = getReadBuffer().getSize();
                getReadBuffer().clear();
                http2Stream.notifyAll();
                Unit unit = Unit.INSTANCE;
            }
            if (size > 0) {
                updateConnectionFlowControl(size);
            }
            this.this$0.cancelStreamIfNecessary$okhttp();
        }

        /* renamed from: getClosed$okhttp, reason: from getter */
        public final boolean getClosed() {
            return this.closed;
        }

        /* renamed from: getFinished$okhttp, reason: from getter */
        public final boolean getFinished() {
            return this.finished;
        }

        public final Buffer getReadBuffer() {
            return this.readBuffer;
        }

        public final Buffer getReceiveBuffer() {
            return this.receiveBuffer;
        }

        /* JADX WARN: Code restructure failed: missing block: B:45:0x00d3, code lost:
        
            throw new java.io.IOException("stream closed");
         */
        @Override // okio.Source
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public long read(Buffer sink, long byteCount) {
            IOException iOException;
            boolean z5;
            long j5;
            Intrinsics.checkNotNullParameter(sink, "sink");
            long j6 = 0;
            if (byteCount < 0) {
                throw new IllegalArgumentException(Intrinsics.stringPlus("byteCount < 0: ", Long.valueOf(byteCount)).toString());
            }
            while (true) {
                Http2Stream http2Stream = this.this$0;
                synchronized (http2Stream) {
                    http2Stream.getReadTimeout().enter();
                    try {
                        if (http2Stream.getErrorCode$okhttp() == null || getFinished()) {
                            iOException = null;
                        } else {
                            iOException = http2Stream.getErrorException();
                            if (iOException == null) {
                                ErrorCode errorCode$okhttp = http2Stream.getErrorCode$okhttp();
                                Intrinsics.checkNotNull(errorCode$okhttp);
                                iOException = new StreamResetException(errorCode$okhttp);
                            }
                        }
                        if (getClosed()) {
                            break;
                        }
                        z5 = false;
                        if (getReadBuffer().getSize() > j6) {
                            j5 = getReadBuffer().read(sink, Math.min(byteCount, getReadBuffer().getSize()));
                            http2Stream.setReadBytesTotal$okhttp(http2Stream.getReadBytesTotal() + j5);
                            long readBytesTotal = http2Stream.getReadBytesTotal() - http2Stream.getReadBytesAcknowledged();
                            if (iOException == null && readBytesTotal >= http2Stream.getConnection().getOkHttpSettings().getInitialWindowSize() / 2) {
                                http2Stream.getConnection().writeWindowUpdateLater$okhttp(http2Stream.getId(), readBytesTotal);
                                http2Stream.setReadBytesAcknowledged$okhttp(http2Stream.getReadBytesTotal());
                            }
                        } else {
                            if (!getFinished() && iOException == null) {
                                http2Stream.waitForIo$okhttp();
                                z5 = true;
                            }
                            j5 = -1;
                        }
                        http2Stream.getReadTimeout().exitAndThrowIfTimedOut();
                        Unit unit = Unit.INSTANCE;
                    } finally {
                    }
                }
                if (!z5) {
                    if (j5 != -1) {
                        updateConnectionFlowControl(j5);
                        return j5;
                    }
                    if (iOException == null) {
                        return -1L;
                    }
                    throw iOException;
                }
                j6 = 0;
            }
        }

        public final void receive$okhttp(BufferedSource source, long byteCount) {
            boolean finished;
            boolean z5;
            long j5;
            Intrinsics.checkNotNullParameter(source, "source");
            Http2Stream http2Stream = this.this$0;
            if (Util.assertionsEnabled && Thread.holdsLock(http2Stream)) {
                throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + http2Stream);
            }
            while (byteCount > 0) {
                synchronized (this.this$0) {
                    finished = getFinished();
                    z5 = getReadBuffer().getSize() + byteCount > this.maxByteCount;
                    Unit unit = Unit.INSTANCE;
                }
                if (z5) {
                    source.skip(byteCount);
                    this.this$0.closeLater(ErrorCode.FLOW_CONTROL_ERROR);
                    return;
                }
                if (finished) {
                    source.skip(byteCount);
                    return;
                }
                long read = source.read(this.receiveBuffer, byteCount);
                if (read == -1) {
                    throw new EOFException();
                }
                byteCount -= read;
                Http2Stream http2Stream2 = this.this$0;
                synchronized (http2Stream2) {
                    try {
                        if (getClosed()) {
                            j5 = getReceiveBuffer().getSize();
                            getReceiveBuffer().clear();
                        } else {
                            boolean z6 = getReadBuffer().getSize() == 0;
                            getReadBuffer().writeAll(getReceiveBuffer());
                            if (z6) {
                                http2Stream2.notifyAll();
                            }
                            j5 = 0;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (j5 > 0) {
                    updateConnectionFlowControl(j5);
                }
            }
        }

        public final void setClosed$okhttp(boolean z5) {
            this.closed = z5;
        }

        public final void setFinished$okhttp(boolean z5) {
            this.finished = z5;
        }

        public final void setTrailers(Headers headers) {
            this.trailers = headers;
        }

        @Override // okio.Source
        /* renamed from: timeout */
        public Timeout getTimeout() {
            return this.this$0.getReadTimeout();
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014J\b\u0010\b\u001a\u00020\u0004H\u0014¨\u0006\t"}, d2 = {"Lokhttp3/internal/http2/Http2Stream$StreamTimeout;", "Lokio/AsyncTimeout;", "(Lokhttp3/internal/http2/Http2Stream;)V", "exitAndThrowIfTimedOut", BuildConfig.FLAVOR, "newTimeoutException", "Ljava/io/IOException;", "cause", "timedOut", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public final class StreamTimeout extends AsyncTimeout {
        final /* synthetic */ Http2Stream this$0;

        public StreamTimeout(Http2Stream this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this.this$0 = this$0;
        }

        public final void exitAndThrowIfTimedOut() {
            if (exit()) {
                throw newTimeoutException(null);
            }
        }

        @Override // okio.AsyncTimeout
        protected IOException newTimeoutException(IOException cause) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (cause != null) {
                socketTimeoutException.initCause(cause);
            }
            return socketTimeoutException;
        }

        @Override // okio.AsyncTimeout
        protected void timedOut() {
            this.this$0.closeLater(ErrorCode.CANCEL);
            this.this$0.getConnection().sendDegradedPingLater$okhttp();
        }
    }

    public Http2Stream(int i5, Http2Connection connection, boolean z5, boolean z6, Headers headers) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        this.id = i5;
        this.connection = connection;
        this.writeBytesMaximum = connection.getPeerSettings().getInitialWindowSize();
        ArrayDeque<Headers> arrayDeque = new ArrayDeque<>();
        this.headersQueue = arrayDeque;
        this.source = new FramingSource(this, connection.getOkHttpSettings().getInitialWindowSize(), z6);
        this.sink = new FramingSink(this, z5);
        this.readTimeout = new StreamTimeout(this);
        this.writeTimeout = new StreamTimeout(this);
        if (headers == null) {
            if (!isLocallyInitiated()) {
                throw new IllegalStateException("remotely-initiated streams should have headers");
            }
        } else {
            if (isLocallyInitiated()) {
                throw new IllegalStateException("locally-initiated streams shouldn't have headers yet");
            }
            arrayDeque.add(headers);
        }
    }

    private final boolean closeInternal(ErrorCode errorCode, IOException errorException) {
        if (Util.assertionsEnabled && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + this);
        }
        synchronized (this) {
            if (getErrorCode$okhttp() != null) {
                return false;
            }
            if (getSource().getFinished() && getSink().getFinished()) {
                return false;
            }
            setErrorCode$okhttp(errorCode);
            setErrorException$okhttp(errorException);
            notifyAll();
            Unit unit = Unit.INSTANCE;
            this.connection.removeStream$okhttp(this.id);
            return true;
        }
    }

    public final void addBytesToWriteWindow(long delta) {
        this.writeBytesMaximum += delta;
        if (delta > 0) {
            notifyAll();
        }
    }

    public final void cancelStreamIfNecessary$okhttp() {
        boolean z5;
        boolean isOpen;
        if (Util.assertionsEnabled && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + this);
        }
        synchronized (this) {
            try {
                if (getSource().getFinished() || !getSource().getClosed() || (!getSink().getFinished() && !getSink().getClosed())) {
                    z5 = false;
                    isOpen = isOpen();
                    Unit unit = Unit.INSTANCE;
                }
                z5 = true;
                isOpen = isOpen();
                Unit unit2 = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z5) {
            close(ErrorCode.CANCEL, null);
        } else {
            if (isOpen) {
                return;
            }
            this.connection.removeStream$okhttp(this.id);
        }
    }

    public final void checkOutNotClosed$okhttp() {
        if (this.sink.getClosed()) {
            throw new IOException("stream closed");
        }
        if (this.sink.getFinished()) {
            throw new IOException("stream finished");
        }
        if (this.errorCode != null) {
            IOException iOException = this.errorException;
            if (iOException != null) {
                throw iOException;
            }
            ErrorCode errorCode = this.errorCode;
            Intrinsics.checkNotNull(errorCode);
            throw new StreamResetException(errorCode);
        }
    }

    public final void close(ErrorCode rstStatusCode, IOException errorException) {
        Intrinsics.checkNotNullParameter(rstStatusCode, "rstStatusCode");
        if (closeInternal(rstStatusCode, errorException)) {
            this.connection.writeSynReset$okhttp(this.id, rstStatusCode);
        }
    }

    public final void closeLater(ErrorCode errorCode) {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        if (closeInternal(errorCode, null)) {
            this.connection.writeSynResetLater$okhttp(this.id, errorCode);
        }
    }

    public final Http2Connection getConnection() {
        return this.connection;
    }

    public final synchronized ErrorCode getErrorCode$okhttp() {
        return this.errorCode;
    }

    /* renamed from: getErrorException$okhttp, reason: from getter */
    public final IOException getErrorException() {
        return this.errorException;
    }

    public final int getId() {
        return this.id;
    }

    public final long getReadBytesAcknowledged() {
        return this.readBytesAcknowledged;
    }

    public final long getReadBytesTotal() {
        return this.readBytesTotal;
    }

    /* renamed from: getReadTimeout$okhttp, reason: from getter */
    public final StreamTimeout getReadTimeout() {
        return this.readTimeout;
    }

    public final Sink getSink() {
        synchronized (this) {
            try {
                if (!this.hasResponseHeaders && !isLocallyInitiated()) {
                    throw new IllegalStateException("reply before requesting the sink");
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
        return this.sink;
    }

    /* renamed from: getSink$okhttp, reason: from getter */
    public final FramingSink getSink() {
        return this.sink;
    }

    /* renamed from: getSource$okhttp, reason: from getter */
    public final FramingSource getSource() {
        return this.source;
    }

    public final long getWriteBytesMaximum() {
        return this.writeBytesMaximum;
    }

    public final long getWriteBytesTotal() {
        return this.writeBytesTotal;
    }

    /* renamed from: getWriteTimeout$okhttp, reason: from getter */
    public final StreamTimeout getWriteTimeout() {
        return this.writeTimeout;
    }

    public final boolean isLocallyInitiated() {
        return this.connection.getClient() == ((this.id & 1) == 1);
    }

    public final synchronized boolean isOpen() {
        try {
            if (this.errorCode != null) {
                return false;
            }
            if (!this.source.getFinished()) {
                if (this.source.getClosed()) {
                }
                return true;
            }
            if (this.sink.getFinished() || this.sink.getClosed()) {
                if (this.hasResponseHeaders) {
                    return false;
                }
            }
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final Timeout readTimeout() {
        return this.readTimeout;
    }

    public final void receiveData(BufferedSource source, int length) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (!Util.assertionsEnabled || !Thread.holdsLock(this)) {
            this.source.receive$okhttp(source, length);
            return;
        }
        throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + this);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0053 A[Catch: all -> 0x0048, TryCatch #0 {all -> 0x0048, blocks: (B:10:0x0038, B:14:0x0040, B:16:0x0053, B:17:0x005a, B:24:0x004a), top: B:9:0x0038 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void receiveHeaders(Headers headers, boolean inFinished) {
        boolean isOpen;
        Intrinsics.checkNotNullParameter(headers, "headers");
        if (Util.assertionsEnabled && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + this);
        }
        synchronized (this) {
            try {
                if (this.hasResponseHeaders && inFinished) {
                    getSource().setTrailers(headers);
                    if (inFinished) {
                        getSource().setFinished$okhttp(true);
                    }
                    isOpen = isOpen();
                    notifyAll();
                    Unit unit = Unit.INSTANCE;
                }
                this.hasResponseHeaders = true;
                this.headersQueue.add(headers);
                if (inFinished) {
                }
                isOpen = isOpen();
                notifyAll();
                Unit unit2 = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (isOpen) {
            return;
        }
        this.connection.removeStream$okhttp(this.id);
    }

    public final synchronized void receiveRstStream(ErrorCode errorCode) {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        if (this.errorCode == null) {
            this.errorCode = errorCode;
            notifyAll();
        }
    }

    public final void setErrorCode$okhttp(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public final void setErrorException$okhttp(IOException iOException) {
        this.errorException = iOException;
    }

    public final void setReadBytesAcknowledged$okhttp(long j5) {
        this.readBytesAcknowledged = j5;
    }

    public final void setReadBytesTotal$okhttp(long j5) {
        this.readBytesTotal = j5;
    }

    public final void setWriteBytesTotal$okhttp(long j5) {
        this.writeBytesTotal = j5;
    }

    public final synchronized Headers takeHeaders() {
        Headers removeFirst;
        this.readTimeout.enter();
        while (this.headersQueue.isEmpty() && this.errorCode == null) {
            try {
                waitForIo$okhttp();
            } catch (Throwable th) {
                this.readTimeout.exitAndThrowIfTimedOut();
                throw th;
            }
        }
        this.readTimeout.exitAndThrowIfTimedOut();
        if (this.headersQueue.isEmpty()) {
            IOException iOException = this.errorException;
            if (iOException != null) {
                throw iOException;
            }
            ErrorCode errorCode = this.errorCode;
            Intrinsics.checkNotNull(errorCode);
            throw new StreamResetException(errorCode);
        }
        removeFirst = this.headersQueue.removeFirst();
        Intrinsics.checkNotNullExpressionValue(removeFirst, "headersQueue.removeFirst()");
        return removeFirst;
    }

    public final void waitForIo$okhttp() {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    public final Timeout writeTimeout() {
        return this.writeTimeout;
    }
}
