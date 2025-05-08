package dk.molslinjen.domain.model.shared;

import dk.molslinjen.api.shared.response.PriceWithCurrencyDTO;
import dk.molslinjen.core.log.CriticalLog;
import dk.molslinjen.core.log.Logger;
import java.text.NumberFormat;
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

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 )2\u00020\u0001:\u0002)*B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\nB-\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0006\u0010\u000eJ\u0010\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0016J\u0011\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0000H\u0086\u0002J\u0011\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0003H\u0086\u0002J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020\u0014HÖ\u0001J%\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0001¢\u0006\u0002\b(R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006+"}, d2 = {"Ldk/molslinjen/domain/model/shared/PriceWithCurrency;", "Ldk/molslinjen/domain/model/shared/Price;", "value", BuildConfig.FLAVOR, "currencyType", "Ldk/molslinjen/domain/model/shared/CurrencyType;", "<init>", "(ILdk/molslinjen/domain/model/shared/CurrencyType;)V", "dto", "Ldk/molslinjen/api/shared/response/PriceWithCurrencyDTO;", "(Ldk/molslinjen/api/shared/response/PriceWithCurrencyDTO;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILdk/molslinjen/domain/model/shared/CurrencyType;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getValue", "()I", "getCurrencyType", "()Ldk/molslinjen/domain/model/shared/CurrencyType;", "formattedValue", BuildConfig.FLAVOR, "absoluteValue", BuildConfig.FLAVOR, "plus", "other", "times", "component1", "component2", "copy", "equals", BuildConfig.FLAVOR, "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$domain_kombardoProd", "Companion", "$serializer", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class PriceWithCurrency extends Price {
    private final CurrencyType currencyType;
    private final int value;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, CurrencyType.INSTANCE.serializer()};

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\u0005J\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n¨\u0006\u000b"}, d2 = {"Ldk/molslinjen/domain/model/shared/PriceWithCurrency$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mock", "Ldk/molslinjen/domain/model/shared/PriceWithCurrency;", "value", BuildConfig.FLAVOR, "default", "serializer", "Lkotlinx/serialization/KSerializer;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: default, reason: not valid java name */
        public final PriceWithCurrency m3248default() {
            return new PriceWithCurrency(0, CurrencyType.DKK);
        }

        public final PriceWithCurrency mock(int value) {
            return new PriceWithCurrency(value, CurrencyType.DKK);
        }

        public final KSerializer<PriceWithCurrency> serializer() {
            return PriceWithCurrency$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PriceWithCurrency(int i5, int i6, CurrencyType currencyType, SerializationConstructorMarker serializationConstructorMarker) {
        super(null);
        if (3 != (i5 & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 3, PriceWithCurrency$$serializer.INSTANCE.getDescriptor());
        }
        this.value = i6;
        this.currencyType = currencyType;
    }

    public static /* synthetic */ PriceWithCurrency copy$default(PriceWithCurrency priceWithCurrency, int i5, CurrencyType currencyType, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i5 = priceWithCurrency.value;
        }
        if ((i6 & 2) != 0) {
            currencyType = priceWithCurrency.currencyType;
        }
        return priceWithCurrency.copy(i5, currencyType);
    }

    public static /* synthetic */ String formattedValue$default(PriceWithCurrency priceWithCurrency, boolean z5, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            z5 = false;
        }
        return priceWithCurrency.formattedValue(z5);
    }

    public static final /* synthetic */ void write$Self$domain_kombardoProd(PriceWithCurrency self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        output.encodeIntElement(serialDesc, 0, self.value);
        output.encodeSerializableElement(serialDesc, 1, kSerializerArr[1], self.currencyType);
    }

    /* renamed from: component1, reason: from getter */
    public final int getValue() {
        return this.value;
    }

    /* renamed from: component2, reason: from getter */
    public final CurrencyType getCurrencyType() {
        return this.currencyType;
    }

    public final PriceWithCurrency copy(int value, CurrencyType currencyType) {
        Intrinsics.checkNotNullParameter(currencyType, "currencyType");
        return new PriceWithCurrency(value, currencyType);
    }

    @Override // dk.molslinjen.domain.model.shared.Price
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PriceWithCurrency)) {
            return false;
        }
        PriceWithCurrency priceWithCurrency = (PriceWithCurrency) other;
        return this.value == priceWithCurrency.value && this.currencyType == priceWithCurrency.currencyType;
    }

    public final String formattedValue(boolean absoluteValue) {
        String format = NumberFormat.getIntegerInstance().format(Integer.valueOf(absoluteValue ? Math.abs(this.value) : this.value));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    public final CurrencyType getCurrencyType() {
        return this.currencyType;
    }

    public final int getValue() {
        return this.value;
    }

    @Override // dk.molslinjen.domain.model.shared.Price
    public int hashCode() {
        return (Integer.hashCode(this.value) * 31) + this.currencyType.hashCode();
    }

    public final PriceWithCurrency plus(PriceWithCurrency other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (this.currencyType != other.currencyType) {
            Logger.INSTANCE.logCritical(new CriticalLog("Cannot add prices with different currencies"));
        }
        return new PriceWithCurrency(this.value + other.value, this.currencyType);
    }

    public final PriceWithCurrency times(int other) {
        return new PriceWithCurrency(this.value * other, this.currencyType);
    }

    public String toString() {
        return "PriceWithCurrency(value=" + this.value + ", currencyType=" + this.currencyType + ")";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PriceWithCurrency(int i5, CurrencyType currencyType) {
        super(null);
        Intrinsics.checkNotNullParameter(currencyType, "currencyType");
        this.value = i5;
        this.currencyType = currencyType;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PriceWithCurrency(PriceWithCurrencyDTO dto) {
        this((int) dto.getValue(), CurrencyType.INSTANCE.invoke(dto.getCurrencyType()));
        Intrinsics.checkNotNullParameter(dto, "dto");
    }
}
