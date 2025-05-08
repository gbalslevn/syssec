package dk.molslinjen.api.services.geolocator;

import dk.molslinjen.api.helpers.ApiResult;
import dk.molslinjen.api.services.BaseService;
import dk.molslinjen.api.services.config.response.SiteDTO;
import dk.molslinjen.api.services.geolocator.response.TravelTimeToNearestHarborOnRouteResponseDTO;
import dk.molslinjen.api.services.geolocator.response.TravelTimeToNearestHarborResponseDTO;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J,\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0096@¢\u0006\u0002\u0010\u000fJ4\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000eH\u0096@¢\u0006\u0002\u0010\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Ldk/molslinjen/api/services/geolocator/GeoLocatorService;", "Ldk/molslinjen/api/services/BaseService;", "Ldk/molslinjen/api/services/geolocator/IGeoLocatorService;", "api", "Ldk/molslinjen/api/services/geolocator/GeoLocatorApi;", "<init>", "(Ldk/molslinjen/api/services/geolocator/GeoLocatorApi;)V", "getTravelTimeToNearestHarbor", "Ldk/molslinjen/api/helpers/ApiResult;", "Ldk/molslinjen/api/services/geolocator/response/TravelTimeToNearestHarborResponseDTO;", "latitude", BuildConfig.FLAVOR, "longitude", "site", "Ldk/molslinjen/api/services/config/response/SiteDTO;", "(DDLdk/molslinjen/api/services/config/response/SiteDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTravelTimeToNearestHarborOnRoute", "Ldk/molslinjen/api/services/geolocator/response/TravelTimeToNearestHarborOnRouteResponseDTO;", "routeId", BuildConfig.FLAVOR, "(DDLjava/lang/String;Ldk/molslinjen/api/services/config/response/SiteDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class GeoLocatorService extends BaseService implements IGeoLocatorService {
    private final GeoLocatorApi api;

    public GeoLocatorService(GeoLocatorApi api) {
        Intrinsics.checkNotNullParameter(api, "api");
        this.api = api;
    }

    @Override // dk.molslinjen.api.services.geolocator.IGeoLocatorService
    public Object getTravelTimeToNearestHarbor(double d5, double d6, SiteDTO siteDTO, Continuation<? super ApiResult<TravelTimeToNearestHarborResponseDTO>> continuation) {
        return withContextHandlingErrors(Dispatchers.getIO(), new GeoLocatorService$getTravelTimeToNearestHarbor$2(this, d5, d6, siteDTO, null), continuation);
    }

    @Override // dk.molslinjen.api.services.geolocator.IGeoLocatorService
    public Object getTravelTimeToNearestHarborOnRoute(double d5, double d6, String str, SiteDTO siteDTO, Continuation<? super ApiResult<TravelTimeToNearestHarborOnRouteResponseDTO>> continuation) {
        return withContextHandlingErrors(Dispatchers.getIO(), new GeoLocatorService$getTravelTimeToNearestHarborOnRoute$2(this, str, d5, d6, siteDTO, null), continuation);
    }
}
