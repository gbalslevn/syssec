package dk.molslinjen.api.services.booking.response.booking;

import dk.molslinjen.api.helpers.serializers.DurationSerializer;
import dk.molslinjen.api.helpers.serializers.LocalDateWithTimeSerializer;
import dk.molslinjen.api.helpers.serializers.LocalTimeSerializer;
import dk.molslinjen.api.services.booking.response.booking.BookingResponseDTO;
import dk.molslinjen.api.shared.response.HarborDTO;
import dk.molslinjen.api.shared.response.HarborDTO$$serializer;
import dk.molslinjen.api.shared.response.SublineDTO;
import dk.molslinjen.api.shared.response.SublineDTO$$serializer;
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
import org.threeten.bp.Duration;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"dk/molslinjen/api/services/booking/response/booking/BookingResponseDTO.DepartureResponseDTO.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$DepartureResponseDTO;", "<init>", "()V", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public /* synthetic */ class BookingResponseDTO$DepartureResponseDTO$$serializer implements GeneratedSerializer<BookingResponseDTO.DepartureResponseDTO> {
    public static final BookingResponseDTO$DepartureResponseDTO$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        BookingResponseDTO$DepartureResponseDTO$$serializer bookingResponseDTO$DepartureResponseDTO$$serializer = new BookingResponseDTO$DepartureResponseDTO$$serializer();
        INSTANCE = bookingResponseDTO$DepartureResponseDTO$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dk.molslinjen.api.services.booking.response.booking.BookingResponseDTO.DepartureResponseDTO", bookingResponseDTO$DepartureResponseDTO$$serializer, 16);
        pluginGeneratedSerialDescriptor.addElement("arrivalTime", false);
        pluginGeneratedSerialDescriptor.addElement("date", false);
        pluginGeneratedSerialDescriptor.addElement("departureId", false);
        pluginGeneratedSerialDescriptor.addElement("departureTime", false);
        pluginGeneratedSerialDescriptor.addElement("regionId", false);
        pluginGeneratedSerialDescriptor.addElement("routeId", false);
        pluginGeneratedSerialDescriptor.addElement("mainRouteId", false);
        pluginGeneratedSerialDescriptor.addElement("routeTypes", false);
        pluginGeneratedSerialDescriptor.addElement("timeTableId", false);
        pluginGeneratedSerialDescriptor.addElement("ferry", false);
        pluginGeneratedSerialDescriptor.addElement("travelTime", false);
        pluginGeneratedSerialDescriptor.addElement("departureHarbor", false);
        pluginGeneratedSerialDescriptor.addElement("arrivalHarbor", false);
        pluginGeneratedSerialDescriptor.addElement("transportSwitchDescription", false);
        pluginGeneratedSerialDescriptor.addElement("isEarlyCheckInPossible", false);
        pluginGeneratedSerialDescriptor.addElement("subline", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private BookingResponseDTO$DepartureResponseDTO$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr;
        kSerializerArr = BookingResponseDTO.DepartureResponseDTO.$childSerializers;
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        KSerializer<?> kSerializer = kSerializerArr[7];
        KSerializer<?> nullable = BuiltinSerializersKt.getNullable(FerryResponseDTO$$serializer.INSTANCE);
        KSerializer<?> nullable2 = BuiltinSerializersKt.getNullable(stringSerializer);
        KSerializer<?> nullable3 = BuiltinSerializersKt.getNullable(SublineDTO$$serializer.INSTANCE);
        LocalTimeSerializer localTimeSerializer = LocalTimeSerializer.INSTANCE;
        HarborDTO$$serializer harborDTO$$serializer = HarborDTO$$serializer.INSTANCE;
        return new KSerializer[]{localTimeSerializer, LocalDateWithTimeSerializer.INSTANCE, stringSerializer, localTimeSerializer, stringSerializer, stringSerializer, stringSerializer, kSerializer, stringSerializer, nullable, DurationSerializer.INSTANCE, harborDTO$$serializer, harborDTO$$serializer, nullable2, BooleanSerializer.INSTANCE, nullable3};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x00e1. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public final BookingResponseDTO.DepartureResponseDTO deserialize(Decoder decoder) {
        KSerializer[] kSerializerArr;
        int i5;
        FerryResponseDTO ferryResponseDTO;
        SublineDTO sublineDTO;
        List list;
        LocalTime localTime;
        LocalTime localTime2;
        LocalDate localDate;
        String str;
        HarborDTO harborDTO;
        Duration duration;
        HarborDTO harborDTO2;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        boolean z5;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        kSerializerArr = BookingResponseDTO.DepartureResponseDTO.$childSerializers;
        char c5 = '\t';
        LocalTime localTime3 = null;
        if (beginStructure.decodeSequentially()) {
            LocalTimeSerializer localTimeSerializer = LocalTimeSerializer.INSTANCE;
            LocalTime localTime4 = (LocalTime) beginStructure.decodeSerializableElement(serialDescriptor, 0, localTimeSerializer, null);
            LocalDate localDate2 = (LocalDate) beginStructure.decodeSerializableElement(serialDescriptor, 1, LocalDateWithTimeSerializer.INSTANCE, null);
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 2);
            LocalTime localTime5 = (LocalTime) beginStructure.decodeSerializableElement(serialDescriptor, 3, localTimeSerializer, null);
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 4);
            String decodeStringElement3 = beginStructure.decodeStringElement(serialDescriptor, 5);
            String decodeStringElement4 = beginStructure.decodeStringElement(serialDescriptor, 6);
            List list2 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 7, kSerializerArr[7], null);
            String decodeStringElement5 = beginStructure.decodeStringElement(serialDescriptor, 8);
            FerryResponseDTO ferryResponseDTO2 = (FerryResponseDTO) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, FerryResponseDTO$$serializer.INSTANCE, null);
            Duration duration2 = (Duration) beginStructure.decodeSerializableElement(serialDescriptor, 10, DurationSerializer.INSTANCE, null);
            HarborDTO$$serializer harborDTO$$serializer = HarborDTO$$serializer.INSTANCE;
            HarborDTO harborDTO3 = (HarborDTO) beginStructure.decodeSerializableElement(serialDescriptor, 11, harborDTO$$serializer, null);
            HarborDTO harborDTO4 = (HarborDTO) beginStructure.decodeSerializableElement(serialDescriptor, 12, harborDTO$$serializer, null);
            String str7 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 13, StringSerializer.INSTANCE, null);
            boolean decodeBooleanElement = beginStructure.decodeBooleanElement(serialDescriptor, 14);
            sublineDTO = (SublineDTO) beginStructure.decodeNullableSerializableElement(serialDescriptor, 15, SublineDTO$$serializer.INSTANCE, null);
            i5 = 65535;
            str2 = decodeStringElement;
            str6 = decodeStringElement5;
            localDate = localDate2;
            localTime2 = localTime4;
            str3 = decodeStringElement2;
            ferryResponseDTO = ferryResponseDTO2;
            str5 = decodeStringElement4;
            str4 = decodeStringElement3;
            duration = duration2;
            z5 = decodeBooleanElement;
            harborDTO2 = harborDTO3;
            str = str7;
            localTime = localTime5;
            harborDTO = harborDTO4;
            list = list2;
        } else {
            boolean z6 = true;
            int i6 = 0;
            boolean z7 = false;
            FerryResponseDTO ferryResponseDTO3 = null;
            SublineDTO sublineDTO2 = null;
            List list3 = null;
            LocalTime localTime6 = null;
            LocalDate localDate3 = null;
            String str8 = null;
            HarborDTO harborDTO5 = null;
            Duration duration3 = null;
            HarborDTO harborDTO6 = null;
            String str9 = null;
            String str10 = null;
            String str11 = null;
            String str12 = null;
            String str13 = null;
            while (z6) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z6 = false;
                    case 0:
                        localTime3 = (LocalTime) beginStructure.decodeSerializableElement(serialDescriptor, 0, LocalTimeSerializer.INSTANCE, localTime3);
                        i6 |= 1;
                        c5 = '\t';
                    case 1:
                        localDate3 = (LocalDate) beginStructure.decodeSerializableElement(serialDescriptor, 1, LocalDateWithTimeSerializer.INSTANCE, localDate3);
                        i6 |= 2;
                        c5 = '\t';
                    case 2:
                        str9 = beginStructure.decodeStringElement(serialDescriptor, 2);
                        i6 |= 4;
                        c5 = '\t';
                    case 3:
                        localTime6 = (LocalTime) beginStructure.decodeSerializableElement(serialDescriptor, 3, LocalTimeSerializer.INSTANCE, localTime6);
                        i6 |= 8;
                        c5 = '\t';
                    case 4:
                        str10 = beginStructure.decodeStringElement(serialDescriptor, 4);
                        i6 |= 16;
                        c5 = '\t';
                    case 5:
                        str11 = beginStructure.decodeStringElement(serialDescriptor, 5);
                        i6 |= 32;
                        c5 = '\t';
                    case 6:
                        str12 = beginStructure.decodeStringElement(serialDescriptor, 6);
                        i6 |= 64;
                        c5 = '\t';
                    case 7:
                        list3 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 7, kSerializerArr[7], list3);
                        i6 |= 128;
                        c5 = '\t';
                    case 8:
                        str13 = beginStructure.decodeStringElement(serialDescriptor, 8);
                        i6 |= 256;
                        c5 = c5;
                    case 9:
                        ferryResponseDTO3 = (FerryResponseDTO) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, FerryResponseDTO$$serializer.INSTANCE, ferryResponseDTO3);
                        i6 |= 512;
                        c5 = '\t';
                    case 10:
                        duration3 = (Duration) beginStructure.decodeSerializableElement(serialDescriptor, 10, DurationSerializer.INSTANCE, duration3);
                        i6 |= 1024;
                        c5 = '\t';
                    case 11:
                        harborDTO6 = (HarborDTO) beginStructure.decodeSerializableElement(serialDescriptor, 11, HarborDTO$$serializer.INSTANCE, harborDTO6);
                        i6 |= 2048;
                        c5 = '\t';
                    case 12:
                        harborDTO5 = (HarborDTO) beginStructure.decodeSerializableElement(serialDescriptor, 12, HarborDTO$$serializer.INSTANCE, harborDTO5);
                        i6 |= 4096;
                        c5 = '\t';
                    case 13:
                        str8 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 13, StringSerializer.INSTANCE, str8);
                        i6 |= 8192;
                        c5 = '\t';
                    case 14:
                        z7 = beginStructure.decodeBooleanElement(serialDescriptor, 14);
                        i6 |= 16384;
                        c5 = '\t';
                    case 15:
                        sublineDTO2 = (SublineDTO) beginStructure.decodeNullableSerializableElement(serialDescriptor, 15, SublineDTO$$serializer.INSTANCE, sublineDTO2);
                        i6 |= 32768;
                        c5 = '\t';
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            i5 = i6;
            ferryResponseDTO = ferryResponseDTO3;
            sublineDTO = sublineDTO2;
            list = list3;
            localTime = localTime6;
            localTime2 = localTime3;
            localDate = localDate3;
            str = str8;
            harborDTO = harborDTO5;
            duration = duration3;
            harborDTO2 = harborDTO6;
            str2 = str9;
            str3 = str10;
            str4 = str11;
            str5 = str12;
            str6 = str13;
            z5 = z7;
        }
        beginStructure.endStructure(serialDescriptor);
        return new BookingResponseDTO.DepartureResponseDTO(i5, localTime2, localDate, str2, localTime, str3, str4, str5, list, str6, ferryResponseDTO, duration, harborDTO2, harborDTO, str, z5, sublineDTO, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, BookingResponseDTO.DepartureResponseDTO value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        BookingResponseDTO.DepartureResponseDTO.write$Self$api_kombardoProd(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
