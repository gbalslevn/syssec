package dk.molslinjen.api.services.config.response;

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
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"dk/molslinjen/api/services/config/response/ConfigurationResponseDTO.LanguageSpecificConfigurationDTO.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$LanguageSpecificConfigurationDTO;", "<init>", "()V", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public /* synthetic */ class ConfigurationResponseDTO$LanguageSpecificConfigurationDTO$$serializer implements GeneratedSerializer<ConfigurationResponseDTO.LanguageSpecificConfigurationDTO> {
    public static final ConfigurationResponseDTO$LanguageSpecificConfigurationDTO$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        ConfigurationResponseDTO$LanguageSpecificConfigurationDTO$$serializer configurationResponseDTO$LanguageSpecificConfigurationDTO$$serializer = new ConfigurationResponseDTO$LanguageSpecificConfigurationDTO$$serializer();
        INSTANCE = configurationResponseDTO$LanguageSpecificConfigurationDTO$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dk.molslinjen.api.services.config.response.ConfigurationResponseDTO.LanguageSpecificConfigurationDTO", configurationResponseDTO$LanguageSpecificConfigurationDTO$$serializer, 12);
        pluginGeneratedSerialDescriptor.addElement("lineName", false);
        pluginGeneratedSerialDescriptor.addElement("lineLogoUrl", true);
        pluginGeneratedSerialDescriptor.addElement("harbors", false);
        pluginGeneratedSerialDescriptor.addElement("regions", true);
        pluginGeneratedSerialDescriptor.addElement("routes", false);
        pluginGeneratedSerialDescriptor.addElement("transportCategories", false);
        pluginGeneratedSerialDescriptor.addElement("extraTransports", false);
        pluginGeneratedSerialDescriptor.addElement("tripCardTypes", false);
        pluginGeneratedSerialDescriptor.addElement("ferries", false);
        pluginGeneratedSerialDescriptor.addElement("ageClassifications", false);
        pluginGeneratedSerialDescriptor.addElement("content", false);
        pluginGeneratedSerialDescriptor.addElement("enabledCurrencies", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private ConfigurationResponseDTO$LanguageSpecificConfigurationDTO$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr;
        kSerializerArr = ConfigurationResponseDTO.LanguageSpecificConfigurationDTO.$childSerializers;
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{stringSerializer, BuiltinSerializersKt.getNullable(stringSerializer), kSerializerArr[2], BuiltinSerializersKt.getNullable(kSerializerArr[3]), kSerializerArr[4], kSerializerArr[5], kSerializerArr[6], kSerializerArr[7], kSerializerArr[8], ConfigurationResponseDTO$AgeClassificationsDTO$$serializer.INSTANCE, ConfigurationResponseDTO$SiteSupportInfoDTO$$serializer.INSTANCE, kSerializerArr[11]};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x00bb. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public final ConfigurationResponseDTO.LanguageSpecificConfigurationDTO deserialize(Decoder decoder) {
        KSerializer[] kSerializerArr;
        String str;
        List list;
        ConfigurationResponseDTO.SiteSupportInfoDTO siteSupportInfoDTO;
        int i5;
        List list2;
        List list3;
        List list4;
        List list5;
        ConfigurationResponseDTO.AgeClassificationsDTO ageClassificationsDTO;
        List list6;
        List list7;
        List list8;
        String str2;
        KSerializer[] kSerializerArr2;
        String str3;
        String str4;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        kSerializerArr = ConfigurationResponseDTO.LanguageSpecificConfigurationDTO.$childSerializers;
        if (beginStructure.decodeSequentially()) {
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 0);
            String str5 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, null);
            List list9 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 2, kSerializerArr[2], null);
            List list10 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, kSerializerArr[3], null);
            List list11 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 4, kSerializerArr[4], null);
            List list12 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 5, kSerializerArr[5], null);
            List list13 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 6, kSerializerArr[6], null);
            List list14 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 7, kSerializerArr[7], null);
            List list15 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 8, kSerializerArr[8], null);
            ConfigurationResponseDTO.AgeClassificationsDTO ageClassificationsDTO2 = (ConfigurationResponseDTO.AgeClassificationsDTO) beginStructure.decodeSerializableElement(serialDescriptor, 9, ConfigurationResponseDTO$AgeClassificationsDTO$$serializer.INSTANCE, null);
            ConfigurationResponseDTO.SiteSupportInfoDTO siteSupportInfoDTO2 = (ConfigurationResponseDTO.SiteSupportInfoDTO) beginStructure.decodeSerializableElement(serialDescriptor, 10, ConfigurationResponseDTO$SiteSupportInfoDTO$$serializer.INSTANCE, null);
            list = (List) beginStructure.decodeSerializableElement(serialDescriptor, 11, kSerializerArr[11], null);
            str2 = decodeStringElement;
            siteSupportInfoDTO = siteSupportInfoDTO2;
            ageClassificationsDTO = ageClassificationsDTO2;
            i5 = 4095;
            list3 = list14;
            list4 = list13;
            list6 = list12;
            list7 = list10;
            list2 = list15;
            list5 = list11;
            list8 = list9;
            str = str5;
        } else {
            List list16 = null;
            ConfigurationResponseDTO.SiteSupportInfoDTO siteSupportInfoDTO3 = null;
            List list17 = null;
            List list18 = null;
            List list19 = null;
            List list20 = null;
            ConfigurationResponseDTO.AgeClassificationsDTO ageClassificationsDTO3 = null;
            List list21 = null;
            List list22 = null;
            String str6 = null;
            boolean z5 = true;
            List list23 = null;
            int i6 = 0;
            String str7 = null;
            while (z5) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        kSerializerArr2 = kSerializerArr;
                        str7 = str7;
                        z5 = false;
                        kSerializerArr = kSerializerArr2;
                    case 0:
                        kSerializerArr2 = kSerializerArr;
                        str3 = str7;
                        str6 = beginStructure.decodeStringElement(serialDescriptor, 0);
                        i6 |= 1;
                        str7 = str3;
                        kSerializerArr = kSerializerArr2;
                    case 1:
                        kSerializerArr2 = kSerializerArr;
                        str3 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str7);
                        i6 |= 2;
                        str7 = str3;
                        kSerializerArr = kSerializerArr2;
                    case 2:
                        str4 = str7;
                        list23 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 2, kSerializerArr[2], list23);
                        i6 |= 4;
                        str7 = str4;
                    case 3:
                        str4 = str7;
                        list22 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, kSerializerArr[3], list22);
                        i6 |= 8;
                        str7 = str4;
                    case 4:
                        str4 = str7;
                        list20 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 4, kSerializerArr[4], list20);
                        i6 |= 16;
                        str7 = str4;
                    case 5:
                        str4 = str7;
                        list21 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 5, kSerializerArr[5], list21);
                        i6 |= 32;
                        str7 = str4;
                    case 6:
                        str4 = str7;
                        list19 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 6, kSerializerArr[6], list19);
                        i6 |= 64;
                        str7 = str4;
                    case 7:
                        str4 = str7;
                        list18 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 7, kSerializerArr[7], list18);
                        i6 |= 128;
                        str7 = str4;
                    case 8:
                        str4 = str7;
                        list17 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 8, kSerializerArr[8], list17);
                        i6 |= 256;
                        str7 = str4;
                    case 9:
                        str4 = str7;
                        ageClassificationsDTO3 = (ConfigurationResponseDTO.AgeClassificationsDTO) beginStructure.decodeSerializableElement(serialDescriptor, 9, ConfigurationResponseDTO$AgeClassificationsDTO$$serializer.INSTANCE, ageClassificationsDTO3);
                        i6 |= 512;
                        str7 = str4;
                    case 10:
                        str4 = str7;
                        siteSupportInfoDTO3 = (ConfigurationResponseDTO.SiteSupportInfoDTO) beginStructure.decodeSerializableElement(serialDescriptor, 10, ConfigurationResponseDTO$SiteSupportInfoDTO$$serializer.INSTANCE, siteSupportInfoDTO3);
                        i6 |= 1024;
                        str7 = str4;
                    case 11:
                        list16 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 11, kSerializerArr[11], list16);
                        i6 |= 2048;
                        str7 = str7;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            str = str7;
            list = list16;
            siteSupportInfoDTO = siteSupportInfoDTO3;
            i5 = i6;
            list2 = list17;
            list3 = list18;
            list4 = list19;
            list5 = list20;
            ageClassificationsDTO = ageClassificationsDTO3;
            list6 = list21;
            list7 = list22;
            list8 = list23;
            str2 = str6;
        }
        beginStructure.endStructure(serialDescriptor);
        return new ConfigurationResponseDTO.LanguageSpecificConfigurationDTO(i5, str2, str, list8, list7, list5, list6, list4, list3, list2, ageClassificationsDTO, siteSupportInfoDTO, list, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, ConfigurationResponseDTO.LanguageSpecificConfigurationDTO value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        ConfigurationResponseDTO.LanguageSpecificConfigurationDTO.write$Self$api_kombardoProd(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
