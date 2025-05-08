package dk.molslinjen.api.services.booking.response.booking;

import com.sdk.growthbook.utils.Constants;
import dk.molslinjen.api.services.booking.response.booking.BookingResponseDTO;
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
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"dk/molslinjen/api/services/booking/response/booking/BookingResponseDTO.BookingSeatDTO.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$BookingSeatDTO;", "<init>", "()V", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public /* synthetic */ class BookingResponseDTO$BookingSeatDTO$$serializer implements GeneratedSerializer<BookingResponseDTO.BookingSeatDTO> {
    public static final BookingResponseDTO$BookingSeatDTO$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        BookingResponseDTO$BookingSeatDTO$$serializer bookingResponseDTO$BookingSeatDTO$$serializer = new BookingResponseDTO$BookingSeatDTO$$serializer();
        INSTANCE = bookingResponseDTO$BookingSeatDTO$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dk.molslinjen.api.services.booking.response.booking.BookingResponseDTO.BookingSeatDTO", bookingResponseDTO$BookingSeatDTO$$serializer, 4);
        pluginGeneratedSerialDescriptor.addElement(Constants.ID_ATTRIBUTE_KEY, false);
        pluginGeneratedSerialDescriptor.addElement("seatPrice", false);
        pluginGeneratedSerialDescriptor.addElement("text", false);
        pluginGeneratedSerialDescriptor.addElement("sectionName", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private BookingResponseDTO$BookingSeatDTO$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{IntSerializer.INSTANCE, PriceWithCurrencyDTO$$serializer.INSTANCE, stringSerializer, stringSerializer};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final BookingResponseDTO.BookingSeatDTO deserialize(Decoder decoder) {
        int i5;
        int i6;
        PriceWithCurrencyDTO priceWithCurrencyDTO;
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        if (beginStructure.decodeSequentially()) {
            int decodeIntElement = beginStructure.decodeIntElement(serialDescriptor, 0);
            PriceWithCurrencyDTO priceWithCurrencyDTO2 = (PriceWithCurrencyDTO) beginStructure.decodeSerializableElement(serialDescriptor, 1, PriceWithCurrencyDTO$$serializer.INSTANCE, null);
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 2);
            i5 = decodeIntElement;
            str2 = beginStructure.decodeStringElement(serialDescriptor, 3);
            str = decodeStringElement;
            priceWithCurrencyDTO = priceWithCurrencyDTO2;
            i6 = 15;
        } else {
            boolean z5 = true;
            int i7 = 0;
            PriceWithCurrencyDTO priceWithCurrencyDTO3 = null;
            String str3 = null;
            String str4 = null;
            int i8 = 0;
            while (z5) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                if (decodeElementIndex == -1) {
                    z5 = false;
                } else if (decodeElementIndex == 0) {
                    i7 = beginStructure.decodeIntElement(serialDescriptor, 0);
                    i8 |= 1;
                } else if (decodeElementIndex == 1) {
                    priceWithCurrencyDTO3 = (PriceWithCurrencyDTO) beginStructure.decodeSerializableElement(serialDescriptor, 1, PriceWithCurrencyDTO$$serializer.INSTANCE, priceWithCurrencyDTO3);
                    i8 |= 2;
                } else if (decodeElementIndex == 2) {
                    str3 = beginStructure.decodeStringElement(serialDescriptor, 2);
                    i8 |= 4;
                } else {
                    if (decodeElementIndex != 3) {
                        throw new UnknownFieldException(decodeElementIndex);
                    }
                    str4 = beginStructure.decodeStringElement(serialDescriptor, 3);
                    i8 |= 8;
                }
            }
            i5 = i7;
            i6 = i8;
            priceWithCurrencyDTO = priceWithCurrencyDTO3;
            str = str3;
            str2 = str4;
        }
        beginStructure.endStructure(serialDescriptor);
        return new BookingResponseDTO.BookingSeatDTO(i6, i5, priceWithCurrencyDTO, str, str2, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, BookingResponseDTO.BookingSeatDTO value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        BookingResponseDTO.BookingSeatDTO.write$Self$api_kombardoProd(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
