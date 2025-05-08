package dk.molslinjen.api.services.multiRide.response;

import com.sdk.growthbook.utils.Constants;
import dk.molslinjen.api.helpers.serializers.LocalDateWithTimeSerializer;
import dk.molslinjen.api.helpers.serializers.LocalTimeSerializer;
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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"dk/molslinjen/api/services/multiRide/response/MultiRideBookingTicketResponseDTO.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Ldk/molslinjen/api/services/multiRide/response/MultiRideBookingTicketResponseDTO;", "<init>", "()V", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public /* synthetic */ class MultiRideBookingTicketResponseDTO$$serializer implements GeneratedSerializer<MultiRideBookingTicketResponseDTO> {
    public static final MultiRideBookingTicketResponseDTO$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        MultiRideBookingTicketResponseDTO$$serializer multiRideBookingTicketResponseDTO$$serializer = new MultiRideBookingTicketResponseDTO$$serializer();
        INSTANCE = multiRideBookingTicketResponseDTO$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dk.molslinjen.api.services.multiRide.response.MultiRideBookingTicketResponseDTO", multiRideBookingTicketResponseDTO$$serializer, 12);
        pluginGeneratedSerialDescriptor.addElement(Constants.ID_ATTRIBUTE_KEY, false);
        pluginGeneratedSerialDescriptor.addElement("arrivalHarbor", false);
        pluginGeneratedSerialDescriptor.addElement("arrivalTime", false);
        pluginGeneratedSerialDescriptor.addElement("date", false);
        pluginGeneratedSerialDescriptor.addElement("departureHarbor", false);
        pluginGeneratedSerialDescriptor.addElement("departureRegionId", false);
        pluginGeneratedSerialDescriptor.addElement("departureTime", false);
        pluginGeneratedSerialDescriptor.addElement("ferry", false);
        pluginGeneratedSerialDescriptor.addElement("noShow", false);
        pluginGeneratedSerialDescriptor.addElement("numberPlate", false);
        pluginGeneratedSerialDescriptor.addElement("passengers", false);
        pluginGeneratedSerialDescriptor.addElement("phone", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private MultiRideBookingTicketResponseDTO$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        LocalTimeSerializer localTimeSerializer = LocalTimeSerializer.INSTANCE;
        return new KSerializer[]{stringSerializer, stringSerializer, localTimeSerializer, LocalDateWithTimeSerializer.INSTANCE, stringSerializer, stringSerializer, localTimeSerializer, stringSerializer, BooleanSerializer.INSTANCE, stringSerializer, IntSerializer.INSTANCE, stringSerializer};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x0099. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public final MultiRideBookingTicketResponseDTO deserialize(Decoder decoder) {
        int i5;
        LocalTime localTime;
        LocalDate localDate;
        LocalTime localTime2;
        int i6;
        boolean z5;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        int i7 = 10;
        int i8 = 0;
        if (beginStructure.decodeSequentially()) {
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 0);
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 1);
            LocalTimeSerializer localTimeSerializer = LocalTimeSerializer.INSTANCE;
            LocalTime localTime3 = (LocalTime) beginStructure.decodeSerializableElement(serialDescriptor, 2, localTimeSerializer, null);
            LocalDate localDate2 = (LocalDate) beginStructure.decodeSerializableElement(serialDescriptor, 3, LocalDateWithTimeSerializer.INSTANCE, null);
            String decodeStringElement3 = beginStructure.decodeStringElement(serialDescriptor, 4);
            String decodeStringElement4 = beginStructure.decodeStringElement(serialDescriptor, 5);
            LocalTime localTime4 = (LocalTime) beginStructure.decodeSerializableElement(serialDescriptor, 6, localTimeSerializer, null);
            String decodeStringElement5 = beginStructure.decodeStringElement(serialDescriptor, 7);
            boolean decodeBooleanElement = beginStructure.decodeBooleanElement(serialDescriptor, 8);
            String decodeStringElement6 = beginStructure.decodeStringElement(serialDescriptor, 9);
            str = decodeStringElement;
            localDate = localDate2;
            i5 = beginStructure.decodeIntElement(serialDescriptor, 10);
            str6 = decodeStringElement6;
            str5 = decodeStringElement5;
            localTime = localTime4;
            str4 = decodeStringElement4;
            str3 = decodeStringElement3;
            z5 = decodeBooleanElement;
            str7 = beginStructure.decodeStringElement(serialDescriptor, 11);
            localTime2 = localTime3;
            str2 = decodeStringElement2;
            i6 = 4095;
        } else {
            int i9 = 11;
            boolean z6 = true;
            int i10 = 0;
            LocalTime localTime5 = null;
            LocalDate localDate3 = null;
            LocalTime localTime6 = null;
            String str8 = null;
            String str9 = null;
            String str10 = null;
            String str11 = null;
            String str12 = null;
            String str13 = null;
            String str14 = null;
            boolean z7 = false;
            while (z6) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z6 = false;
                        i9 = 11;
                    case 0:
                        str8 = beginStructure.decodeStringElement(serialDescriptor, 0);
                        i8 |= 1;
                        i9 = 11;
                        i7 = 10;
                    case 1:
                        str9 = beginStructure.decodeStringElement(serialDescriptor, 1);
                        i8 |= 2;
                        i9 = 11;
                        i7 = 10;
                    case 2:
                        localTime6 = (LocalTime) beginStructure.decodeSerializableElement(serialDescriptor, 2, LocalTimeSerializer.INSTANCE, localTime6);
                        i8 |= 4;
                        i9 = 11;
                        i7 = 10;
                    case 3:
                        localDate3 = (LocalDate) beginStructure.decodeSerializableElement(serialDescriptor, 3, LocalDateWithTimeSerializer.INSTANCE, localDate3);
                        i8 |= 8;
                        i9 = 11;
                        i7 = 10;
                    case 4:
                        str10 = beginStructure.decodeStringElement(serialDescriptor, 4);
                        i8 |= 16;
                    case 5:
                        str11 = beginStructure.decodeStringElement(serialDescriptor, 5);
                        i8 |= 32;
                    case 6:
                        localTime5 = (LocalTime) beginStructure.decodeSerializableElement(serialDescriptor, 6, LocalTimeSerializer.INSTANCE, localTime5);
                        i8 |= 64;
                    case 7:
                        str12 = beginStructure.decodeStringElement(serialDescriptor, 7);
                        i8 |= 128;
                    case 8:
                        z7 = beginStructure.decodeBooleanElement(serialDescriptor, 8);
                        i8 |= 256;
                    case 9:
                        str13 = beginStructure.decodeStringElement(serialDescriptor, 9);
                        i8 |= 512;
                    case 10:
                        i10 = beginStructure.decodeIntElement(serialDescriptor, i7);
                        i8 |= 1024;
                    case 11:
                        str14 = beginStructure.decodeStringElement(serialDescriptor, i9);
                        i8 |= 2048;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            i5 = i10;
            localTime = localTime5;
            localDate = localDate3;
            localTime2 = localTime6;
            i6 = i8;
            z5 = z7;
            str = str8;
            str2 = str9;
            str3 = str10;
            str4 = str11;
            str5 = str12;
            str6 = str13;
            str7 = str14;
        }
        beginStructure.endStructure(serialDescriptor);
        return new MultiRideBookingTicketResponseDTO(i6, str, str2, localTime2, localDate, str3, str4, localTime, str5, z5, str6, i5, str7, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, MultiRideBookingTicketResponseDTO value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        MultiRideBookingTicketResponseDTO.write$Self$api_kombardoProd(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
