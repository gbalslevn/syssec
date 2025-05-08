package androidx.navigation.compose;

import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.animation.AnimatedContentTransitionScope;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.SizeTransform;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDestination;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlinx.coroutines.flow.StateFlow;
import org.conscrypt.BuildConfig;

@Navigator.Name("composable")
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 #2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002#$B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J1\u0010\r\u001a\u00020\f2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0006¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0006¢\u0006\u0004\b\u0019\u0010\u0018R \u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00120\u001a8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001d\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u001f8F¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006%"}, d2 = {"Landroidx/navigation/compose/ComposeNavigator;", "Landroidx/navigation/Navigator;", "Landroidx/navigation/compose/ComposeNavigator$Destination;", "<init>", "()V", BuildConfig.FLAVOR, "Landroidx/navigation/NavBackStackEntry;", "entries", "Landroidx/navigation/NavOptions;", "navOptions", "Landroidx/navigation/Navigator$Extras;", "navigatorExtras", BuildConfig.FLAVOR, "navigate", "(Ljava/util/List;Landroidx/navigation/NavOptions;Landroidx/navigation/Navigator$Extras;)V", "createDestination", "()Landroidx/navigation/compose/ComposeNavigator$Destination;", "popUpTo", BuildConfig.FLAVOR, "savedState", "popBackStack", "(Landroidx/navigation/NavBackStackEntry;Z)V", "entry", "prepareForTransition", "(Landroidx/navigation/NavBackStackEntry;)V", "onTransitionComplete", "Landroidx/compose/runtime/MutableState;", "isPop", "Landroidx/compose/runtime/MutableState;", "isPop$navigation_compose_release", "()Landroidx/compose/runtime/MutableState;", "Lkotlinx/coroutines/flow/StateFlow;", "getBackStack", "()Lkotlinx/coroutines/flow/StateFlow;", "backStack", "Companion", "Destination", "navigation-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ComposeNavigator extends Navigator<Destination> {
    private final MutableState<Boolean> isPop;

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0004\b\t\u0010\nR,\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\b\u0010\u000b\u001a\u0004\b\f\u0010\rR8\u0010\u0011\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000e8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R8\u0010\u0018\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0018\u00010\u000e8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R8\u0010\u001b\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000e8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0012\u001a\u0004\b\u001c\u0010\u0014\"\u0004\b\u001d\u0010\u0016R8\u0010\u001e\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0018\u00010\u000e8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0012\u001a\u0004\b\u001f\u0010\u0014\"\u0004\b \u0010\u0016R8\u0010\"\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u000f\u0012\u0006\u0012\u0004\u0018\u00010!\u0018\u00010\u000e8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u0012\u001a\u0004\b#\u0010\u0014\"\u0004\b$\u0010\u0016¨\u0006%"}, d2 = {"Landroidx/navigation/compose/ComposeNavigator$Destination;", "Landroidx/navigation/NavDestination;", "Landroidx/navigation/compose/ComposeNavigator;", "navigator", "Lkotlin/Function2;", "Landroidx/compose/animation/AnimatedContentScope;", "Landroidx/navigation/NavBackStackEntry;", BuildConfig.FLAVOR, "content", "<init>", "(Landroidx/navigation/compose/ComposeNavigator;Lkotlin/jvm/functions/Function4;)V", "Lkotlin/jvm/functions/Function4;", "getContent$navigation_compose_release", "()Lkotlin/jvm/functions/Function4;", "Lkotlin/Function1;", "Landroidx/compose/animation/AnimatedContentTransitionScope;", "Landroidx/compose/animation/EnterTransition;", "enterTransition", "Lkotlin/jvm/functions/Function1;", "getEnterTransition$navigation_compose_release", "()Lkotlin/jvm/functions/Function1;", "setEnterTransition$navigation_compose_release", "(Lkotlin/jvm/functions/Function1;)V", "Landroidx/compose/animation/ExitTransition;", "exitTransition", "getExitTransition$navigation_compose_release", "setExitTransition$navigation_compose_release", "popEnterTransition", "getPopEnterTransition$navigation_compose_release", "setPopEnterTransition$navigation_compose_release", "popExitTransition", "getPopExitTransition$navigation_compose_release", "setPopExitTransition$navigation_compose_release", "Landroidx/compose/animation/SizeTransform;", "sizeTransform", "getSizeTransform$navigation_compose_release", "setSizeTransform$navigation_compose_release", "navigation-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Destination extends NavDestination {
        private final Function4<AnimatedContentScope, NavBackStackEntry, Composer, Integer, Unit> content;
        private Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> enterTransition;
        private Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> exitTransition;
        private Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> popEnterTransition;
        private Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> popExitTransition;
        private Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> sizeTransform;

        /* JADX WARN: Multi-variable type inference failed */
        public Destination(ComposeNavigator composeNavigator, Function4<? super AnimatedContentScope, NavBackStackEntry, ? super Composer, ? super Integer, Unit> function4) {
            super(composeNavigator);
            this.content = function4;
        }

        public final Function4<AnimatedContentScope, NavBackStackEntry, Composer, Integer, Unit> getContent$navigation_compose_release() {
            return this.content;
        }

        public final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> getEnterTransition$navigation_compose_release() {
            return this.enterTransition;
        }

        public final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> getExitTransition$navigation_compose_release() {
            return this.exitTransition;
        }

        public final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> getPopEnterTransition$navigation_compose_release() {
            return this.popEnterTransition;
        }

        public final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> getPopExitTransition$navigation_compose_release() {
            return this.popExitTransition;
        }

        public final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> getSizeTransform$navigation_compose_release() {
            return this.sizeTransform;
        }

        public final void setEnterTransition$navigation_compose_release(Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function1) {
            this.enterTransition = function1;
        }

        public final void setExitTransition$navigation_compose_release(Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function1) {
            this.exitTransition = function1;
        }

        public final void setPopEnterTransition$navigation_compose_release(Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function1) {
            this.popEnterTransition = function1;
        }

        public final void setPopExitTransition$navigation_compose_release(Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function1) {
            this.popExitTransition = function1;
        }

        public final void setSizeTransform$navigation_compose_release(Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> function1) {
            this.sizeTransform = function1;
        }
    }

    public ComposeNavigator() {
        MutableState<Boolean> mutableStateOf$default;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        this.isPop = mutableStateOf$default;
    }

    public final StateFlow<List<NavBackStackEntry>> getBackStack() {
        return getState().getBackStack();
    }

    public final MutableState<Boolean> isPop$navigation_compose_release() {
        return this.isPop;
    }

    @Override // androidx.navigation.Navigator
    public void navigate(List<NavBackStackEntry> entries, NavOptions navOptions, Navigator.Extras navigatorExtras) {
        Iterator<T> it = entries.iterator();
        while (it.hasNext()) {
            getState().pushWithTransition((NavBackStackEntry) it.next());
        }
        this.isPop.setValue(Boolean.FALSE);
    }

    public final void onTransitionComplete(NavBackStackEntry entry) {
        getState().markTransitionComplete(entry);
    }

    @Override // androidx.navigation.Navigator
    public void popBackStack(NavBackStackEntry popUpTo, boolean savedState) {
        getState().popWithTransition(popUpTo, savedState);
        this.isPop.setValue(Boolean.TRUE);
    }

    public final void prepareForTransition(NavBackStackEntry entry) {
        getState().prepareForTransition(entry);
    }

    @Override // androidx.navigation.Navigator
    public Destination createDestination() {
        return new Destination(this, ComposableSingletons$ComposeNavigatorKt.INSTANCE.m2724getLambda1$navigation_compose_release());
    }
}
