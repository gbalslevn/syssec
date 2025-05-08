package dk.molslinjen.ui.views.global.navigation;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.hilt.navigation.compose.HiltViewModelKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import com.ramcosta.composedestinations.navigation.DependenciesContainerBuilder;
import com.ramcosta.composedestinations.navigation.DestinationDependenciesContainerImpl;
import com.ramcosta.composedestinations.spec.TypedDestinationSpec;
import dk.molslinjen.ui.views.reusable.input.nationality.NationalitySelectionViewModel;
import dk.molslinjen.ui.views.reusable.input.phoneNumberCode.PhoneNumberCodeSelectionViewModel;
import dk.molslinjen.ui.views.screens.agreements.AgreementsViewModel;
import dk.molslinjen.ui.views.screens.agreements.commuter.bornholm.add.BornholmCommuterAddViewModel;
import dk.molslinjen.ui.views.screens.agreements.commuter.bornholm.details.BornholmCommuterDetailsViewModel;
import dk.molslinjen.ui.views.screens.agreements.commuter.bornholm.history.BornholmCommuterTicketHistoryViewModel;
import dk.molslinjen.ui.views.screens.agreements.commuter.oeresund.details.OeresundCommuterDetailsViewModel;
import dk.molslinjen.ui.views.screens.agreements.multiride.add.MultiRideAddCardViewModel;
import dk.molslinjen.ui.views.screens.agreements.multiride.details.MultiRideDetailsViewModel;
import dk.molslinjen.ui.views.screens.agreements.multiride.details.history.MultiRideTicketHistoryViewModel;
import dk.molslinjen.ui.views.screens.agreements.multiride.purchase.MultiRidePurchaseReceiptViewModel;
import dk.molslinjen.ui.views.screens.agreements.multiride.purchase.MultiRidePurchaseSummaryViewModel;
import dk.molslinjen.ui.views.screens.agreements.multiride.purchase.MultiRidePurchaseViewModel;
import dk.molslinjen.ui.views.screens.agreements.multiride.refill.MultiRideRefillViewModel;
import dk.molslinjen.ui.views.screens.booking.addons.AddonsViewModel;
import dk.molslinjen.ui.views.screens.booking.addons.seating.FerryFloorSectionViewModel;
import dk.molslinjen.ui.views.screens.booking.addons.seating.select.FerrySectionSeatsViewModel;
import dk.molslinjen.ui.views.screens.booking.departures.DeparturesViewModel;
import dk.molslinjen.ui.views.screens.booking.departures.calendar.CalendarViewModel;
import dk.molslinjen.ui.views.screens.booking.departures.selectPassengers.PassengerCountSelectorViewModel;
import dk.molslinjen.ui.views.screens.booking.departures.selectTrailers.TrailerSelectorViewModel;
import dk.molslinjen.ui.views.screens.booking.departures.selectTransportation.CargoDetailsViewModel;
import dk.molslinjen.ui.views.screens.booking.departures.selectTransportation.TransportationSelectorViewModel;
import dk.molslinjen.ui.views.screens.booking.departures.selectTransportationProducts.TransportProductSelectorViewModel;
import dk.molslinjen.ui.views.screens.booking.food.FoodViewModel;
import dk.molslinjen.ui.views.screens.booking.passengers.PassengersViewModel;
import dk.molslinjen.ui.views.screens.booking.passengers.count.PassengerCountViewModel;
import dk.molslinjen.ui.views.screens.booking.passengers.create.CheckoutPassengerCreateViewModel;
import dk.molslinjen.ui.views.screens.booking.passengers.create.EarlyCheckInPassengerCreateViewModel;
import dk.molslinjen.ui.views.screens.booking.passengers.edit.CheckoutPassengerEditViewModel;
import dk.molslinjen.ui.views.screens.booking.passengers.edit.EarlyCheckInPassengerEditViewModel;
import dk.molslinjen.ui.views.screens.booking.payment.PaymentViewModel;
import dk.molslinjen.ui.views.screens.booking.receipt.ReceiptViewModel;
import dk.molslinjen.ui.views.screens.booking.shared.CheckoutDetailsViewModel;
import dk.molslinjen.ui.views.screens.booking.simpleChange.SimpleChangeSummaryViewModel;
import dk.molslinjen.ui.views.screens.booking.simpleChange.addons.SimpleChangeAddonsViewModel;
import dk.molslinjen.ui.views.screens.booking.simpleChange.food.SimpleChangeFoodViewModel;
import dk.molslinjen.ui.views.screens.booking.simpleChange.receipt.SimpleChangeReceiptViewModel;
import dk.molslinjen.ui.views.screens.booking.summary.BookingSummaryViewModel;
import dk.molslinjen.ui.views.screens.deeplink.DeepLinkViewModel;
import dk.molslinjen.ui.views.screens.developer.inputs.DeveloperInputComponentsViewModel;
import dk.molslinjen.ui.views.screens.onboarding.location.OnboardingLocationViewModel;
import dk.molslinjen.ui.views.screens.onboarding.notifications.OnboardingMarketingNotificationsViewModel;
import dk.molslinjen.ui.views.screens.onboarding.notifications.OnboardingNotificationViewModel;
import dk.molslinjen.ui.views.screens.onboarding.selectRoute.OnboardingSelectRouteViewModel;
import dk.molslinjen.ui.views.screens.profile.ProfileViewModel;
import dk.molslinjen.ui.views.screens.profile.authentication.activation.AccountActivationViewModel;
import dk.molslinjen.ui.views.screens.profile.authentication.login.LoginViewModel;
import dk.molslinjen.ui.views.screens.profile.authentication.password.forgot.ForgotPasswordViewModel;
import dk.molslinjen.ui.views.screens.profile.authentication.password.reset.ResetPasswordViewModel;
import dk.molslinjen.ui.views.screens.profile.authentication.register.SignupViewModel;
import dk.molslinjen.ui.views.screens.profile.brobizz.ProfileBrobizzViewModel;
import dk.molslinjen.ui.views.screens.profile.brobizz.register.ProfileBrobizzRegisterViewModel;
import dk.molslinjen.ui.views.screens.profile.contact.ContactScreenViewModel;
import dk.molslinjen.ui.views.screens.profile.creditcards.ProfileCreditCardsViewModel;
import dk.molslinjen.ui.views.screens.profile.currencies.CurrenciesViewModel;
import dk.molslinjen.ui.views.screens.profile.edit.ProfileEditViewModel;
import dk.molslinjen.ui.views.screens.profile.edit.changePassword.ChangePasswordViewModel;
import dk.molslinjen.ui.views.screens.profile.faq.FaqViewModel;
import dk.molslinjen.ui.views.screens.profile.faq.subject.FaqSubjectViewModel;
import dk.molslinjen.ui.views.screens.profile.newsletters.ProfileNewslettersViewModel;
import dk.molslinjen.ui.views.screens.profile.passengers.ProfilePassengersViewModel;
import dk.molslinjen.ui.views.screens.profile.passengers.edit.ProfilePassengerEditViewModel;
import dk.molslinjen.ui.views.screens.profile.passengers.register.ProfilePassengersRegisterViewModel;
import dk.molslinjen.ui.views.screens.profile.permissions.PermissionsViewModel;
import dk.molslinjen.ui.views.screens.profile.vehicles.ProfileVehiclesViewModel;
import dk.molslinjen.ui.views.screens.profile.vehicles.edit.ProfileVehiclesEditViewModel;
import dk.molslinjen.ui.views.screens.profile.vehicles.register.ProfileVehiclesRegisterViewModel;
import dk.molslinjen.ui.views.screens.profile.vehicles.selector.VehicleSelectorViewModel;
import dk.molslinjen.ui.views.screens.saleOnBoard.SaleOnBoardViewModel;
import dk.molslinjen.ui.views.screens.saleOnBoard.basket.SaleOnBoardBasketViewModel;
import dk.molslinjen.ui.views.screens.saleOnBoard.foodListScreen.SaleOnBoardFoodListViewModel;
import dk.molslinjen.ui.views.screens.saleOnBoard.orderDetails.SaleOnBoardOrderDetailsViewModel;
import dk.molslinjen.ui.views.screens.saleOnBoard.orderHistory.SaleOnBoardOrderHistoryViewModel;
import dk.molslinjen.ui.views.screens.saleOnBoard.produdctDetails.SaleOnBoardProductDetailsViewModel;
import dk.molslinjen.ui.views.screens.saleOnBoard.receipt.SaleOnBoardReceiptViewModel;
import dk.molslinjen.ui.views.screens.saleOnBoard.selectDeparture.SaleOnBoardDepartureSelectorViewModel;
import dk.molslinjen.ui.views.screens.tickets.TicketsViewModel;
import dk.molslinjen.ui.views.screens.tickets.addExisting.AddExistingTicketViewModel;
import dk.molslinjen.ui.views.screens.tickets.barcodeDetails.BarcodeDetailsViewModel;
import dk.molslinjen.ui.views.screens.tickets.barcodeDetails.FoodBarcodeDetailsViewModel;
import dk.molslinjen.ui.views.screens.tickets.barcodeDetails.LoungeBarcodeDetailsViewModel;
import dk.molslinjen.ui.views.screens.tickets.barcodeDetails.SaleOnBoardBarcodeDetailsViewModel;
import dk.molslinjen.ui.views.screens.tickets.details.TicketDetailsViewModel;
import dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.EarlyCheckInViewModel;
import dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.passengerSelector.EarlyCheckInPassengerSelectorViewModel;
import dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.processing.EarlyCheckInProcessingViewModel;
import dk.molslinjen.ui.views.screens.tickets.history.TicketHistoryViewModel;
import dk.molslinjen.ui.views.screens.tickets.refund.RefundReceiptViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ComposableSingletons$ScreenConfigurationsKt {
    public static final ComposableSingletons$ScreenConfigurationsKt INSTANCE = new ComposableSingletons$ScreenConfigurationsKt();

    /* renamed from: lambda-1, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f53lambda1 = ComposableLambdaKt.composableLambdaInstance(258744529, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(258744529, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-1.<anonymous> (ScreenConfigurations.kt:104)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) DeepLinkViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(DeepLinkViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-2, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f64lambda2 = ComposableLambdaKt.composableLambdaInstance(2052929874, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2052929874, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-2.<anonymous> (ScreenConfigurations.kt:110)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) OnboardingSelectRouteViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(OnboardingSelectRouteViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-3, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f75lambda3 = ComposableLambdaKt.composableLambdaInstance(-447852077, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-3$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-447852077, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-3.<anonymous> (ScreenConfigurations.kt:116)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) OnboardingNotificationViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(OnboardingNotificationViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-4, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f86lambda4 = ComposableLambdaKt.composableLambdaInstance(1346333268, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-4$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1346333268, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-4.<anonymous> (ScreenConfigurations.kt:122)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) OnboardingMarketingNotificationsViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(OnboardingMarketingNotificationsViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-5, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f97lambda5 = ComposableLambdaKt.composableLambdaInstance(-1154448683, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-5$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1154448683, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-5.<anonymous> (ScreenConfigurations.kt:130)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) OnboardingLocationViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(OnboardingLocationViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-6, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f108lambda6 = ComposableLambdaKt.composableLambdaInstance(639736662, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-6$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(639736662, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-6.<anonymous> (ScreenConfigurations.kt:136)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) LoginViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(LoginViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-7, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f119lambda7 = ComposableLambdaKt.composableLambdaInstance(-1861045289, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-7$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1861045289, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-7.<anonymous> (ScreenConfigurations.kt:143)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) SaleOnBoardViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(SaleOnBoardViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-8, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f130lambda8 = ComposableLambdaKt.composableLambdaInstance(-66859944, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-8$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-66859944, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-8.<anonymous> (ScreenConfigurations.kt:152)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) SaleOnBoardFoodListViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(SaleOnBoardFoodListViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-9, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f141lambda9 = ComposableLambdaKt.composableLambdaInstance(1727325401, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-9$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1727325401, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-9.<anonymous> (ScreenConfigurations.kt:157)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) SaleOnBoardDepartureSelectorViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(SaleOnBoardDepartureSelectorViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-10, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f54lambda10 = ComposableLambdaKt.composableLambdaInstance(-773456550, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-10$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-773456550, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-10.<anonymous> (ScreenConfigurations.kt:164)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) SaleOnBoardProductDetailsViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(SaleOnBoardProductDetailsViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-11, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f55lambda11 = ComposableLambdaKt.composableLambdaInstance(246936546, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-11$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(246936546, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-11.<anonymous> (ScreenConfigurations.kt:172)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) SaleOnBoardBasketViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(SaleOnBoardBasketViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-12, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f56lambda12 = ComposableLambdaKt.composableLambdaInstance(2041121891, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-12$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2041121891, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-12.<anonymous> (ScreenConfigurations.kt:178)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) SaleOnBoardReceiptViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(SaleOnBoardReceiptViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-13, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f57lambda13 = ComposableLambdaKt.composableLambdaInstance(-459660060, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-13$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-459660060, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-13.<anonymous> (ScreenConfigurations.kt:183)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) SaleOnBoardOrderDetailsViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(SaleOnBoardOrderDetailsViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-14, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f58lambda14 = ComposableLambdaKt.composableLambdaInstance(1334525285, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-14$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1334525285, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-14.<anonymous> (ScreenConfigurations.kt:189)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) SaleOnBoardOrderHistoryViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(SaleOnBoardOrderHistoryViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-15, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f59lambda15 = ComposableLambdaKt.composableLambdaInstance(-1166256666, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-15$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1166256666, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-15.<anonymous> (ScreenConfigurations.kt:194)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) LoginViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(LoginViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-16, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f60lambda16 = ComposableLambdaKt.composableLambdaInstance(627928679, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-16$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(627928679, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-16.<anonymous> (ScreenConfigurations.kt:199)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) ForgotPasswordViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(ForgotPasswordViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-17, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f61lambda17 = ComposableLambdaKt.composableLambdaInstance(-1872853272, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-17$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1872853272, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-17.<anonymous> (ScreenConfigurations.kt:204)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) ResetPasswordViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(ResetPasswordViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-18, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f62lambda18 = ComposableLambdaKt.composableLambdaInstance(-78667927, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-18$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-78667927, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-18.<anonymous> (ScreenConfigurations.kt:209)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) AccountActivationViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(AccountActivationViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-19, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f63lambda19 = ComposableLambdaKt.composableLambdaInstance(1715517418, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-19$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1715517418, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-19.<anonymous> (ScreenConfigurations.kt:214)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) SignupViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(SignupViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-20, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f65lambda20 = ComposableLambdaKt.composableLambdaInstance(-785264533, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-20$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-785264533, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-20.<anonymous> (ScreenConfigurations.kt:219)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) NationalitySelectionViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(NationalitySelectionViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-21, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f66lambda21 = ComposableLambdaKt.composableLambdaInstance(32107393, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-21$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(32107393, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-21.<anonymous> (ScreenConfigurations.kt:224)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) PhoneNumberCodeSelectionViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(PhoneNumberCodeSelectionViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-22, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f67lambda22 = ComposableLambdaKt.composableLambdaInstance(1826292738, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-22$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1826292738, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-22.<anonymous> (ScreenConfigurations.kt:229)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) ProfileViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(ProfileViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-23, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f68lambda23 = ComposableLambdaKt.composableLambdaInstance(-674489213, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-23$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-674489213, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-23.<anonymous> (ScreenConfigurations.kt:234)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) ProfileEditViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(ProfileEditViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-24, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f69lambda24 = ComposableLambdaKt.composableLambdaInstance(1119696132, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-24$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1119696132, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-24.<anonymous> (ScreenConfigurations.kt:239)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) ChangePasswordViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(ChangePasswordViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-25, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f70lambda25 = ComposableLambdaKt.composableLambdaInstance(-1381085819, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-25$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1381085819, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-25.<anonymous> (ScreenConfigurations.kt:244)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) ProfileVehiclesViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(ProfileVehiclesViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-26, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f71lambda26 = ComposableLambdaKt.composableLambdaInstance(413099526, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-26$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(413099526, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-26.<anonymous> (ScreenConfigurations.kt:249)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) ProfileVehiclesRegisterViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(ProfileVehiclesRegisterViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-27, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f72lambda27 = ComposableLambdaKt.composableLambdaInstance(-2087682425, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-27$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2087682425, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-27.<anonymous> (ScreenConfigurations.kt:254)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) ProfileVehiclesEditViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(ProfileVehiclesEditViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-28, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f73lambda28 = ComposableLambdaKt.composableLambdaInstance(-293497080, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-28$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-293497080, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-28.<anonymous> (ScreenConfigurations.kt:259)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) ProfileNewslettersViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(ProfileNewslettersViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-29, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f74lambda29 = ComposableLambdaKt.composableLambdaInstance(1500688265, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-29$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1500688265, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-29.<anonymous> (ScreenConfigurations.kt:264)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) ProfileCreditCardsViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(ProfileCreditCardsViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-30, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f76lambda30 = ComposableLambdaKt.composableLambdaInstance(-1000093686, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-30$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1000093686, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-30.<anonymous> (ScreenConfigurations.kt:269)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) ProfilePassengersViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(ProfilePassengersViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-31, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f77lambda31 = ComposableLambdaKt.composableLambdaInstance(-182721760, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-31$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-182721760, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-31.<anonymous> (ScreenConfigurations.kt:274)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) ProfilePassengersRegisterViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(ProfilePassengersRegisterViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-32, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f78lambda32 = ComposableLambdaKt.composableLambdaInstance(1611463585, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-32$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1611463585, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-32.<anonymous> (ScreenConfigurations.kt:281)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) ProfilePassengerEditViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(ProfilePassengerEditViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-33, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f79lambda33 = ComposableLambdaKt.composableLambdaInstance(-889318366, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-33$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-889318366, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-33.<anonymous> (ScreenConfigurations.kt:286)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) CurrenciesViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(CurrenciesViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-34, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f80lambda34 = ComposableLambdaKt.composableLambdaInstance(904866979, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-34$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(904866979, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-34.<anonymous> (ScreenConfigurations.kt:291)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) ProfileBrobizzViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(ProfileBrobizzViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-35, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f81lambda35 = ComposableLambdaKt.composableLambdaInstance(-1595914972, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-35$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1595914972, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-35.<anonymous> (ScreenConfigurations.kt:296)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) ProfileBrobizzRegisterViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(ProfileBrobizzRegisterViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-36, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f82lambda36 = ComposableLambdaKt.composableLambdaInstance(198270373, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-36$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(198270373, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-36.<anonymous> (ScreenConfigurations.kt:301)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) ContactScreenViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(ContactScreenViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-37, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f83lambda37 = ComposableLambdaKt.composableLambdaInstance(1992455718, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-37$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1992455718, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-37.<anonymous> (ScreenConfigurations.kt:306)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) FaqViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(FaqViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-38, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f84lambda38 = ComposableLambdaKt.composableLambdaInstance(-508326233, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-38$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-508326233, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-38.<anonymous> (ScreenConfigurations.kt:311)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) FaqSubjectViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(FaqSubjectViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-39, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f85lambda39 = ComposableLambdaKt.composableLambdaInstance(1285859112, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-39$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1285859112, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-39.<anonymous> (ScreenConfigurations.kt:316)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) PermissionsViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(PermissionsViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-40, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f87lambda40 = ComposableLambdaKt.composableLambdaInstance(-1214922839, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-40$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1214922839, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-40.<anonymous> (ScreenConfigurations.kt:323)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) DeparturesViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(DeparturesViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-41, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f88lambda41 = ComposableLambdaKt.composableLambdaInstance(-397550913, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-41$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-397550913, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-41.<anonymous> (ScreenConfigurations.kt:329)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) DeparturesViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(DeparturesViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-42, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f89lambda42 = ComposableLambdaKt.composableLambdaInstance(1396634432, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-42$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1396634432, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-42.<anonymous> (ScreenConfigurations.kt:335)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) DeparturesViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(DeparturesViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-43, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f90lambda43 = ComposableLambdaKt.composableLambdaInstance(-1104147519, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-43$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1104147519, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-43.<anonymous> (ScreenConfigurations.kt:341)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) DeparturesViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(DeparturesViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-44, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f91lambda44 = ComposableLambdaKt.composableLambdaInstance(690037826, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-44$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(690037826, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-44.<anonymous> (ScreenConfigurations.kt:347)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) DeparturesViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(DeparturesViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-45, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f92lambda45 = ComposableLambdaKt.composableLambdaInstance(-1810744125, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-45$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1810744125, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-45.<anonymous> (ScreenConfigurations.kt:352)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) CalendarViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(CalendarViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-46, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f93lambda46 = ComposableLambdaKt.composableLambdaInstance(-16558780, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-46$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-16558780, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-46.<anonymous> (ScreenConfigurations.kt:359)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) TicketsViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(TicketsViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-47, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f94lambda47 = ComposableLambdaKt.composableLambdaInstance(1777626565, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-47$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1777626565, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-47.<anonymous> (ScreenConfigurations.kt:365)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) TicketHistoryViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(TicketHistoryViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-48, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f95lambda48 = ComposableLambdaKt.composableLambdaInstance(-723155386, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-48$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-723155386, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-48.<anonymous> (ScreenConfigurations.kt:374)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) TicketDetailsViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(TicketDetailsViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-49, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f96lambda49 = ComposableLambdaKt.composableLambdaInstance(1071029959, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-49$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1071029959, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-49.<anonymous> (ScreenConfigurations.kt:379)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) EarlyCheckInViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(EarlyCheckInViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-50, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f98lambda50 = ComposableLambdaKt.composableLambdaInstance(-1429751992, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-50$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1429751992, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-50.<anonymous> (ScreenConfigurations.kt:386)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) AgreementsViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(AgreementsViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-51, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f99lambda51 = ComposableLambdaKt.composableLambdaInstance(-612380066, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-51$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-612380066, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-51.<anonymous> (ScreenConfigurations.kt:392)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) MultiRideDetailsViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(MultiRideDetailsViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-52, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f100lambda52 = ComposableLambdaKt.composableLambdaInstance(1181805279, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-52$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1181805279, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-52.<anonymous> (ScreenConfigurations.kt:401)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) MultiRideTicketHistoryViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(MultiRideTicketHistoryViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-53, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f101lambda53 = ComposableLambdaKt.composableLambdaInstance(-1318976672, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-53$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1318976672, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-53.<anonymous> (ScreenConfigurations.kt:406)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) MultiRideRefillViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(MultiRideRefillViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-54, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f102lambda54 = ComposableLambdaKt.composableLambdaInstance(475208673, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-54$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(475208673, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-54.<anonymous> (ScreenConfigurations.kt:411)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) MultiRidePurchaseViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(MultiRidePurchaseViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-55, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f103lambda55 = ComposableLambdaKt.composableLambdaInstance(-2025573278, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-55$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2025573278, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-55.<anonymous> (ScreenConfigurations.kt:416)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) MultiRidePurchaseSummaryViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(MultiRidePurchaseSummaryViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-56, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f104lambda56 = ComposableLambdaKt.composableLambdaInstance(-231387933, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-56$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-231387933, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-56.<anonymous> (ScreenConfigurations.kt:422)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) MultiRidePurchaseReceiptViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(MultiRidePurchaseReceiptViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-57, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f105lambda57 = ComposableLambdaKt.composableLambdaInstance(1562797412, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-57$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1562797412, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-57.<anonymous> (ScreenConfigurations.kt:427)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) MultiRideAddCardViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(MultiRideAddCardViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-58, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f106lambda58 = ComposableLambdaKt.composableLambdaInstance(-937984539, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-58$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-937984539, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-58.<anonymous> (ScreenConfigurations.kt:433)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) BornholmCommuterDetailsViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(BornholmCommuterDetailsViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-59, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f107lambda59 = ComposableLambdaKt.composableLambdaInstance(856200806, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-59$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(856200806, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-59.<anonymous> (ScreenConfigurations.kt:439)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) OeresundCommuterDetailsViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(OeresundCommuterDetailsViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-60, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f109lambda60 = ComposableLambdaKt.composableLambdaInstance(-1644581145, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-60$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1644581145, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-60.<anonymous> (ScreenConfigurations.kt:445)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) BornholmCommuterTicketHistoryViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(BornholmCommuterTicketHistoryViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-61, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f110lambda61 = ComposableLambdaKt.composableLambdaInstance(-827209219, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-61$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-827209219, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-61.<anonymous> (ScreenConfigurations.kt:452)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) BornholmCommuterAddViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(BornholmCommuterAddViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-62, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f111lambda62 = ComposableLambdaKt.composableLambdaInstance(-1533805825, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-62$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1533805825, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-62.<anonymous> (ScreenConfigurations.kt:458)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) TransportationSelectorViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(TransportationSelectorViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-63, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f112lambda63 = ComposableLambdaKt.composableLambdaInstance(260379520, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-63$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(260379520, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-63.<anonymous> (ScreenConfigurations.kt:463)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) CargoDetailsViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(CargoDetailsViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-64, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f113lambda64 = ComposableLambdaKt.composableLambdaInstance(2054564865, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-64$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2054564865, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-64.<anonymous> (ScreenConfigurations.kt:468)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) PassengerCountSelectorViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(PassengerCountSelectorViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-65, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f114lambda65 = ComposableLambdaKt.composableLambdaInstance(-446217086, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-65$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-446217086, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-65.<anonymous> (ScreenConfigurations.kt:473)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) TrailerSelectorViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(TrailerSelectorViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-66, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f115lambda66 = ComposableLambdaKt.composableLambdaInstance(1347968259, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-66$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1347968259, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-66.<anonymous> (ScreenConfigurations.kt:478)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) TransportProductSelectorViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(TransportProductSelectorViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-67, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f116lambda67 = ComposableLambdaKt.composableLambdaInstance(641371653, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-67$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(641371653, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-67.<anonymous> (ScreenConfigurations.kt:484)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) SimpleChangeAddonsViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(SimpleChangeAddonsViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-68, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f117lambda68 = ComposableLambdaKt.composableLambdaInstance(-1859410298, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-68$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1859410298, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-68.<anonymous> (ScreenConfigurations.kt:489)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) SimpleChangeFoodViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(SimpleChangeFoodViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-69, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f118lambda69 = ComposableLambdaKt.composableLambdaInstance(-1042038372, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-69$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1042038372, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-69.<anonymous> (ScreenConfigurations.kt:494)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) SimpleChangeSummaryViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(SimpleChangeSummaryViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-70, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f120lambda70 = ComposableLambdaKt.composableLambdaInstance(752146973, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-70$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(752146973, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-70.<anonymous> (ScreenConfigurations.kt:500)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) SimpleChangeReceiptViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(SimpleChangeReceiptViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-71, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f121lambda71 = ComposableLambdaKt.composableLambdaInstance(-1748634978, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-71$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1748634978, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-71.<anonymous> (ScreenConfigurations.kt:505)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) PaymentViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(PaymentViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-72, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f122lambda72 = ComposableLambdaKt.composableLambdaInstance(45550367, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-72$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(45550367, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-72.<anonymous> (ScreenConfigurations.kt:510)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) EarlyCheckInProcessingViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(EarlyCheckInProcessingViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-73, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f123lambda73 = ComposableLambdaKt.composableLambdaInstance(1839735712, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-73$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1839735712, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-73.<anonymous> (ScreenConfigurations.kt:515)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) EarlyCheckInPassengerCreateViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(EarlyCheckInPassengerCreateViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-74, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f124lambda74 = ComposableLambdaKt.composableLambdaInstance(-661046239, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-74$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-661046239, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-74.<anonymous> (ScreenConfigurations.kt:522)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) EarlyCheckInPassengerEditViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(EarlyCheckInPassengerEditViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-75, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f125lambda75 = ComposableLambdaKt.composableLambdaInstance(1133139106, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-75$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1133139106, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-75.<anonymous> (ScreenConfigurations.kt:529)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) SimpleChangeAddonsViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(SimpleChangeAddonsViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-76, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f126lambda76 = ComposableLambdaKt.composableLambdaInstance(-1367642845, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-76$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1367642845, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-76.<anonymous> (ScreenConfigurations.kt:534)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) SimpleChangeFoodViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(SimpleChangeFoodViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-77, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f127lambda77 = ComposableLambdaKt.composableLambdaInstance(426542500, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-77$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(426542500, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-77.<anonymous> (ScreenConfigurations.kt:539)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) EarlyCheckInPassengerSelectorViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(EarlyCheckInPassengerSelectorViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-78, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f128lambda78 = ComposableLambdaKt.composableLambdaInstance(-2074239451, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-78$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2074239451, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-78.<anonymous> (ScreenConfigurations.kt:550)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) BookingSummaryViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(BookingSummaryViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-79, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f129lambda79 = ComposableLambdaKt.composableLambdaInstance(-1256867525, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-79$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1256867525, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-79.<anonymous> (ScreenConfigurations.kt:559)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) AddonsViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(AddonsViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-80, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f131lambda80 = ComposableLambdaKt.composableLambdaInstance(537317820, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-80$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(537317820, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-80.<anonymous> (ScreenConfigurations.kt:564)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) FerryFloorSectionViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(FerryFloorSectionViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-81, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f132lambda81 = ComposableLambdaKt.composableLambdaInstance(-1963464131, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-81$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1963464131, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-81.<anonymous> (ScreenConfigurations.kt:569)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) FerrySectionSeatsViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(FerrySectionSeatsViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-82, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f133lambda82 = ComposableLambdaKt.composableLambdaInstance(-169278786, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-82$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-169278786, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-82.<anonymous> (ScreenConfigurations.kt:578)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) FoodViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(FoodViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-83, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f134lambda83 = ComposableLambdaKt.composableLambdaInstance(1624906559, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-83$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1624906559, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-83.<anonymous> (ScreenConfigurations.kt:587)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) PassengersViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(PassengersViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-84, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f135lambda84 = ComposableLambdaKt.composableLambdaInstance(-875875392, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-84$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-875875392, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-84.<anonymous> (ScreenConfigurations.kt:596)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) PassengerCountViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(PassengerCountViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-85, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f136lambda85 = ComposableLambdaKt.composableLambdaInstance(-1582471998, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-85$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1582471998, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-85.<anonymous> (ScreenConfigurations.kt:602)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) CheckoutPassengerCreateViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(CheckoutPassengerCreateViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-86, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f137lambda86 = ComposableLambdaKt.composableLambdaInstance(211713347, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-86$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(211713347, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-86.<anonymous> (ScreenConfigurations.kt:607)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) CheckoutPassengerEditViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(CheckoutPassengerEditViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-87, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f138lambda87 = ComposableLambdaKt.composableLambdaInstance(2005898692, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-87$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2005898692, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-87.<anonymous> (ScreenConfigurations.kt:612)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) CheckoutDetailsViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(CheckoutDetailsViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-88, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f139lambda88 = ComposableLambdaKt.composableLambdaInstance(-1471696678, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-88$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1471696678, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-88.<anonymous> (ScreenConfigurations.kt:617)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) VehicleSelectorViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(VehicleSelectorViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-89, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f140lambda89 = ComposableLambdaKt.composableLambdaInstance(322488667, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-89$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(322488667, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-89.<anonymous> (ScreenConfigurations.kt:627)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) PaymentViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(PaymentViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-90, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f142lambda90 = ComposableLambdaKt.composableLambdaInstance(2116674012, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-90$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2116674012, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-90.<anonymous> (ScreenConfigurations.kt:633)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) ReceiptViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(ReceiptViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-91, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f143lambda91 = ComposableLambdaKt.composableLambdaInstance(-384107939, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-91$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-384107939, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-91.<anonymous> (ScreenConfigurations.kt:638)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) AddExistingTicketViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(AddExistingTicketViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-92, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f144lambda92 = ComposableLambdaKt.composableLambdaInstance(1410077406, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-92$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1410077406, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-92.<anonymous> (ScreenConfigurations.kt:643)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) BarcodeDetailsViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(BarcodeDetailsViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-93, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f145lambda93 = ComposableLambdaKt.composableLambdaInstance(-1090704545, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-93$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1090704545, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-93.<anonymous> (ScreenConfigurations.kt:648)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) FoodBarcodeDetailsViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(FoodBarcodeDetailsViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-94, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f146lambda94 = ComposableLambdaKt.composableLambdaInstance(703480800, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-94$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(703480800, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-94.<anonymous> (ScreenConfigurations.kt:653)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) LoungeBarcodeDetailsViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(LoungeBarcodeDetailsViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-95, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f147lambda95 = ComposableLambdaKt.composableLambdaInstance(-1797301151, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-95$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1797301151, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-95.<anonymous> (ScreenConfigurations.kt:658)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) SaleOnBoardBarcodeDetailsViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(SaleOnBoardBarcodeDetailsViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-96, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f148lambda96 = ComposableLambdaKt.composableLambdaInstance(-3115806, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-96$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-3115806, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-96.<anonymous> (ScreenConfigurations.kt:666)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) RefundReceiptViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(RefundReceiptViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-97, reason: not valid java name */
    private static Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> f149lambda97 = ComposableLambdaKt.composableLambdaInstance(95718226, false, new Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt$lambda-97$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(TypedDestinationSpec<?> typedDestinationSpec, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, Integer num) {
            invoke(typedDestinationSpec, dependenciesContainerBuilder, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(TypedDestinationSpec<?> destination, DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, int i5) {
            CreationExtras creationExtras;
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(95718226, i5, -1, "dk.molslinjen.ui.views.global.navigation.ComposableSingletons$ScreenConfigurationsKt.lambda-97.<anonymous> (ScreenConfigurations.kt:674)");
            }
            composer.startReplaceGroup(-32363301);
            if (Intrinsics.areEqual(dependenciesContainerBuilder.getDestination().getRoute(), destination.getRoute())) {
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) DeveloperInputComponentsViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ((DestinationDependenciesContainerImpl) dependenciesContainerBuilder).dependency(viewModel, Reflection.getOrCreateKotlinClass(DeveloperInputComponentsViewModel.class));
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: getLambda-1$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3282getLambda1$app_kombardoProd() {
        return f53lambda1;
    }

    /* renamed from: getLambda-10$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3283getLambda10$app_kombardoProd() {
        return f54lambda10;
    }

    /* renamed from: getLambda-11$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3284getLambda11$app_kombardoProd() {
        return f55lambda11;
    }

    /* renamed from: getLambda-12$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3285getLambda12$app_kombardoProd() {
        return f56lambda12;
    }

    /* renamed from: getLambda-13$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3286getLambda13$app_kombardoProd() {
        return f57lambda13;
    }

    /* renamed from: getLambda-14$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3287getLambda14$app_kombardoProd() {
        return f58lambda14;
    }

    /* renamed from: getLambda-15$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3288getLambda15$app_kombardoProd() {
        return f59lambda15;
    }

    /* renamed from: getLambda-16$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3289getLambda16$app_kombardoProd() {
        return f60lambda16;
    }

    /* renamed from: getLambda-17$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3290getLambda17$app_kombardoProd() {
        return f61lambda17;
    }

    /* renamed from: getLambda-18$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3291getLambda18$app_kombardoProd() {
        return f62lambda18;
    }

    /* renamed from: getLambda-19$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3292getLambda19$app_kombardoProd() {
        return f63lambda19;
    }

    /* renamed from: getLambda-2$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3293getLambda2$app_kombardoProd() {
        return f64lambda2;
    }

    /* renamed from: getLambda-20$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3294getLambda20$app_kombardoProd() {
        return f65lambda20;
    }

    /* renamed from: getLambda-21$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3295getLambda21$app_kombardoProd() {
        return f66lambda21;
    }

    /* renamed from: getLambda-22$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3296getLambda22$app_kombardoProd() {
        return f67lambda22;
    }

    /* renamed from: getLambda-23$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3297getLambda23$app_kombardoProd() {
        return f68lambda23;
    }

    /* renamed from: getLambda-24$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3298getLambda24$app_kombardoProd() {
        return f69lambda24;
    }

    /* renamed from: getLambda-25$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3299getLambda25$app_kombardoProd() {
        return f70lambda25;
    }

    /* renamed from: getLambda-26$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3300getLambda26$app_kombardoProd() {
        return f71lambda26;
    }

    /* renamed from: getLambda-27$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3301getLambda27$app_kombardoProd() {
        return f72lambda27;
    }

    /* renamed from: getLambda-28$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3302getLambda28$app_kombardoProd() {
        return f73lambda28;
    }

    /* renamed from: getLambda-29$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3303getLambda29$app_kombardoProd() {
        return f74lambda29;
    }

    /* renamed from: getLambda-3$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3304getLambda3$app_kombardoProd() {
        return f75lambda3;
    }

    /* renamed from: getLambda-30$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3305getLambda30$app_kombardoProd() {
        return f76lambda30;
    }

    /* renamed from: getLambda-31$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3306getLambda31$app_kombardoProd() {
        return f77lambda31;
    }

    /* renamed from: getLambda-32$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3307getLambda32$app_kombardoProd() {
        return f78lambda32;
    }

    /* renamed from: getLambda-33$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3308getLambda33$app_kombardoProd() {
        return f79lambda33;
    }

    /* renamed from: getLambda-34$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3309getLambda34$app_kombardoProd() {
        return f80lambda34;
    }

    /* renamed from: getLambda-35$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3310getLambda35$app_kombardoProd() {
        return f81lambda35;
    }

    /* renamed from: getLambda-36$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3311getLambda36$app_kombardoProd() {
        return f82lambda36;
    }

    /* renamed from: getLambda-37$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3312getLambda37$app_kombardoProd() {
        return f83lambda37;
    }

    /* renamed from: getLambda-38$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3313getLambda38$app_kombardoProd() {
        return f84lambda38;
    }

    /* renamed from: getLambda-39$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3314getLambda39$app_kombardoProd() {
        return f85lambda39;
    }

    /* renamed from: getLambda-4$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3315getLambda4$app_kombardoProd() {
        return f86lambda4;
    }

    /* renamed from: getLambda-40$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3316getLambda40$app_kombardoProd() {
        return f87lambda40;
    }

    /* renamed from: getLambda-41$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3317getLambda41$app_kombardoProd() {
        return f88lambda41;
    }

    /* renamed from: getLambda-42$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3318getLambda42$app_kombardoProd() {
        return f89lambda42;
    }

    /* renamed from: getLambda-43$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3319getLambda43$app_kombardoProd() {
        return f90lambda43;
    }

    /* renamed from: getLambda-44$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3320getLambda44$app_kombardoProd() {
        return f91lambda44;
    }

    /* renamed from: getLambda-45$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3321getLambda45$app_kombardoProd() {
        return f92lambda45;
    }

    /* renamed from: getLambda-46$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3322getLambda46$app_kombardoProd() {
        return f93lambda46;
    }

    /* renamed from: getLambda-47$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3323getLambda47$app_kombardoProd() {
        return f94lambda47;
    }

    /* renamed from: getLambda-48$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3324getLambda48$app_kombardoProd() {
        return f95lambda48;
    }

    /* renamed from: getLambda-49$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3325getLambda49$app_kombardoProd() {
        return f96lambda49;
    }

    /* renamed from: getLambda-5$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3326getLambda5$app_kombardoProd() {
        return f97lambda5;
    }

    /* renamed from: getLambda-50$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3327getLambda50$app_kombardoProd() {
        return f98lambda50;
    }

    /* renamed from: getLambda-51$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3328getLambda51$app_kombardoProd() {
        return f99lambda51;
    }

    /* renamed from: getLambda-52$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3329getLambda52$app_kombardoProd() {
        return f100lambda52;
    }

    /* renamed from: getLambda-53$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3330getLambda53$app_kombardoProd() {
        return f101lambda53;
    }

    /* renamed from: getLambda-54$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3331getLambda54$app_kombardoProd() {
        return f102lambda54;
    }

    /* renamed from: getLambda-55$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3332getLambda55$app_kombardoProd() {
        return f103lambda55;
    }

    /* renamed from: getLambda-56$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3333getLambda56$app_kombardoProd() {
        return f104lambda56;
    }

    /* renamed from: getLambda-57$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3334getLambda57$app_kombardoProd() {
        return f105lambda57;
    }

    /* renamed from: getLambda-58$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3335getLambda58$app_kombardoProd() {
        return f106lambda58;
    }

    /* renamed from: getLambda-59$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3336getLambda59$app_kombardoProd() {
        return f107lambda59;
    }

    /* renamed from: getLambda-6$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3337getLambda6$app_kombardoProd() {
        return f108lambda6;
    }

    /* renamed from: getLambda-60$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3338getLambda60$app_kombardoProd() {
        return f109lambda60;
    }

    /* renamed from: getLambda-61$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3339getLambda61$app_kombardoProd() {
        return f110lambda61;
    }

    /* renamed from: getLambda-62$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3340getLambda62$app_kombardoProd() {
        return f111lambda62;
    }

    /* renamed from: getLambda-63$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3341getLambda63$app_kombardoProd() {
        return f112lambda63;
    }

    /* renamed from: getLambda-64$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3342getLambda64$app_kombardoProd() {
        return f113lambda64;
    }

    /* renamed from: getLambda-65$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3343getLambda65$app_kombardoProd() {
        return f114lambda65;
    }

    /* renamed from: getLambda-66$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3344getLambda66$app_kombardoProd() {
        return f115lambda66;
    }

    /* renamed from: getLambda-67$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3345getLambda67$app_kombardoProd() {
        return f116lambda67;
    }

    /* renamed from: getLambda-68$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3346getLambda68$app_kombardoProd() {
        return f117lambda68;
    }

    /* renamed from: getLambda-69$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3347getLambda69$app_kombardoProd() {
        return f118lambda69;
    }

    /* renamed from: getLambda-7$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3348getLambda7$app_kombardoProd() {
        return f119lambda7;
    }

    /* renamed from: getLambda-70$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3349getLambda70$app_kombardoProd() {
        return f120lambda70;
    }

    /* renamed from: getLambda-71$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3350getLambda71$app_kombardoProd() {
        return f121lambda71;
    }

    /* renamed from: getLambda-72$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3351getLambda72$app_kombardoProd() {
        return f122lambda72;
    }

    /* renamed from: getLambda-73$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3352getLambda73$app_kombardoProd() {
        return f123lambda73;
    }

    /* renamed from: getLambda-74$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3353getLambda74$app_kombardoProd() {
        return f124lambda74;
    }

    /* renamed from: getLambda-75$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3354getLambda75$app_kombardoProd() {
        return f125lambda75;
    }

    /* renamed from: getLambda-76$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3355getLambda76$app_kombardoProd() {
        return f126lambda76;
    }

    /* renamed from: getLambda-77$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3356getLambda77$app_kombardoProd() {
        return f127lambda77;
    }

    /* renamed from: getLambda-78$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3357getLambda78$app_kombardoProd() {
        return f128lambda78;
    }

    /* renamed from: getLambda-79$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3358getLambda79$app_kombardoProd() {
        return f129lambda79;
    }

    /* renamed from: getLambda-8$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3359getLambda8$app_kombardoProd() {
        return f130lambda8;
    }

    /* renamed from: getLambda-80$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3360getLambda80$app_kombardoProd() {
        return f131lambda80;
    }

    /* renamed from: getLambda-81$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3361getLambda81$app_kombardoProd() {
        return f132lambda81;
    }

    /* renamed from: getLambda-82$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3362getLambda82$app_kombardoProd() {
        return f133lambda82;
    }

    /* renamed from: getLambda-83$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3363getLambda83$app_kombardoProd() {
        return f134lambda83;
    }

    /* renamed from: getLambda-84$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3364getLambda84$app_kombardoProd() {
        return f135lambda84;
    }

    /* renamed from: getLambda-85$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3365getLambda85$app_kombardoProd() {
        return f136lambda85;
    }

    /* renamed from: getLambda-86$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3366getLambda86$app_kombardoProd() {
        return f137lambda86;
    }

    /* renamed from: getLambda-87$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3367getLambda87$app_kombardoProd() {
        return f138lambda87;
    }

    /* renamed from: getLambda-88$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3368getLambda88$app_kombardoProd() {
        return f139lambda88;
    }

    /* renamed from: getLambda-89$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3369getLambda89$app_kombardoProd() {
        return f140lambda89;
    }

    /* renamed from: getLambda-9$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3370getLambda9$app_kombardoProd() {
        return f141lambda9;
    }

    /* renamed from: getLambda-90$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3371getLambda90$app_kombardoProd() {
        return f142lambda90;
    }

    /* renamed from: getLambda-91$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3372getLambda91$app_kombardoProd() {
        return f143lambda91;
    }

    /* renamed from: getLambda-92$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3373getLambda92$app_kombardoProd() {
        return f144lambda92;
    }

    /* renamed from: getLambda-93$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3374getLambda93$app_kombardoProd() {
        return f145lambda93;
    }

    /* renamed from: getLambda-94$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3375getLambda94$app_kombardoProd() {
        return f146lambda94;
    }

    /* renamed from: getLambda-95$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3376getLambda95$app_kombardoProd() {
        return f147lambda95;
    }

    /* renamed from: getLambda-96$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3377getLambda96$app_kombardoProd() {
        return f148lambda96;
    }

    /* renamed from: getLambda-97$app_kombardoProd, reason: not valid java name */
    public final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> m3378getLambda97$app_kombardoProd() {
        return f149lambda97;
    }
}
