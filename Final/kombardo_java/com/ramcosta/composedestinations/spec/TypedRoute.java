package com.ramcosta.composedestinations.spec;

import android.os.Bundle;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NamedNavArgument;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDeepLink;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H¦\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\t\u001a\u0004\u0018\u00018\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\t\u001a\u0004\u0018\u00018\u00002\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\t\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000e8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u000e8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00190\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0017\u0082\u0001\u0002\u001c\u001d¨\u0006\u001e"}, d2 = {"Lcom/ramcosta/composedestinations/spec/TypedRoute;", "NAV_ARGS", "Lcom/ramcosta/composedestinations/spec/RouteOrDirection;", "navArgs", "Lcom/ramcosta/composedestinations/spec/Direction;", "invoke", "(Ljava/lang/Object;)Lcom/ramcosta/composedestinations/spec/Direction;", "Landroid/os/Bundle;", "bundle", "argsFrom", "(Landroid/os/Bundle;)Ljava/lang/Object;", "Landroidx/lifecycle/SavedStateHandle;", "savedStateHandle", "(Landroidx/lifecycle/SavedStateHandle;)Ljava/lang/Object;", BuildConfig.FLAVOR, "getRoute", "()Ljava/lang/String;", "route", "getBaseRoute", "baseRoute", BuildConfig.FLAVOR, "Landroidx/navigation/NamedNavArgument;", "getArguments", "()Ljava/util/List;", "arguments", "Landroidx/navigation/NavDeepLink;", "getDeepLinks", "deepLinks", "Lcom/ramcosta/composedestinations/spec/TypedDestinationSpec;", "Lcom/ramcosta/composedestinations/spec/TypedNavGraphSpec;", "compose-destinations_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface TypedRoute<NAV_ARGS> extends RouteOrDirection {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static <NAV_ARGS> NAV_ARGS argsFrom(TypedRoute<NAV_ARGS> typedRoute, NavBackStackEntry navBackStackEntry) {
            Intrinsics.checkNotNullParameter(navBackStackEntry, "navBackStackEntry");
            return typedRoute.argsFrom(navBackStackEntry.getArguments());
        }

        public static <NAV_ARGS> List<NamedNavArgument> getArguments(TypedRoute<NAV_ARGS> typedRoute) {
            return CollectionsKt.emptyList();
        }

        public static <NAV_ARGS> List<NavDeepLink> getDeepLinks(TypedRoute<NAV_ARGS> typedRoute) {
            return CollectionsKt.emptyList();
        }
    }

    NAV_ARGS argsFrom(Bundle bundle);

    NAV_ARGS argsFrom(SavedStateHandle savedStateHandle);

    List<NamedNavArgument> getArguments();

    String getBaseRoute();

    List<NavDeepLink> getDeepLinks();

    @Override // com.ramcosta.composedestinations.spec.RouteOrDirection
    String getRoute();

    Direction invoke(NAV_ARGS navArgs);
}
