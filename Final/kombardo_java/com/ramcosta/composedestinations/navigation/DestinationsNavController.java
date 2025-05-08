package com.ramcosta.composedestinations.navigation;

import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import com.ramcosta.composedestinations.spec.Direction;
import com.ramcosta.composedestinations.spec.RouteOrDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J+\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0017¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u000fH\u0017¢\u0006\u0004\b\u0010\u0010\u0016R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/ramcosta/composedestinations/navigation/DestinationsNavController;", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "Landroidx/navigation/NavController;", "navController", "<init>", "(Landroidx/navigation/NavController;)V", "Lcom/ramcosta/composedestinations/spec/Direction;", "direction", "Landroidx/navigation/NavOptions;", "navOptions", "Landroidx/navigation/Navigator$Extras;", "navigatorExtras", BuildConfig.FLAVOR, "navigate", "(Lcom/ramcosta/composedestinations/spec/Direction;Landroidx/navigation/NavOptions;Landroidx/navigation/Navigator$Extras;)V", BuildConfig.FLAVOR, "popBackStack", "()Z", "Lcom/ramcosta/composedestinations/spec/RouteOrDirection;", "route", "inclusive", "saveState", "(Lcom/ramcosta/composedestinations/spec/RouteOrDirection;ZZ)Z", "Landroidx/navigation/NavController;", "compose-destinations_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DestinationsNavController implements DestinationsNavigator {
    private final NavController navController;

    public DestinationsNavController(NavController navController) {
        Intrinsics.checkNotNullParameter(navController, "navController");
        this.navController = navController;
    }

    @Override // com.ramcosta.composedestinations.navigation.DestinationsNavigator
    public void navigate(Direction direction, NavOptions navOptions, Navigator.Extras navigatorExtras) {
        Intrinsics.checkNotNullParameter(direction, "direction");
        this.navController.navigate(direction.getRoute(), navOptions, navigatorExtras);
    }

    @Override // com.ramcosta.composedestinations.navigation.DestinationsNavigator
    public boolean popBackStack() {
        return this.navController.popBackStack();
    }

    @Override // com.ramcosta.composedestinations.navigation.DestinationsNavigator
    public boolean popBackStack(RouteOrDirection route, boolean inclusive, boolean saveState) {
        Intrinsics.checkNotNullParameter(route, "route");
        return this.navController.popBackStack(route.getRoute(), inclusive, saveState);
    }
}
