package dk.molslinjen.ui.views.screens.tickets.history;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import com.ramcosta.composedestinations.generated.destinations.TicketDetailsScreenDestination;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import dk.molslinjen.domain.model.booking.BookingHeader;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.views.screens.tickets.TicketRowViewKt;
import dk.molslinjen.ui.views.screens.tickets.history.TicketHistoryScreenKt;
import dk.molslinjen.ui.views.screens.tickets.history.TicketHistoryViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001aK\u0010\u0010\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u001e\u0010\f\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00040\t2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00040\rH\u0003¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Ldk/molslinjen/ui/views/screens/tickets/history/TicketHistoryViewModel;", "viewModel", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "navigator", BuildConfig.FLAVOR, "TicketHistoryScreen", "(Ldk/molslinjen/ui/views/screens/tickets/history/TicketHistoryViewModel;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Landroidx/compose/runtime/Composer;I)V", "Ldk/molslinjen/ui/views/screens/tickets/history/TicketHistoryViewModel$ViewState;", "state", "Lkotlin/Function3;", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/config/Site;", "showDetails", "Lkotlin/Function1;", BuildConfig.FLAVOR, "ticketIndexShown", "TicketHistoryContent", "(Ldk/molslinjen/ui/views/screens/tickets/history/TicketHistoryViewModel$ViewState;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class TicketHistoryScreenKt {
    private static final void TicketHistoryContent(final TicketHistoryViewModel.ViewState viewState, final Function3<? super String, ? super String, ? super Site, Unit> function3, final Function1<? super Integer, Unit> function1, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(590781775);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewState) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(function3) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if ((i6 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(590781775, i6, -1, "dk.molslinjen.ui.views.screens.tickets.history.TicketHistoryContent (TicketHistoryScreen.kt:48)");
            }
            Modifier m104backgroundbw27NRU$default = BackgroundKt.m104backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), AppColor.INSTANCE.m3269getGrey60d7_KjU(), null, 2, null);
            float f5 = 16;
            PaddingValues m307PaddingValuesYgX7TsA = PaddingKt.m307PaddingValuesYgX7TsA(Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(24));
            Arrangement.HorizontalOrVertical m265spacedBy0680j_4 = Arrangement.INSTANCE.m265spacedBy0680j_4(Dp.m2599constructorimpl(f5));
            startRestartGroup.startReplaceGroup(669434840);
            boolean changedInstance = startRestartGroup.changedInstance(viewState) | ((i6 & 112) == 32) | ((i6 & 896) == 256);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: t4.d
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit TicketHistoryContent$lambda$10$lambda$9;
                        TicketHistoryContent$lambda$10$lambda$9 = TicketHistoryScreenKt.TicketHistoryContent$lambda$10$lambda$9(TicketHistoryViewModel.ViewState.this, function3, function1, (LazyListScope) obj);
                        return TicketHistoryContent$lambda$10$lambda$9;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            LazyDslKt.LazyColumn(m104backgroundbw27NRU$default, null, m307PaddingValuesYgX7TsA, false, m265spacedBy0680j_4, null, null, false, (Function1) rememberedValue, startRestartGroup, 24582, 234);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: t4.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit TicketHistoryContent$lambda$11;
                    TicketHistoryContent$lambda$11 = TicketHistoryScreenKt.TicketHistoryContent$lambda$11(TicketHistoryViewModel.ViewState.this, function3, function1, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return TicketHistoryContent$lambda$11;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TicketHistoryContent$lambda$10$lambda$9(TicketHistoryViewModel.ViewState viewState, final Function3 function3, final Function1 function1, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        final List<BookingHeader> bookings = viewState.getBookings();
        LazyColumn.items(bookings.size(), null, new Function1<Integer, Object>() { // from class: dk.molslinjen.ui.views.screens.tickets.history.TicketHistoryScreenKt$TicketHistoryContent$lambda$10$lambda$9$$inlined$itemsIndexed$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i5) {
                bookings.get(i5);
                return null;
            }
        }, ComposableLambdaKt.composableLambdaInstance(-1091073711, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.tickets.history.TicketHistoryScreenKt$TicketHistoryContent$lambda$10$lambda$9$$inlined$itemsIndexed$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope lazyItemScope, int i5, Composer composer, int i6) {
                int i7;
                if ((i6 & 6) == 0) {
                    i7 = i6 | (composer.changed(lazyItemScope) ? 4 : 2);
                } else {
                    i7 = i6;
                }
                if ((i6 & 48) == 0) {
                    i7 |= composer.changed(i5) ? 32 : 16;
                }
                int i8 = i7;
                if ((i8 & 147) == 146 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1091073711, i8, -1, "androidx.compose.foundation.lazy.itemsIndexed.<anonymous> (LazyDsl.kt:188)");
                }
                final BookingHeader bookingHeader = (BookingHeader) bookings.get(i5);
                composer.startReplaceGroup(1216605045);
                composer.startReplaceGroup(-2038961257);
                boolean changed = composer.changed(function3) | composer.changedInstance(bookingHeader);
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    final Function3 function32 = function3;
                    rememberedValue = new Function0<Unit>() { // from class: dk.molslinjen.ui.views.screens.tickets.history.TicketHistoryScreenKt$TicketHistoryContent$1$1$1$1$1
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            function32.invoke(bookingHeader.getReservationId(), bookingHeader.getPhone(), bookingHeader.getSite());
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                Function0 function0 = (Function0) rememberedValue;
                composer.endReplaceGroup();
                composer.startReplaceGroup(-2038957931);
                Object rememberedValue2 = composer.rememberedValue();
                Composer.Companion companion = Composer.INSTANCE;
                if (rememberedValue2 == companion.getEmpty()) {
                    rememberedValue2 = new Function0<Unit>() { // from class: dk.molslinjen.ui.views.screens.tickets.history.TicketHistoryScreenKt$TicketHistoryContent$1$1$1$2$1
                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue2);
                }
                Function0 function02 = (Function0) rememberedValue2;
                composer.endReplaceGroup();
                composer.startReplaceGroup(-2038955915);
                Object rememberedValue3 = composer.rememberedValue();
                if (rememberedValue3 == companion.getEmpty()) {
                    rememberedValue3 = new Function1<String, Unit>() { // from class: dk.molslinjen.ui.views.screens.tickets.history.TicketHistoryScreenKt$TicketHistoryContent$1$1$1$3$1
                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(String it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(String str) {
                            invoke2(str);
                            return Unit.INSTANCE;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue3);
                }
                composer.endReplaceGroup();
                TicketRowViewKt.TicketRowView(bookingHeader, null, function0, function02, (Function1) rememberedValue3, true, false, composer, 1797168, 0);
                Boolean bool = Boolean.TRUE;
                composer.startReplaceGroup(-2038950677);
                boolean changed2 = composer.changed(function1) | ((((i8 & 112) ^ 48) > 32 && composer.changed(i5)) || (i8 & 48) == 32);
                Object rememberedValue4 = composer.rememberedValue();
                if (changed2 || rememberedValue4 == companion.getEmpty()) {
                    rememberedValue4 = new TicketHistoryScreenKt$TicketHistoryContent$1$1$1$4$1(function1, i5, null);
                    composer.updateRememberedValue(rememberedValue4);
                }
                composer.endReplaceGroup();
                EffectsKt.LaunchedEffect(bool, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue4, composer, 6);
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        if (viewState.getIsLoading()) {
            LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$TicketHistoryScreenKt.INSTANCE.m3554getLambda2$app_kombardoProd(), 3, null);
        }
        if (!viewState.getIsLoading() && viewState.getBookings().isEmpty()) {
            LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$TicketHistoryScreenKt.INSTANCE.m3555getLambda3$app_kombardoProd(), 3, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TicketHistoryContent$lambda$11(TicketHistoryViewModel.ViewState viewState, Function3 function3, Function1 function1, int i5, Composer composer, int i6) {
        TicketHistoryContent(viewState, function3, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void TicketHistoryScreen(final TicketHistoryViewModel viewModel, final DestinationsNavigator navigator, Composer composer, final int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Composer startRestartGroup = composer.startRestartGroup(-1963116204);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewModel) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(navigator) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1963116204, i6, -1, "dk.molslinjen.ui.views.screens.tickets.history.TicketHistoryScreen (TicketHistoryScreen.kt:24)");
            }
            TicketHistoryViewModel.ViewState viewState = (TicketHistoryViewModel.ViewState) SnapshotStateKt.collectAsState(viewModel.getViewState(), null, startRestartGroup, 0, 1).getValue();
            startRestartGroup.startReplaceGroup(-653935774);
            boolean z5 = (i6 & 112) == 32;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function3() { // from class: t4.b
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit TicketHistoryScreen$lambda$1$lambda$0;
                        TicketHistoryScreen$lambda$1$lambda$0 = TicketHistoryScreenKt.TicketHistoryScreen$lambda$1$lambda$0(DestinationsNavigator.this, (String) obj, (String) obj2, (Site) obj3);
                        return TicketHistoryScreen$lambda$1$lambda$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            Function3 function3 = (Function3) rememberedValue;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-653926263);
            boolean changedInstance = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new TicketHistoryScreenKt$TicketHistoryScreen$2$1(viewModel);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            TicketHistoryContent(viewState, function3, (Function1) ((KFunction) rememberedValue2), startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: t4.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit TicketHistoryScreen$lambda$3;
                    TicketHistoryScreen$lambda$3 = TicketHistoryScreenKt.TicketHistoryScreen$lambda$3(TicketHistoryViewModel.this, navigator, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return TicketHistoryScreen$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TicketHistoryScreen$lambda$1$lambda$0(DestinationsNavigator destinationsNavigator, String id, String phone, Site site) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(phone, "phone");
        Intrinsics.checkNotNullParameter(site, "site");
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, TicketDetailsScreenDestination.INSTANCE.invoke(id, phone, site, true), null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TicketHistoryScreen$lambda$3(TicketHistoryViewModel ticketHistoryViewModel, DestinationsNavigator destinationsNavigator, int i5, Composer composer, int i6) {
        TicketHistoryScreen(ticketHistoryViewModel, destinationsNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
