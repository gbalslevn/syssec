package dk.molslinjen.domain.model.booking;

import dk.molslinjen.api.services.geolocator.response.HarborCoordinatesResponseDTO;
import dk.molslinjen.api.services.geolocator.response.TravelTimeToNearestHarborOnRouteResponseDTO;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001b\b\u0086\b\u0018\u0000 +2\u00020\u0001:\u0001+BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fB\u0011\b\u0016\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u000e\u0010\u0012J\t\u0010\u001e\u001a\u00020\u0003HÂ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÂ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\bHÆ\u0003J\t\u0010#\u001a\u00020\bHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010%\u001a\u00020\rHÆ\u0003J[\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0013\u0010'\u001a\u00020\r2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\bHÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014¨\u0006,"}, d2 = {"Ldk/molslinjen/domain/model/booking/TravelTimeToNearestHarborOnRoute;", BuildConfig.FLAVOR, "address", BuildConfig.FLAVOR, "city", "harborName", "siteName", "travelTimeMinutes", BuildConfig.FLAVOR, "travelTimeHours", "harborCoordinates", "Ldk/molslinjen/domain/model/booking/Coordinate;", "isWithinTravelRange", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILdk/molslinjen/domain/model/booking/Coordinate;Z)V", "dto", "Ldk/molslinjen/api/services/geolocator/response/TravelTimeToNearestHarborOnRouteResponseDTO;", "(Ldk/molslinjen/api/services/geolocator/response/TravelTimeToNearestHarborOnRouteResponseDTO;)V", "getHarborName", "()Ljava/lang/String;", "getSiteName", "getTravelTimeMinutes", "()I", "getTravelTimeHours", "getHarborCoordinates", "()Ldk/molslinjen/domain/model/booking/Coordinate;", "()Z", "directionsDestination", "getDirectionsDestination", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "Companion", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class TravelTimeToNearestHarborOnRoute {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final TravelTimeToNearestHarborOnRoute mock = new TravelTimeToNearestHarborOnRoute("Københavns Havn 3", "København", "København Havn", "Molslinjen", 10, 1, Coordinate.INSTANCE.getMock(), true);
    private final String address;
    private final String city;
    private final String directionsDestination;
    private final Coordinate harborCoordinates;
    private final String harborName;
    private final boolean isWithinTravelRange;
    private final String siteName;
    private final int travelTimeHours;
    private final int travelTimeMinutes;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ldk/molslinjen/domain/model/booking/TravelTimeToNearestHarborOnRoute$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mock", "Ldk/molslinjen/domain/model/booking/TravelTimeToNearestHarborOnRoute;", "getMock", "()Ldk/molslinjen/domain/model/booking/TravelTimeToNearestHarborOnRoute;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TravelTimeToNearestHarborOnRoute getMock() {
            return TravelTimeToNearestHarborOnRoute.mock;
        }

        private Companion() {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0045, code lost:
    
        if (r4 == null) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TravelTimeToNearestHarborOnRoute(String address, String city, String harborName, String siteName, int i5, int i6, Coordinate coordinate, boolean z5) {
        String str;
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(city, "city");
        Intrinsics.checkNotNullParameter(harborName, "harborName");
        Intrinsics.checkNotNullParameter(siteName, "siteName");
        this.address = address;
        this.city = city;
        this.harborName = harborName;
        this.siteName = siteName;
        this.travelTimeMinutes = i5;
        this.travelTimeHours = i6;
        this.harborCoordinates = coordinate;
        this.isWithinTravelRange = z5;
        if (coordinate != null) {
            str = coordinate.getLatitude() + "," + coordinate.getLongitude();
        }
        str = address + ", " + city;
        this.directionsDestination = str;
    }

    /* renamed from: component1, reason: from getter */
    private final String getAddress() {
        return this.address;
    }

    /* renamed from: component2, reason: from getter */
    private final String getCity() {
        return this.city;
    }

    /* renamed from: component3, reason: from getter */
    public final String getHarborName() {
        return this.harborName;
    }

    /* renamed from: component4, reason: from getter */
    public final String getSiteName() {
        return this.siteName;
    }

    /* renamed from: component5, reason: from getter */
    public final int getTravelTimeMinutes() {
        return this.travelTimeMinutes;
    }

    /* renamed from: component6, reason: from getter */
    public final int getTravelTimeHours() {
        return this.travelTimeHours;
    }

    /* renamed from: component7, reason: from getter */
    public final Coordinate getHarborCoordinates() {
        return this.harborCoordinates;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getIsWithinTravelRange() {
        return this.isWithinTravelRange;
    }

    public final TravelTimeToNearestHarborOnRoute copy(String address, String city, String harborName, String siteName, int travelTimeMinutes, int travelTimeHours, Coordinate harborCoordinates, boolean isWithinTravelRange) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(city, "city");
        Intrinsics.checkNotNullParameter(harborName, "harborName");
        Intrinsics.checkNotNullParameter(siteName, "siteName");
        return new TravelTimeToNearestHarborOnRoute(address, city, harborName, siteName, travelTimeMinutes, travelTimeHours, harborCoordinates, isWithinTravelRange);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TravelTimeToNearestHarborOnRoute)) {
            return false;
        }
        TravelTimeToNearestHarborOnRoute travelTimeToNearestHarborOnRoute = (TravelTimeToNearestHarborOnRoute) other;
        return Intrinsics.areEqual(this.address, travelTimeToNearestHarborOnRoute.address) && Intrinsics.areEqual(this.city, travelTimeToNearestHarborOnRoute.city) && Intrinsics.areEqual(this.harborName, travelTimeToNearestHarborOnRoute.harborName) && Intrinsics.areEqual(this.siteName, travelTimeToNearestHarborOnRoute.siteName) && this.travelTimeMinutes == travelTimeToNearestHarborOnRoute.travelTimeMinutes && this.travelTimeHours == travelTimeToNearestHarborOnRoute.travelTimeHours && Intrinsics.areEqual(this.harborCoordinates, travelTimeToNearestHarborOnRoute.harborCoordinates) && this.isWithinTravelRange == travelTimeToNearestHarborOnRoute.isWithinTravelRange;
    }

    public final String getDirectionsDestination() {
        return this.directionsDestination;
    }

    public final Coordinate getHarborCoordinates() {
        return this.harborCoordinates;
    }

    public final String getHarborName() {
        return this.harborName;
    }

    public final String getSiteName() {
        return this.siteName;
    }

    public final int getTravelTimeHours() {
        return this.travelTimeHours;
    }

    public final int getTravelTimeMinutes() {
        return this.travelTimeMinutes;
    }

    public int hashCode() {
        int hashCode = ((((((((((this.address.hashCode() * 31) + this.city.hashCode()) * 31) + this.harborName.hashCode()) * 31) + this.siteName.hashCode()) * 31) + Integer.hashCode(this.travelTimeMinutes)) * 31) + Integer.hashCode(this.travelTimeHours)) * 31;
        Coordinate coordinate = this.harborCoordinates;
        return ((hashCode + (coordinate == null ? 0 : coordinate.hashCode())) * 31) + Boolean.hashCode(this.isWithinTravelRange);
    }

    public final boolean isWithinTravelRange() {
        return this.isWithinTravelRange;
    }

    public String toString() {
        return "TravelTimeToNearestHarborOnRoute(address=" + this.address + ", city=" + this.city + ", harborName=" + this.harborName + ", siteName=" + this.siteName + ", travelTimeMinutes=" + this.travelTimeMinutes + ", travelTimeHours=" + this.travelTimeHours + ", harborCoordinates=" + this.harborCoordinates + ", isWithinTravelRange=" + this.isWithinTravelRange + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TravelTimeToNearestHarborOnRoute(TravelTimeToNearestHarborOnRouteResponseDTO dto) {
        this(r2, r3, r4, r5, r6, r7, r0 != null ? new Coordinate(r0.getLatitude(), r0.getLongitude()) : null, dto.isWithinTravelRange());
        Intrinsics.checkNotNullParameter(dto, "dto");
        String harborName = dto.getHarborName();
        String address = dto.getAddress();
        String city = dto.getCity();
        String lineName = dto.getLineName();
        int travelTimeMinutes = dto.getTravelTimeMinutes();
        int travelTimeHours = dto.getTravelTimeHours();
        HarborCoordinatesResponseDTO harborCoordinates = dto.getHarborCoordinates();
    }
}
