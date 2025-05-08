package dk.molslinjen.ui.views.screens.agreements.commuter.bornholm.add;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import dk.molslinjen.ui.views.screens.agreements.commuter.bornholm.add.BornholmCommuterAddViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class BornholmCommuterAddScreenKt$BornholmCommuterAddScreen$3 implements Function3<ColumnScope, Composer, Integer, Unit> {
    final /* synthetic */ DestinationsNavigator $navigator;
    final /* synthetic */ BornholmCommuterAddViewModel $viewModel;
    final /* synthetic */ BornholmCommuterAddViewModel.ViewState $viewState;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BornholmCommuterAddScreenKt$BornholmCommuterAddScreen$3(BornholmCommuterAddViewModel.ViewState viewState, BornholmCommuterAddViewModel bornholmCommuterAddViewModel, DestinationsNavigator destinationsNavigator) {
        this.$viewState = viewState;
        this.$viewModel = bornholmCommuterAddViewModel;
        this.$navigator = destinationsNavigator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$3$lambda$2(BornholmCommuterAddViewModel bornholmCommuterAddViewModel, DestinationsNavigator destinationsNavigator) {
        bornholmCommuterAddViewModel.addCommuterCard(new BornholmCommuterAddScreenKt$BornholmCommuterAddScreen$3$3$1$1(destinationsNavigator));
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
            ComposerKt.traceEventStart(-164237960, i5, -1, "dk.molslinjen.ui.views.screens.agreements.commuter.bornholm.add.BornholmCommuterAddScreen.<anonymous> (BornholmCommuterAddScreen.kt:83)");
        }
        BornholmCommuterAddViewModel.ViewState viewState = this.$viewState;
        BornholmCommuterAddViewModel bornholmCommuterAddViewModel = this.$viewModel;
        composer.startReplaceGroup(1875193224);
        boolean changedInstance = composer.changedInstance(bornholmCommuterAddViewModel);
        Object rememberedValue = composer.rememberedValue();
        if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new BornholmCommuterAddScreenKt$BornholmCommuterAddScreen$3$1$1(bornholmCommuterAddViewModel);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        Function1 function1 = (Function1) ((KFunction) rememberedValue);
        BornholmCommuterAddViewModel bornholmCommuterAddViewModel2 = this.$viewModel;
        composer.startReplaceGroup(1875195115);
        boolean changedInstance2 = composer.changedInstance(bornholmCommuterAddViewModel2);
        Object rememberedValue2 = composer.rememberedValue();
        if (changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            rememberedValue2 = new BornholmCommuterAddScreenKt$BornholmCommuterAddScreen$3$2$1(bornholmCommuterAddViewModel2);
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceGroup();
        Function1 function12 = (Function1) ((KFunction) rememberedValue2);
        composer.startReplaceGroup(1875197125);
        boolean changedInstance3 = composer.changedInstance(this.$viewModel) | composer.changed(this.$navigator);
        final BornholmCommuterAddViewModel bornholmCommuterAddViewModel3 = this.$viewModel;
        final DestinationsNavigator destinationsNavigator = this.$navigator;
        Object rememberedValue3 = composer.rememberedValue();
        if (changedInstance3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
            rememberedValue3 = new Function0() { // from class: dk.molslinjen.ui.views.screens.agreements.commuter.bornholm.add.a
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$3$lambda$2;
                    invoke$lambda$3$lambda$2 = BornholmCommuterAddScreenKt$BornholmCommuterAddScreen$3.invoke$lambda$3$lambda$2(BornholmCommuterAddViewModel.this, destinationsNavigator);
                    return invoke$lambda$3$lambda$2;
                }
            };
            composer.updateRememberedValue(rememberedValue3);
        }
        composer.endReplaceGroup();
        BornholmCommuterAddScreenKt.AddAgreementContent(viewState, function1, function12, (Function0) rememberedValue3, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
