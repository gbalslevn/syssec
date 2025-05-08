package dk.molslinjen;

import android.app.Activity;
import android.content.Context;
import androidx.appcompat.R$styleable;
import androidx.hilt.work.HiltWorkerFactory;
import androidx.hilt.work.WorkerAssistedFactory;
import androidx.hilt.work.WorkerFactoryModule_ProvideFactoryFactory;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import com.google.common.collect.ImmutableMap;
import com.sun.jna.Function;
import dagger.hilt.android.ActivityRetainedLifecycle;
import dagger.hilt.android.ViewModelLifecycle;
import dagger.hilt.android.internal.builders.ActivityComponentBuilder;
import dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder;
import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories_InternalFactoryFactory_Factory;
import dagger.hilt.android.internal.managers.ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory;
import dagger.hilt.android.internal.managers.SavedStateHandleHolder;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.android.internal.modules.ApplicationContextModule_ProvideContextFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.LazyClassKeyMap;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import dagger.internal.SingleCheck;
import dk.molslinjen.api.INetworkManager;
import dk.molslinjen.api.hilt.ApiClientModule_BindAccountApi$api_kombardoProdFactory;
import dk.molslinjen.api.hilt.ApiClientModule_BindAccountBookingApi$api_kombardoProdFactory;
import dk.molslinjen.api.hilt.ApiClientModule_BindAccountBrobizzApi$api_kombardoProdFactory;
import dk.molslinjen.api.hilt.ApiClientModule_BindAccountCreditCardsApi$api_kombardoProdFactory;
import dk.molslinjen.api.hilt.ApiClientModule_BindAccountMultiRideApiFactory;
import dk.molslinjen.api.hilt.ApiClientModule_BindAccountPassengersApi$api_kombardoProdFactory;
import dk.molslinjen.api.hilt.ApiClientModule_BindAccountVehiclesApi$api_kombardoProdFactory;
import dk.molslinjen.api.hilt.ApiClientModule_BindBookingApi$api_kombardoProdFactory;
import dk.molslinjen.api.hilt.ApiClientModule_BindCateringApi$api_kombardoProdFactory;
import dk.molslinjen.api.hilt.ApiClientModule_BindCommuteApiFactory;
import dk.molslinjen.api.hilt.ApiClientModule_BindConfigApi$api_kombardoProdFactory;
import dk.molslinjen.api.hilt.ApiClientModule_BindFaqApi$api_kombardoProdFactory;
import dk.molslinjen.api.hilt.ApiClientModule_BindForceUpdateApi$api_kombardoProdFactory;
import dk.molslinjen.api.hilt.ApiClientModule_BindGeoLocatorApi$api_kombardoProdFactory;
import dk.molslinjen.api.hilt.ApiClientModule_BindInfoApi$api_kombardoProdFactory;
import dk.molslinjen.api.hilt.ApiClientModule_BindMultiRideApiFactory;
import dk.molslinjen.api.hilt.ApiClientModule_BindNetworkManagerFactory;
import dk.molslinjen.api.hilt.ApiClientModule_BindNewslettersApi$api_kombardoProdFactory;
import dk.molslinjen.api.hilt.ApiClientModule_BindNotificationApi$api_kombardoProdFactory;
import dk.molslinjen.api.hilt.ApiClientModule_BindOeresundCommuterApiFactory;
import dk.molslinjen.api.hilt.ApiClientModule_BindPaymentApi$api_kombardoProdFactory;
import dk.molslinjen.api.hilt.ApiClientModule_BindPaymentTypesApi$api_kombardoProdFactory;
import dk.molslinjen.api.services.account.AccountApi;
import dk.molslinjen.api.services.account.AccountService;
import dk.molslinjen.api.services.account.booking.AccountBookingsApi;
import dk.molslinjen.api.services.account.booking.AccountBookingsService;
import dk.molslinjen.api.services.account.brobizz.AccountBrobizzApi;
import dk.molslinjen.api.services.account.brobizz.AccountBrobizzService;
import dk.molslinjen.api.services.account.creditcard.AccountCreditCardsApi;
import dk.molslinjen.api.services.account.creditcard.AccountCreditCardsService;
import dk.molslinjen.api.services.account.passenger.AccountPassengerService;
import dk.molslinjen.api.services.account.passenger.AccountPassengersApi;
import dk.molslinjen.api.services.account.vehicle.AccountVehicleService;
import dk.molslinjen.api.services.account.vehicle.AccountVehiclesApi;
import dk.molslinjen.api.services.booking.BookingApi;
import dk.molslinjen.api.services.booking.BookingService;
import dk.molslinjen.api.services.commuter.bornholm.BornholmCommuterApi;
import dk.molslinjen.api.services.commuter.bornholm.BornholmCommuterService;
import dk.molslinjen.api.services.commuter.oeresund.OeresundCommuterApi;
import dk.molslinjen.api.services.commuter.oeresund.OeresundCommuterService;
import dk.molslinjen.api.services.config.ConfigApi;
import dk.molslinjen.api.services.config.ConfigService;
import dk.molslinjen.api.services.faq.FaqApi;
import dk.molslinjen.api.services.faq.FaqService;
import dk.molslinjen.api.services.forceUpdate.ForceUpdateApi;
import dk.molslinjen.api.services.forceUpdate.ForceUpdateService;
import dk.molslinjen.api.services.geolocator.GeoLocatorApi;
import dk.molslinjen.api.services.geolocator.GeoLocatorService;
import dk.molslinjen.api.services.info.InfoApi;
import dk.molslinjen.api.services.info.InfoService;
import dk.molslinjen.api.services.multiRide.AccountMultiRideApi;
import dk.molslinjen.api.services.multiRide.AccountMultiRideService;
import dk.molslinjen.api.services.multiRide.MultiRideApi;
import dk.molslinjen.api.services.multiRide.MultiRideService;
import dk.molslinjen.api.services.newsletters.NewslettersApi;
import dk.molslinjen.api.services.newsletters.NewslettersService;
import dk.molslinjen.api.services.notifications.NotificationApi;
import dk.molslinjen.api.services.notifications.NotificationService;
import dk.molslinjen.api.services.payment.PaymentApi;
import dk.molslinjen.api.services.payment.PaymentService;
import dk.molslinjen.api.services.paymentTypes.PaymentTypesApi;
import dk.molslinjen.api.services.paymentTypes.PaymentTypesService;
import dk.molslinjen.api.services.saleOnBoard.SaleOnBoardApi;
import dk.molslinjen.api.services.saleOnBoard.SaleOnBoardService;
import dk.molslinjen.core.AppUpdater;
import dk.molslinjen.core.IAppUpdater;
import dk.molslinjen.core.hilt.AccountMergeModule_ProvidesAssetsMergerFactory;
import dk.molslinjen.core.hilt.HandlerProviderModule_BindAgillicHandlerFactory;
import dk.molslinjen.core.hilt.HandlerProviderModule_BindDepartureLowPriceHandlerFactory;
import dk.molslinjen.core.hilt.HandlerProviderModule_BindSelectSeatingHandlerFactory;
import dk.molslinjen.core.hilt.HelperProviderModule_BindPhoneNumberUtilFactory;
import dk.molslinjen.core.hilt.HelperProviderModule_BindSelectSeatingHelperFactory;
import dk.molslinjen.core.location.DirectionsManager;
import dk.molslinjen.core.location.IDirectionsManager;
import dk.molslinjen.core.location.ILocationManager;
import dk.molslinjen.core.location.LocationManager;
import dk.molslinjen.core.location.LocationManagerProvider;
import dk.molslinjen.core.migration.IMigrator;
import dk.molslinjen.core.migration.Migrator;
import dk.molslinjen.core.migration.oldApp.IOldAppDataMigrator;
import dk.molslinjen.core.migration.oldApp.OldAppDataMigrator;
import dk.molslinjen.core.navigation.CheckoutNavigator;
import dk.molslinjen.core.navigation.ICheckoutNavigator;
import dk.molslinjen.core.providers.IApiInfoProvider;
import dk.molslinjen.core.providers.IPaymentCallbackUrlProvider;
import dk.molslinjen.core.providers.PaymentCallbackUrlProvider;
import dk.molslinjen.core.providers.StringsProvider;
import dk.molslinjen.core.push.IPushHandler;
import dk.molslinjen.core.push.PushHandler;
import dk.molslinjen.core.push.PushHandlerProvider;
import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.core.snackbar.SnackbarService;
import dk.molslinjen.core.version.AppVersionProvider;
import dk.molslinjen.domain.analytics.AdjustTracker;
import dk.molslinjen.domain.analytics.AnalyticsStateTrackingHelper;
import dk.molslinjen.domain.analytics.AnalyticsTracker;
import dk.molslinjen.domain.analytics.AnalyticsTrackingHelper;
import dk.molslinjen.domain.analytics.FacebookTracker;
import dk.molslinjen.domain.analytics.IAdjustTracker;
import dk.molslinjen.domain.analytics.IAnalyticsStateTrackingHelper;
import dk.molslinjen.domain.analytics.IAnalyticsTracker;
import dk.molslinjen.domain.analytics.IAnalyticsTrackingHelper;
import dk.molslinjen.domain.analytics.IFacebookTracker;
import dk.molslinjen.domain.analytics.ILocationManagerProvider;
import dk.molslinjen.domain.localstorage.ConfigurationRepository;
import dk.molslinjen.domain.localstorage.agreements.commuter.bornholm.BornholmCommuterRepository;
import dk.molslinjen.domain.localstorage.agreements.commuter.oeresund.OeresundCommuterRepository;
import dk.molslinjen.domain.localstorage.agreements.multiride.MultiRideRepository;
import dk.molslinjen.domain.localstorage.bookings.BookingsRepository;
import dk.molslinjen.domain.localstorage.creditcard.CreditCardsRepository;
import dk.molslinjen.domain.localstorage.infoAlerts.InfoAlertRepository;
import dk.molslinjen.domain.localstorage.passengers.PassengerRepository;
import dk.molslinjen.domain.localstorage.saleOnBoardOrders.SaleOnBoardOrdersRepository;
import dk.molslinjen.domain.localstorage.user.UserRepository;
import dk.molslinjen.domain.localstorage.vehicle.VehicleRepository;
import dk.molslinjen.domain.managers.agreement.commuter.bornholm.BornholmCommuterManager;
import dk.molslinjen.domain.managers.agreement.commuter.bornholm.IBornholmCommuterManager;
import dk.molslinjen.domain.managers.agreement.commuter.oeresund.IOeresundCommuterManager;
import dk.molslinjen.domain.managers.agreement.commuter.oeresund.OeresundCommuterManager;
import dk.molslinjen.domain.managers.agreement.multiride.IMultiRideManager;
import dk.molslinjen.domain.managers.agreement.multiride.MultiRideManager;
import dk.molslinjen.domain.managers.agreement.multiride.purchase.IMultiRideCardCheckoutManager;
import dk.molslinjen.domain.managers.agreement.multiride.purchase.MultiRideCardCheckoutManager;
import dk.molslinjen.domain.managers.api.ApiProviderManager;
import dk.molslinjen.domain.managers.api.ForceUpdateManager;
import dk.molslinjen.domain.managers.api.IApiProviderManager;
import dk.molslinjen.domain.managers.api.IForceUpdateManager;
import dk.molslinjen.domain.managers.checkout.AddonHelper;
import dk.molslinjen.domain.managers.checkout.CheckoutManager;
import dk.molslinjen.domain.managers.checkout.CheckoutPassengerManager;
import dk.molslinjen.domain.managers.checkout.CurrencyManager;
import dk.molslinjen.domain.managers.checkout.EarlyCheckInPassengerManager;
import dk.molslinjen.domain.managers.checkout.EditManager;
import dk.molslinjen.domain.managers.checkout.ICheckoutManager;
import dk.molslinjen.domain.managers.checkout.ICheckoutPassengerManager;
import dk.molslinjen.domain.managers.checkout.ICurrencyManager;
import dk.molslinjen.domain.managers.checkout.IEarlyCheckInPassengerManager;
import dk.molslinjen.domain.managers.checkout.IEditManager;
import dk.molslinjen.domain.managers.checkout.IPaymentManager;
import dk.molslinjen.domain.managers.checkout.IReturnManager;
import dk.molslinjen.domain.managers.checkout.ISimpleChangeCheckoutManager;
import dk.molslinjen.domain.managers.checkout.PassengerSelectionHelper;
import dk.molslinjen.domain.managers.checkout.PaymentManager;
import dk.molslinjen.domain.managers.checkout.ReturnManager;
import dk.molslinjen.domain.managers.checkout.SimpleChangeCheckoutManager;
import dk.molslinjen.domain.managers.checkout.SummaryAddonHelper;
import dk.molslinjen.domain.managers.checkout.passengers.IPassengerMergeHelper;
import dk.molslinjen.domain.managers.checkout.passengers.PassengerMergeHelper;
import dk.molslinjen.domain.managers.company.CompanyViewHelper;
import dk.molslinjen.domain.managers.company.ICompanyViewHelper;
import dk.molslinjen.domain.managers.configuration.ConfigurationManager;
import dk.molslinjen.domain.managers.configuration.IConfigurationManager;
import dk.molslinjen.domain.managers.departure.DepartureManager;
import dk.molslinjen.domain.managers.departure.IDepartureManager;
import dk.molslinjen.domain.managers.faq.FaqManager;
import dk.molslinjen.domain.managers.faq.IFaqManager;
import dk.molslinjen.domain.managers.geo.GeoLocatorManager;
import dk.molslinjen.domain.managers.geo.IGeoLocatorManager;
import dk.molslinjen.domain.managers.infoAlerts.IInfoAlertManager;
import dk.molslinjen.domain.managers.infoAlerts.InfoAlertManager;
import dk.molslinjen.domain.managers.notification.IMarketingNotificationManager;
import dk.molslinjen.domain.managers.notification.INotificationManager;
import dk.molslinjen.domain.managers.notification.MarketingNotificationManager;
import dk.molslinjen.domain.managers.notification.NotificationManager;
import dk.molslinjen.domain.managers.route.IRouteManager;
import dk.molslinjen.domain.managers.route.RouteManager;
import dk.molslinjen.domain.managers.saleOnBoard.ISaleOnBoardCheckoutManager;
import dk.molslinjen.domain.managers.saleOnBoard.ISaleOnBoardDepartureManager;
import dk.molslinjen.domain.managers.saleOnBoard.ISaleOnBoardManager;
import dk.molslinjen.domain.managers.saleOnBoard.ISaleOnBoardRouteManager;
import dk.molslinjen.domain.managers.saleOnBoard.SaleOnBoardCheckoutManager;
import dk.molslinjen.domain.managers.saleOnBoard.SaleOnBoardDepartureManager;
import dk.molslinjen.domain.managers.saleOnBoard.SaleOnBoardManager;
import dk.molslinjen.domain.managers.saleOnBoard.SaleOnBoardRouteManager;
import dk.molslinjen.domain.managers.seating.ISelectSeatingManager;
import dk.molslinjen.domain.managers.seating.SelectSeatingManager;
import dk.molslinjen.domain.managers.site.ISiteManager;
import dk.molslinjen.domain.managers.site.SiteManager;
import dk.molslinjen.domain.managers.splitTest.ISplitTestManager;
import dk.molslinjen.domain.managers.splitTest.SplitTestManager;
import dk.molslinjen.domain.managers.ticket.ITicketsManager;
import dk.molslinjen.domain.managers.ticket.TicketsManager;
import dk.molslinjen.domain.managers.ticket.helper.BookingHeaderMapper;
import dk.molslinjen.domain.managers.ticket.helper.IBookingHeaderMapper;
import dk.molslinjen.domain.managers.user.IUserManager;
import dk.molslinjen.domain.managers.user.UserManager;
import dk.molslinjen.domain.managers.user.brobizz.IUserBrobizzManager;
import dk.molslinjen.domain.managers.user.brobizz.UserBrobizzManager;
import dk.molslinjen.domain.managers.user.creditcards.IUserCreditCardsManager;
import dk.molslinjen.domain.managers.user.creditcards.UserCreditCardsManager;
import dk.molslinjen.domain.managers.user.merge.IAssetsMerger;
import dk.molslinjen.domain.managers.user.newsletters.INewslettersManager;
import dk.molslinjen.domain.managers.user.newsletters.NewslettersManager;
import dk.molslinjen.domain.managers.user.passengers.IUserPassengerManager;
import dk.molslinjen.domain.managers.user.passengers.UserPassengerManager;
import dk.molslinjen.domain.managers.user.vehicles.IUserVehiclesManager;
import dk.molslinjen.domain.managers.user.vehicles.UserVehiclesManager;
import dk.molslinjen.domain.model.settings.ISettings;
import dk.molslinjen.domain.model.settings.Settings;
import dk.molslinjen.domain.providers.IPushHandlerProvider;
import dk.molslinjen.domain.providers.IStringsProvider;
import dk.molslinjen.ui.views.global.bottombar.BottomBarManager;
import dk.molslinjen.ui.views.global.bottombar.BottomBarViewModel;
import dk.molslinjen.ui.views.global.bottombar.BottomBarViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.global.bottombar.BottomBarViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.global.bottombar.BottomBarViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.global.bottombar.IBottomBarManager;
import dk.molslinjen.ui.views.global.navigation.MainActivity;
import dk.molslinjen.ui.views.global.navigation.MainActivity_MembersInjector;
import dk.molslinjen.ui.views.global.topbar.ITopBarManager;
import dk.molslinjen.ui.views.global.topbar.TopBarManager;
import dk.molslinjen.ui.views.global.topbar.TopBarViewModel;
import dk.molslinjen.ui.views.global.topbar.TopBarViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.global.topbar.TopBarViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.global.topbar.TopBarViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.reusable.input.nationality.NationalitySelectionViewModel;
import dk.molslinjen.ui.views.reusable.input.nationality.NationalitySelectionViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.reusable.input.nationality.NationalitySelectionViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.reusable.input.nationality.NationalitySelectionViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.reusable.input.phoneNumberCode.PhoneNumberCodeSelectionViewModel;
import dk.molslinjen.ui.views.reusable.input.phoneNumberCode.PhoneNumberCodeSelectionViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.reusable.input.phoneNumberCode.PhoneNumberCodeSelectionViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.reusable.input.phoneNumberCode.PhoneNumberCodeSelectionViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.agreements.AgreementsViewModel;
import dk.molslinjen.ui.views.screens.agreements.AgreementsViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.agreements.AgreementsViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.agreements.AgreementsViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.agreements.commuter.CommuterAddAgreementsViewModel;
import dk.molslinjen.ui.views.screens.agreements.commuter.CommuterAddAgreementsViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.agreements.commuter.CommuterAddAgreementsViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.agreements.commuter.CommuterAddAgreementsViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.agreements.commuter.CommuterOverviewViewModel;
import dk.molslinjen.ui.views.screens.agreements.commuter.CommuterOverviewViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.agreements.commuter.CommuterOverviewViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.agreements.commuter.CommuterOverviewViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.agreements.commuter.bornholm.add.BornholmCommuterAddViewModel;
import dk.molslinjen.ui.views.screens.agreements.commuter.bornholm.add.BornholmCommuterAddViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.agreements.commuter.bornholm.add.BornholmCommuterAddViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.agreements.commuter.bornholm.add.BornholmCommuterAddViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.agreements.commuter.bornholm.details.BornholmCommuterDetailsViewModel;
import dk.molslinjen.ui.views.screens.agreements.commuter.bornholm.details.BornholmCommuterDetailsViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.agreements.commuter.bornholm.details.BornholmCommuterDetailsViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.agreements.commuter.bornholm.details.BornholmCommuterDetailsViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.agreements.commuter.bornholm.history.BornholmCommuterTicketHistoryViewModel;
import dk.molslinjen.ui.views.screens.agreements.commuter.bornholm.history.BornholmCommuterTicketHistoryViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.agreements.commuter.bornholm.history.BornholmCommuterTicketHistoryViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.agreements.commuter.bornholm.history.BornholmCommuterTicketHistoryViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.agreements.commuter.oeresund.details.OeresundCommuterDetailsViewModel;
import dk.molslinjen.ui.views.screens.agreements.commuter.oeresund.details.OeresundCommuterDetailsViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.agreements.commuter.oeresund.details.OeresundCommuterDetailsViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.agreements.commuter.oeresund.details.OeresundCommuterDetailsViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.agreements.multiride.add.MultiRideAddCardViewModel;
import dk.molslinjen.ui.views.screens.agreements.multiride.add.MultiRideAddCardViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.agreements.multiride.add.MultiRideAddCardViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.agreements.multiride.add.MultiRideAddCardViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.agreements.multiride.details.MultiRideDetailsViewModel;
import dk.molslinjen.ui.views.screens.agreements.multiride.details.MultiRideDetailsViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.agreements.multiride.details.MultiRideDetailsViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.agreements.multiride.details.MultiRideDetailsViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.agreements.multiride.details.history.MultiRideTicketHistoryViewModel;
import dk.molslinjen.ui.views.screens.agreements.multiride.details.history.MultiRideTicketHistoryViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.agreements.multiride.details.history.MultiRideTicketHistoryViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.agreements.multiride.details.history.MultiRideTicketHistoryViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.agreements.multiride.overview.MultiRideOverviewViewModel;
import dk.molslinjen.ui.views.screens.agreements.multiride.overview.MultiRideOverviewViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.agreements.multiride.overview.MultiRideOverviewViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.agreements.multiride.overview.MultiRideOverviewViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.agreements.multiride.purchase.MultiRidePurchaseReceiptViewModel;
import dk.molslinjen.ui.views.screens.agreements.multiride.purchase.MultiRidePurchaseReceiptViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.agreements.multiride.purchase.MultiRidePurchaseReceiptViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.agreements.multiride.purchase.MultiRidePurchaseReceiptViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.agreements.multiride.purchase.MultiRidePurchaseSummaryViewModel;
import dk.molslinjen.ui.views.screens.agreements.multiride.purchase.MultiRidePurchaseSummaryViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.agreements.multiride.purchase.MultiRidePurchaseSummaryViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.agreements.multiride.purchase.MultiRidePurchaseSummaryViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.agreements.multiride.purchase.MultiRidePurchaseViewModel;
import dk.molslinjen.ui.views.screens.agreements.multiride.purchase.MultiRidePurchaseViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.agreements.multiride.purchase.MultiRidePurchaseViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.agreements.multiride.purchase.MultiRidePurchaseViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.agreements.multiride.refill.MultiRideRefillViewModel;
import dk.molslinjen.ui.views.screens.agreements.multiride.refill.MultiRideRefillViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.agreements.multiride.refill.MultiRideRefillViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.agreements.multiride.refill.MultiRideRefillViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.booking.addons.AddonsViewModel;
import dk.molslinjen.ui.views.screens.booking.addons.AddonsViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.booking.addons.AddonsViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.booking.addons.AddonsViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.booking.addons.seating.FerryFloorSectionViewModel;
import dk.molslinjen.ui.views.screens.booking.addons.seating.FerryFloorSectionViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.booking.addons.seating.FerryFloorSectionViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.booking.addons.seating.FerryFloorSectionViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.booking.addons.seating.select.FerrySectionSeatsViewModel;
import dk.molslinjen.ui.views.screens.booking.addons.seating.select.FerrySectionSeatsViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.booking.addons.seating.select.FerrySectionSeatsViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.booking.addons.seating.select.FerrySectionSeatsViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.booking.checkout.CheckoutViewModel;
import dk.molslinjen.ui.views.screens.booking.checkout.CheckoutViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.booking.checkout.CheckoutViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.booking.checkout.CheckoutViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.booking.departures.DeparturesViewModel;
import dk.molslinjen.ui.views.screens.booking.departures.DeparturesViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.booking.departures.DeparturesViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.booking.departures.DeparturesViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.booking.departures.calendar.CalendarViewModel;
import dk.molslinjen.ui.views.screens.booking.departures.calendar.CalendarViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.booking.departures.calendar.CalendarViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.booking.departures.calendar.CalendarViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.booking.departures.infoAlert.InfoAlertViewModel;
import dk.molslinjen.ui.views.screens.booking.departures.infoAlert.InfoAlertViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.booking.departures.infoAlert.InfoAlertViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.booking.departures.infoAlert.InfoAlertViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.booking.departures.selectPassengers.PassengerCountSelectorViewModel;
import dk.molslinjen.ui.views.screens.booking.departures.selectPassengers.PassengerCountSelectorViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.booking.departures.selectPassengers.PassengerCountSelectorViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.booking.departures.selectPassengers.PassengerCountSelectorViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.booking.departures.selectTrailers.TrailerSelectorViewModel;
import dk.molslinjen.ui.views.screens.booking.departures.selectTrailers.TrailerSelectorViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.booking.departures.selectTrailers.TrailerSelectorViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.booking.departures.selectTrailers.TrailerSelectorViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.booking.departures.selectTransportation.CargoDetailsViewModel;
import dk.molslinjen.ui.views.screens.booking.departures.selectTransportation.CargoDetailsViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.booking.departures.selectTransportation.CargoDetailsViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.booking.departures.selectTransportation.CargoDetailsViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.booking.departures.selectTransportation.TransportationSelectorViewModel;
import dk.molslinjen.ui.views.screens.booking.departures.selectTransportation.TransportationSelectorViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.booking.departures.selectTransportation.TransportationSelectorViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.booking.departures.selectTransportation.TransportationSelectorViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.booking.departures.selectTransportationProducts.TransportProductSelectorViewModel;
import dk.molslinjen.ui.views.screens.booking.departures.selectTransportationProducts.TransportProductSelectorViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.booking.departures.selectTransportationProducts.TransportProductSelectorViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.booking.departures.selectTransportationProducts.TransportProductSelectorViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.booking.food.FoodViewModel;
import dk.molslinjen.ui.views.screens.booking.food.FoodViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.booking.food.FoodViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.booking.food.FoodViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.booking.passengers.CreateYourSelfAsPassengerViewModel;
import dk.molslinjen.ui.views.screens.booking.passengers.CreateYourSelfAsPassengerViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.booking.passengers.CreateYourSelfAsPassengerViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.booking.passengers.CreateYourSelfAsPassengerViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.booking.passengers.PassengersViewModel;
import dk.molslinjen.ui.views.screens.booking.passengers.PassengersViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.booking.passengers.PassengersViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.booking.passengers.PassengersViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.booking.passengers.count.PassengerCountViewModel;
import dk.molslinjen.ui.views.screens.booking.passengers.count.PassengerCountViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.booking.passengers.count.PassengerCountViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.booking.passengers.count.PassengerCountViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.booking.passengers.create.CheckoutPassengerCreateViewModel;
import dk.molslinjen.ui.views.screens.booking.passengers.create.CheckoutPassengerCreateViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.booking.passengers.create.CheckoutPassengerCreateViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.booking.passengers.create.CheckoutPassengerCreateViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.booking.passengers.create.EarlyCheckInPassengerCreateViewModel;
import dk.molslinjen.ui.views.screens.booking.passengers.create.EarlyCheckInPassengerCreateViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.booking.passengers.create.EarlyCheckInPassengerCreateViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.booking.passengers.create.EarlyCheckInPassengerCreateViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.booking.passengers.edit.CheckoutPassengerEditViewModel;
import dk.molslinjen.ui.views.screens.booking.passengers.edit.CheckoutPassengerEditViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.booking.passengers.edit.CheckoutPassengerEditViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.booking.passengers.edit.CheckoutPassengerEditViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.booking.passengers.edit.EarlyCheckInPassengerEditViewModel;
import dk.molslinjen.ui.views.screens.booking.passengers.edit.EarlyCheckInPassengerEditViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.booking.passengers.edit.EarlyCheckInPassengerEditViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.booking.passengers.edit.EarlyCheckInPassengerEditViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.booking.payment.PaymentViewModel;
import dk.molslinjen.ui.views.screens.booking.payment.PaymentViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.booking.payment.PaymentViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.booking.payment.PaymentViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.booking.receipt.ReceiptViewModel;
import dk.molslinjen.ui.views.screens.booking.receipt.ReceiptViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.booking.receipt.ReceiptViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.booking.receipt.ReceiptViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.booking.shared.CheckoutDetailsViewModel;
import dk.molslinjen.ui.views.screens.booking.shared.CheckoutDetailsViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.booking.shared.CheckoutDetailsViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.booking.shared.CheckoutDetailsViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.booking.simpleChange.SimpleChangeSummaryViewModel;
import dk.molslinjen.ui.views.screens.booking.simpleChange.SimpleChangeSummaryViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.booking.simpleChange.SimpleChangeSummaryViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.booking.simpleChange.SimpleChangeSummaryViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.booking.simpleChange.addons.SimpleChangeAddonsViewModel;
import dk.molslinjen.ui.views.screens.booking.simpleChange.addons.SimpleChangeAddonsViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.booking.simpleChange.addons.SimpleChangeAddonsViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.booking.simpleChange.addons.SimpleChangeAddonsViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.booking.simpleChange.food.SimpleChangeFoodViewModel;
import dk.molslinjen.ui.views.screens.booking.simpleChange.food.SimpleChangeFoodViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.booking.simpleChange.food.SimpleChangeFoodViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.booking.simpleChange.food.SimpleChangeFoodViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.booking.simpleChange.receipt.SimpleChangeReceiptViewModel;
import dk.molslinjen.ui.views.screens.booking.simpleChange.receipt.SimpleChangeReceiptViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.booking.simpleChange.receipt.SimpleChangeReceiptViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.booking.simpleChange.receipt.SimpleChangeReceiptViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.booking.summary.BookingSummaryViewModel;
import dk.molslinjen.ui.views.screens.booking.summary.BookingSummaryViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.booking.summary.BookingSummaryViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.booking.summary.BookingSummaryViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.booking.ticketType.TicketTypeKombardoViewModel;
import dk.molslinjen.ui.views.screens.booking.ticketType.TicketTypeKombardoViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.booking.ticketType.TicketTypeKombardoViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.booking.ticketType.TicketTypeKombardoViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.booking.ticketType.TicketTypeMolslinjenViewModel;
import dk.molslinjen.ui.views.screens.booking.ticketType.TicketTypeMolslinjenViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.booking.ticketType.TicketTypeMolslinjenViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.booking.ticketType.TicketTypeMolslinjenViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.deeplink.DeepLinkViewModel;
import dk.molslinjen.ui.views.screens.deeplink.DeepLinkViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.deeplink.DeepLinkViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.deeplink.DeepLinkViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.developer.DeveloperViewModel;
import dk.molslinjen.ui.views.screens.developer.DeveloperViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.developer.DeveloperViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.developer.DeveloperViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.developer.inputs.DeveloperInputComponentsViewModel;
import dk.molslinjen.ui.views.screens.developer.inputs.DeveloperInputComponentsViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.developer.inputs.DeveloperInputComponentsViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.developer.inputs.DeveloperInputComponentsViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.main.MainViewModel;
import dk.molslinjen.ui.views.screens.main.MainViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.main.MainViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.main.MainViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.main.ManuelForceUpdateViewModel;
import dk.molslinjen.ui.views.screens.main.ManuelForceUpdateViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.main.ManuelForceUpdateViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.main.ManuelForceUpdateViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.main.MigrationErrorViewModel;
import dk.molslinjen.ui.views.screens.main.MigrationErrorViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.main.MigrationErrorViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.main.MigrationErrorViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.main.push.PushDialogViewModel;
import dk.molslinjen.ui.views.screens.main.push.PushDialogViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.main.push.PushDialogViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.main.push.PushDialogViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.onboarding.location.OnboardingLocationViewModel;
import dk.molslinjen.ui.views.screens.onboarding.location.OnboardingLocationViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.onboarding.location.OnboardingLocationViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.onboarding.location.OnboardingLocationViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.onboarding.navigator.OnboardingNavigator;
import dk.molslinjen.ui.views.screens.onboarding.notifications.OnboardingMarketingNotificationsViewModel;
import dk.molslinjen.ui.views.screens.onboarding.notifications.OnboardingMarketingNotificationsViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.onboarding.notifications.OnboardingMarketingNotificationsViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.onboarding.notifications.OnboardingMarketingNotificationsViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.onboarding.notifications.OnboardingNotificationViewModel;
import dk.molslinjen.ui.views.screens.onboarding.notifications.OnboardingNotificationViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.onboarding.notifications.OnboardingNotificationViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.onboarding.notifications.OnboardingNotificationViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.onboarding.selectRoute.OnboardingSelectRouteViewModel;
import dk.molslinjen.ui.views.screens.onboarding.selectRoute.OnboardingSelectRouteViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.onboarding.selectRoute.OnboardingSelectRouteViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.onboarding.selectRoute.OnboardingSelectRouteViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.profile.ProfileViewModel;
import dk.molslinjen.ui.views.screens.profile.ProfileViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.profile.ProfileViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.profile.ProfileViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.profile.authentication.activation.AccountActivationViewModel;
import dk.molslinjen.ui.views.screens.profile.authentication.activation.AccountActivationViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.profile.authentication.activation.AccountActivationViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.profile.authentication.activation.AccountActivationViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.profile.authentication.login.LoginViewModel;
import dk.molslinjen.ui.views.screens.profile.authentication.login.LoginViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.profile.authentication.login.LoginViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.profile.authentication.login.LoginViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.profile.authentication.password.forgot.ForgotPasswordViewModel;
import dk.molslinjen.ui.views.screens.profile.authentication.password.forgot.ForgotPasswordViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.profile.authentication.password.forgot.ForgotPasswordViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.profile.authentication.password.forgot.ForgotPasswordViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.profile.authentication.password.reset.ResetPasswordViewModel;
import dk.molslinjen.ui.views.screens.profile.authentication.password.reset.ResetPasswordViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.profile.authentication.password.reset.ResetPasswordViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.profile.authentication.password.reset.ResetPasswordViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.profile.authentication.register.SignupViewModel;
import dk.molslinjen.ui.views.screens.profile.authentication.register.SignupViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.profile.authentication.register.SignupViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.profile.authentication.register.SignupViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.profile.brobizz.ProfileBrobizzViewModel;
import dk.molslinjen.ui.views.screens.profile.brobizz.ProfileBrobizzViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.profile.brobizz.ProfileBrobizzViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.profile.brobizz.ProfileBrobizzViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.profile.brobizz.register.ProfileBrobizzRegisterViewModel;
import dk.molslinjen.ui.views.screens.profile.brobizz.register.ProfileBrobizzRegisterViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.profile.brobizz.register.ProfileBrobizzRegisterViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.profile.brobizz.register.ProfileBrobizzRegisterViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.profile.contact.ContactScreenViewModel;
import dk.molslinjen.ui.views.screens.profile.contact.ContactScreenViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.profile.contact.ContactScreenViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.profile.contact.ContactScreenViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.profile.creditcards.ProfileCreditCardsViewModel;
import dk.molslinjen.ui.views.screens.profile.creditcards.ProfileCreditCardsViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.profile.creditcards.ProfileCreditCardsViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.profile.creditcards.ProfileCreditCardsViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.profile.currencies.CurrenciesViewModel;
import dk.molslinjen.ui.views.screens.profile.currencies.CurrenciesViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.profile.currencies.CurrenciesViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.profile.currencies.CurrenciesViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.profile.edit.ProfileEditViewModel;
import dk.molslinjen.ui.views.screens.profile.edit.ProfileEditViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.profile.edit.ProfileEditViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.profile.edit.ProfileEditViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.profile.edit.changePassword.ChangePasswordViewModel;
import dk.molslinjen.ui.views.screens.profile.edit.changePassword.ChangePasswordViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.profile.edit.changePassword.ChangePasswordViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.profile.edit.changePassword.ChangePasswordViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.profile.faq.FaqViewModel;
import dk.molslinjen.ui.views.screens.profile.faq.FaqViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.profile.faq.FaqViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.profile.faq.FaqViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.profile.faq.subject.FaqSubjectViewModel;
import dk.molslinjen.ui.views.screens.profile.faq.subject.FaqSubjectViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.profile.faq.subject.FaqSubjectViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.profile.faq.subject.FaqSubjectViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.profile.merge.AssetsMergeViewModel;
import dk.molslinjen.ui.views.screens.profile.merge.AssetsMergeViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.profile.merge.AssetsMergeViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.profile.merge.AssetsMergeViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.profile.newsletters.ProfileNewslettersViewModel;
import dk.molslinjen.ui.views.screens.profile.newsletters.ProfileNewslettersViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.profile.newsletters.ProfileNewslettersViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.profile.newsletters.ProfileNewslettersViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.profile.passengers.ProfilePassengersViewModel;
import dk.molslinjen.ui.views.screens.profile.passengers.ProfilePassengersViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.profile.passengers.ProfilePassengersViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.profile.passengers.ProfilePassengersViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.profile.passengers.edit.ProfilePassengerEditViewModel;
import dk.molslinjen.ui.views.screens.profile.passengers.edit.ProfilePassengerEditViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.profile.passengers.edit.ProfilePassengerEditViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.profile.passengers.edit.ProfilePassengerEditViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.profile.passengers.register.ProfilePassengersRegisterViewModel;
import dk.molslinjen.ui.views.screens.profile.passengers.register.ProfilePassengersRegisterViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.profile.passengers.register.ProfilePassengersRegisterViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.profile.passengers.register.ProfilePassengersRegisterViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.profile.permissions.PermissionsViewModel;
import dk.molslinjen.ui.views.screens.profile.permissions.PermissionsViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.profile.permissions.PermissionsViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.profile.permissions.PermissionsViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.profile.vehicles.ProfileVehiclesViewModel;
import dk.molslinjen.ui.views.screens.profile.vehicles.ProfileVehiclesViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.profile.vehicles.ProfileVehiclesViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.profile.vehicles.ProfileVehiclesViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.profile.vehicles.edit.ProfileVehiclesEditViewModel;
import dk.molslinjen.ui.views.screens.profile.vehicles.edit.ProfileVehiclesEditViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.profile.vehicles.edit.ProfileVehiclesEditViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.profile.vehicles.edit.ProfileVehiclesEditViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.profile.vehicles.register.ProfileVehiclesRegisterViewModel;
import dk.molslinjen.ui.views.screens.profile.vehicles.register.ProfileVehiclesRegisterViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.profile.vehicles.register.ProfileVehiclesRegisterViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.profile.vehicles.register.ProfileVehiclesRegisterViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.profile.vehicles.selector.VehicleSelectorViewModel;
import dk.molslinjen.ui.views.screens.profile.vehicles.selector.VehicleSelectorViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.profile.vehicles.selector.VehicleSelectorViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.profile.vehicles.selector.VehicleSelectorViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.saleOnBoard.SaleOnBoardViewModel;
import dk.molslinjen.ui.views.screens.saleOnBoard.SaleOnBoardViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.saleOnBoard.SaleOnBoardViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.saleOnBoard.SaleOnBoardViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.saleOnBoard.basket.SaleOnBoardBasketViewModel;
import dk.molslinjen.ui.views.screens.saleOnBoard.basket.SaleOnBoardBasketViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.saleOnBoard.basket.SaleOnBoardBasketViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.saleOnBoard.basket.SaleOnBoardBasketViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.saleOnBoard.foodListScreen.SaleOnBoardFoodListViewModel;
import dk.molslinjen.ui.views.screens.saleOnBoard.foodListScreen.SaleOnBoardFoodListViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.saleOnBoard.foodListScreen.SaleOnBoardFoodListViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.saleOnBoard.foodListScreen.SaleOnBoardFoodListViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.saleOnBoard.orderDetails.SaleOnBoardOrderDetailsViewModel;
import dk.molslinjen.ui.views.screens.saleOnBoard.orderDetails.SaleOnBoardOrderDetailsViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.saleOnBoard.orderDetails.SaleOnBoardOrderDetailsViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.saleOnBoard.orderDetails.SaleOnBoardOrderDetailsViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.saleOnBoard.orderHistory.SaleOnBoardOrderHistoryViewModel;
import dk.molslinjen.ui.views.screens.saleOnBoard.orderHistory.SaleOnBoardOrderHistoryViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.saleOnBoard.orderHistory.SaleOnBoardOrderHistoryViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.saleOnBoard.orderHistory.SaleOnBoardOrderHistoryViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.saleOnBoard.produdctDetails.SaleOnBoardProductDetailsViewModel;
import dk.molslinjen.ui.views.screens.saleOnBoard.produdctDetails.SaleOnBoardProductDetailsViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.saleOnBoard.produdctDetails.SaleOnBoardProductDetailsViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.saleOnBoard.produdctDetails.SaleOnBoardProductDetailsViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.saleOnBoard.receipt.SaleOnBoardReceiptViewModel;
import dk.molslinjen.ui.views.screens.saleOnBoard.receipt.SaleOnBoardReceiptViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.saleOnBoard.receipt.SaleOnBoardReceiptViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.saleOnBoard.receipt.SaleOnBoardReceiptViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.saleOnBoard.selectDeparture.SaleOnBoardDepartureSelectorViewModel;
import dk.molslinjen.ui.views.screens.saleOnBoard.selectDeparture.SaleOnBoardDepartureSelectorViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.saleOnBoard.selectDeparture.SaleOnBoardDepartureSelectorViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.saleOnBoard.selectDeparture.SaleOnBoardDepartureSelectorViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.tickets.TicketsViewModel;
import dk.molslinjen.ui.views.screens.tickets.TicketsViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.tickets.TicketsViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.tickets.TicketsViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.tickets.addExisting.AddExistingTicketViewModel;
import dk.molslinjen.ui.views.screens.tickets.addExisting.AddExistingTicketViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.tickets.addExisting.AddExistingTicketViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.tickets.addExisting.AddExistingTicketViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.tickets.barcodeDetails.BarcodeDetailsViewModel;
import dk.molslinjen.ui.views.screens.tickets.barcodeDetails.BarcodeDetailsViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.tickets.barcodeDetails.BarcodeDetailsViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.tickets.barcodeDetails.BarcodeDetailsViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.tickets.barcodeDetails.FoodBarcodeDetailsViewModel;
import dk.molslinjen.ui.views.screens.tickets.barcodeDetails.FoodBarcodeDetailsViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.tickets.barcodeDetails.FoodBarcodeDetailsViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.tickets.barcodeDetails.FoodBarcodeDetailsViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.tickets.barcodeDetails.LoungeBarcodeDetailsViewModel;
import dk.molslinjen.ui.views.screens.tickets.barcodeDetails.LoungeBarcodeDetailsViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.tickets.barcodeDetails.LoungeBarcodeDetailsViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.tickets.barcodeDetails.LoungeBarcodeDetailsViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.tickets.barcodeDetails.SaleOnBoardBarcodeDetailsViewModel;
import dk.molslinjen.ui.views.screens.tickets.barcodeDetails.SaleOnBoardBarcodeDetailsViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.tickets.barcodeDetails.SaleOnBoardBarcodeDetailsViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.tickets.barcodeDetails.SaleOnBoardBarcodeDetailsViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.tickets.details.TicketDetailsViewModel;
import dk.molslinjen.ui.views.screens.tickets.details.TicketDetailsViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.tickets.details.TicketDetailsViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.tickets.details.TicketDetailsViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.EarlyCheckInViewModel;
import dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.EarlyCheckInViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.EarlyCheckInViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.EarlyCheckInViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.passengerSelector.EarlyCheckInPassengerSelectorViewModel;
import dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.passengerSelector.EarlyCheckInPassengerSelectorViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.passengerSelector.EarlyCheckInPassengerSelectorViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.passengerSelector.EarlyCheckInPassengerSelectorViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.processing.EarlyCheckInProcessingViewModel;
import dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.processing.EarlyCheckInProcessingViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.processing.EarlyCheckInProcessingViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.processing.EarlyCheckInProcessingViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.tickets.history.TicketHistoryViewModel;
import dk.molslinjen.ui.views.screens.tickets.history.TicketHistoryViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.tickets.history.TicketHistoryViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.tickets.history.TicketHistoryViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.screens.tickets.refund.RefundReceiptViewModel;
import dk.molslinjen.ui.views.screens.tickets.refund.RefundReceiptViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.screens.tickets.refund.RefundReceiptViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.screens.tickets.refund.RefundReceiptViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.shared.error.ErrorViewModel;
import dk.molslinjen.ui.views.shared.error.ErrorViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.shared.error.ErrorViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.shared.error.ErrorViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.shared.routeSelector.RouteSelectorKombardoViewModel;
import dk.molslinjen.ui.views.shared.routeSelector.RouteSelectorKombardoViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.shared.routeSelector.RouteSelectorKombardoViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.shared.routeSelector.RouteSelectorKombardoViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.shared.routeSelector.RouteSelectorMolslinjenViewModel;
import dk.molslinjen.ui.views.shared.routeSelector.RouteSelectorMolslinjenViewModel_HiltModules$KeyModule;
import dk.molslinjen.ui.views.shared.routeSelector.RouteSelectorMolslinjenViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import dk.molslinjen.ui.views.shared.routeSelector.RouteSelectorMolslinjenViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import dk.molslinjen.ui.views.shared.routeSelector.helpers.IRouteLocationHelper;
import dk.molslinjen.ui.views.shared.routeSelector.helpers.RouteLocationHelper;
import dk.molslinjen.workers.ConfigUpdateWorker;
import io.michaelrocks.libphonenumber.android.PhoneNumberUtil;
import java.util.Map;
import uniffi.molslinjen_shared.SelectSeatingHelperInterface;

/* loaded from: classes2.dex */
public abstract class DaggerApp_HiltComponents_SingletonC {

    /* loaded from: classes2.dex */
    private static final class ActivityCBuilder implements ActivityComponentBuilder {
        private Activity activity;
        private final ActivityRetainedCImpl activityRetainedCImpl;
        private final SingletonCImpl singletonCImpl;

        private ActivityCBuilder(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl) {
            this.singletonCImpl = singletonCImpl;
            this.activityRetainedCImpl = activityRetainedCImpl;
        }

        @Override // dagger.hilt.android.internal.builders.ActivityComponentBuilder
        public ActivityCBuilder activity(Activity activity) {
            this.activity = (Activity) Preconditions.checkNotNull(activity);
            return this;
        }

        @Override // dagger.hilt.android.internal.builders.ActivityComponentBuilder
        public App_HiltComponents$ActivityC build() {
            Preconditions.checkBuilderRequirement(this.activity, Activity.class);
            return new ActivityCImpl(this.singletonCImpl, this.activityRetainedCImpl, this.activity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class ActivityCImpl extends App_HiltComponents$ActivityC {
        private final ActivityCImpl activityCImpl;
        private final ActivityRetainedCImpl activityRetainedCImpl;
        private final SingletonCImpl singletonCImpl;

        private MainActivity injectMainActivity2(MainActivity mainActivity) {
            MainActivity_MembersInjector.injectAppUpdater(mainActivity, (IAppUpdater) this.singletonCImpl.bindAppUpdaterProvider.get());
            MainActivity_MembersInjector.injectPaymentManager(mainActivity, (IPaymentManager) this.singletonCImpl.bindPaymentManagerProvider.get());
            MainActivity_MembersInjector.injectTicketsManager(mainActivity, (ITicketsManager) this.singletonCImpl.bindTicketsManagerProvider.get());
            MainActivity_MembersInjector.injectMultiRideManager(mainActivity, (IMultiRideManager) this.singletonCImpl.bindMultiRideManagerProvider.get());
            MainActivity_MembersInjector.injectUserManager(mainActivity, (IUserManager) this.singletonCImpl.bindUserManagerProvider.get());
            MainActivity_MembersInjector.injectPushHandler(mainActivity, (IPushHandler) this.singletonCImpl.bindPushHandlerProvider.get());
            MainActivity_MembersInjector.injectNotificationManager(mainActivity, (INotificationManager) this.singletonCImpl.bindNotificationManagerProvider.get());
            MainActivity_MembersInjector.injectPushHandlerProvider(mainActivity, (IPushHandlerProvider) this.singletonCImpl.bindPushHandlerProvider2.get());
            MainActivity_MembersInjector.injectCompanyViewHelper(mainActivity, (ICompanyViewHelper) this.singletonCImpl.bindCompanyViewHelperProvider.get());
            MainActivity_MembersInjector.injectInfoAlertsManager(mainActivity, (IInfoAlertManager) this.singletonCImpl.bindInfoAlertManagerProvider.get());
            MainActivity_MembersInjector.injectAdjustTracker(mainActivity, (IAdjustTracker) this.singletonCImpl.bindAdjustTrackerProvider.get());
            MainActivity_MembersInjector.injectSettings(mainActivity, (ISettings) this.singletonCImpl.bindSettingsProvider.get());
            MainActivity_MembersInjector.injectAnalyticsTracker(mainActivity, (IAnalyticsTracker) this.singletonCImpl.bindAnalyticsTrackerProvider.get());
            MainActivity_MembersInjector.injectPaymentCallbackUrlProvider(mainActivity, (IPaymentCallbackUrlProvider) this.singletonCImpl.bindPaymentCallbackUrlProvider.get());
            MainActivity_MembersInjector.injectMarketingNotificationManager(mainActivity, (IMarketingNotificationManager) this.singletonCImpl.bindMarketingNotificationManagerProvider.get());
            return mainActivity;
        }

        @Override // dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories.ActivityEntryPoint
        public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
            return DefaultViewModelFactories_InternalFactoryFactory_Factory.newInstance(getViewModelKeys(), new ViewModelCBuilder(this.singletonCImpl, this.activityRetainedCImpl));
        }

        @Override // dagger.hilt.android.internal.lifecycle.HiltViewModelFactory.ActivityCreatorEntryPoint
        public ViewModelComponentBuilder getViewModelComponentBuilder() {
            return new ViewModelCBuilder(this.singletonCImpl, this.activityRetainedCImpl);
        }

        @Override // dagger.hilt.android.internal.lifecycle.HiltViewModelFactory.ActivityCreatorEntryPoint
        public Map<Class<?>, Boolean> getViewModelKeys() {
            return LazyClassKeyMap.of(ImmutableMap.builderWithExpectedSize(108).put(AccountActivationViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(AccountActivationViewModel_HiltModules$KeyModule.provide())).put(AddExistingTicketViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(AddExistingTicketViewModel_HiltModules$KeyModule.provide())).put(AddonsViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(AddonsViewModel_HiltModules$KeyModule.provide())).put(AgreementsViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(AgreementsViewModel_HiltModules$KeyModule.provide())).put(AssetsMergeViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(AssetsMergeViewModel_HiltModules$KeyModule.provide())).put(BarcodeDetailsViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(BarcodeDetailsViewModel_HiltModules$KeyModule.provide())).put(BookingSummaryViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(BookingSummaryViewModel_HiltModules$KeyModule.provide())).put(BornholmCommuterAddViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(BornholmCommuterAddViewModel_HiltModules$KeyModule.provide())).put(BornholmCommuterDetailsViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(BornholmCommuterDetailsViewModel_HiltModules$KeyModule.provide())).put(BornholmCommuterTicketHistoryViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(BornholmCommuterTicketHistoryViewModel_HiltModules$KeyModule.provide())).put(BottomBarViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(BottomBarViewModel_HiltModules$KeyModule.provide())).put(CalendarViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(CalendarViewModel_HiltModules$KeyModule.provide())).put(CargoDetailsViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(CargoDetailsViewModel_HiltModules$KeyModule.provide())).put(ChangePasswordViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(ChangePasswordViewModel_HiltModules$KeyModule.provide())).put(CheckoutDetailsViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(CheckoutDetailsViewModel_HiltModules$KeyModule.provide())).put(CheckoutPassengerCreateViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(CheckoutPassengerCreateViewModel_HiltModules$KeyModule.provide())).put(CheckoutPassengerEditViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(CheckoutPassengerEditViewModel_HiltModules$KeyModule.provide())).put(CheckoutViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(CheckoutViewModel_HiltModules$KeyModule.provide())).put(CommuterAddAgreementsViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(CommuterAddAgreementsViewModel_HiltModules$KeyModule.provide())).put(CommuterOverviewViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(CommuterOverviewViewModel_HiltModules$KeyModule.provide())).put(ContactScreenViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(ContactScreenViewModel_HiltModules$KeyModule.provide())).put(CreateYourSelfAsPassengerViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(CreateYourSelfAsPassengerViewModel_HiltModules$KeyModule.provide())).put(CurrenciesViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(CurrenciesViewModel_HiltModules$KeyModule.provide())).put(DeepLinkViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(DeepLinkViewModel_HiltModules$KeyModule.provide())).put(DeparturesViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(DeparturesViewModel_HiltModules$KeyModule.provide())).put(DeveloperInputComponentsViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(DeveloperInputComponentsViewModel_HiltModules$KeyModule.provide())).put(DeveloperViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(DeveloperViewModel_HiltModules$KeyModule.provide())).put(EarlyCheckInPassengerCreateViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(EarlyCheckInPassengerCreateViewModel_HiltModules$KeyModule.provide())).put(EarlyCheckInPassengerEditViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(EarlyCheckInPassengerEditViewModel_HiltModules$KeyModule.provide())).put(EarlyCheckInPassengerSelectorViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(EarlyCheckInPassengerSelectorViewModel_HiltModules$KeyModule.provide())).put(EarlyCheckInProcessingViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(EarlyCheckInProcessingViewModel_HiltModules$KeyModule.provide())).put(EarlyCheckInViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(EarlyCheckInViewModel_HiltModules$KeyModule.provide())).put(ErrorViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(ErrorViewModel_HiltModules$KeyModule.provide())).put(FaqSubjectViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(FaqSubjectViewModel_HiltModules$KeyModule.provide())).put(FaqViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(FaqViewModel_HiltModules$KeyModule.provide())).put(FerryFloorSectionViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(FerryFloorSectionViewModel_HiltModules$KeyModule.provide())).put(FerrySectionSeatsViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(FerrySectionSeatsViewModel_HiltModules$KeyModule.provide())).put(FoodBarcodeDetailsViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(FoodBarcodeDetailsViewModel_HiltModules$KeyModule.provide())).put(FoodViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(FoodViewModel_HiltModules$KeyModule.provide())).put(ForgotPasswordViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(ForgotPasswordViewModel_HiltModules$KeyModule.provide())).put(InfoAlertViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(InfoAlertViewModel_HiltModules$KeyModule.provide())).put(LoginViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(LoginViewModel_HiltModules$KeyModule.provide())).put(LoungeBarcodeDetailsViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(LoungeBarcodeDetailsViewModel_HiltModules$KeyModule.provide())).put(MainViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(MainViewModel_HiltModules$KeyModule.provide())).put(ManuelForceUpdateViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(ManuelForceUpdateViewModel_HiltModules$KeyModule.provide())).put(MigrationErrorViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(MigrationErrorViewModel_HiltModules$KeyModule.provide())).put(MultiRideAddCardViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(MultiRideAddCardViewModel_HiltModules$KeyModule.provide())).put(MultiRideDetailsViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(MultiRideDetailsViewModel_HiltModules$KeyModule.provide())).put(MultiRideOverviewViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(MultiRideOverviewViewModel_HiltModules$KeyModule.provide())).put(MultiRidePurchaseReceiptViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(MultiRidePurchaseReceiptViewModel_HiltModules$KeyModule.provide())).put(MultiRidePurchaseSummaryViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(MultiRidePurchaseSummaryViewModel_HiltModules$KeyModule.provide())).put(MultiRidePurchaseViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(MultiRidePurchaseViewModel_HiltModules$KeyModule.provide())).put(MultiRideRefillViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(MultiRideRefillViewModel_HiltModules$KeyModule.provide())).put(MultiRideTicketHistoryViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(MultiRideTicketHistoryViewModel_HiltModules$KeyModule.provide())).put(NationalitySelectionViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(NationalitySelectionViewModel_HiltModules$KeyModule.provide())).put(OeresundCommuterDetailsViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(OeresundCommuterDetailsViewModel_HiltModules$KeyModule.provide())).put(OnboardingLocationViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(OnboardingLocationViewModel_HiltModules$KeyModule.provide())).put(OnboardingMarketingNotificationsViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(OnboardingMarketingNotificationsViewModel_HiltModules$KeyModule.provide())).put(OnboardingNotificationViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(OnboardingNotificationViewModel_HiltModules$KeyModule.provide())).put(OnboardingSelectRouteViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(OnboardingSelectRouteViewModel_HiltModules$KeyModule.provide())).put(PassengerCountSelectorViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(PassengerCountSelectorViewModel_HiltModules$KeyModule.provide())).put(PassengerCountViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(PassengerCountViewModel_HiltModules$KeyModule.provide())).put(PassengersViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(PassengersViewModel_HiltModules$KeyModule.provide())).put(PaymentViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(PaymentViewModel_HiltModules$KeyModule.provide())).put(PermissionsViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(PermissionsViewModel_HiltModules$KeyModule.provide())).put(PhoneNumberCodeSelectionViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(PhoneNumberCodeSelectionViewModel_HiltModules$KeyModule.provide())).put(ProfileBrobizzRegisterViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(ProfileBrobizzRegisterViewModel_HiltModules$KeyModule.provide())).put(ProfileBrobizzViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(ProfileBrobizzViewModel_HiltModules$KeyModule.provide())).put(ProfileCreditCardsViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(ProfileCreditCardsViewModel_HiltModules$KeyModule.provide())).put(ProfileEditViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(ProfileEditViewModel_HiltModules$KeyModule.provide())).put(ProfileNewslettersViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(ProfileNewslettersViewModel_HiltModules$KeyModule.provide())).put(ProfilePassengerEditViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(ProfilePassengerEditViewModel_HiltModules$KeyModule.provide())).put(ProfilePassengersRegisterViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(ProfilePassengersRegisterViewModel_HiltModules$KeyModule.provide())).put(ProfilePassengersViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(ProfilePassengersViewModel_HiltModules$KeyModule.provide())).put(ProfileVehiclesEditViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(ProfileVehiclesEditViewModel_HiltModules$KeyModule.provide())).put(ProfileVehiclesRegisterViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(ProfileVehiclesRegisterViewModel_HiltModules$KeyModule.provide())).put(ProfileVehiclesViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(ProfileVehiclesViewModel_HiltModules$KeyModule.provide())).put(ProfileViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(ProfileViewModel_HiltModules$KeyModule.provide())).put(PushDialogViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(PushDialogViewModel_HiltModules$KeyModule.provide())).put(ReceiptViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(ReceiptViewModel_HiltModules$KeyModule.provide())).put(RefundReceiptViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(RefundReceiptViewModel_HiltModules$KeyModule.provide())).put(ResetPasswordViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(ResetPasswordViewModel_HiltModules$KeyModule.provide())).put(RouteSelectorKombardoViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(RouteSelectorKombardoViewModel_HiltModules$KeyModule.provide())).put(RouteSelectorMolslinjenViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(RouteSelectorMolslinjenViewModel_HiltModules$KeyModule.provide())).put(SaleOnBoardBarcodeDetailsViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(SaleOnBoardBarcodeDetailsViewModel_HiltModules$KeyModule.provide())).put(SaleOnBoardBasketViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(SaleOnBoardBasketViewModel_HiltModules$KeyModule.provide())).put(SaleOnBoardDepartureSelectorViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(SaleOnBoardDepartureSelectorViewModel_HiltModules$KeyModule.provide())).put(SaleOnBoardFoodListViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(SaleOnBoardFoodListViewModel_HiltModules$KeyModule.provide())).put(SaleOnBoardOrderDetailsViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(SaleOnBoardOrderDetailsViewModel_HiltModules$KeyModule.provide())).put(SaleOnBoardOrderHistoryViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(SaleOnBoardOrderHistoryViewModel_HiltModules$KeyModule.provide())).put(SaleOnBoardProductDetailsViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(SaleOnBoardProductDetailsViewModel_HiltModules$KeyModule.provide())).put(SaleOnBoardReceiptViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(SaleOnBoardReceiptViewModel_HiltModules$KeyModule.provide())).put(SaleOnBoardViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(SaleOnBoardViewModel_HiltModules$KeyModule.provide())).put(SignupViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(SignupViewModel_HiltModules$KeyModule.provide())).put(SimpleChangeAddonsViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(SimpleChangeAddonsViewModel_HiltModules$KeyModule.provide())).put(SimpleChangeFoodViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(SimpleChangeFoodViewModel_HiltModules$KeyModule.provide())).put(SimpleChangeReceiptViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(SimpleChangeReceiptViewModel_HiltModules$KeyModule.provide())).put(SimpleChangeSummaryViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(SimpleChangeSummaryViewModel_HiltModules$KeyModule.provide())).put(TicketDetailsViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(TicketDetailsViewModel_HiltModules$KeyModule.provide())).put(TicketHistoryViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(TicketHistoryViewModel_HiltModules$KeyModule.provide())).put(TicketTypeKombardoViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(TicketTypeKombardoViewModel_HiltModules$KeyModule.provide())).put(TicketTypeMolslinjenViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(TicketTypeMolslinjenViewModel_HiltModules$KeyModule.provide())).put(TicketsViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(TicketsViewModel_HiltModules$KeyModule.provide())).put(TopBarViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(TopBarViewModel_HiltModules$KeyModule.provide())).put(TrailerSelectorViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(TrailerSelectorViewModel_HiltModules$KeyModule.provide())).put(TransportProductSelectorViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(TransportProductSelectorViewModel_HiltModules$KeyModule.provide())).put(TransportationSelectorViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(TransportationSelectorViewModel_HiltModules$KeyModule.provide())).put(VehicleSelectorViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(VehicleSelectorViewModel_HiltModules$KeyModule.provide())).build());
        }

        @Override // dk.molslinjen.ui.views.global.navigation.MainActivity_GeneratedInjector
        public void injectMainActivity(MainActivity mainActivity) {
            injectMainActivity2(mainActivity);
        }

        private ActivityCImpl(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl, Activity activity) {
            this.activityCImpl = this;
            this.singletonCImpl = singletonCImpl;
            this.activityRetainedCImpl = activityRetainedCImpl;
        }
    }

    /* loaded from: classes2.dex */
    private static final class ActivityRetainedCBuilder implements ActivityRetainedComponentBuilder {
        private SavedStateHandleHolder savedStateHandleHolder;
        private final SingletonCImpl singletonCImpl;

        private ActivityRetainedCBuilder(SingletonCImpl singletonCImpl) {
            this.singletonCImpl = singletonCImpl;
        }

        @Override // dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder
        public App_HiltComponents$ActivityRetainedC build() {
            Preconditions.checkBuilderRequirement(this.savedStateHandleHolder, SavedStateHandleHolder.class);
            return new ActivityRetainedCImpl(this.singletonCImpl, this.savedStateHandleHolder);
        }

        @Override // dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder
        public ActivityRetainedCBuilder savedStateHandleHolder(SavedStateHandleHolder savedStateHandleHolder) {
            this.savedStateHandleHolder = (SavedStateHandleHolder) Preconditions.checkNotNull(savedStateHandleHolder);
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class ActivityRetainedCImpl extends App_HiltComponents$ActivityRetainedC {
        private final ActivityRetainedCImpl activityRetainedCImpl;
        private Provider<ActivityRetainedLifecycle> provideActivityRetainedLifecycleProvider;
        private final SingletonCImpl singletonCImpl;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes2.dex */
        public static final class SwitchingProvider<T> implements Provider<T> {
            private final ActivityRetainedCImpl activityRetainedCImpl;
            private final int id;
            private final SingletonCImpl singletonCImpl;

            SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl, int i5) {
                this.singletonCImpl = singletonCImpl;
                this.activityRetainedCImpl = activityRetainedCImpl;
                this.id = i5;
            }

            @Override // javax.inject.Provider
            public T get() {
                if (this.id == 0) {
                    return (T) ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory.provideActivityRetainedLifecycle();
                }
                throw new AssertionError(this.id);
            }
        }

        private void initialize(SavedStateHandleHolder savedStateHandleHolder) {
            this.provideActivityRetainedLifecycleProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, 0));
        }

        @Override // dagger.hilt.android.internal.managers.ActivityComponentManager.ActivityComponentBuilderEntryPoint
        public ActivityComponentBuilder activityComponentBuilder() {
            return new ActivityCBuilder(this.singletonCImpl, this.activityRetainedCImpl);
        }

        @Override // dagger.hilt.android.internal.managers.ActivityRetainedComponentManager.ActivityRetainedLifecycleEntryPoint
        public ActivityRetainedLifecycle getActivityRetainedLifecycle() {
            return this.provideActivityRetainedLifecycleProvider.get();
        }

        private ActivityRetainedCImpl(SingletonCImpl singletonCImpl, SavedStateHandleHolder savedStateHandleHolder) {
            this.activityRetainedCImpl = this;
            this.singletonCImpl = singletonCImpl;
            initialize(savedStateHandleHolder);
        }
    }

    /* loaded from: classes2.dex */
    public static final class Builder {
        private ApplicationContextModule applicationContextModule;

        public Builder applicationContextModule(ApplicationContextModule applicationContextModule) {
            this.applicationContextModule = (ApplicationContextModule) Preconditions.checkNotNull(applicationContextModule);
            return this;
        }

        public App_HiltComponents$SingletonC build() {
            Preconditions.checkBuilderRequirement(this.applicationContextModule, ApplicationContextModule.class);
            return new SingletonCImpl(this.applicationContextModule);
        }

        private Builder() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class SingletonCImpl extends App_HiltComponents$SingletonC {
        private Provider<AdjustTracker> adjustTrackerProvider;
        private Provider<AnalyticsStateTrackingHelper> analyticsStateTrackingHelperProvider;
        private Provider<AnalyticsTracker> analyticsTrackerProvider;
        private Provider<AnalyticsTrackingHelper> analyticsTrackingHelperProvider;
        private Provider<ApiProviderManager> apiProviderManagerProvider;
        private Provider<AppUpdater> appUpdaterProvider;
        private Provider<AppVersionProvider> appVersionProvider;
        private final ApplicationContextModule applicationContextModule;
        private Provider<AccountApi> bindAccountApi$api_kombardoProdProvider;
        private Provider<AccountBookingsApi> bindAccountBookingApi$api_kombardoProdProvider;
        private Provider<AccountBrobizzApi> bindAccountBrobizzApi$api_kombardoProdProvider;
        private Provider<AccountCreditCardsApi> bindAccountCreditCardsApi$api_kombardoProdProvider;
        private Provider<AccountMultiRideApi> bindAccountMultiRideApiProvider;
        private Provider<AccountPassengersApi> bindAccountPassengersApi$api_kombardoProdProvider;
        private Provider<AccountVehiclesApi> bindAccountVehiclesApi$api_kombardoProdProvider;
        private Provider<IAdjustTracker> bindAdjustTrackerProvider;
        private Provider<IAnalyticsStateTrackingHelper> bindAnalyticsStateTrackingHelperProvider;
        private Provider<IAnalyticsTracker> bindAnalyticsTrackerProvider;
        private Provider<IAnalyticsTrackingHelper> bindAnalyticsTrackingHelperProvider;
        private Provider<IApiProviderManager> bindApiProviderManagerProvider;
        private Provider<IAppUpdater> bindAppUpdaterProvider;
        private Provider<BookingApi> bindBookingApi$api_kombardoProdProvider;
        private Provider<IBookingHeaderMapper> bindBookingHeaderMapperProvider;
        private Provider<IBornholmCommuterManager> bindBornholmCommuterManagerProvider;
        private Provider<IBottomBarManager> bindBottomBarManagerProvider;
        private Provider<SaleOnBoardApi> bindCateringApi$api_kombardoProdProvider;
        private Provider<ICheckoutManager> bindCheckoutManagerProvider;
        private Provider<ICheckoutNavigator> bindCheckoutNavigatorProvider;
        private Provider<ICheckoutPassengerManager> bindCheckoutPassengerManagerProvider;
        private Provider<BornholmCommuterApi> bindCommuteApiProvider;
        private Provider<ICompanyViewHelper> bindCompanyViewHelperProvider;
        private Provider<ConfigApi> bindConfigApi$api_kombardoProdProvider;
        private Provider<IConfigurationManager> bindConfigurationManagerProvider;
        private Provider<ICurrencyManager> bindCurrencyManagerProvider;
        private Provider<IDepartureManager> bindDepartureManagerProvider;
        private Provider<IDirectionsManager> bindDirectionsManagerProvider;
        private Provider<IEarlyCheckInPassengerManager> bindEarlyCheckInPassengerManagerProvider;
        private Provider<IEditManager> bindEditManagerProvider;
        private Provider<IFacebookTracker> bindFacebookTrackerProvider;
        private Provider<FaqApi> bindFaqApi$api_kombardoProdProvider;
        private Provider<IFaqManager> bindFaqManagerProvider;
        private Provider<ForceUpdateApi> bindForceUpdateApi$api_kombardoProdProvider;
        private Provider<IForceUpdateManager> bindForceUpdateManagerProvider;
        private Provider<GeoLocatorApi> bindGeoLocatorApi$api_kombardoProdProvider;
        private Provider<IGeoLocatorManager> bindGeoLocatorManagerProvider;
        private Provider<IInfoAlertManager> bindInfoAlertManagerProvider;
        private Provider<InfoApi> bindInfoApi$api_kombardoProdProvider;
        private Provider<ILocationManager> bindLocationManagerProvider;
        private Provider<ILocationManagerProvider> bindLocationManagerProvider2;
        private Provider<IMarketingNotificationManager> bindMarketingNotificationManagerProvider;
        private Provider<IMigrator> bindMigratorProvider;
        private Provider<MultiRideApi> bindMultiRideApiProvider;
        private Provider<IMultiRideCardCheckoutManager> bindMultiRideCardCheckoutManagerProvider;
        private Provider<IMultiRideManager> bindMultiRideManagerProvider;
        private Provider<INetworkManager> bindNetworkManagerProvider;
        private Provider<NewslettersApi> bindNewslettersApi$api_kombardoProdProvider;
        private Provider<INewslettersManager> bindNewslettersManagerProvider;
        private Provider<NotificationApi> bindNotificationApi$api_kombardoProdProvider;
        private Provider<INotificationManager> bindNotificationManagerProvider;
        private Provider<OeresundCommuterApi> bindOeresundCommuterApiProvider;
        private Provider<IOeresundCommuterManager> bindOeresundCommuterManagerProvider;
        private Provider<IOldAppDataMigrator> bindOldAppMigratorProvider;
        private Provider<IPassengerMergeHelper> bindPassengerMergeHelperProvider;
        private Provider<PaymentApi> bindPaymentApi$api_kombardoProdProvider;
        private Provider<IPaymentCallbackUrlProvider> bindPaymentCallbackUrlProvider;
        private Provider<IPaymentManager> bindPaymentManagerProvider;
        private Provider<PaymentTypesApi> bindPaymentTypesApi$api_kombardoProdProvider;
        private Provider<PhoneNumberUtil> bindPhoneNumberUtilProvider;
        private Provider<IPushHandler> bindPushHandlerProvider;
        private Provider<IPushHandlerProvider> bindPushHandlerProvider2;
        private Provider<IReturnManager> bindReturnManagerProvider;
        private Provider<IRouteLocationHelper> bindRouteLocationHelperProvider;
        private Provider<IRouteManager> bindRouteManagerProvider;
        private Provider<ISaleOnBoardCheckoutManager> bindSaleOnBoardCheckoutManagerProvider;
        private Provider<ISaleOnBoardDepartureManager> bindSaleOnBoardDepartureManagerProvider;
        private Provider<ISaleOnBoardManager> bindSaleOnBoardManagerProvider;
        private Provider<ISaleOnBoardRouteManager> bindSaleOnBoardRouteManagerProvider;
        private Provider<ISelectSeatingManager> bindSeatReservationManagerProvider;
        private Provider<SelectSeatingHelperInterface> bindSelectSeatingHelperProvider;
        private Provider<ISettings> bindSettingsProvider;
        private Provider<ISimpleChangeCheckoutManager> bindSimpleChangeCheckoutManagerProvider;
        private Provider<ISiteManager> bindSiteManagerProvider;
        private Provider<ISnackbarService> bindSnackbarServiceProvider;
        private Provider<ISplitTestManager> bindSplitTestManagerProvider;
        private Provider<IStringsProvider> bindStringsProvider;
        private Provider<ITicketsManager> bindTicketsManagerProvider;
        private Provider<ITopBarManager> bindTopBarManagerProvider;
        private Provider<IUserBrobizzManager> bindUserBrobizzManagerProvider;
        private Provider<IUserCreditCardsManager> bindUserCreditCardsManagerProvider;
        private Provider<IUserManager> bindUserManagerProvider;
        private Provider<IUserPassengerManager> bindUserPassengerManagerProvider;
        private Provider<IUserVehiclesManager> bindUserVehiclesManagerProvider;
        private Provider<BookingHeaderMapper> bookingHeaderMapperProvider;
        private Provider<BornholmCommuterManager> bornholmCommuterManagerProvider;
        private Provider<BottomBarManager> bottomBarManagerProvider;
        private Provider<CheckoutManager> checkoutManagerProvider;
        private Provider<CheckoutNavigator> checkoutNavigatorProvider;
        private Provider<CheckoutPassengerManager> checkoutPassengerManagerProvider;
        private Provider<CompanyViewHelper> companyViewHelperProvider;
        private Provider<Object> configUpdateWorker_AssistedFactoryProvider;
        private Provider<ConfigurationManager> configurationManagerProvider;
        private Provider<CurrencyManager> currencyManagerProvider;
        private Provider<DepartureManager> departureManagerProvider;
        private Provider<DirectionsManager> directionsManagerProvider;
        private Provider<EarlyCheckInPassengerManager> earlyCheckInPassengerManagerProvider;
        private Provider<EditManager> editManagerProvider;
        private Provider<FacebookTracker> facebookTrackerProvider;
        private Provider<FaqManager> faqManagerProvider;
        private Provider<ForceUpdateManager> forceUpdateManagerProvider;
        private Provider<GeoLocatorManager> geoLocatorManagerProvider;
        private Provider<InfoAlertManager> infoAlertManagerProvider;
        private Provider<LocationManager> locationManagerProvider;
        private Provider<LocationManagerProvider> locationManagerProvider2;
        private Provider<MarketingNotificationManager> marketingNotificationManagerProvider;
        private Provider<Migrator> migratorProvider;
        private Provider<MultiRideCardCheckoutManager> multiRideCardCheckoutManagerProvider;
        private Provider<MultiRideManager> multiRideManagerProvider;
        private Provider<NewslettersManager> newslettersManagerProvider;
        private Provider<NotificationManager> notificationManagerProvider;
        private Provider<OeresundCommuterManager> oeresundCommuterManagerProvider;
        private Provider<OldAppDataMigrator> oldAppDataMigratorProvider;
        private Provider<PassengerMergeHelper> passengerMergeHelperProvider;
        private Provider<PaymentCallbackUrlProvider> paymentCallbackUrlProvider;
        private Provider<PaymentManager> paymentManagerProvider;
        private Provider<IAssetsMerger[]> providesAssetsMergerProvider;
        private Provider<PushHandler> pushHandlerProvider;
        private Provider<PushHandlerProvider> pushHandlerProvider2;
        private Provider<ReturnManager> returnManagerProvider;
        private Provider<RouteLocationHelper> routeLocationHelperProvider;
        private Provider<RouteManager> routeManagerProvider;
        private Provider<SaleOnBoardCheckoutManager> saleOnBoardCheckoutManagerProvider;
        private Provider<SaleOnBoardDepartureManager> saleOnBoardDepartureManagerProvider;
        private Provider<SaleOnBoardManager> saleOnBoardManagerProvider;
        private Provider<SaleOnBoardRouteManager> saleOnBoardRouteManagerProvider;
        private Provider<SelectSeatingManager> selectSeatingManagerProvider;
        private Provider<Settings> settingsProvider;
        private Provider<SimpleChangeCheckoutManager> simpleChangeCheckoutManagerProvider;
        private final SingletonCImpl singletonCImpl;
        private Provider<SiteManager> siteManagerProvider;
        private Provider<SnackbarService> snackbarServiceProvider;
        private Provider<SplitTestManager> splitTestManagerProvider;
        private Provider<StringsProvider> stringsProvider;
        private Provider<TicketsManager> ticketsManagerProvider;
        private Provider<TopBarManager> topBarManagerProvider;
        private Provider<UserBrobizzManager> userBrobizzManagerProvider;
        private Provider<UserCreditCardsManager> userCreditCardsManagerProvider;
        private Provider<UserManager> userManagerProvider;
        private Provider<UserPassengerManager> userPassengerManagerProvider;
        private Provider<UserVehiclesManager> userVehiclesManagerProvider;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes2.dex */
        public static final class SwitchingProvider<T> implements Provider<T> {
            private final int id;
            private final SingletonCImpl singletonCImpl;

            SwitchingProvider(SingletonCImpl singletonCImpl, int i5) {
                this.singletonCImpl = singletonCImpl;
                this.id = i5;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // javax.inject.Provider
            public T get() {
                switch (this.id) {
                    case 0:
                        return (T) new Settings(ApplicationContextModule_ProvideContextFactory.provideContext(this.singletonCImpl.applicationContextModule));
                    case 1:
                        return (T) new PushHandler((INotificationManager) this.singletonCImpl.bindNotificationManagerProvider.get(), (ISettings) this.singletonCImpl.bindSettingsProvider.get(), (ISaleOnBoardManager) this.singletonCImpl.bindSaleOnBoardManagerProvider.get(), (ITicketsManager) this.singletonCImpl.bindTicketsManagerProvider.get(), this.singletonCImpl.bookingsRepository(), ApplicationContextModule_ProvideContextFactory.provideContext(this.singletonCImpl.applicationContextModule));
                    case 2:
                        return (T) new NotificationManager(this.singletonCImpl.notificationService());
                    case 3:
                        return (T) ApiClientModule_BindNotificationApi$api_kombardoProdFactory.bindNotificationApi$api_kombardoProd((INetworkManager) this.singletonCImpl.bindNetworkManagerProvider.get());
                    case 4:
                        return (T) ApiClientModule_BindNetworkManagerFactory.bindNetworkManager((IApiInfoProvider) this.singletonCImpl.bindApiProviderManagerProvider.get(), (AppVersionProvider) this.singletonCImpl.appVersionProvider.get());
                    case 5:
                        return (T) new ApiProviderManager((ISettings) this.singletonCImpl.bindSettingsProvider.get());
                    case 6:
                        return (T) new AppVersionProvider(ApplicationContextModule_ProvideContextFactory.provideContext(this.singletonCImpl.applicationContextModule));
                    case 7:
                        return (T) new SaleOnBoardManager(this.singletonCImpl.saleOnBoardService(), this.singletonCImpl.saleOnBoardOrdersRepository());
                    case 8:
                        return (T) ApiClientModule_BindCateringApi$api_kombardoProdFactory.bindCateringApi$api_kombardoProd((INetworkManager) this.singletonCImpl.bindNetworkManagerProvider.get());
                    case 9:
                        return (T) new TicketsManager(this.singletonCImpl.accountBookingsService(), this.singletonCImpl.bookingService(), (IUserManager) this.singletonCImpl.bindUserManagerProvider.get(), (IMultiRideManager) this.singletonCImpl.bindMultiRideManagerProvider.get(), (IBornholmCommuterManager) this.singletonCImpl.bindBornholmCommuterManagerProvider.get(), this.singletonCImpl.bookingsRepository(), (IBookingHeaderMapper) this.singletonCImpl.bindBookingHeaderMapperProvider.get(), (IStringsProvider) this.singletonCImpl.bindStringsProvider.get(), (IConfigurationManager) this.singletonCImpl.bindConfigurationManagerProvider.get());
                    case 10:
                        return (T) ApiClientModule_BindAccountBookingApi$api_kombardoProdFactory.bindAccountBookingApi$api_kombardoProd((INetworkManager) this.singletonCImpl.bindNetworkManagerProvider.get());
                    case 11:
                        return (T) ApiClientModule_BindBookingApi$api_kombardoProdFactory.bindBookingApi$api_kombardoProd((INetworkManager) this.singletonCImpl.bindNetworkManagerProvider.get());
                    case 12:
                        return (T) new UserManager((ISettings) this.singletonCImpl.bindSettingsProvider.get(), this.singletonCImpl.userRepository(), this.singletonCImpl.accountService(), (INetworkManager) this.singletonCImpl.bindNetworkManagerProvider.get(), ApplicationContextModule_ProvideContextFactory.provideContext(this.singletonCImpl.applicationContextModule), (IAnalyticsTracker) this.singletonCImpl.bindAnalyticsTrackerProvider.get());
                    case 13:
                        return (T) ApiClientModule_BindAccountApi$api_kombardoProdFactory.bindAccountApi$api_kombardoProd((INetworkManager) this.singletonCImpl.bindNetworkManagerProvider.get());
                    case 14:
                        return (T) new AnalyticsTracker((IFacebookTracker) this.singletonCImpl.bindFacebookTrackerProvider.get(), (IAnalyticsTrackingHelper) this.singletonCImpl.bindAnalyticsTrackingHelperProvider.get(), (IAnalyticsStateTrackingHelper) this.singletonCImpl.bindAnalyticsStateTrackingHelperProvider.get(), (ILocationManagerProvider) this.singletonCImpl.bindLocationManagerProvider2.get(), ApplicationContextModule_ProvideContextFactory.provideContext(this.singletonCImpl.applicationContextModule));
                    case 15:
                        return (T) new FacebookTracker((ISettings) this.singletonCImpl.bindSettingsProvider.get());
                    case 16:
                        return (T) new AnalyticsTrackingHelper((IFacebookTracker) this.singletonCImpl.bindFacebookTrackerProvider.get(), (IAdjustTracker) this.singletonCImpl.bindAdjustTrackerProvider.get());
                    case 17:
                        return (T) new AdjustTracker((ISettings) this.singletonCImpl.bindSettingsProvider.get());
                    case 18:
                        return (T) new AnalyticsStateTrackingHelper();
                    case 19:
                        return (T) new LocationManagerProvider((ILocationManager) this.singletonCImpl.bindLocationManagerProvider.get());
                    case 20:
                        return (T) new LocationManager(ApplicationContextModule_ProvideContextFactory.provideContext(this.singletonCImpl.applicationContextModule));
                    case 21:
                        return (T) new MultiRideManager(this.singletonCImpl.multiRideService(), this.singletonCImpl.accountMultiRideService(), this.singletonCImpl.multiRideRepository(), (IUserManager) this.singletonCImpl.bindUserManagerProvider.get(), (IAnalyticsTracker) this.singletonCImpl.bindAnalyticsTrackerProvider.get());
                    case 22:
                        return (T) ApiClientModule_BindMultiRideApiFactory.bindMultiRideApi((INetworkManager) this.singletonCImpl.bindNetworkManagerProvider.get());
                    case R$styleable.Toolbar_titleMarginBottom /* 23 */:
                        return (T) new PaymentCallbackUrlProvider();
                    case R$styleable.Toolbar_titleMarginEnd /* 24 */:
                        return (T) ApiClientModule_BindAccountMultiRideApiFactory.bindAccountMultiRideApi((INetworkManager) this.singletonCImpl.bindNetworkManagerProvider.get());
                    case 25:
                        return (T) new BornholmCommuterManager(this.singletonCImpl.bornholmCommuterService(), (IConfigurationManager) this.singletonCImpl.bindConfigurationManagerProvider.get(), this.singletonCImpl.bornholmCommuterRepository(), (IAnalyticsTracker) this.singletonCImpl.bindAnalyticsTrackerProvider.get());
                    case 26:
                        return (T) ApiClientModule_BindCommuteApiFactory.bindCommuteApi((INetworkManager) this.singletonCImpl.bindNetworkManagerProvider.get());
                    case 27:
                        return (T) new ConfigurationManager(this.singletonCImpl.configurationRepository(), this.singletonCImpl.configService());
                    case 28:
                        return (T) ApiClientModule_BindConfigApi$api_kombardoProdFactory.bindConfigApi$api_kombardoProd((INetworkManager) this.singletonCImpl.bindNetworkManagerProvider.get());
                    case R$styleable.Toolbar_titleTextColor /* 29 */:
                        return (T) new BookingHeaderMapper((IConfigurationManager) this.singletonCImpl.bindConfigurationManagerProvider.get());
                    case 30:
                        return (T) new StringsProvider(ApplicationContextModule_ProvideContextFactory.provideContext(this.singletonCImpl.applicationContextModule));
                    case 31:
                        return (T) new WorkerAssistedFactory() { // from class: dk.molslinjen.DaggerApp_HiltComponents_SingletonC.SingletonCImpl.SwitchingProvider.1
                            @Override // androidx.hilt.work.WorkerAssistedFactory
                            public ConfigUpdateWorker create(Context context, WorkerParameters workerParameters) {
                                return new ConfigUpdateWorker(context, workerParameters, (IConfigurationManager) SwitchingProvider.this.singletonCImpl.bindConfigurationManagerProvider.get());
                            }
                        };
                    case 32:
                        return (T) new Migrator((ISettings) this.singletonCImpl.bindSettingsProvider.get(), (IOldAppDataMigrator) this.singletonCImpl.bindOldAppMigratorProvider.get(), this.singletonCImpl.configurationRepository());
                    case 33:
                        return (T) new OldAppDataMigrator(ApplicationContextModule_ProvideContextFactory.provideContext(this.singletonCImpl.applicationContextModule), this.singletonCImpl.saleOnBoardOrdersRepository(), this.singletonCImpl.passengerRepository(), (ITicketsManager) this.singletonCImpl.bindTicketsManagerProvider.get(), this.singletonCImpl.creditCardsRepository(), this.singletonCImpl.multiRideRepository(), (IMultiRideManager) this.singletonCImpl.bindMultiRideManagerProvider.get(), (IUserManager) this.singletonCImpl.bindUserManagerProvider.get());
                    case 34:
                        return (T) AccountMergeModule_ProvidesAssetsMergerFactory.providesAssetsMerger((IUserPassengerManager) this.singletonCImpl.bindUserPassengerManagerProvider.get(), (IUserVehiclesManager) this.singletonCImpl.bindUserVehiclesManagerProvider.get(), (IUserCreditCardsManager) this.singletonCImpl.bindUserCreditCardsManagerProvider.get(), (ITicketsManager) this.singletonCImpl.bindTicketsManagerProvider.get(), (IMultiRideManager) this.singletonCImpl.bindMultiRideManagerProvider.get());
                    case 35:
                        return (T) new UserPassengerManager(this.singletonCImpl.accountPassengerService(), (IUserManager) this.singletonCImpl.bindUserManagerProvider.get(), this.singletonCImpl.passengerRepository());
                    case 36:
                        return (T) ApiClientModule_BindAccountPassengersApi$api_kombardoProdFactory.bindAccountPassengersApi$api_kombardoProd((INetworkManager) this.singletonCImpl.bindNetworkManagerProvider.get());
                    case 37:
                        return (T) new UserVehiclesManager(this.singletonCImpl.accountVehicleService(), (IUserManager) this.singletonCImpl.bindUserManagerProvider.get(), this.singletonCImpl.vehicleRepository(), (IStringsProvider) this.singletonCImpl.bindStringsProvider.get());
                    case 38:
                        return (T) ApiClientModule_BindAccountVehiclesApi$api_kombardoProdFactory.bindAccountVehiclesApi$api_kombardoProd((INetworkManager) this.singletonCImpl.bindNetworkManagerProvider.get());
                    case 39:
                        return (T) new UserCreditCardsManager(this.singletonCImpl.accountCreditCardsService(), this.singletonCImpl.creditCardsRepository(), (IUserManager) this.singletonCImpl.bindUserManagerProvider.get(), (IFacebookTracker) this.singletonCImpl.bindFacebookTrackerProvider.get());
                    case 40:
                        return (T) ApiClientModule_BindAccountCreditCardsApi$api_kombardoProdFactory.bindAccountCreditCardsApi$api_kombardoProd((INetworkManager) this.singletonCImpl.bindNetworkManagerProvider.get());
                    case 41:
                        return (T) new AppUpdater((IForceUpdateManager) this.singletonCImpl.bindForceUpdateManagerProvider.get(), (ISettings) this.singletonCImpl.bindSettingsProvider.get(), (ISnackbarService) this.singletonCImpl.bindSnackbarServiceProvider.get());
                    case 42:
                        return (T) new ForceUpdateManager(this.singletonCImpl.forceUpdateService());
                    case 43:
                        return (T) ApiClientModule_BindForceUpdateApi$api_kombardoProdFactory.bindForceUpdateApi$api_kombardoProd((INetworkManager) this.singletonCImpl.bindNetworkManagerProvider.get());
                    case 44:
                        return (T) new SnackbarService(ApplicationContextModule_ProvideContextFactory.provideContext(this.singletonCImpl.applicationContextModule));
                    case 45:
                        return (T) new PaymentManager(this.singletonCImpl.paymentService(), this.singletonCImpl.paymentTypesService(), (IUserCreditCardsManager) this.singletonCImpl.bindUserCreditCardsManagerProvider.get(), (IAnalyticsTracker) this.singletonCImpl.bindAnalyticsTrackerProvider.get());
                    case 46:
                        return (T) ApiClientModule_BindPaymentApi$api_kombardoProdFactory.bindPaymentApi$api_kombardoProd((INetworkManager) this.singletonCImpl.bindNetworkManagerProvider.get());
                    case 47:
                        return (T) ApiClientModule_BindPaymentTypesApi$api_kombardoProdFactory.bindPaymentTypesApi$api_kombardoProd((INetworkManager) this.singletonCImpl.bindNetworkManagerProvider.get());
                    case 48:
                        return (T) new PushHandlerProvider((IPushHandler) this.singletonCImpl.bindPushHandlerProvider.get());
                    case 49:
                        return (T) new CompanyViewHelper((IUserManager) this.singletonCImpl.bindUserManagerProvider.get());
                    case 50:
                        return (T) new InfoAlertManager(this.singletonCImpl.infoAlertRepository(), this.singletonCImpl.infoService());
                    case 51:
                        return (T) ApiClientModule_BindInfoApi$api_kombardoProdFactory.bindInfoApi$api_kombardoProd((INetworkManager) this.singletonCImpl.bindNetworkManagerProvider.get());
                    case 52:
                        return (T) new MarketingNotificationManager(HandlerProviderModule_BindAgillicHandlerFactory.bindAgillicHandler(), (IUserManager) this.singletonCImpl.bindUserManagerProvider.get(), (ISettings) this.singletonCImpl.bindSettingsProvider.get(), (INotificationManager) this.singletonCImpl.bindNotificationManagerProvider.get());
                    case 53:
                        return (T) new CheckoutManager((IRouteManager) this.singletonCImpl.bindRouteManagerProvider.get(), (IDepartureManager) this.singletonCImpl.bindDepartureManagerProvider.get(), (IUserManager) this.singletonCImpl.bindUserManagerProvider.get(), this.singletonCImpl.bookingService(), (IPaymentManager) this.singletonCImpl.bindPaymentManagerProvider.get(), (ICheckoutPassengerManager) this.singletonCImpl.bindCheckoutPassengerManagerProvider.get(), (ITicketsManager) this.singletonCImpl.bindTicketsManagerProvider.get(), (IEditManager) this.singletonCImpl.bindEditManagerProvider.get(), (IMultiRideManager) this.singletonCImpl.bindMultiRideManagerProvider.get(), (IBornholmCommuterManager) this.singletonCImpl.bindBornholmCommuterManagerProvider.get(), (ISettings) this.singletonCImpl.bindSettingsProvider.get(), (IUserVehiclesManager) this.singletonCImpl.bindUserVehiclesManagerProvider.get(), (ISaleOnBoardManager) this.singletonCImpl.bindSaleOnBoardManagerProvider.get(), (IAnalyticsTracker) this.singletonCImpl.bindAnalyticsTrackerProvider.get(), (IPaymentCallbackUrlProvider) this.singletonCImpl.bindPaymentCallbackUrlProvider.get(), (IConfigurationManager) this.singletonCImpl.bindConfigurationManagerProvider.get());
                    case 54:
                        return (T) new RouteManager(this.singletonCImpl.bookingService(), (IConfigurationManager) this.singletonCImpl.bindConfigurationManagerProvider.get(), (ISettings) this.singletonCImpl.bindSettingsProvider.get(), (ICurrencyManager) this.singletonCImpl.bindCurrencyManagerProvider.get(), (IAnalyticsTracker) this.singletonCImpl.bindAnalyticsTrackerProvider.get());
                    case 55:
                        return (T) new CurrencyManager((IConfigurationManager) this.singletonCImpl.bindConfigurationManagerProvider.get(), (ISettings) this.singletonCImpl.bindSettingsProvider.get());
                    case 56:
                        return (T) new DepartureManager((IRouteManager) this.singletonCImpl.bindRouteManagerProvider.get(), (IEditManager) this.singletonCImpl.bindEditManagerProvider.get(), this.singletonCImpl.bookingService(), (ISettings) this.singletonCImpl.bindSettingsProvider.get());
                    case 57:
                        return (T) new EditManager((IRouteManager) this.singletonCImpl.bindRouteManagerProvider.get(), (IPassengerMergeHelper) this.singletonCImpl.bindPassengerMergeHelperProvider.get(), (IAnalyticsTracker) this.singletonCImpl.bindAnalyticsTrackerProvider.get());
                    case 58:
                        return (T) new PassengerMergeHelper();
                    case 59:
                        return (T) new CheckoutPassengerManager((IConfigurationManager) this.singletonCImpl.bindConfigurationManagerProvider.get(), (IEditManager) this.singletonCImpl.bindEditManagerProvider.get(), this.singletonCImpl.passengerSelectionHelper(), this.singletonCImpl.passengerSelectionHelper(), (IPassengerMergeHelper) this.singletonCImpl.bindPassengerMergeHelperProvider.get());
                    case 60:
                        return (T) new SplitTestManager((IAnalyticsTracker) this.singletonCImpl.bindAnalyticsTrackerProvider.get(), (ISettings) this.singletonCImpl.bindSettingsProvider.get());
                    case 61:
                        return (T) new SelectSeatingManager((ICheckoutManager) this.singletonCImpl.bindCheckoutManagerProvider.get(), HandlerProviderModule_BindSelectSeatingHandlerFactory.bindSelectSeatingHandler(), (SelectSeatingHelperInterface) this.singletonCImpl.bindSelectSeatingHelperProvider.get(), (IStringsProvider) this.singletonCImpl.bindStringsProvider.get());
                    case 62:
                        return (T) HelperProviderModule_BindSelectSeatingHelperFactory.bindSelectSeatingHelper();
                    case Function.ALT_CONVENTION /* 63 */:
                        return (T) new CheckoutNavigator((ICheckoutManager) this.singletonCImpl.bindCheckoutManagerProvider.get(), (ICheckoutPassengerManager) this.singletonCImpl.bindCheckoutPassengerManagerProvider.get(), (IReturnManager) this.singletonCImpl.bindReturnManagerProvider.get(), (IPaymentManager) this.singletonCImpl.bindPaymentManagerProvider.get(), (IAnalyticsTracker) this.singletonCImpl.bindAnalyticsTrackerProvider.get(), (IUserManager) this.singletonCImpl.bindUserManagerProvider.get(), (ISplitTestManager) this.singletonCImpl.bindSplitTestManagerProvider.get());
                    case Function.THROW_LAST_ERROR /* 64 */:
                        return (T) new ReturnManager((IRouteManager) this.singletonCImpl.bindRouteManagerProvider.get(), (IDepartureManager) this.singletonCImpl.bindDepartureManagerProvider.get(), (ICheckoutManager) this.singletonCImpl.bindCheckoutManagerProvider.get(), (IAnalyticsTracker) this.singletonCImpl.bindAnalyticsTrackerProvider.get());
                    case 65:
                        return (T) new OeresundCommuterManager(this.singletonCImpl.oeresundCommuterService(), this.singletonCImpl.oeresundCommuterRepository(), (IUserManager) this.singletonCImpl.bindUserManagerProvider.get());
                    case 66:
                        return (T) ApiClientModule_BindOeresundCommuterApiFactory.bindOeresundCommuterApi((INetworkManager) this.singletonCImpl.bindNetworkManagerProvider.get());
                    case 67:
                        return (T) new SiteManager((IConfigurationManager) this.singletonCImpl.bindConfigurationManagerProvider.get(), (IRouteManager) this.singletonCImpl.bindRouteManagerProvider.get());
                    case 68:
                        return (T) new BottomBarManager();
                    case 69:
                        return (T) new DirectionsManager((IGeoLocatorManager) this.singletonCImpl.bindGeoLocatorManagerProvider.get(), (ILocationManager) this.singletonCImpl.bindLocationManagerProvider.get());
                    case 70:
                        return (T) new GeoLocatorManager(this.singletonCImpl.geoLocatorService());
                    case 71:
                        return (T) ApiClientModule_BindGeoLocatorApi$api_kombardoProdFactory.bindGeoLocatorApi$api_kombardoProd((INetworkManager) this.singletonCImpl.bindNetworkManagerProvider.get());
                    case 72:
                        return (T) new RouteLocationHelper((ILocationManager) this.singletonCImpl.bindLocationManagerProvider.get(), (IConfigurationManager) this.singletonCImpl.bindConfigurationManagerProvider.get());
                    case 73:
                        return (T) new EarlyCheckInPassengerManager((IConfigurationManager) this.singletonCImpl.bindConfigurationManagerProvider.get(), this.singletonCImpl.passengerSelectionHelper(), (IPassengerMergeHelper) this.singletonCImpl.bindPassengerMergeHelperProvider.get());
                    case 74:
                        return (T) new SimpleChangeCheckoutManager((IUserManager) this.singletonCImpl.bindUserManagerProvider.get(), this.singletonCImpl.bookingService(), (IPaymentManager) this.singletonCImpl.bindPaymentManagerProvider.get(), (IEarlyCheckInPassengerManager) this.singletonCImpl.bindEarlyCheckInPassengerManagerProvider.get(), (ITicketsManager) this.singletonCImpl.bindTicketsManagerProvider.get(), (IAnalyticsTracker) this.singletonCImpl.bindAnalyticsTrackerProvider.get(), HandlerProviderModule_BindSelectSeatingHandlerFactory.bindSelectSeatingHandler(), (IPaymentCallbackUrlProvider) this.singletonCImpl.bindPaymentCallbackUrlProvider.get());
                    case 75:
                        return (T) new FaqManager((ISiteManager) this.singletonCImpl.bindSiteManagerProvider.get(), this.singletonCImpl.faqService());
                    case 76:
                        return (T) ApiClientModule_BindFaqApi$api_kombardoProdFactory.bindFaqApi$api_kombardoProd((INetworkManager) this.singletonCImpl.bindNetworkManagerProvider.get());
                    case 77:
                        return (T) new TopBarManager();
                    case 78:
                        return (T) new MultiRideCardCheckoutManager(this.singletonCImpl.multiRideService(), (IPaymentManager) this.singletonCImpl.bindPaymentManagerProvider.get(), (IMultiRideManager) this.singletonCImpl.bindMultiRideManagerProvider.get(), (IUserManager) this.singletonCImpl.bindUserManagerProvider.get(), (ISiteManager) this.singletonCImpl.bindSiteManagerProvider.get(), (ICurrencyManager) this.singletonCImpl.bindCurrencyManagerProvider.get(), (IAnalyticsTracker) this.singletonCImpl.bindAnalyticsTrackerProvider.get(), (ISettings) this.singletonCImpl.bindSettingsProvider.get());
                    case 79:
                        return (T) new SaleOnBoardCheckoutManager(this.singletonCImpl.saleOnBoardService(), (IUserManager) this.singletonCImpl.bindUserManagerProvider.get(), (IPaymentManager) this.singletonCImpl.bindPaymentManagerProvider.get(), this.singletonCImpl.paymentService(), (ISaleOnBoardManager) this.singletonCImpl.bindSaleOnBoardManagerProvider.get(), (IAnalyticsTracker) this.singletonCImpl.bindAnalyticsTrackerProvider.get(), (ISettings) this.singletonCImpl.bindSettingsProvider.get(), (IPaymentCallbackUrlProvider) this.singletonCImpl.bindPaymentCallbackUrlProvider.get());
                    case 80:
                        return (T) HelperProviderModule_BindPhoneNumberUtilFactory.bindPhoneNumberUtil(ApplicationContextModule_ProvideContextFactory.provideContext(this.singletonCImpl.applicationContextModule));
                    case 81:
                        return (T) new UserBrobizzManager(this.singletonCImpl.accountBrobizzService(), (IUserManager) this.singletonCImpl.bindUserManagerProvider.get());
                    case 82:
                        return (T) ApiClientModule_BindAccountBrobizzApi$api_kombardoProdFactory.bindAccountBrobizzApi$api_kombardoProd((INetworkManager) this.singletonCImpl.bindNetworkManagerProvider.get());
                    case 83:
                        return (T) new NewslettersManager(this.singletonCImpl.newslettersService(), this.singletonCImpl.siteManager(), (IUserManager) this.singletonCImpl.bindUserManagerProvider.get());
                    case 84:
                        return (T) ApiClientModule_BindNewslettersApi$api_kombardoProdFactory.bindNewslettersApi$api_kombardoProd((INetworkManager) this.singletonCImpl.bindNetworkManagerProvider.get());
                    case 85:
                        return (T) new SaleOnBoardRouteManager((IConfigurationManager) this.singletonCImpl.bindConfigurationManagerProvider.get());
                    case 86:
                        return (T) new SaleOnBoardDepartureManager(this.singletonCImpl.bookingService(), (ISaleOnBoardRouteManager) this.singletonCImpl.bindSaleOnBoardRouteManagerProvider.get());
                    default:
                        throw new AssertionError(this.id);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public AccountBookingsService accountBookingsService() {
            return new AccountBookingsService(this.bindAccountBookingApi$api_kombardoProdProvider.get());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public AccountBrobizzService accountBrobizzService() {
            return new AccountBrobizzService(this.bindAccountBrobizzApi$api_kombardoProdProvider.get());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public AccountCreditCardsService accountCreditCardsService() {
            return new AccountCreditCardsService(this.bindAccountCreditCardsApi$api_kombardoProdProvider.get());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public AccountMultiRideService accountMultiRideService() {
            return new AccountMultiRideService(this.bindAccountMultiRideApiProvider.get());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public AccountPassengerService accountPassengerService() {
            return new AccountPassengerService(this.bindAccountPassengersApi$api_kombardoProdProvider.get());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public AccountService accountService() {
            return new AccountService(this.bindAccountApi$api_kombardoProdProvider.get());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public AccountVehicleService accountVehicleService() {
            return new AccountVehicleService(this.bindAccountVehiclesApi$api_kombardoProdProvider.get());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public AddonHelper addonHelper() {
            return new AddonHelper(bookingService(), this.bindSplitTestManagerProvider.get(), this.bindStringsProvider.get());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public AnalyticsTracker analyticsTracker() {
            return new AnalyticsTracker(this.bindFacebookTrackerProvider.get(), this.bindAnalyticsTrackingHelperProvider.get(), this.bindAnalyticsStateTrackingHelperProvider.get(), this.bindLocationManagerProvider2.get(), ApplicationContextModule_ProvideContextFactory.provideContext(this.applicationContextModule));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public BookingService bookingService() {
            return new BookingService(this.bindBookingApi$api_kombardoProdProvider.get());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public BookingsRepository bookingsRepository() {
            return new BookingsRepository(ApplicationContextModule_ProvideContextFactory.provideContext(this.applicationContextModule));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public BornholmCommuterRepository bornholmCommuterRepository() {
            return new BornholmCommuterRepository(ApplicationContextModule_ProvideContextFactory.provideContext(this.applicationContextModule));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public BornholmCommuterService bornholmCommuterService() {
            return new BornholmCommuterService(this.bindCommuteApiProvider.get());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ConfigService configService() {
            return new ConfigService(this.bindConfigApi$api_kombardoProdProvider.get());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ConfigurationRepository configurationRepository() {
            return new ConfigurationRepository(ApplicationContextModule_ProvideContextFactory.provideContext(this.applicationContextModule));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public CreditCardsRepository creditCardsRepository() {
            return new CreditCardsRepository(ApplicationContextModule_ProvideContextFactory.provideContext(this.applicationContextModule));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public FaqService faqService() {
            return new FaqService(this.bindFaqApi$api_kombardoProdProvider.get());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ForceUpdateService forceUpdateService() {
            return new ForceUpdateService(this.bindForceUpdateApi$api_kombardoProdProvider.get());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public GeoLocatorService geoLocatorService() {
            return new GeoLocatorService(this.bindGeoLocatorApi$api_kombardoProdProvider.get());
        }

        private HiltWorkerFactory hiltWorkerFactory() {
            return WorkerFactoryModule_ProvideFactoryFactory.provideFactory(mapOfStringAndProviderOfWorkerAssistedFactoryOf());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public InfoAlertRepository infoAlertRepository() {
            return new InfoAlertRepository(ApplicationContextModule_ProvideContextFactory.provideContext(this.applicationContextModule));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public InfoService infoService() {
            return new InfoService(this.bindInfoApi$api_kombardoProdProvider.get());
        }

        private void initialize(ApplicationContextModule applicationContextModule) {
            SwitchingProvider switchingProvider = new SwitchingProvider(this.singletonCImpl, 0);
            this.settingsProvider = switchingProvider;
            this.bindSettingsProvider = DoubleCheck.provider((Provider) switchingProvider);
            SwitchingProvider switchingProvider2 = new SwitchingProvider(this.singletonCImpl, 5);
            this.apiProviderManagerProvider = switchingProvider2;
            this.bindApiProviderManagerProvider = DoubleCheck.provider((Provider) switchingProvider2);
            this.appVersionProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 6));
            this.bindNetworkManagerProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 4));
            this.bindNotificationApi$api_kombardoProdProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 3));
            SwitchingProvider switchingProvider3 = new SwitchingProvider(this.singletonCImpl, 2);
            this.notificationManagerProvider = switchingProvider3;
            this.bindNotificationManagerProvider = DoubleCheck.provider((Provider) switchingProvider3);
            this.bindCateringApi$api_kombardoProdProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 8));
            SwitchingProvider switchingProvider4 = new SwitchingProvider(this.singletonCImpl, 7);
            this.saleOnBoardManagerProvider = switchingProvider4;
            this.bindSaleOnBoardManagerProvider = DoubleCheck.provider((Provider) switchingProvider4);
            this.bindAccountBookingApi$api_kombardoProdProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 10));
            this.bindBookingApi$api_kombardoProdProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 11));
            this.bindAccountApi$api_kombardoProdProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 13));
            SwitchingProvider switchingProvider5 = new SwitchingProvider(this.singletonCImpl, 15);
            this.facebookTrackerProvider = switchingProvider5;
            this.bindFacebookTrackerProvider = DoubleCheck.provider((Provider) switchingProvider5);
            SwitchingProvider switchingProvider6 = new SwitchingProvider(this.singletonCImpl, 17);
            this.adjustTrackerProvider = switchingProvider6;
            this.bindAdjustTrackerProvider = DoubleCheck.provider((Provider) switchingProvider6);
            SwitchingProvider switchingProvider7 = new SwitchingProvider(this.singletonCImpl, 16);
            this.analyticsTrackingHelperProvider = switchingProvider7;
            this.bindAnalyticsTrackingHelperProvider = DoubleCheck.provider((Provider) switchingProvider7);
            SwitchingProvider switchingProvider8 = new SwitchingProvider(this.singletonCImpl, 18);
            this.analyticsStateTrackingHelperProvider = switchingProvider8;
            this.bindAnalyticsStateTrackingHelperProvider = DoubleCheck.provider((Provider) switchingProvider8);
            SwitchingProvider switchingProvider9 = new SwitchingProvider(this.singletonCImpl, 20);
            this.locationManagerProvider = switchingProvider9;
            this.bindLocationManagerProvider = DoubleCheck.provider((Provider) switchingProvider9);
        }

        private void initialize2(ApplicationContextModule applicationContextModule) {
            SwitchingProvider switchingProvider = new SwitchingProvider(this.singletonCImpl, 19);
            this.locationManagerProvider2 = switchingProvider;
            this.bindLocationManagerProvider2 = DoubleCheck.provider((Provider) switchingProvider);
            SwitchingProvider switchingProvider2 = new SwitchingProvider(this.singletonCImpl, 14);
            this.analyticsTrackerProvider = switchingProvider2;
            this.bindAnalyticsTrackerProvider = DoubleCheck.provider((Provider) switchingProvider2);
            SwitchingProvider switchingProvider3 = new SwitchingProvider(this.singletonCImpl, 12);
            this.userManagerProvider = switchingProvider3;
            this.bindUserManagerProvider = DoubleCheck.provider((Provider) switchingProvider3);
            this.bindMultiRideApiProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 22));
            SwitchingProvider switchingProvider4 = new SwitchingProvider(this.singletonCImpl, 23);
            this.paymentCallbackUrlProvider = switchingProvider4;
            this.bindPaymentCallbackUrlProvider = DoubleCheck.provider((Provider) switchingProvider4);
            this.bindAccountMultiRideApiProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 24));
            SwitchingProvider switchingProvider5 = new SwitchingProvider(this.singletonCImpl, 21);
            this.multiRideManagerProvider = switchingProvider5;
            this.bindMultiRideManagerProvider = DoubleCheck.provider((Provider) switchingProvider5);
            this.bindCommuteApiProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 26));
            this.bindConfigApi$api_kombardoProdProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 28));
            SwitchingProvider switchingProvider6 = new SwitchingProvider(this.singletonCImpl, 27);
            this.configurationManagerProvider = switchingProvider6;
            this.bindConfigurationManagerProvider = DoubleCheck.provider((Provider) switchingProvider6);
            SwitchingProvider switchingProvider7 = new SwitchingProvider(this.singletonCImpl, 25);
            this.bornholmCommuterManagerProvider = switchingProvider7;
            this.bindBornholmCommuterManagerProvider = DoubleCheck.provider((Provider) switchingProvider7);
            SwitchingProvider switchingProvider8 = new SwitchingProvider(this.singletonCImpl, 29);
            this.bookingHeaderMapperProvider = switchingProvider8;
            this.bindBookingHeaderMapperProvider = DoubleCheck.provider((Provider) switchingProvider8);
            SwitchingProvider switchingProvider9 = new SwitchingProvider(this.singletonCImpl, 30);
            this.stringsProvider = switchingProvider9;
            this.bindStringsProvider = DoubleCheck.provider((Provider) switchingProvider9);
            SwitchingProvider switchingProvider10 = new SwitchingProvider(this.singletonCImpl, 9);
            this.ticketsManagerProvider = switchingProvider10;
            this.bindTicketsManagerProvider = DoubleCheck.provider((Provider) switchingProvider10);
            this.pushHandlerProvider = new SwitchingProvider(this.singletonCImpl, 1);
        }

        private void initialize3(ApplicationContextModule applicationContextModule) {
            this.bindPushHandlerProvider = DoubleCheck.provider((Provider) this.pushHandlerProvider);
            this.configUpdateWorker_AssistedFactoryProvider = SingleCheck.provider(new SwitchingProvider(this.singletonCImpl, 31));
            SwitchingProvider switchingProvider = new SwitchingProvider(this.singletonCImpl, 33);
            this.oldAppDataMigratorProvider = switchingProvider;
            this.bindOldAppMigratorProvider = DoubleCheck.provider((Provider) switchingProvider);
            SwitchingProvider switchingProvider2 = new SwitchingProvider(this.singletonCImpl, 32);
            this.migratorProvider = switchingProvider2;
            this.bindMigratorProvider = DoubleCheck.provider((Provider) switchingProvider2);
            this.bindAccountPassengersApi$api_kombardoProdProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 36));
            SwitchingProvider switchingProvider3 = new SwitchingProvider(this.singletonCImpl, 35);
            this.userPassengerManagerProvider = switchingProvider3;
            this.bindUserPassengerManagerProvider = DoubleCheck.provider((Provider) switchingProvider3);
            this.bindAccountVehiclesApi$api_kombardoProdProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 38));
            SwitchingProvider switchingProvider4 = new SwitchingProvider(this.singletonCImpl, 37);
            this.userVehiclesManagerProvider = switchingProvider4;
            this.bindUserVehiclesManagerProvider = DoubleCheck.provider((Provider) switchingProvider4);
            this.bindAccountCreditCardsApi$api_kombardoProdProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 40));
            SwitchingProvider switchingProvider5 = new SwitchingProvider(this.singletonCImpl, 39);
            this.userCreditCardsManagerProvider = switchingProvider5;
            this.bindUserCreditCardsManagerProvider = DoubleCheck.provider((Provider) switchingProvider5);
            this.providesAssetsMergerProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 34));
            this.bindForceUpdateApi$api_kombardoProdProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 43));
            SwitchingProvider switchingProvider6 = new SwitchingProvider(this.singletonCImpl, 42);
            this.forceUpdateManagerProvider = switchingProvider6;
            this.bindForceUpdateManagerProvider = DoubleCheck.provider((Provider) switchingProvider6);
            SwitchingProvider switchingProvider7 = new SwitchingProvider(this.singletonCImpl, 44);
            this.snackbarServiceProvider = switchingProvider7;
            this.bindSnackbarServiceProvider = DoubleCheck.provider((Provider) switchingProvider7);
            SwitchingProvider switchingProvider8 = new SwitchingProvider(this.singletonCImpl, 41);
            this.appUpdaterProvider = switchingProvider8;
            this.bindAppUpdaterProvider = DoubleCheck.provider((Provider) switchingProvider8);
            this.bindPaymentApi$api_kombardoProdProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 46));
            this.bindPaymentTypesApi$api_kombardoProdProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 47));
        }

        private void initialize4(ApplicationContextModule applicationContextModule) {
            SwitchingProvider switchingProvider = new SwitchingProvider(this.singletonCImpl, 45);
            this.paymentManagerProvider = switchingProvider;
            this.bindPaymentManagerProvider = DoubleCheck.provider((Provider) switchingProvider);
            SwitchingProvider switchingProvider2 = new SwitchingProvider(this.singletonCImpl, 48);
            this.pushHandlerProvider2 = switchingProvider2;
            this.bindPushHandlerProvider2 = DoubleCheck.provider((Provider) switchingProvider2);
            SwitchingProvider switchingProvider3 = new SwitchingProvider(this.singletonCImpl, 49);
            this.companyViewHelperProvider = switchingProvider3;
            this.bindCompanyViewHelperProvider = DoubleCheck.provider((Provider) switchingProvider3);
            this.bindInfoApi$api_kombardoProdProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 51));
            SwitchingProvider switchingProvider4 = new SwitchingProvider(this.singletonCImpl, 50);
            this.infoAlertManagerProvider = switchingProvider4;
            this.bindInfoAlertManagerProvider = DoubleCheck.provider((Provider) switchingProvider4);
            SwitchingProvider switchingProvider5 = new SwitchingProvider(this.singletonCImpl, 52);
            this.marketingNotificationManagerProvider = switchingProvider5;
            this.bindMarketingNotificationManagerProvider = DoubleCheck.provider((Provider) switchingProvider5);
            SwitchingProvider switchingProvider6 = new SwitchingProvider(this.singletonCImpl, 55);
            this.currencyManagerProvider = switchingProvider6;
            this.bindCurrencyManagerProvider = DoubleCheck.provider((Provider) switchingProvider6);
            SwitchingProvider switchingProvider7 = new SwitchingProvider(this.singletonCImpl, 54);
            this.routeManagerProvider = switchingProvider7;
            this.bindRouteManagerProvider = DoubleCheck.provider((Provider) switchingProvider7);
            SwitchingProvider switchingProvider8 = new SwitchingProvider(this.singletonCImpl, 58);
            this.passengerMergeHelperProvider = switchingProvider8;
            this.bindPassengerMergeHelperProvider = DoubleCheck.provider((Provider) switchingProvider8);
            SwitchingProvider switchingProvider9 = new SwitchingProvider(this.singletonCImpl, 57);
            this.editManagerProvider = switchingProvider9;
            this.bindEditManagerProvider = DoubleCheck.provider((Provider) switchingProvider9);
            SwitchingProvider switchingProvider10 = new SwitchingProvider(this.singletonCImpl, 56);
            this.departureManagerProvider = switchingProvider10;
            this.bindDepartureManagerProvider = DoubleCheck.provider((Provider) switchingProvider10);
            SwitchingProvider switchingProvider11 = new SwitchingProvider(this.singletonCImpl, 59);
            this.checkoutPassengerManagerProvider = switchingProvider11;
            this.bindCheckoutPassengerManagerProvider = DoubleCheck.provider((Provider) switchingProvider11);
            SwitchingProvider switchingProvider12 = new SwitchingProvider(this.singletonCImpl, 53);
            this.checkoutManagerProvider = switchingProvider12;
            this.bindCheckoutManagerProvider = DoubleCheck.provider((Provider) switchingProvider12);
        }

        private void initialize5(ApplicationContextModule applicationContextModule) {
            SwitchingProvider switchingProvider = new SwitchingProvider(this.singletonCImpl, 60);
            this.splitTestManagerProvider = switchingProvider;
            this.bindSplitTestManagerProvider = DoubleCheck.provider((Provider) switchingProvider);
            this.bindSelectSeatingHelperProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 62));
            SwitchingProvider switchingProvider2 = new SwitchingProvider(this.singletonCImpl, 61);
            this.selectSeatingManagerProvider = switchingProvider2;
            this.bindSeatReservationManagerProvider = DoubleCheck.provider((Provider) switchingProvider2);
            SwitchingProvider switchingProvider3 = new SwitchingProvider(this.singletonCImpl, 64);
            this.returnManagerProvider = switchingProvider3;
            this.bindReturnManagerProvider = DoubleCheck.provider((Provider) switchingProvider3);
            SwitchingProvider switchingProvider4 = new SwitchingProvider(this.singletonCImpl, 63);
            this.checkoutNavigatorProvider = switchingProvider4;
            this.bindCheckoutNavigatorProvider = DoubleCheck.provider((Provider) switchingProvider4);
            this.bindOeresundCommuterApiProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 66));
            SwitchingProvider switchingProvider5 = new SwitchingProvider(this.singletonCImpl, 65);
            this.oeresundCommuterManagerProvider = switchingProvider5;
            this.bindOeresundCommuterManagerProvider = DoubleCheck.provider((Provider) switchingProvider5);
            SwitchingProvider switchingProvider6 = new SwitchingProvider(this.singletonCImpl, 67);
            this.siteManagerProvider = switchingProvider6;
            this.bindSiteManagerProvider = DoubleCheck.provider((Provider) switchingProvider6);
            SwitchingProvider switchingProvider7 = new SwitchingProvider(this.singletonCImpl, 68);
            this.bottomBarManagerProvider = switchingProvider7;
            this.bindBottomBarManagerProvider = DoubleCheck.provider((Provider) switchingProvider7);
            this.bindGeoLocatorApi$api_kombardoProdProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 71));
            SwitchingProvider switchingProvider8 = new SwitchingProvider(this.singletonCImpl, 70);
            this.geoLocatorManagerProvider = switchingProvider8;
            this.bindGeoLocatorManagerProvider = DoubleCheck.provider((Provider) switchingProvider8);
            SwitchingProvider switchingProvider9 = new SwitchingProvider(this.singletonCImpl, 69);
            this.directionsManagerProvider = switchingProvider9;
            this.bindDirectionsManagerProvider = DoubleCheck.provider((Provider) switchingProvider9);
            SwitchingProvider switchingProvider10 = new SwitchingProvider(this.singletonCImpl, 72);
            this.routeLocationHelperProvider = switchingProvider10;
            this.bindRouteLocationHelperProvider = DoubleCheck.provider((Provider) switchingProvider10);
            SwitchingProvider switchingProvider11 = new SwitchingProvider(this.singletonCImpl, 73);
            this.earlyCheckInPassengerManagerProvider = switchingProvider11;
            this.bindEarlyCheckInPassengerManagerProvider = DoubleCheck.provider((Provider) switchingProvider11);
        }

        private void initialize6(ApplicationContextModule applicationContextModule) {
            SwitchingProvider switchingProvider = new SwitchingProvider(this.singletonCImpl, 74);
            this.simpleChangeCheckoutManagerProvider = switchingProvider;
            this.bindSimpleChangeCheckoutManagerProvider = DoubleCheck.provider((Provider) switchingProvider);
            this.bindFaqApi$api_kombardoProdProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 76));
            SwitchingProvider switchingProvider2 = new SwitchingProvider(this.singletonCImpl, 75);
            this.faqManagerProvider = switchingProvider2;
            this.bindFaqManagerProvider = DoubleCheck.provider((Provider) switchingProvider2);
            SwitchingProvider switchingProvider3 = new SwitchingProvider(this.singletonCImpl, 77);
            this.topBarManagerProvider = switchingProvider3;
            this.bindTopBarManagerProvider = DoubleCheck.provider((Provider) switchingProvider3);
            SwitchingProvider switchingProvider4 = new SwitchingProvider(this.singletonCImpl, 78);
            this.multiRideCardCheckoutManagerProvider = switchingProvider4;
            this.bindMultiRideCardCheckoutManagerProvider = DoubleCheck.provider((Provider) switchingProvider4);
            SwitchingProvider switchingProvider5 = new SwitchingProvider(this.singletonCImpl, 79);
            this.saleOnBoardCheckoutManagerProvider = switchingProvider5;
            this.bindSaleOnBoardCheckoutManagerProvider = DoubleCheck.provider((Provider) switchingProvider5);
            this.bindPhoneNumberUtilProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 80));
            this.bindAccountBrobizzApi$api_kombardoProdProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 82));
            SwitchingProvider switchingProvider6 = new SwitchingProvider(this.singletonCImpl, 81);
            this.userBrobizzManagerProvider = switchingProvider6;
            this.bindUserBrobizzManagerProvider = DoubleCheck.provider((Provider) switchingProvider6);
            this.bindNewslettersApi$api_kombardoProdProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 84));
            SwitchingProvider switchingProvider7 = new SwitchingProvider(this.singletonCImpl, 83);
            this.newslettersManagerProvider = switchingProvider7;
            this.bindNewslettersManagerProvider = DoubleCheck.provider((Provider) switchingProvider7);
            SwitchingProvider switchingProvider8 = new SwitchingProvider(this.singletonCImpl, 85);
            this.saleOnBoardRouteManagerProvider = switchingProvider8;
            this.bindSaleOnBoardRouteManagerProvider = DoubleCheck.provider((Provider) switchingProvider8);
            SwitchingProvider switchingProvider9 = new SwitchingProvider(this.singletonCImpl, 86);
            this.saleOnBoardDepartureManagerProvider = switchingProvider9;
            this.bindSaleOnBoardDepartureManagerProvider = DoubleCheck.provider((Provider) switchingProvider9);
        }

        private App injectApp2(App app) {
            App_MembersInjector.injectSettings(app, this.bindSettingsProvider.get());
            App_MembersInjector.injectPushHandler(app, this.bindPushHandlerProvider.get());
            App_MembersInjector.injectWorkerFactory(app, hiltWorkerFactory());
            App_MembersInjector.injectMigrator(app, this.bindMigratorProvider.get());
            App_MembersInjector.injectAdjustTracker(app, this.bindAdjustTrackerProvider.get());
            App_MembersInjector.injectFacebookTracker(app, this.bindFacebookTrackerProvider.get());
            App_MembersInjector.injectApiProviderManager(app, this.bindApiProviderManagerProvider.get());
            App_MembersInjector.injectNotificationManager(app, this.bindNotificationManagerProvider.get());
            App_MembersInjector.injectLocationManager(app, this.bindLocationManagerProvider.get());
            return app;
        }

        private Map<String, javax.inject.Provider<WorkerAssistedFactory<? extends ListenableWorker>>> mapOfStringAndProviderOfWorkerAssistedFactoryOf() {
            return ImmutableMap.of("dk.molslinjen.workers.ConfigUpdateWorker", this.configUpdateWorker_AssistedFactoryProvider);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public MultiRideManager multiRideManager() {
            return new MultiRideManager(multiRideService(), accountMultiRideService(), multiRideRepository(), this.bindUserManagerProvider.get(), this.bindAnalyticsTrackerProvider.get());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public MultiRideRepository multiRideRepository() {
            return new MultiRideRepository(ApplicationContextModule_ProvideContextFactory.provideContext(this.applicationContextModule));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public MultiRideService multiRideService() {
            return new MultiRideService(this.bindMultiRideApiProvider.get(), this.bindPaymentCallbackUrlProvider.get());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public NewslettersService newslettersService() {
            return new NewslettersService(this.bindNewslettersApi$api_kombardoProdProvider.get());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public NotificationService notificationService() {
            return new NotificationService(this.bindNotificationApi$api_kombardoProdProvider.get());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public OeresundCommuterRepository oeresundCommuterRepository() {
            return new OeresundCommuterRepository(ApplicationContextModule_ProvideContextFactory.provideContext(this.applicationContextModule));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public OeresundCommuterService oeresundCommuterService() {
            return new OeresundCommuterService(this.bindOeresundCommuterApiProvider.get());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public OnboardingNavigator onboardingNavigator() {
            return new OnboardingNavigator(this.bindSettingsProvider.get(), this.bindPushHandlerProvider.get());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public PassengerRepository passengerRepository() {
            return new PassengerRepository(ApplicationContextModule_ProvideContextFactory.provideContext(this.applicationContextModule));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public PassengerSelectionHelper passengerSelectionHelper() {
            return new PassengerSelectionHelper(this.bindUserPassengerManagerProvider.get());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public PaymentService paymentService() {
            return new PaymentService(this.bindPaymentApi$api_kombardoProdProvider.get());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public PaymentTypesService paymentTypesService() {
            return new PaymentTypesService(this.bindPaymentTypesApi$api_kombardoProdProvider.get());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public SaleOnBoardOrdersRepository saleOnBoardOrdersRepository() {
            return new SaleOnBoardOrdersRepository(ApplicationContextModule_ProvideContextFactory.provideContext(this.applicationContextModule));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public SaleOnBoardService saleOnBoardService() {
            return new SaleOnBoardService(this.bindCateringApi$api_kombardoProdProvider.get());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public SiteManager siteManager() {
            return new SiteManager(this.bindConfigurationManagerProvider.get(), this.bindRouteManagerProvider.get());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public SummaryAddonHelper summaryAddonHelper() {
            return new SummaryAddonHelper(bookingService(), this.bindSplitTestManagerProvider.get(), this.bindStringsProvider.get());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public UserRepository userRepository() {
            return new UserRepository(ApplicationContextModule_ProvideContextFactory.provideContext(this.applicationContextModule));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public VehicleRepository vehicleRepository() {
            return new VehicleRepository(ApplicationContextModule_ProvideContextFactory.provideContext(this.applicationContextModule));
        }

        @Override // dk.molslinjen.domain.managers.user.merge.AssetsMergeContext.AssetsMergeContextEntryPoint
        public IAssetsMerger[] assetsMergers() {
            return this.providesAssetsMergerProvider.get();
        }

        @Override // dk.molslinjen.core.push.NotificationManagerEntryPoint
        public INotificationManager getNotificationManager() {
            return this.bindNotificationManagerProvider.get();
        }

        @Override // dk.molslinjen.core.push.PushHandlerEntryPoint
        public IPushHandler getPushHandler() {
            return this.bindPushHandlerProvider.get();
        }

        @Override // dk.molslinjen.App_GeneratedInjector
        public void injectApp(App app) {
            injectApp2(app);
        }

        @Override // dagger.hilt.android.internal.managers.ActivityRetainedComponentManager.ActivityRetainedComponentBuilderEntryPoint
        public ActivityRetainedComponentBuilder retainedComponentBuilder() {
            return new ActivityRetainedCBuilder(this.singletonCImpl);
        }

        private SingletonCImpl(ApplicationContextModule applicationContextModule) {
            this.singletonCImpl = this;
            this.applicationContextModule = applicationContextModule;
            initialize(applicationContextModule);
            initialize2(applicationContextModule);
            initialize3(applicationContextModule);
            initialize4(applicationContextModule);
            initialize5(applicationContextModule);
            initialize6(applicationContextModule);
        }
    }

    /* loaded from: classes2.dex */
    private static final class ViewModelCBuilder implements ViewModelComponentBuilder {
        private final ActivityRetainedCImpl activityRetainedCImpl;
        private SavedStateHandle savedStateHandle;
        private final SingletonCImpl singletonCImpl;
        private ViewModelLifecycle viewModelLifecycle;

        private ViewModelCBuilder(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl) {
            this.singletonCImpl = singletonCImpl;
            this.activityRetainedCImpl = activityRetainedCImpl;
        }

        @Override // dagger.hilt.android.internal.builders.ViewModelComponentBuilder
        public App_HiltComponents$ViewModelC build() {
            Preconditions.checkBuilderRequirement(this.savedStateHandle, SavedStateHandle.class);
            Preconditions.checkBuilderRequirement(this.viewModelLifecycle, ViewModelLifecycle.class);
            return new ViewModelCImpl(this.singletonCImpl, this.activityRetainedCImpl, this.savedStateHandle, this.viewModelLifecycle);
        }

        @Override // dagger.hilt.android.internal.builders.ViewModelComponentBuilder
        public ViewModelCBuilder savedStateHandle(SavedStateHandle savedStateHandle) {
            this.savedStateHandle = (SavedStateHandle) Preconditions.checkNotNull(savedStateHandle);
            return this;
        }

        @Override // dagger.hilt.android.internal.builders.ViewModelComponentBuilder
        public ViewModelCBuilder viewModelLifecycle(ViewModelLifecycle viewModelLifecycle) {
            this.viewModelLifecycle = (ViewModelLifecycle) Preconditions.checkNotNull(viewModelLifecycle);
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class ViewModelCImpl extends App_HiltComponents$ViewModelC {
        private Provider<AccountActivationViewModel> accountActivationViewModelProvider;
        private final ActivityRetainedCImpl activityRetainedCImpl;
        private Provider<AddExistingTicketViewModel> addExistingTicketViewModelProvider;
        private Provider<AddonsViewModel> addonsViewModelProvider;
        private Provider<AgreementsViewModel> agreementsViewModelProvider;
        private Provider<AssetsMergeViewModel> assetsMergeViewModelProvider;
        private Provider<BarcodeDetailsViewModel> barcodeDetailsViewModelProvider;
        private Provider<BookingSummaryViewModel> bookingSummaryViewModelProvider;
        private Provider<BornholmCommuterAddViewModel> bornholmCommuterAddViewModelProvider;
        private Provider<BornholmCommuterDetailsViewModel> bornholmCommuterDetailsViewModelProvider;
        private Provider<BornholmCommuterTicketHistoryViewModel> bornholmCommuterTicketHistoryViewModelProvider;
        private Provider<BottomBarViewModel> bottomBarViewModelProvider;
        private Provider<CalendarViewModel> calendarViewModelProvider;
        private Provider<CargoDetailsViewModel> cargoDetailsViewModelProvider;
        private Provider<ChangePasswordViewModel> changePasswordViewModelProvider;
        private Provider<CheckoutDetailsViewModel> checkoutDetailsViewModelProvider;
        private Provider<CheckoutPassengerCreateViewModel> checkoutPassengerCreateViewModelProvider;
        private Provider<CheckoutPassengerEditViewModel> checkoutPassengerEditViewModelProvider;
        private Provider<CheckoutViewModel> checkoutViewModelProvider;
        private Provider<CommuterAddAgreementsViewModel> commuterAddAgreementsViewModelProvider;
        private Provider<CommuterOverviewViewModel> commuterOverviewViewModelProvider;
        private Provider<ContactScreenViewModel> contactScreenViewModelProvider;
        private Provider<CreateYourSelfAsPassengerViewModel> createYourSelfAsPassengerViewModelProvider;
        private Provider<CurrenciesViewModel> currenciesViewModelProvider;
        private Provider<DeepLinkViewModel> deepLinkViewModelProvider;
        private Provider<DeparturesViewModel> departuresViewModelProvider;
        private Provider<DeveloperInputComponentsViewModel> developerInputComponentsViewModelProvider;
        private Provider<DeveloperViewModel> developerViewModelProvider;
        private Provider<EarlyCheckInPassengerCreateViewModel> earlyCheckInPassengerCreateViewModelProvider;
        private Provider<EarlyCheckInPassengerEditViewModel> earlyCheckInPassengerEditViewModelProvider;
        private Provider<EarlyCheckInPassengerSelectorViewModel> earlyCheckInPassengerSelectorViewModelProvider;
        private Provider<EarlyCheckInProcessingViewModel> earlyCheckInProcessingViewModelProvider;
        private Provider<EarlyCheckInViewModel> earlyCheckInViewModelProvider;
        private Provider<ErrorViewModel> errorViewModelProvider;
        private Provider<FaqSubjectViewModel> faqSubjectViewModelProvider;
        private Provider<FaqViewModel> faqViewModelProvider;
        private Provider<FerryFloorSectionViewModel> ferryFloorSectionViewModelProvider;
        private Provider<FerrySectionSeatsViewModel> ferrySectionSeatsViewModelProvider;
        private Provider<FoodBarcodeDetailsViewModel> foodBarcodeDetailsViewModelProvider;
        private Provider<FoodViewModel> foodViewModelProvider;
        private Provider<ForgotPasswordViewModel> forgotPasswordViewModelProvider;
        private Provider<InfoAlertViewModel> infoAlertViewModelProvider;
        private Provider<LoginViewModel> loginViewModelProvider;
        private Provider<LoungeBarcodeDetailsViewModel> loungeBarcodeDetailsViewModelProvider;
        private Provider<MainViewModel> mainViewModelProvider;
        private Provider<ManuelForceUpdateViewModel> manuelForceUpdateViewModelProvider;
        private Provider<MigrationErrorViewModel> migrationErrorViewModelProvider;
        private Provider<MultiRideAddCardViewModel> multiRideAddCardViewModelProvider;
        private Provider<MultiRideDetailsViewModel> multiRideDetailsViewModelProvider;
        private Provider<MultiRideOverviewViewModel> multiRideOverviewViewModelProvider;
        private Provider<MultiRidePurchaseReceiptViewModel> multiRidePurchaseReceiptViewModelProvider;
        private Provider<MultiRidePurchaseSummaryViewModel> multiRidePurchaseSummaryViewModelProvider;
        private Provider<MultiRidePurchaseViewModel> multiRidePurchaseViewModelProvider;
        private Provider<MultiRideRefillViewModel> multiRideRefillViewModelProvider;
        private Provider<MultiRideTicketHistoryViewModel> multiRideTicketHistoryViewModelProvider;
        private Provider<NationalitySelectionViewModel> nationalitySelectionViewModelProvider;
        private Provider<OeresundCommuterDetailsViewModel> oeresundCommuterDetailsViewModelProvider;
        private Provider<OnboardingLocationViewModel> onboardingLocationViewModelProvider;
        private Provider<OnboardingMarketingNotificationsViewModel> onboardingMarketingNotificationsViewModelProvider;
        private Provider<OnboardingNotificationViewModel> onboardingNotificationViewModelProvider;
        private Provider<OnboardingSelectRouteViewModel> onboardingSelectRouteViewModelProvider;
        private Provider<PassengerCountSelectorViewModel> passengerCountSelectorViewModelProvider;
        private Provider<PassengerCountViewModel> passengerCountViewModelProvider;
        private Provider<PassengersViewModel> passengersViewModelProvider;
        private Provider<PaymentViewModel> paymentViewModelProvider;
        private Provider<PermissionsViewModel> permissionsViewModelProvider;
        private Provider<PhoneNumberCodeSelectionViewModel> phoneNumberCodeSelectionViewModelProvider;
        private Provider<ProfileBrobizzRegisterViewModel> profileBrobizzRegisterViewModelProvider;
        private Provider<ProfileBrobizzViewModel> profileBrobizzViewModelProvider;
        private Provider<ProfileCreditCardsViewModel> profileCreditCardsViewModelProvider;
        private Provider<ProfileEditViewModel> profileEditViewModelProvider;
        private Provider<ProfileNewslettersViewModel> profileNewslettersViewModelProvider;
        private Provider<ProfilePassengerEditViewModel> profilePassengerEditViewModelProvider;
        private Provider<ProfilePassengersRegisterViewModel> profilePassengersRegisterViewModelProvider;
        private Provider<ProfilePassengersViewModel> profilePassengersViewModelProvider;
        private Provider<ProfileVehiclesEditViewModel> profileVehiclesEditViewModelProvider;
        private Provider<ProfileVehiclesRegisterViewModel> profileVehiclesRegisterViewModelProvider;
        private Provider<ProfileVehiclesViewModel> profileVehiclesViewModelProvider;
        private Provider<ProfileViewModel> profileViewModelProvider;
        private Provider<PushDialogViewModel> pushDialogViewModelProvider;
        private Provider<ReceiptViewModel> receiptViewModelProvider;
        private Provider<RefundReceiptViewModel> refundReceiptViewModelProvider;
        private Provider<ResetPasswordViewModel> resetPasswordViewModelProvider;
        private Provider<RouteSelectorKombardoViewModel> routeSelectorKombardoViewModelProvider;
        private Provider<RouteSelectorMolslinjenViewModel> routeSelectorMolslinjenViewModelProvider;
        private Provider<SaleOnBoardBarcodeDetailsViewModel> saleOnBoardBarcodeDetailsViewModelProvider;
        private Provider<SaleOnBoardBasketViewModel> saleOnBoardBasketViewModelProvider;
        private Provider<SaleOnBoardDepartureSelectorViewModel> saleOnBoardDepartureSelectorViewModelProvider;
        private Provider<SaleOnBoardFoodListViewModel> saleOnBoardFoodListViewModelProvider;
        private Provider<SaleOnBoardOrderDetailsViewModel> saleOnBoardOrderDetailsViewModelProvider;
        private Provider<SaleOnBoardOrderHistoryViewModel> saleOnBoardOrderHistoryViewModelProvider;
        private Provider<SaleOnBoardProductDetailsViewModel> saleOnBoardProductDetailsViewModelProvider;
        private Provider<SaleOnBoardReceiptViewModel> saleOnBoardReceiptViewModelProvider;
        private Provider<SaleOnBoardViewModel> saleOnBoardViewModelProvider;
        private final SavedStateHandle savedStateHandle;
        private Provider<SignupViewModel> signupViewModelProvider;
        private Provider<SimpleChangeAddonsViewModel> simpleChangeAddonsViewModelProvider;
        private Provider<SimpleChangeFoodViewModel> simpleChangeFoodViewModelProvider;
        private Provider<SimpleChangeReceiptViewModel> simpleChangeReceiptViewModelProvider;
        private Provider<SimpleChangeSummaryViewModel> simpleChangeSummaryViewModelProvider;
        private final SingletonCImpl singletonCImpl;
        private Provider<TicketDetailsViewModel> ticketDetailsViewModelProvider;
        private Provider<TicketHistoryViewModel> ticketHistoryViewModelProvider;
        private Provider<TicketTypeKombardoViewModel> ticketTypeKombardoViewModelProvider;
        private Provider<TicketTypeMolslinjenViewModel> ticketTypeMolslinjenViewModelProvider;
        private Provider<TicketsViewModel> ticketsViewModelProvider;
        private Provider<TopBarViewModel> topBarViewModelProvider;
        private Provider<TrailerSelectorViewModel> trailerSelectorViewModelProvider;
        private Provider<TransportProductSelectorViewModel> transportProductSelectorViewModelProvider;
        private Provider<TransportationSelectorViewModel> transportationSelectorViewModelProvider;
        private Provider<VehicleSelectorViewModel> vehicleSelectorViewModelProvider;
        private final ViewModelCImpl viewModelCImpl;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes2.dex */
        public static final class SwitchingProvider<T> implements Provider<T> {
            private final ActivityRetainedCImpl activityRetainedCImpl;
            private final int id;
            private final SingletonCImpl singletonCImpl;
            private final ViewModelCImpl viewModelCImpl;

            SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl, ViewModelCImpl viewModelCImpl, int i5) {
                this.singletonCImpl = singletonCImpl;
                this.activityRetainedCImpl = activityRetainedCImpl;
                this.viewModelCImpl = viewModelCImpl;
                this.id = i5;
            }

            private T get0() {
                switch (this.id) {
                    case 0:
                        return (T) new AccountActivationViewModel((IUserManager) this.singletonCImpl.bindUserManagerProvider.get(), this.viewModelCImpl.savedStateHandle);
                    case 1:
                        return (T) new AddExistingTicketViewModel((ISnackbarService) this.singletonCImpl.bindSnackbarServiceProvider.get(), (ITicketsManager) this.singletonCImpl.bindTicketsManagerProvider.get());
                    case 2:
                        return (T) new AddonsViewModel((ICheckoutManager) this.singletonCImpl.bindCheckoutManagerProvider.get(), this.singletonCImpl.addonHelper(), (ISelectSeatingManager) this.singletonCImpl.bindSeatReservationManagerProvider.get(), (ISnackbarService) this.singletonCImpl.bindSnackbarServiceProvider.get(), (ICheckoutNavigator) this.singletonCImpl.bindCheckoutNavigatorProvider.get(), (IEditManager) this.singletonCImpl.bindEditManagerProvider.get(), (IRouteManager) this.singletonCImpl.bindRouteManagerProvider.get(), (IDepartureManager) this.singletonCImpl.bindDepartureManagerProvider.get(), (IReturnManager) this.singletonCImpl.bindReturnManagerProvider.get(), (IPaymentManager) this.singletonCImpl.bindPaymentManagerProvider.get(), (IAnalyticsTracker) this.singletonCImpl.bindAnalyticsTrackerProvider.get(), this.viewModelCImpl.savedStateHandle);
                    case 3:
                        return (T) new AgreementsViewModel((IRouteManager) this.singletonCImpl.bindRouteManagerProvider.get(), (IBornholmCommuterManager) this.singletonCImpl.bindBornholmCommuterManagerProvider.get(), (IOeresundCommuterManager) this.singletonCImpl.bindOeresundCommuterManagerProvider.get(), (IMultiRideManager) this.singletonCImpl.bindMultiRideManagerProvider.get());
                    case 4:
                        return (T) new AssetsMergeViewModel((IUserManager) this.singletonCImpl.bindUserManagerProvider.get(), (ISnackbarService) this.singletonCImpl.bindSnackbarServiceProvider.get());
                    case 5:
                        return (T) new BarcodeDetailsViewModel(this.viewModelCImpl.savedStateHandle);
                    case 6:
                        return (T) new BookingSummaryViewModel((ICheckoutManager) this.singletonCImpl.bindCheckoutManagerProvider.get(), (IUserCreditCardsManager) this.singletonCImpl.bindUserCreditCardsManagerProvider.get(), (ISiteManager) this.singletonCImpl.bindSiteManagerProvider.get(), (ISnackbarService) this.singletonCImpl.bindSnackbarServiceProvider.get(), (IRouteManager) this.singletonCImpl.bindRouteManagerProvider.get(), (IDepartureManager) this.singletonCImpl.bindDepartureManagerProvider.get(), (IReturnManager) this.singletonCImpl.bindReturnManagerProvider.get(), (IEditManager) this.singletonCImpl.bindEditManagerProvider.get(), (IPaymentManager) this.singletonCImpl.bindPaymentManagerProvider.get(), this.singletonCImpl.summaryAddonHelper(), (IUserManager) this.singletonCImpl.bindUserManagerProvider.get(), (IAnalyticsTracker) this.singletonCImpl.bindAnalyticsTrackerProvider.get(), (ISplitTestManager) this.singletonCImpl.bindSplitTestManagerProvider.get());
                    case 7:
                        return (T) new BornholmCommuterAddViewModel((IBornholmCommuterManager) this.singletonCImpl.bindBornholmCommuterManagerProvider.get());
                    case 8:
                        return (T) new BornholmCommuterDetailsViewModel((IRouteManager) this.singletonCImpl.bindRouteManagerProvider.get(), (IBornholmCommuterManager) this.singletonCImpl.bindBornholmCommuterManagerProvider.get(), this.viewModelCImpl.savedStateHandle);
                    case 9:
                        return (T) new BornholmCommuterTicketHistoryViewModel((IBornholmCommuterManager) this.singletonCImpl.bindBornholmCommuterManagerProvider.get(), (ISnackbarService) this.singletonCImpl.bindSnackbarServiceProvider.get(), this.viewModelCImpl.savedStateHandle);
                    case 10:
                        return (T) new BottomBarViewModel((IBottomBarManager) this.singletonCImpl.bindBottomBarManagerProvider.get(), (IAnalyticsTracker) this.singletonCImpl.bindAnalyticsTrackerProvider.get());
                    case 11:
                        return (T) new CalendarViewModel(HandlerProviderModule_BindDepartureLowPriceHandlerFactory.bindDepartureLowPriceHandler(), (IRouteManager) this.singletonCImpl.bindRouteManagerProvider.get(), this.viewModelCImpl.savedStateHandle);
                    case 12:
                        return (T) new CargoDetailsViewModel(this.viewModelCImpl.savedStateHandle, (ISnackbarService) this.singletonCImpl.bindSnackbarServiceProvider.get(), (IRouteManager) this.singletonCImpl.bindRouteManagerProvider.get());
                    case 13:
                        return (T) new ChangePasswordViewModel((IUserManager) this.singletonCImpl.bindUserManagerProvider.get(), (ISnackbarService) this.singletonCImpl.bindSnackbarServiceProvider.get());
                    case 14:
                        return (T) new CheckoutDetailsViewModel((ICheckoutManager) this.singletonCImpl.bindCheckoutManagerProvider.get(), this.viewModelCImpl.savedStateHandle);
                    case 15:
                        return (T) new CheckoutPassengerCreateViewModel((IUserPassengerManager) this.singletonCImpl.bindUserPassengerManagerProvider.get(), (ICheckoutPassengerManager) this.singletonCImpl.bindCheckoutPassengerManagerProvider.get(), (IConfigurationManager) this.singletonCImpl.bindConfigurationManagerProvider.get(), this.viewModelCImpl.savedStateHandle);
                    case 16:
                        return (T) new CheckoutPassengerEditViewModel((IUserPassengerManager) this.singletonCImpl.bindUserPassengerManagerProvider.get(), (ICheckoutPassengerManager) this.singletonCImpl.bindCheckoutPassengerManagerProvider.get(), (IConfigurationManager) this.singletonCImpl.bindConfigurationManagerProvider.get(), this.viewModelCImpl.savedStateHandle);
                    case 17:
                        return (T) new CheckoutViewModel((ICheckoutNavigator) this.singletonCImpl.bindCheckoutNavigatorProvider.get(), (IReturnManager) this.singletonCImpl.bindReturnManagerProvider.get(), (ISplitTestManager) this.singletonCImpl.bindSplitTestManagerProvider.get(), this.singletonCImpl.analyticsTracker());
                    case 18:
                        return (T) new CommuterAddAgreementsViewModel((IBornholmCommuterManager) this.singletonCImpl.bindBornholmCommuterManagerProvider.get(), (IOeresundCommuterManager) this.singletonCImpl.bindOeresundCommuterManagerProvider.get(), (IUserManager) this.singletonCImpl.bindUserManagerProvider.get());
                    case 19:
                        return (T) new CommuterOverviewViewModel((IBornholmCommuterManager) this.singletonCImpl.bindBornholmCommuterManagerProvider.get(), (IOeresundCommuterManager) this.singletonCImpl.bindOeresundCommuterManagerProvider.get());
                    case 20:
                        return (T) new ContactScreenViewModel((ISiteManager) this.singletonCImpl.bindSiteManagerProvider.get(), (ISnackbarService) this.singletonCImpl.bindSnackbarServiceProvider.get(), this.viewModelCImpl.savedStateHandle, (IAnalyticsTracker) this.singletonCImpl.bindAnalyticsTrackerProvider.get());
                    case 21:
                        return (T) new CreateYourSelfAsPassengerViewModel((IUserManager) this.singletonCImpl.bindUserManagerProvider.get(), (ICheckoutPassengerManager) this.singletonCImpl.bindCheckoutPassengerManagerProvider.get(), (IConfigurationManager) this.singletonCImpl.bindConfigurationManagerProvider.get(), (ISiteManager) this.singletonCImpl.bindSiteManagerProvider.get(), (ICheckoutManager) this.singletonCImpl.bindCheckoutManagerProvider.get(), this.viewModelCImpl.savedStateHandle);
                    case 22:
                        return (T) new CurrenciesViewModel((ICurrencyManager) this.singletonCImpl.bindCurrencyManagerProvider.get(), (ISnackbarService) this.singletonCImpl.bindSnackbarServiceProvider.get());
                    case R$styleable.Toolbar_titleMarginBottom /* 23 */:
                        return (T) new DeepLinkViewModel(this.viewModelCImpl.savedStateHandle);
                    case R$styleable.Toolbar_titleMarginEnd /* 24 */:
                        return (T) new DeparturesViewModel((IRouteManager) this.singletonCImpl.bindRouteManagerProvider.get(), (IDepartureManager) this.singletonCImpl.bindDepartureManagerProvider.get(), (ISnackbarService) this.singletonCImpl.bindSnackbarServiceProvider.get(), (ILocationManager) this.singletonCImpl.bindLocationManagerProvider.get(), (IDirectionsManager) this.singletonCImpl.bindDirectionsManagerProvider.get(), (IReturnManager) this.singletonCImpl.bindReturnManagerProvider.get(), (IEditManager) this.singletonCImpl.bindEditManagerProvider.get(), (IPaymentManager) this.singletonCImpl.bindPaymentManagerProvider.get(), this.viewModelCImpl.savedStateHandle, (ICheckoutNavigator) this.singletonCImpl.bindCheckoutNavigatorProvider.get(), (ICompanyViewHelper) this.singletonCImpl.bindCompanyViewHelperProvider.get(), (IAnalyticsTracker) this.singletonCImpl.bindAnalyticsTrackerProvider.get(), (IUserManager) this.singletonCImpl.bindUserManagerProvider.get(), (IRouteLocationHelper) this.singletonCImpl.bindRouteLocationHelperProvider.get(), (ISplitTestManager) this.singletonCImpl.bindSplitTestManagerProvider.get());
                    case 25:
                        return (T) new DeveloperInputComponentsViewModel((ISnackbarService) this.singletonCImpl.bindSnackbarServiceProvider.get());
                    case 26:
                        return (T) new DeveloperViewModel((IApiProviderManager) this.singletonCImpl.bindApiProviderManagerProvider.get());
                    case 27:
                        return (T) new EarlyCheckInPassengerCreateViewModel((IUserPassengerManager) this.singletonCImpl.bindUserPassengerManagerProvider.get(), (IEarlyCheckInPassengerManager) this.singletonCImpl.bindEarlyCheckInPassengerManagerProvider.get(), (IConfigurationManager) this.singletonCImpl.bindConfigurationManagerProvider.get(), this.viewModelCImpl.savedStateHandle);
                    case 28:
                        return (T) new EarlyCheckInPassengerEditViewModel((IUserPassengerManager) this.singletonCImpl.bindUserPassengerManagerProvider.get(), (IEarlyCheckInPassengerManager) this.singletonCImpl.bindEarlyCheckInPassengerManagerProvider.get(), (IConfigurationManager) this.singletonCImpl.bindConfigurationManagerProvider.get(), this.viewModelCImpl.savedStateHandle);
                    case R$styleable.Toolbar_titleTextColor /* 29 */:
                        return (T) new EarlyCheckInPassengerSelectorViewModel((IEarlyCheckInPassengerManager) this.singletonCImpl.bindEarlyCheckInPassengerManagerProvider.get(), (ITicketsManager) this.singletonCImpl.bindTicketsManagerProvider.get(), (ISnackbarService) this.singletonCImpl.bindSnackbarServiceProvider.get());
                    case 30:
                        return (T) new EarlyCheckInProcessingViewModel((ISimpleChangeCheckoutManager) this.singletonCImpl.bindSimpleChangeCheckoutManagerProvider.get(), (ISnackbarService) this.singletonCImpl.bindSnackbarServiceProvider.get());
                    case 31:
                        return (T) new EarlyCheckInViewModel((ISnackbarService) this.singletonCImpl.bindSnackbarServiceProvider.get(), (ITicketsManager) this.singletonCImpl.bindTicketsManagerProvider.get(), (IUserVehiclesManager) this.singletonCImpl.bindUserVehiclesManagerProvider.get(), (IEarlyCheckInPassengerManager) this.singletonCImpl.bindEarlyCheckInPassengerManagerProvider.get(), (ISimpleChangeCheckoutManager) this.singletonCImpl.bindSimpleChangeCheckoutManagerProvider.get(), this.viewModelCImpl.savedStateHandle);
                    case 32:
                        return (T) new ErrorViewModel((IConfigurationManager) this.singletonCImpl.bindConfigurationManagerProvider.get());
                    case 33:
                        return (T) new FaqSubjectViewModel((IFaqManager) this.singletonCImpl.bindFaqManagerProvider.get(), this.viewModelCImpl.savedStateHandle, (IAnalyticsTracker) this.singletonCImpl.bindAnalyticsTrackerProvider.get());
                    case 34:
                        return (T) new FaqViewModel((IFaqManager) this.singletonCImpl.bindFaqManagerProvider.get(), (ISiteManager) this.singletonCImpl.bindSiteManagerProvider.get(), (ISnackbarService) this.singletonCImpl.bindSnackbarServiceProvider.get());
                    case 35:
                        return (T) new FerryFloorSectionViewModel((ISelectSeatingManager) this.singletonCImpl.bindSeatReservationManagerProvider.get(), (ISnackbarService) this.singletonCImpl.bindSnackbarServiceProvider.get(), (SelectSeatingHelperInterface) this.singletonCImpl.bindSelectSeatingHelperProvider.get(), this.viewModelCImpl.savedStateHandle);
                    case 36:
                        return (T) new FerrySectionSeatsViewModel((ISelectSeatingManager) this.singletonCImpl.bindSeatReservationManagerProvider.get(), (ISnackbarService) this.singletonCImpl.bindSnackbarServiceProvider.get(), (SelectSeatingHelperInterface) this.singletonCImpl.bindSelectSeatingHelperProvider.get(), ApplicationContextModule_ProvideContextFactory.provideContext(this.singletonCImpl.applicationContextModule), this.viewModelCImpl.savedStateHandle);
                    case 37:
                        return (T) new FoodBarcodeDetailsViewModel(this.viewModelCImpl.savedStateHandle, (ITicketsManager) this.singletonCImpl.bindTicketsManagerProvider.get());
                    case 38:
                        return (T) new FoodViewModel((ICheckoutManager) this.singletonCImpl.bindCheckoutManagerProvider.get(), this.singletonCImpl.addonHelper(), (ISnackbarService) this.singletonCImpl.bindSnackbarServiceProvider.get(), (ICheckoutNavigator) this.singletonCImpl.bindCheckoutNavigatorProvider.get(), (IEditManager) this.singletonCImpl.bindEditManagerProvider.get(), this.viewModelCImpl.savedStateHandle, (IRouteManager) this.singletonCImpl.bindRouteManagerProvider.get(), (IDepartureManager) this.singletonCImpl.bindDepartureManagerProvider.get(), (IReturnManager) this.singletonCImpl.bindReturnManagerProvider.get(), (IPaymentManager) this.singletonCImpl.bindPaymentManagerProvider.get(), (IAnalyticsTracker) this.singletonCImpl.bindAnalyticsTrackerProvider.get());
                    case 39:
                        return (T) new ForgotPasswordViewModel((IUserManager) this.singletonCImpl.bindUserManagerProvider.get(), (ISnackbarService) this.singletonCImpl.bindSnackbarServiceProvider.get());
                    case 40:
                        return (T) new InfoAlertViewModel((IRouteManager) this.singletonCImpl.bindRouteManagerProvider.get(), (IInfoAlertManager) this.singletonCImpl.bindInfoAlertManagerProvider.get());
                    case 41:
                        return (T) new LoginViewModel((IUserManager) this.singletonCImpl.bindUserManagerProvider.get(), (ISnackbarService) this.singletonCImpl.bindSnackbarServiceProvider.get(), (IAnalyticsTracker) this.singletonCImpl.bindAnalyticsTrackerProvider.get());
                    case 42:
                        return (T) new LoungeBarcodeDetailsViewModel(this.viewModelCImpl.savedStateHandle);
                    case 43:
                        return (T) new MainViewModel((ISettings) this.singletonCImpl.bindSettingsProvider.get(), (IBottomBarManager) this.singletonCImpl.bindBottomBarManagerProvider.get(), (ITopBarManager) this.singletonCImpl.bindTopBarManagerProvider.get(), (ISnackbarService) this.singletonCImpl.bindSnackbarServiceProvider.get(), this.singletonCImpl.onboardingNavigator(), (IAnalyticsTracker) this.singletonCImpl.bindAnalyticsTrackerProvider.get(), (IAppUpdater) this.singletonCImpl.bindAppUpdaterProvider.get(), (IMigrator) this.singletonCImpl.bindMigratorProvider.get());
                    case 44:
                        return (T) new ManuelForceUpdateViewModel();
                    case 45:
                        return (T) new MigrationErrorViewModel((IMigrator) this.singletonCImpl.bindMigratorProvider.get());
                    case 46:
                        return (T) new MultiRideAddCardViewModel((IMultiRideManager) this.singletonCImpl.bindMultiRideManagerProvider.get());
                    case 47:
                        return (T) new MultiRideDetailsViewModel((IMultiRideManager) this.singletonCImpl.bindMultiRideManagerProvider.get(), (IRouteManager) this.singletonCImpl.bindRouteManagerProvider.get(), (ISnackbarService) this.singletonCImpl.bindSnackbarServiceProvider.get(), this.viewModelCImpl.savedStateHandle);
                    case 48:
                        return (T) new MultiRideOverviewViewModel((IMultiRideManager) this.singletonCImpl.bindMultiRideManagerProvider.get());
                    case 49:
                        return (T) new MultiRidePurchaseReceiptViewModel((IMultiRideCardCheckoutManager) this.singletonCImpl.bindMultiRideCardCheckoutManagerProvider.get());
                    case 50:
                        return (T) new MultiRidePurchaseSummaryViewModel((IMultiRideCardCheckoutManager) this.singletonCImpl.bindMultiRideCardCheckoutManagerProvider.get(), (IPaymentManager) this.singletonCImpl.bindPaymentManagerProvider.get(), (IUserCreditCardsManager) this.singletonCImpl.bindUserCreditCardsManagerProvider.get(), (ISnackbarService) this.singletonCImpl.bindSnackbarServiceProvider.get(), (IAnalyticsTracker) this.singletonCImpl.bindAnalyticsTrackerProvider.get());
                    case 51:
                        return (T) new MultiRidePurchaseViewModel((IMultiRideCardCheckoutManager) this.singletonCImpl.bindMultiRideCardCheckoutManagerProvider.get(), (ISnackbarService) this.singletonCImpl.bindSnackbarServiceProvider.get(), this.viewModelCImpl.savedStateHandle, (IAnalyticsTracker) this.singletonCImpl.bindAnalyticsTrackerProvider.get());
                    case 52:
                        return (T) new MultiRideRefillViewModel((IMultiRideCardCheckoutManager) this.singletonCImpl.bindMultiRideCardCheckoutManagerProvider.get(), (ISnackbarService) this.singletonCImpl.bindSnackbarServiceProvider.get(), this.viewModelCImpl.savedStateHandle);
                    case 53:
                        return (T) new MultiRideTicketHistoryViewModel(this.singletonCImpl.multiRideManager(), (ISnackbarService) this.singletonCImpl.bindSnackbarServiceProvider.get(), this.viewModelCImpl.savedStateHandle);
                    case 54:
                        return (T) new NationalitySelectionViewModel();
                    case 55:
                        return (T) new OeresundCommuterDetailsViewModel((IOeresundCommuterManager) this.singletonCImpl.bindOeresundCommuterManagerProvider.get(), this.viewModelCImpl.savedStateHandle);
                    case 56:
                        return (T) new OnboardingLocationViewModel((IAnalyticsTracker) this.singletonCImpl.bindAnalyticsTrackerProvider.get(), (IUserManager) this.singletonCImpl.bindUserManagerProvider.get(), (ILocationManager) this.singletonCImpl.bindLocationManagerProvider.get());
                    case 57:
                        return (T) new OnboardingMarketingNotificationsViewModel((IPushHandlerProvider) this.singletonCImpl.bindPushHandlerProvider2.get(), (IMarketingNotificationManager) this.singletonCImpl.bindMarketingNotificationManagerProvider.get(), (IAnalyticsTracker) this.singletonCImpl.bindAnalyticsTrackerProvider.get(), (IUserManager) this.singletonCImpl.bindUserManagerProvider.get());
                    case 58:
                        return (T) new OnboardingNotificationViewModel((IPushHandler) this.singletonCImpl.bindPushHandlerProvider.get(), (IPushHandlerProvider) this.singletonCImpl.bindPushHandlerProvider2.get(), (IAnalyticsTracker) this.singletonCImpl.bindAnalyticsTrackerProvider.get(), (IUserManager) this.singletonCImpl.bindUserManagerProvider.get());
                    case 59:
                        return (T) new OnboardingSelectRouteViewModel((ISettings) this.singletonCImpl.bindSettingsProvider.get());
                    case 60:
                        return (T) new PassengerCountSelectorViewModel((ISnackbarService) this.singletonCImpl.bindSnackbarServiceProvider.get(), (IRouteManager) this.singletonCImpl.bindRouteManagerProvider.get(), (IReturnManager) this.singletonCImpl.bindReturnManagerProvider.get());
                    case 61:
                        return (T) new PassengerCountViewModel((ICheckoutManager) this.singletonCImpl.bindCheckoutManagerProvider.get(), (ICheckoutNavigator) this.singletonCImpl.bindCheckoutNavigatorProvider.get(), (IRouteManager) this.singletonCImpl.bindRouteManagerProvider.get(), (IDepartureManager) this.singletonCImpl.bindDepartureManagerProvider.get(), (IReturnManager) this.singletonCImpl.bindReturnManagerProvider.get(), (IEditManager) this.singletonCImpl.bindEditManagerProvider.get(), (IPaymentManager) this.singletonCImpl.bindPaymentManagerProvider.get(), (IAnalyticsTracker) this.singletonCImpl.bindAnalyticsTrackerProvider.get());
                    case 62:
                        return (T) new PassengersViewModel((ICheckoutManager) this.singletonCImpl.bindCheckoutManagerProvider.get(), (ICheckoutNavigator) this.singletonCImpl.bindCheckoutNavigatorProvider.get(), (ICheckoutPassengerManager) this.singletonCImpl.bindCheckoutPassengerManagerProvider.get(), (ISnackbarService) this.singletonCImpl.bindSnackbarServiceProvider.get(), (IUserManager) this.singletonCImpl.bindUserManagerProvider.get(), this.viewModelCImpl.savedStateHandle, (IRouteManager) this.singletonCImpl.bindRouteManagerProvider.get(), (IDepartureManager) this.singletonCImpl.bindDepartureManagerProvider.get(), (IReturnManager) this.singletonCImpl.bindReturnManagerProvider.get(), (IEditManager) this.singletonCImpl.bindEditManagerProvider.get(), (IPaymentManager) this.singletonCImpl.bindPaymentManagerProvider.get(), (IAnalyticsTracker) this.singletonCImpl.bindAnalyticsTrackerProvider.get(), (ISplitTestManager) this.singletonCImpl.bindSplitTestManagerProvider.get());
                    case Function.ALT_CONVENTION /* 63 */:
                        return (T) new PaymentViewModel((IPaymentManager) this.singletonCImpl.bindPaymentManagerProvider.get(), (ICheckoutManager) this.singletonCImpl.bindCheckoutManagerProvider.get(), (ISimpleChangeCheckoutManager) this.singletonCImpl.bindSimpleChangeCheckoutManagerProvider.get(), (IMultiRideCardCheckoutManager) this.singletonCImpl.bindMultiRideCardCheckoutManagerProvider.get(), (ISnackbarService) this.singletonCImpl.bindSnackbarServiceProvider.get(), (IRouteManager) this.singletonCImpl.bindRouteManagerProvider.get(), (IDepartureManager) this.singletonCImpl.bindDepartureManagerProvider.get(), (IReturnManager) this.singletonCImpl.bindReturnManagerProvider.get(), (IEditManager) this.singletonCImpl.bindEditManagerProvider.get(), (ISaleOnBoardCheckoutManager) this.singletonCImpl.bindSaleOnBoardCheckoutManagerProvider.get(), this.viewModelCImpl.savedStateHandle, (IAnalyticsTracker) this.singletonCImpl.bindAnalyticsTrackerProvider.get());
                    case Function.THROW_LAST_ERROR /* 64 */:
                        return (T) new PermissionsViewModel((IPushHandler) this.singletonCImpl.bindPushHandlerProvider.get(), (IPushHandlerProvider) this.singletonCImpl.bindPushHandlerProvider2.get(), (IAnalyticsTracker) this.singletonCImpl.bindAnalyticsTrackerProvider.get(), (IUserManager) this.singletonCImpl.bindUserManagerProvider.get(), (IMarketingNotificationManager) this.singletonCImpl.bindMarketingNotificationManagerProvider.get(), (ISettings) this.singletonCImpl.bindSettingsProvider.get());
                    case 65:
                        return (T) new PhoneNumberCodeSelectionViewModel((PhoneNumberUtil) this.singletonCImpl.bindPhoneNumberUtilProvider.get());
                    case 66:
                        return (T) new ProfileBrobizzRegisterViewModel((IUserBrobizzManager) this.singletonCImpl.bindUserBrobizzManagerProvider.get(), (ISnackbarService) this.singletonCImpl.bindSnackbarServiceProvider.get());
                    case 67:
                        return (T) new ProfileBrobizzViewModel((IUserBrobizzManager) this.singletonCImpl.bindUserBrobizzManagerProvider.get(), (ISnackbarService) this.singletonCImpl.bindSnackbarServiceProvider.get());
                    case 68:
                        return (T) new ProfileCreditCardsViewModel((IUserCreditCardsManager) this.singletonCImpl.bindUserCreditCardsManagerProvider.get(), (ISnackbarService) this.singletonCImpl.bindSnackbarServiceProvider.get(), (IAnalyticsTracker) this.singletonCImpl.bindAnalyticsTrackerProvider.get());
                    case 69:
                        return (T) new ProfileEditViewModel((IUserManager) this.singletonCImpl.bindUserManagerProvider.get(), (ISnackbarService) this.singletonCImpl.bindSnackbarServiceProvider.get(), (IAnalyticsTracker) this.singletonCImpl.bindAnalyticsTrackerProvider.get());
                    case 70:
                        return (T) new ProfileNewslettersViewModel((INewslettersManager) this.singletonCImpl.bindNewslettersManagerProvider.get(), (IUserManager) this.singletonCImpl.bindUserManagerProvider.get(), (ISnackbarService) this.singletonCImpl.bindSnackbarServiceProvider.get());
                    case 71:
                        return (T) new ProfilePassengerEditViewModel((IUserPassengerManager) this.singletonCImpl.bindUserPassengerManagerProvider.get(), this.viewModelCImpl.savedStateHandle);
                    case 72:
                        return (T) new ProfilePassengersRegisterViewModel((IUserPassengerManager) this.singletonCImpl.bindUserPassengerManagerProvider.get());
                    case 73:
                        return (T) new ProfilePassengersViewModel((IUserPassengerManager) this.singletonCImpl.bindUserPassengerManagerProvider.get(), (IUserManager) this.singletonCImpl.bindUserManagerProvider.get());
                    case 74:
                        return (T) new ProfileVehiclesEditViewModel((IUserVehiclesManager) this.singletonCImpl.bindUserVehiclesManagerProvider.get(), (ISnackbarService) this.singletonCImpl.bindSnackbarServiceProvider.get(), this.viewModelCImpl.savedStateHandle);
                    case 75:
                        return (T) new ProfileVehiclesRegisterViewModel((IUserVehiclesManager) this.singletonCImpl.bindUserVehiclesManagerProvider.get(), (ISnackbarService) this.singletonCImpl.bindSnackbarServiceProvider.get());
                    case 76:
                        return (T) new ProfileVehiclesViewModel((IUserVehiclesManager) this.singletonCImpl.bindUserVehiclesManagerProvider.get(), (IUserManager) this.singletonCImpl.bindUserManagerProvider.get(), (ISnackbarService) this.singletonCImpl.bindSnackbarServiceProvider.get());
                    case 77:
                        return (T) new ProfileViewModel((ISettings) this.singletonCImpl.bindSettingsProvider.get(), (IUserManager) this.singletonCImpl.bindUserManagerProvider.get(), (IApiProviderManager) this.singletonCImpl.bindApiProviderManagerProvider.get(), ApplicationContextModule_ProvideContextFactory.provideContext(this.singletonCImpl.applicationContextModule), (IAnalyticsTracker) this.singletonCImpl.bindAnalyticsTrackerProvider.get());
                    case 78:
                        return (T) new PushDialogViewModel((INotificationManager) this.singletonCImpl.bindNotificationManagerProvider.get());
                    case 79:
                        return (T) new ReceiptViewModel((ICheckoutManager) this.singletonCImpl.bindCheckoutManagerProvider.get(), (IUserManager) this.singletonCImpl.bindUserManagerProvider.get(), (IDepartureManager) this.singletonCImpl.bindDepartureManagerProvider.get(), (IRouteManager) this.singletonCImpl.bindRouteManagerProvider.get(), (IReturnManager) this.singletonCImpl.bindReturnManagerProvider.get(), (IEditManager) this.singletonCImpl.bindEditManagerProvider.get(), (IAnalyticsTracker) this.singletonCImpl.bindAnalyticsTrackerProvider.get());
                    case 80:
                        return (T) new RefundReceiptViewModel((ITicketsManager) this.singletonCImpl.bindTicketsManagerProvider.get());
                    case 81:
                        return (T) new ResetPasswordViewModel((IUserManager) this.singletonCImpl.bindUserManagerProvider.get(), (ISnackbarService) this.singletonCImpl.bindSnackbarServiceProvider.get(), this.viewModelCImpl.savedStateHandle);
                    case 82:
                        return (T) new RouteSelectorKombardoViewModel(this.viewModelCImpl.savedStateHandle, (IRouteManager) this.singletonCImpl.bindRouteManagerProvider.get(), (ILocationManager) this.singletonCImpl.bindLocationManagerProvider.get(), (IDirectionsManager) this.singletonCImpl.bindDirectionsManagerProvider.get(), (IConfigurationManager) this.singletonCImpl.bindConfigurationManagerProvider.get(), ApplicationContextModule_ProvideContextFactory.provideContext(this.singletonCImpl.applicationContextModule));
                    case 83:
                        return (T) new RouteSelectorMolslinjenViewModel((IRouteManager) this.singletonCImpl.bindRouteManagerProvider.get(), (IConfigurationManager) this.singletonCImpl.bindConfigurationManagerProvider.get(), (IRouteLocationHelper) this.singletonCImpl.bindRouteLocationHelperProvider.get(), (ILocationManager) this.singletonCImpl.bindLocationManagerProvider.get());
                    case 84:
                        return (T) new SaleOnBoardBarcodeDetailsViewModel(this.viewModelCImpl.savedStateHandle, (ISaleOnBoardManager) this.singletonCImpl.bindSaleOnBoardManagerProvider.get());
                    case 85:
                        return (T) new SaleOnBoardBasketViewModel((ISnackbarService) this.singletonCImpl.bindSnackbarServiceProvider.get(), (ISaleOnBoardCheckoutManager) this.singletonCImpl.bindSaleOnBoardCheckoutManagerProvider.get(), (IPaymentManager) this.singletonCImpl.bindPaymentManagerProvider.get(), (IUserCreditCardsManager) this.singletonCImpl.bindUserCreditCardsManagerProvider.get(), (IPushHandler) this.singletonCImpl.bindPushHandlerProvider.get(), (ISiteManager) this.singletonCImpl.bindSiteManagerProvider.get(), (IAnalyticsTracker) this.singletonCImpl.bindAnalyticsTrackerProvider.get());
                    case 86:
                        return (T) new SaleOnBoardDepartureSelectorViewModel((ISaleOnBoardCheckoutManager) this.singletonCImpl.bindSaleOnBoardCheckoutManagerProvider.get(), (ISaleOnBoardRouteManager) this.singletonCImpl.bindSaleOnBoardRouteManagerProvider.get(), (ISaleOnBoardDepartureManager) this.singletonCImpl.bindSaleOnBoardDepartureManagerProvider.get(), (IRouteLocationHelper) this.singletonCImpl.bindRouteLocationHelperProvider.get(), (ISplitTestManager) this.singletonCImpl.bindSplitTestManagerProvider.get());
                    case 87:
                        return (T) new SaleOnBoardFoodListViewModel((ISaleOnBoardCheckoutManager) this.singletonCImpl.bindSaleOnBoardCheckoutManagerProvider.get(), (IAnalyticsTracker) this.singletonCImpl.bindAnalyticsTrackerProvider.get());
                    case 88:
                        return (T) new SaleOnBoardOrderDetailsViewModel((ISaleOnBoardManager) this.singletonCImpl.bindSaleOnBoardManagerProvider.get(), this.viewModelCImpl.savedStateHandle, (ISnackbarService) this.singletonCImpl.bindSnackbarServiceProvider.get(), (IAnalyticsTracker) this.singletonCImpl.bindAnalyticsTrackerProvider.get());
                    case 89:
                        return (T) new SaleOnBoardOrderHistoryViewModel((ISaleOnBoardManager) this.singletonCImpl.bindSaleOnBoardManagerProvider.get());
                    case 90:
                        return (T) new SaleOnBoardProductDetailsViewModel((ISaleOnBoardCheckoutManager) this.singletonCImpl.bindSaleOnBoardCheckoutManagerProvider.get(), this.viewModelCImpl.savedStateHandle, (ISnackbarService) this.singletonCImpl.bindSnackbarServiceProvider.get(), (IAnalyticsTracker) this.singletonCImpl.bindAnalyticsTrackerProvider.get());
                    case 91:
                        return (T) new SaleOnBoardReceiptViewModel((ISaleOnBoardCheckoutManager) this.singletonCImpl.bindSaleOnBoardCheckoutManagerProvider.get());
                    case 92:
                        return (T) new SaleOnBoardViewModel((ITicketsManager) this.singletonCImpl.bindTicketsManagerProvider.get(), (ISaleOnBoardCheckoutManager) this.singletonCImpl.bindSaleOnBoardCheckoutManagerProvider.get(), (ISaleOnBoardManager) this.singletonCImpl.bindSaleOnBoardManagerProvider.get());
                    case 93:
                        return (T) new SignupViewModel((IUserManager) this.singletonCImpl.bindUserManagerProvider.get(), (ISiteManager) this.singletonCImpl.bindSiteManagerProvider.get(), (ISnackbarService) this.singletonCImpl.bindSnackbarServiceProvider.get(), (IAnalyticsTracker) this.singletonCImpl.bindAnalyticsTrackerProvider.get(), (PhoneNumberUtil) this.singletonCImpl.bindPhoneNumberUtilProvider.get());
                    case 94:
                        return (T) new SimpleChangeAddonsViewModel(this.singletonCImpl.addonHelper(), (ISnackbarService) this.singletonCImpl.bindSnackbarServiceProvider.get(), (ISimpleChangeCheckoutManager) this.singletonCImpl.bindSimpleChangeCheckoutManagerProvider.get());
                    case 95:
                        return (T) new SimpleChangeFoodViewModel(this.singletonCImpl.addonHelper(), (ISnackbarService) this.singletonCImpl.bindSnackbarServiceProvider.get(), (ISimpleChangeCheckoutManager) this.singletonCImpl.bindSimpleChangeCheckoutManagerProvider.get());
                    case 96:
                        return (T) new SimpleChangeReceiptViewModel((ISimpleChangeCheckoutManager) this.singletonCImpl.bindSimpleChangeCheckoutManagerProvider.get());
                    case 97:
                        return (T) new SimpleChangeSummaryViewModel((ISnackbarService) this.singletonCImpl.bindSnackbarServiceProvider.get(), (IUserCreditCardsManager) this.singletonCImpl.bindUserCreditCardsManagerProvider.get(), (IPaymentManager) this.singletonCImpl.bindPaymentManagerProvider.get(), (ISimpleChangeCheckoutManager) this.singletonCImpl.bindSimpleChangeCheckoutManagerProvider.get(), (ISiteManager) this.singletonCImpl.bindSiteManagerProvider.get());
                    case 98:
                        return (T) new TicketDetailsViewModel(this.viewModelCImpl.savedStateHandle, (ISnackbarService) this.singletonCImpl.bindSnackbarServiceProvider.get(), (ITicketsManager) this.singletonCImpl.bindTicketsManagerProvider.get(), (IUserManager) this.singletonCImpl.bindUserManagerProvider.get(), (IConfigurationManager) this.singletonCImpl.bindConfigurationManagerProvider.get(), (ISimpleChangeCheckoutManager) this.singletonCImpl.bindSimpleChangeCheckoutManagerProvider.get(), (IEditManager) this.singletonCImpl.bindEditManagerProvider.get(), (ISaleOnBoardManager) this.singletonCImpl.bindSaleOnBoardManagerProvider.get(), ApplicationContextModule_ProvideContextFactory.provideContext(this.singletonCImpl.applicationContextModule));
                    case 99:
                        return (T) new TicketHistoryViewModel((ITicketsManager) this.singletonCImpl.bindTicketsManagerProvider.get(), (ISnackbarService) this.singletonCImpl.bindSnackbarServiceProvider.get());
                    default:
                        throw new AssertionError(this.id);
                }
            }

            private T get1() {
                switch (this.id) {
                    case 100:
                        return (T) new TicketTypeKombardoViewModel(this.viewModelCImpl.savedStateHandle, (IDepartureManager) this.singletonCImpl.bindDepartureManagerProvider.get(), (IRouteManager) this.singletonCImpl.bindRouteManagerProvider.get(), ApplicationContextModule_ProvideContextFactory.provideContext(this.singletonCImpl.applicationContextModule), (ICheckoutNavigator) this.singletonCImpl.bindCheckoutNavigatorProvider.get(), (IAnalyticsTracker) this.singletonCImpl.bindAnalyticsTrackerProvider.get(), (IEditManager) this.singletonCImpl.bindEditManagerProvider.get());
                    case 101:
                        return (T) new TicketTypeMolslinjenViewModel(this.viewModelCImpl.savedStateHandle, (IDepartureManager) this.singletonCImpl.bindDepartureManagerProvider.get(), (IRouteManager) this.singletonCImpl.bindRouteManagerProvider.get(), (ICheckoutNavigator) this.singletonCImpl.bindCheckoutNavigatorProvider.get(), (IEditManager) this.singletonCImpl.bindEditManagerProvider.get(), (IAnalyticsTracker) this.singletonCImpl.bindAnalyticsTrackerProvider.get());
                    case 102:
                        return (T) new TicketsViewModel((ITicketsManager) this.singletonCImpl.bindTicketsManagerProvider.get(), (ISnackbarService) this.singletonCImpl.bindSnackbarServiceProvider.get(), (IConfigurationManager) this.singletonCImpl.bindConfigurationManagerProvider.get());
                    case 103:
                        return (T) new TopBarViewModel((ITopBarManager) this.singletonCImpl.bindTopBarManagerProvider.get());
                    case 104:
                        return (T) new TrailerSelectorViewModel((IRouteManager) this.singletonCImpl.bindRouteManagerProvider.get(), (ISnackbarService) this.singletonCImpl.bindSnackbarServiceProvider.get(), (IReturnManager) this.singletonCImpl.bindReturnManagerProvider.get());
                    case 105:
                        return (T) new TransportProductSelectorViewModel((IRouteManager) this.singletonCImpl.bindRouteManagerProvider.get(), (ISnackbarService) this.singletonCImpl.bindSnackbarServiceProvider.get(), (IReturnManager) this.singletonCImpl.bindReturnManagerProvider.get());
                    case 106:
                        return (T) new TransportationSelectorViewModel((ISnackbarService) this.singletonCImpl.bindSnackbarServiceProvider.get(), (IRouteManager) this.singletonCImpl.bindRouteManagerProvider.get());
                    case 107:
                        return (T) new VehicleSelectorViewModel((IUserVehiclesManager) this.singletonCImpl.bindUserVehiclesManagerProvider.get(), (ISnackbarService) this.singletonCImpl.bindSnackbarServiceProvider.get(), (IConfigurationManager) this.singletonCImpl.bindConfigurationManagerProvider.get(), this.viewModelCImpl.savedStateHandle);
                    default:
                        throw new AssertionError(this.id);
                }
            }

            @Override // javax.inject.Provider
            public T get() {
                int i5 = this.id / 100;
                if (i5 == 0) {
                    return get0();
                }
                if (i5 == 1) {
                    return get1();
                }
                throw new AssertionError(this.id);
            }
        }

        private void initialize(SavedStateHandle savedStateHandle, ViewModelLifecycle viewModelLifecycle) {
            this.accountActivationViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 0);
            this.addExistingTicketViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 1);
            this.addonsViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 2);
            this.agreementsViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 3);
            this.assetsMergeViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 4);
            this.barcodeDetailsViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 5);
            this.bookingSummaryViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 6);
            this.bornholmCommuterAddViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 7);
            this.bornholmCommuterDetailsViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 8);
            this.bornholmCommuterTicketHistoryViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 9);
            this.bottomBarViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 10);
            this.calendarViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 11);
            this.cargoDetailsViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 12);
            this.changePasswordViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 13);
            this.checkoutDetailsViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 14);
            this.checkoutPassengerCreateViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 15);
            this.checkoutPassengerEditViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 16);
            this.checkoutViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 17);
            this.commuterAddAgreementsViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 18);
            this.commuterOverviewViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 19);
            this.contactScreenViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 20);
            this.createYourSelfAsPassengerViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 21);
            this.currenciesViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 22);
            this.deepLinkViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 23);
            this.departuresViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 24);
        }

        private void initialize2(SavedStateHandle savedStateHandle, ViewModelLifecycle viewModelLifecycle) {
            this.developerInputComponentsViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 25);
            this.developerViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 26);
            this.earlyCheckInPassengerCreateViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 27);
            this.earlyCheckInPassengerEditViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 28);
            this.earlyCheckInPassengerSelectorViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 29);
            this.earlyCheckInProcessingViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 30);
            this.earlyCheckInViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 31);
            this.errorViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 32);
            this.faqSubjectViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 33);
            this.faqViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 34);
            this.ferryFloorSectionViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 35);
            this.ferrySectionSeatsViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 36);
            this.foodBarcodeDetailsViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 37);
            this.foodViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 38);
            this.forgotPasswordViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 39);
            this.infoAlertViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 40);
            this.loginViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 41);
            this.loungeBarcodeDetailsViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 42);
            this.mainViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 43);
            this.manuelForceUpdateViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 44);
            this.migrationErrorViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 45);
            this.multiRideAddCardViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 46);
            this.multiRideDetailsViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 47);
            this.multiRideOverviewViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 48);
            this.multiRidePurchaseReceiptViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 49);
        }

        private void initialize3(SavedStateHandle savedStateHandle, ViewModelLifecycle viewModelLifecycle) {
            this.multiRidePurchaseSummaryViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 50);
            this.multiRidePurchaseViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 51);
            this.multiRideRefillViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 52);
            this.multiRideTicketHistoryViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 53);
            this.nationalitySelectionViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 54);
            this.oeresundCommuterDetailsViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 55);
            this.onboardingLocationViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 56);
            this.onboardingMarketingNotificationsViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 57);
            this.onboardingNotificationViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 58);
            this.onboardingSelectRouteViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 59);
            this.passengerCountSelectorViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 60);
            this.passengerCountViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 61);
            this.passengersViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 62);
            this.paymentViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 63);
            this.permissionsViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 64);
            this.phoneNumberCodeSelectionViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 65);
            this.profileBrobizzRegisterViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 66);
            this.profileBrobizzViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 67);
            this.profileCreditCardsViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 68);
            this.profileEditViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 69);
            this.profileNewslettersViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 70);
            this.profilePassengerEditViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 71);
            this.profilePassengersRegisterViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 72);
            this.profilePassengersViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 73);
            this.profileVehiclesEditViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 74);
        }

        private void initialize4(SavedStateHandle savedStateHandle, ViewModelLifecycle viewModelLifecycle) {
            this.profileVehiclesRegisterViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 75);
            this.profileVehiclesViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 76);
            this.profileViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 77);
            this.pushDialogViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 78);
            this.receiptViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 79);
            this.refundReceiptViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 80);
            this.resetPasswordViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 81);
            this.routeSelectorKombardoViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 82);
            this.routeSelectorMolslinjenViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 83);
            this.saleOnBoardBarcodeDetailsViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 84);
            this.saleOnBoardBasketViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 85);
            this.saleOnBoardDepartureSelectorViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 86);
            this.saleOnBoardFoodListViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 87);
            this.saleOnBoardOrderDetailsViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 88);
            this.saleOnBoardOrderHistoryViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 89);
            this.saleOnBoardProductDetailsViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 90);
            this.saleOnBoardReceiptViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 91);
            this.saleOnBoardViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 92);
            this.signupViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 93);
            this.simpleChangeAddonsViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 94);
            this.simpleChangeFoodViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 95);
            this.simpleChangeReceiptViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 96);
            this.simpleChangeSummaryViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 97);
            this.ticketDetailsViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 98);
            this.ticketHistoryViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 99);
        }

        private void initialize5(SavedStateHandle savedStateHandle, ViewModelLifecycle viewModelLifecycle) {
            this.ticketTypeKombardoViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 100);
            this.ticketTypeMolslinjenViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 101);
            this.ticketsViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 102);
            this.topBarViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 103);
            this.trailerSelectorViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 104);
            this.transportProductSelectorViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 105);
            this.transportationSelectorViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 106);
            this.vehicleSelectorViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 107);
        }

        @Override // dagger.hilt.android.internal.lifecycle.HiltViewModelFactory.ViewModelFactoriesEntryPoint
        public Map<Class<?>, Object> getHiltViewModelAssistedMap() {
            return ImmutableMap.of();
        }

        @Override // dagger.hilt.android.internal.lifecycle.HiltViewModelFactory.ViewModelFactoriesEntryPoint
        public Map<Class<?>, javax.inject.Provider<ViewModel>> getHiltViewModelMap() {
            return LazyClassKeyMap.of(ImmutableMap.builderWithExpectedSize(108).put(AccountActivationViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.accountActivationViewModelProvider).put(AddExistingTicketViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.addExistingTicketViewModelProvider).put(AddonsViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.addonsViewModelProvider).put(AgreementsViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.agreementsViewModelProvider).put(AssetsMergeViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.assetsMergeViewModelProvider).put(BarcodeDetailsViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.barcodeDetailsViewModelProvider).put(BookingSummaryViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.bookingSummaryViewModelProvider).put(BornholmCommuterAddViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.bornholmCommuterAddViewModelProvider).put(BornholmCommuterDetailsViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.bornholmCommuterDetailsViewModelProvider).put(BornholmCommuterTicketHistoryViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.bornholmCommuterTicketHistoryViewModelProvider).put(BottomBarViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.bottomBarViewModelProvider).put(CalendarViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.calendarViewModelProvider).put(CargoDetailsViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.cargoDetailsViewModelProvider).put(ChangePasswordViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.changePasswordViewModelProvider).put(CheckoutDetailsViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.checkoutDetailsViewModelProvider).put(CheckoutPassengerCreateViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.checkoutPassengerCreateViewModelProvider).put(CheckoutPassengerEditViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.checkoutPassengerEditViewModelProvider).put(CheckoutViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.checkoutViewModelProvider).put(CommuterAddAgreementsViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.commuterAddAgreementsViewModelProvider).put(CommuterOverviewViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.commuterOverviewViewModelProvider).put(ContactScreenViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.contactScreenViewModelProvider).put(CreateYourSelfAsPassengerViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.createYourSelfAsPassengerViewModelProvider).put(CurrenciesViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.currenciesViewModelProvider).put(DeepLinkViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.deepLinkViewModelProvider).put(DeparturesViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.departuresViewModelProvider).put(DeveloperInputComponentsViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.developerInputComponentsViewModelProvider).put(DeveloperViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.developerViewModelProvider).put(EarlyCheckInPassengerCreateViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.earlyCheckInPassengerCreateViewModelProvider).put(EarlyCheckInPassengerEditViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.earlyCheckInPassengerEditViewModelProvider).put(EarlyCheckInPassengerSelectorViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.earlyCheckInPassengerSelectorViewModelProvider).put(EarlyCheckInProcessingViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.earlyCheckInProcessingViewModelProvider).put(EarlyCheckInViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.earlyCheckInViewModelProvider).put(ErrorViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.errorViewModelProvider).put(FaqSubjectViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.faqSubjectViewModelProvider).put(FaqViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.faqViewModelProvider).put(FerryFloorSectionViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.ferryFloorSectionViewModelProvider).put(FerrySectionSeatsViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.ferrySectionSeatsViewModelProvider).put(FoodBarcodeDetailsViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.foodBarcodeDetailsViewModelProvider).put(FoodViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.foodViewModelProvider).put(ForgotPasswordViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.forgotPasswordViewModelProvider).put(InfoAlertViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.infoAlertViewModelProvider).put(LoginViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.loginViewModelProvider).put(LoungeBarcodeDetailsViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.loungeBarcodeDetailsViewModelProvider).put(MainViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.mainViewModelProvider).put(ManuelForceUpdateViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.manuelForceUpdateViewModelProvider).put(MigrationErrorViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.migrationErrorViewModelProvider).put(MultiRideAddCardViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.multiRideAddCardViewModelProvider).put(MultiRideDetailsViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.multiRideDetailsViewModelProvider).put(MultiRideOverviewViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.multiRideOverviewViewModelProvider).put(MultiRidePurchaseReceiptViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.multiRidePurchaseReceiptViewModelProvider).put(MultiRidePurchaseSummaryViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.multiRidePurchaseSummaryViewModelProvider).put(MultiRidePurchaseViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.multiRidePurchaseViewModelProvider).put(MultiRideRefillViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.multiRideRefillViewModelProvider).put(MultiRideTicketHistoryViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.multiRideTicketHistoryViewModelProvider).put(NationalitySelectionViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.nationalitySelectionViewModelProvider).put(OeresundCommuterDetailsViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.oeresundCommuterDetailsViewModelProvider).put(OnboardingLocationViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.onboardingLocationViewModelProvider).put(OnboardingMarketingNotificationsViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.onboardingMarketingNotificationsViewModelProvider).put(OnboardingNotificationViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.onboardingNotificationViewModelProvider).put(OnboardingSelectRouteViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.onboardingSelectRouteViewModelProvider).put(PassengerCountSelectorViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.passengerCountSelectorViewModelProvider).put(PassengerCountViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.passengerCountViewModelProvider).put(PassengersViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.passengersViewModelProvider).put(PaymentViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.paymentViewModelProvider).put(PermissionsViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.permissionsViewModelProvider).put(PhoneNumberCodeSelectionViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.phoneNumberCodeSelectionViewModelProvider).put(ProfileBrobizzRegisterViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.profileBrobizzRegisterViewModelProvider).put(ProfileBrobizzViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.profileBrobizzViewModelProvider).put(ProfileCreditCardsViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.profileCreditCardsViewModelProvider).put(ProfileEditViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.profileEditViewModelProvider).put(ProfileNewslettersViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.profileNewslettersViewModelProvider).put(ProfilePassengerEditViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.profilePassengerEditViewModelProvider).put(ProfilePassengersRegisterViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.profilePassengersRegisterViewModelProvider).put(ProfilePassengersViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.profilePassengersViewModelProvider).put(ProfileVehiclesEditViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.profileVehiclesEditViewModelProvider).put(ProfileVehiclesRegisterViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.profileVehiclesRegisterViewModelProvider).put(ProfileVehiclesViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.profileVehiclesViewModelProvider).put(ProfileViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.profileViewModelProvider).put(PushDialogViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.pushDialogViewModelProvider).put(ReceiptViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.receiptViewModelProvider).put(RefundReceiptViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.refundReceiptViewModelProvider).put(ResetPasswordViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.resetPasswordViewModelProvider).put(RouteSelectorKombardoViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.routeSelectorKombardoViewModelProvider).put(RouteSelectorMolslinjenViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.routeSelectorMolslinjenViewModelProvider).put(SaleOnBoardBarcodeDetailsViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.saleOnBoardBarcodeDetailsViewModelProvider).put(SaleOnBoardBasketViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.saleOnBoardBasketViewModelProvider).put(SaleOnBoardDepartureSelectorViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.saleOnBoardDepartureSelectorViewModelProvider).put(SaleOnBoardFoodListViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.saleOnBoardFoodListViewModelProvider).put(SaleOnBoardOrderDetailsViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.saleOnBoardOrderDetailsViewModelProvider).put(SaleOnBoardOrderHistoryViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.saleOnBoardOrderHistoryViewModelProvider).put(SaleOnBoardProductDetailsViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.saleOnBoardProductDetailsViewModelProvider).put(SaleOnBoardReceiptViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.saleOnBoardReceiptViewModelProvider).put(SaleOnBoardViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.saleOnBoardViewModelProvider).put(SignupViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.signupViewModelProvider).put(SimpleChangeAddonsViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.simpleChangeAddonsViewModelProvider).put(SimpleChangeFoodViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.simpleChangeFoodViewModelProvider).put(SimpleChangeReceiptViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.simpleChangeReceiptViewModelProvider).put(SimpleChangeSummaryViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.simpleChangeSummaryViewModelProvider).put(TicketDetailsViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.ticketDetailsViewModelProvider).put(TicketHistoryViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.ticketHistoryViewModelProvider).put(TicketTypeKombardoViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.ticketTypeKombardoViewModelProvider).put(TicketTypeMolslinjenViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.ticketTypeMolslinjenViewModelProvider).put(TicketsViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.ticketsViewModelProvider).put(TopBarViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.topBarViewModelProvider).put(TrailerSelectorViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.trailerSelectorViewModelProvider).put(TransportProductSelectorViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.transportProductSelectorViewModelProvider).put(TransportationSelectorViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.transportationSelectorViewModelProvider).put(VehicleSelectorViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.vehicleSelectorViewModelProvider).build());
        }

        private ViewModelCImpl(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl, SavedStateHandle savedStateHandle, ViewModelLifecycle viewModelLifecycle) {
            this.viewModelCImpl = this;
            this.singletonCImpl = singletonCImpl;
            this.activityRetainedCImpl = activityRetainedCImpl;
            this.savedStateHandle = savedStateHandle;
            initialize(savedStateHandle, viewModelLifecycle);
            initialize2(savedStateHandle, viewModelLifecycle);
            initialize3(savedStateHandle, viewModelLifecycle);
            initialize4(savedStateHandle, viewModelLifecycle);
            initialize5(savedStateHandle, viewModelLifecycle);
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
