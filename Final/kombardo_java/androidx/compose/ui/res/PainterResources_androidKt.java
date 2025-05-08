package androidx.compose.ui.res;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.util.TypedValue;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.painter.BitmapPainter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.VectorPainterKt;
import androidx.compose.ui.graphics.vector.compat.XmlVectorParser_androidKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.ImageVectorCache;
import com.sdk.growthbook.utils.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002\u001a1\u0010\n\u001a\u00020\u000b2\n\u0010\f\u001a\u00060\rR\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0003¢\u0006\u0002\u0010\u000f\u001a\u0017\u0010\u0010\u001a\u00020\u00112\b\b\u0001\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\u0012\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"errorMessage", BuildConfig.FLAVOR, "loadImageBitmapResource", "Landroidx/compose/ui/graphics/ImageBitmap;", "path", BuildConfig.FLAVOR, "res", "Landroid/content/res/Resources;", Constants.ID_ATTRIBUTE_KEY, BuildConfig.FLAVOR, "loadVectorResource", "Landroidx/compose/ui/graphics/vector/ImageVector;", "theme", "Landroid/content/res/Resources$Theme;", "changingConfigurations", "(Landroid/content/res/Resources$Theme;Landroid/content/res/Resources;IILandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/vector/ImageVector;", "painterResource", "Landroidx/compose/ui/graphics/painter/Painter;", "(ILandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/painter/Painter;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class PainterResources_androidKt {
    private static final String errorMessage = "Only VectorDrawables and rasterized asset types are supported ex. PNG, JPG, WEBP";

    private static final ImageBitmap loadImageBitmapResource(CharSequence charSequence, Resources resources, int i5) {
        try {
            return ImageResources_androidKt.imageResource(ImageBitmap.INSTANCE, resources, i5);
        } catch (Exception e5) {
            throw new ResourceResolutionException("Error attempting to load resource: " + ((Object) charSequence), e5);
        }
    }

    private static final ImageVector loadVectorResource(Resources.Theme theme, Resources resources, int i5, int i6, Composer composer, int i7) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(21855625, i7, -1, "androidx.compose.ui.res.loadVectorResource (PainterResources.android.kt:91)");
        }
        ImageVectorCache imageVectorCache = (ImageVectorCache) composer.consume(AndroidCompositionLocals_androidKt.getLocalImageVectorCache());
        ImageVectorCache.Key key = new ImageVectorCache.Key(theme, i5);
        ImageVectorCache.ImageVectorEntry imageVectorEntry = imageVectorCache.get(key);
        if (imageVectorEntry == null) {
            XmlResourceParser xml = resources.getXml(i5);
            if (!Intrinsics.areEqual(XmlVectorParser_androidKt.seekToStartTag(xml).getName(), "vector")) {
                throw new IllegalArgumentException(errorMessage);
            }
            imageVectorEntry = VectorResources_androidKt.loadVectorResourceInner(theme, resources, xml, i6);
            imageVectorCache.set(key, imageVectorEntry);
        }
        ImageVector imageVector = imageVectorEntry.getImageVector();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return imageVector;
    }

    public static final Painter painterResource(int i5, Composer composer, int i6) {
        Painter bitmapPainter;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(473971343, i6, -1, "androidx.compose.ui.res.painterResource (PainterResources.android.kt:57)");
        }
        Context context = (Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        composer.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration());
        Resources resources = context.getResources();
        TypedValue resolveResourcePath = ((ResourceIdCache) composer.consume(AndroidCompositionLocals_androidKt.getLocalResourceIdCache())).resolveResourcePath(resources, i5);
        CharSequence charSequence = resolveResourcePath.string;
        boolean z5 = true;
        if (charSequence == null || !StringsKt.endsWith$default(charSequence, (CharSequence) ".xml", false, 2, (Object) null)) {
            composer.startReplaceGroup(-802884675);
            Object theme = context.getTheme();
            boolean changed = composer.changed(charSequence);
            if ((((i6 & 14) ^ 6) <= 4 || !composer.changed(i5)) && (i6 & 6) != 4) {
                z5 = false;
            }
            boolean changed2 = changed | z5 | composer.changed(theme);
            Object rememberedValue = composer.rememberedValue();
            if (changed2 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = loadImageBitmapResource(charSequence, resources, i5);
                composer.updateRememberedValue(rememberedValue);
            }
            bitmapPainter = new BitmapPainter((ImageBitmap) rememberedValue, 0L, 0L, 6, null);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(-803040357);
            bitmapPainter = VectorPainterKt.rememberVectorPainter(loadVectorResource(context.getTheme(), resources, i5, resolveResourcePath.changingConfigurations, composer, (i6 << 6) & 896), composer, 0);
            composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return bitmapPainter;
    }
}
