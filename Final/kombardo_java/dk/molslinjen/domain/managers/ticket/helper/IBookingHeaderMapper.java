package dk.molslinjen.domain.managers.ticket.helper;

import dk.molslinjen.api.services.booking.response.booking.BookingHeaderResponseDTO;
import dk.molslinjen.domain.managers.ticket.helper.BookingHeaderMapper;
import dk.molslinjen.domain.model.booking.BookingHeader;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H¦@¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Ldk/molslinjen/domain/managers/ticket/helper/IBookingHeaderMapper;", BuildConfig.FLAVOR, "mapBookingHeader", "Ldk/molslinjen/domain/model/booking/BookingHeader;", "booking", "Ldk/molslinjen/api/services/booking/response/booking/BookingHeaderResponseDTO;", "siteEntryByRouteIdCache", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "Ldk/molslinjen/domain/managers/ticket/helper/BookingHeaderMapper$SiteCacheEntry;", "(Ldk/molslinjen/api/services/booking/response/booking/BookingHeaderResponseDTO;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IBookingHeaderMapper {
    Object mapBookingHeader(BookingHeaderResponseDTO bookingHeaderResponseDTO, Map<String, BookingHeaderMapper.SiteCacheEntry> map, Continuation<? super BookingHeader> continuation);
}
