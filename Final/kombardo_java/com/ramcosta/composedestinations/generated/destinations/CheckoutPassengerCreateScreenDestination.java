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
import com.ramcosta.composedestinations.generated.destinations.CheckoutPassengerCreateScreenDestination;
import com.ramcosta.composedestinations.generated.navtype.EnumCustomNavTypesKt;
import com.ramcosta.composedestinations.generated.navtype.LocaleNavType;
import com.ramcosta.composedestinations.generated.navtype.LocaleNavTypeKt;
import com.ramcosta.composedestinations.navargs.primitives.DestinationsBooleanNavTypeKt;
import com.ramcosta.composedestinations.navargs.primitives.DestinationsEnumNavType;
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
import dk.molslinjen.domain.model.booking.DepartureDirection;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.ui.views.screens.booking.passengers.create.CheckoutPassengerCreateScreenKt;
import dk.molslinjen.ui.views.screens.booking.passengers.create.CheckoutPassengerCreateScreenNavArgs;
import dk.molslinjen.ui.views.screens.booking.passengers.create.CheckoutPassengerCreateViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\n\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H\u0096\u0002J!\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0086\u0002J\u0017\u0010\u001e\u001a\u00020\u001f*\b\u0012\u0004\u0012\u00020\u00030 H\u0017¢\u0006\u0002\u0010!J\u0012\u0010\"\u001a\u00020\u00032\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u0010\u0010\"\u001a\u00020\u00032\u0006\u0010%\u001a\u00020&H\u0016J\t\u0010'\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u000f\u001a\u00020\u0010X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u001bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006("}, d2 = {"Lcom/ramcosta/composedestinations/generated/destinations/CheckoutPassengerCreateScreenDestination;", "Lcom/ramcosta/composedestinations/spec/BaseRoute;", "Lcom/ramcosta/composedestinations/spec/TypedDestinationSpec;", "Ldk/molslinjen/ui/views/screens/booking/passengers/create/CheckoutPassengerCreateScreenNavArgs;", "<init>", "()V", "invoke", "Lcom/ramcosta/composedestinations/spec/Direction;", "navArgs", "direction", "Ldk/molslinjen/domain/model/booking/DepartureDirection;", "selectAfterCreation", BuildConfig.FLAVOR, "site", "Ldk/molslinjen/domain/model/config/Site;", "baseRoute", BuildConfig.FLAVOR, "getBaseRoute", "()Ljava/lang/String;", "route", "getRoute", "arguments", BuildConfig.FLAVOR, "Landroidx/navigation/NamedNavArgument;", "getArguments", "()Ljava/util/List;", "style", "Lcom/ramcosta/composedestinations/spec/DestinationStyle;", "getStyle", "()Lcom/ramcosta/composedestinations/spec/DestinationStyle;", "Content", BuildConfig.FLAVOR, "Lcom/ramcosta/composedestinations/scope/DestinationScope;", "(Lcom/ramcosta/composedestinations/scope/DestinationScope;Landroidx/compose/runtime/Composer;I)V", "argsFrom", "bundle", "Landroid/os/Bundle;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "toString", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class CheckoutPassengerCreateScreenDestination extends BaseRoute implements TypedDestinationSpec<CheckoutPassengerCreateScreenNavArgs> {
    public static final int $stable;
    public static final CheckoutPassengerCreateScreenDestination INSTANCE;
    private static final String baseRoute;
    private static final String route;
    private static final DestinationStyle style;

    static {
        CheckoutPassengerCreateScreenDestination checkoutPassengerCreateScreenDestination = new CheckoutPassengerCreateScreenDestination();
        INSTANCE = checkoutPassengerCreateScreenDestination;
        baseRoute = "checkout_passenger_create_screen";
        route = checkoutPassengerCreateScreenDestination.getBaseRoute() + "/{direction}/{selectAfterCreation}/{site}";
        style = DestinationStyleBottomSheet.INSTANCE;
        $stable = DestinationStyle.$stable;
    }

    private CheckoutPassengerCreateScreenDestination() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _get_arguments_$lambda$1(NavArgumentBuilder navArgument) {
        Intrinsics.checkNotNullParameter(navArgument, "$this$navArgument");
        navArgument.setType(EnumCustomNavTypesKt.getDepartureDirectionEnumNavType());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _get_arguments_$lambda$2(NavArgumentBuilder navArgument) {
        Intrinsics.checkNotNullParameter(navArgument, "$this$navArgument");
        navArgument.setType(DestinationsBooleanNavTypeKt.getBooleanNavType());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _get_arguments_$lambda$3(NavArgumentBuilder navArgument) {
        Intrinsics.checkNotNullParameter(navArgument, "$this$navArgument");
        navArgument.setType(EnumCustomNavTypesKt.getSiteEnumNavType());
        return Unit.INSTANCE;
    }

    @Override // com.ramcosta.composedestinations.spec.TypedDestinationSpec
    public void Content(DestinationScope<CheckoutPassengerCreateScreenNavArgs> destinationScope, Composer composer, int i5) {
        Intrinsics.checkNotNullParameter(destinationScope, "<this>");
        composer.startReplaceGroup(272124475);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(272124475, i5, -1, "com.ramcosta.composedestinations.generated.destinations.CheckoutPassengerCreateScreenDestination.Content (CheckoutPassengerCreateScreenDestination.kt:68)");
        }
        CheckoutPassengerCreateViewModel checkoutPassengerCreateViewModel = (CheckoutPassengerCreateViewModel) ((DestinationDependenciesContainerImpl) destinationScope.buildDependencies(composer, i5 & 14)).require(Reflection.getOrCreateKotlinClass(CheckoutPassengerCreateViewModel.class), false);
        DestinationsNavigator destinationsNavigator = destinationScope.getDestinationsNavigator();
        LocaleNavType localeNavType = LocaleNavTypeKt.getLocaleNavType();
        composer.startReplaceGroup(1363506722);
        ResultRecipient resultRecipient = ResultCommonsKt.resultRecipient(destinationScope.getNavBackStackEntry(), Reflection.getOrCreateKotlinClass(NationalitySelectionScreenDestination.class), localeNavType, composer, 0);
        composer.endReplaceGroup();
        CheckoutPassengerCreateScreenKt.CheckoutPassengerCreateScreen(checkoutPassengerCreateViewModel, destinationsNavigator, resultRecipient, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
    }

    @Override // com.ramcosta.composedestinations.spec.TypedRoute
    public List<NamedNavArgument> getArguments() {
        return CollectionsKt.listOf((Object[]) new NamedNavArgument[]{NamedNavArgumentKt.navArgument("direction", new Function1() { // from class: f1.p
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit _get_arguments_$lambda$1;
                _get_arguments_$lambda$1 = CheckoutPassengerCreateScreenDestination._get_arguments_$lambda$1((NavArgumentBuilder) obj);
                return _get_arguments_$lambda$1;
            }
        }), NamedNavArgumentKt.navArgument("selectAfterCreation", new Function1() { // from class: f1.q
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit _get_arguments_$lambda$2;
                _get_arguments_$lambda$2 = CheckoutPassengerCreateScreenDestination._get_arguments_$lambda$2((NavArgumentBuilder) obj);
                return _get_arguments_$lambda$2;
            }
        }), NamedNavArgumentKt.navArgument("site", new Function1() { // from class: f1.r
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit _get_arguments_$lambda$3;
                _get_arguments_$lambda$3 = CheckoutPassengerCreateScreenDestination._get_arguments_$lambda$3((NavArgumentBuilder) obj);
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
        return "CheckoutPassengerCreateScreenDestination";
    }

    @Override // com.ramcosta.composedestinations.spec.TypedRoute
    public Direction invoke(CheckoutPassengerCreateScreenNavArgs navArgs) {
        Intrinsics.checkNotNullParameter(navArgs, "navArgs");
        return INSTANCE.invoke(navArgs.getDirection(), navArgs.getSelectAfterCreation(), navArgs.getSite());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ramcosta.composedestinations.spec.TypedDestinationSpec, com.ramcosta.composedestinations.spec.TypedRoute
    public CheckoutPassengerCreateScreenNavArgs argsFrom(Bundle bundle) {
        DepartureDirection departureDirection = (DepartureDirection) EnumCustomNavTypesKt.getDepartureDirectionEnumNavType().safeGet(bundle, "direction");
        if (departureDirection != null) {
            Boolean safeGet = DestinationsBooleanNavTypeKt.getBooleanNavType().safeGet(bundle, "selectAfterCreation");
            if (safeGet != null) {
                boolean booleanValue = safeGet.booleanValue();
                Site site = (Site) EnumCustomNavTypesKt.getSiteEnumNavType().safeGet(bundle, "site");
                if (site != null) {
                    return new CheckoutPassengerCreateScreenNavArgs(departureDirection, booleanValue, site);
                }
                throw new RuntimeException("'site' argument is mandatory, but was not present!");
            }
            throw new RuntimeException("'selectAfterCreation' argument is mandatory, but was not present!");
        }
        throw new RuntimeException("'direction' argument is mandatory, but was not present!");
    }

    public final Direction invoke(DepartureDirection direction, boolean selectAfterCreation, Site site) {
        Intrinsics.checkNotNullParameter(direction, "direction");
        Intrinsics.checkNotNullParameter(site, "site");
        return DirectionKt.Direction(getBaseRoute() + "/" + EnumCustomNavTypesKt.getDepartureDirectionEnumNavType().serializeValue((DestinationsEnumNavType<DepartureDirection>) direction) + "/" + DestinationsBooleanNavTypeKt.getBooleanNavType().serializeValue(Boolean.valueOf(selectAfterCreation)) + "/" + EnumCustomNavTypesKt.getSiteEnumNavType().serializeValue((DestinationsEnumNavType<Site>) site));
    }

    @Override // com.ramcosta.composedestinations.spec.TypedDestinationSpec, com.ramcosta.composedestinations.spec.TypedRoute
    public CheckoutPassengerCreateScreenNavArgs argsFrom(SavedStateHandle savedStateHandle) {
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        DepartureDirection departureDirection = EnumCustomNavTypesKt.getDepartureDirectionEnumNavType().get(savedStateHandle, "direction");
        if (departureDirection != null) {
            Boolean bool = DestinationsBooleanNavTypeKt.getBooleanNavType().get(savedStateHandle, "selectAfterCreation");
            if (bool != null) {
                boolean booleanValue = bool.booleanValue();
                Site site = EnumCustomNavTypesKt.getSiteEnumNavType().get(savedStateHandle, "site");
                if (site != null) {
                    return new CheckoutPassengerCreateScreenNavArgs(departureDirection, booleanValue, site);
                }
                throw new RuntimeException("'site' argument is mandatory, but was not present!");
            }
            throw new RuntimeException("'selectAfterCreation' argument is mandatory, but was not present!");
        }
        throw new RuntimeException("'direction' argument is mandatory, but was not present!");
    }
}
