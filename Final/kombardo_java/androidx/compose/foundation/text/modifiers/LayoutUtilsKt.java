package androidx.compose.foundation.text.modifiers;

import androidx.compose.foundation.text.TextDelegateKt;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\u001a2\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a*\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0000ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a2\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0013"}, d2 = {"finalConstraints", "Landroidx/compose/ui/unit/Constraints;", "constraints", "softWrap", BuildConfig.FLAVOR, "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "maxIntrinsicWidth", BuildConfig.FLAVOR, "finalConstraints-tfFHcEY", "(JZIF)J", "finalMaxLines", BuildConfig.FLAVOR, "maxLinesIn", "finalMaxLines-xdlQI24", "(ZII)I", "finalMaxWidth", "finalMaxWidth-tfFHcEY", "(JZIF)I", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class LayoutUtilsKt {
    /* renamed from: finalConstraints-tfFHcEY, reason: not valid java name */
    public static final long m603finalConstraintstfFHcEY(long j5, boolean z5, int i5, float f5) {
        return Constraints.INSTANCE.m2586fitPrioritizingWidthZbe2FdA(0, m605finalMaxWidthtfFHcEY(j5, z5, i5, f5), 0, Constraints.m2577getMaxHeightimpl(j5));
    }

    /* renamed from: finalMaxLines-xdlQI24, reason: not valid java name */
    public static final int m604finalMaxLinesxdlQI24(boolean z5, int i5, int i6) {
        if (z5 || !TextOverflow.m2560equalsimpl0(i5, TextOverflow.INSTANCE.m2564getEllipsisgIe3tQ8())) {
            return RangesKt.coerceAtLeast(i6, 1);
        }
        return 1;
    }

    /* renamed from: finalMaxWidth-tfFHcEY, reason: not valid java name */
    public static final int m605finalMaxWidthtfFHcEY(long j5, boolean z5, int i5, float f5) {
        int m2578getMaxWidthimpl = ((z5 || TextOverflow.m2560equalsimpl0(i5, TextOverflow.INSTANCE.m2564getEllipsisgIe3tQ8())) && Constraints.m2574getHasBoundedWidthimpl(j5)) ? Constraints.m2578getMaxWidthimpl(j5) : Integer.MAX_VALUE;
        return Constraints.m2580getMinWidthimpl(j5) == m2578getMaxWidthimpl ? m2578getMaxWidthimpl : RangesKt.coerceIn(TextDelegateKt.ceilToIntPx(f5), Constraints.m2580getMinWidthimpl(j5), m2578getMaxWidthimpl);
    }
}
