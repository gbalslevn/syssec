package dk.molslinjen.api.services.multiRide.response;

import dk.molslinjen.api.helpers.serializers.DurationSerializer;
import dk.molslinjen.api.helpers.serializers.LocalDateWithTimeSerializer;
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
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;
import org.conscrypt.BuildConfig;
import org.threeten.bp.Duration;
import org.threeten.bp.LocalDate;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"dk/molslinjen/api/services/multiRide/response/MultiRideCardResponseDTO.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Ldk/molslinjen/api/services/multiRide/response/MultiRideCardResponseDTO;", "<init>", "()V", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public /* synthetic */ class MultiRideCardResponseDTO$$serializer implements GeneratedSerializer<MultiRideCardResponseDTO> {
    public static final MultiRideCardResponseDTO$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        MultiRideCardResponseDTO$$serializer multiRideCardResponseDTO$$serializer = new MultiRideCardResponseDTO$$serializer();
        INSTANCE = multiRideCardResponseDTO$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dk.molslinjen.api.services.multiRide.response.MultiRideCardResponseDTO", multiRideCardResponseDTO$$serializer, 12);
        pluginGeneratedSerialDescriptor.addElement("cardNumber", false);
        pluginGeneratedSerialDescriptor.addElement("cardType", false);
        pluginGeneratedSerialDescriptor.addElement("category", false);
        pluginGeneratedSerialDescriptor.addElement("enabledTransports", false);
        pluginGeneratedSerialDescriptor.addElement("defaultTransport", false);
        pluginGeneratedSerialDescriptor.addElement("numberOfTickets", false);
        pluginGeneratedSerialDescriptor.addElement("customerId", false);
        pluginGeneratedSerialDescriptor.addElement("validUntil", false);
        pluginGeneratedSerialDescriptor.addElement("allowedRoundtripRouteIds", false);
        pluginGeneratedSerialDescriptor.addElement("canRefill", false);
        pluginGeneratedSerialDescriptor.addElement("ticketExpiration", false);
        pluginGeneratedSerialDescriptor.addElement("ticketExpiringCount", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private MultiRideCardResponseDTO$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr;
        kSerializerArr = MultiRideCardResponseDTO.$childSerializers;
        KSerializer<?> kSerializer = kSerializerArr[3];
        KSerializer<?> kSerializer2 = kSerializerArr[8];
        KSerializer<?> nullable = BuiltinSerializersKt.getNullable(DurationSerializer.INSTANCE);
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        IntSerializer intSerializer = IntSerializer.INSTANCE;
        return new KSerializer[]{stringSerializer, stringSerializer, MultiRideTicketCategoryResponseDTO$$serializer.INSTANCE, kSerializer, MultiRideTransportDTO$$serializer.INSTANCE, intSerializer, stringSerializer, LocalDateWithTimeSerializer.INSTANCE, kSerializer2, BooleanSerializer.INSTANCE, nullable, intSerializer};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x00aa. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public final MultiRideCardResponseDTO deserialize(Decoder decoder) {
        KSerializer[] kSerializerArr;
        String str;
        int i5;
        Duration duration;
        List list;
        MultiRideTransportDTO multiRideTransportDTO;
        LocalDate localDate;
        List list2;
        MultiRideTicketCategoryResponseDTO multiRideTicketCategoryResponseDTO;
        String str2;
        String str3;
        int i6;
        boolean z5;
        int i7;
        char c5;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        kSerializerArr = MultiRideCardResponseDTO.$childSerializers;
        int i8 = 10;
        String str4 = null;
        if (beginStructure.decodeSequentially()) {
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 0);
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 1);
            MultiRideTicketCategoryResponseDTO multiRideTicketCategoryResponseDTO2 = (MultiRideTicketCategoryResponseDTO) beginStructure.decodeSerializableElement(serialDescriptor, 2, MultiRideTicketCategoryResponseDTO$$serializer.INSTANCE, null);
            List list3 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 3, kSerializerArr[3], null);
            MultiRideTransportDTO multiRideTransportDTO2 = (MultiRideTransportDTO) beginStructure.decodeSerializableElement(serialDescriptor, 4, MultiRideTransportDTO$$serializer.INSTANCE, null);
            int decodeIntElement = beginStructure.decodeIntElement(serialDescriptor, 5);
            String decodeStringElement3 = beginStructure.decodeStringElement(serialDescriptor, 6);
            LocalDate localDate2 = (LocalDate) beginStructure.decodeSerializableElement(serialDescriptor, 7, LocalDateWithTimeSerializer.INSTANCE, null);
            List list4 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 8, kSerializerArr[8], null);
            boolean decodeBooleanElement = beginStructure.decodeBooleanElement(serialDescriptor, 9);
            list = list4;
            str = decodeStringElement;
            duration = (Duration) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, DurationSerializer.INSTANCE, null);
            i6 = beginStructure.decodeIntElement(serialDescriptor, 11);
            z5 = decodeBooleanElement;
            localDate = localDate2;
            str3 = decodeStringElement3;
            i7 = decodeIntElement;
            multiRideTransportDTO = multiRideTransportDTO2;
            multiRideTicketCategoryResponseDTO = multiRideTicketCategoryResponseDTO2;
            list2 = list3;
            i5 = 4095;
            str2 = decodeStringElement2;
        } else {
            int i9 = 11;
            Duration duration2 = null;
            List list5 = null;
            MultiRideTransportDTO multiRideTransportDTO3 = null;
            LocalDate localDate3 = null;
            String str5 = null;
            String str6 = null;
            boolean z6 = true;
            int i10 = 0;
            int i11 = 0;
            boolean z7 = false;
            int i12 = 0;
            List list6 = null;
            MultiRideTicketCategoryResponseDTO multiRideTicketCategoryResponseDTO3 = null;
            while (z6) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z6 = false;
                        i8 = 10;
                    case 0:
                        i10 |= 1;
                        str4 = beginStructure.decodeStringElement(serialDescriptor, 0);
                        i9 = 11;
                        i8 = 10;
                    case 1:
                        str5 = beginStructure.decodeStringElement(serialDescriptor, 1);
                        i10 |= 2;
                        i9 = 11;
                        i8 = 10;
                    case 2:
                        multiRideTicketCategoryResponseDTO3 = (MultiRideTicketCategoryResponseDTO) beginStructure.decodeSerializableElement(serialDescriptor, 2, MultiRideTicketCategoryResponseDTO$$serializer.INSTANCE, multiRideTicketCategoryResponseDTO3);
                        i10 |= 4;
                        i9 = 11;
                        i8 = 10;
                    case 3:
                        list6 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 3, kSerializerArr[3], list6);
                        i10 |= 8;
                        i9 = 11;
                        i8 = 10;
                    case 4:
                        multiRideTransportDTO3 = (MultiRideTransportDTO) beginStructure.decodeSerializableElement(serialDescriptor, 4, MultiRideTransportDTO$$serializer.INSTANCE, multiRideTransportDTO3);
                        i10 |= 16;
                        i9 = 11;
                        i8 = 10;
                    case 5:
                        i12 = beginStructure.decodeIntElement(serialDescriptor, 5);
                        i10 |= 32;
                        i9 = 11;
                    case 6:
                        c5 = 7;
                        str6 = beginStructure.decodeStringElement(serialDescriptor, 6);
                        i10 |= 64;
                        i9 = 11;
                    case 7:
                        c5 = 7;
                        localDate3 = (LocalDate) beginStructure.decodeSerializableElement(serialDescriptor, 7, LocalDateWithTimeSerializer.INSTANCE, localDate3);
                        i10 |= 128;
                        i9 = 11;
                    case 8:
                        list5 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 8, kSerializerArr[8], list5);
                        i10 |= 256;
                    case 9:
                        z7 = beginStructure.decodeBooleanElement(serialDescriptor, 9);
                        i10 |= 512;
                    case 10:
                        duration2 = (Duration) beginStructure.decodeNullableSerializableElement(serialDescriptor, i8, DurationSerializer.INSTANCE, duration2);
                        i10 |= 1024;
                    case 11:
                        i11 = beginStructure.decodeIntElement(serialDescriptor, i9);
                        i10 |= 2048;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            str = str4;
            i5 = i10;
            duration = duration2;
            list = list5;
            multiRideTransportDTO = multiRideTransportDTO3;
            localDate = localDate3;
            list2 = list6;
            multiRideTicketCategoryResponseDTO = multiRideTicketCategoryResponseDTO3;
            str2 = str5;
            str3 = str6;
            i6 = i11;
            z5 = z7;
            i7 = i12;
        }
        beginStructure.endStructure(serialDescriptor);
        return new MultiRideCardResponseDTO(i5, str, str2, multiRideTicketCategoryResponseDTO, list2, multiRideTransportDTO, i7, str3, localDate, list, z5, duration, i6, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, MultiRideCardResponseDTO value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        MultiRideCardResponseDTO.write$Self$api_kombardoProd(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
