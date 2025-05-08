package dk.molslinjen.ui.views.screens.booking.departures;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.view.compose.BackHandlerKt;
import com.ramcosta.composedestinations.generated.destinations.CalendarScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.TicketTypeScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.TransportationSelectorScreenDestination;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import com.ramcosta.composedestinations.result.ResultRecipient;
import dk.molslinjen.ui.views.global.navigation.wrappers.CommuterFlowStickyTopBarWrapper;
import dk.molslinjen.ui.views.screens.booking.departures.DeparturesCommuterScreenKt;
import dk.molslinjen.ui.views.screens.booking.departures.DeparturesViewModel;
import dk.molslinjen.ui.views.screens.booking.shared.CheckoutCommuterFlowTopBarKt;
import dk.molslinjen.ui.views.screens.config.regular.checkout.helpers.ICheckoutExpirationDialogHandler;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;

@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aa\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\u00072\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\u00072\u0006\u0010\u0010\u001a\u00020\u0011H\u0007¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, d2 = {"DeparturesCommuterScreen", BuildConfig.FLAVOR, "viewModel", "Ldk/molslinjen/ui/views/screens/booking/departures/DeparturesViewModel;", "navigator", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "calendarResultRecipient", "Lcom/ramcosta/composedestinations/result/ResultRecipient;", "Lcom/ramcosta/composedestinations/generated/destinations/CalendarScreenDestination;", "Lorg/threeten/bp/LocalDate;", "transportationSelectorResultRecipient", "Lcom/ramcosta/composedestinations/generated/destinations/TransportationSelectorScreenDestination;", BuildConfig.FLAVOR, "onOutboundDepartureSelectedResultRecipient", "Lcom/ramcosta/composedestinations/generated/destinations/TicketTypeScreenDestination;", "Ljava/util/UUID;", "checkoutExpirationDialogHandler", "Ldk/molslinjen/ui/views/screens/config/regular/checkout/helpers/ICheckoutExpirationDialogHandler;", "(Ldk/molslinjen/ui/views/screens/booking/departures/DeparturesViewModel;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Lcom/ramcosta/composedestinations/result/ResultRecipient;Lcom/ramcosta/composedestinations/result/ResultRecipient;Lcom/ramcosta/composedestinations/result/ResultRecipient;Ldk/molslinjen/ui/views/screens/config/regular/checkout/helpers/ICheckoutExpirationDialogHandler;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class DeparturesCommuterScreenKt {
    public static final void DeparturesCommuterScreen(final DeparturesViewModel viewModel, final DestinationsNavigator navigator, final ResultRecipient<CalendarScreenDestination, LocalDate> calendarResultRecipient, final ResultRecipient<TransportationSelectorScreenDestination, Boolean> transportationSelectorResultRecipient, final ResultRecipient<TicketTypeScreenDestination, UUID> onOutboundDepartureSelectedResultRecipient, final ICheckoutExpirationDialogHandler checkoutExpirationDialogHandler, Composer composer, final int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Intrinsics.checkNotNullParameter(calendarResultRecipient, "calendarResultRecipient");
        Intrinsics.checkNotNullParameter(transportationSelectorResultRecipient, "transportationSelectorResultRecipient");
        Intrinsics.checkNotNullParameter(onOutboundDepartureSelectedResultRecipient, "onOutboundDepartureSelectedResultRecipient");
        Intrinsics.checkNotNullParameter(checkoutExpirationDialogHandler, "checkoutExpirationDialogHandler");
        Composer startRestartGroup = composer.startRestartGroup(906345928);
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
            i6 |= startRestartGroup.changed(transportationSelectorResultRecipient) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changed(onOutboundDepartureSelectedResultRecipient) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i6 |= (262144 & i5) == 0 ? startRestartGroup.changed(checkoutExpirationDialogHandler) : startRestartGroup.changedInstance(checkoutExpirationDialogHandler) ? 131072 : 65536;
        }
        if ((74899 & i6) == 74898 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(906345928, i6, -1, "dk.molslinjen.ui.views.screens.booking.departures.DeparturesCommuterScreen (DeparturesCommuterScreen.kt:31)");
            }
            startRestartGroup.startReplaceGroup(1508649786);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final MutableState mutableState = (MutableState) rememberedValue;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1508651428);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: J2.p
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit DeparturesCommuterScreen$lambda$2$lambda$1;
                        DeparturesCommuterScreen$lambda$2$lambda$1 = DeparturesCommuterScreenKt.DeparturesCommuterScreen$lambda$2$lambda$1(MutableState.this);
                        return DeparturesCommuterScreen$lambda$2$lambda$1;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            BackHandlerKt.BackHandler(false, (Function0) rememberedValue2, startRestartGroup, 48, 1);
            startRestartGroup.startReplaceGroup(1508654991);
            boolean changedInstance = startRestartGroup.changedInstance(viewModel) | ((i6 & 112) == 32);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue3 == companion.getEmpty()) {
                rememberedValue3 = new Function0() { // from class: J2.q
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit DeparturesCommuterScreen$lambda$4$lambda$3;
                        DeparturesCommuterScreen$lambda$4$lambda$3 = DeparturesCommuterScreenKt.DeparturesCommuterScreen$lambda$4$lambda$3(DeparturesViewModel.this, navigator);
                        return DeparturesCommuterScreen$lambda$4$lambda$3;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceGroup();
            CheckoutCommuterFlowTopBarKt.AbortCommuterFlowDialog(mutableState, (Function0) rememberedValue3, startRestartGroup, 6);
            DeparturesScreenSharedKt.DeparturesScreenShared(viewModel, navigator, calendarResultRecipient, transportationSelectorResultRecipient, onOutboundDepartureSelectedResultRecipient, checkoutExpirationDialogHandler, startRestartGroup, i6 & 524286);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: J2.r
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit DeparturesCommuterScreen$lambda$5;
                    DeparturesCommuterScreen$lambda$5 = DeparturesCommuterScreenKt.DeparturesCommuterScreen$lambda$5(DeparturesViewModel.this, navigator, calendarResultRecipient, transportationSelectorResultRecipient, onOutboundDepartureSelectedResultRecipient, checkoutExpirationDialogHandler, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return DeparturesCommuterScreen$lambda$5;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeparturesCommuterScreen$lambda$2$lambda$1(MutableState mutableState) {
        mutableState.setValue(Boolean.TRUE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeparturesCommuterScreen$lambda$4$lambda$3(DeparturesViewModel departuresViewModel, DestinationsNavigator destinationsNavigator) {
        CommuterFlowStickyTopBarWrapper.INSTANCE.abortCommuterFlow(departuresViewModel, destinationsNavigator);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeparturesCommuterScreen$lambda$5(DeparturesViewModel departuresViewModel, DestinationsNavigator destinationsNavigator, ResultRecipient resultRecipient, ResultRecipient resultRecipient2, ResultRecipient resultRecipient3, ICheckoutExpirationDialogHandler iCheckoutExpirationDialogHandler, int i5, Composer composer, int i6) {
        DeparturesCommuterScreen(departuresViewModel, destinationsNavigator, resultRecipient, resultRecipient2, resultRecipient3, iCheckoutExpirationDialogHandler, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
