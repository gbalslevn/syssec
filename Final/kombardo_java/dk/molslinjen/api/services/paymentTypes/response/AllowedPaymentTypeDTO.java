package dk.molslinjen.api.services.paymentTypes.response;

import dk.molslinjen.api.services.paymentTypes.response.PaymentTypeDTO;
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

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0002!\"B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B/\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\tHÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J%\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0001¢\u0006\u0002\b R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006#"}, d2 = {"Ldk/molslinjen/api/services/paymentTypes/response/AllowedPaymentTypeDTO;", BuildConfig.FLAVOR, "type", "Ldk/molslinjen/api/services/paymentTypes/response/PaymentTypeDTO;", "name", BuildConfig.FLAVOR, "<init>", "(Ldk/molslinjen/api/services/paymentTypes/response/PaymentTypeDTO;Ljava/lang/String;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILdk/molslinjen/api/services/paymentTypes/response/PaymentTypeDTO;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getType", "()Ldk/molslinjen/api/services/paymentTypes/response/PaymentTypeDTO;", "getName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class AllowedPaymentTypeDTO {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String name;
    private final PaymentTypeDTO type;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/paymentTypes/response/AllowedPaymentTypeDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/paymentTypes/response/AllowedPaymentTypeDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<AllowedPaymentTypeDTO> serializer() {
            return AllowedPaymentTypeDTO$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ AllowedPaymentTypeDTO(int i5, PaymentTypeDTO paymentTypeDTO, String str, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i5 & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 3, AllowedPaymentTypeDTO$$serializer.INSTANCE.getDescriptor());
        }
        this.type = paymentTypeDTO;
        this.name = str;
    }

    public static /* synthetic */ AllowedPaymentTypeDTO copy$default(AllowedPaymentTypeDTO allowedPaymentTypeDTO, PaymentTypeDTO paymentTypeDTO, String str, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            paymentTypeDTO = allowedPaymentTypeDTO.type;
        }
        if ((i5 & 2) != 0) {
            str = allowedPaymentTypeDTO.name;
        }
        return allowedPaymentTypeDTO.copy(paymentTypeDTO, str);
    }

    public static final /* synthetic */ void write$Self$api_kombardoProd(AllowedPaymentTypeDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeSerializableElement(serialDesc, 0, PaymentTypeDTO.Serializer.INSTANCE, self.type);
        output.encodeStringElement(serialDesc, 1, self.name);
    }

    /* renamed from: component1, reason: from getter */
    public final PaymentTypeDTO getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final AllowedPaymentTypeDTO copy(PaymentTypeDTO type, String name) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(name, "name");
        return new AllowedPaymentTypeDTO(type, name);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AllowedPaymentTypeDTO)) {
            return false;
        }
        AllowedPaymentTypeDTO allowedPaymentTypeDTO = (AllowedPaymentTypeDTO) other;
        return this.type == allowedPaymentTypeDTO.type && Intrinsics.areEqual(this.name, allowedPaymentTypeDTO.name);
    }

    public final String getName() {
        return this.name;
    }

    public final PaymentTypeDTO getType() {
        return this.type;
    }

    public int hashCode() {
        return (this.type.hashCode() * 31) + this.name.hashCode();
    }

    public String toString() {
        return "AllowedPaymentTypeDTO(type=" + this.type + ", name=" + this.name + ")";
    }

    public AllowedPaymentTypeDTO(PaymentTypeDTO type, String name) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(name, "name");
        this.type = type;
        this.name = name;
    }
}
