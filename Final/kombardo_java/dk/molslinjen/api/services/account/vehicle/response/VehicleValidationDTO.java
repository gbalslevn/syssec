package dk.molslinjen.api.services.account.vehicle.response;

import dk.molslinjen.api.services.account.vehicle.response.LicensePlateValidationResultResponseDTO;
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

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 %2\u00020\u0001:\u0002$%B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bB9\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J'\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\nHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J%\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0001¢\u0006\u0002\b#R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006&"}, d2 = {"Ldk/molslinjen/api/services/account/vehicle/response/VehicleValidationDTO;", BuildConfig.FLAVOR, "licensePlate", BuildConfig.FLAVOR, "transportId", "validationResult", "Ldk/molslinjen/api/services/account/vehicle/response/LicensePlateValidationResultResponseDTO;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/services/account/vehicle/response/LicensePlateValidationResultResponseDTO;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/services/account/vehicle/response/LicensePlateValidationResultResponseDTO;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getLicensePlate", "()Ljava/lang/String;", "getTransportId", "getValidationResult", "()Ldk/molslinjen/api/services/account/vehicle/response/LicensePlateValidationResultResponseDTO;", "component1", "component2", "component3", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class VehicleValidationDTO {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String licensePlate;
    private final String transportId;
    private final LicensePlateValidationResultResponseDTO validationResult;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/account/vehicle/response/VehicleValidationDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/account/vehicle/response/VehicleValidationDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<VehicleValidationDTO> serializer() {
            return VehicleValidationDTO$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ VehicleValidationDTO(int i5, String str, String str2, LicensePlateValidationResultResponseDTO licensePlateValidationResultResponseDTO, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (i5 & 7)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 7, VehicleValidationDTO$$serializer.INSTANCE.getDescriptor());
        }
        this.licensePlate = str;
        this.transportId = str2;
        this.validationResult = licensePlateValidationResultResponseDTO;
    }

    public static /* synthetic */ VehicleValidationDTO copy$default(VehicleValidationDTO vehicleValidationDTO, String str, String str2, LicensePlateValidationResultResponseDTO licensePlateValidationResultResponseDTO, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = vehicleValidationDTO.licensePlate;
        }
        if ((i5 & 2) != 0) {
            str2 = vehicleValidationDTO.transportId;
        }
        if ((i5 & 4) != 0) {
            licensePlateValidationResultResponseDTO = vehicleValidationDTO.validationResult;
        }
        return vehicleValidationDTO.copy(str, str2, licensePlateValidationResultResponseDTO);
    }

    public static final /* synthetic */ void write$Self$api_kombardoProd(VehicleValidationDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.licensePlate);
        output.encodeStringElement(serialDesc, 1, self.transportId);
        output.encodeSerializableElement(serialDesc, 2, LicensePlateValidationResultResponseDTO.Serializer.INSTANCE, self.validationResult);
    }

    /* renamed from: component1, reason: from getter */
    public final String getLicensePlate() {
        return this.licensePlate;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTransportId() {
        return this.transportId;
    }

    /* renamed from: component3, reason: from getter */
    public final LicensePlateValidationResultResponseDTO getValidationResult() {
        return this.validationResult;
    }

    public final VehicleValidationDTO copy(String licensePlate, String transportId, LicensePlateValidationResultResponseDTO validationResult) {
        Intrinsics.checkNotNullParameter(licensePlate, "licensePlate");
        Intrinsics.checkNotNullParameter(transportId, "transportId");
        Intrinsics.checkNotNullParameter(validationResult, "validationResult");
        return new VehicleValidationDTO(licensePlate, transportId, validationResult);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VehicleValidationDTO)) {
            return false;
        }
        VehicleValidationDTO vehicleValidationDTO = (VehicleValidationDTO) other;
        return Intrinsics.areEqual(this.licensePlate, vehicleValidationDTO.licensePlate) && Intrinsics.areEqual(this.transportId, vehicleValidationDTO.transportId) && this.validationResult == vehicleValidationDTO.validationResult;
    }

    public final String getLicensePlate() {
        return this.licensePlate;
    }

    public final String getTransportId() {
        return this.transportId;
    }

    public final LicensePlateValidationResultResponseDTO getValidationResult() {
        return this.validationResult;
    }

    public int hashCode() {
        return (((this.licensePlate.hashCode() * 31) + this.transportId.hashCode()) * 31) + this.validationResult.hashCode();
    }

    public String toString() {
        return "VehicleValidationDTO(licensePlate=" + this.licensePlate + ", transportId=" + this.transportId + ", validationResult=" + this.validationResult + ")";
    }

    public VehicleValidationDTO(String licensePlate, String transportId, LicensePlateValidationResultResponseDTO validationResult) {
        Intrinsics.checkNotNullParameter(licensePlate, "licensePlate");
        Intrinsics.checkNotNullParameter(transportId, "transportId");
        Intrinsics.checkNotNullParameter(validationResult, "validationResult");
        this.licensePlate = licensePlate;
        this.transportId = transportId;
        this.validationResult = validationResult;
    }
}
