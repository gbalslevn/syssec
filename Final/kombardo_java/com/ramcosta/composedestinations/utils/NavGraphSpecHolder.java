package com.ramcosta.composedestinations.utils;

import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavGraph;
import com.ramcosta.composedestinations.spec.TypedNavGraphSpec;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\b\u001a\u00020\u00072\u0012\u0010\u0006\u001a\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0004j\u0002`\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ!\u0010\n\u001a\u00020\u00072\u0012\u0010\u0006\u001a\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0004j\u0002`\u0005¢\u0006\u0004\b\n\u0010\tJ%\u0010\r\u001a\u0012\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0004j\u0004\u0018\u0001`\u00052\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ%\u0010\u0006\u001a\u0012\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0004j\u0004\u0018\u0001`\u00052\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0006\u0010\u000eR,\u0010\u0011\u001a\u001a\u0012\u0004\u0012\u00020\u0010\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0004j\u0002`\u00050\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/ramcosta/composedestinations/utils/NavGraphSpecHolder;", BuildConfig.FLAVOR, "<init>", "()V", "Lcom/ramcosta/composedestinations/spec/TypedNavGraphSpec;", "Lcom/ramcosta/composedestinations/spec/NavGraphSpec;", "navGraph", BuildConfig.FLAVOR, "addUnique", "(Lcom/ramcosta/composedestinations/spec/TypedNavGraphSpec;)V", "addGraph", "Landroidx/navigation/NavBackStackEntry;", "navBackStackEntry", "parentNavGraph", "(Landroidx/navigation/NavBackStackEntry;)Lcom/ramcosta/composedestinations/spec/TypedNavGraphSpec;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "navGraphSpecsByRoute", "Ljava/util/Map;", "compose-destinations_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NavGraphSpecHolder {
    private final Map<String, TypedNavGraphSpec<?, ?>> navGraphSpecsByRoute = new LinkedHashMap();

    private final void addUnique(TypedNavGraphSpec<?, ?> navGraph) {
        TypedNavGraphSpec<?, ?> put = this.navGraphSpecsByRoute.put(navGraph.getRoute(), navGraph);
        if (put == null || put == navGraph) {
            return;
        }
        throw new IllegalArgumentException(("Registering multiple navigation graphs with same route ('" + navGraph.getRoute() + "') is not allowed.").toString());
    }

    public final void addGraph(TypedNavGraphSpec<?, ?> navGraph) {
        Intrinsics.checkNotNullParameter(navGraph, "navGraph");
        addUnique(navGraph);
        Iterator<T> it = navGraph.getNestedNavGraphs().iterator();
        while (it.hasNext()) {
            addGraph((TypedNavGraphSpec) it.next());
        }
    }

    public final TypedNavGraphSpec<?, ?> navGraph(NavBackStackEntry navBackStackEntry) {
        Intrinsics.checkNotNullParameter(navBackStackEntry, "navBackStackEntry");
        Map<String, TypedNavGraphSpec<?, ?>> map = this.navGraphSpecsByRoute;
        String route = navBackStackEntry.getDestination().getRoute();
        Intrinsics.checkNotNull(route);
        return map.get(route);
    }

    public final TypedNavGraphSpec<?, ?> parentNavGraph(NavBackStackEntry navBackStackEntry) {
        Intrinsics.checkNotNullParameter(navBackStackEntry, "navBackStackEntry");
        NavGraph parent = navBackStackEntry.getDestination().getParent();
        if (parent == null) {
            return null;
        }
        Map<String, TypedNavGraphSpec<?, ?>> map = this.navGraphSpecsByRoute;
        String route = parent.getRoute();
        Intrinsics.checkNotNull(route);
        return map.get(route);
    }
}
