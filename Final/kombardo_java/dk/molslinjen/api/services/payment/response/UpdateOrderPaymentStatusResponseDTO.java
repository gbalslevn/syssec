package dk.molslinjen.api.services.payment.response;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 !2\u00020\u0001:\u0002 !B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B-\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\tHÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J%\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0001¢\u0006\u0002\b\u001fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\""}, d2 = {"Ldk/molslinjen/api/services/payment/response/UpdateOrderPaymentStatusResponseDTO;", BuildConfig.FLAVOR, "updatedInErp", BuildConfig.FLAVOR, "orderStatus", BuildConfig.FLAVOR, "<init>", "(ZLjava/lang/String;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IZLjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getUpdatedInErp", "()Z", "getOrderStatus", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class UpdateOrderPaymentStatusResponseDTO {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String orderStatus;
    private final boolean updatedInErp;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/payment/response/UpdateOrderPaymentStatusResponseDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/payment/response/UpdateOrderPaymentStatusResponseDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<UpdateOrderPaymentStatusResponseDTO> serializer() {
            return UpdateOrderPaymentStatusResponseDTO$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ UpdateOrderPaymentStatusResponseDTO(int i5, boolean z5, String str, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i5 & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 3, UpdateOrderPaymentStatusResponseDTO$$serializer.INSTANCE.getDescriptor());
        }
        this.updatedInErp = z5;
        this.orderStatus = str;
    }

    public static /* synthetic */ UpdateOrderPaymentStatusResponseDTO copy$default(UpdateOrderPaymentStatusResponseDTO updateOrderPaymentStatusResponseDTO, boolean z5, String str, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            z5 = updateOrderPaymentStatusResponseDTO.updatedInErp;
        }
        if ((i5 & 2) != 0) {
            str = updateOrderPaymentStatusResponseDTO.orderStatus;
        }
        return updateOrderPaymentStatusResponseDTO.copy(z5, str);
    }

    public static final /* synthetic */ void write$Self$api_kombardoProd(UpdateOrderPaymentStatusResponseDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeBooleanElement(serialDesc, 0, self.updatedInErp);
        output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.orderStatus);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getUpdatedInErp() {
        return this.updatedInErp;
    }

    /* renamed from: component2, reason: from getter */
    public final String getOrderStatus() {
        return this.orderStatus;
    }

    public final UpdateOrderPaymentStatusResponseDTO copy(boolean updatedInErp, String orderStatus) {
        return new UpdateOrderPaymentStatusResponseDTO(updatedInErp, orderStatus);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UpdateOrderPaymentStatusResponseDTO)) {
            return false;
        }
        UpdateOrderPaymentStatusResponseDTO updateOrderPaymentStatusResponseDTO = (UpdateOrderPaymentStatusResponseDTO) other;
        return this.updatedInErp == updateOrderPaymentStatusResponseDTO.updatedInErp && Intrinsics.areEqual(this.orderStatus, updateOrderPaymentStatusResponseDTO.orderStatus);
    }

    public final String getOrderStatus() {
        return this.orderStatus;
    }

    public final boolean getUpdatedInErp() {
        return this.updatedInErp;
    }

    public int hashCode() {
        int hashCode = Boolean.hashCode(this.updatedInErp) * 31;
        String str = this.orderStatus;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "UpdateOrderPaymentStatusResponseDTO(updatedInErp=" + this.updatedInErp + ", orderStatus=" + this.orderStatus + ")";
    }

    public UpdateOrderPaymentStatusResponseDTO(boolean z5, String str) {
        this.updatedInErp = z5;
        this.orderStatus = str;
    }
}
