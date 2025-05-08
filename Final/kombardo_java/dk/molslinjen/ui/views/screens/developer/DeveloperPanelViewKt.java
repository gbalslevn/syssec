package dk.molslinjen.ui.views.screens.developer;

import android.content.res.Configuration;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import com.ramcosta.composedestinations.generated.destinations.DeveloperBottomSheetWithStickyScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.DeveloperComponentsScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.DeveloperInputComponentsScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.DeveloperNavigationScreenDestination;
import dk.molslinjen.extensions.ComposeExtensionsKt;
import dk.molslinjen.ui.views.reusable.dialog.CustomDialogKt;
import dk.molslinjen.ui.views.reusable.dialog.SimpleButtonData;
import dk.molslinjen.ui.views.screens.developer.DeveloperPanelViewKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0003\u0010\u0004\u001a%\u0010\b\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0001\u001a\u00020\u0000H\u0003¢\u0006\u0004\b\b\u0010\t\u001a%\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\fH\u0003¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0013²\u0006\u000e\u0010\u0011\u001a\u00020\u00108\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u0012\u001a\u00020\u00068\n@\nX\u008a\u008e\u0002"}, d2 = {"Landroidx/navigation/NavController;", "navController", BuildConfig.FLAVOR, "DeveloperPanelView", "(Landroidx/navigation/NavController;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/runtime/MutableState;", BuildConfig.FLAVOR, "expanded", "DeveloperPanelExpanded", "(Landroidx/compose/runtime/MutableState;Landroidx/navigation/NavController;Landroidx/compose/runtime/Composer;I)V", BuildConfig.FLAVOR, "text", "Lkotlin/Function0;", "onClick", "DeveloperTextButton", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", BuildConfig.FLAVOR, "offsetY", "showDialog", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class DeveloperPanelViewKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void DeveloperPanelExpanded(final MutableState<Boolean> mutableState, final NavController navController, Composer composer, final int i5) {
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(-1411125495);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(mutableState) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(navController) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1411125495, i6, -1, "dk.molslinjen.ui.views.screens.developer.DeveloperPanelExpanded (DeveloperPanelView.kt:107)");
            }
            startRestartGroup.startReplaceGroup(-825643458);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final MutableState mutableState2 = (MutableState) rememberedValue;
            startRestartGroup.endReplaceGroup();
            Modifier m104backgroundbw27NRU$default = BackgroundKt.m104backgroundbw27NRU$default(Modifier.INSTANCE, MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).getInverseSurface(), null, 2, null);
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m104backgroundbw27NRU$default);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion2.getConstructor();
            if (startRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            startRestartGroup.startReplaceGroup(-1287565710);
            int i7 = i6 & 14;
            boolean changedInstance = (i7 == 4) | startRestartGroup.changedInstance(navController);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: l3.q
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit DeveloperPanelExpanded$lambda$26$lambda$17$lambda$16;
                        DeveloperPanelExpanded$lambda$26$lambda$17$lambda$16 = DeveloperPanelViewKt.DeveloperPanelExpanded$lambda$26$lambda$17$lambda$16(MutableState.this, navController);
                        return DeveloperPanelExpanded$lambda$26$lambda$17$lambda$16;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            DeveloperTextButton("Bot/Top nav test", (Function0) rememberedValue2, startRestartGroup, 6);
            startRestartGroup.startReplaceGroup(-1287560169);
            boolean changedInstance2 = startRestartGroup.changedInstance(navController) | (i7 == 4);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue3 == companion.getEmpty()) {
                rememberedValue3 = new Function0() { // from class: l3.r
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit DeveloperPanelExpanded$lambda$26$lambda$19$lambda$18;
                        DeveloperPanelExpanded$lambda$26$lambda$19$lambda$18 = DeveloperPanelViewKt.DeveloperPanelExpanded$lambda$26$lambda$19$lambda$18(MutableState.this, navController);
                        return DeveloperPanelExpanded$lambda$26$lambda$19$lambda$18;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceGroup();
            DeveloperTextButton("Inputs preview", (Function0) rememberedValue3, startRestartGroup, 6);
            startRestartGroup.startReplaceGroup(-1287554342);
            boolean changedInstance3 = startRestartGroup.changedInstance(navController);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (changedInstance3 || rememberedValue4 == companion.getEmpty()) {
                rememberedValue4 = new Function0() { // from class: l3.s
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit DeveloperPanelExpanded$lambda$26$lambda$21$lambda$20;
                        DeveloperPanelExpanded$lambda$26$lambda$21$lambda$20 = DeveloperPanelViewKt.DeveloperPanelExpanded$lambda$26$lambda$21$lambda$20(NavController.this);
                        return DeveloperPanelExpanded$lambda$26$lambda$21$lambda$20;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            startRestartGroup.endReplaceGroup();
            DeveloperTextButton("Trigger bottomsheet", (Function0) rememberedValue4, startRestartGroup, 6);
            startRestartGroup.startReplaceGroup(-1287549724);
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (rememberedValue5 == companion.getEmpty()) {
                rememberedValue5 = new Function0() { // from class: l3.t
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit DeveloperPanelExpanded$lambda$26$lambda$23$lambda$22;
                        DeveloperPanelExpanded$lambda$26$lambda$23$lambda$22 = DeveloperPanelViewKt.DeveloperPanelExpanded$lambda$26$lambda$23$lambda$22(MutableState.this);
                        return DeveloperPanelExpanded$lambda$26$lambda$23$lambda$22;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            startRestartGroup.endReplaceGroup();
            DeveloperTextButton("Show dialog", (Function0) rememberedValue5, startRestartGroup, 54);
            startRestartGroup.startReplaceGroup(-1287546769);
            boolean changedInstance4 = startRestartGroup.changedInstance(navController);
            Object rememberedValue6 = startRestartGroup.rememberedValue();
            if (changedInstance4 || rememberedValue6 == companion.getEmpty()) {
                rememberedValue6 = new Function0() { // from class: l3.u
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit DeveloperPanelExpanded$lambda$26$lambda$25$lambda$24;
                        DeveloperPanelExpanded$lambda$26$lambda$25$lambda$24 = DeveloperPanelViewKt.DeveloperPanelExpanded$lambda$26$lambda$25$lambda$24(NavController.this);
                        return DeveloperPanelExpanded$lambda$26$lambda$25$lambda$24;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue6);
            }
            startRestartGroup.endReplaceGroup();
            DeveloperTextButton("Components", (Function0) rememberedValue6, startRestartGroup, 6);
            startRestartGroup.endNode();
            if (DeveloperPanelExpanded$lambda$14(mutableState2)) {
                startRestartGroup.startReplaceGroup(-825611886);
                Object rememberedValue7 = startRestartGroup.rememberedValue();
                if (rememberedValue7 == companion.getEmpty()) {
                    rememberedValue7 = new Function0() { // from class: l3.v
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit DeveloperPanelExpanded$lambda$28$lambda$27;
                            DeveloperPanelExpanded$lambda$28$lambda$27 = DeveloperPanelViewKt.DeveloperPanelExpanded$lambda$28$lambda$27(MutableState.this);
                            return DeveloperPanelExpanded$lambda$28$lambda$27;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue7);
                }
                startRestartGroup.endReplaceGroup();
                SimpleButtonData simpleButtonData = new SimpleButtonData("OK", false, false, (Function0) rememberedValue7, 6, null);
                startRestartGroup.startReplaceGroup(-825609996);
                Object rememberedValue8 = startRestartGroup.rememberedValue();
                if (rememberedValue8 == companion.getEmpty()) {
                    rememberedValue8 = new Function0() { // from class: l3.k
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue8);
                }
                startRestartGroup.endReplaceGroup();
                CustomDialogKt.CustomDialog(simpleButtonData, null, null, (Function0) rememberedValue8, false, ComposableSingletons$DeveloperPanelViewKt.INSTANCE.m3488getLambda2$app_kombardoProd(), startRestartGroup, 199680, 22);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: l3.l
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit DeveloperPanelExpanded$lambda$31;
                    DeveloperPanelExpanded$lambda$31 = DeveloperPanelViewKt.DeveloperPanelExpanded$lambda$31(MutableState.this, navController, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return DeveloperPanelExpanded$lambda$31;
                }
            });
        }
    }

    private static final boolean DeveloperPanelExpanded$lambda$14(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void DeveloperPanelExpanded$lambda$15(MutableState<Boolean> mutableState, boolean z5) {
        mutableState.setValue(Boolean.valueOf(z5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeveloperPanelExpanded$lambda$26$lambda$17$lambda$16(MutableState mutableState, NavController navController) {
        mutableState.setValue(Boolean.FALSE);
        NavController.navigate$default(navController, DeveloperNavigationScreenDestination.INSTANCE, (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeveloperPanelExpanded$lambda$26$lambda$19$lambda$18(MutableState mutableState, NavController navController) {
        mutableState.setValue(Boolean.FALSE);
        NavController.navigate$default(navController, DeveloperInputComponentsScreenDestination.INSTANCE, (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeveloperPanelExpanded$lambda$26$lambda$21$lambda$20(NavController navController) {
        NavController.navigate$default(navController, DeveloperBottomSheetWithStickyScreenDestination.INSTANCE, (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeveloperPanelExpanded$lambda$26$lambda$23$lambda$22(MutableState mutableState) {
        DeveloperPanelExpanded$lambda$15(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeveloperPanelExpanded$lambda$26$lambda$25$lambda$24(NavController navController) {
        NavController.navigate$default(navController, DeveloperComponentsScreenDestination.INSTANCE, (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeveloperPanelExpanded$lambda$28$lambda$27(MutableState mutableState) {
        DeveloperPanelExpanded$lambda$15(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeveloperPanelExpanded$lambda$31(MutableState mutableState, NavController navController, int i5, Composer composer, int i6) {
        DeveloperPanelExpanded(mutableState, navController, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void DeveloperPanelView(final NavController navController, Composer composer, final int i5) {
        int i6;
        Modifier draggable;
        Intrinsics.checkNotNullParameter(navController, "navController");
        Composer startRestartGroup = composer.startRestartGroup(-1678214806);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(navController) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i6 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1678214806, i6, -1, "dk.molslinjen.ui.views.screens.developer.DeveloperPanelView (DeveloperPanelView.kt:54)");
            }
            startRestartGroup.startReplaceGroup(-679230230);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final MutableState mutableState = (MutableState) rememberedValue;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-679228459);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(200.0f), null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            final MutableState mutableState2 = (MutableState) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            final int max = Math.max(0, Math.min(MathKt.roundToInt(DeveloperPanelView$lambda$2(mutableState2)), ComposeExtensionsKt.dpToPx(((Configuration) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration())).screenHeightDp, startRestartGroup, 0) - 200));
            Modifier.Companion companion2 = Modifier.INSTANCE;
            Modifier alpha = AlphaKt.alpha(SizeKt.fillMaxHeight$default(companion2, 0.0f, 1, null), 0.7f);
            Alignment.Companion companion3 = Alignment.INSTANCE;
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getTopStart(), false);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, alpha);
            ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion4.getConstructor();
            if (startRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion4.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion4.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion4.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion4.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            startRestartGroup.startReplaceGroup(-1378334868);
            boolean changed = startRestartGroup.changed(max);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue3 == companion.getEmpty()) {
                rememberedValue3 = new Function1() { // from class: l3.j
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        IntOffset DeveloperPanelView$lambda$11$lambda$5$lambda$4;
                        DeveloperPanelView$lambda$11$lambda$5$lambda$4 = DeveloperPanelViewKt.DeveloperPanelView$lambda$11$lambda$5$lambda$4(max, (Density) obj);
                        return DeveloperPanelView$lambda$11$lambda$5$lambda$4;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceGroup();
            Modifier offset = OffsetKt.offset(companion2, (Function1) rememberedValue3);
            Orientation orientation = Orientation.Vertical;
            startRestartGroup.startReplaceGroup(-1378328304);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (rememberedValue4 == companion.getEmpty()) {
                rememberedValue4 = new Function1() { // from class: l3.n
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit DeveloperPanelView$lambda$11$lambda$7$lambda$6;
                        DeveloperPanelView$lambda$11$lambda$7$lambda$6 = DeveloperPanelViewKt.DeveloperPanelView$lambda$11$lambda$7$lambda$6(MutableState.this, ((Float) obj).floatValue());
                        return DeveloperPanelView$lambda$11$lambda$7$lambda$6;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            startRestartGroup.endReplaceGroup();
            draggable = DraggableKt.draggable(offset, DraggableKt.rememberDraggableState((Function1) rememberedValue4, startRestartGroup, 6), orientation, (r20 & 4) != 0, (r20 & 8) != 0 ? null : null, (r20 & 16) != 0 ? false : false, (r20 & 32) != 0 ? DraggableKt.NoOpOnDragStarted : null, (r20 & 64) != 0 ? DraggableKt.NoOpOnDragStopped : null, (r20 & 128) != 0 ? false : false);
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), companion3.getStart(), startRestartGroup, 0);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, draggable);
            Function0<ComposeUiNode> constructor2 = companion4.getConstructor();
            if (startRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor2);
            } else {
                startRestartGroup.useNode();
            }
            Composer m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl2, columnMeasurePolicy, companion4.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion4.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion4.getSetCompositeKeyHash();
            if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion4.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            Modifier m104backgroundbw27NRU$default = BackgroundKt.m104backgroundbw27NRU$default(companion2, MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).getInverseSurface(), null, 2, null);
            startRestartGroup.startReplaceGroup(-1955545366);
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (rememberedValue5 == companion.getEmpty()) {
                rememberedValue5 = new Function0() { // from class: l3.o
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit DeveloperPanelView$lambda$11$lambda$10$lambda$9$lambda$8;
                        DeveloperPanelView$lambda$11$lambda$10$lambda$9$lambda$8 = DeveloperPanelViewKt.DeveloperPanelView$lambda$11$lambda$10$lambda$9$lambda$8(MutableState.this);
                        return DeveloperPanelView$lambda$11$lambda$10$lambda$9$lambda$8;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            startRestartGroup.endReplaceGroup();
            IconButtonKt.IconButton((Function0) rememberedValue5, m104backgroundbw27NRU$default, false, null, null, ComposableSingletons$DeveloperPanelViewKt.INSTANCE.m3487getLambda1$app_kombardoProd(), startRestartGroup, 196614, 28);
            AnimatedVisibilityKt.AnimatedVisibility(columnScopeInstance, ((Boolean) mutableState.getValue()).booleanValue(), (Modifier) null, EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null), EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null), (String) null, ComposableLambdaKt.rememberComposableLambda(262999102, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.developer.DeveloperPanelViewKt$DeveloperPanelView$1$3$2
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer2, Integer num) {
                    invoke(animatedVisibilityScope, composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer composer2, int i7) {
                    Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(262999102, i7, -1, "dk.molslinjen.ui.views.screens.developer.DeveloperPanelView.<anonymous>.<anonymous>.<anonymous> (DeveloperPanelView.kt:97)");
                    }
                    DeveloperPanelViewKt.DeveloperPanelExpanded(mutableState, navController, composer2, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), startRestartGroup, 1600518, 18);
            startRestartGroup.endNode();
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: l3.p
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit DeveloperPanelView$lambda$12;
                    DeveloperPanelView$lambda$12 = DeveloperPanelViewKt.DeveloperPanelView$lambda$12(NavController.this, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return DeveloperPanelView$lambda$12;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeveloperPanelView$lambda$11$lambda$10$lambda$9$lambda$8(MutableState mutableState) {
        mutableState.setValue(Boolean.valueOf(!((Boolean) mutableState.getValue()).booleanValue()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IntOffset DeveloperPanelView$lambda$11$lambda$5$lambda$4(int i5, Density offset) {
        Intrinsics.checkNotNullParameter(offset, "$this$offset");
        return IntOffset.m2632boximpl(IntOffsetKt.IntOffset(0, i5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeveloperPanelView$lambda$11$lambda$7$lambda$6(MutableState mutableState, float f5) {
        DeveloperPanelView$lambda$3(mutableState, DeveloperPanelView$lambda$2(mutableState) + f5);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeveloperPanelView$lambda$12(NavController navController, int i5, Composer composer, int i6) {
        DeveloperPanelView(navController, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    private static final float DeveloperPanelView$lambda$2(MutableState<Float> mutableState) {
        return mutableState.getValue().floatValue();
    }

    private static final void DeveloperPanelView$lambda$3(MutableState<Float> mutableState, float f5) {
        mutableState.setValue(Float.valueOf(f5));
    }

    private static final void DeveloperTextButton(final String str, final Function0<Unit> function0, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(442539844);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(str) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(442539844, i6, -1, "dk.molslinjen.ui.views.screens.developer.DeveloperTextButton (DeveloperPanelView.kt:157)");
            }
            composer2 = startRestartGroup;
            ButtonKt.TextButton(function0, null, false, null, null, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(-632014719, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.developer.DeveloperPanelViewKt$DeveloperTextButton$1
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer3, Integer num) {
                    invoke(rowScope, composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(RowScope TextButton, Composer composer3, int i7) {
                    Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
                    if ((i7 & 17) == 16 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-632014719, i7, -1, "dk.molslinjen.ui.views.screens.developer.DeveloperTextButton.<anonymous> (DeveloperPanelView.kt:159)");
                    }
                    TextKt.m940Text4IGK_g(str, null, MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getInverseOnSurface(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer3, 0, 0, 131066);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), startRestartGroup, ((i6 >> 3) & 14) | 805306368, 510);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: l3.m
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit DeveloperTextButton$lambda$32;
                    DeveloperTextButton$lambda$32 = DeveloperPanelViewKt.DeveloperTextButton$lambda$32(str, function0, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return DeveloperTextButton$lambda$32;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeveloperTextButton$lambda$32(String str, Function0 function0, int i5, Composer composer, int i6) {
        DeveloperTextButton(str, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
