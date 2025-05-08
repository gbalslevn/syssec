package dk.molslinjen.domain.managers.saleOnBoard;

import dk.molslinjen.domain.model.booking.RouteDirection;
import dk.molslinjen.domain.model.config.LocalizedSiteConfiguration;
import dk.molslinjen.domain.model.config.Route;
import dk.molslinjen.domain.model.config.RouteDirectionGroup;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.domain.model.config.Transportation;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0018\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011JV\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000eHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010!\u001a\u0004\b\"\u0010#R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010$\u001a\u0004\b%\u0010&R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010'\u001a\u0004\b(\u0010)R\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010*\u001a\u0004\b+\u0010,R\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010-\u001a\u0004\b.\u0010/R\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u00100\u001a\u0004\b1\u00102¨\u00063"}, d2 = {"Ldk/molslinjen/domain/managers/saleOnBoard/SaleOnBoardRouteState;", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/config/LocalizedSiteConfiguration;", "configuration", "Ldk/molslinjen/domain/model/config/Route;", "selectedRoute", "Ldk/molslinjen/domain/model/booking/RouteDirection;", "selectedRouteDirection", "Ldk/molslinjen/domain/model/config/RouteDirectionGroup;", "selectedRouteDirectionGroup", "Lorg/threeten/bp/LocalDate;", "selectedStartDate", "Ldk/molslinjen/domain/model/config/Transportation;", "transportation", "Ldk/molslinjen/domain/model/config/Site;", "site", "<init>", "(Ldk/molslinjen/domain/model/config/LocalizedSiteConfiguration;Ldk/molslinjen/domain/model/config/Route;Ldk/molslinjen/domain/model/booking/RouteDirection;Ldk/molslinjen/domain/model/config/RouteDirectionGroup;Lorg/threeten/bp/LocalDate;Ldk/molslinjen/domain/model/config/Transportation;Ldk/molslinjen/domain/model/config/Site;)V", "copy", "(Ldk/molslinjen/domain/model/config/LocalizedSiteConfiguration;Ldk/molslinjen/domain/model/config/Route;Ldk/molslinjen/domain/model/booking/RouteDirection;Ldk/molslinjen/domain/model/config/RouteDirectionGroup;Lorg/threeten/bp/LocalDate;Ldk/molslinjen/domain/model/config/Transportation;Ldk/molslinjen/domain/model/config/Site;)Ldk/molslinjen/domain/managers/saleOnBoard/SaleOnBoardRouteState;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ldk/molslinjen/domain/model/config/LocalizedSiteConfiguration;", "getConfiguration", "()Ldk/molslinjen/domain/model/config/LocalizedSiteConfiguration;", "Ldk/molslinjen/domain/model/config/Route;", "getSelectedRoute", "()Ldk/molslinjen/domain/model/config/Route;", "Ldk/molslinjen/domain/model/booking/RouteDirection;", "getSelectedRouteDirection", "()Ldk/molslinjen/domain/model/booking/RouteDirection;", "Ldk/molslinjen/domain/model/config/RouteDirectionGroup;", "getSelectedRouteDirectionGroup", "()Ldk/molslinjen/domain/model/config/RouteDirectionGroup;", "Lorg/threeten/bp/LocalDate;", "getSelectedStartDate", "()Lorg/threeten/bp/LocalDate;", "Ldk/molslinjen/domain/model/config/Transportation;", "getTransportation", "()Ldk/molslinjen/domain/model/config/Transportation;", "Ldk/molslinjen/domain/model/config/Site;", "getSite", "()Ldk/molslinjen/domain/model/config/Site;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class SaleOnBoardRouteState {
    private final LocalizedSiteConfiguration configuration;
    private final Route selectedRoute;
    private final RouteDirection selectedRouteDirection;
    private final RouteDirectionGroup selectedRouteDirectionGroup;
    private final LocalDate selectedStartDate;
    private final Site site;
    private final Transportation transportation;

    public SaleOnBoardRouteState(LocalizedSiteConfiguration configuration, Route selectedRoute, RouteDirection selectedRouteDirection, RouteDirectionGroup selectedRouteDirectionGroup, LocalDate selectedStartDate, Transportation transportation, Site site) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(selectedRoute, "selectedRoute");
        Intrinsics.checkNotNullParameter(selectedRouteDirection, "selectedRouteDirection");
        Intrinsics.checkNotNullParameter(selectedRouteDirectionGroup, "selectedRouteDirectionGroup");
        Intrinsics.checkNotNullParameter(selectedStartDate, "selectedStartDate");
        Intrinsics.checkNotNullParameter(transportation, "transportation");
        Intrinsics.checkNotNullParameter(site, "site");
        this.configuration = configuration;
        this.selectedRoute = selectedRoute;
        this.selectedRouteDirection = selectedRouteDirection;
        this.selectedRouteDirectionGroup = selectedRouteDirectionGroup;
        this.selectedStartDate = selectedStartDate;
        this.transportation = transportation;
        this.site = site;
    }

    public static /* synthetic */ SaleOnBoardRouteState copy$default(SaleOnBoardRouteState saleOnBoardRouteState, LocalizedSiteConfiguration localizedSiteConfiguration, Route route, RouteDirection routeDirection, RouteDirectionGroup routeDirectionGroup, LocalDate localDate, Transportation transportation, Site site, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            localizedSiteConfiguration = saleOnBoardRouteState.configuration;
        }
        if ((i5 & 2) != 0) {
            route = saleOnBoardRouteState.selectedRoute;
        }
        Route route2 = route;
        if ((i5 & 4) != 0) {
            routeDirection = saleOnBoardRouteState.selectedRouteDirection;
        }
        RouteDirection routeDirection2 = routeDirection;
        if ((i5 & 8) != 0) {
            routeDirectionGroup = saleOnBoardRouteState.selectedRouteDirectionGroup;
        }
        RouteDirectionGroup routeDirectionGroup2 = routeDirectionGroup;
        if ((i5 & 16) != 0) {
            localDate = saleOnBoardRouteState.selectedStartDate;
        }
        LocalDate localDate2 = localDate;
        if ((i5 & 32) != 0) {
            transportation = saleOnBoardRouteState.transportation;
        }
        Transportation transportation2 = transportation;
        if ((i5 & 64) != 0) {
            site = saleOnBoardRouteState.site;
        }
        return saleOnBoardRouteState.copy(localizedSiteConfiguration, route2, routeDirection2, routeDirectionGroup2, localDate2, transportation2, site);
    }

    public final SaleOnBoardRouteState copy(LocalizedSiteConfiguration configuration, Route selectedRoute, RouteDirection selectedRouteDirection, RouteDirectionGroup selectedRouteDirectionGroup, LocalDate selectedStartDate, Transportation transportation, Site site) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(selectedRoute, "selectedRoute");
        Intrinsics.checkNotNullParameter(selectedRouteDirection, "selectedRouteDirection");
        Intrinsics.checkNotNullParameter(selectedRouteDirectionGroup, "selectedRouteDirectionGroup");
        Intrinsics.checkNotNullParameter(selectedStartDate, "selectedStartDate");
        Intrinsics.checkNotNullParameter(transportation, "transportation");
        Intrinsics.checkNotNullParameter(site, "site");
        return new SaleOnBoardRouteState(configuration, selectedRoute, selectedRouteDirection, selectedRouteDirectionGroup, selectedStartDate, transportation, site);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SaleOnBoardRouteState)) {
            return false;
        }
        SaleOnBoardRouteState saleOnBoardRouteState = (SaleOnBoardRouteState) other;
        return Intrinsics.areEqual(this.configuration, saleOnBoardRouteState.configuration) && Intrinsics.areEqual(this.selectedRoute, saleOnBoardRouteState.selectedRoute) && this.selectedRouteDirection == saleOnBoardRouteState.selectedRouteDirection && Intrinsics.areEqual(this.selectedRouteDirectionGroup, saleOnBoardRouteState.selectedRouteDirectionGroup) && Intrinsics.areEqual(this.selectedStartDate, saleOnBoardRouteState.selectedStartDate) && Intrinsics.areEqual(this.transportation, saleOnBoardRouteState.transportation) && this.site == saleOnBoardRouteState.site;
    }

    public final LocalizedSiteConfiguration getConfiguration() {
        return this.configuration;
    }

    public final Route getSelectedRoute() {
        return this.selectedRoute;
    }

    public final RouteDirection getSelectedRouteDirection() {
        return this.selectedRouteDirection;
    }

    public final RouteDirectionGroup getSelectedRouteDirectionGroup() {
        return this.selectedRouteDirectionGroup;
    }

    public final LocalDate getSelectedStartDate() {
        return this.selectedStartDate;
    }

    public final Site getSite() {
        return this.site;
    }

    public final Transportation getTransportation() {
        return this.transportation;
    }

    public int hashCode() {
        return (((((((((((this.configuration.hashCode() * 31) + this.selectedRoute.hashCode()) * 31) + this.selectedRouteDirection.hashCode()) * 31) + this.selectedRouteDirectionGroup.hashCode()) * 31) + this.selectedStartDate.hashCode()) * 31) + this.transportation.hashCode()) * 31) + this.site.hashCode();
    }

    public String toString() {
        return "SaleOnBoardRouteState(configuration=" + this.configuration + ", selectedRoute=" + this.selectedRoute + ", selectedRouteDirection=" + this.selectedRouteDirection + ", selectedRouteDirectionGroup=" + this.selectedRouteDirectionGroup + ", selectedStartDate=" + this.selectedStartDate + ", transportation=" + this.transportation + ", site=" + this.site + ")";
    }

    public /* synthetic */ SaleOnBoardRouteState(LocalizedSiteConfiguration localizedSiteConfiguration, Route route, RouteDirection routeDirection, RouteDirectionGroup routeDirectionGroup, LocalDate localDate, Transportation transportation, Site site, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(localizedSiteConfiguration, route, routeDirection, routeDirectionGroup, (i5 & 16) != 0 ? LocalDate.now() : localDate, transportation, (i5 & 64) != 0 ? Site.Mols : site);
    }
}
