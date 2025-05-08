package dk.molslinjen.ui.views.shared.ticket.ticketSummary;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import dk.molslinjen.domain.managers.checkout.PriceDetails;
import dk.molslinjen.domain.managers.checkout.PriceTotal;
import dk.molslinjen.domain.model.booking.BookingPassenger;
import dk.molslinjen.domain.model.booking.IDepartureInfo;
import dk.molslinjen.domain.model.booking.PassengerInfo;
import dk.molslinjen.domain.model.booking.ProductType;
import dk.molslinjen.domain.model.booking.TicketCategory;
import dk.molslinjen.domain.model.booking.TicketSection;
import dk.molslinjen.domain.model.booking.TicketSurcharge;
import dk.molslinjen.domain.model.booking.TransportationCargoInfo;
import dk.molslinjen.domain.model.booking.product.CheckoutSeatReservation;
import dk.molslinjen.domain.model.booking.product.ISummaryProduct;
import dk.molslinjen.domain.model.config.Subline;
import dk.molslinjen.domain.model.config.Transportation;
import dk.molslinjen.domain.model.shared.Price;
import dk.molslinjen.extensions.ColorExtensionsKt;
import dk.molslinjen.extensions.ModifierExtensionsKt;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.HorizontalDividerKt;
import dk.molslinjen.ui.views.reusable.buttons.ShowDetailsButtonKt;
import dk.molslinjen.ui.views.shared.ticket.ticketSummary.TicketSummaryViewKt;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u001aá\u0002\u00102\u001a\u00020 2\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\n2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u000f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000f0\n2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00002\b\b\u0002\u0010\u001e\u001a\u00020\u001d2\u0016\b\u0002\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020 \u0018\u00010\u001f2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"2\b\b\u0002\u0010$\u001a\u00020\u001d2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020%0\n2\u0006\u0010'\u001a\u00020\u001d2\b\b\u0002\u0010(\u001a\u00020\u001d2\u0010\b\u0002\u0010*\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010)2\u0010\b\u0002\u0010+\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010)2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00002\f\u0010.\u001a\b\u0012\u0004\u0012\u00020-0\n2\b\u00100\u001a\u0004\u0018\u00010/2\b\u00101\u001a\u0004\u0018\u00010\u0000H\u0007¢\u0006\u0004\b2\u00103\u001a÷\u0001\u00104\u001a\u00020 2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\n2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u000f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000f0\n2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020%0\n2\b\u0010#\u001a\u0004\u0018\u00010\"2\u0006\u0010$\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020\u001d2\u000e\u0010*\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010)2\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010)2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020-0\n2\b\u0010\t\u001a\u0004\u0018\u00010\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\u00100\u001a\u0004\u0018\u00010/2\b\u00101\u001a\u0004\u0018\u00010\u0000H\u0003¢\u0006\u0004\b4\u00105¨\u00067²\u0006\u000e\u00106\u001a\u00020\u001d8\n@\nX\u008a\u008e\u0002"}, d2 = {BuildConfig.FLAVOR, "headerTitle", "Ldk/molslinjen/domain/model/booking/IDepartureInfo;", "departure", "Ldk/molslinjen/domain/model/booking/TicketCategory;", "category", "Ldk/molslinjen/domain/model/config/Transportation;", "transportation", "Ldk/molslinjen/domain/model/booking/TransportationCargoInfo;", "cargoInfo", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/TicketSurcharge;", "surcharges", "Ldk/molslinjen/domain/model/booking/PassengerInfo;", "passengerInfo", "Ldk/molslinjen/domain/model/booking/product/ISummaryProduct;", "addons", "food", "Ldk/molslinjen/domain/model/booking/product/CheckoutSeatReservation;", "seatReservation", "trailer", "transportProducts", "Ldk/molslinjen/domain/managers/checkout/PriceDetails;", "priceDetails", "Ldk/molslinjen/domain/managers/checkout/PriceTotal;", "totalPrice", "Ldk/molslinjen/domain/model/shared/Price;", "ticketPrice", "reservationNumber", BuildConfig.FLAVOR, "showTicketBackground", "Lkotlin/Function1;", BuildConfig.FLAVOR, "addToCalendar", "Ldk/molslinjen/domain/model/booking/TicketSection;", "focusedSection", "expandableDetails", "Ldk/molslinjen/domain/model/booking/BookingPassenger;", "passengers", "askForPersonData", "showDimmedOverlay", "Lkotlin/Function0;", "addProducts", "addFood", "priceTotalText", "Ldk/molslinjen/domain/model/booking/ProductType;", "availableProductTypes", "Ldk/molslinjen/domain/model/config/Subline;", "subline", "lineLogoUrl", "TicketSummaryView", "(Ljava/lang/String;Ldk/molslinjen/domain/model/booking/IDepartureInfo;Ldk/molslinjen/domain/model/booking/TicketCategory;Ldk/molslinjen/domain/model/config/Transportation;Ldk/molslinjen/domain/model/booking/TransportationCargoInfo;Ljava/util/List;Ldk/molslinjen/domain/model/booking/PassengerInfo;Ljava/util/List;Ljava/util/List;Ldk/molslinjen/domain/model/booking/product/CheckoutSeatReservation;Ldk/molslinjen/domain/model/booking/product/ISummaryProduct;Ljava/util/List;Ldk/molslinjen/domain/managers/checkout/PriceDetails;Ldk/molslinjen/domain/managers/checkout/PriceTotal;Ldk/molslinjen/domain/model/shared/Price;Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Ldk/molslinjen/domain/model/booking/TicketSection;ZLjava/util/List;ZZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Ljava/lang/String;Ljava/util/List;Ldk/molslinjen/domain/model/config/Subline;Ljava/lang/String;Landroidx/compose/runtime/Composer;IIII)V", "MiddleSection", "(Ldk/molslinjen/domain/model/booking/IDepartureInfo;Ldk/molslinjen/domain/model/booking/TicketCategory;Ldk/molslinjen/domain/model/config/Transportation;Ldk/molslinjen/domain/model/booking/PassengerInfo;Ljava/util/List;Ljava/util/List;Ldk/molslinjen/domain/model/booking/product/CheckoutSeatReservation;Ldk/molslinjen/domain/model/booking/product/ISummaryProduct;Ljava/util/List;Ljava/util/List;Ldk/molslinjen/domain/model/booking/TicketSection;ZLdk/molslinjen/domain/model/shared/Price;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Ljava/util/List;Ldk/molslinjen/domain/model/booking/TransportationCargoInfo;Ljava/util/List;Ldk/molslinjen/domain/model/config/Subline;Ljava/lang/String;Landroidx/compose/runtime/Composer;III)V", "showDetails", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class TicketSummaryViewKt {
    /* JADX WARN: Removed duplicated region for block: B:195:0x03af  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0409  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x04b5  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x03ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void MiddleSection(final IDepartureInfo iDepartureInfo, final TicketCategory ticketCategory, final Transportation transportation, final PassengerInfo passengerInfo, final List<? extends ISummaryProduct> list, final List<? extends ISummaryProduct> list2, final CheckoutSeatReservation checkoutSeatReservation, final ISummaryProduct iSummaryProduct, final List<? extends ISummaryProduct> list3, final List<BookingPassenger> list4, final TicketSection ticketSection, final boolean z5, final Price price, final boolean z6, final Function0<Unit> function0, final Function0<Unit> function02, final List<? extends ProductType> list5, final TransportationCargoInfo transportationCargoInfo, final List<TicketSurcharge> list6, final Subline subline, final String str, Composer composer, final int i5, final int i6, final int i7) {
        boolean z7;
        Composer composer2;
        MutableState mutableState;
        int i8;
        int i9;
        boolean z8;
        boolean contains;
        Composer composer3;
        int i10;
        Composer startRestartGroup = composer.startRestartGroup(-259295627);
        int i11 = (i5 & 6) == 0 ? i5 | (startRestartGroup.changedInstance(iDepartureInfo) ? 4 : 2) : i5;
        if ((i5 & 48) == 0) {
            i11 |= startRestartGroup.changedInstance(ticketCategory) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i11 |= startRestartGroup.changedInstance(transportation) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i11 |= startRestartGroup.changedInstance(passengerInfo) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i11 |= startRestartGroup.changedInstance(list) ? 16384 : 8192;
        }
        if ((i5 & 196608) == 0) {
            i11 |= startRestartGroup.changedInstance(list2) ? 131072 : 65536;
        }
        if ((i5 & 1572864) == 0) {
            i11 |= startRestartGroup.changedInstance(checkoutSeatReservation) ? 1048576 : 524288;
        }
        if ((i5 & 12582912) == 0) {
            i11 |= startRestartGroup.changedInstance(iSummaryProduct) ? 8388608 : 4194304;
        }
        if ((i5 & 100663296) == 0) {
            i11 |= startRestartGroup.changedInstance(list3) ? 67108864 : 33554432;
        }
        if ((i5 & 805306368) == 0) {
            i11 |= startRestartGroup.changedInstance(list4) ? 536870912 : 268435456;
        }
        int i12 = i11;
        int i13 = (i6 & 6) == 0 ? i6 | (startRestartGroup.changed(ticketSection) ? 4 : 2) : i6;
        if ((i6 & 48) == 0) {
            i13 |= startRestartGroup.changed(z5) ? 32 : 16;
        }
        if ((i6 & 384) == 0) {
            i13 |= startRestartGroup.changedInstance(price) ? 256 : 128;
        }
        if ((i6 & 3072) == 0) {
            i13 |= startRestartGroup.changed(z6) ? 2048 : 1024;
        }
        if ((i6 & 24576) == 0) {
            i13 |= startRestartGroup.changedInstance(function0) ? 16384 : 8192;
        }
        if ((i6 & 196608) == 0) {
            i13 |= startRestartGroup.changedInstance(function02) ? 131072 : 65536;
        }
        if ((i6 & 1572864) == 0) {
            i13 |= startRestartGroup.changedInstance(list5) ? 1048576 : 524288;
        }
        if ((12582912 & i6) == 0) {
            i13 |= startRestartGroup.changedInstance(transportationCargoInfo) ? 8388608 : 4194304;
        }
        if ((i6 & 100663296) == 0) {
            i13 |= startRestartGroup.changedInstance(list6) ? 67108864 : 33554432;
        }
        if ((i6 & 805306368) == 0) {
            i13 |= startRestartGroup.changedInstance(subline) ? 536870912 : 268435456;
        }
        int i14 = i13;
        int i15 = (i7 & 6) == 0 ? i7 | (startRestartGroup.changed(str) ? 4 : 2) : i7;
        if ((i12 & 306783379) == 306783378 && (306783379 & i14) == 306783378 && (i15 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer3 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-259295627, i12, i14, "dk.molslinjen.ui.views.shared.ticket.ticketSummary.MiddleSection (TicketSummaryView.kt:184)");
            }
            Object[] objArr = new Object[0];
            startRestartGroup.startReplaceGroup(650391371);
            boolean z9 = (i14 & 112) == 32;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z9 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: C4.D
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        MutableState MiddleSection$lambda$13$lambda$12;
                        MiddleSection$lambda$13$lambda$12 = TicketSummaryViewKt.MiddleSection$lambda$13$lambda$12(z5);
                        return MiddleSection$lambda$13$lambda$12;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            MutableState mutableState2 = (MutableState) RememberSaveableKt.rememberSaveable(objArr, null, null, (Function0) rememberedValue, startRestartGroup, 0, 6);
            Modifier.Companion companion = Modifier.INSTANCE;
            float f5 = 8;
            Modifier m313paddingVpY3zN4$default = PaddingKt.m313paddingVpY3zN4$default(companion, Dp.m2599constructorimpl(f5), 0.0f, 2, null);
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m313paddingVpY3zN4$default);
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
            int i16 = i12 >> 9;
            int i17 = (i12 & 8190) | (57344 & i16) | (i16 & 458752) | ((i14 << 15) & 29360128);
            int i18 = i14 << 3;
            TicketSectionKt.TicketSection(iDepartureInfo, ticketCategory, transportation, passengerInfo, iSummaryProduct, list3, MiddleSection$lambda$14(mutableState2), price, transportationCargoInfo, list6, subline, str, startRestartGroup, i17 | (234881024 & i18) | (i18 & 1879048192), ((i14 >> 27) & 14) | ((i15 << 3) & 112));
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f5)), startRestartGroup, 6);
            boolean z10 = z6 && transportation.getMaxPassengers() > 0;
            boolean z11 = z10 || !transportation.isWalking();
            startRestartGroup.startReplaceGroup(1172209397);
            if (z11) {
                PassengerSectionKt.PassengerSection(list4, MiddleSection$lambda$14(mutableState2), ticketSection == TicketSection.Passenger, passengerInfo.getTotalPassengerCount(), z10, startRestartGroup, (i12 >> 27) & 14);
                SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f5)), startRestartGroup, 6);
            }
            startRestartGroup.endReplaceGroup();
            List<? extends ProductType> list7 = list5;
            if (!(list7 instanceof Collection) || !list7.isEmpty()) {
                for (ProductType productType : list7) {
                    if (productType == ProductType.Extra || productType == ProductType.Bunk) {
                        break;
                    }
                }
            }
            if (checkoutSeatReservation == null) {
                z7 = false;
                startRestartGroup.startReplaceGroup(1172228831);
                if (z7) {
                    composer2 = startRestartGroup;
                    mutableState = mutableState2;
                    i8 = i12;
                    i9 = i14;
                    z8 = false;
                } else {
                    z8 = false;
                    composer2 = startRestartGroup;
                    mutableState = mutableState2;
                    i8 = i12;
                    i9 = i14;
                    ProductSectionKt.ProductSection(list, checkoutSeatReservation, MiddleSection$lambda$14(mutableState2), function0, ticketSection == TicketSection.Addons, false, false, composer2, ((i12 >> 12) & 14) | ((i12 >> 15) & 112) | ((i14 >> 3) & 7168), 96);
                }
                composer2.endReplaceGroup();
                contains = list5.contains(ProductType.Catering);
                composer3 = composer2;
                composer3.startReplaceGroup(1172241789);
                if (contains) {
                    FoodSectionKt.FoodSection(list2, MiddleSection$lambda$14(mutableState), function02, ticketSection == TicketSection.Food ? true : z8, false, false, composer3, ((i8 >> 15) & 14) | ((i9 >> 9) & 896), 48);
                }
                composer3.endReplaceGroup();
                composer3.startReplaceGroup(1172250196);
                if (z5 || !((z11 && z10) || z7 || contains)) {
                    i10 = 16;
                } else {
                    i10 = 16;
                    Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(PaddingKt.m315paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m2599constructorimpl(16), 0.0f, 0.0f, 13, null), 0.0f, 1, null);
                    composer3.startReplaceGroup(1172259554);
                    final MutableState mutableState3 = mutableState;
                    boolean changed = composer3.changed(mutableState3);
                    Object rememberedValue2 = composer3.rememberedValue();
                    if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue2 = new Function0() { // from class: C4.E
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit MiddleSection$lambda$19$lambda$18$lambda$17;
                                MiddleSection$lambda$19$lambda$18$lambda$17 = TicketSummaryViewKt.MiddleSection$lambda$19$lambda$18$lambda$17(MutableState.this);
                                return MiddleSection$lambda$19$lambda$18$lambda$17;
                            }
                        };
                        composer3.updateRememberedValue(rememberedValue2);
                    }
                    composer3.endReplaceGroup();
                    ShowDetailsButtonKt.ShowDetailsButton(fillMaxWidth$default, null, null, (Function0) rememberedValue2, MiddleSection$lambda$14(mutableState3), composer3, 6, 6);
                }
                composer3.endReplaceGroup();
                SpacerKt.Spacer(SizeKt.m325height3ABfNKs(Modifier.INSTANCE, Dp.m2599constructorimpl(i10)), composer3, 6);
                composer3.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            z7 = true;
            startRestartGroup.startReplaceGroup(1172228831);
            if (z7) {
            }
            composer2.endReplaceGroup();
            contains = list5.contains(ProductType.Catering);
            composer3 = composer2;
            composer3.startReplaceGroup(1172241789);
            if (contains) {
            }
            composer3.endReplaceGroup();
            composer3.startReplaceGroup(1172250196);
            if (z5) {
            }
            i10 = 16;
            composer3.endReplaceGroup();
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(Modifier.INSTANCE, Dp.m2599constructorimpl(i10)), composer3, 6);
            composer3.endNode();
            if (ComposerKt.isTraceInProgress()) {
            }
        }
        ScopeUpdateScope endRestartGroup = composer3.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: C4.F
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit MiddleSection$lambda$20;
                    MiddleSection$lambda$20 = TicketSummaryViewKt.MiddleSection$lambda$20(IDepartureInfo.this, ticketCategory, transportation, passengerInfo, list, list2, checkoutSeatReservation, iSummaryProduct, list3, list4, ticketSection, z5, price, z6, function0, function02, list5, transportationCargoInfo, list6, subline, str, i5, i6, i7, (Composer) obj, ((Integer) obj2).intValue());
                    return MiddleSection$lambda$20;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState MiddleSection$lambda$13$lambda$12(boolean z5) {
        MutableState mutableStateOf$default;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(!z5), null, 2, null);
        return mutableStateOf$default;
    }

    private static final boolean MiddleSection$lambda$14(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void MiddleSection$lambda$15(MutableState<Boolean> mutableState, boolean z5) {
        mutableState.setValue(Boolean.valueOf(z5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MiddleSection$lambda$19$lambda$18$lambda$17(MutableState mutableState) {
        MiddleSection$lambda$15(mutableState, !MiddleSection$lambda$14(mutableState));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MiddleSection$lambda$20(IDepartureInfo iDepartureInfo, TicketCategory ticketCategory, Transportation transportation, PassengerInfo passengerInfo, List list, List list2, CheckoutSeatReservation checkoutSeatReservation, ISummaryProduct iSummaryProduct, List list3, List list4, TicketSection ticketSection, boolean z5, Price price, boolean z6, Function0 function0, Function0 function02, List list5, TransportationCargoInfo transportationCargoInfo, List list6, Subline subline, String str, int i5, int i6, int i7, Composer composer, int i8) {
        MiddleSection(iDepartureInfo, ticketCategory, transportation, passengerInfo, list, list2, checkoutSeatReservation, iSummaryProduct, list3, list4, ticketSection, z5, price, z6, function0, function02, list5, transportationCargoInfo, list6, subline, str, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), RecomposeScopeImplKt.updateChangedFlags(i6), RecomposeScopeImplKt.updateChangedFlags(i7));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x07c5  */
    /* JADX WARN: Removed duplicated region for block: B:110:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x03db  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x03e2  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x03e9  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x03f0  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x03f7  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x03fe  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0406  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x040d  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0414  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x041b  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0426  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x045a  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0466  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0489  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x04c3  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x04f8  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0522  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0586  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0592  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x05b5  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x05e2  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x06f6  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x071f  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0738  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0770  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x07a8  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x073e  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x05ef  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0596  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x054d  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x046a  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x041e  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0417  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0410  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0409  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0401  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x03fa  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x03f3  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x03ec  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x03e5  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x03de  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x038c  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x0373  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0358  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x0326  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x030b  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x02f2  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:298:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:319:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:326:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:334:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:341:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:348:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:355:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:362:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x02ed  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0306  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0321  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x033a  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0353  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x036e  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0387  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x03a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TicketSummaryView(final String str, final IDepartureInfo departure, final TicketCategory category, final Transportation transportation, final TransportationCargoInfo transportationCargoInfo, final List<TicketSurcharge> surcharges, final PassengerInfo passengerInfo, final List<? extends ISummaryProduct> addons, final List<? extends ISummaryProduct> food, final CheckoutSeatReservation checkoutSeatReservation, final ISummaryProduct iSummaryProduct, final List<? extends ISummaryProduct> transportProducts, PriceDetails priceDetails, final PriceTotal totalPrice, final Price ticketPrice, String str2, boolean z5, Function1<? super IDepartureInfo, Unit> function1, TicketSection ticketSection, boolean z6, final List<BookingPassenger> passengers, final boolean z7, boolean z8, Function0<Unit> function0, Function0<Unit> function02, String str3, final List<? extends ProductType> availableProductTypes, final Subline subline, final String str4, Composer composer, final int i5, final int i6, final int i7, final int i8) {
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        boolean z9;
        boolean z10;
        int currentCompositeKeyHash;
        Composer m1226constructorimpl;
        Object rememberedValue;
        Composer.Companion companion;
        Object rememberedValue2;
        int currentCompositeKeyHash2;
        Composer m1226constructorimpl2;
        int i23;
        boolean z11;
        int i24;
        Composer composer2;
        int i25;
        MutableState mutableState;
        int i26;
        Composer composer3;
        final MutableState mutableState2;
        boolean changed;
        Object rememberedValue3;
        Composer composer4;
        final PriceDetails priceDetails2;
        final boolean z12;
        final Function1<? super IDepartureInfo, Unit> function12;
        final TicketSection ticketSection2;
        final boolean z13;
        final String str5;
        final boolean z14;
        final Function0<Unit> function03;
        final Function0<Unit> function04;
        final String str6;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(departure, "departure");
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(transportation, "transportation");
        Intrinsics.checkNotNullParameter(surcharges, "surcharges");
        Intrinsics.checkNotNullParameter(passengerInfo, "passengerInfo");
        Intrinsics.checkNotNullParameter(addons, "addons");
        Intrinsics.checkNotNullParameter(food, "food");
        Intrinsics.checkNotNullParameter(transportProducts, "transportProducts");
        Intrinsics.checkNotNullParameter(totalPrice, "totalPrice");
        Intrinsics.checkNotNullParameter(ticketPrice, "ticketPrice");
        Intrinsics.checkNotNullParameter(passengers, "passengers");
        Intrinsics.checkNotNullParameter(availableProductTypes, "availableProductTypes");
        Composer startRestartGroup = composer.startRestartGroup(1437900324);
        if ((i8 & 1) != 0) {
            i9 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i9 = (startRestartGroup.changed(str) ? 4 : 2) | i5;
        } else {
            i9 = i5;
        }
        if ((i8 & 2) != 0) {
            i9 |= 48;
        } else if ((i5 & 48) == 0) {
            i9 |= startRestartGroup.changedInstance(departure) ? 32 : 16;
        }
        if ((i8 & 4) != 0) {
            i9 |= 384;
        } else if ((i5 & 384) == 0) {
            i9 |= startRestartGroup.changedInstance(category) ? 256 : 128;
        }
        if ((i8 & 8) != 0) {
            i9 |= 3072;
        } else if ((i5 & 3072) == 0) {
            i9 |= startRestartGroup.changedInstance(transportation) ? 2048 : 1024;
        }
        if ((i8 & 16) != 0) {
            i9 |= 24576;
        } else if ((i5 & 24576) == 0) {
            i9 |= startRestartGroup.changedInstance(transportationCargoInfo) ? 16384 : 8192;
            if ((i8 & 32) == 0) {
                i9 |= 196608;
            } else if ((i5 & 196608) == 0) {
                i9 |= startRestartGroup.changedInstance(surcharges) ? 131072 : 65536;
            }
            if ((i8 & 64) == 0) {
                i9 |= 1572864;
            } else if ((i5 & 1572864) == 0) {
                i9 |= startRestartGroup.changedInstance(passengerInfo) ? 1048576 : 524288;
            }
            if ((i8 & 128) == 0) {
                i9 |= 12582912;
            } else if ((i5 & 12582912) == 0) {
                i9 |= startRestartGroup.changedInstance(addons) ? 8388608 : 4194304;
            }
            if ((i8 & 256) == 0) {
                i9 |= 100663296;
            } else if ((i5 & 100663296) == 0) {
                i9 |= startRestartGroup.changedInstance(food) ? 67108864 : 33554432;
            }
            if ((i8 & 512) == 0) {
                i9 |= 805306368;
            } else if ((i5 & 805306368) == 0) {
                i9 |= startRestartGroup.changedInstance(checkoutSeatReservation) ? 536870912 : 268435456;
                if ((i8 & 1024) != 0) {
                    i10 = i6;
                    i11 = i10 | 6;
                } else {
                    i10 = i6;
                    if ((i10 & 6) == 0) {
                        i11 = i10 | (startRestartGroup.changedInstance(iSummaryProduct) ? 4 : 2);
                    } else {
                        i11 = i10;
                    }
                }
                if ((i8 & 2048) != 0) {
                    i11 |= 48;
                } else if ((i10 & 48) == 0) {
                    i11 |= startRestartGroup.changedInstance(transportProducts) ? 32 : 16;
                }
                int i27 = i11;
                i12 = i8 & 4096;
                if (i12 != 0) {
                    i27 |= 384;
                } else if ((i10 & 384) == 0) {
                    i27 |= startRestartGroup.changedInstance(priceDetails) ? 256 : 128;
                    if ((i8 & 8192) == 0) {
                        i27 |= 3072;
                    } else if ((i10 & 3072) == 0) {
                        i27 |= startRestartGroup.changedInstance(totalPrice) ? 2048 : 1024;
                    }
                    if ((i8 & 16384) == 0) {
                        i27 |= 24576;
                    } else if ((i10 & 24576) == 0) {
                        i27 |= startRestartGroup.changedInstance(ticketPrice) ? 16384 : 8192;
                    }
                    i13 = 32768 & i8;
                    if (i13 == 0) {
                        i27 |= 196608;
                    } else if ((i10 & 196608) == 0) {
                        i27 |= startRestartGroup.changed(str2) ? 131072 : 65536;
                    }
                    i14 = i8 & 65536;
                    if (i14 == 0) {
                        i27 |= 1572864;
                    } else if ((i10 & 1572864) == 0) {
                        i27 |= startRestartGroup.changed(z5) ? 1048576 : 524288;
                    }
                    i15 = i8 & 131072;
                    if (i15 == 0) {
                        i27 |= 12582912;
                    } else if ((i10 & 12582912) == 0) {
                        i27 |= startRestartGroup.changedInstance(function1) ? 8388608 : 4194304;
                    }
                    i16 = i8 & 262144;
                    if (i16 == 0) {
                        i27 |= 100663296;
                    } else if ((i10 & 100663296) == 0) {
                        i27 |= startRestartGroup.changed(ticketSection) ? 67108864 : 33554432;
                    }
                    i17 = i8 & 524288;
                    if (i17 == 0) {
                        i27 |= 805306368;
                    } else if ((i10 & 805306368) == 0) {
                        i27 |= startRestartGroup.changed(z6) ? 536870912 : 268435456;
                    }
                    if ((i8 & 1048576) == 0) {
                        i18 = i7 | 6;
                    } else if ((i7 & 6) == 0) {
                        i18 = i7 | (startRestartGroup.changedInstance(passengers) ? 4 : 2);
                    } else {
                        i18 = i7;
                    }
                    if ((i8 & 2097152) == 0) {
                        i18 |= 48;
                    } else if ((i7 & 48) == 0) {
                        i18 |= startRestartGroup.changed(z7) ? 32 : 16;
                    }
                    int i28 = i18;
                    i19 = i8 & 4194304;
                    if (i19 == 0) {
                        i28 |= 384;
                    } else if ((i7 & 384) == 0) {
                        i28 |= startRestartGroup.changed(z8) ? 256 : 128;
                        i20 = i8 & 8388608;
                        if (i20 != 0) {
                            i28 |= 3072;
                        } else if ((i7 & 3072) == 0) {
                            i28 |= startRestartGroup.changedInstance(function0) ? 2048 : 1024;
                            i21 = i8 & 16777216;
                            if (i21 == 0) {
                                i28 |= 24576;
                            } else if ((i7 & 24576) == 0) {
                                i28 |= startRestartGroup.changedInstance(function02) ? 16384 : 8192;
                                i22 = i8 & 33554432;
                                if (i22 != 0) {
                                    i28 |= 196608;
                                } else if ((i7 & 196608) == 0) {
                                    i28 |= startRestartGroup.changed(str3) ? 131072 : 65536;
                                }
                                if ((i8 & 67108864) != 0) {
                                    i28 |= 1572864;
                                } else if ((i7 & 1572864) == 0) {
                                    i28 |= startRestartGroup.changedInstance(availableProductTypes) ? 1048576 : 524288;
                                }
                                if ((i8 & 134217728) != 0) {
                                    i28 |= 12582912;
                                } else if ((i7 & 12582912) == 0) {
                                    i28 |= startRestartGroup.changedInstance(subline) ? 8388608 : 4194304;
                                }
                                if ((i8 & 268435456) != 0) {
                                    i28 |= 100663296;
                                } else if ((i7 & 100663296) == 0) {
                                    i28 |= startRestartGroup.changed(str4) ? 67108864 : 33554432;
                                }
                                if ((i9 & 306783379) != 306783378 && (306783379 & i27) == 306783378 && (38347923 & i28) == 38347922 && startRestartGroup.getSkipping()) {
                                    startRestartGroup.skipToGroupEnd();
                                    priceDetails2 = priceDetails;
                                    str5 = str2;
                                    z12 = z5;
                                    function12 = function1;
                                    ticketSection2 = ticketSection;
                                    z13 = z6;
                                    z14 = z8;
                                    function03 = function0;
                                    function04 = function02;
                                    str6 = str3;
                                    composer4 = startRestartGroup;
                                } else {
                                    PriceDetails priceDetails3 = i12 != 0 ? null : priceDetails;
                                    String str7 = i13 != 0 ? null : str2;
                                    z9 = i14 != 0 ? true : z5;
                                    Function1<? super IDepartureInfo, Unit> function13 = i15 != 0 ? null : function1;
                                    TicketSection ticketSection3 = i16 != 0 ? null : ticketSection;
                                    boolean z15 = i17 != 0 ? true : z6;
                                    z10 = i19 != 0 ? false : z8;
                                    Function0<Unit> function05 = i20 != 0 ? null : function0;
                                    Function0<Unit> function06 = i21 != 0 ? null : function02;
                                    String str8 = i22 != 0 ? null : str3;
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1437900324, i9, i27, "dk.molslinjen.ui.views.shared.ticket.ticketSummary.TicketSummaryView (TicketSummaryView.kt:83)");
                                    }
                                    Modifier.Companion companion2 = Modifier.INSTANCE;
                                    Modifier height = IntrinsicKt.height(companion2, IntrinsicSize.Max);
                                    Alignment.Companion companion3 = Alignment.INSTANCE;
                                    MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getCenter(), false);
                                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                                    CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, height);
                                    ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
                                    int i29 = i9;
                                    Function0<ComposeUiNode> constructor = companion4.getConstructor();
                                    if (startRestartGroup.getApplier() == null) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    startRestartGroup.startReusableNode();
                                    if (startRestartGroup.getInserting()) {
                                        startRestartGroup.createNode(constructor);
                                    } else {
                                        startRestartGroup.useNode();
                                    }
                                    m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
                                    Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion4.getSetMeasurePolicy());
                                    Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion4.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion4.getSetCompositeKeyHash();
                                    if (!m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                    }
                                    Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion4.getSetModifier());
                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                    Object[] objArr = new Object[0];
                                    startRestartGroup.startReplaceGroup(257034376);
                                    rememberedValue = startRestartGroup.rememberedValue();
                                    companion = Composer.INSTANCE;
                                    if (rememberedValue == companion.getEmpty()) {
                                        rememberedValue = new Function0() { // from class: C4.G
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Object invoke() {
                                                MutableState TicketSummaryView$lambda$10$lambda$1$lambda$0;
                                                TicketSummaryView$lambda$10$lambda$1$lambda$0 = TicketSummaryViewKt.TicketSummaryView$lambda$10$lambda$1$lambda$0();
                                                return TicketSummaryView$lambda$10$lambda$1$lambda$0;
                                            }
                                        };
                                        startRestartGroup.updateRememberedValue(rememberedValue);
                                    }
                                    startRestartGroup.endReplaceGroup();
                                    final MutableState mutableState3 = (MutableState) RememberSaveableKt.rememberSaveable(objArr, null, null, (Function0) rememberedValue, startRestartGroup, 3072, 6);
                                    Object[] objArr2 = new Object[0];
                                    startRestartGroup.startReplaceGroup(257036616);
                                    rememberedValue2 = startRestartGroup.rememberedValue();
                                    if (rememberedValue2 == companion.getEmpty()) {
                                        rememberedValue2 = new Function0() { // from class: C4.H
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Object invoke() {
                                                MutableState TicketSummaryView$lambda$10$lambda$3$lambda$2;
                                                TicketSummaryView$lambda$10$lambda$3$lambda$2 = TicketSummaryViewKt.TicketSummaryView$lambda$10$lambda$3$lambda$2();
                                                return TicketSummaryView$lambda$10$lambda$3$lambda$2;
                                            }
                                        };
                                        startRestartGroup.updateRememberedValue(rememberedValue2);
                                    }
                                    startRestartGroup.endReplaceGroup();
                                    MutableState mutableState4 = (MutableState) RememberSaveableKt.rememberSaveable(objArr2, null, null, (Function0) rememberedValue2, startRestartGroup, 3072, 6);
                                    startRestartGroup.startReplaceGroup(257037904);
                                    if (z9) {
                                        TicketSummaryBackgroundViewKt.m3563TicketSummaryBackgroundViewww6aTOc(ModifierExtensionsKt.defaultShadow$default(SizeKt.fillMaxHeight$default(companion2, 0.0f, 1, null), null, 1, null), ((Number) mutableState3.getValue()).intValue(), ((Number) mutableState4.getValue()).intValue(), 0L, startRestartGroup, 0, 8);
                                    }
                                    startRestartGroup.endReplaceGroup();
                                    Modifier m313paddingVpY3zN4$default = PaddingKt.m313paddingVpY3zN4$default(companion2, Dp.m2599constructorimpl(16), 0.0f, 2, null);
                                    MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), companion3.getStart(), startRestartGroup, 0);
                                    currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                                    CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                                    Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m313paddingVpY3zN4$default);
                                    Function0<ComposeUiNode> constructor2 = companion4.getConstructor();
                                    if (startRestartGroup.getApplier() == null) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    startRestartGroup.startReusableNode();
                                    if (startRestartGroup.getInserting()) {
                                        startRestartGroup.createNode(constructor2);
                                    } else {
                                        startRestartGroup.useNode();
                                    }
                                    m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
                                    Updater.m1227setimpl(m1226constructorimpl2, columnMeasurePolicy, companion4.getSetMeasurePolicy());
                                    Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion4.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion4.getSetCompositeKeyHash();
                                    if (!m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                        m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                        m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                    }
                                    Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion4.getSetModifier());
                                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                    startRestartGroup.startReplaceGroup(1401632598);
                                    if (str == null) {
                                        mutableState = mutableState4;
                                        composer2 = startRestartGroup;
                                        i25 = i27;
                                        i23 = i29;
                                        i26 = 2;
                                        z11 = false;
                                        i24 = 1;
                                    } else {
                                        startRestartGroup.startReplaceGroup(-1547113603);
                                        boolean changed2 = startRestartGroup.changed(mutableState3);
                                        Object rememberedValue4 = startRestartGroup.rememberedValue();
                                        if (changed2 || rememberedValue4 == companion.getEmpty()) {
                                            rememberedValue4 = new Function1() { // from class: C4.I
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Object invoke(Object obj) {
                                                    Unit TicketSummaryView$lambda$10$lambda$9$lambda$6$lambda$5$lambda$4;
                                                    TicketSummaryView$lambda$10$lambda$9$lambda$6$lambda$5$lambda$4 = TicketSummaryViewKt.TicketSummaryView$lambda$10$lambda$9$lambda$6$lambda$5$lambda$4(MutableState.this, (LayoutCoordinates) obj);
                                                    return TicketSummaryView$lambda$10$lambda$9$lambda$6$lambda$5$lambda$4;
                                                }
                                            };
                                            startRestartGroup.updateRememberedValue(rememberedValue4);
                                        }
                                        startRestartGroup.endReplaceGroup();
                                        i23 = i29;
                                        z11 = false;
                                        i24 = 1;
                                        composer2 = startRestartGroup;
                                        i25 = i27;
                                        mutableState = mutableState4;
                                        TicketSummaryHeaderRowKt.TicketSummaryHeaderRow(OnGloballyPositionedModifierKt.onGloballyPositioned(companion2, (Function1) rememberedValue4), str, str7, startRestartGroup, (i27 >> 9) & 896, 0);
                                        i26 = 2;
                                        HorizontalDividerKt.m3388HorizontalDividertZIQpXc(PaddingKt.m315paddingqDBjuR0$default(companion2, 0.0f, 0.0f, 0.0f, Dp.m2599constructorimpl(24), 7, null), 0L, 0.0f, Dp.m2597boximpl(Dp.m2599constructorimpl(2)), composer2, 3078, 6);
                                        Unit unit = Unit.INSTANCE;
                                    }
                                    composer2.endReplaceGroup();
                                    int i30 = i23 >> 9;
                                    int i31 = ((i23 >> 3) & 1022) | (i30 & 7168) | (57344 & i30) | (i30 & 458752) | (i30 & 3670016);
                                    int i32 = i25 << 21;
                                    int i33 = i31 | (29360128 & i32) | (i32 & 234881024) | ((i28 << 27) & 1879048192);
                                    int i34 = i25 >> 6;
                                    int i35 = i28 << 6;
                                    int i36 = i28 << 3;
                                    int i37 = ((i25 >> 24) & 126) | (i34 & 896) | (i35 & 7168) | (57344 & i36) | (i36 & 458752) | (i28 & 3670016);
                                    int i38 = i23 << 9;
                                    int i39 = i24;
                                    MiddleSection(departure, category, transportation, passengerInfo, addons, food, checkoutSeatReservation, iSummaryProduct, transportProducts, passengers, ticketSection3, z15, ticketPrice, z7, function05, function06, availableProductTypes, transportationCargoInfo, surcharges, subline, str4, composer2, i33, i37 | (29360128 & i38) | (i38 & 234881024) | (i35 & 1879048192), (i28 >> 24) & 14);
                                    composer3 = composer2;
                                    composer3.startReplaceGroup(1401675764);
                                    if (z9) {
                                        HorizontalDividerKt.m3388HorizontalDividertZIQpXc(null, 0L, 0.0f, Dp.m2597boximpl(Dp.m2599constructorimpl(i26)), composer3, 3072, 7);
                                    }
                                    composer3.endReplaceGroup();
                                    composer3.startReplaceGroup(1401681853);
                                    mutableState2 = mutableState;
                                    changed = composer3.changed(mutableState2);
                                    rememberedValue3 = composer3.rememberedValue();
                                    if (!changed || rememberedValue3 == companion.getEmpty()) {
                                        rememberedValue3 = new Function1() { // from class: C4.J
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Object invoke(Object obj) {
                                                Unit TicketSummaryView$lambda$10$lambda$9$lambda$8$lambda$7;
                                                TicketSummaryView$lambda$10$lambda$9$lambda$8$lambda$7 = TicketSummaryViewKt.TicketSummaryView$lambda$10$lambda$9$lambda$8$lambda$7(MutableState.this, (LayoutCoordinates) obj);
                                                return TicketSummaryView$lambda$10$lambda$9$lambda$8$lambda$7;
                                            }
                                        };
                                        composer3.updateRememberedValue(rememberedValue3);
                                    }
                                    composer3.endReplaceGroup();
                                    int i40 = (i34 & 458752) | (i25 & 896) | (i34 & 112) | ((i23 << 6) & 7168) | (i36 & 3670016);
                                    composer4 = composer3;
                                    TicketSummaryFooterRowKt.TicketSummaryFooterRow(OnGloballyPositionedModifierKt.onGloballyPositioned(companion2, (Function1) rememberedValue3), totalPrice, priceDetails3, departure, z15 ? TypographyKt.getSub() : TypographyKt.getParagraphSmall(), function13, str8, composer3, i40, 0);
                                    composer4.endNode();
                                    composer4.startReplaceGroup(257112747);
                                    if (z10) {
                                        TicketSummaryBackgroundViewKt.m3563TicketSummaryBackgroundViewww6aTOc(SizeKt.fillMaxHeight$default(companion2, 0.0f, i39, null), ((Number) mutableState3.getValue()).intValue(), ((Number) mutableState2.getValue()).intValue(), ColorExtensionsKt.m3249withAlphaDxMtmZc(AppColor.INSTANCE.m3268getGrey50d7_KjU(), 0.5f), composer4, 6, 0);
                                    }
                                    composer4.endReplaceGroup();
                                    composer4.endNode();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    priceDetails2 = priceDetails3;
                                    z12 = z9;
                                    function12 = function13;
                                    ticketSection2 = ticketSection3;
                                    z13 = z15;
                                    str5 = str7;
                                    z14 = z10;
                                    function03 = function05;
                                    function04 = function06;
                                    str6 = str8;
                                }
                                endRestartGroup = composer4.endRestartGroup();
                                if (endRestartGroup != null) {
                                    endRestartGroup.updateScope(new Function2() { // from class: C4.K
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj, Object obj2) {
                                            Unit TicketSummaryView$lambda$11;
                                            TicketSummaryView$lambda$11 = TicketSummaryViewKt.TicketSummaryView$lambda$11(str, departure, category, transportation, transportationCargoInfo, surcharges, passengerInfo, addons, food, checkoutSeatReservation, iSummaryProduct, transportProducts, priceDetails2, totalPrice, ticketPrice, str5, z12, function12, ticketSection2, z13, passengers, z7, z14, function03, function04, str6, availableProductTypes, subline, str4, i5, i6, i7, i8, (Composer) obj, ((Integer) obj2).intValue());
                                            return TicketSummaryView$lambda$11;
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            i22 = i8 & 33554432;
                            if (i22 != 0) {
                            }
                            if ((i8 & 67108864) != 0) {
                            }
                            if ((i8 & 134217728) != 0) {
                            }
                            if ((i8 & 268435456) != 0) {
                            }
                            if ((i9 & 306783379) != 306783378) {
                            }
                            if (i12 != 0) {
                            }
                            if (i13 != 0) {
                            }
                            if (i14 != 0) {
                            }
                            if (i15 != 0) {
                            }
                            if (i16 != 0) {
                            }
                            if (i17 != 0) {
                            }
                            if (i19 != 0) {
                            }
                            if (i20 != 0) {
                            }
                            if (i21 != 0) {
                            }
                            if (i22 != 0) {
                            }
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            Modifier.Companion companion22 = Modifier.INSTANCE;
                            Modifier height2 = IntrinsicKt.height(companion22, IntrinsicSize.Max);
                            Alignment.Companion companion32 = Alignment.INSTANCE;
                            MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion32.getCenter(), false);
                            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
                            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, height2);
                            ComposeUiNode.Companion companion42 = ComposeUiNode.INSTANCE;
                            int i292 = i9;
                            Function0<ComposeUiNode> constructor3 = companion42.getConstructor();
                            if (startRestartGroup.getApplier() == null) {
                            }
                            startRestartGroup.startReusableNode();
                            if (startRestartGroup.getInserting()) {
                            }
                            m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
                            Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy2, companion42.getSetMeasurePolicy());
                            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap3, companion42.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion42.getSetCompositeKeyHash();
                            if (!m1226constructorimpl.getInserting()) {
                            }
                            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash3);
                            Updater.m1227setimpl(m1226constructorimpl, materializeModifier3, companion42.getSetModifier());
                            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                            Object[] objArr3 = new Object[0];
                            startRestartGroup.startReplaceGroup(257034376);
                            rememberedValue = startRestartGroup.rememberedValue();
                            companion = Composer.INSTANCE;
                            if (rememberedValue == companion.getEmpty()) {
                            }
                            startRestartGroup.endReplaceGroup();
                            final MutableState mutableState32 = (MutableState) RememberSaveableKt.rememberSaveable(objArr3, null, null, (Function0) rememberedValue, startRestartGroup, 3072, 6);
                            Object[] objArr22 = new Object[0];
                            startRestartGroup.startReplaceGroup(257036616);
                            rememberedValue2 = startRestartGroup.rememberedValue();
                            if (rememberedValue2 == companion.getEmpty()) {
                            }
                            startRestartGroup.endReplaceGroup();
                            MutableState mutableState42 = (MutableState) RememberSaveableKt.rememberSaveable(objArr22, null, null, (Function0) rememberedValue2, startRestartGroup, 3072, 6);
                            startRestartGroup.startReplaceGroup(257037904);
                            if (z9) {
                            }
                            startRestartGroup.endReplaceGroup();
                            Modifier m313paddingVpY3zN4$default2 = PaddingKt.m313paddingVpY3zN4$default(companion22, Dp.m2599constructorimpl(16), 0.0f, 2, null);
                            MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), companion32.getStart(), startRestartGroup, 0);
                            currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                            CompositionLocalMap currentCompositionLocalMap22 = startRestartGroup.getCurrentCompositionLocalMap();
                            Modifier materializeModifier22 = ComposedModifierKt.materializeModifier(startRestartGroup, m313paddingVpY3zN4$default2);
                            Function0<ComposeUiNode> constructor22 = companion42.getConstructor();
                            if (startRestartGroup.getApplier() == null) {
                            }
                            startRestartGroup.startReusableNode();
                            if (startRestartGroup.getInserting()) {
                            }
                            m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
                            Updater.m1227setimpl(m1226constructorimpl2, columnMeasurePolicy2, companion42.getSetMeasurePolicy());
                            Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap22, companion42.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash22 = companion42.getSetCompositeKeyHash();
                            if (!m1226constructorimpl2.getInserting()) {
                            }
                            m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                            m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash22);
                            Updater.m1227setimpl(m1226constructorimpl2, materializeModifier22, companion42.getSetModifier());
                            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                            startRestartGroup.startReplaceGroup(1401632598);
                            if (str == null) {
                            }
                            composer2.endReplaceGroup();
                            int i302 = i23 >> 9;
                            int i312 = ((i23 >> 3) & 1022) | (i302 & 7168) | (57344 & i302) | (i302 & 458752) | (i302 & 3670016);
                            int i322 = i25 << 21;
                            int i332 = i312 | (29360128 & i322) | (i322 & 234881024) | ((i28 << 27) & 1879048192);
                            int i342 = i25 >> 6;
                            int i352 = i28 << 6;
                            int i362 = i28 << 3;
                            int i372 = ((i25 >> 24) & 126) | (i342 & 896) | (i352 & 7168) | (57344 & i362) | (i362 & 458752) | (i28 & 3670016);
                            int i382 = i23 << 9;
                            int i392 = i24;
                            MiddleSection(departure, category, transportation, passengerInfo, addons, food, checkoutSeatReservation, iSummaryProduct, transportProducts, passengers, ticketSection3, z15, ticketPrice, z7, function05, function06, availableProductTypes, transportationCargoInfo, surcharges, subline, str4, composer2, i332, i372 | (29360128 & i382) | (i382 & 234881024) | (i352 & 1879048192), (i28 >> 24) & 14);
                            composer3 = composer2;
                            composer3.startReplaceGroup(1401675764);
                            if (z9) {
                            }
                            composer3.endReplaceGroup();
                            composer3.startReplaceGroup(1401681853);
                            mutableState2 = mutableState;
                            changed = composer3.changed(mutableState2);
                            rememberedValue3 = composer3.rememberedValue();
                            if (!changed) {
                            }
                            rememberedValue3 = new Function1() { // from class: C4.J
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    Unit TicketSummaryView$lambda$10$lambda$9$lambda$8$lambda$7;
                                    TicketSummaryView$lambda$10$lambda$9$lambda$8$lambda$7 = TicketSummaryViewKt.TicketSummaryView$lambda$10$lambda$9$lambda$8$lambda$7(MutableState.this, (LayoutCoordinates) obj);
                                    return TicketSummaryView$lambda$10$lambda$9$lambda$8$lambda$7;
                                }
                            };
                            composer3.updateRememberedValue(rememberedValue3);
                            composer3.endReplaceGroup();
                            int i402 = (i342 & 458752) | (i25 & 896) | (i342 & 112) | ((i23 << 6) & 7168) | (i362 & 3670016);
                            composer4 = composer3;
                            TicketSummaryFooterRowKt.TicketSummaryFooterRow(OnGloballyPositionedModifierKt.onGloballyPositioned(companion22, (Function1) rememberedValue3), totalPrice, priceDetails3, departure, z15 ? TypographyKt.getSub() : TypographyKt.getParagraphSmall(), function13, str8, composer3, i402, 0);
                            composer4.endNode();
                            composer4.startReplaceGroup(257112747);
                            if (z10) {
                            }
                            composer4.endReplaceGroup();
                            composer4.endNode();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            priceDetails2 = priceDetails3;
                            z12 = z9;
                            function12 = function13;
                            ticketSection2 = ticketSection3;
                            z13 = z15;
                            str5 = str7;
                            z14 = z10;
                            function03 = function05;
                            function04 = function06;
                            str6 = str8;
                            endRestartGroup = composer4.endRestartGroup();
                            if (endRestartGroup != null) {
                            }
                        }
                        i21 = i8 & 16777216;
                        if (i21 == 0) {
                        }
                        i22 = i8 & 33554432;
                        if (i22 != 0) {
                        }
                        if ((i8 & 67108864) != 0) {
                        }
                        if ((i8 & 134217728) != 0) {
                        }
                        if ((i8 & 268435456) != 0) {
                        }
                        if ((i9 & 306783379) != 306783378) {
                        }
                        if (i12 != 0) {
                        }
                        if (i13 != 0) {
                        }
                        if (i14 != 0) {
                        }
                        if (i15 != 0) {
                        }
                        if (i16 != 0) {
                        }
                        if (i17 != 0) {
                        }
                        if (i19 != 0) {
                        }
                        if (i20 != 0) {
                        }
                        if (i21 != 0) {
                        }
                        if (i22 != 0) {
                        }
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        Modifier.Companion companion222 = Modifier.INSTANCE;
                        Modifier height22 = IntrinsicKt.height(companion222, IntrinsicSize.Max);
                        Alignment.Companion companion322 = Alignment.INSTANCE;
                        MeasurePolicy maybeCachedBoxMeasurePolicy22 = BoxKt.maybeCachedBoxMeasurePolicy(companion322.getCenter(), false);
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap32 = startRestartGroup.getCurrentCompositionLocalMap();
                        Modifier materializeModifier32 = ComposedModifierKt.materializeModifier(startRestartGroup, height22);
                        ComposeUiNode.Companion companion422 = ComposeUiNode.INSTANCE;
                        int i2922 = i9;
                        Function0<ComposeUiNode> constructor32 = companion422.getConstructor();
                        if (startRestartGroup.getApplier() == null) {
                        }
                        startRestartGroup.startReusableNode();
                        if (startRestartGroup.getInserting()) {
                        }
                        m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
                        Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy22, companion422.getSetMeasurePolicy());
                        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap32, companion422.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash32 = companion422.getSetCompositeKeyHash();
                        if (!m1226constructorimpl.getInserting()) {
                        }
                        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash32);
                        Updater.m1227setimpl(m1226constructorimpl, materializeModifier32, companion422.getSetModifier());
                        BoxScopeInstance boxScopeInstance22 = BoxScopeInstance.INSTANCE;
                        Object[] objArr32 = new Object[0];
                        startRestartGroup.startReplaceGroup(257034376);
                        rememberedValue = startRestartGroup.rememberedValue();
                        companion = Composer.INSTANCE;
                        if (rememberedValue == companion.getEmpty()) {
                        }
                        startRestartGroup.endReplaceGroup();
                        final MutableState mutableState322 = (MutableState) RememberSaveableKt.rememberSaveable(objArr32, null, null, (Function0) rememberedValue, startRestartGroup, 3072, 6);
                        Object[] objArr222 = new Object[0];
                        startRestartGroup.startReplaceGroup(257036616);
                        rememberedValue2 = startRestartGroup.rememberedValue();
                        if (rememberedValue2 == companion.getEmpty()) {
                        }
                        startRestartGroup.endReplaceGroup();
                        MutableState mutableState422 = (MutableState) RememberSaveableKt.rememberSaveable(objArr222, null, null, (Function0) rememberedValue2, startRestartGroup, 3072, 6);
                        startRestartGroup.startReplaceGroup(257037904);
                        if (z9) {
                        }
                        startRestartGroup.endReplaceGroup();
                        Modifier m313paddingVpY3zN4$default22 = PaddingKt.m313paddingVpY3zN4$default(companion222, Dp.m2599constructorimpl(16), 0.0f, 2, null);
                        MeasurePolicy columnMeasurePolicy22 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), companion322.getStart(), startRestartGroup, 0);
                        currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap222 = startRestartGroup.getCurrentCompositionLocalMap();
                        Modifier materializeModifier222 = ComposedModifierKt.materializeModifier(startRestartGroup, m313paddingVpY3zN4$default22);
                        Function0<ComposeUiNode> constructor222 = companion422.getConstructor();
                        if (startRestartGroup.getApplier() == null) {
                        }
                        startRestartGroup.startReusableNode();
                        if (startRestartGroup.getInserting()) {
                        }
                        m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
                        Updater.m1227setimpl(m1226constructorimpl2, columnMeasurePolicy22, companion422.getSetMeasurePolicy());
                        Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap222, companion422.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash222 = companion422.getSetCompositeKeyHash();
                        if (!m1226constructorimpl2.getInserting()) {
                        }
                        m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash222);
                        Updater.m1227setimpl(m1226constructorimpl2, materializeModifier222, companion422.getSetModifier());
                        ColumnScopeInstance columnScopeInstance22 = ColumnScopeInstance.INSTANCE;
                        startRestartGroup.startReplaceGroup(1401632598);
                        if (str == null) {
                        }
                        composer2.endReplaceGroup();
                        int i3022 = i23 >> 9;
                        int i3122 = ((i23 >> 3) & 1022) | (i3022 & 7168) | (57344 & i3022) | (i3022 & 458752) | (i3022 & 3670016);
                        int i3222 = i25 << 21;
                        int i3322 = i3122 | (29360128 & i3222) | (i3222 & 234881024) | ((i28 << 27) & 1879048192);
                        int i3422 = i25 >> 6;
                        int i3522 = i28 << 6;
                        int i3622 = i28 << 3;
                        int i3722 = ((i25 >> 24) & 126) | (i3422 & 896) | (i3522 & 7168) | (57344 & i3622) | (i3622 & 458752) | (i28 & 3670016);
                        int i3822 = i23 << 9;
                        int i3922 = i24;
                        MiddleSection(departure, category, transportation, passengerInfo, addons, food, checkoutSeatReservation, iSummaryProduct, transportProducts, passengers, ticketSection3, z15, ticketPrice, z7, function05, function06, availableProductTypes, transportationCargoInfo, surcharges, subline, str4, composer2, i3322, i3722 | (29360128 & i3822) | (i3822 & 234881024) | (i3522 & 1879048192), (i28 >> 24) & 14);
                        composer3 = composer2;
                        composer3.startReplaceGroup(1401675764);
                        if (z9) {
                        }
                        composer3.endReplaceGroup();
                        composer3.startReplaceGroup(1401681853);
                        mutableState2 = mutableState;
                        changed = composer3.changed(mutableState2);
                        rememberedValue3 = composer3.rememberedValue();
                        if (!changed) {
                        }
                        rememberedValue3 = new Function1() { // from class: C4.J
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                Unit TicketSummaryView$lambda$10$lambda$9$lambda$8$lambda$7;
                                TicketSummaryView$lambda$10$lambda$9$lambda$8$lambda$7 = TicketSummaryViewKt.TicketSummaryView$lambda$10$lambda$9$lambda$8$lambda$7(MutableState.this, (LayoutCoordinates) obj);
                                return TicketSummaryView$lambda$10$lambda$9$lambda$8$lambda$7;
                            }
                        };
                        composer3.updateRememberedValue(rememberedValue3);
                        composer3.endReplaceGroup();
                        int i4022 = (i3422 & 458752) | (i25 & 896) | (i3422 & 112) | ((i23 << 6) & 7168) | (i3622 & 3670016);
                        composer4 = composer3;
                        TicketSummaryFooterRowKt.TicketSummaryFooterRow(OnGloballyPositionedModifierKt.onGloballyPositioned(companion222, (Function1) rememberedValue3), totalPrice, priceDetails3, departure, z15 ? TypographyKt.getSub() : TypographyKt.getParagraphSmall(), function13, str8, composer3, i4022, 0);
                        composer4.endNode();
                        composer4.startReplaceGroup(257112747);
                        if (z10) {
                        }
                        composer4.endReplaceGroup();
                        composer4.endNode();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        priceDetails2 = priceDetails3;
                        z12 = z9;
                        function12 = function13;
                        ticketSection2 = ticketSection3;
                        z13 = z15;
                        str5 = str7;
                        z14 = z10;
                        function03 = function05;
                        function04 = function06;
                        str6 = str8;
                        endRestartGroup = composer4.endRestartGroup();
                        if (endRestartGroup != null) {
                        }
                    }
                    i20 = i8 & 8388608;
                    if (i20 != 0) {
                    }
                    i21 = i8 & 16777216;
                    if (i21 == 0) {
                    }
                    i22 = i8 & 33554432;
                    if (i22 != 0) {
                    }
                    if ((i8 & 67108864) != 0) {
                    }
                    if ((i8 & 134217728) != 0) {
                    }
                    if ((i8 & 268435456) != 0) {
                    }
                    if ((i9 & 306783379) != 306783378) {
                    }
                    if (i12 != 0) {
                    }
                    if (i13 != 0) {
                    }
                    if (i14 != 0) {
                    }
                    if (i15 != 0) {
                    }
                    if (i16 != 0) {
                    }
                    if (i17 != 0) {
                    }
                    if (i19 != 0) {
                    }
                    if (i20 != 0) {
                    }
                    if (i21 != 0) {
                    }
                    if (i22 != 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    Modifier.Companion companion2222 = Modifier.INSTANCE;
                    Modifier height222 = IntrinsicKt.height(companion2222, IntrinsicSize.Max);
                    Alignment.Companion companion3222 = Alignment.INSTANCE;
                    MeasurePolicy maybeCachedBoxMeasurePolicy222 = BoxKt.maybeCachedBoxMeasurePolicy(companion3222.getCenter(), false);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap322 = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier materializeModifier322 = ComposedModifierKt.materializeModifier(startRestartGroup, height222);
                    ComposeUiNode.Companion companion4222 = ComposeUiNode.INSTANCE;
                    int i29222 = i9;
                    Function0<ComposeUiNode> constructor322 = companion4222.getConstructor();
                    if (startRestartGroup.getApplier() == null) {
                    }
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.getInserting()) {
                    }
                    m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
                    Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy222, companion4222.getSetMeasurePolicy());
                    Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap322, companion4222.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash322 = companion4222.getSetCompositeKeyHash();
                    if (!m1226constructorimpl.getInserting()) {
                    }
                    m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash322);
                    Updater.m1227setimpl(m1226constructorimpl, materializeModifier322, companion4222.getSetModifier());
                    BoxScopeInstance boxScopeInstance222 = BoxScopeInstance.INSTANCE;
                    Object[] objArr322 = new Object[0];
                    startRestartGroup.startReplaceGroup(257034376);
                    rememberedValue = startRestartGroup.rememberedValue();
                    companion = Composer.INSTANCE;
                    if (rememberedValue == companion.getEmpty()) {
                    }
                    startRestartGroup.endReplaceGroup();
                    final MutableState mutableState3222 = (MutableState) RememberSaveableKt.rememberSaveable(objArr322, null, null, (Function0) rememberedValue, startRestartGroup, 3072, 6);
                    Object[] objArr2222 = new Object[0];
                    startRestartGroup.startReplaceGroup(257036616);
                    rememberedValue2 = startRestartGroup.rememberedValue();
                    if (rememberedValue2 == companion.getEmpty()) {
                    }
                    startRestartGroup.endReplaceGroup();
                    MutableState mutableState4222 = (MutableState) RememberSaveableKt.rememberSaveable(objArr2222, null, null, (Function0) rememberedValue2, startRestartGroup, 3072, 6);
                    startRestartGroup.startReplaceGroup(257037904);
                    if (z9) {
                    }
                    startRestartGroup.endReplaceGroup();
                    Modifier m313paddingVpY3zN4$default222 = PaddingKt.m313paddingVpY3zN4$default(companion2222, Dp.m2599constructorimpl(16), 0.0f, 2, null);
                    MeasurePolicy columnMeasurePolicy222 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), companion3222.getStart(), startRestartGroup, 0);
                    currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap2222 = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier materializeModifier2222 = ComposedModifierKt.materializeModifier(startRestartGroup, m313paddingVpY3zN4$default222);
                    Function0<ComposeUiNode> constructor2222 = companion4222.getConstructor();
                    if (startRestartGroup.getApplier() == null) {
                    }
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.getInserting()) {
                    }
                    m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
                    Updater.m1227setimpl(m1226constructorimpl2, columnMeasurePolicy222, companion4222.getSetMeasurePolicy());
                    Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2222, companion4222.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2222 = companion4222.getSetCompositeKeyHash();
                    if (!m1226constructorimpl2.getInserting()) {
                    }
                    m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2222);
                    Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2222, companion4222.getSetModifier());
                    ColumnScopeInstance columnScopeInstance222 = ColumnScopeInstance.INSTANCE;
                    startRestartGroup.startReplaceGroup(1401632598);
                    if (str == null) {
                    }
                    composer2.endReplaceGroup();
                    int i30222 = i23 >> 9;
                    int i31222 = ((i23 >> 3) & 1022) | (i30222 & 7168) | (57344 & i30222) | (i30222 & 458752) | (i30222 & 3670016);
                    int i32222 = i25 << 21;
                    int i33222 = i31222 | (29360128 & i32222) | (i32222 & 234881024) | ((i28 << 27) & 1879048192);
                    int i34222 = i25 >> 6;
                    int i35222 = i28 << 6;
                    int i36222 = i28 << 3;
                    int i37222 = ((i25 >> 24) & 126) | (i34222 & 896) | (i35222 & 7168) | (57344 & i36222) | (i36222 & 458752) | (i28 & 3670016);
                    int i38222 = i23 << 9;
                    int i39222 = i24;
                    MiddleSection(departure, category, transportation, passengerInfo, addons, food, checkoutSeatReservation, iSummaryProduct, transportProducts, passengers, ticketSection3, z15, ticketPrice, z7, function05, function06, availableProductTypes, transportationCargoInfo, surcharges, subline, str4, composer2, i33222, i37222 | (29360128 & i38222) | (i38222 & 234881024) | (i35222 & 1879048192), (i28 >> 24) & 14);
                    composer3 = composer2;
                    composer3.startReplaceGroup(1401675764);
                    if (z9) {
                    }
                    composer3.endReplaceGroup();
                    composer3.startReplaceGroup(1401681853);
                    mutableState2 = mutableState;
                    changed = composer3.changed(mutableState2);
                    rememberedValue3 = composer3.rememberedValue();
                    if (!changed) {
                    }
                    rememberedValue3 = new Function1() { // from class: C4.J
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit TicketSummaryView$lambda$10$lambda$9$lambda$8$lambda$7;
                            TicketSummaryView$lambda$10$lambda$9$lambda$8$lambda$7 = TicketSummaryViewKt.TicketSummaryView$lambda$10$lambda$9$lambda$8$lambda$7(MutableState.this, (LayoutCoordinates) obj);
                            return TicketSummaryView$lambda$10$lambda$9$lambda$8$lambda$7;
                        }
                    };
                    composer3.updateRememberedValue(rememberedValue3);
                    composer3.endReplaceGroup();
                    int i40222 = (i34222 & 458752) | (i25 & 896) | (i34222 & 112) | ((i23 << 6) & 7168) | (i36222 & 3670016);
                    composer4 = composer3;
                    TicketSummaryFooterRowKt.TicketSummaryFooterRow(OnGloballyPositionedModifierKt.onGloballyPositioned(companion2222, (Function1) rememberedValue3), totalPrice, priceDetails3, departure, z15 ? TypographyKt.getSub() : TypographyKt.getParagraphSmall(), function13, str8, composer3, i40222, 0);
                    composer4.endNode();
                    composer4.startReplaceGroup(257112747);
                    if (z10) {
                    }
                    composer4.endReplaceGroup();
                    composer4.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    priceDetails2 = priceDetails3;
                    z12 = z9;
                    function12 = function13;
                    ticketSection2 = ticketSection3;
                    z13 = z15;
                    str5 = str7;
                    z14 = z10;
                    function03 = function05;
                    function04 = function06;
                    str6 = str8;
                    endRestartGroup = composer4.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                if ((i8 & 8192) == 0) {
                }
                if ((i8 & 16384) == 0) {
                }
                i13 = 32768 & i8;
                if (i13 == 0) {
                }
                i14 = i8 & 65536;
                if (i14 == 0) {
                }
                i15 = i8 & 131072;
                if (i15 == 0) {
                }
                i16 = i8 & 262144;
                if (i16 == 0) {
                }
                i17 = i8 & 524288;
                if (i17 == 0) {
                }
                if ((i8 & 1048576) == 0) {
                }
                if ((i8 & 2097152) == 0) {
                }
                int i282 = i18;
                i19 = i8 & 4194304;
                if (i19 == 0) {
                }
                i20 = i8 & 8388608;
                if (i20 != 0) {
                }
                i21 = i8 & 16777216;
                if (i21 == 0) {
                }
                i22 = i8 & 33554432;
                if (i22 != 0) {
                }
                if ((i8 & 67108864) != 0) {
                }
                if ((i8 & 134217728) != 0) {
                }
                if ((i8 & 268435456) != 0) {
                }
                if ((i9 & 306783379) != 306783378) {
                }
                if (i12 != 0) {
                }
                if (i13 != 0) {
                }
                if (i14 != 0) {
                }
                if (i15 != 0) {
                }
                if (i16 != 0) {
                }
                if (i17 != 0) {
                }
                if (i19 != 0) {
                }
                if (i20 != 0) {
                }
                if (i21 != 0) {
                }
                if (i22 != 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                Modifier.Companion companion22222 = Modifier.INSTANCE;
                Modifier height2222 = IntrinsicKt.height(companion22222, IntrinsicSize.Max);
                Alignment.Companion companion32222 = Alignment.INSTANCE;
                MeasurePolicy maybeCachedBoxMeasurePolicy2222 = BoxKt.maybeCachedBoxMeasurePolicy(companion32222.getCenter(), false);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3222 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier3222 = ComposedModifierKt.materializeModifier(startRestartGroup, height2222);
                ComposeUiNode.Companion companion42222 = ComposeUiNode.INSTANCE;
                int i292222 = i9;
                Function0<ComposeUiNode> constructor3222 = companion42222.getConstructor();
                if (startRestartGroup.getApplier() == null) {
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                }
                m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
                Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy2222, companion42222.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap3222, companion42222.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3222 = companion42222.getSetCompositeKeyHash();
                if (!m1226constructorimpl.getInserting()) {
                }
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash3222);
                Updater.m1227setimpl(m1226constructorimpl, materializeModifier3222, companion42222.getSetModifier());
                BoxScopeInstance boxScopeInstance2222 = BoxScopeInstance.INSTANCE;
                Object[] objArr3222 = new Object[0];
                startRestartGroup.startReplaceGroup(257034376);
                rememberedValue = startRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (rememberedValue == companion.getEmpty()) {
                }
                startRestartGroup.endReplaceGroup();
                final MutableState mutableState32222 = (MutableState) RememberSaveableKt.rememberSaveable(objArr3222, null, null, (Function0) rememberedValue, startRestartGroup, 3072, 6);
                Object[] objArr22222 = new Object[0];
                startRestartGroup.startReplaceGroup(257036616);
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (rememberedValue2 == companion.getEmpty()) {
                }
                startRestartGroup.endReplaceGroup();
                MutableState mutableState42222 = (MutableState) RememberSaveableKt.rememberSaveable(objArr22222, null, null, (Function0) rememberedValue2, startRestartGroup, 3072, 6);
                startRestartGroup.startReplaceGroup(257037904);
                if (z9) {
                }
                startRestartGroup.endReplaceGroup();
                Modifier m313paddingVpY3zN4$default2222 = PaddingKt.m313paddingVpY3zN4$default(companion22222, Dp.m2599constructorimpl(16), 0.0f, 2, null);
                MeasurePolicy columnMeasurePolicy2222 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), companion32222.getStart(), startRestartGroup, 0);
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap22222 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier22222 = ComposedModifierKt.materializeModifier(startRestartGroup, m313paddingVpY3zN4$default2222);
                Function0<ComposeUiNode> constructor22222 = companion42222.getConstructor();
                if (startRestartGroup.getApplier() == null) {
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                }
                m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
                Updater.m1227setimpl(m1226constructorimpl2, columnMeasurePolicy2222, companion42222.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap22222, companion42222.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash22222 = companion42222.getSetCompositeKeyHash();
                if (!m1226constructorimpl2.getInserting()) {
                }
                m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash22222);
                Updater.m1227setimpl(m1226constructorimpl2, materializeModifier22222, companion42222.getSetModifier());
                ColumnScopeInstance columnScopeInstance2222 = ColumnScopeInstance.INSTANCE;
                startRestartGroup.startReplaceGroup(1401632598);
                if (str == null) {
                }
                composer2.endReplaceGroup();
                int i302222 = i23 >> 9;
                int i312222 = ((i23 >> 3) & 1022) | (i302222 & 7168) | (57344 & i302222) | (i302222 & 458752) | (i302222 & 3670016);
                int i322222 = i25 << 21;
                int i332222 = i312222 | (29360128 & i322222) | (i322222 & 234881024) | ((i282 << 27) & 1879048192);
                int i342222 = i25 >> 6;
                int i352222 = i282 << 6;
                int i362222 = i282 << 3;
                int i372222 = ((i25 >> 24) & 126) | (i342222 & 896) | (i352222 & 7168) | (57344 & i362222) | (i362222 & 458752) | (i282 & 3670016);
                int i382222 = i23 << 9;
                int i392222 = i24;
                MiddleSection(departure, category, transportation, passengerInfo, addons, food, checkoutSeatReservation, iSummaryProduct, transportProducts, passengers, ticketSection3, z15, ticketPrice, z7, function05, function06, availableProductTypes, transportationCargoInfo, surcharges, subline, str4, composer2, i332222, i372222 | (29360128 & i382222) | (i382222 & 234881024) | (i352222 & 1879048192), (i282 >> 24) & 14);
                composer3 = composer2;
                composer3.startReplaceGroup(1401675764);
                if (z9) {
                }
                composer3.endReplaceGroup();
                composer3.startReplaceGroup(1401681853);
                mutableState2 = mutableState;
                changed = composer3.changed(mutableState2);
                rememberedValue3 = composer3.rememberedValue();
                if (!changed) {
                }
                rememberedValue3 = new Function1() { // from class: C4.J
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit TicketSummaryView$lambda$10$lambda$9$lambda$8$lambda$7;
                        TicketSummaryView$lambda$10$lambda$9$lambda$8$lambda$7 = TicketSummaryViewKt.TicketSummaryView$lambda$10$lambda$9$lambda$8$lambda$7(MutableState.this, (LayoutCoordinates) obj);
                        return TicketSummaryView$lambda$10$lambda$9$lambda$8$lambda$7;
                    }
                };
                composer3.updateRememberedValue(rememberedValue3);
                composer3.endReplaceGroup();
                int i402222 = (i342222 & 458752) | (i25 & 896) | (i342222 & 112) | ((i23 << 6) & 7168) | (i362222 & 3670016);
                composer4 = composer3;
                TicketSummaryFooterRowKt.TicketSummaryFooterRow(OnGloballyPositionedModifierKt.onGloballyPositioned(companion22222, (Function1) rememberedValue3), totalPrice, priceDetails3, departure, z15 ? TypographyKt.getSub() : TypographyKt.getParagraphSmall(), function13, str8, composer3, i402222, 0);
                composer4.endNode();
                composer4.startReplaceGroup(257112747);
                if (z10) {
                }
                composer4.endReplaceGroup();
                composer4.endNode();
                if (ComposerKt.isTraceInProgress()) {
                }
                priceDetails2 = priceDetails3;
                z12 = z9;
                function12 = function13;
                ticketSection2 = ticketSection3;
                z13 = z15;
                str5 = str7;
                z14 = z10;
                function03 = function05;
                function04 = function06;
                str6 = str8;
                endRestartGroup = composer4.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            if ((i8 & 1024) != 0) {
            }
            if ((i8 & 2048) != 0) {
            }
            int i272 = i11;
            i12 = i8 & 4096;
            if (i12 != 0) {
            }
            if ((i8 & 8192) == 0) {
            }
            if ((i8 & 16384) == 0) {
            }
            i13 = 32768 & i8;
            if (i13 == 0) {
            }
            i14 = i8 & 65536;
            if (i14 == 0) {
            }
            i15 = i8 & 131072;
            if (i15 == 0) {
            }
            i16 = i8 & 262144;
            if (i16 == 0) {
            }
            i17 = i8 & 524288;
            if (i17 == 0) {
            }
            if ((i8 & 1048576) == 0) {
            }
            if ((i8 & 2097152) == 0) {
            }
            int i2822 = i18;
            i19 = i8 & 4194304;
            if (i19 == 0) {
            }
            i20 = i8 & 8388608;
            if (i20 != 0) {
            }
            i21 = i8 & 16777216;
            if (i21 == 0) {
            }
            i22 = i8 & 33554432;
            if (i22 != 0) {
            }
            if ((i8 & 67108864) != 0) {
            }
            if ((i8 & 134217728) != 0) {
            }
            if ((i8 & 268435456) != 0) {
            }
            if ((i9 & 306783379) != 306783378) {
            }
            if (i12 != 0) {
            }
            if (i13 != 0) {
            }
            if (i14 != 0) {
            }
            if (i15 != 0) {
            }
            if (i16 != 0) {
            }
            if (i17 != 0) {
            }
            if (i19 != 0) {
            }
            if (i20 != 0) {
            }
            if (i21 != 0) {
            }
            if (i22 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            Modifier.Companion companion222222 = Modifier.INSTANCE;
            Modifier height22222 = IntrinsicKt.height(companion222222, IntrinsicSize.Max);
            Alignment.Companion companion322222 = Alignment.INSTANCE;
            MeasurePolicy maybeCachedBoxMeasurePolicy22222 = BoxKt.maybeCachedBoxMeasurePolicy(companion322222.getCenter(), false);
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap32222 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier32222 = ComposedModifierKt.materializeModifier(startRestartGroup, height22222);
            ComposeUiNode.Companion companion422222 = ComposeUiNode.INSTANCE;
            int i2922222 = i9;
            Function0<ComposeUiNode> constructor32222 = companion422222.getConstructor();
            if (startRestartGroup.getApplier() == null) {
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
            }
            m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy22222, companion422222.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap32222, companion422222.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash32222 = companion422222.getSetCompositeKeyHash();
            if (!m1226constructorimpl.getInserting()) {
            }
            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash32222);
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier32222, companion422222.getSetModifier());
            BoxScopeInstance boxScopeInstance22222 = BoxScopeInstance.INSTANCE;
            Object[] objArr32222 = new Object[0];
            startRestartGroup.startReplaceGroup(257034376);
            rememberedValue = startRestartGroup.rememberedValue();
            companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
            }
            startRestartGroup.endReplaceGroup();
            final MutableState mutableState322222 = (MutableState) RememberSaveableKt.rememberSaveable(objArr32222, null, null, (Function0) rememberedValue, startRestartGroup, 3072, 6);
            Object[] objArr222222 = new Object[0];
            startRestartGroup.startReplaceGroup(257036616);
            rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion.getEmpty()) {
            }
            startRestartGroup.endReplaceGroup();
            MutableState mutableState422222 = (MutableState) RememberSaveableKt.rememberSaveable(objArr222222, null, null, (Function0) rememberedValue2, startRestartGroup, 3072, 6);
            startRestartGroup.startReplaceGroup(257037904);
            if (z9) {
            }
            startRestartGroup.endReplaceGroup();
            Modifier m313paddingVpY3zN4$default22222 = PaddingKt.m313paddingVpY3zN4$default(companion222222, Dp.m2599constructorimpl(16), 0.0f, 2, null);
            MeasurePolicy columnMeasurePolicy22222 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), companion322222.getStart(), startRestartGroup, 0);
            currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap222222 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier222222 = ComposedModifierKt.materializeModifier(startRestartGroup, m313paddingVpY3zN4$default22222);
            Function0<ComposeUiNode> constructor222222 = companion422222.getConstructor();
            if (startRestartGroup.getApplier() == null) {
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
            }
            m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl2, columnMeasurePolicy22222, companion422222.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap222222, companion422222.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash222222 = companion422222.getSetCompositeKeyHash();
            if (!m1226constructorimpl2.getInserting()) {
            }
            m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
            m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash222222);
            Updater.m1227setimpl(m1226constructorimpl2, materializeModifier222222, companion422222.getSetModifier());
            ColumnScopeInstance columnScopeInstance22222 = ColumnScopeInstance.INSTANCE;
            startRestartGroup.startReplaceGroup(1401632598);
            if (str == null) {
            }
            composer2.endReplaceGroup();
            int i3022222 = i23 >> 9;
            int i3122222 = ((i23 >> 3) & 1022) | (i3022222 & 7168) | (57344 & i3022222) | (i3022222 & 458752) | (i3022222 & 3670016);
            int i3222222 = i25 << 21;
            int i3322222 = i3122222 | (29360128 & i3222222) | (i3222222 & 234881024) | ((i2822 << 27) & 1879048192);
            int i3422222 = i25 >> 6;
            int i3522222 = i2822 << 6;
            int i3622222 = i2822 << 3;
            int i3722222 = ((i25 >> 24) & 126) | (i3422222 & 896) | (i3522222 & 7168) | (57344 & i3622222) | (i3622222 & 458752) | (i2822 & 3670016);
            int i3822222 = i23 << 9;
            int i3922222 = i24;
            MiddleSection(departure, category, transportation, passengerInfo, addons, food, checkoutSeatReservation, iSummaryProduct, transportProducts, passengers, ticketSection3, z15, ticketPrice, z7, function05, function06, availableProductTypes, transportationCargoInfo, surcharges, subline, str4, composer2, i3322222, i3722222 | (29360128 & i3822222) | (i3822222 & 234881024) | (i3522222 & 1879048192), (i2822 >> 24) & 14);
            composer3 = composer2;
            composer3.startReplaceGroup(1401675764);
            if (z9) {
            }
            composer3.endReplaceGroup();
            composer3.startReplaceGroup(1401681853);
            mutableState2 = mutableState;
            changed = composer3.changed(mutableState2);
            rememberedValue3 = composer3.rememberedValue();
            if (!changed) {
            }
            rememberedValue3 = new Function1() { // from class: C4.J
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit TicketSummaryView$lambda$10$lambda$9$lambda$8$lambda$7;
                    TicketSummaryView$lambda$10$lambda$9$lambda$8$lambda$7 = TicketSummaryViewKt.TicketSummaryView$lambda$10$lambda$9$lambda$8$lambda$7(MutableState.this, (LayoutCoordinates) obj);
                    return TicketSummaryView$lambda$10$lambda$9$lambda$8$lambda$7;
                }
            };
            composer3.updateRememberedValue(rememberedValue3);
            composer3.endReplaceGroup();
            int i4022222 = (i3422222 & 458752) | (i25 & 896) | (i3422222 & 112) | ((i23 << 6) & 7168) | (i3622222 & 3670016);
            composer4 = composer3;
            TicketSummaryFooterRowKt.TicketSummaryFooterRow(OnGloballyPositionedModifierKt.onGloballyPositioned(companion222222, (Function1) rememberedValue3), totalPrice, priceDetails3, departure, z15 ? TypographyKt.getSub() : TypographyKt.getParagraphSmall(), function13, str8, composer3, i4022222, 0);
            composer4.endNode();
            composer4.startReplaceGroup(257112747);
            if (z10) {
            }
            composer4.endReplaceGroup();
            composer4.endNode();
            if (ComposerKt.isTraceInProgress()) {
            }
            priceDetails2 = priceDetails3;
            z12 = z9;
            function12 = function13;
            ticketSection2 = ticketSection3;
            z13 = z15;
            str5 = str7;
            z14 = z10;
            function03 = function05;
            function04 = function06;
            str6 = str8;
            endRestartGroup = composer4.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        if ((i8 & 32) == 0) {
        }
        if ((i8 & 64) == 0) {
        }
        if ((i8 & 128) == 0) {
        }
        if ((i8 & 256) == 0) {
        }
        if ((i8 & 512) == 0) {
        }
        if ((i8 & 1024) != 0) {
        }
        if ((i8 & 2048) != 0) {
        }
        int i2722 = i11;
        i12 = i8 & 4096;
        if (i12 != 0) {
        }
        if ((i8 & 8192) == 0) {
        }
        if ((i8 & 16384) == 0) {
        }
        i13 = 32768 & i8;
        if (i13 == 0) {
        }
        i14 = i8 & 65536;
        if (i14 == 0) {
        }
        i15 = i8 & 131072;
        if (i15 == 0) {
        }
        i16 = i8 & 262144;
        if (i16 == 0) {
        }
        i17 = i8 & 524288;
        if (i17 == 0) {
        }
        if ((i8 & 1048576) == 0) {
        }
        if ((i8 & 2097152) == 0) {
        }
        int i28222 = i18;
        i19 = i8 & 4194304;
        if (i19 == 0) {
        }
        i20 = i8 & 8388608;
        if (i20 != 0) {
        }
        i21 = i8 & 16777216;
        if (i21 == 0) {
        }
        i22 = i8 & 33554432;
        if (i22 != 0) {
        }
        if ((i8 & 67108864) != 0) {
        }
        if ((i8 & 134217728) != 0) {
        }
        if ((i8 & 268435456) != 0) {
        }
        if ((i9 & 306783379) != 306783378) {
        }
        if (i12 != 0) {
        }
        if (i13 != 0) {
        }
        if (i14 != 0) {
        }
        if (i15 != 0) {
        }
        if (i16 != 0) {
        }
        if (i17 != 0) {
        }
        if (i19 != 0) {
        }
        if (i20 != 0) {
        }
        if (i21 != 0) {
        }
        if (i22 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        Modifier.Companion companion2222222 = Modifier.INSTANCE;
        Modifier height222222 = IntrinsicKt.height(companion2222222, IntrinsicSize.Max);
        Alignment.Companion companion3222222 = Alignment.INSTANCE;
        MeasurePolicy maybeCachedBoxMeasurePolicy222222 = BoxKt.maybeCachedBoxMeasurePolicy(companion3222222.getCenter(), false);
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap322222 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier322222 = ComposedModifierKt.materializeModifier(startRestartGroup, height222222);
        ComposeUiNode.Companion companion4222222 = ComposeUiNode.INSTANCE;
        int i29222222 = i9;
        Function0<ComposeUiNode> constructor322222 = companion4222222.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
        Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy222222, companion4222222.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap322222, companion4222222.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash322222 = companion4222222.getSetCompositeKeyHash();
        if (!m1226constructorimpl.getInserting()) {
        }
        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash322222);
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier322222, companion4222222.getSetModifier());
        BoxScopeInstance boxScopeInstance222222 = BoxScopeInstance.INSTANCE;
        Object[] objArr322222 = new Object[0];
        startRestartGroup.startReplaceGroup(257034376);
        rememberedValue = startRestartGroup.rememberedValue();
        companion = Composer.INSTANCE;
        if (rememberedValue == companion.getEmpty()) {
        }
        startRestartGroup.endReplaceGroup();
        final MutableState mutableState3222222 = (MutableState) RememberSaveableKt.rememberSaveable(objArr322222, null, null, (Function0) rememberedValue, startRestartGroup, 3072, 6);
        Object[] objArr2222222 = new Object[0];
        startRestartGroup.startReplaceGroup(257036616);
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (rememberedValue2 == companion.getEmpty()) {
        }
        startRestartGroup.endReplaceGroup();
        MutableState mutableState4222222 = (MutableState) RememberSaveableKt.rememberSaveable(objArr2222222, null, null, (Function0) rememberedValue2, startRestartGroup, 3072, 6);
        startRestartGroup.startReplaceGroup(257037904);
        if (z9) {
        }
        startRestartGroup.endReplaceGroup();
        Modifier m313paddingVpY3zN4$default222222 = PaddingKt.m313paddingVpY3zN4$default(companion2222222, Dp.m2599constructorimpl(16), 0.0f, 2, null);
        MeasurePolicy columnMeasurePolicy222222 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), companion3222222.getStart(), startRestartGroup, 0);
        currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap2222222 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier2222222 = ComposedModifierKt.materializeModifier(startRestartGroup, m313paddingVpY3zN4$default222222);
        Function0<ComposeUiNode> constructor2222222 = companion4222222.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
        Updater.m1227setimpl(m1226constructorimpl2, columnMeasurePolicy222222, companion4222222.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2222222, companion4222222.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2222222 = companion4222222.getSetCompositeKeyHash();
        if (!m1226constructorimpl2.getInserting()) {
        }
        m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
        m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2222222);
        Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2222222, companion4222222.getSetModifier());
        ColumnScopeInstance columnScopeInstance222222 = ColumnScopeInstance.INSTANCE;
        startRestartGroup.startReplaceGroup(1401632598);
        if (str == null) {
        }
        composer2.endReplaceGroup();
        int i30222222 = i23 >> 9;
        int i31222222 = ((i23 >> 3) & 1022) | (i30222222 & 7168) | (57344 & i30222222) | (i30222222 & 458752) | (i30222222 & 3670016);
        int i32222222 = i25 << 21;
        int i33222222 = i31222222 | (29360128 & i32222222) | (i32222222 & 234881024) | ((i28222 << 27) & 1879048192);
        int i34222222 = i25 >> 6;
        int i35222222 = i28222 << 6;
        int i36222222 = i28222 << 3;
        int i37222222 = ((i25 >> 24) & 126) | (i34222222 & 896) | (i35222222 & 7168) | (57344 & i36222222) | (i36222222 & 458752) | (i28222 & 3670016);
        int i38222222 = i23 << 9;
        int i39222222 = i24;
        MiddleSection(departure, category, transportation, passengerInfo, addons, food, checkoutSeatReservation, iSummaryProduct, transportProducts, passengers, ticketSection3, z15, ticketPrice, z7, function05, function06, availableProductTypes, transportationCargoInfo, surcharges, subline, str4, composer2, i33222222, i37222222 | (29360128 & i38222222) | (i38222222 & 234881024) | (i35222222 & 1879048192), (i28222 >> 24) & 14);
        composer3 = composer2;
        composer3.startReplaceGroup(1401675764);
        if (z9) {
        }
        composer3.endReplaceGroup();
        composer3.startReplaceGroup(1401681853);
        mutableState2 = mutableState;
        changed = composer3.changed(mutableState2);
        rememberedValue3 = composer3.rememberedValue();
        if (!changed) {
        }
        rememberedValue3 = new Function1() { // from class: C4.J
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit TicketSummaryView$lambda$10$lambda$9$lambda$8$lambda$7;
                TicketSummaryView$lambda$10$lambda$9$lambda$8$lambda$7 = TicketSummaryViewKt.TicketSummaryView$lambda$10$lambda$9$lambda$8$lambda$7(MutableState.this, (LayoutCoordinates) obj);
                return TicketSummaryView$lambda$10$lambda$9$lambda$8$lambda$7;
            }
        };
        composer3.updateRememberedValue(rememberedValue3);
        composer3.endReplaceGroup();
        int i40222222 = (i34222222 & 458752) | (i25 & 896) | (i34222222 & 112) | ((i23 << 6) & 7168) | (i36222222 & 3670016);
        composer4 = composer3;
        TicketSummaryFooterRowKt.TicketSummaryFooterRow(OnGloballyPositionedModifierKt.onGloballyPositioned(companion2222222, (Function1) rememberedValue3), totalPrice, priceDetails3, departure, z15 ? TypographyKt.getSub() : TypographyKt.getParagraphSmall(), function13, str8, composer3, i40222222, 0);
        composer4.endNode();
        composer4.startReplaceGroup(257112747);
        if (z10) {
        }
        composer4.endReplaceGroup();
        composer4.endNode();
        if (ComposerKt.isTraceInProgress()) {
        }
        priceDetails2 = priceDetails3;
        z12 = z9;
        function12 = function13;
        ticketSection2 = ticketSection3;
        z13 = z15;
        str5 = str7;
        z14 = z10;
        function03 = function05;
        function04 = function06;
        str6 = str8;
        endRestartGroup = composer4.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState TicketSummaryView$lambda$10$lambda$1$lambda$0() {
        MutableState mutableStateOf$default;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
        return mutableStateOf$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState TicketSummaryView$lambda$10$lambda$3$lambda$2() {
        MutableState mutableStateOf$default;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
        return mutableStateOf$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TicketSummaryView$lambda$10$lambda$9$lambda$6$lambda$5$lambda$4(MutableState mutableState, LayoutCoordinates it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(Integer.valueOf(IntSize.m2660getHeightimpl(it.mo1948getSizeYbymL2g())));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TicketSummaryView$lambda$10$lambda$9$lambda$8$lambda$7(MutableState mutableState, LayoutCoordinates it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(Integer.valueOf(IntSize.m2660getHeightimpl(it.mo1948getSizeYbymL2g())));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TicketSummaryView$lambda$11(String str, IDepartureInfo iDepartureInfo, TicketCategory ticketCategory, Transportation transportation, TransportationCargoInfo transportationCargoInfo, List list, PassengerInfo passengerInfo, List list2, List list3, CheckoutSeatReservation checkoutSeatReservation, ISummaryProduct iSummaryProduct, List list4, PriceDetails priceDetails, PriceTotal priceTotal, Price price, String str2, boolean z5, Function1 function1, TicketSection ticketSection, boolean z6, List list5, boolean z7, boolean z8, Function0 function0, Function0 function02, String str3, List list6, Subline subline, String str4, int i5, int i6, int i7, int i8, Composer composer, int i9) {
        TicketSummaryView(str, iDepartureInfo, ticketCategory, transportation, transportationCargoInfo, list, passengerInfo, list2, list3, checkoutSeatReservation, iSummaryProduct, list4, priceDetails, priceTotal, price, str2, z5, function1, ticketSection, z6, list5, z7, z8, function0, function02, str3, list6, subline, str4, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), RecomposeScopeImplKt.updateChangedFlags(i6), RecomposeScopeImplKt.updateChangedFlags(i7), i8);
        return Unit.INSTANCE;
    }
}
