package dk.molslinjen.api.services.booking.response;

import dk.molslinjen.api.services.booking.response.ProductsResponseDTO;
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
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"dk/molslinjen/api/services/booking/response/ProductsResponseDTO.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Ldk/molslinjen/api/services/booking/response/ProductsResponseDTO;", "<init>", "()V", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public /* synthetic */ class ProductsResponseDTO$$serializer implements GeneratedSerializer<ProductsResponseDTO> {
    public static final ProductsResponseDTO$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        ProductsResponseDTO$$serializer productsResponseDTO$$serializer = new ProductsResponseDTO$$serializer();
        INSTANCE = productsResponseDTO$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dk.molslinjen.api.services.booking.response.ProductsResponseDTO", productsResponseDTO$$serializer, 3);
        pluginGeneratedSerialDescriptor.addElement("groups", false);
        pluginGeneratedSerialDescriptor.addElement("unavailableProducts", false);
        pluginGeneratedSerialDescriptor.addElement("recommendedProductsGroup", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private ProductsResponseDTO$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer[] kSerializerArr;
        kSerializerArr = ProductsResponseDTO.$childSerializers;
        return new KSerializer[]{BuiltinSerializersKt.getNullable(kSerializerArr[0]), BuiltinSerializersKt.getNullable(ProductsResponseDTO.UnavailableProductResponseDTO.UnavailableProductResponseDTOSafeListSerializer.INSTANCE), BuiltinSerializersKt.getNullable(ProductsResponseDTO$ProductGroupResponseDTO$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final ProductsResponseDTO deserialize(Decoder decoder) {
        KSerializer[] kSerializerArr;
        int i5;
        List list;
        List list2;
        ProductsResponseDTO.ProductGroupResponseDTO productGroupResponseDTO;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        kSerializerArr = ProductsResponseDTO.$childSerializers;
        List list3 = null;
        if (beginStructure.decodeSequentially()) {
            list = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, kSerializerArr[0], null);
            list2 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, ProductsResponseDTO.UnavailableProductResponseDTO.UnavailableProductResponseDTOSafeListSerializer.INSTANCE, null);
            productGroupResponseDTO = (ProductsResponseDTO.ProductGroupResponseDTO) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, ProductsResponseDTO$ProductGroupResponseDTO$$serializer.INSTANCE, null);
            i5 = 7;
        } else {
            boolean z5 = true;
            int i6 = 0;
            List list4 = null;
            ProductsResponseDTO.ProductGroupResponseDTO productGroupResponseDTO2 = null;
            while (z5) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                if (decodeElementIndex == -1) {
                    z5 = false;
                } else if (decodeElementIndex == 0) {
                    list3 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, kSerializerArr[0], list3);
                    i6 |= 1;
                } else if (decodeElementIndex == 1) {
                    list4 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, ProductsResponseDTO.UnavailableProductResponseDTO.UnavailableProductResponseDTOSafeListSerializer.INSTANCE, list4);
                    i6 |= 2;
                } else {
                    if (decodeElementIndex != 2) {
                        throw new UnknownFieldException(decodeElementIndex);
                    }
                    productGroupResponseDTO2 = (ProductsResponseDTO.ProductGroupResponseDTO) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, ProductsResponseDTO$ProductGroupResponseDTO$$serializer.INSTANCE, productGroupResponseDTO2);
                    i6 |= 4;
                }
            }
            i5 = i6;
            list = list3;
            list2 = list4;
            productGroupResponseDTO = productGroupResponseDTO2;
        }
        beginStructure.endStructure(serialDescriptor);
        return new ProductsResponseDTO(i5, list, list2, productGroupResponseDTO, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, ProductsResponseDTO value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        ProductsResponseDTO.write$Self$api_kombardoProd(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
