package com.ramcosta.composedestinations.spec;

import android.os.Bundle;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NamedNavArgument;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDeepLink;
import com.ramcosta.composedestinations.spec.DestinationStyle;
import com.ramcosta.composedestinations.spec.TypedRoute;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\u00038&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\"\u0010\u000f\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u00030\u000bj\u0002`\f0\n8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR&\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0000j\u0002`\u00100\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000eR\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00138&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/ramcosta/composedestinations/spec/TypedNavGraphSpec;", "NAV_ARGS", "START_ROUTE_NAV_ARGS", "Lcom/ramcosta/composedestinations/spec/TypedRoute;", BuildConfig.FLAVOR, "throwMissingNavArgsException", "()Ljava/lang/Void;", "getStartRoute", "()Lcom/ramcosta/composedestinations/spec/TypedRoute;", "startRoute", BuildConfig.FLAVOR, "Lcom/ramcosta/composedestinations/spec/TypedDestinationSpec;", "Lcom/ramcosta/composedestinations/spec/DestinationSpec;", "getDestinations", "()Ljava/util/List;", "destinations", "Lcom/ramcosta/composedestinations/spec/NavGraphSpec;", "getNestedNavGraphs", "nestedNavGraphs", "Lcom/ramcosta/composedestinations/spec/DestinationStyle$Animated;", "getDefaultTransitions", "()Lcom/ramcosta/composedestinations/spec/DestinationStyle$Animated;", "defaultTransitions", "compose-destinations_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface TypedNavGraphSpec<NAV_ARGS, START_ROUTE_NAV_ARGS> extends TypedRoute<NAV_ARGS> {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static <NAV_ARGS, START_ROUTE_NAV_ARGS> NAV_ARGS argsFrom(TypedNavGraphSpec<NAV_ARGS, START_ROUTE_NAV_ARGS> typedNavGraphSpec, NavBackStackEntry navBackStackEntry) {
            Intrinsics.checkNotNullParameter(navBackStackEntry, "navBackStackEntry");
            return (NAV_ARGS) TypedRoute.DefaultImpls.argsFrom(typedNavGraphSpec, navBackStackEntry);
        }

        public static <NAV_ARGS, START_ROUTE_NAV_ARGS> List<NamedNavArgument> getArguments(TypedNavGraphSpec<NAV_ARGS, START_ROUTE_NAV_ARGS> typedNavGraphSpec) {
            return TypedRoute.DefaultImpls.getArguments(typedNavGraphSpec);
        }

        public static <NAV_ARGS, START_ROUTE_NAV_ARGS> List<NavDeepLink> getDeepLinks(TypedNavGraphSpec<NAV_ARGS, START_ROUTE_NAV_ARGS> typedNavGraphSpec) {
            return TypedRoute.DefaultImpls.getDeepLinks(typedNavGraphSpec);
        }

        public static <NAV_ARGS, START_ROUTE_NAV_ARGS> List<TypedNavGraphSpec<?, ?>> getNestedNavGraphs(TypedNavGraphSpec<NAV_ARGS, START_ROUTE_NAV_ARGS> typedNavGraphSpec) {
            return CollectionsKt.emptyList();
        }

        public static <NAV_ARGS, START_ROUTE_NAV_ARGS> NAV_ARGS requireGraphArgs(TypedNavGraphSpec<NAV_ARGS, START_ROUTE_NAV_ARGS> typedNavGraphSpec, Bundle bundle) {
            NAV_ARGS argsFrom = typedNavGraphSpec.argsFrom(bundle);
            if (argsFrom != null) {
                return argsFrom;
            }
            throwMissingNavArgsException(typedNavGraphSpec);
            throw new KotlinNothingValueException();
        }

        private static <NAV_ARGS, START_ROUTE_NAV_ARGS> Void throwMissingNavArgsException(TypedNavGraphSpec<NAV_ARGS, START_ROUTE_NAV_ARGS> typedNavGraphSpec) {
            throw new IllegalStateException((typedNavGraphSpec + " navigation arguments were not present. Make sure you navigated to " + typedNavGraphSpec + " nav graph, and not to one of its destinations!").toString());
        }

        public static <NAV_ARGS, START_ROUTE_NAV_ARGS> NAV_ARGS requireGraphArgs(TypedNavGraphSpec<NAV_ARGS, START_ROUTE_NAV_ARGS> typedNavGraphSpec, SavedStateHandle savedStateHandle) {
            Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
            NAV_ARGS argsFrom = typedNavGraphSpec.argsFrom(savedStateHandle);
            if (argsFrom != null) {
                return argsFrom;
            }
            throwMissingNavArgsException(typedNavGraphSpec);
            throw new KotlinNothingValueException();
        }

        public static <NAV_ARGS, START_ROUTE_NAV_ARGS> NAV_ARGS requireGraphArgs(TypedNavGraphSpec<NAV_ARGS, START_ROUTE_NAV_ARGS> typedNavGraphSpec, NavBackStackEntry navBackStackEntry) {
            Intrinsics.checkNotNullParameter(navBackStackEntry, "navBackStackEntry");
            NAV_ARGS argsFrom = typedNavGraphSpec.argsFrom(navBackStackEntry.getArguments());
            if (argsFrom != null) {
                return argsFrom;
            }
            throwMissingNavArgsException(typedNavGraphSpec);
            throw new KotlinNothingValueException();
        }
    }

    DestinationStyle.Animated getDefaultTransitions();

    List<TypedDestinationSpec<?>> getDestinations();

    List<TypedNavGraphSpec<?, ?>> getNestedNavGraphs();

    TypedRoute<START_ROUTE_NAV_ARGS> getStartRoute();
}
