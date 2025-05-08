package androidx.compose.ui.text.platform;

import android.graphics.Typeface;
import android.os.Build;
import android.text.SpannableString;
import android.text.style.ScaleXSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.LinkAnnotation;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TtsAnnotation;
import androidx.compose.ui.text.UrlAnnotation;
import androidx.compose.ui.text.font.AndroidFontUtils_androidKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.GenericFontFamily;
import androidx.compose.ui.text.platform.extensions.SpannableExtensions_androidKt;
import androidx.compose.ui.text.platform.extensions.TtsAnnotationExtensions_androidKt;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Density;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a4\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002\u001a$\u0010\f\u001a\u00020\u0002*\u00020\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007\u001a\u0018\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011*\b\u0012\u0004\u0012\u00020\u00130\u0011H\u0002¨\u0006\u0014"}, d2 = {"setSpanStyle", BuildConfig.FLAVOR, "Landroid/text/SpannableString;", "spanStyle", "Landroidx/compose/ui/text/SpanStyle;", "start", BuildConfig.FLAVOR, "end", "density", "Landroidx/compose/ui/unit/Density;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "toAccessibilitySpannableString", "Landroidx/compose/ui/text/AnnotatedString;", "urlSpanCache", "Landroidx/compose/ui/text/platform/URLSpanCache;", "toUrlLink", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/LinkAnnotation$Url;", "Landroidx/compose/ui/text/LinkAnnotation;", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class AndroidAccessibilitySpannableString_androidKt {
    private static final void setSpanStyle(SpannableString spannableString, SpanStyle spanStyle, int i5, int i6, Density density, FontFamily.Resolver resolver) {
        SpannableExtensions_androidKt.m2446setColorRPmYEkk(spannableString, spanStyle.m2255getColor0d7_KjU(), i5, i6);
        SpannableExtensions_androidKt.m2447setFontSizeKmRG4DE(spannableString, spanStyle.getFontSize(), density, i5, i6);
        if (spanStyle.getFontWeight() != null || spanStyle.getFontStyle() != null) {
            FontWeight fontWeight = spanStyle.getFontWeight();
            if (fontWeight == null) {
                fontWeight = FontWeight.INSTANCE.getNormal();
            }
            FontStyle fontStyle = spanStyle.getFontStyle();
            spannableString.setSpan(new StyleSpan(AndroidFontUtils_androidKt.m2313getAndroidTypefaceStyleFO1MlWM(fontWeight, fontStyle != null ? fontStyle.getValue() : FontStyle.INSTANCE.m2344getNormal_LCdwA())), i5, i6, 33);
        }
        if (spanStyle.getFontFamily() != null) {
            if (spanStyle.getFontFamily() instanceof GenericFontFamily) {
                spannableString.setSpan(new TypefaceSpan(((GenericFontFamily) spanStyle.getFontFamily()).getName()), i5, i6, 33);
            } else if (Build.VERSION.SDK_INT >= 28) {
                FontFamily fontFamily = spanStyle.getFontFamily();
                FontSynthesis fontSynthesis = spanStyle.getFontSynthesis();
                Object value = FontFamily.Resolver.m2324resolveDPcqOEQ$default(resolver, fontFamily, null, 0, fontSynthesis != null ? fontSynthesis.getValue() : FontSynthesis.INSTANCE.m2354getAllGVVA2EU(), 6, null).getValue();
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type android.graphics.Typeface");
                spannableString.setSpan(Api28Impl.INSTANCE.createTypefaceSpan((Typeface) value), i5, i6, 33);
            }
        }
        if (spanStyle.getTextDecoration() != null) {
            TextDecoration textDecoration = spanStyle.getTextDecoration();
            TextDecoration.Companion companion = TextDecoration.INSTANCE;
            if (textDecoration.contains(companion.getUnderline())) {
                spannableString.setSpan(new UnderlineSpan(), i5, i6, 33);
            }
            if (spanStyle.getTextDecoration().contains(companion.getLineThrough())) {
                spannableString.setSpan(new StrikethroughSpan(), i5, i6, 33);
            }
        }
        if (spanStyle.getTextGeometricTransform() != null) {
            spannableString.setSpan(new ScaleXSpan(spanStyle.getTextGeometricTransform().getScaleX()), i5, i6, 33);
        }
        SpannableExtensions_androidKt.setLocaleList(spannableString, spanStyle.getLocaleList(), i5, i6);
        SpannableExtensions_androidKt.m2444setBackgroundRPmYEkk(spannableString, spanStyle.getBackground(), i5, i6);
    }

    public static final SpannableString toAccessibilitySpannableString(AnnotatedString annotatedString, Density density, FontFamily.Resolver resolver, URLSpanCache uRLSpanCache) {
        SpanStyle m2252copyGSF8kmg;
        SpannableString spannableString = new SpannableString(annotatedString.getText());
        List<AnnotatedString.Range<SpanStyle>> spanStylesOrNull$ui_text_release = annotatedString.getSpanStylesOrNull$ui_text_release();
        if (spanStylesOrNull$ui_text_release != null) {
            int size = spanStylesOrNull$ui_text_release.size();
            for (int i5 = 0; i5 < size; i5++) {
                AnnotatedString.Range<SpanStyle> range = spanStylesOrNull$ui_text_release.get(i5);
                SpanStyle component1 = range.component1();
                int start = range.getStart();
                int end = range.getEnd();
                m2252copyGSF8kmg = component1.m2252copyGSF8kmg((r38 & 1) != 0 ? component1.m2255getColor0d7_KjU() : 0L, (r38 & 2) != 0 ? component1.fontSize : 0L, (r38 & 4) != 0 ? component1.fontWeight : null, (r38 & 8) != 0 ? component1.fontStyle : null, (r38 & 16) != 0 ? component1.fontSynthesis : null, (r38 & 32) != 0 ? component1.fontFamily : null, (r38 & 64) != 0 ? component1.fontFeatureSettings : null, (r38 & 128) != 0 ? component1.letterSpacing : 0L, (r38 & 256) != 0 ? component1.baselineShift : null, (r38 & 512) != 0 ? component1.textGeometricTransform : null, (r38 & 1024) != 0 ? component1.localeList : null, (r38 & 2048) != 0 ? component1.background : 0L, (r38 & 4096) != 0 ? component1.textDecoration : null, (r38 & 8192) != 0 ? component1.shadow : null, (r38 & 16384) != 0 ? component1.platformStyle : null, (r38 & 32768) != 0 ? component1.drawStyle : null);
                setSpanStyle(spannableString, m2252copyGSF8kmg, start, end, density, resolver);
            }
        }
        List<AnnotatedString.Range<TtsAnnotation>> ttsAnnotations = annotatedString.getTtsAnnotations(0, annotatedString.length());
        int size2 = ttsAnnotations.size();
        for (int i6 = 0; i6 < size2; i6++) {
            AnnotatedString.Range<TtsAnnotation> range2 = ttsAnnotations.get(i6);
            spannableString.setSpan(TtsAnnotationExtensions_androidKt.toSpan(range2.component1()), range2.getStart(), range2.getEnd(), 33);
        }
        List<AnnotatedString.Range<UrlAnnotation>> urlAnnotations = annotatedString.getUrlAnnotations(0, annotatedString.length());
        int size3 = urlAnnotations.size();
        for (int i7 = 0; i7 < size3; i7++) {
            AnnotatedString.Range<UrlAnnotation> range3 = urlAnnotations.get(i7);
            spannableString.setSpan(uRLSpanCache.toURLSpan(range3.component1()), range3.getStart(), range3.getEnd(), 33);
        }
        List<AnnotatedString.Range<LinkAnnotation>> linkAnnotations = annotatedString.getLinkAnnotations(0, annotatedString.length());
        int size4 = linkAnnotations.size();
        for (int i8 = 0; i8 < size4; i8++) {
            AnnotatedString.Range<LinkAnnotation> range4 = linkAnnotations.get(i8);
            if (range4.getStart() != range4.getEnd()) {
                LinkAnnotation item = range4.getItem();
                if (item instanceof LinkAnnotation.Url) {
                    item.getLinkInteractionListener();
                    spannableString.setSpan(uRLSpanCache.toURLSpan(toUrlLink(range4)), range4.getStart(), range4.getEnd(), 33);
                } else {
                    spannableString.setSpan(uRLSpanCache.toClickableSpan(range4), range4.getStart(), range4.getEnd(), 33);
                }
            }
        }
        return spannableString;
    }

    private static final AnnotatedString.Range<LinkAnnotation.Url> toUrlLink(AnnotatedString.Range<LinkAnnotation> range) {
        LinkAnnotation item = range.getItem();
        Intrinsics.checkNotNull(item, "null cannot be cast to non-null type androidx.compose.ui.text.LinkAnnotation.Url");
        return new AnnotatedString.Range<>((LinkAnnotation.Url) item, range.getStart(), range.getEnd());
    }
}
