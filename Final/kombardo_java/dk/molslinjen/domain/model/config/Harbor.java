package dk.molslinjen.domain.model.config;

import android.location.Location;
import com.sdk.growthbook.utils.Constants;
import dk.molslinjen.api.shared.response.AreaDTO;
import dk.molslinjen.api.shared.response.HarborDTO;
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

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 92\u00020\u0001:\u00029:BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rB\u0011\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\f\u0010\u0010Bk\b\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\f\u0010\u0015J\u0006\u0010 \u001a\u00020\u0003J\u0006\u0010!\u001a\u00020\"J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u000bHÆ\u0003J[\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u00020\u0012HÖ\u0001J\t\u00100\u001a\u00020\u0003HÖ\u0001J%\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u00002\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u000207H\u0001¢\u0006\u0002\b8R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006;"}, d2 = {"Ldk/molslinjen/domain/model/config/Harbor;", BuildConfig.FLAVOR, "address", BuildConfig.FLAVOR, "city", Constants.ID_ATTRIBUTE_KEY, "latitude", "longitude", "name", "postalCode", "area", "Ldk/molslinjen/domain/model/config/Area;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/domain/model/config/Area;)V", "routeDTO", "Ldk/molslinjen/api/shared/response/HarborDTO;", "(Ldk/molslinjen/api/shared/response/HarborDTO;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/domain/model/config/Area;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getAddress", "()Ljava/lang/String;", "getCity", "getId", "getLatitude", "getLongitude", "getName", "getPostalCode", "getArea", "()Ldk/molslinjen/domain/model/config/Area;", "fullAddress", "location", "Landroid/location/Location;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$domain_kombardoProd", "Companion", "$serializer", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class Harbor {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Harbor mockAarhus = new Harbor("Færgevej 7A", "Aarhus C", "ÅRH3", "56.150765", "10.253467", "Aarhus", "8000", Area.INSTANCE.getMock());
    private static final Harbor mockOdden = new Harbor("Oddenvej 388", "Sjællands Odde", "ODD", "55.975495", "11.298353", "Odden", "4583", (Area) null, 128, (DefaultConstructorMarker) null);
    private final String address;
    private final Area area;
    private final String city;
    private final String id;
    private final String latitude;
    private final String longitude;
    private final String name;
    private final String postalCode;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\f"}, d2 = {"Ldk/molslinjen/domain/model/config/Harbor$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mockAarhus", "Ldk/molslinjen/domain/model/config/Harbor;", "getMockAarhus", "()Ldk/molslinjen/domain/model/config/Harbor;", "mockOdden", "getMockOdden", "serializer", "Lkotlinx/serialization/KSerializer;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Harbor getMockAarhus() {
            return Harbor.mockAarhus;
        }

        public final Harbor getMockOdden() {
            return Harbor.mockOdden;
        }

        public final KSerializer<Harbor> serializer() {
            return Harbor$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ Harbor(int i5, String str, String str2, String str3, String str4, String str5, String str6, String str7, Area area, SerializationConstructorMarker serializationConstructorMarker) {
        if (127 != (i5 & 127)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 127, Harbor$$serializer.INSTANCE.getDescriptor());
        }
        this.address = str;
        this.city = str2;
        this.id = str3;
        this.latitude = str4;
        this.longitude = str5;
        this.name = str6;
        this.postalCode = str7;
        if ((i5 & 128) == 0) {
            this.area = null;
        } else {
            this.area = area;
        }
    }

    public static final /* synthetic */ void write$Self$domain_kombardoProd(Harbor self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.address);
        output.encodeStringElement(serialDesc, 1, self.city);
        output.encodeStringElement(serialDesc, 2, self.id);
        output.encodeStringElement(serialDesc, 3, self.latitude);
        output.encodeStringElement(serialDesc, 4, self.longitude);
        output.encodeStringElement(serialDesc, 5, self.name);
        output.encodeStringElement(serialDesc, 6, self.postalCode);
        if (!output.shouldEncodeElementDefault(serialDesc, 7) && self.area == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 7, Area$$serializer.INSTANCE, self.area);
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
    public final String getId() {
        return this.id;
    }

    /* renamed from: component4, reason: from getter */
    public final String getLatitude() {
        return this.latitude;
    }

    /* renamed from: component5, reason: from getter */
    public final String getLongitude() {
        return this.longitude;
    }

    /* renamed from: component6, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component7, reason: from getter */
    public final String getPostalCode() {
        return this.postalCode;
    }

    /* renamed from: component8, reason: from getter */
    public final Area getArea() {
        return this.area;
    }

    public final Harbor copy(String address, String city, String id, String latitude, String longitude, String name, String postalCode, Area area) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(city, "city");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(latitude, "latitude");
        Intrinsics.checkNotNullParameter(longitude, "longitude");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(postalCode, "postalCode");
        return new Harbor(address, city, id, latitude, longitude, name, postalCode, area);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Harbor)) {
            return false;
        }
        Harbor harbor = (Harbor) other;
        return Intrinsics.areEqual(this.address, harbor.address) && Intrinsics.areEqual(this.city, harbor.city) && Intrinsics.areEqual(this.id, harbor.id) && Intrinsics.areEqual(this.latitude, harbor.latitude) && Intrinsics.areEqual(this.longitude, harbor.longitude) && Intrinsics.areEqual(this.name, harbor.name) && Intrinsics.areEqual(this.postalCode, harbor.postalCode) && Intrinsics.areEqual(this.area, harbor.area);
    }

    public final String fullAddress() {
        return this.address + "\n" + this.postalCode + " " + this.city;
    }

    public final String getAddress() {
        return this.address;
    }

    public final Area getArea() {
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
        Area area = this.area;
        return hashCode + (area == null ? 0 : area.hashCode());
    }

    public final Location location() {
        Location location = new Location(BuildConfig.FLAVOR);
        location.setLatitude(Double.parseDouble(this.latitude));
        location.setLongitude(Double.parseDouble(this.longitude));
        location.setTime(System.currentTimeMillis());
        return location;
    }

    public String toString() {
        return "Harbor(address=" + this.address + ", city=" + this.city + ", id=" + this.id + ", latitude=" + this.latitude + ", longitude=" + this.longitude + ", name=" + this.name + ", postalCode=" + this.postalCode + ", area=" + this.area + ")";
    }

    public Harbor(String address, String city, String id, String latitude, String longitude, String name, String postalCode, Area area) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(city, "city");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(latitude, "latitude");
        Intrinsics.checkNotNullParameter(longitude, "longitude");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(postalCode, "postalCode");
        this.address = address;
        this.city = city;
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
        this.postalCode = postalCode;
        this.area = area;
    }

    public /* synthetic */ Harbor(String str, String str2, String str3, String str4, String str5, String str6, String str7, Area area, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, str5, str6, str7, (i5 & 128) != 0 ? null : area);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Harbor(HarborDTO routeDTO) {
        this(r2, r3, r4, r5, r6, r7, r8, r11 != null ? new Area(r11) : null);
        Intrinsics.checkNotNullParameter(routeDTO, "routeDTO");
        String address = routeDTO.getAddress();
        String city = routeDTO.getCity();
        String id = routeDTO.getId();
        String latitude = routeDTO.getLatitude();
        String longitude = routeDTO.getLongitude();
        String name = routeDTO.getName();
        String postalCode = routeDTO.getPostalCode();
        AreaDTO area = routeDTO.getArea();
    }
}
