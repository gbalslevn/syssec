package dk.molslinjen.api.shared.response;

import dk.molslinjen.api.shared.response.TicketSurchargeTypeDTO;
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

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0087\b\u0018\u0000 )2\u00020\u0001:\u0002*)B9\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ'\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001f\u001a\u0004\b \u0010\u0018R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010!\u001a\u0004\b\"\u0010#R \u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\t\u0010$\u0012\u0004\b'\u0010(\u001a\u0004\b%\u0010&¨\u0006+"}, d2 = {"Ldk/molslinjen/api/shared/response/TicketSurchargeDTO;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "seen0", BuildConfig.FLAVOR, "name", "Ldk/molslinjen/api/shared/response/PriceWithCurrencyDTO;", "price", "Ldk/molslinjen/api/shared/response/TicketSurchargeTypeDTO;", "type", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "<init>", "(ILjava/lang/String;Ldk/molslinjen/api/shared/response/PriceWithCurrencyDTO;Ldk/molslinjen/api/shared/response/TicketSurchargeTypeDTO;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", BuildConfig.FLAVOR, "write$Self$api_kombardoProd", "(Ldk/molslinjen/api/shared/response/TicketSurchargeDTO;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getName", "Ldk/molslinjen/api/shared/response/PriceWithCurrencyDTO;", "getPrice", "()Ldk/molslinjen/api/shared/response/PriceWithCurrencyDTO;", "Ldk/molslinjen/api/shared/response/TicketSurchargeTypeDTO;", "getType", "()Ldk/molslinjen/api/shared/response/TicketSurchargeTypeDTO;", "getType$annotations", "()V", "Companion", "$serializer", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class TicketSurchargeDTO {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String name;
    private final PriceWithCurrencyDTO price;
    private final TicketSurchargeTypeDTO type;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/shared/response/TicketSurchargeDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/shared/response/TicketSurchargeDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<TicketSurchargeDTO> serializer() {
            return TicketSurchargeDTO$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ TicketSurchargeDTO(int i5, String str, PriceWithCurrencyDTO priceWithCurrencyDTO, TicketSurchargeTypeDTO ticketSurchargeTypeDTO, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (i5 & 7)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 7, TicketSurchargeDTO$$serializer.INSTANCE.getDescriptor());
        }
        this.name = str;
        this.price = priceWithCurrencyDTO;
        this.type = ticketSurchargeTypeDTO;
    }

    public static final /* synthetic */ void write$Self$api_kombardoProd(TicketSurchargeDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.name);
        output.encodeSerializableElement(serialDesc, 1, PriceWithCurrencyDTO$$serializer.INSTANCE, self.price);
        output.encodeSerializableElement(serialDesc, 2, TicketSurchargeTypeDTO.Serializer.INSTANCE, self.type);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TicketSurchargeDTO)) {
            return false;
        }
        TicketSurchargeDTO ticketSurchargeDTO = (TicketSurchargeDTO) other;
        return Intrinsics.areEqual(this.name, ticketSurchargeDTO.name) && Intrinsics.areEqual(this.price, ticketSurchargeDTO.price) && this.type == ticketSurchargeDTO.type;
    }

    public final String getName() {
        return this.name;
    }

    public final PriceWithCurrencyDTO getPrice() {
        return this.price;
    }

    public final TicketSurchargeTypeDTO getType() {
        return this.type;
    }

    public int hashCode() {
        return (((this.name.hashCode() * 31) + this.price.hashCode()) * 31) + this.type.hashCode();
    }

    public String toString() {
        return "TicketSurchargeDTO(name=" + this.name + ", price=" + this.price + ", type=" + this.type + ")";
    }
}
