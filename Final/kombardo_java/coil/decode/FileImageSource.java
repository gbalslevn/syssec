package coil.decode;

import coil.content.Utils;
import coil.decode.ImageSource;
import java.io.Closeable;
import kotlin.Metadata;
import okio.BufferedSource;
import okio.FileSystem;
import okio.Okio;
import okio.Path;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0014\u0010\u0010R\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\t\u001a\u0004\u0018\u00010\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u001eR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001f\u001a\u0004\b \u0010!R\u0016\u0010#\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010%¨\u0006&"}, d2 = {"Lcoil/decode/FileImageSource;", "Lcoil/decode/ImageSource;", "Lokio/Path;", "file", "Lokio/FileSystem;", "fileSystem", BuildConfig.FLAVOR, "diskCacheKey", "Ljava/io/Closeable;", "closeable", "Lcoil/decode/ImageSource$Metadata;", "metadata", "<init>", "(Lokio/Path;Lokio/FileSystem;Ljava/lang/String;Ljava/io/Closeable;Lcoil/decode/ImageSource$Metadata;)V", BuildConfig.FLAVOR, "assertNotClosed", "()V", "Lokio/BufferedSource;", "source", "()Lokio/BufferedSource;", "close", "Lokio/Path;", "getFile$coil_base_release", "()Lokio/Path;", "Lokio/FileSystem;", "getFileSystem", "()Lokio/FileSystem;", "Ljava/lang/String;", "getDiskCacheKey$coil_base_release", "()Ljava/lang/String;", "Ljava/io/Closeable;", "Lcoil/decode/ImageSource$Metadata;", "getMetadata", "()Lcoil/decode/ImageSource$Metadata;", BuildConfig.FLAVOR, "isClosed", "Z", "Lokio/BufferedSource;", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FileImageSource extends ImageSource {
    private final Closeable closeable;
    private final String diskCacheKey;
    private final Path file;
    private final FileSystem fileSystem;
    private boolean isClosed;
    private final ImageSource.Metadata metadata;
    private BufferedSource source;

    public FileImageSource(Path path, FileSystem fileSystem, String str, Closeable closeable, ImageSource.Metadata metadata) {
        super(null);
        this.file = path;
        this.fileSystem = fileSystem;
        this.diskCacheKey = str;
        this.closeable = closeable;
        this.metadata = metadata;
    }

    private final void assertNotClosed() {
        if (this.isClosed) {
            throw new IllegalStateException("closed");
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        try {
            this.isClosed = true;
            BufferedSource bufferedSource = this.source;
            if (bufferedSource != null) {
                Utils.closeQuietly(bufferedSource);
            }
            Closeable closeable = this.closeable;
            if (closeable != null) {
                Utils.closeQuietly(closeable);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* renamed from: getDiskCacheKey$coil_base_release, reason: from getter */
    public final String getDiskCacheKey() {
        return this.diskCacheKey;
    }

    public FileSystem getFileSystem() {
        return this.fileSystem;
    }

    @Override // coil.decode.ImageSource
    public ImageSource.Metadata getMetadata() {
        return this.metadata;
    }

    @Override // coil.decode.ImageSource
    public synchronized BufferedSource source() {
        assertNotClosed();
        BufferedSource bufferedSource = this.source;
        if (bufferedSource != null) {
            return bufferedSource;
        }
        BufferedSource buffer = Okio.buffer(getFileSystem().source(this.file));
        this.source = buffer;
        return buffer;
    }
}
