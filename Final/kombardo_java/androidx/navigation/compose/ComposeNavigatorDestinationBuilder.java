package androidx.navigation.compose;

import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.animation.AnimatedContentTransitionScope;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.SizeTransform;
import androidx.compose.runtime.Composer;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDestinationBuilder;
import androidx.navigation.compose.ComposeNavigator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B3\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R&\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0013R8\u0010\u0017\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR8\u0010\u001e\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u001d\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0018\u001a\u0004\b\u001f\u0010\u001a\"\u0004\b \u0010\u001cR8\u0010!\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0018\u001a\u0004\b\"\u0010\u001a\"\u0004\b#\u0010\u001cR8\u0010$\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u001d\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010\u0018\u001a\u0004\b%\u0010\u001a\"\u0004\b&\u0010\u001cR8\u0010(\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u0015\u0012\u0006\u0012\u0004\u0018\u00010'\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010\u0018\u001a\u0004\b)\u0010\u001a\"\u0004\b*\u0010\u001c¨\u0006+"}, d2 = {"Landroidx/navigation/compose/ComposeNavigatorDestinationBuilder;", "Landroidx/navigation/NavDestinationBuilder;", "Landroidx/navigation/compose/ComposeNavigator$Destination;", "Landroidx/navigation/compose/ComposeNavigator;", "navigator", BuildConfig.FLAVOR, "route", "Lkotlin/Function2;", "Landroidx/compose/animation/AnimatedContentScope;", "Landroidx/navigation/NavBackStackEntry;", BuildConfig.FLAVOR, "content", "<init>", "(Landroidx/navigation/compose/ComposeNavigator;Ljava/lang/String;Lkotlin/jvm/functions/Function4;)V", "instantiateDestination", "()Landroidx/navigation/compose/ComposeNavigator$Destination;", "build", "composeNavigator", "Landroidx/navigation/compose/ComposeNavigator;", "Lkotlin/jvm/functions/Function4;", "Lkotlin/Function1;", "Landroidx/compose/animation/AnimatedContentTransitionScope;", "Landroidx/compose/animation/EnterTransition;", "enterTransition", "Lkotlin/jvm/functions/Function1;", "getEnterTransition", "()Lkotlin/jvm/functions/Function1;", "setEnterTransition", "(Lkotlin/jvm/functions/Function1;)V", "Landroidx/compose/animation/ExitTransition;", "exitTransition", "getExitTransition", "setExitTransition", "popEnterTransition", "getPopEnterTransition", "setPopEnterTransition", "popExitTransition", "getPopExitTransition", "setPopExitTransition", "Landroidx/compose/animation/SizeTransform;", "sizeTransform", "getSizeTransform", "setSizeTransform", "navigation-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ComposeNavigatorDestinationBuilder extends NavDestinationBuilder<ComposeNavigator.Destination> {
    private final ComposeNavigator composeNavigator;
    private final Function4<AnimatedContentScope, NavBackStackEntry, Composer, Integer, Unit> content;
    private Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> enterTransition;
    private Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> exitTransition;
    private Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> popEnterTransition;
    private Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> popExitTransition;
    private Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> sizeTransform;

    /* JADX WARN: Multi-variable type inference failed */
    public ComposeNavigatorDestinationBuilder(ComposeNavigator composeNavigator, String str, Function4<? super AnimatedContentScope, ? super NavBackStackEntry, ? super Composer, ? super Integer, Unit> function4) {
        super(composeNavigator, str);
        this.composeNavigator = composeNavigator;
        this.content = function4;
    }

    public final void setEnterTransition(Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function1) {
        this.enterTransition = function1;
    }

    public final void setExitTransition(Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function1) {
        this.exitTransition = function1;
    }

    public final void setPopEnterTransition(Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function1) {
        this.popEnterTransition = function1;
    }

    public final void setPopExitTransition(Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function1) {
        this.popExitTransition = function1;
    }

    public final void setSizeTransform(Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> function1) {
        this.sizeTransform = function1;
    }

    @Override // androidx.navigation.NavDestinationBuilder
    public ComposeNavigator.Destination build() {
        ComposeNavigator.Destination destination = (ComposeNavigator.Destination) super.build();
        destination.setEnterTransition$navigation_compose_release(this.enterTransition);
        destination.setExitTransition$navigation_compose_release(this.exitTransition);
        destination.setPopEnterTransition$navigation_compose_release(this.popEnterTransition);
        destination.setPopExitTransition$navigation_compose_release(this.popExitTransition);
        destination.setSizeTransform$navigation_compose_release(this.sizeTransform);
        return destination;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.navigation.NavDestinationBuilder
    public ComposeNavigator.Destination instantiateDestination() {
        return new ComposeNavigator.Destination(this.composeNavigator, this.content);
    }
}
