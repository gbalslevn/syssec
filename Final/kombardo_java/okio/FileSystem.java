package okio;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Path;
import okio.internal.ResourceFileSystem;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\n\b&\u0018\u0000 *2\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\t\u0010\bJ\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e2\u0006\u0010\r\u001a\u00020\u0004H&¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0004H&¢\u0006\u0004\b\u0013\u0010\u0014J+\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00042\b\b\u0002\u0010\u0015\u001a\u00020\n2\b\b\u0002\u0010\u0016\u001a\u00020\nH&¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0004¢\u0006\u0004\b\u0017\u0010\u0014J\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0011\u001a\u00020\u0004H&¢\u0006\u0004\b\u001a\u0010\u001bJ!\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0011\u001a\u00020\u00042\b\b\u0002\u0010\u0015\u001a\u00020\nH&¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0011\u001a\u00020\u0004¢\u0006\u0004\b\u001d\u0010\u001fJ!\u0010 \u001a\u00020\u001c2\u0006\u0010\u0011\u001a\u00020\u00042\b\b\u0002\u0010\u0016\u001a\u00020\nH&¢\u0006\u0004\b \u0010\u001eJ\u0015\u0010 \u001a\u00020\u001c2\u0006\u0010\u0011\u001a\u00020\u0004¢\u0006\u0004\b \u0010\u001fJ!\u0010\"\u001a\u00020!2\u0006\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u0015\u001a\u00020\nH&¢\u0006\u0004\b\"\u0010#J\u0015\u0010\"\u001a\u00020!2\u0006\u0010\r\u001a\u00020\u0004¢\u0006\u0004\b\"\u0010$J\u001f\u0010%\u001a\u00020!2\u0006\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u0015\u001a\u00020\n¢\u0006\u0004\b%\u0010#J\u0015\u0010%\u001a\u00020!2\u0006\u0010\r\u001a\u00020\u0004¢\u0006\u0004\b%\u0010$J\u001f\u0010'\u001a\u00020!2\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0004H&¢\u0006\u0004\b'\u0010(J!\u0010)\u001a\u00020!2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0016\u001a\u00020\nH&¢\u0006\u0004\b)\u0010#J\u0015\u0010)\u001a\u00020!2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b)\u0010$¨\u0006+"}, d2 = {"Lokio/FileSystem;", BuildConfig.FLAVOR, "<init>", "()V", "Lokio/Path;", "path", "Lokio/FileMetadata;", "metadata", "(Lokio/Path;)Lokio/FileMetadata;", "metadataOrNull", BuildConfig.FLAVOR, "exists", "(Lokio/Path;)Z", "dir", BuildConfig.FLAVOR, "list", "(Lokio/Path;)Ljava/util/List;", "file", "Lokio/FileHandle;", "openReadOnly", "(Lokio/Path;)Lokio/FileHandle;", "mustCreate", "mustExist", "openReadWrite", "(Lokio/Path;ZZ)Lokio/FileHandle;", "Lokio/Source;", "source", "(Lokio/Path;)Lokio/Source;", "Lokio/Sink;", "sink", "(Lokio/Path;Z)Lokio/Sink;", "(Lokio/Path;)Lokio/Sink;", "appendingSink", BuildConfig.FLAVOR, "createDirectory", "(Lokio/Path;Z)V", "(Lokio/Path;)V", "createDirectories", "target", "atomicMove", "(Lokio/Path;Lokio/Path;)V", "delete", "Companion", "okio"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class FileSystem {
    public static final FileSystem RESOURCES;
    public static final FileSystem SYSTEM;
    public static final Path SYSTEM_TEMPORARY_DIRECTORY;

    static {
        FileSystem jvmSystemFileSystem;
        try {
            Class.forName("java.nio.file.Files");
            jvmSystemFileSystem = new NioSystemFileSystem();
        } catch (ClassNotFoundException unused) {
            jvmSystemFileSystem = new JvmSystemFileSystem();
        }
        SYSTEM = jvmSystemFileSystem;
        Path.Companion companion = Path.INSTANCE;
        String property = System.getProperty("java.io.tmpdir");
        Intrinsics.checkNotNullExpressionValue(property, "getProperty(\"java.io.tmpdir\")");
        SYSTEM_TEMPORARY_DIRECTORY = Path.Companion.get$default(companion, property, false, 1, (Object) null);
        ClassLoader classLoader = ResourceFileSystem.class.getClassLoader();
        Intrinsics.checkNotNullExpressionValue(classLoader, "ResourceFileSystem::class.java.classLoader");
        RESOURCES = new ResourceFileSystem(classLoader, false);
    }

    public final Sink appendingSink(Path file) {
        Intrinsics.checkNotNullParameter(file, "file");
        return appendingSink(file, false);
    }

    public abstract Sink appendingSink(Path file, boolean mustExist);

    public abstract void atomicMove(Path source, Path target);

    public final void createDirectories(Path dir, boolean mustCreate) {
        Intrinsics.checkNotNullParameter(dir, "dir");
        okio.internal.FileSystem.commonCreateDirectories(this, dir, mustCreate);
    }

    public final void createDirectory(Path dir) {
        Intrinsics.checkNotNullParameter(dir, "dir");
        createDirectory(dir, false);
    }

    public abstract void createDirectory(Path dir, boolean mustCreate);

    public final void delete(Path path) {
        Intrinsics.checkNotNullParameter(path, "path");
        delete(path, false);
    }

    public abstract void delete(Path path, boolean mustExist);

    public final boolean exists(Path path) {
        Intrinsics.checkNotNullParameter(path, "path");
        return okio.internal.FileSystem.commonExists(this, path);
    }

    public abstract List<Path> list(Path dir);

    public final FileMetadata metadata(Path path) {
        Intrinsics.checkNotNullParameter(path, "path");
        return okio.internal.FileSystem.commonMetadata(this, path);
    }

    public abstract FileMetadata metadataOrNull(Path path);

    public abstract FileHandle openReadOnly(Path file);

    public final FileHandle openReadWrite(Path file) {
        Intrinsics.checkNotNullParameter(file, "file");
        return openReadWrite(file, false, false);
    }

    public abstract FileHandle openReadWrite(Path file, boolean mustCreate, boolean mustExist);

    public final Sink sink(Path file) {
        Intrinsics.checkNotNullParameter(file, "file");
        return sink(file, false);
    }

    public abstract Sink sink(Path file, boolean mustCreate);

    public abstract Source source(Path file);

    public final void createDirectories(Path dir) {
        Intrinsics.checkNotNullParameter(dir, "dir");
        createDirectories(dir, false);
    }
}
