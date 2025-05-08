package dk.molslinjen.api.services.booking;

import dagger.internal.Provider;
import dagger.internal.Providers;

/* loaded from: classes2.dex */
public final class BookingService_Factory implements Provider {
    private final Provider<BookingApi> apiProvider;

    public BookingService_Factory(Provider<BookingApi> provider) {
        this.apiProvider = provider;
    }

    public static BookingService_Factory create(javax.inject.Provider<BookingApi> provider) {
        return new BookingService_Factory(Providers.asDaggerProvider(provider));
    }

    public static BookingService newInstance(BookingApi bookingApi) {
        return new BookingService(bookingApi);
    }

    public static BookingService_Factory create(Provider<BookingApi> provider) {
        return new BookingService_Factory(provider);
    }

    @Override // javax.inject.Provider
    public BookingService get() {
        return newInstance(this.apiProvider.get());
    }
}
