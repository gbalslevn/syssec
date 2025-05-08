package dk.molslinjen.api.shared.response;

import com.sdk.growthbook.utils.Constants;
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

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0087\b\u0018\u0000 .2\u00020\u0001:\u0002/.Bk\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010!\u001a\u00020 2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b!\u0010\"R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010#\u001a\u0004\b$\u0010\u001cR\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010#\u001a\u0004\b%\u0010\u001cR\u0017\u0010\u0007\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010#\u001a\u0004\b&\u0010\u001cR\u0017\u0010\b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\b\u0010#\u001a\u0004\b'\u0010\u001cR\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010#\u001a\u0004\b(\u0010\u001cR\u0017\u0010\n\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\n\u0010#\u001a\u0004\b)\u0010\u001cR\u0017\u0010\u000b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000b\u0010#\u001a\u0004\b*\u0010\u001cR\u0019\u0010\r\u001a\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b\r\u0010+\u001a\u0004\b,\u0010-¨\u00060"}, d2 = {"Ldk/molslinjen/api/shared/response/HarborDTO;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "seen0", BuildConfig.FLAVOR, "address", "city", Constants.ID_ATTRIBUTE_KEY, "latitude", "longitude", "name", "postalCode", "Ldk/molslinjen/api/shared/response/AreaDTO;", "area", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/shared/response/AreaDTO;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", BuildConfig.FLAVOR, "write$Self$api_kombardoProd", "(Ldk/molslinjen/api/shared/response/HarborDTO;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getAddress", "getCity", "getId", "getLatitude", "getLongitude", "getName", "getPostalCode", "Ldk/molslinjen/api/shared/response/AreaDTO;", "getArea", "()Ldk/molslinjen/api/shared/response/AreaDTO;", "Companion", "$serializer", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class HarborDTO {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String address;
    private final AreaDTO area;
    private final String city;
    private final String id;
    private final String latitude;
    private final String longitude;
    private final String name;
    private final String postalCode;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/shared/response/HarborDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/shared/response/HarborDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<HarborDTO> serializer() {
            return HarborDTO$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ HarborDTO(int i5, String str, String str2, String str3, String str4, String str5, String str6, String str7, AreaDTO areaDTO, SerializationConstructorMarker serializationConstructorMarker) {
        if (255 != (i5 & Function.USE_VARARGS)) {
            PluginExceptionsKt.throwMissingFieldException(i5, Function.USE_VARARGS, HarborDTO$$serializer.INSTANCE.getDescriptor());
        }
        this.address = str;
        this.city = str2;
        this.id = str3;
        this.latitude = str4;
        this.longitude = str5;
        this.name = str6;
        this.postalCode = str7;
        this.area = areaDTO;
    }

    public static final /* synthetic */ void write$Self$api_kombardoProd(HarborDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.address);
        output.encodeStringElement(serialDesc, 1, self.city);
        output.encodeStringElement(serialDesc, 2, self.id);
        output.encodeStringElement(serialDesc, 3, self.latitude);
        output.encodeStringElement(serialDesc, 4, self.longitude);
        output.encodeStringElement(serialDesc, 5, self.name);
        output.encodeStringElement(serialDesc, 6, self.postalCode);
        output.encodeNullableSerializableElement(serialDesc, 7, AreaDTO$$serializer.INSTANCE, self.area);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HarborDTO)) {
            return false;
        }
        HarborDTO harborDTO = (HarborDTO) other;
        return Intrinsics.areEqual(this.address, harborDTO.address) && Intrinsics.areEqual(this.city, harborDTO.city) && Intrinsics.areEqual(this.id, harborDTO.id) && Intrinsics.areEqual(this.latitude, harborDTO.latitude) && Intrinsics.areEqual(this.longitude, harborDTO.longitude) && Intrinsics.areEqual(this.name, harborDTO.name) && Intrinsics.areEqual(this.postalCode, harborDTO.postalCode) && Intrinsics.areEqual(this.area, harborDTO.area);
    }

    public final String getAddress() {
        return this.address;
    }

    public final AreaDTO getArea() {
        return this.area;
    }

    public final String getCity() {
        return this.city;
    }

    public final String getId() {
        return this.id;
    }

    public final String getLatitude() {
        return this.latitude;
    }

    public final String getLongitude() {
        return this.longitude;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPostalCode() {
        return this.postalCode;
    }

    public int hashCode() {
        int hashCode = ((((((((((((this.address.hashCode() * 31) + this.city.hashCode()) * 31) + this.id.hashCode()) * 31) + this.latitude.hashCode()) * 31) + this.longitude.hashCode()) * 31) + this.name.hashCode()) * 31) + this.postalCode.hashCode()) * 31;
        AreaDTO areaDTO = this.area;
        return hashCode + (areaDTO == null ? 0 : areaDTO.hashCode());
    }

    public String toString() {
        return "HarborDTO(address=" + this.address + ", city=" + this.city + ", id=" + this.id + ", latitude=" + this.latitude + ", longitude=" + this.longitude + ", name=" + this.name + ", postalCode=" + this.postalCode + ", area=" + this.area + ")";
    }
}
