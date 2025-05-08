package dk.molslinjen.ui.views.screens.booking.simpleChange;

import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.res.StringResources_androidKt;
import dk.molslinjen.domain.managers.checkout.PriceTotal;
import dk.molslinjen.domain.managers.checkout.SimpleChangeCheckoutManager;
import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import dk.molslinjen.domain.model.site.SiteInfo;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.reusable.input.validation.IFormValidator;
import dk.molslinjen.ui.views.screens.booking.simpleChange.SimpleChangeSummaryViewModel;
import dk.molslinjen.ui.views.screens.booking.summary.ConfirmSectionViewKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SimpleChangeSummaryScreenKt$ChangeProductSummaryContent$1$1$3 implements Function3<LazyItemScope, Composer, Integer, Unit> {
    final /* synthetic */ Function0<Unit> $proceed;
    final /* synthetic */ SimpleChangeCheckoutManager.SimpleChangeCheckoutState $simpleChangeCheckoutState;
    final /* synthetic */ SimpleChangeSummaryViewModel.ViewState $state;
    final /* synthetic */ MutableState<Boolean> $termsAccepted;
    final /* synthetic */ PriceWithCurrency $totalPrice;
    final /* synthetic */ IFormValidator $validator;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SimpleChangeSummaryScreenKt$ChangeProductSummaryContent$1$1$3(MutableState<Boolean> mutableState, SimpleChangeSummaryViewModel.ViewState viewState, SimpleChangeCheckoutManager.SimpleChangeCheckoutState simpleChangeCheckoutState, PriceWithCurrency priceWithCurrency, IFormValidator iFormValidator, Function0<Unit> function0) {
        this.$termsAccepted = mutableState;
        this.$state = viewState;
        this.$simpleChangeCheckoutState = simpleChangeCheckoutState;
        this.$totalPrice = priceWithCurrency;
        this.$validator = iFormValidator;
        this.$proceed = function0;
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
            ComposerKt.traceEventStart(-1404120534, i5, -1, "dk.molslinjen.ui.views.screens.booking.simpleChange.ChangeProductSummaryContent.<anonymous>.<anonymous>.<anonymous> (SimpleChangeSummaryScreen.kt:146)");
        }
        boolean booleanValue = this.$termsAccepted.getValue().booleanValue();
        SiteInfo siteInfo = this.$state.getSiteInfo();
        composer.startReplaceGroup(1938988910);
        String stringResource = Intrinsics.areEqual(this.$simpleChangeCheckoutState.getEarlyCheckIn(), Boolean.TRUE) ? StringResources_androidKt.stringResource(R.string.earlyCheckIn_payAndCheckIn, composer, 6) : null;
        composer.endReplaceGroup();
        PriceTotal priceTotal = new PriceTotal(this.$totalPrice);
        composer.startReplaceGroup(1938998720);
        boolean z5 = this.$termsAccepted.getValue().booleanValue() && ((Boolean) SnapshotStateKt.collectAsState(this.$validator.isFormValid(), null, composer, 0, 1).getValue()).booleanValue();
        composer.endReplaceGroup();
        composer.startReplaceGroup(1938993721);
        boolean changed = composer.changed(this.$termsAccepted);
        final MutableState<Boolean> mutableState = this.$termsAccepted;
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function1() { // from class: dk.molslinjen.ui.views.screens.booking.simpleChange.a
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit invoke$lambda$1$lambda$0;
                    invoke$lambda$1$lambda$0 = SimpleChangeSummaryScreenKt$ChangeProductSummaryContent$1$1$3.invoke$lambda$1$lambda$0(MutableState.this, ((Boolean) obj).booleanValue());
                    return invoke$lambda$1$lambda$0;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        ConfirmSectionViewKt.TermsAndButtonSection(booleanValue, siteInfo, (Function1) rememberedValue, this.$validator, priceTotal, z5, stringResource, this.$proceed, composer, 0, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
