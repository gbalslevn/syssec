package dk.molslinjen.ui.views.screens.booking.departures;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.lifecycle.compose.LifecycleEffectKt;
import androidx.lifecycle.compose.LifecyclePauseOrDisposeEffectResult;
import androidx.lifecycle.compose.LifecycleResumePauseEffectScope;
import androidx.view.compose.BackHandlerKt;
import com.ramcosta.composedestinations.generated.destinations.CalendarScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.CargoDetailsScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.TicketTypeScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.TransportationSelectorScreenDestination;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import com.ramcosta.composedestinations.result.OpenResultRecipientKt;
import com.ramcosta.composedestinations.result.ResultRecipient;
import dk.molslinjen.ui.views.global.navigation.wrappers.SingleReturnFlowStickyTopBarWrapper;
import dk.molslinjen.ui.views.screens.booking.departures.DeparturesReturnScreenKt;
import dk.molslinjen.ui.views.screens.booking.departures.DeparturesViewModel;
import dk.molslinjen.ui.views.screens.booking.shared.CheckoutReturnFlowTopBarKt;
import dk.molslinjen.ui.views.screens.config.regular.checkout.helpers.ICheckoutExpirationDialogHandler;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;

@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001au\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\u00072\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\f0\u00072\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u00072\u0006\u0010\u0012\u001a\u00020\u0013H\u0007¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, d2 = {"DeparturesReturnScreen", BuildConfig.FLAVOR, "viewModel", "Ldk/molslinjen/ui/views/screens/booking/departures/DeparturesViewModel;", "navigator", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "calendarResultRecipient", "Lcom/ramcosta/composedestinations/result/ResultRecipient;", "Lcom/ramcosta/composedestinations/generated/destinations/CalendarScreenDestination;", "Lorg/threeten/bp/LocalDate;", "cargoDetailsResultRecipient", "Lcom/ramcosta/composedestinations/generated/destinations/CargoDetailsScreenDestination;", BuildConfig.FLAVOR, "transportationSelectorResultRecipient", "Lcom/ramcosta/composedestinations/generated/destinations/TransportationSelectorScreenDestination;", "onOutboundDepartureSelectedResultRecipient", "Lcom/ramcosta/composedestinations/generated/destinations/TicketTypeScreenDestination;", "Ljava/util/UUID;", "checkoutExpirationDialogHandler", "Ldk/molslinjen/ui/views/screens/config/regular/checkout/helpers/ICheckoutExpirationDialogHandler;", "(Ldk/molslinjen/ui/views/screens/booking/departures/DeparturesViewModel;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Lcom/ramcosta/composedestinations/result/ResultRecipient;Lcom/ramcosta/composedestinations/result/ResultRecipient;Lcom/ramcosta/composedestinations/result/ResultRecipient;Lcom/ramcosta/composedestinations/result/ResultRecipient;Ldk/molslinjen/ui/views/screens/config/regular/checkout/helpers/ICheckoutExpirationDialogHandler;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class DeparturesReturnScreenKt {
    public static final void DeparturesReturnScreen(final DeparturesViewModel viewModel, final DestinationsNavigator navigator, final ResultRecipient<CalendarScreenDestination, LocalDate> calendarResultRecipient, final ResultRecipient<CargoDetailsScreenDestination, Boolean> cargoDetailsResultRecipient, final ResultRecipient<TransportationSelectorScreenDestination, Boolean> transportationSelectorResultRecipient, final ResultRecipient<TicketTypeScreenDestination, UUID> onOutboundDepartureSelectedResultRecipient, final ICheckoutExpirationDialogHandler checkoutExpirationDialogHandler, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Intrinsics.checkNotNullParameter(calendarResultRecipient, "calendarResultRecipient");
        Intrinsics.checkNotNullParameter(cargoDetailsResultRecipient, "cargoDetailsResultRecipient");
        Intrinsics.checkNotNullParameter(transportationSelectorResultRecipient, "transportationSelectorResultRecipient");
        Intrinsics.checkNotNullParameter(onOutboundDepartureSelectedResultRecipient, "onOutboundDepartureSelectedResultRecipient");
        Intrinsics.checkNotNullParameter(checkoutExpirationDialogHandler, "checkoutExpirationDialogHandler");
        Composer startRestartGroup = composer.startRestartGroup(2004807656);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewModel) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(navigator) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changed(calendarResultRecipient) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changed(cargoDetailsResultRecipient) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changed(transportationSelectorResultRecipient) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i6 |= startRestartGroup.changed(onOutboundDepartureSelectedResultRecipient) ? 131072 : 65536;
        }
        if ((1572864 & i5) == 0) {
            i6 |= (2097152 & i5) == 0 ? startRestartGroup.changed(checkoutExpirationDialogHandler) : startRestartGroup.changedInstance(checkoutExpirationDialogHandler) ? 1048576 : 524288;
        }
        int i7 = i6;
        if ((599187 & i7) == 599186 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2004807656, i7, -1, "dk.molslinjen.ui.views.screens.booking.departures.DeparturesReturnScreen (DeparturesReturnScreen.kt:35)");
            }
            startRestartGroup.startReplaceGroup(2002973554);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final MutableState mutableState = (MutableState) rememberedValue;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(2002975206);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: J2.y
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit DeparturesReturnScreen$lambda$2$lambda$1;
                        DeparturesReturnScreen$lambda$2$lambda$1 = DeparturesReturnScreenKt.DeparturesReturnScreen$lambda$2$lambda$1(MutableState.this);
                        return DeparturesReturnScreen$lambda$2$lambda$1;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            BackHandlerKt.BackHandler(false, (Function0) rememberedValue2, startRestartGroup, 48, 1);
            startRestartGroup.startReplaceGroup(2002979273);
            int i8 = i7 & 112;
            boolean changedInstance = startRestartGroup.changedInstance(viewModel) | (i8 == 32);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue3 == companion.getEmpty()) {
                rememberedValue3 = new Function0() { // from class: J2.z
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit DeparturesReturnScreen$lambda$4$lambda$3;
                        DeparturesReturnScreen$lambda$4$lambda$3 = DeparturesReturnScreenKt.DeparturesReturnScreen$lambda$4$lambda$3(DeparturesViewModel.this, navigator);
                        return DeparturesReturnScreen$lambda$4$lambda$3;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceGroup();
            CheckoutReturnFlowTopBarKt.AbortReturnFlowDialog(mutableState, (Function0) rememberedValue3, startRestartGroup, 6);
            startRestartGroup.startReplaceGroup(2002983581);
            boolean changedInstance2 = startRestartGroup.changedInstance(viewModel) | (i8 == 32);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue4 == companion.getEmpty()) {
                rememberedValue4 = new Function1() { // from class: J2.A
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit DeparturesReturnScreen$lambda$6$lambda$5;
                        DeparturesReturnScreen$lambda$6$lambda$5 = DeparturesReturnScreenKt.DeparturesReturnScreen$lambda$6$lambda$5(DeparturesViewModel.this, navigator, ((Boolean) obj).booleanValue());
                        return DeparturesReturnScreen$lambda$6$lambda$5;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            startRestartGroup.endReplaceGroup();
            OpenResultRecipientKt.onResult(cargoDetailsResultRecipient, null, (Function1) rememberedValue4, startRestartGroup, (i7 >> 9) & 14, 1);
            Unit unit = Unit.INSTANCE;
            startRestartGroup.startReplaceGroup(2002989587);
            boolean changedInstance3 = startRestartGroup.changedInstance(viewModel) | (i8 == 32);
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (changedInstance3 || rememberedValue5 == companion.getEmpty()) {
                rememberedValue5 = new Function1() { // from class: J2.B
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        LifecyclePauseOrDisposeEffectResult DeparturesReturnScreen$lambda$10$lambda$9;
                        DeparturesReturnScreen$lambda$10$lambda$9 = DeparturesReturnScreenKt.DeparturesReturnScreen$lambda$10$lambda$9(DeparturesViewModel.this, navigator, (LifecycleResumePauseEffectScope) obj);
                        return DeparturesReturnScreen$lambda$10$lambda$9;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            startRestartGroup.endReplaceGroup();
            LifecycleEffectKt.LifecycleResumeEffect(unit, null, (Function1) rememberedValue5, startRestartGroup, 6, 2);
            int i9 = i7 >> 3;
            composer2 = startRestartGroup;
            DeparturesScreenSharedKt.DeparturesScreenShared(viewModel, navigator, calendarResultRecipient, transportationSelectorResultRecipient, onOutboundDepartureSelectedResultRecipient, checkoutExpirationDialogHandler, startRestartGroup, (i7 & 1022) | (i9 & 7168) | (57344 & i9) | (i9 & 458752));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: J2.C
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit DeparturesReturnScreen$lambda$11;
                    DeparturesReturnScreen$lambda$11 = DeparturesReturnScreenKt.DeparturesReturnScreen$lambda$11(DeparturesViewModel.this, navigator, calendarResultRecipient, cargoDetailsResultRecipient, transportationSelectorResultRecipient, onOutboundDepartureSelectedResultRecipient, checkoutExpirationDialogHandler, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return DeparturesReturnScreen$lambda$11;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LifecyclePauseOrDisposeEffectResult DeparturesReturnScreen$lambda$10$lambda$9(DeparturesViewModel departuresViewModel, final DestinationsNavigator destinationsNavigator, final LifecycleResumePauseEffectScope LifecycleResumeEffect) {
        Intrinsics.checkNotNullParameter(LifecycleResumeEffect, "$this$LifecycleResumeEffect");
        departuresViewModel.handlePromptForCargoDetails(new Function1() { // from class: J2.D
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit DeparturesReturnScreen$lambda$10$lambda$9$lambda$7;
                DeparturesReturnScreen$lambda$10$lambda$9$lambda$7 = DeparturesReturnScreenKt.DeparturesReturnScreen$lambda$10$lambda$9$lambda$7(DestinationsNavigator.this, (String) obj);
                return DeparturesReturnScreen$lambda$10$lambda$9$lambda$7;
            }
        });
        return new LifecyclePauseOrDisposeEffectResult() { // from class: dk.molslinjen.ui.views.screens.booking.departures.DeparturesReturnScreenKt$DeparturesReturnScreen$lambda$10$lambda$9$$inlined$onPauseOrDispose$1
            @Override // androidx.lifecycle.compose.LifecyclePauseOrDisposeEffectResult
            public void runPauseOrOnDisposeEffect() {
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeparturesReturnScreen$lambda$10$lambda$9$lambda$7(DestinationsNavigator destinationsNavigator, String transportationId) {
        Intrinsics.checkNotNullParameter(transportationId, "transportationId");
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, CargoDetailsScreenDestination.INSTANCE.invoke(transportationId), null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeparturesReturnScreen$lambda$11(DeparturesViewModel departuresViewModel, DestinationsNavigator destinationsNavigator, ResultRecipient resultRecipient, ResultRecipient resultRecipient2, ResultRecipient resultRecipient3, ResultRecipient resultRecipient4, ICheckoutExpirationDialogHandler iCheckoutExpirationDialogHandler, int i5, Composer composer, int i6) {
        DeparturesReturnScreen(departuresViewModel, destinationsNavigator, resultRecipient, resultRecipient2, resultRecipient3, resultRecipient4, iCheckoutExpirationDialogHandler, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeparturesReturnScreen$lambda$2$lambda$1(MutableState mutableState) {
        mutableState.setValue(Boolean.TRUE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeparturesReturnScreen$lambda$4$lambda$3(DeparturesViewModel departuresViewModel, DestinationsNavigator destinationsNavigator) {
        SingleReturnFlowStickyTopBarWrapper.INSTANCE.abortReturnFlow(departuresViewModel, destinationsNavigator);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeparturesReturnScreen$lambda$6$lambda$5(DeparturesViewModel departuresViewModel, DestinationsNavigator destinationsNavigator, boolean z5) {
        if (z5) {
            SingleReturnFlowStickyTopBarWrapper.INSTANCE.abortReturnFlow(departuresViewModel, destinationsNavigator);
        }
        return Unit.INSTANCE;
    }
}
