package dk.molslinjen.ui.views.screens.tickets.refund;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.unit.Dp;
import com.ramcosta.composedestinations.result.ResultBackNavigator;
import dk.molslinjen.domain.managers.ticket.TicketsManager;
import dk.molslinjen.domain.model.booking.Booking;
import dk.molslinjen.domain.model.booking.BookingDeparture;
import dk.molslinjen.domain.model.booking.BookingSeatReservation;
import dk.molslinjen.domain.model.booking.BookingTicket;
import dk.molslinjen.domain.model.booking.LineItem;
import dk.molslinjen.domain.model.booking.PassengerInfo;
import dk.molslinjen.domain.model.booking.ProductType;
import dk.molslinjen.domain.model.booking.TicketCategory;
import dk.molslinjen.domain.model.booking.TicketSurcharge;
import dk.molslinjen.domain.model.booking.TransportationCargoInfo;
import dk.molslinjen.domain.model.booking.product.CheckoutSeatReservation;
import dk.molslinjen.domain.model.booking.product.ISummaryProduct;
import dk.molslinjen.domain.model.config.Transportation;
import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.reusable.HorizontalDividerKt;
import dk.molslinjen.ui.views.screens.booking.receipt.ReceiptViewKt;
import dk.molslinjen.ui.views.screens.tickets.refund.RefundReceiptScreenKt;
import dk.molslinjen.ui.views.screens.tickets.refund.RefundReceiptViewModel;
import dk.molslinjen.ui.views.shared.ticket.ticketSummary.TicketSummaryViewKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a%\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0007\u001a%\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\nH\u0003¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Ldk/molslinjen/ui/views/screens/tickets/refund/RefundReceiptViewModel;", "viewModel", "Lcom/ramcosta/composedestinations/result/ResultBackNavigator;", BuildConfig.FLAVOR, "resultNavigator", BuildConfig.FLAVOR, "RefundReceiptScreen", "(Ldk/molslinjen/ui/views/screens/tickets/refund/RefundReceiptViewModel;Lcom/ramcosta/composedestinations/result/ResultBackNavigator;Landroidx/compose/runtime/Composer;I)V", "Ldk/molslinjen/domain/model/booking/Booking;", "booking", "Lkotlin/Function0;", "dismiss", "ReceiptContent", "(Ldk/molslinjen/domain/model/booking/Booking;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class RefundReceiptScreenKt {
    private static final void ReceiptContent(final Booking booking, final Function0<Unit> function0, Composer composer, final int i5) {
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(1761852770);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(booking) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1761852770, i6, -1, "dk.molslinjen.ui.views.screens.tickets.refund.ReceiptContent (RefundReceiptScreen.kt:37)");
            }
            ReceiptViewKt.ReceiptView(StringResources_androidKt.stringResource(R.string.refund_ticketRefunded, startRestartGroup, 6), new AnnotatedString(StringResources_androidKt.stringResource(R.string.refund_onAccountInBankdays, startRestartGroup, 6), null, null, 6, null), StringResources_androidKt.stringResource(R.string.receipt_showMyTickets, startRestartGroup, 6), function0, function0, ComposableLambdaKt.rememberComposableLambda(-454843185, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.tickets.refund.RefundReceiptScreenKt$ReceiptContent$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i7) {
                    if ((i7 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-454843185, i7, -1, "dk.molslinjen.ui.views.screens.tickets.refund.ReceiptContent.<anonymous> (RefundReceiptScreen.kt:45)");
                    }
                    PriceWithCurrency refundAmount = Booking.this.getRefundAmount();
                    PriceWithCurrency refundFee = Booking.this.getRefundFee();
                    if (refundAmount != null && refundFee != null) {
                        HorizontalDividerKt.m3388HorizontalDividertZIQpXc(PaddingKt.m315paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m2599constructorimpl(8), 0.0f, Dp.m2599constructorimpl(24), 5, null), 0L, 0.0f, null, composer2, 6, 14);
                        RefundAmountsViewKt.RefundAmountsView(refundAmount, refundFee, false, composer2, 0, 4);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(624698862, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.tickets.refund.RefundReceiptScreenKt$ReceiptContent$2
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i7) {
                    Object obj;
                    if ((i7 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(624698862, i7, -1, "dk.molslinjen.ui.views.screens.tickets.refund.ReceiptContent.<anonymous> (RefundReceiptScreen.kt:53)");
                    }
                    BookingTicket ticket = Booking.this.getTicket();
                    String stringResource = StringResources_androidKt.stringResource(R.string.ticketSummary_myTravel, composer2, 6);
                    BookingDeparture departure = ticket.getDeparture();
                    TicketCategory ticketCategory = ticket.toTicketCategory();
                    Transportation transport = ticket.getTransport();
                    TransportationCargoInfo cargoInfo = ticket.getCargoInfo();
                    List<TicketSurcharge> surcharges = ticket.getSurcharges();
                    PassengerInfo passengerInfo = ticket.getPassengerInfo().toPassengerInfo();
                    List<LineItem> products = ticket.getProducts();
                    ArrayList arrayList = new ArrayList();
                    for (Object obj2 : products) {
                        if (((LineItem) obj2).getProductType() != ProductType.Catering) {
                            arrayList.add(obj2);
                        }
                    }
                    List<LineItem> products2 = ticket.getProducts();
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj3 : products2) {
                        if (((LineItem) obj3).getProductType() == ProductType.Catering) {
                            arrayList2.add(obj3);
                        }
                    }
                    BookingSeatReservation seatReservation = ticket.getSeatReservation();
                    CheckoutSeatReservation checkoutSeatReservation = seatReservation != null ? new CheckoutSeatReservation(seatReservation) : null;
                    Iterator it = ticket.getTransportProducts().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj = null;
                            break;
                        }
                        Object next = it.next();
                        Iterator it2 = it;
                        if (((LineItem) next).getProductType() == ProductType.Trailer) {
                            obj = next;
                            break;
                        }
                        it = it2;
                    }
                    ISummaryProduct iSummaryProduct = (ISummaryProduct) obj;
                    List<LineItem> transportProducts = ticket.getTransportProducts();
                    ArrayList arrayList3 = new ArrayList();
                    Iterator it3 = transportProducts.iterator();
                    while (it3.hasNext()) {
                        Object next2 = it3.next();
                        Iterator it4 = it3;
                        ISummaryProduct iSummaryProduct2 = iSummaryProduct;
                        if (((LineItem) next2).getProductType() != ProductType.Trailer) {
                            arrayList3.add(next2);
                        }
                        it3 = it4;
                        iSummaryProduct = iSummaryProduct2;
                    }
                    TicketSummaryViewKt.TicketSummaryView(stringResource, departure, ticketCategory, transport, cargoInfo, surcharges, passengerInfo, arrayList, arrayList2, checkoutSeatReservation, iSummaryProduct, arrayList3, null, Booking.this.getOrderTotal(), ticket.getTicketPrice(), Booking.this.getReservationNumber(), false, null, null, false, ticket.getPassengerInfo().getPassengerData(), !ticket.getPassengerInfo().getPassengerData().isEmpty(), false, null, null, null, ticket.getAvailableProductTypes(), ticket.getDeparture().getSubline(), null, composer2, 0, 817889280, 100663680, 59052032);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), startRestartGroup, ((i6 << 6) & 7168) | 1769472 | ((i6 << 9) & 57344));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: u4.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ReceiptContent$lambda$4;
                    ReceiptContent$lambda$4 = RefundReceiptScreenKt.ReceiptContent$lambda$4(Booking.this, function0, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return ReceiptContent$lambda$4;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ReceiptContent$lambda$4(Booking booking, Function0 function0, int i5, Composer composer, int i6) {
        ReceiptContent(booking, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void RefundReceiptScreen(final RefundReceiptViewModel viewModel, final ResultBackNavigator<Boolean> resultNavigator, Composer composer, final int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(resultNavigator, "resultNavigator");
        Composer startRestartGroup = composer.startRestartGroup(1533307353);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewModel) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(resultNavigator) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1533307353, i6, -1, "dk.molslinjen.ui.views.screens.tickets.refund.RefundReceiptScreen (RefundReceiptScreen.kt:25)");
            }
            Booking lastActiveBooking = ((TicketsManager.TicketsState) SnapshotStateKt.collectAsState(viewModel.getState(), null, startRestartGroup, 0, 1).getValue()).getLastActiveBooking();
            if (lastActiveBooking == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: u4.d
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit RefundReceiptScreen$lambda$0;
                            RefundReceiptScreen$lambda$0 = RefundReceiptScreenKt.RefundReceiptScreen$lambda$0(RefundReceiptViewModel.this, resultNavigator, i5, (Composer) obj, ((Integer) obj2).intValue());
                            return RefundReceiptScreen$lambda$0;
                        }
                    });
                    return;
                }
                return;
            }
            startRestartGroup.startReplaceGroup(802147900);
            boolean z5 = (i6 & 112) == 32;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: u4.e
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit RefundReceiptScreen$lambda$2$lambda$1;
                        RefundReceiptScreen$lambda$2$lambda$1 = RefundReceiptScreenKt.RefundReceiptScreen$lambda$2$lambda$1(ResultBackNavigator.this);
                        return RefundReceiptScreen$lambda$2$lambda$1;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            ReceiptContent(lastActiveBooking, (Function0) rememberedValue, startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup2 = startRestartGroup.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.updateScope(new Function2() { // from class: u4.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit RefundReceiptScreen$lambda$3;
                    RefundReceiptScreen$lambda$3 = RefundReceiptScreenKt.RefundReceiptScreen$lambda$3(RefundReceiptViewModel.this, resultNavigator, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return RefundReceiptScreen$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RefundReceiptScreen$lambda$0(RefundReceiptViewModel refundReceiptViewModel, ResultBackNavigator resultBackNavigator, int i5, Composer composer, int i6) {
        RefundReceiptScreen(refundReceiptViewModel, resultBackNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RefundReceiptScreen$lambda$2$lambda$1(ResultBackNavigator resultBackNavigator) {
        resultBackNavigator.navigateBack(Boolean.TRUE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RefundReceiptScreen$lambda$3(RefundReceiptViewModel refundReceiptViewModel, ResultBackNavigator resultBackNavigator, int i5, Composer composer, int i6) {
        RefundReceiptScreen(refundReceiptViewModel, resultBackNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
