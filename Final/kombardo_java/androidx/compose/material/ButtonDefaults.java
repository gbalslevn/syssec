package androidx.compose.material;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0013\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JD\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ:\u0010\u0016\u001a\u00020\u00132\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J0\u0010\u0019\u001a\u00020\u00132\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001a\u001a\u00020\u00048\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u00048\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u001c\u0010\u001bR\u0017\u0010\u001e\u001a\u00020\u001d8\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001d\u0010\"\u001a\u00020\u00048\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\"\u0010\u001b\u001a\u0004\b#\u0010$R\u001d\u0010%\u001a\u00020\u00048\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b%\u0010\u001b\u001a\u0004\b&\u0010$R\u001d\u0010'\u001a\u00020\u00048\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b'\u0010\u001b\u001a\u0004\b(\u0010$R\u001d\u0010)\u001a\u00020\u00048\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b)\u0010\u001b\u001a\u0004\b*\u0010$R\u001d\u0010+\u001a\u00020\u00048\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b+\u0010\u001b\u001a\u0004\b,\u0010$R\u001a\u0010-\u001a\u00020\u00048\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b-\u0010\u001bR\u0017\u0010.\u001a\u00020\u001d8\u0006¢\u0006\f\n\u0004\b.\u0010\u001f\u001a\u0004\b/\u0010!\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00060"}, d2 = {"Landroidx/compose/material/ButtonDefaults;", BuildConfig.FLAVOR, "<init>", "()V", "Landroidx/compose/ui/unit/Dp;", "defaultElevation", "pressedElevation", "disabledElevation", "hoveredElevation", "focusedElevation", "Landroidx/compose/material/ButtonElevation;", "elevation-R_JCAzs", "(FFFFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/ButtonElevation;", "elevation", "Landroidx/compose/ui/graphics/Color;", "backgroundColor", "contentColor", "disabledBackgroundColor", "disabledContentColor", "Landroidx/compose/material/ButtonColors;", "buttonColors-ro_MJ88", "(JJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/ButtonColors;", "buttonColors", "textButtonColors-RGew2ao", "(JJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/ButtonColors;", "textButtonColors", "ButtonHorizontalPadding", "F", "ButtonVerticalPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "ContentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getContentPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "MinWidth", "getMinWidth-D9Ej5fM", "()F", "MinHeight", "getMinHeight-D9Ej5fM", "IconSize", "getIconSize-D9Ej5fM", "IconSpacing", "getIconSpacing-D9Ej5fM", "OutlinedBorderSize", "getOutlinedBorderSize-D9Ej5fM", "TextButtonHorizontalPadding", "TextButtonContentPadding", "getTextButtonContentPadding", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ButtonDefaults {
    private static final float ButtonHorizontalPadding;
    private static final float ButtonVerticalPadding;
    private static final PaddingValues ContentPadding;
    public static final ButtonDefaults INSTANCE = new ButtonDefaults();
    private static final float IconSize;
    private static final float IconSpacing;
    private static final float MinHeight;
    private static final float MinWidth;
    private static final float OutlinedBorderSize;
    private static final PaddingValues TextButtonContentPadding;
    private static final float TextButtonHorizontalPadding;

    static {
        float m2599constructorimpl = Dp.m2599constructorimpl(16);
        ButtonHorizontalPadding = m2599constructorimpl;
        float f5 = 8;
        float m2599constructorimpl2 = Dp.m2599constructorimpl(f5);
        ButtonVerticalPadding = m2599constructorimpl2;
        PaddingValues m309PaddingValuesa9UjIt4 = PaddingKt.m309PaddingValuesa9UjIt4(m2599constructorimpl, m2599constructorimpl2, m2599constructorimpl, m2599constructorimpl2);
        ContentPadding = m309PaddingValuesa9UjIt4;
        MinWidth = Dp.m2599constructorimpl(64);
        MinHeight = Dp.m2599constructorimpl(36);
        IconSize = Dp.m2599constructorimpl(18);
        IconSpacing = Dp.m2599constructorimpl(f5);
        OutlinedBorderSize = Dp.m2599constructorimpl(1);
        float m2599constructorimpl3 = Dp.m2599constructorimpl(f5);
        TextButtonHorizontalPadding = m2599constructorimpl3;
        TextButtonContentPadding = PaddingKt.m309PaddingValuesa9UjIt4(m2599constructorimpl3, m309PaddingValuesa9UjIt4.getTop(), m2599constructorimpl3, m309PaddingValuesa9UjIt4.getBottom());
    }

    private ButtonDefaults() {
    }

    /* renamed from: buttonColors-ro_MJ88, reason: not valid java name */
    public final ButtonColors m655buttonColorsro_MJ88(long j5, long j6, long j7, long j8, Composer composer, int i5, int i6) {
        long j9;
        long m667getPrimary0d7_KjU = (i6 & 1) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m667getPrimary0d7_KjU() : j5;
        long m673contentColorForek8zF_U = (i6 & 2) != 0 ? ColorsKt.m673contentColorForek8zF_U(m667getPrimary0d7_KjU, composer, i5 & 14) : j6;
        if ((i6 & 4) != 0) {
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            j9 = ColorKt.m1505compositeOverOWjLjI(Color.m1485copywmQWz5c$default(materialTheme.getColors(composer, 6).m666getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null), materialTheme.getColors(composer, 6).m671getSurface0d7_KjU());
        } else {
            j9 = j7;
        }
        long m1485copywmQWz5c$default = (i6 & 8) != 0 ? Color.m1485copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m666getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j8;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1870371134, i5, -1, "androidx.compose.material.ButtonDefaults.buttonColors (Button.kt:413)");
        }
        DefaultButtonColors defaultButtonColors = new DefaultButtonColors(m667getPrimary0d7_KjU, m673contentColorForek8zF_U, j9, m1485copywmQWz5c$default, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return defaultButtonColors;
    }

    /* renamed from: elevation-R_JCAzs, reason: not valid java name */
    public final ButtonElevation m656elevationR_JCAzs(float f5, float f6, float f7, float f8, float f9, Composer composer, int i5, int i6) {
        if ((i6 & 1) != 0) {
            f5 = Dp.m2599constructorimpl(2);
        }
        float f10 = f5;
        if ((i6 & 2) != 0) {
            f6 = Dp.m2599constructorimpl(8);
        }
        float f11 = f6;
        if ((i6 & 4) != 0) {
            f7 = Dp.m2599constructorimpl(0);
        }
        float f12 = f7;
        if ((i6 & 8) != 0) {
            f8 = Dp.m2599constructorimpl(4);
        }
        float f13 = f8;
        if ((i6 & 16) != 0) {
            f9 = Dp.m2599constructorimpl(4);
        }
        float f14 = f9;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-737170518, i5, -1, "androidx.compose.material.ButtonDefaults.elevation (Button.kt:378)");
        }
        boolean z5 = ((((i5 & 14) ^ 6) > 4 && composer.changed(f10)) || (i5 & 6) == 4) | ((((i5 & 112) ^ 48) > 32 && composer.changed(f11)) || (i5 & 48) == 32) | ((((i5 & 896) ^ 384) > 256 && composer.changed(f12)) || (i5 & 384) == 256) | ((((i5 & 7168) ^ 3072) > 2048 && composer.changed(f13)) || (i5 & 3072) == 2048) | ((((57344 & i5) ^ 24576) > 16384 && composer.changed(f14)) || (i5 & 24576) == 16384);
        Object rememberedValue = composer.rememberedValue();
        if (z5 || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new DefaultButtonElevation(f10, f11, f12, f13, f14, null);
            composer.updateRememberedValue(rememberedValue);
        }
        DefaultButtonElevation defaultButtonElevation = (DefaultButtonElevation) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return defaultButtonElevation;
    }

    public final PaddingValues getContentPadding() {
        return ContentPadding;
    }

    /* renamed from: getMinHeight-D9Ej5fM, reason: not valid java name */
    public final float m657getMinHeightD9Ej5fM() {
        return MinHeight;
    }

    /* renamed from: getMinWidth-D9Ej5fM, reason: not valid java name */
    public final float m658getMinWidthD9Ej5fM() {
        return MinWidth;
    }

    public final PaddingValues getTextButtonContentPadding() {
        return TextButtonContentPadding;
    }

    /* renamed from: textButtonColors-RGew2ao, reason: not valid java name */
    public final ButtonColors m659textButtonColorsRGew2ao(long j5, long j6, long j7, Composer composer, int i5, int i6) {
        long m1500getTransparent0d7_KjU = (i6 & 1) != 0 ? Color.INSTANCE.m1500getTransparent0d7_KjU() : j5;
        long m667getPrimary0d7_KjU = (i6 & 2) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m667getPrimary0d7_KjU() : j6;
        long m1485copywmQWz5c$default = (i6 & 4) != 0 ? Color.m1485copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m666getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j7;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(182742216, i5, -1, "androidx.compose.material.ButtonDefaults.textButtonColors (Button.kt:455)");
        }
        DefaultButtonColors defaultButtonColors = new DefaultButtonColors(m1500getTransparent0d7_KjU, m667getPrimary0d7_KjU, m1500getTransparent0d7_KjU, m1485copywmQWz5c$default, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return defaultButtonColors;
    }
}
