package dk.molslinjen.ui.views.screens.booking.departures.selectTransportationProducts;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.res.StringResources_androidKt;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import dk.molslinjen.domain.model.booking.product.Product;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.reusable.bottomsheet.BottomSheetButtonKt;
import dk.molslinjen.ui.views.screens.booking.departures.selectTransportationProducts.TransportProductSelectorViewModel;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TransportProductSelectorScreenKt$TransportProductSelectorScreen$2 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ DestinationsNavigator $navigator;
    final /* synthetic */ TransportProductSelectorViewModel.TransportProductsState $outboundState;
    final /* synthetic */ TransportProductSelectorViewModel.TransportProductsState $returnState;
    final /* synthetic */ TransportProductSelectorViewModel $viewModel;
    final /* synthetic */ TransportProductSelectorViewModel.ViewState $viewState;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TransportProductSelectorScreenKt$TransportProductSelectorScreen$2(TransportProductSelectorViewModel.ViewState viewState, TransportProductSelectorViewModel.TransportProductsState transportProductsState, TransportProductSelectorViewModel.TransportProductsState transportProductsState2, TransportProductSelectorViewModel transportProductSelectorViewModel, DestinationsNavigator destinationsNavigator) {
        this.$viewState = viewState;
        this.$outboundState = transportProductsState;
        this.$returnState = transportProductsState2;
        this.$viewModel = transportProductSelectorViewModel;
        this.$navigator = destinationsNavigator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$3$lambda$2(TransportProductSelectorViewModel transportProductSelectorViewModel, DestinationsNavigator destinationsNavigator) {
        transportProductSelectorViewModel.saveAndClose(new TransportProductSelectorScreenKt$TransportProductSelectorScreen$2$3$1$1(destinationsNavigator));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void invoke(Composer composer, int i5) {
        boolean z5;
        boolean changedInstance;
        Object rememberedValue;
        if ((i5 & 3) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2008071878, i5, -1, "dk.molslinjen.ui.views.screens.booking.departures.selectTransportationProducts.TransportProductSelectorScreen.<anonymous> (TransportProductSelectorScreen.kt:57)");
        }
        String stringResource = StringResources_androidKt.stringResource(R.string.transportProducts_addButtonText, composer, 6);
        if (!this.$viewState.getIsEditing()) {
            List<Product> products = this.$outboundState.getProducts();
            if (!(products instanceof Collection) || !products.isEmpty()) {
                Iterator<T> it = products.iterator();
                while (it.hasNext()) {
                    if (((Product) it.next()).getQuantity() > 0) {
                        break;
                    }
                }
            }
            List<Product> products2 = this.$returnState.getProducts();
            if (!(products2 instanceof Collection) || !products2.isEmpty()) {
                Iterator<T> it2 = products2.iterator();
                while (it2.hasNext()) {
                    if (((Product) it2.next()).getQuantity() > 0) {
                    }
                }
            }
            z5 = false;
            boolean z6 = z5;
            composer.startReplaceGroup(195956852);
            changedInstance = composer.changedInstance(this.$viewModel) | composer.changed(this.$navigator);
            final TransportProductSelectorViewModel transportProductSelectorViewModel = this.$viewModel;
            final DestinationsNavigator destinationsNavigator = this.$navigator;
            rememberedValue = composer.rememberedValue();
            if (!changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: dk.molslinjen.ui.views.screens.booking.departures.selectTransportationProducts.a
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit invoke$lambda$3$lambda$2;
                        invoke$lambda$3$lambda$2 = TransportProductSelectorScreenKt$TransportProductSelectorScreen$2.invoke$lambda$3$lambda$2(TransportProductSelectorViewModel.this, destinationsNavigator);
                        return invoke$lambda$3$lambda$2;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceGroup();
            BottomSheetButtonKt.m3397BottomSheetButton1YH7lEI(stringResource, null, z6, false, false, 0L, null, (Function0) rememberedValue, composer, 0, 122);
            if (ComposerKt.isTraceInProgress()) {
                return;
            }
            ComposerKt.traceEventEnd();
            return;
        }
        z5 = true;
        boolean z62 = z5;
        composer.startReplaceGroup(195956852);
        changedInstance = composer.changedInstance(this.$viewModel) | composer.changed(this.$navigator);
        final TransportProductSelectorViewModel transportProductSelectorViewModel2 = this.$viewModel;
        final DestinationsNavigator destinationsNavigator2 = this.$navigator;
        rememberedValue = composer.rememberedValue();
        if (!changedInstance) {
        }
        rememberedValue = new Function0() { // from class: dk.molslinjen.ui.views.screens.booking.departures.selectTransportationProducts.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit invoke$lambda$3$lambda$2;
                invoke$lambda$3$lambda$2 = TransportProductSelectorScreenKt$TransportProductSelectorScreen$2.invoke$lambda$3$lambda$2(TransportProductSelectorViewModel.this, destinationsNavigator2);
                return invoke$lambda$3$lambda$2;
            }
        };
        composer.updateRememberedValue(rememberedValue);
        composer.endReplaceGroup();
        BottomSheetButtonKt.m3397BottomSheetButton1YH7lEI(stringResource, null, z62, false, false, 0L, null, (Function0) rememberedValue, composer, 0, 122);
        if (ComposerKt.isTraceInProgress()) {
        }
    }
}
