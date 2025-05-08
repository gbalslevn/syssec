package dk.molslinjen.ui.views.screens.agreements.multiride.purchase;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import com.ramcosta.composedestinations.generated.destinations.PaymentBottomSheetScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.PhoneNumberCodeSelectionScreenDestination;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import dk.molslinjen.domain.managers.agreement.multiride.purchase.IMultiRideCardCheckoutManager;
import dk.molslinjen.domain.model.payment.PaymentOrigin;
import dk.molslinjen.ui.views.reusable.input.validation.FormValidator;
import dk.molslinjen.ui.views.screens.agreements.multiride.purchase.MultiRidePurchaseSummaryViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MultiRideCardPurchaseSummaryScreenKt$MultiRideCardPurchaseSummaryScreen$4 implements Function3<ColumnScope, Composer, Integer, Unit> {
    final /* synthetic */ IMultiRideCardCheckoutManager.CheckoutState $checkoutState;
    final /* synthetic */ DestinationsNavigator $navigator;
    final /* synthetic */ LazyListState $scrollState;
    final /* synthetic */ FormValidator $validator;
    final /* synthetic */ MultiRidePurchaseSummaryViewModel $viewModel;
    final /* synthetic */ MultiRidePurchaseSummaryViewModel.ViewState $viewState;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MultiRideCardPurchaseSummaryScreenKt$MultiRideCardPurchaseSummaryScreen$4(MultiRidePurchaseSummaryViewModel multiRidePurchaseSummaryViewModel, MultiRidePurchaseSummaryViewModel.ViewState viewState, IMultiRideCardCheckoutManager.CheckoutState checkoutState, LazyListState lazyListState, FormValidator formValidator, DestinationsNavigator destinationsNavigator) {
        this.$viewModel = multiRidePurchaseSummaryViewModel;
        this.$viewState = viewState;
        this.$checkoutState = checkoutState;
        this.$scrollState = lazyListState;
        this.$validator = formValidator;
        this.$navigator = destinationsNavigator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$10$lambda$9(DestinationsNavigator destinationsNavigator) {
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, PhoneNumberCodeSelectionScreenDestination.INSTANCE, null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$8$lambda$7(MultiRidePurchaseSummaryViewModel multiRidePurchaseSummaryViewModel, final DestinationsNavigator destinationsNavigator) {
        multiRidePurchaseSummaryViewModel.initiatePayment(new Function1() { // from class: dk.molslinjen.ui.views.screens.agreements.multiride.purchase.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit invoke$lambda$8$lambda$7$lambda$6;
                invoke$lambda$8$lambda$7$lambda$6 = MultiRideCardPurchaseSummaryScreenKt$MultiRideCardPurchaseSummaryScreen$4.invoke$lambda$8$lambda$7$lambda$6(DestinationsNavigator.this, (PaymentOrigin) obj);
                return invoke$lambda$8$lambda$7$lambda$6;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$8$lambda$7$lambda$6(DestinationsNavigator destinationsNavigator, PaymentOrigin origin) {
        Intrinsics.checkNotNullParameter(origin, "origin");
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, PaymentBottomSheetScreenDestination.INSTANCE.invoke(origin), null, null, 6, null);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
        invoke(columnScope, composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(ColumnScope BottomSheetContainer, Composer composer, int i5) {
        Intrinsics.checkNotNullParameter(BottomSheetContainer, "$this$BottomSheetContainer");
        if ((i5 & 17) == 16 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1512997925, i5, -1, "dk.molslinjen.ui.views.screens.agreements.multiride.purchase.MultiRideCardPurchaseSummaryScreen.<anonymous> (MultiRideCardPurchaseSummaryScreen.kt:95)");
        }
        MultiRidePurchaseSummaryViewModel multiRidePurchaseSummaryViewModel = this.$viewModel;
        composer.startReplaceGroup(1888561885);
        boolean changedInstance = composer.changedInstance(multiRidePurchaseSummaryViewModel);
        Object rememberedValue = composer.rememberedValue();
        if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new MultiRideCardPurchaseSummaryScreenKt$MultiRideCardPurchaseSummaryScreen$4$1$1(multiRidePurchaseSummaryViewModel);
            composer.updateRememberedValue(rememberedValue);
        }
        KFunction kFunction = (KFunction) rememberedValue;
        composer.endReplaceGroup();
        MultiRidePurchaseSummaryViewModel multiRidePurchaseSummaryViewModel2 = this.$viewModel;
        composer.startReplaceGroup(1888563799);
        boolean changedInstance2 = composer.changedInstance(multiRidePurchaseSummaryViewModel2);
        Object rememberedValue2 = composer.rememberedValue();
        if (changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            rememberedValue2 = new MultiRideCardPurchaseSummaryScreenKt$MultiRideCardPurchaseSummaryScreen$4$2$1(multiRidePurchaseSummaryViewModel2);
            composer.updateRememberedValue(rememberedValue2);
        }
        KFunction kFunction2 = (KFunction) rememberedValue2;
        composer.endReplaceGroup();
        MultiRidePurchaseSummaryViewModel multiRidePurchaseSummaryViewModel3 = this.$viewModel;
        composer.startReplaceGroup(1888565692);
        boolean changedInstance3 = composer.changedInstance(multiRidePurchaseSummaryViewModel3);
        Object rememberedValue3 = composer.rememberedValue();
        if (changedInstance3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
            rememberedValue3 = new MultiRideCardPurchaseSummaryScreenKt$MultiRideCardPurchaseSummaryScreen$4$3$1(multiRidePurchaseSummaryViewModel3);
            composer.updateRememberedValue(rememberedValue3);
        }
        KFunction kFunction3 = (KFunction) rememberedValue3;
        composer.endReplaceGroup();
        MultiRidePurchaseSummaryViewModel multiRidePurchaseSummaryViewModel4 = this.$viewModel;
        composer.startReplaceGroup(1888567839);
        boolean changedInstance4 = composer.changedInstance(multiRidePurchaseSummaryViewModel4);
        Object rememberedValue4 = composer.rememberedValue();
        if (changedInstance4 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
            rememberedValue4 = new MultiRideCardPurchaseSummaryScreenKt$MultiRideCardPurchaseSummaryScreen$4$4$1(multiRidePurchaseSummaryViewModel4);
            composer.updateRememberedValue(rememberedValue4);
        }
        KFunction kFunction4 = (KFunction) rememberedValue4;
        composer.endReplaceGroup();
        MultiRidePurchaseSummaryViewModel multiRidePurchaseSummaryViewModel5 = this.$viewModel;
        composer.startReplaceGroup(1888570145);
        boolean changedInstance5 = composer.changedInstance(multiRidePurchaseSummaryViewModel5);
        Object rememberedValue5 = composer.rememberedValue();
        if (changedInstance5 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
            rememberedValue5 = new MultiRideCardPurchaseSummaryScreenKt$MultiRideCardPurchaseSummaryScreen$4$5$1(multiRidePurchaseSummaryViewModel5);
            composer.updateRememberedValue(rememberedValue5);
        }
        KFunction kFunction5 = (KFunction) rememberedValue5;
        composer.endReplaceGroup();
        MultiRidePurchaseSummaryViewModel multiRidePurchaseSummaryViewModel6 = this.$viewModel;
        composer.startReplaceGroup(1888572414);
        boolean changedInstance6 = composer.changedInstance(multiRidePurchaseSummaryViewModel6);
        Object rememberedValue6 = composer.rememberedValue();
        if (changedInstance6 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
            rememberedValue6 = new MultiRideCardPurchaseSummaryScreenKt$MultiRideCardPurchaseSummaryScreen$4$6$1(multiRidePurchaseSummaryViewModel6);
            composer.updateRememberedValue(rememberedValue6);
        }
        composer.endReplaceGroup();
        MultiRidePurchaseSummaryViewModel.ViewState viewState = this.$viewState;
        IMultiRideCardCheckoutManager.CheckoutState checkoutState = this.$checkoutState;
        LazyListState lazyListState = this.$scrollState;
        FormValidator formValidator = this.$validator;
        Function1 function1 = (Function1) kFunction;
        Function1 function12 = (Function1) kFunction2;
        Function1 function13 = (Function1) kFunction3;
        Function0 function0 = (Function0) kFunction4;
        Function2 function2 = (Function2) kFunction5;
        Function1 function14 = (Function1) ((KFunction) rememberedValue6);
        composer.startReplaceGroup(1888578716);
        boolean changedInstance7 = composer.changedInstance(this.$viewModel) | composer.changed(this.$navigator);
        final MultiRidePurchaseSummaryViewModel multiRidePurchaseSummaryViewModel7 = this.$viewModel;
        final DestinationsNavigator destinationsNavigator = this.$navigator;
        Object rememberedValue7 = composer.rememberedValue();
        if (changedInstance7 || rememberedValue7 == Composer.INSTANCE.getEmpty()) {
            rememberedValue7 = new Function0() { // from class: dk.molslinjen.ui.views.screens.agreements.multiride.purchase.a
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$8$lambda$7;
                    invoke$lambda$8$lambda$7 = MultiRideCardPurchaseSummaryScreenKt$MultiRideCardPurchaseSummaryScreen$4.invoke$lambda$8$lambda$7(MultiRidePurchaseSummaryViewModel.this, destinationsNavigator);
                    return invoke$lambda$8$lambda$7;
                }
            };
            composer.updateRememberedValue(rememberedValue7);
        }
        Function0 function02 = (Function0) rememberedValue7;
        composer.endReplaceGroup();
        composer.startReplaceGroup(1888574876);
        boolean changed = composer.changed(this.$navigator);
        final DestinationsNavigator destinationsNavigator2 = this.$navigator;
        Object rememberedValue8 = composer.rememberedValue();
        if (changed || rememberedValue8 == Composer.INSTANCE.getEmpty()) {
            rememberedValue8 = new Function0() { // from class: dk.molslinjen.ui.views.screens.agreements.multiride.purchase.b
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$10$lambda$9;
                    invoke$lambda$10$lambda$9 = MultiRideCardPurchaseSummaryScreenKt$MultiRideCardPurchaseSummaryScreen$4.invoke$lambda$10$lambda$9(DestinationsNavigator.this);
                    return invoke$lambda$10$lambda$9;
                }
            };
            composer.updateRememberedValue(rememberedValue8);
        }
        composer.endReplaceGroup();
        MultiRideCardPurchaseSummaryScreenKt.Content(viewState, checkoutState, lazyListState, formValidator, function1, function12, function13, function0, function2, function14, function02, (Function0) rememberedValue8, composer, 0, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
