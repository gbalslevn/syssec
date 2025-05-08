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
import kotlinx.serialization.internal.StringSerializer;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"dk/molslinjen/api/services/config/response/ConfigurationResponseDTO.SiteSupportInfoDTO.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$SiteSupportInfoDTO;", "<init>", "()V", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public /* synthetic */ class ConfigurationResponseDTO$SiteSupportInfoDTO$$serializer implements GeneratedSerializer<ConfigurationResponseDTO.SiteSupportInfoDTO> {
    public static final ConfigurationResponseDTO$SiteSupportInfoDTO$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        ConfigurationResponseDTO$SiteSupportInfoDTO$$serializer configurationResponseDTO$SiteSupportInfoDTO$$serializer = new ConfigurationResponseDTO$SiteSupportInfoDTO$$serializer();
        INSTANCE = configurationResponseDTO$SiteSupportInfoDTO$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dk.molslinjen.api.services.config.response.ConfigurationResponseDTO.SiteSupportInfoDTO", configurationResponseDTO$SiteSupportInfoDTO$$serializer, 7);
        pluginGeneratedSerialDescriptor.addElement("support", false);
        pluginGeneratedSerialDescriptor.addElement("supportPhoneNumber", false);
        pluginGeneratedSerialDescriptor.addElement("openingHours", false);
        pluginGeneratedSerialDescriptor.addElement("lostAndFoundPageUrl", false);
        pluginGeneratedSerialDescriptor.addElement("suggestionsAndComplaintsPageUrl", false);
        pluginGeneratedSerialDescriptor.addElement("privacyPolicyPageUrl", false);
        pluginGeneratedSerialDescriptor.addElement("termsAndConditionsPageUrl", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private ConfigurationResponseDTO$SiteSupportInfoDTO$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer[] kSerializerArr;
        kSerializerArr = ConfigurationResponseDTO.SiteSupportInfoDTO.$childSerializers;
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{ConfigurationResponseDTO$SiteContactInfoDTO$$serializer.INSTANCE, BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(kSerializerArr[2]), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer)};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x0072. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public final ConfigurationResponseDTO.SiteSupportInfoDTO deserialize(Decoder decoder) {
        KSerializer[] kSerializerArr;
        int i5;
        String str;
        String str2;
        ConfigurationResponseDTO.SiteContactInfoDTO siteContactInfoDTO;
        String str3;
        List list;
        String str4;
        String str5;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        kSerializerArr = ConfigurationResponseDTO.SiteSupportInfoDTO.$childSerializers;
        int i6 = 6;
        int i7 = 5;
        ConfigurationResponseDTO.SiteContactInfoDTO siteContactInfoDTO2 = null;
        if (beginStructure.decodeSequentially()) {
            ConfigurationResponseDTO.SiteContactInfoDTO siteContactInfoDTO3 = (ConfigurationResponseDTO.SiteContactInfoDTO) beginStructure.decodeSerializableElement(serialDescriptor, 0, ConfigurationResponseDTO$SiteContactInfoDTO$$serializer.INSTANCE, null);
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            String str6 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, stringSerializer, null);
            List list2 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, kSerializerArr[2], null);
            String str7 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, stringSerializer, null);
            String str8 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, stringSerializer, null);
            String str9 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, stringSerializer, null);
            list = list2;
            siteContactInfoDTO = siteContactInfoDTO3;
            str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, stringSerializer, null);
            str2 = str9;
            str4 = str7;
            str5 = str8;
            i5 = 127;
            str3 = str6;
        } else {
            boolean z5 = true;
            int i8 = 0;
            String str10 = null;
            String str11 = null;
            String str12 = null;
            List list3 = null;
            String str13 = null;
            String str14 = null;
            while (z5) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z5 = false;
                        i7 = 5;
                    case 0:
                        siteContactInfoDTO2 = (ConfigurationResponseDTO.SiteContactInfoDTO) beginStructure.decodeSerializableElement(serialDescriptor, 0, ConfigurationResponseDTO$SiteContactInfoDTO$$serializer.INSTANCE, siteContactInfoDTO2);
                        i8 |= 1;
                        i6 = 6;
                        i7 = 5;
                    case 1:
                        str12 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str12);
                        i8 |= 2;
                        i6 = 6;
                        i7 = 5;
                    case 2:
                        list3 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, kSerializerArr[2], list3);
                        i8 |= 4;
                        i6 = 6;
                    case 3:
                        str13 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str13);
                        i8 |= 8;
                    case 4:
                        str14 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, str14);
                        i8 |= 16;
                    case 5:
                        str11 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, i7, StringSerializer.INSTANCE, str11);
                        i8 |= 32;
                    case 6:
                        str10 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, i6, StringSerializer.INSTANCE, str10);
                        i8 |= 64;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            i5 = i8;
            str = str10;
            str2 = str11;
            siteContactInfoDTO = siteContactInfoDTO2;
            str3 = str12;
            list = list3;
            str4 = str13;
            str5 = str14;
        }
        beginStructure.endStructure(serialDescriptor);
        return new ConfigurationResponseDTO.SiteSupportInfoDTO(i5, siteContactInfoDTO, str3, list, str4, str5, str2, str, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, ConfigurationResponseDTO.SiteSupportInfoDTO value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        ConfigurationResponseDTO.SiteSupportInfoDTO.write$Self$api_kombardoProd(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
