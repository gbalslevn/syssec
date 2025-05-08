package dk.molslinjen.api.hilt;

import dk.molslinjen.api.INetworkManager;
import dk.molslinjen.api.NetworkManager;
import dk.molslinjen.api.services.account.AccountApi;
import dk.molslinjen.api.services.account.booking.AccountBookingsApi;
import dk.molslinjen.api.services.account.brobizz.AccountBrobizzApi;
import dk.molslinjen.api.services.account.creditcard.AccountCreditCardsApi;
import dk.molslinjen.api.services.account.passenger.AccountPassengersApi;
import dk.molslinjen.api.services.account.vehicle.AccountVehiclesApi;
import dk.molslinjen.api.services.booking.BookingApi;
import dk.molslinjen.api.services.commuter.bornholm.BornholmCommuterApi;
import dk.molslinjen.api.services.commuter.oeresund.OeresundCommuterApi;
import dk.molslinjen.api.services.config.ConfigApi;
import dk.molslinjen.api.services.faq.FaqApi;
import dk.molslinjen.api.services.forceUpdate.ForceUpdateApi;
import dk.molslinjen.api.services.geolocator.GeoLocatorApi;
import dk.molslinjen.api.services.info.InfoApi;
import dk.molslinjen.api.services.multiRide.AccountMultiRideApi;
import dk.molslinjen.api.services.multiRide.MultiRideApi;
import dk.molslinjen.api.services.newsletters.NewslettersApi;
import dk.molslinjen.api.services.notifications.NotificationApi;
import dk.molslinjen.api.services.payment.PaymentApi;
import dk.molslinjen.api.services.paymentTypes.PaymentTypesApi;
import dk.molslinjen.api.services.saleOnBoard.SaleOnBoardApi;
import dk.molslinjen.core.providers.IApiInfoProvider;
import dk.molslinjen.core.version.AppVersionProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\u0015\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u0001¢\u0006\u0002\b\rJ\u0015\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u0005H\u0001¢\u0006\u0002\b\u0010J\u0015\u0010\u0011\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u0005H\u0001¢\u0006\u0002\b\u0013J\u0015\u0010\u0014\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\u0005H\u0001¢\u0006\u0002\b\u0016J\u0015\u0010\u0017\u001a\u00020\u00182\u0006\u0010\f\u001a\u00020\u0005H\u0001¢\u0006\u0002\b\u0019J\u0015\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\f\u001a\u00020\u0005H\u0001¢\u0006\u0002\b\u001cJ\u0015\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\f\u001a\u00020\u0005H\u0001¢\u0006\u0002\b\u001fJ\u0015\u0010 \u001a\u00020!2\u0006\u0010\f\u001a\u00020\u0005H\u0001¢\u0006\u0002\b\"J\u0015\u0010#\u001a\u00020$2\u0006\u0010\f\u001a\u00020\u0005H\u0001¢\u0006\u0002\b%J\u0015\u0010&\u001a\u00020'2\u0006\u0010\f\u001a\u00020\u0005H\u0001¢\u0006\u0002\b(J\u0015\u0010)\u001a\u00020*2\u0006\u0010\f\u001a\u00020\u0005H\u0001¢\u0006\u0002\b+J\u0015\u0010,\u001a\u00020-2\u0006\u0010\f\u001a\u00020\u0005H\u0001¢\u0006\u0002\b.J\u0015\u0010/\u001a\u0002002\u0006\u0010\f\u001a\u00020\u0005H\u0001¢\u0006\u0002\b1J\u0015\u00102\u001a\u0002032\u0006\u0010\f\u001a\u00020\u0005H\u0001¢\u0006\u0002\b4J\u0015\u00105\u001a\u0002062\u0006\u0010\f\u001a\u00020\u0005H\u0001¢\u0006\u0002\b7J\u0015\u00108\u001a\u0002092\u0006\u0010\f\u001a\u00020\u0005H\u0001¢\u0006\u0002\b:J\u0015\u0010;\u001a\u00020<2\u0006\u0010\f\u001a\u00020\u0005H\u0001¢\u0006\u0002\b=J\u0010\u0010>\u001a\u00020?2\u0006\u0010\f\u001a\u00020\u0005H\u0007J\u0010\u0010@\u001a\u00020A2\u0006\u0010\f\u001a\u00020\u0005H\u0007J\u0010\u0010B\u001a\u00020C2\u0006\u0010\f\u001a\u00020\u0005H\u0007J\u0010\u0010D\u001a\u00020E2\u0006\u0010\f\u001a\u00020\u0005H\u0007¨\u0006F"}, d2 = {"Ldk/molslinjen/api/hilt/ApiClientModule;", BuildConfig.FLAVOR, "<init>", "()V", "bindNetworkManager", "Ldk/molslinjen/api/INetworkManager;", "apiInfoProvider", "Ldk/molslinjen/core/providers/IApiInfoProvider;", "appVersionProvider", "Ldk/molslinjen/core/version/AppVersionProvider;", "bindForceUpdateApi", "Ldk/molslinjen/api/services/forceUpdate/ForceUpdateApi;", "networkManager", "bindForceUpdateApi$api_kombardoProd", "bindNotificationApi", "Ldk/molslinjen/api/services/notifications/NotificationApi;", "bindNotificationApi$api_kombardoProd", "bindConfigApi", "Ldk/molslinjen/api/services/config/ConfigApi;", "bindConfigApi$api_kombardoProd", "bindAccountApi", "Ldk/molslinjen/api/services/account/AccountApi;", "bindAccountApi$api_kombardoProd", "bindBookingApi", "Ldk/molslinjen/api/services/booking/BookingApi;", "bindBookingApi$api_kombardoProd", "bindInfoApi", "Ldk/molslinjen/api/services/info/InfoApi;", "bindInfoApi$api_kombardoProd", "bindAccountBookingApi", "Ldk/molslinjen/api/services/account/booking/AccountBookingsApi;", "bindAccountBookingApi$api_kombardoProd", "bindAccountBrobizzApi", "Ldk/molslinjen/api/services/account/brobizz/AccountBrobizzApi;", "bindAccountBrobizzApi$api_kombardoProd", "bindAccountCreditCardsApi", "Ldk/molslinjen/api/services/account/creditcard/AccountCreditCardsApi;", "bindAccountCreditCardsApi$api_kombardoProd", "bindAccountPassengersApi", "Ldk/molslinjen/api/services/account/passenger/AccountPassengersApi;", "bindAccountPassengersApi$api_kombardoProd", "bindAccountVehiclesApi", "Ldk/molslinjen/api/services/account/vehicle/AccountVehiclesApi;", "bindAccountVehiclesApi$api_kombardoProd", "bindNewslettersApi", "Ldk/molslinjen/api/services/newsletters/NewslettersApi;", "bindNewslettersApi$api_kombardoProd", "bindGeoLocatorApi", "Ldk/molslinjen/api/services/geolocator/GeoLocatorApi;", "bindGeoLocatorApi$api_kombardoProd", "bindPaymentApi", "Ldk/molslinjen/api/services/payment/PaymentApi;", "bindPaymentApi$api_kombardoProd", "bindPaymentTypesApi", "Ldk/molslinjen/api/services/paymentTypes/PaymentTypesApi;", "bindPaymentTypesApi$api_kombardoProd", "bindCateringApi", "Ldk/molslinjen/api/services/saleOnBoard/SaleOnBoardApi;", "bindCateringApi$api_kombardoProd", "bindFaqApi", "Ldk/molslinjen/api/services/faq/FaqApi;", "bindFaqApi$api_kombardoProd", "bindCommuteApi", "Ldk/molslinjen/api/services/commuter/bornholm/BornholmCommuterApi;", "bindMultiRideApi", "Ldk/molslinjen/api/services/multiRide/MultiRideApi;", "bindAccountMultiRideApi", "Ldk/molslinjen/api/services/multiRide/AccountMultiRideApi;", "bindOeresundCommuterApi", "Ldk/molslinjen/api/services/commuter/oeresund/OeresundCommuterApi;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ApiClientModule {
    public static final ApiClientModule INSTANCE = new ApiClientModule();

    private ApiClientModule() {
    }

    public final AccountApi bindAccountApi$api_kombardoProd(INetworkManager networkManager) {
        Intrinsics.checkNotNullParameter(networkManager, "networkManager");
        return (AccountApi) INetworkManager.DefaultImpls.createApiService$default(networkManager, AccountApi.class, null, 0, 6, null);
    }

    public final AccountBookingsApi bindAccountBookingApi$api_kombardoProd(INetworkManager networkManager) {
        Intrinsics.checkNotNullParameter(networkManager, "networkManager");
        return (AccountBookingsApi) INetworkManager.DefaultImpls.createApiService$default(networkManager, AccountBookingsApi.class, null, 0, 6, null);
    }

    public final AccountBrobizzApi bindAccountBrobizzApi$api_kombardoProd(INetworkManager networkManager) {
        Intrinsics.checkNotNullParameter(networkManager, "networkManager");
        return (AccountBrobizzApi) INetworkManager.DefaultImpls.createApiService$default(networkManager, AccountBrobizzApi.class, null, 0, 6, null);
    }

    public final AccountCreditCardsApi bindAccountCreditCardsApi$api_kombardoProd(INetworkManager networkManager) {
        Intrinsics.checkNotNullParameter(networkManager, "networkManager");
        return (AccountCreditCardsApi) INetworkManager.DefaultImpls.createApiService$default(networkManager, AccountCreditCardsApi.class, null, 0, 6, null);
    }

    public final AccountMultiRideApi bindAccountMultiRideApi(INetworkManager networkManager) {
        Intrinsics.checkNotNullParameter(networkManager, "networkManager");
        return (AccountMultiRideApi) INetworkManager.DefaultImpls.createApiService$default(networkManager, AccountMultiRideApi.class, null, 0, 6, null);
    }

    public final AccountPassengersApi bindAccountPassengersApi$api_kombardoProd(INetworkManager networkManager) {
        Intrinsics.checkNotNullParameter(networkManager, "networkManager");
        return (AccountPassengersApi) INetworkManager.DefaultImpls.createApiService$default(networkManager, AccountPassengersApi.class, null, 0, 6, null);
    }

    public final AccountVehiclesApi bindAccountVehiclesApi$api_kombardoProd(INetworkManager networkManager) {
        Intrinsics.checkNotNullParameter(networkManager, "networkManager");
        return (AccountVehiclesApi) INetworkManager.DefaultImpls.createApiService$default(networkManager, AccountVehiclesApi.class, null, 0, 6, null);
    }

    public final BookingApi bindBookingApi$api_kombardoProd(INetworkManager networkManager) {
        Intrinsics.checkNotNullParameter(networkManager, "networkManager");
        return (BookingApi) INetworkManager.DefaultImpls.createApiService$default(networkManager, BookingApi.class, null, 0, 6, null);
    }

    public final SaleOnBoardApi bindCateringApi$api_kombardoProd(INetworkManager networkManager) {
        Intrinsics.checkNotNullParameter(networkManager, "networkManager");
        return (SaleOnBoardApi) INetworkManager.DefaultImpls.createRetailItsService$default(networkManager, SaleOnBoardApi.class, null, 0, 6, null);
    }

    public final BornholmCommuterApi bindCommuteApi(INetworkManager networkManager) {
        Intrinsics.checkNotNullParameter(networkManager, "networkManager");
        return (BornholmCommuterApi) INetworkManager.DefaultImpls.createApiService$default(networkManager, BornholmCommuterApi.class, null, 0, 6, null);
    }

    public final ConfigApi bindConfigApi$api_kombardoProd(INetworkManager networkManager) {
        Intrinsics.checkNotNullParameter(networkManager, "networkManager");
        return (ConfigApi) INetworkManager.DefaultImpls.createApiService$default(networkManager, ConfigApi.class, null, 0, 6, null);
    }

    public final FaqApi bindFaqApi$api_kombardoProd(INetworkManager networkManager) {
        Intrinsics.checkNotNullParameter(networkManager, "networkManager");
        return (FaqApi) INetworkManager.DefaultImpls.createApiService$default(networkManager, FaqApi.class, null, 0, 6, null);
    }

    public final ForceUpdateApi bindForceUpdateApi$api_kombardoProd(INetworkManager networkManager) {
        Intrinsics.checkNotNullParameter(networkManager, "networkManager");
        return (ForceUpdateApi) INetworkManager.DefaultImpls.createApiService$default(networkManager, ForceUpdateApi.class, null, 0, 6, null);
    }

    public final GeoLocatorApi bindGeoLocatorApi$api_kombardoProd(INetworkManager networkManager) {
        Intrinsics.checkNotNullParameter(networkManager, "networkManager");
        return (GeoLocatorApi) INetworkManager.DefaultImpls.createApiService$default(networkManager, GeoLocatorApi.class, null, 0, 6, null);
    }

    public final InfoApi bindInfoApi$api_kombardoProd(INetworkManager networkManager) {
        Intrinsics.checkNotNullParameter(networkManager, "networkManager");
        return (InfoApi) INetworkManager.DefaultImpls.createApiService$default(networkManager, InfoApi.class, null, 0, 6, null);
    }

    public final MultiRideApi bindMultiRideApi(INetworkManager networkManager) {
        Intrinsics.checkNotNullParameter(networkManager, "networkManager");
        return (MultiRideApi) INetworkManager.DefaultImpls.createApiService$default(networkManager, MultiRideApi.class, null, 0, 6, null);
    }

    public final INetworkManager bindNetworkManager(IApiInfoProvider apiInfoProvider, AppVersionProvider appVersionProvider) {
        Intrinsics.checkNotNullParameter(apiInfoProvider, "apiInfoProvider");
        Intrinsics.checkNotNullParameter(appVersionProvider, "appVersionProvider");
        return new NetworkManager(apiInfoProvider, appVersionProvider);
    }

    public final NewslettersApi bindNewslettersApi$api_kombardoProd(INetworkManager networkManager) {
        Intrinsics.checkNotNullParameter(networkManager, "networkManager");
        return (NewslettersApi) INetworkManager.DefaultImpls.createApiService$default(networkManager, NewslettersApi.class, null, 0, 6, null);
    }

    public final NotificationApi bindNotificationApi$api_kombardoProd(INetworkManager networkManager) {
        Intrinsics.checkNotNullParameter(networkManager, "networkManager");
        return (NotificationApi) INetworkManager.DefaultImpls.createNotificationService$default(networkManager, NotificationApi.class, null, 0, 6, null);
    }

    public final OeresundCommuterApi bindOeresundCommuterApi(INetworkManager networkManager) {
        Intrinsics.checkNotNullParameter(networkManager, "networkManager");
        return (OeresundCommuterApi) INetworkManager.DefaultImpls.createApiService$default(networkManager, OeresundCommuterApi.class, null, 0, 6, null);
    }

    public final PaymentApi bindPaymentApi$api_kombardoProd(INetworkManager networkManager) {
        Intrinsics.checkNotNullParameter(networkManager, "networkManager");
        return (PaymentApi) INetworkManager.DefaultImpls.createPaymentService$default(networkManager, PaymentApi.class, null, 0, 6, null);
    }

    public final PaymentTypesApi bindPaymentTypesApi$api_kombardoProd(INetworkManager networkManager) {
        Intrinsics.checkNotNullParameter(networkManager, "networkManager");
        return (PaymentTypesApi) INetworkManager.DefaultImpls.createApiService$default(networkManager, PaymentTypesApi.class, null, 0, 6, null);
    }
}
