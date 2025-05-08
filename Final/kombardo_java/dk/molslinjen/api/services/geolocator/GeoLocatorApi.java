package dk.molslinjen.api.services.geolocator;

import dk.molslinjen.api.helpers.retry.Retry;
import dk.molslinjen.api.services.config.response.SiteDTO;
import dk.molslinjen.api.services.geolocator.response.TravelTimeToNearestHarborOnRouteResponseDTO;
import dk.molslinjen.api.services.geolocator.response.TravelTimeToNearestHarborResponseDTO;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.conscrypt.BuildConfig;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\ba\u0018\u00002\u00020\u0001J2\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0003\u0010\b\u001a\u00020\tH§@¢\u0006\u0002\u0010\nJ<\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\b\b\u0001\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\tH§@¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"Ldk/molslinjen/api/services/geolocator/GeoLocatorApi;", BuildConfig.FLAVOR, "getTravelTimeToNearestHarbor", "Lretrofit2/Response;", "Ldk/molslinjen/api/services/geolocator/response/TravelTimeToNearestHarborResponseDTO;", "latitude", BuildConfig.FLAVOR, "longitude", "site", "Ldk/molslinjen/api/services/config/response/SiteDTO;", "(DDLdk/molslinjen/api/services/config/response/SiteDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTravelTimeToNearestHarborOnRoute", "Ldk/molslinjen/api/services/geolocator/response/TravelTimeToNearestHarborOnRouteResponseDTO;", "routeId", BuildConfig.FLAVOR, "(Ljava/lang/String;DDLdk/molslinjen/api/services/config/response/SiteDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface GeoLocatorApi {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ Object getTravelTimeToNearestHarbor$default(GeoLocatorApi geoLocatorApi, double d5, double d6, SiteDTO siteDTO, Continuation continuation, int i5, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getTravelTimeToNearestHarbor");
            }
            if ((i5 & 4) != 0) {
                siteDTO = SiteDTO.Kombardo;
            }
            return geoLocatorApi.getTravelTimeToNearestHarbor(d5, d6, siteDTO, continuation);
        }
    }

    @GET("v1/geo/harbor")
    @Retry
    Object getTravelTimeToNearestHarbor(@Query("latitude") double d5, @Query("longitude") double d6, @Header("Line") SiteDTO siteDTO, Continuation<Response<TravelTimeToNearestHarborResponseDTO>> continuation);

    @GET("v1/geo/harbor/traveltime/{routeId}")
    Object getTravelTimeToNearestHarborOnRoute(@Path("routeId") String str, @Query("latitude") double d5, @Query("longitude") double d6, @Header("Line") SiteDTO siteDTO, Continuation<Response<TravelTimeToNearestHarborOnRouteResponseDTO>> continuation);
}
