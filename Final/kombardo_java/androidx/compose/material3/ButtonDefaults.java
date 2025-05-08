package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.tokens.FilledButtonTokens;
import androidx.compose.material3.tokens.TextButtonTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J:\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u000e\u0010\u0006J:\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\rJD\u0010\u0019\u001a\u00020\u00162\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u00102\b\b\u0002\u0010\u0014\u001a\u00020\u00102\b\b\u0002\u0010\u0015\u001a\u00020\u0010H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001a\u001a\u00020\u00108\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u00108\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u001c\u0010\u001bR\u0017\u0010\u001e\u001a\u00020\u001d8\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\u00108\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\"\u0010\u001bR\u0017\u0010#\u001a\u00020\u001d8\u0006¢\u0006\f\n\u0004\b#\u0010\u001f\u001a\u0004\b$\u0010!R\u001a\u0010%\u001a\u00020\u00108\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b%\u0010\u001bR\u0017\u0010&\u001a\u00020\u001d8\u0006¢\u0006\f\n\u0004\b&\u0010\u001f\u001a\u0004\b'\u0010!R\u001a\u0010(\u001a\u00020\u00108\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b(\u0010\u001bR\u0017\u0010)\u001a\u00020\u001d8\u0006¢\u0006\f\n\u0004\b)\u0010\u001f\u001a\u0004\b*\u0010!R\u001d\u0010+\u001a\u00020\u00108\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b+\u0010\u001b\u001a\u0004\b,\u0010-R\u001d\u0010.\u001a\u00020\u00108\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b.\u0010\u001b\u001a\u0004\b/\u0010-R\u001d\u00100\u001a\u00020\u00108\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b0\u0010\u001b\u001a\u0004\b1\u0010-R\u001d\u00102\u001a\u00020\u00108\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b2\u0010\u001b\u001a\u0004\b3\u0010-R\u0011\u00107\u001a\u0002048G¢\u0006\u0006\u001a\u0004\b5\u00106R\u0011\u00109\u001a\u0002048G¢\u0006\u0006\u001a\u0004\b8\u00106R\u0018\u0010=\u001a\u00020\u0004*\u00020:8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b;\u0010<R\u0018\u0010?\u001a\u00020\u0004*\u00020:8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b>\u0010<\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006@"}, d2 = {"Landroidx/compose/material3/ButtonDefaults;", BuildConfig.FLAVOR, "<init>", "()V", "Landroidx/compose/material3/ButtonColors;", "buttonColors", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/ButtonColors;", "Landroidx/compose/ui/graphics/Color;", "containerColor", "contentColor", "disabledContainerColor", "disabledContentColor", "buttonColors-ro_MJ88", "(JJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/ButtonColors;", "textButtonColors", "textButtonColors-ro_MJ88", "Landroidx/compose/ui/unit/Dp;", "defaultElevation", "pressedElevation", "focusedElevation", "hoveredElevation", "disabledElevation", "Landroidx/compose/material3/ButtonElevation;", "buttonElevation-R_JCAzs", "(FFFFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/ButtonElevation;", "buttonElevation", "ButtonHorizontalPadding", "F", "ButtonVerticalPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "ContentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getContentPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "ButtonWithIconHorizontalStartPadding", "ButtonWithIconContentPadding", "getButtonWithIconContentPadding", "TextButtonHorizontalPadding", "TextButtonContentPadding", "getTextButtonContentPadding", "TextButtonWithIconHorizontalEndPadding", "TextButtonWithIconContentPadding", "getTextButtonWithIconContentPadding", "MinWidth", "getMinWidth-D9Ej5fM", "()F", "MinHeight", "getMinHeight-D9Ej5fM", "IconSize", "getIconSize-D9Ej5fM", "IconSpacing", "getIconSpacing-D9Ej5fM", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "shape", "getTextShape", "textShape", "Landroidx/compose/material3/ColorScheme;", "getDefaultButtonColors$material3_release", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/ButtonColors;", "defaultButtonColors", "getDefaultTextButtonColors$material3_release", "defaultTextButtonColors", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ButtonDefaults {
    public static final int $stable = 0;
    private static final float ButtonHorizontalPadding;
    private static final float ButtonVerticalPadding;
    private static final PaddingValues ButtonWithIconContentPadding;
    private static final float ButtonWithIconHorizontalStartPadding;
    private static final PaddingValues ContentPadding;
    public static final ButtonDefaults INSTANCE = new ButtonDefaults();
    private static final float IconSize;
    private static final float IconSpacing;
    private static final float MinHeight;
    private static final float MinWidth;
    private static final PaddingValues TextButtonContentPadding;
    private static final float TextButtonHorizontalPadding;
    private static final PaddingValues TextButtonWithIconContentPadding;
    private static final float TextButtonWithIconHorizontalEndPadding;

    static {
        float m2599constructorimpl = Dp.m2599constructorimpl(24);
        ButtonHorizontalPadding = m2599constructorimpl;
        float f5 = 8;
        float m2599constructorimpl2 = Dp.m2599constructorimpl(f5);
        ButtonVerticalPadding = m2599constructorimpl2;
        PaddingValues m309PaddingValuesa9UjIt4 = PaddingKt.m309PaddingValuesa9UjIt4(m2599constructorimpl, m2599constructorimpl2, m2599constructorimpl, m2599constructorimpl2);
        ContentPadding = m309PaddingValuesa9UjIt4;
        float f6 = 16;
        float m2599constructorimpl3 = Dp.m2599constructorimpl(f6);
        ButtonWithIconHorizontalStartPadding = m2599constructorimpl3;
        ButtonWithIconContentPadding = PaddingKt.m309PaddingValuesa9UjIt4(m2599constructorimpl3, m2599constructorimpl2, m2599constructorimpl, m2599constructorimpl2);
        float m2599constructorimpl4 = Dp.m2599constructorimpl(12);
        TextButtonHorizontalPadding = m2599constructorimpl4;
        TextButtonContentPadding = PaddingKt.m309PaddingValuesa9UjIt4(m2599constructorimpl4, m309PaddingValuesa9UjIt4.getTop(), m2599constructorimpl4, m309PaddingValuesa9UjIt4.getBottom());
        float m2599constructorimpl5 = Dp.m2599constructorimpl(f6);
        TextButtonWithIconHorizontalEndPadding = m2599constructorimpl5;
        TextButtonWithIconContentPadding = PaddingKt.m309PaddingValuesa9UjIt4(m2599constructorimpl4, m309PaddingValuesa9UjIt4.getTop(), m2599constructorimpl5, m309PaddingValuesa9UjIt4.getBottom());
        MinWidth = Dp.m2599constructorimpl(58);
        MinHeight = Dp.m2599constructorimpl(40);
        IconSize = FilledButtonTokens.INSTANCE.m1085getIconSizeD9Ej5fM();
        IconSpacing = Dp.m2599constructorimpl(f5);
    }

    private ButtonDefaults() {
    }

    public final ButtonColors buttonColors(Composer composer, int i5) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1449248637, i5, -1, "androidx.compose.material3.ButtonDefaults.buttonColors (Button.kt:564)");
        }
        ButtonColors defaultButtonColors$material3_release = getDefaultButtonColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return defaultButtonColors$material3_release;
    }

    /* renamed from: buttonColors-ro_MJ88, reason: not valid java name */
    public final ButtonColors m779buttonColorsro_MJ88(long j5, long j6, long j7, long j8, Composer composer, int i5, int i6) {
        long m1501getUnspecified0d7_KjU = (i6 & 1) != 0 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : j5;
        long m1501getUnspecified0d7_KjU2 = (i6 & 2) != 0 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : j6;
        long m1501getUnspecified0d7_KjU3 = (i6 & 4) != 0 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : j7;
        long m1501getUnspecified0d7_KjU4 = (i6 & 8) != 0 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : j8;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-339300779, i5, -1, "androidx.compose.material3.ButtonDefaults.buttonColors (Button.kt:582)");
        }
        ButtonColors m778copyjRlVdoo = getDefaultButtonColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).m778copyjRlVdoo(m1501getUnspecified0d7_KjU, m1501getUnspecified0d7_KjU2, m1501getUnspecified0d7_KjU3, m1501getUnspecified0d7_KjU4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return m778copyjRlVdoo;
    }

    /* renamed from: buttonElevation-R_JCAzs, reason: not valid java name */
    public final ButtonElevation m780buttonElevationR_JCAzs(float f5, float f6, float f7, float f8, float f9, Composer composer, int i5, int i6) {
        if ((i6 & 1) != 0) {
            f5 = FilledButtonTokens.INSTANCE.m1081getContainerElevationD9Ej5fM();
        }
        if ((i6 & 2) != 0) {
            f6 = FilledButtonTokens.INSTANCE.m1086getPressedContainerElevationD9Ej5fM();
        }
        float f10 = f6;
        if ((i6 & 4) != 0) {
            f7 = FilledButtonTokens.INSTANCE.m1083getFocusContainerElevationD9Ej5fM();
        }
        float f11 = f7;
        if ((i6 & 8) != 0) {
            f8 = FilledButtonTokens.INSTANCE.m1084getHoverContainerElevationD9Ej5fM();
        }
        float f12 = f8;
        if ((i6 & 16) != 0) {
            f9 = FilledButtonTokens.INSTANCE.m1082getDisabledContainerElevationD9Ej5fM();
        }
        float f13 = f9;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1827791191, i5, -1, "androidx.compose.material3.ButtonDefaults.buttonElevation (Button.kt:802)");
        }
        ButtonElevation buttonElevation = new ButtonElevation(f5, f10, f11, f12, f13, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return buttonElevation;
    }

    public final PaddingValues getContentPadding() {
        return ContentPadding;
    }

    public final ButtonColors getDefaultButtonColors$material3_release(ColorScheme colorScheme) {
        ButtonColors defaultButtonColorsCached = colorScheme.getDefaultButtonColorsCached();
        if (defaultButtonColorsCached != null) {
            return defaultButtonColorsCached;
        }
        FilledButtonTokens filledButtonTokens = FilledButtonTokens.INSTANCE;
        ButtonColors buttonColors = new ButtonColors(ColorSchemeKt.fromToken(colorScheme, filledButtonTokens.getContainerColor()), ColorSchemeKt.fromToken(colorScheme, filledButtonTokens.getLabelTextColor()), Color.m1485copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, filledButtonTokens.getDisabledContainerColor()), 0.12f, 0.0f, 0.0f, 0.0f, 14, null), Color.m1485copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, filledButtonTokens.getDisabledLabelTextColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), null);
        colorScheme.setDefaultButtonColorsCached$material3_release(buttonColors);
        return buttonColors;
    }

    public final ButtonColors getDefaultTextButtonColors$material3_release(ColorScheme colorScheme) {
        ButtonColors defaultTextButtonColorsCached = colorScheme.getDefaultTextButtonColorsCached();
        if (defaultTextButtonColorsCached != null) {
            return defaultTextButtonColorsCached;
        }
        Color.Companion companion = Color.INSTANCE;
        long m1500getTransparent0d7_KjU = companion.m1500getTransparent0d7_KjU();
        TextButtonTokens textButtonTokens = TextButtonTokens.INSTANCE;
        ButtonColors buttonColors = new ButtonColors(m1500getTransparent0d7_KjU, ColorSchemeKt.fromToken(colorScheme, textButtonTokens.getLabelTextColor()), companion.m1500getTransparent0d7_KjU(), Color.m1485copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, textButtonTokens.getDisabledLabelTextColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), null);
        colorScheme.setDefaultTextButtonColorsCached$material3_release(buttonColors);
        return buttonColors;
    }

    /* renamed from: getMinHeight-D9Ej5fM, reason: not valid java name */
    public final float m781getMinHeightD9Ej5fM() {
        return MinHeight;
    }

    /* renamed from: getMinWidth-D9Ej5fM, reason: not valid java name */
    public final float m782getMinWidthD9Ej5fM() {
        return MinWidth;
    }

    public final Shape getShape(Composer composer, int i5) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1234923021, i5, -1, "androidx.compose.material3.ButtonDefaults.<get-shape> (Button.kt:542)");
        }
        Shape value = ShapesKt.getValue(FilledButtonTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return value;
    }

    public final PaddingValues getTextButtonContentPadding() {
        return TextButtonContentPadding;
    }

    public final Shape getTextShape(Composer composer, int i5) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-349121587, i5, -1, "androidx.compose.material3.ButtonDefaults.<get-textShape> (Button.kt:558)");
        }
        Shape value = ShapesKt.getValue(TextButtonTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return value;
    }

    public final ButtonColors textButtonColors(Composer composer, int i5) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1880341584, i5, -1, "androidx.compose.material3.ButtonDefaults.textButtonColors (Button.kt:744)");
        }
        ButtonColors defaultTextButtonColors$material3_release = getDefaultTextButtonColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return defaultTextButtonColors$material3_release;
    }

    /* renamed from: textButtonColors-ro_MJ88, reason: not valid java name */
    public final ButtonColors m783textButtonColorsro_MJ88(long j5, long j6, long j7, long j8, Composer composer, int i5, int i6) {
        long m1501getUnspecified0d7_KjU = (i6 & 1) != 0 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : j5;
        long m1501getUnspecified0d7_KjU2 = (i6 & 2) != 0 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : j6;
        long m1501getUnspecified0d7_KjU3 = (i6 & 4) != 0 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : j7;
        long m1501getUnspecified0d7_KjU4 = (i6 & 8) != 0 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : j8;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1402274782, i5, -1, "androidx.compose.material3.ButtonDefaults.textButtonColors (Button.kt:762)");
        }
        ButtonColors m778copyjRlVdoo = getDefaultTextButtonColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).m778copyjRlVdoo(m1501getUnspecified0d7_KjU, m1501getUnspecified0d7_KjU2, m1501getUnspecified0d7_KjU3, m1501getUnspecified0d7_KjU4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return m778copyjRlVdoo;
    }
}
