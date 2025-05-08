package androidx.compose.foundation.text;

import androidx.compose.ui.text.Paragraph;
import androidx.compose.ui.text.ParagraphKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a;\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\bH\u0000¢\u0006\u0004\b\u000b\u0010\f\"\u001a\u0010\r\u001a\u00020\u00068\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/text/TextStyle;", "style", "Landroidx/compose/ui/unit/Density;", "density", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "fontFamilyResolver", BuildConfig.FLAVOR, "text", BuildConfig.FLAVOR, "maxLines", "Landroidx/compose/ui/unit/IntSize;", "computeSizeForDefaultText", "(Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;Ljava/lang/String;I)J", "EmptyTextReplacement", "Ljava/lang/String;", "getEmptyTextReplacement", "()Ljava/lang/String;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class TextFieldDelegateKt {
    private static final String EmptyTextReplacement = StringsKt.repeat("H", 10);

    public static final long computeSizeForDefaultText(TextStyle textStyle, Density density, FontFamily.Resolver resolver, String str, int i5) {
        Paragraph m2229ParagraphUdtVg6A;
        m2229ParagraphUdtVg6A = ParagraphKt.m2229ParagraphUdtVg6A(str, textStyle, ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null), density, resolver, (r22 & 32) != 0 ? CollectionsKt.emptyList() : CollectionsKt.emptyList(), (r22 & 64) != 0 ? CollectionsKt.emptyList() : null, (r22 & 128) != 0 ? Integer.MAX_VALUE : i5, (r22 & 256) != 0 ? false : false);
        return IntSizeKt.IntSize(TextDelegateKt.ceilToIntPx(m2229ParagraphUdtVg6A.getMinIntrinsicWidth()), TextDelegateKt.ceilToIntPx(m2229ParagraphUdtVg6A.getHeight()));
    }

    public static /* synthetic */ long computeSizeForDefaultText$default(TextStyle textStyle, Density density, FontFamily.Resolver resolver, String str, int i5, int i6, Object obj) {
        if ((i6 & 8) != 0) {
            str = EmptyTextReplacement;
        }
        if ((i6 & 16) != 0) {
            i5 = 1;
        }
        return computeSizeForDefaultText(textStyle, density, resolver, str, i5);
    }

    public static final String getEmptyTextReplacement() {
        return EmptyTextReplacement;
    }
}
