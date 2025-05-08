package com.ramcosta.composedestinations.generated.navgraphs;

import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NamedNavArgument;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDeepLink;
import com.ramcosta.composedestinations.animations.NavHostAnimatedDestinationStyle;
import com.ramcosta.composedestinations.generated.destinations.AccountActivationScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.AddExistingTicketScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.AgreementsScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.AssetsMergeScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.BarcodeDetailsScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.BornholmCommuterAddScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.BornholmCommuterDetailsScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.CalendarScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.CargoDetailsScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.ChangePasswordScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.CheckoutDetailsScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.CheckoutPassengerCreateScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.CheckoutPassengerEditScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.CommuterOverviewScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.CommuterTicketHistoryScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.ContactScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.CurrenciesScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.DeepLinkScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.DeparturesCommuterScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.DeparturesEditScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.DeparturesMultiRideScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.DeparturesReturnScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.DeparturesScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.DeveloperBottomSheetWithStickyScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.DeveloperComponentsScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.DeveloperInputComponentsScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.DeveloperNavigationScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.EarlyCheckInAddonsScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.EarlyCheckInFoodScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.EarlyCheckInPassengerCreateScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.EarlyCheckInPassengerEditScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.EarlyCheckInPassengerSelectorScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.EarlyCheckInProcessingScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.EarlyCheckInScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.ErrorScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.FaqScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.FaqSubjectScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.FerryFloorSectionsScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.FerrySectionSeatsScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.FoodBarcodeDetailsScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.ForgotPasswordScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.LoginScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.LoungeBarcodeDetailsScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.ManuelForceUpdateScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.MigrationErrorScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.MultiRideAddCardScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.MultiRideCardPurchaseSummaryScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.MultiRideDetailsScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.MultiRidePurchaseReceiptScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.MultiRidePurchaseScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.MultiRideRefillScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.MultiRideScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.MultiRideTicketHistoryScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.NationalitySelectionScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.OeresundCommuterDetailsScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.OnboardingLocationScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.OnboardingLoginScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.OnboardingMarketingNotificationsScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.OnboardingNotificationsScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.OnboardingSelectRouteScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.PassengerCountSelectorScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.PassengerHelpScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.PaymentBottomSheetScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.PaymentScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.PermissionsScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.PhoneNumberCodeSelectionScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.ProfileBrobizzRegisterScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.ProfileBrobizzScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.ProfileCreditCardsScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.ProfileEditScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.ProfileNewslettersScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.ProfilePassengerEditScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.ProfilePassengersRegisterScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.ProfilePassengersScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.ProfileScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.ProfileVehicleEditScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.ProfileVehiclesRegisterScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.ProfileVehiclesScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.ReceiptScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.RefundReceiptScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.ResetPasswordScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.RouteSelectorScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.SaleOnBoardBarcodeDetailsScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.SaleOnBoardBasketScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.SaleOnBoardDepartureSelectorScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.SaleOnBoardFoodListScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.SaleOnBoardOrderDetailsScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.SaleOnBoardOrderHistoryScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.SaleOnBoardProductDetailsScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.SaleOnBoardReceiptScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.SaleOnBoardScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.SignupScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.SimpleChangeAddonsScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.SimpleChangeFoodScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.SimpleChangeReceiptScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.SimpleChangeSummaryScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.TicketDetailsScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.TicketHistoryScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.TicketTypeKombardoScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.TicketTypeMolslinjenScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.TicketTypeScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.TicketsScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.TrailerSelectorScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.TransportProductSelectorScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.TransportationSelectorScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.VehicleSelectorScreenDestination;
import com.ramcosta.composedestinations.spec.BaseRoute;
import com.ramcosta.composedestinations.spec.Direction;
import com.ramcosta.composedestinations.spec.DirectionNavHostGraphSpec;
import com.ramcosta.composedestinations.spec.NavHostGraphSpecKt;
import com.ramcosta.composedestinations.spec.TypedDestinationSpec;
import com.ramcosta.composedestinations.spec.TypedNavGraphSpec;
import com.ramcosta.composedestinations.spec.TypedRoute;
import dk.molslinjen.ui.views.global.navigation.transitions.HorizontalScreenTransitions;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import org.conscrypt.BuildConfig;

@Keep
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÇ\n\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\t\u0010 \u001a\u00020\u001dHÖ\u0001R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\"\u0010\u000e\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u00030\u0010j\u0002`\u00110\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R&\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0015j\u0002`\u00160\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u0019X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u001dX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006!"}, d2 = {"Lcom/ramcosta/composedestinations/generated/navgraphs/AnimatedRootNavigationNavGraph;", "Lcom/ramcosta/composedestinations/spec/BaseRoute;", "Lcom/ramcosta/composedestinations/spec/DirectionNavHostGraphSpec;", "<init>", "()V", "startRoute", "Lcom/ramcosta/composedestinations/spec/TypedRoute;", BuildConfig.FLAVOR, "getStartRoute", "()Lcom/ramcosta/composedestinations/spec/TypedRoute;", "defaultStartDirection", "Lcom/ramcosta/composedestinations/spec/Direction;", "getDefaultStartDirection", "()Lcom/ramcosta/composedestinations/spec/Direction;", "destinations", BuildConfig.FLAVOR, "Lcom/ramcosta/composedestinations/spec/TypedDestinationSpec;", "Lcom/ramcosta/composedestinations/spec/DestinationSpec;", "getDestinations", "()Ljava/util/List;", "nestedNavGraphs", "Lcom/ramcosta/composedestinations/spec/TypedNavGraphSpec;", "Lcom/ramcosta/composedestinations/spec/NavGraphSpec;", "getNestedNavGraphs", "defaultTransitions", "Lcom/ramcosta/composedestinations/animations/NavHostAnimatedDestinationStyle;", "getDefaultTransitions", "()Lcom/ramcosta/composedestinations/animations/NavHostAnimatedDestinationStyle;", "route", BuildConfig.FLAVOR, "getRoute", "()Ljava/lang/String;", "toString", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class AnimatedRootNavigationNavGraph extends BaseRoute implements DirectionNavHostGraphSpec {
    public static final int $stable;
    public static final AnimatedRootNavigationNavGraph INSTANCE;
    private static final Direction defaultStartDirection;
    private static final NavHostAnimatedDestinationStyle defaultTransitions;
    private static final String route;
    private static final TypedRoute<Unit> startRoute;

    static {
        AnimatedRootNavigationNavGraph animatedRootNavigationNavGraph = new AnimatedRootNavigationNavGraph();
        INSTANCE = animatedRootNavigationNavGraph;
        startRoute = TicketsScreenDestination.INSTANCE;
        defaultStartDirection = NavHostGraphSpecKt.defaultStartDirection(animatedRootNavigationNavGraph);
        defaultTransitions = HorizontalScreenTransitions.INSTANCE;
        route = "animated-root";
        $stable = 8;
    }

    private AnimatedRootNavigationNavGraph() {
    }

    @Override // com.ramcosta.composedestinations.spec.TypedRoute
    public /* bridge */ /* synthetic */ Object argsFrom(Bundle bundle) {
        m3171argsFrom(bundle);
        return Unit.INSTANCE;
    }

    @Override // com.ramcosta.composedestinations.spec.TypedRoute
    public List<NamedNavArgument> getArguments() {
        return DirectionNavHostGraphSpec.DefaultImpls.getArguments(this);
    }

    @Override // com.ramcosta.composedestinations.spec.TypedRoute
    public String getBaseRoute() {
        return DirectionNavHostGraphSpec.DefaultImpls.getBaseRoute(this);
    }

    @Override // com.ramcosta.composedestinations.spec.TypedRoute
    public List<NavDeepLink> getDeepLinks() {
        return DirectionNavHostGraphSpec.DefaultImpls.getDeepLinks(this);
    }

    @Override // com.ramcosta.composedestinations.spec.TypedNavHostGraphSpec
    public Direction getDefaultStartDirection() {
        return defaultStartDirection;
    }

    @Override // com.ramcosta.composedestinations.spec.TypedNavGraphSpec
    public List<TypedDestinationSpec<?>> getDestinations() {
        return CollectionsKt.listOf((Object[]) new TypedDestinationSpec[]{NationalitySelectionScreenDestination.INSTANCE, PhoneNumberCodeSelectionScreenDestination.INSTANCE, AgreementsScreenDestination.INSTANCE, CommuterOverviewScreenDestination.INSTANCE, BornholmCommuterAddScreenDestination.INSTANCE, BornholmCommuterDetailsScreenDestination.INSTANCE, CommuterTicketHistoryScreenDestination.INSTANCE, OeresundCommuterDetailsScreenDestination.INSTANCE, MultiRideAddCardScreenDestination.INSTANCE, MultiRideDetailsScreenDestination.INSTANCE, MultiRideTicketHistoryScreenDestination.INSTANCE, MultiRideScreenDestination.INSTANCE, MultiRideCardPurchaseSummaryScreenDestination.INSTANCE, MultiRidePurchaseReceiptScreenDestination.INSTANCE, MultiRidePurchaseScreenDestination.INSTANCE, MultiRideRefillScreenDestination.INSTANCE, FerryFloorSectionsScreenDestination.INSTANCE, FerrySectionSeatsScreenDestination.INSTANCE, DeparturesCommuterScreenDestination.INSTANCE, DeparturesEditScreenDestination.INSTANCE, DeparturesMultiRideScreenDestination.INSTANCE, DeparturesReturnScreenDestination.INSTANCE, DeparturesScreenDestination.INSTANCE, CalendarScreenDestination.INSTANCE, PassengerCountSelectorScreenDestination.INSTANCE, RouteSelectorScreenDestination.INSTANCE, TrailerSelectorScreenDestination.INSTANCE, CargoDetailsScreenDestination.INSTANCE, TransportationSelectorScreenDestination.INSTANCE, TransportProductSelectorScreenDestination.INSTANCE, PassengerHelpScreenDestination.INSTANCE, CheckoutPassengerCreateScreenDestination.INSTANCE, EarlyCheckInPassengerCreateScreenDestination.INSTANCE, CheckoutPassengerEditScreenDestination.INSTANCE, EarlyCheckInPassengerEditScreenDestination.INSTANCE, PaymentBottomSheetScreenDestination.INSTANCE, PaymentScreenDestination.INSTANCE, ReceiptScreenDestination.INSTANCE, CheckoutDetailsScreenDestination.INSTANCE, SimpleChangeSummaryScreenDestination.INSTANCE, EarlyCheckInAddonsScreenDestination.INSTANCE, SimpleChangeAddonsScreenDestination.INSTANCE, EarlyCheckInFoodScreenDestination.INSTANCE, SimpleChangeFoodScreenDestination.INSTANCE, SimpleChangeReceiptScreenDestination.INSTANCE, TicketTypeKombardoScreenDestination.INSTANCE, TicketTypeMolslinjenScreenDestination.INSTANCE, TicketTypeScreenDestination.INSTANCE, DeepLinkScreenDestination.INSTANCE, DeveloperBottomSheetWithStickyScreenDestination.INSTANCE, DeveloperComponentsScreenDestination.INSTANCE, DeveloperInputComponentsScreenDestination.INSTANCE, DeveloperNavigationScreenDestination.INSTANCE, ManuelForceUpdateScreenDestination.INSTANCE, MigrationErrorScreenDestination.INSTANCE, OnboardingLocationScreenDestination.INSTANCE, OnboardingLoginScreenDestination.INSTANCE, OnboardingMarketingNotificationsScreenDestination.INSTANCE, OnboardingNotificationsScreenDestination.INSTANCE, OnboardingSelectRouteScreenDestination.INSTANCE, ProfileScreenDestination.INSTANCE, AccountActivationScreenDestination.INSTANCE, LoginScreenDestination.INSTANCE, ForgotPasswordScreenDestination.INSTANCE, ResetPasswordScreenDestination.INSTANCE, SignupScreenDestination.INSTANCE, ProfileBrobizzScreenDestination.INSTANCE, ProfileBrobizzRegisterScreenDestination.INSTANCE, ContactScreenDestination.INSTANCE, ProfileCreditCardsScreenDestination.INSTANCE, CurrenciesScreenDestination.INSTANCE, ProfileEditScreenDestination.INSTANCE, ChangePasswordScreenDestination.INSTANCE, FaqScreenDestination.INSTANCE, FaqSubjectScreenDestination.INSTANCE, AssetsMergeScreenDestination.INSTANCE, ProfileNewslettersScreenDestination.INSTANCE, ProfilePassengersScreenDestination.INSTANCE, ProfilePassengerEditScreenDestination.INSTANCE, ProfilePassengersRegisterScreenDestination.INSTANCE, PermissionsScreenDestination.INSTANCE, ProfileVehiclesScreenDestination.INSTANCE, ProfileVehicleEditScreenDestination.INSTANCE, ProfileVehiclesRegisterScreenDestination.INSTANCE, VehicleSelectorScreenDestination.INSTANCE, SaleOnBoardScreenDestination.INSTANCE, SaleOnBoardBasketScreenDestination.INSTANCE, SaleOnBoardFoodListScreenDestination.INSTANCE, SaleOnBoardOrderDetailsScreenDestination.INSTANCE, SaleOnBoardOrderHistoryScreenDestination.INSTANCE, SaleOnBoardProductDetailsScreenDestination.INSTANCE, SaleOnBoardReceiptScreenDestination.INSTANCE, SaleOnBoardDepartureSelectorScreenDestination.INSTANCE, TicketsScreenDestination.INSTANCE, AddExistingTicketScreenDestination.INSTANCE, BarcodeDetailsScreenDestination.INSTANCE, FoodBarcodeDetailsScreenDestination.INSTANCE, LoungeBarcodeDetailsScreenDestination.INSTANCE, SaleOnBoardBarcodeDetailsScreenDestination.INSTANCE, TicketDetailsScreenDestination.INSTANCE, EarlyCheckInScreenDestination.INSTANCE, EarlyCheckInPassengerSelectorScreenDestination.INSTANCE, EarlyCheckInProcessingScreenDestination.INSTANCE, TicketHistoryScreenDestination.INSTANCE, RefundReceiptScreenDestination.INSTANCE, ErrorScreenDestination.INSTANCE});
    }

    @Override // com.ramcosta.composedestinations.spec.TypedNavGraphSpec
    public List<TypedNavGraphSpec<?, ?>> getNestedNavGraphs() {
        return CollectionsKt.listOf(CheckoutNavigationNavGraph.INSTANCE);
    }

    @Override // com.ramcosta.composedestinations.spec.TypedRoute, com.ramcosta.composedestinations.spec.RouteOrDirection
    public String getRoute() {
        return route;
    }

    @Override // com.ramcosta.composedestinations.spec.TypedNavGraphSpec
    /* renamed from: getStartRoute */
    public TypedRoute<Unit> getStartRoute2() {
        return startRoute;
    }

    public Direction invoke() {
        return DirectionNavHostGraphSpec.DefaultImpls.invoke(this);
    }

    public /* bridge */ /* synthetic */ Object requireGraphArgs(Bundle bundle) {
        m3173requireGraphArgs(bundle);
        return Unit.INSTANCE;
    }

    public String toString() {
        return "AnimatedRootNavigationNavGraph";
    }

    @Override // com.ramcosta.composedestinations.spec.TypedRoute
    public /* bridge */ /* synthetic */ Object argsFrom(SavedStateHandle savedStateHandle) {
        m3172argsFrom(savedStateHandle);
        return Unit.INSTANCE;
    }

    @Override // com.ramcosta.composedestinations.spec.TypedNavHostGraphSpec
    public Unit getDefaultStartArgs() {
        return DirectionNavHostGraphSpec.DefaultImpls.getDefaultStartArgs(this);
    }

    @Override // com.ramcosta.composedestinations.spec.TypedNavGraphSpec
    public NavHostAnimatedDestinationStyle getDefaultTransitions() {
        return defaultTransitions;
    }

    public /* bridge */ /* synthetic */ Object requireGraphArgs(SavedStateHandle savedStateHandle) {
        m3174requireGraphArgs(savedStateHandle);
        return Unit.INSTANCE;
    }

    @Override // com.ramcosta.composedestinations.spec.TypedRoute
    public Direction invoke(Unit unit) {
        return DirectionNavHostGraphSpec.DefaultImpls.invoke(this, unit);
    }

    public /* bridge */ /* synthetic */ Object requireGraphArgs(NavBackStackEntry navBackStackEntry) {
        m3175requireGraphArgs(navBackStackEntry);
        return Unit.INSTANCE;
    }

    public Unit argsFrom(NavBackStackEntry navBackStackEntry) {
        return DirectionNavHostGraphSpec.DefaultImpls.argsFrom(this, navBackStackEntry);
    }

    /* renamed from: requireGraphArgs, reason: collision with other method in class */
    public void m3173requireGraphArgs(Bundle bundle) {
        DirectionNavHostGraphSpec.DefaultImpls.requireGraphArgs(this, bundle);
    }

    /* renamed from: argsFrom, reason: collision with other method in class */
    public void m3171argsFrom(Bundle bundle) {
        DirectionNavHostGraphSpec.DefaultImpls.argsFrom(this, bundle);
    }

    /* renamed from: requireGraphArgs, reason: collision with other method in class */
    public void m3174requireGraphArgs(SavedStateHandle savedStateHandle) {
        DirectionNavHostGraphSpec.DefaultImpls.requireGraphArgs(this, savedStateHandle);
    }

    /* renamed from: argsFrom, reason: collision with other method in class */
    public void m3172argsFrom(SavedStateHandle savedStateHandle) {
        DirectionNavHostGraphSpec.DefaultImpls.argsFrom(this, savedStateHandle);
    }

    /* renamed from: requireGraphArgs, reason: collision with other method in class */
    public void m3175requireGraphArgs(NavBackStackEntry navBackStackEntry) {
        DirectionNavHostGraphSpec.DefaultImpls.requireGraphArgs(this, navBackStackEntry);
    }
}
