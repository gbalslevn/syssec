package androidx.navigation;

import android.os.Bundle;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import org.conscrypt.BuildConfig;

@Navigator.Name("navigation")
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\b\u0017\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J+\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J1\u0010\u000e\u001a\u00020\r2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u00122\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u0014R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0015¨\u0006\u0016"}, d2 = {"Landroidx/navigation/NavGraphNavigator;", "Landroidx/navigation/Navigator;", "Landroidx/navigation/NavGraph;", "Landroidx/navigation/NavigatorProvider;", "navigatorProvider", "<init>", "(Landroidx/navigation/NavigatorProvider;)V", "Landroidx/navigation/NavBackStackEntry;", "entry", "Landroidx/navigation/NavOptions;", "navOptions", "Landroidx/navigation/Navigator$Extras;", "navigatorExtras", BuildConfig.FLAVOR, "navigate", "(Landroidx/navigation/NavBackStackEntry;Landroidx/navigation/NavOptions;Landroidx/navigation/Navigator$Extras;)V", "createDestination", "()Landroidx/navigation/NavGraph;", BuildConfig.FLAVOR, "entries", "(Ljava/util/List;Landroidx/navigation/NavOptions;Landroidx/navigation/Navigator$Extras;)V", "Landroidx/navigation/NavigatorProvider;", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public class NavGraphNavigator extends Navigator<NavGraph> {
    private final NavigatorProvider navigatorProvider;

    public NavGraphNavigator(NavigatorProvider navigatorProvider) {
        Intrinsics.checkNotNullParameter(navigatorProvider, "navigatorProvider");
        this.navigatorProvider = navigatorProvider;
    }

    @Override // androidx.navigation.Navigator
    public void navigate(List<NavBackStackEntry> entries, NavOptions navOptions, Navigator.Extras navigatorExtras) {
        Intrinsics.checkNotNullParameter(entries, "entries");
        Iterator<NavBackStackEntry> it = entries.iterator();
        while (it.hasNext()) {
            navigate(it.next(), navOptions, navigatorExtras);
        }
    }

    @Override // androidx.navigation.Navigator
    public NavGraph createDestination() {
        return new NavGraph(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v6, types: [android.os.Bundle, T] */
    /* JADX WARN: Type inference failed for: r5v1, types: [android.os.Bundle, T] */
    private final void navigate(NavBackStackEntry entry, NavOptions navOptions, Navigator.Extras navigatorExtras) {
        NavDestination navDestination;
        NavDestination destination = entry.getDestination();
        Intrinsics.checkNotNull(destination, "null cannot be cast to non-null type androidx.navigation.NavGraph");
        NavGraph navGraph = (NavGraph) destination;
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = entry.getArguments();
        int startDestId = navGraph.getStartDestId();
        String startDestinationRoute = navGraph.getStartDestinationRoute();
        if (startDestId == 0 && startDestinationRoute == null) {
            throw new IllegalStateException(("no start destination defined via app:startDestination for " + navGraph.getDisplayName()).toString());
        }
        if (startDestinationRoute != null) {
            navDestination = navGraph.findNode(startDestinationRoute, false);
        } else {
            navDestination = navGraph.getNodes().get(startDestId);
        }
        if (navDestination != null) {
            if (startDestinationRoute != null) {
                if (!Intrinsics.areEqual(startDestinationRoute, navDestination.getRoute())) {
                    NavDestination.DeepLinkMatch matchRoute = navDestination.matchRoute(startDestinationRoute);
                    Bundle matchingArgs = matchRoute != null ? matchRoute.getMatchingArgs() : null;
                    if (matchingArgs != null && !matchingArgs.isEmpty()) {
                        ?? bundle = new Bundle();
                        bundle.putAll(matchingArgs);
                        T t5 = ref$ObjectRef.element;
                        if (((Bundle) t5) != null) {
                            bundle.putAll((Bundle) t5);
                        }
                        ref$ObjectRef.element = bundle;
                    }
                }
                if (!navDestination.getArguments().isEmpty()) {
                    List<String> missingRequiredArguments = NavArgumentKt.missingRequiredArguments(navDestination.getArguments(), new Function1<String, Boolean>() { // from class: androidx.navigation.NavGraphNavigator$navigate$missingRequiredArgs$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Boolean invoke(String key) {
                            Intrinsics.checkNotNullParameter(key, "key");
                            Bundle bundle2 = ref$ObjectRef.element;
                            boolean z5 = true;
                            if (bundle2 != null && bundle2.containsKey(key)) {
                                z5 = false;
                            }
                            return Boolean.valueOf(z5);
                        }
                    });
                    if (!missingRequiredArguments.isEmpty()) {
                        throw new IllegalArgumentException(("Cannot navigate to startDestination " + navDestination + ". Missing required arguments [" + missingRequiredArguments + ']').toString());
                    }
                }
            }
            this.navigatorProvider.getNavigator(navDestination.getNavigatorName()).navigate(CollectionsKt.listOf(getState().createBackStackEntry(navDestination, navDestination.addInDefaultArgs((Bundle) ref$ObjectRef.element))), navOptions, navigatorExtras);
            return;
        }
        throw new IllegalArgumentException("navigation destination " + navGraph.getStartDestDisplayName() + " is not a direct child of this NavGraph");
    }
}
