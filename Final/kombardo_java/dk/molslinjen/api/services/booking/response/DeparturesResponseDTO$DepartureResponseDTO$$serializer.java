package dk.molslinjen.api.services.booking.response;

import com.sdk.growthbook.utils.Constants;
import dk.molslinjen.api.helpers.serializers.DurationSerializer;
import dk.molslinjen.api.helpers.serializers.LocalDateWithTimeSerializer;
import dk.molslinjen.api.helpers.serializers.LocalTimeSerializer;
import dk.molslinjen.api.services.booking.response.DeparturesResponseDTO;
import dk.molslinjen.api.services.booking.response.booking.FerryResponseDTO;
import dk.molslinjen.api.services.booking.response.booking.FerryResponseDTO$$serializer;
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

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"dk/molslinjen/api/services/booking/response/DeparturesResponseDTO.DepartureResponseDTO.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Ldk/molslinjen/api/services/booking/response/DeparturesResponseDTO$DepartureResponseDTO;", "<init>", "()V", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public /* synthetic */ class DeparturesResponseDTO$DepartureResponseDTO$$serializer implements GeneratedSerializer<DeparturesResponseDTO.DepartureResponseDTO> {
    public static final DeparturesResponseDTO$DepartureResponseDTO$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        DeparturesResponseDTO$DepartureResponseDTO$$serializer departuresResponseDTO$DepartureResponseDTO$$serializer = new DeparturesResponseDTO$DepartureResponseDTO$$serializer();
        INSTANCE = departuresResponseDTO$DepartureResponseDTO$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dk.molslinjen.api.services.booking.response.DeparturesResponseDTO.DepartureResponseDTO", departuresResponseDTO$DepartureResponseDTO$$serializer, 21);
        pluginGeneratedSerialDescriptor.addElement("arrivalHarbor", false);
        pluginGeneratedSerialDescriptor.addElement("arrivalTime", false);
        pluginGeneratedSerialDescriptor.addElement("cancelled", false);
        pluginGeneratedSerialDescriptor.addElement("customRouteTypeText", false);
        pluginGeneratedSerialDescriptor.addElement("date", false);
        pluginGeneratedSerialDescriptor.addElement("departureHarbor", false);
        pluginGeneratedSerialDescriptor.addElement("departureTime", false);
        pluginGeneratedSerialDescriptor.addElement("ferry", false);
        pluginGeneratedSerialDescriptor.addElement(Constants.ID_ATTRIBUTE_KEY, false);
        pluginGeneratedSerialDescriptor.addElement("information", false);
        pluginGeneratedSerialDescriptor.addElement("lowestPrice", false);
        pluginGeneratedSerialDescriptor.addElement("mainRouteId", false);
        pluginGeneratedSerialDescriptor.addElement("routeId", false);
        pluginGeneratedSerialDescriptor.addElement("routeTypes", false);
        pluginGeneratedSerialDescriptor.addElement("soldOut", false);
        pluginGeneratedSerialDescriptor.addElement("tickets", false);
        pluginGeneratedSerialDescriptor.addElement("transportSwitchDescription", false);
        pluginGeneratedSerialDescriptor.addElement("travelTime", false);
        pluginGeneratedSerialDescriptor.addElement("timeTableId", false);
        pluginGeneratedSerialDescriptor.addElement("limitedAvailability", false);
        pluginGeneratedSerialDescriptor.addElement("availableProductTypes", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private DeparturesResponseDTO$DepartureResponseDTO$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr;
        kSerializerArr = DeparturesResponseDTO.DepartureResponseDTO.$childSerializers;
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        KSerializer<?> nullable = BuiltinSerializersKt.getNullable(stringSerializer);
        KSerializer<?> nullable2 = BuiltinSerializersKt.getNullable(FerryResponseDTO$$serializer.INSTANCE);
        KSerializer<?> nullable3 = BuiltinSerializersKt.getNullable(stringSerializer);
        KSerializer<?> nullable4 = BuiltinSerializersKt.getNullable(DeparturesResponseDTO$CheapestTicketDTO$$serializer.INSTANCE);
        KSerializer<?> kSerializer = kSerializerArr[13];
        KSerializer<?> kSerializer2 = kSerializerArr[15];
        KSerializer<?> nullable5 = BuiltinSerializersKt.getNullable(stringSerializer);
        KSerializer<?> nullable6 = BuiltinSerializersKt.getNullable(kSerializerArr[20]);
        DeparturesResponseDTO$SimpleHarborDTO$$serializer departuresResponseDTO$SimpleHarborDTO$$serializer = DeparturesResponseDTO$SimpleHarborDTO$$serializer.INSTANCE;
        LocalTimeSerializer localTimeSerializer = LocalTimeSerializer.INSTANCE;
        BooleanSerializer booleanSerializer = BooleanSerializer.INSTANCE;
        return new KSerializer[]{departuresResponseDTO$SimpleHarborDTO$$serializer, localTimeSerializer, booleanSerializer, nullable, LocalDateWithTimeSerializer.INSTANCE, departuresResponseDTO$SimpleHarborDTO$$serializer, localTimeSerializer, nullable2, stringSerializer, nullable3, nullable4, stringSerializer, stringSerializer, kSerializer, booleanSerializer, kSerializer2, nullable5, DurationSerializer.INSTANCE, stringSerializer, booleanSerializer, nullable6};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x0131. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public final DeparturesResponseDTO.DepartureResponseDTO deserialize(Decoder decoder) {
        KSerializer[] kSerializerArr;
        LocalDate localDate;
        int i5;
        String str;
        LocalTime localTime;
        LocalTime localTime2;
        DeparturesResponseDTO.SimpleHarborDTO simpleHarborDTO;
        List list;
        boolean z5;
        DeparturesResponseDTO.CheapestTicketDTO cheapestTicketDTO;
        String str2;
        FerryResponseDTO ferryResponseDTO;
        DeparturesResponseDTO.SimpleHarborDTO simpleHarborDTO2;
        List list2;
        Duration duration;
        List list3;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        KSerializer[] kSerializerArr2;
        boolean z10;
        boolean z11;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        kSerializerArr = DeparturesResponseDTO.DepartureResponseDTO.$childSerializers;
        if (beginStructure.decodeSequentially()) {
            DeparturesResponseDTO$SimpleHarborDTO$$serializer departuresResponseDTO$SimpleHarborDTO$$serializer = DeparturesResponseDTO$SimpleHarborDTO$$serializer.INSTANCE;
            DeparturesResponseDTO.SimpleHarborDTO simpleHarborDTO3 = (DeparturesResponseDTO.SimpleHarborDTO) beginStructure.decodeSerializableElement(serialDescriptor, 0, departuresResponseDTO$SimpleHarborDTO$$serializer, null);
            LocalTimeSerializer localTimeSerializer = LocalTimeSerializer.INSTANCE;
            LocalTime localTime3 = (LocalTime) beginStructure.decodeSerializableElement(serialDescriptor, 1, localTimeSerializer, null);
            boolean decodeBooleanElement = beginStructure.decodeBooleanElement(serialDescriptor, 2);
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            String str8 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, stringSerializer, null);
            LocalDate localDate2 = (LocalDate) beginStructure.decodeSerializableElement(serialDescriptor, 4, LocalDateWithTimeSerializer.INSTANCE, null);
            DeparturesResponseDTO.SimpleHarborDTO simpleHarborDTO4 = (DeparturesResponseDTO.SimpleHarborDTO) beginStructure.decodeSerializableElement(serialDescriptor, 5, departuresResponseDTO$SimpleHarborDTO$$serializer, null);
            LocalTime localTime4 = (LocalTime) beginStructure.decodeSerializableElement(serialDescriptor, 6, localTimeSerializer, null);
            FerryResponseDTO ferryResponseDTO2 = (FerryResponseDTO) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, FerryResponseDTO$$serializer.INSTANCE, null);
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 8);
            String str9 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, stringSerializer, null);
            DeparturesResponseDTO.CheapestTicketDTO cheapestTicketDTO2 = (DeparturesResponseDTO.CheapestTicketDTO) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, DeparturesResponseDTO$CheapestTicketDTO$$serializer.INSTANCE, null);
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 11);
            String decodeStringElement3 = beginStructure.decodeStringElement(serialDescriptor, 12);
            List list4 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 13, kSerializerArr[13], null);
            boolean decodeBooleanElement2 = beginStructure.decodeBooleanElement(serialDescriptor, 14);
            List list5 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 15, kSerializerArr[15], null);
            String str10 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 16, stringSerializer, null);
            Duration duration2 = (Duration) beginStructure.decodeSerializableElement(serialDescriptor, 17, DurationSerializer.INSTANCE, null);
            String decodeStringElement4 = beginStructure.decodeStringElement(serialDescriptor, 18);
            boolean decodeBooleanElement3 = beginStructure.decodeBooleanElement(serialDescriptor, 19);
            localTime2 = localTime3;
            list2 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 20, kSerializerArr[20], null);
            duration = duration2;
            i5 = 2097151;
            localDate = localDate2;
            localTime = localTime4;
            z5 = decodeBooleanElement3;
            str5 = decodeStringElement3;
            ferryResponseDTO = ferryResponseDTO2;
            str7 = decodeStringElement4;
            str3 = decodeStringElement;
            str2 = str9;
            str4 = decodeStringElement2;
            str = str8;
            str6 = str10;
            list = list5;
            list3 = list4;
            z7 = decodeBooleanElement2;
            z6 = decodeBooleanElement;
            cheapestTicketDTO = cheapestTicketDTO2;
            simpleHarborDTO = simpleHarborDTO3;
            simpleHarborDTO2 = simpleHarborDTO4;
        } else {
            LocalDate localDate3 = null;
            LocalTime localTime5 = null;
            DeparturesResponseDTO.CheapestTicketDTO cheapestTicketDTO3 = null;
            String str11 = null;
            FerryResponseDTO ferryResponseDTO3 = null;
            DeparturesResponseDTO.SimpleHarborDTO simpleHarborDTO5 = null;
            DeparturesResponseDTO.SimpleHarborDTO simpleHarborDTO6 = null;
            String str12 = null;
            String str13 = null;
            String str14 = null;
            List list6 = null;
            List list7 = null;
            String str15 = null;
            Duration duration3 = null;
            String str16 = null;
            List list8 = null;
            boolean z12 = true;
            boolean z13 = false;
            boolean z14 = false;
            boolean z15 = false;
            String str17 = null;
            int i6 = 0;
            LocalTime localTime6 = null;
            while (z12) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        kSerializerArr2 = kSerializerArr;
                        z10 = z13;
                        z11 = z14;
                        z12 = false;
                        kSerializerArr = kSerializerArr2;
                        z13 = z10;
                        z14 = z11;
                    case 0:
                        kSerializerArr2 = kSerializerArr;
                        z10 = z13;
                        z11 = z14;
                        simpleHarborDTO6 = (DeparturesResponseDTO.SimpleHarborDTO) beginStructure.decodeSerializableElement(serialDescriptor, 0, DeparturesResponseDTO$SimpleHarborDTO$$serializer.INSTANCE, simpleHarborDTO6);
                        i6 |= 1;
                        list6 = list6;
                        kSerializerArr = kSerializerArr2;
                        z13 = z10;
                        z14 = z11;
                    case 1:
                        kSerializerArr2 = kSerializerArr;
                        z10 = z13;
                        z11 = z14;
                        localTime6 = (LocalTime) beginStructure.decodeSerializableElement(serialDescriptor, 1, LocalTimeSerializer.INSTANCE, localTime6);
                        i6 |= 2;
                        kSerializerArr = kSerializerArr2;
                        z13 = z10;
                        z14 = z11;
                    case 2:
                        z11 = z14;
                        i6 |= 4;
                        kSerializerArr = kSerializerArr;
                        z13 = beginStructure.decodeBooleanElement(serialDescriptor, 2);
                        z14 = z11;
                    case 3:
                        kSerializerArr2 = kSerializerArr;
                        z10 = z13;
                        z11 = z14;
                        str17 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str17);
                        i6 |= 8;
                        kSerializerArr = kSerializerArr2;
                        z13 = z10;
                        z14 = z11;
                    case 4:
                        kSerializerArr2 = kSerializerArr;
                        z10 = z13;
                        z11 = z14;
                        localDate3 = (LocalDate) beginStructure.decodeSerializableElement(serialDescriptor, 4, LocalDateWithTimeSerializer.INSTANCE, localDate3);
                        i6 |= 16;
                        kSerializerArr = kSerializerArr2;
                        z13 = z10;
                        z14 = z11;
                    case 5:
                        kSerializerArr2 = kSerializerArr;
                        z10 = z13;
                        z11 = z14;
                        simpleHarborDTO5 = (DeparturesResponseDTO.SimpleHarborDTO) beginStructure.decodeSerializableElement(serialDescriptor, 5, DeparturesResponseDTO$SimpleHarborDTO$$serializer.INSTANCE, simpleHarborDTO5);
                        i6 |= 32;
                        kSerializerArr = kSerializerArr2;
                        z13 = z10;
                        z14 = z11;
                    case 6:
                        kSerializerArr2 = kSerializerArr;
                        z10 = z13;
                        z11 = z14;
                        localTime5 = (LocalTime) beginStructure.decodeSerializableElement(serialDescriptor, 6, LocalTimeSerializer.INSTANCE, localTime5);
                        i6 |= 64;
                        kSerializerArr = kSerializerArr2;
                        z13 = z10;
                        z14 = z11;
                    case 7:
                        kSerializerArr2 = kSerializerArr;
                        z10 = z13;
                        z11 = z14;
                        ferryResponseDTO3 = (FerryResponseDTO) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, FerryResponseDTO$$serializer.INSTANCE, ferryResponseDTO3);
                        i6 |= 128;
                        kSerializerArr = kSerializerArr2;
                        z13 = z10;
                        z14 = z11;
                    case 8:
                        kSerializerArr2 = kSerializerArr;
                        z10 = z13;
                        z11 = z14;
                        str12 = beginStructure.decodeStringElement(serialDescriptor, 8);
                        i6 |= 256;
                        kSerializerArr = kSerializerArr2;
                        z13 = z10;
                        z14 = z11;
                    case 9:
                        kSerializerArr2 = kSerializerArr;
                        z10 = z13;
                        z11 = z14;
                        str11 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, StringSerializer.INSTANCE, str11);
                        i6 |= 512;
                        kSerializerArr = kSerializerArr2;
                        z13 = z10;
                        z14 = z11;
                    case 10:
                        kSerializerArr2 = kSerializerArr;
                        z10 = z13;
                        z11 = z14;
                        cheapestTicketDTO3 = (DeparturesResponseDTO.CheapestTicketDTO) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, DeparturesResponseDTO$CheapestTicketDTO$$serializer.INSTANCE, cheapestTicketDTO3);
                        i6 |= 1024;
                        kSerializerArr = kSerializerArr2;
                        z13 = z10;
                        z14 = z11;
                    case 11:
                        kSerializerArr2 = kSerializerArr;
                        z10 = z13;
                        z11 = z14;
                        str13 = beginStructure.decodeStringElement(serialDescriptor, 11);
                        i6 |= 2048;
                        kSerializerArr = kSerializerArr2;
                        z13 = z10;
                        z14 = z11;
                    case 12:
                        kSerializerArr2 = kSerializerArr;
                        z10 = z13;
                        z11 = z14;
                        str14 = beginStructure.decodeStringElement(serialDescriptor, 12);
                        i6 |= 4096;
                        kSerializerArr = kSerializerArr2;
                        z13 = z10;
                        z14 = z11;
                    case 13:
                        z10 = z13;
                        z11 = z14;
                        kSerializerArr2 = kSerializerArr;
                        list6 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 13, kSerializerArr[13], list6);
                        i6 |= 8192;
                        kSerializerArr = kSerializerArr2;
                        z13 = z10;
                        z14 = z11;
                    case 14:
                        i6 |= 16384;
                        z14 = beginStructure.decodeBooleanElement(serialDescriptor, 14);
                        z13 = z13;
                    case 15:
                        z10 = z13;
                        z11 = z14;
                        list7 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 15, kSerializerArr[15], list7);
                        i6 |= 32768;
                        z13 = z10;
                        z14 = z11;
                    case 16:
                        z10 = z13;
                        z11 = z14;
                        str15 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 16, StringSerializer.INSTANCE, str15);
                        i6 |= 65536;
                        duration3 = duration3;
                        z13 = z10;
                        z14 = z11;
                    case 17:
                        z10 = z13;
                        z11 = z14;
                        duration3 = (Duration) beginStructure.decodeSerializableElement(serialDescriptor, 17, DurationSerializer.INSTANCE, duration3);
                        i6 |= 131072;
                        list8 = list8;
                        z13 = z10;
                        z14 = z11;
                    case 18:
                        z10 = z13;
                        z11 = z14;
                        str16 = beginStructure.decodeStringElement(serialDescriptor, 18);
                        i6 |= 262144;
                        z13 = z10;
                        z14 = z11;
                    case 19:
                        z8 = z13;
                        z9 = z14;
                        z15 = beginStructure.decodeBooleanElement(serialDescriptor, 19);
                        i6 |= 524288;
                        list8 = list8;
                        z13 = z8;
                        z14 = z9;
                    case 20:
                        z8 = z13;
                        z9 = z14;
                        list8 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 20, kSerializerArr[20], list8);
                        i6 |= 1048576;
                        z13 = z8;
                        z14 = z9;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            localDate = localDate3;
            i5 = i6;
            str = str17;
            localTime = localTime5;
            localTime2 = localTime6;
            simpleHarborDTO = simpleHarborDTO6;
            list = list7;
            z5 = z15;
            cheapestTicketDTO = cheapestTicketDTO3;
            str2 = str11;
            ferryResponseDTO = ferryResponseDTO3;
            simpleHarborDTO2 = simpleHarborDTO5;
            list2 = list8;
            duration = duration3;
            list3 = list6;
            str3 = str12;
            str4 = str13;
            str5 = str14;
            str6 = str15;
            str7 = str16;
            z6 = z13;
            z7 = z14;
        }
        beginStructure.endStructure(serialDescriptor);
        return new DeparturesResponseDTO.DepartureResponseDTO(i5, simpleHarborDTO, localTime2, z6, str, localDate, simpleHarborDTO2, localTime, ferryResponseDTO, str3, str2, cheapestTicketDTO, str4, str5, list3, z7, list, str6, duration, str7, z5, list2, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, DeparturesResponseDTO.DepartureResponseDTO value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        DeparturesResponseDTO.DepartureResponseDTO.write$Self$api_kombardoProd(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
