package dk.molslinjen.api.services.booking.response;

import dk.molslinjen.api.services.booking.response.DeparturesResponseDTO;
import dk.molslinjen.api.shared.response.PriceWithCurrencyDTO;
import dk.molslinjen.api.shared.response.PriceWithCurrencyDTO$$serializer;
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
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"dk/molslinjen/api/services/booking/response/DeparturesResponseDTO.CheapestTicketDTO.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Ldk/molslinjen/api/services/booking/response/DeparturesResponseDTO$CheapestTicketDTO;", "<init>", "()V", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public /* synthetic */ class DeparturesResponseDTO$CheapestTicketDTO$$serializer implements GeneratedSerializer<DeparturesResponseDTO.CheapestTicketDTO> {
    public static final DeparturesResponseDTO$CheapestTicketDTO$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        DeparturesResponseDTO$CheapestTicketDTO$$serializer departuresResponseDTO$CheapestTicketDTO$$serializer = new DeparturesResponseDTO$CheapestTicketDTO$$serializer();
        INSTANCE = departuresResponseDTO$CheapestTicketDTO$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dk.molslinjen.api.services.booking.response.DeparturesResponseDTO.CheapestTicketDTO", departuresResponseDTO$CheapestTicketDTO$$serializer, 4);
        pluginGeneratedSerialDescriptor.addElement("priceIndicator", false);
        pluginGeneratedSerialDescriptor.addElement("ticketTypeId", false);
        pluginGeneratedSerialDescriptor.addElement("ticketTypeName", false);
        pluginGeneratedSerialDescriptor.addElement("price", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private DeparturesResponseDTO$CheapestTicketDTO$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{DeparturesResponseDTO.CheapestTicketPriceIndicatorDTO.Serializer.INSTANCE, stringSerializer, stringSerializer, PriceWithCurrencyDTO$$serializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final DeparturesResponseDTO.CheapestTicketDTO deserialize(Decoder decoder) {
        int i5;
        DeparturesResponseDTO.CheapestTicketPriceIndicatorDTO cheapestTicketPriceIndicatorDTO;
        String str;
        String str2;
        PriceWithCurrencyDTO priceWithCurrencyDTO;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        DeparturesResponseDTO.CheapestTicketPriceIndicatorDTO cheapestTicketPriceIndicatorDTO2 = null;
        if (beginStructure.decodeSequentially()) {
            DeparturesResponseDTO.CheapestTicketPriceIndicatorDTO cheapestTicketPriceIndicatorDTO3 = (DeparturesResponseDTO.CheapestTicketPriceIndicatorDTO) beginStructure.decodeSerializableElement(serialDescriptor, 0, DeparturesResponseDTO.CheapestTicketPriceIndicatorDTO.Serializer.INSTANCE, null);
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 1);
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 2);
            cheapestTicketPriceIndicatorDTO = cheapestTicketPriceIndicatorDTO3;
            priceWithCurrencyDTO = (PriceWithCurrencyDTO) beginStructure.decodeSerializableElement(serialDescriptor, 3, PriceWithCurrencyDTO$$serializer.INSTANCE, null);
            str2 = decodeStringElement2;
            str = decodeStringElement;
            i5 = 15;
        } else {
            boolean z5 = true;
            int i6 = 0;
            String str3 = null;
            String str4 = null;
            PriceWithCurrencyDTO priceWithCurrencyDTO2 = null;
            while (z5) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                if (decodeElementIndex == -1) {
                    z5 = false;
                } else if (decodeElementIndex == 0) {
                    cheapestTicketPriceIndicatorDTO2 = (DeparturesResponseDTO.CheapestTicketPriceIndicatorDTO) beginStructure.decodeSerializableElement(serialDescriptor, 0, DeparturesResponseDTO.CheapestTicketPriceIndicatorDTO.Serializer.INSTANCE, cheapestTicketPriceIndicatorDTO2);
                    i6 |= 1;
                } else if (decodeElementIndex == 1) {
                    str3 = beginStructure.decodeStringElement(serialDescriptor, 1);
                    i6 |= 2;
                } else if (decodeElementIndex == 2) {
                    str4 = beginStructure.decodeStringElement(serialDescriptor, 2);
                    i6 |= 4;
                } else {
                    if (decodeElementIndex != 3) {
                        throw new UnknownFieldException(decodeElementIndex);
                    }
                    priceWithCurrencyDTO2 = (PriceWithCurrencyDTO) beginStructure.decodeSerializableElement(serialDescriptor, 3, PriceWithCurrencyDTO$$serializer.INSTANCE, priceWithCurrencyDTO2);
                    i6 |= 8;
                }
            }
            i5 = i6;
            cheapestTicketPriceIndicatorDTO = cheapestTicketPriceIndicatorDTO2;
            str = str3;
            str2 = str4;
            priceWithCurrencyDTO = priceWithCurrencyDTO2;
        }
        beginStructure.endStructure(serialDescriptor);
        return new DeparturesResponseDTO.CheapestTicketDTO(i5, cheapestTicketPriceIndicatorDTO, str, str2, priceWithCurrencyDTO, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, DeparturesResponseDTO.CheapestTicketDTO value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        DeparturesResponseDTO.CheapestTicketDTO.write$Self$api_kombardoProd(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
