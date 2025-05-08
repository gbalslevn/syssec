package dk.molslinjen.domain.managers.route;

import dk.molslinjen.domain.model.booking.PassengerInfo;
import dk.molslinjen.domain.model.booking.RouteDirection;
import dk.molslinjen.domain.model.booking.TransportationCargoInfo;
import dk.molslinjen.domain.model.booking.product.Product;
import dk.molslinjen.domain.model.booking.product.TrailerProduct;
import dk.molslinjen.domain.model.config.LocalizedSiteConfiguration;
import dk.molslinjen.domain.model.config.Route;
import dk.molslinjen.domain.model.config.RouteDirectionDetails;
import dk.molslinjen.domain.model.config.RouteDirectionGroup;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0018\b\u0086\b\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0018\u0010\u0019J`\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eHÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001f\u001a\u00020\u001eHÖ\u0001¢\u0006\u0004\b\u001f\u0010 J\u001a\u0010#\u001a\u00020\"2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b#\u0010$R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010%\u001a\u0004\b&\u0010'R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010(\u001a\u0004\b)\u0010*R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010+\u001a\u0004\b,\u0010-R\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010.\u001a\u0004\b/\u00100R\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u00101\u001a\u0004\b2\u00103R\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u00104\u001a\u0004\b5\u00106R\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006¢\u0006\f\n\u0004\b\u0010\u00107\u001a\u0004\b8\u00109¨\u0006:"}, d2 = {"Ldk/molslinjen/domain/managers/route/RouteSelectedState;", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/RouteDirection;", "selectedRouteDirection", "Ldk/molslinjen/domain/model/config/RouteDirectionGroup;", "selectedRouteDirectionGroup", "Ldk/molslinjen/domain/model/booking/TransportationCargoInfo;", "transportationCargoInfo", "Ldk/molslinjen/domain/model/booking/product/TrailerProduct;", "selectedTrailer", "Lorg/threeten/bp/LocalDate;", "selectedStartDate", "Ldk/molslinjen/domain/model/booking/PassengerInfo;", "passengerInfo", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/product/Product;", "selectedTransportProducts", "<init>", "(Ldk/molslinjen/domain/model/booking/RouteDirection;Ldk/molslinjen/domain/model/config/RouteDirectionGroup;Ldk/molslinjen/domain/model/booking/TransportationCargoInfo;Ldk/molslinjen/domain/model/booking/product/TrailerProduct;Lorg/threeten/bp/LocalDate;Ldk/molslinjen/domain/model/booking/PassengerInfo;Ljava/util/List;)V", "Ldk/molslinjen/domain/model/config/LocalizedSiteConfiguration;", "configuration", BuildConfig.FLAVOR, "departureRouteId", "Ldk/molslinjen/domain/model/config/RouteDirectionDetails;", "getSelectedRouteDirectionDetails", "(Ldk/molslinjen/domain/model/config/LocalizedSiteConfiguration;Ljava/lang/String;)Ldk/molslinjen/domain/model/config/RouteDirectionDetails;", "copy", "(Ldk/molslinjen/domain/model/booking/RouteDirection;Ldk/molslinjen/domain/model/config/RouteDirectionGroup;Ldk/molslinjen/domain/model/booking/TransportationCargoInfo;Ldk/molslinjen/domain/model/booking/product/TrailerProduct;Lorg/threeten/bp/LocalDate;Ldk/molslinjen/domain/model/booking/PassengerInfo;Ljava/util/List;)Ldk/molslinjen/domain/managers/route/RouteSelectedState;", "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ldk/molslinjen/domain/model/booking/RouteDirection;", "getSelectedRouteDirection", "()Ldk/molslinjen/domain/model/booking/RouteDirection;", "Ldk/molslinjen/domain/model/config/RouteDirectionGroup;", "getSelectedRouteDirectionGroup", "()Ldk/molslinjen/domain/model/config/RouteDirectionGroup;", "Ldk/molslinjen/domain/model/booking/TransportationCargoInfo;", "getTransportationCargoInfo", "()Ldk/molslinjen/domain/model/booking/TransportationCargoInfo;", "Ldk/molslinjen/domain/model/booking/product/TrailerProduct;", "getSelectedTrailer", "()Ldk/molslinjen/domain/model/booking/product/TrailerProduct;", "Lorg/threeten/bp/LocalDate;", "getSelectedStartDate", "()Lorg/threeten/bp/LocalDate;", "Ldk/molslinjen/domain/model/booking/PassengerInfo;", "getPassengerInfo", "()Ldk/molslinjen/domain/model/booking/PassengerInfo;", "Ljava/util/List;", "getSelectedTransportProducts", "()Ljava/util/List;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class RouteSelectedState {
    private final PassengerInfo passengerInfo;
    private final RouteDirection selectedRouteDirection;
    private final RouteDirectionGroup selectedRouteDirectionGroup;
    private final LocalDate selectedStartDate;
    private final TrailerProduct selectedTrailer;
    private final List<Product> selectedTransportProducts;
    private final TransportationCargoInfo transportationCargoInfo;

    /* JADX WARN: Multi-variable type inference failed */
    public RouteSelectedState(RouteDirection selectedRouteDirection, RouteDirectionGroup selectedRouteDirectionGroup, TransportationCargoInfo transportationCargoInfo, TrailerProduct trailerProduct, LocalDate selectedStartDate, PassengerInfo passengerInfo, List<? extends Product> selectedTransportProducts) {
        Intrinsics.checkNotNullParameter(selectedRouteDirection, "selectedRouteDirection");
        Intrinsics.checkNotNullParameter(selectedRouteDirectionGroup, "selectedRouteDirectionGroup");
        Intrinsics.checkNotNullParameter(selectedStartDate, "selectedStartDate");
        Intrinsics.checkNotNullParameter(passengerInfo, "passengerInfo");
        Intrinsics.checkNotNullParameter(selectedTransportProducts, "selectedTransportProducts");
        this.selectedRouteDirection = selectedRouteDirection;
        this.selectedRouteDirectionGroup = selectedRouteDirectionGroup;
        this.transportationCargoInfo = transportationCargoInfo;
        this.selectedTrailer = trailerProduct;
        this.selectedStartDate = selectedStartDate;
        this.passengerInfo = passengerInfo;
        this.selectedTransportProducts = selectedTransportProducts;
    }

    public static /* synthetic */ RouteSelectedState copy$default(RouteSelectedState routeSelectedState, RouteDirection routeDirection, RouteDirectionGroup routeDirectionGroup, TransportationCargoInfo transportationCargoInfo, TrailerProduct trailerProduct, LocalDate localDate, PassengerInfo passengerInfo, List list, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            routeDirection = routeSelectedState.selectedRouteDirection;
        }
        if ((i5 & 2) != 0) {
            routeDirectionGroup = routeSelectedState.selectedRouteDirectionGroup;
        }
        RouteDirectionGroup routeDirectionGroup2 = routeDirectionGroup;
        if ((i5 & 4) != 0) {
            transportationCargoInfo = routeSelectedState.transportationCargoInfo;
        }
        TransportationCargoInfo transportationCargoInfo2 = transportationCargoInfo;
        if ((i5 & 8) != 0) {
            trailerProduct = routeSelectedState.selectedTrailer;
        }
        TrailerProduct trailerProduct2 = trailerProduct;
        if ((i5 & 16) != 0) {
            localDate = routeSelectedState.selectedStartDate;
        }
        LocalDate localDate2 = localDate;
        if ((i5 & 32) != 0) {
            passengerInfo = routeSelectedState.passengerInfo;
        }
        PassengerInfo passengerInfo2 = passengerInfo;
        if ((i5 & 64) != 0) {
            list = routeSelectedState.selectedTransportProducts;
        }
        return routeSelectedState.copy(routeDirection, routeDirectionGroup2, transportationCargoInfo2, trailerProduct2, localDate2, passengerInfo2, list);
    }

    public final RouteSelectedState copy(RouteDirection selectedRouteDirection, RouteDirectionGroup selectedRouteDirectionGroup, TransportationCargoInfo transportationCargoInfo, TrailerProduct selectedTrailer, LocalDate selectedStartDate, PassengerInfo passengerInfo, List<? extends Product> selectedTransportProducts) {
        Intrinsics.checkNotNullParameter(selectedRouteDirection, "selectedRouteDirection");
        Intrinsics.checkNotNullParameter(selectedRouteDirectionGroup, "selectedRouteDirectionGroup");
        Intrinsics.checkNotNullParameter(selectedStartDate, "selectedStartDate");
        Intrinsics.checkNotNullParameter(passengerInfo, "passengerInfo");
        Intrinsics.checkNotNullParameter(selectedTransportProducts, "selectedTransportProducts");
        return new RouteSelectedState(selectedRouteDirection, selectedRouteDirectionGroup, transportationCargoInfo, selectedTrailer, selectedStartDate, passengerInfo, selectedTransportProducts);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RouteSelectedState)) {
            return false;
        }
        RouteSelectedState routeSelectedState = (RouteSelectedState) other;
        return this.selectedRouteDirection == routeSelectedState.selectedRouteDirection && Intrinsics.areEqual(this.selectedRouteDirectionGroup, routeSelectedState.selectedRouteDirectionGroup) && Intrinsics.areEqual(this.transportationCargoInfo, routeSelectedState.transportationCargoInfo) && Intrinsics.areEqual(this.selectedTrailer, routeSelectedState.selectedTrailer) && Intrinsics.areEqual(this.selectedStartDate, routeSelectedState.selectedStartDate) && Intrinsics.areEqual(this.passengerInfo, routeSelectedState.passengerInfo) && Intrinsics.areEqual(this.selectedTransportProducts, routeSelectedState.selectedTransportProducts);
    }

    public final PassengerInfo getPassengerInfo() {
        return this.passengerInfo;
    }

    public final RouteDirection getSelectedRouteDirection() {
        return this.selectedRouteDirection;
    }

    public final RouteDirectionDetails getSelectedRouteDirectionDetails(LocalizedSiteConfiguration configuration, String departureRouteId) {
        Object obj;
        Object obj2;
        RouteDirectionGroup routeDirectionGroup;
        List<RouteDirectionDetails> routes;
        List<Route> routes2;
        Intrinsics.checkNotNullParameter(departureRouteId, "departureRouteId");
        Iterator<T> it = this.selectedRouteDirectionGroup.getRoutes().iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                obj2 = null;
                break;
            }
            obj2 = it.next();
            if (Intrinsics.areEqual(((RouteDirectionDetails) obj2).getId(), departureRouteId)) {
                break;
            }
        }
        RouteDirectionDetails routeDirectionDetails = (RouteDirectionDetails) obj2;
        if (routeDirectionDetails != null) {
            return routeDirectionDetails;
        }
        if (configuration != null && (routes2 = configuration.getRoutes()) != null) {
            Iterator<T> it2 = routes2.iterator();
            while (it2.hasNext()) {
                routeDirectionGroup = ((Route) it2.next()).getRouteDirection(departureRouteId);
                if (routeDirectionGroup != null) {
                    break;
                }
            }
        }
        routeDirectionGroup = null;
        if (routeDirectionGroup == null || (routes = routeDirectionGroup.getRoutes()) == null) {
            return null;
        }
        Iterator<T> it3 = routes.iterator();
        while (true) {
            if (!it3.hasNext()) {
                break;
            }
            Object next = it3.next();
            if (Intrinsics.areEqual(((RouteDirectionDetails) next).getId(), departureRouteId)) {
                obj = next;
                break;
            }
        }
        return (RouteDirectionDetails) obj;
    }

    public final RouteDirectionGroup getSelectedRouteDirectionGroup() {
        return this.selectedRouteDirectionGroup;
    }

    public final LocalDate getSelectedStartDate() {
        return this.selectedStartDate;
    }

    public final TrailerProduct getSelectedTrailer() {
        return this.selectedTrailer;
    }

    public final List<Product> getSelectedTransportProducts() {
        return this.selectedTransportProducts;
    }

    public final TransportationCargoInfo getTransportationCargoInfo() {
        return this.transportationCargoInfo;
    }

    public int hashCode() {
        int hashCode = ((this.selectedRouteDirection.hashCode() * 31) + this.selectedRouteDirectionGroup.hashCode()) * 31;
        TransportationCargoInfo transportationCargoInfo = this.transportationCargoInfo;
        int hashCode2 = (hashCode + (transportationCargoInfo == null ? 0 : transportationCargoInfo.hashCode())) * 31;
        TrailerProduct trailerProduct = this.selectedTrailer;
        return ((((((hashCode2 + (trailerProduct != null ? trailerProduct.hashCode() : 0)) * 31) + this.selectedStartDate.hashCode()) * 31) + this.passengerInfo.hashCode()) * 31) + this.selectedTransportProducts.hashCode();
    }

    public String toString() {
        return "RouteSelectedState(selectedRouteDirection=" + this.selectedRouteDirection + ", selectedRouteDirectionGroup=" + this.selectedRouteDirectionGroup + ", transportationCargoInfo=" + this.transportationCargoInfo + ", selectedTrailer=" + this.selectedTrailer + ", selectedStartDate=" + this.selectedStartDate + ", passengerInfo=" + this.passengerInfo + ", selectedTransportProducts=" + this.selectedTransportProducts + ")";
    }

    public /* synthetic */ RouteSelectedState(RouteDirection routeDirection, RouteDirectionGroup routeDirectionGroup, TransportationCargoInfo transportationCargoInfo, TrailerProduct trailerProduct, LocalDate localDate, PassengerInfo passengerInfo, List list, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(routeDirection, routeDirectionGroup, (i5 & 4) != 0 ? null : transportationCargoInfo, (i5 & 8) != 0 ? null : trailerProduct, (i5 & 16) != 0 ? LocalDate.now() : localDate, passengerInfo, (i5 & 64) != 0 ? CollectionsKt.emptyList() : list);
    }
}
