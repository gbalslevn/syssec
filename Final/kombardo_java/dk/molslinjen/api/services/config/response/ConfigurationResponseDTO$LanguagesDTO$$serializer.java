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

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"dk/molslinjen/api/services/config/response/ConfigurationResponseDTO.LanguagesDTO.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$LanguagesDTO;", "<init>", "()V", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public /* synthetic */ class ConfigurationResponseDTO$LanguagesDTO$$serializer implements GeneratedSerializer<ConfigurationResponseDTO.LanguagesDTO> {
    public static final ConfigurationResponseDTO$LanguagesDTO$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        ConfigurationResponseDTO$LanguagesDTO$$serializer configurationResponseDTO$LanguagesDTO$$serializer = new ConfigurationResponseDTO$LanguagesDTO$$serializer();
        INSTANCE = configurationResponseDTO$LanguagesDTO$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dk.molslinjen.api.services.config.response.ConfigurationResponseDTO.LanguagesDTO", configurationResponseDTO$LanguagesDTO$$serializer, 3);
        pluginGeneratedSerialDescriptor.addElement("da-DK", false);
        pluginGeneratedSerialDescriptor.addElement("en-GB", false);
        pluginGeneratedSerialDescriptor.addElement("sv-SE", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private ConfigurationResponseDTO$LanguagesDTO$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        ConfigurationResponseDTO$LanguageSpecificConfigurationDTO$$serializer configurationResponseDTO$LanguageSpecificConfigurationDTO$$serializer = ConfigurationResponseDTO$LanguageSpecificConfigurationDTO$$serializer.INSTANCE;
        return new KSerializer[]{configurationResponseDTO$LanguageSpecificConfigurationDTO$$serializer, configurationResponseDTO$LanguageSpecificConfigurationDTO$$serializer, configurationResponseDTO$LanguageSpecificConfigurationDTO$$serializer};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final ConfigurationResponseDTO.LanguagesDTO deserialize(Decoder decoder) {
        int i5;
        ConfigurationResponseDTO.LanguageSpecificConfigurationDTO languageSpecificConfigurationDTO;
        ConfigurationResponseDTO.LanguageSpecificConfigurationDTO languageSpecificConfigurationDTO2;
        ConfigurationResponseDTO.LanguageSpecificConfigurationDTO languageSpecificConfigurationDTO3;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        ConfigurationResponseDTO.LanguageSpecificConfigurationDTO languageSpecificConfigurationDTO4 = null;
        if (beginStructure.decodeSequentially()) {
            ConfigurationResponseDTO$LanguageSpecificConfigurationDTO$$serializer configurationResponseDTO$LanguageSpecificConfigurationDTO$$serializer = ConfigurationResponseDTO$LanguageSpecificConfigurationDTO$$serializer.INSTANCE;
            ConfigurationResponseDTO.LanguageSpecificConfigurationDTO languageSpecificConfigurationDTO5 = (ConfigurationResponseDTO.LanguageSpecificConfigurationDTO) beginStructure.decodeSerializableElement(serialDescriptor, 0, configurationResponseDTO$LanguageSpecificConfigurationDTO$$serializer, null);
            ConfigurationResponseDTO.LanguageSpecificConfigurationDTO languageSpecificConfigurationDTO6 = (ConfigurationResponseDTO.LanguageSpecificConfigurationDTO) beginStructure.decodeSerializableElement(serialDescriptor, 1, configurationResponseDTO$LanguageSpecificConfigurationDTO$$serializer, null);
            languageSpecificConfigurationDTO3 = (ConfigurationResponseDTO.LanguageSpecificConfigurationDTO) beginStructure.decodeSerializableElement(serialDescriptor, 2, configurationResponseDTO$LanguageSpecificConfigurationDTO$$serializer, null);
            i5 = 7;
            languageSpecificConfigurationDTO2 = languageSpecificConfigurationDTO6;
            languageSpecificConfigurationDTO = languageSpecificConfigurationDTO5;
        } else {
            boolean z5 = true;
            int i6 = 0;
            ConfigurationResponseDTO.LanguageSpecificConfigurationDTO languageSpecificConfigurationDTO7 = null;
            ConfigurationResponseDTO.LanguageSpecificConfigurationDTO languageSpecificConfigurationDTO8 = null;
            while (z5) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                if (decodeElementIndex == -1) {
                    z5 = false;
                } else if (decodeElementIndex == 0) {
                    languageSpecificConfigurationDTO4 = (ConfigurationResponseDTO.LanguageSpecificConfigurationDTO) beginStructure.decodeSerializableElement(serialDescriptor, 0, ConfigurationResponseDTO$LanguageSpecificConfigurationDTO$$serializer.INSTANCE, languageSpecificConfigurationDTO4);
                    i6 |= 1;
                } else if (decodeElementIndex == 1) {
                    languageSpecificConfigurationDTO7 = (ConfigurationResponseDTO.LanguageSpecificConfigurationDTO) beginStructure.decodeSerializableElement(serialDescriptor, 1, ConfigurationResponseDTO$LanguageSpecificConfigurationDTO$$serializer.INSTANCE, languageSpecificConfigurationDTO7);
                    i6 |= 2;
                } else {
                    if (decodeElementIndex != 2) {
                        throw new UnknownFieldException(decodeElementIndex);
                    }
                    languageSpecificConfigurationDTO8 = (ConfigurationResponseDTO.LanguageSpecificConfigurationDTO) beginStructure.decodeSerializableElement(serialDescriptor, 2, ConfigurationResponseDTO$LanguageSpecificConfigurationDTO$$serializer.INSTANCE, languageSpecificConfigurationDTO8);
                    i6 |= 4;
                }
            }
            i5 = i6;
            languageSpecificConfigurationDTO = languageSpecificConfigurationDTO4;
            languageSpecificConfigurationDTO2 = languageSpecificConfigurationDTO7;
            languageSpecificConfigurationDTO3 = languageSpecificConfigurationDTO8;
        }
        beginStructure.endStructure(serialDescriptor);
        return new ConfigurationResponseDTO.LanguagesDTO(i5, languageSpecificConfigurationDTO, languageSpecificConfigurationDTO2, languageSpecificConfigurationDTO3, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, ConfigurationResponseDTO.LanguagesDTO value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        ConfigurationResponseDTO.LanguagesDTO.write$Self$api_kombardoProd(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
