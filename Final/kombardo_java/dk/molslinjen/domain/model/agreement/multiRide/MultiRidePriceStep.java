package dk.molslinjen.domain.model.agreement.multiRide;

import dk.molslinjen.api.services.multiRide.response.MultiRidePriceStepResponseDTO;
import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import dk.molslinjen.domain.model.shared.PriceWithCurrency$$serializer;
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

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 *2\u00020\u0001:\u0002*+B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0007\u0010\u000bB7\b\u0010\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0007\u0010\u000fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0013J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J.\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001J%\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0001¢\u0006\u0002\b)R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006,"}, d2 = {"Ldk/molslinjen/domain/model/agreement/multiRide/MultiRidePriceStep;", BuildConfig.FLAVOR, "min", BuildConfig.FLAVOR, "max", "price", "Ldk/molslinjen/domain/model/shared/PriceWithCurrency;", "<init>", "(ILjava/lang/Integer;Ldk/molslinjen/domain/model/shared/PriceWithCurrency;)V", "dto", "Ldk/molslinjen/api/services/multiRide/response/MultiRidePriceStepResponseDTO;", "(Ldk/molslinjen/api/services/multiRide/response/MultiRidePriceStepResponseDTO;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILjava/lang/Integer;Ldk/molslinjen/domain/model/shared/PriceWithCurrency;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getMin", "()I", "getMax", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPrice", "()Ldk/molslinjen/domain/model/shared/PriceWithCurrency;", "component1", "component2", "component3", "copy", "(ILjava/lang/Integer;Ldk/molslinjen/domain/model/shared/PriceWithCurrency;)Ldk/molslinjen/domain/model/agreement/multiRide/MultiRidePriceStep;", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", BuildConfig.FLAVOR, "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$domain_kombardoProd", "Companion", "$serializer", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class MultiRidePriceStep {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final MultiRidePriceStep mock1;
    private static final MultiRidePriceStep mock2;
    private static final MultiRidePriceStep mock3;
    private static final MultiRidePriceStep mock4;
    private final Integer max;
    private final int min;
    private final PriceWithCurrency price;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007¨\u0006\u0010"}, d2 = {"Ldk/molslinjen/domain/model/agreement/multiRide/MultiRidePriceStep$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mock1", "Ldk/molslinjen/domain/model/agreement/multiRide/MultiRidePriceStep;", "getMock1", "()Ldk/molslinjen/domain/model/agreement/multiRide/MultiRidePriceStep;", "mock2", "getMock2", "mock3", "getMock3", "mock4", "getMock4", "serializer", "Lkotlinx/serialization/KSerializer;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MultiRidePriceStep getMock1() {
            return MultiRidePriceStep.mock1;
        }

        public final MultiRidePriceStep getMock2() {
            return MultiRidePriceStep.mock2;
        }

        public final MultiRidePriceStep getMock3() {
            return MultiRidePriceStep.mock3;
        }

        public final MultiRidePriceStep getMock4() {
            return MultiRidePriceStep.mock4;
        }

        public final KSerializer<MultiRidePriceStep> serializer() {
            return MultiRidePriceStep$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    static {
        PriceWithCurrency.Companion companion = PriceWithCurrency.INSTANCE;
        mock1 = new MultiRidePriceStep(1, 5, companion.mock(100));
        mock2 = new MultiRidePriceStep(6, 15, companion.mock(90));
        mock3 = new MultiRidePriceStep(15, 30, companion.mock(80));
        mock4 = new MultiRidePriceStep(30, null, companion.mock(70));
    }

    public /* synthetic */ MultiRidePriceStep(int i5, int i6, Integer num, PriceWithCurrency priceWithCurrency, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (i5 & 7)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 7, MultiRidePriceStep$$serializer.INSTANCE.getDescriptor());
        }
        this.min = i6;
        this.max = num;
        this.price = priceWithCurrency;
    }

    public static /* synthetic */ MultiRidePriceStep copy$default(MultiRidePriceStep multiRidePriceStep, int i5, Integer num, PriceWithCurrency priceWithCurrency, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i5 = multiRidePriceStep.min;
        }
        if ((i6 & 2) != 0) {
            num = multiRidePriceStep.max;
        }
        if ((i6 & 4) != 0) {
            priceWithCurrency = multiRidePriceStep.price;
        }
        return multiRidePriceStep.copy(i5, num, priceWithCurrency);
    }

    public static final /* synthetic */ void write$Self$domain_kombardoProd(MultiRidePriceStep self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeIntElement(serialDesc, 0, self.min);
        output.encodeNullableSerializableElement(serialDesc, 1, IntSerializer.INSTANCE, self.max);
        output.encodeSerializableElement(serialDesc, 2, PriceWithCurrency$$serializer.INSTANCE, self.price);
    }

    /* renamed from: component1, reason: from getter */
    public final int getMin() {
        return this.min;
    }

    /* renamed from: component2, reason: from getter */
    public final Integer getMax() {
        return this.max;
    }

    /* renamed from: component3, reason: from getter */
    public final PriceWithCurrency getPrice() {
        return this.price;
    }

    public final MultiRidePriceStep copy(int min, Integer max, PriceWithCurrency price) {
        Intrinsics.checkNotNullParameter(price, "price");
        return new MultiRidePriceStep(min, max, price);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MultiRidePriceStep)) {
            return false;
        }
        MultiRidePriceStep multiRidePriceStep = (MultiRidePriceStep) other;
        return this.min == multiRidePriceStep.min && Intrinsics.areEqual(this.max, multiRidePriceStep.max) && Intrinsics.areEqual(this.price, multiRidePriceStep.price);
    }

    public final Integer getMax() {
        return this.max;
    }

    public final int getMin() {
        return this.min;
    }

    public final PriceWithCurrency getPrice() {
        return this.price;
    }

    public int hashCode() {
        int hashCode = Integer.hashCode(this.min) * 31;
        Integer num = this.max;
        return ((hashCode + (num == null ? 0 : num.hashCode())) * 31) + this.price.hashCode();
    }

    public String toString() {
        return "MultiRidePriceStep(min=" + this.min + ", max=" + this.max + ", price=" + this.price + ")";
    }

    public MultiRidePriceStep(int i5, Integer num, PriceWithCurrency price) {
        Intrinsics.checkNotNullParameter(price, "price");
        this.min = i5;
        this.max = num;
        this.price = price;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MultiRidePriceStep(MultiRidePriceStepResponseDTO dto) {
        this(dto.getMin(), dto.getMax(), new PriceWithCurrency(dto.getPricePerClip()));
        Intrinsics.checkNotNullParameter(dto, "dto");
    }
}
