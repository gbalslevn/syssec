package dk.molslinjen.ui.views.screens.booking.departures;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.domain.managers.departure.DepartureState;
import dk.molslinjen.domain.model.booking.DayDepartures;
import dk.molslinjen.domain.model.booking.Departure;
import dk.molslinjen.domain.model.booking.TimeTableStatus;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.reusable.IndexHolder;
import dk.molslinjen.ui.views.reusable.ItemIndexedKt;
import dk.molslinjen.ui.views.screens.booking.departures.rows.DepartureDayHeaderViewKt;
import dk.molslinjen.ui.views.screens.booking.departures.rows.EmptyDeparturesViewKt;
import dk.molslinjen.ui.views.screens.booking.departures.rows.departure.DepartureRowViewKt;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a|\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u000f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010\u000f¨\u0006\u0013"}, d2 = {"departureItemsView", BuildConfig.FLAVOR, "Landroidx/compose/foundation/lazy/LazyListScope;", "departureState", "Ldk/molslinjen/domain/managers/departure/DepartureState;", "selectedStartDate", "Lorg/threeten/bp/LocalDate;", "indexCounter", "Ldk/molslinjen/ui/views/reusable/IndexHolder;", "firstVisibleItemIndex", BuildConfig.FLAVOR, "inSelectForSaleOnBoardMode", BuildConfig.FLAVOR, "itemsEnabled", "updateShownHeaderDate", "Lkotlin/Function1;", "departureDayHeaderShown", "departureSelected", "Ldk/molslinjen/domain/model/booking/Departure;", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class DepartureItemsViewKt {
    public static final void departureItemsView(LazyListScope lazyListScope, final DepartureState departureState, LocalDate localDate, IndexHolder indexCounter, final int i5, final boolean z5, final boolean z6, final Function1<? super LocalDate, Unit> function1, final Function1<? super LocalDate, Unit> departureDayHeaderShown, final Function1<? super Departure, Unit> departureSelected) {
        final int i6 = i5;
        final Function1<? super LocalDate, Unit> updateShownHeaderDate = function1;
        Intrinsics.checkNotNullParameter(lazyListScope, "<this>");
        Intrinsics.checkNotNullParameter(departureState, "departureState");
        Intrinsics.checkNotNullParameter(indexCounter, "indexCounter");
        Intrinsics.checkNotNullParameter(updateShownHeaderDate, "updateShownHeaderDate");
        Intrinsics.checkNotNullParameter(departureDayHeaderShown, "departureDayHeaderShown");
        Intrinsics.checkNotNullParameter(departureSelected, "departureSelected");
        Iterator<DayDepartures> it = departureState.getDepartures().iterator();
        while (it.hasNext()) {
            final DayDepartures next = it.next();
            if (!Intrinsics.areEqual(localDate, next.getDate())) {
                ItemIndexedKt.itemIndexed$default(lazyListScope, indexCounter, null, null, ComposableLambdaKt.composableLambdaInstance(-13209106, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.departures.DepartureItemsViewKt$departureItemsView$1
                    @Override // kotlin.jvm.functions.Function4
                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                        invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(LazyItemScope itemIndexed, int i7, Composer composer, int i8) {
                        Intrinsics.checkNotNullParameter(itemIndexed, "$this$itemIndexed");
                        if ((i8 & 48) == 0) {
                            i8 |= composer.changed(i7) ? 32 : 16;
                        }
                        if ((i8 & 145) == 144 && composer.getSkipping()) {
                            composer.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-13209106, i8, -1, "dk.molslinjen.ui.views.screens.booking.departures.departureItemsView.<anonymous> (DepartureItemsView.kt:34)");
                        }
                        if (i6 == i7) {
                            updateShownHeaderDate.invoke(next.getDate());
                        }
                        Boolean bool = Boolean.TRUE;
                        composer.startReplaceGroup(-431119464);
                        boolean changed = composer.changed(departureDayHeaderShown) | composer.changedInstance(next);
                        Function1<LocalDate, Unit> function12 = departureDayHeaderShown;
                        DayDepartures dayDepartures = next;
                        Object rememberedValue = composer.rememberedValue();
                        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                            rememberedValue = new DepartureItemsViewKt$departureItemsView$1$1$1(function12, dayDepartures, null);
                            composer.updateRememberedValue(rememberedValue);
                        }
                        composer.endReplaceGroup();
                        EffectsKt.LaunchedEffect(bool, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue, composer, 6);
                        DepartureDayHeaderViewKt.DepartureDayHeaderView(next.getDate(), composer, 0);
                        SpacerKt.Spacer(SizeKt.m325height3ABfNKs(Modifier.INSTANCE, Dp.m2599constructorimpl(16)), composer, 6);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), 6, null);
            }
            if (!next.getDepartures().isEmpty() || next.getTimeTableStatus() == TimeTableStatus.Available) {
                boolean z7 = true;
                for (final Departure departure : next.getDepartures()) {
                    final DayDepartures dayDepartures = next;
                    boolean z8 = z7;
                    ItemIndexedKt.itemIndexed$default(lazyListScope, indexCounter, null, null, ComposableLambdaKt.composableLambdaInstance(1461224144, z8, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.departures.DepartureItemsViewKt$departureItemsView$3
                        @Override // kotlin.jvm.functions.Function4
                        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                            invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(LazyItemScope itemIndexed, int i7, Composer composer, int i8) {
                            int i9;
                            Intrinsics.checkNotNullParameter(itemIndexed, "$this$itemIndexed");
                            if ((i8 & 48) == 0) {
                                i9 = i8 | (composer.changed(i7) ? 32 : 16);
                            } else {
                                i9 = i8;
                            }
                            if ((i9 & 145) == 144 && composer.getSkipping()) {
                                composer.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1461224144, i9, -1, "dk.molslinjen.ui.views.screens.booking.departures.departureItemsView.<anonymous> (DepartureItemsView.kt:63)");
                            }
                            if (i5 == i7) {
                                function1.invoke(dayDepartures.getDate());
                            }
                            Modifier.Companion companion = Modifier.INSTANCE;
                            float f5 = 16;
                            DepartureRowViewKt.DepartureRowView(PaddingKt.m313paddingVpY3zN4$default(companion, Dp.m2599constructorimpl(f5), 0.0f, 2, null), departure, Intrinsics.areEqual(departureState.getSelectedDeparture(), departure), z6, departureSelected, z5, composer, 6, 0);
                            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f5)), composer, 6);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), 6, null);
                    z7 = z8;
                    next = next;
                }
                i6 = i5;
                updateShownHeaderDate = function1;
            } else {
                ItemIndexedKt.itemIndexed$default(lazyListScope, indexCounter, null, null, ComposableLambdaKt.composableLambdaInstance(1931842597, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.departures.DepartureItemsViewKt$departureItemsView$2

                    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
                    /* loaded from: classes2.dex */
                    public /* synthetic */ class WhenMappings {
                        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                        static {
                            int[] iArr = new int[TimeTableStatus.values().length];
                            try {
                                iArr[TimeTableStatus.AvailableLaterDate.ordinal()] = 1;
                            } catch (NoSuchFieldError unused) {
                            }
                            try {
                                iArr[TimeTableStatus.NotAvailableForEdit.ordinal()] = 2;
                            } catch (NoSuchFieldError unused2) {
                            }
                            $EnumSwitchMapping$0 = iArr;
                        }
                    }

                    @Override // kotlin.jvm.functions.Function4
                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                        invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(LazyItemScope itemIndexed, int i7, Composer composer, int i8) {
                        Intrinsics.checkNotNullParameter(itemIndexed, "$this$itemIndexed");
                        if ((i8 & 48) == 0) {
                            i8 |= composer.changed(i7) ? 32 : 16;
                        }
                        if ((i8 & 145) == 144 && composer.getSkipping()) {
                            composer.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1931842597, i8, -1, "dk.molslinjen.ui.views.screens.booking.departures.departureItemsView.<anonymous> (DepartureItemsView.kt:47)");
                        }
                        if (i6 == i7) {
                            updateShownHeaderDate.invoke(next.getDate());
                        }
                        int i9 = WhenMappings.$EnumSwitchMapping$0[next.getTimeTableStatus().ordinal()];
                        EmptyDeparturesViewKt.EmptyDeparturesView(i9 != 1 ? i9 != 2 ? R.string.departures_timeTableNotReleasedYet : R.string.departures_notAvailableForEdit : R.string.departures_noDepartureOnDay, composer, 0);
                        SpacerKt.Spacer(SizeKt.m325height3ABfNKs(Modifier.INSTANCE, Dp.m2599constructorimpl(16)), composer, 6);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), 6, null);
            }
        }
    }
}
