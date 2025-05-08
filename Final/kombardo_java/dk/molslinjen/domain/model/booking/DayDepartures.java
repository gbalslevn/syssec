package dk.molslinjen.domain.model.booking;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J\t\u0010\u001c\u001a\u00020\nHÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\fHÆ\u0003JC\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006%"}, d2 = {"Ldk/molslinjen/domain/model/booking/DayDepartures;", BuildConfig.FLAVOR, "date", "Lorg/threeten/bp/LocalDate;", "departures", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/Departure;", "loadingState", "Ldk/molslinjen/domain/model/booking/DepartureLoadingState;", "timeTableStatus", "Ldk/molslinjen/domain/model/booking/TimeTableStatus;", "siteDeparturesNotice", BuildConfig.FLAVOR, "<init>", "(Lorg/threeten/bp/LocalDate;Ljava/util/List;Ldk/molslinjen/domain/model/booking/DepartureLoadingState;Ldk/molslinjen/domain/model/booking/TimeTableStatus;Ljava/lang/String;)V", "getDate", "()Lorg/threeten/bp/LocalDate;", "getDepartures", "()Ljava/util/List;", "getLoadingState", "()Ldk/molslinjen/domain/model/booking/DepartureLoadingState;", "getTimeTableStatus", "()Ldk/molslinjen/domain/model/booking/TimeTableStatus;", "getSiteDeparturesNotice", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", BuildConfig.FLAVOR, "toString", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class DayDepartures {
    private final LocalDate date;
    private final List<Departure> departures;
    private final DepartureLoadingState loadingState;
    private final String siteDeparturesNotice;
    private final TimeTableStatus timeTableStatus;

    public DayDepartures(LocalDate date, List<Departure> departures, DepartureLoadingState loadingState, TimeTableStatus timeTableStatus, String str) {
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(departures, "departures");
        Intrinsics.checkNotNullParameter(loadingState, "loadingState");
        Intrinsics.checkNotNullParameter(timeTableStatus, "timeTableStatus");
        this.date = date;
        this.departures = departures;
        this.loadingState = loadingState;
        this.timeTableStatus = timeTableStatus;
        this.siteDeparturesNotice = str;
    }

    public static /* synthetic */ DayDepartures copy$default(DayDepartures dayDepartures, LocalDate localDate, List list, DepartureLoadingState departureLoadingState, TimeTableStatus timeTableStatus, String str, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            localDate = dayDepartures.date;
        }
        if ((i5 & 2) != 0) {
            list = dayDepartures.departures;
        }
        List list2 = list;
        if ((i5 & 4) != 0) {
            departureLoadingState = dayDepartures.loadingState;
        }
        DepartureLoadingState departureLoadingState2 = departureLoadingState;
        if ((i5 & 8) != 0) {
            timeTableStatus = dayDepartures.timeTableStatus;
        }
        TimeTableStatus timeTableStatus2 = timeTableStatus;
        if ((i5 & 16) != 0) {
            str = dayDepartures.siteDeparturesNotice;
        }
        return dayDepartures.copy(localDate, list2, departureLoadingState2, timeTableStatus2, str);
    }

    /* renamed from: component1, reason: from getter */
    public final LocalDate getDate() {
        return this.date;
    }

    public final List<Departure> component2() {
        return this.departures;
    }

    /* renamed from: component3, reason: from getter */
    public final DepartureLoadingState getLoadingState() {
        return this.loadingState;
    }

    /* renamed from: component4, reason: from getter */
    public final TimeTableStatus getTimeTableStatus() {
        return this.timeTableStatus;
    }

    /* renamed from: component5, reason: from getter */
    public final String getSiteDeparturesNotice() {
        return this.siteDeparturesNotice;
    }

    public final DayDepartures copy(LocalDate date, List<Departure> departures, DepartureLoadingState loadingState, TimeTableStatus timeTableStatus, String siteDeparturesNotice) {
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(departures, "departures");
        Intrinsics.checkNotNullParameter(loadingState, "loadingState");
        Intrinsics.checkNotNullParameter(timeTableStatus, "timeTableStatus");
        return new DayDepartures(date, departures, loadingState, timeTableStatus, siteDeparturesNotice);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DayDepartures)) {
            return false;
        }
        DayDepartures dayDepartures = (DayDepartures) other;
        return Intrinsics.areEqual(this.date, dayDepartures.date) && Intrinsics.areEqual(this.departures, dayDepartures.departures) && this.loadingState == dayDepartures.loadingState && this.timeTableStatus == dayDepartures.timeTableStatus && Intrinsics.areEqual(this.siteDeparturesNotice, dayDepartures.siteDeparturesNotice);
    }

    public final LocalDate getDate() {
        return this.date;
    }

    public final List<Departure> getDepartures() {
        return this.departures;
    }

    public final DepartureLoadingState getLoadingState() {
        return this.loadingState;
    }

    public final String getSiteDeparturesNotice() {
        return this.siteDeparturesNotice;
    }

    public final TimeTableStatus getTimeTableStatus() {
        return this.timeTableStatus;
    }

    public int hashCode() {
        int hashCode = ((((((this.date.hashCode() * 31) + this.departures.hashCode()) * 31) + this.loadingState.hashCode()) * 31) + this.timeTableStatus.hashCode()) * 31;
        String str = this.siteDeparturesNotice;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "DayDepartures(date=" + this.date + ", departures=" + this.departures + ", loadingState=" + this.loadingState + ", timeTableStatus=" + this.timeTableStatus + ", siteDeparturesNotice=" + this.siteDeparturesNotice + ")";
    }
}
