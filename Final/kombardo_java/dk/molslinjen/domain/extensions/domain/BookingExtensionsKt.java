package dk.molslinjen.domain.extensions.domain;

import dk.molslinjen.domain.model.booking.BookingDeparture;
import dk.molslinjen.domain.model.booking.BookingHeader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDateTime;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0003¨\u0006\u0004"}, d2 = {"isEarlyCheckInAllowedNow", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/BookingHeader;", "Ldk/molslinjen/domain/model/booking/BookingDeparture;", "domain_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class BookingExtensionsKt {
    public static final boolean isEarlyCheckInAllowedNow(BookingHeader bookingHeader) {
        Intrinsics.checkNotNullParameter(bookingHeader, "<this>");
        return bookingHeader.isEarlyCheckInAllowed() && bookingHeader.departureDateTime().minusDays(2L).isBefore(LocalDateTime.now()) && LocalDateTime.now().isBefore(bookingHeader.departureDateTime());
    }

    public static final boolean isEarlyCheckInAllowedNow(BookingDeparture bookingDeparture) {
        Intrinsics.checkNotNullParameter(bookingDeparture, "<this>");
        return bookingDeparture.isEarlyCheckInPossible() && bookingDeparture.departureDateTime().minusDays(2L).isBefore(LocalDateTime.now()) && LocalDateTime.now().isBefore(bookingDeparture.departureDateTime());
    }
}
