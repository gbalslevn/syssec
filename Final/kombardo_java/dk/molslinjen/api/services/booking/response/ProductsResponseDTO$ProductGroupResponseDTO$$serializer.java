package dk.molslinjen.api.services.booking.response;

import dk.molslinjen.api.services.booking.response.ProductsResponseDTO;
import dk.molslinjen.api.services.booking.response.product.ProductResponseDTO;
import java.util.List;
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

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"dk/molslinjen/api/services/booking/response/ProductsResponseDTO.ProductGroupResponseDTO.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Ldk/molslinjen/api/services/booking/response/ProductsResponseDTO$ProductGroupResponseDTO;", "<init>", "()V", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public /* synthetic */ class ProductsResponseDTO$ProductGroupResponseDTO$$serializer implements GeneratedSerializer<ProductsResponseDTO.ProductGroupResponseDTO> {
    public static final ProductsResponseDTO$ProductGroupResponseDTO$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        ProductsResponseDTO$ProductGroupResponseDTO$$serializer productsResponseDTO$ProductGroupResponseDTO$$serializer = new ProductsResponseDTO$ProductGroupResponseDTO$$serializer();
        INSTANCE = productsResponseDTO$ProductGroupResponseDTO$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dk.molslinjen.api.services.booking.response.ProductsResponseDTO.ProductGroupResponseDTO", productsResponseDTO$ProductGroupResponseDTO$$serializer, 4);
        pluginGeneratedSerialDescriptor.addElement("name", false);
        pluginGeneratedSerialDescriptor.addElement("description", false);
        pluginGeneratedSerialDescriptor.addElement("products", false);
        pluginGeneratedSerialDescriptor.addElement("size", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private ProductsResponseDTO$ProductGroupResponseDTO$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{stringSerializer, stringSerializer, ProductResponseDTO.ProductResponseDTOSafeListSerializer.INSTANCE, ProductsResponseDTO.ProductSizeResponseDTO.Serializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final ProductsResponseDTO.ProductGroupResponseDTO deserialize(Decoder decoder) {
        int i5;
        String str;
        String str2;
        List list;
        ProductsResponseDTO.ProductSizeResponseDTO productSizeResponseDTO;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        String str3 = null;
        if (beginStructure.decodeSequentially()) {
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 0);
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 1);
            List list2 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 2, ProductResponseDTO.ProductResponseDTOSafeListSerializer.INSTANCE, null);
            str = decodeStringElement;
            productSizeResponseDTO = (ProductsResponseDTO.ProductSizeResponseDTO) beginStructure.decodeSerializableElement(serialDescriptor, 3, ProductsResponseDTO.ProductSizeResponseDTO.Serializer.INSTANCE, null);
            list = list2;
            str2 = decodeStringElement2;
            i5 = 15;
        } else {
            boolean z5 = true;
            int i6 = 0;
            String str4 = null;
            List list3 = null;
            ProductsResponseDTO.ProductSizeResponseDTO productSizeResponseDTO2 = null;
            while (z5) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                if (decodeElementIndex == -1) {
                    z5 = false;
                } else if (decodeElementIndex == 0) {
                    str3 = beginStructure.decodeStringElement(serialDescriptor, 0);
                    i6 |= 1;
                } else if (decodeElementIndex == 1) {
                    str4 = beginStructure.decodeStringElement(serialDescriptor, 1);
                    i6 |= 2;
                } else if (decodeElementIndex == 2) {
                    list3 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 2, ProductResponseDTO.ProductResponseDTOSafeListSerializer.INSTANCE, list3);
                    i6 |= 4;
                } else {
                    if (decodeElementIndex != 3) {
                        throw new UnknownFieldException(decodeElementIndex);
                    }
                    productSizeResponseDTO2 = (ProductsResponseDTO.ProductSizeResponseDTO) beginStructure.decodeSerializableElement(serialDescriptor, 3, ProductsResponseDTO.ProductSizeResponseDTO.Serializer.INSTANCE, productSizeResponseDTO2);
                    i6 |= 8;
                }
            }
            i5 = i6;
            str = str3;
            str2 = str4;
            list = list3;
            productSizeResponseDTO = productSizeResponseDTO2;
        }
        beginStructure.endStructure(serialDescriptor);
        return new ProductsResponseDTO.ProductGroupResponseDTO(i5, str, str2, list, productSizeResponseDTO, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, ProductsResponseDTO.ProductGroupResponseDTO value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        ProductsResponseDTO.ProductGroupResponseDTO.write$Self$api_kombardoProd(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
