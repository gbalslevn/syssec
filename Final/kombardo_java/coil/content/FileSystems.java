package coil.content;

import java.io.FileNotFoundException;
import java.io.IOException;
import kotlin.Metadata;
import okio.FileSystem;
import okio.Path;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u0014\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0004H\u0000¨\u0006\u0007"}, d2 = {"createFile", BuildConfig.FLAVOR, "Lokio/FileSystem;", "file", "Lokio/Path;", "deleteContents", "directory", "coil-base_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* renamed from: coil.util.-FileSystems, reason: invalid class name */
/* loaded from: classes.dex */
public abstract class FileSystems {
    public static final void createFile(FileSystem fileSystem, Path path) {
        if (fileSystem.exists(path)) {
            return;
        }
        Utils.closeQuietly(fileSystem.sink(path));
    }

    public static final void deleteContents(FileSystem fileSystem, Path path) {
        try {
            IOException iOException = null;
            for (Path path2 : fileSystem.list(path)) {
                try {
                    if (fileSystem.metadata(path2).getIsDirectory()) {
                        deleteContents(fileSystem, path2);
                    }
                    fileSystem.delete(path2);
                } catch (IOException e5) {
                    if (iOException == null) {
                        iOException = e5;
                    }
                }
            }
            if (iOException != null) {
                throw iOException;
            }
        } catch (FileNotFoundException unused) {
        }
    }
}
