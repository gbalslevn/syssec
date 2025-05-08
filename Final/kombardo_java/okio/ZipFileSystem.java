package okio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.zip.Inflater;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.Path;
import okio.internal.FixedLengthSource;
import okio.internal.ZipEntry;
import okio.internal.ZipFilesKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\f\b\u0000\u0018\u0000 32\u00020\u0001:\u00013B7\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00122\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ'\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0013\u0010 J\u0017\u0010\"\u001a\u00020!2\u0006\u0010\u0018\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\"\u0010#J\u001f\u0010%\u001a\u00020$2\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0010H\u0016¢\u0006\u0004\b%\u0010&J\u001f\u0010'\u001a\u00020$2\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0010H\u0016¢\u0006\u0004\b'\u0010&J\u001f\u0010)\u001a\u00020(2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0010H\u0016¢\u0006\u0004\b)\u0010*J\u001f\u0010,\u001a\u00020(2\u0006\u0010\"\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\u0002H\u0016¢\u0006\u0004\b,\u0010-J\u001f\u0010.\u001a\u00020(2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0010H\u0016¢\u0006\u0004\b.\u0010*R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010/R\u0014\u0010\u0004\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u00100R \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u00101R\u0016\u0010\t\u001a\u0004\u0018\u00010\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u00102¨\u00064"}, d2 = {"Lokio/ZipFileSystem;", "Lokio/FileSystem;", "Lokio/Path;", "zipPath", "fileSystem", BuildConfig.FLAVOR, "Lokio/internal/ZipEntry;", "entries", BuildConfig.FLAVOR, "comment", "<init>", "(Lokio/Path;Lokio/FileSystem;Ljava/util/Map;Ljava/lang/String;)V", "path", "canonicalizeInternal", "(Lokio/Path;)Lokio/Path;", "dir", BuildConfig.FLAVOR, "throwOnFailure", BuildConfig.FLAVOR, "list", "(Lokio/Path;Z)Ljava/util/List;", "Lokio/FileMetadata;", "metadataOrNull", "(Lokio/Path;)Lokio/FileMetadata;", "file", "Lokio/FileHandle;", "openReadOnly", "(Lokio/Path;)Lokio/FileHandle;", "mustCreate", "mustExist", "openReadWrite", "(Lokio/Path;ZZ)Lokio/FileHandle;", "(Lokio/Path;)Ljava/util/List;", "Lokio/Source;", "source", "(Lokio/Path;)Lokio/Source;", "Lokio/Sink;", "sink", "(Lokio/Path;Z)Lokio/Sink;", "appendingSink", BuildConfig.FLAVOR, "createDirectory", "(Lokio/Path;Z)V", "target", "atomicMove", "(Lokio/Path;Lokio/Path;)V", "delete", "Lokio/Path;", "Lokio/FileSystem;", "Ljava/util/Map;", "Ljava/lang/String;", "Companion", "okio"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ZipFileSystem extends FileSystem {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    private static final Path ROOT = Path.Companion.get$default(Path.INSTANCE, "/", false, 1, (Object) null);
    private final String comment;
    private final Map<Path, ZipEntry> entries;
    private final FileSystem fileSystem;
    private final Path zipPath;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lokio/ZipFileSystem$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "okio"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes3.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public ZipFileSystem(Path zipPath, FileSystem fileSystem, Map<Path, ZipEntry> entries, String str) {
        Intrinsics.checkNotNullParameter(zipPath, "zipPath");
        Intrinsics.checkNotNullParameter(fileSystem, "fileSystem");
        Intrinsics.checkNotNullParameter(entries, "entries");
        this.zipPath = zipPath;
        this.fileSystem = fileSystem;
        this.entries = entries;
        this.comment = str;
    }

    private final Path canonicalizeInternal(Path path) {
        return ROOT.resolve(path, true);
    }

    @Override // okio.FileSystem
    public Sink appendingSink(Path file, boolean mustExist) {
        Intrinsics.checkNotNullParameter(file, "file");
        throw new IOException("zip file systems are read-only");
    }

    @Override // okio.FileSystem
    public void atomicMove(Path source, Path target) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(target, "target");
        throw new IOException("zip file systems are read-only");
    }

    @Override // okio.FileSystem
    public void createDirectory(Path dir, boolean mustCreate) {
        Intrinsics.checkNotNullParameter(dir, "dir");
        throw new IOException("zip file systems are read-only");
    }

    @Override // okio.FileSystem
    public void delete(Path path, boolean mustExist) {
        Intrinsics.checkNotNullParameter(path, "path");
        throw new IOException("zip file systems are read-only");
    }

    @Override // okio.FileSystem
    public List<Path> list(Path dir) {
        Intrinsics.checkNotNullParameter(dir, "dir");
        List<Path> list = list(dir, true);
        Intrinsics.checkNotNull(list);
        return list;
    }

    @Override // okio.FileSystem
    public FileMetadata metadataOrNull(Path path) {
        BufferedSource bufferedSource;
        Intrinsics.checkNotNullParameter(path, "path");
        ZipEntry zipEntry = this.entries.get(canonicalizeInternal(path));
        Throwable th = null;
        if (zipEntry == null) {
            return null;
        }
        FileMetadata fileMetadata = new FileMetadata(!zipEntry.getIsDirectory(), zipEntry.getIsDirectory(), null, zipEntry.getIsDirectory() ? null : Long.valueOf(zipEntry.getSize()), null, zipEntry.getLastModifiedAtMillis(), null, null, 128, null);
        if (zipEntry.getOffset() == -1) {
            return fileMetadata;
        }
        FileHandle openReadOnly = this.fileSystem.openReadOnly(this.zipPath);
        try {
            bufferedSource = Okio.buffer(openReadOnly.source(zipEntry.getOffset()));
            if (openReadOnly != null) {
                try {
                    openReadOnly.close();
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        } catch (Throwable th3) {
            if (openReadOnly != null) {
                try {
                    openReadOnly.close();
                } catch (Throwable th4) {
                    ExceptionsKt.addSuppressed(th3, th4);
                }
            }
            th = th3;
            bufferedSource = null;
        }
        if (th != null) {
            throw th;
        }
        Intrinsics.checkNotNull(bufferedSource);
        return ZipFilesKt.readLocalHeader(bufferedSource, fileMetadata);
    }

    @Override // okio.FileSystem
    public FileHandle openReadOnly(Path file) {
        Intrinsics.checkNotNullParameter(file, "file");
        throw new UnsupportedOperationException("not implemented yet!");
    }

    @Override // okio.FileSystem
    public FileHandle openReadWrite(Path file, boolean mustCreate, boolean mustExist) {
        Intrinsics.checkNotNullParameter(file, "file");
        throw new IOException("zip entries are not writable");
    }

    @Override // okio.FileSystem
    public Sink sink(Path file, boolean mustCreate) {
        Intrinsics.checkNotNullParameter(file, "file");
        throw new IOException("zip file systems are read-only");
    }

    @Override // okio.FileSystem
    public Source source(Path file) {
        BufferedSource bufferedSource;
        Intrinsics.checkNotNullParameter(file, "file");
        ZipEntry zipEntry = this.entries.get(canonicalizeInternal(file));
        if (zipEntry == null) {
            throw new FileNotFoundException("no such file: " + file);
        }
        FileHandle openReadOnly = this.fileSystem.openReadOnly(this.zipPath);
        Throwable th = null;
        try {
            bufferedSource = Okio.buffer(openReadOnly.source(zipEntry.getOffset()));
            if (openReadOnly != null) {
                try {
                    openReadOnly.close();
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        } catch (Throwable th3) {
            if (openReadOnly != null) {
                try {
                    openReadOnly.close();
                } catch (Throwable th4) {
                    ExceptionsKt.addSuppressed(th3, th4);
                }
            }
            bufferedSource = null;
            th = th3;
        }
        if (th != null) {
            throw th;
        }
        Intrinsics.checkNotNull(bufferedSource);
        ZipFilesKt.skipLocalHeader(bufferedSource);
        return zipEntry.getCompressionMethod() == 0 ? new FixedLengthSource(bufferedSource, zipEntry.getSize(), true) : new FixedLengthSource(new InflaterSource(new FixedLengthSource(bufferedSource, zipEntry.getCompressedSize(), true), new Inflater(true)), zipEntry.getSize(), false);
    }

    private final List<Path> list(Path dir, boolean throwOnFailure) {
        ZipEntry zipEntry = this.entries.get(canonicalizeInternal(dir));
        if (zipEntry != null) {
            return CollectionsKt.toList(zipEntry.getChildren());
        }
        if (!throwOnFailure) {
            return null;
        }
        throw new IOException("not a directory: " + dir);
    }
}
