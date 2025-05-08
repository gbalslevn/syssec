package androidx.compose.material3;

import android.R;
import android.content.Context;
import android.os.Build;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.core.math.MathUtils;
import com.sun.jna.Function;
import kotlin.Metadata;
import kotlin.math.MathKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007\u001a\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0001\u001a\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0001\u001a\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007\u001a\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0001\u001a\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0001\u001a\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0007H\u0001\u001a\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0003H\u0002\u001a \u0010\u0012\u001a\u00020\u0013*\u00020\u00132\b\b\u0001\u0010\u0014\u001a\u00020\u0003H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0017"}, d2 = {"delinearized", BuildConfig.FLAVOR, "rgbComponent", BuildConfig.FLAVOR, "dynamicDarkColorScheme", "Landroidx/compose/material3/ColorScheme;", "context", "Landroid/content/Context;", "dynamicDarkColorScheme31", "tonalPalette", "Landroidx/compose/material3/TonalPalette;", "dynamicDarkColorScheme34", "dynamicLightColorScheme", "dynamicLightColorScheme31", "dynamicLightColorScheme34", "dynamicTonalPalette", "labInvf", "ft", "setLuminance", "Landroidx/compose/ui/graphics/Color;", "newLuminance", "setLuminance-DxMtmZc", "(JF)J", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class DynamicTonalPaletteKt {
    private static final int delinearized(float f5) {
        double d5 = f5 / 100;
        return MathUtils.clamp(MathKt.roundToInt((d5 <= 0.0031308d ? d5 * 12.92d : (Math.pow(d5, 0.4166666666666667d) * 1.055d) - 0.055d) * 255.0d), 0, Function.USE_VARARGS);
    }

    public static final ColorScheme dynamicDarkColorScheme(Context context) {
        return Build.VERSION.SDK_INT >= 34 ? dynamicDarkColorScheme34(context) : dynamicDarkColorScheme31(dynamicTonalPalette(context));
    }

    public static final ColorScheme dynamicDarkColorScheme31(TonalPalette tonalPalette) {
        long primary80 = tonalPalette.getPrimary80();
        long primary20 = tonalPalette.getPrimary20();
        long primary30 = tonalPalette.getPrimary30();
        long primary90 = tonalPalette.getPrimary90();
        long primary40 = tonalPalette.getPrimary40();
        long secondary80 = tonalPalette.getSecondary80();
        long secondary20 = tonalPalette.getSecondary20();
        long secondary30 = tonalPalette.getSecondary30();
        long secondary90 = tonalPalette.getSecondary90();
        long tertiary80 = tonalPalette.getTertiary80();
        long tertiary20 = tonalPalette.getTertiary20();
        long tertiary30 = tonalPalette.getTertiary30();
        long tertiary90 = tonalPalette.getTertiary90();
        long neutralVariant6 = tonalPalette.getNeutralVariant6();
        long neutralVariant90 = tonalPalette.getNeutralVariant90();
        long neutralVariant62 = tonalPalette.getNeutralVariant6();
        long neutralVariant902 = tonalPalette.getNeutralVariant90();
        long neutralVariant30 = tonalPalette.getNeutralVariant30();
        long neutralVariant80 = tonalPalette.getNeutralVariant80();
        long neutralVariant903 = tonalPalette.getNeutralVariant90();
        long neutralVariant20 = tonalPalette.getNeutralVariant20();
        long neutralVariant60 = tonalPalette.getNeutralVariant60();
        long neutralVariant302 = tonalPalette.getNeutralVariant30();
        long neutralVariant0 = tonalPalette.getNeutralVariant0();
        long neutralVariant24 = tonalPalette.getNeutralVariant24();
        long neutralVariant63 = tonalPalette.getNeutralVariant6();
        return ColorSchemeKt.m829darkColorSchemeCXl9yA$default(primary80, primary20, primary30, primary90, primary40, secondary80, secondary20, secondary30, secondary90, tertiary80, tertiary20, tertiary30, tertiary90, neutralVariant6, neutralVariant90, neutralVariant62, neutralVariant902, neutralVariant30, neutralVariant80, tonalPalette.getPrimary80(), neutralVariant903, neutralVariant20, 0L, 0L, 0L, 0L, neutralVariant60, neutralVariant302, neutralVariant0, neutralVariant24, tonalPalette.getNeutralVariant12(), tonalPalette.getNeutralVariant17(), tonalPalette.getNeutralVariant22(), tonalPalette.getNeutralVariant10(), tonalPalette.getNeutralVariant4(), neutralVariant63, 62914560, 0, null);
    }

    public static final ColorScheme dynamicDarkColorScheme34(Context context) {
        ColorResourceHelper colorResourceHelper = ColorResourceHelper.INSTANCE;
        long m788getColorWaAFU9c = colorResourceHelper.m788getColorWaAFU9c(context, R.color.car_cyan_50);
        long m788getColorWaAFU9c2 = colorResourceHelper.m788getColorWaAFU9c(context, R.color.car_cyan_500);
        long m788getColorWaAFU9c3 = colorResourceHelper.m788getColorWaAFU9c(context, R.color.car_cyan_300);
        long m788getColorWaAFU9c4 = colorResourceHelper.m788getColorWaAFU9c(context, R.color.car_cyan_400);
        long m788getColorWaAFU9c5 = colorResourceHelper.m788getColorWaAFU9c(context, R.color.car_action1_dark);
        long m788getColorWaAFU9c6 = colorResourceHelper.m788getColorWaAFU9c(context, R.color.car_cyan_800);
        long m788getColorWaAFU9c7 = colorResourceHelper.m788getColorWaAFU9c(context, R.color.car_cyan_900);
        long m788getColorWaAFU9c8 = colorResourceHelper.m788getColorWaAFU9c(context, R.color.car_cyan_600);
        long m788getColorWaAFU9c9 = colorResourceHelper.m788getColorWaAFU9c(context, R.color.car_cyan_700);
        long m788getColorWaAFU9c10 = colorResourceHelper.m788getColorWaAFU9c(context, R.color.car_dark_blue_grey_700);
        long m788getColorWaAFU9c11 = colorResourceHelper.m788getColorWaAFU9c(context, R.color.car_dark_blue_grey_800);
        long m788getColorWaAFU9c12 = colorResourceHelper.m788getColorWaAFU9c(context, R.color.car_dark_blue_grey_1000);
        long m788getColorWaAFU9c13 = colorResourceHelper.m788getColorWaAFU9c(context, R.color.car_dark_blue_grey_600);
        long m788getColorWaAFU9c14 = colorResourceHelper.m788getColorWaAFU9c(context, R.color.car_dark_blue_grey_900);
        long m788getColorWaAFU9c15 = colorResourceHelper.m788getColorWaAFU9c(context, R.color.car_green_100);
        long m788getColorWaAFU9c16 = colorResourceHelper.m788getColorWaAFU9c(context, R.color.car_green_200);
        long m788getColorWaAFU9c17 = colorResourceHelper.m788getColorWaAFU9c(context, R.color.car_green_300);
        long m788getColorWaAFU9c18 = colorResourceHelper.m788getColorWaAFU9c(context, R.color.car_grey_100);
        long m788getColorWaAFU9c19 = colorResourceHelper.m788getColorWaAFU9c(context, R.color.car_grey_1000);
        long m788getColorWaAFU9c20 = colorResourceHelper.m788getColorWaAFU9c(context, R.color.car_blue_900);
        long m788getColorWaAFU9c21 = colorResourceHelper.m788getColorWaAFU9c(context, R.color.car_blue_grey_800);
        long m788getColorWaAFU9c22 = colorResourceHelper.m788getColorWaAFU9c(context, R.color.car_grey_200);
        long m788getColorWaAFU9c23 = colorResourceHelper.m788getColorWaAFU9c(context, R.color.car_keyboard_divider_line);
        long m788getColorWaAFU9c24 = colorResourceHelper.m788getColorWaAFU9c(context, R.color.car_green_800);
        long m788getColorWaAFU9c25 = colorResourceHelper.m788getColorWaAFU9c(context, R.color.car_green_900);
        return ColorSchemeKt.m829darkColorSchemeCXl9yA$default(m788getColorWaAFU9c, m788getColorWaAFU9c2, m788getColorWaAFU9c3, m788getColorWaAFU9c4, m788getColorWaAFU9c5, m788getColorWaAFU9c6, m788getColorWaAFU9c7, m788getColorWaAFU9c8, m788getColorWaAFU9c9, m788getColorWaAFU9c10, m788getColorWaAFU9c11, m788getColorWaAFU9c12, m788getColorWaAFU9c13, m788getColorWaAFU9c14, m788getColorWaAFU9c15, m788getColorWaAFU9c16, m788getColorWaAFU9c17, m788getColorWaAFU9c18, m788getColorWaAFU9c19, colorResourceHelper.m788getColorWaAFU9c(context, R.color.car_cyan_50), m788getColorWaAFU9c20, m788getColorWaAFU9c21, 0L, 0L, 0L, 0L, m788getColorWaAFU9c22, m788getColorWaAFU9c23, 0L, m788getColorWaAFU9c24, colorResourceHelper.m788getColorWaAFU9c(context, R.color.car_green_500), colorResourceHelper.m788getColorWaAFU9c(context, R.color.car_green_600), colorResourceHelper.m788getColorWaAFU9c(context, R.color.car_green_700), colorResourceHelper.m788getColorWaAFU9c(context, R.color.car_green_400), colorResourceHelper.m788getColorWaAFU9c(context, R.color.car_green_50), m788getColorWaAFU9c25, 331350016, 0, null);
    }

    public static final ColorScheme dynamicLightColorScheme(Context context) {
        return Build.VERSION.SDK_INT >= 34 ? dynamicLightColorScheme34(context) : dynamicLightColorScheme31(dynamicTonalPalette(context));
    }

    public static final ColorScheme dynamicLightColorScheme31(TonalPalette tonalPalette) {
        long primary40 = tonalPalette.getPrimary40();
        long primary100 = tonalPalette.getPrimary100();
        long primary90 = tonalPalette.getPrimary90();
        long primary10 = tonalPalette.getPrimary10();
        long primary80 = tonalPalette.getPrimary80();
        long secondary40 = tonalPalette.getSecondary40();
        long secondary100 = tonalPalette.getSecondary100();
        long secondary90 = tonalPalette.getSecondary90();
        long secondary10 = tonalPalette.getSecondary10();
        long tertiary40 = tonalPalette.getTertiary40();
        long tertiary100 = tonalPalette.getTertiary100();
        long tertiary90 = tonalPalette.getTertiary90();
        long tertiary10 = tonalPalette.getTertiary10();
        long neutralVariant98 = tonalPalette.getNeutralVariant98();
        long neutralVariant10 = tonalPalette.getNeutralVariant10();
        long neutralVariant982 = tonalPalette.getNeutralVariant98();
        long neutralVariant102 = tonalPalette.getNeutralVariant10();
        long neutralVariant90 = tonalPalette.getNeutralVariant90();
        long neutralVariant30 = tonalPalette.getNeutralVariant30();
        long neutralVariant20 = tonalPalette.getNeutralVariant20();
        long neutralVariant95 = tonalPalette.getNeutralVariant95();
        long neutralVariant50 = tonalPalette.getNeutralVariant50();
        long neutralVariant80 = tonalPalette.getNeutralVariant80();
        long neutralVariant0 = tonalPalette.getNeutralVariant0();
        long neutralVariant983 = tonalPalette.getNeutralVariant98();
        long neutralVariant87 = tonalPalette.getNeutralVariant87();
        return ColorSchemeKt.m831lightColorSchemeCXl9yA$default(primary40, primary100, primary90, primary10, primary80, secondary40, secondary100, secondary90, secondary10, tertiary40, tertiary100, tertiary90, tertiary10, neutralVariant98, neutralVariant10, neutralVariant982, neutralVariant102, neutralVariant90, neutralVariant30, tonalPalette.getPrimary40(), neutralVariant20, neutralVariant95, 0L, 0L, 0L, 0L, neutralVariant50, neutralVariant80, neutralVariant0, neutralVariant983, tonalPalette.getNeutralVariant94(), tonalPalette.getNeutralVariant92(), tonalPalette.getNeutralVariant90(), tonalPalette.getNeutralVariant96(), tonalPalette.getNeutralVariant100(), neutralVariant87, 62914560, 0, null);
    }

    public static final ColorScheme dynamicLightColorScheme34(Context context) {
        ColorResourceHelper colorResourceHelper = ColorResourceHelper.INSTANCE;
        long m788getColorWaAFU9c = colorResourceHelper.m788getColorWaAFU9c(context, R.color.car_action1_dark);
        long m788getColorWaAFU9c2 = colorResourceHelper.m788getColorWaAFU9c(context, R.color.car_action1_light);
        long m788getColorWaAFU9c3 = colorResourceHelper.m788getColorWaAFU9c(context, R.color.car_accent_light);
        long m788getColorWaAFU9c4 = colorResourceHelper.m788getColorWaAFU9c(context, R.color.car_action1);
        long m788getColorWaAFU9c5 = colorResourceHelper.m788getColorWaAFU9c(context, R.color.car_cyan_50);
        long m788getColorWaAFU9c6 = colorResourceHelper.m788getColorWaAFU9c(context, R.color.car_blue_200);
        long m788getColorWaAFU9c7 = colorResourceHelper.m788getColorWaAFU9c(context, R.color.car_blue_300);
        long m788getColorWaAFU9c8 = colorResourceHelper.m788getColorWaAFU9c(context, R.color.car_background);
        long m788getColorWaAFU9c9 = colorResourceHelper.m788getColorWaAFU9c(context, R.color.car_blue_100);
        long m788getColorWaAFU9c10 = colorResourceHelper.m788getColorWaAFU9c(context, R.color.car_blue_500);
        long m788getColorWaAFU9c11 = colorResourceHelper.m788getColorWaAFU9c(context, R.color.car_blue_600);
        long m788getColorWaAFU9c12 = colorResourceHelper.m788getColorWaAFU9c(context, R.color.car_blue_400);
        long m788getColorWaAFU9c13 = colorResourceHelper.m788getColorWaAFU9c(context, R.color.car_blue_50);
        long m788getColorWaAFU9c14 = colorResourceHelper.m788getColorWaAFU9c(context, R.color.car_blue_700);
        long m788getColorWaAFU9c15 = colorResourceHelper.m788getColorWaAFU9c(context, R.color.car_blue_800);
        long m788getColorWaAFU9c16 = colorResourceHelper.m788getColorWaAFU9c(context, R.color.car_blue_900);
        long m788getColorWaAFU9c17 = colorResourceHelper.m788getColorWaAFU9c(context, R.color.car_blue_grey_800);
        long m788getColorWaAFU9c18 = colorResourceHelper.m788getColorWaAFU9c(context, R.color.car_body3);
        long m788getColorWaAFU9c19 = colorResourceHelper.m788getColorWaAFU9c(context, R.color.car_body3_dark);
        long m788getColorWaAFU9c20 = colorResourceHelper.m788getColorWaAFU9c(context, R.color.car_green_200);
        long m788getColorWaAFU9c21 = colorResourceHelper.m788getColorWaAFU9c(context, R.color.car_green_300);
        long m788getColorWaAFU9c22 = colorResourceHelper.m788getColorWaAFU9c(context, R.color.car_body3_light);
        long m788getColorWaAFU9c23 = colorResourceHelper.m788getColorWaAFU9c(context, R.color.car_highlight_light);
        long m788getColorWaAFU9c24 = colorResourceHelper.m788getColorWaAFU9c(context, R.color.car_body2_dark);
        long m788getColorWaAFU9c25 = colorResourceHelper.m788getColorWaAFU9c(context, R.color.car_body2_light);
        return ColorSchemeKt.m831lightColorSchemeCXl9yA$default(m788getColorWaAFU9c, m788getColorWaAFU9c2, m788getColorWaAFU9c3, m788getColorWaAFU9c4, m788getColorWaAFU9c5, m788getColorWaAFU9c6, m788getColorWaAFU9c7, m788getColorWaAFU9c8, m788getColorWaAFU9c9, m788getColorWaAFU9c10, m788getColorWaAFU9c11, m788getColorWaAFU9c12, m788getColorWaAFU9c13, m788getColorWaAFU9c14, m788getColorWaAFU9c15, m788getColorWaAFU9c16, m788getColorWaAFU9c17, m788getColorWaAFU9c18, m788getColorWaAFU9c19, colorResourceHelper.m788getColorWaAFU9c(context, R.color.car_action1_dark), m788getColorWaAFU9c20, m788getColorWaAFU9c21, 0L, 0L, 0L, 0L, m788getColorWaAFU9c22, m788getColorWaAFU9c23, 0L, m788getColorWaAFU9c24, colorResourceHelper.m788getColorWaAFU9c(context, R.color.car_body1_dark), colorResourceHelper.m788getColorWaAFU9c(context, R.color.car_body1_light), colorResourceHelper.m788getColorWaAFU9c(context, R.color.car_body2), colorResourceHelper.m788getColorWaAFU9c(context, R.color.car_blue_grey_900), colorResourceHelper.m788getColorWaAFU9c(context, R.color.car_body1), m788getColorWaAFU9c25, 331350016, 0, null);
    }

    public static final TonalPalette dynamicTonalPalette(Context context) {
        ColorResourceHelper colorResourceHelper = ColorResourceHelper.INSTANCE;
        return new TonalPalette(colorResourceHelper.m788getColorWaAFU9c(context, R.color.Blue_700), colorResourceHelper.m788getColorWaAFU9c(context, R.color.Blue_800), m844setLuminanceDxMtmZc(colorResourceHelper.m788getColorWaAFU9c(context, R.color.Purple_800), 98.0f), m844setLuminanceDxMtmZc(colorResourceHelper.m788getColorWaAFU9c(context, R.color.Purple_800), 96.0f), colorResourceHelper.m788getColorWaAFU9c(context, R.color.GM2_grey_800), m844setLuminanceDxMtmZc(colorResourceHelper.m788getColorWaAFU9c(context, R.color.Purple_800), 94.0f), m844setLuminanceDxMtmZc(colorResourceHelper.m788getColorWaAFU9c(context, R.color.Purple_800), 92.0f), colorResourceHelper.m788getColorWaAFU9c(context, R.color.Indigo_700), m844setLuminanceDxMtmZc(colorResourceHelper.m788getColorWaAFU9c(context, R.color.Purple_800), 87.0f), colorResourceHelper.m788getColorWaAFU9c(context, R.color.Indigo_800), colorResourceHelper.m788getColorWaAFU9c(context, R.color.Pink_700), colorResourceHelper.m788getColorWaAFU9c(context, R.color.Pink_800), colorResourceHelper.m788getColorWaAFU9c(context, R.color.Purple_700), colorResourceHelper.m788getColorWaAFU9c(context, R.color.Purple_800), colorResourceHelper.m788getColorWaAFU9c(context, R.color.Red_700), m844setLuminanceDxMtmZc(colorResourceHelper.m788getColorWaAFU9c(context, R.color.Purple_800), 24.0f), m844setLuminanceDxMtmZc(colorResourceHelper.m788getColorWaAFU9c(context, R.color.Purple_800), 22.0f), colorResourceHelper.m788getColorWaAFU9c(context, R.color.Red_800), m844setLuminanceDxMtmZc(colorResourceHelper.m788getColorWaAFU9c(context, R.color.Purple_800), 17.0f), m844setLuminanceDxMtmZc(colorResourceHelper.m788getColorWaAFU9c(context, R.color.Purple_800), 12.0f), colorResourceHelper.m788getColorWaAFU9c(context, R.color.Teal_700), m844setLuminanceDxMtmZc(colorResourceHelper.m788getColorWaAFU9c(context, R.color.Purple_800), 6.0f), m844setLuminanceDxMtmZc(colorResourceHelper.m788getColorWaAFU9c(context, R.color.Purple_800), 4.0f), colorResourceHelper.m788getColorWaAFU9c(context, R.color.Teal_800), colorResourceHelper.m788getColorWaAFU9c(context, R.color.accent_device_default), colorResourceHelper.m788getColorWaAFU9c(context, R.color.accent_device_default_50), m844setLuminanceDxMtmZc(colorResourceHelper.m788getColorWaAFU9c(context, R.color.accessibility_focus_highlight), 98.0f), m844setLuminanceDxMtmZc(colorResourceHelper.m788getColorWaAFU9c(context, R.color.accessibility_focus_highlight), 96.0f), colorResourceHelper.m788getColorWaAFU9c(context, R.color.accent_device_default_700), m844setLuminanceDxMtmZc(colorResourceHelper.m788getColorWaAFU9c(context, R.color.accessibility_focus_highlight), 94.0f), m844setLuminanceDxMtmZc(colorResourceHelper.m788getColorWaAFU9c(context, R.color.accessibility_focus_highlight), 92.0f), colorResourceHelper.m788getColorWaAFU9c(context, R.color.accent_device_default_dark), m844setLuminanceDxMtmZc(colorResourceHelper.m788getColorWaAFU9c(context, R.color.accessibility_focus_highlight), 87.0f), colorResourceHelper.m788getColorWaAFU9c(context, R.color.accent_device_default_dark_60_percent_opacity), colorResourceHelper.m788getColorWaAFU9c(context, R.color.accent_device_default_light), colorResourceHelper.m788getColorWaAFU9c(context, R.color.accent_material_dark), colorResourceHelper.m788getColorWaAFU9c(context, R.color.accent_material_light), colorResourceHelper.m788getColorWaAFU9c(context, R.color.accessibility_focus_highlight), colorResourceHelper.m788getColorWaAFU9c(context, R.color.autofill_background_material_dark), m844setLuminanceDxMtmZc(colorResourceHelper.m788getColorWaAFU9c(context, R.color.accessibility_focus_highlight), 24.0f), m844setLuminanceDxMtmZc(colorResourceHelper.m788getColorWaAFU9c(context, R.color.accessibility_focus_highlight), 22.0f), colorResourceHelper.m788getColorWaAFU9c(context, R.color.autofill_background_material_light), m844setLuminanceDxMtmZc(colorResourceHelper.m788getColorWaAFU9c(context, R.color.accessibility_focus_highlight), 17.0f), m844setLuminanceDxMtmZc(colorResourceHelper.m788getColorWaAFU9c(context, R.color.accessibility_focus_highlight), 12.0f), colorResourceHelper.m788getColorWaAFU9c(context, R.color.autofilled_highlight), m844setLuminanceDxMtmZc(colorResourceHelper.m788getColorWaAFU9c(context, R.color.accessibility_focus_highlight), 6.0f), m844setLuminanceDxMtmZc(colorResourceHelper.m788getColorWaAFU9c(context, R.color.accessibility_focus_highlight), 4.0f), colorResourceHelper.m788getColorWaAFU9c(context, R.color.background_cache_hint_selector_device_default), colorResourceHelper.m788getColorWaAFU9c(context, R.color.background_cache_hint_selector_holo_dark), colorResourceHelper.m788getColorWaAFU9c(context, R.color.background_cache_hint_selector_holo_light), colorResourceHelper.m788getColorWaAFU9c(context, R.color.background_cache_hint_selector_material_dark), colorResourceHelper.m788getColorWaAFU9c(context, R.color.background_cache_hint_selector_material_light), colorResourceHelper.m788getColorWaAFU9c(context, R.color.background_device_default_dark), colorResourceHelper.m788getColorWaAFU9c(context, R.color.background_device_default_light), colorResourceHelper.m788getColorWaAFU9c(context, R.color.background_floating_device_default_dark), colorResourceHelper.m788getColorWaAFU9c(context, R.color.background_floating_device_default_light), colorResourceHelper.m788getColorWaAFU9c(context, R.color.background_floating_material_dark), colorResourceHelper.m788getColorWaAFU9c(context, R.color.background_floating_material_light), colorResourceHelper.m788getColorWaAFU9c(context, R.color.background_holo_dark), colorResourceHelper.m788getColorWaAFU9c(context, R.color.background_holo_light), colorResourceHelper.m788getColorWaAFU9c(context, R.color.background_leanback_dark), colorResourceHelper.m788getColorWaAFU9c(context, R.color.background_leanback_light), colorResourceHelper.m788getColorWaAFU9c(context, R.color.background_material_dark), colorResourceHelper.m788getColorWaAFU9c(context, R.color.background_material_light), colorResourceHelper.m788getColorWaAFU9c(context, R.color.bright_foreground_dark), colorResourceHelper.m788getColorWaAFU9c(context, R.color.bright_foreground_dark_disabled), colorResourceHelper.m788getColorWaAFU9c(context, R.color.bright_foreground_dark_inverse), colorResourceHelper.m788getColorWaAFU9c(context, R.color.bright_foreground_disabled_holo_dark), colorResourceHelper.m788getColorWaAFU9c(context, R.color.bright_foreground_disabled_holo_light), colorResourceHelper.m788getColorWaAFU9c(context, R.color.bright_foreground_holo_dark), colorResourceHelper.m788getColorWaAFU9c(context, R.color.bright_foreground_holo_light), colorResourceHelper.m788getColorWaAFU9c(context, R.color.bright_foreground_inverse_holo_dark), colorResourceHelper.m788getColorWaAFU9c(context, R.color.bright_foreground_inverse_holo_light), colorResourceHelper.m788getColorWaAFU9c(context, R.color.bright_foreground_light), colorResourceHelper.m788getColorWaAFU9c(context, R.color.bright_foreground_light_disabled), colorResourceHelper.m788getColorWaAFU9c(context, R.color.bright_foreground_light_inverse), colorResourceHelper.m788getColorWaAFU9c(context, R.color.btn_colored_background_material), colorResourceHelper.m788getColorWaAFU9c(context, R.color.btn_colored_borderless_text_material), colorResourceHelper.m788getColorWaAFU9c(context, R.color.btn_colored_text_material), colorResourceHelper.m788getColorWaAFU9c(context, R.color.btn_default_material_dark), colorResourceHelper.m788getColorWaAFU9c(context, R.color.btn_default_material_light), colorResourceHelper.m788getColorWaAFU9c(context, R.color.btn_watch_default_dark), colorResourceHelper.m788getColorWaAFU9c(context, R.color.button_material_dark), colorResourceHelper.m788getColorWaAFU9c(context, R.color.button_material_light), colorResourceHelper.m788getColorWaAFU9c(context, R.color.button_normal_device_default_dark), colorResourceHelper.m788getColorWaAFU9c(context, R.color.car_accent), colorResourceHelper.m788getColorWaAFU9c(context, R.color.car_accent_dark), null);
    }

    private static final float labInvf(float f5) {
        float f6 = f5 * f5 * f5;
        return f6 > 0.008856452f ? f6 : ((116 * f5) - 16) / 903.2963f;
    }

    /* renamed from: setLuminance-DxMtmZc, reason: not valid java name */
    public static final long m844setLuminanceDxMtmZc(long j5, float f5) {
        double d5 = f5;
        if ((d5 < 1.0E-4d) || (d5 > 99.9999d)) {
            int delinearized = delinearized(100 * labInvf((f5 + 16) / 116));
            return ColorKt.Color$default(delinearized, delinearized, delinearized, 0, 8, null);
        }
        ColorSpaces colorSpaces = ColorSpaces.INSTANCE;
        long m1483convertvNxB06k = Color.m1483convertvNxB06k(j5, colorSpaces.getCieLab());
        return Color.m1483convertvNxB06k(ColorKt.Color$default(f5, Color.m1491getGreenimpl(m1483convertvNxB06k), Color.m1489getBlueimpl(m1483convertvNxB06k), 0.0f, colorSpaces.getCieLab(), 8, null), colorSpaces.getSrgb());
    }
}
