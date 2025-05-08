package androidx.compose.animation;

import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000V\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u001aS\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH\u0007¢\u0006\u0004\b\u000e\u0010\u000f\u001aW\u0010\u000e\u001a\u00020\f*\u00020\u00102\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH\u0007¢\u0006\u0004\b\u000e\u0010\u0011\u001aW\u0010\u000e\u001a\u00020\f*\u00020\u00122\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH\u0007¢\u0006\u0004\b\u000e\u0010\u0013\u001ac\u0010\u0017\u001a\u00020\f\"\u0004\b\u0000\u0010\u00142\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00152\u0012\u0010\u0001\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00000\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH\u0001¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0089\u0001\u0010\u001e\u001a\u00020\f\"\u0004\b\u0000\u0010\u00142\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00152\u0012\u0010\u0001\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00000\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0018\u0010\u001b\u001a\u0014\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00000\u00192\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH\u0001¢\u0006\u0004\b\u001e\u0010\u001f\u001a;\u0010!\u001a\u00020\u001a\"\u0004\b\u0000\u0010\u0014*\b\u0012\u0004\u0012\u00028\u00000\u00152\u0012\u0010\u0001\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00000\n2\u0006\u0010 \u001a\u00028\u0000H\u0003¢\u0006\u0004\b!\u0010\"\"\u001e\u0010%\u001a\u00020\u0000*\b\u0012\u0004\u0012\u00020\u001a0\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$¨\u0006(²\u0006$\u0010&\u001a\u0014\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00000\u0019\"\u0004\b\u0000\u0010\u00148\nX\u008a\u0084\u0002²\u0006\u0012\u0010'\u001a\u00020\u0000\"\u0004\b\u0000\u0010\u00148\nX\u008a\u0084\u0002"}, d2 = {BuildConfig.FLAVOR, "visible", "Landroidx/compose/ui/Modifier;", "modifier", "Landroidx/compose/animation/EnterTransition;", "enter", "Landroidx/compose/animation/ExitTransition;", "exit", BuildConfig.FLAVOR, "label", "Lkotlin/Function1;", "Landroidx/compose/animation/AnimatedVisibilityScope;", BuildConfig.FLAVOR, "content", "AnimatedVisibility", "(ZLandroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/foundation/layout/RowScope;", "(Landroidx/compose/foundation/layout/RowScope;ZLandroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/foundation/layout/ColumnScope;", "(Landroidx/compose/foundation/layout/ColumnScope;ZLandroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "T", "Landroidx/compose/animation/core/Transition;", "transition", "AnimatedVisibilityImpl", "(Landroidx/compose/animation/core/Transition;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "Lkotlin/Function2;", "Landroidx/compose/animation/EnterExitState;", "shouldDisposeBlock", "Landroidx/compose/animation/OnLookaheadMeasured;", "onLookaheadMeasured", "AnimatedEnterExitImpl", "(Landroidx/compose/animation/core/Transition;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Lkotlin/jvm/functions/Function2;Landroidx/compose/animation/OnLookaheadMeasured;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "targetState", "targetEnterExit", "(Landroidx/compose/animation/core/Transition;Lkotlin/jvm/functions/Function1;Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/EnterExitState;", "getExitFinished", "(Landroidx/compose/animation/core/Transition;)Z", "exitFinished", "shouldDisposeBlockUpdated", "shouldDisposeAfterExit", "animation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class AnimatedVisibilityKt {
    /* JADX WARN: Removed duplicated region for block: B:112:0x02ed  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0310  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x031c  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0320  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x02ce  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0386  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x037c  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0293  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> void AnimatedEnterExitImpl(final Transition<T> transition, final Function1<? super T, Boolean> function1, final Modifier modifier, final EnterTransition enterTransition, final ExitTransition exitTransition, final Function2<? super EnterExitState, ? super EnterExitState, Boolean> function2, OnLookaheadMeasured onLookaheadMeasured, final Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i5, final int i6) {
        int i7;
        int i8;
        boolean z5;
        Object rememberedValue;
        int i9;
        OnLookaheadMeasured onLookaheadMeasured2;
        int i10;
        int i11;
        OnLookaheadMeasured onLookaheadMeasured3;
        int i12;
        Transition createChildTransitionInternal;
        boolean changed;
        Object rememberedValue2;
        boolean z6;
        Object rememberedValue3;
        final OnLookaheadMeasured onLookaheadMeasured4;
        Composer composer2;
        Modifier modifier2;
        Object rememberedValue4;
        int currentCompositeKeyHash;
        Composer m1226constructorimpl;
        OnLookaheadMeasured onLookaheadMeasured5;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-891967166);
        if ((i6 & 1) != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changed(transition) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        if ((i6 & 2) != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i6 & 4) != 0) {
            i7 |= 384;
        } else if ((i5 & 384) == 0) {
            i7 |= startRestartGroup.changed(modifier) ? 256 : 128;
        }
        if ((i6 & 8) != 0) {
            i7 |= 3072;
        } else if ((i5 & 3072) == 0) {
            i7 |= startRestartGroup.changed(enterTransition) ? 2048 : 1024;
        }
        if ((i6 & 16) != 0) {
            i7 |= 24576;
        } else if ((i5 & 24576) == 0) {
            i7 |= startRestartGroup.changed(exitTransition) ? 16384 : 8192;
        }
        if ((i6 & 32) != 0) {
            i7 |= 196608;
        } else if ((i5 & 196608) == 0) {
            i7 |= startRestartGroup.changedInstance(function2) ? 131072 : 65536;
        }
        int i13 = i6 & 64;
        int i14 = 1572864;
        if (i13 == 0) {
            if ((i5 & 1572864) == 0) {
                i14 = (i5 & 2097152) == 0 ? startRestartGroup.changed(onLookaheadMeasured) : startRestartGroup.changedInstance(onLookaheadMeasured) ? 1048576 : 524288;
            }
            if ((i6 & 128) == 0) {
                i7 |= 12582912;
            } else if ((i5 & 12582912) == 0) {
                i7 |= startRestartGroup.changedInstance(function3) ? 8388608 : 4194304;
            }
            i8 = i7;
            if ((4793491 & i8) == 4793490 || !startRestartGroup.getSkipping()) {
                OnLookaheadMeasured onLookaheadMeasured6 = i13 == 0 ? null : onLookaheadMeasured;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-891967166, i8, -1, "androidx.compose.animation.AnimatedEnterExitImpl (AnimatedVisibility.kt:737)");
                }
                if (!function1.invoke(transition.getTargetState()).booleanValue() || function1.invoke(transition.getCurrentState()).booleanValue() || transition.isSeeking() || transition.getHasInitialValueAnimations()) {
                    startRestartGroup.startReplaceGroup(1787977937);
                    int i15 = i8 & 14;
                    int i16 = i15 | 48;
                    int i17 = i16 & 14;
                    boolean z7 = true;
                    z5 = ((i17 ^ 6) <= 4 && startRestartGroup.changed(transition)) || (i16 & 6) == 4;
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (!z5 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                        rememberedValue = transition.getCurrentState();
                        startRestartGroup.updateRememberedValue(rememberedValue);
                    }
                    if (transition.isSeeking()) {
                        rememberedValue = transition.getCurrentState();
                    }
                    startRestartGroup.startReplaceGroup(-466616829);
                    if (ComposerKt.isTraceInProgress()) {
                        i9 = i15;
                        onLookaheadMeasured2 = onLookaheadMeasured6;
                    } else {
                        i9 = i15;
                        onLookaheadMeasured2 = onLookaheadMeasured6;
                        ComposerKt.traceEventStart(-466616829, 0, -1, "androidx.compose.animation.AnimatedEnterExitImpl.<anonymous> (AnimatedVisibility.kt:742)");
                    }
                    int i18 = i8 & 126;
                    EnterExitState targetEnterExit = targetEnterExit(transition, function1, rememberedValue, startRestartGroup, i18);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    startRestartGroup.endReplaceGroup();
                    T targetState = transition.getTargetState();
                    startRestartGroup.startReplaceGroup(-466616829);
                    if (ComposerKt.isTraceInProgress()) {
                        i10 = i8;
                    } else {
                        i10 = i8;
                        ComposerKt.traceEventStart(-466616829, 0, -1, "androidx.compose.animation.AnimatedEnterExitImpl.<anonymous> (AnimatedVisibility.kt:742)");
                    }
                    EnterExitState targetEnterExit2 = targetEnterExit(transition, function1, targetState, startRestartGroup, i18);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    startRestartGroup.endReplaceGroup();
                    int i19 = i17 | 3072;
                    i11 = i9;
                    onLookaheadMeasured3 = onLookaheadMeasured2;
                    i12 = i10;
                    createChildTransitionInternal = TransitionKt.createChildTransitionInternal(transition, targetEnterExit, targetEnterExit2, "EnterExitTransition", startRestartGroup, i19);
                    State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function2, startRestartGroup, (i12 >> 15) & 14);
                    Boolean invoke = function2.invoke(createChildTransitionInternal.getCurrentState(), createChildTransitionInternal.getTargetState());
                    changed = startRestartGroup.changed(createChildTransitionInternal) | startRestartGroup.changed(rememberUpdatedState);
                    rememberedValue2 = startRestartGroup.rememberedValue();
                    if (!changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue2 = new AnimatedVisibilityKt$AnimatedEnterExitImpl$shouldDisposeAfterExit$2$1(createChildTransitionInternal, rememberUpdatedState, null);
                        startRestartGroup.updateRememberedValue(rememberedValue2);
                    }
                    State produceState = SnapshotStateKt.produceState(invoke, (Function2) rememberedValue2, startRestartGroup, 0);
                    if (getExitFinished(createChildTransitionInternal) || !AnimatedEnterExitImpl$lambda$4(produceState)) {
                        startRestartGroup.startReplaceGroup(1788869559);
                        z6 = i11 != 4;
                        rememberedValue3 = startRestartGroup.rememberedValue();
                        if (!z6 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue3 = new AnimatedVisibilityScopeImpl(createChildTransitionInternal);
                            startRestartGroup.updateRememberedValue(rememberedValue3);
                        }
                        AnimatedVisibilityScopeImpl animatedVisibilityScopeImpl = (AnimatedVisibilityScopeImpl) rememberedValue3;
                        int i20 = i12 >> 6;
                        int i21 = (i20 & 112) | 24576 | (i20 & 896);
                        onLookaheadMeasured4 = onLookaheadMeasured3;
                        composer2 = startRestartGroup;
                        Modifier createModifier = EnterExitTransitionKt.createModifier(createChildTransitionInternal, enterTransition, exitTransition, null, "Built-in", composer2, i21, 4);
                        if (onLookaheadMeasured4 == null) {
                            composer2.startReplaceGroup(1789227361);
                            Modifier.Companion companion = Modifier.INSTANCE;
                            if ((i12 & 3670016) != 1048576 && ((i12 & 2097152) == 0 || !composer2.changedInstance(onLookaheadMeasured4))) {
                                z7 = false;
                            }
                            Object rememberedValue5 = composer2.rememberedValue();
                            if (z7 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue5 = new Function3<MeasureScope, Measurable, Constraints, MeasureResult>(onLookaheadMeasured4) { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedEnterExitImpl$2$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                                        return m23invoke3p2s80s(measureScope, measurable, constraints.getValue());
                                    }

                                    /* renamed from: invoke-3p2s80s, reason: not valid java name */
                                    public final MeasureResult m23invoke3p2s80s(MeasureScope measureScope, Measurable measurable, long j5) {
                                        final Placeable mo1946measureBRTryo0 = measurable.mo1946measureBRTryo0(j5);
                                        if (!measureScope.isLookingAhead()) {
                                            return MeasureScope.layout$default(measureScope, mo1946measureBRTryo0.getWidth(), mo1946measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedEnterExitImpl$2$1$1$1
                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                                    invoke2(placementScope);
                                                    return Unit.INSTANCE;
                                                }

                                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                public final void invoke2(Placeable.PlacementScope placementScope) {
                                                    Placeable.PlacementScope.place$default(placementScope, Placeable.this, 0, 0, 0.0f, 4, null);
                                                }
                                            }, 4, null);
                                        }
                                        IntSizeKt.IntSize(mo1946measureBRTryo0.getWidth(), mo1946measureBRTryo0.getHeight());
                                        throw null;
                                    }
                                };
                                composer2.updateRememberedValue(rememberedValue5);
                            }
                            modifier2 = LayoutModifierKt.layout(companion, (Function3) rememberedValue5);
                            composer2.endReplaceGroup();
                        } else {
                            composer2.startReplaceGroup(1581766416);
                            composer2.endReplaceGroup();
                            modifier2 = Modifier.INSTANCE;
                        }
                        Modifier then = modifier.then(createModifier.then(modifier2));
                        rememberedValue4 = composer2.rememberedValue();
                        if (rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue4 = new AnimatedEnterExitMeasurePolicy(animatedVisibilityScopeImpl);
                            composer2.updateRememberedValue(rememberedValue4);
                        }
                        AnimatedEnterExitMeasurePolicy animatedEnterExitMeasurePolicy = (AnimatedEnterExitMeasurePolicy) rememberedValue4;
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, then);
                        ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                        Function0<ComposeUiNode> constructor = companion2.getConstructor();
                        if (composer2.getApplier() == null) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.useNode();
                        } else {
                            composer2.createNode(constructor);
                        }
                        m1226constructorimpl = Updater.m1226constructorimpl(composer2);
                        Updater.m1227setimpl(m1226constructorimpl, animatedEnterExitMeasurePolicy, companion2.getSetMeasurePolicy());
                        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                        if (!m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
                        function3.invoke(animatedVisibilityScopeImpl, composer2, Integer.valueOf((i12 >> 18) & 112));
                        composer2.endNode();
                        composer2.endReplaceGroup();
                    } else {
                        startRestartGroup.startReplaceGroup(1790256282);
                        startRestartGroup.endReplaceGroup();
                        onLookaheadMeasured4 = onLookaheadMeasured3;
                        composer2 = startRestartGroup;
                    }
                    composer2.endReplaceGroup();
                } else {
                    startRestartGroup.startReplaceGroup(1790262234);
                    startRestartGroup.endReplaceGroup();
                    onLookaheadMeasured4 = onLookaheadMeasured6;
                    composer2 = startRestartGroup;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                onLookaheadMeasured5 = onLookaheadMeasured4;
            } else {
                startRestartGroup.skipToGroupEnd();
                onLookaheadMeasured5 = onLookaheadMeasured;
                composer2 = startRestartGroup;
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
                final OnLookaheadMeasured onLookaheadMeasured7 = onLookaheadMeasured5;
                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>(transition, function1, modifier, enterTransition, exitTransition, function2, onLookaheadMeasured7, function3, i5, i6) { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedEnterExitImpl$4
                    final /* synthetic */ int $$changed;
                    final /* synthetic */ int $$default;
                    final /* synthetic */ Function3<AnimatedVisibilityScope, Composer, Integer, Unit> $content;
                    final /* synthetic */ EnterTransition $enter;
                    final /* synthetic */ ExitTransition $exit;
                    final /* synthetic */ Modifier $modifier;
                    final /* synthetic */ Function2<EnterExitState, EnterExitState, Boolean> $shouldDisposeBlock;
                    final /* synthetic */ Transition<T> $transition;
                    final /* synthetic */ Function1<T, Boolean> $visible;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                        this.$content = function3;
                        this.$$changed = i5;
                        this.$$default = i6;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                        invoke(composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i22) {
                        AnimatedVisibilityKt.AnimatedEnterExitImpl(this.$transition, this.$visible, this.$modifier, this.$enter, this.$exit, this.$shouldDisposeBlock, null, this.$content, composer3, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
                    }
                });
                return;
            }
            return;
        }
        i7 |= i14;
        if ((i6 & 128) == 0) {
        }
        i8 = i7;
        if ((4793491 & i8) == 4793490) {
        }
        if (i13 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        if (function1.invoke(transition.getTargetState()).booleanValue()) {
        }
        startRestartGroup.startReplaceGroup(1787977937);
        int i152 = i8 & 14;
        int i162 = i152 | 48;
        int i172 = i162 & 14;
        boolean z72 = true;
        if ((i172 ^ 6) <= 4) {
        }
        rememberedValue = startRestartGroup.rememberedValue();
        if (!z5) {
        }
        rememberedValue = transition.getCurrentState();
        startRestartGroup.updateRememberedValue(rememberedValue);
        if (transition.isSeeking()) {
        }
        startRestartGroup.startReplaceGroup(-466616829);
        if (ComposerKt.isTraceInProgress()) {
        }
        int i182 = i8 & 126;
        EnterExitState targetEnterExit3 = targetEnterExit(transition, function1, rememberedValue, startRestartGroup, i182);
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.endReplaceGroup();
        T targetState2 = transition.getTargetState();
        startRestartGroup.startReplaceGroup(-466616829);
        if (ComposerKt.isTraceInProgress()) {
        }
        EnterExitState targetEnterExit22 = targetEnterExit(transition, function1, targetState2, startRestartGroup, i182);
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.endReplaceGroup();
        int i192 = i172 | 3072;
        i11 = i9;
        onLookaheadMeasured3 = onLookaheadMeasured2;
        i12 = i10;
        createChildTransitionInternal = TransitionKt.createChildTransitionInternal(transition, targetEnterExit3, targetEnterExit22, "EnterExitTransition", startRestartGroup, i192);
        State rememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(function2, startRestartGroup, (i12 >> 15) & 14);
        Boolean invoke2 = function2.invoke(createChildTransitionInternal.getCurrentState(), createChildTransitionInternal.getTargetState());
        changed = startRestartGroup.changed(createChildTransitionInternal) | startRestartGroup.changed(rememberUpdatedState2);
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (!changed) {
        }
        rememberedValue2 = new AnimatedVisibilityKt$AnimatedEnterExitImpl$shouldDisposeAfterExit$2$1(createChildTransitionInternal, rememberUpdatedState2, null);
        startRestartGroup.updateRememberedValue(rememberedValue2);
        State produceState2 = SnapshotStateKt.produceState(invoke2, (Function2) rememberedValue2, startRestartGroup, 0);
        if (getExitFinished(createChildTransitionInternal)) {
        }
        startRestartGroup.startReplaceGroup(1788869559);
        if (i11 != 4) {
        }
        rememberedValue3 = startRestartGroup.rememberedValue();
        if (!z6) {
        }
        rememberedValue3 = new AnimatedVisibilityScopeImpl(createChildTransitionInternal);
        startRestartGroup.updateRememberedValue(rememberedValue3);
        AnimatedVisibilityScopeImpl animatedVisibilityScopeImpl2 = (AnimatedVisibilityScopeImpl) rememberedValue3;
        int i202 = i12 >> 6;
        int i212 = (i202 & 112) | 24576 | (i202 & 896);
        onLookaheadMeasured4 = onLookaheadMeasured3;
        composer2 = startRestartGroup;
        Modifier createModifier2 = EnterExitTransitionKt.createModifier(createChildTransitionInternal, enterTransition, exitTransition, null, "Built-in", composer2, i212, 4);
        if (onLookaheadMeasured4 == null) {
        }
        Modifier then2 = modifier.then(createModifier2.then(modifier2));
        rememberedValue4 = composer2.rememberedValue();
        if (rememberedValue4 == Composer.INSTANCE.getEmpty()) {
        }
        AnimatedEnterExitMeasurePolicy animatedEnterExitMeasurePolicy2 = (AnimatedEnterExitMeasurePolicy) rememberedValue4;
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
        CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
        Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer2, then2);
        ComposeUiNode.Companion companion22 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor2 = companion22.getConstructor();
        if (composer2.getApplier() == null) {
        }
        composer2.startReusableNode();
        if (composer2.getInserting()) {
        }
        m1226constructorimpl = Updater.m1226constructorimpl(composer2);
        Updater.m1227setimpl(m1226constructorimpl, animatedEnterExitMeasurePolicy2, companion22.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap2, companion22.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion22.getSetCompositeKeyHash();
        if (!m1226constructorimpl.getInserting()) {
        }
        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash2);
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier2, companion22.getSetModifier());
        function3.invoke(animatedVisibilityScopeImpl2, composer2, Integer.valueOf((i12 >> 18) & 112));
        composer2.endNode();
        composer2.endReplaceGroup();
        composer2.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
        }
        onLookaheadMeasured5 = onLookaheadMeasured4;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function2<EnterExitState, EnterExitState, Boolean> AnimatedEnterExitImpl$lambda$2(State<? extends Function2<? super EnterExitState, ? super EnterExitState, Boolean>> state) {
        return (Function2) state.getValue();
    }

    private static final boolean AnimatedEnterExitImpl$lambda$4(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void AnimatedVisibility(final boolean z5, Modifier modifier, EnterTransition enterTransition, ExitTransition exitTransition, String str, final Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i5, final int i6) {
        int i7;
        Modifier modifier2;
        int i8;
        EnterTransition enterTransition2;
        int i9;
        ExitTransition exitTransition2;
        int i10;
        String str2;
        Modifier modifier3;
        final String str3;
        final EnterTransition enterTransition3;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(2088733774);
        if ((i6 & 1) != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changed(z5) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        int i11 = i6 & 2;
        if (i11 != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            modifier2 = modifier;
            i7 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            i8 = i6 & 4;
            if (i8 == 0) {
                i7 |= 384;
            } else if ((i5 & 384) == 0) {
                enterTransition2 = enterTransition;
                i7 |= startRestartGroup.changed(enterTransition2) ? 256 : 128;
                i9 = i6 & 8;
                if (i9 != 0) {
                    i7 |= 3072;
                } else if ((i5 & 3072) == 0) {
                    exitTransition2 = exitTransition;
                    i7 |= startRestartGroup.changed(exitTransition2) ? 2048 : 1024;
                    i10 = i6 & 16;
                    if (i10 == 0) {
                        i7 |= 24576;
                    } else if ((i5 & 24576) == 0) {
                        str2 = str;
                        i7 |= startRestartGroup.changed(str2) ? 16384 : 8192;
                        if ((i6 & 32) != 0) {
                            i7 |= 196608;
                        } else if ((i5 & 196608) == 0) {
                            i7 |= startRestartGroup.changedInstance(function3) ? 131072 : 65536;
                        }
                        if ((74899 & i7) != 74898 && startRestartGroup.getSkipping()) {
                            startRestartGroup.skipToGroupEnd();
                            modifier3 = modifier2;
                            enterTransition3 = enterTransition2;
                            str3 = str2;
                        } else {
                            modifier3 = i11 != 0 ? Modifier.INSTANCE : modifier2;
                            EnterTransition plus = i8 != 0 ? EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null)) : enterTransition2;
                            ExitTransition plus2 = i9 != 0 ? EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null)) : exitTransition2;
                            String str4 = i10 != 0 ? "AnimatedVisibility" : str2;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(2088733774, i7, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:131)");
                            }
                            int i12 = i7 << 3;
                            int i13 = (i12 & 57344) | (i12 & 896) | 48 | (i12 & 7168) | (i7 & 458752);
                            String str5 = str4;
                            AnimatedVisibilityImpl(TransitionKt.updateTransition(Boolean.valueOf(z5), str4, startRestartGroup, (i7 & 14) | ((i7 >> 9) & 112), 0), new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$1
                                public final Boolean invoke(boolean z6) {
                                    return Boolean.valueOf(z6);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                    return invoke(bool.booleanValue());
                                }
                            }, modifier3, plus, plus2, function3, startRestartGroup, i13);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            exitTransition2 = plus2;
                            str3 = str5;
                            enterTransition3 = plus;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            final Modifier modifier4 = modifier3;
                            final ExitTransition exitTransition3 = exitTransition2;
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$2
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

                                public final void invoke(Composer composer2, int i14) {
                                    AnimatedVisibilityKt.AnimatedVisibility(z5, modifier4, enterTransition3, exitTransition3, str3, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    str2 = str;
                    if ((i6 & 32) != 0) {
                    }
                    if ((74899 & i7) != 74898) {
                    }
                    if (i11 != 0) {
                    }
                    if (i8 != 0) {
                    }
                    if (i9 != 0) {
                    }
                    if (i10 != 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i122 = i7 << 3;
                    int i132 = (i122 & 57344) | (i122 & 896) | 48 | (i122 & 7168) | (i7 & 458752);
                    String str52 = str4;
                    AnimatedVisibilityImpl(TransitionKt.updateTransition(Boolean.valueOf(z5), str4, startRestartGroup, (i7 & 14) | ((i7 >> 9) & 112), 0), new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$1
                        public final Boolean invoke(boolean z6) {
                            return Boolean.valueOf(z6);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                            return invoke(bool.booleanValue());
                        }
                    }, modifier3, plus, plus2, function3, startRestartGroup, i132);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    exitTransition2 = plus2;
                    str3 = str52;
                    enterTransition3 = plus;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                exitTransition2 = exitTransition;
                i10 = i6 & 16;
                if (i10 == 0) {
                }
                str2 = str;
                if ((i6 & 32) != 0) {
                }
                if ((74899 & i7) != 74898) {
                }
                if (i11 != 0) {
                }
                if (i8 != 0) {
                }
                if (i9 != 0) {
                }
                if (i10 != 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                int i1222 = i7 << 3;
                int i1322 = (i1222 & 57344) | (i1222 & 896) | 48 | (i1222 & 7168) | (i7 & 458752);
                String str522 = str4;
                AnimatedVisibilityImpl(TransitionKt.updateTransition(Boolean.valueOf(z5), str4, startRestartGroup, (i7 & 14) | ((i7 >> 9) & 112), 0), new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$1
                    public final Boolean invoke(boolean z6) {
                        return Boolean.valueOf(z6);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                        return invoke(bool.booleanValue());
                    }
                }, modifier3, plus, plus2, function3, startRestartGroup, i1322);
                if (ComposerKt.isTraceInProgress()) {
                }
                exitTransition2 = plus2;
                str3 = str522;
                enterTransition3 = plus;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            enterTransition2 = enterTransition;
            i9 = i6 & 8;
            if (i9 != 0) {
            }
            exitTransition2 = exitTransition;
            i10 = i6 & 16;
            if (i10 == 0) {
            }
            str2 = str;
            if ((i6 & 32) != 0) {
            }
            if ((74899 & i7) != 74898) {
            }
            if (i11 != 0) {
            }
            if (i8 != 0) {
            }
            if (i9 != 0) {
            }
            if (i10 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            int i12222 = i7 << 3;
            int i13222 = (i12222 & 57344) | (i12222 & 896) | 48 | (i12222 & 7168) | (i7 & 458752);
            String str5222 = str4;
            AnimatedVisibilityImpl(TransitionKt.updateTransition(Boolean.valueOf(z5), str4, startRestartGroup, (i7 & 14) | ((i7 >> 9) & 112), 0), new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$1
                public final Boolean invoke(boolean z6) {
                    return Boolean.valueOf(z6);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                    return invoke(bool.booleanValue());
                }
            }, modifier3, plus, plus2, function3, startRestartGroup, i13222);
            if (ComposerKt.isTraceInProgress()) {
            }
            exitTransition2 = plus2;
            str3 = str5222;
            enterTransition3 = plus;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i8 = i6 & 4;
        if (i8 == 0) {
        }
        enterTransition2 = enterTransition;
        i9 = i6 & 8;
        if (i9 != 0) {
        }
        exitTransition2 = exitTransition;
        i10 = i6 & 16;
        if (i10 == 0) {
        }
        str2 = str;
        if ((i6 & 32) != 0) {
        }
        if ((74899 & i7) != 74898) {
        }
        if (i11 != 0) {
        }
        if (i8 != 0) {
        }
        if (i9 != 0) {
        }
        if (i10 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        int i122222 = i7 << 3;
        int i132222 = (i122222 & 57344) | (i122222 & 896) | 48 | (i122222 & 7168) | (i7 & 458752);
        String str52222 = str4;
        AnimatedVisibilityImpl(TransitionKt.updateTransition(Boolean.valueOf(z5), str4, startRestartGroup, (i7 & 14) | ((i7 >> 9) & 112), 0), new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$1
            public final Boolean invoke(boolean z6) {
                return Boolean.valueOf(z6);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                return invoke(bool.booleanValue());
            }
        }, modifier3, plus, plus2, function3, startRestartGroup, i132222);
        if (ComposerKt.isTraceInProgress()) {
        }
        exitTransition2 = plus2;
        str3 = str52222;
        enterTransition3 = plus;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    public static final <T> void AnimatedVisibilityImpl(final Transition<T> transition, final Function1<? super T, Boolean> function1, final Modifier modifier, final EnterTransition enterTransition, final ExitTransition exitTransition, final Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i5) {
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(429978603);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(transition) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changed(modifier) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changed(enterTransition) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changed(exitTransition) ? 16384 : 8192;
        }
        if ((i5 & 196608) == 0) {
            i6 |= startRestartGroup.changedInstance(function3) ? 131072 : 65536;
        }
        if ((74899 & i6) == 74898 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(429978603, i6, -1, "androidx.compose.animation.AnimatedVisibilityImpl (AnimatedVisibility.kt:693)");
            }
            int i7 = i6 & 112;
            int i8 = i6 & 14;
            boolean z5 = (i7 == 32) | (i8 == 4);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibilityImpl$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                        return m24invoke3p2s80s(measureScope, measurable, constraints.getValue());
                    }

                    /* renamed from: invoke-3p2s80s, reason: not valid java name */
                    public final MeasureResult m24invoke3p2s80s(MeasureScope measureScope, Measurable measurable, long j5) {
                        final Placeable mo1946measureBRTryo0 = measurable.mo1946measureBRTryo0(j5);
                        long IntSize = (!measureScope.isLookingAhead() || function1.invoke(transition.getTargetState()).booleanValue()) ? IntSizeKt.IntSize(mo1946measureBRTryo0.getWidth(), mo1946measureBRTryo0.getHeight()) : IntSize.INSTANCE.m2665getZeroYbymL2g();
                        return MeasureScope.layout$default(measureScope, IntSize.m2661getWidthimpl(IntSize), IntSize.m2660getHeightimpl(IntSize), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibilityImpl$1$1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                invoke2(placementScope);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Placeable.PlacementScope placementScope) {
                                Placeable.PlacementScope.place$default(placementScope, Placeable.this, 0, 0, 0.0f, 4, null);
                            }
                        }, 4, null);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            AnimatedEnterExitImpl(transition, function1, LayoutModifierKt.layout(modifier, (Function3) rememberedValue), enterTransition, exitTransition, new Function2<EnterExitState, EnterExitState, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibilityImpl$2
                @Override // kotlin.jvm.functions.Function2
                public final Boolean invoke(EnterExitState enterExitState, EnterExitState enterExitState2) {
                    return Boolean.valueOf(enterExitState == enterExitState2 && enterExitState2 == EnterExitState.PostExit);
                }
            }, null, function3, startRestartGroup, i7 | 196608 | i8 | (i6 & 7168) | (57344 & i6) | ((i6 << 6) & 29360128), 64);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibilityImpl$3
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

                public final void invoke(Composer composer2, int i9) {
                    AnimatedVisibilityKt.AnimatedVisibilityImpl(transition, function1, modifier, enterTransition, exitTransition, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getExitFinished(Transition<EnterExitState> transition) {
        EnterExitState currentState = transition.getCurrentState();
        EnterExitState enterExitState = EnterExitState.PostExit;
        return currentState == enterExitState && transition.getTargetState() == enterExitState;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> EnterExitState targetEnterExit(Transition<T> transition, Function1<? super T, Boolean> function1, T t5, Composer composer, int i5) {
        EnterExitState enterExitState;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(361571134, i5, -1, "androidx.compose.animation.targetEnterExit (AnimatedVisibility.kt:855)");
        }
        composer.startMovableGroup(-902048200, transition);
        if (transition.isSeeking()) {
            composer.startReplaceGroup(2101296683);
            composer.endReplaceGroup();
            enterExitState = function1.invoke(t5).booleanValue() ? EnterExitState.Visible : function1.invoke(transition.getCurrentState()).booleanValue() ? EnterExitState.PostExit : EnterExitState.PreEnter;
        } else {
            composer.startReplaceGroup(2101530516);
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composer.updateRememberedValue(rememberedValue);
            }
            MutableState mutableState = (MutableState) rememberedValue;
            if (function1.invoke(transition.getCurrentState()).booleanValue()) {
                mutableState.setValue(Boolean.TRUE);
            }
            enterExitState = function1.invoke(t5).booleanValue() ? EnterExitState.Visible : ((Boolean) mutableState.getValue()).booleanValue() ? EnterExitState.PostExit : EnterExitState.PreEnter;
            composer.endReplaceGroup();
        }
        composer.endMovableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return enterExitState;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void AnimatedVisibility(final RowScope rowScope, final boolean z5, Modifier modifier, EnterTransition enterTransition, ExitTransition exitTransition, String str, final Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i5, final int i6) {
        int i7;
        Modifier modifier2;
        int i8;
        EnterTransition enterTransition2;
        int i9;
        ExitTransition exitTransition2;
        int i10;
        String str2;
        final ExitTransition plus;
        final Modifier modifier3;
        final EnterTransition enterTransition3;
        final String str3;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-1741346906);
        if ((i6 & 1) != 0) {
            i7 = i5 | 48;
        } else if ((i5 & 48) == 0) {
            i7 = (startRestartGroup.changed(z5) ? 32 : 16) | i5;
        } else {
            i7 = i5;
        }
        int i11 = i6 & 2;
        if (i11 != 0) {
            i7 |= 384;
        } else if ((i5 & 384) == 0) {
            modifier2 = modifier;
            i7 |= startRestartGroup.changed(modifier2) ? 256 : 128;
            i8 = i6 & 4;
            if (i8 == 0) {
                i7 |= 3072;
            } else if ((i5 & 3072) == 0) {
                enterTransition2 = enterTransition;
                i7 |= startRestartGroup.changed(enterTransition2) ? 2048 : 1024;
                i9 = i6 & 8;
                if (i9 != 0) {
                    i7 |= 24576;
                } else if ((i5 & 24576) == 0) {
                    exitTransition2 = exitTransition;
                    i7 |= startRestartGroup.changed(exitTransition2) ? 16384 : 8192;
                    i10 = i6 & 16;
                    if (i10 == 0) {
                        i7 |= 196608;
                    } else if ((196608 & i5) == 0) {
                        str2 = str;
                        i7 |= startRestartGroup.changed(str2) ? 131072 : 65536;
                        if ((i6 & 32) != 0) {
                            i7 |= 1572864;
                        } else if ((i5 & 1572864) == 0) {
                            i7 |= startRestartGroup.changedInstance(function3) ? 1048576 : 524288;
                        }
                        if ((599185 & i7) != 599184 && startRestartGroup.getSkipping()) {
                            startRestartGroup.skipToGroupEnd();
                            modifier3 = modifier2;
                            enterTransition3 = enterTransition2;
                            plus = exitTransition2;
                            str3 = str2;
                        } else {
                            Modifier modifier4 = i11 != 0 ? Modifier.INSTANCE : modifier2;
                            EnterTransition plus2 = i8 != 0 ? EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandHorizontally$default(null, null, false, null, 15, null)) : enterTransition2;
                            plus = i9 != 0 ? EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkHorizontally$default(null, null, false, null, 15, null)) : exitTransition2;
                            String str4 = i10 != 0 ? "AnimatedVisibility" : str2;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1741346906, i7, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:206)");
                            }
                            int i12 = i7 >> 3;
                            AnimatedVisibilityImpl(TransitionKt.updateTransition(Boolean.valueOf(z5), str4, startRestartGroup, (i12 & 14) | ((i7 >> 12) & 112), 0), new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$3
                                public final Boolean invoke(boolean z6) {
                                    return Boolean.valueOf(z6);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                    return invoke(bool.booleanValue());
                                }
                            }, modifier4, plus2, plus, function3, startRestartGroup, (i7 & 57344) | (i7 & 896) | 48 | (i7 & 7168) | (i12 & 458752));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier4;
                            enterTransition3 = plus2;
                            str3 = str4;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$4
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

                                public final void invoke(Composer composer2, int i13) {
                                    AnimatedVisibilityKt.AnimatedVisibility(RowScope.this, z5, modifier3, enterTransition3, plus, str3, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    str2 = str;
                    if ((i6 & 32) != 0) {
                    }
                    if ((599185 & i7) != 599184) {
                    }
                    if (i11 != 0) {
                    }
                    if (i8 != 0) {
                    }
                    if (i9 != 0) {
                    }
                    if (i10 != 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i122 = i7 >> 3;
                    AnimatedVisibilityImpl(TransitionKt.updateTransition(Boolean.valueOf(z5), str4, startRestartGroup, (i122 & 14) | ((i7 >> 12) & 112), 0), new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$3
                        public final Boolean invoke(boolean z6) {
                            return Boolean.valueOf(z6);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                            return invoke(bool.booleanValue());
                        }
                    }, modifier4, plus2, plus, function3, startRestartGroup, (i7 & 57344) | (i7 & 896) | 48 | (i7 & 7168) | (i122 & 458752));
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier3 = modifier4;
                    enterTransition3 = plus2;
                    str3 = str4;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                exitTransition2 = exitTransition;
                i10 = i6 & 16;
                if (i10 == 0) {
                }
                str2 = str;
                if ((i6 & 32) != 0) {
                }
                if ((599185 & i7) != 599184) {
                }
                if (i11 != 0) {
                }
                if (i8 != 0) {
                }
                if (i9 != 0) {
                }
                if (i10 != 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                int i1222 = i7 >> 3;
                AnimatedVisibilityImpl(TransitionKt.updateTransition(Boolean.valueOf(z5), str4, startRestartGroup, (i1222 & 14) | ((i7 >> 12) & 112), 0), new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$3
                    public final Boolean invoke(boolean z6) {
                        return Boolean.valueOf(z6);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                        return invoke(bool.booleanValue());
                    }
                }, modifier4, plus2, plus, function3, startRestartGroup, (i7 & 57344) | (i7 & 896) | 48 | (i7 & 7168) | (i1222 & 458752));
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier3 = modifier4;
                enterTransition3 = plus2;
                str3 = str4;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            enterTransition2 = enterTransition;
            i9 = i6 & 8;
            if (i9 != 0) {
            }
            exitTransition2 = exitTransition;
            i10 = i6 & 16;
            if (i10 == 0) {
            }
            str2 = str;
            if ((i6 & 32) != 0) {
            }
            if ((599185 & i7) != 599184) {
            }
            if (i11 != 0) {
            }
            if (i8 != 0) {
            }
            if (i9 != 0) {
            }
            if (i10 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            int i12222 = i7 >> 3;
            AnimatedVisibilityImpl(TransitionKt.updateTransition(Boolean.valueOf(z5), str4, startRestartGroup, (i12222 & 14) | ((i7 >> 12) & 112), 0), new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$3
                public final Boolean invoke(boolean z6) {
                    return Boolean.valueOf(z6);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                    return invoke(bool.booleanValue());
                }
            }, modifier4, plus2, plus, function3, startRestartGroup, (i7 & 57344) | (i7 & 896) | 48 | (i7 & 7168) | (i12222 & 458752));
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier3 = modifier4;
            enterTransition3 = plus2;
            str3 = str4;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i8 = i6 & 4;
        if (i8 == 0) {
        }
        enterTransition2 = enterTransition;
        i9 = i6 & 8;
        if (i9 != 0) {
        }
        exitTransition2 = exitTransition;
        i10 = i6 & 16;
        if (i10 == 0) {
        }
        str2 = str;
        if ((i6 & 32) != 0) {
        }
        if ((599185 & i7) != 599184) {
        }
        if (i11 != 0) {
        }
        if (i8 != 0) {
        }
        if (i9 != 0) {
        }
        if (i10 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        int i122222 = i7 >> 3;
        AnimatedVisibilityImpl(TransitionKt.updateTransition(Boolean.valueOf(z5), str4, startRestartGroup, (i122222 & 14) | ((i7 >> 12) & 112), 0), new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$3
            public final Boolean invoke(boolean z6) {
                return Boolean.valueOf(z6);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                return invoke(bool.booleanValue());
            }
        }, modifier4, plus2, plus, function3, startRestartGroup, (i7 & 57344) | (i7 & 896) | 48 | (i7 & 7168) | (i122222 & 458752));
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier3 = modifier4;
        enterTransition3 = plus2;
        str3 = str4;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void AnimatedVisibility(final ColumnScope columnScope, final boolean z5, Modifier modifier, EnterTransition enterTransition, ExitTransition exitTransition, String str, final Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i5, final int i6) {
        int i7;
        Modifier modifier2;
        int i8;
        EnterTransition enterTransition2;
        int i9;
        ExitTransition exitTransition2;
        int i10;
        String str2;
        final ExitTransition plus;
        final Modifier modifier3;
        final EnterTransition enterTransition3;
        final String str3;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(1766503102);
        if ((i6 & 1) != 0) {
            i7 = i5 | 48;
        } else if ((i5 & 48) == 0) {
            i7 = (startRestartGroup.changed(z5) ? 32 : 16) | i5;
        } else {
            i7 = i5;
        }
        int i11 = i6 & 2;
        if (i11 != 0) {
            i7 |= 384;
        } else if ((i5 & 384) == 0) {
            modifier2 = modifier;
            i7 |= startRestartGroup.changed(modifier2) ? 256 : 128;
            i8 = i6 & 4;
            if (i8 == 0) {
                i7 |= 3072;
            } else if ((i5 & 3072) == 0) {
                enterTransition2 = enterTransition;
                i7 |= startRestartGroup.changed(enterTransition2) ? 2048 : 1024;
                i9 = i6 & 8;
                if (i9 != 0) {
                    i7 |= 24576;
                } else if ((i5 & 24576) == 0) {
                    exitTransition2 = exitTransition;
                    i7 |= startRestartGroup.changed(exitTransition2) ? 16384 : 8192;
                    i10 = i6 & 16;
                    if (i10 == 0) {
                        i7 |= 196608;
                    } else if ((196608 & i5) == 0) {
                        str2 = str;
                        i7 |= startRestartGroup.changed(str2) ? 131072 : 65536;
                        if ((i6 & 32) != 0) {
                            i7 |= 1572864;
                        } else if ((i5 & 1572864) == 0) {
                            i7 |= startRestartGroup.changedInstance(function3) ? 1048576 : 524288;
                        }
                        if ((599185 & i7) != 599184 && startRestartGroup.getSkipping()) {
                            startRestartGroup.skipToGroupEnd();
                            modifier3 = modifier2;
                            enterTransition3 = enterTransition2;
                            plus = exitTransition2;
                            str3 = str2;
                        } else {
                            Modifier modifier4 = i11 != 0 ? Modifier.INSTANCE : modifier2;
                            EnterTransition plus2 = i8 != 0 ? EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null)) : enterTransition2;
                            plus = i9 != 0 ? EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null)) : exitTransition2;
                            String str4 = i10 != 0 ? "AnimatedVisibility" : str2;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1766503102, i7, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:279)");
                            }
                            int i12 = i7 >> 3;
                            AnimatedVisibilityImpl(TransitionKt.updateTransition(Boolean.valueOf(z5), str4, startRestartGroup, (i12 & 14) | ((i7 >> 12) & 112), 0), new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$5
                                public final Boolean invoke(boolean z6) {
                                    return Boolean.valueOf(z6);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                    return invoke(bool.booleanValue());
                                }
                            }, modifier4, plus2, plus, function3, startRestartGroup, (i7 & 57344) | (i7 & 896) | 48 | (i7 & 7168) | (i12 & 458752));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier4;
                            enterTransition3 = plus2;
                            str3 = str4;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$6
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

                                public final void invoke(Composer composer2, int i13) {
                                    AnimatedVisibilityKt.AnimatedVisibility(ColumnScope.this, z5, modifier3, enterTransition3, plus, str3, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    str2 = str;
                    if ((i6 & 32) != 0) {
                    }
                    if ((599185 & i7) != 599184) {
                    }
                    if (i11 != 0) {
                    }
                    if (i8 != 0) {
                    }
                    if (i9 != 0) {
                    }
                    if (i10 != 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i122 = i7 >> 3;
                    AnimatedVisibilityImpl(TransitionKt.updateTransition(Boolean.valueOf(z5), str4, startRestartGroup, (i122 & 14) | ((i7 >> 12) & 112), 0), new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$5
                        public final Boolean invoke(boolean z6) {
                            return Boolean.valueOf(z6);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                            return invoke(bool.booleanValue());
                        }
                    }, modifier4, plus2, plus, function3, startRestartGroup, (i7 & 57344) | (i7 & 896) | 48 | (i7 & 7168) | (i122 & 458752));
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier3 = modifier4;
                    enterTransition3 = plus2;
                    str3 = str4;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                exitTransition2 = exitTransition;
                i10 = i6 & 16;
                if (i10 == 0) {
                }
                str2 = str;
                if ((i6 & 32) != 0) {
                }
                if ((599185 & i7) != 599184) {
                }
                if (i11 != 0) {
                }
                if (i8 != 0) {
                }
                if (i9 != 0) {
                }
                if (i10 != 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                int i1222 = i7 >> 3;
                AnimatedVisibilityImpl(TransitionKt.updateTransition(Boolean.valueOf(z5), str4, startRestartGroup, (i1222 & 14) | ((i7 >> 12) & 112), 0), new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$5
                    public final Boolean invoke(boolean z6) {
                        return Boolean.valueOf(z6);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                        return invoke(bool.booleanValue());
                    }
                }, modifier4, plus2, plus, function3, startRestartGroup, (i7 & 57344) | (i7 & 896) | 48 | (i7 & 7168) | (i1222 & 458752));
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier3 = modifier4;
                enterTransition3 = plus2;
                str3 = str4;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            enterTransition2 = enterTransition;
            i9 = i6 & 8;
            if (i9 != 0) {
            }
            exitTransition2 = exitTransition;
            i10 = i6 & 16;
            if (i10 == 0) {
            }
            str2 = str;
            if ((i6 & 32) != 0) {
            }
            if ((599185 & i7) != 599184) {
            }
            if (i11 != 0) {
            }
            if (i8 != 0) {
            }
            if (i9 != 0) {
            }
            if (i10 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            int i12222 = i7 >> 3;
            AnimatedVisibilityImpl(TransitionKt.updateTransition(Boolean.valueOf(z5), str4, startRestartGroup, (i12222 & 14) | ((i7 >> 12) & 112), 0), new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$5
                public final Boolean invoke(boolean z6) {
                    return Boolean.valueOf(z6);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                    return invoke(bool.booleanValue());
                }
            }, modifier4, plus2, plus, function3, startRestartGroup, (i7 & 57344) | (i7 & 896) | 48 | (i7 & 7168) | (i12222 & 458752));
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier3 = modifier4;
            enterTransition3 = plus2;
            str3 = str4;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i8 = i6 & 4;
        if (i8 == 0) {
        }
        enterTransition2 = enterTransition;
        i9 = i6 & 8;
        if (i9 != 0) {
        }
        exitTransition2 = exitTransition;
        i10 = i6 & 16;
        if (i10 == 0) {
        }
        str2 = str;
        if ((i6 & 32) != 0) {
        }
        if ((599185 & i7) != 599184) {
        }
        if (i11 != 0) {
        }
        if (i8 != 0) {
        }
        if (i9 != 0) {
        }
        if (i10 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        int i122222 = i7 >> 3;
        AnimatedVisibilityImpl(TransitionKt.updateTransition(Boolean.valueOf(z5), str4, startRestartGroup, (i122222 & 14) | ((i7 >> 12) & 112), 0), new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$5
            public final Boolean invoke(boolean z6) {
                return Boolean.valueOf(z6);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                return invoke(bool.booleanValue());
            }
        }, modifier4, plus2, plus, function3, startRestartGroup, (i7 & 57344) | (i7 & 896) | 48 | (i7 & 7168) | (i122222 & 458752));
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier3 = modifier4;
        enterTransition3 = plus2;
        str3 = str4;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }
}
