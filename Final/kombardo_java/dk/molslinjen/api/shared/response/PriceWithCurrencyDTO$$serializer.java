package dk.molslinjen.api.shared.response;

import dk.molslinjen.api.shared.response.CurrencyTypeDTO;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"dk/molslinjen/api/shared/response/PriceWithCurrencyDTO.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Ldk/molslinjen/api/shared/response/PriceWithCurrencyDTO;", "<init>", "()V", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public /* synthetic */ class PriceWithCurrencyDTO$$serializer implements GeneratedSerializer<PriceWithCurrencyDTO> {
    public static final PriceWithCurrencyDTO$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        PriceWithCurrencyDTO$$serializer priceWithCurrencyDTO$$serializer = new PriceWithCurrencyDTO$$serializer();
        INSTANCE = priceWithCurrencyDTO$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dk.molslinjen.api.shared.response.PriceWithCurrencyDTO", priceWithCurrencyDTO$$serializer, 2);
        pluginGeneratedSerialDescriptor.addElement("value", false);
        pluginGeneratedSerialDescriptor.addElement("currencyType", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private PriceWithCurrencyDTO$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{DoubleSerializer.INSTANCE, CurrencyTypeDTO.Serializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final PriceWithCurrencyDTO deserialize(Decoder decoder) {
        double d5;
        int i5;
        CurrencyTypeDTO currencyTypeDTO;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        CurrencyTypeDTO currencyTypeDTO2 = null;
        if (beginStructure.decodeSequentially()) {
            d5 = beginStructure.decodeDoubleElement(serialDescriptor, 0);
            currencyTypeDTO = (CurrencyTypeDTO) beginStructure.decodeSerializableElement(serialDescriptor, 1, CurrencyTypeDTO.Serializer.INSTANCE, null);
            i5 = 3;
        } else {
            d5 = 0.0d;
            boolean z5 = true;
            int i6 = 0;
            while (z5) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                if (decodeElementIndex == -1) {
                    z5 = false;
                } else if (decodeElementIndex == 0) {
                    d5 = beginStructure.decodeDoubleElement(serialDescriptor, 0);
                    i6 |= 1;
                } else {
                    if (decodeElementIndex != 1) {
                        throw new UnknownFieldException(decodeElementIndex);
                    }
                    currencyTypeDTO2 = (CurrencyTypeDTO) beginStructure.decodeSerializableElement(serialDescriptor, 1, CurrencyTypeDTO.Serializer.INSTANCE, currencyTypeDTO2);
                    i6 |= 2;
                }
            }
            i5 = i6;
            currencyTypeDTO = currencyTypeDTO2;
        }
        double d6 = d5;
        beginStructure.endStructure(serialDescriptor);
        return new PriceWithCurrencyDTO(i5, d6, currencyTypeDTO, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, PriceWithCurrencyDTO value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        PriceWithCurrencyDTO.write$Self$api_kombardoProd(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
