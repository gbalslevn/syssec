package dk.molslinjen.core.location;

import android.location.Location;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.geo.IGeoLocatorManager;
import dk.molslinjen.domain.model.booking.TravelTimeToNearestHarbor;
import dk.molslinjen.domain.model.booking.TravelTimeToNearestHarborOnRoute;
import dk.molslinjen.domain.model.config.Site;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010\rJ&\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\t2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Ldk/molslinjen/core/location/DirectionsManager;", "Ldk/molslinjen/core/location/IDirectionsManager;", "geoLocatorManager", "Ldk/molslinjen/domain/managers/geo/IGeoLocatorManager;", "locationManager", "Ldk/molslinjen/core/location/ILocationManager;", "<init>", "(Ldk/molslinjen/domain/managers/geo/IGeoLocatorManager;Ldk/molslinjen/core/location/ILocationManager;)V", "getTravelTimeToNearestHarbor", "Ldk/molslinjen/domain/managers/ManagerResult;", "Ldk/molslinjen/domain/model/booking/TravelTimeToNearestHarbor;", "site", "Ldk/molslinjen/domain/model/config/Site;", "(Ldk/molslinjen/domain/model/config/Site;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTravelTimeToNearestHarborOnRoute", "Ldk/molslinjen/domain/model/booking/TravelTimeToNearestHarborOnRoute;", "routeDirectionId", BuildConfig.FLAVOR, "(Ljava/lang/String;Ldk/molslinjen/domain/model/config/Site;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DirectionsManager implements IDirectionsManager {
    private final IGeoLocatorManager geoLocatorManager;
    private final ILocationManager locationManager;

    public DirectionsManager(IGeoLocatorManager geoLocatorManager, ILocationManager locationManager) {
        Intrinsics.checkNotNullParameter(geoLocatorManager, "geoLocatorManager");
        Intrinsics.checkNotNullParameter(locationManager, "locationManager");
        this.geoLocatorManager = geoLocatorManager;
        this.locationManager = locationManager;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0026  */
    @Override // dk.molslinjen.core.location.IDirectionsManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getTravelTimeToNearestHarbor(Site site, Continuation<? super ManagerResult<TravelTimeToNearestHarbor>> continuation) {
        DirectionsManager$getTravelTimeToNearestHarbor$1 directionsManager$getTravelTimeToNearestHarbor$1;
        int i5;
        DirectionsManager directionsManager;
        Location location;
        if (continuation instanceof DirectionsManager$getTravelTimeToNearestHarbor$1) {
            directionsManager$getTravelTimeToNearestHarbor$1 = (DirectionsManager$getTravelTimeToNearestHarbor$1) continuation;
            int i6 = directionsManager$getTravelTimeToNearestHarbor$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                directionsManager$getTravelTimeToNearestHarbor$1.label = i6 - Integer.MIN_VALUE;
                DirectionsManager$getTravelTimeToNearestHarbor$1 directionsManager$getTravelTimeToNearestHarbor$12 = directionsManager$getTravelTimeToNearestHarbor$1;
                Object obj = directionsManager$getTravelTimeToNearestHarbor$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = directionsManager$getTravelTimeToNearestHarbor$12.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    ILocationManager iLocationManager = this.locationManager;
                    directionsManager$getTravelTimeToNearestHarbor$12.L$0 = this;
                    directionsManager$getTravelTimeToNearestHarbor$12.L$1 = site;
                    directionsManager$getTravelTimeToNearestHarbor$12.label = 1;
                    obj = iLocationManager.getLocation(directionsManager$getTravelTimeToNearestHarbor$12);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    directionsManager = this;
                } else {
                    if (i5 != 1) {
                        if (i5 == 2) {
                            ResultKt.throwOnFailure(obj);
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    site = (Site) directionsManager$getTravelTimeToNearestHarbor$12.L$1;
                    directionsManager = (DirectionsManager) directionsManager$getTravelTimeToNearestHarbor$12.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                Site site2 = site;
                location = (Location) obj;
                if (location != null) {
                    return ManagerResult.Error.INSTANCE.noMessage();
                }
                IGeoLocatorManager iGeoLocatorManager = directionsManager.geoLocatorManager;
                double latitude = location.getLatitude();
                double longitude = location.getLongitude();
                directionsManager$getTravelTimeToNearestHarbor$12.L$0 = null;
                directionsManager$getTravelTimeToNearestHarbor$12.L$1 = null;
                directionsManager$getTravelTimeToNearestHarbor$12.label = 2;
                obj = iGeoLocatorManager.getTravelTimeToNearestHarbor(latitude, longitude, site2, directionsManager$getTravelTimeToNearestHarbor$12);
                return obj == coroutine_suspended ? coroutine_suspended : obj;
            }
        }
        directionsManager$getTravelTimeToNearestHarbor$1 = new DirectionsManager$getTravelTimeToNearestHarbor$1(this, continuation);
        DirectionsManager$getTravelTimeToNearestHarbor$1 directionsManager$getTravelTimeToNearestHarbor$122 = directionsManager$getTravelTimeToNearestHarbor$1;
        Object obj2 = directionsManager$getTravelTimeToNearestHarbor$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = directionsManager$getTravelTimeToNearestHarbor$122.label;
        if (i5 != 0) {
        }
        Site site22 = site;
        location = (Location) obj2;
        if (location != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0026  */
    @Override // dk.molslinjen.core.location.IDirectionsManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getTravelTimeToNearestHarborOnRoute(String str, Site site, Continuation<? super ManagerResult<TravelTimeToNearestHarborOnRoute>> continuation) {
        DirectionsManager$getTravelTimeToNearestHarborOnRoute$1 directionsManager$getTravelTimeToNearestHarborOnRoute$1;
        int i5;
        DirectionsManager directionsManager;
        Location location;
        if (continuation instanceof DirectionsManager$getTravelTimeToNearestHarborOnRoute$1) {
            directionsManager$getTravelTimeToNearestHarborOnRoute$1 = (DirectionsManager$getTravelTimeToNearestHarborOnRoute$1) continuation;
            int i6 = directionsManager$getTravelTimeToNearestHarborOnRoute$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                directionsManager$getTravelTimeToNearestHarborOnRoute$1.label = i6 - Integer.MIN_VALUE;
                DirectionsManager$getTravelTimeToNearestHarborOnRoute$1 directionsManager$getTravelTimeToNearestHarborOnRoute$12 = directionsManager$getTravelTimeToNearestHarborOnRoute$1;
                Object obj = directionsManager$getTravelTimeToNearestHarborOnRoute$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = directionsManager$getTravelTimeToNearestHarborOnRoute$12.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    ILocationManager iLocationManager = this.locationManager;
                    directionsManager$getTravelTimeToNearestHarborOnRoute$12.L$0 = this;
                    directionsManager$getTravelTimeToNearestHarborOnRoute$12.L$1 = str;
                    directionsManager$getTravelTimeToNearestHarborOnRoute$12.L$2 = site;
                    directionsManager$getTravelTimeToNearestHarborOnRoute$12.label = 1;
                    obj = iLocationManager.getLocation(directionsManager$getTravelTimeToNearestHarborOnRoute$12);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    directionsManager = this;
                } else {
                    if (i5 != 1) {
                        if (i5 == 2) {
                            ResultKt.throwOnFailure(obj);
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    site = (Site) directionsManager$getTravelTimeToNearestHarborOnRoute$12.L$2;
                    str = (String) directionsManager$getTravelTimeToNearestHarborOnRoute$12.L$1;
                    directionsManager = (DirectionsManager) directionsManager$getTravelTimeToNearestHarborOnRoute$12.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                String str2 = str;
                Site site2 = site;
                location = (Location) obj;
                if (location != null) {
                    return ManagerResult.Error.INSTANCE.noMessage();
                }
                IGeoLocatorManager iGeoLocatorManager = directionsManager.geoLocatorManager;
                double latitude = location.getLatitude();
                double longitude = location.getLongitude();
                directionsManager$getTravelTimeToNearestHarborOnRoute$12.L$0 = null;
                directionsManager$getTravelTimeToNearestHarborOnRoute$12.L$1 = null;
                directionsManager$getTravelTimeToNearestHarborOnRoute$12.L$2 = null;
                directionsManager$getTravelTimeToNearestHarborOnRoute$12.label = 2;
                obj = iGeoLocatorManager.getTravelTimeToNearestHarborOnRoute(latitude, longitude, str2, site2, directionsManager$getTravelTimeToNearestHarborOnRoute$12);
                return obj == coroutine_suspended ? coroutine_suspended : obj;
            }
        }
        directionsManager$getTravelTimeToNearestHarborOnRoute$1 = new DirectionsManager$getTravelTimeToNearestHarborOnRoute$1(this, continuation);
        DirectionsManager$getTravelTimeToNearestHarborOnRoute$1 directionsManager$getTravelTimeToNearestHarborOnRoute$122 = directionsManager$getTravelTimeToNearestHarborOnRoute$1;
        Object obj2 = directionsManager$getTravelTimeToNearestHarborOnRoute$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = directionsManager$getTravelTimeToNearestHarborOnRoute$122.label;
        if (i5 != 0) {
        }
        String str22 = str;
        Site site22 = site;
        location = (Location) obj2;
        if (location != null) {
        }
    }
}
