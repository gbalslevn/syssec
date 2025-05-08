package dk.molslinjen.ui.views.screens.booking.departures.calendar;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import com.ramcosta.composedestinations.result.ResultBackNavigator;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.global.navigation.bottomsheet.BlockedDismissType;
import dk.molslinjen.ui.views.global.navigation.bottomsheet.BottomSheetDismissHandler;
import dk.molslinjen.ui.views.reusable.LoadingViewKt;
import dk.molslinjen.ui.views.reusable.bottomsheet.BottomSheetContainerKt;
import dk.molslinjen.ui.views.screens.booking.departures.calendar.CalendarScreenKt;
import dk.molslinjen.ui.views.screens.booking.departures.calendar.CalendarViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;
import org.threeten.bp.YearMonth;
import uniffi.molslinjen_shared.DepartureCalendarPrice;
import uniffi.molslinjen_shared.DepartureCalendarPrices;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aE\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0007¢\u0006\u0004\b\u000e\u0010\u000f\u001a]\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00102\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\r0\u00152\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\r0\u00152\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\r0\u0019H\u0003¢\u0006\u0004\b\u001b\u0010\u001c\u001aW\u0010\u001f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00102\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\u0006\u0010\u001e\u001a\u00020\u001d2\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\r0\u00152\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\r0\u0015H\u0003¢\u0006\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/departures/calendar/CalendarViewModel;", "viewModel", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "navigator", "Landroidx/navigation/NavBackStackEntry;", "navBackStackEntry", "Landroidx/navigation/NavController;", "navController", "Ldk/molslinjen/ui/views/global/navigation/bottomsheet/BottomSheetDismissHandler;", "bottomSheetDismissHandler", "Lcom/ramcosta/composedestinations/result/ResultBackNavigator;", "Lorg/threeten/bp/LocalDate;", "resultNavigator", BuildConfig.FLAVOR, "CalendarScreen", "(Ldk/molslinjen/ui/views/screens/booking/departures/calendar/CalendarViewModel;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Landroidx/navigation/NavBackStackEntry;Landroidx/navigation/NavController;Ldk/molslinjen/ui/views/global/navigation/bottomsheet/BottomSheetDismissHandler;Lcom/ramcosta/composedestinations/result/ResultBackNavigator;Landroidx/compose/runtime/Composer;I)V", "Ldk/molslinjen/ui/views/screens/booking/departures/calendar/CalendarViewModel$ViewState;", "state", "Ldk/molslinjen/ui/views/screens/booking/departures/calendar/CalendarViewModel$ViewState$PricesState;", "Luniffi/molslinjen_shared/DepartureCalendarPrices;", "pricesState", "Lkotlin/Function1;", "Lorg/threeten/bp/YearMonth;", "onMonthChange", "onDatePressed", "Lkotlin/Function0;", "dismiss", "CalendarContent", "(Ldk/molslinjen/ui/views/screens/booking/departures/calendar/CalendarViewModel$ViewState;Ldk/molslinjen/ui/views/screens/booking/departures/calendar/CalendarViewModel$ViewState$PricesState;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/foundation/ScrollState;", "scrollState", "Content", "(Ldk/molslinjen/ui/views/screens/booking/departures/calendar/CalendarViewModel$ViewState;Ldk/molslinjen/ui/views/screens/booking/departures/calendar/CalendarViewModel$ViewState$PricesState;Landroidx/compose/foundation/ScrollState;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class CalendarScreenKt {
    private static final void CalendarContent(final CalendarViewModel.ViewState viewState, final CalendarViewModel.ViewState.PricesState<DepartureCalendarPrices> pricesState, final Function1<? super YearMonth, Unit> function1, final Function1<? super LocalDate, Unit> function12, final Function0<Unit> function0, Composer composer, final int i5) {
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(533360899);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewState) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(pricesState) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(function12) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(function0) ? 16384 : 8192;
        }
        if ((i6 & 9363) == 9362 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(533360899, i6, -1, "dk.molslinjen.ui.views.screens.booking.departures.calendar.CalendarContent (CalendarScreen.kt:97)");
            }
            final ScrollState rememberScrollState = ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1);
            BottomSheetContainerKt.m3399BottomSheetContainerZO57_FM(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, StringResources_androidKt.stringResource(R.string.calendar_choose_departure_date, startRestartGroup, 6), null, 0L, null, function0, rememberScrollState, null, ComposableLambdaKt.rememberComposableLambda(231480144, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.departures.calendar.CalendarScreenKt$CalendarContent$1
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer2, Integer num) {
                    invoke(columnScope, composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(ColumnScope BottomSheetContainer, Composer composer2, int i7) {
                    Intrinsics.checkNotNullParameter(BottomSheetContainer, "$this$BottomSheetContainer");
                    if ((i7 & 17) == 16 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(231480144, i7, -1, "dk.molslinjen.ui.views.screens.booking.departures.calendar.CalendarContent.<anonymous> (CalendarScreen.kt:106)");
                    }
                    CalendarScreenKt.Content(CalendarViewModel.ViewState.this, pricesState, rememberScrollState, function12, function1, composer2, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), startRestartGroup, ((i6 << 6) & 3670016) | 805306374, 314);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: K2.l
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit CalendarContent$lambda$5;
                    CalendarContent$lambda$5 = CalendarScreenKt.CalendarContent$lambda$5(CalendarViewModel.ViewState.this, pricesState, function1, function12, function0, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return CalendarContent$lambda$5;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CalendarContent$lambda$5(CalendarViewModel.ViewState viewState, CalendarViewModel.ViewState.PricesState pricesState, Function1 function1, Function1 function12, Function0 function0, int i5, Composer composer, int i6) {
        CalendarContent(viewState, pricesState, function1, function12, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void CalendarScreen(final CalendarViewModel viewModel, final DestinationsNavigator navigator, final NavBackStackEntry navBackStackEntry, final NavController navController, final BottomSheetDismissHandler bottomSheetDismissHandler, final ResultBackNavigator<LocalDate> resultNavigator, Composer composer, final int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Intrinsics.checkNotNullParameter(navBackStackEntry, "navBackStackEntry");
        Intrinsics.checkNotNullParameter(navController, "navController");
        Intrinsics.checkNotNullParameter(bottomSheetDismissHandler, "bottomSheetDismissHandler");
        Intrinsics.checkNotNullParameter(resultNavigator, "resultNavigator");
        Composer startRestartGroup = composer.startRestartGroup(-1445559025);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewModel) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(navigator) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(navBackStackEntry) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(navController) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(bottomSheetDismissHandler) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i6 |= startRestartGroup.changed(resultNavigator) ? 131072 : 65536;
        }
        int i7 = i6;
        if ((74899 & i7) == 74898 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1445559025, i7, -1, "dk.molslinjen.ui.views.screens.booking.departures.calendar.CalendarScreen (CalendarScreen.kt:70)");
            }
            int i8 = i7 >> 6;
            bottomSheetDismissHandler.SetupHandling(navBackStackEntry, navController, navigator, BlockedDismissType.DragToDismiss, startRestartGroup, (i8 & 112) | (i8 & 14) | 3072 | ((i7 << 3) & 896) | (57344 & i7));
            CalendarViewModel.ViewState viewState = (CalendarViewModel.ViewState) SnapshotStateKt.collectAsState(viewModel.getViewState(), null, startRestartGroup, 0, 1).getValue();
            CalendarViewModel.ViewState.PricesState pricesState = (CalendarViewModel.ViewState.PricesState) SnapshotStateKt.collectAsState(viewModel.getPricesData(), null, startRestartGroup, 0, 1).getValue();
            startRestartGroup.startReplaceGroup(1113856253);
            boolean changedInstance = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new CalendarScreenKt$CalendarScreen$1$1(viewModel);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            Function1 function1 = (Function1) ((KFunction) rememberedValue);
            startRestartGroup.startReplaceGroup(1113857911);
            boolean z5 = (i7 & 458752) == 131072;
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: K2.j
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit CalendarScreen$lambda$2$lambda$1;
                        CalendarScreen$lambda$2$lambda$1 = CalendarScreenKt.CalendarScreen$lambda$2$lambda$1(ResultBackNavigator.this, (LocalDate) obj);
                        return CalendarScreen$lambda$2$lambda$1;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            Function1 function12 = (Function1) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1113861116);
            boolean z6 = (i7 & 112) == 32;
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (z6 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = new CalendarScreenKt$CalendarScreen$3$1(navigator);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceGroup();
            CalendarContent(viewState, pricesState, function1, function12, (Function0) rememberedValue3, startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: K2.k
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit CalendarScreen$lambda$4;
                    CalendarScreen$lambda$4 = CalendarScreenKt.CalendarScreen$lambda$4(CalendarViewModel.this, navigator, navBackStackEntry, navController, bottomSheetDismissHandler, resultNavigator, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return CalendarScreen$lambda$4;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CalendarScreen$lambda$2$lambda$1(ResultBackNavigator resultBackNavigator, LocalDate selectedDate) {
        Intrinsics.checkNotNullParameter(selectedDate, "selectedDate");
        resultBackNavigator.navigateBack(selectedDate);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CalendarScreen$lambda$4(CalendarViewModel calendarViewModel, DestinationsNavigator destinationsNavigator, NavBackStackEntry navBackStackEntry, NavController navController, BottomSheetDismissHandler bottomSheetDismissHandler, ResultBackNavigator resultBackNavigator, int i5, Composer composer, int i6) {
        CalendarScreen(calendarViewModel, destinationsNavigator, navBackStackEntry, navController, bottomSheetDismissHandler, resultBackNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Content(final CalendarViewModel.ViewState viewState, final CalendarViewModel.ViewState.PricesState<DepartureCalendarPrices> pricesState, final ScrollState scrollState, final Function1<? super LocalDate, Unit> function1, final Function1<? super YearMonth, Unit> function12, Composer composer, final int i5) {
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(-31804615);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewState) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(pricesState) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changed(scrollState) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(function12) ? 16384 : 8192;
        }
        int i7 = i6;
        if ((i7 & 9363) == 9362 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-31804615, i7, -1, "dk.molslinjen.ui.views.screens.booking.departures.calendar.Content (CalendarScreen.kt:123)");
            }
            boolean z5 = pricesState instanceof CalendarViewModel.ViewState.PricesState.Success;
            List<DepartureCalendarPrice> priceIndicators = z5 ? ((DepartureCalendarPrices) ((CalendarViewModel.ViewState.PricesState.Success) pricesState).getValue()).getPriceIndicators() : CollectionsKt.emptyList();
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier verticalScroll$default = ScrollKt.verticalScroll$default(companion, scrollState, false, null, false, 14, null);
            Arrangement arrangement = Arrangement.INSTANCE;
            Arrangement.Vertical top = arrangement.getTop();
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion2.getStart(), startRestartGroup, 0);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, verticalScroll$default);
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion3.getConstructor();
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
            Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            float f5 = 8;
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f5)), startRestartGroup, 6);
            CalendarMonthPickerKt.CalendarMonthPicker(viewState.getMonthToShow(), null, function12, startRestartGroup, (i7 >> 6) & 896, 2);
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(32)), startRestartGroup, 6);
            CustomCalendarViewKt.CustomCalendarView(priceIndicators, viewState.getSelectedDate(), viewState.getMonthToShow(), viewState.getMinDate(), viewState.getMaxDate(), function1, startRestartGroup, (i7 << 6) & 458752);
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(18)), startRestartGroup, 6);
            Modifier align = columnScopeInstance.align(companion, companion2.getCenterHorizontally());
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getTop(), startRestartGroup, 0);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, align);
            Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
            if (startRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor2);
            } else {
                startRestartGroup.useNode();
            }
            Composer m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl2, rowMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion3.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            startRestartGroup.startReplaceGroup(-1280909718);
            if (viewState.getCalendarType() == CalendarSheetType.LowPrice) {
                if (Intrinsics.areEqual(pricesState, CalendarViewModel.ViewState.PricesState.Loading.INSTANCE)) {
                    startRestartGroup.startReplaceGroup(-1053365516);
                    LoadingViewKt.m3393LoadingVieworJrPs(Dp.m2599constructorimpl(20), 0, startRestartGroup, 6, 2);
                    startRestartGroup.endReplaceGroup();
                } else if (z5) {
                    startRestartGroup.startReplaceGroup(-1053189064);
                    String collapsedPriceIndicator = ((DepartureCalendarPrices) ((CalendarViewModel.ViewState.PricesState.Success) pricesState).getValue()).getCollapsedPriceIndicator();
                    if (collapsedPriceIndicator != null) {
                        Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, 0.0f, 0.0f, Dp.m2599constructorimpl(f5), 7, null);
                        float m2599constructorimpl = Dp.m2599constructorimpl(1);
                        AppColor appColor = AppColor.INSTANCE;
                        BoxKt.Box(BackgroundKt.m103backgroundbw27NRU(SizeKt.m331size3ABfNKs(BorderKt.m108borderxT4_qwU(m315paddingqDBjuR0$default, m2599constructorimpl, appColor.m3265getGrey20d7_KjU(), RoundedCornerShapeKt.getCircleShape()), Dp.m2599constructorimpl(12)), appColor.m3279getTagYellow0d7_KjU(), RoundedCornerShapeKt.getCircleShape()), startRestartGroup, 0);
                        SpacerKt.Spacer(SizeKt.m336width3ABfNKs(companion, Dp.m2599constructorimpl(f5)), startRestartGroup, 6);
                        TextKt.m940Text4IGK_g(collapsedPriceIndicator, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSubSmallBold(), startRestartGroup, 0, 1572864, 65534);
                        Unit unit = Unit.INSTANCE;
                    }
                    startRestartGroup.endReplaceGroup();
                } else {
                    startRestartGroup.startReplaceGroup(-1052439484);
                    startRestartGroup.endReplaceGroup();
                }
            }
            startRestartGroup.endReplaceGroup();
            startRestartGroup.endNode();
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: K2.m
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit Content$lambda$9;
                    Content$lambda$9 = CalendarScreenKt.Content$lambda$9(CalendarViewModel.ViewState.this, pricesState, scrollState, function1, function12, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return Content$lambda$9;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$9(CalendarViewModel.ViewState viewState, CalendarViewModel.ViewState.PricesState pricesState, ScrollState scrollState, Function1 function1, Function1 function12, int i5, Composer composer, int i6) {
        Content(viewState, pricesState, scrollState, function1, function12, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
