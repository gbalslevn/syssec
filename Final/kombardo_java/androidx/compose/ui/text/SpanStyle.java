package androidx.compose.ui.text;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextForegroundStyle;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.TextUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b0\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B¿\u0001\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b!\u0010\"BÁ\u0001\b\u0016\u0012\b\b\u0002\u0010#\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b!\u0010$J\u001b\u0010&\u001a\u00020\u00002\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0000H\u0007¢\u0006\u0004\b&\u0010'JÈ\u0001\u0010*\u001a\u00020\u00002\b\b\u0002\u0010#\u001a\u00020\u00172\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00042\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u00172\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001fø\u0001\u0000¢\u0006\u0004\b(\u0010)J\u001a\u0010,\u001a\u00020+2\b\u0010%\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b,\u0010-J\u0017\u00100\u001a\u00020+2\u0006\u0010%\u001a\u00020\u0000H\u0000¢\u0006\u0004\b.\u0010/J\u0017\u00102\u001a\u00020+2\u0006\u0010%\u001a\u00020\u0000H\u0000¢\u0006\u0004\b1\u0010/J\u000f\u00104\u001a\u000203H\u0016¢\u0006\u0004\b4\u00105J\u000f\u00106\u001a\u00020\u000eH\u0016¢\u0006\u0004\b6\u00107R\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u00108\u001a\u0004\b9\u0010:R\u001d\u0010\u0005\u001a\u00020\u00048\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0005\u0010;\u001a\u0004\b<\u0010=R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010>\u001a\u0004\b?\u0010@R\u001f\u0010\t\u001a\u0004\u0018\u00010\b8\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\t\u0010A\u001a\u0004\bB\u0010CR\u001f\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u000b\u0010D\u001a\u0004\bE\u0010FR\u0019\u0010\r\u001a\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b\r\u0010G\u001a\u0004\bH\u0010IR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010J\u001a\u0004\bK\u00107R\u001d\u0010\u0010\u001a\u00020\u00048\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0010\u0010;\u001a\u0004\bL\u0010=R\u001f\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0012\u0010M\u001a\u0004\bN\u0010OR\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010P\u001a\u0004\bQ\u0010RR\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006¢\u0006\f\n\u0004\b\u0016\u0010S\u001a\u0004\bT\u0010UR\u001d\u0010\u0018\u001a\u00020\u00178\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0018\u0010;\u001a\u0004\bV\u0010=R\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006¢\u0006\f\n\u0004\b\u001a\u0010W\u001a\u0004\bX\u0010YR\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006¢\u0006\f\n\u0004\b\u001c\u0010Z\u001a\u0004\b[\u0010\\R\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006¢\u0006\f\n\u0004\b\u001e\u0010]\u001a\u0004\b^\u0010_R\u0019\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006¢\u0006\f\n\u0004\b \u0010`\u001a\u0004\ba\u0010bR\u0017\u0010#\u001a\u00020\u00178Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\bc\u0010=R\u0013\u0010g\u001a\u0004\u0018\u00010d8F¢\u0006\u0006\u001a\u0004\be\u0010fR\u0011\u0010k\u001a\u00020h8F¢\u0006\u0006\u001a\u0004\bi\u0010j\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006l"}, d2 = {"Landroidx/compose/ui/text/SpanStyle;", BuildConfig.FLAVOR, "Landroidx/compose/ui/text/style/TextForegroundStyle;", "textForegroundStyle", "Landroidx/compose/ui/unit/TextUnit;", "fontSize", "Landroidx/compose/ui/text/font/FontWeight;", "fontWeight", "Landroidx/compose/ui/text/font/FontStyle;", "fontStyle", "Landroidx/compose/ui/text/font/FontSynthesis;", "fontSynthesis", "Landroidx/compose/ui/text/font/FontFamily;", "fontFamily", BuildConfig.FLAVOR, "fontFeatureSettings", "letterSpacing", "Landroidx/compose/ui/text/style/BaselineShift;", "baselineShift", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "textGeometricTransform", "Landroidx/compose/ui/text/intl/LocaleList;", "localeList", "Landroidx/compose/ui/graphics/Color;", "background", "Landroidx/compose/ui/text/style/TextDecoration;", "textDecoration", "Landroidx/compose/ui/graphics/Shadow;", "shadow", "Landroidx/compose/ui/text/PlatformSpanStyle;", "platformStyle", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "drawStyle", "<init>", "(Landroidx/compose/ui/text/style/TextForegroundStyle;JLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/PlatformSpanStyle;Landroidx/compose/ui/graphics/drawscope/DrawStyle;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "color", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/PlatformSpanStyle;Landroidx/compose/ui/graphics/drawscope/DrawStyle;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "other", "merge", "(Landroidx/compose/ui/text/SpanStyle;)Landroidx/compose/ui/text/SpanStyle;", "copy-GSF8kmg", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/PlatformSpanStyle;Landroidx/compose/ui/graphics/drawscope/DrawStyle;)Landroidx/compose/ui/text/SpanStyle;", "copy", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "hasSameLayoutAffectingAttributes$ui_text_release", "(Landroidx/compose/ui/text/SpanStyle;)Z", "hasSameLayoutAffectingAttributes", "hasSameNonLayoutAttributes$ui_text_release", "hasSameNonLayoutAttributes", BuildConfig.FLAVOR, "hashCode", "()I", "toString", "()Ljava/lang/String;", "Landroidx/compose/ui/text/style/TextForegroundStyle;", "getTextForegroundStyle$ui_text_release", "()Landroidx/compose/ui/text/style/TextForegroundStyle;", "J", "getFontSize-XSAIIZE", "()J", "Landroidx/compose/ui/text/font/FontWeight;", "getFontWeight", "()Landroidx/compose/ui/text/font/FontWeight;", "Landroidx/compose/ui/text/font/FontStyle;", "getFontStyle-4Lr2A7w", "()Landroidx/compose/ui/text/font/FontStyle;", "Landroidx/compose/ui/text/font/FontSynthesis;", "getFontSynthesis-ZQGJjVo", "()Landroidx/compose/ui/text/font/FontSynthesis;", "Landroidx/compose/ui/text/font/FontFamily;", "getFontFamily", "()Landroidx/compose/ui/text/font/FontFamily;", "Ljava/lang/String;", "getFontFeatureSettings", "getLetterSpacing-XSAIIZE", "Landroidx/compose/ui/text/style/BaselineShift;", "getBaselineShift-5SSeXJ0", "()Landroidx/compose/ui/text/style/BaselineShift;", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "getTextGeometricTransform", "()Landroidx/compose/ui/text/style/TextGeometricTransform;", "Landroidx/compose/ui/text/intl/LocaleList;", "getLocaleList", "()Landroidx/compose/ui/text/intl/LocaleList;", "getBackground-0d7_KjU", "Landroidx/compose/ui/text/style/TextDecoration;", "getTextDecoration", "()Landroidx/compose/ui/text/style/TextDecoration;", "Landroidx/compose/ui/graphics/Shadow;", "getShadow", "()Landroidx/compose/ui/graphics/Shadow;", "Landroidx/compose/ui/text/PlatformSpanStyle;", "getPlatformStyle", "()Landroidx/compose/ui/text/PlatformSpanStyle;", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "getDrawStyle", "()Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "getColor-0d7_KjU", "Landroidx/compose/ui/graphics/Brush;", "getBrush", "()Landroidx/compose/ui/graphics/Brush;", "brush", BuildConfig.FLAVOR, "getAlpha", "()F", "alpha", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SpanStyle {
    private final long background;
    private final BaselineShift baselineShift;
    private final DrawStyle drawStyle;
    private final FontFamily fontFamily;
    private final String fontFeatureSettings;
    private final long fontSize;
    private final FontStyle fontStyle;
    private final FontSynthesis fontSynthesis;
    private final FontWeight fontWeight;
    private final long letterSpacing;
    private final LocaleList localeList;
    private final PlatformSpanStyle platformStyle;
    private final Shadow shadow;
    private final TextDecoration textDecoration;
    private final TextForegroundStyle textForegroundStyle;
    private final TextGeometricTransform textGeometricTransform;

    public /* synthetic */ SpanStyle(long j5, long j6, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j7, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j8, TextDecoration textDecoration, Shadow shadow, PlatformSpanStyle platformSpanStyle, DrawStyle drawStyle, DefaultConstructorMarker defaultConstructorMarker) {
        this(j5, j6, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j7, baselineShift, textGeometricTransform, localeList, j8, textDecoration, shadow, platformSpanStyle, drawStyle);
    }

    /* renamed from: copy-GSF8kmg, reason: not valid java name */
    public final SpanStyle m2252copyGSF8kmg(long color, long fontSize, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String fontFeatureSettings, long letterSpacing, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long background, TextDecoration textDecoration, Shadow shadow, PlatformSpanStyle platformStyle, DrawStyle drawStyle) {
        return new SpanStyle(Color.m1487equalsimpl0(color, m2255getColor0d7_KjU()) ? this.textForegroundStyle : TextForegroundStyle.INSTANCE.m2549from8_81llA(color), fontSize, fontWeight, fontStyle, fontSynthesis, fontFamily, fontFeatureSettings, letterSpacing, baselineShift, textGeometricTransform, localeList, background, textDecoration, shadow, platformStyle, drawStyle, (DefaultConstructorMarker) null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SpanStyle)) {
            return false;
        }
        SpanStyle spanStyle = (SpanStyle) other;
        return hasSameLayoutAffectingAttributes$ui_text_release(spanStyle) && hasSameNonLayoutAttributes$ui_text_release(spanStyle);
    }

    public final float getAlpha() {
        return this.textForegroundStyle.getAlpha();
    }

    /* renamed from: getBackground-0d7_KjU, reason: not valid java name and from getter */
    public final long getBackground() {
        return this.background;
    }

    /* renamed from: getBaselineShift-5SSeXJ0, reason: not valid java name and from getter */
    public final BaselineShift getBaselineShift() {
        return this.baselineShift;
    }

    public final Brush getBrush() {
        return this.textForegroundStyle.getBrush();
    }

    /* renamed from: getColor-0d7_KjU, reason: not valid java name */
    public final long m2255getColor0d7_KjU() {
        return this.textForegroundStyle.mo2464getColor0d7_KjU();
    }

    public final DrawStyle getDrawStyle() {
        return this.drawStyle;
    }

    public final FontFamily getFontFamily() {
        return this.fontFamily;
    }

    public final String getFontFeatureSettings() {
        return this.fontFeatureSettings;
    }

    /* renamed from: getFontSize-XSAIIZE, reason: not valid java name and from getter */
    public final long getFontSize() {
        return this.fontSize;
    }

    /* renamed from: getFontStyle-4Lr2A7w, reason: not valid java name and from getter */
    public final FontStyle getFontStyle() {
        return this.fontStyle;
    }

    /* renamed from: getFontSynthesis-ZQGJjVo, reason: not valid java name and from getter */
    public final FontSynthesis getFontSynthesis() {
        return this.fontSynthesis;
    }

    public final FontWeight getFontWeight() {
        return this.fontWeight;
    }

    /* renamed from: getLetterSpacing-XSAIIZE, reason: not valid java name and from getter */
    public final long getLetterSpacing() {
        return this.letterSpacing;
    }

    public final LocaleList getLocaleList() {
        return this.localeList;
    }

    public final PlatformSpanStyle getPlatformStyle() {
        return this.platformStyle;
    }

    public final Shadow getShadow() {
        return this.shadow;
    }

    public final TextDecoration getTextDecoration() {
        return this.textDecoration;
    }

    /* renamed from: getTextForegroundStyle$ui_text_release, reason: from getter */
    public final TextForegroundStyle getTextForegroundStyle() {
        return this.textForegroundStyle;
    }

    public final TextGeometricTransform getTextGeometricTransform() {
        return this.textGeometricTransform;
    }

    public final boolean hasSameLayoutAffectingAttributes$ui_text_release(SpanStyle other) {
        if (this == other) {
            return true;
        }
        return TextUnit.m2672equalsimpl0(this.fontSize, other.fontSize) && Intrinsics.areEqual(this.fontWeight, other.fontWeight) && Intrinsics.areEqual(this.fontStyle, other.fontStyle) && Intrinsics.areEqual(this.fontSynthesis, other.fontSynthesis) && Intrinsics.areEqual(this.fontFamily, other.fontFamily) && Intrinsics.areEqual(this.fontFeatureSettings, other.fontFeatureSettings) && TextUnit.m2672equalsimpl0(this.letterSpacing, other.letterSpacing) && Intrinsics.areEqual(this.baselineShift, other.baselineShift) && Intrinsics.areEqual(this.textGeometricTransform, other.textGeometricTransform) && Intrinsics.areEqual(this.localeList, other.localeList) && Color.m1487equalsimpl0(this.background, other.background) && Intrinsics.areEqual(this.platformStyle, other.platformStyle);
    }

    public final boolean hasSameNonLayoutAttributes$ui_text_release(SpanStyle other) {
        return Intrinsics.areEqual(this.textForegroundStyle, other.textForegroundStyle) && Intrinsics.areEqual(this.textDecoration, other.textDecoration) && Intrinsics.areEqual(this.shadow, other.shadow) && Intrinsics.areEqual(this.drawStyle, other.drawStyle);
    }

    public int hashCode() {
        int m1493hashCodeimpl = Color.m1493hashCodeimpl(m2255getColor0d7_KjU()) * 31;
        Brush brush = getBrush();
        int hashCode = (((((m1493hashCodeimpl + (brush != null ? brush.hashCode() : 0)) * 31) + Float.hashCode(getAlpha())) * 31) + TextUnit.m2676hashCodeimpl(this.fontSize)) * 31;
        FontWeight fontWeight = this.fontWeight;
        int hashCode2 = (hashCode + (fontWeight != null ? fontWeight.hashCode() : 0)) * 31;
        FontStyle fontStyle = this.fontStyle;
        int m2340hashCodeimpl = (hashCode2 + (fontStyle != null ? FontStyle.m2340hashCodeimpl(fontStyle.getValue()) : 0)) * 31;
        FontSynthesis fontSynthesis = this.fontSynthesis;
        int m2349hashCodeimpl = (m2340hashCodeimpl + (fontSynthesis != null ? FontSynthesis.m2349hashCodeimpl(fontSynthesis.getValue()) : 0)) * 31;
        FontFamily fontFamily = this.fontFamily;
        int hashCode3 = (m2349hashCodeimpl + (fontFamily != null ? fontFamily.hashCode() : 0)) * 31;
        String str = this.fontFeatureSettings;
        int hashCode4 = (((hashCode3 + (str != null ? str.hashCode() : 0)) * 31) + TextUnit.m2676hashCodeimpl(this.letterSpacing)) * 31;
        BaselineShift baselineShift = this.baselineShift;
        int m2459hashCodeimpl = (hashCode4 + (baselineShift != null ? BaselineShift.m2459hashCodeimpl(baselineShift.getMultiplier()) : 0)) * 31;
        TextGeometricTransform textGeometricTransform = this.textGeometricTransform;
        int hashCode5 = (m2459hashCodeimpl + (textGeometricTransform != null ? textGeometricTransform.hashCode() : 0)) * 31;
        LocaleList localeList = this.localeList;
        int hashCode6 = (((hashCode5 + (localeList != null ? localeList.hashCode() : 0)) * 31) + Color.m1493hashCodeimpl(this.background)) * 31;
        TextDecoration textDecoration = this.textDecoration;
        int hashCode7 = (hashCode6 + (textDecoration != null ? textDecoration.hashCode() : 0)) * 31;
        Shadow shadow = this.shadow;
        int hashCode8 = (hashCode7 + (shadow != null ? shadow.hashCode() : 0)) * 31;
        PlatformSpanStyle platformSpanStyle = this.platformStyle;
        int hashCode9 = (hashCode8 + (platformSpanStyle != null ? platformSpanStyle.hashCode() : 0)) * 31;
        DrawStyle drawStyle = this.drawStyle;
        return hashCode9 + (drawStyle != null ? drawStyle.hashCode() : 0);
    }

    public final SpanStyle merge(SpanStyle other) {
        return other == null ? this : SpanStyleKt.m2260fastMergedSHsh3o(this, other.textForegroundStyle.mo2464getColor0d7_KjU(), other.textForegroundStyle.getBrush(), other.textForegroundStyle.getAlpha(), other.fontSize, other.fontWeight, other.fontStyle, other.fontSynthesis, other.fontFamily, other.fontFeatureSettings, other.letterSpacing, other.baselineShift, other.textGeometricTransform, other.localeList, other.background, other.textDecoration, other.shadow, other.platformStyle, other.drawStyle);
    }

    public String toString() {
        return "SpanStyle(color=" + ((Object) Color.m1494toStringimpl(m2255getColor0d7_KjU())) + ", brush=" + getBrush() + ", alpha=" + getAlpha() + ", fontSize=" + ((Object) TextUnit.m2677toStringimpl(this.fontSize)) + ", fontWeight=" + this.fontWeight + ", fontStyle=" + this.fontStyle + ", fontSynthesis=" + this.fontSynthesis + ", fontFamily=" + this.fontFamily + ", fontFeatureSettings=" + this.fontFeatureSettings + ", letterSpacing=" + ((Object) TextUnit.m2677toStringimpl(this.letterSpacing)) + ", baselineShift=" + this.baselineShift + ", textGeometricTransform=" + this.textGeometricTransform + ", localeList=" + this.localeList + ", background=" + ((Object) Color.m1494toStringimpl(this.background)) + ", textDecoration=" + this.textDecoration + ", shadow=" + this.shadow + ", platformStyle=" + this.platformStyle + ", drawStyle=" + this.drawStyle + ')';
    }

    public /* synthetic */ SpanStyle(TextForegroundStyle textForegroundStyle, long j5, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j6, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j7, TextDecoration textDecoration, Shadow shadow, PlatformSpanStyle platformSpanStyle, DrawStyle drawStyle, DefaultConstructorMarker defaultConstructorMarker) {
        this(textForegroundStyle, j5, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j6, baselineShift, textGeometricTransform, localeList, j7, textDecoration, shadow, platformSpanStyle, drawStyle);
    }

    private SpanStyle(TextForegroundStyle textForegroundStyle, long j5, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j6, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j7, TextDecoration textDecoration, Shadow shadow, PlatformSpanStyle platformSpanStyle, DrawStyle drawStyle) {
        this.textForegroundStyle = textForegroundStyle;
        this.fontSize = j5;
        this.fontWeight = fontWeight;
        this.fontStyle = fontStyle;
        this.fontSynthesis = fontSynthesis;
        this.fontFamily = fontFamily;
        this.fontFeatureSettings = str;
        this.letterSpacing = j6;
        this.baselineShift = baselineShift;
        this.textGeometricTransform = textGeometricTransform;
        this.localeList = localeList;
        this.background = j7;
        this.textDecoration = textDecoration;
        this.shadow = shadow;
        this.platformStyle = platformSpanStyle;
        this.drawStyle = drawStyle;
    }

    public /* synthetic */ SpanStyle(long j5, long j6, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j7, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j8, TextDecoration textDecoration, Shadow shadow, PlatformSpanStyle platformSpanStyle, DrawStyle drawStyle, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : j5, (i5 & 2) != 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : j6, (i5 & 4) != 0 ? null : fontWeight, (i5 & 8) != 0 ? null : fontStyle, (i5 & 16) != 0 ? null : fontSynthesis, (i5 & 32) != 0 ? null : fontFamily, (i5 & 64) != 0 ? null : str, (i5 & 128) != 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : j7, (i5 & 256) != 0 ? null : baselineShift, (i5 & 512) != 0 ? null : textGeometricTransform, (i5 & 1024) != 0 ? null : localeList, (i5 & 2048) != 0 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : j8, (i5 & 4096) != 0 ? null : textDecoration, (i5 & 8192) != 0 ? null : shadow, (i5 & 16384) != 0 ? null : platformSpanStyle, (i5 & 32768) != 0 ? null : drawStyle, (DefaultConstructorMarker) null);
    }

    private SpanStyle(long j5, long j6, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j7, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j8, TextDecoration textDecoration, Shadow shadow, PlatformSpanStyle platformSpanStyle, DrawStyle drawStyle) {
        this(TextForegroundStyle.INSTANCE.m2549from8_81llA(j5), j6, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j7, baselineShift, textGeometricTransform, localeList, j8, textDecoration, shadow, platformSpanStyle, drawStyle, (DefaultConstructorMarker) null);
    }
}
