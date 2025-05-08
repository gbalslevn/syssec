package com.ramcosta.composedestinations.utils;

import com.ramcosta.composedestinations.spec.TypedDestinationSpec;
import com.ramcosta.composedestinations.spec.TypedNavGraphSpec;
import com.ramcosta.composedestinations.spec.TypedRoute;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001aC\u0010\u0007\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u00030\u0003j\u0002`\u00040\u0006*\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0000j\u0002`\u00012\u0014\u0010\u0005\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u00030\u0003j\u0002`\u00040\u0002H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a1\u0010\r\u001a\u000e\u0012\u0002\b\u0003\u0018\u00010\u000bj\u0004\u0018\u0001`\f*\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0000j\u0002`\u00012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000e\"%\u0010\u0011\u001a\n\u0012\u0002\b\u00030\u000bj\u0002`\f*\n\u0012\u0002\b\u00030\u0003j\u0002`\u00048F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\"/\u0010\u0014\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u00030\u0003j\u0002`\u00040\u0006*\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0000j\u0002`\u00018F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/ramcosta/composedestinations/spec/TypedNavGraphSpec;", "Lcom/ramcosta/composedestinations/spec/NavGraphSpec;", BuildConfig.FLAVOR, "Lcom/ramcosta/composedestinations/spec/TypedRoute;", "Lcom/ramcosta/composedestinations/spec/Route;", "currentList", BuildConfig.FLAVOR, "addAllRoutesTo", "(Lcom/ramcosta/composedestinations/spec/TypedNavGraphSpec;Ljava/util/List;)Ljava/util/List;", BuildConfig.FLAVOR, "route", "Lcom/ramcosta/composedestinations/spec/TypedDestinationSpec;", "Lcom/ramcosta/composedestinations/spec/DestinationSpec;", "findDestination", "(Lcom/ramcosta/composedestinations/spec/TypedNavGraphSpec;Ljava/lang/String;)Lcom/ramcosta/composedestinations/spec/TypedDestinationSpec;", "getStartDestination", "(Lcom/ramcosta/composedestinations/spec/TypedRoute;)Lcom/ramcosta/composedestinations/spec/TypedDestinationSpec;", "startDestination", "getAllRoutes", "(Lcom/ramcosta/composedestinations/spec/TypedNavGraphSpec;)Ljava/util/List;", "allRoutes", "compose-destinations_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class SpecExtensionsKt {
    public static final List<TypedRoute<?>> addAllRoutesTo(TypedNavGraphSpec<?, ?> typedNavGraphSpec, List<TypedRoute<?>> currentList) {
        Intrinsics.checkNotNullParameter(typedNavGraphSpec, "<this>");
        Intrinsics.checkNotNullParameter(currentList, "currentList");
        currentList.addAll(typedNavGraphSpec.getDestinations());
        currentList.addAll(typedNavGraphSpec.getNestedNavGraphs());
        Iterator<T> it = typedNavGraphSpec.getNestedNavGraphs().iterator();
        while (it.hasNext()) {
            addAllRoutesTo((TypedNavGraphSpec) it.next(), currentList);
        }
        return currentList;
    }

    public static final TypedDestinationSpec<?> findDestination(TypedNavGraphSpec<?, ?> typedNavGraphSpec, String route) {
        Object obj;
        Intrinsics.checkNotNullParameter(typedNavGraphSpec, "<this>");
        Intrinsics.checkNotNullParameter(route, "route");
        Iterator<T> it = typedNavGraphSpec.getDestinations().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((TypedDestinationSpec) obj).getRoute(), route)) {
                break;
            }
        }
        TypedDestinationSpec<?> typedDestinationSpec = (TypedDestinationSpec) obj;
        if (typedDestinationSpec != null) {
            return typedDestinationSpec;
        }
        Iterator<TypedNavGraphSpec<?, ?>> it2 = typedNavGraphSpec.getNestedNavGraphs().iterator();
        while (it2.hasNext()) {
            TypedDestinationSpec<?> findDestination = findDestination(it2.next(), route);
            if (findDestination != null) {
                return findDestination;
            }
        }
        return null;
    }

    public static final List<TypedRoute<?>> getAllRoutes(TypedNavGraphSpec<?, ?> typedNavGraphSpec) {
        Intrinsics.checkNotNullParameter(typedNavGraphSpec, "<this>");
        return addAllRoutesTo(typedNavGraphSpec, new ArrayList());
    }

    public static final TypedDestinationSpec<?> getStartDestination(TypedRoute<?> typedRoute) {
        Intrinsics.checkNotNullParameter(typedRoute, "<this>");
        if (typedRoute instanceof TypedDestinationSpec) {
            return (TypedDestinationSpec) typedRoute;
        }
        if (typedRoute instanceof TypedNavGraphSpec) {
            return getStartDestination(((TypedNavGraphSpec) typedRoute).getStartRoute());
        }
        throw new NoWhenBranchMatchedException();
    }
}
