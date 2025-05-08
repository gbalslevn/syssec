package androidx.compose.foundation.text;

import androidx.compose.ui.text.TextRangeKt;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\b\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0000\u001a\u0014\u0010\u0004\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0000\u001a\u0019\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001H\u0000¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"findParagraphEnd", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "startIndex", "findParagraphStart", "getParagraphBoundary", "Landroidx/compose/ui/text/TextRange;", "index", "(Ljava/lang/CharSequence;I)J", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class StringHelpersKt {
    public static final int findParagraphEnd(CharSequence charSequence, int i5) {
        int length = charSequence.length();
        while (i5 < length) {
            if (charSequence.charAt(i5) == '\n') {
                return i5;
            }
            i5++;
        }
        return charSequence.length();
    }

    public static final int findParagraphStart(CharSequence charSequence, int i5) {
        while (i5 > 0) {
            if (charSequence.charAt(i5 - 1) == '\n') {
                return i5;
            }
            i5--;
        }
        return 0;
    }

    public static final long getParagraphBoundary(CharSequence charSequence, int i5) {
        return TextRangeKt.TextRange(findParagraphStart(charSequence, i5), findParagraphEnd(charSequence, i5));
    }
}
