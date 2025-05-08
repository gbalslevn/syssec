package dk.molslinjen.api.services.account.response;

import dk.molslinjen.api.helpers.serializers.LocalDateWithTimeSerializer;
import dk.molslinjen.api.services.account.passenger.response.GenderDTO;
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
import org.threeten.bp.LocalDate;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"dk/molslinjen/api/services/account/response/AccountUpdateInfoResponseDTO.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Ldk/molslinjen/api/services/account/response/AccountUpdateInfoResponseDTO;", "<init>", "()V", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public /* synthetic */ class AccountUpdateInfoResponseDTO$$serializer implements GeneratedSerializer<AccountUpdateInfoResponseDTO> {
    public static final AccountUpdateInfoResponseDTO$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        AccountUpdateInfoResponseDTO$$serializer accountUpdateInfoResponseDTO$$serializer = new AccountUpdateInfoResponseDTO$$serializer();
        INSTANCE = accountUpdateInfoResponseDTO$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dk.molslinjen.api.services.account.response.AccountUpdateInfoResponseDTO", accountUpdateInfoResponseDTO$$serializer, 9);
        pluginGeneratedSerialDescriptor.addElement("email", false);
        pluginGeneratedSerialDescriptor.addElement("gender", false);
        pluginGeneratedSerialDescriptor.addElement("firstName", false);
        pluginGeneratedSerialDescriptor.addElement("lastName", false);
        pluginGeneratedSerialDescriptor.addElement("birthday", false);
        pluginGeneratedSerialDescriptor.addElement("nationality", false);
        pluginGeneratedSerialDescriptor.addElement("mobileNumberPrefix", false);
        pluginGeneratedSerialDescriptor.addElement("mobileNumber", false);
        pluginGeneratedSerialDescriptor.addElement("postNumber", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private AccountUpdateInfoResponseDTO$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{stringSerializer, BuiltinSerializersKt.getNullable(GenderDTO.Serializer.INSTANCE), stringSerializer, stringSerializer, BuiltinSerializersKt.getNullable(LocalDateWithTimeSerializer.INSTANCE), BuiltinSerializersKt.getNullable(stringSerializer), stringSerializer, stringSerializer, BuiltinSerializersKt.getNullable(stringSerializer)};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x007b. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public final AccountUpdateInfoResponseDTO deserialize(Decoder decoder) {
        int i5;
        String str;
        String str2;
        LocalDate localDate;
        String str3;
        GenderDTO genderDTO;
        String str4;
        String str5;
        String str6;
        String str7;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        int i6 = 7;
        int i7 = 6;
        String str8 = null;
        if (beginStructure.decodeSequentially()) {
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 0);
            GenderDTO genderDTO2 = (GenderDTO) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, GenderDTO.Serializer.INSTANCE, null);
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 2);
            String decodeStringElement3 = beginStructure.decodeStringElement(serialDescriptor, 3);
            LocalDate localDate2 = (LocalDate) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, LocalDateWithTimeSerializer.INSTANCE, null);
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            String str9 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, stringSerializer, null);
            String decodeStringElement4 = beginStructure.decodeStringElement(serialDescriptor, 6);
            str3 = decodeStringElement;
            str7 = beginStructure.decodeStringElement(serialDescriptor, 7);
            str6 = decodeStringElement4;
            str2 = str9;
            str5 = decodeStringElement3;
            str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, stringSerializer, null);
            localDate = localDate2;
            str4 = decodeStringElement2;
            genderDTO = genderDTO2;
            i5 = 511;
        } else {
            boolean z5 = true;
            int i8 = 0;
            String str10 = null;
            String str11 = null;
            LocalDate localDate3 = null;
            GenderDTO genderDTO3 = null;
            String str12 = null;
            String str13 = null;
            String str14 = null;
            String str15 = null;
            while (z5) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z5 = false;
                        i6 = 7;
                    case 0:
                        str8 = beginStructure.decodeStringElement(serialDescriptor, 0);
                        i8 |= 1;
                        i6 = 7;
                        i7 = 6;
                    case 1:
                        genderDTO3 = (GenderDTO) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, GenderDTO.Serializer.INSTANCE, genderDTO3);
                        i8 |= 2;
                        i6 = 7;
                        i7 = 6;
                    case 2:
                        i8 |= 4;
                        str12 = beginStructure.decodeStringElement(serialDescriptor, 2);
                    case 3:
                        str13 = beginStructure.decodeStringElement(serialDescriptor, 3);
                        i8 |= 8;
                    case 4:
                        localDate3 = (LocalDate) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, LocalDateWithTimeSerializer.INSTANCE, localDate3);
                        i8 |= 16;
                    case 5:
                        str11 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, str11);
                        i8 |= 32;
                    case 6:
                        str14 = beginStructure.decodeStringElement(serialDescriptor, i7);
                        i8 |= 64;
                    case 7:
                        str15 = beginStructure.decodeStringElement(serialDescriptor, i6);
                        i8 |= 128;
                    case 8:
                        str10 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, StringSerializer.INSTANCE, str10);
                        i8 |= 256;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            i5 = i8;
            str = str10;
            str2 = str11;
            localDate = localDate3;
            str3 = str8;
            genderDTO = genderDTO3;
            str4 = str12;
            str5 = str13;
            str6 = str14;
            str7 = str15;
        }
        beginStructure.endStructure(serialDescriptor);
        return new AccountUpdateInfoResponseDTO(i5, str3, genderDTO, str4, str5, localDate, str2, str6, str7, str, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, AccountUpdateInfoResponseDTO value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        AccountUpdateInfoResponseDTO.write$Self$api_kombardoProd(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
