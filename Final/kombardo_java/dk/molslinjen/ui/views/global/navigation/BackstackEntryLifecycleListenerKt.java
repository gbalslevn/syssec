package dk.molslinjen.ui.views.global.navigation;

import android.os.Bundle;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import dk.molslinjen.ui.views.global.navigation.BackstackEntryLifecycleListenerKt;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\u001a+\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0007¢\u0006\u0002\u0010\b\u001a\u0012\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n*\u00020\u0003H\u0002¨\u0006\f"}, d2 = {"BackstackEntryLifecycleListener", BuildConfig.FLAVOR, "navController", "Landroidx/navigation/NavController;", "navBackStackEntry", "Landroidx/navigation/NavBackStackEntry;", "onRemoved", "Lkotlin/Function0;", "(Landroidx/navigation/NavController;Landroidx/navigation/NavBackStackEntry;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "collectBackstackEntries", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class BackstackEntryLifecycleListenerKt {
    public static final void BackstackEntryLifecycleListener(final NavController navController, final NavBackStackEntry navBackStackEntry, final Function0<Unit> onRemoved, Composer composer, final int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(navController, "navController");
        Intrinsics.checkNotNullParameter(navBackStackEntry, "navBackStackEntry");
        Intrinsics.checkNotNullParameter(onRemoved, "onRemoved");
        Composer startRestartGroup = composer.startRestartGroup(-1890283366);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(navController) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(navBackStackEntry) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(onRemoved) ? 256 : 128;
        }
        if ((i6 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1890283366, i6, -1, "dk.molslinjen.ui.views.global.navigation.BackstackEntryLifecycleListener (BackstackEntryLifecycleListener.kt:10)");
            }
            startRestartGroup.startReplaceGroup(-1478416735);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = navBackStackEntry.getId();
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final String str = (String) rememberedValue;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-1478414812);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(collectBackstackEntries(navController), null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            final MutableState mutableState = (MutableState) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-1478410984);
            boolean changedInstance = ((i6 & 896) == 256) | startRestartGroup.changedInstance(navController);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue3 == companion.getEmpty()) {
                rememberedValue3 = new Function1() { // from class: R1.b
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        DisposableEffectResult BackstackEntryLifecycleListener$lambda$5$lambda$4;
                        BackstackEntryLifecycleListener$lambda$5$lambda$4 = BackstackEntryLifecycleListenerKt.BackstackEntryLifecycleListener$lambda$5$lambda$4(NavController.this, mutableState, str, onRemoved, (DisposableEffectScope) obj);
                        return BackstackEntryLifecycleListener$lambda$5$lambda$4;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceGroup();
            EffectsKt.DisposableEffect(navController, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue3, startRestartGroup, i6 & 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: R1.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit BackstackEntryLifecycleListener$lambda$6;
                    BackstackEntryLifecycleListener$lambda$6 = BackstackEntryLifecycleListenerKt.BackstackEntryLifecycleListener$lambda$6(NavController.this, navBackStackEntry, onRemoved, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return BackstackEntryLifecycleListener$lambda$6;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult BackstackEntryLifecycleListener$lambda$5$lambda$4(final NavController navController, final MutableState mutableState, final String str, final Function0 function0, DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        final NavController.OnDestinationChangedListener onDestinationChangedListener = new NavController.OnDestinationChangedListener() { // from class: R1.a
            @Override // androidx.navigation.NavController.OnDestinationChangedListener
            public final void onDestinationChanged(NavController navController2, NavDestination navDestination, Bundle bundle) {
                BackstackEntryLifecycleListenerKt.BackstackEntryLifecycleListener$lambda$5$lambda$4$lambda$2(MutableState.this, str, function0, navController2, navDestination, bundle);
            }
        };
        navController.addOnDestinationChangedListener(onDestinationChangedListener);
        return new DisposableEffectResult() { // from class: dk.molslinjen.ui.views.global.navigation.BackstackEntryLifecycleListenerKt$BackstackEntryLifecycleListener$lambda$5$lambda$4$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                NavController.this.removeOnDestinationChangedListener(onDestinationChangedListener);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void BackstackEntryLifecycleListener$lambda$5$lambda$4$lambda$2(MutableState mutableState, String str, Function0 function0, NavController controller, NavDestination navDestination, Bundle bundle) {
        Intrinsics.checkNotNullParameter(controller, "controller");
        Intrinsics.checkNotNullParameter(navDestination, "<unused var>");
        Set<String> collectBackstackEntries = collectBackstackEntries(controller);
        if (((Set) mutableState.getValue()).contains(str) && !collectBackstackEntries.contains(str)) {
            function0.invoke();
        }
        mutableState.setValue(collectBackstackEntries);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BackstackEntryLifecycleListener$lambda$6(NavController navController, NavBackStackEntry navBackStackEntry, Function0 function0, int i5, Composer composer, int i6) {
        BackstackEntryLifecycleListener(navController, navBackStackEntry, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    private static final Set<String> collectBackstackEntries(NavController navController) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        NavBackStackEntry currentBackStackEntry = navController.getCurrentBackStackEntry();
        if (currentBackStackEntry != null) {
            linkedHashSet.add(currentBackStackEntry.getId());
        }
        NavBackStackEntry previousBackStackEntry = navController.getPreviousBackStackEntry();
        if (previousBackStackEntry != null) {
            linkedHashSet.add(previousBackStackEntry.getId());
        }
        return linkedHashSet;
    }
}
