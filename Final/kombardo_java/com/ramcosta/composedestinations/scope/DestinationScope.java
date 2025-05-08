package com.ramcosta.composedestinations.scope;

import androidx.compose.runtime.Composer;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import com.ramcosta.composedestinations.navigation.DestinationDependenciesContainer;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import com.ramcosta.composedestinations.spec.TypedDestinationSpec;
import kotlin.Metadata;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002J\r\u0010\u0013\u001a\u00020\u0014H'¢\u0006\u0002\u0010\u0015R\u0018\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0012\u0010\u000f\u001a\u00020\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0012\u0010\u0016\u001a\u00028\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/ramcosta/composedestinations/scope/DestinationScope;", "T", "Lcom/ramcosta/composedestinations/scope/DestinationScopeWithNoDependencies;", "destination", "Lcom/ramcosta/composedestinations/spec/TypedDestinationSpec;", "getDestination", "()Lcom/ramcosta/composedestinations/spec/TypedDestinationSpec;", "navBackStackEntry", "Landroidx/navigation/NavBackStackEntry;", "getNavBackStackEntry", "()Landroidx/navigation/NavBackStackEntry;", "navController", "Landroidx/navigation/NavController;", "getNavController", "()Landroidx/navigation/NavController;", "destinationsNavigator", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "getDestinationsNavigator", "()Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "buildDependencies", "Lcom/ramcosta/composedestinations/navigation/DestinationDependenciesContainer;", "(Landroidx/compose/runtime/Composer;I)Lcom/ramcosta/composedestinations/navigation/DestinationDependenciesContainer;", "navArgs", "getNavArgs", "()Ljava/lang/Object;", "compose-destinations_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface DestinationScope<T> extends DestinationScopeWithNoDependencies<T> {
    DestinationDependenciesContainer buildDependencies(Composer composer, int i5);

    TypedDestinationSpec<T> getDestination();

    DestinationsNavigator getDestinationsNavigator();

    T getNavArgs();

    NavBackStackEntry getNavBackStackEntry();

    NavController getNavController();
}
