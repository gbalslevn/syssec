package dk.molslinjen.ui.views.screens.booking.departures.calendar;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import com.kizitonwose.calendar.compose.CalendarKt;
import com.kizitonwose.calendar.compose.CalendarState;
import com.kizitonwose.calendar.compose.CalendarStateKt;
import com.kizitonwose.calendar.core.CalendarDay;
import com.kizitonwose.calendar.core.CalendarMonth;
import com.kizitonwose.calendar.core.ExtensionsKt;
import dk.molslinjen.core.extensions.StringExtensionsKt;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.screens.booking.departures.calendar.CustomCalendarViewKt;
import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;
import org.threeten.bp.YearMonth;
import uniffi.molslinjen_shared.DepartureCalendarPrice;
import uniffi.molslinjen_shared.DeparturePriceIndicator;

@Metadata(d1 = {"\u0000@\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aS\u0010\f\u001a\u00020\n2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u00032\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n0\tH\u0007¢\u0006\u0004\b\f\u0010\r\u001a%\u0010\u0012\u001a\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00002\u0006\u0010\u0011\u001a\u00020\u0010H\u0003¢\u0006\u0004\b\u0012\u0010\u0013*\f\b\u0002\u0010\u0015\"\u00020\u00142\u00020\u0014*\f\b\u0002\u0010\u0017\"\u00020\u00162\u00020\u0016¨\u0006\u0018"}, d2 = {BuildConfig.FLAVOR, "Luniffi/molslinjen_shared/DepartureCalendarPrice;", "lowPrices", "Lorg/threeten/bp/LocalDate;", "currentSelectedDate", "Lorg/threeten/bp/YearMonth;", "monthToShow", "minDate", "maxDate", "Lkotlin/Function1;", BuildConfig.FLAVOR, "onDatePressed", "CustomCalendarView", "(Ljava/util/List;Lorg/threeten/bp/LocalDate;Lorg/threeten/bp/YearMonth;Lorg/threeten/bp/LocalDate;Lorg/threeten/bp/LocalDate;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "Ljava/time/DayOfWeek;", "daysOfWeek", "Ljava/util/Locale;", "locale", "DaysOfTheWeekRow", "(Ljava/util/List;Ljava/util/Locale;Landroidx/compose/runtime/Composer;I)V", "Ljava/time/LocalDate;", "JavaLocalDate", "Ljava/time/YearMonth;", "JavaYearMonth", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class CustomCalendarViewKt {
    public static final void CustomCalendarView(final List<DepartureCalendarPrice> lowPrices, final LocalDate currentSelectedDate, final YearMonth monthToShow, final LocalDate minDate, final LocalDate localDate, final Function1<? super LocalDate, Unit> onDatePressed, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Intrinsics.checkNotNullParameter(lowPrices, "lowPrices");
        Intrinsics.checkNotNullParameter(currentSelectedDate, "currentSelectedDate");
        Intrinsics.checkNotNullParameter(monthToShow, "monthToShow");
        Intrinsics.checkNotNullParameter(minDate, "minDate");
        Intrinsics.checkNotNullParameter(onDatePressed, "onDatePressed");
        Composer startRestartGroup = composer.startRestartGroup(-371229700);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(lowPrices) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(currentSelectedDate) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(monthToShow) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(minDate) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(localDate) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i6 |= startRestartGroup.changedInstance(onDatePressed) ? 131072 : 65536;
        }
        if ((74899 & i6) == 74898 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-371229700, i6, -1, "dk.molslinjen.ui.views.screens.booking.departures.calendar.CustomCalendarView (CustomCalendarView.kt:47)");
            }
            final java.time.LocalDate of = java.time.LocalDate.of(minDate.getYear(), minDate.getMonthValue(), minDate.getDayOfMonth());
            final java.time.LocalDate of2 = localDate != null ? java.time.LocalDate.of(localDate.getYear(), localDate.getMonthValue(), localDate.getDayOfMonth()) : null;
            LocalDate now = LocalDate.now();
            java.time.YearMonth of3 = java.time.YearMonth.of(now.getYear(), now.getMonthValue());
            startRestartGroup.startReplaceGroup(-1469392040);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = ExtensionsKt.daysOfWeek(DayOfWeek.MONDAY);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final List list = (List) rememberedValue;
            startRestartGroup.endReplaceGroup();
            Intrinsics.checkNotNull(of3);
            java.time.YearMonth plusYears = of3.plusYears(20L);
            Intrinsics.checkNotNullExpressionValue(plusYears, "plusYears(...)");
            java.time.YearMonth of4 = java.time.YearMonth.of(monthToShow.getYear(), monthToShow.getMonthValue());
            Intrinsics.checkNotNullExpressionValue(of4, "of(...)");
            CalendarState rememberCalendarState = CalendarStateKt.rememberCalendarState(of3, plusYears, of4, null, null, startRestartGroup, 0, 24);
            startRestartGroup.startReplaceGroup(-1469383025);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = Locale.getDefault();
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            final Locale locale = (Locale) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            CalendarKt.HorizontalCalendar(null, rememberCalendarState, false, false, false, PaddingKt.m306PaddingValues0680j_4(Dp.m2599constructorimpl(0)), null, ComposableLambdaKt.rememberComposableLambda(-1463220411, true, new Function4<BoxScope, CalendarDay, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.departures.calendar.CustomCalendarViewKt$CustomCalendarView$1
                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(BoxScope boxScope, CalendarDay calendarDay, Composer composer3, Integer num) {
                    invoke(boxScope, calendarDay, composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(BoxScope HorizontalCalendar, CalendarDay day, Composer composer3, int i7) {
                    int i8;
                    Object obj;
                    Intrinsics.checkNotNullParameter(HorizontalCalendar, "$this$HorizontalCalendar");
                    Intrinsics.checkNotNullParameter(day, "day");
                    if ((i7 & 48) == 0) {
                        i8 = i7 | (composer3.changed(day) ? 32 : 16);
                    } else {
                        i8 = i7;
                    }
                    if ((i8 & 145) == 144 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1463220411, i8, -1, "dk.molslinjen.ui.views.screens.booking.departures.calendar.CustomCalendarView.<anonymous> (CustomCalendarView.kt:67)");
                    }
                    Iterator<T> it = lowPrices.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it.next();
                        DepartureCalendarPrice departureCalendarPrice = (DepartureCalendarPrice) obj;
                        if (departureCalendarPrice.getDate().getYear() == day.getDate().getYear() && departureCalendarPrice.getDate().getMonthValue() == day.getDate().getMonthValue() && departureCalendarPrice.getDate().getDayOfMonth() == day.getDate().getDayOfMonth()) {
                            break;
                        }
                    }
                    DepartureCalendarPrice departureCalendarPrice2 = (DepartureCalendarPrice) obj;
                    boolean isBefore = day.getDate().isBefore(of);
                    boolean isAfter = localDate != null ? day.getDate().isAfter(of2) : false;
                    boolean z5 = day.getDate().toEpochDay() == currentSelectedDate.toEpochDay();
                    boolean z6 = isBefore || isAfter || !(departureCalendarPrice2 == null || departureCalendarPrice2.getHasDepartures());
                    boolean z7 = (departureCalendarPrice2 != null ? departureCalendarPrice2.getPriceIndicator() : null) == DeparturePriceIndicator.LOW_PRICE;
                    Locale locale2 = locale;
                    Intrinsics.checkNotNull(locale2);
                    CalendarDayViewKt.CalendarDayView(day, z5, z6, z7, locale2, onDatePressed, composer3, (i8 >> 3) & 14);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composer2, 54), ComposableLambdaKt.rememberComposableLambda(1741971777, true, new Function4<ColumnScope, CalendarMonth, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.departures.calendar.CustomCalendarViewKt$CustomCalendarView$2
                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, CalendarMonth calendarMonth, Composer composer3, Integer num) {
                    invoke(columnScope, calendarMonth, composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(ColumnScope HorizontalCalendar, CalendarMonth it, Composer composer3, int i7) {
                    Intrinsics.checkNotNullParameter(HorizontalCalendar, "$this$HorizontalCalendar");
                    Intrinsics.checkNotNullParameter(it, "it");
                    if ((i7 & 129) == 128 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1741971777, i7, -1, "dk.molslinjen.ui.views.screens.booking.departures.calendar.CustomCalendarView.<anonymous> (CustomCalendarView.kt:84)");
                    }
                    List<DayOfWeek> list2 = list;
                    Locale locale2 = locale;
                    Intrinsics.checkNotNull(locale2);
                    CustomCalendarViewKt.DaysOfTheWeekRow(list2, locale2, composer3, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composer2, 54), ComposableSingletons$CustomCalendarViewKt.INSTANCE.m3459getLambda1$app_kombardoProd(), null, null, composer2, 918752256, 0, 3157);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: K2.n
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit CustomCalendarView$lambda$3;
                    CustomCalendarView$lambda$3 = CustomCalendarViewKt.CustomCalendarView$lambda$3(lowPrices, currentSelectedDate, monthToShow, minDate, localDate, onDatePressed, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return CustomCalendarView$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CustomCalendarView$lambda$3(List list, LocalDate localDate, YearMonth yearMonth, LocalDate localDate2, LocalDate localDate3, Function1 function1, int i5, Composer composer, int i6) {
        CustomCalendarView(list, localDate, yearMonth, localDate2, localDate3, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DaysOfTheWeekRow(final List<? extends DayOfWeek> list, final Locale locale, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(1222287738);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(list) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(locale) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1222287738, i6, -1, "dk.molslinjen.ui.views.screens.booking.departures.calendar.DaysOfTheWeekRow (CustomCalendarView.kt:103)");
            }
            int i7 = 1;
            Object obj = null;
            float f5 = 16;
            Modifier m313paddingVpY3zN4$default = PaddingKt.m313paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m2599constructorimpl(f5), 0.0f, 2, null);
            boolean z5 = false;
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), startRestartGroup, 0);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m313paddingVpY3zN4$default);
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion.getConstructor();
            if (startRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            startRestartGroup.startReplaceGroup(1415847544);
            Iterator<? extends DayOfWeek> it = list.iterator();
            while (it.hasNext()) {
                final String displayName = it.next().getDisplayName(TextStyle.FULL, locale);
                Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), 0.0f, 0.0f, 0.0f, Dp.m2599constructorimpl(f5), 7, null);
                startRestartGroup.startReplaceGroup(1415855841);
                boolean changed = startRestartGroup.changed(displayName);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function1() { // from class: K2.o
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            Unit DaysOfTheWeekRow$lambda$6$lambda$5$lambda$4;
                            DaysOfTheWeekRow$lambda$6$lambda$5$lambda$4 = CustomCalendarViewKt.DaysOfTheWeekRow$lambda$6$lambda$5$lambda$4(displayName, (SemanticsPropertyReceiver) obj2);
                            return DaysOfTheWeekRow$lambda$6$lambda$5$lambda$4;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                Modifier semantics$default = SemanticsModifierKt.semantics$default(m315paddingqDBjuR0$default, z5, (Function1) rememberedValue, i7, obj);
                Intrinsics.checkNotNull(displayName);
                Composer composer3 = startRestartGroup;
                TextKt.m940Text4IGK_g(StringsKt.take(StringExtensionsKt.uppercaseFirstLetter(displayName), 3), semantics$default, 0L, 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(TextAlign.INSTANCE.m2528getCentere0LSkKk()), 0L, 0, false, 0, 0, null, TypographyKt.getSub(), composer3, 0, 1572864, 65020);
                z5 = z5;
                f5 = f5;
                i7 = i7;
                obj = obj;
                startRestartGroup = composer3;
            }
            composer2 = startRestartGroup;
            composer2.endReplaceGroup();
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: K2.p
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    Unit DaysOfTheWeekRow$lambda$7;
                    DaysOfTheWeekRow$lambda$7 = CustomCalendarViewKt.DaysOfTheWeekRow$lambda$7(list, locale, i5, (Composer) obj2, ((Integer) obj3).intValue());
                    return DaysOfTheWeekRow$lambda$7;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DaysOfTheWeekRow$lambda$6$lambda$5$lambda$4(String str, SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        SemanticsPropertiesKt.setContentDescription(semantics, str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DaysOfTheWeekRow$lambda$7(List list, Locale locale, int i5, Composer composer, int i6) {
        DaysOfTheWeekRow(list, locale, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
