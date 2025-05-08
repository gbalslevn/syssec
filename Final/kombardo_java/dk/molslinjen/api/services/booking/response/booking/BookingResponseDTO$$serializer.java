package dk.molslinjen.api.services.booking.response.booking;

import dk.molslinjen.api.helpers.serializers.LocalDateWithTimeSerializer;
import dk.molslinjen.api.services.booking.response.booking.BookingResponseDTO;
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
import org.threeten.bp.LocalDate;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"dk/molslinjen/api/services/booking/response/booking/BookingResponseDTO.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO;", "<init>", "()V", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public /* synthetic */ class BookingResponseDTO$$serializer implements GeneratedSerializer<BookingResponseDTO> {
    public static final BookingResponseDTO$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        BookingResponseDTO$$serializer bookingResponseDTO$$serializer = new BookingResponseDTO$$serializer();
        INSTANCE = bookingResponseDTO$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dk.molslinjen.api.services.booking.response.booking.BookingResponseDTO", bookingResponseDTO$$serializer, 14);
        pluginGeneratedSerialDescriptor.addElement("authenticationInfo", false);
        pluginGeneratedSerialDescriptor.addElement("canChange", false);
        pluginGeneratedSerialDescriptor.addElement("customerInfo", false);
        pluginGeneratedSerialDescriptor.addElement("orderTotal", false);
        pluginGeneratedSerialDescriptor.addElement("isRefundAvailable", false);
        pluginGeneratedSerialDescriptor.addElement("changeFee", false);
        pluginGeneratedSerialDescriptor.addElement("refundAmount", false);
        pluginGeneratedSerialDescriptor.addElement("refundFee", false);
        pluginGeneratedSerialDescriptor.addElement("refundDate", false);
        pluginGeneratedSerialDescriptor.addElement("isRefunded", false);
        pluginGeneratedSerialDescriptor.addElement("isUsed", false);
        pluginGeneratedSerialDescriptor.addElement("reservationId", false);
        pluginGeneratedSerialDescriptor.addElement("tickets", false);
        pluginGeneratedSerialDescriptor.addElement("multiRideInfo", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private BookingResponseDTO$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr;
        kSerializerArr = BookingResponseDTO.$childSerializers;
        PriceWithCurrencyDTO$$serializer priceWithCurrencyDTO$$serializer = PriceWithCurrencyDTO$$serializer.INSTANCE;
        KSerializer<?> nullable = BuiltinSerializersKt.getNullable(priceWithCurrencyDTO$$serializer);
        KSerializer<?> nullable2 = BuiltinSerializersKt.getNullable(priceWithCurrencyDTO$$serializer);
        KSerializer<?> nullable3 = BuiltinSerializersKt.getNullable(priceWithCurrencyDTO$$serializer);
        KSerializer<?> nullable4 = BuiltinSerializersKt.getNullable(LocalDateWithTimeSerializer.INSTANCE);
        KSerializer<?> kSerializer = kSerializerArr[12];
        KSerializer<?> nullable5 = BuiltinSerializersKt.getNullable(BookingResponseDTO$MultiRideInfoResponseDTO$$serializer.INSTANCE);
        BooleanSerializer booleanSerializer = BooleanSerializer.INSTANCE;
        return new KSerializer[]{BookingResponseDTO$AuthenticationInfoResponseDTO$$serializer.INSTANCE, booleanSerializer, BookingResponseDTO$CustomerInfoResponseDTO$$serializer.INSTANCE, priceWithCurrencyDTO$$serializer, booleanSerializer, nullable, nullable2, nullable3, nullable4, booleanSerializer, booleanSerializer, StringSerializer.INSTANCE, kSerializer, nullable5};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x00c6. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public final BookingResponseDTO deserialize(Decoder decoder) {
        KSerializer[] kSerializerArr;
        int i5;
        PriceWithCurrencyDTO priceWithCurrencyDTO;
        boolean z5;
        BookingResponseDTO.AuthenticationInfoResponseDTO authenticationInfoResponseDTO;
        BookingResponseDTO.MultiRideInfoResponseDTO multiRideInfoResponseDTO;
        List list;
        LocalDate localDate;
        PriceWithCurrencyDTO priceWithCurrencyDTO2;
        PriceWithCurrencyDTO priceWithCurrencyDTO3;
        PriceWithCurrencyDTO priceWithCurrencyDTO4;
        BookingResponseDTO.CustomerInfoResponseDTO customerInfoResponseDTO;
        String str;
        boolean z6;
        boolean z7;
        boolean z8;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        kSerializerArr = BookingResponseDTO.$childSerializers;
        int i6 = 10;
        int i7 = 9;
        if (beginStructure.decodeSequentially()) {
            BookingResponseDTO.AuthenticationInfoResponseDTO authenticationInfoResponseDTO2 = (BookingResponseDTO.AuthenticationInfoResponseDTO) beginStructure.decodeSerializableElement(serialDescriptor, 0, BookingResponseDTO$AuthenticationInfoResponseDTO$$serializer.INSTANCE, null);
            boolean decodeBooleanElement = beginStructure.decodeBooleanElement(serialDescriptor, 1);
            BookingResponseDTO.CustomerInfoResponseDTO customerInfoResponseDTO2 = (BookingResponseDTO.CustomerInfoResponseDTO) beginStructure.decodeSerializableElement(serialDescriptor, 2, BookingResponseDTO$CustomerInfoResponseDTO$$serializer.INSTANCE, null);
            PriceWithCurrencyDTO$$serializer priceWithCurrencyDTO$$serializer = PriceWithCurrencyDTO$$serializer.INSTANCE;
            PriceWithCurrencyDTO priceWithCurrencyDTO5 = (PriceWithCurrencyDTO) beginStructure.decodeSerializableElement(serialDescriptor, 3, priceWithCurrencyDTO$$serializer, null);
            boolean decodeBooleanElement2 = beginStructure.decodeBooleanElement(serialDescriptor, 4);
            PriceWithCurrencyDTO priceWithCurrencyDTO6 = (PriceWithCurrencyDTO) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, priceWithCurrencyDTO$$serializer, null);
            PriceWithCurrencyDTO priceWithCurrencyDTO7 = (PriceWithCurrencyDTO) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, priceWithCurrencyDTO$$serializer, null);
            PriceWithCurrencyDTO priceWithCurrencyDTO8 = (PriceWithCurrencyDTO) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, priceWithCurrencyDTO$$serializer, null);
            LocalDate localDate2 = (LocalDate) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, LocalDateWithTimeSerializer.INSTANCE, null);
            boolean decodeBooleanElement3 = beginStructure.decodeBooleanElement(serialDescriptor, 9);
            boolean decodeBooleanElement4 = beginStructure.decodeBooleanElement(serialDescriptor, 10);
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 11);
            List list2 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 12, kSerializerArr[12], null);
            multiRideInfoResponseDTO = (BookingResponseDTO.MultiRideInfoResponseDTO) beginStructure.decodeNullableSerializableElement(serialDescriptor, 13, BookingResponseDTO$MultiRideInfoResponseDTO$$serializer.INSTANCE, null);
            i5 = 16383;
            z5 = decodeBooleanElement;
            z6 = decodeBooleanElement4;
            z7 = decodeBooleanElement3;
            priceWithCurrencyDTO3 = priceWithCurrencyDTO8;
            priceWithCurrencyDTO2 = priceWithCurrencyDTO7;
            priceWithCurrencyDTO4 = priceWithCurrencyDTO6;
            priceWithCurrencyDTO = priceWithCurrencyDTO5;
            localDate = localDate2;
            z8 = decodeBooleanElement2;
            customerInfoResponseDTO = customerInfoResponseDTO2;
            str = decodeStringElement;
            list = list2;
            authenticationInfoResponseDTO = authenticationInfoResponseDTO2;
        } else {
            boolean z9 = true;
            PriceWithCurrencyDTO priceWithCurrencyDTO9 = null;
            BookingResponseDTO.MultiRideInfoResponseDTO multiRideInfoResponseDTO2 = null;
            List list3 = null;
            LocalDate localDate3 = null;
            PriceWithCurrencyDTO priceWithCurrencyDTO10 = null;
            PriceWithCurrencyDTO priceWithCurrencyDTO11 = null;
            PriceWithCurrencyDTO priceWithCurrencyDTO12 = null;
            BookingResponseDTO.AuthenticationInfoResponseDTO authenticationInfoResponseDTO3 = null;
            String str2 = null;
            int i8 = 0;
            boolean z10 = false;
            boolean z11 = false;
            boolean z12 = false;
            boolean z13 = false;
            BookingResponseDTO.CustomerInfoResponseDTO customerInfoResponseDTO3 = null;
            while (z9) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z9 = false;
                        i7 = 9;
                    case 0:
                        i8 |= 1;
                        authenticationInfoResponseDTO3 = (BookingResponseDTO.AuthenticationInfoResponseDTO) beginStructure.decodeSerializableElement(serialDescriptor, 0, BookingResponseDTO$AuthenticationInfoResponseDTO$$serializer.INSTANCE, authenticationInfoResponseDTO3);
                        i6 = 10;
                        i7 = 9;
                    case 1:
                        z13 = beginStructure.decodeBooleanElement(serialDescriptor, 1);
                        i8 |= 2;
                        i6 = 10;
                        i7 = 9;
                    case 2:
                        customerInfoResponseDTO3 = (BookingResponseDTO.CustomerInfoResponseDTO) beginStructure.decodeSerializableElement(serialDescriptor, 2, BookingResponseDTO$CustomerInfoResponseDTO$$serializer.INSTANCE, customerInfoResponseDTO3);
                        i8 |= 4;
                        i6 = 10;
                        i7 = 9;
                    case 3:
                        priceWithCurrencyDTO9 = (PriceWithCurrencyDTO) beginStructure.decodeSerializableElement(serialDescriptor, 3, PriceWithCurrencyDTO$$serializer.INSTANCE, priceWithCurrencyDTO9);
                        i8 |= 8;
                        i6 = 10;
                        i7 = 9;
                    case 4:
                        z12 = beginStructure.decodeBooleanElement(serialDescriptor, 4);
                        i8 |= 16;
                        i6 = 10;
                        i7 = 9;
                    case 5:
                        priceWithCurrencyDTO12 = (PriceWithCurrencyDTO) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, PriceWithCurrencyDTO$$serializer.INSTANCE, priceWithCurrencyDTO12);
                        i8 |= 32;
                        i6 = 10;
                        i7 = 9;
                    case 6:
                        priceWithCurrencyDTO10 = (PriceWithCurrencyDTO) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, PriceWithCurrencyDTO$$serializer.INSTANCE, priceWithCurrencyDTO10);
                        i8 |= 64;
                        i6 = 10;
                        i7 = 9;
                    case 7:
                        priceWithCurrencyDTO11 = (PriceWithCurrencyDTO) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, PriceWithCurrencyDTO$$serializer.INSTANCE, priceWithCurrencyDTO11);
                        i8 |= 128;
                        i6 = 10;
                        i7 = 9;
                    case 8:
                        localDate3 = (LocalDate) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, LocalDateWithTimeSerializer.INSTANCE, localDate3);
                        i8 |= 256;
                        i6 = 10;
                        i7 = 9;
                    case 9:
                        int i9 = i7;
                        z11 = beginStructure.decodeBooleanElement(serialDescriptor, i9);
                        i8 |= 512;
                        i7 = i9;
                        i6 = 10;
                    case 10:
                        z10 = beginStructure.decodeBooleanElement(serialDescriptor, i6);
                        i8 |= 1024;
                        i7 = 9;
                    case 11:
                        str2 = beginStructure.decodeStringElement(serialDescriptor, 11);
                        i8 |= 2048;
                        i7 = 9;
                    case 12:
                        list3 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 12, kSerializerArr[12], list3);
                        i8 |= 4096;
                        i7 = 9;
                    case 13:
                        multiRideInfoResponseDTO2 = (BookingResponseDTO.MultiRideInfoResponseDTO) beginStructure.decodeNullableSerializableElement(serialDescriptor, 13, BookingResponseDTO$MultiRideInfoResponseDTO$$serializer.INSTANCE, multiRideInfoResponseDTO2);
                        i8 |= 8192;
                        i7 = 9;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            i5 = i8;
            priceWithCurrencyDTO = priceWithCurrencyDTO9;
            z5 = z13;
            authenticationInfoResponseDTO = authenticationInfoResponseDTO3;
            multiRideInfoResponseDTO = multiRideInfoResponseDTO2;
            list = list3;
            localDate = localDate3;
            priceWithCurrencyDTO2 = priceWithCurrencyDTO10;
            priceWithCurrencyDTO3 = priceWithCurrencyDTO11;
            priceWithCurrencyDTO4 = priceWithCurrencyDTO12;
            customerInfoResponseDTO = customerInfoResponseDTO3;
            str = str2;
            z6 = z10;
            z7 = z11;
            z8 = z12;
        }
        beginStructure.endStructure(serialDescriptor);
        return new BookingResponseDTO(i5, authenticationInfoResponseDTO, z5, customerInfoResponseDTO, priceWithCurrencyDTO, z8, priceWithCurrencyDTO4, priceWithCurrencyDTO2, priceWithCurrencyDTO3, localDate, z7, z6, str, list, multiRideInfoResponseDTO, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, BookingResponseDTO value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        BookingResponseDTO.write$Self$api_kombardoProd(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
