package dk.molslinjen.api.services.geolocator.response;

import com.sun.jna.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 52\u00020\u0001:\u000245BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fBe\b\u0010\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u000e\u0010\u0013J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\bHÆ\u0003J\t\u0010$\u001a\u00020\bHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010&\u001a\u00020\rHÆ\u0003J[\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0013\u0010(\u001a\u00020\r2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020\bHÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001J%\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00002\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0001¢\u0006\u0002\b3R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u001e¨\u00066"}, d2 = {"Ldk/molslinjen/api/services/geolocator/response/TravelTimeToNearestHarborOnRouteResponseDTO;", BuildConfig.FLAVOR, "address", BuildConfig.FLAVOR, "city", "harborName", "lineName", "travelTimeMinutes", BuildConfig.FLAVOR, "travelTimeHours", "harborCoordinates", "Ldk/molslinjen/api/services/geolocator/response/HarborCoordinatesResponseDTO;", "isWithinTravelRange", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILdk/molslinjen/api/services/geolocator/response/HarborCoordinatesResponseDTO;Z)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILdk/molslinjen/api/services/geolocator/response/HarborCoordinatesResponseDTO;ZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getAddress", "()Ljava/lang/String;", "getCity", "getHarborName", "getLineName", "getTravelTimeMinutes", "()I", "getTravelTimeHours", "getHarborCoordinates", "()Ldk/molslinjen/api/services/geolocator/response/HarborCoordinatesResponseDTO;", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class TravelTimeToNearestHarborOnRouteResponseDTO {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String address;
    private final String city;
    private final HarborCoordinatesResponseDTO harborCoordinates;
    private final String harborName;
    private final boolean isWithinTravelRange;
    private final String lineName;
    private final int travelTimeHours;
    private final int travelTimeMinutes;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/geolocator/response/TravelTimeToNearestHarborOnRouteResponseDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/geolocator/response/TravelTimeToNearestHarborOnRouteResponseDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<TravelTimeToNearestHarborOnRouteResponseDTO> serializer() {
            return TravelTimeToNearestHarborOnRouteResponseDTO$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ TravelTimeToNearestHarborOnRouteResponseDTO(int i5, String str, String str2, String str3, String str4, int i6, int i7, HarborCoordinatesResponseDTO harborCoordinatesResponseDTO, boolean z5, SerializationConstructorMarker serializationConstructorMarker) {
        if (255 != (i5 & Function.USE_VARARGS)) {
            PluginExceptionsKt.throwMissingFieldException(i5, Function.USE_VARARGS, TravelTimeToNearestHarborOnRouteResponseDTO$$serializer.INSTANCE.getDescriptor());
        }
        this.address = str;
        this.city = str2;
        this.harborName = str3;
        this.lineName = str4;
        this.travelTimeMinutes = i6;
        this.travelTimeHours = i7;
        this.harborCoordinates = harborCoordinatesResponseDTO;
        this.isWithinTravelRange = z5;
    }

    public static final /* synthetic */ void write$Self$api_kombardoProd(TravelTimeToNearestHarborOnRouteResponseDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.address);
        output.encodeStringElement(serialDesc, 1, self.city);
        output.encodeStringElement(serialDesc, 2, self.harborName);
        output.encodeStringElement(serialDesc, 3, self.lineName);
        output.encodeIntElement(serialDesc, 4, self.travelTimeMinutes);
        output.encodeIntElement(serialDesc, 5, self.travelTimeHours);
        output.encodeNullableSerializableElement(serialDesc, 6, HarborCoordinatesResponseDTO$$serializer.INSTANCE, self.harborCoordinates);
        output.encodeBooleanElement(serialDesc, 7, self.isWithinTravelRange);
    }

    /* renamed from: component1, reason: from getter */
    public final String getAddress() {
        return this.address;
    }

    /* renamed from: component2, reason: from getter */
    public final String getCity() {
        return this.city;
    }

    /* renamed from: component3, reason: from getter */
    public final String getHarborName() {
        return this.harborName;
    }

    /* renamed from: component4, reason: from getter */
    public final String getLineName() {
        return this.lineName;
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
    public final HarborCoordinatesResponseDTO getHarborCoordinates() {
        return this.harborCoordinates;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getIsWithinTravelRange() {
        return this.isWithinTravelRange;
    }

    public final TravelTimeToNearestHarborOnRouteResponseDTO copy(String address, String city, String harborName, String lineName, int travelTimeMinutes, int travelTimeHours, HarborCoordinatesResponseDTO harborCoordinates, boolean isWithinTravelRange) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(city, "city");
        Intrinsics.checkNotNullParameter(harborName, "harborName");
        Intrinsics.checkNotNullParameter(lineName, "lineName");
        return new TravelTimeToNearestHarborOnRouteResponseDTO(address, city, harborName, lineName, travelTimeMinutes, travelTimeHours, harborCoordinates, isWithinTravelRange);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TravelTimeToNearestHarborOnRouteResponseDTO)) {
            return false;
        }
        TravelTimeToNearestHarborOnRouteResponseDTO travelTimeToNearestHarborOnRouteResponseDTO = (TravelTimeToNearestHarborOnRouteResponseDTO) other;
        return Intrinsics.areEqual(this.address, travelTimeToNearestHarborOnRouteResponseDTO.address) && Intrinsics.areEqual(this.city, travelTimeToNearestHarborOnRouteResponseDTO.city) && Intrinsics.areEqual(this.harborName, travelTimeToNearestHarborOnRouteResponseDTO.harborName) && Intrinsics.areEqual(this.lineName, travelTimeToNearestHarborOnRouteResponseDTO.lineName) && this.travelTimeMinutes == travelTimeToNearestHarborOnRouteResponseDTO.travelTimeMinutes && this.travelTimeHours == travelTimeToNearestHarborOnRouteResponseDTO.travelTimeHours && Intrinsics.areEqual(this.harborCoordinates, travelTimeToNearestHarborOnRouteResponseDTO.harborCoordinates) && this.isWithinTravelRange == travelTimeToNearestHarborOnRouteResponseDTO.isWithinTravelRange;
    }

    public final String getAddress() {
        return this.address;
    }

    public final String getCity() {
        return this.city;
    }

    public final HarborCoordinatesResponseDTO getHarborCoordinates() {
        return this.harborCoordinates;
    }

    public final String getHarborName() {
        return this.harborName;
    }

    public final String getLineName() {
        return this.lineName;
    }

    public final int getTravelTimeHours() {
        return this.travelTimeHours;
    }

    public final int getTravelTimeMinutes() {
        return this.travelTimeMinutes;
    }

    public int hashCode() {
        int hashCode = ((((((((((this.address.hashCode() * 31) + this.city.hashCode()) * 31) + this.harborName.hashCode()) * 31) + this.lineName.hashCode()) * 31) + Integer.hashCode(this.travelTimeMinutes)) * 31) + Integer.hashCode(this.travelTimeHours)) * 31;
        HarborCoordinatesResponseDTO harborCoordinatesResponseDTO = this.harborCoordinates;
        return ((hashCode + (harborCoordinatesResponseDTO == null ? 0 : harborCoordinatesResponseDTO.hashCode())) * 31) + Boolean.hashCode(this.isWithinTravelRange);
    }

    public final boolean isWithinTravelRange() {
        return this.isWithinTravelRange;
    }

    public String toString() {
        return "TravelTimeToNearestHarborOnRouteResponseDTO(address=" + this.address + ", city=" + this.city + ", harborName=" + this.harborName + ", lineName=" + this.lineName + ", travelTimeMinutes=" + this.travelTimeMinutes + ", travelTimeHours=" + this.travelTimeHours + ", harborCoordinates=" + this.harborCoordinates + ", isWithinTravelRange=" + this.isWithinTravelRange + ")";
    }

    public TravelTimeToNearestHarborOnRouteResponseDTO(String address, String city, String harborName, String lineName, int i5, int i6, HarborCoordinatesResponseDTO harborCoordinatesResponseDTO, boolean z5) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(city, "city");
        Intrinsics.checkNotNullParameter(harborName, "harborName");
        Intrinsics.checkNotNullParameter(lineName, "lineName");
        this.address = address;
        this.city = city;
        this.harborName = harborName;
        this.lineName = lineName;
        this.travelTimeMinutes = i5;
        this.travelTimeHours = i6;
        this.harborCoordinates = harborCoordinatesResponseDTO;
        this.isWithinTravelRange = z5;
    }
}
