package coil.compose;

import android.graphics.drawable.Drawable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.platform.InspectionModeKt;
import coil.ImageLoader;
import coil.compose.AsyncImagePainter;
import coil.request.ImageRequest;
import coil.size.Dimension;
import coil.size.Dimensions;
import coil.transition.TransitionTarget;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.math.MathKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000}\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0001\u001ai\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u000f2\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a§\u0001\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001a2\u0016\b\u0002\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000f2\u0016\b\u0002\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000f2\u0016\b\u0002\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a\u001a\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020(H\u0002\u001a\u0010\u0010*\u001a\u00020\u00122\u0006\u0010+\u001a\u00020,H\u0002\u001a\u001b\u0010-\u001a\u0004\u0018\u00010.*\u00020\u0005H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b/\u00100\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u001b\u0010\u0003\u001a\u00020\u0004*\u00020\u00058BX\u0082\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u00061"}, d2 = {"FakeTransitionTarget", "coil/compose/AsyncImagePainterKt$FakeTransitionTarget$1", "Lcoil/compose/AsyncImagePainterKt$FakeTransitionTarget$1;", "isPositive", BuildConfig.FLAVOR, "Landroidx/compose/ui/geometry/Size;", "isPositive-uvyYCjk", "(J)Z", "rememberAsyncImagePainter", "Lcoil/compose/AsyncImagePainter;", "model", BuildConfig.FLAVOR, "imageLoader", "Lcoil/ImageLoader;", "transform", "Lkotlin/Function1;", "Lcoil/compose/AsyncImagePainter$State;", "onState", BuildConfig.FLAVOR, "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "rememberAsyncImagePainter-5jETZwI", "(Ljava/lang/Object;Lcoil/ImageLoader;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/layout/ContentScale;ILandroidx/compose/runtime/Composer;II)Lcoil/compose/AsyncImagePainter;", "placeholder", "Landroidx/compose/ui/graphics/painter/Painter;", "error", "fallback", "onLoading", "Lcoil/compose/AsyncImagePainter$State$Loading;", "onSuccess", "Lcoil/compose/AsyncImagePainter$State$Success;", "onError", "Lcoil/compose/AsyncImagePainter$State$Error;", "rememberAsyncImagePainter-3HmZ8SU", "(Ljava/lang/Object;Lcoil/ImageLoader;Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/layout/ContentScale;ILandroidx/compose/runtime/Composer;II)Lcoil/compose/AsyncImagePainter;", "unsupportedData", BuildConfig.FLAVOR, "name", BuildConfig.FLAVOR, "description", "validateRequest", "request", "Lcoil/request/ImageRequest;", "toSizeOrNull", "Lcoil/size/Size;", "toSizeOrNull-uvyYCjk", "(J)Lcoil/size/Size;", "coil-compose-base_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class AsyncImagePainterKt {
    private static final AsyncImagePainterKt$FakeTransitionTarget$1 FakeTransitionTarget = new TransitionTarget() { // from class: coil.compose.AsyncImagePainterKt$FakeTransitionTarget$1
        @Override // coil.transition.TransitionTarget
        public Drawable getDrawable() {
            return null;
        }
    };

    /* renamed from: isPositive-uvyYCjk */
    private static final boolean m2733isPositiveuvyYCjk(long j5) {
        return ((double) Size.m1377getWidthimpl(j5)) >= 0.5d && ((double) Size.m1375getHeightimpl(j5)) >= 0.5d;
    }

    /* renamed from: rememberAsyncImagePainter-3HmZ8SU */
    public static final AsyncImagePainter m2734rememberAsyncImagePainter3HmZ8SU(Object obj, ImageLoader imageLoader, Painter painter, Painter painter2, Painter painter3, Function1<? super AsyncImagePainter.State.Loading, Unit> function1, Function1<? super AsyncImagePainter.State.Success, Unit> function12, Function1<? super AsyncImagePainter.State.Error, Unit> function13, ContentScale contentScale, int i5, Composer composer, int i6, int i7) {
        composer.startReplaceableGroup(2140758544);
        Painter painter4 = (i7 & 4) != 0 ? null : painter;
        Painter painter5 = (i7 & 8) != 0 ? null : painter2;
        Painter painter6 = (i7 & 16) != 0 ? painter5 : painter3;
        Function1<? super AsyncImagePainter.State.Loading, Unit> function14 = (i7 & 32) != 0 ? null : function1;
        Function1<? super AsyncImagePainter.State.Success, Unit> function15 = (i7 & 64) != 0 ? null : function12;
        Function1<? super AsyncImagePainter.State.Error, Unit> function16 = (i7 & 128) == 0 ? function13 : null;
        ContentScale fit = (i7 & 256) != 0 ? ContentScale.INSTANCE.getFit() : contentScale;
        int m1705getDefaultFilterQualityfv9h1I = (i7 & 512) != 0 ? DrawScope.INSTANCE.m1705getDefaultFilterQualityfv9h1I() : i5;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2140758544, i6, -1, "coil.compose.rememberAsyncImagePainter (AsyncImagePainter.kt:83)");
        }
        int i8 = i6 >> 12;
        AsyncImagePainter m2735rememberAsyncImagePainter5jETZwI = m2735rememberAsyncImagePainter5jETZwI(obj, imageLoader, UtilsKt.transformOf(painter4, painter5, painter6), UtilsKt.onStateOf(function14, function15, function16), fit, m1705getDefaultFilterQualityfv9h1I, composer, (57344 & i8) | 72 | (i8 & 458752), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return m2735rememberAsyncImagePainter5jETZwI;
    }

    /* renamed from: rememberAsyncImagePainter-5jETZwI */
    public static final AsyncImagePainter m2735rememberAsyncImagePainter5jETZwI(Object obj, ImageLoader imageLoader, Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function1, Function1<? super AsyncImagePainter.State, Unit> function12, ContentScale contentScale, int i5, Composer composer, int i6, int i7) {
        composer.startReplaceableGroup(-2020614074);
        if ((i7 & 4) != 0) {
            function1 = AsyncImagePainter.INSTANCE.getDefaultTransform();
        }
        if ((i7 & 8) != 0) {
            function12 = null;
        }
        if ((i7 & 16) != 0) {
            contentScale = ContentScale.INSTANCE.getFit();
        }
        if ((i7 & 32) != 0) {
            i5 = DrawScope.INSTANCE.m1705getDefaultFilterQualityfv9h1I();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2020614074, i6, -1, "coil.compose.rememberAsyncImagePainter (AsyncImagePainter.kt:128)");
        }
        ImageRequest requestOf = UtilsKt.requestOf(obj, composer, 8);
        validateRequest(requestOf);
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new AsyncImagePainter(requestOf, imageLoader);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        AsyncImagePainter asyncImagePainter = (AsyncImagePainter) rememberedValue;
        asyncImagePainter.setTransform$coil_compose_base_release(function1);
        asyncImagePainter.setOnState$coil_compose_base_release(function12);
        asyncImagePainter.setContentScale$coil_compose_base_release(contentScale);
        asyncImagePainter.m2731setFilterQualityvDHp3xo$coil_compose_base_release(i5);
        asyncImagePainter.setPreview$coil_compose_base_release(((Boolean) composer.consume(InspectionModeKt.getLocalInspectionMode())).booleanValue());
        asyncImagePainter.setImageLoader$coil_compose_base_release(imageLoader);
        asyncImagePainter.setRequest$coil_compose_base_release(requestOf);
        asyncImagePainter.onRemembered();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return asyncImagePainter;
    }

    /* renamed from: toSizeOrNull-uvyYCjk */
    public static final coil.size.Size m2736toSizeOrNulluvyYCjk(long j5) {
        if (j5 == Size.INSTANCE.m1383getUnspecifiedNHjbRc()) {
            return coil.size.Size.ORIGINAL;
        }
        if (!m2733isPositiveuvyYCjk(j5)) {
            return null;
        }
        float m1377getWidthimpl = Size.m1377getWidthimpl(j5);
        Dimension Dimension = (Float.isInfinite(m1377getWidthimpl) || Float.isNaN(m1377getWidthimpl)) ? Dimension.Undefined.INSTANCE : Dimensions.Dimension(MathKt.roundToInt(Size.m1377getWidthimpl(j5)));
        float m1375getHeightimpl = Size.m1375getHeightimpl(j5);
        return new coil.size.Size(Dimension, (Float.isInfinite(m1375getHeightimpl) || Float.isNaN(m1375getHeightimpl)) ? Dimension.Undefined.INSTANCE : Dimensions.Dimension(MathKt.roundToInt(Size.m1375getHeightimpl(j5))));
    }

    private static final Void unsupportedData(String str, String str2) {
        throw new IllegalArgumentException("Unsupported type: " + str + ". " + str2);
    }

    static /* synthetic */ Void unsupportedData$default(String str, String str2, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            str2 = "If you wish to display this " + str + ", use androidx.compose.foundation.Image.";
        }
        return unsupportedData(str, str2);
    }

    private static final void validateRequest(ImageRequest imageRequest) {
        Object data = imageRequest.getData();
        if (data instanceof ImageRequest.Builder) {
            unsupportedData("ImageRequest.Builder", "Did you forget to call ImageRequest.Builder.build()?");
            throw new KotlinNothingValueException();
        }
        if (data instanceof ImageBitmap) {
            unsupportedData$default("ImageBitmap", null, 2, null);
            throw new KotlinNothingValueException();
        }
        if (data instanceof ImageVector) {
            unsupportedData$default("ImageVector", null, 2, null);
            throw new KotlinNothingValueException();
        }
        if (data instanceof Painter) {
            unsupportedData$default("Painter", null, 2, null);
            throw new KotlinNothingValueException();
        }
        if (imageRequest.getTarget() != null) {
            throw new IllegalArgumentException("request.target must be null.");
        }
    }
}
