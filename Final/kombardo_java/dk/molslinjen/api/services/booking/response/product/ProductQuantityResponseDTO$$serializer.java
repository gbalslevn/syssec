package dk.molslinjen.api.services.booking.response.product;

import com.sdk.growthbook.utils.Constants;
import dk.molslinjen.api.services.booking.response.ProductTypeResponseDTO;
import dk.molslinjen.api.services.booking.response.product.presentation.ProductPresentationResponseDTO;
import dk.molslinjen.api.services.booking.response.product.presentation.ProductPresentationResponseDTOSerializer;
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
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"dk/molslinjen/api/services/booking/response/product/ProductQuantityResponseDTO.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Ldk/molslinjen/api/services/booking/response/product/ProductQuantityResponseDTO;", "<init>", "()V", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public /* synthetic */ class ProductQuantityResponseDTO$$serializer implements GeneratedSerializer<ProductQuantityResponseDTO> {
    public static final ProductQuantityResponseDTO$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        ProductQuantityResponseDTO$$serializer productQuantityResponseDTO$$serializer = new ProductQuantityResponseDTO$$serializer();
        INSTANCE = productQuantityResponseDTO$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dk.molslinjen.api.services.booking.response.product.ProductQuantityResponseDTO", productQuantityResponseDTO$$serializer, 11);
        pluginGeneratedSerialDescriptor.addElement(Constants.ID_ATTRIBUTE_KEY, false);
        pluginGeneratedSerialDescriptor.addElement("name", false);
        pluginGeneratedSerialDescriptor.addElement("price", false);
        pluginGeneratedSerialDescriptor.addElement("originalPrice", true);
        pluginGeneratedSerialDescriptor.addElement("quantity", false);
        pluginGeneratedSerialDescriptor.addElement("disabled", false);
        pluginGeneratedSerialDescriptor.addElement("presentation", false);
        pluginGeneratedSerialDescriptor.addElement("productType", false);
        pluginGeneratedSerialDescriptor.addElement("tags", false);
        pluginGeneratedSerialDescriptor.addElement("maxQuantity", false);
        pluginGeneratedSerialDescriptor.addElement("minFirstStep", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private ProductQuantityResponseDTO$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer[] kSerializerArr;
        kSerializerArr = ProductQuantityResponseDTO.$childSerializers;
        PriceWithCurrencyDTO$$serializer priceWithCurrencyDTO$$serializer = PriceWithCurrencyDTO$$serializer.INSTANCE;
        KSerializer<?> nullable = BuiltinSerializersKt.getNullable(priceWithCurrencyDTO$$serializer);
        KSerializer<?> nullable2 = BuiltinSerializersKt.getNullable(kSerializerArr[8]);
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        IntSerializer intSerializer = IntSerializer.INSTANCE;
        return new KSerializer[]{stringSerializer, stringSerializer, priceWithCurrencyDTO$$serializer, nullable, intSerializer, BooleanSerializer.INSTANCE, ProductPresentationResponseDTOSerializer.INSTANCE, ProductTypeResponseDTO.Serializer.INSTANCE, nullable2, intSerializer, intSerializer};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x0098. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public final ProductQuantityResponseDTO deserialize(Decoder decoder) {
        KSerializer[] kSerializerArr;
        int i5;
        List list;
        ProductPresentationResponseDTO productPresentationResponseDTO;
        ProductTypeResponseDTO productTypeResponseDTO;
        PriceWithCurrencyDTO priceWithCurrencyDTO;
        PriceWithCurrencyDTO priceWithCurrencyDTO2;
        int i6;
        int i7;
        boolean z5;
        int i8;
        String str;
        String str2;
        char c5;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        kSerializerArr = ProductQuantityResponseDTO.$childSerializers;
        int i9 = 10;
        int i10 = 9;
        int i11 = 0;
        if (beginStructure.decodeSequentially()) {
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 0);
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 1);
            PriceWithCurrencyDTO$$serializer priceWithCurrencyDTO$$serializer = PriceWithCurrencyDTO$$serializer.INSTANCE;
            PriceWithCurrencyDTO priceWithCurrencyDTO3 = (PriceWithCurrencyDTO) beginStructure.decodeSerializableElement(serialDescriptor, 2, priceWithCurrencyDTO$$serializer, null);
            PriceWithCurrencyDTO priceWithCurrencyDTO4 = (PriceWithCurrencyDTO) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, priceWithCurrencyDTO$$serializer, null);
            int decodeIntElement = beginStructure.decodeIntElement(serialDescriptor, 4);
            boolean decodeBooleanElement = beginStructure.decodeBooleanElement(serialDescriptor, 5);
            ProductPresentationResponseDTO productPresentationResponseDTO2 = (ProductPresentationResponseDTO) beginStructure.decodeSerializableElement(serialDescriptor, 6, ProductPresentationResponseDTOSerializer.INSTANCE, null);
            ProductTypeResponseDTO productTypeResponseDTO2 = (ProductTypeResponseDTO) beginStructure.decodeSerializableElement(serialDescriptor, 7, ProductTypeResponseDTO.Serializer.INSTANCE, null);
            List list2 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, kSerializerArr[8], null);
            int decodeIntElement2 = beginStructure.decodeIntElement(serialDescriptor, 9);
            list = list2;
            str = decodeStringElement;
            i5 = beginStructure.decodeIntElement(serialDescriptor, 10);
            i7 = decodeIntElement2;
            productTypeResponseDTO = productTypeResponseDTO2;
            productPresentationResponseDTO = productPresentationResponseDTO2;
            z5 = decodeBooleanElement;
            priceWithCurrencyDTO = priceWithCurrencyDTO4;
            i8 = decodeIntElement;
            priceWithCurrencyDTO2 = priceWithCurrencyDTO3;
            i6 = 2047;
            str2 = decodeStringElement2;
        } else {
            boolean z6 = true;
            int i12 = 0;
            boolean z7 = false;
            int i13 = 0;
            List list3 = null;
            ProductPresentationResponseDTO productPresentationResponseDTO3 = null;
            ProductTypeResponseDTO productTypeResponseDTO3 = null;
            PriceWithCurrencyDTO priceWithCurrencyDTO5 = null;
            PriceWithCurrencyDTO priceWithCurrencyDTO6 = null;
            String str3 = null;
            String str4 = null;
            int i14 = 0;
            while (z6) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z6 = false;
                        i9 = 10;
                    case 0:
                        str3 = beginStructure.decodeStringElement(serialDescriptor, 0);
                        i11 |= 1;
                        i9 = 10;
                        i10 = 9;
                    case 1:
                        str4 = beginStructure.decodeStringElement(serialDescriptor, 1);
                        i11 |= 2;
                        i9 = 10;
                        i10 = 9;
                    case 2:
                        priceWithCurrencyDTO6 = (PriceWithCurrencyDTO) beginStructure.decodeSerializableElement(serialDescriptor, 2, PriceWithCurrencyDTO$$serializer.INSTANCE, priceWithCurrencyDTO6);
                        i11 |= 4;
                        i9 = 10;
                        i10 = 9;
                    case 3:
                        priceWithCurrencyDTO5 = (PriceWithCurrencyDTO) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, PriceWithCurrencyDTO$$serializer.INSTANCE, priceWithCurrencyDTO5);
                        i11 |= 8;
                        i9 = 10;
                        i10 = 9;
                    case 4:
                        i13 = beginStructure.decodeIntElement(serialDescriptor, 4);
                        i11 |= 16;
                        i9 = 10;
                    case 5:
                        c5 = 6;
                        z7 = beginStructure.decodeBooleanElement(serialDescriptor, 5);
                        i11 |= 32;
                        i9 = 10;
                    case 6:
                        c5 = 6;
                        productPresentationResponseDTO3 = (ProductPresentationResponseDTO) beginStructure.decodeSerializableElement(serialDescriptor, 6, ProductPresentationResponseDTOSerializer.INSTANCE, productPresentationResponseDTO3);
                        i11 |= 64;
                        i9 = 10;
                    case 7:
                        productTypeResponseDTO3 = (ProductTypeResponseDTO) beginStructure.decodeSerializableElement(serialDescriptor, 7, ProductTypeResponseDTO.Serializer.INSTANCE, productTypeResponseDTO3);
                        i11 |= 128;
                    case 8:
                        list3 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, kSerializerArr[8], list3);
                        i11 |= 256;
                    case 9:
                        i14 = beginStructure.decodeIntElement(serialDescriptor, i10);
                        i11 |= 512;
                    case 10:
                        i12 = beginStructure.decodeIntElement(serialDescriptor, i9);
                        i11 |= 1024;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            i5 = i12;
            list = list3;
            productPresentationResponseDTO = productPresentationResponseDTO3;
            productTypeResponseDTO = productTypeResponseDTO3;
            priceWithCurrencyDTO = priceWithCurrencyDTO5;
            priceWithCurrencyDTO2 = priceWithCurrencyDTO6;
            i6 = i11;
            i7 = i14;
            z5 = z7;
            i8 = i13;
            str = str3;
            str2 = str4;
        }
        beginStructure.endStructure(serialDescriptor);
        return new ProductQuantityResponseDTO(i6, str, str2, priceWithCurrencyDTO2, priceWithCurrencyDTO, i8, z5, productPresentationResponseDTO, productTypeResponseDTO, list, i7, i5, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, ProductQuantityResponseDTO value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        ProductQuantityResponseDTO.write$Self$api_kombardoProd(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
