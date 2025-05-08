package androidx.navigation;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.SerializersKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\b\u0017\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ%\u0010\u000e\u001a\u00020\r\"\b\b\u0000\u0010\u000b*\u00020\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001d\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010 \u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020\n0\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006%"}, d2 = {"Landroidx/navigation/NavGraphBuilder;", "Landroidx/navigation/NavDestinationBuilder;", "Landroidx/navigation/NavGraph;", "Landroidx/navigation/NavigatorProvider;", "provider", BuildConfig.FLAVOR, "startDestination", "route", "<init>", "(Landroidx/navigation/NavigatorProvider;Ljava/lang/String;Ljava/lang/String;)V", "Landroidx/navigation/NavDestination;", "D", "navDestination", BuildConfig.FLAVOR, "destination", "(Landroidx/navigation/NavDestinationBuilder;)V", "addDestination", "(Landroidx/navigation/NavDestination;)V", "build", "()Landroidx/navigation/NavGraph;", "Landroidx/navigation/NavigatorProvider;", "getProvider", "()Landroidx/navigation/NavigatorProvider;", BuildConfig.FLAVOR, "startDestinationId", "I", "startDestinationRoute", "Ljava/lang/String;", "Lkotlin/reflect/KClass;", "startDestinationClass", "Lkotlin/reflect/KClass;", BuildConfig.FLAVOR, "startDestinationObject", "Ljava/lang/Object;", BuildConfig.FLAVOR, "destinations", "Ljava/util/List;", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public class NavGraphBuilder extends NavDestinationBuilder<NavGraph> {
    private final List<NavDestination> destinations;
    private final NavigatorProvider provider;
    private KClass<?> startDestinationClass;
    private int startDestinationId;
    private Object startDestinationObject;
    private String startDestinationRoute;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NavGraphBuilder(NavigatorProvider provider, String startDestination, String str) {
        super(provider.getNavigator(NavGraphNavigator.class), str);
        Intrinsics.checkNotNullParameter(provider, "provider");
        Intrinsics.checkNotNullParameter(startDestination, "startDestination");
        this.destinations = new ArrayList();
        this.provider = provider;
        this.startDestinationRoute = startDestination;
    }

    public final void addDestination(NavDestination destination) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        this.destinations.add(destination);
    }

    public final <D extends NavDestination> void destination(NavDestinationBuilder<? extends D> navDestination) {
        Intrinsics.checkNotNullParameter(navDestination, "navDestination");
        this.destinations.add(navDestination.build());
    }

    public final NavigatorProvider getProvider() {
        return this.provider;
    }

    @Override // androidx.navigation.NavDestinationBuilder
    public NavGraph build() {
        NavGraph navGraph = (NavGraph) super.build();
        navGraph.addDestinations(this.destinations);
        int i5 = this.startDestinationId;
        if (i5 == 0 && this.startDestinationRoute == null && this.startDestinationClass == null && this.startDestinationObject == null) {
            if (getRoute() != null) {
                throw new IllegalStateException("You must set a start destination route");
            }
            throw new IllegalStateException("You must set a start destination id");
        }
        String str = this.startDestinationRoute;
        if (str != null) {
            Intrinsics.checkNotNull(str);
            navGraph.setStartDestination(str);
        } else {
            KClass<?> kClass = this.startDestinationClass;
            if (kClass != null) {
                Intrinsics.checkNotNull(kClass);
                navGraph.setStartDestination(SerializersKt.serializer(kClass), new Function1<NavDestination, String>() { // from class: androidx.navigation.NavGraphBuilder$build$1$1
                    @Override // kotlin.jvm.functions.Function1
                    public final String invoke(NavDestination it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        String route = it.getRoute();
                        Intrinsics.checkNotNull(route);
                        return route;
                    }
                });
            } else {
                Object obj = this.startDestinationObject;
                if (obj != null) {
                    Intrinsics.checkNotNull(obj);
                    navGraph.setStartDestination((NavGraph) obj);
                } else {
                    navGraph.setStartDestination(i5);
                }
            }
        }
        return navGraph;
    }
}
