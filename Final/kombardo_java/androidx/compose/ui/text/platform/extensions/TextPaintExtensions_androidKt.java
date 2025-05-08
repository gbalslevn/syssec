package androidx.compose.ui.text.platform.extensions;

import android.graphics.Typeface;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.platform.AndroidTextPaint;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000`\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a6\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001aP\u0010\u000f\u001a\u0004\u0018\u00010\u0004*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00042&\u0010\u0012\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00132\u0006\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0000\u001a\f\u0010\u001b\u001a\u00020\b*\u00020\u0004H\u0000\u001a\u0016\u0010\u001c\u001a\u00020\u001d*\u00020\u00102\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006 "}, d2 = {"correctBlurRadius", BuildConfig.FLAVOR, "blurRadius", "generateFallbackSpanStyle", "Landroidx/compose/ui/text/SpanStyle;", "letterSpacing", "Landroidx/compose/ui/unit/TextUnit;", "requiresLetterSpacing", BuildConfig.FLAVOR, "background", "Landroidx/compose/ui/graphics/Color;", "baselineShift", "Landroidx/compose/ui/text/style/BaselineShift;", "generateFallbackSpanStyle-62GTOB8", "(JZJLandroidx/compose/ui/text/style/BaselineShift;)Landroidx/compose/ui/text/SpanStyle;", "applySpanStyle", "Landroidx/compose/ui/text/platform/AndroidTextPaint;", "style", "resolveTypeface", "Lkotlin/Function4;", "Landroidx/compose/ui/text/font/FontFamily;", "Landroidx/compose/ui/text/font/FontWeight;", "Landroidx/compose/ui/text/font/FontStyle;", "Landroidx/compose/ui/text/font/FontSynthesis;", "Landroid/graphics/Typeface;", "density", "Landroidx/compose/ui/unit/Density;", "hasFontAttributes", "setTextMotion", BuildConfig.FLAVOR, "textMotion", "Landroidx/compose/ui/text/style/TextMotion;", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class TextPaintExtensions_androidKt {
    public static final SpanStyle applySpanStyle(AndroidTextPaint androidTextPaint, SpanStyle spanStyle, Function4<? super FontFamily, ? super FontWeight, ? super FontStyle, ? super FontSynthesis, ? extends Typeface> function4, Density density, boolean z5) {
        long m2674getTypeUIouoOA = TextUnit.m2674getTypeUIouoOA(spanStyle.getFontSize());
        TextUnitType.Companion companion = TextUnitType.INSTANCE;
        if (TextUnitType.m2688equalsimpl0(m2674getTypeUIouoOA, companion.m2693getSpUIouoOA())) {
            androidTextPaint.setTextSize(density.mo211toPxR2X_6o(spanStyle.getFontSize()));
        } else if (TextUnitType.m2688equalsimpl0(m2674getTypeUIouoOA, companion.m2692getEmUIouoOA())) {
            androidTextPaint.setTextSize(androidTextPaint.getTextSize() * TextUnit.m2675getValueimpl(spanStyle.getFontSize()));
        }
        if (hasFontAttributes(spanStyle)) {
            FontFamily fontFamily = spanStyle.getFontFamily();
            FontWeight fontWeight = spanStyle.getFontWeight();
            if (fontWeight == null) {
                fontWeight = FontWeight.INSTANCE.getNormal();
            }
            FontStyle fontStyle = spanStyle.getFontStyle();
            FontStyle m2336boximpl = FontStyle.m2336boximpl(fontStyle != null ? fontStyle.getValue() : FontStyle.INSTANCE.m2344getNormal_LCdwA());
            FontSynthesis fontSynthesis = spanStyle.getFontSynthesis();
            androidTextPaint.setTypeface(function4.invoke(fontFamily, fontWeight, m2336boximpl, FontSynthesis.m2345boximpl(fontSynthesis != null ? fontSynthesis.getValue() : FontSynthesis.INSTANCE.m2354getAllGVVA2EU())));
        }
        if (spanStyle.getLocaleList() != null && !Intrinsics.areEqual(spanStyle.getLocaleList(), LocaleList.INSTANCE.getCurrent())) {
            LocaleListHelperMethods.INSTANCE.setTextLocales(androidTextPaint, spanStyle.getLocaleList());
        }
        if (spanStyle.getFontFeatureSettings() != null && !Intrinsics.areEqual(spanStyle.getFontFeatureSettings(), BuildConfig.FLAVOR)) {
            androidTextPaint.setFontFeatureSettings(spanStyle.getFontFeatureSettings());
        }
        if (spanStyle.getTextGeometricTransform() != null && !Intrinsics.areEqual(spanStyle.getTextGeometricTransform(), TextGeometricTransform.INSTANCE.getNone$ui_text_release())) {
            androidTextPaint.setTextScaleX(androidTextPaint.getTextScaleX() * spanStyle.getTextGeometricTransform().getScaleX());
            androidTextPaint.setTextSkewX(androidTextPaint.getTextSkewX() + spanStyle.getTextGeometricTransform().getSkewX());
        }
        androidTextPaint.m2441setColor8_81llA(spanStyle.m2255getColor0d7_KjU());
        androidTextPaint.m2440setBrush12SF9DM(spanStyle.getBrush(), Size.INSTANCE.m1383getUnspecifiedNHjbRc(), spanStyle.getAlpha());
        androidTextPaint.setShadow(spanStyle.getShadow());
        androidTextPaint.setTextDecoration(spanStyle.getTextDecoration());
        androidTextPaint.setDrawStyle(spanStyle.getDrawStyle());
        if (TextUnitType.m2688equalsimpl0(TextUnit.m2674getTypeUIouoOA(spanStyle.getLetterSpacing()), companion.m2693getSpUIouoOA()) && TextUnit.m2675getValueimpl(spanStyle.getLetterSpacing()) != 0.0f) {
            float textSize = androidTextPaint.getTextSize() * androidTextPaint.getTextScaleX();
            float mo211toPxR2X_6o = density.mo211toPxR2X_6o(spanStyle.getLetterSpacing());
            if (textSize != 0.0f) {
                androidTextPaint.setLetterSpacing(mo211toPxR2X_6o / textSize);
            }
        } else if (TextUnitType.m2688equalsimpl0(TextUnit.m2674getTypeUIouoOA(spanStyle.getLetterSpacing()), companion.m2692getEmUIouoOA())) {
            androidTextPaint.setLetterSpacing(TextUnit.m2675getValueimpl(spanStyle.getLetterSpacing()));
        }
        return m2450generateFallbackSpanStyle62GTOB8(spanStyle.getLetterSpacing(), z5, spanStyle.getBackground(), spanStyle.getBaselineShift());
    }

    public static final float correctBlurRadius(float f5) {
        if (f5 == 0.0f) {
            return Float.MIN_VALUE;
        }
        return f5;
    }

    /* renamed from: generateFallbackSpanStyle-62GTOB8, reason: not valid java name */
    private static final SpanStyle m2450generateFallbackSpanStyle62GTOB8(long j5, boolean z5, long j6, BaselineShift baselineShift) {
        long j7 = j6;
        boolean z6 = false;
        boolean z7 = z5 && TextUnitType.m2688equalsimpl0(TextUnit.m2674getTypeUIouoOA(j5), TextUnitType.INSTANCE.m2693getSpUIouoOA()) && TextUnit.m2675getValueimpl(j5) != 0.0f;
        Color.Companion companion = Color.INSTANCE;
        boolean z8 = (Color.m1487equalsimpl0(j7, companion.m1501getUnspecified0d7_KjU()) || Color.m1487equalsimpl0(j7, companion.m1500getTransparent0d7_KjU())) ? false : true;
        if (baselineShift != null) {
            if (!BaselineShift.m2458equalsimpl0(baselineShift.getMultiplier(), BaselineShift.INSTANCE.m2462getNoney9eOQZs())) {
                z6 = true;
            }
        }
        if (!z7 && !z8 && !z6) {
            return null;
        }
        long m2679getUnspecifiedXSAIIZE = z7 ? j5 : TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE();
        if (!z8) {
            j7 = companion.m1501getUnspecified0d7_KjU();
        }
        return new SpanStyle(0L, 0L, null, null, null, null, null, m2679getUnspecifiedXSAIIZE, z6 ? baselineShift : null, null, null, j7, null, null, null, null, 63103, null);
    }

    public static final boolean hasFontAttributes(SpanStyle spanStyle) {
        return (spanStyle.getFontFamily() == null && spanStyle.getFontStyle() == null && spanStyle.getFontWeight() == null) ? false : true;
    }

    public static final void setTextMotion(AndroidTextPaint androidTextPaint, TextMotion textMotion) {
        if (textMotion == null) {
            textMotion = TextMotion.INSTANCE.getStatic();
        }
        androidTextPaint.setFlags(textMotion.getSubpixelTextPositioning() ? androidTextPaint.getFlags() | 128 : androidTextPaint.getFlags() & (-129));
        int linearity = textMotion.getLinearity();
        TextMotion.Linearity.Companion companion = TextMotion.Linearity.INSTANCE;
        if (TextMotion.Linearity.m2554equalsimpl0(linearity, companion.m2557getLinear4e0Vf04())) {
            androidTextPaint.setFlags(androidTextPaint.getFlags() | 64);
            androidTextPaint.setHinting(0);
        } else if (TextMotion.Linearity.m2554equalsimpl0(linearity, companion.m2556getFontHinting4e0Vf04())) {
            androidTextPaint.getFlags();
            androidTextPaint.setHinting(1);
        } else if (!TextMotion.Linearity.m2554equalsimpl0(linearity, companion.m2558getNone4e0Vf04())) {
            androidTextPaint.getFlags();
        } else {
            androidTextPaint.getFlags();
            androidTextPaint.setHinting(0);
        }
    }
}
