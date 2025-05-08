package dk.molslinjen.ui.views.screens.agreements.multiride.purchase;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import com.ramcosta.composedestinations.generated.destinations.PhoneNumberCodeSelectionScreenDestination;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import com.ramcosta.composedestinations.result.OpenResultRecipientKt;
import com.ramcosta.composedestinations.result.ResultRecipient;
import dk.molslinjen.domain.managers.agreement.multiride.purchase.IMultiRideCardCheckoutManager;
import dk.molslinjen.domain.managers.checkout.PriceTotal;
import dk.molslinjen.domain.model.account.CreditCard;
import dk.molslinjen.domain.model.payment.PaymentType;
import dk.molslinjen.domain.model.shared.PhoneNumber;
import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import dk.molslinjen.domain.model.site.SiteInfo;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.views.reusable.bottomsheet.BottomSheetContainerKt;
import dk.molslinjen.ui.views.reusable.input.validation.FormValidator;
import dk.molslinjen.ui.views.reusable.input.validation.IFormValidator;
import dk.molslinjen.ui.views.reusable.input.validation.validators.EmailInputValidator;
import dk.molslinjen.ui.views.reusable.input.validation.validators.NonEmptyStringValidator;
import dk.molslinjen.ui.views.reusable.input.validation.validators.PhoneNumberInputValidator;
import dk.molslinjen.ui.views.reusable.input.validation.validators.RequiredBooleanCustomValidator;
import dk.molslinjen.ui.views.screens.agreements.multiride.common.MultiRideSummaryCardKt;
import dk.molslinjen.ui.views.screens.agreements.multiride.purchase.MultiRideCardPurchaseSummaryScreenKt;
import dk.molslinjen.ui.views.screens.agreements.multiride.purchase.MultiRidePurchaseSummaryViewModel;
import dk.molslinjen.ui.views.screens.booking.summary.BookingSummaryFormField;
import dk.molslinjen.ui.views.screens.booking.summary.ConfirmSectionViewKt;
import dk.molslinjen.ui.views.screens.booking.summary.PaymentMethodSectionViewKt;
import dk.molslinjen.ui.views.screens.booking.summary.PersonalInfoSectionViewKt;
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
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a3\u0010\t\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0007¢\u0006\u0004\b\t\u0010\n\u001aÅ\u0001\u0010\"\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\b0\u00132\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u00132\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u00132\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u00182\u001a\u0010\u001d\u001a\u0016\u0012\u0004\u0012\u00020\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0012\u0004\u0012\u00020\b0\u001a2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\b0\u00132\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\b0\u00182\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\b0\u0018H\u0003¢\u0006\u0004\b\"\u0010#\u001a\u0013\u0010%\u001a\u00020\b*\u00020$H\u0002¢\u0006\u0004\b%\u0010&¨\u0006'"}, d2 = {"Ldk/molslinjen/ui/views/screens/agreements/multiride/purchase/MultiRidePurchaseSummaryViewModel;", "viewModel", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "navigator", "Lcom/ramcosta/composedestinations/result/ResultRecipient;", "Lcom/ramcosta/composedestinations/generated/destinations/PhoneNumberCodeSelectionScreenDestination;", BuildConfig.FLAVOR, "resultRecipient", BuildConfig.FLAVOR, "MultiRideCardPurchaseSummaryScreen", "(Ldk/molslinjen/ui/views/screens/agreements/multiride/purchase/MultiRidePurchaseSummaryViewModel;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Lcom/ramcosta/composedestinations/result/ResultRecipient;Landroidx/compose/runtime/Composer;I)V", "Ldk/molslinjen/ui/views/screens/agreements/multiride/purchase/MultiRidePurchaseSummaryViewModel$ViewState;", "viewState", "Ldk/molslinjen/domain/managers/agreement/multiride/purchase/IMultiRideCardCheckoutManager$CheckoutState;", "checkoutState", "Landroidx/compose/foundation/lazy/LazyListState;", "scrollState", "Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator;", "validator", "Lkotlin/Function1;", "Ldk/molslinjen/domain/model/shared/PhoneNumber;", "onPhoneNumberChange", "onEmailChange", "onPostalCodeChange", "Lkotlin/Function0;", "startPersonalInfoEdit", "Lkotlin/Function2;", "Ldk/molslinjen/domain/model/payment/PaymentType;", "Ldk/molslinjen/domain/model/account/CreditCard;", "onPaymentMethodSelected", BuildConfig.FLAVOR, "onTermsAcceptUpdated", "proceed", "showPhoneNumberCodeSelector", "Content", "(Ldk/molslinjen/ui/views/screens/agreements/multiride/purchase/MultiRidePurchaseSummaryViewModel$ViewState;Ldk/molslinjen/domain/managers/agreement/multiride/purchase/IMultiRideCardCheckoutManager$CheckoutState;Landroidx/compose/foundation/lazy/LazyListState;Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/foundation/lazy/LazyListScope;", "splitterItem", "(Landroidx/compose/foundation/lazy/LazyListScope;)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class MultiRideCardPurchaseSummaryScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void Content(final MultiRidePurchaseSummaryViewModel.ViewState viewState, final IMultiRideCardCheckoutManager.CheckoutState checkoutState, final LazyListState lazyListState, final IFormValidator iFormValidator, final Function1<? super PhoneNumber, Unit> function1, final Function1<? super String, Unit> function12, final Function1<? super String, Unit> function13, final Function0<Unit> function0, final Function2<? super PaymentType, ? super CreditCard, Unit> function2, final Function1<? super Boolean, Unit> function14, final Function0<Unit> function02, final Function0<Unit> function03, Composer composer, final int i5, final int i6) {
        int i7;
        int i8;
        int i9;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(427510382);
        if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changedInstance(viewState) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changedInstance(checkoutState) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i7 |= startRestartGroup.changed(lazyListState) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i7 |= (i5 & 4096) == 0 ? startRestartGroup.changed(iFormValidator) : startRestartGroup.changedInstance(iFormValidator) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i7 |= startRestartGroup.changedInstance(function1) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i7 |= startRestartGroup.changedInstance(function12) ? 131072 : 65536;
        }
        if ((i5 & 1572864) == 0) {
            i7 |= startRestartGroup.changedInstance(function13) ? 1048576 : 524288;
        }
        if ((i5 & 12582912) == 0) {
            i7 |= startRestartGroup.changedInstance(function0) ? 8388608 : 4194304;
        }
        if ((i5 & 100663296) == 0) {
            i7 |= startRestartGroup.changedInstance(function2) ? 67108864 : 33554432;
        }
        if ((i5 & 805306368) == 0) {
            i7 |= startRestartGroup.changedInstance(function14) ? 536870912 : 268435456;
        }
        if ((i6 & 6) == 0) {
            i8 = i6 | (startRestartGroup.changedInstance(function02) ? 4 : 2);
        } else {
            i8 = i6;
        }
        if ((i6 & 48) == 0) {
            i8 |= startRestartGroup.changedInstance(function03) ? 32 : 16;
        }
        int i10 = i8;
        if ((i7 & 306783379) == 306783378 && (i10 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(427510382, i7, i10, "dk.molslinjen.ui.views.screens.agreements.multiride.purchase.Content (MultiRideCardPurchaseSummaryScreen.kt:132)");
            }
            final PriceWithCurrency totalPrice = checkoutState.getTotalPrice();
            if (totalPrice == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: B2.c
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit Content$lambda$7;
                            Content$lambda$7 = MultiRideCardPurchaseSummaryScreenKt.Content$lambda$7(MultiRidePurchaseSummaryViewModel.ViewState.this, checkoutState, lazyListState, iFormValidator, function1, function12, function13, function0, function2, function14, function02, function03, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                            return Content$lambda$7;
                        }
                    });
                    return;
                }
                return;
            }
            float f5 = 24;
            PaddingValues m309PaddingValuesa9UjIt4 = PaddingKt.m309PaddingValuesa9UjIt4(Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(16), Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(f5));
            startRestartGroup.startReplaceGroup(932021781);
            boolean changedInstance = startRestartGroup.changedInstance(checkoutState) | startRestartGroup.changedInstance(viewState) | ((i7 & 7168) == 2048 || ((i7 & 4096) != 0 && startRestartGroup.changedInstance(iFormValidator))) | ((57344 & i7) == 16384) | ((458752 & i7) == 131072) | ((3670016 & i7) == 1048576) | ((29360128 & i7) == 8388608) | ((i10 & 112) == 32) | ((234881024 & i7) == 67108864) | ((1879048192 & i7) == 536870912) | startRestartGroup.changedInstance(totalPrice) | ((i10 & 14) == 4);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                i9 = i7;
                composer2 = startRestartGroup;
                Function1 function15 = new Function1() { // from class: B2.d
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit Content$lambda$9$lambda$8;
                        Content$lambda$9$lambda$8 = MultiRideCardPurchaseSummaryScreenKt.Content$lambda$9$lambda$8(IMultiRideCardCheckoutManager.CheckoutState.this, viewState, iFormValidator, function1, function12, function13, function0, function03, function2, function14, totalPrice, function02, (LazyListScope) obj);
                        return Content$lambda$9$lambda$8;
                    }
                };
                composer2.updateRememberedValue(function15);
                rememberedValue = function15;
            } else {
                i9 = i7;
                composer2 = startRestartGroup;
            }
            composer2.endReplaceGroup();
            LazyDslKt.LazyColumn(null, lazyListState, m309PaddingValuesa9UjIt4, false, null, null, null, false, (Function1) rememberedValue, composer2, ((i9 >> 3) & 112) | 384, 249);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup2 = composer2.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.updateScope(new Function2() { // from class: B2.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit Content$lambda$10;
                    Content$lambda$10 = MultiRideCardPurchaseSummaryScreenKt.Content$lambda$10(MultiRidePurchaseSummaryViewModel.ViewState.this, checkoutState, lazyListState, iFormValidator, function1, function12, function13, function0, function2, function14, function02, function03, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                    return Content$lambda$10;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$10(MultiRidePurchaseSummaryViewModel.ViewState viewState, IMultiRideCardCheckoutManager.CheckoutState checkoutState, LazyListState lazyListState, IFormValidator iFormValidator, Function1 function1, Function1 function12, Function1 function13, Function0 function0, Function2 function2, Function1 function14, Function0 function02, Function0 function03, int i5, int i6, Composer composer, int i7) {
        Content(viewState, checkoutState, lazyListState, iFormValidator, function1, function12, function13, function0, function2, function14, function02, function03, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), RecomposeScopeImplKt.updateChangedFlags(i6));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$7(MultiRidePurchaseSummaryViewModel.ViewState viewState, IMultiRideCardCheckoutManager.CheckoutState checkoutState, LazyListState lazyListState, IFormValidator iFormValidator, Function1 function1, Function1 function12, Function1 function13, Function0 function0, Function2 function2, Function1 function14, Function0 function02, Function0 function03, int i5, int i6, Composer composer, int i7) {
        Content(viewState, checkoutState, lazyListState, iFormValidator, function1, function12, function13, function0, function2, function14, function02, function03, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), RecomposeScopeImplKt.updateChangedFlags(i6));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$9$lambda$8(final IMultiRideCardCheckoutManager.CheckoutState checkoutState, final MultiRidePurchaseSummaryViewModel.ViewState viewState, final IFormValidator iFormValidator, final Function1 function1, final Function1 function12, final Function1 function13, final Function0 function0, final Function0 function02, final Function2 function2, final Function1 function14, final PriceWithCurrency priceWithCurrency, final Function0 function03, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(2112909058, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.agreements.multiride.purchase.MultiRideCardPurchaseSummaryScreenKt$Content$1$1$1
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
                    ComposerKt.traceEventStart(2112909058, i5, -1, "dk.molslinjen.ui.views.screens.agreements.multiride.purchase.Content.<anonymous>.<anonymous>.<anonymous> (MultiRideCardPurchaseSummaryScreen.kt:139)");
                }
                MultiRideSummaryCardKt.MultiRideSummaryCard(IMultiRideCardCheckoutManager.CheckoutState.this.getSummaryCardInfo(), false, composer, 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), 3, null);
        splitterItem(LazyColumn);
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-448846407, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.agreements.multiride.purchase.MultiRideCardPurchaseSummaryScreenKt$Content$1$1$2
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
                    ComposerKt.traceEventStart(-448846407, i5, -1, "dk.molslinjen.ui.views.screens.agreements.multiride.purchase.Content.<anonymous>.<anonymous>.<anonymous> (MultiRideCardPurchaseSummaryScreen.kt:146)");
                }
                PersonalInfoSectionViewKt.PersonalInfoSection(IMultiRideCardCheckoutManager.CheckoutState.this.getPersonalInfo(), iFormValidator, function1, function12, function13, function0, function02, viewState.getPersonalInfoIsInEditMode(), composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), 3, null);
        splitterItem(LazyColumn);
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-752703942, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.agreements.multiride.purchase.MultiRideCardPurchaseSummaryScreenKt$Content$1$1$3
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
                    ComposerKt.traceEventStart(-752703942, i5, -1, "dk.molslinjen.ui.views.screens.agreements.multiride.purchase.Content.<anonymous>.<anonymous>.<anonymous> (MultiRideCardPurchaseSummaryScreen.kt:159)");
                }
                PaymentMethodSectionViewKt.PaymentMethodSectionView(MultiRidePurchaseSummaryViewModel.ViewState.this.getPaymentTypes(), MultiRidePurchaseSummaryViewModel.ViewState.this.getSavedCreditCards(), checkoutState.getSelectedPaymentType(), checkoutState.getSelectedCreditCard(), function2, composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), 3, null);
        splitterItem(LazyColumn);
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-1056561477, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.agreements.multiride.purchase.MultiRideCardPurchaseSummaryScreenKt$Content$1$1$4
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
                    ComposerKt.traceEventStart(-1056561477, i5, -1, "dk.molslinjen.ui.views.screens.agreements.multiride.purchase.Content.<anonymous>.<anonymous>.<anonymous> (MultiRideCardPurchaseSummaryScreen.kt:170)");
                }
                boolean termsAccepted = MultiRidePurchaseSummaryViewModel.ViewState.this.getTermsAccepted();
                SiteInfo siteInfo = checkoutState.getSiteInfo();
                Function1<Boolean, Unit> function15 = function14;
                IFormValidator iFormValidator2 = iFormValidator;
                PriceTotal priceTotal = new PriceTotal(priceWithCurrency);
                boolean z5 = false;
                if (((Boolean) SnapshotStateKt.collectAsState(iFormValidator.isFormValid(), null, composer, 0, 1).getValue()).booleanValue() && checkoutState.getSummaryCardInfo() != null) {
                    z5 = true;
                }
                ConfirmSectionViewKt.TermsAndButtonSection(termsAccepted, siteInfo, function15, iFormValidator2, priceTotal, z5, StringResources_androidKt.stringResource(R.string.button_confirmAndPay, composer, 6), function03, composer, 0, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), 3, null);
        return Unit.INSTANCE;
    }

    public static final void MultiRideCardPurchaseSummaryScreen(final MultiRidePurchaseSummaryViewModel viewModel, final DestinationsNavigator navigator, final ResultRecipient<PhoneNumberCodeSelectionScreenDestination, String> resultRecipient, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Intrinsics.checkNotNullParameter(resultRecipient, "resultRecipient");
        Composer startRestartGroup = composer.startRestartGroup(1464554248);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewModel) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(navigator) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changed(resultRecipient) ? 256 : 128;
        }
        int i7 = i6;
        if ((i7 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1464554248, i7, -1, "dk.molslinjen.ui.views.screens.agreements.multiride.purchase.MultiRideCardPurchaseSummaryScreen (MultiRideCardPurchaseSummaryScreen.kt:61)");
            }
            startRestartGroup.startReplaceGroup(-895023341);
            boolean changedInstance = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: B2.a
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit MultiRideCardPurchaseSummaryScreen$lambda$1$lambda$0;
                        MultiRideCardPurchaseSummaryScreen$lambda$1$lambda$0 = MultiRideCardPurchaseSummaryScreenKt.MultiRideCardPurchaseSummaryScreen$lambda$1$lambda$0(MultiRidePurchaseSummaryViewModel.this, (String) obj);
                        return MultiRideCardPurchaseSummaryScreen$lambda$1$lambda$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            OpenResultRecipientKt.onResult(resultRecipient, null, (Function1) rememberedValue, startRestartGroup, (i7 >> 6) & 14, 1);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (rememberedValue2 == companion.getEmpty()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup));
                startRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                rememberedValue2 = compositionScopedCoroutineScopeCanceller;
            }
            CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue2).getCoroutineScope();
            MultiRidePurchaseSummaryViewModel.ViewState viewState = (MultiRidePurchaseSummaryViewModel.ViewState) SnapshotStateKt.collectAsState(viewModel.getViewState(), null, startRestartGroup, 0, 1).getValue();
            IMultiRideCardCheckoutManager.CheckoutState checkoutState = (IMultiRideCardCheckoutManager.CheckoutState) SnapshotStateKt.collectAsState(viewModel.getCheckoutState(), null, startRestartGroup, 0, 1).getValue();
            LazyListState rememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, startRestartGroup, 0, 3);
            startRestartGroup.startReplaceGroup(-895013230);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == companion.getEmpty()) {
                rememberedValue3 = new FormValidator(MapsKt.mapOf(TuplesKt.to(BookingSummaryFormField.Terms, RequiredBooleanCustomValidator.INSTANCE), TuplesKt.to(BookingSummaryFormField.NationalNumber, PhoneNumberInputValidator.NationalNumber.INSTANCE), TuplesKt.to(BookingSummaryFormField.CountryCode, PhoneNumberInputValidator.CountryCode.INSTANCE), TuplesKt.to(BookingSummaryFormField.Email, EmailInputValidator.INSTANCE), TuplesKt.to(BookingSummaryFormField.PostalCode, NonEmptyStringValidator.INSTANCE)), coroutineScope);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            FormValidator formValidator = (FormValidator) rememberedValue3;
            startRestartGroup.endReplaceGroup();
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            AppColor appColor = AppColor.INSTANCE;
            Modifier m104backgroundbw27NRU$default = BackgroundKt.m104backgroundbw27NRU$default(fillMaxSize$default, appColor.m3269getGrey60d7_KjU(), null, 2, null);
            String stringResource = StringResources_androidKt.stringResource(R.string.bookingSummary_proceed, startRestartGroup, 6);
            long m3269getGrey60d7_KjU = appColor.m3269getGrey60d7_KjU();
            startRestartGroup.startReplaceGroup(-894988041);
            int i8 = i7 & 112;
            boolean z5 = i8 == 32;
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue4 == companion.getEmpty()) {
                rememberedValue4 = new MultiRideCardPurchaseSummaryScreenKt$MultiRideCardPurchaseSummaryScreen$2$1(navigator);
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            Function0 function0 = (Function0) rememberedValue4;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-894986473);
            boolean z6 = i8 == 32;
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (z6 || rememberedValue5 == companion.getEmpty()) {
                rememberedValue5 = new MultiRideCardPurchaseSummaryScreenKt$MultiRideCardPurchaseSummaryScreen$3$1(navigator);
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            Function0 function02 = (Function0) rememberedValue5;
            startRestartGroup.endReplaceGroup();
            ComposableLambda rememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1512997925, true, new MultiRideCardPurchaseSummaryScreenKt$MultiRideCardPurchaseSummaryScreen$4(viewModel, viewState, checkoutState, rememberLazyListState, formValidator, navigator), startRestartGroup, 54);
            composer2 = startRestartGroup;
            BottomSheetContainerKt.m3399BottomSheetContainerZO57_FM(m104backgroundbw27NRU$default, 0.0f, stringResource, null, m3269getGrey60d7_KjU, function0, function02, rememberLazyListState, null, rememberComposableLambda, composer2, 805330950, 266);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: B2.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit MultiRideCardPurchaseSummaryScreen$lambda$6;
                    MultiRideCardPurchaseSummaryScreen$lambda$6 = MultiRideCardPurchaseSummaryScreenKt.MultiRideCardPurchaseSummaryScreen$lambda$6(MultiRidePurchaseSummaryViewModel.this, navigator, resultRecipient, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return MultiRideCardPurchaseSummaryScreen$lambda$6;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MultiRideCardPurchaseSummaryScreen$lambda$1$lambda$0(MultiRidePurchaseSummaryViewModel multiRidePurchaseSummaryViewModel, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        multiRidePurchaseSummaryViewModel.updatePhoneNumberCode(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MultiRideCardPurchaseSummaryScreen$lambda$6(MultiRidePurchaseSummaryViewModel multiRidePurchaseSummaryViewModel, DestinationsNavigator destinationsNavigator, ResultRecipient resultRecipient, int i5, Composer composer, int i6) {
        MultiRideCardPurchaseSummaryScreen(multiRidePurchaseSummaryViewModel, destinationsNavigator, resultRecipient, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    private static final void splitterItem(LazyListScope lazyListScope) {
        LazyListScope.item$default(lazyListScope, null, null, ComposableSingletons$MultiRideCardPurchaseSummaryScreenKt.INSTANCE.m3436getLambda1$app_kombardoProd(), 3, null);
    }
}
