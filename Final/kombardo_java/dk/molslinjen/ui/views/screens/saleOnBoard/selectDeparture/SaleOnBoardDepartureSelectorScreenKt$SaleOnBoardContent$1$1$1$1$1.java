package dk.molslinjen.ui.views.screens.saleOnBoard.selectDeparture;

import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.domain.managers.departure.DepartureState;
import dk.molslinjen.domain.managers.saleOnBoard.SaleOnBoardRouteState;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.views.screens.booking.departures.rows.CalendarSelectorHeaderViewKt;
import dk.molslinjen.ui.views.screens.saleOnBoard.selectDeparture.SaleOnBoardDepartureSelectorScreenKt$SaleOnBoardContent$1$1$1$1$1;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.threeten.bp.LocalDate;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SaleOnBoardDepartureSelectorScreenKt$SaleOnBoardContent$1$1$1$1$1 implements Function4<LazyItemScope, Integer, Composer, Integer, Unit> {
    final /* synthetic */ DepartureState $departureState;
    final /* synthetic */ LazyListState $listState;
    final /* synthetic */ SaleOnBoardRouteState $routeState;
    final /* synthetic */ Function1<LocalDate, Unit> $showCalendar;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: dk.molslinjen.ui.views.screens.saleOnBoard.selectDeparture.SaleOnBoardDepartureSelectorScreenKt$SaleOnBoardContent$1$1$1$1$1$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ DepartureState $departureState;
        final /* synthetic */ SaleOnBoardRouteState $routeState;
        final /* synthetic */ Function1<LocalDate, Unit> $showCalendar;

        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(DepartureState departureState, Function1<? super LocalDate, Unit> function1, SaleOnBoardRouteState saleOnBoardRouteState) {
            this.$departureState = departureState;
            this.$showCalendar = function1;
            this.$routeState = saleOnBoardRouteState;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invoke$lambda$1$lambda$0(Function1 function1, SaleOnBoardRouteState saleOnBoardRouteState) {
            function1.invoke(saleOnBoardRouteState.getSelectedStartDate());
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i5) {
            if ((i5 & 3) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(806175978, i5, -1, "dk.molslinjen.ui.views.screens.saleOnBoard.selectDeparture.SaleOnBoardContent.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SaleOnBoardDepartureSelectorScreen.kt:157)");
            }
            LocalDate shownHeaderDate = this.$departureState.getShownHeaderDate();
            composer.startReplaceGroup(-430213138);
            boolean changed = composer.changed(this.$showCalendar) | composer.changedInstance(this.$routeState);
            final Function1<LocalDate, Unit> function1 = this.$showCalendar;
            final SaleOnBoardRouteState saleOnBoardRouteState = this.$routeState;
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: dk.molslinjen.ui.views.screens.saleOnBoard.selectDeparture.b
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit invoke$lambda$1$lambda$0;
                        invoke$lambda$1$lambda$0 = SaleOnBoardDepartureSelectorScreenKt$SaleOnBoardContent$1$1$1$1$1.AnonymousClass1.invoke$lambda$1$lambda$0(Function1.this, saleOnBoardRouteState);
                        return invoke$lambda$1$lambda$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            Function0 function0 = (Function0) rememberedValue;
            composer.endReplaceGroup();
            composer.startReplaceGroup(-430207842);
            Object rememberedValue2 = composer.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: dk.molslinjen.ui.views.screens.saleOnBoard.selectDeparture.c
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit unit;
                        unit = Unit.INSTANCE;
                        return unit;
                    }
                };
                composer.updateRememberedValue(rememberedValue2);
            }
            composer.endReplaceGroup();
            CalendarSelectorHeaderViewKt.CalendarSelectorHeaderView(shownHeaderDate, function0, (Function0) rememberedValue2, composer, 384);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public SaleOnBoardDepartureSelectorScreenKt$SaleOnBoardContent$1$1$1$1$1(SaleOnBoardRouteState saleOnBoardRouteState, LazyListState lazyListState, DepartureState departureState, Function1<? super LocalDate, Unit> function1) {
        this.$routeState = saleOnBoardRouteState;
        this.$listState = lazyListState;
        this.$departureState = departureState;
        this.$showCalendar = function1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invoke$lambda$1$lambda$0(LazyListState lazyListState, int i5) {
        return lazyListState.getFirstVisibleItemIndex() >= i5;
    }

    private static final boolean invoke$lambda$2(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
        invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(LazyItemScope stickyHeaderIndexed, final int i5, Composer composer, int i6) {
        int i7;
        Intrinsics.checkNotNullParameter(stickyHeaderIndexed, "$this$stickyHeaderIndexed");
        if ((i6 & 48) == 0) {
            i7 = i6 | (composer.changed(i5) ? 32 : 16);
        } else {
            i7 = i6;
        }
        if ((i7 & 145) == 144 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1448954144, i7, -1, "dk.molslinjen.ui.views.screens.saleOnBoard.selectDeparture.SaleOnBoardContent.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SaleOnBoardDepartureSelectorScreen.kt:151)");
        }
        if (this.$routeState != null) {
            composer.startReplaceGroup(-1678863995);
            final LazyListState lazyListState = this.$listState;
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = SnapshotStateKt.derivedStateOf(new Function0() { // from class: dk.molslinjen.ui.views.screens.saleOnBoard.selectDeparture.a
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        boolean invoke$lambda$1$lambda$0;
                        invoke$lambda$1$lambda$0 = SaleOnBoardDepartureSelectorScreenKt$SaleOnBoardContent$1$1$1$1$1.invoke$lambda$1$lambda$0(LazyListState.this, i5);
                        return Boolean.valueOf(invoke$lambda$1$lambda$0);
                    }
                });
                composer.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceGroup();
            SurfaceKt.m900SurfaceT9BRK9s(null, null, AppColor.INSTANCE.m3270getShadowColor0d7_KjU(), 0L, 0.0f, Dp.m2599constructorimpl(invoke$lambda$2((State) rememberedValue) ? 6 : 0), null, ComposableLambdaKt.rememberComposableLambda(806175978, true, new AnonymousClass1(this.$departureState, this.$showCalendar, this.$routeState), composer, 54), composer, 12583296, 91);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
