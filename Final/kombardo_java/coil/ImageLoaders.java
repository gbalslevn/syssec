package coil;

import android.content.Context;
import coil.ImageLoader;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Landroid/content/Context;", "context", "Lcoil/ImageLoader;", "create", "(Landroid/content/Context;)Lcoil/ImageLoader;", "ImageLoader", "coil-base_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class ImageLoaders {
    public static final ImageLoader create(Context context) {
        return new ImageLoader.Builder(context).build();
    }
}
