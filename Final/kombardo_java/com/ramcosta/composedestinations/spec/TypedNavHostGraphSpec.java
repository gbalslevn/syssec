package com.ramcosta.composedestinations.spec;

import android.os.Bundle;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NamedNavArgument;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDeepLink;
import com.ramcosta.composedestinations.animations.NavHostAnimatedDestinationStyle;
import com.ramcosta.composedestinations.spec.TypedNavGraphSpec;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\u0002R\u0014\u0010\u0006\u001a\u00020\u00038&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u0004\u0018\u00018\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\r\u001a\u00020\n8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/ramcosta/composedestinations/spec/TypedNavHostGraphSpec;", "START_ROUTE_NAV_ARGS", "Lcom/ramcosta/composedestinations/spec/TypedNavGraphSpec;", "Lcom/ramcosta/composedestinations/animations/NavHostAnimatedDestinationStyle;", "getDefaultTransitions", "()Lcom/ramcosta/composedestinations/animations/NavHostAnimatedDestinationStyle;", "defaultTransitions", "getDefaultStartArgs", "()Ljava/lang/Object;", "defaultStartArgs", "Lcom/ramcosta/composedestinations/spec/Direction;", "getDefaultStartDirection", "()Lcom/ramcosta/composedestinations/spec/Direction;", "defaultStartDirection", "compose-destinations_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface TypedNavHostGraphSpec<START_ROUTE_NAV_ARGS> extends TypedNavGraphSpec<START_ROUTE_NAV_ARGS, START_ROUTE_NAV_ARGS> {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static <START_ROUTE_NAV_ARGS> START_ROUTE_NAV_ARGS argsFrom(TypedNavHostGraphSpec<START_ROUTE_NAV_ARGS> typedNavHostGraphSpec, NavBackStackEntry navBackStackEntry) {
            Intrinsics.checkNotNullParameter(navBackStackEntry, "navBackStackEntry");
            return (START_ROUTE_NAV_ARGS) TypedNavGraphSpec.DefaultImpls.argsFrom(typedNavHostGraphSpec, navBackStackEntry);
        }

        public static <START_ROUTE_NAV_ARGS> List<NamedNavArgument> getArguments(TypedNavHostGraphSpec<START_ROUTE_NAV_ARGS> typedNavHostGraphSpec) {
            return TypedNavGraphSpec.DefaultImpls.getArguments(typedNavHostGraphSpec);
        }

        public static <START_ROUTE_NAV_ARGS> List<NavDeepLink> getDeepLinks(TypedNavHostGraphSpec<START_ROUTE_NAV_ARGS> typedNavHostGraphSpec) {
            return TypedNavGraphSpec.DefaultImpls.getDeepLinks(typedNavHostGraphSpec);
        }

        public static <START_ROUTE_NAV_ARGS> START_ROUTE_NAV_ARGS requireGraphArgs(TypedNavHostGraphSpec<START_ROUTE_NAV_ARGS> typedNavHostGraphSpec, Bundle bundle) {
            return (START_ROUTE_NAV_ARGS) TypedNavGraphSpec.DefaultImpls.requireGraphArgs(typedNavHostGraphSpec, bundle);
        }

        public static <START_ROUTE_NAV_ARGS> START_ROUTE_NAV_ARGS requireGraphArgs(TypedNavHostGraphSpec<START_ROUTE_NAV_ARGS> typedNavHostGraphSpec, SavedStateHandle savedStateHandle) {
            Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
            return (START_ROUTE_NAV_ARGS) TypedNavGraphSpec.DefaultImpls.requireGraphArgs(typedNavHostGraphSpec, savedStateHandle);
        }

        public static <START_ROUTE_NAV_ARGS> START_ROUTE_NAV_ARGS requireGraphArgs(TypedNavHostGraphSpec<START_ROUTE_NAV_ARGS> typedNavHostGraphSpec, NavBackStackEntry navBackStackEntry) {
            Intrinsics.checkNotNullParameter(navBackStackEntry, "navBackStackEntry");
            return (START_ROUTE_NAV_ARGS) TypedNavGraphSpec.DefaultImpls.requireGraphArgs(typedNavHostGraphSpec, navBackStackEntry);
        }
    }

    START_ROUTE_NAV_ARGS getDefaultStartArgs();

    Direction getDefaultStartDirection();

    @Override // com.ramcosta.composedestinations.spec.TypedNavGraphSpec
    NavHostAnimatedDestinationStyle getDefaultTransitions();
}
