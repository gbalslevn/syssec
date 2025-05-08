package dk.molslinjen.domain.managers.ticket.helper;

import dk.molslinjen.api.services.booking.response.booking.BookingHeaderResponseDTO;
import dk.molslinjen.api.services.booking.response.booking.FerryResponseDTO;
import dk.molslinjen.core.log.Logger;
import dk.molslinjen.domain.managers.configuration.IConfigurationManager;
import dk.molslinjen.domain.model.booking.BookingHeader;
import dk.molslinjen.domain.model.booking.Ferry;
import dk.molslinjen.domain.model.booking.RouteType;
import dk.molslinjen.domain.model.config.Configuration;
import dk.molslinjen.domain.model.config.LocalizedSiteConfiguration;
import dk.molslinjen.domain.model.config.Route;
import dk.molslinjen.domain.model.config.RouteDirectionDetails;
import dk.molslinjen.domain.model.config.RouteDirectionGroup;
import dk.molslinjen.domain.model.config.SimpleFerry;
import dk.molslinjen.domain.model.config.SiteConfiguration;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0013B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J,\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bH\u0096@¢\u0006\u0002\u0010\u000eJ0\u0010\u000f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Ldk/molslinjen/domain/managers/ticket/helper/BookingHeaderMapper;", "Ldk/molslinjen/domain/managers/ticket/helper/IBookingHeaderMapper;", "configurationManager", "Ldk/molslinjen/domain/managers/configuration/IConfigurationManager;", "<init>", "(Ldk/molslinjen/domain/managers/configuration/IConfigurationManager;)V", "mapBookingHeader", "Ldk/molslinjen/domain/model/booking/BookingHeader;", "booking", "Ldk/molslinjen/api/services/booking/response/booking/BookingHeaderResponseDTO;", "siteEntryByRouteIdCache", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "Ldk/molslinjen/domain/managers/ticket/helper/BookingHeaderMapper$SiteCacheEntry;", "(Ldk/molslinjen/api/services/booking/response/booking/BookingHeaderResponseDTO;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSiteEntryCached", "routeId", "configuration", "Ldk/molslinjen/domain/model/config/Configuration;", "SiteCacheEntry", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class BookingHeaderMapper implements IBookingHeaderMapper {
    private final IConfigurationManager configurationManager;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Ldk/molslinjen/domain/managers/ticket/helper/BookingHeaderMapper$SiteCacheEntry;", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/config/LocalizedSiteConfiguration;", "configuration", "Ldk/molslinjen/domain/model/config/Route;", "route", "<init>", "(Ldk/molslinjen/domain/model/config/LocalizedSiteConfiguration;Ldk/molslinjen/domain/model/config/Route;)V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ldk/molslinjen/domain/model/config/LocalizedSiteConfiguration;", "getConfiguration", "()Ldk/molslinjen/domain/model/config/LocalizedSiteConfiguration;", "Ldk/molslinjen/domain/model/config/Route;", "getRoute", "()Ldk/molslinjen/domain/model/config/Route;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class SiteCacheEntry {
        private final LocalizedSiteConfiguration configuration;
        private final Route route;

        public SiteCacheEntry(LocalizedSiteConfiguration configuration, Route route) {
            Intrinsics.checkNotNullParameter(configuration, "configuration");
            Intrinsics.checkNotNullParameter(route, "route");
            this.configuration = configuration;
            this.route = route;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SiteCacheEntry)) {
                return false;
            }
            SiteCacheEntry siteCacheEntry = (SiteCacheEntry) other;
            return Intrinsics.areEqual(this.configuration, siteCacheEntry.configuration) && Intrinsics.areEqual(this.route, siteCacheEntry.route);
        }

        public final LocalizedSiteConfiguration getConfiguration() {
            return this.configuration;
        }

        public final Route getRoute() {
            return this.route;
        }

        public int hashCode() {
            return (this.configuration.hashCode() * 31) + this.route.hashCode();
        }

        public String toString() {
            return "SiteCacheEntry(configuration=" + this.configuration + ", route=" + this.route + ")";
        }
    }

    public BookingHeaderMapper(IConfigurationManager configurationManager) {
        Intrinsics.checkNotNullParameter(configurationManager, "configurationManager");
        this.configurationManager = configurationManager;
    }

    private final SiteCacheEntry getSiteEntryCached(String routeId, Configuration configuration, Map<String, SiteCacheEntry> siteEntryByRouteIdCache) {
        Object obj;
        if (configuration == null) {
            return null;
        }
        Iterator<SiteConfiguration> it = configuration.getSiteConfigurations().values().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            LocalizedSiteConfiguration activeConfiguration = it.next().getActiveConfiguration();
            Iterator<T> it2 = activeConfiguration.getRoutes().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it2.next();
                Route route = (Route) obj;
                List<RouteDirectionDetails> routes = route.getOutRoute().getRoutes();
                if (!(routes instanceof Collection) || !routes.isEmpty()) {
                    Iterator<T> it3 = routes.iterator();
                    while (it3.hasNext()) {
                        if (Intrinsics.areEqual(((RouteDirectionDetails) it3.next()).getId(), routeId)) {
                            break;
                        }
                    }
                }
                List<RouteDirectionDetails> routes2 = route.getReturnRoute().getRoutes();
                if (!(routes2 instanceof Collection) || !routes2.isEmpty()) {
                    Iterator<T> it4 = routes2.iterator();
                    while (it4.hasNext()) {
                        if (Intrinsics.areEqual(((RouteDirectionDetails) it4.next()).getId(), routeId)) {
                            break;
                        }
                    }
                }
            }
            Route route2 = (Route) obj;
            if (route2 != null) {
                siteEntryByRouteIdCache.put(routeId, new SiteCacheEntry(activeConfiguration, route2));
                break;
            }
        }
        return siteEntryByRouteIdCache.get(routeId);
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00c0, code lost:
    
        if (r5 != null) goto L62;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00bd A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    @Override // dk.molslinjen.domain.managers.ticket.helper.IBookingHeaderMapper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mapBookingHeader(BookingHeaderResponseDTO bookingHeaderResponseDTO, Map<String, SiteCacheEntry> map, Continuation<? super BookingHeader> continuation) {
        BookingHeaderMapper$mapBookingHeader$1 bookingHeaderMapper$mapBookingHeader$1;
        int i5;
        BookingHeaderResponseDTO bookingHeaderResponseDTO2;
        BookingHeaderMapper bookingHeaderMapper;
        Map<String, SiteCacheEntry> map2;
        SiteCacheEntry siteEntryCached;
        String str;
        RouteDirectionDetails routeDirectionDetails;
        Route route;
        RouteDirectionGroup returnRoute;
        List<RouteDirectionDetails> routes;
        Object obj;
        Route route2;
        RouteDirectionGroup outRoute;
        List<RouteDirectionDetails> routes2;
        Iterator<T> it;
        Object obj2;
        LocalizedSiteConfiguration configuration;
        SimpleFerry ferry;
        if (continuation instanceof BookingHeaderMapper$mapBookingHeader$1) {
            bookingHeaderMapper$mapBookingHeader$1 = (BookingHeaderMapper$mapBookingHeader$1) continuation;
            int i6 = bookingHeaderMapper$mapBookingHeader$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                bookingHeaderMapper$mapBookingHeader$1.label = i6 - Integer.MIN_VALUE;
                Object obj3 = bookingHeaderMapper$mapBookingHeader$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = bookingHeaderMapper$mapBookingHeader$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj3);
                    IConfigurationManager iConfigurationManager = this.configurationManager;
                    bookingHeaderMapper$mapBookingHeader$1.L$0 = this;
                    bookingHeaderResponseDTO2 = bookingHeaderResponseDTO;
                    bookingHeaderMapper$mapBookingHeader$1.L$1 = bookingHeaderResponseDTO2;
                    bookingHeaderMapper$mapBookingHeader$1.L$2 = map;
                    bookingHeaderMapper$mapBookingHeader$1.label = 1;
                    obj3 = iConfigurationManager.getConfiguration(bookingHeaderMapper$mapBookingHeader$1);
                    if (obj3 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    bookingHeaderMapper = this;
                    map2 = map;
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    map2 = (Map) bookingHeaderMapper$mapBookingHeader$1.L$2;
                    bookingHeaderResponseDTO2 = (BookingHeaderResponseDTO) bookingHeaderMapper$mapBookingHeader$1.L$1;
                    bookingHeaderMapper = (BookingHeaderMapper) bookingHeaderMapper$mapBookingHeader$1.L$0;
                    ResultKt.throwOnFailure(obj3);
                }
                siteEntryCached = bookingHeaderMapper.getSiteEntryCached(bookingHeaderResponseDTO2.getRouteId(), (Configuration) obj3, map2);
                if (siteEntryCached != null && (configuration = siteEntryCached.getConfiguration()) != null) {
                    FerryResponseDTO ferry2 = bookingHeaderResponseDTO2.getFerry();
                    ferry = configuration.getFerry(ferry2 == null ? ferry2.getFerryId() : null);
                    if (ferry != null) {
                        str = ferry.getName();
                        if (siteEntryCached != null && (route2 = siteEntryCached.getRoute()) != null && (outRoute = route2.getOutRoute()) != null && (routes2 = outRoute.getRoutes()) != null) {
                            it = routes2.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    obj2 = null;
                                    break;
                                }
                                obj2 = it.next();
                                if (Intrinsics.areEqual(((RouteDirectionDetails) obj2).getId(), bookingHeaderResponseDTO2.getRouteId())) {
                                    break;
                                }
                            }
                            routeDirectionDetails = (RouteDirectionDetails) obj2;
                        }
                        if (siteEntryCached != null || (route = siteEntryCached.getRoute()) == null || (returnRoute = route.getReturnRoute()) == null || (routes = returnRoute.getRoutes()) == null) {
                            routeDirectionDetails = null;
                        } else {
                            Iterator<T> it2 = routes.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    obj = null;
                                    break;
                                }
                                obj = it2.next();
                                if (Intrinsics.areEqual(((RouteDirectionDetails) obj).getId(), bookingHeaderResponseDTO2.getRouteId())) {
                                    break;
                                }
                            }
                            routeDirectionDetails = (RouteDirectionDetails) obj;
                        }
                        if (siteEntryCached == null) {
                            Logger.log$default(Logger.INSTANCE, "No site configuration or route found for routeId: " + bookingHeaderResponseDTO2.getRouteId() + ", while mapping booking header for reservationId " + bookingHeaderResponseDTO2.getReservationId(), null, 0, 6, null);
                        }
                        if (routeDirectionDetails == null) {
                            Logger.log$default(Logger.INSTANCE, "No routeDirectionDetails found for routeId: " + bookingHeaderResponseDTO2.getRouteId() + ", while mapping booking header", null, 0, 6, null);
                        }
                        RouteType routeType = routeDirectionDetails != null ? routeDirectionDetails.getRouteType() : null;
                        FerryResponseDTO ferry3 = bookingHeaderResponseDTO2.getFerry();
                        return new BookingHeader(bookingHeaderResponseDTO2, routeType, ferry3 != null ? new Ferry(FerryResponseDTO.copy$default(ferry3, null, null, null, null, null, str, null, 95, null)) : null);
                    }
                }
                str = null;
                if (siteEntryCached != null) {
                    it = routes2.iterator();
                    while (true) {
                        if (it.hasNext()) {
                        }
                    }
                    routeDirectionDetails = (RouteDirectionDetails) obj2;
                }
                if (siteEntryCached != null) {
                }
                routeDirectionDetails = null;
                if (siteEntryCached == null) {
                }
                if (routeDirectionDetails == null) {
                }
                if (routeDirectionDetails != null) {
                }
                FerryResponseDTO ferry32 = bookingHeaderResponseDTO2.getFerry();
                return new BookingHeader(bookingHeaderResponseDTO2, routeType, ferry32 != null ? new Ferry(FerryResponseDTO.copy$default(ferry32, null, null, null, null, null, str, null, 95, null)) : null);
            }
        }
        bookingHeaderMapper$mapBookingHeader$1 = new BookingHeaderMapper$mapBookingHeader$1(this, continuation);
        Object obj32 = bookingHeaderMapper$mapBookingHeader$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = bookingHeaderMapper$mapBookingHeader$1.label;
        if (i5 != 0) {
        }
        siteEntryCached = bookingHeaderMapper.getSiteEntryCached(bookingHeaderResponseDTO2.getRouteId(), (Configuration) obj32, map2);
        if (siteEntryCached != null) {
            FerryResponseDTO ferry22 = bookingHeaderResponseDTO2.getFerry();
            ferry = configuration.getFerry(ferry22 == null ? ferry22.getFerryId() : null);
            if (ferry != null) {
            }
        }
        str = null;
        if (siteEntryCached != null) {
        }
        if (siteEntryCached != null) {
        }
        routeDirectionDetails = null;
        if (siteEntryCached == null) {
        }
        if (routeDirectionDetails == null) {
        }
        if (routeDirectionDetails != null) {
        }
        FerryResponseDTO ferry322 = bookingHeaderResponseDTO2.getFerry();
        return new BookingHeader(bookingHeaderResponseDTO2, routeType, ferry322 != null ? new Ferry(FerryResponseDTO.copy$default(ferry322, null, null, null, null, null, str, null, 95, null)) : null);
    }
}
