package dk.molslinjen.ui.views.shared.routeSelector.helpers;

import android.location.Location;
import dk.molslinjen.core.location.ILocationManager;
import dk.molslinjen.core.log.CriticalLog;
import dk.molslinjen.core.log.Logger;
import dk.molslinjen.domain.managers.configuration.IConfigurationManager;
import dk.molslinjen.domain.model.booking.RouteDirection;
import dk.molslinjen.domain.model.config.Configuration;
import dk.molslinjen.domain.model.config.Harbor;
import dk.molslinjen.domain.model.config.Route;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.domain.model.config.SiteConfiguration;
import dk.molslinjen.extensions.IntExtensionsKt;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J(\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Ldk/molslinjen/ui/views/shared/routeSelector/helpers/RouteLocationHelper;", "Ldk/molslinjen/ui/views/shared/routeSelector/helpers/IRouteLocationHelper;", "locationManager", "Ldk/molslinjen/core/location/ILocationManager;", "configurationManager", "Ldk/molslinjen/domain/managers/configuration/IConfigurationManager;", "<init>", "(Ldk/molslinjen/core/location/ILocationManager;Ldk/molslinjen/domain/managers/configuration/IConfigurationManager;)V", "getNearestRouteDirection", "Ldk/molslinjen/domain/model/booking/RouteDirection;", "route", "Ldk/molslinjen/domain/model/config/Route;", "site", "Ldk/molslinjen/domain/model/config/Site;", "maxTimeWaitingInSeconds", BuildConfig.FLAVOR, "(Ldk/molslinjen/domain/model/config/Route;Ldk/molslinjen/domain/model/config/Site;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RouteLocationHelper implements IRouteLocationHelper {
    private final IConfigurationManager configurationManager;
    private final ILocationManager locationManager;

    public RouteLocationHelper(ILocationManager locationManager, IConfigurationManager configurationManager) {
        Intrinsics.checkNotNullParameter(locationManager, "locationManager");
        Intrinsics.checkNotNullParameter(configurationManager, "configurationManager");
        this.locationManager = locationManager;
        this.configurationManager = configurationManager;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x00a4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0088 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0029  */
    @Override // dk.molslinjen.ui.views.shared.routeSelector.helpers.IRouteLocationHelper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getNearestRouteDirection(Route route, Site site, int i5, Continuation<? super RouteDirection> continuation) {
        RouteLocationHelper$getNearestRouteDirection$1 routeLocationHelper$getNearestRouteDirection$1;
        int i6;
        Route route2;
        Site site2;
        RouteLocationHelper routeLocationHelper;
        Location location;
        Location location2;
        Route route3;
        Site site3;
        Configuration configuration;
        Object obj;
        Object obj2;
        try {
            if (continuation instanceof RouteLocationHelper$getNearestRouteDirection$1) {
                routeLocationHelper$getNearestRouteDirection$1 = (RouteLocationHelper$getNearestRouteDirection$1) continuation;
                int i7 = routeLocationHelper$getNearestRouteDirection$1.label;
                if ((i7 & Integer.MIN_VALUE) != 0) {
                    routeLocationHelper$getNearestRouteDirection$1.label = i7 - Integer.MIN_VALUE;
                    Object obj3 = routeLocationHelper$getNearestRouteDirection$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i6 = routeLocationHelper$getNearestRouteDirection$1.label;
                    if (i6 != 0) {
                        ResultKt.throwOnFailure(obj3);
                        if (!this.locationManager.isAuthorized()) {
                            return null;
                        }
                        long secondsAsMilliseconds = IntExtensionsKt.secondsAsMilliseconds(i5);
                        RouteLocationHelper$getNearestRouteDirection$currentLocation$1 routeLocationHelper$getNearestRouteDirection$currentLocation$1 = new RouteLocationHelper$getNearestRouteDirection$currentLocation$1(this, null);
                        routeLocationHelper$getNearestRouteDirection$1.L$0 = this;
                        route2 = route;
                        routeLocationHelper$getNearestRouteDirection$1.L$1 = route2;
                        site2 = site;
                        routeLocationHelper$getNearestRouteDirection$1.L$2 = site2;
                        routeLocationHelper$getNearestRouteDirection$1.label = 1;
                        obj3 = TimeoutKt.withTimeout(secondsAsMilliseconds, routeLocationHelper$getNearestRouteDirection$currentLocation$1, routeLocationHelper$getNearestRouteDirection$1);
                        if (obj3 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        routeLocationHelper = this;
                    } else {
                        if (i6 != 1) {
                            if (i6 != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            location2 = (Location) routeLocationHelper$getNearestRouteDirection$1.L$3;
                            site3 = (Site) routeLocationHelper$getNearestRouteDirection$1.L$2;
                            route3 = (Route) routeLocationHelper$getNearestRouteDirection$1.L$1;
                            ResultKt.throwOnFailure(obj3);
                            configuration = (Configuration) obj3;
                            if (configuration != null) {
                                return null;
                            }
                            SiteConfiguration siteConfiguration = configuration.getSiteConfigurations().get(site3);
                            if (siteConfiguration == null) {
                                Logger.INSTANCE.logCritical(new CriticalLog("No configuration found for site " + site3 + " for RouteLocationHelper, Available sites: " + CollectionsKt.joinToString$default(configuration.getSiteConfigurations().keySet(), ", ", null, null, 0, null, null, 62, null)));
                                return null;
                            }
                            List<Harbor> harbors = siteConfiguration.getActiveConfiguration().getHarbors();
                            Iterator<T> it = harbors.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    obj = null;
                                    break;
                                }
                                obj = it.next();
                                if (Intrinsics.areEqual(((Harbor) obj).getId(), route3.getOutRoute().getDepartureHarbor().getId())) {
                                    break;
                                }
                            }
                            Harbor harbor = (Harbor) obj;
                            if (harbor == null) {
                                return null;
                            }
                            Iterator<T> it2 = harbors.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    obj2 = null;
                                    break;
                                }
                                obj2 = it2.next();
                                if (Intrinsics.areEqual(((Harbor) obj2).getId(), route3.getOutRoute().getArrivalHarbor().getId())) {
                                    break;
                                }
                            }
                            Harbor harbor2 = (Harbor) obj2;
                            if (harbor2 == null) {
                                return null;
                            }
                            return harbor.location().distanceTo(location2) < harbor2.location().distanceTo(location2) ? RouteDirection.Outbound : RouteDirection.Return;
                        }
                        Site site4 = (Site) routeLocationHelper$getNearestRouteDirection$1.L$2;
                        Route route4 = (Route) routeLocationHelper$getNearestRouteDirection$1.L$1;
                        routeLocationHelper = (RouteLocationHelper) routeLocationHelper$getNearestRouteDirection$1.L$0;
                        ResultKt.throwOnFailure(obj3);
                        site2 = site4;
                        route2 = route4;
                    }
                    location = (Location) obj3;
                    if (location != null) {
                        return null;
                    }
                    IConfigurationManager iConfigurationManager = routeLocationHelper.configurationManager;
                    routeLocationHelper$getNearestRouteDirection$1.L$0 = routeLocationHelper;
                    routeLocationHelper$getNearestRouteDirection$1.L$1 = route2;
                    routeLocationHelper$getNearestRouteDirection$1.L$2 = site2;
                    routeLocationHelper$getNearestRouteDirection$1.L$3 = location;
                    routeLocationHelper$getNearestRouteDirection$1.label = 2;
                    Object configuration2 = iConfigurationManager.getConfiguration(routeLocationHelper$getNearestRouteDirection$1);
                    if (configuration2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    location2 = location;
                    obj3 = configuration2;
                    route3 = route2;
                    site3 = site2;
                    configuration = (Configuration) obj3;
                    if (configuration != null) {
                    }
                }
            }
            if (i6 != 0) {
            }
            location = (Location) obj3;
            if (location != null) {
            }
        } catch (TimeoutCancellationException unused) {
            return null;
        }
        routeLocationHelper$getNearestRouteDirection$1 = new RouteLocationHelper$getNearestRouteDirection$1(this, continuation);
        Object obj32 = routeLocationHelper$getNearestRouteDirection$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i6 = routeLocationHelper$getNearestRouteDirection$1.label;
    }
}
