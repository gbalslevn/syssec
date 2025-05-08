package dk.molslinjen.ui.views.screens.booking.departures;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.core.Feature;
import dk.molslinjen.domain.extensions.ManagerResultExtensionsKt;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.route.RouteSelectedState;
import dk.molslinjen.domain.managers.route.RouteSharedSelectedState;
import dk.molslinjen.domain.managers.route.RouteState;
import dk.molslinjen.domain.model.booking.BookingType;
import dk.molslinjen.domain.model.booking.DepartureDirection;
import dk.molslinjen.domain.model.booking.PassengerInfo;
import dk.molslinjen.domain.model.booking.RouteDirection;
import dk.molslinjen.domain.model.booking.TransportProducts;
import dk.molslinjen.domain.model.booking.TransportationCargoInfo;
import dk.molslinjen.domain.model.booking.product.Product;
import dk.molslinjen.domain.model.booking.product.TrailerProduct;
import dk.molslinjen.domain.model.config.RouteDirectionGroup;
import dk.molslinjen.domain.model.config.Transportation;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.views.screens.booking.departures.DepartureFiltersViewKt;
import dk.molslinjen.ui.views.screens.booking.departures.selectPassengers.PassengerCountSelectedCardViewKt;
import dk.molslinjen.ui.views.screens.booking.departures.selectRoute.RouteSelectorViewKt;
import dk.molslinjen.ui.views.screens.booking.departures.selectTrailers.TrailerSelectorViewKt;
import dk.molslinjen.ui.views.screens.booking.departures.selectTransportation.TransportationSelectorViewKt;
import dk.molslinjen.ui.views.screens.booking.departures.selectTransportationProducts.TransportProductSelectedCardViewKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\u001aë\u0002\u0010*\u001a\u00020\u00192\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00122\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u00172\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u001b2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00190\u00172\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00190\u001b2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00190\u00172\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00190\u001b2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00190\u001b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00190\u001b2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00190\u001b2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00190\u001b2\b\b\u0002\u0010%\u001a\u00020\u00122\b\b\u0002\u0010&\u001a\u00020\u00122\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00190\u001b2\u0006\u0010(\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u0012H\u0007¢\u0006\u0004\b*\u0010+\u001a\u0097\u0001\u0010,\u001a\u00020\u00192\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0015\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00190\u001b2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00190\u001b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00190\u001b2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00190\u001bH\u0003¢\u0006\u0004\b,\u0010-\u001a\u000f\u0010.\u001a\u00020\u0019H\u0007¢\u0006\u0004\b.\u0010/¨\u00060"}, d2 = {"Ldk/molslinjen/domain/model/booking/BookingType;", "selectedBookingType", "Ldk/molslinjen/domain/model/booking/DepartureDirection;", "selectedDepartureDirection", "Ldk/molslinjen/domain/managers/route/RouteState;", "routeState", "Ldk/molslinjen/domain/model/booking/PassengerInfo;", "outboundPassengerInfo", "returnPassengerInfo", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/product/Product;", "outboundTransportProducts", "returnTransportProducts", "Ldk/molslinjen/domain/managers/route/RouteSharedSelectedState;", "routeSharedSelectedState", "Ldk/molslinjen/domain/managers/route/RouteSelectedState;", "outboundRouteSelectedState", "returnRouteSelectedState", BuildConfig.FLAVOR, "outboundDepartureSelected", "returnDepartureSelected", "isAddingReturnFromBookingSummary", "isEditing", "Lkotlin/Function1;", "Ldk/molslinjen/domain/model/booking/RouteDirection;", BuildConfig.FLAVOR, "showRouteSelector", "Lkotlin/Function0;", "showTransportationSelector", "updateBookingType", "flipDirection", "updateDepartureDirection", "showPassengerCountSelector", "showTrailerSelector", "showTransportProductsSelector", "removeSelectedTrailer", "removeAllSelectedTransportProducts", "disabledPossibilityToAddReturnTrip", "onlyOneMultiRideChargeBack", "onTripTypeDisabledClick", "splitTestMoveReturnTripSelector", "splitTestShowRouteSwitchWithText", "DepartureFiltersView", "(Ldk/molslinjen/domain/model/booking/BookingType;Ldk/molslinjen/domain/model/booking/DepartureDirection;Ldk/molslinjen/domain/managers/route/RouteState;Ldk/molslinjen/domain/model/booking/PassengerInfo;Ldk/molslinjen/domain/model/booking/PassengerInfo;Ljava/util/List;Ljava/util/List;Ldk/molslinjen/domain/managers/route/RouteSharedSelectedState;Ldk/molslinjen/domain/managers/route/RouteSelectedState;Ldk/molslinjen/domain/managers/route/RouteSelectedState;ZZZZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;ZZLkotlin/jvm/functions/Function0;ZZLandroidx/compose/runtime/Composer;IIII)V", "ProductsSelectors", "(Ldk/molslinjen/domain/managers/route/RouteSharedSelectedState;Ldk/molslinjen/domain/managers/route/RouteSelectedState;ZLdk/molslinjen/domain/managers/route/RouteSelectedState;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Ldk/molslinjen/domain/managers/route/RouteState;Ljava/util/List;Ljava/util/List;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "FiltersOverscrollBackground", "(Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class DepartureFiltersViewKt {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DepartureDirection.values().length];
            try {
                iArr[DepartureDirection.Outbound.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DepartureDirection.Return.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0391  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x03aa  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x03c9  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0817  */
    /* JADX WARN: Removed duplicated region for block: B:118:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x03f0  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x03f7  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0402  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0434  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0440  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0463  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x052f  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x053b  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x055e  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x058e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x06ff  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0707  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x070c  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0722 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0738  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0741  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x07c9 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:218:0x080c  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0709  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0704  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x06f2  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x053f  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0444  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x040d  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x03fa  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x03f3  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x03af  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0396  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x037b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x0362  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x0346  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x032b  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x0314  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x02fb  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x02bd  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:322:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:329:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:336:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:343:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:351:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:359:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:366:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:374:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:382:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:389:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:396:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:403:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:410:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:417:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x02ba  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x02d1  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0328  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0341  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x035d  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0376  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void DepartureFiltersView(final BookingType selectedBookingType, final DepartureDirection selectedDepartureDirection, final RouteState routeState, final PassengerInfo passengerInfo, final PassengerInfo passengerInfo2, final List<? extends Product> list, final List<? extends Product> list2, final RouteSharedSelectedState routeSharedSelectedState, final RouteSelectedState routeSelectedState, final RouteSelectedState routeSelectedState2, final boolean z5, final boolean z6, final boolean z7, final boolean z8, final Function1<? super RouteDirection, Unit> showRouteSelector, final Function0<Unit> showTransportationSelector, final Function1<? super BookingType, Unit> updateBookingType, final Function0<Unit> flipDirection, final Function1<? super DepartureDirection, Unit> updateDepartureDirection, final Function0<Unit> showPassengerCountSelector, final Function0<Unit> showTrailerSelector, final Function0<Unit> showTransportProductsSelector, final Function0<Unit> removeSelectedTrailer, final Function0<Unit> removeAllSelectedTransportProducts, boolean z9, boolean z10, final Function0<Unit> onTripTypeDisabledClick, final boolean z11, final boolean z12, Composer composer, final int i5, final int i6, final int i7, final int i8) {
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        boolean z13;
        final boolean z14;
        int i17;
        int currentCompositeKeyHash;
        Composer m1226constructorimpl;
        int currentCompositeKeyHash2;
        Composer m1226constructorimpl2;
        int i18;
        Modifier.Companion companion;
        float f5;
        int i19;
        Composer composer2;
        final boolean z15;
        Transportation selectedTransportation;
        final Function0<Unit> function0;
        Function1<? super RouteDirection, Unit> function1;
        RouteSelectedState routeSelectedState3;
        Function0<Unit> function02;
        TransportationCargoInfo transportationCargoInfo;
        Double totalWeight;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(selectedBookingType, "selectedBookingType");
        Intrinsics.checkNotNullParameter(selectedDepartureDirection, "selectedDepartureDirection");
        Intrinsics.checkNotNullParameter(showRouteSelector, "showRouteSelector");
        Intrinsics.checkNotNullParameter(showTransportationSelector, "showTransportationSelector");
        Intrinsics.checkNotNullParameter(updateBookingType, "updateBookingType");
        Intrinsics.checkNotNullParameter(flipDirection, "flipDirection");
        Intrinsics.checkNotNullParameter(updateDepartureDirection, "updateDepartureDirection");
        Intrinsics.checkNotNullParameter(showPassengerCountSelector, "showPassengerCountSelector");
        Intrinsics.checkNotNullParameter(showTrailerSelector, "showTrailerSelector");
        Intrinsics.checkNotNullParameter(showTransportProductsSelector, "showTransportProductsSelector");
        Intrinsics.checkNotNullParameter(removeSelectedTrailer, "removeSelectedTrailer");
        Intrinsics.checkNotNullParameter(removeAllSelectedTransportProducts, "removeAllSelectedTransportProducts");
        Intrinsics.checkNotNullParameter(onTripTypeDisabledClick, "onTripTypeDisabledClick");
        Composer startRestartGroup = composer.startRestartGroup(-138180396);
        if ((i8 & 1) != 0) {
            i9 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i9 = i5 | (startRestartGroup.changed(selectedBookingType) ? 4 : 2);
        } else {
            i9 = i5;
        }
        if ((i8 & 2) != 0) {
            i9 |= 48;
        } else if ((i5 & 48) == 0) {
            i9 |= startRestartGroup.changed(selectedDepartureDirection) ? 32 : 16;
        }
        int i20 = i9;
        if ((i8 & 4) != 0) {
            i20 |= 384;
        } else if ((i5 & 384) == 0) {
            i20 |= startRestartGroup.changedInstance(routeState) ? 256 : 128;
            if ((i8 & 8) == 0) {
                i20 |= 3072;
            } else if ((i5 & 3072) == 0) {
                i20 |= startRestartGroup.changedInstance(passengerInfo) ? 2048 : 1024;
                if ((i8 & 16) != 0) {
                    i20 |= 24576;
                } else if ((i5 & 24576) == 0) {
                    i20 |= startRestartGroup.changedInstance(passengerInfo2) ? 16384 : 8192;
                    if ((i8 & 32) == 0) {
                        i20 |= 196608;
                    } else if ((i5 & 196608) == 0) {
                        i20 |= startRestartGroup.changedInstance(list) ? 131072 : 65536;
                    }
                    if ((i8 & 64) == 0) {
                        i20 |= 1572864;
                    } else if ((i5 & 1572864) == 0) {
                        i20 |= startRestartGroup.changedInstance(list2) ? 1048576 : 524288;
                    }
                    if ((i8 & 128) == 0) {
                        i20 |= 12582912;
                    } else if ((i5 & 12582912) == 0) {
                        i20 |= startRestartGroup.changedInstance(routeSharedSelectedState) ? 8388608 : 4194304;
                        if ((i8 & 256) != 0) {
                            i20 |= 100663296;
                        } else if ((i5 & 100663296) == 0) {
                            i20 |= startRestartGroup.changedInstance(routeSelectedState) ? 67108864 : 33554432;
                            if ((i8 & 512) == 0) {
                                i20 |= 805306368;
                            } else if ((i5 & 805306368) == 0) {
                                i20 |= startRestartGroup.changedInstance(routeSelectedState2) ? 536870912 : 268435456;
                            }
                            if ((i8 & 1024) == 0) {
                                i10 = i6;
                                i11 = i10 | 6;
                            } else {
                                i10 = i6;
                                if ((i10 & 6) == 0) {
                                    i11 = i10 | (startRestartGroup.changed(z5) ? 4 : 2);
                                } else {
                                    i11 = i10;
                                }
                            }
                            if ((i8 & 2048) == 0) {
                                i11 |= 48;
                            } else if ((i10 & 48) == 0) {
                                i11 |= startRestartGroup.changed(z6) ? 32 : 16;
                                int i21 = i11;
                                if ((i8 & 4096) != 0) {
                                    i21 |= 384;
                                } else if ((i10 & 384) == 0) {
                                    i21 |= startRestartGroup.changed(z7) ? 256 : 128;
                                }
                                i12 = i20;
                                if ((i8 & 8192) != 0) {
                                    i21 |= 3072;
                                } else if ((i10 & 3072) == 0) {
                                    i21 |= startRestartGroup.changed(z8) ? 2048 : 1024;
                                }
                                if ((i8 & 16384) != 0) {
                                    i21 |= 24576;
                                } else if ((i10 & 24576) == 0) {
                                    i21 |= startRestartGroup.changedInstance(showRouteSelector) ? 16384 : 8192;
                                }
                                if ((32768 & i8) != 0) {
                                    i21 |= 196608;
                                } else if ((i10 & 196608) == 0) {
                                    i21 |= startRestartGroup.changedInstance(showTransportationSelector) ? 131072 : 65536;
                                }
                                if ((i8 & 65536) != 0) {
                                    i21 |= 1572864;
                                } else if ((i10 & 1572864) == 0) {
                                    i21 |= startRestartGroup.changedInstance(updateBookingType) ? 1048576 : 524288;
                                }
                                if ((i8 & 131072) != 0) {
                                    i21 |= 12582912;
                                } else if ((i10 & 12582912) == 0) {
                                    i21 |= startRestartGroup.changedInstance(flipDirection) ? 8388608 : 4194304;
                                }
                                if ((262144 & i8) != 0) {
                                    i21 |= 100663296;
                                } else if ((i10 & 100663296) == 0) {
                                    i21 |= startRestartGroup.changedInstance(updateDepartureDirection) ? 67108864 : 33554432;
                                }
                                if ((i8 & 524288) != 0) {
                                    i21 |= 805306368;
                                } else if ((i10 & 805306368) == 0) {
                                    i21 |= startRestartGroup.changedInstance(showPassengerCountSelector) ? 536870912 : 268435456;
                                }
                                if ((i8 & 1048576) != 0) {
                                    i13 = i7;
                                    i14 = i13 | 6;
                                } else {
                                    i13 = i7;
                                    if ((i13 & 6) == 0) {
                                        i14 = i13 | (startRestartGroup.changedInstance(showTrailerSelector) ? 4 : 2);
                                    } else {
                                        i14 = i13;
                                    }
                                }
                                if ((i8 & 2097152) != 0) {
                                    i14 |= 48;
                                } else if ((i13 & 48) == 0) {
                                    i14 |= startRestartGroup.changedInstance(showTransportProductsSelector) ? 32 : 16;
                                }
                                int i22 = i14;
                                if ((i8 & 4194304) != 0) {
                                    i22 |= 384;
                                } else if ((i13 & 384) == 0) {
                                    i22 |= startRestartGroup.changedInstance(removeSelectedTrailer) ? 256 : 128;
                                }
                                if ((i8 & 8388608) != 0) {
                                    i22 |= 3072;
                                } else if ((i13 & 3072) == 0) {
                                    i22 |= startRestartGroup.changedInstance(removeAllSelectedTransportProducts) ? 2048 : 1024;
                                }
                                i15 = 16777216 & i8;
                                if (i15 != 0) {
                                    i22 |= 24576;
                                } else if ((i13 & 24576) == 0) {
                                    i22 |= startRestartGroup.changed(z9) ? 16384 : 8192;
                                    i16 = i8 & 33554432;
                                    if (i16 == 0) {
                                        i22 |= 196608;
                                    } else if ((i13 & 196608) == 0) {
                                        i22 |= startRestartGroup.changed(z10) ? 131072 : 65536;
                                    }
                                    if ((i8 & 67108864) == 0) {
                                        i22 |= 1572864;
                                    } else if ((i13 & 1572864) == 0) {
                                        i22 |= startRestartGroup.changedInstance(onTripTypeDisabledClick) ? 1048576 : 524288;
                                    }
                                    if ((i8 & 134217728) == 0) {
                                        i22 |= 12582912;
                                        z13 = z11;
                                    } else {
                                        z13 = z11;
                                        if ((i13 & 12582912) == 0) {
                                            i22 |= startRestartGroup.changed(z13) ? 8388608 : 4194304;
                                        }
                                    }
                                    if ((i8 & 268435456) == 0) {
                                        i22 |= 100663296;
                                    } else if ((i13 & 100663296) == 0) {
                                        i22 |= startRestartGroup.changed(z12) ? 67108864 : 33554432;
                                    }
                                    if ((i12 & 306783379) != 306783378 && (306783379 & i21) == 306783378 && (38347923 & i22) == 38347922 && startRestartGroup.getSkipping()) {
                                        startRestartGroup.skipToGroupEnd();
                                        z15 = z9;
                                        z14 = z10;
                                        composer2 = startRestartGroup;
                                    } else {
                                        boolean z16 = i15 == 0 ? false : z9;
                                        z14 = i16 == 0 ? false : z10;
                                        if (ComposerKt.isTraceInProgress()) {
                                            i17 = i12;
                                        } else {
                                            i17 = i12;
                                            ComposerKt.traceEventStart(-138180396, i17, i21, "dk.molslinjen.ui.views.screens.booking.departures.DepartureFiltersView (DepartureFiltersView.kt:66)");
                                        }
                                        Modifier.Companion companion2 = Modifier.INSTANCE;
                                        Alignment.Companion companion3 = Alignment.INSTANCE;
                                        MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getTopStart(), false);
                                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                                        CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                                        Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, companion2);
                                        ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
                                        Function0<ComposeUiNode> constructor = companion4.getConstructor();
                                        if (startRestartGroup.getApplier() == null) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        startRestartGroup.startReusableNode();
                                        if (startRestartGroup.getInserting()) {
                                            startRestartGroup.useNode();
                                        } else {
                                            startRestartGroup.createNode(constructor);
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
                                        FiltersOverscrollBackground(startRestartGroup, 0);
                                        float f6 = 16;
                                        Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(BackgroundKt.background$default(companion2, Brush.Companion.m1466verticalGradient8A3gB4$default(Brush.INSTANCE, new Pair[]{TuplesKt.to(Float.valueOf(0.0f), Color.m1481boximpl(AppColor.INSTANCE.m3259getBrandDarkBlue10d7_KjU())), TuplesKt.to(Float.valueOf(0.44f), Color.m1481boximpl(ColorKt.Color(4280040641L))), TuplesKt.to(Float.valueOf(1.0f), Color.m1481boximpl(ColorKt.Color(4279713462L)))}, 0.0f, 0.0f, 0, 14, (Object) null), null, 0.0f, 6, null), 0.0f, 1, null), Dp.m2599constructorimpl(f6), 0.0f, Dp.m2599constructorimpl(f6), 0.0f, 10, null);
                                        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), companion3.getStart(), startRestartGroup, 0);
                                        currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                                        CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                                        Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m315paddingqDBjuR0$default);
                                        Function0<ComposeUiNode> constructor2 = companion4.getConstructor();
                                        if (startRestartGroup.getApplier() == null) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        startRestartGroup.startReusableNode();
                                        if (startRestartGroup.getInserting()) {
                                            startRestartGroup.useNode();
                                        } else {
                                            startRestartGroup.createNode(constructor2);
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
                                        startRestartGroup.startReplaceGroup(1418583381);
                                        if (z7) {
                                            startRestartGroup.startReplaceGroup(1418583220);
                                            if (z13 || z8 || z16) {
                                                function0 = flipDirection;
                                                i18 = i17;
                                                companion = companion2;
                                                f5 = f6;
                                            } else {
                                                i18 = i17;
                                                companion = companion2;
                                                function0 = flipDirection;
                                                f5 = f6;
                                                DepartureTripTypeTabsKt.DepartureTripTypeTabs(PaddingKt.m315paddingqDBjuR0$default(companion2, 0.0f, Dp.m2599constructorimpl(f6), 0.0f, 0.0f, 13, null), selectedBookingType, !z14, onTripTypeDisabledClick, updateBookingType, startRestartGroup, ((i17 << 3) & 112) | 6 | ((i22 >> 9) & 7168) | ((i21 >> 6) & 57344), 0);
                                            }
                                            startRestartGroup.endReplaceGroup();
                                            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(24)), startRestartGroup, 6);
                                            RouteDirectionGroup selectedRouteDirectionGroup = routeSelectedState != null ? routeSelectedState.getSelectedRouteDirectionGroup() : null;
                                            startRestartGroup.startReplaceGroup(1418610237);
                                            if (z8) {
                                                startRestartGroup.startReplaceGroup(1418610679);
                                                boolean z17 = (29360128 & i21) == 8388608;
                                                Object rememberedValue = startRestartGroup.rememberedValue();
                                                if (z17 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                                    rememberedValue = new Function1() { // from class: J2.h
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Object invoke(Object obj) {
                                                            Unit DepartureFiltersView$lambda$3$lambda$2$lambda$1$lambda$0;
                                                            DepartureFiltersView$lambda$3$lambda$2$lambda$1$lambda$0 = DepartureFiltersViewKt.DepartureFiltersView$lambda$3$lambda$2$lambda$1$lambda$0(Function0.this, (RouteDirection) obj);
                                                            return DepartureFiltersView$lambda$3$lambda$2$lambda$1$lambda$0;
                                                        }
                                                    };
                                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                                }
                                                function1 = (Function1) rememberedValue;
                                                startRestartGroup.endReplaceGroup();
                                            } else {
                                                function1 = showRouteSelector;
                                            }
                                            startRestartGroup.endReplaceGroup();
                                            RouteSelectorViewKt.RouteSelectorView(selectedRouteDirectionGroup, routeSharedSelectedState != null ? routeSharedSelectedState.getLineLogoUrl() : null, function1, flipDirection, z12, startRestartGroup, ((i21 >> 12) & 7168) | ((i22 >> 12) & 57344));
                                            startRestartGroup.startReplaceGroup(1418620435);
                                            if (z11 && !z8 && !z16) {
                                                DepartureTripTypeTabsKt.DepartureTripTypeTabs(PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, Dp.m2599constructorimpl(f5), 0.0f, 0.0f, 13, null), selectedBookingType, !z14, onTripTypeDisabledClick, updateBookingType, startRestartGroup, ((i18 << 3) & 112) | 6 | ((i22 >> 9) & 7168) | ((i21 >> 6) & 57344), 0);
                                            }
                                            startRestartGroup.endReplaceGroup();
                                            if (!Feature.OnlyWalkingPassengers.isEnabled()) {
                                                SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f5)), startRestartGroup, 6);
                                                Transportation selectedTransportation2 = routeSharedSelectedState != null ? routeSharedSelectedState.getSelectedTransportation() : null;
                                                int i23 = WhenMappings.$EnumSwitchMapping$0[selectedDepartureDirection.ordinal()];
                                                if (i23 == 1) {
                                                    routeSelectedState3 = routeSelectedState;
                                                } else {
                                                    if (i23 != 2) {
                                                        throw new NoWhenBranchMatchedException();
                                                    }
                                                    routeSelectedState3 = routeSelectedState2;
                                                }
                                                Integer valueOf = (routeSelectedState3 == null || (transportationCargoInfo = routeSelectedState3.getTransportationCargoInfo()) == null || (totalWeight = transportationCargoInfo.getTotalWeight()) == null) ? null : Integer.valueOf((int) totalWeight.doubleValue());
                                                if (z8) {
                                                    i19 = 0;
                                                    function02 = null;
                                                } else {
                                                    function02 = showTransportationSelector;
                                                    i19 = 0;
                                                }
                                                TransportationSelectorViewKt.TransportationSelectorView(selectedTransportation2, valueOf, function02, startRestartGroup, i19);
                                                startRestartGroup.endReplaceGroup();
                                                int i24 = (routeSharedSelectedState != null ? routeSharedSelectedState.getCommuterBookingData() : null) != null ? 1 : i19;
                                                if (routeSharedSelectedState != null && (selectedTransportation = routeSharedSelectedState.getSelectedTransportation()) != null && selectedTransportation.isWalking()) {
                                                    i19 = 1;
                                                }
                                                startRestartGroup.startReplaceGroup(1418671541);
                                                if (i19 != 0 && i24 == 0) {
                                                    SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f5)), startRestartGroup, 6);
                                                    PassengerCountSelectedCardViewKt.PassengerCountSelectedCardView(passengerInfo, passengerInfo2, z7, showPassengerCountSelector, !Feature.OnlyWalkingPassengers.isEnabled() ? Integer.valueOf(R.drawable.icon_walking) : null, startRestartGroup, ((i18 >> 9) & 126) | (i21 & 896) | ((i21 >> 18) & 7168), 0);
                                                }
                                                startRestartGroup.endReplaceGroup();
                                                int i25 = i18 << 6;
                                                int i26 = i18;
                                                ProductsSelectors(routeSharedSelectedState, routeSelectedState, z7, routeSelectedState2, showTrailerSelector, removeSelectedTrailer, routeState, list, list2, showTransportProductsSelector, removeAllSelectedTransportProducts, startRestartGroup, ((i18 >> 21) & 126) | (i21 & 896) | ((i18 >> 18) & 7168) | ((i22 << 12) & 57344) | ((i22 << 9) & 458752) | ((i18 << 12) & 3670016) | (29360128 & i25) | (i25 & 234881024) | ((i22 << 24) & 1879048192), (i22 >> 9) & 14);
                                                SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f5)), startRestartGroup, 6);
                                                startRestartGroup.startReplaceGroup(1418717696);
                                                if (selectedBookingType == BookingType.TwoWay || z7) {
                                                    composer2 = startRestartGroup;
                                                } else {
                                                    SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(8)), startRestartGroup, 6);
                                                    int i27 = i21 << 6;
                                                    int i28 = (i26 & 112) | (i27 & 896) | (i27 & 7168) | ((i21 >> 12) & 57344);
                                                    composer2 = startRestartGroup;
                                                    DepartureDirectionTabsKt.DepartureDirectionTabs(null, selectedDepartureDirection, z5, z6, updateDepartureDirection, startRestartGroup, i28, 1);
                                                }
                                                composer2.endReplaceGroup();
                                                composer2.endNode();
                                                composer2.endNode();
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                                z15 = z16;
                                            }
                                        } else {
                                            i18 = i17;
                                            companion = companion2;
                                            f5 = f6;
                                        }
                                        i19 = 0;
                                        startRestartGroup.endReplaceGroup();
                                        if ((routeSharedSelectedState != null ? routeSharedSelectedState.getCommuterBookingData() : null) != null) {
                                        }
                                        if (routeSharedSelectedState != null) {
                                            i19 = 1;
                                        }
                                        startRestartGroup.startReplaceGroup(1418671541);
                                        if (i19 != 0) {
                                            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f5)), startRestartGroup, 6);
                                            PassengerCountSelectedCardViewKt.PassengerCountSelectedCardView(passengerInfo, passengerInfo2, z7, showPassengerCountSelector, !Feature.OnlyWalkingPassengers.isEnabled() ? Integer.valueOf(R.drawable.icon_walking) : null, startRestartGroup, ((i18 >> 9) & 126) | (i21 & 896) | ((i21 >> 18) & 7168), 0);
                                        }
                                        startRestartGroup.endReplaceGroup();
                                        int i252 = i18 << 6;
                                        int i262 = i18;
                                        ProductsSelectors(routeSharedSelectedState, routeSelectedState, z7, routeSelectedState2, showTrailerSelector, removeSelectedTrailer, routeState, list, list2, showTransportProductsSelector, removeAllSelectedTransportProducts, startRestartGroup, ((i18 >> 21) & 126) | (i21 & 896) | ((i18 >> 18) & 7168) | ((i22 << 12) & 57344) | ((i22 << 9) & 458752) | ((i18 << 12) & 3670016) | (29360128 & i252) | (i252 & 234881024) | ((i22 << 24) & 1879048192), (i22 >> 9) & 14);
                                        SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f5)), startRestartGroup, 6);
                                        startRestartGroup.startReplaceGroup(1418717696);
                                        if (selectedBookingType == BookingType.TwoWay) {
                                        }
                                        composer2 = startRestartGroup;
                                        composer2.endReplaceGroup();
                                        composer2.endNode();
                                        composer2.endNode();
                                        if (ComposerKt.isTraceInProgress()) {
                                        }
                                        z15 = z16;
                                    }
                                    endRestartGroup = composer2.endRestartGroup();
                                    if (endRestartGroup == null) {
                                        endRestartGroup.updateScope(new Function2() { // from class: J2.i
                                            @Override // kotlin.jvm.functions.Function2
                                            public final Object invoke(Object obj, Object obj2) {
                                                Unit DepartureFiltersView$lambda$4;
                                                DepartureFiltersView$lambda$4 = DepartureFiltersViewKt.DepartureFiltersView$lambda$4(BookingType.this, selectedDepartureDirection, routeState, passengerInfo, passengerInfo2, list, list2, routeSharedSelectedState, routeSelectedState, routeSelectedState2, z5, z6, z7, z8, showRouteSelector, showTransportationSelector, updateBookingType, flipDirection, updateDepartureDirection, showPassengerCountSelector, showTrailerSelector, showTransportProductsSelector, removeSelectedTrailer, removeAllSelectedTransportProducts, z15, z14, onTripTypeDisabledClick, z11, z12, i5, i6, i7, i8, (Composer) obj, ((Integer) obj2).intValue());
                                                return DepartureFiltersView$lambda$4;
                                            }
                                        });
                                        return;
                                    }
                                    return;
                                }
                                i16 = i8 & 33554432;
                                if (i16 == 0) {
                                }
                                if ((i8 & 67108864) == 0) {
                                }
                                if ((i8 & 134217728) == 0) {
                                }
                                if ((i8 & 268435456) == 0) {
                                }
                                if ((i12 & 306783379) != 306783378) {
                                }
                                if (i15 == 0) {
                                }
                                if (i16 == 0) {
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                Modifier.Companion companion22 = Modifier.INSTANCE;
                                Alignment.Companion companion32 = Alignment.INSTANCE;
                                MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion32.getTopStart(), false);
                                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                                CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
                                Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, companion22);
                                ComposeUiNode.Companion companion42 = ComposeUiNode.INSTANCE;
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
                                FiltersOverscrollBackground(startRestartGroup, 0);
                                float f62 = 16;
                                Modifier m315paddingqDBjuR0$default2 = PaddingKt.m315paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(BackgroundKt.background$default(companion22, Brush.Companion.m1466verticalGradient8A3gB4$default(Brush.INSTANCE, new Pair[]{TuplesKt.to(Float.valueOf(0.0f), Color.m1481boximpl(AppColor.INSTANCE.m3259getBrandDarkBlue10d7_KjU())), TuplesKt.to(Float.valueOf(0.44f), Color.m1481boximpl(ColorKt.Color(4280040641L))), TuplesKt.to(Float.valueOf(1.0f), Color.m1481boximpl(ColorKt.Color(4279713462L)))}, 0.0f, 0.0f, 0, 14, (Object) null), null, 0.0f, 6, null), 0.0f, 1, null), Dp.m2599constructorimpl(f62), 0.0f, Dp.m2599constructorimpl(f62), 0.0f, 10, null);
                                MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), companion32.getStart(), startRestartGroup, 0);
                                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                                CompositionLocalMap currentCompositionLocalMap22 = startRestartGroup.getCurrentCompositionLocalMap();
                                Modifier materializeModifier22 = ComposedModifierKt.materializeModifier(startRestartGroup, m315paddingqDBjuR0$default2);
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
                                startRestartGroup.startReplaceGroup(1418583381);
                                if (z7) {
                                }
                                i19 = 0;
                                startRestartGroup.endReplaceGroup();
                                if ((routeSharedSelectedState != null ? routeSharedSelectedState.getCommuterBookingData() : null) != null) {
                                }
                                if (routeSharedSelectedState != null) {
                                }
                                startRestartGroup.startReplaceGroup(1418671541);
                                if (i19 != 0) {
                                }
                                startRestartGroup.endReplaceGroup();
                                int i2522 = i18 << 6;
                                int i2622 = i18;
                                ProductsSelectors(routeSharedSelectedState, routeSelectedState, z7, routeSelectedState2, showTrailerSelector, removeSelectedTrailer, routeState, list, list2, showTransportProductsSelector, removeAllSelectedTransportProducts, startRestartGroup, ((i18 >> 21) & 126) | (i21 & 896) | ((i18 >> 18) & 7168) | ((i22 << 12) & 57344) | ((i22 << 9) & 458752) | ((i18 << 12) & 3670016) | (29360128 & i2522) | (i2522 & 234881024) | ((i22 << 24) & 1879048192), (i22 >> 9) & 14);
                                SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f5)), startRestartGroup, 6);
                                startRestartGroup.startReplaceGroup(1418717696);
                                if (selectedBookingType == BookingType.TwoWay) {
                                }
                                composer2 = startRestartGroup;
                                composer2.endReplaceGroup();
                                composer2.endNode();
                                composer2.endNode();
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                z15 = z16;
                                endRestartGroup = composer2.endRestartGroup();
                                if (endRestartGroup == null) {
                                }
                            }
                            int i212 = i11;
                            if ((i8 & 4096) != 0) {
                            }
                            i12 = i20;
                            if ((i8 & 8192) != 0) {
                            }
                            if ((i8 & 16384) != 0) {
                            }
                            if ((32768 & i8) != 0) {
                            }
                            if ((i8 & 65536) != 0) {
                            }
                            if ((i8 & 131072) != 0) {
                            }
                            if ((262144 & i8) != 0) {
                            }
                            if ((i8 & 524288) != 0) {
                            }
                            if ((i8 & 1048576) != 0) {
                            }
                            if ((i8 & 2097152) != 0) {
                            }
                            int i222 = i14;
                            if ((i8 & 4194304) != 0) {
                            }
                            if ((i8 & 8388608) != 0) {
                            }
                            i15 = 16777216 & i8;
                            if (i15 != 0) {
                            }
                            i16 = i8 & 33554432;
                            if (i16 == 0) {
                            }
                            if ((i8 & 67108864) == 0) {
                            }
                            if ((i8 & 134217728) == 0) {
                            }
                            if ((i8 & 268435456) == 0) {
                            }
                            if ((i12 & 306783379) != 306783378) {
                            }
                            if (i15 == 0) {
                            }
                            if (i16 == 0) {
                            }
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            Modifier.Companion companion222 = Modifier.INSTANCE;
                            Alignment.Companion companion322 = Alignment.INSTANCE;
                            MeasurePolicy maybeCachedBoxMeasurePolicy22 = BoxKt.maybeCachedBoxMeasurePolicy(companion322.getTopStart(), false);
                            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                            CompositionLocalMap currentCompositionLocalMap32 = startRestartGroup.getCurrentCompositionLocalMap();
                            Modifier materializeModifier32 = ComposedModifierKt.materializeModifier(startRestartGroup, companion222);
                            ComposeUiNode.Companion companion422 = ComposeUiNode.INSTANCE;
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
                            FiltersOverscrollBackground(startRestartGroup, 0);
                            float f622 = 16;
                            Modifier m315paddingqDBjuR0$default22 = PaddingKt.m315paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(BackgroundKt.background$default(companion222, Brush.Companion.m1466verticalGradient8A3gB4$default(Brush.INSTANCE, new Pair[]{TuplesKt.to(Float.valueOf(0.0f), Color.m1481boximpl(AppColor.INSTANCE.m3259getBrandDarkBlue10d7_KjU())), TuplesKt.to(Float.valueOf(0.44f), Color.m1481boximpl(ColorKt.Color(4280040641L))), TuplesKt.to(Float.valueOf(1.0f), Color.m1481boximpl(ColorKt.Color(4279713462L)))}, 0.0f, 0.0f, 0, 14, (Object) null), null, 0.0f, 6, null), 0.0f, 1, null), Dp.m2599constructorimpl(f622), 0.0f, Dp.m2599constructorimpl(f622), 0.0f, 10, null);
                            MeasurePolicy columnMeasurePolicy22 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), companion322.getStart(), startRestartGroup, 0);
                            currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                            CompositionLocalMap currentCompositionLocalMap222 = startRestartGroup.getCurrentCompositionLocalMap();
                            Modifier materializeModifier222 = ComposedModifierKt.materializeModifier(startRestartGroup, m315paddingqDBjuR0$default22);
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
                            startRestartGroup.startReplaceGroup(1418583381);
                            if (z7) {
                            }
                            i19 = 0;
                            startRestartGroup.endReplaceGroup();
                            if ((routeSharedSelectedState != null ? routeSharedSelectedState.getCommuterBookingData() : null) != null) {
                            }
                            if (routeSharedSelectedState != null) {
                            }
                            startRestartGroup.startReplaceGroup(1418671541);
                            if (i19 != 0) {
                            }
                            startRestartGroup.endReplaceGroup();
                            int i25222 = i18 << 6;
                            int i26222 = i18;
                            ProductsSelectors(routeSharedSelectedState, routeSelectedState, z7, routeSelectedState2, showTrailerSelector, removeSelectedTrailer, routeState, list, list2, showTransportProductsSelector, removeAllSelectedTransportProducts, startRestartGroup, ((i18 >> 21) & 126) | (i212 & 896) | ((i18 >> 18) & 7168) | ((i222 << 12) & 57344) | ((i222 << 9) & 458752) | ((i18 << 12) & 3670016) | (29360128 & i25222) | (i25222 & 234881024) | ((i222 << 24) & 1879048192), (i222 >> 9) & 14);
                            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f5)), startRestartGroup, 6);
                            startRestartGroup.startReplaceGroup(1418717696);
                            if (selectedBookingType == BookingType.TwoWay) {
                            }
                            composer2 = startRestartGroup;
                            composer2.endReplaceGroup();
                            composer2.endNode();
                            composer2.endNode();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            z15 = z16;
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup == null) {
                            }
                        }
                        if ((i8 & 512) == 0) {
                        }
                        if ((i8 & 1024) == 0) {
                        }
                        if ((i8 & 2048) == 0) {
                        }
                        int i2122 = i11;
                        if ((i8 & 4096) != 0) {
                        }
                        i12 = i20;
                        if ((i8 & 8192) != 0) {
                        }
                        if ((i8 & 16384) != 0) {
                        }
                        if ((32768 & i8) != 0) {
                        }
                        if ((i8 & 65536) != 0) {
                        }
                        if ((i8 & 131072) != 0) {
                        }
                        if ((262144 & i8) != 0) {
                        }
                        if ((i8 & 524288) != 0) {
                        }
                        if ((i8 & 1048576) != 0) {
                        }
                        if ((i8 & 2097152) != 0) {
                        }
                        int i2222 = i14;
                        if ((i8 & 4194304) != 0) {
                        }
                        if ((i8 & 8388608) != 0) {
                        }
                        i15 = 16777216 & i8;
                        if (i15 != 0) {
                        }
                        i16 = i8 & 33554432;
                        if (i16 == 0) {
                        }
                        if ((i8 & 67108864) == 0) {
                        }
                        if ((i8 & 134217728) == 0) {
                        }
                        if ((i8 & 268435456) == 0) {
                        }
                        if ((i12 & 306783379) != 306783378) {
                        }
                        if (i15 == 0) {
                        }
                        if (i16 == 0) {
                        }
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        Modifier.Companion companion2222 = Modifier.INSTANCE;
                        Alignment.Companion companion3222 = Alignment.INSTANCE;
                        MeasurePolicy maybeCachedBoxMeasurePolicy222 = BoxKt.maybeCachedBoxMeasurePolicy(companion3222.getTopStart(), false);
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap322 = startRestartGroup.getCurrentCompositionLocalMap();
                        Modifier materializeModifier322 = ComposedModifierKt.materializeModifier(startRestartGroup, companion2222);
                        ComposeUiNode.Companion companion4222 = ComposeUiNode.INSTANCE;
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
                        FiltersOverscrollBackground(startRestartGroup, 0);
                        float f6222 = 16;
                        Modifier m315paddingqDBjuR0$default222 = PaddingKt.m315paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(BackgroundKt.background$default(companion2222, Brush.Companion.m1466verticalGradient8A3gB4$default(Brush.INSTANCE, new Pair[]{TuplesKt.to(Float.valueOf(0.0f), Color.m1481boximpl(AppColor.INSTANCE.m3259getBrandDarkBlue10d7_KjU())), TuplesKt.to(Float.valueOf(0.44f), Color.m1481boximpl(ColorKt.Color(4280040641L))), TuplesKt.to(Float.valueOf(1.0f), Color.m1481boximpl(ColorKt.Color(4279713462L)))}, 0.0f, 0.0f, 0, 14, (Object) null), null, 0.0f, 6, null), 0.0f, 1, null), Dp.m2599constructorimpl(f6222), 0.0f, Dp.m2599constructorimpl(f6222), 0.0f, 10, null);
                        MeasurePolicy columnMeasurePolicy222 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), companion3222.getStart(), startRestartGroup, 0);
                        currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap2222 = startRestartGroup.getCurrentCompositionLocalMap();
                        Modifier materializeModifier2222 = ComposedModifierKt.materializeModifier(startRestartGroup, m315paddingqDBjuR0$default222);
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
                        startRestartGroup.startReplaceGroup(1418583381);
                        if (z7) {
                        }
                        i19 = 0;
                        startRestartGroup.endReplaceGroup();
                        if ((routeSharedSelectedState != null ? routeSharedSelectedState.getCommuterBookingData() : null) != null) {
                        }
                        if (routeSharedSelectedState != null) {
                        }
                        startRestartGroup.startReplaceGroup(1418671541);
                        if (i19 != 0) {
                        }
                        startRestartGroup.endReplaceGroup();
                        int i252222 = i18 << 6;
                        int i262222 = i18;
                        ProductsSelectors(routeSharedSelectedState, routeSelectedState, z7, routeSelectedState2, showTrailerSelector, removeSelectedTrailer, routeState, list, list2, showTransportProductsSelector, removeAllSelectedTransportProducts, startRestartGroup, ((i18 >> 21) & 126) | (i2122 & 896) | ((i18 >> 18) & 7168) | ((i2222 << 12) & 57344) | ((i2222 << 9) & 458752) | ((i18 << 12) & 3670016) | (29360128 & i252222) | (i252222 & 234881024) | ((i2222 << 24) & 1879048192), (i2222 >> 9) & 14);
                        SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f5)), startRestartGroup, 6);
                        startRestartGroup.startReplaceGroup(1418717696);
                        if (selectedBookingType == BookingType.TwoWay) {
                        }
                        composer2 = startRestartGroup;
                        composer2.endReplaceGroup();
                        composer2.endNode();
                        composer2.endNode();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        z15 = z16;
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    if ((i8 & 256) != 0) {
                    }
                    if ((i8 & 512) == 0) {
                    }
                    if ((i8 & 1024) == 0) {
                    }
                    if ((i8 & 2048) == 0) {
                    }
                    int i21222 = i11;
                    if ((i8 & 4096) != 0) {
                    }
                    i12 = i20;
                    if ((i8 & 8192) != 0) {
                    }
                    if ((i8 & 16384) != 0) {
                    }
                    if ((32768 & i8) != 0) {
                    }
                    if ((i8 & 65536) != 0) {
                    }
                    if ((i8 & 131072) != 0) {
                    }
                    if ((262144 & i8) != 0) {
                    }
                    if ((i8 & 524288) != 0) {
                    }
                    if ((i8 & 1048576) != 0) {
                    }
                    if ((i8 & 2097152) != 0) {
                    }
                    int i22222 = i14;
                    if ((i8 & 4194304) != 0) {
                    }
                    if ((i8 & 8388608) != 0) {
                    }
                    i15 = 16777216 & i8;
                    if (i15 != 0) {
                    }
                    i16 = i8 & 33554432;
                    if (i16 == 0) {
                    }
                    if ((i8 & 67108864) == 0) {
                    }
                    if ((i8 & 134217728) == 0) {
                    }
                    if ((i8 & 268435456) == 0) {
                    }
                    if ((i12 & 306783379) != 306783378) {
                    }
                    if (i15 == 0) {
                    }
                    if (i16 == 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    Modifier.Companion companion22222 = Modifier.INSTANCE;
                    Alignment.Companion companion32222 = Alignment.INSTANCE;
                    MeasurePolicy maybeCachedBoxMeasurePolicy2222 = BoxKt.maybeCachedBoxMeasurePolicy(companion32222.getTopStart(), false);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap3222 = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier materializeModifier3222 = ComposedModifierKt.materializeModifier(startRestartGroup, companion22222);
                    ComposeUiNode.Companion companion42222 = ComposeUiNode.INSTANCE;
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
                    FiltersOverscrollBackground(startRestartGroup, 0);
                    float f62222 = 16;
                    Modifier m315paddingqDBjuR0$default2222 = PaddingKt.m315paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(BackgroundKt.background$default(companion22222, Brush.Companion.m1466verticalGradient8A3gB4$default(Brush.INSTANCE, new Pair[]{TuplesKt.to(Float.valueOf(0.0f), Color.m1481boximpl(AppColor.INSTANCE.m3259getBrandDarkBlue10d7_KjU())), TuplesKt.to(Float.valueOf(0.44f), Color.m1481boximpl(ColorKt.Color(4280040641L))), TuplesKt.to(Float.valueOf(1.0f), Color.m1481boximpl(ColorKt.Color(4279713462L)))}, 0.0f, 0.0f, 0, 14, (Object) null), null, 0.0f, 6, null), 0.0f, 1, null), Dp.m2599constructorimpl(f62222), 0.0f, Dp.m2599constructorimpl(f62222), 0.0f, 10, null);
                    MeasurePolicy columnMeasurePolicy2222 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), companion32222.getStart(), startRestartGroup, 0);
                    currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap22222 = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier materializeModifier22222 = ComposedModifierKt.materializeModifier(startRestartGroup, m315paddingqDBjuR0$default2222);
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
                    startRestartGroup.startReplaceGroup(1418583381);
                    if (z7) {
                    }
                    i19 = 0;
                    startRestartGroup.endReplaceGroup();
                    if ((routeSharedSelectedState != null ? routeSharedSelectedState.getCommuterBookingData() : null) != null) {
                    }
                    if (routeSharedSelectedState != null) {
                    }
                    startRestartGroup.startReplaceGroup(1418671541);
                    if (i19 != 0) {
                    }
                    startRestartGroup.endReplaceGroup();
                    int i2522222 = i18 << 6;
                    int i2622222 = i18;
                    ProductsSelectors(routeSharedSelectedState, routeSelectedState, z7, routeSelectedState2, showTrailerSelector, removeSelectedTrailer, routeState, list, list2, showTransportProductsSelector, removeAllSelectedTransportProducts, startRestartGroup, ((i18 >> 21) & 126) | (i21222 & 896) | ((i18 >> 18) & 7168) | ((i22222 << 12) & 57344) | ((i22222 << 9) & 458752) | ((i18 << 12) & 3670016) | (29360128 & i2522222) | (i2522222 & 234881024) | ((i22222 << 24) & 1879048192), (i22222 >> 9) & 14);
                    SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f5)), startRestartGroup, 6);
                    startRestartGroup.startReplaceGroup(1418717696);
                    if (selectedBookingType == BookingType.TwoWay) {
                    }
                    composer2 = startRestartGroup;
                    composer2.endReplaceGroup();
                    composer2.endNode();
                    composer2.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    z15 = z16;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                if ((i8 & 32) == 0) {
                }
                if ((i8 & 64) == 0) {
                }
                if ((i8 & 128) == 0) {
                }
                if ((i8 & 256) != 0) {
                }
                if ((i8 & 512) == 0) {
                }
                if ((i8 & 1024) == 0) {
                }
                if ((i8 & 2048) == 0) {
                }
                int i212222 = i11;
                if ((i8 & 4096) != 0) {
                }
                i12 = i20;
                if ((i8 & 8192) != 0) {
                }
                if ((i8 & 16384) != 0) {
                }
                if ((32768 & i8) != 0) {
                }
                if ((i8 & 65536) != 0) {
                }
                if ((i8 & 131072) != 0) {
                }
                if ((262144 & i8) != 0) {
                }
                if ((i8 & 524288) != 0) {
                }
                if ((i8 & 1048576) != 0) {
                }
                if ((i8 & 2097152) != 0) {
                }
                int i222222 = i14;
                if ((i8 & 4194304) != 0) {
                }
                if ((i8 & 8388608) != 0) {
                }
                i15 = 16777216 & i8;
                if (i15 != 0) {
                }
                i16 = i8 & 33554432;
                if (i16 == 0) {
                }
                if ((i8 & 67108864) == 0) {
                }
                if ((i8 & 134217728) == 0) {
                }
                if ((i8 & 268435456) == 0) {
                }
                if ((i12 & 306783379) != 306783378) {
                }
                if (i15 == 0) {
                }
                if (i16 == 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                Modifier.Companion companion222222 = Modifier.INSTANCE;
                Alignment.Companion companion322222 = Alignment.INSTANCE;
                MeasurePolicy maybeCachedBoxMeasurePolicy22222 = BoxKt.maybeCachedBoxMeasurePolicy(companion322222.getTopStart(), false);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap32222 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier32222 = ComposedModifierKt.materializeModifier(startRestartGroup, companion222222);
                ComposeUiNode.Companion companion422222 = ComposeUiNode.INSTANCE;
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
                FiltersOverscrollBackground(startRestartGroup, 0);
                float f622222 = 16;
                Modifier m315paddingqDBjuR0$default22222 = PaddingKt.m315paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(BackgroundKt.background$default(companion222222, Brush.Companion.m1466verticalGradient8A3gB4$default(Brush.INSTANCE, new Pair[]{TuplesKt.to(Float.valueOf(0.0f), Color.m1481boximpl(AppColor.INSTANCE.m3259getBrandDarkBlue10d7_KjU())), TuplesKt.to(Float.valueOf(0.44f), Color.m1481boximpl(ColorKt.Color(4280040641L))), TuplesKt.to(Float.valueOf(1.0f), Color.m1481boximpl(ColorKt.Color(4279713462L)))}, 0.0f, 0.0f, 0, 14, (Object) null), null, 0.0f, 6, null), 0.0f, 1, null), Dp.m2599constructorimpl(f622222), 0.0f, Dp.m2599constructorimpl(f622222), 0.0f, 10, null);
                MeasurePolicy columnMeasurePolicy22222 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), companion322222.getStart(), startRestartGroup, 0);
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap222222 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier222222 = ComposedModifierKt.materializeModifier(startRestartGroup, m315paddingqDBjuR0$default22222);
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
                startRestartGroup.startReplaceGroup(1418583381);
                if (z7) {
                }
                i19 = 0;
                startRestartGroup.endReplaceGroup();
                if ((routeSharedSelectedState != null ? routeSharedSelectedState.getCommuterBookingData() : null) != null) {
                }
                if (routeSharedSelectedState != null) {
                }
                startRestartGroup.startReplaceGroup(1418671541);
                if (i19 != 0) {
                }
                startRestartGroup.endReplaceGroup();
                int i25222222 = i18 << 6;
                int i26222222 = i18;
                ProductsSelectors(routeSharedSelectedState, routeSelectedState, z7, routeSelectedState2, showTrailerSelector, removeSelectedTrailer, routeState, list, list2, showTransportProductsSelector, removeAllSelectedTransportProducts, startRestartGroup, ((i18 >> 21) & 126) | (i212222 & 896) | ((i18 >> 18) & 7168) | ((i222222 << 12) & 57344) | ((i222222 << 9) & 458752) | ((i18 << 12) & 3670016) | (29360128 & i25222222) | (i25222222 & 234881024) | ((i222222 << 24) & 1879048192), (i222222 >> 9) & 14);
                SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f5)), startRestartGroup, 6);
                startRestartGroup.startReplaceGroup(1418717696);
                if (selectedBookingType == BookingType.TwoWay) {
                }
                composer2 = startRestartGroup;
                composer2.endReplaceGroup();
                composer2.endNode();
                composer2.endNode();
                if (ComposerKt.isTraceInProgress()) {
                }
                z15 = z16;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            if ((i8 & 16) != 0) {
            }
            if ((i8 & 32) == 0) {
            }
            if ((i8 & 64) == 0) {
            }
            if ((i8 & 128) == 0) {
            }
            if ((i8 & 256) != 0) {
            }
            if ((i8 & 512) == 0) {
            }
            if ((i8 & 1024) == 0) {
            }
            if ((i8 & 2048) == 0) {
            }
            int i2122222 = i11;
            if ((i8 & 4096) != 0) {
            }
            i12 = i20;
            if ((i8 & 8192) != 0) {
            }
            if ((i8 & 16384) != 0) {
            }
            if ((32768 & i8) != 0) {
            }
            if ((i8 & 65536) != 0) {
            }
            if ((i8 & 131072) != 0) {
            }
            if ((262144 & i8) != 0) {
            }
            if ((i8 & 524288) != 0) {
            }
            if ((i8 & 1048576) != 0) {
            }
            if ((i8 & 2097152) != 0) {
            }
            int i2222222 = i14;
            if ((i8 & 4194304) != 0) {
            }
            if ((i8 & 8388608) != 0) {
            }
            i15 = 16777216 & i8;
            if (i15 != 0) {
            }
            i16 = i8 & 33554432;
            if (i16 == 0) {
            }
            if ((i8 & 67108864) == 0) {
            }
            if ((i8 & 134217728) == 0) {
            }
            if ((i8 & 268435456) == 0) {
            }
            if ((i12 & 306783379) != 306783378) {
            }
            if (i15 == 0) {
            }
            if (i16 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            Modifier.Companion companion2222222 = Modifier.INSTANCE;
            Alignment.Companion companion3222222 = Alignment.INSTANCE;
            MeasurePolicy maybeCachedBoxMeasurePolicy222222 = BoxKt.maybeCachedBoxMeasurePolicy(companion3222222.getTopStart(), false);
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap322222 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier322222 = ComposedModifierKt.materializeModifier(startRestartGroup, companion2222222);
            ComposeUiNode.Companion companion4222222 = ComposeUiNode.INSTANCE;
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
            FiltersOverscrollBackground(startRestartGroup, 0);
            float f6222222 = 16;
            Modifier m315paddingqDBjuR0$default222222 = PaddingKt.m315paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(BackgroundKt.background$default(companion2222222, Brush.Companion.m1466verticalGradient8A3gB4$default(Brush.INSTANCE, new Pair[]{TuplesKt.to(Float.valueOf(0.0f), Color.m1481boximpl(AppColor.INSTANCE.m3259getBrandDarkBlue10d7_KjU())), TuplesKt.to(Float.valueOf(0.44f), Color.m1481boximpl(ColorKt.Color(4280040641L))), TuplesKt.to(Float.valueOf(1.0f), Color.m1481boximpl(ColorKt.Color(4279713462L)))}, 0.0f, 0.0f, 0, 14, (Object) null), null, 0.0f, 6, null), 0.0f, 1, null), Dp.m2599constructorimpl(f6222222), 0.0f, Dp.m2599constructorimpl(f6222222), 0.0f, 10, null);
            MeasurePolicy columnMeasurePolicy222222 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), companion3222222.getStart(), startRestartGroup, 0);
            currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2222222 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2222222 = ComposedModifierKt.materializeModifier(startRestartGroup, m315paddingqDBjuR0$default222222);
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
            startRestartGroup.startReplaceGroup(1418583381);
            if (z7) {
            }
            i19 = 0;
            startRestartGroup.endReplaceGroup();
            if ((routeSharedSelectedState != null ? routeSharedSelectedState.getCommuterBookingData() : null) != null) {
            }
            if (routeSharedSelectedState != null) {
            }
            startRestartGroup.startReplaceGroup(1418671541);
            if (i19 != 0) {
            }
            startRestartGroup.endReplaceGroup();
            int i252222222 = i18 << 6;
            int i262222222 = i18;
            ProductsSelectors(routeSharedSelectedState, routeSelectedState, z7, routeSelectedState2, showTrailerSelector, removeSelectedTrailer, routeState, list, list2, showTransportProductsSelector, removeAllSelectedTransportProducts, startRestartGroup, ((i18 >> 21) & 126) | (i2122222 & 896) | ((i18 >> 18) & 7168) | ((i2222222 << 12) & 57344) | ((i2222222 << 9) & 458752) | ((i18 << 12) & 3670016) | (29360128 & i252222222) | (i252222222 & 234881024) | ((i2222222 << 24) & 1879048192), (i2222222 >> 9) & 14);
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f5)), startRestartGroup, 6);
            startRestartGroup.startReplaceGroup(1418717696);
            if (selectedBookingType == BookingType.TwoWay) {
            }
            composer2 = startRestartGroup;
            composer2.endReplaceGroup();
            composer2.endNode();
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
            }
            z15 = z16;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        if ((i8 & 8) == 0) {
        }
        if ((i8 & 16) != 0) {
        }
        if ((i8 & 32) == 0) {
        }
        if ((i8 & 64) == 0) {
        }
        if ((i8 & 128) == 0) {
        }
        if ((i8 & 256) != 0) {
        }
        if ((i8 & 512) == 0) {
        }
        if ((i8 & 1024) == 0) {
        }
        if ((i8 & 2048) == 0) {
        }
        int i21222222 = i11;
        if ((i8 & 4096) != 0) {
        }
        i12 = i20;
        if ((i8 & 8192) != 0) {
        }
        if ((i8 & 16384) != 0) {
        }
        if ((32768 & i8) != 0) {
        }
        if ((i8 & 65536) != 0) {
        }
        if ((i8 & 131072) != 0) {
        }
        if ((262144 & i8) != 0) {
        }
        if ((i8 & 524288) != 0) {
        }
        if ((i8 & 1048576) != 0) {
        }
        if ((i8 & 2097152) != 0) {
        }
        int i22222222 = i14;
        if ((i8 & 4194304) != 0) {
        }
        if ((i8 & 8388608) != 0) {
        }
        i15 = 16777216 & i8;
        if (i15 != 0) {
        }
        i16 = i8 & 33554432;
        if (i16 == 0) {
        }
        if ((i8 & 67108864) == 0) {
        }
        if ((i8 & 134217728) == 0) {
        }
        if ((i8 & 268435456) == 0) {
        }
        if ((i12 & 306783379) != 306783378) {
        }
        if (i15 == 0) {
        }
        if (i16 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        Modifier.Companion companion22222222 = Modifier.INSTANCE;
        Alignment.Companion companion32222222 = Alignment.INSTANCE;
        MeasurePolicy maybeCachedBoxMeasurePolicy2222222 = BoxKt.maybeCachedBoxMeasurePolicy(companion32222222.getTopStart(), false);
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap3222222 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier3222222 = ComposedModifierKt.materializeModifier(startRestartGroup, companion22222222);
        ComposeUiNode.Companion companion42222222 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor3222222 = companion42222222.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
        Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy2222222, companion42222222.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap3222222, companion42222222.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3222222 = companion42222222.getSetCompositeKeyHash();
        if (!m1226constructorimpl.getInserting()) {
        }
        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash3222222);
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier3222222, companion42222222.getSetModifier());
        BoxScopeInstance boxScopeInstance2222222 = BoxScopeInstance.INSTANCE;
        FiltersOverscrollBackground(startRestartGroup, 0);
        float f62222222 = 16;
        Modifier m315paddingqDBjuR0$default2222222 = PaddingKt.m315paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(BackgroundKt.background$default(companion22222222, Brush.Companion.m1466verticalGradient8A3gB4$default(Brush.INSTANCE, new Pair[]{TuplesKt.to(Float.valueOf(0.0f), Color.m1481boximpl(AppColor.INSTANCE.m3259getBrandDarkBlue10d7_KjU())), TuplesKt.to(Float.valueOf(0.44f), Color.m1481boximpl(ColorKt.Color(4280040641L))), TuplesKt.to(Float.valueOf(1.0f), Color.m1481boximpl(ColorKt.Color(4279713462L)))}, 0.0f, 0.0f, 0, 14, (Object) null), null, 0.0f, 6, null), 0.0f, 1, null), Dp.m2599constructorimpl(f62222222), 0.0f, Dp.m2599constructorimpl(f62222222), 0.0f, 10, null);
        MeasurePolicy columnMeasurePolicy2222222 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), companion32222222.getStart(), startRestartGroup, 0);
        currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap22222222 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier22222222 = ComposedModifierKt.materializeModifier(startRestartGroup, m315paddingqDBjuR0$default2222222);
        Function0<ComposeUiNode> constructor22222222 = companion42222222.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
        Updater.m1227setimpl(m1226constructorimpl2, columnMeasurePolicy2222222, companion42222222.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap22222222, companion42222222.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash22222222 = companion42222222.getSetCompositeKeyHash();
        if (!m1226constructorimpl2.getInserting()) {
        }
        m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
        m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash22222222);
        Updater.m1227setimpl(m1226constructorimpl2, materializeModifier22222222, companion42222222.getSetModifier());
        ColumnScopeInstance columnScopeInstance2222222 = ColumnScopeInstance.INSTANCE;
        startRestartGroup.startReplaceGroup(1418583381);
        if (z7) {
        }
        i19 = 0;
        startRestartGroup.endReplaceGroup();
        if ((routeSharedSelectedState != null ? routeSharedSelectedState.getCommuterBookingData() : null) != null) {
        }
        if (routeSharedSelectedState != null) {
        }
        startRestartGroup.startReplaceGroup(1418671541);
        if (i19 != 0) {
        }
        startRestartGroup.endReplaceGroup();
        int i2522222222 = i18 << 6;
        int i2622222222 = i18;
        ProductsSelectors(routeSharedSelectedState, routeSelectedState, z7, routeSelectedState2, showTrailerSelector, removeSelectedTrailer, routeState, list, list2, showTransportProductsSelector, removeAllSelectedTransportProducts, startRestartGroup, ((i18 >> 21) & 126) | (i21222222 & 896) | ((i18 >> 18) & 7168) | ((i22222222 << 12) & 57344) | ((i22222222 << 9) & 458752) | ((i18 << 12) & 3670016) | (29360128 & i2522222222) | (i2522222222 & 234881024) | ((i22222222 << 24) & 1879048192), (i22222222 >> 9) & 14);
        SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f5)), startRestartGroup, 6);
        startRestartGroup.startReplaceGroup(1418717696);
        if (selectedBookingType == BookingType.TwoWay) {
        }
        composer2 = startRestartGroup;
        composer2.endReplaceGroup();
        composer2.endNode();
        composer2.endNode();
        if (ComposerKt.isTraceInProgress()) {
        }
        z15 = z16;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DepartureFiltersView$lambda$3$lambda$2$lambda$1$lambda$0(Function0 function0, RouteDirection routeDirection) {
        Intrinsics.checkNotNullParameter(routeDirection, "<unused var>");
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DepartureFiltersView$lambda$4(BookingType bookingType, DepartureDirection departureDirection, RouteState routeState, PassengerInfo passengerInfo, PassengerInfo passengerInfo2, List list, List list2, RouteSharedSelectedState routeSharedSelectedState, RouteSelectedState routeSelectedState, RouteSelectedState routeSelectedState2, boolean z5, boolean z6, boolean z7, boolean z8, Function1 function1, Function0 function0, Function1 function12, Function0 function02, Function1 function13, Function0 function03, Function0 function04, Function0 function05, Function0 function06, Function0 function07, boolean z9, boolean z10, Function0 function08, boolean z11, boolean z12, int i5, int i6, int i7, int i8, Composer composer, int i9) {
        DepartureFiltersView(bookingType, departureDirection, routeState, passengerInfo, passengerInfo2, list, list2, routeSharedSelectedState, routeSelectedState, routeSelectedState2, z5, z6, z7, z8, function1, function0, function12, function02, function13, function03, function04, function05, function06, function07, z9, z10, function08, z11, z12, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), RecomposeScopeImplKt.updateChangedFlags(i6), RecomposeScopeImplKt.updateChangedFlags(i7), i8);
        return Unit.INSTANCE;
    }

    public static final void FiltersOverscrollBackground(Composer composer, final int i5) {
        Composer startRestartGroup = composer.startRestartGroup(342265727);
        if (i5 == 0 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(342265727, i5, -1, "dk.molslinjen.ui.views.screens.booking.departures.FiltersOverscrollBackground (DepartureFiltersView.kt:214)");
            }
            BoxKt.Box(BackgroundKt.m104backgroundbw27NRU$default(SizeKt.fillMaxWidth$default(SizeKt.m325height3ABfNKs(OffsetKt.m295offsetVpY3zN4$default(Modifier.INSTANCE, 0.0f, Dp.m2599constructorimpl(-20), 1, null), Dp.m2599constructorimpl(20)), 0.0f, 1, null), AppColor.INSTANCE.m3259getBrandDarkBlue10d7_KjU(), null, 2, null), startRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: J2.k
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit FiltersOverscrollBackground$lambda$8;
                    FiltersOverscrollBackground$lambda$8 = DepartureFiltersViewKt.FiltersOverscrollBackground$lambda$8(i5, (Composer) obj, ((Integer) obj2).intValue());
                    return FiltersOverscrollBackground$lambda$8;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FiltersOverscrollBackground$lambda$8(int i5, Composer composer, int i6) {
        FiltersOverscrollBackground(composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    private static final void ProductsSelectors(final RouteSharedSelectedState routeSharedSelectedState, final RouteSelectedState routeSelectedState, final boolean z5, final RouteSelectedState routeSelectedState2, final Function0<Unit> function0, final Function0<Unit> function02, final RouteState routeState, final List<? extends Product> list, final List<? extends Product> list2, final Function0<Unit> function03, final Function0<Unit> function04, Composer composer, final int i5, final int i6) {
        Composer composer2;
        ManagerResult<TransportProducts> transportProducts;
        TransportProducts transportProducts2;
        List<Product> products;
        List emptyList;
        ArrayList arrayList;
        Transportation selectedTransportation;
        TrailerProduct selectedTrailer;
        Composer startRestartGroup = composer.startRestartGroup(-226599179);
        int i7 = (i5 & 6) == 0 ? (startRestartGroup.changedInstance(routeSharedSelectedState) ? 4 : 2) | i5 : i5;
        if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changedInstance(routeSelectedState) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i7 |= startRestartGroup.changed(z5) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i7 |= startRestartGroup.changedInstance(routeSelectedState2) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i7 |= startRestartGroup.changedInstance(function0) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i7 |= startRestartGroup.changedInstance(function02) ? 131072 : 65536;
        }
        if ((1572864 & i5) == 0) {
            i7 |= startRestartGroup.changedInstance(routeState) ? 1048576 : 524288;
        }
        if ((12582912 & i5) == 0) {
            i7 |= startRestartGroup.changedInstance(list) ? 8388608 : 4194304;
        }
        if ((100663296 & i5) == 0) {
            i7 |= startRestartGroup.changedInstance(list2) ? 67108864 : 33554432;
        }
        if ((805306368 & i5) == 0) {
            i7 |= startRestartGroup.changedInstance(function03) ? 536870912 : 268435456;
        }
        int i8 = (i6 & 6) == 0 ? i6 | (startRestartGroup.changedInstance(function04) ? 4 : 2) : i6;
        if ((i7 & 306783379) == 306783378 && (i8 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-226599179, i7, i8, "dk.molslinjen.ui.views.screens.booking.departures.ProductsSelectors (DepartureFiltersView.kt:186)");
            }
            startRestartGroup.startReplaceGroup(1339898827);
            if (routeSharedSelectedState != null && (selectedTransportation = routeSharedSelectedState.getSelectedTransportation()) != null && selectedTransportation.getTrailerAllowed() && routeSelectedState != null) {
                SpacerKt.Spacer(SizeKt.m325height3ABfNKs(Modifier.INSTANCE, Dp.m2599constructorimpl(16)), startRestartGroup, 6);
                if (z5) {
                    if (routeSelectedState2 != null) {
                        selectedTrailer = routeSelectedState2.getSelectedTrailer();
                        TrailerSelectorViewKt.TrailerSelectorView(selectedTrailer, function0, function02, startRestartGroup, (i7 >> 9) & 1008);
                    }
                    selectedTrailer = null;
                    TrailerSelectorViewKt.TrailerSelectorView(selectedTrailer, function0, function02, startRestartGroup, (i7 >> 9) & 1008);
                } else {
                    selectedTrailer = routeSelectedState.getSelectedTrailer();
                    if (selectedTrailer == null) {
                        if (routeSelectedState2 != null) {
                            selectedTrailer = routeSelectedState2.getSelectedTrailer();
                        }
                        selectedTrailer = null;
                    }
                    TrailerSelectorViewKt.TrailerSelectorView(selectedTrailer, function0, function02, startRestartGroup, (i7 >> 9) & 1008);
                }
            }
            startRestartGroup.endReplaceGroup();
            if (routeState == null || (transportProducts = routeState.getTransportProducts()) == null || (transportProducts2 = (TransportProducts) ManagerResultExtensionsKt.toData(transportProducts)) == null || (products = transportProducts2.getProducts()) == null || !(!products.isEmpty())) {
                composer2 = startRestartGroup;
            } else {
                SpacerKt.Spacer(SizeKt.m325height3ABfNKs(Modifier.INSTANCE, Dp.m2599constructorimpl(16)), startRestartGroup, 6);
                if (list != null) {
                    emptyList = new ArrayList();
                    for (Object obj : list) {
                        if (((Product) obj).getQuantity() > 0) {
                            emptyList.add(obj);
                        }
                    }
                } else {
                    emptyList = CollectionsKt.emptyList();
                }
                if (list2 != null) {
                    arrayList = new ArrayList();
                    for (Object obj2 : list2) {
                        if (((Product) obj2).getQuantity() > 0) {
                            arrayList.add(obj2);
                        }
                    }
                } else {
                    arrayList = null;
                }
                composer2 = startRestartGroup;
                TransportProductSelectedCardViewKt.TransportProductSelectedCardView(emptyList, arrayList, z5, function03, function04, startRestartGroup, (i7 & 896) | ((i7 >> 18) & 7168) | ((i8 << 12) & 57344));
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: J2.j
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj3, Object obj4) {
                    Unit ProductsSelectors$lambda$7;
                    ProductsSelectors$lambda$7 = DepartureFiltersViewKt.ProductsSelectors$lambda$7(RouteSharedSelectedState.this, routeSelectedState, z5, routeSelectedState2, function0, function02, routeState, list, list2, function03, function04, i5, i6, (Composer) obj3, ((Integer) obj4).intValue());
                    return ProductsSelectors$lambda$7;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProductsSelectors$lambda$7(RouteSharedSelectedState routeSharedSelectedState, RouteSelectedState routeSelectedState, boolean z5, RouteSelectedState routeSelectedState2, Function0 function0, Function0 function02, RouteState routeState, List list, List list2, Function0 function03, Function0 function04, int i5, int i6, Composer composer, int i7) {
        ProductsSelectors(routeSharedSelectedState, routeSelectedState, z5, routeSelectedState2, function0, function02, routeState, list, list2, function03, function04, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), RecomposeScopeImplKt.updateChangedFlags(i6));
        return Unit.INSTANCE;
    }
}
