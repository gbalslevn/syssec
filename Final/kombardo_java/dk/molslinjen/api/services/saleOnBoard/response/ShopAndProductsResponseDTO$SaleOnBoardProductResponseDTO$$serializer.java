package dk.molslinjen.api.services.saleOnBoard.response;

import com.sdk.growthbook.utils.Constants;
import dk.molslinjen.api.services.saleOnBoard.response.ShopAndProductsResponseDTO;
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
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"dk/molslinjen/api/services/saleOnBoard/response/ShopAndProductsResponseDTO.SaleOnBoardProductResponseDTO.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Ldk/molslinjen/api/services/saleOnBoard/response/ShopAndProductsResponseDTO$SaleOnBoardProductResponseDTO;", "<init>", "()V", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public /* synthetic */ class ShopAndProductsResponseDTO$SaleOnBoardProductResponseDTO$$serializer implements GeneratedSerializer<ShopAndProductsResponseDTO.SaleOnBoardProductResponseDTO> {
    public static final ShopAndProductsResponseDTO$SaleOnBoardProductResponseDTO$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        ShopAndProductsResponseDTO$SaleOnBoardProductResponseDTO$$serializer shopAndProductsResponseDTO$SaleOnBoardProductResponseDTO$$serializer = new ShopAndProductsResponseDTO$SaleOnBoardProductResponseDTO$$serializer();
        INSTANCE = shopAndProductsResponseDTO$SaleOnBoardProductResponseDTO$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dk.molslinjen.api.services.saleOnBoard.response.ShopAndProductsResponseDTO.SaleOnBoardProductResponseDTO", shopAndProductsResponseDTO$SaleOnBoardProductResponseDTO$$serializer, 9);
        pluginGeneratedSerialDescriptor.addElement(Constants.ID_ATTRIBUTE_KEY, false);
        pluginGeneratedSerialDescriptor.addElement("addOn", false);
        pluginGeneratedSerialDescriptor.addElement("crossSelling", false);
        pluginGeneratedSerialDescriptor.addElement("itemDescription", false);
        pluginGeneratedSerialDescriptor.addElement("itemExtendedText", false);
        pluginGeneratedSerialDescriptor.addElement("itemNo", false);
        pluginGeneratedSerialDescriptor.addElement("modifier", false);
        pluginGeneratedSerialDescriptor.addElement("price", false);
        pluginGeneratedSerialDescriptor.addElement("imageUrl", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private ShopAndProductsResponseDTO$SaleOnBoardProductResponseDTO$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer[] kSerializerArr;
        kSerializerArr = ShopAndProductsResponseDTO.SaleOnBoardProductResponseDTO.$childSerializers;
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{stringSerializer, BuiltinSerializersKt.getNullable(kSerializerArr[1]), BuiltinSerializersKt.getNullable(ShopAndProductsResponseDTO$SaleOnBoardCrossSalesResponseDTO$$serializer.INSTANCE), stringSerializer, BuiltinSerializersKt.getNullable(kSerializerArr[4]), stringSerializer, BuiltinSerializersKt.getNullable(ShopAndProductsResponseDTO$VariantsResponseDTO$$serializer.INSTANCE), DoubleSerializer.INSTANCE, BuiltinSerializersKt.getNullable(stringSerializer)};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x0089. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public final ShopAndProductsResponseDTO.SaleOnBoardProductResponseDTO deserialize(Decoder decoder) {
        KSerializer[] kSerializerArr;
        int i5;
        String str;
        ShopAndProductsResponseDTO.VariantsResponseDTO variantsResponseDTO;
        List list;
        String str2;
        List list2;
        ShopAndProductsResponseDTO.SaleOnBoardCrossSalesResponseDTO saleOnBoardCrossSalesResponseDTO;
        String str3;
        String str4;
        double d5;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        kSerializerArr = ShopAndProductsResponseDTO.SaleOnBoardProductResponseDTO.$childSerializers;
        int i6 = 7;
        int i7 = 6;
        String str5 = null;
        if (beginStructure.decodeSequentially()) {
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 0);
            List list3 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, kSerializerArr[1], null);
            ShopAndProductsResponseDTO.SaleOnBoardCrossSalesResponseDTO saleOnBoardCrossSalesResponseDTO2 = (ShopAndProductsResponseDTO.SaleOnBoardCrossSalesResponseDTO) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, ShopAndProductsResponseDTO$SaleOnBoardCrossSalesResponseDTO$$serializer.INSTANCE, null);
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 3);
            List list4 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, kSerializerArr[4], null);
            String decodeStringElement3 = beginStructure.decodeStringElement(serialDescriptor, 5);
            ShopAndProductsResponseDTO.VariantsResponseDTO variantsResponseDTO2 = (ShopAndProductsResponseDTO.VariantsResponseDTO) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, ShopAndProductsResponseDTO$VariantsResponseDTO$$serializer.INSTANCE, null);
            double decodeDoubleElement = beginStructure.decodeDoubleElement(serialDescriptor, 7);
            list = list4;
            str2 = decodeStringElement;
            str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, StringSerializer.INSTANCE, null);
            variantsResponseDTO = variantsResponseDTO2;
            str4 = decodeStringElement3;
            str3 = decodeStringElement2;
            i5 = 511;
            saleOnBoardCrossSalesResponseDTO = saleOnBoardCrossSalesResponseDTO2;
            list2 = list3;
            d5 = decodeDoubleElement;
        } else {
            boolean z5 = true;
            int i8 = 0;
            String str6 = null;
            ShopAndProductsResponseDTO.VariantsResponseDTO variantsResponseDTO3 = null;
            List list5 = null;
            String str7 = null;
            String str8 = null;
            double d6 = 0.0d;
            List list6 = null;
            ShopAndProductsResponseDTO.SaleOnBoardCrossSalesResponseDTO saleOnBoardCrossSalesResponseDTO3 = null;
            while (z5) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z5 = false;
                        i7 = 6;
                    case 0:
                        str5 = beginStructure.decodeStringElement(serialDescriptor, 0);
                        i8 |= 1;
                        i6 = 7;
                        i7 = 6;
                    case 1:
                        list6 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, kSerializerArr[1], list6);
                        i8 |= 2;
                        i6 = 7;
                        i7 = 6;
                    case 2:
                        saleOnBoardCrossSalesResponseDTO3 = (ShopAndProductsResponseDTO.SaleOnBoardCrossSalesResponseDTO) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, ShopAndProductsResponseDTO$SaleOnBoardCrossSalesResponseDTO$$serializer.INSTANCE, saleOnBoardCrossSalesResponseDTO3);
                        i8 |= 4;
                        i6 = 7;
                        i7 = 6;
                    case 3:
                        str7 = beginStructure.decodeStringElement(serialDescriptor, 3);
                        i8 |= 8;
                    case 4:
                        list5 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, kSerializerArr[4], list5);
                        i8 |= 16;
                    case 5:
                        str8 = beginStructure.decodeStringElement(serialDescriptor, 5);
                        i8 |= 32;
                    case 6:
                        variantsResponseDTO3 = (ShopAndProductsResponseDTO.VariantsResponseDTO) beginStructure.decodeNullableSerializableElement(serialDescriptor, i7, ShopAndProductsResponseDTO$VariantsResponseDTO$$serializer.INSTANCE, variantsResponseDTO3);
                        i8 |= 64;
                    case 7:
                        d6 = beginStructure.decodeDoubleElement(serialDescriptor, i6);
                        i8 |= 128;
                    case 8:
                        str6 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, StringSerializer.INSTANCE, str6);
                        i8 |= 256;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            i5 = i8;
            str = str6;
            variantsResponseDTO = variantsResponseDTO3;
            list = list5;
            str2 = str5;
            list2 = list6;
            saleOnBoardCrossSalesResponseDTO = saleOnBoardCrossSalesResponseDTO3;
            str3 = str7;
            str4 = str8;
            d5 = d6;
        }
        beginStructure.endStructure(serialDescriptor);
        return new ShopAndProductsResponseDTO.SaleOnBoardProductResponseDTO(i5, str2, list2, saleOnBoardCrossSalesResponseDTO, str3, list, str4, variantsResponseDTO, d5, str, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, ShopAndProductsResponseDTO.SaleOnBoardProductResponseDTO value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        ShopAndProductsResponseDTO.SaleOnBoardProductResponseDTO.write$Self$api_kombardoProd(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
