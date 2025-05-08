package androidx.compose.ui.text;

import kotlin.Metadata;
import kotlin.ranges.RangesKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\u0010\r\n\u0002\b\u0004\u001a\u0013\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004\u001a\u001b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007\u001a\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0002\u001a$\u0010\n\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a\u001c\u0010\u000f\u001a\u00020\u0010*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0001ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0015"}, d2 = {"TextRange", "Landroidx/compose/ui/text/TextRange;", "index", BuildConfig.FLAVOR, "(I)J", "start", "end", "(II)J", "packWithCheck", BuildConfig.FLAVOR, "coerceIn", "minimumValue", "maximumValue", "coerceIn-8ffj60Q", "(JII)J", "substring", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "range", "substring-FDrldGo", "(Ljava/lang/CharSequence;J)Ljava/lang/String;", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class TextRangeKt {
    public static final long TextRange(int i5, int i6) {
        return TextRange.m2274constructorimpl(packWithCheck(i5, i6));
    }

    /* renamed from: coerceIn-8ffj60Q, reason: not valid java name */
    public static final long m2291coerceIn8ffj60Q(long j5, int i5, int i6) {
        int coerceIn = RangesKt.coerceIn(TextRange.m2285getStartimpl(j5), i5, i6);
        int coerceIn2 = RangesKt.coerceIn(TextRange.m2280getEndimpl(j5), i5, i6);
        return (coerceIn == TextRange.m2285getStartimpl(j5) && coerceIn2 == TextRange.m2280getEndimpl(j5)) ? j5 : TextRange(coerceIn, coerceIn2);
    }

    private static final long packWithCheck(int i5, int i6) {
        if (i5 < 0) {
            throw new IllegalArgumentException(("start cannot be negative. [start: " + i5 + ", end: " + i6 + ']').toString());
        }
        if (i6 >= 0) {
            return (i6 & 4294967295L) | (i5 << 32);
        }
        throw new IllegalArgumentException(("end cannot be negative. [start: " + i5 + ", end: " + i6 + ']').toString());
    }

    /* renamed from: substring-FDrldGo, reason: not valid java name */
    public static final String m2292substringFDrldGo(CharSequence charSequence, long j5) {
        return charSequence.subSequence(TextRange.m2283getMinimpl(j5), TextRange.m2282getMaximpl(j5)).toString();
    }

    public static final long TextRange(int i5) {
        return TextRange(i5, i5);
    }
}
