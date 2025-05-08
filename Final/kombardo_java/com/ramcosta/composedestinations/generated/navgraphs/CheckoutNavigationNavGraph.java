package com.ramcosta.composedestinations.generated.navgraphs;

import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NamedNavArgument;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDeepLink;
import com.ramcosta.composedestinations.generated.destinations.AddonsScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.BookingSummaryScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.FoodScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.PassengerCountScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.PassengersScreenDestination;
import com.ramcosta.composedestinations.spec.BaseRoute;
import com.ramcosta.composedestinations.spec.DestinationStyle;
import com.ramcosta.composedestinations.spec.Direction;
import com.ramcosta.composedestinations.spec.DirectionKt;
import com.ramcosta.composedestinations.spec.TypedDestinationSpec;
import com.ramcosta.composedestinations.spec.TypedNavGraphSpec;
import com.ramcosta.composedestinations.spec.TypedRoute;
import dk.molslinjen.ui.views.global.navigation.transitions.HorizontalScreenTransitions;
import dk.molslinjen.ui.views.screens.booking.passengers.PassengersScreenNavArgs;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;

@Keep
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\n\u0018\u00002\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0003H\u0096\u0002J\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001f\u001a\u00020 H\u0016J\t\u0010$\u001a\u00020\u0014HÖ\u0001R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\"\u0010\n\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u00030\u0007j\u0002`\f0\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u0014X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u000e¨\u0006%"}, d2 = {"Lcom/ramcosta/composedestinations/generated/navgraphs/CheckoutNavigationNavGraph;", "Lcom/ramcosta/composedestinations/spec/BaseRoute;", "Lcom/ramcosta/composedestinations/spec/TypedNavGraphSpec;", "Ldk/molslinjen/ui/views/screens/booking/passengers/PassengersScreenNavArgs;", "<init>", "()V", "startRoute", "Lcom/ramcosta/composedestinations/spec/TypedDestinationSpec;", "getStartRoute", "()Lcom/ramcosta/composedestinations/spec/TypedDestinationSpec;", "destinations", BuildConfig.FLAVOR, "Lcom/ramcosta/composedestinations/spec/DestinationSpec;", "getDestinations", "()Ljava/util/List;", "defaultTransitions", "Lcom/ramcosta/composedestinations/spec/DestinationStyle$Animated;", "getDefaultTransitions", "()Lcom/ramcosta/composedestinations/spec/DestinationStyle$Animated;", "baseRoute", BuildConfig.FLAVOR, "getBaseRoute", "()Ljava/lang/String;", "route", "getRoute", "invoke", "Lcom/ramcosta/composedestinations/spec/Direction;", "navArgs", "argsFrom", "bundle", "Landroid/os/Bundle;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "arguments", "Landroidx/navigation/NamedNavArgument;", "getArguments", "toString", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class CheckoutNavigationNavGraph extends BaseRoute implements TypedNavGraphSpec<PassengersScreenNavArgs, PassengersScreenNavArgs> {
    public static final int $stable;
    public static final CheckoutNavigationNavGraph INSTANCE;
    private static final String baseRoute;
    private static final DestinationStyle.Animated defaultTransitions;
    private static final String route;
    private static final TypedDestinationSpec<PassengersScreenNavArgs> startRoute;

    static {
        CheckoutNavigationNavGraph checkoutNavigationNavGraph = new CheckoutNavigationNavGraph();
        INSTANCE = checkoutNavigationNavGraph;
        startRoute = PassengersScreenDestination.INSTANCE;
        defaultTransitions = HorizontalScreenTransitions.INSTANCE;
        baseRoute = "checkout";
        route = checkoutNavigationNavGraph.getBaseRoute() + StringsKt.removePrefix(checkoutNavigationNavGraph.getStartRoute2().getRoute(), checkoutNavigationNavGraph.getStartRoute2().getBaseRoute());
        $stable = 8;
    }

    private CheckoutNavigationNavGraph() {
    }

    /* renamed from: argsFrom, reason: merged with bridge method [inline-methods] */
    public PassengersScreenNavArgs m3176argsFrom(NavBackStackEntry navBackStackEntry) {
        return (PassengersScreenNavArgs) TypedNavGraphSpec.DefaultImpls.argsFrom(this, navBackStackEntry);
    }

    @Override // com.ramcosta.composedestinations.spec.TypedRoute
    public List<NamedNavArgument> getArguments() {
        return getStartRoute2().getArguments();
    }

    @Override // com.ramcosta.composedestinations.spec.TypedRoute
    public String getBaseRoute() {
        return baseRoute;
    }

    @Override // com.ramcosta.composedestinations.spec.TypedRoute
    public List<NavDeepLink> getDeepLinks() {
        return TypedNavGraphSpec.DefaultImpls.getDeepLinks(this);
    }

    @Override // com.ramcosta.composedestinations.spec.TypedNavGraphSpec
    public DestinationStyle.Animated getDefaultTransitions() {
        return defaultTransitions;
    }

    @Override // com.ramcosta.composedestinations.spec.TypedNavGraphSpec
    public List<TypedDestinationSpec<?>> getDestinations() {
        return CollectionsKt.listOf((Object[]) new TypedDestinationSpec[]{AddonsScreenDestination.INSTANCE, FoodScreenDestination.INSTANCE, PassengersScreenDestination.INSTANCE, PassengerCountScreenDestination.INSTANCE, BookingSummaryScreenDestination.INSTANCE});
    }

    @Override // com.ramcosta.composedestinations.spec.TypedNavGraphSpec
    public List<TypedNavGraphSpec<?, ?>> getNestedNavGraphs() {
        return TypedNavGraphSpec.DefaultImpls.getNestedNavGraphs(this);
    }

    @Override // com.ramcosta.composedestinations.spec.TypedRoute, com.ramcosta.composedestinations.spec.RouteOrDirection
    public String getRoute() {
        return route;
    }

    /* renamed from: requireGraphArgs, reason: merged with bridge method [inline-methods] */
    public PassengersScreenNavArgs m3177requireGraphArgs(Bundle bundle) {
        return (PassengersScreenNavArgs) TypedNavGraphSpec.DefaultImpls.requireGraphArgs(this, bundle);
    }

    public String toString() {
        return "CheckoutNavigationNavGraph";
    }

    @Override // com.ramcosta.composedestinations.spec.TypedNavGraphSpec
    /* renamed from: getStartRoute, reason: merged with bridge method [inline-methods] */
    public TypedRoute<PassengersScreenNavArgs> getStartRoute2() {
        return startRoute;
    }

    @Override // com.ramcosta.composedestinations.spec.TypedRoute
    public Direction invoke(PassengersScreenNavArgs navArgs) {
        Intrinsics.checkNotNullParameter(navArgs, "navArgs");
        return DirectionKt.Direction(getBaseRoute() + StringsKt.removePrefix(getStartRoute2().invoke(navArgs).getRoute(), getStartRoute2().getBaseRoute()));
    }

    /* renamed from: requireGraphArgs, reason: merged with bridge method [inline-methods] */
    public PassengersScreenNavArgs m3178requireGraphArgs(SavedStateHandle savedStateHandle) {
        return (PassengersScreenNavArgs) TypedNavGraphSpec.DefaultImpls.requireGraphArgs(this, savedStateHandle);
    }

    /* renamed from: requireGraphArgs, reason: merged with bridge method [inline-methods] */
    public PassengersScreenNavArgs m3179requireGraphArgs(NavBackStackEntry navBackStackEntry) {
        return (PassengersScreenNavArgs) TypedNavGraphSpec.DefaultImpls.requireGraphArgs(this, navBackStackEntry);
    }

    @Override // com.ramcosta.composedestinations.spec.TypedRoute
    public PassengersScreenNavArgs argsFrom(Bundle bundle) {
        return (PassengersScreenNavArgs) getStartRoute2().argsFrom(bundle);
    }

    @Override // com.ramcosta.composedestinations.spec.TypedRoute
    public PassengersScreenNavArgs argsFrom(SavedStateHandle savedStateHandle) {
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        return (PassengersScreenNavArgs) getStartRoute2().argsFrom(savedStateHandle);
    }
}
