package com.kizitonwose.calendar.core;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.temporal.WeekFields;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u0018\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0007\u001a\u0012\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0007\u001a\n\u0010\u0007\u001a\u00020\b*\u00020\t\"\u0015\u0010\n\u001a\u00020\t*\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\"\u0015\u0010\r\u001a\u00020\t*\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0015\u0010\u0010\u001a\u00020\t*\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u0012"}, d2 = {"daysOfWeek", BuildConfig.FLAVOR, "Ljava/time/DayOfWeek;", "firstDayOfWeek", "firstDayOfWeekFromLocale", "locale", "Ljava/util/Locale;", "atStartOfMonth", "Ljava/time/LocalDate;", "Ljava/time/YearMonth;", "yearMonth", "getYearMonth", "(Ljava/time/LocalDate;)Ljava/time/YearMonth;", "nextMonth", "getNextMonth", "(Ljava/time/YearMonth;)Ljava/time/YearMonth;", "previousMonth", "getPreviousMonth", "core"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class ExtensionsKt {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class EntriesMappings {
        public static final /* synthetic */ EnumEntries<DayOfWeek> entries$0 = EnumEntriesKt.enumEntries(DayOfWeek.values());
    }

    public static final LocalDate atStartOfMonth(YearMonth yearMonth) {
        Intrinsics.checkNotNullParameter(yearMonth, "<this>");
        LocalDate atDay = yearMonth.atDay(1);
        Intrinsics.checkNotNullExpressionValue(atDay, "atDay(...)");
        return atDay;
    }

    public static final List<DayOfWeek> daysOfWeek(DayOfWeek firstDayOfWeek) {
        Intrinsics.checkNotNullParameter(firstDayOfWeek, "firstDayOfWeek");
        int ordinal = 7 - firstDayOfWeek.ordinal();
        EnumEntries<DayOfWeek> enumEntries = EntriesMappings.entries$0;
        return CollectionsKt.plus((Collection) CollectionsKt.takeLast(enumEntries, ordinal), (Iterable) CollectionsKt.dropLast(enumEntries, ordinal));
    }

    public static final DayOfWeek firstDayOfWeekFromLocale(Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        DayOfWeek firstDayOfWeek = WeekFields.of(locale).getFirstDayOfWeek();
        Intrinsics.checkNotNullExpressionValue(firstDayOfWeek, "getFirstDayOfWeek(...)");
        return firstDayOfWeek;
    }

    public static /* synthetic */ DayOfWeek firstDayOfWeekFromLocale$default(Locale locale, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            locale = Locale.getDefault();
        }
        return firstDayOfWeekFromLocale(locale);
    }

    public static final YearMonth getNextMonth(YearMonth yearMonth) {
        Intrinsics.checkNotNullParameter(yearMonth, "<this>");
        YearMonth plusMonths = yearMonth.plusMonths(1L);
        Intrinsics.checkNotNullExpressionValue(plusMonths, "plusMonths(...)");
        return plusMonths;
    }

    public static final YearMonth getPreviousMonth(YearMonth yearMonth) {
        Intrinsics.checkNotNullParameter(yearMonth, "<this>");
        YearMonth minusMonths = yearMonth.minusMonths(1L);
        Intrinsics.checkNotNullExpressionValue(minusMonths, "minusMonths(...)");
        return minusMonths;
    }

    public static final YearMonth getYearMonth(LocalDate localDate) {
        Intrinsics.checkNotNullParameter(localDate, "<this>");
        YearMonth of = YearMonth.of(localDate.getYear(), localDate.getMonth());
        Intrinsics.checkNotNullExpressionValue(of, "of(...)");
        return of;
    }
}
