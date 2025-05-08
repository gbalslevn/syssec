package androidx.compose.foundation.pager;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.gestures.ScrollableStateKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier;
import androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo;
import androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.foundation.lazy.layout.PrefetchScheduler;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.Remeasurement;
import androidx.compose.ui.layout.RemeasurementModifier;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\t\b'\u0018\u00002\u00020\u0001B)\b\u0000\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0003\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tB\u001d\b\u0016\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0003\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\nJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eH\u0082@¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u0002*\u00020\u0002H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b!\u0010\"J\"\u0010%\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u00022\b\b\u0003\u0010$\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b%\u0010&J\u001b\u0010)\u001a\u00020\u000e*\u00020'2\u0006\u0010(\u001a\u00020\u0002H\u0007¢\u0006\u0004\b)\u0010*J'\u0010/\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u0018H\u0000¢\u0006\u0004\b-\u0010.J2\u00102\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u00022\b\b\u0003\u0010$\u001a\u00020\u00042\u000e\b\u0002\u00101\u001a\b\u0012\u0004\u0012\u00020\u000400H\u0086@¢\u0006\u0004\b2\u00103J<\u0010:\u001a\u00020\u000e2\u0006\u00105\u001a\u0002042\"\u00109\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020'\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e07\u0012\u0006\u0012\u0004\u0018\u00010806H\u0096@¢\u0006\u0004\b:\u0010;J\u0017\u0010<\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b<\u0010\rJ!\u0010@\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010=\u001a\u00020\u0018H\u0000¢\u0006\u0004\b>\u0010?J!\u0010E\u001a\u00020\u00022\u0006\u0010B\u001a\u00020A2\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\bC\u0010DR1\u0010N\u001a\u00020F2\u0006\u0010G\u001a\u00020F8@@@X\u0080\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u0014\u0010P\u001a\u00020O8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u0010QR\u0014\u0010S\u001a\u00020R8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bS\u0010TR$\u0010U\u001a\u00020\u00022\u0006\u0010G\u001a\u00020\u00028\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\bU\u0010V\u001a\u0004\bW\u0010XR$\u0010Y\u001a\u00020\u00022\u0006\u0010G\u001a\u00020\u00028\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\bY\u0010V\u001a\u0004\bZ\u0010XR\u0016\u0010\\\u001a\u00020[8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010^\u001a\u00020[8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010]R\u0016\u0010_\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010a\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010`R\u0014\u0010b\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bb\u0010cR$\u0010d\u001a\u00020\u00022\u0006\u0010G\u001a\u00020\u00028\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\bd\u0010V\u001a\u0004\be\u0010XR\u0016\u0010f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010VR\"\u0010g\u001a\u00020\u00188\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bg\u0010h\u001a\u0004\bi\u0010\u001c\"\u0004\bj\u0010kR\u0016\u0010l\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bl\u0010VR\u0018\u0010n\u001a\u0004\u0018\u00010m8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bn\u0010oR\u0016\u0010p\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010hR\u001c\u0010r\u001a\b\u0012\u0004\u0012\u00020\u00110q8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\br\u0010IR\"\u0010t\u001a\u00020s8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bt\u0010u\u001a\u0004\bv\u0010w\"\u0004\bx\u0010yR\u001a\u0010{\u001a\u00020z8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b{\u0010|\u001a\u0004\b}\u0010~R0\u0010\u0084\u0001\u001a\u00020\u00022\u0006\u0010G\u001a\u00020\u00028B@BX\u0082\u008e\u0002¢\u0006\u0016\n\u0005\b\u007f\u0010\u0080\u0001\u001a\u0005\b\u0081\u0001\u0010X\"\u0006\b\u0082\u0001\u0010\u0083\u0001R1\u0010\u0088\u0001\u001a\u00020\u00022\u0006\u0010G\u001a\u00020\u00028B@BX\u0082\u008e\u0002¢\u0006\u0017\n\u0006\b\u0085\u0001\u0010\u0080\u0001\u001a\u0005\b\u0086\u0001\u0010X\"\u0006\b\u0087\u0001\u0010\u0083\u0001R\u001f\u0010\u008c\u0001\u001a\u00020\u00028FX\u0086\u0084\u0002¢\u0006\u000f\n\u0006\b\u0089\u0001\u0010\u008a\u0001\u001a\u0005\b\u008b\u0001\u0010XR\u001e\u0010(\u001a\u00020\u00028FX\u0086\u0084\u0002¢\u0006\u000f\n\u0006\b\u008d\u0001\u0010\u008a\u0001\u001a\u0005\b\u008e\u0001\u0010XR \u0010\u0090\u0001\u001a\u00030\u008f\u00018\u0000X\u0080\u0004¢\u0006\u0010\n\u0006\b\u0090\u0001\u0010\u0091\u0001\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001R \u0010\u0095\u0001\u001a\u00030\u0094\u00018\u0000X\u0080\u0004¢\u0006\u0010\n\u0006\b\u0095\u0001\u0010\u0096\u0001\u001a\u0006\b\u0097\u0001\u0010\u0098\u0001R \u0010\u009a\u0001\u001a\u00030\u0099\u00018\u0000X\u0080\u0004¢\u0006\u0010\n\u0006\b\u009a\u0001\u0010\u009b\u0001\u001a\u0006\b\u009c\u0001\u0010\u009d\u0001R7\u0010¤\u0001\u001a\u0005\u0018\u00010\u009e\u00012\t\u0010G\u001a\u0005\u0018\u00010\u009e\u00018@@BX\u0080\u008e\u0002¢\u0006\u0017\n\u0005\b\u009f\u0001\u0010I\u001a\u0006\b \u0001\u0010¡\u0001\"\u0006\b¢\u0001\u0010£\u0001R \u0010¦\u0001\u001a\u00030¥\u00018\u0000X\u0080\u0004¢\u0006\u0010\n\u0006\b¦\u0001\u0010§\u0001\u001a\u0006\b¨\u0001\u0010©\u0001R-\u0010«\u0001\u001a\u00030ª\u00018\u0000@\u0000X\u0080\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0015\n\u0005\b«\u0001\u0010]\u001a\u0005\b¬\u0001\u0010K\"\u0005\b\u00ad\u0001\u0010MR \u0010¯\u0001\u001a\u00030®\u00018\u0000X\u0080\u0004¢\u0006\u0010\n\u0006\b¯\u0001\u0010°\u0001\u001a\u0006\b±\u0001\u0010²\u0001R%\u0010´\u0001\u001a\u00030³\u00018\u0000X\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u000f\n\u0005\b´\u0001\u0010I\u001a\u0006\bµ\u0001\u0010¶\u0001R%\u0010·\u0001\u001a\u00030³\u00018\u0000X\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u000f\n\u0005\b·\u0001\u0010I\u001a\u0006\b¸\u0001\u0010¶\u0001R/\u0010¼\u0001\u001a\u00020\u00182\u0006\u0010G\u001a\u00020\u00188F@BX\u0086\u008e\u0002¢\u0006\u0015\n\u0005\b¹\u0001\u0010I\u001a\u0005\bº\u0001\u0010\u001c\"\u0005\b»\u0001\u0010kR/\u0010À\u0001\u001a\u00020\u00182\u0006\u0010G\u001a\u00020\u00188F@BX\u0086\u008e\u0002¢\u0006\u0015\n\u0005\b½\u0001\u0010I\u001a\u0005\b¾\u0001\u0010\u001c\"\u0005\b¿\u0001\u0010kR\u001c\u0010Á\u0001\u001a\b\u0012\u0004\u0012\u00020\u00180q8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bÁ\u0001\u0010IR\u001c\u0010Â\u0001\u001a\b\u0012\u0004\u0012\u00020\u00180q8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bÂ\u0001\u0010IR\u0016\u0010Ä\u0001\u001a\u00020\u00028&X¦\u0004¢\u0006\u0007\u001a\u0005\bÃ\u0001\u0010XR\u0014\u0010Ç\u0001\u001a\u00020\u001d8F¢\u0006\b\u001a\u0006\bÅ\u0001\u0010Æ\u0001R\u0016\u0010É\u0001\u001a\u00020\u00028@X\u0080\u0004¢\u0006\u0007\u001a\u0005\bÈ\u0001\u0010XR\u0016\u0010Ë\u0001\u001a\u00020\u00028@X\u0080\u0004¢\u0006\u0007\u001a\u0005\bÊ\u0001\u0010XR\u0016\u0010Í\u0001\u001a\u00020\u00028@X\u0080\u0004¢\u0006\u0007\u001a\u0005\bÌ\u0001\u0010XR\u0017\u0010Ð\u0001\u001a\u00020\u00048@X\u0080\u0004¢\u0006\b\u001a\u0006\bÎ\u0001\u0010Ï\u0001R\u0012\u0010\u0003\u001a\u00020\u00028F¢\u0006\u0007\u001a\u0005\bÑ\u0001\u0010XR\u0013\u0010\u0005\u001a\u00020\u00048F¢\u0006\b\u001a\u0006\bÒ\u0001\u0010Ï\u0001R!\u0010Ø\u0001\u001a\u00030Ó\u00018@X\u0080\u0084\u0002¢\u0006\u0010\u001a\u0006\bÔ\u0001\u0010Õ\u0001*\u0006\bÖ\u0001\u0010×\u0001R\u0016\u0010Ù\u0001\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bÙ\u0001\u0010\u001cR\u0016\u0010Û\u0001\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bÚ\u0001\u0010\u001c\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006Ü\u0001"}, d2 = {"Landroidx/compose/foundation/pager/PagerState;", "Landroidx/compose/foundation/gestures/ScrollableState;", BuildConfig.FLAVOR, "currentPage", BuildConfig.FLAVOR, "currentPageOffsetFraction", "Landroidx/compose/foundation/lazy/layout/PrefetchScheduler;", "prefetchScheduler", "<init>", "(IFLandroidx/compose/foundation/lazy/layout/PrefetchScheduler;)V", "(IF)V", "delta", "performScroll", "(F)F", BuildConfig.FLAVOR, "awaitScrollDependencies", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/compose/foundation/pager/PagerMeasureResult;", "result", "tryRunPrefetch", "(Landroidx/compose/foundation/pager/PagerMeasureResult;)V", "coerceInPageRange", "(I)I", "scrollDelta", BuildConfig.FLAVOR, "isGestureActionMatchesScroll", "(F)Z", "isNotGestureAction", "()Z", "Landroidx/compose/foundation/pager/PagerLayoutInfo;", "info", "notifyPrefetch", "(FLandroidx/compose/foundation/pager/PagerLayoutInfo;)V", "cancelPrefetchIfVisibleItemsChanged", "(Landroidx/compose/foundation/pager/PagerLayoutInfo;)V", "page", "pageOffsetFraction", "scrollToPage", "(IFLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/compose/foundation/gestures/ScrollScope;", "targetPage", "updateTargetPage", "(Landroidx/compose/foundation/gestures/ScrollScope;I)V", "offsetFraction", "forceRemeasure", "snapToItem$foundation_release", "(IFZ)V", "snapToItem", "Landroidx/compose/animation/core/AnimationSpec;", "animationSpec", "animateScrollToPage", "(IFLandroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/compose/foundation/MutatePriority;", "scrollPriority", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", BuildConfig.FLAVOR, "block", "scroll", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatchRawDelta", "visibleItemsStayedTheSame", "applyMeasureResult$foundation_release", "(Landroidx/compose/foundation/pager/PagerMeasureResult;Z)V", "applyMeasureResult", "Landroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;", "itemProvider", "matchScrollPositionWithKey$foundation_release", "(Landroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;I)I", "matchScrollPositionWithKey", "Landroidx/compose/ui/geometry/Offset;", "<set-?>", "upDownDifference$delegate", "Landroidx/compose/runtime/MutableState;", "getUpDownDifference-F1C5BW0$foundation_release", "()J", "setUpDownDifference-k-4lQ0M$foundation_release", "(J)V", "upDownDifference", "Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimateScrollScope;", "animatedScrollScope", "Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimateScrollScope;", "Landroidx/compose/foundation/pager/PagerScrollPosition;", "scrollPosition", "Landroidx/compose/foundation/pager/PagerScrollPosition;", "firstVisiblePage", "I", "getFirstVisiblePage$foundation_release", "()I", "firstVisiblePageOffset", "getFirstVisiblePageOffset$foundation_release", BuildConfig.FLAVOR, "maxScrollOffset", "J", "minScrollOffset", "accumulator", "F", "previousPassDelta", "scrollableState", "Landroidx/compose/foundation/gestures/ScrollableState;", "layoutWithMeasurement", "getLayoutWithMeasurement$foundation_release", "layoutWithoutMeasurement", "prefetchingEnabled", "Z", "getPrefetchingEnabled$foundation_release", "setPrefetchingEnabled$foundation_release", "(Z)V", "indexToPrefetch", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "currentPrefetchHandle", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "wasPrefetchingForward", "Landroidx/compose/runtime/MutableState;", "pagerLayoutInfoState", "Landroidx/compose/ui/unit/Density;", "density", "Landroidx/compose/ui/unit/Density;", "getDensity$foundation_release", "()Landroidx/compose/ui/unit/Density;", "setDensity$foundation_release", "(Landroidx/compose/ui/unit/Density;)V", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "internalInteractionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "getInternalInteractionSource$foundation_release", "()Landroidx/compose/foundation/interaction/MutableInteractionSource;", "programmaticScrollTargetPage$delegate", "Landroidx/compose/runtime/MutableIntState;", "getProgrammaticScrollTargetPage", "setProgrammaticScrollTargetPage", "(I)V", "programmaticScrollTargetPage", "settledPageState$delegate", "getSettledPageState", "setSettledPageState", "settledPageState", "settledPage$delegate", "Landroidx/compose/runtime/State;", "getSettledPage", "settledPage", "targetPage$delegate", "getTargetPage", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "prefetchState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "getPrefetchState$foundation_release", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;", "beyondBoundsInfo", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;", "getBeyondBoundsInfo$foundation_release", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;", "Landroidx/compose/foundation/lazy/layout/AwaitFirstLayoutModifier;", "awaitLayoutModifier", "Landroidx/compose/foundation/lazy/layout/AwaitFirstLayoutModifier;", "getAwaitLayoutModifier$foundation_release", "()Landroidx/compose/foundation/lazy/layout/AwaitFirstLayoutModifier;", "Landroidx/compose/ui/layout/Remeasurement;", "remeasurement$delegate", "getRemeasurement$foundation_release", "()Landroidx/compose/ui/layout/Remeasurement;", "setRemeasurement", "(Landroidx/compose/ui/layout/Remeasurement;)V", "remeasurement", "Landroidx/compose/ui/layout/RemeasurementModifier;", "remeasurementModifier", "Landroidx/compose/ui/layout/RemeasurementModifier;", "getRemeasurementModifier$foundation_release", "()Landroidx/compose/ui/layout/RemeasurementModifier;", "Landroidx/compose/ui/unit/Constraints;", "premeasureConstraints", "getPremeasureConstraints-msEJaDk$foundation_release", "setPremeasureConstraints-BRTryo0$foundation_release", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList;", "pinnedPages", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList;", "getPinnedPages$foundation_release", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList;", "Landroidx/compose/foundation/lazy/layout/ObservableScopeInvalidator;", "placementScopeInvalidator", "getPlacementScopeInvalidator-zYiylxw$foundation_release", "()Landroidx/compose/runtime/MutableState;", "measurementScopeInvalidator", "getMeasurementScopeInvalidator-zYiylxw$foundation_release", "canScrollForward$delegate", "getCanScrollForward", "setCanScrollForward", "canScrollForward", "canScrollBackward$delegate", "getCanScrollBackward", "setCanScrollBackward", "canScrollBackward", "isLastScrollForwardState", "isLastScrollBackwardState", "getPageCount", "pageCount", "getLayoutInfo", "()Landroidx/compose/foundation/pager/PagerLayoutInfo;", "layoutInfo", "getPageSpacing$foundation_release", "pageSpacing", "getPageSize$foundation_release", "pageSize", "getPageSizeWithSpacing$foundation_release", "pageSizeWithSpacing", "getPositionThresholdFraction$foundation_release", "()F", "positionThresholdFraction", "getCurrentPage", "getCurrentPageOffsetFraction", "Lkotlin/ranges/IntRange;", "getNearestRange$foundation_release", "()Lkotlin/ranges/IntRange;", "getNearestRange$foundation_release$delegate", "(Landroidx/compose/foundation/pager/PagerState;)Ljava/lang/Object;", "nearestRange", "isScrollInProgress", "getLastScrolledForward", "lastScrolledForward", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class PagerState implements ScrollableState {
    private float accumulator;
    private final LazyLayoutAnimateScrollScope animatedScrollScope;
    private final AwaitFirstLayoutModifier awaitLayoutModifier;
    private final LazyLayoutBeyondBoundsInfo beyondBoundsInfo;

    /* renamed from: canScrollBackward$delegate, reason: from kotlin metadata */
    private final MutableState canScrollBackward;

    /* renamed from: canScrollForward$delegate, reason: from kotlin metadata */
    private final MutableState canScrollForward;
    private LazyLayoutPrefetchState.PrefetchHandle currentPrefetchHandle;
    private Density density;
    private int firstVisiblePage;
    private int firstVisiblePageOffset;
    private int indexToPrefetch;
    private final MutableInteractionSource internalInteractionSource;
    private final MutableState<Boolean> isLastScrollBackwardState;
    private final MutableState<Boolean> isLastScrollForwardState;
    private int layoutWithMeasurement;
    private int layoutWithoutMeasurement;
    private long maxScrollOffset;
    private final MutableState<Unit> measurementScopeInvalidator;
    private long minScrollOffset;
    private MutableState<PagerMeasureResult> pagerLayoutInfoState;
    private final LazyLayoutPinnedItemList pinnedPages;
    private final MutableState<Unit> placementScopeInvalidator;
    private final LazyLayoutPrefetchState prefetchState;
    private boolean prefetchingEnabled;
    private long premeasureConstraints;
    private float previousPassDelta;

    /* renamed from: programmaticScrollTargetPage$delegate, reason: from kotlin metadata */
    private final MutableIntState programmaticScrollTargetPage;

    /* renamed from: remeasurement$delegate, reason: from kotlin metadata */
    private final MutableState remeasurement;
    private final RemeasurementModifier remeasurementModifier;
    private final PagerScrollPosition scrollPosition;
    private final ScrollableState scrollableState;

    /* renamed from: settledPage$delegate, reason: from kotlin metadata */
    private final State settledPage;

    /* renamed from: settledPageState$delegate, reason: from kotlin metadata */
    private final MutableIntState settledPageState;

    /* renamed from: targetPage$delegate, reason: from kotlin metadata */
    private final State targetPage;

    /* renamed from: upDownDifference$delegate, reason: from kotlin metadata */
    private final MutableState upDownDifference;
    private boolean wasPrefetchingForward;

    public PagerState(int i5, float f5, PrefetchScheduler prefetchScheduler) {
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        MutableState mutableStateOf$default3;
        MutableState mutableStateOf$default4;
        MutableState<Boolean> mutableStateOf$default5;
        MutableState<Boolean> mutableStateOf$default6;
        double d5 = f5;
        if (-0.5d <= d5 && d5 <= 0.5d) {
            mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Offset.m1328boximpl(Offset.INSTANCE.m1349getZeroF1C5BW0()), null, 2, null);
            this.upDownDifference = mutableStateOf$default;
            this.animatedScrollScope = PagerLazyAnimateScrollScopeKt.PagerLazyAnimateScrollScope(this);
            PagerScrollPosition pagerScrollPosition = new PagerScrollPosition(i5, f5, this);
            this.scrollPosition = pagerScrollPosition;
            this.firstVisiblePage = i5;
            this.maxScrollOffset = Long.MAX_VALUE;
            this.scrollableState = ScrollableStateKt.ScrollableState(new Function1<Float, Float>() { // from class: androidx.compose.foundation.pager.PagerState$scrollableState$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                public final Float invoke(float f6) {
                    float performScroll;
                    performScroll = PagerState.this.performScroll(f6);
                    return Float.valueOf(performScroll);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Float invoke(Float f6) {
                    return invoke(f6.floatValue());
                }
            });
            this.prefetchingEnabled = true;
            this.indexToPrefetch = -1;
            this.pagerLayoutInfoState = SnapshotStateKt.mutableStateOf(PagerStateKt.getEmptyLayoutInfo(), SnapshotStateKt.neverEqualPolicy());
            this.density = PagerStateKt.access$getUnitDensity$p();
            this.internalInteractionSource = InteractionSourceKt.MutableInteractionSource();
            this.programmaticScrollTargetPage = SnapshotIntStateKt.mutableIntStateOf(-1);
            this.settledPageState = SnapshotIntStateKt.mutableIntStateOf(i5);
            this.settledPage = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new Function0<Integer>() { // from class: androidx.compose.foundation.pager.PagerState$settledPage$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Integer invoke() {
                    int currentPage;
                    if (PagerState.this.isScrollInProgress()) {
                        currentPage = PagerState.this.getSettledPageState();
                    } else {
                        currentPage = PagerState.this.getCurrentPage();
                    }
                    return Integer.valueOf(currentPage);
                }
            });
            this.targetPage = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new Function0<Integer>() { // from class: androidx.compose.foundation.pager.PagerState$targetPage$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Integer invoke() {
                    int programmaticScrollTargetPage;
                    int currentPage;
                    int coerceInPageRange;
                    if (!PagerState.this.isScrollInProgress()) {
                        currentPage = PagerState.this.getCurrentPage();
                    } else {
                        programmaticScrollTargetPage = PagerState.this.getProgrammaticScrollTargetPage();
                        if (programmaticScrollTargetPage != -1) {
                            currentPage = PagerState.this.getProgrammaticScrollTargetPage();
                        } else if (Math.abs(PagerState.this.getCurrentPageOffsetFraction()) >= Math.abs(PagerState.this.getPositionThresholdFraction$foundation_release())) {
                            if (PagerState.this.getLastScrolledForward()) {
                                currentPage = PagerState.this.getFirstVisiblePage() + 1;
                            } else {
                                currentPage = PagerState.this.getFirstVisiblePage();
                            }
                        } else {
                            currentPage = PagerState.this.getCurrentPage();
                        }
                    }
                    coerceInPageRange = PagerState.this.coerceInPageRange(currentPage);
                    return Integer.valueOf(coerceInPageRange);
                }
            });
            this.prefetchState = new LazyLayoutPrefetchState(prefetchScheduler, null, 2, null);
            this.beyondBoundsInfo = new LazyLayoutBeyondBoundsInfo();
            this.awaitLayoutModifier = new AwaitFirstLayoutModifier();
            mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
            this.remeasurement = mutableStateOf$default2;
            this.remeasurementModifier = new RemeasurementModifier() { // from class: androidx.compose.foundation.pager.PagerState$remeasurementModifier$1
                @Override // androidx.compose.ui.layout.RemeasurementModifier
                public void onRemeasurementAvailable(Remeasurement remeasurement) {
                    PagerState.this.setRemeasurement(remeasurement);
                }
            };
            this.premeasureConstraints = ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null);
            this.pinnedPages = new LazyLayoutPinnedItemList();
            pagerScrollPosition.getNearestRangeState();
            this.placementScopeInvalidator = ObservableScopeInvalidator.m427constructorimpl$default(null, 1, null);
            this.measurementScopeInvalidator = ObservableScopeInvalidator.m427constructorimpl$default(null, 1, null);
            Boolean bool = Boolean.FALSE;
            mutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
            this.canScrollForward = mutableStateOf$default3;
            mutableStateOf$default4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
            this.canScrollBackward = mutableStateOf$default4;
            mutableStateOf$default5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
            this.isLastScrollForwardState = mutableStateOf$default5;
            mutableStateOf$default6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
            this.isLastScrollBackwardState = mutableStateOf$default6;
            return;
        }
        throw new IllegalArgumentException(("currentPageOffsetFraction " + f5 + " is not within the range -0.5 to 0.5").toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object animateScrollToPage$default(PagerState pagerState, int i5, float f5, AnimationSpec animationSpec, Continuation continuation, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: animateScrollToPage");
        }
        if ((i6 & 2) != 0) {
            f5 = 0.0f;
        }
        if ((i6 & 4) != 0) {
            animationSpec = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
        }
        return pagerState.animateScrollToPage(i5, f5, animationSpec, continuation);
    }

    public static /* synthetic */ void applyMeasureResult$foundation_release$default(PagerState pagerState, PagerMeasureResult pagerMeasureResult, boolean z5, int i5, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: applyMeasureResult");
        }
        if ((i5 & 2) != 0) {
            z5 = false;
        }
        pagerState.applyMeasureResult$foundation_release(pagerMeasureResult, z5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object awaitScrollDependencies(Continuation<? super Unit> continuation) {
        Object waitForFirstLayout = this.awaitLayoutModifier.waitForFirstLayout(continuation);
        return waitForFirstLayout == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? waitForFirstLayout : Unit.INSTANCE;
    }

    private final void cancelPrefetchIfVisibleItemsChanged(PagerLayoutInfo info) {
        if (this.indexToPrefetch == -1 || info.getVisiblePagesInfo().isEmpty()) {
            return;
        }
        if (this.indexToPrefetch != (this.wasPrefetchingForward ? ((PageInfo) CollectionsKt.last((List) info.getVisiblePagesInfo())).getIndex() + info.getBeyondViewportPageCount() + 1 : (((PageInfo) CollectionsKt.first((List) info.getVisiblePagesInfo())).getIndex() - info.getBeyondViewportPageCount()) - 1)) {
            this.indexToPrefetch = -1;
            LazyLayoutPrefetchState.PrefetchHandle prefetchHandle = this.currentPrefetchHandle;
            if (prefetchHandle != null) {
                prefetchHandle.cancel();
            }
            this.currentPrefetchHandle = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int coerceInPageRange(int i5) {
        if (getPageCount() > 0) {
            return RangesKt.coerceIn(i5, 0, getPageCount() - 1);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getProgrammaticScrollTargetPage() {
        return this.programmaticScrollTargetPage.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getSettledPageState() {
        return this.settledPageState.getIntValue();
    }

    private final boolean isGestureActionMatchesScroll(float scrollDelta) {
        if (getLayoutInfo().getOrientation() != Orientation.Vertical ? Math.signum(scrollDelta) != Math.signum(-Offset.m1337getXimpl(m447getUpDownDifferenceF1C5BW0$foundation_release())) : Math.signum(scrollDelta) != Math.signum(-Offset.m1338getYimpl(m447getUpDownDifferenceF1C5BW0$foundation_release()))) {
            if (!isNotGestureAction()) {
                return false;
            }
        }
        return true;
    }

    private final boolean isNotGestureAction() {
        return ((int) Offset.m1337getXimpl(m447getUpDownDifferenceF1C5BW0$foundation_release())) == 0 && ((int) Offset.m1338getYimpl(m447getUpDownDifferenceF1C5BW0$foundation_release())) == 0;
    }

    private final void notifyPrefetch(float delta, PagerLayoutInfo info) {
        LazyLayoutPrefetchState.PrefetchHandle prefetchHandle;
        LazyLayoutPrefetchState.PrefetchHandle prefetchHandle2;
        LazyLayoutPrefetchState.PrefetchHandle prefetchHandle3;
        if (this.prefetchingEnabled && !info.getVisiblePagesInfo().isEmpty()) {
            boolean z5 = delta > 0.0f;
            int index = z5 ? ((PageInfo) CollectionsKt.last((List) info.getVisiblePagesInfo())).getIndex() + info.getBeyondViewportPageCount() + 1 : (((PageInfo) CollectionsKt.first((List) info.getVisiblePagesInfo())).getIndex() - info.getBeyondViewportPageCount()) - 1;
            if (index < 0 || index >= getPageCount()) {
                return;
            }
            if (index != this.indexToPrefetch) {
                if (this.wasPrefetchingForward != z5 && (prefetchHandle3 = this.currentPrefetchHandle) != null) {
                    prefetchHandle3.cancel();
                }
                this.wasPrefetchingForward = z5;
                this.indexToPrefetch = index;
                this.currentPrefetchHandle = this.prefetchState.m423schedulePrefetch0kLqBqw(index, this.premeasureConstraints);
            }
            if (z5) {
                if ((((PageInfo) CollectionsKt.last((List) info.getVisiblePagesInfo())).getOffset() + (info.getPageSize() + info.getPageSpacing())) - info.getViewportEndOffset() >= delta || (prefetchHandle2 = this.currentPrefetchHandle) == null) {
                    return;
                }
                prefetchHandle2.markAsUrgent();
                return;
            }
            if (info.getViewportStartOffset() - ((PageInfo) CollectionsKt.first((List) info.getVisiblePagesInfo())).getOffset() >= (-delta) || (prefetchHandle = this.currentPrefetchHandle) == null) {
                return;
            }
            prefetchHandle.markAsUrgent();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float performScroll(float delta) {
        long currentAbsoluteScrollOffset = PagerScrollPositionKt.currentAbsoluteScrollOffset(this);
        float f5 = this.accumulator + delta;
        long roundToLong = MathKt.roundToLong(f5);
        this.accumulator = f5 - ((float) roundToLong);
        if (Math.abs(delta) < 1.0E-4f) {
            return delta;
        }
        long j5 = roundToLong + currentAbsoluteScrollOffset;
        long coerceIn = RangesKt.coerceIn(j5, this.minScrollOffset, this.maxScrollOffset);
        boolean z5 = j5 != coerceIn;
        long j6 = coerceIn - currentAbsoluteScrollOffset;
        float f6 = (float) j6;
        this.previousPassDelta = f6;
        if (Math.abs(j6) != 0) {
            this.isLastScrollForwardState.setValue(Boolean.valueOf(f6 > 0.0f));
            this.isLastScrollBackwardState.setValue(Boolean.valueOf(f6 < 0.0f));
        }
        PagerMeasureResult value = this.pagerLayoutInfoState.getValue();
        int i5 = (int) j6;
        if (value.tryToApplyScrollWithoutRemeasure(-i5)) {
            applyMeasureResult$foundation_release(value, true);
            ObservableScopeInvalidator.m428invalidateScopeimpl(this.placementScopeInvalidator);
            this.layoutWithoutMeasurement++;
        } else {
            this.scrollPosition.applyScrollDelta(i5);
            Remeasurement remeasurement$foundation_release = getRemeasurement$foundation_release();
            if (remeasurement$foundation_release != null) {
                remeasurement$foundation_release.forceRemeasure();
            }
            this.layoutWithMeasurement++;
        }
        return (z5 ? Long.valueOf(j6) : Float.valueOf(delta)).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ Object scroll$suspendImpl(PagerState pagerState, MutatePriority mutatePriority, Function2<? super ScrollScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        PagerState$scroll$1 pagerState$scroll$1;
        Object coroutine_suspended;
        int i5;
        ScrollableState scrollableState;
        if (continuation instanceof PagerState$scroll$1) {
            pagerState$scroll$1 = (PagerState$scroll$1) continuation;
            int i6 = pagerState$scroll$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                pagerState$scroll$1.label = i6 - Integer.MIN_VALUE;
                Object obj = pagerState$scroll$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = pagerState$scroll$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    pagerState$scroll$1.L$0 = pagerState;
                    pagerState$scroll$1.L$1 = mutatePriority;
                    pagerState$scroll$1.L$2 = function2;
                    pagerState$scroll$1.label = 1;
                    if (pagerState.awaitScrollDependencies(pagerState$scroll$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i5 != 1) {
                        if (i5 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        pagerState = (PagerState) pagerState$scroll$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        pagerState.setProgrammaticScrollTargetPage(-1);
                        return Unit.INSTANCE;
                    }
                    function2 = (Function2) pagerState$scroll$1.L$2;
                    mutatePriority = (MutatePriority) pagerState$scroll$1.L$1;
                    pagerState = (PagerState) pagerState$scroll$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                if (!pagerState.isScrollInProgress()) {
                    pagerState.setSettledPageState(pagerState.getCurrentPage());
                }
                scrollableState = pagerState.scrollableState;
                pagerState$scroll$1.L$0 = pagerState;
                pagerState$scroll$1.L$1 = null;
                pagerState$scroll$1.L$2 = null;
                pagerState$scroll$1.label = 2;
                if (scrollableState.scroll(mutatePriority, function2, pagerState$scroll$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                pagerState.setProgrammaticScrollTargetPage(-1);
                return Unit.INSTANCE;
            }
        }
        pagerState$scroll$1 = new PagerState$scroll$1(pagerState, continuation);
        Object obj2 = pagerState$scroll$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = pagerState$scroll$1.label;
        if (i5 != 0) {
        }
        if (!pagerState.isScrollInProgress()) {
        }
        scrollableState = pagerState.scrollableState;
        pagerState$scroll$1.L$0 = pagerState;
        pagerState$scroll$1.L$1 = null;
        pagerState$scroll$1.L$2 = null;
        pagerState$scroll$1.label = 2;
        if (scrollableState.scroll(mutatePriority, function2, pagerState$scroll$1) == coroutine_suspended) {
        }
        pagerState.setProgrammaticScrollTargetPage(-1);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Object scrollToPage$default(PagerState pagerState, int i5, float f5, Continuation continuation, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: scrollToPage");
        }
        if ((i6 & 2) != 0) {
            f5 = 0.0f;
        }
        return pagerState.scrollToPage(i5, f5, continuation);
    }

    private final void setCanScrollBackward(boolean z5) {
        this.canScrollBackward.setValue(Boolean.valueOf(z5));
    }

    private final void setCanScrollForward(boolean z5) {
        this.canScrollForward.setValue(Boolean.valueOf(z5));
    }

    private final void setProgrammaticScrollTargetPage(int i5) {
        this.programmaticScrollTargetPage.setIntValue(i5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setRemeasurement(Remeasurement remeasurement) {
        this.remeasurement.setValue(remeasurement);
    }

    private final void setSettledPageState(int i5) {
        this.settledPageState.setIntValue(i5);
    }

    private final void tryRunPrefetch(PagerMeasureResult result) {
        Snapshot.Companion companion = Snapshot.INSTANCE;
        Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
        Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
        Snapshot makeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
        try {
            if (Math.abs(this.previousPassDelta) > 0.5f && this.prefetchingEnabled && isGestureActionMatchesScroll(this.previousPassDelta)) {
                notifyPrefetch(this.previousPassDelta, result);
            }
            Unit unit = Unit.INSTANCE;
            companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
        } catch (Throwable th) {
            companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object animateScrollToPage(int i5, float f5, AnimationSpec<Float> animationSpec, Continuation<? super Unit> continuation) {
        PagerState$animateScrollToPage$1 pagerState$animateScrollToPage$1;
        int i6;
        final PagerState pagerState;
        double d5;
        if (continuation instanceof PagerState$animateScrollToPage$1) {
            pagerState$animateScrollToPage$1 = (PagerState$animateScrollToPage$1) continuation;
            int i7 = pagerState$animateScrollToPage$1.label;
            if ((i7 & Integer.MIN_VALUE) != 0) {
                pagerState$animateScrollToPage$1.label = i7 - Integer.MIN_VALUE;
                PagerState$animateScrollToPage$1 pagerState$animateScrollToPage$12 = pagerState$animateScrollToPage$1;
                Object obj = pagerState$animateScrollToPage$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i6 = pagerState$animateScrollToPage$12.label;
                if (i6 != 0) {
                    ResultKt.throwOnFailure(obj);
                    if ((i5 == getCurrentPage() && getCurrentPageOffsetFraction() == f5) || getPageCount() == 0) {
                        return Unit.INSTANCE;
                    }
                    pagerState$animateScrollToPage$12.L$0 = this;
                    pagerState$animateScrollToPage$12.L$1 = animationSpec;
                    pagerState$animateScrollToPage$12.I$0 = i5;
                    pagerState$animateScrollToPage$12.F$0 = f5;
                    pagerState$animateScrollToPage$12.label = 1;
                    if (awaitScrollDependencies(pagerState$animateScrollToPage$12) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    pagerState = this;
                } else {
                    if (i6 != 1) {
                        if (i6 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    f5 = pagerState$animateScrollToPage$12.F$0;
                    i5 = pagerState$animateScrollToPage$12.I$0;
                    animationSpec = (AnimationSpec) pagerState$animateScrollToPage$12.L$1;
                    pagerState = (PagerState) pagerState$animateScrollToPage$12.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                AnimationSpec<Float> animationSpec2 = animationSpec;
                d5 = f5;
                if (-0.5d <= d5 || d5 > 0.5d) {
                    throw new IllegalArgumentException(("pageOffsetFraction " + f5 + " is not within the range -0.5 to 0.5").toString());
                }
                int coerceInPageRange = pagerState.coerceInPageRange(i5);
                float pageSizeWithSpacing$foundation_release = f5 * pagerState.getPageSizeWithSpacing$foundation_release();
                LazyLayoutAnimateScrollScope lazyLayoutAnimateScrollScope = pagerState.animatedScrollScope;
                Function2<ScrollScope, Integer, Unit> function2 = new Function2<ScrollScope, Integer, Unit>() { // from class: androidx.compose.foundation.pager.PagerState$animateScrollToPage$3
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(ScrollScope scrollScope, Integer num) {
                        invoke(scrollScope, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(ScrollScope scrollScope, int i8) {
                        PagerState.this.updateTargetPage(scrollScope, i8);
                    }
                };
                pagerState$animateScrollToPage$12.L$0 = null;
                pagerState$animateScrollToPage$12.L$1 = null;
                pagerState$animateScrollToPage$12.label = 2;
                if (PagerStateKt.access$animateScrollToPage(lazyLayoutAnimateScrollScope, coerceInPageRange, pageSizeWithSpacing$foundation_release, animationSpec2, function2, pagerState$animateScrollToPage$12) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
        }
        pagerState$animateScrollToPage$1 = new PagerState$animateScrollToPage$1(this, continuation);
        PagerState$animateScrollToPage$1 pagerState$animateScrollToPage$122 = pagerState$animateScrollToPage$1;
        Object obj2 = pagerState$animateScrollToPage$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i6 = pagerState$animateScrollToPage$122.label;
        if (i6 != 0) {
        }
        AnimationSpec<Float> animationSpec22 = animationSpec;
        d5 = f5;
        if (-0.5d <= d5) {
        }
        throw new IllegalArgumentException(("pageOffsetFraction " + f5 + " is not within the range -0.5 to 0.5").toString());
    }

    public final void applyMeasureResult$foundation_release(PagerMeasureResult result, boolean visibleItemsStayedTheSame) {
        if (visibleItemsStayedTheSame) {
            this.scrollPosition.updateCurrentPageOffsetFraction(result.getCurrentPageOffsetFraction());
        } else {
            this.scrollPosition.updateFromMeasureResult(result);
            cancelPrefetchIfVisibleItemsChanged(result);
        }
        this.pagerLayoutInfoState.setValue(result);
        setCanScrollForward(result.getCanScrollForward());
        setCanScrollBackward(result.getCanScrollBackward());
        MeasuredPage firstVisiblePage = result.getFirstVisiblePage();
        if (firstVisiblePage != null) {
            this.firstVisiblePage = firstVisiblePage.getIndex();
        }
        this.firstVisiblePageOffset = result.getFirstVisiblePageScrollOffset();
        tryRunPrefetch(result);
        this.maxScrollOffset = PagerStateKt.calculateNewMaxScrollOffset(result, getPageCount());
        this.minScrollOffset = PagerStateKt.access$calculateNewMinScrollOffset(result, getPageCount());
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
    public final boolean getCanScrollBackward() {
        return ((Boolean) this.canScrollBackward.getValue()).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final boolean getCanScrollForward() {
        return ((Boolean) this.canScrollForward.getValue()).booleanValue();
    }

    public final int getCurrentPage() {
        return this.scrollPosition.getCurrentPage();
    }

    public final float getCurrentPageOffsetFraction() {
        return this.scrollPosition.getCurrentPageOffsetFraction();
    }

    /* renamed from: getDensity$foundation_release, reason: from getter */
    public final Density getDensity() {
        return this.density;
    }

    /* renamed from: getFirstVisiblePage$foundation_release, reason: from getter */
    public final int getFirstVisiblePage() {
        return this.firstVisiblePage;
    }

    /* renamed from: getFirstVisiblePageOffset$foundation_release, reason: from getter */
    public final int getFirstVisiblePageOffset() {
        return this.firstVisiblePageOffset;
    }

    /* renamed from: getInternalInteractionSource$foundation_release, reason: from getter */
    public final MutableInteractionSource getInternalInteractionSource() {
        return this.internalInteractionSource;
    }

    public boolean getLastScrolledForward() {
        return this.isLastScrollForwardState.getValue().booleanValue();
    }

    public final PagerLayoutInfo getLayoutInfo() {
        return this.pagerLayoutInfoState.getValue();
    }

    /* renamed from: getMeasurementScopeInvalidator-zYiylxw$foundation_release, reason: not valid java name */
    public final MutableState<Unit> m445getMeasurementScopeInvalidatorzYiylxw$foundation_release() {
        return this.measurementScopeInvalidator;
    }

    public final IntRange getNearestRange$foundation_release() {
        return this.scrollPosition.getNearestRangeState().getValue();
    }

    public abstract int getPageCount();

    public final int getPageSize$foundation_release() {
        return this.pagerLayoutInfoState.getValue().getPageSize();
    }

    public final int getPageSizeWithSpacing$foundation_release() {
        return getPageSize$foundation_release() + getPageSpacing$foundation_release();
    }

    public final int getPageSpacing$foundation_release() {
        return this.pagerLayoutInfoState.getValue().getPageSpacing();
    }

    /* renamed from: getPinnedPages$foundation_release, reason: from getter */
    public final LazyLayoutPinnedItemList getPinnedPages() {
        return this.pinnedPages;
    }

    /* renamed from: getPlacementScopeInvalidator-zYiylxw$foundation_release, reason: not valid java name */
    public final MutableState<Unit> m446getPlacementScopeInvalidatorzYiylxw$foundation_release() {
        return this.placementScopeInvalidator;
    }

    public final float getPositionThresholdFraction$foundation_release() {
        return Math.min(this.density.mo212toPx0680j_4(PagerStateKt.getDefaultPositionThreshold()), getPageSize$foundation_release() / 2.0f) / getPageSize$foundation_release();
    }

    /* renamed from: getPrefetchState$foundation_release, reason: from getter */
    public final LazyLayoutPrefetchState getPrefetchState() {
        return this.prefetchState;
    }

    public final Remeasurement getRemeasurement$foundation_release() {
        return (Remeasurement) this.remeasurement.getValue();
    }

    /* renamed from: getRemeasurementModifier$foundation_release, reason: from getter */
    public final RemeasurementModifier getRemeasurementModifier() {
        return this.remeasurementModifier;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getUpDownDifference-F1C5BW0$foundation_release, reason: not valid java name */
    public final long m447getUpDownDifferenceF1C5BW0$foundation_release() {
        return ((Offset) this.upDownDifference.getValue()).getPackedValue();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean isScrollInProgress() {
        return this.scrollableState.isScrollInProgress();
    }

    public final int matchScrollPositionWithKey$foundation_release(PagerLazyLayoutItemProvider itemProvider, int currentPage) {
        return this.scrollPosition.matchPageWithKey(itemProvider, currentPage);
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public Object scroll(MutatePriority mutatePriority, Function2<? super ScrollScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        return scroll$suspendImpl(this, mutatePriority, function2, continuation);
    }

    public final Object scrollToPage(int i5, float f5, Continuation<? super Unit> continuation) {
        Object scroll$default = ScrollableState.scroll$default(this, null, new PagerState$scrollToPage$2(this, f5, i5, null), continuation, 1, null);
        return scroll$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? scroll$default : Unit.INSTANCE;
    }

    public final void setDensity$foundation_release(Density density) {
        this.density = density;
    }

    /* renamed from: setPremeasureConstraints-BRTryo0$foundation_release, reason: not valid java name */
    public final void m448setPremeasureConstraintsBRTryo0$foundation_release(long j5) {
        this.premeasureConstraints = j5;
    }

    /* renamed from: setUpDownDifference-k-4lQ0M$foundation_release, reason: not valid java name */
    public final void m449setUpDownDifferencek4lQ0M$foundation_release(long j5) {
        this.upDownDifference.setValue(Offset.m1328boximpl(j5));
    }

    public final void snapToItem$foundation_release(int page, float offsetFraction, boolean forceRemeasure) {
        this.scrollPosition.requestPositionAndForgetLastKnownKey(page, offsetFraction);
        if (!forceRemeasure) {
            ObservableScopeInvalidator.m428invalidateScopeimpl(this.measurementScopeInvalidator);
            return;
        }
        Remeasurement remeasurement$foundation_release = getRemeasurement$foundation_release();
        if (remeasurement$foundation_release != null) {
            remeasurement$foundation_release.forceRemeasure();
        }
    }

    public final void updateTargetPage(ScrollScope scrollScope, int i5) {
        setProgrammaticScrollTargetPage(coerceInPageRange(i5));
    }

    public PagerState(int i5, float f5) {
        this(i5, f5, null);
    }
}
