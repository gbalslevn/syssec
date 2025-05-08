package dk.molslinjen.ui.views.screens.booking.shared.kombardoTravelDetails;

import android.content.Context;
import dk.molslinjen.domain.model.booking.IDepartureInfo;
import dk.molslinjen.domain.model.booking.RouteType;
import dk.molslinjen.domain.model.config.Harbor;
import dk.molslinjen.ui.views.screens.booking.ticketType.Step;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J=\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/shared/kombardoTravelDetails/KombardoTravelDetailsHandler;", BuildConfig.FLAVOR, "<init>", "()V", "Landroid/content/Context;", "context", "Ldk/molslinjen/domain/model/config/Harbor;", "departureHarbor", "arrivalHarbor", "Ldk/molslinjen/domain/model/booking/IDepartureInfo;", "departure", BuildConfig.FLAVOR, "harbors", BuildConfig.FLAVOR, "buildTravelDetails", "(Landroid/content/Context;Ldk/molslinjen/domain/model/config/Harbor;Ldk/molslinjen/domain/model/config/Harbor;Ldk/molslinjen/domain/model/booking/IDepartureInfo;Ljava/util/List;)V", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/ui/views/screens/booking/shared/kombardoTravelDetails/IKombardoTravelDetailsHandler$TravelDetailsState;", "travelDetailsState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "getTravelDetailsState", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class KombardoTravelDetailsHandler {
    private final MutableStateFlow<TravelDetailsState> travelDetailsState = StateFlowKt.MutableStateFlow(new TravelDetailsState(null, 1, null));

    public void buildTravelDetails(Context context, Harbor departureHarbor, Harbor arrivalHarbor, IDepartureInfo departure, List<Harbor> harbors) {
        TravelDetailsState value;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(departureHarbor, "departureHarbor");
        Intrinsics.checkNotNullParameter(arrivalHarbor, "arrivalHarbor");
        Intrinsics.checkNotNullParameter(departure, "departure");
        Intrinsics.checkNotNullParameter(harbors, "harbors");
        List<? extends Step> access$buildShuttleSteps = departure.getRouteType() == RouteType.Shuttle ? KombardoTravelDetailsHandlerKt.access$buildShuttleSteps(departure, departureHarbor, arrivalHarbor, harbors, context) : KombardoTravelDetailsHandlerKt.access$buildNoneShuttleSteps(departure, departureHarbor, arrivalHarbor, departure.getRouteType(), harbors, context);
        MutableStateFlow<TravelDetailsState> travelDetailsState = getTravelDetailsState();
        do {
            value = travelDetailsState.getValue();
        } while (!travelDetailsState.compareAndSet(value, value.copy(access$buildShuttleSteps)));
    }

    public MutableStateFlow<TravelDetailsState> getTravelDetailsState() {
        return this.travelDetailsState;
    }
}
