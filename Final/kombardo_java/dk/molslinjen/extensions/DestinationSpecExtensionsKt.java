package dk.molslinjen.extensions;

import com.ramcosta.composedestinations.generated.destinations.AgreementsScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.DeparturesScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.SaleOnBoardScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.TicketsScreenDestination;
import com.ramcosta.composedestinations.spec.TypedDestinationSpec;
import dk.molslinjen.core.log.CriticalLog;
import dk.molslinjen.core.log.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\n\u0012\u0002\b\u00030\u0002j\u0002`\u0003¨\u0006\u0004"}, d2 = {"toTrackingTab", BuildConfig.FLAVOR, "Lcom/ramcosta/composedestinations/spec/TypedDestinationSpec;", "Lcom/ramcosta/composedestinations/spec/DestinationSpec;", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class DestinationSpecExtensionsKt {
    public static final String toTrackingTab(TypedDestinationSpec<?> typedDestinationSpec) {
        Intrinsics.checkNotNullParameter(typedDestinationSpec, "<this>");
        if (Intrinsics.areEqual(typedDestinationSpec, DeparturesScreenDestination.INSTANCE)) {
            return "departures";
        }
        if (Intrinsics.areEqual(typedDestinationSpec, TicketsScreenDestination.INSTANCE)) {
            return "tickets";
        }
        if (Intrinsics.areEqual(typedDestinationSpec, AgreementsScreenDestination.INSTANCE)) {
            return "agreements";
        }
        if (Intrinsics.areEqual(typedDestinationSpec, SaleOnBoardScreenDestination.INSTANCE)) {
            return "saleOnBoard";
        }
        Logger.INSTANCE.logCriticalThenFatalError(new CriticalLog("Unexpected tracking tap for destination for tracking: " + typedDestinationSpec));
        return "-";
    }
}
