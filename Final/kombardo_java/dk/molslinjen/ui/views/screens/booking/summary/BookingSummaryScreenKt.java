package dk.molslinjen.ui.views.screens.booking.summary;

import android.content.Context;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
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
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.IconKt;
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
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.LiveRegionMode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import com.ramcosta.composedestinations.generated.destinations.DeparturesReturnScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.PaymentScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.PhoneNumberCodeSelectionScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.VehicleSelectorScreenDestination;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import com.ramcosta.composedestinations.result.OpenResultRecipientKt;
import com.ramcosta.composedestinations.result.ResultRecipient;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.domain.managers.checkout.CheckoutManager;
import dk.molslinjen.domain.managers.checkout.EditManager;
import dk.molslinjen.domain.managers.checkout.PriceDetails;
import dk.molslinjen.domain.managers.checkout.PriceTotal;
import dk.molslinjen.domain.managers.checkout.SummaryAddonHelper;
import dk.molslinjen.domain.model.account.CreditCard;
import dk.molslinjen.domain.model.account.UserVehicle;
import dk.molslinjen.domain.model.booking.BookingPassenger;
import dk.molslinjen.domain.model.booking.BookingType;
import dk.molslinjen.domain.model.booking.Departure;
import dk.molslinjen.domain.model.booking.DepartureDirection;
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
import dk.molslinjen.domain.model.payment.PaymentOrigin;
import dk.molslinjen.domain.model.payment.PaymentType;
import dk.molslinjen.domain.model.shared.PhoneNumber;
import dk.molslinjen.domain.model.shared.Price;
import dk.molslinjen.extensions.ModifierExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.HorizontalDividerKt;
import dk.molslinjen.ui.views.reusable.buttons.OutlineDashedButtonKt;
import dk.molslinjen.ui.views.reusable.input.licensePlate.LicensePlateButtonKt;
import dk.molslinjen.ui.views.reusable.input.validation.FormValidator;
import dk.molslinjen.ui.views.reusable.input.validation.IFormValidator;
import dk.molslinjen.ui.views.reusable.input.validation.InputValidationError;
import dk.molslinjen.ui.views.reusable.input.validation.validators.EmailInputValidator;
import dk.molslinjen.ui.views.reusable.input.validation.validators.NonEmptyStringValidator;
import dk.molslinjen.ui.views.reusable.input.validation.validators.PhoneNumberInputValidator;
import dk.molslinjen.ui.views.reusable.input.validation.validators.RequiredBooleanCustomValidator;
import dk.molslinjen.ui.views.screens.booking.addons.MultipleAddonsViewKt;
import dk.molslinjen.ui.views.screens.booking.shared.FanoeReturnInfoViewKt;
import dk.molslinjen.ui.views.screens.booking.summary.BookingSummaryScreenKt;
import dk.molslinjen.ui.views.screens.booking.summary.BookingSummaryViewModel;
import dk.molslinjen.ui.views.screens.config.regular.checkout.helpers.ICheckoutExpirationDialogHandler;
import dk.molslinjen.ui.views.shared.components.PriceTextKt;
import dk.molslinjen.ui.views.shared.components.PriceViewType;
import dk.molslinjen.ui.views.shared.ticket.ticketSummary.TicketSummaryViewKt;
import java.util.Collection;
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
import kotlin.reflect.KFunction;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u001aO\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u000e\u0010\u000f\u001aÍ\u0002\u00107\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\r0\u001d2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\r0\u001d2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\r0\u001d2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\r0\u001d2\u001a\u0010%\u001a\u0016\u0012\u0004\u0012\u00020#\u0012\u0006\u0012\u0004\u0018\u00010$\u0012\u0004\u0012\u00020\r0\"2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\r0\u001d2\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\r0'2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0'2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0'2\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\r0'2\u001e\u00102\u001a\u001a\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\r0.2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\r0\u001d2\f\u00104\u001a\b\u0012\u0004\u0012\u00020\r0\u001d2\f\u00105\u001a\b\u0012\u0004\u0012\u00020\r0\u001d2\u0006\u00106\u001a\u00020,H\u0003¢\u0006\u0004\b7\u00108\u001aK\u0010:\u001a\u00020\r*\u0002092\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0018\u001a\u00020\u00172\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\r0\u001d2\u0006\u00106\u001a\u00020,H\u0002¢\u0006\u0004\b:\u0010;\u001a\u0017\u0010>\u001a\u00020\r2\u0006\u0010=\u001a\u00020<H\u0003¢\u0006\u0004\b>\u0010?\u001aE\u0010C\u001a\u00020\r2\b\u0010@\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010B\u001a\u00020A2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\r0\u001d2\f\u00104\u001a\b\u0012\u0004\u0012\u00020\r0\u001dH\u0003¢\u0006\u0004\bC\u0010D\u001a\u001d\u0010E\u001a\u00020\r2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\r0\u001dH\u0003¢\u0006\u0004\bE\u0010F\u001a\u001d\u0010G\u001a\u00020\r2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\r0\u001dH\u0003¢\u0006\u0004\bG\u0010F\u001a\u000f\u0010H\u001a\u00020\rH\u0003¢\u0006\u0004\bH\u0010I¨\u0006J"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/summary/BookingSummaryViewModel;", "viewModel", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "navigator", "Lcom/ramcosta/composedestinations/result/ResultRecipient;", "Lcom/ramcosta/composedestinations/generated/destinations/PhoneNumberCodeSelectionScreenDestination;", BuildConfig.FLAVOR, "phoneNumberCodeResultRecipient", "Lcom/ramcosta/composedestinations/generated/destinations/VehicleSelectorScreenDestination;", "Ldk/molslinjen/domain/model/account/UserVehicle;", "vehicleSelectorResultRecipient", "Ldk/molslinjen/ui/views/screens/config/regular/checkout/helpers/ICheckoutExpirationDialogHandler;", "checkoutExpirationDialogHandler", BuildConfig.FLAVOR, "BookingSummaryScreen", "(Ldk/molslinjen/ui/views/screens/booking/summary/BookingSummaryViewModel;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Lcom/ramcosta/composedestinations/result/ResultRecipient;Lcom/ramcosta/composedestinations/result/ResultRecipient;Ldk/molslinjen/ui/views/screens/config/regular/checkout/helpers/ICheckoutExpirationDialogHandler;Landroidx/compose/runtime/Composer;I)V", "Ldk/molslinjen/ui/views/screens/booking/summary/BookingSummaryViewModel$ViewState;", "state", "Ldk/molslinjen/domain/managers/checkout/CheckoutManager$CheckoutState;", "checkoutState", "Ldk/molslinjen/domain/managers/checkout/CheckoutManager$CheckoutDirectionState;", "outboundCheckoutState", "returnCheckoutState", "Ldk/molslinjen/domain/managers/checkout/EditManager$EditState;", "editState", "Ldk/molslinjen/domain/managers/checkout/SummaryAddonHelper$SummaryAddonState;", "summaryAddonState", "Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator;", "validator", "Lkotlin/Function0;", "toggleNewsletterSignup", "toggleAcceptMarketing", "addReturnTrip", "proceed", "Lkotlin/Function2;", "Ldk/molslinjen/domain/model/payment/PaymentType;", "Ldk/molslinjen/domain/model/account/CreditCard;", "paymentMethodSelected", "showVehiclePickerDialog", "Lkotlin/Function1;", "Ldk/molslinjen/domain/model/shared/PhoneNumber;", "onPhoneNumberChange", "onEmailChange", "onPostalCodeChange", BuildConfig.FLAVOR, "onEarlyCheckInChange", "Lkotlin/Function3;", "Ldk/molslinjen/domain/model/booking/DepartureDirection;", "Ldk/molslinjen/domain/model/booking/product/Product;", BuildConfig.FLAVOR, "onProductQuantityChanged", "startPersonalInfoEdit", "clearSelectedVehicle", "showPhoneNumberCodeSelector", "highlightReturnTicketButton", "BookingSummaryContent", "(Ldk/molslinjen/ui/views/screens/booking/summary/BookingSummaryViewModel$ViewState;Ldk/molslinjen/domain/managers/checkout/CheckoutManager$CheckoutState;Ldk/molslinjen/domain/managers/checkout/CheckoutManager$CheckoutDirectionState;Ldk/molslinjen/domain/managers/checkout/CheckoutManager$CheckoutDirectionState;Ldk/molslinjen/domain/managers/checkout/EditManager$EditState;Ldk/molslinjen/domain/managers/checkout/SummaryAddonHelper$SummaryAddonState;Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;III)V", "Landroidx/compose/foundation/lazy/LazyListScope;", "ticketSummaryViews", "(Landroidx/compose/foundation/lazy/LazyListScope;Ldk/molslinjen/domain/managers/checkout/CheckoutManager$CheckoutState;Ldk/molslinjen/domain/managers/checkout/CheckoutManager$CheckoutDirectionState;Ldk/molslinjen/domain/managers/checkout/CheckoutManager$CheckoutDirectionState;Ldk/molslinjen/domain/managers/checkout/EditManager$EditState;Lkotlin/jvm/functions/Function0;Z)V", "Ldk/molslinjen/domain/managers/checkout/PriceTotal;", "totalPrice", "TotalPriceRow", "(Ldk/molslinjen/domain/managers/checkout/PriceTotal;Landroidx/compose/runtime/Composer;I)V", "selectedVehicle", "Ldk/molslinjen/domain/model/config/Transportation;", "transportation", "LicensePlateSection", "(Ldk/molslinjen/domain/model/account/UserVehicle;Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator;Ldk/molslinjen/domain/model/config/Transportation;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "AddReturnTicketButton", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "HighlightedAddReturnTicketButton", "Splitter", "(Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class BookingSummaryScreenKt {
    public static final void AddReturnTicketButton(final Function0<Unit> function0, Composer composer, final int i5) {
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(219599100);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(function0) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i6 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(219599100, i6, -1, "dk.molslinjen.ui.views.screens.booking.summary.AddReturnTicketButton (BookingSummaryScreen.kt:515)");
            }
            OutlineDashedButtonKt.m3405OutlineDashedButtonEMNEwkI(Modifier.INSTANCE, StringResources_androidKt.stringResource(R.string.bookingSummary_addReturnTrip, startRestartGroup, 6), R.drawable.icon_plus_circled, AppColor.INSTANCE.m3269getGrey60d7_KjU(), 0L, 0L, function0, startRestartGroup, ((i6 << 18) & 3670016) | 3462, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: h3.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit AddReturnTicketButton$lambda$41;
                    AddReturnTicketButton$lambda$41 = BookingSummaryScreenKt.AddReturnTicketButton$lambda$41(Function0.this, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return AddReturnTicketButton$lambda$41;
                }
            });
        }
    }

    public static final Unit AddReturnTicketButton$lambda$41(Function0 function0, int i5, Composer composer, int i6) {
        AddReturnTicketButton(function0, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    private static final void BookingSummaryContent(final BookingSummaryViewModel.ViewState viewState, final CheckoutManager.CheckoutState checkoutState, final CheckoutManager.CheckoutDirectionState checkoutDirectionState, final CheckoutManager.CheckoutDirectionState checkoutDirectionState2, final EditManager.EditState editState, final SummaryAddonHelper.SummaryAddonState summaryAddonState, final IFormValidator iFormValidator, final Function0<Unit> function0, final Function0<Unit> function02, final Function0<Unit> function03, final Function0<Unit> function04, final Function2<? super PaymentType, ? super CreditCard, Unit> function2, final Function0<Unit> function05, final Function1<? super PhoneNumber, Unit> function1, final Function1<? super String, Unit> function12, final Function1<? super String, Unit> function13, final Function1<? super Boolean, Unit> function14, final Function3<? super DepartureDirection, ? super Product, ? super Integer, Unit> function3, final Function0<Unit> function06, final Function0<Unit> function07, final Function0<Unit> function08, final boolean z5, Composer composer, final int i5, final int i6, final int i7) {
        int i8;
        int i9;
        int i10;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-1060473322);
        if ((i5 & 6) == 0) {
            i8 = (startRestartGroup.changedInstance(viewState) ? 4 : 2) | i5;
        } else {
            i8 = i5;
        }
        if ((i5 & 48) == 0) {
            i8 |= startRestartGroup.changedInstance(checkoutState) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i8 |= startRestartGroup.changedInstance(checkoutDirectionState) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i8 |= startRestartGroup.changedInstance(checkoutDirectionState2) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i8 |= startRestartGroup.changedInstance(editState) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i8 |= startRestartGroup.changedInstance(summaryAddonState) ? 131072 : 65536;
        }
        if ((1572864 & i5) == 0) {
            i8 |= (2097152 & i5) == 0 ? startRestartGroup.changed(iFormValidator) : startRestartGroup.changedInstance(iFormValidator) ? 1048576 : 524288;
        }
        if ((12582912 & i5) == 0) {
            i8 |= startRestartGroup.changedInstance(function0) ? 8388608 : 4194304;
        }
        if ((i5 & 100663296) == 0) {
            i8 |= startRestartGroup.changedInstance(function02) ? 67108864 : 33554432;
        }
        if ((i5 & 805306368) == 0) {
            i8 |= startRestartGroup.changedInstance(function03) ? 536870912 : 268435456;
        }
        if ((i6 & 6) == 0) {
            i9 = i6 | (startRestartGroup.changedInstance(function04) ? 4 : 2);
        } else {
            i9 = i6;
        }
        if ((i6 & 48) == 0) {
            i9 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i6 & 384) == 0) {
            i9 |= startRestartGroup.changedInstance(function05) ? 256 : 128;
        }
        if ((i6 & 3072) == 0) {
            i9 |= startRestartGroup.changedInstance(function1) ? 2048 : 1024;
        }
        if ((i6 & 24576) == 0) {
            i9 |= startRestartGroup.changedInstance(function12) ? 16384 : 8192;
        }
        if ((i6 & 196608) == 0) {
            i9 |= startRestartGroup.changedInstance(function13) ? 131072 : 65536;
        }
        if ((i6 & 1572864) == 0) {
            i9 |= startRestartGroup.changedInstance(function14) ? 1048576 : 524288;
        }
        if ((i6 & 12582912) == 0) {
            i9 |= startRestartGroup.changedInstance(function3) ? 8388608 : 4194304;
        }
        if ((i6 & 100663296) == 0) {
            i9 |= startRestartGroup.changedInstance(function06) ? 67108864 : 33554432;
        }
        if ((i6 & 805306368) == 0) {
            i9 |= startRestartGroup.changedInstance(function07) ? 536870912 : 268435456;
        }
        int i11 = i9;
        if ((i7 & 6) == 0) {
            i10 = i7 | (startRestartGroup.changedInstance(function08) ? 4 : 2);
        } else {
            i10 = i7;
        }
        if ((i7 & 48) == 0) {
            i10 |= startRestartGroup.changed(z5) ? 32 : 16;
        }
        int i12 = i10;
        if ((i8 & 306783379) == 306783378 && (306783379 & i11) == 306783378 && (i12 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1060473322, i8, i11, "dk.molslinjen.ui.views.screens.booking.summary.BookingSummaryContent (BookingSummaryScreen.kt:208)");
            }
            Object[] objArr = new Object[0];
            startRestartGroup.startReplaceGroup(1395110339);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: h3.c
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        MutableState BookingSummaryContent$lambda$29$lambda$28;
                        BookingSummaryContent$lambda$29$lambda$28 = BookingSummaryScreenKt.BookingSummaryContent$lambda$29$lambda$28();
                        return BookingSummaryContent$lambda$29$lambda$28;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            final MutableState mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr, null, null, (Function0) rememberedValue, startRestartGroup, 3072, 6);
            Modifier m313paddingVpY3zN4$default = PaddingKt.m313paddingVpY3zN4$default(BackgroundKt.m104backgroundbw27NRU$default(ModifierExtensionsKt.closeKeyboardOnClickOutside(SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), (FocusManager) startRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager())), AppColor.INSTANCE.m3269getGrey60d7_KjU(), null, 2, null), Dp.m2599constructorimpl(16), 0.0f, 2, null);
            PaddingValues m310PaddingValuesa9UjIt4$default = PaddingKt.m310PaddingValuesa9UjIt4$default(0.0f, Dp.m2599constructorimpl(24), 0.0f, Dp.m2599constructorimpl(40), 5, null);
            Arrangement.HorizontalOrVertical m265spacedBy0680j_4 = Arrangement.INSTANCE.m265spacedBy0680j_4(Dp.m2599constructorimpl(32));
            startRestartGroup.startReplaceGroup(1395126632);
            boolean changedInstance = ((i8 & 234881024) == 67108864) | startRestartGroup.changedInstance(checkoutState) | startRestartGroup.changedInstance(checkoutDirectionState) | startRestartGroup.changedInstance(checkoutDirectionState2) | startRestartGroup.changedInstance(editState) | ((1879048192 & i8) == 536870912) | ((i12 & 112) == 32) | startRestartGroup.changedInstance(summaryAddonState) | ((29360128 & i11) == 8388608) | startRestartGroup.changedInstance(viewState) | ((3670016 & i8) == 1048576 || ((2097152 & i8) != 0 && startRestartGroup.changedInstance(iFormValidator))) | ((i11 & 7168) == 2048) | ((57344 & i11) == 16384) | ((458752 & i11) == 131072) | ((234881024 & i11) == 67108864) | ((i12 & 14) == 4) | ((i11 & 896) == 256) | ((1879048192 & i11) == 536870912) | ((i11 & 112) == 32) | startRestartGroup.changed(mutableState) | ((29360128 & i8) == 8388608) | ((3670016 & i11) == 1048576) | ((i11 & 14) == 4);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue2 == companion.getEmpty()) {
                composer2 = startRestartGroup;
                rememberedValue2 = new Function1() { // from class: h3.d
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit BookingSummaryContent$lambda$31$lambda$30;
                        BookingSummaryContent$lambda$31$lambda$30 = BookingSummaryScreenKt.BookingSummaryContent$lambda$31$lambda$30(CheckoutManager.CheckoutState.this, checkoutDirectionState, checkoutDirectionState2, editState, function03, z5, summaryAddonState, function3, viewState, iFormValidator, function1, function12, function13, function06, function08, function05, function07, function2, mutableState, function0, function02, function14, function04, (LazyListScope) obj);
                        return BookingSummaryContent$lambda$31$lambda$30;
                    }
                };
                composer2.updateRememberedValue(rememberedValue2);
            } else {
                composer2 = startRestartGroup;
            }
            composer2.endReplaceGroup();
            LazyDslKt.LazyColumn(m313paddingVpY3zN4$default, null, m310PaddingValuesa9UjIt4$default, false, m265spacedBy0680j_4, null, null, false, (Function1) rememberedValue2, composer2, 24960, 234);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: h3.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit BookingSummaryContent$lambda$32;
                    BookingSummaryContent$lambda$32 = BookingSummaryScreenKt.BookingSummaryContent$lambda$32(BookingSummaryViewModel.ViewState.this, checkoutState, checkoutDirectionState, checkoutDirectionState2, editState, summaryAddonState, iFormValidator, function0, function02, function03, function04, function2, function05, function1, function12, function13, function14, function3, function06, function07, function08, z5, i5, i6, i7, (Composer) obj, ((Integer) obj2).intValue());
                    return BookingSummaryContent$lambda$32;
                }
            });
        }
    }

    public static final MutableState BookingSummaryContent$lambda$29$lambda$28() {
        MutableState mutableStateOf$default;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        return mutableStateOf$default;
    }

    public static final Unit BookingSummaryContent$lambda$31$lambda$30(final CheckoutManager.CheckoutState checkoutState, CheckoutManager.CheckoutDirectionState checkoutDirectionState, CheckoutManager.CheckoutDirectionState checkoutDirectionState2, EditManager.EditState editState, Function0 function0, boolean z5, final SummaryAddonHelper.SummaryAddonState summaryAddonState, final Function3 function3, final BookingSummaryViewModel.ViewState viewState, final IFormValidator iFormValidator, final Function1 function1, final Function1 function12, final Function1 function13, final Function0 function02, final Function0 function03, final Function0 function04, final Function0 function05, final Function2 function2, MutableState mutableState, Function0 function06, Function0 function07, Function1 function14, Function0 function08, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        ticketSummaryViews(LazyColumn, checkoutState, checkoutDirectionState, checkoutDirectionState2, editState, function0, z5);
        if (!summaryAddonState.getOutboundProducts().isEmpty() || !summaryAddonState.getReturnProducts().isEmpty()) {
            LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-1445741627, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.summary.BookingSummaryScreenKt$BookingSummaryContent$1$1$1
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
                        ComposerKt.traceEventStart(-1445741627, i5, -1, "dk.molslinjen.ui.views.screens.booking.summary.BookingSummaryContent.<anonymous>.<anonymous>.<anonymous> (BookingSummaryScreen.kt:231)");
                    }
                    TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.bookingSummary_addonProducts, composer, 6), PaddingKt.m315paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m2599constructorimpl(16), 7, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphBold(), composer, 48, 1572864, 65532);
                    MultipleAddonsViewKt.MultipleAddonsView(CheckoutManager.CheckoutState.this.getBookingType() == BookingType.TwoWay, summaryAddonState.getOutboundProducts(), summaryAddonState.getReturnProducts(), function3, composer, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), 3, null);
            LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$BookingSummaryScreenKt.INSTANCE.m3469getLambda1$app_kombardoProd(), 3, null);
        }
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(1461005738, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.summary.BookingSummaryScreenKt$BookingSummaryContent$1$1$2
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
                    ComposerKt.traceEventStart(1461005738, i5, -1, "dk.molslinjen.ui.views.screens.booking.summary.BookingSummaryContent.<anonymous>.<anonymous>.<anonymous> (BookingSummaryScreen.kt:248)");
                }
                PersonalInfoSectionViewKt.PersonalInfoSection(checkoutState.getPersonalInfo(), iFormValidator, function1, function12, function13, function02, function03, BookingSummaryViewModel.ViewState.this.getPersonalInfoIsInEditMode(), composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), 3, null);
        ComposableSingletons$BookingSummaryScreenKt composableSingletons$BookingSummaryScreenKt = ComposableSingletons$BookingSummaryScreenKt.INSTANCE;
        LazyListScope.item$default(LazyColumn, null, null, composableSingletons$BookingSummaryScreenKt.m3470getLambda2$app_kombardoProd(), 3, null);
        if (checkoutState.getTransportation().getAllowLicensePlate()) {
            LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(1723655164, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.summary.BookingSummaryScreenKt$BookingSummaryContent$1$1$3
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
                        ComposerKt.traceEventStart(1723655164, i5, -1, "dk.molslinjen.ui.views.screens.booking.summary.BookingSummaryContent.<anonymous>.<anonymous>.<anonymous> (BookingSummaryScreen.kt:264)");
                    }
                    BookingSummaryScreenKt.LicensePlateSection(CheckoutManager.CheckoutState.this.getSelectedVehicle(), iFormValidator, CheckoutManager.CheckoutState.this.getTransportation(), function04, function05, composer, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), 3, null);
            LazyListScope.item$default(LazyColumn, null, null, composableSingletons$BookingSummaryScreenKt.m3471getLambda3$app_kombardoProd(), 3, null);
        }
        if (checkoutState.getPriceDetails().getTotalPrice().compareTo(0) > 0) {
            LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-1601709507, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.summary.BookingSummaryScreenKt$BookingSummaryContent$1$1$4
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
                        ComposerKt.traceEventStart(-1601709507, i5, -1, "dk.molslinjen.ui.views.screens.booking.summary.BookingSummaryContent.<anonymous>.<anonymous>.<anonymous> (BookingSummaryScreen.kt:278)");
                    }
                    PaymentMethodSectionViewKt.PaymentMethodSectionView(BookingSummaryViewModel.ViewState.this.getPaymentTypes(), BookingSummaryViewModel.ViewState.this.getSavedCreditCards(), checkoutState.getSelectedPaymentType(), checkoutState.getSelectedCreditCard(), function2, composer, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), 3, null);
            LazyListScope.item$default(LazyColumn, null, null, composableSingletons$BookingSummaryScreenKt.m3472getLambda4$app_kombardoProd(), 3, null);
        }
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(53765858, true, new BookingSummaryScreenKt$BookingSummaryContent$1$1$5(iFormValidator, viewState, mutableState, checkoutState, checkoutDirectionState, checkoutDirectionState2, function06, function07, function14, function08)), 3, null);
        return Unit.INSTANCE;
    }

    public static final Unit BookingSummaryContent$lambda$32(BookingSummaryViewModel.ViewState viewState, CheckoutManager.CheckoutState checkoutState, CheckoutManager.CheckoutDirectionState checkoutDirectionState, CheckoutManager.CheckoutDirectionState checkoutDirectionState2, EditManager.EditState editState, SummaryAddonHelper.SummaryAddonState summaryAddonState, IFormValidator iFormValidator, Function0 function0, Function0 function02, Function0 function03, Function0 function04, Function2 function2, Function0 function05, Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function3 function3, Function0 function06, Function0 function07, Function0 function08, boolean z5, int i5, int i6, int i7, Composer composer, int i8) {
        BookingSummaryContent(viewState, checkoutState, checkoutDirectionState, checkoutDirectionState2, editState, summaryAddonState, iFormValidator, function0, function02, function03, function04, function2, function05, function1, function12, function13, function14, function3, function06, function07, function08, z5, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), RecomposeScopeImplKt.updateChangedFlags(i6), RecomposeScopeImplKt.updateChangedFlags(i7));
        return Unit.INSTANCE;
    }

    public static final void BookingSummaryScreen(final BookingSummaryViewModel viewModel, final DestinationsNavigator navigator, final ResultRecipient<PhoneNumberCodeSelectionScreenDestination, String> phoneNumberCodeResultRecipient, final ResultRecipient<VehicleSelectorScreenDestination, UserVehicle> vehicleSelectorResultRecipient, final ICheckoutExpirationDialogHandler checkoutExpirationDialogHandler, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Intrinsics.checkNotNullParameter(phoneNumberCodeResultRecipient, "phoneNumberCodeResultRecipient");
        Intrinsics.checkNotNullParameter(vehicleSelectorResultRecipient, "vehicleSelectorResultRecipient");
        Intrinsics.checkNotNullParameter(checkoutExpirationDialogHandler, "checkoutExpirationDialogHandler");
        Composer startRestartGroup = composer.startRestartGroup(286704249);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewModel) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(navigator) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changed(phoneNumberCodeResultRecipient) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changed(vehicleSelectorResultRecipient) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= (32768 & i5) == 0 ? startRestartGroup.changed(checkoutExpirationDialogHandler) : startRestartGroup.changedInstance(checkoutExpirationDialogHandler) ? 16384 : 8192;
        }
        if ((i6 & 9363) == 9362 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(286704249, i6, -1, "dk.molslinjen.ui.views.screens.booking.summary.BookingSummaryScreen (BookingSummaryScreen.kt:108)");
            }
            int i7 = i6 & 112;
            int i8 = i6 >> 6;
            checkoutExpirationDialogHandler.HandleDepartureExpiration(viewModel, navigator, startRestartGroup, (i6 & 126) | (i8 & 896));
            startRestartGroup.startReplaceGroup(893636430);
            boolean changedInstance = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: h3.a
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit BookingSummaryScreen$lambda$1$lambda$0;
                        BookingSummaryScreen$lambda$1$lambda$0 = BookingSummaryScreenKt.BookingSummaryScreen$lambda$1$lambda$0(BookingSummaryViewModel.this, (UserVehicle) obj);
                        return BookingSummaryScreen$lambda$1$lambda$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            OpenResultRecipientKt.onResult(vehicleSelectorResultRecipient, null, (Function1) rememberedValue, startRestartGroup, (i6 >> 9) & 14, 1);
            startRestartGroup.startReplaceGroup(893639502);
            boolean changedInstance2 = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: h3.l
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit BookingSummaryScreen$lambda$3$lambda$2;
                        BookingSummaryScreen$lambda$3$lambda$2 = BookingSummaryScreenKt.BookingSummaryScreen$lambda$3$lambda$2(BookingSummaryViewModel.this, (String) obj);
                        return BookingSummaryScreen$lambda$3$lambda$2;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            OpenResultRecipientKt.onResult(phoneNumberCodeResultRecipient, null, (Function1) rememberedValue2, startRestartGroup, i8 & 14, 1);
            BookingSummaryViewModel.ViewState viewState = (BookingSummaryViewModel.ViewState) SnapshotStateKt.collectAsState(viewModel.getViewState(), null, startRestartGroup, 0, 1).getValue();
            final CheckoutManager.CheckoutState checkoutState = (CheckoutManager.CheckoutState) SnapshotStateKt.collectAsState(viewModel.getCheckoutState(), null, startRestartGroup, 0, 1).getValue();
            if (checkoutState == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: h3.m
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit BookingSummaryScreen$lambda$4;
                            BookingSummaryScreen$lambda$4 = BookingSummaryScreenKt.BookingSummaryScreen$lambda$4(BookingSummaryViewModel.this, navigator, phoneNumberCodeResultRecipient, vehicleSelectorResultRecipient, checkoutExpirationDialogHandler, i5, (Composer) obj, ((Integer) obj2).intValue());
                            return BookingSummaryScreen$lambda$4;
                        }
                    });
                    return;
                }
                return;
            }
            final CheckoutManager.CheckoutDirectionState checkoutDirectionState = (CheckoutManager.CheckoutDirectionState) SnapshotStateKt.collectAsState(viewModel.getOutboundCheckoutState(), null, startRestartGroup, 0, 1).getValue();
            if (checkoutDirectionState == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup2 = startRestartGroup.endRestartGroup();
                if (endRestartGroup2 != null) {
                    endRestartGroup2.updateScope(new Function2() { // from class: h3.n
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit BookingSummaryScreen$lambda$5;
                            BookingSummaryScreen$lambda$5 = BookingSummaryScreenKt.BookingSummaryScreen$lambda$5(BookingSummaryViewModel.this, navigator, phoneNumberCodeResultRecipient, vehicleSelectorResultRecipient, checkoutExpirationDialogHandler, i5, (Composer) obj, ((Integer) obj2).intValue());
                            return BookingSummaryScreen$lambda$5;
                        }
                    });
                    return;
                }
                return;
            }
            CheckoutManager.CheckoutDirectionState checkoutDirectionState2 = (CheckoutManager.CheckoutDirectionState) SnapshotStateKt.collectAsState(viewModel.getReturnCheckoutState(), null, startRestartGroup, 0, 1).getValue();
            SummaryAddonHelper.SummaryAddonState summaryAddonState = (SummaryAddonHelper.SummaryAddonState) SnapshotStateKt.collectAsState(viewModel.getSummaryAddonState(), null, startRestartGroup, 0, 1).getValue();
            EditManager.EditState editState = (EditManager.EditState) SnapshotStateKt.collectAsState(viewModel.getEditState(), null, startRestartGroup, 0, 1).getValue();
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (rememberedValue3 == companion.getEmpty()) {
                Object compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup));
                startRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                rememberedValue3 = compositionScopedCoroutineScopeCanceller;
            }
            CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue3).getCoroutineScope();
            startRestartGroup.startReplaceGroup(893658763);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (rememberedValue4 == companion.getEmpty()) {
                rememberedValue4 = new FormValidator(MapsKt.mapOf(TuplesKt.to(BookingSummaryFormField.Terms, RequiredBooleanCustomValidator.INSTANCE), TuplesKt.to(BookingSummaryFormField.NationalNumber, PhoneNumberInputValidator.NationalNumber.INSTANCE), TuplesKt.to(BookingSummaryFormField.CountryCode, PhoneNumberInputValidator.CountryCode.INSTANCE), TuplesKt.to(BookingSummaryFormField.Email, EmailInputValidator.INSTANCE), TuplesKt.to(BookingSummaryFormField.PostalCode, NonEmptyStringValidator.INSTANCE), TuplesKt.to(BookingSummaryFormField.EarlyCheckIn, EarlyCheckInValidator.INSTANCE), TuplesKt.to(BookingSummaryFormField.LicensePlate, LicensePlateValidator.INSTANCE)), coroutineScope);
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            FormValidator formValidator = (FormValidator) rememberedValue4;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(893690972);
            boolean changedInstance3 = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (changedInstance3 || rememberedValue5 == companion.getEmpty()) {
                rememberedValue5 = new BookingSummaryScreenKt$BookingSummaryScreen$3$1(viewModel);
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            startRestartGroup.endReplaceGroup();
            Function0 function0 = (Function0) ((KFunction) rememberedValue5);
            startRestartGroup.startReplaceGroup(893693115);
            boolean changedInstance4 = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue6 = startRestartGroup.rememberedValue();
            if (changedInstance4 || rememberedValue6 == companion.getEmpty()) {
                rememberedValue6 = new BookingSummaryScreenKt$BookingSummaryScreen$4$1(viewModel);
                startRestartGroup.updateRememberedValue(rememberedValue6);
            }
            startRestartGroup.endReplaceGroup();
            Function0 function02 = (Function0) ((KFunction) rememberedValue6);
            startRestartGroup.startReplaceGroup(893695123);
            boolean changedInstance5 = startRestartGroup.changedInstance(viewModel) | (i7 == 32);
            Object rememberedValue7 = startRestartGroup.rememberedValue();
            if (changedInstance5 || rememberedValue7 == companion.getEmpty()) {
                rememberedValue7 = new Function0() { // from class: h3.o
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit BookingSummaryScreen$lambda$11$lambda$10;
                        BookingSummaryScreen$lambda$11$lambda$10 = BookingSummaryScreenKt.BookingSummaryScreen$lambda$11$lambda$10(BookingSummaryViewModel.this, navigator);
                        return BookingSummaryScreen$lambda$11$lambda$10;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue7);
            }
            Function0 function03 = (Function0) rememberedValue7;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(893701634);
            boolean changedInstance6 = startRestartGroup.changedInstance(viewModel) | (i7 == 32);
            Object rememberedValue8 = startRestartGroup.rememberedValue();
            if (changedInstance6 || rememberedValue8 == companion.getEmpty()) {
                rememberedValue8 = new Function0() { // from class: h3.p
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit BookingSummaryScreen$lambda$14$lambda$13;
                        BookingSummaryScreen$lambda$14$lambda$13 = BookingSummaryScreenKt.BookingSummaryScreen$lambda$14$lambda$13(BookingSummaryViewModel.this, navigator);
                        return BookingSummaryScreen$lambda$14$lambda$13;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue8);
            }
            Function0 function04 = (Function0) rememberedValue8;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(893707931);
            boolean changedInstance7 = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue9 = startRestartGroup.rememberedValue();
            if (changedInstance7 || rememberedValue9 == companion.getEmpty()) {
                rememberedValue9 = new BookingSummaryScreenKt$BookingSummaryScreen$7$1(viewModel);
                startRestartGroup.updateRememberedValue(rememberedValue9);
            }
            startRestartGroup.endReplaceGroup();
            Function2 function2 = (Function2) ((KFunction) rememberedValue9);
            startRestartGroup.startReplaceGroup(893710419);
            boolean changedInstance8 = (i7 == 32) | startRestartGroup.changedInstance(checkoutDirectionState) | startRestartGroup.changedInstance(checkoutState);
            Object rememberedValue10 = startRestartGroup.rememberedValue();
            if (changedInstance8 || rememberedValue10 == companion.getEmpty()) {
                rememberedValue10 = new Function0() { // from class: h3.q
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit BookingSummaryScreen$lambda$17$lambda$16;
                        BookingSummaryScreen$lambda$17$lambda$16 = BookingSummaryScreenKt.BookingSummaryScreen$lambda$17$lambda$16(DestinationsNavigator.this, checkoutDirectionState, checkoutState);
                        return BookingSummaryScreen$lambda$17$lambda$16;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue10);
            }
            Function0 function05 = (Function0) rememberedValue10;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(893722137);
            boolean changedInstance9 = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue11 = startRestartGroup.rememberedValue();
            if (changedInstance9 || rememberedValue11 == companion.getEmpty()) {
                rememberedValue11 = new BookingSummaryScreenKt$BookingSummaryScreen$9$1(viewModel);
                startRestartGroup.updateRememberedValue(rememberedValue11);
            }
            startRestartGroup.endReplaceGroup();
            Function1 function1 = (Function1) ((KFunction) rememberedValue11);
            startRestartGroup.startReplaceGroup(893723923);
            boolean changedInstance10 = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue12 = startRestartGroup.rememberedValue();
            if (changedInstance10 || rememberedValue12 == companion.getEmpty()) {
                rememberedValue12 = new BookingSummaryScreenKt$BookingSummaryScreen$10$1(viewModel);
                startRestartGroup.updateRememberedValue(rememberedValue12);
            }
            startRestartGroup.endReplaceGroup();
            Function1 function12 = (Function1) ((KFunction) rememberedValue12);
            startRestartGroup.startReplaceGroup(893725688);
            boolean changedInstance11 = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue13 = startRestartGroup.rememberedValue();
            if (changedInstance11 || rememberedValue13 == companion.getEmpty()) {
                rememberedValue13 = new BookingSummaryScreenKt$BookingSummaryScreen$11$1(viewModel);
                startRestartGroup.updateRememberedValue(rememberedValue13);
            }
            startRestartGroup.endReplaceGroup();
            Function1 function13 = (Function1) ((KFunction) rememberedValue13);
            startRestartGroup.startReplaceGroup(893727674);
            boolean changedInstance12 = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue14 = startRestartGroup.rememberedValue();
            if (changedInstance12 || rememberedValue14 == companion.getEmpty()) {
                rememberedValue14 = new BookingSummaryScreenKt$BookingSummaryScreen$12$1(viewModel);
                startRestartGroup.updateRememberedValue(rememberedValue14);
            }
            startRestartGroup.endReplaceGroup();
            Function1 function14 = (Function1) ((KFunction) rememberedValue14);
            startRestartGroup.startReplaceGroup(893729854);
            boolean changedInstance13 = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue15 = startRestartGroup.rememberedValue();
            if (changedInstance13 || rememberedValue15 == companion.getEmpty()) {
                rememberedValue15 = new BookingSummaryScreenKt$BookingSummaryScreen$13$1(viewModel);
                startRestartGroup.updateRememberedValue(rememberedValue15);
            }
            startRestartGroup.endReplaceGroup();
            Function3 function3 = (Function3) ((KFunction) rememberedValue15);
            startRestartGroup.startReplaceGroup(893732059);
            boolean changedInstance14 = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue16 = startRestartGroup.rememberedValue();
            if (changedInstance14 || rememberedValue16 == companion.getEmpty()) {
                rememberedValue16 = new BookingSummaryScreenKt$BookingSummaryScreen$14$1(viewModel);
                startRestartGroup.updateRememberedValue(rememberedValue16);
            }
            startRestartGroup.endReplaceGroup();
            Function0 function06 = (Function0) ((KFunction) rememberedValue16);
            startRestartGroup.startReplaceGroup(893734138);
            boolean changedInstance15 = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue17 = startRestartGroup.rememberedValue();
            if (changedInstance15 || rememberedValue17 == companion.getEmpty()) {
                rememberedValue17 = new BookingSummaryScreenKt$BookingSummaryScreen$15$1(viewModel);
                startRestartGroup.updateRememberedValue(rememberedValue17);
            }
            startRestartGroup.endReplaceGroup();
            Function0 function07 = (Function0) ((KFunction) rememberedValue17);
            startRestartGroup.startReplaceGroup(893736464);
            boolean z5 = i7 == 32;
            Object rememberedValue18 = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue18 == companion.getEmpty()) {
                rememberedValue18 = new Function0() { // from class: h3.r
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit BookingSummaryScreen$lambda$26$lambda$25;
                        BookingSummaryScreen$lambda$26$lambda$25 = BookingSummaryScreenKt.BookingSummaryScreen$lambda$26$lambda$25(DestinationsNavigator.this);
                        return BookingSummaryScreen$lambda$26$lambda$25;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue18);
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            BookingSummaryContent(viewState, checkoutState, checkoutDirectionState, checkoutDirectionState2, editState, summaryAddonState, formValidator, function0, function02, function03, function04, function2, function05, function1, function12, function13, function14, function3, function06, function07, (Function0) rememberedValue18, viewModel.getHighlightReturnTicketButton(), composer2, 0, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup3 = composer2.endRestartGroup();
        if (endRestartGroup3 != null) {
            endRestartGroup3.updateScope(new Function2() { // from class: h3.s
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit BookingSummaryScreen$lambda$27;
                    BookingSummaryScreen$lambda$27 = BookingSummaryScreenKt.BookingSummaryScreen$lambda$27(BookingSummaryViewModel.this, navigator, phoneNumberCodeResultRecipient, vehicleSelectorResultRecipient, checkoutExpirationDialogHandler, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return BookingSummaryScreen$lambda$27;
                }
            });
        }
    }

    public static final Unit BookingSummaryScreen$lambda$1$lambda$0(BookingSummaryViewModel bookingSummaryViewModel, UserVehicle it) {
        Intrinsics.checkNotNullParameter(it, "it");
        bookingSummaryViewModel.updateSelectedVehicle(it);
        return Unit.INSTANCE;
    }

    public static final Unit BookingSummaryScreen$lambda$11$lambda$10(BookingSummaryViewModel bookingSummaryViewModel, final DestinationsNavigator destinationsNavigator) {
        bookingSummaryViewModel.proceedToReturnBooking(new Function0() { // from class: h3.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit BookingSummaryScreen$lambda$11$lambda$10$lambda$9;
                BookingSummaryScreen$lambda$11$lambda$10$lambda$9 = BookingSummaryScreenKt.BookingSummaryScreen$lambda$11$lambda$10$lambda$9(DestinationsNavigator.this);
                return BookingSummaryScreen$lambda$11$lambda$10$lambda$9;
            }
        });
        return Unit.INSTANCE;
    }

    public static final Unit BookingSummaryScreen$lambda$11$lambda$10$lambda$9(DestinationsNavigator destinationsNavigator) {
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, DeparturesReturnScreenDestination.INSTANCE.invoke(true), null, null, 6, null);
        return Unit.INSTANCE;
    }

    public static final Unit BookingSummaryScreen$lambda$14$lambda$13(BookingSummaryViewModel bookingSummaryViewModel, final DestinationsNavigator destinationsNavigator) {
        bookingSummaryViewModel.proceed(new Function1() { // from class: h3.t
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit BookingSummaryScreen$lambda$14$lambda$13$lambda$12;
                BookingSummaryScreen$lambda$14$lambda$13$lambda$12 = BookingSummaryScreenKt.BookingSummaryScreen$lambda$14$lambda$13$lambda$12(DestinationsNavigator.this, (PaymentOrigin) obj);
                return BookingSummaryScreen$lambda$14$lambda$13$lambda$12;
            }
        });
        return Unit.INSTANCE;
    }

    public static final Unit BookingSummaryScreen$lambda$14$lambda$13$lambda$12(DestinationsNavigator destinationsNavigator, PaymentOrigin paymentOrigin) {
        Intrinsics.checkNotNullParameter(paymentOrigin, "paymentOrigin");
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, PaymentScreenDestination.INSTANCE.invoke(paymentOrigin), null, null, 6, null);
        return Unit.INSTANCE;
    }

    public static final Unit BookingSummaryScreen$lambda$17$lambda$16(DestinationsNavigator destinationsNavigator, CheckoutManager.CheckoutDirectionState checkoutDirectionState, CheckoutManager.CheckoutState checkoutState) {
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, VehicleSelectorScreenDestination.INSTANCE.invoke(CollectionsKt.arrayListOf(checkoutDirectionState.getDepartureTicket().getCarId()), CollectionsKt.arrayListOf(checkoutState.getTransportation().getId()), checkoutState.getSite()), null, null, 6, null);
        return Unit.INSTANCE;
    }

    public static final Unit BookingSummaryScreen$lambda$26$lambda$25(DestinationsNavigator destinationsNavigator) {
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, PhoneNumberCodeSelectionScreenDestination.INSTANCE, null, null, 6, null);
        return Unit.INSTANCE;
    }

    public static final Unit BookingSummaryScreen$lambda$27(BookingSummaryViewModel bookingSummaryViewModel, DestinationsNavigator destinationsNavigator, ResultRecipient resultRecipient, ResultRecipient resultRecipient2, ICheckoutExpirationDialogHandler iCheckoutExpirationDialogHandler, int i5, Composer composer, int i6) {
        BookingSummaryScreen(bookingSummaryViewModel, destinationsNavigator, resultRecipient, resultRecipient2, iCheckoutExpirationDialogHandler, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final Unit BookingSummaryScreen$lambda$3$lambda$2(BookingSummaryViewModel bookingSummaryViewModel, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        bookingSummaryViewModel.updatePhoneNumberCode(it);
        return Unit.INSTANCE;
    }

    public static final Unit BookingSummaryScreen$lambda$4(BookingSummaryViewModel bookingSummaryViewModel, DestinationsNavigator destinationsNavigator, ResultRecipient resultRecipient, ResultRecipient resultRecipient2, ICheckoutExpirationDialogHandler iCheckoutExpirationDialogHandler, int i5, Composer composer, int i6) {
        BookingSummaryScreen(bookingSummaryViewModel, destinationsNavigator, resultRecipient, resultRecipient2, iCheckoutExpirationDialogHandler, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final Unit BookingSummaryScreen$lambda$5(BookingSummaryViewModel bookingSummaryViewModel, DestinationsNavigator destinationsNavigator, ResultRecipient resultRecipient, ResultRecipient resultRecipient2, ICheckoutExpirationDialogHandler iCheckoutExpirationDialogHandler, int i5, Composer composer, int i6) {
        BookingSummaryScreen(bookingSummaryViewModel, destinationsNavigator, resultRecipient, resultRecipient2, iCheckoutExpirationDialogHandler, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void HighlightedAddReturnTicketButton(final Function0<Unit> function0, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(415040979);
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
                ComposerKt.traceEventStart(415040979, i6, -1, "dk.molslinjen.ui.views.screens.booking.summary.HighlightedAddReturnTicketButton (BookingSummaryScreen.kt:526)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            AppColor appColor = AppColor.INSTANCE;
            float f5 = 8;
            float f6 = 24;
            Modifier m311padding3ABfNKs = PaddingKt.m311padding3ABfNKs(BackgroundKt.m103backgroundbw27NRU(companion, appColor.m3255getBrandBlue10d7_KjU(), RoundedCornerShapeKt.m460RoundedCornerShape0680j_4(Dp.m2599constructorimpl(f5))), Dp.m2599constructorimpl(f6));
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getCenterHorizontally(), startRestartGroup, 48);
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
            String stringResource = StringResources_androidKt.stringResource(R.string.bookingSummary_addReturnTrip_title, startRestartGroup, 6);
            TextAlign.Companion companion3 = TextAlign.INSTANCE;
            TextKt.m940Text4IGK_g(stringResource, null, appColor.m3281getWhite0d7_KjU(), 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(companion3.m2528getCentere0LSkKk()), 0L, 0, false, 0, 0, null, TypographyKt.getH3Bold(), startRestartGroup, 384, 1572864, 65018);
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f5)), startRestartGroup, 6);
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.bookingSummary_addReturnTrip_description, startRestartGroup, 6), null, appColor.m3281getWhite0d7_KjU(), 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(companion3.m2528getCentere0LSkKk()), 0L, 0, false, 0, 0, null, TypographyKt.getSubSmall(), startRestartGroup, 384, 1572864, 65018);
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f6)), startRestartGroup, 6);
            composer2 = startRestartGroup;
            OutlineDashedButtonKt.m3405OutlineDashedButtonEMNEwkI(companion, StringResources_androidKt.stringResource(R.string.bookingSummary_addReturnTrip, startRestartGroup, 6), R.drawable.icon_plus_circled, appColor.m3269getGrey60d7_KjU(), 0L, 0L, function0, startRestartGroup, ((i6 << 18) & 3670016) | 3462, 48);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: h3.j
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit HighlightedAddReturnTicketButton$lambda$43;
                    HighlightedAddReturnTicketButton$lambda$43 = BookingSummaryScreenKt.HighlightedAddReturnTicketButton$lambda$43(Function0.this, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return HighlightedAddReturnTicketButton$lambda$43;
                }
            });
        }
    }

    public static final Unit HighlightedAddReturnTicketButton$lambda$43(Function0 function0, int i5, Composer composer, int i6) {
        HighlightedAddReturnTicketButton(function0, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r3v7 */
    public static final void LicensePlateSection(final UserVehicle userVehicle, final IFormValidator iFormValidator, final Transportation transportation, final Function0<Unit> function0, final Function0<Unit> function02, Composer composer, final int i5) {
        int i6;
        int i7;
        Modifier.Companion companion;
        final String str;
        ?? r32;
        int i8;
        Composer startRestartGroup = composer.startRestartGroup(504716691);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(userVehicle) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= (i5 & 64) == 0 ? startRestartGroup.changed(iFormValidator) : startRestartGroup.changedInstance(iFormValidator) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(transportation) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(function0) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(function02) ? 16384 : 8192;
        }
        if ((i6 & 9363) == 9362 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(504716691, i6, -1, "dk.molslinjen.ui.views.screens.booking.summary.LicensePlateSection (BookingSummaryScreen.kt:443)");
            }
            BookingSummaryFormField bookingSummaryFormField = BookingSummaryFormField.LicensePlate;
            iFormValidator.set(bookingSummaryFormField, LicensePlateValidator.INSTANCE.validateInput(userVehicle, transportation.getLicensePlateRequired()));
            iFormValidator.submit(bookingSummaryFormField);
            InputValidationError inputValidationError = (InputValidationError) ((Map) SnapshotStateKt.collectAsState(iFormValidator.getSubmittedErrors(), null, startRestartGroup, 0, 1).getValue()).get(bookingSummaryFormField);
            startRestartGroup.startReplaceGroup(179048321);
            String errorMessage = inputValidationError == null ? null : inputValidationError.toErrorMessage((Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext()), bookingSummaryFormField);
            startRestartGroup.endReplaceGroup();
            Modifier.Companion companion2 = Modifier.INSTANCE;
            float f5 = 16;
            Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(companion2, 0.0f, 0.0f, 0.0f, Dp.m2599constructorimpl(f5), 7, null);
            Arrangement arrangement = Arrangement.INSTANCE;
            Arrangement.Horizontal start = arrangement.getStart();
            Alignment.Companion companion3 = Alignment.INSTANCE;
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(start, companion3.getTop(), startRestartGroup, 0);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m315paddingqDBjuR0$default);
            ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
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
            Composer m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
            String str2 = errorMessage;
            Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion4.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion4.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion4.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion4.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.bookingSummary_licensePlate, startRestartGroup, 6), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphBold(), startRestartGroup, 0, 1572864, 65534);
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.common_optional, startRestartGroup, 6), PaddingKt.m315paddingqDBjuR0$default(companion2, Dp.m2599constructorimpl(4), 0.0f, 0.0f, 0.0f, 14, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraph(), startRestartGroup, 48, 1572864, 65532);
            startRestartGroup.endNode();
            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion3.getCenterVertically(), startRestartGroup, 48);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, companion2);
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
            Composer m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl2, rowMeasurePolicy2, companion4.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion4.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion4.getSetCompositeKeyHash();
            if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion4.getSetModifier());
            LicensePlateButtonKt.LicensePlateButton(userVehicle, RowScope.weight$default(rowScopeInstance, companion2, 1.0f, false, 2, null), false, function0, startRestartGroup, i6 & 7182, 4);
            startRestartGroup.startReplaceGroup(2108402018);
            if (userVehicle != null) {
                SpacerKt.Spacer(SizeKt.m336width3ABfNKs(companion2, Dp.m2599constructorimpl(f5)), startRestartGroup, 6);
                i7 = 6;
                r32 = 0;
                companion = companion2;
                str = str2;
                i8 = 48;
                startRestartGroup = startRestartGroup;
                IconKt.m857Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.icon_minus_button, startRestartGroup, 6), StringResources_androidKt.stringResource(R.string.accessibilityLabel_remove, startRestartGroup, 6), ClickableKt.m122clickableXHw0xAI$default(ClipKt.clip(companion2, RoundedCornerShapeKt.getCircleShape()), false, null, null, function02, 7, null), AppColor.INSTANCE.m3265getGrey20d7_KjU(), startRestartGroup, 3072, 0);
            } else {
                startRestartGroup = startRestartGroup;
                i7 = 6;
                companion = companion2;
                str = str2;
                r32 = 0;
                i8 = 48;
            }
            startRestartGroup.endReplaceGroup();
            startRestartGroup.endNode();
            Modifier m315paddingqDBjuR0$default2 = PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, Dp.m2599constructorimpl(f5), 0.0f, 0.0f, 13, null);
            MeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion3.getCenterVertically(), startRestartGroup, i8);
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, r32);
            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, m315paddingqDBjuR0$default2);
            Function0<ComposeUiNode> constructor3 = companion4.getConstructor();
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
            Updater.m1227setimpl(m1226constructorimpl3, rowMeasurePolicy3, companion4.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap3, companion4.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion4.getSetCompositeKeyHash();
            if (m1226constructorimpl3.getInserting() || !Intrinsics.areEqual(m1226constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m1227setimpl(m1226constructorimpl3, materializeModifier3, companion4.getSetModifier());
            IconKt.m857Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.icon_checkmark_circle, startRestartGroup, i7), Accessibility.INSTANCE.getSkip(), SizeKt.m331size3ABfNKs(companion, Dp.m2599constructorimpl(f5)), AppColor.INSTANCE.m3263getContrastGreen20d7_KjU(), startRestartGroup, 3456, 0);
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.bookingSummary_fasterThroughCheckIn, startRestartGroup, i7), PaddingKt.m315paddingqDBjuR0$default(companion, Dp.m2599constructorimpl(8), 0.0f, 0.0f, 0.0f, 14, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), startRestartGroup, 48, 1572864, 65532);
            startRestartGroup.endNode();
            boolean z5 = str != null ? true : r32;
            startRestartGroup.startReplaceGroup(179103691);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: h3.h
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit LicensePlateSection$lambda$39$lambda$38;
                        LicensePlateSection$lambda$39$lambda$38 = BookingSummaryScreenKt.LicensePlateSection$lambda$39$lambda$38((SemanticsPropertyReceiver) obj);
                        return LicensePlateSection$lambda$39$lambda$38;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            AnimatedVisibilityKt.AnimatedVisibility(z5, SemanticsModifierKt.semantics$default(companion, r32, (Function1) rememberedValue, 1, null), null, null, null, ComposableLambdaKt.rememberComposableLambda(991267771, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.summary.BookingSummaryScreenKt$LicensePlateSection$5
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer2, Integer num) {
                    invoke(animatedVisibilityScope, composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer composer2, int i9) {
                    TextStyle m2295copyp1EtxEg;
                    Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(991267771, i9, -1, "dk.molslinjen.ui.views.screens.booking.summary.LicensePlateSection.<anonymous> (BookingSummaryScreen.kt:506)");
                    }
                    String str3 = str;
                    if (str3 == null) {
                        str3 = BuildConfig.FLAVOR;
                    }
                    m2295copyp1EtxEg = r3.m2295copyp1EtxEg((r48 & 1) != 0 ? r3.spanStyle.m2255getColor0d7_KjU() : AppColor.INSTANCE.m3272getSignalRed0d7_KjU(), (r48 & 2) != 0 ? r3.spanStyle.getFontSize() : 0L, (r48 & 4) != 0 ? r3.spanStyle.getFontWeight() : null, (r48 & 8) != 0 ? r3.spanStyle.getFontStyle() : null, (r48 & 16) != 0 ? r3.spanStyle.getFontSynthesis() : null, (r48 & 32) != 0 ? r3.spanStyle.getFontFamily() : null, (r48 & 64) != 0 ? r3.spanStyle.getFontFeatureSettings() : null, (r48 & 128) != 0 ? r3.spanStyle.getLetterSpacing() : 0L, (r48 & 256) != 0 ? r3.spanStyle.getBaselineShift() : null, (r48 & 512) != 0 ? r3.spanStyle.getTextGeometricTransform() : null, (r48 & 1024) != 0 ? r3.spanStyle.getLocaleList() : null, (r48 & 2048) != 0 ? r3.spanStyle.getBackground() : 0L, (r48 & 4096) != 0 ? r3.spanStyle.getTextDecoration() : null, (r48 & 8192) != 0 ? r3.spanStyle.getShadow() : null, (r48 & 16384) != 0 ? r3.spanStyle.getDrawStyle() : null, (r48 & 32768) != 0 ? r3.paragraphStyle.getTextAlign() : 0, (r48 & 65536) != 0 ? r3.paragraphStyle.getTextDirection() : 0, (r48 & 131072) != 0 ? r3.paragraphStyle.getLineHeight() : 0L, (r48 & 262144) != 0 ? r3.paragraphStyle.getTextIndent() : null, (r48 & 524288) != 0 ? r3.platformStyle : null, (r48 & 1048576) != 0 ? r3.paragraphStyle.getLineHeightStyle() : null, (r48 & 2097152) != 0 ? r3.paragraphStyle.getLineBreak() : 0, (r48 & 4194304) != 0 ? r3.paragraphStyle.getHyphens() : 0, (r48 & 8388608) != 0 ? TypographyKt.getSub().paragraphStyle.getTextMotion() : null);
                    TextKt.m940Text4IGK_g(str3, PaddingKt.m315paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m2599constructorimpl(8), 0.0f, 0.0f, 13, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, m2295copyp1EtxEg, composer2, 48, 0, 65532);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), startRestartGroup, 196608, 28);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: h3.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit LicensePlateSection$lambda$40;
                    LicensePlateSection$lambda$40 = BookingSummaryScreenKt.LicensePlateSection$lambda$40(UserVehicle.this, iFormValidator, transportation, function0, function02, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return LicensePlateSection$lambda$40;
                }
            });
        }
    }

    public static final Unit LicensePlateSection$lambda$39$lambda$38(SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        SemanticsPropertiesKt.m2183setLiveRegionhR3wRGc(semantics, LiveRegionMode.INSTANCE.m2161getAssertive0phEisY());
        return Unit.INSTANCE;
    }

    public static final Unit LicensePlateSection$lambda$40(UserVehicle userVehicle, IFormValidator iFormValidator, Transportation transportation, Function0 function0, Function0 function02, int i5, Composer composer, int i6) {
        LicensePlateSection(userVehicle, iFormValidator, transportation, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void Splitter(Composer composer, final int i5) {
        Composer startRestartGroup = composer.startRestartGroup(-458242822);
        if (i5 == 0 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-458242822, i5, -1, "dk.molslinjen.ui.views.screens.booking.summary.Splitter (BookingSummaryScreen.kt:558)");
            }
            HorizontalDividerKt.m3388HorizontalDividertZIQpXc(PaddingKt.m313paddingVpY3zN4$default(Modifier.INSTANCE, 0.0f, Dp.m2599constructorimpl(8), 1, null), 0L, 0.0f, null, startRestartGroup, 6, 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: h3.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit Splitter$lambda$44;
                    Splitter$lambda$44 = BookingSummaryScreenKt.Splitter$lambda$44(i5, (Composer) obj, ((Integer) obj2).intValue());
                    return Splitter$lambda$44;
                }
            });
        }
    }

    public static final Unit Splitter$lambda$44(int i5, Composer composer, int i6) {
        Splitter(composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void TotalPriceRow(final PriceTotal priceTotal, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(1442999249);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(priceTotal) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i6 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1442999249, i6, -1, "dk.molslinjen.ui.views.screens.booking.summary.TotalPriceRow (BookingSummaryScreen.kt:409)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, Dp.m2599constructorimpl(24), 0.0f, Dp.m2599constructorimpl(16), 5, null);
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), startRestartGroup, 0);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m315paddingqDBjuR0$default);
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
            SpacerKt.Spacer(RowScope.weight$default(rowScopeInstance, companion, 1.0f, false, 2, null), startRestartGroup, 0);
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.ticketInfo_summedTotalPrice, startRestartGroup, 6), PaddingKt.m315paddingqDBjuR0$default(rowScopeInstance.alignByBaseline(companion), 0.0f, 0.0f, Dp.m2599constructorimpl(8), 0.0f, 11, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), startRestartGroup, 0, 1572864, 65532);
            int i7 = (i6 & 14) | 24960;
            composer2 = startRestartGroup;
            PriceTextKt.m3556PriceText1y9Plug(priceTotal, PaddingKt.m315paddingqDBjuR0$default(rowScopeInstance.alignByBaseline(companion), 0.0f, 0.0f, Dp.m2599constructorimpl(4), 0.0f, 11, null), PriceViewType.PriceOnly, false, TypographyKt.getH2Bold(), (TextAlign) null, 0, 0L, startRestartGroup, i7, 232);
            PriceTextKt.m3556PriceText1y9Plug(priceTotal, rowScopeInstance.alignByBaseline(companion), PriceViewType.CurrencyOnly, false, TypographyKt.getSub(), (TextAlign) null, 0, 0L, composer2, i7, 232);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: h3.k
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit TotalPriceRow$lambda$34;
                    TotalPriceRow$lambda$34 = BookingSummaryScreenKt.TotalPriceRow$lambda$34(PriceTotal.this, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return TotalPriceRow$lambda$34;
                }
            });
        }
    }

    public static final Unit TotalPriceRow$lambda$34(PriceTotal priceTotal, int i5, Composer composer, int i6) {
        TotalPriceRow(priceTotal, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ void access$Splitter(Composer composer, int i5) {
        Splitter(composer, i5);
    }

    private static final void ticketSummaryViews(LazyListScope lazyListScope, final CheckoutManager.CheckoutState checkoutState, final CheckoutManager.CheckoutDirectionState checkoutDirectionState, final CheckoutManager.CheckoutDirectionState checkoutDirectionState2, final EditManager.EditState editState, final Function0<Unit> function0, final boolean z5) {
        LazyListScope.item$default(lazyListScope, null, null, ComposableLambdaKt.composableLambdaInstance(210125178, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.summary.BookingSummaryScreenKt$ticketSummaryViews$1
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
                    ComposerKt.traceEventStart(210125178, i5, -1, "dk.molslinjen.ui.views.screens.booking.summary.ticketSummaryViews.<anonymous> (BookingSummaryScreen.kt:325)");
                }
                BookingType bookingType = CheckoutManager.CheckoutState.this.getBookingType();
                BookingType bookingType2 = BookingType.TwoWay;
                String stringResource = StringResources_androidKt.stringResource((bookingType == bookingType2 || CheckoutManager.CheckoutState.this.getSite() == Site.Fanoe) ? R.string.departures_return_outbound : R.string.ticketSummary_myTravel, composer, 0);
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
                boolean z6 = CheckoutManager.CheckoutState.this.getEditingBooking() == null;
                List<BookingPassenger> passengers = checkoutDirectionState.getPassengers();
                boolean askForPersonData = checkoutDirectionState.getRouteDirectionDetails().getAskForPersonData();
                List<ProductType> availableProductTypes = checkoutDirectionState.getDeparture().getAvailableProductTypes();
                BookingType bookingType3 = CheckoutManager.CheckoutState.this.getBookingType();
                composer.startReplaceGroup(-1188601281);
                String stringResource2 = bookingType3 == bookingType2 ? StringResources_androidKt.stringResource(R.string.ticketInfo_outboundPrice, composer, 6) : null;
                composer.endReplaceGroup();
                TicketSummaryViewKt.TicketSummaryView(stringResource, departure, category, transportation, transportationCargoInfo, surcharges, passengerInfo, plus, food, seatReservation, trailer, transportProducts, priceDetails, totalPrice, price, null, false, null, null, z6, passengers, askForPersonData, false, null, null, stringResource2, availableProductTypes, checkoutDirectionState.getRouteDirectionDetails().getSubline(), CheckoutManager.CheckoutState.this.getLineLogoUrl(), composer, 0, 12582912, 0, 29720576);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), 3, null);
        LazyListScope.item$default(lazyListScope, null, null, ComposableLambdaKt.composableLambdaInstance(-1708428047, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.summary.BookingSummaryScreenKt$ticketSummaryViews$2
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                invoke(lazyItemScope, composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope item, Composer composer, int i5) {
                int i6;
                Composer composer2;
                int i7;
                Unit unit;
                Intrinsics.checkNotNullParameter(item, "$this$item");
                if ((i5 & 6) == 0) {
                    i6 = i5 | (composer.changed(item) ? 4 : 2);
                } else {
                    i6 = i5;
                }
                if ((i6 & 19) == 18 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1708428047, i6, -1, "dk.molslinjen.ui.views.screens.booking.summary.ticketSummaryViews.<anonymous> (BookingSummaryScreen.kt:362)");
                }
                if (CheckoutManager.CheckoutState.this.getSite() == Site.Fanoe) {
                    composer.startReplaceGroup(1808436250);
                    FanoeReturnInfoViewKt.FanoeReturnInfoView(CheckoutManager.CheckoutState.this.getCurrency(), composer, 0);
                    BookingSummaryScreenKt.TotalPriceRow(CheckoutManager.CheckoutState.this.getPriceDetails().getTotalPrice(), composer, 0);
                    BookingSummaryScreenKt.Splitter(composer, 0);
                    composer.endReplaceGroup();
                } else {
                    composer.startReplaceGroup(1808678887);
                    CheckoutManager.CheckoutDirectionState checkoutDirectionState3 = checkoutDirectionState2;
                    composer.startReplaceGroup(-1188580963);
                    if (checkoutDirectionState3 == null) {
                        unit = null;
                        composer2 = composer;
                        i7 = 0;
                    } else {
                        CheckoutManager.CheckoutState checkoutState2 = CheckoutManager.CheckoutState.this;
                        SpacerKt.Spacer(SizeKt.m325height3ABfNKs(Modifier.INSTANCE, Dp.m2599constructorimpl(24)), composer, 6);
                        composer2 = composer;
                        TicketSummaryViewKt.TicketSummaryView(StringResources_androidKt.stringResource(R.string.departures_return_return, composer, 6), checkoutDirectionState3.getDeparture(), checkoutDirectionState3.getDepartureTicket().getCategory(), checkoutState2.getTransportation(), checkoutDirectionState3.getTransportationCargoInfo(), checkoutDirectionState3.getDepartureTicket().getSurcharges(), checkoutDirectionState3.getPassengerInfo(), CollectionsKt.plus((Collection) checkoutDirectionState3.getAddons(), (Iterable) checkoutDirectionState3.getSummaryAddons()), checkoutDirectionState3.getFood(), checkoutDirectionState3.getSeatReservation(), checkoutDirectionState3.getTrailer(), checkoutDirectionState3.getTransportProducts(), null, checkoutDirectionState3.getTotalPrice(), checkoutDirectionState3.getDepartureTicket().getPrice(), null, false, null, null, false, checkoutDirectionState3.getPassengers(), checkoutDirectionState3.getRouteDirectionDetails().getAskForPersonData(), false, null, null, StringResources_androidKt.stringResource(R.string.ticketInfo_returnPrice, composer, 6), checkoutDirectionState3.getDeparture().getAvailableProductTypes(), checkoutDirectionState3.getRouteDirectionDetails().getSubline(), checkoutState2.getLineLogoUrl(), composer, 0, 12582912, 0, 30248960);
                        i7 = 0;
                        BookingSummaryScreenKt.TotalPriceRow(checkoutState2.getPriceDetails().getTotalPrice(), composer2, 0);
                        BookingSummaryScreenKt.Splitter(composer2, 0);
                        unit = Unit.INSTANCE;
                    }
                    composer.endReplaceGroup();
                    if (unit == null) {
                        CheckoutManager.CheckoutState checkoutState3 = CheckoutManager.CheckoutState.this;
                        EditManager.EditState editState2 = editState;
                        boolean z6 = z5;
                        Function0<Unit> function02 = function0;
                        int i8 = (checkoutState3.getSite() == Site.Oeresund && checkoutState3.getTransportation().isTura()) ? 1 : i7;
                        composer2.startReplaceGroup(-1188528647);
                        if (!editState2.getIsEditing() && i8 == 0) {
                            if (z6) {
                                composer2.startReplaceGroup(-358466113);
                                BookingSummaryScreenKt.HighlightedAddReturnTicketButton(function02, composer2, i7);
                                composer.endReplaceGroup();
                            } else {
                                composer2.startReplaceGroup(-358350390);
                                BookingSummaryScreenKt.AddReturnTicketButton(function02, composer2, i7);
                                composer.endReplaceGroup();
                            }
                        }
                        composer.endReplaceGroup();
                    }
                    composer.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), 3, null);
    }
}
