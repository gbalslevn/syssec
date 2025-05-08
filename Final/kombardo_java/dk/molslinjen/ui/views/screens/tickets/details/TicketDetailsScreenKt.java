package dk.molslinjen.ui.views.screens.tickets.details;

import android.content.Context;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
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
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import com.ramcosta.composedestinations.generated.destinations.BarcodeDetailsScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.DeparturesEditScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.EarlyCheckInProcessingScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.EarlyCheckInScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.FoodBarcodeDetailsScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.LoungeBarcodeDetailsScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.ReceiptScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.RefundReceiptScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.SaleOnBoardBarcodeDetailsScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.SimpleChangeAddonsScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.SimpleChangeFoodScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.SimpleChangeReceiptScreenDestination;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import com.ramcosta.composedestinations.result.OpenResultRecipientKt;
import com.ramcosta.composedestinations.result.ResultRecipient;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.domain.extensions.LocalDateTimeExtensionsKt;
import dk.molslinjen.domain.model.booking.Booking;
import dk.molslinjen.domain.model.booking.BookingDeparture;
import dk.molslinjen.domain.model.booking.BookingSeatReservation;
import dk.molslinjen.domain.model.booking.BookingTicket;
import dk.molslinjen.domain.model.booking.IDepartureInfo;
import dk.molslinjen.domain.model.booking.LineItem;
import dk.molslinjen.domain.model.booking.PassengerInfo;
import dk.molslinjen.domain.model.booking.ProductType;
import dk.molslinjen.domain.model.booking.TicketCategory;
import dk.molslinjen.domain.model.booking.TicketSurcharge;
import dk.molslinjen.domain.model.booking.TransportationCargoInfo;
import dk.molslinjen.domain.model.booking.product.CheckoutSeatReservation;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.domain.model.config.Transportation;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardOrder;
import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.ThemeShapesKt;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.barcode.BarcodeViewType;
import dk.molslinjen.ui.views.reusable.dialog.SimpleButtonData;
import dk.molslinjen.ui.views.reusable.dialog.TextDialogKt;
import dk.molslinjen.ui.views.screens.booking.shared.kombardoTravelDetails.TravelDetailsState;
import dk.molslinjen.ui.views.screens.tickets.barcodeDetails.BarcodeValidity;
import dk.molslinjen.ui.views.screens.tickets.details.TicketDetailsScreenKt;
import dk.molslinjen.ui.views.screens.tickets.details.TicketDetailsViewModel;
import dk.molslinjen.ui.views.screens.tickets.refund.RefundDialogKt;
import dk.molslinjen.ui.views.shared.ticket.RefundBoxViewKt;
import dk.molslinjen.ui.views.shared.ticket.ticketSummary.TicketSummaryViewKt;
import java.util.ArrayList;
import java.util.Iterator;
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
import org.threeten.bp.LocalDate;

@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u001ao\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u00042\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00060\u00042\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00060\u0004H\u0007¢\u0006\u0004\b\u000f\u0010\u0010\u001a+\u0010\u0015\u001a\u00020\u000e2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u00112\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0013H\u0003¢\u0006\u0004\b\u0015\u0010\u0016\u001aÍ\u0002\u00107\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00132\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u000e0\u001c2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00132\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000e0\u00132\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00132*\u0010'\u001a&\u0012\u0004\u0012\u00020#\u0012\u0006\u0012\u0004\u0018\u00010#\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u000e0\"j\u0002`&2\u0018\u0010*\u001a\u0014\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u000e0(2\u001e\u0010,\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0+\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u000e0(2\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u000e0\u001c2\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u000e0\u001c2\u000e\u00100\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00132\u000e\u00101\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00132\u001e\u00104\u001a\u001a\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u000e022\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020\u000e0\u001cH\u0003¢\u0006\u0004\b7\u00108\u001a×\u0001\u0010;\u001a\u00020\u000e*\u0002092\u0006\u0010:\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00172\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00132\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u000e0\u001c2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00132\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000e0\u00132\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00132*\u0010'\u001a&\u0012\u0004\u0012\u00020#\u0012\u0006\u0012\u0004\u0018\u00010#\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u000e0\"j\u0002`&2\u0006\u0010\u001a\u001a\u00020\u00192\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u000e0\u001c2\u001e\u00104\u001a\u001a\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u000e02H\u0002¢\u0006\u0004\b;\u0010<\u001a\u0017\u0010>\u001a\u00020\u000e2\u0006\u0010=\u001a\u00020#H\u0003¢\u0006\u0004\b>\u0010?\u001a\u0017\u0010B\u001a\u00020\u000e2\u0006\u0010A\u001a\u00020@H\u0003¢\u0006\u0004\bB\u0010C\u001a\u001f\u0010F\u001a\u00020\u000e2\u0006\u0010E\u001a\u00020D2\u0006\u0010=\u001a\u00020#H\u0003¢\u0006\u0004\bF\u0010G\u001am\u0010I\u001a\u00020\u000e2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u00042\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00060\u00042\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00060\u00042\f\u0010H\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0013H\u0003¢\u0006\u0004\bI\u0010J¨\u0006K"}, d2 = {"Ldk/molslinjen/ui/views/screens/tickets/details/TicketDetailsViewModel;", "viewModel", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "navigator", "Lcom/ramcosta/composedestinations/result/ResultRecipient;", "Lcom/ramcosta/composedestinations/generated/destinations/EarlyCheckInProcessingScreenDestination;", BuildConfig.FLAVOR, "earlyCheckInResultRecipient", "Lcom/ramcosta/composedestinations/generated/destinations/SimpleChangeReceiptScreenDestination;", "simpleChangeReceiptResultRecipient", "Lcom/ramcosta/composedestinations/generated/destinations/ReceiptScreenDestination;", "receiptResultRecipient", "Lcom/ramcosta/composedestinations/generated/destinations/RefundReceiptScreenDestination;", "refundReceiptResultRecipient", BuildConfig.FLAVOR, "TicketDetailsScreen", "(Ldk/molslinjen/ui/views/screens/tickets/details/TicketDetailsViewModel;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Lcom/ramcosta/composedestinations/result/ResultRecipient;Lcom/ramcosta/composedestinations/result/ResultRecipient;Lcom/ramcosta/composedestinations/result/ResultRecipient;Lcom/ramcosta/composedestinations/result/ResultRecipient;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/runtime/MutableState;", "showCancelSaleOnBoardOrderDialog", "Lkotlin/Function0;", "startEdit", "ShowCancelSaleOnBoardOrderWarning", "(Landroidx/compose/runtime/MutableState;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "Ldk/molslinjen/ui/views/screens/tickets/details/TicketDetailsViewModel$ViewState;", "state", "Ldk/molslinjen/ui/views/screens/booking/shared/kombardoTravelDetails/IKombardoTravelDetailsHandler$TravelDetailsState;", "travelDetailsState", "refund", "Lkotlin/Function1;", "Landroid/content/Context;", "shareReceipt", "editTicket", "showReceiptDisabledMessage", "showRefundDisabledMessage", "Lkotlin/Function4;", BuildConfig.FLAVOR, "Ldk/molslinjen/ui/views/reusable/barcode/BarcodeViewType;", "Ldk/molslinjen/ui/views/screens/tickets/barcodeDetails/BarcodeValidity;", "Ldk/molslinjen/ui/views/shared/components/ExpandBarcodeCallback;", "expandBarcode", "Lkotlin/Function2;", "Ldk/molslinjen/domain/model/booking/LineItem;", "showLoungeAccessBarcode", BuildConfig.FLAVOR, "showFoodBarcode", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardOrder;", "showSaleOnBoardDetails", "showOnMap", "addProducts", "addFood", "Lkotlin/Function3;", "Ldk/molslinjen/domain/model/config/Site;", "startEarlyCheckIn", "Ldk/molslinjen/domain/model/booking/IDepartureInfo;", "addToCalendar", "TicketDetailsContent", "(Ldk/molslinjen/ui/views/screens/tickets/details/TicketDetailsViewModel$ViewState;Ldk/molslinjen/ui/views/screens/booking/shared/kombardoTravelDetails/IKombardoTravelDetailsHandler$TravelDetailsState;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/foundation/lazy/LazyListScope;", "refunded", "topSection", "(Landroidx/compose/foundation/lazy/LazyListScope;ZLdk/molslinjen/ui/views/screens/tickets/details/TicketDetailsViewModel$ViewState;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function4;Ldk/molslinjen/ui/views/screens/booking/shared/kombardoTravelDetails/IKombardoTravelDetailsHandler$TravelDetailsState;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;)V", "reservationNumber", "ExpiredTicketInfo", "(Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "Lorg/threeten/bp/LocalDate;", "refundDate", "RefundedBanner", "(Lorg/threeten/bp/LocalDate;Landroidx/compose/runtime/Composer;I)V", "Ldk/molslinjen/domain/model/booking/Booking;", "booking", "RefundInfo", "(Ldk/molslinjen/domain/model/booking/Booking;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "reloadTicket", "HandleResultRecipients", "(Lcom/ramcosta/composedestinations/result/ResultRecipient;Lcom/ramcosta/composedestinations/result/ResultRecipient;Lcom/ramcosta/composedestinations/result/ResultRecipient;Lcom/ramcosta/composedestinations/result/ResultRecipient;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class TicketDetailsScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void ExpiredTicketInfo(final String str, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-1937874952);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(str) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i6 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1937874952, i6, -1, "dk.molslinjen.ui.views.screens.tickets.details.ExpiredTicketInfo (TicketDetailsScreen.kt:387)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier clip = ClipKt.clip(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), ThemeShapesKt.getThemeShapes().getMedium());
            AppColor appColor = AppColor.INSTANCE;
            float f5 = 16;
            Modifier m311padding3ABfNKs = PaddingKt.m311padding3ABfNKs(BackgroundKt.m104backgroundbw27NRU$default(clip, appColor.m3268getGrey50d7_KjU(), null, 2, null), Dp.m2599constructorimpl(f5));
            Alignment.Companion companion2 = Alignment.INSTANCE;
            Alignment.Vertical centerVertically = companion2.getCenterVertically();
            Arrangement arrangement = Arrangement.INSTANCE;
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), centerVertically, startRestartGroup, 48);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m311padding3ABfNKs);
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
            Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            IconKt.m857Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.icon_alert_warning, startRestartGroup, 6), Accessibility.INSTANCE.getSkip(), SizeKt.m331size3ABfNKs(companion, Dp.m2599constructorimpl(20)), appColor.m3266getGrey30d7_KjU(), startRestartGroup, 3456, 0);
            SpacerKt.Spacer(SizeKt.m336width3ABfNKs(companion, Dp.m2599constructorimpl(f5)), startRestartGroup, 6);
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion2.getStart(), startRestartGroup, 0);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, companion);
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
            Updater.m1227setimpl(m1226constructorimpl2, columnMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion3.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.ticketDetails_expiredTicket, startRestartGroup, 6), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), startRestartGroup, 0, 1572864, 65534);
            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getTop(), startRestartGroup, 0);
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, companion);
            Function0<ComposeUiNode> constructor3 = companion3.getConstructor();
            if (startRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor3);
            } else {
                startRestartGroup.useNode();
            }
            Composer m1226constructorimpl3 = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl3, rowMeasurePolicy2, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap3, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl3.getInserting() || !Intrinsics.areEqual(m1226constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m1227setimpl(m1226constructorimpl3, materializeModifier3, companion3.getSetModifier());
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.tickets_addExistingTicket_reservationNumber, startRestartGroup, 6) + ": ", null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), startRestartGroup, 0, 1572864, 65534);
            composer2 = startRestartGroup;
            TextKt.m940Text4IGK_g(str, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSubBold(), composer2, i6 & 14, 1572864, 65534);
            composer2.endNode();
            composer2.endNode();
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: p4.K
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ExpiredTicketInfo$lambda$53;
                    ExpiredTicketInfo$lambda$53 = TicketDetailsScreenKt.ExpiredTicketInfo$lambda$53(str, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return ExpiredTicketInfo$lambda$53;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExpiredTicketInfo$lambda$53(String str, int i5, Composer composer, int i6) {
        ExpiredTicketInfo(str, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    private static final void HandleResultRecipients(final ResultRecipient<EarlyCheckInProcessingScreenDestination, Boolean> resultRecipient, final ResultRecipient<SimpleChangeReceiptScreenDestination, Boolean> resultRecipient2, final ResultRecipient<ReceiptScreenDestination, Boolean> resultRecipient3, final ResultRecipient<RefundReceiptScreenDestination, Boolean> resultRecipient4, final Function0<Unit> function0, Composer composer, final int i5) {
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(-471780691);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(resultRecipient) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(resultRecipient2) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changed(resultRecipient3) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changed(resultRecipient4) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(function0) ? 16384 : 8192;
        }
        if ((i6 & 9363) == 9362 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-471780691, i6, -1, "dk.molslinjen.ui.views.screens.tickets.details.HandleResultRecipients (TicketDetailsScreen.kt:461)");
            }
            startRestartGroup.startReplaceGroup(832297097);
            int i7 = 57344 & i6;
            boolean z5 = i7 == 16384;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: p4.v
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit HandleResultRecipients$lambda$58$lambda$57;
                        HandleResultRecipients$lambda$58$lambda$57 = TicketDetailsScreenKt.HandleResultRecipients$lambda$58$lambda$57(Function0.this, ((Boolean) obj).booleanValue());
                        return HandleResultRecipients$lambda$58$lambda$57;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            OpenResultRecipientKt.onResult(resultRecipient, null, (Function1) rememberedValue, startRestartGroup, i6 & 14, 1);
            startRestartGroup.startReplaceGroup(832299241);
            boolean z6 = i7 == 16384;
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (z6 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: p4.x
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit HandleResultRecipients$lambda$60$lambda$59;
                        HandleResultRecipients$lambda$60$lambda$59 = TicketDetailsScreenKt.HandleResultRecipients$lambda$60$lambda$59(Function0.this, ((Boolean) obj).booleanValue());
                        return HandleResultRecipients$lambda$60$lambda$59;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            OpenResultRecipientKt.onResult(resultRecipient2, null, (Function1) rememberedValue2, startRestartGroup, (i6 >> 3) & 14, 1);
            startRestartGroup.startReplaceGroup(832301001);
            boolean z7 = i7 == 16384;
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (z7 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = new Function1() { // from class: p4.y
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit HandleResultRecipients$lambda$62$lambda$61;
                        HandleResultRecipients$lambda$62$lambda$61 = TicketDetailsScreenKt.HandleResultRecipients$lambda$62$lambda$61(Function0.this, ((Boolean) obj).booleanValue());
                        return HandleResultRecipients$lambda$62$lambda$61;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceGroup();
            OpenResultRecipientKt.onResult(resultRecipient3, null, (Function1) rememberedValue3, startRestartGroup, (i6 >> 6) & 14, 1);
            startRestartGroup.startReplaceGroup(832302953);
            boolean z8 = i7 == 16384;
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (z8 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                rememberedValue4 = new Function1() { // from class: p4.z
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit HandleResultRecipients$lambda$64$lambda$63;
                        HandleResultRecipients$lambda$64$lambda$63 = TicketDetailsScreenKt.HandleResultRecipients$lambda$64$lambda$63(Function0.this, ((Boolean) obj).booleanValue());
                        return HandleResultRecipients$lambda$64$lambda$63;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            startRestartGroup.endReplaceGroup();
            OpenResultRecipientKt.onResult(resultRecipient4, null, (Function1) rememberedValue4, startRestartGroup, (i6 >> 9) & 14, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: p4.A
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit HandleResultRecipients$lambda$65;
                    HandleResultRecipients$lambda$65 = TicketDetailsScreenKt.HandleResultRecipients$lambda$65(ResultRecipient.this, resultRecipient2, resultRecipient3, resultRecipient4, function0, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return HandleResultRecipients$lambda$65;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HandleResultRecipients$lambda$58$lambda$57(Function0 function0, boolean z5) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HandleResultRecipients$lambda$60$lambda$59(Function0 function0, boolean z5) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HandleResultRecipients$lambda$62$lambda$61(Function0 function0, boolean z5) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HandleResultRecipients$lambda$64$lambda$63(Function0 function0, boolean z5) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HandleResultRecipients$lambda$65(ResultRecipient resultRecipient, ResultRecipient resultRecipient2, ResultRecipient resultRecipient3, ResultRecipient resultRecipient4, Function0 function0, int i5, Composer composer, int i6) {
        HandleResultRecipients(resultRecipient, resultRecipient2, resultRecipient3, resultRecipient4, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void RefundInfo(final Booking booking, final String str, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-1777461272);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(booking) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(str) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1777461272, i6, -1, "dk.molslinjen.ui.views.screens.tickets.details.RefundInfo (TicketDetailsScreen.kt:435)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), startRestartGroup, 0);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, companion);
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
            Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.common_reservationNumber, startRestartGroup, 6), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getH3Bold(), startRestartGroup, 0, 1572864, 65534);
            TextKt.m940Text4IGK_g(str, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getH3(), startRestartGroup, (i6 >> 3) & 14, 1572864, 65534);
            startRestartGroup.endNode();
            composer2 = startRestartGroup;
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(24)), composer2, 6);
            RefundBoxViewKt.RefundBoxView(booking.getRefundAmount(), booking.getRefundFee(), StringResources_androidKt.stringResource(R.string.refund_onAccountInBankdays, composer2, 6), composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: p4.I
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit RefundInfo$lambda$56;
                    RefundInfo$lambda$56 = TicketDetailsScreenKt.RefundInfo$lambda$56(Booking.this, str, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return RefundInfo$lambda$56;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RefundInfo$lambda$56(Booking booking, String str, int i5, Composer composer, int i6) {
        RefundInfo(booking, str, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    private static final void RefundedBanner(final LocalDate localDate, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(1994374962);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(localDate) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i6 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1994374962, i6, -1, "dk.molslinjen.ui.views.screens.tickets.details.RefundedBanner (TicketDetailsScreen.kt:423)");
            }
            composer2 = startRestartGroup;
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.refund_refundDate, new Object[]{LocalDateTimeExtensionsKt.toFormatWeekdayWithDateLowercase(localDate)}, startRestartGroup, 6), PaddingKt.m312paddingVpY3zN4(BackgroundKt.m104backgroundbw27NRU$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), AppColor.INSTANCE.m3277getTagPurple0d7_KjU(), null, 2, null), Dp.m2599constructorimpl(16), Dp.m2599constructorimpl(10)), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), composer2, 48, 1572864, 65532);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: p4.J
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit RefundedBanner$lambda$54;
                    RefundedBanner$lambda$54 = TicketDetailsScreenKt.RefundedBanner$lambda$54(LocalDate.this, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return RefundedBanner$lambda$54;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RefundedBanner$lambda$54(LocalDate localDate, int i5, Composer composer, int i6) {
        RefundedBanner(localDate, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    private static final void ShowCancelSaleOnBoardOrderWarning(final MutableState<Boolean> mutableState, final Function0<Unit> function0, Composer composer, final int i5) {
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(-1719741978);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(mutableState) ? 4 : 2) | i5;
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
                ComposerKt.traceEventStart(-1719741978, i6, -1, "dk.molslinjen.ui.views.screens.tickets.details.ShowCancelSaleOnBoardOrderWarning (TicketDetailsScreen.kt:195)");
            }
            if (mutableState.getValue().booleanValue()) {
                String stringResource = StringResources_androidKt.stringResource(R.string.ticketDetails_cancelSaleOnBoardOrder_title, startRestartGroup, 6);
                String stringResource2 = StringResources_androidKt.stringResource(R.string.ticketDetails_cancelSaleOnBoardOrder_description, startRestartGroup, 6);
                String stringResource3 = StringResources_androidKt.stringResource(R.string.ticketDetails_cancelSaleOnBoardOrder_continueChange, startRestartGroup, 6);
                startRestartGroup.startReplaceGroup(503736405);
                int i7 = i6 & 14;
                boolean z5 = ((i6 & 112) == 32) | (i7 == 4);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (z5 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function0() { // from class: p4.q
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit ShowCancelSaleOnBoardOrderWarning$lambda$40$lambda$39;
                            ShowCancelSaleOnBoardOrderWarning$lambda$40$lambda$39 = TicketDetailsScreenKt.ShowCancelSaleOnBoardOrderWarning$lambda$40$lambda$39(MutableState.this, function0);
                            return ShowCancelSaleOnBoardOrderWarning$lambda$40$lambda$39;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                SimpleButtonData simpleButtonData = new SimpleButtonData(stringResource3, false, false, (Function0) rememberedValue, 6, null);
                String stringResource4 = StringResources_androidKt.stringResource(R.string.button_cancel, startRestartGroup, 6);
                startRestartGroup.startReplaceGroup(503745169);
                boolean z6 = i7 == 4;
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (z6 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue2 = new Function0() { // from class: p4.r
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit ShowCancelSaleOnBoardOrderWarning$lambda$42$lambda$41;
                            ShowCancelSaleOnBoardOrderWarning$lambda$42$lambda$41 = TicketDetailsScreenKt.ShowCancelSaleOnBoardOrderWarning$lambda$42$lambda$41(MutableState.this);
                            return ShowCancelSaleOnBoardOrderWarning$lambda$42$lambda$41;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceGroup();
                SimpleButtonData simpleButtonData2 = new SimpleButtonData(stringResource4, false, false, (Function0) rememberedValue2, 6, null);
                startRestartGroup.startReplaceGroup(503728977);
                boolean z7 = i7 == 4;
                Object rememberedValue3 = startRestartGroup.rememberedValue();
                if (z7 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue3 = new Function0() { // from class: p4.s
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit ShowCancelSaleOnBoardOrderWarning$lambda$44$lambda$43;
                            ShowCancelSaleOnBoardOrderWarning$lambda$44$lambda$43 = TicketDetailsScreenKt.ShowCancelSaleOnBoardOrderWarning$lambda$44$lambda$43(MutableState.this);
                            return ShowCancelSaleOnBoardOrderWarning$lambda$44$lambda$43;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                startRestartGroup.endReplaceGroup();
                TextDialogKt.TextDialog(stringResource, stringResource2, simpleButtonData, null, simpleButtonData2, false, (Function0) rememberedValue3, startRestartGroup, 0, 40);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: p4.t
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ShowCancelSaleOnBoardOrderWarning$lambda$45;
                    ShowCancelSaleOnBoardOrderWarning$lambda$45 = TicketDetailsScreenKt.ShowCancelSaleOnBoardOrderWarning$lambda$45(MutableState.this, function0, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return ShowCancelSaleOnBoardOrderWarning$lambda$45;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShowCancelSaleOnBoardOrderWarning$lambda$40$lambda$39(MutableState mutableState, Function0 function0) {
        mutableState.setValue(Boolean.FALSE);
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShowCancelSaleOnBoardOrderWarning$lambda$42$lambda$41(MutableState mutableState) {
        mutableState.setValue(Boolean.FALSE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShowCancelSaleOnBoardOrderWarning$lambda$44$lambda$43(MutableState mutableState) {
        mutableState.setValue(Boolean.FALSE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShowCancelSaleOnBoardOrderWarning$lambda$45(MutableState mutableState, Function0 function0, int i5, Composer composer, int i6) {
        ShowCancelSaleOnBoardOrderWarning(mutableState, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    private static final void TicketDetailsContent(final TicketDetailsViewModel.ViewState viewState, final TravelDetailsState travelDetailsState, final Function0<Unit> function0, final Function1<? super Context, Unit> function1, final Function0<Unit> function02, final Function0<Unit> function03, final Function0<Unit> function04, final Function4<? super String, ? super String, ? super BarcodeViewType, ? super BarcodeValidity, Unit> function4, final Function2<? super LineItem, ? super String, Unit> function2, final Function2<? super List<LineItem>, ? super String, Unit> function22, final Function1<? super SaleOnBoardOrder, Unit> function12, final Function1<? super String, Unit> function13, final Function0<Unit> function05, final Function0<Unit> function06, final Function3<? super String, ? super String, ? super Site, Unit> function3, final Function1<? super IDepartureInfo, Unit> function14, Composer composer, final int i5, final int i6) {
        int i7;
        int i8;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-1646650329);
        if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changedInstance(viewState) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changedInstance(travelDetailsState) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i7 |= startRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i7 |= startRestartGroup.changedInstance(function1) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i7 |= startRestartGroup.changedInstance(function02) ? 16384 : 8192;
        }
        if ((i5 & 196608) == 0) {
            i7 |= startRestartGroup.changedInstance(function03) ? 131072 : 65536;
        }
        if ((i5 & 1572864) == 0) {
            i7 |= startRestartGroup.changedInstance(function04) ? 1048576 : 524288;
        }
        if ((i5 & 12582912) == 0) {
            i7 |= startRestartGroup.changedInstance(function4) ? 8388608 : 4194304;
        }
        if ((i5 & 100663296) == 0) {
            i7 |= startRestartGroup.changedInstance(function2) ? 67108864 : 33554432;
        }
        if ((i5 & 805306368) == 0) {
            i7 |= startRestartGroup.changedInstance(function22) ? 536870912 : 268435456;
        }
        if ((i6 & 6) == 0) {
            i8 = i6 | (startRestartGroup.changedInstance(function12) ? 4 : 2);
        } else {
            i8 = i6;
        }
        if ((i6 & 48) == 0) {
            i8 |= startRestartGroup.changedInstance(function13) ? 32 : 16;
        }
        if ((i6 & 384) == 0) {
            i8 |= startRestartGroup.changedInstance(function05) ? 256 : 128;
        }
        if ((i6 & 3072) == 0) {
            i8 |= startRestartGroup.changedInstance(function06) ? 2048 : 1024;
        }
        if ((i6 & 24576) == 0) {
            i8 |= startRestartGroup.changedInstance(function3) ? 16384 : 8192;
        }
        if ((i6 & 196608) == 0) {
            i8 |= startRestartGroup.changedInstance(function14) ? 131072 : 65536;
        }
        int i9 = i8;
        if ((i7 & 306783379) == 306783378 && (74899 & i9) == 74898 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1646650329, i7, i9, "dk.molslinjen.ui.views.screens.tickets.details.TicketDetailsContent (TicketDetailsScreen.kt:234)");
            }
            Booking booking = viewState.getBooking();
            boolean z5 = booking != null && booking.getRefunded();
            Booking booking2 = viewState.getBooking();
            LocalDate refundDate = booking2 != null ? booking2.getRefundDate() : null;
            startRestartGroup.startReplaceGroup(-21846438);
            if (z5 && refundDate != null) {
                RefundedBanner(refundDate, startRestartGroup, 0);
            }
            startRestartGroup.endReplaceGroup();
            float f5 = 16;
            Modifier m313paddingVpY3zN4$default = PaddingKt.m313paddingVpY3zN4$default(BackgroundKt.m104backgroundbw27NRU$default(SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), AppColor.INSTANCE.m3269getGrey60d7_KjU(), null, 2, null), Dp.m2599constructorimpl(f5), 0.0f, 2, null);
            PaddingValues m310PaddingValuesa9UjIt4$default = PaddingKt.m310PaddingValuesa9UjIt4$default(0.0f, Dp.m2599constructorimpl(f5), 0.0f, Dp.m2599constructorimpl(40), 5, null);
            Arrangement.HorizontalOrVertical m265spacedBy0680j_4 = Arrangement.INSTANCE.m265spacedBy0680j_4(Dp.m2599constructorimpl(24));
            startRestartGroup.startReplaceGroup(-21831086);
            boolean changed = ((i7 & 1879048192) == 536870912) | startRestartGroup.changed(z5) | startRestartGroup.changedInstance(viewState) | ((i7 & 896) == 256) | ((i7 & 7168) == 2048) | ((57344 & i7) == 16384) | ((458752 & i7) == 131072) | ((3670016 & i7) == 1048576) | ((29360128 & i7) == 8388608) | startRestartGroup.changedInstance(travelDetailsState) | ((i9 & 112) == 32) | ((57344 & i9) == 16384) | ((234881024 & i7) == 67108864) | ((i9 & 14) == 4) | ((458752 & i9) == 131072) | ((i9 & 896) == 256) | ((i9 & 7168) == 2048);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                final boolean z6 = z5;
                rememberedValue = new Function1() { // from class: p4.E
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit TicketDetailsContent$lambda$48$lambda$47;
                        TicketDetailsContent$lambda$48$lambda$47 = TicketDetailsScreenKt.TicketDetailsContent$lambda$48$lambda$47(z6, viewState, function0, function1, function02, function03, function04, function4, travelDetailsState, function13, function3, function2, function22, function12, function14, function05, function06, (LazyListScope) obj);
                        return TicketDetailsContent$lambda$48$lambda$47;
                    }
                };
                composer2 = startRestartGroup;
                composer2.updateRememberedValue(rememberedValue);
            } else {
                composer2 = startRestartGroup;
            }
            composer2.endReplaceGroup();
            LazyDslKt.LazyColumn(m313paddingVpY3zN4$default, null, m310PaddingValuesa9UjIt4$default, false, m265spacedBy0680j_4, null, null, false, (Function1) rememberedValue, composer2, 24966, 234);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: p4.F
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit TicketDetailsContent$lambda$49;
                    TicketDetailsContent$lambda$49 = TicketDetailsScreenKt.TicketDetailsContent$lambda$49(TicketDetailsViewModel.ViewState.this, travelDetailsState, function0, function1, function02, function03, function04, function4, function2, function22, function12, function13, function05, function06, function3, function14, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                    return TicketDetailsContent$lambda$49;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TicketDetailsContent$lambda$48$lambda$47(boolean z5, final TicketDetailsViewModel.ViewState viewState, Function0 function0, Function1 function1, Function0 function02, Function0 function03, Function0 function04, Function4 function4, TravelDetailsState travelDetailsState, Function1 function12, Function3 function3, Function2 function2, Function2 function22, Function1 function13, final Function1 function14, final Function0 function05, final Function0 function06, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        topSection(LazyColumn, z5, viewState, function0, function1, function02, function03, function04, function4, travelDetailsState, function12, function3);
        final Booking booking = viewState.getBooking();
        if (booking != null) {
            final BookingTicket ticket = booking.getTicket();
            if (booking.isActive()) {
                TicketDetailsProductsSectionKt.ticketDetailsProductsSection(LazyColumn, ticket, viewState.getSaleOnBoardOrders(), function2, function22, function13);
            }
            LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-48075601, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.tickets.details.TicketDetailsScreenKt$TicketDetailsContent$1$1$1$1
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                    invoke(lazyItemScope, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(LazyItemScope item, Composer composer, int i5) {
                    Object obj;
                    Intrinsics.checkNotNullParameter(item, "$this$item");
                    if ((i5 & 17) == 16 && composer.getSkipping()) {
                        composer.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-48075601, i5, -1, "dk.molslinjen.ui.views.screens.tickets.details.TicketDetailsContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TicketDetailsScreen.kt:277)");
                    }
                    String stringResource = StringResources_androidKt.stringResource(R.string.ticketSummary_myTravel, composer, 6);
                    BookingDeparture departure = BookingTicket.this.getDeparture();
                    TicketCategory ticketCategory = BookingTicket.this.toTicketCategory();
                    Transportation transport = BookingTicket.this.getTransport();
                    TransportationCargoInfo cargoInfo = BookingTicket.this.getCargoInfo();
                    List<TicketSurcharge> surcharges = BookingTicket.this.getSurcharges();
                    PassengerInfo passengerInfo = BookingTicket.this.getPassengerInfo().toPassengerInfo();
                    List<LineItem> products = BookingTicket.this.getProducts();
                    ArrayList arrayList = new ArrayList();
                    for (Object obj2 : products) {
                        if (((LineItem) obj2).getProductType() != ProductType.Catering) {
                            arrayList.add(obj2);
                        }
                    }
                    List<LineItem> products2 = BookingTicket.this.getProducts();
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj3 : products2) {
                        if (((LineItem) obj3).getProductType() == ProductType.Catering) {
                            arrayList2.add(obj3);
                        }
                    }
                    BookingSeatReservation seatReservation = BookingTicket.this.getSeatReservation();
                    CheckoutSeatReservation checkoutSeatReservation = seatReservation != null ? new CheckoutSeatReservation(seatReservation) : null;
                    Iterator<T> it = BookingTicket.this.getTransportProducts().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            obj = it.next();
                            if (((LineItem) obj).getProductType() == ProductType.Trailer) {
                                break;
                            }
                        } else {
                            obj = null;
                            break;
                        }
                    }
                    LineItem lineItem = (LineItem) obj;
                    List<LineItem> transportProducts = BookingTicket.this.getTransportProducts();
                    ArrayList arrayList3 = new ArrayList();
                    Iterator it2 = transportProducts.iterator();
                    while (it2.hasNext()) {
                        Object next = it2.next();
                        Iterator it3 = it2;
                        if (((LineItem) next).getProductType() != ProductType.Trailer) {
                            arrayList3.add(next);
                        }
                        it2 = it3;
                    }
                    TicketSummaryViewKt.TicketSummaryView(stringResource, departure, ticketCategory, transport, cargoInfo, surcharges, passengerInfo, arrayList, arrayList2, checkoutSeatReservation, lineItem, arrayList3, null, booking.getOrderTotal(), BookingTicket.this.getTicketPrice(), booking.getReservationNumber(), false, viewState.getIsHistory() ? null : function14, null, false, BookingTicket.this.getPassengerInfo().getPassengerData(), !BookingTicket.this.getPassengerInfo().getPassengerData().isEmpty(), !booking.isActive(), (!viewState.getBooking().getCanChange() || viewState.getIsHistory()) ? null : function05, (!viewState.getBooking().getCanChange() || viewState.getIsHistory()) ? null : function06, null, BookingTicket.this.getAvailableProductTypes(), BookingTicket.this.getDeparture().getSubline(), viewState.getLineLogoUrl(), composer, 0, 805306368, 0, 33886208);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), 3, null);
        }
        if (viewState.getIsLoading()) {
            LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$TicketDetailsScreenKt.INSTANCE.m3543getLambda2$app_kombardoProd(), 3, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TicketDetailsContent$lambda$49(TicketDetailsViewModel.ViewState viewState, TravelDetailsState travelDetailsState, Function0 function0, Function1 function1, Function0 function02, Function0 function03, Function0 function04, Function4 function4, Function2 function2, Function2 function22, Function1 function12, Function1 function13, Function0 function05, Function0 function06, Function3 function3, Function1 function14, int i5, int i6, Composer composer, int i7) {
        TicketDetailsContent(viewState, travelDetailsState, function0, function1, function02, function03, function04, function4, function2, function22, function12, function13, function05, function06, function3, function14, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), RecomposeScopeImplKt.updateChangedFlags(i6));
        return Unit.INSTANCE;
    }

    public static final void TicketDetailsScreen(final TicketDetailsViewModel viewModel, final DestinationsNavigator navigator, final ResultRecipient<EarlyCheckInProcessingScreenDestination, Boolean> earlyCheckInResultRecipient, final ResultRecipient<SimpleChangeReceiptScreenDestination, Boolean> simpleChangeReceiptResultRecipient, final ResultRecipient<ReceiptScreenDestination, Boolean> receiptResultRecipient, final ResultRecipient<RefundReceiptScreenDestination, Boolean> refundReceiptResultRecipient, Composer composer, final int i5) {
        int i6;
        final TicketDetailsViewModel.ViewState viewState;
        Composer composer2;
        int i7;
        Composer composer3;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Intrinsics.checkNotNullParameter(earlyCheckInResultRecipient, "earlyCheckInResultRecipient");
        Intrinsics.checkNotNullParameter(simpleChangeReceiptResultRecipient, "simpleChangeReceiptResultRecipient");
        Intrinsics.checkNotNullParameter(receiptResultRecipient, "receiptResultRecipient");
        Intrinsics.checkNotNullParameter(refundReceiptResultRecipient, "refundReceiptResultRecipient");
        Composer startRestartGroup = composer.startRestartGroup(-1951538952);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewModel) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(navigator) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changed(earlyCheckInResultRecipient) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changed(simpleChangeReceiptResultRecipient) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changed(receiptResultRecipient) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i6 |= startRestartGroup.changed(refundReceiptResultRecipient) ? 131072 : 65536;
        }
        int i8 = i6;
        if ((74899 & i8) == 74898 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer3 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1951538952, i8, -1, "dk.molslinjen.ui.views.screens.tickets.details.TicketDetailsScreen (TicketDetailsScreen.kt:90)");
            }
            TicketDetailsViewModel.ViewState viewState2 = (TicketDetailsViewModel.ViewState) SnapshotStateKt.collectAsState(viewModel.getViewState(), null, startRestartGroup, 0, 1).getValue();
            TravelDetailsState travelDetailsState = (TravelDetailsState) SnapshotStateKt.collectAsState(viewModel.getTravelDetailsState(), null, startRestartGroup, 0, 1).getValue();
            final Context context = (Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            final boolean z5 = !viewState2.getSaleOnBoardOrders().isEmpty();
            String pdfReceiptPath = viewState2.getPdfReceiptPath();
            startRestartGroup.startReplaceGroup(-2061615085);
            boolean changedInstance = startRestartGroup.changedInstance(viewState2) | startRestartGroup.changedInstance(context) | startRestartGroup.changedInstance(viewModel);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new TicketDetailsScreenKt$TicketDetailsScreen$1$1(viewState2, context, viewModel, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(pdfReceiptPath, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue, startRestartGroup, 0);
            startRestartGroup.startReplaceGroup(-2061607093);
            boolean changedInstance2 = startRestartGroup.changedInstance(viewModel) | startRestartGroup.changedInstance(context);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: p4.l
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit TicketDetailsScreen$lambda$2$lambda$1;
                        TicketDetailsScreen$lambda$2$lambda$1 = TicketDetailsScreenKt.TicketDetailsScreen$lambda$2$lambda$1(TicketDetailsViewModel.this, context);
                        return TicketDetailsScreen$lambda$2$lambda$1;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            HandleResultRecipients(earlyCheckInResultRecipient, simpleChangeReceiptResultRecipient, receiptResultRecipient, refundReceiptResultRecipient, (Function0) rememberedValue2, startRestartGroup, (i8 >> 6) & 8190);
            Booking booking = viewState2.getBooking();
            PriceWithCurrency refundAmount = booking != null ? booking.getRefundAmount() : null;
            Booking booking2 = viewState2.getBooking();
            PriceWithCurrency refundFee = booking2 != null ? booking2.getRefundFee() : null;
            startRestartGroup.startReplaceGroup(-2061592191);
            if (viewState2.getShowRefundDialog() && viewState2.getBooking() != null && refundAmount != null && refundFee != null) {
                boolean isRefunding = viewState2.getIsRefunding();
                startRestartGroup.startReplaceGroup(-2061578619);
                boolean changedInstance3 = startRestartGroup.changedInstance(viewModel);
                Object rememberedValue3 = startRestartGroup.rememberedValue();
                if (changedInstance3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue3 = new TicketDetailsScreenKt$TicketDetailsScreen$3$1(viewModel);
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                KFunction kFunction = (KFunction) rememberedValue3;
                startRestartGroup.endReplaceGroup();
                startRestartGroup.startReplaceGroup(-2061584033);
                boolean changedInstance4 = startRestartGroup.changedInstance(viewModel) | ((i8 & 112) == 32) | startRestartGroup.changedInstance(context);
                Object rememberedValue4 = startRestartGroup.rememberedValue();
                if (changedInstance4 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue4 = new Function0() { // from class: p4.N
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit TicketDetailsScreen$lambda$6$lambda$5;
                            TicketDetailsScreen$lambda$6$lambda$5 = TicketDetailsScreenKt.TicketDetailsScreen$lambda$6$lambda$5(TicketDetailsViewModel.this, context, navigator);
                            return TicketDetailsScreen$lambda$6$lambda$5;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue4);
                }
                startRestartGroup.endReplaceGroup();
                RefundDialogKt.RefundDialog(refundAmount, refundFee, z5, isRefunding, (Function0) rememberedValue4, (Function0) kFunction, startRestartGroup, 0);
            }
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-2061573140);
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (rememberedValue5 == companion.getEmpty()) {
                rememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            final MutableState mutableState = (MutableState) rememberedValue5;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-2061567590);
            int i9 = i8 & 112;
            boolean changedInstance5 = startRestartGroup.changedInstance(viewModel) | (i9 == 32) | startRestartGroup.changedInstance(context);
            Object rememberedValue6 = startRestartGroup.rememberedValue();
            if (changedInstance5 || rememberedValue6 == companion.getEmpty()) {
                rememberedValue6 = new Function0() { // from class: p4.O
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit TicketDetailsScreen$lambda$10$lambda$9;
                        TicketDetailsScreen$lambda$10$lambda$9 = TicketDetailsScreenKt.TicketDetailsScreen$lambda$10$lambda$9(TicketDetailsViewModel.this, context, navigator);
                        return TicketDetailsScreen$lambda$10$lambda$9;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue6);
            }
            startRestartGroup.endReplaceGroup();
            ShowCancelSaleOnBoardOrderWarning(mutableState, (Function0) rememberedValue6, startRestartGroup, 6);
            startRestartGroup.startReplaceGroup(-2061560155);
            boolean changedInstance6 = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue7 = startRestartGroup.rememberedValue();
            if (changedInstance6 || rememberedValue7 == companion.getEmpty()) {
                rememberedValue7 = new TicketDetailsScreenKt$TicketDetailsScreen$6$1(viewModel);
                startRestartGroup.updateRememberedValue(rememberedValue7);
            }
            KFunction kFunction2 = (KFunction) rememberedValue7;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-2061558495);
            boolean changedInstance7 = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue8 = startRestartGroup.rememberedValue();
            if (changedInstance7 || rememberedValue8 == companion.getEmpty()) {
                rememberedValue8 = new TicketDetailsScreenKt$TicketDetailsScreen$7$1(viewModel);
                startRestartGroup.updateRememberedValue(rememberedValue8);
            }
            KFunction kFunction3 = (KFunction) rememberedValue8;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-2061540881);
            boolean changedInstance8 = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue9 = startRestartGroup.rememberedValue();
            if (changedInstance8 || rememberedValue9 == companion.getEmpty()) {
                rememberedValue9 = new TicketDetailsScreenKt$TicketDetailsScreen$8$1(viewModel);
                startRestartGroup.updateRememberedValue(rememberedValue9);
            }
            KFunction kFunction4 = (KFunction) rememberedValue9;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-2061538483);
            boolean changedInstance9 = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue10 = startRestartGroup.rememberedValue();
            if (changedInstance9 || rememberedValue10 == companion.getEmpty()) {
                rememberedValue10 = new TicketDetailsScreenKt$TicketDetailsScreen$9$1(viewModel);
                startRestartGroup.updateRememberedValue(rememberedValue10);
            }
            KFunction kFunction5 = (KFunction) rememberedValue10;
            startRestartGroup.endReplaceGroup();
            Function0 function0 = (Function0) kFunction2;
            Function1 function1 = (Function1) kFunction3;
            startRestartGroup.startReplaceGroup(-2061556760);
            boolean changed = startRestartGroup.changed(z5) | startRestartGroup.changedInstance(viewModel) | (i9 == 32) | startRestartGroup.changedInstance(context);
            Object rememberedValue11 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue11 == companion.getEmpty()) {
                viewState = viewState2;
                composer2 = startRestartGroup;
                i7 = 32;
                rememberedValue11 = new Function0() { // from class: p4.P
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit TicketDetailsScreen$lambda$17$lambda$16;
                        TicketDetailsScreen$lambda$17$lambda$16 = TicketDetailsScreenKt.TicketDetailsScreen$lambda$17$lambda$16(z5, mutableState, viewModel, context, navigator);
                        return TicketDetailsScreen$lambda$17$lambda$16;
                    }
                };
                composer2.updateRememberedValue(rememberedValue11);
            } else {
                viewState = viewState2;
                composer2 = startRestartGroup;
                i7 = 32;
            }
            Function0 function02 = (Function0) rememberedValue11;
            composer2.endReplaceGroup();
            Function0 function03 = (Function0) kFunction4;
            Function0 function04 = (Function0) kFunction5;
            composer2.startReplaceGroup(-2061546909);
            boolean z6 = i9 == i7;
            Object rememberedValue12 = composer2.rememberedValue();
            if (z6 || rememberedValue12 == companion.getEmpty()) {
                rememberedValue12 = new Function4() { // from class: p4.Q
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        Unit TicketDetailsScreen$lambda$19$lambda$18;
                        TicketDetailsScreen$lambda$19$lambda$18 = TicketDetailsScreenKt.TicketDetailsScreen$lambda$19$lambda$18(DestinationsNavigator.this, (String) obj, (String) obj2, (BarcodeViewType) obj3, (BarcodeValidity) obj4);
                        return TicketDetailsScreen$lambda$19$lambda$18;
                    }
                };
                composer2.updateRememberedValue(rememberedValue12);
            }
            Function4 function4 = (Function4) rememberedValue12;
            composer2.endReplaceGroup();
            composer2.startReplaceGroup(-2061535999);
            boolean changedInstance10 = composer2.changedInstance(viewState) | (i9 == i7);
            Object rememberedValue13 = composer2.rememberedValue();
            if (changedInstance10 || rememberedValue13 == companion.getEmpty()) {
                rememberedValue13 = new Function2() { // from class: p4.S
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit TicketDetailsScreen$lambda$21$lambda$20;
                        TicketDetailsScreen$lambda$21$lambda$20 = TicketDetailsScreenKt.TicketDetailsScreen$lambda$21$lambda$20(TicketDetailsViewModel.ViewState.this, navigator, (LineItem) obj, (String) obj2);
                        return TicketDetailsScreen$lambda$21$lambda$20;
                    }
                };
                composer2.updateRememberedValue(rememberedValue13);
            }
            Function2 function2 = (Function2) rememberedValue13;
            composer2.endReplaceGroup();
            composer2.startReplaceGroup(-2061527344);
            boolean z7 = i9 == i7;
            Object rememberedValue14 = composer2.rememberedValue();
            if (z7 || rememberedValue14 == companion.getEmpty()) {
                rememberedValue14 = new Function2() { // from class: p4.m
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit TicketDetailsScreen$lambda$23$lambda$22;
                        TicketDetailsScreen$lambda$23$lambda$22 = TicketDetailsScreenKt.TicketDetailsScreen$lambda$23$lambda$22(DestinationsNavigator.this, (List) obj, (String) obj2);
                        return TicketDetailsScreen$lambda$23$lambda$22;
                    }
                };
                composer2.updateRememberedValue(rememberedValue14);
            }
            Function2 function22 = (Function2) rememberedValue14;
            composer2.endReplaceGroup();
            composer2.startReplaceGroup(-2061498754);
            boolean z8 = i9 == i7;
            Object rememberedValue15 = composer2.rememberedValue();
            if (z8 || rememberedValue15 == companion.getEmpty()) {
                rememberedValue15 = new Function1() { // from class: p4.n
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit TicketDetailsScreen$lambda$25$lambda$24;
                        TicketDetailsScreen$lambda$25$lambda$24 = TicketDetailsScreenKt.TicketDetailsScreen$lambda$25$lambda$24(DestinationsNavigator.this, (SaleOnBoardOrder) obj);
                        return TicketDetailsScreen$lambda$25$lambda$24;
                    }
                };
                composer2.updateRememberedValue(rememberedValue15);
            }
            Function1 function12 = (Function1) rememberedValue15;
            composer2.endReplaceGroup();
            composer2.startReplaceGroup(-2061523386);
            composer3 = composer2;
            boolean changedInstance11 = composer3.changedInstance(viewModel) | composer3.changedInstance(context);
            Object rememberedValue16 = composer3.rememberedValue();
            if (changedInstance11 || rememberedValue16 == companion.getEmpty()) {
                rememberedValue16 = new Function1() { // from class: p4.o
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit TicketDetailsScreen$lambda$27$lambda$26;
                        TicketDetailsScreen$lambda$27$lambda$26 = TicketDetailsScreenKt.TicketDetailsScreen$lambda$27$lambda$26(TicketDetailsViewModel.this, context, (String) obj);
                        return TicketDetailsScreen$lambda$27$lambda$26;
                    }
                };
                composer3.updateRememberedValue(rememberedValue16);
            }
            Function1 function13 = (Function1) rememberedValue16;
            composer3.endReplaceGroup();
            composer3.startReplaceGroup(-2061519622);
            boolean changedInstance12 = composer3.changedInstance(viewModel) | (i9 == i7);
            Object rememberedValue17 = composer3.rememberedValue();
            if (changedInstance12 || rememberedValue17 == companion.getEmpty()) {
                rememberedValue17 = new Function0() { // from class: p4.p
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit TicketDetailsScreen$lambda$30$lambda$29;
                        TicketDetailsScreen$lambda$30$lambda$29 = TicketDetailsScreenKt.TicketDetailsScreen$lambda$30$lambda$29(TicketDetailsViewModel.this, navigator);
                        return TicketDetailsScreen$lambda$30$lambda$29;
                    }
                };
                composer3.updateRememberedValue(rememberedValue17);
            }
            Function0 function05 = (Function0) rememberedValue17;
            composer3.endReplaceGroup();
            composer3.startReplaceGroup(-2061514376);
            boolean changedInstance13 = composer3.changedInstance(viewModel) | (i9 == i7);
            Object rememberedValue18 = composer3.rememberedValue();
            if (changedInstance13 || rememberedValue18 == companion.getEmpty()) {
                rememberedValue18 = new Function0() { // from class: p4.w
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit TicketDetailsScreen$lambda$33$lambda$32;
                        TicketDetailsScreen$lambda$33$lambda$32 = TicketDetailsScreenKt.TicketDetailsScreen$lambda$33$lambda$32(TicketDetailsViewModel.this, navigator);
                        return TicketDetailsScreen$lambda$33$lambda$32;
                    }
                };
                composer3.updateRememberedValue(rememberedValue18);
            }
            Function0 function06 = (Function0) rememberedValue18;
            composer3.endReplaceGroup();
            composer3.startReplaceGroup(-2061508732);
            boolean z9 = i9 == i7;
            Object rememberedValue19 = composer3.rememberedValue();
            if (z9 || rememberedValue19 == companion.getEmpty()) {
                rememberedValue19 = new Function3() { // from class: p4.H
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit TicketDetailsScreen$lambda$35$lambda$34;
                        TicketDetailsScreen$lambda$35$lambda$34 = TicketDetailsScreenKt.TicketDetailsScreen$lambda$35$lambda$34(DestinationsNavigator.this, (String) obj, (String) obj2, (Site) obj3);
                        return TicketDetailsScreen$lambda$35$lambda$34;
                    }
                };
                composer3.updateRememberedValue(rememberedValue19);
            }
            Function3 function3 = (Function3) rememberedValue19;
            composer3.endReplaceGroup();
            composer3.startReplaceGroup(-2061494270);
            boolean changedInstance14 = composer3.changedInstance(viewModel) | composer3.changedInstance(context);
            Object rememberedValue20 = composer3.rememberedValue();
            if (changedInstance14 || rememberedValue20 == companion.getEmpty()) {
                rememberedValue20 = new Function1() { // from class: p4.L
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit TicketDetailsScreen$lambda$37$lambda$36;
                        TicketDetailsScreen$lambda$37$lambda$36 = TicketDetailsScreenKt.TicketDetailsScreen$lambda$37$lambda$36(TicketDetailsViewModel.this, context, (IDepartureInfo) obj);
                        return TicketDetailsScreen$lambda$37$lambda$36;
                    }
                };
                composer3.updateRememberedValue(rememberedValue20);
            }
            composer3.endReplaceGroup();
            TicketDetailsContent(viewState, travelDetailsState, function0, function1, function02, function03, function04, function4, function2, function22, function12, function13, function05, function06, function3, (Function1) rememberedValue20, composer3, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer3.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: p4.M
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit TicketDetailsScreen$lambda$38;
                    TicketDetailsScreen$lambda$38 = TicketDetailsScreenKt.TicketDetailsScreen$lambda$38(TicketDetailsViewModel.this, navigator, earlyCheckInResultRecipient, simpleChangeReceiptResultRecipient, receiptResultRecipient, refundReceiptResultRecipient, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return TicketDetailsScreen$lambda$38;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TicketDetailsScreen$lambda$10$lambda$9(TicketDetailsViewModel ticketDetailsViewModel, Context context, final DestinationsNavigator destinationsNavigator) {
        ticketDetailsViewModel.editTicket(new Function0() { // from class: p4.B
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit TicketDetailsScreen$lambda$10$lambda$9$lambda$8;
                TicketDetailsScreen$lambda$10$lambda$9$lambda$8 = TicketDetailsScreenKt.TicketDetailsScreen$lambda$10$lambda$9$lambda$8(DestinationsNavigator.this);
                return TicketDetailsScreen$lambda$10$lambda$9$lambda$8;
            }
        }, context);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TicketDetailsScreen$lambda$10$lambda$9$lambda$8(DestinationsNavigator destinationsNavigator) {
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, DeparturesEditScreenDestination.invoke$default(DeparturesEditScreenDestination.INSTANCE, false, 1, null), null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TicketDetailsScreen$lambda$17$lambda$16(boolean z5, MutableState mutableState, TicketDetailsViewModel ticketDetailsViewModel, Context context, final DestinationsNavigator destinationsNavigator) {
        if (z5) {
            mutableState.setValue(Boolean.TRUE);
            return Unit.INSTANCE;
        }
        ticketDetailsViewModel.editTicket(new Function0() { // from class: p4.G
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit TicketDetailsScreen$lambda$17$lambda$16$lambda$15;
                TicketDetailsScreen$lambda$17$lambda$16$lambda$15 = TicketDetailsScreenKt.TicketDetailsScreen$lambda$17$lambda$16$lambda$15(DestinationsNavigator.this);
                return TicketDetailsScreen$lambda$17$lambda$16$lambda$15;
            }
        }, context);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TicketDetailsScreen$lambda$17$lambda$16$lambda$15(DestinationsNavigator destinationsNavigator) {
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, DeparturesEditScreenDestination.invoke$default(DeparturesEditScreenDestination.INSTANCE, false, 1, null), null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TicketDetailsScreen$lambda$19$lambda$18(DestinationsNavigator destinationsNavigator, String barcode, String str, BarcodeViewType barcodeType, BarcodeValidity validity) {
        Intrinsics.checkNotNullParameter(barcode, "barcode");
        Intrinsics.checkNotNullParameter(barcodeType, "barcodeType");
        Intrinsics.checkNotNullParameter(validity, "validity");
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, BarcodeDetailsScreenDestination.INSTANCE.invoke(barcode, str, barcodeType, validity), null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TicketDetailsScreen$lambda$2$lambda$1(TicketDetailsViewModel ticketDetailsViewModel, Context context) {
        ticketDetailsViewModel.reloadTicket(context);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TicketDetailsScreen$lambda$21$lambda$20(TicketDetailsViewModel.ViewState viewState, DestinationsNavigator destinationsNavigator, LineItem lineItem, String barcode) {
        Intrinsics.checkNotNullParameter(lineItem, "lineItem");
        Intrinsics.checkNotNullParameter(barcode, "barcode");
        Booking booking = viewState.getBooking();
        if (booking == null) {
            return Unit.INSTANCE;
        }
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, LoungeBarcodeDetailsScreenDestination.INSTANCE.invoke(barcode, lineItem.getQuantity(), booking.getTicket().getDeparture().departureDateTime()), null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TicketDetailsScreen$lambda$23$lambda$22(DestinationsNavigator destinationsNavigator, List list, String barcode) {
        Intrinsics.checkNotNullParameter(list, "<unused var>");
        Intrinsics.checkNotNullParameter(barcode, "barcode");
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, FoodBarcodeDetailsScreenDestination.INSTANCE.invoke(barcode), null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TicketDetailsScreen$lambda$25$lambda$24(DestinationsNavigator destinationsNavigator, SaleOnBoardOrder it) {
        Intrinsics.checkNotNullParameter(it, "it");
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, SaleOnBoardBarcodeDetailsScreenDestination.INSTANCE.invoke(it.getOrderNumber()), null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TicketDetailsScreen$lambda$27$lambda$26(TicketDetailsViewModel ticketDetailsViewModel, Context context, String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        ticketDetailsViewModel.showOnMap(address, context);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TicketDetailsScreen$lambda$30$lambda$29(TicketDetailsViewModel ticketDetailsViewModel, final DestinationsNavigator destinationsNavigator) {
        ticketDetailsViewModel.startSimpleChangeFlow(new Function0() { // from class: p4.C
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit TicketDetailsScreen$lambda$30$lambda$29$lambda$28;
                TicketDetailsScreen$lambda$30$lambda$29$lambda$28 = TicketDetailsScreenKt.TicketDetailsScreen$lambda$30$lambda$29$lambda$28(DestinationsNavigator.this);
                return TicketDetailsScreen$lambda$30$lambda$29$lambda$28;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TicketDetailsScreen$lambda$30$lambda$29$lambda$28(DestinationsNavigator destinationsNavigator) {
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, SimpleChangeAddonsScreenDestination.INSTANCE, null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TicketDetailsScreen$lambda$33$lambda$32(TicketDetailsViewModel ticketDetailsViewModel, final DestinationsNavigator destinationsNavigator) {
        ticketDetailsViewModel.startSimpleChangeFlow(new Function0() { // from class: p4.D
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit TicketDetailsScreen$lambda$33$lambda$32$lambda$31;
                TicketDetailsScreen$lambda$33$lambda$32$lambda$31 = TicketDetailsScreenKt.TicketDetailsScreen$lambda$33$lambda$32$lambda$31(DestinationsNavigator.this);
                return TicketDetailsScreen$lambda$33$lambda$32$lambda$31;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TicketDetailsScreen$lambda$33$lambda$32$lambda$31(DestinationsNavigator destinationsNavigator) {
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, SimpleChangeFoodScreenDestination.INSTANCE, null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TicketDetailsScreen$lambda$35$lambda$34(DestinationsNavigator destinationsNavigator, String reservationNumber, String phone, Site site) {
        Intrinsics.checkNotNullParameter(reservationNumber, "reservationNumber");
        Intrinsics.checkNotNullParameter(phone, "phone");
        Intrinsics.checkNotNullParameter(site, "site");
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, EarlyCheckInScreenDestination.INSTANCE.invoke(reservationNumber, phone, site), null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TicketDetailsScreen$lambda$37$lambda$36(TicketDetailsViewModel ticketDetailsViewModel, Context context, IDepartureInfo it) {
        Intrinsics.checkNotNullParameter(it, "it");
        ticketDetailsViewModel.addToCalendar(context);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TicketDetailsScreen$lambda$38(TicketDetailsViewModel ticketDetailsViewModel, DestinationsNavigator destinationsNavigator, ResultRecipient resultRecipient, ResultRecipient resultRecipient2, ResultRecipient resultRecipient3, ResultRecipient resultRecipient4, int i5, Composer composer, int i6) {
        TicketDetailsScreen(ticketDetailsViewModel, destinationsNavigator, resultRecipient, resultRecipient2, resultRecipient3, resultRecipient4, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TicketDetailsScreen$lambda$6$lambda$5(TicketDetailsViewModel ticketDetailsViewModel, Context context, final DestinationsNavigator destinationsNavigator) {
        ticketDetailsViewModel.refund(new Function0() { // from class: p4.u
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit TicketDetailsScreen$lambda$6$lambda$5$lambda$4;
                TicketDetailsScreen$lambda$6$lambda$5$lambda$4 = TicketDetailsScreenKt.TicketDetailsScreen$lambda$6$lambda$5$lambda$4(DestinationsNavigator.this);
                return TicketDetailsScreen$lambda$6$lambda$5$lambda$4;
            }
        }, context);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TicketDetailsScreen$lambda$6$lambda$5$lambda$4(DestinationsNavigator destinationsNavigator) {
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, RefundReceiptScreenDestination.INSTANCE, null, null, 6, null);
        return Unit.INSTANCE;
    }

    private static final void topSection(LazyListScope lazyListScope, boolean z5, final TicketDetailsViewModel.ViewState viewState, Function0<Unit> function0, Function1<? super Context, Unit> function1, Function0<Unit> function02, Function0<Unit> function03, Function0<Unit> function04, Function4<? super String, ? super String, ? super BarcodeViewType, ? super BarcodeValidity, Unit> function4, TravelDetailsState travelDetailsState, Function1<? super String, Unit> function12, Function3<? super String, ? super String, ? super Site, Unit> function3) {
        if (z5 && viewState.getBooking() != null) {
            LazyListScope.item$default(lazyListScope, null, null, ComposableLambdaKt.composableLambdaInstance(-1440670333, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.tickets.details.TicketDetailsScreenKt$topSection$1
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
                        ComposerKt.traceEventStart(-1440670333, i5, -1, "dk.molslinjen.ui.views.screens.tickets.details.topSection.<anonymous> (TicketDetailsScreen.kt:330)");
                    }
                    TicketDetailsScreenKt.RefundInfo(TicketDetailsViewModel.ViewState.this.getBooking(), TicketDetailsViewModel.ViewState.this.getReservationNumber(), composer, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), 3, null);
        } else if (viewState.getIsHistory()) {
            LazyListScope.item$default(lazyListScope, null, null, ComposableLambdaKt.composableLambdaInstance(1895603756, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.tickets.details.TicketDetailsScreenKt$topSection$2
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
                        ComposerKt.traceEventStart(1895603756, i5, -1, "dk.molslinjen.ui.views.screens.tickets.details.topSection.<anonymous> (TicketDetailsScreen.kt:339)");
                    }
                    TicketDetailsScreenKt.ExpiredTicketInfo(TicketDetailsViewModel.ViewState.this.getReservationNumber(), composer, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), 3, null);
        } else {
            LazyListScope.item$default(lazyListScope, null, null, ComposableLambdaKt.composableLambdaInstance(654952908, true, new TicketDetailsScreenKt$topSection$3(viewState, function0, function1, function02, function03, function04)), 3, null);
            LazyListScope.item$default(lazyListScope, null, null, ComposableLambdaKt.composableLambdaInstance(503894787, true, new TicketDetailsScreenKt$topSection$4(viewState, travelDetailsState, function4, function12, function3)), 3, null);
        }
    }
}
