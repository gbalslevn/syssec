package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0017\u0010\u0005\u001a\u00020\u00068Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\u00020\u00068Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\n\u0010\b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u000b"}, d2 = {"Landroidx/compose/material/SnackbarDefaults;", BuildConfig.FLAVOR, "()V", "SnackbarOverlayAlpha", BuildConfig.FLAVOR, "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "getBackgroundColor", "(Landroidx/compose/runtime/Composer;I)J", "primaryActionColor", "getPrimaryActionColor", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SnackbarDefaults {
    public static final SnackbarDefaults INSTANCE = new SnackbarDefaults();
    private static final float SnackbarOverlayAlpha = 0.8f;

    private SnackbarDefaults() {
    }

    public final long getBackgroundColor(Composer composer, int i5) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1630911716, i5, -1, "androidx.compose.material.SnackbarDefaults.<get-backgroundColor> (Snackbar.kt:204)");
        }
        MaterialTheme materialTheme = MaterialTheme.INSTANCE;
        long m1505compositeOverOWjLjI = ColorKt.m1505compositeOverOWjLjI(Color.m1485copywmQWz5c$default(materialTheme.getColors(composer, 6).m666getOnSurface0d7_KjU(), SnackbarOverlayAlpha, 0.0f, 0.0f, 0.0f, 14, null), materialTheme.getColors(composer, 6).m671getSurface0d7_KjU());
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return m1505compositeOverOWjLjI;
    }

    public final long getPrimaryActionColor(Composer composer, int i5) {
        long m668getPrimaryVariant0d7_KjU;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-810329402, i5, -1, "androidx.compose.material.SnackbarDefaults.<get-primaryActionColor> (Snackbar.kt:224)");
        }
        Colors colors = MaterialTheme.INSTANCE.getColors(composer, 6);
        if (colors.isLight()) {
            m668getPrimaryVariant0d7_KjU = ColorKt.m1505compositeOverOWjLjI(Color.m1485copywmQWz5c$default(colors.m671getSurface0d7_KjU(), 0.6f, 0.0f, 0.0f, 0.0f, 14, null), colors.m667getPrimary0d7_KjU());
        } else {
            m668getPrimaryVariant0d7_KjU = colors.m668getPrimaryVariant0d7_KjU();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return m668getPrimaryVariant0d7_KjU;
    }
}
