package coil.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.ContentScale;
import coil.compose.AsyncImagePainter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000B\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0095\u0001\u0010\u0017\u001a\u00020\t2\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00062\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t\u0018\u00010\u00062\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u0013H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {BuildConfig.FLAVOR, "model", BuildConfig.FLAVOR, "contentDescription", "Landroidx/compose/ui/Modifier;", "modifier", "Lkotlin/Function1;", "Lcoil/compose/AsyncImagePainter$State;", "transform", BuildConfig.FLAVOR, "onState", "Landroidx/compose/ui/Alignment;", "alignment", "Landroidx/compose/ui/layout/ContentScale;", "contentScale", BuildConfig.FLAVOR, "alpha", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", "Landroidx/compose/ui/graphics/FilterQuality;", "filterQuality", "AsyncImage-3HmZ8SU", "(Ljava/lang/Object;Ljava/lang/String;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;ILandroidx/compose/runtime/Composer;II)V", "AsyncImage", "coil-compose-singleton_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class SingletonAsyncImageKt {
    /* renamed from: AsyncImage-3HmZ8SU, reason: not valid java name */
    public static final void m2743AsyncImage3HmZ8SU(Object obj, String str, Modifier modifier, Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function1, Function1<? super AsyncImagePainter.State, Unit> function12, Alignment alignment, ContentScale contentScale, float f5, ColorFilter colorFilter, int i5, Composer composer, int i6, int i7) {
        composer.startReplaceableGroup(-941517612);
        Modifier modifier2 = (i7 & 4) != 0 ? Modifier.INSTANCE : modifier;
        Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> defaultTransform = (i7 & 8) != 0 ? AsyncImagePainter.INSTANCE.getDefaultTransform() : function1;
        Function1<? super AsyncImagePainter.State, Unit> function13 = (i7 & 16) != 0 ? null : function12;
        Alignment center = (i7 & 32) != 0 ? Alignment.INSTANCE.getCenter() : alignment;
        ContentScale fit = (i7 & 64) != 0 ? ContentScale.INSTANCE.getFit() : contentScale;
        float f6 = (i7 & 128) != 0 ? 1.0f : f5;
        ColorFilter colorFilter2 = (i7 & 256) != 0 ? null : colorFilter;
        int m1705getDefaultFilterQualityfv9h1I = (i7 & 512) != 0 ? DrawScope.INSTANCE.m1705getDefaultFilterQualityfv9h1I() : i5;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-941517612, i6, -1, "coil.compose.AsyncImage (SingletonAsyncImage.kt:102)");
        }
        int i8 = i6 << 3;
        AsyncImageKt.m2728AsyncImageMvsnxeU(obj, str, ImageLoaderProvidableCompositionLocal.getCurrent(LocalImageLoaderKt.getLocalImageLoader(), composer, 6), modifier2, defaultTransform, function13, center, fit, f6, colorFilter2, m1705getDefaultFilterQualityfv9h1I, composer, (i6 & 112) | 520 | (i8 & 7168) | (57344 & i8) | (458752 & i8) | (3670016 & i8) | (29360128 & i8) | (234881024 & i8) | (i8 & 1879048192), (i6 >> 27) & 14, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }
}
