package okio;

import java.io.Closeable;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00060\u0001j\u0002`\u0002:\u000223B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\f\u0010\rJ'\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\u000f¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u000e\u001a\u00020\u00162\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010\u0017J\u0017\u0010\n\u001a\u00020\u00182\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u0019J\r\u0010\u001a\u001a\u00020\u000f¢\u0006\u0004\b\u001a\u0010\u0015J/\u0010\u001f\u001a\u00020\u001d2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u000b\u001a\u00020\u001dH$¢\u0006\u0004\b\u001f\u0010 J/\u0010!\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u000b\u001a\u00020\u001dH$¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u000fH$¢\u0006\u0004\b#\u0010\u0015J\u000f\u0010$\u001a\u00020\u0007H$¢\u0006\u0004\b$\u0010\u0013J\u000f\u0010%\u001a\u00020\u000fH$¢\u0006\u0004\b%\u0010\u0015R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010&\u001a\u0004\b'\u0010(R\u0016\u0010)\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010&R\u0016\u0010*\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u001b\u0010.\u001a\u00060,j\u0002`-8\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101¨\u00064"}, d2 = {"Lokio/FileHandle;", "Ljava/io/Closeable;", "Lokio/Closeable;", BuildConfig.FLAVOR, "readWrite", "<init>", "(Z)V", BuildConfig.FLAVOR, "fileOffset", "Lokio/Buffer;", "sink", "byteCount", "readNoCloseCheck", "(JLokio/Buffer;J)J", "source", BuildConfig.FLAVOR, "writeNoCloseCheck", "(JLokio/Buffer;J)V", "size", "()J", "flush", "()V", "Lokio/Source;", "(J)Lokio/Source;", "Lokio/Sink;", "(J)Lokio/Sink;", "close", BuildConfig.FLAVOR, "array", BuildConfig.FLAVOR, "arrayOffset", "protectedRead", "(J[BII)I", "protectedWrite", "(J[BII)V", "protectedFlush", "protectedSize", "protectedClose", "Z", "getReadWrite", "()Z", "closed", "openStreamCount", "I", "Ljava/util/concurrent/locks/ReentrantLock;", "Lokio/Lock;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "getLock", "()Ljava/util/concurrent/locks/ReentrantLock;", "FileHandleSink", "FileHandleSource", "okio"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class FileHandle implements Closeable {
    private boolean closed;
    private final ReentrantLock lock = _JvmPlatformKt.newLock();
    private int openStreamCount;
    private final boolean readWrite;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0013\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lokio/FileHandle$FileHandleSink;", "Lokio/Sink;", "Lokio/FileHandle;", "fileHandle", BuildConfig.FLAVOR, "position", "<init>", "(Lokio/FileHandle;J)V", "Lokio/Buffer;", "source", "byteCount", BuildConfig.FLAVOR, "write", "(Lokio/Buffer;J)V", "flush", "()V", "Lokio/Timeout;", "timeout", "()Lokio/Timeout;", "close", "Lokio/FileHandle;", "getFileHandle", "()Lokio/FileHandle;", "J", "getPosition", "()J", "setPosition", "(J)V", BuildConfig.FLAVOR, "closed", "Z", "getClosed", "()Z", "setClosed", "(Z)V", "okio"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class FileHandleSink implements Sink {
        private boolean closed;
        private final FileHandle fileHandle;
        private long position;

        public FileHandleSink(FileHandle fileHandle, long j5) {
            Intrinsics.checkNotNullParameter(fileHandle, "fileHandle");
            this.fileHandle = fileHandle;
            this.position = j5;
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.closed) {
                return;
            }
            this.closed = true;
            ReentrantLock lock = this.fileHandle.getLock();
            lock.lock();
            try {
                FileHandle fileHandle = this.fileHandle;
                fileHandle.openStreamCount--;
                if (this.fileHandle.openStreamCount == 0 && this.fileHandle.closed) {
                    Unit unit = Unit.INSTANCE;
                    lock.unlock();
                    this.fileHandle.protectedClose();
                }
            } finally {
                lock.unlock();
            }
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() {
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            this.fileHandle.protectedFlush();
        }

        @Override // okio.Sink
        public Timeout timeout() {
            return Timeout.NONE;
        }

        @Override // okio.Sink
        public void write(Buffer source, long byteCount) {
            Intrinsics.checkNotNullParameter(source, "source");
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            this.fileHandle.writeNoCloseCheck(this.position, source, byteCount);
            this.position += byteCount;
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006\""}, d2 = {"Lokio/FileHandle$FileHandleSource;", "Lokio/Source;", "Lokio/FileHandle;", "fileHandle", BuildConfig.FLAVOR, "position", "<init>", "(Lokio/FileHandle;J)V", "Lokio/Buffer;", "sink", "byteCount", "read", "(Lokio/Buffer;J)J", "Lokio/Timeout;", "timeout", "()Lokio/Timeout;", BuildConfig.FLAVOR, "close", "()V", "Lokio/FileHandle;", "getFileHandle", "()Lokio/FileHandle;", "J", "getPosition", "()J", "setPosition", "(J)V", BuildConfig.FLAVOR, "closed", "Z", "getClosed", "()Z", "setClosed", "(Z)V", "okio"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes3.dex */
    private static final class FileHandleSource implements Source {
        private boolean closed;
        private final FileHandle fileHandle;
        private long position;

        public FileHandleSource(FileHandle fileHandle, long j5) {
            Intrinsics.checkNotNullParameter(fileHandle, "fileHandle");
            this.fileHandle = fileHandle;
            this.position = j5;
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.closed) {
                return;
            }
            this.closed = true;
            ReentrantLock lock = this.fileHandle.getLock();
            lock.lock();
            try {
                FileHandle fileHandle = this.fileHandle;
                fileHandle.openStreamCount--;
                if (this.fileHandle.openStreamCount == 0 && this.fileHandle.closed) {
                    Unit unit = Unit.INSTANCE;
                    lock.unlock();
                    this.fileHandle.protectedClose();
                }
            } finally {
                lock.unlock();
            }
        }

        @Override // okio.Source
        public long read(Buffer sink, long byteCount) {
            Intrinsics.checkNotNullParameter(sink, "sink");
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            long readNoCloseCheck = this.fileHandle.readNoCloseCheck(this.position, sink, byteCount);
            if (readNoCloseCheck != -1) {
                this.position += readNoCloseCheck;
            }
            return readNoCloseCheck;
        }

        @Override // okio.Source
        public Timeout timeout() {
            return Timeout.NONE;
        }
    }

    public FileHandle(boolean z5) {
        this.readWrite = z5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long readNoCloseCheck(long fileOffset, Buffer sink, long byteCount) {
        if (byteCount < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
        }
        long j5 = byteCount + fileOffset;
        long j6 = fileOffset;
        while (true) {
            if (j6 >= j5) {
                break;
            }
            Segment writableSegment$okio = sink.writableSegment$okio(1);
            int protectedRead = protectedRead(j6, writableSegment$okio.data, writableSegment$okio.limit, (int) Math.min(j5 - j6, 8192 - r7));
            if (protectedRead == -1) {
                if (writableSegment$okio.pos == writableSegment$okio.limit) {
                    sink.head = writableSegment$okio.pop();
                    SegmentPool.recycle(writableSegment$okio);
                }
                if (fileOffset == j6) {
                    return -1L;
                }
            } else {
                writableSegment$okio.limit += protectedRead;
                long j7 = protectedRead;
                j6 += j7;
                sink.setSize$okio(sink.getSize() + j7);
            }
        }
        return j6 - fileOffset;
    }

    public static /* synthetic */ Sink sink$default(FileHandle fileHandle, long j5, int i5, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sink");
        }
        if ((i5 & 1) != 0) {
            j5 = 0;
        }
        return fileHandle.sink(j5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void writeNoCloseCheck(long fileOffset, Buffer source, long byteCount) {
        SegmentedByteString.checkOffsetAndCount(source.getSize(), 0L, byteCount);
        long j5 = byteCount + fileOffset;
        while (fileOffset < j5) {
            Segment segment = source.head;
            Intrinsics.checkNotNull(segment);
            int min = (int) Math.min(j5 - fileOffset, segment.limit - segment.pos);
            protectedWrite(fileOffset, segment.data, segment.pos, min);
            segment.pos += min;
            long j6 = min;
            fileOffset += j6;
            source.setSize$okio(source.getSize() - j6);
            if (segment.pos == segment.limit) {
                source.head = segment.pop();
                SegmentPool.recycle(segment);
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (this.closed) {
                return;
            }
            this.closed = true;
            if (this.openStreamCount != 0) {
                return;
            }
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            protectedClose();
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void flush() {
        if (!this.readWrite) {
            throw new IllegalStateException("file handle is read-only");
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            protectedFlush();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final ReentrantLock getLock() {
        return this.lock;
    }

    protected abstract void protectedClose();

    protected abstract void protectedFlush();

    protected abstract int protectedRead(long fileOffset, byte[] array, int arrayOffset, int byteCount);

    protected abstract long protectedSize();

    protected abstract void protectedWrite(long fileOffset, byte[] array, int arrayOffset, int byteCount);

    public final Sink sink(long fileOffset) {
        if (!this.readWrite) {
            throw new IllegalStateException("file handle is read-only");
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            this.openStreamCount++;
            reentrantLock.unlock();
            return new FileHandleSink(this, fileOffset);
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final long size() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            return protectedSize();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final Source source(long fileOffset) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            this.openStreamCount++;
            reentrantLock.unlock();
            return new FileHandleSource(this, fileOffset);
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }
}
