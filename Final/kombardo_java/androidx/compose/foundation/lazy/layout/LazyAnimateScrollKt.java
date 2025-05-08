package androidx.compose.foundation.lazy.layout;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a4\u0010\u000b\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\bH\u0080@¢\u0006\u0004\b\u000b\u0010\f\"\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f\"\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u000f\"\u0014\u0010\u0011\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u000f\"\u0014\u0010\u0012\u001a\u00020\u00038\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimateScrollScope;", BuildConfig.FLAVOR, "index", BuildConfig.FLAVOR, "isItemVisible", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimateScrollScope;I)Z", "scrollOffset", "numOfItemsForTeleport", "Landroidx/compose/ui/unit/Density;", "density", BuildConfig.FLAVOR, "animateScrollToItem", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimateScrollScope;IIILandroidx/compose/ui/unit/Density;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/compose/ui/unit/Dp;", "TargetDistance", "F", "BoundDistance", "MinimumDistance", "DEBUG", "Z", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class LazyAnimateScrollKt {
    private static final boolean DEBUG = false;
    private static final float TargetDistance = Dp.m2599constructorimpl(2500);
    private static final float BoundDistance = Dp.m2599constructorimpl(1500);
    private static final float MinimumDistance = Dp.m2599constructorimpl(50);

    public static final Object animateScrollToItem(LazyLayoutAnimateScrollScope lazyLayoutAnimateScrollScope, int i5, int i6, int i7, Density density, Continuation<? super Unit> continuation) {
        Object scroll = lazyLayoutAnimateScrollScope.scroll(new LazyAnimateScrollKt$animateScrollToItem$2(i5, density, lazyLayoutAnimateScrollScope, i6, i7, null), continuation);
        return scroll == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? scroll : Unit.INSTANCE;
    }

    public static final boolean isItemVisible(LazyLayoutAnimateScrollScope lazyLayoutAnimateScrollScope, int i5) {
        return i5 <= lazyLayoutAnimateScrollScope.getLastVisibleItemIndex() && lazyLayoutAnimateScrollScope.getFirstVisibleItemIndex() <= i5;
    }
}
