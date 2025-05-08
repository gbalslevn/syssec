package dk.molslinjen.api.services.booking.response.booking;

import dk.molslinjen.api.services.booking.request.DirectionDTO;
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

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"dk/molslinjen/api/services/booking/response/booking/BookingResponseDTO.TicketResponseDTO.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$TicketResponseDTO;", "<init>", "()V", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public /* synthetic */ class BookingResponseDTO$TicketResponseDTO$$serializer implements GeneratedSerializer<BookingResponseDTO.TicketResponseDTO> {
    public static final BookingResponseDTO$TicketResponseDTO$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        BookingResponseDTO$TicketResponseDTO$$serializer bookingResponseDTO$TicketResponseDTO$$serializer = new BookingResponseDTO$TicketResponseDTO$$serializer();
        INSTANCE = bookingResponseDTO$TicketResponseDTO$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dk.molslinjen.api.services.booking.response.booking.BookingResponseDTO.TicketResponseDTO", bookingResponseDTO$TicketResponseDTO$$serializer, 17);
        pluginGeneratedSerialDescriptor.addElement("departure", false);
        pluginGeneratedSerialDescriptor.addElement("directionType", false);
        pluginGeneratedSerialDescriptor.addElement("editInfo", false);
        pluginGeneratedSerialDescriptor.addElement("goods", false);
        pluginGeneratedSerialDescriptor.addElement("isCheckedIn", false);
        pluginGeneratedSerialDescriptor.addElement("products", false);
        pluginGeneratedSerialDescriptor.addElement("notes", false);
        pluginGeneratedSerialDescriptor.addElement("passengerInfo", false);
        pluginGeneratedSerialDescriptor.addElement("ticketPrice", false);
        pluginGeneratedSerialDescriptor.addElement("totalPrice", false);
        pluginGeneratedSerialDescriptor.addElement("ticketCategoryName", false);
        pluginGeneratedSerialDescriptor.addElement("ticketTypeId", false);
        pluginGeneratedSerialDescriptor.addElement("transportInfo", false);
        pluginGeneratedSerialDescriptor.addElement("barcodes", false);
        pluginGeneratedSerialDescriptor.addElement("availableProductTypes", false);
        pluginGeneratedSerialDescriptor.addElement("seatReservation", false);
        pluginGeneratedSerialDescriptor.addElement("surcharges", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private BookingResponseDTO$TicketResponseDTO$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr;
        kSerializerArr = BookingResponseDTO.TicketResponseDTO.$childSerializers;
        KSerializer<?> nullable = BuiltinSerializersKt.getNullable(BookingResponseDTO$GoodsResponseDTO$$serializer.INSTANCE);
        KSerializer<?> kSerializer = kSerializerArr[5];
        KSerializer<?> kSerializer2 = kSerializerArr[6];
        KSerializer<?> nullable2 = BuiltinSerializersKt.getNullable(kSerializerArr[13]);
        KSerializer<?> nullable3 = BuiltinSerializersKt.getNullable(kSerializerArr[14]);
        KSerializer<?> nullable4 = BuiltinSerializersKt.getNullable(BookingResponseDTO$BookingSeatReservationDTO$$serializer.INSTANCE);
        KSerializer<?> kSerializer3 = kSerializerArr[16];
        PriceWithCurrencyDTO$$serializer priceWithCurrencyDTO$$serializer = PriceWithCurrencyDTO$$serializer.INSTANCE;
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{BookingResponseDTO$DepartureResponseDTO$$serializer.INSTANCE, DirectionDTO.Serializer.INSTANCE, BookingResponseDTO$EditInfoResponseDTO$$serializer.INSTANCE, nullable, BooleanSerializer.INSTANCE, kSerializer, kSerializer2, BookingResponseDTO$PassengerInfoResponseDTO$$serializer.INSTANCE, priceWithCurrencyDTO$$serializer, priceWithCurrencyDTO$$serializer, stringSerializer, stringSerializer, BookingResponseDTO$TransportInfoDTO$$serializer.INSTANCE, nullable2, nullable3, nullable4, kSerializer3};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x0103. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public final BookingResponseDTO.TicketResponseDTO deserialize(Decoder decoder) {
        KSerializer[] kSerializerArr;
        BookingResponseDTO.BookingSeatReservationDTO bookingSeatReservationDTO;
        PriceWithCurrencyDTO priceWithCurrencyDTO;
        int i5;
        List list;
        List list2;
        PriceWithCurrencyDTO priceWithCurrencyDTO2;
        List list3;
        BookingResponseDTO.TransportInfoDTO transportInfoDTO;
        List list4;
        BookingResponseDTO.GoodsResponseDTO goodsResponseDTO;
        BookingResponseDTO.PassengerInfoResponseDTO passengerInfoResponseDTO;
        BookingResponseDTO.DepartureResponseDTO departureResponseDTO;
        DirectionDTO directionDTO;
        BookingResponseDTO.EditInfoResponseDTO editInfoResponseDTO;
        String str;
        String str2;
        List list5;
        boolean z5;
        KSerializer[] kSerializerArr2;
        BookingResponseDTO.EditInfoResponseDTO editInfoResponseDTO2;
        BookingResponseDTO.BookingSeatReservationDTO bookingSeatReservationDTO2;
        DirectionDTO directionDTO2;
        BookingResponseDTO.EditInfoResponseDTO editInfoResponseDTO3;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        kSerializerArr = BookingResponseDTO.TicketResponseDTO.$childSerializers;
        if (beginStructure.decodeSequentially()) {
            BookingResponseDTO.DepartureResponseDTO departureResponseDTO2 = (BookingResponseDTO.DepartureResponseDTO) beginStructure.decodeSerializableElement(serialDescriptor, 0, BookingResponseDTO$DepartureResponseDTO$$serializer.INSTANCE, null);
            DirectionDTO directionDTO3 = (DirectionDTO) beginStructure.decodeSerializableElement(serialDescriptor, 1, DirectionDTO.Serializer.INSTANCE, null);
            BookingResponseDTO.EditInfoResponseDTO editInfoResponseDTO4 = (BookingResponseDTO.EditInfoResponseDTO) beginStructure.decodeSerializableElement(serialDescriptor, 2, BookingResponseDTO$EditInfoResponseDTO$$serializer.INSTANCE, null);
            BookingResponseDTO.GoodsResponseDTO goodsResponseDTO2 = (BookingResponseDTO.GoodsResponseDTO) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, BookingResponseDTO$GoodsResponseDTO$$serializer.INSTANCE, null);
            boolean decodeBooleanElement = beginStructure.decodeBooleanElement(serialDescriptor, 4);
            List list6 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 5, kSerializerArr[5], null);
            List list7 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 6, kSerializerArr[6], null);
            BookingResponseDTO.PassengerInfoResponseDTO passengerInfoResponseDTO2 = (BookingResponseDTO.PassengerInfoResponseDTO) beginStructure.decodeSerializableElement(serialDescriptor, 7, BookingResponseDTO$PassengerInfoResponseDTO$$serializer.INSTANCE, null);
            PriceWithCurrencyDTO$$serializer priceWithCurrencyDTO$$serializer = PriceWithCurrencyDTO$$serializer.INSTANCE;
            PriceWithCurrencyDTO priceWithCurrencyDTO3 = (PriceWithCurrencyDTO) beginStructure.decodeSerializableElement(serialDescriptor, 8, priceWithCurrencyDTO$$serializer, null);
            PriceWithCurrencyDTO priceWithCurrencyDTO4 = (PriceWithCurrencyDTO) beginStructure.decodeSerializableElement(serialDescriptor, 9, priceWithCurrencyDTO$$serializer, null);
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 10);
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 11);
            BookingResponseDTO.TransportInfoDTO transportInfoDTO2 = (BookingResponseDTO.TransportInfoDTO) beginStructure.decodeSerializableElement(serialDescriptor, 12, BookingResponseDTO$TransportInfoDTO$$serializer.INSTANCE, null);
            List list8 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 13, kSerializerArr[13], null);
            List list9 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 14, kSerializerArr[14], null);
            BookingResponseDTO.BookingSeatReservationDTO bookingSeatReservationDTO3 = (BookingResponseDTO.BookingSeatReservationDTO) beginStructure.decodeNullableSerializableElement(serialDescriptor, 15, BookingResponseDTO$BookingSeatReservationDTO$$serializer.INSTANCE, null);
            list5 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 16, kSerializerArr[16], null);
            bookingSeatReservationDTO = bookingSeatReservationDTO3;
            i5 = 131071;
            directionDTO = directionDTO3;
            str = decodeStringElement;
            priceWithCurrencyDTO2 = priceWithCurrencyDTO4;
            passengerInfoResponseDTO = passengerInfoResponseDTO2;
            goodsResponseDTO = goodsResponseDTO2;
            priceWithCurrencyDTO = priceWithCurrencyDTO3;
            z5 = decodeBooleanElement;
            editInfoResponseDTO = editInfoResponseDTO4;
            list3 = list6;
            str2 = decodeStringElement2;
            list2 = list8;
            transportInfoDTO = transportInfoDTO2;
            list = list9;
            departureResponseDTO = departureResponseDTO2;
            list4 = list7;
        } else {
            boolean z6 = false;
            PriceWithCurrencyDTO priceWithCurrencyDTO5 = null;
            List list10 = null;
            List list11 = null;
            PriceWithCurrencyDTO priceWithCurrencyDTO6 = null;
            List list12 = null;
            BookingResponseDTO.TransportInfoDTO transportInfoDTO3 = null;
            List list13 = null;
            BookingResponseDTO.GoodsResponseDTO goodsResponseDTO3 = null;
            BookingResponseDTO.PassengerInfoResponseDTO passengerInfoResponseDTO3 = null;
            BookingResponseDTO.DepartureResponseDTO departureResponseDTO3 = null;
            String str3 = null;
            String str4 = null;
            BookingResponseDTO.BookingSeatReservationDTO bookingSeatReservationDTO4 = null;
            List list14 = null;
            boolean z7 = true;
            DirectionDTO directionDTO4 = null;
            BookingResponseDTO.EditInfoResponseDTO editInfoResponseDTO5 = null;
            int i6 = 0;
            while (z7) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        kSerializerArr2 = kSerializerArr;
                        editInfoResponseDTO2 = editInfoResponseDTO5;
                        bookingSeatReservationDTO2 = bookingSeatReservationDTO4;
                        z7 = false;
                        editInfoResponseDTO5 = editInfoResponseDTO2;
                        kSerializerArr = kSerializerArr2;
                        bookingSeatReservationDTO4 = bookingSeatReservationDTO2;
                    case 0:
                        kSerializerArr2 = kSerializerArr;
                        editInfoResponseDTO2 = editInfoResponseDTO5;
                        bookingSeatReservationDTO2 = bookingSeatReservationDTO4;
                        departureResponseDTO3 = (BookingResponseDTO.DepartureResponseDTO) beginStructure.decodeSerializableElement(serialDescriptor, 0, BookingResponseDTO$DepartureResponseDTO$$serializer.INSTANCE, departureResponseDTO3);
                        i6 |= 1;
                        directionDTO4 = directionDTO4;
                        editInfoResponseDTO5 = editInfoResponseDTO2;
                        kSerializerArr = kSerializerArr2;
                        bookingSeatReservationDTO4 = bookingSeatReservationDTO2;
                    case 1:
                        kSerializerArr2 = kSerializerArr;
                        bookingSeatReservationDTO2 = bookingSeatReservationDTO4;
                        editInfoResponseDTO2 = editInfoResponseDTO5;
                        directionDTO4 = (DirectionDTO) beginStructure.decodeSerializableElement(serialDescriptor, 1, DirectionDTO.Serializer.INSTANCE, directionDTO4);
                        i6 |= 2;
                        editInfoResponseDTO5 = editInfoResponseDTO2;
                        kSerializerArr = kSerializerArr2;
                        bookingSeatReservationDTO4 = bookingSeatReservationDTO2;
                    case 2:
                        bookingSeatReservationDTO2 = bookingSeatReservationDTO4;
                        i6 |= 4;
                        editInfoResponseDTO5 = (BookingResponseDTO.EditInfoResponseDTO) beginStructure.decodeSerializableElement(serialDescriptor, 2, BookingResponseDTO$EditInfoResponseDTO$$serializer.INSTANCE, editInfoResponseDTO5);
                        kSerializerArr = kSerializerArr;
                        directionDTO4 = directionDTO4;
                        bookingSeatReservationDTO4 = bookingSeatReservationDTO2;
                    case 3:
                        directionDTO2 = directionDTO4;
                        editInfoResponseDTO3 = editInfoResponseDTO5;
                        bookingSeatReservationDTO2 = bookingSeatReservationDTO4;
                        goodsResponseDTO3 = (BookingResponseDTO.GoodsResponseDTO) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, BookingResponseDTO$GoodsResponseDTO$$serializer.INSTANCE, goodsResponseDTO3);
                        i6 |= 8;
                        directionDTO4 = directionDTO2;
                        editInfoResponseDTO5 = editInfoResponseDTO3;
                        bookingSeatReservationDTO4 = bookingSeatReservationDTO2;
                    case 4:
                        directionDTO2 = directionDTO4;
                        editInfoResponseDTO3 = editInfoResponseDTO5;
                        bookingSeatReservationDTO2 = bookingSeatReservationDTO4;
                        z6 = beginStructure.decodeBooleanElement(serialDescriptor, 4);
                        i6 |= 16;
                        directionDTO4 = directionDTO2;
                        editInfoResponseDTO5 = editInfoResponseDTO3;
                        bookingSeatReservationDTO4 = bookingSeatReservationDTO2;
                    case 5:
                        directionDTO2 = directionDTO4;
                        editInfoResponseDTO3 = editInfoResponseDTO5;
                        bookingSeatReservationDTO2 = bookingSeatReservationDTO4;
                        list12 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 5, kSerializerArr[5], list12);
                        i6 |= 32;
                        directionDTO4 = directionDTO2;
                        editInfoResponseDTO5 = editInfoResponseDTO3;
                        bookingSeatReservationDTO4 = bookingSeatReservationDTO2;
                    case 6:
                        directionDTO2 = directionDTO4;
                        editInfoResponseDTO3 = editInfoResponseDTO5;
                        bookingSeatReservationDTO2 = bookingSeatReservationDTO4;
                        list13 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 6, kSerializerArr[6], list13);
                        i6 |= 64;
                        directionDTO4 = directionDTO2;
                        editInfoResponseDTO5 = editInfoResponseDTO3;
                        bookingSeatReservationDTO4 = bookingSeatReservationDTO2;
                    case 7:
                        directionDTO2 = directionDTO4;
                        editInfoResponseDTO3 = editInfoResponseDTO5;
                        bookingSeatReservationDTO2 = bookingSeatReservationDTO4;
                        passengerInfoResponseDTO3 = (BookingResponseDTO.PassengerInfoResponseDTO) beginStructure.decodeSerializableElement(serialDescriptor, 7, BookingResponseDTO$PassengerInfoResponseDTO$$serializer.INSTANCE, passengerInfoResponseDTO3);
                        i6 |= 128;
                        directionDTO4 = directionDTO2;
                        editInfoResponseDTO5 = editInfoResponseDTO3;
                        bookingSeatReservationDTO4 = bookingSeatReservationDTO2;
                    case 8:
                        directionDTO2 = directionDTO4;
                        editInfoResponseDTO3 = editInfoResponseDTO5;
                        bookingSeatReservationDTO2 = bookingSeatReservationDTO4;
                        priceWithCurrencyDTO5 = (PriceWithCurrencyDTO) beginStructure.decodeSerializableElement(serialDescriptor, 8, PriceWithCurrencyDTO$$serializer.INSTANCE, priceWithCurrencyDTO5);
                        i6 |= 256;
                        directionDTO4 = directionDTO2;
                        editInfoResponseDTO5 = editInfoResponseDTO3;
                        bookingSeatReservationDTO4 = bookingSeatReservationDTO2;
                    case 9:
                        directionDTO2 = directionDTO4;
                        editInfoResponseDTO3 = editInfoResponseDTO5;
                        bookingSeatReservationDTO2 = bookingSeatReservationDTO4;
                        priceWithCurrencyDTO6 = (PriceWithCurrencyDTO) beginStructure.decodeSerializableElement(serialDescriptor, 9, PriceWithCurrencyDTO$$serializer.INSTANCE, priceWithCurrencyDTO6);
                        i6 |= 512;
                        directionDTO4 = directionDTO2;
                        editInfoResponseDTO5 = editInfoResponseDTO3;
                        bookingSeatReservationDTO4 = bookingSeatReservationDTO2;
                    case 10:
                        directionDTO2 = directionDTO4;
                        editInfoResponseDTO3 = editInfoResponseDTO5;
                        bookingSeatReservationDTO2 = bookingSeatReservationDTO4;
                        str3 = beginStructure.decodeStringElement(serialDescriptor, 10);
                        i6 |= 1024;
                        directionDTO4 = directionDTO2;
                        editInfoResponseDTO5 = editInfoResponseDTO3;
                        bookingSeatReservationDTO4 = bookingSeatReservationDTO2;
                    case 11:
                        directionDTO2 = directionDTO4;
                        editInfoResponseDTO3 = editInfoResponseDTO5;
                        bookingSeatReservationDTO2 = bookingSeatReservationDTO4;
                        str4 = beginStructure.decodeStringElement(serialDescriptor, 11);
                        i6 |= 2048;
                        directionDTO4 = directionDTO2;
                        editInfoResponseDTO5 = editInfoResponseDTO3;
                        bookingSeatReservationDTO4 = bookingSeatReservationDTO2;
                    case 12:
                        directionDTO2 = directionDTO4;
                        editInfoResponseDTO3 = editInfoResponseDTO5;
                        bookingSeatReservationDTO2 = bookingSeatReservationDTO4;
                        transportInfoDTO3 = (BookingResponseDTO.TransportInfoDTO) beginStructure.decodeSerializableElement(serialDescriptor, 12, BookingResponseDTO$TransportInfoDTO$$serializer.INSTANCE, transportInfoDTO3);
                        i6 |= 4096;
                        directionDTO4 = directionDTO2;
                        editInfoResponseDTO5 = editInfoResponseDTO3;
                        bookingSeatReservationDTO4 = bookingSeatReservationDTO2;
                    case 13:
                        directionDTO2 = directionDTO4;
                        editInfoResponseDTO3 = editInfoResponseDTO5;
                        bookingSeatReservationDTO2 = bookingSeatReservationDTO4;
                        list11 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 13, kSerializerArr[13], list11);
                        i6 |= 8192;
                        directionDTO4 = directionDTO2;
                        editInfoResponseDTO5 = editInfoResponseDTO3;
                        bookingSeatReservationDTO4 = bookingSeatReservationDTO2;
                    case 14:
                        directionDTO2 = directionDTO4;
                        editInfoResponseDTO3 = editInfoResponseDTO5;
                        bookingSeatReservationDTO2 = bookingSeatReservationDTO4;
                        list10 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 14, kSerializerArr[14], list10);
                        i6 |= 16384;
                        directionDTO4 = directionDTO2;
                        editInfoResponseDTO5 = editInfoResponseDTO3;
                        bookingSeatReservationDTO4 = bookingSeatReservationDTO2;
                    case 15:
                        directionDTO2 = directionDTO4;
                        editInfoResponseDTO3 = editInfoResponseDTO5;
                        bookingSeatReservationDTO2 = (BookingResponseDTO.BookingSeatReservationDTO) beginStructure.decodeNullableSerializableElement(serialDescriptor, 15, BookingResponseDTO$BookingSeatReservationDTO$$serializer.INSTANCE, bookingSeatReservationDTO4);
                        i6 |= 32768;
                        list14 = list14;
                        directionDTO4 = directionDTO2;
                        editInfoResponseDTO5 = editInfoResponseDTO3;
                        bookingSeatReservationDTO4 = bookingSeatReservationDTO2;
                    case 16:
                        list14 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 16, kSerializerArr[16], list14);
                        i6 |= 65536;
                        directionDTO4 = directionDTO4;
                        editInfoResponseDTO5 = editInfoResponseDTO5;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            bookingSeatReservationDTO = bookingSeatReservationDTO4;
            priceWithCurrencyDTO = priceWithCurrencyDTO5;
            i5 = i6;
            list = list10;
            list2 = list11;
            priceWithCurrencyDTO2 = priceWithCurrencyDTO6;
            list3 = list12;
            transportInfoDTO = transportInfoDTO3;
            list4 = list13;
            goodsResponseDTO = goodsResponseDTO3;
            passengerInfoResponseDTO = passengerInfoResponseDTO3;
            departureResponseDTO = departureResponseDTO3;
            directionDTO = directionDTO4;
            editInfoResponseDTO = editInfoResponseDTO5;
            str = str3;
            str2 = str4;
            list5 = list14;
            z5 = z6;
        }
        beginStructure.endStructure(serialDescriptor);
        return new BookingResponseDTO.TicketResponseDTO(i5, departureResponseDTO, directionDTO, editInfoResponseDTO, goodsResponseDTO, z5, list3, list4, passengerInfoResponseDTO, priceWithCurrencyDTO, priceWithCurrencyDTO2, str, str2, transportInfoDTO, list2, list, bookingSeatReservationDTO, list5, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, BookingResponseDTO.TicketResponseDTO value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        BookingResponseDTO.TicketResponseDTO.write$Self$api_kombardoProd(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
