package dk.molslinjen.ui.views.screens.booking.simpleChange;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.unit.Dp;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import dk.molslinjen.domain.managers.checkout.SimpleChangeCheckoutManager;
import dk.molslinjen.domain.model.account.CreditCard;
import dk.molslinjen.domain.model.payment.PaymentType;
import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.views.global.navigation.bottomsheet.BlockedDismissType;
import dk.molslinjen.ui.views.global.navigation.bottomsheet.BottomSheetDismissHandler;
import dk.molslinjen.ui.views.reusable.bottomsheet.BottomSheetContainerKt;
import dk.molslinjen.ui.views.reusable.input.validation.FormValidator;
import dk.molslinjen.ui.views.reusable.input.validation.IFormValidator;
import dk.molslinjen.ui.views.reusable.input.validation.validators.RequiredBooleanCustomValidator;
import dk.molslinjen.ui.views.screens.booking.simpleChange.SimpleChangeSummaryScreenKt;
import dk.molslinjen.ui.views.screens.booking.simpleChange.SimpleChangeSummaryViewModel;
import dk.molslinjen.ui.views.screens.booking.summary.BookingSummaryFormField;
import dk.molslinjen.ui.views.screens.booking.summary.PaymentMethodSectionViewKt;
import java.util.Collection;
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
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a7\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000b\u0010\f\u001aQ\u0010\u0019\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u001a\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0004\u0012\u00020\n0\u00132\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u0017H\u0003¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/simpleChange/SimpleChangeSummaryViewModel;", "viewModel", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "navigator", "Landroidx/navigation/NavController;", "navController", "Landroidx/navigation/NavBackStackEntry;", "navBackStackEntry", "Ldk/molslinjen/ui/views/global/navigation/bottomsheet/BottomSheetDismissHandler;", "bottomSheetDismissHandler", BuildConfig.FLAVOR, "SimpleChangeSummaryScreen", "(Ldk/molslinjen/ui/views/screens/booking/simpleChange/SimpleChangeSummaryViewModel;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Landroidx/navigation/NavController;Landroidx/navigation/NavBackStackEntry;Ldk/molslinjen/ui/views/global/navigation/bottomsheet/BottomSheetDismissHandler;Landroidx/compose/runtime/Composer;I)V", "Ldk/molslinjen/ui/views/screens/booking/simpleChange/SimpleChangeSummaryViewModel$ViewState;", "state", "Ldk/molslinjen/domain/managers/checkout/SimpleChangeCheckoutManager$SimpleChangeCheckoutState;", "simpleChangeCheckoutState", "Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator;", "validator", "Lkotlin/Function2;", "Ldk/molslinjen/domain/model/payment/PaymentType;", "Ldk/molslinjen/domain/model/account/CreditCard;", "paymentMethodSelected", "Lkotlin/Function0;", "proceed", "ChangeProductSummaryContent", "(Ldk/molslinjen/ui/views/screens/booking/simpleChange/SimpleChangeSummaryViewModel$ViewState;Ldk/molslinjen/domain/managers/checkout/SimpleChangeCheckoutManager$SimpleChangeCheckoutState;Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class SimpleChangeSummaryScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void ChangeProductSummaryContent(final SimpleChangeSummaryViewModel.ViewState viewState, final SimpleChangeCheckoutManager.SimpleChangeCheckoutState simpleChangeCheckoutState, final IFormValidator iFormValidator, final Function2<? super PaymentType, ? super CreditCard, Unit> function2, final Function0<Unit> function0, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-234742692);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewState) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(simpleChangeCheckoutState) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= (i5 & 512) == 0 ? startRestartGroup.changed(iFormValidator) : startRestartGroup.changedInstance(iFormValidator) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(function2) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(function0) ? 16384 : 8192;
        }
        int i7 = i6;
        if ((i7 & 9363) == 9362 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-234742692, i7, -1, "dk.molslinjen.ui.views.screens.booking.simpleChange.ChangeProductSummaryContent (SimpleChangeSummaryScreen.kt:112)");
            }
            Object[] objArr = new Object[0];
            startRestartGroup.startReplaceGroup(-1341793863);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: d3.c
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        MutableState ChangeProductSummaryContent$lambda$5$lambda$4;
                        ChangeProductSummaryContent$lambda$5$lambda$4 = SimpleChangeSummaryScreenKt.ChangeProductSummaryContent$lambda$5$lambda$4();
                        return ChangeProductSummaryContent$lambda$5$lambda$4;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            final MutableState mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr, null, null, (Function0) rememberedValue, startRestartGroup, 3072, 6);
            final PriceWithCurrency totalPrice = simpleChangeCheckoutState.getTotalPrice();
            if (totalPrice == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: d3.d
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit ChangeProductSummaryContent$lambda$6;
                            ChangeProductSummaryContent$lambda$6 = SimpleChangeSummaryScreenKt.ChangeProductSummaryContent$lambda$6(SimpleChangeSummaryViewModel.ViewState.this, simpleChangeCheckoutState, iFormValidator, function2, function0, i5, (Composer) obj, ((Integer) obj2).intValue());
                            return ChangeProductSummaryContent$lambda$6;
                        }
                    });
                    return;
                }
                return;
            }
            Modifier m313paddingVpY3zN4$default = PaddingKt.m313paddingVpY3zN4$default(BackgroundKt.m104backgroundbw27NRU$default(SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), AppColor.INSTANCE.m3269getGrey60d7_KjU(), null, 2, null), Dp.m2599constructorimpl(16), 0.0f, 2, null);
            PaddingValues m310PaddingValuesa9UjIt4$default = PaddingKt.m310PaddingValuesa9UjIt4$default(0.0f, Dp.m2599constructorimpl(0), 0.0f, Dp.m2599constructorimpl(40), 5, null);
            Arrangement.HorizontalOrVertical m265spacedBy0680j_4 = Arrangement.INSTANCE.m265spacedBy0680j_4(Dp.m2599constructorimpl(32));
            startRestartGroup.startReplaceGroup(-1341780272);
            boolean changedInstance = ((i7 & 57344) == 16384) | startRestartGroup.changedInstance(simpleChangeCheckoutState) | startRestartGroup.changedInstance(totalPrice) | startRestartGroup.changedInstance(viewState) | ((i7 & 7168) == 2048) | startRestartGroup.changed(mutableState) | ((i7 & 896) == 256 || ((i7 & 512) != 0 && startRestartGroup.changedInstance(iFormValidator)));
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue2 == companion.getEmpty()) {
                Function1 function1 = new Function1() { // from class: d3.e
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit ChangeProductSummaryContent$lambda$8$lambda$7;
                        ChangeProductSummaryContent$lambda$8$lambda$7 = SimpleChangeSummaryScreenKt.ChangeProductSummaryContent$lambda$8$lambda$7(SimpleChangeCheckoutManager.SimpleChangeCheckoutState.this, totalPrice, viewState, function2, mutableState, iFormValidator, function0, (LazyListScope) obj);
                        return ChangeProductSummaryContent$lambda$8$lambda$7;
                    }
                };
                startRestartGroup.updateRememberedValue(function1);
                rememberedValue2 = function1;
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            LazyDslKt.LazyColumn(m313paddingVpY3zN4$default, null, m310PaddingValuesa9UjIt4$default, false, m265spacedBy0680j_4, null, null, false, (Function1) rememberedValue2, composer2, 24966, 234);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup2 = composer2.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.updateScope(new Function2() { // from class: d3.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ChangeProductSummaryContent$lambda$9;
                    ChangeProductSummaryContent$lambda$9 = SimpleChangeSummaryScreenKt.ChangeProductSummaryContent$lambda$9(SimpleChangeSummaryViewModel.ViewState.this, simpleChangeCheckoutState, iFormValidator, function2, function0, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return ChangeProductSummaryContent$lambda$9;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState ChangeProductSummaryContent$lambda$5$lambda$4() {
        MutableState mutableStateOf$default;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        return mutableStateOf$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChangeProductSummaryContent$lambda$6(SimpleChangeSummaryViewModel.ViewState viewState, SimpleChangeCheckoutManager.SimpleChangeCheckoutState simpleChangeCheckoutState, IFormValidator iFormValidator, Function2 function2, Function0 function0, int i5, Composer composer, int i6) {
        ChangeProductSummaryContent(viewState, simpleChangeCheckoutState, iFormValidator, function2, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChangeProductSummaryContent$lambda$8$lambda$7(final SimpleChangeCheckoutManager.SimpleChangeCheckoutState simpleChangeCheckoutState, final PriceWithCurrency priceWithCurrency, final SimpleChangeSummaryViewModel.ViewState viewState, final Function2 function2, MutableState mutableState, IFormValidator iFormValidator, Function0 function0, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-1937148176, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.simpleChange.SimpleChangeSummaryScreenKt$ChangeProductSummaryContent$1$1$1
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
                    ComposerKt.traceEventStart(-1937148176, i5, -1, "dk.molslinjen.ui.views.screens.booking.simpleChange.ChangeProductSummaryContent.<anonymous>.<anonymous>.<anonymous> (SimpleChangeSummaryScreen.kt:125)");
                }
                SimpleChangeTicketSummaryViewKt.SimpleChangeTicketSummaryView(CollectionsKt.plus((Collection) SimpleChangeCheckoutManager.SimpleChangeCheckoutState.this.getAddons(), (Iterable) SimpleChangeCheckoutManager.SimpleChangeCheckoutState.this.getFood()), priceWithCurrency, composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), 3, null);
        ComposableSingletons$SimpleChangeSummaryScreenKt composableSingletons$SimpleChangeSummaryScreenKt = ComposableSingletons$SimpleChangeSummaryScreenKt.INSTANCE;
        LazyListScope.item$default(LazyColumn, null, null, composableSingletons$SimpleChangeSummaryScreenKt.m3467getLambda1$app_kombardoProd(), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-615312856, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.simpleChange.SimpleChangeSummaryScreenKt$ChangeProductSummaryContent$1$1$2
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
                    ComposerKt.traceEventStart(-615312856, i5, -1, "dk.molslinjen.ui.views.screens.booking.simpleChange.ChangeProductSummaryContent.<anonymous>.<anonymous>.<anonymous> (SimpleChangeSummaryScreen.kt:134)");
                }
                PaymentMethodSectionViewKt.PaymentMethodSectionView(SimpleChangeSummaryViewModel.ViewState.this.getPaymentTypes(), SimpleChangeSummaryViewModel.ViewState.this.getSavedCreditCards(), simpleChangeCheckoutState.getSelectedPaymentType(), simpleChangeCheckoutState.getSelectedCreditCard(), function2, composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, composableSingletons$SimpleChangeSummaryScreenKt.m3468getLambda2$app_kombardoProd(), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-1404120534, true, new SimpleChangeSummaryScreenKt$ChangeProductSummaryContent$1$1$3(mutableState, viewState, simpleChangeCheckoutState, priceWithCurrency, iFormValidator, function0)), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChangeProductSummaryContent$lambda$9(SimpleChangeSummaryViewModel.ViewState viewState, SimpleChangeCheckoutManager.SimpleChangeCheckoutState simpleChangeCheckoutState, IFormValidator iFormValidator, Function2 function2, Function0 function0, int i5, Composer composer, int i6) {
        ChangeProductSummaryContent(viewState, simpleChangeCheckoutState, iFormValidator, function2, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void SimpleChangeSummaryScreen(final SimpleChangeSummaryViewModel viewModel, final DestinationsNavigator navigator, final NavController navController, final NavBackStackEntry navBackStackEntry, final BottomSheetDismissHandler bottomSheetDismissHandler, Composer composer, final int i5) {
        int i6;
        int i7;
        Composer composer2;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Intrinsics.checkNotNullParameter(navController, "navController");
        Intrinsics.checkNotNullParameter(navBackStackEntry, "navBackStackEntry");
        Intrinsics.checkNotNullParameter(bottomSheetDismissHandler, "bottomSheetDismissHandler");
        Composer startRestartGroup = composer.startRestartGroup(-447374925);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewModel) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(navigator) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(navController) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(navBackStackEntry) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(bottomSheetDismissHandler) ? 16384 : 8192;
        }
        int i8 = i6;
        if ((i8 & 9363) == 9362 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-447374925, i8, -1, "dk.molslinjen.ui.views.screens.booking.simpleChange.SimpleChangeSummaryScreen (SimpleChangeSummaryScreen.kt:54)");
            }
            bottomSheetDismissHandler.SetupHandling(navBackStackEntry, navController, navigator, BlockedDismissType.DragToDismissAndBackAction, startRestartGroup, ((i8 >> 9) & 14) | 3072 | ((i8 >> 3) & 112) | ((i8 << 3) & 896) | (57344 & i8));
            SimpleChangeSummaryViewModel.ViewState viewState = (SimpleChangeSummaryViewModel.ViewState) SnapshotStateKt.collectAsState(viewModel.getViewState(), null, startRestartGroup, 0, 1).getValue();
            SimpleChangeCheckoutManager.SimpleChangeCheckoutState simpleChangeCheckoutState = (SimpleChangeCheckoutManager.SimpleChangeCheckoutState) SnapshotStateKt.collectAsState(viewModel.getSimpleChangeCheckoutState(), null, startRestartGroup, 0, 1).getValue();
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup));
                startRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                rememberedValue = compositionScopedCoroutineScopeCanceller;
            }
            CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
            startRestartGroup.startReplaceGroup(1331070329);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = new FormValidator(MapsKt.mapOf(TuplesKt.to(BookingSummaryFormField.Terms, RequiredBooleanCustomValidator.INSTANCE)), coroutineScope);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            FormValidator formValidator = (FormValidator) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            if (Intrinsics.areEqual(simpleChangeCheckoutState.getEarlyCheckIn(), Boolean.TRUE)) {
                PriceWithCurrency totalPrice = simpleChangeCheckoutState.getTotalPrice();
                i7 = (totalPrice != null ? totalPrice.getValue() : 0) > 0 ? R.string.earlyCheckIn_payAndCheckIn : R.string.earlyCheckIn_title;
            } else {
                i7 = R.string.simpleChange_summary_title;
            }
            String stringResource = StringResources_androidKt.stringResource(i7, startRestartGroup, 0);
            long m3269getGrey60d7_KjU = AppColor.INSTANCE.m3269getGrey60d7_KjU();
            AnnotatedString annotatedString = new AnnotatedString(stringResource, null, null, 6, null);
            startRestartGroup.startReplaceGroup(1331093119);
            boolean changedInstance = startRestartGroup.changedInstance(bottomSheetDismissHandler) | ((i8 & 112) == 32);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue3 == companion.getEmpty()) {
                rememberedValue3 = new Function0() { // from class: d3.a
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit SimpleChangeSummaryScreen$lambda$2$lambda$1;
                        SimpleChangeSummaryScreen$lambda$2$lambda$1 = SimpleChangeSummaryScreenKt.SimpleChangeSummaryScreen$lambda$2$lambda$1(BottomSheetDismissHandler.this, navigator);
                        return SimpleChangeSummaryScreen$lambda$2$lambda$1;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            BottomSheetContainerKt.m3398BottomSheetContainer8Un_QVk(null, 0.0f, m3269getGrey60d7_KjU, annotatedString, null, null, (Function0) rememberedValue3, null, null, ComposableLambdaKt.rememberComposableLambda(-1194780986, true, new SimpleChangeSummaryScreenKt$SimpleChangeSummaryScreen$2(viewModel, viewState, simpleChangeCheckoutState, formValidator, bottomSheetDismissHandler, navigator), startRestartGroup, 54), composer2, 805306752, 435);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: d3.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit SimpleChangeSummaryScreen$lambda$3;
                    SimpleChangeSummaryScreen$lambda$3 = SimpleChangeSummaryScreenKt.SimpleChangeSummaryScreen$lambda$3(SimpleChangeSummaryViewModel.this, navigator, navController, navBackStackEntry, bottomSheetDismissHandler, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return SimpleChangeSummaryScreen$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SimpleChangeSummaryScreen$lambda$2$lambda$1(BottomSheetDismissHandler bottomSheetDismissHandler, DestinationsNavigator destinationsNavigator) {
        BottomSheetDismissHandler.dismissPopBlockingSheets$default(bottomSheetDismissHandler, destinationsNavigator, null, false, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SimpleChangeSummaryScreen$lambda$3(SimpleChangeSummaryViewModel simpleChangeSummaryViewModel, DestinationsNavigator destinationsNavigator, NavController navController, NavBackStackEntry navBackStackEntry, BottomSheetDismissHandler bottomSheetDismissHandler, int i5, Composer composer, int i6) {
        SimpleChangeSummaryScreen(simpleChangeSummaryViewModel, destinationsNavigator, navController, navBackStackEntry, bottomSheetDismissHandler, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
