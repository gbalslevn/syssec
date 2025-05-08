package dk.molslinjen.ui.views.screens.booking.simpleChange.addons;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import com.adjust.sdk.Constants;
import dk.molslinjen.core.snackbar.SnackbarEvent;
import dk.molslinjen.core.snackbar.SnackbarText;
import dk.molslinjen.domain.managers.checkout.SimpleChangeCheckoutManager;
import dk.molslinjen.domain.model.booking.Booking;
import dk.molslinjen.domain.model.booking.product.Product;
import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.views.reusable.buttons.ButtonConfig;
import dk.molslinjen.ui.views.reusable.buttons.ButtonWithPriceKt;
import dk.molslinjen.ui.views.screens.booking.simpleChange.addons.SimpleChangeAddonsViewModel;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
final class SimpleChangeAddonsSharedContentKt$SimpleChangeAddonsSharedContent$1 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Booking $existingBooking;
    final /* synthetic */ Function0<Unit> $proceed;
    final /* synthetic */ List<Product> $selectedProducts;
    final /* synthetic */ SimpleChangeCheckoutManager.SimpleChangeCheckoutState $simpleChangeCheckoutState;
    final /* synthetic */ SimpleChangeAddonsViewModel.ViewState $state;
    final /* synthetic */ SimpleChangeAddonsViewModel $viewModel;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public SimpleChangeAddonsSharedContentKt$SimpleChangeAddonsSharedContent$1(Booking booking, List<? extends Product> list, SimpleChangeAddonsViewModel.ViewState viewState, SimpleChangeCheckoutManager.SimpleChangeCheckoutState simpleChangeCheckoutState, Function0<Unit> function0, SimpleChangeAddonsViewModel simpleChangeAddonsViewModel) {
        this.$existingBooking = booking;
        this.$selectedProducts = list;
        this.$state = viewState;
        this.$simpleChangeCheckoutState = simpleChangeCheckoutState;
        this.$proceed = function0;
        this.$viewModel = simpleChangeAddonsViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$3$lambda$2$lambda$1(SimpleChangeAddonsViewModel simpleChangeAddonsViewModel) {
        simpleChangeAddonsViewModel.showSnackbar(new SnackbarEvent.Information(new SnackbarText.ResourceText(R.string.addons_add_noneSelected), null, false, 6, null));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i5) {
        int i6;
        String stringResource;
        if ((i5 & 3) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1779980948, i5, -1, "dk.molslinjen.ui.views.screens.booking.simpleChange.addons.SimpleChangeAddonsSharedContent.<anonymous> (SimpleChangeAddonsSharedContent.kt:44)");
        }
        Modifier m104backgroundbw27NRU$default = BackgroundKt.m104backgroundbw27NRU$default(Modifier.INSTANCE, AppColor.INSTANCE.m3281getWhite0d7_KjU(), null, 2, null);
        Booking booking = this.$existingBooking;
        List<Product> list = this.$selectedProducts;
        SimpleChangeAddonsViewModel.ViewState viewState = this.$state;
        SimpleChangeCheckoutManager.SimpleChangeCheckoutState simpleChangeCheckoutState = this.$simpleChangeCheckoutState;
        Function0<Unit> function0 = this.$proceed;
        final SimpleChangeAddonsViewModel simpleChangeAddonsViewModel = this.$viewModel;
        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, m104backgroundbw27NRU$default);
        ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor = companion.getConstructor();
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
        Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion.getSetCompositeKeyHash();
        if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion.getSetModifier());
        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
        PriceWithCurrency price = booking.getOrderTotal().getPrice();
        if (list != null) {
            Iterator<T> it = list.iterator();
            i6 = 0;
            while (it.hasNext()) {
                i6 += ((Product) it.next()).sum().getValue();
            }
        } else {
            i6 = 0;
        }
        PriceWithCurrency copy$default = PriceWithCurrency.copy$default(price, i6, null, 2, null);
        Modifier m311padding3ABfNKs = PaddingKt.m311padding3ABfNKs(Modifier.INSTANCE, Dp.m2599constructorimpl(16));
        if (viewState.getPreselectedAddons() && list != null && list.isEmpty()) {
            composer.startReplaceGroup(-1874323681);
            stringResource = StringResources_androidKt.stringResource(R.string.button_saveChanges, composer, 6);
            composer.endReplaceGroup();
        } else if (Intrinsics.areEqual(simpleChangeCheckoutState.getEarlyCheckIn(), Boolean.TRUE)) {
            composer.startReplaceGroup(-1874319913);
            stringResource = StringResources_androidKt.stringResource(R.string.button_add, composer, 6);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(-1874317712);
            stringResource = StringResources_androidKt.stringResource(R.string.checkout_buttonBar_proceedToPayment, composer, 6);
            composer.endReplaceGroup();
        }
        String str = stringResource;
        boolean z5 = viewState.getPreselectedAddons() || (list != null && (list.isEmpty() ^ true));
        composer.startReplaceGroup(-1874308046);
        boolean changedInstance = composer.changedInstance(simpleChangeAddonsViewModel);
        Object rememberedValue = composer.rememberedValue();
        if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function0() { // from class: dk.molslinjen.ui.views.screens.booking.simpleChange.addons.a
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$3$lambda$2$lambda$1;
                    invoke$lambda$3$lambda$2$lambda$1 = SimpleChangeAddonsSharedContentKt$SimpleChangeAddonsSharedContent$1.invoke$lambda$3$lambda$2$lambda$1(SimpleChangeAddonsViewModel.this);
                    return invoke$lambda$3$lambda$2$lambda$1;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        ButtonWithPriceKt.ButtonWithPrice(m311padding3ABfNKs, function0, str, copy$default, (String) null, z5, (Function0<Unit>) rememberedValue, (ButtonConfig) null, false, composer, 6, Constants.MINIMAL_ERROR_STATUS_CODE);
        composer.endNode();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
