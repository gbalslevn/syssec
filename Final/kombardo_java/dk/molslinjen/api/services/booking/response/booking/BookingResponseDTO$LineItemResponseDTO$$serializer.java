package dk.molslinjen.api.services.booking.response.booking;

import com.sdk.growthbook.utils.Constants;
import dk.molslinjen.api.services.booking.response.ProductTypeResponseDTO;
import dk.molslinjen.api.services.booking.response.booking.BookingResponseDTO;
import dk.molslinjen.api.shared.response.PriceWithCurrencyDTO;
import dk.molslinjen.api.shared.response.PriceWithCurrencyDTO$$serializer;
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
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"dk/molslinjen/api/services/booking/response/booking/BookingResponseDTO.LineItemResponseDTO.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$LineItemResponseDTO;", "<init>", "()V", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public /* synthetic */ class BookingResponseDTO$LineItemResponseDTO$$serializer implements GeneratedSerializer<BookingResponseDTO.LineItemResponseDTO> {
    public static final BookingResponseDTO$LineItemResponseDTO$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        BookingResponseDTO$LineItemResponseDTO$$serializer bookingResponseDTO$LineItemResponseDTO$$serializer = new BookingResponseDTO$LineItemResponseDTO$$serializer();
        INSTANCE = bookingResponseDTO$LineItemResponseDTO$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dk.molslinjen.api.services.booking.response.booking.BookingResponseDTO.LineItemResponseDTO", bookingResponseDTO$LineItemResponseDTO$$serializer, 9);
        pluginGeneratedSerialDescriptor.addElement(Constants.ID_ATTRIBUTE_KEY, false);
        pluginGeneratedSerialDescriptor.addElement("name", false);
        pluginGeneratedSerialDescriptor.addElement("price", false);
        pluginGeneratedSerialDescriptor.addElement("unitPrice", false);
        pluginGeneratedSerialDescriptor.addElement("productType", false);
        pluginGeneratedSerialDescriptor.addElement("quantity", false);
        pluginGeneratedSerialDescriptor.addElement("imageUrl", false);
        pluginGeneratedSerialDescriptor.addElement("availability", false);
        pluginGeneratedSerialDescriptor.addElement("cateringLocationText", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private BookingResponseDTO$LineItemResponseDTO$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        KSerializer<?> nullable = BuiltinSerializersKt.getNullable(stringSerializer);
        KSerializer<?> nullable2 = BuiltinSerializersKt.getNullable(stringSerializer);
        PriceWithCurrencyDTO$$serializer priceWithCurrencyDTO$$serializer = PriceWithCurrencyDTO$$serializer.INSTANCE;
        return new KSerializer[]{stringSerializer, stringSerializer, priceWithCurrencyDTO$$serializer, priceWithCurrencyDTO$$serializer, ProductTypeResponseDTO.Serializer.INSTANCE, IntSerializer.INSTANCE, nullable, BookingResponseDTO.AvailabilityResponseDTO.Serializer.INSTANCE, nullable2};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x0080. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public final BookingResponseDTO.LineItemResponseDTO deserialize(Decoder decoder) {
        int i5;
        BookingResponseDTO.AvailabilityResponseDTO availabilityResponseDTO;
        String str;
        String str2;
        ProductTypeResponseDTO productTypeResponseDTO;
        PriceWithCurrencyDTO priceWithCurrencyDTO;
        int i6;
        String str3;
        String str4;
        PriceWithCurrencyDTO priceWithCurrencyDTO2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        int i7 = 7;
        int i8 = 6;
        if (beginStructure.decodeSequentially()) {
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 0);
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 1);
            PriceWithCurrencyDTO$$serializer priceWithCurrencyDTO$$serializer = PriceWithCurrencyDTO$$serializer.INSTANCE;
            PriceWithCurrencyDTO priceWithCurrencyDTO3 = (PriceWithCurrencyDTO) beginStructure.decodeSerializableElement(serialDescriptor, 2, priceWithCurrencyDTO$$serializer, null);
            PriceWithCurrencyDTO priceWithCurrencyDTO4 = (PriceWithCurrencyDTO) beginStructure.decodeSerializableElement(serialDescriptor, 3, priceWithCurrencyDTO$$serializer, null);
            ProductTypeResponseDTO productTypeResponseDTO2 = (ProductTypeResponseDTO) beginStructure.decodeSerializableElement(serialDescriptor, 4, ProductTypeResponseDTO.Serializer.INSTANCE, null);
            int decodeIntElement = beginStructure.decodeIntElement(serialDescriptor, 5);
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            String str5 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, stringSerializer, null);
            str3 = decodeStringElement;
            availabilityResponseDTO = (BookingResponseDTO.AvailabilityResponseDTO) beginStructure.decodeSerializableElement(serialDescriptor, 7, BookingResponseDTO.AvailabilityResponseDTO.Serializer.INSTANCE, null);
            str2 = str5;
            i5 = decodeIntElement;
            priceWithCurrencyDTO = priceWithCurrencyDTO4;
            str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, stringSerializer, null);
            productTypeResponseDTO = productTypeResponseDTO2;
            priceWithCurrencyDTO2 = priceWithCurrencyDTO3;
            str4 = decodeStringElement2;
            i6 = 511;
        } else {
            boolean z5 = true;
            int i9 = 0;
            BookingResponseDTO.AvailabilityResponseDTO availabilityResponseDTO2 = null;
            String str6 = null;
            String str7 = null;
            ProductTypeResponseDTO productTypeResponseDTO3 = null;
            String str8 = null;
            String str9 = null;
            PriceWithCurrencyDTO priceWithCurrencyDTO5 = null;
            PriceWithCurrencyDTO priceWithCurrencyDTO6 = null;
            int i10 = 0;
            while (z5) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z5 = false;
                        i7 = 7;
                    case 0:
                        i10 |= 1;
                        str8 = beginStructure.decodeStringElement(serialDescriptor, 0);
                        i7 = 7;
                        i8 = 6;
                    case 1:
                        str9 = beginStructure.decodeStringElement(serialDescriptor, 1);
                        i10 |= 2;
                        i7 = 7;
                        i8 = 6;
                    case 2:
                        priceWithCurrencyDTO5 = (PriceWithCurrencyDTO) beginStructure.decodeSerializableElement(serialDescriptor, 2, PriceWithCurrencyDTO$$serializer.INSTANCE, priceWithCurrencyDTO5);
                        i10 |= 4;
                        i7 = 7;
                        i8 = 6;
                    case 3:
                        priceWithCurrencyDTO6 = (PriceWithCurrencyDTO) beginStructure.decodeSerializableElement(serialDescriptor, 3, PriceWithCurrencyDTO$$serializer.INSTANCE, priceWithCurrencyDTO6);
                        i10 |= 8;
                        i7 = 7;
                        i8 = 6;
                    case 4:
                        productTypeResponseDTO3 = (ProductTypeResponseDTO) beginStructure.decodeSerializableElement(serialDescriptor, 4, ProductTypeResponseDTO.Serializer.INSTANCE, productTypeResponseDTO3);
                        i10 |= 16;
                        i7 = 7;
                        i8 = 6;
                    case 5:
                        i9 = beginStructure.decodeIntElement(serialDescriptor, 5);
                        i10 |= 32;
                    case 6:
                        str7 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, i8, StringSerializer.INSTANCE, str7);
                        i10 |= 64;
                    case 7:
                        availabilityResponseDTO2 = (BookingResponseDTO.AvailabilityResponseDTO) beginStructure.decodeSerializableElement(serialDescriptor, i7, BookingResponseDTO.AvailabilityResponseDTO.Serializer.INSTANCE, availabilityResponseDTO2);
                        i10 |= 128;
                    case 8:
                        str6 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, StringSerializer.INSTANCE, str6);
                        i10 |= 256;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            i5 = i9;
            availabilityResponseDTO = availabilityResponseDTO2;
            str = str6;
            str2 = str7;
            productTypeResponseDTO = productTypeResponseDTO3;
            priceWithCurrencyDTO = priceWithCurrencyDTO6;
            i6 = i10;
            str3 = str8;
            str4 = str9;
            priceWithCurrencyDTO2 = priceWithCurrencyDTO5;
        }
        beginStructure.endStructure(serialDescriptor);
        return new BookingResponseDTO.LineItemResponseDTO(i6, str3, str4, priceWithCurrencyDTO2, priceWithCurrencyDTO, productTypeResponseDTO, i5, str2, availabilityResponseDTO, str, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, BookingResponseDTO.LineItemResponseDTO value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        BookingResponseDTO.LineItemResponseDTO.write$Self$api_kombardoProd(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
