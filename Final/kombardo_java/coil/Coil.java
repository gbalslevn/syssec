package coil;

import android.content.Context;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\bR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\nR\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcoil/Coil;", BuildConfig.FLAVOR, "<init>", "()V", "Landroid/content/Context;", "context", "Lcoil/ImageLoader;", "imageLoader", "(Landroid/content/Context;)Lcoil/ImageLoader;", "newImageLoader", "Lcoil/ImageLoader;", "Lcoil/ImageLoaderFactory;", "imageLoaderFactory", "Lcoil/ImageLoaderFactory;", "coil-singleton_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Coil {
    public static final Coil INSTANCE = new Coil();
    private static ImageLoader imageLoader;
    private static ImageLoaderFactory imageLoaderFactory;

    private Coil() {
    }

    public static final ImageLoader imageLoader(Context context) {
        ImageLoader imageLoader2 = imageLoader;
        return imageLoader2 == null ? INSTANCE.newImageLoader(context) : imageLoader2;
    }

    private final synchronized ImageLoader newImageLoader(Context context) {
        ImageLoader newImageLoader;
        try {
            ImageLoader imageLoader2 = imageLoader;
            if (imageLoader2 != null) {
                return imageLoader2;
            }
            ImageLoaderFactory imageLoaderFactory2 = imageLoaderFactory;
            if (imageLoaderFactory2 != null) {
                newImageLoader = imageLoaderFactory2.newImageLoader();
                if (newImageLoader == null) {
                }
                imageLoaderFactory = null;
                imageLoader = newImageLoader;
                return newImageLoader;
            }
            Object applicationContext = context.getApplicationContext();
            ImageLoaderFactory imageLoaderFactory3 = applicationContext instanceof ImageLoaderFactory ? (ImageLoaderFactory) applicationContext : null;
            newImageLoader = imageLoaderFactory3 != null ? imageLoaderFactory3.newImageLoader() : ImageLoaders.create(context);
            imageLoaderFactory = null;
            imageLoader = newImageLoader;
            return newImageLoader;
        } catch (Throwable th) {
            throw th;
        }
    }
}
