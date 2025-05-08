package com.ramcosta.composedestinations.navigation;

import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import com.ramcosta.composedestinations.spec.Direction;
import com.ramcosta.composedestinations.spec.RouteOrDirection;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J/\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH'¢\u0006\u0004\b\f\u0010\rJ)\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000b2\b\b\u0002\u0010\u0011\u001a\u00020\u000bH'¢\u0006\u0004\b\f\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", BuildConfig.FLAVOR, "Lcom/ramcosta/composedestinations/spec/Direction;", "direction", "Landroidx/navigation/NavOptions;", "navOptions", "Landroidx/navigation/Navigator$Extras;", "navigatorExtras", BuildConfig.FLAVOR, "navigate", "(Lcom/ramcosta/composedestinations/spec/Direction;Landroidx/navigation/NavOptions;Landroidx/navigation/Navigator$Extras;)V", BuildConfig.FLAVOR, "popBackStack", "()Z", "Lcom/ramcosta/composedestinations/spec/RouteOrDirection;", "route", "inclusive", "saveState", "(Lcom/ramcosta/composedestinations/spec/RouteOrDirection;ZZ)Z", "compose-destinations_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface DestinationsNavigator {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void navigate$default(DestinationsNavigator destinationsNavigator, Direction direction, NavOptions navOptions, Navigator.Extras extras, int i5, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: navigate");
            }
            if ((i5 & 2) != 0) {
                navOptions = null;
            }
            if ((i5 & 4) != 0) {
                extras = null;
            }
            destinationsNavigator.navigate(direction, navOptions, extras);
        }

        public static /* synthetic */ boolean popBackStack$default(DestinationsNavigator destinationsNavigator, RouteOrDirection routeOrDirection, boolean z5, boolean z6, int i5, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: popBackStack");
            }
            if ((i5 & 4) != 0) {
                z6 = false;
            }
            return destinationsNavigator.popBackStack(routeOrDirection, z5, z6);
        }
    }

    void navigate(Direction direction, NavOptions navOptions, Navigator.Extras navigatorExtras);

    boolean popBackStack();

    boolean popBackStack(RouteOrDirection route, boolean inclusive, boolean saveState);
}
