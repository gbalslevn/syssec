package dk.molslinjen.ui.views.screens.agreements.multiride.refill;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.res.StringResources_androidKt;
import com.ramcosta.composedestinations.generated.destinations.MultiRideCardPurchaseSummaryScreenDestination;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import dk.molslinjen.domain.managers.agreement.multiride.purchase.IMultiRideCardCheckoutManager;
import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.reusable.bottomsheet.BottomSheetButtonKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MultiRideRefillScreenKt$MultiRideRefillScreen$2 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ IMultiRideCardCheckoutManager.CheckoutState $checkoutState;
    final /* synthetic */ boolean $isButtonEnabled;
    final /* synthetic */ DestinationsNavigator $navigator;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MultiRideRefillScreenKt$MultiRideRefillScreen$2(IMultiRideCardCheckoutManager.CheckoutState checkoutState, boolean z5, DestinationsNavigator destinationsNavigator) {
        this.$checkoutState = checkoutState;
        this.$isButtonEnabled = z5;
        this.$navigator = destinationsNavigator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(DestinationsNavigator destinationsNavigator) {
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, MultiRideCardPurchaseSummaryScreenDestination.INSTANCE, null, null, 6, null);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i5) {
        if ((i5 & 3) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2069865632, i5, -1, "dk.molslinjen.ui.views.screens.agreements.multiride.refill.MultiRideRefillScreen.<anonymous> (MultiRideRefillScreen.kt:72)");
        }
        String stringResource = StringResources_androidKt.stringResource(R.string.button_continue, composer, 6);
        PriceWithCurrency totalPrice = this.$checkoutState.getTotalPrice();
        boolean z5 = this.$isButtonEnabled;
        composer.startReplaceGroup(1711626268);
        boolean changed = composer.changed(this.$navigator);
        final DestinationsNavigator destinationsNavigator = this.$navigator;
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function0() { // from class: dk.molslinjen.ui.views.screens.agreements.multiride.refill.a
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$1$lambda$0;
                    invoke$lambda$1$lambda$0 = MultiRideRefillScreenKt$MultiRideRefillScreen$2.invoke$lambda$1$lambda$0(DestinationsNavigator.this);
                    return invoke$lambda$1$lambda$0;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        BottomSheetButtonKt.m3397BottomSheetButton1YH7lEI(stringResource, totalPrice, z5, false, false, 0L, null, (Function0) rememberedValue, composer, 0, 120);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
