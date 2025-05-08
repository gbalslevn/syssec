package androidx.compose.material;

import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001d\u0010\u000b\u001a\u00020\n8\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0012\u001a\u00020\u000f8Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0016\u001a\u00020\u00138G¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0018\u001a\u00020\u000f8Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0011\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0019"}, d2 = {"Landroidx/compose/material/DrawerDefaults;", BuildConfig.FLAVOR, "<init>", "()V", "Landroidx/compose/animation/core/TweenSpec;", BuildConfig.FLAVOR, "AnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "getAnimationSpec", "()Landroidx/compose/animation/core/TweenSpec;", "Landroidx/compose/ui/unit/Dp;", "Elevation", "F", "getElevation-D9Ej5fM", "()F", "Landroidx/compose/ui/graphics/Color;", "getBackgroundColor", "(Landroidx/compose/runtime/Composer;I)J", "backgroundColor", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "shape", "getScrimColor", "scrimColor", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DrawerDefaults {
    public static final DrawerDefaults INSTANCE = new DrawerDefaults();
    private static final TweenSpec<Float> AnimationSpec = new TweenSpec<>(256, 0, null, 6, null);
    private static final float Elevation = Dp.m2599constructorimpl(16);

    private DrawerDefaults() {
    }

    public final long getBackgroundColor(Composer composer, int i5) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-788676020, i5, -1, "androidx.compose.material.DrawerDefaults.<get-backgroundColor> (Drawer.kt:758)");
        }
        long m671getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composer, 6).m671getSurface0d7_KjU();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return m671getSurface0d7_KjU;
    }

    /* renamed from: getElevation-D9Ej5fM, reason: not valid java name */
    public final float m688getElevationD9Ej5fM() {
        return Elevation;
    }

    public final long getScrimColor(Composer composer, int i5) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(617225966, i5, -1, "androidx.compose.material.DrawerDefaults.<get-scrimColor> (Drawer.kt:777)");
        }
        long m1485copywmQWz5c$default = Color.m1485copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m666getOnSurface0d7_KjU(), 0.32f, 0.0f, 0.0f, 0.0f, 14, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return m1485copywmQWz5c$default;
    }

    public final Shape getShape(Composer composer, int i5) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2041803618, i5, -1, "androidx.compose.material.DrawerDefaults.<get-shape> (Drawer.kt:770)");
        }
        CornerBasedShape large = MaterialTheme.INSTANCE.getShapes(composer, 6).getLarge();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return large;
    }
}
