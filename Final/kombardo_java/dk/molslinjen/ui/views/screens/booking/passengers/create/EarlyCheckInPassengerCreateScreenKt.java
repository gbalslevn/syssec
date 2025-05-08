package dk.molslinjen.ui.views.screens.booking.passengers.create;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import com.ramcosta.composedestinations.generated.destinations.NationalitySelectionScreenDestination;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import com.ramcosta.composedestinations.result.ResultRecipient;
import dk.molslinjen.ui.views.screens.booking.passengers.create.EarlyCheckInPassengerCreateScreenKt;
import dk.molslinjen.ui.views.screens.booking.passengers.create.EarlyCheckInPassengerCreateViewModel;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a1\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H\u0007¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"EarlyCheckInPassengerCreateScreen", BuildConfig.FLAVOR, "viewModel", "Ldk/molslinjen/ui/views/screens/booking/passengers/create/EarlyCheckInPassengerCreateViewModel;", "navigator", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "nationalityResultRecipient", "Lcom/ramcosta/composedestinations/result/ResultRecipient;", "Lcom/ramcosta/composedestinations/generated/destinations/NationalitySelectionScreenDestination;", "Ljava/util/Locale;", "(Ldk/molslinjen/ui/views/screens/booking/passengers/create/EarlyCheckInPassengerCreateViewModel;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Lcom/ramcosta/composedestinations/result/ResultRecipient;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class EarlyCheckInPassengerCreateScreenKt {
    public static final void EarlyCheckInPassengerCreateScreen(final EarlyCheckInPassengerCreateViewModel viewModel, final DestinationsNavigator navigator, final ResultRecipient<NationalitySelectionScreenDestination, Locale> nationalityResultRecipient, Composer composer, final int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Intrinsics.checkNotNullParameter(nationalityResultRecipient, "nationalityResultRecipient");
        Composer startRestartGroup = composer.startRestartGroup(1251461511);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewModel) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(navigator) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changed(nationalityResultRecipient) ? 256 : 128;
        }
        if ((i6 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1251461511, i6, -1, "dk.molslinjen.ui.views.screens.booking.passengers.create.EarlyCheckInPassengerCreateScreen (EarlyCheckInPassengerCreateScreen.kt:29)");
            }
            PassengerCreateViewState passengerCreateViewState = (PassengerCreateViewState) SnapshotStateKt.collectAsState(viewModel.getViewState(), null, startRestartGroup, 0, 1).getValue();
            startRestartGroup.startReplaceGroup(789947741);
            boolean changedInstance = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new EarlyCheckInPassengerCreateScreenKt$EarlyCheckInPassengerCreateScreen$1$1(viewModel);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            Function1 function1 = (Function1) ((KFunction) rememberedValue);
            startRestartGroup.startReplaceGroup(789950617);
            boolean changedInstance2 = startRestartGroup.changedInstance(viewModel) | ((i6 & 112) == 32);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: W2.e
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit EarlyCheckInPassengerCreateScreen$lambda$2$lambda$1;
                        EarlyCheckInPassengerCreateScreen$lambda$2$lambda$1 = EarlyCheckInPassengerCreateScreenKt.EarlyCheckInPassengerCreateScreen$lambda$2$lambda$1(EarlyCheckInPassengerCreateViewModel.this, navigator);
                        return EarlyCheckInPassengerCreateScreen$lambda$2$lambda$1;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            int i7 = (i6 >> 6) & 14;
            int i8 = i6 << 12;
            CheckoutPassengerCreateScreenKt.PassengerCreate(nationalityResultRecipient, function1, passengerCreateViewState, (Function0) rememberedValue2, viewModel, navigator, startRestartGroup, i7 | (57344 & i8) | (i8 & 458752));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: W2.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit EarlyCheckInPassengerCreateScreen$lambda$3;
                    EarlyCheckInPassengerCreateScreen$lambda$3 = EarlyCheckInPassengerCreateScreenKt.EarlyCheckInPassengerCreateScreen$lambda$3(EarlyCheckInPassengerCreateViewModel.this, navigator, nationalityResultRecipient, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return EarlyCheckInPassengerCreateScreen$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EarlyCheckInPassengerCreateScreen$lambda$2$lambda$1(EarlyCheckInPassengerCreateViewModel earlyCheckInPassengerCreateViewModel, DestinationsNavigator destinationsNavigator) {
        earlyCheckInPassengerCreateViewModel.registerPassenger(new EarlyCheckInPassengerCreateScreenKt$EarlyCheckInPassengerCreateScreen$2$1$1(destinationsNavigator));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EarlyCheckInPassengerCreateScreen$lambda$3(EarlyCheckInPassengerCreateViewModel earlyCheckInPassengerCreateViewModel, DestinationsNavigator destinationsNavigator, ResultRecipient resultRecipient, int i5, Composer composer, int i6) {
        EarlyCheckInPassengerCreateScreen(earlyCheckInPassengerCreateViewModel, destinationsNavigator, resultRecipient, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
