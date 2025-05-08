package dk.molslinjen.api.services.multiRide.response;

import com.sdk.growthbook.utils.Constants;
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

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 *2\u00020\u0001:\u0002)*B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tBC\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J3\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u000bHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001J%\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0001¢\u0006\u0002\b(R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0012¨\u0006+"}, d2 = {"Ldk/molslinjen/api/services/multiRide/response/MultiRideBookingResponseDTO;", BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, BuildConfig.FLAVOR, "outbound", "Ldk/molslinjen/api/services/multiRide/response/MultiRideBookingTicketResponseDTO;", "phone", "inbound", "<init>", "(Ljava/lang/String;Ldk/molslinjen/api/services/multiRide/response/MultiRideBookingTicketResponseDTO;Ljava/lang/String;Ldk/molslinjen/api/services/multiRide/response/MultiRideBookingTicketResponseDTO;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ldk/molslinjen/api/services/multiRide/response/MultiRideBookingTicketResponseDTO;Ljava/lang/String;Ldk/molslinjen/api/services/multiRide/response/MultiRideBookingTicketResponseDTO;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId", "()Ljava/lang/String;", "getOutbound", "()Ldk/molslinjen/api/services/multiRide/response/MultiRideBookingTicketResponseDTO;", "getPhone", "getInbound$annotations", "()V", "getInbound", "component1", "component2", "component3", "component4", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class MultiRideBookingResponseDTO {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String id;
    private final MultiRideBookingTicketResponseDTO inbound;
    private final MultiRideBookingTicketResponseDTO outbound;
    private final String phone;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/multiRide/response/MultiRideBookingResponseDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/multiRide/response/MultiRideBookingResponseDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<MultiRideBookingResponseDTO> serializer() {
            return MultiRideBookingResponseDTO$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ MultiRideBookingResponseDTO(int i5, String str, MultiRideBookingTicketResponseDTO multiRideBookingTicketResponseDTO, String str2, MultiRideBookingTicketResponseDTO multiRideBookingTicketResponseDTO2, SerializationConstructorMarker serializationConstructorMarker) {
        if (15 != (i5 & 15)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 15, MultiRideBookingResponseDTO$$serializer.INSTANCE.getDescriptor());
        }
        this.id = str;
        this.outbound = multiRideBookingTicketResponseDTO;
        this.phone = str2;
        this.inbound = multiRideBookingTicketResponseDTO2;
    }

    public static /* synthetic */ MultiRideBookingResponseDTO copy$default(MultiRideBookingResponseDTO multiRideBookingResponseDTO, String str, MultiRideBookingTicketResponseDTO multiRideBookingTicketResponseDTO, String str2, MultiRideBookingTicketResponseDTO multiRideBookingTicketResponseDTO2, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = multiRideBookingResponseDTO.id;
        }
        if ((i5 & 2) != 0) {
            multiRideBookingTicketResponseDTO = multiRideBookingResponseDTO.outbound;
        }
        if ((i5 & 4) != 0) {
            str2 = multiRideBookingResponseDTO.phone;
        }
        if ((i5 & 8) != 0) {
            multiRideBookingTicketResponseDTO2 = multiRideBookingResponseDTO.inbound;
        }
        return multiRideBookingResponseDTO.copy(str, multiRideBookingTicketResponseDTO, str2, multiRideBookingTicketResponseDTO2);
    }

    public static /* synthetic */ void getInbound$annotations() {
    }

    public static final /* synthetic */ void write$Self$api_kombardoProd(MultiRideBookingResponseDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.id);
        MultiRideBookingTicketResponseDTO$$serializer multiRideBookingTicketResponseDTO$$serializer = MultiRideBookingTicketResponseDTO$$serializer.INSTANCE;
        output.encodeSerializableElement(serialDesc, 1, multiRideBookingTicketResponseDTO$$serializer, self.outbound);
        output.encodeStringElement(serialDesc, 2, self.phone);
        output.encodeNullableSerializableElement(serialDesc, 3, multiRideBookingTicketResponseDTO$$serializer, self.inbound);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final MultiRideBookingTicketResponseDTO getOutbound() {
        return this.outbound;
    }

    /* renamed from: component3, reason: from getter */
    public final String getPhone() {
        return this.phone;
    }

    /* renamed from: component4, reason: from getter */
    public final MultiRideBookingTicketResponseDTO getInbound() {
        return this.inbound;
    }

    public final MultiRideBookingResponseDTO copy(String id, MultiRideBookingTicketResponseDTO outbound, String phone, MultiRideBookingTicketResponseDTO inbound) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(outbound, "outbound");
        Intrinsics.checkNotNullParameter(phone, "phone");
        return new MultiRideBookingResponseDTO(id, outbound, phone, inbound);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MultiRideBookingResponseDTO)) {
            return false;
        }
        MultiRideBookingResponseDTO multiRideBookingResponseDTO = (MultiRideBookingResponseDTO) other;
        return Intrinsics.areEqual(this.id, multiRideBookingResponseDTO.id) && Intrinsics.areEqual(this.outbound, multiRideBookingResponseDTO.outbound) && Intrinsics.areEqual(this.phone, multiRideBookingResponseDTO.phone) && Intrinsics.areEqual(this.inbound, multiRideBookingResponseDTO.inbound);
    }

    public final String getId() {
        return this.id;
    }

    public final MultiRideBookingTicketResponseDTO getInbound() {
        return this.inbound;
    }

    public final MultiRideBookingTicketResponseDTO getOutbound() {
        return this.outbound;
    }

    public final String getPhone() {
        return this.phone;
    }

    public int hashCode() {
        int hashCode = ((((this.id.hashCode() * 31) + this.outbound.hashCode()) * 31) + this.phone.hashCode()) * 31;
        MultiRideBookingTicketResponseDTO multiRideBookingTicketResponseDTO = this.inbound;
        return hashCode + (multiRideBookingTicketResponseDTO == null ? 0 : multiRideBookingTicketResponseDTO.hashCode());
    }

    public String toString() {
        return "MultiRideBookingResponseDTO(id=" + this.id + ", outbound=" + this.outbound + ", phone=" + this.phone + ", inbound=" + this.inbound + ")";
    }

    public MultiRideBookingResponseDTO(String id, MultiRideBookingTicketResponseDTO outbound, String phone, MultiRideBookingTicketResponseDTO multiRideBookingTicketResponseDTO) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(outbound, "outbound");
        Intrinsics.checkNotNullParameter(phone, "phone");
        this.id = id;
        this.outbound = outbound;
        this.phone = phone;
        this.inbound = multiRideBookingTicketResponseDTO;
    }
}
