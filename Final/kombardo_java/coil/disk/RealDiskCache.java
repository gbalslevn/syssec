package coil.disk;

import coil.disk.DiskCache;
import coil.disk.DiskLruCache;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineDispatcher;
import okio.ByteString;
import okio.FileSystem;
import okio.Path;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \"2\u00020\u0001:\u0003\"#$B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\r\u001a\u00020\f*\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000f\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u000f\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010 \u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!¨\u0006%"}, d2 = {"Lcoil/disk/RealDiskCache;", "Lcoil/disk/DiskCache;", BuildConfig.FLAVOR, "maxSize", "Lokio/Path;", "directory", "Lokio/FileSystem;", "fileSystem", "Lkotlinx/coroutines/CoroutineDispatcher;", "cleanupDispatcher", "<init>", "(JLokio/Path;Lokio/FileSystem;Lkotlinx/coroutines/CoroutineDispatcher;)V", BuildConfig.FLAVOR, "hash", "(Ljava/lang/String;)Ljava/lang/String;", "key", "Lcoil/disk/DiskCache$Snapshot;", "openSnapshot", "(Ljava/lang/String;)Lcoil/disk/DiskCache$Snapshot;", "Lcoil/disk/DiskCache$Editor;", "openEditor", "(Ljava/lang/String;)Lcoil/disk/DiskCache$Editor;", "J", "getMaxSize", "()J", "Lokio/Path;", "getDirectory", "()Lokio/Path;", "Lokio/FileSystem;", "getFileSystem", "()Lokio/FileSystem;", "Lcoil/disk/DiskLruCache;", "cache", "Lcoil/disk/DiskLruCache;", "Companion", "RealEditor", "RealSnapshot", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RealDiskCache implements DiskCache {
    private static final int ENTRY_DATA = 1;
    private static final int ENTRY_METADATA = 0;
    private final DiskLruCache cache;
    private final Path directory;
    private final FileSystem fileSystem;
    private final long maxSize;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0004\u001a\u00060\u0002R\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u00060\u0002R\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcoil/disk/RealDiskCache$RealEditor;", "Lcoil/disk/DiskCache$Editor;", "Lcoil/disk/DiskLruCache$Editor;", "Lcoil/disk/DiskLruCache;", "editor", "<init>", "(Lcoil/disk/DiskLruCache$Editor;)V", "Lcoil/disk/RealDiskCache$RealSnapshot;", "commitAndOpenSnapshot", "()Lcoil/disk/RealDiskCache$RealSnapshot;", BuildConfig.FLAVOR, "abort", "()V", "Lcoil/disk/DiskLruCache$Editor;", "Lokio/Path;", "getMetadata", "()Lokio/Path;", "metadata", "getData", "data", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class RealEditor implements DiskCache.Editor {
        private final DiskLruCache.Editor editor;

        public RealEditor(DiskLruCache.Editor editor) {
            this.editor = editor;
        }

        @Override // coil.disk.DiskCache.Editor
        public void abort() {
            this.editor.abort();
        }

        @Override // coil.disk.DiskCache.Editor
        public Path getData() {
            return this.editor.file(1);
        }

        @Override // coil.disk.DiskCache.Editor
        public Path getMetadata() {
            return this.editor.file(0);
        }

        @Override // coil.disk.DiskCache.Editor
        public RealSnapshot commitAndOpenSnapshot() {
            DiskLruCache.Snapshot commitAndGet = this.editor.commitAndGet();
            if (commitAndGet != null) {
                return new RealSnapshot(commitAndGet);
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0004\u001a\u00060\u0002R\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0011\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u00060\u0002R\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcoil/disk/RealDiskCache$RealSnapshot;", "Lcoil/disk/DiskCache$Snapshot;", "Lcoil/disk/DiskLruCache$Snapshot;", "Lcoil/disk/DiskLruCache;", "snapshot", "<init>", "(Lcoil/disk/DiskLruCache$Snapshot;)V", BuildConfig.FLAVOR, "close", "()V", "Lcoil/disk/RealDiskCache$RealEditor;", "closeAndOpenEditor", "()Lcoil/disk/RealDiskCache$RealEditor;", "Lcoil/disk/DiskLruCache$Snapshot;", "Lokio/Path;", "getMetadata", "()Lokio/Path;", "metadata", "getData", "data", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class RealSnapshot implements DiskCache.Snapshot {
        private final DiskLruCache.Snapshot snapshot;

        public RealSnapshot(DiskLruCache.Snapshot snapshot) {
            this.snapshot = snapshot;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.snapshot.close();
        }

        @Override // coil.disk.DiskCache.Snapshot
        public Path getData() {
            return this.snapshot.file(1);
        }

        @Override // coil.disk.DiskCache.Snapshot
        public Path getMetadata() {
            return this.snapshot.file(0);
        }

        @Override // coil.disk.DiskCache.Snapshot
        public RealEditor closeAndOpenEditor() {
            DiskLruCache.Editor closeAndEdit = this.snapshot.closeAndEdit();
            if (closeAndEdit != null) {
                return new RealEditor(closeAndEdit);
            }
            return null;
        }
    }

    public RealDiskCache(long j5, Path path, FileSystem fileSystem, CoroutineDispatcher coroutineDispatcher) {
        this.maxSize = j5;
        this.directory = path;
        this.fileSystem = fileSystem;
        this.cache = new DiskLruCache(getFileSystem(), getDirectory(), coroutineDispatcher, getMaxSize(), 1, 2);
    }

    private final String hash(String str) {
        return ByteString.INSTANCE.encodeUtf8(str).sha256().hex();
    }

    public Path getDirectory() {
        return this.directory;
    }

    @Override // coil.disk.DiskCache
    public FileSystem getFileSystem() {
        return this.fileSystem;
    }

    public long getMaxSize() {
        return this.maxSize;
    }

    @Override // coil.disk.DiskCache
    public DiskCache.Editor openEditor(String key) {
        DiskLruCache.Editor edit = this.cache.edit(hash(key));
        if (edit != null) {
            return new RealEditor(edit);
        }
        return null;
    }

    @Override // coil.disk.DiskCache
    public DiskCache.Snapshot openSnapshot(String key) {
        DiskLruCache.Snapshot snapshot = this.cache.get(hash(key));
        if (snapshot != null) {
            return new RealSnapshot(snapshot);
        }
        return null;
    }
}
