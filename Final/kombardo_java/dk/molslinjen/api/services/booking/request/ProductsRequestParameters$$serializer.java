package dk.molslinjen.api.services.booking.request;

import dk.molslinjen.api.services.booking.request.DirectionDTO;
import dk.molslinjen.api.shared.response.CurrencyTypeDTO;
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
import kotlinx.serialization.internal.StringSerializer;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"dk/molslinjen/api/services/booking/request/ProductsRequestParameters.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Ldk/molslinjen/api/services/booking/request/ProductsRequestParameters;", "<init>", "()V", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public /* synthetic */ class ProductsRequestParameters$$serializer implements GeneratedSerializer<ProductsRequestParameters> {
    public static final ProductsRequestParameters$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        ProductsRequestParameters$$serializer productsRequestParameters$$serializer = new ProductsRequestParameters$$serializer();
        INSTANCE = productsRequestParameters$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dk.molslinjen.api.services.booking.request.ProductsRequestParameters", productsRequestParameters$$serializer, 8);
        pluginGeneratedSerialDescriptor.addElement("carId", false);
        pluginGeneratedSerialDescriptor.addElement("departureId", false);
        pluginGeneratedSerialDescriptor.addElement("direction", false);
        pluginGeneratedSerialDescriptor.addElement("passengerCount", false);
        pluginGeneratedSerialDescriptor.addElement("reservationId", false);
        pluginGeneratedSerialDescriptor.addElement("phone", false);
        pluginGeneratedSerialDescriptor.addElement("includeSummaryProducts", false);
        pluginGeneratedSerialDescriptor.addElement("currency", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private ProductsRequestParameters$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{stringSerializer, stringSerializer, DirectionDTO.Serializer.INSTANCE, IntSerializer.INSTANCE, BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BooleanSerializer.INSTANCE, CurrencyTypeDTO.Serializer.INSTANCE};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x0071. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public final ProductsRequestParameters deserialize(Decoder decoder) {
        boolean z5;
        CurrencyTypeDTO currencyTypeDTO;
        String str;
        String str2;
        int i5;
        int i6;
        String str3;
        String str4;
        DirectionDTO directionDTO;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        int i7 = 7;
        int i8 = 6;
        if (beginStructure.decodeSequentially()) {
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 0);
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 1);
            DirectionDTO directionDTO2 = (DirectionDTO) beginStructure.decodeSerializableElement(serialDescriptor, 2, DirectionDTO.Serializer.INSTANCE, null);
            int decodeIntElement = beginStructure.decodeIntElement(serialDescriptor, 3);
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            String str5 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, stringSerializer, null);
            String str6 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, stringSerializer, null);
            boolean decodeBooleanElement = beginStructure.decodeBooleanElement(serialDescriptor, 6);
            str3 = decodeStringElement;
            currencyTypeDTO = (CurrencyTypeDTO) beginStructure.decodeSerializableElement(serialDescriptor, 7, CurrencyTypeDTO.Serializer.INSTANCE, null);
            z5 = decodeBooleanElement;
            str = str6;
            i5 = decodeIntElement;
            str2 = str5;
            directionDTO = directionDTO2;
            str4 = decodeStringElement2;
            i6 = 255;
        } else {
            boolean z6 = true;
            boolean z7 = false;
            int i9 = 0;
            CurrencyTypeDTO currencyTypeDTO2 = null;
            String str7 = null;
            String str8 = null;
            String str9 = null;
            DirectionDTO directionDTO3 = null;
            String str10 = null;
            int i10 = 0;
            while (z6) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z6 = false;
                        i7 = 7;
                    case 0:
                        i9 |= 1;
                        str8 = beginStructure.decodeStringElement(serialDescriptor, 0);
                        i7 = 7;
                        i8 = 6;
                    case 1:
                        str9 = beginStructure.decodeStringElement(serialDescriptor, 1);
                        i9 |= 2;
                        i7 = 7;
                        i8 = 6;
                    case 2:
                        directionDTO3 = (DirectionDTO) beginStructure.decodeSerializableElement(serialDescriptor, 2, DirectionDTO.Serializer.INSTANCE, directionDTO3);
                        i9 |= 4;
                        i7 = 7;
                        i8 = 6;
                    case 3:
                        i10 = beginStructure.decodeIntElement(serialDescriptor, 3);
                        i9 |= 8;
                    case 4:
                        str10 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, str10);
                        i9 |= 16;
                    case 5:
                        str7 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, str7);
                        i9 |= 32;
                    case 6:
                        z7 = beginStructure.decodeBooleanElement(serialDescriptor, i8);
                        i9 |= 64;
                    case 7:
                        currencyTypeDTO2 = (CurrencyTypeDTO) beginStructure.decodeSerializableElement(serialDescriptor, i7, CurrencyTypeDTO.Serializer.INSTANCE, currencyTypeDTO2);
                        i9 |= 128;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            z5 = z7;
            currencyTypeDTO = currencyTypeDTO2;
            str = str7;
            str2 = str10;
            i5 = i10;
            i6 = i9;
            str3 = str8;
            str4 = str9;
            directionDTO = directionDTO3;
        }
        beginStructure.endStructure(serialDescriptor);
        return new ProductsRequestParameters(i6, str3, str4, directionDTO, i5, str2, str, z5, currencyTypeDTO, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, ProductsRequestParameters value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        ProductsRequestParameters.write$Self$api_kombardoProd(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
