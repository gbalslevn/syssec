package dk.molslinjen.ui.views.screens.booking.departures;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import com.ramcosta.composedestinations.generated.destinations.CalendarScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.TicketTypeScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.TransportationSelectorScreenDestination;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import com.ramcosta.composedestinations.result.ResultRecipient;
import dk.molslinjen.ui.views.screens.booking.departures.DeparturesScreenKt;
import dk.molslinjen.ui.views.screens.booking.departures.DeparturesViewModel;
import dk.molslinjen.ui.views.screens.config.regular.checkout.helpers.ICheckoutExpirationDialogHandler;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;

@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aa\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\u00072\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\u00072\u0006\u0010\u0010\u001a\u00020\u0011H\u0007¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, d2 = {"DeparturesScreen", BuildConfig.FLAVOR, "viewModel", "Ldk/molslinjen/ui/views/screens/booking/departures/DeparturesViewModel;", "navigator", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "calendarResultRecipient", "Lcom/ramcosta/composedestinations/result/ResultRecipient;", "Lcom/ramcosta/composedestinations/generated/destinations/CalendarScreenDestination;", "Lorg/threeten/bp/LocalDate;", "transportationSelectorResultRecipient", "Lcom/ramcosta/composedestinations/generated/destinations/TransportationSelectorScreenDestination;", BuildConfig.FLAVOR, "onOutboundDepartureSelectedResultRecipient", "Lcom/ramcosta/composedestinations/generated/destinations/TicketTypeScreenDestination;", "Ljava/util/UUID;", "checkoutExpirationDialogHandler", "Ldk/molslinjen/ui/views/screens/config/regular/checkout/helpers/ICheckoutExpirationDialogHandler;", "(Ldk/molslinjen/ui/views/screens/booking/departures/DeparturesViewModel;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Lcom/ramcosta/composedestinations/result/ResultRecipient;Lcom/ramcosta/composedestinations/result/ResultRecipient;Lcom/ramcosta/composedestinations/result/ResultRecipient;Ldk/molslinjen/ui/views/screens/config/regular/checkout/helpers/ICheckoutExpirationDialogHandler;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class DeparturesScreenKt {
    public static final void DeparturesScreen(final DeparturesViewModel viewModel, final DestinationsNavigator navigator, final ResultRecipient<CalendarScreenDestination, LocalDate> calendarResultRecipient, final ResultRecipient<TransportationSelectorScreenDestination, Boolean> transportationSelectorResultRecipient, final ResultRecipient<TicketTypeScreenDestination, UUID> onOutboundDepartureSelectedResultRecipient, final ICheckoutExpirationDialogHandler checkoutExpirationDialogHandler, Composer composer, final int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Intrinsics.checkNotNullParameter(calendarResultRecipient, "calendarResultRecipient");
        Intrinsics.checkNotNullParameter(transportationSelectorResultRecipient, "transportationSelectorResultRecipient");
        Intrinsics.checkNotNullParameter(onOutboundDepartureSelectedResultRecipient, "onOutboundDepartureSelectedResultRecipient");
        Intrinsics.checkNotNullParameter(checkoutExpirationDialogHandler, "checkoutExpirationDialogHandler");
        Composer startRestartGroup = composer.startRestartGroup(1530342712);
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
                ComposerKt.traceEventStart(1530342712, i6, -1, "dk.molslinjen.ui.views.screens.booking.departures.DeparturesScreen (DeparturesScreen.kt:25)");
            }
            DeparturesScreenSharedKt.DeparturesScreenShared(viewModel, navigator, calendarResultRecipient, transportationSelectorResultRecipient, onOutboundDepartureSelectedResultRecipient, checkoutExpirationDialogHandler, startRestartGroup, i6 & 524286);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: J2.E
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit DeparturesScreen$lambda$0;
                    DeparturesScreen$lambda$0 = DeparturesScreenKt.DeparturesScreen$lambda$0(DeparturesViewModel.this, navigator, calendarResultRecipient, transportationSelectorResultRecipient, onOutboundDepartureSelectedResultRecipient, checkoutExpirationDialogHandler, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return DeparturesScreen$lambda$0;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeparturesScreen$lambda$0(DeparturesViewModel departuresViewModel, DestinationsNavigator destinationsNavigator, ResultRecipient resultRecipient, ResultRecipient resultRecipient2, ResultRecipient resultRecipient3, ICheckoutExpirationDialogHandler iCheckoutExpirationDialogHandler, int i5, Composer composer, int i6) {
        DeparturesScreen(departuresViewModel, destinationsNavigator, resultRecipient, resultRecipient2, resultRecipient3, iCheckoutExpirationDialogHandler, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
