package androidx.compose.ui.text.input;

import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0006"}, d2 = {"updateRangeAfterDelete", "Landroidx/compose/ui/text/TextRange;", "target", "deleted", "updateRangeAfterDelete-pWDy79M", "(JJ)J", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class EditingBufferKt {
    /* renamed from: updateRangeAfterDelete-pWDy79M, reason: not valid java name */
    public static final long m2374updateRangeAfterDeletepWDy79M(long j5, long j6) {
        int m2281getLengthimpl;
        int m2283getMinimpl = TextRange.m2283getMinimpl(j5);
        int m2282getMaximpl = TextRange.m2282getMaximpl(j5);
        if (TextRange.m2287intersects5zctL8(j6, j5)) {
            if (TextRange.m2275contains5zctL8(j6, j5)) {
                m2283getMinimpl = TextRange.m2283getMinimpl(j6);
                m2282getMaximpl = m2283getMinimpl;
            } else {
                if (TextRange.m2275contains5zctL8(j5, j6)) {
                    m2281getLengthimpl = TextRange.m2281getLengthimpl(j6);
                } else if (TextRange.m2276containsimpl(j6, m2283getMinimpl)) {
                    m2283getMinimpl = TextRange.m2283getMinimpl(j6);
                    m2281getLengthimpl = TextRange.m2281getLengthimpl(j6);
                } else {
                    m2282getMaximpl = TextRange.m2283getMinimpl(j6);
                }
                m2282getMaximpl -= m2281getLengthimpl;
            }
        } else if (m2282getMaximpl > TextRange.m2283getMinimpl(j6)) {
            m2283getMinimpl -= TextRange.m2281getLengthimpl(j6);
            m2281getLengthimpl = TextRange.m2281getLengthimpl(j6);
            m2282getMaximpl -= m2281getLengthimpl;
        }
        return TextRangeKt.TextRange(m2283getMinimpl, m2282getMaximpl);
    }
}
