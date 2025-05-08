package dk.molslinjen.domain.model.booking;

import dk.molslinjen.api.helpers.serializers.DurationSerializer;
import dk.molslinjen.api.helpers.serializers.LocalDateSerializer;
import dk.molslinjen.api.helpers.serializers.LocalTimeSerializer;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.domain.model.config.Subline;
import dk.molslinjen.domain.model.config.Subline$$serializer;
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
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.conscrypt.BuildConfig;
import org.threeten.bp.Duration;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"dk/molslinjen/domain/model/booking/BookingHeader.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Ldk/molslinjen/domain/model/booking/BookingHeader;", "<init>", "()V", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public /* synthetic */ class BookingHeader$$serializer implements GeneratedSerializer<BookingHeader> {
    public static final BookingHeader$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        BookingHeader$$serializer bookingHeader$$serializer = new BookingHeader$$serializer();
        INSTANCE = bookingHeader$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dk.molslinjen.domain.model.booking.BookingHeader", bookingHeader$$serializer, 21);
        pluginGeneratedSerialDescriptor.addElement("arrivalHarborName", false);
        pluginGeneratedSerialDescriptor.addElement("date", false);
        pluginGeneratedSerialDescriptor.addElement("arrivalTime", false);
        pluginGeneratedSerialDescriptor.addElement("departureTime", false);
        pluginGeneratedSerialDescriptor.addElement("departureHarborName", false);
        pluginGeneratedSerialDescriptor.addElement("ferry", false);
        pluginGeneratedSerialDescriptor.addElement("timeTableId", false);
        pluginGeneratedSerialDescriptor.addElement("isCheckedIn", false);
        pluginGeneratedSerialDescriptor.addElement("isEarlyCheckInAllowed", false);
        pluginGeneratedSerialDescriptor.addElement("phone", false);
        pluginGeneratedSerialDescriptor.addElement("reservationId", false);
        pluginGeneratedSerialDescriptor.addElement("departureId", false);
        pluginGeneratedSerialDescriptor.addElement("travelTime", false);
        pluginGeneratedSerialDescriptor.addElement("routeId", false);
        pluginGeneratedSerialDescriptor.addElement("routeType", false);
        pluginGeneratedSerialDescriptor.addElement("transportationId", false);
        pluginGeneratedSerialDescriptor.addElement("refunded", false);
        pluginGeneratedSerialDescriptor.addElement("site", false);
        pluginGeneratedSerialDescriptor.addElement("ticketCategory", false);
        pluginGeneratedSerialDescriptor.addElement("subline", true);
        pluginGeneratedSerialDescriptor.addElement("lineLogoUrl", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private BookingHeader$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr;
        kSerializerArr = BookingHeader.$childSerializers;
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        KSerializer<?> nullable = BuiltinSerializersKt.getNullable(Ferry$$serializer.INSTANCE);
        KSerializer<?> nullable2 = BuiltinSerializersKt.getNullable(kSerializerArr[14]);
        KSerializer<?> kSerializer = kSerializerArr[17];
        KSerializer<?> nullable3 = BuiltinSerializersKt.getNullable(Subline$$serializer.INSTANCE);
        KSerializer<?> nullable4 = BuiltinSerializersKt.getNullable(stringSerializer);
        LocalTimeSerializer localTimeSerializer = LocalTimeSerializer.INSTANCE;
        BooleanSerializer booleanSerializer = BooleanSerializer.INSTANCE;
        return new KSerializer[]{stringSerializer, LocalDateSerializer.INSTANCE, localTimeSerializer, localTimeSerializer, stringSerializer, nullable, stringSerializer, booleanSerializer, booleanSerializer, stringSerializer, stringSerializer, stringSerializer, DurationSerializer.INSTANCE, stringSerializer, nullable2, stringSerializer, booleanSerializer, kSerializer, TicketCategory$$serializer.INSTANCE, nullable3, nullable4};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x0124. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public final BookingHeader deserialize(Decoder decoder) {
        KSerializer[] kSerializerArr;
        LocalDate localDate;
        Ferry ferry;
        Duration duration;
        Subline subline;
        LocalTime localTime;
        LocalTime localTime2;
        int i5;
        String str;
        TicketCategory ticketCategory;
        Site site;
        RouteType routeType;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        int i6;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        kSerializerArr = BookingHeader.$childSerializers;
        if (beginStructure.decodeSequentially()) {
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 0);
            LocalDate localDate2 = (LocalDate) beginStructure.decodeSerializableElement(serialDescriptor, 1, LocalDateSerializer.INSTANCE, null);
            LocalTimeSerializer localTimeSerializer = LocalTimeSerializer.INSTANCE;
            LocalTime localTime3 = (LocalTime) beginStructure.decodeSerializableElement(serialDescriptor, 2, localTimeSerializer, null);
            LocalTime localTime4 = (LocalTime) beginStructure.decodeSerializableElement(serialDescriptor, 3, localTimeSerializer, null);
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 4);
            Ferry ferry2 = (Ferry) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, Ferry$$serializer.INSTANCE, null);
            String decodeStringElement3 = beginStructure.decodeStringElement(serialDescriptor, 6);
            boolean decodeBooleanElement = beginStructure.decodeBooleanElement(serialDescriptor, 7);
            boolean decodeBooleanElement2 = beginStructure.decodeBooleanElement(serialDescriptor, 8);
            String decodeStringElement4 = beginStructure.decodeStringElement(serialDescriptor, 9);
            String decodeStringElement5 = beginStructure.decodeStringElement(serialDescriptor, 10);
            String decodeStringElement6 = beginStructure.decodeStringElement(serialDescriptor, 11);
            Duration duration2 = (Duration) beginStructure.decodeSerializableElement(serialDescriptor, 12, DurationSerializer.INSTANCE, null);
            String decodeStringElement7 = beginStructure.decodeStringElement(serialDescriptor, 13);
            RouteType routeType2 = (RouteType) beginStructure.decodeNullableSerializableElement(serialDescriptor, 14, kSerializerArr[14], null);
            String decodeStringElement8 = beginStructure.decodeStringElement(serialDescriptor, 15);
            boolean decodeBooleanElement3 = beginStructure.decodeBooleanElement(serialDescriptor, 16);
            Site site2 = (Site) beginStructure.decodeSerializableElement(serialDescriptor, 17, kSerializerArr[17], null);
            TicketCategory ticketCategory2 = (TicketCategory) beginStructure.decodeSerializableElement(serialDescriptor, 18, TicketCategory$$serializer.INSTANCE, null);
            Subline subline2 = (Subline) beginStructure.decodeNullableSerializableElement(serialDescriptor, 19, Subline$$serializer.INSTANCE, null);
            str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 20, StringSerializer.INSTANCE, null);
            i5 = 2097151;
            str9 = decodeStringElement8;
            str3 = decodeStringElement2;
            z7 = decodeBooleanElement2;
            localTime2 = localTime3;
            localDate = localDate2;
            z5 = decodeBooleanElement3;
            str6 = decodeStringElement5;
            str5 = decodeStringElement4;
            z6 = decodeBooleanElement;
            str4 = decodeStringElement3;
            str7 = decodeStringElement6;
            subline = subline2;
            ticketCategory = ticketCategory2;
            routeType = routeType2;
            ferry = ferry2;
            duration = duration2;
            site = site2;
            str8 = decodeStringElement7;
            str2 = decodeStringElement;
            localTime = localTime4;
        } else {
            boolean z9 = false;
            boolean z10 = false;
            boolean z11 = false;
            boolean z12 = true;
            Ferry ferry3 = null;
            Duration duration3 = null;
            Subline subline3 = null;
            LocalTime localTime5 = null;
            LocalTime localTime6 = null;
            String str10 = null;
            TicketCategory ticketCategory3 = null;
            Site site3 = null;
            RouteType routeType3 = null;
            String str11 = null;
            String str12 = null;
            String str13 = null;
            String str14 = null;
            String str15 = null;
            String str16 = null;
            String str17 = null;
            String str18 = null;
            LocalDate localDate3 = null;
            int i7 = 0;
            while (z12) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z8 = z9;
                        z12 = false;
                        z9 = z8;
                    case 0:
                        z8 = z9;
                        str11 = beginStructure.decodeStringElement(serialDescriptor, 0);
                        i7 |= 1;
                        z9 = z8;
                    case 1:
                        z8 = z9;
                        localDate3 = (LocalDate) beginStructure.decodeSerializableElement(serialDescriptor, 1, LocalDateSerializer.INSTANCE, localDate3);
                        i7 |= 2;
                        z9 = z8;
                    case 2:
                        z8 = z9;
                        localTime6 = (LocalTime) beginStructure.decodeSerializableElement(serialDescriptor, 2, LocalTimeSerializer.INSTANCE, localTime6);
                        i7 |= 4;
                        z9 = z8;
                    case 3:
                        z8 = z9;
                        localTime5 = (LocalTime) beginStructure.decodeSerializableElement(serialDescriptor, 3, LocalTimeSerializer.INSTANCE, localTime5);
                        i7 |= 8;
                        z9 = z8;
                    case 4:
                        z8 = z9;
                        str12 = beginStructure.decodeStringElement(serialDescriptor, 4);
                        i7 |= 16;
                        z9 = z8;
                    case 5:
                        z8 = z9;
                        ferry3 = (Ferry) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, Ferry$$serializer.INSTANCE, ferry3);
                        i7 |= 32;
                        z9 = z8;
                    case 6:
                        z8 = z9;
                        str13 = beginStructure.decodeStringElement(serialDescriptor, 6);
                        i7 |= 64;
                        z9 = z8;
                    case 7:
                        z8 = z9;
                        z11 = beginStructure.decodeBooleanElement(serialDescriptor, 7);
                        i7 |= 128;
                        z9 = z8;
                    case 8:
                        i7 |= 256;
                        z9 = beginStructure.decodeBooleanElement(serialDescriptor, 8);
                    case 9:
                        z8 = z9;
                        str14 = beginStructure.decodeStringElement(serialDescriptor, 9);
                        i7 |= 512;
                        z9 = z8;
                    case 10:
                        str15 = beginStructure.decodeStringElement(serialDescriptor, 10);
                        i7 |= 1024;
                        z9 = z9;
                    case 11:
                        z8 = z9;
                        str16 = beginStructure.decodeStringElement(serialDescriptor, 11);
                        i7 |= 2048;
                        z9 = z8;
                    case 12:
                        z8 = z9;
                        duration3 = (Duration) beginStructure.decodeSerializableElement(serialDescriptor, 12, DurationSerializer.INSTANCE, duration3);
                        i7 |= 4096;
                        z9 = z8;
                    case 13:
                        z8 = z9;
                        str17 = beginStructure.decodeStringElement(serialDescriptor, 13);
                        i7 |= 8192;
                        z9 = z8;
                    case 14:
                        z8 = z9;
                        routeType3 = (RouteType) beginStructure.decodeNullableSerializableElement(serialDescriptor, 14, kSerializerArr[14], routeType3);
                        i7 |= 16384;
                        z9 = z8;
                    case 15:
                        z8 = z9;
                        str18 = beginStructure.decodeStringElement(serialDescriptor, 15);
                        i7 |= 32768;
                        z9 = z8;
                    case 16:
                        z8 = z9;
                        z10 = beginStructure.decodeBooleanElement(serialDescriptor, 16);
                        i7 |= 65536;
                        z9 = z8;
                    case 17:
                        z8 = z9;
                        site3 = (Site) beginStructure.decodeSerializableElement(serialDescriptor, 17, kSerializerArr[17], site3);
                        i7 |= 131072;
                        z9 = z8;
                    case 18:
                        z8 = z9;
                        ticketCategory3 = (TicketCategory) beginStructure.decodeSerializableElement(serialDescriptor, 18, TicketCategory$$serializer.INSTANCE, ticketCategory3);
                        i6 = 262144;
                        i7 |= i6;
                        z9 = z8;
                    case 19:
                        z8 = z9;
                        subline3 = (Subline) beginStructure.decodeNullableSerializableElement(serialDescriptor, 19, Subline$$serializer.INSTANCE, subline3);
                        i6 = 524288;
                        i7 |= i6;
                        z9 = z8;
                    case 20:
                        z8 = z9;
                        str10 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 20, StringSerializer.INSTANCE, str10);
                        i6 = 1048576;
                        i7 |= i6;
                        z9 = z8;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            localDate = localDate3;
            ferry = ferry3;
            duration = duration3;
            subline = subline3;
            localTime = localTime5;
            localTime2 = localTime6;
            i5 = i7;
            str = str10;
            ticketCategory = ticketCategory3;
            site = site3;
            routeType = routeType3;
            str2 = str11;
            str3 = str12;
            str4 = str13;
            str5 = str14;
            str6 = str15;
            str7 = str16;
            str8 = str17;
            str9 = str18;
            z5 = z10;
            z6 = z11;
            z7 = z9;
        }
        beginStructure.endStructure(serialDescriptor);
        return new BookingHeader(i5, str2, localDate, localTime2, localTime, str3, ferry, str4, z6, z7, str5, str6, str7, duration, str8, routeType, str9, z5, site, ticketCategory, subline, str, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, BookingHeader value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        BookingHeader.write$Self$domain_kombardoProd(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
