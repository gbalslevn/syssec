package androidx.compose.material3;

import androidx.appcompat.R$styleable;
import androidx.compose.material3.tokens.ColorDarkTokens;
import androidx.compose.material3.tokens.ColorLightTokens;
import androidx.compose.material3.tokens.ColorSchemeKeyTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\u001aø\u0002\u0010(\u001a\u00020%2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010 \u001a\u00020\u00002\b\b\u0002\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010#\u001a\u00020\u00002\b\b\u0002\u0010$\u001a\u00020\u0000ø\u0001\u0000¢\u0006\u0004\b&\u0010'\u001aø\u0002\u0010*\u001a\u00020%2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010 \u001a\u00020\u00002\b\b\u0002\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010#\u001a\u00020\u00002\b\b\u0002\u0010$\u001a\u00020\u0000ø\u0001\u0000¢\u0006\u0004\b)\u0010'\u001a\u001e\u0010.\u001a\u00020\u0000*\u00020%2\u0006\u0010+\u001a\u00020\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b,\u0010-\u001a\u001a\u0010.\u001a\u00020\u00002\u0006\u0010+\u001a\u00020\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b/\u00100\u001a&\u00105\u001a\u00020\u0000*\u00020%2\u0006\u0010+\u001a\u00020\u00002\u0006\u00102\u001a\u000201H\u0001ø\u0001\u0000¢\u0006\u0004\b3\u00104\u001a\u001e\u00108\u001a\u00020\u0000*\u00020%2\u0006\u00102\u001a\u000201H\u0007ø\u0001\u0000¢\u0006\u0004\b6\u00107\u001a\u001b\u0010;\u001a\u00020\u0000*\u00020%2\u0006\u0010:\u001a\u000209H\u0001¢\u0006\u0004\b;\u0010<\" \u0010>\u001a\b\u0012\u0004\u0012\u00020%0=8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u001d\u0010C\u001a\b\u0012\u0004\u0012\u00020B0=8\u0006¢\u0006\f\n\u0004\bC\u0010?\u001a\u0004\bD\u0010A\"\u0018\u0010:\u001a\u00020\u0000*\u0002098AX\u0080\u0004¢\u0006\u0006\u001a\u0004\bE\u0010F\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006G"}, d2 = {"Landroidx/compose/ui/graphics/Color;", "primary", "onPrimary", "primaryContainer", "onPrimaryContainer", "inversePrimary", "secondary", "onSecondary", "secondaryContainer", "onSecondaryContainer", "tertiary", "onTertiary", "tertiaryContainer", "onTertiaryContainer", "background", "onBackground", "surface", "onSurface", "surfaceVariant", "onSurfaceVariant", "surfaceTint", "inverseSurface", "inverseOnSurface", "error", "onError", "errorContainer", "onErrorContainer", "outline", "outlineVariant", "scrim", "surfaceBright", "surfaceContainer", "surfaceContainerHigh", "surfaceContainerHighest", "surfaceContainerLow", "surfaceContainerLowest", "surfaceDim", "Landroidx/compose/material3/ColorScheme;", "lightColorScheme-C-Xl9yA", "(JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJ)Landroidx/compose/material3/ColorScheme;", "lightColorScheme", "darkColorScheme-C-Xl9yA", "darkColorScheme", "backgroundColor", "contentColorFor-4WTKRHQ", "(Landroidx/compose/material3/ColorScheme;J)J", "contentColorFor", "contentColorFor-ek8zF_U", "(JLandroidx/compose/runtime/Composer;I)J", "Landroidx/compose/ui/unit/Dp;", "elevation", "applyTonalElevation-RFCenO8", "(Landroidx/compose/material3/ColorScheme;JFLandroidx/compose/runtime/Composer;I)J", "applyTonalElevation", "surfaceColorAtElevation-3ABfNKs", "(Landroidx/compose/material3/ColorScheme;F)J", "surfaceColorAtElevation", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "value", "fromToken", "(Landroidx/compose/material3/ColorScheme;Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;)J", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "LocalColorScheme", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "getLocalColorScheme", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", BuildConfig.FLAVOR, "LocalTonalElevationEnabled", "getLocalTonalElevationEnabled", "getValue", "(Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;Landroidx/compose/runtime/Composer;I)J", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class ColorSchemeKt {
    private static final ProvidableCompositionLocal<ColorScheme> LocalColorScheme = CompositionLocalKt.staticCompositionLocalOf(new Function0<ColorScheme>() { // from class: androidx.compose.material3.ColorSchemeKt$LocalColorScheme$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ColorScheme invoke() {
            return ColorSchemeKt.m831lightColorSchemeCXl9yA$default(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, -1, 15, null);
        }
    });
    private static final ProvidableCompositionLocal<Boolean> LocalTonalElevationEnabled = CompositionLocalKt.staticCompositionLocalOf(new Function0<Boolean>() { // from class: androidx.compose.material3.ColorSchemeKt$LocalTonalElevationEnabled$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            return Boolean.TRUE;
        }
    });

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ColorSchemeKeyTokens.values().length];
            try {
                iArr[ColorSchemeKeyTokens.Background.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ColorSchemeKeyTokens.Error.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ColorSchemeKeyTokens.ErrorContainer.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ColorSchemeKeyTokens.InverseOnSurface.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ColorSchemeKeyTokens.InversePrimary.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ColorSchemeKeyTokens.InverseSurface.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnBackground.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnError.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnErrorContainer.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnPrimary.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnPrimaryContainer.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnSecondary.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnSecondaryContainer.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnSurface.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnSurfaceVariant.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[ColorSchemeKeyTokens.SurfaceTint.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnTertiary.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnTertiaryContainer.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr[ColorSchemeKeyTokens.Outline.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OutlineVariant.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr[ColorSchemeKeyTokens.Primary.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr[ColorSchemeKeyTokens.PrimaryContainer.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr[ColorSchemeKeyTokens.Scrim.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr[ColorSchemeKeyTokens.Secondary.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr[ColorSchemeKeyTokens.SecondaryContainer.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                iArr[ColorSchemeKeyTokens.Surface.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                iArr[ColorSchemeKeyTokens.SurfaceVariant.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                iArr[ColorSchemeKeyTokens.SurfaceBright.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                iArr[ColorSchemeKeyTokens.SurfaceContainer.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                iArr[ColorSchemeKeyTokens.SurfaceContainerHigh.ordinal()] = 30;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                iArr[ColorSchemeKeyTokens.SurfaceContainerHighest.ordinal()] = 31;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                iArr[ColorSchemeKeyTokens.SurfaceContainerLow.ordinal()] = 32;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                iArr[ColorSchemeKeyTokens.SurfaceContainerLowest.ordinal()] = 33;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                iArr[ColorSchemeKeyTokens.SurfaceDim.ordinal()] = 34;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                iArr[ColorSchemeKeyTokens.Tertiary.ordinal()] = 35;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                iArr[ColorSchemeKeyTokens.TertiaryContainer.ordinal()] = 36;
            } catch (NoSuchFieldError unused36) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* renamed from: applyTonalElevation-RFCenO8, reason: not valid java name */
    public static final long m825applyTonalElevationRFCenO8(ColorScheme colorScheme, long j5, float f5, Composer composer, int i5) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1610977682, i5, -1, "androidx.compose.material3.applyTonalElevation (ColorScheme.kt:895)");
        }
        boolean booleanValue = ((Boolean) composer.consume(LocalTonalElevationEnabled)).booleanValue();
        if (Color.m1487equalsimpl0(j5, colorScheme.getSurface()) && booleanValue) {
            j5 = m832surfaceColorAtElevation3ABfNKs(colorScheme, f5);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return j5;
    }

    /* renamed from: contentColorFor-4WTKRHQ, reason: not valid java name */
    public static final long m826contentColorFor4WTKRHQ(ColorScheme colorScheme, long j5) {
        if (Color.m1487equalsimpl0(j5, colorScheme.getPrimary())) {
            return colorScheme.getOnPrimary();
        }
        if (Color.m1487equalsimpl0(j5, colorScheme.getSecondary())) {
            return colorScheme.getOnSecondary();
        }
        if (Color.m1487equalsimpl0(j5, colorScheme.getTertiary())) {
            return colorScheme.getOnTertiary();
        }
        if (Color.m1487equalsimpl0(j5, colorScheme.getBackground())) {
            return colorScheme.getOnBackground();
        }
        if (Color.m1487equalsimpl0(j5, colorScheme.getError())) {
            return colorScheme.getOnError();
        }
        if (Color.m1487equalsimpl0(j5, colorScheme.getPrimaryContainer())) {
            return colorScheme.getOnPrimaryContainer();
        }
        if (Color.m1487equalsimpl0(j5, colorScheme.getSecondaryContainer())) {
            return colorScheme.getOnSecondaryContainer();
        }
        if (Color.m1487equalsimpl0(j5, colorScheme.getTertiaryContainer())) {
            return colorScheme.getOnTertiaryContainer();
        }
        if (Color.m1487equalsimpl0(j5, colorScheme.getErrorContainer())) {
            return colorScheme.getOnErrorContainer();
        }
        if (Color.m1487equalsimpl0(j5, colorScheme.getInverseSurface())) {
            return colorScheme.getInverseOnSurface();
        }
        if (Color.m1487equalsimpl0(j5, colorScheme.getSurface())) {
            return colorScheme.getOnSurface();
        }
        if (Color.m1487equalsimpl0(j5, colorScheme.getSurfaceVariant())) {
            return colorScheme.getOnSurfaceVariant();
        }
        if (!Color.m1487equalsimpl0(j5, colorScheme.getSurfaceBright()) && !Color.m1487equalsimpl0(j5, colorScheme.getSurfaceContainer()) && !Color.m1487equalsimpl0(j5, colorScheme.getSurfaceContainerHigh()) && !Color.m1487equalsimpl0(j5, colorScheme.getSurfaceContainerHighest()) && !Color.m1487equalsimpl0(j5, colorScheme.getSurfaceContainerLow()) && !Color.m1487equalsimpl0(j5, colorScheme.getSurfaceContainerLowest())) {
            return Color.INSTANCE.m1501getUnspecified0d7_KjU();
        }
        return colorScheme.getOnSurface();
    }

    /* renamed from: contentColorFor-ek8zF_U, reason: not valid java name */
    public static final long m827contentColorForek8zF_U(long j5, Composer composer, int i5) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(509589638, i5, -1, "androidx.compose.material3.contentColorFor (ColorScheme.kt:878)");
        }
        composer.startReplaceGroup(-1680936624);
        long m826contentColorFor4WTKRHQ = m826contentColorFor4WTKRHQ(MaterialTheme.INSTANCE.getColorScheme(composer, 6), j5);
        if (m826contentColorFor4WTKRHQ == 16) {
            m826contentColorFor4WTKRHQ = ((Color) composer.consume(ContentColorKt.getLocalContentColor())).getValue();
        }
        composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return m826contentColorFor4WTKRHQ;
    }

    /* renamed from: darkColorScheme-C-Xl9yA, reason: not valid java name */
    public static final ColorScheme m828darkColorSchemeCXl9yA(long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, long j39, long j40) {
        return new ColorScheme(j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21, j22, j23, j24, j25, j26, j27, j28, j29, j30, j31, j32, j33, j34, j40, j35, j36, j37, j38, j39, null);
    }

    /* renamed from: darkColorScheme-C-Xl9yA$default, reason: not valid java name */
    public static /* synthetic */ ColorScheme m829darkColorSchemeCXl9yA$default(long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, long j39, long j40, int i5, int i6, Object obj) {
        long m1024getPrimary0d7_KjU = (i5 & 1) != 0 ? ColorDarkTokens.INSTANCE.m1024getPrimary0d7_KjU() : j5;
        return m828darkColorSchemeCXl9yA(m1024getPrimary0d7_KjU, (i5 & 2) != 0 ? ColorDarkTokens.INSTANCE.m1014getOnPrimary0d7_KjU() : j6, (i5 & 4) != 0 ? ColorDarkTokens.INSTANCE.m1025getPrimaryContainer0d7_KjU() : j7, (i5 & 8) != 0 ? ColorDarkTokens.INSTANCE.m1015getOnPrimaryContainer0d7_KjU() : j8, (i5 & 16) != 0 ? ColorDarkTokens.INSTANCE.m1009getInversePrimary0d7_KjU() : j9, (i5 & 32) != 0 ? ColorDarkTokens.INSTANCE.m1027getSecondary0d7_KjU() : j10, (i5 & 64) != 0 ? ColorDarkTokens.INSTANCE.m1016getOnSecondary0d7_KjU() : j11, (i5 & 128) != 0 ? ColorDarkTokens.INSTANCE.m1028getSecondaryContainer0d7_KjU() : j12, (i5 & 256) != 0 ? ColorDarkTokens.INSTANCE.m1017getOnSecondaryContainer0d7_KjU() : j13, (i5 & 512) != 0 ? ColorDarkTokens.INSTANCE.m1038getTertiary0d7_KjU() : j14, (i5 & 1024) != 0 ? ColorDarkTokens.INSTANCE.m1020getOnTertiary0d7_KjU() : j15, (i5 & 2048) != 0 ? ColorDarkTokens.INSTANCE.m1039getTertiaryContainer0d7_KjU() : j16, (i5 & 4096) != 0 ? ColorDarkTokens.INSTANCE.m1021getOnTertiaryContainer0d7_KjU() : j17, (i5 & 8192) != 0 ? ColorDarkTokens.INSTANCE.m1005getBackground0d7_KjU() : j18, (i5 & 16384) != 0 ? ColorDarkTokens.INSTANCE.m1011getOnBackground0d7_KjU() : j19, (i5 & 32768) != 0 ? ColorDarkTokens.INSTANCE.m1029getSurface0d7_KjU() : j20, (i5 & 65536) != 0 ? ColorDarkTokens.INSTANCE.m1018getOnSurface0d7_KjU() : j21, (i5 & 131072) != 0 ? ColorDarkTokens.INSTANCE.m1037getSurfaceVariant0d7_KjU() : j22, (i5 & 262144) != 0 ? ColorDarkTokens.INSTANCE.m1019getOnSurfaceVariant0d7_KjU() : j23, (i5 & 524288) != 0 ? m1024getPrimary0d7_KjU : j24, (i5 & 1048576) != 0 ? ColorDarkTokens.INSTANCE.m1010getInverseSurface0d7_KjU() : j25, (i5 & 2097152) != 0 ? ColorDarkTokens.INSTANCE.m1008getInverseOnSurface0d7_KjU() : j26, (i5 & 4194304) != 0 ? ColorDarkTokens.INSTANCE.m1006getError0d7_KjU() : j27, (i5 & 8388608) != 0 ? ColorDarkTokens.INSTANCE.m1012getOnError0d7_KjU() : j28, (i5 & 16777216) != 0 ? ColorDarkTokens.INSTANCE.m1007getErrorContainer0d7_KjU() : j29, (i5 & 33554432) != 0 ? ColorDarkTokens.INSTANCE.m1013getOnErrorContainer0d7_KjU() : j30, (i5 & 67108864) != 0 ? ColorDarkTokens.INSTANCE.m1022getOutline0d7_KjU() : j31, (i5 & 134217728) != 0 ? ColorDarkTokens.INSTANCE.m1023getOutlineVariant0d7_KjU() : j32, (i5 & 268435456) != 0 ? ColorDarkTokens.INSTANCE.m1026getScrim0d7_KjU() : j33, (i5 & 536870912) != 0 ? ColorDarkTokens.INSTANCE.m1030getSurfaceBright0d7_KjU() : j34, (i5 & 1073741824) != 0 ? ColorDarkTokens.INSTANCE.m1031getSurfaceContainer0d7_KjU() : j35, (i5 & Integer.MIN_VALUE) != 0 ? ColorDarkTokens.INSTANCE.m1032getSurfaceContainerHigh0d7_KjU() : j36, (i6 & 1) != 0 ? ColorDarkTokens.INSTANCE.m1033getSurfaceContainerHighest0d7_KjU() : j37, (i6 & 2) != 0 ? ColorDarkTokens.INSTANCE.m1034getSurfaceContainerLow0d7_KjU() : j38, (i6 & 4) != 0 ? ColorDarkTokens.INSTANCE.m1035getSurfaceContainerLowest0d7_KjU() : j39, (i6 & 8) != 0 ? ColorDarkTokens.INSTANCE.m1036getSurfaceDim0d7_KjU() : j40);
    }

    public static final long fromToken(ColorScheme colorScheme, ColorSchemeKeyTokens colorSchemeKeyTokens) {
        switch (WhenMappings.$EnumSwitchMapping$0[colorSchemeKeyTokens.ordinal()]) {
            case 1:
                return colorScheme.getBackground();
            case 2:
                return colorScheme.getError();
            case 3:
                return colorScheme.getErrorContainer();
            case 4:
                return colorScheme.getInverseOnSurface();
            case 5:
                return colorScheme.getInversePrimary();
            case 6:
                return colorScheme.getInverseSurface();
            case 7:
                return colorScheme.getOnBackground();
            case 8:
                return colorScheme.getOnError();
            case 9:
                return colorScheme.getOnErrorContainer();
            case 10:
                return colorScheme.getOnPrimary();
            case 11:
                return colorScheme.getOnPrimaryContainer();
            case 12:
                return colorScheme.getOnSecondary();
            case 13:
                return colorScheme.getOnSecondaryContainer();
            case 14:
                return colorScheme.getOnSurface();
            case 15:
                return colorScheme.getOnSurfaceVariant();
            case 16:
                return colorScheme.getSurfaceTint();
            case 17:
                return colorScheme.getOnTertiary();
            case 18:
                return colorScheme.getOnTertiaryContainer();
            case 19:
                return colorScheme.getOutline();
            case 20:
                return colorScheme.getOutlineVariant();
            case 21:
                return colorScheme.getPrimary();
            case 22:
                return colorScheme.getPrimaryContainer();
            case R$styleable.Toolbar_titleMarginBottom /* 23 */:
                return colorScheme.getScrim();
            case R$styleable.Toolbar_titleMarginEnd /* 24 */:
                return colorScheme.getSecondary();
            case 25:
                return colorScheme.getSecondaryContainer();
            case 26:
                return colorScheme.getSurface();
            case 27:
                return colorScheme.getSurfaceVariant();
            case 28:
                return colorScheme.getSurfaceBright();
            case R$styleable.Toolbar_titleTextColor /* 29 */:
                return colorScheme.getSurfaceContainer();
            case 30:
                return colorScheme.getSurfaceContainerHigh();
            case 31:
                return colorScheme.getSurfaceContainerHighest();
            case 32:
                return colorScheme.getSurfaceContainerLow();
            case 33:
                return colorScheme.getSurfaceContainerLowest();
            case 34:
                return colorScheme.getSurfaceDim();
            case 35:
                return colorScheme.getTertiary();
            case 36:
                return colorScheme.getTertiaryContainer();
            default:
                return Color.INSTANCE.m1501getUnspecified0d7_KjU();
        }
    }

    public static final ProvidableCompositionLocal<ColorScheme> getLocalColorScheme() {
        return LocalColorScheme;
    }

    public static final long getValue(ColorSchemeKeyTokens colorSchemeKeyTokens, Composer composer, int i5) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-810780884, i5, -1, "androidx.compose.material3.<get-value> (ColorScheme.kt:1009)");
        }
        long fromToken = fromToken(MaterialTheme.INSTANCE.getColorScheme(composer, 6), colorSchemeKeyTokens);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return fromToken;
    }

    /* renamed from: lightColorScheme-C-Xl9yA, reason: not valid java name */
    public static final ColorScheme m830lightColorSchemeCXl9yA(long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, long j39, long j40) {
        return new ColorScheme(j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21, j22, j23, j24, j25, j26, j27, j28, j29, j30, j31, j32, j33, j34, j40, j35, j36, j37, j38, j39, null);
    }

    /* renamed from: lightColorScheme-C-Xl9yA$default, reason: not valid java name */
    public static /* synthetic */ ColorScheme m831lightColorSchemeCXl9yA$default(long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, long j39, long j40, int i5, int i6, Object obj) {
        long m1059getPrimary0d7_KjU = (i5 & 1) != 0 ? ColorLightTokens.INSTANCE.m1059getPrimary0d7_KjU() : j5;
        return m830lightColorSchemeCXl9yA(m1059getPrimary0d7_KjU, (i5 & 2) != 0 ? ColorLightTokens.INSTANCE.m1049getOnPrimary0d7_KjU() : j6, (i5 & 4) != 0 ? ColorLightTokens.INSTANCE.m1060getPrimaryContainer0d7_KjU() : j7, (i5 & 8) != 0 ? ColorLightTokens.INSTANCE.m1050getOnPrimaryContainer0d7_KjU() : j8, (i5 & 16) != 0 ? ColorLightTokens.INSTANCE.m1044getInversePrimary0d7_KjU() : j9, (i5 & 32) != 0 ? ColorLightTokens.INSTANCE.m1062getSecondary0d7_KjU() : j10, (i5 & 64) != 0 ? ColorLightTokens.INSTANCE.m1051getOnSecondary0d7_KjU() : j11, (i5 & 128) != 0 ? ColorLightTokens.INSTANCE.m1063getSecondaryContainer0d7_KjU() : j12, (i5 & 256) != 0 ? ColorLightTokens.INSTANCE.m1052getOnSecondaryContainer0d7_KjU() : j13, (i5 & 512) != 0 ? ColorLightTokens.INSTANCE.m1073getTertiary0d7_KjU() : j14, (i5 & 1024) != 0 ? ColorLightTokens.INSTANCE.m1055getOnTertiary0d7_KjU() : j15, (i5 & 2048) != 0 ? ColorLightTokens.INSTANCE.m1074getTertiaryContainer0d7_KjU() : j16, (i5 & 4096) != 0 ? ColorLightTokens.INSTANCE.m1056getOnTertiaryContainer0d7_KjU() : j17, (i5 & 8192) != 0 ? ColorLightTokens.INSTANCE.m1040getBackground0d7_KjU() : j18, (i5 & 16384) != 0 ? ColorLightTokens.INSTANCE.m1046getOnBackground0d7_KjU() : j19, (i5 & 32768) != 0 ? ColorLightTokens.INSTANCE.m1064getSurface0d7_KjU() : j20, (i5 & 65536) != 0 ? ColorLightTokens.INSTANCE.m1053getOnSurface0d7_KjU() : j21, (i5 & 131072) != 0 ? ColorLightTokens.INSTANCE.m1072getSurfaceVariant0d7_KjU() : j22, (i5 & 262144) != 0 ? ColorLightTokens.INSTANCE.m1054getOnSurfaceVariant0d7_KjU() : j23, (i5 & 524288) != 0 ? m1059getPrimary0d7_KjU : j24, (i5 & 1048576) != 0 ? ColorLightTokens.INSTANCE.m1045getInverseSurface0d7_KjU() : j25, (i5 & 2097152) != 0 ? ColorLightTokens.INSTANCE.m1043getInverseOnSurface0d7_KjU() : j26, (i5 & 4194304) != 0 ? ColorLightTokens.INSTANCE.m1041getError0d7_KjU() : j27, (i5 & 8388608) != 0 ? ColorLightTokens.INSTANCE.m1047getOnError0d7_KjU() : j28, (i5 & 16777216) != 0 ? ColorLightTokens.INSTANCE.m1042getErrorContainer0d7_KjU() : j29, (i5 & 33554432) != 0 ? ColorLightTokens.INSTANCE.m1048getOnErrorContainer0d7_KjU() : j30, (i5 & 67108864) != 0 ? ColorLightTokens.INSTANCE.m1057getOutline0d7_KjU() : j31, (i5 & 134217728) != 0 ? ColorLightTokens.INSTANCE.m1058getOutlineVariant0d7_KjU() : j32, (i5 & 268435456) != 0 ? ColorLightTokens.INSTANCE.m1061getScrim0d7_KjU() : j33, (i5 & 536870912) != 0 ? ColorLightTokens.INSTANCE.m1065getSurfaceBright0d7_KjU() : j34, (i5 & 1073741824) != 0 ? ColorLightTokens.INSTANCE.m1066getSurfaceContainer0d7_KjU() : j35, (i5 & Integer.MIN_VALUE) != 0 ? ColorLightTokens.INSTANCE.m1067getSurfaceContainerHigh0d7_KjU() : j36, (i6 & 1) != 0 ? ColorLightTokens.INSTANCE.m1068getSurfaceContainerHighest0d7_KjU() : j37, (i6 & 2) != 0 ? ColorLightTokens.INSTANCE.m1069getSurfaceContainerLow0d7_KjU() : j38, (i6 & 4) != 0 ? ColorLightTokens.INSTANCE.m1070getSurfaceContainerLowest0d7_KjU() : j39, (i6 & 8) != 0 ? ColorLightTokens.INSTANCE.m1071getSurfaceDim0d7_KjU() : j40);
    }

    /* renamed from: surfaceColorAtElevation-3ABfNKs, reason: not valid java name */
    public static final long m832surfaceColorAtElevation3ABfNKs(ColorScheme colorScheme, float f5) {
        if (Dp.m2601equalsimpl0(f5, Dp.m2599constructorimpl(0))) {
            return colorScheme.getSurface();
        }
        return ColorKt.m1505compositeOverOWjLjI(Color.m1485copywmQWz5c$default(colorScheme.getSurfaceTint(), ((((float) Math.log(f5 + 1)) * 4.5f) + 2.0f) / 100.0f, 0.0f, 0.0f, 0.0f, 14, null), colorScheme.getSurface());
    }
}
