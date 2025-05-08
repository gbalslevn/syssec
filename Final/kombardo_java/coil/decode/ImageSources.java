package coil.decode;

import android.content.Context;
import coil.content.Utils;
import coil.decode.ImageSource;
import java.io.Closeable;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import okio.BufferedSource;
import okio.FileSystem;
import okio.Path;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a9\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b\t\u0010\n\u001a\u001f\u0010\u000b\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\t\u0010\u0010\u001a+\u0010\u000b\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0004\b\t\u0010\u0013¨\u0006\u0014"}, d2 = {"Lokio/Path;", "file", "Lokio/FileSystem;", "fileSystem", BuildConfig.FLAVOR, "diskCacheKey", "Ljava/io/Closeable;", "closeable", "Lcoil/decode/ImageSource;", "create", "(Lokio/Path;Lokio/FileSystem;Ljava/lang/String;Ljava/io/Closeable;)Lcoil/decode/ImageSource;", "ImageSource", "Lokio/BufferedSource;", "source", "Landroid/content/Context;", "context", "(Lokio/BufferedSource;Landroid/content/Context;)Lcoil/decode/ImageSource;", "Lcoil/decode/ImageSource$Metadata;", "metadata", "(Lokio/BufferedSource;Landroid/content/Context;Lcoil/decode/ImageSource$Metadata;)Lcoil/decode/ImageSource;", "coil-base_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class ImageSources {
    public static final ImageSource create(Path path, FileSystem fileSystem, String str, Closeable closeable) {
        return new FileImageSource(path, fileSystem, str, closeable, null);
    }

    public static /* synthetic */ ImageSource create$default(Path path, FileSystem fileSystem, String str, Closeable closeable, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            fileSystem = FileSystem.SYSTEM;
        }
        if ((i5 & 4) != 0) {
            str = null;
        }
        if ((i5 & 8) != 0) {
            closeable = null;
        }
        return create(path, fileSystem, str, closeable);
    }

    public static final ImageSource create(BufferedSource bufferedSource, final Context context) {
        return new SourceImageSource(bufferedSource, new Function0<File>() { // from class: coil.decode.ImageSources$ImageSource$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final File invoke() {
                return Utils.getSafeCacheDir(context);
            }
        }, null);
    }

    public static final ImageSource create(BufferedSource bufferedSource, final Context context, ImageSource.Metadata metadata) {
        return new SourceImageSource(bufferedSource, new Function0<File>() { // from class: coil.decode.ImageSources$ImageSource$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final File invoke() {
                return Utils.getSafeCacheDir(context);
            }
        }, metadata);
    }
}
