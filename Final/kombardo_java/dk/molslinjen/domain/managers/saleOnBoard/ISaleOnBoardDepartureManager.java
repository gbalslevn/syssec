package dk.molslinjen.domain.managers.saleOnBoard;

import dk.molslinjen.domain.managers.departure.DepartureState;
import kotlin.Metadata;
import kotlinx.coroutines.flow.StateFlow;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\nH&J\b\u0010\r\u001a\u00020\bH&R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, d2 = {"Ldk/molslinjen/domain/managers/saleOnBoard/ISaleOnBoardDepartureManager;", BuildConfig.FLAVOR, "departureState", "Lkotlinx/coroutines/flow/StateFlow;", "Ldk/molslinjen/domain/managers/departure/DepartureState;", "getDepartureState", "()Lkotlinx/coroutines/flow/StateFlow;", "updateShownHeaderDate", BuildConfig.FLAVOR, "date", "Lorg/threeten/bp/LocalDate;", "ensureLoadingDeparturesUntil", "toDate", "reloadDepartures", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface ISaleOnBoardDepartureManager {
    void ensureLoadingDeparturesUntil(LocalDate toDate);

    StateFlow<DepartureState> getDepartureState();

    void reloadDepartures();

    void updateShownHeaderDate(LocalDate date);
}
