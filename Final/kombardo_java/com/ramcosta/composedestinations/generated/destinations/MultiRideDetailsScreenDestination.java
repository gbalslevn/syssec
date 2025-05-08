package com.ramcosta.composedestinations.generated.destinations;

import android.os.Bundle;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NamedNavArgument;
import androidx.navigation.NamedNavArgumentKt;
import androidx.navigation.NavArgumentBuilder;
import androidx.navigation.NavDeepLink;
import com.ramcosta.composedestinations.generated.destinations.MultiRideDetailsScreenDestination;
import com.ramcosta.composedestinations.generated.navtype.UserVehicleNavType;
import com.ramcosta.composedestinations.generated.navtype.UserVehicleNavTypeKt;
import com.ramcosta.composedestinations.navargs.primitives.DestinationsStringNavTypeKt;
import com.ramcosta.composedestinations.navigation.DestinationDependenciesContainerImpl;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import com.ramcosta.composedestinations.result.ResultCommonsKt;
import com.ramcosta.composedestinations.result.ResultRecipient;
import com.ramcosta.composedestinations.scope.DestinationScope;
import com.ramcosta.composedestinations.spec.BaseRoute;
import com.ramcosta.composedestinations.spec.DestinationStyle;
import com.ramcosta.composedestinations.spec.Direction;
import com.ramcosta.composedestinations.spec.DirectionKt;
import com.ramcosta.composedestinations.spec.TypedDestinationSpec;
import dk.molslinjen.ui.views.screens.agreements.multiride.details.MultiRideDetailsScreenKt;
import dk.molslinjen.ui.views.screens.agreements.multiride.details.MultiRideDetailsScreenNavArgs;
import dk.molslinjen.ui.views.screens.agreements.multiride.details.MultiRideDetailsViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\n\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H\u0096\u0002J\u0011\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0086\u0002J\u0017\u0010\u0015\u001a\u00020\u0016*\b\u0012\u0004\u0012\u00020\u00030\u0017H\u0017¢\u0006\u0002\u0010\u0018J\u0012\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\t\u0010\u001e\u001a\u00020\nHÖ\u0001R\u0014\u0010\u000b\u001a\u00020\nX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/ramcosta/composedestinations/generated/destinations/MultiRideDetailsScreenDestination;", "Lcom/ramcosta/composedestinations/spec/BaseRoute;", "Lcom/ramcosta/composedestinations/spec/TypedDestinationSpec;", "Ldk/molslinjen/ui/views/screens/agreements/multiride/details/MultiRideDetailsScreenNavArgs;", "<init>", "()V", "invoke", "Lcom/ramcosta/composedestinations/spec/Direction;", "navArgs", "multiRideCardNumber", BuildConfig.FLAVOR, "baseRoute", "getBaseRoute", "()Ljava/lang/String;", "route", "getRoute", "arguments", BuildConfig.FLAVOR, "Landroidx/navigation/NamedNavArgument;", "getArguments", "()Ljava/util/List;", "Content", BuildConfig.FLAVOR, "Lcom/ramcosta/composedestinations/scope/DestinationScope;", "(Lcom/ramcosta/composedestinations/scope/DestinationScope;Landroidx/compose/runtime/Composer;I)V", "argsFrom", "bundle", "Landroid/os/Bundle;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "toString", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class MultiRideDetailsScreenDestination extends BaseRoute implements TypedDestinationSpec<MultiRideDetailsScreenNavArgs> {
    public static final MultiRideDetailsScreenDestination INSTANCE;
    private static final String baseRoute;
    private static final String route;

    static {
        MultiRideDetailsScreenDestination multiRideDetailsScreenDestination = new MultiRideDetailsScreenDestination();
        INSTANCE = multiRideDetailsScreenDestination;
        baseRoute = "multi_ride_details_screen";
        route = multiRideDetailsScreenDestination.getBaseRoute() + "/{multiRideCardNumber}";
    }

    private MultiRideDetailsScreenDestination() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _get_arguments_$lambda$1(NavArgumentBuilder navArgument) {
        Intrinsics.checkNotNullParameter(navArgument, "$this$navArgument");
        navArgument.setType(DestinationsStringNavTypeKt.getStringNavType());
        return Unit.INSTANCE;
    }

    @Override // com.ramcosta.composedestinations.spec.TypedDestinationSpec
    public void Content(DestinationScope<MultiRideDetailsScreenNavArgs> destinationScope, Composer composer, int i5) {
        Intrinsics.checkNotNullParameter(destinationScope, "<this>");
        composer.startReplaceGroup(-1451632081);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1451632081, i5, -1, "com.ramcosta.composedestinations.generated.destinations.MultiRideDetailsScreenDestination.Content (MultiRideDetailsScreenDestination.kt:51)");
        }
        MultiRideDetailsViewModel multiRideDetailsViewModel = (MultiRideDetailsViewModel) ((DestinationDependenciesContainerImpl) destinationScope.buildDependencies(composer, i5 & 14)).require(Reflection.getOrCreateKotlinClass(MultiRideDetailsViewModel.class), false);
        DestinationsNavigator destinationsNavigator = destinationScope.getDestinationsNavigator();
        UserVehicleNavType userVehicleNavType = UserVehicleNavTypeKt.getUserVehicleNavType();
        composer.startReplaceGroup(1363506722);
        ResultRecipient resultRecipient = ResultCommonsKt.resultRecipient(destinationScope.getNavBackStackEntry(), Reflection.getOrCreateKotlinClass(VehicleSelectorScreenDestination.class), userVehicleNavType, composer, 0);
        composer.endReplaceGroup();
        MultiRideDetailsScreenKt.MultiRideDetailsScreen(multiRideDetailsViewModel, destinationsNavigator, resultRecipient, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
    }

    @Override // com.ramcosta.composedestinations.spec.TypedRoute
    public List<NamedNavArgument> getArguments() {
        return CollectionsKt.listOf(NamedNavArgumentKt.navArgument("multiRideCardNumber", new Function1() { // from class: f1.Z
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit _get_arguments_$lambda$1;
                _get_arguments_$lambda$1 = MultiRideDetailsScreenDestination._get_arguments_$lambda$1((NavArgumentBuilder) obj);
                return _get_arguments_$lambda$1;
            }
        }));
    }

    @Override // com.ramcosta.composedestinations.spec.TypedRoute
    public String getBaseRoute() {
        return baseRoute;
    }

    @Override // com.ramcosta.composedestinations.spec.TypedRoute
    public List<NavDeepLink> getDeepLinks() {
        return TypedDestinationSpec.DefaultImpls.getDeepLinks(this);
    }

    @Override // com.ramcosta.composedestinations.spec.TypedRoute, com.ramcosta.composedestinations.spec.RouteOrDirection
    public String getRoute() {
        return route;
    }

    @Override // com.ramcosta.composedestinations.spec.TypedDestinationSpec
    public DestinationStyle getStyle() {
        return TypedDestinationSpec.DefaultImpls.getStyle(this);
    }

    public String toString() {
        return "MultiRideDetailsScreenDestination";
    }

    @Override // com.ramcosta.composedestinations.spec.TypedRoute
    public Direction invoke(MultiRideDetailsScreenNavArgs navArgs) {
        Intrinsics.checkNotNullParameter(navArgs, "navArgs");
        return INSTANCE.invoke(navArgs.getMultiRideCardNumber());
    }

    @Override // com.ramcosta.composedestinations.spec.TypedDestinationSpec, com.ramcosta.composedestinations.spec.TypedRoute
    public MultiRideDetailsScreenNavArgs argsFrom(Bundle bundle) {
        String safeGet = DestinationsStringNavTypeKt.getStringNavType().safeGet(bundle, "multiRideCardNumber");
        if (safeGet != null) {
            return new MultiRideDetailsScreenNavArgs(safeGet);
        }
        throw new RuntimeException("'multiRideCardNumber' argument is mandatory, but was not present!");
    }

    public final Direction invoke(String multiRideCardNumber) {
        Intrinsics.checkNotNullParameter(multiRideCardNumber, "multiRideCardNumber");
        return DirectionKt.Direction(getBaseRoute() + "/" + DestinationsStringNavTypeKt.getStringNavType().serializeValue("multiRideCardNumber", multiRideCardNumber));
    }

    @Override // com.ramcosta.composedestinations.spec.TypedDestinationSpec, com.ramcosta.composedestinations.spec.TypedRoute
    public MultiRideDetailsScreenNavArgs argsFrom(SavedStateHandle savedStateHandle) {
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        String str = DestinationsStringNavTypeKt.getStringNavType().get(savedStateHandle, "multiRideCardNumber");
        if (str != null) {
            return new MultiRideDetailsScreenNavArgs(str);
        }
        throw new RuntimeException("'multiRideCardNumber' argument is mandatory, but was not present!");
    }
}
