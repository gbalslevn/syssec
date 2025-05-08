package dk.molslinjen.ui.views.screens.booking.summary;

import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import dk.molslinjen.domain.managers.checkout.CheckoutManager;
import dk.molslinjen.domain.managers.checkout.PriceTotal;
import dk.molslinjen.domain.model.account.UserVehicle;
import dk.molslinjen.domain.model.booking.Departure;
import dk.molslinjen.domain.model.config.Transportation;
import dk.molslinjen.domain.model.site.SiteInfo;
import dk.molslinjen.ui.views.reusable.input.validation.IFormValidator;
import dk.molslinjen.ui.views.screens.booking.summary.BookingSummaryViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class BookingSummaryScreenKt$BookingSummaryContent$1$1$5 implements Function3<LazyItemScope, Composer, Integer, Unit> {
    final /* synthetic */ CheckoutManager.CheckoutState $checkoutState;
    final /* synthetic */ Function1<Boolean, Unit> $onEarlyCheckInChange;
    final /* synthetic */ CheckoutManager.CheckoutDirectionState $outboundCheckoutState;
    final /* synthetic */ Function0<Unit> $proceed;
    final /* synthetic */ CheckoutManager.CheckoutDirectionState $returnCheckoutState;
    final /* synthetic */ BookingSummaryViewModel.ViewState $state;
    final /* synthetic */ MutableState<Boolean> $termsAccepted;
    final /* synthetic */ Function0<Unit> $toggleAcceptMarketing;
    final /* synthetic */ Function0<Unit> $toggleNewsletterSignup;
    final /* synthetic */ IFormValidator $validator;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public BookingSummaryScreenKt$BookingSummaryContent$1$1$5(IFormValidator iFormValidator, BookingSummaryViewModel.ViewState viewState, MutableState<Boolean> mutableState, CheckoutManager.CheckoutState checkoutState, CheckoutManager.CheckoutDirectionState checkoutDirectionState, CheckoutManager.CheckoutDirectionState checkoutDirectionState2, Function0<Unit> function0, Function0<Unit> function02, Function1<? super Boolean, Unit> function1, Function0<Unit> function03) {
        this.$validator = iFormValidator;
        this.$state = viewState;
        this.$termsAccepted = mutableState;
        this.$checkoutState = checkoutState;
        this.$outboundCheckoutState = checkoutDirectionState;
        this.$returnCheckoutState = checkoutDirectionState2;
        this.$toggleNewsletterSignup = function0;
        this.$toggleAcceptMarketing = function02;
        this.$onEarlyCheckInChange = function1;
        this.$proceed = function03;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(MutableState mutableState, boolean z5) {
        mutableState.setValue(Boolean.valueOf(z5));
        return Unit.INSTANCE;
    }

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
            ComposerKt.traceEventStart(53765858, i5, -1, "dk.molslinjen.ui.views.screens.booking.summary.BookingSummaryContent.<anonymous>.<anonymous>.<anonymous> (BookingSummaryScreen.kt:291)");
        }
        IFormValidator iFormValidator = this.$validator;
        SiteInfo siteInfo = this.$state.getSiteInfo();
        composer.startReplaceGroup(1898867146);
        boolean z5 = this.$termsAccepted.getValue().booleanValue() && ((Boolean) SnapshotStateKt.collectAsState(this.$validator.isFormValid(), null, composer, 0, 1).getValue()).booleanValue();
        composer.endReplaceGroup();
        PriceTotal totalPrice = this.$checkoutState.getPriceDetails().getTotalPrice();
        boolean signedUpForNewsletter = this.$checkoutState.getSignedUpForNewsletter();
        boolean acceptedMarketing = this.$checkoutState.getAcceptedMarketing();
        boolean booleanValue = this.$termsAccepted.getValue().booleanValue();
        boolean isEarlyCheckInPossible = this.$checkoutState.getIsEarlyCheckInPossible();
        boolean makeEarlyCheckIn = this.$checkoutState.getMakeEarlyCheckIn();
        Transportation transportation = this.$checkoutState.getTransportation();
        UserVehicle selectedVehicle = this.$checkoutState.getSelectedVehicle();
        Departure departure = this.$outboundCheckoutState.getDeparture();
        CheckoutManager.CheckoutDirectionState checkoutDirectionState = this.$returnCheckoutState;
        Departure departure2 = checkoutDirectionState != null ? checkoutDirectionState.getDeparture() : null;
        Function0<Unit> function0 = this.$toggleNewsletterSignup;
        Function0<Unit> function02 = this.$toggleAcceptMarketing;
        composer.startReplaceGroup(1898896323);
        boolean changed = composer.changed(this.$termsAccepted);
        final MutableState<Boolean> mutableState = this.$termsAccepted;
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function1() { // from class: dk.molslinjen.ui.views.screens.booking.summary.a
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit invoke$lambda$1$lambda$0;
                    invoke$lambda$1$lambda$0 = BookingSummaryScreenKt$BookingSummaryContent$1$1$5.invoke$lambda$1$lambda$0(MutableState.this, ((Boolean) obj).booleanValue());
                    return invoke$lambda$1$lambda$0;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        ConfirmSectionViewKt.ConfirmSection(iFormValidator, siteInfo, z5, totalPrice, signedUpForNewsletter, acceptedMarketing, booleanValue, isEarlyCheckInPossible, makeEarlyCheckIn, transportation, selectedVehicle, departure, departure2, function0, function02, (Function1) rememberedValue, this.$onEarlyCheckInChange, this.$proceed, composer, 0, 0, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
