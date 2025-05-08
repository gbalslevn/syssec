package dk.molslinjen.api.services.geolocator.request;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Ldk/molslinjen/api/services/geolocator/request/TravelTimeToNearestHarborRequestParameters;", BuildConfig.FLAVOR, "latitude", BuildConfig.FLAVOR, "longitude", "<init>", "(DD)V", "getLatitude", "()D", "getLongitude", "component1", "component2", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class TravelTimeToNearestHarborRequestParameters {
    private final double latitude;
    private final double longitude;

    public TravelTimeToNearestHarborRequestParameters(double d5, double d6) {
        this.latitude = d5;
        this.longitude = d6;
    }

    public static /* synthetic */ TravelTimeToNearestHarborRequestParameters copy$default(TravelTimeToNearestHarborRequestParameters travelTimeToNearestHarborRequestParameters, double d5, double d6, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            d5 = travelTimeToNearestHarborRequestParameters.latitude;
        }
        if ((i5 & 2) != 0) {
            d6 = travelTimeToNearestHarborRequestParameters.longitude;
        }
        return travelTimeToNearestHarborRequestParameters.copy(d5, d6);
    }

    /* renamed from: component1, reason: from getter */
    public final double getLatitude() {
        return this.latitude;
    }

    /* renamed from: component2, reason: from getter */
    public final double getLongitude() {
        return this.longitude;
    }

    public final TravelTimeToNearestHarborRequestParameters copy(double latitude, double longitude) {
        return new TravelTimeToNearestHarborRequestParameters(latitude, longitude);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TravelTimeToNearestHarborRequestParameters)) {
            return false;
        }
        TravelTimeToNearestHarborRequestParameters travelTimeToNearestHarborRequestParameters = (TravelTimeToNearestHarborRequestParameters) other;
        return Double.compare(this.latitude, travelTimeToNearestHarborRequestParameters.latitude) == 0 && Double.compare(this.longitude, travelTimeToNearestHarborRequestParameters.longitude) == 0;
    }

    public final double getLatitude() {
        return this.latitude;
    }

    public final double getLongitude() {
        return this.longitude;
    }

    public int hashCode() {
        return (Double.hashCode(this.latitude) * 31) + Double.hashCode(this.longitude);
    }

    public String toString() {
        return "TravelTimeToNearestHarborRequestParameters(latitude=" + this.latitude + ", longitude=" + this.longitude + ")";
    }
}
