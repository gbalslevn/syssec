package coil.compose;

import androidx.compose.runtime.ProvidableCompositionLocal;
import coil.ImageLoader;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\"\u0014\u0010\u0001\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0001\u0010\u0002\"#\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004ø\u0001\u0000¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {BuildConfig.FLAVOR, "DEPRECATION_MESSAGE", "Ljava/lang/String;", "Lcoil/compose/ImageLoaderProvidableCompositionLocal;", "LocalImageLoader", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "getLocalImageLoader", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "getLocalImageLoader$annotations", "()V", "coil-compose-singleton_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class LocalImageLoaderKt {
    private static final String DEPRECATION_MESSAGE = "LocalImageLoader was intended to provide a method to overwrite the singleton ImageLoader in local compositions. In practice, it's not clear that `LocalImageLoader.provide` **does not** set the singleton ImageLoader. This can result in accidentally creating multiple ImageLoader instances if you use a combination of `LocalImageLoader.current` and `context.imageLoader`. To maximize performance, apps should create one ImageLoader or use `ImageLoader.newBuilder` to create new ImageLoaders that share the same resources.\n\nAdditionally, as a composition is at most scoped to an Activity, `LocalImageLoader.provide` encourages creating multiple ImageLoaders if the user creates multiple activities that use Compose.\n\nYou should migrate to `ImageLoaderFactory` to set the singleton ImageLoader and `LocalContext.current.imageLoader` to access the singleton ImageLoader in Compose. If you need to use a locally scoped ImageLoader it's recommended to use the `AsyncImage` and `rememberAsyncImagePainter` overloads that have an ImageLoader argument and pass the local ImageLoader as input.";
    private static final ProvidableCompositionLocal<ImageLoader> LocalImageLoader = ImageLoaderProvidableCompositionLocal.m2742constructorimpl$default(null, 1, null);

    public static final ProvidableCompositionLocal<ImageLoader> getLocalImageLoader() {
        return LocalImageLoader;
    }
}
