package dk.molslinjen.domain.managers.geo;

import dk.molslinjen.api.helpers.ApiResult;
import dk.molslinjen.api.services.config.response.SiteDTO;
import dk.molslinjen.api.services.geolocator.IGeoLocatorService;
import dk.molslinjen.api.services.geolocator.response.TravelTimeToNearestHarborOnRouteResponseDTO;
import dk.molslinjen.api.services.geolocator.response.TravelTimeToNearestHarborResponseDTO;
import dk.molslinjen.domain.extensions.ManagerResultExtensionsKt;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.geo.GeoLocatorManager;
import dk.molslinjen.domain.model.booking.TravelTimeToNearestHarbor;
import dk.molslinjen.domain.model.booking.TravelTimeToNearestHarborOnRoute;
import dk.molslinjen.domain.model.config.Site;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J,\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u000eJ6\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Ldk/molslinjen/domain/managers/geo/GeoLocatorManager;", "Ldk/molslinjen/domain/managers/geo/IGeoLocatorManager;", "geoLocatorService", "Ldk/molslinjen/api/services/geolocator/IGeoLocatorService;", "<init>", "(Ldk/molslinjen/api/services/geolocator/IGeoLocatorService;)V", "getTravelTimeToNearestHarbor", "Ldk/molslinjen/domain/managers/ManagerResult;", "Ldk/molslinjen/domain/model/booking/TravelTimeToNearestHarbor;", "latitude", BuildConfig.FLAVOR, "longitude", "site", "Ldk/molslinjen/domain/model/config/Site;", "(DDLdk/molslinjen/domain/model/config/Site;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTravelTimeToNearestHarborOnRoute", "Ldk/molslinjen/domain/model/booking/TravelTimeToNearestHarborOnRoute;", "routeId", BuildConfig.FLAVOR, "(DDLjava/lang/String;Ldk/molslinjen/domain/model/config/Site;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class GeoLocatorManager implements IGeoLocatorManager {
    private final IGeoLocatorService geoLocatorService;

    public GeoLocatorManager(IGeoLocatorService geoLocatorService) {
        Intrinsics.checkNotNullParameter(geoLocatorService, "geoLocatorService");
        this.geoLocatorService = geoLocatorService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TravelTimeToNearestHarbor getTravelTimeToNearestHarbor$lambda$0(TravelTimeToNearestHarborResponseDTO it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return new TravelTimeToNearestHarbor(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TravelTimeToNearestHarborOnRoute getTravelTimeToNearestHarborOnRoute$lambda$1(TravelTimeToNearestHarborOnRouteResponseDTO it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.isWithinTravelRange()) {
            return new TravelTimeToNearestHarborOnRoute(it);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    @Override // dk.molslinjen.domain.managers.geo.IGeoLocatorManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getTravelTimeToNearestHarbor(double d5, double d6, Site site, Continuation<? super ManagerResult<TravelTimeToNearestHarbor>> continuation) {
        GeoLocatorManager$getTravelTimeToNearestHarbor$1 geoLocatorManager$getTravelTimeToNearestHarbor$1;
        int i5;
        if (continuation instanceof GeoLocatorManager$getTravelTimeToNearestHarbor$1) {
            geoLocatorManager$getTravelTimeToNearestHarbor$1 = (GeoLocatorManager$getTravelTimeToNearestHarbor$1) continuation;
            int i6 = geoLocatorManager$getTravelTimeToNearestHarbor$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                geoLocatorManager$getTravelTimeToNearestHarbor$1.label = i6 - Integer.MIN_VALUE;
                GeoLocatorManager$getTravelTimeToNearestHarbor$1 geoLocatorManager$getTravelTimeToNearestHarbor$12 = geoLocatorManager$getTravelTimeToNearestHarbor$1;
                Object obj = geoLocatorManager$getTravelTimeToNearestHarbor$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = geoLocatorManager$getTravelTimeToNearestHarbor$12.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    IGeoLocatorService iGeoLocatorService = this.geoLocatorService;
                    SiteDTO dto = site.toDTO();
                    geoLocatorManager$getTravelTimeToNearestHarbor$12.label = 1;
                    obj = iGeoLocatorService.getTravelTimeToNearestHarbor(d5, d6, dto, geoLocatorManager$getTravelTimeToNearestHarbor$12);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return ManagerResultExtensionsKt.toManagerResult((ApiResult) obj, new Function1() { // from class: D1.a
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        TravelTimeToNearestHarbor travelTimeToNearestHarbor$lambda$0;
                        travelTimeToNearestHarbor$lambda$0 = GeoLocatorManager.getTravelTimeToNearestHarbor$lambda$0((TravelTimeToNearestHarborResponseDTO) obj2);
                        return travelTimeToNearestHarbor$lambda$0;
                    }
                });
            }
        }
        geoLocatorManager$getTravelTimeToNearestHarbor$1 = new GeoLocatorManager$getTravelTimeToNearestHarbor$1(this, continuation);
        GeoLocatorManager$getTravelTimeToNearestHarbor$1 geoLocatorManager$getTravelTimeToNearestHarbor$122 = geoLocatorManager$getTravelTimeToNearestHarbor$1;
        Object obj2 = geoLocatorManager$getTravelTimeToNearestHarbor$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = geoLocatorManager$getTravelTimeToNearestHarbor$122.label;
        if (i5 != 0) {
        }
        return ManagerResultExtensionsKt.toManagerResult((ApiResult) obj2, new Function1() { // from class: D1.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj22) {
                TravelTimeToNearestHarbor travelTimeToNearestHarbor$lambda$0;
                travelTimeToNearestHarbor$lambda$0 = GeoLocatorManager.getTravelTimeToNearestHarbor$lambda$0((TravelTimeToNearestHarborResponseDTO) obj22);
                return travelTimeToNearestHarbor$lambda$0;
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0028  */
    @Override // dk.molslinjen.domain.managers.geo.IGeoLocatorManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getTravelTimeToNearestHarborOnRoute(double d5, double d6, String str, Site site, Continuation<? super ManagerResult<TravelTimeToNearestHarborOnRoute>> continuation) {
        GeoLocatorManager$getTravelTimeToNearestHarborOnRoute$1 geoLocatorManager$getTravelTimeToNearestHarborOnRoute$1;
        int i5;
        if (continuation instanceof GeoLocatorManager$getTravelTimeToNearestHarborOnRoute$1) {
            geoLocatorManager$getTravelTimeToNearestHarborOnRoute$1 = (GeoLocatorManager$getTravelTimeToNearestHarborOnRoute$1) continuation;
            int i6 = geoLocatorManager$getTravelTimeToNearestHarborOnRoute$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                geoLocatorManager$getTravelTimeToNearestHarborOnRoute$1.label = i6 - Integer.MIN_VALUE;
                GeoLocatorManager$getTravelTimeToNearestHarborOnRoute$1 geoLocatorManager$getTravelTimeToNearestHarborOnRoute$12 = geoLocatorManager$getTravelTimeToNearestHarborOnRoute$1;
                Object obj = geoLocatorManager$getTravelTimeToNearestHarborOnRoute$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = geoLocatorManager$getTravelTimeToNearestHarborOnRoute$12.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    IGeoLocatorService iGeoLocatorService = this.geoLocatorService;
                    SiteDTO dto = site.toDTO();
                    geoLocatorManager$getTravelTimeToNearestHarborOnRoute$12.label = 1;
                    obj = iGeoLocatorService.getTravelTimeToNearestHarborOnRoute(d5, d6, str, dto, geoLocatorManager$getTravelTimeToNearestHarborOnRoute$12);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return ManagerResultExtensionsKt.toManagerResult((ApiResult) obj, new Function1() { // from class: D1.b
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        TravelTimeToNearestHarborOnRoute travelTimeToNearestHarborOnRoute$lambda$1;
                        travelTimeToNearestHarborOnRoute$lambda$1 = GeoLocatorManager.getTravelTimeToNearestHarborOnRoute$lambda$1((TravelTimeToNearestHarborOnRouteResponseDTO) obj2);
                        return travelTimeToNearestHarborOnRoute$lambda$1;
                    }
                });
            }
        }
        geoLocatorManager$getTravelTimeToNearestHarborOnRoute$1 = new GeoLocatorManager$getTravelTimeToNearestHarborOnRoute$1(this, continuation);
        GeoLocatorManager$getTravelTimeToNearestHarborOnRoute$1 geoLocatorManager$getTravelTimeToNearestHarborOnRoute$122 = geoLocatorManager$getTravelTimeToNearestHarborOnRoute$1;
        Object obj2 = geoLocatorManager$getTravelTimeToNearestHarborOnRoute$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = geoLocatorManager$getTravelTimeToNearestHarborOnRoute$122.label;
        if (i5 != 0) {
        }
        return ManagerResultExtensionsKt.toManagerResult((ApiResult) obj2, new Function1() { // from class: D1.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj22) {
                TravelTimeToNearestHarborOnRoute travelTimeToNearestHarborOnRoute$lambda$1;
                travelTimeToNearestHarborOnRoute$lambda$1 = GeoLocatorManager.getTravelTimeToNearestHarborOnRoute$lambda$1((TravelTimeToNearestHarborOnRouteResponseDTO) obj22);
                return travelTimeToNearestHarborOnRoute$lambda$1;
            }
        });
    }
}
