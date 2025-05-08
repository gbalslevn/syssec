package com.kizitonwose.calendar.data;

import com.kizitonwose.calendar.core.OutDateStyle;
import java.time.DayOfWeek;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u001a-\u0010\t\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\n\u001a\u001d\u0010\f\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u001d\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0000¢\u0006\u0004\b\u000f\u0010\r¨\u0006\u0010"}, d2 = {"Ljava/time/YearMonth;", "startMonth", BuildConfig.FLAVOR, "offset", "Ljava/time/DayOfWeek;", "firstDayOfWeek", "Lcom/kizitonwose/calendar/core/OutDateStyle;", "outDateStyle", "Lcom/kizitonwose/calendar/data/MonthData;", "getCalendarMonthData", "(Ljava/time/YearMonth;ILjava/time/DayOfWeek;Lcom/kizitonwose/calendar/core/OutDateStyle;)Lcom/kizitonwose/calendar/data/MonthData;", "targetMonth", "getMonthIndex", "(Ljava/time/YearMonth;Ljava/time/YearMonth;)I", "endMonth", "getMonthIndicesCount", "data"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class MonthDataKt {
    public static final MonthData getCalendarMonthData(YearMonth startMonth, int i5, DayOfWeek firstDayOfWeek, OutDateStyle outDateStyle) {
        Intrinsics.checkNotNullParameter(startMonth, "startMonth");
        Intrinsics.checkNotNullParameter(firstDayOfWeek, "firstDayOfWeek");
        Intrinsics.checkNotNullParameter(outDateStyle, "outDateStyle");
        YearMonth plusMonths = startMonth.plusMonths(i5);
        Intrinsics.checkNotNull(plusMonths);
        DayOfWeek dayOfWeek = com.kizitonwose.calendar.core.ExtensionsKt.atStartOfMonth(plusMonths).getDayOfWeek();
        Intrinsics.checkNotNullExpressionValue(dayOfWeek, "getDayOfWeek(...)");
        int daysUntil = ExtensionsKt.daysUntil(firstDayOfWeek, dayOfWeek);
        int lengthOfMonth = plusMonths.lengthOfMonth() + daysUntil;
        int i6 = lengthOfMonth % 7;
        int i7 = i6 != 0 ? 7 - i6 : 0;
        return new MonthData(plusMonths, daysUntil, i7 + (outDateStyle != OutDateStyle.EndOfRow ? (6 - ((lengthOfMonth + i7) / 7)) * 7 : 0));
    }

    public static final int getMonthIndex(YearMonth startMonth, YearMonth targetMonth) {
        Intrinsics.checkNotNullParameter(startMonth, "startMonth");
        Intrinsics.checkNotNullParameter(targetMonth, "targetMonth");
        return (int) ChronoUnit.MONTHS.between(startMonth, targetMonth);
    }

    public static final int getMonthIndicesCount(YearMonth startMonth, YearMonth endMonth) {
        Intrinsics.checkNotNullParameter(startMonth, "startMonth");
        Intrinsics.checkNotNullParameter(endMonth, "endMonth");
        return getMonthIndex(startMonth, endMonth) + 1;
    }
}
