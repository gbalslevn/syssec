package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.CheckScrollableContainerConstraintsKt;
import androidx.compose.foundation.ScrollingContainerKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollableDefaults;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsModifierLocalKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsStateKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a{\u0010\u0016\u001a\u00020\u00142\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012H\u0001¢\u0006\u0004\b\u0016\u0010\u0017\u001a{\u0010#\u001a\u0014\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"0\u001f2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0003¢\u0006\u0004\b#\u0010$¨\u0006%"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "state", "Landroidx/compose/foundation/lazy/grid/LazyGridSlotsProvider;", "slots", "Landroidx/compose/foundation/layout/PaddingValues;", "contentPadding", BuildConfig.FLAVOR, "reverseLayout", "isVertical", "Landroidx/compose/foundation/gestures/FlingBehavior;", "flingBehavior", "userScrollEnabled", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "horizontalArrangement", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/grid/LazyGridScope;", BuildConfig.FLAVOR, "content", "LazyGrid", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/foundation/lazy/grid/LazyGridSlotsProvider;Landroidx/compose/foundation/layout/PaddingValues;ZZLandroidx/compose/foundation/gestures/FlingBehavior;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "Lkotlin/Function0;", "Landroidx/compose/foundation/lazy/grid/LazyGridItemProvider;", "itemProviderLambda", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "Landroidx/compose/ui/graphics/GraphicsContext;", "graphicsContext", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "rememberLazyGridMeasurePolicy", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/foundation/lazy/grid/LazyGridSlotsProvider;Landroidx/compose/foundation/layout/PaddingValues;ZZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/ui/graphics/GraphicsContext;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function2;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class LazyGridKt {
    /* JADX WARN: Removed duplicated region for block: B:102:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x030e  */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x025a  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x02fe  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0138  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void LazyGrid(Modifier modifier, final LazyGridState lazyGridState, final LazyGridSlotsProvider lazyGridSlotsProvider, PaddingValues paddingValues, boolean z5, final boolean z6, FlingBehavior flingBehavior, final boolean z7, final Arrangement.Vertical vertical, final Arrangement.Horizontal horizontal, final Function1<? super LazyGridScope, Unit> function1, Composer composer, final int i5, final int i6, final int i7) {
        Modifier modifier2;
        int i8;
        PaddingValues paddingValues2;
        int i9;
        int i10;
        FlingBehavior flingBehavior2;
        Modifier modifier3;
        PaddingValues paddingValues3;
        boolean z8;
        int i11;
        Object rememberedValue;
        Composer composer2;
        final Modifier modifier4;
        final PaddingValues paddingValues4;
        final FlingBehavior flingBehavior3;
        final boolean z9;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-649686062);
        int i12 = i7 & 1;
        if (i12 != 0) {
            i8 = i5 | 6;
            modifier2 = modifier;
        } else if ((i5 & 6) == 0) {
            modifier2 = modifier;
            i8 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i5;
        } else {
            modifier2 = modifier;
            i8 = i5;
        }
        if ((i7 & 2) != 0) {
            i8 |= 48;
        } else if ((i5 & 48) == 0) {
            i8 |= startRestartGroup.changed(lazyGridState) ? 32 : 16;
        }
        if ((i7 & 4) != 0) {
            i8 |= 384;
        } else if ((i5 & 384) == 0) {
            i8 |= (i5 & 512) == 0 ? startRestartGroup.changed(lazyGridSlotsProvider) : startRestartGroup.changedInstance(lazyGridSlotsProvider) ? 256 : 128;
        }
        int i13 = i7 & 8;
        if (i13 != 0) {
            i8 |= 3072;
        } else if ((i5 & 3072) == 0) {
            paddingValues2 = paddingValues;
            i8 |= startRestartGroup.changed(paddingValues2) ? 2048 : 1024;
            i9 = i7 & 16;
            if (i9 == 0) {
                i8 |= 24576;
            } else if ((i5 & 24576) == 0) {
                i8 |= startRestartGroup.changed(z5) ? 16384 : 8192;
                if ((i7 & 32) != 0) {
                    i8 |= 196608;
                } else if ((i5 & 196608) == 0) {
                    i8 |= startRestartGroup.changed(z6) ? 131072 : 65536;
                }
                if ((i5 & 1572864) == 0) {
                    i8 |= ((i7 & 64) == 0 && startRestartGroup.changed(flingBehavior)) ? 1048576 : 524288;
                }
                if ((i7 & 128) != 0) {
                    i8 |= 12582912;
                } else if ((i5 & 12582912) == 0) {
                    i8 |= startRestartGroup.changed(z7) ? 8388608 : 4194304;
                    if ((i7 & 256) == 0) {
                        i8 |= 100663296;
                    } else if ((i5 & 100663296) == 0) {
                        i8 |= startRestartGroup.changed(vertical) ? 67108864 : 33554432;
                        if ((i7 & 512) != 0) {
                            i8 |= 805306368;
                        } else if ((i5 & 805306368) == 0) {
                            i8 |= startRestartGroup.changed(horizontal) ? 536870912 : 268435456;
                            if ((i7 & 1024) == 0) {
                                i10 = i6 | 6;
                            } else if ((i6 & 6) == 0) {
                                i10 = i6 | (startRestartGroup.changedInstance(function1) ? 4 : 2);
                            } else {
                                i10 = i6;
                            }
                            if ((i8 & 306783379) != 306783378 && (i10 & 3) == 2 && startRestartGroup.getSkipping()) {
                                startRestartGroup.skipToGroupEnd();
                                z9 = z5;
                                modifier4 = modifier2;
                                paddingValues4 = paddingValues2;
                                composer2 = startRestartGroup;
                                flingBehavior3 = flingBehavior;
                            } else {
                                startRestartGroup.startDefaults();
                                if ((i5 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                    Modifier modifier5 = i12 == 0 ? Modifier.INSTANCE : modifier2;
                                    PaddingValues m306PaddingValues0680j_4 = i13 == 0 ? PaddingKt.m306PaddingValues0680j_4(Dp.m2599constructorimpl(0)) : paddingValues2;
                                    boolean z10 = i9 == 0 ? false : z5;
                                    if ((i7 & 64) == 0) {
                                        i8 &= -3670017;
                                        modifier3 = modifier5;
                                        paddingValues3 = m306PaddingValues0680j_4;
                                        z8 = z10;
                                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(startRestartGroup, 6);
                                    } else {
                                        flingBehavior2 = flingBehavior;
                                        modifier3 = modifier5;
                                        paddingValues3 = m306PaddingValues0680j_4;
                                        z8 = z10;
                                    }
                                    i11 = i8;
                                } else {
                                    startRestartGroup.skipToGroupEnd();
                                    if ((i7 & 64) != 0) {
                                        i8 &= -3670017;
                                    }
                                    flingBehavior2 = flingBehavior;
                                    modifier3 = modifier2;
                                    i11 = i8;
                                    paddingValues3 = paddingValues2;
                                    z8 = z5;
                                }
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-649686062, i11, i10, "androidx.compose.foundation.lazy.grid.LazyGrid (LazyGrid.kt:77)");
                                }
                                int i14 = i11 >> 3;
                                int i15 = i14 & 14;
                                Function0<LazyGridItemProvider> rememberLazyGridItemProviderLambda = LazyGridItemProviderKt.rememberLazyGridItemProviderLambda(lazyGridState, function1, startRestartGroup, ((i10 << 3) & 112) | i15);
                                int i16 = i11 >> 9;
                                LazyLayoutSemanticState rememberLazyGridSemanticState = LazySemanticsKt.rememberLazyGridSemanticState(lazyGridState, z8, startRestartGroup, (i16 & 112) | i15);
                                rememberedValue = startRestartGroup.rememberedValue();
                                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup));
                                    startRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                                    rememberedValue = compositionScopedCoroutineScopeCanceller;
                                }
                                int i17 = i11 & 112;
                                int i18 = i11 & 57344;
                                int i19 = i11;
                                boolean z11 = z8;
                                Modifier modifier6 = modifier3;
                                Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> rememberLazyGridMeasurePolicy = rememberLazyGridMeasurePolicy(rememberLazyGridItemProviderLambda, lazyGridState, lazyGridSlotsProvider, paddingValues3, z8, z6, horizontal, vertical, ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope(), (GraphicsContext) startRestartGroup.consume(CompositionLocalsKt.getLocalGraphicsContext()), startRestartGroup, (524272 & i11) | (i16 & 3670016) | (29360128 & i14));
                                Orientation orientation = !z6 ? Orientation.Vertical : Orientation.Horizontal;
                                composer2 = startRestartGroup;
                                LazyLayoutKt.LazyLayout(rememberLazyGridItemProviderLambda, ScrollingContainerKt.scrollingContainer(LazyLayoutBeyondBoundsModifierLocalKt.lazyLayoutBeyondBoundsModifier(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier6.then(lazyGridState.getRemeasurementModifier()).then(lazyGridState.getAwaitLayoutModifier()), rememberLazyGridItemProviderLambda, rememberLazyGridSemanticState, orientation, z7, z11, startRestartGroup, (i16 & 57344) | ((i19 << 3) & 458752)), LazyGridBeyondBoundsModifierKt.rememberLazyGridBeyondBoundsState(lazyGridState, startRestartGroup, i15), lazyGridState.getBeyondBoundsInfo(), z11, (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation, z7, startRestartGroup, (MutableVector.$stable << 6) | (i14 & 7168) | (3670016 & i14)).then(lazyGridState.getItemAnimator$foundation_release().getModifier()), lazyGridState, orientation, z7, z11, flingBehavior2, lazyGridState.getInternalInteractionSource(), null, composer2, i17 | ((i19 >> 12) & 7168) | i18 | (458752 & i14), 64), lazyGridState.getPrefetchState(), rememberLazyGridMeasurePolicy, composer2, 0, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier4 = modifier6;
                                paddingValues4 = paddingValues3;
                                flingBehavior3 = flingBehavior2;
                                z9 = z11;
                            }
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup == null) {
                                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$LazyGrid$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                        invoke(composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer3, int i20) {
                                        LazyGridKt.LazyGrid(Modifier.this, lazyGridState, lazyGridSlotsProvider, paddingValues4, z9, z6, flingBehavior3, z7, vertical, horizontal, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), RecomposeScopeImplKt.updateChangedFlags(i6), i7);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        if ((i7 & 1024) == 0) {
                        }
                        if ((i8 & 306783379) != 306783378) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i5 & 1) != 0) {
                        }
                        if (i12 == 0) {
                        }
                        if (i13 == 0) {
                        }
                        if (i9 == 0) {
                        }
                        if ((i7 & 64) == 0) {
                        }
                        i11 = i8;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        int i142 = i11 >> 3;
                        int i152 = i142 & 14;
                        Function0<LazyGridItemProvider> rememberLazyGridItemProviderLambda2 = LazyGridItemProviderKt.rememberLazyGridItemProviderLambda(lazyGridState, function1, startRestartGroup, ((i10 << 3) & 112) | i152);
                        int i162 = i11 >> 9;
                        LazyLayoutSemanticState rememberLazyGridSemanticState2 = LazySemanticsKt.rememberLazyGridSemanticState(lazyGridState, z8, startRestartGroup, (i162 & 112) | i152);
                        rememberedValue = startRestartGroup.rememberedValue();
                        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                        }
                        int i172 = i11 & 112;
                        int i182 = i11 & 57344;
                        int i192 = i11;
                        boolean z112 = z8;
                        Modifier modifier62 = modifier3;
                        Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> rememberLazyGridMeasurePolicy2 = rememberLazyGridMeasurePolicy(rememberLazyGridItemProviderLambda2, lazyGridState, lazyGridSlotsProvider, paddingValues3, z8, z6, horizontal, vertical, ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope(), (GraphicsContext) startRestartGroup.consume(CompositionLocalsKt.getLocalGraphicsContext()), startRestartGroup, (524272 & i11) | (i162 & 3670016) | (29360128 & i142));
                        Orientation orientation2 = !z6 ? Orientation.Vertical : Orientation.Horizontal;
                        composer2 = startRestartGroup;
                        LazyLayoutKt.LazyLayout(rememberLazyGridItemProviderLambda2, ScrollingContainerKt.scrollingContainer(LazyLayoutBeyondBoundsModifierLocalKt.lazyLayoutBeyondBoundsModifier(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier62.then(lazyGridState.getRemeasurementModifier()).then(lazyGridState.getAwaitLayoutModifier()), rememberLazyGridItemProviderLambda2, rememberLazyGridSemanticState2, orientation2, z7, z112, startRestartGroup, (i162 & 57344) | ((i192 << 3) & 458752)), LazyGridBeyondBoundsModifierKt.rememberLazyGridBeyondBoundsState(lazyGridState, startRestartGroup, i152), lazyGridState.getBeyondBoundsInfo(), z112, (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation2, z7, startRestartGroup, (MutableVector.$stable << 6) | (i142 & 7168) | (3670016 & i142)).then(lazyGridState.getItemAnimator$foundation_release().getModifier()), lazyGridState, orientation2, z7, z112, flingBehavior2, lazyGridState.getInternalInteractionSource(), null, composer2, i172 | ((i192 >> 12) & 7168) | i182 | (458752 & i142), 64), lazyGridState.getPrefetchState(), rememberLazyGridMeasurePolicy2, composer2, 0, 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        modifier4 = modifier62;
                        paddingValues4 = paddingValues3;
                        flingBehavior3 = flingBehavior2;
                        z9 = z112;
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    if ((i7 & 512) != 0) {
                    }
                    if ((i7 & 1024) == 0) {
                    }
                    if ((i8 & 306783379) != 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i5 & 1) != 0) {
                    }
                    if (i12 == 0) {
                    }
                    if (i13 == 0) {
                    }
                    if (i9 == 0) {
                    }
                    if ((i7 & 64) == 0) {
                    }
                    i11 = i8;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i1422 = i11 >> 3;
                    int i1522 = i1422 & 14;
                    Function0<LazyGridItemProvider> rememberLazyGridItemProviderLambda22 = LazyGridItemProviderKt.rememberLazyGridItemProviderLambda(lazyGridState, function1, startRestartGroup, ((i10 << 3) & 112) | i1522);
                    int i1622 = i11 >> 9;
                    LazyLayoutSemanticState rememberLazyGridSemanticState22 = LazySemanticsKt.rememberLazyGridSemanticState(lazyGridState, z8, startRestartGroup, (i1622 & 112) | i1522);
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                    }
                    int i1722 = i11 & 112;
                    int i1822 = i11 & 57344;
                    int i1922 = i11;
                    boolean z1122 = z8;
                    Modifier modifier622 = modifier3;
                    Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> rememberLazyGridMeasurePolicy22 = rememberLazyGridMeasurePolicy(rememberLazyGridItemProviderLambda22, lazyGridState, lazyGridSlotsProvider, paddingValues3, z8, z6, horizontal, vertical, ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope(), (GraphicsContext) startRestartGroup.consume(CompositionLocalsKt.getLocalGraphicsContext()), startRestartGroup, (524272 & i11) | (i1622 & 3670016) | (29360128 & i1422));
                    Orientation orientation22 = !z6 ? Orientation.Vertical : Orientation.Horizontal;
                    composer2 = startRestartGroup;
                    LazyLayoutKt.LazyLayout(rememberLazyGridItemProviderLambda22, ScrollingContainerKt.scrollingContainer(LazyLayoutBeyondBoundsModifierLocalKt.lazyLayoutBeyondBoundsModifier(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier622.then(lazyGridState.getRemeasurementModifier()).then(lazyGridState.getAwaitLayoutModifier()), rememberLazyGridItemProviderLambda22, rememberLazyGridSemanticState22, orientation22, z7, z1122, startRestartGroup, (i1622 & 57344) | ((i1922 << 3) & 458752)), LazyGridBeyondBoundsModifierKt.rememberLazyGridBeyondBoundsState(lazyGridState, startRestartGroup, i1522), lazyGridState.getBeyondBoundsInfo(), z1122, (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation22, z7, startRestartGroup, (MutableVector.$stable << 6) | (i1422 & 7168) | (3670016 & i1422)).then(lazyGridState.getItemAnimator$foundation_release().getModifier()), lazyGridState, orientation22, z7, z1122, flingBehavior2, lazyGridState.getInternalInteractionSource(), null, composer2, i1722 | ((i1922 >> 12) & 7168) | i1822 | (458752 & i1422), 64), lazyGridState.getPrefetchState(), rememberLazyGridMeasurePolicy22, composer2, 0, 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier4 = modifier622;
                    paddingValues4 = paddingValues3;
                    flingBehavior3 = flingBehavior2;
                    z9 = z1122;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                if ((i7 & 256) == 0) {
                }
                if ((i7 & 512) != 0) {
                }
                if ((i7 & 1024) == 0) {
                }
                if ((i8 & 306783379) != 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i5 & 1) != 0) {
                }
                if (i12 == 0) {
                }
                if (i13 == 0) {
                }
                if (i9 == 0) {
                }
                if ((i7 & 64) == 0) {
                }
                i11 = i8;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i14222 = i11 >> 3;
                int i15222 = i14222 & 14;
                Function0<LazyGridItemProvider> rememberLazyGridItemProviderLambda222 = LazyGridItemProviderKt.rememberLazyGridItemProviderLambda(lazyGridState, function1, startRestartGroup, ((i10 << 3) & 112) | i15222);
                int i16222 = i11 >> 9;
                LazyLayoutSemanticState rememberLazyGridSemanticState222 = LazySemanticsKt.rememberLazyGridSemanticState(lazyGridState, z8, startRestartGroup, (i16222 & 112) | i15222);
                rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                }
                int i17222 = i11 & 112;
                int i18222 = i11 & 57344;
                int i19222 = i11;
                boolean z11222 = z8;
                Modifier modifier6222 = modifier3;
                Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> rememberLazyGridMeasurePolicy222 = rememberLazyGridMeasurePolicy(rememberLazyGridItemProviderLambda222, lazyGridState, lazyGridSlotsProvider, paddingValues3, z8, z6, horizontal, vertical, ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope(), (GraphicsContext) startRestartGroup.consume(CompositionLocalsKt.getLocalGraphicsContext()), startRestartGroup, (524272 & i11) | (i16222 & 3670016) | (29360128 & i14222));
                Orientation orientation222 = !z6 ? Orientation.Vertical : Orientation.Horizontal;
                composer2 = startRestartGroup;
                LazyLayoutKt.LazyLayout(rememberLazyGridItemProviderLambda222, ScrollingContainerKt.scrollingContainer(LazyLayoutBeyondBoundsModifierLocalKt.lazyLayoutBeyondBoundsModifier(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier6222.then(lazyGridState.getRemeasurementModifier()).then(lazyGridState.getAwaitLayoutModifier()), rememberLazyGridItemProviderLambda222, rememberLazyGridSemanticState222, orientation222, z7, z11222, startRestartGroup, (i16222 & 57344) | ((i19222 << 3) & 458752)), LazyGridBeyondBoundsModifierKt.rememberLazyGridBeyondBoundsState(lazyGridState, startRestartGroup, i15222), lazyGridState.getBeyondBoundsInfo(), z11222, (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation222, z7, startRestartGroup, (MutableVector.$stable << 6) | (i14222 & 7168) | (3670016 & i14222)).then(lazyGridState.getItemAnimator$foundation_release().getModifier()), lazyGridState, orientation222, z7, z11222, flingBehavior2, lazyGridState.getInternalInteractionSource(), null, composer2, i17222 | ((i19222 >> 12) & 7168) | i18222 | (458752 & i14222), 64), lazyGridState.getPrefetchState(), rememberLazyGridMeasurePolicy222, composer2, 0, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier4 = modifier6222;
                paddingValues4 = paddingValues3;
                flingBehavior3 = flingBehavior2;
                z9 = z11222;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            if ((i7 & 32) != 0) {
            }
            if ((i5 & 1572864) == 0) {
            }
            if ((i7 & 128) != 0) {
            }
            if ((i7 & 256) == 0) {
            }
            if ((i7 & 512) != 0) {
            }
            if ((i7 & 1024) == 0) {
            }
            if ((i8 & 306783379) != 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i5 & 1) != 0) {
            }
            if (i12 == 0) {
            }
            if (i13 == 0) {
            }
            if (i9 == 0) {
            }
            if ((i7 & 64) == 0) {
            }
            i11 = i8;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i142222 = i11 >> 3;
            int i152222 = i142222 & 14;
            Function0<LazyGridItemProvider> rememberLazyGridItemProviderLambda2222 = LazyGridItemProviderKt.rememberLazyGridItemProviderLambda(lazyGridState, function1, startRestartGroup, ((i10 << 3) & 112) | i152222);
            int i162222 = i11 >> 9;
            LazyLayoutSemanticState rememberLazyGridSemanticState2222 = LazySemanticsKt.rememberLazyGridSemanticState(lazyGridState, z8, startRestartGroup, (i162222 & 112) | i152222);
            rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            }
            int i172222 = i11 & 112;
            int i182222 = i11 & 57344;
            int i192222 = i11;
            boolean z112222 = z8;
            Modifier modifier62222 = modifier3;
            Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> rememberLazyGridMeasurePolicy2222 = rememberLazyGridMeasurePolicy(rememberLazyGridItemProviderLambda2222, lazyGridState, lazyGridSlotsProvider, paddingValues3, z8, z6, horizontal, vertical, ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope(), (GraphicsContext) startRestartGroup.consume(CompositionLocalsKt.getLocalGraphicsContext()), startRestartGroup, (524272 & i11) | (i162222 & 3670016) | (29360128 & i142222));
            Orientation orientation2222 = !z6 ? Orientation.Vertical : Orientation.Horizontal;
            composer2 = startRestartGroup;
            LazyLayoutKt.LazyLayout(rememberLazyGridItemProviderLambda2222, ScrollingContainerKt.scrollingContainer(LazyLayoutBeyondBoundsModifierLocalKt.lazyLayoutBeyondBoundsModifier(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier62222.then(lazyGridState.getRemeasurementModifier()).then(lazyGridState.getAwaitLayoutModifier()), rememberLazyGridItemProviderLambda2222, rememberLazyGridSemanticState2222, orientation2222, z7, z112222, startRestartGroup, (i162222 & 57344) | ((i192222 << 3) & 458752)), LazyGridBeyondBoundsModifierKt.rememberLazyGridBeyondBoundsState(lazyGridState, startRestartGroup, i152222), lazyGridState.getBeyondBoundsInfo(), z112222, (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation2222, z7, startRestartGroup, (MutableVector.$stable << 6) | (i142222 & 7168) | (3670016 & i142222)).then(lazyGridState.getItemAnimator$foundation_release().getModifier()), lazyGridState, orientation2222, z7, z112222, flingBehavior2, lazyGridState.getInternalInteractionSource(), null, composer2, i172222 | ((i192222 >> 12) & 7168) | i182222 | (458752 & i142222), 64), lazyGridState.getPrefetchState(), rememberLazyGridMeasurePolicy2222, composer2, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier4 = modifier62222;
            paddingValues4 = paddingValues3;
            flingBehavior3 = flingBehavior2;
            z9 = z112222;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        paddingValues2 = paddingValues;
        i9 = i7 & 16;
        if (i9 == 0) {
        }
        if ((i7 & 32) != 0) {
        }
        if ((i5 & 1572864) == 0) {
        }
        if ((i7 & 128) != 0) {
        }
        if ((i7 & 256) == 0) {
        }
        if ((i7 & 512) != 0) {
        }
        if ((i7 & 1024) == 0) {
        }
        if ((i8 & 306783379) != 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i5 & 1) != 0) {
        }
        if (i12 == 0) {
        }
        if (i13 == 0) {
        }
        if (i9 == 0) {
        }
        if ((i7 & 64) == 0) {
        }
        i11 = i8;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i1422222 = i11 >> 3;
        int i1522222 = i1422222 & 14;
        Function0<LazyGridItemProvider> rememberLazyGridItemProviderLambda22222 = LazyGridItemProviderKt.rememberLazyGridItemProviderLambda(lazyGridState, function1, startRestartGroup, ((i10 << 3) & 112) | i1522222);
        int i1622222 = i11 >> 9;
        LazyLayoutSemanticState rememberLazyGridSemanticState22222 = LazySemanticsKt.rememberLazyGridSemanticState(lazyGridState, z8, startRestartGroup, (i1622222 & 112) | i1522222);
        rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
        }
        int i1722222 = i11 & 112;
        int i1822222 = i11 & 57344;
        int i1922222 = i11;
        boolean z1122222 = z8;
        Modifier modifier622222 = modifier3;
        Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> rememberLazyGridMeasurePolicy22222 = rememberLazyGridMeasurePolicy(rememberLazyGridItemProviderLambda22222, lazyGridState, lazyGridSlotsProvider, paddingValues3, z8, z6, horizontal, vertical, ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope(), (GraphicsContext) startRestartGroup.consume(CompositionLocalsKt.getLocalGraphicsContext()), startRestartGroup, (524272 & i11) | (i1622222 & 3670016) | (29360128 & i1422222));
        Orientation orientation22222 = !z6 ? Orientation.Vertical : Orientation.Horizontal;
        composer2 = startRestartGroup;
        LazyLayoutKt.LazyLayout(rememberLazyGridItemProviderLambda22222, ScrollingContainerKt.scrollingContainer(LazyLayoutBeyondBoundsModifierLocalKt.lazyLayoutBeyondBoundsModifier(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier622222.then(lazyGridState.getRemeasurementModifier()).then(lazyGridState.getAwaitLayoutModifier()), rememberLazyGridItemProviderLambda22222, rememberLazyGridSemanticState22222, orientation22222, z7, z1122222, startRestartGroup, (i1622222 & 57344) | ((i1922222 << 3) & 458752)), LazyGridBeyondBoundsModifierKt.rememberLazyGridBeyondBoundsState(lazyGridState, startRestartGroup, i1522222), lazyGridState.getBeyondBoundsInfo(), z1122222, (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation22222, z7, startRestartGroup, (MutableVector.$stable << 6) | (i1422222 & 7168) | (3670016 & i1422222)).then(lazyGridState.getItemAnimator$foundation_release().getModifier()), lazyGridState, orientation22222, z7, z1122222, flingBehavior2, lazyGridState.getInternalInteractionSource(), null, composer2, i1722222 | ((i1922222 >> 12) & 7168) | i1822222 | (458752 & i1422222), 64), lazyGridState.getPrefetchState(), rememberLazyGridMeasurePolicy22222, composer2, 0, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier4 = modifier622222;
        paddingValues4 = paddingValues3;
        flingBehavior3 = flingBehavior2;
        z9 = z1122222;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0023, code lost:
    
        if (r27.changed(r18) != false) goto L13;
     */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ff  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> rememberLazyGridMeasurePolicy(final Function0<? extends LazyGridItemProvider> function0, final LazyGridState lazyGridState, final LazyGridSlotsProvider lazyGridSlotsProvider, final PaddingValues paddingValues, final boolean z5, final boolean z6, final Arrangement.Horizontal horizontal, final Arrangement.Vertical vertical, final CoroutineScope coroutineScope, final GraphicsContext graphicsContext, Composer composer, int i5) {
        boolean z7;
        boolean changed;
        Object rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1585069765, i5, -1, "androidx.compose.foundation.lazy.grid.rememberLazyGridMeasurePolicy (LazyGrid.kt:161)");
        }
        if (((i5 & 112) ^ 48) <= 32) {
        }
        if ((i5 & 48) != 32) {
            z7 = false;
            changed = z7 | ((((i5 & 896) ^ 384) <= 256 && composer.changed(lazyGridSlotsProvider)) || (i5 & 384) == 256) | ((((i5 & 7168) ^ 3072) <= 2048 && composer.changed(paddingValues)) || (i5 & 3072) == 2048) | ((((57344 & i5) ^ 24576) <= 16384 && composer.changed(z5)) || (i5 & 24576) == 16384) | ((((458752 & i5) ^ 196608) <= 131072 && composer.changed(z6)) || (i5 & 196608) == 131072) | ((((3670016 & i5) ^ 1572864) <= 1048576 && composer.changed(horizontal)) || (i5 & 1572864) == 1048576) | ((((29360128 & i5) ^ 12582912) > 8388608 && composer.changed(vertical)) || (i5 & 12582912) == 8388608) | composer.changed(graphicsContext);
            rememberedValue = composer.rememberedValue();
            if (!changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function2<LazyLayoutMeasureScope, Constraints, LazyGridMeasureResult>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ LazyGridMeasureResult invoke(LazyLayoutMeasureScope lazyLayoutMeasureScope, Constraints constraints) {
                        return m393invoke0kLqBqw(lazyLayoutMeasureScope, constraints.getValue());
                    }

                    /* JADX WARN: Type inference failed for: r35v0, types: [androidx.compose.foundation.lazy.grid.LazyGridMeasuredItemProvider, androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1] */
                    /* JADX WARN: Type inference failed for: r9v2, types: [androidx.compose.foundation.lazy.grid.LazyGridMeasuredLineProvider, androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1] */
                    /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                    public final LazyGridMeasureResult m393invoke0kLqBqw(final LazyLayoutMeasureScope lazyLayoutMeasureScope, final long j5) {
                        float spacing;
                        long IntOffset;
                        int lineIndexOfItem;
                        int firstVisibleItemScrollOffset;
                        ObservableScopeInvalidator.m425attachToScopeimpl(LazyGridState.this.m400getMeasurementScopeInvalidatorzYiylxw$foundation_release());
                        CheckScrollableContainerConstraintsKt.m118checkScrollableContainerConstraintsK40F9xA(j5, z6 ? Orientation.Vertical : Orientation.Horizontal);
                        int mo206roundToPx0680j_4 = z6 ? lazyLayoutMeasureScope.mo206roundToPx0680j_4(paddingValues.mo290calculateLeftPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection())) : lazyLayoutMeasureScope.mo206roundToPx0680j_4(PaddingKt.calculateStartPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                        int mo206roundToPx0680j_42 = z6 ? lazyLayoutMeasureScope.mo206roundToPx0680j_4(paddingValues.mo291calculateRightPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection())) : lazyLayoutMeasureScope.mo206roundToPx0680j_4(PaddingKt.calculateEndPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                        int mo206roundToPx0680j_43 = lazyLayoutMeasureScope.mo206roundToPx0680j_4(paddingValues.getTop());
                        int mo206roundToPx0680j_44 = lazyLayoutMeasureScope.mo206roundToPx0680j_4(paddingValues.getBottom());
                        final int i6 = mo206roundToPx0680j_43 + mo206roundToPx0680j_44;
                        final int i7 = mo206roundToPx0680j_4 + mo206roundToPx0680j_42;
                        boolean z8 = z6;
                        int i8 = z8 ? i6 : i7;
                        int i9 = (!z8 || z5) ? (z8 && z5) ? mo206roundToPx0680j_44 : (z8 || z5) ? mo206roundToPx0680j_42 : mo206roundToPx0680j_4 : mo206roundToPx0680j_43;
                        final int i10 = i8 - i9;
                        long m2595offsetNN6EwU = ConstraintsKt.m2595offsetNN6EwU(j5, -i7, -i6);
                        final LazyGridItemProvider invoke = function0.invoke();
                        final LazyGridSpanLayoutProvider spanLayoutProvider = invoke.getSpanLayoutProvider();
                        final LazyGridSlots mo387invoke0kLqBqw = lazyGridSlotsProvider.mo387invoke0kLqBqw(lazyLayoutMeasureScope, j5);
                        int length = mo387invoke0kLqBqw.getSizes().length;
                        spanLayoutProvider.setSlotsPerLine(length);
                        if (z6) {
                            Arrangement.Vertical vertical2 = vertical;
                            if (vertical2 == null) {
                                throw new IllegalArgumentException("null verticalArrangement when isVertical == true");
                            }
                            spacing = vertical2.getSpacing();
                        } else {
                            Arrangement.Horizontal horizontal2 = horizontal;
                            if (horizontal2 == null) {
                                throw new IllegalArgumentException("null horizontalArrangement when isVertical == false");
                            }
                            spacing = horizontal2.getSpacing();
                        }
                        final int mo206roundToPx0680j_45 = lazyLayoutMeasureScope.mo206roundToPx0680j_4(spacing);
                        final int itemCount = invoke.getItemCount();
                        int m2577getMaxHeightimpl = z6 ? Constraints.m2577getMaxHeightimpl(j5) - i6 : Constraints.m2578getMaxWidthimpl(j5) - i7;
                        if (!z5 || m2577getMaxHeightimpl > 0) {
                            IntOffset = IntOffsetKt.IntOffset(mo206roundToPx0680j_4, mo206roundToPx0680j_43);
                        } else {
                            boolean z9 = z6;
                            if (!z9) {
                                mo206roundToPx0680j_4 += m2577getMaxHeightimpl;
                            }
                            if (z9) {
                                mo206roundToPx0680j_43 += m2577getMaxHeightimpl;
                            }
                            IntOffset = IntOffsetKt.IntOffset(mo206roundToPx0680j_4, mo206roundToPx0680j_43);
                        }
                        final long j6 = IntOffset;
                        final LazyGridState lazyGridState2 = LazyGridState.this;
                        final boolean z10 = z6;
                        final boolean z11 = z5;
                        final int i11 = i9;
                        final ?? r35 = new LazyGridMeasuredItemProvider(invoke, lazyLayoutMeasureScope, mo206roundToPx0680j_45, lazyGridState2, z10, z11, i11, i10, j6) { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1
                            final /* synthetic */ int $afterContentPadding;
                            final /* synthetic */ int $beforeContentPadding;
                            final /* synthetic */ boolean $isVertical;
                            final /* synthetic */ boolean $reverseLayout;
                            final /* synthetic */ LazyGridState $state;
                            final /* synthetic */ LazyLayoutMeasureScope $this_null;
                            final /* synthetic */ long $visualItemOffset;

                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                this.$this_null = lazyLayoutMeasureScope;
                                this.$state = lazyGridState2;
                                this.$isVertical = z10;
                                this.$reverseLayout = z11;
                                this.$beforeContentPadding = i11;
                                this.$afterContentPadding = i10;
                                this.$visualItemOffset = j6;
                            }

                            @Override // androidx.compose.foundation.lazy.grid.LazyGridMeasuredItemProvider
                            /* renamed from: createItem-O3s9Psw, reason: not valid java name */
                            public LazyGridMeasuredItem mo394createItemO3s9Psw(int index, Object key, Object contentType, int crossAxisSize, int mainAxisSpacing, List<? extends Placeable> placeables, long constraints, int lane, int span) {
                                return new LazyGridMeasuredItem(index, key, this.$isVertical, crossAxisSize, mainAxisSpacing, this.$reverseLayout, this.$this_null.getLayoutDirection(), this.$beforeContentPadding, this.$afterContentPadding, placeables, this.$visualItemOffset, contentType, this.$state.getItemAnimator$foundation_release(), constraints, lane, span, null);
                            }
                        };
                        final boolean z12 = z6;
                        final ?? r9 = new LazyGridMeasuredLineProvider(z12, mo387invoke0kLqBqw, itemCount, mo206roundToPx0680j_45, r35, spanLayoutProvider) { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1
                            final /* synthetic */ boolean $isVertical;
                            final /* synthetic */ LazyGridSlots $resolvedSlots;

                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(z12, mo387invoke0kLqBqw, itemCount, mo206roundToPx0680j_45, r35, spanLayoutProvider);
                                this.$isVertical = z12;
                                this.$resolvedSlots = mo387invoke0kLqBqw;
                            }

                            @Override // androidx.compose.foundation.lazy.grid.LazyGridMeasuredLineProvider
                            public LazyGridMeasuredLine createLine(int index, LazyGridMeasuredItem[] items, List<GridItemSpan> spans, int mainAxisSpacing) {
                                return new LazyGridMeasuredLine(index, items, this.$resolvedSlots, spans, this.$isVertical, mainAxisSpacing);
                            }
                        };
                        Function1<Integer, ArrayList<Pair<? extends Integer, ? extends Constraints>>> function1 = new Function1<Integer, ArrayList<Pair<? extends Integer, ? extends Constraints>>>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$prefetchInfoRetriever$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ ArrayList<Pair<? extends Integer, ? extends Constraints>> invoke(Integer num) {
                                return invoke(num.intValue());
                            }

                            public final ArrayList<Pair<Integer, Constraints>> invoke(int i12) {
                                LazyGridSpanLayoutProvider.LineConfiguration lineConfiguration = LazyGridSpanLayoutProvider.this.getLineConfiguration(i12);
                                int firstItemIndex = lineConfiguration.getFirstItemIndex();
                                ArrayList<Pair<Integer, Constraints>> arrayList = new ArrayList<>(lineConfiguration.getSpans().size());
                                List<GridItemSpan> spans = lineConfiguration.getSpans();
                                LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1 lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1 = r9;
                                int size = spans.size();
                                int i13 = 0;
                                for (int i14 = 0; i14 < size; i14++) {
                                    int m383getCurrentLineSpanimpl = GridItemSpan.m383getCurrentLineSpanimpl(spans.get(i14).getPackedValue());
                                    arrayList.add(TuplesKt.to(Integer.valueOf(firstItemIndex), Constraints.m2567boximpl(lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1.m399childConstraintsJhjzzOo$foundation_release(i13, m383getCurrentLineSpanimpl))));
                                    firstItemIndex++;
                                    i13 += m383getCurrentLineSpanimpl;
                                }
                                return arrayList;
                            }
                        };
                        Snapshot.Companion companion = Snapshot.INSTANCE;
                        LazyGridState lazyGridState3 = LazyGridState.this;
                        Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
                        Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                        Snapshot makeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
                        try {
                            int updateScrollPositionIfTheFirstItemWasMoved$foundation_release = lazyGridState3.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(invoke, lazyGridState3.getFirstVisibleItemIndex());
                            if (updateScrollPositionIfTheFirstItemWasMoved$foundation_release >= itemCount && itemCount > 0) {
                                lineIndexOfItem = spanLayoutProvider.getLineIndexOfItem(itemCount - 1);
                                firstVisibleItemScrollOffset = 0;
                                Unit unit = Unit.INSTANCE;
                                companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                                LazyGridMeasureResult m396measureLazyGridOZKpZRA = LazyGridMeasureKt.m396measureLazyGridOZKpZRA(itemCount, r9, r35, m2577getMaxHeightimpl, i9, i10, mo206roundToPx0680j_45, lineIndexOfItem, firstVisibleItemScrollOffset, LazyGridState.this.getScrollToBeConsumed(), m2595offsetNN6EwU, z6, vertical, horizontal, z5, lazyLayoutMeasureScope, LazyGridState.this.getItemAnimator$foundation_release(), length, LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(invoke, LazyGridState.this.getPinnedItems(), LazyGridState.this.getBeyondBoundsInfo()), coroutineScope, LazyGridState.this.m401getPlacementScopeInvalidatorzYiylxw$foundation_release(), graphicsContext, function1, new Function3<Integer, Integer, Function1<? super Placeable.PlacementScope, ? extends Unit>, MeasureResult>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measureResult$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ MeasureResult invoke(Integer num, Integer num2, Function1<? super Placeable.PlacementScope, ? extends Unit> function12) {
                                        return invoke(num.intValue(), num2.intValue(), (Function1<? super Placeable.PlacementScope, Unit>) function12);
                                    }

                                    public final MeasureResult invoke(int i12, int i13, Function1<? super Placeable.PlacementScope, Unit> function12) {
                                        return LazyLayoutMeasureScope.this.layout(ConstraintsKt.m2593constrainWidthK40F9xA(j5, i12 + i7), ConstraintsKt.m2592constrainHeightK40F9xA(j5, i13 + i6), MapsKt.emptyMap(), function12);
                                    }
                                });
                                LazyGridState.applyMeasureResult$foundation_release$default(LazyGridState.this, m396measureLazyGridOZKpZRA, false, 2, null);
                                return m396measureLazyGridOZKpZRA;
                            }
                            lineIndexOfItem = spanLayoutProvider.getLineIndexOfItem(updateScrollPositionIfTheFirstItemWasMoved$foundation_release);
                            firstVisibleItemScrollOffset = lazyGridState3.getFirstVisibleItemScrollOffset();
                            Unit unit2 = Unit.INSTANCE;
                            companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                            LazyGridMeasureResult m396measureLazyGridOZKpZRA2 = LazyGridMeasureKt.m396measureLazyGridOZKpZRA(itemCount, r9, r35, m2577getMaxHeightimpl, i9, i10, mo206roundToPx0680j_45, lineIndexOfItem, firstVisibleItemScrollOffset, LazyGridState.this.getScrollToBeConsumed(), m2595offsetNN6EwU, z6, vertical, horizontal, z5, lazyLayoutMeasureScope, LazyGridState.this.getItemAnimator$foundation_release(), length, LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(invoke, LazyGridState.this.getPinnedItems(), LazyGridState.this.getBeyondBoundsInfo()), coroutineScope, LazyGridState.this.m401getPlacementScopeInvalidatorzYiylxw$foundation_release(), graphicsContext, function1, new Function3<Integer, Integer, Function1<? super Placeable.PlacementScope, ? extends Unit>, MeasureResult>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measureResult$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ MeasureResult invoke(Integer num, Integer num2, Function1<? super Placeable.PlacementScope, ? extends Unit> function12) {
                                    return invoke(num.intValue(), num2.intValue(), (Function1<? super Placeable.PlacementScope, Unit>) function12);
                                }

                                public final MeasureResult invoke(int i12, int i13, Function1<? super Placeable.PlacementScope, Unit> function12) {
                                    return LazyLayoutMeasureScope.this.layout(ConstraintsKt.m2593constrainWidthK40F9xA(j5, i12 + i7), ConstraintsKt.m2592constrainHeightK40F9xA(j5, i13 + i6), MapsKt.emptyMap(), function12);
                                }
                            });
                            LazyGridState.applyMeasureResult$foundation_release$default(LazyGridState.this, m396measureLazyGridOZKpZRA2, false, 2, null);
                            return m396measureLazyGridOZKpZRA2;
                        } catch (Throwable th) {
                            companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                            throw th;
                        }
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2 = (Function2) rememberedValue;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            return function2;
        }
        z7 = true;
        if (((29360128 & i5) ^ 12582912) > 8388608) {
            changed = z7 | ((((i5 & 896) ^ 384) <= 256 && composer.changed(lazyGridSlotsProvider)) || (i5 & 384) == 256) | ((((i5 & 7168) ^ 3072) <= 2048 && composer.changed(paddingValues)) || (i5 & 3072) == 2048) | ((((57344 & i5) ^ 24576) <= 16384 && composer.changed(z5)) || (i5 & 24576) == 16384) | ((((458752 & i5) ^ 196608) <= 131072 && composer.changed(z6)) || (i5 & 196608) == 131072) | ((((3670016 & i5) ^ 1572864) <= 1048576 && composer.changed(horizontal)) || (i5 & 1572864) == 1048576) | ((((29360128 & i5) ^ 12582912) > 8388608 && composer.changed(vertical)) || (i5 & 12582912) == 8388608) | composer.changed(graphicsContext);
            rememberedValue = composer.rememberedValue();
            if (!changed) {
            }
            rememberedValue = new Function2<LazyLayoutMeasureScope, Constraints, LazyGridMeasureResult>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ LazyGridMeasureResult invoke(LazyLayoutMeasureScope lazyLayoutMeasureScope, Constraints constraints) {
                    return m393invoke0kLqBqw(lazyLayoutMeasureScope, constraints.getValue());
                }

                /* JADX WARN: Type inference failed for: r35v0, types: [androidx.compose.foundation.lazy.grid.LazyGridMeasuredItemProvider, androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1] */
                /* JADX WARN: Type inference failed for: r9v2, types: [androidx.compose.foundation.lazy.grid.LazyGridMeasuredLineProvider, androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1] */
                /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                public final LazyGridMeasureResult m393invoke0kLqBqw(final LazyLayoutMeasureScope lazyLayoutMeasureScope, final long j5) {
                    float spacing;
                    long IntOffset;
                    int lineIndexOfItem;
                    int firstVisibleItemScrollOffset;
                    ObservableScopeInvalidator.m425attachToScopeimpl(LazyGridState.this.m400getMeasurementScopeInvalidatorzYiylxw$foundation_release());
                    CheckScrollableContainerConstraintsKt.m118checkScrollableContainerConstraintsK40F9xA(j5, z6 ? Orientation.Vertical : Orientation.Horizontal);
                    int mo206roundToPx0680j_4 = z6 ? lazyLayoutMeasureScope.mo206roundToPx0680j_4(paddingValues.mo290calculateLeftPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection())) : lazyLayoutMeasureScope.mo206roundToPx0680j_4(PaddingKt.calculateStartPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                    int mo206roundToPx0680j_42 = z6 ? lazyLayoutMeasureScope.mo206roundToPx0680j_4(paddingValues.mo291calculateRightPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection())) : lazyLayoutMeasureScope.mo206roundToPx0680j_4(PaddingKt.calculateEndPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                    int mo206roundToPx0680j_43 = lazyLayoutMeasureScope.mo206roundToPx0680j_4(paddingValues.getTop());
                    int mo206roundToPx0680j_44 = lazyLayoutMeasureScope.mo206roundToPx0680j_4(paddingValues.getBottom());
                    final int i6 = mo206roundToPx0680j_43 + mo206roundToPx0680j_44;
                    final int i7 = mo206roundToPx0680j_4 + mo206roundToPx0680j_42;
                    boolean z8 = z6;
                    int i8 = z8 ? i6 : i7;
                    int i9 = (!z8 || z5) ? (z8 && z5) ? mo206roundToPx0680j_44 : (z8 || z5) ? mo206roundToPx0680j_42 : mo206roundToPx0680j_4 : mo206roundToPx0680j_43;
                    final int i10 = i8 - i9;
                    long m2595offsetNN6EwU = ConstraintsKt.m2595offsetNN6EwU(j5, -i7, -i6);
                    final LazyGridItemProvider invoke = function0.invoke();
                    final LazyGridSpanLayoutProvider spanLayoutProvider = invoke.getSpanLayoutProvider();
                    final LazyGridSlots mo387invoke0kLqBqw = lazyGridSlotsProvider.mo387invoke0kLqBqw(lazyLayoutMeasureScope, j5);
                    int length = mo387invoke0kLqBqw.getSizes().length;
                    spanLayoutProvider.setSlotsPerLine(length);
                    if (z6) {
                        Arrangement.Vertical vertical2 = vertical;
                        if (vertical2 == null) {
                            throw new IllegalArgumentException("null verticalArrangement when isVertical == true");
                        }
                        spacing = vertical2.getSpacing();
                    } else {
                        Arrangement.Horizontal horizontal2 = horizontal;
                        if (horizontal2 == null) {
                            throw new IllegalArgumentException("null horizontalArrangement when isVertical == false");
                        }
                        spacing = horizontal2.getSpacing();
                    }
                    final int mo206roundToPx0680j_45 = lazyLayoutMeasureScope.mo206roundToPx0680j_4(spacing);
                    final int itemCount = invoke.getItemCount();
                    int m2577getMaxHeightimpl = z6 ? Constraints.m2577getMaxHeightimpl(j5) - i6 : Constraints.m2578getMaxWidthimpl(j5) - i7;
                    if (!z5 || m2577getMaxHeightimpl > 0) {
                        IntOffset = IntOffsetKt.IntOffset(mo206roundToPx0680j_4, mo206roundToPx0680j_43);
                    } else {
                        boolean z9 = z6;
                        if (!z9) {
                            mo206roundToPx0680j_4 += m2577getMaxHeightimpl;
                        }
                        if (z9) {
                            mo206roundToPx0680j_43 += m2577getMaxHeightimpl;
                        }
                        IntOffset = IntOffsetKt.IntOffset(mo206roundToPx0680j_4, mo206roundToPx0680j_43);
                    }
                    final long j6 = IntOffset;
                    final LazyGridState lazyGridState2 = LazyGridState.this;
                    final boolean z10 = z6;
                    final boolean z11 = z5;
                    final int i11 = i9;
                    final LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1 r35 = new LazyGridMeasuredItemProvider(invoke, lazyLayoutMeasureScope, mo206roundToPx0680j_45, lazyGridState2, z10, z11, i11, i10, j6) { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1
                        final /* synthetic */ int $afterContentPadding;
                        final /* synthetic */ int $beforeContentPadding;
                        final /* synthetic */ boolean $isVertical;
                        final /* synthetic */ boolean $reverseLayout;
                        final /* synthetic */ LazyGridState $state;
                        final /* synthetic */ LazyLayoutMeasureScope $this_null;
                        final /* synthetic */ long $visualItemOffset;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.$this_null = lazyLayoutMeasureScope;
                            this.$state = lazyGridState2;
                            this.$isVertical = z10;
                            this.$reverseLayout = z11;
                            this.$beforeContentPadding = i11;
                            this.$afterContentPadding = i10;
                            this.$visualItemOffset = j6;
                        }

                        @Override // androidx.compose.foundation.lazy.grid.LazyGridMeasuredItemProvider
                        /* renamed from: createItem-O3s9Psw, reason: not valid java name */
                        public LazyGridMeasuredItem mo394createItemO3s9Psw(int index, Object key, Object contentType, int crossAxisSize, int mainAxisSpacing, List<? extends Placeable> placeables, long constraints, int lane, int span) {
                            return new LazyGridMeasuredItem(index, key, this.$isVertical, crossAxisSize, mainAxisSpacing, this.$reverseLayout, this.$this_null.getLayoutDirection(), this.$beforeContentPadding, this.$afterContentPadding, placeables, this.$visualItemOffset, contentType, this.$state.getItemAnimator$foundation_release(), constraints, lane, span, null);
                        }
                    };
                    final boolean z12 = z6;
                    final LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1 r9 = new LazyGridMeasuredLineProvider(z12, mo387invoke0kLqBqw, itemCount, mo206roundToPx0680j_45, r35, spanLayoutProvider) { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1
                        final /* synthetic */ boolean $isVertical;
                        final /* synthetic */ LazyGridSlots $resolvedSlots;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(z12, mo387invoke0kLqBqw, itemCount, mo206roundToPx0680j_45, r35, spanLayoutProvider);
                            this.$isVertical = z12;
                            this.$resolvedSlots = mo387invoke0kLqBqw;
                        }

                        @Override // androidx.compose.foundation.lazy.grid.LazyGridMeasuredLineProvider
                        public LazyGridMeasuredLine createLine(int index, LazyGridMeasuredItem[] items, List<GridItemSpan> spans, int mainAxisSpacing) {
                            return new LazyGridMeasuredLine(index, items, this.$resolvedSlots, spans, this.$isVertical, mainAxisSpacing);
                        }
                    };
                    Function1<Integer, ArrayList<Pair<? extends Integer, ? extends Constraints>>> function1 = new Function1<Integer, ArrayList<Pair<? extends Integer, ? extends Constraints>>>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$prefetchInfoRetriever$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ ArrayList<Pair<? extends Integer, ? extends Constraints>> invoke(Integer num) {
                            return invoke(num.intValue());
                        }

                        public final ArrayList<Pair<Integer, Constraints>> invoke(int i12) {
                            LazyGridSpanLayoutProvider.LineConfiguration lineConfiguration = LazyGridSpanLayoutProvider.this.getLineConfiguration(i12);
                            int firstItemIndex = lineConfiguration.getFirstItemIndex();
                            ArrayList<Pair<Integer, Constraints>> arrayList = new ArrayList<>(lineConfiguration.getSpans().size());
                            List<GridItemSpan> spans = lineConfiguration.getSpans();
                            LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1 lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1 = r9;
                            int size = spans.size();
                            int i13 = 0;
                            for (int i14 = 0; i14 < size; i14++) {
                                int m383getCurrentLineSpanimpl = GridItemSpan.m383getCurrentLineSpanimpl(spans.get(i14).getPackedValue());
                                arrayList.add(TuplesKt.to(Integer.valueOf(firstItemIndex), Constraints.m2567boximpl(lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1.m399childConstraintsJhjzzOo$foundation_release(i13, m383getCurrentLineSpanimpl))));
                                firstItemIndex++;
                                i13 += m383getCurrentLineSpanimpl;
                            }
                            return arrayList;
                        }
                    };
                    Snapshot.Companion companion = Snapshot.INSTANCE;
                    LazyGridState lazyGridState3 = LazyGridState.this;
                    Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
                    Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                    Snapshot makeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
                    try {
                        int updateScrollPositionIfTheFirstItemWasMoved$foundation_release = lazyGridState3.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(invoke, lazyGridState3.getFirstVisibleItemIndex());
                        if (updateScrollPositionIfTheFirstItemWasMoved$foundation_release >= itemCount && itemCount > 0) {
                            lineIndexOfItem = spanLayoutProvider.getLineIndexOfItem(itemCount - 1);
                            firstVisibleItemScrollOffset = 0;
                            Unit unit2 = Unit.INSTANCE;
                            companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                            LazyGridMeasureResult m396measureLazyGridOZKpZRA2 = LazyGridMeasureKt.m396measureLazyGridOZKpZRA(itemCount, r9, r35, m2577getMaxHeightimpl, i9, i10, mo206roundToPx0680j_45, lineIndexOfItem, firstVisibleItemScrollOffset, LazyGridState.this.getScrollToBeConsumed(), m2595offsetNN6EwU, z6, vertical, horizontal, z5, lazyLayoutMeasureScope, LazyGridState.this.getItemAnimator$foundation_release(), length, LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(invoke, LazyGridState.this.getPinnedItems(), LazyGridState.this.getBeyondBoundsInfo()), coroutineScope, LazyGridState.this.m401getPlacementScopeInvalidatorzYiylxw$foundation_release(), graphicsContext, function1, new Function3<Integer, Integer, Function1<? super Placeable.PlacementScope, ? extends Unit>, MeasureResult>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measureResult$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ MeasureResult invoke(Integer num, Integer num2, Function1<? super Placeable.PlacementScope, ? extends Unit> function12) {
                                    return invoke(num.intValue(), num2.intValue(), (Function1<? super Placeable.PlacementScope, Unit>) function12);
                                }

                                public final MeasureResult invoke(int i12, int i13, Function1<? super Placeable.PlacementScope, Unit> function12) {
                                    return LazyLayoutMeasureScope.this.layout(ConstraintsKt.m2593constrainWidthK40F9xA(j5, i12 + i7), ConstraintsKt.m2592constrainHeightK40F9xA(j5, i13 + i6), MapsKt.emptyMap(), function12);
                                }
                            });
                            LazyGridState.applyMeasureResult$foundation_release$default(LazyGridState.this, m396measureLazyGridOZKpZRA2, false, 2, null);
                            return m396measureLazyGridOZKpZRA2;
                        }
                        lineIndexOfItem = spanLayoutProvider.getLineIndexOfItem(updateScrollPositionIfTheFirstItemWasMoved$foundation_release);
                        firstVisibleItemScrollOffset = lazyGridState3.getFirstVisibleItemScrollOffset();
                        Unit unit22 = Unit.INSTANCE;
                        companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                        LazyGridMeasureResult m396measureLazyGridOZKpZRA22 = LazyGridMeasureKt.m396measureLazyGridOZKpZRA(itemCount, r9, r35, m2577getMaxHeightimpl, i9, i10, mo206roundToPx0680j_45, lineIndexOfItem, firstVisibleItemScrollOffset, LazyGridState.this.getScrollToBeConsumed(), m2595offsetNN6EwU, z6, vertical, horizontal, z5, lazyLayoutMeasureScope, LazyGridState.this.getItemAnimator$foundation_release(), length, LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(invoke, LazyGridState.this.getPinnedItems(), LazyGridState.this.getBeyondBoundsInfo()), coroutineScope, LazyGridState.this.m401getPlacementScopeInvalidatorzYiylxw$foundation_release(), graphicsContext, function1, new Function3<Integer, Integer, Function1<? super Placeable.PlacementScope, ? extends Unit>, MeasureResult>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measureResult$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ MeasureResult invoke(Integer num, Integer num2, Function1<? super Placeable.PlacementScope, ? extends Unit> function12) {
                                return invoke(num.intValue(), num2.intValue(), (Function1<? super Placeable.PlacementScope, Unit>) function12);
                            }

                            public final MeasureResult invoke(int i12, int i13, Function1<? super Placeable.PlacementScope, Unit> function12) {
                                return LazyLayoutMeasureScope.this.layout(ConstraintsKt.m2593constrainWidthK40F9xA(j5, i12 + i7), ConstraintsKt.m2592constrainHeightK40F9xA(j5, i13 + i6), MapsKt.emptyMap(), function12);
                            }
                        });
                        LazyGridState.applyMeasureResult$foundation_release$default(LazyGridState.this, m396measureLazyGridOZKpZRA22, false, 2, null);
                        return m396measureLazyGridOZKpZRA22;
                    } catch (Throwable th) {
                        companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                        throw th;
                    }
                }
            };
            composer.updateRememberedValue(rememberedValue);
            Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function22 = (Function2) rememberedValue;
            if (ComposerKt.isTraceInProgress()) {
            }
            return function22;
        }
        changed = z7 | ((((i5 & 896) ^ 384) <= 256 && composer.changed(lazyGridSlotsProvider)) || (i5 & 384) == 256) | ((((i5 & 7168) ^ 3072) <= 2048 && composer.changed(paddingValues)) || (i5 & 3072) == 2048) | ((((57344 & i5) ^ 24576) <= 16384 && composer.changed(z5)) || (i5 & 24576) == 16384) | ((((458752 & i5) ^ 196608) <= 131072 && composer.changed(z6)) || (i5 & 196608) == 131072) | ((((3670016 & i5) ^ 1572864) <= 1048576 && composer.changed(horizontal)) || (i5 & 1572864) == 1048576) | ((((29360128 & i5) ^ 12582912) > 8388608 && composer.changed(vertical)) || (i5 & 12582912) == 8388608) | composer.changed(graphicsContext);
        rememberedValue = composer.rememberedValue();
        if (!changed) {
        }
        rememberedValue = new Function2<LazyLayoutMeasureScope, Constraints, LazyGridMeasureResult>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ LazyGridMeasureResult invoke(LazyLayoutMeasureScope lazyLayoutMeasureScope, Constraints constraints) {
                return m393invoke0kLqBqw(lazyLayoutMeasureScope, constraints.getValue());
            }

            /* JADX WARN: Type inference failed for: r35v0, types: [androidx.compose.foundation.lazy.grid.LazyGridMeasuredItemProvider, androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1] */
            /* JADX WARN: Type inference failed for: r9v2, types: [androidx.compose.foundation.lazy.grid.LazyGridMeasuredLineProvider, androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1] */
            /* renamed from: invoke-0kLqBqw, reason: not valid java name */
            public final LazyGridMeasureResult m393invoke0kLqBqw(final LazyLayoutMeasureScope lazyLayoutMeasureScope, final long j5) {
                float spacing;
                long IntOffset;
                int lineIndexOfItem;
                int firstVisibleItemScrollOffset;
                ObservableScopeInvalidator.m425attachToScopeimpl(LazyGridState.this.m400getMeasurementScopeInvalidatorzYiylxw$foundation_release());
                CheckScrollableContainerConstraintsKt.m118checkScrollableContainerConstraintsK40F9xA(j5, z6 ? Orientation.Vertical : Orientation.Horizontal);
                int mo206roundToPx0680j_4 = z6 ? lazyLayoutMeasureScope.mo206roundToPx0680j_4(paddingValues.mo290calculateLeftPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection())) : lazyLayoutMeasureScope.mo206roundToPx0680j_4(PaddingKt.calculateStartPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                int mo206roundToPx0680j_42 = z6 ? lazyLayoutMeasureScope.mo206roundToPx0680j_4(paddingValues.mo291calculateRightPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection())) : lazyLayoutMeasureScope.mo206roundToPx0680j_4(PaddingKt.calculateEndPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                int mo206roundToPx0680j_43 = lazyLayoutMeasureScope.mo206roundToPx0680j_4(paddingValues.getTop());
                int mo206roundToPx0680j_44 = lazyLayoutMeasureScope.mo206roundToPx0680j_4(paddingValues.getBottom());
                final int i6 = mo206roundToPx0680j_43 + mo206roundToPx0680j_44;
                final int i7 = mo206roundToPx0680j_4 + mo206roundToPx0680j_42;
                boolean z8 = z6;
                int i8 = z8 ? i6 : i7;
                int i9 = (!z8 || z5) ? (z8 && z5) ? mo206roundToPx0680j_44 : (z8 || z5) ? mo206roundToPx0680j_42 : mo206roundToPx0680j_4 : mo206roundToPx0680j_43;
                final int i10 = i8 - i9;
                long m2595offsetNN6EwU = ConstraintsKt.m2595offsetNN6EwU(j5, -i7, -i6);
                final LazyGridItemProvider invoke = function0.invoke();
                final LazyGridSpanLayoutProvider spanLayoutProvider = invoke.getSpanLayoutProvider();
                final LazyGridSlots mo387invoke0kLqBqw = lazyGridSlotsProvider.mo387invoke0kLqBqw(lazyLayoutMeasureScope, j5);
                int length = mo387invoke0kLqBqw.getSizes().length;
                spanLayoutProvider.setSlotsPerLine(length);
                if (z6) {
                    Arrangement.Vertical vertical2 = vertical;
                    if (vertical2 == null) {
                        throw new IllegalArgumentException("null verticalArrangement when isVertical == true");
                    }
                    spacing = vertical2.getSpacing();
                } else {
                    Arrangement.Horizontal horizontal2 = horizontal;
                    if (horizontal2 == null) {
                        throw new IllegalArgumentException("null horizontalArrangement when isVertical == false");
                    }
                    spacing = horizontal2.getSpacing();
                }
                final int mo206roundToPx0680j_45 = lazyLayoutMeasureScope.mo206roundToPx0680j_4(spacing);
                final int itemCount = invoke.getItemCount();
                int m2577getMaxHeightimpl = z6 ? Constraints.m2577getMaxHeightimpl(j5) - i6 : Constraints.m2578getMaxWidthimpl(j5) - i7;
                if (!z5 || m2577getMaxHeightimpl > 0) {
                    IntOffset = IntOffsetKt.IntOffset(mo206roundToPx0680j_4, mo206roundToPx0680j_43);
                } else {
                    boolean z9 = z6;
                    if (!z9) {
                        mo206roundToPx0680j_4 += m2577getMaxHeightimpl;
                    }
                    if (z9) {
                        mo206roundToPx0680j_43 += m2577getMaxHeightimpl;
                    }
                    IntOffset = IntOffsetKt.IntOffset(mo206roundToPx0680j_4, mo206roundToPx0680j_43);
                }
                final long j6 = IntOffset;
                final LazyGridState lazyGridState2 = LazyGridState.this;
                final boolean z10 = z6;
                final boolean z11 = z5;
                final int i11 = i9;
                final LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1 r35 = new LazyGridMeasuredItemProvider(invoke, lazyLayoutMeasureScope, mo206roundToPx0680j_45, lazyGridState2, z10, z11, i11, i10, j6) { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1
                    final /* synthetic */ int $afterContentPadding;
                    final /* synthetic */ int $beforeContentPadding;
                    final /* synthetic */ boolean $isVertical;
                    final /* synthetic */ boolean $reverseLayout;
                    final /* synthetic */ LazyGridState $state;
                    final /* synthetic */ LazyLayoutMeasureScope $this_null;
                    final /* synthetic */ long $visualItemOffset;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.$this_null = lazyLayoutMeasureScope;
                        this.$state = lazyGridState2;
                        this.$isVertical = z10;
                        this.$reverseLayout = z11;
                        this.$beforeContentPadding = i11;
                        this.$afterContentPadding = i10;
                        this.$visualItemOffset = j6;
                    }

                    @Override // androidx.compose.foundation.lazy.grid.LazyGridMeasuredItemProvider
                    /* renamed from: createItem-O3s9Psw, reason: not valid java name */
                    public LazyGridMeasuredItem mo394createItemO3s9Psw(int index, Object key, Object contentType, int crossAxisSize, int mainAxisSpacing, List<? extends Placeable> placeables, long constraints, int lane, int span) {
                        return new LazyGridMeasuredItem(index, key, this.$isVertical, crossAxisSize, mainAxisSpacing, this.$reverseLayout, this.$this_null.getLayoutDirection(), this.$beforeContentPadding, this.$afterContentPadding, placeables, this.$visualItemOffset, contentType, this.$state.getItemAnimator$foundation_release(), constraints, lane, span, null);
                    }
                };
                final boolean z12 = z6;
                final LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1 r9 = new LazyGridMeasuredLineProvider(z12, mo387invoke0kLqBqw, itemCount, mo206roundToPx0680j_45, r35, spanLayoutProvider) { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1
                    final /* synthetic */ boolean $isVertical;
                    final /* synthetic */ LazyGridSlots $resolvedSlots;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(z12, mo387invoke0kLqBqw, itemCount, mo206roundToPx0680j_45, r35, spanLayoutProvider);
                        this.$isVertical = z12;
                        this.$resolvedSlots = mo387invoke0kLqBqw;
                    }

                    @Override // androidx.compose.foundation.lazy.grid.LazyGridMeasuredLineProvider
                    public LazyGridMeasuredLine createLine(int index, LazyGridMeasuredItem[] items, List<GridItemSpan> spans, int mainAxisSpacing) {
                        return new LazyGridMeasuredLine(index, items, this.$resolvedSlots, spans, this.$isVertical, mainAxisSpacing);
                    }
                };
                Function1<Integer, ArrayList<Pair<? extends Integer, ? extends Constraints>>> function1 = new Function1<Integer, ArrayList<Pair<? extends Integer, ? extends Constraints>>>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$prefetchInfoRetriever$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ ArrayList<Pair<? extends Integer, ? extends Constraints>> invoke(Integer num) {
                        return invoke(num.intValue());
                    }

                    public final ArrayList<Pair<Integer, Constraints>> invoke(int i12) {
                        LazyGridSpanLayoutProvider.LineConfiguration lineConfiguration = LazyGridSpanLayoutProvider.this.getLineConfiguration(i12);
                        int firstItemIndex = lineConfiguration.getFirstItemIndex();
                        ArrayList<Pair<Integer, Constraints>> arrayList = new ArrayList<>(lineConfiguration.getSpans().size());
                        List<GridItemSpan> spans = lineConfiguration.getSpans();
                        LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1 lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1 = r9;
                        int size = spans.size();
                        int i13 = 0;
                        for (int i14 = 0; i14 < size; i14++) {
                            int m383getCurrentLineSpanimpl = GridItemSpan.m383getCurrentLineSpanimpl(spans.get(i14).getPackedValue());
                            arrayList.add(TuplesKt.to(Integer.valueOf(firstItemIndex), Constraints.m2567boximpl(lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1.m399childConstraintsJhjzzOo$foundation_release(i13, m383getCurrentLineSpanimpl))));
                            firstItemIndex++;
                            i13 += m383getCurrentLineSpanimpl;
                        }
                        return arrayList;
                    }
                };
                Snapshot.Companion companion = Snapshot.INSTANCE;
                LazyGridState lazyGridState3 = LazyGridState.this;
                Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
                Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                Snapshot makeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
                try {
                    int updateScrollPositionIfTheFirstItemWasMoved$foundation_release = lazyGridState3.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(invoke, lazyGridState3.getFirstVisibleItemIndex());
                    if (updateScrollPositionIfTheFirstItemWasMoved$foundation_release >= itemCount && itemCount > 0) {
                        lineIndexOfItem = spanLayoutProvider.getLineIndexOfItem(itemCount - 1);
                        firstVisibleItemScrollOffset = 0;
                        Unit unit22 = Unit.INSTANCE;
                        companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                        LazyGridMeasureResult m396measureLazyGridOZKpZRA22 = LazyGridMeasureKt.m396measureLazyGridOZKpZRA(itemCount, r9, r35, m2577getMaxHeightimpl, i9, i10, mo206roundToPx0680j_45, lineIndexOfItem, firstVisibleItemScrollOffset, LazyGridState.this.getScrollToBeConsumed(), m2595offsetNN6EwU, z6, vertical, horizontal, z5, lazyLayoutMeasureScope, LazyGridState.this.getItemAnimator$foundation_release(), length, LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(invoke, LazyGridState.this.getPinnedItems(), LazyGridState.this.getBeyondBoundsInfo()), coroutineScope, LazyGridState.this.m401getPlacementScopeInvalidatorzYiylxw$foundation_release(), graphicsContext, function1, new Function3<Integer, Integer, Function1<? super Placeable.PlacementScope, ? extends Unit>, MeasureResult>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measureResult$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ MeasureResult invoke(Integer num, Integer num2, Function1<? super Placeable.PlacementScope, ? extends Unit> function12) {
                                return invoke(num.intValue(), num2.intValue(), (Function1<? super Placeable.PlacementScope, Unit>) function12);
                            }

                            public final MeasureResult invoke(int i12, int i13, Function1<? super Placeable.PlacementScope, Unit> function12) {
                                return LazyLayoutMeasureScope.this.layout(ConstraintsKt.m2593constrainWidthK40F9xA(j5, i12 + i7), ConstraintsKt.m2592constrainHeightK40F9xA(j5, i13 + i6), MapsKt.emptyMap(), function12);
                            }
                        });
                        LazyGridState.applyMeasureResult$foundation_release$default(LazyGridState.this, m396measureLazyGridOZKpZRA22, false, 2, null);
                        return m396measureLazyGridOZKpZRA22;
                    }
                    lineIndexOfItem = spanLayoutProvider.getLineIndexOfItem(updateScrollPositionIfTheFirstItemWasMoved$foundation_release);
                    firstVisibleItemScrollOffset = lazyGridState3.getFirstVisibleItemScrollOffset();
                    Unit unit222 = Unit.INSTANCE;
                    companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                    LazyGridMeasureResult m396measureLazyGridOZKpZRA222 = LazyGridMeasureKt.m396measureLazyGridOZKpZRA(itemCount, r9, r35, m2577getMaxHeightimpl, i9, i10, mo206roundToPx0680j_45, lineIndexOfItem, firstVisibleItemScrollOffset, LazyGridState.this.getScrollToBeConsumed(), m2595offsetNN6EwU, z6, vertical, horizontal, z5, lazyLayoutMeasureScope, LazyGridState.this.getItemAnimator$foundation_release(), length, LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(invoke, LazyGridState.this.getPinnedItems(), LazyGridState.this.getBeyondBoundsInfo()), coroutineScope, LazyGridState.this.m401getPlacementScopeInvalidatorzYiylxw$foundation_release(), graphicsContext, function1, new Function3<Integer, Integer, Function1<? super Placeable.PlacementScope, ? extends Unit>, MeasureResult>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measureResult$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ MeasureResult invoke(Integer num, Integer num2, Function1<? super Placeable.PlacementScope, ? extends Unit> function12) {
                            return invoke(num.intValue(), num2.intValue(), (Function1<? super Placeable.PlacementScope, Unit>) function12);
                        }

                        public final MeasureResult invoke(int i12, int i13, Function1<? super Placeable.PlacementScope, Unit> function12) {
                            return LazyLayoutMeasureScope.this.layout(ConstraintsKt.m2593constrainWidthK40F9xA(j5, i12 + i7), ConstraintsKt.m2592constrainHeightK40F9xA(j5, i13 + i6), MapsKt.emptyMap(), function12);
                        }
                    });
                    LazyGridState.applyMeasureResult$foundation_release$default(LazyGridState.this, m396measureLazyGridOZKpZRA222, false, 2, null);
                    return m396measureLazyGridOZKpZRA222;
                } catch (Throwable th) {
                    companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                    throw th;
                }
            }
        };
        composer.updateRememberedValue(rememberedValue);
        Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function222 = (Function2) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
        }
        return function222;
    }
}
