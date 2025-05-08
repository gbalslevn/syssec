package com.kizitonwose.calendar.core;

import java.io.Serializable;
import java.time.LocalDate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/kizitonwose/calendar/core/CalendarDay;", "Ljava/io/Serializable;", "Ljava/time/LocalDate;", "date", "Lcom/kizitonwose/calendar/core/DayPosition;", "position", "<init>", "(Ljava/time/LocalDate;Lcom/kizitonwose/calendar/core/DayPosition;)V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ljava/time/LocalDate;", "getDate", "()Ljava/time/LocalDate;", "Lcom/kizitonwose/calendar/core/DayPosition;", "getPosition", "()Lcom/kizitonwose/calendar/core/DayPosition;", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class CalendarDay implements Serializable {
    private final LocalDate date;
    private final DayPosition position;

    public CalendarDay(LocalDate date, DayPosition position) {
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(position, "position");
        this.date = date;
        this.position = position;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CalendarDay)) {
            return false;
        }
        CalendarDay calendarDay = (CalendarDay) other;
        return Intrinsics.areEqual(this.date, calendarDay.date) && this.position == calendarDay.position;
    }

    public final LocalDate getDate() {
        return this.date;
    }

    public final DayPosition getPosition() {
        return this.position;
    }

    public int hashCode() {
        return (this.date.hashCode() * 31) + this.position.hashCode();
    }

    public String toString() {
        return "CalendarDay(date=" + this.date + ", position=" + this.position + ")";
    }
}
