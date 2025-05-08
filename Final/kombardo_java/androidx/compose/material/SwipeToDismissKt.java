package androidx.compose.material;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a/\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0007\u001ao\u0010\u0014\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\t2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000e0\u00022\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u00022\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u0002H\u0007¢\u0006\u0004\b\u0014\u0010\u0015\u001a!\u0010\u0018\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0018\u0010\u0019\"\u0014\u0010\u001b\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Landroidx/compose/material/DismissValue;", "initialValue", "Lkotlin/Function1;", BuildConfig.FLAVOR, "confirmStateChange", "Landroidx/compose/material/DismissState;", "rememberDismissState", "(Landroidx/compose/material/DismissValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/DismissState;", "state", "Landroidx/compose/ui/Modifier;", "modifier", BuildConfig.FLAVOR, "Landroidx/compose/material/DismissDirection;", "directions", "Landroidx/compose/material/ThresholdConfig;", "dismissThresholds", "Landroidx/compose/foundation/layout/RowScope;", BuildConfig.FLAVOR, "background", "dismissContent", "SwipeToDismiss", "(Landroidx/compose/material/DismissState;Landroidx/compose/ui/Modifier;Ljava/util/Set;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "from", "to", "getDismissDirection", "(Landroidx/compose/material/DismissValue;Landroidx/compose/material/DismissValue;)Landroidx/compose/material/DismissDirection;", "Landroidx/compose/ui/unit/Dp;", "DISMISS_THRESHOLD", "F", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class SwipeToDismissKt {
    private static final float DISMISS_THRESHOLD = Dp.m2599constructorimpl(56);

    /* JADX WARN: Removed duplicated region for block: B:10:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void SwipeToDismiss(final DismissState dismissState, Modifier modifier, Set<? extends DismissDirection> set, Function1<? super DismissDirection, ? extends ThresholdConfig> function1, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32, Composer composer, final int i5, final int i6) {
        int i7;
        Modifier modifier2;
        int i8;
        Set<? extends DismissDirection> set2;
        int i9;
        Function1<? super DismissDirection, ? extends ThresholdConfig> function12;
        Modifier modifier3;
        final Set<? extends DismissDirection> set3;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(634380143);
        if ((i6 & 1) != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changed(dismissState) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        int i10 = i6 & 2;
        if (i10 != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            modifier2 = modifier;
            i7 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            i8 = i6 & 4;
            if (i8 == 0) {
                i7 |= 384;
            } else if ((i5 & 384) == 0) {
                set2 = set;
                i7 |= startRestartGroup.changedInstance(set2) ? 256 : 128;
                i9 = i6 & 8;
                if (i9 != 0) {
                    i7 |= 3072;
                } else if ((i5 & 3072) == 0) {
                    function12 = function1;
                    i7 |= startRestartGroup.changedInstance(function12) ? 2048 : 1024;
                    if ((i6 & 16) == 0) {
                        i7 |= 24576;
                    } else if ((i5 & 24576) == 0) {
                        i7 |= startRestartGroup.changedInstance(function3) ? 16384 : 8192;
                    }
                    if ((i6 & 32) == 0) {
                        i7 |= 196608;
                    } else if ((i5 & 196608) == 0) {
                        i7 |= startRestartGroup.changedInstance(function32) ? 131072 : 65536;
                    }
                    if ((74899 & i7) == 74898 || !startRestartGroup.getSkipping()) {
                        modifier3 = i10 == 0 ? Modifier.INSTANCE : modifier2;
                        Set<? extends DismissDirection> of = i8 == 0 ? SetsKt.setOf((Object[]) new DismissDirection[]{DismissDirection.EndToStart, DismissDirection.StartToEnd}) : set2;
                        Function1<? super DismissDirection, ? extends ThresholdConfig> function13 = i9 == 0 ? new Function1<DismissDirection, FixedThreshold>() { // from class: androidx.compose.material.SwipeToDismissKt$SwipeToDismiss$1
                            @Override // kotlin.jvm.functions.Function1
                            public final FixedThreshold invoke(DismissDirection dismissDirection) {
                                float f5;
                                f5 = SwipeToDismissKt.DISMISS_THRESHOLD;
                                return new FixedThreshold(f5, null);
                            }
                        } : function12;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(634380143, i7, -1, "androidx.compose.material.SwipeToDismiss (SwipeToDismiss.kt:183)");
                        }
                        final Set<? extends DismissDirection> set4 = of;
                        final Function1<? super DismissDirection, ? extends ThresholdConfig> function14 = function13;
                        BoxWithConstraintsKt.BoxWithConstraints(modifier3, null, false, ComposableLambdaKt.rememberComposableLambda(338007641, true, new Function3<BoxWithConstraintsScope, Composer, Integer, Unit>() { // from class: androidx.compose.material.SwipeToDismissKt$SwipeToDismiss$2
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer2, Integer num) {
                                invoke(boxWithConstraintsScope, composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer2, int i11) {
                                int i12;
                                Modifier m744swipeablepPrIpRY;
                                if ((i11 & 6) == 0) {
                                    i12 = i11 | (composer2.changed(boxWithConstraintsScope) ? 4 : 2);
                                } else {
                                    i12 = i11;
                                }
                                if ((i12 & 19) == 18 && composer2.getSkipping()) {
                                    composer2.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(338007641, i12, -1, "androidx.compose.material.SwipeToDismiss.<anonymous> (SwipeToDismiss.kt:184)");
                                }
                                float m2578getMaxWidthimpl = Constraints.m2578getMaxWidthimpl(boxWithConstraintsScope.getConstraints());
                                boolean z5 = composer2.consume(CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl;
                                Float valueOf = Float.valueOf(0.0f);
                                DismissValue dismissValue = DismissValue.Default;
                                Map mutableMapOf = MapsKt.mutableMapOf(TuplesKt.to(valueOf, dismissValue));
                                Set<DismissDirection> set5 = set4;
                                DismissDirection dismissDirection = DismissDirection.StartToEnd;
                                if (set5.contains(dismissDirection)) {
                                    Pair pair = TuplesKt.to(Float.valueOf(m2578getMaxWidthimpl), DismissValue.DismissedToEnd);
                                    mutableMapOf.put(pair.getFirst(), pair.getSecond());
                                }
                                Set<DismissDirection> set6 = set4;
                                DismissDirection dismissDirection2 = DismissDirection.EndToStart;
                                if (set6.contains(dismissDirection2)) {
                                    Pair pair2 = TuplesKt.to(Float.valueOf(-m2578getMaxWidthimpl), DismissValue.DismissedToStart);
                                    mutableMapOf.put(pair2.getFirst(), pair2.getSecond());
                                }
                                boolean changed = composer2.changed(function14);
                                final Function1<DismissDirection, ThresholdConfig> function15 = function14;
                                Object rememberedValue = composer2.rememberedValue();
                                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = new Function2<DismissValue, DismissValue, ThresholdConfig>() { // from class: androidx.compose.material.SwipeToDismissKt$SwipeToDismiss$2$thresholds$1$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public final ThresholdConfig invoke(DismissValue dismissValue2, DismissValue dismissValue3) {
                                            DismissDirection dismissDirection3;
                                            Function1<DismissDirection, ThresholdConfig> function16 = function15;
                                            dismissDirection3 = SwipeToDismissKt.getDismissDirection(dismissValue2, dismissValue3);
                                            Intrinsics.checkNotNull(dismissDirection3);
                                            return function16.invoke(dismissDirection3);
                                        }
                                    };
                                    composer2.updateRememberedValue(rememberedValue);
                                }
                                Function2 function2 = (Function2) rememberedValue;
                                float f5 = set4.contains(dismissDirection2) ? 10.0f : 20.0f;
                                float f6 = set4.contains(dismissDirection) ? 10.0f : 20.0f;
                                Modifier.Companion companion = Modifier.INSTANCE;
                                m744swipeablepPrIpRY = SwipeableKt.m744swipeablepPrIpRY(companion, dismissState, mutableMapOf, Orientation.Horizontal, (r26 & 8) != 0 ? true : dismissState.getCurrentValue() == dismissValue, (r26 & 16) != 0 ? false : z5, (r26 & 32) != 0 ? null : null, (r26 & 64) != 0 ? new Function2() { // from class: androidx.compose.material.SwipeableKt$swipeable$1
                                    @Override // kotlin.jvm.functions.Function2
                                    public final FixedThreshold invoke(Object obj, Object obj2) {
                                        return new FixedThreshold(Dp.m2599constructorimpl(56), null);
                                    }
                                } : function2, (r26 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, mutableMapOf.keySet(), 0.0f, 0.0f, 6, null) : new ResistanceConfig(m2578getMaxWidthimpl, f5, f6), (r26 & 256) != 0 ? SwipeableDefaults.INSTANCE.m743getVelocityThresholdD9Ej5fM() : 0.0f);
                                Function3<RowScope, Composer, Integer, Unit> function33 = function3;
                                final DismissState dismissState2 = dismissState;
                                Function3<RowScope, Composer, Integer, Unit> function34 = function32;
                                Alignment.Companion companion2 = Alignment.INSTANCE;
                                MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                                Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, m744swipeablepPrIpRY);
                                ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                                Function0<ComposeUiNode> constructor = companion3.getConstructor();
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
                                Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
                                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
                                if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                    m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                    m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                }
                                Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
                                Modifier matchParentSize = BoxScopeInstance.INSTANCE.matchParentSize(companion);
                                Arrangement arrangement = Arrangement.INSTANCE;
                                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getTop(), composer2, 0);
                                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer2, matchParentSize);
                                Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
                                if (composer2.getApplier() == null) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer2.startReusableNode();
                                if (composer2.getInserting()) {
                                    composer2.createNode(constructor2);
                                } else {
                                    composer2.useNode();
                                }
                                Composer m1226constructorimpl2 = Updater.m1226constructorimpl(composer2);
                                Updater.m1227setimpl(m1226constructorimpl2, rowMeasurePolicy, companion3.getSetMeasurePolicy());
                                Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
                                if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                    m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                    m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                }
                                Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion3.getSetModifier());
                                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                function33.invoke(rowScopeInstance, composer2, 6);
                                composer2.endNode();
                                boolean changed2 = composer2.changed(dismissState2);
                                Object rememberedValue2 = composer2.rememberedValue();
                                if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue2 = new Function1<Density, IntOffset>() { // from class: androidx.compose.material.SwipeToDismissKt$SwipeToDismiss$2$1$1$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ IntOffset invoke(Density density) {
                                            return IntOffset.m2632boximpl(m742invokeBjo55l4(density));
                                        }

                                        /* renamed from: invoke-Bjo55l4, reason: not valid java name */
                                        public final long m742invokeBjo55l4(Density density) {
                                            return IntOffsetKt.IntOffset(MathKt.roundToInt(DismissState.this.getOffset().getValue().floatValue()), 0);
                                        }
                                    };
                                    composer2.updateRememberedValue(rememberedValue2);
                                }
                                Modifier offset = OffsetKt.offset(companion, (Function1) rememberedValue2);
                                MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getTop(), composer2, 0);
                                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                                Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer2, offset);
                                Function0<ComposeUiNode> constructor3 = companion3.getConstructor();
                                if (composer2.getApplier() == null) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer2.startReusableNode();
                                if (composer2.getInserting()) {
                                    composer2.createNode(constructor3);
                                } else {
                                    composer2.useNode();
                                }
                                Composer m1226constructorimpl3 = Updater.m1226constructorimpl(composer2);
                                Updater.m1227setimpl(m1226constructorimpl3, rowMeasurePolicy2, companion3.getSetMeasurePolicy());
                                Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap3, companion3.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion3.getSetCompositeKeyHash();
                                if (m1226constructorimpl3.getInserting() || !Intrinsics.areEqual(m1226constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                                    m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                                    m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                                }
                                Updater.m1227setimpl(m1226constructorimpl3, materializeModifier3, companion3.getSetModifier());
                                function34.invoke(rowScopeInstance, composer2, 6);
                                composer2.endNode();
                                composer2.endNode();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, startRestartGroup, 54), startRestartGroup, ((i7 >> 3) & 14) | 3072, 6);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        set3 = of;
                        function12 = function13;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        set3 = set2;
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                        final Modifier modifier4 = modifier3;
                        final Function1<? super DismissDirection, ? extends ThresholdConfig> function15 = function12;
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SwipeToDismissKt$SwipeToDismiss$3
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

                            public final void invoke(Composer composer2, int i11) {
                                SwipeToDismissKt.SwipeToDismiss(DismissState.this, modifier4, set3, function15, function3, function32, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
                            }
                        });
                        return;
                    }
                    return;
                }
                function12 = function1;
                if ((i6 & 16) == 0) {
                }
                if ((i6 & 32) == 0) {
                }
                if ((74899 & i7) == 74898) {
                }
                if (i10 == 0) {
                }
                if (i8 == 0) {
                }
                if (i9 == 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                final Set<? extends DismissDirection> set42 = of;
                final Function1<? super DismissDirection, ? extends ThresholdConfig> function142 = function13;
                BoxWithConstraintsKt.BoxWithConstraints(modifier3, null, false, ComposableLambdaKt.rememberComposableLambda(338007641, true, new Function3<BoxWithConstraintsScope, Composer, Integer, Unit>() { // from class: androidx.compose.material.SwipeToDismissKt$SwipeToDismiss$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer2, Integer num) {
                        invoke(boxWithConstraintsScope, composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer2, int i11) {
                        int i12;
                        Modifier m744swipeablepPrIpRY;
                        if ((i11 & 6) == 0) {
                            i12 = i11 | (composer2.changed(boxWithConstraintsScope) ? 4 : 2);
                        } else {
                            i12 = i11;
                        }
                        if ((i12 & 19) == 18 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(338007641, i12, -1, "androidx.compose.material.SwipeToDismiss.<anonymous> (SwipeToDismiss.kt:184)");
                        }
                        float m2578getMaxWidthimpl = Constraints.m2578getMaxWidthimpl(boxWithConstraintsScope.getConstraints());
                        boolean z5 = composer2.consume(CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl;
                        Float valueOf = Float.valueOf(0.0f);
                        DismissValue dismissValue = DismissValue.Default;
                        Map mutableMapOf = MapsKt.mutableMapOf(TuplesKt.to(valueOf, dismissValue));
                        Set<DismissDirection> set5 = set42;
                        DismissDirection dismissDirection = DismissDirection.StartToEnd;
                        if (set5.contains(dismissDirection)) {
                            Pair pair = TuplesKt.to(Float.valueOf(m2578getMaxWidthimpl), DismissValue.DismissedToEnd);
                            mutableMapOf.put(pair.getFirst(), pair.getSecond());
                        }
                        Set<DismissDirection> set6 = set42;
                        DismissDirection dismissDirection2 = DismissDirection.EndToStart;
                        if (set6.contains(dismissDirection2)) {
                            Pair pair2 = TuplesKt.to(Float.valueOf(-m2578getMaxWidthimpl), DismissValue.DismissedToStart);
                            mutableMapOf.put(pair2.getFirst(), pair2.getSecond());
                        }
                        boolean changed = composer2.changed(function142);
                        final Function1<? super DismissDirection, ? extends ThresholdConfig> function152 = function142;
                        Object rememberedValue = composer2.rememberedValue();
                        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                            rememberedValue = new Function2<DismissValue, DismissValue, ThresholdConfig>() { // from class: androidx.compose.material.SwipeToDismissKt$SwipeToDismiss$2$thresholds$1$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public final ThresholdConfig invoke(DismissValue dismissValue2, DismissValue dismissValue3) {
                                    DismissDirection dismissDirection3;
                                    Function1<DismissDirection, ThresholdConfig> function16 = function152;
                                    dismissDirection3 = SwipeToDismissKt.getDismissDirection(dismissValue2, dismissValue3);
                                    Intrinsics.checkNotNull(dismissDirection3);
                                    return function16.invoke(dismissDirection3);
                                }
                            };
                            composer2.updateRememberedValue(rememberedValue);
                        }
                        Function2 function2 = (Function2) rememberedValue;
                        float f5 = set42.contains(dismissDirection2) ? 10.0f : 20.0f;
                        float f6 = set42.contains(dismissDirection) ? 10.0f : 20.0f;
                        Modifier.Companion companion = Modifier.INSTANCE;
                        m744swipeablepPrIpRY = SwipeableKt.m744swipeablepPrIpRY(companion, dismissState, mutableMapOf, Orientation.Horizontal, (r26 & 8) != 0 ? true : dismissState.getCurrentValue() == dismissValue, (r26 & 16) != 0 ? false : z5, (r26 & 32) != 0 ? null : null, (r26 & 64) != 0 ? new Function2() { // from class: androidx.compose.material.SwipeableKt$swipeable$1
                            @Override // kotlin.jvm.functions.Function2
                            public final FixedThreshold invoke(Object obj, Object obj2) {
                                return new FixedThreshold(Dp.m2599constructorimpl(56), null);
                            }
                        } : function2, (r26 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, mutableMapOf.keySet(), 0.0f, 0.0f, 6, null) : new ResistanceConfig(m2578getMaxWidthimpl, f5, f6), (r26 & 256) != 0 ? SwipeableDefaults.INSTANCE.m743getVelocityThresholdD9Ej5fM() : 0.0f);
                        Function3<RowScope, Composer, Integer, Unit> function33 = function3;
                        final DismissState dismissState2 = dismissState;
                        Function3<RowScope, Composer, Integer, Unit> function34 = function32;
                        Alignment.Companion companion2 = Alignment.INSTANCE;
                        MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, m744swipeablepPrIpRY);
                        ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                        Function0<ComposeUiNode> constructor = companion3.getConstructor();
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
                        Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
                        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
                        if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
                        Modifier matchParentSize = BoxScopeInstance.INSTANCE.matchParentSize(companion);
                        Arrangement arrangement = Arrangement.INSTANCE;
                        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getTop(), composer2, 0);
                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                        Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer2, matchParentSize);
                        Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
                        if (composer2.getApplier() == null) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.createNode(constructor2);
                        } else {
                            composer2.useNode();
                        }
                        Composer m1226constructorimpl2 = Updater.m1226constructorimpl(composer2);
                        Updater.m1227setimpl(m1226constructorimpl2, rowMeasurePolicy, companion3.getSetMeasurePolicy());
                        Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
                        if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                            m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                            m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                        }
                        Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion3.getSetModifier());
                        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                        function33.invoke(rowScopeInstance, composer2, 6);
                        composer2.endNode();
                        boolean changed2 = composer2.changed(dismissState2);
                        Object rememberedValue2 = composer2.rememberedValue();
                        if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue2 = new Function1<Density, IntOffset>() { // from class: androidx.compose.material.SwipeToDismissKt$SwipeToDismiss$2$1$1$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ IntOffset invoke(Density density) {
                                    return IntOffset.m2632boximpl(m742invokeBjo55l4(density));
                                }

                                /* renamed from: invoke-Bjo55l4, reason: not valid java name */
                                public final long m742invokeBjo55l4(Density density) {
                                    return IntOffsetKt.IntOffset(MathKt.roundToInt(DismissState.this.getOffset().getValue().floatValue()), 0);
                                }
                            };
                            composer2.updateRememberedValue(rememberedValue2);
                        }
                        Modifier offset = OffsetKt.offset(companion, (Function1) rememberedValue2);
                        MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getTop(), composer2, 0);
                        int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                        Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer2, offset);
                        Function0<ComposeUiNode> constructor3 = companion3.getConstructor();
                        if (composer2.getApplier() == null) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.createNode(constructor3);
                        } else {
                            composer2.useNode();
                        }
                        Composer m1226constructorimpl3 = Updater.m1226constructorimpl(composer2);
                        Updater.m1227setimpl(m1226constructorimpl3, rowMeasurePolicy2, companion3.getSetMeasurePolicy());
                        Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap3, companion3.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion3.getSetCompositeKeyHash();
                        if (m1226constructorimpl3.getInserting() || !Intrinsics.areEqual(m1226constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                            m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                            m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                        }
                        Updater.m1227setimpl(m1226constructorimpl3, materializeModifier3, companion3.getSetModifier());
                        function34.invoke(rowScopeInstance, composer2, 6);
                        composer2.endNode();
                        composer2.endNode();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, startRestartGroup, 54), startRestartGroup, ((i7 >> 3) & 14) | 3072, 6);
                if (ComposerKt.isTraceInProgress()) {
                }
                set3 = of;
                function12 = function13;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            set2 = set;
            i9 = i6 & 8;
            if (i9 != 0) {
            }
            function12 = function1;
            if ((i6 & 16) == 0) {
            }
            if ((i6 & 32) == 0) {
            }
            if ((74899 & i7) == 74898) {
            }
            if (i10 == 0) {
            }
            if (i8 == 0) {
            }
            if (i9 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            final Set<? extends DismissDirection> set422 = of;
            final Function1<? super DismissDirection, ? extends ThresholdConfig> function1422 = function13;
            BoxWithConstraintsKt.BoxWithConstraints(modifier3, null, false, ComposableLambdaKt.rememberComposableLambda(338007641, true, new Function3<BoxWithConstraintsScope, Composer, Integer, Unit>() { // from class: androidx.compose.material.SwipeToDismissKt$SwipeToDismiss$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer2, Integer num) {
                    invoke(boxWithConstraintsScope, composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer2, int i11) {
                    int i12;
                    Modifier m744swipeablepPrIpRY;
                    if ((i11 & 6) == 0) {
                        i12 = i11 | (composer2.changed(boxWithConstraintsScope) ? 4 : 2);
                    } else {
                        i12 = i11;
                    }
                    if ((i12 & 19) == 18 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(338007641, i12, -1, "androidx.compose.material.SwipeToDismiss.<anonymous> (SwipeToDismiss.kt:184)");
                    }
                    float m2578getMaxWidthimpl = Constraints.m2578getMaxWidthimpl(boxWithConstraintsScope.getConstraints());
                    boolean z5 = composer2.consume(CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl;
                    Float valueOf = Float.valueOf(0.0f);
                    DismissValue dismissValue = DismissValue.Default;
                    Map mutableMapOf = MapsKt.mutableMapOf(TuplesKt.to(valueOf, dismissValue));
                    Set<DismissDirection> set5 = set422;
                    DismissDirection dismissDirection = DismissDirection.StartToEnd;
                    if (set5.contains(dismissDirection)) {
                        Pair pair = TuplesKt.to(Float.valueOf(m2578getMaxWidthimpl), DismissValue.DismissedToEnd);
                        mutableMapOf.put(pair.getFirst(), pair.getSecond());
                    }
                    Set<DismissDirection> set6 = set422;
                    DismissDirection dismissDirection2 = DismissDirection.EndToStart;
                    if (set6.contains(dismissDirection2)) {
                        Pair pair2 = TuplesKt.to(Float.valueOf(-m2578getMaxWidthimpl), DismissValue.DismissedToStart);
                        mutableMapOf.put(pair2.getFirst(), pair2.getSecond());
                    }
                    boolean changed = composer2.changed(function1422);
                    final Function1<? super DismissDirection, ? extends ThresholdConfig> function152 = function1422;
                    Object rememberedValue = composer2.rememberedValue();
                    if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                        rememberedValue = new Function2<DismissValue, DismissValue, ThresholdConfig>() { // from class: androidx.compose.material.SwipeToDismissKt$SwipeToDismiss$2$thresholds$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final ThresholdConfig invoke(DismissValue dismissValue2, DismissValue dismissValue3) {
                                DismissDirection dismissDirection3;
                                Function1<DismissDirection, ThresholdConfig> function16 = function152;
                                dismissDirection3 = SwipeToDismissKt.getDismissDirection(dismissValue2, dismissValue3);
                                Intrinsics.checkNotNull(dismissDirection3);
                                return function16.invoke(dismissDirection3);
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue);
                    }
                    Function2 function2 = (Function2) rememberedValue;
                    float f5 = set422.contains(dismissDirection2) ? 10.0f : 20.0f;
                    float f6 = set422.contains(dismissDirection) ? 10.0f : 20.0f;
                    Modifier.Companion companion = Modifier.INSTANCE;
                    m744swipeablepPrIpRY = SwipeableKt.m744swipeablepPrIpRY(companion, dismissState, mutableMapOf, Orientation.Horizontal, (r26 & 8) != 0 ? true : dismissState.getCurrentValue() == dismissValue, (r26 & 16) != 0 ? false : z5, (r26 & 32) != 0 ? null : null, (r26 & 64) != 0 ? new Function2() { // from class: androidx.compose.material.SwipeableKt$swipeable$1
                        @Override // kotlin.jvm.functions.Function2
                        public final FixedThreshold invoke(Object obj, Object obj2) {
                            return new FixedThreshold(Dp.m2599constructorimpl(56), null);
                        }
                    } : function2, (r26 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, mutableMapOf.keySet(), 0.0f, 0.0f, 6, null) : new ResistanceConfig(m2578getMaxWidthimpl, f5, f6), (r26 & 256) != 0 ? SwipeableDefaults.INSTANCE.m743getVelocityThresholdD9Ej5fM() : 0.0f);
                    Function3<RowScope, Composer, Integer, Unit> function33 = function3;
                    final DismissState dismissState2 = dismissState;
                    Function3<RowScope, Composer, Integer, Unit> function34 = function32;
                    Alignment.Companion companion2 = Alignment.INSTANCE;
                    MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, m744swipeablepPrIpRY);
                    ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                    Function0<ComposeUiNode> constructor = companion3.getConstructor();
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
                    Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
                    Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
                    if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
                    Modifier matchParentSize = BoxScopeInstance.INSTANCE.matchParentSize(companion);
                    Arrangement arrangement = Arrangement.INSTANCE;
                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getTop(), composer2, 0);
                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                    Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer2, matchParentSize);
                    Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
                    if (composer2.getApplier() == null) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor2);
                    } else {
                        composer2.useNode();
                    }
                    Composer m1226constructorimpl2 = Updater.m1226constructorimpl(composer2);
                    Updater.m1227setimpl(m1226constructorimpl2, rowMeasurePolicy, companion3.getSetMeasurePolicy());
                    Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
                    if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    }
                    Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion3.getSetModifier());
                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                    function33.invoke(rowScopeInstance, composer2, 6);
                    composer2.endNode();
                    boolean changed2 = composer2.changed(dismissState2);
                    Object rememberedValue2 = composer2.rememberedValue();
                    if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue2 = new Function1<Density, IntOffset>() { // from class: androidx.compose.material.SwipeToDismissKt$SwipeToDismiss$2$1$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ IntOffset invoke(Density density) {
                                return IntOffset.m2632boximpl(m742invokeBjo55l4(density));
                            }

                            /* renamed from: invoke-Bjo55l4, reason: not valid java name */
                            public final long m742invokeBjo55l4(Density density) {
                                return IntOffsetKt.IntOffset(MathKt.roundToInt(DismissState.this.getOffset().getValue().floatValue()), 0);
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue2);
                    }
                    Modifier offset = OffsetKt.offset(companion, (Function1) rememberedValue2);
                    MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getTop(), composer2, 0);
                    int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                    Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer2, offset);
                    Function0<ComposeUiNode> constructor3 = companion3.getConstructor();
                    if (composer2.getApplier() == null) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor3);
                    } else {
                        composer2.useNode();
                    }
                    Composer m1226constructorimpl3 = Updater.m1226constructorimpl(composer2);
                    Updater.m1227setimpl(m1226constructorimpl3, rowMeasurePolicy2, companion3.getSetMeasurePolicy());
                    Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap3, companion3.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion3.getSetCompositeKeyHash();
                    if (m1226constructorimpl3.getInserting() || !Intrinsics.areEqual(m1226constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                        m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                    }
                    Updater.m1227setimpl(m1226constructorimpl3, materializeModifier3, companion3.getSetModifier());
                    function34.invoke(rowScopeInstance, composer2, 6);
                    composer2.endNode();
                    composer2.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), startRestartGroup, ((i7 >> 3) & 14) | 3072, 6);
            if (ComposerKt.isTraceInProgress()) {
            }
            set3 = of;
            function12 = function13;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i8 = i6 & 4;
        if (i8 == 0) {
        }
        set2 = set;
        i9 = i6 & 8;
        if (i9 != 0) {
        }
        function12 = function1;
        if ((i6 & 16) == 0) {
        }
        if ((i6 & 32) == 0) {
        }
        if ((74899 & i7) == 74898) {
        }
        if (i10 == 0) {
        }
        if (i8 == 0) {
        }
        if (i9 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        final Set<? extends DismissDirection> set4222 = of;
        final Function1<? super DismissDirection, ? extends ThresholdConfig> function14222 = function13;
        BoxWithConstraintsKt.BoxWithConstraints(modifier3, null, false, ComposableLambdaKt.rememberComposableLambda(338007641, true, new Function3<BoxWithConstraintsScope, Composer, Integer, Unit>() { // from class: androidx.compose.material.SwipeToDismissKt$SwipeToDismiss$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer2, Integer num) {
                invoke(boxWithConstraintsScope, composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer2, int i11) {
                int i12;
                Modifier m744swipeablepPrIpRY;
                if ((i11 & 6) == 0) {
                    i12 = i11 | (composer2.changed(boxWithConstraintsScope) ? 4 : 2);
                } else {
                    i12 = i11;
                }
                if ((i12 & 19) == 18 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(338007641, i12, -1, "androidx.compose.material.SwipeToDismiss.<anonymous> (SwipeToDismiss.kt:184)");
                }
                float m2578getMaxWidthimpl = Constraints.m2578getMaxWidthimpl(boxWithConstraintsScope.getConstraints());
                boolean z5 = composer2.consume(CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl;
                Float valueOf = Float.valueOf(0.0f);
                DismissValue dismissValue = DismissValue.Default;
                Map mutableMapOf = MapsKt.mutableMapOf(TuplesKt.to(valueOf, dismissValue));
                Set<DismissDirection> set5 = set4222;
                DismissDirection dismissDirection = DismissDirection.StartToEnd;
                if (set5.contains(dismissDirection)) {
                    Pair pair = TuplesKt.to(Float.valueOf(m2578getMaxWidthimpl), DismissValue.DismissedToEnd);
                    mutableMapOf.put(pair.getFirst(), pair.getSecond());
                }
                Set<DismissDirection> set6 = set4222;
                DismissDirection dismissDirection2 = DismissDirection.EndToStart;
                if (set6.contains(dismissDirection2)) {
                    Pair pair2 = TuplesKt.to(Float.valueOf(-m2578getMaxWidthimpl), DismissValue.DismissedToStart);
                    mutableMapOf.put(pair2.getFirst(), pair2.getSecond());
                }
                boolean changed = composer2.changed(function14222);
                final Function1<? super DismissDirection, ? extends ThresholdConfig> function152 = function14222;
                Object rememberedValue = composer2.rememberedValue();
                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function2<DismissValue, DismissValue, ThresholdConfig>() { // from class: androidx.compose.material.SwipeToDismissKt$SwipeToDismiss$2$thresholds$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final ThresholdConfig invoke(DismissValue dismissValue2, DismissValue dismissValue3) {
                            DismissDirection dismissDirection3;
                            Function1<DismissDirection, ThresholdConfig> function16 = function152;
                            dismissDirection3 = SwipeToDismissKt.getDismissDirection(dismissValue2, dismissValue3);
                            Intrinsics.checkNotNull(dismissDirection3);
                            return function16.invoke(dismissDirection3);
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue);
                }
                Function2 function2 = (Function2) rememberedValue;
                float f5 = set4222.contains(dismissDirection2) ? 10.0f : 20.0f;
                float f6 = set4222.contains(dismissDirection) ? 10.0f : 20.0f;
                Modifier.Companion companion = Modifier.INSTANCE;
                m744swipeablepPrIpRY = SwipeableKt.m744swipeablepPrIpRY(companion, dismissState, mutableMapOf, Orientation.Horizontal, (r26 & 8) != 0 ? true : dismissState.getCurrentValue() == dismissValue, (r26 & 16) != 0 ? false : z5, (r26 & 32) != 0 ? null : null, (r26 & 64) != 0 ? new Function2() { // from class: androidx.compose.material.SwipeableKt$swipeable$1
                    @Override // kotlin.jvm.functions.Function2
                    public final FixedThreshold invoke(Object obj, Object obj2) {
                        return new FixedThreshold(Dp.m2599constructorimpl(56), null);
                    }
                } : function2, (r26 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, mutableMapOf.keySet(), 0.0f, 0.0f, 6, null) : new ResistanceConfig(m2578getMaxWidthimpl, f5, f6), (r26 & 256) != 0 ? SwipeableDefaults.INSTANCE.m743getVelocityThresholdD9Ej5fM() : 0.0f);
                Function3<RowScope, Composer, Integer, Unit> function33 = function3;
                final DismissState dismissState2 = dismissState;
                Function3<RowScope, Composer, Integer, Unit> function34 = function32;
                Alignment.Companion companion2 = Alignment.INSTANCE;
                MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, m744swipeablepPrIpRY);
                ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor = companion3.getConstructor();
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
                Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
                if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
                Modifier matchParentSize = BoxScopeInstance.INSTANCE.matchParentSize(companion);
                Arrangement arrangement = Arrangement.INSTANCE;
                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getTop(), composer2, 0);
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer2, matchParentSize);
                Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
                if (composer2.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor2);
                } else {
                    composer2.useNode();
                }
                Composer m1226constructorimpl2 = Updater.m1226constructorimpl(composer2);
                Updater.m1227setimpl(m1226constructorimpl2, rowMeasurePolicy, companion3.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
                if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion3.getSetModifier());
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                function33.invoke(rowScopeInstance, composer2, 6);
                composer2.endNode();
                boolean changed2 = composer2.changed(dismissState2);
                Object rememberedValue2 = composer2.rememberedValue();
                if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue2 = new Function1<Density, IntOffset>() { // from class: androidx.compose.material.SwipeToDismissKt$SwipeToDismiss$2$1$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ IntOffset invoke(Density density) {
                            return IntOffset.m2632boximpl(m742invokeBjo55l4(density));
                        }

                        /* renamed from: invoke-Bjo55l4, reason: not valid java name */
                        public final long m742invokeBjo55l4(Density density) {
                            return IntOffsetKt.IntOffset(MathKt.roundToInt(DismissState.this.getOffset().getValue().floatValue()), 0);
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue2);
                }
                Modifier offset = OffsetKt.offset(companion, (Function1) rememberedValue2);
                MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getTop(), composer2, 0);
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer2, offset);
                Function0<ComposeUiNode> constructor3 = companion3.getConstructor();
                if (composer2.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor3);
                } else {
                    composer2.useNode();
                }
                Composer m1226constructorimpl3 = Updater.m1226constructorimpl(composer2);
                Updater.m1227setimpl(m1226constructorimpl3, rowMeasurePolicy2, companion3.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap3, companion3.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion3.getSetCompositeKeyHash();
                if (m1226constructorimpl3.getInserting() || !Intrinsics.areEqual(m1226constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                    m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                Updater.m1227setimpl(m1226constructorimpl3, materializeModifier3, companion3.getSetModifier());
                function34.invoke(rowScopeInstance, composer2, 6);
                composer2.endNode();
                composer2.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, startRestartGroup, 54), startRestartGroup, ((i7 >> 3) & 14) | 3072, 6);
        if (ComposerKt.isTraceInProgress()) {
        }
        set3 = of;
        function12 = function13;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DismissDirection getDismissDirection(DismissValue dismissValue, DismissValue dismissValue2) {
        if (dismissValue == dismissValue2 && dismissValue == DismissValue.Default) {
            return null;
        }
        if (dismissValue == dismissValue2 && dismissValue == DismissValue.DismissedToEnd) {
            return DismissDirection.StartToEnd;
        }
        if (dismissValue == dismissValue2 && dismissValue == DismissValue.DismissedToStart) {
            return DismissDirection.EndToStart;
        }
        DismissValue dismissValue3 = DismissValue.Default;
        if (dismissValue == dismissValue3 && dismissValue2 == DismissValue.DismissedToEnd) {
            return DismissDirection.StartToEnd;
        }
        if (dismissValue == dismissValue3 && dismissValue2 == DismissValue.DismissedToStart) {
            return DismissDirection.EndToStart;
        }
        if (dismissValue == DismissValue.DismissedToEnd && dismissValue2 == dismissValue3) {
            return DismissDirection.StartToEnd;
        }
        if (dismissValue == DismissValue.DismissedToStart && dismissValue2 == dismissValue3) {
            return DismissDirection.EndToStart;
        }
        return null;
    }

    public static final DismissState rememberDismissState(final DismissValue dismissValue, final Function1<? super DismissValue, Boolean> function1, Composer composer, int i5, int i6) {
        if ((i6 & 1) != 0) {
            dismissValue = DismissValue.Default;
        }
        if ((i6 & 2) != 0) {
            function1 = new Function1<DismissValue, Boolean>() { // from class: androidx.compose.material.SwipeToDismissKt$rememberDismissState$1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(DismissValue dismissValue2) {
                    return Boolean.TRUE;
                }
            };
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1753522702, i5, -1, "androidx.compose.material.rememberDismissState (SwipeToDismiss.kt:152)");
        }
        Object[] objArr = new Object[0];
        Saver<DismissState, DismissValue> Saver = DismissState.INSTANCE.Saver(function1);
        boolean z5 = ((((i5 & 14) ^ 6) > 4 && composer.changed(dismissValue)) || (i5 & 6) == 4) | ((((i5 & 112) ^ 48) > 32 && composer.changed(function1)) || (i5 & 48) == 32);
        Object rememberedValue = composer.rememberedValue();
        if (z5 || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function0<DismissState>() { // from class: androidx.compose.material.SwipeToDismissKt$rememberDismissState$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final DismissState invoke() {
                    return new DismissState(DismissValue.this, function1);
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        DismissState dismissState = (DismissState) RememberSaveableKt.rememberSaveable(objArr, Saver, null, (Function0) rememberedValue, composer, 0, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return dismissState;
    }
}
