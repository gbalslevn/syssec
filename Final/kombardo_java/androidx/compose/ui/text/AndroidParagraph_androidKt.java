package androidx.compose.ui.text;

import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import androidx.compose.ui.text.TextGranularity;
import androidx.compose.ui.text.android.TextLayout;
import androidx.compose.ui.text.android.style.IndentationFixSpan;
import androidx.compose.ui.text.platform.extensions.SpannableExtensions_androidKt;
import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0002\u001a\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u001a\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0002ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\n\u001a\u001a\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\n\u001a\u001a\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0015H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\n\u001a\u001a\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0019H\u0002ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\n\u001a\f\u0010\u001b\u001a\u00020\u001c*\u00020\u001cH\u0002\u001a\u0014\u0010\u001d\u001a\u00020\u0006*\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0006H\u0002\u001a\u0016\u0010 \u001a\u00020\u0006*\u00020!H\u0002ø\u0001\u0000¢\u0006\u0004\b\"\u0010\n\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006#"}, d2 = {"shouldAttachIndentationFixSpan", BuildConfig.FLAVOR, "textStyle", "Landroidx/compose/ui/text/TextStyle;", "ellipsis", "toLayoutAlign", BuildConfig.FLAVOR, "align", "Landroidx/compose/ui/text/style/TextAlign;", "toLayoutAlign-aXe7zB0", "(I)I", "toLayoutBreakStrategy", "breakStrategy", "Landroidx/compose/ui/text/style/LineBreak$Strategy;", "toLayoutBreakStrategy-xImikfE", "toLayoutHyphenationFrequency", "hyphens", "Landroidx/compose/ui/text/style/Hyphens;", "toLayoutHyphenationFrequency--3fSNIE", "toLayoutLineBreakStyle", "lineBreakStrictness", "Landroidx/compose/ui/text/style/LineBreak$Strictness;", "toLayoutLineBreakStyle-hpcqdu8", "toLayoutLineBreakWordStyle", "lineBreakWordStyle", "Landroidx/compose/ui/text/style/LineBreak$WordBreak;", "toLayoutLineBreakWordStyle-wPN0Rpw", "attachIndentationFixSpan", BuildConfig.FLAVOR, "numberOfLinesThatFitMaxHeight", "Landroidx/compose/ui/text/android/TextLayout;", "maxHeight", "toLayoutTextGranularity", "Landroidx/compose/ui/text/TextGranularity;", "toLayoutTextGranularity-duNsdkg", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class AndroidParagraph_androidKt {
    public static final /* synthetic */ CharSequence access$attachIndentationFixSpan(CharSequence charSequence) {
        return attachIndentationFixSpan(charSequence);
    }

    public static final /* synthetic */ int access$numberOfLinesThatFitMaxHeight(TextLayout textLayout, int i5) {
        return numberOfLinesThatFitMaxHeight(textLayout, i5);
    }

    public static final /* synthetic */ boolean access$shouldAttachIndentationFixSpan(TextStyle textStyle, boolean z5) {
        return shouldAttachIndentationFixSpan(textStyle, z5);
    }

    /* renamed from: access$toLayoutAlign-aXe7zB0, reason: not valid java name */
    public static final /* synthetic */ int m2192access$toLayoutAlignaXe7zB0(int i5) {
        return m2198toLayoutAlignaXe7zB0(i5);
    }

    /* renamed from: access$toLayoutBreakStrategy-xImikfE, reason: not valid java name */
    public static final /* synthetic */ int m2193access$toLayoutBreakStrategyxImikfE(int i5) {
        return m2199toLayoutBreakStrategyxImikfE(i5);
    }

    /* renamed from: access$toLayoutHyphenationFrequency--3fSNIE, reason: not valid java name */
    public static final /* synthetic */ int m2194access$toLayoutHyphenationFrequency3fSNIE(int i5) {
        return m2200toLayoutHyphenationFrequency3fSNIE(i5);
    }

    /* renamed from: access$toLayoutLineBreakStyle-hpcqdu8, reason: not valid java name */
    public static final /* synthetic */ int m2195access$toLayoutLineBreakStylehpcqdu8(int i5) {
        return m2201toLayoutLineBreakStylehpcqdu8(i5);
    }

    /* renamed from: access$toLayoutLineBreakWordStyle-wPN0Rpw, reason: not valid java name */
    public static final /* synthetic */ int m2196access$toLayoutLineBreakWordStylewPN0Rpw(int i5) {
        return m2202toLayoutLineBreakWordStylewPN0Rpw(i5);
    }

    /* renamed from: access$toLayoutTextGranularity-duNsdkg, reason: not valid java name */
    public static final /* synthetic */ int m2197access$toLayoutTextGranularityduNsdkg(int i5) {
        return m2203toLayoutTextGranularityduNsdkg(i5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence attachIndentationFixSpan(CharSequence charSequence) {
        if (charSequence.length() == 0) {
            return charSequence;
        }
        Spannable spannableString = charSequence instanceof Spannable ? (Spannable) charSequence : new SpannableString(charSequence);
        SpannableExtensions_androidKt.setSpan(spannableString, new IndentationFixSpan(), spannableString.length() - 1, spannableString.length() - 1);
        return spannableString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int numberOfLinesThatFitMaxHeight(TextLayout textLayout, int i5) {
        int lineCount = textLayout.getLineCount();
        for (int i6 = 0; i6 < lineCount; i6++) {
            if (textLayout.getLineBottom(i6) > i5) {
                return i6;
            }
        }
        return textLayout.getLineCount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean shouldAttachIndentationFixSpan(TextStyle textStyle, boolean z5) {
        if (!z5 || TextUnit.m2672equalsimpl0(textStyle.m2303getLetterSpacingXSAIIZE(), TextUnitKt.getSp(0)) || TextUnit.m2672equalsimpl0(textStyle.m2303getLetterSpacingXSAIIZE(), TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE())) {
            return false;
        }
        int m2306getTextAligne0LSkKk = textStyle.m2306getTextAligne0LSkKk();
        TextAlign.Companion companion = TextAlign.INSTANCE;
        return (TextAlign.m2524equalsimpl0(m2306getTextAligne0LSkKk, companion.m2534getUnspecifiede0LSkKk()) || TextAlign.m2524equalsimpl0(textStyle.m2306getTextAligne0LSkKk(), companion.m2533getStarte0LSkKk()) || TextAlign.m2524equalsimpl0(textStyle.m2306getTextAligne0LSkKk(), companion.m2530getJustifye0LSkKk())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toLayoutAlign-aXe7zB0, reason: not valid java name */
    public static final int m2198toLayoutAlignaXe7zB0(int i5) {
        TextAlign.Companion companion = TextAlign.INSTANCE;
        if (TextAlign.m2524equalsimpl0(i5, companion.m2531getLefte0LSkKk())) {
            return 3;
        }
        if (TextAlign.m2524equalsimpl0(i5, companion.m2532getRighte0LSkKk())) {
            return 4;
        }
        if (TextAlign.m2524equalsimpl0(i5, companion.m2528getCentere0LSkKk())) {
            return 2;
        }
        return (!TextAlign.m2524equalsimpl0(i5, companion.m2533getStarte0LSkKk()) && TextAlign.m2524equalsimpl0(i5, companion.m2529getEnde0LSkKk())) ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toLayoutBreakStrategy-xImikfE, reason: not valid java name */
    public static final int m2199toLayoutBreakStrategyxImikfE(int i5) {
        LineBreak.Strategy.Companion companion = LineBreak.Strategy.INSTANCE;
        if (LineBreak.Strategy.m2488equalsimpl0(i5, companion.m2492getSimplefcGXIks())) {
            return 0;
        }
        if (LineBreak.Strategy.m2488equalsimpl0(i5, companion.m2491getHighQualityfcGXIks())) {
            return 1;
        }
        return LineBreak.Strategy.m2488equalsimpl0(i5, companion.m2490getBalancedfcGXIks()) ? 2 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toLayoutHyphenationFrequency--3fSNIE, reason: not valid java name */
    public static final int m2200toLayoutHyphenationFrequency3fSNIE(int i5) {
        Hyphens.Companion companion = Hyphens.INSTANCE;
        if (Hyphens.m2468equalsimpl0(i5, companion.m2472getAutovmbZdU8())) {
            return Build.VERSION.SDK_INT <= 32 ? 2 : 4;
        }
        Hyphens.m2468equalsimpl0(i5, companion.m2473getNonevmbZdU8());
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toLayoutLineBreakStyle-hpcqdu8, reason: not valid java name */
    public static final int m2201toLayoutLineBreakStylehpcqdu8(int i5) {
        LineBreak.Strictness.Companion companion = LineBreak.Strictness.INSTANCE;
        if (LineBreak.Strictness.m2494equalsimpl0(i5, companion.m2496getDefaultusljTpc())) {
            return 0;
        }
        if (LineBreak.Strictness.m2494equalsimpl0(i5, companion.m2497getLooseusljTpc())) {
            return 1;
        }
        if (LineBreak.Strictness.m2494equalsimpl0(i5, companion.m2498getNormalusljTpc())) {
            return 2;
        }
        return LineBreak.Strictness.m2494equalsimpl0(i5, companion.m2499getStrictusljTpc()) ? 3 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toLayoutLineBreakWordStyle-wPN0Rpw, reason: not valid java name */
    public static final int m2202toLayoutLineBreakWordStylewPN0Rpw(int i5) {
        LineBreak.WordBreak.Companion companion = LineBreak.WordBreak.INSTANCE;
        return (!LineBreak.WordBreak.m2501equalsimpl0(i5, companion.m2503getDefaultjp8hJ3c()) && LineBreak.WordBreak.m2501equalsimpl0(i5, companion.m2504getPhrasejp8hJ3c())) ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toLayoutTextGranularity-duNsdkg, reason: not valid java name */
    public static final int m2203toLayoutTextGranularityduNsdkg(int i5) {
        TextGranularity.Companion companion = TextGranularity.INSTANCE;
        return (!TextGranularity.m2263equalsimpl0(i5, companion.m2264getCharacterDRrd7Zo()) && TextGranularity.m2263equalsimpl0(i5, companion.m2265getWordDRrd7Zo())) ? 1 : 0;
    }
}
