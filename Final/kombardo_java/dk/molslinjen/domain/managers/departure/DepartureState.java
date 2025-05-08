package dk.molslinjen.domain.managers.departure;

import dk.molslinjen.domain.model.booking.DayDepartures;
import dk.molslinjen.domain.model.booking.Departure;
import dk.molslinjen.domain.model.booking.DepartureTicket;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalDateTime;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u001b\b\u0086\b\u0018\u00002\u00020\u0001Bg\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013Jp\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001c\u001a\u00020\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010!\u001a\u0004\b\"\u0010#R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010$\u001a\u0004\b%\u0010\u0017R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010&\u001a\u0004\b'\u0010(R\u0019\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010)\u001a\u0004\b*\u0010+R\u0019\u0010\r\u001a\u0004\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b\r\u0010)\u001a\u0004\b,\u0010+R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010-\u001a\u0004\b.\u0010/R\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u00100\u001a\u0004\b1\u00102¨\u00063"}, d2 = {"Ldk/molslinjen/domain/managers/departure/DepartureState;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "loadingDeparturesError", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/DayDepartures;", "departures", BuildConfig.FLAVOR, "siteDepartureNotice", "Lorg/threeten/bp/LocalDate;", "shownHeaderDate", "Ldk/molslinjen/domain/model/booking/Departure;", "selectionInProgressDeparture", "selectedDeparture", "Ldk/molslinjen/domain/model/booking/DepartureTicket;", "selectedDepartureTicket", "Lorg/threeten/bp/LocalDateTime;", "startedLoadingTime", "<init>", "(ZLjava/util/List;Ljava/lang/String;Lorg/threeten/bp/LocalDate;Ldk/molslinjen/domain/model/booking/Departure;Ldk/molslinjen/domain/model/booking/Departure;Ldk/molslinjen/domain/model/booking/DepartureTicket;Lorg/threeten/bp/LocalDateTime;)V", "copy", "(ZLjava/util/List;Ljava/lang/String;Lorg/threeten/bp/LocalDate;Ldk/molslinjen/domain/model/booking/Departure;Ldk/molslinjen/domain/model/booking/Departure;Ldk/molslinjen/domain/model/booking/DepartureTicket;Lorg/threeten/bp/LocalDateTime;)Ldk/molslinjen/domain/managers/departure/DepartureState;", "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getLoadingDeparturesError", "()Z", "Ljava/util/List;", "getDepartures", "()Ljava/util/List;", "Ljava/lang/String;", "getSiteDepartureNotice", "Lorg/threeten/bp/LocalDate;", "getShownHeaderDate", "()Lorg/threeten/bp/LocalDate;", "Ldk/molslinjen/domain/model/booking/Departure;", "getSelectionInProgressDeparture", "()Ldk/molslinjen/domain/model/booking/Departure;", "getSelectedDeparture", "Ldk/molslinjen/domain/model/booking/DepartureTicket;", "getSelectedDepartureTicket", "()Ldk/molslinjen/domain/model/booking/DepartureTicket;", "Lorg/threeten/bp/LocalDateTime;", "getStartedLoadingTime", "()Lorg/threeten/bp/LocalDateTime;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class DepartureState {
    private final List<DayDepartures> departures;
    private final boolean loadingDeparturesError;
    private final Departure selectedDeparture;
    private final DepartureTicket selectedDepartureTicket;
    private final Departure selectionInProgressDeparture;
    private final LocalDate shownHeaderDate;
    private final String siteDepartureNotice;
    private final LocalDateTime startedLoadingTime;

    public DepartureState(boolean z5, List<DayDepartures> departures, String str, LocalDate shownHeaderDate, Departure departure, Departure departure2, DepartureTicket departureTicket, LocalDateTime localDateTime) {
        Intrinsics.checkNotNullParameter(departures, "departures");
        Intrinsics.checkNotNullParameter(shownHeaderDate, "shownHeaderDate");
        this.loadingDeparturesError = z5;
        this.departures = departures;
        this.siteDepartureNotice = str;
        this.shownHeaderDate = shownHeaderDate;
        this.selectionInProgressDeparture = departure;
        this.selectedDeparture = departure2;
        this.selectedDepartureTicket = departureTicket;
        this.startedLoadingTime = localDateTime;
    }

    public final DepartureState copy(boolean loadingDeparturesError, List<DayDepartures> departures, String siteDepartureNotice, LocalDate shownHeaderDate, Departure selectionInProgressDeparture, Departure selectedDeparture, DepartureTicket selectedDepartureTicket, LocalDateTime startedLoadingTime) {
        Intrinsics.checkNotNullParameter(departures, "departures");
        Intrinsics.checkNotNullParameter(shownHeaderDate, "shownHeaderDate");
        return new DepartureState(loadingDeparturesError, departures, siteDepartureNotice, shownHeaderDate, selectionInProgressDeparture, selectedDeparture, selectedDepartureTicket, startedLoadingTime);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DepartureState)) {
            return false;
        }
        DepartureState departureState = (DepartureState) other;
        return this.loadingDeparturesError == departureState.loadingDeparturesError && Intrinsics.areEqual(this.departures, departureState.departures) && Intrinsics.areEqual(this.siteDepartureNotice, departureState.siteDepartureNotice) && Intrinsics.areEqual(this.shownHeaderDate, departureState.shownHeaderDate) && Intrinsics.areEqual(this.selectionInProgressDeparture, departureState.selectionInProgressDeparture) && Intrinsics.areEqual(this.selectedDeparture, departureState.selectedDeparture) && Intrinsics.areEqual(this.selectedDepartureTicket, departureState.selectedDepartureTicket) && Intrinsics.areEqual(this.startedLoadingTime, departureState.startedLoadingTime);
    }

    public final List<DayDepartures> getDepartures() {
        return this.departures;
    }

    public final boolean getLoadingDeparturesError() {
        return this.loadingDeparturesError;
    }

    public final Departure getSelectedDeparture() {
        return this.selectedDeparture;
    }

    public final DepartureTicket getSelectedDepartureTicket() {
        return this.selectedDepartureTicket;
    }

    public final Departure getSelectionInProgressDeparture() {
        return this.selectionInProgressDeparture;
    }

    public final LocalDate getShownHeaderDate() {
        return this.shownHeaderDate;
    }

    public final String getSiteDepartureNotice() {
        return this.siteDepartureNotice;
    }

    public final LocalDateTime getStartedLoadingTime() {
        return this.startedLoadingTime;
    }

    public int hashCode() {
        int hashCode = ((Boolean.hashCode(this.loadingDeparturesError) * 31) + this.departures.hashCode()) * 31;
        String str = this.siteDepartureNotice;
        int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.shownHeaderDate.hashCode()) * 31;
        Departure departure = this.selectionInProgressDeparture;
        int hashCode3 = (hashCode2 + (departure == null ? 0 : departure.hashCode())) * 31;
        Departure departure2 = this.selectedDeparture;
        int hashCode4 = (hashCode3 + (departure2 == null ? 0 : departure2.hashCode())) * 31;
        DepartureTicket departureTicket = this.selectedDepartureTicket;
        int hashCode5 = (hashCode4 + (departureTicket == null ? 0 : departureTicket.hashCode())) * 31;
        LocalDateTime localDateTime = this.startedLoadingTime;
        return hashCode5 + (localDateTime != null ? localDateTime.hashCode() : 0);
    }

    public String toString() {
        return "DepartureState(loadingDeparturesError=" + this.loadingDeparturesError + ", departures=" + this.departures + ", siteDepartureNotice=" + this.siteDepartureNotice + ", shownHeaderDate=" + this.shownHeaderDate + ", selectionInProgressDeparture=" + this.selectionInProgressDeparture + ", selectedDeparture=" + this.selectedDeparture + ", selectedDepartureTicket=" + this.selectedDepartureTicket + ", startedLoadingTime=" + this.startedLoadingTime + ")";
    }

    public /* synthetic */ DepartureState(boolean z5, List list, String str, LocalDate localDate, Departure departure, Departure departure2, DepartureTicket departureTicket, LocalDateTime localDateTime, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? false : z5, (i5 & 2) != 0 ? CollectionsKt.emptyList() : list, (i5 & 4) != 0 ? null : str, (i5 & 8) != 0 ? LocalDate.now() : localDate, (i5 & 16) != 0 ? null : departure, (i5 & 32) != 0 ? null : departure2, (i5 & 64) != 0 ? null : departureTicket, (i5 & 128) == 0 ? localDateTime : null);
    }
}
