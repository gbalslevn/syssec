package dk.molslinjen.domain.managers.geo;

import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.model.booking.TravelTimeToNearestHarbor;
import dk.molslinjen.domain.model.booking.TravelTimeToNearestHarborOnRoute;
import dk.molslinjen.domain.model.config.Site;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\tH¦@¢\u0006\u0002\u0010\nJ6\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\tH¦@¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"Ldk/molslinjen/domain/managers/geo/IGeoLocatorManager;", BuildConfig.FLAVOR, "getTravelTimeToNearestHarbor", "Ldk/molslinjen/domain/managers/ManagerResult;", "Ldk/molslinjen/domain/model/booking/TravelTimeToNearestHarbor;", "latitude", BuildConfig.FLAVOR, "longitude", "site", "Ldk/molslinjen/domain/model/config/Site;", "(DDLdk/molslinjen/domain/model/config/Site;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTravelTimeToNearestHarborOnRoute", "Ldk/molslinjen/domain/model/booking/TravelTimeToNearestHarborOnRoute;", "routeId", BuildConfig.FLAVOR, "(DDLjava/lang/String;Ldk/molslinjen/domain/model/config/Site;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IGeoLocatorManager {
    Object getTravelTimeToNearestHarbor(double d5, double d6, Site site, Continuation<? super ManagerResult<TravelTimeToNearestHarbor>> continuation);

    Object getTravelTimeToNearestHarborOnRoute(double d5, double d6, String str, Site site, Continuation<? super ManagerResult<TravelTimeToNearestHarborOnRoute>> continuation);
}
