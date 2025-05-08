package dk.molslinjen.api.services.geolocator;

import dk.molslinjen.api.helpers.ApiResult;
import dk.molslinjen.api.services.config.response.SiteDTO;
import dk.molslinjen.api.services.geolocator.response.TravelTimeToNearestHarborOnRouteResponseDTO;
import dk.molslinjen.api.services.geolocator.response.TravelTimeToNearestHarborResponseDTO;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\tH¦@¢\u0006\u0002\u0010\nJ4\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\tH¦@¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"Ldk/molslinjen/api/services/geolocator/IGeoLocatorService;", BuildConfig.FLAVOR, "getTravelTimeToNearestHarbor", "Ldk/molslinjen/api/helpers/ApiResult;", "Ldk/molslinjen/api/services/geolocator/response/TravelTimeToNearestHarborResponseDTO;", "latitude", BuildConfig.FLAVOR, "longitude", "site", "Ldk/molslinjen/api/services/config/response/SiteDTO;", "(DDLdk/molslinjen/api/services/config/response/SiteDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTravelTimeToNearestHarborOnRoute", "Ldk/molslinjen/api/services/geolocator/response/TravelTimeToNearestHarborOnRouteResponseDTO;", "routeId", BuildConfig.FLAVOR, "(DDLjava/lang/String;Ldk/molslinjen/api/services/config/response/SiteDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IGeoLocatorService {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ Object getTravelTimeToNearestHarbor$default(IGeoLocatorService iGeoLocatorService, double d5, double d6, SiteDTO siteDTO, Continuation continuation, int i5, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getTravelTimeToNearestHarbor");
            }
            if ((i5 & 4) != 0) {
                siteDTO = SiteDTO.Kombardo;
            }
            return iGeoLocatorService.getTravelTimeToNearestHarbor(d5, d6, siteDTO, continuation);
        }
    }

    Object getTravelTimeToNearestHarbor(double d5, double d6, SiteDTO siteDTO, Continuation<? super ApiResult<TravelTimeToNearestHarborResponseDTO>> continuation);

    Object getTravelTimeToNearestHarborOnRoute(double d5, double d6, String str, SiteDTO siteDTO, Continuation<? super ApiResult<TravelTimeToNearestHarborOnRouteResponseDTO>> continuation);
}
