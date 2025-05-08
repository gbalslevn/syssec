package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J:\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\u001e\u0010\u0012\u001a\u00020\u0004*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0007H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0013"}, d2 = {"Landroidx/compose/material3/IconButtonDefaults;", BuildConfig.FLAVOR, "<init>", "()V", "Landroidx/compose/material3/IconButtonColors;", "iconButtonColors", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/IconButtonColors;", "Landroidx/compose/ui/graphics/Color;", "containerColor", "contentColor", "disabledContainerColor", "disabledContentColor", "iconButtonColors-ro_MJ88", "(JJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/IconButtonColors;", "Landroidx/compose/material3/ColorScheme;", "localContentColor", "defaultIconButtonColors-4WTKRHQ$material3_release", "(Landroidx/compose/material3/ColorScheme;J)Landroidx/compose/material3/IconButtonColors;", "defaultIconButtonColors", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class IconButtonDefaults {
    public static final int $stable = 0;
    public static final IconButtonDefaults INSTANCE = new IconButtonDefaults();

    private IconButtonDefaults() {
    }

    /* renamed from: defaultIconButtonColors-4WTKRHQ$material3_release, reason: not valid java name */
    public final IconButtonColors m855defaultIconButtonColors4WTKRHQ$material3_release(ColorScheme colorScheme, long j5) {
        IconButtonColors defaultIconButtonColorsCached = colorScheme.getDefaultIconButtonColorsCached();
        if (defaultIconButtonColorsCached != null) {
            return defaultIconButtonColorsCached;
        }
        Color.Companion companion = Color.INSTANCE;
        IconButtonColors iconButtonColors = new IconButtonColors(companion.m1500getTransparent0d7_KjU(), j5, companion.m1500getTransparent0d7_KjU(), Color.m1485copywmQWz5c$default(j5, 0.38f, 0.0f, 0.0f, 0.0f, 14, null), null);
        colorScheme.setDefaultIconButtonColorsCached$material3_release(iconButtonColors);
        return iconButtonColors;
    }

    public final IconButtonColors iconButtonColors(Composer composer, int i5) {
        IconButtonColors m853copyjRlVdoo;
        composer.startReplaceGroup(-1519621781);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1519621781, i5, -1, "androidx.compose.material3.IconButtonDefaults.iconButtonColors (IconButton.kt:592)");
        }
        long value = ((Color) composer.consume(ContentColorKt.getLocalContentColor())).getValue();
        IconButtonColors m855defaultIconButtonColors4WTKRHQ$material3_release = m855defaultIconButtonColors4WTKRHQ$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6), value);
        if (Color.m1487equalsimpl0(m855defaultIconButtonColors4WTKRHQ$material3_release.getContentColor(), value)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return m855defaultIconButtonColors4WTKRHQ$material3_release;
        }
        m853copyjRlVdoo = m855defaultIconButtonColors4WTKRHQ$material3_release.m853copyjRlVdoo((r18 & 1) != 0 ? m855defaultIconButtonColors4WTKRHQ$material3_release.containerColor : 0L, (r18 & 2) != 0 ? m855defaultIconButtonColors4WTKRHQ$material3_release.contentColor : value, (r18 & 4) != 0 ? m855defaultIconButtonColors4WTKRHQ$material3_release.disabledContainerColor : 0L, (r18 & 8) != 0 ? m855defaultIconButtonColors4WTKRHQ$material3_release.disabledContentColor : Color.m1485copywmQWz5c$default(value, 0.38f, 0.0f, 0.0f, 0.0f, 14, null));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return m853copyjRlVdoo;
    }

    /* renamed from: iconButtonColors-ro_MJ88, reason: not valid java name */
    public final IconButtonColors m856iconButtonColorsro_MJ88(long j5, long j6, long j7, long j8, Composer composer, int i5, int i6) {
        long m1501getUnspecified0d7_KjU = (i6 & 1) != 0 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : j5;
        long value = (i6 & 2) != 0 ? ((Color) composer.consume(ContentColorKt.getLocalContentColor())).getValue() : j6;
        long m1501getUnspecified0d7_KjU2 = (i6 & 4) != 0 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : j7;
        long m1485copywmQWz5c$default = (i6 & 8) != 0 ? Color.m1485copywmQWz5c$default(value, 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j8;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(999008085, i5, -1, "androidx.compose.material3.IconButtonDefaults.iconButtonColors (IconButton.kt:622)");
        }
        IconButtonColors m853copyjRlVdoo = m855defaultIconButtonColors4WTKRHQ$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6), ((Color) composer.consume(ContentColorKt.getLocalContentColor())).getValue()).m853copyjRlVdoo(m1501getUnspecified0d7_KjU, value, m1501getUnspecified0d7_KjU2, m1485copywmQWz5c$default);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return m853copyjRlVdoo;
    }
}
