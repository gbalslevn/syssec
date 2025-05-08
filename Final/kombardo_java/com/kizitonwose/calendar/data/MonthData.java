package com.kizitonwose.calendar.data;

import com.kizitonwose.calendar.core.CalendarDay;
import com.kizitonwose.calendar.core.CalendarMonth;
import com.kizitonwose.calendar.core.DayPosition;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B!\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0016R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0017R\u0014\u0010\u0006\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u001c\u0010\u001b\u001a\n \u001a*\u0004\u0018\u00010\u00190\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR \u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u001d0\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010\u0016R\u0014\u0010!\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\u0016R\u0017\u0010#\u001a\u00020\"8\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&¨\u0006'"}, d2 = {"Lcom/kizitonwose/calendar/data/MonthData;", BuildConfig.FLAVOR, "Ljava/time/YearMonth;", "month", BuildConfig.FLAVOR, "inDays", "outDays", "<init>", "(Ljava/time/YearMonth;II)V", "dayOffset", "Lcom/kizitonwose/calendar/core/CalendarDay;", "getDay", "(I)Lcom/kizitonwose/calendar/core/CalendarDay;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ljava/time/YearMonth;", "I", "totalDays", "Ljava/time/LocalDate;", "kotlin.jvm.PlatformType", "firstDay", "Ljava/time/LocalDate;", BuildConfig.FLAVOR, "rows", "Ljava/util/List;", "previousMonth", "nextMonth", "Lcom/kizitonwose/calendar/core/CalendarMonth;", "calendarMonth", "Lcom/kizitonwose/calendar/core/CalendarMonth;", "getCalendarMonth", "()Lcom/kizitonwose/calendar/core/CalendarMonth;", "data"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class MonthData {
    private final CalendarMonth calendarMonth;
    private final LocalDate firstDay;
    private final int inDays;
    private final YearMonth month;
    private final YearMonth nextMonth;
    private final int outDays;
    private final YearMonth previousMonth;
    private final List<List<Integer>> rows;
    private final int totalDays;

    public MonthData(YearMonth month, int i5, int i6) {
        Intrinsics.checkNotNullParameter(month, "month");
        this.month = month;
        this.inDays = i5;
        this.outDays = i6;
        int lengthOfMonth = month.lengthOfMonth() + i5 + i6;
        this.totalDays = lengthOfMonth;
        this.firstDay = com.kizitonwose.calendar.core.ExtensionsKt.atStartOfMonth(month).minusDays(i5);
        List<List<Integer>> chunked = CollectionsKt.chunked(RangesKt.until(0, lengthOfMonth), 7);
        this.rows = chunked;
        this.previousMonth = com.kizitonwose.calendar.core.ExtensionsKt.getPreviousMonth(month);
        this.nextMonth = com.kizitonwose.calendar.core.ExtensionsKt.getNextMonth(month);
        List<List<Integer>> list = chunked;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            List list2 = (List) it.next();
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator it2 = list2.iterator();
            while (it2.hasNext()) {
                arrayList2.add(getDay(((Number) it2.next()).intValue()));
            }
            arrayList.add(arrayList2);
        }
        this.calendarMonth = new CalendarMonth(month, arrayList);
    }

    private final CalendarDay getDay(int dayOffset) {
        DayPosition dayPosition;
        LocalDate plusDays = this.firstDay.plusDays(dayOffset);
        Intrinsics.checkNotNull(plusDays);
        YearMonth yearMonth = com.kizitonwose.calendar.core.ExtensionsKt.getYearMonth(plusDays);
        if (Intrinsics.areEqual(yearMonth, this.month)) {
            dayPosition = DayPosition.MonthDate;
        } else if (Intrinsics.areEqual(yearMonth, this.previousMonth)) {
            dayPosition = DayPosition.InDate;
        } else {
            if (!Intrinsics.areEqual(yearMonth, this.nextMonth)) {
                throw new IllegalArgumentException("Invalid date: " + plusDays + " in month: " + this.month);
            }
            dayPosition = DayPosition.OutDate;
        }
        return new CalendarDay(plusDays, dayPosition);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MonthData)) {
            return false;
        }
        MonthData monthData = (MonthData) other;
        return Intrinsics.areEqual(this.month, monthData.month) && this.inDays == monthData.inDays && this.outDays == monthData.outDays;
    }

    public final CalendarMonth getCalendarMonth() {
        return this.calendarMonth;
    }

    public int hashCode() {
        return (((this.month.hashCode() * 31) + Integer.hashCode(this.inDays)) * 31) + Integer.hashCode(this.outDays);
    }

    public String toString() {
        return "MonthData(month=" + this.month + ", inDays=" + this.inDays + ", outDays=" + this.outDays + ")";
    }
}
