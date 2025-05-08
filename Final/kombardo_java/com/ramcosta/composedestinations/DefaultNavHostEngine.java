package com.ramcosta.composedestinations;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.navigation.NavDestination;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigator;
import androidx.navigation.compose.NavGraphBuilderKt;
import androidx.navigation.compose.NavHostControllerKt;
import androidx.navigation.compose.NavHostKt;
import com.ramcosta.composedestinations.animations.NavHostAnimatedDestinationStyle;
import com.ramcosta.composedestinations.manualcomposablecalls.ManualComposableCalls;
import com.ramcosta.composedestinations.manualcomposablecalls.ManualComposableCallsKt;
import com.ramcosta.composedestinations.navigation.DependenciesContainerBuilder;
import com.ramcosta.composedestinations.spec.DestinationStyle;
import com.ramcosta.composedestinations.spec.Direction;
import com.ramcosta.composedestinations.spec.NavHostEngine;
import com.ramcosta.composedestinations.spec.TypedDestinationSpec;
import com.ramcosta.composedestinations.spec.TypedNavGraphSpec;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J3\u0010\u000b\u001a\u00020\n2\"\u0010\t\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\b0\u00070\u0006\"\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007H\u0017¢\u0006\u0004\b\u000b\u0010\fJK\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\n2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0016H\u0017¢\u0006\u0004\b\u001a\u0010\u001bJC\u0010!\u001a\u00020\u0018*\u00020\u00172\u0012\u0010\u001e\u001a\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001cj\u0002`\u001d2\u0006\u0010 \u001a\u00020\u001f2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0016H\u0016¢\u0006\u0004\b!\u0010\"JO\u0010(\u001a\u00020\u0018\"\u0004\b\u0000\u0010#*\u00020\u00172\f\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000$2\u0006\u0010\u0015\u001a\u00020\n2\u0016\u0010'\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030&\u0012\u0004\u0012\u00020\u00180\u00162\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b(\u0010)R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010*R\u001a\u0010,\u001a\u00020+8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/¨\u00060"}, d2 = {"Lcom/ramcosta/composedestinations/DefaultNavHostEngine;", "Lcom/ramcosta/composedestinations/spec/NavHostEngine;", "Landroidx/compose/ui/Alignment;", "navHostContentAlignment", "<init>", "(Landroidx/compose/ui/Alignment;)V", BuildConfig.FLAVOR, "Landroidx/navigation/Navigator;", "Landroidx/navigation/NavDestination;", "navigators", "Landroidx/navigation/NavHostController;", "rememberNavController", "([Landroidx/navigation/Navigator;Landroidx/compose/runtime/Composer;I)Landroidx/navigation/NavHostController;", "Landroidx/compose/ui/Modifier;", "modifier", BuildConfig.FLAVOR, "route", "Lcom/ramcosta/composedestinations/spec/Direction;", "start", "Lcom/ramcosta/composedestinations/animations/NavHostAnimatedDestinationStyle;", "defaultTransitions", "navController", "Lkotlin/Function1;", "Landroidx/navigation/NavGraphBuilder;", BuildConfig.FLAVOR, "builder", "NavHost", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Lcom/ramcosta/composedestinations/spec/Direction;Lcom/ramcosta/composedestinations/animations/NavHostAnimatedDestinationStyle;Landroidx/navigation/NavHostController;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "Lcom/ramcosta/composedestinations/spec/TypedNavGraphSpec;", "Lcom/ramcosta/composedestinations/spec/NavGraphSpec;", "navGraph", "Lcom/ramcosta/composedestinations/manualcomposablecalls/ManualComposableCalls;", "manualComposableCalls", "navigation", "(Landroidx/navigation/NavGraphBuilder;Lcom/ramcosta/composedestinations/spec/TypedNavGraphSpec;Lcom/ramcosta/composedestinations/manualcomposablecalls/ManualComposableCalls;Lkotlin/jvm/functions/Function1;)V", "T", "Lcom/ramcosta/composedestinations/spec/TypedDestinationSpec;", "destination", "Lcom/ramcosta/composedestinations/navigation/DependenciesContainerBuilder;", "dependenciesContainerBuilder", "composable", "(Landroidx/navigation/NavGraphBuilder;Lcom/ramcosta/composedestinations/spec/TypedDestinationSpec;Landroidx/navigation/NavHostController;Lkotlin/jvm/functions/Function3;Lcom/ramcosta/composedestinations/manualcomposablecalls/ManualComposableCalls;)V", "Landroidx/compose/ui/Alignment;", "Lcom/ramcosta/composedestinations/spec/NavHostEngine$Type;", "type", "Lcom/ramcosta/composedestinations/spec/NavHostEngine$Type;", "getType", "()Lcom/ramcosta/composedestinations/spec/NavHostEngine$Type;", "compose-destinations_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DefaultNavHostEngine implements NavHostEngine {
    private final Alignment navHostContentAlignment;
    private final NavHostEngine.Type type;

    public DefaultNavHostEngine(Alignment navHostContentAlignment) {
        Intrinsics.checkNotNullParameter(navHostContentAlignment, "navHostContentAlignment");
        this.navHostContentAlignment = navHostContentAlignment;
        this.type = NavHostEngine.Type.DEFAULT;
    }

    @Override // com.ramcosta.composedestinations.spec.NavHostEngine
    public void NavHost(Modifier modifier, String route, Direction start, NavHostAnimatedDestinationStyle defaultTransitions, NavHostController navController, Function1<? super NavGraphBuilder, Unit> builder, Composer composer, int i5) {
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Intrinsics.checkNotNullParameter(route, "route");
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(defaultTransitions, "defaultTransitions");
        Intrinsics.checkNotNullParameter(navController, "navController");
        Intrinsics.checkNotNullParameter(builder, "builder");
        composer.startReplaceGroup(803586475);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(803586475, i5, -1, "com.ramcosta.composedestinations.DefaultNavHostEngine.NavHost (DefaultNavHostEngine.kt:54)");
        }
        NavHostKt.NavHost(navController, start.getRoute(), modifier, this.navHostContentAlignment, route, defaultTransitions.getEnterTransition(), defaultTransitions.getExitTransition(), defaultTransitions.getPopEnterTransition(), defaultTransitions.getPopExitTransition(), defaultTransitions.getSizeTransform(), builder, composer, ((i5 >> 12) & 14) | ((i5 << 6) & 896) | ((i5 << 9) & 57344), (i5 >> 15) & 14, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
    }

    @Override // com.ramcosta.composedestinations.spec.NavHostEngine
    public <T> void composable(NavGraphBuilder navGraphBuilder, TypedDestinationSpec<T> destination, NavHostController navController, Function3<? super DependenciesContainerBuilder<?>, ? super Composer, ? super Integer, Unit> dependenciesContainerBuilder, ManualComposableCalls manualComposableCalls) {
        Intrinsics.checkNotNullParameter(navGraphBuilder, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(navController, "navController");
        Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
        Intrinsics.checkNotNullParameter(manualComposableCalls, "manualComposableCalls");
        DestinationStyle manualAnimation = manualComposableCalls.manualAnimation(destination.getRoute());
        if (manualAnimation == null) {
            manualAnimation = destination.getStyle();
        }
        manualAnimation.addComposable(navGraphBuilder, destination, navController, dependenciesContainerBuilder, manualComposableCalls);
    }

    @Override // com.ramcosta.composedestinations.spec.NavHostEngine
    public NavHostEngine.Type getType() {
        return this.type;
    }

    @Override // com.ramcosta.composedestinations.spec.NavHostEngine
    public void navigation(NavGraphBuilder navGraphBuilder, TypedNavGraphSpec<?, ?> navGraph, ManualComposableCalls manualComposableCalls, Function1<? super NavGraphBuilder, Unit> builder) {
        Intrinsics.checkNotNullParameter(navGraphBuilder, "<this>");
        Intrinsics.checkNotNullParameter(navGraph, "navGraph");
        Intrinsics.checkNotNullParameter(manualComposableCalls, "manualComposableCalls");
        Intrinsics.checkNotNullParameter(builder, "builder");
        DestinationStyle.Animated manualAnimation = manualComposableCalls.manualAnimation(navGraph.getRoute());
        if (manualAnimation == null) {
            manualAnimation = navGraph.getDefaultTransitions();
        }
        if (manualAnimation != null) {
            NavGraphBuilderKt.navigation(navGraphBuilder, navGraph.getStartRoute().getRoute(), navGraph.getRoute(), navGraph.getArguments(), ManualComposableCallsKt.allDeepLinks(navGraph, manualComposableCalls), manualAnimation.getEnterTransition(), manualAnimation.getExitTransition(), manualAnimation.getPopEnterTransition(), manualAnimation.getPopExitTransition(), manualAnimation.getSizeTransform(), builder);
        } else {
            NavGraphBuilderKt.navigation$default(navGraphBuilder, navGraph.getStartRoute().getRoute(), navGraph.getRoute(), navGraph.getArguments(), ManualComposableCallsKt.allDeepLinks(navGraph, manualComposableCalls), null, null, null, null, null, builder, 496, null);
        }
    }

    @Override // com.ramcosta.composedestinations.spec.NavHostEngine
    public NavHostController rememberNavController(Navigator<? extends NavDestination>[] navigators, Composer composer, int i5) {
        Intrinsics.checkNotNullParameter(navigators, "navigators");
        composer.startReplaceGroup(1218297258);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1218297258, i5, -1, "com.ramcosta.composedestinations.DefaultNavHostEngine.rememberNavController (DefaultNavHostEngine.kt:44)");
        }
        NavHostController rememberNavController = NavHostControllerKt.rememberNavController((Navigator[]) Arrays.copyOf(navigators, navigators.length), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return rememberNavController;
    }
}
