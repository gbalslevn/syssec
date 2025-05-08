package dk.molslinjen.api.services.account.vehicle.response;

import com.sun.jna.Function;
import dk.molslinjen.api.helpers.serializers.LocalDateTimeSerializer;
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
import org.threeten.bp.LocalDateTime;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 :2\u00020\u0001:\u00029:BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eBg\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\r\u0010\u0013J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\tHÆ\u0003J\t\u0010)\u001a\u00020\tHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\fHÆ\u0003J[\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001J\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u00020\u0010HÖ\u0001J\t\u00100\u001a\u00020\u0003HÖ\u0001J%\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u00002\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u000207H\u0001¢\u0006\u0002\b8R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u001c\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u001b\u001a\u0004\b\u001f\u0010\u001dR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u001b\u001a\u0004\b!\u0010\"¨\u0006;"}, d2 = {"Ldk/molslinjen/api/services/account/vehicle/response/VehicleDTO;", BuildConfig.FLAVOR, "vehicleId", BuildConfig.FLAVOR, "name", "licensePlate", "manufacturer", "model", "heightInMeters", BuildConfig.FLAVOR, "lengthInMeters", "lastUsed", "Lorg/threeten/bp/LocalDateTime;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DDLorg/threeten/bp/LocalDateTime;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DDLorg/threeten/bp/LocalDateTime;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getVehicleId", "()Ljava/lang/String;", "getName", "getLicensePlate", "getManufacturer", "getModel", "getHeightInMeters$annotations", "()V", "getHeightInMeters", "()D", "getLengthInMeters$annotations", "getLengthInMeters", "getLastUsed$annotations", "getLastUsed", "()Lorg/threeten/bp/LocalDateTime;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class VehicleDTO {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final double heightInMeters;
    private final LocalDateTime lastUsed;
    private final double lengthInMeters;
    private final String licensePlate;
    private final String manufacturer;
    private final String model;
    private final String name;
    private final String vehicleId;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/account/vehicle/response/VehicleDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/account/vehicle/response/VehicleDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<VehicleDTO> serializer() {
            return VehicleDTO$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ VehicleDTO(int i5, String str, String str2, String str3, String str4, String str5, double d5, double d6, LocalDateTime localDateTime, SerializationConstructorMarker serializationConstructorMarker) {
        if (255 != (i5 & Function.USE_VARARGS)) {
            PluginExceptionsKt.throwMissingFieldException(i5, Function.USE_VARARGS, VehicleDTO$$serializer.INSTANCE.getDescriptor());
        }
        this.vehicleId = str;
        this.name = str2;
        this.licensePlate = str3;
        this.manufacturer = str4;
        this.model = str5;
        this.heightInMeters = d5;
        this.lengthInMeters = d6;
        this.lastUsed = localDateTime;
    }

    public static /* synthetic */ void getHeightInMeters$annotations() {
    }

    @Serializable(with = LocalDateTimeSerializer.class)
    public static /* synthetic */ void getLastUsed$annotations() {
    }

    public static /* synthetic */ void getLengthInMeters$annotations() {
    }

    public static final /* synthetic */ void write$Self$api_kombardoProd(VehicleDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.vehicleId);
        output.encodeStringElement(serialDesc, 1, self.name);
        output.encodeStringElement(serialDesc, 2, self.licensePlate);
        output.encodeStringElement(serialDesc, 3, self.manufacturer);
        output.encodeStringElement(serialDesc, 4, self.model);
        output.encodeDoubleElement(serialDesc, 5, self.heightInMeters);
        output.encodeDoubleElement(serialDesc, 6, self.lengthInMeters);
        output.encodeNullableSerializableElement(serialDesc, 7, LocalDateTimeSerializer.INSTANCE, self.lastUsed);
    }

    /* renamed from: component1, reason: from getter */
    public final String getVehicleId() {
        return this.vehicleId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final String getLicensePlate() {
        return this.licensePlate;
    }

    /* renamed from: component4, reason: from getter */
    public final String getManufacturer() {
        return this.manufacturer;
    }

    /* renamed from: component5, reason: from getter */
    public final String getModel() {
        return this.model;
    }

    /* renamed from: component6, reason: from getter */
    public final double getHeightInMeters() {
        return this.heightInMeters;
    }

    /* renamed from: component7, reason: from getter */
    public final double getLengthInMeters() {
        return this.lengthInMeters;
    }

    /* renamed from: component8, reason: from getter */
    public final LocalDateTime getLastUsed() {
        return this.lastUsed;
    }

    public final VehicleDTO copy(String vehicleId, String name, String licensePlate, String manufacturer, String model, double heightInMeters, double lengthInMeters, LocalDateTime lastUsed) {
        Intrinsics.checkNotNullParameter(vehicleId, "vehicleId");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(licensePlate, "licensePlate");
        Intrinsics.checkNotNullParameter(manufacturer, "manufacturer");
        Intrinsics.checkNotNullParameter(model, "model");
        return new VehicleDTO(vehicleId, name, licensePlate, manufacturer, model, heightInMeters, lengthInMeters, lastUsed);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VehicleDTO)) {
            return false;
        }
        VehicleDTO vehicleDTO = (VehicleDTO) other;
        return Intrinsics.areEqual(this.vehicleId, vehicleDTO.vehicleId) && Intrinsics.areEqual(this.name, vehicleDTO.name) && Intrinsics.areEqual(this.licensePlate, vehicleDTO.licensePlate) && Intrinsics.areEqual(this.manufacturer, vehicleDTO.manufacturer) && Intrinsics.areEqual(this.model, vehicleDTO.model) && Double.compare(this.heightInMeters, vehicleDTO.heightInMeters) == 0 && Double.compare(this.lengthInMeters, vehicleDTO.lengthInMeters) == 0 && Intrinsics.areEqual(this.lastUsed, vehicleDTO.lastUsed);
    }

    public final double getHeightInMeters() {
        return this.heightInMeters;
    }

    public final LocalDateTime getLastUsed() {
        return this.lastUsed;
    }

    public final double getLengthInMeters() {
        return this.lengthInMeters;
    }

    public final String getLicensePlate() {
        return this.licensePlate;
    }

    public final String getManufacturer() {
        return this.manufacturer;
    }

    public final String getModel() {
        return this.model;
    }

    public final String getName() {
        return this.name;
    }

    public final String getVehicleId() {
        return this.vehicleId;
    }

    public int hashCode() {
        int hashCode = ((((((((((((this.vehicleId.hashCode() * 31) + this.name.hashCode()) * 31) + this.licensePlate.hashCode()) * 31) + this.manufacturer.hashCode()) * 31) + this.model.hashCode()) * 31) + Double.hashCode(this.heightInMeters)) * 31) + Double.hashCode(this.lengthInMeters)) * 31;
        LocalDateTime localDateTime = this.lastUsed;
        return hashCode + (localDateTime == null ? 0 : localDateTime.hashCode());
    }

    public String toString() {
        return "VehicleDTO(vehicleId=" + this.vehicleId + ", name=" + this.name + ", licensePlate=" + this.licensePlate + ", manufacturer=" + this.manufacturer + ", model=" + this.model + ", heightInMeters=" + this.heightInMeters + ", lengthInMeters=" + this.lengthInMeters + ", lastUsed=" + this.lastUsed + ")";
    }

    public VehicleDTO(String vehicleId, String name, String licensePlate, String manufacturer, String model, double d5, double d6, LocalDateTime localDateTime) {
        Intrinsics.checkNotNullParameter(vehicleId, "vehicleId");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(licensePlate, "licensePlate");
        Intrinsics.checkNotNullParameter(manufacturer, "manufacturer");
        Intrinsics.checkNotNullParameter(model, "model");
        this.vehicleId = vehicleId;
        this.name = name;
        this.licensePlate = licensePlate;
        this.manufacturer = manufacturer;
        this.model = model;
        this.heightInMeters = d5;
        this.lengthInMeters = d6;
        this.lastUsed = localDateTime;
    }
}
