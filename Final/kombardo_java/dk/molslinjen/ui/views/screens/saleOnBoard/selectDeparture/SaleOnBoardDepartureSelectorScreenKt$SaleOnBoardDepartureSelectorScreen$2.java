package dk.molslinjen.ui.views.screens.saleOnBoard.selectDeparture;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.navigation.NavOptions;
import com.ramcosta.composedestinations.generated.destinations.CalendarScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.SaleOnBoardFoodListScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.SaleOnBoardScreenDestination;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import dk.molslinjen.domain.managers.departure.DepartureState;
import dk.molslinjen.domain.managers.saleOnBoard.SaleOnBoardRouteState;
import dk.molslinjen.domain.model.booking.Departure;
import dk.molslinjen.ui.views.screens.booking.departures.DepartureTabState;
import dk.molslinjen.ui.views.screens.booking.departures.calendar.CalendarSheetType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import org.threeten.bp.LocalDate;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SaleOnBoardDepartureSelectorScreenKt$SaleOnBoardDepartureSelectorScreen$2 implements Function3<ColumnScope, Composer, Integer, Unit> {
    final /* synthetic */ DepartureState $departureState;
    final /* synthetic */ DepartureTabState $departureTabState;
    final /* synthetic */ DestinationsNavigator $navigator;
    final /* synthetic */ SaleOnBoardRouteState $routeState;
    final /* synthetic */ SaleOnBoardDepartureSelectorViewModel $viewModel;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SaleOnBoardDepartureSelectorScreenKt$SaleOnBoardDepartureSelectorScreen$2(SaleOnBoardRouteState saleOnBoardRouteState, DepartureState departureState, DepartureTabState departureTabState, SaleOnBoardDepartureSelectorViewModel saleOnBoardDepartureSelectorViewModel, DestinationsNavigator destinationsNavigator) {
        this.$routeState = saleOnBoardRouteState;
        this.$departureState = departureState;
        this.$departureTabState = departureTabState;
        this.$viewModel = saleOnBoardDepartureSelectorViewModel;
        this.$navigator = destinationsNavigator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$3$lambda$2(SaleOnBoardDepartureSelectorViewModel saleOnBoardDepartureSelectorViewModel, final DestinationsNavigator destinationsNavigator, Departure departure) {
        Intrinsics.checkNotNullParameter(departure, "departure");
        saleOnBoardDepartureSelectorViewModel.departureSelected(departure, new Function0() { // from class: dk.molslinjen.ui.views.screens.saleOnBoard.selectDeparture.f
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit invoke$lambda$3$lambda$2$lambda$1;
                invoke$lambda$3$lambda$2$lambda$1 = SaleOnBoardDepartureSelectorScreenKt$SaleOnBoardDepartureSelectorScreen$2.invoke$lambda$3$lambda$2$lambda$1(DestinationsNavigator.this);
                return invoke$lambda$3$lambda$2$lambda$1;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$3$lambda$2$lambda$1(DestinationsNavigator destinationsNavigator) {
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, SaleOnBoardFoodListScreenDestination.INSTANCE, NavOptions.Builder.setPopUpTo$default(new NavOptions.Builder(), SaleOnBoardScreenDestination.INSTANCE.getRoute(), false, false, 4, (Object) null).build(), null, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$9$lambda$8(DestinationsNavigator destinationsNavigator, LocalDate selectedDate) {
        Intrinsics.checkNotNullParameter(selectedDate, "selectedDate");
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, CalendarScreenDestination.invoke$default(CalendarScreenDestination.INSTANCE, selectedDate, CalendarSheetType.Regular, null, null, 12, null), null, null, 6, null);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
        invoke(columnScope, composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(ColumnScope BottomSheetContainer, Composer composer, int i5) {
        Intrinsics.checkNotNullParameter(BottomSheetContainer, "$this$BottomSheetContainer");
        if ((i5 & 17) == 16 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-929090443, i5, -1, "dk.molslinjen.ui.views.screens.saleOnBoard.selectDeparture.SaleOnBoardDepartureSelectorScreen.<anonymous> (SaleOnBoardDepartureSelectorScreen.kt:83)");
        }
        SaleOnBoardRouteState saleOnBoardRouteState = this.$routeState;
        DepartureState departureState = this.$departureState;
        DepartureTabState departureTabState = this.$departureTabState;
        SaleOnBoardDepartureSelectorViewModel saleOnBoardDepartureSelectorViewModel = this.$viewModel;
        composer.startReplaceGroup(-1469006081);
        boolean changedInstance = composer.changedInstance(saleOnBoardDepartureSelectorViewModel);
        Object rememberedValue = composer.rememberedValue();
        if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new SaleOnBoardDepartureSelectorScreenKt$SaleOnBoardDepartureSelectorScreen$2$1$1(saleOnBoardDepartureSelectorViewModel);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        Function0 function0 = (Function0) ((KFunction) rememberedValue);
        composer.startReplaceGroup(-1469003789);
        boolean changedInstance2 = composer.changedInstance(this.$viewModel) | composer.changed(this.$navigator);
        final SaleOnBoardDepartureSelectorViewModel saleOnBoardDepartureSelectorViewModel2 = this.$viewModel;
        final DestinationsNavigator destinationsNavigator = this.$navigator;
        Object rememberedValue2 = composer.rememberedValue();
        if (changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            rememberedValue2 = new Function1() { // from class: dk.molslinjen.ui.views.screens.saleOnBoard.selectDeparture.d
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit invoke$lambda$3$lambda$2;
                    invoke$lambda$3$lambda$2 = SaleOnBoardDepartureSelectorScreenKt$SaleOnBoardDepartureSelectorScreen$2.invoke$lambda$3$lambda$2(SaleOnBoardDepartureSelectorViewModel.this, destinationsNavigator, (Departure) obj);
                    return invoke$lambda$3$lambda$2;
                }
            };
            composer.updateRememberedValue(rememberedValue2);
        }
        Function1 function1 = (Function1) rememberedValue2;
        composer.endReplaceGroup();
        SaleOnBoardDepartureSelectorViewModel saleOnBoardDepartureSelectorViewModel3 = this.$viewModel;
        composer.startReplaceGroup(-1468988281);
        boolean changedInstance3 = composer.changedInstance(saleOnBoardDepartureSelectorViewModel3);
        Object rememberedValue3 = composer.rememberedValue();
        if (changedInstance3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
            rememberedValue3 = new SaleOnBoardDepartureSelectorScreenKt$SaleOnBoardDepartureSelectorScreen$2$3$1(saleOnBoardDepartureSelectorViewModel3);
            composer.updateRememberedValue(rememberedValue3);
        }
        composer.endReplaceGroup();
        Function1 function12 = (Function1) ((KFunction) rememberedValue3);
        SaleOnBoardDepartureSelectorViewModel saleOnBoardDepartureSelectorViewModel4 = this.$viewModel;
        composer.startReplaceGroup(-1468985975);
        boolean changedInstance4 = composer.changedInstance(saleOnBoardDepartureSelectorViewModel4);
        Object rememberedValue4 = composer.rememberedValue();
        if (changedInstance4 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
            rememberedValue4 = new SaleOnBoardDepartureSelectorScreenKt$SaleOnBoardDepartureSelectorScreen$2$4$1(saleOnBoardDepartureSelectorViewModel4);
            composer.updateRememberedValue(rememberedValue4);
        }
        composer.endReplaceGroup();
        Function1 function13 = (Function1) ((KFunction) rememberedValue4);
        DestinationsNavigator destinationsNavigator2 = this.$navigator;
        composer.startReplaceGroup(-1468984130);
        boolean changed = composer.changed(destinationsNavigator2);
        Object rememberedValue5 = composer.rememberedValue();
        if (changed || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
            rememberedValue5 = new SaleOnBoardDepartureSelectorScreenKt$SaleOnBoardDepartureSelectorScreen$2$5$1(destinationsNavigator2);
            composer.updateRememberedValue(rememberedValue5);
        }
        Function0 function02 = (Function0) rememberedValue5;
        composer.endReplaceGroup();
        SaleOnBoardDepartureSelectorViewModel saleOnBoardDepartureSelectorViewModel5 = this.$viewModel;
        composer.startReplaceGroup(-1468982004);
        boolean changedInstance5 = composer.changedInstance(saleOnBoardDepartureSelectorViewModel5);
        Object rememberedValue6 = composer.rememberedValue();
        if (changedInstance5 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
            rememberedValue6 = new SaleOnBoardDepartureSelectorScreenKt$SaleOnBoardDepartureSelectorScreen$2$6$1(saleOnBoardDepartureSelectorViewModel5);
            composer.updateRememberedValue(rememberedValue6);
        }
        composer.endReplaceGroup();
        Function0 function03 = (Function0) ((KFunction) rememberedValue6);
        composer.startReplaceGroup(-1468979657);
        boolean changed2 = composer.changed(this.$navigator);
        final DestinationsNavigator destinationsNavigator3 = this.$navigator;
        Object rememberedValue7 = composer.rememberedValue();
        if (changed2 || rememberedValue7 == Composer.INSTANCE.getEmpty()) {
            rememberedValue7 = new Function1() { // from class: dk.molslinjen.ui.views.screens.saleOnBoard.selectDeparture.e
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit invoke$lambda$9$lambda$8;
                    invoke$lambda$9$lambda$8 = SaleOnBoardDepartureSelectorScreenKt$SaleOnBoardDepartureSelectorScreen$2.invoke$lambda$9$lambda$8(DestinationsNavigator.this, (LocalDate) obj);
                    return invoke$lambda$9$lambda$8;
                }
            };
            composer.updateRememberedValue(rememberedValue7);
        }
        composer.endReplaceGroup();
        SaleOnBoardDepartureSelectorScreenKt.SaleOnBoardContent(saleOnBoardRouteState, departureState, departureTabState, function0, function1, function12, function13, function02, function03, (Function1) rememberedValue7, this.$viewModel.getSplitTestShowRouteSwitchWithText(), composer, 0, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
