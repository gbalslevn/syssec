package androidx.compose.material3;

import androidx.compose.material3.tokens.SwitchTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J²\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010\u0012\u001a\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u0014\u001a\u00020\u00072\b\b\u0002\u0010\u0015\u001a\u00020\u00072\b\b\u0002\u0010\u0016\u001a\u00020\u00072\b\b\u0002\u0010\u0017\u001a\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001b\u001a\u00020\u001a8\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0018\u0010\"\u001a\u00020\u0004*\u00020\u001f8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b \u0010!\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006#"}, d2 = {"Landroidx/compose/material3/SwitchDefaults;", BuildConfig.FLAVOR, "<init>", "()V", "Landroidx/compose/material3/SwitchColors;", "colors", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/SwitchColors;", "Landroidx/compose/ui/graphics/Color;", "checkedThumbColor", "checkedTrackColor", "checkedBorderColor", "checkedIconColor", "uncheckedThumbColor", "uncheckedTrackColor", "uncheckedBorderColor", "uncheckedIconColor", "disabledCheckedThumbColor", "disabledCheckedTrackColor", "disabledCheckedBorderColor", "disabledCheckedIconColor", "disabledUncheckedThumbColor", "disabledUncheckedTrackColor", "disabledUncheckedBorderColor", "disabledUncheckedIconColor", "colors-V1nXRL4", "(JJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/SwitchColors;", "Landroidx/compose/ui/unit/Dp;", "IconSize", "F", "getIconSize-D9Ej5fM", "()F", "Landroidx/compose/material3/ColorScheme;", "getDefaultSwitchColors$material3_release", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/SwitchColors;", "defaultSwitchColors", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SwitchDefaults {
    public static final int $stable = 0;
    public static final SwitchDefaults INSTANCE = new SwitchDefaults();
    private static final float IconSize = Dp.m2599constructorimpl(16);

    private SwitchDefaults() {
    }

    public final SwitchColors colors(Composer composer, int i5) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(435552781, i5, -1, "androidx.compose.material3.SwitchDefaults.colors (Switch.kt:299)");
        }
        SwitchColors defaultSwitchColors$material3_release = getDefaultSwitchColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return defaultSwitchColors$material3_release;
    }

    /* renamed from: colors-V1nXRL4, reason: not valid java name */
    public final SwitchColors m912colorsV1nXRL4(long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, Composer composer, int i5, int i6, int i7) {
        long j21;
        long j22;
        long j23;
        long j24;
        long j25;
        long j26;
        int i8;
        long j27;
        long j28;
        long j29;
        long j30;
        long j31;
        long j32;
        long j33;
        long j34;
        long value = (i7 & 1) != 0 ? ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getSelectedHandleColor(), composer, 6) : j5;
        long value2 = (i7 & 2) != 0 ? ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getSelectedTrackColor(), composer, 6) : j6;
        long m1500getTransparent0d7_KjU = (i7 & 4) != 0 ? Color.INSTANCE.m1500getTransparent0d7_KjU() : j7;
        long value3 = (i7 & 8) != 0 ? ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getSelectedIconColor(), composer, 6) : j8;
        long value4 = (i7 & 16) != 0 ? ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getUnselectedHandleColor(), composer, 6) : j9;
        long value5 = (i7 & 32) != 0 ? ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getUnselectedTrackColor(), composer, 6) : j10;
        long value6 = (i7 & 64) != 0 ? ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getUnselectedFocusTrackOutlineColor(), composer, 6) : j11;
        long value7 = (i7 & 128) != 0 ? ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getUnselectedIconColor(), composer, 6) : j12;
        if ((i7 & 256) != 0) {
            SwitchTokens switchTokens = SwitchTokens.INSTANCE;
            j22 = value5;
            j21 = value;
            j23 = ColorKt.m1505compositeOverOWjLjI(Color.m1485copywmQWz5c$default(ColorSchemeKt.getValue(switchTokens.getDisabledSelectedHandleColor(), composer, 6), switchTokens.getDisabledSelectedHandleOpacity(), 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.INSTANCE.getColorScheme(composer, 6).getSurface());
        } else {
            j21 = value;
            j22 = value5;
            j23 = j13;
        }
        if ((i7 & 512) != 0) {
            SwitchTokens switchTokens2 = SwitchTokens.INSTANCE;
            j24 = ColorKt.m1505compositeOverOWjLjI(Color.m1485copywmQWz5c$default(ColorSchemeKt.getValue(switchTokens2.getDisabledSelectedTrackColor(), composer, 6), switchTokens2.getDisabledTrackOpacity(), 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.INSTANCE.getColorScheme(composer, 6).getSurface());
        } else {
            j24 = j14;
        }
        long m1500getTransparent0d7_KjU2 = (i7 & 1024) != 0 ? Color.INSTANCE.m1500getTransparent0d7_KjU() : j15;
        if ((i7 & 2048) != 0) {
            SwitchTokens switchTokens3 = SwitchTokens.INSTANCE;
            j26 = j24;
            i8 = 6;
            j25 = j23;
            j27 = ColorKt.m1505compositeOverOWjLjI(Color.m1485copywmQWz5c$default(ColorSchemeKt.getValue(switchTokens3.getDisabledSelectedIconColor(), composer, 6), switchTokens3.getDisabledSelectedIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.INSTANCE.getColorScheme(composer, 6).getSurface());
        } else {
            j25 = j23;
            j26 = j24;
            i8 = 6;
            j27 = j16;
        }
        if ((i7 & 4096) != 0) {
            SwitchTokens switchTokens4 = SwitchTokens.INSTANCE;
            long m1485copywmQWz5c$default = Color.m1485copywmQWz5c$default(ColorSchemeKt.getValue(switchTokens4.getDisabledUnselectedHandleColor(), composer, i8), switchTokens4.getDisabledUnselectedHandleOpacity(), 0.0f, 0.0f, 0.0f, 14, null);
            i8 = 6;
            j28 = j27;
            j29 = ColorKt.m1505compositeOverOWjLjI(m1485copywmQWz5c$default, MaterialTheme.INSTANCE.getColorScheme(composer, 6).getSurface());
        } else {
            j28 = j27;
            j29 = j17;
        }
        if ((i7 & 8192) != 0) {
            SwitchTokens switchTokens5 = SwitchTokens.INSTANCE;
            long m1485copywmQWz5c$default2 = Color.m1485copywmQWz5c$default(ColorSchemeKt.getValue(switchTokens5.getDisabledUnselectedTrackColor(), composer, i8), switchTokens5.getDisabledTrackOpacity(), 0.0f, 0.0f, 0.0f, 14, null);
            i8 = 6;
            j30 = j29;
            j31 = ColorKt.m1505compositeOverOWjLjI(m1485copywmQWz5c$default2, MaterialTheme.INSTANCE.getColorScheme(composer, 6).getSurface());
        } else {
            j30 = j29;
            j31 = j18;
        }
        if ((i7 & 16384) != 0) {
            SwitchTokens switchTokens6 = SwitchTokens.INSTANCE;
            long m1485copywmQWz5c$default3 = Color.m1485copywmQWz5c$default(ColorSchemeKt.getValue(switchTokens6.getDisabledUnselectedTrackOutlineColor(), composer, i8), switchTokens6.getDisabledTrackOpacity(), 0.0f, 0.0f, 0.0f, 14, null);
            i8 = 6;
            j32 = j31;
            j33 = ColorKt.m1505compositeOverOWjLjI(m1485copywmQWz5c$default3, MaterialTheme.INSTANCE.getColorScheme(composer, 6).getSurface());
        } else {
            j32 = j31;
            j33 = j19;
        }
        if ((i7 & 32768) != 0) {
            SwitchTokens switchTokens7 = SwitchTokens.INSTANCE;
            j34 = ColorKt.m1505compositeOverOWjLjI(Color.m1485copywmQWz5c$default(ColorSchemeKt.getValue(switchTokens7.getDisabledUnselectedIconColor(), composer, i8), switchTokens7.getDisabledUnselectedIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.INSTANCE.getColorScheme(composer, 6).getSurface());
        } else {
            j34 = j20;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1937926421, i5, i6, "androidx.compose.material3.SwitchDefaults.colors (Switch.kt:362)");
        }
        SwitchColors switchColors = new SwitchColors(j21, value2, m1500getTransparent0d7_KjU, value3, value4, j22, value6, value7, j25, j26, m1500getTransparent0d7_KjU2, j28, j30, j32, j33, j34, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return switchColors;
    }

    public final SwitchColors getDefaultSwitchColors$material3_release(ColorScheme colorScheme) {
        SwitchColors defaultSwitchColorsCached = colorScheme.getDefaultSwitchColorsCached();
        if (defaultSwitchColorsCached != null) {
            return defaultSwitchColorsCached;
        }
        SwitchTokens switchTokens = SwitchTokens.INSTANCE;
        long fromToken = ColorSchemeKt.fromToken(colorScheme, switchTokens.getSelectedHandleColor());
        long fromToken2 = ColorSchemeKt.fromToken(colorScheme, switchTokens.getSelectedTrackColor());
        Color.Companion companion = Color.INSTANCE;
        SwitchColors switchColors = new SwitchColors(fromToken, fromToken2, companion.m1500getTransparent0d7_KjU(), ColorSchemeKt.fromToken(colorScheme, switchTokens.getSelectedIconColor()), ColorSchemeKt.fromToken(colorScheme, switchTokens.getUnselectedHandleColor()), ColorSchemeKt.fromToken(colorScheme, switchTokens.getUnselectedTrackColor()), ColorSchemeKt.fromToken(colorScheme, switchTokens.getUnselectedFocusTrackOutlineColor()), ColorSchemeKt.fromToken(colorScheme, switchTokens.getUnselectedIconColor()), ColorKt.m1505compositeOverOWjLjI(Color.m1485copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, switchTokens.getDisabledSelectedHandleColor()), switchTokens.getDisabledSelectedHandleOpacity(), 0.0f, 0.0f, 0.0f, 14, null), colorScheme.getSurface()), ColorKt.m1505compositeOverOWjLjI(Color.m1485copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, switchTokens.getDisabledSelectedTrackColor()), switchTokens.getDisabledTrackOpacity(), 0.0f, 0.0f, 0.0f, 14, null), colorScheme.getSurface()), companion.m1500getTransparent0d7_KjU(), ColorKt.m1505compositeOverOWjLjI(Color.m1485copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, switchTokens.getDisabledSelectedIconColor()), switchTokens.getDisabledSelectedIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null), colorScheme.getSurface()), ColorKt.m1505compositeOverOWjLjI(Color.m1485copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, switchTokens.getDisabledUnselectedHandleColor()), switchTokens.getDisabledUnselectedHandleOpacity(), 0.0f, 0.0f, 0.0f, 14, null), colorScheme.getSurface()), ColorKt.m1505compositeOverOWjLjI(Color.m1485copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, switchTokens.getDisabledUnselectedTrackColor()), switchTokens.getDisabledTrackOpacity(), 0.0f, 0.0f, 0.0f, 14, null), colorScheme.getSurface()), ColorKt.m1505compositeOverOWjLjI(Color.m1485copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, switchTokens.getDisabledUnselectedTrackOutlineColor()), switchTokens.getDisabledTrackOpacity(), 0.0f, 0.0f, 0.0f, 14, null), colorScheme.getSurface()), ColorKt.m1505compositeOverOWjLjI(Color.m1485copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, switchTokens.getDisabledUnselectedIconColor()), switchTokens.getDisabledUnselectedIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null), colorScheme.getSurface()), null);
        colorScheme.setDefaultSwitchColorsCached$material3_release(switchColors);
        return switchColors;
    }
}
