package androidx.compose.foundation.pager;

import androidx.compose.foundation.ScrollingContainerKt;
import androidx.compose.foundation.gestures.BringIntoViewSpec;
import androidx.compose.foundation.gestures.BringIntoViewSpec_androidKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsModifierLocalKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt;
import androidx.compose.foundation.lazy.layout.NearestRangeKeyIndexMap;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.reflect.KProperty0;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a¶\u0001\u0010$\u001a\u00020 2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00152\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001c2\u0018\u0010!\u001a\u0014\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020 0\u001eH\u0001ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\u001a[\u0010(\u001a\b\u0012\u0004\u0012\u00020'0%2\u0006\u0010\u0003\u001a\u00020\u00022\u0018\u0010!\u001a\u0014\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020 0\u001e2\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00152\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\r0%H\u0003¢\u0006\u0004\b(\u0010)\u001a\u001b\u0010*\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b*\u0010+\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006,"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Landroidx/compose/foundation/pager/PagerState;", "state", "Landroidx/compose/foundation/layout/PaddingValues;", "contentPadding", BuildConfig.FLAVOR, "reverseLayout", "Landroidx/compose/foundation/gestures/Orientation;", "orientation", "Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "flingBehavior", "userScrollEnabled", BuildConfig.FLAVOR, "beyondViewportPageCount", "Landroidx/compose/ui/unit/Dp;", "pageSpacing", "Landroidx/compose/foundation/pager/PageSize;", "pageSize", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "pageNestedScrollConnection", "Lkotlin/Function1;", BuildConfig.FLAVOR, "key", "Landroidx/compose/ui/Alignment$Horizontal;", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "verticalAlignment", "Landroidx/compose/foundation/gestures/snapping/SnapPosition;", "snapPosition", "Lkotlin/Function2;", "Landroidx/compose/foundation/pager/PagerScope;", BuildConfig.FLAVOR, "pageContent", "Pager-uYRUAWA", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/gestures/Orientation;Landroidx/compose/foundation/gestures/TargetedFlingBehavior;ZIFLandroidx/compose/foundation/pager/PageSize;Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/snapping/SnapPosition;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;III)V", "Pager", "Lkotlin/Function0;", "pageCount", "Landroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;", "rememberPagerItemProviderLambda", "(Landroidx/compose/foundation/pager/PagerState;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function0;", "dragDirectionDetector", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/pager/PagerState;)Landroidx/compose/ui/Modifier;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class LazyLayoutPagerKt {
    /* JADX WARN: Removed duplicated region for block: B:135:0x0472  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0211  */
    /* renamed from: Pager-uYRUAWA, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m436PageruYRUAWA(final Modifier modifier, final PagerState pagerState, final PaddingValues paddingValues, final boolean z5, final Orientation orientation, final TargetedFlingBehavior targetedFlingBehavior, final boolean z6, int i5, float f5, final PageSize pageSize, final NestedScrollConnection nestedScrollConnection, final Function1<? super Integer, ? extends Object> function1, final Alignment.Horizontal horizontal, final Alignment.Vertical vertical, final SnapPosition snapPosition, final Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4, Composer composer, final int i6, final int i7, final int i8) {
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        Composer composer2;
        int i14;
        boolean z7;
        boolean z8;
        CoroutineScope coroutineScope;
        boolean z9;
        final int i15;
        final float f6;
        int i16;
        Composer startRestartGroup = composer.startRestartGroup(538371694);
        if ((i8 & 1) != 0) {
            i9 = i6 | 6;
        } else if ((i6 & 6) == 0) {
            i9 = (startRestartGroup.changed(modifier) ? 4 : 2) | i6;
        } else {
            i9 = i6;
        }
        if ((i8 & 2) != 0) {
            i9 |= 48;
        } else if ((i6 & 48) == 0) {
            i9 |= startRestartGroup.changed(pagerState) ? 32 : 16;
        }
        if ((i8 & 4) != 0) {
            i9 |= 384;
        } else if ((i6 & 384) == 0) {
            i9 |= startRestartGroup.changed(paddingValues) ? 256 : 128;
            if ((i8 & 8) == 0) {
                i9 |= 3072;
            } else if ((i6 & 3072) == 0) {
                i9 |= startRestartGroup.changed(z5) ? 2048 : 1024;
                if ((i8 & 16) != 0) {
                    i9 |= 24576;
                } else if ((i6 & 24576) == 0) {
                    i9 |= startRestartGroup.changed(orientation) ? 16384 : 8192;
                }
                if ((i8 & 32) != 0) {
                    i9 |= 196608;
                } else if ((i6 & 196608) == 0) {
                    i9 |= startRestartGroup.changed(targetedFlingBehavior) ? 131072 : 65536;
                }
                if ((i8 & 64) == 0) {
                    i16 = (1572864 & i6) == 0 ? startRestartGroup.changed(z6) ? 1048576 : 524288 : 1572864;
                    i10 = i8 & 128;
                    if (i10 == 0) {
                        i9 |= 12582912;
                        i11 = i5;
                    } else {
                        i11 = i5;
                        if ((i6 & 12582912) == 0) {
                            i9 |= startRestartGroup.changed(i11) ? 8388608 : 4194304;
                        }
                    }
                    i12 = i8 & 256;
                    if (i12 == 0) {
                        i9 |= 100663296;
                    } else if ((i6 & 100663296) == 0) {
                        i9 |= startRestartGroup.changed(f5) ? 67108864 : 33554432;
                    }
                    if ((i8 & 512) == 0) {
                        i9 |= 805306368;
                    } else if ((805306368 & i6) == 0) {
                        i9 |= startRestartGroup.changed(pageSize) ? 536870912 : 268435456;
                        if ((i8 & 1024) != 0) {
                            i13 = i7 | 6;
                        } else if ((i7 & 6) == 0) {
                            i13 = (startRestartGroup.changedInstance(nestedScrollConnection) ? 4 : 2) | i7;
                        } else {
                            i13 = i7;
                        }
                        if ((i8 & 2048) != 0) {
                            i13 |= 48;
                        } else if ((i7 & 48) == 0) {
                            i13 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
                            if ((i8 & 4096) == 0) {
                                i13 |= 384;
                            } else if ((i7 & 384) == 0) {
                                i13 |= startRestartGroup.changed(horizontal) ? 256 : 128;
                                if ((i8 & 8192) != 0) {
                                    i13 |= 3072;
                                } else if ((i7 & 3072) == 0) {
                                    i13 |= startRestartGroup.changed(vertical) ? 2048 : 1024;
                                    if ((i8 & 16384) == 0) {
                                        i13 |= 24576;
                                    } else if ((i7 & 24576) == 0) {
                                        i13 |= startRestartGroup.changed(snapPosition) ? 16384 : 8192;
                                        if ((i8 & 32768) != 0) {
                                            i13 |= 196608;
                                        } else if ((i7 & 196608) == 0) {
                                            i13 |= startRestartGroup.changedInstance(function4) ? 131072 : 65536;
                                        }
                                        if ((i9 & 306783379) != 306783378 && (74899 & i13) == 74898 && startRestartGroup.getSkipping()) {
                                            startRestartGroup.skipToGroupEnd();
                                            f6 = f5;
                                            composer2 = startRestartGroup;
                                            i15 = i11;
                                        } else {
                                            if (i10 != 0) {
                                                i11 = 0;
                                            }
                                            float m2599constructorimpl = i12 != 0 ? Dp.m2599constructorimpl(0) : f5;
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(538371694, i9, i13, "androidx.compose.foundation.pager.Pager (LazyLayoutPager.kt:101)");
                                            }
                                            if (i11 < 0) {
                                                throw new IllegalArgumentException(("beyondViewportPageCount should be greater than or equal to 0, you selected " + i11).toString());
                                            }
                                            int i17 = i9 & 112;
                                            boolean z10 = i17 == 32;
                                            Object rememberedValue = startRestartGroup.rememberedValue();
                                            if (z10 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                                rememberedValue = new Function0<Integer>() { // from class: androidx.compose.foundation.pager.LazyLayoutPagerKt$Pager$pagerItemProvider$1$1
                                                    /* JADX INFO: Access modifiers changed from: package-private */
                                                    {
                                                        super(0);
                                                    }

                                                    /* JADX WARN: Can't rename method to resolve collision */
                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Integer invoke() {
                                                        return Integer.valueOf(PagerState.this.getPageCount());
                                                    }
                                                };
                                                startRestartGroup.updateRememberedValue(rememberedValue);
                                            }
                                            int i18 = i9 >> 3;
                                            int i19 = i18 & 14;
                                            int i20 = i13 >> 12;
                                            int i21 = i9;
                                            int i22 = i13;
                                            int i23 = i11;
                                            Function0<PagerLazyLayoutItemProvider> rememberPagerItemProviderLambda = rememberPagerItemProviderLambda(pagerState, function4, function1, (Function0) rememberedValue, startRestartGroup, i19 | (i20 & 112) | ((i13 << 3) & 896));
                                            Object rememberedValue2 = startRestartGroup.rememberedValue();
                                            Composer.Companion companion = Composer.INSTANCE;
                                            if (rememberedValue2 == companion.getEmpty()) {
                                                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup));
                                                startRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                                                rememberedValue2 = compositionScopedCoroutineScopeCanceller;
                                            }
                                            CoroutineScope coroutineScope2 = ((CompositionScopedCoroutineScopeCanceller) rememberedValue2).getCoroutineScope();
                                            boolean z11 = i17 == 32;
                                            Object rememberedValue3 = startRestartGroup.rememberedValue();
                                            if (z11 || rememberedValue3 == companion.getEmpty()) {
                                                rememberedValue3 = new Function0<Integer>() { // from class: androidx.compose.foundation.pager.LazyLayoutPagerKt$Pager$measurePolicy$1$1
                                                    /* JADX INFO: Access modifiers changed from: package-private */
                                                    {
                                                        super(0);
                                                    }

                                                    /* JADX WARN: Can't rename method to resolve collision */
                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Integer invoke() {
                                                        return Integer.valueOf(PagerState.this.getPageCount());
                                                    }
                                                };
                                                startRestartGroup.updateRememberedValue(rememberedValue3);
                                            }
                                            int i24 = i21 & 7168;
                                            int i25 = 65520 & i21;
                                            int i26 = i21 >> 6;
                                            int i27 = i22 << 18;
                                            Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> m443rememberPagerMeasurePolicy8u0NR3k = PagerMeasurePolicyKt.m443rememberPagerMeasurePolicy8u0NR3k(rememberPagerItemProviderLambda, pagerState, paddingValues, z5, orientation, i23, m2599constructorimpl, pageSize, horizontal, vertical, snapPosition, coroutineScope2, (Function0) rememberedValue3, startRestartGroup, i25 | (i26 & 458752) | (3670016 & i26) | (29360128 & i26) | (234881024 & i27) | (i27 & 1879048192), i20 & 14);
                                            Orientation orientation2 = Orientation.Vertical;
                                            if (orientation == orientation2) {
                                                z7 = true;
                                                composer2 = startRestartGroup;
                                                i14 = i19;
                                            } else {
                                                composer2 = startRestartGroup;
                                                i14 = i19;
                                                z7 = false;
                                            }
                                            LazyLayoutSemanticState rememberPagerSemanticState = PagerSemanticsKt.rememberPagerSemanticState(pagerState, z7, composer2, i14);
                                            boolean z12 = (i17 == 32) | ((i21 & 458752) == 131072);
                                            Object rememberedValue4 = composer2.rememberedValue();
                                            if (z12 || rememberedValue4 == companion.getEmpty()) {
                                                rememberedValue4 = new PagerWrapperFlingBehavior(targetedFlingBehavior, pagerState);
                                                composer2.updateRememberedValue(rememberedValue4);
                                            }
                                            PagerWrapperFlingBehavior pagerWrapperFlingBehavior = (PagerWrapperFlingBehavior) rememberedValue4;
                                            BringIntoViewSpec bringIntoViewSpec = (BringIntoViewSpec) composer2.consume(BringIntoViewSpec_androidKt.getLocalBringIntoViewSpec());
                                            boolean changed = (i17 == 32) | composer2.changed(bringIntoViewSpec);
                                            Object rememberedValue5 = composer2.rememberedValue();
                                            if (changed || rememberedValue5 == companion.getEmpty()) {
                                                rememberedValue5 = new PagerBringIntoViewSpec(pagerState, bringIntoViewSpec);
                                                composer2.updateRememberedValue(rememberedValue5);
                                            }
                                            PagerBringIntoViewSpec pagerBringIntoViewSpec = (PagerBringIntoViewSpec) rememberedValue5;
                                            Modifier lazyLayoutSemantics = LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier.then(pagerState.getRemeasurementModifier()).then(pagerState.getAwaitLayoutModifier()), rememberPagerItemProviderLambda, rememberPagerSemanticState, orientation, z6, z5, composer2, (i18 & 7168) | (57344 & i26) | ((i21 << 6) & 458752));
                                            if (orientation == orientation2) {
                                                z8 = z6;
                                                z9 = true;
                                                coroutineScope = coroutineScope2;
                                            } else {
                                                z8 = z6;
                                                coroutineScope = coroutineScope2;
                                                z9 = false;
                                            }
                                            int i28 = i21 << 3;
                                            LazyLayoutKt.LazyLayout(rememberPagerItemProviderLambda, NestedScrollModifierKt.nestedScroll$default(dragDirectionDetector(ScrollingContainerKt.scrollingContainer(LazyLayoutBeyondBoundsModifierLocalKt.lazyLayoutBeyondBoundsModifier(PagerKt.pagerSemantics(lazyLayoutSemantics, pagerState, z9, coroutineScope, z8), PagerBeyondBoundsModifierKt.rememberPagerBeyondBoundsState(pagerState, i23, composer2, ((i21 >> 18) & 112) | i14), pagerState.getBeyondBoundsInfo(), z5, (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation, z6, composer2, (MutableVector.$stable << 6) | i24 | (i28 & 458752) | (i21 & 3670016)), pagerState, orientation, z6, z5, pagerWrapperFlingBehavior, pagerState.getInternalInteractionSource(), pagerBringIntoViewSpec, composer2, (i26 & 896) | i17 | ((i21 >> 9) & 7168) | (i28 & 57344), 0), pagerState), nestedScrollConnection, null, 2, null), pagerState.getPrefetchState(), m443rememberPagerMeasurePolicy8u0NR3k, composer2, 0, 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                            i15 = i23;
                                            f6 = m2599constructorimpl;
                                        }
                                        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
                                        if (endRestartGroup != null) {
                                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.pager.LazyLayoutPagerKt$Pager$2
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

                                                public final void invoke(Composer composer3, int i29) {
                                                    LazyLayoutPagerKt.m436PageruYRUAWA(Modifier.this, pagerState, paddingValues, z5, orientation, targetedFlingBehavior, z6, i15, f6, pageSize, nestedScrollConnection, function1, horizontal, vertical, snapPosition, function4, composer3, RecomposeScopeImplKt.updateChangedFlags(i6 | 1), RecomposeScopeImplKt.updateChangedFlags(i7), i8);
                                                }
                                            });
                                            return;
                                        }
                                        return;
                                    }
                                    if ((i8 & 32768) != 0) {
                                    }
                                    if ((i9 & 306783379) != 306783378) {
                                    }
                                    if (i10 != 0) {
                                    }
                                    if (i12 != 0) {
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    if (i11 < 0) {
                                    }
                                }
                                if ((i8 & 16384) == 0) {
                                }
                                if ((i8 & 32768) != 0) {
                                }
                                if ((i9 & 306783379) != 306783378) {
                                }
                                if (i10 != 0) {
                                }
                                if (i12 != 0) {
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                if (i11 < 0) {
                                }
                            }
                            if ((i8 & 8192) != 0) {
                            }
                            if ((i8 & 16384) == 0) {
                            }
                            if ((i8 & 32768) != 0) {
                            }
                            if ((i9 & 306783379) != 306783378) {
                            }
                            if (i10 != 0) {
                            }
                            if (i12 != 0) {
                            }
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            if (i11 < 0) {
                            }
                        }
                        if ((i8 & 4096) == 0) {
                        }
                        if ((i8 & 8192) != 0) {
                        }
                        if ((i8 & 16384) == 0) {
                        }
                        if ((i8 & 32768) != 0) {
                        }
                        if ((i9 & 306783379) != 306783378) {
                        }
                        if (i10 != 0) {
                        }
                        if (i12 != 0) {
                        }
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        if (i11 < 0) {
                        }
                    }
                    if ((i8 & 1024) != 0) {
                    }
                    if ((i8 & 2048) != 0) {
                    }
                    if ((i8 & 4096) == 0) {
                    }
                    if ((i8 & 8192) != 0) {
                    }
                    if ((i8 & 16384) == 0) {
                    }
                    if ((i8 & 32768) != 0) {
                    }
                    if ((i9 & 306783379) != 306783378) {
                    }
                    if (i10 != 0) {
                    }
                    if (i12 != 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    if (i11 < 0) {
                    }
                }
                i9 |= i16;
                i10 = i8 & 128;
                if (i10 == 0) {
                }
                i12 = i8 & 256;
                if (i12 == 0) {
                }
                if ((i8 & 512) == 0) {
                }
                if ((i8 & 1024) != 0) {
                }
                if ((i8 & 2048) != 0) {
                }
                if ((i8 & 4096) == 0) {
                }
                if ((i8 & 8192) != 0) {
                }
                if ((i8 & 16384) == 0) {
                }
                if ((i8 & 32768) != 0) {
                }
                if ((i9 & 306783379) != 306783378) {
                }
                if (i10 != 0) {
                }
                if (i12 != 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                if (i11 < 0) {
                }
            }
            if ((i8 & 16) != 0) {
            }
            if ((i8 & 32) != 0) {
            }
            if ((i8 & 64) == 0) {
            }
            i9 |= i16;
            i10 = i8 & 128;
            if (i10 == 0) {
            }
            i12 = i8 & 256;
            if (i12 == 0) {
            }
            if ((i8 & 512) == 0) {
            }
            if ((i8 & 1024) != 0) {
            }
            if ((i8 & 2048) != 0) {
            }
            if ((i8 & 4096) == 0) {
            }
            if ((i8 & 8192) != 0) {
            }
            if ((i8 & 16384) == 0) {
            }
            if ((i8 & 32768) != 0) {
            }
            if ((i9 & 306783379) != 306783378) {
            }
            if (i10 != 0) {
            }
            if (i12 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            if (i11 < 0) {
            }
        }
        if ((i8 & 8) == 0) {
        }
        if ((i8 & 16) != 0) {
        }
        if ((i8 & 32) != 0) {
        }
        if ((i8 & 64) == 0) {
        }
        i9 |= i16;
        i10 = i8 & 128;
        if (i10 == 0) {
        }
        i12 = i8 & 256;
        if (i12 == 0) {
        }
        if ((i8 & 512) == 0) {
        }
        if ((i8 & 1024) != 0) {
        }
        if ((i8 & 2048) != 0) {
        }
        if ((i8 & 4096) == 0) {
        }
        if ((i8 & 8192) != 0) {
        }
        if ((i8 & 16384) == 0) {
        }
        if ((i8 & 32768) != 0) {
        }
        if ((i9 & 306783379) != 306783378) {
        }
        if (i10 != 0) {
        }
        if (i12 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        if (i11 < 0) {
        }
    }

    private static final Modifier dragDirectionDetector(Modifier modifier, PagerState pagerState) {
        return modifier.then(SuspendingPointerInputFilterKt.pointerInput(Modifier.INSTANCE, pagerState, new LazyLayoutPagerKt$dragDirectionDetector$1(pagerState, null)));
    }

    private static final Function0<PagerLazyLayoutItemProvider> rememberPagerItemProviderLambda(final PagerState pagerState, Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4, Function1<? super Integer, ? extends Object> function1, final Function0<Integer> function0, Composer composer, int i5) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1372505274, i5, -1, "androidx.compose.foundation.pager.rememberPagerItemProviderLambda (LazyLayoutPager.kt:258)");
        }
        final State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function4, composer, (i5 >> 3) & 14);
        final State rememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(function1, composer, (i5 >> 6) & 14);
        boolean changed = ((((i5 & 14) ^ 6) > 4 && composer.changed(pagerState)) || (i5 & 6) == 4) | composer.changed(rememberUpdatedState) | composer.changed(rememberUpdatedState2) | ((((i5 & 7168) ^ 3072) > 2048 && composer.changed(function0)) || (i5 & 3072) == 2048);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            final State derivedStateOf = SnapshotStateKt.derivedStateOf(SnapshotStateKt.referentialEqualityPolicy(), new Function0<PagerLayoutIntervalContent>() { // from class: androidx.compose.foundation.pager.LazyLayoutPagerKt$rememberPagerItemProviderLambda$1$intervalContentState$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final PagerLayoutIntervalContent invoke() {
                    return new PagerLayoutIntervalContent(rememberUpdatedState.getValue(), rememberUpdatedState2.getValue(), function0.invoke().intValue());
                }
            });
            final State derivedStateOf2 = SnapshotStateKt.derivedStateOf(SnapshotStateKt.referentialEqualityPolicy(), new Function0<PagerLazyLayoutItemProvider>() { // from class: androidx.compose.foundation.pager.LazyLayoutPagerKt$rememberPagerItemProviderLambda$1$itemProviderState$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final PagerLazyLayoutItemProvider invoke() {
                    PagerLayoutIntervalContent value = derivedStateOf.getValue();
                    return new PagerLazyLayoutItemProvider(pagerState, value, new NearestRangeKeyIndexMap(pagerState.getNearestRange$foundation_release(), value));
                }
            });
            rememberedValue = new PropertyReference0Impl(derivedStateOf2) { // from class: androidx.compose.foundation.pager.LazyLayoutPagerKt$rememberPagerItemProviderLambda$1$1
                @Override // kotlin.reflect.KProperty0
                public Object get() {
                    return ((State) this.receiver).getValue();
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        KProperty0 kProperty0 = (KProperty0) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return kProperty0;
    }
}
