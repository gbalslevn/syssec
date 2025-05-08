package androidx.compose.foundation.pager;

import androidx.compose.foundation.CheckScrollableContainerConstraintsKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsStateKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffsetKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u009c\u0001\u0010 \u001a\u0014\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001a2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0000H\u0001ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006!"}, d2 = {"Lkotlin/Function0;", "Landroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;", "itemProviderLambda", "Landroidx/compose/foundation/pager/PagerState;", "state", "Landroidx/compose/foundation/layout/PaddingValues;", "contentPadding", BuildConfig.FLAVOR, "reverseLayout", "Landroidx/compose/foundation/gestures/Orientation;", "orientation", BuildConfig.FLAVOR, "beyondViewportPageCount", "Landroidx/compose/ui/unit/Dp;", "pageSpacing", "Landroidx/compose/foundation/pager/PageSize;", "pageSize", "Landroidx/compose/ui/Alignment$Horizontal;", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "verticalAlignment", "Landroidx/compose/foundation/gestures/snapping/SnapPosition;", "snapPosition", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "pageCount", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "rememberPagerMeasurePolicy-8u0NR3k", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/gestures/Orientation;IFLandroidx/compose/foundation/pager/PageSize;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/snapping/SnapPosition;Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Lkotlin/jvm/functions/Function2;", "rememberPagerMeasurePolicy", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class PagerMeasurePolicyKt {
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00bc, code lost:
    
        if (r34.changed(r27) == false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00d8, code lost:
    
        if (r34.changed(r28) == false) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00f1, code lost:
    
        if (r34.changed(r31) == false) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x010a, code lost:
    
        if (r34.changed(r33) == false) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0127, code lost:
    
        if (r34.changed(r26) == false) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0022, code lost:
    
        if (r34.changed(r22) != false) goto L13;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00bf  */
    /* renamed from: rememberPagerMeasurePolicy-8u0NR3k, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> m443rememberPagerMeasurePolicy8u0NR3k(final Function0<PagerLazyLayoutItemProvider> function0, final PagerState pagerState, final PaddingValues paddingValues, final boolean z5, final Orientation orientation, final int i5, final float f5, final PageSize pageSize, final Alignment.Horizontal horizontal, final Alignment.Vertical vertical, final SnapPosition snapPosition, final CoroutineScope coroutineScope, final Function0<Integer> function02, Composer composer, int i6, int i7) {
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        boolean changed;
        Object rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1391419623, i6, i7, "androidx.compose.foundation.pager.rememberPagerMeasurePolicy (PagerMeasurePolicy.kt:56)");
        }
        if (((i6 & 112) ^ 48) <= 32) {
        }
        if ((i6 & 48) != 32) {
            z6 = false;
            boolean z12 = z6 | ((((i6 & 896) ^ 384) <= 256 && composer.changed(paddingValues)) || (i6 & 384) == 256) | ((((i6 & 7168) ^ 3072) <= 2048 && composer.changed(z5)) || (i6 & 3072) == 2048) | ((((57344 & i6) ^ 24576) <= 16384 && composer.changed(orientation)) || (i6 & 24576) == 16384) | ((((234881024 & i6) ^ 100663296) <= 67108864 && composer.changed(horizontal)) || (i6 & 100663296) == 67108864) | ((((1879048192 & i6) ^ 805306368) <= 536870912 && composer.changed(vertical)) || (i6 & 805306368) == 536870912);
            if (((3670016 & i6) ^ 1572864) <= 1048576) {
            }
            if ((1572864 & i6) != 1048576) {
                z7 = false;
                boolean z13 = z12 | z7;
                if (((29360128 & i6) ^ 12582912) <= 8388608) {
                }
                if ((12582912 & i6) != 8388608) {
                    z8 = false;
                    boolean z14 = z13 | z8;
                    if (((i7 & 14) ^ 6) <= 4) {
                    }
                    if ((i7 & 6) != 4) {
                        z9 = false;
                        boolean z15 = z14 | z9;
                        if (((i7 & 896) ^ 384) <= 256) {
                        }
                        if ((i7 & 384) != 256) {
                            z10 = false;
                            boolean z16 = z10 | z15;
                            if (((458752 & i6) ^ 196608) <= 131072) {
                            }
                            if ((i6 & 196608) != 131072) {
                                z11 = false;
                                changed = z16 | z11 | composer.changed(coroutineScope);
                                rememberedValue = composer.rememberedValue();
                                if (!changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    Function2<LazyLayoutMeasureScope, Constraints, PagerMeasureResult> function2 = new Function2<LazyLayoutMeasureScope, Constraints, PagerMeasureResult>() { // from class: androidx.compose.foundation.pager.PagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ PagerMeasureResult invoke(LazyLayoutMeasureScope lazyLayoutMeasureScope, Constraints constraints) {
                                            return m444invoke0kLqBqw(lazyLayoutMeasureScope, constraints.getValue());
                                        }

                                        /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                                        public final PagerMeasureResult m444invoke0kLqBqw(final LazyLayoutMeasureScope lazyLayoutMeasureScope, final long j5) {
                                            long IntOffset;
                                            ObservableScopeInvalidator.m425attachToScopeimpl(PagerState.this.m445getMeasurementScopeInvalidatorzYiylxw$foundation_release());
                                            Orientation orientation2 = orientation;
                                            Orientation orientation3 = Orientation.Vertical;
                                            boolean z17 = orientation2 == orientation3;
                                            CheckScrollableContainerConstraintsKt.m118checkScrollableContainerConstraintsK40F9xA(j5, z17 ? orientation3 : Orientation.Horizontal);
                                            int mo206roundToPx0680j_4 = z17 ? lazyLayoutMeasureScope.mo206roundToPx0680j_4(paddingValues.mo290calculateLeftPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection())) : lazyLayoutMeasureScope.mo206roundToPx0680j_4(PaddingKt.calculateStartPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                                            int mo206roundToPx0680j_42 = z17 ? lazyLayoutMeasureScope.mo206roundToPx0680j_4(paddingValues.mo291calculateRightPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection())) : lazyLayoutMeasureScope.mo206roundToPx0680j_4(PaddingKt.calculateEndPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                                            int mo206roundToPx0680j_43 = lazyLayoutMeasureScope.mo206roundToPx0680j_4(paddingValues.getTop());
                                            int mo206roundToPx0680j_44 = lazyLayoutMeasureScope.mo206roundToPx0680j_4(paddingValues.getBottom());
                                            final int i8 = mo206roundToPx0680j_43 + mo206roundToPx0680j_44;
                                            final int i9 = mo206roundToPx0680j_4 + mo206roundToPx0680j_42;
                                            int i10 = z17 ? i8 : i9;
                                            int i11 = (!z17 || z5) ? (z17 && z5) ? mo206roundToPx0680j_44 : (z17 || z5) ? mo206roundToPx0680j_42 : mo206roundToPx0680j_4 : mo206roundToPx0680j_43;
                                            int i12 = i10 - i11;
                                            long m2595offsetNN6EwU = ConstraintsKt.m2595offsetNN6EwU(j5, -i9, -i8);
                                            PagerState.this.setDensity$foundation_release(lazyLayoutMeasureScope);
                                            int mo206roundToPx0680j_45 = lazyLayoutMeasureScope.mo206roundToPx0680j_4(f5);
                                            int m2577getMaxHeightimpl = z17 ? Constraints.m2577getMaxHeightimpl(j5) - i8 : Constraints.m2578getMaxWidthimpl(j5) - i9;
                                            if (!z5 || m2577getMaxHeightimpl > 0) {
                                                IntOffset = IntOffsetKt.IntOffset(mo206roundToPx0680j_4, mo206roundToPx0680j_43);
                                            } else {
                                                if (!z17) {
                                                    mo206roundToPx0680j_4 += m2577getMaxHeightimpl;
                                                }
                                                if (z17) {
                                                    mo206roundToPx0680j_43 += m2577getMaxHeightimpl;
                                                }
                                                IntOffset = IntOffsetKt.IntOffset(mo206roundToPx0680j_4, mo206roundToPx0680j_43);
                                            }
                                            long j6 = IntOffset;
                                            int coerceAtLeast = RangesKt.coerceAtLeast(pageSize.calculateMainAxisPageSize(lazyLayoutMeasureScope, m2577getMaxHeightimpl, mo206roundToPx0680j_45), 0);
                                            PagerState.this.m448setPremeasureConstraintsBRTryo0$foundation_release(ConstraintsKt.Constraints$default(0, orientation == orientation3 ? Constraints.m2578getMaxWidthimpl(m2595offsetNN6EwU) : coerceAtLeast, 0, orientation != orientation3 ? Constraints.m2577getMaxHeightimpl(m2595offsetNN6EwU) : coerceAtLeast, 5, null));
                                            PagerLazyLayoutItemProvider invoke = function0.invoke();
                                            Snapshot.Companion companion = Snapshot.INSTANCE;
                                            PagerState pagerState2 = PagerState.this;
                                            SnapPosition snapPosition2 = snapPosition;
                                            Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
                                            Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                                            Snapshot makeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
                                            try {
                                                int matchScrollPositionWithKey$foundation_release = pagerState2.matchScrollPositionWithKey$foundation_release(invoke, pagerState2.getCurrentPage());
                                                int currentPageOffset = PagerKt.currentPageOffset(snapPosition2, m2577getMaxHeightimpl, coerceAtLeast, mo206roundToPx0680j_45, i11, i12, pagerState2.getCurrentPage(), pagerState2.getCurrentPageOffsetFraction(), pagerState2.getPageCount());
                                                Unit unit = Unit.INSTANCE;
                                                companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                                                PagerMeasureResult m442measurePagerbmk8ZPk = PagerMeasureKt.m442measurePagerbmk8ZPk(lazyLayoutMeasureScope, function02.invoke().intValue(), invoke, m2577getMaxHeightimpl, i11, i12, mo206roundToPx0680j_45, matchScrollPositionWithKey$foundation_release, currentPageOffset, m2595offsetNN6EwU, orientation, vertical, horizontal, z5, j6, coerceAtLeast, i5, LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(invoke, PagerState.this.getPinnedPages(), PagerState.this.getBeyondBoundsInfo()), snapPosition, PagerState.this.m446getPlacementScopeInvalidatorzYiylxw$foundation_release(), coroutineScope, new Function3<Integer, Integer, Function1<? super Placeable.PlacementScope, ? extends Unit>, MeasureResult>() { // from class: androidx.compose.foundation.pager.PagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1$measureResult$1
                                                    /* JADX INFO: Access modifiers changed from: package-private */
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(3);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function3
                                                    public /* bridge */ /* synthetic */ MeasureResult invoke(Integer num, Integer num2, Function1<? super Placeable.PlacementScope, ? extends Unit> function1) {
                                                        return invoke(num.intValue(), num2.intValue(), (Function1<? super Placeable.PlacementScope, Unit>) function1);
                                                    }

                                                    public final MeasureResult invoke(int i13, int i14, Function1<? super Placeable.PlacementScope, Unit> function1) {
                                                        return LazyLayoutMeasureScope.this.layout(ConstraintsKt.m2593constrainWidthK40F9xA(j5, i13 + i9), ConstraintsKt.m2592constrainHeightK40F9xA(j5, i14 + i8), MapsKt.emptyMap(), function1);
                                                    }
                                                });
                                                PagerState.applyMeasureResult$foundation_release$default(PagerState.this, m442measurePagerbmk8ZPk, false, 2, null);
                                                return m442measurePagerbmk8ZPk;
                                            } catch (Throwable th) {
                                                companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                                                throw th;
                                            }
                                        }
                                    };
                                    composer.updateRememberedValue(function2);
                                    rememberedValue = function2;
                                }
                                Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function22 = (Function2) rememberedValue;
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                return function22;
                            }
                            z11 = true;
                            changed = z16 | z11 | composer.changed(coroutineScope);
                            rememberedValue = composer.rememberedValue();
                            if (!changed) {
                            }
                            Function2<LazyLayoutMeasureScope, Constraints, PagerMeasureResult> function23 = new Function2<LazyLayoutMeasureScope, Constraints, PagerMeasureResult>() { // from class: androidx.compose.foundation.pager.PagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ PagerMeasureResult invoke(LazyLayoutMeasureScope lazyLayoutMeasureScope, Constraints constraints) {
                                    return m444invoke0kLqBqw(lazyLayoutMeasureScope, constraints.getValue());
                                }

                                /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                                public final PagerMeasureResult m444invoke0kLqBqw(final LazyLayoutMeasureScope lazyLayoutMeasureScope, final long j5) {
                                    long IntOffset;
                                    ObservableScopeInvalidator.m425attachToScopeimpl(PagerState.this.m445getMeasurementScopeInvalidatorzYiylxw$foundation_release());
                                    Orientation orientation2 = orientation;
                                    Orientation orientation3 = Orientation.Vertical;
                                    boolean z17 = orientation2 == orientation3;
                                    CheckScrollableContainerConstraintsKt.m118checkScrollableContainerConstraintsK40F9xA(j5, z17 ? orientation3 : Orientation.Horizontal);
                                    int mo206roundToPx0680j_4 = z17 ? lazyLayoutMeasureScope.mo206roundToPx0680j_4(paddingValues.mo290calculateLeftPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection())) : lazyLayoutMeasureScope.mo206roundToPx0680j_4(PaddingKt.calculateStartPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                                    int mo206roundToPx0680j_42 = z17 ? lazyLayoutMeasureScope.mo206roundToPx0680j_4(paddingValues.mo291calculateRightPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection())) : lazyLayoutMeasureScope.mo206roundToPx0680j_4(PaddingKt.calculateEndPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                                    int mo206roundToPx0680j_43 = lazyLayoutMeasureScope.mo206roundToPx0680j_4(paddingValues.getTop());
                                    int mo206roundToPx0680j_44 = lazyLayoutMeasureScope.mo206roundToPx0680j_4(paddingValues.getBottom());
                                    final int i8 = mo206roundToPx0680j_43 + mo206roundToPx0680j_44;
                                    final int i9 = mo206roundToPx0680j_4 + mo206roundToPx0680j_42;
                                    int i10 = z17 ? i8 : i9;
                                    int i11 = (!z17 || z5) ? (z17 && z5) ? mo206roundToPx0680j_44 : (z17 || z5) ? mo206roundToPx0680j_42 : mo206roundToPx0680j_4 : mo206roundToPx0680j_43;
                                    int i12 = i10 - i11;
                                    long m2595offsetNN6EwU = ConstraintsKt.m2595offsetNN6EwU(j5, -i9, -i8);
                                    PagerState.this.setDensity$foundation_release(lazyLayoutMeasureScope);
                                    int mo206roundToPx0680j_45 = lazyLayoutMeasureScope.mo206roundToPx0680j_4(f5);
                                    int m2577getMaxHeightimpl = z17 ? Constraints.m2577getMaxHeightimpl(j5) - i8 : Constraints.m2578getMaxWidthimpl(j5) - i9;
                                    if (!z5 || m2577getMaxHeightimpl > 0) {
                                        IntOffset = IntOffsetKt.IntOffset(mo206roundToPx0680j_4, mo206roundToPx0680j_43);
                                    } else {
                                        if (!z17) {
                                            mo206roundToPx0680j_4 += m2577getMaxHeightimpl;
                                        }
                                        if (z17) {
                                            mo206roundToPx0680j_43 += m2577getMaxHeightimpl;
                                        }
                                        IntOffset = IntOffsetKt.IntOffset(mo206roundToPx0680j_4, mo206roundToPx0680j_43);
                                    }
                                    long j6 = IntOffset;
                                    int coerceAtLeast = RangesKt.coerceAtLeast(pageSize.calculateMainAxisPageSize(lazyLayoutMeasureScope, m2577getMaxHeightimpl, mo206roundToPx0680j_45), 0);
                                    PagerState.this.m448setPremeasureConstraintsBRTryo0$foundation_release(ConstraintsKt.Constraints$default(0, orientation == orientation3 ? Constraints.m2578getMaxWidthimpl(m2595offsetNN6EwU) : coerceAtLeast, 0, orientation != orientation3 ? Constraints.m2577getMaxHeightimpl(m2595offsetNN6EwU) : coerceAtLeast, 5, null));
                                    PagerLazyLayoutItemProvider invoke = function0.invoke();
                                    Snapshot.Companion companion = Snapshot.INSTANCE;
                                    PagerState pagerState2 = PagerState.this;
                                    SnapPosition snapPosition2 = snapPosition;
                                    Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
                                    Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                                    Snapshot makeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
                                    try {
                                        int matchScrollPositionWithKey$foundation_release = pagerState2.matchScrollPositionWithKey$foundation_release(invoke, pagerState2.getCurrentPage());
                                        int currentPageOffset = PagerKt.currentPageOffset(snapPosition2, m2577getMaxHeightimpl, coerceAtLeast, mo206roundToPx0680j_45, i11, i12, pagerState2.getCurrentPage(), pagerState2.getCurrentPageOffsetFraction(), pagerState2.getPageCount());
                                        Unit unit = Unit.INSTANCE;
                                        companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                                        PagerMeasureResult m442measurePagerbmk8ZPk = PagerMeasureKt.m442measurePagerbmk8ZPk(lazyLayoutMeasureScope, function02.invoke().intValue(), invoke, m2577getMaxHeightimpl, i11, i12, mo206roundToPx0680j_45, matchScrollPositionWithKey$foundation_release, currentPageOffset, m2595offsetNN6EwU, orientation, vertical, horizontal, z5, j6, coerceAtLeast, i5, LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(invoke, PagerState.this.getPinnedPages(), PagerState.this.getBeyondBoundsInfo()), snapPosition, PagerState.this.m446getPlacementScopeInvalidatorzYiylxw$foundation_release(), coroutineScope, new Function3<Integer, Integer, Function1<? super Placeable.PlacementScope, ? extends Unit>, MeasureResult>() { // from class: androidx.compose.foundation.pager.PagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1$measureResult$1
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(3);
                                            }

                                            @Override // kotlin.jvm.functions.Function3
                                            public /* bridge */ /* synthetic */ MeasureResult invoke(Integer num, Integer num2, Function1<? super Placeable.PlacementScope, ? extends Unit> function1) {
                                                return invoke(num.intValue(), num2.intValue(), (Function1<? super Placeable.PlacementScope, Unit>) function1);
                                            }

                                            public final MeasureResult invoke(int i13, int i14, Function1<? super Placeable.PlacementScope, Unit> function1) {
                                                return LazyLayoutMeasureScope.this.layout(ConstraintsKt.m2593constrainWidthK40F9xA(j5, i13 + i9), ConstraintsKt.m2592constrainHeightK40F9xA(j5, i14 + i8), MapsKt.emptyMap(), function1);
                                            }
                                        });
                                        PagerState.applyMeasureResult$foundation_release$default(PagerState.this, m442measurePagerbmk8ZPk, false, 2, null);
                                        return m442measurePagerbmk8ZPk;
                                    } catch (Throwable th) {
                                        companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                                        throw th;
                                    }
                                }
                            };
                            composer.updateRememberedValue(function23);
                            rememberedValue = function23;
                            Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function222 = (Function2) rememberedValue;
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            return function222;
                        }
                        z10 = true;
                        boolean z162 = z10 | z15;
                        if (((458752 & i6) ^ 196608) <= 131072) {
                        }
                        if ((i6 & 196608) != 131072) {
                        }
                        z11 = true;
                        changed = z162 | z11 | composer.changed(coroutineScope);
                        rememberedValue = composer.rememberedValue();
                        if (!changed) {
                        }
                        Function2<LazyLayoutMeasureScope, Constraints, PagerMeasureResult> function232 = new Function2<LazyLayoutMeasureScope, Constraints, PagerMeasureResult>() { // from class: androidx.compose.foundation.pager.PagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ PagerMeasureResult invoke(LazyLayoutMeasureScope lazyLayoutMeasureScope, Constraints constraints) {
                                return m444invoke0kLqBqw(lazyLayoutMeasureScope, constraints.getValue());
                            }

                            /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                            public final PagerMeasureResult m444invoke0kLqBqw(final LazyLayoutMeasureScope lazyLayoutMeasureScope, final long j5) {
                                long IntOffset;
                                ObservableScopeInvalidator.m425attachToScopeimpl(PagerState.this.m445getMeasurementScopeInvalidatorzYiylxw$foundation_release());
                                Orientation orientation2 = orientation;
                                Orientation orientation3 = Orientation.Vertical;
                                boolean z17 = orientation2 == orientation3;
                                CheckScrollableContainerConstraintsKt.m118checkScrollableContainerConstraintsK40F9xA(j5, z17 ? orientation3 : Orientation.Horizontal);
                                int mo206roundToPx0680j_4 = z17 ? lazyLayoutMeasureScope.mo206roundToPx0680j_4(paddingValues.mo290calculateLeftPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection())) : lazyLayoutMeasureScope.mo206roundToPx0680j_4(PaddingKt.calculateStartPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                                int mo206roundToPx0680j_42 = z17 ? lazyLayoutMeasureScope.mo206roundToPx0680j_4(paddingValues.mo291calculateRightPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection())) : lazyLayoutMeasureScope.mo206roundToPx0680j_4(PaddingKt.calculateEndPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                                int mo206roundToPx0680j_43 = lazyLayoutMeasureScope.mo206roundToPx0680j_4(paddingValues.getTop());
                                int mo206roundToPx0680j_44 = lazyLayoutMeasureScope.mo206roundToPx0680j_4(paddingValues.getBottom());
                                final int i8 = mo206roundToPx0680j_43 + mo206roundToPx0680j_44;
                                final int i9 = mo206roundToPx0680j_4 + mo206roundToPx0680j_42;
                                int i10 = z17 ? i8 : i9;
                                int i11 = (!z17 || z5) ? (z17 && z5) ? mo206roundToPx0680j_44 : (z17 || z5) ? mo206roundToPx0680j_42 : mo206roundToPx0680j_4 : mo206roundToPx0680j_43;
                                int i12 = i10 - i11;
                                long m2595offsetNN6EwU = ConstraintsKt.m2595offsetNN6EwU(j5, -i9, -i8);
                                PagerState.this.setDensity$foundation_release(lazyLayoutMeasureScope);
                                int mo206roundToPx0680j_45 = lazyLayoutMeasureScope.mo206roundToPx0680j_4(f5);
                                int m2577getMaxHeightimpl = z17 ? Constraints.m2577getMaxHeightimpl(j5) - i8 : Constraints.m2578getMaxWidthimpl(j5) - i9;
                                if (!z5 || m2577getMaxHeightimpl > 0) {
                                    IntOffset = IntOffsetKt.IntOffset(mo206roundToPx0680j_4, mo206roundToPx0680j_43);
                                } else {
                                    if (!z17) {
                                        mo206roundToPx0680j_4 += m2577getMaxHeightimpl;
                                    }
                                    if (z17) {
                                        mo206roundToPx0680j_43 += m2577getMaxHeightimpl;
                                    }
                                    IntOffset = IntOffsetKt.IntOffset(mo206roundToPx0680j_4, mo206roundToPx0680j_43);
                                }
                                long j6 = IntOffset;
                                int coerceAtLeast = RangesKt.coerceAtLeast(pageSize.calculateMainAxisPageSize(lazyLayoutMeasureScope, m2577getMaxHeightimpl, mo206roundToPx0680j_45), 0);
                                PagerState.this.m448setPremeasureConstraintsBRTryo0$foundation_release(ConstraintsKt.Constraints$default(0, orientation == orientation3 ? Constraints.m2578getMaxWidthimpl(m2595offsetNN6EwU) : coerceAtLeast, 0, orientation != orientation3 ? Constraints.m2577getMaxHeightimpl(m2595offsetNN6EwU) : coerceAtLeast, 5, null));
                                PagerLazyLayoutItemProvider invoke = function0.invoke();
                                Snapshot.Companion companion = Snapshot.INSTANCE;
                                PagerState pagerState2 = PagerState.this;
                                SnapPosition snapPosition2 = snapPosition;
                                Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
                                Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                                Snapshot makeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
                                try {
                                    int matchScrollPositionWithKey$foundation_release = pagerState2.matchScrollPositionWithKey$foundation_release(invoke, pagerState2.getCurrentPage());
                                    int currentPageOffset = PagerKt.currentPageOffset(snapPosition2, m2577getMaxHeightimpl, coerceAtLeast, mo206roundToPx0680j_45, i11, i12, pagerState2.getCurrentPage(), pagerState2.getCurrentPageOffsetFraction(), pagerState2.getPageCount());
                                    Unit unit = Unit.INSTANCE;
                                    companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                                    PagerMeasureResult m442measurePagerbmk8ZPk = PagerMeasureKt.m442measurePagerbmk8ZPk(lazyLayoutMeasureScope, function02.invoke().intValue(), invoke, m2577getMaxHeightimpl, i11, i12, mo206roundToPx0680j_45, matchScrollPositionWithKey$foundation_release, currentPageOffset, m2595offsetNN6EwU, orientation, vertical, horizontal, z5, j6, coerceAtLeast, i5, LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(invoke, PagerState.this.getPinnedPages(), PagerState.this.getBeyondBoundsInfo()), snapPosition, PagerState.this.m446getPlacementScopeInvalidatorzYiylxw$foundation_release(), coroutineScope, new Function3<Integer, Integer, Function1<? super Placeable.PlacementScope, ? extends Unit>, MeasureResult>() { // from class: androidx.compose.foundation.pager.PagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1$measureResult$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ MeasureResult invoke(Integer num, Integer num2, Function1<? super Placeable.PlacementScope, ? extends Unit> function1) {
                                            return invoke(num.intValue(), num2.intValue(), (Function1<? super Placeable.PlacementScope, Unit>) function1);
                                        }

                                        public final MeasureResult invoke(int i13, int i14, Function1<? super Placeable.PlacementScope, Unit> function1) {
                                            return LazyLayoutMeasureScope.this.layout(ConstraintsKt.m2593constrainWidthK40F9xA(j5, i13 + i9), ConstraintsKt.m2592constrainHeightK40F9xA(j5, i14 + i8), MapsKt.emptyMap(), function1);
                                        }
                                    });
                                    PagerState.applyMeasureResult$foundation_release$default(PagerState.this, m442measurePagerbmk8ZPk, false, 2, null);
                                    return m442measurePagerbmk8ZPk;
                                } catch (Throwable th) {
                                    companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                                    throw th;
                                }
                            }
                        };
                        composer.updateRememberedValue(function232);
                        rememberedValue = function232;
                        Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2222 = (Function2) rememberedValue;
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        return function2222;
                    }
                    z9 = true;
                    boolean z152 = z14 | z9;
                    if (((i7 & 896) ^ 384) <= 256) {
                    }
                    if ((i7 & 384) != 256) {
                    }
                    z10 = true;
                    boolean z1622 = z10 | z152;
                    if (((458752 & i6) ^ 196608) <= 131072) {
                    }
                    if ((i6 & 196608) != 131072) {
                    }
                    z11 = true;
                    changed = z1622 | z11 | composer.changed(coroutineScope);
                    rememberedValue = composer.rememberedValue();
                    if (!changed) {
                    }
                    Function2<LazyLayoutMeasureScope, Constraints, PagerMeasureResult> function2322 = new Function2<LazyLayoutMeasureScope, Constraints, PagerMeasureResult>() { // from class: androidx.compose.foundation.pager.PagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ PagerMeasureResult invoke(LazyLayoutMeasureScope lazyLayoutMeasureScope, Constraints constraints) {
                            return m444invoke0kLqBqw(lazyLayoutMeasureScope, constraints.getValue());
                        }

                        /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                        public final PagerMeasureResult m444invoke0kLqBqw(final LazyLayoutMeasureScope lazyLayoutMeasureScope, final long j5) {
                            long IntOffset;
                            ObservableScopeInvalidator.m425attachToScopeimpl(PagerState.this.m445getMeasurementScopeInvalidatorzYiylxw$foundation_release());
                            Orientation orientation2 = orientation;
                            Orientation orientation3 = Orientation.Vertical;
                            boolean z17 = orientation2 == orientation3;
                            CheckScrollableContainerConstraintsKt.m118checkScrollableContainerConstraintsK40F9xA(j5, z17 ? orientation3 : Orientation.Horizontal);
                            int mo206roundToPx0680j_4 = z17 ? lazyLayoutMeasureScope.mo206roundToPx0680j_4(paddingValues.mo290calculateLeftPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection())) : lazyLayoutMeasureScope.mo206roundToPx0680j_4(PaddingKt.calculateStartPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                            int mo206roundToPx0680j_42 = z17 ? lazyLayoutMeasureScope.mo206roundToPx0680j_4(paddingValues.mo291calculateRightPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection())) : lazyLayoutMeasureScope.mo206roundToPx0680j_4(PaddingKt.calculateEndPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                            int mo206roundToPx0680j_43 = lazyLayoutMeasureScope.mo206roundToPx0680j_4(paddingValues.getTop());
                            int mo206roundToPx0680j_44 = lazyLayoutMeasureScope.mo206roundToPx0680j_4(paddingValues.getBottom());
                            final int i8 = mo206roundToPx0680j_43 + mo206roundToPx0680j_44;
                            final int i9 = mo206roundToPx0680j_4 + mo206roundToPx0680j_42;
                            int i10 = z17 ? i8 : i9;
                            int i11 = (!z17 || z5) ? (z17 && z5) ? mo206roundToPx0680j_44 : (z17 || z5) ? mo206roundToPx0680j_42 : mo206roundToPx0680j_4 : mo206roundToPx0680j_43;
                            int i12 = i10 - i11;
                            long m2595offsetNN6EwU = ConstraintsKt.m2595offsetNN6EwU(j5, -i9, -i8);
                            PagerState.this.setDensity$foundation_release(lazyLayoutMeasureScope);
                            int mo206roundToPx0680j_45 = lazyLayoutMeasureScope.mo206roundToPx0680j_4(f5);
                            int m2577getMaxHeightimpl = z17 ? Constraints.m2577getMaxHeightimpl(j5) - i8 : Constraints.m2578getMaxWidthimpl(j5) - i9;
                            if (!z5 || m2577getMaxHeightimpl > 0) {
                                IntOffset = IntOffsetKt.IntOffset(mo206roundToPx0680j_4, mo206roundToPx0680j_43);
                            } else {
                                if (!z17) {
                                    mo206roundToPx0680j_4 += m2577getMaxHeightimpl;
                                }
                                if (z17) {
                                    mo206roundToPx0680j_43 += m2577getMaxHeightimpl;
                                }
                                IntOffset = IntOffsetKt.IntOffset(mo206roundToPx0680j_4, mo206roundToPx0680j_43);
                            }
                            long j6 = IntOffset;
                            int coerceAtLeast = RangesKt.coerceAtLeast(pageSize.calculateMainAxisPageSize(lazyLayoutMeasureScope, m2577getMaxHeightimpl, mo206roundToPx0680j_45), 0);
                            PagerState.this.m448setPremeasureConstraintsBRTryo0$foundation_release(ConstraintsKt.Constraints$default(0, orientation == orientation3 ? Constraints.m2578getMaxWidthimpl(m2595offsetNN6EwU) : coerceAtLeast, 0, orientation != orientation3 ? Constraints.m2577getMaxHeightimpl(m2595offsetNN6EwU) : coerceAtLeast, 5, null));
                            PagerLazyLayoutItemProvider invoke = function0.invoke();
                            Snapshot.Companion companion = Snapshot.INSTANCE;
                            PagerState pagerState2 = PagerState.this;
                            SnapPosition snapPosition2 = snapPosition;
                            Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
                            Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                            Snapshot makeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
                            try {
                                int matchScrollPositionWithKey$foundation_release = pagerState2.matchScrollPositionWithKey$foundation_release(invoke, pagerState2.getCurrentPage());
                                int currentPageOffset = PagerKt.currentPageOffset(snapPosition2, m2577getMaxHeightimpl, coerceAtLeast, mo206roundToPx0680j_45, i11, i12, pagerState2.getCurrentPage(), pagerState2.getCurrentPageOffsetFraction(), pagerState2.getPageCount());
                                Unit unit = Unit.INSTANCE;
                                companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                                PagerMeasureResult m442measurePagerbmk8ZPk = PagerMeasureKt.m442measurePagerbmk8ZPk(lazyLayoutMeasureScope, function02.invoke().intValue(), invoke, m2577getMaxHeightimpl, i11, i12, mo206roundToPx0680j_45, matchScrollPositionWithKey$foundation_release, currentPageOffset, m2595offsetNN6EwU, orientation, vertical, horizontal, z5, j6, coerceAtLeast, i5, LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(invoke, PagerState.this.getPinnedPages(), PagerState.this.getBeyondBoundsInfo()), snapPosition, PagerState.this.m446getPlacementScopeInvalidatorzYiylxw$foundation_release(), coroutineScope, new Function3<Integer, Integer, Function1<? super Placeable.PlacementScope, ? extends Unit>, MeasureResult>() { // from class: androidx.compose.foundation.pager.PagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1$measureResult$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ MeasureResult invoke(Integer num, Integer num2, Function1<? super Placeable.PlacementScope, ? extends Unit> function1) {
                                        return invoke(num.intValue(), num2.intValue(), (Function1<? super Placeable.PlacementScope, Unit>) function1);
                                    }

                                    public final MeasureResult invoke(int i13, int i14, Function1<? super Placeable.PlacementScope, Unit> function1) {
                                        return LazyLayoutMeasureScope.this.layout(ConstraintsKt.m2593constrainWidthK40F9xA(j5, i13 + i9), ConstraintsKt.m2592constrainHeightK40F9xA(j5, i14 + i8), MapsKt.emptyMap(), function1);
                                    }
                                });
                                PagerState.applyMeasureResult$foundation_release$default(PagerState.this, m442measurePagerbmk8ZPk, false, 2, null);
                                return m442measurePagerbmk8ZPk;
                            } catch (Throwable th) {
                                companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                                throw th;
                            }
                        }
                    };
                    composer.updateRememberedValue(function2322);
                    rememberedValue = function2322;
                    Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function22222 = (Function2) rememberedValue;
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    return function22222;
                }
                z8 = true;
                boolean z142 = z13 | z8;
                if (((i7 & 14) ^ 6) <= 4) {
                }
                if ((i7 & 6) != 4) {
                }
                z9 = true;
                boolean z1522 = z142 | z9;
                if (((i7 & 896) ^ 384) <= 256) {
                }
                if ((i7 & 384) != 256) {
                }
                z10 = true;
                boolean z16222 = z10 | z1522;
                if (((458752 & i6) ^ 196608) <= 131072) {
                }
                if ((i6 & 196608) != 131072) {
                }
                z11 = true;
                changed = z16222 | z11 | composer.changed(coroutineScope);
                rememberedValue = composer.rememberedValue();
                if (!changed) {
                }
                Function2<LazyLayoutMeasureScope, Constraints, PagerMeasureResult> function23222 = new Function2<LazyLayoutMeasureScope, Constraints, PagerMeasureResult>() { // from class: androidx.compose.foundation.pager.PagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ PagerMeasureResult invoke(LazyLayoutMeasureScope lazyLayoutMeasureScope, Constraints constraints) {
                        return m444invoke0kLqBqw(lazyLayoutMeasureScope, constraints.getValue());
                    }

                    /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                    public final PagerMeasureResult m444invoke0kLqBqw(final LazyLayoutMeasureScope lazyLayoutMeasureScope, final long j5) {
                        long IntOffset;
                        ObservableScopeInvalidator.m425attachToScopeimpl(PagerState.this.m445getMeasurementScopeInvalidatorzYiylxw$foundation_release());
                        Orientation orientation2 = orientation;
                        Orientation orientation3 = Orientation.Vertical;
                        boolean z17 = orientation2 == orientation3;
                        CheckScrollableContainerConstraintsKt.m118checkScrollableContainerConstraintsK40F9xA(j5, z17 ? orientation3 : Orientation.Horizontal);
                        int mo206roundToPx0680j_4 = z17 ? lazyLayoutMeasureScope.mo206roundToPx0680j_4(paddingValues.mo290calculateLeftPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection())) : lazyLayoutMeasureScope.mo206roundToPx0680j_4(PaddingKt.calculateStartPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                        int mo206roundToPx0680j_42 = z17 ? lazyLayoutMeasureScope.mo206roundToPx0680j_4(paddingValues.mo291calculateRightPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection())) : lazyLayoutMeasureScope.mo206roundToPx0680j_4(PaddingKt.calculateEndPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                        int mo206roundToPx0680j_43 = lazyLayoutMeasureScope.mo206roundToPx0680j_4(paddingValues.getTop());
                        int mo206roundToPx0680j_44 = lazyLayoutMeasureScope.mo206roundToPx0680j_4(paddingValues.getBottom());
                        final int i8 = mo206roundToPx0680j_43 + mo206roundToPx0680j_44;
                        final int i9 = mo206roundToPx0680j_4 + mo206roundToPx0680j_42;
                        int i10 = z17 ? i8 : i9;
                        int i11 = (!z17 || z5) ? (z17 && z5) ? mo206roundToPx0680j_44 : (z17 || z5) ? mo206roundToPx0680j_42 : mo206roundToPx0680j_4 : mo206roundToPx0680j_43;
                        int i12 = i10 - i11;
                        long m2595offsetNN6EwU = ConstraintsKt.m2595offsetNN6EwU(j5, -i9, -i8);
                        PagerState.this.setDensity$foundation_release(lazyLayoutMeasureScope);
                        int mo206roundToPx0680j_45 = lazyLayoutMeasureScope.mo206roundToPx0680j_4(f5);
                        int m2577getMaxHeightimpl = z17 ? Constraints.m2577getMaxHeightimpl(j5) - i8 : Constraints.m2578getMaxWidthimpl(j5) - i9;
                        if (!z5 || m2577getMaxHeightimpl > 0) {
                            IntOffset = IntOffsetKt.IntOffset(mo206roundToPx0680j_4, mo206roundToPx0680j_43);
                        } else {
                            if (!z17) {
                                mo206roundToPx0680j_4 += m2577getMaxHeightimpl;
                            }
                            if (z17) {
                                mo206roundToPx0680j_43 += m2577getMaxHeightimpl;
                            }
                            IntOffset = IntOffsetKt.IntOffset(mo206roundToPx0680j_4, mo206roundToPx0680j_43);
                        }
                        long j6 = IntOffset;
                        int coerceAtLeast = RangesKt.coerceAtLeast(pageSize.calculateMainAxisPageSize(lazyLayoutMeasureScope, m2577getMaxHeightimpl, mo206roundToPx0680j_45), 0);
                        PagerState.this.m448setPremeasureConstraintsBRTryo0$foundation_release(ConstraintsKt.Constraints$default(0, orientation == orientation3 ? Constraints.m2578getMaxWidthimpl(m2595offsetNN6EwU) : coerceAtLeast, 0, orientation != orientation3 ? Constraints.m2577getMaxHeightimpl(m2595offsetNN6EwU) : coerceAtLeast, 5, null));
                        PagerLazyLayoutItemProvider invoke = function0.invoke();
                        Snapshot.Companion companion = Snapshot.INSTANCE;
                        PagerState pagerState2 = PagerState.this;
                        SnapPosition snapPosition2 = snapPosition;
                        Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
                        Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                        Snapshot makeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
                        try {
                            int matchScrollPositionWithKey$foundation_release = pagerState2.matchScrollPositionWithKey$foundation_release(invoke, pagerState2.getCurrentPage());
                            int currentPageOffset = PagerKt.currentPageOffset(snapPosition2, m2577getMaxHeightimpl, coerceAtLeast, mo206roundToPx0680j_45, i11, i12, pagerState2.getCurrentPage(), pagerState2.getCurrentPageOffsetFraction(), pagerState2.getPageCount());
                            Unit unit = Unit.INSTANCE;
                            companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                            PagerMeasureResult m442measurePagerbmk8ZPk = PagerMeasureKt.m442measurePagerbmk8ZPk(lazyLayoutMeasureScope, function02.invoke().intValue(), invoke, m2577getMaxHeightimpl, i11, i12, mo206roundToPx0680j_45, matchScrollPositionWithKey$foundation_release, currentPageOffset, m2595offsetNN6EwU, orientation, vertical, horizontal, z5, j6, coerceAtLeast, i5, LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(invoke, PagerState.this.getPinnedPages(), PagerState.this.getBeyondBoundsInfo()), snapPosition, PagerState.this.m446getPlacementScopeInvalidatorzYiylxw$foundation_release(), coroutineScope, new Function3<Integer, Integer, Function1<? super Placeable.PlacementScope, ? extends Unit>, MeasureResult>() { // from class: androidx.compose.foundation.pager.PagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1$measureResult$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ MeasureResult invoke(Integer num, Integer num2, Function1<? super Placeable.PlacementScope, ? extends Unit> function1) {
                                    return invoke(num.intValue(), num2.intValue(), (Function1<? super Placeable.PlacementScope, Unit>) function1);
                                }

                                public final MeasureResult invoke(int i13, int i14, Function1<? super Placeable.PlacementScope, Unit> function1) {
                                    return LazyLayoutMeasureScope.this.layout(ConstraintsKt.m2593constrainWidthK40F9xA(j5, i13 + i9), ConstraintsKt.m2592constrainHeightK40F9xA(j5, i14 + i8), MapsKt.emptyMap(), function1);
                                }
                            });
                            PagerState.applyMeasureResult$foundation_release$default(PagerState.this, m442measurePagerbmk8ZPk, false, 2, null);
                            return m442measurePagerbmk8ZPk;
                        } catch (Throwable th) {
                            companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                            throw th;
                        }
                    }
                };
                composer.updateRememberedValue(function23222);
                rememberedValue = function23222;
                Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function222222 = (Function2) rememberedValue;
                if (ComposerKt.isTraceInProgress()) {
                }
                return function222222;
            }
            z7 = true;
            boolean z132 = z12 | z7;
            if (((29360128 & i6) ^ 12582912) <= 8388608) {
            }
            if ((12582912 & i6) != 8388608) {
            }
            z8 = true;
            boolean z1422 = z132 | z8;
            if (((i7 & 14) ^ 6) <= 4) {
            }
            if ((i7 & 6) != 4) {
            }
            z9 = true;
            boolean z15222 = z1422 | z9;
            if (((i7 & 896) ^ 384) <= 256) {
            }
            if ((i7 & 384) != 256) {
            }
            z10 = true;
            boolean z162222 = z10 | z15222;
            if (((458752 & i6) ^ 196608) <= 131072) {
            }
            if ((i6 & 196608) != 131072) {
            }
            z11 = true;
            changed = z162222 | z11 | composer.changed(coroutineScope);
            rememberedValue = composer.rememberedValue();
            if (!changed) {
            }
            Function2<LazyLayoutMeasureScope, Constraints, PagerMeasureResult> function232222 = new Function2<LazyLayoutMeasureScope, Constraints, PagerMeasureResult>() { // from class: androidx.compose.foundation.pager.PagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ PagerMeasureResult invoke(LazyLayoutMeasureScope lazyLayoutMeasureScope, Constraints constraints) {
                    return m444invoke0kLqBqw(lazyLayoutMeasureScope, constraints.getValue());
                }

                /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                public final PagerMeasureResult m444invoke0kLqBqw(final LazyLayoutMeasureScope lazyLayoutMeasureScope, final long j5) {
                    long IntOffset;
                    ObservableScopeInvalidator.m425attachToScopeimpl(PagerState.this.m445getMeasurementScopeInvalidatorzYiylxw$foundation_release());
                    Orientation orientation2 = orientation;
                    Orientation orientation3 = Orientation.Vertical;
                    boolean z17 = orientation2 == orientation3;
                    CheckScrollableContainerConstraintsKt.m118checkScrollableContainerConstraintsK40F9xA(j5, z17 ? orientation3 : Orientation.Horizontal);
                    int mo206roundToPx0680j_4 = z17 ? lazyLayoutMeasureScope.mo206roundToPx0680j_4(paddingValues.mo290calculateLeftPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection())) : lazyLayoutMeasureScope.mo206roundToPx0680j_4(PaddingKt.calculateStartPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                    int mo206roundToPx0680j_42 = z17 ? lazyLayoutMeasureScope.mo206roundToPx0680j_4(paddingValues.mo291calculateRightPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection())) : lazyLayoutMeasureScope.mo206roundToPx0680j_4(PaddingKt.calculateEndPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                    int mo206roundToPx0680j_43 = lazyLayoutMeasureScope.mo206roundToPx0680j_4(paddingValues.getTop());
                    int mo206roundToPx0680j_44 = lazyLayoutMeasureScope.mo206roundToPx0680j_4(paddingValues.getBottom());
                    final int i8 = mo206roundToPx0680j_43 + mo206roundToPx0680j_44;
                    final int i9 = mo206roundToPx0680j_4 + mo206roundToPx0680j_42;
                    int i10 = z17 ? i8 : i9;
                    int i11 = (!z17 || z5) ? (z17 && z5) ? mo206roundToPx0680j_44 : (z17 || z5) ? mo206roundToPx0680j_42 : mo206roundToPx0680j_4 : mo206roundToPx0680j_43;
                    int i12 = i10 - i11;
                    long m2595offsetNN6EwU = ConstraintsKt.m2595offsetNN6EwU(j5, -i9, -i8);
                    PagerState.this.setDensity$foundation_release(lazyLayoutMeasureScope);
                    int mo206roundToPx0680j_45 = lazyLayoutMeasureScope.mo206roundToPx0680j_4(f5);
                    int m2577getMaxHeightimpl = z17 ? Constraints.m2577getMaxHeightimpl(j5) - i8 : Constraints.m2578getMaxWidthimpl(j5) - i9;
                    if (!z5 || m2577getMaxHeightimpl > 0) {
                        IntOffset = IntOffsetKt.IntOffset(mo206roundToPx0680j_4, mo206roundToPx0680j_43);
                    } else {
                        if (!z17) {
                            mo206roundToPx0680j_4 += m2577getMaxHeightimpl;
                        }
                        if (z17) {
                            mo206roundToPx0680j_43 += m2577getMaxHeightimpl;
                        }
                        IntOffset = IntOffsetKt.IntOffset(mo206roundToPx0680j_4, mo206roundToPx0680j_43);
                    }
                    long j6 = IntOffset;
                    int coerceAtLeast = RangesKt.coerceAtLeast(pageSize.calculateMainAxisPageSize(lazyLayoutMeasureScope, m2577getMaxHeightimpl, mo206roundToPx0680j_45), 0);
                    PagerState.this.m448setPremeasureConstraintsBRTryo0$foundation_release(ConstraintsKt.Constraints$default(0, orientation == orientation3 ? Constraints.m2578getMaxWidthimpl(m2595offsetNN6EwU) : coerceAtLeast, 0, orientation != orientation3 ? Constraints.m2577getMaxHeightimpl(m2595offsetNN6EwU) : coerceAtLeast, 5, null));
                    PagerLazyLayoutItemProvider invoke = function0.invoke();
                    Snapshot.Companion companion = Snapshot.INSTANCE;
                    PagerState pagerState2 = PagerState.this;
                    SnapPosition snapPosition2 = snapPosition;
                    Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
                    Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                    Snapshot makeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
                    try {
                        int matchScrollPositionWithKey$foundation_release = pagerState2.matchScrollPositionWithKey$foundation_release(invoke, pagerState2.getCurrentPage());
                        int currentPageOffset = PagerKt.currentPageOffset(snapPosition2, m2577getMaxHeightimpl, coerceAtLeast, mo206roundToPx0680j_45, i11, i12, pagerState2.getCurrentPage(), pagerState2.getCurrentPageOffsetFraction(), pagerState2.getPageCount());
                        Unit unit = Unit.INSTANCE;
                        companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                        PagerMeasureResult m442measurePagerbmk8ZPk = PagerMeasureKt.m442measurePagerbmk8ZPk(lazyLayoutMeasureScope, function02.invoke().intValue(), invoke, m2577getMaxHeightimpl, i11, i12, mo206roundToPx0680j_45, matchScrollPositionWithKey$foundation_release, currentPageOffset, m2595offsetNN6EwU, orientation, vertical, horizontal, z5, j6, coerceAtLeast, i5, LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(invoke, PagerState.this.getPinnedPages(), PagerState.this.getBeyondBoundsInfo()), snapPosition, PagerState.this.m446getPlacementScopeInvalidatorzYiylxw$foundation_release(), coroutineScope, new Function3<Integer, Integer, Function1<? super Placeable.PlacementScope, ? extends Unit>, MeasureResult>() { // from class: androidx.compose.foundation.pager.PagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1$measureResult$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ MeasureResult invoke(Integer num, Integer num2, Function1<? super Placeable.PlacementScope, ? extends Unit> function1) {
                                return invoke(num.intValue(), num2.intValue(), (Function1<? super Placeable.PlacementScope, Unit>) function1);
                            }

                            public final MeasureResult invoke(int i13, int i14, Function1<? super Placeable.PlacementScope, Unit> function1) {
                                return LazyLayoutMeasureScope.this.layout(ConstraintsKt.m2593constrainWidthK40F9xA(j5, i13 + i9), ConstraintsKt.m2592constrainHeightK40F9xA(j5, i14 + i8), MapsKt.emptyMap(), function1);
                            }
                        });
                        PagerState.applyMeasureResult$foundation_release$default(PagerState.this, m442measurePagerbmk8ZPk, false, 2, null);
                        return m442measurePagerbmk8ZPk;
                    } catch (Throwable th) {
                        companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                        throw th;
                    }
                }
            };
            composer.updateRememberedValue(function232222);
            rememberedValue = function232222;
            Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2222222 = (Function2) rememberedValue;
            if (ComposerKt.isTraceInProgress()) {
            }
            return function2222222;
        }
        z6 = true;
        boolean z122 = z6 | ((((i6 & 896) ^ 384) <= 256 && composer.changed(paddingValues)) || (i6 & 384) == 256) | ((((i6 & 7168) ^ 3072) <= 2048 && composer.changed(z5)) || (i6 & 3072) == 2048) | ((((57344 & i6) ^ 24576) <= 16384 && composer.changed(orientation)) || (i6 & 24576) == 16384) | ((((234881024 & i6) ^ 100663296) <= 67108864 && composer.changed(horizontal)) || (i6 & 100663296) == 67108864) | ((((1879048192 & i6) ^ 805306368) <= 536870912 && composer.changed(vertical)) || (i6 & 805306368) == 536870912);
        if (((3670016 & i6) ^ 1572864) <= 1048576) {
        }
        if ((1572864 & i6) != 1048576) {
        }
        z7 = true;
        boolean z1322 = z122 | z7;
        if (((29360128 & i6) ^ 12582912) <= 8388608) {
        }
        if ((12582912 & i6) != 8388608) {
        }
        z8 = true;
        boolean z14222 = z1322 | z8;
        if (((i7 & 14) ^ 6) <= 4) {
        }
        if ((i7 & 6) != 4) {
        }
        z9 = true;
        boolean z152222 = z14222 | z9;
        if (((i7 & 896) ^ 384) <= 256) {
        }
        if ((i7 & 384) != 256) {
        }
        z10 = true;
        boolean z1622222 = z10 | z152222;
        if (((458752 & i6) ^ 196608) <= 131072) {
        }
        if ((i6 & 196608) != 131072) {
        }
        z11 = true;
        changed = z1622222 | z11 | composer.changed(coroutineScope);
        rememberedValue = composer.rememberedValue();
        if (!changed) {
        }
        Function2<LazyLayoutMeasureScope, Constraints, PagerMeasureResult> function2322222 = new Function2<LazyLayoutMeasureScope, Constraints, PagerMeasureResult>() { // from class: androidx.compose.foundation.pager.PagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ PagerMeasureResult invoke(LazyLayoutMeasureScope lazyLayoutMeasureScope, Constraints constraints) {
                return m444invoke0kLqBqw(lazyLayoutMeasureScope, constraints.getValue());
            }

            /* renamed from: invoke-0kLqBqw, reason: not valid java name */
            public final PagerMeasureResult m444invoke0kLqBqw(final LazyLayoutMeasureScope lazyLayoutMeasureScope, final long j5) {
                long IntOffset;
                ObservableScopeInvalidator.m425attachToScopeimpl(PagerState.this.m445getMeasurementScopeInvalidatorzYiylxw$foundation_release());
                Orientation orientation2 = orientation;
                Orientation orientation3 = Orientation.Vertical;
                boolean z17 = orientation2 == orientation3;
                CheckScrollableContainerConstraintsKt.m118checkScrollableContainerConstraintsK40F9xA(j5, z17 ? orientation3 : Orientation.Horizontal);
                int mo206roundToPx0680j_4 = z17 ? lazyLayoutMeasureScope.mo206roundToPx0680j_4(paddingValues.mo290calculateLeftPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection())) : lazyLayoutMeasureScope.mo206roundToPx0680j_4(PaddingKt.calculateStartPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                int mo206roundToPx0680j_42 = z17 ? lazyLayoutMeasureScope.mo206roundToPx0680j_4(paddingValues.mo291calculateRightPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection())) : lazyLayoutMeasureScope.mo206roundToPx0680j_4(PaddingKt.calculateEndPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                int mo206roundToPx0680j_43 = lazyLayoutMeasureScope.mo206roundToPx0680j_4(paddingValues.getTop());
                int mo206roundToPx0680j_44 = lazyLayoutMeasureScope.mo206roundToPx0680j_4(paddingValues.getBottom());
                final int i8 = mo206roundToPx0680j_43 + mo206roundToPx0680j_44;
                final int i9 = mo206roundToPx0680j_4 + mo206roundToPx0680j_42;
                int i10 = z17 ? i8 : i9;
                int i11 = (!z17 || z5) ? (z17 && z5) ? mo206roundToPx0680j_44 : (z17 || z5) ? mo206roundToPx0680j_42 : mo206roundToPx0680j_4 : mo206roundToPx0680j_43;
                int i12 = i10 - i11;
                long m2595offsetNN6EwU = ConstraintsKt.m2595offsetNN6EwU(j5, -i9, -i8);
                PagerState.this.setDensity$foundation_release(lazyLayoutMeasureScope);
                int mo206roundToPx0680j_45 = lazyLayoutMeasureScope.mo206roundToPx0680j_4(f5);
                int m2577getMaxHeightimpl = z17 ? Constraints.m2577getMaxHeightimpl(j5) - i8 : Constraints.m2578getMaxWidthimpl(j5) - i9;
                if (!z5 || m2577getMaxHeightimpl > 0) {
                    IntOffset = IntOffsetKt.IntOffset(mo206roundToPx0680j_4, mo206roundToPx0680j_43);
                } else {
                    if (!z17) {
                        mo206roundToPx0680j_4 += m2577getMaxHeightimpl;
                    }
                    if (z17) {
                        mo206roundToPx0680j_43 += m2577getMaxHeightimpl;
                    }
                    IntOffset = IntOffsetKt.IntOffset(mo206roundToPx0680j_4, mo206roundToPx0680j_43);
                }
                long j6 = IntOffset;
                int coerceAtLeast = RangesKt.coerceAtLeast(pageSize.calculateMainAxisPageSize(lazyLayoutMeasureScope, m2577getMaxHeightimpl, mo206roundToPx0680j_45), 0);
                PagerState.this.m448setPremeasureConstraintsBRTryo0$foundation_release(ConstraintsKt.Constraints$default(0, orientation == orientation3 ? Constraints.m2578getMaxWidthimpl(m2595offsetNN6EwU) : coerceAtLeast, 0, orientation != orientation3 ? Constraints.m2577getMaxHeightimpl(m2595offsetNN6EwU) : coerceAtLeast, 5, null));
                PagerLazyLayoutItemProvider invoke = function0.invoke();
                Snapshot.Companion companion = Snapshot.INSTANCE;
                PagerState pagerState2 = PagerState.this;
                SnapPosition snapPosition2 = snapPosition;
                Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
                Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                Snapshot makeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
                try {
                    int matchScrollPositionWithKey$foundation_release = pagerState2.matchScrollPositionWithKey$foundation_release(invoke, pagerState2.getCurrentPage());
                    int currentPageOffset = PagerKt.currentPageOffset(snapPosition2, m2577getMaxHeightimpl, coerceAtLeast, mo206roundToPx0680j_45, i11, i12, pagerState2.getCurrentPage(), pagerState2.getCurrentPageOffsetFraction(), pagerState2.getPageCount());
                    Unit unit = Unit.INSTANCE;
                    companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                    PagerMeasureResult m442measurePagerbmk8ZPk = PagerMeasureKt.m442measurePagerbmk8ZPk(lazyLayoutMeasureScope, function02.invoke().intValue(), invoke, m2577getMaxHeightimpl, i11, i12, mo206roundToPx0680j_45, matchScrollPositionWithKey$foundation_release, currentPageOffset, m2595offsetNN6EwU, orientation, vertical, horizontal, z5, j6, coerceAtLeast, i5, LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(invoke, PagerState.this.getPinnedPages(), PagerState.this.getBeyondBoundsInfo()), snapPosition, PagerState.this.m446getPlacementScopeInvalidatorzYiylxw$foundation_release(), coroutineScope, new Function3<Integer, Integer, Function1<? super Placeable.PlacementScope, ? extends Unit>, MeasureResult>() { // from class: androidx.compose.foundation.pager.PagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1$measureResult$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ MeasureResult invoke(Integer num, Integer num2, Function1<? super Placeable.PlacementScope, ? extends Unit> function1) {
                            return invoke(num.intValue(), num2.intValue(), (Function1<? super Placeable.PlacementScope, Unit>) function1);
                        }

                        public final MeasureResult invoke(int i13, int i14, Function1<? super Placeable.PlacementScope, Unit> function1) {
                            return LazyLayoutMeasureScope.this.layout(ConstraintsKt.m2593constrainWidthK40F9xA(j5, i13 + i9), ConstraintsKt.m2592constrainHeightK40F9xA(j5, i14 + i8), MapsKt.emptyMap(), function1);
                        }
                    });
                    PagerState.applyMeasureResult$foundation_release$default(PagerState.this, m442measurePagerbmk8ZPk, false, 2, null);
                    return m442measurePagerbmk8ZPk;
                } catch (Throwable th) {
                    companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                    throw th;
                }
            }
        };
        composer.updateRememberedValue(function2322222);
        rememberedValue = function2322222;
        Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function22222222 = (Function2) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
        }
        return function22222222;
    }
}
