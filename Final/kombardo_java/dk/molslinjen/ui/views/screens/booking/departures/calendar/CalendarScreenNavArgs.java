package dk.molslinjen.ui.views.screens.booking.departures.calendar;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u001a\u0010\u0016R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u001b\u0010\u0016¨\u0006\u001c"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/departures/calendar/CalendarScreenNavArgs;", BuildConfig.FLAVOR, "Lorg/threeten/bp/LocalDate;", "selectedDate", "Ldk/molslinjen/ui/views/screens/booking/departures/calendar/CalendarSheetType;", "calendarType", "minDate", "maxDate", "<init>", "(Lorg/threeten/bp/LocalDate;Ldk/molslinjen/ui/views/screens/booking/departures/calendar/CalendarSheetType;Lorg/threeten/bp/LocalDate;Lorg/threeten/bp/LocalDate;)V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Lorg/threeten/bp/LocalDate;", "getSelectedDate", "()Lorg/threeten/bp/LocalDate;", "Ldk/molslinjen/ui/views/screens/booking/departures/calendar/CalendarSheetType;", "getCalendarType", "()Ldk/molslinjen/ui/views/screens/booking/departures/calendar/CalendarSheetType;", "getMinDate", "getMaxDate", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class CalendarScreenNavArgs {
    private final CalendarSheetType calendarType;
    private final LocalDate maxDate;
    private final LocalDate minDate;
    private final LocalDate selectedDate;

    public CalendarScreenNavArgs(LocalDate selectedDate, CalendarSheetType calendarType, LocalDate minDate, LocalDate localDate) {
        Intrinsics.checkNotNullParameter(selectedDate, "selectedDate");
        Intrinsics.checkNotNullParameter(calendarType, "calendarType");
        Intrinsics.checkNotNullParameter(minDate, "minDate");
        this.selectedDate = selectedDate;
        this.calendarType = calendarType;
        this.minDate = minDate;
        this.maxDate = localDate;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CalendarScreenNavArgs)) {
            return false;
        }
        CalendarScreenNavArgs calendarScreenNavArgs = (CalendarScreenNavArgs) other;
        return Intrinsics.areEqual(this.selectedDate, calendarScreenNavArgs.selectedDate) && this.calendarType == calendarScreenNavArgs.calendarType && Intrinsics.areEqual(this.minDate, calendarScreenNavArgs.minDate) && Intrinsics.areEqual(this.maxDate, calendarScreenNavArgs.maxDate);
    }

    public final CalendarSheetType getCalendarType() {
        return this.calendarType;
    }

    public final LocalDate getMaxDate() {
        return this.maxDate;
    }

    public final LocalDate getMinDate() {
        return this.minDate;
    }

    public final LocalDate getSelectedDate() {
        return this.selectedDate;
    }

    public int hashCode() {
        int hashCode = ((((this.selectedDate.hashCode() * 31) + this.calendarType.hashCode()) * 31) + this.minDate.hashCode()) * 31;
        LocalDate localDate = this.maxDate;
        return hashCode + (localDate == null ? 0 : localDate.hashCode());
    }

    public String toString() {
        return "CalendarScreenNavArgs(selectedDate=" + this.selectedDate + ", calendarType=" + this.calendarType + ", minDate=" + this.minDate + ", maxDate=" + this.maxDate + ")";
    }
}
