package dk.molslinjen.api.services.geolocator.request;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Ldk/molslinjen/api/services/geolocator/request/TravelTimeToNearestHarborOnRouteRequestParameters;", BuildConfig.FLAVOR, "latitude", BuildConfig.FLAVOR, "longitude", "routeId", BuildConfig.FLAVOR, "<init>", "(DDLjava/lang/String;)V", "getLatitude", "()D", "getLongitude", "getRouteId", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", BuildConfig.FLAVOR, "toString", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class TravelTimeToNearestHarborOnRouteRequestParameters {
    private final double latitude;
    private final double longitude;
    private final String routeId;

    public TravelTimeToNearestHarborOnRouteRequestParameters(double d5, double d6, String routeId) {
        Intrinsics.checkNotNullParameter(routeId, "routeId");
        this.latitude = d5;
        this.longitude = d6;
        this.routeId = routeId;
    }

    public static /* synthetic */ TravelTimeToNearestHarborOnRouteRequestParameters copy$default(TravelTimeToNearestHarborOnRouteRequestParameters travelTimeToNearestHarborOnRouteRequestParameters, double d5, double d6, String str, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            d5 = travelTimeToNearestHarborOnRouteRequestParameters.latitude;
        }
        double d7 = d5;
        if ((i5 & 2) != 0) {
            d6 = travelTimeToNearestHarborOnRouteRequestParameters.longitude;
        }
        double d8 = d6;
        if ((i5 & 4) != 0) {
            str = travelTimeToNearestHarborOnRouteRequestParameters.routeId;
        }
        return travelTimeToNearestHarborOnRouteRequestParameters.copy(d7, d8, str);
    }

    /* renamed from: component1, reason: from getter */
    public final double getLatitude() {
        return this.latitude;
    }

    /* renamed from: component2, reason: from getter */
    public final double getLongitude() {
        return this.longitude;
    }

    /* renamed from: component3, reason: from getter */
    public final String getRouteId() {
        return this.routeId;
    }

    public final TravelTimeToNearestHarborOnRouteRequestParameters copy(double latitude, double longitude, String routeId) {
        Intrinsics.checkNotNullParameter(routeId, "routeId");
        return new TravelTimeToNearestHarborOnRouteRequestParameters(latitude, longitude, routeId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TravelTimeToNearestHarborOnRouteRequestParameters)) {
            return false;
        }
        TravelTimeToNearestHarborOnRouteRequestParameters travelTimeToNearestHarborOnRouteRequestParameters = (TravelTimeToNearestHarborOnRouteRequestParameters) other;
        return Double.compare(this.latitude, travelTimeToNearestHarborOnRouteRequestParameters.latitude) == 0 && Double.compare(this.longitude, travelTimeToNearestHarborOnRouteRequestParameters.longitude) == 0 && Intrinsics.areEqual(this.routeId, travelTimeToNearestHarborOnRouteRequestParameters.routeId);
    }

    public final double getLatitude() {
        return this.latitude;
    }

    public final double getLongitude() {
        return this.longitude;
    }

    public final String getRouteId() {
        return this.routeId;
    }

    public int hashCode() {
        return (((Double.hashCode(this.latitude) * 31) + Double.hashCode(this.longitude)) * 31) + this.routeId.hashCode();
    }

    public String toString() {
        return "TravelTimeToNearestHarborOnRouteRequestParameters(latitude=" + this.latitude + ", longitude=" + this.longitude + ", routeId=" + this.routeId + ")";
    }
}
