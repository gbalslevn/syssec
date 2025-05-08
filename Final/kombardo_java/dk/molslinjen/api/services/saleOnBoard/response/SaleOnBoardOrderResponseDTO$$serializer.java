package dk.molslinjen.api.services.saleOnBoard.response;

import dk.molslinjen.api.helpers.serializers.LocalDateTimeRetailItsSerializer;
import dk.molslinjen.api.services.saleOnBoard.response.SaleOnBoardOrderResponseDTO;
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
import org.threeten.bp.LocalDateTime;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"dk/molslinjen/api/services/saleOnBoard/response/SaleOnBoardOrderResponseDTO.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Ldk/molslinjen/api/services/saleOnBoard/response/SaleOnBoardOrderResponseDTO;", "<init>", "()V", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public /* synthetic */ class SaleOnBoardOrderResponseDTO$$serializer implements GeneratedSerializer<SaleOnBoardOrderResponseDTO> {
    public static final SaleOnBoardOrderResponseDTO$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        SaleOnBoardOrderResponseDTO$$serializer saleOnBoardOrderResponseDTO$$serializer = new SaleOnBoardOrderResponseDTO$$serializer();
        INSTANCE = saleOnBoardOrderResponseDTO$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dk.molslinjen.api.services.saleOnBoard.response.SaleOnBoardOrderResponseDTO", saleOnBoardOrderResponseDTO$$serializer, 7);
        pluginGeneratedSerialDescriptor.addElement("orderNo", false);
        pluginGeneratedSerialDescriptor.addElement("name", false);
        pluginGeneratedSerialDescriptor.addElement("mobileNo", false);
        pluginGeneratedSerialDescriptor.addElement("email", false);
        pluginGeneratedSerialDescriptor.addElement("orderStatus", false);
        pluginGeneratedSerialDescriptor.addElement("estimatedServingTimeStart", false);
        pluginGeneratedSerialDescriptor.addElement("estimatedServingTimeEnd", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private SaleOnBoardOrderResponseDTO$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr;
        kSerializerArr = SaleOnBoardOrderResponseDTO.$childSerializers;
        KSerializer<?> kSerializer = kSerializerArr[4];
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        LocalDateTimeRetailItsSerializer localDateTimeRetailItsSerializer = LocalDateTimeRetailItsSerializer.INSTANCE;
        return new KSerializer[]{stringSerializer, stringSerializer, stringSerializer, stringSerializer, kSerializer, localDateTimeRetailItsSerializer, localDateTimeRetailItsSerializer};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x0068. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public final SaleOnBoardOrderResponseDTO deserialize(Decoder decoder) {
        KSerializer[] kSerializerArr;
        int i5;
        LocalDateTime localDateTime;
        LocalDateTime localDateTime2;
        String str;
        String str2;
        String str3;
        String str4;
        SaleOnBoardOrderResponseDTO.CateringOrderStatusResponseDTO cateringOrderStatusResponseDTO;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        kSerializerArr = SaleOnBoardOrderResponseDTO.$childSerializers;
        String str5 = null;
        if (beginStructure.decodeSequentially()) {
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 0);
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 1);
            String decodeStringElement3 = beginStructure.decodeStringElement(serialDescriptor, 2);
            String decodeStringElement4 = beginStructure.decodeStringElement(serialDescriptor, 3);
            SaleOnBoardOrderResponseDTO.CateringOrderStatusResponseDTO cateringOrderStatusResponseDTO2 = (SaleOnBoardOrderResponseDTO.CateringOrderStatusResponseDTO) beginStructure.decodeSerializableElement(serialDescriptor, 4, kSerializerArr[4], null);
            LocalDateTimeRetailItsSerializer localDateTimeRetailItsSerializer = LocalDateTimeRetailItsSerializer.INSTANCE;
            LocalDateTime localDateTime3 = (LocalDateTime) beginStructure.decodeSerializableElement(serialDescriptor, 5, localDateTimeRetailItsSerializer, null);
            cateringOrderStatusResponseDTO = cateringOrderStatusResponseDTO2;
            str = decodeStringElement;
            localDateTime = (LocalDateTime) beginStructure.decodeSerializableElement(serialDescriptor, 6, localDateTimeRetailItsSerializer, null);
            localDateTime2 = localDateTime3;
            str4 = decodeStringElement4;
            str3 = decodeStringElement3;
            i5 = 127;
            str2 = decodeStringElement2;
        } else {
            boolean z5 = true;
            int i6 = 0;
            LocalDateTime localDateTime4 = null;
            LocalDateTime localDateTime5 = null;
            String str6 = null;
            String str7 = null;
            String str8 = null;
            SaleOnBoardOrderResponseDTO.CateringOrderStatusResponseDTO cateringOrderStatusResponseDTO3 = null;
            while (z5) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z5 = false;
                    case 0:
                        i6 |= 1;
                        str5 = beginStructure.decodeStringElement(serialDescriptor, 0);
                    case 1:
                        i6 |= 2;
                        str6 = beginStructure.decodeStringElement(serialDescriptor, 1);
                    case 2:
                        str7 = beginStructure.decodeStringElement(serialDescriptor, 2);
                        i6 |= 4;
                    case 3:
                        str8 = beginStructure.decodeStringElement(serialDescriptor, 3);
                        i6 |= 8;
                    case 4:
                        cateringOrderStatusResponseDTO3 = (SaleOnBoardOrderResponseDTO.CateringOrderStatusResponseDTO) beginStructure.decodeSerializableElement(serialDescriptor, 4, kSerializerArr[4], cateringOrderStatusResponseDTO3);
                        i6 |= 16;
                    case 5:
                        localDateTime5 = (LocalDateTime) beginStructure.decodeSerializableElement(serialDescriptor, 5, LocalDateTimeRetailItsSerializer.INSTANCE, localDateTime5);
                        i6 |= 32;
                    case 6:
                        localDateTime4 = (LocalDateTime) beginStructure.decodeSerializableElement(serialDescriptor, 6, LocalDateTimeRetailItsSerializer.INSTANCE, localDateTime4);
                        i6 |= 64;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            i5 = i6;
            localDateTime = localDateTime4;
            localDateTime2 = localDateTime5;
            str = str5;
            str2 = str6;
            str3 = str7;
            str4 = str8;
            cateringOrderStatusResponseDTO = cateringOrderStatusResponseDTO3;
        }
        beginStructure.endStructure(serialDescriptor);
        return new SaleOnBoardOrderResponseDTO(i5, str, str2, str3, str4, cateringOrderStatusResponseDTO, localDateTime2, localDateTime, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, SaleOnBoardOrderResponseDTO value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        SaleOnBoardOrderResponseDTO.write$Self$api_kombardoProd(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
