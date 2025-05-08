package dk.molslinjen.api.services.booking.request;

import dk.molslinjen.api.helpers.serializers.LocalDateWithTimeSerializer;
import dk.molslinjen.api.services.booking.request.BookRequestParameters;
import dk.molslinjen.api.services.booking.request.DirectionDTO;
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

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"dk/molslinjen/api/services/booking/request/BookRequestParameters.TicketRequestParameters.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Ldk/molslinjen/api/services/booking/request/BookRequestParameters$TicketRequestParameters;", "<init>", "()V", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public /* synthetic */ class BookRequestParameters$TicketRequestParameters$$serializer implements GeneratedSerializer<BookRequestParameters.TicketRequestParameters> {
    public static final BookRequestParameters$TicketRequestParameters$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        BookRequestParameters$TicketRequestParameters$$serializer bookRequestParameters$TicketRequestParameters$$serializer = new BookRequestParameters$TicketRequestParameters$$serializer();
        INSTANCE = bookRequestParameters$TicketRequestParameters$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dk.molslinjen.api.services.booking.request.BookRequestParameters.TicketRequestParameters", bookRequestParameters$TicketRequestParameters$$serializer, 14);
        pluginGeneratedSerialDescriptor.addElement("carId", false);
        pluginGeneratedSerialDescriptor.addElement("date", false);
        pluginGeneratedSerialDescriptor.addElement("departureId", false);
        pluginGeneratedSerialDescriptor.addElement("direction", false);
        pluginGeneratedSerialDescriptor.addElement("goods", false);
        pluginGeneratedSerialDescriptor.addElement("isCheckedIn", false);
        pluginGeneratedSerialDescriptor.addElement("notes", false);
        pluginGeneratedSerialDescriptor.addElement("passengerInfo", false);
        pluginGeneratedSerialDescriptor.addElement("products", false);
        pluginGeneratedSerialDescriptor.addElement("regionId", false);
        pluginGeneratedSerialDescriptor.addElement("routeId", false);
        pluginGeneratedSerialDescriptor.addElement("ticketTypeId", false);
        pluginGeneratedSerialDescriptor.addElement("transportId", false);
        pluginGeneratedSerialDescriptor.addElement("seatReservation", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private BookRequestParameters$TicketRequestParameters$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr;
        kSerializerArr = BookRequestParameters.TicketRequestParameters.$childSerializers;
        KSerializer<?> nullable = BuiltinSerializersKt.getNullable(BookRequestParameters$GoodsRequestParameters$$serializer.INSTANCE);
        KSerializer<?> kSerializer = kSerializerArr[6];
        KSerializer<?> kSerializer2 = kSerializerArr[8];
        KSerializer<?> nullable2 = BuiltinSerializersKt.getNullable(BookRequestParameters$BookSeatReservationRequestParameter$$serializer.INSTANCE);
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{stringSerializer, LocalDateWithTimeSerializer.INSTANCE, stringSerializer, DirectionDTO.Serializer.INSTANCE, nullable, BooleanSerializer.INSTANCE, kSerializer, BookRequestParameters$PassengerInfoRequestParameters$$serializer.INSTANCE, kSerializer2, stringSerializer, stringSerializer, stringSerializer, stringSerializer, nullable2};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x00c2. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public final BookRequestParameters.TicketRequestParameters deserialize(Decoder decoder) {
        KSerializer[] kSerializerArr;
        int i5;
        DirectionDTO directionDTO;
        LocalDate localDate;
        String str;
        List list;
        List list2;
        BookRequestParameters.PassengerInfoRequestParameters passengerInfoRequestParameters;
        BookRequestParameters.GoodsRequestParameters goodsRequestParameters;
        BookRequestParameters.BookSeatReservationRequestParameter bookSeatReservationRequestParameter;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        boolean z5;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        kSerializerArr = BookRequestParameters.TicketRequestParameters.$childSerializers;
        int i6 = 10;
        int i7 = 9;
        int i8 = 8;
        String str7 = null;
        if (beginStructure.decodeSequentially()) {
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 0);
            LocalDate localDate2 = (LocalDate) beginStructure.decodeSerializableElement(serialDescriptor, 1, LocalDateWithTimeSerializer.INSTANCE, null);
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 2);
            DirectionDTO directionDTO2 = (DirectionDTO) beginStructure.decodeSerializableElement(serialDescriptor, 3, DirectionDTO.Serializer.INSTANCE, null);
            BookRequestParameters.GoodsRequestParameters goodsRequestParameters2 = (BookRequestParameters.GoodsRequestParameters) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, BookRequestParameters$GoodsRequestParameters$$serializer.INSTANCE, null);
            boolean decodeBooleanElement = beginStructure.decodeBooleanElement(serialDescriptor, 5);
            List list3 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 6, kSerializerArr[6], null);
            BookRequestParameters.PassengerInfoRequestParameters passengerInfoRequestParameters2 = (BookRequestParameters.PassengerInfoRequestParameters) beginStructure.decodeSerializableElement(serialDescriptor, 7, BookRequestParameters$PassengerInfoRequestParameters$$serializer.INSTANCE, null);
            List list4 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 8, kSerializerArr[8], null);
            String decodeStringElement3 = beginStructure.decodeStringElement(serialDescriptor, 9);
            String decodeStringElement4 = beginStructure.decodeStringElement(serialDescriptor, 10);
            String decodeStringElement5 = beginStructure.decodeStringElement(serialDescriptor, 11);
            String decodeStringElement6 = beginStructure.decodeStringElement(serialDescriptor, 12);
            bookSeatReservationRequestParameter = (BookRequestParameters.BookSeatReservationRequestParameter) beginStructure.decodeNullableSerializableElement(serialDescriptor, 13, BookRequestParameters$BookSeatReservationRequestParameter$$serializer.INSTANCE, null);
            i5 = 16383;
            localDate = localDate2;
            str2 = decodeStringElement2;
            str4 = decodeStringElement4;
            str3 = decodeStringElement3;
            passengerInfoRequestParameters = passengerInfoRequestParameters2;
            z5 = decodeBooleanElement;
            directionDTO = directionDTO2;
            goodsRequestParameters = goodsRequestParameters2;
            list2 = list3;
            str5 = decodeStringElement5;
            str6 = decodeStringElement6;
            list = list4;
            str = decodeStringElement;
        } else {
            boolean z6 = true;
            int i9 = 0;
            boolean z7 = false;
            DirectionDTO directionDTO3 = null;
            LocalDate localDate3 = null;
            List list5 = null;
            List list6 = null;
            BookRequestParameters.PassengerInfoRequestParameters passengerInfoRequestParameters3 = null;
            BookRequestParameters.GoodsRequestParameters goodsRequestParameters3 = null;
            BookRequestParameters.BookSeatReservationRequestParameter bookSeatReservationRequestParameter2 = null;
            String str8 = null;
            String str9 = null;
            String str10 = null;
            String str11 = null;
            String str12 = null;
            while (z6) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z6 = false;
                        i6 = 10;
                        i8 = 8;
                    case 0:
                        str7 = beginStructure.decodeStringElement(serialDescriptor, 0);
                        i9 |= 1;
                        i6 = 10;
                        i7 = 9;
                        i8 = 8;
                    case 1:
                        localDate3 = (LocalDate) beginStructure.decodeSerializableElement(serialDescriptor, 1, LocalDateWithTimeSerializer.INSTANCE, localDate3);
                        i9 |= 2;
                        i6 = 10;
                        i7 = 9;
                        i8 = 8;
                    case 2:
                        str8 = beginStructure.decodeStringElement(serialDescriptor, 2);
                        i9 |= 4;
                        i6 = 10;
                        i7 = 9;
                        i8 = 8;
                    case 3:
                        directionDTO3 = (DirectionDTO) beginStructure.decodeSerializableElement(serialDescriptor, 3, DirectionDTO.Serializer.INSTANCE, directionDTO3);
                        i9 |= 8;
                        i6 = 10;
                        i7 = 9;
                        i8 = 8;
                    case 4:
                        goodsRequestParameters3 = (BookRequestParameters.GoodsRequestParameters) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, BookRequestParameters$GoodsRequestParameters$$serializer.INSTANCE, goodsRequestParameters3);
                        i9 |= 16;
                        i6 = 10;
                        i7 = 9;
                        i8 = 8;
                    case 5:
                        z7 = beginStructure.decodeBooleanElement(serialDescriptor, 5);
                        i9 |= 32;
                        i6 = 10;
                        i7 = 9;
                        i8 = 8;
                    case 6:
                        list6 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 6, kSerializerArr[6], list6);
                        i9 |= 64;
                        i6 = 10;
                        i7 = 9;
                        i8 = 8;
                    case 7:
                        passengerInfoRequestParameters3 = (BookRequestParameters.PassengerInfoRequestParameters) beginStructure.decodeSerializableElement(serialDescriptor, 7, BookRequestParameters$PassengerInfoRequestParameters$$serializer.INSTANCE, passengerInfoRequestParameters3);
                        i9 |= 128;
                        i6 = 10;
                        i7 = 9;
                        i8 = 8;
                    case 8:
                        int i10 = i8;
                        list5 = (List) beginStructure.decodeSerializableElement(serialDescriptor, i10, kSerializerArr[i10], list5);
                        i9 |= 256;
                        i8 = i10;
                        i6 = 10;
                        i7 = 9;
                    case 9:
                        str9 = beginStructure.decodeStringElement(serialDescriptor, i7);
                        i9 |= 512;
                        i8 = 8;
                    case 10:
                        str10 = beginStructure.decodeStringElement(serialDescriptor, i6);
                        i9 |= 1024;
                        i8 = 8;
                    case 11:
                        str11 = beginStructure.decodeStringElement(serialDescriptor, 11);
                        i9 |= 2048;
                        i8 = 8;
                    case 12:
                        str12 = beginStructure.decodeStringElement(serialDescriptor, 12);
                        i9 |= 4096;
                        i8 = 8;
                    case 13:
                        bookSeatReservationRequestParameter2 = (BookRequestParameters.BookSeatReservationRequestParameter) beginStructure.decodeNullableSerializableElement(serialDescriptor, 13, BookRequestParameters$BookSeatReservationRequestParameter$$serializer.INSTANCE, bookSeatReservationRequestParameter2);
                        i9 |= 8192;
                        i8 = 8;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            i5 = i9;
            directionDTO = directionDTO3;
            localDate = localDate3;
            str = str7;
            list = list5;
            list2 = list6;
            passengerInfoRequestParameters = passengerInfoRequestParameters3;
            goodsRequestParameters = goodsRequestParameters3;
            bookSeatReservationRequestParameter = bookSeatReservationRequestParameter2;
            str2 = str8;
            str3 = str9;
            str4 = str10;
            str5 = str11;
            str6 = str12;
            z5 = z7;
        }
        beginStructure.endStructure(serialDescriptor);
        return new BookRequestParameters.TicketRequestParameters(i5, str, localDate, str2, directionDTO, goodsRequestParameters, z5, list2, passengerInfoRequestParameters, list, str3, str4, str5, str6, bookSeatReservationRequestParameter, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, BookRequestParameters.TicketRequestParameters value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        BookRequestParameters.TicketRequestParameters.write$Self$api_kombardoProd(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
