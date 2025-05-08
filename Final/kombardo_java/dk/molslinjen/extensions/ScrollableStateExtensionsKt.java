package dk.molslinjen.extensions;

import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.lazy.LazyListState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0001¨\u0006\u0004"}, d2 = {"elevationPercentage", BuildConfig.FLAVOR, "Landroidx/compose/foundation/gestures/ScrollableState;", "elevationMaxOffsetPixels", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class ScrollableStateExtensionsKt {
    public static final float elevationPercentage(ScrollableState scrollableState, float f5) {
        int value;
        float f6;
        Intrinsics.checkNotNullParameter(scrollableState, "<this>");
        if (scrollableState instanceof LazyListState) {
            LazyListState lazyListState = (LazyListState) scrollableState;
            if (lazyListState.getFirstVisibleItemIndex() == 0) {
                value = lazyListState.getFirstVisibleItemScrollOffset();
                f6 = value;
            }
            f6 = f5;
        } else {
            if (scrollableState instanceof ScrollState) {
                value = ((ScrollState) scrollableState).getValue();
                f6 = value;
            }
            f6 = f5;
        }
        return RangesKt.coerceIn(f6 / f5, 0.0f, 1.0f);
    }
}
