package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.material3.tokens.InputChipTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0006JN\u0010\u0011\u001a\u00020\u000e2\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J^\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u00152\b\b\u0002\u0010\u0019\u001a\u00020\u00152\b\b\u0002\u0010\u001a\u001a\u00020\u00072\b\b\u0002\u0010\u001b\u001a\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eR\u001d\u0010 \u001a\u00020\u00078\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001d\u0010$\u001a\u00020\u00078\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b$\u0010!\u001a\u0004\b%\u0010#R\u001d\u0010&\u001a\u00020\u00078\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b&\u0010!\u001a\u0004\b'\u0010#R\u0018\u0010+\u001a\u00020\u0004*\u00020(8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0011\u0010/\u001a\u00020,8G¢\u0006\u0006\u001a\u0004\b-\u0010.\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00060"}, d2 = {"Landroidx/compose/material3/InputChipDefaults;", BuildConfig.FLAVOR, "<init>", "()V", "Landroidx/compose/material3/SelectableChipColors;", "inputChipColors", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/SelectableChipColors;", "Landroidx/compose/ui/unit/Dp;", "elevation", "pressedElevation", "focusedElevation", "hoveredElevation", "draggedElevation", "disabledElevation", "Landroidx/compose/material3/SelectableChipElevation;", "inputChipElevation-aqJV_2Y", "(FFFFFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SelectableChipElevation;", "inputChipElevation", BuildConfig.FLAVOR, "enabled", "selected", "Landroidx/compose/ui/graphics/Color;", "borderColor", "selectedBorderColor", "disabledBorderColor", "disabledSelectedBorderColor", "borderWidth", "selectedBorderWidth", "Landroidx/compose/foundation/BorderStroke;", "inputChipBorder-_7El2pE", "(ZZJJJJFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/BorderStroke;", "inputChipBorder", "Height", "F", "getHeight-D9Ej5fM", "()F", "IconSize", "getIconSize-D9Ej5fM", "AvatarSize", "getAvatarSize-D9Ej5fM", "Landroidx/compose/material3/ColorScheme;", "getDefaultInputChipColors$material3_release", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/SelectableChipColors;", "defaultInputChipColors", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "shape", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class InputChipDefaults {
    private static final float AvatarSize;
    private static final float Height;
    public static final InputChipDefaults INSTANCE = new InputChipDefaults();
    private static final float IconSize;

    static {
        InputChipTokens inputChipTokens = InputChipTokens.INSTANCE;
        Height = inputChipTokens.m1091getContainerHeightD9Ej5fM();
        IconSize = inputChipTokens.m1093getLeadingIconSizeD9Ej5fM();
        AvatarSize = inputChipTokens.m1089getAvatarSizeD9Ej5fM();
    }

    private InputChipDefaults() {
    }

    public final SelectableChipColors getDefaultInputChipColors$material3_release(ColorScheme colorScheme) {
        SelectableChipColors defaultInputChipColorsCached = colorScheme.getDefaultInputChipColorsCached();
        if (defaultInputChipColorsCached != null) {
            return defaultInputChipColorsCached;
        }
        Color.Companion companion = Color.INSTANCE;
        long m1500getTransparent0d7_KjU = companion.m1500getTransparent0d7_KjU();
        InputChipTokens inputChipTokens = InputChipTokens.INSTANCE;
        SelectableChipColors selectableChipColors = new SelectableChipColors(m1500getTransparent0d7_KjU, ColorSchemeKt.fromToken(colorScheme, inputChipTokens.getUnselectedLabelTextColor()), ColorSchemeKt.fromToken(colorScheme, inputChipTokens.getUnselectedLeadingIconColor()), ColorSchemeKt.fromToken(colorScheme, inputChipTokens.getUnselectedTrailingIconColor()), companion.m1500getTransparent0d7_KjU(), Color.m1485copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, inputChipTokens.getDisabledLabelTextColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), Color.m1485copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, inputChipTokens.getDisabledLeadingIconColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), Color.m1485copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, inputChipTokens.getDisabledTrailingIconColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, inputChipTokens.getSelectedContainerColor()), Color.m1485copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, inputChipTokens.getDisabledSelectedContainerColor()), 0.12f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, inputChipTokens.getSelectedLabelTextColor()), ColorSchemeKt.fromToken(colorScheme, inputChipTokens.getSelectedLeadingIconColor()), ColorSchemeKt.fromToken(colorScheme, inputChipTokens.getSelectedTrailingIconColor()), null);
        colorScheme.setDefaultInputChipColorsCached$material3_release(selectableChipColors);
        return selectableChipColors;
    }

    /* renamed from: getHeight-D9Ej5fM, reason: not valid java name */
    public final float m860getHeightD9Ej5fM() {
        return Height;
    }

    public final Shape getShape(Composer composer, int i5) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1052444143, i5, -1, "androidx.compose.material3.InputChipDefaults.<get-shape> (Chip.kt:1721)");
        }
        Shape value = ShapesKt.getValue(InputChipTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return value;
    }

    /* renamed from: inputChipBorder-_7El2pE, reason: not valid java name */
    public final BorderStroke m861inputChipBorder_7El2pE(boolean z5, boolean z6, long j5, long j6, long j7, long j8, float f5, float f6, Composer composer, int i5, int i6) {
        long value = (i6 & 4) != 0 ? ColorSchemeKt.getValue(InputChipTokens.INSTANCE.getUnselectedOutlineColor(), composer, 6) : j5;
        long m1500getTransparent0d7_KjU = (i6 & 8) != 0 ? Color.INSTANCE.m1500getTransparent0d7_KjU() : j6;
        long m1485copywmQWz5c$default = (i6 & 16) != 0 ? Color.m1485copywmQWz5c$default(ColorSchemeKt.getValue(InputChipTokens.INSTANCE.getDisabledUnselectedOutlineColor(), composer, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, null) : j7;
        long m1500getTransparent0d7_KjU2 = (i6 & 32) != 0 ? Color.INSTANCE.m1500getTransparent0d7_KjU() : j8;
        float m1095getUnselectedOutlineWidthD9Ej5fM = (i6 & 64) != 0 ? InputChipTokens.INSTANCE.m1095getUnselectedOutlineWidthD9Ej5fM() : f5;
        float m1094getSelectedOutlineWidthD9Ej5fM = (i6 & 128) != 0 ? InputChipTokens.INSTANCE.m1094getSelectedOutlineWidthD9Ej5fM() : f6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2050575347, i5, -1, "androidx.compose.material3.InputChipDefaults.inputChipBorder (Chip.kt:1709)");
        }
        if (!z5) {
            value = z6 ? m1500getTransparent0d7_KjU2 : m1485copywmQWz5c$default;
        } else if (z6) {
            value = m1500getTransparent0d7_KjU;
        }
        if (z6) {
            m1095getUnselectedOutlineWidthD9Ej5fM = m1094getSelectedOutlineWidthD9Ej5fM;
        }
        BorderStroke m117BorderStrokecXLIe8U = BorderStrokeKt.m117BorderStrokecXLIe8U(m1095getUnselectedOutlineWidthD9Ej5fM, value);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return m117BorderStrokecXLIe8U;
    }

    public final SelectableChipColors inputChipColors(Composer composer, int i5) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-770375587, i5, -1, "androidx.compose.material3.InputChipDefaults.inputChipColors (Chip.kt:1568)");
        }
        SelectableChipColors defaultInputChipColors$material3_release = getDefaultInputChipColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return defaultInputChipColors$material3_release;
    }

    /* renamed from: inputChipElevation-aqJV_2Y, reason: not valid java name */
    public final SelectableChipElevation m862inputChipElevationaqJV_2Y(float f5, float f6, float f7, float f8, float f9, float f10, Composer composer, int i5, int i6) {
        if ((i6 & 1) != 0) {
            f5 = InputChipTokens.INSTANCE.m1090getContainerElevationD9Ej5fM();
        }
        float f11 = (i6 & 2) != 0 ? f5 : f6;
        float f12 = (i6 & 4) != 0 ? f5 : f7;
        float f13 = (i6 & 8) != 0 ? f5 : f8;
        if ((i6 & 16) != 0) {
            f9 = InputChipTokens.INSTANCE.m1092getDraggedContainerElevationD9Ej5fM();
        }
        float f14 = f9;
        float f15 = (i6 & 32) != 0 ? f5 : f10;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1745270109, i5, -1, "androidx.compose.material3.InputChipDefaults.inputChipElevation (Chip.kt:1672)");
        }
        SelectableChipElevation selectableChipElevation = new SelectableChipElevation(f5, f11, f12, f13, f14, f15, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return selectableChipElevation;
    }
}
