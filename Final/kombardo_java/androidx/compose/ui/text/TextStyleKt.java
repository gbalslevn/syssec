package androidx.compose.ui.text;

import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001e\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002\u001a\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b\u001a\u0016\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f\u001a\"\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0011H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0016"}, d2 = {"createPlatformTextStyleInternal", "Landroidx/compose/ui/text/PlatformTextStyle;", "platformSpanStyle", "Landroidx/compose/ui/text/PlatformSpanStyle;", "platformParagraphStyle", "Landroidx/compose/ui/text/PlatformParagraphStyle;", "lerp", "Landroidx/compose/ui/text/TextStyle;", "start", "stop", "fraction", BuildConfig.FLAVOR, "resolveDefaults", "style", "direction", "Landroidx/compose/ui/unit/LayoutDirection;", "resolveTextDirection", "Landroidx/compose/ui/text/style/TextDirection;", "layoutDirection", "textDirection", "resolveTextDirection-IhaHGbI", "(Landroidx/compose/ui/unit/LayoutDirection;I)I", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class TextStyleKt {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LayoutDirection.values().length];
            try {
                iArr[LayoutDirection.Ltr.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LayoutDirection.Rtl.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final PlatformTextStyle createPlatformTextStyleInternal(PlatformSpanStyle platformSpanStyle, PlatformParagraphStyle platformParagraphStyle) {
        if (platformSpanStyle == null && platformParagraphStyle == null) {
            return null;
        }
        return AndroidTextStyle_androidKt.createPlatformTextStyle(platformSpanStyle, platformParagraphStyle);
    }

    public static final TextStyle lerp(TextStyle textStyle, TextStyle textStyle2, float f5) {
        return new TextStyle(SpanStyleKt.lerp(textStyle.toSpanStyle(), textStyle2.toSpanStyle(), f5), ParagraphStyleKt.lerp(textStyle.toParagraphStyle(), textStyle2.toParagraphStyle(), f5));
    }

    public static final TextStyle resolveDefaults(TextStyle textStyle, LayoutDirection layoutDirection) {
        return new TextStyle(SpanStyleKt.resolveSpanStyleDefaults(textStyle.getSpanStyle()), ParagraphStyleKt.resolveParagraphStyleDefaults(textStyle.getParagraphStyle(), layoutDirection), textStyle.getPlatformStyle());
    }

    /* renamed from: resolveTextDirection-IhaHGbI */
    public static final int m2309resolveTextDirectionIhaHGbI(LayoutDirection layoutDirection, int i5) {
        TextDirection.Companion companion = TextDirection.INSTANCE;
        if (TextDirection.m2538equalsimpl0(i5, companion.m2542getContents_7Xco())) {
            int i6 = WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()];
            if (i6 == 1) {
                return companion.m2543getContentOrLtrs_7Xco();
            }
            if (i6 == 2) {
                return companion.m2544getContentOrRtls_7Xco();
            }
            throw new NoWhenBranchMatchedException();
        }
        if (!TextDirection.m2538equalsimpl0(i5, companion.m2547getUnspecifieds_7Xco())) {
            return i5;
        }
        int i7 = WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()];
        if (i7 == 1) {
            return companion.m2545getLtrs_7Xco();
        }
        if (i7 == 2) {
            return companion.m2546getRtls_7Xco();
        }
        throw new NoWhenBranchMatchedException();
    }
}
