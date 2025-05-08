package dk.molslinjen.api.services.account.vehicle.request;

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

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000  2\u00020\u0001:\u0002\u001f B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B/\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0005\u0010\u000bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\bHÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J%\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0001¢\u0006\u0002\b\u001eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006!"}, d2 = {"Ldk/molslinjen/api/services/account/vehicle/request/ValidateVehicleRequestParameter;", BuildConfig.FLAVOR, "licensePlate", BuildConfig.FLAVOR, "transportId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getLicensePlate", "()Ljava/lang/String;", "getTransportId", "component1", "component2", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class ValidateVehicleRequestParameter {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String licensePlate;
    private final String transportId;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/account/vehicle/request/ValidateVehicleRequestParameter$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/account/vehicle/request/ValidateVehicleRequestParameter;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<ValidateVehicleRequestParameter> serializer() {
            return ValidateVehicleRequestParameter$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ ValidateVehicleRequestParameter(int i5, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i5 & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 3, ValidateVehicleRequestParameter$$serializer.INSTANCE.getDescriptor());
        }
        this.licensePlate = str;
        this.transportId = str2;
    }

    public static /* synthetic */ ValidateVehicleRequestParameter copy$default(ValidateVehicleRequestParameter validateVehicleRequestParameter, String str, String str2, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = validateVehicleRequestParameter.licensePlate;
        }
        if ((i5 & 2) != 0) {
            str2 = validateVehicleRequestParameter.transportId;
        }
        return validateVehicleRequestParameter.copy(str, str2);
    }

    public static final /* synthetic */ void write$Self$api_kombardoProd(ValidateVehicleRequestParameter self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.licensePlate);
        output.encodeStringElement(serialDesc, 1, self.transportId);
    }

    /* renamed from: component1, reason: from getter */
    public final String getLicensePlate() {
        return this.licensePlate;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTransportId() {
        return this.transportId;
    }

    public final ValidateVehicleRequestParameter copy(String licensePlate, String transportId) {
        Intrinsics.checkNotNullParameter(licensePlate, "licensePlate");
        Intrinsics.checkNotNullParameter(transportId, "transportId");
        return new ValidateVehicleRequestParameter(licensePlate, transportId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ValidateVehicleRequestParameter)) {
            return false;
        }
        ValidateVehicleRequestParameter validateVehicleRequestParameter = (ValidateVehicleRequestParameter) other;
        return Intrinsics.areEqual(this.licensePlate, validateVehicleRequestParameter.licensePlate) && Intrinsics.areEqual(this.transportId, validateVehicleRequestParameter.transportId);
    }

    public final String getLicensePlate() {
        return this.licensePlate;
    }

    public final String getTransportId() {
        return this.transportId;
    }

    public int hashCode() {
        return (this.licensePlate.hashCode() * 31) + this.transportId.hashCode();
    }

    public String toString() {
        return "ValidateVehicleRequestParameter(licensePlate=" + this.licensePlate + ", transportId=" + this.transportId + ")";
    }

    public ValidateVehicleRequestParameter(String licensePlate, String transportId) {
        Intrinsics.checkNotNullParameter(licensePlate, "licensePlate");
        Intrinsics.checkNotNullParameter(transportId, "transportId");
        this.licensePlate = licensePlate;
        this.transportId = transportId;
    }
}
