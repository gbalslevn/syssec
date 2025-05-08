package dk.molslinjen.api.services.geolocator.response;

import dk.molslinjen.api.services.geolocator.response.TravelModeDTO;
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

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 %2\u00020\u0001:\u0002$%B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bB5\b\u0010\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0007\u0010\fJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J%\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0001¢\u0006\u0002\b#R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006&"}, d2 = {"Ldk/molslinjen/api/services/geolocator/response/TravelTimeResponseDTO;", BuildConfig.FLAVOR, "travelMode", "Ldk/molslinjen/api/services/geolocator/response/TravelModeDTO;", "travelTimeMinutes", BuildConfig.FLAVOR, "travelTimeHours", "<init>", "(Ldk/molslinjen/api/services/geolocator/response/TravelModeDTO;II)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILdk/molslinjen/api/services/geolocator/response/TravelModeDTO;IILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getTravelMode", "()Ldk/molslinjen/api/services/geolocator/response/TravelModeDTO;", "getTravelTimeMinutes", "()I", "getTravelTimeHours", "component1", "component2", "component3", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", BuildConfig.FLAVOR, "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class TravelTimeResponseDTO {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final TravelModeDTO travelMode;
    private final int travelTimeHours;
    private final int travelTimeMinutes;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/geolocator/response/TravelTimeResponseDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/geolocator/response/TravelTimeResponseDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<TravelTimeResponseDTO> serializer() {
            return TravelTimeResponseDTO$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ TravelTimeResponseDTO(int i5, TravelModeDTO travelModeDTO, int i6, int i7, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (i5 & 7)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 7, TravelTimeResponseDTO$$serializer.INSTANCE.getDescriptor());
        }
        this.travelMode = travelModeDTO;
        this.travelTimeMinutes = i6;
        this.travelTimeHours = i7;
    }

    public static /* synthetic */ TravelTimeResponseDTO copy$default(TravelTimeResponseDTO travelTimeResponseDTO, TravelModeDTO travelModeDTO, int i5, int i6, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            travelModeDTO = travelTimeResponseDTO.travelMode;
        }
        if ((i7 & 2) != 0) {
            i5 = travelTimeResponseDTO.travelTimeMinutes;
        }
        if ((i7 & 4) != 0) {
            i6 = travelTimeResponseDTO.travelTimeHours;
        }
        return travelTimeResponseDTO.copy(travelModeDTO, i5, i6);
    }

    public static final /* synthetic */ void write$Self$api_kombardoProd(TravelTimeResponseDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeSerializableElement(serialDesc, 0, TravelModeDTO.Serializer.INSTANCE, self.travelMode);
        output.encodeIntElement(serialDesc, 1, self.travelTimeMinutes);
        output.encodeIntElement(serialDesc, 2, self.travelTimeHours);
    }

    /* renamed from: component1, reason: from getter */
    public final TravelModeDTO getTravelMode() {
        return this.travelMode;
    }

    /* renamed from: component2, reason: from getter */
    public final int getTravelTimeMinutes() {
        return this.travelTimeMinutes;
    }

    /* renamed from: component3, reason: from getter */
    public final int getTravelTimeHours() {
        return this.travelTimeHours;
    }

    public final TravelTimeResponseDTO copy(TravelModeDTO travelMode, int travelTimeMinutes, int travelTimeHours) {
        Intrinsics.checkNotNullParameter(travelMode, "travelMode");
        return new TravelTimeResponseDTO(travelMode, travelTimeMinutes, travelTimeHours);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TravelTimeResponseDTO)) {
            return false;
        }
        TravelTimeResponseDTO travelTimeResponseDTO = (TravelTimeResponseDTO) other;
        return this.travelMode == travelTimeResponseDTO.travelMode && this.travelTimeMinutes == travelTimeResponseDTO.travelTimeMinutes && this.travelTimeHours == travelTimeResponseDTO.travelTimeHours;
    }

    public final TravelModeDTO getTravelMode() {
        return this.travelMode;
    }

    public final int getTravelTimeHours() {
        return this.travelTimeHours;
    }

    public final int getTravelTimeMinutes() {
        return this.travelTimeMinutes;
    }

    public int hashCode() {
        return (((this.travelMode.hashCode() * 31) + Integer.hashCode(this.travelTimeMinutes)) * 31) + Integer.hashCode(this.travelTimeHours);
    }

    public String toString() {
        return "TravelTimeResponseDTO(travelMode=" + this.travelMode + ", travelTimeMinutes=" + this.travelTimeMinutes + ", travelTimeHours=" + this.travelTimeHours + ")";
    }

    public TravelTimeResponseDTO(TravelModeDTO travelMode, int i5, int i6) {
        Intrinsics.checkNotNullParameter(travelMode, "travelMode");
        this.travelMode = travelMode;
        this.travelTimeMinutes = i5;
        this.travelTimeHours = i6;
    }
}
