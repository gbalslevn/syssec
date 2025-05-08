package dk.molslinjen.api.hilt;

import dagger.internal.Preconditions;
import dagger.internal.Provider;
import dk.molslinjen.api.INetworkManager;
import dk.molslinjen.api.services.account.booking.AccountBookingsApi;

/* loaded from: classes2.dex */
public abstract class ApiClientModule_BindAccountBookingApi$api_kombardoProdFactory implements Provider {
    public static AccountBookingsApi bindAccountBookingApi$api_kombardoProd(INetworkManager iNetworkManager) {
        return (AccountBookingsApi) Preconditions.checkNotNullFromProvides(ApiClientModule.INSTANCE.bindAccountBookingApi$api_kombardoProd(iNetworkManager));
    }
}
