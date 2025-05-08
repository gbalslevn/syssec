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
import com.ramcosta.composedestinations.generated.destinations.EarlyCheckInScreenDestination;
import com.ramcosta.composedestinations.generated.navtype.EnumCustomNavTypesKt;
import com.ramcosta.composedestinations.generated.navtype.UserVehicleNavType;
import com.ramcosta.composedestinations.generated.navtype.UserVehicleNavTypeKt;
import com.ramcosta.composedestinations.navargs.primitives.DestinationsEnumNavType;
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
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.EarlyCheckInScreenKt;
import dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.EarlyCheckInScreenNavArgs;
import dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.EarlyCheckInViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\n\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H\u0096\u0002J!\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0086\u0002J\u0017\u0010\u001c\u001a\u00020\u001d*\b\u0012\u0004\u0012\u00020\u00030\u001eH\u0017¢\u0006\u0002\u0010\u001fJ\u0012\u0010 \u001a\u00020\u00032\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0010\u0010 \u001a\u00020\u00032\u0006\u0010#\u001a\u00020$H\u0016J\t\u0010%\u001a\u00020\nHÖ\u0001R\u0014\u0010\u000e\u001a\u00020\nX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u0019X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006&"}, d2 = {"Lcom/ramcosta/composedestinations/generated/destinations/EarlyCheckInScreenDestination;", "Lcom/ramcosta/composedestinations/spec/BaseRoute;", "Lcom/ramcosta/composedestinations/spec/TypedDestinationSpec;", "Ldk/molslinjen/ui/views/screens/tickets/earlyCheckIn/EarlyCheckInScreenNavArgs;", "<init>", "()V", "invoke", "Lcom/ramcosta/composedestinations/spec/Direction;", "navArgs", "reservationNumber", BuildConfig.FLAVOR, "phone", "site", "Ldk/molslinjen/domain/model/config/Site;", "baseRoute", "getBaseRoute", "()Ljava/lang/String;", "route", "getRoute", "arguments", BuildConfig.FLAVOR, "Landroidx/navigation/NamedNavArgument;", "getArguments", "()Ljava/util/List;", "style", "Lcom/ramcosta/composedestinations/spec/DestinationStyle;", "getStyle", "()Lcom/ramcosta/composedestinations/spec/DestinationStyle;", "Content", BuildConfig.FLAVOR, "Lcom/ramcosta/composedestinations/scope/DestinationScope;", "(Lcom/ramcosta/composedestinations/scope/DestinationScope;Landroidx/compose/runtime/Composer;I)V", "argsFrom", "bundle", "Landroid/os/Bundle;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "toString", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class EarlyCheckInScreenDestination extends BaseRoute implements TypedDestinationSpec<EarlyCheckInScreenNavArgs> {
    public static final int $stable;
    public static final EarlyCheckInScreenDestination INSTANCE;
    private static final String baseRoute;
    private static final String route;
    private static final DestinationStyle style;

    static {
        EarlyCheckInScreenDestination earlyCheckInScreenDestination = new EarlyCheckInScreenDestination();
        INSTANCE = earlyCheckInScreenDestination;
        baseRoute = "early_check_in_screen";
        route = earlyCheckInScreenDestination.getBaseRoute() + "/{reservationNumber}/{phone}/{site}";
        style = DestinationStyleBottomSheet.INSTANCE;
        $stable = DestinationStyle.$stable;
    }

    private EarlyCheckInScreenDestination() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _get_arguments_$lambda$1(NavArgumentBuilder navArgument) {
        Intrinsics.checkNotNullParameter(navArgument, "$this$navArgument");
        navArgument.setType(DestinationsStringNavTypeKt.getStringNavType());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _get_arguments_$lambda$2(NavArgumentBuilder navArgument) {
        Intrinsics.checkNotNullParameter(navArgument, "$this$navArgument");
        navArgument.setType(DestinationsStringNavTypeKt.getStringNavType());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _get_arguments_$lambda$3(NavArgumentBuilder navArgument) {
        Intrinsics.checkNotNullParameter(navArgument, "$this$navArgument");
        navArgument.setType(EnumCustomNavTypesKt.getSiteEnumNavType());
        return Unit.INSTANCE;
    }

    @Override // com.ramcosta.composedestinations.spec.TypedDestinationSpec
    public void Content(DestinationScope<EarlyCheckInScreenNavArgs> destinationScope, Composer composer, int i5) {
        Intrinsics.checkNotNullParameter(destinationScope, "<this>");
        composer.startReplaceGroup(1233659791);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1233659791, i5, -1, "com.ramcosta.composedestinations.generated.destinations.EarlyCheckInScreenDestination.Content (EarlyCheckInScreenDestination.kt:66)");
        }
        EarlyCheckInViewModel earlyCheckInViewModel = (EarlyCheckInViewModel) ((DestinationDependenciesContainerImpl) destinationScope.buildDependencies(composer, i5 & 14)).require(Reflection.getOrCreateKotlinClass(EarlyCheckInViewModel.class), false);
        DestinationsNavigator destinationsNavigator = destinationScope.getDestinationsNavigator();
        UserVehicleNavType userVehicleNavType = UserVehicleNavTypeKt.getUserVehicleNavType();
        composer.startReplaceGroup(1363506722);
        ResultRecipient resultRecipient = ResultCommonsKt.resultRecipient(destinationScope.getNavBackStackEntry(), Reflection.getOrCreateKotlinClass(VehicleSelectorScreenDestination.class), userVehicleNavType, composer, 0);
        composer.endReplaceGroup();
        EarlyCheckInScreenKt.EarlyCheckInScreen(earlyCheckInViewModel, destinationsNavigator, resultRecipient, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
    }

    @Override // com.ramcosta.composedestinations.spec.TypedRoute
    public List<NamedNavArgument> getArguments() {
        return CollectionsKt.listOf((Object[]) new NamedNavArgument[]{NamedNavArgumentKt.navArgument("reservationNumber", new Function1() { // from class: f1.K
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit _get_arguments_$lambda$1;
                _get_arguments_$lambda$1 = EarlyCheckInScreenDestination._get_arguments_$lambda$1((NavArgumentBuilder) obj);
                return _get_arguments_$lambda$1;
            }
        }), NamedNavArgumentKt.navArgument("phone", new Function1() { // from class: f1.L
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit _get_arguments_$lambda$2;
                _get_arguments_$lambda$2 = EarlyCheckInScreenDestination._get_arguments_$lambda$2((NavArgumentBuilder) obj);
                return _get_arguments_$lambda$2;
            }
        }), NamedNavArgumentKt.navArgument("site", new Function1() { // from class: f1.M
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit _get_arguments_$lambda$3;
                _get_arguments_$lambda$3 = EarlyCheckInScreenDestination._get_arguments_$lambda$3((NavArgumentBuilder) obj);
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
        return "EarlyCheckInScreenDestination";
    }

    @Override // com.ramcosta.composedestinations.spec.TypedRoute
    public Direction invoke(EarlyCheckInScreenNavArgs navArgs) {
        Intrinsics.checkNotNullParameter(navArgs, "navArgs");
        return INSTANCE.invoke(navArgs.getReservationNumber(), navArgs.getPhone(), navArgs.getSite());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ramcosta.composedestinations.spec.TypedDestinationSpec, com.ramcosta.composedestinations.spec.TypedRoute
    public EarlyCheckInScreenNavArgs argsFrom(Bundle bundle) {
        String safeGet = DestinationsStringNavTypeKt.getStringNavType().safeGet(bundle, "reservationNumber");
        if (safeGet != null) {
            String safeGet2 = DestinationsStringNavTypeKt.getStringNavType().safeGet(bundle, "phone");
            if (safeGet2 != null) {
                Site site = (Site) EnumCustomNavTypesKt.getSiteEnumNavType().safeGet(bundle, "site");
                if (site != null) {
                    return new EarlyCheckInScreenNavArgs(safeGet, safeGet2, site);
                }
                throw new RuntimeException("'site' argument is mandatory, but was not present!");
            }
            throw new RuntimeException("'phone' argument is mandatory, but was not present!");
        }
        throw new RuntimeException("'reservationNumber' argument is mandatory, but was not present!");
    }

    public final Direction invoke(String reservationNumber, String phone, Site site) {
        Intrinsics.checkNotNullParameter(reservationNumber, "reservationNumber");
        Intrinsics.checkNotNullParameter(phone, "phone");
        Intrinsics.checkNotNullParameter(site, "site");
        return DirectionKt.Direction(getBaseRoute() + "/" + DestinationsStringNavTypeKt.getStringNavType().serializeValue("reservationNumber", reservationNumber) + "/" + DestinationsStringNavTypeKt.getStringNavType().serializeValue("phone", phone) + "/" + EnumCustomNavTypesKt.getSiteEnumNavType().serializeValue((DestinationsEnumNavType<Site>) site));
    }

    @Override // com.ramcosta.composedestinations.spec.TypedDestinationSpec, com.ramcosta.composedestinations.spec.TypedRoute
    public EarlyCheckInScreenNavArgs argsFrom(SavedStateHandle savedStateHandle) {
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        String str = DestinationsStringNavTypeKt.getStringNavType().get(savedStateHandle, "reservationNumber");
        if (str != null) {
            String str2 = DestinationsStringNavTypeKt.getStringNavType().get(savedStateHandle, "phone");
            if (str2 != null) {
                Site site = EnumCustomNavTypesKt.getSiteEnumNavType().get(savedStateHandle, "site");
                if (site != null) {
                    return new EarlyCheckInScreenNavArgs(str, str2, site);
                }
                throw new RuntimeException("'site' argument is mandatory, but was not present!");
            }
            throw new RuntimeException("'phone' argument is mandatory, but was not present!");
        }
        throw new RuntimeException("'reservationNumber' argument is mandatory, but was not present!");
    }
}
