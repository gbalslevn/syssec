package dk.molslinjen.api.services.config.response;

import dk.molslinjen.api.services.config.response.ConfigurationResponseDTO;
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
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"dk/molslinjen/api/services/config/response/ConfigurationResponseDTO.AgeClassificationsDTO.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$AgeClassificationsDTO;", "<init>", "()V", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public /* synthetic */ class ConfigurationResponseDTO$AgeClassificationsDTO$$serializer implements GeneratedSerializer<ConfigurationResponseDTO.AgeClassificationsDTO> {
    public static final ConfigurationResponseDTO$AgeClassificationsDTO$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        ConfigurationResponseDTO$AgeClassificationsDTO$$serializer configurationResponseDTO$AgeClassificationsDTO$$serializer = new ConfigurationResponseDTO$AgeClassificationsDTO$$serializer();
        INSTANCE = configurationResponseDTO$AgeClassificationsDTO$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dk.molslinjen.api.services.config.response.ConfigurationResponseDTO.AgeClassificationsDTO", configurationResponseDTO$AgeClassificationsDTO$$serializer, 3);
        pluginGeneratedSerialDescriptor.addElement("infant", false);
        pluginGeneratedSerialDescriptor.addElement("child", false);
        pluginGeneratedSerialDescriptor.addElement("adult", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private ConfigurationResponseDTO$AgeClassificationsDTO$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        ConfigurationResponseDTO$AgeClassificationDTO$$serializer configurationResponseDTO$AgeClassificationDTO$$serializer = ConfigurationResponseDTO$AgeClassificationDTO$$serializer.INSTANCE;
        return new KSerializer[]{configurationResponseDTO$AgeClassificationDTO$$serializer, configurationResponseDTO$AgeClassificationDTO$$serializer, configurationResponseDTO$AgeClassificationDTO$$serializer};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final ConfigurationResponseDTO.AgeClassificationsDTO deserialize(Decoder decoder) {
        int i5;
        ConfigurationResponseDTO.AgeClassificationDTO ageClassificationDTO;
        ConfigurationResponseDTO.AgeClassificationDTO ageClassificationDTO2;
        ConfigurationResponseDTO.AgeClassificationDTO ageClassificationDTO3;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        ConfigurationResponseDTO.AgeClassificationDTO ageClassificationDTO4 = null;
        if (beginStructure.decodeSequentially()) {
            ConfigurationResponseDTO$AgeClassificationDTO$$serializer configurationResponseDTO$AgeClassificationDTO$$serializer = ConfigurationResponseDTO$AgeClassificationDTO$$serializer.INSTANCE;
            ConfigurationResponseDTO.AgeClassificationDTO ageClassificationDTO5 = (ConfigurationResponseDTO.AgeClassificationDTO) beginStructure.decodeSerializableElement(serialDescriptor, 0, configurationResponseDTO$AgeClassificationDTO$$serializer, null);
            ConfigurationResponseDTO.AgeClassificationDTO ageClassificationDTO6 = (ConfigurationResponseDTO.AgeClassificationDTO) beginStructure.decodeSerializableElement(serialDescriptor, 1, configurationResponseDTO$AgeClassificationDTO$$serializer, null);
            ageClassificationDTO3 = (ConfigurationResponseDTO.AgeClassificationDTO) beginStructure.decodeSerializableElement(serialDescriptor, 2, configurationResponseDTO$AgeClassificationDTO$$serializer, null);
            i5 = 7;
            ageClassificationDTO2 = ageClassificationDTO6;
            ageClassificationDTO = ageClassificationDTO5;
        } else {
            boolean z5 = true;
            int i6 = 0;
            ConfigurationResponseDTO.AgeClassificationDTO ageClassificationDTO7 = null;
            ConfigurationResponseDTO.AgeClassificationDTO ageClassificationDTO8 = null;
            while (z5) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                if (decodeElementIndex == -1) {
                    z5 = false;
                } else if (decodeElementIndex == 0) {
                    ageClassificationDTO4 = (ConfigurationResponseDTO.AgeClassificationDTO) beginStructure.decodeSerializableElement(serialDescriptor, 0, ConfigurationResponseDTO$AgeClassificationDTO$$serializer.INSTANCE, ageClassificationDTO4);
                    i6 |= 1;
                } else if (decodeElementIndex == 1) {
                    ageClassificationDTO7 = (ConfigurationResponseDTO.AgeClassificationDTO) beginStructure.decodeSerializableElement(serialDescriptor, 1, ConfigurationResponseDTO$AgeClassificationDTO$$serializer.INSTANCE, ageClassificationDTO7);
                    i6 |= 2;
                } else {
                    if (decodeElementIndex != 2) {
                        throw new UnknownFieldException(decodeElementIndex);
                    }
                    ageClassificationDTO8 = (ConfigurationResponseDTO.AgeClassificationDTO) beginStructure.decodeSerializableElement(serialDescriptor, 2, ConfigurationResponseDTO$AgeClassificationDTO$$serializer.INSTANCE, ageClassificationDTO8);
                    i6 |= 4;
                }
            }
            i5 = i6;
            ageClassificationDTO = ageClassificationDTO4;
            ageClassificationDTO2 = ageClassificationDTO7;
            ageClassificationDTO3 = ageClassificationDTO8;
        }
        beginStructure.endStructure(serialDescriptor);
        return new ConfigurationResponseDTO.AgeClassificationsDTO(i5, ageClassificationDTO, ageClassificationDTO2, ageClassificationDTO3, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, ConfigurationResponseDTO.AgeClassificationsDTO value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        ConfigurationResponseDTO.AgeClassificationsDTO.write$Self$api_kombardoProd(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
