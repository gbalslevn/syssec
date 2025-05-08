package androidx.compose.foundation.pager;

import kotlin.Metadata;
import kotlin.math.MathKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroidx/compose/foundation/pager/PagerState;", BuildConfig.FLAVOR, "currentAbsoluteScrollOffset", "(Landroidx/compose/foundation/pager/PagerState;)J", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class PagerScrollPositionKt {
    public static final long currentAbsoluteScrollOffset(PagerState pagerState) {
        return (pagerState.getCurrentPage() * pagerState.getPageSizeWithSpacing$foundation_release()) + MathKt.roundToLong(pagerState.getCurrentPageOffsetFraction() * pagerState.getPageSizeWithSpacing$foundation_release());
    }
}
