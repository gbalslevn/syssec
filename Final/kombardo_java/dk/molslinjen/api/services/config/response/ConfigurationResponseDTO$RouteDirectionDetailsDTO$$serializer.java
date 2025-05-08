package dk.molslinjen.api.services.config.response;

import com.sdk.growthbook.utils.Constants;
import dk.molslinjen.api.helpers.serializers.DurationSerializer;
import dk.molslinjen.api.services.config.response.ConfigurationResponseDTO;
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

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"dk/molslinjen/api/services/config/response/ConfigurationResponseDTO.RouteDirectionDetailsDTO.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$RouteDirectionDetailsDTO;", "<init>", "()V", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public /* synthetic */ class ConfigurationResponseDTO$RouteDirectionDetailsDTO$$serializer implements GeneratedSerializer<ConfigurationResponseDTO.RouteDirectionDetailsDTO> {
    public static final ConfigurationResponseDTO$RouteDirectionDetailsDTO$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        ConfigurationResponseDTO$RouteDirectionDetailsDTO$$serializer configurationResponseDTO$RouteDirectionDetailsDTO$$serializer = new ConfigurationResponseDTO$RouteDirectionDetailsDTO$$serializer();
        INSTANCE = configurationResponseDTO$RouteDirectionDetailsDTO$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dk.molslinjen.api.services.config.response.ConfigurationResponseDTO.RouteDirectionDetailsDTO", configurationResponseDTO$RouteDirectionDetailsDTO$$serializer, 11);
        pluginGeneratedSerialDescriptor.addElement("allowDangerousGoods", false);
        pluginGeneratedSerialDescriptor.addElement("arrivalHarbor", false);
        pluginGeneratedSerialDescriptor.addElement("departureHarbor", false);
        pluginGeneratedSerialDescriptor.addElement("askForPersonData", false);
        pluginGeneratedSerialDescriptor.addElement(Constants.ID_ATTRIBUTE_KEY, false);
        pluginGeneratedSerialDescriptor.addElement("name", false);
        pluginGeneratedSerialDescriptor.addElement("travelTime", false);
        pluginGeneratedSerialDescriptor.addElement("routeTypes", false);
        pluginGeneratedSerialDescriptor.addElement("isSubRoute", false);
        pluginGeneratedSerialDescriptor.addElement("isEarlyCheckInPossible", false);
        pluginGeneratedSerialDescriptor.addElement("subline", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private ConfigurationResponseDTO$RouteDirectionDetailsDTO$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr;
        kSerializerArr = ConfigurationResponseDTO.RouteDirectionDetailsDTO.$childSerializers;
        KSerializer<?> kSerializer = kSerializerArr[7];
        KSerializer<?> nullable = BuiltinSerializersKt.getNullable(SublineDTO$$serializer.INSTANCE);
        BooleanSerializer booleanSerializer = BooleanSerializer.INSTANCE;
        ConfigurationResponseDTO$HarborReferenceDTO$$serializer configurationResponseDTO$HarborReferenceDTO$$serializer = ConfigurationResponseDTO$HarborReferenceDTO$$serializer.INSTANCE;
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{booleanSerializer, configurationResponseDTO$HarborReferenceDTO$$serializer, configurationResponseDTO$HarborReferenceDTO$$serializer, booleanSerializer, stringSerializer, stringSerializer, DurationSerializer.INSTANCE, kSerializer, booleanSerializer, booleanSerializer, nullable};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x0099. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public final ConfigurationResponseDTO.RouteDirectionDetailsDTO deserialize(Decoder decoder) {
        KSerializer[] kSerializerArr;
        boolean z5;
        ConfigurationResponseDTO.HarborReferenceDTO harborReferenceDTO;
        List list;
        SublineDTO sublineDTO;
        Duration duration;
        ConfigurationResponseDTO.HarborReferenceDTO harborReferenceDTO2;
        int i5;
        boolean z6;
        boolean z7;
        boolean z8;
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        kSerializerArr = ConfigurationResponseDTO.RouteDirectionDetailsDTO.$childSerializers;
        int i6 = 10;
        int i7 = 9;
        int i8 = 6;
        int i9 = 0;
        if (beginStructure.decodeSequentially()) {
            boolean decodeBooleanElement = beginStructure.decodeBooleanElement(serialDescriptor, 0);
            ConfigurationResponseDTO$HarborReferenceDTO$$serializer configurationResponseDTO$HarborReferenceDTO$$serializer = ConfigurationResponseDTO$HarborReferenceDTO$$serializer.INSTANCE;
            ConfigurationResponseDTO.HarborReferenceDTO harborReferenceDTO3 = (ConfigurationResponseDTO.HarborReferenceDTO) beginStructure.decodeSerializableElement(serialDescriptor, 1, configurationResponseDTO$HarborReferenceDTO$$serializer, null);
            ConfigurationResponseDTO.HarborReferenceDTO harborReferenceDTO4 = (ConfigurationResponseDTO.HarborReferenceDTO) beginStructure.decodeSerializableElement(serialDescriptor, 2, configurationResponseDTO$HarborReferenceDTO$$serializer, null);
            boolean decodeBooleanElement2 = beginStructure.decodeBooleanElement(serialDescriptor, 3);
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 4);
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 5);
            Duration duration2 = (Duration) beginStructure.decodeSerializableElement(serialDescriptor, 6, DurationSerializer.INSTANCE, null);
            List list2 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 7, kSerializerArr[7], null);
            boolean decodeBooleanElement3 = beginStructure.decodeBooleanElement(serialDescriptor, 8);
            boolean decodeBooleanElement4 = beginStructure.decodeBooleanElement(serialDescriptor, 9);
            list = list2;
            z5 = decodeBooleanElement;
            sublineDTO = (SublineDTO) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, SublineDTO$$serializer.INSTANCE, null);
            z6 = decodeBooleanElement4;
            duration = duration2;
            str2 = decodeStringElement2;
            z7 = decodeBooleanElement2;
            z8 = decodeBooleanElement3;
            str = decodeStringElement;
            harborReferenceDTO2 = harborReferenceDTO4;
            i5 = 2047;
            harborReferenceDTO = harborReferenceDTO3;
        } else {
            boolean z9 = true;
            boolean z10 = false;
            boolean z11 = false;
            boolean z12 = false;
            List list3 = null;
            SublineDTO sublineDTO2 = null;
            Duration duration3 = null;
            ConfigurationResponseDTO.HarborReferenceDTO harborReferenceDTO5 = null;
            ConfigurationResponseDTO.HarborReferenceDTO harborReferenceDTO6 = null;
            String str3 = null;
            String str4 = null;
            boolean z13 = false;
            while (z9) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z9 = false;
                        i6 = 10;
                        i7 = 9;
                    case 0:
                        z10 = beginStructure.decodeBooleanElement(serialDescriptor, 0);
                        i9 |= 1;
                        i6 = 10;
                        i7 = 9;
                        i8 = 6;
                    case 1:
                        i9 |= 2;
                        harborReferenceDTO6 = (ConfigurationResponseDTO.HarborReferenceDTO) beginStructure.decodeSerializableElement(serialDescriptor, 1, ConfigurationResponseDTO$HarborReferenceDTO$$serializer.INSTANCE, harborReferenceDTO6);
                        i6 = 10;
                        i7 = 9;
                        i8 = 6;
                    case 2:
                        harborReferenceDTO5 = (ConfigurationResponseDTO.HarborReferenceDTO) beginStructure.decodeSerializableElement(serialDescriptor, 2, ConfigurationResponseDTO$HarborReferenceDTO$$serializer.INSTANCE, harborReferenceDTO5);
                        i9 |= 4;
                        i6 = 10;
                        i7 = 9;
                    case 3:
                        z11 = beginStructure.decodeBooleanElement(serialDescriptor, 3);
                        i9 |= 8;
                        i6 = 10;
                    case 4:
                        str3 = beginStructure.decodeStringElement(serialDescriptor, 4);
                        i9 |= 16;
                        i6 = 10;
                    case 5:
                        str4 = beginStructure.decodeStringElement(serialDescriptor, 5);
                        i9 |= 32;
                    case 6:
                        duration3 = (Duration) beginStructure.decodeSerializableElement(serialDescriptor, i8, DurationSerializer.INSTANCE, duration3);
                        i9 |= 64;
                    case 7:
                        list3 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 7, kSerializerArr[7], list3);
                        i9 |= 128;
                    case 8:
                        z12 = beginStructure.decodeBooleanElement(serialDescriptor, 8);
                        i9 |= 256;
                    case 9:
                        z13 = beginStructure.decodeBooleanElement(serialDescriptor, i7);
                        i9 |= 512;
                    case 10:
                        sublineDTO2 = (SublineDTO) beginStructure.decodeNullableSerializableElement(serialDescriptor, i6, SublineDTO$$serializer.INSTANCE, sublineDTO2);
                        i9 |= 1024;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            z5 = z10;
            harborReferenceDTO = harborReferenceDTO6;
            list = list3;
            sublineDTO = sublineDTO2;
            duration = duration3;
            harborReferenceDTO2 = harborReferenceDTO5;
            i5 = i9;
            z6 = z13;
            z7 = z11;
            z8 = z12;
            str = str3;
            str2 = str4;
        }
        beginStructure.endStructure(serialDescriptor);
        return new ConfigurationResponseDTO.RouteDirectionDetailsDTO(i5, z5, harborReferenceDTO, harborReferenceDTO2, z7, str, str2, duration, list, z8, z6, sublineDTO, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, ConfigurationResponseDTO.RouteDirectionDetailsDTO value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        ConfigurationResponseDTO.RouteDirectionDetailsDTO.write$Self$api_kombardoProd(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
