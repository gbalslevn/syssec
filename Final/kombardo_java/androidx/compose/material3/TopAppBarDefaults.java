package androidx.compose.material3;

import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.material3.internal.SystemBarsDefaultInsets_androidKt;
import androidx.compose.material3.tokens.TopAppBarLargeTokens;
import androidx.compose.material3.tokens.TopAppBarMediumTokens;
import androidx.compose.material3.tokens.TopAppBarSmallCenteredTokens;
import androidx.compose.material3.tokens.TopAppBarSmallTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JD\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\nH\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0011\u001a\u00020\u00108\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0015\u001a\u00020\u00108\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014R\u001d\u0010\u0017\u001a\u00020\u00108\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014R\u001d\u0010\u0019\u001a\u00020\u00108\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0019\u0010\u0012\u001a\u0004\b\u001a\u0010\u0014R\u001d\u0010\u001b\u001a\u00020\u00108\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u001b\u0010\u0012\u001a\u0004\b\u001c\u0010\u0014R\u0018\u0010 \u001a\u00020\n*\u00020\u001d8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010$\u001a\u00020!8G¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0018\u0010&\u001a\u00020\n*\u00020\u001d8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u001f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006'"}, d2 = {"Landroidx/compose/material3/TopAppBarDefaults;", BuildConfig.FLAVOR, "<init>", "()V", "Landroidx/compose/ui/graphics/Color;", "containerColor", "scrolledContainerColor", "navigationIconContentColor", "titleContentColor", "actionIconContentColor", "Landroidx/compose/material3/TopAppBarColors;", "topAppBarColors-zjMxDiM", "(JJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TopAppBarColors;", "topAppBarColors", "centerAlignedTopAppBarColors", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/TopAppBarColors;", "Landroidx/compose/ui/unit/Dp;", "TopAppBarExpandedHeight", "F", "getTopAppBarExpandedHeight-D9Ej5fM", "()F", "MediumAppBarCollapsedHeight", "getMediumAppBarCollapsedHeight-D9Ej5fM", "MediumAppBarExpandedHeight", "getMediumAppBarExpandedHeight-D9Ej5fM", "LargeAppBarCollapsedHeight", "getLargeAppBarCollapsedHeight-D9Ej5fM", "LargeAppBarExpandedHeight", "getLargeAppBarExpandedHeight-D9Ej5fM", "Landroidx/compose/material3/ColorScheme;", "getDefaultTopAppBarColors$material3_release", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/TopAppBarColors;", "defaultTopAppBarColors", "Landroidx/compose/foundation/layout/WindowInsets;", "getWindowInsets", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/layout/WindowInsets;", "windowInsets", "getDefaultCenterAlignedTopAppBarColors$material3_release", "defaultCenterAlignedTopAppBarColors", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TopAppBarDefaults {
    public static final int $stable = 0;
    public static final TopAppBarDefaults INSTANCE = new TopAppBarDefaults();
    private static final float LargeAppBarCollapsedHeight;
    private static final float LargeAppBarExpandedHeight;
    private static final float MediumAppBarCollapsedHeight;
    private static final float MediumAppBarExpandedHeight;
    private static final float TopAppBarExpandedHeight;

    static {
        TopAppBarSmallTokens topAppBarSmallTokens = TopAppBarSmallTokens.INSTANCE;
        TopAppBarExpandedHeight = topAppBarSmallTokens.m1163getContainerHeightD9Ej5fM();
        MediumAppBarCollapsedHeight = topAppBarSmallTokens.m1163getContainerHeightD9Ej5fM();
        MediumAppBarExpandedHeight = TopAppBarMediumTokens.INSTANCE.m1162getContainerHeightD9Ej5fM();
        LargeAppBarCollapsedHeight = topAppBarSmallTokens.m1163getContainerHeightD9Ej5fM();
        LargeAppBarExpandedHeight = TopAppBarLargeTokens.INSTANCE.m1161getContainerHeightD9Ej5fM();
    }

    private TopAppBarDefaults() {
    }

    public final TopAppBarColors centerAlignedTopAppBarColors(Composer composer, int i5) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(513940029, i5, -1, "androidx.compose.material3.TopAppBarDefaults.centerAlignedTopAppBarColors (AppBar.kt:1035)");
        }
        TopAppBarColors defaultCenterAlignedTopAppBarColors$material3_release = getDefaultCenterAlignedTopAppBarColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return defaultCenterAlignedTopAppBarColors$material3_release;
    }

    public final TopAppBarColors getDefaultCenterAlignedTopAppBarColors$material3_release(ColorScheme colorScheme) {
        TopAppBarColors defaultCenterAlignedTopAppBarColorsCached = colorScheme.getDefaultCenterAlignedTopAppBarColorsCached();
        if (defaultCenterAlignedTopAppBarColorsCached != null) {
            return defaultCenterAlignedTopAppBarColorsCached;
        }
        TopAppBarSmallCenteredTokens topAppBarSmallCenteredTokens = TopAppBarSmallCenteredTokens.INSTANCE;
        TopAppBarColors topAppBarColors = new TopAppBarColors(ColorSchemeKt.fromToken(colorScheme, topAppBarSmallCenteredTokens.getContainerColor()), ColorSchemeKt.fromToken(colorScheme, topAppBarSmallCenteredTokens.getOnScrollContainerColor()), ColorSchemeKt.fromToken(colorScheme, topAppBarSmallCenteredTokens.getLeadingIconColor()), ColorSchemeKt.fromToken(colorScheme, topAppBarSmallCenteredTokens.getHeadlineColor()), ColorSchemeKt.fromToken(colorScheme, topAppBarSmallCenteredTokens.getTrailingIconColor()), null);
        colorScheme.setDefaultCenterAlignedTopAppBarColorsCached$material3_release(topAppBarColors);
        return topAppBarColors;
    }

    public final TopAppBarColors getDefaultTopAppBarColors$material3_release(ColorScheme colorScheme) {
        TopAppBarColors defaultTopAppBarColorsCached = colorScheme.getDefaultTopAppBarColorsCached();
        if (defaultTopAppBarColorsCached != null) {
            return defaultTopAppBarColorsCached;
        }
        TopAppBarSmallTokens topAppBarSmallTokens = TopAppBarSmallTokens.INSTANCE;
        TopAppBarColors topAppBarColors = new TopAppBarColors(ColorSchemeKt.fromToken(colorScheme, topAppBarSmallTokens.getContainerColor()), ColorSchemeKt.fromToken(colorScheme, topAppBarSmallTokens.getOnScrollContainerColor()), ColorSchemeKt.fromToken(colorScheme, topAppBarSmallTokens.getLeadingIconColor()), ColorSchemeKt.fromToken(colorScheme, topAppBarSmallTokens.getHeadlineColor()), ColorSchemeKt.fromToken(colorScheme, topAppBarSmallTokens.getTrailingIconColor()), null);
        colorScheme.setDefaultTopAppBarColorsCached$material3_release(topAppBarColors);
        return topAppBarColors;
    }

    /* renamed from: getTopAppBarExpandedHeight-D9Ej5fM, reason: not valid java name */
    public final float m989getTopAppBarExpandedHeightD9Ej5fM() {
        return TopAppBarExpandedHeight;
    }

    public final WindowInsets getWindowInsets(Composer composer, int i5) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2143182847, i5, -1, "androidx.compose.material3.TopAppBarDefaults.<get-windowInsets> (AppBar.kt:1025)");
        }
        WindowInsets systemBarsForVisualComponents = SystemBarsDefaultInsets_androidKt.getSystemBarsForVisualComponents(WindowInsets.INSTANCE, composer, 6);
        WindowInsetsSides.Companion companion = WindowInsetsSides.INSTANCE;
        WindowInsets m348onlybOOhFvg = WindowInsetsKt.m348onlybOOhFvg(systemBarsForVisualComponents, WindowInsetsSides.m353plusgK_yJZ4(companion.m361getHorizontalJoeWqyM(), companion.m362getTopJoeWqyM()));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return m348onlybOOhFvg;
    }

    /* renamed from: topAppBarColors-zjMxDiM, reason: not valid java name */
    public final TopAppBarColors m990topAppBarColorszjMxDiM(long j5, long j6, long j7, long j8, long j9, Composer composer, int i5, int i6) {
        long m1501getUnspecified0d7_KjU = (i6 & 1) != 0 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : j5;
        long m1501getUnspecified0d7_KjU2 = (i6 & 2) != 0 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : j6;
        long m1501getUnspecified0d7_KjU3 = (i6 & 4) != 0 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : j7;
        long m1501getUnspecified0d7_KjU4 = (i6 & 8) != 0 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : j8;
        long m1501getUnspecified0d7_KjU5 = (i6 & 16) != 0 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : j9;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2142919275, i5, -1, "androidx.compose.material3.TopAppBarDefaults.topAppBarColors (AppBar.kt:998)");
        }
        TopAppBarColors m985copyt635Npw = getDefaultTopAppBarColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).m985copyt635Npw(m1501getUnspecified0d7_KjU, m1501getUnspecified0d7_KjU2, m1501getUnspecified0d7_KjU3, m1501getUnspecified0d7_KjU4, m1501getUnspecified0d7_KjU5);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return m985copyt635Npw;
    }
}
