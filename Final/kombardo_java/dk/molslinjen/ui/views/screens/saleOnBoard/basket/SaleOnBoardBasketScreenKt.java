package dk.molslinjen.ui.views.screens.saleOnBoard.basket;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
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
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import com.ramcosta.composedestinations.generated.destinations.PaymentScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.PhoneNumberCodeSelectionScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.SaleOnBoardProductDetailsScreenDestination;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import com.ramcosta.composedestinations.result.OpenResultRecipientKt;
import com.ramcosta.composedestinations.result.ResultRecipient;
import dk.molslinjen.domain.managers.checkout.PriceTotal;
import dk.molslinjen.domain.managers.saleOnBoard.SaleOnBoardCheckoutManager;
import dk.molslinjen.domain.model.account.CreditCard;
import dk.molslinjen.domain.model.booking.IDepartureInfo;
import dk.molslinjen.domain.model.booking.SaleOnBoardContactInfo;
import dk.molslinjen.domain.model.payment.PaymentOrigin;
import dk.molslinjen.domain.model.payment.PaymentType;
import dk.molslinjen.domain.model.saleOnBoard.NotificationType;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardCrossSaleProduct;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardLineItem;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardTimeSlot;
import dk.molslinjen.domain.model.shared.PhoneNumber;
import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import dk.molslinjen.domain.model.site.SiteInfo;
import dk.molslinjen.extensions.ColorExtensionsKt;
import dk.molslinjen.extensions.ComposeExtensionsKt;
import dk.molslinjen.extensions.ModifierExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.ThemeShapesKt;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.HorizontalDividerKt;
import dk.molslinjen.ui.views.reusable.dialog.SimpleButtonData;
import dk.molslinjen.ui.views.reusable.dialog.TextDialogKt;
import dk.molslinjen.ui.views.reusable.input.validation.FormValidator;
import dk.molslinjen.ui.views.reusable.input.validation.IFormValidator;
import dk.molslinjen.ui.views.reusable.input.validation.validators.EmailInputValidator;
import dk.molslinjen.ui.views.reusable.input.validation.validators.NonEmptyStringValidator;
import dk.molslinjen.ui.views.reusable.input.validation.validators.PhoneNumberInputValidator;
import dk.molslinjen.ui.views.reusable.input.validation.validators.RequiredBooleanCustomValidator;
import dk.molslinjen.ui.views.screens.booking.summary.ConfirmSectionViewKt;
import dk.molslinjen.ui.views.screens.booking.summary.PaymentMethodSectionViewKt;
import dk.molslinjen.ui.views.screens.saleOnBoard.basket.SaleOnBoardBasketScreenKt;
import dk.molslinjen.ui.views.screens.saleOnBoard.basket.SaleOnBoardBasketViewModel;
import dk.molslinjen.ui.views.screens.saleOnBoard.foodListScreen.SaleOnBoardFoodListScreenKt;
import dk.molslinjen.ui.views.shared.ticket.ticketSummary.PriceDetailsViewKt;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
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

@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a3\u0010\t\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0007¢\u0006\u0004\b\t\u0010\n\u001aÃ\u0002\u0010+\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u001a\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0004\u0012\u00020\b0\u000f2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\b0\u00132\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u00132\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\b0\u00132\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\b0\u00132\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\b0\u00132\u0006\u0010\u001e\u001a\u00020\u001d2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u00132\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u00132\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\b0\u00132\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\b0\u00132\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\b0\u00132\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\b0&2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\b0&2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\b0&2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\b0&H\u0003¢\u0006\u0004\b+\u0010,\u001aC\u0010.\u001a\u00020\b*\u00020-2\u0006\u0010\u000e\u001a\u00020\r2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\b0\u00132\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u0013H\u0002¢\u0006\u0004\b.\u0010/\u001a/\u00100\u001a\u00020\b*\u00020-2\u0006\u0010\f\u001a\u00020\u000b2\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\b0\u0013H\u0002¢\u0006\u0004\b0\u00101\u001am\u00103\u001a\u00020\b*\u00020-2\u0006\u00103\u001a\u0002022\u0006\u0010\u001e\u001a\u00020\u001d2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u00132\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u00132\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\b0\u00132\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\b0&H\u0002¢\u0006\u0004\b3\u00104\u001a?\u00105\u001a\u00020\b*\u00020-2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u001a\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0004\u0012\u00020\b0\u000fH\u0002¢\u0006\u0004\b5\u00106\u001a_\u0010?\u001a\u00020\b*\u00020-2\u0006\u00107\u001a\u00020\u00192\b\u00109\u001a\u0004\u0018\u0001082\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\b0\u00132\u0006\u0010\u001e\u001a\u00020;2\u0006\u0010=\u001a\u00020<2\u0006\u0010>\u001a\u00020\u00192\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\b0&H\u0002¢\u0006\u0004\b?\u0010@¨\u0006A"}, d2 = {"Ldk/molslinjen/ui/views/screens/saleOnBoard/basket/SaleOnBoardBasketViewModel;", "viewModel", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "navigator", "Lcom/ramcosta/composedestinations/result/ResultRecipient;", "Lcom/ramcosta/composedestinations/generated/destinations/PhoneNumberCodeSelectionScreenDestination;", BuildConfig.FLAVOR, "phoneNumberCodeResultRecipient", BuildConfig.FLAVOR, "SaleOnBoardBasketScreen", "(Ldk/molslinjen/ui/views/screens/saleOnBoard/basket/SaleOnBoardBasketViewModel;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Lcom/ramcosta/composedestinations/result/ResultRecipient;Landroidx/compose/runtime/Composer;I)V", "Ldk/molslinjen/ui/views/screens/saleOnBoard/basket/SaleOnBoardBasketViewModel$ViewState;", "state", "Ldk/molslinjen/domain/managers/saleOnBoard/SaleOnBoardCheckoutManager$SaleOnBoardCheckoutState;", "saleOnBoardCheckoutState", "Lkotlin/Function2;", "Ldk/molslinjen/domain/model/payment/PaymentType;", "Ldk/molslinjen/domain/model/account/CreditCard;", "paymentMethodSelected", "Lkotlin/Function1;", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardLineItem;", "edit", "remove", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardCrossSaleProduct;", "addCrossSaleProduct", BuildConfig.FLAVOR, "onPickupTimeCategorySelection", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardTimeSlot;", "onTimeSlotSelected", "Ldk/molslinjen/ui/views/reusable/input/validation/FormValidator;", "validator", "onEmailChange", "onNameChange", "Ldk/molslinjen/domain/model/shared/PhoneNumber;", "onPhoneNumberChange", "Ldk/molslinjen/domain/model/saleOnBoard/NotificationType;", "onNotificationTypeChange", "togglePushNotifications", "Lkotlin/Function0;", "proceed", "goBack", "undoRemoveLastLineItem", "showPhoneNumberCodeSelector", "SaleOnBoardBasketContent", "(Ldk/molslinjen/ui/views/screens/saleOnBoard/basket/SaleOnBoardBasketViewModel$ViewState;Ldk/molslinjen/domain/managers/saleOnBoard/SaleOnBoardCheckoutManager$SaleOnBoardCheckoutState;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Ldk/molslinjen/ui/views/reusable/input/validation/FormValidator;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/foundation/lazy/LazyListScope;", "lineItems", "(Landroidx/compose/foundation/lazy/LazyListScope;Ldk/molslinjen/domain/managers/saleOnBoard/SaleOnBoardCheckoutManager$SaleOnBoardCheckoutState;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "crossSale", "(Landroidx/compose/foundation/lazy/LazyListScope;Ldk/molslinjen/ui/views/screens/saleOnBoard/basket/SaleOnBoardBasketViewModel$ViewState;Lkotlin/jvm/functions/Function1;)V", "Ldk/molslinjen/domain/model/booking/SaleOnBoardContactInfo;", "contactInfo", "(Landroidx/compose/foundation/lazy/LazyListScope;Ldk/molslinjen/domain/model/booking/SaleOnBoardContactInfo;Ldk/molslinjen/ui/views/reusable/input/validation/FormValidator;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "payment", "(Landroidx/compose/foundation/lazy/LazyListScope;Ldk/molslinjen/ui/views/screens/saleOnBoard/basket/SaleOnBoardBasketViewModel$ViewState;Ldk/molslinjen/domain/managers/saleOnBoard/SaleOnBoardCheckoutManager$SaleOnBoardCheckoutState;Lkotlin/jvm/functions/Function2;)V", "termsAccepted", "Ldk/molslinjen/domain/model/site/SiteInfo;", "siteInfo", "onTermsAcceptChange", "Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator;", "Ldk/molslinjen/domain/model/shared/PriceWithCurrency;", "totalPrice", "readyToProceed", "termsAndButton", "(Landroidx/compose/foundation/lazy/LazyListScope;ZLdk/molslinjen/domain/model/site/SiteInfo;Lkotlin/jvm/functions/Function1;Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator;Ldk/molslinjen/domain/model/shared/PriceWithCurrency;ZLkotlin/jvm/functions/Function0;)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class SaleOnBoardBasketScreenKt {
    private static final void SaleOnBoardBasketContent(final SaleOnBoardBasketViewModel.ViewState viewState, final SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState saleOnBoardCheckoutState, final Function2<? super PaymentType, ? super CreditCard, Unit> function2, final Function1<? super SaleOnBoardLineItem, Unit> function1, final Function1<? super String, Unit> function12, final Function1<? super SaleOnBoardCrossSaleProduct, Unit> function13, final Function1<? super Boolean, Unit> function14, final Function1<? super SaleOnBoardTimeSlot, Unit> function15, final FormValidator formValidator, final Function1<? super String, Unit> function16, final Function1<? super String, Unit> function17, final Function1<? super PhoneNumber, Unit> function18, final Function1<? super NotificationType, Unit> function19, final Function1<? super Boolean, Unit> function110, final Function0<Unit> function0, final Function0<Unit> function02, final Function0<Unit> function03, final Function0<Unit> function04, Composer composer, final int i5, final int i6) {
        int i7;
        int i8;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(139600137);
        if ((i5 & 6) == 0) {
            i7 = i5 | (startRestartGroup.changedInstance(viewState) ? 4 : 2);
        } else {
            i7 = i5;
        }
        if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changedInstance(saleOnBoardCheckoutState) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i7 |= startRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i7 |= startRestartGroup.changedInstance(function1) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i7 |= startRestartGroup.changedInstance(function12) ? 16384 : 8192;
        }
        if ((i5 & 196608) == 0) {
            i7 |= startRestartGroup.changedInstance(function13) ? 131072 : 65536;
        }
        if ((i5 & 1572864) == 0) {
            i7 |= startRestartGroup.changedInstance(function14) ? 1048576 : 524288;
        }
        if ((i5 & 12582912) == 0) {
            i7 |= startRestartGroup.changedInstance(function15) ? 8388608 : 4194304;
        }
        if ((i5 & 100663296) == 0) {
            i7 |= startRestartGroup.changedInstance(formValidator) ? 67108864 : 33554432;
        }
        if ((i5 & 805306368) == 0) {
            i7 |= startRestartGroup.changedInstance(function16) ? 536870912 : 268435456;
        }
        int i9 = i7;
        if ((i6 & 6) == 0) {
            i8 = i6 | (startRestartGroup.changedInstance(function17) ? 4 : 2);
        } else {
            i8 = i6;
        }
        if ((i6 & 48) == 0) {
            i8 |= startRestartGroup.changedInstance(function18) ? 32 : 16;
        }
        if ((i6 & 384) == 0) {
            i8 |= startRestartGroup.changedInstance(function19) ? 256 : 128;
        }
        if ((i6 & 3072) == 0) {
            i8 |= startRestartGroup.changedInstance(function110) ? 2048 : 1024;
        }
        if ((i6 & 24576) == 0) {
            i8 |= startRestartGroup.changedInstance(function0) ? 16384 : 8192;
        }
        if ((i6 & 196608) == 0) {
            i8 |= startRestartGroup.changedInstance(function02) ? 131072 : 65536;
        }
        if ((i6 & 1572864) == 0) {
            i8 |= startRestartGroup.changedInstance(function03) ? 1048576 : 524288;
        }
        if ((i6 & 12582912) == 0) {
            i8 |= startRestartGroup.changedInstance(function04) ? 8388608 : 4194304;
        }
        int i10 = i8;
        if ((i9 & 306783379) == 306783378 && (4793491 & i10) == 4793490 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(139600137, i9, i10, "dk.molslinjen.ui.views.screens.saleOnBoard.basket.SaleOnBoardBasketContent (SaleOnBoardBasketScreen.kt:153)");
            }
            final IDepartureInfo selectedDeparture = saleOnBoardCheckoutState.getSelectedDeparture();
            if (selectedDeparture == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: f4.k
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit SaleOnBoardBasketContent$lambda$24;
                            SaleOnBoardBasketContent$lambda$24 = SaleOnBoardBasketScreenKt.SaleOnBoardBasketContent$lambda$24(SaleOnBoardBasketViewModel.ViewState.this, saleOnBoardCheckoutState, function2, function1, function12, function13, function14, function15, formValidator, function16, function17, function18, function19, function110, function0, function02, function03, function04, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                            return SaleOnBoardBasketContent$lambda$24;
                        }
                    });
                    return;
                }
                return;
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            AppColor appColor = AppColor.INSTANCE;
            Modifier m104backgroundbw27NRU$default = BackgroundKt.m104backgroundbw27NRU$default(companion, appColor.m3259getBrandDarkBlue10d7_KjU(), null, 2, null);
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m104backgroundbw27NRU$default);
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
            Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            HorizontalDividerKt.m3388HorizontalDividertZIQpXc(null, ColorExtensionsKt.m3249withAlphaDxMtmZc(appColor.m3268getGrey50d7_KjU(), 0.2f), ComposeExtensionsKt.pxToDp(1, startRestartGroup, 6), null, startRestartGroup, 0, 9);
            startRestartGroup.endNode();
            LazyListState rememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, startRestartGroup, 0, 3);
            Object[] objArr = new Object[0];
            startRestartGroup.startReplaceGroup(-1828416191);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion4 = Composer.INSTANCE;
            if (rememberedValue == companion4.getEmpty()) {
                rememberedValue = new Function0() { // from class: f4.l
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        MutableState SaleOnBoardBasketContent$lambda$27$lambda$26;
                        SaleOnBoardBasketContent$lambda$27$lambda$26 = SaleOnBoardBasketScreenKt.SaleOnBoardBasketContent$lambda$27$lambda$26();
                        return SaleOnBoardBasketContent$lambda$27$lambda$26;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            final MutableState mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr, null, null, (Function0) rememberedValue, startRestartGroup, 3072, 6);
            final boolean booleanValue = ((Boolean) SnapshotStateKt.collectAsState(formValidator.isFormValid(), null, startRestartGroup, 0, 1).getValue()).booleanValue();
            startRestartGroup.startReplaceGroup(-1828412523);
            if (saleOnBoardCheckoutState.getBasketLineItems().isEmpty()) {
                String stringResource = StringResources_androidKt.stringResource(R.string.saleOnBoard_basket_emptyDialog_title, startRestartGroup, 6);
                SimpleButtonData simpleButtonData = new SimpleButtonData(StringResources_androidKt.stringResource(R.string.saleOnBoard_basket_emptyDialog_proceed, startRestartGroup, 6), false, false, function02, 6, null);
                SimpleButtonData simpleButtonData2 = new SimpleButtonData(StringResources_androidKt.stringResource(R.string.saleOnBoard_basket_emptyDialog_undo, startRestartGroup, 6), false, false, function03, 6, null);
                startRestartGroup.startReplaceGroup(-1828395830);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (rememberedValue2 == companion4.getEmpty()) {
                    rememberedValue2 = new Function0() { // from class: f4.m
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceGroup();
                TextDialogKt.TextDialog(stringResource, null, simpleButtonData, null, simpleButtonData2, false, (Function0) rememberedValue2, startRestartGroup, 1769472, 10);
            }
            startRestartGroup.endReplaceGroup();
            Arrangement arrangement = Arrangement.INSTANCE;
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
            SaleOnBoardFoodListScreenKt.DepartureInfoBar(selectedDeparture, startRestartGroup, 0);
            Modifier m104backgroundbw27NRU$default2 = BackgroundKt.m104backgroundbw27NRU$default(ColumnScope.weight$default(columnScopeInstance, companion, 1.0f, false, 2, null), appColor.m3269getGrey60d7_KjU(), null, 2, null);
            float f5 = 24;
            Modifier closeKeyboardOnClickOutside = ModifierExtensionsKt.closeKeyboardOnClickOutside(PaddingKt.m313paddingVpY3zN4$default(m104backgroundbw27NRU$default2, Dp.m2599constructorimpl(f5), 0.0f, 2, null), (FocusManager) startRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager()));
            PaddingValues m308PaddingValuesYgX7TsA$default = PaddingKt.m308PaddingValuesYgX7TsA$default(0.0f, Dp.m2599constructorimpl(f5), 1, null);
            Arrangement.HorizontalOrVertical m265spacedBy0680j_4 = arrangement.m265spacedBy0680j_4(Dp.m2599constructorimpl(32));
            startRestartGroup.startReplaceGroup(-2058489280);
            boolean changedInstance = startRestartGroup.changedInstance(selectedDeparture) | startRestartGroup.changedInstance(saleOnBoardCheckoutState) | ((i9 & 7168) == 2048) | ((i9 & 57344) == 16384) | startRestartGroup.changedInstance(viewState) | ((458752 & i9) == 131072) | ((3670016 & i9) == 1048576) | ((i9 & 29360128) == 8388608) | startRestartGroup.changedInstance(formValidator) | ((1879048192 & i9) == 536870912) | ((i10 & 14) == 4) | ((i10 & 112) == 32) | ((29360128 & i10) == 8388608) | ((i10 & 896) == 256) | ((i10 & 7168) == 2048) | ((i9 & 896) == 256) | startRestartGroup.changed(mutableState) | startRestartGroup.changed(booleanValue) | ((i10 & 57344) == 16384);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue3 == companion4.getEmpty()) {
                composer2 = startRestartGroup;
                rememberedValue3 = new Function1() { // from class: f4.b
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit SaleOnBoardBasketContent$lambda$33$lambda$32$lambda$31;
                        SaleOnBoardBasketContent$lambda$33$lambda$32$lambda$31 = SaleOnBoardBasketScreenKt.SaleOnBoardBasketContent$lambda$33$lambda$32$lambda$31(SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState.this, function1, function12, viewState, function13, function14, function15, formValidator, function16, function17, function18, function04, function19, function110, function2, mutableState, booleanValue, function0, selectedDeparture, (LazyListScope) obj);
                        return SaleOnBoardBasketContent$lambda$33$lambda$32$lambda$31;
                    }
                };
                composer2.updateRememberedValue(rememberedValue3);
            } else {
                composer2 = startRestartGroup;
            }
            composer2.endReplaceGroup();
            LazyDslKt.LazyColumn(closeKeyboardOnClickOutside, rememberLazyListState, m308PaddingValuesYgX7TsA$default, false, m265spacedBy0680j_4, null, null, false, (Function1) rememberedValue3, composer2, 24960, 232);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup2 = composer2.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.updateScope(new Function2() { // from class: f4.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit SaleOnBoardBasketContent$lambda$34;
                    SaleOnBoardBasketContent$lambda$34 = SaleOnBoardBasketScreenKt.SaleOnBoardBasketContent$lambda$34(SaleOnBoardBasketViewModel.ViewState.this, saleOnBoardCheckoutState, function2, function1, function12, function13, function14, function15, formValidator, function16, function17, function18, function19, function110, function0, function02, function03, function04, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                    return SaleOnBoardBasketContent$lambda$34;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleOnBoardBasketContent$lambda$24(SaleOnBoardBasketViewModel.ViewState viewState, SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState saleOnBoardCheckoutState, Function2 function2, Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function1 function15, FormValidator formValidator, Function1 function16, Function1 function17, Function1 function18, Function1 function19, Function1 function110, Function0 function0, Function0 function02, Function0 function03, Function0 function04, int i5, int i6, Composer composer, int i7) {
        SaleOnBoardBasketContent(viewState, saleOnBoardCheckoutState, function2, function1, function12, function13, function14, function15, formValidator, function16, function17, function18, function19, function110, function0, function02, function03, function04, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), RecomposeScopeImplKt.updateChangedFlags(i6));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState SaleOnBoardBasketContent$lambda$27$lambda$26() {
        MutableState mutableStateOf$default;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        return mutableStateOf$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleOnBoardBasketContent$lambda$33$lambda$32$lambda$31(SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState saleOnBoardCheckoutState, Function1 function1, Function1 function12, SaleOnBoardBasketViewModel.ViewState viewState, Function1 function13, Function1 function14, Function1 function15, FormValidator formValidator, Function1 function16, Function1 function17, Function1 function18, Function0 function0, Function1 function19, Function1 function110, Function2 function2, final MutableState mutableState, boolean z5, Function0 function02, final IDepartureInfo iDepartureInfo, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(1823113023, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.saleOnBoard.basket.SaleOnBoardBasketScreenKt$SaleOnBoardBasketContent$3$1$1$1
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
                    ComposerKt.traceEventStart(1823113023, i5, -1, "dk.molslinjen.ui.views.screens.saleOnBoard.basket.SaleOnBoardBasketContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SaleOnBoardBasketScreen.kt:191)");
                }
                SaleOnBoardDepartureInfoSectionKt.SaleOnBoardDepartureInfoSection(IDepartureInfo.this, StringResources_androidKt.stringResource(R.string.saleOnBoard_basket_orderingForDeparture, composer, 6), composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$SaleOnBoardBasketScreenKt.INSTANCE.m3524getLambda1$app_kombardoProd(), 3, null);
        lineItems(LazyColumn, saleOnBoardCheckoutState, function1, function12);
        crossSale(LazyColumn, viewState, function13);
        SaleOnBoardPickupTimeSectionKt.saleOnBoardPickupTimeSection(LazyColumn, viewState, saleOnBoardCheckoutState.getSelectedTimeSlot(), function14, function15);
        contactInfo(LazyColumn, saleOnBoardCheckoutState.getContactInfo(), formValidator, function16, function17, function18, function0);
        SaleOnBoardOrderUpdatesSectionKt.saleOnBoardOrderUpdatesSection(LazyColumn, viewState.getIsPushNotificationEnabled(), saleOnBoardCheckoutState, function19, function110);
        payment(LazyColumn, viewState, saleOnBoardCheckoutState, function2);
        termsAndButton(LazyColumn, ((Boolean) mutableState.getValue()).booleanValue(), viewState.getSiteInfo(), new Function1() { // from class: f4.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit SaleOnBoardBasketContent$lambda$33$lambda$32$lambda$31$lambda$30;
                SaleOnBoardBasketContent$lambda$33$lambda$32$lambda$31$lambda$30 = SaleOnBoardBasketScreenKt.SaleOnBoardBasketContent$lambda$33$lambda$32$lambda$31$lambda$30(MutableState.this, ((Boolean) obj).booleanValue());
                return SaleOnBoardBasketContent$lambda$33$lambda$32$lambda$31$lambda$30;
            }
        }, formValidator, saleOnBoardCheckoutState.getTotalPrice(), ((Boolean) mutableState.getValue()).booleanValue() && z5 && !saleOnBoardCheckoutState.getBasketLineItems().isEmpty() && saleOnBoardCheckoutState.getSelectedTimeSlot() != null, function02);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleOnBoardBasketContent$lambda$33$lambda$32$lambda$31$lambda$30(MutableState mutableState, boolean z5) {
        mutableState.setValue(Boolean.valueOf(z5));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleOnBoardBasketContent$lambda$34(SaleOnBoardBasketViewModel.ViewState viewState, SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState saleOnBoardCheckoutState, Function2 function2, Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function1 function15, FormValidator formValidator, Function1 function16, Function1 function17, Function1 function18, Function1 function19, Function1 function110, Function0 function0, Function0 function02, Function0 function03, Function0 function04, int i5, int i6, Composer composer, int i7) {
        SaleOnBoardBasketContent(viewState, saleOnBoardCheckoutState, function2, function1, function12, function13, function14, function15, formValidator, function16, function17, function18, function19, function110, function0, function02, function03, function04, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), RecomposeScopeImplKt.updateChangedFlags(i6));
        return Unit.INSTANCE;
    }

    public static final void SaleOnBoardBasketScreen(final SaleOnBoardBasketViewModel viewModel, final DestinationsNavigator navigator, final ResultRecipient<PhoneNumberCodeSelectionScreenDestination, String> phoneNumberCodeResultRecipient, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Intrinsics.checkNotNullParameter(phoneNumberCodeResultRecipient, "phoneNumberCodeResultRecipient");
        Composer startRestartGroup = composer.startRestartGroup(751098949);
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
        int i7 = i6;
        if ((i7 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(751098949, i7, -1, "dk.molslinjen.ui.views.screens.saleOnBoard.basket.SaleOnBoardBasketScreen (SaleOnBoardBasketScreen.kt:73)");
            }
            startRestartGroup.startReplaceGroup(1343782736);
            boolean changedInstance = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: f4.a
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit SaleOnBoardBasketScreen$lambda$1$lambda$0;
                        SaleOnBoardBasketScreen$lambda$1$lambda$0 = SaleOnBoardBasketScreenKt.SaleOnBoardBasketScreen$lambda$1$lambda$0(SaleOnBoardBasketViewModel.this, (String) obj);
                        return SaleOnBoardBasketScreen$lambda$1$lambda$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            OpenResultRecipientKt.onResult(phoneNumberCodeResultRecipient, null, (Function1) rememberedValue, startRestartGroup, (i7 >> 6) & 14, 1);
            SaleOnBoardBasketViewModel.ViewState viewState = (SaleOnBoardBasketViewModel.ViewState) SnapshotStateKt.collectAsState(viewModel.getViewState(), null, startRestartGroup, 0, 1).getValue();
            SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState saleOnBoardCheckoutState = (SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState) SnapshotStateKt.collectAsState(viewModel.getSaleOnBoardCheckoutState(), null, startRestartGroup, 0, 1).getValue();
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (rememberedValue2 == companion.getEmpty()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup));
                startRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                rememberedValue2 = compositionScopedCoroutineScopeCanceller;
            }
            CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue2).getCoroutineScope();
            startRestartGroup.startReplaceGroup(1343791672);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == companion.getEmpty()) {
                rememberedValue3 = new FormValidator(MapsKt.mapOf(TuplesKt.to(SaleOnBoardBasketFormField.Terms, RequiredBooleanCustomValidator.INSTANCE), TuplesKt.to(SaleOnBoardBasketFormField.Email, EmailInputValidator.INSTANCE), TuplesKt.to(SaleOnBoardBasketFormField.Name, NonEmptyStringValidator.INSTANCE), TuplesKt.to(SaleOnBoardBasketFormField.NationalNumber, PhoneNumberInputValidator.NationalNumber.INSTANCE), TuplesKt.to(SaleOnBoardBasketFormField.CountryCode, PhoneNumberInputValidator.CountryCode.INSTANCE)), coroutineScope);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            FormValidator formValidator = (FormValidator) rememberedValue3;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1343813885);
            boolean changedInstance2 = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue4 == companion.getEmpty()) {
                rememberedValue4 = new SaleOnBoardBasketScreenKt$SaleOnBoardBasketScreen$2$1(viewModel);
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            KFunction kFunction = (KFunction) rememberedValue4;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1343822038);
            boolean changedInstance3 = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (changedInstance3 || rememberedValue5 == companion.getEmpty()) {
                rememberedValue5 = new SaleOnBoardBasketScreenKt$SaleOnBoardBasketScreen$3$1(viewModel);
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            KFunction kFunction2 = (KFunction) rememberedValue5;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1343832069);
            boolean changedInstance4 = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue6 = startRestartGroup.rememberedValue();
            if (changedInstance4 || rememberedValue6 == companion.getEmpty()) {
                rememberedValue6 = new SaleOnBoardBasketScreenKt$SaleOnBoardBasketScreen$4$1(viewModel);
                startRestartGroup.updateRememberedValue(rememberedValue6);
            }
            KFunction kFunction3 = (KFunction) rememberedValue6;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1343834330);
            boolean changedInstance5 = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue7 = startRestartGroup.rememberedValue();
            if (changedInstance5 || rememberedValue7 == companion.getEmpty()) {
                rememberedValue7 = new SaleOnBoardBasketScreenKt$SaleOnBoardBasketScreen$5$1(viewModel);
                startRestartGroup.updateRememberedValue(rememberedValue7);
            }
            KFunction kFunction4 = (KFunction) rememberedValue7;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1343836052);
            boolean changedInstance6 = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue8 = startRestartGroup.rememberedValue();
            if (changedInstance6 || rememberedValue8 == companion.getEmpty()) {
                rememberedValue8 = new SaleOnBoardBasketScreenKt$SaleOnBoardBasketScreen$6$1(viewModel);
                startRestartGroup.updateRememberedValue(rememberedValue8);
            }
            KFunction kFunction5 = (KFunction) rememberedValue8;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1343837621);
            boolean changedInstance7 = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue9 = startRestartGroup.rememberedValue();
            if (changedInstance7 || rememberedValue9 == companion.getEmpty()) {
                rememberedValue9 = new SaleOnBoardBasketScreenKt$SaleOnBoardBasketScreen$7$1(viewModel);
                startRestartGroup.updateRememberedValue(rememberedValue9);
            }
            KFunction kFunction6 = (KFunction) rememberedValue9;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1343839419);
            boolean changedInstance8 = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue10 = startRestartGroup.rememberedValue();
            if (changedInstance8 || rememberedValue10 == companion.getEmpty()) {
                rememberedValue10 = new SaleOnBoardBasketScreenKt$SaleOnBoardBasketScreen$8$1(viewModel);
                startRestartGroup.updateRememberedValue(rememberedValue10);
            }
            KFunction kFunction7 = (KFunction) rememberedValue10;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1343841568);
            boolean changedInstance9 = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue11 = startRestartGroup.rememberedValue();
            if (changedInstance9 || rememberedValue11 == companion.getEmpty()) {
                rememberedValue11 = new SaleOnBoardBasketScreenKt$SaleOnBoardBasketScreen$9$1(viewModel);
                startRestartGroup.updateRememberedValue(rememberedValue11);
            }
            KFunction kFunction8 = (KFunction) rememberedValue11;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1343843848);
            boolean changedInstance10 = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue12 = startRestartGroup.rememberedValue();
            if (changedInstance10 || rememberedValue12 == companion.getEmpty()) {
                rememberedValue12 = new SaleOnBoardBasketScreenKt$SaleOnBoardBasketScreen$10$1(viewModel);
                startRestartGroup.updateRememberedValue(rememberedValue12);
            }
            KFunction kFunction9 = (KFunction) rememberedValue12;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1343851924);
            int i8 = i7 & 112;
            boolean z5 = i8 == 32;
            Object rememberedValue13 = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue13 == companion.getEmpty()) {
                rememberedValue13 = new SaleOnBoardBasketScreenKt$SaleOnBoardBasketScreen$11$1(navigator);
                startRestartGroup.updateRememberedValue(rememberedValue13);
            }
            Function0 function0 = (Function0) rememberedValue13;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1343853790);
            boolean changedInstance11 = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue14 = startRestartGroup.rememberedValue();
            if (changedInstance11 || rememberedValue14 == companion.getEmpty()) {
                rememberedValue14 = new SaleOnBoardBasketScreenKt$SaleOnBoardBasketScreen$12$1(viewModel);
                startRestartGroup.updateRememberedValue(rememberedValue14);
            }
            KFunction kFunction10 = (KFunction) rememberedValue14;
            startRestartGroup.endReplaceGroup();
            Function2 function2 = (Function2) kFunction;
            startRestartGroup.startReplaceGroup(1343815608);
            boolean z6 = i8 == 32;
            Object rememberedValue15 = startRestartGroup.rememberedValue();
            if (z6 || rememberedValue15 == companion.getEmpty()) {
                rememberedValue15 = new Function1() { // from class: f4.e
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit SaleOnBoardBasketScreen$lambda$15$lambda$14;
                        SaleOnBoardBasketScreen$lambda$15$lambda$14 = SaleOnBoardBasketScreenKt.SaleOnBoardBasketScreen$lambda$15$lambda$14(DestinationsNavigator.this, (SaleOnBoardLineItem) obj);
                        return SaleOnBoardBasketScreen$lambda$15$lambda$14;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue15);
            }
            Function1 function1 = (Function1) rememberedValue15;
            startRestartGroup.endReplaceGroup();
            Function1 function12 = (Function1) kFunction2;
            startRestartGroup.startReplaceGroup(1343824051);
            boolean z7 = i8 == 32;
            Object rememberedValue16 = startRestartGroup.rememberedValue();
            if (z7 || rememberedValue16 == companion.getEmpty()) {
                rememberedValue16 = new Function1() { // from class: f4.f
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit SaleOnBoardBasketScreen$lambda$17$lambda$16;
                        SaleOnBoardBasketScreen$lambda$17$lambda$16 = SaleOnBoardBasketScreenKt.SaleOnBoardBasketScreen$lambda$17$lambda$16(DestinationsNavigator.this, (SaleOnBoardCrossSaleProduct) obj);
                        return SaleOnBoardBasketScreen$lambda$17$lambda$16;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue16);
            }
            Function1 function13 = (Function1) rememberedValue16;
            startRestartGroup.endReplaceGroup();
            Function1 function14 = (Function1) kFunction3;
            Function1 function15 = (Function1) kFunction4;
            Function1 function16 = (Function1) kFunction6;
            Function1 function17 = (Function1) kFunction5;
            Function1 function18 = (Function1) kFunction7;
            Function1 function19 = (Function1) kFunction8;
            Function1 function110 = (Function1) kFunction9;
            startRestartGroup.startReplaceGroup(1343845992);
            boolean changedInstance12 = startRestartGroup.changedInstance(viewModel) | (i8 == 32);
            Object rememberedValue17 = startRestartGroup.rememberedValue();
            if (changedInstance12 || rememberedValue17 == companion.getEmpty()) {
                rememberedValue17 = new Function0() { // from class: f4.g
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit SaleOnBoardBasketScreen$lambda$20$lambda$19;
                        SaleOnBoardBasketScreen$lambda$20$lambda$19 = SaleOnBoardBasketScreenKt.SaleOnBoardBasketScreen$lambda$20$lambda$19(SaleOnBoardBasketViewModel.this, navigator);
                        return SaleOnBoardBasketScreen$lambda$20$lambda$19;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue17);
            }
            Function0 function02 = (Function0) rememberedValue17;
            startRestartGroup.endReplaceGroup();
            Function0 function03 = (Function0) kFunction10;
            startRestartGroup.startReplaceGroup(1343856178);
            boolean z8 = i8 == 32;
            Object rememberedValue18 = startRestartGroup.rememberedValue();
            if (z8 || rememberedValue18 == companion.getEmpty()) {
                rememberedValue18 = new Function0() { // from class: f4.h
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit SaleOnBoardBasketScreen$lambda$22$lambda$21;
                        SaleOnBoardBasketScreen$lambda$22$lambda$21 = SaleOnBoardBasketScreenKt.SaleOnBoardBasketScreen$lambda$22$lambda$21(DestinationsNavigator.this);
                        return SaleOnBoardBasketScreen$lambda$22$lambda$21;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue18);
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            SaleOnBoardBasketContent(viewState, saleOnBoardCheckoutState, function2, function1, function12, function13, function14, function15, formValidator, function16, function17, function18, function19, function110, function02, function0, function03, (Function0) rememberedValue18, composer2, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: f4.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit SaleOnBoardBasketScreen$lambda$23;
                    SaleOnBoardBasketScreen$lambda$23 = SaleOnBoardBasketScreenKt.SaleOnBoardBasketScreen$lambda$23(SaleOnBoardBasketViewModel.this, navigator, phoneNumberCodeResultRecipient, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return SaleOnBoardBasketScreen$lambda$23;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleOnBoardBasketScreen$lambda$1$lambda$0(SaleOnBoardBasketViewModel saleOnBoardBasketViewModel, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        saleOnBoardBasketViewModel.updatePhoneNumberCode(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleOnBoardBasketScreen$lambda$15$lambda$14(DestinationsNavigator destinationsNavigator, SaleOnBoardLineItem lineItem) {
        Intrinsics.checkNotNullParameter(lineItem, "lineItem");
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, SaleOnBoardProductDetailsScreenDestination.INSTANCE.invoke(lineItem.getProduct().getId(), lineItem.getId()), null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleOnBoardBasketScreen$lambda$17$lambda$16(DestinationsNavigator destinationsNavigator, SaleOnBoardCrossSaleProduct crossSaleProduct) {
        Intrinsics.checkNotNullParameter(crossSaleProduct, "crossSaleProduct");
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, SaleOnBoardProductDetailsScreenDestination.invoke$default(SaleOnBoardProductDetailsScreenDestination.INSTANCE, crossSaleProduct.getProductId(), null, 2, null), null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleOnBoardBasketScreen$lambda$20$lambda$19(SaleOnBoardBasketViewModel saleOnBoardBasketViewModel, final DestinationsNavigator destinationsNavigator) {
        saleOnBoardBasketViewModel.proceedToPayment(new Function0() { // from class: f4.j
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit SaleOnBoardBasketScreen$lambda$20$lambda$19$lambda$18;
                SaleOnBoardBasketScreen$lambda$20$lambda$19$lambda$18 = SaleOnBoardBasketScreenKt.SaleOnBoardBasketScreen$lambda$20$lambda$19$lambda$18(DestinationsNavigator.this);
                return SaleOnBoardBasketScreen$lambda$20$lambda$19$lambda$18;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleOnBoardBasketScreen$lambda$20$lambda$19$lambda$18(DestinationsNavigator destinationsNavigator) {
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, PaymentScreenDestination.INSTANCE.invoke(PaymentOrigin.SaleOnBoard), null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleOnBoardBasketScreen$lambda$22$lambda$21(DestinationsNavigator destinationsNavigator) {
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, PhoneNumberCodeSelectionScreenDestination.INSTANCE, null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleOnBoardBasketScreen$lambda$23(SaleOnBoardBasketViewModel saleOnBoardBasketViewModel, DestinationsNavigator destinationsNavigator, ResultRecipient resultRecipient, int i5, Composer composer, int i6) {
        SaleOnBoardBasketScreen(saleOnBoardBasketViewModel, destinationsNavigator, resultRecipient, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    private static final void contactInfo(LazyListScope lazyListScope, final SaleOnBoardContactInfo saleOnBoardContactInfo, final FormValidator formValidator, final Function1<? super String, Unit> function1, final Function1<? super String, Unit> function12, final Function1<? super PhoneNumber, Unit> function13, final Function0<Unit> function0) {
        LazyListScope.item$default(lazyListScope, null, null, ComposableLambdaKt.composableLambdaInstance(-213869881, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.saleOnBoard.basket.SaleOnBoardBasketScreenKt$contactInfo$1
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
                    ComposerKt.traceEventStart(-213869881, i5, -1, "dk.molslinjen.ui.views.screens.saleOnBoard.basket.contactInfo.<anonymous> (SaleOnBoardBasketScreen.kt:318)");
                }
                TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.saleOnBoard_basket_contactInfo, composer, 6), PaddingKt.m315paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m2599constructorimpl(16), 7, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphBold(), composer, 48, 1572864, 65532);
                SaleOnBoardContactInfoSectionViewKt.SaleOnBoardContactInfoSectionView(SaleOnBoardContactInfo.this, formValidator, function1, function12, function13, function0, composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), 3, null);
        LazyListScope.item$default(lazyListScope, null, null, ComposableSingletons$SaleOnBoardBasketScreenKt.INSTANCE.m3526getLambda3$app_kombardoProd(), 3, null);
    }

    private static final void crossSale(LazyListScope lazyListScope, final SaleOnBoardBasketViewModel.ViewState viewState, final Function1<? super SaleOnBoardCrossSaleProduct, Unit> function1) {
        if (viewState.getCrossSaleProducts().isEmpty()) {
            return;
        }
        LazyListScope.item$default(lazyListScope, null, null, ComposableLambdaKt.composableLambdaInstance(-1698090850, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.saleOnBoard.basket.SaleOnBoardBasketScreenKt$crossSale$1
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
                    ComposerKt.traceEventStart(-1698090850, i5, -1, "dk.molslinjen.ui.views.screens.saleOnBoard.basket.crossSale.<anonymous> (SaleOnBoardBasketScreen.kt:283)");
                }
                String stringResource = StringResources_androidKt.stringResource(R.string.saleOnBoard_basket_crossSale, composer, 6);
                TextStyle paragraphBold = TypographyKt.getParagraphBold();
                Modifier.Companion companion = Modifier.INSTANCE;
                TextKt.m940Text4IGK_g(stringResource, PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, 0.0f, 0.0f, Dp.m2599constructorimpl(16), 7, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, paragraphBold, composer, 48, 1572864, 65532);
                Modifier clip = ClipKt.clip(BorderKt.m108borderxT4_qwU(companion, Dp.m2599constructorimpl(1), AppColor.INSTANCE.m3268getGrey50d7_KjU(), ThemeShapesKt.getThemeShapes().getMedium()), ThemeShapesKt.getThemeShapes().getMedium());
                SaleOnBoardBasketViewModel.ViewState viewState2 = SaleOnBoardBasketViewModel.ViewState.this;
                Function1<SaleOnBoardCrossSaleProduct, Unit> function12 = function1;
                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
                CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, clip);
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
                composer.startReplaceGroup(-889588008);
                Iterator<SaleOnBoardCrossSaleProduct> it = viewState2.getCrossSaleProducts().iterator();
                while (it.hasNext()) {
                    SaleOnBoardCrossSaleViewKt.SaleOnBoardCrossSaleView(it.next(), function12, composer, 0);
                    HorizontalDividerKt.m3388HorizontalDividertZIQpXc(null, 0L, 0.0f, null, composer, 0, 15);
                }
                composer.endReplaceGroup();
                composer.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), 3, null);
        LazyListScope.item$default(lazyListScope, null, null, ComposableSingletons$SaleOnBoardBasketScreenKt.INSTANCE.m3525getLambda2$app_kombardoProd(), 3, null);
    }

    private static final void lineItems(LazyListScope lazyListScope, final SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState saleOnBoardCheckoutState, final Function1<? super SaleOnBoardLineItem, Unit> function1, final Function1<? super String, Unit> function12) {
        LazyListScope.item$default(lazyListScope, null, null, ComposableLambdaKt.composableLambdaInstance(-1948576893, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.saleOnBoard.basket.SaleOnBoardBasketScreenKt$lineItems$1
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
                    ComposerKt.traceEventStart(-1948576893, i5, -1, "dk.molslinjen.ui.views.screens.saleOnBoard.basket.lineItems.<anonymous> (SaleOnBoardBasketScreen.kt:254)");
                }
                String stringResource = StringResources_androidKt.stringResource(R.string.saleOnBoard_basket_yourOrder, composer, 6);
                TextStyle paragraphBold = TypographyKt.getParagraphBold();
                Modifier.Companion companion = Modifier.INSTANCE;
                TextKt.m940Text4IGK_g(stringResource, PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, 0.0f, 0.0f, Dp.m2599constructorimpl(16), 7, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, paragraphBold, composer, 48, 1572864, 65532);
                Modifier clip = ClipKt.clip(BorderKt.m108borderxT4_qwU(companion, Dp.m2599constructorimpl(1), AppColor.INSTANCE.m3268getGrey50d7_KjU(), ThemeShapesKt.getThemeShapes().getMedium()), ThemeShapesKt.getThemeShapes().getMedium());
                SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState saleOnBoardCheckoutState2 = SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState.this;
                Function1<SaleOnBoardLineItem, Unit> function13 = function1;
                Function1<String, Unit> function14 = function12;
                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
                CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, clip);
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
                composer.startReplaceGroup(-1299193044);
                Iterator<SaleOnBoardLineItem> it = saleOnBoardCheckoutState2.getBasketLineItems().iterator();
                while (it.hasNext()) {
                    SaleOnBoardLineItemViewKt.SaleOnBoardLineItemView(it.next(), function13, function14, false, composer, 0, 8);
                    HorizontalDividerKt.m3388HorizontalDividertZIQpXc(null, 0L, 0.0f, null, composer, 0, 15);
                }
                composer.endReplaceGroup();
                composer.endNode();
                PriceDetailsViewKt.TotalPriceRow(new PriceTotal(SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState.this.getTotalPrice()), null, false, null, composer, 0, 14);
                HorizontalDividerKt.m3388HorizontalDividertZIQpXc(null, 0L, 0.0f, null, composer, 0, 15);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), 3, null);
    }

    private static final void payment(LazyListScope lazyListScope, final SaleOnBoardBasketViewModel.ViewState viewState, final SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState saleOnBoardCheckoutState, final Function2<? super PaymentType, ? super CreditCard, Unit> function2) {
        LazyListScope.item$default(lazyListScope, null, null, ComposableLambdaKt.composableLambdaInstance(1700083273, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.saleOnBoard.basket.SaleOnBoardBasketScreenKt$payment$1
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
                    ComposerKt.traceEventStart(1700083273, i5, -1, "dk.molslinjen.ui.views.screens.saleOnBoard.basket.payment.<anonymous> (SaleOnBoardBasketScreen.kt:345)");
                }
                PaymentMethodSectionViewKt.PaymentMethodSectionView(SaleOnBoardBasketViewModel.ViewState.this.getPaymentTypes(), SaleOnBoardBasketViewModel.ViewState.this.getSavedCreditCards(), saleOnBoardCheckoutState.getSelectedPaymentType(), saleOnBoardCheckoutState.getSelectedCreditCard(), function2, composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), 3, null);
        LazyListScope.item$default(lazyListScope, null, null, ComposableSingletons$SaleOnBoardBasketScreenKt.INSTANCE.m3527getLambda4$app_kombardoProd(), 3, null);
    }

    private static final void termsAndButton(LazyListScope lazyListScope, final boolean z5, final SiteInfo siteInfo, final Function1<? super Boolean, Unit> function1, final IFormValidator iFormValidator, final PriceWithCurrency priceWithCurrency, final boolean z6, final Function0<Unit> function0) {
        LazyListScope.item$default(lazyListScope, null, null, ComposableLambdaKt.composableLambdaInstance(80282275, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.saleOnBoard.basket.SaleOnBoardBasketScreenKt$termsAndButton$1
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
                    ComposerKt.traceEventStart(80282275, i5, -1, "dk.molslinjen.ui.views.screens.saleOnBoard.basket.termsAndButton.<anonymous> (SaleOnBoardBasketScreen.kt:369)");
                }
                ConfirmSectionViewKt.TermsAndButtonSection(z5, siteInfo, function1, iFormValidator, new PriceTotal(priceWithCurrency), z6, null, function0, composer, 0, 64);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), 3, null);
    }
}
