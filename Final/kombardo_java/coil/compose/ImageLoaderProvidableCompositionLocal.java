package coil.compose;

import android.content.Context;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import coil.Coil;
import coil.ImageLoader;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

@Deprecated
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0087@\u0018\u00002\u00020\u0001B\u001e\b\u0000\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00038GX\u0087\u0004¢\u0006\f\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b\u0088\u0001\u0004\u0092\u0001\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002ø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lcoil/compose/ImageLoaderProvidableCompositionLocal;", BuildConfig.FLAVOR, "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Lcoil/ImageLoader;", "delegate", "constructor-impl", "(Landroidx/compose/runtime/ProvidableCompositionLocal;)Landroidx/compose/runtime/ProvidableCompositionLocal;", "getCurrent", "(Landroidx/compose/runtime/ProvidableCompositionLocal;Landroidx/compose/runtime/Composer;I)Lcoil/ImageLoader;", "getCurrent$annotations", "()V", "current", "coil-compose-singleton_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class ImageLoaderProvidableCompositionLocal {
    /* renamed from: constructor-impl, reason: not valid java name */
    public static ProvidableCompositionLocal<ImageLoader> m2741constructorimpl(ProvidableCompositionLocal<ImageLoader> providableCompositionLocal) {
        return providableCompositionLocal;
    }

    /* renamed from: constructor-impl$default, reason: not valid java name */
    public static /* synthetic */ ProvidableCompositionLocal m2742constructorimpl$default(ProvidableCompositionLocal providableCompositionLocal, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i5 & 1) != 0) {
            providableCompositionLocal = CompositionLocalKt.staticCompositionLocalOf(new Function0<ImageLoader>() { // from class: coil.compose.ImageLoaderProvidableCompositionLocal.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final ImageLoader invoke() {
                    return null;
                }
            });
        }
        return m2741constructorimpl(providableCompositionLocal);
    }

    public static final ImageLoader getCurrent(ProvidableCompositionLocal<ImageLoader> providableCompositionLocal, Composer composer, int i5) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-617597678, i5, -1, "coil.compose.ImageLoaderProvidableCompositionLocal.<get-current> (LocalImageLoader.kt:49)");
        }
        ImageLoader imageLoader = (ImageLoader) composer.consume(providableCompositionLocal);
        if (imageLoader == null) {
            imageLoader = Coil.imageLoader((Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext()));
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return imageLoader;
    }
}
