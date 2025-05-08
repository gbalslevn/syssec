package androidx.compose.foundation.pager;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScopeKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000_\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\b\u0004*\u0001)\u001a1\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0003\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a\u0014\u0010\n\u001a\u00020\t*\u00020\u0006H\u0080@¢\u0006\u0004\b\n\u0010\u000b\u001a\u0014\u0010\f\u001a\u00020\t*\u00020\u0006H\u0080@¢\u0006\u0004\b\f\u0010\u000b\u001a\u001b\u0010\u000f\u001a\u00020\u000e*\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u001b\u0010\u0012\u001a\u00020\u000e*\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0012\u0010\u0013\u001aL\u0010\u001c\u001a\u00020\t*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u00172\u0018\u0010\u001b\u001a\u0014\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\t0\u0019H\u0082@¢\u0006\u0004\b\u001c\u0010\u001d\"\u001a\u0010\u001f\u001a\u00020\u001e8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0014\u0010#\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b#\u0010$\"\u001a\u0010%\u001a\u00020\u00118\u0000X\u0080\u0004¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0014\u0010*\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+¨\u0006,"}, d2 = {BuildConfig.FLAVOR, "initialPage", BuildConfig.FLAVOR, "initialPageOffsetFraction", "Lkotlin/Function0;", "pageCount", "Landroidx/compose/foundation/pager/PagerState;", "rememberPagerState", "(IFLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/pager/PagerState;", BuildConfig.FLAVOR, "animateToNextPage", "(Landroidx/compose/foundation/pager/PagerState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateToPreviousPage", "Landroidx/compose/foundation/pager/PagerLayoutInfo;", BuildConfig.FLAVOR, "calculateNewMaxScrollOffset", "(Landroidx/compose/foundation/pager/PagerLayoutInfo;I)J", "Landroidx/compose/foundation/pager/PagerMeasureResult;", "calculateNewMinScrollOffset", "(Landroidx/compose/foundation/pager/PagerMeasureResult;I)J", "Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimateScrollScope;", "targetPage", "targetPageOffsetToSnappedPosition", "Landroidx/compose/animation/core/AnimationSpec;", "animationSpec", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/ScrollScope;", "updateTargetPage", "animateScrollToPage", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimateScrollScope;IFLandroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/compose/ui/unit/Dp;", "DefaultPositionThreshold", "F", "getDefaultPositionThreshold", "()F", "MaxPagesForAnimateScroll", "I", "EmptyLayoutInfo", "Landroidx/compose/foundation/pager/PagerMeasureResult;", "getEmptyLayoutInfo", "()Landroidx/compose/foundation/pager/PagerMeasureResult;", "androidx/compose/foundation/pager/PagerStateKt$UnitDensity$1", "UnitDensity", "Landroidx/compose/foundation/pager/PagerStateKt$UnitDensity$1;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class PagerStateKt {
    private static final int MaxPagesForAnimateScroll = 3;
    private static final float DefaultPositionThreshold = Dp.m2599constructorimpl(56);
    private static final PagerMeasureResult EmptyLayoutInfo = new PagerMeasureResult(CollectionsKt.emptyList(), 0, 0, 0, Orientation.Horizontal, 0, 0, false, 0, null, null, DefaultPositionThreshold, 0, false, SnapPosition.Start.INSTANCE, new MeasureResult() { // from class: androidx.compose.foundation.pager.PagerStateKt$EmptyLayoutInfo$1
        private final Map<AlignmentLine, Integer> alignmentLines = MapsKt.emptyMap();
        private final int height;
        private final int width;

        @Override // androidx.compose.ui.layout.MeasureResult
        public Map<AlignmentLine, Integer> getAlignmentLines() {
            return this.alignmentLines;
        }

        @Override // androidx.compose.ui.layout.MeasureResult
        public int getHeight() {
            return this.height;
        }

        @Override // androidx.compose.ui.layout.MeasureResult
        public int getWidth() {
            return this.width;
        }

        @Override // androidx.compose.ui.layout.MeasureResult
        public void placeChildren() {
        }
    }, false, null, null, CoroutineScopeKt.CoroutineScope(EmptyCoroutineContext.INSTANCE), 393216, null);
    private static final PagerStateKt$UnitDensity$1 UnitDensity = new Density() { // from class: androidx.compose.foundation.pager.PagerStateKt$UnitDensity$1
        private final float density = 1.0f;
        private final float fontScale = 1.0f;

        @Override // androidx.compose.ui.unit.Density
        public float getDensity() {
            return this.density;
        }

        @Override // androidx.compose.ui.unit.FontScaling
        public float getFontScale() {
            return this.fontScale;
        }
    };

    public static final Object animateScrollToPage(LazyLayoutAnimateScrollScope lazyLayoutAnimateScrollScope, int i5, float f5, AnimationSpec<Float> animationSpec, Function2<? super ScrollScope, ? super Integer, Unit> function2, Continuation<? super Unit> continuation) {
        Object scroll = lazyLayoutAnimateScrollScope.scroll(new PagerStateKt$animateScrollToPage$2(function2, i5, lazyLayoutAnimateScrollScope, f5, animationSpec, null), continuation);
        return scroll == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? scroll : Unit.INSTANCE;
    }

    public static final Object animateToNextPage(PagerState pagerState, Continuation<? super Unit> continuation) {
        Object animateScrollToPage$default;
        return (pagerState.getCurrentPage() + 1 >= pagerState.getPageCount() || (animateScrollToPage$default = PagerState.animateScrollToPage$default(pagerState, pagerState.getCurrentPage() + 1, DefaultPositionThreshold, null, continuation, 6, null)) != IntrinsicsKt.getCOROUTINE_SUSPENDED()) ? Unit.INSTANCE : animateScrollToPage$default;
    }

    public static final Object animateToPreviousPage(PagerState pagerState, Continuation<? super Unit> continuation) {
        Object animateScrollToPage$default;
        return (pagerState.getCurrentPage() + (-1) < 0 || (animateScrollToPage$default = PagerState.animateScrollToPage$default(pagerState, pagerState.getCurrentPage() + (-1), DefaultPositionThreshold, null, continuation, 6, null)) != IntrinsicsKt.getCOROUTINE_SUSPENDED()) ? Unit.INSTANCE : animateScrollToPage$default;
    }

    public static final long calculateNewMaxScrollOffset(PagerLayoutInfo pagerLayoutInfo, int i5) {
        long pageSpacing = (i5 * (pagerLayoutInfo.getPageSpacing() + pagerLayoutInfo.getPageSize())) + pagerLayoutInfo.getBeforeContentPadding() + pagerLayoutInfo.getAfterContentPadding();
        int m2661getWidthimpl = pagerLayoutInfo.getOrientation() == Orientation.Horizontal ? IntSize.m2661getWidthimpl(pagerLayoutInfo.mo439getViewportSizeYbymL2g()) : IntSize.m2660getHeightimpl(pagerLayoutInfo.mo439getViewportSizeYbymL2g());
        return RangesKt.coerceAtLeast(pageSpacing - (m2661getWidthimpl - RangesKt.coerceIn(pagerLayoutInfo.getSnapPosition().position(m2661getWidthimpl, pagerLayoutInfo.getPageSize(), pagerLayoutInfo.getBeforeContentPadding(), pagerLayoutInfo.getAfterContentPadding(), i5 - 1, i5), 0, m2661getWidthimpl)), 0L);
    }

    public static final long calculateNewMinScrollOffset(PagerMeasureResult pagerMeasureResult, int i5) {
        int m2661getWidthimpl = pagerMeasureResult.getOrientation() == Orientation.Horizontal ? IntSize.m2661getWidthimpl(pagerMeasureResult.mo439getViewportSizeYbymL2g()) : IntSize.m2660getHeightimpl(pagerMeasureResult.mo439getViewportSizeYbymL2g());
        return RangesKt.coerceIn(pagerMeasureResult.getSnapPosition().position(m2661getWidthimpl, pagerMeasureResult.getPageSize(), pagerMeasureResult.getBeforeContentPadding(), pagerMeasureResult.getAfterContentPadding(), 0, i5), 0, m2661getWidthimpl);
    }

    public static final float getDefaultPositionThreshold() {
        return DefaultPositionThreshold;
    }

    public static final PagerMeasureResult getEmptyLayoutInfo() {
        return EmptyLayoutInfo;
    }

    public static final PagerState rememberPagerState(final int i5, final float f5, final Function0<Integer> function0, Composer composer, int i6, int i7) {
        if ((i7 & 1) != 0) {
            i5 = 0;
        }
        if ((i7 & 2) != 0) {
            f5 = DefaultPositionThreshold;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1210768637, i6, -1, "androidx.compose.foundation.pager.rememberPagerState (PagerState.kt:86)");
        }
        Object[] objArr = new Object[0];
        Saver<DefaultPagerState, ?> saver = DefaultPagerState.INSTANCE.getSaver();
        boolean z5 = ((((i6 & 14) ^ 6) > 4 && composer.changed(i5)) || (i6 & 6) == 4) | ((((i6 & 112) ^ 48) > 32 && composer.changed(f5)) || (i6 & 48) == 32) | ((((i6 & 896) ^ 384) > 256 && composer.changed(function0)) || (i6 & 384) == 256);
        Object rememberedValue = composer.rememberedValue();
        if (z5 || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function0<DefaultPagerState>() { // from class: androidx.compose.foundation.pager.PagerStateKt$rememberPagerState$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final DefaultPagerState invoke() {
                    return new DefaultPagerState(i5, f5, function0);
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        DefaultPagerState defaultPagerState = (DefaultPagerState) RememberSaveableKt.rememberSaveable(objArr, saver, null, (Function0) rememberedValue, composer, 0, 4);
        defaultPagerState.getPageCountState().setValue(function0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return defaultPagerState;
    }
}
