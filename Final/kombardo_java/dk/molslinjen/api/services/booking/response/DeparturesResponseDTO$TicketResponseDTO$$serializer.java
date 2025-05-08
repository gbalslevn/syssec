package dk.molslinjen.api.services.booking.response;

import dk.molslinjen.api.services.booking.response.DeparturesResponseDTO;
import dk.molslinjen.api.shared.response.PriceWithCurrencyDTO;
import dk.molslinjen.api.shared.response.PriceWithCurrencyDTO$$serializer;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"dk/molslinjen/api/services/booking/response/DeparturesResponseDTO.TicketResponseDTO.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Ldk/molslinjen/api/services/booking/response/DeparturesResponseDTO$TicketResponseDTO;", "<init>", "()V", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public /* synthetic */ class DeparturesResponseDTO$TicketResponseDTO$$serializer implements GeneratedSerializer<DeparturesResponseDTO.TicketResponseDTO> {
    public static final DeparturesResponseDTO$TicketResponseDTO$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        DeparturesResponseDTO$TicketResponseDTO$$serializer departuresResponseDTO$TicketResponseDTO$$serializer = new DeparturesResponseDTO$TicketResponseDTO$$serializer();
        INSTANCE = departuresResponseDTO$TicketResponseDTO$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dk.molslinjen.api.services.booking.response.DeparturesResponseDTO.TicketResponseDTO", departuresResponseDTO$TicketResponseDTO$$serializer, 10);
        pluginGeneratedSerialDescriptor.addElement("carId", false);
        pluginGeneratedSerialDescriptor.addElement("category", false);
        pluginGeneratedSerialDescriptor.addElement("changeFee", false);
        pluginGeneratedSerialDescriptor.addElement("fees", false);
        pluginGeneratedSerialDescriptor.addElement("goodsFee", false);
        pluginGeneratedSerialDescriptor.addElement("price", false);
        pluginGeneratedSerialDescriptor.addElement("productPrices", false);
        pluginGeneratedSerialDescriptor.addElement("soldOut", false);
        pluginGeneratedSerialDescriptor.addElement("totalPrice", false);
        pluginGeneratedSerialDescriptor.addElement("surcharges", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private DeparturesResponseDTO$TicketResponseDTO$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr;
        kSerializerArr = DeparturesResponseDTO.TicketResponseDTO.$childSerializers;
        KSerializer<?> nullable = BuiltinSerializersKt.getNullable(DeparturesResponseDTO$FeeResponseDTO$$serializer.INSTANCE);
        KSerializer<?> nullable2 = BuiltinSerializersKt.getNullable(kSerializerArr[6]);
        KSerializer<?> kSerializer = kSerializerArr[9];
        PriceWithCurrencyDTO$$serializer priceWithCurrencyDTO$$serializer = PriceWithCurrencyDTO$$serializer.INSTANCE;
        return new KSerializer[]{StringSerializer.INSTANCE, DeparturesResponseDTO$CategoryResponseDTO$$serializer.INSTANCE, priceWithCurrencyDTO$$serializer, nullable, priceWithCurrencyDTO$$serializer, priceWithCurrencyDTO$$serializer, nullable2, BooleanSerializer.INSTANCE, priceWithCurrencyDTO$$serializer, kSerializer};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x0093. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public final DeparturesResponseDTO.TicketResponseDTO deserialize(Decoder decoder) {
        KSerializer[] kSerializerArr;
        boolean z5;
        List list;
        List list2;
        PriceWithCurrencyDTO priceWithCurrencyDTO;
        PriceWithCurrencyDTO priceWithCurrencyDTO2;
        DeparturesResponseDTO.FeeResponseDTO feeResponseDTO;
        PriceWithCurrencyDTO priceWithCurrencyDTO3;
        PriceWithCurrencyDTO priceWithCurrencyDTO4;
        DeparturesResponseDTO.CategoryResponseDTO categoryResponseDTO;
        int i5;
        String str;
        char c5;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        kSerializerArr = DeparturesResponseDTO.TicketResponseDTO.$childSerializers;
        int i6 = 9;
        if (beginStructure.decodeSequentially()) {
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 0);
            DeparturesResponseDTO.CategoryResponseDTO categoryResponseDTO2 = (DeparturesResponseDTO.CategoryResponseDTO) beginStructure.decodeSerializableElement(serialDescriptor, 1, DeparturesResponseDTO$CategoryResponseDTO$$serializer.INSTANCE, null);
            PriceWithCurrencyDTO$$serializer priceWithCurrencyDTO$$serializer = PriceWithCurrencyDTO$$serializer.INSTANCE;
            PriceWithCurrencyDTO priceWithCurrencyDTO5 = (PriceWithCurrencyDTO) beginStructure.decodeSerializableElement(serialDescriptor, 2, priceWithCurrencyDTO$$serializer, null);
            DeparturesResponseDTO.FeeResponseDTO feeResponseDTO2 = (DeparturesResponseDTO.FeeResponseDTO) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, DeparturesResponseDTO$FeeResponseDTO$$serializer.INSTANCE, null);
            PriceWithCurrencyDTO priceWithCurrencyDTO6 = (PriceWithCurrencyDTO) beginStructure.decodeSerializableElement(serialDescriptor, 4, priceWithCurrencyDTO$$serializer, null);
            PriceWithCurrencyDTO priceWithCurrencyDTO7 = (PriceWithCurrencyDTO) beginStructure.decodeSerializableElement(serialDescriptor, 5, priceWithCurrencyDTO$$serializer, null);
            List list3 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, kSerializerArr[6], null);
            boolean decodeBooleanElement = beginStructure.decodeBooleanElement(serialDescriptor, 7);
            PriceWithCurrencyDTO priceWithCurrencyDTO8 = (PriceWithCurrencyDTO) beginStructure.decodeSerializableElement(serialDescriptor, 8, priceWithCurrencyDTO$$serializer, null);
            list = (List) beginStructure.decodeSerializableElement(serialDescriptor, 9, kSerializerArr[9], null);
            str = decodeStringElement;
            z5 = decodeBooleanElement;
            priceWithCurrencyDTO2 = priceWithCurrencyDTO7;
            feeResponseDTO = feeResponseDTO2;
            priceWithCurrencyDTO3 = priceWithCurrencyDTO8;
            priceWithCurrencyDTO = priceWithCurrencyDTO6;
            priceWithCurrencyDTO4 = priceWithCurrencyDTO5;
            i5 = 1023;
            list2 = list3;
            categoryResponseDTO = categoryResponseDTO2;
        } else {
            boolean z6 = true;
            boolean z7 = false;
            List list4 = null;
            List list5 = null;
            PriceWithCurrencyDTO priceWithCurrencyDTO9 = null;
            PriceWithCurrencyDTO priceWithCurrencyDTO10 = null;
            DeparturesResponseDTO.FeeResponseDTO feeResponseDTO3 = null;
            PriceWithCurrencyDTO priceWithCurrencyDTO11 = null;
            PriceWithCurrencyDTO priceWithCurrencyDTO12 = null;
            String str2 = null;
            DeparturesResponseDTO.CategoryResponseDTO categoryResponseDTO3 = null;
            int i7 = 0;
            while (z6) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z6 = false;
                        i6 = 9;
                    case 0:
                        str2 = beginStructure.decodeStringElement(serialDescriptor, 0);
                        i7 |= 1;
                        i6 = 9;
                    case 1:
                        categoryResponseDTO3 = (DeparturesResponseDTO.CategoryResponseDTO) beginStructure.decodeSerializableElement(serialDescriptor, 1, DeparturesResponseDTO$CategoryResponseDTO$$serializer.INSTANCE, categoryResponseDTO3);
                        i7 |= 2;
                        i6 = 9;
                    case 2:
                        priceWithCurrencyDTO12 = (PriceWithCurrencyDTO) beginStructure.decodeSerializableElement(serialDescriptor, 2, PriceWithCurrencyDTO$$serializer.INSTANCE, priceWithCurrencyDTO12);
                        i7 |= 4;
                        i6 = 9;
                    case 3:
                        feeResponseDTO3 = (DeparturesResponseDTO.FeeResponseDTO) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, DeparturesResponseDTO$FeeResponseDTO$$serializer.INSTANCE, feeResponseDTO3);
                        i7 |= 8;
                        i6 = 9;
                    case 4:
                        priceWithCurrencyDTO9 = (PriceWithCurrencyDTO) beginStructure.decodeSerializableElement(serialDescriptor, 4, PriceWithCurrencyDTO$$serializer.INSTANCE, priceWithCurrencyDTO9);
                        i7 |= 16;
                        i6 = 9;
                    case 5:
                        priceWithCurrencyDTO10 = (PriceWithCurrencyDTO) beginStructure.decodeSerializableElement(serialDescriptor, 5, PriceWithCurrencyDTO$$serializer.INSTANCE, priceWithCurrencyDTO10);
                        i7 |= 32;
                        i6 = 9;
                    case 6:
                        list5 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, kSerializerArr[6], list5);
                        i7 |= 64;
                        i6 = 9;
                    case 7:
                        c5 = '\b';
                        z7 = beginStructure.decodeBooleanElement(serialDescriptor, 7);
                        i7 |= 128;
                        i6 = 9;
                    case 8:
                        c5 = '\b';
                        priceWithCurrencyDTO11 = (PriceWithCurrencyDTO) beginStructure.decodeSerializableElement(serialDescriptor, 8, PriceWithCurrencyDTO$$serializer.INSTANCE, priceWithCurrencyDTO11);
                        i7 |= 256;
                        i6 = 9;
                    case 9:
                        list4 = (List) beginStructure.decodeSerializableElement(serialDescriptor, i6, kSerializerArr[i6], list4);
                        i7 |= 512;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            z5 = z7;
            list = list4;
            list2 = list5;
            priceWithCurrencyDTO = priceWithCurrencyDTO9;
            priceWithCurrencyDTO2 = priceWithCurrencyDTO10;
            feeResponseDTO = feeResponseDTO3;
            priceWithCurrencyDTO3 = priceWithCurrencyDTO11;
            priceWithCurrencyDTO4 = priceWithCurrencyDTO12;
            categoryResponseDTO = categoryResponseDTO3;
            i5 = i7;
            str = str2;
        }
        beginStructure.endStructure(serialDescriptor);
        return new DeparturesResponseDTO.TicketResponseDTO(i5, str, categoryResponseDTO, priceWithCurrencyDTO4, feeResponseDTO, priceWithCurrencyDTO, priceWithCurrencyDTO2, list2, z5, priceWithCurrencyDTO3, list, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, DeparturesResponseDTO.TicketResponseDTO value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        DeparturesResponseDTO.TicketResponseDTO.write$Self$api_kombardoProd(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
