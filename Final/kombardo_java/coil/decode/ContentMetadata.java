package coil.decode;

import android.net.Uri;
import coil.decode.ImageSource;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcoil/decode/ContentMetadata;", "Lcoil/decode/ImageSource$Metadata;", "Landroid/net/Uri;", "uri", "<init>", "(Landroid/net/Uri;)V", "Landroid/net/Uri;", "getUri", "()Landroid/net/Uri;", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ContentMetadata extends ImageSource.Metadata {
    private final Uri uri;

    public ContentMetadata(Uri uri) {
        this.uri = uri;
    }
}
