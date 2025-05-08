package androidx.compose.material3;

import androidx.compose.material3.tokens.NavigationBarTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0006JX\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0014\u001a\u00020\u0004*\u00020\u00118@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0015"}, d2 = {"Landroidx/compose/material3/NavigationBarItemDefaults;", BuildConfig.FLAVOR, "<init>", "()V", "Landroidx/compose/material3/NavigationBarItemColors;", "colors", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/NavigationBarItemColors;", "Landroidx/compose/ui/graphics/Color;", "selectedIconColor", "selectedTextColor", "indicatorColor", "unselectedIconColor", "unselectedTextColor", "disabledIconColor", "disabledTextColor", "colors-69fazGs", "(JJJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/NavigationBarItemColors;", "Landroidx/compose/material3/ColorScheme;", "getDefaultNavigationBarItemColors$material3_release", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/NavigationBarItemColors;", "defaultNavigationBarItemColors", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class NavigationBarItemDefaults {
    public static final int $stable = 0;
    public static final NavigationBarItemDefaults INSTANCE = new NavigationBarItemDefaults();

    private NavigationBarItemDefaults() {
    }

    public final NavigationBarItemColors colors(Composer composer, int i5) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1018883954, i5, -1, "androidx.compose.material3.NavigationBarItemDefaults.colors (NavigationBar.kt:311)");
        }
        NavigationBarItemColors defaultNavigationBarItemColors$material3_release = getDefaultNavigationBarItemColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return defaultNavigationBarItemColors$material3_release;
    }

    /* renamed from: colors-69fazGs, reason: not valid java name */
    public final NavigationBarItemColors m872colors69fazGs(long j5, long j6, long j7, long j8, long j9, long j10, long j11, Composer composer, int i5, int i6) {
        long j12;
        long m1501getUnspecified0d7_KjU = (i6 & 1) != 0 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : j5;
        long m1501getUnspecified0d7_KjU2 = (i6 & 2) != 0 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : j6;
        long m1501getUnspecified0d7_KjU3 = (i6 & 4) != 0 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : j7;
        long m1501getUnspecified0d7_KjU4 = (i6 & 8) != 0 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : j8;
        long m1501getUnspecified0d7_KjU5 = (i6 & 16) != 0 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : j9;
        long m1501getUnspecified0d7_KjU6 = (i6 & 32) != 0 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : j10;
        long m1501getUnspecified0d7_KjU7 = (i6 & 64) != 0 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : j11;
        if (ComposerKt.isTraceInProgress()) {
            j12 = m1501getUnspecified0d7_KjU7;
            ComposerKt.traceEventStart(-1618564327, i5, -1, "androidx.compose.material3.NavigationBarItemDefaults.colors (NavigationBar.kt:336)");
        } else {
            j12 = m1501getUnspecified0d7_KjU7;
        }
        NavigationBarItemColors m868copy4JmcsL4 = getDefaultNavigationBarItemColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).m868copy4JmcsL4(m1501getUnspecified0d7_KjU, m1501getUnspecified0d7_KjU2, m1501getUnspecified0d7_KjU3, m1501getUnspecified0d7_KjU4, m1501getUnspecified0d7_KjU5, m1501getUnspecified0d7_KjU6, j12);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return m868copy4JmcsL4;
    }

    public final NavigationBarItemColors getDefaultNavigationBarItemColors$material3_release(ColorScheme colorScheme) {
        NavigationBarItemColors defaultNavigationBarItemColorsCached = colorScheme.getDefaultNavigationBarItemColorsCached();
        if (defaultNavigationBarItemColorsCached != null) {
            return defaultNavigationBarItemColorsCached;
        }
        NavigationBarTokens navigationBarTokens = NavigationBarTokens.INSTANCE;
        NavigationBarItemColors navigationBarItemColors = new NavigationBarItemColors(ColorSchemeKt.fromToken(colorScheme, navigationBarTokens.getActiveIconColor()), ColorSchemeKt.fromToken(colorScheme, navigationBarTokens.getActiveLabelTextColor()), ColorSchemeKt.fromToken(colorScheme, navigationBarTokens.getActiveIndicatorColor()), ColorSchemeKt.fromToken(colorScheme, navigationBarTokens.getInactiveIconColor()), ColorSchemeKt.fromToken(colorScheme, navigationBarTokens.getInactiveLabelTextColor()), Color.m1485copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, navigationBarTokens.getInactiveIconColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), Color.m1485copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, navigationBarTokens.getInactiveLabelTextColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), null);
        colorScheme.setDefaultNavigationBarItemColorsCached$material3_release(navigationBarItemColors);
        return navigationBarItemColors;
    }
}
