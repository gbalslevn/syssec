package dk.molslinjen.ui.views.screens.booking.receipt;

import android.content.Context;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.unit.Dp;
import androidx.navigation.NavOptions;
import com.ramcosta.composedestinations.generated.destinations.DeparturesScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.ReceiptScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.SaleOnBoardScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.SignupScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.TicketsScreenDestination;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import com.ramcosta.composedestinations.result.ResultBackNavigator;
import dk.molslinjen.core.Feature;
import dk.molslinjen.domain.managers.checkout.CheckoutManager;
import dk.molslinjen.domain.managers.checkout.PriceDetails;
import dk.molslinjen.domain.managers.checkout.PriceTotal;
import dk.molslinjen.domain.model.booking.BookingPassenger;
import dk.molslinjen.domain.model.booking.BookingType;
import dk.molslinjen.domain.model.booking.Departure;
import dk.molslinjen.domain.model.booking.IDepartureInfo;
import dk.molslinjen.domain.model.booking.PassengerInfo;
import dk.molslinjen.domain.model.booking.ProductType;
import dk.molslinjen.domain.model.booking.TicketCategory;
import dk.molslinjen.domain.model.booking.TicketSurcharge;
import dk.molslinjen.domain.model.booking.TransportationCargoInfo;
import dk.molslinjen.domain.model.booking.product.CheckoutSeatReservation;
import dk.molslinjen.domain.model.booking.product.Product;
import dk.molslinjen.domain.model.booking.product.TrailerProduct;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.domain.model.config.Transportation;
import dk.molslinjen.domain.model.shared.Price;
import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.ThemeShapesKt;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.buttons.PrimaryButtonKt;
import dk.molslinjen.ui.views.screens.booking.receipt.ReceiptScreenKt;
import dk.molslinjen.ui.views.screens.booking.receipt.ReceiptViewModel;
import dk.molslinjen.ui.views.screens.booking.shared.FanoeReturnInfoViewKt;
import dk.molslinjen.ui.views.screens.profile.shared.accountCard.AccountActivationPendingCardKt;
import dk.molslinjen.ui.views.screens.profile.shared.accountCard.AccountCardData;
import dk.molslinjen.ui.views.shared.ticket.RefundBoxViewKt;
import dk.molslinjen.ui.views.shared.ticket.ticketSummary.TicketSummaryViewKt;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\u001a-\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007¢\u0006\u0004\b\b\u0010\t\u001a\u007f\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u00112\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u00112\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00070\u00152\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011H\u0003¢\u0006\u0004\b\u0019\u0010\u001a\u001a'\u0010\u001d\u001a\u00020\u00072\b\b\u0001\u0010\u001c\u001a\u00020\u001b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011H\u0003¢\u0006\u0004\b\u001d\u0010\u001e\u001a\u001d\u0010\u001f\u001a\u00020\u00072\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011H\u0003¢\u0006\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/receipt/ReceiptViewModel;", "viewModel", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "navigator", "Lcom/ramcosta/composedestinations/result/ResultBackNavigator;", BuildConfig.FLAVOR, "resultNavigator", BuildConfig.FLAVOR, "ReceiptScreen", "(Ldk/molslinjen/ui/views/screens/booking/receipt/ReceiptViewModel;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Lcom/ramcosta/composedestinations/result/ResultBackNavigator;Landroidx/compose/runtime/Composer;I)V", "Ldk/molslinjen/domain/managers/checkout/CheckoutManager$CheckoutState;", "checkoutState", "Ldk/molslinjen/domain/managers/checkout/CheckoutManager$CheckoutDirectionState;", "outboundCheckoutState", "returnCheckoutState", "Ldk/molslinjen/ui/views/screens/profile/shared/accountCard/AccountCardData;", "accountCardData", "Lkotlin/Function0;", "dismiss", "showTickets", "createProfile", "Lkotlin/Function1;", "Ldk/molslinjen/domain/model/booking/IDepartureInfo;", "addToCalendar", "goToSaleOnBoard", "ReceiptContent", "(Ldk/molslinjen/domain/managers/checkout/CheckoutManager$CheckoutState;Ldk/molslinjen/domain/managers/checkout/CheckoutManager$CheckoutDirectionState;Ldk/molslinjen/domain/managers/checkout/CheckoutManager$CheckoutDirectionState;Ldk/molslinjen/ui/views/screens/profile/shared/accountCard/AccountCardData;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", BuildConfig.FLAVOR, "description", "CreateProfileSection", "(ILkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "SaleOnBoardReorderView", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class ReceiptScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void CreateProfileSection(final int i5, final Function0<Unit> function0, Composer composer, final int i6) {
        int i7;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(1240196335);
        if ((i6 & 6) == 0) {
            i7 = (startRestartGroup.changed(i5) ? 4 : 2) | i6;
        } else {
            i7 = i6;
        }
        if ((i6 & 48) == 0) {
            i7 |= startRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i7 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1240196335, i7, -1, "dk.molslinjen.ui.views.screens.booking.receipt.CreateProfileSection (ReceiptScreen.kt:220)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier m311padding3ABfNKs = PaddingKt.m311padding3ABfNKs(BackgroundKt.m103backgroundbw27NRU(companion, AppColor.INSTANCE.m3268getGrey50d7_KjU(), ThemeShapesKt.getThemeShapes().getMedium()), Dp.m2599constructorimpl(24));
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m311padding3ABfNKs);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion2.getConstructor();
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
            Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.receipt_createProfile, startRestartGroup, 6), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphBold(), startRestartGroup, 0, 1572864, 65534);
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(i5, startRestartGroup, i7 & 14), PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, Dp.m2599constructorimpl(8), 0.0f, 0.0f, 13, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmall(), startRestartGroup, 48, 1572864, 65532);
            composer2 = startRestartGroup;
            PrimaryButtonKt.PrimaryButton(SizeKt.fillMaxWidth$default(PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, Dp.m2599constructorimpl(16), 0.0f, 0.0f, 13, null), 0.0f, 1, null), StringResources_androidKt.stringResource(R.string.receipt_createProfile_button, startRestartGroup, 6), function0, null, null, false, false, false, startRestartGroup, ((i7 << 3) & 896) | 6, 248);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: Z2.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit CreateProfileSection$lambda$16;
                    CreateProfileSection$lambda$16 = ReceiptScreenKt.CreateProfileSection$lambda$16(i5, function0, i6, (Composer) obj, ((Integer) obj2).intValue());
                    return CreateProfileSection$lambda$16;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CreateProfileSection$lambda$16(int i5, Function0 function0, int i6, Composer composer, int i7) {
        CreateProfileSection(i5, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i6 | 1));
        return Unit.INSTANCE;
    }

    private static final void ReceiptContent(final CheckoutManager.CheckoutState checkoutState, final CheckoutManager.CheckoutDirectionState checkoutDirectionState, final CheckoutManager.CheckoutDirectionState checkoutDirectionState2, final AccountCardData accountCardData, final Function0<Unit> function0, final Function0<Unit> function02, final Function0<Unit> function03, final Function1<? super IDepartureInfo, Unit> function1, final Function0<Unit> function04, Composer composer, final int i5) {
        int i6;
        int i7;
        boolean z5;
        int i8;
        ComposableLambda rememberComposableLambda;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-19125824);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(checkoutState) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(checkoutDirectionState) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(checkoutDirectionState2) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changed(accountCardData) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(function0) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i6 |= startRestartGroup.changedInstance(function02) ? 131072 : 65536;
        }
        if ((i5 & 1572864) == 0) {
            i6 |= startRestartGroup.changedInstance(function03) ? 1048576 : 524288;
        }
        if ((12582912 & i5) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 8388608 : 4194304;
        }
        if ((100663296 & i5) == 0) {
            i6 |= startRestartGroup.changedInstance(function04) ? 67108864 : 33554432;
        }
        int i9 = i6;
        if ((38347923 & i9) == 38347922 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-19125824, i9, -1, "dk.molslinjen.ui.views.screens.booking.receipt.ReceiptContent (ReceiptScreen.kt:96)");
            }
            AnnotatedString buildReceiptDescription = ReceiptViewKt.buildReceiptDescription(R.string.receipt_orderCompletedDescription, checkoutState.getPersonalInfo().getEmail(), startRestartGroup, 6);
            boolean z6 = checkoutState.getPriceDetails().getTotalPrice().getPrice().getValue() < 0;
            boolean z7 = Feature.Account.isEnabled() && accountCardData != null;
            final boolean hasCancelledSaleOnBoardOrdersOnEditedOrder = checkoutState.getHasCancelledSaleOnBoardOrdersOnEditedOrder();
            String stringResource = StringResources_androidKt.stringResource(checkoutState.getEditingBooking() != null ? R.string.receipt_ticketHasBeenChanged : R.string.receipt_thanksForYourOrder, startRestartGroup, 0);
            String stringResource2 = StringResources_androidKt.stringResource(R.string.receipt_showMyTickets, startRestartGroup, 6);
            startRestartGroup.startReplaceGroup(1305603717);
            if (z6 || z7 || hasCancelledSaleOnBoardOrdersOnEditedOrder) {
                final boolean z8 = z6;
                i7 = 54;
                z5 = true;
                final boolean z9 = z7;
                i8 = i9;
                rememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1285500338, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.receipt.ReceiptScreenKt$ReceiptContent$1
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                        invoke(composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i10) {
                        if ((i10 & 3) == 2 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1285500338, i10, -1, "dk.molslinjen.ui.views.screens.booking.receipt.ReceiptContent.<anonymous> (ReceiptScreen.kt:117)");
                        }
                        composer3.startReplaceGroup(1948825701);
                        if (z8) {
                            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(Modifier.INSTANCE, Dp.m2599constructorimpl(24)), composer3, 6);
                            RefundBoxViewKt.RefundBoxView(PriceWithCurrency.copy$default(checkoutState.getPriceDetails().getTotalPrice().getPrice(), Math.abs(checkoutState.getPriceDetails().getTotalPrice().getPrice().getValue()), null, 2, null), null, StringResources_androidKt.stringResource(R.string.receipt_refundedAfterTravel, composer3, 6), composer3, 48);
                        }
                        composer3.endReplaceGroup();
                        composer3.startReplaceGroup(1948842330);
                        if (z9 && accountCardData != null) {
                            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(Modifier.INSTANCE, Dp.m2599constructorimpl(24)), composer3, 6);
                            AccountCardData accountCardData2 = accountCardData;
                            if (accountCardData2 instanceof AccountCardData.ActivationPending) {
                                composer3.startReplaceGroup(1948849252);
                                AccountActivationPendingCardKt.AccountActivationPendingCard(null, (AccountCardData.ActivationPending) accountCardData, null, composer3, 0, 5);
                                composer3.endReplaceGroup();
                            } else if (accountCardData2 instanceof AccountCardData.Signup) {
                                composer3.startReplaceGroup(1948852768);
                                ReceiptScreenKt.CreateProfileSection(((AccountCardData.Signup) accountCardData).getDescription(), function03, composer3, 0);
                                composer3.endReplaceGroup();
                            } else {
                                composer3.startReplaceGroup(1948846745);
                                composer3.endReplaceGroup();
                                throw new NoWhenBranchMatchedException();
                            }
                        }
                        composer3.endReplaceGroup();
                        if (hasCancelledSaleOnBoardOrdersOnEditedOrder) {
                            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(Modifier.INSTANCE, Dp.m2599constructorimpl(24)), composer3, 6);
                            ReceiptScreenKt.SaleOnBoardReorderView(function04, composer3, 0);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, startRestartGroup, 54);
            } else {
                rememberComposableLambda = null;
                i7 = 54;
                z5 = true;
                i8 = i9;
            }
            startRestartGroup.endReplaceGroup();
            int i10 = i8 >> 3;
            composer2 = startRestartGroup;
            ReceiptViewKt.ReceiptView(stringResource, buildReceiptDescription, stringResource2, function0, function02, rememberComposableLambda, ComposableLambdaKt.rememberComposableLambda(-514532428, z5, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.receipt.ReceiptScreenKt$ReceiptContent$2
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i11) {
                    if ((i11 & 3) == 2 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-514532428, i11, -1, "dk.molslinjen.ui.views.screens.booking.receipt.ReceiptContent.<anonymous> (ReceiptScreen.kt:148)");
                    }
                    BookingType bookingType = CheckoutManager.CheckoutState.this.getBookingType();
                    BookingType bookingType2 = BookingType.TwoWay;
                    String stringResource3 = StringResources_androidKt.stringResource((bookingType == bookingType2 || CheckoutManager.CheckoutState.this.getSite() == Site.Fanoe) ? R.string.departures_return_outbound : R.string.ticketSummary_myTravel, composer3, 0);
                    Departure departure = checkoutDirectionState.getDeparture();
                    TicketCategory category = checkoutDirectionState.getDepartureTicket().getCategory();
                    Transportation transportation = CheckoutManager.CheckoutState.this.getTransportation();
                    TransportationCargoInfo transportationCargoInfo = checkoutDirectionState.getTransportationCargoInfo();
                    List<TicketSurcharge> surcharges = checkoutDirectionState.getDepartureTicket().getSurcharges();
                    PassengerInfo passengerInfo = checkoutDirectionState.getPassengerInfo();
                    List plus = CollectionsKt.plus((Collection) checkoutDirectionState.getAddons(), (Iterable) checkoutDirectionState.getSummaryAddons());
                    List<Product> food = checkoutDirectionState.getFood();
                    CheckoutSeatReservation seatReservation = checkoutDirectionState.getSeatReservation();
                    TrailerProduct trailer = checkoutDirectionState.getTrailer();
                    List<Product> transportProducts = checkoutDirectionState.getTransportProducts();
                    PriceDetails priceDetails = CheckoutManager.CheckoutState.this.getEditingBooking() != null ? CheckoutManager.CheckoutState.this.getPriceDetails() : null;
                    PriceTotal totalPrice = checkoutDirectionState.getTotalPrice();
                    Price price = checkoutDirectionState.getDepartureTicket().getPrice();
                    String reservationNumber = CheckoutManager.CheckoutState.this.getReservationNumber();
                    List<BookingPassenger> passengers = checkoutDirectionState.getPassengers();
                    boolean askForPersonData = checkoutDirectionState.getRouteDirectionDetails().getAskForPersonData();
                    List<ProductType> availableProductTypes = checkoutDirectionState.getDeparture().getAvailableProductTypes();
                    BookingType bookingType3 = CheckoutManager.CheckoutState.this.getBookingType();
                    composer3.startReplaceGroup(1948928422);
                    String stringResource4 = bookingType3 == bookingType2 ? StringResources_androidKt.stringResource(R.string.ticketInfo_outboundPrice, composer3, 6) : null;
                    composer3.endReplaceGroup();
                    TicketSummaryViewKt.TicketSummaryView(stringResource3, departure, category, transportation, transportationCargoInfo, surcharges, passengerInfo, plus, food, seatReservation, trailer, transportProducts, priceDetails, totalPrice, price, reservationNumber, false, function1, null, false, passengers, askForPersonData, false, null, null, stringResource4, availableProductTypes, checkoutDirectionState.getRouteDirectionDetails().getSubline(), CheckoutManager.CheckoutState.this.getLineLogoUrl(), composer3, 0, 0, 0, 30212096);
                    if (CheckoutManager.CheckoutState.this.getSite() == Site.Fanoe) {
                        composer3.startReplaceGroup(287618690);
                        SpacerKt.Spacer(SizeKt.m325height3ABfNKs(Modifier.INSTANCE, Dp.m2599constructorimpl(24)), composer3, 6);
                        FanoeReturnInfoViewKt.FanoeReturnInfoView(CheckoutManager.CheckoutState.this.getCurrency(), composer3, 0);
                        composer3.endReplaceGroup();
                    } else {
                        composer3.startReplaceGroup(287814114);
                        CheckoutManager.CheckoutDirectionState checkoutDirectionState3 = checkoutDirectionState2;
                        if (checkoutDirectionState3 != null) {
                            CheckoutManager.CheckoutState checkoutState2 = CheckoutManager.CheckoutState.this;
                            CheckoutManager.CheckoutDirectionState checkoutDirectionState4 = checkoutDirectionState;
                            Function1<IDepartureInfo, Unit> function12 = function1;
                            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(Modifier.INSTANCE, Dp.m2599constructorimpl(24)), composer3, 6);
                            TicketSummaryViewKt.TicketSummaryView(StringResources_androidKt.stringResource(R.string.departures_return_return, composer3, 6), checkoutDirectionState3.getDeparture(), checkoutDirectionState3.getDepartureTicket().getCategory(), checkoutState2.getTransportation(), checkoutDirectionState3.getTransportationCargoInfo(), checkoutDirectionState4.getDepartureTicket().getSurcharges(), checkoutDirectionState3.getPassengerInfo(), checkoutDirectionState3.getAddons(), checkoutDirectionState3.getFood(), checkoutDirectionState3.getSeatReservation(), checkoutDirectionState3.getTrailer(), checkoutDirectionState3.getTransportProducts(), null, checkoutDirectionState3.getTotalPrice(), checkoutDirectionState3.getDepartureTicket().getPrice(), checkoutState2.getReturnReservationNumber(), false, function12, null, false, checkoutDirectionState3.getPassengers(), checkoutDirectionState3.getRouteDirectionDetails().getAskForPersonData(), false, null, null, StringResources_androidKt.stringResource(R.string.ticketInfo_returnPrice, composer3, 6), checkoutDirectionState3.getDeparture().getAvailableProductTypes(), checkoutDirectionState3.getRouteDirectionDetails().getSubline(), checkoutState2.getLineLogoUrl(), composer3, 0, 0, 0, 30216192);
                            Unit unit = Unit.INSTANCE;
                        }
                        composer3.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, i7), composer2, (i10 & 57344) | (i10 & 7168) | 1572864);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: Z2.l
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ReceiptContent$lambda$14;
                    ReceiptContent$lambda$14 = ReceiptScreenKt.ReceiptContent$lambda$14(CheckoutManager.CheckoutState.this, checkoutDirectionState, checkoutDirectionState2, accountCardData, function0, function02, function03, function1, function04, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return ReceiptContent$lambda$14;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ReceiptContent$lambda$14(CheckoutManager.CheckoutState checkoutState, CheckoutManager.CheckoutDirectionState checkoutDirectionState, CheckoutManager.CheckoutDirectionState checkoutDirectionState2, AccountCardData accountCardData, Function0 function0, Function0 function02, Function0 function03, Function1 function1, Function0 function04, int i5, Composer composer, int i6) {
        ReceiptContent(checkoutState, checkoutDirectionState, checkoutDirectionState2, accountCardData, function0, function02, function03, function1, function04, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void ReceiptScreen(final ReceiptViewModel viewModel, final DestinationsNavigator navigator, final ResultBackNavigator<Boolean> resultNavigator, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Intrinsics.checkNotNullParameter(resultNavigator, "resultNavigator");
        Composer startRestartGroup = composer.startRestartGroup(590066625);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewModel) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(navigator) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changed(resultNavigator) ? 256 : 128;
        }
        if ((i6 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(590066625, i6, -1, "dk.molslinjen.ui.views.screens.booking.receipt.ReceiptScreen (ReceiptScreen.kt:45)");
            }
            CheckoutManager.CheckoutState checkoutState = (CheckoutManager.CheckoutState) SnapshotStateKt.collectAsState(viewModel.getCheckoutState(), null, startRestartGroup, 0, 1).getValue();
            if (checkoutState == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: Z2.a
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit ReceiptScreen$lambda$0;
                            ReceiptScreen$lambda$0 = ReceiptScreenKt.ReceiptScreen$lambda$0(ReceiptViewModel.this, navigator, resultNavigator, i5, (Composer) obj, ((Integer) obj2).intValue());
                            return ReceiptScreen$lambda$0;
                        }
                    });
                    return;
                }
                return;
            }
            CheckoutManager.CheckoutDirectionState checkoutDirectionState = (CheckoutManager.CheckoutDirectionState) SnapshotStateKt.collectAsState(viewModel.getOutboundCheckoutState(), null, startRestartGroup, 0, 1).getValue();
            if (checkoutDirectionState == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup2 = startRestartGroup.endRestartGroup();
                if (endRestartGroup2 != null) {
                    endRestartGroup2.updateScope(new Function2() { // from class: Z2.d
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit ReceiptScreen$lambda$1;
                            ReceiptScreen$lambda$1 = ReceiptScreenKt.ReceiptScreen$lambda$1(ReceiptViewModel.this, navigator, resultNavigator, i5, (Composer) obj, ((Integer) obj2).intValue());
                            return ReceiptScreen$lambda$1;
                        }
                    });
                    return;
                }
                return;
            }
            CheckoutManager.CheckoutDirectionState checkoutDirectionState2 = (CheckoutManager.CheckoutDirectionState) SnapshotStateKt.collectAsState(viewModel.getReturnCheckoutState(), null, startRestartGroup, 0, 1).getValue();
            AccountCardData accountCardData = (AccountCardData) SnapshotStateKt.collectAsState(viewModel.getAccountCardData(), null, startRestartGroup, 0, 1).getValue();
            final Context context = (Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            startRestartGroup.startReplaceGroup(-1464646374);
            boolean z5 = (i6 & 896) == 256;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: Z2.e
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ReceiptScreen$lambda$3$lambda$2;
                        ReceiptScreen$lambda$3$lambda$2 = ReceiptScreenKt.ReceiptScreen$lambda$3$lambda$2(ResultBackNavigator.this);
                        return ReceiptScreen$lambda$3$lambda$2;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            Function0 function0 = (Function0) rememberedValue;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-1464644173);
            int i7 = i6 & 112;
            boolean z6 = i7 == 32;
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (z6 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: Z2.f
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ReceiptScreen$lambda$5$lambda$4;
                        ReceiptScreen$lambda$5$lambda$4 = ReceiptScreenKt.ReceiptScreen$lambda$5$lambda$4(DestinationsNavigator.this);
                        return ReceiptScreen$lambda$5$lambda$4;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            Function0 function02 = (Function0) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-1464635369);
            boolean z7 = i7 == 32;
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (z7 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = new Function0() { // from class: Z2.g
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ReceiptScreen$lambda$7$lambda$6;
                        ReceiptScreen$lambda$7$lambda$6 = ReceiptScreenKt.ReceiptScreen$lambda$7$lambda$6(DestinationsNavigator.this);
                        return ReceiptScreen$lambda$7$lambda$6;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            Function0 function03 = (Function0) rememberedValue3;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-1464632400);
            boolean changedInstance = startRestartGroup.changedInstance(viewModel) | startRestartGroup.changedInstance(context);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                rememberedValue4 = new Function1() { // from class: Z2.h
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit ReceiptScreen$lambda$9$lambda$8;
                        ReceiptScreen$lambda$9$lambda$8 = ReceiptScreenKt.ReceiptScreen$lambda$9$lambda$8(ReceiptViewModel.this, context, (IDepartureInfo) obj);
                        return ReceiptScreen$lambda$9$lambda$8;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            Function1 function1 = (Function1) rememberedValue4;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-1464629369);
            boolean changedInstance2 = startRestartGroup.changedInstance(viewModel) | (i7 == 32);
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                rememberedValue5 = new Function0() { // from class: Z2.i
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ReceiptScreen$lambda$12$lambda$11;
                        ReceiptScreen$lambda$12$lambda$11 = ReceiptScreenKt.ReceiptScreen$lambda$12$lambda$11(ReceiptViewModel.this, navigator);
                        return ReceiptScreen$lambda$12$lambda$11;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            ReceiptContent(checkoutState, checkoutDirectionState, checkoutDirectionState2, accountCardData, function0, function02, function03, function1, (Function0) rememberedValue5, startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup3 = composer2.endRestartGroup();
        if (endRestartGroup3 != null) {
            endRestartGroup3.updateScope(new Function2() { // from class: Z2.j
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ReceiptScreen$lambda$13;
                    ReceiptScreen$lambda$13 = ReceiptScreenKt.ReceiptScreen$lambda$13(ReceiptViewModel.this, navigator, resultNavigator, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return ReceiptScreen$lambda$13;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ReceiptScreen$lambda$0(ReceiptViewModel receiptViewModel, DestinationsNavigator destinationsNavigator, ResultBackNavigator resultBackNavigator, int i5, Composer composer, int i6) {
        ReceiptScreen(receiptViewModel, destinationsNavigator, resultBackNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ReceiptScreen$lambda$1(ReceiptViewModel receiptViewModel, DestinationsNavigator destinationsNavigator, ResultBackNavigator resultBackNavigator, int i5, Composer composer, int i6) {
        ReceiptScreen(receiptViewModel, destinationsNavigator, resultBackNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ReceiptScreen$lambda$12$lambda$11(ReceiptViewModel receiptViewModel, final DestinationsNavigator destinationsNavigator) {
        receiptViewModel.goToSaleOnBoardReorder(new Function0() { // from class: Z2.k
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit ReceiptScreen$lambda$12$lambda$11$lambda$10;
                ReceiptScreen$lambda$12$lambda$11$lambda$10 = ReceiptScreenKt.ReceiptScreen$lambda$12$lambda$11$lambda$10(DestinationsNavigator.this);
                return ReceiptScreen$lambda$12$lambda$11$lambda$10;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ReceiptScreen$lambda$12$lambda$11$lambda$10(DestinationsNavigator destinationsNavigator) {
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, SaleOnBoardScreenDestination.INSTANCE, NavOptions.Builder.setPopUpTo$default(new NavOptions.Builder(), ReceiptScreenDestination.INSTANCE.getRoute(), true, false, 4, (Object) null).build(), null, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ReceiptScreen$lambda$13(ReceiptViewModel receiptViewModel, DestinationsNavigator destinationsNavigator, ResultBackNavigator resultBackNavigator, int i5, Composer composer, int i6) {
        ReceiptScreen(receiptViewModel, destinationsNavigator, resultBackNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ReceiptScreen$lambda$3$lambda$2(ResultBackNavigator resultBackNavigator) {
        resultBackNavigator.navigateBack(Boolean.TRUE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ReceiptScreen$lambda$5$lambda$4(DestinationsNavigator destinationsNavigator) {
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, TicketsScreenDestination.INSTANCE, NavOptions.Builder.setPopUpTo$default(new NavOptions.Builder(), DeparturesScreenDestination.INSTANCE.getRoute(), false, false, 4, (Object) null).build(), null, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ReceiptScreen$lambda$7$lambda$6(DestinationsNavigator destinationsNavigator) {
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, SignupScreenDestination.INSTANCE, null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ReceiptScreen$lambda$9$lambda$8(ReceiptViewModel receiptViewModel, Context context, IDepartureInfo it) {
        Intrinsics.checkNotNullParameter(it, "it");
        receiptViewModel.addToCalendar(context, it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SaleOnBoardReorderView(final Function0<Unit> function0, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-1794186668);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(function0) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i6 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1794186668, i6, -1, "dk.molslinjen.ui.views.screens.booking.receipt.SaleOnBoardReorderView (ReceiptScreen.kt:246)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier m311padding3ABfNKs = PaddingKt.m311padding3ABfNKs(BackgroundKt.m104backgroundbw27NRU$default(ClipKt.clip(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), ThemeShapesKt.getThemeShapes().getLarge()), AppColor.INSTANCE.m3268getGrey50d7_KjU(), null, 2, null), Dp.m2599constructorimpl(24));
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m311padding3ABfNKs);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion2.getConstructor();
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
            Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.receipt_reorderSaleOnBoard_title, startRestartGroup, 6), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphBold(), startRestartGroup, 0, 1572864, 65534);
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(8)), startRestartGroup, 6);
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.receipt_reorderSaleOnBoard_description, startRestartGroup, 6), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmall(), startRestartGroup, 0, 1572864, 65534);
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(16)), startRestartGroup, 6);
            composer2 = startRestartGroup;
            PrimaryButtonKt.PrimaryButton(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), StringResources_androidKt.stringResource(R.string.receipt_reorderSaleOnBoard_button, startRestartGroup, 6), function0, null, null, false, false, false, startRestartGroup, ((i6 << 6) & 896) | 6, 248);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: Z2.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit SaleOnBoardReorderView$lambda$18;
                    SaleOnBoardReorderView$lambda$18 = ReceiptScreenKt.SaleOnBoardReorderView$lambda$18(Function0.this, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return SaleOnBoardReorderView$lambda$18;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleOnBoardReorderView$lambda$18(Function0 function0, int i5, Composer composer, int i6) {
        SaleOnBoardReorderView(function0, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
