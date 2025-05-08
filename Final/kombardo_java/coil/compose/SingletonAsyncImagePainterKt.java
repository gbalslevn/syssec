package coil.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import coil.compose.AsyncImagePainter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aa\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b\u0018\u00010\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\r\u0010\u000e\u001a\u009f\u0001\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00102\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\b\u0018\u00010\u00052\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u00052\u0016\b\u0002\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\b\u0018\u00010\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u001a\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"rememberAsyncImagePainter", "Lcoil/compose/AsyncImagePainter;", "model", BuildConfig.FLAVOR, "transform", "Lkotlin/Function1;", "Lcoil/compose/AsyncImagePainter$State;", "onState", BuildConfig.FLAVOR, "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "rememberAsyncImagePainter-19ie5dc", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/layout/ContentScale;ILandroidx/compose/runtime/Composer;II)Lcoil/compose/AsyncImagePainter;", "placeholder", "Landroidx/compose/ui/graphics/painter/Painter;", "error", "fallback", "onLoading", "Lcoil/compose/AsyncImagePainter$State$Loading;", "onSuccess", "Lcoil/compose/AsyncImagePainter$State$Success;", "onError", "Lcoil/compose/AsyncImagePainter$State$Error;", "rememberAsyncImagePainter-MqR-F_0", "(Ljava/lang/Object;Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/layout/ContentScale;ILandroidx/compose/runtime/Composer;II)Lcoil/compose/AsyncImagePainter;", "coil-compose-singleton_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class SingletonAsyncImagePainterKt {
    /* renamed from: rememberAsyncImagePainter-19ie5dc, reason: not valid java name */
    public static final AsyncImagePainter m2744rememberAsyncImagePainter19ie5dc(Object obj, Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function1, Function1<? super AsyncImagePainter.State, Unit> function12, ContentScale contentScale, int i5, Composer composer, int i6, int i7) {
        composer.startReplaceableGroup(-1494234083);
        Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> defaultTransform = (i7 & 2) != 0 ? AsyncImagePainter.INSTANCE.getDefaultTransform() : function1;
        Function1<? super AsyncImagePainter.State, Unit> function13 = (i7 & 4) != 0 ? null : function12;
        ContentScale fit = (i7 & 8) != 0 ? ContentScale.INSTANCE.getFit() : contentScale;
        int m1705getDefaultFilterQualityfv9h1I = (i7 & 16) != 0 ? DrawScope.INSTANCE.m1705getDefaultFilterQualityfv9h1I() : i5;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1494234083, i6, -1, "coil.compose.rememberAsyncImagePainter (SingletonAsyncImagePainter.kt:91)");
        }
        int i8 = i6 << 3;
        AsyncImagePainter m2735rememberAsyncImagePainter5jETZwI = AsyncImagePainterKt.m2735rememberAsyncImagePainter5jETZwI(obj, ImageLoaderProvidableCompositionLocal.getCurrent(LocalImageLoaderKt.getLocalImageLoader(), composer, 6), defaultTransform, function13, fit, m1705getDefaultFilterQualityfv9h1I, composer, (i8 & 896) | 72 | (i8 & 7168) | (57344 & i8) | (i8 & 458752), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return m2735rememberAsyncImagePainter5jETZwI;
    }

    /* renamed from: rememberAsyncImagePainter-MqR-F_0, reason: not valid java name */
    public static final AsyncImagePainter m2745rememberAsyncImagePainterMqRF_0(Object obj, Painter painter, Painter painter2, Painter painter3, Function1<? super AsyncImagePainter.State.Loading, Unit> function1, Function1<? super AsyncImagePainter.State.Success, Unit> function12, Function1<? super AsyncImagePainter.State.Error, Unit> function13, ContentScale contentScale, int i5, Composer composer, int i6, int i7) {
        composer.startReplaceableGroup(533921043);
        Painter painter4 = (i7 & 2) != 0 ? null : painter;
        Painter painter5 = (i7 & 4) != 0 ? null : painter2;
        Painter painter6 = (i7 & 8) != 0 ? painter5 : painter3;
        Function1<? super AsyncImagePainter.State.Loading, Unit> function14 = (i7 & 16) != 0 ? null : function1;
        Function1<? super AsyncImagePainter.State.Success, Unit> function15 = (i7 & 32) != 0 ? null : function12;
        Function1<? super AsyncImagePainter.State.Error, Unit> function16 = (i7 & 64) != 0 ? null : function13;
        ContentScale fit = (i7 & 128) != 0 ? ContentScale.INSTANCE.getFit() : contentScale;
        int m1705getDefaultFilterQualityfv9h1I = (i7 & 256) != 0 ? DrawScope.INSTANCE.m1705getDefaultFilterQualityfv9h1I() : i5;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(533921043, i6, -1, "coil.compose.rememberAsyncImagePainter (SingletonAsyncImagePainter.kt:44)");
        }
        int i8 = i6 << 3;
        AsyncImagePainter m2734rememberAsyncImagePainter3HmZ8SU = AsyncImagePainterKt.m2734rememberAsyncImagePainter3HmZ8SU(obj, ImageLoaderProvidableCompositionLocal.getCurrent(LocalImageLoaderKt.getLocalImageLoader(), composer, 6), painter4, painter5, painter6, function14, function15, function16, fit, m1705getDefaultFilterQualityfv9h1I, composer, (458752 & i8) | 37448 | (3670016 & i8) | (29360128 & i8) | (234881024 & i8) | (i8 & 1879048192), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return m2734rememberAsyncImagePainter3HmZ8SU;
    }
}
