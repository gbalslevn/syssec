package com.ramcosta.composedestinations.scope;

import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.runtime.Composer;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import com.ramcosta.composedestinations.navigation.DependenciesContainerBuilder;
import com.ramcosta.composedestinations.spec.TypedDestinationSpec;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0010\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u00032\u00020\u0004BE\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0016\u0010\u000f\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0004\b\u0010\u0010\u0011R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\b\u001a\u00020\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\n\u001a\u00020\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR*\u0010\u000f\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0012\u0004\u0012\u00020\u000e0\f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/ramcosta/composedestinations/scope/AnimatedDestinationScopeImpl;", "T", "Lcom/ramcosta/composedestinations/scope/DestinationScopeImpl;", BuildConfig.FLAVOR, "Landroidx/compose/animation/AnimatedVisibilityScope;", "Lcom/ramcosta/composedestinations/spec/TypedDestinationSpec;", "destination", "Landroidx/navigation/NavBackStackEntry;", "navBackStackEntry", "Landroidx/navigation/NavController;", "navController", "animatedVisibilityScope", "Lkotlin/Function1;", "Lcom/ramcosta/composedestinations/navigation/DependenciesContainerBuilder;", BuildConfig.FLAVOR, "dependenciesContainerBuilder", "<init>", "(Lcom/ramcosta/composedestinations/spec/TypedDestinationSpec;Landroidx/navigation/NavBackStackEntry;Landroidx/navigation/NavController;Landroidx/compose/animation/AnimatedVisibilityScope;Lkotlin/jvm/functions/Function3;)V", "Lcom/ramcosta/composedestinations/spec/TypedDestinationSpec;", "getDestination", "()Lcom/ramcosta/composedestinations/spec/TypedDestinationSpec;", "Landroidx/navigation/NavBackStackEntry;", "getNavBackStackEntry", "()Landroidx/navigation/NavBackStackEntry;", "Landroidx/navigation/NavController;", "getNavController", "()Landroidx/navigation/NavController;", "Lkotlin/jvm/functions/Function3;", "getDependenciesContainerBuilder", "()Lkotlin/jvm/functions/Function3;", "compose-destinations_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AnimatedDestinationScopeImpl<T> extends DestinationScopeImpl<T> implements DestinationScope, AnimatedVisibilityScope {
    private final /* synthetic */ AnimatedVisibilityScope $$delegate_0;
    private final Function3<DependenciesContainerBuilder<?>, Composer, Integer, Unit> dependenciesContainerBuilder;
    private final TypedDestinationSpec<T> destination;
    private final NavBackStackEntry navBackStackEntry;
    private final NavController navController;

    /* JADX WARN: Multi-variable type inference failed */
    public AnimatedDestinationScopeImpl(TypedDestinationSpec<T> destination, NavBackStackEntry navBackStackEntry, NavController navController, AnimatedVisibilityScope animatedVisibilityScope, Function3<? super DependenciesContainerBuilder<?>, ? super Composer, ? super Integer, Unit> dependenciesContainerBuilder) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(navBackStackEntry, "navBackStackEntry");
        Intrinsics.checkNotNullParameter(navController, "navController");
        Intrinsics.checkNotNullParameter(animatedVisibilityScope, "animatedVisibilityScope");
        Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
        this.$$delegate_0 = animatedVisibilityScope;
        this.destination = destination;
        this.navBackStackEntry = navBackStackEntry;
        this.navController = navController;
        this.dependenciesContainerBuilder = dependenciesContainerBuilder;
    }

    @Override // com.ramcosta.composedestinations.scope.DestinationScopeImpl
    public Function3<DependenciesContainerBuilder<?>, Composer, Integer, Unit> getDependenciesContainerBuilder() {
        return this.dependenciesContainerBuilder;
    }

    @Override // com.ramcosta.composedestinations.scope.DestinationScope, com.ramcosta.composedestinations.scope.DestinationScopeWithNoDependencies
    public TypedDestinationSpec<T> getDestination() {
        return this.destination;
    }

    @Override // com.ramcosta.composedestinations.scope.DestinationScope, com.ramcosta.composedestinations.scope.DestinationScopeWithNoDependencies
    public NavBackStackEntry getNavBackStackEntry() {
        return this.navBackStackEntry;
    }

    @Override // com.ramcosta.composedestinations.scope.DestinationScope, com.ramcosta.composedestinations.scope.DestinationScopeWithNoDependencies
    public NavController getNavController() {
        return this.navController;
    }
}
