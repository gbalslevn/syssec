package com.kizitonwose.calendar.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import com.kizitonwose.calendar.compose.CalendarState;
import com.kizitonwose.calendar.compose.CalendarStateKt;
import com.kizitonwose.calendar.core.ExtensionsKt;
import com.kizitonwose.calendar.core.OutDateStyle;
import java.time.DayOfWeek;
import java.time.YearMonth;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a?\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"rememberCalendarState", "Lcom/kizitonwose/calendar/compose/CalendarState;", "startMonth", "Ljava/time/YearMonth;", "endMonth", "firstVisibleMonth", "firstDayOfWeek", "Ljava/time/DayOfWeek;", "outDateStyle", "Lcom/kizitonwose/calendar/core/OutDateStyle;", "(Ljava/time/YearMonth;Ljava/time/YearMonth;Ljava/time/YearMonth;Ljava/time/DayOfWeek;Lcom/kizitonwose/calendar/core/OutDateStyle;Landroidx/compose/runtime/Composer;II)Lcom/kizitonwose/calendar/compose/CalendarState;", "compose_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class CalendarStateKt {
    public static final CalendarState rememberCalendarState(YearMonth yearMonth, YearMonth yearMonth2, YearMonth yearMonth3, DayOfWeek dayOfWeek, OutDateStyle outDateStyle, Composer composer, int i5, int i6) {
        composer.startReplaceGroup(1393080404);
        final YearMonth now = (i6 & 1) != 0 ? YearMonth.now() : yearMonth;
        final YearMonth yearMonth4 = (i6 & 2) != 0 ? now : yearMonth2;
        final YearMonth yearMonth5 = (i6 & 4) != 0 ? now : yearMonth3;
        boolean z5 = true;
        final DayOfWeek firstDayOfWeekFromLocale$default = (i6 & 8) != 0 ? ExtensionsKt.firstDayOfWeekFromLocale$default(null, 1, null) : dayOfWeek;
        final OutDateStyle outDateStyle2 = (i6 & 16) != 0 ? OutDateStyle.EndOfRow : outDateStyle;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1393080404, i5, -1, "com.kizitonwose.calendar.compose.rememberCalendarState (CalendarState.kt:52)");
        }
        Object[] objArr = {now, yearMonth4, yearMonth5, firstDayOfWeekFromLocale$default, outDateStyle2};
        Saver<CalendarState, Object> saver$compose_release = CalendarState.INSTANCE.getSaver$compose_release();
        composer.startReplaceGroup(-2103784735);
        boolean changedInstance = composer.changedInstance(now) | composer.changedInstance(yearMonth4) | ((((i5 & 7168) ^ 3072) > 2048 && composer.changed(firstDayOfWeekFromLocale$default)) || (i5 & 3072) == 2048) | composer.changedInstance(yearMonth5);
        if ((((57344 & i5) ^ 24576) <= 16384 || !composer.changed(outDateStyle2)) && (i5 & 24576) != 16384) {
            z5 = false;
        }
        boolean z6 = changedInstance | z5;
        Object rememberedValue = composer.rememberedValue();
        if (z6 || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function0() { // from class: c1.k
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    CalendarState rememberCalendarState$lambda$1$lambda$0;
                    rememberCalendarState$lambda$1$lambda$0 = CalendarStateKt.rememberCalendarState$lambda$1$lambda$0(now, yearMonth4, firstDayOfWeekFromLocale$default, yearMonth5, outDateStyle2);
                    return rememberCalendarState$lambda$1$lambda$0;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        CalendarState calendarState = (CalendarState) RememberSaveableKt.rememberSaveable(objArr, saver$compose_release, null, (Function0) rememberedValue, composer, 0, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return calendarState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CalendarState rememberCalendarState$lambda$1$lambda$0(YearMonth yearMonth, YearMonth yearMonth2, DayOfWeek dayOfWeek, YearMonth yearMonth3, OutDateStyle outDateStyle) {
        return new CalendarState(yearMonth, yearMonth2, dayOfWeek, yearMonth3, outDateStyle, null);
    }
}
