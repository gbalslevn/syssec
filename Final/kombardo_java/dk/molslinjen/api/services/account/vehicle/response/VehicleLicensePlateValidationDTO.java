package dk.molslinjen.api.services.account.vehicle.response;

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

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 42\u00020\u0001:\u000234B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fBS\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u000b\u0010\u0011J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0007HÆ\u0003J\t\u0010#\u001a\u00020\u0007HÆ\u0003J\t\u0010$\u001a\u00020\nHÆ\u0003JE\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\u000eHÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001J%\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00002\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0001¢\u0006\u0002\b2R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u001c\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0017\u001a\u0004\b\u001b\u0010\u0019R\u001c\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u001e¨\u00065"}, d2 = {"Ldk/molslinjen/api/services/account/vehicle/response/VehicleLicensePlateValidationDTO;", BuildConfig.FLAVOR, "licensePlate", BuildConfig.FLAVOR, "manufacturer", "model", "heightInMeters", BuildConfig.FLAVOR, "lengthInMeters", "lastUsed", "Lorg/threeten/bp/LocalDateTime;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DDLorg/threeten/bp/LocalDateTime;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;DDLorg/threeten/bp/LocalDateTime;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getLicensePlate", "()Ljava/lang/String;", "getManufacturer", "getModel", "getHeightInMeters$annotations", "()V", "getHeightInMeters", "()D", "getLengthInMeters$annotations", "getLengthInMeters", "getLastUsed$annotations", "getLastUsed", "()Lorg/threeten/bp/LocalDateTime;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class VehicleLicensePlateValidationDTO {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final double heightInMeters;
    private final LocalDateTime lastUsed;
    private final double lengthInMeters;
    private final String licensePlate;
    private final String manufacturer;
    private final String model;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/account/vehicle/response/VehicleLicensePlateValidationDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/account/vehicle/response/VehicleLicensePlateValidationDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<VehicleLicensePlateValidationDTO> serializer() {
            return VehicleLicensePlateValidationDTO$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ VehicleLicensePlateValidationDTO(int i5, String str, String str2, String str3, double d5, double d6, LocalDateTime localDateTime, SerializationConstructorMarker serializationConstructorMarker) {
        if (63 != (i5 & 63)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 63, VehicleLicensePlateValidationDTO$$serializer.INSTANCE.getDescriptor());
        }
        this.licensePlate = str;
        this.manufacturer = str2;
        this.model = str3;
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

    public static final /* synthetic */ void write$Self$api_kombardoProd(VehicleLicensePlateValidationDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.licensePlate);
        output.encodeStringElement(serialDesc, 1, self.manufacturer);
        output.encodeStringElement(serialDesc, 2, self.model);
        output.encodeDoubleElement(serialDesc, 3, self.heightInMeters);
        output.encodeDoubleElement(serialDesc, 4, self.lengthInMeters);
        output.encodeSerializableElement(serialDesc, 5, LocalDateTimeSerializer.INSTANCE, self.lastUsed);
    }

    /* renamed from: component1, reason: from getter */
    public final String getLicensePlate() {
        return this.licensePlate;
    }

    /* renamed from: component2, reason: from getter */
    public final String getManufacturer() {
        return this.manufacturer;
    }

    /* renamed from: component3, reason: from getter */
    public final String getModel() {
        return this.model;
    }

    /* renamed from: component4, reason: from getter */
    public final double getHeightInMeters() {
        return this.heightInMeters;
    }

    /* renamed from: component5, reason: from getter */
    public final double getLengthInMeters() {
        return this.lengthInMeters;
    }

    /* renamed from: component6, reason: from getter */
    public final LocalDateTime getLastUsed() {
        return this.lastUsed;
    }

    public final VehicleLicensePlateValidationDTO copy(String licensePlate, String manufacturer, String model, double heightInMeters, double lengthInMeters, LocalDateTime lastUsed) {
        Intrinsics.checkNotNullParameter(licensePlate, "licensePlate");
        Intrinsics.checkNotNullParameter(manufacturer, "manufacturer");
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(lastUsed, "lastUsed");
        return new VehicleLicensePlateValidationDTO(licensePlate, manufacturer, model, heightInMeters, lengthInMeters, lastUsed);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VehicleLicensePlateValidationDTO)) {
            return false;
        }
        VehicleLicensePlateValidationDTO vehicleLicensePlateValidationDTO = (VehicleLicensePlateValidationDTO) other;
        return Intrinsics.areEqual(this.licensePlate, vehicleLicensePlateValidationDTO.licensePlate) && Intrinsics.areEqual(this.manufacturer, vehicleLicensePlateValidationDTO.manufacturer) && Intrinsics.areEqual(this.model, vehicleLicensePlateValidationDTO.model) && Double.compare(this.heightInMeters, vehicleLicensePlateValidationDTO.heightInMeters) == 0 && Double.compare(this.lengthInMeters, vehicleLicensePlateValidationDTO.lengthInMeters) == 0 && Intrinsics.areEqual(this.lastUsed, vehicleLicensePlateValidationDTO.lastUsed);
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

    public int hashCode() {
        return (((((((((this.licensePlate.hashCode() * 31) + this.manufacturer.hashCode()) * 31) + this.model.hashCode()) * 31) + Double.hashCode(this.heightInMeters)) * 31) + Double.hashCode(this.lengthInMeters)) * 31) + this.lastUsed.hashCode();
    }

    public String toString() {
        return "VehicleLicensePlateValidationDTO(licensePlate=" + this.licensePlate + ", manufacturer=" + this.manufacturer + ", model=" + this.model + ", heightInMeters=" + this.heightInMeters + ", lengthInMeters=" + this.lengthInMeters + ", lastUsed=" + this.lastUsed + ")";
    }

    public VehicleLicensePlateValidationDTO(String licensePlate, String manufacturer, String model, double d5, double d6, LocalDateTime lastUsed) {
        Intrinsics.checkNotNullParameter(licensePlate, "licensePlate");
        Intrinsics.checkNotNullParameter(manufacturer, "manufacturer");
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(lastUsed, "lastUsed");
        this.licensePlate = licensePlate;
        this.manufacturer = manufacturer;
        this.model = model;
        this.heightInMeters = d5;
        this.lengthInMeters = d6;
        this.lastUsed = lastUsed;
    }
}
