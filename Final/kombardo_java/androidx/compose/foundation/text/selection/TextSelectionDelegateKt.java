package androidx.compose.foundation.text.selection;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\u001a-\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0000¢\u0006\u0002\u0010\t\u001a$\u0010\n\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0000¨\u0006\f"}, d2 = {"getSelectionHandleCoordinates", "Landroidx/compose/ui/geometry/Offset;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "offset", BuildConfig.FLAVOR, "isStart", BuildConfig.FLAVOR, "areHandlesCrossed", "(Landroidx/compose/ui/text/TextLayoutResult;IZZ)J", "getHorizontalPosition", BuildConfig.FLAVOR, "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class TextSelectionDelegateKt {
    public static final float getHorizontalPosition(TextLayoutResult textLayoutResult, int i5, boolean z5, boolean z6) {
        return textLayoutResult.getHorizontalPosition(i5, textLayoutResult.getBidiRunDirection(((!z5 || z6) && (z5 || !z6)) ? Math.max(i5 + (-1), 0) : i5) == textLayoutResult.getParagraphDirection(i5));
    }

    public static final long getSelectionHandleCoordinates(TextLayoutResult textLayoutResult, int i5, boolean z5, boolean z6) {
        int lineForOffset = textLayoutResult.getLineForOffset(i5);
        return lineForOffset >= textLayoutResult.getLineCount() ? Offset.INSTANCE.m1348getUnspecifiedF1C5BW0() : OffsetKt.Offset(RangesKt.coerceIn(getHorizontalPosition(textLayoutResult, i5, z5, z6), 0.0f, IntSize.m2661getWidthimpl(textLayoutResult.getSize())), RangesKt.coerceIn(textLayoutResult.getLineBottom(lineForOffset), 0.0f, IntSize.m2660getHeightimpl(textLayoutResult.getSize())));
    }
}
