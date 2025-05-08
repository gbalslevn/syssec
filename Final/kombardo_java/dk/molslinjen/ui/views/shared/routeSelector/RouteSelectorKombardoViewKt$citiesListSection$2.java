package dk.molslinjen.ui.views.shared.routeSelector;

import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.views.reusable.HorizontalDividerKt;
import dk.molslinjen.ui.views.shared.routeSelector.RouteSelectorKombardoViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RouteSelectorKombardoViewKt$citiesListSection$2 implements Function4<LazyItemScope, Integer, Composer, Integer, Unit> {
    final /* synthetic */ RouteSelectorKombardoViewModel.ViewState.CityRow $city;
    final /* synthetic */ List<RouteSelectorKombardoViewModel.ViewState.CityRow> $cityRows;
    final /* synthetic */ int $index;
    final /* synthetic */ Function1<RouteSelectorKombardoViewModel.ViewState.CityRow, Unit> $onSelectedCity;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public RouteSelectorKombardoViewKt$citiesListSection$2(RouteSelectorKombardoViewModel.ViewState.CityRow cityRow, Function1<? super RouteSelectorKombardoViewModel.ViewState.CityRow, Unit> function1, int i5, List<RouteSelectorKombardoViewModel.ViewState.CityRow> list) {
        this.$city = cityRow;
        this.$onSelectedCity = function1;
        this.$index = i5;
        this.$cityRows = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(Function1 function1, RouteSelectorKombardoViewModel.ViewState.CityRow cityRow) {
        function1.invoke(cityRow);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
        invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(LazyItemScope itemIndexed, int i5, Composer composer, int i6) {
        Intrinsics.checkNotNullParameter(itemIndexed, "$this$itemIndexed");
        if ((i6 & 129) == 128 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-640292110, i6, -1, "dk.molslinjen.ui.views.shared.routeSelector.citiesListSection.<anonymous> (RouteSelectorKombardoView.kt:226)");
        }
        String name = this.$city.getName();
        composer.startReplaceGroup(-750160792);
        boolean changed = composer.changed(this.$onSelectedCity) | composer.changedInstance(this.$city);
        final Function1<RouteSelectorKombardoViewModel.ViewState.CityRow, Unit> function1 = this.$onSelectedCity;
        final RouteSelectorKombardoViewModel.ViewState.CityRow cityRow = this.$city;
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function0() { // from class: dk.molslinjen.ui.views.shared.routeSelector.b
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$1$lambda$0;
                    invoke$lambda$1$lambda$0 = RouteSelectorKombardoViewKt$citiesListSection$2.invoke$lambda$1$lambda$0(Function1.this, cityRow);
                    return invoke$lambda$1$lambda$0;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        RouteSelectorKombardoViewKt.CityRow(name, (Function0) rememberedValue, composer, 0);
        if (this.$index != this.$cityRows.size() - 1) {
            HorizontalDividerKt.m3388HorizontalDividertZIQpXc(null, AppColor.INSTANCE.m3268getGrey50d7_KjU(), 0.0f, null, composer, 48, 13);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
