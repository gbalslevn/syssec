package dk.molslinjen.api.services.multiRide.response;

import dk.molslinjen.api.shared.response.PriceWithCurrencyDTO;
import dk.molslinjen.api.shared.response.PriceWithCurrencyDTO$$serializer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 (2\u00020\u0001:\u0002'(B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bB7\b\u0010\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0007\u0010\fJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J.\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J%\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0001¢\u0006\u0002\b&R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006)"}, d2 = {"Ldk/molslinjen/api/services/multiRide/response/MultiRidePriceStepResponseDTO;", BuildConfig.FLAVOR, "max", BuildConfig.FLAVOR, "min", "pricePerClip", "Ldk/molslinjen/api/shared/response/PriceWithCurrencyDTO;", "<init>", "(Ljava/lang/Integer;ILdk/molslinjen/api/shared/response/PriceWithCurrencyDTO;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Integer;ILdk/molslinjen/api/shared/response/PriceWithCurrencyDTO;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getMax", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMin", "()I", "getPricePerClip", "()Ldk/molslinjen/api/shared/response/PriceWithCurrencyDTO;", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;ILdk/molslinjen/api/shared/response/PriceWithCurrencyDTO;)Ldk/molslinjen/api/services/multiRide/response/MultiRidePriceStepResponseDTO;", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", BuildConfig.FLAVOR, "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class MultiRidePriceStepResponseDTO {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Integer max;
    private final int min;
    private final PriceWithCurrencyDTO pricePerClip;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/multiRide/response/MultiRidePriceStepResponseDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/multiRide/response/MultiRidePriceStepResponseDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<MultiRidePriceStepResponseDTO> serializer() {
            return MultiRidePriceStepResponseDTO$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ MultiRidePriceStepResponseDTO(int i5, Integer num, int i6, PriceWithCurrencyDTO priceWithCurrencyDTO, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (i5 & 7)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 7, MultiRidePriceStepResponseDTO$$serializer.INSTANCE.getDescriptor());
        }
        this.max = num;
        this.min = i6;
        this.pricePerClip = priceWithCurrencyDTO;
    }

    public static /* synthetic */ MultiRidePriceStepResponseDTO copy$default(MultiRidePriceStepResponseDTO multiRidePriceStepResponseDTO, Integer num, int i5, PriceWithCurrencyDTO priceWithCurrencyDTO, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            num = multiRidePriceStepResponseDTO.max;
        }
        if ((i6 & 2) != 0) {
            i5 = multiRidePriceStepResponseDTO.min;
        }
        if ((i6 & 4) != 0) {
            priceWithCurrencyDTO = multiRidePriceStepResponseDTO.pricePerClip;
        }
        return multiRidePriceStepResponseDTO.copy(num, i5, priceWithCurrencyDTO);
    }

    public static final /* synthetic */ void write$Self$api_kombardoProd(MultiRidePriceStepResponseDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeNullableSerializableElement(serialDesc, 0, IntSerializer.INSTANCE, self.max);
        output.encodeIntElement(serialDesc, 1, self.min);
        output.encodeSerializableElement(serialDesc, 2, PriceWithCurrencyDTO$$serializer.INSTANCE, self.pricePerClip);
    }

    /* renamed from: component1, reason: from getter */
    public final Integer getMax() {
        return this.max;
    }

    /* renamed from: component2, reason: from getter */
    public final int getMin() {
        return this.min;
    }

    /* renamed from: component3, reason: from getter */
    public final PriceWithCurrencyDTO getPricePerClip() {
        return this.pricePerClip;
    }

    public final MultiRidePriceStepResponseDTO copy(Integer max, int min, PriceWithCurrencyDTO pricePerClip) {
        Intrinsics.checkNotNullParameter(pricePerClip, "pricePerClip");
        return new MultiRidePriceStepResponseDTO(max, min, pricePerClip);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MultiRidePriceStepResponseDTO)) {
            return false;
        }
        MultiRidePriceStepResponseDTO multiRidePriceStepResponseDTO = (MultiRidePriceStepResponseDTO) other;
        return Intrinsics.areEqual(this.max, multiRidePriceStepResponseDTO.max) && this.min == multiRidePriceStepResponseDTO.min && Intrinsics.areEqual(this.pricePerClip, multiRidePriceStepResponseDTO.pricePerClip);
    }

    public final Integer getMax() {
        return this.max;
    }

    public final int getMin() {
        return this.min;
    }

    public final PriceWithCurrencyDTO getPricePerClip() {
        return this.pricePerClip;
    }

    public int hashCode() {
        Integer num = this.max;
        return ((((num == null ? 0 : num.hashCode()) * 31) + Integer.hashCode(this.min)) * 31) + this.pricePerClip.hashCode();
    }

    public String toString() {
        return "MultiRidePriceStepResponseDTO(max=" + this.max + ", min=" + this.min + ", pricePerClip=" + this.pricePerClip + ")";
    }

    public MultiRidePriceStepResponseDTO(Integer num, int i5, PriceWithCurrencyDTO pricePerClip) {
        Intrinsics.checkNotNullParameter(pricePerClip, "pricePerClip");
        this.max = num;
        this.min = i5;
        this.pricePerClip = pricePerClip;
    }
}
