package androidx.navigation.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import androidx.compose.runtime.saveable.SaveableStateHolderKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.platform.InspectionModeKt;
import androidx.compose.ui.window.AndroidDialog_androidKt;
import androidx.lifecycle.Lifecycle;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDestination;
import androidx.navigation.compose.DialogNavigator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\"\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004\u001a!\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tH\u0001¢\u0006\u0002\u0010\n\u001a%\u0010\u000b\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00070\f2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tH\u0001¢\u0006\u0002\u0010\r¨\u0006\u000e²\u0006\u0010\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010X\u008a\u0084\u0002²\u0006\u0010\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0012X\u008a\u0084\u0002"}, d2 = {"DialogHost", BuildConfig.FLAVOR, "dialogNavigator", "Landroidx/navigation/compose/DialogNavigator;", "(Landroidx/navigation/compose/DialogNavigator;Landroidx/compose/runtime/Composer;I)V", "rememberVisibleList", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "Landroidx/navigation/NavBackStackEntry;", "backStack", BuildConfig.FLAVOR, "(Ljava/util/Collection;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/snapshots/SnapshotStateList;", "PopulateVisibleList", BuildConfig.FLAVOR, "(Ljava/util/List;Ljava/util/Collection;Landroidx/compose/runtime/Composer;I)V", "navigation-compose_release", "dialogBackStack", BuildConfig.FLAVOR, "transitionInProgress", BuildConfig.FLAVOR}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class DialogHostKt {
    public static final void DialogHost(final DialogNavigator dialogNavigator, Composer composer, final int i5) {
        Composer startRestartGroup = composer.startRestartGroup(294589392);
        int i6 = (i5 & 6) == 0 ? (startRestartGroup.changed(dialogNavigator) ? 4 : 2) | i5 : i5;
        if ((i6 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(294589392, i6, -1, "androidx.navigation.compose.DialogHost (DialogHost.kt:40)");
            }
            boolean z5 = false;
            final SaveableStateHolder rememberSaveableStateHolder = SaveableStateHolderKt.rememberSaveableStateHolder(startRestartGroup, 0);
            Continuation continuation = null;
            boolean z6 = true;
            State collectAsState = SnapshotStateKt.collectAsState(dialogNavigator.getBackStack$navigation_compose_release(), null, startRestartGroup, 0, 1);
            SnapshotStateList<NavBackStackEntry> rememberVisibleList = rememberVisibleList(DialogHost$lambda$0(collectAsState), startRestartGroup, 0);
            PopulateVisibleList(rememberVisibleList, DialogHost$lambda$0(collectAsState), startRestartGroup, 0);
            State collectAsState2 = SnapshotStateKt.collectAsState(dialogNavigator.getTransitionInProgress$navigation_compose_release(), null, startRestartGroup, 0, 1);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = SnapshotStateKt.mutableStateListOf();
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            SnapshotStateList snapshotStateList = (SnapshotStateList) rememberedValue;
            startRestartGroup.startReplaceGroup(1361037007);
            for (final NavBackStackEntry navBackStackEntry : rememberVisibleList) {
                NavDestination destination = navBackStackEntry.getDestination();
                Intrinsics.checkNotNull(destination, "null cannot be cast to non-null type androidx.navigation.compose.DialogNavigator.Destination");
                final DialogNavigator.Destination destination2 = (DialogNavigator.Destination) destination;
                boolean changedInstance = ((i6 & 14) == 4 ? z6 : z5) | startRestartGroup.changedInstance(navBackStackEntry);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (changedInstance || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue2 = new Function0<Unit>() { // from class: androidx.navigation.compose.DialogHostKt$DialogHost$1$1$1
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
                            DialogNavigator.this.dismiss$navigation_compose_release(navBackStackEntry);
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                final SnapshotStateList snapshotStateList2 = snapshotStateList;
                AndroidDialog_androidKt.Dialog((Function0) rememberedValue2, destination2.getDialogProperties(), ComposableLambdaKt.rememberComposableLambda(1129586364, z6, new Function2<Composer, Integer, Unit>() { // from class: androidx.navigation.compose.DialogHostKt$DialogHost$1$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i7) {
                        if ((i7 & 3) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1129586364, i7, -1, "androidx.navigation.compose.DialogHost.<anonymous>.<anonymous> (DialogHost.kt:55)");
                        }
                        NavBackStackEntry navBackStackEntry2 = NavBackStackEntry.this;
                        boolean changedInstance2 = composer2.changedInstance(NavBackStackEntry.this) | composer2.changed(dialogNavigator);
                        final SnapshotStateList<NavBackStackEntry> snapshotStateList3 = snapshotStateList2;
                        final NavBackStackEntry navBackStackEntry3 = NavBackStackEntry.this;
                        final DialogNavigator dialogNavigator2 = dialogNavigator;
                        Object rememberedValue3 = composer2.rememberedValue();
                        if (changedInstance2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue3 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.navigation.compose.DialogHostKt$DialogHost$1$2$1$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                                    snapshotStateList3.add(navBackStackEntry3);
                                    final DialogNavigator dialogNavigator3 = dialogNavigator2;
                                    final NavBackStackEntry navBackStackEntry4 = navBackStackEntry3;
                                    final SnapshotStateList<NavBackStackEntry> snapshotStateList4 = snapshotStateList3;
                                    return new DisposableEffectResult() { // from class: androidx.navigation.compose.DialogHostKt$DialogHost$1$2$1$1$invoke$$inlined$onDispose$1
                                        @Override // androidx.compose.runtime.DisposableEffectResult
                                        public void dispose() {
                                            DialogNavigator.this.onTransitionComplete$navigation_compose_release(navBackStackEntry4);
                                            snapshotStateList4.remove(navBackStackEntry4);
                                        }
                                    };
                                }
                            };
                            composer2.updateRememberedValue(rememberedValue3);
                        }
                        EffectsKt.DisposableEffect(navBackStackEntry2, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue3, composer2, 0);
                        final NavBackStackEntry navBackStackEntry4 = NavBackStackEntry.this;
                        SaveableStateHolder saveableStateHolder = rememberSaveableStateHolder;
                        final DialogNavigator.Destination destination3 = destination2;
                        NavBackStackEntryProviderKt.LocalOwnersProvider(navBackStackEntry4, saveableStateHolder, ComposableLambdaKt.rememberComposableLambda(-497631156, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.navigation.compose.DialogHostKt$DialogHost$1$2.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                invoke(composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i8) {
                                if ((i8 & 3) == 2 && composer3.getSkipping()) {
                                    composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-497631156, i8, -1, "androidx.navigation.compose.DialogHost.<anonymous>.<anonymous>.<anonymous> (DialogHost.kt:66)");
                                }
                                DialogNavigator.Destination.this.getContent$navigation_compose_release().invoke(navBackStackEntry4, composer3, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composer2, 54), composer2, 384);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, startRestartGroup, 54), startRestartGroup, 384, 0);
                continuation = null;
                i6 = i6;
                snapshotStateList = snapshotStateList;
                collectAsState2 = collectAsState2;
                z6 = z6;
                z5 = z5;
            }
            SnapshotStateList snapshotStateList3 = snapshotStateList;
            State state = collectAsState2;
            boolean z7 = z6;
            Continuation continuation2 = continuation;
            boolean z8 = z5;
            startRestartGroup.endReplaceGroup();
            Set<NavBackStackEntry> DialogHost$lambda$1 = DialogHost$lambda$1(state);
            boolean changed = startRestartGroup.changed(state) | ((i6 & 14) == 4 ? z7 : z8);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = new DialogHostKt$DialogHost$2$1(state, dialogNavigator, snapshotStateList3, continuation2);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            EffectsKt.LaunchedEffect(DialogHost$lambda$1, snapshotStateList3, (Function2) rememberedValue3, startRestartGroup, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.navigation.compose.DialogHostKt$DialogHost$3
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i7) {
                    DialogHostKt.DialogHost(DialogNavigator.this, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
                }
            });
        }
    }

    private static final List<NavBackStackEntry> DialogHost$lambda$0(State<? extends List<NavBackStackEntry>> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Set<NavBackStackEntry> DialogHost$lambda$1(State<? extends Set<NavBackStackEntry>> state) {
        return state.getValue();
    }

    public static final void PopulateVisibleList(final List<NavBackStackEntry> list, final Collection<NavBackStackEntry> collection, Composer composer, final int i5) {
        Composer startRestartGroup = composer.startRestartGroup(1537894851);
        int i6 = (i5 & 6) == 0 ? (startRestartGroup.changedInstance(list) ? 4 : 2) | i5 : i5;
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(collection) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1537894851, i6, -1, "androidx.navigation.compose.PopulateVisibleList (DialogHost.kt:88)");
            }
            boolean booleanValue = ((Boolean) startRestartGroup.consume(InspectionModeKt.getLocalInspectionMode())).booleanValue();
            for (NavBackStackEntry navBackStackEntry : collection) {
                Lifecycle lifecycle = navBackStackEntry.getLifecycle();
                boolean changed = startRestartGroup.changed(booleanValue) | startRestartGroup.changedInstance(list) | startRestartGroup.changedInstance(navBackStackEntry);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new DialogHostKt$PopulateVisibleList$1$1$1(navBackStackEntry, booleanValue, list);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                EffectsKt.DisposableEffect(lifecycle, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue, startRestartGroup, 0);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.navigation.compose.DialogHostKt$PopulateVisibleList$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i7) {
                    DialogHostKt.PopulateVisibleList(list, collection, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x002d, code lost:
    
        if (r1 == androidx.compose.runtime.Composer.INSTANCE.getEmpty()) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final SnapshotStateList<NavBackStackEntry> rememberVisibleList(Collection<NavBackStackEntry> collection, Composer composer, int i5) {
        Object obj;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(467378629, i5, -1, "androidx.navigation.compose.rememberVisibleList (DialogHost.kt:119)");
        }
        boolean booleanValue = ((Boolean) composer.consume(InspectionModeKt.getLocalInspectionMode())).booleanValue();
        boolean changed = composer.changed(collection);
        Object rememberedValue = composer.rememberedValue();
        if (!changed) {
            obj = rememberedValue;
        }
        SnapshotStateList mutableStateListOf = SnapshotStateKt.mutableStateListOf();
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : collection) {
            if (booleanValue ? true : ((NavBackStackEntry) obj2).getLifecycle().getState().isAtLeast(Lifecycle.State.STARTED)) {
                arrayList.add(obj2);
            }
        }
        mutableStateListOf.addAll(arrayList);
        composer.updateRememberedValue(mutableStateListOf);
        obj = mutableStateListOf;
        SnapshotStateList<NavBackStackEntry> snapshotStateList = (SnapshotStateList) obj;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return snapshotStateList;
    }
}
