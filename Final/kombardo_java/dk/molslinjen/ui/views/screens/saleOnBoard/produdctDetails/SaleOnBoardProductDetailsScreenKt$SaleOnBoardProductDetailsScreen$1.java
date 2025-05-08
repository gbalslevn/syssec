package dk.molslinjen.ui.views.screens.saleOnBoard.produdctDetails;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import dk.molslinjen.domain.managers.saleOnBoard.SaleOnBoardCheckoutManager;
import dk.molslinjen.ui.views.screens.saleOnBoard.produdctDetails.SaleOnBoardProductDetailsViewModel;
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
public final class SaleOnBoardProductDetailsScreenKt$SaleOnBoardProductDetailsScreen$1 implements Function3<ColumnScope, Composer, Integer, Unit> {
    final /* synthetic */ DestinationsNavigator $navigator;
    final /* synthetic */ SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState $saleOnBoardState;
    final /* synthetic */ SaleOnBoardProductDetailsViewModel.ViewState $state;
    final /* synthetic */ SaleOnBoardProductDetailsViewModel $viewModel;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SaleOnBoardProductDetailsScreenKt$SaleOnBoardProductDetailsScreen$1(SaleOnBoardProductDetailsViewModel saleOnBoardProductDetailsViewModel, DestinationsNavigator destinationsNavigator, SaleOnBoardProductDetailsViewModel.ViewState viewState, SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState saleOnBoardCheckoutState) {
        this.$viewModel = saleOnBoardProductDetailsViewModel;
        this.$navigator = destinationsNavigator;
        this.$state = viewState;
        this.$saleOnBoardState = saleOnBoardCheckoutState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$6$lambda$5(SaleOnBoardProductDetailsViewModel saleOnBoardProductDetailsViewModel, DestinationsNavigator destinationsNavigator, int i5) {
        saleOnBoardProductDetailsViewModel.onAddToBasket(i5, new SaleOnBoardProductDetailsScreenKt$SaleOnBoardProductDetailsScreen$1$5$1$1(destinationsNavigator));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$9$lambda$8(SaleOnBoardProductDetailsViewModel saleOnBoardProductDetailsViewModel, DestinationsNavigator destinationsNavigator) {
        saleOnBoardProductDetailsViewModel.removeFromBasket(new SaleOnBoardProductDetailsScreenKt$SaleOnBoardProductDetailsScreen$1$6$1$1(destinationsNavigator));
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
            ComposerKt.traceEventStart(65198352, i5, -1, "dk.molslinjen.ui.views.screens.saleOnBoard.produdctDetails.SaleOnBoardProductDetailsScreen.<anonymous> (SaleOnBoardProductDetailsScreen.kt:87)");
        }
        SaleOnBoardProductDetailsViewModel saleOnBoardProductDetailsViewModel = this.$viewModel;
        composer.startReplaceGroup(1479799263);
        boolean changedInstance = composer.changedInstance(saleOnBoardProductDetailsViewModel);
        Object rememberedValue = composer.rememberedValue();
        if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new SaleOnBoardProductDetailsScreenKt$SaleOnBoardProductDetailsScreen$1$1$1(saleOnBoardProductDetailsViewModel);
            composer.updateRememberedValue(rememberedValue);
        }
        KFunction kFunction = (KFunction) rememberedValue;
        composer.endReplaceGroup();
        SaleOnBoardProductDetailsViewModel saleOnBoardProductDetailsViewModel2 = this.$viewModel;
        composer.startReplaceGroup(1479809541);
        boolean changedInstance2 = composer.changedInstance(saleOnBoardProductDetailsViewModel2);
        Object rememberedValue2 = composer.rememberedValue();
        if (changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            rememberedValue2 = new SaleOnBoardProductDetailsScreenKt$SaleOnBoardProductDetailsScreen$1$2$1(saleOnBoardProductDetailsViewModel2);
            composer.updateRememberedValue(rememberedValue2);
        }
        KFunction kFunction2 = (KFunction) rememberedValue2;
        composer.endReplaceGroup();
        SaleOnBoardProductDetailsViewModel saleOnBoardProductDetailsViewModel3 = this.$viewModel;
        composer.startReplaceGroup(1479811424);
        boolean changedInstance3 = composer.changedInstance(saleOnBoardProductDetailsViewModel3);
        Object rememberedValue3 = composer.rememberedValue();
        if (changedInstance3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
            rememberedValue3 = new SaleOnBoardProductDetailsScreenKt$SaleOnBoardProductDetailsScreen$1$3$1(saleOnBoardProductDetailsViewModel3);
            composer.updateRememberedValue(rememberedValue3);
        }
        KFunction kFunction3 = (KFunction) rememberedValue3;
        composer.endReplaceGroup();
        DestinationsNavigator destinationsNavigator = this.$navigator;
        composer.startReplaceGroup(1479812959);
        boolean changed = composer.changed(destinationsNavigator);
        Object rememberedValue4 = composer.rememberedValue();
        if (changed || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
            rememberedValue4 = new SaleOnBoardProductDetailsScreenKt$SaleOnBoardProductDetailsScreen$1$4$1(destinationsNavigator);
            composer.updateRememberedValue(rememberedValue4);
        }
        Function0 function0 = (Function0) rememberedValue4;
        composer.endReplaceGroup();
        SaleOnBoardProductDetailsViewModel.ViewState viewState = this.$state;
        SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState saleOnBoardCheckoutState = this.$saleOnBoardState;
        Function2 function2 = (Function2) kFunction;
        Function1 function1 = (Function1) kFunction3;
        composer.startReplaceGroup(1479801041);
        boolean changedInstance4 = composer.changedInstance(this.$viewModel) | composer.changed(this.$navigator);
        final SaleOnBoardProductDetailsViewModel saleOnBoardProductDetailsViewModel4 = this.$viewModel;
        final DestinationsNavigator destinationsNavigator2 = this.$navigator;
        Object rememberedValue5 = composer.rememberedValue();
        if (changedInstance4 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
            rememberedValue5 = new Function1() { // from class: dk.molslinjen.ui.views.screens.saleOnBoard.produdctDetails.b
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit invoke$lambda$6$lambda$5;
                    invoke$lambda$6$lambda$5 = SaleOnBoardProductDetailsScreenKt$SaleOnBoardProductDetailsScreen$1.invoke$lambda$6$lambda$5(SaleOnBoardProductDetailsViewModel.this, destinationsNavigator2, ((Integer) obj).intValue());
                    return invoke$lambda$6$lambda$5;
                }
            };
            composer.updateRememberedValue(rememberedValue5);
        }
        Function1 function12 = (Function1) rememberedValue5;
        composer.endReplaceGroup();
        composer.startReplaceGroup(1479805509);
        boolean changedInstance5 = composer.changedInstance(this.$viewModel) | composer.changed(this.$navigator);
        final SaleOnBoardProductDetailsViewModel saleOnBoardProductDetailsViewModel5 = this.$viewModel;
        final DestinationsNavigator destinationsNavigator3 = this.$navigator;
        Object rememberedValue6 = composer.rememberedValue();
        if (changedInstance5 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
            rememberedValue6 = new Function0() { // from class: dk.molslinjen.ui.views.screens.saleOnBoard.produdctDetails.c
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$9$lambda$8;
                    invoke$lambda$9$lambda$8 = SaleOnBoardProductDetailsScreenKt$SaleOnBoardProductDetailsScreen$1.invoke$lambda$9$lambda$8(SaleOnBoardProductDetailsViewModel.this, destinationsNavigator3);
                    return invoke$lambda$9$lambda$8;
                }
            };
            composer.updateRememberedValue(rememberedValue6);
        }
        composer.endReplaceGroup();
        SaleOnBoardProductDetailsScreenKt.SaleOnBoardProductDetailsContent(viewState, saleOnBoardCheckoutState, function2, function1, function12, (Function0) rememberedValue6, (Function0) kFunction2, function0, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
