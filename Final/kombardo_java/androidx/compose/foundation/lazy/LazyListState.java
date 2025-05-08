package androidx.compose.foundation.lazy;

import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.gestures.ScrollableStateKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier;
import androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator;
import androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.foundation.lazy.layout.NestedPrefetchScope;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.layout.Remeasurement;
import androidx.compose.ui.layout.RemeasurementModifier;
import androidx.compose.ui.unit.Density;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 ª\u00012\u00020\u0001:\u0002ª\u0001B'\b\u0007\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bB\u001d\b\u0016\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\tJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J$\u0010\u0019\u001a\u00020\u000e2\b\b\u0001\u0010\u0017\u001a\u00020\u00022\b\b\u0002\u0010\u0018\u001a\u00020\u0002H\u0086@¢\u0006\u0004\b\u0019\u0010\u001aJ'\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001bH\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ<\u0010'\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020 2\"\u0010&\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020#\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0$\u0012\u0006\u0012\u0004\u0018\u00010%0\"H\u0096@¢\u0006\u0004\b'\u0010(J\u0017\u0010)\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b)\u0010*J\u0017\u0010-\u001a\u00020\n2\u0006\u0010+\u001a\u00020\nH\u0000¢\u0006\u0004\b,\u0010*J$\u0010.\u001a\u00020\u000e2\b\b\u0001\u0010\u0017\u001a\u00020\u00022\b\b\u0002\u0010\u0018\u001a\u00020\u0002H\u0086@¢\u0006\u0004\b.\u0010\u001aJ)\u00105\u001a\u00020\u000e2\u0006\u00100\u001a\u00020/2\u0006\u00101\u001a\u00020\u001b2\b\b\u0002\u00102\u001a\u00020\u001bH\u0000¢\u0006\u0004\b3\u00104J\u001f\u0010;\u001a\u00020\u00022\u0006\u00107\u001a\u0002062\u0006\u00108\u001a\u00020\u0002H\u0000¢\u0006\u0004\b9\u0010:R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010<R$\u0010>\u001a\u00020\u001b2\u0006\u0010=\u001a\u00020\u001b8\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR(\u0010B\u001a\u0004\u0018\u00010/2\b\u0010=\u001a\u0004\u0018\u00010/8\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010ER\u0014\u0010G\u001a\u00020F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u0014\u0010J\u001a\u00020I8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR\u001a\u0010M\u001a\b\u0012\u0004\u0012\u00020/0L8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u001a\u0010P\u001a\u00020O8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010SR$\u0010T\u001a\u00020\n2\u0006\u0010=\u001a\u00020\n8\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\bT\u0010U\u001a\u0004\bV\u0010WR\u0014\u0010X\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bX\u0010YR$\u0010Z\u001a\u00020\u00022\u0006\u0010=\u001a\u00020\u00028\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]R\"\u0010^\u001a\u00020\u001b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b^\u0010?\u001a\u0004\b_\u0010A\"\u0004\b`\u0010aR(\u0010c\u001a\u0004\u0018\u00010b2\b\u0010=\u001a\u0004\u0018\u00010b8\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\bc\u0010d\u001a\u0004\be\u0010fR\u001a\u0010h\u001a\u00020g8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bh\u0010i\u001a\u0004\bj\u0010kR\u001a\u0010m\u001a\u00020l8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bm\u0010n\u001a\u0004\bo\u0010pR \u0010s\u001a\b\u0012\u0004\u0012\u00020r0q8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bs\u0010t\u001a\u0004\bu\u0010vR\u001a\u0010x\u001a\u00020w8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bx\u0010y\u001a\u0004\bz\u0010{R\u001b\u0010}\u001a\u00020|8\u0000X\u0080\u0004¢\u0006\r\n\u0004\b}\u0010~\u001a\u0005\b\u007f\u0010\u0080\u0001R\u0018\u0010\u0082\u0001\u001a\u00030\u0081\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0082\u0001\u0010\u0083\u0001R \u0010\u0085\u0001\u001a\u00030\u0084\u00018\u0000X\u0080\u0004¢\u0006\u0010\n\u0006\b\u0085\u0001\u0010\u0086\u0001\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001R%\u0010\u008a\u0001\u001a\u00030\u0089\u00018\u0000X\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u000f\n\u0005\b\u008a\u0001\u0010N\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001R/\u0010\u0090\u0001\u001a\u00020\u001b2\u0006\u0010=\u001a\u00020\u001b8V@RX\u0096\u008e\u0002¢\u0006\u0015\n\u0005\b\u008d\u0001\u0010N\u001a\u0005\b\u008e\u0001\u0010A\"\u0005\b\u008f\u0001\u0010aR/\u0010\u0094\u0001\u001a\u00020\u001b2\u0006\u0010=\u001a\u00020\u001b8V@RX\u0096\u008e\u0002¢\u0006\u0015\n\u0005\b\u0091\u0001\u0010N\u001a\u0005\b\u0092\u0001\u0010A\"\u0005\b\u0093\u0001\u0010aR%\u0010\u0095\u0001\u001a\u00030\u0089\u00018\u0000X\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u000f\n\u0005\b\u0095\u0001\u0010N\u001a\u0006\b\u0096\u0001\u0010\u008c\u0001R'\u0010\u0099\u0001\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0005\u0012\u00030\u0098\u00010\u0097\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0099\u0001\u0010\u009a\u0001R\u0012\u0010\u0003\u001a\u00020\u00028F¢\u0006\u0007\u001a\u0005\b\u009b\u0001\u0010]R\u0012\u0010\u0004\u001a\u00020\u00028F¢\u0006\u0007\u001a\u0005\b\u009c\u0001\u0010]R\u0013\u0010\r\u001a\u00020\f8F¢\u0006\b\u001a\u0006\b\u009d\u0001\u0010\u009e\u0001R\u0016\u0010\u0012\u001a\u00020\u00118@X\u0080\u0004¢\u0006\b\u001a\u0006\b\u009f\u0001\u0010 \u0001R!\u0010¦\u0001\u001a\u00030¡\u00018@X\u0080\u0084\u0002¢\u0006\u0010\u001a\u0006\b¢\u0001\u0010£\u0001*\u0006\b¤\u0001\u0010¥\u0001R\u0016\u0010§\u0001\u001a\u00020\u001b8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b§\u0001\u0010AR\u0016\u0010©\u0001\u001a\u00020\n8@X\u0080\u0004¢\u0006\u0007\u001a\u0005\b¨\u0001\u0010W\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006«\u0001"}, d2 = {"Landroidx/compose/foundation/lazy/LazyListState;", "Landroidx/compose/foundation/gestures/ScrollableState;", BuildConfig.FLAVOR, "firstVisibleItemIndex", "firstVisibleItemScrollOffset", "Landroidx/compose/foundation/lazy/LazyListPrefetchStrategy;", "prefetchStrategy", "<init>", "(IILandroidx/compose/foundation/lazy/LazyListPrefetchStrategy;)V", "(II)V", BuildConfig.FLAVOR, "delta", "Landroidx/compose/foundation/lazy/LazyListLayoutInfo;", "layoutInfo", BuildConfig.FLAVOR, "notifyPrefetchOnScroll", "(FLandroidx/compose/foundation/lazy/LazyListLayoutInfo;)V", "Landroidx/compose/ui/unit/Density;", "density", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "updateScrollDeltaForPostLookahead", "(FLandroidx/compose/ui/unit/Density;Lkotlinx/coroutines/CoroutineScope;)V", "index", "scrollOffset", "scrollToItem", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", BuildConfig.FLAVOR, "forceRemeasure", "snapToItemIndexInternal$foundation_release", "(IIZ)V", "snapToItemIndexInternal", "Landroidx/compose/foundation/MutatePriority;", "scrollPriority", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/ScrollScope;", "Lkotlin/coroutines/Continuation;", BuildConfig.FLAVOR, "block", "scroll", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatchRawDelta", "(F)F", "distance", "onScroll$foundation_release", "onScroll", "animateScrollToItem", "Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "result", "isLookingAhead", "visibleItemsStayedTheSame", "applyMeasureResult$foundation_release", "(Landroidx/compose/foundation/lazy/LazyListMeasureResult;ZZ)V", "applyMeasureResult", "Landroidx/compose/foundation/lazy/LazyListItemProvider;", "itemProvider", "firstItemIndex", "updateScrollPositionIfTheFirstItemWasMoved$foundation_release", "(Landroidx/compose/foundation/lazy/LazyListItemProvider;I)I", "updateScrollPositionIfTheFirstItemWasMoved", "Landroidx/compose/foundation/lazy/LazyListPrefetchStrategy;", "<set-?>", "hasLookaheadPassOccurred", "Z", "getHasLookaheadPassOccurred$foundation_release", "()Z", "postLookaheadLayoutInfo", "Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "getPostLookaheadLayoutInfo$foundation_release", "()Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "Landroidx/compose/foundation/lazy/LazyListScrollPosition;", "scrollPosition", "Landroidx/compose/foundation/lazy/LazyListScrollPosition;", "Landroidx/compose/foundation/lazy/LazyListAnimateScrollScope;", "animateScrollScope", "Landroidx/compose/foundation/lazy/LazyListAnimateScrollScope;", "Landroidx/compose/runtime/MutableState;", "layoutInfoState", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "internalInteractionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "getInternalInteractionSource$foundation_release", "()Landroidx/compose/foundation/interaction/MutableInteractionSource;", "scrollToBeConsumed", "F", "getScrollToBeConsumed$foundation_release", "()F", "scrollableState", "Landroidx/compose/foundation/gestures/ScrollableState;", "numMeasurePasses", "I", "getNumMeasurePasses$foundation_release", "()I", "prefetchingEnabled", "getPrefetchingEnabled$foundation_release", "setPrefetchingEnabled$foundation_release", "(Z)V", "Landroidx/compose/ui/layout/Remeasurement;", "remeasurement", "Landroidx/compose/ui/layout/Remeasurement;", "getRemeasurement$foundation_release", "()Landroidx/compose/ui/layout/Remeasurement;", "Landroidx/compose/ui/layout/RemeasurementModifier;", "remeasurementModifier", "Landroidx/compose/ui/layout/RemeasurementModifier;", "getRemeasurementModifier$foundation_release", "()Landroidx/compose/ui/layout/RemeasurementModifier;", "Landroidx/compose/foundation/lazy/layout/AwaitFirstLayoutModifier;", "awaitLayoutModifier", "Landroidx/compose/foundation/lazy/layout/AwaitFirstLayoutModifier;", "getAwaitLayoutModifier$foundation_release", "()Landroidx/compose/foundation/lazy/layout/AwaitFirstLayoutModifier;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "Landroidx/compose/foundation/lazy/LazyListMeasuredItem;", "itemAnimator", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "getItemAnimator$foundation_release", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;", "beyondBoundsInfo", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;", "getBeyondBoundsInfo$foundation_release", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "prefetchState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "getPrefetchState$foundation_release", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "Landroidx/compose/foundation/lazy/LazyListPrefetchScope;", "prefetchScope", "Landroidx/compose/foundation/lazy/LazyListPrefetchScope;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList;", "pinnedItems", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList;", "getPinnedItems$foundation_release", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList;", "Landroidx/compose/foundation/lazy/layout/ObservableScopeInvalidator;", "measurementScopeInvalidator", "getMeasurementScopeInvalidator-zYiylxw$foundation_release", "()Landroidx/compose/runtime/MutableState;", "canScrollForward$delegate", "getCanScrollForward", "setCanScrollForward", "canScrollForward", "canScrollBackward$delegate", "getCanScrollBackward", "setCanScrollBackward", "canScrollBackward", "placementScopeInvalidator", "getPlacementScopeInvalidator-zYiylxw$foundation_release", "Landroidx/compose/animation/core/AnimationState;", "Landroidx/compose/animation/core/AnimationVector1D;", "_scrollDeltaBetweenPasses", "Landroidx/compose/animation/core/AnimationState;", "getFirstVisibleItemIndex", "getFirstVisibleItemScrollOffset", "getLayoutInfo", "()Landroidx/compose/foundation/lazy/LazyListLayoutInfo;", "getDensity$foundation_release", "()Landroidx/compose/ui/unit/Density;", "Lkotlin/ranges/IntRange;", "getNearestRange$foundation_release", "()Lkotlin/ranges/IntRange;", "getNearestRange$foundation_release$delegate", "(Landroidx/compose/foundation/lazy/LazyListState;)Ljava/lang/Object;", "nearestRange", "isScrollInProgress", "getScrollDeltaBetweenPasses$foundation_release", "scrollDeltaBetweenPasses", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LazyListState implements ScrollableState {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Saver<LazyListState, ?> Saver = ListSaverKt.listSaver(new Function2<SaverScope, LazyListState, List<? extends Integer>>() { // from class: androidx.compose.foundation.lazy.LazyListState$Companion$Saver$1
        @Override // kotlin.jvm.functions.Function2
        public final List<Integer> invoke(SaverScope saverScope, LazyListState lazyListState) {
            return CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(lazyListState.getFirstVisibleItemIndex()), Integer.valueOf(lazyListState.getFirstVisibleItemScrollOffset())});
        }
    }, new Function1<List<? extends Integer>, LazyListState>() { // from class: androidx.compose.foundation.lazy.LazyListState$Companion$Saver$2
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ LazyListState invoke(List<? extends Integer> list) {
            return invoke2((List<Integer>) list);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final LazyListState invoke2(List<Integer> list) {
            return new LazyListState(list.get(0).intValue(), list.get(1).intValue());
        }
    });
    private AnimationState<Float, AnimationVector1D> _scrollDeltaBetweenPasses;
    private final LazyListAnimateScrollScope animateScrollScope;
    private final AwaitFirstLayoutModifier awaitLayoutModifier;
    private final LazyLayoutBeyondBoundsInfo beyondBoundsInfo;

    /* renamed from: canScrollBackward$delegate, reason: from kotlin metadata */
    private final MutableState canScrollBackward;

    /* renamed from: canScrollForward$delegate, reason: from kotlin metadata */
    private final MutableState canScrollForward;
    private boolean hasLookaheadPassOccurred;
    private final MutableInteractionSource internalInteractionSource;
    private final LazyLayoutItemAnimator<LazyListMeasuredItem> itemAnimator;
    private final MutableState<LazyListMeasureResult> layoutInfoState;
    private final MutableState<Unit> measurementScopeInvalidator;
    private int numMeasurePasses;
    private final LazyLayoutPinnedItemList pinnedItems;
    private final MutableState<Unit> placementScopeInvalidator;
    private LazyListMeasureResult postLookaheadLayoutInfo;
    private final LazyListPrefetchScope prefetchScope;
    private final LazyLayoutPrefetchState prefetchState;
    private final LazyListPrefetchStrategy prefetchStrategy;
    private boolean prefetchingEnabled;
    private Remeasurement remeasurement;
    private final RemeasurementModifier remeasurementModifier;
    private final LazyListScrollPosition scrollPosition;
    private float scrollToBeConsumed;
    private final ScrollableState scrollableState;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R!\u0010\u0006\u001a\f\u0012\u0004\u0012\u00020\u0005\u0012\u0002\b\u00030\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroidx/compose/foundation/lazy/LazyListState$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/lazy/LazyListState;", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "getSaver", "()Landroidx/compose/runtime/saveable/Saver;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Saver<LazyListState, ?> getSaver() {
            return LazyListState.Saver;
        }

        private Companion() {
        }
    }

    public LazyListState(final int i5, int i6, LazyListPrefetchStrategy lazyListPrefetchStrategy) {
        LazyListMeasureResult lazyListMeasureResult;
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        AnimationState<Float, AnimationVector1D> AnimationState;
        this.prefetchStrategy = lazyListPrefetchStrategy;
        LazyListScrollPosition lazyListScrollPosition = new LazyListScrollPosition(i5, i6);
        this.scrollPosition = lazyListScrollPosition;
        this.animateScrollScope = new LazyListAnimateScrollScope(this);
        lazyListMeasureResult = LazyListStateKt.EmptyLazyListMeasureResult;
        this.layoutInfoState = SnapshotStateKt.mutableStateOf(lazyListMeasureResult, SnapshotStateKt.neverEqualPolicy());
        this.internalInteractionSource = InteractionSourceKt.MutableInteractionSource();
        this.scrollableState = ScrollableStateKt.ScrollableState(new Function1<Float, Float>() { // from class: androidx.compose.foundation.lazy.LazyListState$scrollableState$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final Float invoke(float f5) {
                return Float.valueOf(-LazyListState.this.onScroll$foundation_release(-f5));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Float invoke(Float f5) {
                return invoke(f5.floatValue());
            }
        });
        this.prefetchingEnabled = true;
        this.remeasurementModifier = new RemeasurementModifier() { // from class: androidx.compose.foundation.lazy.LazyListState$remeasurementModifier$1
            @Override // androidx.compose.ui.layout.RemeasurementModifier
            public void onRemeasurementAvailable(Remeasurement remeasurement) {
                LazyListState.this.remeasurement = remeasurement;
            }
        };
        this.awaitLayoutModifier = new AwaitFirstLayoutModifier();
        this.itemAnimator = new LazyLayoutItemAnimator<>();
        this.beyondBoundsInfo = new LazyLayoutBeyondBoundsInfo();
        this.prefetchState = new LazyLayoutPrefetchState(lazyListPrefetchStrategy.getPrefetchScheduler(), new Function1<NestedPrefetchScope, Unit>() { // from class: androidx.compose.foundation.lazy.LazyListState$prefetchState$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(NestedPrefetchScope nestedPrefetchScope) {
                invoke2(nestedPrefetchScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(NestedPrefetchScope nestedPrefetchScope) {
                LazyListPrefetchStrategy lazyListPrefetchStrategy2;
                lazyListPrefetchStrategy2 = LazyListState.this.prefetchStrategy;
                int i7 = i5;
                Snapshot.Companion companion = Snapshot.INSTANCE;
                Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
                companion.restoreNonObservable(currentThreadSnapshot, companion.makeCurrentNonObservable(currentThreadSnapshot), currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null);
                lazyListPrefetchStrategy2.onNestedPrefetch(nestedPrefetchScope, i7);
            }
        });
        this.prefetchScope = new LazyListPrefetchScope() { // from class: androidx.compose.foundation.lazy.LazyListState$prefetchScope$1
            @Override // androidx.compose.foundation.lazy.LazyListPrefetchScope
            public LazyLayoutPrefetchState.PrefetchHandle schedulePrefetch(int index) {
                MutableState mutableState;
                Snapshot.Companion companion = Snapshot.INSTANCE;
                LazyListState lazyListState = LazyListState.this;
                Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
                Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                Snapshot makeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
                try {
                    mutableState = lazyListState.layoutInfoState;
                    long childConstraints = ((LazyListMeasureResult) mutableState.getValue()).getChildConstraints();
                    companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                    return LazyListState.this.getPrefetchState().m423schedulePrefetch0kLqBqw(index, childConstraints);
                } catch (Throwable th) {
                    companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                    throw th;
                }
            }
        };
        this.pinnedItems = new LazyLayoutPinnedItemList();
        lazyListScrollPosition.getNearestRangeState();
        this.measurementScopeInvalidator = ObservableScopeInvalidator.m427constructorimpl$default(null, 1, null);
        Boolean bool = Boolean.FALSE;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.canScrollForward = mutableStateOf$default;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.canScrollBackward = mutableStateOf$default2;
        this.placementScopeInvalidator = ObservableScopeInvalidator.m427constructorimpl$default(null, 1, null);
        TwoWayConverter<Float, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
        Float valueOf = Float.valueOf(0.0f);
        AnimationState = AnimationStateKt.AnimationState(vectorConverter, valueOf, valueOf, (r19 & 8) != 0 ? Long.MIN_VALUE : 0L, (r19 & 16) != 0 ? Long.MIN_VALUE : 0L, (r19 & 32) != 0 ? false : false);
        this._scrollDeltaBetweenPasses = AnimationState;
    }

    public static /* synthetic */ Object animateScrollToItem$default(LazyListState lazyListState, int i5, int i6, Continuation continuation, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            i6 = 0;
        }
        return lazyListState.animateScrollToItem(i5, i6, continuation);
    }

    public static /* synthetic */ void applyMeasureResult$foundation_release$default(LazyListState lazyListState, LazyListMeasureResult lazyListMeasureResult, boolean z5, boolean z6, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            z6 = false;
        }
        lazyListState.applyMeasureResult$foundation_release(lazyListMeasureResult, z5, z6);
    }

    private final void notifyPrefetchOnScroll(float delta, LazyListLayoutInfo layoutInfo) {
        if (this.prefetchingEnabled) {
            this.prefetchStrategy.onScroll(this.prefetchScope, delta, layoutInfo);
        }
    }

    public static /* synthetic */ Object scrollToItem$default(LazyListState lazyListState, int i5, int i6, Continuation continuation, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            i6 = 0;
        }
        return lazyListState.scrollToItem(i5, i6, continuation);
    }

    private void setCanScrollBackward(boolean z5) {
        this.canScrollBackward.setValue(Boolean.valueOf(z5));
    }

    private void setCanScrollForward(boolean z5) {
        this.canScrollForward.setValue(Boolean.valueOf(z5));
    }

    private final void updateScrollDeltaForPostLookahead(float delta, Density density, CoroutineScope coroutineScope) {
        float f5;
        f5 = LazyListStateKt.DeltaThresholdForScrollAnimation;
        if (delta <= density.mo212toPx0680j_4(f5)) {
            return;
        }
        Snapshot.Companion companion = Snapshot.INSTANCE;
        Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
        Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
        Snapshot makeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
        try {
            float floatValue = this._scrollDeltaBetweenPasses.getValue().floatValue();
            if (this._scrollDeltaBetweenPasses.getIsRunning()) {
                this._scrollDeltaBetweenPasses = AnimationStateKt.copy$default((AnimationState) this._scrollDeltaBetweenPasses, floatValue - delta, 0.0f, 0L, 0L, false, 30, (Object) null);
                BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new LazyListState$updateScrollDeltaForPostLookahead$2$1(this, null), 3, null);
            } else {
                this._scrollDeltaBetweenPasses = new AnimationState<>(VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), Float.valueOf(-delta), null, 0L, 0L, false, 60, null);
                BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new LazyListState$updateScrollDeltaForPostLookahead$2$2(this, null), 3, null);
            }
            companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
        } catch (Throwable th) {
            companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
            throw th;
        }
    }

    public final Object animateScrollToItem(int i5, int i6, Continuation<? super Unit> continuation) {
        Object animateScrollToItem = LazyAnimateScrollKt.animateScrollToItem(this.animateScrollScope, i5, i6, 100, getDensity$foundation_release(), continuation);
        return animateScrollToItem == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateScrollToItem : Unit.INSTANCE;
    }

    public final void applyMeasureResult$foundation_release(LazyListMeasureResult result, boolean isLookingAhead, boolean visibleItemsStayedTheSame) {
        if (!isLookingAhead && this.hasLookaheadPassOccurred) {
            this.postLookaheadLayoutInfo = result;
            return;
        }
        if (isLookingAhead) {
            this.hasLookaheadPassOccurred = true;
        }
        setCanScrollBackward(result.getCanScrollBackward());
        setCanScrollForward(result.getCanScrollForward());
        this.scrollToBeConsumed -= result.getConsumedScroll();
        this.layoutInfoState.setValue(result);
        if (visibleItemsStayedTheSame) {
            this.scrollPosition.updateScrollOffset(result.getFirstVisibleItemScrollOffset());
        } else {
            this.scrollPosition.updateFromMeasureResult(result);
            if (this.prefetchingEnabled) {
                this.prefetchStrategy.onVisibleItemsUpdated(this.prefetchScope, result);
            }
        }
        if (isLookingAhead) {
            updateScrollDeltaForPostLookahead(result.getScrollBackAmount(), result.getDensity(), result.getCoroutineScope());
        }
        this.numMeasurePasses++;
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public float dispatchRawDelta(float delta) {
        return this.scrollableState.dispatchRawDelta(delta);
    }

    /* renamed from: getAwaitLayoutModifier$foundation_release, reason: from getter */
    public final AwaitFirstLayoutModifier getAwaitLayoutModifier() {
        return this.awaitLayoutModifier;
    }

    /* renamed from: getBeyondBoundsInfo$foundation_release, reason: from getter */
    public final LazyLayoutBeyondBoundsInfo getBeyondBoundsInfo() {
        return this.beyondBoundsInfo;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean getCanScrollBackward() {
        return ((Boolean) this.canScrollBackward.getValue()).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean getCanScrollForward() {
        return ((Boolean) this.canScrollForward.getValue()).booleanValue();
    }

    public final Density getDensity$foundation_release() {
        return this.layoutInfoState.getValue().getDensity();
    }

    public final int getFirstVisibleItemIndex() {
        return this.scrollPosition.getIndex();
    }

    public final int getFirstVisibleItemScrollOffset() {
        return this.scrollPosition.getScrollOffset();
    }

    /* renamed from: getHasLookaheadPassOccurred$foundation_release, reason: from getter */
    public final boolean getHasLookaheadPassOccurred() {
        return this.hasLookaheadPassOccurred;
    }

    /* renamed from: getInternalInteractionSource$foundation_release, reason: from getter */
    public final MutableInteractionSource getInternalInteractionSource() {
        return this.internalInteractionSource;
    }

    public final LazyLayoutItemAnimator<LazyListMeasuredItem> getItemAnimator$foundation_release() {
        return this.itemAnimator;
    }

    public final LazyListLayoutInfo getLayoutInfo() {
        return this.layoutInfoState.getValue();
    }

    /* renamed from: getMeasurementScopeInvalidator-zYiylxw$foundation_release, reason: not valid java name */
    public final MutableState<Unit> m378getMeasurementScopeInvalidatorzYiylxw$foundation_release() {
        return this.measurementScopeInvalidator;
    }

    public final IntRange getNearestRange$foundation_release() {
        return this.scrollPosition.getNearestRangeState().getValue();
    }

    /* renamed from: getPinnedItems$foundation_release, reason: from getter */
    public final LazyLayoutPinnedItemList getPinnedItems() {
        return this.pinnedItems;
    }

    /* renamed from: getPlacementScopeInvalidator-zYiylxw$foundation_release, reason: not valid java name */
    public final MutableState<Unit> m379getPlacementScopeInvalidatorzYiylxw$foundation_release() {
        return this.placementScopeInvalidator;
    }

    /* renamed from: getPostLookaheadLayoutInfo$foundation_release, reason: from getter */
    public final LazyListMeasureResult getPostLookaheadLayoutInfo() {
        return this.postLookaheadLayoutInfo;
    }

    /* renamed from: getPrefetchState$foundation_release, reason: from getter */
    public final LazyLayoutPrefetchState getPrefetchState() {
        return this.prefetchState;
    }

    /* renamed from: getRemeasurement$foundation_release, reason: from getter */
    public final Remeasurement getRemeasurement() {
        return this.remeasurement;
    }

    /* renamed from: getRemeasurementModifier$foundation_release, reason: from getter */
    public final RemeasurementModifier getRemeasurementModifier() {
        return this.remeasurementModifier;
    }

    public final float getScrollDeltaBetweenPasses$foundation_release() {
        return this._scrollDeltaBetweenPasses.getValue().floatValue();
    }

    /* renamed from: getScrollToBeConsumed$foundation_release, reason: from getter */
    public final float getScrollToBeConsumed() {
        return this.scrollToBeConsumed;
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean isScrollInProgress() {
        return this.scrollableState.isScrollInProgress();
    }

    public final float onScroll$foundation_release(float distance) {
        if ((distance < 0.0f && !getCanScrollForward()) || (distance > 0.0f && !getCanScrollBackward())) {
            return 0.0f;
        }
        if (Math.abs(this.scrollToBeConsumed) > 0.5f) {
            throw new IllegalStateException(("entered drag with non-zero pending scroll: " + this.scrollToBeConsumed).toString());
        }
        float f5 = this.scrollToBeConsumed + distance;
        this.scrollToBeConsumed = f5;
        if (Math.abs(f5) > 0.5f) {
            LazyListMeasureResult value = this.layoutInfoState.getValue();
            float f6 = this.scrollToBeConsumed;
            int round = Math.round(f6);
            LazyListMeasureResult lazyListMeasureResult = this.postLookaheadLayoutInfo;
            boolean tryToApplyScrollWithoutRemeasure = value.tryToApplyScrollWithoutRemeasure(round, !this.hasLookaheadPassOccurred);
            if (tryToApplyScrollWithoutRemeasure && lazyListMeasureResult != null) {
                tryToApplyScrollWithoutRemeasure = lazyListMeasureResult.tryToApplyScrollWithoutRemeasure(round, true);
            }
            if (tryToApplyScrollWithoutRemeasure) {
                applyMeasureResult$foundation_release(value, this.hasLookaheadPassOccurred, true);
                ObservableScopeInvalidator.m428invalidateScopeimpl(this.placementScopeInvalidator);
                notifyPrefetchOnScroll(f6 - this.scrollToBeConsumed, value);
            } else {
                Remeasurement remeasurement = this.remeasurement;
                if (remeasurement != null) {
                    remeasurement.forceRemeasure();
                }
                notifyPrefetchOnScroll(f6 - this.scrollToBeConsumed, getLayoutInfo());
            }
        }
        if (Math.abs(this.scrollToBeConsumed) <= 0.5f) {
            return distance;
        }
        float f7 = distance - this.scrollToBeConsumed;
        this.scrollToBeConsumed = 0.0f;
        return f7;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x006b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // androidx.compose.foundation.gestures.ScrollableState
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object scroll(MutatePriority mutatePriority, Function2<? super ScrollScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        LazyListState$scroll$1 lazyListState$scroll$1;
        Object coroutine_suspended;
        int i5;
        LazyListState lazyListState;
        ScrollableState scrollableState;
        if (continuation instanceof LazyListState$scroll$1) {
            lazyListState$scroll$1 = (LazyListState$scroll$1) continuation;
            int i6 = lazyListState$scroll$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                lazyListState$scroll$1.label = i6 - Integer.MIN_VALUE;
                Object obj = lazyListState$scroll$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = lazyListState$scroll$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    AwaitFirstLayoutModifier awaitFirstLayoutModifier = this.awaitLayoutModifier;
                    lazyListState$scroll$1.L$0 = this;
                    lazyListState$scroll$1.L$1 = mutatePriority;
                    lazyListState$scroll$1.L$2 = function2;
                    lazyListState$scroll$1.label = 1;
                    if (awaitFirstLayoutModifier.waitForFirstLayout(lazyListState$scroll$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    lazyListState = this;
                } else {
                    if (i5 != 1) {
                        if (i5 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    function2 = (Function2) lazyListState$scroll$1.L$2;
                    mutatePriority = (MutatePriority) lazyListState$scroll$1.L$1;
                    lazyListState = (LazyListState) lazyListState$scroll$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                scrollableState = lazyListState.scrollableState;
                lazyListState$scroll$1.L$0 = null;
                lazyListState$scroll$1.L$1 = null;
                lazyListState$scroll$1.L$2 = null;
                lazyListState$scroll$1.label = 2;
                if (scrollableState.scroll(mutatePriority, function2, lazyListState$scroll$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
        }
        lazyListState$scroll$1 = new LazyListState$scroll$1(this, continuation);
        Object obj2 = lazyListState$scroll$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = lazyListState$scroll$1.label;
        if (i5 != 0) {
        }
        scrollableState = lazyListState.scrollableState;
        lazyListState$scroll$1.L$0 = null;
        lazyListState$scroll$1.L$1 = null;
        lazyListState$scroll$1.L$2 = null;
        lazyListState$scroll$1.label = 2;
        if (scrollableState.scroll(mutatePriority, function2, lazyListState$scroll$1) == coroutine_suspended) {
        }
        return Unit.INSTANCE;
    }

    public final Object scrollToItem(int i5, int i6, Continuation<? super Unit> continuation) {
        Object scroll$default = ScrollableState.scroll$default(this, null, new LazyListState$scrollToItem$2(this, i5, i6, null), continuation, 1, null);
        return scroll$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? scroll$default : Unit.INSTANCE;
    }

    public final void snapToItemIndexInternal$foundation_release(int index, int scrollOffset, boolean forceRemeasure) {
        if (this.scrollPosition.getIndex() != index || this.scrollPosition.getScrollOffset() != scrollOffset) {
            this.itemAnimator.reset();
        }
        this.scrollPosition.requestPositionAndForgetLastKnownKey(index, scrollOffset);
        if (!forceRemeasure) {
            ObservableScopeInvalidator.m428invalidateScopeimpl(this.measurementScopeInvalidator);
            return;
        }
        Remeasurement remeasurement = this.remeasurement;
        if (remeasurement != null) {
            remeasurement.forceRemeasure();
        }
    }

    public final int updateScrollPositionIfTheFirstItemWasMoved$foundation_release(LazyListItemProvider itemProvider, int firstItemIndex) {
        return this.scrollPosition.updateScrollPositionIfTheFirstItemWasMoved(itemProvider, firstItemIndex);
    }

    public /* synthetic */ LazyListState(int i5, int i6, int i7, DefaultConstructorMarker defaultConstructorMarker) {
        this((i7 & 1) != 0 ? 0 : i5, (i7 & 2) != 0 ? 0 : i6);
    }

    public LazyListState(int i5, int i6) {
        this(i5, i6, LazyListPrefetchStrategyKt.LazyListPrefetchStrategy$default(0, 1, null));
    }
}
