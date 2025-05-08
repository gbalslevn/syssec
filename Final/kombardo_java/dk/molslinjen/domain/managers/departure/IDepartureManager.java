package dk.molslinjen.domain.managers.departure;

import com.sdk.growthbook.utils.Constants;
import dk.molslinjen.domain.model.booking.Departure;
import dk.molslinjen.domain.model.booking.DepartureDirection;
import dk.molslinjen.domain.model.booking.DepartureTicket;
import kotlin.Metadata;
import kotlin.Pair;
import kotlinx.coroutines.flow.StateFlow;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH&J\u0018\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH&J\u0018\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000eH&J \u0010\u0014\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\u000eH&J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH&J(\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\r\u001a\u00020\u000eH&J\b\u0010\u001c\u001a\u00020\nH&R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006¨\u0006\u001d"}, d2 = {"Ldk/molslinjen/domain/managers/departure/IDepartureManager;", BuildConfig.FLAVOR, "outboundState", "Lkotlinx/coroutines/flow/StateFlow;", "Ldk/molslinjen/domain/managers/departure/DepartureState;", "getOutboundState", "()Lkotlinx/coroutines/flow/StateFlow;", "returnState", "getReturnState", "updateShownHeaderDate", BuildConfig.FLAVOR, "date", "Lorg/threeten/bp/LocalDate;", "departureDirection", "Ldk/molslinjen/domain/model/booking/DepartureDirection;", "ensureLoadingDeparturesUntil", "toDate", "departureSelectionStarted", "departure", "Ldk/molslinjen/domain/model/booking/Departure;", "departureTicketSelected", "ticket", "Ldk/molslinjen/domain/model/booking/DepartureTicket;", "reloadDepartures", "getDeparture", "Lkotlin/Pair;", Constants.ID_ATTRIBUTE_KEY, BuildConfig.FLAVOR, "clear", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IDepartureManager {
    void clear();

    void departureSelectionStarted(Departure departure, DepartureDirection departureDirection);

    void departureTicketSelected(Departure departure, DepartureTicket ticket, DepartureDirection departureDirection);

    void ensureLoadingDeparturesUntil(LocalDate toDate, DepartureDirection departureDirection);

    Pair<Departure, DepartureTicket> getDeparture(String id, DepartureDirection departureDirection);

    StateFlow<DepartureState> getOutboundState();

    StateFlow<DepartureState> getReturnState();

    void reloadDepartures(DepartureDirection departureDirection);

    void updateShownHeaderDate(LocalDate date, DepartureDirection departureDirection);
}
