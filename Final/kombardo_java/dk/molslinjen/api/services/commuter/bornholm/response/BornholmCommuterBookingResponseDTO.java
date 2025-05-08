package dk.molslinjen.api.services.commuter.bornholm.response;

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

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 ,2\u00020\u0001:\u0002+,B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bBK\b\u0010\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\n\u0010\u0010J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\bHÆ\u0003J\t\u0010\u001d\u001a\u00020\bHÆ\u0003J=\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001f\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\rHÖ\u0001J\t\u0010\"\u001a\u00020\bHÖ\u0001J%\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00002\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0001¢\u0006\u0002\b*R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017¨\u0006-"}, d2 = {"Ldk/molslinjen/api/services/commuter/bornholm/response/BornholmCommuterBookingResponseDTO;", BuildConfig.FLAVOR, "deleteAllowed", BuildConfig.FLAVOR, "outbound", "Ldk/molslinjen/api/services/commuter/bornholm/response/BornholmCommuterTicketResponseDTO;", "inbound", "reservationNumber", BuildConfig.FLAVOR, "telephone", "<init>", "(ZLdk/molslinjen/api/services/commuter/bornholm/response/BornholmCommuterTicketResponseDTO;Ldk/molslinjen/api/services/commuter/bornholm/response/BornholmCommuterTicketResponseDTO;Ljava/lang/String;Ljava/lang/String;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IZLdk/molslinjen/api/services/commuter/bornholm/response/BornholmCommuterTicketResponseDTO;Ldk/molslinjen/api/services/commuter/bornholm/response/BornholmCommuterTicketResponseDTO;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getDeleteAllowed", "()Z", "getOutbound", "()Ldk/molslinjen/api/services/commuter/bornholm/response/BornholmCommuterTicketResponseDTO;", "getInbound", "getReservationNumber", "()Ljava/lang/String;", "getTelephone", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class BornholmCommuterBookingResponseDTO {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final boolean deleteAllowed;
    private final BornholmCommuterTicketResponseDTO inbound;
    private final BornholmCommuterTicketResponseDTO outbound;
    private final String reservationNumber;
    private final String telephone;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/commuter/bornholm/response/BornholmCommuterBookingResponseDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/commuter/bornholm/response/BornholmCommuterBookingResponseDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<BornholmCommuterBookingResponseDTO> serializer() {
            return BornholmCommuterBookingResponseDTO$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ BornholmCommuterBookingResponseDTO(int i5, boolean z5, BornholmCommuterTicketResponseDTO bornholmCommuterTicketResponseDTO, BornholmCommuterTicketResponseDTO bornholmCommuterTicketResponseDTO2, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
        if (31 != (i5 & 31)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 31, BornholmCommuterBookingResponseDTO$$serializer.INSTANCE.getDescriptor());
        }
        this.deleteAllowed = z5;
        this.outbound = bornholmCommuterTicketResponseDTO;
        this.inbound = bornholmCommuterTicketResponseDTO2;
        this.reservationNumber = str;
        this.telephone = str2;
    }

    public static /* synthetic */ BornholmCommuterBookingResponseDTO copy$default(BornholmCommuterBookingResponseDTO bornholmCommuterBookingResponseDTO, boolean z5, BornholmCommuterTicketResponseDTO bornholmCommuterTicketResponseDTO, BornholmCommuterTicketResponseDTO bornholmCommuterTicketResponseDTO2, String str, String str2, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            z5 = bornholmCommuterBookingResponseDTO.deleteAllowed;
        }
        if ((i5 & 2) != 0) {
            bornholmCommuterTicketResponseDTO = bornholmCommuterBookingResponseDTO.outbound;
        }
        BornholmCommuterTicketResponseDTO bornholmCommuterTicketResponseDTO3 = bornholmCommuterTicketResponseDTO;
        if ((i5 & 4) != 0) {
            bornholmCommuterTicketResponseDTO2 = bornholmCommuterBookingResponseDTO.inbound;
        }
        BornholmCommuterTicketResponseDTO bornholmCommuterTicketResponseDTO4 = bornholmCommuterTicketResponseDTO2;
        if ((i5 & 8) != 0) {
            str = bornholmCommuterBookingResponseDTO.reservationNumber;
        }
        String str3 = str;
        if ((i5 & 16) != 0) {
            str2 = bornholmCommuterBookingResponseDTO.telephone;
        }
        return bornholmCommuterBookingResponseDTO.copy(z5, bornholmCommuterTicketResponseDTO3, bornholmCommuterTicketResponseDTO4, str3, str2);
    }

    public static final /* synthetic */ void write$Self$api_kombardoProd(BornholmCommuterBookingResponseDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeBooleanElement(serialDesc, 0, self.deleteAllowed);
        BornholmCommuterTicketResponseDTO$$serializer bornholmCommuterTicketResponseDTO$$serializer = BornholmCommuterTicketResponseDTO$$serializer.INSTANCE;
        output.encodeSerializableElement(serialDesc, 1, bornholmCommuterTicketResponseDTO$$serializer, self.outbound);
        output.encodeNullableSerializableElement(serialDesc, 2, bornholmCommuterTicketResponseDTO$$serializer, self.inbound);
        output.encodeStringElement(serialDesc, 3, self.reservationNumber);
        output.encodeStringElement(serialDesc, 4, self.telephone);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getDeleteAllowed() {
        return this.deleteAllowed;
    }

    /* renamed from: component2, reason: from getter */
    public final BornholmCommuterTicketResponseDTO getOutbound() {
        return this.outbound;
    }

    /* renamed from: component3, reason: from getter */
    public final BornholmCommuterTicketResponseDTO getInbound() {
        return this.inbound;
    }

    /* renamed from: component4, reason: from getter */
    public final String getReservationNumber() {
        return this.reservationNumber;
    }

    /* renamed from: component5, reason: from getter */
    public final String getTelephone() {
        return this.telephone;
    }

    public final BornholmCommuterBookingResponseDTO copy(boolean deleteAllowed, BornholmCommuterTicketResponseDTO outbound, BornholmCommuterTicketResponseDTO inbound, String reservationNumber, String telephone) {
        Intrinsics.checkNotNullParameter(outbound, "outbound");
        Intrinsics.checkNotNullParameter(reservationNumber, "reservationNumber");
        Intrinsics.checkNotNullParameter(telephone, "telephone");
        return new BornholmCommuterBookingResponseDTO(deleteAllowed, outbound, inbound, reservationNumber, telephone);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BornholmCommuterBookingResponseDTO)) {
            return false;
        }
        BornholmCommuterBookingResponseDTO bornholmCommuterBookingResponseDTO = (BornholmCommuterBookingResponseDTO) other;
        return this.deleteAllowed == bornholmCommuterBookingResponseDTO.deleteAllowed && Intrinsics.areEqual(this.outbound, bornholmCommuterBookingResponseDTO.outbound) && Intrinsics.areEqual(this.inbound, bornholmCommuterBookingResponseDTO.inbound) && Intrinsics.areEqual(this.reservationNumber, bornholmCommuterBookingResponseDTO.reservationNumber) && Intrinsics.areEqual(this.telephone, bornholmCommuterBookingResponseDTO.telephone);
    }

    public final boolean getDeleteAllowed() {
        return this.deleteAllowed;
    }

    public final BornholmCommuterTicketResponseDTO getInbound() {
        return this.inbound;
    }

    public final BornholmCommuterTicketResponseDTO getOutbound() {
        return this.outbound;
    }

    public final String getReservationNumber() {
        return this.reservationNumber;
    }

    public final String getTelephone() {
        return this.telephone;
    }

    public int hashCode() {
        int hashCode = ((Boolean.hashCode(this.deleteAllowed) * 31) + this.outbound.hashCode()) * 31;
        BornholmCommuterTicketResponseDTO bornholmCommuterTicketResponseDTO = this.inbound;
        return ((((hashCode + (bornholmCommuterTicketResponseDTO == null ? 0 : bornholmCommuterTicketResponseDTO.hashCode())) * 31) + this.reservationNumber.hashCode()) * 31) + this.telephone.hashCode();
    }

    public String toString() {
        return "BornholmCommuterBookingResponseDTO(deleteAllowed=" + this.deleteAllowed + ", outbound=" + this.outbound + ", inbound=" + this.inbound + ", reservationNumber=" + this.reservationNumber + ", telephone=" + this.telephone + ")";
    }

    public BornholmCommuterBookingResponseDTO(boolean z5, BornholmCommuterTicketResponseDTO outbound, BornholmCommuterTicketResponseDTO bornholmCommuterTicketResponseDTO, String reservationNumber, String telephone) {
        Intrinsics.checkNotNullParameter(outbound, "outbound");
        Intrinsics.checkNotNullParameter(reservationNumber, "reservationNumber");
        Intrinsics.checkNotNullParameter(telephone, "telephone");
        this.deleteAllowed = z5;
        this.outbound = outbound;
        this.inbound = bornholmCommuterTicketResponseDTO;
        this.reservationNumber = reservationNumber;
        this.telephone = telephone;
    }
}
