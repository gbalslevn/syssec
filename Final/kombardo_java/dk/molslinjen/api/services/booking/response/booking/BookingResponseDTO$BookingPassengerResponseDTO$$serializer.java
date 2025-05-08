package dk.molslinjen.api.services.booking.response.booking;

import dk.molslinjen.api.helpers.serializers.LocalDateWithTimeSerializer;
import dk.molslinjen.api.services.account.passenger.response.GenderDTO;
import dk.molslinjen.api.services.booking.response.booking.AgeGroupResponseDTO;
import dk.molslinjen.api.services.booking.response.booking.BookingResponseDTO;
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
import org.threeten.bp.LocalDate;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"dk/molslinjen/api/services/booking/response/booking/BookingResponseDTO.BookingPassengerResponseDTO.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$BookingPassengerResponseDTO;", "<init>", "()V", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public /* synthetic */ class BookingResponseDTO$BookingPassengerResponseDTO$$serializer implements GeneratedSerializer<BookingResponseDTO.BookingPassengerResponseDTO> {
    public static final BookingResponseDTO$BookingPassengerResponseDTO$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        BookingResponseDTO$BookingPassengerResponseDTO$$serializer bookingResponseDTO$BookingPassengerResponseDTO$$serializer = new BookingResponseDTO$BookingPassengerResponseDTO$$serializer();
        INSTANCE = bookingResponseDTO$BookingPassengerResponseDTO$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dk.molslinjen.api.services.booking.response.booking.BookingResponseDTO.BookingPassengerResponseDTO", bookingResponseDTO$BookingPassengerResponseDTO$$serializer, 6);
        pluginGeneratedSerialDescriptor.addElement("ageGroup", false);
        pluginGeneratedSerialDescriptor.addElement("birthDate", false);
        pluginGeneratedSerialDescriptor.addElement("firstName", false);
        pluginGeneratedSerialDescriptor.addElement("lastName", false);
        pluginGeneratedSerialDescriptor.addElement("nationality", false);
        pluginGeneratedSerialDescriptor.addElement("sex", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private BookingResponseDTO$BookingPassengerResponseDTO$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{AgeGroupResponseDTO.Serializer.INSTANCE, LocalDateWithTimeSerializer.INSTANCE, stringSerializer, stringSerializer, stringSerializer, GenderDTO.Serializer.INSTANCE};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x005d. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public final BookingResponseDTO.BookingPassengerResponseDTO deserialize(Decoder decoder) {
        int i5;
        AgeGroupResponseDTO ageGroupResponseDTO;
        LocalDate localDate;
        String str;
        String str2;
        String str3;
        GenderDTO genderDTO;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        int i6 = 5;
        AgeGroupResponseDTO ageGroupResponseDTO2 = null;
        if (beginStructure.decodeSequentially()) {
            AgeGroupResponseDTO ageGroupResponseDTO3 = (AgeGroupResponseDTO) beginStructure.decodeSerializableElement(serialDescriptor, 0, AgeGroupResponseDTO.Serializer.INSTANCE, null);
            LocalDate localDate2 = (LocalDate) beginStructure.decodeSerializableElement(serialDescriptor, 1, LocalDateWithTimeSerializer.INSTANCE, null);
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 2);
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 3);
            String decodeStringElement3 = beginStructure.decodeStringElement(serialDescriptor, 4);
            ageGroupResponseDTO = ageGroupResponseDTO3;
            genderDTO = (GenderDTO) beginStructure.decodeSerializableElement(serialDescriptor, 5, GenderDTO.Serializer.INSTANCE, null);
            str2 = decodeStringElement2;
            str3 = decodeStringElement3;
            str = decodeStringElement;
            localDate = localDate2;
            i5 = 63;
        } else {
            boolean z5 = true;
            int i7 = 0;
            LocalDate localDate3 = null;
            String str4 = null;
            String str5 = null;
            String str6 = null;
            GenderDTO genderDTO2 = null;
            while (z5) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z5 = false;
                        i6 = 5;
                    case 0:
                        ageGroupResponseDTO2 = (AgeGroupResponseDTO) beginStructure.decodeSerializableElement(serialDescriptor, 0, AgeGroupResponseDTO.Serializer.INSTANCE, ageGroupResponseDTO2);
                        i7 |= 1;
                        i6 = 5;
                    case 1:
                        localDate3 = (LocalDate) beginStructure.decodeSerializableElement(serialDescriptor, 1, LocalDateWithTimeSerializer.INSTANCE, localDate3);
                        i7 |= 2;
                    case 2:
                        str4 = beginStructure.decodeStringElement(serialDescriptor, 2);
                        i7 |= 4;
                    case 3:
                        str5 = beginStructure.decodeStringElement(serialDescriptor, 3);
                        i7 |= 8;
                    case 4:
                        str6 = beginStructure.decodeStringElement(serialDescriptor, 4);
                        i7 |= 16;
                    case 5:
                        genderDTO2 = (GenderDTO) beginStructure.decodeSerializableElement(serialDescriptor, i6, GenderDTO.Serializer.INSTANCE, genderDTO2);
                        i7 |= 32;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            i5 = i7;
            ageGroupResponseDTO = ageGroupResponseDTO2;
            localDate = localDate3;
            str = str4;
            str2 = str5;
            str3 = str6;
            genderDTO = genderDTO2;
        }
        beginStructure.endStructure(serialDescriptor);
        return new BookingResponseDTO.BookingPassengerResponseDTO(i5, ageGroupResponseDTO, localDate, str, str2, str3, genderDTO, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, BookingResponseDTO.BookingPassengerResponseDTO value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        BookingResponseDTO.BookingPassengerResponseDTO.write$Self$api_kombardoProd(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
