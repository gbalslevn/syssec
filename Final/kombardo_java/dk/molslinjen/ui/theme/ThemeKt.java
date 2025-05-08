package dk.molslinjen.ui.theme;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.Window;
import androidx.compose.foundation.DarkThemeKt;
import androidx.compose.material3.ColorScheme;
import androidx.compose.material3.ColorSchemeKt;
import androidx.compose.material3.DynamicTonalPaletteKt;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.Typography;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.core.view.WindowCompat;
import dk.molslinjen.ui.theme.ThemeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000$\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a1\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00002\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\u0007\"\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n\"\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\n\"\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {BuildConfig.FLAVOR, "darkTheme", "dynamicColor", "Lkotlin/Function0;", BuildConfig.FLAVOR, "content", "MolslinjenTheme", "(ZZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/material3/ColorScheme;", "LightColorScheme", "Landroidx/compose/material3/ColorScheme;", "DarkColorScheme", "Landroidx/compose/material3/Typography;", "ThemeTypography", "Landroidx/compose/material3/Typography;", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class ThemeKt {
    private static final ColorScheme DarkColorScheme;
    private static final ColorScheme LightColorScheme;
    private static final Typography ThemeTypography;

    static {
        AppColor appColor = AppColor.INSTANCE;
        LightColorScheme = ColorSchemeKt.m831lightColorSchemeCXl9yA$default(appColor.m3255getBrandBlue10d7_KjU(), appColor.m3281getWhite0d7_KjU(), 0L, 0L, 0L, appColor.m3260getBrandDarkBlue20d7_KjU(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, appColor.m3281getWhite0d7_KjU(), appColor.m3253getBrandBlack10d7_KjU(), appColor.m3281getWhite0d7_KjU(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, -57380, 15, null);
        DarkColorScheme = ColorSchemeKt.m829darkColorSchemeCXl9yA$default(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, -1, 15, null);
        ThemeTypography = new Typography(null, null, null, null, null, null, null, null, null, TypographyKt.getParagraph(), null, null, null, null, null, 32255, null);
    }

    public static final void MolslinjenTheme(final boolean z5, boolean z6, final Function2<? super Composer, ? super Integer, Unit> content, Composer composer, final int i5, final int i6) {
        int i7;
        final ColorScheme colorScheme;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer startRestartGroup = composer.startRestartGroup(-1946110743);
        if ((i5 & 6) == 0) {
            i7 = (((i6 & 1) == 0 && startRestartGroup.changed(z5)) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        int i8 = i6 & 2;
        if (i8 != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changed(z6) ? 32 : 16;
        }
        if ((i6 & 4) != 0) {
            i7 |= 384;
        } else if ((i5 & 384) == 0) {
            i7 |= startRestartGroup.changedInstance(content) ? 256 : 128;
        }
        if ((i7 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            startRestartGroup.startDefaults();
            boolean z7 = true;
            if ((i5 & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                if ((i6 & 1) != 0) {
                    z5 = DarkThemeKt.isSystemInDarkTheme(startRestartGroup, 0);
                    i7 &= -15;
                }
                if (i8 != 0) {
                    z6 = true;
                }
            } else {
                startRestartGroup.skipToGroupEnd();
                if ((i6 & 1) != 0) {
                    i7 &= -15;
                }
            }
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1946110743, i7, -1, "dk.molslinjen.ui.theme.MolslinjenTheme (Theme.kt:59)");
            }
            startRestartGroup.startReplaceGroup(-1467341965);
            if (!z6 || Build.VERSION.SDK_INT < 31) {
                colorScheme = z5 ? DarkColorScheme : LightColorScheme;
            } else {
                Context context = (Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                colorScheme = z5 ? DynamicTonalPaletteKt.dynamicDarkColorScheme(context) : DynamicTonalPaletteKt.dynamicLightColorScheme(context);
            }
            startRestartGroup.endReplaceGroup();
            final View view = (View) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalView());
            startRestartGroup.startReplaceGroup(-1467330791);
            if (!view.isInEditMode()) {
                startRestartGroup.startReplaceGroup(-1467329402);
                boolean changedInstance = startRestartGroup.changedInstance(view) | startRestartGroup.changed(colorScheme);
                if ((((i7 & 14) ^ 6) <= 4 || !startRestartGroup.changed(z5)) && (i7 & 6) != 4) {
                    z7 = false;
                }
                boolean z8 = changedInstance | z7;
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (z8 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function0() { // from class: P1.a
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit MolslinjenTheme$lambda$1$lambda$0;
                            MolslinjenTheme$lambda$1$lambda$0 = ThemeKt.MolslinjenTheme$lambda$1$lambda$0(view, colorScheme, z5);
                            return MolslinjenTheme$lambda$1$lambda$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                EffectsKt.SideEffect((Function0) rememberedValue, startRestartGroup, 0);
            }
            startRestartGroup.endReplaceGroup();
            MaterialThemeKt.MaterialTheme(colorScheme, ThemeShapesKt.getThemeShapes(), ThemeTypography, content, startRestartGroup, ((i7 << 3) & 7168) | 432, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        final boolean z9 = z5;
        final boolean z10 = z6;
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: P1.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit MolslinjenTheme$lambda$2;
                    MolslinjenTheme$lambda$2 = ThemeKt.MolslinjenTheme$lambda$2(z9, z10, content, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                    return MolslinjenTheme$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MolslinjenTheme$lambda$1$lambda$0(View view, ColorScheme colorScheme, boolean z5) {
        Context context = view.getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        Window window = ((Activity) context).getWindow();
        window.setStatusBarColor(ColorKt.m1508toArgb8_81llA(colorScheme.getPrimary()));
        WindowCompat.getInsetsController(window, view).setAppearanceLightStatusBars(z5);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MolslinjenTheme$lambda$2(boolean z5, boolean z6, Function2 function2, int i5, int i6, Composer composer, int i7) {
        MolslinjenTheme(z5, z6, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }
}
