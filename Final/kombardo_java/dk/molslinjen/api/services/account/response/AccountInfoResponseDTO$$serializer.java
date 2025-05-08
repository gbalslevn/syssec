package dk.molslinjen.api.services.account.response;

import dk.molslinjen.api.helpers.serializers.LocalDateWithTimeSerializer;
import dk.molslinjen.api.services.account.passenger.response.GenderDTO;
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
import org.threeten.bp.LocalDate;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"dk/molslinjen/api/services/account/response/AccountInfoResponseDTO.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Ldk/molslinjen/api/services/account/response/AccountInfoResponseDTO;", "<init>", "()V", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public /* synthetic */ class AccountInfoResponseDTO$$serializer implements GeneratedSerializer<AccountInfoResponseDTO> {
    public static final AccountInfoResponseDTO$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        AccountInfoResponseDTO$$serializer accountInfoResponseDTO$$serializer = new AccountInfoResponseDTO$$serializer();
        INSTANCE = accountInfoResponseDTO$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dk.molslinjen.api.services.account.response.AccountInfoResponseDTO", accountInfoResponseDTO$$serializer, 11);
        pluginGeneratedSerialDescriptor.addElement("userId", false);
        pluginGeneratedSerialDescriptor.addElement("email", false);
        pluginGeneratedSerialDescriptor.addElement("gender", false);
        pluginGeneratedSerialDescriptor.addElement("firstName", false);
        pluginGeneratedSerialDescriptor.addElement("lastName", false);
        pluginGeneratedSerialDescriptor.addElement("birthday", false);
        pluginGeneratedSerialDescriptor.addElement("nationality", false);
        pluginGeneratedSerialDescriptor.addElement("mobileNumberPrefix", false);
        pluginGeneratedSerialDescriptor.addElement("mobileNumber", false);
        pluginGeneratedSerialDescriptor.addElement("postNumber", false);
        pluginGeneratedSerialDescriptor.addElement("companies", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private AccountInfoResponseDTO$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr;
        kSerializerArr = AccountInfoResponseDTO.$childSerializers;
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{stringSerializer, stringSerializer, BuiltinSerializersKt.getNullable(GenderDTO.Serializer.INSTANCE), stringSerializer, stringSerializer, BuiltinSerializersKt.getNullable(LocalDateWithTimeSerializer.INSTANCE), BuiltinSerializersKt.getNullable(stringSerializer), stringSerializer, stringSerializer, BuiltinSerializersKt.getNullable(stringSerializer), kSerializerArr[10]};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x0098. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public final AccountInfoResponseDTO deserialize(Decoder decoder) {
        KSerializer[] kSerializerArr;
        int i5;
        String str;
        List list;
        String str2;
        LocalDate localDate;
        GenderDTO genderDTO;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        char c5;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        kSerializerArr = AccountInfoResponseDTO.$childSerializers;
        int i6 = 9;
        int i7 = 7;
        String str9 = null;
        if (beginStructure.decodeSequentially()) {
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 0);
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 1);
            GenderDTO genderDTO2 = (GenderDTO) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, GenderDTO.Serializer.INSTANCE, null);
            String decodeStringElement3 = beginStructure.decodeStringElement(serialDescriptor, 3);
            String decodeStringElement4 = beginStructure.decodeStringElement(serialDescriptor, 4);
            LocalDate localDate2 = (LocalDate) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, LocalDateWithTimeSerializer.INSTANCE, null);
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            String str10 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, stringSerializer, null);
            String decodeStringElement5 = beginStructure.decodeStringElement(serialDescriptor, 7);
            String decodeStringElement6 = beginStructure.decodeStringElement(serialDescriptor, 8);
            String str11 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, stringSerializer, null);
            list = (List) beginStructure.decodeSerializableElement(serialDescriptor, 10, kSerializerArr[10], null);
            str3 = decodeStringElement;
            str = str11;
            str7 = decodeStringElement5;
            str2 = str10;
            localDate = localDate2;
            str5 = decodeStringElement3;
            str8 = decodeStringElement6;
            str6 = decodeStringElement4;
            genderDTO = genderDTO2;
            i5 = 2047;
            str4 = decodeStringElement2;
        } else {
            boolean z5 = true;
            int i8 = 0;
            String str12 = null;
            List list2 = null;
            String str13 = null;
            LocalDate localDate3 = null;
            GenderDTO genderDTO3 = null;
            String str14 = null;
            String str15 = null;
            String str16 = null;
            String str17 = null;
            String str18 = null;
            while (z5) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z5 = false;
                        i6 = 9;
                    case 0:
                        i8 |= 1;
                        str9 = beginStructure.decodeStringElement(serialDescriptor, 0);
                        i6 = 9;
                        i7 = 7;
                    case 1:
                        str14 = beginStructure.decodeStringElement(serialDescriptor, 1);
                        i8 |= 2;
                        i6 = 9;
                        i7 = 7;
                    case 2:
                        genderDTO3 = (GenderDTO) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, GenderDTO.Serializer.INSTANCE, genderDTO3);
                        i8 |= 4;
                        i6 = 9;
                        i7 = 7;
                    case 3:
                        str15 = beginStructure.decodeStringElement(serialDescriptor, 3);
                        i8 |= 8;
                        i6 = 9;
                    case 4:
                        c5 = 5;
                        str16 = beginStructure.decodeStringElement(serialDescriptor, 4);
                        i8 |= 16;
                        i6 = 9;
                    case 5:
                        c5 = 5;
                        localDate3 = (LocalDate) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, LocalDateWithTimeSerializer.INSTANCE, localDate3);
                        i8 |= 32;
                        i6 = 9;
                    case 6:
                        str13 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, str13);
                        i8 |= 64;
                    case 7:
                        str17 = beginStructure.decodeStringElement(serialDescriptor, i7);
                        i8 |= 128;
                    case 8:
                        str18 = beginStructure.decodeStringElement(serialDescriptor, 8);
                        i8 |= 256;
                    case 9:
                        str12 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, i6, StringSerializer.INSTANCE, str12);
                        i8 |= 512;
                    case 10:
                        list2 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 10, kSerializerArr[10], list2);
                        i8 |= 1024;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            i5 = i8;
            str = str12;
            list = list2;
            str2 = str13;
            localDate = localDate3;
            genderDTO = genderDTO3;
            str3 = str9;
            str4 = str14;
            str5 = str15;
            str6 = str16;
            str7 = str17;
            str8 = str18;
        }
        beginStructure.endStructure(serialDescriptor);
        return new AccountInfoResponseDTO(i5, str3, str4, genderDTO, str5, str6, localDate, str2, str7, str8, str, list, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, AccountInfoResponseDTO value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        AccountInfoResponseDTO.write$Self$api_kombardoProd(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
