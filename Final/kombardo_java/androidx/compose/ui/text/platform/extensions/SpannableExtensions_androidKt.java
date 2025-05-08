package androidx.compose.ui.text.platform.extensions;

import android.graphics.Typeface;
import android.text.Spannable;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.LeadingMarginSpan;
import android.text.style.MetricAffectingSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.ScaleXSpan;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.AnnotatedStringKt;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.android.style.BaselineShiftSpan;
import androidx.compose.ui.text.android.style.FontFeatureSpan;
import androidx.compose.ui.text.android.style.LetterSpacingSpanEm;
import androidx.compose.ui.text.android.style.LetterSpacingSpanPx;
import androidx.compose.ui.text.android.style.LineHeightSpan;
import androidx.compose.ui.text.android.style.LineHeightStyleSpan;
import androidx.compose.ui.text.android.style.ShadowSpan;
import androidx.compose.ui.text.android.style.SkewXSpan;
import androidx.compose.ui.text.android.style.TextDecorationSpan;
import androidx.compose.ui.text.android.style.TypefaceSpan;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.platform.style.DrawStyleSpan;
import androidx.compose.ui.text.platform.style.ShaderBrushSpan;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.unit.TextUnitType;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000Ð\u0001\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a$\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001aF\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0012\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00120\u00112\u001e\u0010\u0013\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u000e0\u0014H\u0000\u001a\u0010\u0010\u0016\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\nH\u0002\u001a*\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\nH\u0002ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a\f\u0010\u001d\u001a\u00020\u0001*\u00020\u001eH\u0002\u001a\u0016\u0010\u001f\u001a\u00020\u0002*\u0004\u0018\u00010\u00022\u0006\u0010 \u001a\u00020\u0002H\u0002\u001a.\u0010!\u001a\u00020\u000e*\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u0015H\u0000ø\u0001\u0000¢\u0006\u0004\b'\u0010(\u001a.\u0010)\u001a\u00020\u000e*\u00020\"2\b\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u0015H\u0002ø\u0001\u0000¢\u0006\u0002\b,\u001a.\u0010-\u001a\u00020\u000e*\u00020\"2\b\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u00020\u00182\u0006\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u0015H\u0002\u001a.\u00101\u001a\u00020\u000e*\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u0015H\u0000ø\u0001\u0000¢\u0006\u0004\b2\u0010(\u001a&\u00103\u001a\u00020\u000e*\u00020\"2\b\u00104\u001a\u0004\u0018\u0001052\u0006\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u0015H\u0002\u001aP\u00106\u001a\u00020\u000e*\u00020\"2\u0006\u00107\u001a\u00020\u001e2\u0012\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00120\u00112&\u00108\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010:\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020>09H\u0002\u001a&\u0010?\u001a\u00020\u000e*\u00020\"2\b\u0010@\u001a\u0004\u0018\u00010A2\u0006\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u0015H\u0002\u001a6\u0010B\u001a\u00020\u000e*\u00020\"2\u0006\u0010C\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u0015H\u0000ø\u0001\u0000¢\u0006\u0004\bD\u0010E\u001a&\u0010F\u001a\u00020\u000e*\u00020\"2\b\u0010G\u001a\u0004\u0018\u00010H2\u0006\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u0015H\u0002\u001a.\u0010I\u001a\u00020\u000e*\u00020\"2\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\nH\u0000ø\u0001\u0000¢\u0006\u0004\bJ\u0010K\u001a6\u0010I\u001a\u00020\u000e*\u00020\"2\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\n2\u0006\u0010L\u001a\u00020MH\u0000ø\u0001\u0000¢\u0006\u0004\bN\u0010O\u001a&\u0010P\u001a\u00020\u000e*\u00020\"2\b\u0010Q\u001a\u0004\u0018\u00010R2\u0006\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u0015H\u0000\u001a&\u0010S\u001a\u00020\u000e*\u00020\"2\b\u0010T\u001a\u0004\u0018\u00010U2\u0006\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u0015H\u0002\u001a$\u0010V\u001a\u00020\u000e*\u00020\"2\u0006\u0010W\u001a\u00020X2\u0006\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u0015H\u0000\u001a\"\u0010Y\u001a\u00020\u000e*\u00020\"2\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u00020\u00122\u0006\u0010\t\u001a\u00020\nH\u0002\u001aX\u0010[\u001a\u00020\u000e*\u00020\"2\u0006\u00107\u001a\u00020\u001e2\u0012\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00120\u00112\u0006\u0010\t\u001a\u00020\n2&\u00108\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010:\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020>09H\u0000\u001a&\u0010\\\u001a\u00020\u000e*\u00020\"2\b\u0010]\u001a\u0004\u0018\u00010^2\u0006\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u0015H\u0000\u001a&\u0010_\u001a\u00020\u000e*\u00020\"2\b\u0010`\u001a\u0004\u0018\u00010a2\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\nH\u0000\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006b"}, d2 = {"needsLetterSpacingSpan", BuildConfig.FLAVOR, "Landroidx/compose/ui/text/SpanStyle;", "getNeedsLetterSpacingSpan", "(Landroidx/compose/ui/text/SpanStyle;)Z", "createLetterSpacingSpan", "Landroid/text/style/MetricAffectingSpan;", "letterSpacing", "Landroidx/compose/ui/unit/TextUnit;", "density", "Landroidx/compose/ui/unit/Density;", "createLetterSpacingSpan-eAf_CNQ", "(JLandroidx/compose/ui/unit/Density;)Landroid/text/style/MetricAffectingSpan;", "flattenFontStylesAndApply", BuildConfig.FLAVOR, "contextFontSpanStyle", "spanStyles", BuildConfig.FLAVOR, "Landroidx/compose/ui/text/AnnotatedString$Range;", "block", "Lkotlin/Function3;", BuildConfig.FLAVOR, "isNonLinearFontScalingActive", "resolveLineHeightInPx", BuildConfig.FLAVOR, "lineHeight", "contextFontSize", "resolveLineHeightInPx-o2QH7mI", "(JFLandroidx/compose/ui/unit/Density;)F", "hasFontAttributes", "Landroidx/compose/ui/text/TextStyle;", "merge", "spanStyle", "setBackground", "Landroid/text/Spannable;", "color", "Landroidx/compose/ui/graphics/Color;", "start", "end", "setBackground-RPmYEkk", "(Landroid/text/Spannable;JII)V", "setBaselineShift", "baselineShift", "Landroidx/compose/ui/text/style/BaselineShift;", "setBaselineShift-0ocSgnM", "setBrush", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "setColor", "setColor-RPmYEkk", "setDrawStyle", "drawStyle", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "setFontAttributes", "contextTextStyle", "resolveTypeface", "Lkotlin/Function4;", "Landroidx/compose/ui/text/font/FontFamily;", "Landroidx/compose/ui/text/font/FontWeight;", "Landroidx/compose/ui/text/font/FontStyle;", "Landroidx/compose/ui/text/font/FontSynthesis;", "Landroid/graphics/Typeface;", "setFontFeatureSettings", "fontFeatureSettings", BuildConfig.FLAVOR, "setFontSize", "fontSize", "setFontSize-KmRG4DE", "(Landroid/text/Spannable;JLandroidx/compose/ui/unit/Density;II)V", "setGeometricTransform", "textGeometricTransform", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "setLineHeight", "setLineHeight-r9BaKPg", "(Landroid/text/Spannable;JFLandroidx/compose/ui/unit/Density;)V", "lineHeightStyle", "Landroidx/compose/ui/text/style/LineHeightStyle;", "setLineHeight-KmRG4DE", "(Landroid/text/Spannable;JFLandroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/style/LineHeightStyle;)V", "setLocaleList", "localeList", "Landroidx/compose/ui/text/intl/LocaleList;", "setShadow", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "setSpan", "span", BuildConfig.FLAVOR, "setSpanStyle", "spanStyleRange", "setSpanStyles", "setTextDecoration", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "setTextIndent", "textIndent", "Landroidx/compose/ui/text/style/TextIndent;", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class SpannableExtensions_androidKt {
    /* renamed from: createLetterSpacingSpan-eAf_CNQ, reason: not valid java name */
    private static final MetricAffectingSpan m2442createLetterSpacingSpaneAf_CNQ(long j5, Density density) {
        long m2674getTypeUIouoOA = TextUnit.m2674getTypeUIouoOA(j5);
        TextUnitType.Companion companion = TextUnitType.INSTANCE;
        if (TextUnitType.m2688equalsimpl0(m2674getTypeUIouoOA, companion.m2693getSpUIouoOA())) {
            return new LetterSpacingSpanPx(density.mo211toPxR2X_6o(j5));
        }
        if (TextUnitType.m2688equalsimpl0(m2674getTypeUIouoOA, companion.m2692getEmUIouoOA())) {
            return new LetterSpacingSpanEm(TextUnit.m2675getValueimpl(j5));
        }
        return null;
    }

    public static final void flattenFontStylesAndApply(SpanStyle spanStyle, List<AnnotatedString.Range<SpanStyle>> list, Function3<? super SpanStyle, ? super Integer, ? super Integer, Unit> function3) {
        if (list.size() <= 1) {
            if (list.isEmpty()) {
                return;
            }
            function3.invoke(merge(spanStyle, list.get(0).getItem()), Integer.valueOf(list.get(0).getStart()), Integer.valueOf(list.get(0).getEnd()));
            return;
        }
        int size = list.size();
        int i5 = size * 2;
        Integer[] numArr = new Integer[i5];
        for (int i6 = 0; i6 < i5; i6++) {
            numArr[i6] = 0;
        }
        int size2 = list.size();
        for (int i7 = 0; i7 < size2; i7++) {
            AnnotatedString.Range<SpanStyle> range = list.get(i7);
            numArr[i7] = Integer.valueOf(range.getStart());
            numArr[i7 + size] = Integer.valueOf(range.getEnd());
        }
        ArraysKt.sort(numArr);
        int intValue = ((Number) ArraysKt.first(numArr)).intValue();
        for (int i8 = 0; i8 < i5; i8++) {
            Integer num = numArr[i8];
            int intValue2 = num.intValue();
            if (intValue2 != intValue) {
                int size3 = list.size();
                SpanStyle spanStyle2 = spanStyle;
                for (int i9 = 0; i9 < size3; i9++) {
                    AnnotatedString.Range<SpanStyle> range2 = list.get(i9);
                    if (range2.getStart() != range2.getEnd() && AnnotatedStringKt.intersect(intValue, intValue2, range2.getStart(), range2.getEnd())) {
                        spanStyle2 = merge(spanStyle2, range2.getItem());
                    }
                }
                if (spanStyle2 != null) {
                    function3.invoke(spanStyle2, Integer.valueOf(intValue), num);
                }
                intValue = intValue2;
            }
        }
    }

    private static final boolean getNeedsLetterSpacingSpan(SpanStyle spanStyle) {
        long m2674getTypeUIouoOA = TextUnit.m2674getTypeUIouoOA(spanStyle.getLetterSpacing());
        TextUnitType.Companion companion = TextUnitType.INSTANCE;
        return TextUnitType.m2688equalsimpl0(m2674getTypeUIouoOA, companion.m2693getSpUIouoOA()) || TextUnitType.m2688equalsimpl0(TextUnit.m2674getTypeUIouoOA(spanStyle.getLetterSpacing()), companion.m2692getEmUIouoOA());
    }

    private static final boolean hasFontAttributes(TextStyle textStyle) {
        return TextPaintExtensions_androidKt.hasFontAttributes(textStyle.toSpanStyle()) || textStyle.m2301getFontSynthesisZQGJjVo() != null;
    }

    private static final boolean isNonLinearFontScalingActive(Density density) {
        return ((double) density.getFontScale()) > 1.05d;
    }

    private static final SpanStyle merge(SpanStyle spanStyle, SpanStyle spanStyle2) {
        return spanStyle == null ? spanStyle2 : spanStyle.merge(spanStyle2);
    }

    /* renamed from: resolveLineHeightInPx-o2QH7mI, reason: not valid java name */
    private static final float m2443resolveLineHeightInPxo2QH7mI(long j5, float f5, Density density) {
        float m2675getValueimpl;
        long m2674getTypeUIouoOA = TextUnit.m2674getTypeUIouoOA(j5);
        TextUnitType.Companion companion = TextUnitType.INSTANCE;
        if (TextUnitType.m2688equalsimpl0(m2674getTypeUIouoOA, companion.m2693getSpUIouoOA())) {
            if (!isNonLinearFontScalingActive(density)) {
                return density.mo211toPxR2X_6o(j5);
            }
            m2675getValueimpl = TextUnit.m2675getValueimpl(j5) / TextUnit.m2675getValueimpl(density.mo215toSpkPz2Gy4(f5));
        } else {
            if (!TextUnitType.m2688equalsimpl0(m2674getTypeUIouoOA, companion.m2692getEmUIouoOA())) {
                return Float.NaN;
            }
            m2675getValueimpl = TextUnit.m2675getValueimpl(j5);
        }
        return m2675getValueimpl * f5;
    }

    /* renamed from: setBackground-RPmYEkk, reason: not valid java name */
    public static final void m2444setBackgroundRPmYEkk(Spannable spannable, long j5, int i5, int i6) {
        if (j5 != 16) {
            setSpan(spannable, new BackgroundColorSpan(ColorKt.m1508toArgb8_81llA(j5)), i5, i6);
        }
    }

    /* renamed from: setBaselineShift-0ocSgnM, reason: not valid java name */
    private static final void m2445setBaselineShift0ocSgnM(Spannable spannable, BaselineShift baselineShift, int i5, int i6) {
        if (baselineShift != null) {
            setSpan(spannable, new BaselineShiftSpan(baselineShift.getMultiplier()), i5, i6);
        }
    }

    private static final void setBrush(Spannable spannable, Brush brush, float f5, int i5, int i6) {
        if (brush != null) {
            if (brush instanceof SolidColor) {
                m2446setColorRPmYEkk(spannable, ((SolidColor) brush).getValue(), i5, i6);
            } else if (brush instanceof ShaderBrush) {
                setSpan(spannable, new ShaderBrushSpan((ShaderBrush) brush, f5), i5, i6);
            }
        }
    }

    /* renamed from: setColor-RPmYEkk, reason: not valid java name */
    public static final void m2446setColorRPmYEkk(Spannable spannable, long j5, int i5, int i6) {
        if (j5 != 16) {
            setSpan(spannable, new ForegroundColorSpan(ColorKt.m1508toArgb8_81llA(j5)), i5, i6);
        }
    }

    private static final void setDrawStyle(Spannable spannable, DrawStyle drawStyle, int i5, int i6) {
        if (drawStyle != null) {
            setSpan(spannable, new DrawStyleSpan(drawStyle), i5, i6);
        }
    }

    private static final void setFontAttributes(final Spannable spannable, TextStyle textStyle, List<AnnotatedString.Range<SpanStyle>> list, final Function4<? super FontFamily, ? super FontWeight, ? super FontStyle, ? super FontSynthesis, ? extends Typeface> function4) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            AnnotatedString.Range<SpanStyle> range = list.get(i5);
            AnnotatedString.Range<SpanStyle> range2 = range;
            if (TextPaintExtensions_androidKt.hasFontAttributes(range2.getItem()) || range2.getItem().getFontSynthesis() != null) {
                arrayList.add(range);
            }
        }
        flattenFontStylesAndApply(hasFontAttributes(textStyle) ? new SpanStyle(0L, 0L, textStyle.getFontWeight(), textStyle.m2300getFontStyle4Lr2A7w(), textStyle.m2301getFontSynthesisZQGJjVo(), textStyle.getFontFamily(), null, 0L, null, null, null, 0L, null, null, null, null, 65475, null) : null, arrayList, new Function3<SpanStyle, Integer, Integer, Unit>() { // from class: androidx.compose.ui.text.platform.extensions.SpannableExtensions_androidKt$setFontAttributes$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(SpanStyle spanStyle, Integer num, Integer num2) {
                invoke(spanStyle, num.intValue(), num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(SpanStyle spanStyle, int i6, int i7) {
                Spannable spannable2 = spannable;
                Function4<FontFamily, FontWeight, FontStyle, FontSynthesis, Typeface> function42 = function4;
                FontFamily fontFamily = spanStyle.getFontFamily();
                FontWeight fontWeight = spanStyle.getFontWeight();
                if (fontWeight == null) {
                    fontWeight = FontWeight.INSTANCE.getNormal();
                }
                FontStyle fontStyle = spanStyle.getFontStyle();
                FontStyle m2336boximpl = FontStyle.m2336boximpl(fontStyle != null ? fontStyle.getValue() : FontStyle.INSTANCE.m2344getNormal_LCdwA());
                FontSynthesis fontSynthesis = spanStyle.getFontSynthesis();
                spannable2.setSpan(new TypefaceSpan(function42.invoke(fontFamily, fontWeight, m2336boximpl, FontSynthesis.m2345boximpl(fontSynthesis != null ? fontSynthesis.getValue() : FontSynthesis.INSTANCE.m2354getAllGVVA2EU()))), i6, i7, 33);
            }
        });
    }

    private static final void setFontFeatureSettings(Spannable spannable, String str, int i5, int i6) {
        if (str != null) {
            setSpan(spannable, new FontFeatureSpan(str), i5, i6);
        }
    }

    /* renamed from: setFontSize-KmRG4DE, reason: not valid java name */
    public static final void m2447setFontSizeKmRG4DE(Spannable spannable, long j5, Density density, int i5, int i6) {
        long m2674getTypeUIouoOA = TextUnit.m2674getTypeUIouoOA(j5);
        TextUnitType.Companion companion = TextUnitType.INSTANCE;
        if (TextUnitType.m2688equalsimpl0(m2674getTypeUIouoOA, companion.m2693getSpUIouoOA())) {
            setSpan(spannable, new AbsoluteSizeSpan(MathKt.roundToInt(density.mo211toPxR2X_6o(j5)), false), i5, i6);
        } else if (TextUnitType.m2688equalsimpl0(m2674getTypeUIouoOA, companion.m2692getEmUIouoOA())) {
            setSpan(spannable, new RelativeSizeSpan(TextUnit.m2675getValueimpl(j5)), i5, i6);
        }
    }

    private static final void setGeometricTransform(Spannable spannable, TextGeometricTransform textGeometricTransform, int i5, int i6) {
        if (textGeometricTransform != null) {
            setSpan(spannable, new ScaleXSpan(textGeometricTransform.getScaleX()), i5, i6);
            setSpan(spannable, new SkewXSpan(textGeometricTransform.getSkewX()), i5, i6);
        }
    }

    /* renamed from: setLineHeight-KmRG4DE, reason: not valid java name */
    public static final void m2448setLineHeightKmRG4DE(Spannable spannable, long j5, float f5, Density density, LineHeightStyle lineHeightStyle) {
        float m2443resolveLineHeightInPxo2QH7mI = m2443resolveLineHeightInPxo2QH7mI(j5, f5, density);
        if (Float.isNaN(m2443resolveLineHeightInPxo2QH7mI)) {
            return;
        }
        setSpan(spannable, new LineHeightStyleSpan(m2443resolveLineHeightInPxo2QH7mI, 0, (spannable.length() == 0 || StringsKt.last(spannable) == '\n') ? spannable.length() + 1 : spannable.length(), LineHeightStyle.Trim.m2516isTrimFirstLineTopimpl$ui_text_release(lineHeightStyle.getTrim()), LineHeightStyle.Trim.m2517isTrimLastLineBottomimpl$ui_text_release(lineHeightStyle.getTrim()), lineHeightStyle.getAlignment()), 0, spannable.length());
    }

    /* renamed from: setLineHeight-r9BaKPg, reason: not valid java name */
    public static final void m2449setLineHeightr9BaKPg(Spannable spannable, long j5, float f5, Density density) {
        float m2443resolveLineHeightInPxo2QH7mI = m2443resolveLineHeightInPxo2QH7mI(j5, f5, density);
        if (Float.isNaN(m2443resolveLineHeightInPxo2QH7mI)) {
            return;
        }
        setSpan(spannable, new LineHeightSpan(m2443resolveLineHeightInPxo2QH7mI), 0, spannable.length());
    }

    public static final void setLocaleList(Spannable spannable, LocaleList localeList, int i5, int i6) {
        if (localeList != null) {
            setSpan(spannable, LocaleListHelperMethods.INSTANCE.localeSpan(localeList), i5, i6);
        }
    }

    private static final void setShadow(Spannable spannable, Shadow shadow, int i5, int i6) {
        if (shadow != null) {
            setSpan(spannable, new ShadowSpan(ColorKt.m1508toArgb8_81llA(shadow.getColor()), Offset.m1337getXimpl(shadow.getOffset()), Offset.m1338getYimpl(shadow.getOffset()), TextPaintExtensions_androidKt.correctBlurRadius(shadow.getBlurRadius())), i5, i6);
        }
    }

    public static final void setSpan(Spannable spannable, Object obj, int i5, int i6) {
        spannable.setSpan(obj, i5, i6, 33);
    }

    private static final void setSpanStyle(Spannable spannable, AnnotatedString.Range<SpanStyle> range, Density density) {
        int start = range.getStart();
        int end = range.getEnd();
        SpanStyle item = range.getItem();
        m2445setBaselineShift0ocSgnM(spannable, item.getBaselineShift(), start, end);
        m2446setColorRPmYEkk(spannable, item.m2255getColor0d7_KjU(), start, end);
        setBrush(spannable, item.getBrush(), item.getAlpha(), start, end);
        setTextDecoration(spannable, item.getTextDecoration(), start, end);
        m2447setFontSizeKmRG4DE(spannable, item.getFontSize(), density, start, end);
        setFontFeatureSettings(spannable, item.getFontFeatureSettings(), start, end);
        setGeometricTransform(spannable, item.getTextGeometricTransform(), start, end);
        setLocaleList(spannable, item.getLocaleList(), start, end);
        m2444setBackgroundRPmYEkk(spannable, item.getBackground(), start, end);
        setShadow(spannable, item.getShadow(), start, end);
        setDrawStyle(spannable, item.getDrawStyle(), start, end);
    }

    public static final void setSpanStyles(Spannable spannable, TextStyle textStyle, List<AnnotatedString.Range<SpanStyle>> list, Density density, Function4<? super FontFamily, ? super FontWeight, ? super FontStyle, ? super FontSynthesis, ? extends Typeface> function4) {
        MetricAffectingSpan m2442createLetterSpacingSpaneAf_CNQ;
        setFontAttributes(spannable, textStyle, list, function4);
        int size = list.size();
        boolean z5 = false;
        for (int i5 = 0; i5 < size; i5++) {
            AnnotatedString.Range<SpanStyle> range = list.get(i5);
            int start = range.getStart();
            int end = range.getEnd();
            if (start >= 0 && start < spannable.length() && end > start && end <= spannable.length()) {
                setSpanStyle(spannable, range, density);
                if (getNeedsLetterSpacingSpan(range.getItem())) {
                    z5 = true;
                }
            }
        }
        if (z5) {
            int size2 = list.size();
            for (int i6 = 0; i6 < size2; i6++) {
                AnnotatedString.Range<SpanStyle> range2 = list.get(i6);
                int start2 = range2.getStart();
                int end2 = range2.getEnd();
                SpanStyle item = range2.getItem();
                if (start2 >= 0 && start2 < spannable.length() && end2 > start2 && end2 <= spannable.length() && (m2442createLetterSpacingSpaneAf_CNQ = m2442createLetterSpacingSpaneAf_CNQ(item.getLetterSpacing(), density)) != null) {
                    setSpan(spannable, m2442createLetterSpacingSpaneAf_CNQ, start2, end2);
                }
            }
        }
    }

    public static final void setTextDecoration(Spannable spannable, TextDecoration textDecoration, int i5, int i6) {
        if (textDecoration != null) {
            TextDecoration.Companion companion = TextDecoration.INSTANCE;
            setSpan(spannable, new TextDecorationSpan(textDecoration.contains(companion.getUnderline()), textDecoration.contains(companion.getLineThrough())), i5, i6);
        }
    }

    public static final void setTextIndent(Spannable spannable, TextIndent textIndent, float f5, Density density) {
        if (textIndent != null) {
            if ((TextUnit.m2672equalsimpl0(textIndent.getFirstLine(), TextUnitKt.getSp(0)) && TextUnit.m2672equalsimpl0(textIndent.getRestLine(), TextUnitKt.getSp(0))) || TextUnitKt.m2683isUnspecifiedR2X_6o(textIndent.getFirstLine()) || TextUnitKt.m2683isUnspecifiedR2X_6o(textIndent.getRestLine())) {
                return;
            }
            long m2674getTypeUIouoOA = TextUnit.m2674getTypeUIouoOA(textIndent.getFirstLine());
            TextUnitType.Companion companion = TextUnitType.INSTANCE;
            float f6 = 0.0f;
            float mo211toPxR2X_6o = TextUnitType.m2688equalsimpl0(m2674getTypeUIouoOA, companion.m2693getSpUIouoOA()) ? density.mo211toPxR2X_6o(textIndent.getFirstLine()) : TextUnitType.m2688equalsimpl0(m2674getTypeUIouoOA, companion.m2692getEmUIouoOA()) ? TextUnit.m2675getValueimpl(textIndent.getFirstLine()) * f5 : 0.0f;
            long m2674getTypeUIouoOA2 = TextUnit.m2674getTypeUIouoOA(textIndent.getRestLine());
            if (TextUnitType.m2688equalsimpl0(m2674getTypeUIouoOA2, companion.m2693getSpUIouoOA())) {
                f6 = density.mo211toPxR2X_6o(textIndent.getRestLine());
            } else if (TextUnitType.m2688equalsimpl0(m2674getTypeUIouoOA2, companion.m2692getEmUIouoOA())) {
                f6 = TextUnit.m2675getValueimpl(textIndent.getRestLine()) * f5;
            }
            setSpan(spannable, new LeadingMarginSpan.Standard((int) Math.ceil(mo211toPxR2X_6o), (int) Math.ceil(f6)), 0, spannable.length());
        }
    }
}
