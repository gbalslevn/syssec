package androidx.compose.foundation.gestures.snapping;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.lazy.grid.LazyGridItemInfo;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001b\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0006\u0010\u0005¨\u0006\u0007"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridItemInfo;", "Landroidx/compose/foundation/gestures/Orientation;", "orientation", BuildConfig.FLAVOR, "sizeOnMainAxis", "(Landroidx/compose/foundation/lazy/grid/LazyGridItemInfo;Landroidx/compose/foundation/gestures/Orientation;)I", "offsetOnMainAxis", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class LazyGridSnapLayoutInfoProviderKt {
    public static final int offsetOnMainAxis(LazyGridItemInfo lazyGridItemInfo, Orientation orientation) {
        return orientation == Orientation.Vertical ? IntOffset.m2641getYimpl(lazyGridItemInfo.mo391getOffsetnOccac()) : IntOffset.m2640getXimpl(lazyGridItemInfo.mo391getOffsetnOccac());
    }

    public static final int sizeOnMainAxis(LazyGridItemInfo lazyGridItemInfo, Orientation orientation) {
        return orientation == Orientation.Vertical ? IntSize.m2660getHeightimpl(lazyGridItemInfo.mo392getSizeYbymL2g()) : IntSize.m2661getWidthimpl(lazyGridItemInfo.mo392getSizeYbymL2g());
    }
}
