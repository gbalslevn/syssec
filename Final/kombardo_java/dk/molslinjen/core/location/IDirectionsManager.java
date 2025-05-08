package dk.molslinjen.core.location;

import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.model.booking.TravelTimeToNearestHarbor;
import dk.molslinjen.domain.model.booking.TravelTimeToNearestHarborOnRoute;
import dk.molslinjen.domain.model.config.Site;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\u0007J&\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Ldk/molslinjen/core/location/IDirectionsManager;", BuildConfig.FLAVOR, "getTravelTimeToNearestHarbor", "Ldk/molslinjen/domain/managers/ManagerResult;", "Ldk/molslinjen/domain/model/booking/TravelTimeToNearestHarbor;", "site", "Ldk/molslinjen/domain/model/config/Site;", "(Ldk/molslinjen/domain/model/config/Site;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTravelTimeToNearestHarborOnRoute", "Ldk/molslinjen/domain/model/booking/TravelTimeToNearestHarborOnRoute;", "routeDirectionId", BuildConfig.FLAVOR, "(Ljava/lang/String;Ldk/molslinjen/domain/model/config/Site;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IDirectionsManager {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ Object getTravelTimeToNearestHarbor$default(IDirectionsManager iDirectionsManager, Site site, Continuation continuation, int i5, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getTravelTimeToNearestHarbor");
            }
            if ((i5 & 1) != 0) {
                site = Site.Kombardo;
            }
            return iDirectionsManager.getTravelTimeToNearestHarbor(site, continuation);
        }
    }

    Object getTravelTimeToNearestHarbor(Site site, Continuation<? super ManagerResult<TravelTimeToNearestHarbor>> continuation);

    Object getTravelTimeToNearestHarborOnRoute(String str, Site site, Continuation<? super ManagerResult<TravelTimeToNearestHarborOnRoute>> continuation);
}
