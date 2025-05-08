package dk.molslinjen.api.shared.response;

import com.sdk.growthbook.utils.Constants;
import dk.molslinjen.api.services.config.response.ConfigurationResponseDTO;
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
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"dk/molslinjen/api/shared/response/TransportResponseDTO.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Ldk/molslinjen/api/shared/response/TransportResponseDTO;", "<init>", "()V", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public /* synthetic */ class TransportResponseDTO$$serializer implements GeneratedSerializer<TransportResponseDTO> {
    public static final TransportResponseDTO$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        TransportResponseDTO$$serializer transportResponseDTO$$serializer = new TransportResponseDTO$$serializer();
        INSTANCE = transportResponseDTO$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dk.molslinjen.api.shared.response.TransportResponseDTO", transportResponseDTO$$serializer, 19);
        pluginGeneratedSerialDescriptor.addElement("allowedRoundtripRouteIds", false);
        pluginGeneratedSerialDescriptor.addElement("adultRequired", false);
        pluginGeneratedSerialDescriptor.addElement("adultRequiredForInfants", false);
        pluginGeneratedSerialDescriptor.addElement("allowLicensePlate", false);
        pluginGeneratedSerialDescriptor.addElement("licensePlateRequired", false);
        pluginGeneratedSerialDescriptor.addElement("imageUrl", false);
        pluginGeneratedSerialDescriptor.addElement(Constants.ID_ATTRIBUTE_KEY, false);
        pluginGeneratedSerialDescriptor.addElement("isEarlyCheckInAllowed", false);
        pluginGeneratedSerialDescriptor.addElement("isFreightPossible", false);
        pluginGeneratedSerialDescriptor.addElement("isWalking", false);
        pluginGeneratedSerialDescriptor.addElement("isOnlyAvailableWithReturnTicket", false);
        pluginGeneratedSerialDescriptor.addElement("maxHeight", false);
        pluginGeneratedSerialDescriptor.addElement("maxLength", false);
        pluginGeneratedSerialDescriptor.addElement("maxPassengers", false);
        pluginGeneratedSerialDescriptor.addElement("maxWeight", false);
        pluginGeneratedSerialDescriptor.addElement("name", false);
        pluginGeneratedSerialDescriptor.addElement("passengerEntryType", false);
        pluginGeneratedSerialDescriptor.addElement("personDataOnlyForChauffeur", false);
        pluginGeneratedSerialDescriptor.addElement("trailerAllowed", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private TransportResponseDTO$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr;
        kSerializerArr = TransportResponseDTO.$childSerializers;
        KSerializer<?> kSerializer = kSerializerArr[0];
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        KSerializer<?> nullable = BuiltinSerializersKt.getNullable(stringSerializer);
        BooleanSerializer booleanSerializer = BooleanSerializer.INSTANCE;
        DoubleSerializer doubleSerializer = DoubleSerializer.INSTANCE;
        return new KSerializer[]{kSerializer, booleanSerializer, booleanSerializer, booleanSerializer, booleanSerializer, nullable, stringSerializer, booleanSerializer, booleanSerializer, booleanSerializer, booleanSerializer, doubleSerializer, doubleSerializer, IntSerializer.INSTANCE, doubleSerializer, stringSerializer, ConfigurationResponseDTO.PassengerEntryTypeDTO.Serializer.INSTANCE, booleanSerializer, booleanSerializer};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x00fb. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public final TransportResponseDTO deserialize(Decoder decoder) {
        KSerializer[] kSerializerArr;
        List list;
        int i5;
        ConfigurationResponseDTO.PassengerEntryTypeDTO passengerEntryTypeDTO;
        boolean z5;
        String str;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        String str2;
        int i6;
        String str3;
        boolean z12;
        boolean z13;
        boolean z14;
        double d5;
        double d6;
        double d7;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        kSerializerArr = TransportResponseDTO.$childSerializers;
        int i7 = 8;
        if (beginStructure.decodeSequentially()) {
            List list2 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 0, kSerializerArr[0], null);
            boolean decodeBooleanElement = beginStructure.decodeBooleanElement(serialDescriptor, 1);
            boolean decodeBooleanElement2 = beginStructure.decodeBooleanElement(serialDescriptor, 2);
            boolean decodeBooleanElement3 = beginStructure.decodeBooleanElement(serialDescriptor, 3);
            boolean decodeBooleanElement4 = beginStructure.decodeBooleanElement(serialDescriptor, 4);
            String str4 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, null);
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 6);
            boolean decodeBooleanElement5 = beginStructure.decodeBooleanElement(serialDescriptor, 7);
            boolean decodeBooleanElement6 = beginStructure.decodeBooleanElement(serialDescriptor, 8);
            boolean decodeBooleanElement7 = beginStructure.decodeBooleanElement(serialDescriptor, 9);
            boolean decodeBooleanElement8 = beginStructure.decodeBooleanElement(serialDescriptor, 10);
            double decodeDoubleElement = beginStructure.decodeDoubleElement(serialDescriptor, 11);
            double decodeDoubleElement2 = beginStructure.decodeDoubleElement(serialDescriptor, 12);
            int decodeIntElement = beginStructure.decodeIntElement(serialDescriptor, 13);
            double decodeDoubleElement3 = beginStructure.decodeDoubleElement(serialDescriptor, 14);
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 15);
            passengerEntryTypeDTO = (ConfigurationResponseDTO.PassengerEntryTypeDTO) beginStructure.decodeSerializableElement(serialDescriptor, 16, ConfigurationResponseDTO.PassengerEntryTypeDTO.Serializer.INSTANCE, null);
            z6 = beginStructure.decodeBooleanElement(serialDescriptor, 17);
            z7 = decodeBooleanElement3;
            z8 = decodeBooleanElement6;
            z9 = decodeBooleanElement4;
            z10 = decodeBooleanElement2;
            str = str4;
            z11 = beginStructure.decodeBooleanElement(serialDescriptor, 18);
            i6 = decodeIntElement;
            z12 = decodeBooleanElement8;
            z13 = decodeBooleanElement7;
            z14 = decodeBooleanElement5;
            d5 = decodeDoubleElement;
            i5 = 524287;
            str2 = decodeStringElement;
            str3 = decodeStringElement2;
            z5 = decodeBooleanElement;
            list = list2;
            d6 = decodeDoubleElement2;
            d7 = decodeDoubleElement3;
        } else {
            int i8 = 18;
            boolean z15 = true;
            ConfigurationResponseDTO.PassengerEntryTypeDTO passengerEntryTypeDTO2 = null;
            List list3 = null;
            String str5 = null;
            String str6 = null;
            int i9 = 0;
            boolean z16 = false;
            boolean z17 = false;
            boolean z18 = false;
            boolean z19 = false;
            int i10 = 0;
            boolean z20 = false;
            boolean z21 = false;
            boolean z22 = false;
            double d8 = 0.0d;
            double d9 = 0.0d;
            double d10 = 0.0d;
            boolean z23 = false;
            boolean z24 = false;
            boolean z25 = false;
            String str7 = null;
            while (z15) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z15 = false;
                        i8 = 18;
                        i7 = 8;
                    case 0:
                        list3 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 0, kSerializerArr[0], list3);
                        i9 |= 1;
                        i8 = 18;
                        i7 = 8;
                    case 1:
                        i9 |= 2;
                        z25 = beginStructure.decodeBooleanElement(serialDescriptor, 1);
                        i8 = 18;
                    case 2:
                        z18 = beginStructure.decodeBooleanElement(serialDescriptor, 2);
                        i9 |= 4;
                        i8 = 18;
                    case 3:
                        z24 = beginStructure.decodeBooleanElement(serialDescriptor, 3);
                        i9 |= 8;
                        i8 = 18;
                    case 4:
                        z17 = beginStructure.decodeBooleanElement(serialDescriptor, 4);
                        i9 |= 16;
                        i8 = 18;
                    case 5:
                        str7 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, str7);
                        i9 |= 32;
                        i8 = 18;
                    case 6:
                        str5 = beginStructure.decodeStringElement(serialDescriptor, 6);
                        i9 |= 64;
                        i8 = 18;
                    case 7:
                        z22 = beginStructure.decodeBooleanElement(serialDescriptor, 7);
                        i9 |= 128;
                        i8 = 18;
                    case 8:
                        z16 = beginStructure.decodeBooleanElement(serialDescriptor, i7);
                        i9 |= 256;
                        i8 = 18;
                    case 9:
                        z21 = beginStructure.decodeBooleanElement(serialDescriptor, 9);
                        i9 |= 512;
                        i8 = 18;
                    case 10:
                        z20 = beginStructure.decodeBooleanElement(serialDescriptor, 10);
                        i9 |= 1024;
                        i8 = 18;
                    case 11:
                        d8 = beginStructure.decodeDoubleElement(serialDescriptor, 11);
                        i9 |= 2048;
                        i8 = 18;
                    case 12:
                        d9 = beginStructure.decodeDoubleElement(serialDescriptor, 12);
                        i9 |= 4096;
                        i8 = 18;
                    case 13:
                        i10 = beginStructure.decodeIntElement(serialDescriptor, 13);
                        i9 |= 8192;
                        i8 = 18;
                    case 14:
                        d10 = beginStructure.decodeDoubleElement(serialDescriptor, 14);
                        i9 |= 16384;
                        i8 = 18;
                    case 15:
                        str6 = beginStructure.decodeStringElement(serialDescriptor, 15);
                        i9 |= 32768;
                        i8 = 18;
                    case 16:
                        passengerEntryTypeDTO2 = (ConfigurationResponseDTO.PassengerEntryTypeDTO) beginStructure.decodeSerializableElement(serialDescriptor, 16, ConfigurationResponseDTO.PassengerEntryTypeDTO.Serializer.INSTANCE, passengerEntryTypeDTO2);
                        i9 |= 65536;
                        i8 = 18;
                    case 17:
                        z23 = beginStructure.decodeBooleanElement(serialDescriptor, 17);
                        i9 |= 131072;
                    case 18:
                        z19 = beginStructure.decodeBooleanElement(serialDescriptor, i8);
                        i9 |= 262144;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            list = list3;
            i5 = i9;
            passengerEntryTypeDTO = passengerEntryTypeDTO2;
            z5 = z25;
            str = str7;
            z6 = z23;
            z7 = z24;
            z8 = z16;
            z9 = z17;
            z10 = z18;
            z11 = z19;
            str2 = str5;
            i6 = i10;
            str3 = str6;
            z12 = z20;
            z13 = z21;
            z14 = z22;
            d5 = d8;
            d6 = d9;
            d7 = d10;
        }
        beginStructure.endStructure(serialDescriptor);
        return new TransportResponseDTO(i5, list, z5, z10, z7, z9, str, str2, z14, z8, z13, z12, d5, d6, i6, d7, str3, passengerEntryTypeDTO, z6, z11, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, TransportResponseDTO value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        TransportResponseDTO.write$Self$api_kombardoProd(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
