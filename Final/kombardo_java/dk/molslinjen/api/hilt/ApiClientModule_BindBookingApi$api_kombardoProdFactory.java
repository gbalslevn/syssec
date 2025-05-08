package dk.molslinjen.api.hilt;

import dagger.internal.Preconditions;
import dagger.internal.Provider;
import dk.molslinjen.api.INetworkManager;
import dk.molslinjen.api.services.booking.BookingApi;

/* loaded from: classes2.dex */
public abstract class ApiClientModule_BindBookingApi$api_kombardoProdFactory implements Provider {
    public static BookingApi bindBookingApi$api_kombardoProd(INetworkManager iNetworkManager) {
        return (BookingApi) Preconditions.checkNotNullFromProvides(ApiClientModule.INSTANCE.bindBookingApi$api_kombardoProd(iNetworkManager));
    }
}
