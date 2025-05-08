package com.ramcosta.composedestinations.utils;

import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import com.ramcosta.composedestinations.spec.TypedNavHostGraphSpec;
import com.ramcosta.composedestinations.spec.TypedRoute;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\u000e\u0010\u000b\u001a\n\u0012\u0002\b\u00030\fj\u0002`\rJ\u000e\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006J\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u0006H\u0086\u0002J\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0010\u001a\u00020\u0011H\u0086\u0002J\u0018\u0010\u0012\u001a\u00020\t2\u000e\u0010\u000b\u001a\n\u0012\u0002\b\u00030\fj\u0002`\rH\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/ramcosta/composedestinations/utils/NavGraphRegistry;", BuildConfig.FLAVOR, "<init>", "()V", "holderByTopLevelRoute", BuildConfig.FLAVOR, "Landroidx/navigation/NavController;", "Lcom/ramcosta/composedestinations/utils/NavGraphSpecHolder;", "addGraph", BuildConfig.FLAVOR, "navController", "navGraph", "Lcom/ramcosta/composedestinations/spec/TypedNavHostGraphSpec;", "Lcom/ramcosta/composedestinations/spec/NavHostGraphSpec;", "removeGraph", "get", "navBackStackEntry", "Landroidx/navigation/NavBackStackEntry;", "checkRoutesUniqueness", "compose-destinations_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NavGraphRegistry {
    public static final NavGraphRegistry INSTANCE = new NavGraphRegistry();
    private static final Map<NavController, NavGraphSpecHolder> holderByTopLevelRoute = new LinkedHashMap();
    public static final int $stable = 8;

    private NavGraphRegistry() {
    }

    private final void checkRoutesUniqueness(TypedNavHostGraphSpec<?> navGraph) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<T> it = SpecExtensionsKt.getAllRoutes(navGraph).iterator();
        while (it.hasNext()) {
            TypedRoute typedRoute = (TypedRoute) it.next();
            if (!linkedHashSet.add(typedRoute.getRoute())) {
                throw new IllegalStateException(("Duplicate route found '" + typedRoute.getRoute() + "'. Routes must be unique!").toString());
            }
        }
    }

    public final void addGraph(NavController navController, TypedNavHostGraphSpec<?> navGraph) {
        Intrinsics.checkNotNullParameter(navController, "navController");
        Intrinsics.checkNotNullParameter(navGraph, "navGraph");
        Map<NavController, NavGraphSpecHolder> map = holderByTopLevelRoute;
        if (map.containsKey(navController)) {
            return;
        }
        checkRoutesUniqueness(navGraph);
        NavGraphSpecHolder navGraphSpecHolder = new NavGraphSpecHolder();
        navGraphSpecHolder.addGraph(navGraph);
        map.put(navController, navGraphSpecHolder);
    }

    public final NavGraphSpecHolder get(NavController navController) {
        Intrinsics.checkNotNullParameter(navController, "navController");
        return holderByTopLevelRoute.get(navController);
    }

    public final void removeGraph(NavController navController) {
        Intrinsics.checkNotNullParameter(navController, "navController");
        holderByTopLevelRoute.remove(navController);
    }

    public final NavGraphSpecHolder get(NavBackStackEntry navBackStackEntry) {
        NavGraphSpecHolder navGraphSpecHolder;
        Object m3567constructorimpl;
        boolean areEqual;
        Intrinsics.checkNotNullParameter(navBackStackEntry, "navBackStackEntry");
        String route = ((NavDestination) SequencesKt.last(NavDestination.INSTANCE.getHierarchy(navBackStackEntry.getDestination()))).getRoute();
        Set<NavController> keySet = holderByTopLevelRoute.keySet();
        ArrayList arrayList = new ArrayList();
        for (Object obj : keySet) {
            if (Intrinsics.areEqual(((NavController) obj).getGraph().getRoute(), route)) {
                arrayList.add(obj);
            }
        }
        if (arrayList.size() == 1) {
            return get((NavController) CollectionsKt.first((List) arrayList));
        }
        Object obj2 = null;
        if (arrayList.isEmpty()) {
            return null;
        }
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            NavController navController = (NavController) next;
            String route2 = navBackStackEntry.getDestination().getRoute();
            if (route2 != null) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    m3567constructorimpl = Result.m3567constructorimpl(navController.getBackStackEntry(route2));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    m3567constructorimpl = Result.m3567constructorimpl(ResultKt.createFailure(th));
                }
                if (Result.m3572isFailureimpl(m3567constructorimpl)) {
                    m3567constructorimpl = null;
                }
                areEqual = Intrinsics.areEqual(m3567constructorimpl, navBackStackEntry);
            } else {
                areEqual = false;
            }
            if (areEqual) {
                obj2 = next;
                break;
            }
        }
        NavController navController2 = (NavController) obj2;
        return (navController2 == null || (navGraphSpecHolder = INSTANCE.get(navController2)) == null) ? get((NavController) CollectionsKt.first((List) arrayList)) : navGraphSpecHolder;
    }
}
