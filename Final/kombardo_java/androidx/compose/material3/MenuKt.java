package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.graphics.TransformOriginKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.InspectionModeKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntRect;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\u0003\u001a|\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u001f\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001aH\u0000¢\u0006\u0004\b\u001d\u0010\u001e\"\u001a\u0010\u001f\u001a\u00020\u000e8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0014\u0010#\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010 \"\u0014\u0010$\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010 \"\u001a\u0010%\u001a\u00020\u000e8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b%\u0010 \u001a\u0004\b&\u0010\"\"\u0014\u0010'\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010 \"\u0014\u0010(\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010 \u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006,²\u0006\f\u0010*\u001a\u00020)8\nX\u008a\u0084\u0002²\u0006\f\u0010+\u001a\u00020)8\nX\u008a\u0084\u0002"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Landroidx/compose/animation/core/MutableTransitionState;", BuildConfig.FLAVOR, "expandedState", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/ui/graphics/TransformOrigin;", "transformOriginState", "Landroidx/compose/foundation/ScrollState;", "scrollState", "Landroidx/compose/ui/graphics/Shape;", "shape", "Landroidx/compose/ui/graphics/Color;", "containerColor", "Landroidx/compose/ui/unit/Dp;", "tonalElevation", "shadowElevation", "Landroidx/compose/foundation/BorderStroke;", "border", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", BuildConfig.FLAVOR, "content", "DropdownMenuContent-Qj0Zi0g", "(Landroidx/compose/ui/Modifier;Landroidx/compose/animation/core/MutableTransitionState;Landroidx/compose/runtime/MutableState;Landroidx/compose/foundation/ScrollState;Landroidx/compose/ui/graphics/Shape;JFFLandroidx/compose/foundation/BorderStroke;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "DropdownMenuContent", "Landroidx/compose/ui/unit/IntRect;", "anchorBounds", "menuBounds", "calculateTransformOrigin", "(Landroidx/compose/ui/unit/IntRect;Landroidx/compose/ui/unit/IntRect;)J", "MenuVerticalMargin", "F", "getMenuVerticalMargin", "()F", "MenuListItemContainerHeight", "DropdownMenuItemHorizontalPadding", "DropdownMenuVerticalPadding", "getDropdownMenuVerticalPadding", "DropdownMenuItemDefaultMinWidth", "DropdownMenuItemDefaultMaxWidth", BuildConfig.FLAVOR, "scale", "alpha", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class MenuKt {
    private static final float MenuListItemContainerHeight;
    private static final float MenuVerticalMargin;
    private static final float DropdownMenuItemHorizontalPadding = Dp.m2599constructorimpl(12);
    private static final float DropdownMenuVerticalPadding = Dp.m2599constructorimpl(8);
    private static final float DropdownMenuItemDefaultMinWidth = Dp.m2599constructorimpl(112);
    private static final float DropdownMenuItemDefaultMaxWidth = Dp.m2599constructorimpl(280);

    static {
        float f5 = 48;
        MenuVerticalMargin = Dp.m2599constructorimpl(f5);
        MenuListItemContainerHeight = Dp.m2599constructorimpl(f5);
    }

    /* renamed from: DropdownMenuContent-Qj0Zi0g, reason: not valid java name */
    public static final void m866DropdownMenuContentQj0Zi0g(final Modifier modifier, final MutableTransitionState<Boolean> mutableTransitionState, final MutableState<TransformOrigin> mutableState, final ScrollState scrollState, final Shape shape, final long j5, final float f5, final float f6, final BorderStroke borderStroke, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i5) {
        int i6;
        int i7;
        Composer startRestartGroup = composer.startRestartGroup(-151448888);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(modifier) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= (i5 & 64) == 0 ? startRestartGroup.changed(mutableTransitionState) : startRestartGroup.changedInstance(mutableTransitionState) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changed(mutableState) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changed(scrollState) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changed(shape) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i6 |= startRestartGroup.changed(j5) ? 131072 : 65536;
        }
        if ((1572864 & i5) == 0) {
            i6 |= startRestartGroup.changed(f5) ? 1048576 : 524288;
        }
        if ((i5 & 12582912) == 0) {
            i6 |= startRestartGroup.changed(f6) ? 8388608 : 4194304;
        }
        if ((i5 & 100663296) == 0) {
            i6 |= startRestartGroup.changed(borderStroke) ? 67108864 : 33554432;
        }
        if ((i5 & 805306368) == 0) {
            i6 |= startRestartGroup.changedInstance(function3) ? 536870912 : 268435456;
        }
        if ((i6 & 306783379) == 306783378 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-151448888, i6, -1, "androidx.compose.material3.DropdownMenuContent (Menu.kt:374)");
            }
            Transition updateTransition = TransitionKt.updateTransition((MutableTransitionState) mutableTransitionState, "DropDownMenu", startRestartGroup, MutableTransitionState.$stable | 48 | ((i6 >> 3) & 14), 0);
            MenuKt$DropdownMenuContent$scale$2 menuKt$DropdownMenuContent$scale$2 = new Function3<Transition.Segment<Boolean>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material3.MenuKt$DropdownMenuContent$scale$2
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<Boolean> segment, Composer composer2, Integer num) {
                    return invoke(segment, composer2, num.intValue());
                }

                public final FiniteAnimationSpec<Float> invoke(Transition.Segment<Boolean> segment, Composer composer2, int i8) {
                    TweenSpec tween$default;
                    composer2.startReplaceGroup(1033023423);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1033023423, i8, -1, "androidx.compose.material3.DropdownMenuContent.<anonymous> (Menu.kt:381)");
                    }
                    if (segment.isTransitioningTo(Boolean.FALSE, Boolean.TRUE)) {
                        tween$default = AnimationSpecKt.tween$default(120, 0, EasingKt.getLinearOutSlowInEasing(), 2, null);
                    } else {
                        tween$default = AnimationSpecKt.tween$default(1, 74, null, 4, null);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer2.endReplaceGroup();
                    return tween$default;
                }
            };
            FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
            TwoWayConverter<Float, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(floatCompanionObject);
            boolean booleanValue = ((Boolean) updateTransition.getCurrentState()).booleanValue();
            startRestartGroup.startReplaceGroup(2139028452);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2139028452, 0, -1, "androidx.compose.material3.DropdownMenuContent.<anonymous> (Menu.kt:390)");
            }
            float f7 = booleanValue ? 1.0f : 0.8f;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            startRestartGroup.endReplaceGroup();
            Float valueOf = Float.valueOf(f7);
            boolean booleanValue2 = ((Boolean) updateTransition.getTargetState()).booleanValue();
            startRestartGroup.startReplaceGroup(2139028452);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2139028452, 0, -1, "androidx.compose.material3.DropdownMenuContent.<anonymous> (Menu.kt:390)");
            }
            float f8 = booleanValue2 ? 1.0f : 0.8f;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            startRestartGroup.endReplaceGroup();
            final State createTransitionAnimation = TransitionKt.createTransitionAnimation(updateTransition, valueOf, Float.valueOf(f8), menuKt$DropdownMenuContent$scale$2.invoke((MenuKt$DropdownMenuContent$scale$2) updateTransition.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), vectorConverter, "FloatAnimation", startRestartGroup, 0);
            MenuKt$DropdownMenuContent$alpha$2 menuKt$DropdownMenuContent$alpha$2 = new Function3<Transition.Segment<Boolean>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material3.MenuKt$DropdownMenuContent$alpha$2
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<Boolean> segment, Composer composer2, Integer num) {
                    return invoke(segment, composer2, num.intValue());
                }

                public final FiniteAnimationSpec<Float> invoke(Transition.Segment<Boolean> segment, Composer composer2, int i8) {
                    TweenSpec tween$default;
                    composer2.startReplaceGroup(-1355418157);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1355418157, i8, -1, "androidx.compose.material3.DropdownMenuContent.<anonymous> (Menu.kt:396)");
                    }
                    if (segment.isTransitioningTo(Boolean.FALSE, Boolean.TRUE)) {
                        tween$default = AnimationSpecKt.tween$default(30, 0, null, 6, null);
                    } else {
                        tween$default = AnimationSpecKt.tween$default(75, 0, null, 6, null);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer2.endReplaceGroup();
                    return tween$default;
                }
            };
            TwoWayConverter<Float, AnimationVector1D> vectorConverter2 = VectorConvertersKt.getVectorConverter(floatCompanionObject);
            boolean booleanValue3 = ((Boolean) updateTransition.getCurrentState()).booleanValue();
            startRestartGroup.startReplaceGroup(-249413128);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-249413128, 0, -1, "androidx.compose.material3.DropdownMenuContent.<anonymous> (Menu.kt:405)");
            }
            float f9 = booleanValue3 ? 1.0f : 0.0f;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            startRestartGroup.endReplaceGroup();
            Float valueOf2 = Float.valueOf(f9);
            boolean booleanValue4 = ((Boolean) updateTransition.getTargetState()).booleanValue();
            startRestartGroup.startReplaceGroup(-249413128);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-249413128, 0, -1, "androidx.compose.material3.DropdownMenuContent.<anonymous> (Menu.kt:405)");
            }
            float f10 = booleanValue4 ? 1.0f : 0.0f;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            startRestartGroup.endReplaceGroup();
            final State createTransitionAnimation2 = TransitionKt.createTransitionAnimation(updateTransition, valueOf2, Float.valueOf(f10), menuKt$DropdownMenuContent$alpha$2.invoke((MenuKt$DropdownMenuContent$alpha$2) updateTransition.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), vectorConverter2, "FloatAnimation", startRestartGroup, 0);
            final boolean booleanValue5 = ((Boolean) startRestartGroup.consume(InspectionModeKt.getLocalInspectionMode())).booleanValue();
            Modifier.Companion companion = Modifier.INSTANCE;
            boolean changed = startRestartGroup.changed(booleanValue5) | startRestartGroup.changed(createTransitionAnimation) | ((i6 & 112) == 32 || ((i6 & 64) != 0 && startRestartGroup.changedInstance(mutableTransitionState))) | startRestartGroup.changed(createTransitionAnimation2) | ((i6 & 896) == 256);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                i7 = i6;
                Function1<GraphicsLayerScope, Unit> function1 = new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material3.MenuKt$DropdownMenuContent$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(GraphicsLayerScope graphicsLayerScope) {
                        invoke2(graphicsLayerScope);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(GraphicsLayerScope graphicsLayerScope) {
                        float f11;
                        float f12 = 0.8f;
                        float f13 = 1.0f;
                        if (booleanValue5) {
                            f11 = mutableTransitionState.getTargetState().booleanValue() ? 1.0f : 0.8f;
                        } else {
                            f11 = MenuKt.DropdownMenuContent_Qj0Zi0g$lambda$1(createTransitionAnimation);
                        }
                        graphicsLayerScope.setScaleX(f11);
                        if (!booleanValue5) {
                            f12 = MenuKt.DropdownMenuContent_Qj0Zi0g$lambda$1(createTransitionAnimation);
                        } else if (mutableTransitionState.getTargetState().booleanValue()) {
                            f12 = 1.0f;
                        }
                        graphicsLayerScope.setScaleY(f12);
                        if (!booleanValue5) {
                            f13 = MenuKt.DropdownMenuContent_Qj0Zi0g$lambda$3(createTransitionAnimation2);
                        } else if (!mutableTransitionState.getTargetState().booleanValue()) {
                            f13 = 0.0f;
                        }
                        graphicsLayerScope.setAlpha(f13);
                        graphicsLayerScope.mo1530setTransformOrigin__ExYCQ(mutableState.getValue().getPackedValue());
                    }
                };
                startRestartGroup.updateRememberedValue(function1);
                rememberedValue = function1;
            } else {
                i7 = i6;
            }
            int i8 = i7 >> 9;
            int i9 = i7 >> 6;
            SurfaceKt.m900SurfaceT9BRK9s(GraphicsLayerModifierKt.graphicsLayer(companion, (Function1) rememberedValue), shape, j5, 0L, f5, f6, borderStroke, ComposableLambdaKt.rememberComposableLambda(1573559053, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.MenuKt$DropdownMenuContent$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i10) {
                    if ((i10 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1573559053, i10, -1, "androidx.compose.material3.DropdownMenuContent.<anonymous> (Menu.kt:429)");
                    }
                    Modifier verticalScroll$default = ScrollKt.verticalScroll$default(IntrinsicKt.width(PaddingKt.m313paddingVpY3zN4$default(Modifier.this, 0.0f, MenuKt.getDropdownMenuVerticalPadding(), 1, null), IntrinsicSize.Max), scrollState, false, null, false, 14, null);
                    Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
                    MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, 0);
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, verticalScroll$default);
                    ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                    Function0<ComposeUiNode> constructor = companion2.getConstructor();
                    if (composer2.getApplier() == null) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor);
                    } else {
                        composer2.useNode();
                    }
                    Composer m1226constructorimpl = Updater.m1226constructorimpl(composer2);
                    Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion2.getSetMeasurePolicy());
                    Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                    if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
                    function32.invoke(ColumnScopeInstance.INSTANCE, composer2, 6);
                    composer2.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), startRestartGroup, (i8 & 896) | (i8 & 112) | 12582912 | (57344 & i9) | (458752 & i9) | (i9 & 3670016), 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.MenuKt$DropdownMenuContent$3
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i10) {
                    MenuKt.m866DropdownMenuContentQj0Zi0g(Modifier.this, mutableTransitionState, mutableState, scrollState, shape, j5, f5, f6, borderStroke, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float DropdownMenuContent_Qj0Zi0g$lambda$1(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float DropdownMenuContent_Qj0Zi0g$lambda$3(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final long calculateTransformOrigin(IntRect intRect, IntRect intRect2) {
        float max;
        float f5 = 1.0f;
        if (intRect2.getLeft() < intRect.getRight()) {
            if (intRect2.getRight() <= intRect.getLeft()) {
                max = 1.0f;
            } else if (intRect2.getWidth() != 0) {
                max = (((Math.max(intRect.getLeft(), intRect2.getLeft()) + Math.min(intRect.getRight(), intRect2.getRight())) / 2) - intRect2.getLeft()) / intRect2.getWidth();
            }
            if (intRect2.getTop() < intRect.getBottom()) {
                if (intRect2.getBottom() > intRect.getTop()) {
                    if (intRect2.getHeight() != 0) {
                        f5 = (((Math.max(intRect.getTop(), intRect2.getTop()) + Math.min(intRect.getBottom(), intRect2.getBottom())) / 2) - intRect2.getTop()) / intRect2.getHeight();
                    }
                }
                return TransformOriginKt.TransformOrigin(max, f5);
            }
            f5 = 0.0f;
            return TransformOriginKt.TransformOrigin(max, f5);
        }
        max = 0.0f;
        if (intRect2.getTop() < intRect.getBottom()) {
        }
        f5 = 0.0f;
        return TransformOriginKt.TransformOrigin(max, f5);
    }

    public static final float getDropdownMenuVerticalPadding() {
        return DropdownMenuVerticalPadding;
    }

    public static final float getMenuVerticalMargin() {
        return MenuVerticalMargin;
    }
}
