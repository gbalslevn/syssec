package coil.disk;

import android.os.StatFs;
import java.io.Closeable;
import java.io.File;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import okio.FileSystem;
import okio.Path;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001:\u0003\u0010\u0011\u0012J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\b\u0010\tR\u001a\u0010\u000f\u001a\u00020\n8&X§\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0013À\u0006\u0001"}, d2 = {"Lcoil/disk/DiskCache;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "key", "Lcoil/disk/DiskCache$Snapshot;", "openSnapshot", "(Ljava/lang/String;)Lcoil/disk/DiskCache$Snapshot;", "Lcoil/disk/DiskCache$Editor;", "openEditor", "(Ljava/lang/String;)Lcoil/disk/DiskCache$Editor;", "Lokio/FileSystem;", "getFileSystem", "()Lokio/FileSystem;", "getFileSystem$annotations", "()V", "fileSystem", "Builder", "Editor", "Snapshot", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface DiskCache {

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0007¢\u0006\u0004\b\u0005\u0010\bJ\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\fR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcoil/disk/DiskCache$Builder;", BuildConfig.FLAVOR, "<init>", "()V", "Ljava/io/File;", "directory", "(Ljava/io/File;)Lcoil/disk/DiskCache$Builder;", "Lokio/Path;", "(Lokio/Path;)Lcoil/disk/DiskCache$Builder;", "Lcoil/disk/DiskCache;", "build", "()Lcoil/disk/DiskCache;", "Lokio/Path;", "Lokio/FileSystem;", "fileSystem", "Lokio/FileSystem;", BuildConfig.FLAVOR, "maxSizePercent", "D", BuildConfig.FLAVOR, "minimumMaxSizeBytes", "J", "maximumMaxSizeBytes", "maxSizeBytes", "Lkotlinx/coroutines/CoroutineDispatcher;", "cleanupDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Builder {
        private Path directory;
        private long maxSizeBytes;
        private FileSystem fileSystem = FileSystem.SYSTEM;
        private double maxSizePercent = 0.02d;
        private long minimumMaxSizeBytes = 10485760;
        private long maximumMaxSizeBytes = 262144000;
        private CoroutineDispatcher cleanupDispatcher = Dispatchers.getIO();

        public final DiskCache build() {
            long j5;
            Path path = this.directory;
            if (path == null) {
                throw new IllegalStateException("directory == null");
            }
            if (this.maxSizePercent > 0.0d) {
                try {
                    File file = path.toFile();
                    file.mkdir();
                    StatFs statFs = new StatFs(file.getAbsolutePath());
                    j5 = RangesKt.coerceIn((long) (this.maxSizePercent * statFs.getBlockCountLong() * statFs.getBlockSizeLong()), this.minimumMaxSizeBytes, this.maximumMaxSizeBytes);
                } catch (Exception unused) {
                    j5 = this.minimumMaxSizeBytes;
                }
            } else {
                j5 = this.maxSizeBytes;
            }
            return new RealDiskCache(j5, path, this.fileSystem, this.cleanupDispatcher);
        }

        public final Builder directory(File directory) {
            return directory(Path.Companion.get$default(Path.INSTANCE, directory, false, 1, (Object) null));
        }

        public final Builder directory(Path directory) {
            this.directory = directory;
            return this;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0001"}, d2 = {"Lcoil/disk/DiskCache$Editor;", BuildConfig.FLAVOR, "Lcoil/disk/DiskCache$Snapshot;", "commitAndOpenSnapshot", "()Lcoil/disk/DiskCache$Snapshot;", BuildConfig.FLAVOR, "abort", "()V", "Lokio/Path;", "getMetadata", "()Lokio/Path;", "metadata", "getData", "data", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public interface Editor {
        void abort();

        Snapshot commitAndOpenSnapshot();

        Path getData();

        Path getMetadata();
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00060\u0001j\u0002`\u0002J\u0011\u0010\u0004\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\t\u001a\u00020\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0001"}, d2 = {"Lcoil/disk/DiskCache$Snapshot;", "Ljava/io/Closeable;", "Lokio/Closeable;", "Lcoil/disk/DiskCache$Editor;", "closeAndOpenEditor", "()Lcoil/disk/DiskCache$Editor;", "Lokio/Path;", "getMetadata", "()Lokio/Path;", "metadata", "getData", "data", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public interface Snapshot extends Closeable {
        Editor closeAndOpenEditor();

        Path getData();

        Path getMetadata();
    }

    FileSystem getFileSystem();

    Editor openEditor(String key);

    Snapshot openSnapshot(String key);
}
