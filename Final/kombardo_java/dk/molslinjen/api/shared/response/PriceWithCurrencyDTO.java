package dk.molslinjen.api.shared.response;

import dk.molslinjen.api.shared.response.CurrencyTypeDTO;
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

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0087\b\u0018\u0000 %2\u00020\u0001:\u0002&%B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B-\b\u0010\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0006\u0010\fJ'\u0010\u0015\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\"\u001a\u0004\b#\u0010$¨\u0006'"}, d2 = {"Ldk/molslinjen/api/shared/response/PriceWithCurrencyDTO;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "value", "Ldk/molslinjen/api/shared/response/CurrencyTypeDTO;", "currencyType", "<init>", "(DLdk/molslinjen/api/shared/response/CurrencyTypeDTO;)V", BuildConfig.FLAVOR, "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(IDLdk/molslinjen/api/shared/response/CurrencyTypeDTO;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", BuildConfig.FLAVOR, "write$Self$api_kombardoProd", "(Ldk/molslinjen/api/shared/response/PriceWithCurrencyDTO;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "D", "getValue", "()D", "Ldk/molslinjen/api/shared/response/CurrencyTypeDTO;", "getCurrencyType", "()Ldk/molslinjen/api/shared/response/CurrencyTypeDTO;", "Companion", "$serializer", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class PriceWithCurrencyDTO {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final CurrencyTypeDTO currencyType;
    private final double value;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/shared/response/PriceWithCurrencyDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/shared/response/PriceWithCurrencyDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<PriceWithCurrencyDTO> serializer() {
            return PriceWithCurrencyDTO$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ PriceWithCurrencyDTO(int i5, double d5, CurrencyTypeDTO currencyTypeDTO, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i5 & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 3, PriceWithCurrencyDTO$$serializer.INSTANCE.getDescriptor());
        }
        this.value = d5;
        this.currencyType = currencyTypeDTO;
    }

    public static final /* synthetic */ void write$Self$api_kombardoProd(PriceWithCurrencyDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeDoubleElement(serialDesc, 0, self.value);
        output.encodeSerializableElement(serialDesc, 1, CurrencyTypeDTO.Serializer.INSTANCE, self.currencyType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PriceWithCurrencyDTO)) {
            return false;
        }
        PriceWithCurrencyDTO priceWithCurrencyDTO = (PriceWithCurrencyDTO) other;
        return Double.compare(this.value, priceWithCurrencyDTO.value) == 0 && this.currencyType == priceWithCurrencyDTO.currencyType;
    }

    public final CurrencyTypeDTO getCurrencyType() {
        return this.currencyType;
    }

    public final double getValue() {
        return this.value;
    }

    public int hashCode() {
        return (Double.hashCode(this.value) * 31) + this.currencyType.hashCode();
    }

    public String toString() {
        return "PriceWithCurrencyDTO(value=" + this.value + ", currencyType=" + this.currencyType + ")";
    }

    public PriceWithCurrencyDTO(double d5, CurrencyTypeDTO currencyType) {
        Intrinsics.checkNotNullParameter(currencyType, "currencyType");
        this.value = d5;
        this.currencyType = currencyType;
    }
}
