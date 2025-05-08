package com.ramcosta.composedestinations.generated.destinations;

import android.os.Bundle;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NamedNavArgument;
import androidx.navigation.NamedNavArgumentKt;
import androidx.navigation.NavArgumentBuilder;
import androidx.navigation.NavDeepLink;
import com.ramcosta.composedestinations.bottomsheet.spec.DestinationStyleBottomSheet;
import com.ramcosta.composedestinations.generated.destinations.VehicleSelectorScreenDestination;
import com.ramcosta.composedestinations.generated.navtype.EnumCustomNavTypesKt;
import com.ramcosta.composedestinations.generated.navtype.UserVehicleNavTypeKt;
import com.ramcosta.composedestinations.navargs.primitives.DestinationsEnumNavType;
import com.ramcosta.composedestinations.navargs.primitives.arraylist.DestinationsStringArrayListNavTypeKt;
import com.ramcosta.composedestinations.navigation.DestinationDependenciesContainerImpl;
import com.ramcosta.composedestinations.scope.DestinationScope;
import com.ramcosta.composedestinations.scope.DestinationScopeKt;
import com.ramcosta.composedestinations.spec.BaseRoute;
import com.ramcosta.composedestinations.spec.DestinationStyle;
import com.ramcosta.composedestinations.spec.Direction;
import com.ramcosta.composedestinations.spec.DirectionKt;
import com.ramcosta.composedestinations.spec.TypedDestinationSpec;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.ui.views.screens.profile.vehicles.selector.VehicleSelectorScreenKt;
import dk.molslinjen.ui.views.screens.profile.vehicles.selector.VehicleSelectorScreenNavArgs;
import dk.molslinjen.ui.views.screens.profile.vehicles.selector.VehicleSelectorViewModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\n\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H\u0096\u0002J-\u0010\u0006\u001a\u00020\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\r\u001a\u00020\u000eH\u0086\u0002J\u0017\u0010\u001d\u001a\u00020\u001e*\b\u0012\u0004\u0012\u00020\u00030\u001fH\u0017¢\u0006\u0002\u0010 J\u0012\u0010!\u001a\u00020\u00032\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0010\u0010!\u001a\u00020\u00032\u0006\u0010$\u001a\u00020%H\u0016J\t\u0010&\u001a\u00020\u000bHÖ\u0001R\u0014\u0010\u000f\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u001aX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006'"}, d2 = {"Lcom/ramcosta/composedestinations/generated/destinations/VehicleSelectorScreenDestination;", "Lcom/ramcosta/composedestinations/spec/BaseRoute;", "Lcom/ramcosta/composedestinations/spec/TypedDestinationSpec;", "Ldk/molslinjen/ui/views/screens/profile/vehicles/selector/VehicleSelectorScreenNavArgs;", "<init>", "()V", "invoke", "Lcom/ramcosta/composedestinations/spec/Direction;", "navArgs", "carIds", "Ljava/util/ArrayList;", BuildConfig.FLAVOR, "transportationIds", "site", "Ldk/molslinjen/domain/model/config/Site;", "baseRoute", "getBaseRoute", "()Ljava/lang/String;", "route", "getRoute", "arguments", BuildConfig.FLAVOR, "Landroidx/navigation/NamedNavArgument;", "getArguments", "()Ljava/util/List;", "style", "Lcom/ramcosta/composedestinations/spec/DestinationStyle;", "getStyle", "()Lcom/ramcosta/composedestinations/spec/DestinationStyle;", "Content", BuildConfig.FLAVOR, "Lcom/ramcosta/composedestinations/scope/DestinationScope;", "(Lcom/ramcosta/composedestinations/scope/DestinationScope;Landroidx/compose/runtime/Composer;I)V", "argsFrom", "bundle", "Landroid/os/Bundle;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "toString", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class VehicleSelectorScreenDestination extends BaseRoute implements TypedDestinationSpec<VehicleSelectorScreenNavArgs> {
    public static final int $stable;
    public static final VehicleSelectorScreenDestination INSTANCE;
    private static final String baseRoute;
    private static final String route;
    private static final DestinationStyle style;

    static {
        VehicleSelectorScreenDestination vehicleSelectorScreenDestination = new VehicleSelectorScreenDestination();
        INSTANCE = vehicleSelectorScreenDestination;
        baseRoute = "vehicle_selector_screen";
        route = vehicleSelectorScreenDestination.getBaseRoute() + "/{carIds}/{transportationIds}/{site}";
        style = DestinationStyleBottomSheet.INSTANCE;
        $stable = DestinationStyle.$stable;
    }

    private VehicleSelectorScreenDestination() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _get_arguments_$lambda$1(NavArgumentBuilder navArgument) {
        Intrinsics.checkNotNullParameter(navArgument, "$this$navArgument");
        navArgument.setType(DestinationsStringArrayListNavTypeKt.getStringArrayListNavType());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _get_arguments_$lambda$2(NavArgumentBuilder navArgument) {
        Intrinsics.checkNotNullParameter(navArgument, "$this$navArgument");
        navArgument.setType(DestinationsStringArrayListNavTypeKt.getStringArrayListNavType());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _get_arguments_$lambda$3(NavArgumentBuilder navArgument) {
        Intrinsics.checkNotNullParameter(navArgument, "$this$navArgument");
        navArgument.setType(EnumCustomNavTypesKt.getSiteEnumNavType());
        return Unit.INSTANCE;
    }

    @Override // com.ramcosta.composedestinations.spec.TypedDestinationSpec
    public void Content(DestinationScope<VehicleSelectorScreenNavArgs> destinationScope, Composer composer, int i5) {
        Intrinsics.checkNotNullParameter(destinationScope, "<this>");
        composer.startReplaceGroup(2041333937);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2041333937, i5, -1, "com.ramcosta.composedestinations.generated.destinations.VehicleSelectorScreenDestination.Content (VehicleSelectorScreenDestination.kt:67)");
        }
        int i6 = i5 & 14;
        VehicleSelectorScreenKt.VehicleSelectorScreen((VehicleSelectorViewModel) ((DestinationDependenciesContainerImpl) destinationScope.buildDependencies(composer, i6)).require(Reflection.getOrCreateKotlinClass(VehicleSelectorViewModel.class), false), destinationScope.getDestinationsNavigator(), DestinationScopeKt.resultBackNavigator(destinationScope, UserVehicleNavTypeKt.getUserVehicleNavType(), composer, i6), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
    }

    @Override // com.ramcosta.composedestinations.spec.TypedRoute
    public List<NamedNavArgument> getArguments() {
        return CollectionsKt.listOf((Object[]) new NamedNavArgument[]{NamedNavArgumentKt.navArgument("carIds", new Function1() { // from class: f1.z0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit _get_arguments_$lambda$1;
                _get_arguments_$lambda$1 = VehicleSelectorScreenDestination._get_arguments_$lambda$1((NavArgumentBuilder) obj);
                return _get_arguments_$lambda$1;
            }
        }), NamedNavArgumentKt.navArgument("transportationIds", new Function1() { // from class: f1.A0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit _get_arguments_$lambda$2;
                _get_arguments_$lambda$2 = VehicleSelectorScreenDestination._get_arguments_$lambda$2((NavArgumentBuilder) obj);
                return _get_arguments_$lambda$2;
            }
        }), NamedNavArgumentKt.navArgument("site", new Function1() { // from class: f1.B0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit _get_arguments_$lambda$3;
                _get_arguments_$lambda$3 = VehicleSelectorScreenDestination._get_arguments_$lambda$3((NavArgumentBuilder) obj);
                return _get_arguments_$lambda$3;
            }
        })});
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
        return style;
    }

    public String toString() {
        return "VehicleSelectorScreenDestination";
    }

    @Override // com.ramcosta.composedestinations.spec.TypedRoute
    public Direction invoke(VehicleSelectorScreenNavArgs navArgs) {
        Intrinsics.checkNotNullParameter(navArgs, "navArgs");
        return INSTANCE.invoke(navArgs.getCarIds(), navArgs.getTransportationIds(), navArgs.getSite());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ramcosta.composedestinations.spec.TypedDestinationSpec, com.ramcosta.composedestinations.spec.TypedRoute
    public VehicleSelectorScreenNavArgs argsFrom(Bundle bundle) {
        ArrayList<String> safeGet = DestinationsStringArrayListNavTypeKt.getStringArrayListNavType().safeGet(bundle, "carIds");
        if (safeGet != null) {
            ArrayList<String> safeGet2 = DestinationsStringArrayListNavTypeKt.getStringArrayListNavType().safeGet(bundle, "transportationIds");
            if (safeGet2 != null) {
                Site site = (Site) EnumCustomNavTypesKt.getSiteEnumNavType().safeGet(bundle, "site");
                if (site != null) {
                    return new VehicleSelectorScreenNavArgs(safeGet, safeGet2, site);
                }
                throw new RuntimeException("'site' argument is mandatory, but was not present!");
            }
            throw new RuntimeException("'transportationIds' argument is mandatory, but was not present!");
        }
        throw new RuntimeException("'carIds' argument is mandatory, but was not present!");
    }

    public final Direction invoke(ArrayList<String> carIds, ArrayList<String> transportationIds, Site site) {
        Intrinsics.checkNotNullParameter(carIds, "carIds");
        Intrinsics.checkNotNullParameter(transportationIds, "transportationIds");
        Intrinsics.checkNotNullParameter(site, "site");
        return DirectionKt.Direction(getBaseRoute() + "/" + DestinationsStringArrayListNavTypeKt.getStringArrayListNavType().serializeValue(carIds) + "/" + DestinationsStringArrayListNavTypeKt.getStringArrayListNavType().serializeValue(transportationIds) + "/" + EnumCustomNavTypesKt.getSiteEnumNavType().serializeValue((DestinationsEnumNavType<Site>) site));
    }

    @Override // com.ramcosta.composedestinations.spec.TypedDestinationSpec, com.ramcosta.composedestinations.spec.TypedRoute
    public VehicleSelectorScreenNavArgs argsFrom(SavedStateHandle savedStateHandle) {
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        ArrayList<String> arrayList = DestinationsStringArrayListNavTypeKt.getStringArrayListNavType().get(savedStateHandle, "carIds");
        if (arrayList != null) {
            ArrayList<String> arrayList2 = DestinationsStringArrayListNavTypeKt.getStringArrayListNavType().get(savedStateHandle, "transportationIds");
            if (arrayList2 != null) {
                Site site = EnumCustomNavTypesKt.getSiteEnumNavType().get(savedStateHandle, "site");
                if (site != null) {
                    return new VehicleSelectorScreenNavArgs(arrayList, arrayList2, site);
                }
                throw new RuntimeException("'site' argument is mandatory, but was not present!");
            }
            throw new RuntimeException("'transportationIds' argument is mandatory, but was not present!");
        }
        throw new RuntimeException("'carIds' argument is mandatory, but was not present!");
    }
}
