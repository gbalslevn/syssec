package com.kizitonwose.calendar.core;

import java.io.Serializable;
import java.time.YearMonth;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0096\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R#\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/kizitonwose/calendar/core/CalendarMonth;", "Ljava/io/Serializable;", "Ljava/time/YearMonth;", "yearMonth", BuildConfig.FLAVOR, "Lcom/kizitonwose/calendar/core/CalendarDay;", "weekDays", "<init>", "(Ljava/time/YearMonth;Ljava/util/List;)V", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", BuildConfig.FLAVOR, "hashCode", "()I", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "Ljava/time/YearMonth;", "getYearMonth", "()Ljava/time/YearMonth;", "Ljava/util/List;", "getWeekDays", "()Ljava/util/List;", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class CalendarMonth implements Serializable {
    private final List<List<CalendarDay>> weekDays;
    private final YearMonth yearMonth;

    /* JADX WARN: Multi-variable type inference failed */
    public CalendarMonth(YearMonth yearMonth, List<? extends List<CalendarDay>> weekDays) {
        Intrinsics.checkNotNullParameter(yearMonth, "yearMonth");
        Intrinsics.checkNotNullParameter(weekDays, "weekDays");
        this.yearMonth = yearMonth;
        this.weekDays = weekDays;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(CalendarMonth.class, other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.kizitonwose.calendar.core.CalendarMonth");
        CalendarMonth calendarMonth = (CalendarMonth) other;
        return Intrinsics.areEqual(this.yearMonth, calendarMonth.yearMonth) && Intrinsics.areEqual(CollectionsKt.first((List) CollectionsKt.first((List) this.weekDays)), CollectionsKt.first((List) CollectionsKt.first((List) calendarMonth.weekDays))) && Intrinsics.areEqual(CollectionsKt.last((List) CollectionsKt.last((List) this.weekDays)), CollectionsKt.last((List) CollectionsKt.last((List) calendarMonth.weekDays)));
    }

    public final List<List<CalendarDay>> getWeekDays() {
        return this.weekDays;
    }

    public final YearMonth getYearMonth() {
        return this.yearMonth;
    }

    public int hashCode() {
        return (((this.yearMonth.hashCode() * 31) + ((CalendarDay) CollectionsKt.first((List) CollectionsKt.first((List) this.weekDays))).hashCode()) * 31) + ((CalendarDay) CollectionsKt.last((List) CollectionsKt.last((List) this.weekDays))).hashCode();
    }

    public String toString() {
        return "CalendarMonth { yearMonth = " + this.yearMonth + ", firstDay = " + CollectionsKt.first((List<? extends Object>) CollectionsKt.first((List) this.weekDays)) + ", lastDay = " + CollectionsKt.last((List<? extends Object>) CollectionsKt.last((List) this.weekDays)) + " } ";
    }
}
