package dk.molslinjen.ui.views.screens.tickets;

import android.content.Context;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.material3.IconKt;
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
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.compose.LifecycleEffectKt;
import com.ramcosta.composedestinations.generated.destinations.AddExistingTicketScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.DeparturesScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.EarlyCheckInScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.TicketDetailsScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.TicketHistoryScreenDestination;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.domain.model.booking.BookingHeader;
import dk.molslinjen.domain.model.config.Harbor;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.domain.model.config.Transportation;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.ThemeShapesKt;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.buttons.OutlineDashedButtonKt;
import dk.molslinjen.ui.views.reusable.buttons.PrimaryButtonKt;
import dk.molslinjen.ui.views.screens.tickets.TicketsScreenKt;
import dk.molslinjen.ui.views.screens.tickets.TicketsViewModel;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0095\u0001\u0010\u0014\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\t2\u001e\u0010\u0010\u001a\u001a\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00040\r2\u001e\u0010\u0011\u001a\u001a\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00040\r2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00040\u0012H\u0003¢\u0006\u0004\b\u0014\u0010\u0015\u001a!\u0010\u0017\u001a\u00020\u0004*\u00020\u00162\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\tH\u0002¢\u0006\u0004\b\u0017\u0010\u0018\u001a!\u0010\u0019\u001a\u00020\u0004*\u00020\u00162\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\tH\u0002¢\u0006\u0004\b\u0019\u0010\u0018\u001a!\u0010\u001a\u001a\u00020\u0004*\u00020\u00162\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\tH\u0002¢\u0006\u0004\b\u001a\u0010\u0018¨\u0006\u001b"}, d2 = {"Ldk/molslinjen/ui/views/screens/tickets/TicketsViewModel;", "viewModel", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "navigator", BuildConfig.FLAVOR, "TicketsScreen", "(Ldk/molslinjen/ui/views/screens/tickets/TicketsViewModel;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Landroidx/compose/runtime/Composer;I)V", "Ldk/molslinjen/ui/views/screens/tickets/TicketsViewModel$ViewState;", "state", "Lkotlin/Function0;", "addTicket", "buyTicket", "showTravelHistory", "Lkotlin/Function3;", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/config/Site;", "showDetails", "startEarlyCheckIn", "Lkotlin/Function1;", "showOnMap", "TicketsContent", "(Ldk/molslinjen/ui/views/screens/tickets/TicketsViewModel$ViewState;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/foundation/lazy/LazyListScope;", "addExistingTicket", "(Landroidx/compose/foundation/lazy/LazyListScope;Lkotlin/jvm/functions/Function0;)V", "empty", "travelHistoryButton", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class TicketsScreenKt {
    private static final void TicketsContent(final TicketsViewModel.ViewState viewState, final Function0<Unit> function0, final Function0<Unit> function02, final Function0<Unit> function03, final Function3<? super String, ? super String, ? super Site, Unit> function3, final Function3<? super String, ? super String, ? super Site, Unit> function32, final Function1<? super String, Unit> function1, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(2009887390);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewState) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(function02) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(function03) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(function3) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i6 |= startRestartGroup.changedInstance(function32) ? 131072 : 65536;
        }
        if ((i5 & 1572864) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 1048576 : 524288;
        }
        if ((i6 & 599187) == 599186 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2009887390, i6, -1, "dk.molslinjen.ui.views.screens.tickets.TicketsContent (TicketsScreen.kt:96)");
            }
            Modifier m104backgroundbw27NRU$default = BackgroundKt.m104backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), AppColor.INSTANCE.m3269getGrey60d7_KjU(), null, 2, null);
            float f5 = 16;
            PaddingValues m307PaddingValuesYgX7TsA = PaddingKt.m307PaddingValuesYgX7TsA(Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(24));
            Arrangement.HorizontalOrVertical m265spacedBy0680j_4 = Arrangement.INSTANCE.m265spacedBy0680j_4(Dp.m2599constructorimpl(f5));
            startRestartGroup.startReplaceGroup(-1373815368);
            boolean changedInstance = ((i6 & 112) == 32) | startRestartGroup.changedInstance(viewState) | ((57344 & i6) == 16384) | ((458752 & i6) == 131072) | ((3670016 & i6) == 1048576) | ((i6 & 896) == 256) | ((i6 & 7168) == 2048);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                Function1 function12 = new Function1() { // from class: m4.l
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit TicketsContent$lambda$19$lambda$18;
                        TicketsContent$lambda$19$lambda$18 = TicketsScreenKt.TicketsContent$lambda$19$lambda$18(Function0.this, viewState, function02, function03, function3, function32, function1, (LazyListScope) obj);
                        return TicketsContent$lambda$19$lambda$18;
                    }
                };
                startRestartGroup.updateRememberedValue(function12);
                rememberedValue = function12;
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            LazyDslKt.LazyColumn(m104backgroundbw27NRU$default, null, m307PaddingValuesYgX7TsA, false, m265spacedBy0680j_4, null, null, false, (Function1) rememberedValue, composer2, 24582, 234);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: m4.m
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit TicketsContent$lambda$20;
                    TicketsContent$lambda$20 = TicketsScreenKt.TicketsContent$lambda$20(TicketsViewModel.ViewState.this, function0, function02, function03, function3, function32, function1, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return TicketsContent$lambda$20;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TicketsContent$lambda$19$lambda$18(Function0 function0, final TicketsViewModel.ViewState viewState, Function0 function02, Function0 function03, final Function3 function3, final Function3 function32, final Function1 function1, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        addExistingTicket(LazyColumn, function0);
        if (viewState.getIsLoading()) {
            LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$TicketsScreenKt.INSTANCE.m3541getLambda2$app_kombardoProd(), 3, null);
        }
        final List<BookingHeader> bookings = viewState.getBookings();
        final TicketsScreenKt$TicketsContent$lambda$19$lambda$18$$inlined$items$default$1 ticketsScreenKt$TicketsContent$lambda$19$lambda$18$$inlined$items$default$1 = new Function1() { // from class: dk.molslinjen.ui.views.screens.tickets.TicketsScreenKt$TicketsContent$lambda$19$lambda$18$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(BookingHeader bookingHeader) {
                return null;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke((BookingHeader) obj);
            }
        };
        LazyColumn.items(bookings.size(), null, new Function1<Integer, Object>() { // from class: dk.molslinjen.ui.views.screens.tickets.TicketsScreenKt$TicketsContent$lambda$19$lambda$18$$inlined$items$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i5) {
                return Function1.this.invoke(bookings.get(i5));
            }
        }, ComposableLambdaKt.composableLambdaInstance(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.tickets.TicketsScreenKt$TicketsContent$lambda$19$lambda$18$$inlined$items$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Removed duplicated region for block: B:50:0x0115  */
            /* JADX WARN: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke(LazyItemScope lazyItemScope, int i5, Composer composer, int i6) {
                int i7;
                boolean z5;
                if ((i6 & 6) == 0) {
                    i7 = (composer.changed(lazyItemScope) ? 4 : 2) | i6;
                } else {
                    i7 = i6;
                }
                if ((i6 & 48) == 0) {
                    i7 |= composer.changed(i5) ? 32 : 16;
                }
                if ((i7 & 147) == 146 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-632812321, i7, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:152)");
                }
                final BookingHeader bookingHeader = (BookingHeader) bookings.get(i5);
                composer.startReplaceGroup(576029786);
                Harbor departureHarbor = bookingHeader.getDepartureHarbor(viewState.getAllHarbors());
                Object obj = null;
                String fullAddress = departureHarbor != null ? departureHarbor.fullAddress() : null;
                composer.startReplaceGroup(-951244770);
                boolean changed = composer.changed(function3) | composer.changedInstance(bookingHeader);
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    final Function3 function33 = function3;
                    rememberedValue = new Function0<Unit>() { // from class: dk.molslinjen.ui.views.screens.tickets.TicketsScreenKt$TicketsContent$1$1$1$1$1
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            function33.invoke(bookingHeader.getReservationId(), bookingHeader.getPhone(), bookingHeader.getSite());
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                Function0 function04 = (Function0) rememberedValue;
                composer.endReplaceGroup();
                composer.startReplaceGroup(-951241368);
                boolean changed2 = composer.changed(function32) | composer.changedInstance(bookingHeader);
                Object rememberedValue2 = composer.rememberedValue();
                if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    final Function3 function34 = function32;
                    rememberedValue2 = new Function0<Unit>() { // from class: dk.molslinjen.ui.views.screens.tickets.TicketsScreenKt$TicketsContent$1$1$1$2$1
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            function34.invoke(bookingHeader.getReservationId(), bookingHeader.getPhone(), bookingHeader.getSite());
                        }
                    };
                    composer.updateRememberedValue(rememberedValue2);
                }
                Function0 function05 = (Function0) rememberedValue2;
                composer.endReplaceGroup();
                Function1 function12 = function1;
                List<Transportation> list = viewState.getTransportationsBySite().get(bookingHeader.getSite());
                if (list != null) {
                    Iterator<T> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Object next = it.next();
                        if (Intrinsics.areEqual(((Transportation) next).getId(), bookingHeader.getTransportationId())) {
                            obj = next;
                            break;
                        }
                    }
                    Transportation transportation = (Transportation) obj;
                    if (transportation != null) {
                        z5 = transportation.isWalking();
                        TicketRowViewKt.TicketRowView(bookingHeader, fullAddress, function04, function05, function12, false, z5, composer, 0, 32);
                        composer.endReplaceGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            return;
                        }
                        ComposerKt.traceEventEnd();
                        return;
                    }
                }
                z5 = false;
                TicketRowViewKt.TicketRowView(bookingHeader, fullAddress, function04, function05, function12, false, z5, composer, 0, 32);
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                }
            }
        }));
        if (!viewState.getIsLoading() && viewState.getBookings().isEmpty()) {
            empty(LazyColumn, function02);
        }
        travelHistoryButton(LazyColumn, function03);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TicketsContent$lambda$20(TicketsViewModel.ViewState viewState, Function0 function0, Function0 function02, Function0 function03, Function3 function3, Function3 function32, Function1 function1, int i5, Composer composer, int i6) {
        TicketsContent(viewState, function0, function02, function03, function3, function32, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void TicketsScreen(final TicketsViewModel viewModel, final DestinationsNavigator navigator, Composer composer, final int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Composer startRestartGroup = composer.startRestartGroup(-1145404975);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewModel) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(navigator) ? 32 : 16;
        }
        int i7 = i6;
        if ((i7 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1145404975, i7, -1, "dk.molslinjen.ui.views.screens.tickets.TicketsScreen (TicketsScreen.kt:49)");
            }
            TicketsViewModel.ViewState viewState = (TicketsViewModel.ViewState) SnapshotStateKt.collectAsState(viewModel.getViewState(), null, startRestartGroup, 0, 1).getValue();
            final Context context = (Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            Lifecycle.Event event = Lifecycle.Event.ON_RESUME;
            startRestartGroup.startReplaceGroup(250025661);
            boolean changedInstance = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new TicketsScreenKt$TicketsScreen$1$1(viewModel);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            LifecycleEffectKt.LifecycleEventEffect(event, null, (Function0) rememberedValue, startRestartGroup, 6, 2);
            startRestartGroup.startReplaceGroup(250028693);
            int i8 = i7 & 112;
            boolean z5 = i8 == 32;
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: m4.e
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit TicketsScreen$lambda$2$lambda$1;
                        TicketsScreen$lambda$2$lambda$1 = TicketsScreenKt.TicketsScreen$lambda$2$lambda$1(DestinationsNavigator.this);
                        return TicketsScreen$lambda$2$lambda$1;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            Function0 function0 = (Function0) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(250031909);
            boolean z6 = i8 == 32;
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (z6 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = new Function0() { // from class: m4.f
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit TicketsScreen$lambda$4$lambda$3;
                        TicketsScreen$lambda$4$lambda$3 = TicketsScreenKt.TicketsScreen$lambda$4$lambda$3(DestinationsNavigator.this);
                        return TicketsScreen$lambda$4$lambda$3;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            Function0 function02 = (Function0) rememberedValue3;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(250035857);
            boolean z7 = i8 == 32;
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (z7 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                rememberedValue4 = new Function0() { // from class: m4.g
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit TicketsScreen$lambda$6$lambda$5;
                        TicketsScreen$lambda$6$lambda$5 = TicketsScreenKt.TicketsScreen$lambda$6$lambda$5(DestinationsNavigator.this);
                        return TicketsScreen$lambda$6$lambda$5;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            Function0 function03 = (Function0) rememberedValue4;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(250039068);
            boolean z8 = i8 == 32;
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (z8 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                rememberedValue5 = new Function3() { // from class: m4.h
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit TicketsScreen$lambda$8$lambda$7;
                        TicketsScreen$lambda$8$lambda$7 = TicketsScreenKt.TicketsScreen$lambda$8$lambda$7(DestinationsNavigator.this, (String) obj, (String) obj2, (Site) obj3);
                        return TicketsScreen$lambda$8$lambda$7;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            Function3 function3 = (Function3) rememberedValue5;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(250044929);
            boolean z9 = i8 == 32;
            Object rememberedValue6 = startRestartGroup.rememberedValue();
            if (z9 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                rememberedValue6 = new Function3() { // from class: m4.i
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit TicketsScreen$lambda$10$lambda$9;
                        TicketsScreen$lambda$10$lambda$9 = TicketsScreenKt.TicketsScreen$lambda$10$lambda$9(DestinationsNavigator.this, (String) obj, (String) obj2, (Site) obj3);
                        return TicketsScreen$lambda$10$lambda$9;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue6);
            }
            Function3 function32 = (Function3) rememberedValue6;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(250054451);
            boolean changedInstance2 = startRestartGroup.changedInstance(viewModel) | startRestartGroup.changedInstance(context);
            Object rememberedValue7 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                rememberedValue7 = new Function1() { // from class: m4.j
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit TicketsScreen$lambda$12$lambda$11;
                        TicketsScreen$lambda$12$lambda$11 = TicketsScreenKt.TicketsScreen$lambda$12$lambda$11(TicketsViewModel.this, context, (String) obj);
                        return TicketsScreen$lambda$12$lambda$11;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue7);
            }
            startRestartGroup.endReplaceGroup();
            TicketsContent(viewState, function0, function02, function03, function3, function32, (Function1) rememberedValue7, startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: m4.k
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit TicketsScreen$lambda$13;
                    TicketsScreen$lambda$13 = TicketsScreenKt.TicketsScreen$lambda$13(TicketsViewModel.this, navigator, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return TicketsScreen$lambda$13;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TicketsScreen$lambda$10$lambda$9(DestinationsNavigator destinationsNavigator, String reservationNumber, String phone, Site site) {
        Intrinsics.checkNotNullParameter(reservationNumber, "reservationNumber");
        Intrinsics.checkNotNullParameter(phone, "phone");
        Intrinsics.checkNotNullParameter(site, "site");
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, EarlyCheckInScreenDestination.INSTANCE.invoke(reservationNumber, phone, site), null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TicketsScreen$lambda$12$lambda$11(TicketsViewModel ticketsViewModel, Context context, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        ticketsViewModel.showOnMap(it, context);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TicketsScreen$lambda$13(TicketsViewModel ticketsViewModel, DestinationsNavigator destinationsNavigator, int i5, Composer composer, int i6) {
        TicketsScreen(ticketsViewModel, destinationsNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TicketsScreen$lambda$2$lambda$1(DestinationsNavigator destinationsNavigator) {
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, AddExistingTicketScreenDestination.INSTANCE, null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TicketsScreen$lambda$4$lambda$3(DestinationsNavigator destinationsNavigator) {
        DestinationsNavigator.DefaultImpls.popBackStack$default(destinationsNavigator, DeparturesScreenDestination.INSTANCE, false, false, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TicketsScreen$lambda$6$lambda$5(DestinationsNavigator destinationsNavigator) {
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, TicketHistoryScreenDestination.INSTANCE, null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TicketsScreen$lambda$8$lambda$7(DestinationsNavigator destinationsNavigator, String id, String phone, Site site) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(phone, "phone");
        Intrinsics.checkNotNullParameter(site, "site");
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, TicketDetailsScreenDestination.INSTANCE.invoke(id, phone, site, false), null, null, 6, null);
        return Unit.INSTANCE;
    }

    private static final void addExistingTicket(LazyListScope lazyListScope, final Function0<Unit> function0) {
        LazyListScope.item$default(lazyListScope, null, null, ComposableLambdaKt.composableLambdaInstance(-1676805126, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.tickets.TicketsScreenKt$addExistingTicket$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                invoke(lazyItemScope, composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope item, Composer composer, int i5) {
                Intrinsics.checkNotNullParameter(item, "$this$item");
                if ((i5 & 17) == 16 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1676805126, i5, -1, "dk.molslinjen.ui.views.screens.tickets.addExistingTicket.<anonymous> (TicketsScreen.kt:134)");
                }
                OutlineDashedButtonKt.m3405OutlineDashedButtonEMNEwkI(null, StringResources_androidKt.stringResource(R.string.tickets_addExistingTicket, composer, 6), R.drawable.icon_plus_circled, AppColor.INSTANCE.m3269getGrey60d7_KjU(), 0L, 0L, function0, composer, 3456, 49);
                SpacerKt.Spacer(SizeKt.m325height3ABfNKs(Modifier.INSTANCE, Dp.m2599constructorimpl(8)), composer, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), 3, null);
    }

    private static final void empty(LazyListScope lazyListScope, final Function0<Unit> function0) {
        LazyListScope.item$default(lazyListScope, null, null, ComposableLambdaKt.composableLambdaInstance(-1558343089, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.tickets.TicketsScreenKt$empty$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                invoke(lazyItemScope, composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope item, Composer composer, int i5) {
                Intrinsics.checkNotNullParameter(item, "$this$item");
                if ((i5 & 17) == 16 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1558343089, i5, -1, "dk.molslinjen.ui.views.screens.tickets.empty.<anonymous> (TicketsScreen.kt:146)");
                }
                Modifier.Companion companion = Modifier.INSTANCE;
                Modifier clip = ClipKt.clip(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), ThemeShapesKt.getThemeShapes().getLarge());
                float m2599constructorimpl = Dp.m2599constructorimpl(1);
                AppColor appColor = AppColor.INSTANCE;
                float f5 = 16;
                Modifier m312paddingVpY3zN4 = PaddingKt.m312paddingVpY3zN4(BackgroundKt.m104backgroundbw27NRU$default(BorderKt.m108borderxT4_qwU(clip, m2599constructorimpl, appColor.m3268getGrey50d7_KjU(), ThemeShapesKt.getThemeShapes().getLarge()), appColor.m3281getWhite0d7_KjU(), null, 2, null), Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(32));
                Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                Function0<Unit> function02 = function0;
                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composer, 48);
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
                CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, m312paddingVpY3zN4);
                ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor = companion2.getConstructor();
                if (composer.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(constructor);
                } else {
                    composer.useNode();
                }
                Composer m1226constructorimpl = Updater.m1226constructorimpl(composer);
                Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion2.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                IconKt.m857Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.icon_tickets_empty, composer, 6), Accessibility.INSTANCE.getSkip(), SizeKt.m336width3ABfNKs(companion, Dp.m2599constructorimpl(48)), Color.INSTANCE.m1501getUnspecified0d7_KjU(), composer, 3456, 0);
                SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f5)), composer, 6);
                TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.tickets_empty_noActiveTickets, composer, 6), null, appColor.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(TextAlign.INSTANCE.m2528getCentere0LSkKk()), 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmall(), composer, 384, 1572864, 65018);
                SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(24)), composer, 6);
                PrimaryButtonKt.PrimaryButton(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), StringResources_androidKt.stringResource(R.string.tickets_empty_buyTicket, composer, 6), function02, null, null, false, false, false, composer, 6, 248);
                composer.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), 3, null);
    }

    private static final void travelHistoryButton(LazyListScope lazyListScope, Function0<Unit> function0) {
        LazyListScope.item$default(lazyListScope, null, null, ComposableLambdaKt.composableLambdaInstance(-137641298, true, new TicketsScreenKt$travelHistoryButton$1(function0)), 3, null);
    }
}
