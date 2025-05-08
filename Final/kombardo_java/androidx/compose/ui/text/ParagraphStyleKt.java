package androidx.compose.ui.text;

import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextIndentKt;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000X\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007\u001a&\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\bH\u0002\u001a\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0000\u001af\u0010\u000f\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00012\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0000ø\u0001\u0000¢\u0006\u0004\b \u0010!\u001a\u0018\u0010\"\u001a\u0004\u0018\u00010\n*\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010\nH\u0002\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006$"}, d2 = {"DefaultLineHeight", "Landroidx/compose/ui/unit/TextUnit;", "J", "lerp", "Landroidx/compose/ui/text/ParagraphStyle;", "start", "stop", "fraction", BuildConfig.FLAVOR, "lerpPlatformStyle", "Landroidx/compose/ui/text/PlatformParagraphStyle;", "resolveParagraphStyleDefaults", "style", "direction", "Landroidx/compose/ui/unit/LayoutDirection;", "fastMerge", "textAlign", "Landroidx/compose/ui/text/style/TextAlign;", "textDirection", "Landroidx/compose/ui/text/style/TextDirection;", "lineHeight", "textIndent", "Landroidx/compose/ui/text/style/TextIndent;", "platformStyle", "lineHeightStyle", "Landroidx/compose/ui/text/style/LineHeightStyle;", "lineBreak", "Landroidx/compose/ui/text/style/LineBreak;", "hyphens", "Landroidx/compose/ui/text/style/Hyphens;", "textMotion", "Landroidx/compose/ui/text/style/TextMotion;", "fastMerge-j5T8yCg", "(Landroidx/compose/ui/text/ParagraphStyle;IIJLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformParagraphStyle;Landroidx/compose/ui/text/style/LineHeightStyle;IILandroidx/compose/ui/text/style/TextMotion;)Landroidx/compose/ui/text/ParagraphStyle;", "mergePlatformStyle", "other", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class ParagraphStyleKt {
    private static final long DefaultLineHeight = TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE();

    /* JADX WARN: Code restructure failed: missing block: B:41:0x003d, code lost:
    
        if (androidx.compose.ui.unit.TextUnit.m2672equalsimpl0(r12, r24.getLineHeight()) != false) goto L14;
     */
    /* renamed from: fastMerge-j5T8yCg, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final ParagraphStyle m2239fastMergej5T8yCg(ParagraphStyle paragraphStyle, int i5, int i6, long j5, TextIndent textIndent, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle, int i7, int i8, TextMotion textMotion) {
        long j6;
        int i9 = i5;
        TextIndent textIndent2 = textIndent;
        TextAlign.Companion companion = TextAlign.INSTANCE;
        if (TextAlign.m2524equalsimpl0(i9, companion.m2534getUnspecifiede0LSkKk()) || TextAlign.m2524equalsimpl0(i9, paragraphStyle.getTextAlign())) {
            if (TextUnitKt.m2683isUnspecifiedR2X_6o(j5)) {
                j6 = j5;
            } else {
                j6 = j5;
            }
            if ((textIndent2 == null || Intrinsics.areEqual(textIndent2, paragraphStyle.getTextIndent())) && ((TextDirection.m2538equalsimpl0(i6, TextDirection.INSTANCE.m2547getUnspecifieds_7Xco()) || TextDirection.m2538equalsimpl0(i6, paragraphStyle.getTextDirection())) && ((platformParagraphStyle == null || Intrinsics.areEqual(platformParagraphStyle, paragraphStyle.getPlatformStyle())) && ((lineHeightStyle == null || Intrinsics.areEqual(lineHeightStyle, paragraphStyle.getLineHeightStyle())) && ((LineBreak.m2478equalsimpl0(i7, LineBreak.INSTANCE.m2486getUnspecifiedrAG3T2k()) || LineBreak.m2478equalsimpl0(i7, paragraphStyle.getLineBreak())) && ((Hyphens.m2468equalsimpl0(i8, Hyphens.INSTANCE.m2474getUnspecifiedvmbZdU8()) || Hyphens.m2468equalsimpl0(i8, paragraphStyle.getHyphens())) && (textMotion == null || Intrinsics.areEqual(textMotion, paragraphStyle.getTextMotion())))))))) {
                return paragraphStyle;
            }
        } else {
            j6 = j5;
        }
        long lineHeight = TextUnitKt.m2683isUnspecifiedR2X_6o(j5) ? paragraphStyle.getLineHeight() : j6;
        if (textIndent2 == null) {
            textIndent2 = paragraphStyle.getTextIndent();
        }
        TextIndent textIndent3 = textIndent2;
        if (TextAlign.m2524equalsimpl0(i9, companion.m2534getUnspecifiede0LSkKk())) {
            i9 = paragraphStyle.getTextAlign();
        }
        return new ParagraphStyle(i9, !TextDirection.m2538equalsimpl0(i6, TextDirection.INSTANCE.m2547getUnspecifieds_7Xco()) ? i6 : paragraphStyle.getTextDirection(), lineHeight, textIndent3, mergePlatformStyle(paragraphStyle, platformParagraphStyle), lineHeightStyle == null ? paragraphStyle.getLineHeightStyle() : lineHeightStyle, !LineBreak.m2478equalsimpl0(i7, LineBreak.INSTANCE.m2486getUnspecifiedrAG3T2k()) ? i7 : paragraphStyle.getLineBreak(), !Hyphens.m2468equalsimpl0(i8, Hyphens.INSTANCE.m2474getUnspecifiedvmbZdU8()) ? i8 : paragraphStyle.getHyphens(), textMotion == null ? paragraphStyle.getTextMotion() : textMotion, null);
    }

    public static final ParagraphStyle lerp(ParagraphStyle paragraphStyle, ParagraphStyle paragraphStyle2, float f5) {
        int value = ((TextAlign) SpanStyleKt.lerpDiscrete(TextAlign.m2521boximpl(paragraphStyle.getTextAlign()), TextAlign.m2521boximpl(paragraphStyle2.getTextAlign()), f5)).getValue();
        int value2 = ((TextDirection) SpanStyleKt.lerpDiscrete(TextDirection.m2535boximpl(paragraphStyle.getTextDirection()), TextDirection.m2535boximpl(paragraphStyle2.getTextDirection()), f5)).getValue();
        long m2261lerpTextUnitInheritableC3pnCVY = SpanStyleKt.m2261lerpTextUnitInheritableC3pnCVY(paragraphStyle.getLineHeight(), paragraphStyle2.getLineHeight(), f5);
        TextIndent textIndent = paragraphStyle.getTextIndent();
        if (textIndent == null) {
            textIndent = TextIndent.INSTANCE.getNone();
        }
        TextIndent textIndent2 = paragraphStyle2.getTextIndent();
        if (textIndent2 == null) {
            textIndent2 = TextIndent.INSTANCE.getNone();
        }
        return new ParagraphStyle(value, value2, m2261lerpTextUnitInheritableC3pnCVY, TextIndentKt.lerp(textIndent, textIndent2, f5), lerpPlatformStyle(paragraphStyle.getPlatformStyle(), paragraphStyle2.getPlatformStyle(), f5), (LineHeightStyle) SpanStyleKt.lerpDiscrete(paragraphStyle.getLineHeightStyle(), paragraphStyle2.getLineHeightStyle(), f5), ((LineBreak) SpanStyleKt.lerpDiscrete(LineBreak.m2475boximpl(paragraphStyle.getLineBreak()), LineBreak.m2475boximpl(paragraphStyle2.getLineBreak()), f5)).getMask(), ((Hyphens) SpanStyleKt.lerpDiscrete(Hyphens.m2465boximpl(paragraphStyle.getHyphens()), Hyphens.m2465boximpl(paragraphStyle2.getHyphens()), f5)).getValue(), (TextMotion) SpanStyleKt.lerpDiscrete(paragraphStyle.getTextMotion(), paragraphStyle2.getTextMotion(), f5), null);
    }

    private static final PlatformParagraphStyle lerpPlatformStyle(PlatformParagraphStyle platformParagraphStyle, PlatformParagraphStyle platformParagraphStyle2, float f5) {
        if (platformParagraphStyle == null && platformParagraphStyle2 == null) {
            return null;
        }
        if (platformParagraphStyle == null) {
            platformParagraphStyle = PlatformParagraphStyle.INSTANCE.getDefault();
        }
        if (platformParagraphStyle2 == null) {
            platformParagraphStyle2 = PlatformParagraphStyle.INSTANCE.getDefault();
        }
        return AndroidTextStyle_androidKt.lerp(platformParagraphStyle, platformParagraphStyle2, f5);
    }

    private static final PlatformParagraphStyle mergePlatformStyle(ParagraphStyle paragraphStyle, PlatformParagraphStyle platformParagraphStyle) {
        return paragraphStyle.getPlatformStyle() == null ? platformParagraphStyle : platformParagraphStyle == null ? paragraphStyle.getPlatformStyle() : paragraphStyle.getPlatformStyle().merge(platformParagraphStyle);
    }

    public static final ParagraphStyle resolveParagraphStyleDefaults(ParagraphStyle paragraphStyle, LayoutDirection layoutDirection) {
        int textAlign = paragraphStyle.getTextAlign();
        TextAlign.Companion companion = TextAlign.INSTANCE;
        int m2533getStarte0LSkKk = TextAlign.m2524equalsimpl0(textAlign, companion.m2534getUnspecifiede0LSkKk()) ? companion.m2533getStarte0LSkKk() : paragraphStyle.getTextAlign();
        int m2309resolveTextDirectionIhaHGbI = TextStyleKt.m2309resolveTextDirectionIhaHGbI(layoutDirection, paragraphStyle.getTextDirection());
        long lineHeight = TextUnitKt.m2683isUnspecifiedR2X_6o(paragraphStyle.getLineHeight()) ? DefaultLineHeight : paragraphStyle.getLineHeight();
        TextIndent textIndent = paragraphStyle.getTextIndent();
        if (textIndent == null) {
            textIndent = TextIndent.INSTANCE.getNone();
        }
        TextIndent textIndent2 = textIndent;
        PlatformParagraphStyle platformStyle = paragraphStyle.getPlatformStyle();
        LineHeightStyle lineHeightStyle = paragraphStyle.getLineHeightStyle();
        int lineBreak = paragraphStyle.getLineBreak();
        LineBreak.Companion companion2 = LineBreak.INSTANCE;
        int m2485getSimplerAG3T2k = LineBreak.m2478equalsimpl0(lineBreak, companion2.m2486getUnspecifiedrAG3T2k()) ? companion2.m2485getSimplerAG3T2k() : paragraphStyle.getLineBreak();
        int hyphens = paragraphStyle.getHyphens();
        Hyphens.Companion companion3 = Hyphens.INSTANCE;
        int m2473getNonevmbZdU8 = Hyphens.m2468equalsimpl0(hyphens, companion3.m2474getUnspecifiedvmbZdU8()) ? companion3.m2473getNonevmbZdU8() : paragraphStyle.getHyphens();
        TextMotion textMotion = paragraphStyle.getTextMotion();
        if (textMotion == null) {
            textMotion = TextMotion.INSTANCE.getStatic();
        }
        return new ParagraphStyle(m2533getStarte0LSkKk, m2309resolveTextDirectionIhaHGbI, lineHeight, textIndent2, platformStyle, lineHeightStyle, m2485getSimplerAG3T2k, m2473getNonevmbZdU8, textMotion, null);
    }
}
