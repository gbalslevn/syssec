package com.ramcosta.composedestinations.utils;

import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import com.ramcosta.composedestinations.navigation.DestinationsNavController;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import com.ramcosta.composedestinations.spec.TypedDestinationSpec;
import com.ramcosta.composedestinations.spec.TypedNavGraphSpec;
import com.ramcosta.composedestinations.spec.TypedRoute;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0019\u0010\u0007\u001a\n\u0012\u0002\b\u00030\u0005j\u0002`\u0006*\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b\"#\u0010\u000e\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u00030\nj\u0002`\u000b0\t*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Landroidx/navigation/NavController;", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "toDestinationsNavigator", "(Landroidx/navigation/NavController;)Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "Landroidx/navigation/NavBackStackEntry;", "Lcom/ramcosta/composedestinations/spec/TypedRoute;", "Lcom/ramcosta/composedestinations/spec/Route;", "route", "(Landroidx/navigation/NavBackStackEntry;)Lcom/ramcosta/composedestinations/spec/TypedRoute;", "Lkotlinx/coroutines/flow/Flow;", "Lcom/ramcosta/composedestinations/spec/TypedDestinationSpec;", "Lcom/ramcosta/composedestinations/spec/DestinationSpec;", "getCurrentDestinationFlow", "(Landroidx/navigation/NavController;)Lkotlinx/coroutines/flow/Flow;", "currentDestinationFlow", "compose-destinations_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class NavControllerExtKt {
    public static final Flow<TypedDestinationSpec<?>> getCurrentDestinationFlow(NavController navController) {
        Intrinsics.checkNotNullParameter(navController, "<this>");
        return FlowKt.flow(new NavControllerExtKt$special$$inlined$transform$1(navController.getCurrentBackStackEntryFlow(), null));
    }

    public static final TypedRoute<?> route(NavBackStackEntry navBackStackEntry) {
        TypedDestinationSpec<?> findDestination;
        Intrinsics.checkNotNullParameter(navBackStackEntry, "<this>");
        NavGraphSpecHolder navGraphSpecHolder = NavGraphRegistry.INSTANCE.get(navBackStackEntry);
        if (navGraphSpecHolder == null) {
            throw new IllegalStateException("Cannot call NavBackStackEntry.route() before DestinationsNavHost!");
        }
        TypedNavGraphSpec<?, ?> navGraph = navGraphSpecHolder.navGraph(navBackStackEntry);
        if (navGraph != null) {
            return navGraph;
        }
        TypedNavGraphSpec<?, ?> parentNavGraph = navGraphSpecHolder.parentNavGraph(navBackStackEntry);
        Intrinsics.checkNotNull(parentNavGraph);
        String route = navBackStackEntry.getDestination().getRoute();
        return (route == null || (findDestination = SpecExtensionsKt.findDestination(parentNavGraph, route)) == null) ? SpecExtensionsKt.getStartDestination(parentNavGraph) : findDestination;
    }

    public static final DestinationsNavigator toDestinationsNavigator(NavController navController) {
        Intrinsics.checkNotNullParameter(navController, "<this>");
        return new DestinationsNavController(navController);
    }
}
