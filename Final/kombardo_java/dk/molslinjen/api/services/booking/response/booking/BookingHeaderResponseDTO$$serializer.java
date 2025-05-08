package dk.molslinjen.api.services.booking.response.booking;

import dk.molslinjen.api.helpers.serializers.DurationSerializer;
import dk.molslinjen.api.helpers.serializers.LocalDateTimeSerializer;
import dk.molslinjen.api.helpers.serializers.LocalTimeSerializer;
import dk.molslinjen.api.services.booking.response.booking.BookingHeaderResponseDTO;
import dk.molslinjen.api.services.config.response.SiteDTO;
import dk.molslinjen.api.shared.response.SublineDTO;
import dk.molslinjen.api.shared.response.SublineDTO$$serializer;
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
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.LocalTime;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"dk/molslinjen/api/services/booking/response/booking/BookingHeaderResponseDTO.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Ldk/molslinjen/api/services/booking/response/booking/BookingHeaderResponseDTO;", "<init>", "()V", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public /* synthetic */ class BookingHeaderResponseDTO$$serializer implements GeneratedSerializer<BookingHeaderResponseDTO> {
    public static final BookingHeaderResponseDTO$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        BookingHeaderResponseDTO$$serializer bookingHeaderResponseDTO$$serializer = new BookingHeaderResponseDTO$$serializer();
        INSTANCE = bookingHeaderResponseDTO$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dk.molslinjen.api.services.booking.response.booking.BookingHeaderResponseDTO", bookingHeaderResponseDTO$$serializer, 19);
        pluginGeneratedSerialDescriptor.addElement("arrivalHarborName", false);
        pluginGeneratedSerialDescriptor.addElement("arrivalTime", false);
        pluginGeneratedSerialDescriptor.addElement("departureDateTime", false);
        pluginGeneratedSerialDescriptor.addElement("departureHarborName", false);
        pluginGeneratedSerialDescriptor.addElement("ferry", false);
        pluginGeneratedSerialDescriptor.addElement("isCheckedIn", false);
        pluginGeneratedSerialDescriptor.addElement("phone", false);
        pluginGeneratedSerialDescriptor.addElement("reservationId", false);
        pluginGeneratedSerialDescriptor.addElement("departureId", false);
        pluginGeneratedSerialDescriptor.addElement("travelTime", false);
        pluginGeneratedSerialDescriptor.addElement("routeId", false);
        pluginGeneratedSerialDescriptor.addElement("transportId", false);
        pluginGeneratedSerialDescriptor.addElement("refundInfo", false);
        pluginGeneratedSerialDescriptor.addElement("ticketTypeId", false);
        pluginGeneratedSerialDescriptor.addElement("timeTableId", false);
        pluginGeneratedSerialDescriptor.addElement("isEarlyCheckInPossible", false);
        pluginGeneratedSerialDescriptor.addElement("site", false);
        pluginGeneratedSerialDescriptor.addElement("subline", false);
        pluginGeneratedSerialDescriptor.addElement("lineLogoUrl", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private BookingHeaderResponseDTO$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr;
        kSerializerArr = BookingHeaderResponseDTO.$childSerializers;
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        KSerializer<?> nullable = BuiltinSerializersKt.getNullable(stringSerializer);
        KSerializer<?> nullable2 = BuiltinSerializersKt.getNullable(stringSerializer);
        KSerializer<?> nullable3 = BuiltinSerializersKt.getNullable(FerryResponseDTO$$serializer.INSTANCE);
        KSerializer<?> kSerializer = kSerializerArr[16];
        KSerializer<?> nullable4 = BuiltinSerializersKt.getNullable(SublineDTO$$serializer.INSTANCE);
        KSerializer<?> nullable5 = BuiltinSerializersKt.getNullable(stringSerializer);
        BooleanSerializer booleanSerializer = BooleanSerializer.INSTANCE;
        return new KSerializer[]{nullable, LocalTimeSerializer.INSTANCE, LocalDateTimeSerializer.INSTANCE, nullable2, nullable3, booleanSerializer, stringSerializer, stringSerializer, stringSerializer, DurationSerializer.INSTANCE, stringSerializer, stringSerializer, BookingHeaderResponseDTO$RefundInfo$$serializer.INSTANCE, stringSerializer, stringSerializer, booleanSerializer, kSerializer, nullable4, nullable5};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x010b. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public final BookingHeaderResponseDTO deserialize(Decoder decoder) {
        KSerializer[] kSerializerArr;
        LocalDateTime localDateTime;
        FerryResponseDTO ferryResponseDTO;
        String str;
        Duration duration;
        String str2;
        int i5;
        LocalTime localTime;
        String str3;
        SublineDTO sublineDTO;
        SiteDTO siteDTO;
        BookingHeaderResponseDTO.RefundInfo refundInfo;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        boolean z5;
        boolean z6;
        boolean z7;
        int i6;
        boolean z8;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        kSerializerArr = BookingHeaderResponseDTO.$childSerializers;
        if (beginStructure.decodeSequentially()) {
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            String str11 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, stringSerializer, null);
            LocalTime localTime2 = (LocalTime) beginStructure.decodeSerializableElement(serialDescriptor, 1, LocalTimeSerializer.INSTANCE, null);
            LocalDateTime localDateTime2 = (LocalDateTime) beginStructure.decodeSerializableElement(serialDescriptor, 2, LocalDateTimeSerializer.INSTANCE, null);
            String str12 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, stringSerializer, null);
            FerryResponseDTO ferryResponseDTO2 = (FerryResponseDTO) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, FerryResponseDTO$$serializer.INSTANCE, null);
            boolean decodeBooleanElement = beginStructure.decodeBooleanElement(serialDescriptor, 5);
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 6);
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 7);
            String decodeStringElement3 = beginStructure.decodeStringElement(serialDescriptor, 8);
            Duration duration2 = (Duration) beginStructure.decodeSerializableElement(serialDescriptor, 9, DurationSerializer.INSTANCE, null);
            String decodeStringElement4 = beginStructure.decodeStringElement(serialDescriptor, 10);
            String decodeStringElement5 = beginStructure.decodeStringElement(serialDescriptor, 11);
            BookingHeaderResponseDTO.RefundInfo refundInfo2 = (BookingHeaderResponseDTO.RefundInfo) beginStructure.decodeSerializableElement(serialDescriptor, 12, BookingHeaderResponseDTO$RefundInfo$$serializer.INSTANCE, null);
            String decodeStringElement6 = beginStructure.decodeStringElement(serialDescriptor, 13);
            String decodeStringElement7 = beginStructure.decodeStringElement(serialDescriptor, 14);
            boolean decodeBooleanElement2 = beginStructure.decodeBooleanElement(serialDescriptor, 15);
            SiteDTO siteDTO2 = (SiteDTO) beginStructure.decodeSerializableElement(serialDescriptor, 16, kSerializerArr[16], null);
            sublineDTO = (SublineDTO) beginStructure.decodeNullableSerializableElement(serialDescriptor, 17, SublineDTO$$serializer.INSTANCE, null);
            str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 18, stringSerializer, null);
            i5 = 524287;
            str9 = decodeStringElement6;
            ferryResponseDTO = ferryResponseDTO2;
            localDateTime = localDateTime2;
            str10 = decodeStringElement7;
            str8 = decodeStringElement5;
            z5 = decodeBooleanElement;
            duration = duration2;
            str5 = decodeStringElement2;
            str4 = decodeStringElement;
            str7 = decodeStringElement4;
            z6 = decodeBooleanElement2;
            refundInfo = refundInfo2;
            localTime = localTime2;
            siteDTO = siteDTO2;
            str3 = str11;
            str2 = str12;
            str6 = decodeStringElement3;
        } else {
            boolean z9 = true;
            LocalDateTime localDateTime3 = null;
            FerryResponseDTO ferryResponseDTO3 = null;
            String str13 = null;
            Duration duration3 = null;
            String str14 = null;
            String str15 = null;
            SublineDTO sublineDTO2 = null;
            SiteDTO siteDTO3 = null;
            BookingHeaderResponseDTO.RefundInfo refundInfo3 = null;
            String str16 = null;
            String str17 = null;
            String str18 = null;
            String str19 = null;
            String str20 = null;
            String str21 = null;
            String str22 = null;
            boolean z10 = false;
            boolean z11 = false;
            int i7 = 0;
            LocalTime localTime3 = null;
            while (z9) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z9 = false;
                    case 0:
                        z7 = z10;
                        str15 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, str15);
                        i7 |= 1;
                        z10 = z7;
                    case 1:
                        z7 = z10;
                        localTime3 = (LocalTime) beginStructure.decodeSerializableElement(serialDescriptor, 1, LocalTimeSerializer.INSTANCE, localTime3);
                        i7 |= 2;
                        z10 = z7;
                    case 2:
                        z7 = z10;
                        localDateTime3 = (LocalDateTime) beginStructure.decodeSerializableElement(serialDescriptor, 2, LocalDateTimeSerializer.INSTANCE, localDateTime3);
                        i7 |= 4;
                        z10 = z7;
                    case 3:
                        z7 = z10;
                        str14 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str14);
                        i7 |= 8;
                        z10 = z7;
                    case 4:
                        z7 = z10;
                        ferryResponseDTO3 = (FerryResponseDTO) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, FerryResponseDTO$$serializer.INSTANCE, ferryResponseDTO3);
                        i7 |= 16;
                        z10 = z7;
                    case 5:
                        z8 = z10;
                        z11 = beginStructure.decodeBooleanElement(serialDescriptor, 5);
                        i7 |= 32;
                        z10 = z8;
                    case 6:
                        z8 = z10;
                        str16 = beginStructure.decodeStringElement(serialDescriptor, 6);
                        i7 |= 64;
                        z10 = z8;
                    case 7:
                        z8 = z10;
                        str17 = beginStructure.decodeStringElement(serialDescriptor, 7);
                        i7 |= 128;
                        z10 = z8;
                    case 8:
                        z8 = z10;
                        str18 = beginStructure.decodeStringElement(serialDescriptor, 8);
                        i7 |= 256;
                        z10 = z8;
                    case 9:
                        z8 = z10;
                        duration3 = (Duration) beginStructure.decodeSerializableElement(serialDescriptor, 9, DurationSerializer.INSTANCE, duration3);
                        i7 |= 512;
                        z10 = z8;
                    case 10:
                        z7 = z10;
                        str19 = beginStructure.decodeStringElement(serialDescriptor, 10);
                        i7 |= 1024;
                        z10 = z7;
                    case 11:
                        z7 = z10;
                        str20 = beginStructure.decodeStringElement(serialDescriptor, 11);
                        i7 |= 2048;
                        z10 = z7;
                    case 12:
                        z7 = z10;
                        refundInfo3 = (BookingHeaderResponseDTO.RefundInfo) beginStructure.decodeSerializableElement(serialDescriptor, 12, BookingHeaderResponseDTO$RefundInfo$$serializer.INSTANCE, refundInfo3);
                        i7 |= 4096;
                        z10 = z7;
                    case 13:
                        z7 = z10;
                        str21 = beginStructure.decodeStringElement(serialDescriptor, 13);
                        i7 |= 8192;
                        z10 = z7;
                    case 14:
                        z7 = z10;
                        str22 = beginStructure.decodeStringElement(serialDescriptor, 14);
                        i7 |= 16384;
                        z10 = z7;
                    case 15:
                        i7 |= 32768;
                        z10 = beginStructure.decodeBooleanElement(serialDescriptor, 15);
                    case 16:
                        z7 = z10;
                        siteDTO3 = (SiteDTO) beginStructure.decodeSerializableElement(serialDescriptor, 16, kSerializerArr[16], siteDTO3);
                        i7 |= 65536;
                        z10 = z7;
                    case 17:
                        z7 = z10;
                        sublineDTO2 = (SublineDTO) beginStructure.decodeNullableSerializableElement(serialDescriptor, 17, SublineDTO$$serializer.INSTANCE, sublineDTO2);
                        i6 = 131072;
                        i7 |= i6;
                        z10 = z7;
                    case 18:
                        z7 = z10;
                        str13 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 18, StringSerializer.INSTANCE, str13);
                        i6 = 262144;
                        i7 |= i6;
                        z10 = z7;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            localDateTime = localDateTime3;
            ferryResponseDTO = ferryResponseDTO3;
            str = str13;
            duration = duration3;
            str2 = str14;
            i5 = i7;
            localTime = localTime3;
            str3 = str15;
            sublineDTO = sublineDTO2;
            siteDTO = siteDTO3;
            refundInfo = refundInfo3;
            str4 = str16;
            str5 = str17;
            str6 = str18;
            str7 = str19;
            str8 = str20;
            str9 = str21;
            str10 = str22;
            z5 = z11;
            z6 = z10;
        }
        beginStructure.endStructure(serialDescriptor);
        return new BookingHeaderResponseDTO(i5, str3, localTime, localDateTime, str2, ferryResponseDTO, z5, str4, str5, str6, duration, str7, str8, refundInfo, str9, str10, z6, siteDTO, sublineDTO, str, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, BookingHeaderResponseDTO value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        BookingHeaderResponseDTO.write$Self$api_kombardoProd(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
