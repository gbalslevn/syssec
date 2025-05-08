package com.ramcosta.composedestinations.bottomsheet.scope;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import com.ramcosta.composedestinations.navigation.DependenciesContainerBuilder;
import com.ramcosta.composedestinations.scope.DestinationScope;
import com.ramcosta.composedestinations.scope.DestinationScopeImpl;
import com.ramcosta.composedestinations.spec.TypedDestinationSpec;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u00032\u00020\u0004BE\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0016\u0010\u000f\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0004\b\u0010\u0010\u0011J\u001c\u0010\u0015\u001a\u00020\u0012*\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0013H\u0097\u0001¢\u0006\u0004\b\u0015\u0010\u0016J&\u0010\u0018\u001a\u00020\u0012*\u00020\u00122\b\b\u0001\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0097\u0001¢\u0006\u0004\b\u0018\u0010\u001bR \u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\b\u001a\u00020\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\u001f\u001a\u0004\b \u0010!R\u001a\u0010\n\u001a\u00020\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\"\u001a\u0004\b#\u0010$R*\u0010\u000f\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0012\u0004\u0012\u00020\u000e0\f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000f\u0010%\u001a\u0004\b&\u0010'¨\u0006("}, d2 = {"Lcom/ramcosta/composedestinations/bottomsheet/scope/BottomSheetDestinationScopeImpl;", "T", "Lcom/ramcosta/composedestinations/scope/DestinationScopeImpl;", BuildConfig.FLAVOR, "Landroidx/compose/foundation/layout/ColumnScope;", "Lcom/ramcosta/composedestinations/spec/TypedDestinationSpec;", "destination", "Landroidx/navigation/NavBackStackEntry;", "navBackStackEntry", "Landroidx/navigation/NavController;", "navController", "columnScope", "Lkotlin/Function1;", "Lcom/ramcosta/composedestinations/navigation/DependenciesContainerBuilder;", BuildConfig.FLAVOR, "dependenciesContainerBuilder", "<init>", "(Lcom/ramcosta/composedestinations/spec/TypedDestinationSpec;Landroidx/navigation/NavBackStackEntry;Landroidx/navigation/NavController;Landroidx/compose/foundation/layout/ColumnScope;Lkotlin/jvm/functions/Function3;)V", "Landroidx/compose/ui/Modifier;", "Landroidx/compose/ui/Alignment$Horizontal;", "alignment", "align", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment$Horizontal;)Landroidx/compose/ui/Modifier;", BuildConfig.FLAVOR, "weight", BuildConfig.FLAVOR, "fill", "(Landroidx/compose/ui/Modifier;FZ)Landroidx/compose/ui/Modifier;", "Lcom/ramcosta/composedestinations/spec/TypedDestinationSpec;", "getDestination", "()Lcom/ramcosta/composedestinations/spec/TypedDestinationSpec;", "Landroidx/navigation/NavBackStackEntry;", "getNavBackStackEntry", "()Landroidx/navigation/NavBackStackEntry;", "Landroidx/navigation/NavController;", "getNavController", "()Landroidx/navigation/NavController;", "Lkotlin/jvm/functions/Function3;", "getDependenciesContainerBuilder", "()Lkotlin/jvm/functions/Function3;", "compose-destinations-bottom-sheet_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class BottomSheetDestinationScopeImpl<T> extends DestinationScopeImpl<T> implements DestinationScope, ColumnScope {
    private final /* synthetic */ ColumnScope $$delegate_0;
    private final Function3<DependenciesContainerBuilder<?>, Composer, Integer, Unit> dependenciesContainerBuilder;
    private final TypedDestinationSpec<T> destination;
    private final NavBackStackEntry navBackStackEntry;
    private final NavController navController;

    /* JADX WARN: Multi-variable type inference failed */
    public BottomSheetDestinationScopeImpl(TypedDestinationSpec<T> destination, NavBackStackEntry navBackStackEntry, NavController navController, ColumnScope columnScope, Function3<? super DependenciesContainerBuilder<?>, ? super Composer, ? super Integer, Unit> dependenciesContainerBuilder) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(navBackStackEntry, "navBackStackEntry");
        Intrinsics.checkNotNullParameter(navController, "navController");
        Intrinsics.checkNotNullParameter(columnScope, "columnScope");
        Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
        this.$$delegate_0 = columnScope;
        this.destination = destination;
        this.navBackStackEntry = navBackStackEntry;
        this.navController = navController;
        this.dependenciesContainerBuilder = dependenciesContainerBuilder;
    }

    @Override // androidx.compose.foundation.layout.ColumnScope
    public Modifier align(Modifier modifier, Alignment.Horizontal alignment) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        return this.$$delegate_0.align(modifier, alignment);
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

    @Override // androidx.compose.foundation.layout.ColumnScope
    public Modifier weight(Modifier modifier, float f5, boolean z5) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        return this.$$delegate_0.weight(modifier, f5, z5);
    }
}
