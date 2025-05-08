package androidx.compose.ui.unit;

import androidx.compose.ui.geometry.Rect;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\"\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0013\u0010\t\u001a\u00020\u0004*\u00020\bH\u0007¢\u0006\u0004\b\t\u0010\n\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/unit/IntOffset;", "offset", "Landroidx/compose/ui/unit/IntSize;", "size", "Landroidx/compose/ui/unit/IntRect;", "IntRect-VbeCjmY", "(JJ)Landroidx/compose/ui/unit/IntRect;", "IntRect", "Landroidx/compose/ui/geometry/Rect;", "roundToIntRect", "(Landroidx/compose/ui/geometry/Rect;)Landroidx/compose/ui/unit/IntRect;", "ui-unit_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class IntRectKt {
    /* renamed from: IntRect-VbeCjmY, reason: not valid java name */
    public static final IntRect m2655IntRectVbeCjmY(long j5, long j6) {
        return new IntRect(IntOffset.m2640getXimpl(j5), IntOffset.m2641getYimpl(j5), IntOffset.m2640getXimpl(j5) + IntSize.m2661getWidthimpl(j6), IntOffset.m2641getYimpl(j5) + IntSize.m2660getHeightimpl(j6));
    }

    public static final IntRect roundToIntRect(Rect rect) {
        return new IntRect(Math.round(rect.getLeft()), Math.round(rect.getTop()), Math.round(rect.getRight()), Math.round(rect.getBottom()));
    }
}
