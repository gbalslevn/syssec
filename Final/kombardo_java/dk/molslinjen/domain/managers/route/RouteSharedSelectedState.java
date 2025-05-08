package dk.molslinjen.domain.managers.route;

import dk.molslinjen.domain.model.booking.CommuterBookingData;
import dk.molslinjen.domain.model.booking.MultiRideBookingData;
import dk.molslinjen.domain.model.config.Route;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.domain.model.config.Transportation;
import dk.molslinjen.domain.model.shared.CurrencyType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u001d\b\u0086\b\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013Jf\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001c\u001a\u00020\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010!\u001a\u0004\b\"\u0010#R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010$\u001a\u0004\b%\u0010\u0017R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010&\u001a\u0004\b'\u0010(R\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010)\u001a\u0004\b*\u0010+R\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010,\u001a\u0004\b-\u0010.R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010/\u001a\u0004\b0\u00101R\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u00102\u001a\u0004\b3\u00104¨\u00065"}, d2 = {"Ldk/molslinjen/domain/managers/route/RouteSharedSelectedState;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "hasRouteManuallyBeenSelected", "Ldk/molslinjen/domain/model/config/Site;", "site", BuildConfig.FLAVOR, "lineLogoUrl", "Ldk/molslinjen/domain/model/config/Transportation;", "selectedTransportation", "Ldk/molslinjen/domain/model/config/Route;", "selectedRoute", "Ldk/molslinjen/domain/model/shared/CurrencyType;", "currency", "Ldk/molslinjen/domain/model/booking/CommuterBookingData;", "commuterBookingData", "Ldk/molslinjen/domain/model/booking/MultiRideBookingData;", "multiRideBookingData", "<init>", "(ZLdk/molslinjen/domain/model/config/Site;Ljava/lang/String;Ldk/molslinjen/domain/model/config/Transportation;Ldk/molslinjen/domain/model/config/Route;Ldk/molslinjen/domain/model/shared/CurrencyType;Ldk/molslinjen/domain/model/booking/CommuterBookingData;Ldk/molslinjen/domain/model/booking/MultiRideBookingData;)V", "copy", "(ZLdk/molslinjen/domain/model/config/Site;Ljava/lang/String;Ldk/molslinjen/domain/model/config/Transportation;Ldk/molslinjen/domain/model/config/Route;Ldk/molslinjen/domain/model/shared/CurrencyType;Ldk/molslinjen/domain/model/booking/CommuterBookingData;Ldk/molslinjen/domain/model/booking/MultiRideBookingData;)Ldk/molslinjen/domain/managers/route/RouteSharedSelectedState;", "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getHasRouteManuallyBeenSelected", "()Z", "Ldk/molslinjen/domain/model/config/Site;", "getSite", "()Ldk/molslinjen/domain/model/config/Site;", "Ljava/lang/String;", "getLineLogoUrl", "Ldk/molslinjen/domain/model/config/Transportation;", "getSelectedTransportation", "()Ldk/molslinjen/domain/model/config/Transportation;", "Ldk/molslinjen/domain/model/config/Route;", "getSelectedRoute", "()Ldk/molslinjen/domain/model/config/Route;", "Ldk/molslinjen/domain/model/shared/CurrencyType;", "getCurrency", "()Ldk/molslinjen/domain/model/shared/CurrencyType;", "Ldk/molslinjen/domain/model/booking/CommuterBookingData;", "getCommuterBookingData", "()Ldk/molslinjen/domain/model/booking/CommuterBookingData;", "Ldk/molslinjen/domain/model/booking/MultiRideBookingData;", "getMultiRideBookingData", "()Ldk/molslinjen/domain/model/booking/MultiRideBookingData;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class RouteSharedSelectedState {
    private final CommuterBookingData commuterBookingData;
    private final CurrencyType currency;
    private final boolean hasRouteManuallyBeenSelected;
    private final String lineLogoUrl;
    private final MultiRideBookingData multiRideBookingData;
    private final Route selectedRoute;
    private final Transportation selectedTransportation;
    private final Site site;

    public RouteSharedSelectedState(boolean z5, Site site, String str, Transportation selectedTransportation, Route selectedRoute, CurrencyType currency, CommuterBookingData commuterBookingData, MultiRideBookingData multiRideBookingData) {
        Intrinsics.checkNotNullParameter(site, "site");
        Intrinsics.checkNotNullParameter(selectedTransportation, "selectedTransportation");
        Intrinsics.checkNotNullParameter(selectedRoute, "selectedRoute");
        Intrinsics.checkNotNullParameter(currency, "currency");
        this.hasRouteManuallyBeenSelected = z5;
        this.site = site;
        this.lineLogoUrl = str;
        this.selectedTransportation = selectedTransportation;
        this.selectedRoute = selectedRoute;
        this.currency = currency;
        this.commuterBookingData = commuterBookingData;
        this.multiRideBookingData = multiRideBookingData;
    }

    public final RouteSharedSelectedState copy(boolean hasRouteManuallyBeenSelected, Site site, String lineLogoUrl, Transportation selectedTransportation, Route selectedRoute, CurrencyType currency, CommuterBookingData commuterBookingData, MultiRideBookingData multiRideBookingData) {
        Intrinsics.checkNotNullParameter(site, "site");
        Intrinsics.checkNotNullParameter(selectedTransportation, "selectedTransportation");
        Intrinsics.checkNotNullParameter(selectedRoute, "selectedRoute");
        Intrinsics.checkNotNullParameter(currency, "currency");
        return new RouteSharedSelectedState(hasRouteManuallyBeenSelected, site, lineLogoUrl, selectedTransportation, selectedRoute, currency, commuterBookingData, multiRideBookingData);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RouteSharedSelectedState)) {
            return false;
        }
        RouteSharedSelectedState routeSharedSelectedState = (RouteSharedSelectedState) other;
        return this.hasRouteManuallyBeenSelected == routeSharedSelectedState.hasRouteManuallyBeenSelected && this.site == routeSharedSelectedState.site && Intrinsics.areEqual(this.lineLogoUrl, routeSharedSelectedState.lineLogoUrl) && Intrinsics.areEqual(this.selectedTransportation, routeSharedSelectedState.selectedTransportation) && Intrinsics.areEqual(this.selectedRoute, routeSharedSelectedState.selectedRoute) && this.currency == routeSharedSelectedState.currency && Intrinsics.areEqual(this.commuterBookingData, routeSharedSelectedState.commuterBookingData) && Intrinsics.areEqual(this.multiRideBookingData, routeSharedSelectedState.multiRideBookingData);
    }

    public final CommuterBookingData getCommuterBookingData() {
        return this.commuterBookingData;
    }

    public final CurrencyType getCurrency() {
        return this.currency;
    }

    public final boolean getHasRouteManuallyBeenSelected() {
        return this.hasRouteManuallyBeenSelected;
    }

    public final String getLineLogoUrl() {
        return this.lineLogoUrl;
    }

    public final MultiRideBookingData getMultiRideBookingData() {
        return this.multiRideBookingData;
    }

    public final Route getSelectedRoute() {
        return this.selectedRoute;
    }

    public final Transportation getSelectedTransportation() {
        return this.selectedTransportation;
    }

    public final Site getSite() {
        return this.site;
    }

    public int hashCode() {
        int hashCode = ((Boolean.hashCode(this.hasRouteManuallyBeenSelected) * 31) + this.site.hashCode()) * 31;
        String str = this.lineLogoUrl;
        int hashCode2 = (((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.selectedTransportation.hashCode()) * 31) + this.selectedRoute.hashCode()) * 31) + this.currency.hashCode()) * 31;
        CommuterBookingData commuterBookingData = this.commuterBookingData;
        int hashCode3 = (hashCode2 + (commuterBookingData == null ? 0 : commuterBookingData.hashCode())) * 31;
        MultiRideBookingData multiRideBookingData = this.multiRideBookingData;
        return hashCode3 + (multiRideBookingData != null ? multiRideBookingData.hashCode() : 0);
    }

    public String toString() {
        return "RouteSharedSelectedState(hasRouteManuallyBeenSelected=" + this.hasRouteManuallyBeenSelected + ", site=" + this.site + ", lineLogoUrl=" + this.lineLogoUrl + ", selectedTransportation=" + this.selectedTransportation + ", selectedRoute=" + this.selectedRoute + ", currency=" + this.currency + ", commuterBookingData=" + this.commuterBookingData + ", multiRideBookingData=" + this.multiRideBookingData + ")";
    }
}
