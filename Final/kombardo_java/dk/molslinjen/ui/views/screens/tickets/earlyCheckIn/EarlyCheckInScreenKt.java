package dk.molslinjen.ui.views.screens.tickets.earlyCheckIn;

import android.content.Context;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.grid.GridCells;
import androidx.compose.foundation.lazy.grid.GridItemSpan;
import androidx.compose.foundation.lazy.grid.LazyGridDslKt;
import androidx.compose.foundation.lazy.grid.LazyGridItemScope;
import androidx.compose.foundation.lazy.grid.LazyGridItemSpanScope;
import androidx.compose.foundation.lazy.grid.LazyGridScope;
import androidx.compose.foundation.lazy.grid.LazyGridSpanKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
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
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.LiveRegionMode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import com.ramcosta.composedestinations.generated.destinations.VehicleSelectorScreenDestination;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import com.ramcosta.composedestinations.result.OpenResultRecipientKt;
import com.ramcosta.composedestinations.result.ResultRecipient;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.domain.managers.checkout.PassengerSelectionHelper;
import dk.molslinjen.domain.managers.checkout.PriceTotal;
import dk.molslinjen.domain.managers.checkout.SimpleChangeCheckoutManager;
import dk.molslinjen.domain.model.account.UserVehicle;
import dk.molslinjen.domain.model.booking.Booking;
import dk.molslinjen.domain.model.booking.BookingPassenger;
import dk.molslinjen.domain.model.booking.LineItem;
import dk.molslinjen.domain.model.booking.ProductType;
import dk.molslinjen.domain.model.booking.product.Product;
import dk.molslinjen.domain.model.config.Transportation;
import dk.molslinjen.domain.model.constants.Constants;
import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import dk.molslinjen.extensions.ComposeExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.ThemeShapesKt;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.LoadingComponentKt;
import dk.molslinjen.ui.views.reusable.bottomsheet.BottomSheetContainerKt;
import dk.molslinjen.ui.views.reusable.buttons.SecondaryButtonKt;
import dk.molslinjen.ui.views.reusable.input.licensePlate.LicensePlateButtonKt;
import dk.molslinjen.ui.views.reusable.input.validation.FormValidator;
import dk.molslinjen.ui.views.reusable.input.validation.InputValidationError;
import dk.molslinjen.ui.views.screens.booking.passengers.CheckoutPassengerPortraitSimpleKt;
import dk.molslinjen.ui.views.screens.booking.summary.BookingSummaryFormField;
import dk.molslinjen.ui.views.screens.booking.summary.LicensePlateValidator;
import dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.EarlyCheckInScreenKt;
import dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.EarlyCheckInViewModel;
import dk.molslinjen.ui.views.shared.ticket.ticketSummary.FoodSectionKt;
import dk.molslinjen.ui.views.shared.ticket.ticketSummary.PriceDetailsViewKt;
import dk.molslinjen.ui.views.shared.ticket.ticketSummary.ProductSectionKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\u001a3\u0010\t\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0007¢\u0006\u0004\b\t\u0010\n\u001ag\u0010\u0018\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u00132\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u00132\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u00132\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u0013H\u0003¢\u0006\u0004\b\u0018\u0010\u0019\u001a1\u0010\u001d\u001a\u00020\b*\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0010\u001a\u00020\u000f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u0013H\u0002¢\u0006\u0004\b\u001d\u0010\u001e\u001a1\u0010\u001f\u001a\u00020\b*\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0010\u001a\u00020\u000f2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u0013H\u0002¢\u0006\u0004\b\u001f\u0010\u001e\u001a[\u0010+\u001a\u00020\b*\u00020\u001a2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0 2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\b0\u00132\u0006\u0010%\u001a\u00020$2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020$0&2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020(0&2\u0006\u0010*\u001a\u00020$H\u0002¢\u0006\u0004\b+\u0010,\u001a/\u0010.\u001a\u00020\b2\b\u0010-\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0012\u001a\u00020\u00112\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0013H\u0003¢\u0006\u0004\b.\u0010/\u001a'\u00103\u001a\u00020\b2\u0006\u00101\u001a\u0002002\u000e\u00102\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0013H\u0003¢\u0006\u0004\b3\u00104\u001a7\u0010:\u001a\u00020\b2\b\b\u0001\u00105\u001a\u00020(2\u0006\u00107\u001a\u0002062\u0006\u00108\u001a\u0002062\f\u00109\u001a\b\u0012\u0004\u0012\u00020\b0\u0013H\u0003¢\u0006\u0004\b:\u0010;¨\u0006<"}, d2 = {"Ldk/molslinjen/ui/views/screens/tickets/earlyCheckIn/EarlyCheckInViewModel;", "viewModel", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "navigator", "Lcom/ramcosta/composedestinations/result/ResultRecipient;", "Lcom/ramcosta/composedestinations/generated/destinations/VehicleSelectorScreenDestination;", "Ldk/molslinjen/domain/model/account/UserVehicle;", "vehicleSelectorResultRecipient", BuildConfig.FLAVOR, "EarlyCheckInScreen", "(Ldk/molslinjen/ui/views/screens/tickets/earlyCheckIn/EarlyCheckInViewModel;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Lcom/ramcosta/composedestinations/result/ResultRecipient;Landroidx/compose/runtime/Composer;I)V", "Ldk/molslinjen/ui/views/screens/tickets/earlyCheckIn/EarlyCheckInViewModel$ViewState;", "state", "Ldk/molslinjen/domain/managers/checkout/PassengerSelectionHelper$PassengerState;", "passengerState", "Ldk/molslinjen/domain/managers/checkout/SimpleChangeCheckoutManager$SimpleChangeCheckoutState;", "simpleChangeCheckoutState", "Ldk/molslinjen/ui/views/reusable/input/validation/FormValidator;", "validator", "Lkotlin/Function0;", "showVehiclePickerDialog", "showSelectPassengersDialog", "showSelectFoodDialog", "showSelectAddonsDialog", "EarlyCheckInContent", "(Ldk/molslinjen/ui/views/screens/tickets/earlyCheckIn/EarlyCheckInViewModel$ViewState;Ldk/molslinjen/domain/managers/checkout/PassengerSelectionHelper$PassengerState;Ldk/molslinjen/domain/managers/checkout/SimpleChangeCheckoutManager$SimpleChangeCheckoutState;Ldk/molslinjen/ui/views/reusable/input/validation/FormValidator;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/foundation/lazy/grid/LazyGridScope;", "Ldk/molslinjen/domain/model/booking/Booking;", "booking", "foodSection", "(Landroidx/compose/foundation/lazy/grid/LazyGridScope;Ldk/molslinjen/domain/model/booking/Booking;Ldk/molslinjen/domain/managers/checkout/SimpleChangeCheckoutManager$SimpleChangeCheckoutState;Lkotlin/jvm/functions/Function0;)V", "addonsSection", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/BookingPassenger;", "passengers", "changePassengers", BuildConfig.FLAVOR, "showAgeGroup", "Landroidx/compose/runtime/MutableState;", "showAllPassengers", BuildConfig.FLAVOR, "horizontalCellCount", "showSeatReservationCancelled", "passengersSection", "(Landroidx/compose/foundation/lazy/grid/LazyGridScope;Ljava/util/List;Lkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;Z)V", "selectedVehicle", "LicensePlateSection", "(Ldk/molslinjen/domain/model/account/UserVehicle;Ldk/molslinjen/ui/views/reusable/input/validation/FormValidator;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/ui/text/AnnotatedString;", Constants.IntentExtra.PushTitle, "edit", "HeaderRow", "(Landroidx/compose/ui/text/AnnotatedString;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "drawableResourceId", BuildConfig.FLAVOR, "text", "buttonTitle", "showAddonSelector", "AddonBanner", "(ILjava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class EarlyCheckInScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void AddonBanner(final int i5, final String str, final String str2, final Function0<Unit> function0, Composer composer, final int i6) {
        int i7;
        Composer startRestartGroup = composer.startRestartGroup(-1758028195);
        if ((i6 & 6) == 0) {
            i7 = (startRestartGroup.changed(i5) ? 4 : 2) | i6;
        } else {
            i7 = i6;
        }
        if ((i6 & 48) == 0) {
            i7 |= startRestartGroup.changed(str) ? 32 : 16;
        }
        if ((i6 & 384) == 0) {
            i7 |= startRestartGroup.changed(str2) ? 256 : 128;
        }
        if ((i6 & 3072) == 0) {
            i7 |= startRestartGroup.changedInstance(function0) ? 2048 : 1024;
        }
        int i8 = i7;
        if ((i8 & 1171) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1758028195, i8, -1, "dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.AddonBanner (EarlyCheckInScreen.kt:494)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            float f5 = 8;
            float f6 = 16;
            Modifier m314paddingqDBjuR0 = PaddingKt.m314paddingqDBjuR0(BorderKt.m108borderxT4_qwU(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), Dp.m2599constructorimpl(1), AppColor.INSTANCE.m3268getGrey50d7_KjU(), ThemeShapesKt.getThemeShapes().getMedium()), Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(f6), Dp.m2599constructorimpl(f5));
            Alignment.Companion companion2 = Alignment.INSTANCE;
            Alignment.Vertical centerVertically = companion2.getCenterVertically();
            Arrangement arrangement = Arrangement.INSTANCE;
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), centerVertically, startRestartGroup, 48);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m314paddingqDBjuR0);
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
            ImageKt.Image(PainterResources_androidKt.painterResource(i5, startRestartGroup, i8 & 14), Accessibility.INSTANCE.getSkip(), SizeKt.m333sizeVpY3zN4(companion, Dp.m2599constructorimpl(86), Dp.m2599constructorimpl(125)), null, null, 0.0f, null, startRestartGroup, 384, 120);
            Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(companion, Dp.m2599constructorimpl(f6), 0.0f, 0.0f, 0.0f, 14, null);
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion2.getStart(), startRestartGroup, 0);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m315paddingqDBjuR0$default);
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
            int i9 = i8 >> 3;
            TextKt.m940Text4IGK_g(str, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmall(), startRestartGroup, i9 & 14, 1572864, 65534);
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f6)), startRestartGroup, 6);
            SecondaryButtonKt.m3406SecondaryButtonbZJ32A(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), str2, function0, null, false, null, false, null, null, 0L, false, startRestartGroup, (i9 & 112) | 6 | (i9 & 896), 0, 2040);
            startRestartGroup.endNode();
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: q4.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit AddonBanner$lambda$38;
                    AddonBanner$lambda$38 = EarlyCheckInScreenKt.AddonBanner$lambda$38(i5, str, str2, function0, i6, (Composer) obj, ((Integer) obj2).intValue());
                    return AddonBanner$lambda$38;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddonBanner$lambda$38(int i5, String str, String str2, Function0 function0, int i6, Composer composer, int i7) {
        AddonBanner(i5, str, str2, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i6 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void EarlyCheckInContent(final EarlyCheckInViewModel.ViewState viewState, final PassengerSelectionHelper.PassengerState passengerState, final SimpleChangeCheckoutManager.SimpleChangeCheckoutState simpleChangeCheckoutState, final FormValidator formValidator, final Function0<Unit> function0, final Function0<Unit> function02, final Function0<Unit> function03, final Function0<Unit> function04, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        GridCells.Adaptive adaptive;
        MutableState mutableStateOf$default;
        Composer startRestartGroup = composer.startRestartGroup(1816608153);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewState) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(passengerState) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(simpleChangeCheckoutState) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(formValidator) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(function0) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i6 |= startRestartGroup.changedInstance(function02) ? 131072 : 65536;
        }
        if ((1572864 & i5) == 0) {
            i6 |= startRestartGroup.changedInstance(function03) ? 1048576 : 524288;
        }
        if ((i5 & 12582912) == 0) {
            i6 |= startRestartGroup.changedInstance(function04) ? 8388608 : 4194304;
        }
        if ((i6 & 4793491) == 4793490 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1816608153, i6, -1, "dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.EarlyCheckInContent (EarlyCheckInScreen.kt:195)");
            }
            if (viewState.getIsLoading() || viewState.getBooking() == null) {
                composer2 = startRestartGroup;
                composer2.startReplaceGroup(1850842294);
                LoadingComponentKt.m3392LoadingComponentjfnsLPA(null, 0.0f, true, 0, false, null, ComposableSingletons$EarlyCheckInScreenKt.INSTANCE.m3544getLambda1$app_kombardoProd(), composer2, 1573248, 59);
                composer2.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(1851001014);
                startRestartGroup.startReplaceGroup(2137917589);
                Object rememberedValue = startRestartGroup.rememberedValue();
                Composer.Companion companion = Composer.INSTANCE;
                if (rememberedValue == companion.getEmpty()) {
                    rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                final MutableState mutableState = (MutableState) rememberedValue;
                startRestartGroup.endReplaceGroup();
                startRestartGroup.startReplaceGroup(2137919605);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (rememberedValue2 == companion.getEmpty()) {
                    rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                final MutableState mutableState2 = (MutableState) rememberedValue2;
                startRestartGroup.endReplaceGroup();
                final int m3250dpToPx8Feqmps = (int) ComposeExtensionsKt.m3250dpToPx8Feqmps(Dp.m2599constructorimpl(74), startRestartGroup, 6);
                startRestartGroup.startReplaceGroup(2137923193);
                Object rememberedValue3 = startRestartGroup.rememberedValue();
                if (rememberedValue3 == companion.getEmpty()) {
                    mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    startRestartGroup.updateRememberedValue(mutableStateOf$default);
                    rememberedValue3 = mutableStateOf$default;
                }
                final MutableState mutableState3 = (MutableState) rememberedValue3;
                startRestartGroup.endReplaceGroup();
                float f5 = 24;
                Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(PaddingKt.m313paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m2599constructorimpl(f5), 0.0f, 2, null), 0.0f, 1, null);
                startRestartGroup.startReplaceGroup(2137930070);
                boolean changed = startRestartGroup.changed(m3250dpToPx8Feqmps);
                Object rememberedValue4 = startRestartGroup.rememberedValue();
                if (changed || rememberedValue4 == companion.getEmpty()) {
                    rememberedValue4 = new Function1() { // from class: q4.j
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit EarlyCheckInContent$lambda$9$lambda$8;
                            EarlyCheckInContent$lambda$9$lambda$8 = EarlyCheckInScreenKt.EarlyCheckInContent$lambda$9$lambda$8(MutableState.this, m3250dpToPx8Feqmps, mutableState2, (LayoutCoordinates) obj);
                            return EarlyCheckInContent$lambda$9$lambda$8;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue4);
                }
                startRestartGroup.endReplaceGroup();
                Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(fillMaxSize$default, (Function1) rememberedValue4);
                PaddingValues m310PaddingValuesa9UjIt4$default = PaddingKt.m310PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, Dp.m2599constructorimpl(f5), 7, null);
                Arrangement arrangement = Arrangement.INSTANCE;
                Arrangement.HorizontalOrVertical m265spacedBy0680j_4 = arrangement.m265spacedBy0680j_4(Dp.m2599constructorimpl(16));
                Arrangement.HorizontalOrVertical m265spacedBy0680j_42 = arrangement.m265spacedBy0680j_4(ComposeExtensionsKt.pxToDp(((Number) mutableState2.getValue()).intValue(), startRestartGroup, 0));
                GridCells.Adaptive adaptive2 = new GridCells.Adaptive(ComposeExtensionsKt.pxToDp(m3250dpToPx8Feqmps, startRestartGroup, 0), null);
                startRestartGroup.startReplaceGroup(2137949601);
                boolean changedInstance = startRestartGroup.changedInstance(viewState) | startRestartGroup.changedInstance(formValidator) | ((57344 & i6) == 16384) | startRestartGroup.changedInstance(passengerState) | ((458752 & i6) == 131072) | startRestartGroup.changedInstance(simpleChangeCheckoutState) | ((3670016 & i6) == 1048576) | ((i6 & 29360128) == 8388608);
                Object rememberedValue5 = startRestartGroup.rememberedValue();
                if (changedInstance || rememberedValue5 == companion.getEmpty()) {
                    adaptive = adaptive2;
                    composer2 = startRestartGroup;
                    Function1 function1 = new Function1() { // from class: q4.k
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit EarlyCheckInContent$lambda$14$lambda$13;
                            EarlyCheckInContent$lambda$14$lambda$13 = EarlyCheckInScreenKt.EarlyCheckInContent$lambda$14$lambda$13(EarlyCheckInViewModel.ViewState.this, passengerState, function02, mutableState3, mutableState, simpleChangeCheckoutState, function03, function04, formValidator, function0, (LazyGridScope) obj);
                            return EarlyCheckInContent$lambda$14$lambda$13;
                        }
                    };
                    composer2.updateRememberedValue(function1);
                    rememberedValue5 = function1;
                } else {
                    adaptive = adaptive2;
                    composer2 = startRestartGroup;
                }
                composer2.endReplaceGroup();
                LazyGridDslKt.LazyVerticalGrid(adaptive, onGloballyPositioned, null, m310PaddingValuesa9UjIt4$default, false, m265spacedBy0680j_4, m265spacedBy0680j_42, null, false, (Function1) rememberedValue5, composer2, 199680, 404);
                composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: q4.m
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit EarlyCheckInContent$lambda$15;
                    EarlyCheckInContent$lambda$15 = EarlyCheckInScreenKt.EarlyCheckInContent$lambda$15(EarlyCheckInViewModel.ViewState.this, passengerState, simpleChangeCheckoutState, formValidator, function0, function02, function03, function04, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return EarlyCheckInContent$lambda$15;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EarlyCheckInContent$lambda$14$lambda$13(final EarlyCheckInViewModel.ViewState viewState, PassengerSelectionHelper.PassengerState passengerState, Function0 function0, MutableState mutableState, MutableState mutableState2, SimpleChangeCheckoutManager.SimpleChangeCheckoutState simpleChangeCheckoutState, Function0 function02, Function0 function03, final FormValidator formValidator, final Function0 function04, LazyGridScope LazyVerticalGrid) {
        Intrinsics.checkNotNullParameter(LazyVerticalGrid, "$this$LazyVerticalGrid");
        final Transportation transport = viewState.getBooking().getTicket().getTransport();
        LazyGridScope.item$default(LazyVerticalGrid, null, new Function1() { // from class: q4.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                GridItemSpan EarlyCheckInContent$lambda$14$lambda$13$lambda$10;
                EarlyCheckInContent$lambda$14$lambda$13$lambda$10 = EarlyCheckInScreenKt.EarlyCheckInContent$lambda$14$lambda$13$lambda$10((LazyGridItemSpanScope) obj);
                return EarlyCheckInContent$lambda$14$lambda$13$lambda$10;
            }
        }, null, ComposableLambdaKt.composableLambdaInstance(-1295047257, true, new Function3<LazyGridItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.EarlyCheckInScreenKt$EarlyCheckInContent$2$1$2
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(LazyGridItemScope lazyGridItemScope, Composer composer, Integer num) {
                invoke(lazyGridItemScope, composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyGridItemScope item, Composer composer, int i5) {
                Intrinsics.checkNotNullParameter(item, "$this$item");
                if ((i5 & 17) == 16 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1295047257, i5, -1, "dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.EarlyCheckInContent.<anonymous>.<anonymous>.<anonymous> (EarlyCheckInScreen.kt:219)");
                }
                TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(Transportation.this.isWalking() ? R.string.earlyCheckIn_description_walking : R.string.earlyCheckIn_description_driving, composer, 0), null, AppColor.INSTANCE.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmall(), composer, 384, 1572864, 65530);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), 5, null);
        if (transport.getAllowLicensePlate()) {
            LazyGridScope.item$default(LazyVerticalGrid, null, new Function1() { // from class: q4.l
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    GridItemSpan EarlyCheckInContent$lambda$14$lambda$13$lambda$11;
                    EarlyCheckInContent$lambda$14$lambda$13$lambda$11 = EarlyCheckInScreenKt.EarlyCheckInContent$lambda$14$lambda$13$lambda$11((LazyGridItemSpanScope) obj);
                    return EarlyCheckInContent$lambda$14$lambda$13$lambda$11;
                }
            }, null, ComposableLambdaKt.composableLambdaInstance(601236844, true, new Function3<LazyGridItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.EarlyCheckInScreenKt$EarlyCheckInContent$2$1$4
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(LazyGridItemScope lazyGridItemScope, Composer composer, Integer num) {
                    invoke(lazyGridItemScope, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(LazyGridItemScope item, Composer composer, int i5) {
                    Intrinsics.checkNotNullParameter(item, "$this$item");
                    if ((i5 & 17) == 16 && composer.getSkipping()) {
                        composer.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(601236844, i5, -1, "dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.EarlyCheckInContent.<anonymous>.<anonymous>.<anonymous> (EarlyCheckInScreen.kt:233)");
                    }
                    EarlyCheckInScreenKt.LicensePlateSection(EarlyCheckInViewModel.ViewState.this.getSelectedVehicle(), formValidator, function04, composer, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), 5, null);
            LazyGridScope.item$default(LazyVerticalGrid, null, new Function1() { // from class: q4.n
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    GridItemSpan EarlyCheckInContent$lambda$14$lambda$13$lambda$12;
                    EarlyCheckInContent$lambda$14$lambda$13$lambda$12 = EarlyCheckInScreenKt.EarlyCheckInContent$lambda$14$lambda$13$lambda$12((LazyGridItemSpanScope) obj);
                    return EarlyCheckInContent$lambda$14$lambda$13$lambda$12;
                }
            }, null, ComposableSingletons$EarlyCheckInScreenKt.INSTANCE.m3545getLambda2$app_kombardoProd(), 5, null);
        }
        passengersSection(LazyVerticalGrid, CollectionsKt.plus((Collection) ((!passengerState.getCurrentUserSelected() || passengerState.getCurrentUser() == null) ? CollectionsKt.emptyList() : CollectionsKt.listOfNotNull(passengerState.getCurrentUser())), (Iterable) passengerState.getSelectedPassengers()), function0, transport.isWalking(), mutableState, mutableState2, simpleChangeCheckoutState.getInvalidateSeatReservation());
        foodSection(LazyVerticalGrid, viewState.getBooking(), simpleChangeCheckoutState, function02);
        addonsSection(LazyVerticalGrid, viewState.getBooking(), simpleChangeCheckoutState, function03);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GridItemSpan EarlyCheckInContent$lambda$14$lambda$13$lambda$10(LazyGridItemSpanScope item) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        return GridItemSpan.m380boximpl(LazyGridSpanKt.GridItemSpan(item.getMaxLineSpan()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GridItemSpan EarlyCheckInContent$lambda$14$lambda$13$lambda$11(LazyGridItemSpanScope item) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        return GridItemSpan.m380boximpl(LazyGridSpanKt.GridItemSpan(item.getMaxLineSpan()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GridItemSpan EarlyCheckInContent$lambda$14$lambda$13$lambda$12(LazyGridItemSpanScope item) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        return GridItemSpan.m380boximpl(LazyGridSpanKt.GridItemSpan(item.getMaxLineSpan()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EarlyCheckInContent$lambda$15(EarlyCheckInViewModel.ViewState viewState, PassengerSelectionHelper.PassengerState passengerState, SimpleChangeCheckoutManager.SimpleChangeCheckoutState simpleChangeCheckoutState, FormValidator formValidator, Function0 function0, Function0 function02, Function0 function03, Function0 function04, int i5, Composer composer, int i6) {
        EarlyCheckInContent(viewState, passengerState, simpleChangeCheckoutState, formValidator, function0, function02, function03, function04, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EarlyCheckInContent$lambda$9$lambda$8(MutableState mutableState, int i5, MutableState mutableState2, LayoutCoordinates it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(Integer.valueOf((int) (IntSize.m2661getWidthimpl(it.mo1948getSizeYbymL2g()) / i5)));
        mutableState2.setValue(Integer.valueOf((IntSize.m2661getWidthimpl(it.mo1948getSizeYbymL2g()) - (((Number) mutableState.getValue()).intValue() * i5)) / (((Number) mutableState.getValue()).intValue() - 1)));
        return Unit.INSTANCE;
    }

    public static final void EarlyCheckInScreen(final EarlyCheckInViewModel viewModel, final DestinationsNavigator navigator, final ResultRecipient<VehicleSelectorScreenDestination, UserVehicle> vehicleSelectorResultRecipient, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Intrinsics.checkNotNullParameter(vehicleSelectorResultRecipient, "vehicleSelectorResultRecipient");
        Composer startRestartGroup = composer.startRestartGroup(-1411165608);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewModel) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(navigator) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changed(vehicleSelectorResultRecipient) ? 256 : 128;
        }
        int i7 = i6;
        if ((i7 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1411165608, i7, -1, "dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.EarlyCheckInScreen (EarlyCheckInScreen.kt:109)");
            }
            EarlyCheckInViewModel.ViewState viewState = (EarlyCheckInViewModel.ViewState) SnapshotStateKt.collectAsState(viewModel.getViewState(), null, startRestartGroup, 0, 1).getValue();
            PassengerSelectionHelper.PassengerState passengerState = (PassengerSelectionHelper.PassengerState) SnapshotStateKt.collectAsState(viewModel.getPassengerState(), null, startRestartGroup, 0, 1).getValue();
            SimpleChangeCheckoutManager.SimpleChangeCheckoutState simpleChangeCheckoutState = (SimpleChangeCheckoutManager.SimpleChangeCheckoutState) SnapshotStateKt.collectAsState(viewModel.getSimpleChangeCheckoutState(), null, startRestartGroup, 0, 1).getValue();
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup));
                startRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                rememberedValue = compositionScopedCoroutineScopeCanceller;
            }
            CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
            startRestartGroup.startReplaceGroup(640498625);
            boolean changedInstance = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: q4.h
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit EarlyCheckInScreen$lambda$1$lambda$0;
                        EarlyCheckInScreen$lambda$1$lambda$0 = EarlyCheckInScreenKt.EarlyCheckInScreen$lambda$1$lambda$0(EarlyCheckInViewModel.this, (UserVehicle) obj);
                        return EarlyCheckInScreen$lambda$1$lambda$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            OpenResultRecipientKt.onResult(vehicleSelectorResultRecipient, null, (Function1) rememberedValue2, startRestartGroup, (i7 >> 6) & 14, 1);
            startRestartGroup.startReplaceGroup(640501064);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == companion.getEmpty()) {
                rememberedValue3 = new FormValidator(MapsKt.mapOf(TuplesKt.to(BookingSummaryFormField.LicensePlate, LicensePlateValidator.INSTANCE)), coroutineScope);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            FormValidator formValidator = (FormValidator) rememberedValue3;
            startRestartGroup.endReplaceGroup();
            AnnotatedString annotatedString = new AnnotatedString(StringResources_androidKt.stringResource(R.string.earlyCheckIn_title, startRestartGroup, 6), null, null, 6, null);
            startRestartGroup.startReplaceGroup(640510309);
            boolean z5 = (i7 & 112) == 32;
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue4 == companion.getEmpty()) {
                rememberedValue4 = new EarlyCheckInScreenKt$EarlyCheckInScreen$2$1(navigator);
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            BottomSheetContainerKt.m3398BottomSheetContainer8Un_QVk(null, 0.0f, 0L, annotatedString, null, null, (Function0) rememberedValue4, null, ComposableLambdaKt.rememberComposableLambda(-2094885738, true, new EarlyCheckInScreenKt$EarlyCheckInScreen$3(simpleChangeCheckoutState, viewState, formValidator, viewModel, navigator), startRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(321937317, true, new EarlyCheckInScreenKt$EarlyCheckInScreen$4(viewState, passengerState, simpleChangeCheckoutState, formValidator, navigator), startRestartGroup, 54), composer2, 905969664, 183);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: q4.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit EarlyCheckInScreen$lambda$4;
                    EarlyCheckInScreen$lambda$4 = EarlyCheckInScreenKt.EarlyCheckInScreen$lambda$4(EarlyCheckInViewModel.this, navigator, vehicleSelectorResultRecipient, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return EarlyCheckInScreen$lambda$4;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EarlyCheckInScreen$lambda$1$lambda$0(EarlyCheckInViewModel earlyCheckInViewModel, UserVehicle it) {
        Intrinsics.checkNotNullParameter(it, "it");
        earlyCheckInViewModel.updateSelectedVehicle(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EarlyCheckInScreen$lambda$4(EarlyCheckInViewModel earlyCheckInViewModel, DestinationsNavigator destinationsNavigator, ResultRecipient resultRecipient, int i5, Composer composer, int i6) {
        EarlyCheckInScreen(earlyCheckInViewModel, destinationsNavigator, resultRecipient, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void HeaderRow(final AnnotatedString annotatedString, Function0<Unit> function0, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        final Function0<Unit> function02;
        Modifier.Companion companion;
        Composer startRestartGroup = composer.startRestartGroup(-1992915496);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(annotatedString) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        int i7 = i6;
        if ((i7 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
            function02 = function0;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1992915496, i7, -1, "dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.HeaderRow (EarlyCheckInScreen.kt:459)");
            }
            final String stringResource = StringResources_androidKt.stringResource(R.string.accessibilityLabel_edit, startRestartGroup, 6);
            Modifier.Companion companion2 = Modifier.INSTANCE;
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(companion2, 0.0f, 1, null);
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getCenterVertically(), startRestartGroup, 48);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxWidth$default);
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
            TextKt.m941TextIbK3jfQ(annotatedString, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, TypographyKt.getParagraphBold(), startRestartGroup, i7 & 14, 12582912, 131070);
            composer2 = startRestartGroup;
            SpacerKt.Spacer(RowScope.weight$default(rowScopeInstance, companion2, 1.0f, false, 2, null), composer2, 0);
            composer2.startReplaceGroup(2099280917);
            function02 = function0;
            if (function02 == null) {
                companion = companion2;
            } else {
                composer2.startReplaceGroup(447319010);
                boolean changed = composer2.changed(stringResource);
                Object rememberedValue = composer2.rememberedValue();
                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function1() { // from class: q4.f
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit HeaderRow$lambda$34$lambda$33$lambda$32$lambda$31;
                            HeaderRow$lambda$34$lambda$33$lambda$32$lambda$31 = EarlyCheckInScreenKt.HeaderRow$lambda$34$lambda$33$lambda$32$lambda$31(stringResource, (SemanticsPropertyReceiver) obj);
                            return HeaderRow$lambda$34$lambda$33$lambda$32$lambda$31;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue);
                }
                composer2.endReplaceGroup();
                companion = companion2;
                IconButtonKt.IconButton(function0, SemanticsModifierKt.semantics$default(companion, false, (Function1) rememberedValue, 1, null), false, null, null, ComposableSingletons$EarlyCheckInScreenKt.INSTANCE.m3550getLambda7$app_kombardoProd(), composer2, ((i7 >> 3) & 14) | 196608, 28);
            }
            composer2.endReplaceGroup();
            composer2.endNode();
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(16)), composer2, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: q4.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit HeaderRow$lambda$35;
                    HeaderRow$lambda$35 = EarlyCheckInScreenKt.HeaderRow$lambda$35(AnnotatedString.this, function02, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return HeaderRow$lambda$35;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HeaderRow$lambda$34$lambda$33$lambda$32$lambda$31(String str, SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        SemanticsPropertiesKt.setContentDescription(semantics, str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HeaderRow$lambda$35(AnnotatedString annotatedString, Function0 function0, int i5, Composer composer, int i6) {
        HeaderRow(annotatedString, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void LicensePlateSection(final UserVehicle userVehicle, final FormValidator formValidator, final Function0<Unit> function0, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-1373236779);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(userVehicle) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(formValidator) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if ((i6 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1373236779, i6, -1, "dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.LicensePlateSection (EarlyCheckInScreen.kt:420)");
            }
            BookingSummaryFormField bookingSummaryFormField = BookingSummaryFormField.LicensePlate;
            formValidator.set(bookingSummaryFormField, EarlyCheckInLicensePlateValidator.INSTANCE.validateInput(userVehicle));
            InputValidationError inputValidationError = (InputValidationError) ((Map) SnapshotStateKt.collectAsState(formValidator.getSubmittedErrors(), null, startRestartGroup, 0, 1).getValue()).get(bookingSummaryFormField);
            startRestartGroup.startReplaceGroup(1481617483);
            final String errorMessage = inputValidationError == null ? null : inputValidationError.toErrorMessage((Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext()), bookingSummaryFormField);
            startRestartGroup.endReplaceGroup();
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
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
            Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            HeaderRow(new AnnotatedString(StringResources_androidKt.stringResource(R.string.earlyCheckIn_confirmVehicle, startRestartGroup, 6), null, null, 6, null), userVehicle != null ? function0 : null, startRestartGroup, 0);
            LicensePlateButtonKt.LicensePlateButton(userVehicle, null, false, function0, startRestartGroup, (i6 & 14) | 384 | ((i6 << 3) & 7168), 2);
            boolean z5 = errorMessage != null;
            startRestartGroup.startReplaceGroup(608850556);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: q4.o
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit LicensePlateSection$lambda$29$lambda$28$lambda$27;
                        LicensePlateSection$lambda$29$lambda$28$lambda$27 = EarlyCheckInScreenKt.LicensePlateSection$lambda$29$lambda$28$lambda$27((SemanticsPropertyReceiver) obj);
                        return LicensePlateSection$lambda$29$lambda$28$lambda$27;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            boolean z6 = z5;
            composer2 = startRestartGroup;
            AnimatedVisibilityKt.AnimatedVisibility(columnScopeInstance, z6, SemanticsModifierKt.semantics$default(companion, false, (Function1) rememberedValue, 1, null), (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(637804195, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.EarlyCheckInScreenKt$LicensePlateSection$1$2
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer3, Integer num) {
                    invoke(animatedVisibilityScope, composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer composer3, int i7) {
                    TextStyle m2295copyp1EtxEg;
                    Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(637804195, i7, -1, "dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.LicensePlateSection.<anonymous>.<anonymous> (EarlyCheckInScreen.kt:449)");
                    }
                    String str = errorMessage;
                    if (str == null) {
                        str = BuildConfig.FLAVOR;
                    }
                    m2295copyp1EtxEg = r3.m2295copyp1EtxEg((r48 & 1) != 0 ? r3.spanStyle.m2255getColor0d7_KjU() : AppColor.INSTANCE.m3272getSignalRed0d7_KjU(), (r48 & 2) != 0 ? r3.spanStyle.getFontSize() : 0L, (r48 & 4) != 0 ? r3.spanStyle.getFontWeight() : null, (r48 & 8) != 0 ? r3.spanStyle.getFontStyle() : null, (r48 & 16) != 0 ? r3.spanStyle.getFontSynthesis() : null, (r48 & 32) != 0 ? r3.spanStyle.getFontFamily() : null, (r48 & 64) != 0 ? r3.spanStyle.getFontFeatureSettings() : null, (r48 & 128) != 0 ? r3.spanStyle.getLetterSpacing() : 0L, (r48 & 256) != 0 ? r3.spanStyle.getBaselineShift() : null, (r48 & 512) != 0 ? r3.spanStyle.getTextGeometricTransform() : null, (r48 & 1024) != 0 ? r3.spanStyle.getLocaleList() : null, (r48 & 2048) != 0 ? r3.spanStyle.getBackground() : 0L, (r48 & 4096) != 0 ? r3.spanStyle.getTextDecoration() : null, (r48 & 8192) != 0 ? r3.spanStyle.getShadow() : null, (r48 & 16384) != 0 ? r3.spanStyle.getDrawStyle() : null, (r48 & 32768) != 0 ? r3.paragraphStyle.getTextAlign() : 0, (r48 & 65536) != 0 ? r3.paragraphStyle.getTextDirection() : 0, (r48 & 131072) != 0 ? r3.paragraphStyle.getLineHeight() : 0L, (r48 & 262144) != 0 ? r3.paragraphStyle.getTextIndent() : null, (r48 & 524288) != 0 ? r3.platformStyle : null, (r48 & 1048576) != 0 ? r3.paragraphStyle.getLineHeightStyle() : null, (r48 & 2097152) != 0 ? r3.paragraphStyle.getLineBreak() : 0, (r48 & 4194304) != 0 ? r3.paragraphStyle.getHyphens() : 0, (r48 & 8388608) != 0 ? TypographyKt.getSub().paragraphStyle.getTextMotion() : null);
                    TextKt.m940Text4IGK_g(str, PaddingKt.m315paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m2599constructorimpl(8), 0.0f, 0.0f, 13, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, m2295copyp1EtxEg, composer3, 48, 0, 65532);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), composer2, 1572870, 28);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: q4.p
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit LicensePlateSection$lambda$30;
                    LicensePlateSection$lambda$30 = EarlyCheckInScreenKt.LicensePlateSection$lambda$30(UserVehicle.this, formValidator, function0, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return LicensePlateSection$lambda$30;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LicensePlateSection$lambda$29$lambda$28$lambda$27(SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        SemanticsPropertiesKt.m2183setLiveRegionhR3wRGc(semantics, LiveRegionMode.INSTANCE.m2161getAssertive0phEisY());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LicensePlateSection$lambda$30(UserVehicle userVehicle, FormValidator formValidator, Function0 function0, int i5, Composer composer, int i6) {
        LicensePlateSection(userVehicle, formValidator, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    private static final void addonsSection(LazyGridScope lazyGridScope, Booking booking, final SimpleChangeCheckoutManager.SimpleChangeCheckoutState simpleChangeCheckoutState, final Function0<Unit> function0) {
        List<LineItem> products = booking.getTicket().getProducts();
        ArrayList arrayList = new ArrayList();
        for (Object obj : products) {
            if (((LineItem) obj).getProductType() != ProductType.Catering) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            LazyGridScope.item$default(lazyGridScope, null, new Function1() { // from class: q4.q
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    GridItemSpan addonsSection$lambda$22;
                    addonsSection$lambda$22 = EarlyCheckInScreenKt.addonsSection$lambda$22((LazyGridItemSpanScope) obj2);
                    return addonsSection$lambda$22;
                }
            }, null, ComposableLambdaKt.composableLambdaInstance(274757773, true, new Function3<LazyGridItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.EarlyCheckInScreenKt$addonsSection$2
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(LazyGridItemScope lazyGridItemScope, Composer composer, Integer num) {
                    invoke(lazyGridItemScope, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(LazyGridItemScope item, Composer composer, int i5) {
                    Intrinsics.checkNotNullParameter(item, "$this$item");
                    if ((i5 & 17) == 16 && composer.getSkipping()) {
                        composer.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(274757773, i5, -1, "dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.addonsSection.<anonymous> (EarlyCheckInScreen.kt:332)");
                    }
                    if (SimpleChangeCheckoutManager.SimpleChangeCheckoutState.this.getAddons().isEmpty()) {
                        composer.startReplaceGroup(-2110732457);
                        EarlyCheckInScreenKt.AddonBanner(R.drawable.icon_food_image_missing, StringResources_androidKt.stringResource(R.string.earlyCheckIn_addonBanner_addons_title, composer, 6), StringResources_androidKt.stringResource(R.string.earlyCheckIn_addonBanner_addons_button, composer, 6), function0, composer, 6);
                        composer.endReplaceGroup();
                    } else {
                        composer.startReplaceGroup(-2110315941);
                        SimpleChangeCheckoutManager.SimpleChangeCheckoutState simpleChangeCheckoutState2 = SimpleChangeCheckoutManager.SimpleChangeCheckoutState.this;
                        Function0<Unit> function02 = function0;
                        Modifier.Companion companion = Modifier.INSTANCE;
                        int i6 = 0;
                        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, companion);
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
                        ProductSectionKt.ProductSection(simpleChangeCheckoutState2.getAddons(), null, true, function02, false, true, true, composer, 1794480, 0);
                        PriceWithCurrency price = ((Product) CollectionsKt.first((List) simpleChangeCheckoutState2.getAddons())).getPrice();
                        Iterator<T> it = simpleChangeCheckoutState2.getAddons().iterator();
                        while (it.hasNext()) {
                            i6 += ((Product) it.next()).sum().getValue();
                        }
                        PriceDetailsViewKt.TotalPriceRow(new PriceTotal(PriceWithCurrency.copy$default(price, i6, null, 2, null)), TypographyKt.getSub(), false, null, composer, 48, 12);
                        composer.endNode();
                        composer.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), 5, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GridItemSpan addonsSection$lambda$22(LazyGridItemSpanScope item) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        return GridItemSpan.m380boximpl(LazyGridSpanKt.GridItemSpan(item.getMaxLineSpan()));
    }

    private static final void foodSection(LazyGridScope lazyGridScope, Booking booking, final SimpleChangeCheckoutManager.SimpleChangeCheckoutState simpleChangeCheckoutState, final Function0<Unit> function0) {
        List<LineItem> products = booking.getTicket().getProducts();
        ArrayList arrayList = new ArrayList();
        for (Object obj : products) {
            if (((LineItem) obj).getProductType() == ProductType.Catering) {
                arrayList.add(obj);
            }
        }
        List<LineItem> products2 = booking.getTicket().getProducts();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : products2) {
            if (((LineItem) obj2).getProductType() != ProductType.Catering) {
                arrayList2.add(obj2);
            }
        }
        if (!simpleChangeCheckoutState.getFood().isEmpty()) {
            LazyGridScope.item$default(lazyGridScope, null, new Function1() { // from class: q4.b
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj3) {
                    GridItemSpan foodSection$lambda$18;
                    foodSection$lambda$18 = EarlyCheckInScreenKt.foodSection$lambda$18((LazyGridItemSpanScope) obj3);
                    return foodSection$lambda$18;
                }
            }, null, ComposableSingletons$EarlyCheckInScreenKt.INSTANCE.m3546getLambda3$app_kombardoProd(), 5, null);
        }
        if (arrayList.isEmpty()) {
            LazyGridScope.item$default(lazyGridScope, null, new Function1() { // from class: q4.c
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj3) {
                    GridItemSpan foodSection$lambda$19;
                    foodSection$lambda$19 = EarlyCheckInScreenKt.foodSection$lambda$19((LazyGridItemSpanScope) obj3);
                    return foodSection$lambda$19;
                }
            }, null, ComposableLambdaKt.composableLambdaInstance(721629881, true, new Function3<LazyGridItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.EarlyCheckInScreenKt$foodSection$3
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(LazyGridItemScope lazyGridItemScope, Composer composer, Integer num) {
                    invoke(lazyGridItemScope, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(LazyGridItemScope item, Composer composer, int i5) {
                    Intrinsics.checkNotNullParameter(item, "$this$item");
                    if ((i5 & 17) == 16 && composer.getSkipping()) {
                        composer.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(721629881, i5, -1, "dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.foodSection.<anonymous> (EarlyCheckInScreen.kt:289)");
                    }
                    if (SimpleChangeCheckoutManager.SimpleChangeCheckoutState.this.getFood().isEmpty()) {
                        composer.startReplaceGroup(737448134);
                        EarlyCheckInScreenKt.AddonBanner(R.drawable.icon_food_image_missing, StringResources_androidKt.stringResource(R.string.earlyCheckIn_addonBanner_food_morning, composer, 6), StringResources_androidKt.stringResource(R.string.earlyCheckIn_addonBanner_food_button, composer, 6), function0, composer, 6);
                        composer.endReplaceGroup();
                    } else {
                        composer.startReplaceGroup(737858915);
                        SimpleChangeCheckoutManager.SimpleChangeCheckoutState simpleChangeCheckoutState2 = SimpleChangeCheckoutManager.SimpleChangeCheckoutState.this;
                        Function0<Unit> function02 = function0;
                        Modifier.Companion companion = Modifier.INSTANCE;
                        int i6 = 0;
                        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, companion);
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
                        FoodSectionKt.FoodSection(simpleChangeCheckoutState2.getFood(), true, function02, false, true, true, composer, 224304, 0);
                        PriceWithCurrency price = ((Product) CollectionsKt.first((List) simpleChangeCheckoutState2.getFood())).getPrice();
                        Iterator<T> it = simpleChangeCheckoutState2.getFood().iterator();
                        while (it.hasNext()) {
                            i6 += ((Product) it.next()).sum().getValue();
                        }
                        PriceDetailsViewKt.TotalPriceRow(new PriceTotal(PriceWithCurrency.copy$default(price, i6, null, 2, null)), TypographyKt.getSub(), false, null, composer, 48, 12);
                        composer.endNode();
                        composer.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), 5, null);
        }
        if (!arrayList2.isEmpty() || simpleChangeCheckoutState.getFood().isEmpty()) {
            return;
        }
        LazyGridScope.item$default(lazyGridScope, null, new Function1() { // from class: q4.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj3) {
                GridItemSpan foodSection$lambda$20;
                foodSection$lambda$20 = EarlyCheckInScreenKt.foodSection$lambda$20((LazyGridItemSpanScope) obj3);
                return foodSection$lambda$20;
            }
        }, null, ComposableSingletons$EarlyCheckInScreenKt.INSTANCE.m3547getLambda4$app_kombardoProd(), 5, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GridItemSpan foodSection$lambda$18(LazyGridItemSpanScope item) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        return GridItemSpan.m380boximpl(LazyGridSpanKt.GridItemSpan(item.getMaxLineSpan()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GridItemSpan foodSection$lambda$19(LazyGridItemSpanScope item) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        return GridItemSpan.m380boximpl(LazyGridSpanKt.GridItemSpan(item.getMaxLineSpan()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GridItemSpan foodSection$lambda$20(LazyGridItemSpanScope item) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        return GridItemSpan.m380boximpl(LazyGridSpanKt.GridItemSpan(item.getMaxLineSpan()));
    }

    private static final void passengersSection(LazyGridScope lazyGridScope, final List<BookingPassenger> list, final Function0<Unit> function0, final boolean z5, MutableState<Boolean> mutableState, MutableState<Integer> mutableState2, boolean z6) {
        LazyGridScope.item$default(lazyGridScope, null, new Function1() { // from class: q4.r
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                GridItemSpan passengersSection$lambda$23;
                passengersSection$lambda$23 = EarlyCheckInScreenKt.passengersSection$lambda$23((LazyGridItemSpanScope) obj);
                return passengersSection$lambda$23;
            }
        }, null, ComposableLambdaKt.composableLambdaInstance(-625049872, true, new Function3<LazyGridItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.EarlyCheckInScreenKt$passengersSection$2
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(LazyGridItemScope lazyGridItemScope, Composer composer, Integer num) {
                invoke(lazyGridItemScope, composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyGridItemScope item, Composer composer, int i5) {
                Intrinsics.checkNotNullParameter(item, "$this$item");
                if ((i5 & 17) == 16 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-625049872, i5, -1, "dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.passengersSection.<anonymous> (EarlyCheckInScreen.kt:370)");
                }
                int size = list.size();
                String stringResource = StringResources_androidKt.stringResource(R.string.earlyCheckIn_confirmPassengers, new Object[]{Integer.valueOf(size)}, composer, 6);
                int indexOf$default = StringsKt.indexOf$default((CharSequence) stringResource, String.valueOf(size), 0, false, 6, (Object) null);
                EarlyCheckInScreenKt.HeaderRow(new AnnotatedString(stringResource, CollectionsKt.mutableListOf(new AnnotatedString.Range(new SpanStyle(AppColor.INSTANCE.m3255getBrandBlue10d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, null, 65534, null), indexOf$default, String.valueOf(size).length() + indexOf$default)), null, 4, null), function0, composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), 5, null);
        if (z6) {
            LazyGridScope.item$default(lazyGridScope, null, new Function1() { // from class: q4.s
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    GridItemSpan passengersSection$lambda$24;
                    passengersSection$lambda$24 = EarlyCheckInScreenKt.passengersSection$lambda$24((LazyGridItemSpanScope) obj);
                    return passengersSection$lambda$24;
                }
            }, null, ComposableSingletons$EarlyCheckInScreenKt.INSTANCE.m3548getLambda5$app_kombardoProd(), 5, null);
        }
        for (final BookingPassenger bookingPassenger : CollectionsKt.take(list, mutableState.getValue().booleanValue() ? list.size() : mutableState2.getValue().intValue())) {
            LazyGridScope.item$default(lazyGridScope, null, null, null, ComposableLambdaKt.composableLambdaInstance(698815054, true, new Function3<LazyGridItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.EarlyCheckInScreenKt$passengersSection$4
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(LazyGridItemScope lazyGridItemScope, Composer composer, Integer num) {
                    invoke(lazyGridItemScope, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(LazyGridItemScope item, Composer composer, int i5) {
                    Intrinsics.checkNotNullParameter(item, "$this$item");
                    if ((i5 & 17) == 16 && composer.getSkipping()) {
                        composer.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(698815054, i5, -1, "dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.passengersSection.<anonymous> (EarlyCheckInScreen.kt:394)");
                    }
                    CheckoutPassengerPortraitSimpleKt.PassengerPortraitSimple(BookingPassenger.this, z5, composer, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), 7, null);
        }
        if (list.size() > mutableState2.getValue().intValue()) {
            LazyGridScope.item$default(lazyGridScope, null, new Function1() { // from class: q4.t
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    GridItemSpan passengersSection$lambda$25;
                    passengersSection$lambda$25 = EarlyCheckInScreenKt.passengersSection$lambda$25((LazyGridItemSpanScope) obj);
                    return passengersSection$lambda$25;
                }
            }, null, ComposableLambdaKt.composableLambdaInstance(-1998984994, true, new EarlyCheckInScreenKt$passengersSection$6(mutableState)), 5, null);
        } else {
            LazyGridScope.item$default(lazyGridScope, null, new Function1() { // from class: q4.u
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    GridItemSpan passengersSection$lambda$26;
                    passengersSection$lambda$26 = EarlyCheckInScreenKt.passengersSection$lambda$26((LazyGridItemSpanScope) obj);
                    return passengersSection$lambda$26;
                }
            }, null, ComposableSingletons$EarlyCheckInScreenKt.INSTANCE.m3549getLambda6$app_kombardoProd(), 5, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GridItemSpan passengersSection$lambda$23(LazyGridItemSpanScope item) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        return GridItemSpan.m380boximpl(LazyGridSpanKt.GridItemSpan(item.getMaxLineSpan()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GridItemSpan passengersSection$lambda$24(LazyGridItemSpanScope item) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        return GridItemSpan.m380boximpl(LazyGridSpanKt.GridItemSpan(item.getMaxLineSpan()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GridItemSpan passengersSection$lambda$25(LazyGridItemSpanScope item) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        return GridItemSpan.m380boximpl(LazyGridSpanKt.GridItemSpan(item.getMaxLineSpan()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GridItemSpan passengersSection$lambda$26(LazyGridItemSpanScope item) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        return GridItemSpan.m380boximpl(LazyGridSpanKt.GridItemSpan(item.getMaxLineSpan()));
    }
}
