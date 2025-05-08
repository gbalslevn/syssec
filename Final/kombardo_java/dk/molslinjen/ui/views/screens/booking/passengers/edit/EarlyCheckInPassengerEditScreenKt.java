package dk.molslinjen.ui.views.screens.booking.passengers.edit;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import com.ramcosta.composedestinations.generated.destinations.NationalitySelectionScreenDestination;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import com.ramcosta.composedestinations.result.ResultRecipient;
import dk.molslinjen.ui.views.screens.booking.passengers.edit.EarlyCheckInPassengerEditScreenKt;
import dk.molslinjen.ui.views.screens.booking.passengers.edit.EarlyCheckInPassengerEditViewModel;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a3\u0010\t\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/passengers/edit/EarlyCheckInPassengerEditViewModel;", "viewModel", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "navigator", "Lcom/ramcosta/composedestinations/result/ResultRecipient;", "Lcom/ramcosta/composedestinations/generated/destinations/NationalitySelectionScreenDestination;", "Ljava/util/Locale;", "nationalityResultRecipient", BuildConfig.FLAVOR, "EarlyCheckInPassengerEditScreen", "(Ldk/molslinjen/ui/views/screens/booking/passengers/edit/EarlyCheckInPassengerEditViewModel;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Lcom/ramcosta/composedestinations/result/ResultRecipient;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class EarlyCheckInPassengerEditScreenKt {
    public static final void EarlyCheckInPassengerEditScreen(final EarlyCheckInPassengerEditViewModel viewModel, final DestinationsNavigator navigator, final ResultRecipient<NationalitySelectionScreenDestination, Locale> nationalityResultRecipient, Composer composer, final int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Intrinsics.checkNotNullParameter(nationalityResultRecipient, "nationalityResultRecipient");
        Composer startRestartGroup = composer.startRestartGroup(69010731);
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
                ComposerKt.traceEventStart(69010731, i6, -1, "dk.molslinjen.ui.views.screens.booking.passengers.edit.EarlyCheckInPassengerEditScreen (EarlyCheckInPassengerEditScreen.kt:36)");
            }
            startRestartGroup.startReplaceGroup(919677401);
            boolean changedInstance = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new EarlyCheckInPassengerEditScreenKt$EarlyCheckInPassengerEditScreen$1$1(viewModel);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            Function1 function1 = (Function1) ((KFunction) rememberedValue);
            PassengerEditViewState passengerEditViewState = (PassengerEditViewState) SnapshotStateKt.collectAsState(viewModel.getViewState(), null, startRestartGroup, 0, 1).getValue();
            startRestartGroup.startReplaceGroup(919681267);
            int i7 = i6 & 112;
            boolean changedInstance2 = startRestartGroup.changedInstance(viewModel) | (i7 == 32);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: X2.f
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit EarlyCheckInPassengerEditScreen$lambda$2$lambda$1;
                        EarlyCheckInPassengerEditScreen$lambda$2$lambda$1 = EarlyCheckInPassengerEditScreenKt.EarlyCheckInPassengerEditScreen$lambda$2$lambda$1(EarlyCheckInPassengerEditViewModel.this, navigator);
                        return EarlyCheckInPassengerEditScreen$lambda$2$lambda$1;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            Function0 function0 = (Function0) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(919683863);
            boolean changedInstance3 = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changedInstance3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = new EarlyCheckInPassengerEditScreenKt$EarlyCheckInPassengerEditScreen$3$1(viewModel);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceGroup();
            Function0 function02 = (Function0) ((KFunction) rememberedValue3);
            startRestartGroup.startReplaceGroup(919685624);
            boolean changedInstance4 = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (changedInstance4 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                rememberedValue4 = new EarlyCheckInPassengerEditScreenKt$EarlyCheckInPassengerEditScreen$4$1(viewModel);
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            startRestartGroup.endReplaceGroup();
            Function0 function03 = (Function0) ((KFunction) rememberedValue4);
            startRestartGroup.startReplaceGroup(919687411);
            boolean changedInstance5 = startRestartGroup.changedInstance(viewModel) | (i7 == 32);
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (changedInstance5 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                rememberedValue5 = new Function0() { // from class: X2.g
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit EarlyCheckInPassengerEditScreen$lambda$7$lambda$6;
                        EarlyCheckInPassengerEditScreen$lambda$7$lambda$6 = EarlyCheckInPassengerEditScreenKt.EarlyCheckInPassengerEditScreen$lambda$7$lambda$6(EarlyCheckInPassengerEditViewModel.this, navigator);
                        return EarlyCheckInPassengerEditScreen$lambda$7$lambda$6;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            startRestartGroup.endReplaceGroup();
            int i8 = (i6 >> 6) & 14;
            int i9 = i6 << 21;
            CheckoutPassengerEditScreenKt.PassengerEdit(nationalityResultRecipient, function1, passengerEditViewState, function0, function02, function03, (Function0) rememberedValue5, viewModel, navigator, startRestartGroup, i8 | (29360128 & i9) | (i9 & 234881024));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: X2.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit EarlyCheckInPassengerEditScreen$lambda$8;
                    EarlyCheckInPassengerEditScreen$lambda$8 = EarlyCheckInPassengerEditScreenKt.EarlyCheckInPassengerEditScreen$lambda$8(EarlyCheckInPassengerEditViewModel.this, navigator, nationalityResultRecipient, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return EarlyCheckInPassengerEditScreen$lambda$8;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EarlyCheckInPassengerEditScreen$lambda$2$lambda$1(EarlyCheckInPassengerEditViewModel earlyCheckInPassengerEditViewModel, DestinationsNavigator destinationsNavigator) {
        earlyCheckInPassengerEditViewModel.deletePassenger(new EarlyCheckInPassengerEditScreenKt$EarlyCheckInPassengerEditScreen$2$1$1(destinationsNavigator));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EarlyCheckInPassengerEditScreen$lambda$7$lambda$6(EarlyCheckInPassengerEditViewModel earlyCheckInPassengerEditViewModel, DestinationsNavigator destinationsNavigator) {
        earlyCheckInPassengerEditViewModel.updatePassenger(new EarlyCheckInPassengerEditScreenKt$EarlyCheckInPassengerEditScreen$5$1$1(destinationsNavigator));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EarlyCheckInPassengerEditScreen$lambda$8(EarlyCheckInPassengerEditViewModel earlyCheckInPassengerEditViewModel, DestinationsNavigator destinationsNavigator, ResultRecipient resultRecipient, int i5, Composer composer, int i6) {
        EarlyCheckInPassengerEditScreen(earlyCheckInPassengerEditViewModel, destinationsNavigator, resultRecipient, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
