package dk.molslinjen.ui.views.screens.agreements.commuter.oeresund.details;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import com.ramcosta.composedestinations.generated.destinations.BarcodeDetailsScreenDestination;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import dk.molslinjen.domain.model.agreement.commuter.oeresund.OeresundCommuterAgreement;
import dk.molslinjen.ui.views.reusable.barcode.BarcodeViewType;
import dk.molslinjen.ui.views.screens.tickets.barcodeDetails.BarcodeValidity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class OeresundCommuterDetailsScreenKt$OeresundCommuterDetailsScreen$1$1 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ OeresundCommuterAgreement $agreement;
    final /* synthetic */ DestinationsNavigator $navigator;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OeresundCommuterDetailsScreenKt$OeresundCommuterDetailsScreen$1$1(OeresundCommuterAgreement oeresundCommuterAgreement, DestinationsNavigator destinationsNavigator) {
        this.$agreement = oeresundCommuterAgreement;
        this.$navigator = destinationsNavigator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$2$lambda$1$lambda$0(DestinationsNavigator destinationsNavigator, String barcode, String str, BarcodeViewType barcodeType, BarcodeValidity validity) {
        Intrinsics.checkNotNullParameter(barcode, "barcode");
        Intrinsics.checkNotNullParameter(barcodeType, "barcodeType");
        Intrinsics.checkNotNullParameter(validity, "validity");
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, BarcodeDetailsScreenDestination.INSTANCE.invoke(barcode, str, barcodeType, validity), null, null, 6, null);
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
            ComposerKt.traceEventStart(-917209948, i5, -1, "dk.molslinjen.ui.views.screens.agreements.commuter.oeresund.details.OeresundCommuterDetailsScreen.<anonymous>.<anonymous> (OeresundCommuterDetailsScreen.kt:59)");
        }
        OeresundCommuterAgreement oeresundCommuterAgreement = this.$agreement;
        if (oeresundCommuterAgreement != null) {
            final DestinationsNavigator destinationsNavigator = this.$navigator;
            composer.startReplaceGroup(885094112);
            boolean changed = composer.changed(destinationsNavigator);
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function4() { // from class: dk.molslinjen.ui.views.screens.agreements.commuter.oeresund.details.a
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        Unit invoke$lambda$2$lambda$1$lambda$0;
                        invoke$lambda$2$lambda$1$lambda$0 = OeresundCommuterDetailsScreenKt$OeresundCommuterDetailsScreen$1$1.invoke$lambda$2$lambda$1$lambda$0(DestinationsNavigator.this, (String) obj, (String) obj2, (BarcodeViewType) obj3, (BarcodeValidity) obj4);
                        return invoke$lambda$2$lambda$1$lambda$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceGroup();
            OeresundCommuterDetailsScreenKt.Content(oeresundCommuterAgreement, (Function4) rememberedValue, composer, 0);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
