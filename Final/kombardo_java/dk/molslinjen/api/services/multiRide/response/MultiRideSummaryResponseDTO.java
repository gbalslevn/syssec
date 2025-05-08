package dk.molslinjen.api.services.multiRide.response;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001d\u001eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B%\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0004\u0010\nJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J%\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0001¢\u0006\u0002\b\u001cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001f"}, d2 = {"Ldk/molslinjen/api/services/multiRide/response/MultiRideSummaryResponseDTO;", BuildConfig.FLAVOR, "multiRideTicket", "Ldk/molslinjen/api/services/multiRide/response/MultiRideCardSummaryResponseDTO;", "<init>", "(Ldk/molslinjen/api/services/multiRide/response/MultiRideCardSummaryResponseDTO;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILdk/molslinjen/api/services/multiRide/response/MultiRideCardSummaryResponseDTO;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getMultiRideTicket", "()Ldk/molslinjen/api/services/multiRide/response/MultiRideCardSummaryResponseDTO;", "component1", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", BuildConfig.FLAVOR, "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class MultiRideSummaryResponseDTO {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final MultiRideCardSummaryResponseDTO multiRideTicket;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/multiRide/response/MultiRideSummaryResponseDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/multiRide/response/MultiRideSummaryResponseDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<MultiRideSummaryResponseDTO> serializer() {
            return MultiRideSummaryResponseDTO$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ MultiRideSummaryResponseDTO(int i5, MultiRideCardSummaryResponseDTO multiRideCardSummaryResponseDTO, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i5 & 1)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 1, MultiRideSummaryResponseDTO$$serializer.INSTANCE.getDescriptor());
        }
        this.multiRideTicket = multiRideCardSummaryResponseDTO;
    }

    public static /* synthetic */ MultiRideSummaryResponseDTO copy$default(MultiRideSummaryResponseDTO multiRideSummaryResponseDTO, MultiRideCardSummaryResponseDTO multiRideCardSummaryResponseDTO, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            multiRideCardSummaryResponseDTO = multiRideSummaryResponseDTO.multiRideTicket;
        }
        return multiRideSummaryResponseDTO.copy(multiRideCardSummaryResponseDTO);
    }

    /* renamed from: component1, reason: from getter */
    public final MultiRideCardSummaryResponseDTO getMultiRideTicket() {
        return this.multiRideTicket;
    }

    public final MultiRideSummaryResponseDTO copy(MultiRideCardSummaryResponseDTO multiRideTicket) {
        Intrinsics.checkNotNullParameter(multiRideTicket, "multiRideTicket");
        return new MultiRideSummaryResponseDTO(multiRideTicket);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof MultiRideSummaryResponseDTO) && Intrinsics.areEqual(this.multiRideTicket, ((MultiRideSummaryResponseDTO) other).multiRideTicket);
    }

    public final MultiRideCardSummaryResponseDTO getMultiRideTicket() {
        return this.multiRideTicket;
    }

    public int hashCode() {
        return this.multiRideTicket.hashCode();
    }

    public String toString() {
        return "MultiRideSummaryResponseDTO(multiRideTicket=" + this.multiRideTicket + ")";
    }

    public MultiRideSummaryResponseDTO(MultiRideCardSummaryResponseDTO multiRideTicket) {
        Intrinsics.checkNotNullParameter(multiRideTicket, "multiRideTicket");
        this.multiRideTicket = multiRideTicket;
    }
}
