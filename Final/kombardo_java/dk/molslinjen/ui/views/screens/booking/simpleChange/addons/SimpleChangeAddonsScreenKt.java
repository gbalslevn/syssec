package dk.molslinjen.ui.views.screens.booking.simpleChange.addons;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import com.ramcosta.composedestinations.generated.destinations.SimpleChangeSummaryScreenDestination;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import dk.molslinjen.ui.views.screens.booking.simpleChange.addons.SimpleChangeAddonsScreenKt;
import dk.molslinjen.ui.views.screens.booking.simpleChange.addons.SimpleChangeAddonsViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"SimpleChangeAddonsScreen", BuildConfig.FLAVOR, "viewModel", "Ldk/molslinjen/ui/views/screens/booking/simpleChange/addons/SimpleChangeAddonsViewModel;", "navigator", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "(Ldk/molslinjen/ui/views/screens/booking/simpleChange/addons/SimpleChangeAddonsViewModel;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class SimpleChangeAddonsScreenKt {
    public static final void SimpleChangeAddonsScreen(final SimpleChangeAddonsViewModel viewModel, final DestinationsNavigator navigator, Composer composer, final int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Composer startRestartGroup = composer.startRestartGroup(-2034258640);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewModel) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(navigator) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2034258640, i6, -1, "dk.molslinjen.ui.views.screens.booking.simpleChange.addons.SimpleChangeAddonsScreen (SimpleChangeAddonsScreen.kt:13)");
            }
            startRestartGroup.startReplaceGroup(2099894529);
            int i7 = i6 & 112;
            boolean z5 = i7 == 32;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new SimpleChangeAddonsScreenKt$SimpleChangeAddonsScreen$1$1(navigator);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            Function0 function0 = (Function0) rememberedValue;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(2099895962);
            boolean z6 = i7 == 32;
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (z6 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: e3.d
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit SimpleChangeAddonsScreen$lambda$2$lambda$1;
                        SimpleChangeAddonsScreen$lambda$2$lambda$1 = SimpleChangeAddonsScreenKt.SimpleChangeAddonsScreen$lambda$2$lambda$1(DestinationsNavigator.this);
                        return SimpleChangeAddonsScreen$lambda$2$lambda$1;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            SimpleChangeAddonsSharedContentKt.SimpleChangeAddonsSharedContent(viewModel, (Function0) rememberedValue2, function0, startRestartGroup, i6 & 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: e3.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit SimpleChangeAddonsScreen$lambda$3;
                    SimpleChangeAddonsScreen$lambda$3 = SimpleChangeAddonsScreenKt.SimpleChangeAddonsScreen$lambda$3(SimpleChangeAddonsViewModel.this, navigator, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return SimpleChangeAddonsScreen$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SimpleChangeAddonsScreen$lambda$2$lambda$1(DestinationsNavigator destinationsNavigator) {
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, SimpleChangeSummaryScreenDestination.INSTANCE, null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SimpleChangeAddonsScreen$lambda$3(SimpleChangeAddonsViewModel simpleChangeAddonsViewModel, DestinationsNavigator destinationsNavigator, int i5, Composer composer, int i6) {
        SimpleChangeAddonsScreen(simpleChangeAddonsViewModel, destinationsNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
