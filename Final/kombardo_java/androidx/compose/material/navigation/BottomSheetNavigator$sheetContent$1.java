package androidx.compose.material.navigation;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.material.ModalBottomSheetState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import androidx.compose.runtime.saveable.SaveableStateHolderKt;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavigatorState;
import androidx.view.compose.BackHandlerKt;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.StateFlow;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u000b¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Landroidx/compose/foundation/layout/ColumnScope;", "invoke", "(Landroidx/compose/foundation/layout/ColumnScope;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BottomSheetNavigator$sheetContent$1 extends Lambda implements Function3<ColumnScope, Composer, Integer, Unit> {
    final /* synthetic */ BottomSheetNavigator this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BottomSheetNavigator$sheetContent$1(BottomSheetNavigator bottomSheetNavigator) {
        super(3);
        this.this$0 = bottomSheetNavigator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Set<NavBackStackEntry> invoke$lambda$0(State<? extends Set<NavBackStackEntry>> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NavBackStackEntry invoke$lambda$2(State<NavBackStackEntry> state) {
        return state.getValue();
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
        invoke(columnScope, composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(ColumnScope columnScope, Composer composer, int i5) {
        StateFlow backStack;
        if ((i5 & 6) == 0) {
            i5 |= composer.changed(columnScope) ? 4 : 2;
        }
        if ((i5 & 19) == 18 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1433084388, i5, -1, "androidx.compose.material.navigation.BottomSheetNavigator.sheetContent.<anonymous> (BottomSheetNavigator.kt:146)");
        }
        SaveableStateHolder rememberSaveableStateHolder = SaveableStateHolderKt.rememberSaveableStateHolder(composer, 0);
        final State collectAsState = SnapshotStateKt.collectAsState(this.this$0.getTransitionsInProgress$material_navigation_release(), null, composer, 0, 1);
        backStack = this.this$0.getBackStack();
        boolean changedInstance = composer.changedInstance(this.this$0);
        BottomSheetNavigator bottomSheetNavigator = this.this$0;
        Object rememberedValue = composer.rememberedValue();
        if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new BottomSheetNavigator$sheetContent$1$retainedEntry$2$1(bottomSheetNavigator, null);
            composer.updateRememberedValue(rememberedValue);
        }
        final State produceState = SnapshotStateKt.produceState(null, backStack, (Function2) rememberedValue, composer, 6);
        if (invoke$lambda$2(produceState) != null) {
            composer.startReplaceGroup(1881932140);
            NavBackStackEntry invoke$lambda$2 = invoke$lambda$2(produceState);
            boolean changedInstance2 = composer.changedInstance(this.this$0);
            BottomSheetNavigator bottomSheetNavigator2 = this.this$0;
            Object rememberedValue2 = composer.rememberedValue();
            if (changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new BottomSheetNavigator$sheetContent$1$1$1(bottomSheetNavigator2, null);
                composer.updateRememberedValue(rememberedValue2);
            }
            EffectsKt.LaunchedEffect(invoke$lambda$2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue2, composer, 0);
            boolean changedInstance3 = composer.changedInstance(this.this$0) | composer.changed(produceState);
            final BottomSheetNavigator bottomSheetNavigator3 = this.this$0;
            Object rememberedValue3 = composer.rememberedValue();
            if (changedInstance3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = new Function0<Unit>() { // from class: androidx.compose.material.navigation.BottomSheetNavigator$sheetContent$1$2$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        NavigatorState state;
                        NavBackStackEntry invoke$lambda$22;
                        state = BottomSheetNavigator.this.getState();
                        invoke$lambda$22 = BottomSheetNavigator$sheetContent$1.invoke$lambda$2(produceState);
                        Intrinsics.checkNotNull(invoke$lambda$22);
                        state.popWithTransition(invoke$lambda$22, false);
                    }
                };
                composer.updateRememberedValue(rememberedValue3);
            }
            BackHandlerKt.BackHandler(false, (Function0) rememberedValue3, composer, 0, 1);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(1882153170);
            composer.endReplaceGroup();
        }
        NavBackStackEntry invoke$lambda$22 = invoke$lambda$2(produceState);
        ModalBottomSheetState sheetState = this.this$0.getSheetState();
        boolean changed = composer.changed(collectAsState) | composer.changedInstance(this.this$0);
        final BottomSheetNavigator bottomSheetNavigator4 = this.this$0;
        Object rememberedValue4 = composer.rememberedValue();
        if (changed || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
            rememberedValue4 = new Function1<NavBackStackEntry, Unit>() { // from class: androidx.compose.material.navigation.BottomSheetNavigator$sheetContent$1$3$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(NavBackStackEntry navBackStackEntry) {
                    invoke2(navBackStackEntry);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(NavBackStackEntry navBackStackEntry) {
                    Set invoke$lambda$0;
                    NavigatorState state;
                    invoke$lambda$0 = BottomSheetNavigator$sheetContent$1.invoke$lambda$0(collectAsState);
                    state = BottomSheetNavigator.this.getState();
                    Iterator it = invoke$lambda$0.iterator();
                    while (it.hasNext()) {
                        state.markTransitionComplete((NavBackStackEntry) it.next());
                    }
                }
            };
            composer.updateRememberedValue(rememberedValue4);
        }
        Function1 function1 = (Function1) rememberedValue4;
        boolean changed2 = composer.changed(collectAsState) | composer.changedInstance(this.this$0);
        final BottomSheetNavigator bottomSheetNavigator5 = this.this$0;
        Object rememberedValue5 = composer.rememberedValue();
        if (changed2 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
            rememberedValue5 = new Function1<NavBackStackEntry, Unit>() { // from class: androidx.compose.material.navigation.BottomSheetNavigator$sheetContent$1$4$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(NavBackStackEntry navBackStackEntry) {
                    invoke2(navBackStackEntry);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(NavBackStackEntry navBackStackEntry) {
                    Set invoke$lambda$0;
                    NavigatorState state;
                    NavigatorState state2;
                    invoke$lambda$0 = BottomSheetNavigator$sheetContent$1.invoke$lambda$0(collectAsState);
                    if (invoke$lambda$0.contains(navBackStackEntry)) {
                        state2 = BottomSheetNavigator.this.getState();
                        state2.markTransitionComplete(navBackStackEntry);
                    } else {
                        state = BottomSheetNavigator.this.getState();
                        state.pop(navBackStackEntry, false);
                    }
                }
            };
            composer.updateRememberedValue(rememberedValue5);
        }
        SheetContentHostKt.SheetContentHost(columnScope, invoke$lambda$22, sheetState, rememberSaveableStateHolder, function1, (Function1) rememberedValue5, composer, (i5 & 14) | (ModalBottomSheetState.$stable << 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
