package dk.molslinjen.ui.views.screens.profile.currencies;

import android.content.Context;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import dk.molslinjen.domain.model.shared.CurrencyType;
import dk.molslinjen.ui.views.screens.profile.currencies.CurrenciesViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CurrenciesScreenKt$CurrenciesScreen$3 implements Function3<ColumnScope, Composer, Integer, Unit> {
    final /* synthetic */ Context $context;
    final /* synthetic */ CurrencyType $selectedCurrencyState;
    final /* synthetic */ CurrenciesViewModel $viewModel;
    final /* synthetic */ CurrenciesViewModel.ViewState $viewState;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CurrenciesScreenKt$CurrenciesScreen$3(CurrenciesViewModel.ViewState viewState, CurrencyType currencyType, CurrenciesViewModel currenciesViewModel, Context context) {
        this.$viewState = viewState;
        this.$selectedCurrencyState = currencyType;
        this.$viewModel = currenciesViewModel;
        this.$context = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(CurrenciesViewModel currenciesViewModel, Context context, CurrencyType it) {
        Intrinsics.checkNotNullParameter(it, "it");
        currenciesViewModel.selectCurrency(it, context);
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
            ComposerKt.traceEventStart(-23824051, i5, -1, "dk.molslinjen.ui.views.screens.profile.currencies.CurrenciesScreen.<anonymous> (CurrenciesScreen.kt:48)");
        }
        List<CurrencyType> currencies = this.$viewState.getCurrencies();
        CurrencyType currencyType = this.$selectedCurrencyState;
        composer.startReplaceGroup(-344999379);
        boolean changedInstance = composer.changedInstance(this.$viewModel) | composer.changedInstance(this.$context);
        final CurrenciesViewModel currenciesViewModel = this.$viewModel;
        final Context context = this.$context;
        Object rememberedValue = composer.rememberedValue();
        if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function1() { // from class: dk.molslinjen.ui.views.screens.profile.currencies.a
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit invoke$lambda$1$lambda$0;
                    invoke$lambda$1$lambda$0 = CurrenciesScreenKt$CurrenciesScreen$3.invoke$lambda$1$lambda$0(CurrenciesViewModel.this, context, (CurrencyType) obj);
                    return invoke$lambda$1$lambda$0;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        CurrenciesScreenKt.CurrenciesContent(currencies, currencyType, (Function1) rememberedValue, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
